/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.MCH_Packet;
/*    */ import mcheli.wrapper.W_EntityRenderer;
/*    */ import mcheli.wrapper.W_Network;
/*    */ import mcheli.wrapper.W_PacketBase;
/*    */ 
/*    */ public class MCH_PacketNotifyClientSetting
/*    */   extends MCH_Packet
/*    */ {
/*    */   public boolean dismountAll = true;
/*    */   public boolean heliAutoThrottleDown;
/*    */   public boolean planeAutoThrottleDown;
/*    */   public boolean tankAutoThrottleDown;
/*    */   public boolean shaderSupport = false;
/*    */   
/*    */   public int getMessageID() {
/* 23 */     return 536875072;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput di) {
/*    */     try {
/* 28 */       boolean e = false;
/* 29 */       byte e1 = di.readByte();
/* 30 */       this.dismountAll = getBit(e1, 0);
/* 31 */       this.heliAutoThrottleDown = getBit(e1, 1);
/* 32 */       this.planeAutoThrottleDown = getBit(e1, 2);
/* 33 */       this.tankAutoThrottleDown = getBit(e1, 3);
/* 34 */       this.shaderSupport = getBit(e1, 4);
/* 35 */     } catch (Exception var3) {
/* 36 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 43 */       byte e = 0;
/* 44 */       byte e1 = setBit(e, 0, this.dismountAll);
/* 45 */       e1 = setBit(e1, 1, this.heliAutoThrottleDown);
/* 46 */       e1 = setBit(e1, 2, this.planeAutoThrottleDown);
/* 47 */       e1 = setBit(e1, 3, this.tankAutoThrottleDown);
/* 48 */       e1 = setBit(e1, 4, this.shaderSupport);
/* 49 */       dos.writeByte(e1);
/* 50 */     } catch (IOException var3) {
/* 51 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void send() {
/* 57 */     MCH_PacketNotifyClientSetting s = new MCH_PacketNotifyClientSetting();
/* 58 */     MCH_Config var10001 = MCH_MOD.config;
/* 59 */     s.dismountAll = MCH_Config.DismountAll.prmBool;
/* 60 */     var10001 = MCH_MOD.config;
/* 61 */     s.heliAutoThrottleDown = MCH_Config.AutoThrottleDownHeli.prmBool;
/* 62 */     var10001 = MCH_MOD.config;
/* 63 */     s.planeAutoThrottleDown = MCH_Config.AutoThrottleDownPlane.prmBool;
/* 64 */     var10001 = MCH_MOD.config;
/* 65 */     s.tankAutoThrottleDown = MCH_Config.AutoThrottleDownTank.prmBool;
/* 66 */     s.shaderSupport = W_EntityRenderer.isShaderSupport();
/* 67 */     W_Network.sendToServer((W_PacketBase)s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketNotifyClientSetting.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */