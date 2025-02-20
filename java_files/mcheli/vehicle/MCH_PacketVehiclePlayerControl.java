/*    */ package mcheli.vehicle;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.aircraft.MCH_PacketPlayerControlBase;
/*    */ 
/*    */ public class MCH_PacketVehiclePlayerControl
/*    */   extends MCH_PacketPlayerControlBase
/*    */ {
/* 11 */   public byte switchFold = -1;
/* 12 */   public int unhitchChainId = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 16 */     return 537002000;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/* 20 */     super.readData(data);
/*    */     
/*    */     try {
/* 23 */       this.switchFold = data.readByte();
/* 24 */       this.unhitchChainId = data.readInt();
/* 25 */     } catch (Exception var3) {
/* 26 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/* 32 */     super.writeData(dos);
/*    */     
/*    */     try {
/* 35 */       dos.writeByte(this.switchFold);
/* 36 */       dos.writeInt(this.unhitchChainId);
/* 37 */     } catch (IOException var3) {
/* 38 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\vehicle\MCH_PacketVehiclePlayerControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */