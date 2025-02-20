/*     */ package mcheli.weapon;
/*     */ 
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.particles.MCH_ParticleParam;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.wrapper.W_MovingObjectPosition;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_EntityMarkerRocket extends MCH_EntityBaseBullet {
/*     */   public int countDown;
/*     */   
/*     */   public MCH_EntityMarkerRocket(World par1World) {
/*  20 */     super(par1World);
/*  21 */     setMarkerStatus(0);
/*  22 */     this.countDown = 0;
/*     */   }
/*     */   
/*     */   public MCH_EntityMarkerRocket(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/*  26 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/*  27 */     setMarkerStatus(0);
/*  28 */     this.countDown = 0;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  32 */     super.func_70088_a();
/*  33 */     func_70096_w().func_75682_a(28, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public void setMarkerStatus(int n) {
/*  37 */     if (!this.field_70170_p.field_72995_K) {
/*  38 */       func_70096_w().func_75692_b(28, Byte.valueOf((byte)n));
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getMarkerStatus() {
/*  44 */     return func_70096_w().func_75683_a(28);
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/*  48 */     return false;
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  52 */     int status = getMarkerStatus();
/*  53 */     if (this.field_70170_p.field_72995_K) {
/*  54 */       if (getInfo() == null) {
/*  55 */         super.func_70071_h_();
/*     */       }
/*     */       
/*  58 */       if (getInfo() != null && !(getInfo()).disableSmoke && status != 0) {
/*  59 */         if (status == 1) {
/*  60 */           super.func_70071_h_();
/*  61 */           spawnParticle((getInfo()).trajectoryParticleName, 3, 5.0F * (getInfo()).smokeSize * 0.5F);
/*     */         } else {
/*  63 */           float num = this.field_70146_Z.nextFloat() * 0.3F;
/*  64 */           spawnParticle("explode", 5, (10 + this.field_70146_Z.nextInt(4)), this.field_70146_Z.nextFloat() * 0.2F + 0.8F, num, num, (this.field_70146_Z.nextFloat() - 0.5F) * 0.7F, 0.3F + this.field_70146_Z.nextFloat() * 0.3F, (this.field_70146_Z.nextFloat() - 0.5F) * 0.7F);
/*     */         } 
/*     */       }
/*  67 */     } else if (status != 0 && !func_70090_H()) {
/*  68 */       if (status == 1) {
/*  69 */         super.func_70071_h_();
/*  70 */       } else if (this.countDown > 0) {
/*  71 */         this.countDown--;
/*  72 */         if (this.countDown == 40) {
/*  73 */           int var5 = 6 + this.field_70146_Z.nextInt(2);
/*     */           
/*  75 */           for (int i = 0; i < var5; i++) {
/*  76 */             MCH_EntityBomb e = new MCH_EntityBomb(this.field_70170_p, this.field_70165_t + ((this.field_70146_Z.nextFloat() - 0.5F) * 15.0F), (260.0F + this.field_70146_Z.nextFloat() * 10.0F + (i * 30)), this.field_70161_v + ((this.field_70146_Z.nextFloat() - 0.5F) * 15.0F), 0.0D, -0.5D, 0.0D, 0.0F, 90.0F, 4.0D);
/*  77 */             e.setName(getName());
/*  78 */             e.explosionPower = 3 + this.field_70146_Z.nextInt(2);
/*  79 */             e.explosionPowerInWater = 0;
/*  80 */             e.setPower(30);
/*  81 */             e.piercing = 0;
/*  82 */             e.shootingAircraft = this.shootingAircraft;
/*  83 */             e.shootingEntity = this.shootingEntity;
/*  84 */             this.field_70170_p.func_72838_d((Entity)e);
/*     */           } 
/*     */         } 
/*     */       } else {
/*  88 */         func_70106_y();
/*     */       } 
/*     */     } else {
/*  91 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void spawnParticle(String name, int num, float size, float r, float g, float b, float mx, float my, float mz) {
/*  97 */     if (this.field_70170_p.field_72995_K) {
/*  98 */       if (name.isEmpty() || num < 1 || num > 50) {
/*     */         return;
/*     */       }
/*     */       
/* 102 */       double x = (this.field_70165_t - this.field_70169_q) / num;
/* 103 */       double y = (this.field_70163_u - this.field_70167_r) / num;
/* 104 */       double z = (this.field_70161_v - this.field_70166_s) / num;
/*     */       
/* 106 */       for (int i = 0; i < num; i++) {
/* 107 */         MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", this.field_70169_q + x * i, this.field_70167_r + y * i, this.field_70166_s + z * i);
/* 108 */         prm.motionX = mx;
/* 109 */         prm.motionY = my;
/* 110 */         prm.motionZ = mz;
/* 111 */         prm.size = size + this.field_70146_Z.nextFloat();
/* 112 */         prm.setColor(1.0F, r, g, b);
/* 113 */         prm.isEffectWind = true;
/* 114 */         MCH_ParticlesUtil.spawnParticle(prm);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onImpact(MovingObjectPosition m, float damageFactor) {
/* 121 */     if (!this.field_70170_p.field_72995_K && 
/* 122 */       m.field_72308_g == null && !W_MovingObjectPosition.isHitTypeEntity(m)) {
/* 123 */       int x = m.field_72311_b;
/* 124 */       int y = m.field_72312_c;
/* 125 */       int z = m.field_72309_d;
/* 126 */       switch (m.field_72310_e) {
/*     */         case 0:
/* 128 */           y--;
/*     */           break;
/*     */         case 1:
/* 131 */           y++;
/*     */           break;
/*     */         case 2:
/* 134 */           z--;
/*     */           break;
/*     */         case 3:
/* 137 */           z++;
/*     */           break;
/*     */         case 4:
/* 140 */           x--;
/*     */           break;
/*     */         case 5:
/* 143 */           x++;
/*     */           break;
/*     */       } 
/* 146 */       if (this.field_70170_p.func_147437_c(x, y, z)) {
/* 147 */         MCH_Config var10000 = MCH_MOD.config;
/* 148 */         if (MCH_Config.Explosion_FlamingBlock.prmBool) {
/* 149 */           W_WorldFunc.setBlock(this.field_70170_p, x, y, z, (Block)Blocks.field_150480_ab);
/*     */         }
/*     */         
/* 152 */         int noAirBlockCount = 0;
/*     */         
/* 154 */         int i = y + 1;
/*     */         
/* 156 */         noAirBlockCount++;
/* 157 */         for (; i < 256 && (this.field_70170_p.func_147437_c(x, i, z) || noAirBlockCount < 5); i++);
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 163 */         if (noAirBlockCount < 5) {
/* 164 */           setMarkerStatus(2);
/* 165 */           func_70107_b(x + 0.5D, y + 1.1D, z + 0.5D);
/* 166 */           this.field_70169_q = this.field_70165_t;
/* 167 */           this.field_70167_r = this.field_70163_u;
/* 168 */           this.field_70166_s = this.field_70161_v;
/* 169 */           this.countDown = 100;
/*     */         } else {
/* 171 */           func_70106_y();
/*     */         } 
/*     */       } else {
/* 174 */         func_70106_y();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public MCH_BulletModel getDefaultBulletModel() {
/* 182 */     return MCH_DefaultBulletModels.Rocket;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityMarkerRocket.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */