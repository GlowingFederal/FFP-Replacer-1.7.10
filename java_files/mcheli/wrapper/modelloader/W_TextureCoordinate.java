/*    */ package mcheli.wrapper.modelloader;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ 
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class W_TextureCoordinate
/*    */ {
/*    */   public float u;
/*    */   public float v;
/*    */   public float w;
/*    */   
/*    */   public W_TextureCoordinate(float u, float v) {
/* 15 */     this(u, v, 0.0F);
/*    */   }
/*    */   
/*    */   public W_TextureCoordinate(float u, float v, float w) {
/* 19 */     this.u = u;
/* 20 */     this.v = v;
/* 21 */     this.w = w;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\modelloader\W_TextureCoordinate.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */