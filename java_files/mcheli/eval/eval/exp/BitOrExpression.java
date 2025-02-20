/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class BitOrExpression
/*    */   extends Col2Expression {
/*    */   public BitOrExpression() {
/*  6 */     setOperator("|");
/*    */   }
/*    */   
/*    */   protected BitOrExpression(BitOrExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new BitOrExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long vl, long vr) {
/* 18 */     return vl | vr;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double vl, double vr) {
/* 22 */     return ((long)vl | (long)vr);
/*    */   }
/*    */   
/*    */   protected Object operateObject(Object vl, Object vr) {
/* 26 */     return this.share.oper.bitOr(vl, vr);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\BitOrExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */