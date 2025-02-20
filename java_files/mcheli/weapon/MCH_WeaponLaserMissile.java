/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.MCH_Lib;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponLaserMissile extends MCH_WeaponBase {
/*    */   public MCH_WeaponLaserMissile(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 10 */     super(w, v, yaw, pitch, nm, wi);
/* 11 */     this.acceleration = 4.0F;
/* 12 */     this.explosionPower = 3;
/* 13 */     this.power = 22;
/* 14 */     this.interval = 5;
/* 15 */     if (w.field_72995_K) {
/* 16 */       this.interval += 2;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public String getName() {
/* 22 */     return super.getName() + ((getCurrentMode() == 0) ? " [DIR]" : " [TOP]");
/*    */   }
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 26 */     if (!this.worldObj.field_72995_K) {
/* 27 */       playSound(prm.entity);
/* 28 */       Vec3 v = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -prm.rotYaw, -prm.rotPitch, -prm.rotRoll);
/* 29 */       MCH_EntityLaserMissile e = new MCH_EntityLaserMissile(this.worldObj, prm.posX, prm.posY, prm.posZ, v.field_72450_a, v.field_72448_b, v.field_72449_c, prm.rotYaw, prm.rotPitch, this.acceleration);
/* 30 */       e.setName(this.name);
/* 31 */       e.setParameterFromWeapon(this, prm.entity, prm.user);
/* 32 */       this.worldObj.func_72838_d((Entity)e);
/*    */     } else {
/* 34 */       this.optionParameter1 = getCurrentMode();
/*    */     } 
/* 36 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponLaserMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */