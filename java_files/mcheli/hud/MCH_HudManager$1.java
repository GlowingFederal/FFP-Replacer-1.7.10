/*    */ package mcheli.hud;
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
/*    */ final class null
/*    */   implements FileFilter
/*    */ {
/*    */   public boolean accept(File pathname) {
/* 31 */     String s = pathname.getName().toLowerCase();
/* 32 */     return (pathname.isFile() && s.length() >= 5 && s.substring(s.length() - 4).compareTo(".txt") == 0);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudManager$1.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */