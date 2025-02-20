/*    */ package mcheli.weapon;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.Vec3;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderAAMissile
/*    */   extends MCH_RenderBulletBase {
/*    */   public MCH_RenderAAMissile() {
/* 16 */     this.field_76989_e = 0.5F;
/*    */   }
/*    */   
/*    */   public void renderBullet(Entity entity, double posX, double posY, double posZ, float par8, float par9) {
/* 20 */     if (entity instanceof MCH_EntityAAMissile) {
/* 21 */       MCH_EntityAAMissile aam = (MCH_EntityAAMissile)entity;
/* 22 */       double mx = aam.prevMotionX + (aam.field_70159_w - aam.prevMotionX) * par9;
/* 23 */       double my = aam.prevMotionY + (aam.field_70181_x - aam.prevMotionY) * par9;
/* 24 */       double mz = aam.prevMotionZ + (aam.field_70179_y - aam.prevMotionZ) * par9;
/* 25 */       GL11.glPushMatrix();
/* 26 */       GL11.glTranslated(posX, posY, posZ);
/* 27 */       Vec3 v = MCH_Lib.getYawPitchFromVec(mx, my, mz);
/* 28 */       GL11.glRotatef((float)v.field_72448_b - 90.0F, 0.0F, -1.0F, 0.0F);
/* 29 */       GL11.glRotatef((float)v.field_72449_c, -1.0F, 0.0F, 0.0F);
/* 30 */       renderModel(aam);
/* 31 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 36 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_RenderAAMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */