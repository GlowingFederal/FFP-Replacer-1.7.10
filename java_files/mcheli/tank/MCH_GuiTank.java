/*     */ package mcheli.tank;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_KeyName;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftCommonGui;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_GuiTank
/*     */   extends MCH_AircraftCommonGui
/*     */ {
/*     */   public MCH_GuiTank(Minecraft minecraft) {
/*  19 */     super(minecraft);
/*     */   }
/*     */   
/*     */   public boolean isDrawGui(EntityPlayer player) {
/*  23 */     return MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)player) instanceof MCH_EntityTank;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokestatic getAircraft_RiddenOrControl : (Lnet/minecraft/entity/Entity;)Lmcheli/aircraft/MCH_EntityAircraft;
/*     */     //   4: astore_3
/*     */     //   5: aload_3
/*     */     //   6: instanceof mcheli/tank/MCH_EntityTank
/*     */     //   9: ifeq -> 167
/*     */     //   12: aload_3
/*     */     //   13: invokevirtual isDestroyed : ()Z
/*     */     //   16: ifne -> 167
/*     */     //   19: aload_3
/*     */     //   20: checkcast mcheli/tank/MCH_EntityTank
/*     */     //   23: astore #4
/*     */     //   25: aload_3
/*     */     //   26: aload_1
/*     */     //   27: invokevirtual getSeatIdByEntity : (Lnet/minecraft/entity/Entity;)I
/*     */     //   30: istore #5
/*     */     //   32: getstatic mcheli/gui/MCH_Gui.scaleFactor : I
/*     */     //   35: i2f
/*     */     //   36: invokestatic glLineWidth : (F)V
/*     */     //   39: aload #4
/*     */     //   41: aload_1
/*     */     //   42: invokevirtual getCameraMode : (Lnet/minecraft/entity/player/EntityPlayer;)I
/*     */     //   45: iconst_1
/*     */     //   46: if_icmpne -> 53
/*     */     //   49: aload_0
/*     */     //   50: invokevirtual drawNightVisionNoise : ()V
/*     */     //   53: iload_2
/*     */     //   54: ifeq -> 74
/*     */     //   57: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   60: astore #6
/*     */     //   62: getstatic mcheli/MCH_Config.DisplayHUDThirdPerson : Lmcheli/MCH_ConfigPrm;
/*     */     //   65: getfield prmBool : Z
/*     */     //   68: ifne -> 74
/*     */     //   71: goto -> 82
/*     */     //   74: aload_0
/*     */     //   75: aload_3
/*     */     //   76: aload_1
/*     */     //   77: iload #5
/*     */     //   79: invokevirtual drawHud : (Lmcheli/aircraft/MCH_EntityAircraft;Lnet/minecraft/entity/player/EntityPlayer;I)V
/*     */     //   82: aload_0
/*     */     //   83: aload #4
/*     */     //   85: invokevirtual drawDebugtInfo : (Lmcheli/tank/MCH_EntityTank;)V
/*     */     //   88: iload_2
/*     */     //   89: ifeq -> 109
/*     */     //   92: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   95: astore #6
/*     */     //   97: getstatic mcheli/MCH_Config.DisplayHUDThirdPerson : Lmcheli/MCH_ConfigPrm;
/*     */     //   100: getfield prmBool : Z
/*     */     //   103: ifne -> 109
/*     */     //   106: goto -> 157
/*     */     //   109: aload #4
/*     */     //   111: invokevirtual getTVMissile : ()Lmcheli/weapon/MCH_EntityTvMissile;
/*     */     //   114: ifnull -> 148
/*     */     //   117: aload #4
/*     */     //   119: aload_1
/*     */     //   120: invokevirtual getIsGunnerMode : (Lnet/minecraft/entity/Entity;)Z
/*     */     //   123: ifne -> 134
/*     */     //   126: aload #4
/*     */     //   128: invokevirtual isUAV : ()Z
/*     */     //   131: ifeq -> 148
/*     */     //   134: aload_0
/*     */     //   135: aload #4
/*     */     //   137: aload #4
/*     */     //   139: invokevirtual getTVMissile : ()Lmcheli/weapon/MCH_EntityTvMissile;
/*     */     //   142: invokevirtual drawTvMissileNoise : (Lmcheli/aircraft/MCH_EntityAircraft;Lmcheli/weapon/MCH_EntityTvMissile;)V
/*     */     //   145: goto -> 157
/*     */     //   148: aload_0
/*     */     //   149: aload #4
/*     */     //   151: aload_1
/*     */     //   152: iload #5
/*     */     //   154: invokevirtual drawKeybind : (Lmcheli/tank/MCH_EntityTank;Lnet/minecraft/entity/player/EntityPlayer;I)V
/*     */     //   157: aload_0
/*     */     //   158: aload #4
/*     */     //   160: ldc -14101432
/*     */     //   162: iload #5
/*     */     //   164: invokevirtual drawHitBullet : (Lmcheli/aircraft/MCH_EntityAircraft;II)V
/*     */     //   167: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #27	-> 0
/*     */     //   #28	-> 5
/*     */     //   #29	-> 19
/*     */     //   #30	-> 25
/*     */     //   #31	-> 32
/*     */     //   #32	-> 39
/*     */     //   #33	-> 49
/*     */     //   #38	-> 53
/*     */     //   #39	-> 57
/*     */     //   #40	-> 62
/*     */     //   #41	-> 71
/*     */     //   #45	-> 74
/*     */     //   #49	-> 82
/*     */     //   #50	-> 88
/*     */     //   #51	-> 92
/*     */     //   #52	-> 97
/*     */     //   #53	-> 106
/*     */     //   #57	-> 109
/*     */     //   #58	-> 134
/*     */     //   #60	-> 148
/*     */     //   #64	-> 157
/*     */     //   #66	-> 167
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   62	12	6	var10000	Lmcheli/MCH_Config;
/*     */     //   97	12	6	var10000	Lmcheli/MCH_Config;
/*     */     //   25	142	4	tank	Lmcheli/tank/MCH_EntityTank;
/*     */     //   32	135	5	seatID	I
/*     */     //   0	168	0	this	Lmcheli/tank/MCH_GuiTank;
/*     */     //   0	168	1	player	Lnet/minecraft/entity/player/EntityPlayer;
/*     */     //   0	168	2	isThirdPersonView	Z
/*     */     //   5	163	3	ac	Lmcheli/aircraft/MCH_EntityAircraft;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawDebugtInfo(MCH_EntityTank ac) {
/*  69 */     MCH_Config var10000 = MCH_MOD.config;
/*  70 */     if (MCH_Config.DebugLog) {
/*  71 */       int LX = this.centerX - 100;
/*  72 */       drawDebugtInfo(ac);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawKeybind(MCH_EntityTank tank, EntityPlayer player, int seatID) {
/*  78 */     MCH_Config var10000 = MCH_MOD.config;
/*  79 */     if (!MCH_Config.HideKeybind.prmBool) {
/*  80 */       MCH_TankInfo info = tank.getTankInfo();
/*  81 */       if (info != null) {
/*  82 */         int colorActive = -1342177281;
/*  83 */         int colorInactive = -1349546097;
/*  84 */         int RX = this.centerX + 120;
/*  85 */         int LX = this.centerX - 200;
/*  86 */         drawKeyBind(tank, info, player, seatID, RX, LX, colorActive, colorInactive);
/*     */ 
/*     */ 
/*     */         
/*  90 */         if (seatID == 0 && tank.hasBrake()) {
/*  91 */           StringBuilder var11 = (new StringBuilder()).append("Brake : ");
/*  92 */           MCH_Config var10001 = MCH_MOD.config;
/*  93 */           String msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwitchHovering.prmInt)).toString();
/*  94 */           drawString(msg, RX, this.centerY - 30, colorActive);
/*     */         } 
/*     */         
/*  97 */         if (seatID > 0 && tank.canSwitchGunnerModeOtherSeat(player)) {
/*  98 */           StringBuilder var11 = (new StringBuilder()).append(tank.getIsGunnerMode((Entity)player) ? "Normal" : "Camera").append(" : ");
/*  99 */           MCH_Config var10001 = MCH_MOD.config;
/* 100 */           String msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwitchMode.prmInt)).toString();
/* 101 */           drawString(msg, RX, this.centerY - 40, colorActive);
/*     */         } 
/*     */         
/* 104 */         if (tank.getIsGunnerMode((Entity)player) && info.cameraZoom > 1) {
/* 105 */           StringBuilder var11 = (new StringBuilder()).append("Zoom : ");
/* 106 */           MCH_Config var10001 = MCH_MOD.config;
/* 107 */           String msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt)).toString();
/* 108 */           drawString(msg, LX, this.centerY - 80, colorActive);
/* 109 */         } else if (seatID == 0 && (tank.canFoldHatch() || tank.canUnfoldHatch())) {
/* 110 */           StringBuilder var11 = (new StringBuilder()).append("OpenHatch : ");
/* 111 */           MCH_Config var10001 = MCH_MOD.config;
/* 112 */           String msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt)).toString();
/* 113 */           drawString(msg, LX, this.centerY - 80, colorActive);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tank\MCH_GuiTank.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */