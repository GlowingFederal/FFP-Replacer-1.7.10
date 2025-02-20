/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class AndExpression
/*    */   extends Col2OpeExpression {
/*    */   public AndExpression() {
/*  6 */     setOperator("&&");
/*    */   }
/*    */   
/*    */   protected AndExpression(AndExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new AndExpression(this, s);
/*    */   }
/*    */   
/*    */   public long evalLong() {
/* 18 */     long val = this.expl.evalLong();
/* 19 */     return (val == 0L) ? val : this.expr.evalLong();
/*    */   }
/*    */   
/*    */   public double evalDouble() {
/* 23 */     double val = this.expl.evalDouble();
/* 24 */     return (val == 0.0D) ? val : this.expr.evalDouble();
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 28 */     Object val = this.expl.evalObject();
/* 29 */     return !this.share.oper.bool(val) ? val : this.expr.evalObject();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\AndExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */