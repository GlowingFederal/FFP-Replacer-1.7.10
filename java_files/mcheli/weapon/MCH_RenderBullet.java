/*    */ package mcheli.weapon;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderBullet
/*    */   extends MCH_RenderBulletBase {
/*    */   public void renderBullet(Entity entity, double posX, double posY, double posZ, float yaw, float tickTime) {
/* 14 */     MCH_EntityBaseBullet blt = (MCH_EntityBaseBullet)entity;
/* 15 */     GL11.glPushMatrix();
/* 16 */     double var10000 = entity.field_70169_q + entity.field_70159_w * tickTime;
/* 17 */     var10000 = entity.field_70167_r + entity.field_70181_x * tickTime;
/* 18 */     var10000 = entity.field_70166_s + entity.field_70179_y * tickTime;
/* 19 */     GL11.glTranslated(posX, posY, posZ);
/* 20 */     GL11.glRotatef(-entity.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 21 */     GL11.glRotatef(entity.field_70125_A, 1.0F, 0.0F, 0.0F);
/* 22 */     renderModel(blt);
/* 23 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 27 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_RenderBullet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */