/*    */ package mcheli.eval.eval.rule;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ import mcheli.eval.eval.exp.Col1Expression;
/*    */ import mcheli.eval.eval.exp.StringExpression;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ 
/*    */ public class PrimaryRule extends AbstractRule {
/* 10 */   public PrimaryRule(ShareRuleValue share) { super(share); } public final AbstractExpression parse(Lex lex) { AbstractExpression w; AbstractExpression n; String ope;
/*    */     int pos;
/*    */     AbstractExpression s;
/*    */     AbstractExpression c;
/* 14 */     switch (lex.getType())
/*    */     { case 2147483632:
/* 16 */         w = VariableExpression.create(lex, this.prio);
/* 17 */         lex.next();
/* 18 */         return w;
/*    */       case 2147483633:
/* 20 */         n = NumberExpression.create(lex, this.prio);
/* 21 */         lex.next();
/* 22 */         return n;
/*    */       case 2147483634:
/* 24 */         ope = lex.getOperator();
/* 25 */         pos = lex.getPos();
/* 26 */         if (isMyOperator(ope)) {
/* 27 */           if (ope.equals(this.share.paren.getOperator())) {
/* 28 */             return parseParen(lex, ope, pos);
/*    */           }
/*    */           
/* 31 */           return Col1Expression.create(newExpression(ope, lex.getShare()), lex.getString(), pos, parse(lex.next()));
/*    */         } 
/*    */         
/* 34 */         throw new EvalException(1002, lex);
/*    */       case 2147483635:
/* 36 */         s = StringExpression.create(lex, this.prio);
/* 37 */         lex.next();
/* 38 */         return s;
/*    */       case 2147483636:
/* 40 */         c = CharExpression.create(lex, this.prio);
/* 41 */         lex.next();
/* 42 */         return c;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/*    */       default:
/* 54 */         throw new EvalException(1003, lex);
/*    */       case 2147483647:
/* 56 */         break; }  throw new EvalException(1004, lex); }
/*    */ 
/*    */ 
/*    */   
/*    */   protected AbstractExpression parseParen(Lex lex, String ope, int pos) {
/* 61 */     AbstractExpression s = this.share.topRule.parse(lex.next());
/* 62 */     if (!lex.isOperator(this.share.paren.getEndOperator())) {
/* 63 */       throw new EvalException(1001, new String[] { this.share.paren.getEndOperator() }, lex);
/*    */     }
/* 65 */     lex.next();
/* 66 */     return Col1Expression.create(newExpression(ope, lex.getShare()), lex.getString(), pos, s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\rule\PrimaryRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */