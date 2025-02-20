/*    */ package mcheli;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import java.io.DataOutputStream;
/*    */ import java.io.IOException;
/*    */ import mcheli.wrapper.W_Network;
/*    */ 
/*    */ public class MCH_PacketEffectExplosion
/*    */   extends MCH_Packet
/*    */ {
/* 11 */   ExplosionParam prm = new ExplosionParam();
/*    */ 
/*    */   
/*    */   public int getMessageID() {
/* 15 */     return 268437520;
/*    */   }
/*    */   
/*    */   public void readData(ByteArrayDataInput data) {
/*    */     try {
/* 20 */       this.prm.posX = data.readDouble();
/* 21 */       this.prm.posY = data.readDouble();
/* 22 */       this.prm.posZ = data.readDouble();
/* 23 */       this.prm.size = data.readFloat();
/* 24 */       this.prm.exploderID = data.readInt();
/* 25 */       this.prm.inWater = (data.readByte() != 0);
/* 26 */     } catch (Exception var3) {
/* 27 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void writeData(DataOutputStream dos) {
/*    */     try {
/* 34 */       dos.writeDouble(this.prm.posX);
/* 35 */       dos.writeDouble(this.prm.posY);
/* 36 */       dos.writeDouble(this.prm.posZ);
/* 37 */       dos.writeFloat(this.prm.size);
/* 38 */       dos.writeInt(this.prm.exploderID);
/* 39 */       dos.writeByte(this.prm.inWater ? 1 : 0);
/* 40 */     } catch (IOException var3) {
/* 41 */       var3.printStackTrace();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static ExplosionParam create() {
/* 47 */     return (new MCH_PacketEffectExplosion()).aaa();
/*    */   }
/*    */   
/*    */   private ExplosionParam aaa() {
/* 51 */     return new ExplosionParam();
/*    */   }
/*    */   
/*    */   public static void send(ExplosionParam param) {
/* 55 */     if (param != null) {
/* 56 */       MCH_PacketEffectExplosion s = new MCH_PacketEffectExplosion();
/* 57 */       s.prm = param;
/* 58 */       W_Network.sendToAllPlayers(s);
/*    */     } 
/*    */   }
/*    */   
/*    */   public class ExplosionParam {
/*    */     public double posX;
/*    */     public double posY;
/*    */     public double posZ;
/*    */     public float size;
/*    */     public int exploderID;
/*    */     public boolean inWater;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_PacketEffectExplosion.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */