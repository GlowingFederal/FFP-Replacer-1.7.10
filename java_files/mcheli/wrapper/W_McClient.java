/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.audio.ISound;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.EntityLivingBase;
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
/*    */ public class W_McClient
/*    */ {
/*    */   public static void DEF_playSoundFX(String name, float volume, float pitch) {
/* 23 */     Minecraft.func_71410_x().func_147118_V().func_147682_a((ISound)new W_Sound(new ResourceLocation(name), volume, pitch));
/*    */   }
/*    */   
/*    */   public static void MOD_playSoundFX(String name, float volume, float pitch) {
/* 27 */     DEF_playSoundFX(W_MOD.DOMAIN + ":" + name, volume, pitch);
/*    */   }
/*    */   
/*    */   public static void addSound(String name) {
/* 31 */     Minecraft mc = Minecraft.func_71410_x();
/*    */   }
/*    */   
/*    */   public static void DEF_bindTexture(String tex) {
/* 35 */     (Minecraft.func_71410_x()).field_71446_o.func_110577_a(new ResourceLocation(tex));
/*    */   }
/*    */   
/*    */   public static void MOD_bindTexture(String tex) {
/* 39 */     (Minecraft.func_71410_x()).field_71446_o.func_110577_a(new ResourceLocation(W_MOD.DOMAIN, tex));
/*    */   }
/*    */   
/*    */   public static boolean isGamePaused() {
/* 43 */     Minecraft mc = Minecraft.func_71410_x();
/* 44 */     return mc.func_147113_T();
/*    */   }
/*    */   
/*    */   public static Entity getRenderEntity() {
/* 48 */     return (Entity)(Minecraft.func_71410_x()).field_71451_h;
/*    */   }
/*    */   
/*    */   public static void setRenderEntity(EntityLivingBase entity) {
/* 52 */     (Minecraft.func_71410_x()).field_71451_h = entity;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_McClient.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */