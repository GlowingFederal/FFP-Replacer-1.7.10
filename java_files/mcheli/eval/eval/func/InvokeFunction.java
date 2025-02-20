/*    */ package mcheli.eval.eval.func;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class InvokeFunction
/*    */   implements Function {
/*    */   public long evalLong(Object object, String name, Long[] args) throws Throwable {
/*  8 */     if (object == null) {
/*  9 */       return 0L;
/*    */     }
/* 11 */     Object r = callMethod(object, name, (Object[])args);
/* 12 */     return ((Number)r).longValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public double evalDouble(Object object, String name, Double[] args) throws Throwable {
/* 17 */     if (object == null) {
/* 18 */       return 0.0D;
/*    */     }
/* 20 */     Object r = callMethod(object, name, (Object[])args);
/* 21 */     return ((Number)r).doubleValue();
/*    */   }
/*    */ 
/*    */   
/*    */   public Object evalObject(Object object, String name, Object[] args) throws Throwable {
/* 26 */     return (object == null) ? null : callMethod(object, name, args);
/*    */   }
/*    */   
/*    */   public static Object callMethod(Object obj, String name, Object[] args) throws Exception {
/* 30 */     Class<?> c = obj.getClass();
/* 31 */     Class[] types = new Class[args.length];
/*    */     
/* 33 */     for (int m = 0; m < types.length; m++) {
/* 34 */       types[m] = args[m].getClass();
/*    */     }
/*    */     
/* 37 */     Method var6 = c.getMethod(name, types);
/* 38 */     return var6.invoke(obj, args);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\func\InvokeFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */