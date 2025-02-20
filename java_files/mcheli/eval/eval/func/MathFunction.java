/*    */ package mcheli.eval.eval.func;
/*    */ 
/*    */ import java.lang.reflect.Method;
/*    */ 
/*    */ public class MathFunction
/*    */   implements Function {
/*    */   public long evalLong(Object object, String name, Long[] args) throws Throwable {
/*  8 */     Class[] types = new Class[args.length];
/*    */     
/* 10 */     for (int m = 0; m < types.length; m++) {
/* 11 */       types[m] = long.class;
/*    */     }
/*    */     
/* 14 */     Method var7 = Math.class.getMethod(name, types);
/* 15 */     Object ret = var7.invoke(null, (Object[])args);
/* 16 */     return ((Long)ret).longValue();
/*    */   }
/*    */   
/*    */   public double evalDouble(Object object, String name, Double[] args) throws Throwable {
/* 20 */     Class[] types = new Class[args.length];
/*    */     
/* 22 */     for (int m = 0; m < types.length; m++) {
/* 23 */       types[m] = double.class;
/*    */     }
/*    */     
/* 26 */     Method var7 = Math.class.getMethod(name, types);
/* 27 */     Object ret = var7.invoke(null, (Object[])args);
/* 28 */     return ((Double)ret).doubleValue();
/*    */   }
/*    */   
/*    */   public Object evalObject(Object object, String name, Object[] args) throws Throwable {
/* 32 */     Class[] types = new Class[args.length];
/*    */     
/* 34 */     for (int m = 0; m < types.length; m++) {
/* 35 */       Class<?> c = args[m].getClass();
/* 36 */       if (Double.class.isAssignableFrom(c)) {
/* 37 */         c = double.class;
/* 38 */       } else if (Float.class.isAssignableFrom(c)) {
/* 39 */         c = float.class;
/* 40 */       } else if (Integer.class.isAssignableFrom(c)) {
/* 41 */         c = int.class;
/* 42 */       } else if (Number.class.isAssignableFrom(c)) {
/* 43 */         c = long.class;
/*    */       } 
/*    */       
/* 46 */       types[m] = c;
/*    */     } 
/*    */     
/* 49 */     Method var7 = Math.class.getMethod(name, types);
/* 50 */     return var7.invoke(null, args);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\func\MathFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */