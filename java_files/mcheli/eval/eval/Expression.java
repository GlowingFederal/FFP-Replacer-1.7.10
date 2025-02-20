/*    */ package mcheli.eval.eval;
/*    */ 
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ import mcheli.eval.eval.func.Function;
/*    */ import mcheli.eval.eval.oper.Operator;
/*    */ import mcheli.eval.eval.ref.Refactor;
/*    */ import mcheli.eval.eval.repl.Replace;
/*    */ import mcheli.eval.eval.srch.Search;
/*    */ import mcheli.eval.eval.var.Variable;
/*    */ 
/*    */ 
/*    */ public abstract class Expression
/*    */ {
/*    */   public Variable var;
/*    */   public Function func;
/*    */   public Operator oper;
/*    */   public Search srch;
/*    */   public Replace repl;
/*    */   protected AbstractExpression ae;
/*    */   
/*    */   public static Expression parse(String str) {
/* 22 */     return ExpRuleFactory.getDefaultRule().parse(str);
/*    */   }
/*    */   
/*    */   public void setVariable(Variable var) {
/* 26 */     this.var = var;
/*    */   }
/*    */   
/*    */   public void setFunction(Function func) {
/* 30 */     this.func = func;
/*    */   }
/*    */   
/*    */   public void setOperator(Operator oper) {
/* 34 */     this.oper = oper;
/*    */   }
/*    */   
/*    */   public abstract long evalLong();
/*    */   
/*    */   public abstract double evalDouble();
/*    */   
/*    */   public abstract Object eval();
/*    */   
/*    */   public abstract void optimizeLong(Variable paramVariable);
/*    */   
/*    */   public abstract void optimizeDouble(Variable paramVariable);
/*    */   
/*    */   public abstract void optimize(Variable paramVariable, Operator paramOperator);
/*    */   
/*    */   public abstract void search(Search paramSearch);
/*    */   
/*    */   public abstract void refactorName(Refactor paramRefactor);
/*    */   
/*    */   public abstract void refactorFunc(Refactor paramRefactor, Rule paramRule);
/*    */   
/*    */   public abstract Expression dup();
/*    */   
/*    */   public boolean equals(Object obj) {
/* 58 */     if (obj instanceof Expression) {
/* 59 */       AbstractExpression e = ((Expression)obj).ae;
/* 60 */       return (this.ae == null && e == null) ? true : ((this.ae != null && e != null) ? this.ae.equals(e) : false);
/*    */     } 
/* 62 */     return super.equals(obj);
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 67 */     return (this.ae == null) ? 0 : this.ae.hashCode();
/*    */   }
/*    */   
/*    */   public boolean same(Expression obj) {
/* 71 */     AbstractExpression e = obj.ae;
/* 72 */     return (this.ae == null) ? ((e == null)) : this.ae.same(e);
/*    */   }
/*    */   
/*    */   public boolean isEmpty() {
/* 76 */     return (this.ae == null);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 80 */     return (this.ae == null) ? "" : this.ae.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\Expression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */