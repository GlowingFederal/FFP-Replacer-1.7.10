/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class MultExpression
/*    */   extends Col2Expression {
/*    */   public MultExpression() {
/*  6 */     setOperator("*");
/*    */   }
/*    */   
/*    */   protected MultExpression(MultExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new MultExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long vl, long vr) {
/* 18 */     return vl * vr;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double vl, double vr) {
/* 22 */     return vl * vr;
/*    */   }
/*    */   
/*    */   protected Object operateObject(Object vl, Object vr) {
/* 26 */     return this.share.oper.mult(vl, vr);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\MultExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */