/*    */ package mcheli.weapon;
/*    */ 
/*    */ import mcheli.MCH_Color;
/*    */ import mcheli.wrapper.W_Block;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import mcheli.wrapper.W_WorldFunc;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.entity.Entity;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public abstract class MCH_RenderBulletBase
/*    */   extends W_Render
/*    */ {
/*    */   public void func_76986_a(Entity e, double var2, double var4, double var6, float var8, float var9) {
/* 15 */     if (e instanceof MCH_EntityBaseBullet && ((MCH_EntityBaseBullet)e).getInfo() != null) {
/* 16 */       MCH_Color srcBlend = (((MCH_EntityBaseBullet)e).getInfo()).color;
/*    */       
/* 18 */       for (int i = 0; i < 3; i++) {
/* 19 */         Block b = W_WorldFunc.getBlock(e.field_70170_p, (int)(e.field_70165_t + 0.5D), (int)(e.field_70163_u + 1.5D - i), (int)(e.field_70161_v + 0.5D));
/* 20 */         if (b != null && b == W_Block.getWater()) {
/* 21 */           srcBlend = (((MCH_EntityBaseBullet)e).getInfo()).colorInWater;
/*    */           
/*    */           break;
/*    */         } 
/*    */       } 
/* 26 */       GL11.glColor4f(srcBlend.r, srcBlend.g, srcBlend.b, srcBlend.a);
/*    */     } else {
/* 28 */       GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);
/*    */     } 
/*    */     
/* 31 */     GL11.glAlphaFunc(516, 0.001F);
/* 32 */     GL11.glEnable(2884);
/* 33 */     GL11.glEnable(3042);
/* 34 */     int var13 = GL11.glGetInteger(3041);
/* 35 */     int dstBlend = GL11.glGetInteger(3040);
/* 36 */     GL11.glBlendFunc(770, 771);
/* 37 */     renderBullet(e, var2, var4, var6, var8, var9);
/* 38 */     GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);
/* 39 */     GL11.glBlendFunc(var13, dstBlend);
/* 40 */     GL11.glDisable(3042);
/*    */   }
/*    */   
/*    */   public void renderModel(MCH_EntityBaseBullet e) {
/* 44 */     MCH_BulletModel model = e.getBulletModel();
/* 45 */     if (model != null) {
/* 46 */       bindTexture("textures/bullets/" + model.name + ".png");
/* 47 */       model.model.renderAll();
/*    */     } 
/*    */   }
/*    */   
/*    */   public abstract void renderBullet(Entity paramEntity, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2);
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_RenderBulletBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */