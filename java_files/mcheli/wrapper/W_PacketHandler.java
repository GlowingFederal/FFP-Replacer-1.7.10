/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
/*    */ import cpw.mods.fml.common.network.simpleimpl.MessageContext;
/*    */ import mcheli.MCH_Lib;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_PacketHandler
/*    */   implements IPacketHandler, IMessageHandler<W_PacketBase, W_PacketDummy>
/*    */ {
/*    */   public void onPacket(ByteArrayDataInput data, EntityPlayer player) {}
/*    */   
/*    */   public W_PacketDummy onMessage(W_PacketBase message, MessageContext ctx) {
/*    */     try {
/* 30 */       if (message.data != null) {
/* 31 */         if (ctx.side.isClient()) {
/* 32 */           if (MCH_Lib.getClientPlayer() != null) {
/* 33 */             W_NetworkRegistry.packetHandler.onPacket(message.data, (EntityPlayer)MCH_Lib.getClientPlayer());
/*    */           }
/*    */         } else {
/* 36 */           W_NetworkRegistry.packetHandler.onPacket(message.data, (EntityPlayer)(ctx.getServerHandler()).field_147369_b);
/*    */         }
/*    */       
/*    */       }
/* 40 */     } catch (Exception e) {
/* 41 */       e.printStackTrace();
/*    */     } 
/* 43 */     return null;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_PacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */