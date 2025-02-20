/*      */ package mcheli.aircraft;
/*      */ 
/*      */ import java.util.ArrayList;
/*      */ import java.util.Collections;
/*      */ import java.util.Comparator;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import mcheli.MCH_BaseInfo;
/*      */ import mcheli.MCH_MOD;
/*      */ import mcheli.hud.MCH_Hud;
/*      */ import mcheli.hud.MCH_HudManager;
/*      */ import mcheli.weapon.MCH_WeaponInfoManager;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraftforge.client.model.IModelCustom;
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ public abstract class MCH_AircraftInfo
/*      */   extends MCH_BaseInfo
/*      */ {
/*      */   public final String name;
/*      */   public String displayName;
/*      */   public HashMap displayNameLang;
/*      */   public int itemID;
/*      */   public List recipeString;
/*      */   public List recipe;
/*      */   public boolean isShapedRecipe;
/*      */   public String category;
/*      */   public boolean isEnableGunnerMode;
/*      */   public int cameraZoom;
/*      */   public boolean isEnableConcurrentGunnerMode;
/*      */   public boolean isEnableNightVision;
/*      */   public boolean isEnableEntityRadar;
/*      */   public boolean isEnableEjectionSeat;
/*      */   public boolean isEnableParachuting;
/*      */   public Flare flare;
/*      */   public float bodyHeight;
/*      */   public float bodyWidth;
/*      */   public boolean isFloat;
/*      */   public float floatOffset;
/*      */   public float gravity;
/*      */   public float gravityInWater;
/*      */   public int maxHp;
/*      */   public float armorMinDamage;
/*      */   public float armorMaxDamage;
/*      */   public float armorDamageFactor;
/*      */   public boolean enableBack;
/*      */   public boolean isUAV;
/*      */   public boolean isSmallUAV;
/*      */   public boolean isTargetDrone;
/*      */   public float autoPilotRot;
/*      */   public float onGroundPitch;
/*      */   public boolean canMoveOnGround;
/*      */   public boolean canRotOnGround;
/*      */   public List weaponSetList;
/*      */   public List seatList;
/*      */   public List exclusionSeatList;
/*      */   public List hudList;
/*      */   public MCH_Hud hudTvMissile;
/*      */   public float damageFactor;
/*      */   public float submergedDamageHeight;
/*      */   public boolean regeneration;
/*      */   public List extraBoundingBox;
/*      */   public List wheels;
/*      */   public int maxFuel;
/*      */   public float fuelConsumption;
/*      */   public float fuelSupplyRange;
/*      */   public float ammoSupplyRange;
/*      */   public float repairOtherVehiclesRange;
/*      */   public int repairOtherVehiclesValue;
/*      */   public float stealth;
/*      */   public boolean canRide;
/*      */   public float entityWidth;
/*      */   public float entityHeight;
/*      */   public float entityPitch;
/*      */   public float entityRoll;
/*      */   public float stepHeight;
/*      */   public List entityRackList;
/*      */   public int mobSeatNum;
/*  137 */   private String lastWeaponType = ""; public int entityRackNum; public MCH_MobDropOption mobDropOption; public List repellingHooks; public List rideRacks; public List particleSplashs; public List searchLights; public float rotorSpeed; public boolean enableSeaSurfaceParticle; public float pivotTurnThrottle; public float trackRollerRot; public float partWheelRot; public float onGroundPitchFactor; public float onGroundRollFactor; public Vec3 turretPosition; public boolean defaultFreelook; public Vec3 unmountPosition; public float markerWidth; public float markerHeight; public float bbZmin; public float bbZmax; public float bbZ; public boolean alwaysCameraView; public List cameraPosition; public float cameraRotationSpeed; public float speed; public float motionFactor; public float mobilityYaw; public float mobilityPitch; public float mobilityRoll; public float mobilityYawOnGround; public float minRotationPitch; public float maxRotationPitch; public float minRotationRoll; public float maxRotationRoll; public boolean limitRotation; public float throttleUpDown; public float throttleUpDownOnEntity; private List textureNameList; public int textureCount; public float particlesScale; public boolean hideEntity; public boolean smoothShading; public String soundMove; public float soundRange; public float soundVolume; public float soundPitch; public IModelCustom model; public List hatchList; public List cameraList; public List partWeapon; public List partWeaponBay; public List canopyList; public List landingGear; public List partThrottle; public List partRotPart; public List partCrawlerTrack; public List partTrackRoller; public List partWheel; public List partSteeringWheel; public List lightHatchList;
/*  138 */   private int lastWeaponIndex = -1;
/*      */   
/*      */   private PartWeapon lastWeaponPart;
/*      */   public boolean isNewUAV;
/*      */   
/*      */   public abstract Item getItem();
/*      */   
/*      */   public ItemStack getItemStack() {
/*  146 */     return new ItemStack(getItem());
/*      */   }
/*      */   
/*      */   public abstract String getDirectoryName();
/*      */   
/*      */   public abstract String getKindName();
/*      */   
/*      */   public MCH_AircraftInfo(String s) {
/*  154 */     this.name = s;
/*  155 */     this.displayName = this.name;
/*  156 */     this.displayNameLang = new HashMap<>();
/*  157 */     this.itemID = 0;
/*  158 */     this.recipeString = new ArrayList();
/*  159 */     this.recipe = new ArrayList();
/*  160 */     this.isShapedRecipe = true;
/*  161 */     this.category = "zzz";
/*  162 */     this.isEnableGunnerMode = false;
/*  163 */     this.isEnableConcurrentGunnerMode = false;
/*  164 */     this.isEnableNightVision = false;
/*  165 */     this.isEnableEntityRadar = false;
/*  166 */     this.isEnableEjectionSeat = false;
/*  167 */     this.isEnableParachuting = false;
/*  168 */     this.flare = new Flare();
/*  169 */     this.weaponSetList = new ArrayList();
/*  170 */     this.seatList = new ArrayList();
/*  171 */     this.exclusionSeatList = new ArrayList();
/*  172 */     this.hudList = new ArrayList();
/*  173 */     this.hudTvMissile = null;
/*  174 */     this.bodyHeight = 0.7F;
/*  175 */     this.bodyWidth = 2.0F;
/*  176 */     this.isFloat = false;
/*  177 */     this.floatOffset = 0.0F;
/*  178 */     this.gravity = -0.04F;
/*  179 */     this.gravityInWater = -0.04F;
/*  180 */     this.maxHp = 50;
/*  181 */     this.damageFactor = 0.2F;
/*  182 */     this.submergedDamageHeight = 0.0F;
/*  183 */     this.armorDamageFactor = 1.0F;
/*  184 */     this.armorMaxDamage = 100000.0F;
/*  185 */     this.armorMinDamage = 0.0F;
/*  186 */     this.enableBack = false;
/*  187 */     this.isUAV = false;
/*  188 */     this.isSmallUAV = false;
/*  189 */     this.isTargetDrone = false;
/*  190 */     this.autoPilotRot = -0.6F;
/*  191 */     this.regeneration = false;
/*  192 */     this.onGroundPitch = 0.0F;
/*  193 */     this.canMoveOnGround = true;
/*  194 */     this.canRotOnGround = true;
/*  195 */     this.cameraZoom = getDefaultMaxZoom();
/*  196 */     this.extraBoundingBox = new ArrayList();
/*  197 */     this.maxFuel = 0;
/*  198 */     this.fuelConsumption = 1.0F;
/*  199 */     this.fuelSupplyRange = 0.0F;
/*  200 */     this.ammoSupplyRange = 0.0F;
/*  201 */     this.repairOtherVehiclesRange = 0.0F;
/*  202 */     this.repairOtherVehiclesValue = 10;
/*  203 */     this.stealth = 0.0F;
/*  204 */     this.canRide = true;
/*  205 */     this.entityWidth = 1.0F;
/*  206 */     this.entityHeight = 1.0F;
/*  207 */     this.entityPitch = 0.0F;
/*  208 */     this.entityRoll = 0.0F;
/*  209 */     this.stepHeight = getDefaultStepHeight();
/*  210 */     this.entityRackList = new ArrayList();
/*  211 */     this.mobSeatNum = 0;
/*  212 */     this.entityRackNum = 0;
/*  213 */     this.mobDropOption = new MCH_MobDropOption();
/*  214 */     this.repellingHooks = new ArrayList();
/*  215 */     this.rideRacks = new ArrayList();
/*  216 */     this.particleSplashs = new ArrayList();
/*  217 */     this.searchLights = new ArrayList();
/*  218 */     this.markerHeight = 1.0F;
/*  219 */     this.markerWidth = 2.0F;
/*  220 */     this.bbZmax = 1.0F;
/*  221 */     this.bbZmin = -1.0F;
/*  222 */     this.rotorSpeed = getDefaultRotorSpeed();
/*  223 */     this.wheels = getDefaultWheelList();
/*  224 */     this.onGroundPitchFactor = 0.0F;
/*  225 */     this.onGroundRollFactor = 0.0F;
/*  226 */     this.turretPosition = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/*  227 */     this.defaultFreelook = false;
/*  228 */     this.unmountPosition = null;
/*  229 */     this.cameraPosition = new ArrayList();
/*  230 */     this.alwaysCameraView = false;
/*  231 */     this.cameraRotationSpeed = 1000.0F;
/*  232 */     this.speed = 0.1F;
/*  233 */     this.motionFactor = 0.96F;
/*  234 */     this.mobilityYaw = 1.0F;
/*  235 */     this.mobilityPitch = 1.0F;
/*  236 */     this.mobilityRoll = 1.0F;
/*  237 */     this.mobilityYawOnGround = 1.0F;
/*  238 */     this.minRotationPitch = getMinRotationPitch();
/*  239 */     this.maxRotationPitch = getMaxRotationPitch();
/*  240 */     this.minRotationRoll = getMinRotationPitch();
/*  241 */     this.maxRotationRoll = getMaxRotationPitch();
/*  242 */     this.limitRotation = false;
/*  243 */     this.throttleUpDown = 1.0F;
/*  244 */     this.throttleUpDownOnEntity = 2.0F;
/*  245 */     this.pivotTurnThrottle = 0.0F;
/*  246 */     this.trackRollerRot = 30.0F;
/*  247 */     this.partWheelRot = 30.0F;
/*  248 */     this.textureNameList = new ArrayList();
/*  249 */     this.textureNameList.add(this.name);
/*  250 */     this.textureCount = 0;
/*  251 */     this.particlesScale = 1.0F;
/*  252 */     this.enableSeaSurfaceParticle = false;
/*  253 */     this.hideEntity = false;
/*  254 */     this.smoothShading = true;
/*  255 */     this.soundMove = "";
/*  256 */     this.soundPitch = 1.0F;
/*  257 */     this.soundVolume = 1.0F;
/*  258 */     this.soundRange = getDefaultSoundRange();
/*  259 */     this.model = null;
/*  260 */     this.hatchList = new ArrayList();
/*  261 */     this.cameraList = new ArrayList();
/*  262 */     this.partWeapon = new ArrayList();
/*  263 */     this.lastWeaponPart = null;
/*  264 */     this.partWeaponBay = new ArrayList();
/*  265 */     this.canopyList = new ArrayList();
/*  266 */     this.landingGear = new ArrayList();
/*  267 */     this.partThrottle = new ArrayList();
/*  268 */     this.partRotPart = new ArrayList();
/*  269 */     this.partCrawlerTrack = new ArrayList();
/*  270 */     this.partTrackRoller = new ArrayList();
/*  271 */     this.partWheel = new ArrayList();
/*  272 */     this.partSteeringWheel = new ArrayList();
/*  273 */     this.lightHatchList = new ArrayList();
/*  274 */     this.isNewUAV = false;
/*      */   }
/*      */   
/*      */   public float getDefaultSoundRange() {
/*  278 */     return 100.0F;
/*      */   }
/*      */   
/*      */   public List getDefaultWheelList() {
/*  282 */     return new ArrayList();
/*      */   }
/*      */   
/*      */   public float getDefaultRotorSpeed() {
/*  286 */     return 0.0F;
/*      */   }
/*      */   
/*      */   private float getDefaultStepHeight() {
/*  290 */     return 0.0F;
/*      */   }
/*      */   
/*      */   public boolean haveRepellingHook() {
/*  294 */     return (this.repellingHooks.size() > 0);
/*      */   }
/*      */   
/*      */   public boolean haveFlare() {
/*  298 */     return (this.flare.types.length > 0);
/*      */   }
/*      */   
/*      */   public boolean haveCanopy() {
/*  302 */     return (this.canopyList.size() > 0);
/*      */   }
/*      */   
/*      */   public boolean haveLandingGear() {
/*  306 */     return (this.landingGear.size() > 0);
/*      */   }
/*      */   
/*      */   public abstract String getDefaultHudName(int paramInt);
/*      */   
/*      */   public boolean isValidData() throws Exception {
/*  312 */     if (this.cameraPosition.size() <= 0) {
/*  313 */       this.cameraPosition.add(new CameraPosition());
/*      */     }
/*      */     
/*  316 */     this.bbZ = (this.bbZmax + this.bbZmin) / 2.0F;
/*  317 */     if (this.isTargetDrone) {
/*  318 */       this.isUAV = true;
/*      */     }
/*      */     
/*  321 */     if (this.isEnableParachuting && this.repellingHooks.size() > 0) {
/*  322 */       this.isEnableParachuting = false;
/*  323 */       this.repellingHooks.clear();
/*      */     } 
/*      */     
/*  326 */     if (this.isUAV || this.isNewUAV) {
/*  327 */       this.alwaysCameraView = true;
/*  328 */       if (this.seatList.size() == 0) {
/*  329 */         MCH_SeatInfo i = new MCH_SeatInfo(Vec3.func_72443_a(0.0D, 0.0D, 0.0D), false);
/*  330 */         this.seatList.add(i);
/*      */       } 
/*      */     } 
/*      */     
/*  334 */     this.mobSeatNum = this.seatList.size();
/*  335 */     this.entityRackNum = this.entityRackList.size();
/*  336 */     if (getNumSeat() < 1) {
/*  337 */       throw new Exception();
/*      */     }
/*      */     
/*  340 */     if (getNumHud() < getNumSeat()) {
/*  341 */       for (int i = getNumHud(); i < getNumSeat(); i++) {
/*  342 */         this.hudList.add(MCH_HudManager.get(getDefaultHudName(i)));
/*      */       }
/*      */     }
/*      */     
/*  346 */     if (getNumSeat() == 1 && getNumHud() == 1) {
/*  347 */       this.hudList.add(MCH_HudManager.get(getDefaultHudName(1)));
/*      */     }
/*      */     
/*  350 */     Iterator<MCH_SeatRackInfo> var11 = this.entityRackList.iterator();
/*      */     
/*  352 */     while (var11.hasNext()) {
/*  353 */       MCH_SeatRackInfo wb = var11.next();
/*  354 */       this.seatList.add(wb);
/*      */     } 
/*      */     
/*  357 */     this.entityRackList.clear();
/*  358 */     if (this.hudTvMissile == null) {
/*  359 */       this.hudTvMissile = MCH_HudManager.get("tv_missile");
/*      */     }
/*      */     
/*  362 */     if (this.textureNameList.size() < 1) {
/*  363 */       throw new Exception();
/*      */     }
/*  365 */     if (this.itemID <= 0);
/*      */ 
/*      */ 
/*      */     
/*  369 */     for (int var10 = 0; var10 < this.partWeaponBay.size(); var10++) {
/*  370 */       WeaponBay var12 = this.partWeaponBay.get(var10);
/*  371 */       String[] weaponNames = var12.weaponName.split("\\s*/\\s*");
/*  372 */       if (weaponNames.length <= 0) {
/*  373 */         this.partWeaponBay.remove(var10);
/*      */       } else {
/*  375 */         ArrayList<Integer> list = new ArrayList();
/*  376 */         String[] arr$ = weaponNames;
/*  377 */         int len$ = weaponNames.length;
/*      */         
/*  379 */         for (int i$ = 0; i$ < len$; i$++) {
/*  380 */           String s = arr$[i$];
/*  381 */           int id = getWeaponIdByName(s);
/*  382 */           if (id >= 0) {
/*  383 */             list.add(Integer.valueOf(id));
/*      */           }
/*      */         } 
/*      */         
/*  387 */         if (list.size() <= 0) {
/*  388 */           this.partWeaponBay.remove(var10);
/*      */         } else {
/*  390 */           ((WeaponBay)this.partWeaponBay.get(var10)).weaponIds = list.<Integer>toArray(new Integer[0]);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/*  395 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public int getInfo_MaxSeatNum() {
/*  401 */     return 30;
/*      */   }
/*      */   
/*      */   public int getNumSeatAndRack() {
/*  405 */     return this.seatList.size();
/*      */   }
/*      */   
/*      */   public int getNumSeat() {
/*  409 */     return this.mobSeatNum;
/*      */   }
/*      */   
/*      */   public int getNumRack() {
/*  413 */     return this.entityRackNum;
/*      */   }
/*      */   
/*      */   public int getNumHud() {
/*  417 */     return this.hudList.size();
/*      */   }
/*      */   
/*      */   public float getMaxSpeed() {
/*  421 */     return 0.8F;
/*      */   }
/*      */   
/*      */   public float getMinRotationPitch() {
/*  425 */     return -89.9F;
/*      */   }
/*      */   
/*      */   public float getMaxRotationPitch() {
/*  429 */     return 80.0F;
/*      */   }
/*      */   
/*      */   public float getMinRotationRoll() {
/*  433 */     return -80.0F;
/*      */   }
/*      */   
/*      */   public float getMaxRotationRoll() {
/*  437 */     return 80.0F;
/*      */   }
/*      */   
/*      */   public int getDefaultMaxZoom() {
/*  441 */     return 1;
/*      */   }
/*      */   
/*      */   public boolean haveHatch() {
/*  445 */     return (this.hatchList.size() > 0);
/*      */   }
/*      */   
/*      */   public boolean havePartCamera() {
/*  449 */     return (this.cameraList.size() > 0);
/*      */   }
/*      */   
/*      */   public boolean havePartThrottle() {
/*  453 */     return (this.partThrottle.size() > 0);
/*      */   }
/*      */   
/*      */   public WeaponSet getWeaponSetById(int id) {
/*  457 */     return (id >= 0 && id < this.weaponSetList.size()) ? this.weaponSetList.get(id) : null;
/*      */   }
/*      */   
/*      */   public Weapon getWeaponById(int id) {
/*  461 */     WeaponSet ws = getWeaponSetById(id);
/*  462 */     return (ws != null) ? ws.weapons.get(0) : null;
/*      */   }
/*      */   
/*      */   public int getWeaponIdByName(String s) {
/*  466 */     for (int i = 0; i < this.weaponSetList.size(); i++) {
/*  467 */       if (((WeaponSet)this.weaponSetList.get(i)).type.equalsIgnoreCase(s)) {
/*  468 */         return i;
/*      */       }
/*      */     } 
/*      */     
/*  472 */     return -1;
/*      */   }
/*      */   
/*      */   public Weapon getWeaponByName(String s) {
/*  476 */     for (int i = 0; i < this.weaponSetList.size(); i++) {
/*  477 */       if (((WeaponSet)this.weaponSetList.get(i)).type.equalsIgnoreCase(s)) {
/*  478 */         return getWeaponById(i);
/*      */       }
/*      */     } 
/*      */     
/*  482 */     return null;
/*      */   }
/*      */   
/*      */   public int getWeaponNum() {
/*  486 */     return this.weaponSetList.size();
/*      */   }
/*      */   
/*      */   public void loadItemData(String item, String data) {
/*  490 */     if (item.compareTo("displayname") == 0) {
/*  491 */       this.displayName = data.trim();
/*      */     
/*      */     }
/*  494 */     else if (item.compareTo("adddisplayname") == 0) {
/*  495 */       String[] s = data.split("\\s*,\\s*");
/*  496 */       if (s != null && s.length == 2) {
/*  497 */         this.displayNameLang.put(s[0].trim(), s[1].trim());
/*      */       }
/*  499 */     } else if (item.equalsIgnoreCase("Category")) {
/*  500 */       this.category = data.toUpperCase().replaceAll("[,;:]", ".").replaceAll("[ \t]", "");
/*  501 */     } else if (item.equalsIgnoreCase("CanRide")) {
/*  502 */       this.canRide = toBool(data, true);
/*  503 */     } else if (item.equalsIgnoreCase("MaxFuel")) {
/*  504 */       this.maxFuel = toInt(data, 0, 100000000);
/*  505 */     } else if (item.equalsIgnoreCase("FuelConsumption")) {
/*  506 */       this.fuelConsumption = toFloat(data, 0.0F, 10000.0F);
/*  507 */     } else if (item.equalsIgnoreCase("FuelSupplyRange")) {
/*  508 */       this.fuelSupplyRange = toFloat(data, 0.0F, 1000.0F);
/*  509 */     } else if (item.equalsIgnoreCase("AmmoSupplyRange")) {
/*  510 */       this.ammoSupplyRange = toFloat(data, 0.0F, 1000.0F);
/*  511 */     } else if (item.equalsIgnoreCase("RepairOtherVehicles")) {
/*  512 */       String[] s = splitParam(data);
/*  513 */       if (s.length >= 1) {
/*  514 */         this.repairOtherVehiclesRange = toFloat(s[0], 0.0F, 1000.0F);
/*  515 */         if (s.length >= 2) {
/*  516 */           this.repairOtherVehiclesValue = toInt(s[1], 0, 10000000);
/*      */         }
/*      */       } 
/*  519 */     } else if (item.compareTo("itemid") == 0) {
/*  520 */       this.itemID = toInt(data, 0, 65535);
/*  521 */     } else if (item.compareTo("addtexture") == 0) {
/*  522 */       this.textureNameList.add(data.toLowerCase());
/*  523 */     } else if (item.compareTo("particlesscale") == 0) {
/*  524 */       this.particlesScale = toFloat(data, 0.0F, 50.0F);
/*  525 */     } else if (item.equalsIgnoreCase("EnableSeaSurfaceParticle")) {
/*  526 */       this.enableSeaSurfaceParticle = toBool(data);
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/*      */     }
/*  535 */     else if (item.equalsIgnoreCase("AddParticleSplash")) {
/*  536 */       String[] s = splitParam(data);
/*  537 */       if (s.length >= 3) {
/*  538 */         Vec3 df = toVec3(s[0], s[1], s[2]);
/*  539 */         int c = (s.length >= 4) ? toInt(s[3], 1, 100) : 2;
/*  540 */         float ry = (s.length >= 5) ? toFloat(s[4]) : 2.0F;
/*  541 */         float rz = (s.length >= 6) ? toFloat(s[5]) : 1.0F;
/*  542 */         int px = (s.length >= 7) ? toInt(s[6], 1, 100000) : 80;
/*  543 */         float py = (s.length >= 8) ? toFloat(s[7]) : 0.01F;
/*  544 */         float pz = (s.length >= 9) ? toFloat(s[8]) : 0.0F;
/*  545 */         this.particleSplashs.add(new ParticleSplash(df, c, ry, rz, px, py, pz));
/*      */       
/*      */       }
/*      */ 
/*      */     
/*      */     }
/*  551 */     else if (!item.equalsIgnoreCase("AddSearchLight") && !item.equalsIgnoreCase("AddFixedSearchLight") && !item.equalsIgnoreCase("AddSteeringSearchLight")) {
/*      */       
/*  553 */       if (item.equalsIgnoreCase("AddPartLightHatch")) {
/*  554 */         String[] s = splitParam(data);
/*  555 */         if (s.length >= 6) {
/*  556 */           float var15 = (s.length >= 7) ? toFloat(s[6], -1800.0F, 1800.0F) : 90.0F;
/*  557 */           this.lightHatchList.add(new Hatch(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), var15, "light_hatch" + this.lightHatchList.size(), false));
/*      */         }
/*      */       
/*      */       }
/*  561 */       else if (item.equalsIgnoreCase("AddRepellingHook")) {
/*  562 */         String[] s = splitParam(data);
/*  563 */         if (s != null && s.length >= 3) {
/*  564 */           int var16 = (s.length >= 4) ? toInt(s[3], 1, 100000) : 10;
/*  565 */           this.repellingHooks.add(new RepellingHook(toVec3(s[0], s[1], s[2]), var16));
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*  571 */       else if (item.equalsIgnoreCase("AddRack")) {
/*  572 */         String[] s = data.toLowerCase().split("\\s*,\\s*");
/*  573 */         if (s != null && s.length >= 7) {
/*  574 */           String[] var17 = s[0].split("\\s*/\\s*");
/*  575 */           float var18 = (s.length >= 8) ? toFloat(s[7]) : 6.0F;
/*  576 */           float ry = (s.length >= 9) ? toFloat(s[8], 0.0F, 1000000.0F) : 20.0F;
/*  577 */           float rz = (s.length >= 10) ? toFloat(s[9]) : 0.0F;
/*  578 */           float var26 = (s.length >= 11) ? toFloat(s[10]) : 0.0F;
/*  579 */           boolean var31 = (s.length >= 12) ? toBool(s[11]) : false;
/*  580 */           this.entityRackList.add(new MCH_SeatRackInfo(var17, toDouble(s[1]), toDouble(s[2]), toDouble(s[3]), new CameraPosition(toVec3(s[4], s[5], s[6]).func_72441_c(0.0D, 1.5D, 0.0D)), var18, ry, rz, var26, var31));
/*      */         } 
/*  582 */       } else if (item.equalsIgnoreCase("RideRack")) {
/*  583 */         String[] s = splitParam(data);
/*  584 */         if (s.length >= 2) {
/*  585 */           RideRack var19 = new RideRack(s[0].trim().toLowerCase(), toInt(s[1], 1, 10000));
/*  586 */           this.rideRacks.add(var19);
/*      */ 
/*      */         
/*      */         }
/*      */ 
/*      */       
/*      */       }
/*  593 */       else if (!item.equalsIgnoreCase("AddSeat") && !item.equalsIgnoreCase("AddGunnerSeat") && !item.equalsIgnoreCase("AddFixRotSeat")) {
/*  594 */         if (item.equalsIgnoreCase("SetWheelPos")) {
/*  595 */           String[] s = splitParam(data);
/*  596 */           if (s.length >= 4) {
/*  597 */             float var15 = Math.abs(toFloat(s[0]));
/*  598 */             float var18 = toFloat(s[1]);
/*  599 */             this.wheels.clear();
/*      */             
/*  601 */             for (int var22 = 2; var22 < s.length; var22++) {
/*  602 */               this.wheels.add(new Wheel(Vec3.func_72443_a(var15, var18, toFloat(s[var22]))));
/*      */             }
/*      */             
/*  605 */             Collections.sort(this.wheels, new Comparator<Wheel>() {
/*      */                   public int compare(MCH_AircraftInfo.Wheel arg0, MCH_AircraftInfo.Wheel arg1) {
/*  607 */                     return (arg0.pos.field_72449_c > arg1.pos.field_72449_c) ? -1 : 1;
/*      */                   }
/*      */                 });
/*      */           } 
/*  611 */         } else if (item.equalsIgnoreCase("ExclusionSeat")) {
/*  612 */           String[] s = splitParam(data);
/*  613 */           if (s.length >= 2) {
/*  614 */             Integer[] var27 = new Integer[s.length];
/*      */             
/*  616 */             for (int c = 0; c < var27.length; c++) {
/*  617 */               var27[c] = Integer.valueOf(toInt(s[c], 1, 10000) - 1);
/*      */             }
/*      */             
/*  620 */             this.exclusionSeatList.add(var27);
/*      */           } 
/*  622 */         } else if (MCH_MOD.proxy.isRemote() && item.equalsIgnoreCase("HUD")) {
/*  623 */           this.hudList.clear();
/*  624 */           String[] s = data.split("\\s*,\\s*");
/*  625 */           String[] var17 = s;
/*  626 */           int c = s.length;
/*      */           
/*  628 */           for (int var22 = 0; var22 < c; var22++) {
/*  629 */             String var43 = var17[var22];
/*  630 */             MCH_Hud var38 = MCH_HudManager.get(var43);
/*  631 */             if (var38 == null) {
/*  632 */               var38 = MCH_Hud.NoDisp;
/*      */             }
/*      */             
/*  635 */             this.hudList.add(var38);
/*      */           } 
/*  637 */         } else if (item.compareTo("enablenightvision") == 0) {
/*  638 */           this.isEnableNightVision = toBool(data);
/*  639 */         } else if (item.compareTo("enableentityradar") == 0) {
/*  640 */           this.isEnableEntityRadar = toBool(data);
/*  641 */         } else if (item.equalsIgnoreCase("EnableEjectionSeat")) {
/*  642 */           this.isEnableEjectionSeat = toBool(data);
/*  643 */         } else if (item.equalsIgnoreCase("EnableParachuting")) {
/*  644 */           this.isEnableParachuting = toBool(data);
/*  645 */         } else if (item.equalsIgnoreCase("MobDropOption")) {
/*  646 */           String[] s = splitParam(data);
/*  647 */           if (s.length >= 3) {
/*  648 */             this.mobDropOption.pos = toVec3(s[0], s[1], s[2]);
/*  649 */             this.mobDropOption.interval = (s.length >= 4) ? toInt(s[3]) : 12;
/*      */           } 
/*  651 */         } else if (item.equalsIgnoreCase("Width")) {
/*  652 */           this.bodyWidth = toFloat(data, 0.1F, 1000.0F);
/*  653 */         } else if (item.equalsIgnoreCase("Height")) {
/*  654 */           this.bodyHeight = toFloat(data, 0.1F, 1000.0F);
/*  655 */         } else if (item.compareTo("float") == 0) {
/*  656 */           this.isFloat = toBool(data);
/*  657 */         } else if (item.compareTo("floatoffset") == 0) {
/*  658 */           this.floatOffset = -toFloat(data);
/*  659 */         } else if (item.compareTo("gravity") == 0) {
/*  660 */           this.gravity = toFloat(data, -50.0F, 50.0F);
/*  661 */         } else if (item.compareTo("gravityinwater") == 0) {
/*  662 */           this.gravityInWater = toFloat(data, -50.0F, 50.0F);
/*      */         
/*      */         }
/*  665 */         else if (item.compareTo("cameraposition") == 0) {
/*  666 */           String[] s = data.split("\\s*,\\s*");
/*  667 */           if (s.length >= 3) {
/*  668 */             this.alwaysCameraView = (s.length >= 4) ? toBool(s[3]) : false;
/*  669 */             boolean var28 = (s.length >= 5);
/*  670 */             float var18 = (s.length >= 5) ? toFloat(s[4]) : 0.0F;
/*  671 */             float ry = (s.length >= 6) ? toFloat(s[5]) : 0.0F;
/*  672 */             this.cameraPosition.add(new CameraPosition(toVec3(s[0], s[1], s[2]), var28, var18, ry));
/*      */           } 
/*  674 */         } else if (item.equalsIgnoreCase("UnmountPosition")) {
/*  675 */           String[] s = data.split("\\s*,\\s*");
/*  676 */           if (s.length >= 3) {
/*  677 */             this.unmountPosition = toVec3(s[0], s[1], s[2]);
/*      */           }
/*  679 */         } else if (item.equalsIgnoreCase("TurretPosition")) {
/*  680 */           String[] s = data.split("\\s*,\\s*");
/*  681 */           if (s.length >= 3) {
/*  682 */             this.turretPosition = toVec3(s[0], s[1], s[2]);
/*      */           }
/*  684 */         } else if (item.equalsIgnoreCase("CameraRotationSpeed")) {
/*  685 */           this.cameraRotationSpeed = toFloat(data, 0.0F, 10000.0F);
/*  686 */         } else if (item.compareTo("regeneration") == 0) {
/*  687 */           this.regeneration = toBool(data);
/*  688 */         } else if (item.compareTo("speed") == 0) {
/*  689 */           this.speed = toFloat(data, 0.0F, getMaxSpeed());
/*  690 */         } else if (item.equalsIgnoreCase("EnableBack")) {
/*  691 */           this.enableBack = toBool(data);
/*  692 */         } else if (item.equalsIgnoreCase("MotionFactor")) {
/*  693 */           this.motionFactor = toFloat(data, 0.0F, 1.0F);
/*  694 */         } else if (item.equalsIgnoreCase("MobilityYawOnGround")) {
/*  695 */           this.mobilityYawOnGround = toFloat(data, 0.0F, 100.0F);
/*  696 */         } else if (item.equalsIgnoreCase("MobilityYaw")) {
/*  697 */           this.mobilityYaw = toFloat(data, 0.0F, 100.0F);
/*  698 */         } else if (item.equalsIgnoreCase("MobilityPitch")) {
/*  699 */           this.mobilityPitch = toFloat(data, 0.0F, 100.0F);
/*  700 */         } else if (item.equalsIgnoreCase("MobilityRoll")) {
/*  701 */           this.mobilityRoll = toFloat(data, 0.0F, 100.0F);
/*  702 */         } else if (item.equalsIgnoreCase("MinRotationPitch")) {
/*  703 */           this.limitRotation = true;
/*  704 */           this.minRotationPitch = toFloat(data, getMinRotationPitch(), 0.0F);
/*  705 */         } else if (item.equalsIgnoreCase("MaxRotationPitch")) {
/*  706 */           this.limitRotation = true;
/*  707 */           this.maxRotationPitch = toFloat(data, 0.0F, getMaxRotationPitch());
/*  708 */         } else if (item.equalsIgnoreCase("MinRotationRoll")) {
/*  709 */           this.limitRotation = true;
/*  710 */           this.minRotationRoll = toFloat(data, getMinRotationRoll(), 0.0F);
/*  711 */         } else if (item.equalsIgnoreCase("MaxRotationRoll")) {
/*  712 */           this.limitRotation = true;
/*  713 */           this.maxRotationRoll = toFloat(data, 0.0F, getMaxRotationRoll());
/*  714 */         } else if (item.compareTo("throttleupdown") == 0) {
/*  715 */           this.throttleUpDown = toFloat(data, 0.0F, 3.0F);
/*  716 */         } else if (item.equalsIgnoreCase("ThrottleUpDownOnEntity")) {
/*  717 */           this.throttleUpDownOnEntity = toFloat(data, 0.0F, 100000.0F);
/*  718 */         } else if (item.equalsIgnoreCase("Stealth")) {
/*  719 */           this.stealth = toFloat(data, 0.0F, 1.0F);
/*  720 */         } else if (item.equalsIgnoreCase("EntityWidth")) {
/*  721 */           this.entityWidth = toFloat(data, -100.0F, 100.0F);
/*  722 */         } else if (item.equalsIgnoreCase("EntityHeight")) {
/*  723 */           this.entityHeight = toFloat(data, -100.0F, 100.0F);
/*  724 */         } else if (item.equalsIgnoreCase("EntityPitch")) {
/*  725 */           this.entityPitch = toFloat(data, -360.0F, 360.0F);
/*  726 */         } else if (item.equalsIgnoreCase("EntityRoll")) {
/*  727 */           this.entityRoll = toFloat(data, -360.0F, 360.0F);
/*  728 */         } else if (item.equalsIgnoreCase("StepHeight")) {
/*  729 */           this.stepHeight = toFloat(data, 0.0F, 1000.0F);
/*  730 */         } else if (item.equalsIgnoreCase("CanMoveOnGround")) {
/*  731 */           this.canMoveOnGround = toBool(data);
/*  732 */         } else if (item.equalsIgnoreCase("CanRotOnGround")) {
/*  733 */           this.canRotOnGround = toBool(data);
/*  734 */         } else if (!item.equalsIgnoreCase("AddWeapon") && !item.equalsIgnoreCase("AddTurretWeapon")) {
/*  735 */           if (!item.equalsIgnoreCase("AddPartWeapon") && !item.equalsIgnoreCase("AddPartRotWeapon") && !item.equalsIgnoreCase("AddPartTurretWeapon") && !item.equalsIgnoreCase("AddPartTurretRotWeapon") && !item.equalsIgnoreCase("AddPartWeaponMissile")) {
/*  736 */             if (item.equalsIgnoreCase("AddPartWeaponChild")) {
/*  737 */               String[] s = data.split("\\s*,\\s*");
/*  738 */               if (s.length >= 5 && this.lastWeaponPart != null) {
/*  739 */                 float var15 = (s.length >= 6) ? toFloat(s[5]) : 0.0F;
/*  740 */                 PartWeaponChild var30 = new PartWeaponChild(this.lastWeaponPart.name, toBool(s[0]), toBool(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), this.lastWeaponPart.modelName + "_" + this.lastWeaponPart.child.size(), 0.0F, 0.0F, 0.0F, var15);
/*  741 */                 this.lastWeaponPart.child.add(var30);
/*      */               } 
/*  743 */             } else if (item.compareTo("addrecipe") != 0 && item.compareTo("addshapelessrecipe") != 0) {
/*  744 */               if (item.compareTo("maxhp") == 0) {
/*  745 */                 this.maxHp = toInt(data, 1, 100000);
/*  746 */               } else if (item.compareTo("damagefactor") == 0) {
/*  747 */                 this.damageFactor = toFloat(data, 0.0F, 1.0F);
/*  748 */               } else if (item.equalsIgnoreCase("SubmergedDamageHeight")) {
/*  749 */                 this.submergedDamageHeight = toFloat(data, -1000.0F, 1000.0F);
/*  750 */               } else if (item.equalsIgnoreCase("ArmorDamageFactor")) {
/*  751 */                 this.armorDamageFactor = toFloat(data, 0.0F, 10000.0F);
/*  752 */               } else if (item.equalsIgnoreCase("ArmorMinDamage")) {
/*  753 */                 this.armorMinDamage = toFloat(data, 0.0F, 1000000.0F);
/*  754 */               } else if (item.equalsIgnoreCase("ArmorMaxDamage")) {
/*  755 */                 this.armorMaxDamage = toFloat(data, 0.0F, 1000000.0F);
/*  756 */               } else if (item.equalsIgnoreCase("FlareType")) {
/*  757 */                 String[] s = data.split("\\s*,\\s*");
/*  758 */                 this.flare.types = new int[s.length];
/*      */                 
/*  760 */                 for (int var16 = 0; var16 < s.length; var16++) {
/*  761 */                   this.flare.types[var16] = toInt(s[var16], 1, 10);
/*      */                 }
/*  763 */               } else if (item.equalsIgnoreCase("FlareOption")) {
/*  764 */                 String[] s = splitParam(data);
/*  765 */                 if (s.length >= 3) {
/*  766 */                   this.flare.pos = toVec3(s[0], s[1], s[2]);
/*      */                 }
/*  768 */               } else if (item.equalsIgnoreCase("Sound")) {
/*  769 */                 this.soundMove = data.toLowerCase();
/*  770 */               } else if (item.equalsIgnoreCase("SoundRange")) {
/*  771 */                 this.soundRange = toFloat(data, 1.0F, 1000.0F);
/*  772 */               } else if (item.equalsIgnoreCase("SoundVolume")) {
/*  773 */                 this.soundVolume = toFloat(data, 0.0F, 10.0F);
/*  774 */               } else if (item.equalsIgnoreCase("SoundPitch")) {
/*  775 */                 this.soundPitch = toFloat(data, 0.0F, 10.0F);
/*  776 */               } else if (item.equalsIgnoreCase("UAV")) {
/*  777 */                 this.isUAV = toBool(data);
/*  778 */                 this.isSmallUAV = false;
/*  779 */               } else if (item.equalsIgnoreCase("SmallUAV")) {
/*  780 */                 this.isUAV = toBool(data);
/*  781 */                 this.isSmallUAV = true;
/*  782 */               } else if (item.equalsIgnoreCase("NewUAV")) {
/*  783 */                 this.isNewUAV = toBool(data);
/*  784 */                 this.isSmallUAV = false;
/*  785 */               } else if (item.equalsIgnoreCase("NewSmallUAV")) {
/*  786 */                 this.isNewUAV = toBool(data);
/*  787 */                 this.isSmallUAV = true;
/*  788 */               } else if (item.equalsIgnoreCase("TargetDrone")) {
/*  789 */                 this.isTargetDrone = toBool(data);
/*  790 */               } else if (item.compareTo("autopilotrot") == 0) {
/*  791 */                 this.autoPilotRot = toFloat(data, -5.0F, 5.0F);
/*  792 */               } else if (item.compareTo("ongroundpitch") == 0) {
/*  793 */                 this.onGroundPitch = -toFloat(data, -90.0F, 90.0F);
/*  794 */               } else if (item.compareTo("enablegunnermode") == 0) {
/*  795 */                 this.isEnableGunnerMode = toBool(data);
/*  796 */               } else if (item.compareTo("hideentity") == 0) {
/*  797 */                 this.hideEntity = toBool(data);
/*  798 */               } else if (item.equalsIgnoreCase("SmoothShading")) {
/*  799 */                 this.smoothShading = toBool(data);
/*  800 */               } else if (item.compareTo("concurrentgunnermode") == 0) {
/*  801 */                 this.isEnableConcurrentGunnerMode = toBool(data);
/*      */               
/*      */               }
/*  804 */               else if (!item.equalsIgnoreCase("AddPartWeaponBay") && !item.equalsIgnoreCase("AddPartSlideWeaponBay")) {
/*  805 */                 if (item.compareTo("addparthatch") != 0 && item.compareTo("addpartslidehatch") != 0) {
/*  806 */                   if (item.compareTo("addpartcanopy") != 0 && item.compareTo("addpartslidecanopy") != 0) {
/*  807 */                     if (!item.equalsIgnoreCase("AddPartLG") && !item.equalsIgnoreCase("AddPartSlideRotLG") && !item.equalsIgnoreCase("AddPartLGRev") && !item.equalsIgnoreCase("AddPartLGHatch")) {
/*  808 */                       if (item.equalsIgnoreCase("AddPartThrottle")) {
/*  809 */                         String[] s = data.split("\\s*,\\s*");
/*  810 */                         if (s.length >= 7) {
/*  811 */                           float var15 = (s.length >= 8) ? toFloat(s[7]) : 0.0F;
/*  812 */                           float var18 = (s.length >= 9) ? toFloat(s[8]) : 0.0F;
/*  813 */                           float ry = (s.length >= 10) ? toFloat(s[9]) : 0.0F;
/*  814 */                           Throttle var40 = new Throttle(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), toFloat(s[6]), "throttle" + this.partThrottle.size(), var15, var18, ry);
/*  815 */                           this.partThrottle.add(var40);
/*      */                         } 
/*  817 */                       } else if (item.equalsIgnoreCase("AddPartRotation")) {
/*  818 */                         String[] s = data.split("\\s*,\\s*");
/*  819 */                         if (s.length >= 7) {
/*  820 */                           boolean var28 = (s.length >= 8) ? toBool(s[7]) : true;
/*  821 */                           RotPart var46 = new RotPart(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), toFloat(s[6]), var28, "rotpart" + this.partThrottle.size());
/*  822 */                           this.partRotPart.add(var46);
/*      */                         } 
/*  824 */                       } else if (item.compareTo("addpartcamera") == 0) {
/*  825 */                         String[] s = data.split("\\s*,\\s*");
/*  826 */                         if (s.length >= 3) {
/*  827 */                           boolean var28 = (s.length >= 4) ? toBool(s[3]) : true;
/*  828 */                           boolean var48 = (s.length >= 5) ? toBool(s[4]) : false;
/*  829 */                           Camera var45 = new Camera(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), 0.0F, -1.0F, 0.0F, "camera" + this.cameraList.size(), var28, var48);
/*  830 */                           this.cameraList.add(var45);
/*      */                         } 
/*  832 */                       } else if (item.equalsIgnoreCase("AddPartWheel")) {
/*  833 */                         String[] s = splitParam(data);
/*  834 */                         if (s.length >= 3) {
/*  835 */                           float var15 = (s.length >= 4) ? toFloat(s[3], -1800.0F, 1800.0F) : 0.0F;
/*  836 */                           float var18 = (s.length >= 7) ? toFloat(s[4]) : 0.0F;
/*  837 */                           float ry = (s.length >= 7) ? toFloat(s[5]) : 1.0F;
/*  838 */                           float rz = (s.length >= 7) ? toFloat(s[6]) : 0.0F;
/*  839 */                           float var26 = (s.length >= 10) ? toFloat(s[7]) : toFloat(s[0]);
/*  840 */                           float py = (s.length >= 10) ? toFloat(s[8]) : toFloat(s[1]);
/*  841 */                           float pz = (s.length >= 10) ? toFloat(s[9]) : toFloat(s[2]);
/*  842 */                           this.partWheel.add(new PartWheel(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), var18, ry, rz, var15, var26, py, pz, "wheel" + this.partWheel.size()));
/*      */                         } 
/*  844 */                       } else if (item.equalsIgnoreCase("AddPartSteeringWheel")) {
/*  845 */                         String[] s = splitParam(data);
/*  846 */                         if (s.length >= 7) {
/*  847 */                           this.partSteeringWheel.add(new PartWheel(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), toFloat(s[6]), "steering_wheel" + this.partSteeringWheel.size()));
/*      */                         }
/*  849 */                       } else if (item.equalsIgnoreCase("AddTrackRoller")) {
/*  850 */                         String[] s = splitParam(data);
/*  851 */                         if (s.length >= 3) {
/*  852 */                           this.partTrackRoller.add(new TrackRoller(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), "track_roller" + this.partTrackRoller.size()));
/*      */                         }
/*  854 */                       } else if (item.equalsIgnoreCase("AddCrawlerTrack")) {
/*  855 */                         this.partCrawlerTrack.add(createCrawlerTrack(data, "crawler_track" + this.partCrawlerTrack.size()));
/*  856 */                       } else if (item.equalsIgnoreCase("PivotTurnThrottle")) {
/*  857 */                         this.pivotTurnThrottle = toFloat(data, 0.0F, 1.0F);
/*  858 */                       } else if (item.equalsIgnoreCase("TrackRollerRot")) {
/*  859 */                         this.trackRollerRot = toFloat(data, -10000.0F, 10000.0F);
/*  860 */                       } else if (item.equalsIgnoreCase("PartWheelRot")) {
/*  861 */                         this.partWheelRot = toFloat(data, -10000.0F, 10000.0F);
/*  862 */                       } else if (item.compareTo("camerazoom") == 0) {
/*  863 */                         this.cameraZoom = toInt(data, 1, 10);
/*  864 */                       } else if (item.equalsIgnoreCase("DefaultFreelook")) {
/*  865 */                         this.defaultFreelook = toBool(data);
/*  866 */                       } else if (item.equalsIgnoreCase("BoundingBox")) {
/*  867 */                         String[] s = data.split("\\s*,\\s*");
/*  868 */                         if (s.length >= 5) {
/*  869 */                           float var15 = (s.length >= 6) ? toFloat(s[5]) : 1.0F;
/*  870 */                           MCH_BoundingBox var49 = new MCH_BoundingBox(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), var15);
/*  871 */                           this.extraBoundingBox.add(var49);
/*  872 */                           if (var49.boundingBox.field_72337_e > this.markerHeight) {
/*  873 */                             this.markerHeight = (float)var49.boundingBox.field_72337_e;
/*      */                           }
/*      */                           
/*  876 */                           this.markerWidth = (float)Math.max(this.markerWidth, Math.abs(var49.boundingBox.field_72336_d) / 2.0D);
/*  877 */                           this.markerWidth = (float)Math.max(this.markerWidth, Math.abs(var49.boundingBox.field_72340_a) / 2.0D);
/*  878 */                           this.markerWidth = (float)Math.max(this.markerWidth, Math.abs(var49.boundingBox.field_72334_f) / 2.0D);
/*  879 */                           this.markerWidth = (float)Math.max(this.markerWidth, Math.abs(var49.boundingBox.field_72339_c) / 2.0D);
/*  880 */                           this.bbZmin = (float)Math.min(this.bbZmin, var49.boundingBox.field_72339_c);
/*  881 */                           this.bbZmax = (float)Math.min(this.bbZmax, var49.boundingBox.field_72334_f);
/*      */                         } 
/*  883 */                       } else if (item.equalsIgnoreCase("RotorSpeed")) {
/*  884 */                         this.rotorSpeed = toFloat(data, -10000.0F, 10000.0F);
/*  885 */                         if (this.rotorSpeed > 0.01D) {
/*  886 */                           this.rotorSpeed = (float)(this.rotorSpeed - 0.01D);
/*      */                         }
/*      */                         
/*  889 */                         if (this.rotorSpeed < -0.01D) {
/*  890 */                           this.rotorSpeed = (float)(this.rotorSpeed + 0.01D);
/*      */                         }
/*  892 */                       } else if (item.equalsIgnoreCase("OnGroundPitchFactor")) {
/*  893 */                         this.onGroundPitchFactor = toFloat(data, 0.0F, 180.0F);
/*  894 */                       } else if (item.equalsIgnoreCase("OnGroundRollFactor")) {
/*  895 */                         this.onGroundRollFactor = toFloat(data, 0.0F, 180.0F);
/*      */                       } 
/*      */                     } else {
/*  898 */                       String[] s = data.split("\\s*,\\s*");
/*      */                       
/*  900 */                       if (!item.equalsIgnoreCase("AddPartSlideRotLG") && s.length >= 6) {
/*  901 */                         float var15 = (s.length >= 7) ? toFloat(s[6], -180.0F, 180.0F) : 90.0F;
/*  902 */                         var15 /= 90.0F;
/*  903 */                         LandingGear var42 = new LandingGear(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), "lg" + this.landingGear.size(), var15, item.equalsIgnoreCase("AddPartLgRev"), item.equalsIgnoreCase("AddPartLGHatch"));
/*  904 */                         if (s.length >= 8) {
/*  905 */                           var42.enableRot2 = true;
/*  906 */                           var42.maxRotFactor2 = (s.length >= 11) ? toFloat(s[10], -180.0F, 180.0F) : 90.0F;
/*  907 */                           var42.maxRotFactor2 /= 90.0F;
/*  908 */                           var42.rot2 = Vec3.func_72443_a(toFloat(s[7]), toFloat(s[8]), toFloat(s[9]));
/*      */                         } 
/*      */                         
/*  911 */                         this.landingGear.add(var42);
/*      */                       } 
/*      */                       
/*  914 */                       if (item.equalsIgnoreCase("AddPartSlideRotLG") && s.length >= 9) {
/*  915 */                         float var15 = (s.length >= 10) ? toFloat(s[9], -180.0F, 180.0F) : 90.0F;
/*  916 */                         var15 /= 90.0F;
/*  917 */                         LandingGear var42 = new LandingGear(toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), toFloat(s[6]), toFloat(s[7]), toFloat(s[8]), "lg" + this.landingGear.size(), var15, false, false);
/*  918 */                         var42.slide = Vec3.func_72443_a(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]));
/*  919 */                         this.landingGear.add(var42);
/*      */                       } 
/*      */                     } 
/*      */                   } else {
/*  923 */                     String[] s = data.split("\\s*,\\s*");
/*  924 */                     boolean var28 = (item.compareTo("addpartslidecanopy") == 0);
/*  925 */                     int var22 = this.canopyList.size();
/*  926 */                     if (var22 > 0) {
/*  927 */                       var22--;
/*      */                     }
/*      */ 
/*      */                     
/*  931 */                     if (var28) {
/*  932 */                       if (s.length >= 3) {
/*  933 */                         Canopy var35 = new Canopy(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), 0.0F, 0.0F, 0.0F, 90.0F, "canopy" + var22, var28);
/*  934 */                         this.canopyList.add(var35);
/*  935 */                         if (var22 == 0) {
/*  936 */                           var35 = new Canopy(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), 0.0F, 0.0F, 0.0F, 90.0F, "canopy", var28);
/*  937 */                           this.canopyList.add(var35);
/*      */                         } 
/*      */                       } 
/*  940 */                     } else if (s.length >= 6) {
/*  941 */                       float var18 = (s.length >= 7) ? toFloat(s[6], -180.0F, 180.0F) : 90.0F;
/*  942 */                       var18 /= 90.0F;
/*  943 */                       Canopy var35 = new Canopy(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), var18, "canopy" + var22, var28);
/*  944 */                       this.canopyList.add(var35);
/*  945 */                       if (var22 == 0) {
/*  946 */                         var35 = new Canopy(toFloat(s[0]), toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), toFloat(s[4]), toFloat(s[5]), var18, "canopy", var28);
/*  947 */                         this.canopyList.add(var35);
/*      */                       } 
/*      */                     } 
/*      */                   } 
/*      */                 } else {
/*  952 */                   boolean var32 = (item.compareTo("addpartslidehatch") == 0);
/*  953 */                   String[] var17 = data.split("\\s*,\\s*");
/*  954 */                   Vec3 var20 = null;
/*      */                   
/*  956 */                   if (var32) {
/*  957 */                     if (var17.length >= 3) {
/*  958 */                       Hatch var36 = new Hatch(toFloat(var17[0]), toFloat(var17[1]), toFloat(var17[2]), 0.0F, 0.0F, 0.0F, 90.0F, "hatch" + this.hatchList.size(), var32);
/*  959 */                       this.hatchList.add(var36);
/*      */                     } 
/*  961 */                   } else if (var17.length >= 6) {
/*  962 */                     float ry = (var17.length >= 7) ? toFloat(var17[6], -180.0F, 180.0F) : 90.0F;
/*  963 */                     Hatch var36 = new Hatch(toFloat(var17[0]), toFloat(var17[1]), toFloat(var17[2]), toFloat(var17[3]), toFloat(var17[4]), toFloat(var17[5]), ry, "hatch" + this.hatchList.size(), var32);
/*  964 */                     this.hatchList.add(var36);
/*      */                   } 
/*      */                 } 
/*      */               } else {
/*  968 */                 boolean var32 = item.equalsIgnoreCase("AddPartSlideWeaponBay");
/*  969 */                 String[] var17 = data.split("\\s*,\\s*");
/*  970 */                 Vec3 var20 = null;
/*      */                 
/*  972 */                 if (var32) {
/*  973 */                   if (var17.length >= 4) {
/*  974 */                     WeaponBay var33 = new WeaponBay(var17[0].trim().toLowerCase(), toFloat(var17[1]), toFloat(var17[2]), toFloat(var17[3]), 0.0F, 0.0F, 0.0F, 90.0F, "wb" + this.partWeaponBay.size(), var32);
/*  975 */                     this.partWeaponBay.add(var33);
/*      */                   } 
/*  977 */                 } else if (var17.length >= 7) {
/*  978 */                   float ry = (var17.length >= 8) ? toFloat(var17[7], -180.0F, 180.0F) : 90.0F;
/*  979 */                   WeaponBay var33 = new WeaponBay(var17[0].trim().toLowerCase(), toFloat(var17[1]), toFloat(var17[2]), toFloat(var17[3]), toFloat(var17[4]), toFloat(var17[5]), toFloat(var17[6]), ry / 90.0F, "wb" + this.partWeaponBay.size(), var32);
/*  980 */                   this.partWeaponBay.add(var33);
/*      */                 } 
/*      */               } 
/*      */             } else {
/*      */               
/*  985 */               this.isShapedRecipe = (item.compareTo("addcraft") == 0);
/*  986 */               this.recipeString.add(data.toUpperCase());
/*      */             } 
/*      */           } else {
/*  989 */             String[] s = data.split("\\s*,\\s*");
/*  990 */             if (s.length >= 7) {
/*  991 */               float var15 = 0.0F;
/*  992 */               float var18 = 0.0F;
/*  993 */               float ry = 0.0F;
/*  994 */               float rz = 0.0F;
/*  995 */               boolean var34 = (item.equalsIgnoreCase("AddPartRotWeapon") || item.equalsIgnoreCase("AddPartTurretRotWeapon"));
/*  996 */               boolean var31 = item.equalsIgnoreCase("AddPartWeaponMissile");
/*  997 */               boolean var37 = (item.equalsIgnoreCase("AddPartTurretWeapon") || item.equalsIgnoreCase("AddPartTurretRotWeapon"));
/*  998 */               if (var34) {
/*  999 */                 var15 = (s.length >= 10) ? toFloat(s[7]) : 0.0F;
/* 1000 */                 var18 = (s.length >= 10) ? toFloat(s[8]) : 0.0F;
/* 1001 */                 ry = (s.length >= 10) ? toFloat(s[9]) : -1.0F;
/*      */               } else {
/* 1003 */                 rz = (s.length >= 8) ? toFloat(s[7]) : 0.0F;
/*      */               } 
/*      */               
/* 1006 */               PartWeapon var41 = new PartWeapon(splitParamSlash(s[0].toLowerCase().trim()), var34, var31, toBool(s[1]), toBool(s[2]), toBool(s[3]), toFloat(s[4]), toFloat(s[5]), toFloat(s[6]), "weapon" + this.partWeapon.size(), var15, var18, ry, rz, var37);
/* 1007 */               this.lastWeaponPart = var41;
/* 1008 */               this.partWeapon.add(var41);
/*      */             } 
/*      */           } 
/*      */         } else {
/* 1012 */           String[] s = data.split("\\s*,\\s*");
/* 1013 */           String var29 = s[0].toLowerCase();
/* 1014 */           if (s.length >= 4 && MCH_WeaponInfoManager.contains(var29)) {
/* 1015 */             float var18 = (s.length >= 5) ? toFloat(s[4]) : 0.0F;
/* 1016 */             float ry = (s.length >= 6) ? toFloat(s[5]) : 0.0F;
/* 1017 */             boolean var25 = (s.length >= 7) ? toBool(s[6]) : true;
/* 1018 */             int px = (s.length >= 8) ? (toInt(s[7], 1, getInfo_MaxSeatNum()) - 1) : 0;
/* 1019 */             if (px <= 0) {
/* 1020 */               var25 = true;
/*      */             }
/*      */             
/* 1023 */             float py = (s.length >= 9) ? toFloat(s[8]) : 0.0F;
/* 1024 */             py = MathHelper.func_76142_g(py);
/* 1025 */             float pz = (s.length >= 10) ? toFloat(s[9]) : 0.0F;
/* 1026 */             float w = (s.length >= 11) ? toFloat(s[10]) : 0.0F;
/* 1027 */             float var44 = (s.length >= 12) ? toFloat(s[11]) : 0.0F;
/* 1028 */             float var47 = (s.length >= 13) ? toFloat(s[12]) : 0.0F;
/* 1029 */             Weapon e = new Weapon(toFloat(s[1]), toFloat(s[2]), toFloat(s[3]), var18, ry, var25, px, py, pz, w, var44, var47, item.equalsIgnoreCase("AddTurretWeapon"));
/* 1030 */             if (var29.compareTo(this.lastWeaponType) != 0) {
/* 1031 */               this.weaponSetList.add(new WeaponSet(var29));
/* 1032 */               this.lastWeaponIndex++;
/* 1033 */               this.lastWeaponType = var29;
/*      */             } 
/*      */             
/* 1036 */             ((WeaponSet)this.weaponSetList.get(this.lastWeaponIndex)).weapons.add(e);
/*      */           } 
/*      */         } 
/*      */       } else {
/*      */         
/* 1041 */         if (this.seatList.size() >= getInfo_MaxSeatNum()) {
/*      */           return;
/*      */         }
/*      */         
/* 1045 */         String[] s = splitParam(data);
/* 1046 */         if (s.length < 3) {
/*      */           return;
/*      */         }
/*      */         
/* 1050 */         Vec3 var20 = toVec3(s[0], s[1], s[2]);
/*      */         
/* 1052 */         if (item.equalsIgnoreCase("AddSeat")) {
/* 1053 */           boolean var23 = (s.length >= 4) ? toBool(s[3]) : false;
/* 1054 */           MCH_SeatInfo var21 = new MCH_SeatInfo(var20, var23);
/* 1055 */           this.seatList.add(var21);
/*      */         } else {
/* 1057 */           MCH_SeatInfo var21; if (s.length >= 6) {
/* 1058 */             CameraPosition var24 = new CameraPosition(toVec3(s[3], s[4], s[5]));
/* 1059 */             boolean var25 = (s.length >= 7) ? toBool(s[6]) : false;
/* 1060 */             if (item.equalsIgnoreCase("AddGunnerSeat")) {
/* 1061 */               if (s.length >= 9) {
/* 1062 */                 float var26 = toFloat(s[7], -90.0F, 90.0F);
/* 1063 */                 float py = toFloat(s[8], -90.0F, 90.0F);
/* 1064 */                 if (var26 > py) {
/* 1065 */                   float pz = var26;
/* 1066 */                   var26 = py;
/* 1067 */                   py = pz;
/*      */                 } 
/*      */                 
/* 1070 */                 boolean var37 = (s.length >= 10) ? toBool(s[9]) : false;
/* 1071 */                 var21 = new MCH_SeatInfo(var20, true, var24, true, var25, false, 0.0F, 0.0F, var26, py, var37);
/*      */               } else {
/* 1073 */                 var21 = new MCH_SeatInfo(var20, true, var24, true, var25, false, 0.0F, 0.0F, false);
/*      */               } 
/*      */             } else {
/* 1076 */               boolean var34 = (s.length >= 9);
/* 1077 */               float py = var34 ? toFloat(s[7]) : 0.0F;
/* 1078 */               float pz = var34 ? toFloat(s[8]) : 0.0F;
/* 1079 */               boolean var39 = (s.length >= 10) ? toBool(s[9]) : false;
/* 1080 */               var21 = new MCH_SeatInfo(var20, true, var24, true, var25, var34, py, pz, var39);
/*      */             } 
/*      */           } else {
/* 1083 */             var21 = new MCH_SeatInfo(var20, true, new CameraPosition(), false, false, false, 0.0F, 0.0F, false);
/*      */           } 
/*      */           
/* 1086 */           this.seatList.add(var21);
/*      */         }
/*      */       
/*      */       }
/*      */     
/*      */     } else {
/*      */       
/* 1093 */       String[] s = splitParam(data);
/* 1094 */       if (s.length >= 7) {
/* 1095 */         Vec3 df = toVec3(s[0], s[1], s[2]);
/* 1096 */         int c = hex2dec(s[3]);
/* 1097 */         int var22 = hex2dec(s[4]);
/* 1098 */         float rz = toFloat(s[5]);
/* 1099 */         float var26 = toFloat(s[6]);
/* 1100 */         float py = (s.length >= 8) ? toFloat(s[7]) : 0.0F;
/* 1101 */         float pz = (s.length >= 9) ? toFloat(s[8]) : 0.0F;
/* 1102 */         float w = (s.length >= 10) ? toFloat(s[9]) : 0.0F;
/* 1103 */         boolean mnp = !item.equalsIgnoreCase("AddSearchLight");
/* 1104 */         boolean mxp = item.equalsIgnoreCase("AddSteeringSearchLight");
/* 1105 */         this.searchLights.add(new SearchLight(df, c, var22, rz, var26, mnp, py, pz, mxp, w));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public CrawlerTrack createCrawlerTrack(String data, String name) {
/* 1115 */     String[] s = splitParam(data);
/* 1116 */     int PC = s.length - 3;
/* 1117 */     boolean REV = toBool(s[0]);
/* 1118 */     float LEN = toFloat(s[1], 0.001F, 1000.0F) * 0.9F;
/* 1119 */     float Z = toFloat(s[2]);
/* 1120 */     if (PC < 4) {
/* 1121 */       return null;
/*      */     }
/* 1123 */     double[] cx = new double[PC];
/* 1124 */     double[] cy = new double[PC];
/*      */     
/* 1126 */     for (int lp = 0; lp < PC; lp++) {
/* 1127 */       int dist = !REV ? lp : (PC - lp - 1);
/* 1128 */       String[] xy = splitParamSlash(s[3 + dist]);
/* 1129 */       cx[lp] = toFloat(xy[0]);
/* 1130 */       cy[lp] = toFloat(xy[1]);
/*      */     } 
/*      */     
/* 1133 */     ArrayList<CrawlerTrackPrm> var21 = new ArrayList();
/* 1134 */     var21.add(new CrawlerTrackPrm((float)cx[0], (float)cy[0]));
/* 1135 */     double var22 = 0.0D;
/*      */     
/*      */     int c;
/* 1138 */     for (c = 0; c < PC; c++) {
/* 1139 */       double pp = cx[(c + 1) % PC] - cx[c];
/* 1140 */       double np = cy[(c + 1) % PC] - cy[c];
/* 1141 */       var22 += Math.sqrt(pp * pp + np * np);
/* 1142 */       double nr = var22;
/*      */       
/* 1144 */       for (int nnr = 1; var22 >= LEN; nnr++) {
/* 1145 */         var21.add(new CrawlerTrackPrm((float)(cx[c] + pp * (LEN * nnr) / nr), (float)(cy[c] + np * (LEN * nnr) / nr)));
/* 1146 */         var22 -= LEN;
/*      */       } 
/*      */     } 
/*      */     
/* 1150 */     for (c = 0; c < var21.size(); c++) {
/* 1151 */       CrawlerTrackPrm var24 = var21.get((c + var21.size() - 1) % var21.size());
/* 1152 */       CrawlerTrackPrm cp = var21.get(c);
/* 1153 */       CrawlerTrackPrm var25 = var21.get((c + 1) % var21.size());
/* 1154 */       float pr = (float)(Math.atan2((var24.x - cp.x), (var24.y - cp.y)) * 180.0D / Math.PI);
/* 1155 */       float var26 = (float)(Math.atan2((var25.x - cp.x), (var25.y - cp.y)) * 180.0D / Math.PI);
/* 1156 */       float ppr = (pr + 360.0F) % 360.0F;
/* 1157 */       float var27 = var26 + 180.0F;
/* 1158 */       if ((var27 < ppr - 0.3D || var27 > ppr + 0.3D) && var27 - ppr < 100.0F && var27 - ppr > -100.0F) {
/* 1159 */         var27 = (var27 + ppr) / 2.0F;
/*      */       }
/*      */       
/* 1162 */       cp.r = var27;
/*      */     } 
/*      */     
/* 1165 */     CrawlerTrack var23 = new CrawlerTrack(name);
/* 1166 */     var23.len = LEN;
/* 1167 */     var23.cx = cx;
/* 1168 */     var23.cy = cy;
/* 1169 */     var23.lp = var21;
/* 1170 */     var23.z = Z;
/* 1171 */     var23.side = (Z >= 0.0F) ? 1 : 0;
/* 1172 */     return var23;
/*      */   }
/*      */ 
/*      */   
/*      */   public String getTextureName() {
/* 1177 */     String s = this.textureNameList.get(this.textureCount);
/* 1178 */     this.textureCount = (this.textureCount + 1) % this.textureNameList.size();
/* 1179 */     return s;
/*      */   }
/*      */   
/*      */   public String getNextTextureName(String base) {
/* 1183 */     if (this.textureNameList.size() >= 2) {
/* 1184 */       for (int i = 0; i < this.textureNameList.size(); i++) {
/* 1185 */         String s = this.textureNameList.get(i);
/* 1186 */         if (s.equalsIgnoreCase(base)) {
/* 1187 */           i = (i + 1) % this.textureNameList.size();
/* 1188 */           return this.textureNameList.get(i);
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1193 */     return base;
/*      */   }
/*      */   
/*      */   public void preReload() {
/* 1197 */     this.textureNameList.clear();
/* 1198 */     this.textureNameList.add(this.name);
/* 1199 */     this.cameraList.clear();
/* 1200 */     this.cameraPosition.clear();
/* 1201 */     this.canopyList.clear();
/* 1202 */     this.flare = new Flare();
/* 1203 */     this.hatchList.clear();
/* 1204 */     this.hudList.clear();
/* 1205 */     this.landingGear.clear();
/* 1206 */     this.particleSplashs.clear();
/* 1207 */     this.searchLights.clear();
/* 1208 */     this.partThrottle.clear();
/* 1209 */     this.partRotPart.clear();
/* 1210 */     this.partCrawlerTrack.clear();
/* 1211 */     this.partTrackRoller.clear();
/* 1212 */     this.partWheel.clear();
/* 1213 */     this.partSteeringWheel.clear();
/* 1214 */     this.lightHatchList.clear();
/* 1215 */     this.partWeapon.clear();
/* 1216 */     this.partWeaponBay.clear();
/* 1217 */     this.repellingHooks.clear();
/* 1218 */     this.rideRacks.clear();
/* 1219 */     this.seatList.clear();
/* 1220 */     this.exclusionSeatList.clear();
/* 1221 */     this.entityRackList.clear();
/* 1222 */     this.extraBoundingBox.clear();
/* 1223 */     this.weaponSetList.clear();
/* 1224 */     this.lastWeaponIndex = -1;
/* 1225 */     this.lastWeaponType = "";
/* 1226 */     this.lastWeaponPart = null;
/* 1227 */     this.wheels.clear();
/* 1228 */     this.unmountPosition = null;
/*      */   }
/*      */   
/*      */   public static String[] getCannotReloadItem() {
/* 1232 */     return new String[] { "DisplayName", "AddDisplayName", "ItemID", "AddRecipe", "AddShapelessRecipe", "InventorySize", "Sound", "UAV", "SmallUAV", "TargetDrone", "Category" };
/*      */   }
/*      */   
/*      */   public boolean canReloadItem(String item) {
/* 1236 */     String[] ignoreItems = getCannotReloadItem();
/* 1237 */     String[] arr$ = ignoreItems;
/* 1238 */     int len$ = ignoreItems.length;
/*      */     
/* 1240 */     for (int i$ = 0; i$ < len$; i$++) {
/* 1241 */       String s = arr$[i$];
/* 1242 */       if (s.equalsIgnoreCase(item)) {
/* 1243 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 1247 */     return true;
/*      */   }
/*      */   
/*      */   public class RotPart
/*      */     extends DrawnPart
/*      */   {
/*      */     public final float rotSpeed;
/*      */     public final boolean rotAlways;
/*      */     
/*      */     public RotPart(float px, float py, float pz, float rx, float ry, float rz, float mr, boolean a, String name) {
/* 1257 */       super(px, py, pz, rx, ry, rz, name);
/* 1258 */       this.rotSpeed = mr;
/* 1259 */       this.rotAlways = a;
/*      */     }
/*      */   }
/*      */   
/*      */   public class Hatch
/*      */     extends DrawnPart
/*      */   {
/*      */     public final float maxRotFactor;
/*      */     public final float maxRot;
/*      */     public final boolean isSlide;
/*      */     
/*      */     public Hatch(float px, float py, float pz, float rx, float ry, float rz, float mr, String name, boolean slide) {
/* 1271 */       super(px, py, pz, rx, ry, rz, name);
/* 1272 */       this.maxRot = mr;
/* 1273 */       this.maxRotFactor = this.maxRot / 90.0F;
/* 1274 */       this.isSlide = slide;
/*      */     }
/*      */   }
/*      */   
/*      */   public class TrackRoller
/*      */     extends DrawnPart
/*      */   {
/*      */     final int side;
/*      */     
/*      */     public TrackRoller(float px, float py, float pz, String name) {
/* 1284 */       super(px, py, pz, 0.0F, 0.0F, 0.0F, name);
/* 1285 */       this.side = (px >= 0.0F) ? 1 : 0;
/*      */     }
/*      */   }
/*      */   
/*      */   public class LandingGear
/*      */     extends DrawnPart {
/* 1291 */     public Vec3 slide = null;
/*      */     
/*      */     public final float maxRotFactor;
/*      */     public boolean enableRot2;
/*      */     public Vec3 rot2;
/*      */     public float maxRotFactor2;
/*      */     public final boolean reverse;
/*      */     public final boolean hatch;
/*      */     
/*      */     public LandingGear(float x, float y, float z, float rx, float ry, float rz, String model, float maxRotF, boolean rev, boolean isHatch) {
/* 1301 */       super(x, y, z, rx, ry, rz, model);
/* 1302 */       this.maxRotFactor = maxRotF;
/* 1303 */       this.enableRot2 = false;
/* 1304 */       this.rot2 = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/* 1305 */       this.maxRotFactor2 = 0.0F;
/* 1306 */       this.reverse = rev;
/* 1307 */       this.hatch = isHatch;
/*      */     }
/*      */   }
/*      */   
/*      */   public class PartWeaponChild
/*      */     extends DrawnPart
/*      */   {
/*      */     public final String[] name;
/*      */     public final boolean yaw;
/*      */     public final boolean pitch;
/*      */     public final float recoilBuf;
/*      */     
/*      */     public PartWeaponChild(String[] name, boolean y, boolean p, float px, float py, float pz, String modelName, float rx, float ry, float rz, float rb) {
/* 1320 */       super(px, py, pz, rx, ry, rz, modelName);
/* 1321 */       this.name = name;
/* 1322 */       this.yaw = y;
/* 1323 */       this.pitch = p;
/* 1324 */       this.recoilBuf = rb;
/*      */     }
/*      */   }
/*      */   
/*      */   public class Canopy
/*      */     extends DrawnPart
/*      */   {
/*      */     public final float maxRotFactor;
/*      */     public final boolean isSlide;
/*      */     
/*      */     public Canopy(float px, float py, float pz, float rx, float ry, float rz, float mr, String name, boolean slide) {
/* 1335 */       super(px, py, pz, rx, ry, rz, name);
/* 1336 */       this.maxRotFactor = mr;
/* 1337 */       this.isSlide = slide;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class SearchLight
/*      */   {
/*      */     public final int colorStart;
/*      */     public final int colorEnd;
/*      */     public final Vec3 pos;
/*      */     public final float height;
/*      */     public final float width;
/*      */     public final float angle;
/*      */     public final boolean fixDir;
/*      */     public final float yaw;
/*      */     public final float pitch;
/*      */     public final boolean steering;
/*      */     public final float stRot;
/*      */     
/*      */     public SearchLight(Vec3 pos, int cs, int ce, float h, float w, boolean fix, float y, float p, boolean st, float stRot) {
/* 1357 */       this.colorStart = cs;
/* 1358 */       this.colorEnd = ce;
/* 1359 */       this.pos = pos;
/* 1360 */       this.height = h;
/* 1361 */       this.width = w;
/* 1362 */       this.angle = (float)(Math.atan2((w / 2.0F), h) * 180.0D / Math.PI);
/* 1363 */       this.fixDir = fix;
/* 1364 */       this.steering = st;
/* 1365 */       this.yaw = y;
/* 1366 */       this.pitch = p;
/* 1367 */       this.stRot = stRot;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class DrawnPart
/*      */   {
/*      */     public final Vec3 pos;
/*      */     public final Vec3 rot;
/*      */     public final String modelName;
/*      */     public IModelCustom model;
/*      */     
/*      */     public DrawnPart(float px, float py, float pz, float rx, float ry, float rz, String name) {
/* 1380 */       this.pos = Vec3.func_72443_a(px, py, pz);
/* 1381 */       this.rot = Vec3.func_72443_a(rx, ry, rz);
/* 1382 */       this.modelName = name;
/* 1383 */       this.model = null;
/*      */     }
/*      */   }
/*      */   
/*      */   public class Throttle
/*      */     extends DrawnPart
/*      */   {
/*      */     public final Vec3 slide;
/*      */     public final float rot2;
/*      */     
/*      */     public Throttle(float px, float py, float pz, float rx, float ry, float rz, float rot, String name, float px2, float py2, float pz2) {
/* 1394 */       super(px, py, pz, rx, ry, rz, name);
/* 1395 */       this.rot2 = rot;
/* 1396 */       this.slide = Vec3.func_72443_a(px2, py2, pz2);
/*      */     }
/*      */   }
/*      */   
/*      */   public class PartWeapon
/*      */     extends DrawnPart
/*      */   {
/*      */     public final String[] name;
/*      */     public final boolean rotBarrel;
/*      */     public final boolean isMissile;
/*      */     public final boolean hideGM;
/*      */     public final boolean yaw;
/*      */     public final boolean pitch;
/*      */     public final float recoilBuf;
/*      */     public List child;
/*      */     public final boolean turret;
/*      */     
/*      */     public PartWeapon(String[] name, boolean rotBrl, boolean missile, boolean hgm, boolean y, boolean p, float px, float py, float pz, String modelName, float rx, float ry, float rz, float rb, boolean turret) {
/* 1414 */       super(px, py, pz, rx, ry, rz, modelName);
/* 1415 */       this.name = name;
/* 1416 */       this.rotBarrel = rotBrl;
/* 1417 */       this.isMissile = missile;
/* 1418 */       this.hideGM = hgm;
/* 1419 */       this.yaw = y;
/* 1420 */       this.pitch = p;
/* 1421 */       this.recoilBuf = rb;
/* 1422 */       this.child = new ArrayList();
/* 1423 */       this.turret = turret;
/*      */     }
/*      */   }
/*      */   
/*      */   public class PartWheel
/*      */     extends DrawnPart
/*      */   {
/*      */     final float rotDir;
/*      */     final Vec3 pos2;
/*      */     
/*      */     public PartWheel(float px, float py, float pz, float rx, float ry, float rz, float rd, float px2, float py2, float pz2, String name) {
/* 1434 */       super(px, py, pz, rx, ry, rz, name);
/* 1435 */       this.rotDir = rd;
/* 1436 */       this.pos2 = Vec3.func_72443_a(px2, py2, pz2);
/*      */     }
/*      */     
/*      */     public PartWheel(float px, float py, float pz, float rx, float ry, float rz, float rd, String name) {
/* 1440 */       this(px, py, pz, rx, ry, rz, rd, px, py, pz, name);
/*      */     }
/*      */   }
/*      */   
/*      */   public class Camera
/*      */     extends DrawnPart
/*      */   {
/*      */     public final boolean yawSync;
/*      */     public final boolean pitchSync;
/*      */     
/*      */     public Camera(float px, float py, float pz, float rx, float ry, float rz, String name, boolean ys, boolean ps) {
/* 1451 */       super(px, py, pz, rx, ry, rz, name);
/* 1452 */       this.yawSync = ys;
/* 1453 */       this.pitchSync = ps;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class Weapon
/*      */   {
/*      */     public final Vec3 pos;
/*      */     public final float yaw;
/*      */     public final float pitch;
/*      */     public final boolean canUsePilot;
/*      */     public final int seatID;
/*      */     public final float defaultYaw;
/*      */     public final float minYaw;
/*      */     public final float maxYaw;
/*      */     public final float minPitch;
/*      */     public final float maxPitch;
/*      */     public final boolean turret;
/*      */     
/*      */     public Weapon(float x, float y, float z, float yaw, float pitch, boolean canPirot, int seatId, float defy, float mny, float mxy, float mnp, float mxp, boolean turret) {
/* 1473 */       this.pos = Vec3.func_72443_a(x, y, z);
/* 1474 */       this.yaw = yaw;
/* 1475 */       this.pitch = pitch;
/* 1476 */       this.canUsePilot = canPirot;
/* 1477 */       this.seatID = seatId;
/* 1478 */       this.defaultYaw = defy;
/* 1479 */       this.minYaw = mny;
/* 1480 */       this.maxYaw = mxy;
/* 1481 */       this.minPitch = mnp;
/* 1482 */       this.maxPitch = mxp;
/* 1483 */       this.turret = turret;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class WeaponSet
/*      */   {
/*      */     public final String type;
/*      */     public ArrayList weapons;
/*      */     
/*      */     public WeaponSet(String t) {
/* 1494 */       this.type = t;
/* 1495 */       this.weapons = new ArrayList();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class RepellingHook
/*      */   {
/*      */     final Vec3 pos;
/*      */     final int interval;
/*      */     
/*      */     public RepellingHook(Vec3 pos, int inv) {
/* 1506 */       this.pos = pos;
/* 1507 */       this.interval = inv;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class Wheel
/*      */   {
/*      */     public final float size;
/*      */     public final Vec3 pos;
/*      */     
/*      */     public Wheel(Vec3 v, float sz) {
/* 1518 */       this.pos = v;
/* 1519 */       this.size = sz;
/*      */     }
/*      */     
/*      */     public Wheel(Vec3 v) {
/* 1523 */       this(v, 1.0F);
/*      */     }
/*      */   }
/*      */   
/*      */   public class Flare
/*      */   {
/* 1529 */     public int[] types = new int[0];
/* 1530 */     public Vec3 pos = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   public class RideRack
/*      */   {
/*      */     public final String name;
/*      */     
/*      */     public final int rackID;
/*      */ 
/*      */     
/*      */     public RideRack(String n, int id) {
/* 1542 */       this.name = n;
/* 1543 */       this.rackID = id;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class CameraPosition
/*      */   {
/*      */     public final Vec3 pos;
/*      */     public final boolean fixRot;
/*      */     public final float yaw;
/*      */     public final float pitch;
/*      */     
/*      */     public CameraPosition(Vec3 vec3, boolean fixRot, float yaw, float pitch) {
/* 1556 */       this.pos = vec3;
/* 1557 */       this.fixRot = fixRot;
/* 1558 */       this.yaw = yaw;
/* 1559 */       this.pitch = pitch;
/*      */     }
/*      */     
/*      */     public CameraPosition(Vec3 vec3) {
/* 1563 */       this(vec3, false, 0.0F, 0.0F);
/*      */     }
/*      */     
/*      */     public CameraPosition() {
/* 1567 */       this(Vec3.func_72443_a(0.0D, 0.0D, 0.0D));
/*      */     }
/*      */   }
/*      */   
/*      */   public class WeaponBay
/*      */     extends DrawnPart
/*      */   {
/*      */     public final float maxRotFactor;
/*      */     public final boolean isSlide;
/*      */     private final String weaponName;
/*      */     public Integer[] weaponIds;
/*      */     
/*      */     public WeaponBay(String wn, float px, float py, float pz, float rx, float ry, float rz, float mr, String name, boolean slide) {
/* 1580 */       super(px, py, pz, rx, ry, rz, name);
/* 1581 */       this.maxRotFactor = mr;
/* 1582 */       this.isSlide = slide;
/* 1583 */       this.weaponName = wn;
/* 1584 */       this.weaponIds = new Integer[0];
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class ParticleSplash
/*      */   {
/*      */     public final int num;
/*      */     public final float acceleration;
/*      */     public final float size;
/*      */     public final Vec3 pos;
/*      */     public final int age;
/*      */     public final float motionY;
/*      */     public final float gravity;
/*      */     
/*      */     public ParticleSplash(Vec3 v, int nm, float siz, float acc, int ag, float my, float gr) {
/* 1600 */       this.num = nm;
/* 1601 */       this.pos = v;
/* 1602 */       this.size = siz;
/* 1603 */       this.acceleration = acc;
/* 1604 */       this.age = ag;
/* 1605 */       this.motionY = my;
/* 1606 */       this.gravity = gr;
/*      */     }
/*      */   }
/*      */   
/*      */   public class CrawlerTrack
/*      */     extends DrawnPart {
/* 1612 */     public float len = 0.35F;
/*      */     
/*      */     public double[] cx;
/*      */     public double[] cy;
/*      */     public List lp;
/*      */     public float z;
/*      */     public int side;
/*      */     
/*      */     public CrawlerTrack(String name) {
/* 1621 */       super(0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, name);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public class CrawlerTrackPrm
/*      */   {
/*      */     float x;
/*      */     float y;
/*      */     float nx;
/*      */     float ny;
/*      */     float r;
/*      */     
/*      */     public CrawlerTrackPrm(float x, float y) {
/* 1635 */       this.x = x;
/* 1636 */       this.y = y;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_AircraftInfo.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */