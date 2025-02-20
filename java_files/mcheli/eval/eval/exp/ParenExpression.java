/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class ParenExpression
/*    */   extends Col1Expression {
/*    */   public ParenExpression() {
/*  6 */     setOperator("(");
/*  7 */     setEndOperator(")");
/*    */   }
/*    */   
/*    */   protected ParenExpression(ParenExpression from, ShareExpValue s) {
/* 11 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 15 */     return new ParenExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long val) {
/* 19 */     return val;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double val) {
/* 23 */     return val;
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 27 */     return this.exp.evalObject();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 31 */     return (this.exp == null) ? "" : (getOperator() + this.exp.toString() + getEndOperator());
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\ParenExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */