/*    */ package mcheli;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.text.SimpleDateFormat;
/*    */ import java.util.Date;
/*    */ import java.util.TreeSet;
/*    */ 
/*    */ public class MCH_FileSearch
/*    */ {
/*    */   public static final int TYPE_FILE_OR_DIR = 1;
/*    */   public static final int TYPE_FILE = 2;
/*    */   public static final int TYPE_DIR = 3;
/* 13 */   private TreeSet set = new TreeSet();
/*    */ 
/*    */   
/*    */   public File[] listFiles(String directoryPath, String fileName) {
/* 17 */     if (fileName != null) {
/* 18 */       fileName = fileName.replace(".", "\\.");
/* 19 */       fileName = fileName.replace("*", ".*");
/*    */     } 
/*    */     
/* 22 */     return listFiles(directoryPath, fileName, 2, true, 0);
/*    */   }
/*    */   
/*    */   public File[] listFiles(String directoryPath, String fileNamePattern, int type, boolean isRecursive, int period) {
/* 26 */     File dir = new File(directoryPath);
/* 27 */     if (!dir.isDirectory()) {
/* 28 */       throw new IllegalArgumentException("引数で指定されたパス[" + dir.getAbsolutePath() + "]はディレクトリではありません。");
/*    */     }
/* 30 */     File[] files = dir.listFiles();
/*    */     
/* 32 */     for (int i = 0; i < files.length; i++) {
/* 33 */       File file = files[i];
/* 34 */       addFile(type, fileNamePattern, this.set, file, period);
/* 35 */       if (isRecursive && file.isDirectory()) {
/* 36 */         listFiles(file.getAbsolutePath(), fileNamePattern, type, isRecursive, period);
/*    */       }
/*    */     } 
/*    */     
/* 40 */     return (File[])this.set.toArray((Object[])new File[this.set.size()]);
/*    */   }
/*    */ 
/*    */   
/*    */   private void addFile(int type, String match, TreeSet<File> set, File file, int period) {
/* 45 */     switch (type) {
/*    */       case 2:
/* 47 */         if (!file.isFile()) {
/*    */           return;
/*    */         }
/*    */         break;
/*    */       case 3:
/* 52 */         if (!file.isDirectory()) {
/*    */           return;
/*    */         }
/*    */         break;
/*    */     } 
/* 57 */     if (match == null || file.getName().matches(match)) {
/* 58 */       if (period != 0) {
/* 59 */         Date lastModifiedDate = new Date(file.lastModified());
/* 60 */         String lastModifiedDateStr = (new SimpleDateFormat("yyyyMMdd")).format(lastModifiedDate);
/* 61 */         long oneDayTime = 86400000L;
/* 62 */         long periodTime = oneDayTime * Math.abs(period);
/* 63 */         Date designatedDate = new Date(System.currentTimeMillis() - periodTime);
/* 64 */         String designatedDateStr = (new SimpleDateFormat("yyyyMMdd")).format(designatedDate);
/* 65 */         if (period > 0) {
/* 66 */           if (lastModifiedDateStr.compareTo(designatedDateStr) < 0) {
/*    */             return;
/*    */           }
/* 69 */         } else if (lastModifiedDateStr.compareTo(designatedDateStr) > 0) {
/*    */           return;
/*    */         } 
/*    */       } 
/*    */       
/* 74 */       set.add(file);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void clear() {
/* 79 */     this.set.clear();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_FileSearch.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */