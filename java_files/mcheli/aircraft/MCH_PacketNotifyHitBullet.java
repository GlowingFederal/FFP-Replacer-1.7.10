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
/*    */ public class MCH_PacketNotifyHitBullet extends MCH_Packet {
/* 14 */   public int entityID_Ac = -1;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 18 */     return 268439602;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 23 */       this.entityID_Ac = data.readInt();
/* 24 */     } catch (Exception var3) {
/* 25 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 32 */       dos.writeInt(this.entityID_Ac);
/* 33 */     } catch (IOException var3) {
/* 34 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(MCH_EntityAircraft ac, EntityPlayer rider) {
/* 40 */     if (rider != null && !rider.field_70128_L) {
/* 41 */       MCH_PacketNotifyHitBullet s = new MCH_PacketNotifyHitBullet();
/* 42 */       s.entityID_Ac = (ac != null && !ac.field_70128_L) ? W_Entity.getEntityId((Entity)ac) : -1;
/* 43 */       W_Network.sendToPlayer((W_PacketBase)s, rider);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketNotifyHitBullet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */