/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.HashMap;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.MCH_OutputFile;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.item.Item;
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
/*    */ public class W_LanguageRegistry
/*    */ {
/* 21 */   private static HashMap<String, ArrayList<String>> map = new HashMap<>();
/*    */   
/*    */   public static void addName(Object objectToName, String name) {
/* 24 */     addNameForObject(objectToName, "en_US", name);
/*    */   }
/*    */   
/*    */   public static void addNameForObject(Object o, String lang, String name) {
/* 28 */     addNameForObject(o, lang, name, "", "");
/*    */   }
/*    */   
/*    */   public static void addNameForObject(Object o, String lang, String name, String key, String desc) {
/* 32 */     if (o == null) {
/*    */       return;
/*    */     }
/* 35 */     if (!map.containsKey(lang)) {
/* 36 */       map.put(lang, new ArrayList<>());
/*    */     }
/* 38 */     if (o instanceof Item) {
/* 39 */       ((ArrayList<String>)map.get(lang)).add(((Item)o).func_77658_a() + ".name=" + name);
/*    */     }
/* 41 */     if (o instanceof Block) {
/* 42 */       ((ArrayList<String>)map.get(lang)).add(((Block)o).func_149739_a() + ".name=" + name);
/* 43 */     } else if (o instanceof net.minecraft.stats.Achievement) {
/* 44 */       ((ArrayList<String>)map.get(lang)).add("achievement." + key + "=" + name);
/* 45 */       ((ArrayList<String>)map.get(lang)).add("achievement." + key + ".desc=" + desc);
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void updateLang(String filePath) {
/* 50 */     for (String key : map.keySet()) {
/* 51 */       ArrayList<String> list = map.get(key);
/* 52 */       MCH_OutputFile file = new MCH_OutputFile();
/* 53 */       if (!file.openUTF8(filePath + key + ".lang"))
/* 54 */         continue;  for (String s : list) {
/* 55 */         file.writeLine(s);
/*    */       }
/* 57 */       MCH_Lib.Log("[mcheli] Update lang:" + file.file.getAbsolutePath(), new Object[0]);
/* 58 */       file.close();
/*    */     } 
/* 60 */     map = null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_LanguageRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */