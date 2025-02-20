/*    */ package mcheli.weapon;
/*    */ 
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_EntityTorpedo
/*    */   extends MCH_EntityBaseBullet {
/*    */   public double targetPosX;
/*    */   public double targetPosY;
/*    */   public double targetPosZ;
/* 11 */   public double accelerationInWater = 2.0D;
/*    */ 
/*    */   
/*    */   public MCH_EntityTorpedo(World par1World) {
/* 15 */     super(par1World);
/* 16 */     this.targetPosX = 0.0D;
/* 17 */     this.targetPosY = 0.0D;
/* 18 */     this.targetPosZ = 0.0D;
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 22 */     super.func_70071_h_();
/* 23 */     if (getInfo() != null && (getInfo()).isGuidedTorpedo) {
/* 24 */       onUpdateGuided();
/*    */     } else {
/* 26 */       onUpdateNoGuided();
/*    */     } 
/*    */     
/* 29 */     if (func_70090_H() && getInfo() != null && !(getInfo()).disableSmoke) {
/* 30 */       spawnParticle((getInfo()).trajectoryParticleName, 3, 5.0F * (getInfo()).smokeSize * 0.5F);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   private void onUpdateNoGuided() {
/* 37 */     if (!this.field_70170_p.field_72995_K && func_70090_H()) {
/* 38 */       this.field_70181_x *= 0.800000011920929D;
/* 39 */       if (this.acceleration < this.accelerationInWater) {
/* 40 */         this.acceleration += 0.1D;
/* 41 */       } else if (this.acceleration > this.accelerationInWater + 0.20000000298023224D) {
/* 42 */         this.acceleration -= 0.1D;
/*    */       } 
/*    */       
/* 45 */       double a = this.field_70159_w;
/* 46 */       double y = this.field_70181_x;
/* 47 */       double z = this.field_70179_y;
/* 48 */       double d = MathHelper.func_76133_a(a * a + y * y + z * z);
/* 49 */       this.field_70159_w = a * this.acceleration / d;
/* 50 */       this.field_70181_x = y * this.acceleration / d;
/* 51 */       this.field_70179_y = z * this.acceleration / d;
/*    */     } 
/*    */     
/* 54 */     if (func_70090_H()) {
/* 55 */       double a = (float)Math.atan2(this.field_70179_y, this.field_70159_w);
/* 56 */       this.field_70177_z = (float)(a * 180.0D / Math.PI) - 90.0F;
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void onUpdateGuided() {
/* 64 */     if (!this.field_70170_p.field_72995_K && func_70090_H()) {
/* 65 */       if (this.acceleration < this.accelerationInWater) {
/* 66 */         this.acceleration += 0.1D;
/* 67 */       } else if (this.acceleration > this.accelerationInWater + 0.20000000298023224D) {
/* 68 */         this.acceleration -= 0.1D;
/*    */       } 
/*    */       
/* 71 */       double a = this.targetPosX - this.field_70165_t;
/* 72 */       double r = this.targetPosY - this.field_70163_u;
/* 73 */       double z = this.targetPosZ - this.field_70161_v;
/* 74 */       double d = MathHelper.func_76133_a(a * a + r * r + z * z);
/* 75 */       this.field_70159_w = a * this.acceleration / d;
/* 76 */       this.field_70181_x = r * this.acceleration / d;
/* 77 */       this.field_70179_y = z * this.acceleration / d;
/*    */     } 
/*    */     
/* 80 */     if (func_70090_H()) {
/* 81 */       double a = (float)Math.atan2(this.field_70179_y, this.field_70159_w);
/* 82 */       this.field_70177_z = (float)(a * 180.0D / Math.PI) - 90.0F;
/* 83 */       double r = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 84 */       this.field_70125_A = -((float)(Math.atan2(this.field_70181_x, r) * 180.0D / Math.PI));
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MCH_EntityTorpedo(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/* 90 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/*    */   }
/*    */   
/*    */   public MCH_BulletModel getDefaultBulletModel() {
/* 94 */     return MCH_DefaultBulletModels.Torpedo;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityTorpedo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */