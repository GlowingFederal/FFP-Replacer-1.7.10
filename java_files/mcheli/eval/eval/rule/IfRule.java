/*    */ package mcheli.eval.eval.rule;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ import mcheli.eval.eval.exp.Col3Expression;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ 
/*    */ public class IfRule
/*    */   extends AbstractRule
/*    */ {
/*    */   public AbstractExpression cond;
/*    */   
/*    */   public IfRule(ShareRuleValue share) {
/* 14 */     super(share);
/*    */   } protected AbstractExpression parse(Lex lex) {
/*    */     String ope;
/*    */     int pos;
/* 18 */     AbstractExpression x = this.nextRule.parse(lex);
/* 19 */     switch (lex.getType()) {
/*    */       case 2147483634:
/* 21 */         ope = lex.getOperator();
/* 22 */         pos = lex.getPos();
/* 23 */         if (isMyOperator(ope) && lex.isOperator(this.cond.getOperator())) {
/* 24 */           x = parseCond(lex, x, ope, pos);
/*    */         }
/*    */         
/* 27 */         return x;
/*    */     } 
/* 29 */     return x;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AbstractExpression parseCond(Lex lex, AbstractExpression x, String ope, int pos) {
/* 34 */     AbstractExpression y = parse(lex.next());
/* 35 */     if (!lex.isOperator(this.cond.getEndOperator())) {
/* 36 */       throw new EvalException(1001, new String[] { this.cond.getEndOperator() }, lex);
/*    */     }
/* 38 */     AbstractExpression z = parse(lex.next());
/* 39 */     x = Col3Expression.create(newExpression(ope, lex.getShare()), lex.getString(), pos, x, y, z);
/* 40 */     return x;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\rule\IfRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */