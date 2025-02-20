/*    */ package mcheli.weapon;
/*    */ 
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponSmoke
/*    */   extends MCH_WeaponBase {
/*    */   public MCH_WeaponSmoke(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/*  9 */     super(w, v, yaw, pitch, nm, wi);
/* 10 */     this.power = 0;
/*    */   }
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 14 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponSmoke.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */