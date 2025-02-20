/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.MCH_Lib;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponMachineGun2 extends MCH_WeaponBase {
/*    */   public MCH_WeaponMachineGun2(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 10 */     super(w, v, yaw, pitch, nm, wi);
/* 11 */     this.power = 16;
/* 12 */     this.acceleration = 4.0F;
/* 13 */     this.explosionPower = 1;
/* 14 */     this.interval = 2;
/* 15 */     this.numMode = 2;
/*    */   }
/*    */   
/*    */   public void modifyParameters() {
/* 19 */     if (this.explosionPower == 0) {
/* 20 */       this.numMode = 0;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 26 */     return super.getName() + ((getCurrentMode() == 0) ? "" : " [HE]");
/*    */   }
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 30 */     if (!this.worldObj.field_72995_K) {
/* 31 */       Vec3 v = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -prm.rotYaw, -prm.rotPitch, -prm.rotRoll);
/* 32 */       MCH_EntityBullet e = new MCH_EntityBullet(this.worldObj, prm.posX, prm.posY, prm.posZ, v.field_72450_a, v.field_72448_b, v.field_72449_c, prm.rotYaw, prm.rotPitch, this.acceleration);
/* 33 */       e.setName(this.name);
/* 34 */       e.setParameterFromWeapon(this, prm.entity, prm.user);
/* 35 */       if ((getInfo()).modeNum < 2) {
/* 36 */         e.explosionPower = this.explosionPower;
/*    */       } else {
/* 38 */         e.explosionPower = (prm.option1 == 0) ? -this.explosionPower : this.explosionPower;
/*    */       } 
/*    */       
/* 41 */       e.field_70165_t += e.field_70159_w * 0.5D;
/* 42 */       e.field_70163_u += e.field_70181_x * 0.5D;
/* 43 */       e.field_70161_v += e.field_70179_y * 0.5D;
/* 44 */       this.worldObj.func_72838_d((Entity)e);
/* 45 */       playSound(prm.entity);
/*    */     } else {
/* 47 */       this.optionParameter1 = getCurrentMode();
/*    */     } 
/*    */     
/* 50 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponMachineGun2.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */