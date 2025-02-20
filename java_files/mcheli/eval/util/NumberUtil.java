/*     */ package mcheli.eval.util;
/*     */ 
/*     */ 
/*     */ public class NumberUtil
/*     */ {
/*     */   public static long parseLong(String str) {
/*   7 */     if (str == null) {
/*   8 */       return 0L;
/*     */     }
/*  10 */     str = str.trim();
/*  11 */     int len = str.length();
/*  12 */     if (len <= 0) {
/*  13 */       return 0L;
/*     */     }
/*  15 */     switch (str.charAt(len - 1)) {
/*     */       case '.':
/*     */       case 'L':
/*     */       case 'l':
/*  19 */         len--; break;
/*     */     } 
/*  21 */     if (len >= 3 && str.charAt(0) == '0') {
/*  22 */       switch (str.charAt(1)) {
/*     */         case 'B':
/*     */         case 'b':
/*  25 */           return parseLongBin(str, 2, len - 2);
/*     */         case 'O':
/*     */         case 'o':
/*  28 */           return parseLongOct(str, 2, len - 2);
/*     */         case 'X':
/*     */         case 'x':
/*  31 */           return parseLongHex(str, 2, len - 2);
/*     */       } 
/*     */     
/*     */     }
/*  35 */     return parseLongDec(str, 0, len);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static long parseLongBin(String str) {
/*  42 */     return (str == null) ? 0L : parseLongBin(str, 0, str.length());
/*     */   }
/*     */   
/*     */   public static long parseLongBin(String str, int pos, int len) {
/*  46 */     long ret = 0L;
/*  47 */     int i = 0;
/*     */     
/*  49 */     while (i < len) {
/*  50 */       ret *= 2L;
/*  51 */       char c = str.charAt(pos++);
/*  52 */       switch (c) {
/*     */         case '1':
/*  54 */           ret++;
/*     */         case '0':
/*  56 */           i++;
/*     */           continue;
/*     */       } 
/*  59 */       throw new NumberFormatException(str.substring(pos, len));
/*     */     } 
/*     */ 
/*     */     
/*  63 */     return ret;
/*     */   }
/*     */   
/*     */   public static long parseLongOct(String str) {
/*  67 */     return (str == null) ? 0L : parseLongOct(str, 0, str.length());
/*     */   }
/*     */   
/*     */   public static long parseLongOct(String str, int pos, int len) {
/*  71 */     long ret = 0L;
/*  72 */     int i = 0;
/*     */     
/*  74 */     while (i < len) {
/*  75 */       ret *= 8L;
/*  76 */       char c = str.charAt(pos++);
/*  77 */       switch (c) {
/*     */         case '1':
/*     */         case '2':
/*     */         case '3':
/*     */         case '4':
/*     */         case '5':
/*     */         case '6':
/*     */         case '7':
/*  85 */           ret += (c - 48);
/*     */         case '0':
/*  87 */           i++;
/*     */           continue;
/*     */       } 
/*  90 */       throw new NumberFormatException(str.substring(pos, len));
/*     */     } 
/*     */ 
/*     */     
/*  94 */     return ret;
/*     */   }
/*     */   
/*     */   public static long parseLongDec(String str) {
/*  98 */     return (str == null) ? 0L : parseLongDec(str, 0, str.length());
/*     */   }
/*     */   
/*     */   public static long parseLongDec(String str, int pos, int len) {
/* 102 */     long ret = 0L;
/* 103 */     int i = 0;
/*     */     
/* 105 */     while (i < len) {
/* 106 */       ret *= 10L;
/* 107 */       char c = str.charAt(pos++);
/* 108 */       switch (c) {
/*     */         case '1':
/*     */         case '2':
/*     */         case '3':
/*     */         case '4':
/*     */         case '5':
/*     */         case '6':
/*     */         case '7':
/*     */         case '8':
/*     */         case '9':
/* 118 */           ret += (c - 48);
/*     */         case '0':
/* 120 */           i++;
/*     */           continue;
/*     */       } 
/* 123 */       throw new NumberFormatException(str.substring(pos, len));
/*     */     } 
/*     */ 
/*     */     
/* 127 */     return ret;
/*     */   }
/*     */   
/*     */   public static long parseLongHex(String str) {
/* 131 */     return (str == null) ? 0L : parseLongHex(str, 0, str.length());
/*     */   }
/*     */   
/*     */   public static long parseLongHex(String str, int pos, int len) {
/* 135 */     long ret = 0L;
/*     */     
/* 137 */     for (int i = 0; i < len; i++) {
/* 138 */       ret *= 16L;
/* 139 */       char c = str.charAt(pos++);
/* 140 */       switch (c) {
/*     */         case '0':
/*     */           break;
/*     */         case '1':
/*     */         case '2':
/*     */         case '3':
/*     */         case '4':
/*     */         case '5':
/*     */         case '6':
/*     */         case '7':
/*     */         case '8':
/*     */         case '9':
/* 152 */           ret += (c - 48);
/*     */           break;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         default:
/* 188 */           throw new NumberFormatException(str.substring(pos, len));
/*     */         case 'A':
/*     */         case 'B':
/*     */         case 'C':
/*     */         case 'D':
/*     */         case 'E':
/*     */         case 'F':
/* 195 */           ret += (c - 65 + 10);
/*     */           break;
/*     */         case 'a':
/*     */         case 'b':
/*     */         case 'c':
/*     */         case 'd':
/*     */         case 'e':
/*     */         case 'f':
/* 203 */           ret += (c - 97 + 10);
/*     */           break;
/*     */       } 
/*     */     } 
/* 207 */     return ret;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eva\\util\NumberUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */