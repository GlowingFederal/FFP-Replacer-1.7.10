/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import java.util.ArrayList;
/*    */ import java.util.List;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_GuiButton
/*    */   extends GuiButton
/*    */ {
/* 20 */   public List<String> hoverStringList = null;
/*    */   
/*    */   public W_GuiButton(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/* 23 */     super(par1, par2, par3, par4, par5, par6Str);
/*    */   }
/*    */   
/*    */   public void addHoverString(String s) {
/* 27 */     if (this.hoverStringList == null) {
/* 28 */       this.hoverStringList = new ArrayList<>();
/*    */     }
/* 30 */     this.hoverStringList.add(s);
/*    */   }
/*    */   
/*    */   public boolean isVisible() {
/* 34 */     return this.field_146125_m;
/*    */   }
/*    */   
/*    */   public void setVisible(boolean b) {
/* 38 */     this.field_146125_m = b;
/*    */   }
/*    */   
/*    */   public static void setVisible(GuiButton button, boolean b) {
/* 42 */     button.field_146125_m = b;
/*    */   }
/*    */   
/*    */   public void enableBlend() {
/* 46 */     GL11.glEnable(3042);
/* 47 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/* 48 */     GL11.glBlendFunc(770, 771);
/*    */   }
/*    */   
/*    */   public boolean isOnMouseOver() {
/* 52 */     return this.field_146123_n;
/*    */   }
/*    */   
/*    */   public void setOnMouseOver(boolean b) {
/* 56 */     this.field_146123_n = b;
/*    */   }
/*    */   
/*    */   public int getWidth() {
/* 60 */     return this.field_146120_f;
/*    */   }
/*    */   
/*    */   public int getHeight() {
/* 64 */     return this.field_146121_g;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_GuiButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */