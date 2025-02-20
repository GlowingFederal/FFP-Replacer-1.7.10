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
/*    */ public class MCH_PacketSeatListResponse extends MCH_Packet {
/* 14 */   public int entityID_AC = -1;
/* 15 */   public byte seatNum = -1;
/* 16 */   public int[] seatEntityID = new int[] { -1 };
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 20 */     return 268439569;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 25 */       this.entityID_AC = data.readInt();
/* 26 */       this.seatNum = data.readByte();
/* 27 */       if (this.seatNum > 0) {
/* 28 */         this.seatEntityID = new int[this.seatNum];
/*    */         
/* 30 */         for (int e = 0; e < this.seatNum; e++) {
/* 31 */           this.seatEntityID[e] = data.readInt();
/*    */         }
/*    */       } 
/* 34 */     } catch (Exception var3) {
/* 35 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 42 */       dos.writeInt(this.entityID_AC);
/* 43 */       if (this.seatNum > 0 && this.seatEntityID != null && this.seatEntityID.length == this.seatNum) {
/* 44 */         dos.writeByte(this.seatNum);
/*    */         
/* 46 */         for (int e = 0; e < this.seatNum; e++) {
/* 47 */           dos.writeInt(this.seatEntityID[e]);
/*    */         }
/*    */       } else {
/* 50 */         dos.writeByte(-1);
/*    */       } 
/* 52 */     } catch (IOException var3) {
/* 53 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendSeatList(MCH_EntityAircraft ac, EntityPlayer player) {
/* 59 */     MCH_PacketSeatListResponse s = new MCH_PacketSeatListResponse();
/* 60 */     s.setParameter(ac);
/* 61 */     W_Network.sendToPlayer((W_PacketBase)s, player);
/*    */   }
/*    */   
/*    */   protected void setParameter(MCH_EntityAircraft ac) {
/* 65 */     if (ac != null) {
/* 66 */       this.entityID_AC = W_Entity.getEntityId((Entity)ac);
/* 67 */       this.seatNum = (byte)(ac.getSeats()).length;
/* 68 */       if (this.seatNum > 0) {
/* 69 */         this.seatEntityID = new int[this.seatNum];
/*    */         
/* 71 */         for (int i = 0; i < this.seatNum; i++) {
/* 72 */           this.seatEntityID[i] = W_Entity.getEntityId((Entity)ac.getSeat(i));
/*    */         }
/*    */       } else {
/* 75 */         this.seatEntityID = new int[] { -1 };
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketSeatListResponse.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */