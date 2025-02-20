/*     */ package mcheli.weapon;
/*     */ 
/*     */ import java.io.BufferedReader;
/*     */ import java.io.File;
/*     */ import java.io.FileFilter;
/*     */ import java.util.Collection;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Set;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class MCH_WeaponInfoManager {
/*  17 */   private static MCH_WeaponInfoManager instance = new MCH_WeaponInfoManager();
/*     */   
/*     */   private static HashMap map;
/*     */   private static String lastPath;
/*     */   
/*     */   private MCH_WeaponInfoManager() {
/*  23 */     map = new HashMap<>();
/*     */   }
/*     */   
/*     */   public static boolean reload() {
/*  27 */     boolean ret = false;
/*     */     
/*     */     try {
/*  30 */       map.clear();
/*  31 */       ret = load(lastPath);
/*  32 */       setRoundItems();
/*  33 */       MCH_MOD.proxy.registerModels();
/*  34 */     } catch (Exception var2) {
/*  35 */       var2.printStackTrace();
/*     */     } 
/*     */     
/*  38 */     return ret;
/*     */   }
/*     */   
/*     */   public static boolean load(String path) {
/*  42 */     lastPath = path;
/*  43 */     path = path.replace('\\', '/');
/*  44 */     File dir = new File(path);
/*  45 */     File[] files = dir.listFiles(new FileFilter() {
/*     */           public boolean accept(File pathname) {
/*  47 */             String s = pathname.getName().toLowerCase();
/*  48 */             return (pathname.isFile() && s.length() >= 5 && s.substring(s.length() - 4).compareTo(".txt") == 0);
/*     */           }
/*     */         });
/*  51 */     if (files != null && files.length > 0) {
/*  52 */       File[] arr$ = files;
/*  53 */       int len$ = files.length;
/*     */       
/*  55 */       for (int i$ = 0; i$ < len$; i$++) {
/*  56 */         File f = arr$[i$];
/*  57 */         BufferedReader br = null;
/*  58 */         int line = 0;
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
/*     */ 
/*     */       
/* 100 */       MCH_Lib.Log("[mcheli] Read %d weapons", new Object[] { Integer.valueOf(map.size()) });
/* 101 */       return (map.size() > 0);
/*     */     } 
/* 103 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setRoundItems() {
/* 108 */     Iterator<MCH_WeaponInfo> i$ = map.values().iterator();
/*     */     
/* 110 */     while (i$.hasNext()) {
/* 111 */       MCH_WeaponInfo w = i$.next();
/*     */ 
/*     */ 
/*     */       
/* 115 */       for (MCH_WeaponInfo.RoundItem r : w.roundItems) {
/*     */         
/* 117 */         Item item = W_Item.getItemByName(r.itemName);
/*     */         r.itemStack = new ItemStack(item, 1, r.damage);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static MCH_WeaponInfo get(String name) {
/* 124 */     return (MCH_WeaponInfo)map.get(name);
/*     */   }
/*     */   
/*     */   public static boolean contains(String name) {
/* 128 */     return map.containsKey(name);
/*     */   }
/*     */   
/*     */   public static Set getKeySet() {
/* 132 */     return map.keySet();
/*     */   }
/*     */   
/*     */   public static Collection getValues() {
/* 136 */     return map.values();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponInfoManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */