/*    */ package mcheli.command;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ import net.minecraft.util.IChatComponent;
/*    */ 
/*    */ public class MCH_PacketTitle
/*    */   extends MCH_Packet
/*    */ {
/* 14 */   public IChatComponent chatComponent = null;
/* 15 */   public int showTime = 1;
/* 16 */   public int position = 0;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 20 */     return 268438272;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 25 */       this.chatComponent = IChatComponent.Serializer.func_150699_a(data.readUTF());
/* 26 */       this.showTime = data.readShort();
/* 27 */       this.position = data.readShort();
/* 28 */     } catch (Exception var3) {
/* 29 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 36 */       dos.writeUTF(IChatComponent.Serializer.func_150696_a(this.chatComponent));
/* 37 */       dos.writeShort(this.showTime);
/* 38 */       dos.writeShort(this.position);
/* 39 */     } catch (IOException var3) {
/* 40 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(IChatComponent chat, int showTime, int pos) {
/* 46 */     MCH_PacketTitle s = new MCH_PacketTitle();
/* 47 */     s.chatComponent = chat;
/* 48 */     s.showTime = showTime;
/* 49 */     s.position = pos;
/* 50 */     W_Network.sendToAllPlayers((W_PacketBase)s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\command\MCH_PacketTitle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */