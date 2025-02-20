/*    */ package mcheli.eval.eval.rule;
/*    */ 
/*    */ import java.util.List;
/*    */ import mcheli.eval.eval.EvalException;
/*    */ import mcheli.eval.eval.Expression;
/*    */ import mcheli.eval.eval.Rule;
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ import mcheli.eval.eval.exp.ShareExpValue;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ import mcheli.eval.eval.lex.LexFactory;
/*    */ import mcheli.eval.eval.oper.Operator;
/*    */ import mcheli.eval.eval.ref.Refactor;
/*    */ import mcheli.eval.eval.srch.Search;
/*    */ import mcheli.eval.eval.var.Variable;
/*    */ 
/*    */ public class ShareRuleValue
/*    */   extends Rule
/*    */ {
/*    */   public AbstractRule topRule;
/*    */   public AbstractRule funcArgRule;
/*    */   public LexFactory lexFactory;
/* 22 */   protected List[] opeList = new List[4];
/*    */   
/*    */   public AbstractExpression paren;
/*    */   
/*    */   public Expression parse(String str) {
/* 27 */     if (str == null)
/* 28 */       return null; 
/* 29 */     if (str.trim().length() <= 0) {
/* 30 */       return new EmptyExpression();
/*    */     }
/* 32 */     ShareExpValue exp = new ShareExpValue();
/* 33 */     AbstractExpression x = parse(str, exp);
/* 34 */     exp.setAbstractExpression(x);
/* 35 */     return (Expression)exp;
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractExpression parse(String str, ShareExpValue exp) {
/* 40 */     if (str == null) {
/* 41 */       return null;
/*    */     }
/* 43 */     Lex lex = this.lexFactory.create(str, this.opeList, this, exp);
/* 44 */     lex.check();
/* 45 */     AbstractExpression x = this.topRule.parse(lex);
/* 46 */     if (lex.getType() != Integer.MAX_VALUE) {
/* 47 */       throw new EvalException(1005, lex);
/*    */     }
/* 49 */     return x;
/*    */   }
/*    */ 
/*    */   
/*    */   class EmptyExpression
/*    */     extends Expression
/*    */   {
/*    */     public long evalLong() {
/* 57 */       return 0L;
/*    */     }
/*    */     
/*    */     public double evalDouble() {
/* 61 */       return 0.0D;
/*    */     }
/*    */     
/*    */     public Object eval() {
/* 65 */       return null;
/*    */     }
/*    */     
/*    */     public void optimizeLong(Variable var) {}
/*    */     
/*    */     public void optimizeDouble(Variable var) {}
/*    */     
/*    */     public void optimize(Variable var, Operator oper) {}
/*    */     
/*    */     public void search(Search srch) {}
/*    */     
/*    */     public void refactorName(Refactor ref) {}
/*    */     
/*    */     public void refactorFunc(Refactor ref, Rule rule) {}
/*    */     
/*    */     public Expression dup() {
/* 81 */       ShareRuleValue.this.getClass(); return new EmptyExpression();
/*    */     }
/*    */     
/*    */     public boolean same(Expression obj) {
/* 85 */       return obj instanceof EmptyExpression;
/*    */     }
/*    */     
/*    */     public String toString() {
/* 89 */       return "";
/*    */     }
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\rule\ShareRuleValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */