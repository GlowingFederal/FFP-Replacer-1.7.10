/*    */ package mcheli.weapon;
/*    */ 
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_EntityAAMissile extends MCH_EntityBaseBullet {
/*    */   public double prevDistanceToEntity;
/*    */   public int closeCount;
/*    */   
/*    */   public MCH_EntityAAMissile(World par1World) {
/* 11 */     super(par1World);
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */     
/* 52 */     this.prevDistanceToEntity = 0.0D;
/* 53 */     this.closeCount = 0; this.targetEntity = null; } public MCH_EntityAAMissile(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) { super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration); this.prevDistanceToEntity = 0.0D; this.closeCount = 0; }
/*    */ 
/*    */   
/* 56 */   private void applyGuidance() { if (this.targetEntity != null); }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public MCH_BulletModel getDefaultBulletModel() {
/* 62 */     return MCH_DefaultBulletModels.AAMissile;
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/*    */     super.func_70071_h_();
/*    */     if (getCountOnUpdate() > 4 && getInfo() != null && !(getInfo()).disableSmoke)
/*    */       spawnParticle((getInfo()).trajectoryParticleName, 3, 7.0F * (getInfo()).smokeSize * 0.5F); 
/*    */     if (!this.field_70170_p.field_72995_K && getInfo() != null && this.shootingEntity != null && this.targetEntity != null && !this.targetEntity.field_70128_L) {
/*    */       double x = this.field_70165_t - this.targetEntity.field_70165_t;
/*    */       double y = this.field_70163_u - this.targetEntity.field_70163_u;
/*    */       double z = this.field_70161_v - this.targetEntity.field_70161_v;
/*    */       double d = x * x + y * y + z * z;
/*    */       if (d > 3422500.0D) {
/*    */         func_70106_y();
/*    */       } else if (getCountOnUpdate() > (getInfo()).rigidityTime) {
/*    */         if ((getInfo()).proximityFuseDist >= 0.1F && d < (getInfo()).proximityFuseDist) {
/*    */           MovingObjectPosition mop = new MovingObjectPosition(this.targetEntity);
/*    */           this.field_70165_t = (this.targetEntity.field_70165_t + this.field_70165_t) / 2.0D;
/*    */           this.field_70163_u = (this.targetEntity.field_70163_u + this.field_70163_u) / 2.0D;
/*    */           this.field_70161_v = (this.targetEntity.field_70161_v + this.field_70161_v) / 2.0D;
/*    */           onImpact(mop, 1.0F);
/*    */         } else {
/*    */           applyGuidance();
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityAAMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */