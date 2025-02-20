/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.audio.ISound;
/*    */ import net.minecraft.client.audio.SoundHandler;
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
/*    */ public class W_SoundUpdater
/*    */ {
/*    */   protected final SoundHandler theSoundHnadler;
/*    */   protected W_Sound es;
/*    */   
/*    */   public W_SoundUpdater(Minecraft minecraft, Entity entity) {
/* 25 */     this.theSoundHnadler = minecraft.func_147118_V();
/*    */   }
/*    */   
/*    */   public void initEntitySound(String name) {
/* 29 */     this.es = new W_Sound(new ResourceLocation("mcheli", name), 1.0F, 1.0F);
/* 30 */     this.es.setRepeat(true);
/*    */   }
/*    */   
/*    */   public boolean isValidSound() {
/* 34 */     return (this.es != null);
/*    */   }
/*    */   
/*    */   public void playEntitySound(String name, Entity entity, float volume, float pitch, boolean par5) {
/* 38 */     if (isValidSound()) {
/* 39 */       this.es.setSoundParam(entity, volume, pitch);
/* 40 */       this.theSoundHnadler.func_147682_a((ISound)this.es);
/*    */     } 
/*    */   }
/*    */   
/*    */   public void stopEntitySound(Entity entity) {
/* 45 */     if (isValidSound()) {
/* 46 */       this.theSoundHnadler.func_147683_b((ISound)this.es);
/*    */     }
/*    */   }
/*    */   
/*    */   public boolean isEntitySoundPlaying(Entity entity) {
/* 51 */     return isValidSound() ? this.theSoundHnadler.func_147692_c((ISound)this.es) : false;
/*    */   }
/*    */   
/*    */   public void setEntitySoundPitch(Entity entity, float pitch) {
/* 55 */     if (isValidSound()) {
/* 56 */       this.es.setPitch(pitch);
/*    */     }
/*    */   }
/*    */   
/*    */   public void setEntitySoundVolume(Entity entity, float volume) {
/* 61 */     if (isValidSound()) {
/* 62 */       this.es.setVolume(volume);
/*    */     }
/*    */   }
/*    */   
/*    */   public void updateSoundLocation(Entity entity) {
/* 67 */     if (isValidSound()) {
/* 68 */       this.es.setPosition(entity);
/*    */     }
/*    */   }
/*    */   
/*    */   public void updateSoundLocation(double x, double y, double z) {
/* 73 */     if (isValidSound()) {
/* 74 */       this.es.setPosition(x, y, z);
/*    */     }
/*    */   }
/*    */   
/*    */   public void _updateSoundLocation(Entity entityListener, Entity entity) {
/* 79 */     if (isValidSound())
/* 80 */       this.es.setPosition(entity); 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_SoundUpdater.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */