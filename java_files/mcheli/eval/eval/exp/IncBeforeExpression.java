/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class IncBeforeExpression
/*    */   extends Col1Expression {
/*    */   public IncBeforeExpression() {
/*  6 */     setOperator("++");
/*    */   }
/*    */   
/*    */   protected IncBeforeExpression(IncBeforeExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new IncBeforeExpression(this, s);
/*    */   }
/*    */   
/*    */   protected long operateLong(long val) {
/* 18 */     val++;
/* 19 */     this.exp.let(val, this.pos);
/* 20 */     return val;
/*    */   }
/*    */   
/*    */   protected double operateDouble(double val) {
/* 24 */     val++;
/* 25 */     this.exp.let(val, this.pos);
/* 26 */     return val;
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 30 */     Object val = this.exp.evalObject();
/* 31 */     val = this.share.oper.inc(val, 1);
/* 32 */     this.exp.let(val, this.pos);
/* 33 */     return val;
/*    */   }
/*    */   
/*    */   protected AbstractExpression replace() {
/* 37 */     this.exp = this.exp.replaceVar();
/* 38 */     return this.share.repl.replaceVar1(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\IncBeforeExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */