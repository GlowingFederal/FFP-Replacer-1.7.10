/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.wrapper.W_MovingObjectPosition;
/*    */ import mcheli.wrapper.W_WorldFunc;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.MathHelper;
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MCH_WeaponASMissile
/*    */   extends MCH_WeaponBase
/*    */ {
/*    */   public MCH_WeaponASMissile(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 18 */     super(w, v, yaw, pitch, nm, wi);
/* 19 */     this.acceleration = 3.0F;
/* 20 */     this.explosionPower = 9;
/* 21 */     this.power = 40;
/* 22 */     this.interval = -350;
/* 23 */     if (w.field_72995_K) {
/* 24 */       this.interval -= 10;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean isCooldownCountReloadTime() {
/* 30 */     return true;
/*    */   }
/*    */   
/*    */   public void update(int countWait) {
/* 34 */     super.update(countWait);
/*    */   }
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 38 */     float yaw = prm.user.field_70177_z;
/* 39 */     float pitch = prm.user.field_70125_A;
/* 40 */     double tX = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 41 */     double tZ = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 42 */     double tY = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/* 43 */     double dist = MathHelper.func_76133_a(tX * tX + tY * tY + tZ * tZ);
/* 44 */     if (this.worldObj.field_72995_K) {
/* 45 */       tX = tX * 200.0D / dist;
/* 46 */       tY = tY * 200.0D / dist;
/* 47 */       tZ = tZ * 200.0D / dist;
/*    */     } else {
/* 49 */       tX = tX * 250.0D / dist;
/* 50 */       tY = tY * 250.0D / dist;
/* 51 */       tZ = tZ * 250.0D / dist;
/*    */     } 
/*    */     
/* 54 */     Vec3 src = W_WorldFunc.getWorldVec3(this.worldObj, prm.entity.field_70165_t, prm.entity.field_70163_u + 1.62D, prm.entity.field_70161_v);
/* 55 */     Vec3 dst = W_WorldFunc.getWorldVec3(this.worldObj, prm.entity.field_70165_t + tX, prm.entity.field_70163_u + 1.62D + tY, prm.entity.field_70161_v + tZ);
/* 56 */     MovingObjectPosition m = W_WorldFunc.clip(this.worldObj, src, dst);
/* 57 */     if (m != null && W_MovingObjectPosition.isHitTypeTile(m) && !MCH_Lib.isBlockInWater(this.worldObj, m.field_72311_b, m.field_72312_c, m.field_72309_d)) {
/* 58 */       if (!this.worldObj.field_72995_K) {
/* 59 */         MCH_EntityASMissile e = new MCH_EntityASMissile(this.worldObj, prm.posX, prm.posY, prm.posZ, tX, tY, tZ, yaw, pitch, this.acceleration);
/* 60 */         e.setName(this.name);
/* 61 */         e.setParameterFromWeapon(this, prm.entity, prm.user);
/* 62 */         e.targetPosX = m.field_72307_f.field_72450_a;
/* 63 */         e.targetPosY = m.field_72307_f.field_72448_b;
/* 64 */         e.targetPosZ = m.field_72307_f.field_72449_c;
/* 65 */         this.worldObj.func_72838_d((Entity)e);
/* 66 */         playSound(prm.entity);
/*    */       } 
/*    */       
/* 69 */       return true;
/*    */     } 
/* 71 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponASMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */