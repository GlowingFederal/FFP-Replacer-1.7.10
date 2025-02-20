/*     */ package mcheli.tank;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.crash.CrashReport;
/*     */ import net.minecraft.crash.CrashReportCategory;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_EntityWheel
/*     */   extends W_Entity
/*     */ {
/*     */   private MCH_EntityAircraft parents;
/*     */   public Vec3 pos;
/*     */   boolean isPlus;
/*     */   
/*     */   public MCH_EntityWheel(World w) {
/*  30 */     super(w);
/*  31 */     func_70105_a(1.0F, 1.0F);
/*  32 */     this.field_70138_W = 1.5F;
/*  33 */     this.field_70178_ae = true;
/*  34 */     this.isPlus = false;
/*     */   }
/*     */   
/*     */   public void setWheelPos(Vec3 pos, Vec3 weightedCenter) {
/*  38 */     this.pos = pos;
/*  39 */     this.isPlus = (pos.field_72449_c >= weightedCenter.field_72449_c);
/*     */   }
/*     */   
/*     */   public void func_71027_c(int p_71027_1_) {}
/*     */   
/*     */   public MCH_EntityAircraft getParents() {
/*  45 */     return this.parents;
/*     */   }
/*     */   
/*     */   public void setParents(MCH_EntityAircraft parents) {
/*  49 */     this.parents = parents;
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound p_70037_1_) {
/*  53 */     func_70106_y();
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound p_70014_1_) {}
/*     */   
/*     */   public void func_70091_d(double parX, double parY, double parZ) {
/*  59 */     this.field_70170_p.field_72984_F.func_76320_a("move");
/*  60 */     this.field_70139_V *= 0.4F;
/*  61 */     double nowPosX = this.field_70165_t;
/*  62 */     double nowPosY = this.field_70163_u;
/*  63 */     double nowPosZ = this.field_70161_v;
/*  64 */     double mx = parX;
/*  65 */     double my = parY;
/*  66 */     double mz = parZ;
/*  67 */     AxisAlignedBB axisalignedbb = this.field_70121_D.func_72329_c();
/*  68 */     List<AxisAlignedBB> list = getCollidingBoundingBoxes((Entity)this, this.field_70121_D.func_72321_a(parX, parY, parZ));
/*     */     
/*  70 */     for (int flag1 = 0; flag1 < list.size(); flag1++) {
/*  71 */       parY = ((AxisAlignedBB)list.get(flag1)).func_72323_b(this.field_70121_D, parY);
/*     */     }
/*     */     
/*  74 */     this.field_70121_D.func_72317_d(0.0D, parY, 0.0D);
/*  75 */     boolean var32 = (this.field_70122_E || (my != parY && my < 0.0D));
/*     */     
/*     */     int bkParY;
/*  78 */     for (bkParY = 0; bkParY < list.size(); bkParY++) {
/*  79 */       parX = ((AxisAlignedBB)list.get(bkParY)).func_72316_a(this.field_70121_D, parX);
/*     */     }
/*     */     
/*  82 */     this.field_70121_D.func_72317_d(parX, 0.0D, 0.0D);
/*     */     
/*  84 */     for (bkParY = 0; bkParY < list.size(); bkParY++) {
/*  85 */       parZ = ((AxisAlignedBB)list.get(bkParY)).func_72322_c(this.field_70121_D, parZ);
/*     */     }
/*     */     
/*  88 */     this.field_70121_D.func_72317_d(0.0D, 0.0D, parZ);
/*  89 */     if (this.field_70138_W > 0.0F && var32 && this.field_70139_V < 0.05F && (mx != parX || mz != parZ)) {
/*  90 */       double bkParX = parX;
/*  91 */       double var33 = parY;
/*  92 */       double bkParZ = parZ;
/*  93 */       parX = mx;
/*  94 */       parY = this.field_70138_W;
/*  95 */       parZ = mz;
/*  96 */       AxisAlignedBB throwable = this.field_70121_D.func_72329_c();
/*  97 */       this.field_70121_D.func_72328_c(axisalignedbb);
/*  98 */       list = getCollidingBoundingBoxes((Entity)this, this.field_70121_D.func_72321_a(mx, parY, mz));
/*     */       
/*     */       int crashreport;
/* 101 */       for (crashreport = 0; crashreport < list.size(); crashreport++) {
/* 102 */         parY = ((AxisAlignedBB)list.get(crashreport)).func_72323_b(this.field_70121_D, parY);
/*     */       }
/*     */       
/* 105 */       this.field_70121_D.func_72317_d(0.0D, parY, 0.0D);
/*     */       
/* 107 */       for (crashreport = 0; crashreport < list.size(); crashreport++) {
/* 108 */         parX = ((AxisAlignedBB)list.get(crashreport)).func_72316_a(this.field_70121_D, parX);
/*     */       }
/*     */       
/* 111 */       this.field_70121_D.func_72317_d(parX, 0.0D, 0.0D);
/*     */       
/* 113 */       for (crashreport = 0; crashreport < list.size(); crashreport++) {
/* 114 */         parZ = ((AxisAlignedBB)list.get(crashreport)).func_72322_c(this.field_70121_D, parZ);
/*     */       }
/*     */       
/* 117 */       this.field_70121_D.func_72317_d(0.0D, 0.0D, parZ);
/* 118 */       parY = -this.field_70138_W;
/*     */       
/* 120 */       for (crashreport = 0; crashreport < list.size(); crashreport++) {
/* 121 */         parY = ((AxisAlignedBB)list.get(crashreport)).func_72323_b(this.field_70121_D, parY);
/*     */       }
/*     */       
/* 124 */       this.field_70121_D.func_72317_d(0.0D, parY, 0.0D);
/* 125 */       if (bkParX * bkParX + bkParZ * bkParZ >= parX * parX + parZ * parZ) {
/* 126 */         parX = bkParX;
/* 127 */         parY = var33;
/* 128 */         parZ = bkParZ;
/* 129 */         this.field_70121_D.func_72328_c(throwable);
/*     */       } 
/*     */     } 
/*     */     
/* 133 */     this.field_70170_p.field_72984_F.func_76319_b();
/* 134 */     this.field_70170_p.field_72984_F.func_76320_a("rest");
/* 135 */     this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
/* 136 */     this.field_70163_u = this.field_70121_D.field_72338_b + this.field_70129_M - this.field_70139_V;
/* 137 */     this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
/* 138 */     this.field_70123_F = (mx != parX || mz != parZ);
/* 139 */     this.field_70124_G = (my != parY);
/* 140 */     this.field_70122_E = (my != parY && my < 0.0D);
/* 141 */     this.field_70132_H = (this.field_70123_F || this.field_70124_G);
/* 142 */     func_70064_a(parY, this.field_70122_E);
/* 143 */     if (mx != parX) {
/* 144 */       this.field_70159_w = 0.0D;
/*     */     }
/*     */     
/* 147 */     if (my != parY) {
/* 148 */       this.field_70181_x = 0.0D;
/*     */     }
/*     */     
/* 151 */     if (mz != parZ) {
/* 152 */       this.field_70179_y = 0.0D;
/*     */     }
/*     */     
/*     */     try {
/* 156 */       doBlockCollisions();
/* 157 */     } catch (Throwable var31) {
/* 158 */       CrashReport var34 = CrashReport.func_85055_a(var31, "Checking entity tile collision");
/* 159 */       CrashReportCategory crashreportcategory = var34.func_85058_a("Entity being checked for collision");
/* 160 */       func_85029_a(crashreportcategory);
/*     */     } 
/*     */     
/* 163 */     this.field_70170_p.field_72984_F.func_76319_b();
/*     */   }
/*     */   
/*     */   public List getCollidingBoundingBoxes(Entity par1Entity, AxisAlignedBB par2AxisAlignedBB) {
/* 167 */     ArrayList<AxisAlignedBB> collidingBoundingBoxes = new ArrayList();
/* 168 */     collidingBoundingBoxes.clear();
/* 169 */     int i = MathHelper.func_76128_c(par2AxisAlignedBB.field_72340_a);
/* 170 */     int j = MathHelper.func_76128_c(par2AxisAlignedBB.field_72336_d + 1.0D);
/* 171 */     int k = MathHelper.func_76128_c(par2AxisAlignedBB.field_72338_b);
/* 172 */     int l = MathHelper.func_76128_c(par2AxisAlignedBB.field_72337_e + 1.0D);
/* 173 */     int i1 = MathHelper.func_76128_c(par2AxisAlignedBB.field_72339_c);
/* 174 */     int j1 = MathHelper.func_76128_c(par2AxisAlignedBB.field_72334_f + 1.0D);
/*     */     
/* 176 */     for (int d0 = i; d0 < j; d0++) {
/* 177 */       for (int l1 = i1; l1 < j1; l1++) {
/* 178 */         if (par1Entity.field_70170_p.func_72899_e(d0, 64, l1)) {
/* 179 */           for (int list = k - 1; list < l; list++) {
/* 180 */             Block j2 = W_WorldFunc.getBlock(par1Entity.field_70170_p, d0, list, l1);
/* 181 */             if (j2 != null) {
/* 182 */               j2.func_149743_a(par1Entity.field_70170_p, d0, list, l1, par2AxisAlignedBB, collidingBoundingBoxes, par1Entity);
/*     */             }
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 189 */     double var16 = 0.25D;
/* 190 */     List<Entity> var17 = par1Entity.field_70170_p.func_72839_b(par1Entity, par2AxisAlignedBB.func_72314_b(var16, var16, var16));
/*     */     
/* 192 */     for (int var18 = 0; var18 < var17.size(); var18++) {
/* 193 */       Entity entity = var17.get(var18);
/* 194 */       if (!W_Lib.isEntityLivingBase(entity) && !(entity instanceof mcheli.aircraft.MCH_EntitySeat) && !(entity instanceof mcheli.aircraft.MCH_EntityHitBox) && entity != this.parents) {
/* 195 */         AxisAlignedBB axisalignedbb1 = entity.func_70046_E();
/* 196 */         if (axisalignedbb1 != null && axisalignedbb1.func_72326_a(par2AxisAlignedBB)) {
/* 197 */           collidingBoundingBoxes.add(axisalignedbb1);
/*     */         }
/*     */         
/* 200 */         axisalignedbb1 = par1Entity.func_70114_g(entity);
/* 201 */         if (axisalignedbb1 != null && axisalignedbb1.func_72326_a(par2AxisAlignedBB)) {
/* 202 */           collidingBoundingBoxes.add(axisalignedbb1);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 207 */     return collidingBoundingBoxes;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tank\MCH_EntityWheel.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */