/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.client.audio.ISound;
/*    */ import net.minecraft.client.audio.SoundManager;
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
/*    */ public class W_SoundManagerFunc
/*    */ {
/*    */   public static void DEF_playEntitySound(SoundManager sm, String name, Entity entity, float volume, float pitch, boolean par5) {
/* 19 */     sm.func_148611_c((ISound)new W_Sound(new ResourceLocation(name), volume, pitch, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v));
/*    */   }
/*    */   
/*    */   public static void MOD_playEntitySound(SoundManager sm, String name, Entity entity, float volume, float pitch, boolean par5) {
/* 23 */     DEF_playEntitySound(sm, W_MOD.DOMAIN + ":" + name, entity, volume, pitch, par5);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_SoundManagerFunc.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */