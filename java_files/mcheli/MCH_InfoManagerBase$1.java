/*    */ package mcheli;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileFilter;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ class null
/*    */   implements FileFilter
/*    */ {
/*    */   public boolean accept(File pathname) {
/* 18 */     String s = pathname.getName().toLowerCase();
/* 19 */     return (pathname.isFile() && s.length() >= 5 && s.substring(s.length() - 4).compareTo(".txt") == 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_InfoManagerBase$1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */