/*    */ package mcheli.eval.eval.rule;
/*    */ 
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ import mcheli.eval.eval.exp.Col2Expression;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ 
/*    */ public class Col2Rule
/*    */   extends AbstractRule {
/*    */   public Col2Rule(ShareRuleValue share) {
/* 10 */     super(share);
/*    */   }
/*    */   
/*    */   protected AbstractExpression parse(Lex lex) {
/* 14 */     AbstractExpression x = this.nextRule.parse(lex); while (true) {
/*    */       String ope; int pos;
/*    */       AbstractExpression y;
/* 17 */       switch (lex.getType()) {
/*    */         case 2147483634:
/* 19 */           ope = lex.getOperator();
/* 20 */           if (!isMyOperator(ope)) {
/* 21 */             return x;
/*    */           }
/*    */           
/* 24 */           pos = lex.getPos();
/* 25 */           y = this.nextRule.parse(lex.next());
/* 26 */           x = Col2Expression.create(newExpression(ope, lex.getShare()), lex.getString(), pos, x, y); continue;
/*    */       }  break;
/*    */     } 
/* 29 */     return x;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\rule\Col2Rule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */