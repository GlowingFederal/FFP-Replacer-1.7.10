/*     */ package mcheli.helicopter;
/*     */ 
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_PacketStatusRequest;
/*     */ import mcheli.aircraft.MCH_Rotor;
/*     */ import mcheli.particles.MCH_ParticleParam;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_EntityHeli
/*     */   extends MCH_EntityAircraft
/*     */ {
/*     */   public static final byte FOLD_STAT_FOLDED = 0;
/*     */   public static final byte FOLD_STAT_FOLDING = 1;
/*     */   public static final byte FOLD_STAT_UNFOLDED = 2;
/*     */   public static final byte FOLD_STAT_UNFOLDING = 3;
/*  30 */   private MCH_HeliInfo heliInfo = null;
/*  31 */   public double prevRotationRotor = 0.0D;
/*  32 */   public double rotationRotor = 0.0D;
/*     */   public MCH_Rotor[] rotors;
/*     */   public byte lastFoldBladeStat;
/*     */   public int foldBladesCooldown;
/*  36 */   public float prevRollFactor = 0.0F;
/*     */ 
/*     */   
/*     */   public MCH_EntityHeli(World world) {
/*  40 */     super(world);
/*  41 */     this.currentSpeed = 0.07D;
/*  42 */     this.field_70156_m = true;
/*  43 */     func_70105_a(2.0F, 0.7F);
/*  44 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  45 */     this.field_70159_w = 0.0D;
/*  46 */     this.field_70181_x = 0.0D;
/*  47 */     this.field_70179_y = 0.0D;
/*  48 */     this.weapons = createWeapon(0);
/*  49 */     this.rotors = new MCH_Rotor[0];
/*  50 */     this.lastFoldBladeStat = -1;
/*  51 */     if (this.field_70170_p.field_72995_K) {
/*  52 */       this.foldBladesCooldown = 40;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String getKindName() {
/*  58 */     return "helicopters";
/*     */   }
/*     */   
/*     */   public String getEntityType() {
/*  62 */     return "Plane";
/*     */   }
/*     */   
/*     */   public MCH_HeliInfo getHeliInfo() {
/*  66 */     return this.heliInfo;
/*     */   }
/*     */   
/*     */   public void changeType(String type) {
/*  70 */     if (!type.isEmpty()) {
/*  71 */       this.heliInfo = MCH_HeliInfoManager.get(type);
/*     */     }
/*     */     
/*  74 */     if (this.heliInfo == null) {
/*  75 */       MCH_Lib.Log((Entity)this, "##### MCH_EntityHeli changeHeliType() Heli info null %d, %s, %s", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)this)), type, getEntityName() });
/*  76 */       setDead(true);
/*     */     } else {
/*  78 */       setAcInfo(this.heliInfo);
/*  79 */       newSeats(getAcInfo().getNumSeatAndRack());
/*  80 */       createRotors();
/*  81 */       this.weapons = createWeapon(1 + getSeatNum());
/*  82 */       initPartRotation(getRotYaw(), getRotPitch());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getItem() {
/*  88 */     return (getHeliInfo() != null) ? (Item)(getHeliInfo()).item : null;
/*     */   }
/*     */   
/*     */   public boolean canMountWithNearEmptyMinecart() {
/*  92 */     MCH_Config var10000 = MCH_MOD.config;
/*  93 */     return MCH_Config.MountMinecartHeli.prmBool;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  97 */     super.func_70088_a();
/*  98 */     this.field_70180_af.func_75682_a(30, Byte.valueOf((byte)2));
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 102 */     super.func_70014_b(par1NBTTagCompound);
/* 103 */     par1NBTTagCompound.func_74780_a("RotorSpeed", getCurrentThrottle());
/* 104 */     par1NBTTagCompound.func_74780_a("rotetionRotor", this.rotationRotor);
/* 105 */     par1NBTTagCompound.func_74757_a("FoldBlade", (getFoldBladeStat() == 0));
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 109 */     super.func_70037_a(par1NBTTagCompound);
/* 110 */     boolean beforeFoldBlade = (getFoldBladeStat() == 0);
/* 111 */     if (getCommonUniqueId().isEmpty()) {
/* 112 */       setCommonUniqueId(par1NBTTagCompound.func_74779_i("HeliUniqueId"));
/* 113 */       MCH_Lib.Log((Entity)this, "# MCH_EntityHeli readEntityFromNBT() " + W_Entity.getEntityId((Entity)this) + ", " + getEntityName() + ", AircraftUniqueId=null, HeliUniqueId=" + getCommonUniqueId(), new Object[0]);
/*     */     } 
/*     */     
/* 116 */     if (getTypeName().isEmpty()) {
/* 117 */       setTypeName(par1NBTTagCompound.func_74779_i("HeliType"));
/* 118 */       MCH_Lib.Log((Entity)this, "# MCH_EntityHeli readEntityFromNBT() " + W_Entity.getEntityId((Entity)this) + ", " + getEntityName() + ", TypeName=null, HeliType=" + getTypeName(), new Object[0]);
/*     */     } 
/*     */     
/* 121 */     setCurrentThrottle(par1NBTTagCompound.func_74769_h("RotorSpeed"));
/* 122 */     this.rotationRotor = par1NBTTagCompound.func_74769_h("rotetionRotor");
/* 123 */     setFoldBladeStat((byte)(par1NBTTagCompound.func_74767_n("FoldBlade") ? 0 : 2));
/* 124 */     if (this.heliInfo == null) {
/* 125 */       this.heliInfo = MCH_HeliInfoManager.get(getTypeName());
/* 126 */       if (this.heliInfo == null) {
/* 127 */         MCH_Lib.Log((Entity)this, "##### MCH_EntityHeli readEntityFromNBT() Heli info null %d, %s", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)this)), getEntityName() });
/* 128 */         setDead(true);
/*     */       } else {
/* 130 */         setAcInfo(this.heliInfo);
/*     */       } 
/*     */     } 
/*     */     
/* 134 */     if (!beforeFoldBlade && getFoldBladeStat() == 0) {
/* 135 */       forceFoldBlade();
/*     */     }
/*     */     
/* 138 */     this.prevRotationRotor = this.rotationRotor;
/*     */   }
/*     */   
/*     */   public float getSoundVolume() {
/* 142 */     return (getAcInfo() != null && (getAcInfo()).throttleUpDown <= 0.0F) ? 0.0F : ((float)getCurrentThrottle() * 2.0F);
/*     */   }
/*     */   
/*     */   public float getSoundPitch() {
/* 146 */     return (float)(0.2D + getCurrentThrottle() * 0.2D);
/*     */   }
/*     */   
/*     */   public String getDefaultSoundName() {
/* 150 */     return "heli";
/*     */   }
/*     */   
/*     */   public float getUnfoldLandingGearThrottle() {
/* 154 */     double x = this.field_70165_t - this.field_70169_q;
/* 155 */     double y = this.field_70163_u - this.field_70167_r;
/* 156 */     double z = this.field_70161_v - this.field_70166_s;
/* 157 */     float s = (getAcInfo()).speed / 3.5F;
/* 158 */     return (x * x + y * y + z * z <= s) ? 0.8F : 0.3F;
/*     */   }
/*     */   
/*     */   protected void createRotors() {
/* 162 */     if (this.heliInfo != null) {
/* 163 */       this.rotors = new MCH_Rotor[this.heliInfo.rotorList.size()];
/* 164 */       int i = 0;
/*     */       
/* 166 */       for (MCH_HeliInfo.Rotor r : this.heliInfo.rotorList) {
/*     */         
/* 168 */         this.rotors[i] = new MCH_Rotor(r.bladeNum, r.bladeRot, this.field_70170_p.field_72995_K ? 2 : 2, (float)r.pos.field_72450_a, (float)r.pos.field_72448_b, (float)r.pos.field_72449_c, (float)r.rot.field_72450_a, (float)r.rot.field_72448_b, (float)r.rot.field_72449_c, r.haveFoldFunc);
/*     */         i++;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void forceFoldBlade() {
/* 175 */     if (this.heliInfo != null && this.rotors.length > 0 && this.heliInfo.isEnableFoldBlade) {
/* 176 */       MCH_Rotor[] arr$ = this.rotors;
/* 177 */       int len$ = arr$.length;
/*     */       
/* 179 */       for (int i$ = 0; i$ < len$; i$++) {
/* 180 */         MCH_Rotor r = arr$[i$];
/* 181 */         r.update((float)this.rotationRotor);
/* 182 */         foldBlades();
/* 183 */         r.forceFold();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isFoldBlades() {
/* 190 */     return (this.heliInfo != null && this.rotors.length > 0) ? ((getFoldBladeStat() == 0)) : false;
/*     */   }
/*     */   
/*     */   protected boolean canSwitchFoldBlades() {
/* 194 */     return (this.heliInfo != null && this.rotors.length > 0) ? ((this.heliInfo.isEnableFoldBlade && getCurrentThrottle() <= 0.01D && this.foldBladesCooldown == 0 && (getFoldBladeStat() == 2 || getFoldBladeStat() == 0))) : false;
/*     */   }
/*     */   
/*     */   protected boolean canUseBlades() {
/* 198 */     if (this.heliInfo == null)
/* 199 */       return false; 
/* 200 */     if (this.rotors.length <= 0)
/* 201 */       return true; 
/* 202 */     if (getFoldBladeStat() == 2) {
/* 203 */       MCH_Rotor[] arr$ = this.rotors;
/* 204 */       int len$ = arr$.length;
/*     */       
/* 206 */       for (int i$ = 0; i$ < len$; i$++) {
/* 207 */         MCH_Rotor r = arr$[i$];
/* 208 */         if (r.isFoldingOrUnfolding()) {
/* 209 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 213 */       return true;
/*     */     } 
/* 215 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void foldBlades() {
/* 220 */     if (this.heliInfo != null && this.rotors.length > 0) {
/* 221 */       setCurrentThrottle(0.0D);
/* 222 */       MCH_Rotor[] arr$ = this.rotors;
/* 223 */       int len$ = arr$.length;
/*     */       
/* 225 */       for (int i$ = 0; i$ < len$; i$++) {
/* 226 */         MCH_Rotor r = arr$[i$];
/* 227 */         r.startFold();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void unfoldBlades() {
/* 234 */     if (this.heliInfo != null && this.rotors.length > 0) {
/* 235 */       MCH_Rotor[] arr$ = this.rotors;
/* 236 */       int len$ = arr$.length;
/*     */       
/* 238 */       for (int i$ = 0; i$ < len$; i$++) {
/* 239 */         MCH_Rotor r = arr$[i$];
/* 240 */         r.startUnfold();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onRideEntity(Entity ridingEntity) {
/* 247 */     if (ridingEntity instanceof mcheli.aircraft.MCH_EntitySeat) {
/* 248 */       if (this.heliInfo == null || this.rotors.length <= 0) {
/*     */         return;
/*     */       }
/*     */       
/* 252 */       if (this.heliInfo.isEnableFoldBlade) {
/* 253 */         forceFoldBlade();
/* 254 */         setFoldBladeStat((byte)0);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected byte getFoldBladeStat() {
/* 261 */     return this.field_70180_af.func_75683_a(30);
/*     */   }
/*     */   
/*     */   public void setFoldBladeStat(byte b) {
/* 265 */     if (!this.field_70170_p.field_72995_K && b >= 0 && b <= 3) {
/* 266 */       this.field_70180_af.func_75692_b(30, Byte.valueOf(b));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canSwitchGunnerMode() {
/* 272 */     if (super.canSwitchGunnerMode() && canUseBlades()) {
/* 273 */       float roll = MathHelper.func_76135_e(MathHelper.func_76142_g(getRotRoll()));
/* 274 */       float pitch = MathHelper.func_76135_e(MathHelper.func_76142_g(getRotPitch()));
/* 275 */       if (roll < 40.0F && pitch < 40.0F) {
/* 276 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 280 */     return false;
/*     */   }
/*     */   
/*     */   public boolean canSwitchHoveringMode() {
/* 284 */     if (super.canSwitchHoveringMode() && canUseBlades()) {
/* 285 */       float roll = MathHelper.func_76135_e(MathHelper.func_76142_g(getRotRoll()));
/* 286 */       float pitch = MathHelper.func_76135_e(MathHelper.func_76142_g(getRotPitch()));
/* 287 */       if (roll < 40.0F && pitch < 40.0F) {
/* 288 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 292 */     return false;
/*     */   }
/*     */   
/*     */   public void onUpdateAircraft() {
/* 296 */     if (this.heliInfo == null) {
/* 297 */       changeType(getTypeName());
/* 298 */       this.field_70169_q = this.field_70165_t;
/* 299 */       this.field_70167_r = this.field_70163_u;
/* 300 */       this.field_70166_s = this.field_70161_v;
/*     */     } else {
/* 302 */       if (!this.isRequestedSyncStatus) {
/* 303 */         this.isRequestedSyncStatus = true;
/* 304 */         if (this.field_70170_p.field_72995_K) {
/* 305 */           byte stat = getFoldBladeStat();
/* 306 */           if (stat == 1 || stat == 0) {
/* 307 */             forceFoldBlade();
/*     */           }
/*     */           
/* 310 */           MCH_PacketStatusRequest.requestStatus(this);
/*     */         } 
/*     */       } 
/*     */       
/* 314 */       if (this.lastRiddenByEntity == null && getRiddenByEntity() != null) {
/* 315 */         initCurrentWeapon(getRiddenByEntity());
/*     */       }
/*     */       
/* 318 */       updateWeapons();
/* 319 */       onUpdate_Seats();
/* 320 */       onUpdate_Control();
/* 321 */       onUpdate_Rotor();
/* 322 */       this.field_70169_q = this.field_70165_t;
/* 323 */       this.field_70167_r = this.field_70163_u;
/* 324 */       this.field_70166_s = this.field_70161_v;
/* 325 */       if (!isDestroyed() && isHovering() && MathHelper.func_76135_e(getRotPitch()) < 70.0F) {
/* 326 */         setRotPitch(getRotPitch() * 0.95F);
/*     */       }
/*     */       
/* 329 */       if (isDestroyed() && getCurrentThrottle() > 0.0D) {
/* 330 */         if (MCH_Lib.getBlockIdY((Entity)this, 3, -2) > 0) {
/* 331 */           setCurrentThrottle(getCurrentThrottle() * 0.8D);
/*     */         }
/*     */         
/* 334 */         if (isExploded()) {
/* 335 */           setCurrentThrottle(getCurrentThrottle() * 0.98D);
/*     */         }
/*     */       } 
/*     */       
/* 339 */       updateCameraViewers();
/* 340 */       if (this.field_70170_p.field_72995_K) {
/* 341 */         onUpdate_Client();
/*     */       } else {
/* 343 */         onUpdate_Server();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canMouseRot() {
/* 350 */     return super.canMouseRot();
/*     */   }
/*     */   
/*     */   public boolean canUpdatePitch(Entity player) {
/* 354 */     return (super.canUpdatePitch(player) && !isHovering());
/*     */   }
/*     */   
/*     */   public boolean canUpdateRoll(Entity player) {
/* 358 */     return (super.canUpdateRoll(player) && !isHovering());
/*     */   }
/*     */   
/*     */   public boolean isOverridePlayerPitch() {
/* 362 */     return (super.isOverridePlayerPitch() && !isHovering());
/*     */   }
/*     */   
/*     */   public float getRollFactor() {
/* 366 */     float roll = super.getRollFactor();
/* 367 */     double d = func_70092_e(this.field_70169_q, this.field_70163_u, this.field_70166_s);
/* 368 */     double s = (getAcInfo()).speed;
/*     */     
/* 370 */     if (s > 0.1D) {
/* 371 */       double var10000 = d / s;
/*     */     } else {
/* 373 */       double var10000 = 0.0D;
/*     */     } 
/*     */     
/* 376 */     float f = this.prevRollFactor;
/* 377 */     this.prevRollFactor = roll;
/* 378 */     return (roll + f) / 2.0F;
/*     */   }
/*     */   
/*     */   public float getControlRotYaw(float mouseX, float mouseY, float tick) {
/* 382 */     return mouseX;
/*     */   }
/*     */   
/*     */   public float getControlRotPitch(float mouseX, float mouseY, float tick) {
/* 386 */     return mouseY;
/*     */   }
/*     */   
/*     */   public float getControlRotRoll(float mouseX, float mouseY, float tick) {
/* 390 */     return mouseX;
/*     */   }
/*     */   
/*     */   public void onUpdateAngles(float partialTicks) {
/* 394 */     if (!isDestroyed()) {
/* 395 */       float rotRoll = !isHovering() ? 0.04F : 0.07F;
/* 396 */       rotRoll = 1.0F - rotRoll * partialTicks;
/* 397 */       if (getRotRoll() > 0.1D && getRotRoll() < 65.0F) {
/* 398 */         setRotRoll(getRotRoll() * rotRoll);
/*     */       }
/*     */       
/* 401 */       if (getRotRoll() < -0.1D && getRotRoll() > -65.0F) {
/* 402 */         setRotRoll(getRotRoll() * rotRoll);
/*     */       }
/*     */       
/* 405 */       if (MCH_Lib.getBlockIdY((Entity)this, 3, -3) == 0) {
/*     */ 
/*     */ 
/*     */         
/* 409 */         if (this.moveLeft && !this.moveRight) {
/* 410 */           setRotRoll(getRotRoll() - 1.2F * partialTicks);
/*     */         }
/*     */         
/* 413 */         if (this.moveRight && !this.moveLeft) {
/* 414 */           setRotRoll(getRotRoll() + 1.2F * partialTicks);
/*     */         }
/*     */       } else {
/*     */         
/* 418 */         if (MathHelper.func_76135_e(getRotPitch()) < 40.0F) {
/* 419 */           applyOnGroundPitch(0.97F);
/*     */         }
/*     */         
/* 422 */         if (this.heliInfo.isEnableFoldBlade && this.rotors.length > 0 && getFoldBladeStat() == 0 && !isDestroyed()) {
/* 423 */           if (this.moveLeft && !this.moveRight) {
/* 424 */             setRotYaw(getRotYaw() - 0.5F * partialTicks);
/*     */           }
/*     */           
/* 427 */           if (this.moveRight && !this.moveLeft) {
/* 428 */             setRotYaw(getRotYaw() + 0.5F * partialTicks);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdate_Rotor() {
/* 437 */     byte stat = getFoldBladeStat();
/* 438 */     boolean isEndSwitch = true;
/* 439 */     if (stat != this.lastFoldBladeStat) {
/* 440 */       if (stat == 1) {
/* 441 */         foldBlades();
/* 442 */       } else if (stat == 3) {
/* 443 */         unfoldBlades();
/*     */       } 
/*     */       
/* 446 */       if (this.field_70170_p.field_72995_K) {
/* 447 */         this.foldBladesCooldown = 40;
/*     */       }
/*     */       
/* 450 */       this.lastFoldBladeStat = stat;
/* 451 */     } else if (this.foldBladesCooldown > 0) {
/* 452 */       this.foldBladesCooldown--;
/*     */     } 
/*     */     
/* 455 */     MCH_Rotor[] arr$ = this.rotors;
/* 456 */     int len$ = arr$.length;
/*     */     
/* 458 */     for (int i$ = 0; i$ < len$; i$++) {
/* 459 */       MCH_Rotor r = arr$[i$];
/* 460 */       r.update((float)this.rotationRotor);
/* 461 */       if (r.isFoldingOrUnfolding()) {
/* 462 */         isEndSwitch = false;
/*     */       }
/*     */     } 
/*     */     
/* 466 */     if (isEndSwitch) {
/* 467 */       if (stat == 1) {
/* 468 */         setFoldBladeStat((byte)0);
/* 469 */       } else if (stat == 3) {
/* 470 */         setFoldBladeStat((byte)2);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdate_Control() {
/* 477 */     if (isHoveringMode() && !canUseFuel(true)) {
/* 478 */       switchHoveringMode(false);
/*     */     }
/*     */     
/* 481 */     if (this.isGunnerMode && !canUseFuel()) {
/* 482 */       switchGunnerMode(false);
/*     */     }
/*     */     
/* 485 */     if (!isDestroyed() && (getRiddenByEntity() != null || isHoveringMode()) && canUseBlades() && isCanopyClose() && canUseFuel(true)) {
/* 486 */       if (!isHovering()) {
/* 487 */         onUpdate_ControlNotHovering();
/*     */       } else {
/* 489 */         onUpdate_ControlHovering();
/*     */       } 
/*     */     } else {
/* 492 */       if (getCurrentThrottle() > 0.0D) {
/* 493 */         addCurrentThrottle(-0.00125D);
/*     */       } else {
/* 495 */         setCurrentThrottle(0.0D);
/*     */       } 
/*     */       
/* 498 */       if (this.heliInfo.isEnableFoldBlade && this.rotors.length > 0 && getFoldBladeStat() == 0 && this.field_70122_E && !isDestroyed()) {
/* 499 */         onUpdate_ControlFoldBladeAndOnGround();
/*     */       }
/*     */     } 
/*     */     
/* 503 */     if (this.field_70170_p.field_72995_K) {
/* 504 */       if (!W_Lib.isClientPlayer(getRiddenByEntity())) {
/* 505 */         double rp = getThrottle();
/* 506 */         if (getCurrentThrottle() >= rp - 0.02D) {
/* 507 */           addCurrentThrottle(-0.01D);
/* 508 */         } else if (getCurrentThrottle() < rp) {
/* 509 */           addCurrentThrottle(0.01D);
/*     */         } 
/*     */       } 
/*     */     } else {
/* 513 */       setThrottle(getCurrentThrottle());
/*     */     } 
/*     */     
/* 516 */     if (getCurrentThrottle() < 0.0D) {
/* 517 */       setCurrentThrottle(0.0D);
/*     */     }
/*     */     
/* 520 */     this.prevRotationRotor = this.rotationRotor;
/* 521 */     float rp1 = (float)(1.0D - getCurrentThrottle());
/* 522 */     this.rotationRotor += ((1.0F - rp1 * rp1 * rp1) * (getAcInfo()).rotorSpeed);
/* 523 */     this.rotationRotor %= 360.0D;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onUpdate_ControlNotHovering() {
/* 530 */     float throttleUpDown = (getAcInfo()).throttleUpDown;
/* 531 */     if (this.throttleUp) {
/* 532 */       if (getCurrentThrottle() < 1.0D) {
/* 533 */         addCurrentThrottle(0.02D * throttleUpDown);
/*     */       } else {
/* 535 */         setCurrentThrottle(1.0D);
/*     */       } 
/* 537 */     } else if (this.throttleDown) {
/* 538 */       if (getCurrentThrottle() > 0.0D) {
/* 539 */         addCurrentThrottle(-0.014285714285714285D * throttleUpDown);
/*     */       } else {
/* 541 */         setCurrentThrottle(0.0D);
/*     */       } 
/* 543 */     } else if ((!this.field_70170_p.field_72995_K || W_Lib.isClientPlayer(getRiddenByEntity())) && this.cs_heliAutoThrottleDown) {
/* 544 */       if (getCurrentThrottle() > 0.52D) {
/* 545 */         addCurrentThrottle(-0.01D * throttleUpDown);
/* 546 */       } else if (getCurrentThrottle() < 0.48D) {
/* 547 */         addCurrentThrottle(0.01D * throttleUpDown);
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 552 */     if (!this.field_70170_p.field_72995_K) {
/* 553 */       boolean move = false;
/* 554 */       float yaw = getRotYaw();
/* 555 */       double x = 0.0D;
/* 556 */       double z = 0.0D;
/* 557 */       if (this.moveLeft && !this.moveRight) {
/* 558 */         yaw = getRotYaw() - 90.0F;
/* 559 */         x += Math.sin(yaw * Math.PI / 180.0D);
/* 560 */         z += Math.cos(yaw * Math.PI / 180.0D);
/* 561 */         move = true;
/*     */       } 
/*     */       
/* 564 */       if (this.moveRight && !this.moveLeft) {
/* 565 */         yaw = getRotYaw() + 90.0F;
/* 566 */         x += Math.sin(yaw * Math.PI / 180.0D);
/* 567 */         z += Math.cos(yaw * Math.PI / 180.0D);
/* 568 */         move = true;
/*     */       } 
/*     */       
/* 571 */       if (move) {
/* 572 */         double f = 1.0D;
/* 573 */         double d = Math.sqrt(x * x + z * z);
/* 574 */         this.field_70159_w -= x / d * 0.019999999552965164D * f * (getAcInfo()).speed;
/* 575 */         this.field_70179_y += z / d * 0.019999999552965164D * f * (getAcInfo()).speed;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdate_ControlHovering() {
/* 582 */     if (getCurrentThrottle() < 1.0D) {
/* 583 */       addCurrentThrottle(0.03333333333333333D);
/*     */     } else {
/* 585 */       setCurrentThrottle(1.0D);
/*     */     } 
/*     */     
/* 588 */     if (!this.field_70170_p.field_72995_K) {
/* 589 */       boolean move = false;
/* 590 */       float yaw = getRotYaw();
/* 591 */       double x = 0.0D;
/* 592 */       double z = 0.0D;
/* 593 */       if (this.throttleUp) {
/* 594 */         yaw = getRotYaw();
/* 595 */         x += Math.sin(yaw * Math.PI / 180.0D);
/* 596 */         z += Math.cos(yaw * Math.PI / 180.0D);
/* 597 */         move = true;
/*     */       } 
/*     */       
/* 600 */       if (this.throttleDown) {
/* 601 */         yaw = getRotYaw() - 180.0F;
/* 602 */         x += Math.sin(yaw * Math.PI / 180.0D);
/* 603 */         z += Math.cos(yaw * Math.PI / 180.0D);
/* 604 */         move = true;
/*     */       } 
/*     */       
/* 607 */       if (this.moveLeft && !this.moveRight) {
/* 608 */         yaw = getRotYaw() - 90.0F;
/* 609 */         x += Math.sin(yaw * Math.PI / 180.0D);
/* 610 */         z += Math.cos(yaw * Math.PI / 180.0D);
/* 611 */         move = true;
/*     */       } 
/*     */       
/* 614 */       if (this.moveRight && !this.moveLeft) {
/* 615 */         yaw = getRotYaw() + 90.0F;
/* 616 */         x += Math.sin(yaw * Math.PI / 180.0D);
/* 617 */         z += Math.cos(yaw * Math.PI / 180.0D);
/* 618 */         move = true;
/*     */       } 
/*     */       
/* 621 */       if (move) {
/* 622 */         double d = Math.sqrt(x * x + z * z);
/* 623 */         this.field_70159_w -= x / d * 0.009999999776482582D * (getAcInfo()).speed;
/* 624 */         this.field_70179_y += z / d * 0.009999999776482582D * (getAcInfo()).speed;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdate_ControlFoldBladeAndOnGround() {
/* 631 */     if (!this.field_70170_p.field_72995_K) {
/* 632 */       boolean move = false;
/* 633 */       float yaw = getRotYaw();
/* 634 */       double x = 0.0D;
/* 635 */       double z = 0.0D;
/* 636 */       if (this.throttleUp) {
/* 637 */         yaw = getRotYaw();
/* 638 */         x += Math.sin(yaw * Math.PI / 180.0D);
/* 639 */         z += Math.cos(yaw * Math.PI / 180.0D);
/* 640 */         move = true;
/*     */       } 
/*     */       
/* 643 */       if (this.throttleDown) {
/* 644 */         yaw = getRotYaw() - 180.0F;
/* 645 */         x += Math.sin(yaw * Math.PI / 180.0D);
/* 646 */         z += Math.cos(yaw * Math.PI / 180.0D);
/* 647 */         move = true;
/*     */       } 
/*     */       
/* 650 */       if (move) {
/* 651 */         double d = Math.sqrt(x * x + z * z);
/* 652 */         this.field_70159_w -= x / d * 0.029999999329447746D;
/* 653 */         this.field_70179_y += z / d * 0.029999999329447746D;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdate_Particle2() {
/* 660 */     if (this.field_70170_p.field_72995_K && 
/* 661 */       getHP() <= getMaxHP() * 0.5D && 
/* 662 */       getHeliInfo() != null) {
/* 663 */       int rotorNum = (getHeliInfo()).rotorList.size();
/* 664 */       if (rotorNum > 0) {
/* 665 */         if (this.isFirstDamageSmoke) {
/* 666 */           this.prevDamageSmokePos = new Vec3[rotorNum];
/*     */         }
/*     */         
/* 669 */         for (int ri = 0; ri < rotorNum; ri++) {
/* 670 */           Vec3 rotor_pos = ((MCH_HeliInfo.Rotor)(getHeliInfo()).rotorList.get(ri)).pos;
/* 671 */           float yaw = getRotYaw();
/* 672 */           float pitch = getRotPitch();
/* 673 */           Vec3 pos = MCH_Lib.RotVec3(rotor_pos, -yaw, -pitch, -getRotRoll());
/* 674 */           double x = this.field_70165_t + pos.field_72450_a;
/* 675 */           double y = this.field_70163_u + pos.field_72448_b;
/* 676 */           double z = this.field_70161_v + pos.field_72449_c;
/* 677 */           if (this.isFirstDamageSmoke) {
/* 678 */             this.prevDamageSmokePos[ri] = Vec3.func_72443_a(x, y, z);
/*     */           }
/*     */           
/* 681 */           Vec3 prev = this.prevDamageSmokePos[ri];
/* 682 */           double dx = x - prev.field_72450_a;
/* 683 */           double dy = y - prev.field_72448_b;
/* 684 */           double dz = z - prev.field_72449_c;
/* 685 */           int num = (int)(MathHelper.func_76133_a(dx * dx + dy * dy + dz * dz) * 2.0F) + 1;
/*     */           double i;
/* 687 */           for (i = 0.0D; i < num; i++) {
/* 688 */             double p = getHP() / getMaxHP();
/* 689 */             if (p < (this.field_70146_Z.nextFloat() / 2.0F)) {
/* 690 */               float c = 0.2F + this.field_70146_Z.nextFloat() * 0.3F;
/* 691 */               MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", prev.field_72450_a + (x - prev.field_72450_a) * i / num, prev.field_72448_b + (y - prev.field_72448_b) * i / num, prev.field_72449_c + (z - prev.field_72449_c) * i / num);
/* 692 */               prm.motionX = (this.field_70146_Z.nextDouble() - 0.5D) * 0.3D;
/* 693 */               prm.motionY = this.field_70146_Z.nextDouble() * 0.1D;
/* 694 */               prm.motionZ = (this.field_70146_Z.nextDouble() - 0.5D) * 0.3D;
/* 695 */               prm.size = (this.field_70146_Z.nextInt(5) + 5.0F) * 1.0F;
/* 696 */               prm.setColor(0.7F + this.field_70146_Z.nextFloat() * 0.1F, c, c, c);
/* 697 */               MCH_ParticlesUtil.spawnParticle(prm);
/* 698 */               int ebi = this.field_70146_Z.nextInt(1 + this.extraBoundingBox.length);
/* 699 */               if (p < 0.3D && ebi > 0) {
/* 700 */                 AxisAlignedBB bb = (this.extraBoundingBox[ebi - 1]).boundingBox;
/* 701 */                 double bx = (bb.field_72336_d + bb.field_72340_a) / 2.0D;
/* 702 */                 double by = (bb.field_72337_e + bb.field_72338_b) / 2.0D;
/* 703 */                 double bz = (bb.field_72334_f + bb.field_72339_c) / 2.0D;
/* 704 */                 prm.posX = bx;
/* 705 */                 prm.posY = by;
/* 706 */                 prm.posZ = bz;
/* 707 */                 MCH_ParticlesUtil.spawnParticle(prm);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 712 */           (this.prevDamageSmokePos[ri]).field_72450_a = x;
/* 713 */           (this.prevDamageSmokePos[ri]).field_72448_b = y;
/* 714 */           (this.prevDamageSmokePos[ri]).field_72449_c = z;
/*     */         } 
/*     */         
/* 717 */         this.isFirstDamageSmoke = false;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onUpdate_Client() {
/* 725 */     if (getRiddenByEntity() != null && W_Lib.isClientPlayer(getRiddenByEntity())) {
/* 726 */       (getRiddenByEntity()).field_70125_A = (getRiddenByEntity()).field_70127_C;
/*     */     }
/*     */     
/* 729 */     if (this.aircraftPosRotInc > 0) {
/* 730 */       applyServerPositionAndRotation();
/*     */     } else {
/* 732 */       func_70107_b(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 733 */       if (!isDestroyed() && (this.field_70122_E || MCH_Lib.getBlockIdY((Entity)this, 1, -2) > 0)) {
/* 734 */         this.field_70159_w *= 0.95D;
/* 735 */         this.field_70179_y *= 0.95D;
/* 736 */         applyOnGroundPitch(0.95F);
/*     */       } 
/*     */       
/* 739 */       if (func_70090_H()) {
/* 740 */         this.field_70159_w *= 0.99D;
/* 741 */         this.field_70179_y *= 0.99D;
/*     */       } 
/*     */     } 
/*     */     
/* 745 */     if (isDestroyed()) {
/* 746 */       if (this.rotDestroyedYaw < 15.0F) {
/* 747 */         this.rotDestroyedYaw += 0.3F;
/*     */       }
/*     */       
/* 750 */       setRotYaw(getRotYaw() + this.rotDestroyedYaw * (float)getCurrentThrottle());
/* 751 */       if (MCH_Lib.getBlockIdY((Entity)this, 3, -3) == 0) {
/* 752 */         if (MathHelper.func_76135_e(getRotPitch()) < 10.0F) {
/* 753 */           setRotPitch(getRotPitch() + this.rotDestroyedPitch);
/*     */         }
/*     */         
/* 756 */         setRotRoll(getRotRoll() + this.rotDestroyedRoll);
/*     */       } 
/*     */     } 
/*     */     
/* 760 */     if (getRiddenByEntity() != null);
/*     */ 
/*     */ 
/*     */     
/* 764 */     onUpdate_ParticleSandCloud(false);
/* 765 */     onUpdate_Particle2();
/* 766 */     updateCamera(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */   }
/*     */   
/*     */   private void onUpdate_Server() {
/* 770 */     double prevMotion = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 771 */     float ogp = (getAcInfo()).onGroundPitch;
/*     */ 
/*     */ 
/*     */     
/* 775 */     if (!isHovering()) {
/* 776 */       double d = 0.0D;
/* 777 */       if (canFloatWater()) {
/* 778 */         d = getWaterDepth();
/*     */       }
/*     */       
/* 781 */       if (d == 0.0D) {
/* 782 */         this.field_70181_x += !func_70090_H() ? (getAcInfo()).gravity : (getAcInfo()).gravityInWater;
/* 783 */         float f1 = getRotYaw() / 180.0F * 3.1415927F;
/* 784 */         float pitch = getRotPitch();
/* 785 */         if (MCH_Lib.getBlockIdY((Entity)this, 3, -3) > 0) {
/* 786 */           pitch -= ogp;
/*     */         }
/*     */         
/* 789 */         this.field_70159_w += 0.1D * MathHelper.func_76126_a(f1) * this.currentSpeed * -(pitch * pitch * pitch / 30000.0F) * getCurrentThrottle();
/* 790 */         this.field_70179_y += 0.1D * MathHelper.func_76134_b(f1) * this.currentSpeed * (pitch * pitch * pitch / 30000.0F) * getCurrentThrottle();
/* 791 */         double y = (MathHelper.func_76135_e(getRotPitch()) + MathHelper.func_76135_e(getRotRoll()));
/* 792 */         y *= 0.6000000238418579D;
/* 793 */         if (y <= 50.0D) {
/* 794 */           y = 1.0D - y / 50.0D;
/*     */         } else {
/* 796 */           y = 0.0D;
/*     */         } 
/*     */         
/* 799 */         double throttle = getCurrentThrottle();
/* 800 */         if (isDestroyed()) {
/* 801 */           throttle *= 0.65D;
/*     */         }
/*     */         
/* 804 */         this.field_70181_x += (y * 0.025D + 0.03D) * throttle;
/*     */       } else {
/* 806 */         if (MathHelper.func_76135_e(getRotPitch()) < 40.0F) {
/* 807 */           float f = getRotPitch();
/* 808 */           f -= ogp;
/* 809 */           f *= 0.9F;
/* 810 */           f += ogp;
/* 811 */           setRotPitch(f);
/*     */         } 
/*     */         
/* 814 */         if (MathHelper.func_76135_e(getRotRoll()) < 40.0F) {
/* 815 */           setRotRoll(getRotRoll() * 0.9F);
/*     */         }
/*     */         
/* 818 */         if (d < 1.0D) {
/* 819 */           this.field_70181_x -= 1.0E-4D;
/* 820 */           this.field_70181_x += 0.007D * getCurrentThrottle();
/*     */         } else {
/* 822 */           if (this.field_70181_x < 0.0D) {
/* 823 */             this.field_70181_x *= 0.7D;
/*     */           }
/*     */           
/* 826 */           this.field_70181_x += 0.007D;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 830 */       if (this.field_70146_Z.nextInt(50) == 0) {
/* 831 */         this.field_70159_w += (this.field_70146_Z.nextDouble() - 0.5D) / 30.0D;
/*     */       }
/*     */       
/* 834 */       if (this.field_70146_Z.nextInt(50) == 0) {
/* 835 */         this.field_70181_x += (this.field_70146_Z.nextDouble() - 0.5D) / 50.0D;
/*     */       }
/*     */       
/* 838 */       if (this.field_70146_Z.nextInt(50) == 0) {
/* 839 */         this.field_70179_y += (this.field_70146_Z.nextDouble() - 0.5D) / 30.0D;
/*     */       }
/*     */     } 
/*     */     
/* 843 */     double motion = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 844 */     float speedLimit = (getAcInfo()).speed;
/* 845 */     if (motion > speedLimit) {
/* 846 */       this.field_70159_w *= speedLimit / motion;
/* 847 */       this.field_70179_y *= speedLimit / motion;
/* 848 */       motion = speedLimit;
/*     */     } 
/*     */     
/* 851 */     if (motion > prevMotion && this.currentSpeed < speedLimit) {
/* 852 */       this.currentSpeed += (speedLimit - this.currentSpeed) / 35.0D;
/* 853 */       if (this.currentSpeed > speedLimit) {
/* 854 */         this.currentSpeed = speedLimit;
/*     */       }
/*     */     } else {
/* 857 */       this.currentSpeed -= (this.currentSpeed - 0.07D) / 35.0D;
/* 858 */       if (this.currentSpeed < 0.07D) {
/* 859 */         this.currentSpeed = 0.07D;
/*     */       }
/*     */     } 
/*     */     
/* 863 */     if (this.field_70122_E) {
/* 864 */       this.field_70159_w *= 0.5D;
/* 865 */       this.field_70179_y *= 0.5D;
/* 866 */       if (MathHelper.func_76135_e(getRotPitch()) < 40.0F) {
/* 867 */         float pitch = getRotPitch();
/* 868 */         pitch -= ogp;
/* 869 */         pitch *= 0.9F;
/* 870 */         pitch += ogp;
/* 871 */         setRotPitch(pitch);
/*     */       } 
/*     */       
/* 874 */       if (MathHelper.func_76135_e(getRotRoll()) < 40.0F) {
/* 875 */         setRotRoll(getRotRoll() * 0.9F);
/*     */       }
/*     */     } 
/*     */     
/* 879 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 880 */     this.field_70181_x *= 0.95D;
/* 881 */     this.field_70159_w *= 0.99D;
/* 882 */     this.field_70179_y *= 0.99D;
/* 883 */     func_70101_b(getRotYaw(), getRotPitch());
/* 884 */     onUpdate_updateBlock();
/* 885 */     if (getRiddenByEntity() != null && (getRiddenByEntity()).field_70128_L) {
/* 886 */       unmountEntity();
/* 887 */       this.field_70153_n = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\helicopter\MCH_EntityHeli.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */