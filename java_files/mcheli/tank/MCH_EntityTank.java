/*      */ package mcheli.tank;
/*      */ 
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import mcheli.MCH_Config;
/*      */ import mcheli.MCH_Lib;
/*      */ import mcheli.MCH_MOD;
/*      */ import mcheli.MCH_Math;
/*      */ import mcheli.aircraft.MCH_AircraftInfo;
/*      */ import mcheli.aircraft.MCH_BoundingBox;
/*      */ import mcheli.aircraft.MCH_EntityAircraft;
/*      */ import mcheli.aircraft.MCH_EntityHitBox;
/*      */ import mcheli.aircraft.MCH_EntitySeat;
/*      */ import mcheli.aircraft.MCH_PacketStatusRequest;
/*      */ import mcheli.aircraft.MCH_Parts;
/*      */ import mcheli.particles.MCH_ParticleParam;
/*      */ import mcheli.particles.MCH_ParticlesUtil;
/*      */ import mcheli.weapon.MCH_WeaponSet;
/*      */ import mcheli.wrapper.W_Block;
/*      */ import mcheli.wrapper.W_Entity;
/*      */ import mcheli.wrapper.W_Lib;
/*      */ import mcheli.wrapper.W_WorldFunc;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.block.material.Material;
/*      */ import net.minecraft.command.IEntitySelector;
/*      */ import net.minecraft.crash.CrashReport;
/*      */ import net.minecraft.crash.CrashReportCategory;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ public class MCH_EntityTank
/*      */   extends MCH_EntityAircraft {
/*   44 */   private MCH_TankInfo tankInfo = null;
/*      */   public float soundVolume; public float soundVolumeTarget; public float rotationRotor; public float prevRotationRotor; public float addkeyRotValue; public final MCH_WheelManager WheelMng; public int destroyedAt; double theta; double phi; float turretMotY; public String getKindName() {
/*      */     return "tanks";
/*      */   }
/*      */   public String getEntityType() {
/*      */     return "Vehicle";
/*      */   }
/*      */   public MCH_TankInfo getTankInfo() {
/*      */     return this.tankInfo;
/*      */   }
/*   54 */   public MCH_EntityTank(World world) { super(world);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*  152 */     this.destroyedAt = -1;
/*  153 */     this.theta = -999.0D;
/*  154 */     this.phi = -999.0D;
/*  155 */     this.turretMotY = 0.0F; this.currentSpeed = 0.07D; this.field_70156_m = true; func_70105_a(2.0F, 0.7F); this.field_70129_M = this.field_70131_O / 2.0F; this.field_70159_w = 0.0D; this.field_70181_x = 0.0D; this.field_70179_y = 0.0D; this.weapons = createWeapon(0); this.soundVolume = 0.0F; this.field_70138_W = 0.6F; this.rotationRotor = 0.0F; this.prevRotationRotor = 0.0F; this.WheelMng = new MCH_WheelManager(this); }
/*      */   public void changeType(String type) { if (!type.isEmpty()) this.tankInfo = MCH_TankInfoManager.get(type);  if (this.tankInfo == null) { MCH_Lib.Log((Entity)this, "##### MCH_EntityTank changeTankType() Tank info null %d, %s, %s", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)this)), type, getEntityName() }); func_70106_y(); } else { setAcInfo(this.tankInfo); newSeats(getAcInfo().getNumSeatAndRack()); switchFreeLookModeClient((getAcInfo()).defaultFreelook); this.weapons = createWeapon(1 + getSeatNum()); initPartRotation(getRotYaw(), getRotPitch()); this.WheelMng.createWheels(this.field_70170_p, (getAcInfo()).wheels, Vec3.func_72443_a(0.0D, -0.35D, (getTankInfo()).weightedCenterZ)); }  }
/*      */   public Item getItem() { return (getTankInfo() != null) ? (Item)(getTankInfo()).item : null; }
/*  158 */   public boolean canMountWithNearEmptyMinecart() { MCH_Config var10000 = MCH_MOD.config; return MCH_Config.MountMinecartTank.prmBool; } public void onUpdateAircraft() { if (this.tankInfo == null)
/*  159 */     { changeType(getTypeName());
/*  160 */       this.field_70169_q = this.field_70165_t;
/*  161 */       this.field_70167_r = this.field_70163_u;
/*  162 */       this.field_70166_s = this.field_70161_v; }
/*      */     else
/*  164 */     { if (!this.isRequestedSyncStatus) {
/*  165 */         this.isRequestedSyncStatus = true;
/*  166 */         if (this.field_70170_p.field_72995_K) {
/*  167 */           MCH_PacketStatusRequest.requestStatus(this);
/*      */         }
/*      */       } 
/*      */       
/*  171 */       if (this.lastRiddenByEntity == null && getRiddenByEntity() != null) {
/*  172 */         initCurrentWeapon(getRiddenByEntity());
/*      */       }
/*      */       
/*  175 */       updateWeapons();
/*  176 */       onUpdate_Seats();
/*  177 */       onUpdate_Control();
/*  178 */       this.prevRotationRotor = this.rotationRotor;
/*  179 */       this.rotationRotor = (float)(this.rotationRotor + getCurrentThrottle() * (getAcInfo()).rotorSpeed);
/*  180 */       if (this.rotationRotor > 360.0F) {
/*  181 */         this.rotationRotor -= 360.0F;
/*  182 */         this.prevRotationRotor -= 360.0F;
/*      */       } 
/*      */       
/*  185 */       if (this.rotationRotor < 0.0F) {
/*  186 */         this.rotationRotor += 360.0F;
/*  187 */         this.prevRotationRotor += 360.0F;
/*      */       } 
/*      */       
/*  190 */       this.field_70169_q = this.field_70165_t;
/*  191 */       this.field_70167_r = this.field_70163_u;
/*  192 */       this.field_70166_s = this.field_70161_v;
/*  193 */       if (isDestroyed() && getCurrentThrottle() > 0.0D) {
/*  194 */         if (MCH_Lib.getBlockIdY((Entity)this, 3, -2) > 0) {
/*  195 */           setCurrentThrottle(getCurrentThrottle() * 0.8D);
/*      */         }
/*      */         
/*  198 */         if (isExploded()) {
/*  199 */           setCurrentThrottle(getCurrentThrottle() * 0.98D);
/*      */         }
/*      */       } 
/*      */       
/*  203 */       if (isDestroyed());
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  228 */       updateCameraViewers();
/*  229 */       if (this.field_70170_p.field_72995_K)
/*  230 */       { onUpdate_Client(); }
/*      */       else
/*  232 */       { onUpdate_Server(); }  }  } protected void func_70088_a() { super.func_70088_a(); }
/*      */   public float getGiveDamageRot() { return 91.0F; }
/*      */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) { super.func_70014_b(par1NBTTagCompound); }
/*      */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) { super.func_70037_a(par1NBTTagCompound); if (this.tankInfo == null) { this.tankInfo = MCH_TankInfoManager.get(getTypeName()); if (this.tankInfo == null) { MCH_Lib.Log((Entity)this, "##### MCH_EntityTank readEntityFromNBT() Tank info null %d, %s", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)this)), getEntityName() }); func_70106_y(); } else { setAcInfo(this.tankInfo); }  }
/*      */      }
/*      */   public void func_70106_y() { super.func_70106_y(); }
/*      */   public void onInteractFirst(EntityPlayer player) { this.addkeyRotValue = 0.0F; player.field_70759_as = player.field_70758_at = getLastRiderYaw(); player.field_70126_B = player.field_70177_z = getLastRiderYaw(); player.field_70125_A = getLastRiderPitch(); }
/*      */   public boolean canSwitchGunnerMode() { return !super.canSwitchGunnerMode() ? false : false; }
/*  240 */   @SideOnly(Side.CLIENT) public boolean func_90999_ad() { return (isDestroyed() || super.func_90999_ad()); }
/*      */ 
/*      */   
/*      */   public void updateExtraBoundingBox() {
/*  244 */     if (this.field_70170_p.field_72995_K) {
/*  245 */       super.updateExtraBoundingBox();
/*  246 */     } else if (getCountOnUpdate() <= 1) {
/*  247 */       super.updateExtraBoundingBox();
/*  248 */       super.updateExtraBoundingBox();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public double calculateXOffset(List<AxisAlignedBB> list, AxisAlignedBB bb, double parX) {
/*  254 */     for (int i = 0; i < list.size(); i++) {
/*  255 */       parX = ((AxisAlignedBB)list.get(i)).func_72316_a(bb, parX);
/*      */     }
/*      */     
/*  258 */     bb.func_72317_d(parX, 0.0D, 0.0D);
/*  259 */     return parX;
/*      */   }
/*      */   
/*      */   public double calculateYOffset(List<AxisAlignedBB> list, AxisAlignedBB bb, double parY) {
/*  263 */     for (int i = 0; i < list.size(); i++) {
/*  264 */       parY = ((AxisAlignedBB)list.get(i)).func_72323_b(bb, parY);
/*      */     }
/*      */     
/*  267 */     bb.func_72317_d(0.0D, parY, 0.0D);
/*  268 */     return parY;
/*      */   }
/*      */   
/*      */   public double calculateZOffset(List<AxisAlignedBB> list, AxisAlignedBB bb, double parZ) {
/*  272 */     for (int i = 0; i < list.size(); i++) {
/*  273 */       parZ = ((AxisAlignedBB)list.get(i)).func_72322_c(bb, parZ);
/*      */     }
/*      */     
/*  276 */     bb.func_72317_d(0.0D, 0.0D, parZ);
/*  277 */     return parZ;
/*      */   }
/*      */   
/*      */   public void func_70091_d(double parX, double parY, double parZ) {
/*  281 */     this.field_70170_p.field_72984_F.func_76320_a("move");
/*  282 */     this.field_70139_V *= 0.4F;
/*  283 */     double nowPosX = this.field_70165_t;
/*  284 */     double nowPosY = this.field_70163_u;
/*  285 */     double nowPosZ = this.field_70161_v;
/*  286 */     double mx = parX;
/*  287 */     double my = parY;
/*  288 */     double mz = parZ;
/*  289 */     AxisAlignedBB backUpAxisalignedBB = this.field_70121_D.func_72329_c();
/*  290 */     List list = getCollidingBoundingBoxes((Entity)this, this.field_70121_D.func_72321_a(parX, parY, parZ));
/*  291 */     parY = calculateYOffset(list, this.field_70121_D, parY);
/*  292 */     boolean flag1 = (this.field_70122_E || (my != parY && my < 0.0D));
/*  293 */     MCH_BoundingBox[] prevPX = this.extraBoundingBox;
/*  294 */     int len$ = prevPX.length;
/*      */     
/*  296 */     for (int prevPZ = 0; prevPZ < len$; prevPZ++) {
/*  297 */       MCH_BoundingBox ebb = prevPX[prevPZ];
/*  298 */       ebb.updatePosition(this.field_70165_t, this.field_70163_u, this.field_70161_v, getRotYaw(), getRotPitch(), getRotRoll());
/*      */     } 
/*      */     
/*  301 */     parX = calculateXOffset(list, this.field_70121_D, parX);
/*  302 */     parZ = calculateZOffset(list, this.field_70121_D, parZ);
/*      */ 
/*      */ 
/*      */     
/*  306 */     if (this.field_70138_W > 0.0F && flag1 && this.field_70139_V < 0.05F && (mx != parX || mz != parZ)) {
/*  307 */       double d2 = parX;
/*  308 */       double d3 = parY;
/*  309 */       double d1 = parZ;
/*  310 */       parY = this.field_70138_W;
/*  311 */       AxisAlignedBB minZ = this.field_70121_D.func_72329_c();
/*  312 */       this.field_70121_D.func_72328_c(backUpAxisalignedBB);
/*  313 */       list = getCollidingBoundingBoxes((Entity)this, this.field_70121_D.func_72321_a(mx, parY, mz));
/*  314 */       calculateYOffset(list, this.field_70121_D, parY);
/*  315 */       parX = calculateXOffset(list, this.field_70121_D, mx);
/*  316 */       parZ = calculateZOffset(list, this.field_70121_D, mz);
/*  317 */       parY = calculateYOffset(list, this.field_70121_D, -this.field_70138_W);
/*  318 */       if (d2 * d2 + d1 * d1 >= parX * parX + parZ * parZ) {
/*  319 */         parX = d2;
/*  320 */         parY = d3;
/*  321 */         parZ = d1;
/*  322 */         this.field_70121_D.func_72328_c(minZ);
/*      */       } 
/*      */     } 
/*      */     
/*  326 */     double var38 = this.field_70165_t;
/*  327 */     double var39 = this.field_70161_v;
/*  328 */     this.field_70170_p.field_72984_F.func_76319_b();
/*  329 */     this.field_70170_p.field_72984_F.func_76320_a("rest");
/*  330 */     double minX = this.field_70121_D.field_72340_a;
/*  331 */     double var40 = this.field_70121_D.field_72339_c;
/*  332 */     double maxX = this.field_70121_D.field_72336_d;
/*  333 */     double maxZ = this.field_70121_D.field_72334_f;
/*  334 */     this.field_70165_t = (minX + maxX) / 2.0D;
/*  335 */     this.field_70163_u = this.field_70121_D.field_72338_b + this.field_70129_M - this.field_70139_V;
/*  336 */     this.field_70161_v = (var40 + maxZ) / 2.0D;
/*  337 */     this.field_70123_F = (mx != parX || mz != parZ);
/*  338 */     this.field_70124_G = (my != parY);
/*  339 */     this.field_70122_E = (my != parY && my < 0.0D);
/*  340 */     this.field_70132_H = (this.field_70123_F || this.field_70124_G);
/*  341 */     func_70064_a(parY, this.field_70122_E);
/*  342 */     if (mx != parX) {
/*  343 */       this.field_70159_w = 0.0D;
/*      */     }
/*      */     
/*  346 */     if (my != parY) {
/*  347 */       this.field_70181_x = 0.0D;
/*      */     }
/*      */     
/*  350 */     if (mz != parZ) {
/*  351 */       this.field_70179_y = 0.0D;
/*      */     }
/*      */     
/*      */     try {
/*  355 */       doBlockCollisions();
/*  356 */     } catch (Throwable var37) {
/*  357 */       CrashReport crashreport = CrashReport.func_85055_a(var37, "Checking entity tile collision");
/*  358 */       CrashReportCategory crashreportcategory = crashreport.func_85058_a("Entity being checked for collision");
/*  359 */       func_85029_a(crashreportcategory);
/*      */     } 
/*      */     
/*  362 */     this.field_70170_p.field_72984_F.func_76319_b();
/*      */   }
/*      */   
/*      */   private void rotationByKey(float partialTicks) {
/*  366 */     float rot = 0.2F;
/*  367 */     if (this.moveLeft && !this.moveRight) {
/*  368 */       this.addkeyRotValue -= rot * partialTicks;
/*      */     }
/*      */     
/*  371 */     if (this.moveRight && !this.moveLeft) {
/*  372 */       this.addkeyRotValue += rot * partialTicks;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void onUpdateAngles(float partialTicks) {
/*  378 */     if (!isDestroyed()) {
/*  379 */       if (this.isGunnerMode) {
/*  380 */         setRotPitch(getRotPitch() * 0.95F);
/*  381 */         setRotYaw(getRotYaw() + (getAcInfo()).autoPilotRot * 0.2F);
/*  382 */         if (MathHelper.func_76135_e(getRotRoll()) > 20.0F) {
/*  383 */           setRotRoll(getRotRoll() * 0.95F);
/*      */         }
/*      */       } 
/*      */       
/*  387 */       updateRecoil(partialTicks);
/*  388 */       setRotPitch(getRotPitch() + (this.WheelMng.targetPitch - getRotPitch()) * partialTicks);
/*  389 */       setRotRoll(getRotRoll() + (this.WheelMng.targetRoll - getRotRoll()) * partialTicks);
/*  390 */       boolean isFly = (MCH_Lib.getBlockIdY((Entity)this, 3, -3) == 0);
/*  391 */       if (!isFly || ((getAcInfo()).isFloat && getWaterDepth() > 0.0D)) {
/*  392 */         float gmy = 1.0F;
/*  393 */         if (!isFly) {
/*  394 */           gmy = (getAcInfo()).mobilityYawOnGround;
/*  395 */           if (!(getAcInfo()).canRotOnGround) {
/*  396 */             Block pivotTurnThrottle = MCH_Lib.getBlockY((Entity)this, 3, -2, false);
/*  397 */             if (!W_Block.isEqual(pivotTurnThrottle, W_Block.getWater()) && !W_Block.isEqual(pivotTurnThrottle, Blocks.field_150350_a)) {
/*  398 */               gmy = 0.0F;
/*      */             }
/*      */           } 
/*      */         } 
/*      */         
/*  403 */         float pivotTurnThrottle1 = (getAcInfo()).pivotTurnThrottle;
/*  404 */         double dx = this.field_70165_t - this.field_70169_q;
/*  405 */         double dz = this.field_70161_v - this.field_70166_s;
/*  406 */         double dist = dx * dx + dz * dz;
/*  407 */         if (pivotTurnThrottle1 <= 0.0F || getCurrentThrottle() >= pivotTurnThrottle1 || this.throttleBack >= pivotTurnThrottle1 / 10.0F || dist > this.throttleBack * 0.01D) {
/*  408 */           float sf = (float)Math.sqrt((dist <= 1.0D) ? dist : 1.0D);
/*  409 */           if (pivotTurnThrottle1 <= 0.0F) {
/*  410 */             sf = 1.0F;
/*      */           }
/*      */           
/*  413 */           float flag = (!this.throttleUp && this.throttleDown && getCurrentThrottle() < pivotTurnThrottle1 + 0.05D) ? -1.0F : 1.0F;
/*  414 */           if (this.moveLeft && !this.moveRight) {
/*  415 */             setRotYaw(getRotYaw() - 0.6F * gmy * partialTicks * flag * sf);
/*      */           }
/*      */           
/*  418 */           if (this.moveRight && !this.moveLeft) {
/*  419 */             setRotYaw(getRotYaw() + 0.6F * gmy * partialTicks * flag * sf);
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  424 */       this.addkeyRotValue = (float)(this.addkeyRotValue * (1.0D - (0.1F * partialTicks)));
/*      */     } 
/*      */   }
/*      */   
/*      */   protected void onUpdate_Control() {
/*  429 */     if (this.isGunnerMode && !canUseFuel()) {
/*  430 */       switchGunnerMode(false);
/*      */     }
/*      */     
/*  433 */     this.throttleBack = (float)(this.throttleBack * 0.8D);
/*  434 */     if (getBrake()) {
/*  435 */       this.throttleBack = (float)(this.throttleBack * 0.5D);
/*  436 */       if (getCurrentThrottle() > 0.0D) {
/*  437 */         addCurrentThrottle(-0.02D * (getAcInfo()).throttleUpDown);
/*      */       } else {
/*  439 */         setCurrentThrottle(0.0D);
/*      */       } 
/*      */     } 
/*      */     
/*  443 */     if (getRiddenByEntity() != null && !(getRiddenByEntity()).field_70128_L && isCanopyClose() && canUseFuel() && !isDestroyed()) {
/*  444 */       onUpdate_ControlSub();
/*  445 */     } else if (isTargetDrone() && canUseFuel() && !isDestroyed()) {
/*  446 */       this.throttleUp = true;
/*  447 */       onUpdate_ControlSub();
/*  448 */     } else if (getCurrentThrottle() > 0.0D) {
/*  449 */       addCurrentThrottle(-0.0025D * (getAcInfo()).throttleUpDown);
/*      */     } else {
/*  451 */       setCurrentThrottle(0.0D);
/*      */     } 
/*      */     
/*  454 */     if (getCurrentThrottle() < 0.0D) {
/*  455 */       setCurrentThrottle(0.0D);
/*      */     }
/*      */     
/*  458 */     if (this.field_70170_p.field_72995_K) {
/*  459 */       if (!W_Lib.isClientPlayer(getRiddenByEntity()) || getCountOnUpdate() % 200 == 0) {
/*  460 */         double ct = getThrottle();
/*  461 */         if (getCurrentThrottle() > ct) {
/*  462 */           addCurrentThrottle(-0.005D);
/*      */         }
/*      */         
/*  465 */         if (getCurrentThrottle() < ct) {
/*  466 */           addCurrentThrottle(0.005D);
/*      */         }
/*      */       } 
/*      */     } else {
/*  470 */       setThrottle(getCurrentThrottle());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void onUpdate_ControlSub() {
/*  476 */     if (!this.isGunnerMode) {
/*  477 */       float throttleUpDown = (getAcInfo()).throttleUpDown;
/*  478 */       if (this.throttleUp) {
/*  479 */         float f = throttleUpDown;
/*  480 */         if (getRidingEntity() != null) {
/*  481 */           double mx = (getRidingEntity()).field_70159_w;
/*  482 */           double mz = (getRidingEntity()).field_70179_y;
/*  483 */           f = throttleUpDown * MathHelper.func_76133_a(mx * mx + mz * mz) * (getAcInfo()).throttleUpDownOnEntity;
/*      */         } 
/*      */         
/*  486 */         if ((getAcInfo()).enableBack && this.throttleBack > 0.0F) {
/*  487 */           this.throttleBack = (float)(this.throttleBack - 0.01D * f);
/*      */         } else {
/*  489 */           this.throttleBack = 0.0F;
/*  490 */           if (getCurrentThrottle() < 1.0D) {
/*  491 */             addCurrentThrottle(0.01D * f);
/*      */           } else {
/*  493 */             setCurrentThrottle(1.0D);
/*      */           } 
/*      */         } 
/*  496 */       } else if (this.throttleDown) {
/*  497 */         if (getCurrentThrottle() > 0.0D) {
/*  498 */           addCurrentThrottle(-0.01D * throttleUpDown);
/*      */         } else {
/*  500 */           setCurrentThrottle(0.0D);
/*  501 */           if ((getAcInfo()).enableBack) {
/*  502 */             this.throttleBack = (float)(this.throttleBack + 0.0025D * throttleUpDown);
/*  503 */             if (this.throttleBack > 0.6F) {
/*  504 */               this.throttleBack = 0.6F;
/*      */             }
/*      */           } 
/*      */         } 
/*  508 */       } else if (this.cs_tankAutoThrottleDown && getCurrentThrottle() > 0.0D) {
/*  509 */         addCurrentThrottle(-0.005D * throttleUpDown);
/*  510 */         if (getCurrentThrottle() <= 0.0D) {
/*  511 */           setCurrentThrottle(0.0D);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void onUpdate_Particle2() {
/*  519 */     if (this.field_70170_p.field_72995_K && 
/*  520 */       getHP() < getMaxHP() * 0.5D && 
/*  521 */       getTankInfo() != null) {
/*  522 */       int bbNum = (getTankInfo()).extraBoundingBox.size();
/*  523 */       if (bbNum < 0) {
/*  524 */         bbNum = 0;
/*      */       }
/*      */       
/*  527 */       if (this.isFirstDamageSmoke || this.prevDamageSmokePos.length != bbNum + 1) {
/*  528 */         this.prevDamageSmokePos = new Vec3[bbNum + 1];
/*      */       }
/*      */       
/*  531 */       float yaw = getRotYaw();
/*  532 */       float pitch = getRotPitch();
/*  533 */       float roll = getRotRoll();
/*      */ 
/*      */ 
/*      */ 
/*      */       
/*  538 */       for (int b = 0; b < bbNum; b++) {
/*  539 */         if (getHP() >= getMaxHP() * 0.2D && getMaxHP() > 0) {
/*  540 */           int px = (int)((getHP() / getMaxHP() - 0.2D) / 0.3D * 15.0D);
/*  541 */           if (px > 0 && this.field_70146_Z.nextInt(px) > 0) {
/*      */             continue;
/*      */           }
/*      */         } 
/*      */         
/*  546 */         MCH_BoundingBox var15 = (getTankInfo()).extraBoundingBox.get(b);
/*  547 */         Vec3 pos = getTransformedPosition(var15.offsetX, var15.offsetY, var15.offsetZ);
/*  548 */         double py = pos.field_72450_a;
/*  549 */         double pz = pos.field_72448_b;
/*  550 */         double pos1 = pos.field_72449_c;
/*  551 */         onUpdate_Particle2SpawnSmoke(b, py, pz, pos1, 1.0F);
/*      */         continue;
/*      */       } 
/*  554 */       boolean var14 = true;
/*  555 */       if (getHP() >= getMaxHP() * 0.2D && getMaxHP() > 0) {
/*  556 */         int px = (int)((getHP() / getMaxHP() - 0.2D) / 0.3D * 15.0D);
/*  557 */         if (px > 0 && this.field_70146_Z.nextInt(px) > 0) {
/*  558 */           var14 = false;
/*      */         }
/*      */       } 
/*      */       
/*  562 */       if (var14) {
/*  563 */         double var16 = this.field_70165_t;
/*  564 */         double py = this.field_70163_u;
/*  565 */         double pz = this.field_70161_v;
/*  566 */         if (getSeatInfo(0) != null && (getSeatInfo(0)).pos != null) {
/*  567 */           Vec3 var17 = MCH_Lib.RotVec3(0.0D, (getSeatInfo(0)).pos.field_72448_b, -2.0D, -yaw, -pitch, -roll);
/*  568 */           var16 += var17.field_72450_a;
/*  569 */           py += var17.field_72448_b;
/*  570 */           pz += var17.field_72449_c;
/*      */         } 
/*      */         
/*  573 */         onUpdate_Particle2SpawnSmoke(bbNum, var16, py, pz, (bbNum == 0) ? 2.0F : 1.0F);
/*      */       } 
/*      */       
/*  576 */       this.isFirstDamageSmoke = false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate_Particle2SpawnSmoke(int ri, double x, double y, double z, float size) {
/*  583 */     if (this.isFirstDamageSmoke || this.prevDamageSmokePos[ri] == null) {
/*  584 */       this.prevDamageSmokePos[ri] = Vec3.func_72443_a(x, y, z);
/*      */     }
/*      */     
/*  587 */     Vec3 prev = this.prevDamageSmokePos[ri];
/*  588 */     double var10000 = x - prev.field_72450_a;
/*  589 */     var10000 = y - prev.field_72448_b;
/*  590 */     var10000 = z - prev.field_72449_c;
/*  591 */     byte num = 1;
/*      */     
/*  593 */     for (int i = 0; i < num; i++) {
/*  594 */       float c = 0.2F + this.field_70146_Z.nextFloat() * 0.3F;
/*  595 */       MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", x, y, z);
/*  596 */       prm.motionX = size * (this.field_70146_Z.nextDouble() - 0.5D) * 0.3D;
/*  597 */       prm.motionY = size * this.field_70146_Z.nextDouble() * 0.1D;
/*  598 */       prm.motionZ = size * (this.field_70146_Z.nextDouble() - 0.5D) * 0.3D;
/*  599 */       prm.size = size * (this.field_70146_Z.nextInt(5) + 5.0F) * 1.0F;
/*  600 */       prm.setColor(0.7F + this.field_70146_Z.nextFloat() * 0.1F, c, c, c);
/*  601 */       MCH_ParticlesUtil.spawnParticle(prm);
/*      */     } 
/*      */     
/*  604 */     (this.prevDamageSmokePos[ri]).field_72450_a = x;
/*  605 */     (this.prevDamageSmokePos[ri]).field_72448_b = y;
/*  606 */     (this.prevDamageSmokePos[ri]).field_72449_c = z;
/*      */   }
/*      */   
/*      */   public void onUpdate_Particle2SpawnSmode(int ri, double x, double y, double z, float size) {
/*  610 */     if (this.isFirstDamageSmoke) {
/*  611 */       this.prevDamageSmokePos[ri] = Vec3.func_72443_a(x, y, z);
/*      */     }
/*      */     
/*  614 */     Vec3 prev = this.prevDamageSmokePos[ri];
/*  615 */     double dx = x - prev.field_72450_a;
/*  616 */     double dy = y - prev.field_72448_b;
/*  617 */     double dz = z - prev.field_72449_c;
/*  618 */     int num = (int)(MathHelper.func_76133_a(dx * dx + dy * dy + dz * dz) / 0.3D) + 1;
/*      */     
/*  620 */     for (int i = 0; i < num; i++) {
/*  621 */       float c = 0.2F + this.field_70146_Z.nextFloat() * 0.3F;
/*  622 */       MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", x, y, z);
/*  623 */       prm.motionX = size * (this.field_70146_Z.nextDouble() - 0.5D) * 0.3D;
/*  624 */       prm.motionY = size * this.field_70146_Z.nextDouble() * 0.1D;
/*  625 */       prm.motionZ = size * (this.field_70146_Z.nextDouble() - 0.5D) * 0.3D;
/*  626 */       prm.size = size * (this.field_70146_Z.nextInt(5) + 5.0F) * 1.0F;
/*  627 */       prm.setColor(0.7F + this.field_70146_Z.nextFloat() * 0.1F, c, c, c);
/*  628 */       MCH_ParticlesUtil.spawnParticle(prm);
/*      */     } 
/*      */     
/*  631 */     (this.prevDamageSmokePos[ri]).field_72450_a = x;
/*  632 */     (this.prevDamageSmokePos[ri]).field_72448_b = y;
/*  633 */     (this.prevDamageSmokePos[ri]).field_72449_c = z;
/*      */   }
/*      */   
/*      */   public void onUpdate_ParticleLandingGear() {
/*  637 */     this.WheelMng.particleLandingGear();
/*      */   }
/*      */   
/*      */   private void onUpdate_ParticleSplash() {
/*  641 */     if (getAcInfo() != null && 
/*  642 */       this.field_70170_p.field_72995_K) {
/*  643 */       double mx = this.field_70165_t - this.field_70169_q;
/*  644 */       double mz = this.field_70161_v - this.field_70166_s;
/*  645 */       double dist = mx * mx + mz * mz;
/*  646 */       if (dist > 1.0D) {
/*  647 */         dist = 1.0D;
/*      */       }
/*      */       
/*  650 */       Iterator<MCH_AircraftInfo.ParticleSplash> i$ = (getAcInfo()).particleSplashs.iterator();
/*      */       
/*  652 */       while (i$.hasNext()) {
/*  653 */         MCH_AircraftInfo.ParticleSplash p = i$.next();
/*      */         
/*  655 */         for (int i = 0; i < p.num; i++) {
/*  656 */           if (dist > 0.03D + this.field_70146_Z.nextFloat() * 0.1D) {
/*  657 */             setParticleSplash(p.pos, -mx * p.acceleration, p.motionY, -mz * p.acceleration, p.gravity, p.size * (0.5D + dist * 0.5D), p.age);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setParticleSplash(Vec3 pos, double mx, double my, double mz, float gravity, double size, int age) {
/*  667 */     Vec3 v = getTransformedPosition(pos);
/*  668 */     v = v.func_72441_c(this.field_70146_Z.nextDouble() - 0.5D, (this.field_70146_Z.nextDouble() - 0.5D) * 0.5D, this.field_70146_Z.nextDouble() - 0.5D);
/*  669 */     int x = (int)(v.field_72450_a + 0.5D);
/*  670 */     int y = (int)(v.field_72448_b + 0.0D);
/*  671 */     int z = (int)(v.field_72449_c + 0.5D);
/*  672 */     if (W_WorldFunc.isBlockWater(this.field_70170_p, x, y, z)) {
/*  673 */       float c = this.field_70146_Z.nextFloat() * 0.3F + 0.7F;
/*  674 */       MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", v.field_72450_a, v.field_72448_b, v.field_72449_c);
/*  675 */       prm.motionX = mx + (this.field_70146_Z.nextFloat() - 0.5D) * 0.7D;
/*  676 */       prm.motionY = my;
/*  677 */       prm.motionZ = mz + (this.field_70146_Z.nextFloat() - 0.5D) * 0.7D;
/*  678 */       prm.size = (float)size * (this.field_70146_Z.nextFloat() * 0.2F + 0.8F);
/*  679 */       prm.setColor(0.9F, c, c, c);
/*  680 */       prm.age = age + (int)(this.field_70146_Z.nextFloat() * 0.5D * age);
/*  681 */       prm.gravity = gravity;
/*  682 */       MCH_ParticlesUtil.spawnParticle(prm);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void destroyAircraft() {
/*  688 */     super.destroyAircraft();
/*  689 */     this.rotDestroyedPitch = 0.0F;
/*  690 */     this.rotDestroyedRoll = 0.0F;
/*  691 */     this.rotDestroyedYaw = 0.0F;
/*      */   }
/*      */   
/*      */   public int getClientPositionDelayCorrection() {
/*  695 */     return (getTankInfo() == null) ? 7 : (((getTankInfo()).weightType == 1) ? 2 : 7);
/*      */   }
/*      */   
/*      */   protected void onUpdate_Client() {
/*  699 */     if (getRiddenByEntity() != null && W_Lib.isClientPlayer(getRiddenByEntity())) {
/*  700 */       (getRiddenByEntity()).field_70125_A = (getRiddenByEntity()).field_70127_C;
/*      */     }
/*      */     
/*  703 */     if (this.aircraftPosRotInc > 0) {
/*  704 */       applyServerPositionAndRotation();
/*      */     } else {
/*  706 */       func_70107_b(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*  707 */       if (!isDestroyed() && (this.field_70122_E || MCH_Lib.getBlockIdY((Entity)this, 1, -2) > 0)) {
/*  708 */         this.field_70159_w *= 0.95D;
/*  709 */         this.field_70179_y *= 0.95D;
/*  710 */         applyOnGroundPitch(0.95F);
/*      */       } 
/*      */       
/*  713 */       if (func_70090_H()) {
/*  714 */         this.field_70159_w *= 0.99D;
/*  715 */         this.field_70179_y *= 0.99D;
/*      */       } 
/*      */     } 
/*      */     
/*  719 */     updateWheels();
/*  720 */     onUpdate_Particle2();
/*  721 */     updateSound();
/*  722 */     if (this.field_70170_p.field_72995_K) {
/*  723 */       onUpdate_ParticleLandingGear();
/*  724 */       onUpdate_ParticleSplash();
/*  725 */       onUpdate_ParticleSandCloud(true);
/*      */     } 
/*      */     
/*  728 */     updateCamera(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*      */   }
/*      */   
/*      */   public void applyOnGroundPitch(float factor) {}
/*      */   
/*      */   private void onUpdate_Server() {
/*  734 */     Entity rdnEnt = getRiddenByEntity();
/*  735 */     double prevMotion = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*  736 */     double dp = 0.0D;
/*  737 */     if (canFloatWater()) {
/*  738 */       dp = getWaterDepth();
/*      */     }
/*      */     
/*  741 */     boolean levelOff = this.isGunnerMode;
/*  742 */     if (dp == 0.0D) {
/*  743 */       if (!levelOff) {
/*  744 */         this.field_70181_x += 0.04D + (!func_70090_H() ? (getAcInfo()).gravity : (getAcInfo()).gravityInWater);
/*  745 */         this.field_70181_x += -0.047D * (1.0D - getCurrentThrottle());
/*      */       } else {
/*  747 */         this.field_70181_x *= 0.8D;
/*      */       } 
/*      */     } else {
/*  750 */       if (MathHelper.func_76135_e(getRotRoll()) < 40.0F);
/*      */ 
/*      */ 
/*      */       
/*  754 */       if (dp < 1.0D) {
/*  755 */         this.field_70181_x -= 1.0E-4D;
/*  756 */         this.field_70181_x += 0.007D * getCurrentThrottle();
/*      */       } else {
/*  758 */         if (this.field_70181_x < 0.0D) {
/*  759 */           this.field_70181_x /= 2.0D;
/*      */         }
/*      */         
/*  762 */         this.field_70181_x += 0.007D;
/*      */       } 
/*      */     } 
/*      */     
/*  766 */     float throttle = (float)(getCurrentThrottle() / 10.0D);
/*  767 */     Vec3 v = MCH_Lib.Rot2Vec3(getRotYaw(), getRotPitch() - 10.0F);
/*  768 */     if (!levelOff) {
/*  769 */       this.field_70181_x += v.field_72448_b * throttle / 8.0D;
/*      */     }
/*      */     
/*  772 */     boolean canMove = true;
/*  773 */     if (!(getAcInfo()).canMoveOnGround) {
/*  774 */       Block motion = MCH_Lib.getBlockY((Entity)this, 3, -2, false);
/*  775 */       if (!W_Block.isEqual(motion, W_Block.getWater()) && !W_Block.isEqual(motion, Blocks.field_150350_a)) {
/*  776 */         canMove = false;
/*      */       }
/*      */     } 
/*      */     
/*  780 */     if (canMove) {
/*  781 */       if ((getAcInfo()).enableBack && this.throttleBack > 0.0F) {
/*  782 */         this.field_70159_w -= v.field_72450_a * this.throttleBack;
/*  783 */         this.field_70179_y -= v.field_72449_c * this.throttleBack;
/*      */       } else {
/*  785 */         this.field_70159_w += v.field_72450_a * throttle;
/*  786 */         this.field_70179_y += v.field_72449_c * throttle;
/*      */       } 
/*      */     }
/*      */     
/*  790 */     double motion1 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*  791 */     float speedLimit = getMaxSpeed();
/*  792 */     if (motion1 > speedLimit) {
/*  793 */       this.field_70159_w *= speedLimit / motion1;
/*  794 */       this.field_70179_y *= speedLimit / motion1;
/*  795 */       motion1 = speedLimit;
/*      */     } 
/*      */     
/*  798 */     if (motion1 > prevMotion && this.currentSpeed < speedLimit) {
/*  799 */       this.currentSpeed += (speedLimit - this.currentSpeed) / 35.0D;
/*  800 */       if (this.currentSpeed > speedLimit) {
/*  801 */         this.currentSpeed = speedLimit;
/*      */       }
/*      */     } else {
/*  804 */       this.currentSpeed -= (this.currentSpeed - 0.07D) / 35.0D;
/*  805 */       if (this.currentSpeed < 0.07D) {
/*  806 */         this.currentSpeed = 0.07D;
/*      */       }
/*      */     } 
/*      */     
/*  810 */     if (this.field_70122_E || MCH_Lib.getBlockIdY((Entity)this, 1, -2) > 0) {
/*  811 */       this.field_70159_w *= (getAcInfo()).motionFactor;
/*  812 */       this.field_70179_y *= (getAcInfo()).motionFactor;
/*  813 */       if (MathHelper.func_76135_e(getRotPitch()) < 40.0F) {
/*  814 */         applyOnGroundPitch(0.8F);
/*      */       }
/*      */     } 
/*      */     
/*  818 */     updateWheels();
/*  819 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*  820 */     this.field_70181_x *= 0.95D;
/*  821 */     this.field_70159_w *= (getAcInfo()).motionFactor;
/*  822 */     this.field_70179_y *= (getAcInfo()).motionFactor;
/*  823 */     func_70101_b(getRotYaw(), getRotPitch());
/*  824 */     onUpdate_updateBlock();
/*  825 */     updateCollisionBox();
/*  826 */     if (getRiddenByEntity() != null && (getRiddenByEntity()).field_70128_L) {
/*  827 */       unmountEntity();
/*  828 */       this.field_70153_n = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void collisionEntity(AxisAlignedBB bb) {
/*  834 */     if (bb != null) {
/*  835 */       double speed = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
/*  836 */       if (speed > 0.05D) {
/*  837 */         Entity rider = getRiddenByEntity();
/*  838 */         float damage = (float)(speed * 15.0D);
/*  839 */         final MCH_EntityAircraft rideAc = (this.field_70154_o instanceof MCH_EntityAircraft) ? (MCH_EntityAircraft)this.field_70154_o : ((this.field_70154_o instanceof MCH_EntitySeat) ? ((MCH_EntitySeat)this.field_70154_o).getParent() : null);
/*  840 */         List<Entity> list = this.field_70170_p.func_94576_a((Entity)this, bb.func_72314_b(0.3D, 0.3D, 0.3D), new IEntitySelector() {
/*      */               public boolean func_82704_a(Entity e) {
/*  842 */                 if (e != rideAc && !(e instanceof net.minecraft.entity.item.EntityItem) && !(e instanceof net.minecraft.entity.item.EntityXPOrb) && !(e instanceof mcheli.weapon.MCH_EntityBaseBullet) && !(e instanceof MCH_EntitySeat)) {
/*      */                   
/*  844 */                   if (e instanceof MCH_EntityTank) {
/*  845 */                     MCH_EntityTank tank = (MCH_EntityTank)e;
/*  846 */                     if (tank.getTankInfo() != null && (tank.getTankInfo()).weightType == 2) {
/*  847 */                       MCH_Config mCH_Config = MCH_MOD.config;
/*  848 */                       return MCH_Config.Collision_EntityTankDamage.prmBool;
/*      */                     } 
/*      */                   } 
/*      */                   
/*  852 */                   MCH_Config var10000 = MCH_MOD.config;
/*  853 */                   return MCH_Config.Collision_EntityDamage.prmBool;
/*      */                 } 
/*  855 */                 return false;
/*      */               }
/*      */             });
/*      */ 
/*      */         
/*  860 */         for (int i = 0; i < list.size(); i++) {
/*  861 */           Entity e = list.get(i);
/*  862 */           if (shouldCollisionDamage(e)) {
/*  863 */             DamageSource ds; double dx = e.field_70165_t - this.field_70165_t;
/*  864 */             double dz = e.field_70161_v - this.field_70161_v;
/*  865 */             double dist = Math.sqrt(dx * dx + dz * dz);
/*  866 */             if (dist > 5.0D) {
/*  867 */               dist = 5.0D;
/*      */             }
/*      */             
/*  870 */             damage = (float)(damage + 5.0D - dist);
/*      */             
/*  872 */             if (rider instanceof EntityLivingBase) {
/*  873 */               ds = DamageSource.func_76358_a((EntityLivingBase)rider);
/*      */             } else {
/*  875 */               ds = DamageSource.field_76377_j;
/*      */             } 
/*      */             
/*  878 */             MCH_Lib.applyEntityHurtResistantTimeConfig(e);
/*  879 */             e.func_70097_a(ds, damage);
/*  880 */             if (e instanceof MCH_EntityAircraft) {
/*  881 */               e.field_70159_w += this.field_70159_w * 0.05D;
/*  882 */               e.field_70179_y += this.field_70179_y * 0.05D;
/*  883 */             } else if (e instanceof net.minecraft.entity.projectile.EntityArrow) {
/*  884 */               e.func_70106_y();
/*      */             } else {
/*  886 */               e.field_70159_w += this.field_70159_w * 1.5D;
/*  887 */               e.field_70179_y += this.field_70179_y * 1.5D;
/*      */             } 
/*      */             
/*  890 */             if ((getTankInfo()).weightType != 2 && (e.field_70130_N >= 1.0F || e.field_70131_O >= 1.5D)) {
/*  891 */               if (e instanceof EntityLivingBase) {
/*  892 */                 ds = DamageSource.func_76358_a((EntityLivingBase)e);
/*      */               } else {
/*  894 */                 ds = DamageSource.field_76377_j;
/*      */               } 
/*      */               
/*  897 */               func_70097_a(ds, damage / 3.0F);
/*      */             } 
/*      */             
/*  900 */             MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityTank.collisionEntity damage=%.1f %s", new Object[] { Float.valueOf(damage), e.toString() });
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private boolean shouldCollisionDamage(Entity e) {
/*  909 */     if (getSeatIdByEntity(e) >= 0)
/*  910 */       return false; 
/*  911 */     if (this.noCollisionEntities.containsKey(e)) {
/*  912 */       return false;
/*      */     }
/*  914 */     if (e instanceof MCH_EntityHitBox && ((MCH_EntityHitBox)e).parent != null) {
/*  915 */       MCH_EntityAircraft ac = ((MCH_EntityHitBox)e).parent;
/*  916 */       if (this.noCollisionEntities.containsKey(ac)) {
/*  917 */         return false;
/*      */       }
/*      */     } 
/*      */     
/*  921 */     return (e.field_70154_o instanceof MCH_EntityAircraft && this.noCollisionEntities.containsKey(e.field_70154_o)) ? false : ((!(e.field_70154_o instanceof MCH_EntitySeat) || ((MCH_EntitySeat)e.field_70154_o).getParent() == null || !this.noCollisionEntities.containsKey(((MCH_EntitySeat)e.field_70154_o).getParent())));
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateCollisionBox() {
/*  926 */     if (getAcInfo() != null) {
/*  927 */       this.WheelMng.updateBlock();
/*  928 */       MCH_BoundingBox[] arr$ = this.extraBoundingBox;
/*  929 */       int len$ = arr$.length;
/*      */ 
/*      */       
/*  932 */       for (int i$ = 0; i$ < len$; i$++) {
/*  933 */         MCH_BoundingBox bb = arr$[i$];
/*  934 */         if (this.field_70146_Z.nextInt(3) == 0) {
/*  935 */           MCH_Config mCH_Config = MCH_MOD.config;
/*  936 */           if (MCH_Config.Collision_DestroyBlock.prmBool) {
/*  937 */             Vec3 v = getTransformedPosition(bb.offsetX, bb.offsetY, bb.offsetZ);
/*  938 */             destoryBlockRange(v, bb.width, bb.height);
/*      */           } 
/*      */           
/*  941 */           collisionEntity(bb.boundingBox);
/*      */         } 
/*      */       } 
/*      */       
/*  945 */       MCH_Config var10000 = MCH_MOD.config;
/*  946 */       if (MCH_Config.Collision_DestroyBlock.prmBool) {
/*  947 */         destoryBlockRange(getTransformedPosition(0.0D, 0.0D, 0.0D), this.field_70130_N * 1.5D, (this.field_70131_O * 2.0F));
/*      */       }
/*      */       
/*  950 */       collisionEntity(func_70046_E());
/*      */     } 
/*      */   }
/*      */   
/*      */   public void destoryBlockRange(Vec3 v, double w, double h) {
/*  955 */     if (getAcInfo() != null) {
/*  956 */       MCH_Config var10000 = MCH_MOD.config;
/*  957 */       List<Block> destroyBlocks = MCH_Config.getBreakableBlockListFromType((getTankInfo()).weightType);
/*  958 */       var10000 = MCH_MOD.config;
/*  959 */       List noDestroyBlocks = MCH_Config.getNoBreakableBlockListFromType((getTankInfo()).weightType);
/*  960 */       var10000 = MCH_MOD.config;
/*  961 */       List<Block> destroyMaterials = MCH_Config.getBreakableMaterialListFromType((getTankInfo()).weightType);
/*  962 */       int ws = (int)(w + 2.0D) / 2;
/*  963 */       int hs = (int)(h + 2.0D) / 2;
/*      */       
/*  965 */       for (int x = -ws; x <= ws; x++) {
/*  966 */         int z = -ws;
/*      */         
/*  968 */         while (z <= ws) {
/*  969 */           int y = -hs;
/*      */ 
/*      */           
/*  972 */           while (y <= hs + 1) {
/*      */             
/*  974 */             int bx = (int)(v.field_72450_a + x - 0.5D);
/*  975 */             int by = (int)(v.field_72448_b + y - 1.0D);
/*  976 */             int bz = (int)(v.field_72449_c + z - 0.5D);
/*  977 */             Block block = (by >= 0 && by < 256) ? this.field_70170_p.func_147439_a(bx, by, bz) : Blocks.field_150350_a;
/*  978 */             Material mat = block.func_149688_o();
/*  979 */             if (!Block.func_149680_a(block, Blocks.field_150350_a)) {
/*  980 */               Iterator<Block> i$ = noDestroyBlocks.iterator();
/*      */ 
/*      */               
/*  983 */               while (i$.hasNext()) {
/*  984 */                 Block m = i$.next();
/*  985 */                 if (Block.func_149680_a(block, m)) {
/*  986 */                   block = null;
/*      */                   
/*      */                   break;
/*      */                 } 
/*      */               } 
/*  991 */               if (block == null) {
/*      */                 break;
/*      */               }
/*      */               
/*  995 */               i$ = destroyBlocks.iterator();
/*      */               
/*  997 */               while (i$.hasNext()) {
/*  998 */                 Block m = i$.next();
/*  999 */                 if (Block.func_149680_a(block, m)) {
/* 1000 */                   destroyBlock(bx, by, bz);
/* 1001 */                   mat = null;
/*      */                   
/*      */                   break;
/*      */                 } 
/*      */               } 
/* 1006 */               if (mat == null) {
/*      */                 break;
/*      */               }
/*      */               
/* 1010 */               i$ = destroyMaterials.iterator();
/*      */               
/* 1012 */               while (i$.hasNext()) {
/* 1013 */                 Material var21 = (Material)i$.next();
/* 1014 */                 if (block.func_149688_o() == var21) {
/* 1015 */                   destroyBlock(bx, by, bz);
/*      */                   
/*      */                   break;
/*      */                 } 
/*      */               } 
/*      */             } 
/* 1021 */             y++;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 1026 */           z++;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void destroyBlock(int bx, int by, int bz) {
/* 1036 */     if (this.field_70146_Z.nextInt(8) == 0) {
/* 1037 */       W_WorldFunc.destroyBlock(this.field_70170_p, bx, by, bz, true);
/*      */     } else {
/* 1039 */       this.field_70170_p.func_147468_f(bx, by, bz);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void updateWheels() {
/* 1045 */     this.WheelMng.move(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*      */   }
/*      */   
/*      */   public float getMaxSpeed() {
/* 1049 */     return (getTankInfo()).speed + 0.0F;
/*      */   }
/*      */   
/*      */   public void setAngles(Entity player, boolean fixRot, float fixYaw, float fixPitch, float deltaX, float deltaY, float x, float y, float partialTicks) {
/* 1053 */     if (partialTicks < 0.03F) {
/* 1054 */       partialTicks = 0.4F;
/*      */     }
/*      */     
/* 1057 */     if (partialTicks > 0.9F) {
/* 1058 */       partialTicks = 0.6F;
/*      */     }
/*      */     
/* 1061 */     this.lowPassPartialTicks.put(partialTicks);
/* 1062 */     partialTicks = this.lowPassPartialTicks.getAvg();
/* 1063 */     float ac_pitch = getRotPitch();
/* 1064 */     float ac_yaw = getRotYaw();
/* 1065 */     float ac_roll = getRotRoll();
/* 1066 */     if (isFreeLookMode()) {
/* 1067 */       y = 0.0F;
/* 1068 */       x = 0.0F;
/*      */     } 
/*      */     
/* 1071 */     float yaw = 0.0F;
/* 1072 */     float pitch = 0.0F;
/* 1073 */     float roll = 0.0F;
/* 1074 */     MCH_Math.FMatrix m_add = MCH_Math.newMatrix();
/* 1075 */     MCH_Math.MatTurnZ(m_add, roll / 180.0F * 3.1415927F);
/* 1076 */     MCH_Math.MatTurnX(m_add, pitch / 180.0F * 3.1415927F);
/* 1077 */     MCH_Math.MatTurnY(m_add, yaw / 180.0F * 3.1415927F);
/* 1078 */     MCH_Math.MatTurnZ(m_add, (float)((getRotRoll() / 180.0F) * Math.PI));
/* 1079 */     MCH_Math.MatTurnX(m_add, (float)((getRotPitch() / 180.0F) * Math.PI));
/* 1080 */     MCH_Math.MatTurnY(m_add, (float)((getRotYaw() / 180.0F) * Math.PI));
/* 1081 */     MCH_Math.FVector3D v = MCH_Math.MatrixToEuler(m_add);
/* 1082 */     v.x = MCH_Lib.RNG(v.x, -90.0F, 90.0F);
/* 1083 */     v.z = MCH_Lib.RNG(v.z, -90.0F, 90.0F);
/* 1084 */     if (v.z > 180.0F) {
/* 1085 */       v.z -= 360.0F;
/*      */     }
/*      */     
/* 1088 */     if (v.z < -180.0F) {
/* 1089 */       v.z += 360.0F;
/*      */     }
/*      */     
/* 1092 */     setRotYaw(v.y);
/* 1093 */     setRotPitch(v.x);
/* 1094 */     setRotRoll(v.z);
/* 1095 */     onUpdateAngles(partialTicks);
/* 1096 */     if ((getAcInfo()).limitRotation) {
/* 1097 */       v.x = MCH_Lib.RNG(getRotPitch(), -90.0F, 90.0F);
/* 1098 */       v.z = MCH_Lib.RNG(getRotRoll(), -90.0F, 90.0F);
/* 1099 */       setRotPitch(v.x);
/* 1100 */       setRotRoll(v.z);
/*      */     } 
/*      */     
/* 1103 */     float RV = 180.0F;
/* 1104 */     if (MathHelper.func_76135_e(getRotPitch()) > 90.0F) {
/* 1105 */       MCH_Lib.DbgLog(true, "MCH_EntityAircraft.setAngles Error:Pitch=%.1f", new Object[] { Float.valueOf(getRotPitch()) });
/* 1106 */       setRotPitch(0.0F);
/*      */     } 
/*      */     
/* 1109 */     if (getRotRoll() > 180.0F) {
/* 1110 */       setRotRoll(getRotRoll() - 360.0F);
/*      */     }
/*      */     
/* 1113 */     if (getRotRoll() < -180.0F) {
/* 1114 */       setRotRoll(getRotRoll() + 360.0F);
/*      */     }
/*      */     
/* 1117 */     this.prevRotationRoll = getRotRoll();
/* 1118 */     this.field_70127_C = getRotPitch();
/* 1119 */     if (getRidingEntity() == null) {
/* 1120 */       this.field_70126_B = getRotYaw();
/*      */     }
/*      */     
/* 1123 */     float deltaLimit = (getAcInfo()).cameraRotationSpeed * partialTicks;
/* 1124 */     MCH_WeaponSet ws = getCurrentWeapon(player);
/* 1125 */     deltaLimit *= (ws != null && ws.getInfo() != null) ? (ws.getInfo()).cameraRotationSpeedPitch : 1.0F;
/* 1126 */     if (deltaX > deltaLimit) {
/* 1127 */       deltaX = deltaLimit;
/*      */     }
/*      */     
/* 1130 */     if (deltaX < -deltaLimit) {
/* 1131 */       deltaX = -deltaLimit;
/*      */     }
/*      */     
/* 1134 */     if (deltaY > deltaLimit) {
/* 1135 */       deltaY = deltaLimit;
/*      */     }
/*      */     
/* 1138 */     if (deltaY < -deltaLimit) {
/* 1139 */       deltaY = -deltaLimit;
/*      */     }
/*      */     
/* 1142 */     if (!isOverridePlayerYaw() && !fixRot) {
/* 1143 */       player.func_70082_c(deltaX, 0.0F);
/*      */     } else {
/* 1145 */       if (getRidingEntity() == null) {
/* 1146 */         player.field_70126_B = getRotYaw() + fixYaw;
/*      */       } else {
/* 1148 */         if (getRotYaw() - player.field_70177_z > 180.0F) {
/* 1149 */           player.field_70126_B += 360.0F;
/*      */         }
/*      */         
/* 1152 */         if (getRotYaw() - player.field_70177_z < -180.0F) {
/* 1153 */           player.field_70126_B -= 360.0F;
/*      */         }
/*      */       } 
/*      */       
/* 1157 */       player.field_70177_z = getRotYaw() + fixYaw;
/*      */     } 
/*      */     
/* 1160 */     if (!isOverridePlayerPitch() && !fixRot) {
/* 1161 */       player.func_70082_c(0.0F, deltaY);
/*      */     } else {
/* 1163 */       player.field_70127_C = getRotPitch() + fixPitch;
/* 1164 */       player.field_70125_A = getRotPitch() + fixPitch;
/*      */     } 
/*      */     
/* 1167 */     float playerYaw = MathHelper.func_76142_g(getRotYaw() - player.field_70177_z);
/* 1168 */     float playerPitch = getRotPitch() * MathHelper.func_76134_b((float)(playerYaw * Math.PI / 180.0D)) + -getRotRoll() * MathHelper.func_76126_a((float)(playerYaw * Math.PI / 180.0D));
/* 1169 */     if (MCH_MOD.proxy.isFirstPerson()) {
/* 1170 */       player.field_70125_A = MCH_Lib.RNG(player.field_70125_A, playerPitch + (getAcInfo()).minRotationPitch, playerPitch + (getAcInfo()).maxRotationPitch);
/* 1171 */       player.field_70125_A = MCH_Lib.RNG(player.field_70125_A, -90.0F, 90.0F);
/*      */     } 
/*      */     
/* 1174 */     player.field_70127_C = player.field_70125_A;
/* 1175 */     if ((getRidingEntity() == null && ac_yaw != getRotYaw()) || ac_pitch != getRotPitch() || ac_roll != getRotRoll()) {
/* 1176 */       this.aircraftRotChanged = true;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public float getSoundVolume() {
/* 1182 */     return (getAcInfo() != null && (getAcInfo()).throttleUpDown <= 0.0F) ? 0.0F : (this.soundVolume * 0.7F);
/*      */   }
/*      */   
/*      */   public void updateSound() {
/* 1186 */     float target = (float)getCurrentThrottle();
/* 1187 */     if (getRiddenByEntity() != null && (this.partCanopy == null || getCanopyRotation() < 1.0F)) {
/* 1188 */       target += 0.1F;
/*      */     }
/*      */     
/* 1191 */     if (!this.moveLeft && !this.moveRight && !this.throttleDown) {
/* 1192 */       this.soundVolumeTarget *= 0.8F;
/*      */     } else {
/* 1194 */       this.soundVolumeTarget += 0.1F;
/* 1195 */       if (this.soundVolumeTarget > 0.75F) {
/* 1196 */         this.soundVolumeTarget = 0.75F;
/*      */       }
/*      */     } 
/*      */     
/* 1200 */     if (target < this.soundVolumeTarget) {
/* 1201 */       target = this.soundVolumeTarget;
/*      */     }
/*      */     
/* 1204 */     if (this.soundVolume < target) {
/* 1205 */       this.soundVolume += 0.02F;
/* 1206 */       if (this.soundVolume >= target) {
/* 1207 */         this.soundVolume = target;
/*      */       }
/* 1209 */     } else if (this.soundVolume > target) {
/* 1210 */       this.soundVolume -= 0.02F;
/* 1211 */       if (this.soundVolume <= target) {
/* 1212 */         this.soundVolume = target;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public float getSoundPitch() {
/* 1219 */     float target1 = (float)(0.5D + getCurrentThrottle() * 0.5D);
/* 1220 */     float target2 = (float)(0.5D + this.soundVolumeTarget * 0.5D);
/* 1221 */     return (target1 > target2) ? target1 : target2;
/*      */   }
/*      */   
/*      */   public String getDefaultSoundName() {
/* 1225 */     return "prop";
/*      */   }
/*      */   
/*      */   public boolean hasBrake() {
/* 1229 */     return true;
/*      */   }
/*      */   
/*      */   public void updateParts(int stat) {
/* 1233 */     super.updateParts(stat);
/* 1234 */     if (!isDestroyed()) {
/* 1235 */       MCH_Parts[] parts = new MCH_Parts[0];
/* 1236 */       MCH_Parts[] arr$ = parts;
/* 1237 */       int len$ = parts.length;
/*      */       
/* 1239 */       for (int i$ = 0; i$ < len$; i$++) {
/* 1240 */         MCH_Parts p = arr$[i$];
/* 1241 */         if (p != null) {
/* 1242 */           p.updateStatusClient(stat);
/* 1243 */           p.update();
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public float getUnfoldLandingGearThrottle() {
/* 1251 */     return 0.7F;
/*      */   }
/*      */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tank\MCH_EntityTank.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */