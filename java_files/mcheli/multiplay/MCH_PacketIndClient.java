/*    */ package mcheli.multiplay;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ 
/*    */ public class MCH_PacketIndClient extends MCH_Packet {
/* 13 */   public int CmdID = -1;
/*    */   
/*    */   public String CmdStr;
/*    */   
/*    */   public int getMessageID() {
/* 18 */     return 268438032;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 23 */       this.CmdID = data.readInt();
/* 24 */       this.CmdStr = data.readUTF();
/* 25 */     } catch (Exception var3) {
/* 26 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 33 */       dos.writeInt(this.CmdID);
/* 34 */       dos.writeUTF(this.CmdStr);
/* 35 */     } catch (IOException var3) {
/* 36 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(int cmd_id, String str, EntityPlayerMP player) {
/* 42 */     if (cmd_id <= 0)
/*    */       return; 
/* 44 */     MCH_PacketIndClient s = new MCH_PacketIndClient();
/* 45 */     s.CmdID = cmd_id;
/* 46 */     s.CmdStr = str;
/* 47 */     W_Network.sendToPlayer((W_PacketBase)s, (EntityPlayer)player);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_PacketIndClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */