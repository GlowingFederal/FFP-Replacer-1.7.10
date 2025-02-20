/*    */ package mcheli.vehicle;
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
/*    */ public class MCH_VehicleInfoManager
/*    */   extends MCH_AircraftInfoManager {
/* 14 */   private static MCH_VehicleInfoManager instance = new MCH_VehicleInfoManager();
/* 15 */   public static HashMap map = new LinkedHashMap<>();
/*    */ 
/*    */   
/*    */   public static MCH_VehicleInfo get(String name) {
/* 19 */     return (MCH_VehicleInfo)map.get(name);
/*    */   }
/*    */   
/*    */   public static MCH_VehicleInfoManager getInstance() {
/* 23 */     return instance;
/*    */   }
/*    */   
/*    */   public MCH_BaseInfo newInfo(String name) {
/* 27 */     return (MCH_BaseInfo)new MCH_VehicleInfo(name);
/*    */   }
/*    */   
/*    */   public Map getMap() {
/* 31 */     return map;
/*    */   }
/*    */   
/*    */   public static MCH_VehicleInfo getFromItem(Item item) {
/* 35 */     return getInstance().getAcInfoFromItem(item);
/*    */   }
/*    */   public MCH_VehicleInfo getAcInfoFromItem(Item item) {
/*    */     MCH_VehicleInfo info;
/* 39 */     if (item == null) {
/* 40 */       return null;
/*    */     }
/* 42 */     Iterator<MCH_VehicleInfo> i$ = map.values().iterator();
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


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\vehicle\MCH_VehicleInfoManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */