/*    */ package mcheli;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileFilter;
/*    */ import java.util.Map;
/*    */ 
/*    */ public abstract class MCH_InfoManagerBase
/*    */ {
/*    */   public abstract MCH_BaseInfo newInfo(String paramString);
/*    */   
/*    */   public abstract Map getMap();
/*    */   
/*    */   public boolean load(String path, String type) {
/* 14 */     path = path.replace('\\', '/');
/* 15 */     File dir = new File(path + type);
/* 16 */     File[] files = dir.listFiles(new FileFilter() {
/*    */           public boolean accept(File pathname) {
/* 18 */             String s = pathname.getName().toLowerCase();
/* 19 */             return (pathname.isFile() && s.length() >= 5 && s.substring(s.length() - 4).compareTo(".txt") == 0);
/*    */           }
/*    */         });
/* 22 */     if (files != null && files.length > 0) {
/* 23 */       File[] arr$ = files;
/* 24 */       int len$ = files.length;
/*    */       
/* 26 */       for (int i$ = 0; i$ < len$; i$++) {
/* 27 */         File f = arr$[i$];
/* 28 */         int line = 0;
/* 29 */         MCH_InputFile inFile = new MCH_InputFile();
/* 30 */         Object br = null;
/*    */       } 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */       
/* 67 */       MCH_Lib.Log("Read %d %s", new Object[] { Integer.valueOf(getMap().size()), type });
/* 68 */       return (getMap().size() > 0);
/*    */     } 
/* 70 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_InfoManagerBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */