/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class CommaExpression
/*    */   extends Col2OpeExpression {
/*    */   public CommaExpression() {
/*  6 */     setOperator(",");
/*    */   }
/*    */   
/*    */   protected CommaExpression(CommaExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new CommaExpression(this, s);
/*    */   }
/*    */   
/*    */   public long evalLong() {
/* 18 */     this.expl.evalLong();
/* 19 */     return this.expr.evalLong();
/*    */   }
/*    */   
/*    */   public double evalDouble() {
/* 23 */     this.expl.evalDouble();
/* 24 */     return this.expr.evalDouble();
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 28 */     this.expl.evalObject();
/* 29 */     return this.expr.evalObject();
/*    */   }
/*    */   
/*    */   protected String toStringLeftSpace() {
/* 33 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\CommaExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */