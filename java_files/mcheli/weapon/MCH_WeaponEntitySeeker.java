/*    */ package mcheli.weapon;
/*    */ 
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public abstract class MCH_WeaponEntitySeeker
/*    */   extends MCH_WeaponBase
/*    */ {
/*    */   public MCH_IEntityLockChecker entityLockChecker;
/*    */   public MCH_WeaponGuidanceSystem guidanceSystem;
/*    */   
/*    */   public MCH_WeaponEntitySeeker(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/* 13 */     super(w, v, yaw, pitch, nm, wi);
/* 14 */     this.guidanceSystem = new MCH_WeaponGuidanceSystem(w);
/* 15 */     this.guidanceSystem.lockRange = 200.0D;
/* 16 */     this.guidanceSystem.lockAngle = 5;
/* 17 */     this.guidanceSystem.setLockCountMax(25);
/*    */   }
/*    */   
/*    */   public MCH_WeaponGuidanceSystem getGuidanceSystem() {
/* 21 */     return this.guidanceSystem;
/*    */   }
/*    */   
/*    */   public int getLockCount() {
/* 25 */     return this.guidanceSystem.getLockCount();
/*    */   }
/*    */   
/*    */   public void setLockCountMax(int n) {
/* 29 */     this.guidanceSystem.setLockCountMax(n);
/*    */   }
/*    */   
/*    */   public int getLockCountMax() {
/* 33 */     return this.guidanceSystem.getLockCountMax();
/*    */   }
/*    */   
/*    */   public void setLockChecker(MCH_IEntityLockChecker checker) {
/* 37 */     this.guidanceSystem.checker = checker;
/*    */   }
/*    */   
/*    */   public void update(int countWait) {
/* 41 */     super.update(countWait);
/* 42 */     this.guidanceSystem.update();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponEntitySeeker.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */