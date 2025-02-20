/*     */ package mcheli.eval.eval.lex;
/*     */ 
/*     */ import java.util.List;
/*     */ import mcheli.eval.eval.exp.AbstractExpression;
/*     */ import mcheli.eval.eval.exp.ShareExpValue;
/*     */ import mcheli.eval.util.CharUtil;
/*     */ 
/*     */ 
/*     */ public class Lex
/*     */ {
/*     */   protected List[] opeList;
/*     */   protected String string;
/*  13 */   protected int pos = 0;
/*  14 */   protected int len = 0;
/*  15 */   protected int type = -1;
/*     */   public static final int TYPE_WORD = 2147483632;
/*     */   public static final int TYPE_NUM = 2147483633;
/*     */   public static final int TYPE_OPE = 2147483634;
/*     */   public static final int TYPE_STRING = 2147483635;
/*     */   public static final int TYPE_CHAR = 2147483636;
/*     */   public static final int TYPE_EOF = 2147483647;
/*     */   public static final int TYPE_ERR = -1;
/*     */   protected String ope;
/*     */   protected ShareExpValue expShare;
/*  25 */   protected String SPC_CHAR = " \t\r\n";
/*  26 */   protected String NUMBER_CHAR = "._";
/*     */ 
/*     */   
/*     */   protected Lex(String str, List[] lists, AbstractExpression paren, ShareExpValue exp) {
/*  30 */     this.string = str;
/*  31 */     this.opeList = lists;
/*  32 */     this.expShare = exp;
/*  33 */     if (this.expShare.paren == null) {
/*  34 */       this.expShare.paren = paren;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isSpace(int pos) {
/*  40 */     if (pos >= this.string.length()) {
/*  41 */       return true;
/*     */     }
/*  43 */     char c = this.string.charAt(pos);
/*  44 */     return (this.SPC_CHAR.indexOf(c) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isNumberTop(int pos) {
/*  49 */     if (pos >= this.string.length()) {
/*  50 */       return false;
/*     */     }
/*  52 */     char c = this.string.charAt(pos);
/*  53 */     return ('0' <= c && c <= '9');
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isSpecialNumber(int pos) {
/*  58 */     if (pos >= this.string.length()) {
/*  59 */       return false;
/*     */     }
/*  61 */     char c = this.string.charAt(pos);
/*  62 */     return (this.NUMBER_CHAR.indexOf(c) >= 0);
/*     */   }
/*     */ 
/*     */   
/*     */   protected String isOperator(int pos) {
/*  67 */     for (int i = this.opeList.length - 1; i >= 0; i--) {
/*  68 */       if (pos + i < this.string.length()) {
/*  69 */         List<String> list = this.opeList[i];
/*  70 */         if (list != null) {
/*  71 */           int j = 0;
/*     */ 
/*     */           
/*  74 */           label22: while (j < list.size()) {
/*  75 */             String ope = list.get(j);
/*     */             
/*  77 */             for (int k = 0; k <= i; k++) {
/*  78 */               char c = this.string.charAt(pos + k);
/*  79 */               char o = ope.charAt(k);
/*  80 */               if (c != o) {
/*  81 */                 j++;
/*     */                 
/*     */                 continue label22;
/*     */               } 
/*     */             } 
/*  86 */             return ope;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/*  92 */     return null;
/*     */   }
/*     */   
/*     */   protected boolean isStringTop(int pos) {
/*  96 */     if (pos >= this.string.length()) {
/*  97 */       return false;
/*     */     }
/*  99 */     char c = this.string.charAt(pos);
/* 100 */     return (c == '"');
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isStringEnd(int pos) {
/* 105 */     return isStringTop(pos);
/*     */   }
/*     */   
/*     */   protected boolean isCharTop(int pos) {
/* 109 */     if (pos >= this.string.length()) {
/* 110 */       return false;
/*     */     }
/* 112 */     char c = this.string.charAt(pos);
/* 113 */     return (c == '\'');
/*     */   }
/*     */ 
/*     */   
/*     */   protected boolean isCharEnd(int pos) {
/* 118 */     return isCharTop(pos);
/*     */   }
/*     */   
/*     */   public void check() {
/* 122 */     while (isSpace(this.pos)) {
/* 123 */       if (this.pos >= this.string.length()) {
/* 124 */         this.type = Integer.MAX_VALUE;
/* 125 */         this.len = 0;
/*     */         
/*     */         return;
/*     */       } 
/* 129 */       this.pos++;
/*     */     } 
/*     */     
/* 132 */     if (isStringTop(this.pos)) {
/* 133 */       processString();
/* 134 */     } else if (isCharTop(this.pos)) {
/* 135 */       processChar();
/*     */     } else {
/* 137 */       String ope = isOperator(this.pos);
/* 138 */       if (ope != null) {
/* 139 */         this.type = 2147483634;
/* 140 */         this.ope = ope;
/* 141 */         this.len = ope.length();
/*     */       } else {
/* 143 */         boolean number = isNumberTop(this.pos);
/* 144 */         this.type = number ? 2147483633 : 2147483632;
/*     */         
/* 146 */         for (this.len = 1; !isSpace(this.pos + this.len) && ((number && isSpecialNumber(this.pos + this.len)) || isOperator(this.pos + this.len) == null); this.len++);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void processString() {
/* 155 */     int[] ret = new int[1];
/* 156 */     this.type = 2147483635;
/* 157 */     this.len = 1;
/*     */     
/*     */     do {
/* 160 */       this.len += getCharLen(this.pos + this.len, ret);
/* 161 */       if (this.pos + this.len >= this.string.length()) {
/* 162 */         this.type = Integer.MAX_VALUE;
/*     */         return;
/*     */       } 
/* 165 */     } while (!isStringEnd(this.pos + this.len));
/*     */     
/* 167 */     this.len++;
/*     */   }
/*     */   
/*     */   protected void processChar() {
/* 171 */     int[] ret = new int[1];
/* 172 */     this.type = 2147483636;
/* 173 */     this.len = 1;
/*     */     
/*     */     do {
/* 176 */       this.len += getCharLen(this.pos + this.len, ret);
/* 177 */       if (this.pos + this.len >= this.string.length()) {
/* 178 */         this.type = Integer.MAX_VALUE;
/*     */         return;
/*     */       } 
/* 181 */     } while (!isCharEnd(this.pos + this.len));
/*     */     
/* 183 */     this.len++;
/*     */   }
/*     */   
/*     */   protected int getCharLen(int pos, int[] ret) {
/* 187 */     CharUtil.escapeChar(this.string, pos, this.string.length(), ret);
/* 188 */     return ret[0];
/*     */   }
/*     */   
/*     */   public Lex next() {
/* 192 */     this.pos += this.len;
/* 193 */     check();
/* 194 */     return this;
/*     */   }
/*     */   
/*     */   public int getType() {
/* 198 */     return this.type;
/*     */   }
/*     */   
/*     */   public String getOperator() {
/* 202 */     return this.ope;
/*     */   }
/*     */   
/*     */   public boolean isOperator(String ope) {
/* 206 */     return (this.type == 2147483634) ? this.ope.equals(ope) : false;
/*     */   }
/*     */   
/*     */   public String getWord() {
/* 210 */     return this.string.substring(this.pos, this.pos + this.len);
/*     */   }
/*     */   
/*     */   public String getString() {
/* 214 */     return this.string;
/*     */   }
/*     */   
/*     */   public int getPos() {
/* 218 */     return this.pos;
/*     */   }
/*     */   
/*     */   public ShareExpValue getShare() {
/* 222 */     return this.expShare;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\lex\Lex.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */