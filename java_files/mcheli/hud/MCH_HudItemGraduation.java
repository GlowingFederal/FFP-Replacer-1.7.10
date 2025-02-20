/*     */ package mcheli.hud;
/*     */ 
/*     */ import mcheli.MCH_Lib;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_HudItemGraduation
/*     */   extends MCH_HudItem
/*     */ {
/*     */   private final String drawRot;
/*     */   private final String drawRoll;
/*     */   private final String drawPosX;
/*     */   private final String drawPosY;
/*     */   private final int type;
/*     */   
/*     */   public MCH_HudItemGraduation(int fileLine, int type, String rot, String roll, String posx, String posy) {
/*  16 */     super(fileLine);
/*  17 */     this.drawRot = toFormula(rot);
/*  18 */     this.drawRoll = toFormula(roll);
/*  19 */     this.drawPosX = toFormula(posx);
/*  20 */     this.drawPosY = toFormula(posy);
/*  21 */     this.type = type;
/*     */   }
/*     */   
/*     */   public void execute() {
/*  25 */     GL11.glPushMatrix();
/*  26 */     int x = (int)(MCH_HudItem.centerX + calc(this.drawPosX));
/*  27 */     int y = (int)(MCH_HudItem.centerY + calc(this.drawPosY));
/*  28 */     GL11.glTranslated(x, y, 0.0D);
/*  29 */     GL11.glRotatef((float)calc(this.drawRoll), 0.0F, 0.0F, 1.0F);
/*  30 */     GL11.glTranslated(-x, -y, 0.0D);
/*  31 */     if (this.type == 0) {
/*  32 */       drawCommonGraduationYaw(calc(this.drawRot), MCH_HudItem.colorSetting, x, y);
/*  33 */     } else if (this.type == 1) {
/*  34 */       drawCommonGraduationPitch1(calc(this.drawRot), MCH_HudItem.colorSetting, x, y);
/*  35 */     } else if (this.type == 2 || this.type == 3) {
/*  36 */       drawCommonGraduationPitch2(calc(this.drawRot), MCH_HudItem.colorSetting, x, y);
/*     */     } 
/*     */     
/*  39 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   private void drawCommonGraduationPitch2(double playerPitch, int color, int posX, int posY) {
/*  43 */     playerPitch = -playerPitch;
/*  44 */     int pitch_n = (int)playerPitch / 5 * 5;
/*  45 */     double[] line = new double[8];
/*  46 */     int start = (this.type == 2) ? 0 : 1;
/*  47 */     int end = (this.type == 2) ? 5 : 4;
/*  48 */     int INT = (this.type == 2) ? 1 : 2;
/*     */     
/*  50 */     for (int i = start; i < end; i++) {
/*  51 */       int pitch = -(-pitch_n - 10 + i * 5);
/*  52 */       double p_rest = playerPitch % 5.0D;
/*  53 */       boolean XO = true;
/*  54 */       boolean XI = true;
/*  55 */       int x = (pitch != 0) ? 50 : 100;
/*  56 */       int y = posY + (int)((-60 * INT) + p_rest * 6.0D * INT + (i * 30 * INT));
/*  57 */       line[0] = (posX - x);
/*  58 */       line[1] = (y + ((pitch == 0) ? 0 : ((pitch > 0) ? 2 : -2)));
/*  59 */       line[2] = (posX - 50);
/*  60 */       line[3] = y;
/*  61 */       line[4] = (posX + x);
/*  62 */       line[5] = line[1];
/*  63 */       line[6] = (posX + 50);
/*  64 */       line[7] = y;
/*  65 */       drawLine(line, color);
/*  66 */       line[0] = (posX - 50);
/*  67 */       line[1] = y;
/*  68 */       line[2] = (posX - 30);
/*  69 */       line[3] = y;
/*  70 */       line[4] = (posX + 50);
/*  71 */       line[5] = y;
/*  72 */       line[6] = (posX + 30);
/*  73 */       line[7] = y;
/*  74 */       if (pitch >= 0) {
/*  75 */         drawLine(line, color);
/*     */       } else {
/*  77 */         drawLineStipple(line, color, 1, 52428);
/*     */       } 
/*     */       
/*  80 */       if (pitch != 0) {
/*  81 */         drawCenteredString("" + pitch, posX - 50 - 10, y - 4, color);
/*  82 */         drawCenteredString("" + pitch, posX + 50 + 10, y - 4, color);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void drawCommonGraduationPitch1(double playerPitch, int color, int posX, int posY) {
/*  89 */     int pitch = (int)playerPitch % 360;
/*  90 */     boolean INVY = true;
/*  91 */     int y = (int)(playerPitch * 10.0D % 10.0D);
/*  92 */     if (y < 0) {
/*  93 */       y += 10;
/*     */     }
/*     */     
/*  96 */     boolean GW = true;
/*  97 */     int posX_L = posX - 100;
/*  98 */     int posX_R = posX + 100;
/*  99 */     int linePosY = posY;
/* 100 */     posY -= 80;
/* 101 */     double[] line = new double[144];
/* 102 */     int p = (playerPitch < 0.0D && y != 0) ? (pitch - 9) : (pitch - 8);
/*     */     
/* 104 */     for (int verticalLine = 0; verticalLine < line.length / 8; p++) {
/* 105 */       int olx = (p % 3 == 0) ? 15 : 5;
/* 106 */       byte ilx = 0;
/* 107 */       line[verticalLine * 8 + 0] = (posX_L - olx);
/* 108 */       line[verticalLine * 8 + 1] = (posY + verticalLine * 10 - y);
/* 109 */       line[verticalLine * 8 + 2] = (posX_L + ilx);
/* 110 */       line[verticalLine * 8 + 3] = (posY + verticalLine * 10 - y);
/* 111 */       line[verticalLine * 8 + 4] = (posX_R + olx);
/* 112 */       line[verticalLine * 8 + 5] = (posY + verticalLine * 10 - y);
/* 113 */       line[verticalLine * 8 + 6] = (posX_R - ilx);
/* 114 */       line[verticalLine * 8 + 7] = (posY + verticalLine * 10 - y);
/* 115 */       verticalLine++;
/*     */     } 
/*     */     
/* 118 */     drawLine(line, color);
/* 119 */     double[] var18 = { (posX_L - 25), (linePosY - 90), posX_L, (linePosY - 90), posX_L, (linePosY + 90), (posX_L - 25), (linePosY + 90) };
/* 120 */     drawLine(var18, color, 3);
/* 121 */     var18 = new double[] { (posX_R + 25), (linePosY - 90), posX_R, (linePosY - 90), posX_R, (linePosY + 90), (posX_R + 25), (linePosY + 90) };
/* 122 */     drawLine(var18, color, 3);
/*     */   }
/*     */   
/*     */   private void drawCommonGraduationYaw(double playerYaw, int color, int posX, int posY) {
/* 126 */     double yaw = MCH_Lib.getRotate360(playerYaw);
/* 127 */     boolean INVX = true;
/* 128 */     posX -= 90;
/* 129 */     double[] line = new double[76];
/* 130 */     int x = (int)(yaw * 10.0D) % 10;
/* 131 */     int y = (int)yaw - 9;
/*     */     
/* 133 */     for (int i = 0; i < line.length / 4; y++) {
/* 134 */       int azPosX = posX + i * 10 - x;
/* 135 */       line[i * 4 + 0] = azPosX;
/* 136 */       line[i * 4 + 1] = posY;
/* 137 */       line[i * 4 + 2] = azPosX;
/* 138 */       line[i * 4 + 3] = (posY + ((y % 45 == 0) ? 15 : ((y % 3 == 0) ? 10 : 5)));
/* 139 */       if (y % 45 == 0) {
/* 140 */         drawCenteredString(MCH_Lib.getAzimuthStr8(y), azPosX, posY - 10, -65536);
/* 141 */       } else if (y % 3 == 0) {
/* 142 */         int rot = y + 180;
/* 143 */         if (rot < 0) {
/* 144 */           rot += 360;
/*     */         }
/*     */         
/* 147 */         if (rot > 360) {
/* 148 */           rot -= 360;
/*     */         }
/*     */         
/* 151 */         drawCenteredString(String.format("%d", new Object[] { Integer.valueOf(rot) }), azPosX, posY - 10, color);
/*     */       } 
/*     */       
/* 154 */       i++;
/*     */     } 
/*     */     
/* 157 */     drawLine(line, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemGraduation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */