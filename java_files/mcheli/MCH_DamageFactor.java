/*    */ package mcheli;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ 
/*    */ public class MCH_DamageFactor
/*    */ {
/*  9 */   private HashMap map = new HashMap<>();
/*    */ 
/*    */   
/*    */   public void clear() {
/* 13 */     this.map.clear();
/*    */   }
/*    */   
/*    */   public void add(Class<?> c, float value) {
/* 17 */     this.map.put(c, Float.valueOf(value));
/*    */   }
/*    */   
/*    */   public float getDamageFactor(Class c) {
/* 21 */     return this.map.containsKey(c) ? ((Float)this.map.get(c)).floatValue() : 1.0F;
/*    */   }
/*    */   
/*    */   public float getDamageFactor(Entity e) {
/* 25 */     return (e != null) ? getDamageFactor(e.getClass()) : 1.0F;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_DamageFactor.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */