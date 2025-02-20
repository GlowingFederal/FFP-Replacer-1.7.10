/*     */ package mcheli.container;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_IEntityCanRideAircraft;
/*     */ import mcheli.aircraft.MCH_SeatRackInfo;
/*     */ import mcheli.multiplay.MCH_Multiplay;
/*     */ import mcheli.wrapper.W_AxisAlignedBB;
/*     */ import mcheli.wrapper.W_Block;
/*     */ import mcheli.wrapper.W_EntityContainer;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_EntityContainer
/*     */   extends W_EntityContainer
/*     */   implements MCH_IEntityCanRideAircraft
/*     */ {
/*     */   private boolean field_70279_a;
/*     */   private double speedMultiplier;
/*     */   private int boatPosRotationIncrements;
/*     */   private double boatX;
/*     */   private double boatY;
/*     */   private double boatZ;
/*     */   private double boatYaw;
/*     */   private double boatPitch;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityX;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityY;
/*     */   @SideOnly(Side.CLIENT)
/*     */   private double velocityZ;
/*     */   
/*     */   public MCH_EntityContainer(World par1World) {
/*  48 */     super(par1World);
/*  49 */     this.speedMultiplier = 0.07D;
/*  50 */     this.field_70156_m = true;
/*  51 */     func_70105_a(2.0F, 1.0F);
/*  52 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  53 */     this.field_70138_W = 0.6F;
/*  54 */     this.field_70178_ae = true;
/*  55 */     this.field_70155_l = 2.0D;
/*     */   }
/*     */   
/*     */   public MCH_EntityContainer(World par1World, double par2, double par4, double par6) {
/*  59 */     this(par1World);
/*  60 */     func_70107_b(par2, par4 + this.field_70129_M, par6);
/*  61 */     this.field_70159_w = 0.0D;
/*  62 */     this.field_70181_x = 0.0D;
/*  63 */     this.field_70179_y = 0.0D;
/*  64 */     this.field_70169_q = par2;
/*  65 */     this.field_70167_r = par4;
/*  66 */     this.field_70166_s = par6;
/*     */   }
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  70 */     return false;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  74 */     this.field_70180_af.func_75682_a(17, new Integer(0));
/*  75 */     this.field_70180_af.func_75682_a(18, new Integer(1));
/*  76 */     this.field_70180_af.func_75682_a(19, new Integer(0));
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/*  80 */     return par1Entity.field_70121_D;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/*  84 */     return this.field_70121_D;
/*     */   }
/*     */   
/*     */   public boolean func_70104_M() {
/*  88 */     return true;
/*     */   }
/*     */   
/*     */   public int func_70302_i_() {
/*  92 */     return 54;
/*     */   }
/*     */   
/*     */   public String getInvName() {
/*  96 */     return "Container " + super.getInvName();
/*     */   }
/*     */   
/*     */   public double func_70042_X() {
/* 100 */     return -0.3D;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource ds, float damage) {
/* 104 */     if (func_85032_ar())
/* 105 */       return false; 
/* 106 */     if (!this.field_70170_p.field_72995_K && !this.field_70128_L) {
/* 107 */       MCH_Config var10000 = MCH_MOD.config;
/* 108 */       damage = MCH_Config.applyDamageByExternal((Entity)this, ds, damage);
/* 109 */       if (!MCH_Multiplay.canAttackEntity(ds, (Entity)this))
/* 110 */         return false; 
/* 111 */       if (ds.func_76346_g() instanceof EntityPlayer && ds.func_76355_l().equalsIgnoreCase("player")) {
/* 112 */         MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityContainer.attackEntityFrom:damage=%.1f:%s", new Object[] { Float.valueOf(damage), ds.func_76355_l() });
/* 113 */         W_WorldFunc.MOD_playSoundAtEntity((Entity)this, "hit", 1.0F, 1.3F);
/* 114 */         setDamageTaken(getDamageTaken() + (int)(damage * 20.0F));
/* 115 */         setForwardDirection(-getForwardDirection());
/* 116 */         setTimeSinceHit(10);
/* 117 */         func_70018_K();
/* 118 */         boolean flag = (ds.func_76346_g() instanceof EntityPlayer && ((EntityPlayer)ds.func_76346_g()).field_71075_bZ.field_75098_d);
/* 119 */         if (flag || getDamageTaken() > 40.0F) {
/* 120 */           if (!flag) {
/* 121 */             dropItemWithOffset((Item)MCH_MOD.itemContainer, 1, 0.0F);
/*     */           }
/*     */           
/* 124 */           func_70106_y();
/*     */         } 
/*     */         
/* 127 */         return true;
/*     */       } 
/* 129 */       return false;
/*     */     } 
/*     */     
/* 132 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70057_ab() {
/* 138 */     setForwardDirection(-getForwardDirection());
/* 139 */     setTimeSinceHit(10);
/* 140 */     setDamageTaken(getDamageTaken() * 11);
/*     */   }
/*     */   
/*     */   public boolean func_70067_L() {
/* 144 */     return !this.field_70128_L;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 149 */     this.boatPosRotationIncrements = par9 + 10;
/* 150 */     this.boatX = par1;
/* 151 */     this.boatY = par3;
/* 152 */     this.boatZ = par5;
/* 153 */     this.boatYaw = par7;
/* 154 */     this.boatPitch = par8;
/* 155 */     this.field_70159_w = this.velocityX;
/* 156 */     this.field_70181_x = this.velocityY;
/* 157 */     this.field_70179_y = this.velocityZ;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 162 */     this.velocityX = this.field_70159_w = par1;
/* 163 */     this.velocityY = this.field_70181_x = par3;
/* 164 */     this.velocityZ = this.field_70179_y = par5;
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/* 168 */     super.func_70071_h_();
/* 169 */     if (getTimeSinceHit() > 0) {
/* 170 */       setTimeSinceHit(getTimeSinceHit() - 1);
/*     */     }
/*     */     
/* 173 */     if (getDamageTaken() > 0.0F) {
/* 174 */       setDamageTaken(getDamageTaken() - 1);
/*     */     }
/*     */     
/* 177 */     this.field_70169_q = this.field_70165_t;
/* 178 */     this.field_70167_r = this.field_70163_u;
/* 179 */     this.field_70166_s = this.field_70161_v;
/* 180 */     byte b0 = 5;
/* 181 */     double d0 = 0.0D;
/*     */     
/* 183 */     for (int d3 = 0; d3 < b0; d3++) {
/* 184 */       double d1 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (d3 + 0) / b0 - 0.125D;
/* 185 */       double d2 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (d3 + 1) / b0 - 0.125D;
/* 186 */       AxisAlignedBB axisalignedbb = W_AxisAlignedBB.getAABB(this.field_70121_D.field_72340_a, d1, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d2, this.field_70121_D.field_72334_f);
/* 187 */       if (this.field_70170_p.func_72830_b(axisalignedbb, Material.field_151586_h)) {
/* 188 */         d0 += 1.0D / b0;
/* 189 */       } else if (this.field_70170_p.func_72830_b(axisalignedbb, Material.field_151587_i)) {
/* 190 */         d0 += 1.0D / b0;
/*     */       } 
/*     */     } 
/*     */     
/* 194 */     double var22 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/*     */ 
/*     */     
/* 197 */     if (var22 > 0.2625D) {
/* 198 */       double d4 = Math.cos(this.field_70177_z * Math.PI / 180.0D);
/* 199 */       double d1 = Math.sin(this.field_70177_z * Math.PI / 180.0D);
/*     */     } 
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 205 */     if (this.field_70170_p.field_72995_K) {
/* 206 */       if (this.boatPosRotationIncrements > 0) {
/* 207 */         double d4 = this.field_70165_t + (this.boatX - this.field_70165_t) / this.boatPosRotationIncrements;
/* 208 */         double d5 = this.field_70163_u + (this.boatY - this.field_70163_u) / this.boatPosRotationIncrements;
/* 209 */         double d11 = this.field_70161_v + (this.boatZ - this.field_70161_v) / this.boatPosRotationIncrements;
/* 210 */         double d10 = MathHelper.func_76138_g(this.boatYaw - this.field_70177_z);
/* 211 */         this.field_70177_z = (float)(this.field_70177_z + d10 / this.boatPosRotationIncrements);
/* 212 */         this.field_70125_A = (float)(this.field_70125_A + (this.boatPitch - this.field_70125_A) / this.boatPosRotationIncrements);
/* 213 */         this.boatPosRotationIncrements--;
/* 214 */         func_70107_b(d4, d5, d11);
/* 215 */         func_70101_b(this.field_70177_z, this.field_70125_A);
/*     */       } else {
/* 217 */         double d4 = this.field_70165_t + this.field_70159_w;
/* 218 */         double d5 = this.field_70163_u + this.field_70181_x;
/* 219 */         double d11 = this.field_70161_v + this.field_70179_y;
/* 220 */         func_70107_b(d4, d5, d11);
/* 221 */         if (this.field_70122_E) {
/* 222 */           float d12 = 0.9F;
/* 223 */           this.field_70159_w *= 0.8999999761581421D;
/* 224 */           this.field_70179_y *= 0.8999999761581421D;
/*     */         } 
/*     */         
/* 227 */         this.field_70159_w *= 0.99D;
/* 228 */         this.field_70181_x *= 0.95D;
/* 229 */         this.field_70179_y *= 0.99D;
/*     */       } 
/*     */     } else {
/* 232 */       if (d0 < 1.0D) {
/* 233 */         double d = d0 * 2.0D - 1.0D;
/* 234 */         this.field_70181_x += 0.04D * d;
/*     */       } else {
/* 236 */         if (this.field_70181_x < 0.0D) {
/* 237 */           this.field_70181_x /= 2.0D;
/*     */         }
/*     */         
/* 240 */         this.field_70181_x += 0.007D;
/*     */       } 
/*     */       
/* 243 */       double d4 = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 244 */       if (d4 > 0.35D) {
/* 245 */         double d = 0.35D / d4;
/* 246 */         this.field_70159_w *= d;
/* 247 */         this.field_70179_y *= d;
/* 248 */         d4 = 0.35D;
/*     */       } 
/*     */       
/* 251 */       if (d4 > var22 && this.speedMultiplier < 0.35D) {
/* 252 */         this.speedMultiplier += (0.35D - this.speedMultiplier) / 35.0D;
/* 253 */         if (this.speedMultiplier > 0.35D) {
/* 254 */           this.speedMultiplier = 0.35D;
/*     */         }
/*     */       } else {
/* 257 */         this.speedMultiplier -= (this.speedMultiplier - 0.07D) / 35.0D;
/* 258 */         if (this.speedMultiplier < 0.07D) {
/* 259 */           this.speedMultiplier = 0.07D;
/*     */         }
/*     */       } 
/*     */       
/* 263 */       if (this.field_70122_E) {
/* 264 */         float d12 = 0.9F;
/* 265 */         this.field_70159_w *= 0.8999999761581421D;
/* 266 */         this.field_70179_y *= 0.8999999761581421D;
/*     */       } 
/*     */       
/* 269 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 270 */       this.field_70159_w *= 0.99D;
/* 271 */       this.field_70181_x *= 0.95D;
/* 272 */       this.field_70179_y *= 0.99D;
/* 273 */       this.field_70125_A = 0.0F;
/* 274 */       double d5 = this.field_70177_z;
/* 275 */       double d11 = this.field_70169_q - this.field_70165_t;
/* 276 */       double d10 = this.field_70166_s - this.field_70161_v;
/* 277 */       if (d11 * d11 + d10 * d10 > 0.001D) {
/* 278 */         d5 = (float)(Math.atan2(d10, d11) * 180.0D / Math.PI);
/*     */       }
/*     */       
/* 281 */       double var23 = MathHelper.func_76138_g(d5 - this.field_70177_z);
/* 282 */       if (var23 > 5.0D) {
/* 283 */         var23 = 5.0D;
/*     */       }
/*     */       
/* 286 */       if (var23 < -5.0D) {
/* 287 */         var23 = -5.0D;
/*     */       }
/*     */       
/* 290 */       this.field_70177_z = (float)(this.field_70177_z + var23);
/* 291 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/* 292 */       if (!this.field_70170_p.field_72995_K) {
/* 293 */         List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(0.2D, 0.0D, 0.2D));
/*     */         
/* 295 */         if (list != null && !list.isEmpty()) {
/* 296 */           for (int l = 0; l < list.size(); l++) {
/* 297 */             Entity i1 = list.get(l);
/* 298 */             if (i1.func_70104_M() && i1 instanceof MCH_EntityContainer) {
/* 299 */               i1.func_70108_f((Entity)this);
/*     */             }
/*     */           } 
/*     */         }
/*     */         
/* 304 */         MCH_Config var10000 = MCH_MOD.config;
/* 305 */         if (MCH_Config.Collision_DestroyBlock.prmBool) {
/* 306 */           for (int l = 0; l < 4; l++) {
/* 307 */             int var24 = MathHelper.func_76128_c(this.field_70165_t + ((l % 2) - 0.5D) * 0.8D);
/* 308 */             int j1 = MathHelper.func_76128_c(this.field_70161_v + ((l / 2) - 0.5D) * 0.8D);
/*     */             
/* 310 */             for (int k1 = 0; k1 < 2; k1++) {
/* 311 */               int l1 = MathHelper.func_76128_c(this.field_70163_u) + k1;
/* 312 */               if (W_WorldFunc.isEqualBlock(this.field_70170_p, var24, l1, j1, W_Block.getSnowLayer())) {
/* 313 */                 this.field_70170_p.func_147468_f(var24, l1, j1);
/* 314 */               } else if (W_WorldFunc.isEqualBlock(this.field_70170_p, var24, l1, j1, Blocks.field_150392_bi)) {
/* 315 */                 W_WorldFunc.destroyBlock(this.field_70170_p, var24, l1, j1, true);
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/* 326 */     super.func_70014_b(par1NBTTagCompound);
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/* 330 */     super.func_70037_a(par1NBTTagCompound);
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 335 */     return 2.0F;
/*     */   }
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer player) {
/* 339 */     if (player != null) {
/* 340 */       openInventory(player);
/*     */     }
/*     */     
/* 343 */     return true;
/*     */   }
/*     */   
/*     */   public void setDamageTaken(int par1) {
/* 347 */     this.field_70180_af.func_75692_b(19, Integer.valueOf(par1));
/*     */   }
/*     */   
/*     */   public int getDamageTaken() {
/* 351 */     return this.field_70180_af.func_75679_c(19);
/*     */   }
/*     */   
/*     */   public void setTimeSinceHit(int par1) {
/* 355 */     this.field_70180_af.func_75692_b(17, Integer.valueOf(par1));
/*     */   }
/*     */   
/*     */   public int getTimeSinceHit() {
/* 359 */     return this.field_70180_af.func_75679_c(17);
/*     */   }
/*     */   
/*     */   public void setForwardDirection(int par1) {
/* 363 */     this.field_70180_af.func_75692_b(18, Integer.valueOf(par1));
/*     */   }
/*     */   
/*     */   public int getForwardDirection() {
/* 367 */     return this.field_70180_af.func_75679_c(18);
/*     */   }
/*     */   
/*     */   public boolean canRideAircraft(MCH_EntityAircraft ac, int seatID, MCH_SeatRackInfo info) {
/* 371 */     String[] arr$ = info.names;
/* 372 */     int len$ = arr$.length;
/*     */     
/* 374 */     for (int i$ = 0; i$ < len$; i$++) {
/* 375 */       String s = arr$[i$];
/* 376 */       if (s.equalsIgnoreCase("container")) {
/* 377 */         return (ac.field_70154_o == null && this.field_70154_o == null);
/*     */       }
/*     */     } 
/*     */     
/* 381 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isSkipNormalRender() {
/* 385 */     return this.field_70154_o instanceof mcheli.aircraft.MCH_EntitySeat;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\container\MCH_EntityContainer.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */