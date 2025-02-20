/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import java.nio.FloatBuffer;
/*    */ import mcheli.MCH_Config;
/*    */ import net.minecraft.client.renderer.GLAllocation;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.renderer.entity.Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
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
/*    */ public abstract class W_Render
/*    */   extends Render
/*    */ {
/* 26 */   private static FloatBuffer colorBuffer = GLAllocation.func_74529_h(16);
/* 27 */   protected static final ResourceLocation TEX_DEFAULT = new ResourceLocation(W_MOD.DOMAIN, "textures/default.png");
/*    */   public int srcBlend;
/*    */   public int dstBlend;
/*    */   
/*    */   protected void bindTexture(String path) {
/* 32 */     func_110776_a(new ResourceLocation(W_MOD.DOMAIN, path));
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 36 */     return TEX_DEFAULT;
/*    */   }
/*    */   
/*    */   public static FloatBuffer setColorBuffer(float p_74521_0_, float p_74521_1_, float p_74521_2_, float p_74521_3_) {
/* 40 */     colorBuffer.clear();
/* 41 */     colorBuffer.put(p_74521_0_).put(p_74521_1_).put(p_74521_2_).put(p_74521_3_);
/* 42 */     colorBuffer.flip();
/* 43 */     return colorBuffer;
/*    */   }
/*    */   
/*    */   public void setCommonRenderParam(boolean smoothShading, int lighting) {
/* 47 */     if (smoothShading && MCH_Config.SmoothShading.prmBool) {
/* 48 */       GL11.glShadeModel(7425);
/*    */     }
/* 50 */     GL11.glAlphaFunc(516, 0.001F);
/* 51 */     GL11.glEnable(2884);
/* 52 */     int j = lighting % 65536;
/* 53 */     int k = lighting / 65536;
/* 54 */     OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, j / 1.0F, k / 1.0F);
/* 55 */     GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);
/* 56 */     GL11.glEnable(3042);
/* 57 */     this.srcBlend = GL11.glGetInteger(3041);
/* 58 */     this.dstBlend = GL11.glGetInteger(3040);
/* 59 */     GL11.glBlendFunc(770, 771);
/*    */   }
/*    */   
/*    */   public void restoreCommonRenderParam() {
/* 63 */     GL11.glBlendFunc(this.srcBlend, this.dstBlend);
/* 64 */     GL11.glDisable(3042);
/* 65 */     GL11.glShadeModel(7424);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_Render.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */