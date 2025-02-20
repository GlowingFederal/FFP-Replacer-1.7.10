/*    */ package mcheli.parachute;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.MCH_ModelManager;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderParachute
/*    */   extends W_Render
/*    */ {
/* 18 */   public static final Random rand = new Random();
/*    */ 
/*    */   
/*    */   public MCH_RenderParachute() {
/* 22 */     this.field_76989_e = 0.5F;
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double posX, double posY, double posZ, float par8, float tickTime) {
/* 26 */     if (entity instanceof MCH_EntityParachute) {
/* 27 */       MCH_EntityParachute parachute = (MCH_EntityParachute)entity;
/* 28 */       int type = parachute.getType();
/* 29 */       if (type > 0) {
/* 30 */         GL11.glPushMatrix();
/* 31 */         GL11.glEnable(2884);
/* 32 */         GL11.glTranslated(posX, posY, posZ);
/* 33 */         float prevYaw = entity.field_70126_B;
/* 34 */         if (entity.field_70177_z - prevYaw < -180.0F) {
/* 35 */           prevYaw -= 360.0F;
/* 36 */         } else if (prevYaw - entity.field_70177_z < -180.0F) {
/* 37 */           prevYaw += 360.0F;
/*    */         } 
/*    */         
/* 40 */         float yaw = prevYaw + (entity.field_70177_z - prevYaw) * tickTime;
/* 41 */         GL11.glRotatef(yaw, 0.0F, -1.0F, 0.0F);
/* 42 */         GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);
/* 43 */         GL11.glEnable(3042);
/* 44 */         int srcBlend = GL11.glGetInteger(3041);
/* 45 */         int dstBlend = GL11.glGetInteger(3040);
/* 46 */         GL11.glBlendFunc(770, 771);
/* 47 */         MCH_Config var10000 = MCH_MOD.config;
/* 48 */         if (MCH_Config.SmoothShading.prmBool) {
/* 49 */           GL11.glShadeModel(7425);
/*    */         }
/*    */         
/* 52 */         switch (type) {
/*    */           case 1:
/* 54 */             bindTexture("textures/parachute1.png");
/* 55 */             MCH_ModelManager.render("parachute1");
/*    */             break;
/*    */           case 2:
/* 58 */             bindTexture("textures/parachute2.png");
/* 59 */             if (parachute.isOpenParachute()) {
/* 60 */               MCH_ModelManager.renderPart("parachute2", "$parachute"); break;
/*    */             } 
/* 62 */             MCH_ModelManager.renderPart("parachute2", "$seat");
/*    */             break;
/*    */           
/*    */           case 3:
/* 66 */             bindTexture("textures/parachute2.png");
/* 67 */             MCH_ModelManager.renderPart("parachute2", "$parachute");
/*    */             break;
/*    */         } 
/* 70 */         GL11.glBlendFunc(srcBlend, dstBlend);
/* 71 */         GL11.glDisable(3042);
/* 72 */         GL11.glShadeModel(7424);
/* 73 */         GL11.glPopMatrix();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 79 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\parachute\MCH_RenderParachute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */