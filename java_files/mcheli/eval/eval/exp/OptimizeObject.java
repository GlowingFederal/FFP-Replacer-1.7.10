/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import mcheli.eval.eval.repl.ReplaceAdapter;
/*    */ 
/*    */ public class OptimizeObject
/*    */   extends ReplaceAdapter {
/*    */   protected boolean isConst(AbstractExpression x) {
/*  8 */     return (x instanceof NumberExpression || x instanceof StringExpression || x instanceof CharExpression);
/*    */   }
/*    */   
/*    */   protected boolean isTrue(AbstractExpression x) {
/* 12 */     return (x.evalLong() != 0L);
/*    */   }
/*    */   
/*    */   protected AbstractExpression toConst(AbstractExpression exp) {
/*    */     try {
/* 17 */       Object e = exp.evalObject();
/* 18 */       return (e instanceof String) ? StringExpression.create(exp, (String)e) : ((e instanceof Character) ? CharExpression.create(exp, e.toString()) : NumberExpression.create(exp, e.toString()));
/* 19 */     } catch (Exception var3) {
/* 20 */       return exp;
/*    */     } 
/*    */   }
/*    */   
/*    */   public AbstractExpression replace0(WordExpression exp) {
/* 25 */     return (exp instanceof VariableExpression) ? toConst(exp) : exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replace1(Col1Expression exp) {
/* 29 */     return (exp instanceof ParenExpression) ? exp.exp : ((exp instanceof SignPlusExpression) ? exp.exp : (isConst(exp.exp) ? toConst(exp) : exp));
/*    */   }
/*    */   
/*    */   public AbstractExpression replace2(Col2Expression exp) {
/* 33 */     boolean const_l = isConst(exp.expl);
/* 34 */     boolean const_r = isConst(exp.expr);
/* 35 */     return (const_l && const_r) ? toConst(exp) : exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replace2(Col2OpeExpression exp) {
/* 39 */     if (exp instanceof ArrayExpression)
/* 40 */       return isConst(exp.expr) ? toConst(exp) : exp; 
/* 41 */     if (exp instanceof FieldExpression) {
/* 42 */       return toConst(exp);
/*    */     }
/* 44 */     boolean const_l = isConst(exp.expl);
/* 45 */     return (exp instanceof AndExpression) ? (const_l ? (isTrue(exp.expl) ? exp.expr : exp.expl) : exp) : ((exp instanceof OrExpression) ? (const_l ? (isTrue(exp.expl) ? exp.expl : exp.expr) : exp) : ((exp instanceof CommaExpression) ? (const_l ? exp.expr : exp) : exp));
/*    */   }
/*    */ 
/*    */   
/*    */   public AbstractExpression replace3(Col3Expression exp) {
/* 50 */     return isConst(exp.exp1) ? (isTrue(exp.exp1) ? exp.exp2 : exp.exp3) : exp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\OptimizeObject.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */