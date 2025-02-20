/*    */ package mcheli.eval.eval.rule;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ import mcheli.eval.eval.exp.AbstractExpression;
/*    */ import mcheli.eval.eval.exp.Col1Expression;
/*    */ import mcheli.eval.eval.exp.Col2Expression;
/*    */ import mcheli.eval.eval.exp.FunctionExpression;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ 
/*    */ public class Col1AfterRule
/*    */   extends AbstractRule
/*    */ {
/*    */   public AbstractExpression func;
/*    */   public AbstractExpression array;
/*    */   public AbstractExpression field;
/*    */   
/*    */   public Col1AfterRule(ShareRuleValue share) {
/* 18 */     super(share);
/*    */   }
/*    */   
/*    */   public AbstractExpression parse(Lex lex) {
/* 22 */     AbstractExpression x = this.nextRule.parse(lex); while (true) {
/*    */       String ope;
/*    */       int pos;
/* 25 */       switch (lex.getType()) {
/*    */         case 2147483634:
/* 27 */           ope = lex.getOperator();
/* 28 */           pos = lex.getPos();
/* 29 */           if (!isMyOperator(ope)) {
/* 30 */             return x;
/*    */           }
/*    */           
/* 33 */           if (lex.isOperator(this.func.getOperator())) {
/* 34 */             x = parseFunc(lex, x); continue;
/* 35 */           }  if (lex.isOperator(this.array.getOperator())) {
/* 36 */             x = parseArray(lex, x, ope, pos); continue;
/* 37 */           }  if (lex.isOperator(this.field.getOperator())) {
/* 38 */             x = parseField(lex, x, ope, pos); continue;
/*    */           } 
/* 40 */           x = Col1Expression.create(newExpression(ope, lex.getShare()), lex.getString(), pos, x);
/* 41 */           lex.next(); continue;
/*    */       } 
/*    */       break;
/*    */     } 
/* 45 */     return x;
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected AbstractExpression parseFunc(Lex lex, AbstractExpression x) {
/* 51 */     AbstractExpression a = null;
/* 52 */     lex.next();
/* 53 */     if (!lex.isOperator(this.func.getEndOperator())) {
/* 54 */       a = this.share.funcArgRule.parse(lex);
/* 55 */       if (!lex.isOperator(this.func.getEndOperator())) {
/* 56 */         throw new EvalException(1001, new String[] { this.func.getEndOperator() }, lex);
/*    */       }
/*    */     } 
/*    */     
/* 60 */     lex.next();
/* 61 */     x = FunctionExpression.create(x, a, this.prio, lex.getShare());
/* 62 */     return x;
/*    */   }
/*    */   
/*    */   protected AbstractExpression parseArray(Lex lex, AbstractExpression x, String ope, int pos) {
/* 66 */     AbstractExpression y = this.share.topRule.parse(lex.next());
/* 67 */     if (!lex.isOperator(this.array.getEndOperator())) {
/* 68 */       throw new EvalException(1001, new String[] { this.array.getEndOperator() }, lex);
/*    */     }
/* 70 */     lex.next();
/* 71 */     x = Col2Expression.create(newExpression(ope, lex.getShare()), lex.getString(), pos, x, y);
/* 72 */     return x;
/*    */   }
/*    */ 
/*    */   
/*    */   protected AbstractExpression parseField(Lex lex, AbstractExpression x, String ope, int pos) {
/* 77 */     AbstractExpression y = this.nextRule.parse(lex.next());
/* 78 */     x = Col2Expression.create(newExpression(ope, lex.getShare()), lex.getString(), pos, x, y);
/* 79 */     return x;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\rule\Col1AfterRule.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */