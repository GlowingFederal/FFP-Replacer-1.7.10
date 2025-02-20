/*     */ package mcheli.gltd;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.MCH_Camera;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.multiplay.MCH_Multiplay;
/*     */ import mcheli.weapon.MCH_WeaponCAS;
/*     */ import mcheli.weapon.MCH_WeaponInfo;
/*     */ import mcheli.weapon.MCH_WeaponInfoManager;
/*     */ import mcheli.wrapper.W_Block;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_EntityGLTD
/*     */   extends W_Entity {
/*     */   private boolean field_70279_a;
/*     */   private double speedMultiplier;
/*     */   private int gltdPosRotInc;
/*     */   private double gltdX;
/*     */   private double gltdY;
/*     */   private double gltdZ;
/*     */   private double gltdYaw;
/*     */   private double gltdPitch;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityX;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityY;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityZ;
/*     */   public final MCH_Camera camera;
/*     */   public boolean zoomDir;
/*     */   public final MCH_WeaponCAS weaponCAS;
/*     */   public int countWait;
/*     */   public boolean isUsedPlayer;
/*     */   public float renderRotaionYaw;
/*     */   public float renderRotaionPitch;
/*     */   public int retryRiddenByEntityCheck;
/*     */   public Entity lastRiddenByEntity;
/*     */   
/*     */   public MCH_EntityGLTD(World world) {
/*  52 */     super(world);
/*  53 */     this.field_70279_a = true;
/*  54 */     this.speedMultiplier = 0.07D;
/*  55 */     this.field_70156_m = true;
/*  56 */     func_70105_a(0.5F, 0.5F);
/*  57 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  58 */     this.camera = new MCH_Camera(world, (Entity)this);
/*  59 */     MCH_WeaponInfo wi = MCH_WeaponInfoManager.get("a10gau8");
/*  60 */     this.weaponCAS = new MCH_WeaponCAS(world, Vec3.func_72443_a(0.0D, 0.0D, 0.0D), 0.0F, 0.0F, "a10gau8", wi);
/*  61 */     this.weaponCAS.interval += (this.weaponCAS.interval > 0) ? 150 : -150;
/*  62 */     this.weaponCAS.displayName = "A-10 GAU-8 Avenger";
/*  63 */     this.field_70158_ak = true;
/*  64 */     this.countWait = 0;
/*  65 */     this.retryRiddenByEntityCheck = 0;
/*  66 */     this.lastRiddenByEntity = null;
/*  67 */     this.isUsedPlayer = false;
/*  68 */     this.renderRotaionYaw = 0.0F;
/*  69 */     this.renderRotaionYaw = 0.0F;
/*  70 */     this.renderRotaionPitch = 0.0F;
/*  71 */     this.zoomDir = true;
/*  72 */     this.field_70155_l = 2.0D;
/*     */   }
/*     */   
/*     */   public MCH_EntityGLTD(World par1World, double x, double y, double z) {
/*  76 */     this(par1World);
/*  77 */     func_70107_b(x, y + this.field_70129_M, z);
/*  78 */     this.field_70159_w = 0.0D;
/*  79 */     this.field_70181_x = 0.0D;
/*  80 */     this.field_70179_y = 0.0D;
/*  81 */     this.field_70169_q = x;
/*  82 */     this.field_70167_r = y;
/*  83 */     this.field_70166_s = z;
/*  84 */     this.camera.setPosition(x, y, z);
/*     */   }
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  88 */     return false;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  92 */     this.field_70180_af.func_75682_a(17, new Integer(0));
/*  93 */     this.field_70180_af.func_75682_a(18, new Integer(1));
/*  94 */     this.field_70180_af.func_75682_a(19, new Integer(0));
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/*  98 */     return par1Entity.field_70121_D;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/* 102 */     return this.field_70121_D;
/*     */   }
/*     */   
/*     */   public boolean func_70104_M() {
/* 106 */     return false;
/*     */   }
/*     */   
/*     */   public double func_70042_X() {
/* 110 */     return this.field_70131_O * 0.0D - 0.3D;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource ds, float damage) {
/* 114 */     if (func_85032_ar())
/* 115 */       return false; 
/* 116 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
/* 117 */       MCH_Config var10000 = MCH_MOD.config;
/* 118 */       damage = MCH_Config.applyDamageByExternal((Entity)this, ds, damage);
/* 119 */       if (!MCH_Multiplay.canAttackEntity(ds, (Entity)this)) {
/* 120 */         return false;
/*     */       }
/* 122 */       setForwardDirection(-getForwardDirection());
/* 123 */       setTimeSinceHit(10);
/* 124 */       setDamageTaken((int)(getDamageTaken() + damage * 100.0F));
/* 125 */       func_70018_K();
/* 126 */       boolean flag = (ds.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)ds.func_76346_g()).field_71075_bZ.field_75098_d);
/* 127 */       if (flag || getDamageTaken() > 40.0F) {
/* 128 */         this.camera.initCamera(0, this.field_70153_n);
/* 129 */         if (this.field_70153_n != null) {
/* 130 */           this.field_70153_n.func_70078_a((Entity)this);
/*     */         }
/*     */         
/* 133 */         if (!flag) {
/* 134 */           dropItemWithOffset((Item)MCH_MOD.itemGLTD, 1, 0.0F);
/*     */         }
/*     */         
/* 137 */         W_WorldFunc.MOD_playSoundEffect(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, "hit", 1.0F, 1.0F);
/* 138 */         func_70106_y();
/*     */       } 
/*     */       
/* 141 */       return true;
/*     */     } 
/*     */     
/* 144 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70057_ab() {}
/*     */   
/*     */   public boolean func_70067_L() {
/* 152 */     return !this.field_70128_L;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 157 */     if (this.field_70279_a) {
/* 158 */       this.gltdPosRotInc = par9 + 5;
/*     */     } else {
/* 160 */       double x = par1 - this.field_70165_t;
/* 161 */       double y = par3 - this.field_70163_u;
/* 162 */       double z = par5 - this.field_70161_v;
/* 163 */       if (x * x + y * y + z * z <= 1.0D) {
/*     */         return;
/*     */       }
/*     */       
/* 167 */       this.gltdPosRotInc = 3;
/*     */     } 
/*     */     
/* 170 */     this.gltdX = par1;
/* 171 */     this.gltdY = par3;
/* 172 */     this.gltdZ = par5;
/* 173 */     this.gltdYaw = par7;
/* 174 */     this.gltdPitch = par8;
/* 175 */     this.field_70159_w = this.velocityX;
/* 176 */     this.field_70181_x = this.velocityY;
/* 177 */     this.field_70179_y = this.velocityZ;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double x, double y, double z) {
/* 182 */     this.velocityX = this.field_70159_w = x;
/* 183 */     this.velocityY = this.field_70181_x = y;
/* 184 */     this.velocityZ = this.field_70179_y = z;
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/* 188 */     super.func_70071_h_();
/* 189 */     if (getTimeSinceHit() > 0) {
/* 190 */       setTimeSinceHit(getTimeSinceHit() - 1);
/*     */     }
/*     */     
/* 193 */     if (getDamageTaken() > 0.0F) {
/* 194 */       setDamageTaken(getDamageTaken() - 1);
/*     */     }
/*     */     
/* 197 */     this.field_70169_q = this.field_70165_t;
/* 198 */     this.field_70167_r = this.field_70163_u;
/* 199 */     this.field_70166_s = this.field_70161_v;
/* 200 */     double d3 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 201 */     if (this.field_70153_n != null) {
/* 202 */       this.camera.updateViewer(0, this.field_70153_n);
/*     */     }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 209 */     if (this.field_70170_p.field_72995_K && this.field_70279_a) {
/* 210 */       if (this.gltdPosRotInc > 0) {
/* 211 */         double d4 = this.field_70165_t + (this.gltdX - this.field_70165_t) / this.gltdPosRotInc;
/* 212 */         double d5 = this.field_70163_u + (this.gltdY - this.field_70163_u) / this.gltdPosRotInc;
/* 213 */         double d11 = this.field_70161_v + (this.gltdZ - this.field_70161_v) / this.gltdPosRotInc;
/* 214 */         double d10 = MathHelper.func_76138_g(this.gltdYaw - this.field_70177_z);
/* 215 */         this.field_70177_z = (float)(this.field_70177_z + d10 / this.gltdPosRotInc);
/* 216 */         this.field_70125_A = (float)(this.field_70125_A + (this.gltdPitch - this.field_70125_A) / this.gltdPosRotInc);
/* 217 */         this.gltdPosRotInc--;
/* 218 */         func_70107_b(d4, d5, d11);
/* 219 */         func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       } else {
/* 221 */         double d4 = this.field_70165_t + this.field_70159_w;
/* 222 */         double d5 = this.field_70163_u + this.field_70181_x;
/* 223 */         double d11 = this.field_70161_v + this.field_70179_y;
/* 224 */         func_70107_b(d4, d5, d11);
/* 225 */         if (this.field_70122_E) {
/* 226 */           this.field_70159_w *= 0.5D;
/* 227 */           this.field_70181_x *= 0.5D;
/* 228 */           this.field_70179_y *= 0.5D;
/*     */         } 
/*     */         
/* 231 */         this.field_70159_w *= 0.99D;
/* 232 */         this.field_70181_x *= 0.95D;
/* 233 */         this.field_70179_y *= 0.99D;
/*     */       } 
/*     */     } else {
/* 236 */       this.field_70181_x -= 0.04D;
/* 237 */       double d4 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 238 */       if (d4 > 0.35D) {
/* 239 */         double d = 0.35D / d4;
/* 240 */         this.field_70159_w *= d;
/* 241 */         this.field_70179_y *= d;
/* 242 */         d4 = 0.35D;
/*     */       } 
/*     */       
/* 245 */       if (d4 > d3 && this.speedMultiplier < 0.35D) {
/* 246 */         this.speedMultiplier += (0.35D - this.speedMultiplier) / 35.0D;
/* 247 */         if (this.speedMultiplier > 0.35D) {
/* 248 */           this.speedMultiplier = 0.35D;
/*     */         }
/*     */       } else {
/* 251 */         this.speedMultiplier -= (this.speedMultiplier - 0.07D) / 35.0D;
/* 252 */         if (this.speedMultiplier < 0.07D) {
/* 253 */           this.speedMultiplier = 0.07D;
/*     */         }
/*     */       } 
/*     */       
/* 257 */       if (this.field_70122_E) {
/* 258 */         this.field_70159_w *= 0.5D;
/* 259 */         this.field_70181_x *= 0.5D;
/* 260 */         this.field_70179_y *= 0.5D;
/*     */       } 
/*     */       
/* 263 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 264 */       this.field_70159_w *= 0.99D;
/* 265 */       this.field_70181_x *= 0.95D;
/* 266 */       this.field_70179_y *= 0.99D;
/* 267 */       this.field_70125_A = 0.0F;
/* 268 */       double d5 = this.field_70177_z;
/* 269 */       double d11 = this.field_70169_q - this.field_70165_t;
/* 270 */       double d10 = this.field_70166_s - this.field_70161_v;
/* 271 */       if (d11 * d11 + d10 * d10 > 0.001D) {
/* 272 */         d5 = (float)(Math.atan2(d10, d11) * 180.0D / Math.PI);
/*     */       }
/*     */       
/* 275 */       double d12 = MathHelper.func_76138_g(d5 - this.field_70177_z);
/* 276 */       if (d12 > 20.0D) {
/* 277 */         d12 = 20.0D;
/*     */       }
/*     */       
/* 280 */       if (d12 < -20.0D) {
/* 281 */         d12 = -20.0D;
/*     */       }
/*     */       
/* 284 */       this.field_70177_z = (float)(this.field_70177_z + d12);
/* 285 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/* 286 */       if (!this.field_70170_p.field_72995_K) {
/* 287 */         MCH_Config var10000 = MCH_MOD.config;
/* 288 */         if (MCH_Config.Collision_DestroyBlock.prmBool) {
/* 289 */           for (int l = 0; l < 4; l++) {
/* 290 */             int i1 = MathHelper.func_76128_c(this.field_70165_t + ((l % 2) - 0.5D) * 0.8D);
/* 291 */             int j1 = MathHelper.func_76128_c(this.field_70161_v + ((l / 2) - 0.5D) * 0.8D);
/*     */             
/* 293 */             for (int k1 = 0; k1 < 2; k1++) {
/* 294 */               int l1 = MathHelper.func_76128_c(this.field_70163_u) + k1;
/* 295 */               if (W_WorldFunc.isEqualBlock(this.field_70170_p, i1, l1, j1, W_Block.getSnowLayer())) {
/* 296 */                 this.field_70170_p.func_147468_f(i1, l1, j1);
/*     */               }
/*     */             } 
/*     */           } 
/*     */         }
/*     */         
/* 302 */         if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
/* 303 */           this.field_70153_n = null;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 308 */     updateCameraPosition(false);
/* 309 */     if (this.countWait > 0) {
/* 310 */       this.countWait--;
/*     */     }
/*     */     
/* 313 */     if (this.countWait < 0) {
/* 314 */       this.countWait++;
/*     */     }
/*     */     
/* 317 */     this.weaponCAS.update(this.countWait);
/* 318 */     if (this.lastRiddenByEntity != null && this.field_70153_n == null) {
/* 319 */       if (this.retryRiddenByEntityCheck < 3) {
/* 320 */         this.retryRiddenByEntityCheck++;
/* 321 */         setUnmoundPosition(this.lastRiddenByEntity);
/*     */       } else {
/* 323 */         unmountEntity();
/*     */       } 
/*     */     } else {
/* 326 */       this.retryRiddenByEntityCheck = 0;
/*     */     } 
/*     */     
/* 329 */     if (this.field_70153_n != null) {
/* 330 */       this.lastRiddenByEntity = this.field_70153_n;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void setUnmoundPosition(Entity e) {
/* 336 */     if (e != null) {
/* 337 */       float yaw = this.field_70177_z;
/* 338 */       double d0 = Math.sin(yaw * Math.PI / 180.0D) * 1.2D;
/* 339 */       double d1 = -Math.cos(yaw * Math.PI / 180.0D) * 1.2D;
/* 340 */       e.func_70107_b(this.field_70165_t + d0, this.field_70163_u + func_70042_X() + e.func_70033_W() + 1.0D, this.field_70161_v + d1);
/* 341 */       e.field_70142_S = e.field_70169_q = e.field_70165_t;
/* 342 */       e.field_70137_T = e.field_70167_r = e.field_70163_u;
/* 343 */       e.field_70136_U = e.field_70166_s = e.field_70161_v;
/*     */     } 
/*     */   }
/*     */   
/*     */   public void unmountEntity() {
/* 348 */     this.camera.setMode(0, 0);
/* 349 */     this.camera.setCameraZoom(1.0F);
/* 350 */     if (!this.field_70170_p.field_72995_K) {
/* 351 */       if (this.field_70153_n != null) {
/* 352 */         if (!this.field_70153_n.field_70128_L) {
/* 353 */           this.field_70153_n.func_70078_a((Entity)null);
/*     */         }
/* 355 */       } else if (this.lastRiddenByEntity != null && !this.lastRiddenByEntity.field_70128_L) {
/* 356 */         this.camera.updateViewer(0, this.lastRiddenByEntity);
/* 357 */         setUnmoundPosition(this.lastRiddenByEntity);
/*     */       } 
/*     */     }
/*     */     
/* 361 */     this.field_70153_n = null;
/* 362 */     this.lastRiddenByEntity = null;
/*     */   }
/*     */   
/*     */   public void updateCameraPosition(boolean foreceUpdate) {
/* 366 */     if (foreceUpdate || (this.field_70153_n != null && this.camera != null)) {
/* 367 */       double x = -Math.sin(this.field_70177_z * Math.PI / 180.0D) * 0.6D;
/* 368 */       double z = Math.cos(this.field_70177_z * Math.PI / 180.0D) * 0.6D;
/* 369 */       this.camera.setPosition(this.field_70165_t + x, this.field_70163_u + 0.7D, this.field_70161_v + z);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void zoomCamera(float f) {
/* 376 */     float z = this.camera.getCameraZoom();
/* 377 */     z += f;
/* 378 */     if (z < 1.0F) {
/* 379 */       z = 1.0F;
/*     */     }
/*     */     
/* 382 */     if (z > 10.0F) {
/* 383 */       z = 10.0F;
/*     */     }
/*     */     
/* 386 */     this.camera.setCameraZoom(z);
/*     */   }
/*     */   
/*     */   public void func_70043_V() {
/* 390 */     if (this.field_70153_n != null) {
/* 391 */       double x = Math.sin(this.field_70177_z * Math.PI / 180.0D) * 0.5D;
/* 392 */       double z = -Math.cos(this.field_70177_z * Math.PI / 180.0D) * 0.5D;
/* 393 */       this.field_70153_n.func_70107_b(this.field_70165_t + x, this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + z);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void switchWeapon(int id) {}
/*     */   
/*     */   public boolean useCurrentWeapon(int option1, int option2) {
/* 401 */     if (this.countWait == 0 && this.field_70153_n != null && this.weaponCAS.shot(this.field_70153_n, this.camera.posX, this.camera.posY, this.camera.posZ, option1, option2)) {
/* 402 */       this.countWait = this.weaponCAS.interval;
/* 403 */       if (this.field_70170_p.field_72995_K) {
/* 404 */         this.countWait += (this.countWait > 0) ? 10 : -10;
/*     */       } else {
/* 406 */         W_WorldFunc.MOD_playSoundEffect(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, "gltd", 0.5F, 1.0F);
/*     */       } 
/*     */       
/* 409 */       return true;
/*     */     } 
/* 411 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {}
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 421 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer player) {
/* 425 */     if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer && this.field_70153_n != player) {
/* 426 */       return true;
/*     */     }
/* 428 */     player.field_70177_z = MathHelper.func_76142_g(this.field_70177_z);
/* 429 */     player.field_70125_A = MathHelper.func_76142_g(this.field_70125_A);
/* 430 */     if (!this.field_70170_p.field_72995_K) {
/* 431 */       player.func_70078_a((Entity)this);
/*     */     } else {
/* 433 */       this.zoomDir = true;
/* 434 */       this.camera.setCameraZoom(1.0F);
/* 435 */       if (this.countWait > 0) {
/* 436 */         this.countWait = -this.countWait;
/*     */       }
/*     */       
/* 439 */       if (this.countWait > -60) {
/* 440 */         this.countWait = -60;
/*     */       }
/*     */     } 
/*     */     
/* 444 */     updateCameraPosition(true);
/* 445 */     return true;
/*     */   }
/*     */ 
/*     */   
/*     */   public void setDamageTaken(int par1) {
/* 450 */     this.field_70180_af.func_75692_b(19, Integer.valueOf(par1));
/*     */   }
/*     */   
/*     */   public int getDamageTaken() {
/* 454 */     return this.field_70180_af.func_75679_c(19);
/*     */   }
/*     */   
/*     */   public void setTimeSinceHit(int par1) {
/* 458 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(par1));
/*     */   }
/*     */   
/*     */   public int getTimeSinceHit() {
/* 462 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */   
/*     */   public void setForwardDirection(int par1) {
/* 466 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(par1));
/*     */   }
/*     */   
/*     */   public int getForwardDirection() {
/* 470 */     return 0;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70270_d(boolean par1) {
/* 475 */     this.field_70279_a = par1;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gltd\MCH_EntityGLTD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */