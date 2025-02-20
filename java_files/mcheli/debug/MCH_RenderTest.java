/*    */ package mcheli.debug;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderTest
/*    */   extends W_Render
/*    */ {
/*    */   protected MCH_ModelTest model;
/*    */   private float offsetX;
/*    */   private float offsetY;
/*    */   private float offsetZ;
/*    */   private String textureName;
/*    */   
/*    */   public MCH_RenderTest(float x, float y, float z, String texture_name) {
/* 23 */     this.offsetX = x;
/* 24 */     this.offsetY = y;
/* 25 */     this.offsetZ = z;
/* 26 */     this.textureName = texture_name;
/* 27 */     this.model = new MCH_ModelTest();
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity e, double posX, double posY, double posZ, float par8, float par9) {
/* 31 */     MCH_Config var10000 = MCH_MOD.config;
/* 32 */     if (MCH_Config.TestMode.prmBool) {
/* 33 */       float prevYaw; GL11.glPushMatrix();
/* 34 */       GL11.glTranslated(posX + this.offsetX, posY + this.offsetY, posZ + this.offsetZ);
/* 35 */       GL11.glScalef(e.field_70130_N, e.field_70131_O, e.field_70130_N);
/* 36 */       GL11.glColor4f(0.5F, 0.5F, 0.5F, 1.0F);
/*    */       
/* 38 */       if (e.field_70177_z - e.field_70126_B < -180.0F) {
/* 39 */         prevYaw = e.field_70126_B - 360.0F;
/* 40 */       } else if (e.field_70126_B - e.field_70177_z < -180.0F) {
/* 41 */         prevYaw = e.field_70126_B + 360.0F;
/*    */       } else {
/* 43 */         prevYaw = e.field_70126_B;
/*    */       } 
/*    */       
/* 46 */       float yaw = -(prevYaw + (e.field_70177_z - prevYaw) * par9) - 180.0F;
/* 47 */       float pitch = -(e.field_70127_C + (e.field_70125_A - e.field_70127_C) * par9);
/* 48 */       GL11.glRotatef(yaw, 0.0F, 1.0F, 0.0F);
/* 49 */       GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/* 50 */       bindTexture("textures/" + this.textureName + ".png");
/* 51 */       this.model.renderModel(0.0D, 0.0D, 0.1F);
/* 52 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 57 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\debug\MCH_RenderTest.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */