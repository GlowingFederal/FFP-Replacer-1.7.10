/*    */ package mcheli.uav;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.MCH_ModelManager;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderUavStation
/*    */   extends W_Render
/*    */ {
/* 16 */   public static final String[] MODEL_NAME = new String[] { "uav_station", "uav_portable_controller" };
/* 17 */   public static final String[] TEX_NAME_ON = new String[] { "uav_station_on", "uav_portable_controller_on" };
/* 18 */   public static final String[] TEX_NAME_OFF = new String[] { "uav_station", "uav_portable_controller" };
/*    */ 
/*    */   
/*    */   public MCH_RenderUavStation() {
/* 22 */     this.field_76989_e = 1.0F;
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double posX, double posY, double posZ, float par8, float tickTime) {
/* 26 */     if (entity instanceof MCH_EntityUavStation) {
/* 27 */       MCH_EntityUavStation uavSt = (MCH_EntityUavStation)entity;
/* 28 */       if (uavSt.getKind() > 0) {
/* 29 */         int kind = uavSt.getKind() - 1;
/* 30 */         GL11.glPushMatrix();
/* 31 */         GL11.glTranslated(posX, posY, posZ);
/* 32 */         GL11.glEnable(2884);
/* 33 */         GL11.glRotatef(entity.field_70177_z, 0.0F, -1.0F, 0.0F);
/* 34 */         GL11.glRotatef(entity.field_70125_A, 1.0F, 0.0F, 0.0F);
/* 35 */         GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);
/* 36 */         GL11.glEnable(3042);
/* 37 */         int srcBlend = GL11.glGetInteger(3041);
/* 38 */         int dstBlend = GL11.glGetInteger(3040);
/* 39 */         GL11.glBlendFunc(770, 771);
/* 40 */         if (kind == 0) {
/* 41 */           if (uavSt.getControlAircract() != null && uavSt.field_70153_n != null) {
/* 42 */             bindTexture("textures/" + TEX_NAME_ON[kind] + ".png");
/*    */           } else {
/* 44 */             bindTexture("textures/" + TEX_NAME_OFF[kind] + ".png");
/*    */           } 
/*    */           
/* 47 */           MCH_ModelManager.render(MODEL_NAME[kind]);
/*    */         } else {
/* 49 */           if (uavSt.rotCover > 0.95F) {
/* 50 */             bindTexture("textures/" + TEX_NAME_ON[kind] + ".png");
/*    */           } else {
/* 52 */             bindTexture("textures/" + TEX_NAME_OFF[kind] + ".png");
/*    */           } 
/*    */           
/* 55 */           renderPortableController(uavSt, MODEL_NAME[kind], tickTime);
/*    */         } 
/*    */         
/* 58 */         GL11.glBlendFunc(srcBlend, dstBlend);
/* 59 */         GL11.glDisable(3042);
/* 60 */         GL11.glPopMatrix();
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void renderPortableController(MCH_EntityUavStation uavSt, String name, float tickTime) {
/* 66 */     MCH_ModelManager.renderPart(name, "$body");
/* 67 */     float rot = MCH_Lib.smooth(uavSt.rotCover, uavSt.prevRotCover, tickTime);
/* 68 */     renderRotPart(name, "$cover", rot * 60.0F, 0.0D, -0.1812D, -0.3186D);
/* 69 */     renderRotPart(name, "$laptop_cover", rot * 95.0F, 0.0D, -0.1808D, -0.0422D);
/* 70 */     renderRotPart(name, "$display", rot * -85.0F, 0.0D, -0.1807D, 0.2294D);
/*    */   }
/*    */   
/*    */   private void renderRotPart(String modelName, String partName, float rot, double x, double y, double z) {
/* 74 */     GL11.glPushMatrix();
/* 75 */     GL11.glTranslated(x, y, z);
/* 76 */     GL11.glRotatef(rot, -1.0F, 0.0F, 0.0F);
/* 77 */     GL11.glTranslated(-x, -y, -z);
/* 78 */     MCH_ModelManager.renderPart(modelName, partName);
/* 79 */     GL11.glPopMatrix();
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 83 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mchel\\uav\MCH_RenderUavStation.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */