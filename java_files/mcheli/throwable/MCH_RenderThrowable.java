/*    */ package mcheli.throwable;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderThrowable
/*    */   extends W_Render {
/*    */   public MCH_RenderThrowable() {
/* 14 */     this.field_76989_e = 0.0F;
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double posX, double posY, double posZ, float par8, float tickTime) {
/* 18 */     MCH_EntityThrowable throwable = (MCH_EntityThrowable)entity;
/* 19 */     MCH_ThrowableInfo info = throwable.getInfo();
/* 20 */     if (info != null) {
/* 21 */       GL11.glPushMatrix();
/* 22 */       GL11.glTranslated(posX, posY, posZ);
/* 23 */       GL11.glRotatef(entity.field_70177_z, 0.0F, -1.0F, 0.0F);
/* 24 */       GL11.glRotatef(entity.field_70125_A, 1.0F, 0.0F, 0.0F);
/* 25 */       setCommonRenderParam(true, entity.func_70070_b(tickTime));
/* 26 */       if (info.model != null) {
/* 27 */         bindTexture("textures/throwable/" + info.name + ".png");
/* 28 */         info.model.renderAll();
/*    */       } 
/*    */       
/* 31 */       restoreCommonRenderParam();
/* 32 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 37 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\throwable\MCH_RenderThrowable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */