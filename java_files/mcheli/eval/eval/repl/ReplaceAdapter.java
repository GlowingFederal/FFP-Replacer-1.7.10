/*    */ package mcheli.eval.eval.repl;
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ import mcheli.eval.eval.exp.Col1Expression;
/*    */ import mcheli.eval.eval.exp.Col2Expression;
/*    */ 
/*    */ public class ReplaceAdapter implements Replace {
/*    */   public AbstractExpression replace0(WordExpression exp) {
/*  8 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replace1(Col1Expression exp) {
/* 12 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replace2(Col2Expression exp) {
/* 16 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replace2(Col2OpeExpression exp) {
/* 20 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replace3(Col3Expression exp) {
/* 24 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replaceVar0(WordExpression exp) {
/* 28 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replaceVar1(Col1Expression exp) {
/* 32 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replaceVar2(Col2Expression exp) {
/* 36 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replaceVar2(Col2OpeExpression exp) {
/* 40 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replaceVar3(Col3Expression exp) {
/* 44 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replaceFunc(FunctionExpression exp) {
/* 48 */     return (AbstractExpression)exp;
/*    */   }
/*    */   
/*    */   public AbstractExpression replaceLet(Col2Expression exp) {
/* 52 */     return (AbstractExpression)exp;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\repl\ReplaceAdapter.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */