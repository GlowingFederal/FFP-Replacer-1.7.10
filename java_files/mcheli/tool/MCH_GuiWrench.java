/*    */ package mcheli.tool;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.gui.MCH_Gui;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_GuiWrench
/*    */   extends MCH_Gui {
/*    */   public MCH_GuiWrench(Minecraft minecraft) {
/* 15 */     super(minecraft);
/*    */   }
/*    */   
/*    */   public void func_73866_w_() {
/* 19 */     super.func_73866_w_();
/*    */   }
/*    */   
/*    */   public boolean func_73868_f() {
/* 23 */     return false;
/*    */   }
/*    */   
/*    */   public boolean isDrawGui(EntityPlayer player) {
/* 27 */     return (player != null && player.field_70170_p != null && player.func_71045_bC() != null && player.func_71045_bC().func_77973_b() instanceof MCH_ItemWrench);
/*    */   }
/*    */   
/*    */   public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/* 31 */     if (!isThirdPersonView) {
/* 32 */       GL11.glLineWidth(MCH_Gui.scaleFactor);
/* 33 */       if (isDrawGui(player)) {
/* 34 */         GL11.glDisable(3042);
/* 35 */         MCH_EntityAircraft ac = ((MCH_ItemWrench)player.func_71045_bC().func_77973_b()).getMouseOverAircraft(player);
/* 36 */         if (ac != null && ac.getMaxHP() > 0) {
/* 37 */           int color = (ac.getHP() / ac.getMaxHP() > 0.3D) ? -14101432 : -2161656;
/* 38 */           drawHP(color, -15433180, ac.getHP(), ac.getMaxHP());
/*    */         } 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   void drawHP(int color, int colorBG, int hp, int hpmax) {
/* 46 */     int posX = this.centerX;
/* 47 */     int posY = this.centerY + 20;
/* 48 */     boolean WID = true;
/* 49 */     boolean INV = true;
/* 50 */     func_73734_a(posX - 20, posY + 20 + 1, posX - 20 + 40, posY + 20 + 1 + 1 + 3 + 1, colorBG);
/* 51 */     if (hp > hpmax) {
/* 52 */       hp = hpmax;
/*    */     }
/*    */     
/* 55 */     float hpp = hp / hpmax;
/* 56 */     func_73734_a(posX - 20 + 1, posY + 20 + 1 + 1, posX - 20 + 1 + (int)(38.0D * hpp), posY + 20 + 1 + 1 + 3, color);
/* 57 */     int hppn = (int)(hpp * 100.0F);
/* 58 */     if (hp < hpmax && hppn >= 100) {
/* 59 */       hppn = 99;
/*    */     }
/*    */     
/* 62 */     drawCenteredString(String.format("%d %%", new Object[] { Integer.valueOf(hppn) }), posX, posY + 30, color);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tool\MCH_GuiWrench.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */