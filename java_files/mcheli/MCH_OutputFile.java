/*    */ package mcheli;
/*    */ import java.io.File;
/*    */ import java.io.FileNotFoundException;
/*    */ import java.io.PrintWriter;
/*    */ 
/*    */ public class MCH_OutputFile {
/*  7 */   public File file = null;
/*  8 */   public PrintWriter pw = null;
/*    */ 
/*    */   
/*    */   public boolean open(String path) {
/* 12 */     close();
/* 13 */     this.file = new File(path);
/*    */     
/*    */     try {
/* 16 */       this.pw = new PrintWriter(this.file);
/* 17 */       return true;
/* 18 */     } catch (FileNotFoundException var3) {
/* 19 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public boolean openUTF8(String path) {
/* 24 */     close();
/* 25 */     this.file = new File(path);
/*    */     
/*    */     try {
/* 28 */       this.pw = new PrintWriter(new OutputStreamWriter(new FileOutputStream(this.file), "UTF-8"));
/* 29 */       return true;
/* 30 */     } catch (Exception var3) {
/* 31 */       var3.printStackTrace();
/* 32 */       return false;
/*    */     } 
/*    */   }
/*    */   
/*    */   public void writeLine(String s) {
/* 37 */     if (this.pw != null && s != null) {
/* 38 */       this.pw.println(s);
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void close() {
/* 44 */     if (this.pw != null) {
/* 45 */       this.pw.close();
/*    */     }
/*    */     
/* 48 */     this.pw = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_OutputFile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */