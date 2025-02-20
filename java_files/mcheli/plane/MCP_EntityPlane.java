/*      */ package mcheli.plane;
/*      */ 
/*      */ import java.util.Iterator;
/*      */ import mcheli.MCH_Config;
/*      */ import mcheli.MCH_Lib;
/*      */ import mcheli.MCH_MOD;
/*      */ import mcheli.aircraft.MCH_AircraftInfo;
/*      */ import mcheli.aircraft.MCH_EntityAircraft;
/*      */ import mcheli.aircraft.MCH_PacketStatusRequest;
/*      */ import mcheli.aircraft.MCH_Parts;
/*      */ import mcheli.particles.MCH_ParticleParam;
/*      */ import mcheli.particles.MCH_ParticlesUtil;
/*      */ import mcheli.wrapper.W_Block;
/*      */ import mcheli.wrapper.W_Entity;
/*      */ import mcheli.wrapper.W_Lib;
/*      */ import mcheli.wrapper.W_WorldFunc;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.World;
/*      */ 
/*      */ public class MCP_EntityPlane
/*      */   extends MCH_EntityAircraft
/*      */ {
/*   30 */   private MCP_PlaneInfo planeInfo = null;
/*      */   
/*      */   public float soundVolume;
/*      */   public MCH_Parts partNozzle;
/*      */   public MCH_Parts partWing;
/*      */   public float rotationRotor;
/*      */   public float prevRotationRotor;
/*      */   public float addkeyRotValue;
/*      */   
/*      */   public MCP_EntityPlane(World world) {
/*   40 */     super(world);
/*   41 */     this.currentSpeed = 0.07D;
/*   42 */     this.field_70156_m = true;
/*   43 */     func_70105_a(2.0F, 0.7F);
/*   44 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*   45 */     this.field_70159_w = 0.0D;
/*   46 */     this.field_70181_x = 0.0D;
/*   47 */     this.field_70179_y = 0.0D;
/*   48 */     this.weapons = createWeapon(0);
/*   49 */     this.soundVolume = 0.0F;
/*   50 */     this.partNozzle = null;
/*   51 */     this.partWing = null;
/*   52 */     this.field_70138_W = 0.6F;
/*   53 */     this.rotationRotor = 0.0F;
/*   54 */     this.prevRotationRotor = 0.0F;
/*      */   }
/*      */   
/*      */   public String getKindName() {
/*   58 */     return "planes";
/*      */   }
/*      */   
/*      */   public String getEntityType() {
/*   62 */     return "Plane";
/*      */   }
/*      */   
/*      */   public MCP_PlaneInfo getPlaneInfo() {
/*   66 */     return this.planeInfo;
/*      */   }
/*      */   
/*      */   public void changeType(String type) {
/*   70 */     if (!type.isEmpty()) {
/*   71 */       this.planeInfo = MCP_PlaneInfoManager.get(type);
/*      */     }
/*      */     
/*   74 */     if (this.planeInfo == null) {
/*   75 */       MCH_Lib.Log((Entity)this, "##### MCP_EntityPlane changePlaneType() Plane info null %d, %s, %s", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)this)), type, getEntityName() });
/*   76 */       func_70106_y();
/*      */     } else {
/*   78 */       setAcInfo(this.planeInfo);
/*   79 */       newSeats(getAcInfo().getNumSeatAndRack());
/*   80 */       this.partNozzle = createNozzle(this.planeInfo);
/*   81 */       this.partWing = createWing(this.planeInfo);
/*   82 */       this.weapons = createWeapon(1 + getSeatNum());
/*   83 */       initPartRotation(getRotYaw(), getRotPitch());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public Item getItem() {
/*   89 */     return (getPlaneInfo() != null) ? (Item)(getPlaneInfo()).item : null;
/*      */   }
/*      */   
/*      */   public boolean canMountWithNearEmptyMinecart() {
/*   93 */     MCH_Config var10000 = MCH_MOD.config;
/*   94 */     return MCH_Config.MountMinecartPlane.prmBool;
/*      */   }
/*      */   
/*      */   protected void func_70088_a() {
/*   98 */     super.func_70088_a();
/*      */   }
/*      */   
/*      */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  102 */     super.func_70014_b(par1NBTTagCompound);
/*      */   }
/*      */   
/*      */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/*  106 */     super.func_70037_a(par1NBTTagCompound);
/*  107 */     if (this.planeInfo == null) {
/*  108 */       this.planeInfo = MCP_PlaneInfoManager.get(getTypeName());
/*  109 */       if (this.planeInfo == null) {
/*  110 */         MCH_Lib.Log((Entity)this, "##### MCP_EntityPlane readEntityFromNBT() Plane info null %d, %s", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)this)), getEntityName() });
/*  111 */         func_70106_y();
/*      */       } else {
/*  113 */         setAcInfo(this.planeInfo);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70106_y() {
/*  120 */     super.func_70106_y();
/*      */   }
/*      */   
/*      */   public int getNumEjectionSeat() {
/*  124 */     if (getAcInfo() != null && (getAcInfo()).isEnableEjectionSeat) {
/*  125 */       int n = getSeatNum() + 1;
/*  126 */       return (n <= 2) ? n : 0;
/*      */     } 
/*  128 */     return 0;
/*      */   }
/*      */ 
/*      */   
/*      */   public void onInteractFirst(EntityPlayer player) {
/*  133 */     this.addkeyRotValue = 0.0F;
/*      */   }
/*      */   
/*      */   public boolean canSwitchGunnerMode() {
/*  137 */     if (!super.canSwitchGunnerMode()) {
/*  138 */       return false;
/*      */     }
/*  140 */     float roll = MathHelper.func_76135_e(MathHelper.func_76142_g(getRotRoll()));
/*  141 */     float pitch = MathHelper.func_76135_e(MathHelper.func_76142_g(getRotPitch()));
/*  142 */     return (roll <= 40.0F && pitch <= 40.0F) ? ((getCurrentThrottle() > 0.6000000238418579D && MCH_Lib.getBlockIdY((Entity)this, 3, -5) == 0)) : false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void onUpdateAircraft() {
/*  147 */     if (this.planeInfo == null) {
/*  148 */       changeType(getTypeName());
/*  149 */       this.field_70169_q = this.field_70165_t;
/*  150 */       this.field_70167_r = this.field_70163_u;
/*  151 */       this.field_70166_s = this.field_70161_v;
/*      */     } else {
/*  153 */       if (!this.isRequestedSyncStatus) {
/*  154 */         this.isRequestedSyncStatus = true;
/*  155 */         if (this.field_70170_p.field_72995_K) {
/*  156 */           MCH_PacketStatusRequest.requestStatus(this);
/*      */         }
/*      */       } 
/*      */       
/*  160 */       if (this.lastRiddenByEntity == null && getRiddenByEntity() != null) {
/*  161 */         initCurrentWeapon(getRiddenByEntity());
/*      */       }
/*      */       
/*  164 */       updateWeapons();
/*  165 */       onUpdate_Seats();
/*  166 */       onUpdate_Control();
/*  167 */       this.prevRotationRotor = this.rotationRotor;
/*  168 */       this.rotationRotor = (float)(this.rotationRotor + getCurrentThrottle() * (getAcInfo()).rotorSpeed);
/*  169 */       if (this.rotationRotor > 360.0F) {
/*  170 */         this.rotationRotor -= 360.0F;
/*  171 */         this.prevRotationRotor -= 360.0F;
/*      */       } 
/*      */       
/*  174 */       if (this.rotationRotor < 0.0F) {
/*  175 */         this.rotationRotor += 360.0F;
/*  176 */         this.prevRotationRotor += 360.0F;
/*      */       } 
/*      */       
/*  179 */       if (this.field_70122_E && getVtolMode() == 0 && this.planeInfo.isDefaultVtol) {
/*  180 */         swithVtolMode(true);
/*      */       }
/*      */       
/*  183 */       this.field_70169_q = this.field_70165_t;
/*  184 */       this.field_70167_r = this.field_70163_u;
/*  185 */       this.field_70166_s = this.field_70161_v;
/*  186 */       if (!isDestroyed() && isHovering() && MathHelper.func_76135_e(getRotPitch()) < 70.0F) {
/*  187 */         setRotPitch(getRotPitch() * 0.95F, "isHovering()");
/*      */       }
/*      */       
/*  190 */       if (isDestroyed() && getCurrentThrottle() > 0.0D) {
/*  191 */         if (MCH_Lib.getBlockIdY((Entity)this, 3, -2) > 0) {
/*  192 */           setCurrentThrottle(getCurrentThrottle() * 0.8D);
/*      */         }
/*      */         
/*  195 */         if (isExploded()) {
/*  196 */           setCurrentThrottle(getCurrentThrottle() * 0.98D);
/*      */         }
/*      */       } 
/*      */       
/*  200 */       updateCameraViewers();
/*  201 */       if (this.field_70170_p.field_72995_K) {
/*  202 */         onUpdate_Client();
/*      */       } else {
/*  204 */         onUpdate_Server();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canUpdateYaw(Entity player) {
/*  211 */     return (super.canUpdateYaw(player) && !isHovering());
/*      */   }
/*      */   
/*      */   public boolean canUpdatePitch(Entity player) {
/*  215 */     return (super.canUpdatePitch(player) && !isHovering());
/*      */   }
/*      */   
/*      */   public boolean canUpdateRoll(Entity player) {
/*  219 */     return (super.canUpdateRoll(player) && !isHovering());
/*      */   }
/*      */   
/*      */   public float getYawFactor() {
/*  223 */     float yaw = (getVtolMode() > 0) ? (getPlaneInfo()).vtolYaw : super.getYawFactor();
/*  224 */     return yaw * 0.8F;
/*      */   }
/*      */   
/*      */   public float getPitchFactor() {
/*  228 */     float pitch = (getVtolMode() > 0) ? (getPlaneInfo()).vtolPitch : super.getPitchFactor();
/*  229 */     return pitch * 0.8F;
/*      */   }
/*      */   
/*      */   public float getRollFactor() {
/*  233 */     float roll = (getVtolMode() > 0) ? (getPlaneInfo()).vtolYaw : super.getRollFactor();
/*  234 */     return roll * 0.8F;
/*      */   }
/*      */   
/*      */   public boolean isOverridePlayerPitch() {
/*  238 */     return (super.isOverridePlayerPitch() && !isHovering());
/*      */   }
/*      */   
/*      */   public boolean isOverridePlayerYaw() {
/*  242 */     return (super.isOverridePlayerYaw() && !isHovering());
/*      */   }
/*      */   
/*      */   public float getControlRotYaw(float mouseX, float mouseY, float tick) {
/*  246 */     MCH_Config var10000 = MCH_MOD.config;
/*  247 */     if (MCH_Config.MouseControlFlightSimMode.prmBool) {
/*  248 */       rotationByKey(tick);
/*  249 */       return this.addkeyRotValue * 20.0F;
/*      */     } 
/*  251 */     return mouseX;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getControlRotPitch(float mouseX, float mouseY, float tick) {
/*  256 */     return mouseY;
/*      */   }
/*      */   
/*      */   public float getControlRotRoll(float mouseX, float mouseY, float tick) {
/*  260 */     MCH_Config var10000 = MCH_MOD.config;
/*  261 */     return MCH_Config.MouseControlFlightSimMode.prmBool ? (mouseX * 2.0F) : ((getVtolMode() == 0) ? (mouseX * 0.5F) : mouseX);
/*      */   }
/*      */   
/*      */   private void rotationByKey(float partialTicks) {
/*  265 */     float rot = 0.2F;
/*  266 */     MCH_Config var10000 = MCH_MOD.config;
/*  267 */     if (!MCH_Config.MouseControlFlightSimMode.prmBool && getVtolMode() != 0) {
/*  268 */       rot *= 0.0F;
/*      */     }
/*      */     
/*  271 */     if (this.moveLeft && !this.moveRight) {
/*  272 */       this.addkeyRotValue -= rot * partialTicks;
/*      */     }
/*      */     
/*  275 */     if (this.moveRight && !this.moveLeft) {
/*  276 */       this.addkeyRotValue += rot * partialTicks;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void onUpdateAngles(float partialTicks) {
/*  282 */     if (!isDestroyed()) {
/*  283 */       if (this.isGunnerMode) {
/*  284 */         setRotPitch(getRotPitch() * 0.95F);
/*  285 */         setRotYaw(getRotYaw() + (getAcInfo()).autoPilotRot * 0.2F);
/*  286 */         if (MathHelper.func_76135_e(getRotRoll()) > 20.0F) {
/*  287 */           setRotRoll(getRotRoll() * 0.95F);
/*      */         }
/*      */       } 
/*      */       
/*  291 */       boolean isFly = (MCH_Lib.getBlockIdY((Entity)this, 3, -3) == 0);
/*      */       
/*  293 */       if (isFly && !isFreeLookMode() && !this.isGunnerMode && (!(getAcInfo()).isFloat || getWaterDepth() <= 0.0D)) {
/*  294 */         if (isFly) {
/*  295 */           MCH_Config var10000 = MCH_MOD.config;
/*  296 */           if (!MCH_Config.MouseControlFlightSimMode.prmBool) {
/*  297 */             rotationByKey(partialTicks);
/*  298 */             setRotRoll(getRotRoll() + this.addkeyRotValue * 0.5F * (getAcInfo()).mobilityRoll);
/*      */           } 
/*      */         } 
/*      */       } else {
/*  302 */         float rot = 1.0F;
/*  303 */         if (!isFly) {
/*  304 */           rot = (getAcInfo()).mobilityYawOnGround;
/*  305 */           if (!(getAcInfo()).canRotOnGround) {
/*  306 */             Block block = MCH_Lib.getBlockY((Entity)this, 3, -2, false);
/*  307 */             if (!W_Block.isEqual(block, W_Block.getWater()) && !W_Block.isEqual(block, Blocks.field_150350_a)) {
/*  308 */               rot = 0.0F;
/*      */             }
/*      */           } 
/*      */         } 
/*      */         
/*  313 */         if (this.moveLeft && !this.moveRight) {
/*  314 */           setRotYaw(getRotYaw() - 0.6F * rot * partialTicks);
/*      */         }
/*      */         
/*  317 */         if (this.moveRight && !this.moveLeft) {
/*  318 */           setRotYaw(getRotYaw() + 0.6F * rot * partialTicks);
/*      */         }
/*      */       } 
/*      */       
/*  322 */       this.addkeyRotValue = (float)(this.addkeyRotValue * (1.0D - (0.1F * partialTicks)));
/*  323 */       if (!isFly && MathHelper.func_76135_e(getRotPitch()) < 40.0F) {
/*  324 */         applyOnGroundPitch(0.97F);
/*      */       }
/*      */       
/*  327 */       if (getNozzleRotation() > 0.001F) {
/*  328 */         float rot = 1.0F - 0.03F * partialTicks;
/*  329 */         setRotPitch(getRotPitch() * rot);
/*  330 */         rot = 1.0F - 0.1F * partialTicks;
/*  331 */         setRotRoll(getRotRoll() * rot);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void onUpdate_Control() {
/*  338 */     if (this.isGunnerMode && !canUseFuel()) {
/*  339 */       switchGunnerMode(false);
/*      */     }
/*      */     
/*  342 */     this.throttleBack = (float)(this.throttleBack * 0.8D);
/*  343 */     if (getRiddenByEntity() != null && !(getRiddenByEntity()).field_70128_L && isCanopyClose() && canUseWing() && canUseFuel() && !isDestroyed()) {
/*  344 */       onUpdate_ControlNotHovering();
/*  345 */     } else if (isTargetDrone() && canUseFuel() && !isDestroyed()) {
/*  346 */       this.throttleUp = true;
/*  347 */       onUpdate_ControlNotHovering();
/*  348 */     } else if (getCurrentThrottle() > 0.0D) {
/*  349 */       addCurrentThrottle(-0.0025D * (getAcInfo()).throttleUpDown);
/*      */     } else {
/*  351 */       setCurrentThrottle(0.0D);
/*      */     } 
/*      */     
/*  354 */     if (getCurrentThrottle() < 0.0D) {
/*  355 */       setCurrentThrottle(0.0D);
/*      */     }
/*      */     
/*  358 */     if (this.field_70170_p.field_72995_K) {
/*  359 */       if (!W_Lib.isClientPlayer(getRiddenByEntity())) {
/*  360 */         double ct = getThrottle();
/*  361 */         if (getCurrentThrottle() > ct) {
/*  362 */           addCurrentThrottle(-0.005D);
/*      */         }
/*      */         
/*  365 */         if (getCurrentThrottle() < ct) {
/*  366 */           addCurrentThrottle(0.005D);
/*      */         }
/*      */       } 
/*      */     } else {
/*  370 */       setThrottle(getCurrentThrottle());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void onUpdate_ControlNotHovering() {
/*  376 */     if (!this.isGunnerMode) {
/*  377 */       float throttleUpDown = (getAcInfo()).throttleUpDown;
/*  378 */       boolean turn = ((this.moveLeft && !this.moveRight) || (!this.moveLeft && this.moveRight));
/*  379 */       float pivotTurnThrottle = (getAcInfo()).pivotTurnThrottle;
/*  380 */       boolean localThrottleUp = this.throttleUp;
/*  381 */       if (turn && getCurrentThrottle() < (getAcInfo()).pivotTurnThrottle && !localThrottleUp && !this.throttleDown) {
/*  382 */         localThrottleUp = true;
/*  383 */         throttleUpDown *= 2.0F;
/*      */       } 
/*      */       
/*  386 */       if (localThrottleUp) {
/*  387 */         float f = throttleUpDown;
/*  388 */         if (getRidingEntity() != null) {
/*  389 */           double mx = (getRidingEntity()).field_70159_w;
/*  390 */           double mz = (getRidingEntity()).field_70179_y;
/*  391 */           f = throttleUpDown * MathHelper.func_76133_a(mx * mx + mz * mz) * (getAcInfo()).throttleUpDownOnEntity;
/*      */         } 
/*      */         
/*  394 */         if ((getAcInfo()).enableBack && this.throttleBack > 0.0F) {
/*  395 */           this.throttleBack = (float)(this.throttleBack - 0.01D * f);
/*      */         } else {
/*  397 */           this.throttleBack = 0.0F;
/*  398 */           if (getCurrentThrottle() < 1.0D) {
/*  399 */             addCurrentThrottle(0.01D * f);
/*      */           } else {
/*  401 */             setCurrentThrottle(1.0D);
/*      */           } 
/*      */         } 
/*  404 */       } else if (this.throttleDown) {
/*  405 */         if (getCurrentThrottle() > 0.0D) {
/*  406 */           addCurrentThrottle(-0.01D * throttleUpDown);
/*      */         } else {
/*  408 */           setCurrentThrottle(0.0D);
/*  409 */           if ((getAcInfo()).enableBack) {
/*  410 */             this.throttleBack = (float)(this.throttleBack + 0.0025D * throttleUpDown);
/*  411 */             if (this.throttleBack > 0.6F) {
/*  412 */               this.throttleBack = 0.6F;
/*      */             }
/*      */           } 
/*      */         } 
/*  416 */       } else if (this.cs_planeAutoThrottleDown && getCurrentThrottle() > 0.0D) {
/*  417 */         addCurrentThrottle(-0.005D * throttleUpDown);
/*  418 */         if (getCurrentThrottle() <= 0.0D) {
/*  419 */           setCurrentThrottle(0.0D);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void onUpdate_Particle() {
/*  427 */     if (this.field_70170_p.field_72995_K) {
/*  428 */       onUpdate_ParticleLandingGear();
/*  429 */       onUpdate_ParticleNozzle();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void onUpdate_Particle2() {
/*  435 */     if (this.field_70170_p.field_72995_K && 
/*  436 */       getHP() < getMaxHP() * 0.5D && 
/*  437 */       getPlaneInfo() != null) {
/*  438 */       int rotorNum = (getPlaneInfo()).rotorList.size();
/*  439 */       if (rotorNum < 0) {
/*  440 */         rotorNum = 0;
/*      */       }
/*      */       
/*  443 */       if (this.isFirstDamageSmoke) {
/*  444 */         this.prevDamageSmokePos = new Vec3[rotorNum + 1];
/*      */       }
/*      */       
/*  447 */       float yaw = getRotYaw();
/*  448 */       float pitch = getRotPitch();
/*  449 */       float roll = getRotRoll();
/*  450 */       boolean spawnSmoke = true;
/*      */       
/*      */       int px;
/*  453 */       for (px = 0; px < rotorNum; px++) {
/*  454 */         if (getHP() >= getMaxHP() * 0.2D && getMaxHP() > 0) {
/*  455 */           int rotor_pos = (int)((getHP() / getMaxHP() - 0.2D) / 0.3D * 15.0D);
/*  456 */           if (rotor_pos > 0 && this.field_70146_Z.nextInt(rotor_pos) > 0) {
/*  457 */             spawnSmoke = false;
/*      */           }
/*      */         } 
/*      */         
/*  461 */         Vec3 var16 = ((MCP_PlaneInfo.Rotor)(getPlaneInfo()).rotorList.get(px)).pos;
/*  462 */         Vec3 py = MCH_Lib.RotVec3(var16, -yaw, -pitch, -roll);
/*  463 */         double x = this.field_70165_t + py.field_72450_a;
/*  464 */         double y = this.field_70163_u + py.field_72448_b;
/*  465 */         double z = this.field_70161_v + py.field_72449_c;
/*  466 */         onUpdate_Particle2SpawnSmoke(px, x, y, z, 1.0F, spawnSmoke);
/*      */       } 
/*      */       
/*  469 */       spawnSmoke = true;
/*  470 */       if (getHP() >= getMaxHP() * 0.2D && getMaxHP() > 0) {
/*  471 */         px = (int)((getHP() / getMaxHP() - 0.2D) / 0.3D * 15.0D);
/*  472 */         if (px > 0 && this.field_70146_Z.nextInt(px) > 0) {
/*  473 */           spawnSmoke = false;
/*      */         }
/*      */       } 
/*      */       
/*  477 */       double var15 = this.field_70165_t;
/*  478 */       double var17 = this.field_70163_u;
/*  479 */       double pz = this.field_70161_v;
/*  480 */       if (getSeatInfo(0) != null && (getSeatInfo(0)).pos != null) {
/*  481 */         Vec3 pos = MCH_Lib.RotVec3(0.0D, (getSeatInfo(0)).pos.field_72448_b, -2.0D, -yaw, -pitch, -roll);
/*  482 */         var15 += pos.field_72450_a;
/*  483 */         var17 += pos.field_72448_b;
/*  484 */         pz += pos.field_72449_c;
/*      */       } 
/*      */       
/*  487 */       onUpdate_Particle2SpawnSmoke(rotorNum, var15, var17, pz, (rotorNum == 0) ? 2.0F : 1.0F, spawnSmoke);
/*  488 */       this.isFirstDamageSmoke = false;
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void onUpdate_Particle2SpawnSmoke(int ri, double x, double y, double z, float size, boolean spawnSmoke) {
/*  495 */     if (this.isFirstDamageSmoke || this.prevDamageSmokePos[ri] == null) {
/*  496 */       this.prevDamageSmokePos[ri] = Vec3.func_72443_a(x, y, z);
/*      */     }
/*      */     
/*  499 */     Vec3 prev = this.prevDamageSmokePos[ri];
/*  500 */     double dx = x - prev.field_72450_a;
/*  501 */     double dy = y - prev.field_72448_b;
/*  502 */     double dz = z - prev.field_72449_c;
/*  503 */     int num = (int)(MathHelper.func_76133_a(dx * dx + dy * dy + dz * dz) / 0.3D) + 1;
/*      */     
/*  505 */     for (int i = 0; i < num; i++) {
/*  506 */       float c = 0.2F + this.field_70146_Z.nextFloat() * 0.3F;
/*  507 */       MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", prev.field_72450_a + (x - prev.field_72450_a) * i / 3.0D, prev.field_72448_b + (y - prev.field_72448_b) * i / 3.0D, prev.field_72449_c + (z - prev.field_72449_c) * i / 3.0D);
/*  508 */       prm.motionX = size * (this.field_70146_Z.nextDouble() - 0.5D) * 0.3D;
/*  509 */       prm.motionY = size * this.field_70146_Z.nextDouble() * 0.1D;
/*  510 */       prm.motionZ = size * (this.field_70146_Z.nextDouble() - 0.5D) * 0.3D;
/*  511 */       prm.size = size * (this.field_70146_Z.nextInt(5) + 5.0F) * 1.0F;
/*  512 */       prm.setColor(0.7F + this.field_70146_Z.nextFloat() * 0.1F, c, c, c);
/*  513 */       MCH_ParticlesUtil.spawnParticle(prm);
/*      */     } 
/*      */     
/*  516 */     (this.prevDamageSmokePos[ri]).field_72450_a = x;
/*  517 */     (this.prevDamageSmokePos[ri]).field_72448_b = y;
/*  518 */     (this.prevDamageSmokePos[ri]).field_72449_c = z;
/*      */   }
/*      */   
/*      */   public void onUpdate_ParticleLandingGear() {
/*  522 */     double d = this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y;
/*  523 */     if (d > 0.01D) {
/*  524 */       int x = MathHelper.func_76128_c(this.field_70165_t + 0.5D);
/*  525 */       int y = MathHelper.func_76128_c(this.field_70163_u - 0.5D);
/*  526 */       int z = MathHelper.func_76128_c(this.field_70161_v + 0.5D);
/*  527 */       MCH_ParticlesUtil.spawnParticleTileCrack(this.field_70170_p, x, y, z, this.field_70165_t + (this.field_70146_Z.nextFloat() - 0.5D) * this.field_70130_N, this.field_70121_D.field_72338_b + 0.1D, this.field_70161_v + (this.field_70146_Z.nextFloat() - 0.5D) * this.field_70130_N, -this.field_70159_w * 4.0D, 1.5D, -this.field_70179_y * 4.0D);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void onUpdate_ParticleSplash() {
/*  533 */     if (getAcInfo() != null && 
/*  534 */       this.field_70170_p.field_72995_K) {
/*  535 */       double mx = this.field_70165_t - this.field_70169_q;
/*  536 */       double mz = this.field_70161_v - this.field_70166_s;
/*  537 */       double dist = mx * mx + mz * mz;
/*  538 */       if (dist > 1.0D) {
/*  539 */         dist = 1.0D;
/*      */       }
/*      */       
/*  542 */       Iterator<MCH_AircraftInfo.ParticleSplash> i$ = (getAcInfo()).particleSplashs.iterator();
/*      */       
/*  544 */       while (i$.hasNext()) {
/*  545 */         MCH_AircraftInfo.ParticleSplash p = i$.next();
/*      */         
/*  547 */         for (int i = 0; i < p.num; i++) {
/*  548 */           if (dist > 0.03D + this.field_70146_Z.nextFloat() * 0.1D) {
/*  549 */             setParticleSplash(p.pos, -mx * p.acceleration, p.motionY, -mz * p.acceleration, p.gravity, p.size * (0.5D + dist * 0.5D), p.age);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   private void setParticleSplash(Vec3 pos, double mx, double my, double mz, float gravity, double size, int age) {
/*  559 */     Vec3 v = getTransformedPosition(pos);
/*  560 */     v = v.func_72441_c(this.field_70146_Z.nextDouble() - 0.5D, (this.field_70146_Z.nextDouble() - 0.5D) * 0.5D, this.field_70146_Z.nextDouble() - 0.5D);
/*  561 */     int x = (int)(v.field_72450_a + 0.5D);
/*  562 */     int y = (int)(v.field_72448_b + 0.0D);
/*  563 */     int z = (int)(v.field_72449_c + 0.5D);
/*  564 */     if (W_WorldFunc.isBlockWater(this.field_70170_p, x, y, z)) {
/*  565 */       float c = this.field_70146_Z.nextFloat() * 0.3F + 0.7F;
/*  566 */       MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", v.field_72450_a, v.field_72448_b, v.field_72449_c);
/*  567 */       prm.motionX = mx + (this.field_70146_Z.nextFloat() - 0.5D) * 0.7D;
/*  568 */       prm.motionY = my;
/*  569 */       prm.motionZ = mz + (this.field_70146_Z.nextFloat() - 0.5D) * 0.7D;
/*  570 */       prm.size = (float)size * (this.field_70146_Z.nextFloat() * 0.2F + 0.8F);
/*  571 */       prm.setColor(0.9F, c, c, c);
/*  572 */       prm.age = age + (int)(this.field_70146_Z.nextFloat() * 0.5D * age);
/*  573 */       prm.gravity = gravity;
/*  574 */       MCH_ParticlesUtil.spawnParticle(prm);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void onUpdate_ParticleNozzle() {
/*  580 */     if (this.planeInfo != null && this.planeInfo.haveNozzle() && 
/*  581 */       getCurrentThrottle() > 0.10000000149011612D) {
/*  582 */       float yaw = getRotYaw();
/*  583 */       float pitch = getRotPitch();
/*  584 */       float roll = getRotRoll();
/*  585 */       Vec3 nozzleRot = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -yaw - 180.0F, pitch - getNozzleRotation(), roll);
/*  586 */       Iterator<MCH_AircraftInfo.DrawnPart> i$ = this.planeInfo.nozzles.iterator();
/*      */       
/*  588 */       while (i$.hasNext()) {
/*  589 */         MCH_AircraftInfo.DrawnPart nozzle = i$.next();
/*  590 */         if (this.field_70146_Z.nextFloat() <= getCurrentThrottle() * 1.5D) {
/*  591 */           Vec3 nozzlePos = MCH_Lib.RotVec3(nozzle.pos, -yaw, -pitch, -roll);
/*  592 */           double x = this.field_70165_t + nozzlePos.field_72450_a + nozzleRot.field_72450_a;
/*  593 */           double y = this.field_70163_u + nozzlePos.field_72448_b + nozzleRot.field_72448_b;
/*  594 */           double z = this.field_70161_v + nozzlePos.field_72449_c + nozzleRot.field_72449_c;
/*  595 */           float a = 0.7F;
/*  596 */           if (W_WorldFunc.getBlockId(this.field_70170_p, (int)(x + nozzleRot.field_72450_a * 3.0D), (int)(y + nozzleRot.field_72448_b * 3.0D), (int)(z + nozzleRot.field_72449_c * 3.0D)) != 0) {
/*  597 */             a = 2.0F;
/*      */           }
/*      */           
/*  600 */           MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", x, y, z, nozzleRot.field_72450_a + ((this.field_70146_Z.nextFloat() - 0.5F) * a), nozzleRot.field_72448_b, nozzleRot.field_72449_c + ((this.field_70146_Z.nextFloat() - 0.5F) * a), 5.0F * (getAcInfo()).particlesScale);
/*  601 */           MCH_ParticlesUtil.spawnParticle(prm);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void destroyAircraft() {
/*  610 */     super.destroyAircraft();
/*  611 */     byte inv = 1;
/*  612 */     if (getRotRoll() >= 0.0F) {
/*  613 */       if (getRotRoll() > 90.0F) {
/*  614 */         inv = -1;
/*      */       }
/*  616 */     } else if (getRotRoll() > -90.0F) {
/*  617 */       inv = -1;
/*      */     } 
/*      */     
/*  620 */     this.rotDestroyedRoll = (0.5F + this.field_70146_Z.nextFloat()) * inv;
/*      */   }
/*      */   
/*      */   protected void onUpdate_Client() {
/*  624 */     if (getRiddenByEntity() != null && W_Lib.isClientPlayer(getRiddenByEntity())) {
/*  625 */       (getRiddenByEntity()).field_70125_A = (getRiddenByEntity()).field_70127_C;
/*      */     }
/*      */     
/*  628 */     if (this.aircraftPosRotInc > 0) {
/*  629 */       applyServerPositionAndRotation();
/*      */     } else {
/*  631 */       func_70107_b(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/*  632 */       if (!isDestroyed() && (this.field_70122_E || MCH_Lib.getBlockIdY((Entity)this, 1, -2) > 0)) {
/*  633 */         this.field_70159_w *= 0.95D;
/*  634 */         this.field_70179_y *= 0.95D;
/*  635 */         applyOnGroundPitch(0.95F);
/*      */       } 
/*      */       
/*  638 */       if (func_70090_H()) {
/*  639 */         this.field_70159_w *= 0.99D;
/*  640 */         this.field_70179_y *= 0.99D;
/*      */       } 
/*      */     } 
/*      */     
/*  644 */     if (isDestroyed()) {
/*  645 */       if (MCH_Lib.getBlockIdY((Entity)this, 3, -3) == 0) {
/*  646 */         if (MathHelper.func_76135_e(getRotPitch()) < 10.0F) {
/*  647 */           setRotPitch(getRotPitch() + this.rotDestroyedPitch);
/*      */         }
/*      */         
/*  650 */         float roll = MathHelper.func_76135_e(getRotRoll());
/*  651 */         if (roll < 45.0F || roll > 135.0F) {
/*  652 */           setRotRoll(getRotRoll() + this.rotDestroyedRoll);
/*      */         }
/*  654 */       } else if (MathHelper.func_76135_e(getRotPitch()) > 20.0F) {
/*  655 */         setRotPitch(getRotPitch() * 0.99F);
/*      */       } 
/*      */     }
/*      */     
/*  659 */     if (getRiddenByEntity() != null);
/*      */ 
/*      */ 
/*      */     
/*  663 */     updateSound();
/*  664 */     onUpdate_Particle();
/*  665 */     onUpdate_Particle2();
/*  666 */     onUpdate_ParticleSplash();
/*  667 */     onUpdate_ParticleSandCloud(true);
/*  668 */     updateCamera(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*      */   }
/*      */   private void onUpdate_Server() {
/*      */     Vec3 v;
/*  672 */     Entity rdnEnt = getRiddenByEntity();
/*  673 */     double prevMotion = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*  674 */     double dp = 0.0D;
/*  675 */     if (canFloatWater()) {
/*  676 */       dp = getWaterDepth();
/*      */     }
/*      */     
/*  679 */     boolean levelOff = this.isGunnerMode;
/*  680 */     if (dp == 0.0D) {
/*  681 */       if (isTargetDrone() && canUseFuel() && !isDestroyed()) {
/*  682 */         Block throttle = MCH_Lib.getBlockY((Entity)this, 3, -40, true);
/*  683 */         if (throttle != null && !W_Block.isEqual(throttle, Blocks.field_150350_a)) {
/*  684 */           throttle = MCH_Lib.getBlockY((Entity)this, 3, -5, true);
/*  685 */           if (throttle == null || W_Block.isEqual(throttle, Blocks.field_150350_a)) {
/*  686 */             setRotYaw(getRotYaw() + (getAcInfo()).autoPilotRot * 2.0F);
/*  687 */             if (getRotPitch() > -20.0F) {
/*  688 */               setRotPitch(getRotPitch() - 0.5F);
/*      */             }
/*      */           } 
/*      */         } else {
/*  692 */           setRotYaw(getRotYaw() + (getAcInfo()).autoPilotRot * 1.0F);
/*  693 */           setRotPitch(getRotPitch() * 0.95F);
/*  694 */           if (canFoldLandingGear()) {
/*  695 */             foldLandingGear();
/*      */           }
/*      */           
/*  698 */           levelOff = true;
/*      */         } 
/*      */       } 
/*      */       
/*  702 */       if (!levelOff) {
/*  703 */         this.field_70181_x += 0.04D + (!func_70090_H() ? (getAcInfo()).gravity : (getAcInfo()).gravityInWater);
/*  704 */         this.field_70181_x += -0.047D * (1.0D - getCurrentThrottle());
/*      */       } else {
/*  706 */         this.field_70181_x *= 0.8D;
/*      */       } 
/*      */     } else {
/*  709 */       setRotPitch(getRotPitch() * 0.8F, "getWaterDepth != 0");
/*  710 */       if (MathHelper.func_76135_e(getRotRoll()) < 40.0F) {
/*  711 */         setRotRoll(getRotRoll() * 0.9F);
/*      */       }
/*      */       
/*  714 */       if (dp < 1.0D) {
/*  715 */         this.field_70181_x -= 1.0E-4D;
/*  716 */         this.field_70181_x += 0.007D * getCurrentThrottle();
/*      */       } else {
/*  718 */         if (this.field_70181_x < 0.0D) {
/*  719 */           this.field_70181_x /= 2.0D;
/*      */         }
/*      */         
/*  722 */         this.field_70181_x += 0.007D;
/*      */       } 
/*      */     } 
/*      */     
/*  726 */     float throttle1 = (float)(getCurrentThrottle() / 10.0D);
/*      */     
/*  728 */     if (getNozzleRotation() > 0.001F) {
/*  729 */       setRotPitch(getRotPitch() * 0.95F);
/*  730 */       v = MCH_Lib.Rot2Vec3(getRotYaw(), getRotPitch() - getNozzleRotation());
/*  731 */       if (getNozzleRotation() >= 90.0F) {
/*  732 */         v.field_72450_a *= 0.800000011920929D;
/*  733 */         v.field_72449_c *= 0.800000011920929D;
/*      */       } 
/*      */     } else {
/*  736 */       v = MCH_Lib.Rot2Vec3(getRotYaw(), getRotPitch() - 10.0F);
/*      */     } 
/*      */     
/*  739 */     if (!levelOff) {
/*  740 */       if (getNozzleRotation() <= 0.01F) {
/*  741 */         this.field_70181_x += v.field_72448_b * throttle1 / 2.0D;
/*      */       } else {
/*  743 */         this.field_70181_x += v.field_72448_b * throttle1 / 8.0D;
/*      */       } 
/*      */     }
/*      */     
/*  747 */     boolean canMove = true;
/*  748 */     if (!(getAcInfo()).canMoveOnGround) {
/*  749 */       Block motion = MCH_Lib.getBlockY((Entity)this, 3, -2, false);
/*  750 */       if (!W_Block.isEqual(motion, W_Block.getWater()) && !W_Block.isEqual(motion, Blocks.field_150350_a)) {
/*  751 */         canMove = false;
/*      */       }
/*      */     } 
/*      */     
/*  755 */     if (canMove) {
/*  756 */       if ((getAcInfo()).enableBack && this.throttleBack > 0.0F) {
/*  757 */         this.field_70159_w -= v.field_72450_a * this.throttleBack;
/*  758 */         this.field_70179_y -= v.field_72449_c * this.throttleBack;
/*      */       } else {
/*  760 */         this.field_70159_w += v.field_72450_a * throttle1;
/*  761 */         this.field_70179_y += v.field_72449_c * throttle1;
/*      */       } 
/*      */     }
/*      */     
/*  765 */     double motion1 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*  766 */     float speedLimit = getMaxSpeed();
/*  767 */     if (motion1 > speedLimit) {
/*  768 */       this.field_70159_w *= speedLimit / motion1;
/*  769 */       this.field_70179_y *= speedLimit / motion1;
/*  770 */       motion1 = speedLimit;
/*      */     } 
/*      */     
/*  773 */     if (motion1 > prevMotion && this.currentSpeed < speedLimit) {
/*  774 */       this.currentSpeed += (speedLimit - this.currentSpeed) / 35.0D;
/*  775 */       if (this.currentSpeed > speedLimit) {
/*  776 */         this.currentSpeed = speedLimit;
/*      */       }
/*      */     } else {
/*  779 */       this.currentSpeed -= (this.currentSpeed - 0.07D) / 35.0D;
/*  780 */       if (this.currentSpeed < 0.07D) {
/*  781 */         this.currentSpeed = 0.07D;
/*      */       }
/*      */     } 
/*      */     
/*  785 */     if (this.field_70122_E || MCH_Lib.getBlockIdY((Entity)this, 1, -2) > 0) {
/*  786 */       this.field_70159_w *= (getAcInfo()).motionFactor;
/*  787 */       this.field_70179_y *= (getAcInfo()).motionFactor;
/*  788 */       if (MathHelper.func_76135_e(getRotPitch()) < 40.0F) {
/*  789 */         applyOnGroundPitch(0.8F);
/*      */       }
/*      */     } 
/*      */     
/*  793 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*  794 */     this.field_70181_x *= 0.95D;
/*  795 */     this.field_70159_w *= (getAcInfo()).motionFactor;
/*  796 */     this.field_70179_y *= (getAcInfo()).motionFactor;
/*  797 */     func_70101_b(getRotYaw(), getRotPitch());
/*  798 */     onUpdate_updateBlock();
/*  799 */     if (getRiddenByEntity() != null && (getRiddenByEntity()).field_70128_L) {
/*  800 */       unmountEntity();
/*  801 */       this.field_70153_n = null;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public float getMaxSpeed() {
/*  807 */     float f = 0.0F;
/*  808 */     if (this.partWing != null && (getPlaneInfo()).isVariableSweepWing) {
/*  809 */       f = ((getPlaneInfo()).sweepWingSpeed - (getPlaneInfo()).speed) * this.partWing.getFactor();
/*  810 */     } else if (this.partHatch != null && (getPlaneInfo()).isVariableSweepWing) {
/*  811 */       f = ((getPlaneInfo()).sweepWingSpeed - (getPlaneInfo()).speed) * this.partHatch.getFactor();
/*      */     } 
/*      */     
/*  814 */     return (getPlaneInfo()).speed + f;
/*      */   }
/*      */   
/*      */   public float getSoundVolume() {
/*  818 */     return (getAcInfo() != null && (getAcInfo()).throttleUpDown <= 0.0F) ? 0.0F : (this.soundVolume * 0.7F);
/*      */   }
/*      */   
/*      */   public void updateSound() {
/*  822 */     float target = (float)getCurrentThrottle();
/*  823 */     if (getRiddenByEntity() != null && (this.partCanopy == null || getCanopyRotation() < 1.0F)) {
/*  824 */       target += 0.1F;
/*      */     }
/*      */     
/*  827 */     if (this.soundVolume < target) {
/*  828 */       this.soundVolume += 0.02F;
/*  829 */       if (this.soundVolume >= target) {
/*  830 */         this.soundVolume = target;
/*      */       }
/*  832 */     } else if (this.soundVolume > target) {
/*  833 */       this.soundVolume -= 0.02F;
/*  834 */       if (this.soundVolume <= target) {
/*  835 */         this.soundVolume = target;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public float getSoundPitch() {
/*  842 */     return (float)(0.6D + getCurrentThrottle() * 0.4D);
/*      */   }
/*      */   
/*      */   public String getDefaultSoundName() {
/*  846 */     return "plane";
/*      */   }
/*      */   
/*      */   public void updateParts(int stat) {
/*  850 */     super.updateParts(stat);
/*  851 */     if (!isDestroyed()) {
/*  852 */       MCH_Parts[] parts = { this.partNozzle, this.partWing };
/*  853 */       MCH_Parts[] arr$ = parts;
/*  854 */       int len$ = parts.length;
/*      */       
/*  856 */       for (int i$ = 0; i$ < len$; i$++) {
/*  857 */         MCH_Parts p = arr$[i$];
/*  858 */         if (p != null) {
/*  859 */           p.updateStatusClient(stat);
/*  860 */           p.update();
/*      */         } 
/*      */       } 
/*      */       
/*  864 */       if (!this.field_70170_p.field_72995_K && this.partWing != null && (getPlaneInfo()).isVariableSweepWing && this.partWing.isON() && getCurrentThrottle() >= 0.20000000298023224D && (getCurrentThrottle() < 0.5D || MCH_Lib.getBlockIdY((Entity)this, 1, -10) != 0)) {
/*  865 */         this.partWing.setStatusServer(false);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public float getUnfoldLandingGearThrottle() {
/*  872 */     return 0.7F;
/*      */   }
/*      */   
/*      */   public boolean canSwitchVtol() {
/*  876 */     if (this.planeInfo != null && this.planeInfo.isEnableVtol) {
/*  877 */       if (getModeSwitchCooldown() > 0)
/*  878 */         return false; 
/*  879 */       if (getVtolMode() == 1)
/*  880 */         return false; 
/*  881 */       if (MathHelper.func_76135_e(getRotRoll()) > 30.0F)
/*  882 */         return false; 
/*  883 */       if (this.field_70122_E && this.planeInfo.isDefaultVtol) {
/*  884 */         return false;
/*      */       }
/*  886 */       setModeSwitchCooldown(20);
/*  887 */       return true;
/*      */     } 
/*      */     
/*  890 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getNozzleStat() {
/*  895 */     return (this.partNozzle != null) ? this.partNozzle.getStatus() : false;
/*      */   }
/*      */   
/*      */   public int getVtolMode() {
/*  899 */     return !getNozzleStat() ? ((getNozzleRotation() <= 0.005F) ? 0 : 1) : ((getNozzleRotation() >= 89.995F) ? 2 : 1);
/*      */   }
/*      */   
/*      */   public float getFuleConsumptionFactor() {
/*  903 */     return getFuelConsumptionFactor() * ((getVtolMode() == 2) ? true : true);
/*      */   }
/*      */   
/*      */   public float getNozzleRotation() {
/*  907 */     return (this.partNozzle != null) ? this.partNozzle.rotation : 0.0F;
/*      */   }
/*      */   
/*      */   public float getPrevNozzleRotation() {
/*  911 */     return (this.partNozzle != null) ? this.partNozzle.prevRotation : 0.0F;
/*      */   }
/*      */   
/*      */   public void swithVtolMode(boolean mode) {
/*  915 */     if (this.partNozzle != null) {
/*  916 */       if (this.planeInfo.isDefaultVtol && this.field_70122_E && !mode) {
/*      */         return;
/*      */       }
/*      */       
/*  920 */       if (!this.field_70170_p.field_72995_K) {
/*  921 */         this.partNozzle.setStatusServer(mode);
/*      */       }
/*      */       
/*  924 */       if (getRiddenByEntity() != null && !(getRiddenByEntity()).field_70128_L) {
/*  925 */         (getRiddenByEntity()).field_70125_A = (getRiddenByEntity()).field_70127_C = 0.0F;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected MCH_Parts createNozzle(MCP_PlaneInfo info) {
/*  932 */     MCH_Parts nozzle = null;
/*  933 */     if (info.haveNozzle() || info.haveRotor() || info.isEnableVtol) {
/*  934 */       nozzle = new MCH_Parts((Entity)this, 1, 31, "Nozzle");
/*  935 */       nozzle.rotationMax = 90.0F;
/*  936 */       nozzle.rotationInv = 1.5F;
/*  937 */       nozzle.soundStartSwichOn.setPrm("plane_cc", 1.0F, 0.5F);
/*  938 */       nozzle.soundEndSwichOn.setPrm("plane_cc", 1.0F, 0.5F);
/*  939 */       nozzle.soundStartSwichOff.setPrm("plane_cc", 1.0F, 0.5F);
/*  940 */       nozzle.soundEndSwichOff.setPrm("plane_cc", 1.0F, 0.5F);
/*  941 */       nozzle.soundSwitching.setPrm("plane_cv", 1.0F, 0.5F);
/*  942 */       if (info.isDefaultVtol) {
/*  943 */         nozzle.forceSwitch(true);
/*      */       }
/*      */     } 
/*      */     
/*  947 */     return nozzle;
/*      */   }
/*      */   
/*      */   protected MCH_Parts createWing(MCP_PlaneInfo info) {
/*  951 */     MCH_Parts wing = null;
/*  952 */     if (this.planeInfo.haveWing()) {
/*  953 */       wing = new MCH_Parts((Entity)this, 3, 31, "Wing");
/*  954 */       wing.rotationMax = 90.0F;
/*  955 */       wing.rotationInv = 2.5F;
/*  956 */       wing.soundStartSwichOn.setPrm("plane_cc", 1.0F, 0.5F);
/*  957 */       wing.soundEndSwichOn.setPrm("plane_cc", 1.0F, 0.5F);
/*  958 */       wing.soundStartSwichOff.setPrm("plane_cc", 1.0F, 0.5F);
/*  959 */       wing.soundEndSwichOff.setPrm("plane_cc", 1.0F, 0.5F);
/*      */     } 
/*      */     
/*  962 */     return wing;
/*      */   }
/*      */   
/*      */   public boolean canUseWing() {
/*  966 */     return (this.partWing == null) ? true : ((getPlaneInfo()).isVariableSweepWing ? ((getCurrentThrottle() < 0.2D) ? this.partWing.isOFF() : true) : this.partWing.isOFF());
/*      */   }
/*      */   
/*      */   public boolean canFoldWing() {
/*  970 */     if (this.partWing != null && getModeSwitchCooldown() <= 0) {
/*  971 */       if ((getPlaneInfo()).isVariableSweepWing) {
/*  972 */         if (!this.field_70122_E && MCH_Lib.getBlockIdY((Entity)this, 3, -20) == 0) {
/*  973 */           if (getCurrentThrottle() < 0.699999988079071D) {
/*  974 */             return false;
/*      */           }
/*  976 */         } else if (getCurrentThrottle() > 0.10000000149011612D) {
/*  977 */           return false;
/*      */         } 
/*      */       } else {
/*  980 */         if (!this.field_70122_E && MCH_Lib.getBlockIdY((Entity)this, 3, -3) == 0) {
/*  981 */           return false;
/*      */         }
/*      */         
/*  984 */         if (getCurrentThrottle() > 0.009999999776482582D) {
/*  985 */           return false;
/*      */         }
/*      */       } 
/*      */       
/*  989 */       return this.partWing.isOFF();
/*      */     } 
/*  991 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canUnfoldWing() {
/*  996 */     return (this.partWing != null && getModeSwitchCooldown() <= 0) ? this.partWing.isON() : false;
/*      */   }
/*      */   
/*      */   public void foldWing(boolean fold) {
/* 1000 */     if (this.partWing != null && getModeSwitchCooldown() <= 0) {
/* 1001 */       this.partWing.setStatusServer(fold);
/* 1002 */       setModeSwitchCooldown(20);
/*      */     } 
/*      */   }
/*      */   
/*      */   public float getWingRotation() {
/* 1007 */     return (this.partWing != null) ? this.partWing.rotation : 0.0F;
/*      */   }
/*      */   
/*      */   public float getPrevWingRotation() {
/* 1011 */     return (this.partWing != null) ? this.partWing.prevRotation : 0.0F;
/*      */   }
/*      */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\plane\MCP_EntityPlane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */