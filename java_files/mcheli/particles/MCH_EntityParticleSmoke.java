/*     */ package mcheli.particles;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import net.minecraft.client.particle.EntityFX;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_EntityParticleSmoke
/*     */   extends MCH_EntityParticleBase {
/*     */   public MCH_EntityParticleSmoke(World par1World, double x, double y, double z, double mx, double my, double mz) {
/*  17 */     super(par1World, x, y, z, mx, my, mz);
/*  18 */     this.field_70552_h = this.field_70553_i = this.field_70551_j = this.field_70146_Z.nextFloat() * 0.3F + 0.7F;
/*  19 */     setParticleScale(this.field_70146_Z.nextFloat() * 0.5F + 5.0F);
/*  20 */     setParticleMaxAge((int)(16.0D / (this.field_70146_Z.nextFloat() * 0.8D + 0.2D)) + 2);
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  24 */     this.field_70169_q = this.field_70165_t;
/*  25 */     this.field_70167_r = this.field_70163_u;
/*  26 */     this.field_70166_s = this.field_70161_v;
/*  27 */     if (this.field_70546_d < this.field_70547_e) {
/*  28 */       func_70536_a((int)(8.0D * this.field_70546_d / this.field_70547_e));
/*  29 */       this.field_70546_d++;
/*  30 */       if (this.diffusible && this.field_70544_f < this.particleMaxScale) {
/*  31 */         this.field_70544_f += 0.8F;
/*     */       }
/*     */       
/*  34 */       if (this.toWhite) {
/*  35 */         float mn = getMinColor();
/*  36 */         float mx = getMaxColor();
/*  37 */         float dist = mx - mn;
/*  38 */         if (dist > 0.2D) {
/*  39 */           this.field_70552_h += (mx - this.field_70552_h) * 0.016F;
/*  40 */           this.field_70553_i += (mx - this.field_70553_i) * 0.016F;
/*  41 */           this.field_70551_j += (mx - this.field_70551_j) * 0.016F;
/*     */         } 
/*     */       } 
/*     */       
/*  45 */       effectWind();
/*  46 */       if (this.field_70546_d / this.field_70547_e > this.moutionYUpAge) {
/*  47 */         this.field_70181_x += 0.02D;
/*     */       } else {
/*  49 */         this.field_70181_x += this.gravity;
/*     */       } 
/*     */       
/*  52 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*  53 */       if (this.diffusible) {
/*  54 */         this.field_70159_w *= 0.96D;
/*  55 */         this.field_70179_y *= 0.96D;
/*  56 */         this.field_70181_x *= 0.96D;
/*     */       } else {
/*  58 */         this.field_70159_w *= 0.9D;
/*  59 */         this.field_70179_y *= 0.9D;
/*     */       } 
/*     */     } else {
/*     */       
/*  63 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */   
/*     */   public float getMinColor() {
/*  68 */     return min(min(this.field_70551_j, this.field_70553_i), this.field_70552_h);
/*     */   }
/*     */   
/*     */   public float getMaxColor() {
/*  72 */     return max(max(this.field_70551_j, this.field_70553_i), this.field_70552_h);
/*     */   }
/*     */   
/*     */   public float min(float a, float b) {
/*  76 */     return (a < b) ? a : b;
/*     */   }
/*     */   
/*     */   public float max(float a, float b) {
/*  80 */     return (a > b) ? a : b;
/*     */   }
/*     */   
/*     */   public void effectWind() {
/*  84 */     if (this.isEffectedWind) {
/*  85 */       boolean range = true;
/*  86 */       List<MCH_EntityAircraft> list = this.field_70170_p.func_72872_a(MCH_EntityAircraft.class, func_70046_E().func_72314_b(15.0D, 15.0D, 15.0D));
/*     */       
/*  88 */       for (int i = 0; i < list.size(); i++) {
/*  89 */         MCH_EntityAircraft ac = list.get(i);
/*  90 */         if (ac.getThrottle() > 0.10000000149011612D) {
/*  91 */           float dist = func_70032_d((Entity)ac);
/*  92 */           double vel = (23.0D - dist) * 0.009999999776482582D * ac.getThrottle();
/*  93 */           double mx = ac.field_70165_t - this.field_70165_t;
/*  94 */           double mz = ac.field_70161_v - this.field_70161_v;
/*  95 */           this.field_70159_w -= mx * vel;
/*  96 */           this.field_70179_y -= mz * vel;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int func_70537_b() {
/* 104 */     return 3;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70070_b(float p_70070_1_) {
/* 109 */     double y = this.field_70163_u;
/* 110 */     this.field_70163_u += 3000.0D;
/* 111 */     int i = super.func_70070_b(p_70070_1_);
/* 112 */     this.field_70163_u = y;
/* 113 */     return i;
/*     */   }
/*     */   
/*     */   public void func_70539_a(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
/* 117 */     GL11.glPushMatrix();
/* 118 */     W_McClient.MOD_bindTexture("textures/particles/smoke.png");
/* 119 */     GL11.glEnable(3042);
/* 120 */     int srcBlend = GL11.glGetInteger(3041);
/* 121 */     int dstBlend = GL11.glGetInteger(3040);
/* 122 */     GL11.glBlendFunc(770, 771);
/* 123 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 124 */     GL11.glDisable(2884);
/* 125 */     float f6 = this.field_94054_b / 8.0F;
/* 126 */     float f7 = f6 + 0.125F;
/* 127 */     float f8 = 0.0F;
/* 128 */     float f9 = 1.0F;
/* 129 */     float f10 = 0.1F * this.field_70544_f;
/* 130 */     float f11 = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * par2 - EntityFX.field_70556_an);
/* 131 */     float f12 = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * par2 - EntityFX.field_70554_ao);
/* 132 */     float f13 = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * par2 - EntityFX.field_70555_ap);
/* 133 */     par1Tessellator.func_78382_b();
/* 134 */     par1Tessellator.func_78369_a(this.field_70552_h, this.field_70553_i, this.field_70551_j, this.field_82339_as);
/* 135 */     par1Tessellator.func_78380_c(func_70070_b(par2));
/* 136 */     par1Tessellator.func_78375_b(0.0F, 1.0F, 0.0F);
/* 137 */     par1Tessellator.func_78374_a((f11 - par3 * f10 - par6 * f10), (f12 - par4 * f10), (f13 - par5 * f10 - par7 * f10), f7, f9);
/* 138 */     par1Tessellator.func_78374_a((f11 - par3 * f10 + par6 * f10), (f12 + par4 * f10), (f13 - par5 * f10 + par7 * f10), f7, f8);
/* 139 */     par1Tessellator.func_78374_a((f11 + par3 * f10 + par6 * f10), (f12 + par4 * f10), (f13 + par5 * f10 + par7 * f10), f6, f8);
/* 140 */     par1Tessellator.func_78374_a((f11 + par3 * f10 - par6 * f10), (f12 - par4 * f10), (f13 + par5 * f10 - par7 * f10), f6, f9);
/* 141 */     par1Tessellator.func_78381_a();
/* 142 */     GL11.glEnable(2884);
/* 143 */     GL11.glBlendFunc(srcBlend, dstBlend);
/* 144 */     GL11.glDisable(3042);
/* 145 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\particles\MCH_EntityParticleSmoke.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */