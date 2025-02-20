/*    */ package mcheli.helicopter;
/*    */ 
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.LinkedHashMap;
/*    */ import java.util.Map;
/*    */ import mcheli.MCH_BaseInfo;
/*    */ import mcheli.aircraft.MCH_AircraftInfo;
/*    */ import mcheli.aircraft.MCH_AircraftInfoManager;
/*    */ import net.minecraft.item.Item;
/*    */ 
/*    */ public class MCH_HeliInfoManager
/*    */   extends MCH_AircraftInfoManager {
/* 14 */   private static final MCH_HeliInfoManager instance = new MCH_HeliInfoManager();
/* 15 */   public static final HashMap map = new LinkedHashMap<>();
/*    */ 
/*    */   
/*    */   public static MCH_HeliInfoManager getInstance() {
/* 19 */     return instance;
/*    */   }
/*    */   
/*    */   public static MCH_HeliInfo get(String name) {
/* 23 */     return (MCH_HeliInfo)map.get(name);
/*    */   }
/*    */   
/*    */   public MCH_BaseInfo newInfo(String name) {
/* 27 */     return (MCH_BaseInfo)new MCH_HeliInfo(name);
/*    */   }
/*    */   
/*    */   public Map getMap() {
/* 31 */     return map;
/*    */   }
/*    */   
/*    */   public static MCH_HeliInfo getFromItem(Item item) {
/* 35 */     return getInstance().getAcInfoFromItem(item);
/*    */   }
/*    */   public MCH_HeliInfo getAcInfoFromItem(Item item) {
/*    */     MCH_HeliInfo info;
/* 39 */     if (item == null) {
/* 40 */       return null;
/*    */     }
/* 42 */     Iterator<MCH_HeliInfo> i$ = map.values().iterator();
/*    */ 
/*    */     
/*    */     do {
/* 46 */       if (!i$.hasNext()) {
/* 47 */         return null;
/*    */       }
/*    */       
/* 50 */       info = i$.next();
/* 51 */     } while (info.item != item);
/*    */     
/* 53 */     return info;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\helicopter\MCH_HeliInfoManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */