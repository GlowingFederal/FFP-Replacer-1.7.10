/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ import mcheli.eval.util.CharUtil;
/*    */ 
/*    */ public class CharExpression
/*    */   extends WordExpression {
/*    */   public static AbstractExpression create(Lex lex, int prio) {
/* 10 */     String str = lex.getWord();
/* 11 */     str = CharUtil.escapeString(str, 1, str.length() - 2);
/* 12 */     CharExpression exp = new CharExpression(str);
/* 13 */     exp.setPos(lex.getString(), lex.getPos());
/* 14 */     exp.setPriority(prio);
/* 15 */     exp.share = lex.getShare();
/* 16 */     return exp;
/*    */   }
/*    */   
/*    */   public CharExpression(String str) {
/* 20 */     super(str);
/* 21 */     setOperator("'");
/* 22 */     setEndOperator("'");
/*    */   }
/*    */   
/*    */   protected CharExpression(CharExpression from, ShareExpValue s) {
/* 26 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 30 */     return new CharExpression(this, s);
/*    */   }
/*    */   
/*    */   public static CharExpression create(AbstractExpression from, String word) {
/* 34 */     CharExpression n = new CharExpression(word);
/* 35 */     n.string = from.string;
/* 36 */     n.pos = from.pos;
/* 37 */     n.prio = from.prio;
/* 38 */     n.share = from.share;
/* 39 */     return n;
/*    */   }
/*    */   
/*    */   public long evalLong() {
/*    */     try {
/* 44 */       return this.word.charAt(0);
/* 45 */     } catch (Exception var2) {
/* 46 */       throw new EvalException(2003, this.word, this.string, this.pos, var2);
/*    */     } 
/*    */   }
/*    */   
/*    */   public double evalDouble() {
/*    */     try {
/* 52 */       return this.word.charAt(0);
/* 53 */     } catch (Exception var2) {
/* 54 */       throw new EvalException(2003, this.word, this.string, this.pos, var2);
/*    */     } 
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 59 */     return new Character(this.word.charAt(0));
/*    */   }
/*    */   
/*    */   public String toString() {
/* 63 */     StringBuffer sb = new StringBuffer();
/* 64 */     sb.append(getOperator());
/* 65 */     sb.append(this.word);
/* 66 */     sb.append(getEndOperator());
/* 67 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\CharExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */