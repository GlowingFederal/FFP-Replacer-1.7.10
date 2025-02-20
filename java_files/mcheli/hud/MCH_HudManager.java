/*     */ package mcheli.hud;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Set;
/*     */ import mcheli.MCH_InputFile;
/*     */ import mcheli.MCH_Lib;
/*     */ import net.minecraft.client.Minecraft;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_HudManager
/*     */ {
/*  16 */   private static MCH_HudManager instance = new MCH_HudManager();
/*     */   
/*     */   private static HashMap map;
/*     */   
/*     */   private MCH_HudManager() {
/*  21 */     map = new HashMap<>();
/*     */   }
/*     */   
/*     */   public static boolean load(String path) {
/*  25 */     MCH_HudItem.mc = Minecraft.func_71410_x();
/*  26 */     map.clear();
/*  27 */     path = path.replace('\\', '/');
/*  28 */     File dir = new File(path);
/*  29 */     File[] files = dir.listFiles(new FileFilter() {
/*     */           public boolean accept(File pathname) {
/*  31 */             String s = pathname.getName().toLowerCase();
/*  32 */             return (pathname.isFile() && s.length() >= 5 && s.substring(s.length() - 4).compareTo(".txt") == 0);
/*     */           }
/*     */         });
/*  35 */     if (files != null && files.length > 0) {
/*  36 */       File[] arr$ = files;
/*  37 */       int len$ = files.length;
/*     */       
/*  39 */       for (int i$ = 0; i$ < len$; i$++) {
/*  40 */         File f = arr$[i$];
/*  41 */         MCH_InputFile inFile = new MCH_InputFile();
/*  42 */         int line = 0;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*  82 */       MCH_Lib.Log("Read %d HUD", new Object[] { Integer.valueOf(map.size()) });
/*  83 */       return (map.size() > 0);
/*     */     } 
/*  85 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static MCH_Hud get(String name) {
/*  90 */     return (MCH_Hud)map.get(name.toLowerCase());
/*     */   }
/*     */   
/*     */   public static boolean contains(String name) {
/*  94 */     return map.containsKey(name);
/*     */   }
/*     */   
/*     */   public static Set getKeySet() {
/*  98 */     return map.keySet();
/*     */   }
/*     */   
/*     */   public static Collection getValues() {
/* 102 */     return map.values();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */