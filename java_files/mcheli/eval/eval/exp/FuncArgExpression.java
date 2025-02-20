/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import java.util.List;
/*    */ 
/*    */ public class FuncArgExpression
/*    */   extends Col2OpeExpression {
/*    */   public FuncArgExpression() {
/*  8 */     setOperator(",");
/*    */   }
/*    */   
/*    */   protected FuncArgExpression(FuncArgExpression from, ShareExpValue s) {
/* 12 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 16 */     return new FuncArgExpression(this, s);
/*    */   }
/*    */   
/*    */   protected void evalArgsLong(List args) {
/* 20 */     this.expl.evalArgsLong(args);
/* 21 */     this.expr.evalArgsLong(args);
/*    */   }
/*    */   
/*    */   protected void evalArgsDouble(List args) {
/* 25 */     this.expl.evalArgsDouble(args);
/* 26 */     this.expr.evalArgsDouble(args);
/*    */   }
/*    */   
/*    */   protected void evalArgsObject(List args) {
/* 30 */     this.expl.evalArgsObject(args);
/* 31 */     this.expr.evalArgsObject(args);
/*    */   }
/*    */   
/*    */   protected String toStringLeftSpace() {
/* 35 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\FuncArgExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */