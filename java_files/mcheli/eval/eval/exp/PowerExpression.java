/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class PowerExpression
/*    */   extends Col2Expression {
/*    */   public PowerExpression() {
/*  6 */     setOperator("**");
/*    */   }
/*    */   
/*    */   protected PowerExpression(PowerExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new PowerExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long vl, long vr) {
/* 18 */     return (long)Math.pow(vl, vr);
/*    */   }
/*    */   
/*    */   protected double operateDouble(double vl, double vr) {
/* 22 */     return Math.pow(vl, vr);
/*    */   }
/*    */   
/*    */   protected Object operateObject(Object vl, Object vr) {
/* 26 */     return this.share.oper.power(vl, vr);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\PowerExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */