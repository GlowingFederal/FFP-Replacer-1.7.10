/*     */ package mcheli.eval.util;
/*     */ 
/*     */ 
/*     */ public class CharUtil
/*     */ {
/*     */   public static String escapeString(String str) {
/*   7 */     return escapeString(str, 0, str.length());
/*     */   }
/*     */   
/*     */   public static String escapeString(String str, int pos, int len) {
/*  11 */     StringBuffer sb = new StringBuffer(len);
/*  12 */     int end_pos = pos + len;
/*     */     
/*  14 */     for (int[] ret = new int[1]; pos < end_pos; pos += ret[0]) {
/*  15 */       char c = escapeChar(str, pos, end_pos, ret);
/*  16 */       if (ret[0] <= 0) {
/*     */         break;
/*     */       }
/*     */       
/*  20 */       sb.append(c);
/*     */     } 
/*     */     
/*  23 */     return sb.toString();
/*     */   } public static char escapeChar(String str, int pos, int end_pos, int[] ret) {
/*     */     long code;
/*     */     int i;
/*  27 */     if (pos >= end_pos) {
/*  28 */       ret[0] = 0;
/*  29 */       return Character.MIN_VALUE;
/*     */     } 
/*  31 */     char c = str.charAt(pos);
/*  32 */     if (c != '\\') {
/*  33 */       ret[0] = 1;
/*  34 */       return c;
/*     */     } 
/*  36 */     pos++;
/*  37 */     if (pos >= end_pos) {
/*  38 */       ret[0] = 1;
/*  39 */       return c;
/*     */     } 
/*  41 */     ret[0] = 2;
/*  42 */     c = str.charAt(pos);
/*     */ 
/*     */     
/*  45 */     switch (c) {
/*     */       case '0':
/*     */       case '1':
/*     */       case '2':
/*     */       case '3':
/*     */       case '4':
/*     */       case '5':
/*     */       case '6':
/*     */       case '7':
/*  54 */         code = (c - 48);
/*     */         
/*  56 */         i = 1;
/*  57 */         pos++;
/*  58 */         for (; i < 3 && pos < end_pos; i++) {
/*     */ 
/*     */ 
/*     */           
/*  62 */           c = str.charAt(pos);
/*  63 */           if (c < '0' || c > '7') {
/*     */             break;
/*     */           }
/*     */           
/*  67 */           ret[0] = ret[0] + 1;
/*  68 */           code *= 8L;
/*  69 */           code += (c - 48);
/*     */         } 
/*     */         
/*  72 */         return (char)(int)code;
/*     */       case 'b':
/*  74 */         return '\b';
/*     */       case 'f':
/*  76 */         return '\f';
/*     */       case 'n':
/*  78 */         return '\n';
/*     */       case 'r':
/*  80 */         return '\r';
/*     */       case 't':
/*  82 */         return '\t';
/*     */       case 'u':
/*  84 */         code = 0L;
/*     */         
/*  86 */         i = 0;
/*  87 */         pos++;
/*  88 */         for (; i < 4 && pos < end_pos; i++) {
/*     */ 
/*     */ 
/*     */           
/*  92 */           c = str.charAt(pos);
/*  93 */           if ('0' <= c && c <= '9') {
/*  94 */             ret[0] = ret[0] + 1;
/*  95 */             code *= 16L;
/*  96 */             code += (c - 48);
/*  97 */           } else if ('a' <= c && c <= 'f') {
/*  98 */             ret[0] = ret[0] + 1;
/*  99 */             code *= 16L;
/* 100 */             code += (c - 97 + 10);
/*     */           } else {
/* 102 */             if ('A' > c || c > 'F') {
/*     */               break;
/*     */             }
/*     */             
/* 106 */             ret[0] = ret[0] + 1;
/* 107 */             code *= 16L;
/* 108 */             code += (c - 65 + 10);
/*     */           } 
/*     */         } 
/*     */         
/* 112 */         return (char)(int)code;
/*     */     } 
/* 114 */     return c;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\eva\\util\CharUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */