/*    */ package mcheli.wrapper;
/*    */ 
/*    */ import net.minecraft.client.audio.MovingSound;
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
/*    */ public class W_Sound
/*    */   extends MovingSound
/*    */ {
/*    */   protected W_Sound(ResourceLocation r, float volume, float pitch, double x, double y, double z) {
/* 19 */     super(r);
/* 20 */     setVolumeAndPitch(volume, pitch);
/* 21 */     setPosition(x, y, z);
/*    */   }
/*    */   
/*    */   protected W_Sound(ResourceLocation r, float volume, float pitch) {
/* 25 */     super(r);
/* 26 */     setVolumeAndPitch(volume, pitch);
/* 27 */     Entity entity = W_McClient.getRenderEntity();
/* 28 */     if (entity != null) {
/* 29 */       setPosition(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
/*    */     }
/*    */   }
/*    */   
/*    */   public void setRepeat(boolean b) {
/* 34 */     this.field_147659_g = b;
/*    */   }
/*    */   
/*    */   public void setSoundParam(Entity e, float v, float p) {
/* 38 */     setPosition(e);
/* 39 */     setVolumeAndPitch(v, p);
/*    */   }
/*    */   
/*    */   public void setVolumeAndPitch(float v, float p) {
/* 43 */     setVolume(v);
/* 44 */     setPitch(p);
/*    */   }
/*    */   
/*    */   public void setVolume(float v) {
/* 48 */     this.field_147662_b = v;
/*    */   }
/*    */   
/*    */   public void setPitch(float p) {
/* 52 */     this.field_147663_c = p;
/*    */   }
/*    */   
/*    */   public void setPosition(double x, double y, double z) {
/* 56 */     this.field_147660_d = (float)x;
/* 57 */     this.field_147661_e = (float)y;
/* 58 */     this.field_147658_f = (float)z;
/*    */   }
/*    */   
/*    */   public void setPosition(Entity e) {
/* 62 */     setPosition(e.field_70165_t, e.field_70163_u, e.field_70161_v);
/*    */   }
/*    */   
/*    */   public void func_73660_a() {}
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\wrapper\W_Sound.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */