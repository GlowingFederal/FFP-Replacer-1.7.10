/*    */ package mcheli.weapon;
/*    */ 
/*    */ import java.util.List;
/*    */ import mcheli.wrapper.W_Lib;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_EntityBomb
/*    */   extends MCH_EntityBaseBullet
/*    */ {
/*    */   public MCH_EntityBomb(World par1World) {
/* 14 */     super(par1World);
/*    */   }
/*    */   
/*    */   public MCH_EntityBomb(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/* 18 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 22 */     super.func_70071_h_();
/* 23 */     if (!this.field_70170_p.field_72995_K && getInfo() != null) {
/* 24 */       this.field_70159_w *= 0.999D;
/* 25 */       this.field_70179_y *= 0.999D;
/* 26 */       if (func_70090_H()) {
/* 27 */         this.field_70159_w *= (getInfo()).velocityInWater;
/* 28 */         this.field_70181_x *= (getInfo()).velocityInWater;
/* 29 */         this.field_70179_y *= (getInfo()).velocityInWater;
/*    */       } 
/*    */       
/* 32 */       float dist = (getInfo()).proximityFuseDist;
/* 33 */       if (dist > 0.1F && getCountOnUpdate() % 10 == 0) {
/* 34 */         List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(dist, dist, dist));
/* 35 */         if (list != null) {
/* 36 */           for (int i = 0; i < list.size(); i++) {
/* 37 */             Entity entity = list.get(i);
/* 38 */             if (W_Lib.isEntityLivingBase(entity) && canBeCollidedEntity(entity)) {
/* 39 */               MovingObjectPosition m = new MovingObjectPosition((int)(this.field_70165_t + 0.5D), (int)(this.field_70163_u + 0.5D), (int)(this.field_70161_v + 0.5D), 0, Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v));
/* 40 */               onImpact(m, 1.0F);
/*    */               
/*    */               break;
/*    */             } 
/*    */           } 
/*    */         }
/*    */       } 
/*    */     } 
/* 48 */     onUpdateBomblet();
/*    */   }
/*    */   
/*    */   public void sprinkleBomblet() {
/* 52 */     if (!this.field_70170_p.field_72995_K) {
/* 53 */       MCH_EntityBomb e = new MCH_EntityBomb(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y, this.field_70146_Z.nextInt(360), 0.0F, this.acceleration);
/* 54 */       e.setParameterFromWeapon(this, this.shootingAircraft, this.shootingEntity);
/* 55 */       e.setName(getName());
/* 56 */       float MOTION = 1.0F;
/* 57 */       float RANDOM = (getInfo()).bombletDiff;
/* 58 */       e.field_70159_w = this.field_70159_w * 1.0D + ((this.field_70146_Z.nextFloat() - 0.5F) * RANDOM);
/* 59 */       e.field_70181_x = this.field_70181_x * 1.0D / 2.0D + ((this.field_70146_Z.nextFloat() - 0.5F) * RANDOM / 2.0F);
/* 60 */       e.field_70179_y = this.field_70179_y * 1.0D + ((this.field_70146_Z.nextFloat() - 0.5F) * RANDOM);
/* 61 */       e.setBomblet();
/* 62 */       this.field_70170_p.func_72838_d((Entity)e);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MCH_BulletModel getDefaultBulletModel() {
/* 68 */     return MCH_DefaultBulletModels.Bomb;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityBomb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */