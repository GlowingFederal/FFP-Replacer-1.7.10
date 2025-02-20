/*    */ package mcheli.tank;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.aircraft.MCH_PacketPlayerControlBase;
/*    */ 
/*    */ public class MCH_TankPacketPlayerControl
/*    */   extends MCH_PacketPlayerControlBase
/*    */ {
/* 11 */   public byte switchVtol = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 15 */     return 537919504;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/* 19 */     super.readData(data);
/*    */     
/*    */     try {
/* 22 */       this.switchVtol = data.readByte();
/* 23 */     } catch (Exception var3) {
/* 24 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/* 30 */     super.writeData(dos);
/*    */     
/*    */     try {
/* 33 */       dos.writeByte(this.switchVtol);
/* 34 */     } catch (IOException var3) {
/* 35 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tank\MCH_TankPacketPlayerControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */