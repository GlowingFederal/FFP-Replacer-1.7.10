/*    */ package mcheli.gui;
/*    */ 
/*    */ import mcheli.wrapper.W_GuiButton;
/*    */ import net.minecraft.client.Minecraft;
/*    */ 
/*    */ public class MCH_GuiOnOffButton
/*    */   extends W_GuiButton
/*    */ {
/*    */   private boolean statOnOff;
/*    */   private final String dispOnOffString;
/*    */   
/*    */   public MCH_GuiOnOffButton(int par1, int par2, int par3, int par4, int par5, String par6Str) {
/* 13 */     super(par1, par2, par3, par4, par5, "");
/* 14 */     this.dispOnOffString = par6Str;
/* 15 */     setOnOff(false);
/*    */   }
/*    */   
/*    */   public void setOnOff(boolean b) {
/* 19 */     this.statOnOff = b;
/* 20 */     this.field_146126_j = this.dispOnOffString + (getOnOff() ? "ON" : "OFF");
/*    */   }
/*    */   
/*    */   public boolean getOnOff() {
/* 24 */     return this.statOnOff;
/*    */   }
/*    */   
/*    */   public void switchOnOff() {
/* 28 */     setOnOff(!getOnOff());
/*    */   }
/*    */   
/*    */   public boolean func_146116_c(Minecraft mc, int x, int y) {
/* 32 */     if (super.func_146116_c(mc, x, y)) {
/* 33 */       switchOnOff();
/* 34 */       return true;
/*    */     } 
/* 36 */     return false;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gui\MCH_GuiOnOffButton.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */