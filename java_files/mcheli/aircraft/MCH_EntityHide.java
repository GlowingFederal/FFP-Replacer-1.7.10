/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.DamageSource;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.ReportedException;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_EntityHide
/*     */   extends W_Entity
/*     */ {
/*     */   private MCH_EntityAircraft ac;
/*     */   private Entity user;
/*     */   private int paraPosRotInc;
/*     */   private double paraX;
/*     */   private double paraY;
/*     */   
/*     */   public MCH_EntityHide(World par1World) {
/*  39 */     super(par1World);
/*  40 */     func_70105_a(1.0F, 1.0F);
/*  41 */     this.field_70156_m = true;
/*  42 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  43 */     this.user = null;
/*  44 */     this.field_70159_w = this.field_70181_x = this.field_70179_y = 0.0D; } private double paraZ; private double paraYaw; private double paraPitch; @SideOnly(Side.CLIENT)
/*     */   private double velocityX; @SideOnly(Side.CLIENT)
/*     */   private double velocityY; @SideOnly(Side.CLIENT)
/*     */   private double velocityZ; public MCH_EntityHide(World par1World, double x, double y, double z) {
/*  48 */     this(par1World);
/*  49 */     this.field_70165_t = x;
/*  50 */     this.field_70163_u = y;
/*  51 */     this.field_70161_v = z;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  55 */     super.func_70088_a();
/*  56 */     createRopeIndex(-1);
/*  57 */     func_70096_w().func_75682_a(31, new Integer(0));
/*     */   }
/*     */   
/*     */   public void setParent(MCH_EntityAircraft ac, Entity user, int ropeIdx) {
/*  61 */     this.ac = ac;
/*  62 */     setRopeIndex(ropeIdx);
/*  63 */     this.user = user;
/*     */   }
/*     */   
/*     */   protected boolean func_70041_e_() {
/*  67 */     return false;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/*  71 */     return par1Entity.field_70121_D;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_70046_E() {
/*  75 */     return this.field_70121_D;
/*     */   }
/*     */   
/*     */   public boolean func_70104_M() {
/*  79 */     return true;
/*     */   }
/*     */   
/*     */   public double func_70042_X() {
/*  83 */     return this.field_70131_O * 0.0D - 0.3D;
/*     */   }
/*     */   
/*     */   public boolean func_70097_a(DamageSource par1DamageSource, float par2) {
/*  87 */     return false;
/*     */   }
/*     */   
/*     */   public boolean func_70067_L() {
/*  91 */     return !this.field_70128_L;
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound nbt) {}
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound nbt) {}
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public float func_70053_R() {
/* 100 */     return 0.0F;
/*     */   }
/*     */   
/*     */   public boolean func_130002_c(EntityPlayer par1EntityPlayer) {
/* 104 */     return false;
/*     */   }
/*     */   
/*     */   public void createRopeIndex(int defaultValue) {
/* 108 */     func_70096_w().func_75682_a(30, new Integer(defaultValue));
/*     */   }
/*     */   
/*     */   public int getRopeIndex() {
/* 112 */     return func_70096_w().func_75679_c(30);
/*     */   }
/*     */   
/*     */   public void setRopeIndex(int value) {
/* 116 */     func_70096_w().func_75692_b(30, new Integer(value));
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 121 */     this.paraPosRotInc = par9 + 10;
/* 122 */     this.paraX = par1;
/* 123 */     this.paraY = par3;
/* 124 */     this.paraZ = par5;
/* 125 */     this.paraYaw = par7;
/* 126 */     this.paraPitch = par8;
/* 127 */     this.field_70159_w = this.velocityX;
/* 128 */     this.field_70181_x = this.velocityY;
/* 129 */     this.field_70179_y = this.velocityZ;
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void func_70016_h(double par1, double par3, double par5) {
/* 134 */     this.velocityX = this.field_70159_w = par1;
/* 135 */     this.velocityY = this.field_70181_x = par3;
/* 136 */     this.velocityZ = this.field_70179_y = par5;
/*     */   }
/*     */   
/*     */   public void func_70106_y() {
/* 140 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public void func_70071_h_() {
/* 144 */     super.func_70071_h_();
/* 145 */     if (this.user != null && !this.field_70170_p.field_72995_K) {
/* 146 */       if (this.ac != null) {
/* 147 */         func_70096_w().func_75692_b(31, new Integer(this.ac.func_145782_y()));
/*     */       }
/*     */       
/* 150 */       this.user.func_70078_a((Entity)this);
/* 151 */       this.user = null;
/*     */     } 
/*     */ 
/*     */     
/* 155 */     if (this.ac == null && this.field_70170_p.field_72995_K) {
/* 156 */       int id = func_70096_w().func_75679_c(31);
/* 157 */       if (id > 0) {
/* 158 */         Entity v = this.field_70170_p.func_73045_a(id);
/* 159 */         if (v instanceof MCH_EntityAircraft) {
/* 160 */           this.ac = (MCH_EntityAircraft)v;
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 165 */     this.field_70169_q = this.field_70165_t;
/* 166 */     this.field_70167_r = this.field_70163_u;
/* 167 */     this.field_70166_s = this.field_70161_v;
/* 168 */     this.field_70143_R = 0.0F;
/* 169 */     if (this.field_70153_n != null) {
/* 170 */       this.field_70153_n.field_70143_R = 0.0F;
/*     */     }
/*     */     
/* 173 */     if (this.ac != null) {
/* 174 */       if (!this.ac.isRepelling()) {
/* 175 */         func_70106_y();
/*     */       }
/*     */       
/* 178 */       int id = getRopeIndex();
/* 179 */       if (id >= 0) {
/* 180 */         Vec3 v1 = this.ac.getRopePos(id);
/* 181 */         this.field_70165_t = v1.field_72450_a;
/* 182 */         this.field_70161_v = v1.field_72449_c;
/*     */       } 
/*     */     } 
/*     */     
/* 186 */     func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 187 */     if (this.field_70170_p.field_72995_K) {
/* 188 */       onUpdateClient();
/*     */     } else {
/* 190 */       onUpdateServer();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdateClient() {
/* 196 */     if (this.paraPosRotInc > 0) {
/* 197 */       double x = this.field_70165_t + (this.paraX - this.field_70165_t) / this.paraPosRotInc;
/* 198 */       double y = this.field_70163_u + (this.paraY - this.field_70163_u) / this.paraPosRotInc;
/* 199 */       double z = this.field_70161_v + (this.paraZ - this.field_70161_v) / this.paraPosRotInc;
/* 200 */       double yaw = MathHelper.func_76138_g(this.paraYaw - this.field_70177_z);
/* 201 */       this.field_70177_z = (float)(this.field_70177_z + yaw / this.paraPosRotInc);
/* 202 */       this.field_70125_A = (float)(this.field_70125_A + (this.paraPitch - this.field_70125_A) / this.paraPosRotInc);
/* 203 */       this.paraPosRotInc--;
/* 204 */       func_70107_b(x, y, z);
/* 205 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/* 206 */       if (this.field_70153_n != null) {
/* 207 */         func_70101_b(this.field_70153_n.field_70126_B, this.field_70125_A);
/*     */       }
/*     */     } else {
/* 210 */       func_70107_b(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 211 */       this.field_70159_w *= 0.99D;
/* 212 */       this.field_70181_x *= 0.95D;
/* 213 */       this.field_70179_y *= 0.99D;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdateServer() {
/* 219 */     this.field_70181_x -= this.field_70122_E ? 0.01D : 0.03D;
/* 220 */     if (this.field_70122_E) {
/* 221 */       onGroundAndDead();
/*     */     } else {
/* 223 */       func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 224 */       this.field_70181_x *= 0.9D;
/* 225 */       this.field_70159_w *= 0.95D;
/* 226 */       this.field_70179_y *= 0.95D;
/* 227 */       int id = getRopeIndex();
/* 228 */       if (this.ac != null && id >= 0) {
/* 229 */         Vec3 v = this.ac.getRopePos(id);
/* 230 */         if (Math.abs(this.field_70163_u - v.field_72448_b) > (Math.abs(this.ac.ropesLength) + 5.0F)) {
/* 231 */           onGroundAndDead();
/*     */         }
/*     */       } 
/*     */       
/* 235 */       if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
/* 236 */         this.field_70153_n = null;
/* 237 */         func_70106_y();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public List getCollidingBoundingBoxes(Entity par1Entity, AxisAlignedBB par2AxisAlignedBB) {
/* 244 */     ArrayList<AxisAlignedBB> collidingBoundingBoxes = new ArrayList();
/* 245 */     collidingBoundingBoxes.clear();
/* 246 */     int i = MathHelper.func_76128_c(par2AxisAlignedBB.field_72340_a);
/* 247 */     int j = MathHelper.func_76128_c(par2AxisAlignedBB.field_72336_d + 1.0D);
/* 248 */     int k = MathHelper.func_76128_c(par2AxisAlignedBB.field_72338_b);
/* 249 */     int l = MathHelper.func_76128_c(par2AxisAlignedBB.field_72337_e + 1.0D);
/* 250 */     int i1 = MathHelper.func_76128_c(par2AxisAlignedBB.field_72339_c);
/* 251 */     int j1 = MathHelper.func_76128_c(par2AxisAlignedBB.field_72334_f + 1.0D);
/*     */     
/* 253 */     for (int d0 = i; d0 < j; d0++) {
/* 254 */       for (int l1 = i1; l1 < j1; l1++) {
/* 255 */         if (this.field_70170_p.func_72899_e(d0, 64, l1)) {
/* 256 */           for (int list = k - 1; list < l; list++) {
/* 257 */             Block j2 = W_WorldFunc.getBlock(this.field_70170_p, d0, list, l1);
/* 258 */             if (j2 != null && 
/* 259 */               par1Entity instanceof EntityPlayer) {
/* 260 */               j2.func_149743_a(this.field_70170_p, d0, list, l1, par2AxisAlignedBB, collidingBoundingBoxes, par1Entity);
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 268 */     double var16 = 0.25D;
/* 269 */     List<Entity> var17 = this.field_70170_p.func_72839_b(par1Entity, par2AxisAlignedBB.func_72314_b(var16, var16, var16));
/*     */     
/* 271 */     for (int var18 = 0; var18 < var17.size(); var18++) {
/* 272 */       Entity entity = var17.get(var18);
/* 273 */       if (!W_Lib.isEntityLivingBase(entity) && !(entity instanceof MCH_EntitySeat) && !(entity instanceof MCH_EntityHitBox) && entity instanceof EntityPlayer) {
/* 274 */         AxisAlignedBB axisalignedbb1 = entity.func_70046_E();
/* 275 */         if (axisalignedbb1 != null && axisalignedbb1.func_72326_a(par2AxisAlignedBB)) {
/* 276 */           collidingBoundingBoxes.add(axisalignedbb1);
/*     */         }
/*     */         
/* 279 */         axisalignedbb1 = par1Entity.func_70114_g(entity);
/* 280 */         if (axisalignedbb1 != null && axisalignedbb1.func_72326_a(par2AxisAlignedBB)) {
/* 281 */           collidingBoundingBoxes.add(axisalignedbb1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 287 */     return collidingBoundingBoxes;
/*     */   }
/*     */   
/*     */   public void func_70091_d(double par1, double par3, double par5) {
/* 291 */     this.field_70170_p.field_72984_F.func_76320_a("move");
/* 292 */     this.field_70139_V *= 0.4F;
/* 293 */     double d3 = this.field_70165_t;
/* 294 */     double d4 = this.field_70163_u;
/* 295 */     double d5 = this.field_70161_v;
/* 296 */     double d6 = par1;
/* 297 */     double d7 = par3;
/* 298 */     double d8 = par5;
/* 299 */     AxisAlignedBB axisalignedbb = this.field_70121_D.func_72329_c();
/* 300 */     List<AxisAlignedBB> list = getCollidingBoundingBoxes((Entity)this, this.field_70121_D.func_72321_a(par1, par3, par5));
/*     */     
/* 302 */     for (int flag1 = 0; flag1 < list.size(); flag1++) {
/* 303 */       par3 = ((AxisAlignedBB)list.get(flag1)).func_72323_b(this.field_70121_D, par3);
/*     */     }
/*     */     
/* 306 */     this.field_70121_D.func_72317_d(0.0D, par3, 0.0D);
/* 307 */     if (!this.field_70135_K && d7 != par3) {
/* 308 */       par5 = 0.0D;
/* 309 */       par3 = 0.0D;
/* 310 */       par1 = 0.0D;
/*     */     } 
/*     */     
/* 313 */     boolean var34 = (this.field_70122_E || (d7 != par3 && d7 < 0.0D));
/*     */     
/*     */     int j;
/* 316 */     for (j = 0; j < list.size(); j++) {
/* 317 */       par1 = ((AxisAlignedBB)list.get(j)).func_72316_a(this.field_70121_D, par1);
/*     */     }
/*     */     
/* 320 */     this.field_70121_D.func_72317_d(par1, 0.0D, 0.0D);
/* 321 */     if (!this.field_70135_K && d6 != par1) {
/* 322 */       par5 = 0.0D;
/* 323 */       par3 = 0.0D;
/* 324 */       par1 = 0.0D;
/*     */     } 
/*     */     
/* 327 */     for (j = 0; j < list.size(); j++) {
/* 328 */       par5 = ((AxisAlignedBB)list.get(j)).func_72322_c(this.field_70121_D, par5);
/*     */     }
/*     */     
/* 331 */     this.field_70121_D.func_72317_d(0.0D, 0.0D, par5);
/* 332 */     if (!this.field_70135_K && d8 != par5) {
/* 333 */       par5 = 0.0D;
/* 334 */       par3 = 0.0D;
/* 335 */       par1 = 0.0D;
/*     */     } 
/*     */     
/* 338 */     if (this.field_70138_W > 0.0F && var34 && this.field_70139_V < 0.05F && (d6 != par1 || d8 != par5)) {
/* 339 */       double d12 = par1;
/* 340 */       double d10 = par3;
/* 341 */       double d11 = par5;
/* 342 */       par1 = d6;
/* 343 */       par3 = this.field_70138_W;
/* 344 */       par5 = d8;
/* 345 */       AxisAlignedBB throwable = this.field_70121_D.func_72329_c();
/* 346 */       this.field_70121_D.func_72328_c(axisalignedbb);
/* 347 */       list = getCollidingBoundingBoxes((Entity)this, this.field_70121_D.func_72321_a(d6, par3, d8));
/*     */       
/*     */       int k;
/* 350 */       for (k = 0; k < list.size(); k++) {
/* 351 */         par3 = ((AxisAlignedBB)list.get(k)).func_72323_b(this.field_70121_D, par3);
/*     */       }
/*     */       
/* 354 */       this.field_70121_D.func_72317_d(0.0D, par3, 0.0D);
/* 355 */       if (!this.field_70135_K && d7 != par3) {
/* 356 */         par5 = 0.0D;
/* 357 */         par3 = 0.0D;
/* 358 */         par1 = 0.0D;
/*     */       } 
/*     */       
/* 361 */       for (k = 0; k < list.size(); k++) {
/* 362 */         par1 = ((AxisAlignedBB)list.get(k)).func_72316_a(this.field_70121_D, par1);
/*     */       }
/*     */       
/* 365 */       this.field_70121_D.func_72317_d(par1, 0.0D, 0.0D);
/* 366 */       if (!this.field_70135_K && d6 != par1) {
/* 367 */         par5 = 0.0D;
/* 368 */         par3 = 0.0D;
/* 369 */         par1 = 0.0D;
/*     */       } 
/*     */       
/* 372 */       for (k = 0; k < list.size(); k++) {
/* 373 */         par5 = ((AxisAlignedBB)list.get(k)).func_72322_c(this.field_70121_D, par5);
/*     */       }
/*     */       
/* 376 */       this.field_70121_D.func_72317_d(0.0D, 0.0D, par5);
/* 377 */       if (!this.field_70135_K && d8 != par5) {
/* 378 */         par5 = 0.0D;
/* 379 */         par3 = 0.0D;
/* 380 */         par1 = 0.0D;
/*     */       } 
/*     */       
/* 383 */       if (!this.field_70135_K && d7 != par3) {
/* 384 */         par5 = 0.0D;
/* 385 */         par3 = 0.0D;
/* 386 */         par1 = 0.0D;
/*     */       } else {
/* 388 */         par3 = -this.field_70138_W;
/*     */         
/* 390 */         for (k = 0; k < list.size(); k++) {
/* 391 */           par3 = ((AxisAlignedBB)list.get(k)).func_72323_b(this.field_70121_D, par3);
/*     */         }
/*     */         
/* 394 */         this.field_70121_D.func_72317_d(0.0D, par3, 0.0D);
/*     */       } 
/*     */       
/* 397 */       if (d12 * d12 + d11 * d11 >= par1 * par1 + par5 * par5) {
/* 398 */         par1 = d12;
/* 399 */         par3 = d10;
/* 400 */         par5 = d11;
/* 401 */         this.field_70121_D.func_72328_c(throwable);
/*     */       } 
/*     */     } 
/*     */     
/* 405 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 406 */     this.field_70170_p.field_72984_F.func_76320_a("rest");
/* 407 */     this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
/* 408 */     this.field_70163_u = this.field_70121_D.field_72338_b + this.field_70129_M - this.field_70139_V;
/* 409 */     this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
/* 410 */     this.field_70123_F = (d6 != par1 || d8 != par5);
/* 411 */     this.field_70124_G = (d7 != par3);
/* 412 */     this.field_70122_E = (d7 != par3 && d7 < 0.0D);
/* 413 */     this.field_70132_H = (this.field_70123_F || this.field_70124_G);
/* 414 */     func_70064_a(par3, this.field_70122_E);
/* 415 */     if (d6 != par1) {
/* 416 */       this.field_70159_w = 0.0D;
/*     */     }
/*     */     
/* 419 */     if (d7 != par3) {
/* 420 */       this.field_70181_x = 0.0D;
/*     */     }
/*     */     
/* 423 */     if (d8 != par5) {
/* 424 */       this.field_70179_y = 0.0D;
/*     */     }
/*     */     
/* 427 */     double var10000 = this.field_70165_t - d3;
/* 428 */     var10000 = this.field_70163_u - d4;
/* 429 */     var10000 = this.field_70161_v - d5;
/*     */     
/*     */     try {
/* 432 */       doBlockCollisions();
/* 433 */     } catch (Throwable var33) {
/* 434 */       CrashReport crashreport = CrashReport.func_85055_a(var33, "Checking entity tile collision");
/* 435 */       CrashReportCategory crashreportcategory = crashreport.func_85058_a("Entity being checked for collision");
/* 436 */       func_85029_a(crashreportcategory);
/* 437 */       throw new ReportedException(crashreport);
/*     */     } 
/*     */     
/* 440 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */   }
/*     */   
/*     */   public void onGroundAndDead() {
/* 444 */     this.field_70163_u += 0.5D;
/* 445 */     func_70043_V();
/* 446 */     func_70106_y();
/*     */   }
/*     */   
/*     */   public void _updateRiderPosition() {
/* 450 */     if (this.field_70153_n != null) {
/* 451 */       double x = -Math.sin(this.field_70177_z * Math.PI / 180.0D) * 0.1D;
/* 452 */       double z = Math.cos(this.field_70177_z * Math.PI / 180.0D) * 0.1D;
/* 453 */       this.field_70153_n.func_70107_b(this.field_70165_t + x, this.field_70163_u + func_70042_X() + this.field_70153_n.func_70033_W(), this.field_70161_v + z);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_EntityHide.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */