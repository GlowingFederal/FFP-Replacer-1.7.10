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
/*    */ public class MCH_PacketIndReload extends MCH_Packet {
/* 13 */   public int entityID_Ac = -1;
/* 14 */   public int weaponID = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 18 */     return 536875059;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 23 */       this.entityID_Ac = data.readInt();
/* 24 */       this.weaponID = data.readByte();
/* 25 */     } catch (Exception var3) {
/* 26 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 33 */       dos.writeInt(this.entityID_Ac);
/* 34 */       dos.writeByte(this.weaponID);
/* 35 */     } catch (IOException var3) {
/* 36 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(MCH_EntityAircraft ac, int weaponId) {
/* 42 */     if (ac != null) {
/* 43 */       MCH_PacketIndReload s = new MCH_PacketIndReload();
/* 44 */       s.entityID_Ac = W_Entity.getEntityId((Entity)ac);
/* 45 */       s.weaponID = weaponId;
/* 46 */       W_Network.sendToServer((W_PacketBase)s);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketIndReload.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */