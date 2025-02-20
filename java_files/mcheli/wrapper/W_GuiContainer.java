/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.client.gui.FontRenderer;
/*    */ import net.minecraft.client.gui.GuiScreen;
/*    */ import net.minecraft.client.gui.inventory.GuiContainer;
/*    */ import net.minecraft.inventory.Container;
/*    */ import net.minecraft.item.ItemStack;
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
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public abstract class W_GuiContainer
/*    */   extends GuiContainer
/*    */ {
/*    */   public W_GuiContainer(Container par1Container) {
/* 29 */     super(par1Container);
/*    */   }
/*    */   
/*    */   public void drawItemStack(ItemStack item, int x, int y) {
/* 33 */     if (item == null) {
/*    */       return;
/*    */     }
/* 36 */     if (item.func_77973_b() == null) {
/*    */       return;
/*    */     }
/* 39 */     FontRenderer font = item.func_77973_b().getFontRenderer(item);
/* 40 */     if (font == null) {
/* 41 */       font = this.field_146289_q;
/*    */     }
/* 43 */     GL11.glEnable(2929);
/* 44 */     GL11.glEnable(2896);
/* 45 */     GuiScreen.field_146296_j.func_82406_b(font, this.field_146297_k.func_110434_K(), item, x, y);
/* 46 */     GuiScreen.field_146296_j.func_94148_a(font, this.field_146297_k.func_110434_K(), item, x, y, null);
/* 47 */     this.field_73735_i = 0.0F;
/* 48 */     GuiScreen.field_146296_j.field_77023_b = 0.0F;
/*    */   }
/*    */   
/*    */   public void drawString(String s, int x, int y, int color) {
/* 52 */     func_73731_b(this.field_146289_q, s, x, y, color);
/*    */   }
/*    */   
/*    */   public void drawCenteredString(String s, int x, int y, int color) {
/* 56 */     func_73732_a(this.field_146289_q, s, x, y, color);
/*    */   }
/*    */   
/*    */   public int getStringWidth(String s) {
/* 60 */     return this.field_146289_q.func_78256_a(s);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_GuiContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */