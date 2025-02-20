/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class ShiftRightLogicalExpression
/*    */   extends Col2Expression {
/*    */   public ShiftRightLogicalExpression() {
/*  6 */     setOperator(">>>");
/*    */   }
/*    */   
/*    */   protected ShiftRightLogicalExpression(ShiftRightLogicalExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new ShiftRightLogicalExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long vl, long vr) {
/* 18 */     return vl >>> (int)vr;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double vl, double vr) {
/* 22 */     if (vl < 0.0D) {
/* 23 */       vl = -vl;
/*    */     }
/*    */     
/* 26 */     return vl / Math.pow(2.0D, vr);
/*    */   }
/*    */   
/*    */   protected Object operateObject(Object vl, Object vr) {
/* 30 */     return this.share.oper.shiftRightLogical(vl, vr);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\ShiftRightLogicalExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */