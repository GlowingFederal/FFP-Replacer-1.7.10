/*    */ package mcheli.multiplay;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class MCH_PacketNotifySpotedEntity
/*    */   extends MCH_Packet {
/* 12 */   public int count = 0;
/* 13 */   public int num = 0;
/* 14 */   public int[] entityId = null;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 18 */     return 268437761;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 23 */       this.count = data.readShort();
/* 24 */       this.num = data.readShort();
/* 25 */       if (this.num > 0) {
/* 26 */         this.entityId = new int[this.num];
/*    */         
/* 28 */         for (int e = 0; e < this.num; e++) {
/* 29 */           this.entityId[e] = data.readInt();
/*    */         }
/*    */       } else {
/* 32 */         this.num = 0;
/*    */       } 
/* 34 */     } catch (Exception var3) {
/* 35 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 42 */       dos.writeShort(this.count);
/* 43 */       dos.writeShort(this.num);
/*    */       
/* 45 */       for (int e = 0; e < this.num; e++) {
/* 46 */         dos.writeInt(this.entityId[e]);
/*    */       }
/* 48 */     } catch (Exception var3) {
/* 49 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(EntityPlayer player, int count, int[] entityId) {
/* 55 */     if (player != null && entityId != null && entityId.length > 0 && count > 0) {
/* 56 */       if (count > 30000) {
/* 57 */         count = 30000;
/*    */       }
/*    */       
/* 60 */       MCH_PacketNotifySpotedEntity pkt = new MCH_PacketNotifySpotedEntity();
/* 61 */       pkt.count = count;
/* 62 */       pkt.num = entityId.length;
/* 63 */       if (pkt.num > 300) {
/* 64 */         pkt.num = 300;
/*    */       }
/*    */       
/* 67 */       if (pkt.num > entityId.length) {
/* 68 */         pkt.num = entityId.length;
/*    */       }
/*    */       
/* 71 */       pkt.entityId = entityId;
/* 72 */       W_Network.sendToPlayer((W_PacketBase)pkt, player);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_PacketNotifySpotedEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */