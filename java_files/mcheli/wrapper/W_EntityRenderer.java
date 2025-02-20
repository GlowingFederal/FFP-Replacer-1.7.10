/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import com.google.gson.JsonSyntaxException;
/*    */ import java.io.IOException;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_Lib;
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.renderer.ItemRenderer;
/*    */ import net.minecraft.client.renderer.OpenGlHelper;
/*    */ import net.minecraft.client.renderer.entity.RenderManager;
/*    */ import net.minecraft.client.shader.ShaderGroup;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ 
/*    */ public class W_EntityRenderer
/*    */ {
/*    */   public static void setItemRenderer(Minecraft mc, ItemRenderer ir) {
/* 35 */     W_Reflection.setItemRenderer(ir);
/*    */   }
/*    */   
/*    */   public static boolean isShaderSupport() {
/* 39 */     return (OpenGlHelper.field_148824_g && !MCH_Config.DisableShader.prmBool);
/*    */   }
/*    */   
/*    */   public static void activateShader(String n) {
/* 43 */     activateShader(new ResourceLocation("mcheli", "shaders/post/" + n + ".json"));
/*    */   }
/*    */   
/*    */   public static void activateShader(ResourceLocation r) {
/* 47 */     Minecraft mc = Minecraft.func_71410_x();
/*    */     try {
/* 49 */       mc.field_71460_t.field_147707_d = new ShaderGroup(mc.func_110434_K(), mc.func_110442_L(), mc.func_147110_a(), r);
/* 50 */       mc.field_71460_t.field_147707_d.func_148026_a(mc.field_71443_c, mc.field_71440_d);
/*    */     }
/* 52 */     catch (IOException ioexception) {
/* 53 */       ioexception.printStackTrace();
/*    */     }
/* 55 */     catch (JsonSyntaxException jsonsyntaxexception) {
/* 56 */       MCH_Lib.Log("Failed to load shader: " + r, new Object[0]);
/* 57 */       jsonsyntaxexception.printStackTrace();
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void deactivateShader() {
/* 62 */     (Minecraft.func_71410_x()).field_71460_t.func_147703_b();
/*    */   }
/*    */   
/*    */   public static void renderEntityWithPosYaw(RenderManager rm, Entity par1Entity, double par2, double par4, double par6, float par8, float par9, boolean b) {
/* 66 */     rm.func_147939_a(par1Entity, par2, par4, par6, par8, par9, b);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_EntityRenderer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */