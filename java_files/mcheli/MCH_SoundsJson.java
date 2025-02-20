/*    */ package mcheli;
/*    */ 
/*    */ import java.io.File;
/*    */ import java.io.FileFilter;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintWriter;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedHashMap;
/*    */ 
/*    */ public class MCH_SoundsJson
/*    */ {
/*    */   public static boolean update(String path) {
/* 14 */     boolean result = true;
/* 15 */     path = path.replace('\\', '/');
/* 16 */     File dir = new File(path + "sounds");
/* 17 */     File[] files = dir.listFiles(new FileFilter() {
/*    */           public boolean accept(File pathname) {
/* 19 */             String s = pathname.getName().toLowerCase();
/* 20 */             return (pathname.isFile() && s.length() >= 5 && s.substring(s.length() - 4).compareTo(".ogg") == 0);
/*    */           }
/*    */         });
/* 23 */     int cnt = 0;
/* 24 */     PrintWriter pw = null;
/*    */     
/*    */     try {
/* 27 */       File e = new File(path + "sounds.json");
/* 28 */       pw = new PrintWriter(e);
/* 29 */       pw.println("{");
/* 30 */       if (files != null) {
/* 31 */         LinkedHashMap<Object, Object> map = new LinkedHashMap<>();
/* 32 */         File[] i$ = files;
/* 33 */         int key = files.length;
/*    */         
/* 35 */         for (int list = 0; list < key; list++) {
/* 36 */           File line = i$[list];
/* 37 */           String fi = line.getName().toLowerCase();
/* 38 */           int ei = fi.lastIndexOf(".");
/* 39 */           fi = fi.substring(0, ei);
/* 40 */           String key1 = fi;
/* 41 */           char c = fi.charAt(fi.length() - 1);
/* 42 */           if (c >= '0' && c <= '9') {
/* 43 */             key1 = fi.substring(0, fi.length() - 1);
/*    */           }
/*    */           
/* 46 */           if (!map.containsKey(key1)) {
/* 47 */             map.put(key1, new ArrayList());
/*    */           }
/*    */           
/* 50 */           ((ArrayList<String>)map.get(key1)).add(fi);
/*    */         } 
/*    */ 
/*    */         
/* 54 */         for (Iterator<String> var21 = map.keySet().iterator(); var21.hasNext(); pw.println(var24)) {
/* 55 */           String var22 = var21.next();
/* 56 */           cnt++;
/* 57 */           ArrayList<String> var23 = (ArrayList)map.get(var22);
/* 58 */           String var24 = "";
/* 59 */           var24 = "\"" + var22 + "\": {\"category\": \"master\",\"sounds\": [";
/*    */           
/* 61 */           for (int var25 = 0; var25 < var23.size(); var25++) {
/* 62 */             var24 = var24 + ((var25 > 0) ? "," : "") + "\"" + (String)var23.get(var25) + "\"";
/*    */           }
/*    */           
/* 65 */           var24 = var24 + "]}";
/* 66 */           if (cnt < map.size()) {
/* 67 */             var24 = var24 + ",";
/*    */           }
/*    */         } 
/*    */       } 
/*    */       
/* 72 */       pw.println("}");
/* 73 */       pw.println("");
/* 74 */       result = true;
/* 75 */     } catch (IOException var19) {
/* 76 */       result = false;
/* 77 */       var19.printStackTrace();
/*    */     } finally {
/* 79 */       if (pw != null) {
/* 80 */         pw.close();
/*    */       }
/*    */     } 
/*    */ 
/*    */     
/* 85 */     if (result) {
/* 86 */       MCH_Lib.Log("Update sounds.json. %d sounds", new Object[] { Integer.valueOf(cnt) });
/*    */     } else {
/* 88 */       MCH_Lib.Log("Failed sounds.json update! %d sounds", new Object[] { Integer.valueOf(cnt) });
/*    */     } 
/*    */     
/* 91 */     return result;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_SoundsJson.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */