/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import cpw.mods.fml.common.network.IGuiHandler;
/*    */ import cpw.mods.fml.common.network.NetworkRegistry;
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import net.minecraft.entity.player.EntityPlayer;
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
/*    */ public class W_NetworkRegistry
/*    */ {
/*    */   public static W_PacketHandler packetHandler;
/*    */   
/*    */   public static void registerChannel(W_PacketHandler handler, String name) {
/* 22 */     packetHandler = handler;
/* 23 */     W_Network.INSTANCE.registerMessage(W_PacketHandler.class, W_PacketBase.class, 0, Side.SERVER);
/* 24 */     W_Network.INSTANCE.registerMessage(W_PacketHandler.class, W_PacketBase.class, 0, Side.CLIENT);
/*    */   }
/*    */ 
/*    */   
/*    */   public static void handlePacket(EntityPlayer player, byte[] data) {}
/*    */   
/*    */   public static void registerGuiHandler(Object mod, IGuiHandler handler) {
/* 31 */     NetworkRegistry.INSTANCE.registerGuiHandler(mod, handler);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_NetworkRegistry.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */