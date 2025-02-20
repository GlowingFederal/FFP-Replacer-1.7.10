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
/*    */ public class MCH_PacketNotifyWeaponID
/*    */   extends MCH_Packet {
/* 14 */   public int entityID_Ac = -1;
/* 15 */   public int seatID = -1;
/* 16 */   public int weaponID = -1;
/* 17 */   public short ammo = 0;
/* 18 */   public short restAmmo = 0;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 22 */     return 268439601;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 27 */       this.entityID_Ac = data.readInt();
/* 28 */       this.seatID = data.readByte();
/* 29 */       this.weaponID = data.readByte();
/* 30 */       this.ammo = data.readShort();
/* 31 */       this.restAmmo = data.readShort();
/* 32 */     } catch (Exception var3) {
/* 33 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 40 */       dos.writeInt(this.entityID_Ac);
/* 41 */       dos.writeByte(this.seatID);
/* 42 */       dos.writeByte(this.weaponID);
/* 43 */       dos.writeShort(this.ammo);
/* 44 */       dos.writeShort(this.restAmmo);
/* 45 */     } catch (IOException var3) {
/* 46 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(Entity sender, int sid, int wid, int ammo, int rest_ammo) {
/* 52 */     MCH_PacketNotifyWeaponID s = new MCH_PacketNotifyWeaponID();
/* 53 */     s.entityID_Ac = W_Entity.getEntityId(sender);
/* 54 */     s.seatID = sid;
/* 55 */     s.weaponID = wid;
/* 56 */     s.ammo = (short)ammo;
/* 57 */     s.restAmmo = (short)rest_ammo;
/* 58 */     W_Network.sendToAllAround((W_PacketBase)s, sender, 150.0D);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketNotifyWeaponID.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */