/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_EntityTvMissile
/*    */   extends MCH_EntityBaseBullet
/*    */ {
/*    */   public boolean isSpawnParticle = true;
/*    */   
/*    */   public MCH_EntityTvMissile(World par1World) {
/* 14 */     super(par1World);
/*    */   }
/*    */   
/*    */   public MCH_EntityTvMissile(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/* 18 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 22 */     super.func_70071_h_();
/* 23 */     if (this.isSpawnParticle && getInfo() != null && !(getInfo()).disableSmoke) {
/* 24 */       spawnParticle((getInfo()).trajectoryParticleName, 3, 5.0F * (getInfo()).smokeSize * 0.5F);
/*    */     }
/*    */     
/* 27 */     if (this.shootingEntity != null) {
/* 28 */       double x = this.field_70165_t - this.shootingEntity.field_70165_t;
/* 29 */       double y = this.field_70163_u - this.shootingEntity.field_70163_u;
/* 30 */       double z = this.field_70161_v - this.shootingEntity.field_70161_v;
/* 31 */       if (x * x + y * y + z * z > 1440000.0D) {
/* 32 */         func_70106_y();
/*    */       }
/*    */       
/* 35 */       if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
/* 36 */         onUpdateMotion();
/*    */       }
/* 38 */     } else if (!this.field_70170_p.field_72995_K) {
/* 39 */       func_70106_y();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void onUpdateMotion() {
/* 45 */     Entity e = this.shootingEntity;
/* 46 */     if (e != null && !e.field_70128_L) {
/* 47 */       MCH_EntityAircraft ac = MCH_EntityAircraft.getAircraft_RiddenOrControl(e);
/* 48 */       if (ac != null && ac.getTVMissile() == this) {
/* 49 */         float yaw = e.field_70177_z;
/* 50 */         float pitch = e.field_70125_A;
/* 51 */         double tX = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 52 */         double tZ = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 53 */         double tY = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/* 54 */         setMotion(tX, tY, tZ);
/* 55 */         func_70101_b(yaw, pitch);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public MCH_BulletModel getDefaultBulletModel() {
/* 62 */     return MCH_DefaultBulletModels.ATMissile;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityTvMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */