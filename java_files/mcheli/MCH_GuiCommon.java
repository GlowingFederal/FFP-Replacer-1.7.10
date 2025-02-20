/*    */ package mcheli;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.aircraft.MCH_AircraftCommonGui;
/*    */ import mcheli.gui.MCH_Gui;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_GuiCommon
/*    */   extends MCH_AircraftCommonGui {
/* 14 */   public int hitCount = 0;
/*    */ 
/*    */   
/*    */   public MCH_GuiCommon(Minecraft minecraft) {
/* 18 */     super(minecraft);
/*    */   }
/*    */   
/*    */   public boolean isDrawGui(EntityPlayer player) {
/* 22 */     return true;
/*    */   }
/*    */   
/*    */   public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/* 26 */     GL11.glLineWidth(MCH_Gui.scaleFactor);
/* 27 */     drawHitBullet(this.hitCount, 15, -805306369);
/*    */   }
/*    */   
/*    */   public void onTick() {
/* 31 */     super.onTick();
/* 32 */     if (this.hitCount > 0) {
/* 33 */       this.hitCount--;
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public void hitBullet() {
/* 39 */     this.hitCount = 15;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_GuiCommon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */