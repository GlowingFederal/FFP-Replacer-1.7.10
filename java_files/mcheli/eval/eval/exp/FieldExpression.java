/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ 
/*    */ public class FieldExpression
/*    */   extends Col2OpeExpression {
/*    */   public FieldExpression() {
/*  8 */     setOperator(".");
/*    */   }
/*    */   
/*    */   protected FieldExpression(FieldExpression from, ShareExpValue s) {
/* 12 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 16 */     return new FieldExpression(this, s);
/*    */   }
/*    */   
/*    */   public long evalLong() {
/*    */     try {
/* 21 */       return this.share.var.evalLong(getVariable());
/* 22 */     } catch (EvalException var2) {
/* 23 */       throw var2;
/* 24 */     } catch (Exception var3) {
/* 25 */       throw new EvalException(2003, toString(), this.string, this.pos, var3);
/*    */     } 
/*    */   }
/*    */   
/*    */   public double evalDouble() {
/*    */     try {
/* 31 */       return this.share.var.evalDouble(getVariable());
/* 32 */     } catch (EvalException var2) {
/* 33 */       throw var2;
/* 34 */     } catch (Exception var3) {
/* 35 */       throw new EvalException(2003, toString(), this.string, this.pos, var3);
/*    */     } 
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 40 */     return getVariable();
/*    */   }
/*    */   
/*    */   protected Object getVariable() {
/* 44 */     Object obj = this.expl.getVariable();
/* 45 */     if (obj == null) {
/* 46 */       throw new EvalException(2104, this.expl.toString(), this.string, this.pos, (Throwable)null);
/*    */     }
/* 48 */     String word = this.expr.getWord();
/*    */     
/*    */     try {
/* 51 */       return this.share.var.getObject(obj, word);
/* 52 */     } catch (EvalException var4) {
/* 53 */       throw var4;
/* 54 */     } catch (Exception var5) {
/* 55 */       throw new EvalException(2301, toString(), this.string, this.pos, var5);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void let(Object val, int pos) {
/* 61 */     Object obj = this.expl.getVariable();
/* 62 */     if (obj == null) {
/* 63 */       throw new EvalException(2104, this.expl.toString(), this.string, pos, (Throwable)null);
/*    */     }
/* 65 */     String word = this.expr.getWord();
/*    */     
/*    */     try {
/* 68 */       this.share.var.setValue(obj, word, val);
/* 69 */     } catch (EvalException var6) {
/* 70 */       throw var6;
/* 71 */     } catch (Exception var7) {
/* 72 */       throw new EvalException(2302, toString(), this.string, pos, var7);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected AbstractExpression replace() {
/* 78 */     this.expl = this.expl.replaceVar();
/* 79 */     return this.share.repl.replace2(this);
/*    */   }
/*    */   
/*    */   protected AbstractExpression replaceVar() {
/* 83 */     this.expl = this.expl.replaceVar();
/* 84 */     return this.share.repl.replaceVar2(this);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 88 */     StringBuffer sb = new StringBuffer();
/* 89 */     sb.append(this.expl.toString());
/* 90 */     sb.append('.');
/* 91 */     sb.append(this.expr.toString());
/* 92 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\FieldExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */