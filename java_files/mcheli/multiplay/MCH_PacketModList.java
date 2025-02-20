/*    */ package mcheli.multiplay;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.util.ArrayList;
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class MCH_PacketModList
/*    */   extends MCH_Packet {
/*    */   public boolean firstData = false;
/* 16 */   public int id = 0;
/* 17 */   public int num = 0;
/* 18 */   public List list = new ArrayList();
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 22 */     return 536873473;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 27 */       this.firstData = (data.readByte() == 1);
/* 28 */       this.id = data.readInt();
/* 29 */       this.num = data.readInt();
/*    */       
/* 31 */       for (int e = 0; e < this.num; e++) {
/* 32 */         this.list.add(data.readUTF());
/*    */       }
/* 34 */     } catch (Exception var3) {
/* 35 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 42 */       dos.writeByte(this.firstData ? 1 : 0);
/* 43 */       dos.writeInt(this.id);
/* 44 */       dos.writeInt(this.num);
/* 45 */       Iterator<String> e = this.list.iterator();
/*    */       
/* 47 */       while (e.hasNext()) {
/* 48 */         String s = e.next();
/* 49 */         dos.writeUTF(s);
/*    */       } 
/* 51 */     } catch (Exception var4) {
/* 52 */       var4.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(EntityPlayer player, MCH_PacketModList p) {
/* 58 */     W_Network.sendToPlayer((W_PacketBase)p, player);
/*    */   }
/*    */   
/*    */   public static void send(List list, int id) {
/* 62 */     MCH_PacketModList p = null;
/* 63 */     int size = 0;
/* 64 */     boolean isFirst = true;
/* 65 */     Iterator<String> i$ = list.iterator();
/*    */     
/* 67 */     while (i$.hasNext()) {
/* 68 */       String s = i$.next();
/* 69 */       if (p == null) {
/* 70 */         p = new MCH_PacketModList();
/* 71 */         p.id = id;
/* 72 */         p.firstData = isFirst;
/* 73 */         isFirst = false;
/*    */       } 
/*    */       
/* 76 */       p.list.add(s);
/* 77 */       size += s.length() + 2;
/* 78 */       if (size > 1024) {
/* 79 */         p.num = p.list.size();
/* 80 */         W_Network.sendToServer((W_PacketBase)p);
/* 81 */         p = null;
/* 82 */         size = 0;
/*    */       } 
/*    */     } 
/*    */     
/* 86 */     if (p != null) {
/* 87 */       p.num = p.list.size();
/* 88 */       W_Network.sendToServer((W_PacketBase)p);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_PacketModList.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */