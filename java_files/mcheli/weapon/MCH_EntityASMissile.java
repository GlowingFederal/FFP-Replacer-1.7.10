/*     */ package mcheli.weapon;
/*     */ 
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_EntityASMissile
/*     */   extends MCH_EntityBaseBullet
/*     */ {
/*     */   public double targetPosX;
/*     */   public double targetPosY;
/*     */   public double targetPosZ;
/*     */   
/*     */   public MCH_EntityASMissile(World par1World) {
/*  20 */     super(par1World);
/*  21 */     this.targetPosX = 0.0D;
/*  22 */     this.targetPosY = 0.0D;
/*  23 */     this.targetPosZ = 0.0D;
/*     */   }
/*     */   
/*     */   public float getGravity() {
/*  27 */     return (getBomblet() == 1) ? -0.03F : super.getGravity();
/*     */   }
/*     */   
/*     */   public float getGravityInWater() {
/*  31 */     return (getBomblet() == 1) ? -0.03F : super.getGravityInWater();
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/*  35 */     super.func_70071_h_();
/*  36 */     if (getInfo() != null && !(getInfo()).disableSmoke && getBomblet() == 0) {
/*  37 */       spawnParticle((getInfo()).trajectoryParticleName, 3, 10.0F * (getInfo()).smokeSize * 0.5F);
/*     */     }
/*     */     
/*  40 */     if (getInfo() != null && !this.field_70170_p.field_72995_K && this.isBomblet != 1) {
/*  41 */       Block a = W_WorldFunc.getBlock(this.field_70170_p, (int)this.targetPosX, (int)this.targetPosY, (int)this.targetPosZ);
/*  42 */       if (a != null && a.func_149703_v()) {
/*  43 */         double dist = func_70011_f(this.targetPosX, this.targetPosY, this.targetPosZ);
/*  44 */         if (dist < (getInfo()).proximityFuseDist) {
/*  45 */           if ((getInfo()).bomblet > 0) {
/*  46 */             for (int x = 0; x < (getInfo()).bomblet; x++) {
/*  47 */               sprinkleBomblet();
/*     */             }
/*     */           } else {
/*  50 */             MovingObjectPosition var15 = new MovingObjectPosition((Entity)this);
/*  51 */             onImpact(var15, 1.0F);
/*     */           } 
/*     */           
/*  54 */           func_70106_y();
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*     */         }
/*  60 */         else if (getGravity() == 0.0D) {
/*  61 */           double var16 = 0.0D;
/*  62 */           if (getCountOnUpdate() < 10) {
/*  63 */             var16 = 20.0D;
/*     */           }
/*     */           
/*  66 */           double y = this.targetPosX - this.field_70165_t;
/*  67 */           double z = this.targetPosY + var16 - this.field_70163_u;
/*  68 */           double d = this.targetPosZ - this.field_70161_v;
/*  69 */           double d1 = MathHelper.func_76133_a(y * y + z * z + d * d);
/*  70 */           this.field_70159_w = y * this.acceleration / d1;
/*  71 */           this.field_70181_x = z * this.acceleration / d1;
/*  72 */           this.field_70179_y = d * this.acceleration / d1;
/*     */         } else {
/*  74 */           double var16 = this.targetPosX - this.field_70165_t;
/*  75 */           double y = this.targetPosY - this.field_70163_u;
/*  76 */           y *= 0.3D;
/*  77 */           double z = this.targetPosZ - this.field_70161_v;
/*  78 */           double d = MathHelper.func_76133_a(var16 * var16 + y * y + z * z);
/*  79 */           this.field_70159_w = var16 * this.acceleration / d;
/*  80 */           this.field_70179_y = z * this.acceleration / d;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  86 */     double var14 = (float)Math.atan2(this.field_70179_y, this.field_70159_w);
/*  87 */     this.field_70177_z = (float)(var14 * 180.0D / Math.PI) - 90.0F;
/*  88 */     double r = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*  89 */     this.field_70125_A = -((float)(Math.atan2(this.field_70181_x, r) * 180.0D / Math.PI));
/*  90 */     onUpdateBomblet();
/*     */   }
/*     */   
/*     */   public void sprinkleBomblet() {
/*  94 */     if (!this.field_70170_p.field_72995_K) {
/*  95 */       MCH_EntityASMissile e = new MCH_EntityASMissile(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, this.field_70159_w, this.field_70181_x, this.field_70179_y, this.field_70146_Z.nextInt(360), 0.0F, this.acceleration);
/*  96 */       e.setParameterFromWeapon(this, this.shootingAircraft, this.shootingEntity);
/*  97 */       e.setName(getName());
/*  98 */       float MOTION = 0.5F;
/*  99 */       float RANDOM = (getInfo()).bombletDiff;
/* 100 */       e.field_70159_w = this.field_70159_w * 0.5D + ((this.field_70146_Z.nextFloat() - 0.5F) * RANDOM);
/* 101 */       e.field_70181_x = this.field_70181_x * 0.5D / 2.0D + ((this.field_70146_Z.nextFloat() - 0.5F) * RANDOM / 2.0F);
/* 102 */       e.field_70179_y = this.field_70179_y * 0.5D + ((this.field_70146_Z.nextFloat() - 0.5F) * RANDOM);
/* 103 */       e.setBomblet();
/* 104 */       this.field_70170_p.func_72838_d((Entity)e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MCH_EntityASMissile(World par1World, double posX, double posY, double posZ, double targetX, double targetY, double targetZ, float yaw, float pitch, double acceleration) {
/* 110 */     super(par1World, posX, posY, posZ, targetX, targetY, targetZ, yaw, pitch, acceleration);
/*     */   }
/*     */   
/*     */   public MCH_BulletModel getDefaultBulletModel() {
/* 114 */     return MCH_DefaultBulletModels.ASMissile;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityASMissile.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */