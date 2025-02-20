/*     */ package mcheli.weapon;
/*     */ 
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_PacketNotifyLock;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.uav.MCH_EntityUavStation;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import mcheli.wrapper.W_MovingObjectPosition;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_WeaponGuidanceSystem
/*     */ {
/*     */   protected World worldObj;
/*     */   public Entity lastLockEntity;
/*     */   private Entity targetEntity;
/*     */   private int lockCount;
/*     */   private int lockSoundCount;
/*     */   private int continueLockCount;
/*     */   private int lockCountMax;
/*     */   private int prevLockCount;
/*     */   public boolean canLockInWater;
/*     */   public boolean canLockOnGround;
/*     */   public boolean canLockInAir;
/*     */   public boolean ridableOnly;
/*     */   public double lockRange;
/*     */   public int lockAngle;
/*     */   public MCH_IEntityLockChecker checker;
/*     */   
/*     */   public MCH_WeaponGuidanceSystem() {
/*  39 */     this((World)null);
/*     */   }
/*     */   
/*     */   public MCH_WeaponGuidanceSystem(World w) {
/*  43 */     this.worldObj = w;
/*  44 */     this.targetEntity = null;
/*  45 */     this.lastLockEntity = null;
/*  46 */     this.lockCount = 0;
/*  47 */     this.continueLockCount = 0;
/*  48 */     this.lockCountMax = 1;
/*  49 */     this.prevLockCount = 0;
/*  50 */     this.canLockInWater = false;
/*  51 */     this.canLockOnGround = false;
/*  52 */     this.canLockInAir = false;
/*  53 */     this.ridableOnly = false;
/*  54 */     this.lockRange = 50.0D;
/*  55 */     this.lockAngle = 10;
/*  56 */     this.checker = null;
/*     */   }
/*     */   
/*     */   public void setWorld(World w) {
/*  60 */     this.worldObj = w;
/*     */   }
/*     */   
/*     */   public void setLockCountMax(int i) {
/*  64 */     this.lockCountMax = (i > 0) ? i : 1;
/*     */   }
/*     */   
/*     */   public int getLockCountMax() {
/*  68 */     float stealth = getEntityStealth(this.targetEntity);
/*  69 */     return (int)(this.lockCountMax + this.lockCountMax * stealth);
/*     */   }
/*     */   
/*     */   public int getLockCount() {
/*  73 */     return this.lockCount;
/*     */   }
/*     */   
/*     */   public boolean isLockingEntity(Entity entity) {
/*  77 */     return (getLockCount() > 0 && this.targetEntity != null && !this.targetEntity.field_70128_L && W_Entity.isEqual(entity, this.targetEntity));
/*     */   }
/*     */   
/*     */   public Entity getLockingEntity() {
/*  81 */     return (getLockCount() > 0 && this.targetEntity != null && !this.targetEntity.field_70128_L) ? this.targetEntity : null;
/*     */   }
/*     */   
/*     */   public Entity getTargetEntity() {
/*  85 */     return this.targetEntity;
/*     */   }
/*     */   
/*     */   public boolean isLockComplete() {
/*  89 */     return (getLockCount() == getLockCountMax() && this.lastLockEntity != null);
/*     */   }
/*     */   
/*     */   public void update() {
/*  93 */     if (this.worldObj != null && this.worldObj.field_72995_K) {
/*  94 */       if (this.lockCount != this.prevLockCount) {
/*  95 */         this.prevLockCount = this.lockCount;
/*     */       } else {
/*  97 */         this.lockCount = this.prevLockCount = 0;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean isEntityOnGround(Entity entity) {
/* 104 */     if (entity != null && !entity.field_70128_L) {
/* 105 */       if (entity.field_70122_E) {
/* 106 */         return true;
/*     */       }
/*     */       
/* 109 */       for (int i = 0; i < 12; i++) {
/* 110 */         int x = (int)(entity.field_70165_t + 0.5D);
/* 111 */         int y = (int)(entity.field_70163_u + 0.5D) - i;
/* 112 */         int z = (int)(entity.field_70161_v + 0.5D);
/* 113 */         int blockId = W_WorldFunc.getBlockId(entity.field_70170_p, x, y, z);
/* 114 */         if (blockId != 0 && !W_WorldFunc.isBlockWater(entity.field_70170_p, x, y, z)) {
/* 115 */           return true;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 120 */     return false;
/*     */   }
/*     */   
/*     */   public boolean lock(Entity user) {
/* 124 */     return lock(user, true);
/*     */   }
/*     */   
/*     */   public boolean lock(Entity user, boolean isLockContinue) {
/* 128 */     if (!this.worldObj.field_72995_K) {
/* 129 */       return false;
/*     */     }
/* 131 */     boolean result = false;
/*     */     
/* 133 */     if (this.lockCount == 0) {
/* 134 */       List<Entity> canLock = this.worldObj.func_72839_b(user, user.field_70121_D.func_72314_b(this.lockRange, this.lockRange, this.lockRange));
/* 135 */       Entity dx = null;
/* 136 */       double dist = this.lockRange * this.lockRange * 2.0D;
/*     */       
/* 138 */       for (int i = 0; i < canLock.size(); i++) {
/* 139 */         Entity ong = canLock.get(i);
/* 140 */         if (canLockEntity(ong)) {
/* 141 */           double dz = ong.field_70165_t - user.field_70165_t;
/* 142 */           double stealth = ong.field_70163_u - user.field_70163_u;
/* 143 */           double dz1 = ong.field_70161_v - user.field_70161_v;
/* 144 */           double d = dz * dz + stealth * stealth + dz1 * dz1;
/* 145 */           Entity entityLocker1 = getLockEntity(user);
/* 146 */           float stealth1 = 1.0F - getEntityStealth(ong);
/* 147 */           double range1 = this.lockRange * stealth1;
/* 148 */           float angle = this.lockAngle * (stealth1 / 2.0F + 0.5F);
/* 149 */           if (d < range1 * range1 && d < dist && inLockRange(entityLocker1, user.field_70177_z, user.field_70125_A, ong, angle)) {
/* 150 */             Vec3 v1 = W_WorldFunc.getWorldVec3(this.worldObj, entityLocker1.field_70165_t, entityLocker1.field_70163_u, entityLocker1.field_70161_v);
/* 151 */             Vec3 v2 = W_WorldFunc.getWorldVec3(this.worldObj, ong.field_70165_t, ong.field_70163_u + (ong.field_70131_O / 2.0F), ong.field_70161_v);
/* 152 */             MovingObjectPosition m = W_WorldFunc.clip(this.worldObj, v1, v2, false, true, false);
/* 153 */             if (m == null || W_MovingObjectPosition.isHitTypeEntity(m)) {
/* 154 */               dx = ong;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 160 */       this.targetEntity = dx;
/* 161 */       if (dx != null) {
/* 162 */         this.lockCount++;
/*     */       }
/* 164 */     } else if (this.targetEntity != null && !this.targetEntity.field_70128_L) {
/* 165 */       boolean var26 = true;
/* 166 */       if (!this.canLockInWater && this.targetEntity.func_70090_H()) {
/* 167 */         var26 = false;
/*     */       }
/*     */       
/* 170 */       boolean var27 = isEntityOnGround(this.targetEntity);
/* 171 */       if (!this.canLockOnGround && var27) {
/* 172 */         var26 = false;
/*     */       }
/*     */       
/* 175 */       if (!this.canLockInAir && !var27) {
/* 176 */         var26 = false;
/*     */       }
/*     */       
/* 179 */       if (var26) {
/* 180 */         double var28 = this.targetEntity.field_70165_t - user.field_70165_t;
/* 181 */         double dy = this.targetEntity.field_70163_u - user.field_70163_u;
/* 182 */         double dz = this.targetEntity.field_70161_v - user.field_70161_v;
/* 183 */         float var29 = 1.0F - getEntityStealth(this.targetEntity);
/* 184 */         double range = this.lockRange * var29;
/* 185 */         if (var28 * var28 + dy * dy + dz * dz < range * range) {
/* 186 */           if (this.worldObj.field_72995_K && this.lockSoundCount == 1) {
/* 187 */             MCH_PacketNotifyLock.send(getTargetEntity());
/*     */           }
/*     */           
/* 190 */           this.lockSoundCount = (this.lockSoundCount + 1) % 15;
/* 191 */           Entity entityLocker = getLockEntity(user);
/* 192 */           if (inLockRange(entityLocker, user.field_70177_z, user.field_70125_A, this.targetEntity, this.lockAngle)) {
/* 193 */             if (this.lockCount < getLockCountMax()) {
/* 194 */               this.lockCount++;
/*     */             }
/* 196 */           } else if (this.continueLockCount > 0) {
/* 197 */             this.continueLockCount--;
/* 198 */             if (this.continueLockCount <= 0 && this.lockCount > 0) {
/* 199 */               this.lockCount--;
/*     */             }
/*     */           } else {
/* 202 */             this.continueLockCount = 0;
/* 203 */             this.lockCount--;
/*     */           } 
/*     */           
/* 206 */           if (this.lockCount >= getLockCountMax()) {
/* 207 */             if (this.continueLockCount <= 0) {
/* 208 */               this.continueLockCount = getLockCountMax() / 3;
/* 209 */               if (this.continueLockCount > 20) {
/* 210 */                 this.continueLockCount = 20;
/*     */               }
/*     */             } 
/*     */             
/* 214 */             result = true;
/* 215 */             this.lastLockEntity = this.targetEntity;
/* 216 */             if (isLockContinue) {
/* 217 */               this.prevLockCount = this.lockCount - 1;
/*     */             } else {
/* 219 */               clearLock();
/*     */             } 
/*     */           } 
/*     */         } else {
/* 223 */           clearLock();
/*     */         } 
/*     */       } else {
/* 226 */         clearLock();
/*     */       } 
/*     */     } else {
/* 229 */       clearLock();
/*     */     } 
/*     */     
/* 232 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public static float getEntityStealth(Entity entity) {
/* 237 */     return (entity instanceof MCH_EntityAircraft) ? ((MCH_EntityAircraft)entity).getStealth() : ((entity != null && entity.field_70154_o instanceof MCH_EntityAircraft) ? ((MCH_EntityAircraft)entity.field_70154_o).getStealth() : 0.0F);
/*     */   }
/*     */   
/*     */   public void clearLock() {
/* 241 */     this.targetEntity = null;
/* 242 */     this.lockCount = 0;
/* 243 */     this.continueLockCount = 0;
/* 244 */     this.lockSoundCount = 0;
/*     */   }
/*     */   
/*     */   public Entity getLockEntity(Entity entity) {
/* 248 */     if (entity.field_70154_o instanceof MCH_EntityUavStation) {
/* 249 */       MCH_EntityUavStation us = (MCH_EntityUavStation)entity.field_70154_o;
/* 250 */       if (us.getControlAircract() != null) {
/* 251 */         return (Entity)us.getControlAircract();
/*     */       }
/*     */     } 
/*     */     
/* 255 */     return entity;
/*     */   }
/*     */   
/*     */   public boolean canLockEntity(Entity entity) {
/* 259 */     if (this.ridableOnly && entity instanceof net.minecraft.entity.player.EntityPlayer && entity.field_70154_o == null) {
/* 260 */       return false;
/*     */     }
/* 262 */     String className = entity.getClass().getName();
/* 263 */     if (className.indexOf("EntityCamera") >= 0)
/* 264 */       return false; 
/* 265 */     if (!W_Lib.isEntityLivingBase(entity) && !(entity instanceof MCH_EntityAircraft) && className.indexOf("EntityVehicle") < 0 && className.indexOf("EntityPlane") < 0 && className.indexOf("EntityMecha") < 0 && className.indexOf("EntityAAGun") < 0)
/* 266 */       return false; 
/* 267 */     if (!this.canLockInWater && entity.func_70090_H())
/* 268 */       return false; 
/* 269 */     if (this.checker != null && !this.checker.canLockEntity(entity)) {
/* 270 */       return false;
/*     */     }
/* 272 */     boolean ong = isEntityOnGround(entity);
/* 273 */     return (!this.canLockOnGround && ong) ? false : ((this.canLockInAir || ong));
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static boolean inLockRange(Entity entity, float rotationYaw, float rotationPitch, Entity target, float lockAng) {
/* 279 */     double dx = target.field_70165_t - entity.field_70165_t;
/* 280 */     double dy = target.field_70163_u + (target.field_70131_O / 2.0F) - entity.field_70163_u;
/* 281 */     double dz = target.field_70161_v - entity.field_70161_v;
/* 282 */     float entityYaw = (float)MCH_Lib.getRotate360(rotationYaw);
/* 283 */     float targetYaw = (float)MCH_Lib.getRotate360(Math.atan2(dz, dx) * 180.0D / Math.PI);
/* 284 */     float diffYaw = (float)MCH_Lib.getRotate360((targetYaw - entityYaw - 90.0F));
/* 285 */     double dxz = Math.sqrt(dx * dx + dz * dz);
/* 286 */     float targetPitch = -((float)(Math.atan2(dy, dxz) * 180.0D / Math.PI));
/* 287 */     float diffPitch = targetPitch - rotationPitch;
/* 288 */     return ((diffYaw < lockAng || diffYaw > 360.0F - lockAng) && Math.abs(diffPitch) < lockAng);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponGuidanceSystem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */