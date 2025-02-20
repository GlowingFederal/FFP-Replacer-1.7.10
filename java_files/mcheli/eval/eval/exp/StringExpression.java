/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ import mcheli.eval.util.CharUtil;
/*    */ import mcheli.eval.util.NumberUtil;
/*    */ 
/*    */ public class StringExpression
/*    */   extends WordExpression {
/*    */   public static AbstractExpression create(Lex lex, int prio) {
/* 11 */     String str = lex.getWord();
/* 12 */     str = CharUtil.escapeString(str, 1, str.length() - 2);
/* 13 */     StringExpression exp = new StringExpression(str);
/* 14 */     exp.setPos(lex.getString(), lex.getPos());
/* 15 */     exp.setPriority(prio);
/* 16 */     exp.share = lex.getShare();
/* 17 */     return exp;
/*    */   }
/*    */   
/*    */   public StringExpression(String str) {
/* 21 */     super(str);
/* 22 */     setOperator("\"");
/* 23 */     setEndOperator("\"");
/*    */   }
/*    */   
/*    */   protected StringExpression(StringExpression from, ShareExpValue s) {
/* 27 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 31 */     return new StringExpression(this, s);
/*    */   }
/*    */   
/*    */   public static StringExpression create(AbstractExpression from, String word) {
/* 35 */     StringExpression n = new StringExpression(word);
/* 36 */     n.string = from.string;
/* 37 */     n.pos = from.pos;
/* 38 */     n.prio = from.prio;
/* 39 */     n.share = from.share;
/* 40 */     return n;
/*    */   }
/*    */   
/*    */   public long evalLong() {
/*    */     try {
/* 45 */       return NumberUtil.parseLong(this.word);
/* 46 */     } catch (Exception var4) {
/*    */       try {
/* 48 */         return Long.parseLong(this.word);
/* 49 */       } catch (Exception var3) {
/*    */         try {
/* 51 */           return (long)Double.parseDouble(this.word);
/* 52 */         } catch (Exception var2) {
/* 53 */           throw new EvalException(2003, this.word, this.string, this.pos, var2);
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public double evalDouble() {
/*    */     try {
/* 61 */       return Double.parseDouble(this.word);
/* 62 */     } catch (Exception var4) {
/*    */       try {
/* 64 */         return NumberUtil.parseLong(this.word);
/* 65 */       } catch (Exception var3) {
/* 66 */         throw new EvalException(2003, this.word, this.string, this.pos, var4);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 72 */     return this.word;
/*    */   }
/*    */   
/*    */   public boolean equals(Object obj) {
/* 76 */     if (obj instanceof StringExpression) {
/* 77 */       StringExpression e = (StringExpression)obj;
/* 78 */       return this.word.equals(e.word);
/*    */     } 
/* 80 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public int hashCode() {
/* 85 */     return this.word.hashCode();
/*    */   }
/*    */   
/*    */   public String toString() {
/* 89 */     StringBuffer sb = new StringBuffer();
/* 90 */     sb.append(getOperator());
/* 91 */     sb.append(this.word);
/* 92 */     sb.append(getEndOperator());
/* 93 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\StringExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */