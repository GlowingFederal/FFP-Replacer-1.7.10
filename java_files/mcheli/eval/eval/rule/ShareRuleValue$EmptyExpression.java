/*    */ package mcheli.eval.eval.rule;
/*    */ 
/*    */ import mcheli.eval.eval.Expression;
/*    */ import mcheli.eval.eval.Rule;
/*    */ import mcheli.eval.eval.oper.Operator;
/*    */ import mcheli.eval.eval.ref.Refactor;
/*    */ import mcheli.eval.eval.srch.Search;
/*    */ import mcheli.eval.eval.var.Variable;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class EmptyExpression
/*    */   extends Expression
/*    */ {
/*    */   public long evalLong() {
/* 57 */     return 0L;
/*    */   }
/*    */   
/*    */   public double evalDouble() {
/* 61 */     return 0.0D;
/*    */   }
/*    */   
/*    */   public Object eval() {
/* 65 */     return null;
/*    */   }
/*    */   
/*    */   public void optimizeLong(Variable var) {}
/*    */   
/*    */   public void optimizeDouble(Variable var) {}
/*    */   
/*    */   public void optimize(Variable var, Operator oper) {}
/*    */   
/*    */   public void search(Search srch) {}
/*    */   
/*    */   public void refactorName(Refactor ref) {}
/*    */   
/*    */   public void refactorFunc(Refactor ref, Rule rule) {}
/*    */   
/*    */   public Expression dup() {
/* 81 */     ShareRuleValue.this.getClass(); return new EmptyExpression();
/*    */   }
/*    */   
/*    */   public boolean same(Expression obj) {
/* 85 */     return obj instanceof EmptyExpression;
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     return "";
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\rule\ShareRuleValue$EmptyExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */