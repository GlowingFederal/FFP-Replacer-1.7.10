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
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class MCH_PacketNotifyOnMountEntity
/*    */   extends MCH_Packet {
/* 15 */   public int entityID_Ac = -1;
/* 16 */   public int entityID_rider = -1;
/* 17 */   public int seatID = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 21 */     return 268439632;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 26 */       this.entityID_Ac = data.readInt();
/* 27 */       this.entityID_rider = data.readInt();
/* 28 */       this.seatID = data.readByte();
/* 29 */     } catch (Exception var3) {
/* 30 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 37 */       dos.writeInt(this.entityID_Ac);
/* 38 */       dos.writeInt(this.entityID_rider);
/* 39 */       dos.writeByte(this.seatID);
/* 40 */     } catch (IOException var3) {
/* 41 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(MCH_EntityAircraft ac, Entity rider, int seatId) {
/* 47 */     if (ac != null && rider != null) {
/* 48 */       Entity pilot = ac.getRiddenByEntity();
/* 49 */       if (pilot instanceof EntityPlayer && !pilot.field_70128_L) {
/* 50 */         MCH_PacketNotifyOnMountEntity s = new MCH_PacketNotifyOnMountEntity();
/* 51 */         s.entityID_Ac = W_Entity.getEntityId((Entity)ac);
/* 52 */         s.entityID_rider = W_Entity.getEntityId(rider);
/* 53 */         s.seatID = seatId;
/* 54 */         W_Network.sendToPlayer((W_PacketBase)s, (EntityPlayer)pilot);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketNotifyOnMountEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */