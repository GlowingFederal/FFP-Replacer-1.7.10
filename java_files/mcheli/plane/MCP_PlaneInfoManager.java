/*    */ package mcheli.plane;
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
/*    */ public class MCP_PlaneInfoManager
/*    */   extends MCH_AircraftInfoManager {
/* 14 */   private static MCP_PlaneInfoManager instance = new MCP_PlaneInfoManager();
/* 15 */   public static HashMap map = new LinkedHashMap<>();
/*    */ 
/*    */   
/*    */   public static MCP_PlaneInfo get(String name) {
/* 19 */     return (MCP_PlaneInfo)map.get(name);
/*    */   }
/*    */   
/*    */   public static MCP_PlaneInfoManager getInstance() {
/* 23 */     return instance;
/*    */   }
/*    */   
/*    */   public MCH_BaseInfo newInfo(String name) {
/* 27 */     return (MCH_BaseInfo)new MCP_PlaneInfo(name);
/*    */   }
/*    */   
/*    */   public Map getMap() {
/* 31 */     return map;
/*    */   }
/*    */   
/*    */   public static MCP_PlaneInfo getFromItem(Item item) {
/* 35 */     return getInstance().getAcInfoFromItem(item);
/*    */   }
/*    */   public MCP_PlaneInfo getAcInfoFromItem(Item item) {
/*    */     MCP_PlaneInfo info;
/* 39 */     if (item == null) {
/* 40 */       return null;
/*    */     }
/* 42 */     Iterator<MCP_PlaneInfo> i$ = map.values().iterator();
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


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\plane\MCP_PlaneInfoManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */