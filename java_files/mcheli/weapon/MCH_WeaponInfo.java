/*     */ package mcheli.weapon;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_BaseInfo;
/*     */ import mcheli.MCH_Color;
/*     */ import mcheli.MCH_DamageFactor;
/*     */ import mcheli.helicopter.MCH_EntityHeli;
/*     */ import mcheli.plane.MCP_EntityPlane;
/*     */ import mcheli.tank.MCH_EntityTank;
/*     */ import mcheli.vehicle.MCH_EntityVehicle;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ 
/*     */ public class MCH_WeaponInfo
/*     */   extends MCH_BaseInfo {
/*     */   public final String name;
/*     */   public String displayName;
/*     */   public String type;
/*     */   public int power;
/*     */   public float acceleration;
/*     */   public float accelerationInWater;
/*     */   public int explosion;
/*     */   public int explosionBlock;
/*     */   public int explosionInWater;
/*     */   public int explosionAltitude;
/*     */   public int delayFuse;
/*     */   public float bound;
/*     */   public int timeFuse;
/*     */   public boolean flaming;
/*     */   public MCH_SightType sight;
/*     */   public float[] zoom;
/*     */   public int delay;
/*     */   public int reloadTime;
/*     */   public int round;
/*     */   public int suppliedNum;
/*     */   public int maxAmmo;
/*     */   public List roundItems;
/*     */   public int soundDelay;
/*     */   public float soundVolume;
/*     */   public float soundPitch;
/*     */   public float soundPitchRandom;
/*     */   public int soundPattern;
/*     */   public int lockTime;
/*     */   public boolean ridableOnly;
/*     */   public float proximityFuseDist;
/*     */   public int rigidityTime;
/*     */   public float accuracy;
/*     */   public int bomblet;
/*     */   public int bombletSTime;
/*     */   public float bombletDiff;
/*     */   public int modeNum;
/*     */   public int fixMode;
/*     */   public int piercing;
/*     */   public int heatCount;
/*     */   public int maxHeatCount;
/*     */   public boolean isFAE;
/*     */   public boolean isGuidedTorpedo;
/*     */   public float gravity;
/*     */   public float gravityInWater;
/*     */   public float velocityInWater;
/*     */   public boolean destruct;
/*     */   public String trajectoryParticleName;
/*     */   public int trajectoryParticleStartTick;
/*     */   public boolean disableSmoke;
/*     */   public MCH_Cartridge cartridge;
/*     */   public MCH_Color color;
/*     */   public MCH_Color colorInWater;
/*     */   public String soundFileName;
/*     */   public float smokeSize;
/*     */   public int smokeNum;
/*     */   public int smokeMaxAge;
/*     */   public Item dispenseItem;
/*     */   public int dispenseDamege;
/*     */   public int dispenseRange;
/*     */   public int recoilBufCount;
/*     */   public int recoilBufCountSpeed;
/*     */   public float length;
/*     */   public float radius;
/*     */   public float angle;
/*     */   public boolean displayMortarDistance;
/*     */   public boolean fixCameraPitch;
/*     */   public float cameraRotationSpeedPitch;
/*     */   public int target;
/*     */   public int markTime;
/*     */   public float recoil;
/*     */   public String bulletModelName;
/*     */   public MCH_BulletModel bulletModel;
/*     */   public String bombletModelName;
/*     */   public MCH_BulletModel bombletModel;
/*     */   public MCH_DamageFactor damageFactor;
/*     */   public String group;
/*     */   public List listMuzzleFlash;
/*     */   public List listMuzzleFlashSmoke;
/*     */   public boolean canLoadChunks;
/*     */   public int minShotAlt;
/*     */   public int minShotDist;
/*     */   public float maxDegrees;
/*     */   public boolean isMultiStep;
/* 103 */   public String gpsSubType = "";
/*     */ 
/*     */   
/*     */   public MCH_WeaponInfo(String name) {
/* 107 */     this.name = name;
/* 108 */     this.displayName = name;
/* 109 */     this.type = "";
/* 110 */     this.power = 0;
/* 111 */     this.acceleration = 1.0F;
/* 112 */     this.accelerationInWater = 1.0F;
/* 113 */     this.explosion = 0;
/* 114 */     this.explosionBlock = -1;
/* 115 */     this.explosionInWater = 0;
/* 116 */     this.explosionAltitude = 0;
/* 117 */     this.delayFuse = 0;
/* 118 */     this.timeFuse = 0;
/* 119 */     this.flaming = false;
/* 120 */     this.sight = MCH_SightType.NONE;
/* 121 */     this.zoom = new float[] { 1.0F };
/* 122 */     this.delay = 10;
/* 123 */     this.reloadTime = 30;
/* 124 */     this.round = 0;
/* 125 */     this.suppliedNum = 1;
/* 126 */     this.roundItems = new ArrayList();
/* 127 */     this.maxAmmo = 0;
/* 128 */     this.soundDelay = 0;
/* 129 */     this.soundPattern = 0;
/* 130 */     this.soundVolume = 1.0F;
/* 131 */     this.soundPitch = 1.0F;
/* 132 */     this.soundPitchRandom = 0.1F;
/* 133 */     this.lockTime = 30;
/* 134 */     this.ridableOnly = false;
/* 135 */     this.proximityFuseDist = 0.0F;
/* 136 */     this.rigidityTime = 7;
/* 137 */     this.accuracy = 0.0F;
/* 138 */     this.bomblet = 0;
/* 139 */     this.bombletSTime = 10;
/* 140 */     this.bombletDiff = 0.3F;
/* 141 */     this.modeNum = 0;
/* 142 */     this.fixMode = 0;
/* 143 */     this.piercing = 0;
/* 144 */     this.heatCount = 0;
/* 145 */     this.maxHeatCount = 0;
/* 146 */     this.bulletModelName = "";
/* 147 */     this.bombletModelName = "";
/* 148 */     this.bulletModel = null;
/* 149 */     this.bombletModel = null;
/* 150 */     this.isFAE = false;
/* 151 */     this.isGuidedTorpedo = false;
/* 152 */     this.gravity = 0.0F;
/* 153 */     this.gravityInWater = 0.0F;
/* 154 */     this.velocityInWater = 0.999F;
/* 155 */     this.destruct = false;
/* 156 */     this.trajectoryParticleName = "explode";
/* 157 */     this.trajectoryParticleStartTick = 0;
/* 158 */     this.cartridge = null;
/* 159 */     this.disableSmoke = false;
/* 160 */     this.color = new MCH_Color();
/* 161 */     this.colorInWater = new MCH_Color();
/* 162 */     this.soundFileName = name + "_snd";
/* 163 */     this.smokeMaxAge = 100;
/* 164 */     this.smokeNum = 1;
/* 165 */     this.smokeSize = 2.0F;
/* 166 */     this.dispenseItem = null;
/* 167 */     this.dispenseDamege = 0;
/* 168 */     this.dispenseRange = 1;
/* 169 */     this.recoilBufCount = 2;
/* 170 */     this.recoilBufCountSpeed = 3;
/* 171 */     this.length = 0.0F;
/* 172 */     this.radius = 0.0F;
/* 173 */     this.target = 1;
/* 174 */     this.recoil = 0.0F;
/* 175 */     this.damageFactor = null;
/* 176 */     this.group = "";
/* 177 */     this.listMuzzleFlash = null;
/* 178 */     this.listMuzzleFlashSmoke = null;
/* 179 */     this.displayMortarDistance = false;
/* 180 */     this.fixCameraPitch = false;
/* 181 */     this.cameraRotationSpeedPitch = 1.0F;
/* 182 */     this.canLoadChunks = false;
/* 183 */     this.minShotDist = this.minShotAlt = -1;
/* 184 */     this.maxDegrees = 30.0F;
/* 185 */     this.isMultiStep = false;
/* 186 */     this.gpsSubType = "";
/*     */   }
/*     */   
/*     */   public void checkData() {
/* 190 */     if (this.explosionBlock < 0) {
/* 191 */       this.explosionBlock = this.explosion;
/*     */     }
/*     */     
/* 194 */     if (this.fixMode >= this.modeNum) {
/* 195 */       this.fixMode = 0;
/*     */     }
/*     */     
/* 198 */     if (this.round <= 0) {
/* 199 */       this.round = this.maxAmmo;
/*     */     }
/*     */     
/* 202 */     if (this.round > this.maxAmmo) {
/* 203 */       this.round = this.maxAmmo;
/*     */     }
/*     */     
/* 206 */     if (this.explosion <= 0) {
/* 207 */       this.isFAE = false;
/*     */     }
/*     */     
/* 210 */     if (this.delayFuse <= 0) {
/* 211 */       this.bound = 0.0F;
/*     */     }
/*     */     
/* 214 */     if (this.isFAE) {
/* 215 */       this.explosionInWater = 0;
/*     */     }
/*     */     
/* 218 */     if (this.bomblet > 0 && this.bombletSTime < 1) {
/* 219 */       this.bombletSTime = 1;
/*     */     }
/*     */     
/* 222 */     if (this.destruct) {
/* 223 */       this.delay = 1000000;
/*     */     }
/*     */     
/* 226 */     this.angle = (float)(Math.atan2(this.radius, this.length) * 180.0D / Math.PI);
/*     */   }
/*     */   
/*     */   public void loadItemData(String item, String data) {
/* 230 */     if (item.compareTo("displayname") == 0) {
/* 231 */       this.displayName = data;
/* 232 */     } else if (item.compareTo("type") == 0) {
/* 233 */       this.type = data.toLowerCase();
/* 234 */       if (this.type.equalsIgnoreCase("bomb") || this.type.equalsIgnoreCase("dispenser")) {
/* 235 */         this.gravity = -0.03F;
/* 236 */         this.gravityInWater = -0.03F;
/*     */       } 
/* 238 */     } else if (item.compareTo("group") == 0) {
/* 239 */       this.group = data.toLowerCase().trim();
/* 240 */     } else if (item.compareTo("power") == 0) {
/* 241 */       this.power = toInt(data);
/* 242 */     } else if (item.equalsIgnoreCase("sound")) {
/* 243 */       this.soundFileName = data.toLowerCase().trim();
/* 244 */     } else if (item.compareTo("acceleration") == 0) {
/* 245 */       this.acceleration = toFloat(data, 0.0F, 100.0F);
/* 246 */     } else if (item.compareTo("accelerationinwater") == 0) {
/* 247 */       this.accelerationInWater = toFloat(data, 0.0F, 100.0F);
/* 248 */     } else if (item.compareTo("gravity") == 0) {
/* 249 */       this.gravity = toFloat(data, -50.0F, 50.0F);
/* 250 */     } else if (item.compareTo("gravityinwater") == 0) {
/* 251 */       this.gravityInWater = toFloat(data, -50.0F, 50.0F);
/* 252 */     } else if (item.equalsIgnoreCase("VelocityInWater")) {
/* 253 */       this.velocityInWater = toFloat(data);
/* 254 */     } else if (item.compareTo("explosion") == 0) {
/* 255 */       this.explosion = toInt(data, 0, 50);
/* 256 */     } else if (item.equalsIgnoreCase("explosionBlock")) {
/* 257 */       this.explosionBlock = toInt(data, 0, 50);
/* 258 */     } else if (item.compareTo("explosioninwater") == 0) {
/* 259 */       this.explosionInWater = toInt(data, 0, 50);
/* 260 */     } else if (item.equalsIgnoreCase("ExplosionAltitude")) {
/* 261 */       this.explosionAltitude = toInt(data, 0, 100);
/* 262 */     } else if (item.equalsIgnoreCase("TimeFuse")) {
/* 263 */       this.timeFuse = toInt(data, 0, 100000);
/* 264 */     } else if (item.equalsIgnoreCase("DelayFuse")) {
/* 265 */       this.delayFuse = toInt(data, 0, 100000);
/* 266 */     } else if (item.equalsIgnoreCase("Bound")) {
/* 267 */       this.bound = toFloat(data, 0.0F, 100000.0F);
/* 268 */     } else if (item.compareTo("flaming") == 0) {
/* 269 */       this.flaming = toBool(data);
/* 270 */     } else if (item.equalsIgnoreCase("DisplayMortarDistance")) {
/* 271 */       this.displayMortarDistance = toBool(data);
/* 272 */     } else if (item.equalsIgnoreCase("FixCameraPitch")) {
/* 273 */       this.fixCameraPitch = toBool(data);
/* 274 */     } else if (item.equalsIgnoreCase("CameraRotationSpeedPitch")) {
/* 275 */       this.cameraRotationSpeedPitch = toFloat(data, 0.0F, 100.0F);
/* 276 */     } else if (item.compareTo("sight") == 0) {
/* 277 */       data = data.toLowerCase();
/* 278 */       if (data.compareTo("movesight") == 0) {
/* 279 */         this.sight = MCH_SightType.ROCKET;
/*     */       }
/*     */       
/* 282 */       if (data.compareTo("missilesight") == 0) {
/* 283 */         this.sight = MCH_SightType.LOCK;
/*     */       
/*     */       }
/*     */     
/*     */     }
/* 288 */     else if (item.equalsIgnoreCase("Zoom")) {
/* 289 */       String[] s = splitParam(data);
/* 290 */       if (s.length > 0) {
/* 291 */         this.zoom = new float[s.length];
/*     */         
/* 293 */         for (int c = 0; c < s.length; c++) {
/* 294 */           this.zoom[c] = toFloat(s[c], 0.1F, 10.0F);
/*     */         }
/*     */       } 
/* 297 */     } else if (item.compareTo("delay") == 0) {
/* 298 */       this.delay = toInt(data, 0, 100000);
/* 299 */     } else if (item.compareTo("reloadtime") == 0) {
/* 300 */       this.reloadTime = toInt(data, 3, 1000);
/* 301 */     } else if (item.compareTo("round") == 0) {
/* 302 */       this.round = toInt(data, 1, 30000);
/* 303 */     } else if (item.equalsIgnoreCase("MaxAmmo")) {
/* 304 */       this.maxAmmo = toInt(data, 0, 30000);
/* 305 */     } else if (item.equalsIgnoreCase("SuppliedNum")) {
/* 306 */       this.suppliedNum = toInt(data, 1, 30000);
/* 307 */     } else if (item.equalsIgnoreCase("Item")) {
/* 308 */       String[] s = data.split("\\s*,\\s*");
/* 309 */       if (s.length >= 2 && s[1].length() > 0 && this.roundItems.size() < 3) {
/* 310 */         int c = toInt(s[0], 1, 64);
/* 311 */         if (c > 0) {
/* 312 */           int className = (s.length >= 3) ? toInt(s[2], 0, 100000000) : 0;
/* 313 */           this.roundItems.add(new RoundItem(c, s[1].toLowerCase().trim(), className));
/*     */         } 
/*     */       } 
/* 316 */     } else if (item.compareTo("sounddelay") == 0) {
/* 317 */       this.soundDelay = toInt(data, 0, 1000);
/* 318 */     } else if (item.compareTo("soundpattern") != 0) {
/* 319 */       if (item.compareTo("soundvolume") == 0) {
/* 320 */         this.soundVolume = toFloat(data, 0.0F, 1000.0F);
/* 321 */       } else if (item.compareTo("soundpitch") == 0) {
/* 322 */         this.soundPitch = toFloat(data, 0.0F, 1.0F);
/* 323 */       } else if (item.equalsIgnoreCase("SoundPitchRandom")) {
/* 324 */         this.soundPitchRandom = toFloat(data, 0.0F, 1.0F);
/* 325 */       } else if (item.compareTo("locktime") == 0) {
/* 326 */         this.lockTime = toInt(data, 2, 1000);
/* 327 */       } else if (item.equalsIgnoreCase("RidableOnly")) {
/* 328 */         this.ridableOnly = toBool(data);
/* 329 */       } else if (item.compareTo("proximityfusedist") == 0) {
/* 330 */         this.proximityFuseDist = toFloat(data, 0.0F, 2000.0F);
/* 331 */       } else if (item.equalsIgnoreCase("RigidityTime")) {
/* 332 */         this.rigidityTime = toInt(data, 0, 1000000);
/* 333 */       } else if (item.compareTo("accuracy") == 0) {
/* 334 */         this.accuracy = toFloat(data, 0.0F, 1000.0F);
/* 335 */       } else if (item.compareTo("bomblet") == 0) {
/* 336 */         this.bomblet = toInt(data, 0, 1000);
/* 337 */       } else if (item.compareTo("bombletstime") == 0) {
/* 338 */         this.bombletSTime = toInt(data, 0, 1000);
/* 339 */       } else if (item.equalsIgnoreCase("BombletDiff")) {
/* 340 */         this.bombletDiff = toFloat(data, 0.0F, 1000.0F);
/* 341 */       } else if (item.equalsIgnoreCase("RecoilBufCount")) {
/* 342 */         String[] s = splitParam(data);
/* 343 */         if (s.length >= 1) {
/* 344 */           this.recoilBufCount = toInt(s[0], 1, 10000);
/*     */         }
/*     */         
/* 347 */         if (s.length >= 2 && this.recoilBufCount > 2) {
/* 348 */           this.recoilBufCountSpeed = toInt(s[1], 1, 10000) - 1;
/* 349 */           if (this.recoilBufCountSpeed > this.recoilBufCount / 2) {
/* 350 */             this.recoilBufCountSpeed = this.recoilBufCount / 2;
/*     */           }
/*     */         } 
/* 353 */       } else if (item.compareTo("modenum") == 0) {
/* 354 */         this.modeNum = toInt(data, 0, 1000);
/* 355 */       } else if (item.equalsIgnoreCase("FixMode")) {
/* 356 */         this.fixMode = toInt(data, 0, 10);
/* 357 */       } else if (item.compareTo("piercing") == 0) {
/* 358 */         this.piercing = toInt(data, 0, 100000);
/* 359 */       } else if (item.compareTo("heatcount") == 0) {
/* 360 */         this.heatCount = toInt(data, 0, 100000);
/* 361 */       } else if (item.compareTo("maxheatcount") == 0) {
/* 362 */         this.maxHeatCount = toInt(data, 0, 100000);
/* 363 */       } else if (item.compareTo("modelbullet") == 0) {
/* 364 */         this.bulletModelName = data.toLowerCase().trim();
/* 365 */       } else if (item.equalsIgnoreCase("ModelBomblet")) {
/* 366 */         this.bombletModelName = data.toLowerCase().trim();
/* 367 */       } else if (item.compareTo("fae") == 0) {
/* 368 */         this.isFAE = toBool(data);
/* 369 */       } else if (item.compareTo("guidedtorpedo") == 0) {
/* 370 */         this.isGuidedTorpedo = toBool(data);
/* 371 */       } else if (item.compareTo("destruct") == 0) {
/* 372 */         this.destruct = toBool(data);
/* 373 */       } else if (item.equalsIgnoreCase("CanLoadChunks")) {
/* 374 */         this.canLoadChunks = toBool(data);
/* 375 */       } else if (item.equalsIgnoreCase("MinShotAlt")) {
/* 376 */         this.minShotAlt = toInt(data);
/* 377 */       } else if (item.equalsIgnoreCase("MinShotDistance")) {
/* 378 */         this.minShotDist = toInt(data);
/* 379 */       } else if (item.equalsIgnoreCase("MaxDegrees")) {
/* 380 */         this.maxDegrees = toFloat(data);
/* 381 */       } else if (item.equalsIgnoreCase("IsMultiStep")) {
/* 382 */         this.isMultiStep = toBool(data);
/* 383 */       } else if (item.equalsIgnoreCase("SubTypeGPS")) {
/* 384 */         this.gpsSubType = data.toLowerCase().trim();
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/*     */       }
/* 393 */       else if (item.equalsIgnoreCase("AddMuzzleFlash")) {
/* 394 */         String[] s = splitParam(data);
/* 395 */         if (s.length >= 7) {
/* 396 */           if (this.listMuzzleFlash == null) {
/* 397 */             this.listMuzzleFlash = new ArrayList();
/*     */           }
/*     */           
/* 400 */           this.listMuzzleFlash.add(new MuzzleFlash(toFloat(s[0]), toFloat(s[1]), 0.0F, toInt(s[2]), toFloat(s[3]) / 255.0F, toFloat(s[4]) / 255.0F, toFloat(s[5]) / 255.0F, toFloat(s[6]) / 255.0F, 1));
/*     */         } 
/* 402 */       } else if (item.equalsIgnoreCase("AddMuzzleFlashSmoke")) {
/* 403 */         String[] s = splitParam(data);
/* 404 */         if (s.length >= 9) {
/* 405 */           if (this.listMuzzleFlashSmoke == null) {
/* 406 */             this.listMuzzleFlashSmoke = new ArrayList();
/*     */           }
/*     */           
/* 409 */           this.listMuzzleFlashSmoke.add(new MuzzleFlash(toFloat(s[0]), toFloat(s[2]), toFloat(s[3]), toInt(s[4]), toFloat(s[5]) / 255.0F, toFloat(s[6]) / 255.0F, toFloat(s[7]) / 255.0F, toFloat(s[8]) / 255.0F, toInt(s[1], 1, 1000)));
/*     */         } 
/* 411 */       } else if (item.equalsIgnoreCase("TrajectoryParticle")) {
/* 412 */         this.trajectoryParticleName = data.toLowerCase().trim();
/* 413 */         if (this.trajectoryParticleName.equalsIgnoreCase("none")) {
/* 414 */           this.trajectoryParticleName = "";
/*     */         }
/* 416 */       } else if (item.equalsIgnoreCase("TrajectoryParticleStartTick")) {
/* 417 */         this.trajectoryParticleStartTick = toInt(data, 0, 10000);
/* 418 */       } else if (item.equalsIgnoreCase("DisableSmoke")) {
/* 419 */         this.disableSmoke = toBool(data);
/*     */       
/*     */       }
/* 422 */       else if (item.equalsIgnoreCase("SetCartridge")) {
/* 423 */         String[] s = data.split("\\s*,\\s*");
/* 424 */         if (s.length > 0 && s[0].length() > 0) {
/* 425 */           float var10 = (s.length >= 2) ? toFloat(s[1]) : 0.0F;
/* 426 */           float var11 = (s.length >= 3) ? toFloat(s[2]) : 0.0F;
/* 427 */           float pt = (s.length >= 4) ? toFloat(s[3]) : 0.0F;
/* 428 */           float sc = (s.length >= 5) ? toFloat(s[4]) : 1.0F;
/* 429 */           float gr = (s.length >= 6) ? toFloat(s[5]) : -0.04F;
/* 430 */           float bo = (s.length >= 7) ? toFloat(s[6]) : 0.5F;
/* 431 */           this.cartridge = new MCH_Cartridge(s[0].toLowerCase(), var10, var11, pt, bo, gr, sc);
/*     */         } 
/* 433 */       } else if (!item.equalsIgnoreCase("BulletColorInWater") && !item.equalsIgnoreCase("BulletColor") && !item.equalsIgnoreCase("SmokeColor")) {
/* 434 */         if (item.equalsIgnoreCase("SmokeSize")) {
/* 435 */           this.smokeSize = toFloat(data, 0.0F, 100.0F);
/* 436 */         } else if (item.equalsIgnoreCase("SmokeNum")) {
/* 437 */           this.smokeNum = toInt(data, 1, 100);
/* 438 */         } else if (item.equalsIgnoreCase("SmokeMaxAge")) {
/* 439 */           this.smokeMaxAge = toInt(data, 2, 1000);
/* 440 */         } else if (item.equalsIgnoreCase("DispenseItem")) {
/* 441 */           String[] s = data.split("\\s*,\\s*");
/* 442 */           if (s.length >= 2) {
/* 443 */             this.dispenseDamege = toInt(s[1], 0, 100000000);
/*     */           }
/*     */           
/* 446 */           this.dispenseItem = W_Item.getItemByName(s[0]);
/* 447 */         } else if (item.equalsIgnoreCase("DispenseRange")) {
/* 448 */           this.dispenseRange = toInt(data, 1, 100);
/* 449 */         } else if (item.equalsIgnoreCase("Length")) {
/* 450 */           this.length = toInt(data, 1, 300);
/* 451 */         } else if (item.equalsIgnoreCase("Radius")) {
/* 452 */           this.radius = toInt(data, 1, 1000);
/* 453 */         } else if (item.equalsIgnoreCase("Target")) {
/* 454 */           if (data.indexOf("block") >= 0) {
/* 455 */             this.target = 64;
/*     */           } else {
/* 457 */             this.target = 0;
/* 458 */             this.target |= (data.indexOf("planes") >= 0) ? 32 : 0;
/* 459 */             this.target |= (data.indexOf("helicopters") >= 0) ? 16 : 0;
/* 460 */             this.target |= (data.indexOf("vehicles") >= 0) ? 8 : 0;
/* 461 */             this.target |= (data.indexOf("tanks") >= 0) ? 8 : 0;
/* 462 */             this.target |= (data.indexOf("players") >= 0) ? 4 : 0;
/* 463 */             this.target |= (data.indexOf("monsters") >= 0) ? 2 : 0;
/* 464 */             this.target |= (data.indexOf("others") >= 0) ? 1 : 0;
/*     */           } 
/* 466 */         } else if (item.equalsIgnoreCase("MarkTime")) {
/* 467 */           this.markTime = toInt(data, 1, 30000) + 1;
/* 468 */         } else if (item.equalsIgnoreCase("Recoil")) {
/* 469 */           this.recoil = toFloat(data, 0.0F, 100.0F);
/* 470 */         } else if (item.equalsIgnoreCase("DamageFactor")) {
/* 471 */           String[] s = splitParam(data);
/* 472 */           if (s.length >= 2) {
/* 473 */             Class<MCH_EntityHeli> clazz; Class<EntityPlayer> var13 = null;
/* 474 */             String var14 = s[0].toLowerCase();
/* 475 */             if (var14.equals("player")) {
/* 476 */               var13 = EntityPlayer.class;
/* 477 */             } else if (!var14.equals("heli") && !var14.equals("helicopter")) {
/* 478 */               if (var14.equals("plane")) {
/* 479 */                 Class<MCP_EntityPlane> clazz1 = MCP_EntityPlane.class;
/* 480 */               } else if (var14.equals("tank")) {
/* 481 */                 Class<MCH_EntityTank> clazz1 = MCH_EntityTank.class;
/* 482 */               } else if (var14.equals("vehicle")) {
/* 483 */                 Class<MCH_EntityVehicle> clazz1 = MCH_EntityVehicle.class;
/*     */               } 
/*     */             } else {
/* 486 */               clazz = MCH_EntityHeli.class;
/*     */             } 
/*     */             
/* 489 */             if (clazz != null) {
/* 490 */               if (this.damageFactor == null) {
/* 491 */                 this.damageFactor = new MCH_DamageFactor();
/*     */               }
/*     */               
/* 494 */               this.damageFactor.add(clazz, toFloat(s[1], 0.0F, 1000000.0F));
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } else {
/* 499 */         String[] s = data.split("\\s*,\\s*");
/* 500 */         if (s.length >= 4) {
/* 501 */           float var10 = 0.003921569F;
/* 502 */           MCH_Color var12 = new MCH_Color(0.003921569F * toInt(s[0], 0, 255), 0.003921569F * toInt(s[1], 0, 255), 0.003921569F * toInt(s[2], 0, 255), 0.003921569F * toInt(s[3], 0, 255));
/* 503 */           if (item.equalsIgnoreCase("BulletColorInWater")) {
/* 504 */             this.colorInWater = var12;
/*     */           } else {
/* 506 */             this.color = var12;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public float getDamageFactor(Entity e) {
/* 517 */     return (this.damageFactor != null) ? this.damageFactor.getDamageFactor(e) : 1.0F;
/*     */   }
/*     */   
/*     */   public String getWeaponTypeName() {
/* 521 */     return this.type.equalsIgnoreCase("MachineGun1") ? "MachineGun" : (this.type.equalsIgnoreCase("MachineGun2") ? "MachineGun" : (this.type.equalsIgnoreCase("Torpedo") ? "Torpedo" : (this.type.equalsIgnoreCase("CAS") ? "CAS" : (this.type.equalsIgnoreCase("Rocket") ? "Rocket" : ((this.type.equalsIgnoreCase("CruiseMissile") || this.type.equalsIgnoreCase("GPSMissile")) ? "GPS Missile" : (this.type.equalsIgnoreCase("AAMissile") ? "AA Missile" : (this.type.equalsIgnoreCase("TVMissile") ? "TV Missile" : (this.type.equalsIgnoreCase("ATMissile") ? "AT Missile" : (this.type.equalsIgnoreCase("Bomb") ? "Bomb" : (this.type.equalsIgnoreCase("MkRocket") ? "Mk Rocket" : (this.type.equalsIgnoreCase("Dummy") ? "Dummy" : (this.type.equalsIgnoreCase("Smoke") ? "Smoke" : (this.type.equalsIgnoreCase("Smoke") ? "Smoke" : (this.type.equalsIgnoreCase("Dispenser") ? "Dispenser" : (this.type.equalsIgnoreCase("TargetingPod") ? "Targeting Pod" : "")))))))))))))));
/*     */   }
/*     */ 
/*     */   
/*     */   public class RoundItem
/*     */   {
/*     */     public final int num;
/*     */     public final String itemName;
/*     */     public final int damage;
/*     */     public ItemStack itemStack;
/*     */     
/*     */     public RoundItem(int n, String name, int damage) {
/* 533 */       this.num = n;
/* 534 */       this.itemName = name;
/* 535 */       this.damage = damage;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class MuzzleFlash
/*     */   {
/*     */     public final float dist;
/*     */     public final float size;
/*     */     public final float range;
/*     */     public final int age;
/*     */     public final float a;
/*     */     public final float r;
/*     */     public final float g;
/*     */     public final float b;
/*     */     public final int num;
/*     */     
/*     */     public MuzzleFlash(float dist, float size, float range, int age, float a, float r, float g, float b, int num) {
/* 553 */       this.dist = dist;
/* 554 */       this.size = size;
/* 555 */       this.range = range;
/* 556 */       this.age = age;
/* 557 */       this.a = a;
/* 558 */       this.r = r;
/* 559 */       this.g = g;
/* 560 */       this.b = b;
/* 561 */       this.num = num;
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\weapon\MCH_WeaponInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */