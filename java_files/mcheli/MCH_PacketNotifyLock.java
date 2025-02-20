/*    */ package mcheli;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ public class MCH_PacketNotifyLock
/*    */   extends MCH_Packet
/*    */ {
/* 14 */   public int entityID = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 18 */     return 536873984;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 23 */       this.entityID = data.readInt();
/* 24 */     } catch (Exception var3) {
/* 25 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 32 */       dos.writeInt(this.entityID);
/* 33 */     } catch (IOException var3) {
/* 34 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(Entity target) {
/* 40 */     if (target != null) {
/* 41 */       MCH_PacketNotifyLock s = new MCH_PacketNotifyLock();
/* 42 */       s.entityID = target.func_145782_y();
/* 43 */       W_Network.sendToServer(s);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendToPlayer(EntityPlayer entity) {
/* 49 */     if (entity instanceof net.minecraft.entity.player.EntityPlayerMP) {
/* 50 */       MCH_PacketNotifyLock s = new MCH_PacketNotifyLock();
/* 51 */       W_Network.sendToPlayer(s, entity);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_PacketNotifyLock.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */