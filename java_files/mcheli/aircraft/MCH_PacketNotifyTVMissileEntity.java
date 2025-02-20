/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ 
/*    */ public class MCH_PacketNotifyTVMissileEntity
/*    */   extends MCH_Packet {
/* 12 */   public int entityID_Ac = -1;
/* 13 */   public int entityID_TVMissile = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 17 */     return 268439600;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 22 */       this.entityID_Ac = data.readInt();
/* 23 */       this.entityID_TVMissile = data.readInt();
/* 24 */     } catch (Exception var3) {
/* 25 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 32 */       dos.writeInt(this.entityID_Ac);
/* 33 */       dos.writeInt(this.entityID_TVMissile);
/* 34 */     } catch (IOException var3) {
/* 35 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(int heliEntityID, int tvMissileEntityID) {
/* 41 */     MCH_PacketNotifyTVMissileEntity s = new MCH_PacketNotifyTVMissileEntity();
/* 42 */     s.entityID_Ac = heliEntityID;
/* 43 */     s.entityID_TVMissile = tvMissileEntityID;
/* 44 */     W_Network.sendToAllPlayers((W_PacketBase)s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketNotifyTVMissileEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */