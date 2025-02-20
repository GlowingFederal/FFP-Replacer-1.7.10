/*    */ package mcheli;
/*    */ 
/*    */ 
/*    */ public class MCH_LowPassFilterFloat
/*    */ {
/*    */   private MCH_Queue filter;
/*    */   
/*    */   public MCH_LowPassFilterFloat(int filterLength) {
/*  9 */     this.filter = new MCH_Queue(filterLength, Float.valueOf(0.0F));
/*    */   }
/*    */   
/*    */   public void clear() {
/* 13 */     this.filter.clear(Float.valueOf(0.0F));
/*    */   }
/*    */   
/*    */   public void put(float t) {
/* 17 */     this.filter.put(Float.valueOf(t));
/*    */   }
/*    */   
/*    */   public float getAvg() {
/* 21 */     float f = 0.0F;
/*    */     
/* 23 */     for (int i = 0; i < this.filter.size(); i++) {
/* 24 */       f += ((Float)this.filter.get(i)).floatValue();
/*    */     }
/*    */     
/* 27 */     return f / this.filter.size();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_LowPassFilterFloat.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */