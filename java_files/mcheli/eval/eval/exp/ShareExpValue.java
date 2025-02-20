/*     */ package mcheli.eval.eval.exp;
/*     */ 
/*     */ import mcheli.eval.eval.Expression;
/*     */ import mcheli.eval.eval.Rule;
/*     */ import mcheli.eval.eval.func.Function;
/*     */ import mcheli.eval.eval.func.InvokeFunction;
/*     */ import mcheli.eval.eval.oper.JavaExOperator;
/*     */ import mcheli.eval.eval.oper.Operator;
/*     */ import mcheli.eval.eval.ref.Refactor;
/*     */ import mcheli.eval.eval.repl.Replace;
/*     */ import mcheli.eval.eval.srch.Search;
/*     */ import mcheli.eval.eval.var.MapVariable;
/*     */ import mcheli.eval.eval.var.Variable;
/*     */ 
/*     */ public class ShareExpValue
/*     */   extends Expression {
/*     */   public AbstractExpression paren;
/*     */   
/*     */   public void setAbstractExpression(AbstractExpression ae) {
/*  20 */     this.ae = ae;
/*     */   }
/*     */   
/*     */   public void initVar() {
/*  24 */     if (this.var == null) {
/*  25 */       this.var = (Variable)new MapVariable();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void initOper() {
/*  31 */     if (this.oper == null) {
/*  32 */       this.oper = (Operator)new JavaExOperator();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void initFunc() {
/*  38 */     if (this.func == null) {
/*  39 */       this.func = (Function)new InvokeFunction();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public long evalLong() {
/*  45 */     initVar();
/*  46 */     initFunc();
/*  47 */     return this.ae.evalLong();
/*     */   }
/*     */   
/*     */   public double evalDouble() {
/*  51 */     initVar();
/*  52 */     initFunc();
/*  53 */     return this.ae.evalDouble();
/*     */   }
/*     */   
/*     */   public Object eval() {
/*  57 */     initVar();
/*  58 */     initOper();
/*  59 */     initFunc();
/*  60 */     return this.ae.evalObject();
/*     */   }
/*     */   
/*     */   public void optimizeLong(Variable var) {
/*  64 */     optimize(var, (Replace)new OptimizeLong());
/*     */   }
/*     */   
/*     */   public void optimizeDouble(Variable var) {
/*  68 */     optimize(var, (Replace)new OptimizeDouble());
/*     */   }
/*     */   
/*     */   public void optimize(Variable var, Operator oper) {
/*  72 */     Operator bak = this.oper;
/*  73 */     this.oper = oper;
/*     */     
/*     */     try {
/*  76 */       optimize(var, (Replace)new OptimizeObject());
/*     */     } finally {
/*  78 */       this.oper = bak;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void optimize(Variable var, Replace repl) {
/*     */     MapVariable mapVariable;
/*  84 */     Variable bak = this.var;
/*  85 */     if (var == null) {
/*  86 */       mapVariable = new MapVariable();
/*     */     }
/*     */     
/*  89 */     this.var = (Variable)mapVariable;
/*  90 */     this.repl = repl;
/*     */     
/*     */     try {
/*  93 */       this.ae = this.ae.replace();
/*     */     } finally {
/*  95 */       this.var = bak;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void search(Search srch) {
/* 101 */     if (srch == null) {
/* 102 */       throw new NullPointerException();
/*     */     }
/* 104 */     this.srch = srch;
/* 105 */     this.ae.search();
/*     */   }
/*     */ 
/*     */   
/*     */   public void refactorName(Refactor ref) {
/* 110 */     if (ref == null) {
/* 111 */       throw new NullPointerException();
/*     */     }
/* 113 */     this.srch = (Search)new Search4RefactorName(ref);
/* 114 */     this.ae.search();
/*     */   }
/*     */ 
/*     */   
/*     */   public void refactorFunc(Refactor ref, Rule rule) {
/* 119 */     if (ref == null) {
/* 120 */       throw new NullPointerException();
/*     */     }
/* 122 */     this.repl = (Replace)new Replace4RefactorGetter(ref, rule);
/* 123 */     this.ae.replace();
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean same(Expression obj) {
/* 128 */     if (!(obj instanceof ShareExpValue)) {
/* 129 */       return false;
/*     */     }
/* 131 */     AbstractExpression p = ((ShareExpValue)obj).paren;
/* 132 */     return (this.paren.same(p) && super.same(obj));
/*     */   }
/*     */ 
/*     */   
/*     */   public Expression dup() {
/* 137 */     ShareExpValue n = new ShareExpValue();
/* 138 */     n.ae = this.ae.dup(n);
/* 139 */     n.paren = this.paren.dup(n);
/* 140 */     return n;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\ShareExpValue.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */