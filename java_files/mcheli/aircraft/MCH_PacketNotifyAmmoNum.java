/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import java.io.DataOutputStream;
/*     */ import java.io.IOException;
/*     */ import mcheli.MCH_Packet;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_Network;
/*     */ import mcheli.wrapper.W_PacketBase;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ public class MCH_PacketNotifyAmmoNum
/*     */   extends MCH_Packet {
/*  15 */   public int entityID_Ac = -1;
/*     */   public boolean all = false;
/*  17 */   public byte weaponID = -1;
/*  18 */   public byte num = 0;
/*  19 */   public short[] ammo = new short[0];
/*  20 */   public short[] restAmmo = new short[0];
/*     */ 
/*     */   
/*     */   public int getMessageID() {
/*  24 */     return 268439604;
/*     */   }
/*     */   
/*     */   public void readData(ByteArrayDataInput data) {
/*     */     try {
/*  29 */       this.entityID_Ac = data.readInt();
/*  30 */       this.all = (data.readByte() != 0);
/*  31 */       if (this.all) {
/*  32 */         this.num = data.readByte();
/*  33 */         this.ammo = new short[this.num];
/*  34 */         this.restAmmo = new short[this.num];
/*     */         
/*  36 */         for (int e = 0; e < this.num; e++) {
/*  37 */           this.ammo[e] = data.readShort();
/*  38 */           this.restAmmo[e] = data.readShort();
/*     */         } 
/*     */       } else {
/*  41 */         this.weaponID = data.readByte();
/*  42 */         this.ammo = new short[] { data.readShort() };
/*  43 */         this.restAmmo = new short[] { data.readShort() };
/*     */       } 
/*  45 */     } catch (Exception var3) {
/*  46 */       var3.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeData(DataOutputStream dos) {
/*     */     try {
/*  53 */       dos.writeInt(this.entityID_Ac);
/*  54 */       dos.writeByte(this.all ? 1 : 0);
/*  55 */       if (this.all) {
/*  56 */         dos.writeByte(this.num);
/*     */         
/*  58 */         for (int e = 0; e < this.num; e++) {
/*  59 */           dos.writeShort(this.ammo[e]);
/*  60 */           dos.writeShort(this.restAmmo[e]);
/*     */         } 
/*     */       } else {
/*  63 */         dos.writeByte(this.weaponID);
/*  64 */         dos.writeShort(this.ammo[0]);
/*  65 */         dos.writeShort(this.restAmmo[0]);
/*     */       } 
/*  67 */     } catch (IOException var3) {
/*  68 */       var3.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void sendAllAmmoNum(MCH_EntityAircraft ac, EntityPlayer target) {
/*  74 */     MCH_PacketNotifyAmmoNum s = new MCH_PacketNotifyAmmoNum();
/*  75 */     s.entityID_Ac = W_Entity.getEntityId((Entity)ac);
/*  76 */     s.all = true;
/*  77 */     s.num = (byte)ac.getWeaponNum();
/*  78 */     s.ammo = new short[s.num];
/*  79 */     s.restAmmo = new short[s.num];
/*     */     
/*  81 */     for (int i = 0; i < s.num; i++) {
/*  82 */       s.ammo[i] = (short)ac.getWeapon(i).getAmmoNum();
/*  83 */       s.restAmmo[i] = (short)ac.getWeapon(i).getRestAllAmmoNum();
/*     */     } 
/*     */     
/*  86 */     send(s, ac, target);
/*     */   }
/*     */   
/*     */   public static void sendAmmoNum(MCH_EntityAircraft ac, EntityPlayer target, int wid) {
/*  90 */     sendAmmoNum(ac, target, wid, ac.getWeapon(wid).getAmmoNum(), ac.getWeapon(wid).getRestAllAmmoNum());
/*     */   }
/*     */   
/*     */   public static void sendAmmoNum(MCH_EntityAircraft ac, EntityPlayer target, int wid, int ammo, int rest_ammo) {
/*  94 */     MCH_PacketNotifyAmmoNum s = new MCH_PacketNotifyAmmoNum();
/*  95 */     s.entityID_Ac = W_Entity.getEntityId((Entity)ac);
/*  96 */     s.all = false;
/*  97 */     s.weaponID = (byte)wid;
/*  98 */     s.ammo = new short[] { (short)ammo };
/*  99 */     s.restAmmo = new short[] { (short)rest_ammo };
/* 100 */     send(s, ac, target);
/*     */   }
/*     */   
/*     */   public static void send(MCH_PacketNotifyAmmoNum s, MCH_EntityAircraft ac, EntityPlayer target) {
/* 104 */     if (target == null) {
/* 105 */       for (int i = 0; i < ac.getSeatNum() + 1; i++) {
/* 106 */         Entity e = ac.getEntityBySeatId(i);
/* 107 */         if (e instanceof EntityPlayer) {
/* 108 */           W_Network.sendToPlayer((W_PacketBase)s, (EntityPlayer)e);
/*     */         }
/*     */       } 
/*     */     } else {
/* 112 */       W_Network.sendToPlayer((W_PacketBase)s, target);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_PacketNotifyAmmoNum.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */