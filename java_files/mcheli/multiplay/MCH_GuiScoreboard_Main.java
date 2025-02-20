/*    */ package mcheli.multiplay;
/*    */ 
/*    */ import java.util.Iterator;
/*    */ import java.util.List;
/*    */ import mcheli.MCH_ServerSettings;
/*    */ import mcheli.wrapper.W_GuiButton;
/*    */ import net.minecraft.client.gui.GuiButton;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ public class MCH_GuiScoreboard_Main
/*    */   extends MCH_GuiScoreboard_Base
/*    */ {
/*    */   private W_GuiButton buttonSwitchPVP;
/*    */   
/*    */   public MCH_GuiScoreboard_Main(MCH_IGuiScoreboard switcher, EntityPlayer player) {
/* 17 */     super(switcher, player);
/*    */   }
/*    */   
/*    */   public void func_73866_w_() {
/* 21 */     super.func_73866_w_();
/*    */   }
/*    */ 
/*    */   
/*    */   protected void func_73869_a(char c, int code) {
/* 26 */     if (code == 1) {
/* 27 */       this.field_146297_k.field_71439_g.func_71053_j();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void updateScreenButtons(List list) {
/* 33 */     Iterator i$ = list.iterator();
/*    */     
/* 35 */     while (i$.hasNext()) {
/* 36 */       Object o = i$.next();
/* 37 */       GuiButton button = (GuiButton)o;
/* 38 */       if (button.field_146127_k == 1024) {
/* 39 */         button.field_146126_j = "PVP : " + (MCH_ServerSettings.enablePVP ? "ON" : "OFF");
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */ 
/*    */   
/*    */   protected void func_146284_a(GuiButton btn) {}
/*    */ 
/*    */   
/*    */   public void drawGuiContainerForegroundLayerScreen(int x, int y) {
/* 50 */     super.drawGuiContainerForegroundLayerScreen(x, y);
/*    */   }
/*    */   
/*    */   protected void func_146976_a(float par1, int par2, int par3) {
/* 54 */     drawList(this.field_146297_k, this.field_146289_q, true);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\multiplay\MCH_GuiScoreboard_Main.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */