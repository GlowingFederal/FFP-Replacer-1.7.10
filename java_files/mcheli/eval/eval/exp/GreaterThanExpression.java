/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class GreaterThanExpression
/*    */   extends Col2Expression {
/*    */   public GreaterThanExpression() {
/*  6 */     setOperator(">");
/*    */   }
/*    */   
/*    */   protected GreaterThanExpression(GreaterThanExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new GreaterThanExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long vl, long vr) {
/* 18 */     return (vl > vr) ? 1L : 0L;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double vl, double vr) {
/* 22 */     return (vl > vr) ? 1.0D : 0.0D;
/*    */   }
/*    */   
/*    */   protected Object operateObject(Object vl, Object vr) {
/* 26 */     return this.share.oper.greaterThan(vl, vr);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\GreaterThanExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */