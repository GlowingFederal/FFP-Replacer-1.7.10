/*     */ package mcheli.eval.eval;
/*     */ 
/*     */ import mcheli.eval.eval.lex.Lex;
/*     */ 
/*     */ public class EvalException
/*     */   extends RuntimeException
/*     */ {
/*     */   private static final long serialVersionUID = 4174576689426433715L;
/*     */   public static final int PARSE_NOT_FOUND_END_OP = 1001;
/*     */   public static final int PARSE_INVALID_OP = 1002;
/*     */   public static final int PARSE_INVALID_CHAR = 1003;
/*     */   public static final int PARSE_END_OF_STR = 1004;
/*     */   public static final int PARSE_STILL_EXIST = 1005;
/*     */   public static final int PARSE_NOT_FUNC = 1101;
/*     */   public static final int EXP_FORBIDDEN_CALL = 2001;
/*     */   public static final int EXP_NOT_VARIABLE = 2002;
/*     */   public static final int EXP_NOT_NUMBER = 2003;
/*     */   public static final int EXP_NOT_LET = 2004;
/*     */   public static final int EXP_NOT_VAR_VALUE = 2101;
/*     */   public static final int EXP_NOT_LET_VAR = 2102;
/*     */   public static final int EXP_NOT_DEF_VAR = 2103;
/*     */   public static final int EXP_NOT_DEF_OBJ = 2104;
/*     */   public static final int EXP_NOT_ARR_VALUE = 2201;
/*     */   public static final int EXP_NOT_LET_ARR = 2202;
/*     */   public static final int EXP_NOT_FLD_VALUE = 2301;
/*     */   public static final int EXP_NOT_LET_FIELD = 2302;
/*     */   public static final int EXP_FUNC_CALL_ERROR = 2401;
/*     */   protected int msg_code;
/*     */   protected String[] msg_opt;
/*     */   protected String string;
/*     */   protected int pos;
/*     */   protected String word;
/*     */   
/*     */   public EvalException(int msg, Lex lex) {
/*  35 */     this(msg, (String[])null, lex);
/*     */   }
/*     */   
/*     */   public EvalException(int msg, String[] opt, Lex lex) {
/*  39 */     this.pos = -1;
/*  40 */     this.msg_code = msg;
/*  41 */     this.msg_opt = opt;
/*  42 */     if (lex != null) {
/*  43 */       this.string = lex.getString();
/*  44 */       this.pos = lex.getPos();
/*  45 */       this.word = lex.getWord();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public EvalException(int msg, String word, String string, int pos, Throwable e) {
/*  51 */     for (this.pos = -1; e != null && e.getClass() == RuntimeException.class && e.getCause() != null; e = e.getCause());
/*     */ 
/*     */ 
/*     */     
/*  55 */     if (e != null) {
/*  56 */       initCause(e);
/*     */     }
/*     */     
/*  59 */     this.msg_code = msg;
/*  60 */     this.string = string;
/*  61 */     this.pos = pos;
/*  62 */     this.word = word;
/*     */   }
/*     */   
/*     */   public int getErrorCode() {
/*  66 */     return this.msg_code;
/*     */   }
/*     */   
/*     */   public String[] getOption() {
/*  70 */     return this.msg_opt;
/*     */   }
/*     */   
/*     */   public String getWord() {
/*  74 */     return this.word;
/*     */   }
/*     */   
/*     */   public String getString() {
/*  78 */     return this.string;
/*     */   }
/*     */   
/*     */   public int getPos() {
/*  82 */     return this.pos;
/*     */   }
/*     */   
/*     */   public static String getErrCodeMessage(int code) {
/*  86 */     switch (code) {
/*     */       case 1001:
/*  88 */         return "演算子「%0」が在りません。";
/*     */       case 1002:
/*  90 */         return "演算子の文法エラーです。";
/*     */       case 1003:
/*  92 */         return "未対応の識別子です。";
/*     */       case 1004:
/*  94 */         return "式の解釈の途中で文字列が終了しています。";
/*     */       case 1005:
/*  96 */         return "式の解釈が終わりましたが文字列が残っています。";
/*     */       case 1101:
/*  98 */         return "関数として使用できません。";
/*     */       case 2001:
/* 100 */         return "禁止されているメソッドを呼び出しました。";
/*     */       case 2002:
/* 102 */         return "変数として使用できません。";
/*     */       case 2003:
/* 104 */         return "数値として使用できません。";
/*     */       case 2004:
/* 106 */         return "代入できません。";
/*     */       case 2101:
/* 108 */         return "変数の値が取得できません。";
/*     */       case 2102:
/* 110 */         return "変数に代入できません。";
/*     */       case 2103:
/* 112 */         return "変数が未定義です。";
/*     */       case 2104:
/* 114 */         return "オブジェクトが未定義です。";
/*     */       case 2201:
/* 116 */         return "配列の値が取得できません。";
/*     */       case 2202:
/* 118 */         return "配列に代入できません。";
/*     */       case 2301:
/* 120 */         return "フィールドの値が取得できません。";
/*     */       case 2302:
/* 122 */         return "フィールドに代入できません。";
/*     */       case 2401:
/* 124 */         return "関数の呼び出しに失敗しました。";
/*     */     } 
/* 126 */     return "エラーが発生しました。";
/*     */   }
/*     */ 
/*     */   
/*     */   public String getDefaultFormat(String msgFmt) {
/* 131 */     StringBuffer fmt = new StringBuffer(128);
/* 132 */     fmt.append(msgFmt);
/* 133 */     boolean bWord = false;
/* 134 */     if (this.word != null && this.word.length() > 0) {
/* 135 */       bWord = true;
/* 136 */       if (this.word.equals(this.string)) {
/* 137 */         bWord = false;
/*     */       }
/*     */     } 
/*     */     
/* 141 */     if (bWord) {
/* 142 */       fmt.append(" word=「%w」");
/*     */     }
/*     */     
/* 145 */     if (this.pos >= 0) {
/* 146 */       fmt.append(" pos=%p");
/*     */     }
/*     */     
/* 149 */     if (this.string != null) {
/* 150 */       fmt.append(" string=「%s」");
/*     */     }
/*     */     
/* 153 */     if (getCause() != null) {
/* 154 */       fmt.append(" cause by %e");
/*     */     }
/*     */     
/* 157 */     return fmt.toString();
/*     */   }
/*     */   
/*     */   public String toString() {
/* 161 */     String msg = getErrCodeMessage(this.msg_code);
/* 162 */     String fmt = getDefaultFormat(msg);
/* 163 */     return toString(fmt);
/*     */   }
/*     */   
/*     */   public String toString(String fmt) {
/* 167 */     StringBuffer sb = new StringBuffer(256);
/* 168 */     int len = fmt.length();
/*     */     
/* 170 */     for (int i = 0; i < len; i++) {
/* 171 */       char c = fmt.charAt(i);
/* 172 */       if (c != '%') {
/* 173 */         sb.append(c);
/*     */       } else {
/* 175 */         int n; if (i + 1 >= len) {
/* 176 */           sb.append(c);
/*     */           
/*     */           break;
/*     */         } 
/* 180 */         i++;
/* 181 */         c = fmt.charAt(i);
/* 182 */         switch (c) {
/*     */           case '%':
/* 184 */             sb.append('%');
/*     */             break;
/*     */           case '0':
/*     */           case '1':
/*     */           case '2':
/*     */           case '3':
/*     */           case '4':
/*     */           case '5':
/*     */           case '6':
/*     */           case '7':
/*     */           case '8':
/*     */           case '9':
/* 196 */             n = c - 48;
/* 197 */             if (this.msg_opt != null && n < this.msg_opt.length) {
/* 198 */               sb.append(this.msg_opt[n]);
/*     */             }
/*     */             break;
/*     */           case 'c':
/* 202 */             sb.append(this.msg_code);
/*     */             break;
/*     */           case 'e':
/* 205 */             sb.append(getCause());
/*     */             break;
/*     */           case 'p':
/* 208 */             sb.append(this.pos);
/*     */             break;
/*     */           case 's':
/* 211 */             sb.append(this.string);
/*     */             break;
/*     */           case 'w':
/* 214 */             sb.append(this.word);
/*     */             break;
/*     */           default:
/* 217 */             sb.append('%');
/* 218 */             sb.append(c);
/*     */             break;
/*     */         } 
/*     */       } 
/*     */     } 
/* 223 */     return sb.toString();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eval\eval\EvalException.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */