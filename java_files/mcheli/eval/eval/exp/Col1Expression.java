/*     */ package mcheli.eval.eval.exp;
/*     */ 
/*     */ public abstract class Col1Expression
/*     */   extends AbstractExpression
/*     */ {
/*     */   protected AbstractExpression exp;
/*     */   
/*     */   public static AbstractExpression create(AbstractExpression exp, String string, int pos, AbstractExpression x) {
/*   9 */     Col1Expression n = (Col1Expression)exp;
/*  10 */     n.setExpression(x);
/*  11 */     n.setPos(string, pos);
/*  12 */     return n;
/*     */   }
/*     */   
/*     */   protected Col1Expression() {}
/*     */   
/*     */   protected Col1Expression(Col1Expression from, ShareExpValue s) {
/*  18 */     super(from, s);
/*  19 */     if (from.exp != null) {
/*  20 */       this.exp = from.exp.dup(s);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setExpression(AbstractExpression x) {
/*  26 */     this.exp = x;
/*     */   }
/*     */   
/*     */   protected final int getCols() {
/*  30 */     return 1;
/*     */   }
/*     */   
/*     */   protected final int getFirstPos() {
/*  34 */     return this.exp.getFirstPos();
/*     */   }
/*     */   
/*     */   public long evalLong() {
/*  38 */     return operateLong(this.exp.evalLong());
/*     */   }
/*     */   
/*     */   public double evalDouble() {
/*  42 */     return operateDouble(this.exp.evalDouble());
/*     */   }
/*     */   
/*     */   protected abstract long operateLong(long paramLong);
/*     */   
/*     */   protected abstract double operateDouble(double paramDouble);
/*     */   
/*     */   protected void search() {
/*  50 */     this.share.srch.search(this);
/*  51 */     if (!this.share.srch.end() && 
/*  52 */       !this.share.srch.search1_begin(this) && 
/*  53 */       !this.share.srch.end()) {
/*  54 */       this.exp.search();
/*  55 */       if (!this.share.srch.end()) {
/*  56 */         this.share.srch.search1_end(this);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractExpression replace() {
/*  64 */     this.exp = this.exp.replace();
/*  65 */     return this.share.repl.replace1(this);
/*     */   }
/*     */   
/*     */   protected AbstractExpression replaceVar() {
/*  69 */     this.exp = this.exp.replaceVar();
/*  70 */     return this.share.repl.replaceVar1(this);
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj) {
/*  74 */     if (obj instanceof Col1Expression) {
/*  75 */       Col1Expression e = (Col1Expression)obj;
/*  76 */       if (getClass() == e.getClass()) {
/*  77 */         if (this.exp == null) {
/*  78 */           return (e.exp == null);
/*     */         }
/*     */         
/*  81 */         if (e.exp == null) {
/*  82 */           return false;
/*     */         }
/*     */         
/*  85 */         return this.exp.equals(e.exp);
/*     */       } 
/*     */     } 
/*     */     
/*  89 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/*  93 */     return getClass().hashCode() ^ this.exp.hashCode();
/*     */   }
/*     */   
/*     */   public void dump(int n) {
/*  97 */     StringBuffer sb = new StringBuffer();
/*     */     
/*  99 */     for (int i = 0; i < n; i++) {
/* 100 */       sb.append(' ');
/*     */     }
/*     */     
/* 103 */     sb.append(getOperator());
/* 104 */     System.out.println(sb.toString());
/* 105 */     if (this.exp != null) {
/* 106 */       this.exp.dump(n + 1);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public String toString() {
/* 112 */     if (this.exp == null) {
/* 113 */       return getOperator();
/*     */     }
/* 115 */     StringBuffer sb = new StringBuffer();
/* 116 */     if (this.exp.getPriority() > this.prio) {
/* 117 */       sb.append(getOperator());
/* 118 */       sb.append(this.exp.toString());
/* 119 */     } else if (this.exp.getPriority() == this.prio) {
/* 120 */       sb.append(getOperator());
/* 121 */       sb.append(' ');
/* 122 */       sb.append(this.exp.toString());
/*     */     } else {
/* 124 */       sb.append(getOperator());
/* 125 */       sb.append(this.share.paren.getOperator());
/* 126 */       sb.append(this.exp.toString());
/* 127 */       sb.append(this.share.paren.getEndOperator());
/*     */     } 
/*     */     
/* 130 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\Col1Expression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */