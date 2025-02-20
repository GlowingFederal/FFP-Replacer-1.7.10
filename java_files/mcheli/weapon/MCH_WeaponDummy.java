/*    */ package mcheli.weapon;
/*    */ 
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_WeaponDummy
/*    */   extends MCH_WeaponBase {
/*  8 */   static final MCH_WeaponInfo dummy = new MCH_WeaponInfo("none");
/*    */ 
/*    */   
/*    */   public int getUseInterval() {
/* 12 */     return 0;
/*    */   }
/*    */   
/*    */   public MCH_WeaponDummy(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 16 */     super(w, v, yaw, pitch, !nm.isEmpty() ? nm : "none", (wi != null) ? wi : dummy);
/*    */   }
/*    */   
/*    */   public boolean shot(MCH_WeaponParam prm) {
/* 20 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponDummy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */