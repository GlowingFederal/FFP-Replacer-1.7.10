/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class OptimizeLong
/*    */   extends OptimizeObject {
/*    */   protected boolean isTrue(AbstractExpression x) {
/*  6 */     return (x.evalLong() != 0L);
/*    */   }
/*    */   
/*    */   protected AbstractExpression toConst(AbstractExpression exp) {
/*    */     try {
/* 11 */       long e = exp.evalLong();
/* 12 */       return NumberExpression.create(exp, Long.toString(e));
/* 13 */     } catch (Exception var4) {
/* 14 */       return exp;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\OptimizeLong.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */