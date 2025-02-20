/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ import mcheli.eval.eval.lex.Lex;
/*    */ 
/*    */ public class VariableExpression
/*    */   extends WordExpression {
/*    */   public static AbstractExpression create(Lex lex, int prio) {
/*  9 */     VariableExpression exp = new VariableExpression(lex.getWord());
/* 10 */     exp.setPos(lex.getString(), lex.getPos());
/* 11 */     exp.setPriority(prio);
/* 12 */     exp.share = lex.getShare();
/* 13 */     return exp;
/*    */   }
/*    */   
/*    */   public VariableExpression(String str) {
/* 17 */     super(str);
/*    */   }
/*    */   
/*    */   protected VariableExpression(VariableExpression from, ShareExpValue s) {
/* 21 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 25 */     return new VariableExpression(this, s);
/*    */   }
/*    */   
/*    */   public long evalLong() {
/*    */     try {
/* 30 */       return this.share.var.evalLong(getVarValue());
/* 31 */     } catch (EvalException var2) {
/* 32 */       throw var2;
/* 33 */     } catch (Exception var3) {
/* 34 */       throw new EvalException(2003, this.word, this.string, this.pos, var3);
/*    */     } 
/*    */   }
/*    */   
/*    */   public double evalDouble() {
/*    */     try {
/* 40 */       return this.share.var.evalDouble(getVarValue());
/* 41 */     } catch (EvalException var2) {
/* 42 */       throw var2;
/* 43 */     } catch (Exception var3) {
/* 44 */       throw new EvalException(2003, this.word, this.string, this.pos, var3);
/*    */     } 
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 49 */     return getVarValue();
/*    */   }
/*    */   
/*    */   protected void let(Object val, int pos) {
/* 53 */     String name = getWord();
/*    */     
/*    */     try {
/* 56 */       this.share.var.setValue(name, val);
/* 57 */     } catch (EvalException var5) {
/* 58 */       throw var5;
/* 59 */     } catch (Exception var6) {
/* 60 */       throw new EvalException(2102, name, this.string, pos, var6);
/*    */     } 
/*    */   }
/*    */   private Object getVarValue() {
/*    */     Object val;
/* 65 */     String word = getWord();
/*    */ 
/*    */     
/*    */     try {
/* 69 */       val = this.share.var.getObject(word);
/* 70 */     } catch (EvalException var4) {
/* 71 */       throw var4;
/* 72 */     } catch (Exception var5) {
/* 73 */       throw new EvalException(2101, word, this.string, this.pos, var5);
/*    */     } 
/*    */     
/* 76 */     if (val == null) {
/* 77 */       throw new EvalException(2103, word, this.string, this.pos, (Throwable)null);
/*    */     }
/* 79 */     return val;
/*    */   }
/*    */ 
/*    */   
/*    */   protected Object getVariable() {
/*    */     try {
/* 85 */       return this.share.var.getObject(this.word);
/* 86 */     } catch (EvalException var2) {
/* 87 */       throw var2;
/* 88 */     } catch (Exception var3) {
/* 89 */       throw new EvalException(2002, this.word, this.string, this.pos, (Throwable)null);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\VariableExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */