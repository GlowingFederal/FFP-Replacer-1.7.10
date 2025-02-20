/*     */ package mcheli;
/*     */ 
/*     */ import java.io.File;
/*     */ import java.io.PrintWriter;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.wrapper.W_Block;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.DamageSource;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_Config
/*     */ {
/*     */   public static String mcPath;
/*     */   public static String configFilePath;
/*     */   public static boolean DebugLog;
/*     */   public static String configVer;
/*     */   public static int hitMarkColorRGB;
/*     */   public static float hitMarkColorAlpha;
/*     */   public static List bulletBreakableBlocks;
/*  30 */   public static final List dummyBreakableBlocks = new ArrayList();
/*  31 */   public static final List dummyBreakableMaterials = new ArrayList();
/*     */   public static List carNoBreakableBlocks;
/*     */   public static List carBreakableBlocks;
/*     */   public static List carBreakableMaterials;
/*     */   public static List tankNoBreakableBlocks;
/*     */   public static List tankBreakableBlocks;
/*     */   public static List tankBreakableMaterials;
/*     */   public static MCH_ConfigPrm KeyUp;
/*     */   public static MCH_ConfigPrm KeyDown;
/*     */   public static MCH_ConfigPrm KeyRight;
/*     */   public static MCH_ConfigPrm KeyLeft;
/*     */   public static MCH_ConfigPrm KeySwitchMode;
/*     */   public static MCH_ConfigPrm KeySwitchHovering;
/*     */   public static MCH_ConfigPrm KeyAttack;
/*     */   public static MCH_ConfigPrm KeyUseWeapon;
/*     */   public static MCH_ConfigPrm KeySwitchWeapon1;
/*     */   public static MCH_ConfigPrm KeySwitchWeapon2;
/*     */   public static MCH_ConfigPrm KeySwWeaponMode;
/*     */   public static MCH_ConfigPrm KeyZoom;
/*     */   public static MCH_ConfigPrm KeyCameraMode;
/*     */   public static MCH_ConfigPrm KeyUnmount;
/*     */   public static MCH_ConfigPrm KeyFlare;
/*     */   public static MCH_ConfigPrm KeyExtra;
/*     */   public static MCH_ConfigPrm KeyCameraDistUp;
/*     */   public static MCH_ConfigPrm KeyCameraDistDown;
/*     */   public static MCH_ConfigPrm KeyFreeLook;
/*     */   public static MCH_ConfigPrm KeyGUI;
/*     */   public static MCH_ConfigPrm KeyGearUpDown;
/*     */   public static MCH_ConfigPrm KeyPutToRack;
/*     */   public static MCH_ConfigPrm KeyDownFromRack;
/*     */   public static MCH_ConfigPrm KeyScoreboard;
/*     */   public static MCH_ConfigPrm KeyMultiplayManager;
/*     */   public static List DamageVs;
/*     */   public static List IgnoreBulletHitList;
/*     */   public static MCH_ConfigPrm IgnoreBulletHitItem;
/*     */   public static DamageFactor[] DamageFactorList;
/*     */   public static DamageFactor DamageVsEntity;
/*     */   public static DamageFactor DamageVsLiving;
/*     */   public static DamageFactor DamageVsPlayer;
/*     */   public static DamageFactor DamageVsMCHeliAircraft;
/*     */   public static DamageFactor DamageVsMCHeliTank;
/*     */   public static DamageFactor DamageVsMCHeliVehicle;
/*     */   public static DamageFactor DamageVsMCHeliOther;
/*     */   public static DamageFactor DamageAircraftByExternal;
/*     */   public static DamageFactor DamageTankByExternal;
/*     */   public static DamageFactor DamageVehicleByExternal;
/*     */   public static DamageFactor DamageOtherByExternal;
/*     */   public static List CommandPermission;
/*     */   public static List CommandPermissionList;
/*     */   public static MCH_ConfigPrm TestMode;
/*     */   public static MCH_ConfigPrm EnableCommand;
/*     */   public static MCH_ConfigPrm PlaceableOnSpongeOnly;
/*     */   public static MCH_ConfigPrm HideKeybind;
/*     */   public static MCH_ConfigPrm ItemDamage;
/*     */   public static MCH_ConfigPrm ItemFuel;
/*     */   public static MCH_ConfigPrm AutoRepairHP;
/*     */   public static MCH_ConfigPrm Collision_DestroyBlock;
/*     */   public static MCH_ConfigPrm Explosion_DestroyBlock;
/*     */   public static MCH_ConfigPrm Explosion_FlamingBlock;
/*     */   public static MCH_ConfigPrm BulletBreakableBlock;
/*     */   public static MCH_ConfigPrm Collision_Car_BreakableBlock;
/*     */   public static MCH_ConfigPrm Collision_Car_NoBreakableBlock;
/*     */   public static MCH_ConfigPrm Collision_Car_BreakableMaterial;
/*     */   public static MCH_ConfigPrm Collision_Tank_BreakableBlock;
/*     */   public static MCH_ConfigPrm Collision_Tank_NoBreakableBlock;
/*     */   public static MCH_ConfigPrm Collision_Tank_BreakableMaterial;
/*     */   public static MCH_ConfigPrm Collision_EntityDamage;
/*     */   public static MCH_ConfigPrm Collision_EntityTankDamage;
/*     */   public static MCH_ConfigPrm LWeaponAutoFire;
/*     */   public static MCH_ConfigPrm DismountAll;
/*     */   public static MCH_ConfigPrm MountMinecartHeli;
/*     */   public static MCH_ConfigPrm MountMinecartPlane;
/*     */   public static MCH_ConfigPrm MountMinecartVehicle;
/*     */   public static MCH_ConfigPrm MountMinecartTank;
/*     */   public static MCH_ConfigPrm AutoThrottleDownHeli;
/*     */   public static MCH_ConfigPrm AutoThrottleDownPlane;
/*     */   public static MCH_ConfigPrm AutoThrottleDownTank;
/*     */   public static MCH_ConfigPrm DisableItemRender;
/*     */   public static MCH_ConfigPrm RenderDistanceWeight;
/*     */   public static MCH_ConfigPrm MobRenderDistanceWeight;
/*     */   public static MCH_ConfigPrm CreativeTabIcon;
/*     */   public static MCH_ConfigPrm CreativeTabIconHeli;
/*     */   public static MCH_ConfigPrm CreativeTabIconPlane;
/*     */   public static MCH_ConfigPrm CreativeTabIconTank;
/*     */   public static MCH_ConfigPrm CreativeTabIconVehicle;
/*     */   public static MCH_ConfigPrm DisableShader;
/*     */   public static MCH_ConfigPrm AliveTimeOfCartridge;
/*     */   public static MCH_ConfigPrm InfinityAmmo;
/*     */   public static MCH_ConfigPrm InfinityFuel;
/*     */   public static MCH_ConfigPrm HitMarkColor;
/*     */   public static MCH_ConfigPrm SmoothShading;
/*     */   public static MCH_ConfigPrm EnableModEntityRender;
/*     */   public static MCH_ConfigPrm DisableRenderLivingSpecials;
/*     */   public static MCH_ConfigPrm PreventingBroken;
/*     */   public static MCH_ConfigPrm DropItemInCreativeMode;
/*     */   public static MCH_ConfigPrm BreakableOnlyPickaxe;
/*     */   public static MCH_ConfigPrm InvertMouse;
/*     */   public static MCH_ConfigPrm MouseSensitivity;
/*     */   public static MCH_ConfigPrm MouseControlStickModeHeli;
/*     */   public static MCH_ConfigPrm MouseControlStickModePlane;
/*     */   public static MCH_ConfigPrm MouseControlFlightSimMode;
/*     */   public static MCH_ConfigPrm SwitchWeaponWithMouseWheel;
/*     */   public static MCH_ConfigPrm AllPlaneSpeed;
/*     */   public static MCH_ConfigPrm AllHeliSpeed;
/*     */   public static MCH_ConfigPrm AllTankSpeed;
/*     */   public static MCH_ConfigPrm HurtResistantTime;
/*     */   public static MCH_ConfigPrm DisplayHUDThirdPerson;
/*     */   public static MCH_ConfigPrm DisableCameraDistChange;
/*     */   public static MCH_ConfigPrm EnableReplaceTextureManager;
/*     */   public static MCH_ConfigPrm DisplayEntityMarker;
/*     */   public static MCH_ConfigPrm EntityMarkerSize;
/*     */   public static MCH_ConfigPrm BlockMarkerSize;
/*     */   public static MCH_ConfigPrm DisplayMarkThroughWall;
/*     */   public static MCH_ConfigPrm ReplaceRenderViewEntity;
/*     */   public static MCH_ConfigPrm StingerLockRange;
/*     */   public static MCH_ConfigPrm DefaultExplosionParticle;
/*     */   public static MCH_ConfigPrm RangeFinderSpotDist;
/*     */   public static MCH_ConfigPrm RangeFinderSpotTime;
/*     */   public static MCH_ConfigPrm RangeFinderConsume;
/*     */   public static MCH_ConfigPrm EnablePutRackInFlying;
/*     */   public static MCH_ConfigPrm EnableDebugBoundingBox;
/*     */   public static MCH_ConfigPrm RangeOfGunner_VsMonster_Vertical;
/*     */   public static MCH_ConfigPrm RangeOfGunner_VsMonster_Horizontal;
/*     */   public static MCH_ConfigPrm RangeOfGunner_VsPlayer_Vertical;
/*     */   public static MCH_ConfigPrm RangeOfGunner_VsPlayer_Horizontal;
/*     */   public static MCH_ConfigPrm HitBoxDelayTick;
/*     */   public static MCH_ConfigPrm ItemID_Fuel;
/*     */   public static MCH_ConfigPrm ItemID_GLTD;
/*     */   public static MCH_ConfigPrm ItemID_Chain;
/*     */   public static MCH_ConfigPrm ItemID_Parachute;
/*     */   public static MCH_ConfigPrm ItemID_Container;
/*     */   public static MCH_ConfigPrm ItemID_Stinger;
/*     */   public static MCH_ConfigPrm ItemID_StingerMissile;
/*     */   public static MCH_ConfigPrm[] ItemID_UavStation;
/*     */   public static MCH_ConfigPrm ItemID_InvisibleItem;
/*     */   public static MCH_ConfigPrm ItemID_DraftingTable;
/*     */   public static MCH_ConfigPrm ItemID_Wrench;
/*     */   public static MCH_ConfigPrm ItemID_RangeFinder;
/*     */   public static MCH_ConfigPrm BlockID_DraftingTableOFF;
/*     */   public static MCH_ConfigPrm BlockID_DraftingTableON;
/*     */   public static MCH_ConfigPrm ItemRecipe_Fuel;
/*     */   public static MCH_ConfigPrm ItemRecipe_GLTD;
/*     */   public static MCH_ConfigPrm ItemRecipe_Chain;
/*     */   public static MCH_ConfigPrm ItemRecipe_Parachute;
/*     */   public static MCH_ConfigPrm ItemRecipe_Container;
/*     */   public static MCH_ConfigPrm ItemRecipe_Stinger;
/*     */   public static MCH_ConfigPrm ItemRecipe_StingerMissile;
/*     */   public static MCH_ConfigPrm ItemRecipe_Javelin;
/*     */   public static MCH_ConfigPrm ItemRecipe_JavelinMissile;
/*     */   public static MCH_ConfigPrm[] ItemRecipe_UavStation;
/*     */   public static MCH_ConfigPrm ItemRecipe_DraftingTable;
/*     */   public static MCH_ConfigPrm ItemRecipe_Wrench;
/*     */   public static MCH_ConfigPrm ItemRecipe_RangeFinder;
/*     */   public static MCH_ConfigPrm[] KeyConfig;
/*     */   public static MCH_ConfigPrm[] General;
/* 186 */   public final String destroyBlockNames = "glass_pane, stained_glass_pane, tallgrass, double_plant, yellow_flower, red_flower, vine, wheat, reeds, waterlily";
/*     */ 
/*     */   
/*     */   public MCH_Config(String minecraftPath, String cfgFile) {
/* 190 */     mcPath = minecraftPath;
/* 191 */     configFilePath = mcPath + cfgFile;
/* 192 */     DebugLog = false;
/* 193 */     configVer = "0.0.0";
/* 194 */     bulletBreakableBlocks = new ArrayList();
/* 195 */     carBreakableBlocks = new ArrayList();
/* 196 */     carNoBreakableBlocks = new ArrayList();
/* 197 */     carBreakableMaterials = new ArrayList();
/* 198 */     tankBreakableBlocks = new ArrayList();
/* 199 */     tankNoBreakableBlocks = new ArrayList();
/* 200 */     tankBreakableMaterials = new ArrayList();
/* 201 */     KeyUp = new MCH_ConfigPrm("KeyUp", 17);
/* 202 */     KeyDown = new MCH_ConfigPrm("KeyDown", 31);
/* 203 */     KeyRight = new MCH_ConfigPrm("KeyRight", 32);
/* 204 */     KeyLeft = new MCH_ConfigPrm("KeyLeft", 30);
/* 205 */     KeySwitchMode = new MCH_ConfigPrm("KeySwitchGunner", 35);
/* 206 */     KeySwitchHovering = new MCH_ConfigPrm("KeySwitchHovering", 57);
/* 207 */     KeyAttack = new MCH_ConfigPrm("KeyAttack", -100);
/* 208 */     KeyUseWeapon = new MCH_ConfigPrm("KeyUseWeapon", -99);
/* 209 */     KeySwitchWeapon1 = new MCH_ConfigPrm("KeySwitchWeapon1", -98);
/* 210 */     KeySwitchWeapon2 = new MCH_ConfigPrm("KeySwitchWeapon2", 34);
/* 211 */     KeySwWeaponMode = new MCH_ConfigPrm("KeySwitchWeaponMode", 45);
/* 212 */     KeyZoom = new MCH_ConfigPrm("KeyZoom", 44);
/* 213 */     KeyCameraMode = new MCH_ConfigPrm("KeyCameraMode", 46);
/* 214 */     KeyUnmount = new MCH_ConfigPrm("KeyUnmountMob", 21);
/* 215 */     KeyFlare = new MCH_ConfigPrm("KeyFlare", 47);
/* 216 */     KeyExtra = new MCH_ConfigPrm("KeyExtra", 33);
/* 217 */     KeyCameraDistUp = new MCH_ConfigPrm("KeyCameraDistanceUp", 201);
/* 218 */     KeyCameraDistDown = new MCH_ConfigPrm("KeyCameraDistanceDown", 209);
/* 219 */     KeyFreeLook = new MCH_ConfigPrm("KeyFreeLook", 29);
/* 220 */     KeyGUI = new MCH_ConfigPrm("KeyGUI", 19);
/* 221 */     KeyGearUpDown = new MCH_ConfigPrm("KeyGearUpDown", 48);
/* 222 */     KeyPutToRack = new MCH_ConfigPrm("KeyPutToRack", 36);
/* 223 */     KeyDownFromRack = new MCH_ConfigPrm("KeyDownFromRack", 22);
/* 224 */     KeyScoreboard = new MCH_ConfigPrm("KeyScoreboard", 38);
/* 225 */     KeyMultiplayManager = new MCH_ConfigPrm("KeyMultiplayManager", 50);
/* 226 */     KeyConfig = new MCH_ConfigPrm[] { KeyUp, KeyDown, KeyRight, KeyLeft, KeySwitchMode, KeySwitchHovering, KeySwitchWeapon1, KeySwitchWeapon2, KeySwWeaponMode, KeyZoom, KeyCameraMode, KeyUnmount, KeyFlare, KeyExtra, KeyCameraDistUp, KeyCameraDistDown, KeyFreeLook, KeyGUI, KeyGearUpDown, KeyPutToRack, KeyDownFromRack, KeyScoreboard, KeyMultiplayManager };
/* 227 */     DamageVs = new ArrayList();
/* 228 */     CommandPermission = new ArrayList();
/* 229 */     CommandPermissionList = new ArrayList();
/* 230 */     IgnoreBulletHitList = new ArrayList();
/* 231 */     IgnoreBulletHitItem = new MCH_ConfigPrm("IgnoreBulletHit", "");
/* 232 */     TestMode = new MCH_ConfigPrm("TestMode", false);
/* 233 */     EnableCommand = new MCH_ConfigPrm("EnableCommand", true);
/* 234 */     PlaceableOnSpongeOnly = new MCH_ConfigPrm("PlaceableOnSpongeOnly", false);
/* 235 */     HideKeybind = new MCH_ConfigPrm("HideKeybind", false);
/* 236 */     ItemDamage = new MCH_ConfigPrm("ItemDamage", true);
/* 237 */     ItemFuel = new MCH_ConfigPrm("ItemFuel", true);
/* 238 */     AutoRepairHP = new MCH_ConfigPrm("AutoRepairHP", 0.5D);
/* 239 */     Collision_DestroyBlock = new MCH_ConfigPrm("Collision_DestroyBlock", true);
/* 240 */     Explosion_DestroyBlock = new MCH_ConfigPrm("Explosion_DestroyBlock", true);
/* 241 */     Explosion_FlamingBlock = new MCH_ConfigPrm("Explosion_FlamingBlock", true);
/* 242 */     Collision_Car_BreakableBlock = new MCH_ConfigPrm("Collision_Car_BreakableBlock", "double_plant, glass_pane,stained_glass_pane");
/* 243 */     Collision_Car_NoBreakableBlock = new MCH_ConfigPrm("Collision_Car_NoBreakBlock", "torch");
/* 244 */     Collision_Car_BreakableMaterial = new MCH_ConfigPrm("Collision_Car_BreakableMaterial", "cactus, cake, gourd, leaves, vine, plants");
/* 245 */     Collision_Tank_BreakableBlock = new MCH_ConfigPrm("Collision_Tank_BreakableBlock", "nether_brick_fence");
/* 246 */     Collision_Tank_BreakableBlock.validVer = "1.0.0";
/* 247 */     Collision_Tank_NoBreakableBlock = new MCH_ConfigPrm("Collision_Tank_NoBreakBlock", "torch, glowstone");
/* 248 */     Collision_Tank_BreakableMaterial = new MCH_ConfigPrm("Collision_Tank_BreakableMaterial", "cactus, cake, carpet, circuits, glass, gourd, leaves, vine, wood, plants");
/* 249 */     Collision_EntityDamage = new MCH_ConfigPrm("Collision_EntityDamage", true);
/* 250 */     Collision_EntityTankDamage = new MCH_ConfigPrm("Collision_EntityTankDamage", false);
/* 251 */     LWeaponAutoFire = new MCH_ConfigPrm("LWeaponAutoFire", false);
/* 252 */     DismountAll = new MCH_ConfigPrm("DismountAll", false);
/* 253 */     MountMinecartHeli = new MCH_ConfigPrm("MountMinecartHeli", true);
/* 254 */     MountMinecartPlane = new MCH_ConfigPrm("MountMinecartPlane", true);
/* 255 */     MountMinecartVehicle = new MCH_ConfigPrm("MountMinecartVehicle", false);
/* 256 */     MountMinecartTank = new MCH_ConfigPrm("MountMinecartTank", true);
/* 257 */     AutoThrottleDownHeli = new MCH_ConfigPrm("AutoThrottleDownHeli", true);
/* 258 */     AutoThrottleDownPlane = new MCH_ConfigPrm("AutoThrottleDownPlane", false);
/* 259 */     AutoThrottleDownTank = new MCH_ConfigPrm("AutoThrottleDownTank", false);
/* 260 */     DisableItemRender = new MCH_ConfigPrm("DisableItemRender", 1);
/* 261 */     DisableItemRender.desc = ";DisableItemRender = 0 ~ 3 (1 = Recommended)";
/* 262 */     RenderDistanceWeight = new MCH_ConfigPrm("RenderDistanceWeight", 10.0D);
/* 263 */     MobRenderDistanceWeight = new MCH_ConfigPrm("MobRenderDistanceWeight", 1.0D);
/* 264 */     CreativeTabIcon = new MCH_ConfigPrm("CreativeTabIconItem", "fuel");
/* 265 */     CreativeTabIconHeli = new MCH_ConfigPrm("CreativeTabIconHeli", "ah-64");
/* 266 */     CreativeTabIconPlane = new MCH_ConfigPrm("CreativeTabIconPlane", "f22a");
/* 267 */     CreativeTabIconTank = new MCH_ConfigPrm("CreativeTabIconTank", "merkava_mk4");
/* 268 */     CreativeTabIconVehicle = new MCH_ConfigPrm("CreativeTabIconVehicle", "mk15");
/* 269 */     DisableShader = new MCH_ConfigPrm("DisableShader", false);
/* 270 */     AliveTimeOfCartridge = new MCH_ConfigPrm("AliveTimeOfCartridge", 200);
/* 271 */     InfinityAmmo = new MCH_ConfigPrm("InfinityAmmo", false);
/* 272 */     InfinityFuel = new MCH_ConfigPrm("InfinityFuel", false);
/* 273 */     HitMarkColor = new MCH_ConfigPrm("HitMarkColor", "255, 255, 0, 0");
/* 274 */     HitMarkColor.desc = ";HitMarkColor = Alpha, Red, Green, Blue";
/* 275 */     SmoothShading = new MCH_ConfigPrm("SmoothShading", true);
/* 276 */     BulletBreakableBlock = new MCH_ConfigPrm("BulletBreakableBlocks", "glass_pane, stained_glass_pane, tallgrass, double_plant, yellow_flower, red_flower, vine, wheat, reeds, waterlily");
/* 277 */     BulletBreakableBlock.validVer = "0.10.4";
/* 278 */     EnableModEntityRender = new MCH_ConfigPrm("EnableModEntityRender", true);
/* 279 */     DisableRenderLivingSpecials = new MCH_ConfigPrm("DisableRenderLivingSpecials", true);
/* 280 */     PreventingBroken = new MCH_ConfigPrm("PreventingBroken", false);
/* 281 */     DropItemInCreativeMode = new MCH_ConfigPrm("DropItemInCreativeMode", false);
/* 282 */     BreakableOnlyPickaxe = new MCH_ConfigPrm("BreakableOnlyPickaxe", false);
/* 283 */     InvertMouse = new MCH_ConfigPrm("InvertMouse", false);
/* 284 */     MouseSensitivity = new MCH_ConfigPrm("MouseSensitivity", 10.0D);
/* 285 */     MouseControlStickModeHeli = new MCH_ConfigPrm("MouseControlStickModeHeli", false);
/* 286 */     MouseControlStickModePlane = new MCH_ConfigPrm("MouseControlStickModePlane", false);
/* 287 */     MouseControlFlightSimMode = new MCH_ConfigPrm("MouseControlFlightSimMode", false);
/* 288 */     MouseControlFlightSimMode.desc = ";MouseControlFlightSimMode = true ( Yaw:key, Roll=mouse )";
/* 289 */     SwitchWeaponWithMouseWheel = new MCH_ConfigPrm("SwitchWeaponWithMouseWheel", true);
/* 290 */     AllHeliSpeed = new MCH_ConfigPrm("AllHeliSpeed", 1.0D);
/* 291 */     AllPlaneSpeed = new MCH_ConfigPrm("AllPlaneSpeed", 1.0D);
/* 292 */     AllTankSpeed = new MCH_ConfigPrm("AllTankSpeed", 1.0D);
/* 293 */     HurtResistantTime = new MCH_ConfigPrm("HurtResistantTime", 0.0D);
/* 294 */     DisplayHUDThirdPerson = new MCH_ConfigPrm("DisplayHUDThirdPerson", false);
/* 295 */     DisableCameraDistChange = new MCH_ConfigPrm("DisableThirdPersonCameraDistChange", false);
/* 296 */     EnableReplaceTextureManager = new MCH_ConfigPrm("EnableReplaceTextureManager", true);
/* 297 */     DisplayEntityMarker = new MCH_ConfigPrm("DisplayEntityMarker", true);
/* 298 */     DisplayMarkThroughWall = new MCH_ConfigPrm("DisplayMarkThroughWall", true);
/* 299 */     EntityMarkerSize = new MCH_ConfigPrm("EntityMarkerSize", 10.0D);
/* 300 */     BlockMarkerSize = new MCH_ConfigPrm("BlockMarkerSize", 10.0D);
/* 301 */     ReplaceRenderViewEntity = new MCH_ConfigPrm("ReplaceRenderViewEntity", true);
/* 302 */     StingerLockRange = new MCH_ConfigPrm("StingerLockRange", 320.0D);
/* 303 */     StingerLockRange.validVer = "1.0.0";
/* 304 */     DefaultExplosionParticle = new MCH_ConfigPrm("DefaultExplosionParticle", false);
/* 305 */     RangeFinderSpotDist = new MCH_ConfigPrm("RangeFinderSpotDist", 400);
/* 306 */     RangeFinderSpotTime = new MCH_ConfigPrm("RangeFinderSpotTime", 15);
/* 307 */     RangeFinderConsume = new MCH_ConfigPrm("RangeFinderConsume", true);
/* 308 */     EnablePutRackInFlying = new MCH_ConfigPrm("EnablePutRackInFlying", true);
/* 309 */     EnableDebugBoundingBox = new MCH_ConfigPrm("EnableDebugBoundingBox", true);
/* 310 */     RangeOfGunner_VsMonster_Horizontal = new MCH_ConfigPrm("RangeOfGunner_VsMonster_Horizontal", 80);
/* 311 */     RangeOfGunner_VsMonster_Vertical = new MCH_ConfigPrm("RangeOfGunner_VsMonster_Vertical", 160);
/* 312 */     RangeOfGunner_VsPlayer_Horizontal = new MCH_ConfigPrm("RangeOfGunner_VsPlayer_Horizontal", 200);
/* 313 */     RangeOfGunner_VsPlayer_Vertical = new MCH_ConfigPrm("RangeOfGunner_VsPlayer_Vertical", 300);
/* 314 */     HitBoxDelayTick = new MCH_ConfigPrm("HitBoxDelayTick", 0);
/* 315 */     hitMarkColorAlpha = 1.0F;
/* 316 */     hitMarkColorRGB = 16711680;
/* 317 */     ItemRecipe_Fuel = new MCH_ConfigPrm("ItemRecipe_Fuel", "\"ICI\", \"III\", I, iron_ingot, C, coal");
/* 318 */     ItemRecipe_GLTD = new MCH_ConfigPrm("ItemRecipe_GLTD", "\" B \", \"IDI\", \"IRI\", B, iron_block, I, iron_ingot, D, diamond, R, redstone");
/* 319 */     ItemRecipe_Chain = new MCH_ConfigPrm("ItemRecipe_Chain", "\"I I\", \"III\", \"I I\", I, iron_ingot");
/* 320 */     ItemRecipe_Parachute = new MCH_ConfigPrm("ItemRecipe_Parachute", "\"WWW\", \"S S\", \" W \", W, wool, S, string");
/* 321 */     ItemRecipe_Container = new MCH_ConfigPrm("ItemRecipe_Container", "\"CCI\", C, chest, I, iron_ingot");
/* 322 */     ItemRecipe_UavStation = new MCH_ConfigPrm[] { new MCH_ConfigPrm("ItemRecipe_UavStation", "\"III\", \"IDI\", \"IRI\", I, iron_ingot, D, diamond, R, redstone_block"), new MCH_ConfigPrm("ItemRecipe_UavStation2", "\"IDI\", \"IRI\", I, iron_ingot, D, diamond, R, redstone") };
/* 323 */     ItemRecipe_DraftingTable = new MCH_ConfigPrm("ItemRecipe_DraftingTable", "\"R  \", \"PCP\", \"F F\", R, redstone, C, crafting_table, P, planks, F, fence");
/* 324 */     ItemRecipe_Wrench = new MCH_ConfigPrm("ItemRecipe_Wrench", "\" I \", \" II\", \"I  \", I, iron_ingot");
/* 325 */     ItemRecipe_RangeFinder = new MCH_ConfigPrm("ItemRecipe_RangeFinder", "\"III\", \"RGR\", \"III\", I, iron_ingot, G, glass, R, redstone");
/* 326 */     ItemRecipe_Stinger = new MCH_ConfigPrm("ItemRecipe_Stinger", "\"G  \", \"III\", \"RI \", G, glass, I, iron_ingot, R, redstone");
/* 327 */     ItemRecipe_StingerMissile = new MCH_ConfigPrm("ItemRecipe_StingerMissile", "\"R  \", \" I \", \"  G\", G, gunpowder, I, iron_ingot, R, redstone");
/* 328 */     ItemRecipe_Javelin = new MCH_ConfigPrm("ItemRecipe_Javelin", "\"III\", \"GR \", G, glass, I, iron_ingot, R, redstone");
/* 329 */     ItemRecipe_JavelinMissile = new MCH_ConfigPrm("ItemRecipe_JavelinMissile", "\" R \", \" I \", \" G \", G, gunpowder, I, iron_ingot, R, redstone");
/* 330 */     ItemID_GLTD = new MCH_ConfigPrm("ItemID_GLTD", 28799);
/* 331 */     ItemID_Chain = new MCH_ConfigPrm("ItemID_Chain", 28798);
/* 332 */     ItemID_Parachute = new MCH_ConfigPrm("ItemID_Parachute", 28797);
/* 333 */     ItemID_Container = new MCH_ConfigPrm("ItemID_Container", 28796);
/* 334 */     ItemID_UavStation = new MCH_ConfigPrm[] { new MCH_ConfigPrm("ItemID_UavStation", 28795), new MCH_ConfigPrm("ItemID_UavStation2", 28790) };
/* 335 */     ItemID_InvisibleItem = new MCH_ConfigPrm("ItemID_Internal", 28794);
/* 336 */     ItemID_Fuel = new MCH_ConfigPrm("ItemID_Fuel", 28793);
/* 337 */     ItemID_DraftingTable = new MCH_ConfigPrm("ItemID_DraftingTable", 28792);
/* 338 */     ItemID_Wrench = new MCH_ConfigPrm("ItemID_Wrench", 28791);
/* 339 */     ItemID_RangeFinder = new MCH_ConfigPrm("ItemID_RangeFinder", 28789);
/* 340 */     ItemID_Stinger = new MCH_ConfigPrm("ItemID_Stinger", 28900);
/* 341 */     ItemID_StingerMissile = new MCH_ConfigPrm("ItemID_StingerMissile", 28901);
/* 342 */     BlockID_DraftingTableOFF = new MCH_ConfigPrm("BlockID_DraftingTable", 3450);
/* 343 */     BlockID_DraftingTableON = new MCH_ConfigPrm("BlockID_DraftingTableON", 3451);
/* 344 */     General = new MCH_ConfigPrm[] { TestMode, EnableCommand, null, PlaceableOnSpongeOnly, ItemDamage, ItemFuel, AutoRepairHP, Explosion_DestroyBlock, Explosion_FlamingBlock, BulletBreakableBlock, Collision_DestroyBlock, Collision_Car_BreakableBlock, Collision_Car_BreakableMaterial, Collision_Tank_BreakableBlock, Collision_Tank_BreakableMaterial, Collision_EntityDamage, Collision_EntityTankDamage, InfinityAmmo, InfinityFuel, DismountAll, MountMinecartHeli, MountMinecartPlane, MountMinecartVehicle, MountMinecartTank, PreventingBroken, DropItemInCreativeMode, BreakableOnlyPickaxe, AllHeliSpeed, AllPlaneSpeed, AllTankSpeed, HurtResistantTime, StingerLockRange, RangeFinderSpotDist, RangeFinderSpotTime, RangeFinderConsume, EnablePutRackInFlying, EnableDebugBoundingBox, null, InvertMouse, MouseSensitivity, MouseControlStickModeHeli, MouseControlStickModePlane, MouseControlFlightSimMode, AutoThrottleDownHeli, AutoThrottleDownPlane, AutoThrottleDownTank, SwitchWeaponWithMouseWheel, LWeaponAutoFire, DisableItemRender, HideKeybind, RenderDistanceWeight, MobRenderDistanceWeight, CreativeTabIcon, CreativeTabIconHeli, CreativeTabIconPlane, CreativeTabIconTank, CreativeTabIconVehicle, DisableShader, DefaultExplosionParticle, AliveTimeOfCartridge, HitMarkColor, SmoothShading, EnableModEntityRender, DisableRenderLivingSpecials, DisplayHUDThirdPerson, DisableCameraDistChange, EnableReplaceTextureManager, DisplayEntityMarker, EntityMarkerSize, BlockMarkerSize, ReplaceRenderViewEntity, null, ItemRecipe_Fuel, ItemRecipe_GLTD, ItemRecipe_Chain, ItemRecipe_Parachute, ItemRecipe_Container, ItemRecipe_UavStation[0], ItemRecipe_UavStation[1], ItemRecipe_DraftingTable, ItemRecipe_Wrench, ItemRecipe_RangeFinder, ItemRecipe_Stinger, ItemRecipe_StingerMissile, ItemRecipe_Javelin, ItemRecipe_JavelinMissile };
/* 345 */     DamageVsEntity = new DamageFactor("DamageVsEntity");
/* 346 */     DamageVsLiving = new DamageFactor("DamageVsLiving");
/* 347 */     DamageVsPlayer = new DamageFactor("DamageVsPlayer");
/* 348 */     DamageVsMCHeliAircraft = new DamageFactor("DamageVsMCHeliAircraft");
/* 349 */     DamageVsMCHeliTank = new DamageFactor("DamageVsMCHeliTank");
/* 350 */     DamageVsMCHeliVehicle = new DamageFactor("DamageVsMCHeliVehicle");
/* 351 */     DamageVsMCHeliOther = new DamageFactor("DamageVsMCHeliOther");
/* 352 */     DamageAircraftByExternal = new DamageFactor("DamageMCHeliAircraftByExternal");
/* 353 */     DamageTankByExternal = new DamageFactor("DamageMCHeliTankByExternal");
/* 354 */     DamageVehicleByExternal = new DamageFactor("DamageMCHeliVehicleByExternal");
/* 355 */     DamageOtherByExternal = new DamageFactor("DamageMCHeliOtherByExternal");
/* 356 */     DamageFactorList = new DamageFactor[] { DamageVsEntity, DamageVsLiving, DamageVsPlayer, DamageVsMCHeliAircraft, DamageVsMCHeliTank, DamageVsMCHeliVehicle, DamageVsMCHeliOther, DamageAircraftByExternal, DamageTankByExternal, DamageVehicleByExternal, DamageOtherByExternal };
/*     */   }
/*     */   
/*     */   public void setBlockListFromString(List<Block> list, String str) {
/* 360 */     list.clear();
/* 361 */     String[] s = str.split("\\s*,\\s*");
/* 362 */     String[] arr$ = s;
/* 363 */     int len$ = s.length;
/*     */     
/* 365 */     for (int i$ = 0; i$ < len$; i$++) {
/* 366 */       String blockName = arr$[i$];
/* 367 */       Block b = W_Block.getBlockFromName(blockName);
/* 368 */       if (b != null) {
/* 369 */         list.add(b);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void setMaterialListFromString(List<Material> list, String str) {
/* 376 */     list.clear();
/* 377 */     String[] s = str.split("\\s*,\\s*");
/* 378 */     String[] arr$ = s;
/* 379 */     int len$ = s.length;
/*     */     
/* 381 */     for (int i$ = 0; i$ < len$; i$++) {
/* 382 */       String name = arr$[i$];
/* 383 */       Material m = MCH_Lib.getMaterialFromName(name);
/* 384 */       if (m != null) {
/* 385 */         list.add(m);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void correctionParameter() {
/* 392 */     String[] s = HitMarkColor.prmString.split("\\s*,\\s*");
/* 393 */     if (s.length == 4) {
/* 394 */       hitMarkColorAlpha = toInt255(s[0]) / 255.0F;
/* 395 */       hitMarkColorRGB = toInt255(s[1]) << 16 | toInt255(s[2]) << 8 | toInt255(s[3]);
/*     */     } 
/*     */     
/* 398 */     AllHeliSpeed.prmDouble = MCH_Lib.RNG(AllHeliSpeed.prmDouble, 0.0D, 1000.0D);
/* 399 */     AllPlaneSpeed.prmDouble = MCH_Lib.RNG(AllPlaneSpeed.prmDouble, 0.0D, 1000.0D);
/* 400 */     AllTankSpeed.prmDouble = MCH_Lib.RNG(AllTankSpeed.prmDouble, 0.0D, 1000.0D);
/* 401 */     setBlockListFromString(bulletBreakableBlocks, BulletBreakableBlock.prmString);
/* 402 */     setBlockListFromString(carBreakableBlocks, Collision_Car_BreakableBlock.prmString);
/* 403 */     setBlockListFromString(carNoBreakableBlocks, Collision_Car_NoBreakableBlock.prmString);
/* 404 */     setMaterialListFromString(carBreakableMaterials, Collision_Car_BreakableMaterial.prmString);
/* 405 */     setBlockListFromString(tankBreakableBlocks, Collision_Tank_BreakableBlock.prmString);
/* 406 */     setBlockListFromString(tankNoBreakableBlocks, Collision_Tank_NoBreakableBlock.prmString);
/* 407 */     setMaterialListFromString(tankBreakableMaterials, Collision_Tank_BreakableMaterial.prmString);
/* 408 */     if (EntityMarkerSize.prmDouble < 0.0D) {
/* 409 */       EntityMarkerSize.prmDouble = 0.0D;
/*     */     }
/*     */     
/* 412 */     if (BlockMarkerSize.prmDouble < 0.0D) {
/* 413 */       BlockMarkerSize.prmDouble = 0.0D;
/*     */     }
/*     */     
/* 416 */     if (HurtResistantTime.prmDouble < 0.0D) {
/* 417 */       HurtResistantTime.prmDouble = 0.0D;
/*     */     }
/*     */     
/* 420 */     if (HurtResistantTime.prmDouble > 10000.0D) {
/* 421 */       HurtResistantTime.prmDouble = 10000.0D;
/*     */     }
/*     */     
/* 424 */     if (MobRenderDistanceWeight.prmDouble < 0.1D) {
/* 425 */       MobRenderDistanceWeight.prmDouble = 0.1D;
/* 426 */     } else if (MobRenderDistanceWeight.prmDouble > 10.0D) {
/* 427 */       MobRenderDistanceWeight.prmDouble = 10.0D;
/*     */     } 
/*     */     
/* 430 */     Iterator<MCH_ConfigPrm> isNoDamageVsSetting = CommandPermission.iterator();
/*     */     
/* 432 */     while (isNoDamageVsSetting.hasNext()) {
/* 433 */       MCH_ConfigPrm arr$ = isNoDamageVsSetting.next();
/* 434 */       CommandPermission len$ = new CommandPermission(arr$.prmString);
/* 435 */       if (!len$.name.isEmpty()) {
/* 436 */         CommandPermissionList.add(len$);
/*     */       }
/*     */     } 
/*     */     
/* 440 */     if (IgnoreBulletHitList.size() <= 0) {
/* 441 */       IgnoreBulletHitList.add("flansmod.common.guns.EntityBullet");
/* 442 */       IgnoreBulletHitList.add("flansmod.common.guns.EntityGrenade");
/*     */     } 
/*     */     
/* 445 */     boolean var10 = (DamageVs.size() <= 0);
/* 446 */     Iterator<MCH_ConfigPrm> var11 = DamageVs.iterator();
/*     */     
/* 448 */     while (var11.hasNext()) {
/* 449 */       MCH_ConfigPrm var13 = var11.next();
/* 450 */       DamageFactor[] i$ = DamageFactorList;
/* 451 */       int df = i$.length;
/*     */       
/* 453 */       for (int foundCommon = 0; foundCommon < df; foundCommon++) {
/* 454 */         DamageFactor i$1 = i$[foundCommon];
/* 455 */         if (var13.name.equals(i$1.itemName)) {
/* 456 */           i$1.list.add(newDamageEntity(var13.prmString));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 461 */     DamageFactor[] var12 = DamageFactorList;
/* 462 */     int var14 = var12.length;
/*     */     
/* 464 */     for (int var15 = 0; var15 < var14; var15++) {
/* 465 */       DamageFactor var16 = var12[var15];
/* 466 */       if (var16.list.size() <= 0) {
/* 467 */         DamageVs.add(new MCH_ConfigPrm(var16.itemName, "1.0"));
/*     */       } else {
/* 469 */         boolean var17 = false;
/* 470 */         Iterator<DamageEntity> var18 = var16.list.iterator();
/*     */         
/* 472 */         while (var18.hasNext()) {
/* 473 */           DamageEntity n = var18.next();
/* 474 */           if (n.name.isEmpty()) {
/* 475 */             var17 = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 480 */         if (!var17) {
/* 481 */           DamageVs.add(new MCH_ConfigPrm(var16.itemName, "1.0"));
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 486 */     if (var10) {
/* 487 */       DamageVs.add(new MCH_ConfigPrm("DamageVsEntity", "3.0, flansmod"));
/* 488 */       DamageVs.add(new MCH_ConfigPrm("DamageMCHeliAircraftByExternal", "0.5, flansmod"));
/* 489 */       DamageVs.add(new MCH_ConfigPrm("DamageMCHeliVehicleByExternal", "0.5, flansmod"));
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public DamageEntity newDamageEntity(String s) {
/* 495 */     String[] splt = s.split("\\s*,\\s*");
/* 496 */     return (splt.length == 1) ? new DamageEntity(Double.parseDouble(splt[0]), "") : ((splt.length == 2) ? new DamageEntity(Double.parseDouble(splt[0]), splt[1]) : new DamageEntity(1.0D, ""));
/*     */   }
/*     */   
/*     */   public static float applyDamageByExternal(Entity target, DamageSource ds, float damage) {
/*     */     List list;
/* 501 */     if (!(target instanceof mcheli.helicopter.MCH_EntityHeli) && !(target instanceof mcheli.plane.MCP_EntityPlane)) {
/* 502 */       if (target instanceof mcheli.tank.MCH_EntityTank) {
/* 503 */         list = DamageTankByExternal.list;
/* 504 */       } else if (target instanceof mcheli.vehicle.MCH_EntityVehicle) {
/* 505 */         list = DamageVehicleByExternal.list;
/*     */       } else {
/* 507 */         list = DamageOtherByExternal.list;
/*     */       } 
/*     */     } else {
/* 510 */       list = DamageAircraftByExternal.list;
/*     */     } 
/*     */     
/* 513 */     Entity attacker = ds.func_76346_g();
/* 514 */     Entity attackerSource = ds.func_76364_f();
/* 515 */     Iterator<DamageEntity> i$ = list.iterator();
/*     */     
/* 517 */     while (i$.hasNext()) {
/* 518 */       DamageEntity de = i$.next();
/* 519 */       if (de.name.isEmpty() || (attacker != null && attacker.getClass().toString().indexOf(de.name) > 0) || (attackerSource != null && attackerSource.getClass().toString().indexOf(de.name) > 0)) {
/* 520 */         damage = (float)(damage * de.factor);
/*     */       }
/*     */     } 
/*     */     
/* 524 */     return damage;
/*     */   }
/*     */   public static float applyDamageVsEntity(Entity target, DamageSource ds, float damage) {
/*     */     List list;
/* 528 */     if (target == null) {
/* 529 */       return damage;
/*     */     }
/* 531 */     String targetName = target.getClass().toString();
/*     */     
/* 533 */     if (!(target instanceof mcheli.helicopter.MCH_EntityHeli) && !(target instanceof mcheli.plane.MCP_EntityPlane)) {
/* 534 */       if (target instanceof mcheli.tank.MCH_EntityTank) {
/* 535 */         list = DamageVsMCHeliTank.list;
/* 536 */       } else if (target instanceof mcheli.vehicle.MCH_EntityVehicle) {
/* 537 */         list = DamageVsMCHeliVehicle.list;
/* 538 */       } else if (targetName.indexOf("mcheli.") > 0) {
/* 539 */         list = DamageVsMCHeliOther.list;
/* 540 */       } else if (target instanceof net.minecraft.entity.player.EntityPlayer) {
/* 541 */         list = DamageVsPlayer.list;
/* 542 */       } else if (target instanceof net.minecraft.entity.EntityLivingBase) {
/* 543 */         list = DamageVsLiving.list;
/*     */       } else {
/* 545 */         list = DamageVsEntity.list;
/*     */       } 
/*     */     } else {
/* 548 */       list = DamageVsMCHeliAircraft.list;
/*     */     } 
/*     */     
/* 551 */     Iterator<DamageEntity> i$ = list.iterator();
/*     */     
/* 553 */     while (i$.hasNext()) {
/* 554 */       DamageEntity de = i$.next();
/* 555 */       if (de.name.isEmpty() || targetName.indexOf(de.name) > 0) {
/* 556 */         damage = (float)(damage * de.factor);
/*     */       }
/*     */     } 
/*     */     
/* 560 */     return damage;
/*     */   }
/*     */ 
/*     */   
/*     */   public static List getBreakableBlockListFromType(int n) {
/* 565 */     return (n == 2) ? tankBreakableBlocks : ((n == 1) ? carBreakableBlocks : dummyBreakableBlocks);
/*     */   }
/*     */   
/*     */   public static List getNoBreakableBlockListFromType(int n) {
/* 569 */     return (n == 2) ? tankNoBreakableBlocks : ((n == 1) ? carNoBreakableBlocks : dummyBreakableBlocks);
/*     */   }
/*     */   
/*     */   public static List getBreakableMaterialListFromType(int n) {
/* 573 */     return (n == 2) ? tankBreakableMaterials : ((n == 1) ? carBreakableMaterials : dummyBreakableMaterials);
/*     */   }
/*     */   
/*     */   public int toInt255(String s) {
/* 577 */     int a = Integer.valueOf(s).intValue();
/* 578 */     return (a < 0) ? 0 : ((a > 255) ? 255 : a);
/*     */   }
/*     */   
/*     */   public void load() {
/* 582 */     MCH_InputFile file = new MCH_InputFile();
/* 583 */     if (file.open(configFilePath)) {
/* 584 */       for (String str = file.readLine(); str != null; str = file.readLine()) {
/* 585 */         if (str.trim().equalsIgnoreCase("McHeliOutputDebugLog")) {
/* 586 */           DebugLog = true;
/*     */         } else {
/* 588 */           readConfigData(str);
/*     */         } 
/*     */       } 
/*     */       
/* 592 */       file.close();
/* 593 */       MCH_Lib.Log("loaded " + file.file.getAbsolutePath(), new Object[0]);
/*     */     } else {
/* 595 */       MCH_Lib.Log("" + (new File(configFilePath)).getAbsolutePath() + " not found.", new Object[0]);
/*     */     } 
/*     */     
/* 598 */     correctionParameter();
/*     */   }
/*     */   
/*     */   private void readConfigData(String str) {
/* 602 */     String[] s = str.split("=");
/* 603 */     if (s.length == 2) {
/* 604 */       s[0] = s[0].trim();
/* 605 */       s[1] = s[1].trim();
/* 606 */       if (s[0].equalsIgnoreCase("MOD_Version")) {
/* 607 */         configVer = s[1];
/*     */       } else {
/* 609 */         if (s[0].equalsIgnoreCase("CommandPermission")) {
/* 610 */           CommandPermission.add(new MCH_ConfigPrm("CommandPermission", s[1]));
/*     */         }
/*     */         
/* 613 */         DamageFactor[] arr$ = DamageFactorList;
/* 614 */         int len$ = arr$.length;
/*     */         
/*     */         int i$;
/* 617 */         for (i$ = 0; i$ < len$; i$++) {
/* 618 */           DamageFactor p = arr$[i$];
/* 619 */           if (p.itemName.equalsIgnoreCase(s[0])) {
/* 620 */             DamageVs.add(new MCH_ConfigPrm(p.itemName, s[1]));
/*     */           }
/*     */         } 
/*     */         
/* 624 */         if (IgnoreBulletHitItem.compare(s[0])) {
/* 625 */           IgnoreBulletHitList.add(s[1]);
/*     */         }
/*     */         
/* 628 */         MCH_ConfigPrm[] var7 = KeyConfig;
/* 629 */         len$ = var7.length;
/*     */ 
/*     */         
/* 632 */         for (i$ = 0; i$ < len$; i$++) {
/* 633 */           MCH_ConfigPrm var8 = var7[i$];
/* 634 */           if (var8 != null && var8.compare(s[0]) && var8.isValidVer(configVer)) {
/* 635 */             var8.setPrm(s[1]);
/*     */             
/*     */             return;
/*     */           } 
/*     */         } 
/* 640 */         var7 = General;
/* 641 */         len$ = var7.length;
/*     */         
/* 643 */         for (i$ = 0; i$ < len$; i$++) {
/* 644 */           MCH_ConfigPrm var8 = var7[i$];
/* 645 */           if (var8 != null && var8.compare(s[0]) && var8.isValidVer(configVer)) {
/* 646 */             var8.setPrm(s[1]);
/*     */             return;
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void write() {
/* 656 */     MCH_OutputFile file = new MCH_OutputFile();
/* 657 */     if (file.open(configFilePath)) {
/* 658 */       writeConfigData(file.pw);
/* 659 */       file.close();
/* 660 */       MCH_Lib.Log("update " + file.file.getAbsolutePath(), new Object[0]);
/*     */     } else {
/* 662 */       MCH_Lib.Log("" + (new File(configFilePath)).getAbsolutePath() + " cannot open.", new Object[0]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private void writeConfigData(PrintWriter pw) {
/* 668 */     pw.println("[General]");
/* 669 */     pw.println("MOD_Name = mcheli");
/* 670 */     pw.println("MOD_Version = " + MCH_MOD.VER);
/* 671 */     pw.println("MOD_MC_Version = 1.7.10");
/* 672 */     pw.println();
/* 673 */     if (DebugLog) {
/* 674 */       pw.println("McHeliOutputDebugLog");
/* 675 */       pw.println();
/*     */     } 
/*     */     
/* 678 */     MCH_ConfigPrm[] arr$ = General;
/* 679 */     int len$ = arr$.length;
/*     */     
/*     */     int i$;
/*     */     
/* 683 */     for (i$ = 0; i$ < len$; i$++) {
/* 684 */       MCH_ConfigPrm p = arr$[i$];
/* 685 */       if (p != null) {
/* 686 */         if (!p.desc.isEmpty()) {
/* 687 */           pw.println(p.desc);
/*     */         }
/*     */         
/* 690 */         pw.println(p.name + " = " + p);
/*     */       } else {
/* 692 */         pw.println("");
/*     */       } 
/*     */     } 
/*     */     
/* 696 */     pw.println();
/* 697 */     Iterator<MCH_ConfigPrm> var6 = DamageVs.iterator();
/*     */ 
/*     */     
/* 700 */     while (var6.hasNext()) {
/* 701 */       MCH_ConfigPrm var7 = var6.next();
/* 702 */       pw.println(var7.name + " = " + var7);
/*     */     } 
/*     */     
/* 705 */     pw.println();
/* 706 */     var6 = IgnoreBulletHitList.iterator();
/*     */     
/* 708 */     while (var6.hasNext()) {
/* 709 */       String var8 = (String)var6.next();
/* 710 */       pw.println(IgnoreBulletHitItem.name + " = " + var8);
/*     */     } 
/*     */     
/* 713 */     pw.println();
/* 714 */     pw.println(";CommandPermission = commandName(eg, modlist, status, fill...):playerName1, playerName2, playerName3...");
/* 715 */     if (CommandPermission.size() == 0) {
/* 716 */       pw.println(";CommandPermission = modlist :example1, example2");
/* 717 */       pw.println(";CommandPermission = status :  example2");
/*     */     } 
/*     */     
/* 720 */     var6 = CommandPermission.iterator();
/*     */     
/* 722 */     while (var6.hasNext()) {
/* 723 */       MCH_ConfigPrm var7 = var6.next();
/* 724 */       pw.println(var7.name + " = " + var7);
/*     */     } 
/*     */     
/* 727 */     pw.println();
/* 728 */     pw.println();
/* 729 */     pw.println("[Key config]");
/* 730 */     pw.println("http://minecraft.gamepedia.com/Key_codes");
/* 731 */     pw.println();
/* 732 */     arr$ = KeyConfig;
/* 733 */     len$ = arr$.length;
/*     */     
/* 735 */     for (i$ = 0; i$ < len$; i$++) {
/* 736 */       MCH_ConfigPrm p = arr$[i$];
/* 737 */       pw.println(p.name + " = " + p);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   class DamageFactor
/*     */   {
/*     */     public final String itemName;
/*     */     
/*     */     public List list;
/*     */ 
/*     */     
/*     */     public DamageFactor(String itemName) {
/* 750 */       this.itemName = itemName;
/* 751 */       this.list = new ArrayList();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   class DamageEntity
/*     */   {
/*     */     public final double factor;
/*     */     public final String name;
/*     */     
/*     */     public DamageEntity(double factor, String name) {
/* 762 */       this.factor = factor;
/* 763 */       this.name = name;
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public class CommandPermission
/*     */   {
/*     */     public final String name;
/*     */     public final String[] players;
/*     */     
/*     */     public CommandPermission(String param) {
/* 774 */       String[] s = param.split(":");
/* 775 */       if (s.length == 2) {
/* 776 */         this.name = s[0].toLowerCase().trim();
/* 777 */         this.players = s[1].trim().split("\\s*,\\s*");
/*     */       } else {
/* 779 */         this.name = "";
/* 780 */         this.players = new String[0];
/*     */       } 
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_Config.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */