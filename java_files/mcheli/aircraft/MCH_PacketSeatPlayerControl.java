/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Packet;
/*    */ 
/*    */ public class MCH_PacketSeatPlayerControl
/*    */   extends MCH_Packet
/*    */ {
/*    */   public boolean isUnmount = false;
/* 12 */   public byte switchSeat = 0;
/*    */   
/*    */   public boolean parachuting;
/*    */   
/*    */   public int getMessageID() {
/* 17 */     return 536875040;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 22 */       byte e = data.readByte();
/* 23 */       this.isUnmount = ((e >> 3 & 0x1) != 0);
/* 24 */       this.switchSeat = (byte)(e >> 1 & 0x3);
/* 25 */       this.parachuting = ((e >> 0 & 0x1) != 0);
/* 26 */     } catch (Exception var3) {
/* 27 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 34 */       byte e = (byte)((this.isUnmount ? 8 : 0) | this.switchSeat << 1 | (this.parachuting ? 1 : 0));
/* 35 */       dos.writeByte(e);
/* 36 */     } catch (IOException var3) {
/* 37 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketSeatPlayerControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */