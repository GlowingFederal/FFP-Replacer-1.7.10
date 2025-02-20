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
/*    */ public class MCH_PacketSetTargetPoint extends MCH_Packet {
/* 13 */   public int entityID_Ac = -1;
/* 14 */   public int weaponID = -1;
/*    */   
/*    */   public int x;
/*    */   
/*    */   public int getMessageID() {
/* 19 */     return 576875059;
/*    */   }
/*    */   public int y; public int z;
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 24 */       this.entityID_Ac = data.readInt();
/* 25 */       this.weaponID = data.readByte();
/* 26 */       this.x = data.readInt();
/* 27 */       this.y = data.readInt();
/* 28 */       this.z = data.readInt();
/* 29 */     } catch (Exception var3) {
/* 30 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 37 */       dos.writeInt(this.entityID_Ac);
/* 38 */       dos.writeByte(this.weaponID);
/* 39 */       dos.writeInt(this.x);
/* 40 */       dos.writeInt(this.y);
/* 41 */       dos.writeInt(this.z);
/* 42 */     } catch (IOException var3) {
/* 43 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(MCH_EntityAircraft ac, int weaponId, int x, int y, int z) {
/* 49 */     if (ac != null) {
/* 50 */       MCH_PacketSetTargetPoint s = new MCH_PacketSetTargetPoint();
/* 51 */       s.entityID_Ac = W_Entity.getEntityId((Entity)ac);
/* 52 */       s.weaponID = weaponId;
/* 53 */       s.x = x;
/* 54 */       s.y = y;
/* 55 */       s.z = z;
/* 56 */       W_Network.sendToServer((W_PacketBase)s);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketSetTargetPoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */