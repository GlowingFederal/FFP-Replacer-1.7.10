/*    */ package mcheli.gui;
/*    */ 
/*    */ import mcheli.MCH_ConfigPrm;
/*    */ import mcheli.MCH_KeyName;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ 
/*    */ public class MCH_GuiListItemKeyBind
/*    */   extends MCH_GuiListItem
/*    */ {
/*    */   public String displayString;
/*    */   public GuiButton button;
/*    */   public GuiButton buttonReset;
/*    */   public int keycode;
/*    */   public final int defaultKeycode;
/*    */   public MCH_ConfigPrm config;
/*    */   public GuiButton lastPushButton;
/*    */   
/*    */   public MCH_GuiListItemKeyBind(int id, int idReset, int posX, String dispStr, MCH_ConfigPrm prm) {
/* 20 */     this.displayString = dispStr;
/* 21 */     this.defaultKeycode = prm.prmIntDefault;
/* 22 */     this.button = new GuiButton(id, posX + 160, 0, 70, 20, "");
/* 23 */     this.buttonReset = new GuiButton(idReset, posX + 240, 0, 40, 20, "Reset");
/* 24 */     this.config = prm;
/* 25 */     this.lastPushButton = null;
/* 26 */     setKeycode(prm.prmInt);
/*    */   }
/*    */   
/*    */   public void mouseReleased(int x, int y) {
/* 30 */     this.button.func_146118_a(x, y);
/* 31 */     this.buttonReset.func_146118_a(x, y);
/*    */   }
/*    */   
/*    */   public boolean mousePressed(Minecraft mc, int x, int y) {
/* 35 */     if (this.button.func_146116_c(mc, x, y)) {
/* 36 */       this.lastPushButton = this.button;
/* 37 */       return true;
/* 38 */     }  if (this.buttonReset.func_146116_c(mc, x, y)) {
/* 39 */       this.lastPushButton = this.buttonReset;
/* 40 */       return true;
/*    */     } 
/* 42 */     return false;
/*    */   }
/*    */ 
/*    */   
/*    */   public void draw(Minecraft mc, int mouseX, int mouseY, int posX, int posY) {
/* 47 */     byte y = 6;
/* 48 */     this.button.func_73731_b(mc.field_71466_p, this.displayString, posX + 10, posY + y, -1);
/* 49 */     this.button.field_146129_i = posY;
/* 50 */     this.button.func_146112_a(mc, mouseX, mouseY);
/* 51 */     this.buttonReset.field_146124_l = (this.keycode != this.defaultKeycode);
/* 52 */     this.buttonReset.field_146129_i = posY;
/* 53 */     this.buttonReset.func_146112_a(mc, mouseX, mouseY);
/*    */   }
/*    */   
/*    */   public void applyKeycode() {
/* 57 */     this.config.setPrm(this.keycode);
/*    */   }
/*    */   
/*    */   public void resetKeycode() {
/* 61 */     setKeycode(this.defaultKeycode);
/*    */   }
/*    */   
/*    */   public void setKeycode(int k) {
/* 65 */     if (k != 0 && !MCH_KeyName.getDescOrName(k).isEmpty()) {
/* 66 */       this.keycode = k;
/* 67 */       this.button.field_146126_j = MCH_KeyName.getDescOrName(k);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gui\MCH_GuiListItemKeyBind.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */