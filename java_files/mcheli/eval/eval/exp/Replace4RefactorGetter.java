/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import mcheli.eval.eval.Rule;
/*    */ import mcheli.eval.eval.ref.Refactor;
/*    */ import mcheli.eval.eval.repl.ReplaceAdapter;
/*    */ import mcheli.eval.eval.rule.ShareRuleValue;
/*    */ 
/*    */ public class Replace4RefactorGetter
/*    */   extends ReplaceAdapter
/*    */ {
/*    */   protected Refactor ref;
/*    */   protected ShareRuleValue rule;
/*    */   
/*    */   Replace4RefactorGetter(Refactor ref, Rule rule) {
/* 15 */     this.ref = ref;
/* 16 */     this.rule = (ShareRuleValue)rule;
/*    */   }
/*    */   
/*    */   protected AbstractExpression var(VariableExpression exp) {
/* 20 */     String name = this.ref.getNewName(null, exp.getWord());
/* 21 */     return (name == null) ? exp : this.rule.parse(name, exp.share);
/*    */   }
/*    */   
/*    */   protected AbstractExpression field(FieldExpression exp) {
/* 25 */     AbstractExpression exp1 = exp.expl;
/* 26 */     Object obj = exp1.getVariable();
/* 27 */     if (obj == null) {
/* 28 */       return exp;
/*    */     }
/* 30 */     AbstractExpression exp2 = exp.expr;
/* 31 */     String name = this.ref.getNewName(obj, exp2.getWord());
/* 32 */     if (name == null) {
/* 33 */       return exp;
/*    */     }
/* 35 */     exp.expr = this.rule.parse(name, exp2.share);
/* 36 */     return exp;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   public AbstractExpression replace0(WordExpression exp) {
/* 42 */     return (exp instanceof VariableExpression) ? var((VariableExpression)exp) : exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replace2(Col2OpeExpression exp) {
/* 46 */     return (exp instanceof FieldExpression) ? field((FieldExpression)exp) : exp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\Replace4RefactorGetter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */