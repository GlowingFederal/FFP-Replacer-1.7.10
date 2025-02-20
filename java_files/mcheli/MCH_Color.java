/*    */ package mcheli;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MCH_Color
/*    */ {
/*    */   public float a;
/*    */   public float r;
/*    */   public float g;
/*    */   public float b;
/*    */   
/*    */   public MCH_Color(float aa, float rr, float gg, float bb) {
/* 13 */     this.a = round(aa);
/* 14 */     this.r = round(rr);
/* 15 */     this.g = round(gg);
/* 16 */     this.b = round(bb);
/*    */   }
/*    */   
/*    */   public MCH_Color(float rr, float gg, float bb) {
/* 20 */     this(1.0F, rr, gg, bb);
/*    */   }
/*    */   
/*    */   public MCH_Color() {
/* 24 */     this(1.0F, 1.0F, 1.0F, 1.0F);
/*    */   }
/*    */   
/*    */   public float round(float f) {
/* 28 */     return (f < 0.0F) ? 0.0F : ((f > 1.0F) ? 1.0F : f);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_Color.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */