/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import com.google.common.io.ByteStreams;
/*    */ import cpw.mods.fml.common.network.simpleimpl.IMessage;
/*    */ import io.netty.buffer.ByteBuf;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_PacketBase
/*    */   implements IMessage
/*    */ {
/*    */   ByteArrayDataInput data;
/*    */   
/*    */   public byte[] createData() {
/* 22 */     return null;
/*    */   }
/*    */   
/*    */   public void fromBytes(ByteBuf buf) {
/* 26 */     byte[] dst = new byte[(buf.array()).length - 1];
/* 27 */     buf.getBytes(0, dst);
/* 28 */     this.data = ByteStreams.newDataInput(dst);
/*    */   }
/*    */   
/*    */   public void toBytes(ByteBuf buf) {
/* 32 */     buf.writeBytes(createData());
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_PacketBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */