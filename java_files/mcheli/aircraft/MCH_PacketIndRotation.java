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
/*    */ public class MCH_PacketIndRotation extends MCH_Packet {
/* 13 */   public int entityID_Ac = -1;
/* 14 */   public float yaw = 0.0F;
/* 15 */   public float pitch = 0.0F;
/* 16 */   public float roll = 0.0F;
/*    */   
/*    */   public boolean rollRev = false;
/*    */   
/*    */   public int getMessageID() {
/* 21 */     return 536875062;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 26 */       this.entityID_Ac = data.readInt();
/* 27 */       this.yaw = data.readFloat();
/* 28 */       this.pitch = data.readFloat();
/* 29 */       this.roll = data.readFloat();
/* 30 */       this.rollRev = (data.readByte() != 0);
/* 31 */     } catch (Exception var3) {
/* 32 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 39 */       dos.writeInt(this.entityID_Ac);
/* 40 */       dos.writeFloat(this.yaw);
/* 41 */       dos.writeFloat(this.pitch);
/* 42 */       dos.writeFloat(this.roll);
/* 43 */       dos.writeByte(this.rollRev ? 1 : 0);
/* 44 */     } catch (IOException var3) {
/* 45 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(MCH_EntityAircraft ac) {
/* 51 */     if (ac != null) {
/* 52 */       MCH_PacketIndRotation s = new MCH_PacketIndRotation();
/* 53 */       s.entityID_Ac = W_Entity.getEntityId((Entity)ac);
/* 54 */       s.yaw = ac.getRotYaw();
/* 55 */       s.pitch = ac.getRotPitch();
/* 56 */       s.roll = ac.getRotRoll();
/* 57 */       s.rollRev = ac.aircraftRollRev;
/* 58 */       W_Network.sendToServer((W_PacketBase)s);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketIndRotation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */