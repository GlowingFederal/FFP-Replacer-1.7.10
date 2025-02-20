/*    */ package mcheli;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.wrapper.W_Network;
/*    */ 
/*    */ public class MCH_PacketIndOpenScreen
/*    */   extends MCH_Packet
/*    */ {
/* 11 */   public int guiID = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 15 */     return 536872992;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 20 */       this.guiID = data.readInt();
/* 21 */     } catch (Exception var3) {
/* 22 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 29 */       dos.writeInt(this.guiID);
/* 30 */     } catch (IOException var3) {
/* 31 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(int gui_id) {
/* 37 */     if (gui_id >= 0) {
/* 38 */       MCH_PacketIndOpenScreen s = new MCH_PacketIndOpenScreen();
/* 39 */       s.guiID = gui_id;
/* 40 */       W_Network.sendToServer(s);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_PacketIndOpenScreen.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */