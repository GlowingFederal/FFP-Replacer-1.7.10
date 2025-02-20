/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ 
/*    */ public class MCH_PacketNotifyInfoReloaded
/*    */   extends MCH_Packet {
/* 12 */   public int type = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 16 */     return 536875063;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 21 */       this.type = data.readInt();
/* 22 */     } catch (Exception var3) {
/* 23 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 30 */       dos.writeInt(this.type);
/* 31 */     } catch (IOException var3) {
/* 32 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendRealodAc() {
/* 38 */     MCH_PacketNotifyInfoReloaded s = new MCH_PacketNotifyInfoReloaded();
/* 39 */     s.type = 0;
/* 40 */     W_Network.sendToServer((W_PacketBase)s);
/*    */   }
/*    */   
/*    */   public static void sendRealodAllWeapon() {
/* 44 */     MCH_PacketNotifyInfoReloaded s = new MCH_PacketNotifyInfoReloaded();
/* 45 */     s.type = 1;
/* 46 */     W_Network.sendToServer((W_PacketBase)s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketNotifyInfoReloaded.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */