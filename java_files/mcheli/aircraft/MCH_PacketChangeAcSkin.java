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
/*    */ public class MCH_PacketChangeAcSkin extends MCH_Packet {
/* 13 */   public int entityID_Ac = -1;
/*    */   
/*    */   public int getMessageID() {
/* 16 */     return 536875762;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 21 */       this.entityID_Ac = data.readInt();
/* 22 */     } catch (Exception var3) {
/* 23 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 30 */       dos.writeInt(this.entityID_Ac);
/* 31 */     } catch (IOException var3) {
/* 32 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(MCH_EntityAircraft ac) {
/* 38 */     if (ac != null) {
/* 39 */       MCH_PacketChangeAcSkin s = new MCH_PacketChangeAcSkin();
/* 40 */       s.entityID_Ac = W_Entity.getEntityId((Entity)ac);
/* 41 */       W_Network.sendToServer((W_PacketBase)s);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketChangeAcSkin.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */