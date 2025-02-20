/*     */ package mcheli.weapon;
/*     */ 
/*     */ import java.util.Random;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MCH_WeaponBase
/*     */ {
/*  17 */   protected static final Random rand = new Random();
/*     */   
/*     */   public final World worldObj;
/*     */   public final Vec3 position;
/*     */   public final float fixRotationYaw;
/*     */   public final float fixRotationPitch;
/*     */   public final String name;
/*     */   public final MCH_WeaponInfo weaponInfo;
/*     */   public String displayName;
/*     */   public int power;
/*     */   public float acceleration;
/*     */   public int explosionPower;
/*     */   public int explosionPowerInWater;
/*     */   public int interval;
/*     */   public int numMode;
/*     */   public int lockTime;
/*     */   public int piercing;
/*     */   public int heatCount;
/*     */   public MCH_Cartridge cartridge;
/*     */   public boolean onTurret;
/*     */   public MCH_EntityAircraft aircraft;
/*     */   public int tick;
/*     */   public int optionParameter1;
/*     */   public int optionParameter2;
/*     */   private int currentMode;
/*     */   public boolean canPlaySound;
/*     */   
/*     */   public MCH_WeaponBase(World w, Vec3 v, float yaw, float pitch, String nm, MCH_WeaponInfo wi) {
/*  45 */     this.worldObj = w;
/*  46 */     this.position = v;
/*  47 */     this.fixRotationYaw = yaw;
/*  48 */     this.fixRotationPitch = pitch;
/*  49 */     this.name = nm;
/*  50 */     this.weaponInfo = wi;
/*  51 */     this.displayName = (wi != null) ? wi.displayName : "";
/*  52 */     this.power = 0;
/*  53 */     this.acceleration = 0.0F;
/*  54 */     this.explosionPower = 0;
/*  55 */     this.explosionPowerInWater = 0;
/*  56 */     this.interval = 1;
/*  57 */     this.numMode = 0;
/*  58 */     this.lockTime = 0;
/*  59 */     this.heatCount = 0;
/*  60 */     this.cartridge = null;
/*  61 */     this.tick = 0;
/*  62 */     this.optionParameter1 = 0;
/*  63 */     this.optionParameter2 = 0;
/*  64 */     setCurrentMode(0);
/*  65 */     this.canPlaySound = true;
/*     */   }
/*     */   
/*     */   public MCH_WeaponInfo getInfo() {
/*  69 */     return this.weaponInfo;
/*     */   }
/*     */   
/*     */   public String getName() {
/*  73 */     return this.displayName;
/*     */   }
/*     */   
/*     */   public abstract boolean shot(MCH_WeaponParam paramMCH_WeaponParam);
/*     */   
/*     */   public void setLockChecker(MCH_IEntityLockChecker checker) {}
/*     */   
/*     */   public void setLockCountMax(int n) {}
/*     */   
/*     */   public int getLockCount() {
/*  83 */     return 0;
/*     */   }
/*     */   
/*     */   public int getLockCountMax() {
/*  87 */     return 0;
/*     */   }
/*     */   
/*     */   public final int getNumAmmoMax() {
/*  91 */     return (getInfo()).round;
/*     */   }
/*     */   
/*     */   public int getCurrentMode() {
/*  95 */     return (getInfo() != null && (getInfo()).fixMode > 0) ? (getInfo()).fixMode : this.currentMode;
/*     */   }
/*     */   
/*     */   public void setCurrentMode(int currentMode) {
/*  99 */     this.currentMode = currentMode;
/*     */   }
/*     */   
/*     */   public final int getAllAmmoNum() {
/* 103 */     return (getInfo()).maxAmmo;
/*     */   }
/*     */   
/*     */   public final int getReloadCount() {
/* 107 */     return (getInfo()).reloadTime;
/*     */   }
/*     */   
/*     */   public final MCH_SightType getSightType() {
/* 111 */     return (getInfo()).sight;
/*     */   }
/*     */   
/*     */   public MCH_WeaponGuidanceSystem getGuidanceSystem() {
/* 115 */     return null;
/*     */   }
/*     */   
/*     */   public void update(int countWait) {
/* 119 */     if (countWait != 0) {
/* 120 */       this.tick++;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean isCooldownCountReloadTime() {
/* 126 */     return false;
/*     */   }
/*     */   
/*     */   public void modifyCommonParameters() {
/* 130 */     modifyParameters();
/*     */   }
/*     */   
/*     */   public void modifyParameters() {}
/*     */   
/*     */   public boolean switchMode() {
/* 136 */     if (getInfo() != null && (getInfo()).fixMode > 0) {
/* 137 */       return false;
/*     */     }
/* 139 */     int beforeMode = getCurrentMode();
/* 140 */     if (this.numMode > 0) {
/* 141 */       setCurrentMode((getCurrentMode() + 1) % this.numMode);
/*     */     } else {
/* 143 */       setCurrentMode(0);
/*     */     } 
/*     */     
/* 146 */     if (beforeMode != getCurrentMode()) {
/* 147 */       onSwitchMode();
/*     */     }
/*     */     
/* 150 */     return (beforeMode != getCurrentMode());
/*     */   }
/*     */ 
/*     */   
/*     */   public void onSwitchMode() {}
/*     */   
/*     */   public boolean use(MCH_WeaponParam prm) {
/* 157 */     Vec3 v = getShotPos(prm.entity);
/* 158 */     prm.posX += v.field_72450_a;
/* 159 */     prm.posY += v.field_72448_b;
/* 160 */     prm.posZ += v.field_72449_c;
/* 161 */     if (shot(prm)) {
/* 162 */       this.tick = 0;
/* 163 */       return true;
/*     */     } 
/* 165 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public Vec3 getShotPos(Entity entity) {
/* 170 */     if (entity instanceof MCH_EntityAircraft && this.onTurret) {
/* 171 */       return ((MCH_EntityAircraft)entity).calcOnTurretPos(this.position);
/*     */     }
/* 173 */     Vec3 v = Vec3.func_72443_a(this.position.field_72450_a, this.position.field_72448_b, this.position.field_72449_c);
/* 174 */     float roll = (entity instanceof MCH_EntityAircraft) ? ((MCH_EntityAircraft)entity).getRotRoll() : 0.0F;
/* 175 */     return MCH_Lib.RotVec3(v, -entity.field_70177_z, -entity.field_70125_A, -roll);
/*     */   }
/*     */ 
/*     */   
/*     */   public void playSound(Entity e) {
/* 180 */     playSound(e, (getInfo()).soundFileName);
/*     */   }
/*     */   
/*     */   public void playSound(Entity e, String snd) {
/* 184 */     if (!e.field_70170_p.field_72995_K && this.canPlaySound && getInfo() != null) {
/* 185 */       float prnd = (getInfo()).soundPitchRandom;
/* 186 */       W_WorldFunc.MOD_playSoundEffect(this.worldObj, e.field_70165_t, e.field_70163_u, e.field_70161_v, snd, (getInfo()).soundVolume, (getInfo()).soundPitch * (1.0F - prnd) + rand.nextFloat() * prnd);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void playSoundClient(Entity e, float volume, float pitch) {
/* 192 */     if (e.field_70170_p.field_72995_K && getInfo() != null) {
/* 193 */       W_McClient.MOD_playSoundFX((getInfo()).soundFileName, volume, pitch);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public double getLandInDistance(MCH_WeaponParam prm) {
/* 199 */     if (this.weaponInfo == null)
/* 200 */       return -1.0D; 
/* 201 */     if (this.weaponInfo.gravity >= 0.0F) {
/* 202 */       return -1.0D;
/*     */     }
/* 204 */     Vec3 v = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -prm.rotYaw, -prm.rotPitch, -prm.rotRoll);
/* 205 */     double s = Math.sqrt(v.field_72450_a * v.field_72450_a + v.field_72448_b * v.field_72448_b + v.field_72449_c * v.field_72449_c);
/* 206 */     double acc = (this.acceleration < 4.0F) ? this.acceleration : 4.0D;
/* 207 */     double accFac = this.acceleration / acc;
/* 208 */     double my = v.field_72448_b * this.acceleration / s;
/* 209 */     if (my <= 0.0D) {
/* 210 */       return -1.0D;
/*     */     }
/* 212 */     double mx = v.field_72450_a * this.acceleration / s;
/* 213 */     double mz = v.field_72449_c * this.acceleration / s;
/* 214 */     double ls = my / this.weaponInfo.gravity;
/* 215 */     double gravity = this.weaponInfo.gravity * accFac;
/*     */     
/* 217 */     if (ls < -12.0D) {
/* 218 */       double d = ls / -12.0D;
/* 219 */       mx *= d;
/* 220 */       my *= d;
/* 221 */       mz *= d;
/* 222 */       gravity *= d * d * 0.95D;
/*     */     } 
/*     */     
/* 225 */     double spx = prm.posX;
/* 226 */     double spy = prm.posY + 3.0D;
/* 227 */     double spz = prm.posZ;
/* 228 */     Vec3 vs = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/* 229 */     Vec3 ve = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/*     */     
/* 231 */     for (int i = 0; i < 50; i++) {
/* 232 */       vs.field_72450_a = spx;
/* 233 */       vs.field_72448_b = spy;
/* 234 */       vs.field_72449_c = spz;
/* 235 */       ve.field_72450_a = spx + mx;
/* 236 */       ve.field_72448_b = spy + my;
/* 237 */       ve.field_72449_c = spz + mz;
/* 238 */       MovingObjectPosition mop = this.worldObj.func_72933_a(vs, ve);
/*     */ 
/*     */       
/* 241 */       if (mop != null && mop.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
/* 242 */         double dx = mop.field_72311_b - prm.posX;
/* 243 */         double dz = mop.field_72309_d - prm.posZ;
/* 244 */         return Math.sqrt(dx * dx + dz * dz);
/*     */       } 
/*     */       
/* 247 */       my += gravity;
/* 248 */       spx += mx;
/* 249 */       spy += my;
/* 250 */       spz += mz;
/* 251 */       if (spy < prm.posY) {
/* 252 */         double dx = spx - prm.posX;
/* 253 */         double dz = spz - prm.posZ;
/* 254 */         return Math.sqrt(dx * dx + dz * dz);
/*     */       } 
/*     */     } 
/*     */     
/* 258 */     return -1.0D;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */