/*    */ package mcheli.eval.eval.rule;
/*    */ 
/*    */ import mcheli.eval.eval.ExpRuleFactory;
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ 
/*    */ public class JavaRuleFactory
/*    */   extends ExpRuleFactory
/*    */ {
/*    */   private static JavaRuleFactory me;
/*    */   
/*    */   public static ExpRuleFactory getInstance() {
/* 12 */     if (me == null) {
/* 13 */       me = new JavaRuleFactory();
/*    */     }
/*    */     
/* 16 */     return me;
/*    */   }
/*    */   
/*    */   protected AbstractRule createCommaRule(ShareRuleValue share) {
/* 20 */     return null;
/*    */   }
/*    */   
/*    */   protected AbstractRule createPowerRule(ShareRuleValue share) {
/* 24 */     return null;
/*    */   }
/*    */   
/*    */   protected AbstractExpression createLetPowerExpression() {
/* 28 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\rule\JavaRuleFactory.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */