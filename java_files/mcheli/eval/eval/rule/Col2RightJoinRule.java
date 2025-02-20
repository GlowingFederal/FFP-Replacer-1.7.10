/*    */ package mcheli.eval.eval.rule;
/*    */ 
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ import mcheli.eval.eval.exp.Col2Expression;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ 
/*    */ public class Col2RightJoinRule
/*    */   extends AbstractRule {
/*    */   public Col2RightJoinRule(ShareRuleValue share) {
/* 10 */     super(share);
/*    */   }
/*    */   protected AbstractExpression parse(Lex lex) {
/*    */     String ope;
/* 14 */     AbstractExpression x = this.nextRule.parse(lex);
/* 15 */     switch (lex.getType()) {
/*    */       case 2147483634:
/* 17 */         ope = lex.getOperator();
/* 18 */         if (isMyOperator(ope)) {
/* 19 */           int pos = lex.getPos();
/* 20 */           AbstractExpression y = parse(lex.next());
/* 21 */           x = Col2Expression.create(newExpression(ope, lex.getShare()), lex.getString(), pos, x, y);
/*    */         } 
/*    */         
/* 24 */         return x;
/*    */     } 
/* 26 */     return x;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\rule\Col2RightJoinRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */