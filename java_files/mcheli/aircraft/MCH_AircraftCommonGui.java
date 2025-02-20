/*    */ package mcheli.aircraft;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.gui.MCH_Gui;
/*    */ import mcheli.hud.MCH_Hud;
/*    */ import mcheli.weapon.MCH_EntityTvMissile;
/*    */ import mcheli.wrapper.W_McClient;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public abstract class MCH_AircraftCommonGui
/*    */   extends MCH_Gui
/*    */ {
/*    */   public MCH_AircraftCommonGui(Minecraft minecraft) {
/* 23 */     super(minecraft);
/*    */   }
/*    */   
/*    */   public void drawHud(MCH_EntityAircraft ac, EntityPlayer player, int seatId) {
/* 27 */     MCH_AircraftInfo info = ac.getAcInfo();
/* 28 */     if (info != null) {
/* 29 */       if (ac.isMissileCameraMode((Entity)player) && ac.getTVMissile() != null && info.hudTvMissile != null) {
/* 30 */         info.hudTvMissile.draw(ac, player, this.smoothCamPartialTicks);
/*    */       } else {
/* 32 */         if (seatId < 0) {
/*    */           return;
/*    */         }
/*    */         
/* 36 */         if (seatId < info.hudList.size()) {
/* 37 */           MCH_Hud hud = info.hudList.get(seatId);
/* 38 */           if (hud != null) {
/* 39 */             hud.draw(ac, player, this.smoothCamPartialTicks);
/*    */           }
/*    */         } 
/*    */       } 
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawDebugtInfo(MCH_EntityAircraft ac) {
/* 48 */     MCH_Config var10000 = MCH_MOD.config;
/* 49 */     if (MCH_Config.DebugLog) {
/* 50 */       int i = this.centerX - 100;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawNightVisionNoise() {
/* 56 */     GL11.glEnable(3042);
/* 57 */     GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.3F);
/* 58 */     int srcBlend = GL11.glGetInteger(3041);
/* 59 */     int dstBlend = GL11.glGetInteger(3040);
/* 60 */     GL11.glBlendFunc(1, 1);
/* 61 */     W_McClient.MOD_bindTexture("textures/gui/alpha.png");
/* 62 */     drawTexturedModalRectRotate(0.0D, 0.0D, this.field_146294_l, this.field_146295_m, this.rand.nextInt(256), this.rand.nextInt(256), 256.0D, 256.0D, 0.0F);
/* 63 */     GL11.glBlendFunc(srcBlend, dstBlend);
/* 64 */     GL11.glDisable(3042);
/*    */   }
/*    */   
/*    */   public void drawHitBullet(int hs, int hsMax, int color) {
/* 68 */     if (hs > 0) {
/* 69 */       int cx = this.centerX;
/* 70 */       int cy = this.centerY;
/* 71 */       byte IVX = 10;
/* 72 */       byte IVY = 10;
/* 73 */       byte SZX = 5;
/* 74 */       byte SZY = 5;
/* 75 */       double[] ls = { (cx - IVX), (cy - IVY), (cx - SZX), (cy - SZY), (cx - IVX), (cy + IVY), (cx - SZX), (cy + SZY), (cx + IVX), (cy - IVY), (cx + SZX), (cy - SZY), (cx + IVX), (cy + IVY), (cx + SZX), (cy + SZY) };
/* 76 */       MCH_Config var10000 = MCH_MOD.config;
/* 77 */       color = MCH_Config.hitMarkColorRGB;
/* 78 */       int alpha = hs * 256 / hsMax;
/* 79 */       MCH_Config var10001 = MCH_MOD.config;
/* 80 */       color |= (int)(MCH_Config.hitMarkColorAlpha * alpha) << 24;
/* 81 */       drawLine(ls, color);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public void drawHitBullet(MCH_EntityAircraft ac, int color, int seatID) {
/* 87 */     drawHitBullet(ac.getHitStatus(), ac.getMaxHitStatus(), color);
/*    */   }
/*    */   
/*    */   protected void drawTvMissileNoise(MCH_EntityAircraft ac, MCH_EntityTvMissile tvmissile) {
/* 91 */     GL11.glEnable(3042);
/* 92 */     GL11.glColor4f(0.5F, 0.5F, 0.5F, 0.4F);
/* 93 */     int srcBlend = GL11.glGetInteger(3041);
/* 94 */     int dstBlend = GL11.glGetInteger(3040);
/* 95 */     GL11.glBlendFunc(1, 1);
/* 96 */     W_McClient.MOD_bindTexture("textures/gui/noise.png");
/* 97 */     drawTexturedModalRectRotate(0.0D, 0.0D, this.field_146294_l, this.field_146295_m, this.rand.nextInt(256), this.rand.nextInt(256), 256.0D, 256.0D, 0.0F);
/* 98 */     GL11.glBlendFunc(srcBlend, dstBlend);
/* 99 */     GL11.glDisable(3042);
/*    */   }
/*    */   
/*    */   public void drawKeyBind(MCH_EntityAircraft ac, MCH_AircraftInfo info, EntityPlayer player, int seatID, int RX, int LX, int colorActive, int colorInactive) {
/*    */     // Byte code:
/*    */     //   0: ldc ''
/*    */     //   2: astore #9
/*    */     //   4: iconst_0
/*    */     //   5: istore #10
/*    */     //   7: iload #4
/*    */     //   9: ifne -> 74
/*    */     //   12: aload_1
/*    */     //   13: invokevirtual canPutToRack : ()Z
/*    */     //   16: ifeq -> 74
/*    */     //   19: new java/lang/StringBuilder
/*    */     //   22: dup
/*    */     //   23: invokespecial <init> : ()V
/*    */     //   26: ldc 'PutRack : '
/*    */     //   28: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   31: astore #11
/*    */     //   33: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   36: astore #12
/*    */     //   38: aload #11
/*    */     //   40: getstatic mcheli/MCH_Config.KeyPutToRack : Lmcheli/MCH_ConfigPrm;
/*    */     //   43: getfield prmInt : I
/*    */     //   46: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   49: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   52: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   55: astore #9
/*    */     //   57: aload_0
/*    */     //   58: aload #9
/*    */     //   60: iload #6
/*    */     //   62: aload_0
/*    */     //   63: getfield centerY : I
/*    */     //   66: bipush #10
/*    */     //   68: isub
/*    */     //   69: iload #7
/*    */     //   71: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   74: iload #4
/*    */     //   76: ifne -> 140
/*    */     //   79: aload_1
/*    */     //   80: invokevirtual canDownFromRack : ()Z
/*    */     //   83: ifeq -> 140
/*    */     //   86: new java/lang/StringBuilder
/*    */     //   89: dup
/*    */     //   90: invokespecial <init> : ()V
/*    */     //   93: ldc 'DownRack : '
/*    */     //   95: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   98: astore #11
/*    */     //   100: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   103: astore #12
/*    */     //   105: aload #11
/*    */     //   107: getstatic mcheli/MCH_Config.KeyDownFromRack : Lmcheli/MCH_ConfigPrm;
/*    */     //   110: getfield prmInt : I
/*    */     //   113: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   116: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   119: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   122: astore #9
/*    */     //   124: aload_0
/*    */     //   125: aload #9
/*    */     //   127: iload #6
/*    */     //   129: aload_0
/*    */     //   130: getfield centerY : I
/*    */     //   133: iconst_0
/*    */     //   134: isub
/*    */     //   135: iload #7
/*    */     //   137: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   140: iload #4
/*    */     //   142: ifne -> 207
/*    */     //   145: aload_1
/*    */     //   146: invokevirtual canRideRack : ()Z
/*    */     //   149: ifeq -> 207
/*    */     //   152: new java/lang/StringBuilder
/*    */     //   155: dup
/*    */     //   156: invokespecial <init> : ()V
/*    */     //   159: ldc 'RideRack : '
/*    */     //   161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   164: astore #11
/*    */     //   166: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   169: astore #12
/*    */     //   171: aload #11
/*    */     //   173: getstatic mcheli/MCH_Config.KeyPutToRack : Lmcheli/MCH_ConfigPrm;
/*    */     //   176: getfield prmInt : I
/*    */     //   179: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   182: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   185: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   188: astore #9
/*    */     //   190: aload_0
/*    */     //   191: aload #9
/*    */     //   193: iload #6
/*    */     //   195: aload_0
/*    */     //   196: getfield centerY : I
/*    */     //   199: bipush #10
/*    */     //   201: iadd
/*    */     //   202: iload #7
/*    */     //   204: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   207: iload #4
/*    */     //   209: ifne -> 274
/*    */     //   212: aload_1
/*    */     //   213: getfield field_70154_o : Lnet/minecraft/entity/Entity;
/*    */     //   216: ifnull -> 274
/*    */     //   219: new java/lang/StringBuilder
/*    */     //   222: dup
/*    */     //   223: invokespecial <init> : ()V
/*    */     //   226: ldc 'DismountRack : '
/*    */     //   228: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   231: astore #11
/*    */     //   233: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   236: astore #12
/*    */     //   238: aload #11
/*    */     //   240: getstatic mcheli/MCH_Config.KeyDownFromRack : Lmcheli/MCH_ConfigPrm;
/*    */     //   243: getfield prmInt : I
/*    */     //   246: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   249: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   252: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   255: astore #9
/*    */     //   257: aload_0
/*    */     //   258: aload #9
/*    */     //   260: iload #6
/*    */     //   262: aload_0
/*    */     //   263: getfield centerY : I
/*    */     //   266: bipush #10
/*    */     //   268: iadd
/*    */     //   269: iload #7
/*    */     //   271: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   274: iload #4
/*    */     //   276: ifle -> 287
/*    */     //   279: aload_1
/*    */     //   280: invokevirtual getSeatNum : ()I
/*    */     //   283: iconst_1
/*    */     //   284: if_icmpgt -> 307
/*    */     //   287: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   290: astore #14
/*    */     //   292: getstatic mcheli/MCH_Config.KeyFreeLook : Lmcheli/MCH_ConfigPrm;
/*    */     //   295: getfield prmInt : I
/*    */     //   298: invokestatic isKeyDown : (I)Z
/*    */     //   301: ifne -> 307
/*    */     //   304: goto -> 499
/*    */     //   307: iload #4
/*    */     //   309: ifne -> 318
/*    */     //   312: sipush #-208
/*    */     //   315: goto -> 320
/*    */     //   318: iload #7
/*    */     //   320: istore #13
/*    */     //   322: iload #4
/*    */     //   324: ifne -> 369
/*    */     //   327: new java/lang/StringBuilder
/*    */     //   330: dup
/*    */     //   331: invokespecial <init> : ()V
/*    */     //   334: astore #11
/*    */     //   336: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   339: astore #12
/*    */     //   341: aload #11
/*    */     //   343: getstatic mcheli/MCH_Config.KeyFreeLook : Lmcheli/MCH_ConfigPrm;
/*    */     //   346: getfield prmInt : I
/*    */     //   349: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   352: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   355: ldc_w ' + '
/*    */     //   358: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   361: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   364: astore #14
/*    */     //   366: goto -> 373
/*    */     //   369: ldc ''
/*    */     //   371: astore #14
/*    */     //   373: aload #14
/*    */     //   375: astore #15
/*    */     //   377: new java/lang/StringBuilder
/*    */     //   380: dup
/*    */     //   381: invokespecial <init> : ()V
/*    */     //   384: ldc_w 'NextSeat : '
/*    */     //   387: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   390: aload #15
/*    */     //   392: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   395: astore #11
/*    */     //   397: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   400: astore #12
/*    */     //   402: aload #11
/*    */     //   404: getstatic mcheli/MCH_Config.KeyGUI : Lmcheli/MCH_ConfigPrm;
/*    */     //   407: getfield prmInt : I
/*    */     //   410: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   413: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   416: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   419: astore #9
/*    */     //   421: aload_0
/*    */     //   422: aload #9
/*    */     //   424: iload #5
/*    */     //   426: aload_0
/*    */     //   427: getfield centerY : I
/*    */     //   430: bipush #70
/*    */     //   432: isub
/*    */     //   433: iload #13
/*    */     //   435: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   438: new java/lang/StringBuilder
/*    */     //   441: dup
/*    */     //   442: invokespecial <init> : ()V
/*    */     //   445: ldc_w 'PrevSeat : '
/*    */     //   448: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   451: aload #15
/*    */     //   453: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   456: astore #11
/*    */     //   458: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   461: astore #12
/*    */     //   463: aload #11
/*    */     //   465: getstatic mcheli/MCH_Config.KeyExtra : Lmcheli/MCH_ConfigPrm;
/*    */     //   468: getfield prmInt : I
/*    */     //   471: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   474: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   477: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   480: astore #9
/*    */     //   482: aload_0
/*    */     //   483: aload #9
/*    */     //   485: iload #5
/*    */     //   487: aload_0
/*    */     //   488: getfield centerY : I
/*    */     //   491: bipush #60
/*    */     //   493: isub
/*    */     //   494: iload #13
/*    */     //   496: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   499: iload #4
/*    */     //   501: iflt -> 589
/*    */     //   504: iload #4
/*    */     //   506: iconst_1
/*    */     //   507: if_icmpgt -> 589
/*    */     //   510: aload_1
/*    */     //   511: invokevirtual haveFlare : ()Z
/*    */     //   514: ifeq -> 589
/*    */     //   517: aload_1
/*    */     //   518: invokevirtual isFlarePreparation : ()Z
/*    */     //   521: ifeq -> 529
/*    */     //   524: iload #8
/*    */     //   526: goto -> 531
/*    */     //   529: iload #7
/*    */     //   531: istore #13
/*    */     //   533: new java/lang/StringBuilder
/*    */     //   536: dup
/*    */     //   537: invokespecial <init> : ()V
/*    */     //   540: ldc_w 'Flare : '
/*    */     //   543: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   546: astore #11
/*    */     //   548: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   551: astore #12
/*    */     //   553: aload #11
/*    */     //   555: getstatic mcheli/MCH_Config.KeyFlare : Lmcheli/MCH_ConfigPrm;
/*    */     //   558: getfield prmInt : I
/*    */     //   561: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   564: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   567: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   570: astore #9
/*    */     //   572: aload_0
/*    */     //   573: aload #9
/*    */     //   575: iload #5
/*    */     //   577: aload_0
/*    */     //   578: getfield centerY : I
/*    */     //   581: bipush #50
/*    */     //   583: isub
/*    */     //   584: iload #13
/*    */     //   586: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   589: iload #4
/*    */     //   591: ifne -> 730
/*    */     //   594: aload_2
/*    */     //   595: invokevirtual haveLandingGear : ()Z
/*    */     //   598: ifeq -> 730
/*    */     //   601: aload_1
/*    */     //   602: invokevirtual canFoldLandingGear : ()Z
/*    */     //   605: ifeq -> 667
/*    */     //   608: new java/lang/StringBuilder
/*    */     //   611: dup
/*    */     //   612: invokespecial <init> : ()V
/*    */     //   615: ldc_w 'Gear Up : '
/*    */     //   618: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   621: astore #11
/*    */     //   623: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   626: astore #12
/*    */     //   628: aload #11
/*    */     //   630: getstatic mcheli/MCH_Config.KeyGearUpDown : Lmcheli/MCH_ConfigPrm;
/*    */     //   633: getfield prmInt : I
/*    */     //   636: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   639: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   642: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   645: astore #9
/*    */     //   647: aload_0
/*    */     //   648: aload #9
/*    */     //   650: iload #5
/*    */     //   652: aload_0
/*    */     //   653: getfield centerY : I
/*    */     //   656: bipush #40
/*    */     //   658: isub
/*    */     //   659: iload #7
/*    */     //   661: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   664: goto -> 730
/*    */     //   667: aload_1
/*    */     //   668: invokevirtual canUnfoldLandingGear : ()Z
/*    */     //   671: ifeq -> 730
/*    */     //   674: new java/lang/StringBuilder
/*    */     //   677: dup
/*    */     //   678: invokespecial <init> : ()V
/*    */     //   681: ldc_w 'Gear Down : '
/*    */     //   684: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   687: astore #11
/*    */     //   689: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   692: astore #12
/*    */     //   694: aload #11
/*    */     //   696: getstatic mcheli/MCH_Config.KeyGearUpDown : Lmcheli/MCH_ConfigPrm;
/*    */     //   699: getfield prmInt : I
/*    */     //   702: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   705: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   708: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   711: astore #9
/*    */     //   713: aload_0
/*    */     //   714: aload #9
/*    */     //   716: iload #5
/*    */     //   718: aload_0
/*    */     //   719: getfield centerY : I
/*    */     //   722: bipush #40
/*    */     //   724: isub
/*    */     //   725: iload #7
/*    */     //   727: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   730: aload_1
/*    */     //   731: aload_3
/*    */     //   732: invokevirtual getCurrentWeapon : (Lnet/minecraft/entity/Entity;)Lmcheli/weapon/MCH_WeaponSet;
/*    */     //   735: astore #14
/*    */     //   737: aload_1
/*    */     //   738: invokevirtual getWeaponNum : ()I
/*    */     //   741: iconst_1
/*    */     //   742: if_icmple -> 801
/*    */     //   745: new java/lang/StringBuilder
/*    */     //   748: dup
/*    */     //   749: invokespecial <init> : ()V
/*    */     //   752: ldc_w 'Weapon : '
/*    */     //   755: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   758: astore #11
/*    */     //   760: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   763: astore #12
/*    */     //   765: aload #11
/*    */     //   767: getstatic mcheli/MCH_Config.KeySwitchWeapon2 : Lmcheli/MCH_ConfigPrm;
/*    */     //   770: getfield prmInt : I
/*    */     //   773: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   776: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   779: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   782: astore #9
/*    */     //   784: aload_0
/*    */     //   785: aload #9
/*    */     //   787: iload #6
/*    */     //   789: aload_0
/*    */     //   790: getfield centerY : I
/*    */     //   793: bipush #70
/*    */     //   795: isub
/*    */     //   796: iload #7
/*    */     //   798: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   801: aload #14
/*    */     //   803: invokevirtual getCurrentWeapon : ()Lmcheli/weapon/MCH_WeaponBase;
/*    */     //   806: getfield numMode : I
/*    */     //   809: ifle -> 868
/*    */     //   812: new java/lang/StringBuilder
/*    */     //   815: dup
/*    */     //   816: invokespecial <init> : ()V
/*    */     //   819: ldc_w 'WeaponMode : '
/*    */     //   822: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   825: astore #11
/*    */     //   827: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   830: astore #12
/*    */     //   832: aload #11
/*    */     //   834: getstatic mcheli/MCH_Config.KeySwWeaponMode : Lmcheli/MCH_ConfigPrm;
/*    */     //   837: getfield prmInt : I
/*    */     //   840: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   843: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   846: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   849: astore #9
/*    */     //   851: aload_0
/*    */     //   852: aload #9
/*    */     //   854: iload #6
/*    */     //   856: aload_0
/*    */     //   857: getfield centerY : I
/*    */     //   860: bipush #60
/*    */     //   862: isub
/*    */     //   863: iload #7
/*    */     //   865: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   868: aload_1
/*    */     //   869: aload_3
/*    */     //   870: invokevirtual canSwitchSearchLight : (Lnet/minecraft/entity/Entity;)Z
/*    */     //   873: ifeq -> 935
/*    */     //   876: new java/lang/StringBuilder
/*    */     //   879: dup
/*    */     //   880: invokespecial <init> : ()V
/*    */     //   883: ldc_w 'SearchLight : '
/*    */     //   886: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   889: astore #11
/*    */     //   891: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   894: astore #12
/*    */     //   896: aload #11
/*    */     //   898: getstatic mcheli/MCH_Config.KeyCameraMode : Lmcheli/MCH_ConfigPrm;
/*    */     //   901: getfield prmInt : I
/*    */     //   904: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   907: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   910: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   913: astore #9
/*    */     //   915: aload_0
/*    */     //   916: aload #9
/*    */     //   918: iload #6
/*    */     //   920: aload_0
/*    */     //   921: getfield centerY : I
/*    */     //   924: bipush #50
/*    */     //   926: isub
/*    */     //   927: iload #7
/*    */     //   929: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   932: goto -> 1000
/*    */     //   935: aload_1
/*    */     //   936: iload #4
/*    */     //   938: invokevirtual canSwitchCameraMode : (I)Z
/*    */     //   941: ifeq -> 1000
/*    */     //   944: new java/lang/StringBuilder
/*    */     //   947: dup
/*    */     //   948: invokespecial <init> : ()V
/*    */     //   951: ldc_w 'CameraMode : '
/*    */     //   954: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   957: astore #11
/*    */     //   959: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   962: astore #12
/*    */     //   964: aload #11
/*    */     //   966: getstatic mcheli/MCH_Config.KeyCameraMode : Lmcheli/MCH_ConfigPrm;
/*    */     //   969: getfield prmInt : I
/*    */     //   972: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   975: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   978: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   981: astore #9
/*    */     //   983: aload_0
/*    */     //   984: aload #9
/*    */     //   986: iload #6
/*    */     //   988: aload_0
/*    */     //   989: getfield centerY : I
/*    */     //   992: bipush #50
/*    */     //   994: isub
/*    */     //   995: iload #7
/*    */     //   997: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   1000: iload #4
/*    */     //   1002: ifne -> 1186
/*    */     //   1005: aload_1
/*    */     //   1006: invokevirtual getSeatNum : ()I
/*    */     //   1009: iconst_1
/*    */     //   1010: if_icmplt -> 1186
/*    */     //   1013: iload #7
/*    */     //   1015: istore #15
/*    */     //   1017: aload_2
/*    */     //   1018: getfield isEnableParachuting : Z
/*    */     //   1021: ifeq -> 1076
/*    */     //   1024: aload_1
/*    */     //   1025: iconst_3
/*    */     //   1026: bipush #-10
/*    */     //   1028: invokestatic getBlockIdY : (Lnet/minecraft/entity/Entity;II)I
/*    */     //   1031: ifne -> 1076
/*    */     //   1034: new java/lang/StringBuilder
/*    */     //   1037: dup
/*    */     //   1038: invokespecial <init> : ()V
/*    */     //   1041: ldc_w 'Parachuting : '
/*    */     //   1044: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   1047: astore #11
/*    */     //   1049: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   1052: astore #12
/*    */     //   1054: aload #11
/*    */     //   1056: getstatic mcheli/MCH_Config.KeyUnmount : Lmcheli/MCH_ConfigPrm;
/*    */     //   1059: getfield prmInt : I
/*    */     //   1062: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   1065: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   1068: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   1071: astore #9
/*    */     //   1073: goto -> 1169
/*    */     //   1076: aload_1
/*    */     //   1077: invokevirtual canStartRepelling : ()Z
/*    */     //   1080: ifeq -> 1130
/*    */     //   1083: new java/lang/StringBuilder
/*    */     //   1086: dup
/*    */     //   1087: invokespecial <init> : ()V
/*    */     //   1090: ldc_w 'Repelling : '
/*    */     //   1093: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   1096: astore #11
/*    */     //   1098: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   1101: astore #12
/*    */     //   1103: aload #11
/*    */     //   1105: getstatic mcheli/MCH_Config.KeyUnmount : Lmcheli/MCH_ConfigPrm;
/*    */     //   1108: getfield prmInt : I
/*    */     //   1111: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   1114: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   1117: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   1120: astore #9
/*    */     //   1122: sipush #-256
/*    */     //   1125: istore #15
/*    */     //   1127: goto -> 1169
/*    */     //   1130: new java/lang/StringBuilder
/*    */     //   1133: dup
/*    */     //   1134: invokespecial <init> : ()V
/*    */     //   1137: ldc_w 'Dismount : '
/*    */     //   1140: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   1143: astore #11
/*    */     //   1145: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   1148: astore #12
/*    */     //   1150: aload #11
/*    */     //   1152: getstatic mcheli/MCH_Config.KeyUnmount : Lmcheli/MCH_ConfigPrm;
/*    */     //   1155: getfield prmInt : I
/*    */     //   1158: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   1161: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   1164: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   1167: astore #9
/*    */     //   1169: aload_0
/*    */     //   1170: aload #9
/*    */     //   1172: iload #6
/*    */     //   1174: aload_0
/*    */     //   1175: getfield centerY : I
/*    */     //   1178: bipush #30
/*    */     //   1180: isub
/*    */     //   1181: iload #15
/*    */     //   1183: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   1186: iload #4
/*    */     //   1188: ifne -> 1198
/*    */     //   1191: aload_1
/*    */     //   1192: invokevirtual canSwitchFreeLook : ()Z
/*    */     //   1195: ifne -> 1211
/*    */     //   1198: iload #4
/*    */     //   1200: ifle -> 1267
/*    */     //   1203: aload_1
/*    */     //   1204: aload_3
/*    */     //   1205: invokevirtual canSwitchGunnerModeOtherSeat : (Lnet/minecraft/entity/player/EntityPlayer;)Z
/*    */     //   1208: ifeq -> 1267
/*    */     //   1211: new java/lang/StringBuilder
/*    */     //   1214: dup
/*    */     //   1215: invokespecial <init> : ()V
/*    */     //   1218: ldc_w 'FreeLook : '
/*    */     //   1221: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   1224: astore #11
/*    */     //   1226: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*    */     //   1229: astore #12
/*    */     //   1231: aload #11
/*    */     //   1233: getstatic mcheli/MCH_Config.KeyFreeLook : Lmcheli/MCH_ConfigPrm;
/*    */     //   1236: getfield prmInt : I
/*    */     //   1239: invokestatic getDescOrName : (I)Ljava/lang/String;
/*    */     //   1242: invokevirtual append : (Ljava/lang/String;)Ljava/lang/StringBuilder;
/*    */     //   1245: invokevirtual toString : ()Ljava/lang/String;
/*    */     //   1248: astore #9
/*    */     //   1250: aload_0
/*    */     //   1251: aload #9
/*    */     //   1253: iload #6
/*    */     //   1255: aload_0
/*    */     //   1256: getfield centerY : I
/*    */     //   1259: bipush #20
/*    */     //   1261: isub
/*    */     //   1262: iload #7
/*    */     //   1264: invokevirtual drawString : (Ljava/lang/String;III)V
/*    */     //   1267: return
/*    */     // Line number table:
/*    */     //   Java source line number -> byte code offset
/*    */     //   #103	-> 0
/*    */     //   #104	-> 4
/*    */     //   #107	-> 7
/*    */     //   #108	-> 19
/*    */     //   #109	-> 33
/*    */     //   #110	-> 38
/*    */     //   #111	-> 57
/*    */     //   #114	-> 74
/*    */     //   #115	-> 86
/*    */     //   #116	-> 100
/*    */     //   #117	-> 105
/*    */     //   #118	-> 124
/*    */     //   #121	-> 140
/*    */     //   #122	-> 152
/*    */     //   #123	-> 166
/*    */     //   #124	-> 171
/*    */     //   #125	-> 190
/*    */     //   #128	-> 207
/*    */     //   #129	-> 219
/*    */     //   #130	-> 233
/*    */     //   #131	-> 238
/*    */     //   #132	-> 257
/*    */     //   #137	-> 274
/*    */     //   #138	-> 287
/*    */     //   #139	-> 292
/*    */     //   #140	-> 304
/*    */     //   #144	-> 307
/*    */     //   #146	-> 322
/*    */     //   #147	-> 327
/*    */     //   #148	-> 336
/*    */     //   #149	-> 341
/*    */     //   #151	-> 369
/*    */     //   #154	-> 373
/*    */     //   #155	-> 377
/*    */     //   #156	-> 397
/*    */     //   #157	-> 402
/*    */     //   #158	-> 421
/*    */     //   #159	-> 438
/*    */     //   #160	-> 458
/*    */     //   #161	-> 463
/*    */     //   #162	-> 482
/*    */     //   #165	-> 499
/*    */     //   #166	-> 517
/*    */     //   #167	-> 533
/*    */     //   #168	-> 548
/*    */     //   #169	-> 553
/*    */     //   #170	-> 572
/*    */     //   #173	-> 589
/*    */     //   #174	-> 601
/*    */     //   #175	-> 608
/*    */     //   #176	-> 623
/*    */     //   #177	-> 628
/*    */     //   #178	-> 647
/*    */     //   #179	-> 667
/*    */     //   #180	-> 674
/*    */     //   #181	-> 689
/*    */     //   #182	-> 694
/*    */     //   #183	-> 713
/*    */     //   #187	-> 730
/*    */     //   #188	-> 737
/*    */     //   #189	-> 745
/*    */     //   #190	-> 760
/*    */     //   #191	-> 765
/*    */     //   #192	-> 784
/*    */     //   #195	-> 801
/*    */     //   #196	-> 812
/*    */     //   #197	-> 827
/*    */     //   #198	-> 832
/*    */     //   #199	-> 851
/*    */     //   #202	-> 868
/*    */     //   #203	-> 876
/*    */     //   #204	-> 891
/*    */     //   #205	-> 896
/*    */     //   #206	-> 915
/*    */     //   #207	-> 935
/*    */     //   #208	-> 944
/*    */     //   #209	-> 959
/*    */     //   #210	-> 964
/*    */     //   #211	-> 983
/*    */     //   #214	-> 1000
/*    */     //   #215	-> 1013
/*    */     //   #216	-> 1017
/*    */     //   #217	-> 1034
/*    */     //   #218	-> 1049
/*    */     //   #219	-> 1054
/*    */     //   #220	-> 1076
/*    */     //   #221	-> 1083
/*    */     //   #222	-> 1098
/*    */     //   #223	-> 1103
/*    */     //   #224	-> 1122
/*    */     //   #226	-> 1130
/*    */     //   #227	-> 1145
/*    */     //   #228	-> 1150
/*    */     //   #231	-> 1169
/*    */     //   #234	-> 1186
/*    */     //   #235	-> 1211
/*    */     //   #236	-> 1226
/*    */     //   #237	-> 1231
/*    */     //   #238	-> 1250
/*    */     //   #241	-> 1267
/*    */     // Local variable table:
/*    */     //   start	length	slot	name	descriptor
/*    */     //   33	41	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   38	36	12	var10001	Lmcheli/MCH_Config;
/*    */     //   100	40	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   105	35	12	var10001	Lmcheli/MCH_Config;
/*    */     //   166	41	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   171	36	12	var10001	Lmcheli/MCH_Config;
/*    */     //   233	41	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   238	36	12	var10001	Lmcheli/MCH_Config;
/*    */     //   292	15	14	var15	Lmcheli/MCH_Config;
/*    */     //   336	33	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   341	28	12	var10001	Lmcheli/MCH_Config;
/*    */     //   366	3	14	var16	Ljava/lang/String;
/*    */     //   373	126	14	var16	Ljava/lang/String;
/*    */     //   377	122	15	ws	Ljava/lang/String;
/*    */     //   397	102	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   402	97	12	var10001	Lmcheli/MCH_Config;
/*    */     //   322	177	13	c1	I
/*    */     //   548	41	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   553	36	12	var10001	Lmcheli/MCH_Config;
/*    */     //   533	56	13	c1	I
/*    */     //   623	44	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   628	39	12	var10001	Lmcheli/MCH_Config;
/*    */     //   689	41	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   694	36	12	var10001	Lmcheli/MCH_Config;
/*    */     //   760	41	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   765	36	12	var10001	Lmcheli/MCH_Config;
/*    */     //   827	41	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   832	36	12	var10001	Lmcheli/MCH_Config;
/*    */     //   891	44	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   896	39	12	var10001	Lmcheli/MCH_Config;
/*    */     //   959	41	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   964	36	12	var10001	Lmcheli/MCH_Config;
/*    */     //   1049	27	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   1054	22	12	var10001	Lmcheli/MCH_Config;
/*    */     //   1098	32	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   1103	27	12	var10001	Lmcheli/MCH_Config;
/*    */     //   1017	169	15	color	I
/*    */     //   1145	41	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   1150	36	12	var10001	Lmcheli/MCH_Config;
/*    */     //   1226	41	11	var10000	Ljava/lang/StringBuilder;
/*    */     //   1231	36	12	var10001	Lmcheli/MCH_Config;
/*    */     //   0	1268	0	this	Lmcheli/aircraft/MCH_AircraftCommonGui;
/*    */     //   0	1268	1	ac	Lmcheli/aircraft/MCH_EntityAircraft;
/*    */     //   0	1268	2	info	Lmcheli/aircraft/MCH_AircraftInfo;
/*    */     //   0	1268	3	player	Lnet/minecraft/entity/player/EntityPlayer;
/*    */     //   0	1268	4	seatID	I
/*    */     //   0	1268	5	RX	I
/*    */     //   0	1268	6	LX	I
/*    */     //   0	1268	7	colorActive	I
/*    */     //   0	1268	8	colorInactive	I
/*    */     //   4	1264	9	msg	Ljava/lang/String;
/*    */     //   7	1261	10	c	Z
/*    */     //   737	531	14	ws1	Lmcheli/weapon/MCH_WeaponSet;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_AircraftCommonGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */