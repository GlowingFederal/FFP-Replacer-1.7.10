/*     */ package mcheli.weapon;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_WeaponSet
/*     */ {
/*  14 */   private static Random rand = new Random();
/*     */   
/*     */   private final String name;
/*     */   protected MCH_WeaponBase[] weapons;
/*     */   private int currentWeaponIndex;
/*     */   public float rotationYaw;
/*     */   public float rotationPitch;
/*     */   public float prevRotationYaw;
/*     */   public float prevRotationPitch;
/*     */   public float defaultRotationYaw;
/*     */   public float rotationTurretYaw;
/*     */   public float rotBay;
/*     */   public float prevRotBay;
/*     */   public Recoil[] recoilBuf;
/*     */   protected int numAmmo;
/*     */   protected int numRestAllAmmo;
/*     */   public int currentHeat;
/*     */   public int cooldownSpeed;
/*     */   public int countWait;
/*     */   public int countReloadWait;
/*     */   protected int[] lastUsedCount;
/*     */   private static final int WAIT_CLEAR_USED_COUNT = 4;
/*     */   public int soundWait;
/*     */   private int lastUsedOptionParameter1;
/*     */   private int lastUsedOptionParameter2;
/*     */   public float rotBarrelSpd;
/*     */   public float rotBarrel;
/*     */   public float prevRotBarrel;
/*     */   public Vec3 targetPoint;
/*     */   
/*     */   public MCH_WeaponSet(MCH_WeaponBase[] weapon) {
/*  45 */     this.lastUsedOptionParameter1 = 0;
/*  46 */     this.lastUsedOptionParameter2 = 0;
/*  47 */     this.name = (weapon[0]).name;
/*  48 */     this.weapons = weapon;
/*  49 */     this.currentWeaponIndex = 0;
/*  50 */     this.countWait = 0;
/*  51 */     this.countReloadWait = 0;
/*  52 */     this.lastUsedCount = new int[weapon.length];
/*  53 */     this.rotationYaw = 0.0F;
/*  54 */     this.prevRotationYaw = 0.0F;
/*  55 */     this.rotationPitch = 0.0F;
/*  56 */     this.prevRotationPitch = 0.0F;
/*  57 */     setAmmoNum(0);
/*  58 */     setRestAllAmmoNum(0);
/*  59 */     this.currentHeat = 0;
/*  60 */     this.soundWait = 0;
/*  61 */     this.cooldownSpeed = 1;
/*  62 */     this.rotBarrelSpd = 0.0F;
/*  63 */     this.rotBarrel = 0.0F;
/*  64 */     this.prevRotBarrel = 0.0F;
/*  65 */     this.recoilBuf = new Recoil[weapon.length];
/*     */     
/*  67 */     for (int i = 0; i < this.recoilBuf.length; i++) {
/*  68 */       this.recoilBuf[i] = new Recoil((weapon[i].getInfo()).recoilBufCount, (weapon[i].getInfo()).recoilBufCountSpeed);
/*     */     }
/*     */     
/*  71 */     this.defaultRotationYaw = 0.0F;
/*     */     
/*  73 */     this.targetPoint = Vec3.func_72443_a(0.0D, -1.0D, 0.0D);
/*     */   }
/*     */   
/*     */   public MCH_WeaponSet(MCH_WeaponBase weapon) {
/*  77 */     this(new MCH_WeaponBase[] { weapon });
/*     */   }
/*     */   
/*     */   public boolean isEqual(String s) {
/*  81 */     return this.name.equalsIgnoreCase(s);
/*     */   }
/*     */   
/*     */   public int getAmmoNum() {
/*  85 */     return this.numAmmo;
/*     */   }
/*     */   
/*     */   public int getAmmoNumMax() {
/*  89 */     return getFirstWeapon().getNumAmmoMax();
/*     */   }
/*     */   
/*     */   public int getRestAllAmmoNum() {
/*  93 */     return this.numRestAllAmmo;
/*     */   }
/*     */   
/*     */   public int getAllAmmoNum() {
/*  97 */     return getFirstWeapon().getAllAmmoNum();
/*     */   }
/*     */   
/*     */   public void setAmmoNum(int n) {
/* 101 */     this.numAmmo = n;
/*     */   }
/*     */   
/*     */   public void setRestAllAmmoNum(int n) {
/* 105 */     int debugBefore = this.numRestAllAmmo;
/* 106 */     int m = (getInfo()).maxAmmo - getAmmoNum();
/* 107 */     this.numRestAllAmmo = (n <= m) ? n : m;
/* 108 */     MCH_Lib.DbgLog((getFirstWeapon()).worldObj, "MCH_WeaponSet.setRestAllAmmoNum:%s %d->%d (%d)", new Object[] { getName(), Integer.valueOf(debugBefore), Integer.valueOf(this.numRestAllAmmo), Integer.valueOf(n) });
/*     */   }
/*     */   
/*     */   public void supplyRestAllAmmo() {
/* 112 */     int m = (getInfo()).maxAmmo;
/* 113 */     if (getRestAllAmmoNum() + getAmmoNum() < m) {
/* 114 */       setRestAllAmmoNum(getRestAllAmmoNum() + getAmmoNum() + (getInfo()).suppliedNum);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInPreparation() {
/* 120 */     return (this.countWait < 0 || this.countReloadWait > 0);
/*     */   }
/*     */   
/*     */   public String getName() {
/* 124 */     MCH_WeaponBase w = getCurrentWeapon();
/* 125 */     return (w != null) ? w.getName() : "";
/*     */   }
/*     */   
/*     */   public boolean canUse() {
/* 129 */     return (this.countWait == 0);
/*     */   }
/*     */   
/*     */   public boolean isLongDelayWeapon() {
/* 133 */     return ((getInfo()).delay > 4);
/*     */   }
/*     */   
/*     */   public void reload() {
/* 137 */     MCH_WeaponBase crtWpn = getCurrentWeapon();
/* 138 */     if (getAmmoNumMax() > 0 && getAmmoNum() < getAmmoNumMax() && crtWpn.getReloadCount() > 0) {
/* 139 */       this.countReloadWait = crtWpn.getReloadCount();
/* 140 */       if (crtWpn.worldObj.field_72995_K) {
/* 141 */         setAmmoNum(0);
/*     */       }
/*     */       
/* 144 */       if (!crtWpn.worldObj.field_72995_K) {
/* 145 */         this.countReloadWait -= 20;
/* 146 */         if (this.countReloadWait <= 0) {
/* 147 */           this.countReloadWait = 1;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void reloadMag() {
/* 155 */     int restAmmo = getRestAllAmmoNum();
/* 156 */     int nAmmo = getAmmoNumMax() - getAmmoNum();
/* 157 */     if (nAmmo > 0) {
/* 158 */       if (nAmmo > restAmmo) {
/* 159 */         nAmmo = restAmmo;
/*     */       }
/*     */       
/* 162 */       setAmmoNum(getAmmoNum() + nAmmo);
/* 163 */       setRestAllAmmoNum(getRestAllAmmoNum() - nAmmo);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void switchMode() {
/* 169 */     boolean isChanged = false;
/* 170 */     MCH_WeaponBase[] cntSwitch = this.weapons;
/* 171 */     int len$ = cntSwitch.length;
/*     */     
/* 173 */     for (int i$ = 0; i$ < len$; i$++) {
/* 174 */       MCH_WeaponBase w = cntSwitch[i$];
/* 175 */       if (w != null) {
/* 176 */         isChanged = (w.switchMode() || isChanged);
/*     */       }
/*     */     } 
/*     */     
/* 180 */     if (isChanged) {
/* 181 */       byte var6 = 15;
/* 182 */       if (this.countWait >= -var6) {
/* 183 */         if (this.countWait > var6) {
/* 184 */           this.countWait = -this.countWait;
/*     */         } else {
/* 186 */           this.countWait = -var6;
/*     */         } 
/*     */       }
/*     */       
/* 190 */       if ((getCurrentWeapon()).worldObj.field_72995_K) {
/* 191 */         W_McClient.DEF_playSoundFX("random.click", 1.0F, 1.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onSwitchWeapon(boolean isRemote, boolean isCreative) {
/* 198 */     int cntSwitch = 15;
/* 199 */     if (isRemote) {
/* 200 */       cntSwitch += 10;
/*     */     }
/*     */     
/* 203 */     if (this.countWait >= -cntSwitch) {
/* 204 */       if (this.countWait > cntSwitch) {
/* 205 */         this.countWait = -this.countWait;
/*     */       } else {
/* 207 */         this.countWait = -cntSwitch;
/*     */       } 
/*     */     }
/*     */     
/* 211 */     this.currentWeaponIndex = 0;
/* 212 */     if (isCreative) {
/* 213 */       setAmmoNum(getAmmoNumMax());
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isUsed(int index) {
/* 219 */     MCH_WeaponBase w = getFirstWeapon();
/* 220 */     if (w != null && index < this.lastUsedCount.length) {
/* 221 */       int cnt = this.lastUsedCount[index];
/* 222 */       return ((w.interval >= 4 && cnt > w.interval / 2) || cnt >= 4);
/*     */     } 
/* 224 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update(Entity shooter, boolean isSelected, boolean isUsed) {
/* 229 */     if (getCurrentWeapon().getInfo() != null) {
/* 230 */       if (this.countReloadWait > 0) {
/* 231 */         this.countReloadWait--;
/* 232 */         if (this.countReloadWait == 0) {
/* 233 */           reloadMag();
/*     */         }
/*     */       } 
/*     */       
/* 237 */       for (int arr$ = 0; arr$ < this.lastUsedCount.length; arr$++) {
/* 238 */         if (this.lastUsedCount[arr$] > 0) {
/* 239 */           if (this.lastUsedCount[arr$] == 4) {
/* 240 */             if (0 == getCurrentWeaponIndex() && canUse() && (getAmmoNum() > 0 || getAllAmmoNum() <= 0)) {
/* 241 */               this.lastUsedCount[arr$] = this.lastUsedCount[arr$] - 1;
/*     */             }
/*     */           } else {
/* 244 */             this.lastUsedCount[arr$] = this.lastUsedCount[arr$] - 1;
/*     */           } 
/*     */         }
/*     */       } 
/*     */       
/* 249 */       if (this.currentHeat > 0) {
/* 250 */         if (this.currentHeat < (getCurrentWeapon().getInfo()).maxHeatCount) {
/* 251 */           this.cooldownSpeed++;
/*     */         }
/*     */         
/* 254 */         this.currentHeat -= this.cooldownSpeed / 20 + 1;
/* 255 */         if (this.currentHeat < 0) {
/* 256 */           this.currentHeat = 0;
/*     */         }
/*     */       } 
/*     */       
/* 260 */       if (this.countWait > 0) {
/* 261 */         this.countWait--;
/*     */       }
/*     */       
/* 264 */       if (this.countWait < 0) {
/* 265 */         this.countWait++;
/*     */       }
/*     */       
/* 268 */       this.prevRotationYaw = this.rotationYaw;
/* 269 */       this.prevRotationPitch = this.rotationPitch;
/* 270 */       if (this.weapons != null && this.weapons.length > 0) {
/* 271 */         MCH_WeaponBase[] var8 = this.weapons;
/* 272 */         int len$ = var8.length;
/*     */         
/* 274 */         for (int i$ = 0; i$ < len$; i$++) {
/* 275 */           MCH_WeaponBase w = var8[i$];
/* 276 */           if (w != null) {
/* 277 */             w.update(this.countWait);
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 282 */       if (this.soundWait > 0) {
/* 283 */         this.soundWait--;
/*     */       }
/*     */       
/* 286 */       if (isUsed && this.rotBarrelSpd < 75.0F) {
/* 287 */         this.rotBarrelSpd += (25 + rand.nextInt(3));
/* 288 */         if (this.rotBarrelSpd > 74.0F) {
/* 289 */           this.rotBarrelSpd = 74.0F;
/*     */         }
/*     */       } 
/*     */       
/* 293 */       this.prevRotBarrel = this.rotBarrel;
/* 294 */       this.rotBarrel += this.rotBarrelSpd;
/* 295 */       if (this.rotBarrel >= 360.0F) {
/* 296 */         this.rotBarrel -= 360.0F;
/* 297 */         this.prevRotBarrel -= 360.0F;
/*     */       } 
/*     */       
/* 300 */       if (this.rotBarrelSpd > 0.0F) {
/* 301 */         this.rotBarrelSpd--;
/* 302 */         if (this.rotBarrelSpd < 0.0F) {
/* 303 */           this.rotBarrelSpd = 0.0F;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateWeapon(Entity shooter, boolean isUsed, int index) {
/* 311 */     MCH_WeaponBase crtWpn = getWeapon(index);
/*     */     
/* 313 */     if (isUsed && shooter.field_70170_p.field_72995_K && crtWpn != null && crtWpn.cartridge != null) {
/* 314 */       Vec3 r = crtWpn.getShotPos(shooter);
/* 315 */       float rb = shooter.field_70177_z;
/* 316 */       float pitch = shooter.field_70125_A;
/* 317 */       if (!(shooter instanceof mcheli.vehicle.MCH_EntityVehicle) || shooter.field_70153_n != null);
/*     */ 
/*     */ 
/*     */       
/* 321 */       MCH_EntityCartridge.spawnCartridge(shooter.field_70170_p, crtWpn.cartridge, shooter.field_70165_t + r.field_72450_a, shooter.field_70163_u + r.field_72448_b, shooter.field_70161_v + r.field_72449_c, shooter.field_70159_w, shooter.field_70181_x, shooter.field_70179_y, rb + this.rotationYaw, pitch + this.rotationPitch);
/*     */     } 
/*     */     
/* 324 */     if (index < this.recoilBuf.length) {
/* 325 */       Recoil var8 = this.recoilBuf[index];
/* 326 */       var8.prevRecoilBuf = var8.recoilBuf;
/* 327 */       if (isUsed && var8.recoilBufCount <= 0) {
/* 328 */         var8.recoilBufCount = var8.recoilBufCountMax;
/*     */       }
/*     */       
/* 331 */       if (var8.recoilBufCount > 0) {
/* 332 */         if (var8.recoilBufCountMax <= 1) {
/* 333 */           var8.recoilBuf = 1.0F;
/* 334 */         } else if (var8.recoilBufCountMax == 2) {
/* 335 */           var8.recoilBuf = (var8.recoilBufCount == 2) ? 1.0F : 0.6F;
/*     */         } else {
/* 337 */           if (var8.recoilBufCount > var8.recoilBufCountMax / 2) {
/* 338 */             var8.recoilBufCount -= var8.recoilBufCountSpeed;
/*     */           }
/*     */           
/* 341 */           float rb = var8.recoilBufCount / var8.recoilBufCountMax;
/* 342 */           var8.recoilBuf = MathHelper.func_76126_a(rb * 3.1415927F);
/*     */         } 
/*     */         
/* 345 */         var8.recoilBufCount--;
/*     */       } else {
/* 347 */         var8.recoilBuf = 0.0F;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean use(MCH_WeaponParam prm) {
/* 354 */     MCH_WeaponBase crtWpn = getCurrentWeapon();
/* 355 */     if (crtWpn != null && crtWpn.getInfo() != null) {
/* 356 */       MCH_WeaponInfo info = crtWpn.getInfo();
/* 357 */       if ((getAmmoNumMax() <= 0 || getAmmoNum() > 0) && (info.maxHeatCount <= 0 || this.currentHeat < info.maxHeatCount)) {
/* 358 */         crtWpn.canPlaySound = (this.soundWait == 0);
/* 359 */         prm.rotYaw = (prm.entity != null) ? prm.entity.field_70177_z : 0.0F;
/* 360 */         prm.rotPitch = (prm.entity != null) ? prm.entity.field_70125_A : 0.0F;
/* 361 */         prm.rotYaw += this.rotationYaw + crtWpn.fixRotationYaw;
/* 362 */         prm.rotPitch += this.rotationPitch + crtWpn.fixRotationPitch;
/* 363 */         if (info.accuracy > 0.0F) {
/* 364 */           prm.rotYaw += (rand.nextFloat() - 0.5F) * info.accuracy;
/* 365 */           prm.rotPitch += (rand.nextFloat() - 0.5F) * info.accuracy;
/*     */         } 
/*     */         
/* 368 */         prm.rotYaw = MathHelper.func_76142_g(prm.rotYaw);
/* 369 */         prm.rotPitch = MathHelper.func_76142_g(prm.rotPitch);
/* 370 */         if (crtWpn.use(prm)) {
/* 371 */           if (info.maxHeatCount > 0) {
/* 372 */             this.cooldownSpeed = 1;
/* 373 */             this.currentHeat += crtWpn.heatCount;
/* 374 */             if (this.currentHeat >= info.maxHeatCount) {
/* 375 */               this.currentHeat += 30;
/*     */             }
/*     */           } 
/*     */           
/* 379 */           if (info.soundDelay > 0 && this.soundWait == 0) {
/* 380 */             this.soundWait = info.soundDelay;
/*     */           }
/*     */           
/* 383 */           this.lastUsedOptionParameter1 = crtWpn.optionParameter1;
/* 384 */           this.lastUsedOptionParameter2 = crtWpn.optionParameter2;
/* 385 */           this.lastUsedCount[this.currentWeaponIndex] = (crtWpn.interval > 0) ? crtWpn.interval : -crtWpn.interval;
/* 386 */           if (crtWpn.isCooldownCountReloadTime() && crtWpn.getReloadCount() - 10 > this.lastUsedCount[this.currentWeaponIndex]) {
/* 387 */             this.lastUsedCount[this.currentWeaponIndex] = crtWpn.getReloadCount() - 10;
/*     */           }
/*     */           
/* 390 */           this.currentWeaponIndex = (this.currentWeaponIndex + 1) % this.weapons.length;
/* 391 */           this.countWait = crtWpn.interval;
/* 392 */           this.countReloadWait = 0;
/* 393 */           if (getAmmoNum() > 0) {
/* 394 */             setAmmoNum(getAmmoNum() - 1);
/*     */           }
/*     */           
/* 397 */           if (getAmmoNum() <= 0) {
/* 398 */             if (prm.isInfinity && getRestAllAmmoNum() < getAmmoNumMax()) {
/* 399 */               setRestAllAmmoNum(getAmmoNumMax());
/*     */             }
/*     */             
/* 402 */             reload();
/* 403 */             prm.reload = true;
/*     */           } 
/*     */           
/* 406 */           prm.result = true;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 411 */     return prm.result;
/*     */   }
/*     */   
/*     */   public void waitAndReloadByOther(boolean reload) {
/* 415 */     MCH_WeaponBase crtWpn = getCurrentWeapon();
/* 416 */     if (crtWpn != null && crtWpn.getInfo() != null) {
/* 417 */       this.countWait = crtWpn.interval;
/* 418 */       this.countReloadWait = 0;
/* 419 */       if (reload && getAmmoNumMax() > 0 && crtWpn.getReloadCount() > 0) {
/* 420 */         this.countReloadWait = crtWpn.getReloadCount();
/* 421 */         if (!crtWpn.worldObj.field_72995_K) {
/* 422 */           this.countReloadWait -= 20;
/* 423 */           if (this.countReloadWait <= 0) {
/* 424 */             this.countReloadWait = 1;
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getLastUsedOptionParameter1() {
/* 433 */     return this.lastUsedOptionParameter1;
/*     */   }
/*     */   
/*     */   public int getLastUsedOptionParameter2() {
/* 437 */     return this.lastUsedOptionParameter2;
/*     */   }
/*     */   
/*     */   public MCH_WeaponBase getFirstWeapon() {
/* 441 */     return getWeapon(0);
/*     */   }
/*     */   
/*     */   public int getCurrentWeaponIndex() {
/* 445 */     return this.currentWeaponIndex;
/*     */   }
/*     */   
/*     */   public MCH_WeaponBase getCurrentWeapon() {
/* 449 */     return getWeapon(this.currentWeaponIndex);
/*     */   }
/*     */   
/*     */   public MCH_WeaponBase getWeapon(int idx) {
/* 453 */     return (this.weapons != null && this.weapons.length > 0 && idx < this.weapons.length) ? this.weapons[idx] : null;
/*     */   }
/*     */   
/*     */   public int getWeaponNum() {
/* 457 */     return (this.weapons != null) ? this.weapons.length : 0;
/*     */   }
/*     */   
/*     */   public MCH_WeaponInfo getInfo() {
/* 461 */     return getFirstWeapon().getInfo();
/*     */   }
/*     */   
/*     */   public double getLandInDistance(MCH_WeaponParam prm) {
/* 465 */     double ret = -1.0D;
/* 466 */     MCH_WeaponBase crtWpn = getCurrentWeapon();
/* 467 */     if (crtWpn != null && crtWpn.getInfo() != null) {
/* 468 */       MCH_WeaponInfo info = crtWpn.getInfo();
/* 469 */       prm.rotYaw = (prm.entity != null) ? prm.entity.field_70177_z : 0.0F;
/* 470 */       prm.rotPitch = (prm.entity != null) ? prm.entity.field_70125_A : 0.0F;
/* 471 */       prm.rotYaw += this.rotationYaw + crtWpn.fixRotationYaw;
/* 472 */       prm.rotPitch += this.rotationPitch + crtWpn.fixRotationPitch;
/* 473 */       prm.rotYaw = MathHelper.func_76142_g(prm.rotYaw);
/* 474 */       prm.rotPitch = MathHelper.func_76142_g(prm.rotPitch);
/* 475 */       return crtWpn.getLandInDistance(prm);
/*     */     } 
/* 477 */     return ret;
/*     */   }
/*     */ 
/*     */   
/*     */   public class Recoil
/*     */   {
/*     */     public int recoilBufCount;
/*     */     
/*     */     public final int recoilBufCountMax;
/*     */     
/*     */     public final int recoilBufCountSpeed;
/*     */     public float recoilBuf;
/*     */     public float prevRecoilBuf;
/*     */     
/*     */     public Recoil(int max, int spd) {
/* 492 */       this.recoilBufCountMax = max;
/* 493 */       this.recoilBufCountSpeed = spd;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponSet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */