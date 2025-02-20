/*     */ package mcheli;
/*     */ 
/*     */ public class MCH_ConfigPrm
/*     */ {
/*     */   public final int type;
/*     */   public final String name;
/*   7 */   public int prmInt = 0;
/*   8 */   public String prmString = "";
/*     */   public boolean prmBool = false;
/*  10 */   public double prmDouble = 0.0D;
/*  11 */   public String desc = "";
/*  12 */   public int prmIntDefault = 0;
/*  13 */   public String validVer = "";
/*     */ 
/*     */   
/*     */   public String toString() {
/*  17 */     return (this.type == 0) ? String.valueOf(this.prmInt) : ((this.type == 1) ? this.prmString : ((this.type == 2) ? String.valueOf(this.prmBool) : ((this.type == 3) ? String.format("%.2f", new Object[] { Double.valueOf(this.prmDouble) }).replace(',', '.') : "")));
/*     */   }
/*     */   
/*     */   public MCH_ConfigPrm(String parameterName, int defaultParameter) {
/*  21 */     this.prmInt = defaultParameter;
/*  22 */     this.prmIntDefault = defaultParameter;
/*  23 */     this.type = 0;
/*  24 */     this.name = parameterName;
/*     */   }
/*     */   
/*     */   public MCH_ConfigPrm(String parameterName, String defaultParameter) {
/*  28 */     this.prmString = defaultParameter;
/*  29 */     this.type = 1;
/*  30 */     this.name = parameterName;
/*     */   }
/*     */   
/*     */   public MCH_ConfigPrm(String parameterName, boolean defaultParameter) {
/*  34 */     this.prmBool = defaultParameter;
/*  35 */     this.type = 2;
/*  36 */     this.name = parameterName;
/*     */   }
/*     */   
/*     */   public MCH_ConfigPrm(String parameterName, double defaultParameter) {
/*  40 */     this.prmDouble = defaultParameter;
/*  41 */     this.type = 3;
/*  42 */     this.name = parameterName;
/*     */   }
/*     */   
/*     */   public boolean compare(String s) {
/*  46 */     return this.name.equalsIgnoreCase(s);
/*     */   }
/*     */   
/*     */   public boolean isValidVer(String configVer) {
/*  50 */     if (configVer.length() >= 5 && this.validVer.length() >= 5) {
/*  51 */       String[] configVerSplit = configVer.split("\\.");
/*  52 */       String[] validVerSplit = this.validVer.split("\\.");
/*  53 */       if (configVerSplit.length == 3 && validVerSplit.length == 3) {
/*  54 */         for (int i = 0; i < 3; i++) {
/*  55 */           int n1 = Integer.valueOf(configVerSplit[i].replaceAll("[a-zA-Z-_]", "").trim()).intValue();
/*  56 */           int n2 = Integer.valueOf(validVerSplit[i].replaceAll("[a-zA-Z-_]", "").trim()).intValue();
/*  57 */           if (n1 > n2) {
/*  58 */             return true;
/*     */           }
/*     */           
/*  61 */           if (n1 < n2) {
/*  62 */             return false;
/*     */           }
/*     */         } 
/*     */       }
/*     */     } 
/*     */     
/*  68 */     return true;
/*     */   }
/*     */   
/*     */   public void setPrm(int n) {
/*  72 */     if (this.type == 0) {
/*  73 */       this.prmInt = n;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPrm(String s) {
/*  79 */     if (this.type == 0) {
/*  80 */       this.prmInt = Integer.parseInt(s);
/*     */     }
/*     */     
/*  83 */     if (this.type == 1) {
/*  84 */       this.prmString = s;
/*     */     }
/*     */     
/*  87 */     if (this.type == 2) {
/*  88 */       s = s.toLowerCase();
/*  89 */       if (s.compareTo("true") == 0) {
/*  90 */         this.prmBool = true;
/*     */       }
/*     */       
/*  93 */       if (s.compareTo("false") == 0) {
/*  94 */         this.prmBool = false;
/*     */       }
/*     */     } 
/*     */     
/*  98 */     if (this.type == 3 && !s.isEmpty()) {
/*  99 */       this.prmDouble = MCH_Lib.parseDouble(s);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPrm(boolean b) {
/* 105 */     if (this.type == 2) {
/* 106 */       this.prmBool = b;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setPrm(double f) {
/* 112 */     if (this.type == 3)
/* 113 */       this.prmDouble = f; 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_ConfigPrm.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */