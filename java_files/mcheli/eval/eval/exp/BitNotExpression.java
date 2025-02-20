/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class BitNotExpression
/*    */   extends Col1Expression {
/*    */   public BitNotExpression() {
/*  6 */     setOperator("~");
/*    */   }
/*    */   
/*    */   protected BitNotExpression(BitNotExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new BitNotExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long val) {
/* 18 */     return val ^ 0xFFFFFFFFFFFFFFFFL;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double val) {
/* 22 */     return ((long)val ^ 0xFFFFFFFFFFFFFFFFL);
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 26 */     return this.share.oper.bitNot(this.exp.evalObject());
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\BitNotExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */