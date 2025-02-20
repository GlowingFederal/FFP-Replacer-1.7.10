/*     */ package mcheli.uav;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Explosion;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.helicopter.MCH_HeliInfo;
/*     */ import mcheli.helicopter.MCH_HeliInfoManager;
/*     */ import mcheli.helicopter.MCH_ItemHeli;
/*     */ import mcheli.multiplay.MCH_Multiplay;
/*     */ import mcheli.plane.MCP_ItemPlane;
/*     */ import mcheli.plane.MCP_PlaneInfo;
/*     */ import mcheli.plane.MCP_PlaneInfoManager;
/*     */ import mcheli.tank.MCH_ItemTank;
/*     */ import mcheli.tank.MCH_TankInfo;
/*     */ import mcheli.tank.MCH_TankInfoManager;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_EntityContainer;
/*     */ import mcheli.wrapper.W_EntityPlayer;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.ChatComponentText;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.EnumChatFormatting;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_EntityUavStation
/*     */   extends W_EntityContainer
/*     */ {
/*     */   protected static final int DATAWT_ID_KIND = 27;
/*     */   protected static final int DATAWT_ID_LAST_AC = 28;
/*     */   protected static final int DATAWT_ID_UAV_X = 29;
/*     */   protected static final int DATAWT_ID_UAV_Y = 30;
/*     */   protected static final int DATAWT_ID_UAV_Z = 31;
/*     */   protected Entity lastRiddenByEntity;
/*     */   public boolean isRequestedSyncStatus;
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected double velocityX;
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected double velocityY;
/*     */   @SideOnly(Side.CLIENT)
/*     */   protected double velocityZ;
/*     */   protected int aircraftPosRotInc;
/*     */   protected double aircraftX;
/*     */   
/*     */   public MCH_EntityUavStation(World world) {
/*  69 */     super(world);
/*  70 */     this.dropContentsWhenDead = false;
/*  71 */     this.field_70156_m = true;
/*  72 */     func_70105_a(2.0F, 0.7F);
/*  73 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  74 */     this.field_70159_w = 0.0D;
/*  75 */     this.field_70181_x = 0.0D;
/*  76 */     this.field_70179_y = 0.0D;
/*  77 */     this.field_70158_ak = true;
/*  78 */     this.lastRiddenByEntity = null;
/*  79 */     this.aircraftPosRotInc = 0;
/*  80 */     this.aircraftX = 0.0D;
/*  81 */     this.aircraftY = 0.0D;
/*  82 */     this.aircraftZ = 0.0D;
/*  83 */     this.aircraftYaw = 0.0D;
/*  84 */     this.aircraftPitch = 0.0D;
/*  85 */     this.posUavX = 0;
/*  86 */     this.posUavY = 0;
/*  87 */     this.posUavZ = 0;
/*  88 */     this.rotCover = 0.0F;
/*  89 */     this.prevRotCover = 0.0F;
/*  90 */     setControlAircract((MCH_EntityAircraft)null);
/*  91 */     setLastControlAircraft((MCH_EntityAircraft)null);
/*  92 */     this.loadedLastControlAircraftGuid = "";
/*     */   }
/*     */   protected double aircraftY; protected double aircraftZ; protected double aircraftYaw; protected double aircraftPitch; private MCH_EntityAircraft controlAircraft; private MCH_EntityAircraft lastControlAircraft; private String loadedLastControlAircraftGuid; public int posUavX; public int posUavY; public int posUavZ; public float rotCover; public float prevRotCover;
/*     */   protected void func_70088_a() {
/*  96 */     super.func_70088_a();
/*  97 */     func_70096_w().func_75682_a(27, Byte.valueOf((byte)0));
/*  98 */     func_70096_w().func_75682_a(28, Integer.valueOf(0));
/*  99 */     func_70096_w().func_75682_a(29, Integer.valueOf(0));
/* 100 */     func_70096_w().func_75682_a(30, Integer.valueOf(0));
/* 101 */     func_70096_w().func_75682_a(31, Integer.valueOf(0));
/* 102 */     setOpen(true);
/*     */   }
/*     */   
/*     */   public int getStatus() {
/* 106 */     return func_70096_w().func_75683_a(27);
/*     */   }
/*     */   
/*     */   public void setStatus(int n) {
/* 110 */     if (!this.field_70170_p.field_72995_K) {
/* 111 */       MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityUavStation.setStatus(%d)", new Object[] { Integer.valueOf(n) });
/* 112 */       func_70096_w().func_75692_b(27, Byte.valueOf((byte)n));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getKind() {
/* 118 */     return 0x7F & getStatus();
/*     */   }
/*     */   
/*     */   public void setKind(int n) {
/* 122 */     setStatus(getStatus() & 0x80 | n);
/*     */   }
/*     */   
/*     */   public boolean isOpen() {
/* 126 */     return ((getStatus() & 0x80) != 0);
/*     */   }
/*     */   
/*     */   public void setOpen(boolean b) {
/* 130 */     setStatus((b ? 128 : 0) | getStatus() & 0x7F);
/*     */   }
/*     */   
/*     */   public MCH_EntityAircraft getControlAircract() {
/* 134 */     return this.controlAircraft;
/*     */   }
/*     */   
/*     */   public void setControlAircract(MCH_EntityAircraft ac) {
/* 138 */     this.controlAircraft = ac;
/* 139 */     if (ac != null && !ac.field_70128_L) {
/* 140 */       setLastControlAircraft(ac);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUavPosition(int x, int y, int z) {
/* 146 */     if (!this.field_70170_p.field_72995_K) {
/* 147 */       this.posUavX = x;
/* 148 */       this.posUavY = y;
/* 149 */       this.posUavZ = z;
/* 150 */       func_70096_w().func_75692_b(29, Integer.valueOf(x));
/* 151 */       func_70096_w().func_75692_b(30, Integer.valueOf(y));
/* 152 */       func_70096_w().func_75692_b(31, Integer.valueOf(z));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateUavPosition() {
/* 158 */     this.posUavX = func_70096_w().func_75679_c(29);
/* 159 */     this.posUavY = func_70096_w().func_75679_c(30);
/* 160 */     this.posUavZ = func_70096_w().func_75679_c(31);
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound nbt) {
/* 164 */     super.func_70014_b(nbt);
/* 165 */     nbt.func_74768_a("UavStatus", getStatus());
/* 166 */     nbt.func_74768_a("PosUavX", this.posUavX);
/* 167 */     nbt.func_74768_a("PosUavY", this.posUavY);
/* 168 */     nbt.func_74768_a("PosUavZ", this.posUavZ);
/* 169 */     String s = "";
/* 170 */     if (getLastControlAircraft() != null && !(getLastControlAircraft()).field_70128_L) {
/* 171 */       s = getLastControlAircraft().getCommonUniqueId();
/*     */     }
/*     */     
/* 174 */     if (s.isEmpty()) {
/* 175 */       s = this.loadedLastControlAircraftGuid;
/*     */     }
/*     */     
/* 178 */     nbt.func_74778_a("LastCtrlAc", s);
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound nbt) {
/* 182 */     super.func_70037_a(nbt);
/* 183 */     setUavPosition(nbt.func_74762_e("PosUavX"), nbt.func_74762_e("PosUavY"), nbt.func_74762_e("PosUavZ"));
/* 184 */     if (nbt.func_74764_b("UavStatus")) {
/* 185 */       setStatus(nbt.func_74762_e("UavStatus"));
/*     */     } else {
/* 187 */       setKind(1);
/*     */     } 
/*     */     
/* 190 */     this.loadedLastControlAircraftGuid = nbt.func_74779_i("LastCtrlAc");
/*     */   }
/*     */   
/*     */   public void initUavPostion() {
/* 194 */     int rt = (int)(MCH_Lib.getRotate360((this.field_70177_z + 45.0F)) / 90.0D);
/* 195 */     boolean D = true;
/* 196 */     this.posUavX = (rt != 0 && rt != 3) ? -12 : 12;
/* 197 */     this.posUavZ = (rt != 0 && rt != 1) ? -12 : 12;
/* 198 */     this.posUavY = 2;
/* 199 */     setUavPosition(this.posUavX, this.posUavY, this.posUavZ);
/*     */   }
/*     */   
/*     */   public void func_70106_y() {
/* 203 */     if (this.controlAircraft != null && 
/* 204 */       this.controlAircraft.isNewUAV() && this.controlAircraft.getRiddenByEntity() != null && 
/* 205 */       this.controlAircraft.getRiddenByEntity() instanceof EntityPlayer) {
/* 206 */       ((EntityPlayer)this.controlAircraft.getRiddenByEntity()).func_145747_a((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "Station destroyed!"));
/* 207 */       ((EntityPlayer)this.controlAircraft.getRiddenByEntity()).func_70690_d(new PotionEffect(11, 20, 50));
/* 208 */       this.controlAircraft.getRiddenByEntity().func_70078_a((Entity)this);
/*     */     } 
/*     */ 
/*     */     
/* 212 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource damageSource, float damage) {
/* 216 */     if (func_85032_ar())
/* 217 */       return false; 
/* 218 */     if (this.field_70128_L)
/* 219 */       return true; 
/* 220 */     if (this.field_70170_p.field_72995_K) {
/* 221 */       return true;
/*     */     }
/* 223 */     String dmt = damageSource.func_76355_l();
/* 224 */     MCH_Config var10000 = MCH_MOD.config;
/* 225 */     damage = MCH_Config.applyDamageByExternal((Entity)this, damageSource, damage);
/* 226 */     if (!MCH_Multiplay.canAttackEntity(damageSource, (Entity)this)) {
/* 227 */       return false;
/*     */     }
/* 229 */     boolean isCreative = false;
/* 230 */     Entity entity = damageSource.func_76346_g();
/* 231 */     boolean isDamegeSourcePlayer = false;
/* 232 */     if (entity instanceof EntityPlayer) {
/* 233 */       isCreative = ((EntityPlayer)entity).field_71075_bZ.field_75098_d;
/* 234 */       if (dmt.compareTo("player") == 0) {
/* 235 */         isDamegeSourcePlayer = true;
/*     */       }
/*     */       
/* 238 */       W_WorldFunc.MOD_playSoundAtEntity((Entity)this, "hit", 1.0F, 1.0F);
/*     */     } else {
/* 240 */       W_WorldFunc.MOD_playSoundAtEntity((Entity)this, "helidmg", 1.0F, 0.9F + this.field_70146_Z.nextFloat() * 0.1F);
/*     */     } 
/*     */     
/* 243 */     func_70018_K();
/* 244 */     if (damage > 0.0F) {
/* 245 */       if (this.field_70153_n != null) {
/* 246 */         this.field_70153_n.func_70078_a((Entity)this);
/*     */       }
/*     */       
/* 249 */       this.dropContentsWhenDead = true;
/* 250 */       func_70106_y();
/* 251 */       if (!isDamegeSourcePlayer) {
/* 252 */         MCH_Explosion.newExplosion(this.field_70170_p, (Entity)null, this.field_70153_n, this.field_70165_t, this.field_70163_u, this.field_70161_v, 1.0F, 0.0F, true, true, false, false, 0);
/*     */       }
/*     */       
/* 255 */       if (!isCreative) {
/* 256 */         int kind = getKind();
/* 257 */         if (kind > 0) {
/* 258 */           dropItemWithOffset((Item)MCH_MOD.itemUavStation[kind - 1], 1, 0.0F);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 263 */     return true;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected boolean func_70041_e_() {
/* 269 */     return false;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/* 273 */     return par1Entity.field_70121_D;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/* 277 */     return this.field_70121_D;
/*     */   }
/*     */   
/*     */   public boolean func_70104_M() {
/* 281 */     return false;
/*     */   }
/*     */   
/*     */   public double func_70042_X() {
/* 285 */     if (getKind() == 2 && this.field_70153_n != null) {
/* 286 */       double px = -Math.sin(this.field_70177_z * Math.PI / 180.0D) * 0.9D;
/* 287 */       double pz = Math.cos(this.field_70177_z * Math.PI / 180.0D) * 0.9D;
/* 288 */       int x = (int)(this.field_70165_t + px);
/* 289 */       int y = (int)(this.field_70163_u - 0.5D);
/* 290 */       int z = (int)(this.field_70161_v + pz);
/* 291 */       Block block = this.field_70170_p.func_147439_a(x, y, z);
/* 292 */       return block.func_149662_c() ? -0.4D : -0.9D;
/*     */     } 
/* 294 */     return 0.35D;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 300 */     return 2.0F;
/*     */   }
/*     */   
/*     */   public boolean func_70067_L() {
/* 304 */     return !this.field_70128_L;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70108_f(Entity par1Entity) {}
/*     */ 
/*     */   
/*     */   public void func_70024_g(double par1, double par3, double par5) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 315 */     this.velocityX = this.field_70159_w = par1;
/* 316 */     this.velocityY = this.field_70181_x = par3;
/* 317 */     this.velocityZ = this.field_70179_y = par5;
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/* 321 */     super.func_70071_h_();
/* 322 */     this.prevRotCover = this.rotCover;
/* 323 */     if (isOpen()) {
/* 324 */       if (this.rotCover < 1.0F) {
/* 325 */         this.rotCover += 0.1F;
/*     */       } else {
/* 327 */         this.rotCover = 1.0F;
/*     */       } 
/* 329 */     } else if (this.rotCover > 0.0F) {
/* 330 */       this.rotCover -= 0.1F;
/*     */     } else {
/* 332 */       this.rotCover = 0.0F;
/*     */     } 
/*     */     
/* 335 */     if (this.field_70153_n == null && 
/* 336 */       this.lastRiddenByEntity != null) {
/* 337 */       unmountEntity(true);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 343 */     int uavStationKind = getKind();
/* 344 */     if (this.field_70173_aa >= 30 || uavStationKind <= 0 || uavStationKind == 1 || uavStationKind == 2);
/*     */ 
/*     */ 
/*     */     
/* 348 */     if (this.field_70170_p.field_72995_K && !this.isRequestedSyncStatus) {
/* 349 */       this.isRequestedSyncStatus = true;
/*     */     }
/*     */     
/* 352 */     this.field_70169_q = this.field_70165_t;
/* 353 */     this.field_70167_r = this.field_70163_u;
/* 354 */     this.field_70166_s = this.field_70161_v;
/* 355 */     if (getControlAircract() != null && ((getControlAircract()).field_70128_L || getControlAircract().isDestroyed())) {
/* 356 */       setControlAircract((MCH_EntityAircraft)null);
/*     */     }
/*     */     
/* 359 */     if (getLastControlAircraft() != null && ((getLastControlAircraft()).field_70128_L || getLastControlAircraft().isDestroyed())) {
/* 360 */       setLastControlAircraft((MCH_EntityAircraft)null);
/*     */     }
/*     */     
/* 363 */     if (this.field_70170_p.field_72995_K) {
/* 364 */       onUpdate_Client();
/*     */     } else {
/* 366 */       onUpdate_Server();
/*     */     } 
/*     */     
/* 369 */     this.lastRiddenByEntity = this.field_70153_n;
/*     */   }
/*     */   
/*     */   public MCH_EntityAircraft getLastControlAircraft() {
/* 373 */     return this.lastControlAircraft;
/*     */   }
/*     */   
/*     */   public MCH_EntityAircraft getAndSearchLastControlAircraft() {
/* 377 */     if (getLastControlAircraft() == null) {
/* 378 */       int id = getLastControlAircraftEntityId().intValue();
/* 379 */       if (id > 0) {
/* 380 */         Entity entity = this.field_70170_p.func_73045_a(id);
/* 381 */         if (entity instanceof MCH_EntityAircraft) {
/* 382 */           MCH_EntityAircraft ac = (MCH_EntityAircraft)entity;
/* 383 */           if (ac.isUAV()) {
/* 384 */             setLastControlAircraft(ac);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 390 */     return getLastControlAircraft();
/*     */   }
/*     */   
/*     */   public void setLastControlAircraft(MCH_EntityAircraft ac) {
/* 394 */     MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityUavStation.setLastControlAircraft:" + ac, new Object[0]);
/* 395 */     this.lastControlAircraft = ac;
/*     */   }
/*     */   
/*     */   public Integer getLastControlAircraftEntityId() {
/* 399 */     return Integer.valueOf(func_70096_w().func_75679_c(28));
/*     */   }
/*     */   
/*     */   public void setLastControlAircraftEntityId(int s) {
/* 403 */     if (!this.field_70170_p.field_72995_K) {
/* 404 */       func_70096_w().func_75692_b(28, Integer.valueOf(s));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void searchLastControlAircraft() {
/* 410 */     if (!this.loadedLastControlAircraftGuid.isEmpty()) {
/* 411 */       List<MCH_EntityAircraft> list = this.field_70170_p.func_72872_a(MCH_EntityAircraft.class, func_70046_E().func_72314_b(120.0D, 120.0D, 120.0D));
/* 412 */       if (list != null) {
/* 413 */         for (int i = 0; i < list.size(); i++) {
/* 414 */           MCH_EntityAircraft ac = list.get(i);
/* 415 */           if (ac.getCommonUniqueId().equals(this.loadedLastControlAircraftGuid)) {
/* 416 */             String n = (ac.getAcInfo() != null) ? (ac.getAcInfo()).displayName : ("no info : " + ac);
/* 417 */             MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityUavStation.searchLastControlAircraft:found" + n, new Object[0]);
/* 418 */             setLastControlAircraft(ac);
/* 419 */             setLastControlAircraftEntityId(W_Entity.getEntityId((Entity)ac));
/* 420 */             this.loadedLastControlAircraftGuid = "";
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdate_Client() {
/* 430 */     if (this.aircraftPosRotInc > 0) {
/* 431 */       double rpinc = this.aircraftPosRotInc;
/* 432 */       double yaw = MathHelper.func_76138_g(this.aircraftYaw - this.field_70177_z);
/* 433 */       this.field_70177_z = (float)(this.field_70177_z + yaw / rpinc);
/* 434 */       this.field_70125_A = (float)(this.field_70125_A + (this.aircraftPitch - this.field_70125_A) / rpinc);
/* 435 */       func_70107_b(this.field_70165_t + (this.aircraftX - this.field_70165_t) / rpinc, this.field_70163_u + (this.aircraftY - this.field_70163_u) / rpinc, this.field_70161_v + (this.aircraftZ - this.field_70161_v) / rpinc);
/* 436 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/* 437 */       this.aircraftPosRotInc--;
/*     */     } else {
/* 439 */       func_70107_b(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 440 */       this.field_70181_x *= 0.96D;
/* 441 */       this.field_70159_w = 0.0D;
/* 442 */       this.field_70179_y = 0.0D;
/*     */     } 
/*     */     
/* 445 */     updateUavPosition();
/*     */   }
/*     */   
/*     */   private void onUpdate_Server() {
/* 449 */     this.field_70181_x -= 0.03D;
/* 450 */     func_70091_d(0.0D, this.field_70181_x, 0.0D);
/* 451 */     this.field_70181_x *= 0.96D;
/* 452 */     this.field_70159_w = 0.0D;
/* 453 */     this.field_70179_y = 0.0D;
/* 454 */     func_70101_b(this.field_70177_z, this.field_70125_A);
/* 455 */     if (this.field_70153_n != null) {
/* 456 */       if (this.field_70153_n.field_70128_L) {
/* 457 */         unmountEntity(true);
/* 458 */         this.field_70153_n = null;
/*     */       } else {
/* 460 */         ItemStack item = func_70301_a(0);
/* 461 */         if (item != null && item.field_77994_a > 0) {
/* 462 */           handleItem(this.field_70153_n, item);
/* 463 */           if (item.field_77994_a == 0) {
/* 464 */             func_70299_a(0, (ItemStack)null);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 470 */     if (getLastControlAircraft() == null && this.field_70173_aa % 40 == 0) {
/* 471 */       searchLastControlAircraft();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 477 */     this.aircraftPosRotInc = par9 + 8;
/* 478 */     this.aircraftX = par1;
/* 479 */     this.aircraftY = par3;
/* 480 */     this.aircraftZ = par5;
/* 481 */     this.aircraftYaw = par7;
/* 482 */     this.aircraftPitch = par8;
/* 483 */     this.field_70159_w = this.velocityX;
/* 484 */     this.field_70181_x = this.velocityY;
/* 485 */     this.field_70179_y = this.velocityZ;
/*     */   }
/*     */   
/*     */   public void func_70043_V() {
/* 489 */     if (this.field_70153_n != null) {
/* 490 */       double x = -Math.sin(this.field_70177_z * Math.PI / 180.0D) * 0.9D;
/* 491 */       double z = Math.cos(this.field_70177_z * Math.PI / 180.0D) * 0.9D;
/* 492 */       this.field_70153_n.func_70107_b(this.field_70165_t + x, this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + z);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void controlLastAircraft(Entity user) {
/* 498 */     if (getLastControlAircraft() != null && !(getLastControlAircraft()).field_70128_L) {
/* 499 */       getLastControlAircraft().setUavStation(this);
/* 500 */       setControlAircract(getLastControlAircraft());
/* 501 */       if (this.controlAircraft != null && 
/* 502 */         (this.controlAircraft.getAcInfo()).isNewUAV && 
/* 503 */         this.controlAircraft.field_70173_aa >= 10)
/*     */       {
/* 505 */         this.field_70153_n.func_70078_a((Entity)this.controlAircraft);
/*     */       }
/*     */ 
/*     */ 
/*     */       
/* 510 */       W_EntityPlayer.closeScreen(user);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void handleItem(Entity user, ItemStack itemStack) {
/* 516 */     if (user != null && !user.field_70128_L && itemStack != null && itemStack.field_77994_a == 1 && 
/* 517 */       !this.field_70170_p.field_72995_K) {
/* 518 */       Object ac = null;
/* 519 */       double x = this.field_70165_t + this.posUavX;
/* 520 */       double y = this.field_70163_u + this.posUavY;
/* 521 */       double z = this.field_70161_v + this.posUavZ;
/* 522 */       if (y <= 1.0D) {
/* 523 */         y = 2.0D;
/*     */       }
/*     */       
/* 526 */       Item item = itemStack.func_77973_b();
/* 527 */       if (item instanceof MCP_ItemPlane) {
/* 528 */         MCP_PlaneInfo hi = MCP_PlaneInfoManager.getFromItem(item);
/* 529 */         if (hi != null && (hi.isUAV || hi.isNewUAV)) {
/* 530 */           if (!hi.isSmallUAV && getKind() == 2) {
/* 531 */             ac = null;
/*     */           } else {
/* 533 */             ac = ((MCP_ItemPlane)item).createAircraft(this.field_70170_p, x, y, z, itemStack);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 538 */       if (item instanceof MCH_ItemHeli) {
/* 539 */         MCH_HeliInfo hi1 = MCH_HeliInfoManager.getFromItem(item);
/* 540 */         if (hi1 != null && hi1.isUAV) {
/* 541 */           if (!hi1.isSmallUAV && getKind() == 2) {
/* 542 */             ac = null;
/*     */           } else {
/* 544 */             ac = ((MCH_ItemHeli)item).createAircraft(this.field_70170_p, x, y, z, itemStack);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 549 */       if (item instanceof MCH_ItemTank) {
/* 550 */         MCH_TankInfo hi2 = MCH_TankInfoManager.getFromItem(item);
/* 551 */         if (hi2 != null && hi2.isUAV) {
/* 552 */           if (!hi2.isSmallUAV && getKind() == 2) {
/* 553 */             ac = null;
/*     */           } else {
/* 555 */             ac = ((MCH_ItemTank)item).createAircraft(this.field_70170_p, x, y, z, itemStack);
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 560 */       if (ac != null) {
/* 561 */         ((Entity)ac).field_70177_z = this.field_70177_z - 180.0F;
/* 562 */         ((Entity)ac).field_70126_B = ((Entity)ac).field_70177_z;
/* 563 */         user.field_70177_z = this.field_70177_z - 180.0F;
/* 564 */         if (this.field_70170_p.func_72945_a((Entity)ac, ((Entity)ac).field_70121_D.func_72314_b(-0.1D, -0.1D, -0.1D)).isEmpty()) {
/* 565 */           itemStack.field_77994_a--;
/* 566 */           MCH_Lib.DbgLog(this.field_70170_p, "Create UAV: %s : %s", new Object[] { item.func_77658_a(), item });
/* 567 */           user.field_70177_z = this.field_70177_z - 180.0F;
/* 568 */           if (!((MCH_EntityAircraft)ac).isTargetDrone()) {
/* 569 */             ((MCH_EntityAircraft)ac).setUavStation(this);
/* 570 */             setControlAircract((MCH_EntityAircraft)ac);
/*     */           } 
/*     */           
/* 573 */           this.field_70170_p.func_72838_d((Entity)ac);
/* 574 */           if (!((MCH_EntityAircraft)ac).isTargetDrone()) {
/* 575 */             ((MCH_EntityAircraft)ac).setFuel((int)(((MCH_EntityAircraft)ac).getMaxFuel() * 0.05F));
/* 576 */             W_EntityPlayer.closeScreen(user);
/*     */           } else {
/* 578 */             ((MCH_EntityAircraft)ac).setFuel(((MCH_EntityAircraft)ac).getMaxFuel());
/*     */           } 
/*     */         } else {
/* 581 */           ((MCH_EntityAircraft)ac).func_70106_y();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void _setInventorySlotContents(int par1, ItemStack itemStack) {
/* 590 */     func_70299_a(par1, itemStack);
/*     */   }
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer player) {
/* 594 */     int kind = getKind();
/* 595 */     if (kind <= 0)
/* 596 */       return false; 
/* 597 */     if (this.field_70153_n != null) {
/* 598 */       return false;
/*     */     }
/* 600 */     if (kind == 2) {
/* 601 */       if (player.func_70093_af()) {
/* 602 */         setOpen(!isOpen());
/* 603 */         return false;
/*     */       } 
/*     */       
/* 606 */       if (!isOpen()) {
/* 607 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 611 */     this.field_70153_n = null;
/* 612 */     this.lastRiddenByEntity = null;
/* 613 */     if (!this.field_70170_p.field_72995_K) {
/* 614 */       player.func_70078_a((Entity)this);
/* 615 */       player.openGui(MCH_MOD.instance, 0, player.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*     */     } 
/*     */     
/* 618 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70302_i_() {
/* 623 */     return 1;
/*     */   }
/*     */   
/*     */   public int func_70297_j_() {
/* 627 */     return 1;
/*     */   }
/*     */   
/*     */   public void unmountEntity(boolean unmountAllEntity) {
/* 631 */     Entity rByEntity = null;
/* 632 */     if (this.field_70153_n != null) {
/* 633 */       if (!this.field_70170_p.field_72995_K) {
/* 634 */         rByEntity = this.field_70153_n;
/* 635 */         this.field_70153_n.func_70078_a((Entity)null);
/*     */       } 
/* 637 */     } else if (this.lastRiddenByEntity != null) {
/* 638 */       rByEntity = this.lastRiddenByEntity;
/*     */     } 
/*     */     
/* 641 */     if (getControlAircract() != null) {
/* 642 */       getControlAircract().setUavStation((MCH_EntityUavStation)null);
/*     */     }
/*     */     
/* 645 */     setControlAircract((MCH_EntityAircraft)null);
/* 646 */     if (this.field_70170_p.field_72995_K) {
/* 647 */       W_EntityPlayer.closeScreen(rByEntity);
/*     */     }
/*     */     
/* 650 */     this.field_70153_n = null;
/* 651 */     this.lastRiddenByEntity = null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mchel\\uav\MCH_EntityUavStation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */