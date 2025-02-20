/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ import mcheli.eval.eval.ref.Refactor;
/*    */ import mcheli.eval.eval.repl.ReplaceAdapter;
/*    */ 
/*    */ public class Replace4RefactorName
/*    */   extends ReplaceAdapter
/*    */ {
/*    */   protected Refactor ref;
/*    */   
/*    */   Replace4RefactorName(Refactor ref) {
/* 13 */     this.ref = ref;
/*    */   }
/*    */   
/*    */   protected void var(VariableExpression exp) {
/* 17 */     String name = this.ref.getNewName(null, exp.getWord());
/* 18 */     if (name != null) {
/* 19 */       exp.setWord(name);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   protected void field(FieldExpression exp) {
/* 25 */     AbstractExpression exp1 = exp.expl;
/* 26 */     Object obj = exp1.getVariable();
/* 27 */     if (obj == null) {
/* 28 */       throw new EvalException(2104, toString(), exp1.string, exp1.pos, (Throwable)null);
/*    */     }
/* 30 */     AbstractExpression exp2 = exp.expr;
/* 31 */     String name = this.ref.getNewName(obj, exp2.getWord());
/* 32 */     if (name != null) {
/* 33 */       exp2.setWord(name);
/*    */     }
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func(FunctionExpression exp) {
/* 40 */     Object obj = null;
/* 41 */     if (exp.target != null) {
/* 42 */       obj = exp.target.getVariable();
/*    */     }
/*    */     
/* 45 */     String name = this.ref.getNewFuncName(obj, exp.name);
/* 46 */     if (name != null) {
/* 47 */       exp.name = name;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractExpression replace0(WordExpression exp) {
/* 53 */     if (exp instanceof VariableExpression) {
/* 54 */       var((VariableExpression)exp);
/*    */     }
/*    */     
/* 57 */     return exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replace2(Col2Expression exp) {
/* 61 */     if (exp instanceof FieldExpression) {
/* 62 */       field((FieldExpression)exp);
/*    */     }
/*    */     
/* 65 */     return exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replaceFunc(FunctionExpression exp) {
/* 69 */     func(exp);
/* 70 */     return exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replaceVar(AbstractExpression exp) {
/* 74 */     if (exp instanceof VariableExpression) {
/* 75 */       var((VariableExpression)exp);
/* 76 */     } else if (exp instanceof FieldExpression) {
/* 77 */       field((FieldExpression)exp);
/* 78 */     } else if (exp instanceof FunctionExpression) {
/* 79 */       func((FunctionExpression)exp);
/*    */     } 
/*    */     
/* 82 */     return exp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\Replace4RefactorName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */