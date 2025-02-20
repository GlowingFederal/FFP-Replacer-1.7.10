/*     */ package mcheli.gui;
/*     */ 
/*     */ import mcheli.MCH_Key;
/*     */ import mcheli.wrapper.W_GuiButton;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.FontRenderer;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_GuiSliderVertical
/*     */   extends W_GuiButton {
/*     */   private float currentSlider;
/*     */   private boolean isMousePress;
/*  16 */   public float valueMin = 0.0F;
/*  17 */   public float valueMax = 1.0F;
/*  18 */   public float valueStep = 0.1F;
/*     */ 
/*     */   
/*     */   public MCH_GuiSliderVertical(int gui_id, int posX, int posY, int sliderWidth, int sliderHeight, String string, float defaultSliderPos, float minVal, float maxVal, float step) {
/*  22 */     super(gui_id, posX, posY, sliderWidth, sliderHeight, string);
/*  23 */     this.valueMin = minVal;
/*  24 */     this.valueMax = maxVal;
/*  25 */     this.valueStep = step;
/*  26 */     setSliderValue(defaultSliderPos);
/*     */   }
/*     */   
/*     */   public int func_146114_a(boolean p_146114_1_) {
/*  30 */     return 0;
/*     */   }
/*     */   
/*     */   public void scrollUp(float a) {
/*  34 */     if (isVisible() && !this.isMousePress) {
/*  35 */       setSliderValue(getSliderValue() + this.valueStep * a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void scrollDown(float a) {
/*  41 */     if (isVisible() && !this.isMousePress) {
/*  42 */       setSliderValue(getSliderValue() - this.valueStep * a);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_146119_b(Minecraft mc, int x, int y) {
/*  48 */     if (isVisible()) {
/*  49 */       if (this.isMousePress) {
/*  50 */         this.currentSlider = (y - this.field_146129_i + 4) / (this.field_146121_g - 8);
/*  51 */         if (this.currentSlider < 0.0F) {
/*  52 */           this.currentSlider = 0.0F;
/*     */         }
/*     */         
/*  55 */         if (this.currentSlider > 1.0F) {
/*  56 */           this.currentSlider = 1.0F;
/*     */         }
/*     */         
/*  59 */         this.currentSlider = normalizeValue(denormalizeValue(this.currentSlider));
/*     */       } 
/*     */       
/*  62 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  63 */       func_73729_b(this.field_146128_h, this.field_146129_i + (int)(this.currentSlider * (this.field_146121_g - 8)), 66, 0, 20, 4);
/*  64 */       func_73729_b(this.field_146128_h, this.field_146129_i + (int)(this.currentSlider * (this.field_146121_g - 8)) + 4, 66, 196, 20, 4);
/*  65 */       if (!MCH_Key.isKeyDown(-100)) {
/*  66 */         func_146118_a(x, y);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setSliderValue(float f) {
/*  73 */     this.currentSlider = normalizeValue(f);
/*     */   }
/*     */   
/*     */   public float getSliderValue() {
/*  77 */     return denormalizeValue(this.currentSlider);
/*     */   }
/*     */   
/*     */   public float getSliderValueInt(int digit) {
/*     */     int d;
/*  82 */     for (d = 1; digit > 0; digit--) {
/*  83 */       d *= 10;
/*     */     }
/*     */     
/*  86 */     int n = (int)(denormalizeValue(this.currentSlider) * d);
/*  87 */     return n / d;
/*     */   }
/*     */   
/*     */   public float normalizeValue(float f) {
/*  91 */     return MathHelper.func_76131_a((snapToStepClamp(f) - this.valueMin) / (this.valueMax - this.valueMin), 0.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public float denormalizeValue(float f) {
/*  95 */     return snapToStepClamp(this.valueMin + (this.valueMax - this.valueMin) * MathHelper.func_76131_a(f, 0.0F, 1.0F));
/*     */   }
/*     */   
/*     */   public float snapToStepClamp(float f) {
/*  99 */     f = snapToStep(f);
/* 100 */     return MathHelper.func_76131_a(f, this.valueMin, this.valueMax);
/*     */   }
/*     */   
/*     */   protected float snapToStep(float f) {
/* 104 */     if (this.valueStep > 0.0F) {
/* 105 */       f = this.valueStep * Math.round(f / this.valueStep);
/*     */     }
/*     */     
/* 108 */     return f;
/*     */   }
/*     */   
/*     */   public boolean func_146116_c(Minecraft mc, int x, int y) {
/* 112 */     if (super.func_146116_c(mc, x, y)) {
/* 113 */       this.currentSlider = (y - this.field_146129_i + 4) / (this.field_146121_g - 8);
/* 114 */       if (this.currentSlider < 0.0F) {
/* 115 */         this.currentSlider = 0.0F;
/*     */       }
/*     */       
/* 118 */       if (this.currentSlider > 1.0F) {
/* 119 */         this.currentSlider = 1.0F;
/*     */       }
/*     */       
/* 122 */       this.isMousePress = true;
/* 123 */       return true;
/*     */     } 
/* 125 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146118_a(int p_146118_1_, int p_146118_2_) {
/* 130 */     this.isMousePress = false;
/*     */   }
/*     */   
/*     */   public void func_146112_a(Minecraft mc, int x, int y) {
/* 134 */     if (isVisible()) {
/* 135 */       FontRenderer fontrenderer = mc.field_71466_p;
/* 136 */       mc.func_110434_K().func_110577_a(new ResourceLocation("mcheli", "textures/gui/widgets.png"));
/* 137 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 138 */       setOnMouseOver((x >= this.field_146128_h && y >= this.field_146129_i && x < this.field_146128_h + this.field_146120_f && y < this.field_146129_i + this.field_146121_g));
/* 139 */       int k = func_146114_a(isOnMouseOver());
/* 140 */       enableBlend();
/* 141 */       func_73729_b(this.field_146128_h, this.field_146129_i, 46 + k * 20, 0, this.field_146120_f, this.field_146121_g / 2);
/* 142 */       func_73729_b(this.field_146128_h, this.field_146129_i + this.field_146121_g / 2, 46 + k * 20, 200 - this.field_146121_g / 2, this.field_146120_f, this.field_146121_g / 2);
/* 143 */       func_146119_b(mc, x, y);
/* 144 */       int l = 14737632;
/* 145 */       if (this.packedFGColour != 0) {
/* 146 */         l = this.packedFGColour;
/* 147 */       } else if (!this.field_146124_l) {
/* 148 */         l = 10526880;
/* 149 */       } else if (isOnMouseOver()) {
/* 150 */         l = 16777120;
/*     */       } 
/*     */       
/* 153 */       func_73732_a(fontrenderer, this.field_146126_j, this.field_146128_h + this.field_146120_f / 2, this.field_146129_i + (this.field_146121_g - 8) / 2, l);
/* 154 */       mc.func_110434_K().func_110577_a(GuiButton.field_146122_a);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gui\MCH_GuiSliderVertical.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */