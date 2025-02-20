/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Entity;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class MCH_PacketSeatListRequest extends MCH_Packet {
/* 13 */   public int entityID_AC = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 17 */     return 536875024;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 22 */       this.entityID_AC = data.readInt();
/* 23 */     } catch (Exception var3) {
/* 24 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 31 */       dos.writeInt(this.entityID_AC);
/* 32 */     } catch (IOException var3) {
/* 33 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void requestSeatList(MCH_EntityAircraft ac) {
/* 39 */     MCH_PacketSeatListRequest s = new MCH_PacketSeatListRequest();
/* 40 */     s.entityID_AC = W_Entity.getEntityId((Entity)ac);
/* 41 */     W_Network.sendToServer((W_PacketBase)s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketSeatListRequest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */