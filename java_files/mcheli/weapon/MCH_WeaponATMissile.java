/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.wrapper.W_Entity;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponATMissile
/*    */   extends MCH_WeaponEntitySeeker {
/*    */   public MCH_WeaponATMissile(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 12 */     super(w, v, yaw, pitch, nm, wi);
/* 13 */     this.power = 32;
/* 14 */     this.acceleration = 2.0F;
/* 15 */     this.explosionPower = 4;
/* 16 */     this.interval = -100;
/* 17 */     if (w.field_72995_K) {
/* 18 */       this.interval -= 10;
/*    */     }
/*    */     
/* 21 */     this.numMode = 2;
/* 22 */     this.guidanceSystem.canLockOnGround = true;
/* 23 */     this.guidanceSystem.ridableOnly = wi.ridableOnly;
/*    */   }
/*    */   
/*    */   public boolean isCooldownCountReloadTime() {
/* 27 */     return true;
/*    */   }
/*    */   
/*    */   public String getName() {
/* 31 */     String opt = "";
/* 32 */     if (getCurrentMode() == 1) {
/* 33 */       opt = " [TA]";
/*    */     }
/*    */     
/* 36 */     return super.getName() + opt;
/*    */   }
/*    */   
/*    */   public void update(int countWait) {
/* 40 */     super.update(countWait);
/*    */   }
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 44 */     return this.worldObj.field_72995_K ? shotClient(prm.entity, prm.user) : shotServer(prm);
/*    */   }
/*    */   
/*    */   protected boolean shotClient(Entity entity, Entity user) {
/* 48 */     boolean result = false;
/* 49 */     if (this.guidanceSystem.lock(user) && this.guidanceSystem.lastLockEntity != null) {
/* 50 */       result = true;
/* 51 */       this.optionParameter1 = W_Entity.getEntityId(this.guidanceSystem.lastLockEntity);
/*    */     } 
/*    */     
/* 54 */     this.optionParameter2 = getCurrentMode();
/* 55 */     return result;
/*    */   }
/*    */   
/*    */   protected boolean shotServer(MCH_WeaponParam prm) {
/* 59 */     Entity tgtEnt = null;
/* 60 */     tgtEnt = prm.user.field_70170_p.func_73045_a(prm.option1);
/* 61 */     if (tgtEnt != null && !tgtEnt.field_70128_L) {
/* 62 */       float yaw = prm.user.field_70177_z + this.fixRotationYaw;
/* 63 */       float pitch = prm.entity.field_70125_A + this.fixRotationPitch;
/* 64 */       double tX = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 65 */       double tZ = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 66 */       double tY = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/* 67 */       MCH_EntityATMissile e = new MCH_EntityATMissile(this.worldObj, prm.posX, prm.posY, prm.posZ, tX, tY, tZ, yaw, pitch, this.acceleration);
/* 68 */       e.setName(this.name);
/* 69 */       e.setParameterFromWeapon(this, prm.entity, prm.user);
/* 70 */       e.setTargetEntity(tgtEnt);
/* 71 */       e.guidanceType = prm.option2;
/* 72 */       this.worldObj.func_72838_d((Entity)e);
/* 73 */       playSound(prm.entity);
/* 74 */       return true;
/*    */     } 
/* 76 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponATMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */