/*     */ package mcheli.flare;
/*     */ 
/*     */ import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import io.netty.buffer.ByteBuf;
/*     */ import mcheli.particles.MCH_ParticleParam;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_EntityFlare
/*     */   extends W_Entity implements IEntityAdditionalSpawnData {
/*     */   public double gravity;
/*     */   public double airResistance;
/*     */   public float size;
/*     */   public int fuseCount;
/*     */   
/*     */   public MCH_EntityFlare(World par1World) {
/*  26 */     super(par1World);
/*  27 */     this.gravity = -0.013D;
/*  28 */     this.airResistance = 0.992D;
/*  29 */     func_70105_a(1.0F, 1.0F);
/*  30 */     this.field_70126_B = this.field_70177_z;
/*  31 */     this.field_70127_C = this.field_70125_A;
/*  32 */     this.size = 6.0F;
/*  33 */     this.fuseCount = 0;
/*     */   }
/*     */   
/*     */   public MCH_EntityFlare(World par1World, double pX, double pY, double pZ, double mX, double mY, double mZ, float size, int fuseCount) {
/*  37 */     this(par1World);
/*  38 */     func_70012_b(pX, pY, pZ, 0.0F, 0.0F);
/*  39 */     this.field_70129_M = 0.0F;
/*  40 */     this.field_70159_w = mX;
/*  41 */     this.field_70181_x = mY;
/*  42 */     this.field_70179_y = mZ;
/*  43 */     this.size = size;
/*  44 */     this.fuseCount = fuseCount;
/*     */   }
/*     */   
/*     */   public boolean func_85032_ar() {
/*  48 */     return true;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double par1) {
/*  53 */     double d1 = this.field_70121_D.func_72320_b() * 4.0D;
/*  54 */     d1 *= 64.0D;
/*  55 */     return (par1 < d1 * d1);
/*     */   }
/*     */   
/*     */   public void func_70106_y() {
/*  59 */     super.func_70106_y();
/*  60 */     if (this.fuseCount > 0 && this.field_70170_p.field_72995_K) {
/*  61 */       this.fuseCount = 0;
/*  62 */       boolean num = true;
/*     */       
/*  64 */       for (int i = 0; i < 20; i++) {
/*  65 */         double x = (this.field_70146_Z.nextDouble() - 0.5D) * 10.0D;
/*  66 */         double y = (this.field_70146_Z.nextDouble() - 0.5D) * 10.0D;
/*  67 */         double z = (this.field_70146_Z.nextDouble() - 0.5D) * 10.0D;
/*  68 */         MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", this.field_70165_t + x, this.field_70163_u + y, this.field_70161_v + z);
/*  69 */         prm.age = 200 + this.field_70146_Z.nextInt(100);
/*  70 */         prm.size = (20 + this.field_70146_Z.nextInt(25));
/*  71 */         prm.motionX = (this.field_70146_Z.nextDouble() - 0.5D) * 0.45D;
/*  72 */         prm.motionY = (this.field_70146_Z.nextDouble() - 0.5D) * 0.01D;
/*  73 */         prm.motionZ = (this.field_70146_Z.nextDouble() - 0.5D) * 0.45D;
/*  74 */         prm.a = this.field_70146_Z.nextFloat() * 0.1F + 0.85F;
/*  75 */         prm.b = this.field_70146_Z.nextFloat() * 0.2F + 0.5F;
/*  76 */         prm.g = prm.b + 0.05F;
/*  77 */         prm.r = prm.b + 0.1F;
/*  78 */         MCH_ParticlesUtil.spawnParticle(prm);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void writeSpawnData(ByteBuf buffer) {
/*     */     try {
/*  86 */       buffer.writeByte(this.fuseCount);
/*  87 */     } catch (Exception var3) {
/*  88 */       var3.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void readSpawnData(ByteBuf additionalData) {
/*     */     try {
/*  95 */       this.fuseCount = additionalData.readByte();
/*  96 */     } catch (Exception var3) {
/*  97 */       var3.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70071_h_() {
/* 103 */     if (this.fuseCount > 0 && this.field_70173_aa >= this.fuseCount) {
/* 104 */       func_70106_y();
/* 105 */     } else if (!this.field_70170_p.field_72995_K && !this.field_70170_p.func_72899_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v)) {
/* 106 */       func_70106_y();
/* 107 */     } else if (this.field_70173_aa > 300 && !this.field_70170_p.field_72995_K) {
/* 108 */       func_70106_y();
/*     */     } else {
/* 110 */       super.func_70071_h_();
/* 111 */       if (!this.field_70170_p.field_72995_K) {
/* 112 */         onUpdateCollided();
/*     */       }
/*     */       
/* 115 */       this.field_70165_t += this.field_70159_w;
/* 116 */       this.field_70163_u += this.field_70181_x;
/* 117 */       this.field_70161_v += this.field_70179_y;
/* 118 */       if (this.field_70170_p.field_72995_K) {
/* 119 */         boolean num = true;
/* 120 */         double x = (this.field_70165_t - this.field_70169_q) / 2.0D;
/* 121 */         double y = (this.field_70163_u - this.field_70167_r) / 2.0D;
/* 122 */         double z = (this.field_70161_v - this.field_70166_s) / 2.0D;
/*     */         
/* 124 */         for (int i = 0; i < 2; i++) {
/* 125 */           MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", this.field_70169_q + x * i, this.field_70167_r + y * i, this.field_70166_s + z * i);
/* 126 */           prm.size = 6.0F + this.field_70146_Z.nextFloat();
/* 127 */           if (this.size < 5.0F) {
/* 128 */             prm.a = (float)(prm.a * 0.75D);
/* 129 */             if (this.field_70146_Z.nextInt(2) == 0) {
/*     */               continue;
/*     */             }
/*     */           } 
/*     */           
/* 134 */           if (this.fuseCount > 0) {
/* 135 */             prm.a = this.field_70146_Z.nextFloat() * 0.1F + 0.85F;
/* 136 */             prm.b = this.field_70146_Z.nextFloat() * 0.1F + 0.5F;
/* 137 */             prm.g = prm.b + 0.05F;
/* 138 */             prm.r = prm.b + 0.1F;
/*     */           } 
/*     */           
/* 141 */           MCH_ParticlesUtil.spawnParticle(prm);
/*     */           continue;
/*     */         } 
/*     */       } 
/* 145 */       this.field_70181_x += this.gravity;
/* 146 */       this.field_70159_w *= this.airResistance;
/* 147 */       this.field_70179_y *= this.airResistance;
/* 148 */       if (func_70090_H() && !this.field_70170_p.field_72995_K) {
/* 149 */         func_70106_y();
/*     */       }
/*     */       
/* 152 */       if (this.field_70122_E && !this.field_70170_p.field_72995_K) {
/* 153 */         func_70106_y();
/*     */       }
/*     */       
/* 156 */       func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdateCollided() {
/* 162 */     Vec3 vec3 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 163 */     Vec3 vec31 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 164 */     MovingObjectPosition mop = W_WorldFunc.clip(this.field_70170_p, vec3, vec31);
/* 165 */     vec3 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 166 */     vec31 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 167 */     if (mop != null) {
/* 168 */       W_WorldFunc.getWorldVec3(this.field_70170_p, mop.field_72307_f.field_72450_a, mop.field_72307_f.field_72448_b, mop.field_72307_f.field_72449_c);
/* 169 */       onImpact(mop);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onImpact(MovingObjectPosition par1MovingObjectPosition) {
/* 175 */     if (!this.field_70170_p.field_72995_K) {
/* 176 */       func_70106_y();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 182 */     par1NBTTagCompound.func_74782_a("direction", (NBTBase)func_70087_a(new double[] { this.field_70159_w, this.field_70181_x, this.field_70179_y }));
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 186 */     func_70106_y();
/*     */   }
/*     */   
/*     */   public boolean func_70067_L() {
/* 190 */     return true;
/*     */   }
/*     */   
/*     */   public float func_70111_Y() {
/* 194 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/* 198 */     return false;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 203 */     return 0.0F;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\flare\MCH_EntityFlare.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */