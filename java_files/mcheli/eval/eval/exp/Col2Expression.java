/*     */ package mcheli.eval.eval.exp;
/*     */ 
/*     */ public abstract class Col2Expression
/*     */   extends AbstractExpression
/*     */ {
/*     */   public AbstractExpression expl;
/*     */   public AbstractExpression expr;
/*     */   
/*     */   public static AbstractExpression create(AbstractExpression exp, String string, int pos, AbstractExpression x, AbstractExpression y) {
/*  10 */     Col2Expression n = (Col2Expression)exp;
/*  11 */     n.setExpression(x, y);
/*  12 */     n.setPos(string, pos);
/*  13 */     return n;
/*     */   }
/*     */   
/*     */   protected Col2Expression() {}
/*     */   
/*     */   protected Col2Expression(Col2Expression from, ShareExpValue s) {
/*  19 */     super(from, s);
/*  20 */     if (from.expl != null) {
/*  21 */       this.expl = from.expl.dup(s);
/*     */     }
/*     */     
/*  24 */     if (from.expr != null) {
/*  25 */       this.expr = from.expr.dup(s);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setExpression(AbstractExpression x, AbstractExpression y) {
/*  31 */     this.expl = x;
/*  32 */     this.expr = y;
/*     */   }
/*     */   
/*     */   protected final int getCols() {
/*  36 */     return 2;
/*     */   }
/*     */   
/*     */   protected final int getFirstPos() {
/*  40 */     return this.expl.getFirstPos();
/*     */   }
/*     */   
/*     */   public long evalLong() {
/*  44 */     return operateLong(this.expl.evalLong(), this.expr.evalLong());
/*     */   }
/*     */   
/*     */   public double evalDouble() {
/*  48 */     return operateDouble(this.expl.evalDouble(), this.expr.evalDouble());
/*     */   }
/*     */   
/*     */   public Object evalObject() {
/*  52 */     return operateObject(this.expl.evalObject(), this.expr.evalObject());
/*     */   }
/*     */   
/*     */   protected abstract long operateLong(long paramLong1, long paramLong2);
/*     */   
/*     */   protected abstract double operateDouble(double paramDouble1, double paramDouble2);
/*     */   
/*     */   protected abstract Object operateObject(Object paramObject1, Object paramObject2);
/*     */   
/*     */   protected void search() {
/*  62 */     this.share.srch.search(this);
/*  63 */     if (!this.share.srch.end() && 
/*  64 */       !this.share.srch.search2_begin(this) && 
/*  65 */       !this.share.srch.end()) {
/*  66 */       this.expl.search();
/*  67 */       if (!this.share.srch.end() && 
/*  68 */         !this.share.srch.search2_2(this) && 
/*  69 */         !this.share.srch.end()) {
/*  70 */         this.expr.search();
/*  71 */         if (!this.share.srch.end()) {
/*  72 */           this.share.srch.search2_end(this);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractExpression replace() {
/*  83 */     this.expl = this.expl.replace();
/*  84 */     this.expr = this.expr.replace();
/*  85 */     return this.share.repl.replace2(this);
/*     */   }
/*     */   
/*     */   protected AbstractExpression replaceVar() {
/*  89 */     this.expl = this.expl.replaceVar();
/*  90 */     this.expr = this.expr.replaceVar();
/*  91 */     return this.share.repl.replaceVar2(this);
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj) {
/*  95 */     if (obj instanceof Col2Expression) {
/*  96 */       Col2Expression e = (Col2Expression)obj;
/*  97 */       if (getClass() == e.getClass()) {
/*  98 */         return (this.expl.equals(e.expl) && this.expr.equals(e.expr));
/*     */       }
/*     */     } 
/*     */     
/* 102 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 106 */     return getClass().hashCode() ^ this.expl.hashCode() ^ this.expr.hashCode() * 2;
/*     */   }
/*     */   
/*     */   public void dump(int n) {
/* 110 */     StringBuffer sb = new StringBuffer();
/*     */     
/* 112 */     for (int i = 0; i < n; i++) {
/* 113 */       sb.append(' ');
/*     */     }
/*     */     
/* 116 */     sb.append(getOperator());
/* 117 */     System.out.println(sb.toString());
/* 118 */     this.expl.dump(n + 1);
/* 119 */     this.expr.dump(n + 1);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 123 */     StringBuffer sb = new StringBuffer();
/* 124 */     if (this.expl.getPriority() < this.prio) {
/* 125 */       sb.append(this.share.paren.getOperator());
/* 126 */       sb.append(this.expl.toString());
/* 127 */       sb.append(this.share.paren.getEndOperator());
/*     */     } else {
/* 129 */       sb.append(this.expl.toString());
/*     */     } 
/*     */     
/* 132 */     sb.append(toStringLeftSpace());
/* 133 */     sb.append(getOperator());
/* 134 */     sb.append(' ');
/* 135 */     if (this.expr.getPriority() < this.prio) {
/* 136 */       sb.append(this.share.paren.getOperator());
/* 137 */       sb.append(this.expr.toString());
/* 138 */       sb.append(this.share.paren.getEndOperator());
/*     */     } else {
/* 140 */       sb.append(this.expr.toString());
/*     */     } 
/*     */     
/* 143 */     return sb.toString();
/*     */   }
/*     */   
/*     */   protected String toStringLeftSpace() {
/* 147 */     return " ";
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\Col2Expression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */