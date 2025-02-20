/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class SignPlusExpression
/*    */   extends Col1Expression {
/*    */   public SignPlusExpression() {
/*  6 */     setOperator("+");
/*    */   }
/*    */   
/*    */   protected SignPlusExpression(SignPlusExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new SignPlusExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long val) {
/* 18 */     return val;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double val) {
/* 22 */     return val;
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 26 */     return this.share.oper.signPlus(this.exp.evalObject());
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\SignPlusExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */