/*    */ package mcheli.weapon;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_EntityCruiseMissile2 extends MCH_EntityBaseBullet {
/*    */   public double targetPosX;
/*    */   public double targetPosY;
/*    */   public double targetPosZ;
/*    */   public double lastDistToTarget;
/*    */   
/*    */   public MCH_EntityCruiseMissile2(World par1World) {
/* 15 */     super(par1World);
/* 16 */     this.targetPosX = 0.0D;
/* 17 */     this.targetPosY = 0.0D;
/* 18 */     this.targetPosZ = 0.0D;
/*    */   }
/*    */   
/*    */   public float getGravity() {
/* 22 */     return (getBomblet() == 1) ? -0.03F : super.getGravity();
/*    */   }
/*    */   
/*    */   public float getGravityInWater() {
/* 26 */     return (getBomblet() == 1) ? -0.03F : super.getGravityInWater();
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 30 */     super.func_70071_h_();
/* 31 */     if (getInfo() != null && !(getInfo()).disableSmoke && getBomblet() == 0) {
/* 32 */       spawnParticle((getInfo()).trajectoryParticleName, 3, 10.0F * (getInfo()).smokeSize * 0.5F);
/*    */     }
/* 34 */     if (!this.field_70170_p.field_72995_K && 
/* 35 */       Vec3.func_72443_a(this.targetPosX, this.targetPosY, this.targetPosZ).func_72438_d(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v)) > this.lastDistToTarget && this.field_70173_aa > 20) {
/* 36 */       MovingObjectPosition var15 = new MovingObjectPosition((Entity)this);
/* 37 */       onImpact(var15, 1.0F);
/* 38 */       func_70106_y();
/*    */     } 
/*    */ 
/*    */     
/* 42 */     double var14 = (float)Math.atan2(this.field_70179_y, this.field_70159_w);
/* 43 */     this.field_70177_z = (float)(var14 * 180.0D / Math.PI) - 90.0F;
/* 44 */     double r = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 45 */     this.field_70125_A = -((float)(Math.atan2(this.field_70181_x, r) * 180.0D / Math.PI));
/*    */   }
/*    */   
/*    */   public MCH_EntityCruiseMissile2(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/* 49 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/* 50 */     this.lastDistToTarget = Vec3.func_72443_a(targetX, targetY, targetZ).func_72438_d(Vec3.func_72443_a(posX, posY, posZ));
/*    */   }
/*    */   
/*    */   public MCH_BulletModel getDefaultBulletModel() {
/* 54 */     return MCH_DefaultBulletModels.GPSMissile;
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_70088_a() {
/* 59 */     super.func_70088_a();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityCruiseMissile2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */