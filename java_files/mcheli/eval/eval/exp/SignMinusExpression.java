/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class SignMinusExpression
/*    */   extends Col1Expression {
/*    */   public SignMinusExpression() {
/*  6 */     setOperator("-");
/*    */   }
/*    */   
/*    */   protected SignMinusExpression(SignMinusExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new SignMinusExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long val) {
/* 18 */     return -val;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double val) {
/* 22 */     return -val;
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 26 */     return this.share.oper.signMinus(this.exp.evalObject());
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\SignMinusExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */