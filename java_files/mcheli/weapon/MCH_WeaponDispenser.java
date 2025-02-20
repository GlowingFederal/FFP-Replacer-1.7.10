/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.MCH_Lib;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponDispenser extends MCH_WeaponBase {
/*    */   public MCH_WeaponDispenser(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 10 */     super(w, v, yaw, pitch, nm, wi);
/* 11 */     this.acceleration = 0.5F;
/* 12 */     this.explosionPower = 0;
/* 13 */     this.power = 0;
/* 14 */     this.interval = -90;
/* 15 */     if (w.field_72995_K) {
/* 16 */       this.interval -= 10;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 22 */     if (!this.worldObj.field_72995_K) {
/* 23 */       playSound(prm.entity);
/* 24 */       Vec3 v = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -prm.rotYaw, -prm.rotPitch, -prm.rotRoll);
/* 25 */       MCH_EntityDispensedItem e = new MCH_EntityDispensedItem(this.worldObj, prm.posX, prm.posY, prm.posZ, v.field_72450_a, v.field_72448_b, v.field_72449_c, prm.rotYaw, prm.rotPitch, this.acceleration);
/* 26 */       e.setName(this.name);
/* 27 */       e.setParameterFromWeapon(this, prm.entity, prm.user);
/* 28 */       e.field_70159_w = prm.entity.field_70159_w + e.field_70159_w * 0.5D;
/* 29 */       e.field_70181_x = prm.entity.field_70181_x + e.field_70181_x * 0.5D;
/* 30 */       e.field_70179_y = prm.entity.field_70179_y + e.field_70179_y * 0.5D;
/* 31 */       e.field_70165_t += e.field_70159_w * 0.5D;
/* 32 */       e.field_70163_u += e.field_70181_x * 0.5D;
/* 33 */       e.field_70161_v += e.field_70179_y * 0.5D;
/* 34 */       this.worldObj.func_72838_d((Entity)e);
/*    */     } 
/*    */     
/* 37 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponDispenser.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */