/*    */ package mcheli.weapon;
/*    */ 
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.util.vector.Vector3f;
/*    */ 
/*    */ 
/*    */ public class MCH_EntityLaserMissile
/*    */   extends MCH_EntityBaseBullet
/*    */ {
/* 13 */   public int guidanceType = 0;
/* 14 */   private float getPrevDistanceToTarget = 0.0F;
/* 15 */   private int closeCount = 0;
/*    */ 
/*    */   
/*    */   public MCH_EntityLaserMissile(World par1World) {
/* 19 */     super(par1World);
/*    */   }
/*    */   
/*    */   public MCH_EntityLaserMissile(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/* 23 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 27 */     super.func_70071_h_();
/* 28 */     if (getInfo() != null && !(getInfo()).disableSmoke && this.field_70173_aa >= (getInfo()).trajectoryParticleStartTick) {
/* 29 */       spawnParticle((getInfo()).trajectoryParticleName, 3, 5.0F * (getInfo()).smokeSize * 0.5F);
/*    */     }
/*    */     
/* 32 */     if (!this.field_70170_p.field_72995_K && 
/* 33 */       this.shootingEntity != null) {
/* 34 */       MovingObjectPosition mop = getSpottedPoint((EntityLivingBase)this.shootingEntity, 1.0F, 256.0D, false);
/* 35 */       if (mop != null) {
/* 36 */         applyLaserGuidance(new Vector3f(mop.field_72311_b, mop.field_72312_c, mop.field_72309_d), new Vector3f((float)this.field_70159_w, (float)this.field_70181_x, (float)this.field_70179_y));
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 41 */     double a = (float)Math.atan2(this.field_70179_y, this.field_70159_w);
/* 42 */     this.field_70177_z = (float)(a * 180.0D / Math.PI) - 90.0F;
/* 43 */     double r = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 44 */     this.field_70125_A = -((float)(Math.atan2(this.field_70181_x, r) * 180.0D / Math.PI));
/*    */   }
/*    */   private static MovingObjectPosition getSpottedPoint(EntityLivingBase entity_base, float fasc, double dist, boolean interact) {
/* 47 */     Vec3 vec3 = Vec3.func_72443_a(entity_base.field_70165_t, entity_base.field_70163_u + entity_base.func_70047_e(), entity_base.field_70161_v);
/* 48 */     Vec3 vec31 = entity_base.func_70676_i(fasc);
/* 49 */     Vec3 vec32 = vec3.func_72441_c(vec31.field_72450_a * dist, vec31.field_72448_b * dist, vec31.field_72449_c * dist);
/* 50 */     return entity_base.field_70170_p.func_72901_a(vec3, vec32, interact);
/*    */   }
/*    */   
/*    */   private void applyLaserGuidance(Vector3f targetPos, Vector3f motion) {}
/*    */   
/*    */   public MCH_BulletModel getDefaultBulletModel() {
/* 56 */     return MCH_DefaultBulletModels.ATMissile;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityLaserMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */