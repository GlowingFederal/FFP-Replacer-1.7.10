/*     */ package mcheli.plane;
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
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCP_GuiPlane
/*     */   extends MCH_AircraftCommonGui
/*     */ {
/*     */   public MCP_GuiPlane(Minecraft minecraft) {
/*  20 */     super(minecraft);
/*     */   }
/*     */   
/*     */   public boolean isDrawGui(EntityPlayer player) {
/*  24 */     return MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)player) instanceof MCP_EntityPlane;
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
/*     */ 
/*     */   
/*     */   public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/*     */     // Byte code:
/*     */     //   0: aload_1
/*     */     //   1: invokestatic getAircraft_RiddenOrControl : (Lnet/minecraft/entity/Entity;)Lmcheli/aircraft/MCH_EntityAircraft;
/*     */     //   4: astore_3
/*     */     //   5: aload_3
/*     */     //   6: instanceof mcheli/plane/MCP_EntityPlane
/*     */     //   9: ifeq -> 191
/*     */     //   12: aload_3
/*     */     //   13: invokevirtual isDestroyed : ()Z
/*     */     //   16: ifne -> 191
/*     */     //   19: aload_3
/*     */     //   20: checkcast mcheli/plane/MCP_EntityPlane
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
/*     */     //   71: goto -> 106
/*     */     //   74: iload #5
/*     */     //   76: ifne -> 98
/*     */     //   79: aload #4
/*     */     //   81: aload_1
/*     */     //   82: invokevirtual getIsGunnerMode : (Lnet/minecraft/entity/Entity;)Z
/*     */     //   85: ifeq -> 98
/*     */     //   88: aload_0
/*     */     //   89: aload_3
/*     */     //   90: aload_1
/*     */     //   91: iconst_1
/*     */     //   92: invokevirtual drawHud : (Lmcheli/aircraft/MCH_EntityAircraft;Lnet/minecraft/entity/player/EntityPlayer;I)V
/*     */     //   95: goto -> 106
/*     */     //   98: aload_0
/*     */     //   99: aload_3
/*     */     //   100: aload_1
/*     */     //   101: iload #5
/*     */     //   103: invokevirtual drawHud : (Lmcheli/aircraft/MCH_EntityAircraft;Lnet/minecraft/entity/player/EntityPlayer;I)V
/*     */     //   106: aload_0
/*     */     //   107: aload #4
/*     */     //   109: invokevirtual drawDebugtInfo : (Lmcheli/aircraft/MCH_EntityAircraft;)V
/*     */     //   112: iload_2
/*     */     //   113: ifeq -> 133
/*     */     //   116: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   119: astore #6
/*     */     //   121: getstatic mcheli/MCH_Config.DisplayHUDThirdPerson : Lmcheli/MCH_ConfigPrm;
/*     */     //   124: getfield prmBool : Z
/*     */     //   127: ifne -> 133
/*     */     //   130: goto -> 181
/*     */     //   133: aload #4
/*     */     //   135: invokevirtual getTVMissile : ()Lmcheli/weapon/MCH_EntityTvMissile;
/*     */     //   138: ifnull -> 172
/*     */     //   141: aload #4
/*     */     //   143: aload_1
/*     */     //   144: invokevirtual getIsGunnerMode : (Lnet/minecraft/entity/Entity;)Z
/*     */     //   147: ifne -> 158
/*     */     //   150: aload #4
/*     */     //   152: invokevirtual isUAV : ()Z
/*     */     //   155: ifeq -> 172
/*     */     //   158: aload_0
/*     */     //   159: aload #4
/*     */     //   161: aload #4
/*     */     //   163: invokevirtual getTVMissile : ()Lmcheli/weapon/MCH_EntityTvMissile;
/*     */     //   166: invokevirtual drawTvMissileNoise : (Lmcheli/aircraft/MCH_EntityAircraft;Lmcheli/weapon/MCH_EntityTvMissile;)V
/*     */     //   169: goto -> 181
/*     */     //   172: aload_0
/*     */     //   173: aload #4
/*     */     //   175: aload_1
/*     */     //   176: iload #5
/*     */     //   178: invokevirtual drawKeybind : (Lmcheli/plane/MCP_EntityPlane;Lnet/minecraft/entity/player/EntityPlayer;I)V
/*     */     //   181: aload_0
/*     */     //   182: aload #4
/*     */     //   184: ldc -14101432
/*     */     //   186: iload #5
/*     */     //   188: invokevirtual drawHitBullet : (Lmcheli/aircraft/MCH_EntityAircraft;II)V
/*     */     //   191: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #28	-> 0
/*     */     //   #29	-> 5
/*     */     //   #30	-> 19
/*     */     //   #31	-> 25
/*     */     //   #32	-> 32
/*     */     //   #33	-> 39
/*     */     //   #34	-> 49
/*     */     //   #39	-> 53
/*     */     //   #40	-> 57
/*     */     //   #41	-> 62
/*     */     //   #42	-> 71
/*     */     //   #46	-> 74
/*     */     //   #47	-> 88
/*     */     //   #49	-> 98
/*     */     //   #54	-> 106
/*     */     //   #55	-> 112
/*     */     //   #56	-> 116
/*     */     //   #57	-> 121
/*     */     //   #58	-> 130
/*     */     //   #62	-> 133
/*     */     //   #63	-> 158
/*     */     //   #65	-> 172
/*     */     //   #69	-> 181
/*     */     //   #71	-> 191
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   62	12	6	var10000	Lmcheli/MCH_Config;
/*     */     //   121	12	6	var10000	Lmcheli/MCH_Config;
/*     */     //   25	166	4	plane	Lmcheli/plane/MCP_EntityPlane;
/*     */     //   32	159	5	seatID	I
/*     */     //   0	192	0	this	Lmcheli/plane/MCP_GuiPlane;
/*     */     //   0	192	1	player	Lnet/minecraft/entity/player/EntityPlayer;
/*     */     //   0	192	2	isThirdPersonView	Z
/*     */     //   5	187	3	ac	Lmcheli/aircraft/MCH_EntityAircraft;
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
/*     */ 
/*     */   
/*     */   public void drawKeybind(MCP_EntityPlane plane, EntityPlayer player, int seatID) {
/*  74 */     MCH_Config var10000 = MCH_MOD.config;
/*  75 */     if (!MCH_Config.HideKeybind.prmBool) {
/*  76 */       MCP_PlaneInfo info = plane.getPlaneInfo();
/*  77 */       if (info != null) {
/*  78 */         int colorActive = -1342177281;
/*  79 */         int colorInactive = -1349546097;
/*  80 */         int RX = this.centerX + 120;
/*  81 */         int LX = this.centerX - 200;
/*  82 */         drawKeyBind(plane, info, player, seatID, RX, LX, colorActive, colorInactive);
/*     */ 
/*     */ 
/*     */         
/*  86 */         if (seatID == 0 && info.isEnableGunnerMode) {
/*  87 */           var10000 = MCH_MOD.config;
/*  88 */           if (!Keyboard.isKeyDown(MCH_Config.KeyFreeLook.prmInt)) {
/*  89 */             int c = plane.isHoveringMode() ? colorInactive : colorActive;
/*  90 */             StringBuilder var12 = (new StringBuilder()).append(plane.getIsGunnerMode((Entity)player) ? "Normal" : "Gunner").append(" : ");
/*  91 */             MCH_Config var10001 = MCH_MOD.config;
/*  92 */             String msg = var12.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwitchMode.prmInt)).toString();
/*  93 */             drawString(msg, RX, this.centerY - 70, c);
/*     */           } 
/*     */         } 
/*     */         
/*  97 */         if (seatID > 0 && plane.canSwitchGunnerModeOtherSeat(player)) {
/*  98 */           StringBuilder var12 = (new StringBuilder()).append(plane.getIsGunnerMode((Entity)player) ? "Normal" : "Camera").append(" : ");
/*  99 */           MCH_Config var10001 = MCH_MOD.config;
/* 100 */           String msg = var12.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwitchMode.prmInt)).toString();
/* 101 */           drawString(msg, RX, this.centerY - 40, colorActive);
/*     */         } 
/*     */         
/* 104 */         if (seatID == 0 && info.isEnableVtol) {
/* 105 */           var10000 = MCH_MOD.config;
/* 106 */           if (!Keyboard.isKeyDown(MCH_Config.KeyFreeLook.prmInt)) {
/* 107 */             int stat = plane.getVtolMode();
/* 108 */             if (stat != 1) {
/* 109 */               StringBuilder var12 = (new StringBuilder()).append((stat == 0) ? "VTOL : " : "Normal : ");
/* 110 */               MCH_Config var10001 = MCH_MOD.config;
/* 111 */               String msg = var12.append(MCH_KeyName.getDescOrName(MCH_Config.KeyExtra.prmInt)).toString();
/* 112 */               drawString(msg, RX, this.centerY - 60, colorActive);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */         
/* 117 */         if (plane.canEjectSeat((Entity)player)) {
/* 118 */           StringBuilder var12 = (new StringBuilder()).append("Eject seat: ");
/* 119 */           MCH_Config var10001 = MCH_MOD.config;
/* 120 */           String msg = var12.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwitchHovering.prmInt)).toString();
/* 121 */           drawString(msg, RX, this.centerY - 30, colorActive);
/*     */         } 
/*     */         
/* 124 */         if (plane.getIsGunnerMode((Entity)player) && info.cameraZoom > 1) {
/* 125 */           StringBuilder var12 = (new StringBuilder()).append("Zoom : ");
/* 126 */           MCH_Config var10001 = MCH_MOD.config;
/* 127 */           String msg = var12.append(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt)).toString();
/* 128 */           drawString(msg, LX, this.centerY - 80, colorActive);
/* 129 */         } else if (seatID == 0) {
/* 130 */           if (!plane.canFoldWing() && !plane.canUnfoldWing()) {
/* 131 */             if (plane.canFoldHatch() || plane.canUnfoldHatch()) {
/* 132 */               StringBuilder var12 = (new StringBuilder()).append("OpenHatch : ");
/* 133 */               MCH_Config var10001 = MCH_MOD.config;
/* 134 */               String msg = var12.append(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt)).toString();
/* 135 */               drawString(msg, LX, this.centerY - 80, colorActive);
/*     */             } 
/*     */           } else {
/* 138 */             StringBuilder var12 = (new StringBuilder()).append("FoldWing : ");
/* 139 */             MCH_Config var10001 = MCH_MOD.config;
/* 140 */             String msg = var12.append(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt)).toString();
/* 141 */             drawString(msg, LX, this.centerY - 80, colorActive);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\plane\MCP_GuiPlane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */