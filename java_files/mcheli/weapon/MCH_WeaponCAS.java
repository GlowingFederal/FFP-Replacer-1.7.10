/*     */ package mcheli.weapon;
/*     */ 
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.wrapper.W_MovingObjectPosition;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_WeaponCAS
/*     */   extends MCH_WeaponBase
/*     */ {
/*     */   private double targetPosX;
/*     */   private double targetPosY;
/*     */   private double targetPosZ;
/*     */   public int direction;
/*     */   private int startTick;
/*     */   private int cntAtk;
/*     */   private Entity shooter;
/*     */   public Entity user;
/*     */   
/*     */   public MCH_WeaponCAS(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/*  25 */     super(w, v, yaw, pitch, nm, wi);
/*  26 */     this.acceleration = 4.0F;
/*  27 */     this.explosionPower = 2;
/*  28 */     this.power = 32;
/*  29 */     this.interval = -300;
/*  30 */     if (w.field_72995_K) {
/*  31 */       this.interval -= 10;
/*     */     }
/*     */     
/*  34 */     this.targetPosX = 0.0D;
/*  35 */     this.targetPosY = 0.0D;
/*  36 */     this.targetPosZ = 0.0D;
/*  37 */     this.direction = 0;
/*  38 */     this.startTick = 0;
/*  39 */     this.cntAtk = 3;
/*  40 */     this.shooter = null;
/*  41 */     this.user = null;
/*     */   }
/*     */   
/*     */   public void update(int countWait) {
/*  45 */     super.update(countWait);
/*  46 */     if (!this.worldObj.field_72995_K && this.cntAtk < 3 && countWait != 0 && this.tick == this.startTick) {
/*  47 */       double x = 0.0D;
/*  48 */       double z = 0.0D;
/*  49 */       if (this.cntAtk >= 1) {
/*  50 */         double sign = (this.cntAtk == 1) ? 1.0D : -1.0D;
/*  51 */         if (this.direction == 0 || this.direction == 2) {
/*  52 */           x = MCH_WeaponBase.rand.nextDouble() * 10.0D * sign;
/*  53 */           z = (MCH_WeaponBase.rand.nextDouble() - 0.5D) * 10.0D;
/*     */         } 
/*     */         
/*  56 */         if (this.direction == 1 || this.direction == 3) {
/*  57 */           z = MCH_WeaponBase.rand.nextDouble() * 10.0D * sign;
/*  58 */           x = (MCH_WeaponBase.rand.nextDouble() - 0.5D) * 10.0D;
/*     */         } 
/*     */       } 
/*     */       
/*  62 */       spawnA10(this.targetPosX + x, this.targetPosY + 20.0D, this.targetPosZ + z);
/*  63 */       this.startTick = this.tick + 45;
/*  64 */       this.cntAtk++;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void modifyParameters() {
/*  70 */     if (this.interval > -250) {
/*  71 */       this.interval = -250;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setTargetPosition(double x, double y, double z) {
/*  77 */     this.targetPosX = x;
/*  78 */     this.targetPosY = y;
/*  79 */     this.targetPosZ = z;
/*     */   }
/*     */   
/*     */   public void spawnA10(double x, double y, double z) {
/*  83 */     double mX = 0.0D;
/*  84 */     double mY = 0.0D;
/*  85 */     double mZ = 0.0D;
/*  86 */     boolean SPEED = true;
/*  87 */     if (this.direction == 0) {
/*  88 */       mZ += 3.0D;
/*  89 */       z -= 90.0D;
/*     */     } 
/*     */     
/*  92 */     if (this.direction == 1) {
/*  93 */       mX -= 3.0D;
/*  94 */       x += 90.0D;
/*     */     } 
/*     */     
/*  97 */     if (this.direction == 2) {
/*  98 */       mZ -= 3.0D;
/*  99 */       z += 90.0D;
/*     */     } 
/*     */     
/* 102 */     if (this.direction == 3) {
/* 103 */       mX += 3.0D;
/* 104 */       x -= 90.0D;
/*     */     } 
/*     */     
/* 107 */     MCH_EntityA10 a10 = new MCH_EntityA10(this.worldObj, x, y, z);
/* 108 */     a10.setWeaponName(this.name);
/* 109 */     a10.field_70126_B = a10.field_70177_z = (90 * this.direction);
/* 110 */     a10.field_70159_w = mX;
/* 111 */     a10.field_70181_x = mY;
/* 112 */     a10.field_70179_y = mZ;
/* 113 */     a10.direction = this.direction;
/* 114 */     a10.shootingEntity = this.user;
/* 115 */     a10.shootingAircraft = this.shooter;
/* 116 */     a10.explosionPower = this.explosionPower;
/* 117 */     a10.power = this.power;
/* 118 */     a10.acceleration = this.acceleration;
/* 119 */     this.worldObj.func_72838_d((Entity)a10);
/* 120 */     W_WorldFunc.MOD_playSoundEffect(this.worldObj, x, y, z, "a-10_snd", 150.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public boolean shot(MCH_WeaponParam prm) {
/* 124 */     float yaw = prm.user.field_70177_z;
/* 125 */     float pitch = prm.user.field_70125_A;
/* 126 */     double tX = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 127 */     double tZ = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 128 */     double tY = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/* 129 */     double dist = MathHelper.func_76133_a(tX * tX + tY * tY + tZ * tZ);
/* 130 */     if (this.worldObj.field_72995_K) {
/* 131 */       tX = tX * 80.0D / dist;
/* 132 */       tY = tY * 80.0D / dist;
/* 133 */       tZ = tZ * 80.0D / dist;
/*     */     } else {
/* 135 */       tX = tX * 150.0D / dist;
/* 136 */       tY = tY * 150.0D / dist;
/* 137 */       tZ = tZ * 150.0D / dist;
/*     */     } 
/*     */     
/* 140 */     Vec3 src = W_WorldFunc.getWorldVec3(this.worldObj, prm.entity.field_70165_t, prm.entity.field_70163_u + 2.0D, prm.entity.field_70161_v);
/* 141 */     Vec3 dst = W_WorldFunc.getWorldVec3(this.worldObj, prm.entity.field_70165_t + tX, prm.entity.field_70163_u + tY + 2.0D, prm.entity.field_70161_v + tZ);
/* 142 */     MovingObjectPosition m = W_WorldFunc.clip(this.worldObj, src, dst);
/* 143 */     if (m != null && W_MovingObjectPosition.isHitTypeTile(m)) {
/* 144 */       this.targetPosX = m.field_72307_f.field_72450_a;
/* 145 */       this.targetPosY = m.field_72307_f.field_72448_b;
/* 146 */       this.targetPosZ = m.field_72307_f.field_72449_c;
/* 147 */       this.direction = (int)MCH_Lib.getRotate360((yaw + 45.0F)) / 90;
/* 148 */       this.direction += MCH_WeaponBase.rand.nextBoolean() ? -1 : 1;
/* 149 */       this.direction %= 4;
/* 150 */       if (this.direction < 0) {
/* 151 */         this.direction += 4;
/*     */       }
/*     */       
/* 154 */       this.user = prm.user;
/* 155 */       this.shooter = prm.entity;
/* 156 */       if (prm.entity != null) {
/* 157 */         playSoundClient(prm.entity, 1.0F, 1.0F);
/*     */       }
/*     */       
/* 160 */       this.startTick = 50;
/* 161 */       this.cntAtk = 0;
/* 162 */       return true;
/*     */     } 
/* 164 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean shot(Entity user, double px, double py, double pz, int option1, int option2) {
/* 169 */     float yaw = user.field_70177_z;
/* 170 */     float pitch = user.field_70125_A;
/* 171 */     double tX = (-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 172 */     double tZ = (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F));
/* 173 */     double tY = -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F);
/* 174 */     double dist = MathHelper.func_76133_a(tX * tX + tY * tY + tZ * tZ);
/* 175 */     if (this.worldObj.field_72995_K) {
/* 176 */       tX = tX * 80.0D / dist;
/* 177 */       tY = tY * 80.0D / dist;
/* 178 */       tZ = tZ * 80.0D / dist;
/*     */     } else {
/* 180 */       tX = tX * 120.0D / dist;
/* 181 */       tY = tY * 120.0D / dist;
/* 182 */       tZ = tZ * 120.0D / dist;
/*     */     } 
/*     */     
/* 185 */     Vec3 src = W_WorldFunc.getWorldVec3(this.worldObj, px, py, pz);
/* 186 */     Vec3 dst = W_WorldFunc.getWorldVec3(this.worldObj, px + tX, py + tY, pz + tZ);
/* 187 */     MovingObjectPosition m = W_WorldFunc.clip(this.worldObj, src, dst);
/* 188 */     if (W_MovingObjectPosition.isHitTypeTile(m)) {
/* 189 */       if (this.worldObj.field_72995_K) {
/* 190 */         double dx = m.field_72307_f.field_72450_a - px;
/* 191 */         double var10000 = m.field_72307_f.field_72448_b - py;
/* 192 */         double dz = m.field_72307_f.field_72449_c - pz;
/* 193 */         if (Math.sqrt(dx * dx + dz * dz) < 20.0D) {
/* 194 */           return false;
/*     */         }
/*     */       } 
/*     */       
/* 198 */       this.targetPosX = m.field_72307_f.field_72450_a;
/* 199 */       this.targetPosY = m.field_72307_f.field_72448_b;
/* 200 */       this.targetPosZ = m.field_72307_f.field_72449_c;
/* 201 */       this.direction = (int)MCH_Lib.getRotate360((yaw + 45.0F)) / 90;
/* 202 */       this.direction += MCH_WeaponBase.rand.nextBoolean() ? -1 : 1;
/* 203 */       this.direction %= 4;
/* 204 */       if (this.direction < 0) {
/* 205 */         this.direction += 4;
/*     */       }
/*     */       
/* 208 */       this.user = user;
/* 209 */       this.shooter = null;
/* 210 */       this.tick = 0;
/* 211 */       this.startTick = 50;
/* 212 */       this.cntAtk = 0;
/* 213 */       return true;
/*     */     } 
/* 215 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponCAS.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */