/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class ShiftRightExpression
/*    */   extends Col2Expression {
/*    */   public ShiftRightExpression() {
/*  6 */     setOperator(">>");
/*    */   }
/*    */   
/*    */   protected ShiftRightExpression(ShiftRightExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new ShiftRightExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long vl, long vr) {
/* 18 */     return vl >> (int)vr;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double vl, double vr) {
/* 22 */     return vl / Math.pow(2.0D, vr);
/*    */   }
/*    */   
/*    */   protected Object operateObject(Object vl, Object vr) {
/* 26 */     return this.share.oper.shiftRight(vl, vr);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\ShiftRightExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */