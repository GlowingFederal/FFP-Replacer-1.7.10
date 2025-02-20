/*     */ package mcheli.vehicle;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_PacketStatusRequest;
/*     */ import mcheli.weapon.MCH_WeaponParam;
/*     */ import mcheli.weapon.MCH_WeaponSet;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.nbt.NBTTagCompound;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_EntityVehicle
/*     */   extends MCH_EntityAircraft {
/*  24 */   private MCH_VehicleInfo vehicleInfo = null;
/*     */   
/*     */   public boolean isUsedPlayer;
/*     */   public float lastRiderYaw;
/*     */   public float lastRiderPitch;
/*     */   
/*     */   public MCH_EntityVehicle(World world) {
/*  31 */     super(world);
/*  32 */     this.currentSpeed = 0.07D;
/*  33 */     this.field_70156_m = true;
/*  34 */     func_70105_a(2.0F, 0.7F);
/*  35 */     this.field_70129_M = this.field_70131_O / 2.0F;
/*  36 */     this.field_70159_w = 0.0D;
/*  37 */     this.field_70181_x = 0.0D;
/*  38 */     this.field_70179_y = 0.0D;
/*  39 */     this.isUsedPlayer = false;
/*  40 */     this.lastRiderYaw = 0.0F;
/*  41 */     this.lastRiderPitch = 0.0F;
/*  42 */     this.weapons = createWeapon(0);
/*     */   }
/*     */   
/*     */   public String getKindName() {
/*  46 */     return "vehicles";
/*     */   }
/*     */   
/*     */   public String getEntityType() {
/*  50 */     return "Vehicle";
/*     */   }
/*     */   
/*     */   public MCH_VehicleInfo getVehicleInfo() {
/*  54 */     return this.vehicleInfo;
/*     */   }
/*     */   
/*     */   public void changeType(String type) {
/*  58 */     if (!type.isEmpty()) {
/*  59 */       this.vehicleInfo = MCH_VehicleInfoManager.get(type);
/*     */     }
/*     */     
/*  62 */     if (this.vehicleInfo == null) {
/*  63 */       MCH_Lib.Log((Entity)this, "##### MCH_EntityVehicle changeVehicleType() Vehicle info null %d, %s, %s", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)this)), type, getEntityName() });
/*  64 */       func_70106_y();
/*     */     } else {
/*  66 */       setAcInfo(this.vehicleInfo);
/*  67 */       newSeats(getAcInfo().getNumSeatAndRack());
/*  68 */       this.weapons = createWeapon(1 + getSeatNum());
/*  69 */       initPartRotation(this.field_70177_z, this.field_70125_A);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean canMountWithNearEmptyMinecart() {
/*  75 */     MCH_Config var10000 = MCH_MOD.config;
/*  76 */     return MCH_Config.MountMinecartVehicle.prmBool;
/*     */   }
/*     */   
/*     */   protected void func_70088_a() {
/*  80 */     super.func_70088_a();
/*     */   }
/*     */   
/*     */   protected void func_70014_b(NBTTagCompound par1NBTTagCompound) {
/*  84 */     super.func_70014_b(par1NBTTagCompound);
/*     */   }
/*     */   
/*     */   protected void func_70037_a(NBTTagCompound par1NBTTagCompound) {
/*  88 */     super.func_70037_a(par1NBTTagCompound);
/*  89 */     if (this.vehicleInfo == null) {
/*  90 */       this.vehicleInfo = MCH_VehicleInfoManager.get(getTypeName());
/*  91 */       if (this.vehicleInfo == null) {
/*  92 */         MCH_Lib.Log((Entity)this, "##### MCH_EntityVehicle readEntityFromNBT() Vehicle info null %d, %s", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)this)), getEntityName() });
/*  93 */         func_70106_y();
/*     */       } else {
/*  95 */         setAcInfo(this.vehicleInfo);
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public Item getItem() {
/* 102 */     return (getVehicleInfo() != null) ? (Item)(getVehicleInfo()).item : null;
/*     */   }
/*     */   
/*     */   public void func_70106_y() {
/* 106 */     super.func_70106_y();
/*     */   }
/*     */   
/*     */   public float getSoundVolume() {
/* 110 */     return (float)getCurrentThrottle() * 2.0F;
/*     */   }
/*     */   
/*     */   public float getSoundPitch() {
/* 114 */     return (float)(getCurrentThrottle() * 0.5D);
/*     */   }
/*     */   
/*     */   public String getDefaultSoundName() {
/* 118 */     return "";
/*     */   }
/*     */   
/*     */   @SideOnly(Side.CLIENT)
/*     */   public void zoomCamera() {
/* 123 */     if (canZoom()) {
/* 124 */       float z = this.camera.getCameraZoom();
/* 125 */       z++;
/* 126 */       this.camera.setCameraZoom((z <= getZoomMax() + 0.01D) ? z : 1.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void _updateCameraRotate(float yaw, float pitch) {
/* 132 */     this.camera.prevRotationYaw = this.camera.rotationYaw;
/* 133 */     this.camera.prevRotationPitch = this.camera.rotationPitch;
/* 134 */     if (pitch > 89.0F) {
/* 135 */       pitch = 89.0F;
/*     */     }
/*     */     
/* 138 */     if (pitch < -89.0F) {
/* 139 */       pitch = -89.0F;
/*     */     }
/*     */     
/* 142 */     this.camera.rotationYaw = yaw;
/* 143 */     this.camera.rotationPitch = pitch;
/*     */   }
/*     */   
/*     */   public boolean isCameraView(Entity entity) {
/* 147 */     return true;
/*     */   }
/*     */   
/*     */   public boolean useCurrentWeapon(MCH_WeaponParam prm) {
/* 151 */     if (prm.user != null) {
/* 152 */       MCH_WeaponSet breforeUseWeaponPitch = getCurrentWeapon(prm.user);
/* 153 */       if (breforeUseWeaponPitch != null) {
/* 154 */         MCH_AircraftInfo.Weapon breforeUseWeaponYaw = getAcInfo().getWeaponByName((breforeUseWeaponPitch.getInfo()).name);
/* 155 */         if (breforeUseWeaponYaw != null && breforeUseWeaponYaw.maxYaw != 0.0F && breforeUseWeaponYaw.minYaw != 0.0F) {
/* 156 */           return super.useCurrentWeapon(prm);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 161 */     float breforeUseWeaponPitch1 = this.field_70125_A;
/* 162 */     float breforeUseWeaponYaw1 = this.field_70177_z;
/* 163 */     this.field_70125_A = prm.user.field_70125_A;
/* 164 */     this.field_70177_z = prm.user.field_70177_z;
/* 165 */     boolean result = super.useCurrentWeapon(prm);
/* 166 */     this.field_70125_A = breforeUseWeaponPitch1;
/* 167 */     this.field_70177_z = breforeUseWeaponYaw1;
/* 168 */     return result;
/*     */   }
/*     */   
/*     */   public void onUpdateAircraft() {
/* 172 */     if (this.vehicleInfo == null) {
/* 173 */       changeType(getTypeName());
/* 174 */       this.field_70169_q = this.field_70165_t;
/* 175 */       this.field_70167_r = this.field_70163_u;
/* 176 */       this.field_70166_s = this.field_70161_v;
/*     */     } else {
/* 178 */       if (!this.isRequestedSyncStatus) {
/* 179 */         this.isRequestedSyncStatus = true;
/* 180 */         if (this.field_70170_p.field_72995_K) {
/* 181 */           MCH_PacketStatusRequest.requestStatus(this);
/*     */         }
/*     */       } 
/*     */       
/* 185 */       if (this.lastRiddenByEntity == null && getRiddenByEntity() != null) {
/* 186 */         (getRiddenByEntity()).field_70125_A = 0.0F;
/* 187 */         (getRiddenByEntity()).field_70127_C = 0.0F;
/* 188 */         initCurrentWeapon(getRiddenByEntity());
/*     */       } 
/*     */       
/* 191 */       updateWeapons();
/* 192 */       onUpdate_Seats();
/* 193 */       onUpdate_Control();
/* 194 */       this.field_70169_q = this.field_70165_t;
/* 195 */       this.field_70167_r = this.field_70163_u;
/* 196 */       this.field_70166_s = this.field_70161_v;
/* 197 */       if (func_70090_H()) {
/* 198 */         this.field_70125_A *= 0.9F;
/*     */       }
/*     */       
/* 201 */       if (this.field_70170_p.field_72995_K) {
/* 202 */         onUpdate_Client();
/*     */       } else {
/* 204 */         onUpdate_Server();
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdate_Control() {
/* 211 */     double max_y = 1.0D;
/* 212 */     if (this.field_70153_n != null && !this.field_70153_n.field_70128_L) {
/* 213 */       if ((getVehicleInfo()).isEnableMove || (getVehicleInfo()).isEnableRot) {
/* 214 */         onUpdate_ControlOnGround();
/*     */       }
/* 216 */     } else if (getCurrentThrottle() > 0.0D) {
/* 217 */       addCurrentThrottle(-0.00125D);
/*     */     } else {
/* 219 */       setCurrentThrottle(0.0D);
/*     */     } 
/*     */     
/* 222 */     if (getCurrentThrottle() < 0.0D) {
/* 223 */       setCurrentThrottle(0.0D);
/*     */     }
/*     */     
/* 226 */     if (this.field_70170_p.field_72995_K) {
/* 227 */       if (!W_Lib.isClientPlayer(getRiddenByEntity())) {
/* 228 */         double ct = getThrottle();
/* 229 */         if (getCurrentThrottle() > ct) {
/* 230 */           addCurrentThrottle(-0.005D);
/*     */         }
/*     */         
/* 233 */         if (getCurrentThrottle() < ct) {
/* 234 */           addCurrentThrottle(0.005D);
/*     */         }
/*     */       } 
/*     */     } else {
/* 238 */       setThrottle(getCurrentThrottle());
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdate_ControlOnGround() {
/* 244 */     if (!this.field_70170_p.field_72995_K) {
/* 245 */       boolean move = false;
/* 246 */       float yaw = this.field_70177_z;
/* 247 */       double x = 0.0D;
/* 248 */       double z = 0.0D;
/* 249 */       if ((getVehicleInfo()).isEnableMove) {
/* 250 */         if (this.throttleUp) {
/* 251 */           yaw = this.field_70177_z;
/* 252 */           x += Math.sin(yaw * Math.PI / 180.0D);
/* 253 */           z += Math.cos(yaw * Math.PI / 180.0D);
/* 254 */           move = true;
/*     */         } 
/*     */         
/* 257 */         if (this.throttleDown) {
/* 258 */           yaw = this.field_70177_z - 180.0F;
/* 259 */           x += Math.sin(yaw * Math.PI / 180.0D);
/* 260 */           z += Math.cos(yaw * Math.PI / 180.0D);
/* 261 */           move = true;
/*     */         } 
/*     */       } 
/*     */       
/* 265 */       if ((getVehicleInfo()).isEnableMove) {
/* 266 */         if (this.moveLeft && !this.moveRight) {
/* 267 */           this.field_70177_z = (float)(this.field_70177_z - 0.5D);
/*     */         }
/*     */         
/* 270 */         if (this.moveRight && !this.moveLeft) {
/* 271 */           this.field_70177_z = (float)(this.field_70177_z + 0.5D);
/*     */         }
/*     */       } 
/*     */       
/* 275 */       if (move) {
/* 276 */         double d = Math.sqrt(x * x + z * z);
/* 277 */         this.field_70159_w -= x / d * 0.029999999329447746D;
/* 278 */         this.field_70179_y += z / d * 0.029999999329447746D;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdate_Particle() {
/* 285 */     double particlePosY = this.field_70163_u;
/* 286 */     boolean b = false;
/*     */     
/*     */     int y;
/*     */     
/* 290 */     for (y = 0; y < 5 && !b; y++) {
/*     */       int pn;
/*     */       
/* 293 */       for (pn = -1; pn <= 1; pn++) {
/* 294 */         for (int z = -1; z <= 1; z++) {
/* 295 */           int k = W_WorldFunc.getBlockId(this.field_70170_p, (int)(this.field_70165_t + 0.5D) + pn, (int)(this.field_70163_u + 0.5D) - y, (int)(this.field_70161_v + 0.5D) + z);
/* 296 */           if (k != 0 && !b) {
/* 297 */             particlePosY = ((int)(this.field_70163_u + 1.0D) - y);
/* 298 */             b = true;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */       
/* 303 */       for (pn = -3; b && pn <= 3; pn++) {
/* 304 */         for (int z = -3; z <= 3; z++) {
/* 305 */           if (W_WorldFunc.isBlockWater(this.field_70170_p, (int)(this.field_70165_t + 0.5D) + pn, (int)(this.field_70163_u + 0.5D) - y, (int)(this.field_70161_v + 0.5D) + z)) {
/* 306 */             for (int k = 0; k < 7.0D * getCurrentThrottle(); k++) {
/* 307 */               this.field_70170_p.func_72869_a("splash", this.field_70165_t + 0.5D + pn + (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, particlePosY + this.field_70146_Z.nextDouble(), this.field_70161_v + 0.5D + z + (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, pn + (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, -0.3D, z + (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D);
/*     */             }
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 314 */     double var9 = (5 - y + 1) / 5.0D;
/* 315 */     if (b) {
/* 316 */       for (int k = 0; k < (int)(getCurrentThrottle() * 6.0D * var9); k++) {
/* 317 */         float f3 = 0.25F;
/* 318 */         this.field_70170_p.func_72869_a("explode", this.field_70165_t + this.field_70146_Z.nextDouble() - 0.5D, particlePosY + this.field_70146_Z.nextDouble() - 0.5D, this.field_70161_v + this.field_70146_Z.nextDouble() - 0.5D, (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D, -0.4D, (this.field_70146_Z.nextDouble() - 0.5D) * 2.0D);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void onUpdate_Client() {
/* 325 */     updateCameraViewers();
/* 326 */     if (this.field_70153_n != null && W_Lib.isClientPlayer(getRiddenByEntity())) {
/* 327 */       (getRiddenByEntity()).field_70125_A = (getRiddenByEntity()).field_70127_C;
/*     */     }
/*     */     
/* 330 */     if (this.aircraftPosRotInc > 0) {
/* 331 */       double rpinc = this.aircraftPosRotInc;
/* 332 */       double yaw = MathHelper.func_76138_g(this.aircraftYaw - this.field_70177_z);
/* 333 */       this.field_70177_z = (float)(this.field_70177_z + yaw / rpinc);
/* 334 */       this.field_70125_A = (float)(this.field_70125_A + (this.aircraftPitch - this.field_70125_A) / rpinc);
/* 335 */       func_70107_b(this.field_70165_t + (this.aircraftX - this.field_70165_t) / rpinc, this.field_70163_u + (this.aircraftY - this.field_70163_u) / rpinc, this.field_70161_v + (this.aircraftZ - this.field_70161_v) / rpinc);
/* 336 */       func_70101_b(this.field_70177_z, this.field_70125_A);
/* 337 */       this.aircraftPosRotInc--;
/*     */     } else {
/* 339 */       func_70107_b(this.field_70165_t + this.field_70159_w, this.field_70163_u + this.field_70181_x, this.field_70161_v + this.field_70179_y);
/* 340 */       if (this.field_70122_E) {
/* 341 */         this.field_70159_w *= 0.95D;
/* 342 */         this.field_70179_y *= 0.95D;
/*     */       } 
/*     */       
/* 345 */       if (func_70090_H()) {
/* 346 */         this.field_70159_w *= 0.99D;
/* 347 */         this.field_70179_y *= 0.99D;
/*     */       } 
/*     */     } 
/*     */     
/* 351 */     if (this.field_70153_n != null);
/*     */ 
/*     */ 
/*     */     
/* 355 */     updateCamera(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*     */   }
/*     */   
/*     */   private void onUpdate_Server() {
/* 359 */     double prevMotion = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 360 */     updateCameraViewers();
/* 361 */     double dp = 0.0D;
/* 362 */     if (canFloatWater()) {
/* 363 */       dp = getWaterDepth();
/*     */     }
/*     */     
/* 366 */     if (dp == 0.0D) {
/* 367 */       this.field_70181_x += (!func_70090_H() ? (getAcInfo()).gravity : (getAcInfo()).gravityInWater);
/* 368 */     } else if (dp < 1.0D) {
/* 369 */       this.field_70181_x -= 1.0E-4D;
/* 370 */       this.field_70181_x += 0.007D * getCurrentThrottle();
/*     */     } else {
/* 372 */       if (this.field_70181_x < 0.0D) {
/* 373 */         this.field_70181_x /= 2.0D;
/*     */       }
/*     */       
/* 376 */       this.field_70181_x += 0.007D;
/*     */     } 
/*     */     
/* 379 */     double motion = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
/* 380 */     float speedLimit = (getAcInfo()).speed;
/* 381 */     if (motion > speedLimit) {
/* 382 */       this.field_70159_w *= speedLimit / motion;
/* 383 */       this.field_70179_y *= speedLimit / motion;
/* 384 */       motion = speedLimit;
/*     */     } 
/*     */     
/* 387 */     if (motion > prevMotion && this.currentSpeed < speedLimit) {
/* 388 */       this.currentSpeed += (speedLimit - this.currentSpeed) / 35.0D;
/* 389 */       if (this.currentSpeed > speedLimit) {
/* 390 */         this.currentSpeed = speedLimit;
/*     */       }
/*     */     } else {
/* 393 */       this.currentSpeed -= (this.currentSpeed - 0.07D) / 35.0D;
/* 394 */       if (this.currentSpeed < 0.07D) {
/* 395 */         this.currentSpeed = 0.07D;
/*     */       }
/*     */     } 
/*     */     
/* 399 */     if (this.field_70122_E) {
/* 400 */       this.field_70159_w *= 0.5D;
/* 401 */       this.field_70179_y *= 0.5D;
/*     */     } 
/*     */     
/* 404 */     func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
/* 405 */     this.field_70181_x *= 0.95D;
/* 406 */     this.field_70159_w *= 0.99D;
/* 407 */     this.field_70179_y *= 0.99D;
/* 408 */     onUpdate_updateBlock();
/* 409 */     if (this.field_70153_n != null && this.field_70153_n.field_70128_L) {
/* 410 */       unmountEntity();
/* 411 */       this.field_70153_n = null;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onUpdateAngles(float partialTicks) {}
/*     */   
/*     */   public void _updateRiderPosition() {
/* 419 */     float yaw = this.field_70177_z;
/* 420 */     if (this.field_70153_n != null) {
/* 421 */       this.field_70177_z = this.field_70153_n.field_70177_z;
/*     */     }
/*     */     
/* 424 */     func_70043_V();
/* 425 */     this.field_70177_z = yaw;
/*     */   }
/*     */   
/*     */   public boolean canSwitchFreeLook() {
/* 429 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\vehicle\MCH_EntityVehicle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */