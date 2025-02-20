/*     */ package mcheli;
/*     */ 
/*     */ import java.io.File;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_BaseInfo
/*     */ {
/*     */   public String filePath;
/*     */   
/*     */   public boolean toBool(String s) {
/*  13 */     return s.equalsIgnoreCase("true");
/*     */   }
/*     */   
/*     */   public boolean toBool(String s, boolean defaultValue) {
/*  17 */     return s.equalsIgnoreCase("true") ? true : (s.equalsIgnoreCase("false") ? false : defaultValue);
/*     */   }
/*     */   
/*     */   public float toFloat(String s) {
/*  21 */     return Float.parseFloat(s);
/*     */   }
/*     */   
/*     */   public float toFloat(String s, float min, float max) {
/*  25 */     float f = Float.parseFloat(s);
/*  26 */     return (f < min) ? min : ((f > max) ? max : f);
/*     */   }
/*     */   
/*     */   public double toDouble(String s) {
/*  30 */     return Double.parseDouble(s);
/*     */   }
/*     */   
/*     */   public Vec3 toVec3(String x, String y, String z) {
/*  34 */     return Vec3.func_72443_a(toDouble(x), toDouble(y), toDouble(z));
/*     */   }
/*     */   
/*     */   public int toInt(String s) {
/*  38 */     return Integer.parseInt(s);
/*     */   }
/*     */   
/*     */   public int toInt(String s, int min, int max) {
/*  42 */     int f = Integer.parseInt(s);
/*  43 */     return (f < min) ? min : ((f > max) ? max : f);
/*     */   }
/*     */   
/*     */   public int hex2dec(String s) {
/*  47 */     return (!s.startsWith("0x") && !s.startsWith("0X") && s.indexOf(false) != 35) ? (int)(Long.decode("0x" + s).longValue() & 0xFFFFFFFFFFFFFFFFL) : (int)(Long.decode(s).longValue() & 0xFFFFFFFFFFFFFFFFL);
/*     */   }
/*     */   
/*     */   public String[] splitParam(String data) {
/*  51 */     return data.split("\\s*,\\s*");
/*     */   }
/*     */   
/*     */   public String[] splitParamSlash(String data) {
/*  55 */     return data.split("\\s*/\\s*");
/*     */   }
/*     */   
/*     */   public boolean isValidData() throws Exception {
/*  59 */     return true;
/*     */   }
/*     */   
/*     */   public void loadItemData(String item, String data) {}
/*     */   
/*     */   public void loadItemData(int fileLine, String item, String data) {}
/*     */   
/*     */   public void preReload() {}
/*     */   
/*     */   public void postReload() {}
/*     */   
/*     */   public boolean canReloadItem(String item) {
/*  71 */     return false;
/*     */   }
/*     */   
/*     */   public boolean reload() {
/*  75 */     return reload(this);
/*     */   }
/*     */   
/*     */   private boolean reload(MCH_BaseInfo info) {
/*  79 */     int line = 0;
/*  80 */     MCH_InputFile inFile = new MCH_InputFile();
/*  81 */     Object br = null;
/*  82 */     File f = new File(info.filePath);
/*     */     
/*     */     try {
/*  85 */       if (inFile.openUTF8(f)) {
/*  86 */         info.preReload();
/*     */         
/*     */         String e;
/*  89 */         while ((e = inFile.br.readLine()) != null) {
/*  90 */           line++;
/*  91 */           e = e.trim();
/*  92 */           int eqIdx = e.indexOf('=');
/*  93 */           if (eqIdx >= 0 && e.length() > eqIdx + 1) {
/*  94 */             String item = e.substring(0, eqIdx).trim().toLowerCase();
/*  95 */             if (info.canReloadItem(item)) {
/*  96 */               info.loadItemData(item, e.substring(eqIdx + 1).trim());
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 101 */         boolean var14 = false;
/* 102 */         info.isValidData();
/* 103 */         info.postReload();
/*     */       } 
/* 105 */     } catch (Exception var12) {
/* 106 */       if (line > 0) {
/* 107 */         MCH_Lib.Log("### Load failed %s : line=%d", new Object[] { f.getName(), Integer.valueOf(line) });
/*     */       } else {
/* 109 */         MCH_Lib.Log("### Load failed %s", new Object[] { f.getName() });
/*     */       } 
/*     */       
/* 112 */       var12.printStackTrace();
/*     */     } finally {
/* 114 */       inFile.close();
/*     */     } 
/*     */     
/* 117 */     return true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_BaseInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */