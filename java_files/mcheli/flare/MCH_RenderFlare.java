/*    */ package mcheli.flare;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderFlare
/*    */   extends W_Render {
/* 13 */   protected MCH_ModelFlare model = new MCH_ModelFlare();
/*    */ 
/*    */   
/*    */   public void func_76986_a(Entity entity, double posX, double posY, double posZ, float yaw, float partialTickTime) {
/* 17 */     GL11.glPushMatrix();
/* 18 */     GL11.glEnable(2884);
/* 19 */     double var10000 = entity.field_70169_q + entity.field_70159_w * partialTickTime;
/* 20 */     var10000 = entity.field_70167_r + entity.field_70181_x * partialTickTime;
/* 21 */     var10000 = entity.field_70166_s + entity.field_70179_y * partialTickTime;
/* 22 */     GL11.glTranslated(posX, posY, posZ);
/* 23 */     GL11.glRotatef(-entity.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 24 */     GL11.glRotatef(entity.field_70125_A, 1.0F, 0.0F, 0.0F);
/* 25 */     GL11.glRotatef(45.0F, 0.0F, 0.0F, 1.0F);
/* 26 */     GL11.glColor4f(1.0F, 1.0F, 0.5F, 1.0F);
/* 27 */     bindTexture("textures/flare.png");
/* 28 */     this.model.renderModel(0.0D, 0.0D, 0.0625F);
/* 29 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 33 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\flare\MCH_RenderFlare.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */