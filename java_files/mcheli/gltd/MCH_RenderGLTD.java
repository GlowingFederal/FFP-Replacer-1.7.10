/*    */ package mcheli.gltd;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import mcheli.MCH_RenderLib;
/*    */ import mcheli.wrapper.W_Lib;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.Vec3;
/*    */ import net.minecraftforge.client.model.IModelCustom;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderGLTD
/*    */   extends W_Render
/*    */ {
/* 20 */   public static final Random rand = new Random();
/*    */   
/*    */   public static IModelCustom model;
/*    */   
/*    */   public MCH_RenderGLTD() {
/* 25 */     this.field_76989_e = 0.5F;
/* 26 */     model = null;
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double posX, double posY, double posZ, float par8, float tickTime) {
/* 30 */     if (entity instanceof MCH_EntityGLTD) {
/* 31 */       MCH_EntityGLTD gltd = (MCH_EntityGLTD)entity;
/* 32 */       GL11.glPushMatrix();
/* 33 */       GL11.glTranslated(posX, posY, posZ);
/* 34 */       setCommonRenderParam(true, entity.func_70070_b(tickTime));
/* 35 */       bindTexture("textures/gltd.png");
/* 36 */       Minecraft mc = Minecraft.func_71410_x();
/* 37 */       boolean isNotRenderHead = false;
/* 38 */       if (gltd.field_70153_n != null) {
/* 39 */         gltd.isUsedPlayer = true;
/* 40 */         gltd.renderRotaionYaw = gltd.field_70153_n.field_70177_z;
/* 41 */         gltd.renderRotaionPitch = gltd.field_70153_n.field_70125_A;
/* 42 */         isNotRenderHead = (mc.field_71474_y.field_74320_O == 0 && W_Lib.isClientPlayer(gltd.field_70153_n));
/*    */       } 
/*    */       
/* 45 */       if (gltd.isUsedPlayer) {
/* 46 */         GL11.glPushMatrix();
/* 47 */         GL11.glRotatef(-gltd.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 48 */         model.renderPart("$body");
/* 49 */         GL11.glPopMatrix();
/*    */       } else {
/* 51 */         GL11.glRotatef(-gltd.field_70177_z, 0.0F, 1.0F, 0.0F);
/* 52 */         model.renderPart("$body");
/*    */       } 
/*    */       
/* 55 */       GL11.glTranslatef(0.0F, 0.45F, 0.0F);
/* 56 */       if (gltd.isUsedPlayer) {
/* 57 */         GL11.glRotatef(gltd.renderRotaionYaw, 0.0F, -1.0F, 0.0F);
/* 58 */         GL11.glRotatef(gltd.renderRotaionPitch, 1.0F, 0.0F, 0.0F);
/*    */       } 
/*    */       
/* 61 */       GL11.glTranslatef(0.0F, -0.45F, 0.0F);
/* 62 */       if (!isNotRenderHead) {
/* 63 */         model.renderPart("$head");
/*    */       }
/*    */       
/* 66 */       GL11.glTranslatef(0.0F, 0.45F, 0.0F);
/* 67 */       restoreCommonRenderParam();
/* 68 */       GL11.glDisable(2896);
/* 69 */       Vec3[] v = { Vec3.func_72443_a(0.0D, 0.2D, 0.0D), Vec3.func_72443_a(0.0D, 0.2D, 100.0D) };
/* 70 */       int a = rand.nextInt(64);
/* 71 */       MCH_RenderLib.drawLine(v, 0x6080FF80 | a << 24);
/* 72 */       GL11.glEnable(2896);
/* 73 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 78 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gltd\MCH_RenderGLTD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */