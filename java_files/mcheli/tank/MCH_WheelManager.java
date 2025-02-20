/*     */ package mcheli.tank;
/*     */ 
/*     */ import java.util.List;
/*     */ import java.util.Random;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.wrapper.W_Block;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ public class MCH_WheelManager
/*     */ {
/*     */   public final MCH_EntityAircraft parent;
/*     */   public MCH_EntityWheel[] wheels;
/*     */   private double minZ;
/*     */   private double maxZ;
/*     */   private double avgZ;
/*     */   public Vec3 weightedCenter;
/*     */   public float targetPitch;
/*     */   public float targetRoll;
/*     */   public float prevYaw;
/*  32 */   private static Random rand = new Random();
/*     */ 
/*     */   
/*     */   public MCH_WheelManager(MCH_EntityAircraft ac) {
/*  36 */     this.parent = ac;
/*  37 */     this.wheels = new MCH_EntityWheel[0];
/*  38 */     this.weightedCenter = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/*     */   }
/*     */   
/*     */   public void createWheels(World w, List list, Vec3 weightedCenter) {
/*  42 */     this.wheels = new MCH_EntityWheel[list.size() * 2];
/*  43 */     this.minZ = 999999.0D;
/*  44 */     this.maxZ = -999999.0D;
/*  45 */     this.weightedCenter = weightedCenter;
/*     */     
/*  47 */     for (int i = 0; i < this.wheels.length; i++) {
/*  48 */       MCH_EntityWheel wheel = new MCH_EntityWheel(w);
/*  49 */       wheel.setParents(this.parent);
/*  50 */       Vec3 wp = ((MCH_AircraftInfo.Wheel)list.get(i / 2)).pos;
/*  51 */       wheel.setWheelPos(Vec3.func_72443_a((i % 2 == 0) ? wp.field_72450_a : -wp.field_72450_a, wp.field_72448_b, wp.field_72449_c), this.weightedCenter);
/*  52 */       Vec3 v = this.parent.getTransformedPosition(wheel.pos.field_72450_a, wheel.pos.field_72448_b, wheel.pos.field_72449_c);
/*  53 */       wheel.func_70012_b(v.field_72450_a, v.field_72448_b + 1.0D, v.field_72449_c, 0.0F, 0.0F);
/*  54 */       this.wheels[i] = wheel;
/*  55 */       if (wheel.pos.field_72449_c <= this.minZ) {
/*  56 */         this.minZ = wheel.pos.field_72449_c;
/*     */       }
/*     */       
/*  59 */       if (wheel.pos.field_72449_c >= this.maxZ) {
/*  60 */         this.maxZ = wheel.pos.field_72449_c;
/*     */       }
/*     */     } 
/*     */     
/*  64 */     this.avgZ = this.maxZ - this.minZ;
/*     */   }
/*     */   
/*     */   public void move(double x, double y, double z) {
/*  68 */     MCH_EntityAircraft ac = this.parent;
/*  69 */     if (ac.getAcInfo() != null) {
/*  70 */       boolean showLog = (ac.field_70173_aa % 1 == 1);
/*  71 */       if (showLog) {
/*  72 */         MCH_Lib.DbgLog(ac.field_70170_p, "[" + (ac.field_70170_p.field_72995_K ? "Client" : "Server") + "] ==============================", new Object[0]);
/*     */       }
/*     */       
/*  75 */       MCH_EntityWheel[] zmog = this.wheels;
/*  76 */       int rv = zmog.length;
/*     */       
/*     */       int wc;
/*     */       
/*  80 */       for (wc = 0; wc < rv; wc++) {
/*  81 */         MCH_EntityWheel pitch = zmog[wc];
/*  82 */         pitch.field_70169_q = pitch.field_70165_t;
/*  83 */         pitch.field_70167_r = pitch.field_70163_u;
/*  84 */         pitch.field_70166_s = pitch.field_70161_v;
/*  85 */         Vec3 roll = ac.getTransformedPosition(pitch.pos.field_72450_a, pitch.pos.field_72448_b, pitch.pos.field_72449_c);
/*  86 */         pitch.field_70159_w = roll.field_72450_a - pitch.field_70165_t + x;
/*  87 */         pitch.field_70181_x = roll.field_72448_b - pitch.field_70163_u;
/*  88 */         pitch.field_70179_y = roll.field_72449_c - pitch.field_70161_v + z;
/*     */       } 
/*     */       
/*  91 */       zmog = this.wheels;
/*  92 */       rv = zmog.length;
/*     */       
/*  94 */       for (wc = 0; wc < rv; wc++) {
/*  95 */         MCH_EntityWheel pitch = zmog[wc];
/*  96 */         pitch.field_70181_x *= 0.15D;
/*  97 */         pitch.func_70091_d(pitch.field_70159_w, pitch.field_70181_x, pitch.field_70179_y);
/*  98 */         double var32 = 1.0D;
/*  99 */         pitch.func_70091_d(0.0D, -0.1D * var32, 0.0D);
/*     */       } 
/*     */       
/* 102 */       int var28 = -1;
/*     */ 
/*     */       
/* 105 */       for (rv = 0; rv < this.wheels.length / 2; rv++) {
/* 106 */         var28 = rv;
/* 107 */         MCH_EntityWheel var30 = this.wheels[rv * 2 + 0];
/* 108 */         MCH_EntityWheel pitch = this.wheels[rv * 2 + 1];
/* 109 */         if (!var30.isPlus && (var30.field_70122_E || pitch.field_70122_E)) {
/* 110 */           var28 = -1;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 115 */       if (var28 >= 0) {
/* 116 */         (this.wheels[var28 * 2 + 0]).field_70122_E = true;
/* 117 */         (this.wheels[var28 * 2 + 1]).field_70122_E = true;
/*     */       } 
/*     */       
/* 120 */       var28 = -1;
/*     */       
/* 122 */       for (rv = this.wheels.length / 2 - 1; rv >= 0; rv--) {
/* 123 */         var28 = rv;
/* 124 */         MCH_EntityWheel var30 = this.wheels[rv * 2 + 0];
/* 125 */         MCH_EntityWheel pitch = this.wheels[rv * 2 + 1];
/* 126 */         if (var30.isPlus && (var30.field_70122_E || pitch.field_70122_E)) {
/* 127 */           var28 = -1;
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 132 */       if (var28 >= 0) {
/* 133 */         (this.wheels[var28 * 2 + 0]).field_70122_E = true;
/* 134 */         (this.wheels[var28 * 2 + 1]).field_70122_E = true;
/*     */       } 
/*     */       
/* 137 */       Vec3 var29 = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/* 138 */       Vec3 var31 = ac.getTransformedPosition(this.weightedCenter);
/* 139 */       var31.field_72450_a -= ac.field_70165_t;
/* 140 */       var31.field_72448_b = this.weightedCenter.field_72448_b;
/* 141 */       var31.field_72449_c -= ac.field_70161_v;
/*     */       
/* 143 */       for (int var33 = 0; var33 < this.wheels.length / 2; var33++) {
/* 144 */         MCH_EntityWheel var34 = this.wheels[var33 * 2 + 0];
/* 145 */         MCH_EntityWheel ogpf = this.wheels[var33 * 2 + 1];
/* 146 */         Vec3 ogrf = Vec3.func_72443_a(var34.field_70165_t - ac.field_70165_t + var31.field_72450_a, var34.field_70163_u - ac.field_70163_u + var31.field_72448_b, var34.field_70161_v - ac.field_70161_v + var31.field_72449_c);
/* 147 */         Vec3 arr$ = Vec3.func_72443_a(ogpf.field_70165_t - ac.field_70165_t + var31.field_72450_a, ogpf.field_70163_u - ac.field_70163_u + var31.field_72448_b, ogpf.field_70161_v - ac.field_70161_v + var31.field_72449_c);
/* 148 */         Vec3 len$ = (var34.pos.field_72449_c >= 0.0D) ? arr$.func_72431_c(ogrf) : ogrf.func_72431_c(arr$);
/* 149 */         len$ = len$.func_72432_b();
/* 150 */         double i$ = Math.abs(var34.pos.field_72449_c / this.avgZ);
/* 151 */         if (!var34.field_70122_E && !ogpf.field_70122_E) {
/* 152 */           i$ = 0.0D;
/*     */         }
/*     */         
/* 155 */         var29.field_72450_a += len$.field_72450_a * i$;
/* 156 */         var29.field_72448_b += len$.field_72448_b * i$;
/* 157 */         var29.field_72449_c += len$.field_72449_c * i$;
/* 158 */         if (showLog) {
/* 159 */           len$.func_72442_b((float)(ac.getRotYaw() * Math.PI / 180.0D));
/* 160 */           MCH_Lib.DbgLog(ac.field_70170_p, "%2d : %.2f :[%+.1f, %+.1f, %+.1f][%s %d %d][%+.2f(%+.2f), %+.2f(%+.2f)][%+.1f, %+.1f, %+.1f]", new Object[] { Integer.valueOf(var33), Double.valueOf(i$), Double.valueOf(len$.field_72450_a), Double.valueOf(len$.field_72448_b), Double.valueOf(len$.field_72449_c), var34.isPlus ? "+" : "-", Integer.valueOf(var34.field_70122_E ? 1 : 0), Integer.valueOf(ogpf.field_70122_E ? 1 : 0), Double.valueOf(var34.field_70163_u - var34.field_70167_r), Double.valueOf(var34.field_70181_x), Double.valueOf(ogpf.field_70163_u - ogpf.field_70167_r), Double.valueOf(ogpf.field_70181_x), Double.valueOf(len$.field_72450_a), Double.valueOf(len$.field_72448_b), Double.valueOf(len$.field_72449_c) });
/*     */         } 
/*     */       } 
/*     */       
/* 164 */       var29 = var29.func_72432_b();
/* 165 */       if (var29.field_72448_b > 0.01D && var29.field_72448_b < 0.7D) {
/* 166 */         ac.field_70159_w += var29.field_72450_a / 50.0D;
/* 167 */         ac.field_70179_y += var29.field_72449_c / 50.0D;
/*     */       } 
/*     */       
/* 170 */       var29.func_72442_b((float)(ac.getRotYaw() * Math.PI / 180.0D));
/* 171 */       float var35 = (float)(90.0D - Math.atan2(var29.field_72448_b, var29.field_72449_c) * 180.0D / Math.PI);
/* 172 */       float var36 = -((float)(90.0D - Math.atan2(var29.field_72448_b, var29.field_72450_a) * 180.0D / Math.PI));
/* 173 */       float var37 = (ac.getAcInfo()).onGroundPitchFactor;
/* 174 */       if (var35 - ac.getRotPitch() > var37) {
/* 175 */         var35 = ac.getRotPitch() + var37;
/*     */       }
/*     */       
/* 178 */       if (var35 - ac.getRotPitch() < -var37) {
/* 179 */         var35 = ac.getRotPitch() - var37;
/*     */       }
/*     */       
/* 182 */       float var38 = (ac.getAcInfo()).onGroundRollFactor;
/* 183 */       if (var36 - ac.getRotRoll() > var38) {
/* 184 */         var36 = ac.getRotRoll() + var38;
/*     */       }
/*     */       
/* 187 */       if (var36 - ac.getRotRoll() < -var38) {
/* 188 */         var36 = ac.getRotRoll() - var38;
/*     */       }
/*     */       
/* 191 */       this.targetPitch = var35;
/* 192 */       this.targetRoll = var36;
/* 193 */       if (!W_Lib.isClientPlayer(ac.getRiddenByEntity())) {
/* 194 */         ac.setRotPitch(var35);
/* 195 */         ac.setRotRoll(var36);
/*     */       } 
/*     */       
/* 198 */       if (showLog) {
/* 199 */         MCH_Lib.DbgLog(ac.field_70170_p, "%+03d, %+03d :[%.2f, %.2f, %.2f] yaw=%.2f, pitch=%.2f, roll=%.2f", new Object[] { Integer.valueOf((int)var35), Integer.valueOf((int)var36), Double.valueOf(var29.field_72450_a), Double.valueOf(var29.field_72448_b), Double.valueOf(var29.field_72449_c), Float.valueOf(ac.getRotYaw()), Float.valueOf(this.targetPitch), Float.valueOf(this.targetRoll) });
/*     */       }
/*     */       
/* 202 */       MCH_EntityWheel[] var39 = this.wheels;
/* 203 */       int var40 = var39.length;
/*     */       
/* 205 */       for (int var41 = 0; var41 < var40; var41++) {
/* 206 */         MCH_EntityWheel wheel = var39[var41];
/* 207 */         Vec3 v = getTransformedPosition(wheel.pos.field_72450_a, wheel.pos.field_72448_b, wheel.pos.field_72449_c, ac, ac.getRotYaw(), this.targetPitch, this.targetRoll);
/* 208 */         double offset = wheel.field_70122_E ? 0.01D : -0.0D;
/* 209 */         double rangeH = 2.0D;
/* 210 */         double poy = (wheel.field_70138_W / 2.0F);
/* 211 */         int b = 0;
/* 212 */         if (wheel.field_70165_t > v.field_72450_a + rangeH) {
/* 213 */           wheel.field_70165_t = v.field_72450_a + rangeH;
/* 214 */           wheel.field_70163_u = v.field_72448_b + poy;
/* 215 */           b |= 0x1;
/*     */         } 
/*     */         
/* 218 */         if (wheel.field_70165_t < v.field_72450_a - rangeH) {
/* 219 */           wheel.field_70165_t = v.field_72450_a - rangeH;
/* 220 */           wheel.field_70163_u = v.field_72448_b + poy;
/* 221 */           b |= 0x2;
/*     */         } 
/*     */         
/* 224 */         if (wheel.field_70161_v > v.field_72449_c + rangeH) {
/* 225 */           wheel.field_70161_v = v.field_72449_c + rangeH;
/* 226 */           wheel.field_70163_u = v.field_72448_b + poy;
/* 227 */           b |= 0x4;
/*     */         } 
/*     */         
/* 230 */         if (wheel.field_70161_v < v.field_72449_c - rangeH) {
/* 231 */           wheel.field_70161_v = v.field_72449_c - rangeH;
/* 232 */           wheel.field_70163_u = v.field_72448_b + poy;
/* 233 */           b |= 0x8;
/*     */         } 
/*     */         
/* 236 */         wheel.func_70080_a(wheel.field_70165_t, wheel.field_70163_u, wheel.field_70161_v, 0.0F, 0.0F);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Vec3 getTransformedPosition(double x, double y, double z, MCH_EntityAircraft ac, float yaw, float pitch, float roll) {
/* 243 */     Vec3 v = MCH_Lib.RotVec3(x, y, z, -yaw, -pitch, -roll);
/* 244 */     return v.func_72441_c(ac.field_70165_t, ac.field_70163_u, ac.field_70161_v);
/*     */   }
/*     */   
/*     */   public void updateBlock() {
/* 248 */     MCH_Config var10000 = MCH_MOD.config;
/* 249 */     if (MCH_Config.Collision_DestroyBlock.prmBool) {
/* 250 */       MCH_EntityAircraft ac = this.parent;
/* 251 */       MCH_EntityWheel[] arr$ = this.wheels;
/* 252 */       int len$ = arr$.length;
/*     */       
/* 254 */       for (int i$ = 0; i$ < len$; i$++) {
/* 255 */         MCH_EntityWheel w = arr$[i$];
/* 256 */         Vec3 v = ac.getTransformedPosition(w.pos);
/* 257 */         int x = (int)(v.field_72450_a + 0.5D);
/* 258 */         int y = (int)(v.field_72448_b + 0.5D);
/* 259 */         int z = (int)(v.field_72449_c + 0.5D);
/* 260 */         Block block = ac.field_70170_p.func_147439_a(x, y, z);
/* 261 */         if (block == W_Block.getSnowLayer()) {
/* 262 */           ac.field_70170_p.func_147468_f(x, y, z);
/*     */         }
/*     */         
/* 265 */         if (block == Blocks.field_150392_bi || block == Blocks.field_150414_aQ) {
/* 266 */           W_WorldFunc.destroyBlock(ac.field_70170_p, x, y, z, false);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void particleLandingGear() {
/* 274 */     if (this.wheels.length > 0) {
/* 275 */       MCH_EntityAircraft ac = this.parent;
/* 276 */       double d = ac.field_70159_w * ac.field_70159_w + ac.field_70179_y * ac.field_70179_y + Math.abs(this.prevYaw - ac.getRotYaw());
/* 277 */       this.prevYaw = ac.getRotYaw();
/* 278 */       if (d > 0.001D)
/* 279 */         for (int i = 0; i < 2; i++) {
/* 280 */           MCH_EntityWheel w = this.wheels[rand.nextInt(this.wheels.length)];
/* 281 */           Vec3 v = ac.getTransformedPosition(w.pos);
/* 282 */           int x = MathHelper.func_76128_c(v.field_72450_a + 0.5D);
/* 283 */           int y = MathHelper.func_76128_c(v.field_72448_b - 0.5D);
/* 284 */           int z = MathHelper.func_76128_c(v.field_72449_c + 0.5D);
/* 285 */           Block block = ac.field_70170_p.func_147439_a(x, y, z);
/* 286 */           if (Block.func_149680_a(block, Blocks.field_150350_a)) {
/* 287 */             y = MathHelper.func_76128_c(v.field_72448_b + 0.5D);
/* 288 */             block = ac.field_70170_p.func_147439_a(x, y, z);
/*     */           } 
/*     */           
/* 291 */           if (!Block.func_149680_a(block, Blocks.field_150350_a))
/* 292 */             MCH_ParticlesUtil.spawnParticleTileCrack(ac.field_70170_p, x, y, z, v.field_72450_a + rand.nextFloat() - 0.5D, v.field_72448_b + 0.1D, v.field_72449_c + rand.nextFloat() - 0.5D, -ac.field_70159_w * 4.0D + (rand.nextFloat() - 0.5D) * 0.1D, rand.nextFloat() * 0.5D, -ac.field_70179_y * 4.0D + (rand.nextFloat() - 0.5D) * 0.1D); 
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tank\MCH_WheelManager.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */