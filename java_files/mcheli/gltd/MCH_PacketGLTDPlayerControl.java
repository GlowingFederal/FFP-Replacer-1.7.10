/*    */ package mcheli.gltd;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Packet;
/*    */ 
/*    */ public class MCH_PacketGLTDPlayerControl
/*    */   extends MCH_Packet
/*    */ {
/* 11 */   public byte switchCameraMode = -1;
/* 12 */   public byte switchWeapon = -1;
/*    */   public boolean useWeapon = false;
/* 14 */   public int useWeaponOption1 = 0;
/* 15 */   public int useWeaponOption2 = 0;
/* 16 */   public double useWeaponPosX = 0.0D;
/* 17 */   public double useWeaponPosY = 0.0D;
/* 18 */   public double useWeaponPosZ = 0.0D;
/*    */   
/*    */   public boolean unmount = false;
/*    */   
/*    */   public int getMessageID() {
/* 23 */     return 536887312;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 28 */       this.switchCameraMode = data.readByte();
/* 29 */       this.switchWeapon = data.readByte();
/* 30 */       this.useWeapon = (data.readByte() != 0);
/* 31 */       if (this.useWeapon) {
/* 32 */         this.useWeaponOption1 = data.readInt();
/* 33 */         this.useWeaponOption2 = data.readInt();
/* 34 */         this.useWeaponPosX = data.readDouble();
/* 35 */         this.useWeaponPosY = data.readDouble();
/* 36 */         this.useWeaponPosZ = data.readDouble();
/*    */       } 
/*    */       
/* 39 */       this.unmount = (data.readByte() != 0);
/* 40 */     } catch (Exception var3) {
/* 41 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 48 */       dos.writeByte(this.switchCameraMode);
/* 49 */       dos.writeByte(this.switchWeapon);
/* 50 */       dos.writeByte(this.useWeapon ? 1 : 0);
/* 51 */       if (this.useWeapon) {
/* 52 */         dos.writeInt(this.useWeaponOption1);
/* 53 */         dos.writeInt(this.useWeaponOption2);
/* 54 */         dos.writeDouble(this.useWeaponPosX);
/* 55 */         dos.writeDouble(this.useWeaponPosY);
/* 56 */         dos.writeDouble(this.useWeaponPosZ);
/*    */       } 
/*    */       
/* 59 */       dos.writeByte(this.unmount ? 1 : 0);
/* 60 */     } catch (IOException var3) {
/* 61 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gltd\MCH_PacketGLTDPlayerControl.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */