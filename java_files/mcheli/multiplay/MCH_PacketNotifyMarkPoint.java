/*    */ package mcheli.multiplay;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class MCH_PacketNotifyMarkPoint
/*    */   extends MCH_Packet
/*    */ {
/* 18 */   public int px = this.pz = 0;
/* 19 */   public int py = 0;
/*    */   public int pz;
/*    */   
/*    */   public int getMessageID() {
/* 23 */     return 268437762;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 28 */       this.px = data.readInt();
/* 29 */       this.py = data.readInt();
/* 30 */       this.pz = data.readInt();
/* 31 */     } catch (Exception var3) {
/* 32 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 39 */       dos.writeInt(this.px);
/* 40 */       dos.writeInt(this.py);
/* 41 */       dos.writeInt(this.pz);
/* 42 */     } catch (Exception var3) {
/* 43 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(EntityPlayer player, int x, int y, int z) {
/* 49 */     MCH_PacketNotifyMarkPoint pkt = new MCH_PacketNotifyMarkPoint();
/* 50 */     pkt.px = x;
/* 51 */     pkt.py = y;
/* 52 */     pkt.pz = z;
/* 53 */     W_Network.sendToPlayer((W_PacketBase)pkt, player);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_PacketNotifyMarkPoint.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */