/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import cpw.mods.fml.common.network.NetworkRegistry;
/*    */ import cpw.mods.fml.common.network.simpleimpl.SimpleNetworkWrapper;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
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
/*    */ public class W_Network
/*    */ {
/* 23 */   public static final SimpleNetworkWrapper INSTANCE = NetworkRegistry.INSTANCE.newSimpleChannel("MCHeli_CH");
/*    */   
/*    */   public static void sendToServer(W_PacketBase pkt) {
/* 26 */     INSTANCE.sendToServer(pkt);
/*    */   }
/*    */   
/*    */   public static void sendToPlayer(W_PacketBase pkt, EntityPlayer player) {
/* 30 */     if (player instanceof EntityPlayerMP) {
/* 31 */       INSTANCE.sendTo(pkt, (EntityPlayerMP)player);
/*    */     }
/*    */   }
/*    */   
/*    */   public static void sendToAllAround(W_PacketBase pkt, Entity sender, double renge) {
/* 36 */     NetworkRegistry.TargetPoint t = new NetworkRegistry.TargetPoint(sender.field_71093_bK, sender.field_70165_t, sender.field_70163_u, sender.field_70161_v, renge);
/* 37 */     INSTANCE.sendToAllAround(pkt, t);
/*    */   }
/*    */   
/*    */   public static void sendToAllPlayers(W_PacketBase pkt) {
/* 41 */     INSTANCE.sendToAll(pkt);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_Network.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */