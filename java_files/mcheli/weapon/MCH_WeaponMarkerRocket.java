/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.MCH_Lib;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponMarkerRocket extends MCH_WeaponBase {
/*    */   public MCH_WeaponMarkerRocket(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 10 */     super(w, v, yaw, pitch, nm, wi);
/* 11 */     this.acceleration = 3.0F;
/* 12 */     this.explosionPower = 0;
/* 13 */     this.power = 0;
/* 14 */     this.interval = 60;
/* 15 */     if (w.field_72995_K) {
/* 16 */       this.interval += 10;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 22 */     if (!this.worldObj.field_72995_K) {
/* 23 */       playSound(prm.entity);
/* 24 */       Vec3 v = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -prm.rotYaw, -prm.rotPitch, -prm.rotRoll);
/* 25 */       MCH_EntityMarkerRocket e = new MCH_EntityMarkerRocket(this.worldObj, prm.posX, prm.posY, prm.posZ, v.field_72450_a, v.field_72448_b, v.field_72449_c, prm.rotYaw, prm.rotPitch, this.acceleration);
/* 26 */       e.setName(this.name);
/* 27 */       e.setParameterFromWeapon(this, prm.entity, prm.user);
/* 28 */       e.setMarkerStatus(1);
/* 29 */       this.worldObj.func_72838_d((Entity)e);
/*    */     } else {
/* 31 */       this.optionParameter1 = getCurrentMode();
/*    */     } 
/*    */     
/* 34 */     return true;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponMarkerRocket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */