/*     */ package mcheli.gui;
/*     */ 
/*     */ import mcheli.MCH_Key;
/*     */ import mcheli.wrapper.W_GuiButton;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_GuiSlider
/*     */   extends W_GuiButton {
/*     */   private float currentSlider;
/*     */   private boolean isMousePress;
/*     */   public String stringFormat;
/*  14 */   public float valueMin = 0.0F;
/*  15 */   public float valueMax = 1.0F;
/*  16 */   public float valueStep = 0.1F;
/*     */ 
/*     */   
/*     */   public MCH_GuiSlider(int gui_id, int posX, int posY, int sliderWidth, int sliderHeight, String string_format, float defaultSliderPos, float minVal, float maxVal, float step) {
/*  20 */     super(gui_id, posX, posY, sliderWidth, sliderHeight, "");
/*  21 */     this.stringFormat = string_format;
/*  22 */     this.valueMin = minVal;
/*  23 */     this.valueMax = maxVal;
/*  24 */     this.valueStep = step;
/*  25 */     setSliderValue(defaultSliderPos);
/*     */   }
/*     */   
/*     */   public int func_146114_a(boolean p_146114_1_) {
/*  29 */     return 0;
/*     */   }
/*     */   
/*     */   protected void func_146119_b(Minecraft mc, int x, int y) {
/*  33 */     if (isVisible()) {
/*  34 */       if (this.isMousePress) {
/*  35 */         this.currentSlider = (x - this.field_146128_h + 4) / (this.field_146120_f - 8);
/*  36 */         if (this.currentSlider < 0.0F) {
/*  37 */           this.currentSlider = 0.0F;
/*     */         }
/*     */         
/*  40 */         if (this.currentSlider > 1.0F) {
/*  41 */           this.currentSlider = 1.0F;
/*     */         }
/*     */         
/*  44 */         this.currentSlider = normalizeValue(denormalizeValue(this.currentSlider));
/*  45 */         updateDisplayString();
/*     */       } 
/*     */       
/*  48 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  49 */       func_73729_b(this.field_146128_h + (int)(this.currentSlider * (this.field_146120_f - 8)), this.field_146129_i, 0, 66, 4, 20);
/*  50 */       func_73729_b(this.field_146128_h + (int)(this.currentSlider * (this.field_146120_f - 8)) + 4, this.field_146129_i, 196, 66, 4, 20);
/*  51 */       if (!MCH_Key.isKeyDown(-100)) {
/*  52 */         func_146118_a(x, y);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateDisplayString() {
/*  59 */     this.field_146126_j = String.format(this.stringFormat, new Object[] { Float.valueOf(denormalizeValue(this.currentSlider)) });
/*     */   }
/*     */   
/*     */   public void setSliderValue(float f) {
/*  63 */     this.currentSlider = normalizeValue(f);
/*  64 */     updateDisplayString();
/*     */   }
/*     */   
/*     */   public float getSliderValue() {
/*  68 */     return denormalizeValue(this.currentSlider);
/*     */   }
/*     */   
/*     */   public float getSliderValueInt(int digit) {
/*     */     int d;
/*  73 */     for (d = 1; digit > 0; digit--) {
/*  74 */       d *= 10;
/*     */     }
/*     */     
/*  77 */     int n = (int)(denormalizeValue(this.currentSlider) * d);
/*  78 */     return n / d;
/*     */   }
/*     */   
/*     */   public float normalizeValue(float f) {
/*  82 */     return MathHelper.func_76131_a((snapToStepClamp(f) - this.valueMin) / (this.valueMax - this.valueMin), 0.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public float denormalizeValue(float f) {
/*  86 */     return snapToStepClamp(this.valueMin + (this.valueMax - this.valueMin) * MathHelper.func_76131_a(f, 0.0F, 1.0F));
/*     */   }
/*     */   
/*     */   public float snapToStepClamp(float f) {
/*  90 */     f = snapToStep(f);
/*  91 */     return MathHelper.func_76131_a(f, this.valueMin, this.valueMax);
/*     */   }
/*     */   
/*     */   protected float snapToStep(float f) {
/*  95 */     if (this.valueStep > 0.0F) {
/*  96 */       f = this.valueStep * Math.round(f / this.valueStep);
/*     */     }
/*     */     
/*  99 */     return f;
/*     */   }
/*     */   
/*     */   public boolean func_146116_c(Minecraft mc, int x, int y) {
/* 103 */     if (super.func_146116_c(mc, x, y)) {
/* 104 */       this.currentSlider = (x - this.field_146128_h + 4) / (this.field_146120_f - 8);
/* 105 */       if (this.currentSlider < 0.0F) {
/* 106 */         this.currentSlider = 0.0F;
/*     */       }
/*     */       
/* 109 */       if (this.currentSlider > 1.0F) {
/* 110 */         this.currentSlider = 1.0F;
/*     */       }
/*     */       
/* 113 */       updateDisplayString();
/* 114 */       this.isMousePress = true;
/* 115 */       return true;
/*     */     } 
/* 117 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146118_a(int p_146118_1_, int p_146118_2_) {
/* 122 */     this.isMousePress = false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gui\MCH_GuiSlider.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */