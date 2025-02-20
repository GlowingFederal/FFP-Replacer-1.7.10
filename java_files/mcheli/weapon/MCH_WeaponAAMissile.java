/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.wrapper.W_Entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponAAMissile
/*    */   extends MCH_WeaponEntitySeeker {
/*    */   public MCH_WeaponAAMissile(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 12 */     super(w, v, yaw, pitch, nm, wi);
/* 13 */     this.power = 12;
/* 14 */     this.acceleration = 2.5F;
/* 15 */     this.explosionPower = 4;
/* 16 */     this.interval = 5;
/* 17 */     if (w.field_72995_K) {
/* 18 */       this.interval += 5;
/*    */     }
/*    */     
/* 21 */     this.guidanceSystem.canLockInAir = true;
/* 22 */     this.guidanceSystem.ridableOnly = wi.ridableOnly;
/*    */   }
/*    */   
/*    */   public boolean isCooldownCountReloadTime() {
/* 26 */     return true;
/*    */   }
/*    */   
/*    */   public void update(int countWait) {
/* 30 */     super.update(countWait);
/*    */   }
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 34 */     boolean result = false;
/* 35 */     if (!this.worldObj.field_72995_K) {
/* 36 */       Entity tgtEnt = prm.user.field_70170_p.func_73045_a(prm.option1);
/* 37 */       if (tgtEnt != null && !tgtEnt.field_70128_L) {
/* 38 */         playSound(prm.entity);
/* 39 */         float yaw = prm.entity.field_70177_z + this.fixRotationYaw;
/* 40 */         float pitch = prm.entity.field_70125_A + this.fixRotationPitch;
/* 41 */         double tX = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 42 */         double tZ = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 43 */         double tY = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/* 44 */         MCH_EntityAAMissile e = new MCH_EntityAAMissile(this.worldObj, prm.posX, prm.posY, prm.posZ, tX, tY, tZ, yaw, pitch, this.acceleration);
/* 45 */         e.setName(this.name);
/* 46 */         e.setParameterFromWeapon(this, prm.entity, prm.user);
/* 47 */         e.setTargetEntity(tgtEnt);
/* 48 */         this.worldObj.func_72838_d((Entity)e);
/* 49 */         result = true;
/*    */       } 
/* 51 */     } else if (this.guidanceSystem.lock(prm.user) && this.guidanceSystem.lastLockEntity != null) {
/* 52 */       result = true;
/* 53 */       this.optionParameter1 = W_Entity.getEntityId(this.guidanceSystem.lastLockEntity);
/*    */     } 
/*    */     
/* 56 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponAAMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */