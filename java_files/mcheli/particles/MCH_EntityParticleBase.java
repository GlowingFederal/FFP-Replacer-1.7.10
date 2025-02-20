/*     */ package mcheli.particles;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mcheli.wrapper.W_EntityFX;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public abstract class MCH_EntityParticleBase
/*     */   extends W_EntityFX
/*     */ {
/*     */   public boolean isEffectedWind;
/*     */   public boolean diffusible;
/*     */   public boolean toWhite;
/*     */   public float particleMaxScale;
/*     */   public float gravity;
/*     */   public float moutionYUpAge;
/*     */   
/*     */   public MCH_EntityParticleBase(World par1World, double x, double y, double z, double mx, double my, double mz) {
/*  29 */     super(par1World, x, y, z, mx, my, mz);
/*  30 */     this.field_70159_w = mx;
/*  31 */     this.field_70181_x = my;
/*  32 */     this.field_70179_y = mz;
/*  33 */     this.isEffectedWind = false;
/*  34 */     this.particleMaxScale = this.field_70544_f;
/*     */   }
/*     */   
/*     */   public MCH_EntityParticleBase setParticleScale(float scale) {
/*  38 */     this.field_70544_f = scale;
/*  39 */     return this;
/*     */   }
/*     */   
/*     */   public void setParticleMaxAge(int age) {
/*  43 */     this.field_70547_e = age;
/*     */   }
/*     */   
/*     */   public void func_70536_a(int par1) {
/*  47 */     this.field_94054_b = par1 % 8;
/*  48 */     this.field_94055_c = par1 / 8;
/*     */   }
/*     */   
/*     */   public int func_70537_b() {
/*  52 */     return 2;
/*     */   }
/*     */   
/*     */   public void func_70091_d(double par1, double par3, double par5) {
/*  56 */     if (this.field_70145_X) {
/*  57 */       this.field_70121_D.func_72317_d(par1, par3, par5);
/*  58 */       this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
/*  59 */       this.field_70163_u = this.field_70121_D.field_72338_b + this.field_70129_M - this.field_70139_V;
/*  60 */       this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
/*     */     } else {
/*  62 */       this.field_70170_p.field_72984_F.func_76320_a("move");
/*  63 */       this.field_70139_V *= 0.4F;
/*  64 */       double d3 = this.field_70165_t;
/*  65 */       double d4 = this.field_70163_u;
/*  66 */       double d5 = this.field_70161_v;
/*  67 */       double d6 = par1;
/*  68 */       double d7 = par3;
/*  69 */       double d8 = par5;
/*  70 */       AxisAlignedBB axisalignedbb = this.field_70121_D.func_72329_c();
/*  71 */       boolean flag = false;
/*  72 */       List<AxisAlignedBB> list = this.field_70170_p.func_72945_a((Entity)this, this.field_70121_D.func_72321_a(par1, par3, par5));
/*     */       
/*  74 */       for (int flag1 = 0; flag1 < list.size(); flag1++) {
/*  75 */         par3 = ((AxisAlignedBB)list.get(flag1)).func_72323_b(this.field_70121_D, par3);
/*     */       }
/*     */       
/*  78 */       this.field_70121_D.func_72317_d(0.0D, par3, 0.0D);
/*  79 */       if (!this.field_70135_K && d7 != par3) {
/*  80 */         par5 = 0.0D;
/*  81 */         par3 = 0.0D;
/*  82 */         par1 = 0.0D;
/*     */       } 
/*     */ 
/*     */       
/*  86 */       if (!this.field_70122_E && (d7 == par3 || d7 >= 0.0D)) {
/*  87 */         boolean var10000 = false;
/*     */       } else {
/*  89 */         boolean var10000 = true;
/*     */       } 
/*     */       
/*     */       int j;
/*  93 */       for (j = 0; j < list.size(); j++) {
/*  94 */         par1 = ((AxisAlignedBB)list.get(j)).func_72316_a(this.field_70121_D, par1);
/*     */       }
/*     */       
/*  97 */       this.field_70121_D.func_72317_d(par1, 0.0D, 0.0D);
/*  98 */       if (!this.field_70135_K && d6 != par1) {
/*  99 */         par5 = 0.0D;
/* 100 */         par3 = 0.0D;
/* 101 */         par1 = 0.0D;
/*     */       } 
/*     */       
/* 104 */       for (j = 0; j < list.size(); j++) {
/* 105 */         par5 = ((AxisAlignedBB)list.get(j)).func_72322_c(this.field_70121_D, par5);
/*     */       }
/*     */       
/* 108 */       this.field_70121_D.func_72317_d(0.0D, 0.0D, par5);
/* 109 */       if (!this.field_70135_K && d8 != par5) {
/* 110 */         par5 = 0.0D;
/* 111 */         par3 = 0.0D;
/* 112 */         par1 = 0.0D;
/*     */       } 
/*     */       
/* 115 */       this.field_70170_p.field_72984_F.func_76319_b();
/* 116 */       this.field_70170_p.field_72984_F.func_76320_a("rest");
/* 117 */       this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
/* 118 */       this.field_70163_u = this.field_70121_D.field_72338_b + this.field_70129_M - this.field_70139_V;
/* 119 */       this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
/* 120 */       this.field_70123_F = (d6 != par1 || d8 != par5);
/* 121 */       this.field_70124_G = (d7 != par3);
/* 122 */       this.field_70122_E = (d7 != par3 && d7 < 0.0D);
/* 123 */       this.field_70132_H = (this.field_70123_F || this.field_70124_G);
/* 124 */       func_70064_a(par3, this.field_70122_E);
/* 125 */       if (d6 != par1) {
/* 126 */         this.field_70159_w = 0.0D;
/*     */       }
/*     */       
/* 129 */       if (d7 != par3) {
/* 130 */         this.field_70181_x = 0.0D;
/*     */       }
/*     */       
/* 133 */       if (d8 != par5) {
/* 134 */         this.field_70179_y = 0.0D;
/*     */       }
/*     */       
/* 137 */       double var35 = this.field_70165_t - d3;
/* 138 */       var35 = this.field_70163_u - d4;
/* 139 */       var35 = this.field_70161_v - d5;
/*     */       
/*     */       try {
/* 142 */         doBlockCollisions();
/* 143 */       } catch (Throwable var34) {
/* 144 */         CrashReport crashreport = CrashReport.func_85055_a(var34, "Checking entity block collision");
/* 145 */         CrashReportCategory crashreportcategory = crashreport.func_85058_a("Entity being checked for collision");
/* 146 */         func_85029_a(crashreportcategory);
/* 147 */         throw new ReportedException(crashreport);
/*     */       } 
/*     */       
/* 150 */       this.field_70170_p.field_72984_F.func_76319_b();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List getCollidingBoundingBoxes(Entity par1Entity, AxisAlignedBB par2AxisAlignedBB) {
/* 156 */     ArrayList collidingBoundingBoxes = new ArrayList();
/* 157 */     int i = MathHelper.func_76128_c(par2AxisAlignedBB.field_72340_a);
/* 158 */     int j = MathHelper.func_76128_c(par2AxisAlignedBB.field_72336_d + 1.0D);
/* 159 */     int k = MathHelper.func_76128_c(par2AxisAlignedBB.field_72338_b);
/* 160 */     int l = MathHelper.func_76128_c(par2AxisAlignedBB.field_72337_e + 1.0D);
/* 161 */     int i1 = MathHelper.func_76128_c(par2AxisAlignedBB.field_72339_c);
/* 162 */     int j1 = MathHelper.func_76128_c(par2AxisAlignedBB.field_72334_f + 1.0D);
/*     */     
/* 164 */     for (int k1 = i; k1 < j; k1++) {
/* 165 */       for (int l1 = i1; l1 < j1; l1++) {
/* 166 */         if (this.field_70170_p.func_72899_e(k1, 64, l1)) {
/* 167 */           for (int i2 = k - 1; i2 < l; i2++) {
/*     */             Block block;
/* 169 */             if (k1 >= -30000000 && k1 < 30000000 && l1 >= -30000000 && l1 < 30000000) {
/* 170 */               block = W_WorldFunc.getBlock(this.field_70170_p, k1, i2, l1);
/*     */             } else {
/* 172 */               block = Blocks.field_150348_b;
/*     */             } 
/*     */             
/* 175 */             block.func_149743_a(this.field_70170_p, k1, i2, l1, par2AxisAlignedBB, collidingBoundingBoxes, par1Entity);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 181 */     return collidingBoundingBoxes;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\particles\MCH_EntityParticleBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */