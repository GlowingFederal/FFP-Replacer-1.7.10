/*    */ package mcheli.eval.eval.exp;
/*    */ 
/*    */ import mcheli.eval.eval.EvalException;
/*    */ 
/*    */ public class ArrayExpression
/*    */   extends Col2OpeExpression {
/*    */   public ArrayExpression() {
/*  8 */     setOperator("[");
/*  9 */     setEndOperator("]");
/*    */   }
/*    */   
/*    */   protected ArrayExpression(ArrayExpression from, ShareExpValue s) {
/* 13 */     super(from, s);
/*    */   }
/*    */   
/*    */   public AbstractExpression dup(ShareExpValue s) {
/* 17 */     return new ArrayExpression(this, s);
/*    */   }
/*    */   
/*    */   public long evalLong() {
/*    */     try {
/* 22 */       return this.share.var.evalLong(getVariable());
/* 23 */     } catch (EvalException var2) {
/* 24 */       throw var2;
/* 25 */     } catch (Exception var3) {
/* 26 */       throw new EvalException(2201, toString(), this.string, this.pos, var3);
/*    */     } 
/*    */   }
/*    */   
/*    */   public double evalDouble() {
/*    */     try {
/* 32 */       return this.share.var.evalDouble(getVariable());
/* 33 */     } catch (EvalException var2) {
/* 34 */       throw var2;
/* 35 */     } catch (Exception var3) {
/* 36 */       throw new EvalException(2201, toString(), this.string, this.pos, var3);
/*    */     } 
/*    */   }
/*    */   
/*    */   public Object evalObject() {
/* 41 */     return getVariable();
/*    */   }
/*    */   
/*    */   protected Object getVariable() {
/* 45 */     Object obj = this.expl.getVariable();
/* 46 */     if (obj == null) {
/* 47 */       throw new EvalException(2104, this.expl.toString(), this.string, this.pos, (Throwable)null);
/*    */     }
/* 49 */     int index = (int)this.expr.evalLong();
/*    */     
/*    */     try {
/* 52 */       return this.share.var.getObject(obj, index);
/* 53 */     } catch (EvalException var4) {
/* 54 */       throw var4;
/* 55 */     } catch (Exception var5) {
/* 56 */       throw new EvalException(2201, toString(), this.string, this.pos, var5);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected void let(Object val, int pos) {
/* 62 */     Object obj = this.expl.getVariable();
/* 63 */     if (obj == null) {
/* 64 */       throw new EvalException(2104, this.expl.toString(), this.string, pos, (Throwable)null);
/*    */     }
/* 66 */     int index = (int)this.expr.evalLong();
/*    */     
/*    */     try {
/* 69 */       this.share.var.setValue(obj, index, val);
/* 70 */     } catch (EvalException var6) {
/* 71 */       throw var6;
/* 72 */     } catch (Exception var7) {
/* 73 */       throw new EvalException(2202, toString(), this.string, pos, var7);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected AbstractExpression replaceVar() {
/* 79 */     this.expl = this.expl.replaceVar();
/* 80 */     this.expr = this.expr.replace();
/* 81 */     return this.share.repl.replaceVar2(this);
/*    */   }
/*    */   
/*    */   public String toString() {
/* 85 */     StringBuffer sb = new StringBuffer();
/* 86 */     sb.append(this.expl.toString());
/* 87 */     sb.append('[');
/* 88 */     sb.append(this.expr.toString());
/* 89 */     sb.append(']');
/* 90 */     return sb.toString();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\ArrayExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */