/*     */ package mcheli.weapon;
/*     */ 
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_WeaponCreator
/*     */ {
/*     */   public static MCH_WeaponBase createWeapon(World w, String weaponName, Vec3 v, float yaw, float pitch, MCH_IEntityLockChecker lockChecker, boolean onTurret) {
/*   9 */     MCH_WeaponInfo info = MCH_WeaponInfoManager.get(weaponName);
/*  10 */     if (info != null && info.type != "") {
/*  11 */       Object weapon = null;
/*  12 */       if (info.type.compareTo("machinegun1") == 0) {
/*  13 */         weapon = new MCH_WeaponMachineGun1(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  16 */       if (info.type.compareTo("machinegun2") == 0) {
/*  17 */         weapon = new MCH_WeaponMachineGun2(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  20 */       if (info.type.compareTo("tvmissile") == 0) {
/*  21 */         weapon = new MCH_WeaponTvMissile(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  24 */       if (info.type.compareTo("torpedo") == 0) {
/*  25 */         weapon = new MCH_WeaponTorpedo(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  28 */       if (info.type.compareTo("cas") == 0) {
/*  29 */         weapon = new MCH_WeaponCAS(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  32 */       if (info.type.compareTo("rocket") == 0) {
/*  33 */         weapon = new MCH_WeaponRocket(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*  35 */       if (info.type.compareTo("gpsmissile") == 0) {
/*  36 */         weapon = new MCH_WeaponGPSMissile(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  39 */       if (info.type.compareTo("aamissile") == 0) {
/*  40 */         weapon = new MCH_WeaponAAMissile(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  43 */       if (info.type.compareTo("asmissile") == 0) {
/*  44 */         weapon = new MCH_WeaponASMissile(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  47 */       if (info.type.compareTo("atmissile") == 0) {
/*  48 */         weapon = new MCH_WeaponATMissile(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  51 */       if (info.type.compareTo("lasermissile") == 0) {
/*  52 */         weapon = new MCH_WeaponLaserMissile(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  55 */       if (info.type.compareTo("bomb") == 0) {
/*  56 */         weapon = new MCH_WeaponBomb(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  59 */       if (info.type.compareTo("mkrocket") == 0) {
/*  60 */         weapon = new MCH_WeaponMarkerRocket(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  63 */       if (info.type.compareTo("dummy") == 0) {
/*  64 */         weapon = new MCH_WeaponDummy(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  67 */       if (info.type.compareTo("smoke") == 0) {
/*  68 */         weapon = new MCH_WeaponSmoke(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  71 */       if (info.type.compareTo("dispenser") == 0) {
/*  72 */         weapon = new MCH_WeaponDispenser(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  75 */       if (info.type.compareTo("targetingpod") == 0) {
/*  76 */         weapon = new MCH_WeaponTargetingPod(w, v, yaw, pitch, weaponName, info);
/*     */       }
/*     */       
/*  79 */       if (weapon != null) {
/*  80 */         ((MCH_WeaponBase)weapon).displayName = info.displayName;
/*  81 */         ((MCH_WeaponBase)weapon).power = info.power;
/*  82 */         ((MCH_WeaponBase)weapon).acceleration = info.acceleration;
/*  83 */         ((MCH_WeaponBase)weapon).explosionPower = info.explosion;
/*  84 */         ((MCH_WeaponBase)weapon).explosionPowerInWater = info.explosionInWater;
/*  85 */         ((MCH_WeaponBase)weapon).interval = info.delay;
/*  86 */         ((MCH_WeaponBase)weapon).setLockCountMax(info.lockTime);
/*  87 */         ((MCH_WeaponBase)weapon).setLockChecker(lockChecker);
/*  88 */         ((MCH_WeaponBase)weapon).numMode = info.modeNum;
/*  89 */         ((MCH_WeaponBase)weapon).piercing = info.piercing;
/*  90 */         ((MCH_WeaponBase)weapon).heatCount = info.heatCount;
/*  91 */         ((MCH_WeaponBase)weapon).onTurret = onTurret;
/*  92 */         if (info.maxHeatCount > 0 && ((MCH_WeaponBase)weapon).heatCount < 2) {
/*  93 */           ((MCH_WeaponBase)weapon).heatCount = 2;
/*     */         }
/*     */         
/*  96 */         if (w.field_72995_K) {
/*  97 */           if (((MCH_WeaponBase)weapon).interval < 4) {
/*  98 */             ((MCH_WeaponBase)weapon).interval++;
/*  99 */           } else if (((MCH_WeaponBase)weapon).interval < 7) {
/* 100 */             ((MCH_WeaponBase)weapon).interval += 2;
/* 101 */           } else if (((MCH_WeaponBase)weapon).interval < 10) {
/* 102 */             ((MCH_WeaponBase)weapon).interval += 3;
/* 103 */           } else if (((MCH_WeaponBase)weapon).interval < 20) {
/* 104 */             ((MCH_WeaponBase)weapon).interval += 6;
/*     */           } else {
/* 106 */             ((MCH_WeaponBase)weapon).interval += 10;
/* 107 */             if (((MCH_WeaponBase)weapon).interval >= 40) {
/* 108 */               ((MCH_WeaponBase)weapon).interval = -((MCH_WeaponBase)weapon).interval;
/*     */             }
/*     */           } 
/*     */           
/* 112 */           ((MCH_WeaponBase)weapon).heatCount++;
/* 113 */           ((MCH_WeaponBase)weapon).cartridge = info.cartridge;
/*     */         } 
/*     */         
/* 116 */         ((MCH_WeaponBase)weapon).modifyCommonParameters();
/*     */       } 
/*     */       
/* 119 */       return (MCH_WeaponBase)weapon;
/*     */     } 
/* 121 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponCreator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */