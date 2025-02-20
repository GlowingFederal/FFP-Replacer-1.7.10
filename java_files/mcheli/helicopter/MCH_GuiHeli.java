/*     */ package mcheli.helicopter;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_KeyName;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftCommonGui;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_GuiHeli
/*     */   extends MCH_AircraftCommonGui
/*     */ {
/*     */   public MCH_GuiHeli(Minecraft minecraft) {
/*  22 */     super(minecraft);
/*     */   }
/*     */   
/*     */   public boolean isDrawGui(EntityPlayer player) {
/*  26 */     return MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)player) instanceof MCH_EntityHeli;
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
/*     */     //   6: instanceof mcheli/helicopter/MCH_EntityHeli
/*     */     //   9: ifeq -> 236
/*     */     //   12: aload_3
/*     */     //   13: invokevirtual isDestroyed : ()Z
/*     */     //   16: ifne -> 236
/*     */     //   19: aload_3
/*     */     //   20: checkcast mcheli/helicopter/MCH_EntityHeli
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
/*     */     //   112: aload #4
/*     */     //   114: aload_1
/*     */     //   115: invokevirtual getIsGunnerMode : (Lnet/minecraft/entity/Entity;)Z
/*     */     //   118: ifne -> 164
/*     */     //   121: iload_2
/*     */     //   122: ifeq -> 142
/*     */     //   125: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   128: astore #6
/*     */     //   130: getstatic mcheli/MCH_Config.DisplayHUDThirdPerson : Lmcheli/MCH_ConfigPrm;
/*     */     //   133: getfield prmBool : Z
/*     */     //   136: ifne -> 142
/*     */     //   139: goto -> 151
/*     */     //   142: aload_0
/*     */     //   143: aload #4
/*     */     //   145: aload_1
/*     */     //   146: iload #5
/*     */     //   148: invokevirtual drawKeyBind : (Lmcheli/helicopter/MCH_EntityHeli;Lnet/minecraft/entity/player/EntityPlayer;I)V
/*     */     //   151: aload_0
/*     */     //   152: aload #4
/*     */     //   154: ldc -14101432
/*     */     //   156: iload #5
/*     */     //   158: invokevirtual drawHitBullet : (Lmcheli/aircraft/MCH_EntityAircraft;II)V
/*     */     //   161: goto -> 236
/*     */     //   164: iload_2
/*     */     //   165: ifeq -> 185
/*     */     //   168: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   171: astore #6
/*     */     //   173: getstatic mcheli/MCH_Config.DisplayHUDThirdPerson : Lmcheli/MCH_ConfigPrm;
/*     */     //   176: getfield prmBool : Z
/*     */     //   179: ifne -> 185
/*     */     //   182: goto -> 226
/*     */     //   185: aload #4
/*     */     //   187: invokevirtual getTVMissile : ()Lmcheli/weapon/MCH_EntityTvMissile;
/*     */     //   190: astore #7
/*     */     //   192: aload #4
/*     */     //   194: aload_1
/*     */     //   195: invokevirtual isMissileCameraMode : (Lnet/minecraft/entity/Entity;)Z
/*     */     //   198: ifne -> 213
/*     */     //   201: aload_0
/*     */     //   202: aload #4
/*     */     //   204: aload_1
/*     */     //   205: iload #5
/*     */     //   207: invokevirtual drawKeyBind : (Lmcheli/helicopter/MCH_EntityHeli;Lnet/minecraft/entity/player/EntityPlayer;I)V
/*     */     //   210: goto -> 226
/*     */     //   213: aload #7
/*     */     //   215: ifnull -> 226
/*     */     //   218: aload_0
/*     */     //   219: aload #4
/*     */     //   221: aload #7
/*     */     //   223: invokevirtual drawTvMissileNoise : (Lmcheli/aircraft/MCH_EntityAircraft;Lmcheli/weapon/MCH_EntityTvMissile;)V
/*     */     //   226: aload_0
/*     */     //   227: aload #4
/*     */     //   229: ldc -805306369
/*     */     //   231: iload #5
/*     */     //   233: invokevirtual drawHitBullet : (Lmcheli/aircraft/MCH_EntityAircraft;II)V
/*     */     //   236: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #30	-> 0
/*     */     //   #31	-> 5
/*     */     //   #32	-> 19
/*     */     //   #33	-> 25
/*     */     //   #34	-> 32
/*     */     //   #35	-> 39
/*     */     //   #36	-> 49
/*     */     //   #41	-> 53
/*     */     //   #42	-> 57
/*     */     //   #43	-> 62
/*     */     //   #44	-> 71
/*     */     //   #48	-> 74
/*     */     //   #49	-> 88
/*     */     //   #51	-> 98
/*     */     //   #55	-> 106
/*     */     //   #56	-> 112
/*     */     //   #58	-> 121
/*     */     //   #59	-> 125
/*     */     //   #60	-> 130
/*     */     //   #61	-> 139
/*     */     //   #65	-> 142
/*     */     //   #68	-> 151
/*     */     //   #71	-> 164
/*     */     //   #72	-> 168
/*     */     //   #73	-> 173
/*     */     //   #74	-> 182
/*     */     //   #78	-> 185
/*     */     //   #79	-> 192
/*     */     //   #80	-> 201
/*     */     //   #81	-> 213
/*     */     //   #82	-> 218
/*     */     //   #86	-> 226
/*     */     //   #90	-> 236
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   62	12	6	var10000	Lmcheli/MCH_Config;
/*     */     //   130	12	6	var10000	Lmcheli/MCH_Config;
/*     */     //   173	12	6	var10000	Lmcheli/MCH_Config;
/*     */     //   192	34	7	tvmissile	Lmcheli/weapon/MCH_EntityTvMissile;
/*     */     //   25	211	4	heli	Lmcheli/helicopter/MCH_EntityHeli;
/*     */     //   32	204	5	seatID	I
/*     */     //   0	237	0	this	Lmcheli/helicopter/MCH_GuiHeli;
/*     */     //   0	237	1	player	Lnet/minecraft/entity/player/EntityPlayer;
/*     */     //   0	237	2	isThirdPersonView	Z
/*     */     //   5	232	3	ac	Lmcheli/aircraft/MCH_EntityAircraft;
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
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawKeyBind(MCH_EntityHeli heli, EntityPlayer player, int seatID) {
/*  93 */     MCH_Config var10000 = MCH_MOD.config;
/*  94 */     if (!MCH_Config.HideKeybind.prmBool) {
/*  95 */       MCH_HeliInfo info = heli.getHeliInfo();
/*  96 */       if (info != null) {
/*  97 */         int colorActive = -1342177281;
/*  98 */         int colorInactive = -1349546097;
/*  99 */         int RX = this.centerX + 120;
/* 100 */         int LX = this.centerX - 200;
/* 101 */         drawKeyBind(heli, info, player, seatID, RX, LX, colorActive, colorInactive);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 106 */         if (seatID == 0 && info.isEnableGunnerMode) {
/* 107 */           var10000 = MCH_MOD.config;
/* 108 */           if (!Keyboard.isKeyDown(MCH_Config.KeyFreeLook.prmInt)) {
/* 109 */             int c = heli.isHoveringMode() ? colorInactive : colorActive;
/* 110 */             StringBuilder var11 = (new StringBuilder()).append(heli.getIsGunnerMode((Entity)player) ? "Normal" : "Gunner").append(" : ");
/* 111 */             MCH_Config var10001 = MCH_MOD.config;
/* 112 */             String msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwitchMode.prmInt)).toString();
/* 113 */             drawString(msg, RX, this.centerY - 70, c);
/*     */           } 
/*     */         } 
/*     */         
/* 117 */         if (seatID > 0 && heli.canSwitchGunnerModeOtherSeat(player)) {
/* 118 */           StringBuilder var11 = (new StringBuilder()).append(heli.getIsGunnerMode((Entity)player) ? "Normal" : "Camera").append(" : ");
/* 119 */           MCH_Config var10001 = MCH_MOD.config;
/* 120 */           String msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwitchMode.prmInt)).toString();
/* 121 */           drawString(msg, RX, this.centerY - 40, colorActive);
/*     */         } 
/*     */         
/* 124 */         if (seatID == 0) {
/* 125 */           var10000 = MCH_MOD.config;
/* 126 */           if (!Keyboard.isKeyDown(MCH_Config.KeyFreeLook.prmInt)) {
/* 127 */             int c = heli.getIsGunnerMode((Entity)player) ? colorInactive : colorActive;
/* 128 */             StringBuilder var11 = (new StringBuilder()).append(heli.getIsGunnerMode((Entity)player) ? "Normal" : "Hovering").append(" : ");
/* 129 */             MCH_Config var10001 = MCH_MOD.config;
/* 130 */             String msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwitchHovering.prmInt)).toString();
/* 131 */             drawString(msg, RX, this.centerY - 60, c);
/*     */           } 
/*     */         } 
/*     */         
/* 135 */         if (seatID == 0 && 
/* 136 */           info.isEnableFoldBlade && MCH_Lib.getBlockIdY(heli.field_70170_p, heli.field_70165_t, heli.field_70163_u, heli.field_70161_v, 1, -2, true) > 0 && heli.getCurrentThrottle() <= 0.01D) {
/* 137 */           StringBuilder var11 = (new StringBuilder()).append("FoldBlade  : ");
/* 138 */           MCH_Config var10001 = MCH_MOD.config;
/* 139 */           String msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeyExtra.prmInt)).toString();
/* 140 */           drawString(msg, RX, this.centerY - 30, colorActive);
/*     */         } 
/*     */ 
/*     */         
/* 144 */         if ((heli.getIsGunnerMode((Entity)player) || heli.isUAV()) && info.cameraZoom > 1) {
/* 145 */           StringBuilder var11 = (new StringBuilder()).append("Zoom : ");
/* 146 */           MCH_Config var10001 = MCH_MOD.config;
/* 147 */           String msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt)).toString();
/* 148 */           drawString(msg, LX, this.centerY - 80, colorActive);
/* 149 */         } else if (seatID == 0 && (heli.canFoldHatch() || heli.canUnfoldHatch())) {
/* 150 */           StringBuilder var11 = (new StringBuilder()).append("OpenHatch : ");
/* 151 */           MCH_Config var10001 = MCH_MOD.config;
/* 152 */           String msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt)).toString();
/* 153 */           drawString(msg, LX, this.centerY - 80, colorActive);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\helicopter\MCH_GuiHeli.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */