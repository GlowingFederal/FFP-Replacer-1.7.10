/*    */ package mcheli.particles;
/*    */ 
/*    */ import mcheli.wrapper.W_Block;
/*    */ import mcheli.wrapper.W_McClient;
/*    */ import mcheli.wrapper.W_WorldFunc;
/*    */ import net.minecraft.block.Block;
/*    */ import net.minecraft.client.particle.EntityFX;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.world.World;
/*    */ 
/*    */ public class MCH_EntityParticleSplash
/*    */   extends MCH_EntityParticleBase {
/*    */   public MCH_EntityParticleSplash(World par1World, double x, double y, double z, double mx, double my, double mz) {
/* 14 */     super(par1World, x, y, z, mx, my, mz);
/* 15 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = this.field_70146_Z.nextFloat() * 0.3F + 0.7F;
/* 16 */     setParticleScale(this.field_70146_Z.nextFloat() * 0.5F + 5.0F);
/* 17 */     setParticleMaxAge((int)(80.0D / (this.field_70146_Z.nextFloat() * 0.8D + 0.2D)) + 2);
/*    */   }
/*    */   
/*    */   public void func_70071_h_() {
/* 21 */     this.field_70169_q = this.field_70165_t;
/* 22 */     this.field_70167_r = this.field_70163_u;
/* 23 */     this.field_70166_s = this.field_70161_v;
/* 24 */     if (this.field_70546_d < this.field_70547_e) {
/* 25 */       func_70536_a((int)(8.0D * this.field_70546_d / this.field_70547_e));
/* 26 */       this.field_70546_d++;
/*    */     } else {
/* 28 */       func_70106_y();
/*    */     } 
/*    */     
/* 31 */     this.field_70181_x -= 0.05999999865889549D;
/* 32 */     Block block = W_WorldFunc.getBlock(this.field_70170_p, (int)(this.field_70165_t + 0.5D), (int)(this.field_70163_u + 0.5D), (int)(this.field_70161_v + 0.5D));
/* 33 */     boolean beforeInWater = W_Block.func_149680_a(block, W_Block.getWater());
/* 34 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 35 */     block = W_WorldFunc.getBlock(this.field_70170_p, (int)(this.field_70165_t + 0.5D), (int)(this.field_70163_u + 0.5D), (int)(this.field_70161_v + 0.5D));
/* 36 */     boolean nowInWater = W_Block.func_149680_a(block, W_Block.getWater());
/* 37 */     if (this.field_70181_x < -0.6D && !beforeInWater && nowInWater) {
/* 38 */       double p = -this.field_70181_x * 10.0D;
/*    */       
/* 40 */       for (int i = 0; i < p; i++) {
/* 41 */         this.field_70170_p.func_72869_a("splash", this.field_70165_t + 0.5D + (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, this.field_70163_u + this.field_70146_Z.nextDouble(), this.field_70161_v + 0.5D + (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, 4.0D, (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D);
/* 42 */         this.field_70170_p.func_72869_a("bubble", this.field_70165_t + 0.5D + (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, this.field_70163_u - this.field_70146_Z.nextDouble(), this.field_70161_v + 0.5D + (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, -0.5D, (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D);
/*    */       } 
/* 44 */     } else if (this.field_70122_E) {
/* 45 */       func_70106_y();
/*    */     } 
/*    */     
/* 48 */     this.field_70159_w *= 0.9D;
/* 49 */     this.field_70179_y *= 0.9D;
/*    */   }
/*    */   
/*    */   public void func_70539_a(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
/* 53 */     W_McClient.MOD_bindTexture("textures/particles/smoke.png");
/* 54 */     float f6 = this.field_94054_b / 8.0F;
/* 55 */     float f7 = f6 + 0.125F;
/* 56 */     float f8 = 0.0F;
/* 57 */     float f9 = 1.0F;
/* 58 */     float f10 = 0.1F * this.field_70544_f;
/* 59 */     float f11 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * par2 - EntityFX.field_70556_an);
/* 60 */     float f12 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * par2 - EntityFX.field_70554_ao);
/* 61 */     float f13 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * par2 - EntityFX.field_70555_ap);
/* 62 */     float f14 = 1.0F;
/* 63 */     par1Tessellator.func_78369_a(this.field_70552_h * f14, this.field_70553_i * f14, this.field_70551_j * f14, this.field_82339_as);
/* 64 */     par1Tessellator.func_78374_a((f11 - par3 * f10 - par6 * f10), (f12 - par4 * f10), (f13 - par5 * f10 - par7 * f10), f7, f9);
/* 65 */     par1Tessellator.func_78374_a((f11 - par3 * f10 + par6 * f10), (f12 + par4 * f10), (f13 - par5 * f10 + par7 * f10), f7, f8);
/* 66 */     par1Tessellator.func_78374_a((f11 + par3 * f10 + par6 * f10), (f12 + par4 * f10), (f13 + par5 * f10 + par7 * f10), f6, f8);
/* 67 */     par1Tessellator.func_78374_a((f11 + par3 * f10 - par6 * f10), (f12 - par4 * f10), (f13 + par5 * f10 - par7 * f10), f6, f9);
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\particles\MCH_EntityParticleSplash.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */