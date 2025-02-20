/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.util.MovingObjectPosition;
/*    */ import net.minecraft.util.Vec3;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_MovingObjectPosition
/*    */ {
/*    */   public static boolean isHitTypeEntity(MovingObjectPosition m) {
/* 16 */     if (m == null) {
/* 17 */       return false;
/*    */     }
/* 19 */     return (m.field_72313_a == MovingObjectPosition.MovingObjectType.ENTITY);
/*    */   }
/*    */   
/*    */   public static boolean isHitTypeTile(MovingObjectPosition m) {
/* 23 */     if (m == null) {
/* 24 */       return false;
/*    */     }
/* 26 */     return (m.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK);
/*    */   }
/*    */   
/*    */   public static MovingObjectPosition newMOP(int p1, int p2, int p3, int p4, Vec3 p5, boolean p6) {
/* 30 */     return new MovingObjectPosition(p1, p2, p3, p4, p5, p6);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_MovingObjectPosition.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */