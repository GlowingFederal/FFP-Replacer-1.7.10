/*     */ package mcheli.eval.eval.exp;
/*     */ 
/*     */ import java.util.List;
/*     */ import mcheli.eval.eval.EvalException;
/*     */ 
/*     */ 
/*     */ public abstract class AbstractExpression
/*     */ {
/*     */   public static final int TRUE = 1;
/*     */   public static final int FALSE = 0;
/*  11 */   protected String string = null;
/*  12 */   protected int pos = -1;
/*     */   
/*     */   private String ope1;
/*     */   private String ope2;
/*     */   public ShareExpValue share;
/*     */   protected int prio;
/*     */   
/*     */   protected final boolean isTrue(boolean lng) {
/*  20 */     return lng ? ((evalLong() != 0L)) : ((evalDouble() != 0.0D));
/*     */   }
/*     */   
/*     */   protected AbstractExpression() {}
/*     */   
/*     */   protected AbstractExpression(AbstractExpression from, ShareExpValue s) {
/*  26 */     this.string = from.string;
/*  27 */     this.pos = from.pos;
/*  28 */     this.prio = from.prio;
/*  29 */     if (s != null) {
/*  30 */       this.share = s;
/*     */     } else {
/*  32 */       this.share = from.share;
/*     */     } 
/*     */     
/*  35 */     this.ope1 = from.ope1;
/*  36 */     this.ope2 = from.ope2;
/*     */   }
/*     */   
/*     */   public abstract AbstractExpression dup(ShareExpValue paramShareExpValue);
/*     */   
/*     */   public final String getOperator() {
/*  42 */     return this.ope1;
/*     */   }
/*     */   
/*     */   public final String getEndOperator() {
/*  46 */     return this.ope2;
/*     */   }
/*     */   
/*     */   public final void setOperator(String ope) {
/*  50 */     this.ope1 = ope;
/*     */   }
/*     */   
/*     */   public final void setEndOperator(String ope) {
/*  54 */     this.ope2 = ope;
/*     */   }
/*     */   
/*     */   protected String getWord() {
/*  58 */     return getOperator();
/*     */   }
/*     */   
/*     */   protected void setWord(String word) {
/*  62 */     throw new EvalException(2001, word, this.string, this.pos, (Throwable)null);
/*     */   }
/*     */   
/*     */   protected abstract int getCols();
/*     */   
/*     */   protected final void setPos(String string, int pos) {
/*  68 */     this.string = string;
/*  69 */     this.pos = pos;
/*     */   }
/*     */   
/*     */   protected abstract int getFirstPos();
/*     */   
/*     */   public final void setPriority(int prio) {
/*  75 */     this.prio = prio;
/*     */   }
/*     */   
/*     */   protected final int getPriority() {
/*  79 */     return this.prio;
/*     */   }
/*     */   
/*     */   protected void let(Object val, int pos) {
/*  83 */     throw new EvalException(2004, toString(), this.string, pos, (Throwable)null);
/*     */   }
/*     */   
/*     */   protected void let(long val, int pos) {
/*  87 */     let(new Long(val), pos);
/*     */   }
/*     */   
/*     */   protected void let(double val, int pos) {
/*  91 */     let(new Double(val), pos);
/*     */   }
/*     */   
/*     */   protected Object getVariable() {
/*  95 */     String word = toString();
/*  96 */     throw new EvalException(2002, word, this.string, this.pos, (Throwable)null);
/*     */   }
/*     */   
/*     */   protected void evalArgsLong(List<Long> args) {
/* 100 */     args.add(new Long(evalLong()));
/*     */   }
/*     */   
/*     */   protected void evalArgsDouble(List<Double> args) {
/* 104 */     args.add(new Double(evalDouble()));
/*     */   }
/*     */   
/*     */   protected void evalArgsObject(List<Object> args) {
/* 108 */     args.add(evalObject());
/*     */   }
/*     */   
/*     */   public abstract long evalLong();
/*     */   
/*     */   public abstract double evalDouble();
/*     */   
/*     */   public abstract Object evalObject();
/*     */   
/*     */   protected abstract void search();
/*     */   
/*     */   protected abstract AbstractExpression replace();
/*     */   
/*     */   protected abstract AbstractExpression replaceVar();
/*     */   
/*     */   public abstract boolean equals(Object paramObject);
/*     */   
/*     */   public abstract int hashCode();
/*     */   
/*     */   public boolean same(AbstractExpression exp) {
/* 128 */     return (same(getOperator(), exp.getOperator()) && same(getEndOperator(), exp.getEndOperator()) && equals(exp));
/*     */   }
/*     */   
/*     */   private static boolean same(String str1, String str2) {
/* 132 */     return (str1 == null) ? ((str2 == null)) : str1.equals(str2);
/*     */   }
/*     */   
/*     */   public abstract void dump(int paramInt);
/*     */   
/*     */   public abstract String toString();
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\AbstractExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */