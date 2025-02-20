/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ public abstract class Col2OpeExpression
/*    */   extends Col2Expression {
/*    */   protected Col2OpeExpression() {}
/*    */   
/*    */   protected Col2OpeExpression(Col2Expression from, ShareExpValue s) {
/*  8 */     super(from, s);
/*    */   }
/*    */   
/*    */   protected final long operateLong(long vl, long vr) {
/* 12 */     throw new RuntimeException("この関数が呼ばれてはいけない");
/*    */   }
/*    */   
/*    */   protected final double operateDouble(double vl, double vr) {
/* 16 */     throw new RuntimeException("この関数が呼ばれてはいけない");
/*    */   }
/*    */   
/*    */   protected final Object operateObject(Object vl, Object vr) {
/* 20 */     throw new RuntimeException("この関数が呼ばれてはいけない");
/*    */   }
/*    */   
/*    */   protected AbstractExpression replace() {
/* 24 */     this.expl = this.expl.replace();
/* 25 */     this.expr = this.expr.replace();
/* 26 */     return this.share.repl.replace2(this);
/*    */   }
/*    */   
/*    */   protected AbstractExpression replaceVar() {
/* 30 */     this.expl = this.expl.replaceVar();
/* 31 */     this.expr = this.expr.replaceVar();
/* 32 */     return this.share.repl.replaceVar2(this);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\Col2OpeExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */