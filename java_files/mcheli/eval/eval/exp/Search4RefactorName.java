/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ import mcheli.eval.eval.ref.Refactor;
/*    */ import mcheli.eval.eval.srch.SearchAdapter;
/*    */ 
/*    */ public class Search4RefactorName
/*    */   extends SearchAdapter
/*    */ {
/*    */   protected Refactor ref;
/*    */   
/*    */   Search4RefactorName(Refactor ref) {
/* 13 */     this.ref = ref;
/*    */   }
/*    */   
/*    */   public void search0(WordExpression exp) {
/* 17 */     if (exp instanceof VariableExpression) {
/* 18 */       String name = this.ref.getNewName(null, exp.getWord());
/* 19 */       if (name != null) {
/* 20 */         exp.setWord(name);
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean search2_2(Col2Expression exp) {
/* 27 */     if (exp instanceof FieldExpression) {
/* 28 */       AbstractExpression exp1 = exp.expl;
/* 29 */       Object obj = exp1.getVariable();
/* 30 */       if (obj == null) {
/* 31 */         throw new EvalException(2104, toString(), exp1.string, exp1.pos, (Throwable)null);
/*    */       }
/* 33 */       AbstractExpression exp2 = exp.expr;
/* 34 */       String name = this.ref.getNewName(obj, exp2.getWord());
/* 35 */       if (name != null) {
/* 36 */         exp2.setWord(name);
/*    */       }
/*    */       
/* 39 */       return true;
/*    */     } 
/*    */     
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public boolean searchFunc_2(FunctionExpression exp) {
/* 47 */     Object obj = null;
/* 48 */     if (exp.target != null) {
/* 49 */       obj = exp.target.getVariable();
/*    */     }
/*    */     
/* 52 */     String name = this.ref.getNewFuncName(obj, exp.name);
/* 53 */     if (name != null) {
/* 54 */       exp.name = name;
/*    */     }
/*    */     
/* 57 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\Search4RefactorName.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */