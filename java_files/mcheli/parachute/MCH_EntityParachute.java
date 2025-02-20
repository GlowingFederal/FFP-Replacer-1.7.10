/*     */ package mcheli.parachute;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.particles.MCH_ParticleParam;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.wrapper.W_AxisAlignedBB;
/*     */ import mcheli.wrapper.W_Block;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.item.EntityBoat;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_EntityParachute
/*     */   extends W_Entity
/*     */ {
/*     */   private double speedMultiplier;
/*     */   private int paraPosRotInc;
/*     */   private double paraX;
/*     */   private double paraY;
/*     */   private double paraZ;
/*     */   private double paraYaw;
/*     */   
/*     */   public MCH_EntityParachute(World par1World) {
/*  42 */     super(par1World);
/*  43 */     this.speedMultiplier = 0.07D;
/*  44 */     this.field_70156_m = true;
/*  45 */     func_70105_a(1.5F, 0.6F);
/*  46 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  47 */     this.user = null;
/*  48 */     this.onGroundCount = 0; } private double paraPitch; @SideOnly(Side.CLIENT)
/*     */   private double velocityX; @SideOnly(Side.CLIENT)
/*     */   private double velocityY; @SideOnly(Side.CLIENT)
/*     */   private double velocityZ; public Entity user; public int onGroundCount; public MCH_EntityParachute(World par1World, double par2, double par4, double par6) {
/*  52 */     this(par1World);
/*  53 */     func_70107_b(par2, par4 + this.field_70129_M, par6);
/*  54 */     this.field_70159_w = 0.0D;
/*  55 */     this.field_70181_x = 0.0D;
/*  56 */     this.field_70179_y = 0.0D;
/*  57 */     this.field_70169_q = par2;
/*  58 */     this.field_70167_r = par4;
/*  59 */     this.field_70166_s = par6;
/*     */   }
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  63 */     return false;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  67 */     func_70096_w().func_75682_a(31, Byte.valueOf((byte)0));
/*     */   }
/*     */   
/*     */   public void setType(int n) {
/*  71 */     func_70096_w().func_75692_b(31, Byte.valueOf((byte)n));
/*     */   }
/*     */   
/*     */   public int getType() {
/*  75 */     return func_70096_w().func_75683_a(31);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/*  79 */     return par1Entity.field_70121_D;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/*  83 */     return this.field_70121_D;
/*     */   }
/*     */   
/*     */   public boolean func_70104_M() {
/*  87 */     return true;
/*     */   }
/*     */   
/*     */   public double func_70042_X() {
/*  91 */     return this.field_70131_O * 0.0D - 0.30000001192092896D;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/*  95 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_70067_L() {
/*  99 */     return !this.field_70128_L;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 104 */     this.paraPosRotInc = par9 + 10;
/* 105 */     this.paraX = par1;
/* 106 */     this.paraY = par3;
/* 107 */     this.paraZ = par5;
/* 108 */     this.paraYaw = par7;
/* 109 */     this.paraPitch = par8;
/* 110 */     this.field_70159_w = this.velocityX;
/* 111 */     this.field_70181_x = this.velocityY;
/* 112 */     this.field_70179_y = this.velocityZ;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 117 */     this.velocityX = this.field_70159_w = par1;
/* 118 */     this.velocityY = this.field_70181_x = par3;
/* 119 */     this.velocityZ = this.field_70179_y = par5;
/*     */   }
/*     */   
/*     */   public void func_70106_y() {
/* 123 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/* 127 */     super.func_70071_h_();
/* 128 */     if (!this.field_70170_p.field_72995_K && this.field_70173_aa % 10 == 0) {
/* 129 */       MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityParachute.onUpdate %d, %.3f", new Object[] { Integer.valueOf(this.field_70173_aa), Double.valueOf(this.field_70181_x) });
/*     */     }
/*     */     
/* 132 */     if (isOpenParachute() && this.field_70181_x > -0.3D && this.field_70173_aa > 20) {
/* 133 */       this.field_70143_R = (float)(this.field_70143_R * 0.85D);
/*     */     }
/*     */     
/* 136 */     if (!this.field_70170_p.field_72995_K && this.user != null && this.user.field_70154_o == null) {
/* 137 */       this.user.func_70078_a((Entity)this);
/* 138 */       this.field_70177_z = this.field_70126_B = this.user.field_70177_z;
/* 139 */       this.user = null;
/*     */     } 
/*     */     
/* 142 */     this.field_70169_q = this.field_70165_t;
/* 143 */     this.field_70167_r = this.field_70163_u;
/* 144 */     this.field_70166_s = this.field_70161_v;
/* 145 */     double d1 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 0.0D / 5.0D - 0.125D;
/* 146 */     double d2 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 1.0D / 5.0D - 0.125D;
/* 147 */     AxisAlignedBB axisalignedbb = W_AxisAlignedBB.getAABB(this.field_70121_D.field_72340_a, d1, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d2, this.field_70121_D.field_72334_f);
/* 148 */     if (this.field_70170_p.func_72830_b(axisalignedbb, Material.field_151586_h)) {
/* 149 */       onWaterSetBoat();
/* 150 */       func_70106_y();
/*     */     } 
/*     */     
/* 153 */     if (this.field_70170_p.field_72995_K) {
/* 154 */       onUpdateClient();
/*     */     } else {
/* 156 */       onUpdateServer();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdateClient() {
/* 162 */     if (this.paraPosRotInc > 0) {
/* 163 */       double color = this.field_70165_t + (this.paraX - this.field_70165_t) / this.paraPosRotInc;
/* 164 */       double y = this.field_70163_u + (this.paraY - this.field_70163_u) / this.paraPosRotInc;
/* 165 */       double z = this.field_70161_v + (this.paraZ - this.field_70161_v) / this.paraPosRotInc;
/* 166 */       double yaw = MathHelper.func_76138_g(this.paraYaw - this.field_70177_z);
/* 167 */       this.field_70177_z = (float)(this.field_70177_z + yaw / this.paraPosRotInc);
/* 168 */       this.field_70125_A = (float)(this.field_70125_A + (this.paraPitch - this.field_70125_A) / this.paraPosRotInc);
/* 169 */       this.paraPosRotInc--;
/* 170 */       func_70107_b(color, y, z);
/* 171 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/* 172 */       if (this.field_70153_n != null) {
/* 173 */         func_70101_b(this.field_70153_n.field_70126_B, this.field_70125_A);
/*     */       }
/*     */     } else {
/* 176 */       func_70107_b(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 177 */       if (this.field_70122_E);
/*     */ 
/*     */ 
/*     */       
/* 181 */       this.field_70159_w *= 0.99D;
/* 182 */       this.field_70181_x *= 0.95D;
/* 183 */       this.field_70179_y *= 0.99D;
/*     */     } 
/*     */     
/* 186 */     if (!isOpenParachute() && this.field_70181_x > 0.01D) {
/* 187 */       float var12 = 0.6F + this.field_70146_Z.nextFloat() * 0.2F;
/* 188 */       double dx = this.field_70169_q - this.field_70165_t;
/* 189 */       double dy = this.field_70167_r - this.field_70163_u;
/* 190 */       double dz = this.field_70166_s - this.field_70161_v;
/* 191 */       int num = 1 + (int)(MathHelper.func_76133_a(dx * dx + dy * dy + dz * dz) * 2.0D);
/*     */       double i;
/* 193 */       for (i = 0.0D; i < num; i++) {
/* 194 */         MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", this.field_70169_q + (this.field_70165_t - this.field_70169_q) * i / num * 0.8D, this.field_70167_r + (this.field_70163_u - this.field_70167_r) * i / num * 0.8D, this.field_70166_s + (this.field_70161_v - this.field_70166_s) * i / num * 0.8D);
/* 195 */         prm.motionX = this.field_70159_w * 0.5D + (this.field_70146_Z.nextDouble() - 0.5D) * 0.5D;
/* 196 */         prm.motionX = this.field_70181_x * -0.5D + (this.field_70146_Z.nextDouble() - 0.5D) * 0.5D;
/* 197 */         prm.motionX = this.field_70179_y * 0.5D + (this.field_70146_Z.nextDouble() - 0.5D) * 0.5D;
/* 198 */         prm.size = 5.0F;
/* 199 */         prm.setColor(0.8F + this.field_70146_Z.nextFloat(), var12, var12, var12);
/* 200 */         MCH_ParticlesUtil.spawnParticle(prm);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdateServer() {
/* 207 */     double prevSpeed = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 208 */     double gravity = this.field_70122_E ? 0.01D : 0.03D;
/* 209 */     if (getType() == 2 && this.field_70173_aa < 20) {
/* 210 */       gravity = 0.01D;
/*     */     }
/*     */     
/* 213 */     this.field_70181_x -= gravity;
/*     */ 
/*     */ 
/*     */     
/* 217 */     if (isOpenParachute()) {
/* 218 */       if (W_Lib.isEntityLivingBase(this.field_70153_n)) {
/* 219 */         double d1 = W_Lib.getEntityMoveDist(this.field_70153_n);
/* 220 */         if (!isOpenParachute()) {
/* 221 */           d1 = 0.0D;
/*     */         }
/*     */         
/* 224 */         if (d1 > 0.0D) {
/* 225 */           double d2 = -Math.sin((this.field_70153_n.field_70177_z * 3.1415927F / 180.0F));
/* 226 */           double d3 = Math.cos((this.field_70153_n.field_70177_z * 3.1415927F / 180.0F));
/* 227 */           this.field_70159_w += d2 * this.speedMultiplier * 0.05D;
/* 228 */           this.field_70179_y += d3 * this.speedMultiplier * 0.05D;
/*     */         } 
/*     */       } 
/*     */       
/* 232 */       double d = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 233 */       if (d > 0.35D) {
/* 234 */         this.field_70159_w *= 0.35D / d;
/* 235 */         this.field_70179_y *= 0.35D / d;
/* 236 */         d = 0.35D;
/*     */       } 
/*     */       
/* 239 */       if (d > prevSpeed && this.speedMultiplier < 0.35D) {
/* 240 */         this.speedMultiplier += (0.35D - this.speedMultiplier) / 35.0D;
/* 241 */         if (this.speedMultiplier > 0.35D) {
/* 242 */           this.speedMultiplier = 0.35D;
/*     */         }
/*     */       } else {
/* 245 */         this.speedMultiplier -= (this.speedMultiplier - 0.07D) / 35.0D;
/* 246 */         if (this.speedMultiplier < 0.07D) {
/* 247 */           this.speedMultiplier = 0.07D;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 252 */     if (this.field_70122_E) {
/* 253 */       this.onGroundCount++;
/* 254 */       if (this.onGroundCount > 5) {
/* 255 */         onGroundAndDead();
/*     */         
/*     */         return;
/*     */       } 
/*     */     } 
/* 260 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 261 */     if (getType() == 2 && this.field_70173_aa < 20) {
/* 262 */       this.field_70181_x *= 0.95D;
/*     */     } else {
/* 264 */       this.field_70181_x *= 0.9D;
/*     */     } 
/*     */     
/* 267 */     if (isOpenParachute()) {
/* 268 */       this.field_70159_w *= 0.95D;
/* 269 */       this.field_70179_y *= 0.95D;
/*     */     } else {
/* 271 */       this.field_70159_w *= 0.99D;
/* 272 */       this.field_70179_y *= 0.99D;
/*     */     } 
/*     */     
/* 275 */     this.field_70125_A = 0.0F;
/* 276 */     double yaw = this.field_70177_z;
/* 277 */     double dx = this.field_70169_q - this.field_70165_t;
/* 278 */     double dz = this.field_70166_s - this.field_70161_v;
/* 279 */     if (dx * dx + dz * dz > 0.001D) {
/* 280 */       yaw = (float)(Math.atan2(dx, dz) * 180.0D / Math.PI);
/*     */     }
/*     */     
/* 283 */     double yawDiff = MathHelper.func_76138_g(yaw - this.field_70177_z);
/* 284 */     if (yawDiff > 20.0D) {
/* 285 */       yawDiff = 20.0D;
/*     */     }
/*     */     
/* 288 */     if (yawDiff < -20.0D) {
/* 289 */       yawDiff = -20.0D;
/*     */     }
/*     */     
/* 292 */     if (this.field_70153_n != null) {
/* 293 */       func_70101_b(this.field_70153_n.field_70177_z, this.field_70125_A);
/*     */     } else {
/* 295 */       this.field_70177_z = (float)(this.field_70177_z + yawDiff);
/* 296 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */     } 
/*     */     
/* 299 */     List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(0.2D, 0.0D, 0.2D));
/* 300 */     if (list != null && !list.isEmpty()) {
/* 301 */       for (int l = 0; l < list.size(); l++) {
/* 302 */         Entity entity = list.get(l);
/* 303 */         if (entity != this.field_70153_n && entity.func_70104_M() && entity instanceof MCH_EntityParachute) {
/* 304 */           entity.func_70108_f((Entity)this);
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/* 309 */     if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
/* 310 */       this.field_70153_n = null;
/* 311 */       func_70106_y();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onGroundAndDead() {
/* 317 */     this.field_70163_u++;
/* 318 */     func_70043_V();
/* 319 */     func_70106_y();
/*     */   }
/*     */   
/*     */   public void onWaterSetBoat() {
/* 323 */     if (!this.field_70170_p.field_72995_K && 
/* 324 */       getType() == 2 && 
/* 325 */       this.field_70153_n != null) {
/* 326 */       int px = (int)(this.field_70165_t + 0.5D);
/* 327 */       int py = (int)(this.field_70163_u + 0.5D);
/* 328 */       int pz = (int)(this.field_70161_v + 0.5D);
/* 329 */       boolean foundBlock = false;
/*     */       
/*     */       int countWater;
/* 332 */       for (countWater = 0; countWater < 5 && py + countWater >= 0 && py + countWater <= 255; countWater++) {
/* 333 */         Block size = W_WorldFunc.getBlock(this.field_70170_p, px, py - countWater, pz);
/* 334 */         if (size == W_Block.getWater()) {
/* 335 */           py -= countWater;
/* 336 */           foundBlock = true;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 341 */       if (foundBlock) {
/* 342 */         countWater = 0;
/* 343 */         boolean var11 = true;
/*     */         
/* 345 */         for (int entityboat = 0; entityboat < 3 && py + entityboat >= 0 && py + entityboat <= 255; entityboat++) {
/* 346 */           int x = -2;
/*     */           
/* 348 */           while (x <= 2) {
/* 349 */             int z = -2;
/*     */ 
/*     */             
/* 352 */             while (z <= 2) {
/*     */               
/* 354 */               Block block = W_WorldFunc.getBlock(this.field_70170_p, px + x, py - entityboat, pz + z);
/*     */               
/* 356 */               countWater++;
/* 357 */               if (block == W_Block.getWater() && countWater > 37) {
/*     */                 break;
/*     */               }
/*     */ 
/*     */               
/* 362 */               z++;
/*     */             } 
/*     */ 
/*     */ 
/*     */             
/* 367 */             x++;
/*     */           } 
/*     */         } 
/*     */ 
/*     */ 
/*     */         
/* 373 */         if (countWater > 37) {
/* 374 */           EntityBoat var12 = new EntityBoat(this.field_70170_p, px, (py + 1.0F), pz);
/* 375 */           var12.field_70177_z = this.field_70177_z - 90.0F;
/* 376 */           this.field_70170_p.func_72838_d((Entity)var12);
/* 377 */           this.field_70153_n.func_70078_a((Entity)var12);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean isOpenParachute() {
/* 387 */     return (getType() != 2 || this.field_70181_x < -0.1D);
/*     */   }
/*     */   
/*     */   public void func_70043_V() {
/* 391 */     if (this.field_70153_n != null) {
/* 392 */       double x = -Math.sin(this.field_70177_z * Math.PI / 180.0D) * 0.1D;
/* 393 */       double z = Math.cos(this.field_70177_z * Math.PI / 180.0D) * 0.1D;
/* 394 */       this.field_70153_n.func_70107_b(this.field_70165_t + x, this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + z);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound nbt) {
/* 400 */     nbt.func_74774_a("ParachuteModelType", (byte)getType());
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound nbt) {
/* 404 */     setType(nbt.func_74771_c("ParachuteModelType"));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 409 */     return 4.0F;
/*     */   }
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer par1EntityPlayer) {
/* 413 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\parachute\MCH_EntityParachute.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */