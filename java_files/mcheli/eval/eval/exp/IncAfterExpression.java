/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class IncAfterExpression
/*    */   extends Col1AfterExpression {
/*    */   public IncAfterExpression() {
/*  6 */     setOperator("++");
/*    */   }
/*    */   
/*    */   protected IncAfterExpression(IncAfterExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new IncAfterExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long val) {
/* 18 */     this.exp.let(val + 1L, this.pos);
/* 19 */     return val;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double val) {
/* 23 */     this.exp.let(val + 1.0D, this.pos);
/* 24 */     return val;
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 28 */     Object val = this.exp.evalObject();
/* 29 */     this.exp.let(this.share.oper.inc(val, 1), this.pos);
/* 30 */     return val;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\IncAfterExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */