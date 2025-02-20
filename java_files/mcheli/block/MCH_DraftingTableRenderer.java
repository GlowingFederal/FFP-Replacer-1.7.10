/*    */ package mcheli.block;
/*    */ 
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.MCH_ModelManager;
/*    */ import mcheli.wrapper.W_McClient;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
/*    */ import net.minecraft.tileentity.TileEntity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MCH_DraftingTableRenderer
/*    */   extends TileEntitySpecialRenderer {
/*    */   public void func_147500_a(TileEntity tile, double posX, double posY, double posZ, float var8) {
/* 15 */     GL11.glPushMatrix();
/* 16 */     GL11.glEnable(2884);
/* 17 */     GL11.glTranslated(posX + 0.5D, posY, posZ + 0.5D);
/* 18 */     float yaw = (-tile.func_145832_p() * 45 + 180);
/* 19 */     GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
/* 20 */     RenderHelper.func_74519_b();
/* 21 */     GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);
/* 22 */     GL11.glEnable(3042);
/* 23 */     int srcBlend = GL11.glGetInteger(3041);
/* 24 */     int dstBlend = GL11.glGetInteger(3040);
/* 25 */     GL11.glBlendFunc(770, 771);
/* 26 */     MCH_Config var10000 = MCH_MOD.config;
/* 27 */     if (MCH_Config.SmoothShading.prmBool) {
/* 28 */       GL11.glShadeModel(7425);
/*    */     }
/*    */     
/* 31 */     W_McClient.MOD_bindTexture("textures/blocks/drafting_table.png");
/* 32 */     MCH_ModelManager.render("blocks", "drafting_table");
/* 33 */     GL11.glBlendFunc(srcBlend, dstBlend);
/* 34 */     GL11.glDisable(3042);
/* 35 */     GL11.glShadeModel(7424);
/* 36 */     GL11.glPopMatrix();
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\block\MCH_DraftingTableRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */