/*    */ package mcheli.particles;
/*    */ 
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ 
/*    */ public class MCH_ParticleParam
/*    */ {
/*    */   public final World world;
/*    */   public final String name;
/*    */   public double posX;
/*    */   public double posY;
/*    */   public double posZ;
/*    */   public double motionX;
/*    */   public double motionY;
/*    */   public double motionZ;
/*    */   public float size;
/*    */   public float a;
/*    */   public float r;
/*    */   public float g;
/*    */   public float b;
/*    */   public boolean isEffectWind;
/*    */   public int age;
/*    */   public boolean diffusible;
/*    */   public boolean toWhite;
/*    */   public float gravity;
/*    */   public float motionYUpAge;
/*    */   
/*    */   public MCH_ParticleParam(World w, String name, double x, double y, double z) {
/* 29 */     this.motionX = 0.0D;
/* 30 */     this.motionY = 0.0D;
/* 31 */     this.motionZ = 0.0D;
/* 32 */     this.size = 1.0F;
/* 33 */     this.a = 1.0F;
/* 34 */     this.r = 1.0F;
/* 35 */     this.g = 1.0F;
/* 36 */     this.b = 1.0F;
/* 37 */     this.isEffectWind = false;
/* 38 */     this.age = 0;
/* 39 */     this.diffusible = false;
/* 40 */     this.toWhite = false;
/* 41 */     this.gravity = 0.0F;
/* 42 */     this.motionYUpAge = 2.0F;
/* 43 */     this.world = w;
/* 44 */     this.name = name;
/* 45 */     this.posX = x;
/* 46 */     this.posY = y;
/* 47 */     this.posZ = z;
/*    */   }
/*    */   
/*    */   public MCH_ParticleParam(World w, String name, double x, double y, double z, double mx, double my, double mz, float size) {
/* 51 */     this(w, name, x, y, z);
/* 52 */     this.motionX = mx;
/* 53 */     this.motionY = my;
/* 54 */     this.motionZ = mz;
/* 55 */     this.size = size;
/*    */   }
/*    */   
/*    */   public void setColor(float a, float r, float g, float b) {
/* 59 */     this.a = a;
/* 60 */     this.r = r;
/* 61 */     this.g = g;
/* 62 */     this.b = b;
/*    */   }
/*    */   
/*    */   public void setMotion(double x, double y, double z) {
/* 66 */     this.motionX = x;
/* 67 */     this.motionY = y;
/* 68 */     this.motionZ = z;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\particles\MCH_ParticleParam.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */