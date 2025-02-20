/*    */ package mcheli.eval.eval.var;
/*    */ 
/*    */ import java.lang.reflect.Array;
/*    */ import java.lang.reflect.Field;
/*    */ import java.util.HashMap;
/*    */ import java.util.Map;
/*    */ 
/*    */ public class MapVariable
/*    */   implements Variable
/*    */ {
/*    */   protected Map map;
/*    */   
/*    */   public MapVariable() {
/* 14 */     this(new HashMap<>());
/*    */   }
/*    */   
/*    */   public MapVariable(Map varMap) {
/* 18 */     this.map = varMap;
/*    */   }
/*    */   
/*    */   public void setMap(Map varMap) {
/* 22 */     this.map = varMap;
/*    */   }
/*    */   
/*    */   public Map getMap() {
/* 26 */     return this.map;
/*    */   }
/*    */   
/*    */   public void setValue(Object name, Object obj) {
/* 30 */     this.map.put(name, obj);
/*    */   }
/*    */   
/*    */   public Object getObject(Object name) {
/* 34 */     return this.map.get(name);
/*    */   }
/*    */   
/*    */   public long evalLong(Object val) {
/* 38 */     return ((Number)val).longValue();
/*    */   }
/*    */   
/*    */   public double evalDouble(Object val) {
/* 42 */     return ((Number)val).doubleValue();
/*    */   }
/*    */   
/*    */   public Object getObject(Object array, int index) {
/* 46 */     return Array.get(array, index);
/*    */   }
/*    */   
/*    */   public void setValue(Object array, int index, Object val) {
/* 50 */     Array.set(array, index, val);
/*    */   }
/*    */   
/*    */   public Object getObject(Object obj, String field) {
/*    */     try {
/* 55 */       Class<?> e = obj.getClass();
/* 56 */       Field f = e.getField(field);
/* 57 */       return f.get(obj);
/* 58 */     } catch (RuntimeException var5) {
/* 59 */       throw var5;
/* 60 */     } catch (Exception var6) {
/* 61 */       throw new RuntimeException(var6);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void setValue(Object obj, String field, Object val) {
/*    */     try {
/* 67 */       Class<?> e = obj.getClass();
/* 68 */       Field f = e.getField(field);
/* 69 */       f.set(obj, val);
/* 70 */     } catch (RuntimeException var6) {
/* 71 */       throw var6;
/* 72 */     } catch (Exception var7) {
/* 73 */       throw new RuntimeException(var7);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\var\MapVariable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */