/*    */ package mcheli.lweapon;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Packet;
/*    */ 
/*    */ public class MCH_PacketLightWeaponPlayerControl
/*    */   extends MCH_Packet
/*    */ {
/*    */   public boolean useWeapon = false;
/* 12 */   public int useWeaponOption1 = 0;
/* 13 */   public int useWeaponOption2 = 0;
/* 14 */   public double useWeaponPosX = 0.0D;
/* 15 */   public double useWeaponPosY = 0.0D;
/* 16 */   public double useWeaponPosZ = 0.0D;
/* 17 */   public int cmpReload = 0;
/* 18 */   public int camMode = 0;
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 22 */     return 536936464;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 27 */       this.useWeapon = (data.readByte() != 0);
/* 28 */       if (this.useWeapon) {
/* 29 */         this.useWeaponOption1 = data.readInt();
/* 30 */         this.useWeaponOption2 = data.readInt();
/* 31 */         this.useWeaponPosX = data.readDouble();
/* 32 */         this.useWeaponPosY = data.readDouble();
/* 33 */         this.useWeaponPosZ = data.readDouble();
/*    */       } 
/*    */       
/* 36 */       this.cmpReload = data.readByte();
/* 37 */       this.camMode = data.readByte();
/* 38 */     } catch (Exception var3) {
/* 39 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 46 */       dos.writeByte(this.useWeapon ? 1 : 0);
/* 47 */       if (this.useWeapon) {
/* 48 */         dos.writeInt(this.useWeaponOption1);
/* 49 */         dos.writeInt(this.useWeaponOption2);
/* 50 */         dos.writeDouble(this.useWeaponPosX);
/* 51 */         dos.writeDouble(this.useWeaponPosY);
/* 52 */         dos.writeDouble(this.useWeaponPosZ);
/*    */       } 
/*    */       
/* 55 */       dos.writeByte(this.cmpReload);
/* 56 */       dos.writeByte(this.camMode);
/* 57 */     } catch (IOException var3) {
/* 58 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\lweapon\MCH_PacketLightWeaponPlayerControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */