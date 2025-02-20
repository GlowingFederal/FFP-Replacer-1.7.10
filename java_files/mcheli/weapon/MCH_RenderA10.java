/*    */ package mcheli.weapon;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.MCH_ModelManager;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderA10
/*    */   extends MCH_RenderBulletBase {
/*    */   public MCH_RenderA10() {
/* 15 */     this.field_76989_e = 10.5F;
/*    */   }
/*    */   
/*    */   public void renderBullet(Entity e, double posX, double posY, double posZ, float par8, float tickTime) {
/* 19 */     if (e instanceof MCH_EntityA10 && (
/* 20 */       (MCH_EntityA10)e).isRender()) {
/* 21 */       GL11.glPushMatrix();
/* 22 */       GL11.glTranslated(posX, posY, posZ);
/* 23 */       float yaw = -(e.field_70126_B + (e.field_70177_z - e.field_70126_B) * tickTime);
/* 24 */       float pitch = -(e.field_70127_C + (e.field_70125_A - e.field_70127_C) * tickTime);
/* 25 */       GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
/* 26 */       GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/* 27 */       bindTexture("textures/bullets/a10.png");
/* 28 */       MCH_ModelManager.render("a-10");
/* 29 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 35 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_RenderA10.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */