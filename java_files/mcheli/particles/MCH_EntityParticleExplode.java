/*    */ package mcheli.particles;
/*    */ 
/*    */ import net.minecraft.client.Minecraft;
/*    */ import net.minecraft.client.particle.EntityFX;
/*    */ import net.minecraft.client.renderer.RenderHelper;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.client.renderer.texture.TextureManager;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.world.World;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ public class MCH_EntityParticleExplode
/*    */   extends MCH_EntityParticleBase {
/* 14 */   private static final ResourceLocation texture = new ResourceLocation("textures/entity/explosion.png");
/*    */   
/*    */   private int nowCount;
/*    */   private int endCount;
/*    */   private TextureManager theRenderEngine;
/*    */   private float size;
/*    */   
/*    */   public MCH_EntityParticleExplode(World w, double x, double y, double z, double size, double age, double mz) {
/* 22 */     super(w, x, y, z, 0.0D, 0.0D, 0.0D);
/* 23 */     this.theRenderEngine = (Minecraft.func_71410_x()).field_71446_o;
/* 24 */     this.endCount = 1 + (int)age;
/* 25 */     this.size = (float)size;
/*    */   }
/*    */   
/*    */   public void func_70539_a(Tessellator tessellator, float p_70539_2_, float p_70539_3_, float p_70539_4_, float p_70539_5_, float p_70539_6_, float p_70539_7_) {
/* 29 */     int i = (int)((this.nowCount + p_70539_2_) * 15.0F / this.endCount);
/* 30 */     if (i <= 15) {
/* 31 */       GL11.glEnable(3042);
/* 32 */       int srcBlend = GL11.glGetInteger(3041);
/* 33 */       int dstBlend = GL11.glGetInteger(3040);
/* 34 */       GL11.glBlendFunc(770, 771);
/* 35 */       GL11.glDisable(2884);
/* 36 */       this.theRenderEngine.func_110577_a(texture);
/* 37 */       float f6 = (i % 4) / 4.0F;
/* 38 */       float f7 = f6 + 0.24975F;
/* 39 */       float f8 = (i / 4) / 4.0F;
/* 40 */       float f9 = f8 + 0.24975F;
/* 41 */       float f10 = 2.0F * this.size;
/* 42 */       float f11 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * p_70539_2_ - EntityFX.field_70556_an);
/* 43 */       float f12 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * p_70539_2_ - EntityFX.field_70554_ao);
/* 44 */       float f13 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * p_70539_2_ - EntityFX.field_70555_ap);
/* 45 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 46 */       RenderHelper.func_74518_a();
/* 47 */       tessellator.func_78382_b();
/* 48 */       tessellator.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
/* 49 */       tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 50 */       tessellator.func_78380_c(15728880);
/* 51 */       tessellator.func_78374_a((f11 - p_70539_3_ * f10 - p_70539_6_ * f10), (f12 - p_70539_4_ * f10), (f13 - p_70539_5_ * f10 - p_70539_7_ * f10), f7, f9);
/* 52 */       tessellator.func_78374_a((f11 - p_70539_3_ * f10 + p_70539_6_ * f10), (f12 + p_70539_4_ * f10), (f13 - p_70539_5_ * f10 + p_70539_7_ * f10), f7, f8);
/* 53 */       tessellator.func_78374_a((f11 + p_70539_3_ * f10 + p_70539_6_ * f10), (f12 + p_70539_4_ * f10), (f13 + p_70539_5_ * f10 + p_70539_7_ * f10), f6, f8);
/* 54 */       tessellator.func_78374_a((f11 + p_70539_3_ * f10 - p_70539_6_ * f10), (f12 - p_70539_4_ * f10), (f13 + p_70539_5_ * f10 - p_70539_7_ * f10), f6, f9);
/* 55 */       tessellator.func_78381_a();
/* 56 */       GL11.glPolygonOffset(0.0F, 0.0F);
/* 57 */       GL11.glEnable(2896);
/* 58 */       GL11.glEnable(2884);
/* 59 */       GL11.glBlendFunc(srcBlend, dstBlend);
/* 60 */       GL11.glDisable(3042);
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70070_b(float p_70070_1_) {
/* 66 */     return 15728880;
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 70 */     this.field_70169_q = this.field_70165_t;
/* 71 */     this.field_70167_r = this.field_70163_u;
/* 72 */     this.field_70166_s = this.field_70161_v;
/* 73 */     this.nowCount++;
/* 74 */     if (this.nowCount == this.endCount) {
/* 75 */       func_70106_y();
/*    */     }
/*    */   }
/*    */ 
/*    */   
/*    */   public int func_70537_b() {
/* 81 */     return 3;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\particles\MCH_EntityParticleExplode.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */