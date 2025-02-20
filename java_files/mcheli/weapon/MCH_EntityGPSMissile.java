/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_EntityGPSMissile
/*    */   extends MCH_EntityBaseBullet {
/*    */   public Vec3 targetPos;
/*    */   public Vec3 brimstoneTargetPosNext;
/* 11 */   public MCH_EntityAircraft targetAC = null;
/*    */   public Vec3 nextStepTargetPos;
/* 13 */   public int currentStep = 1;
/* 14 */   public int lastStepChangeTime = 0;
/*    */   public Vec3 launchPos;
/*    */   public double lastDistToTarget;
/*    */   
/*    */   public MCH_EntityGPSMissile(World par1World) {
/* 19 */     super(par1World);
/* 20 */     this.nextStepTargetPos = Vec3.func_72443_a(0.0D, 150.0D, 0.0D);
/* 21 */     this.targetPos = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/*    */   }
/*    */   
/*    */   public MCH_EntityGPSMissile(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration, MCH_WeaponInfo wi) {
/* 25 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/* 26 */     this.lastDistToTarget = Vec3.func_72443_a(targetX, targetY, targetZ).func_72438_d(Vec3.func_72443_a(posX, posY, posZ));
/* 27 */     this.launchPos = Vec3.func_72443_a(posX, posY, posZ);
/* 28 */     this.nextStepTargetPos = Vec3.func_72443_a(posX, posY + 150.0D, posZ);
/*    */   }
/*    */ 
/*    */   
/*    */   public void func_70071_h_() {
/* 33 */     super.func_70071_h_();
/* 34 */     if (getInfo() != null && !(getInfo()).disableSmoke && getBomblet() == 0 && this.field_70173_aa > 80) {
/* 35 */       spawnParticle((getInfo()).trajectoryParticleName, 3, 10.0F * (getInfo()).smokeSize * 0.5F);
/*    */     }
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 45 */     double var14 = (float)Math.atan2(this.field_70179_y, this.field_70159_w);
/* 46 */     this.field_70177_z = (float)(var14 * 180.0D / Math.PI) - 90.0F;
/* 47 */     double r = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 48 */     this.field_70125_A = -((float)(Math.atan2(this.field_70181_x, r) * 180.0D / Math.PI));
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_70088_a() {
/* 54 */     super.func_70088_a();
/*    */   }
/*    */   
/*    */   public MCH_BulletModel getDefaultBulletModel() {
/* 58 */     return MCH_DefaultBulletModels.GPSMissile;
/*    */   }
/*    */   
/*    */   public float getGravity() {
/* 62 */     return (getBomblet() == 1) ? -0.03F : super.getGravity();
/*    */   }
/*    */   
/*    */   public float getGravityInWater() {
/* 66 */     return (getBomblet() == 1) ? -0.03F : super.getGravityInWater();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityGPSMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */