/*    */ package mcheli.eval.eval.rule;
/*    */ 
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ import mcheli.eval.eval.exp.Col1Expression;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ 
/*    */ public class SignRule
/*    */   extends AbstractRule {
/*    */   public SignRule(ShareRuleValue share) {
/* 10 */     super(share);
/*    */   }
/*    */   public AbstractExpression parse(Lex lex) {
/*    */     String ope;
/* 14 */     switch (lex.getType()) {
/*    */       case 2147483634:
/* 16 */         ope = lex.getOperator();
/* 17 */         if (isMyOperator(ope)) {
/* 18 */           int pos = lex.getPos();
/* 19 */           return Col1Expression.create(newExpression(ope, lex.getShare()), lex.getString(), pos, parse(lex.next()));
/*    */         } 
/*    */         
/* 22 */         return this.nextRule.parse(lex);
/*    */     } 
/* 24 */     return this.nextRule.parse(lex);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\rule\SignRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */