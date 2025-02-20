/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import mcheli.MCH_Packet;
/*     */ 
/*     */ public abstract class MCH_PacketPlayerControlBase
/*     */   extends MCH_Packet
/*     */ {
/*  11 */   public byte isUnmount = 0;
/*  12 */   public byte switchMode = -1;
/*  13 */   public byte switchCameraMode = 0;
/*  14 */   public byte switchWeapon = -1;
/*  15 */   public byte useFlareType = 0;
/*     */   public boolean useWeapon = false;
/*  17 */   public int useWeaponOption1 = 0;
/*  18 */   public int useWeaponOption2 = 0;
/*  19 */   public double useWeaponPosX = 0.0D;
/*  20 */   public double useWeaponPosY = 0.0D;
/*  21 */   public double useWeaponPosZ = 0.0D;
/*     */   public boolean throttleUp = false;
/*     */   public boolean throttleDown = false;
/*     */   public boolean moveLeft = false;
/*     */   public boolean moveRight = false;
/*     */   public boolean openGui;
/*  27 */   public byte switchHatch = 0;
/*  28 */   public byte switchFreeLook = 0;
/*  29 */   public byte switchGear = 0;
/*     */   public boolean ejectSeat = false;
/*  31 */   public byte putDownRack = 0;
/*     */   
/*     */   public boolean switchSearchLight = false;
/*     */   public boolean useBrake = false;
/*     */   
/*     */   public void readData(ByteArrayDataInput data) {
/*     */     try {
/*  38 */       short e = data.readShort();
/*  39 */       this.useWeapon = getBit(e, 0);
/*  40 */       this.throttleUp = getBit(e, 1);
/*  41 */       this.throttleDown = getBit(e, 2);
/*  42 */       this.moveLeft = getBit(e, 3);
/*  43 */       this.moveRight = getBit(e, 4);
/*  44 */       this.switchSearchLight = getBit(e, 5);
/*  45 */       this.ejectSeat = getBit(e, 6);
/*  46 */       this.openGui = getBit(e, 7);
/*  47 */       this.useBrake = getBit(e, 8);
/*  48 */       e = (short)data.readByte();
/*  49 */       this.putDownRack = (byte)(e >> 6 & 0x3);
/*  50 */       this.isUnmount = (byte)(e >> 4 & 0x3);
/*  51 */       this.useFlareType = (byte)(e >> 0 & 0xF);
/*  52 */       this.switchMode = data.readByte();
/*  53 */       this.switchWeapon = data.readByte();
/*  54 */       if (this.useWeapon) {
/*  55 */         this.useWeaponOption1 = data.readInt();
/*  56 */         this.useWeaponOption2 = data.readInt();
/*  57 */         this.useWeaponPosX = data.readDouble();
/*  58 */         this.useWeaponPosY = data.readDouble();
/*  59 */         this.useWeaponPosZ = data.readDouble();
/*     */       } 
/*     */       
/*  62 */       e = (short)data.readByte();
/*  63 */       this.switchCameraMode = (byte)(e >> 6 & 0x3);
/*  64 */       this.switchHatch = (byte)(e >> 4 & 0x3);
/*  65 */       this.switchFreeLook = (byte)(e >> 2 & 0x3);
/*  66 */       this.switchGear = (byte)(e >> 0 & 0x3);
/*  67 */     } catch (Exception var3) {
/*  68 */       var3.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeData(DataOutputStream dos) {
/*     */     try {
/*  75 */       byte e = 0;
/*  76 */       short e1 = (short)setBit(e, 0, this.useWeapon);
/*  77 */       e1 = setBit(e1, 1, this.throttleUp);
/*  78 */       e1 = setBit(e1, 2, this.throttleDown);
/*  79 */       e1 = setBit(e1, 3, this.moveLeft);
/*  80 */       e1 = setBit(e1, 4, this.moveRight);
/*  81 */       e1 = setBit(e1, 5, this.switchSearchLight);
/*  82 */       e1 = setBit(e1, 6, this.ejectSeat);
/*  83 */       e1 = setBit(e1, 7, this.openGui);
/*  84 */       e1 = setBit(e1, 8, this.useBrake);
/*  85 */       dos.writeShort(e1);
/*  86 */       e1 = (short)(byte)((this.putDownRack & 0x3) << 6 | (this.isUnmount & 0x3) << 4 | this.useFlareType & 0xF);
/*  87 */       dos.writeByte(e1);
/*  88 */       dos.writeByte(this.switchMode);
/*  89 */       dos.writeByte(this.switchWeapon);
/*  90 */       if (this.useWeapon) {
/*  91 */         dos.writeInt(this.useWeaponOption1);
/*  92 */         dos.writeInt(this.useWeaponOption2);
/*  93 */         dos.writeDouble(this.useWeaponPosX);
/*  94 */         dos.writeDouble(this.useWeaponPosY);
/*  95 */         dos.writeDouble(this.useWeaponPosZ);
/*     */       } 
/*     */       
/*  98 */       e1 = (short)(byte)((this.switchCameraMode & 0x3) << 6 | (this.switchHatch & 0x3) << 4 | (this.switchFreeLook & 0x3) << 2 | (this.switchGear & 0x3) << 0);
/*  99 */       dos.writeByte(e1);
/* 100 */     } catch (IOException var3) {
/* 101 */       var3.printStackTrace();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketPlayerControlBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */