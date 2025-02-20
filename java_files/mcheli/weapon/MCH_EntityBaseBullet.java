/*     */ package mcheli.weapon;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Explosion;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_PacketNotifyHitBullet;
/*     */ import mcheli.particles.MCH_ParticleParam;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_EntityPlayer;
/*     */ import mcheli.wrapper.W_MovingObjectPosition;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTBase;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import net.minecraftforge.common.ForgeChunkManager;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MCH_EntityBaseBullet
/*     */   extends W_Entity
/*     */ {
/*     */   public static final int DATAWT_RESERVE1 = 26;
/*     */   public static final int DATAWT_TARGET_ENTITY = 27;
/*     */   public static final int DATAWT_MARKER_STAT = 28;
/*     */   public static final int DATAWT_NAME = 29;
/*     */   public static final int DATAWT_BULLET_MODEL = 30;
/*     */   public static final int DATAWT_BOMBLET_FLAG = 31;
/*     */   public Entity shootingEntity;
/*     */   public Entity shootingAircraft;
/*     */   private int countOnUpdate;
/*     */   public int explosionPower;
/*     */   public int explosionPowerInWater;
/*     */   private int power;
/*     */   public double acceleration;
/*     */   public double accelerationFactor;
/*     */   public Entity targetEntity;
/*     */   
/*     */   public MCH_EntityBaseBullet(World par1World) {
/*  64 */     super(par1World);
/*  65 */     this.countOnUpdate = 0;
/*  66 */     func_70105_a(1.0F, 1.0F);
/*  67 */     this.field_70126_B = this.field_70177_z;
/*  68 */     this.field_70127_C = this.field_70125_A;
/*  69 */     this.targetEntity = null;
/*  70 */     setPower(1);
/*  71 */     this.acceleration = 1.0D;
/*  72 */     this.accelerationFactor = 1.0D;
/*  73 */     this.piercing = 0;
/*  74 */     this.explosionPower = 0;
/*  75 */     this.explosionPowerInWater = 0;
/*  76 */     this.delayFuse = 0;
/*  77 */     this.sprinkleTime = 0;
/*  78 */     this.isBomblet = -1;
/*  79 */     this.weaponInfo = null;
/*  80 */     this.field_70158_ak = true;
/*  81 */     if (par1World.field_72995_K)
/*  82 */       this.model = null; 
/*     */   }
/*     */   public int piercing; public int delayFuse; public int sprinkleTime; public byte isBomblet; private MCH_WeaponInfo weaponInfo; private MCH_BulletModel model; public double prevPosX2; public double prevPosY2; public double prevPosZ2; public double prevMotionX; public double prevMotionY; public double prevMotionZ; public double hitX; public double hitY; public double hitZ;
/*     */   public ForgeChunkManager.Ticket chunkLoadingTicket;
/*     */   
/*     */   public MCH_EntityBaseBullet(World par1World, double px, double py, double pz, double mx, double my, double mz, float yaw, float pitch, double acceleration) {
/*  88 */     this(par1World);
/*  89 */     func_70105_a(1.0F, 1.0F);
/*  90 */     func_70012_b(px, py, pz, yaw, pitch);
/*  91 */     func_70107_b(px, py, pz);
/*  92 */     this.field_70126_B = yaw;
/*  93 */     this.field_70127_C = pitch;
/*  94 */     this.field_70129_M = 0.0F;
/*  95 */     if (acceleration > 3.9D) {
/*  96 */       acceleration = 3.9D;
/*     */     }
/*     */     
/*  99 */     double d = MathHelper.func_76133_a(mx * mx + my * my + mz * mz);
/* 100 */     this.field_70159_w = mx * acceleration / d;
/* 101 */     this.field_70181_x = my * acceleration / d;
/* 102 */     this.field_70179_y = mz * acceleration / d;
/* 103 */     this.prevMotionX = this.field_70159_w;
/* 104 */     this.prevMotionY = this.field_70181_x;
/* 105 */     this.prevMotionZ = this.field_70179_y;
/* 106 */     this.acceleration = acceleration;
/*     */   }
/*     */   
/*     */   public void func_70012_b(double par1, double par3, double par5, float par7, float par8) {
/* 110 */     super.func_70012_b(par1, par3, par5, par7, par8);
/* 111 */     this.prevPosX2 = par1;
/* 112 */     this.prevPosY2 = par3;
/* 113 */     this.prevPosZ2 = par5;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/* 117 */     super.func_70088_a();
/* 118 */     func_70096_w().func_75682_a(27, Integer.valueOf(0));
/* 119 */     func_70096_w().func_75682_a(29, String.valueOf(""));
/* 120 */     func_70096_w().func_75682_a(30, String.valueOf(""));
/* 121 */     func_70096_w().func_75682_a(31, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public void setName(String s) {
/* 125 */     if (s != null && !s.isEmpty()) {
/* 126 */       this.weaponInfo = MCH_WeaponInfoManager.get(s);
/* 127 */       if (this.weaponInfo != null) {
/* 128 */         if (!this.field_70170_p.field_72995_K) {
/* 129 */           func_70096_w().func_75692_b(29, String.valueOf(s));
/*     */         }
/*     */         
/* 132 */         onSetWeasponInfo();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getName() {
/* 139 */     return func_70096_w().func_75681_e(29);
/*     */   }
/*     */   
/*     */   public MCH_WeaponInfo getInfo() {
/* 143 */     return this.weaponInfo;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onSetWeasponInfo() {
/* 150 */     if (!this.field_70170_p.field_72995_K) {
/* 151 */       this.isBomblet = 0;
/*     */     }
/*     */     
/* 154 */     if ((getInfo()).bomblet > 0) {
/* 155 */       this.sprinkleTime = (getInfo()).bombletSTime;
/*     */     }
/*     */     
/* 158 */     this.piercing = (getInfo()).piercing;
/* 159 */     if (this instanceof MCH_EntityBullet) {
/* 160 */       if ((getInfo()).acceleration > 4.0F) {
/* 161 */         this.accelerationFactor = ((getInfo()).acceleration / 4.0F);
/*     */       }
/* 163 */     } else if (this instanceof MCH_EntityRocket && this.isBomblet == 0 && (getInfo()).acceleration > 4.0F) {
/* 164 */       this.accelerationFactor = ((getInfo()).acceleration / 4.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void forceChunkLoading(ForgeChunkManager.Ticket ticket) {}
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_70106_y() {
/* 175 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public void setBomblet() {
/* 179 */     this.isBomblet = 1;
/* 180 */     this.sprinkleTime = 0;
/* 181 */     this.field_70180_af.func_75692_b(31, Byte.valueOf((byte)1));
/*     */   }
/*     */   
/*     */   public byte getBomblet() {
/* 185 */     return this.field_70180_af.func_75683_a(31);
/*     */   }
/*     */   
/*     */   public void setTargetEntity(Entity entity) {
/* 189 */     this.targetEntity = entity;
/* 190 */     if (!this.field_70170_p.field_72995_K) {
/* 191 */       if (entity != null) {
/* 192 */         func_70096_w().func_75692_b(27, Integer.valueOf(W_Entity.getEntityId(entity)));
/*     */       } else {
/* 194 */         func_70096_w().func_75692_b(27, Integer.valueOf(0));
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public int getTargetEntityID() {
/* 201 */     return (this.targetEntity != null) ? W_Entity.getEntityId(this.targetEntity) : func_70096_w().func_75679_c(27);
/*     */   }
/*     */   
/*     */   public MCH_BulletModel getBulletModel() {
/* 205 */     if (getInfo() == null)
/* 206 */       return null; 
/* 207 */     if (this.isBomblet < 0) {
/* 208 */       return null;
/*     */     }
/* 210 */     if (this.model == null) {
/* 211 */       if (this.isBomblet == 1) {
/* 212 */         this.model = (getInfo()).bombletModel;
/*     */       } else {
/* 214 */         this.model = (getInfo()).bulletModel;
/*     */       } 
/*     */       
/* 217 */       if (this.model == null) {
/* 218 */         this.model = getDefaultBulletModel();
/*     */       }
/*     */     } 
/*     */     
/* 222 */     return this.model;
/*     */   }
/*     */ 
/*     */   
/*     */   public abstract MCH_BulletModel getDefaultBulletModel();
/*     */   
/*     */   public void sprinkleBomblet() {}
/*     */   
/*     */   public void spawnParticle(String name, int num, float size) {
/* 231 */     if (this.field_70170_p.field_72995_K) {
/* 232 */       if (name.isEmpty() || num < 1 || num > 50) {
/*     */         return;
/*     */       }
/*     */       
/* 236 */       double x = (this.field_70165_t - this.field_70169_q) / num;
/* 237 */       double y = (this.field_70163_u - this.field_70167_r) / num;
/* 238 */       double z = (this.field_70161_v - this.field_70166_s) / num;
/* 239 */       double x2 = (this.field_70169_q - this.prevPosX2) / num;
/* 240 */       double y2 = (this.field_70167_r - this.prevPosY2) / num;
/* 241 */       double z2 = (this.field_70166_s - this.prevPosZ2) / num;
/*     */       
/* 243 */       if (name.equals("explode")) {
/* 244 */         for (int i = 0; i < num; i++) {
/* 245 */           MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", (this.field_70169_q + x * i + this.prevPosX2 + x2 * i) / 2.0D, (this.field_70167_r + y * i + this.prevPosY2 + y2 * i) / 2.0D, (this.field_70166_s + z * i + this.prevPosZ2 + z2 * i) / 2.0D);
/* 246 */           prm.size = size + this.field_70146_Z.nextFloat();
/* 247 */           MCH_ParticlesUtil.spawnParticle(prm);
/*     */         } 
/*     */       } else {
/* 250 */         for (int i = 0; i < num; i++) {
/* 251 */           MCH_ParticlesUtil.DEF_spawnParticle(name, (this.field_70169_q + x * i + this.prevPosX2 + x2 * i) / 2.0D, (this.field_70167_r + y * i + this.prevPosY2 + y2 * i) / 2.0D, (this.field_70166_s + z * i + this.prevPosZ2 + z2 * i) / 2.0D, 0.0D, 0.0D, 0.0D, 50.0F);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void DEF_spawnParticle(String name, int num, float size) {
/* 259 */     if (this.field_70170_p.field_72995_K) {
/* 260 */       if (name.isEmpty() || num < 1 || num > 50) {
/*     */         return;
/*     */       }
/*     */       
/* 264 */       double x = (this.field_70165_t - this.field_70169_q) / num;
/* 265 */       double y = (this.field_70163_u - this.field_70167_r) / num;
/* 266 */       double z = (this.field_70161_v - this.field_70166_s) / num;
/* 267 */       double x2 = (this.field_70169_q - this.prevPosX2) / num;
/* 268 */       double y2 = (this.field_70167_r - this.prevPosY2) / num;
/* 269 */       double z2 = (this.field_70166_s - this.prevPosZ2) / num;
/*     */       
/* 271 */       for (int i = 0; i < num; i++) {
/* 272 */         MCH_ParticlesUtil.DEF_spawnParticle(name, (this.field_70169_q + x * i + this.prevPosX2 + x2 * i) / 2.0D, (this.field_70167_r + y * i + this.prevPosY2 + y2 * i) / 2.0D, (this.field_70166_s + z * i + this.prevPosZ2 + z2 * i) / 2.0D, 0.0D, 0.0D, 0.0D, 150.0F);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public int getCountOnUpdate() {
/* 279 */     return this.countOnUpdate;
/*     */   }
/*     */   
/*     */   public void clearCountOnUpdate() {
/* 283 */     this.countOnUpdate = 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public boolean func_70112_a(double par1) {
/* 288 */     double d1 = this.field_70121_D.func_72320_b() * 4.0D;
/* 289 */     d1 *= 64.0D;
/* 290 */     return (par1 < d1 * d1);
/*     */   }
/*     */   
/*     */   public void setParameterFromWeapon(MCH_WeaponBase w, Entity entity, Entity user) {
/* 294 */     this.explosionPower = w.explosionPower;
/* 295 */     this.explosionPowerInWater = w.explosionPowerInWater;
/* 296 */     setPower(w.power);
/* 297 */     this.piercing = w.piercing;
/* 298 */     this.shootingAircraft = entity;
/* 299 */     this.shootingEntity = user;
/*     */   }
/*     */   
/*     */   public void setParameterFromWeapon(MCH_EntityBaseBullet b, Entity entity, Entity user) {
/* 303 */     this.explosionPower = b.explosionPower;
/* 304 */     this.explosionPowerInWater = b.explosionPowerInWater;
/* 305 */     setPower(b.getPower());
/* 306 */     this.piercing = b.piercing;
/* 307 */     this.shootingAircraft = entity;
/* 308 */     this.shootingEntity = user;
/*     */   }
/*     */   
/*     */   public void setMotion(double targetX, double targetY, double targetZ) {
/* 312 */     double d6 = MathHelper.func_76133_a(targetX * targetX + targetY * targetY + targetZ * targetZ);
/* 313 */     this.field_70159_w = targetX * this.acceleration / d6;
/* 314 */     this.field_70181_x = targetY * this.acceleration / d6;
/* 315 */     this.field_70179_y = targetZ * this.acceleration / d6;
/*     */   }
/*     */   
/*     */   public void guidanceToTarget(double targetPosX, double targetPosY, double targetPosZ) {
/* 319 */     guidanceToTarget(targetPosX, targetPosY, targetPosZ, 1.0F);
/*     */   }
/*     */   
/*     */   public void guidanceToTarget(double targetPosX, double targetPosY, double targetPosZ, float accelerationFactor) {
/* 323 */     double tx = targetPosX - this.field_70165_t;
/* 324 */     double ty = targetPosY - this.field_70163_u;
/* 325 */     double tz = targetPosZ - this.field_70161_v;
/* 326 */     double d = MathHelper.func_76133_a(tx * tx + ty * ty + tz * tz);
/* 327 */     double mx = tx * this.acceleration / d;
/* 328 */     double my = ty * this.acceleration / d;
/* 329 */     double mz = tz * this.acceleration / d;
/* 330 */     this.field_70159_w = (this.field_70159_w * 6.0D + mx) / 7.0D;
/* 331 */     this.field_70181_x = (this.field_70181_x * 6.0D + my) / 7.0D;
/* 332 */     this.field_70179_y = (this.field_70179_y * 6.0D + mz) / 7.0D;
/* 333 */     double a = (float)Math.atan2(this.field_70179_y, this.field_70159_w);
/* 334 */     this.field_70177_z = (float)(a * 180.0D / Math.PI) - 90.0F;
/* 335 */     double r = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 336 */     this.field_70125_A = -((float)(Math.atan2(this.field_70181_x, r) * 180.0D / Math.PI));
/*     */   }
/*     */   
/*     */   public boolean checkValid() {
/* 340 */     if (this.shootingEntity == null && this.shootingAircraft == null)
/* 341 */       return false; 
/* 342 */     if (this.shootingEntity != null && this.shootingEntity.field_70128_L) {
/* 343 */       return false;
/*     */     }
/* 345 */     if (this.shootingAircraft == null || this.shootingAircraft.field_70128_L);
/*     */ 
/*     */ 
/*     */     
/* 349 */     Entity shooter = (this.shootingEntity != null) ? this.shootingEntity : this.shootingAircraft;
/* 350 */     double x = this.field_70165_t - shooter.field_70165_t;
/* 351 */     double z = this.field_70161_v - shooter.field_70161_v;
/* 352 */     return (x * x + z * z < 3.38724E7D);
/*     */   }
/*     */ 
/*     */   
/*     */   public float getGravity() {
/* 357 */     return (getInfo() != null) ? (getInfo()).gravity : 0.0F;
/*     */   }
/*     */   
/*     */   public float getGravityInWater() {
/* 361 */     return (getInfo() != null) ? (getInfo()).gravityInWater : 0.0F;
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/* 365 */     if (this.field_70170_p.field_72995_K && this.countOnUpdate == 0) {
/* 366 */       int f3 = getTargetEntityID();
/* 367 */       if (f3 > 0) {
/* 368 */         setTargetEntity(this.field_70170_p.func_73045_a(f3));
/*     */       }
/*     */     } 
/*     */     
/* 372 */     if (this.prevMotionX != this.field_70159_w || this.prevMotionY != this.field_70181_x || this.prevMotionZ != this.field_70179_y) {
/* 373 */       double var5 = (float)Math.atan2(this.field_70179_y, this.field_70159_w);
/* 374 */       this.field_70177_z = (float)(var5 * 180.0D / Math.PI) - 90.0F;
/* 375 */       double r = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 376 */       this.field_70125_A = -((float)(Math.atan2(this.field_70181_x, r) * 180.0D / Math.PI));
/*     */     } 
/*     */     
/* 379 */     this.prevMotionX = this.field_70159_w;
/* 380 */     this.prevMotionY = this.field_70181_x;
/* 381 */     this.prevMotionZ = this.field_70179_y;
/* 382 */     this.countOnUpdate++;
/* 383 */     if (this.countOnUpdate > 10000000) {
/* 384 */       clearCountOnUpdate();
/*     */     }
/*     */     
/* 387 */     this.prevPosX2 = this.field_70169_q;
/* 388 */     this.prevPosY2 = this.field_70167_r;
/* 389 */     this.prevPosZ2 = this.field_70166_s;
/* 390 */     super.func_70071_h_();
/* 391 */     if (getInfo() == null) {
/* 392 */       if (this.countOnUpdate >= 2) {
/* 393 */         MCH_Lib.Log((Entity)this, "##### MCH_EntityBaseBullet onUpdate() Weapon info null %d, %s, Name=%s", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)this)), getEntityName(), getName() });
/* 394 */         func_70106_y();
/*     */         
/*     */         return;
/*     */       } 
/* 398 */       setName(getName());
/* 399 */       if (getInfo() == null) {
/*     */         return;
/*     */       }
/*     */     } 
/*     */     
/* 404 */     if (this.field_70170_p.field_72995_K && this.isBomblet < 0) {
/* 405 */       this.isBomblet = getBomblet();
/*     */     }
/*     */     
/* 408 */     if (!this.field_70170_p.field_72995_K) {
/* 409 */       if ((int)this.field_70163_u <= 255 && !this.field_70170_p.func_72899_e((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v)) {
/* 410 */         if ((getInfo()).delayFuse <= 0) {
/* 411 */           func_70106_y();
/*     */           
/*     */           return;
/*     */         } 
/* 415 */         if (this.delayFuse == 0) {
/* 416 */           this.delayFuse = (getInfo()).delayFuse;
/*     */         }
/*     */       } 
/*     */       
/* 420 */       if (this.delayFuse > 0) {
/* 421 */         this.delayFuse--;
/* 422 */         if (this.delayFuse == 0) {
/* 423 */           onUpdateTimeout();
/* 424 */           func_70106_y();
/*     */           
/*     */           return;
/*     */         } 
/*     */       } 
/* 429 */       if (!checkValid()) {
/* 430 */         func_70106_y();
/*     */         
/*     */         return;
/*     */       } 
/* 434 */       if ((getInfo()).timeFuse > 0 && getCountOnUpdate() > (getInfo()).timeFuse) {
/* 435 */         onUpdateTimeout();
/* 436 */         func_70106_y();
/*     */         
/*     */         return;
/*     */       } 
/* 440 */       if ((getInfo()).explosionAltitude > 0 && MCH_Lib.getBlockIdY((Entity)this, 3, -(getInfo()).explosionAltitude) != 0) {
/* 441 */         MovingObjectPosition var6 = new MovingObjectPosition((int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v, 0, Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v));
/* 442 */         onImpact(var6, 1.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 446 */     if (!func_70090_H()) {
/* 447 */       this.field_70181_x += getGravity();
/*     */     } else {
/* 449 */       this.field_70181_x += getGravityInWater();
/*     */     } 
/*     */     
/* 452 */     if (!this.field_70128_L) {
/* 453 */       onUpdateCollided();
/*     */     }
/*     */     
/* 456 */     this.field_70165_t += this.field_70159_w * this.accelerationFactor;
/* 457 */     this.field_70163_u += this.field_70181_x * this.accelerationFactor;
/* 458 */     this.field_70161_v += this.field_70179_y * this.accelerationFactor;
/* 459 */     if (this.field_70170_p.field_72995_K) {
/* 460 */       updateSplash();
/*     */     }
/*     */     
/* 463 */     if (func_70090_H()) {
/* 464 */       float var7 = 0.25F;
/* 465 */       this.field_70170_p.func_72869_a("bubble", this.field_70165_t - this.field_70159_w * var7, this.field_70163_u - this.field_70181_x * var7, this.field_70161_v - this.field_70179_y * var7, this.field_70159_w, this.field_70181_x, this.field_70179_y);
/*     */     } 
/*     */     
/* 468 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */   }
/*     */   
/*     */   public void simulateOnUpdate() {
/* 472 */     if (this.field_70170_p.field_72995_K && this.countOnUpdate == 0) {
/* 473 */       int f3 = getTargetEntityID();
/* 474 */       if (f3 > 0) {
/* 475 */         setTargetEntity(this.field_70170_p.func_73045_a(f3));
/*     */       }
/*     */     } 
/*     */     
/* 479 */     if (this.prevMotionX != this.field_70159_w || this.prevMotionY != this.field_70181_x || this.prevMotionZ != this.field_70179_y) {
/* 480 */       double var5 = (float)Math.atan2(this.field_70179_y, this.field_70159_w);
/* 481 */       this.field_70177_z = (float)(var5 * 180.0D / Math.PI) - 90.0F;
/* 482 */       double r = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 483 */       this.field_70125_A = -((float)(Math.atan2(this.field_70181_x, r) * 180.0D / Math.PI));
/*     */     } 
/*     */     
/* 486 */     this.prevMotionX = this.field_70159_w;
/* 487 */     this.prevMotionY = this.field_70181_x;
/* 488 */     this.prevMotionZ = this.field_70179_y;
/* 489 */     this.countOnUpdate++;
/* 490 */     if (this.countOnUpdate > 10000000) {
/* 491 */       clearCountOnUpdate();
/*     */     }
/*     */     
/* 494 */     this.prevPosX2 = this.field_70169_q;
/* 495 */     this.prevPosY2 = this.field_70167_r;
/* 496 */     this.prevPosZ2 = this.field_70166_s;
/* 497 */     super.func_70071_h_();
/* 498 */     if (getInfo() == null) {
/* 499 */       if (this.countOnUpdate >= 2) {
/* 500 */         MCH_Lib.Log((Entity)this, "##### MCH_EntityBaseBullet onUpdate() Weapon info null %d, %s, Name=%s", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)this)), getEntityName(), getName() });
/* 501 */         func_70106_y();
/*     */         
/*     */         return;
/*     */       } 
/* 505 */       setName(getName());
/* 506 */       if (getInfo() == null) {
/*     */         return;
/*     */       }
/*     */     } 
/* 510 */     this.field_70165_t += this.field_70159_w * this.accelerationFactor;
/* 511 */     this.field_70163_u += this.field_70181_x * this.accelerationFactor;
/* 512 */     this.field_70161_v += this.field_70179_y * this.accelerationFactor;
/* 513 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */   }
/*     */   
/*     */   public void updateSplash() {
/* 517 */     if (getInfo() != null && 
/* 518 */       (getInfo()).power > 0 && 
/* 519 */       !W_WorldFunc.isBlockWater(this.field_70170_p, (int)(this.field_70169_q + 0.5D), (int)(this.field_70167_r + 0.5D), (int)(this.field_70166_s + 0.5D)) && W_WorldFunc.isBlockWater(this.field_70170_p, (int)(this.field_70165_t + 0.5D), (int)(this.field_70163_u + 0.5D), (int)(this.field_70161_v + 0.5D))) {
/* 520 */       double x = this.field_70165_t - this.field_70169_q;
/* 521 */       double y = this.field_70163_u - this.field_70167_r;
/* 522 */       double z = this.field_70161_v - this.field_70166_s;
/* 523 */       double d = Math.sqrt(x * x + y * y + z * z);
/* 524 */       if (d <= 0.15D) {
/*     */         return;
/*     */       }
/*     */       
/* 528 */       x /= d;
/* 529 */       y /= d;
/* 530 */       z /= d;
/* 531 */       double px = this.field_70169_q;
/* 532 */       double py = this.field_70167_r;
/* 533 */       double pz = this.field_70166_s;
/*     */       
/* 535 */       for (int i = 0; i <= d; i++) {
/* 536 */         px += x;
/* 537 */         py += y;
/* 538 */         pz += z;
/* 539 */         if (W_WorldFunc.isBlockWater(this.field_70170_p, (int)(px + 0.5D), (int)(py + 0.5D), (int)(pz + 0.5D))) {
/* 540 */           float pwr = ((getInfo()).power < 20) ? (getInfo()).power : 20.0F;
/* 541 */           int n = this.field_70146_Z.nextInt(1 + (int)pwr / 3) + (int)pwr / 2 + 1;
/* 542 */           pwr *= 0.03F;
/*     */           
/* 544 */           for (int j = 0; j < n; j++) {
/* 545 */             MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "splash", px, py + 0.5D, pz, pwr * (this.field_70146_Z.nextDouble() - 0.5D) * 0.3D, pwr * (this.field_70146_Z.nextDouble() * 0.5D + 0.5D) * 1.8D, pwr * (this.field_70146_Z.nextDouble() - 0.5D) * 0.3D, pwr * 5.0F);
/* 546 */             MCH_ParticlesUtil.spawnParticle(prm);
/*     */           } 
/*     */           return;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onUpdateTimeout() {
/* 559 */     if (func_70090_H()) {
/* 560 */       if (this.explosionPowerInWater > 0) {
/* 561 */         newExplosion(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.explosionPowerInWater, this.explosionPowerInWater, true);
/*     */       }
/* 563 */     } else if (this.explosionPower > 0) {
/* 564 */       newExplosion(this.field_70165_t, this.field_70163_u, this.field_70161_v, this.explosionPower, (getInfo()).explosionBlock, false);
/* 565 */     } else if (this.explosionPower < 0) {
/* 566 */       playExplosionSound();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdateBomblet() {
/* 572 */     if (!this.field_70170_p.field_72995_K && this.sprinkleTime > 0 && !this.field_70128_L) {
/* 573 */       this.sprinkleTime--;
/* 574 */       if (this.sprinkleTime == 0) {
/* 575 */         for (int i = 0; i < (getInfo()).bomblet; i++) {
/* 576 */           sprinkleBomblet();
/*     */         }
/*     */         
/* 579 */         func_70106_y();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void boundBullet(int sideHit) {
/* 586 */     switch (sideHit) {
/*     */       case 0:
/* 588 */         if (this.field_70181_x > 0.0D) {
/* 589 */           this.field_70181_x = -this.field_70181_x * (getInfo()).bound;
/*     */         }
/*     */         break;
/*     */       case 1:
/* 593 */         if (this.field_70181_x < 0.0D) {
/* 594 */           this.field_70181_x = -this.field_70181_x * (getInfo()).bound;
/*     */         }
/*     */         break;
/*     */       case 2:
/* 598 */         if (this.field_70179_y > 0.0D) {
/* 599 */           this.field_70179_y = -this.field_70179_y * (getInfo()).bound; break;
/*     */         } 
/* 601 */         this.field_70161_v += this.field_70179_y;
/*     */         break;
/*     */       
/*     */       case 3:
/* 605 */         if (this.field_70179_y < 0.0D) {
/* 606 */           this.field_70179_y = -this.field_70179_y * (getInfo()).bound; break;
/*     */         } 
/* 608 */         this.field_70161_v += this.field_70179_y;
/*     */         break;
/*     */       
/*     */       case 4:
/* 612 */         if (this.field_70159_w > 0.0D) {
/* 613 */           this.field_70159_w = -this.field_70159_w * (getInfo()).bound; break;
/*     */         } 
/* 615 */         this.field_70165_t += this.field_70159_w;
/*     */         break;
/*     */       
/*     */       case 5:
/* 619 */         if (this.field_70159_w < 0.0D) {
/* 620 */           this.field_70159_w = -this.field_70159_w * (getInfo()).bound; break;
/*     */         } 
/* 622 */         this.field_70165_t += this.field_70159_w;
/*     */         break;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdateCollided() {
/* 629 */     float damageFator = 1.0F;
/* 630 */     double mx = this.field_70159_w * this.accelerationFactor;
/* 631 */     double my = this.field_70181_x * this.accelerationFactor;
/* 632 */     double mz = this.field_70179_y * this.accelerationFactor;
/* 633 */     MovingObjectPosition m = null;
/*     */ 
/*     */ 
/*     */     
/* 637 */     for (int entity = 0; entity < 5; entity++) {
/* 638 */       Vec3 vec32 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 639 */       Vec3 vec33 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t + mx, this.field_70163_u + my, this.field_70161_v + mz);
/* 640 */       m = W_WorldFunc.clip(this.field_70170_p, vec32, vec33);
/* 641 */       boolean list = false;
/* 642 */       if (this.shootingEntity != null && W_MovingObjectPosition.isHitTypeTile(m)) {
/* 643 */         Block d0 = W_WorldFunc.getBlock(this.field_70170_p, m.field_72311_b, m.field_72312_c, m.field_72309_d);
/* 644 */         MCH_Config var10000 = MCH_MOD.config;
/* 645 */         if (MCH_Config.bulletBreakableBlocks.contains(d0)) {
/* 646 */           W_WorldFunc.destroyBlock(this.field_70170_p, m.field_72311_b, m.field_72312_c, m.field_72309_d, true);
/* 647 */           list = true;
/*     */         } 
/*     */       } 
/*     */       
/* 651 */       if (!list) {
/*     */         break;
/*     */       }
/*     */     } 
/*     */     
/* 656 */     Vec3 vec3 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 657 */     Vec3 vec31 = W_WorldFunc.getWorldVec3(this.field_70170_p, this.field_70165_t + mx, this.field_70163_u + my, this.field_70161_v + mz);
/* 658 */     if ((getInfo()).delayFuse > 0) {
/* 659 */       if (m != null) {
/* 660 */         boundBullet(m.field_72310_e);
/* 661 */         if (this.delayFuse == 0) {
/* 662 */           this.delayFuse = (getInfo()).delayFuse;
/*     */         }
/*     */       } 
/*     */     } else {
/*     */       
/* 667 */       if (m != null) {
/* 668 */         vec31 = W_WorldFunc.getWorldVec3(this.field_70170_p, m.field_72307_f.field_72450_a, m.field_72307_f.field_72448_b, m.field_72307_f.field_72449_c);
/*     */       }
/*     */       
/* 671 */       Entity var22 = null;
/* 672 */       List<Entity> var23 = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72321_a(mx, my, mz).func_72314_b(21.0D, 21.0D, 21.0D));
/* 673 */       double var24 = 0.0D;
/*     */       
/* 675 */       for (int j = 0; j < var23.size(); j++) {
/* 676 */         Entity entity1 = var23.get(j);
/* 677 */         if (canBeCollidedEntity(entity1)) {
/* 678 */           float f = 0.3F;
/* 679 */           AxisAlignedBB axisalignedbb = entity1.field_70121_D.func_72314_b(f, f, f);
/* 680 */           MovingObjectPosition m1 = axisalignedbb.func_72327_a(vec3, vec31);
/* 681 */           if (m1 != null) {
/* 682 */             double d1 = vec3.func_72438_d(m1.field_72307_f);
/* 683 */             if (d1 < var24 || var24 == 0.0D) {
/* 684 */               var22 = entity1;
/* 685 */               var24 = d1;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 691 */       if (var22 != null) {
/* 692 */         m = new MovingObjectPosition(var22);
/*     */       }
/*     */       
/* 695 */       if (m != null) {
/* 696 */         onImpact(m, damageFator);
/*     */       }
/*     */     } 
/*     */   }
/*     */   
/*     */   public boolean canBeCollidedEntity(Entity entity) {
/*     */     String s;
/* 703 */     if (!entity.func_70067_L()) {
/* 704 */       return false;
/*     */     }
/* 706 */     if (entity instanceof MCH_EntityBaseBullet) {
/* 707 */       if (this.field_70170_p.field_72995_K) {
/* 708 */         return false;
/*     */       }
/*     */       
/* 711 */       MCH_EntityBaseBullet i$ = (MCH_EntityBaseBullet)entity;
/* 712 */       if (W_Entity.isEqual(i$.shootingAircraft, this.shootingAircraft)) {
/* 713 */         return false;
/*     */       }
/*     */       
/* 716 */       if (W_Entity.isEqual(i$.shootingEntity, this.shootingEntity)) {
/* 717 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 721 */     if (entity instanceof mcheli.aircraft.MCH_EntitySeat)
/* 722 */       return false; 
/* 723 */     if (entity instanceof mcheli.aircraft.MCH_EntityHitBox)
/* 724 */       return false; 
/* 725 */     if (W_Entity.isEqual(entity, this.shootingEntity)) {
/* 726 */       return false;
/*     */     }
/* 728 */     if (this.shootingAircraft instanceof MCH_EntityAircraft) {
/* 729 */       if (W_Entity.isEqual(entity, this.shootingAircraft)) {
/* 730 */         return false;
/*     */       }
/*     */       
/* 733 */       if (((MCH_EntityAircraft)this.shootingAircraft).isMountedEntity(entity)) {
/* 734 */         return false;
/*     */       }
/*     */     } 
/*     */     
/* 738 */     MCH_Config var10000 = MCH_MOD.config;
/* 739 */     Iterator<String> i$1 = MCH_Config.IgnoreBulletHitList.iterator();
/*     */ 
/*     */     
/*     */     do {
/* 743 */       if (!i$1.hasNext()) {
/* 744 */         return true;
/*     */       }
/*     */       
/* 747 */       s = i$1.next();
/* 748 */     } while (entity.getClass().getName().toLowerCase().indexOf(s.toLowerCase()) < 0);
/*     */     
/* 750 */     return false;
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void notifyHitBullet() {
/* 756 */     if (this.shootingAircraft instanceof MCH_EntityAircraft && W_EntityPlayer.isPlayer(this.shootingEntity)) {
/* 757 */       MCH_PacketNotifyHitBullet.send((MCH_EntityAircraft)this.shootingAircraft, (EntityPlayer)this.shootingEntity);
/*     */     }
/*     */     
/* 760 */     if (W_EntityPlayer.isPlayer(this.shootingEntity)) {
/* 761 */       MCH_PacketNotifyHitBullet.send((MCH_EntityAircraft)null, (EntityPlayer)this.shootingEntity);
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void onImpact(MovingObjectPosition m, float damageFactor) {
/* 768 */     if (!this.field_70170_p.field_72995_K) {
/* 769 */       if (m.field_72308_g != null) {
/* 770 */         onImpactEntity(m.field_72308_g, damageFactor);
/* 771 */         this.piercing = 0;
/*     */       } 
/*     */       
/* 774 */       float p = this.explosionPower * damageFactor;
/* 775 */       float i = this.explosionPowerInWater * damageFactor;
/* 776 */       double dx = 0.0D;
/* 777 */       double dy = 0.0D;
/* 778 */       double dz = 0.0D;
/* 779 */       this.hitX = m.field_72307_f.field_72450_a + dx;
/* 780 */       this.hitY = m.field_72307_f.field_72448_b + dy;
/* 781 */       this.hitZ = m.field_72307_f.field_72449_c + dz;
/* 782 */       if (this.piercing > 0) {
/* 783 */         this.piercing--;
/* 784 */         if (p > 0.0F) {
/* 785 */           newExplosion(m.field_72307_f.field_72450_a + dx, m.field_72307_f.field_72448_b + dy, m.field_72307_f.field_72449_c + dz, 1.0F, 1.0F, false);
/*     */         }
/*     */       } else {
/* 788 */         if (i == 0.0F) {
/* 789 */           if ((getInfo()).isFAE) {
/* 790 */             newFAExplosion(this.field_70165_t, this.field_70163_u, this.field_70161_v, p, (getInfo()).explosionBlock);
/* 791 */           } else if (p > 0.0F) {
/* 792 */             newExplosion(m.field_72307_f.field_72450_a + dx, m.field_72307_f.field_72448_b + dy, m.field_72307_f.field_72449_c + dz, p, (getInfo()).explosionBlock, false);
/* 793 */           } else if (p < 0.0F) {
/* 794 */             playExplosionSound();
/*     */           } 
/* 796 */         } else if (m.field_72308_g != null) {
/* 797 */           if (func_70090_H()) {
/* 798 */             newExplosion(m.field_72307_f.field_72450_a + dx, m.field_72307_f.field_72448_b + dy, m.field_72307_f.field_72449_c + dz, i, i, true);
/*     */           } else {
/* 800 */             newExplosion(m.field_72307_f.field_72450_a + dx, m.field_72307_f.field_72448_b + dy, m.field_72307_f.field_72449_c + dz, p, (getInfo()).explosionBlock, false);
/*     */           } 
/* 802 */         } else if (!func_70090_H() && !MCH_Lib.isBlockInWater(this.field_70170_p, m.field_72311_b, m.field_72312_c, m.field_72309_d)) {
/* 803 */           if (p > 0.0F) {
/* 804 */             newExplosion(m.field_72307_f.field_72450_a + dx, m.field_72307_f.field_72448_b + dy, m.field_72307_f.field_72449_c + dz, p, (getInfo()).explosionBlock, false);
/* 805 */           } else if (p < 0.0F) {
/* 806 */             playExplosionSound();
/*     */           } 
/*     */         } else {
/* 809 */           newExplosion(m.field_72311_b, m.field_72312_c, m.field_72309_d, i, i, true);
/*     */         } 
/*     */         
/* 812 */         func_70106_y();
/*     */       } 
/* 814 */     } else if (getInfo() != null && ((getInfo()).explosion == 0 || (getInfo()).modeNum >= 2) && W_MovingObjectPosition.isHitTypeTile(m)) {
/* 815 */       float p = (getInfo()).power;
/*     */       
/* 817 */       for (int var11 = 0; var11 < p / 3.0F; var11++) {
/* 818 */         MCH_ParticlesUtil.spawnParticleTileCrack(this.field_70170_p, m.field_72311_b, m.field_72312_c, m.field_72309_d, m.field_72307_f.field_72450_a + (this.field_70146_Z.nextFloat() - 0.5D) * p / 10.0D, m.field_72307_f.field_72448_b + 0.1D, m.field_72307_f.field_72449_c + (this.field_70146_Z.nextFloat() - 0.5D) * p / 10.0D, -this.field_70159_w * p / 2.0D, (p / 2.0F), -this.field_70179_y * p / 2.0D);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onImpactEntity(Entity entity, float damageFactor) {
/* 825 */     if (!entity.field_70128_L) {
/* 826 */       MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityBaseBullet.onImpactEntity:Damage=%d:" + entity.getClass(), new Object[] { Integer.valueOf(getPower()) });
/* 827 */       MCH_Lib.applyEntityHurtResistantTimeConfig(entity);
/* 828 */       DamageSource ds = DamageSource.func_76356_a((Entity)this, this.shootingEntity);
/* 829 */       MCH_Config var10000 = MCH_MOD.config;
/* 830 */       float damage = MCH_Config.applyDamageVsEntity(entity, ds, getPower() * damageFactor);
/* 831 */       damage *= (getInfo() != null) ? getInfo().getDamageFactor(entity) : 1.0F;
/* 832 */       entity.func_70097_a(ds, damage);
/*     */       
/* 834 */       if (entity.field_70128_L);
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 839 */     notifyHitBullet();
/*     */   }
/*     */   
/*     */   public void newFAExplosion(double x, double y, double z, float exp, float expBlock) {
/* 843 */     MCH_Explosion.ExplosionResult result = MCH_Explosion.newExplosion(this.field_70170_p, (Entity)this, this.shootingEntity, x, y, z, exp, expBlock, true, true, (getInfo()).flaming, false, 15);
/* 844 */     if (result != null && result.hitEntity) {
/* 845 */       notifyHitBullet();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void newExplosion(double x, double y, double z, float exp, float expBlock, boolean inWater) {
/*     */     MCH_Explosion.ExplosionResult result;
/* 852 */     if (!inWater) {
/* 853 */       result = MCH_Explosion.newExplosion(this.field_70170_p, (Entity)this, this.shootingEntity, x, y, z, exp, expBlock, (this.isBomblet == 1) ? ((this.field_70146_Z.nextInt(3) == 0)) : true, true, (getInfo()).flaming, true, 0, (getInfo() != null) ? (getInfo()).damageFactor : null);
/*     */     } else {
/* 855 */       result = MCH_Explosion.newExplosionInWater(this.field_70170_p, (Entity)this, this.shootingEntity, x, y, z, exp, expBlock, (this.isBomblet == 1) ? ((this.field_70146_Z.nextInt(3) == 0)) : true, true, (getInfo()).flaming, true, 0, (getInfo() != null) ? (getInfo()).damageFactor : null);
/*     */     } 
/*     */     
/* 858 */     if (result != null && result.hitEntity) {
/* 859 */       notifyHitBullet();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void playExplosionSound() {
/* 865 */     MCH_Explosion.playExplosionSound(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */   }
/*     */   
/*     */   public void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 869 */     par1NBTTagCompound.func_74782_a("direction", (NBTBase)func_70087_a(new double[] { this.field_70159_w, this.field_70181_x, this.field_70179_y }));
/* 870 */     par1NBTTagCompound.func_74778_a("WeaponName", getName());
/*     */   }
/*     */   
/*     */   public void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 874 */     func_70106_y();
/*     */   }
/*     */   
/*     */   public boolean func_70067_L() {
/* 878 */     return true;
/*     */   }
/*     */   
/*     */   public float func_70111_Y() {
/* 882 */     return 1.0F;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource ds, float par2) {
/* 886 */     if (func_85032_ar())
/* 887 */       return false; 
/* 888 */     if (!this.field_70170_p.field_72995_K && par2 > 0.0F && ds.func_76355_l().equalsIgnoreCase("thrown")) {
/* 889 */       func_70018_K();
/* 890 */       MovingObjectPosition m = new MovingObjectPosition((int)(this.field_70165_t + 0.5D), (int)(this.field_70163_u + 0.5D), (int)(this.field_70161_v + 0.5D), 0, Vec3.func_72443_a(this.field_70165_t + 0.5D, this.field_70163_u + 0.5D, this.field_70161_v + 0.5D));
/* 891 */       onImpact(m, 1.0F);
/* 892 */       return true;
/*     */     } 
/* 894 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 900 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public float func_70013_c(float par1) {
/* 904 */     return 1.0F;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public int func_70070_b(float par1) {
/* 909 */     return 15728880;
/*     */   }
/*     */   
/*     */   public int getPower() {
/* 913 */     return this.power;
/*     */   }
/*     */   
/*     */   public void setPower(int power) {
/* 917 */     this.power = power;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_EntityBaseBullet.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */