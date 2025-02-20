/*    */ package mcheli.eval.eval.func;
/*    */ 
/*    */ public class VoidFunction
/*    */   implements Function {
/*    */   public long evalLong(Object object, String name, Long[] args) throws Throwable {
/*  6 */     System.out.println(object + "." + name + "関数が呼ばれた(long)");
/*    */     
/*  8 */     for (int i = 0; i < args.length; i++) {
/*  9 */       System.out.println("arg[" + i + "] " + args[i]);
/*    */     }
/*    */     
/* 12 */     return 0L;
/*    */   }
/*    */   
/*    */   public double evalDouble(Object object, String name, Double[] args) throws Throwable {
/* 16 */     System.out.println(object + "." + name + "関数が呼ばれた(double)");
/*    */     
/* 18 */     for (int i = 0; i < args.length; i++) {
/* 19 */       System.out.println("arg[" + i + "] " + args[i]);
/*    */     }
/*    */     
/* 22 */     return 0.0D;
/*    */   }
/*    */   
/*    */   public Object evalObject(Object object, String name, Object[] args) throws Throwable {
/* 26 */     System.out.println(object + "." + name + "関数が呼ばれた(Object)");
/*    */     
/* 28 */     for (int i = 0; i < args.length; i++) {
/* 29 */       System.out.println("arg[" + i + "] " + args[i]);
/*    */     }
/*    */     
/* 32 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\func\VoidFunction.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */