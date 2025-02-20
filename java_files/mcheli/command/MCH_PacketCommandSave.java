/*    */ package mcheli.command;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Packet;
/*    */ 
/*    */ public class MCH_PacketCommandSave
/*    */   extends MCH_Packet {
/* 10 */   public String str = "";
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 16 */     return 536873729;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 21 */       this.str = data.readUTF();
/* 22 */     } catch (Exception var3) {
/* 23 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 30 */       dos.writeUTF(this.str);
/* 31 */     } catch (IOException var3) {
/* 32 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void send(String cmd) {}
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\command\MCH_PacketCommandSave.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */