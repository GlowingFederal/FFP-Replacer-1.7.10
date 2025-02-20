/*     */ package mcheli.eval.eval.oper;
/*     */ 
/*     */ import java.math.BigDecimal;
/*     */ import java.math.BigInteger;
/*     */ 
/*     */ public class JavaExOperator
/*     */   implements Operator {
/*     */   boolean inLong(Object x) {
/*   9 */     return (x instanceof Long) ? true : ((x instanceof Integer) ? true : ((x instanceof Short) ? true : ((x instanceof Byte) ? true : ((x instanceof BigInteger) ? true : (x instanceof BigDecimal)))));
/*     */   }
/*     */   
/*     */   long l(Object x) {
/*  13 */     return ((Number)x).longValue();
/*     */   }
/*     */   
/*     */   boolean inDouble(Object x) {
/*  17 */     return (x instanceof Double) ? true : (x instanceof Float);
/*     */   }
/*     */   
/*     */   double d(Object x) {
/*  21 */     return ((Number)x).doubleValue();
/*     */   }
/*     */   
/*     */   Object n(long n, Object x) {
/*  25 */     return (x instanceof Long) ? new Long(n) : ((x instanceof Double) ? new Double(n) : ((x instanceof Integer) ? new Integer((int)n) : ((x instanceof Short) ? new Short((short)(int)n) : ((x instanceof Byte) ? new Byte((byte)(int)n) : ((x instanceof Float) ? new Float((float)n) : ((x instanceof BigInteger) ? BigInteger.valueOf(n) : ((x instanceof BigDecimal) ? BigDecimal.valueOf(n) : ((x instanceof String) ? String.valueOf(n) : new Long(n)))))))));
/*     */   }
/*     */   
/*     */   Object n(long n, Object x, Object y) {
/*  29 */     return (!(x instanceof Byte) && !(y instanceof Byte)) ? ((!(x instanceof Short) && !(y instanceof Short)) ? ((!(x instanceof Integer) && !(y instanceof Integer)) ? ((!(x instanceof Long) && !(y instanceof Long)) ? ((!(x instanceof BigInteger) && !(y instanceof BigInteger)) ? ((!(x instanceof BigDecimal) && !(y instanceof BigDecimal)) ? ((!(x instanceof Float) && !(y instanceof Float)) ? ((!(x instanceof Double) && !(y instanceof Double)) ? ((!(x instanceof String) && !(y instanceof String)) ? new Long(n) : String.valueOf(n)) : new Double(n)) : new Float((float)n)) : BigDecimal.valueOf(n)) : BigInteger.valueOf(n)) : new Long(n)) : new Integer((int)n)) : new Short((short)(int)n)) : new Byte((byte)(int)n);
/*     */   }
/*     */   
/*     */   Object n(double n, Object x) {
/*  33 */     return (x instanceof Float) ? new Float(n) : ((x instanceof String) ? String.valueOf(n) : new Double(n));
/*     */   }
/*     */   
/*     */   Object n(double n, Object x, Object y) {
/*  37 */     return (!(x instanceof Float) && !(y instanceof Float)) ? ((!(x instanceof Number) && !(y instanceof Number)) ? ((!(x instanceof String) && !(y instanceof String)) ? new Double(n) : String.valueOf(n)) : new Double(n)) : new Float(n);
/*     */   }
/*     */   
/*     */   Object nn(long n, Object x) {
/*  41 */     return (x instanceof BigDecimal) ? BigDecimal.valueOf(n) : ((x instanceof BigInteger) ? BigInteger.valueOf(n) : new Long(n));
/*     */   }
/*     */   
/*     */   Object nn(long n, Object x, Object y) {
/*  45 */     return (!(x instanceof BigDecimal) && !(y instanceof BigDecimal)) ? ((!(x instanceof BigInteger) && !(y instanceof BigInteger)) ? new Long(n) : BigInteger.valueOf(n)) : BigDecimal.valueOf(n);
/*     */   }
/*     */   
/*     */   Object nn(double n, Object x) {
/*  49 */     return Double.valueOf(inLong(x) ? (new Long((long)n)).longValue() : (new Double(n)).doubleValue());
/*     */   }
/*     */   
/*     */   Object nn(double n, Object x, Object y) {
/*  53 */     return Double.valueOf((inLong(x) && inLong(y)) ? (new Long((long)n)).longValue() : (new Double(n)).doubleValue());
/*     */   }
/*     */   
/*     */   RuntimeException undefined(Object x) {
/*  57 */     String c = null;
/*  58 */     if (x != null) {
/*  59 */       c = x.getClass().getName();
/*     */     }
/*     */     
/*  62 */     return new RuntimeException("未定義単項演算：" + c);
/*     */   }
/*     */   
/*     */   RuntimeException undefined(Object x, Object y) {
/*  66 */     String c1 = null;
/*  67 */     String c2 = null;
/*  68 */     if (x != null) {
/*  69 */       c1 = x.getClass().getName();
/*     */     }
/*     */     
/*  72 */     if (y != null) {
/*  73 */       c2 = y.getClass().getName();
/*     */     }
/*     */     
/*  76 */     return new RuntimeException("未定義二項演算：" + c1 + " , " + c2);
/*     */   }
/*     */   
/*     */   public Object power(Object x, Object y) {
/*  80 */     return (x == null && y == null) ? null : nn(Math.pow(d(x), d(y)), x, y);
/*     */   }
/*     */   
/*     */   public Object signPlus(Object x) {
/*  84 */     return x;
/*     */   }
/*     */   
/*     */   public Object signMinus(Object x) {
/*  88 */     if (x == null)
/*  89 */       return null; 
/*  90 */     if (inLong(x))
/*  91 */       return n(-l(x), x); 
/*  92 */     if (inDouble(x))
/*  93 */       return n(-d(x), x); 
/*  94 */     if (x instanceof Boolean) {
/*  95 */       return x;
/*     */     }
/*  97 */     throw undefined(x);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object plus(Object x, Object y) {
/* 102 */     if (x == null && y == null)
/* 103 */       return null; 
/* 104 */     if (inLong(x) && inLong(y))
/* 105 */       return nn(l(x) + l(y), x, y); 
/* 106 */     if (inDouble(x) && inDouble(y))
/* 107 */       return nn(d(x) + d(y), x, y); 
/* 108 */     if (!(x instanceof String) && !(y instanceof String)) {
/* 109 */       if (!(x instanceof Character) && !(y instanceof Character)) {
/* 110 */         throw undefined(x, y);
/*     */       }
/* 112 */       return x + String.valueOf(y);
/*     */     } 
/*     */     
/* 115 */     return x + String.valueOf(y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object minus(Object x, Object y) {
/* 120 */     if (x == null && y == null)
/* 121 */       return null; 
/* 122 */     if (inLong(x) && inLong(y))
/* 123 */       return nn(l(x) - l(y), x, y); 
/* 124 */     if (inDouble(x) && inDouble(y)) {
/* 125 */       return nn(d(x) - d(y), x, y);
/*     */     }
/* 127 */     throw undefined(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object mult(Object x, Object y) {
/* 132 */     if (x == null && y == null)
/* 133 */       return null; 
/* 134 */     if (inLong(x) && inLong(y))
/* 135 */       return nn(l(x) * l(y), x, y); 
/* 136 */     if (inDouble(x) && inDouble(y)) {
/* 137 */       return nn(d(x) * d(y), x, y);
/*     */     }
/* 139 */     String s = null;
/* 140 */     int ct = 0;
/* 141 */     boolean str = false;
/* 142 */     if (x instanceof String && y instanceof Number) {
/* 143 */       s = (String)x;
/* 144 */       ct = (int)l(y);
/* 145 */       str = true;
/* 146 */     } else if (y instanceof String && x instanceof Number) {
/* 147 */       s = (String)y;
/* 148 */       ct = (int)l(x);
/* 149 */       str = true;
/*     */     } 
/*     */     
/* 152 */     if (!str) {
/* 153 */       throw undefined(x, y);
/*     */     }
/* 155 */     StringBuffer sb = new StringBuffer(s.length() * ct);
/*     */     
/* 157 */     for (int i = 0; i < ct; i++) {
/* 158 */       sb.append(s);
/*     */     }
/*     */     
/* 161 */     return sb.toString();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object div(Object x, Object y) {
/* 167 */     if (x == null && y == null)
/* 168 */       return null; 
/* 169 */     if (inLong(x) && inLong(y))
/* 170 */       return nn(l(x) / l(y), x); 
/* 171 */     if (inDouble(x) && inDouble(y))
/* 172 */       return nn(d(x) / d(y), x); 
/* 173 */     if (x instanceof String && y instanceof String) {
/* 174 */       String s = (String)x;
/* 175 */       String r = (String)y;
/* 176 */       return s.split(r);
/*     */     } 
/* 178 */     throw undefined(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object mod(Object x, Object y) {
/* 183 */     if (x == null && y == null)
/* 184 */       return null; 
/* 185 */     if (inLong(x) && inLong(y))
/* 186 */       return nn(l(x) % l(y), x); 
/* 187 */     if (inDouble(x) && inDouble(y)) {
/* 188 */       return nn(d(x) % d(y), x);
/*     */     }
/* 190 */     throw undefined(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object bitNot(Object x) {
/* 195 */     if (x == null)
/* 196 */       return null; 
/* 197 */     if (x instanceof Number) {
/* 198 */       return n(l(x) ^ 0xFFFFFFFFFFFFFFFFL, x);
/*     */     }
/* 200 */     throw undefined(x);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object shiftLeft(Object x, Object y) {
/* 205 */     if (x == null && y == null)
/* 206 */       return null; 
/* 207 */     if (inLong(x) && inLong(y))
/* 208 */       return n(l(x) << (int)l(y), x); 
/* 209 */     if (inDouble(x) && inDouble(y)) {
/* 210 */       return n(d(x) * Math.pow(2.0D, d(y)), x);
/*     */     }
/* 212 */     throw undefined(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object shiftRight(Object x, Object y) {
/* 217 */     if (x == null && y == null)
/* 218 */       return null; 
/* 219 */     if (inLong(x) && inLong(y))
/* 220 */       return n(l(x) >> (int)l(y), x); 
/* 221 */     if (inDouble(x) && inDouble(y)) {
/* 222 */       return n(d(x) / Math.pow(2.0D, d(y)), x);
/*     */     }
/* 224 */     throw undefined(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object shiftRightLogical(Object x, Object y) {
/* 229 */     if (x == null && y == null)
/* 230 */       return null; 
/* 231 */     if (x instanceof Byte && y instanceof Number)
/* 232 */       return n((l(x) & 0xFFL) >>> (int)l(y), x); 
/* 233 */     if (x instanceof Short && y instanceof Number)
/* 234 */       return n((l(x) & 0xFFFFL) >>> (int)l(y), x); 
/* 235 */     if (x instanceof Integer && y instanceof Number)
/* 236 */       return n((l(x) & 0xFFFFFFFFL) >>> (int)l(y), x); 
/* 237 */     if (inLong(x) && y instanceof Number)
/* 238 */       return n(l(x) >>> (int)l(y), x); 
/* 239 */     if (inDouble(x) && y instanceof Number) {
/* 240 */       double t = d(x);
/* 241 */       if (t < 0.0D) {
/* 242 */         t = -t;
/*     */       }
/*     */       
/* 245 */       return n(t / Math.pow(2.0D, d(y)), x);
/*     */     } 
/* 247 */     throw undefined(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object bitAnd(Object x, Object y) {
/* 252 */     if (x == null && y == null)
/* 253 */       return null; 
/* 254 */     if (x instanceof Number && y instanceof Number) {
/* 255 */       return n(l(x) & l(y), x);
/*     */     }
/* 257 */     throw undefined(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object bitOr(Object x, Object y) {
/* 262 */     if (x == null && y == null)
/* 263 */       return null; 
/* 264 */     if (x instanceof Number && y instanceof Number) {
/* 265 */       return n(l(x) | l(y), x);
/*     */     }
/* 267 */     throw undefined(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object bitXor(Object x, Object y) {
/* 272 */     if (x == null && y == null)
/* 273 */       return null; 
/* 274 */     if (x instanceof Number && y instanceof Number) {
/* 275 */       return n(l(x) ^ l(y), x);
/*     */     }
/* 277 */     throw undefined(x, y);
/*     */   }
/*     */ 
/*     */   
/*     */   public Object not(Object x) {
/* 282 */     if (x == null)
/* 283 */       return null; 
/* 284 */     if (x instanceof Boolean)
/* 285 */       return ((Boolean)x).booleanValue() ? Boolean.FALSE : Boolean.TRUE; 
/* 286 */     if (x instanceof Number) {
/* 287 */       return (l(x) == 0L) ? Boolean.TRUE : Boolean.FALSE;
/*     */     }
/* 289 */     throw undefined(x);
/*     */   }
/*     */ 
/*     */   
/*     */   int compare(Object x, Object y) {
/* 294 */     if (x == null && y == null)
/* 295 */       return 0; 
/* 296 */     if (x == null && y != null)
/* 297 */       return -1; 
/* 298 */     if (x != null && y == null)
/* 299 */       return 1; 
/* 300 */     if (inLong(x) && inLong(y)) {
/* 301 */       long xc2 = l(x) - l(y);
/* 302 */       return (xc2 == 0L) ? 0 : ((xc2 < 0L) ? -1 : 1);
/* 303 */     }  if (x instanceof Number && y instanceof Number) {
/* 304 */       double xc1 = d(x) - d(y);
/* 305 */       return (xc1 == 0.0D) ? 0 : ((xc1 < 0.0D) ? -1 : 1);
/*     */     } 
/* 307 */     Class<?> xc = x.getClass();
/* 308 */     Class<?> yc = y.getClass();
/* 309 */     if (xc.isAssignableFrom(yc) && x instanceof Comparable)
/* 310 */       return ((Comparable<Object>)x).compareTo(y); 
/* 311 */     if (yc.isAssignableFrom(xc) && y instanceof Comparable)
/* 312 */       return -((Comparable)y).compareTo((T)x); 
/* 313 */     if (x.equals(y)) {
/* 314 */       return 0;
/*     */     }
/* 316 */     throw undefined(x, y);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public Object equal(Object x, Object y) {
/* 322 */     return (compare(x, y) == 0) ? Boolean.TRUE : Boolean.FALSE;
/*     */   }
/*     */   
/*     */   public Object notEqual(Object x, Object y) {
/* 326 */     return (compare(x, y) != 0) ? Boolean.TRUE : Boolean.FALSE;
/*     */   }
/*     */   
/*     */   public Object lessThan(Object x, Object y) {
/* 330 */     return (compare(x, y) < 0) ? Boolean.TRUE : Boolean.FALSE;
/*     */   }
/*     */   
/*     */   public Object lessEqual(Object x, Object y) {
/* 334 */     return (compare(x, y) <= 0) ? Boolean.TRUE : Boolean.FALSE;
/*     */   }
/*     */   
/*     */   public Object greaterThan(Object x, Object y) {
/* 338 */     return (compare(x, y) > 0) ? Boolean.TRUE : Boolean.FALSE;
/*     */   }
/*     */   
/*     */   public Object greaterEqual(Object x, Object y) {
/* 342 */     return (compare(x, y) >= 0) ? Boolean.TRUE : Boolean.FALSE;
/*     */   }
/*     */   
/*     */   public boolean bool(Object x) {
/* 346 */     return (x == null) ? false : ((x instanceof Boolean) ? ((Boolean)x).booleanValue() : ((x instanceof Number) ? ((((Number)x).longValue() != 0L)) : Boolean.valueOf(x.toString()).booleanValue()));
/*     */   }
/*     */   
/*     */   public Object inc(Object x, int inc) {
/* 350 */     if (x == null)
/* 351 */       return null; 
/* 352 */     if (inLong(x))
/* 353 */       return n(l(x) + inc, x); 
/* 354 */     if (inDouble(x)) {
/* 355 */       return n(d(x) + inc, x);
/*     */     }
/* 357 */     throw undefined(x);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\oper\JavaExOperator.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */