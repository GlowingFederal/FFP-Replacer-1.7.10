/*     */ package mcheli.eval.eval.exp;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mcheli.eval.eval.EvalException;
/*     */ 
/*     */ 
/*     */ public class FunctionExpression
/*     */   extends Col1Expression
/*     */ {
/*     */   protected AbstractExpression target;
/*     */   String name;
/*     */   
/*     */   public static AbstractExpression create(AbstractExpression x, AbstractExpression args, int prio, ShareExpValue share) {
/*     */     AbstractExpression obj;
/*  16 */     if (x instanceof VariableExpression) {
/*  17 */       obj = null;
/*     */     } else {
/*  19 */       if (!(x instanceof FieldExpression)) {
/*  20 */         throw new EvalException(1101, x.toString(), x.string, x.pos, (Throwable)null);
/*     */       }
/*     */       
/*  23 */       FieldExpression name = (FieldExpression)x;
/*  24 */       obj = name.expl;
/*  25 */       x = name.expr;
/*     */     } 
/*     */     
/*  28 */     String name1 = x.getWord();
/*  29 */     FunctionExpression f = new FunctionExpression(obj, name1);
/*  30 */     f.setExpression(args);
/*  31 */     f.setPos(x.string, x.pos);
/*  32 */     f.setPriority(prio);
/*  33 */     f.share = share;
/*  34 */     return f;
/*     */   }
/*     */   
/*     */   public FunctionExpression() {
/*  38 */     setOperator("(");
/*  39 */     setEndOperator(")");
/*     */   }
/*     */   
/*     */   public FunctionExpression(AbstractExpression obj, String word) {
/*  43 */     this();
/*  44 */     this.target = obj;
/*  45 */     this.name = word;
/*     */   }
/*     */   
/*     */   protected FunctionExpression(FunctionExpression from, ShareExpValue s) {
/*  49 */     super(from, s);
/*  50 */     if (from.target != null) {
/*  51 */       this.target = from.target.dup(s);
/*     */     }
/*     */     
/*  54 */     this.name = from.name;
/*     */   }
/*     */   
/*     */   public AbstractExpression dup(ShareExpValue s) {
/*  58 */     return new FunctionExpression(this, s);
/*     */   }
/*     */   
/*     */   public long evalLong() {
/*  62 */     Object obj = null;
/*  63 */     if (this.target != null) {
/*  64 */       obj = this.target.getVariable();
/*     */     }
/*     */     
/*  67 */     List args = evalArgsLong();
/*     */     
/*     */     try {
/*  70 */       Long[] e = new Long[args.size()];
/*  71 */       return this.share.func.evalLong(obj, this.name, (Long[])args.toArray((Object[])e));
/*  72 */     } catch (EvalException var4) {
/*  73 */       throw var4;
/*  74 */     } catch (Throwable var5) {
/*  75 */       throw new EvalException(2401, this.name, this.string, this.pos, var5);
/*     */     } 
/*     */   }
/*     */   
/*     */   public double evalDouble() {
/*  80 */     Object obj = null;
/*  81 */     if (this.target != null) {
/*  82 */       obj = this.target.getVariable();
/*     */     }
/*     */     
/*  85 */     List args = evalArgsDouble();
/*     */     
/*     */     try {
/*  88 */       Double[] e = new Double[args.size()];
/*  89 */       return this.share.func.evalDouble(obj, this.name, (Double[])args.toArray((Object[])e));
/*  90 */     } catch (EvalException var4) {
/*  91 */       throw var4;
/*  92 */     } catch (Throwable var5) {
/*  93 */       throw new EvalException(2401, this.name, this.string, this.pos, var5);
/*     */     } 
/*     */   }
/*     */   
/*     */   public Object evalObject() {
/*  98 */     Object obj = null;
/*  99 */     if (this.target != null) {
/* 100 */       obj = this.target.getVariable();
/*     */     }
/*     */     
/* 103 */     List args = evalArgsObject();
/*     */     
/*     */     try {
/* 106 */       Object[] e = new Object[args.size()];
/* 107 */       return this.share.func.evalObject(obj, this.name, args.toArray(e));
/* 108 */     } catch (EvalException var4) {
/* 109 */       throw var4;
/* 110 */     } catch (Throwable var5) {
/* 111 */       throw new EvalException(2401, this.name, this.string, this.pos, var5);
/*     */     } 
/*     */   }
/*     */   
/*     */   private List evalArgsLong() {
/* 116 */     ArrayList args = new ArrayList();
/* 117 */     if (this.exp != null) {
/* 118 */       this.exp.evalArgsLong(args);
/*     */     }
/*     */     
/* 121 */     return args;
/*     */   }
/*     */   
/*     */   private List evalArgsDouble() {
/* 125 */     ArrayList args = new ArrayList();
/* 126 */     if (this.exp != null) {
/* 127 */       this.exp.evalArgsDouble(args);
/*     */     }
/*     */     
/* 130 */     return args;
/*     */   }
/*     */   
/*     */   private List evalArgsObject() {
/* 134 */     ArrayList args = new ArrayList();
/* 135 */     if (this.exp != null) {
/* 136 */       this.exp.evalArgsObject(args);
/*     */     }
/*     */     
/* 139 */     return args;
/*     */   }
/*     */   
/*     */   protected Object getVariable() {
/* 143 */     return evalObject();
/*     */   }
/*     */   
/*     */   protected long operateLong(long val) {
/* 147 */     throw new RuntimeException("この関数が呼ばれてはいけない。サブクラスで実装要");
/*     */   }
/*     */   
/*     */   protected double operateDouble(double val) {
/* 151 */     throw new RuntimeException("この関数が呼ばれてはいけない。サブクラスで実装要");
/*     */   }
/*     */   
/*     */   protected void search() {
/* 155 */     this.share.srch.search(this);
/* 156 */     if (!this.share.srch.end() && 
/* 157 */       !this.share.srch.searchFunc_begin(this) && 
/* 158 */       !this.share.srch.end()) {
/* 159 */       if (this.target != null) {
/* 160 */         this.target.search();
/* 161 */         if (this.share.srch.end()) {
/*     */           return;
/*     */         }
/*     */       } 
/*     */       
/* 166 */       if (!this.share.srch.searchFunc_2(this) && 
/* 167 */         !this.share.srch.end()) {
/* 168 */         if (this.exp != null) {
/* 169 */           this.exp.search();
/* 170 */           if (this.share.srch.end()) {
/*     */             return;
/*     */           }
/*     */         } 
/*     */         
/* 175 */         this.share.srch.searchFunc_end(this);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected AbstractExpression replace() {
/* 184 */     if (this.target != null) {
/* 185 */       this.target = this.target.replace();
/*     */     }
/*     */     
/* 188 */     if (this.exp != null) {
/* 189 */       this.exp = this.exp.replace();
/*     */     }
/*     */     
/* 192 */     return this.share.repl.replaceFunc(this);
/*     */   }
/*     */   
/*     */   public boolean equals(Object obj) {
/* 196 */     if (!(obj instanceof FunctionExpression)) {
/* 197 */       return false;
/*     */     }
/* 199 */     FunctionExpression e = (FunctionExpression)obj;
/* 200 */     return (this.name.equals(e.name) && equals(this.target, e.target) && equals(this.exp, e.exp));
/*     */   }
/*     */ 
/*     */   
/*     */   private static boolean equals(AbstractExpression e1, AbstractExpression e2) {
/* 205 */     return (e1 == null) ? ((e2 == null)) : ((e2 == null) ? false : e1.equals(e2));
/*     */   }
/*     */   
/*     */   public int hashCode() {
/* 209 */     int t = (this.target != null) ? this.target.hashCode() : 0;
/* 210 */     int a = (this.exp != null) ? this.exp.hashCode() : 0;
/* 211 */     return this.name.hashCode() ^ t ^ a * 2;
/*     */   }
/*     */   
/*     */   public String toString() {
/* 215 */     StringBuffer sb = new StringBuffer();
/* 216 */     if (this.target != null) {
/* 217 */       sb.append(this.target.toString());
/* 218 */       sb.append('.');
/*     */     } 
/*     */     
/* 221 */     sb.append(this.name);
/* 222 */     sb.append('(');
/* 223 */     if (this.exp != null) {
/* 224 */       sb.append(this.exp.toString());
/*     */     }
/*     */     
/* 227 */     sb.append(')');
/* 228 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\exp\FunctionExpression.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */