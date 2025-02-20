/*     */ package mcheli.eval.eval.exp;
/*     */ 
/*     */ public abstract class Col3Expression
/*     */   extends AbstractExpression
/*     */ {
/*     */   protected AbstractExpression exp1;
/*     */   protected AbstractExpression exp2;
/*     */   protected AbstractExpression exp3;
/*     */   
/*     */   public static AbstractExpression create(AbstractExpression exp, String string, int pos, AbstractExpression x, AbstractExpression y, AbstractExpression z) {
/*  11 */     Col3Expression n = (Col3Expression)exp;
/*  12 */     n.setExpression(x, y, z);
/*  13 */     n.setPos(string, pos);
/*  14 */     return n;
/*     */   }
/*     */   
/*     */   protected Col3Expression() {}
/*     */   
/*     */   protected Col3Expression(Col3Expression from, ShareExpValue s) {
/*  20 */     super(from, s);
/*  21 */     if (from.exp1 != null) {
/*  22 */       this.exp1 = from.exp1.dup(s);
/*     */     }
/*     */     
/*  25 */     if (from.exp2 != null) {
/*  26 */       this.exp2 = from.exp2.dup(s);
/*     */     }
/*     */     
/*  29 */     if (from.exp3 != null) {
/*  30 */       this.exp3 = from.exp3.dup(s);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public final void setExpression(AbstractExpression x, AbstractExpression y, AbstractExpression z) {
/*  36 */     this.exp1 = x;
/*  37 */     this.exp2 = y;
/*  38 */     this.exp3 = z;
/*     */   }
/*     */   
/*     */   protected final int getCols() {
/*  42 */     return 3;
/*     */   }
/*     */   
/*     */   protected int getFirstPos() {
/*  46 */     return this.exp1.getFirstPos();
/*     */   }
/*     */   
/*     */   protected void search() {
/*  50 */     this.share.srch.search(this);
/*  51 */     if (!this.share.srch.end() && 
/*  52 */       !this.share.srch.search3_begin(this) && 
/*  53 */       !this.share.srch.end()) {
/*  54 */       this.exp1.search();
/*  55 */       if (!this.share.srch.end() && 
/*  56 */         !this.share.srch.search3_2(this) && 
/*  57 */         !this.share.srch.end()) {
/*  58 */         this.exp2.search();
/*  59 */         if (!this.share.srch.end() && 
/*  60 */           !this.share.srch.search3_3(this) && 
/*  61 */           !this.share.srch.end()) {
/*  62 */           this.exp3.search();
/*  63 */           if (!this.share.srch.end()) {
/*  64 */             this.share.srch.search3_end(this);
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractExpression replace() {
/*  78 */     this.exp1 = this.exp1.replace();
/*  79 */     this.exp2 = this.exp2.replace();
/*  80 */     this.exp3 = this.exp3.replace();
/*  81 */     return this.share.repl.replace3(this);
/*     */   }
/*     */   
/*     */   protected AbstractExpression replaceVar() {
/*  85 */     this.exp1 = this.exp1.replace();
/*  86 */     this.exp2 = this.exp2.replaceVar();
/*  87 */     this.exp3 = this.exp3.replaceVar();
/*  88 */     return this.share.repl.replaceVar3(this);
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj) {
/*  92 */     if (obj instanceof Col3Expression) {
/*  93 */       Col3Expression e = (Col3Expression)obj;
/*  94 */       if (getClass() == e.getClass()) {
/*  95 */         return (this.exp1.equals(e.exp1) && this.exp2.equals(e.exp2) && this.exp3.equals(e.exp3));
/*     */       }
/*     */     } 
/*     */     
/*  99 */     return false;
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 103 */     return getClass().hashCode() ^ this.exp1.hashCode() ^ this.exp2.hashCode() * 2 ^ this.exp3.hashCode() * 3;
/*     */   }
/*     */   
/*     */   public void dump(int n) {
/* 107 */     StringBuffer sb = new StringBuffer();
/*     */     
/* 109 */     for (int i = 0; i < n; i++) {
/* 110 */       sb.append(' ');
/*     */     }
/*     */     
/* 113 */     sb.append(getOperator());
/* 114 */     System.out.println(sb.toString());
/* 115 */     this.exp1.dump(n + 1);
/* 116 */     this.exp2.dump(n + 1);
/* 117 */     this.exp3.dump(n + 1);
/*     */   }
/*     */   
/*     */   public String toString() {
/* 121 */     StringBuffer sb = new StringBuffer();
/* 122 */     if (this.exp1.getPriority() > this.prio && this.exp1.getCols() < 2) {
/* 123 */       sb.append(this.exp1.toString());
/*     */     } else {
/* 125 */       sb.append(this.share.paren.getOperator());
/* 126 */       sb.append(this.exp1.toString());
/* 127 */       sb.append(this.share.paren.getEndOperator());
/*     */     } 
/*     */     
/* 130 */     sb.append(' ');
/* 131 */     sb.append(getOperator());
/* 132 */     sb.append(' ');
/* 133 */     if (this.exp2.getPriority() > this.prio && this.exp2.getCols() < 2) {
/* 134 */       sb.append(this.exp2.toString());
/*     */     } else {
/* 136 */       sb.append(this.share.paren.getOperator());
/* 137 */       sb.append(this.exp2.toString());
/* 138 */       sb.append(this.share.paren.getEndOperator());
/*     */     } 
/*     */     
/* 141 */     sb.append(' ');
/* 142 */     sb.append(getEndOperator());
/* 143 */     sb.append(' ');
/* 144 */     if (this.exp3.getPriority() > this.prio && this.exp3.getCols() < 2) {
/* 145 */       sb.append(this.exp3.toString());
/*     */     } else {
/* 147 */       sb.append(this.share.paren.getOperator());
/* 148 */       sb.append(this.exp3.toString());
/* 149 */       sb.append(this.share.paren.getEndOperator());
/*     */     } 
/*     */     
/* 152 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\Col3Expression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */