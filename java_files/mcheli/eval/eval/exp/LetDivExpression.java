/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public class LetDivExpression
/*    */   extends DivExpression {
/*    */   public LetDivExpression() {
/*  6 */     setOperator("/=");
/*    */   }
/*    */   
/*    */   protected LetDivExpression(LetDivExpression from, ShareExpValue s) {
/* 10 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 14 */     return new LetDivExpression(this, s);
/*    */   }
/*    */   
/*    */   public long evalLong() {
/* 18 */     long val = super.evalLong();
/* 19 */     this.expl.let(val, this.pos);
/* 20 */     return val;
/*    */   }
/*    */   
/*    */   public double evalDouble() {
/* 24 */     double val = super.evalDouble();
/* 25 */     this.expl.let(val, this.pos);
/* 26 */     return val;
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 30 */     Object val = super.evalObject();
/* 31 */     this.expl.let(val, this.pos);
/* 32 */     return val;
/*    */   }
/*    */   
/*    */   protected AbstractExpression replace() {
/* 36 */     this.expl = this.expl.replaceVar();
/* 37 */     this.expr = this.expr.replace();
/* 38 */     return this.share.repl.replaceLet(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\LetDivExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */