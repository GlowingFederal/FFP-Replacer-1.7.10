/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
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
/*    */ public class W_TextureUtil
/*    */ {
/* 18 */   private static W_TextureUtil instance = new W_TextureUtil();
/*    */ 
/*    */ 
/*    */ 
/*    */   
/*    */   private TextureParam newParam() {
/* 24 */     return new TextureParam();
/*    */   }
/*    */   
/*    */   public static TextureParam getTextureInfo(String domain, String name) {
/* 28 */     TextureManager textureManager = Minecraft.func_71410_x().func_110434_K();
/* 29 */     ResourceLocation r = new ResourceLocation(domain, name);
/* 30 */     textureManager.func_110577_a(r);
/* 31 */     TextureParam info = instance.newParam();
/* 32 */     info.width = GL11.glGetTexLevelParameteri(3553, 0, 4096);
/* 33 */     info.height = GL11.glGetTexLevelParameteri(3553, 0, 4097);
/* 34 */     return info;
/*    */   }
/*    */   
/*    */   public class TextureParam {
/*    */     public int width;
/*    */     public int height;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_TextureUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */