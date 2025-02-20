/*    */ package mcheli;
/*    */ 
/*    */ import cpw.mods.fml.common.eventhandler.SubscribeEvent;
/*    */ import cpw.mods.fml.common.gameevent.TickEvent;
/*    */ import cpw.mods.fml.common.network.internal.FMLProxyPacket;
/*    */ import java.util.HashMap;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import java.util.Queue;
/*    */ import mcheli.wrapper.W_Reflection;
/*    */ import net.minecraft.network.NetworkManager;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MCH_ServerTickHandler
/*    */ {
/* 17 */   HashMap rcvMap = new HashMap<>();
/* 18 */   HashMap sndMap = new HashMap<>();
/* 19 */   int sndPacketNum = 0;
/* 20 */   int rcvPacketNum = 0;
/*    */   
/*    */   int tick;
/*    */   
/*    */   @SubscribeEvent
/*    */   public void onServerTickEvent(TickEvent.ServerTickEvent event) {
/* 26 */     TickEvent.Phase var10001 = event.phase;
/* 27 */     if (event.phase == TickEvent.Phase.START);
/*    */ 
/*    */ 
/*    */     
/* 31 */     var10001 = event.phase;
/* 32 */     if (event.phase == TickEvent.Phase.END);
/*    */   }
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private void onServerTickPre() {
/* 39 */     this.tick++;
/* 40 */     List<NetworkManager> list = W_Reflection.getNetworkManagers();
/* 41 */     if (list != null) {
/* 42 */       for (int i = 0; i < list.size(); i++) {
/* 43 */         Queue queue = W_Reflection.getReceivedPacketsQueue(list.get(i));
/* 44 */         if (queue != null) {
/* 45 */           putMap(this.rcvMap, queue.iterator());
/* 46 */           this.rcvPacketNum += queue.size();
/*    */         } 
/*    */         
/* 49 */         queue = W_Reflection.getSendPacketsQueue(list.get(i));
/* 50 */         if (queue != null) {
/* 51 */           putMap(this.sndMap, queue.iterator());
/* 52 */           this.sndPacketNum += queue.size();
/*    */         } 
/*    */       } 
/*    */     }
/*    */     
/* 57 */     if (this.tick >= 20) {
/* 58 */       this.tick = 0;
/* 59 */       this.rcvPacketNum = this.sndPacketNum = 0;
/* 60 */       this.rcvMap.clear();
/* 61 */       this.sndMap.clear();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void putMap(HashMap<String, Integer> map, Iterator iterator) {
/* 67 */     while (iterator.hasNext()) {
/* 68 */       Object o = iterator.next();
/* 69 */       String key = o.getClass().getName().toString();
/* 70 */       if (key.startsWith("net.minecraft.")) {
/* 71 */         key = "Minecraft";
/* 72 */       } else if (o instanceof FMLProxyPacket) {
/* 73 */         FMLProxyPacket p = (FMLProxyPacket)o;
/* 74 */         key = p.channel();
/*    */       } else {
/* 76 */         key = "Unknown!";
/*    */       } 
/*    */       
/* 79 */       if (map.containsKey(key)) {
/* 80 */         map.put(key, Integer.valueOf(1 + ((Integer)map.get(key)).intValue())); continue;
/*    */       } 
/* 82 */       map.put(key, Integer.valueOf(1));
/*    */     } 
/*    */   }
/*    */   
/*    */   private void onServerTickPost() {}
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_ServerTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */