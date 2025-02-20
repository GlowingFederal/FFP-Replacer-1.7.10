/*    */ package mcheli.multiplay;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ import net.minecraft.entity.EntityLivingBase;
/*    */ 
/*    */ public class MCH_PacketIndSpotEntity
/*    */   extends MCH_Packet {
/* 12 */   public int targetFilter = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 16 */     return 536873216;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 21 */       this.targetFilter = data.readInt();
/* 22 */     } catch (Exception var3) {
/* 23 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 30 */       dos.writeInt(this.targetFilter);
/* 31 */     } catch (Exception var3) {
/* 32 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(EntityLivingBase spoter, int targetFilter) {
/* 38 */     MCH_PacketIndSpotEntity s = new MCH_PacketIndSpotEntity();
/* 39 */     s.targetFilter = targetFilter;
/* 40 */     W_Network.sendToServer((W_PacketBase)s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_PacketIndSpotEntity.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */