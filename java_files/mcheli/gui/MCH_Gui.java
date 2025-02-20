/*     */ package mcheli.gui;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Random;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_ScaledResolution;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiScreen;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public abstract class MCH_Gui
/*     */   extends GuiScreen
/*     */ {
/*  19 */   protected int centerX = 0;
/*  20 */   protected int centerY = 0;
/*  21 */   protected Random rand = new Random();
/*     */   
/*     */   protected float smoothCamPartialTicks;
/*     */   public static int scaleFactor;
/*     */   
/*     */   public MCH_Gui(Minecraft minecraft) {
/*  27 */     this.field_146297_k = minecraft;
/*  28 */     this.smoothCamPartialTicks = 0.0F;
/*  29 */     this.field_73735_i = -110.0F;
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  33 */     super.func_73866_w_();
/*     */   }
/*     */   
/*     */   public boolean func_73868_f() {
/*  37 */     return false;
/*     */   }
/*     */   
/*     */   public void onTick() {}
/*     */   
/*     */   public abstract boolean isDrawGui(EntityPlayer paramEntityPlayer);
/*     */   
/*     */   public abstract void drawGui(EntityPlayer paramEntityPlayer, boolean paramBoolean);
/*     */   
/*     */   public void func_73863_a(int par1, int par2, float partialTicks) {
/*  47 */     this.smoothCamPartialTicks = partialTicks;
/*  48 */     W_ScaledResolution scaledresolution = new W_ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/*  49 */     scaleFactor = scaledresolution.func_78325_e();
/*  50 */     if (!this.field_146297_k.field_71474_y.field_74319_N) {
/*  51 */       this.field_146294_l = this.field_146297_k.field_71443_c / scaleFactor;
/*  52 */       this.field_146295_m = this.field_146297_k.field_71440_d / scaleFactor;
/*  53 */       this.centerX = this.field_146294_l / 2;
/*  54 */       this.centerY = this.field_146295_m / 2;
/*  55 */       GL11.glPushMatrix();
/*  56 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  57 */       if (this.field_146297_k.field_71439_g != null) {
/*  58 */         drawGui((EntityPlayer)this.field_146297_k.field_71439_g, (this.field_146297_k.field_71474_y.field_74320_O != 0));
/*     */       }
/*     */       
/*  61 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  62 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawTexturedModalRectRotate(double left, double top, double width, double height, double uLeft, double vTop, double uWidth, double vHeight, float rot) {
/*  68 */     GL11.glPushMatrix();
/*  69 */     GL11.glTranslated(left + width / 2.0D, top + height / 2.0D, 0.0D);
/*  70 */     GL11.glRotatef(rot, 0.0F, 0.0F, 1.0F);
/*  71 */     float f = 0.00390625F;
/*  72 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  73 */     tessellator.func_78382_b();
/*  74 */     tessellator.func_78374_a(-width / 2.0D, height / 2.0D, this.field_73735_i, uLeft * 0.00390625D, (vTop + vHeight) * 0.00390625D);
/*  75 */     tessellator.func_78374_a(width / 2.0D, height / 2.0D, this.field_73735_i, (uLeft + uWidth) * 0.00390625D, (vTop + vHeight) * 0.00390625D);
/*  76 */     tessellator.func_78374_a(width / 2.0D, -height / 2.0D, this.field_73735_i, (uLeft + uWidth) * 0.00390625D, vTop * 0.00390625D);
/*  77 */     tessellator.func_78374_a(-width / 2.0D, -height / 2.0D, this.field_73735_i, uLeft * 0.00390625D, vTop * 0.00390625D);
/*  78 */     tessellator.func_78381_a();
/*  79 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void drawTexturedRect(double left, double top, double width, double height, double uLeft, double vTop, double uWidth, double vHeight, double textureWidth, double textureHeight) {
/*  83 */     float fx = (float)(1.0D / textureWidth);
/*  84 */     float fy = (float)(1.0D / textureHeight);
/*  85 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  86 */     tessellator.func_78382_b();
/*  87 */     tessellator.func_78374_a(left, top + height, this.field_73735_i, uLeft * fx, (vTop + vHeight) * fy);
/*  88 */     tessellator.func_78374_a(left + width, top + height, this.field_73735_i, (uLeft + uWidth) * fx, (vTop + vHeight) * fy);
/*  89 */     tessellator.func_78374_a(left + width, top, this.field_73735_i, (uLeft + uWidth) * fx, vTop * fy);
/*  90 */     tessellator.func_78374_a(left, top, this.field_73735_i, uLeft * fx, vTop * fy);
/*  91 */     tessellator.func_78381_a();
/*     */   }
/*     */   
/*     */   public void drawLineStipple(double[] line, int color, int factor, int pattern) {
/*  95 */     GL11.glEnable(2852);
/*  96 */     GL11.glLineStipple(factor, (short)pattern);
/*  97 */     drawLine(line, color);
/*  98 */     GL11.glDisable(2852);
/*     */   }
/*     */   
/*     */   public void drawLine(double[] line, int color) {
/* 102 */     drawLine(line, color, 1);
/*     */   }
/*     */   
/*     */   public void drawString(String s, int x, int y, int color) {
/* 106 */     func_73731_b(this.field_146297_k.field_71466_p, s, x, y, color);
/*     */   }
/*     */   
/*     */   public void drawDigit(String s, int x, int y, int interval, int color) {
/* 110 */     GL11.glEnable(3042);
/* 111 */     GL11.glColor4ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color & 0xFF), (byte)(color >> 24 & 0xFF));
/* 112 */     int srcBlend = GL11.glGetInteger(3041);
/* 113 */     int dstBlend = GL11.glGetInteger(3040);
/* 114 */     GL11.glBlendFunc(770, 771);
/* 115 */     W_McClient.MOD_bindTexture("textures/gui/digit.png");
/*     */     
/* 117 */     for (int i = 0; i < s.length(); i++) {
/* 118 */       char c = s.charAt(i);
/* 119 */       if (c >= '0' && c <= '9') {
/* 120 */         func_73729_b(x + interval * i, y, 16 * (c - 48), 0, 16, 16);
/*     */       }
/*     */       
/* 123 */       if (c == '-') {
/* 124 */         func_73729_b(x + interval * i, y, 160, 0, 16, 16);
/*     */       }
/*     */     } 
/*     */     
/* 128 */     GL11.glBlendFunc(srcBlend, dstBlend);
/* 129 */     GL11.glDisable(3042);
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String s, int x, int y, int color) {
/* 133 */     func_73732_a(this.field_146297_k.field_71466_p, s, x, y, color);
/*     */   }
/*     */   
/*     */   public void drawLine(double[] line, int color, int mode) {
/* 137 */     GL11.glPushMatrix();
/* 138 */     GL11.glEnable(3042);
/* 139 */     GL11.glDisable(3553);
/* 140 */     GL11.glBlendFunc(770, 771);
/* 141 */     GL11.glColor4ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color >> 0 & 0xFF), (byte)(color >> 24 & 0xFF));
/* 142 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 143 */     tessellator.func_78371_b(mode);
/*     */     
/* 145 */     for (int i = 0; i < line.length; i += 2) {
/* 146 */       tessellator.func_78377_a(line[i + 0], line[i + 1], this.field_73735_i);
/*     */     }
/*     */     
/* 149 */     tessellator.func_78381_a();
/* 150 */     GL11.glEnable(3553);
/* 151 */     GL11.glDisable(3042);
/* 152 */     GL11.glColor4b((byte)-1, (byte)-1, (byte)-1, (byte)-1);
/* 153 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void drawPoints(double[] points, int color, int pointWidth) {
/* 157 */     int prevWidth = GL11.glGetInteger(2833);
/* 158 */     GL11.glPushMatrix();
/* 159 */     GL11.glEnable(3042);
/* 160 */     GL11.glDisable(3553);
/* 161 */     GL11.glBlendFunc(770, 771);
/* 162 */     GL11.glColor4ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color >> 0 & 0xFF), (byte)(color >> 24 & 0xFF));
/* 163 */     GL11.glPointSize(pointWidth);
/* 164 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 165 */     tessellator.func_78371_b(0);
/*     */     
/* 167 */     for (int i = 0; i < points.length; i += 2) {
/* 168 */       tessellator.func_78377_a(points[i], points[i + 1], 0.0D);
/*     */     }
/*     */     
/* 171 */     tessellator.func_78381_a();
/* 172 */     GL11.glEnable(3553);
/* 173 */     GL11.glDisable(3042);
/* 174 */     GL11.glPopMatrix();
/* 175 */     GL11.glColor4b((byte)-1, (byte)-1, (byte)-1, (byte)-1);
/* 176 */     GL11.glPointSize(prevWidth);
/*     */   }
/*     */   
/*     */   public void drawPoints(ArrayList<Double> points, int color, int pointWidth) {
/* 180 */     int prevWidth = GL11.glGetInteger(2833);
/* 181 */     GL11.glPushMatrix();
/* 182 */     GL11.glEnable(3042);
/* 183 */     GL11.glDisable(3553);
/* 184 */     GL11.glBlendFunc(770, 771);
/* 185 */     GL11.glColor4ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color >> 0 & 0xFF), (byte)(color >> 24 & 0xFF));
/* 186 */     GL11.glPointSize(pointWidth);
/* 187 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 188 */     tessellator.func_78371_b(0);
/*     */     
/* 190 */     for (int i = 0; i < points.size(); i += 2) {
/* 191 */       tessellator.func_78377_a(((Double)points.get(i)).doubleValue(), ((Double)points.get(i + 1)).doubleValue(), 0.0D);
/*     */     }
/*     */     
/* 194 */     tessellator.func_78381_a();
/* 195 */     GL11.glEnable(3553);
/* 196 */     GL11.glDisable(3042);
/* 197 */     GL11.glPopMatrix();
/* 198 */     GL11.glColor4b((byte)-1, (byte)-1, (byte)-1, (byte)-1);
/* 199 */     GL11.glPointSize(prevWidth);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gui\MCH_Gui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */