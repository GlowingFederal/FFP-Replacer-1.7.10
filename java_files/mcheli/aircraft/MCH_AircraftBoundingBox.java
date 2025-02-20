/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import net.minecraft.util.AxisAlignedBB;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ 
/*     */ public class MCH_AircraftBoundingBox
/*     */   extends AxisAlignedBB
/*     */ {
/*     */   private final MCH_EntityAircraft ac;
/*     */   
/*     */   protected MCH_AircraftBoundingBox(MCH_EntityAircraft ac) {
/*  13 */     super(ac.field_70121_D.field_72340_a, ac.field_70121_D.field_72338_b, ac.field_70121_D.field_72339_c, ac.field_70121_D.field_72336_d, ac.field_70121_D.field_72337_e, ac.field_70121_D.field_72334_f);
/*  14 */     this.ac = ac;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB NewAABB(double p_72324_1_, double p_72324_3_, double p_72324_5_, double p_72324_7_, double p_72324_9_, double p_72324_11_) {
/*  18 */     return (new MCH_AircraftBoundingBox(this.ac)).func_72324_b(p_72324_1_, p_72324_3_, p_72324_5_, p_72324_7_, p_72324_9_, p_72324_11_);
/*     */   }
/*     */   
/*     */   public double getDistSq(AxisAlignedBB a1, AxisAlignedBB a2) {
/*  22 */     double x1 = (a1.field_72336_d + a1.field_72340_a) / 2.0D;
/*  23 */     double y1 = (a1.field_72337_e + a1.field_72338_b) / 2.0D;
/*  24 */     double z1 = (a1.field_72334_f + a1.field_72339_c) / 2.0D;
/*  25 */     double x2 = (a2.field_72336_d + a2.field_72340_a) / 2.0D;
/*  26 */     double y2 = (a2.field_72337_e + a2.field_72338_b) / 2.0D;
/*  27 */     double z2 = (a2.field_72334_f + a2.field_72339_c) / 2.0D;
/*  28 */     double dx = x1 - x2;
/*  29 */     double dy = y1 - y2;
/*  30 */     double dz = z1 - z2;
/*  31 */     return dx * dx + dy * dy + dz * dz;
/*     */   }
/*     */   
/*     */   public boolean func_72326_a(AxisAlignedBB aabb) {
/*  35 */     boolean ret = false;
/*  36 */     double dist = 1.0E7D;
/*  37 */     this.ac.lastBBDamageFactor = 1.0F;
/*  38 */     if (super.func_72326_a(aabb)) {
/*  39 */       dist = getDistSq(aabb, this);
/*  40 */       ret = true;
/*     */     } 
/*     */     
/*  43 */     MCH_BoundingBox[] arr$ = this.ac.extraBoundingBox;
/*  44 */     int len$ = arr$.length;
/*     */     
/*  46 */     for (int i$ = 0; i$ < len$; i$++) {
/*  47 */       MCH_BoundingBox bb = arr$[i$];
/*  48 */       if (bb.boundingBox.func_72326_a(aabb)) {
/*  49 */         double dist2 = getDistSq(aabb, this);
/*  50 */         if (dist2 < dist) {
/*  51 */           dist = dist2;
/*  52 */           this.ac.lastBBDamageFactor = bb.damegeFactor;
/*     */         } 
/*     */         
/*  55 */         ret = true;
/*     */       } 
/*     */     } 
/*     */     
/*  59 */     return ret;
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72314_b(double p_72314_1_, double p_72314_3_, double p_72314_5_) {
/*  63 */     double d3 = this.field_72340_a - p_72314_1_;
/*  64 */     double d4 = this.field_72338_b - p_72314_3_;
/*  65 */     double d5 = this.field_72339_c - p_72314_5_;
/*  66 */     double d6 = this.field_72336_d + p_72314_1_;
/*  67 */     double d7 = this.field_72337_e + p_72314_3_;
/*  68 */     double d8 = this.field_72334_f + p_72314_5_;
/*  69 */     return NewAABB(d3, d4, d5, d6, d7, d8);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_111270_a(AxisAlignedBB p_111270_1_) {
/*  73 */     double d0 = Math.min(this.field_72340_a, p_111270_1_.field_72340_a);
/*  74 */     double d1 = Math.min(this.field_72338_b, p_111270_1_.field_72338_b);
/*  75 */     double d2 = Math.min(this.field_72339_c, p_111270_1_.field_72339_c);
/*  76 */     double d3 = Math.max(this.field_72336_d, p_111270_1_.field_72336_d);
/*  77 */     double d4 = Math.max(this.field_72337_e, p_111270_1_.field_72337_e);
/*  78 */     double d5 = Math.max(this.field_72334_f, p_111270_1_.field_72334_f);
/*  79 */     return NewAABB(d0, d1, d2, d3, d4, d5);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72321_a(double p_72321_1_, double p_72321_3_, double p_72321_5_) {
/*  83 */     double d3 = this.field_72340_a;
/*  84 */     double d4 = this.field_72338_b;
/*  85 */     double d5 = this.field_72339_c;
/*  86 */     double d6 = this.field_72336_d;
/*  87 */     double d7 = this.field_72337_e;
/*  88 */     double d8 = this.field_72334_f;
/*  89 */     if (p_72321_1_ < 0.0D) {
/*  90 */       d3 += p_72321_1_;
/*     */     }
/*     */     
/*  93 */     if (p_72321_1_ > 0.0D) {
/*  94 */       d6 += p_72321_1_;
/*     */     }
/*     */     
/*  97 */     if (p_72321_3_ < 0.0D) {
/*  98 */       d4 += p_72321_3_;
/*     */     }
/*     */     
/* 101 */     if (p_72321_3_ > 0.0D) {
/* 102 */       d7 += p_72321_3_;
/*     */     }
/*     */     
/* 105 */     if (p_72321_5_ < 0.0D) {
/* 106 */       d5 += p_72321_5_;
/*     */     }
/*     */     
/* 109 */     if (p_72321_5_ > 0.0D) {
/* 110 */       d8 += p_72321_5_;
/*     */     }
/*     */     
/* 113 */     return NewAABB(d3, d4, d5, d6, d7, d8);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72331_e(double p_72331_1_, double p_72331_3_, double p_72331_5_) {
/* 117 */     double d3 = this.field_72340_a + p_72331_1_;
/* 118 */     double d4 = this.field_72338_b + p_72331_3_;
/* 119 */     double d5 = this.field_72339_c + p_72331_5_;
/* 120 */     double d6 = this.field_72336_d - p_72331_1_;
/* 121 */     double d7 = this.field_72337_e - p_72331_3_;
/* 122 */     double d8 = this.field_72334_f - p_72331_5_;
/* 123 */     return NewAABB(d3, d4, d5, d6, d7, d8);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72329_c() {
/* 127 */     return NewAABB(this.field_72340_a, this.field_72338_b, this.field_72339_c, this.field_72336_d, this.field_72337_e, this.field_72334_f);
/*     */   }
/*     */   
/*     */   public AxisAlignedBB func_72325_c(double x, double y, double z) {
/* 131 */     return NewAABB(this.field_72340_a + x, this.field_72338_b + y, this.field_72339_c + z, this.field_72336_d + x, this.field_72337_e + y, this.field_72334_f + z);
/*     */   }
/*     */   
/*     */   public MovingObjectPosition func_72327_a(Vec3 v1, Vec3 v2) {
/* 135 */     this.ac.lastBBDamageFactor = 1.0F;
/* 136 */     MovingObjectPosition mop = super.func_72327_a(v1, v2);
/* 137 */     double dist = 1.0E7D;
/* 138 */     if (mop != null) {
/* 139 */       dist = v1.func_72438_d(mop.field_72307_f);
/*     */     }
/*     */     
/* 142 */     MCH_BoundingBox[] arr$ = this.ac.extraBoundingBox;
/* 143 */     int len$ = arr$.length;
/*     */     
/* 145 */     for (int i$ = 0; i$ < len$; i$++) {
/* 146 */       MCH_BoundingBox bb = arr$[i$];
/* 147 */       MovingObjectPosition mop2 = bb.boundingBox.func_72327_a(v1, v2);
/* 148 */       if (mop2 != null) {
/* 149 */         double dist2 = v1.func_72438_d(mop2.field_72307_f);
/* 150 */         if (dist2 < dist) {
/* 151 */           mop = mop2;
/* 152 */           dist = dist2;
/* 153 */           this.ac.lastBBDamageFactor = bb.damegeFactor;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 158 */     return mop;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_AircraftBoundingBox.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */