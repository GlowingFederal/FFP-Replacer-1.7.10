/*     */ package mcheli.flare;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.particles.MCH_ParticleParam;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_Flare
/*     */ {
/*     */   public final World worldObj;
/*     */   public final MCH_EntityAircraft aircraft;
/*     */   public final Random rand;
/*     */   public int numFlare;
/*     */   public int tick;
/*     */   private int flareType;
/*  23 */   private static FlareParam[] FLARE_DATA = null;
/*     */ 
/*     */   
/*     */   public MCH_Flare(World w, MCH_EntityAircraft ac) {
/*  27 */     this.worldObj = w;
/*  28 */     this.aircraft = ac;
/*  29 */     this.rand = new Random();
/*  30 */     this.tick = 0;
/*  31 */     this.numFlare = 0;
/*  32 */     this.flareType = 0;
/*  33 */     if (FLARE_DATA == null) {
/*  34 */       int delay = w.field_72995_K ? 50 : 0;
/*  35 */       FLARE_DATA = new FlareParam[11];
/*  36 */       FLARE_DATA[1] = new FlareParam(1, 3, 200 + delay, 100, 16);
/*  37 */       FLARE_DATA[2] = new FlareParam(3, 5, 300 + delay, 200, 16);
/*  38 */       FLARE_DATA[3] = new FlareParam(2, 3, 200 + delay, 100, 16);
/*  39 */       FLARE_DATA[4] = new FlareParam(1, 3, 200 + delay, 100, 16);
/*  40 */       FLARE_DATA[5] = new FlareParam(2, 3, 200 + delay, 100, 16);
/*  41 */       FLARE_DATA[10] = new FlareParam(8, 1, 250 + delay, 60, 1);
/*  42 */       FLARE_DATA[0] = FLARE_DATA[1];
/*  43 */       FLARE_DATA[6] = FLARE_DATA[1];
/*  44 */       FLARE_DATA[7] = FLARE_DATA[1];
/*  45 */       FLARE_DATA[8] = FLARE_DATA[1];
/*  46 */       FLARE_DATA[9] = FLARE_DATA[1];
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isInPreparation() {
/*  52 */     return (this.tick != 0);
/*     */   }
/*     */   
/*     */   public boolean isUsing() {
/*  56 */     int type = getFlareType();
/*  57 */     return (this.tick != 0 && type < FLARE_DATA.length && this.tick > (FLARE_DATA[type]).tickWait - (FLARE_DATA[type]).tickEnable);
/*     */   }
/*     */   
/*     */   public int getFlareType() {
/*  61 */     return this.flareType;
/*     */   }
/*     */   
/*     */   public void spawnParticle(String name, int num, float size) {
/*  65 */     if (this.worldObj.field_72995_K) {
/*  66 */       if (name.isEmpty() || num < 1 || num > 50) {
/*     */         return;
/*     */       }
/*     */       
/*  70 */       double x = (this.aircraft.field_70165_t - this.aircraft.field_70169_q) / num;
/*  71 */       double y = (this.aircraft.field_70163_u - this.aircraft.field_70167_r) / num;
/*  72 */       double z = (this.aircraft.field_70161_v - this.aircraft.field_70166_s) / num;
/*     */       
/*  74 */       for (int i = 0; i < num; i++) {
/*  75 */         MCH_ParticleParam prm = new MCH_ParticleParam(this.worldObj, "smoke", this.aircraft.field_70169_q + x * i, this.aircraft.field_70167_r + y * i, this.aircraft.field_70166_s + z * i);
/*  76 */         prm.size = size + this.rand.nextFloat();
/*  77 */         MCH_ParticlesUtil.spawnParticle(prm);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean use(int type) {
/*  84 */     boolean result = false;
/*  85 */     MCH_Lib.DbgLog(this.aircraft.field_70170_p, "MCH_Flare.use type = %d", new Object[] { Integer.valueOf(type) });
/*  86 */     this.flareType = type;
/*  87 */     if (type <= 0 && type >= FLARE_DATA.length) {
/*  88 */       return false;
/*     */     }
/*  90 */     if (this.worldObj.field_72995_K) {
/*  91 */       if (this.tick == 0) {
/*  92 */         this.tick = (FLARE_DATA[getFlareType()]).tickWait;
/*  93 */         result = true;
/*  94 */         this.numFlare = 0;
/*  95 */         W_McClient.DEF_playSoundFX("random.click", 1.0F, 1.0F);
/*     */       } 
/*     */     } else {
/*  98 */       result = true;
/*  99 */       this.numFlare = 0;
/* 100 */       this.tick = (FLARE_DATA[getFlareType()]).tickWait;
/* 101 */       this.aircraft.getEntityData().func_74757_a("FlareUsing", true);
/*     */     } 
/*     */     
/* 104 */     return result;
/*     */   }
/*     */ 
/*     */   
/*     */   public void update() {
/* 109 */     int type = getFlareType();
/* 110 */     if (this.aircraft != null && !this.aircraft.field_70128_L && type > 0 && type <= FLARE_DATA.length) {
/* 111 */       if (this.tick > 0) {
/* 112 */         this.tick--;
/*     */       }
/*     */       
/* 115 */       if (!this.worldObj.field_72995_K && this.tick > 0 && this.tick % (FLARE_DATA[type]).interval == 0 && this.numFlare < (FLARE_DATA[type]).numFlareMax) {
/* 116 */         Vec3 v = (this.aircraft.getAcInfo()).flare.pos;
/* 117 */         v = this.aircraft.getTransformedPosition(v.field_72450_a, v.field_72448_b, v.field_72449_c, this.aircraft.field_70169_q, this.aircraft.field_70167_r, this.aircraft.field_70166_s);
/* 118 */         spawnFlare(v);
/*     */       } 
/*     */       
/* 121 */       if (!isUsing() && this.aircraft.getEntityData().func_74767_n("FlareUsing")) {
/* 122 */         this.aircraft.getEntityData().func_74757_a("FlareUsing", false);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void spawnFlare(Vec3 v) {
/* 129 */     this.numFlare++;
/* 130 */     int type = getFlareType();
/* 131 */     int num = (FLARE_DATA[type]).num;
/* 132 */     double x = v.field_72450_a - this.aircraft.field_70159_w * 2.0D;
/* 133 */     double y = v.field_72448_b - this.aircraft.field_70181_x * 2.0D - 1.0D;
/* 134 */     double z = v.field_72449_c - this.aircraft.field_70179_y * 2.0D;
/* 135 */     this.worldObj.func_72889_a((EntityPlayer)null, 1004, (int)x, (int)y, (int)z, 0);
/*     */     
/* 137 */     for (int i = 0; i < num; i++) {
/* 138 */       x = v.field_72450_a - this.aircraft.field_70159_w * 2.0D;
/* 139 */       y = v.field_72448_b - this.aircraft.field_70181_x * 2.0D - 1.0D;
/* 140 */       z = v.field_72449_c - this.aircraft.field_70179_y * 2.0D;
/* 141 */       double tx = 0.0D;
/* 142 */       double ty = this.aircraft.field_70181_x;
/* 143 */       double tz = 0.0D;
/* 144 */       byte fuseCount = 0;
/* 145 */       double r = this.aircraft.field_70177_z;
/* 146 */       if (type == 1) {
/* 147 */         tx = MathHelper.func_76126_a(this.rand.nextFloat() * 360.0F);
/* 148 */         tz = MathHelper.func_76134_b(this.rand.nextFloat() * 360.0F);
/* 149 */       } else if (type != 2 && type != 3) {
/* 150 */         if (type == 4) {
/* 151 */           r *= 0.017453292519943295D;
/* 152 */           tx = -Math.sin(r) + (this.rand.nextFloat() - 0.5D) * 1.3D;
/* 153 */           tz = Math.cos(r) + (this.rand.nextFloat() - 0.5D) * 1.3D;
/* 154 */         } else if (type == 5) {
/* 155 */           r *= 0.017453292519943295D;
/* 156 */           tx = -Math.sin(r) + (this.rand.nextFloat() - 0.5D) * 0.9D;
/* 157 */           tz = Math.cos(r) + (this.rand.nextFloat() - 0.5D) * 0.9D;
/* 158 */           tx *= 0.3D;
/* 159 */           tz *= 0.3D;
/*     */         } 
/*     */       } else {
/* 162 */         if (i == 0) {
/* 163 */           r += 90.0D;
/*     */         }
/*     */         
/* 166 */         if (i == 1) {
/* 167 */           r -= 90.0D;
/*     */         }
/*     */         
/* 170 */         if (i == 2) {
/* 171 */           r += 180.0D;
/*     */         }
/*     */         
/* 174 */         r *= 0.017453292519943295D;
/* 175 */         tx = -Math.sin(r) + (this.rand.nextFloat() - 0.5D) * 0.6D;
/* 176 */         tz = Math.cos(r) + (this.rand.nextFloat() - 0.5D) * 0.6D;
/*     */       } 
/*     */       
/* 179 */       tx += this.aircraft.field_70159_w;
/* 180 */       ty += this.aircraft.field_70181_x / 2.0D;
/* 181 */       tz += this.aircraft.field_70179_y;
/* 182 */       if (type == 10) {
/* 183 */         r += (360 / num / 2 + i * 360 / num);
/* 184 */         r *= 0.017453292519943295D;
/* 185 */         tx = -Math.sin(r) * 2.0D;
/* 186 */         tz = Math.cos(r) * 2.0D;
/* 187 */         ty = 0.7D;
/* 188 */         y += 2.0D;
/* 189 */         fuseCount = 10;
/*     */       } 
/*     */       
/* 192 */       MCH_EntityFlare e = new MCH_EntityFlare(this.worldObj, x, y, z, tx * 0.5D, ty * 0.5D, tz * 0.5D, 6.0F, fuseCount);
/* 193 */       e.field_70125_A = this.rand.nextFloat() * 360.0F;
/* 194 */       e.field_70177_z = this.rand.nextFloat() * 360.0F;
/* 195 */       e.field_70127_C = this.rand.nextFloat() * 360.0F;
/* 196 */       e.field_70126_B = this.rand.nextFloat() * 360.0F;
/* 197 */       if (type == 4) {
/* 198 */         e.gravity *= 0.6D;
/* 199 */         e.airResistance = 0.995D;
/*     */       } 
/*     */       
/* 202 */       this.worldObj.func_72838_d((Entity)e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private class FlareParam
/*     */   {
/*     */     public final int num;
/*     */     
/*     */     public final int interval;
/*     */     
/*     */     public final int tickWait;
/*     */     public final int tickEnable;
/*     */     public final int numFlareMax;
/*     */     
/*     */     public FlareParam(int num, int interval, int tickWait, int tickEnable, int numFlareMax) {
/* 218 */       this.num = num;
/* 219 */       this.interval = interval;
/* 220 */       this.tickWait = tickWait;
/* 221 */       this.tickEnable = tickEnable;
/* 222 */       this.numFlareMax = numFlareMax;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\flare\MCH_Flare.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */