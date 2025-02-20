/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ import mcheli.eval.util.NumberUtil;
/*    */ 
/*    */ public class NumberExpression
/*    */   extends WordExpression {
/*    */   public static AbstractExpression create(Lex lex, int prio) {
/* 10 */     NumberExpression exp = new NumberExpression(lex.getWord());
/* 11 */     exp.setPos(lex.getString(), lex.getPos());
/* 12 */     exp.setPriority(prio);
/* 13 */     exp.share = lex.getShare();
/* 14 */     return exp;
/*    */   }
/*    */   
/*    */   public NumberExpression(String str) {
/* 18 */     super(str);
/*    */   }
/*    */   
/*    */   protected NumberExpression(NumberExpression from, ShareExpValue s) {
/* 22 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 26 */     return new NumberExpression(this, s);
/*    */   }
/*    */   
/*    */   public static NumberExpression create(AbstractExpression from, String word) {
/* 30 */     NumberExpression n = new NumberExpression(word);
/* 31 */     n.string = from.string;
/* 32 */     n.pos = from.pos;
/* 33 */     n.prio = from.prio;
/* 34 */     n.share = from.share;
/* 35 */     return n;
/*    */   }
/*    */   
/*    */   public long evalLong() {
/*    */     try {
/* 40 */       return NumberUtil.parseLong(this.word);
/* 41 */     } catch (Exception var4) {
/*    */       try {
/* 43 */         return Long.parseLong(this.word);
/* 44 */       } catch (Exception var3) {
/*    */         try {
/* 46 */           return (long)Double.parseDouble(this.word);
/* 47 */         } catch (Exception var2) {
/* 48 */           throw new EvalException(2003, this.word, this.string, this.pos, var2);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public double evalDouble() {
/*    */     try {
/* 56 */       return Double.parseDouble(this.word);
/* 57 */     } catch (Exception var4) {
/*    */       try {
/* 59 */         return NumberUtil.parseLong(this.word);
/* 60 */       } catch (Exception var3) {
/* 61 */         throw new EvalException(2003, this.word, this.string, this.pos, var4);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/*    */     try {
/* 68 */       return new Long(NumberUtil.parseLong(this.word));
/* 69 */     } catch (Exception var4) {
/*    */       try {
/* 71 */         return Long.valueOf(this.word);
/* 72 */       } catch (Exception var3) {
/*    */         try {
/* 74 */           return Double.valueOf(this.word);
/* 75 */         } catch (Exception var2) {
/* 76 */           throw new EvalException(2003, this.word, this.string, this.pos, var2);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\NumberExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */