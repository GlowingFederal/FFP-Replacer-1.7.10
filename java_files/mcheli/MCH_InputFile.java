/*    */ package mcheli;
/*    */ import java.io.BufferedReader;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ 
/*    */ public class MCH_InputFile {
/*  7 */   public File file = null;
/*  8 */   public BufferedReader br = null;
/*    */ 
/*    */   
/*    */   public boolean open(String path) {
/* 12 */     close();
/* 13 */     this.file = new File(path);
/* 14 */     String filePath = this.file.getAbsolutePath();
/*    */     
/*    */     try {
/* 17 */       this.br = new BufferedReader(new FileReader(this.file));
/* 18 */       return true;
/* 19 */     } catch (FileNotFoundException var4) {
/* 20 */       MCH_Lib.DbgLog(true, "FILE open failed MCH_InputFile.open:" + filePath, new Object[0]);
/* 21 */       var4.printStackTrace();
/* 22 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean openUTF8(File file) {
/* 27 */     return openUTF8(file.getPath());
/*    */   }
/*    */   
/*    */   public boolean openUTF8(String path) {
/* 31 */     close();
/* 32 */     this.file = new File(path);
/*    */     
/*    */     try {
/* 35 */       this.br = new BufferedReader(new InputStreamReader(new FileInputStream(this.file), "UTF-8"));
/* 36 */       return true;
/* 37 */     } catch (Exception var3) {
/* 38 */       var3.printStackTrace();
/* 39 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public String readLine() {
/*    */     try {
/* 45 */       return (this.br != null) ? this.br.readLine() : null;
/* 46 */     } catch (IOException var2) {
/* 47 */       return null;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void close() {
/*    */     try {
/* 53 */       if (this.br != null) {
/* 54 */         this.br.close();
/*    */       }
/* 56 */     } catch (IOException iOException) {}
/*    */ 
/*    */ 
/*    */     
/* 60 */     this.br = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_InputFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */