/*    */ package mcheli.weapon;
/*    */ 
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_EntityRocket extends MCH_EntityBaseBullet {
/*    */   public MCH_EntityRocket(World par1World) {
/*  8 */     super(par1World);
/*    */   }
/*    */   
/*    */   public MCH_EntityRocket(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/* 12 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 16 */     super.func_70071_h_();
/* 17 */     onUpdateBomblet();
/* 18 */     if (this.isBomblet <= 0 && getInfo() != null && !(getInfo()).disableSmoke) {
/* 19 */       spawnParticle((getInfo()).trajectoryParticleName, 3, 5.0F * (getInfo()).smokeSize * 0.5F);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void sprinkleBomblet() {
/* 25 */     if (!this.field_70170_p.field_72995_K) {
/* 26 */       MCH_EntityRocket e = new MCH_EntityRocket(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y, this.field_70177_z, this.field_70125_A, this.acceleration);
/* 27 */       e.setName(getName());
/* 28 */       e.setParameterFromWeapon(this, this.shootingAircraft, this.shootingEntity);
/* 29 */       float MOTION = (getInfo()).bombletDiff;
/* 30 */       float RANDOM = 1.2F;
/* 31 */       e.field_70159_w += (this.field_70146_Z.nextFloat() - 0.5D) * MOTION;
/* 32 */       e.field_70181_x += (this.field_70146_Z.nextFloat() - 0.5D) * MOTION;
/* 33 */       e.field_70179_y += (this.field_70146_Z.nextFloat() - 0.5D) * MOTION;
/* 34 */       e.setBomblet();
/* 35 */       this.field_70170_p.func_72838_d((Entity)e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MCH_BulletModel getDefaultBulletModel() {
/* 41 */     return MCH_DefaultBulletModels.Rocket;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityRocket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */