/*    */ package mcheli;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import net.minecraft.entity.player.EntityPlayerMP;
/*    */ import net.minecraft.server.MinecraftServer;
/*    */ 
/*    */ public class MCH_PacketNotifyServerSettings
/*    */   extends MCH_Packet {
/*    */   public boolean enableCamDistChange = true;
/*    */   public boolean enableEntityMarker = true;
/*    */   public boolean enablePVP = true;
/* 16 */   public double stingerLockRange = 120.0D;
/*    */   
/*    */   public boolean enableDebugBoundingBox = true;
/*    */   
/*    */   public int getMessageID() {
/* 21 */     return 268437568;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 26 */       byte e = data.readByte();
/* 27 */       this.enableCamDistChange = getBit(e, 0);
/* 28 */       this.enableEntityMarker = getBit(e, 1);
/* 29 */       this.enablePVP = getBit(e, 2);
/* 30 */       this.stingerLockRange = data.readFloat();
/* 31 */       this.enableDebugBoundingBox = getBit(e, 3);
/* 32 */     } catch (Exception var3) {
/* 33 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 40 */       byte e = 0;
/* 41 */       byte e1 = setBit(e, 0, this.enableCamDistChange);
/* 42 */       e1 = setBit(e1, 1, this.enableEntityMarker);
/* 43 */       e1 = setBit(e1, 2, this.enablePVP);
/* 44 */       e1 = setBit(e1, 3, this.enableDebugBoundingBox);
/* 45 */       dos.writeByte(e1);
/* 46 */       dos.writeFloat((float)this.stingerLockRange);
/* 47 */     } catch (IOException var3) {
/* 48 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send(EntityPlayerMP player) {
/* 54 */     MCH_PacketNotifyServerSettings s = new MCH_PacketNotifyServerSettings();
/* 55 */     MCH_Config var10001 = MCH_MOD.config;
/* 56 */     s.enableCamDistChange = !MCH_Config.DisableCameraDistChange.prmBool;
/* 57 */     var10001 = MCH_MOD.config;
/* 58 */     s.enableEntityMarker = MCH_Config.DisplayEntityMarker.prmBool;
/* 59 */     s.enablePVP = MinecraftServer.func_71276_C().func_71219_W();
/* 60 */     var10001 = MCH_MOD.config;
/* 61 */     s.stingerLockRange = MCH_Config.StingerLockRange.prmDouble;
/* 62 */     var10001 = MCH_MOD.config;
/* 63 */     s.enableDebugBoundingBox = MCH_Config.EnableDebugBoundingBox.prmBool;
/* 64 */     if (player != null) {
/* 65 */       W_Network.sendToPlayer(s, (EntityPlayer)player);
/*    */     } else {
/* 67 */       W_Network.sendToAllPlayers(s);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void sendAll() {
/* 73 */     send((EntityPlayerMP)null);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_PacketNotifyServerSettings.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */