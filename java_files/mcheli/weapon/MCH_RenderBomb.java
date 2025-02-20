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
/*    */ public class MCH_RenderBomb
/*    */   extends MCH_RenderBulletBase {
/*    */   public MCH_RenderBomb() {
/* 14 */     this.field_76989_e = 0.5F;
/*    */   }
/*    */   
/*    */   public void renderBullet(Entity entity, double posX, double posY, double posZ, float yaw, float partialTickTime) {
/* 18 */     if (entity instanceof MCH_EntityBomb) {
/* 19 */       MCH_EntityBomb bomb = (MCH_EntityBomb)entity;
/* 20 */       if (bomb.getInfo() != null) {
/* 21 */         GL11.glPushMatrix();
/* 22 */         GL11.glTranslated(posX, posY, posZ);
/* 23 */         GL11.glRotatef(-entity.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 24 */         GL11.glRotatef(-entity.field_70125_A, -1.0F, 0.0F, 0.0F);
/* 25 */         if (bomb.isBomblet > 0 || (bomb.getInfo()).bomblet <= 0 || (bomb.getInfo()).bombletSTime > 0) {
/* 26 */           renderModel(bomb);
/*    */         }
/*    */         
/* 29 */         GL11.glPopMatrix();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 35 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_RenderBomb.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */