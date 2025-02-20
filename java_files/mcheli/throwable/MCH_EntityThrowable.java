/*     */ package mcheli.throwable;
/*     */ 
/*     */ import mcheli.MCH_Explosion;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.particles.MCH_ParticleParam;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.projectile.EntityThrowable;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_EntityThrowable
/*     */   extends EntityThrowable
/*     */ {
/*     */   private static final int DATAID_NAME = 31;
/*     */   private int countOnUpdate;
/*     */   private MCH_ThrowableInfo throwableInfo;
/*     */   public double boundPosX;
/*     */   public double boundPosY;
/*     */   public double boundPosZ;
/*     */   public MovingObjectPosition lastOnImpact;
/*     */   public int noInfoCount;
/*     */   
/*     */   public MCH_EntityThrowable(World par1World) {
/*  30 */     super(par1World);
/*  31 */     init();
/*     */   }
/*     */   
/*     */   public MCH_EntityThrowable(World par1World, EntityLivingBase par2EntityLivingBase, float acceleration) {
/*  35 */     super(par1World, par2EntityLivingBase);
/*  36 */     this.field_70159_w *= acceleration;
/*  37 */     this.field_70181_x *= acceleration;
/*  38 */     this.field_70179_y *= acceleration;
/*  39 */     init();
/*     */   }
/*     */   
/*     */   public MCH_EntityThrowable(World par1World, double par2, double par4, double par6) {
/*  43 */     super(par1World, par2, par4, par6);
/*  44 */     init();
/*     */   }
/*     */   
/*     */   public MCH_EntityThrowable(World p_i1777_1_, double x, double y, double z, float yaw, float pitch) {
/*  48 */     this(p_i1777_1_);
/*  49 */     func_70105_a(0.25F, 0.25F);
/*  50 */     func_70012_b(x, y, z, yaw, pitch);
/*  51 */     this.field_70165_t -= (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/*  52 */     this.field_70163_u -= 0.10000000149011612D;
/*  53 */     this.field_70161_v -= (MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * 0.16F);
/*  54 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  55 */     this.field_70129_M = 0.0F;
/*  56 */     float f = 0.4F;
/*  57 */     this.field_70159_w = (-MathHelper.func_76126_a(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/*  58 */     this.field_70179_y = (MathHelper.func_76134_b(this.field_70177_z / 180.0F * 3.1415927F) * MathHelper.func_76134_b(this.field_70125_A / 180.0F * 3.1415927F) * f);
/*  59 */     this.field_70181_x = (-MathHelper.func_76126_a((this.field_70125_A + func_70183_g()) / 180.0F * 3.1415927F) * f);
/*  60 */     func_70186_c(this.field_70159_w, this.field_70181_x, this.field_70179_y, func_70182_d(), 1.0F);
/*     */   }
/*     */   
/*     */   public void init() {
/*  64 */     this.lastOnImpact = null;
/*  65 */     this.countOnUpdate = 0;
/*  66 */     setInfo((MCH_ThrowableInfo)null);
/*  67 */     this.noInfoCount = 0;
/*  68 */     func_70096_w().func_75682_a(31, new String(""));
/*     */   }
/*     */   
/*     */   public void func_70106_y() {
/*  72 */     String s = (getInfo() != null) ? (getInfo()).name : "null";
/*  73 */     MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityThrowable.setDead(%s)", new Object[] { s });
/*  74 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  78 */     this.boundPosX = this.field_70165_t;
/*  79 */     this.boundPosY = this.field_70163_u;
/*  80 */     this.boundPosZ = this.field_70161_v;
/*  81 */     if (getInfo() != null) {
/*  82 */       Block i = W_WorldFunc.getBlock(this.field_70170_p, (int)(this.field_70165_t + 0.5D), (int)this.field_70163_u, (int)(this.field_70161_v + 0.5D));
/*  83 */       Material y = W_WorldFunc.getBlockMaterial(this.field_70170_p, (int)(this.field_70165_t + 0.5D), (int)this.field_70163_u, (int)(this.field_70161_v + 0.5D));
/*  84 */       if (i != null && y == Material.field_151586_h) {
/*  85 */         this.field_70181_x += (getInfo()).gravityInWater;
/*     */       } else {
/*  87 */         this.field_70181_x += (getInfo()).gravity;
/*     */       } 
/*     */     } 
/*     */     
/*  91 */     super.func_70071_h_();
/*  92 */     if (this.lastOnImpact != null) {
/*  93 */       boundBullet(this.lastOnImpact);
/*  94 */       func_70107_b(this.boundPosX + this.field_70159_w, this.boundPosY + this.field_70181_x, this.boundPosZ + this.field_70179_y);
/*  95 */       this.lastOnImpact = null;
/*     */     } 
/*     */     
/*  98 */     this.countOnUpdate++;
/*  99 */     if (this.countOnUpdate >= 2147483632) {
/* 100 */       func_70106_y();
/*     */     } else {
/* 102 */       if (getInfo() == null) {
/* 103 */         String var6 = func_70096_w().func_75681_e(31);
/* 104 */         if (!var6.isEmpty()) {
/* 105 */           setInfo(MCH_ThrowableInfoManager.get(var6));
/*     */         }
/*     */         
/* 108 */         if (getInfo() == null) {
/* 109 */           this.noInfoCount++;
/* 110 */           if (this.noInfoCount > 10) {
/* 111 */             func_70106_y();
/*     */           }
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/*     */       
/* 118 */       if (!this.field_70128_L) {
/* 119 */         if (!this.field_70170_p.field_72995_K) {
/* 120 */           if (this.countOnUpdate == (getInfo()).timeFuse && (getInfo()).explosion > 0) {
/* 121 */             MCH_Explosion.newExplosion(this.field_70170_p, (Entity)null, (Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, (getInfo()).explosion, (getInfo()).explosion, true, true, false, true, 0);
/* 122 */             func_70106_y();
/*     */             
/*     */             return;
/*     */           } 
/* 126 */           if (this.countOnUpdate >= (getInfo()).aliveTime) {
/* 127 */             func_70106_y();
/*     */             return;
/*     */           } 
/* 130 */         } else if (this.countOnUpdate >= (getInfo()).timeFuse && (getInfo()).explosion <= 0) {
/* 131 */           for (int var7 = 0; var7 < (getInfo()).smokeNum; var7++) {
/* 132 */             float var8 = ((getInfo()).smokeVelocityVertical >= 0.0F) ? 0.2F : -0.2F;
/* 133 */             float r = (getInfo()).smokeColor.r * 0.9F + this.field_70146_Z.nextFloat() * 0.1F;
/* 134 */             float g = (getInfo()).smokeColor.g * 0.9F + this.field_70146_Z.nextFloat() * 0.1F;
/* 135 */             float b = (getInfo()).smokeColor.b * 0.9F + this.field_70146_Z.nextFloat() * 0.1F;
/* 136 */             if ((getInfo()).smokeColor.r == (getInfo()).smokeColor.g) {
/* 137 */               g = r;
/*     */             }
/*     */             
/* 140 */             if ((getInfo()).smokeColor.r == (getInfo()).smokeColor.b) {
/* 141 */               b = r;
/*     */             }
/*     */             
/* 144 */             if ((getInfo()).smokeColor.g == (getInfo()).smokeColor.b) {
/* 145 */               b = g;
/*     */             }
/*     */             
/* 148 */             spawnParticle("explode", 4, (getInfo()).smokeSize + this.field_70146_Z.nextFloat() * (getInfo()).smokeSize / 3.0F, r, g, b, (getInfo()).smokeVelocityHorizontal * (this.field_70146_Z.nextFloat() - 0.5F), (getInfo()).smokeVelocityVertical * this.field_70146_Z.nextFloat(), (getInfo()).smokeVelocityHorizontal * (this.field_70146_Z.nextFloat() - 0.5F));
/*     */           } 
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void spawnParticle(String name, int num, float size, float r, float g, float b, float mx, float my, float mz) {
/* 157 */     if (this.field_70170_p.field_72995_K) {
/* 158 */       if (name.isEmpty() || num < 1) {
/*     */         return;
/*     */       }
/*     */       
/* 162 */       double x = (this.field_70165_t - this.field_70169_q) / num;
/* 163 */       double y = (this.field_70163_u - this.field_70167_r) / num;
/* 164 */       double z = (this.field_70161_v - this.field_70166_s) / num;
/*     */       
/* 166 */       for (int i = 0; i < num; i++) {
/* 167 */         MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", this.field_70169_q + x * i, 1.0D + this.field_70167_r + y * i, this.field_70166_s + z * i);
/* 168 */         prm.setMotion(mx, my, mz);
/* 169 */         prm.size = size;
/* 170 */         prm.setColor(1.0F, r, g, b);
/* 171 */         prm.isEffectWind = true;
/* 172 */         prm.toWhite = true;
/* 173 */         MCH_ParticlesUtil.spawnParticle(prm);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected float func_70185_h() {
/* 180 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public void boundBullet(MovingObjectPosition m) {
/* 184 */     float bound = (getInfo()).bound;
/* 185 */     switch (m.field_72310_e) {
/*     */       case 0:
/*     */       case 1:
/* 188 */         this.field_70159_w *= 0.8999999761581421D;
/* 189 */         this.field_70179_y *= 0.8999999761581421D;
/* 190 */         this.boundPosY = m.field_72307_f.field_72448_b;
/* 191 */         if ((m.field_72310_e != 0 || this.field_70181_x <= 0.0D) && (m.field_72310_e != 1 || this.field_70181_x >= 0.0D)) {
/* 192 */           this.field_70181_x = 0.0D; break;
/*     */         } 
/* 194 */         this.field_70181_x = -this.field_70181_x * bound;
/*     */         break;
/*     */       
/*     */       case 2:
/* 198 */         if (this.field_70179_y > 0.0D) {
/* 199 */           this.field_70179_y = -this.field_70179_y * bound;
/*     */         }
/*     */         break;
/*     */       case 3:
/* 203 */         if (this.field_70179_y < 0.0D) {
/* 204 */           this.field_70179_y = -this.field_70179_y * bound;
/*     */         }
/*     */         break;
/*     */       case 4:
/* 208 */         if (this.field_70159_w > 0.0D) {
/* 209 */           this.field_70159_w = -this.field_70159_w * bound;
/*     */         }
/*     */         break;
/*     */       case 5:
/* 213 */         if (this.field_70159_w < 0.0D) {
/* 214 */           this.field_70159_w = -this.field_70159_w * bound;
/*     */         }
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_70184_a(MovingObjectPosition m) {
/* 221 */     if (getInfo() != null) {
/* 222 */       this.lastOnImpact = m;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public MCH_ThrowableInfo getInfo() {
/* 228 */     return this.throwableInfo;
/*     */   }
/*     */   
/*     */   public void setInfo(MCH_ThrowableInfo info) {
/* 232 */     this.throwableInfo = info;
/* 233 */     if (info != null && !this.field_70170_p.field_72995_K)
/* 234 */       func_70096_w().func_75692_b(31, new String(info.name)); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\throwable\MCH_EntityThrowable.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */