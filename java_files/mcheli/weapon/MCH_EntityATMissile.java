/*    */ package mcheli.weapon;
/*    */ 
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_EntityATMissile
/*    */   extends MCH_EntityBaseBullet {
/*  9 */   public int guidanceType = 0;
/*    */ 
/*    */   
/*    */   public MCH_EntityATMissile(World par1World) {
/* 13 */     super(par1World);
/*    */   }
/*    */   
/*    */   public MCH_EntityATMissile(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/* 17 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 21 */     super.func_70071_h_();
/* 22 */     if (getInfo() != null && !(getInfo()).disableSmoke && this.field_70173_aa >= (getInfo()).trajectoryParticleStartTick) {
/* 23 */       spawnParticle((getInfo()).trajectoryParticleName, 3, 5.0F * (getInfo()).smokeSize * 0.5F);
/*    */     }
/*    */     
/* 26 */     if (!this.field_70170_p.field_72995_K) {
/* 27 */       if (this.shootingEntity != null && this.targetEntity != null && !this.targetEntity.field_70128_L) {
/* 28 */         onUpdateMotion();
/*    */       } else {
/* 30 */         func_70106_y();
/*    */       } 
/*    */     }
/*    */     
/* 34 */     double a = (float)Math.atan2(this.field_70179_y, this.field_70159_w);
/* 35 */     this.field_70177_z = (float)(a * 180.0D / Math.PI) - 90.0F;
/* 36 */     double r = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 37 */     this.field_70125_A = -((float)(Math.atan2(this.field_70181_x, r) * 180.0D / Math.PI));
/*    */   }
/*    */   
/*    */   public void onUpdateMotion() {
/* 41 */     double x = this.targetEntity.field_70165_t - this.field_70165_t;
/* 42 */     double y = this.targetEntity.field_70163_u - this.field_70163_u;
/* 43 */     double z = this.targetEntity.field_70161_v - this.field_70161_v;
/* 44 */     double d = x * x + y * y + z * z;
/* 45 */     if (d <= 2250000.0D && !this.targetEntity.field_70128_L) {
/* 46 */       if ((getInfo()).proximityFuseDist >= 0.1F && d < (getInfo()).proximityFuseDist) {
/* 47 */         MovingObjectPosition var11 = new MovingObjectPosition(this.targetEntity);
/* 48 */         var11.field_72308_g = null;
/* 49 */         onImpact(var11, 1.0F);
/*    */       } else {
/* 51 */         int rigidityTime = (getInfo()).rigidityTime;
/* 52 */         float af = (getCountOnUpdate() < rigidityTime + (getInfo()).trajectoryParticleStartTick) ? 0.5F : 1.0F;
/* 53 */         if (getCountOnUpdate() > rigidityTime) {
/* 54 */           if (this.guidanceType == 1) {
/* 55 */             if (getCountOnUpdate() <= rigidityTime + 20) {
/* 56 */               guidanceToTarget(this.targetEntity.field_70165_t, this.shootingEntity.field_70163_u + 150.0D, this.targetEntity.field_70161_v, af);
/* 57 */             } else if (getCountOnUpdate() <= rigidityTime + 30) {
/* 58 */               guidanceToTarget(this.targetEntity.field_70165_t, this.shootingEntity.field_70163_u, this.targetEntity.field_70161_v, af);
/*    */             } else {
/* 60 */               if (getCountOnUpdate() == rigidityTime + 35) {
/* 61 */                 setPower((int)(getPower() * 1.2F));
/* 62 */                 if (this.explosionPower > 0) {
/* 63 */                   this.explosionPower++;
/*    */                 }
/*    */               } 
/*    */               
/* 67 */               guidanceToTarget(this.targetEntity.field_70165_t, this.targetEntity.field_70163_u, this.targetEntity.field_70161_v, af);
/*    */             } 
/*    */           } else {
/* 70 */             d = MathHelper.func_76133_a(d);
/* 71 */             this.field_70159_w = x * this.acceleration / d * af;
/* 72 */             this.field_70181_x = y * this.acceleration / d * af;
/* 73 */             this.field_70179_y = z * this.acceleration / d * af;
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } else {
/* 78 */       func_70106_y();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MCH_BulletModel getDefaultBulletModel() {
/* 84 */     return MCH_DefaultBulletModels.ATMissile;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityATMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */