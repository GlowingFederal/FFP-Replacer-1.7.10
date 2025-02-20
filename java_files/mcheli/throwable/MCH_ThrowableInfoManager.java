/*     */ package mcheli.throwable;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.LinkedHashMap;
/*     */ import java.util.Set;
/*     */ import mcheli.MCH_InputFile;
/*     */ import mcheli.MCH_Lib;
/*     */ import net.minecraft.item.Item;
/*     */ 
/*     */ public class MCH_ThrowableInfoManager {
/*  14 */   private static MCH_ThrowableInfoManager instance = new MCH_ThrowableInfoManager();
/*  15 */   private static HashMap map = new LinkedHashMap<>();
/*     */ 
/*     */   
/*     */   public static boolean load(String path) {
/*  19 */     path = path.replace('\\', '/');
/*  20 */     File dir = new File(path);
/*  21 */     File[] files = dir.listFiles(new FileFilter() {
/*     */           public boolean accept(File pathname) {
/*  23 */             String s = pathname.getName().toLowerCase();
/*  24 */             return (pathname.isFile() && s.length() >= 5 && s.substring(s.length() - 4).compareTo(".txt") == 0);
/*     */           }
/*     */         });
/*  27 */     if (files != null && files.length > 0) {
/*  28 */       File[] arr$ = files;
/*  29 */       int len$ = files.length;
/*     */       
/*  31 */       for (int i$ = 0; i$ < len$; i$++) {
/*  32 */         File f = arr$[i$];
/*  33 */         MCH_InputFile inFile = new MCH_InputFile();
/*  34 */         int line = 0;
/*     */       } 
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
/*  68 */       MCH_Lib.Log("Read %d throwable", new Object[] { Integer.valueOf(map.size()) });
/*  69 */       return (map.size() > 0);
/*     */     } 
/*  71 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static MCH_ThrowableInfo get(String name) {
/*  76 */     return (MCH_ThrowableInfo)map.get(name);
/*     */   }
/*     */   public static MCH_ThrowableInfo get(Item item) {
/*     */     MCH_ThrowableInfo info;
/*  80 */     Iterator<MCH_ThrowableInfo> i$ = map.values().iterator();
/*     */ 
/*     */     
/*     */     do {
/*  84 */       if (!i$.hasNext()) {
/*  85 */         return null;
/*     */       }
/*     */       
/*  88 */       info = i$.next();
/*  89 */     } while (info.item != item);
/*     */     
/*  91 */     return info;
/*     */   }
/*     */   
/*     */   public static boolean contains(String name) {
/*  95 */     return map.containsKey(name);
/*     */   }
/*     */   
/*     */   public static Set getKeySet() {
/*  99 */     return map.keySet();
/*     */   }
/*     */   
/*     */   public static Collection getValues() {
/* 103 */     return map.values();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\throwable\MCH_ThrowableInfoManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */