/*     */ package mcheli.weapon;
/*     */ 
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.wrapper.W_MovingObjectPosition;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_EntityBullet
/*     */   extends MCH_EntityBaseBullet
/*     */ {
/*     */   public MCH_EntityBullet(World par1World) {
/*  21 */     super(par1World);
/*     */   }
/*     */   
/*     */   public MCH_EntityBullet(World par1World, double pX, double pY, double pZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/*  25 */     super(par1World, pX, pY, pZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  29 */     super.func_70071_h_();
/*  30 */     if (!this.field_70128_L && !this.field_70170_p.field_72995_K && getCountOnUpdate() > 1 && getInfo() != null && this.explosionPower > 0) {
/*  31 */       float pDist = (getInfo()).proximityFuseDist;
/*  32 */       if (pDist > 0.1D) {
/*  33 */         pDist++;
/*  34 */         float rng = pDist + MathHelper.func_76135_e((getInfo()).acceleration);
/*  35 */         List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(rng, rng, rng));
/*     */         
/*  37 */         for (int i = 0; i < list.size(); i++) {
/*  38 */           Entity entity1 = list.get(i);
/*  39 */           if (canBeCollidedEntity(entity1) && entity1.func_70068_e((Entity)this) < (pDist * pDist)) {
/*  40 */             MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityBullet.onUpdate:proximityFuse:" + entity1, new Object[0]);
/*  41 */             this.field_70165_t = (entity1.field_70165_t + this.field_70165_t) / 2.0D;
/*  42 */             this.field_70163_u = (entity1.field_70163_u + this.field_70163_u) / 2.0D;
/*  43 */             this.field_70161_v = (entity1.field_70161_v + this.field_70161_v) / 2.0D;
/*  44 */             MovingObjectPosition mop = W_MovingObjectPosition.newMOP((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0, W_WorldFunc.getWorldVec3EntityPos((Entity)this), false);
/*  45 */             onImpact(mop, 1.0F);
/*     */             break;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void simulateOnUpdate() {
/*  55 */     super.simulateOnUpdate();
/*     */   }
/*     */   
/*     */   protected void onUpdateCollided() {
/*  59 */     double mx = this.field_70159_w * this.accelerationFactor;
/*  60 */     double my = this.field_70181_x * this.accelerationFactor;
/*  61 */     double mz = this.field_70179_y * this.accelerationFactor;
/*  62 */     float damageFactor = 1.0F;
/*  63 */     MovingObjectPosition m = null;
/*     */ 
/*     */ 
/*     */     
/*  67 */     for (int entity = 0; entity < 5; entity++) {
/*  68 */       Vec3 vec32 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  69 */       Vec3 vec33 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t + mx, this.field_70163_u + my, this.field_70161_v + mz);
/*  70 */       m = W_WorldFunc.clip(this.field_70170_p, vec32, vec33);
/*  71 */       boolean list = false;
/*  72 */       if (this.shootingEntity != null && W_MovingObjectPosition.isHitTypeTile(m)) {
/*  73 */         Block d0 = W_WorldFunc.getBlock(this.field_70170_p, m.field_72311_b, m.field_72312_c, m.field_72309_d);
/*  74 */         MCH_Config var10000 = MCH_MOD.config;
/*  75 */         if (MCH_Config.bulletBreakableBlocks.contains(d0)) {
/*  76 */           W_WorldFunc.destroyBlock(this.field_70170_p, m.field_72311_b, m.field_72312_c, m.field_72309_d, true);
/*  77 */           list = true;
/*     */         } 
/*     */       } 
/*     */       
/*  81 */       if (!list) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/*  86 */     Vec3 vec3 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  87 */     Vec3 vec31 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t + mx, this.field_70163_u + my, this.field_70161_v + mz);
/*  88 */     if ((getInfo()).delayFuse > 0) {
/*  89 */       if (m != null) {
/*  90 */         boundBullet(m.field_72310_e);
/*  91 */         if (this.delayFuse == 0) {
/*  92 */           this.delayFuse = (getInfo()).delayFuse;
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/*  97 */       if (m != null) {
/*  98 */         vec31 = W_WorldFunc.getWorldVec3(this.field_70170_p, m.field_72307_f.field_72450_a, m.field_72307_f.field_72448_b, m.field_72307_f.field_72449_c);
/*     */       }
/*     */       
/* 101 */       Entity var22 = null;
/* 102 */       List<Entity> var23 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72321_a(mx, my, mz).func_72314_b(21.0D, 21.0D, 21.0D));
/* 103 */       double var24 = 0.0D;
/*     */       
/* 105 */       for (int j = 0; j < var23.size(); j++) {
/* 106 */         Entity entity1 = var23.get(j);
/* 107 */         if (canBeCollidedEntity(entity1)) {
/* 108 */           float f = 0.3F;
/* 109 */           AxisAlignedBB axisalignedbb = entity1.field_70121_D.func_72314_b(f, f, f);
/* 110 */           MovingObjectPosition m1 = axisalignedbb.func_72327_a(vec3, vec31);
/* 111 */           if (m1 != null) {
/* 112 */             double d1 = vec3.func_72438_d(m1.field_72307_f);
/* 113 */             if (d1 < var24 || var24 == 0.0D) {
/* 114 */               var22 = entity1;
/* 115 */               var24 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 121 */       if (var22 != null) {
/* 122 */         m = new MovingObjectPosition(var22);
/*     */       }
/*     */       
/* 125 */       if (m != null) {
/* 126 */         onImpact(m, damageFactor);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MCH_BulletModel getDefaultBulletModel() {
/* 133 */     return MCH_DefaultBulletModels.Bullet;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityBullet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */