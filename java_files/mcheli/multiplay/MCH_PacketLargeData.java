/*    */ package mcheli.multiplay;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ 
/*    */ public class MCH_PacketLargeData
/*    */   extends MCH_Packet {
/* 11 */   public int imageDataIndex = -1;
/* 12 */   public int imageDataSize = 0;
/* 13 */   public int imageDataTotalSize = 0;
/*    */   
/*    */   public byte[] buf;
/*    */   
/*    */   public int getMessageID() {
/* 18 */     return 536873472;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 23 */       this.imageDataIndex = data.readInt();
/* 24 */       this.imageDataSize = data.readInt();
/* 25 */       this.imageDataTotalSize = data.readInt();
/* 26 */       this.buf = new byte[this.imageDataSize];
/* 27 */       data.readFully(this.buf);
/* 28 */     } catch (Exception var3) {
/* 29 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 36 */       MCH_MultiplayClient.readImageData(dos);
/* 37 */     } catch (Exception var3) {
/* 38 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void send() {
/* 43 */     MCH_PacketLargeData p = new MCH_PacketLargeData();
/* 44 */     W_Network.sendToServer((W_PacketBase)p);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_PacketLargeData.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */