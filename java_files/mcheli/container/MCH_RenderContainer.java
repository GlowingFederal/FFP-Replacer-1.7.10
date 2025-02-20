/*    */ package mcheli.container;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import java.util.Random;
/*    */ import mcheli.MCH_Lib;
/*    */ import mcheli.MCH_ModelManager;
/*    */ import mcheli.aircraft.MCH_RenderAircraft;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderContainer
/*    */   extends W_Render
/*    */ {
/* 18 */   public static final Random rand = new Random();
/*    */ 
/*    */   
/*    */   public MCH_RenderContainer() {
/* 22 */     this.field_76989_e = 0.5F;
/*    */   }
/*    */   
/*    */   public void func_76986_a(Entity entity, double posX, double posY, double posZ, float par8, float tickTime) {
/* 26 */     if (!MCH_RenderAircraft.shouldSkipRender(entity)) {
/* 27 */       GL11.glPushMatrix();
/* 28 */       GL11.glEnable(2884);
/* 29 */       GL11.glTranslated(posX, posY - 0.2D, posZ);
/* 30 */       float yaw = MCH_Lib.smoothRot(entity.field_70177_z, entity.field_70126_B, tickTime);
/* 31 */       float pitch = MCH_Lib.smoothRot(entity.field_70125_A, entity.field_70127_C, tickTime);
/* 32 */       GL11.glRotatef(yaw, 0.0F, -1.0F, 0.0F);
/* 33 */       GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/* 34 */       GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);
/* 35 */       bindTexture("textures/container.png");
/* 36 */       MCH_ModelManager.render("container");
/* 37 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 42 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\container\MCH_RenderContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */