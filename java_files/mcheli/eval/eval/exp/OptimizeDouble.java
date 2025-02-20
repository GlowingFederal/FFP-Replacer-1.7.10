/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class OptimizeDouble
/*    */   extends OptimizeObject {
/*    */   protected boolean isTrue(AbstractExpression x) {
/*  6 */     return (x.evalDouble() != 0.0D);
/*    */   }
/*    */   
/*    */   protected AbstractExpression toConst(AbstractExpression exp) {
/*    */     try {
/* 11 */       double e = exp.evalDouble();
/* 12 */       return NumberExpression.create(exp, Double.toString(e));
/* 13 */     } catch (Exception var4) {
/* 14 */       return exp;
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\OptimizeDouble.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */