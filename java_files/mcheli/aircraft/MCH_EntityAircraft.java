/*      */ package mcheli.aircraft;
/*      */ import com.google.common.collect.UnmodifiableIterator;
/*      */ import cpw.mods.fml.relauncher.Side;
/*      */ import cpw.mods.fml.relauncher.SideOnly;
/*      */ import io.netty.buffer.ByteBuf;
/*      */ import java.util.ArrayList;
/*      */ import java.util.Arrays;
/*      */ import java.util.HashMap;
/*      */ import java.util.Iterator;
/*      */ import java.util.List;
/*      */ import mcheli.MCH_Camera;
/*      */ import mcheli.MCH_Config;
/*      */ import mcheli.MCH_Explosion;
/*      */ import mcheli.MCH_Lib;
/*      */ import mcheli.MCH_LowPassFilterFloat;
/*      */ import mcheli.MCH_MOD;
/*      */ import mcheli.MCH_Math;
/*      */ import mcheli.MCH_Queue;
/*      */ import mcheli.MCH_ViewEntityDummy;
/*      */ import mcheli.flare.MCH_Flare;
/*      */ import mcheli.multiplay.MCH_Multiplay;
/*      */ import mcheli.parachute.MCH_EntityParachute;
/*      */ import mcheli.particles.MCH_ParticleParam;
/*      */ import mcheli.particles.MCH_ParticlesUtil;
/*      */ import mcheli.uav.MCH_EntityUavStation;
/*      */ import mcheli.weapon.MCH_EntityTvMissile;
/*      */ import mcheli.weapon.MCH_WeaponBase;
/*      */ import mcheli.weapon.MCH_WeaponInfo;
/*      */ import mcheli.weapon.MCH_WeaponParam;
/*      */ import mcheli.weapon.MCH_WeaponSet;
/*      */ import mcheli.wrapper.W_Block;
/*      */ import mcheli.wrapper.W_Entity;
/*      */ import mcheli.wrapper.W_EntityContainer;
/*      */ import mcheli.wrapper.W_Item;
/*      */ import mcheli.wrapper.W_Lib;
/*      */ import mcheli.wrapper.W_NBTTag;
/*      */ import mcheli.wrapper.W_WorldFunc;
/*      */ import net.minecraft.block.Block;
/*      */ import net.minecraft.crash.CrashReport;
/*      */ import net.minecraft.crash.CrashReportCategory;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.entity.item.EntityItem;
/*      */ import net.minecraft.entity.player.EntityPlayer;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.item.Item;
/*      */ import net.minecraft.item.ItemStack;
/*      */ import net.minecraft.nbt.NBTBase;
/*      */ import net.minecraft.nbt.NBTTagCompound;
/*      */ import net.minecraft.potion.Potion;
/*      */ import net.minecraft.potion.PotionEffect;
/*      */ import net.minecraft.util.AxisAlignedBB;
/*      */ import net.minecraft.util.DamageSource;
/*      */ import net.minecraft.util.EnumChatFormatting;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.Vec3;
/*      */ import net.minecraft.world.ChunkCoordIntPair;
/*      */ import net.minecraft.world.World;
/*      */ import net.minecraft.world.WorldServer;
/*      */ import net.minecraftforge.common.ForgeChunkManager;
/*      */ 
/*      */ public abstract class MCH_EntityAircraft extends W_EntityContainer implements MCH_IEntityLockChecker, MCH_IEntityCanRideAircraft, IEntityAdditionalSpawnData {
/*      */   private static final int DATAWT_ID_DAMAGE = 19;
/*      */   private static final int DATAWT_ID_TYPE = 20;
/*      */   private static final int DATAWT_ID_TEXTURE_NAME = 21;
/*      */   private static final int DATAWT_ID_UAV_STATION = 22;
/*      */   private static final int DATAWT_ID_STATUS = 23;
/*      */   private static final int CMN_ID_FLARE = 0;
/*      */   private static final int CMN_ID_FREE_LOOK = 1;
/*      */   private static final int CMN_ID_RELOADING = 2;
/*      */   private static final int CMN_ID_INGINITY_AMMO = 3;
/*      */   private static final int CMN_ID_INGINITY_FUEL = 4;
/*      */   private static final int CMN_ID_RAPELLING = 5;
/*      */   private static final int CMN_ID_SEARCHLIGHT = 6;
/*      */   private static final int CMN_ID_CNTRL_LEFT = 7;
/*      */   private static final int CMN_ID_CNTRL_RIGHT = 8;
/*      */   private static final int CMN_ID_CNTRL_UP = 9;
/*      */   private static final int CMN_ID_CNTRL_DOWN = 10;
/*   79 */   public float turretOffX = 0.0F; private static final int CMN_ID_CNTRL_BRAKE = 11; private static final int DATAWT_ID_USE_WEAPON = 24; private static final int DATAWT_ID_FUEL = 25; private static final int DATAWT_ID_ROT_ROLL = 26; private static final int DATAWT_ID_COMMAND = 27; private static final int DATAWT_ID_THROTTLE = 29; protected static final int DATAWT_ID_FOLD_STAT = 30; protected static final int DATAWT_ID_PART_STAT = 31; protected static final int PART_ID_CANOPY = 0; protected static final int PART_ID_NOZZLE = 1; protected static final int PART_ID_LANDINGGEAR = 2; protected static final int PART_ID_WING = 3; protected static final int PART_ID_HATCH = 4; public static final byte LIMIT_GROUND_PITCH = 40; public static final byte LIMIT_GROUND_ROLL = 40; public boolean isRequestedSyncStatus = false;
/*   80 */   public float turretOffY = 0.0F;
/*   81 */   public float turretOffZ = 0.0F;
/*      */   private MCH_AircraftInfo acInfo;
/*      */   private int commonStatus;
/*      */   private Entity[] partEntities;
/*      */   private MCH_EntityHitBox pilotSeat;
/*      */   private MCH_EntitySeat[] seats;
/*      */   private MCH_SeatInfo[] seatsInfo;
/*      */   private String commonUniqueId;
/*      */   private int seatSearchCount;
/*      */   protected double velocityX;
/*      */   protected double velocityY;
/*      */   protected double velocityZ;
/*      */   public boolean keepOnRideRotation;
/*      */   protected int aircraftPosRotInc;
/*      */   protected double aircraftX;
/*      */   protected double aircraftY;
/*      */   protected double aircraftZ;
/*      */   protected double aircraftYaw;
/*      */   protected double aircraftPitch;
/*      */   public boolean aircraftRollRev;
/*      */   public boolean aircraftRotChanged;
/*      */   public float rotationRoll;
/*      */   public float prevRotationRoll;
/*      */   private double currentThrottle;
/*      */   private double prevCurrentThrottle;
/*      */   public double currentSpeed;
/*      */   public int currentFuel;
/*  108 */   public float throttleBack = 0.0F;
/*      */   public double beforeHoverThrottle;
/*  110 */   public int waitMountEntity = 0;
/*      */   public boolean throttleUp = false;
/*      */   public boolean throttleDown = false;
/*      */   public boolean moveLeft = false;
/*      */   public boolean moveRight = false;
/*      */   public MCH_LowPassFilterFloat lowPassPartialTicks;
/*      */   private MCH_Radar entityRadar;
/*      */   private int radarRotate;
/*      */   private MCH_Flare flareDv;
/*      */   private int currentFlareIndex;
/*      */   protected MCH_WeaponSet[] weapons;
/*      */   protected int[] currentWeaponID;
/*      */   public float lastRiderYaw;
/*      */   public float prevLastRiderYaw;
/*      */   public float lastRiderPitch;
/*      */   public float prevLastRiderPitch;
/*      */   protected MCH_WeaponSet dummyWeapon;
/*      */   protected int useWeaponStat;
/*      */   protected int hitStatus;
/*      */   protected final MCH_SoundUpdater soundUpdater;
/*      */   protected Entity lastRiddenByEntity;
/*      */   protected Entity lastRidingEntity;
/*  132 */   public List listUnmountReserve = new ArrayList();
/*      */   private int countOnUpdate;
/*      */   public MCH_Camera camera;
/*      */   private int cameraId;
/*      */   protected boolean isGunnerMode = false;
/*      */   protected boolean isGunnerModeOtherSeat = false;
/*      */   private boolean isHoveringMode = false;
/*      */   public static final int CAMERA_PITCH_MIN = -30;
/*      */   public static final int CAMERA_PITCH_MAX = 70;
/*      */   private MCH_EntityTvMissile TVmissile;
/*      */   protected boolean isGunnerFreeLookMode = false;
/*      */   public final MCH_MissileDetector missileDetector;
/*  144 */   public int serverNoMoveCount = 0;
/*      */   public int repairCount;
/*      */   public int beforeDamageTaken;
/*      */   public int timeSinceHit;
/*      */   private int despawnCount;
/*      */   public float rotDestroyedYaw;
/*      */   public float rotDestroyedPitch;
/*      */   public float rotDestroyedRoll;
/*      */   public int damageSinceDestroyed;
/*      */   public boolean isFirstDamageSmoke = true;
/*  154 */   public Vec3[] prevDamageSmokePos = new Vec3[0];
/*      */   private MCH_EntityUavStation uavStation;
/*      */   public boolean cs_dismountAll;
/*      */   public boolean cs_heliAutoThrottleDown;
/*      */   public boolean cs_planeAutoThrottleDown;
/*      */   public boolean cs_tankAutoThrottleDown;
/*      */   public MCH_Parts partHatch;
/*      */   public MCH_Parts partCanopy;
/*      */   public MCH_Parts partLandingGear;
/*      */   public double prevRidingEntityPosX;
/*      */   public double prevRidingEntityPosY;
/*      */   public double prevRidingEntityPosZ;
/*      */   public boolean canRideRackStatus;
/*      */   private int modeSwitchCooldown;
/*      */   public MCH_BoundingBox[] extraBoundingBox;
/*      */   public float lastBBDamageFactor;
/*      */   private final MCH_AircraftInventory inventory;
/*      */   private double fuelConsumption;
/*      */   private int fuelSuppliedCount;
/*      */   private int supplyAmmoWait;
/*      */   private boolean beforeSupplyAmmo;
/*      */   public WeaponBay[] weaponBays;
/*      */   public float[] rotPartRotation;
/*      */   public float[] prevRotPartRotation;
/*  178 */   public float[] rotCrawlerTrack = new float[2];
/*  179 */   public float[] prevRotCrawlerTrack = new float[2];
/*  180 */   public float[] throttleCrawlerTrack = new float[2];
/*  181 */   public float[] rotTrackRoller = new float[2];
/*  182 */   public float[] prevRotTrackRoller = new float[2];
/*  183 */   public float rotWheel = 0.0F;
/*  184 */   public float prevRotWheel = 0.0F;
/*  185 */   public float rotYawWheel = 0.0F;
/*  186 */   public float prevRotYawWheel = 0.0F;
/*      */   private boolean isParachuting;
/*  188 */   public float ropesLength = 0.0F;
/*      */   private MCH_Queue prevPosition;
/*      */   private int tickRepelling;
/*      */   private int lastUsedRopeIndex;
/*      */   private boolean dismountedUserCtrl;
/*      */   public float lastSearchLightYaw;
/*      */   public float lastSearchLightPitch;
/*  195 */   public float rotLightHatch = 0.0F;
/*  196 */   public float prevRotLightHatch = 0.0F;
/*  197 */   public int recoilCount = 0;
/*  198 */   public float recoilYaw = 0.0F;
/*  199 */   public float recoilValue = 0.0F;
/*  200 */   public int brightnessHigh = 240;
/*  201 */   public int brightnessLow = 240;
/*  202 */   public final HashMap noCollisionEntities = new HashMap<>();
/*      */   private double lastCalcLandInDistanceCount;
/*      */   private double lastLandInDistance;
/*  205 */   private static final MCH_EntitySeat[] seatsDummy = new MCH_EntitySeat[0];
/*      */   private boolean switchSeat = false;
/*      */   public ForgeChunkManager.Ticket chunkLoadingTicket;
/*      */   
/*      */   public MCH_EntityAircraft(World world) {
/*  210 */     super(world);
/*  211 */     this.soundUpdater = MCH_MOD.proxy.CreateSoundUpdater(this);
/*  212 */     setAcInfo((MCH_AircraftInfo)null);
/*  213 */     this.commonStatus = 0;
/*  214 */     this.dropContentsWhenDead = false;
/*  215 */     this.field_70158_ak = true;
/*  216 */     this.flareDv = new MCH_Flare(world, this);
/*  217 */     this.currentFlareIndex = 0;
/*  218 */     this.entityRadar = new MCH_Radar(world);
/*  219 */     this.radarRotate = 0;
/*  220 */     this.currentWeaponID = new int[0];
/*  221 */     this.aircraftPosRotInc = 0;
/*  222 */     this.aircraftX = 0.0D;
/*  223 */     this.aircraftY = 0.0D;
/*  224 */     this.aircraftZ = 0.0D;
/*  225 */     this.aircraftYaw = 0.0D;
/*  226 */     this.aircraftPitch = 0.0D;
/*  227 */     this.currentSpeed = 0.0D;
/*  228 */     setCurrentThrottle(0.0D);
/*  229 */     this.currentFuel = 0;
/*  230 */     this.cs_dismountAll = false;
/*  231 */     this.cs_heliAutoThrottleDown = true;
/*  232 */     this.cs_planeAutoThrottleDown = false;
/*  233 */     MCH_Config var10001 = MCH_MOD.config;
/*  234 */     this.field_70155_l = MCH_Config.RenderDistanceWeight.prmDouble;
/*  235 */     setCommonUniqueId("");
/*  236 */     this.seatSearchCount = 0;
/*  237 */     this.seatsInfo = null;
/*  238 */     this.seats = new MCH_EntitySeat[0];
/*  239 */     this.pilotSeat = new MCH_EntityHitBox(world, this, 1.0F, 1.0F);
/*  240 */     this.pilotSeat.parent = this;
/*  241 */     this.partEntities = new Entity[] { (Entity)this.pilotSeat };
/*  242 */     setTextureName("");
/*  243 */     this.camera = new MCH_Camera(world, (Entity)this, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*  244 */     setCameraId(0);
/*  245 */     this.lastRiddenByEntity = null;
/*  246 */     this.lastRidingEntity = null;
/*      */     
/*  248 */     this.countOnUpdate = 0;
/*  249 */     this.dummyWeapon = new MCH_WeaponSet((MCH_WeaponBase)new MCH_WeaponDummy(this.field_70170_p, Vec3.func_72443_a(0.0D, 0.0D, 0.0D), 0.0F, 0.0F, "", (MCH_WeaponInfo)null));
/*  250 */     this.useWeaponStat = 0;
/*  251 */     this.hitStatus = 0;
/*  252 */     this.repairCount = 0;
/*  253 */     this.beforeDamageTaken = 0;
/*  254 */     this.timeSinceHit = 0;
/*  255 */     setDespawnCount(0);
/*  256 */     this.missileDetector = new MCH_MissileDetector(this, world);
/*  257 */     this.uavStation = null;
/*  258 */     this.modeSwitchCooldown = 0;
/*  259 */     this.partHatch = null;
/*  260 */     this.partCanopy = null;
/*  261 */     this.partLandingGear = null;
/*  262 */     this.weaponBays = new WeaponBay[0];
/*  263 */     this.rotPartRotation = new float[0];
/*  264 */     this.prevRotPartRotation = new float[0];
/*  265 */     this.lastRiderYaw = 0.0F;
/*  266 */     this.prevLastRiderYaw = 0.0F;
/*  267 */     this.lastRiderPitch = 0.0F;
/*  268 */     this.prevLastRiderPitch = 0.0F;
/*  269 */     this.rotationRoll = 0.0F;
/*  270 */     this.prevRotationRoll = 0.0F;
/*  271 */     this.lowPassPartialTicks = new MCH_LowPassFilterFloat(10);
/*  272 */     this.extraBoundingBox = new MCH_BoundingBox[0];
/*  273 */     W_Reflection.setBoundingBox((Entity)this, new MCH_AircraftBoundingBox(this));
/*  274 */     this.lastBBDamageFactor = 1.0F;
/*  275 */     this.inventory = new MCH_AircraftInventory(this);
/*  276 */     this.fuelConsumption = 0.0D;
/*  277 */     this.fuelSuppliedCount = 0;
/*  278 */     this.canRideRackStatus = false;
/*  279 */     this.isParachuting = false;
/*  280 */     this.prevPosition = new MCH_Queue(10, Vec3.func_72443_a(0.0D, 0.0D, 0.0D));
/*  281 */     this.lastSearchLightYaw = this.lastSearchLightPitch = 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void func_70088_a() {
/*  287 */     super.func_70088_a();
/*  288 */     func_70096_w().func_75682_a(20, "");
/*  289 */     func_70096_w().func_75682_a(19, new Integer(0));
/*  290 */     func_70096_w().func_75682_a(23, new Integer(0));
/*  291 */     func_70096_w().func_75682_a(24, new Integer(0));
/*  292 */     func_70096_w().func_75682_a(25, new Integer(0));
/*  293 */     func_70096_w().func_75682_a(21, "");
/*  294 */     func_70096_w().func_75682_a(22, new Integer(0));
/*  295 */     func_70096_w().func_75682_a(26, new Short((short)0));
/*  296 */     func_70096_w().func_75682_a(27, new String(""));
/*  297 */     func_70096_w().func_75682_a(29, new Integer(0));
/*  298 */     func_70096_w().func_75682_a(31, new Integer(0));
/*  299 */     if (!this.field_70170_p.field_72995_K) {
/*  300 */       MCH_Config var10002 = MCH_MOD.config;
/*  301 */       setCommonStatus(3, MCH_Config.InfinityAmmo.prmBool);
/*  302 */       var10002 = MCH_MOD.config;
/*  303 */       setCommonStatus(4, MCH_Config.InfinityFuel.prmBool);
/*  304 */       setGunnerStatus(true);
/*      */     } 
/*      */     
/*  307 */     getEntityData().func_74778_a("EntityType", getEntityType());
/*      */   }
/*      */   
/*      */   public float getServerRoll() {
/*  311 */     return func_70096_w().func_75693_b(26);
/*      */   }
/*      */   
/*      */   public float getRotYaw() {
/*  315 */     return this.field_70177_z;
/*      */   }
/*      */   
/*      */   public float getRotPitch() {
/*  319 */     return this.field_70125_A;
/*      */   }
/*      */   
/*      */   public float getRotRoll() {
/*  323 */     return this.rotationRoll;
/*      */   }
/*      */   
/*      */   public void setRotYaw(float f) {
/*  327 */     this.field_70177_z = f;
/*      */   }
/*      */   
/*      */   public void setRotPitch(float f) {
/*  331 */     this.field_70125_A = f;
/*      */   }
/*      */   
/*      */   public void setRotPitch(float f, String msg) {
/*  335 */     setRotPitch(f);
/*      */   }
/*      */   
/*      */   public void setRotRoll(float f) {
/*  339 */     this.rotationRoll = f;
/*      */   }
/*      */   
/*      */   public void applyOnGroundPitch(float factor) {
/*  343 */     if (getAcInfo() != null) {
/*  344 */       float ogp = (getAcInfo()).onGroundPitch;
/*  345 */       float pitch = getRotPitch();
/*  346 */       pitch -= ogp;
/*  347 */       pitch *= factor;
/*  348 */       pitch += ogp;
/*  349 */       setRotPitch(pitch, "applyOnGroundPitch");
/*      */     } 
/*      */     
/*  352 */     setRotRoll(getRotRoll() * factor);
/*      */   }
/*      */   
/*      */   public float calcRotYaw(float partialTicks) {
/*  356 */     return this.field_70126_B + (getRotYaw() - this.field_70126_B) * partialTicks;
/*      */   }
/*      */   
/*      */   public float calcRotPitch(float partialTicks) {
/*  360 */     return this.field_70127_C + (getRotPitch() - this.field_70127_C) * partialTicks;
/*      */   }
/*      */   
/*      */   public float calcRotRoll(float partialTicks) {
/*  364 */     return this.prevRotationRoll + (getRotRoll() - this.prevRotationRoll) * partialTicks;
/*      */   }
/*      */   
/*      */   protected void func_70101_b(float y, float p) {
/*  368 */     setRotYaw(y % 360.0F);
/*  369 */     setRotPitch(p % 360.0F);
/*      */   }
/*      */   
/*      */   public boolean isInfinityAmmo(Entity player) {
/*  373 */     return (isCreative(player) || getCommonStatus(3));
/*      */   }
/*      */   
/*      */   public boolean isInfinityFuel(Entity player, boolean checkOtherSeet) {
/*  377 */     if (!isCreative(player) && !getCommonStatus(4)) {
/*  378 */       if (checkOtherSeet) {
/*  379 */         MCH_EntitySeat[] arr$ = getSeats();
/*  380 */         int len$ = arr$.length;
/*      */         
/*  382 */         for (int i$ = 0; i$ < len$; i$++) {
/*  383 */           MCH_EntitySeat seat = arr$[i$];
/*  384 */           if (seat != null && isCreative(seat.field_70153_n)) {
/*  385 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  390 */       return false;
/*      */     } 
/*  392 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void setCommand(String s, EntityPlayer player) {
/*  397 */     if (!this.field_70170_p.field_72995_K && MCH_Command.canUseCommand((Entity)player)) {
/*  398 */       setCommandForce(s);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void setCommandForce(String s) {
/*  404 */     if (!this.field_70170_p.field_72995_K) {
/*  405 */       func_70096_w().func_75692_b(27, s);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCommand() {
/*  411 */     return func_70096_w().func_75681_e(27);
/*      */   }
/*      */   
/*      */   public String getKindName() {
/*  415 */     return "";
/*      */   }
/*      */   
/*      */   public String getEntityType() {
/*  419 */     return "";
/*      */   }
/*      */   
/*      */   public void setTypeName(String s) {
/*  423 */     String beforeType = getTypeName();
/*  424 */     if (s != null && !s.isEmpty() && s.compareTo(beforeType) != 0) {
/*  425 */       func_70096_w().func_75692_b(20, String.valueOf(s));
/*  426 */       changeType(s);
/*  427 */       initRotationYaw(getRotYaw());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String getTypeName() {
/*  433 */     return func_70096_w().func_75681_e(20);
/*      */   }
/*      */   
/*      */   public abstract void changeType(String paramString);
/*      */   
/*      */   public boolean isTargetDrone() {
/*  439 */     return (getAcInfo() != null && (getAcInfo()).isTargetDrone);
/*      */   }
/*      */   
/*      */   public boolean isUAV() {
/*  443 */     return (getAcInfo() != null && (getAcInfo()).isUAV);
/*      */   }
/*      */   
/*      */   public boolean isNewUAV() {
/*  447 */     return (getAcInfo() != null && (getAcInfo()).isNewUAV);
/*      */   }
/*      */   
/*      */   public boolean isSmallUAV() {
/*  451 */     return (getAcInfo() != null && (getAcInfo()).isSmallUAV);
/*      */   }
/*      */   
/*      */   public boolean isAlwaysCameraView() {
/*  455 */     return (getAcInfo() != null && (getAcInfo()).alwaysCameraView);
/*      */   }
/*      */   
/*      */   public void setUavStation(MCH_EntityUavStation uavSt) {
/*  459 */     this.uavStation = uavSt;
/*  460 */     if (!this.field_70170_p.field_72995_K) {
/*  461 */       if (uavSt != null) {
/*  462 */         func_70096_w().func_75692_b(22, Integer.valueOf(W_Entity.getEntityId((Entity)uavSt)));
/*      */       } else {
/*  464 */         func_70096_w().func_75692_b(22, Integer.valueOf(0));
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public float getStealth() {
/*  471 */     return (getAcInfo() != null) ? (getAcInfo()).stealth : 0.0F;
/*      */   }
/*      */   
/*      */   public MCH_AircraftInventory getGuiInventory() {
/*  475 */     return this.inventory;
/*      */   }
/*      */   
/*      */   public void openGui(EntityPlayer player) {
/*  479 */     if (!this.field_70170_p.field_72995_K) {
/*  480 */       player.openGui(MCH_MOD.instance, 1, this.field_70170_p, (int)this.field_70165_t, (int)this.field_70163_u, (int)this.field_70161_v);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public MCH_EntityUavStation getUavStation() {
/*  486 */     return (isUAV() || isNewUAV()) ? this.uavStation : null;
/*      */   }
/*      */   
/*      */   public static MCH_EntityAircraft getAircraft_RiddenOrControl(Entity rider) {
/*  490 */     if (rider != null) {
/*  491 */       if (rider.field_70154_o instanceof MCH_EntityAircraft) {
/*  492 */         return (MCH_EntityAircraft)rider.field_70154_o;
/*      */       }
/*      */       
/*  495 */       if (rider.field_70154_o instanceof MCH_EntitySeat) {
/*  496 */         return ((MCH_EntitySeat)rider.field_70154_o).getParent();
/*      */       }
/*      */       
/*  499 */       if (rider.field_70154_o instanceof MCH_EntityUavStation) {
/*  500 */         MCH_EntityUavStation uavStation = (MCH_EntityUavStation)rider.field_70154_o;
/*  501 */         return uavStation.getControlAircract();
/*      */       } 
/*      */     } 
/*      */     
/*  505 */     return null;
/*      */   }
/*      */   
/*      */   public boolean isCreative(Entity entity) {
/*  509 */     return (entity instanceof EntityPlayer && ((EntityPlayer)entity).field_71075_bZ.field_75098_d);
/*      */   }
/*      */ 
/*      */   
/*      */   public Entity getRiddenByEntity() {
/*  514 */     return (isUAV() && this.uavStation != null) ? this.uavStation.field_70153_n : this.field_70153_n;
/*      */   }
/*      */   
/*      */   public boolean getCommonStatus(int bit) {
/*  518 */     return ((this.commonStatus >> bit & 0x1) != 0);
/*      */   }
/*      */   
/*      */   public void setCommonStatus(int bit, boolean b) {
/*  522 */     setCommonStatus(bit, b, false);
/*      */   }
/*      */   
/*      */   public void setCommonStatus(int bit, boolean b, boolean writeClient) {
/*  526 */     if (!this.field_70170_p.field_72995_K || writeClient) {
/*  527 */       int bofore = this.commonStatus;
/*  528 */       int mask = 1 << bit;
/*  529 */       if (b) {
/*  530 */         this.commonStatus |= mask;
/*      */       } else {
/*  532 */         this.commonStatus &= mask ^ 0xFFFFFFFF;
/*      */       } 
/*      */       
/*  535 */       if (bofore != this.commonStatus) {
/*  536 */         MCH_Lib.DbgLog(this.field_70170_p, "setCommonStatus : %08X -> %08X ", new Object[] { Integer.valueOf(func_70096_w().func_75679_c(23)), Integer.valueOf(this.commonStatus) });
/*  537 */         func_70096_w().func_75692_b(23, Integer.valueOf(this.commonStatus));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public double getThrottle() {
/*  544 */     return 0.05D * func_70096_w().func_75679_c(29);
/*      */   }
/*      */   
/*      */   public void setThrottle(double t) {
/*  548 */     int n = (int)(t * 20.0D);
/*  549 */     if (n == 0 && t > 0.0D) {
/*  550 */       n = 1;
/*      */     }
/*      */     
/*  553 */     func_70096_w().func_75692_b(29, Integer.valueOf(n));
/*      */   }
/*      */   
/*      */   public int getMaxHP() {
/*  557 */     return (getAcInfo() != null) ? (getAcInfo()).maxHp : 100;
/*      */   }
/*      */   
/*      */   public int getHP() {
/*  561 */     return (getMaxHP() - getDamageTaken() >= 0) ? (getMaxHP() - getDamageTaken()) : 0;
/*      */   }
/*      */   
/*      */   public void setDamageTaken(int par1) {
/*  565 */     if (par1 < 0) {
/*  566 */       par1 = 0;
/*      */     }
/*      */     
/*  569 */     if (par1 > getMaxHP()) {
/*  570 */       par1 = getMaxHP();
/*      */     }
/*      */     
/*  573 */     func_70096_w().func_75692_b(19, Integer.valueOf(par1));
/*      */   }
/*      */   
/*      */   public int getDamageTaken() {
/*  577 */     return func_70096_w().func_75679_c(19);
/*      */   }
/*      */   
/*      */   public void destroyAircraft() {
/*  581 */     setSearchLight(false);
/*  582 */     switchHoveringMode(false);
/*  583 */     switchGunnerMode(false);
/*      */     
/*  585 */     for (int entity = 0; entity < getSeatNum() + 1; entity++) {
/*  586 */       Entity e = getEntityBySeatId(entity);
/*  587 */       if (e instanceof EntityPlayer) {
/*  588 */         switchCameraMode((EntityPlayer)e, 0);
/*      */       }
/*      */     } 
/*      */     
/*  592 */     if (isTargetDrone()) {
/*  593 */       setDespawnCount(50);
/*      */     } else {
/*  595 */       setDespawnCount(500);
/*      */     } 
/*      */     
/*  598 */     this.rotDestroyedPitch = this.field_70146_Z.nextFloat() - 0.5F;
/*  599 */     this.rotDestroyedRoll = (this.field_70146_Z.nextFloat() - 0.5F) * 0.5F;
/*  600 */     this.rotDestroyedYaw = 0.0F;
/*  601 */     if (getRiddenByEntity() != null) {
/*  602 */       if (isUAV()) {
/*  603 */         getRiddenByEntity().func_70078_a((Entity)null);
/*  604 */       } else if (isNewUAV()) {
/*  605 */         if (getRiddenByEntity() instanceof EntityPlayer) {
/*  606 */           ((EntityPlayer)getRiddenByEntity()).func_145747_a((IChatComponent)new ChatComponentText(EnumChatFormatting.RED + "Drone destroyed!"));
/*  607 */           ((EntityPlayer)getRiddenByEntity()).func_70690_d(new PotionEffect(11, 20, 50));
/*      */         } 
/*  609 */         getRiddenByEntity().func_70078_a((Entity)getUavStation());
/*      */       } 
/*      */     }
/*      */     
/*  613 */     if (!this.field_70170_p.field_72995_K) {
/*  614 */       ejectSeat(getRiddenByEntity());
/*  615 */       Entity var3 = getEntityBySeatId(1);
/*  616 */       if (var3 != null) {
/*  617 */         ejectSeat(var3);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isDestroyed() {
/*  624 */     return (getDespawnCount() > 0);
/*      */   }
/*      */   
/*      */   public int getDespawnCount() {
/*  628 */     return this.despawnCount;
/*      */   }
/*      */   
/*      */   public void setDespawnCount(int despawnCount) {
/*  632 */     this.despawnCount = despawnCount;
/*      */   }
/*      */   
/*      */   public boolean isEntityRadarMounted() {
/*  636 */     return (getAcInfo() != null) ? (getAcInfo()).isEnableEntityRadar : false;
/*      */   }
/*      */   
/*      */   public boolean canFloatWater() {
/*  640 */     return (getAcInfo() != null && (getAcInfo()).isFloat && !isDestroyed());
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public int func_70070_b(float par1) {
/*  645 */     if (haveSearchLight() && isSearchLightON()) {
/*  646 */       return 15728880;
/*      */     }
/*  648 */     int i = MathHelper.func_76128_c(this.field_70165_t);
/*  649 */     int j = MathHelper.func_76128_c(this.field_70161_v);
/*  650 */     if (this.field_70170_p.func_72899_e(i, 0, j)) {
/*  651 */       double d0 = (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 0.66D;
/*  652 */       float fo = (getAcInfo() != null) ? (getAcInfo()).submergedDamageHeight : 0.0F;
/*  653 */       if (canFloatWater()) {
/*  654 */         fo = (getAcInfo()).floatOffset;
/*  655 */         if (fo < 0.0F) {
/*  656 */           fo = -fo;
/*      */         }
/*      */         
/*  659 */         fo++;
/*      */       } 
/*      */       
/*  662 */       int k = MathHelper.func_76128_c(this.field_70163_u + fo - this.field_70129_M + d0);
/*  663 */       int val = this.field_70170_p.func_72802_i(i, k, j, 0);
/*  664 */       int low = val & 0xFFFF;
/*  665 */       int high = val >> 16 & 0xFFFF;
/*  666 */       if (high < this.brightnessHigh) {
/*  667 */         if (this.brightnessHigh > 0 && getCountOnUpdate() % 2 == 0) {
/*  668 */           this.brightnessHigh--;
/*      */         }
/*  670 */       } else if (high > this.brightnessHigh) {
/*  671 */         this.brightnessHigh += 4;
/*  672 */         if (this.brightnessHigh > 240) {
/*  673 */           this.brightnessHigh = 240;
/*      */         }
/*      */       } 
/*      */       
/*  677 */       return this.brightnessHigh << 16 | low;
/*      */     } 
/*  679 */     return 0;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public MCH_AircraftInfo.CameraPosition getCameraPosInfo() {
/*  685 */     if (getAcInfo() == null) {
/*  686 */       return null;
/*      */     }
/*  688 */     Entity player = MCH_Lib.getClientPlayer();
/*  689 */     int sid = getSeatIdByEntity(player);
/*  690 */     return (sid == 0 && canSwitchCameraPos() && getCameraId() > 0 && getCameraId() < (getAcInfo()).cameraPosition.size()) ? (getAcInfo()).cameraPosition.get(getCameraId()) : ((sid > 0 && sid < (getSeatsInfo()).length && (getSeatsInfo()[sid]).invCamPos) ? getSeatsInfo()[sid].getCamPos() : (getAcInfo()).cameraPosition.get(0));
/*      */   }
/*      */ 
/*      */   
/*      */   public int getCameraId() {
/*  695 */     return this.cameraId;
/*      */   }
/*      */   
/*      */   public void setCameraId(int cameraId) {
/*  699 */     MCH_Lib.DbgLog(true, "MCH_EntityAircraft.setCameraId %d -> %d", new Object[] { Integer.valueOf(this.cameraId), Integer.valueOf(cameraId) });
/*  700 */     this.cameraId = cameraId;
/*      */   }
/*      */   
/*      */   public boolean canSwitchCameraPos() {
/*  704 */     return (getCameraPosNum() >= 2);
/*      */   }
/*      */   
/*      */   public int getCameraPosNum() {
/*  708 */     return (getAcInfo() != null) ? (getAcInfo()).cameraPosition.size() : 1;
/*      */   }
/*      */   
/*      */   public void onAcInfoReloaded() {
/*  712 */     if (getAcInfo() != null) {
/*  713 */       func_70105_a((getAcInfo()).bodyWidth, (getAcInfo()).bodyHeight);
/*      */     }
/*      */   }
/*      */   
/*      */   public void writeSpawnData(ByteBuf buffer) {
/*  718 */     if (getAcInfo() != null) {
/*  719 */       buffer.writeFloat((getAcInfo()).bodyHeight);
/*  720 */       buffer.writeFloat(2.0F);
/*      */     } else {
/*  722 */       buffer.writeFloat(this.field_70131_O);
/*  723 */       buffer.writeFloat(this.field_70130_N);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void readSpawnData(ByteBuf additionalData) {
/*      */     try {
/*  730 */       float e = additionalData.readFloat();
/*  731 */       float width = additionalData.readFloat();
/*  732 */       func_70105_a(width, e);
/*  733 */     } catch (Exception var4) {
/*  734 */       MCH_Lib.Log((Entity)this, "readSpawnData error!", new Object[0]);
/*  735 */       var4.printStackTrace();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70037_a(NBTTagCompound nbt) {
/*  741 */     setDespawnCount(nbt.func_74762_e("AcDespawnCount"));
/*  742 */     setTextureName(nbt.func_74779_i("TextureName"));
/*  743 */     setCommonUniqueId(nbt.func_74779_i("AircraftUniqueId"));
/*  744 */     setRotRoll(nbt.func_74760_g("AcRoll"));
/*  745 */     this.prevRotationRoll = getRotRoll();
/*  746 */     this.prevLastRiderYaw = this.lastRiderYaw = nbt.func_74760_g("AcLastRYaw");
/*  747 */     this.prevLastRiderPitch = this.lastRiderPitch = nbt.func_74760_g("AcLastRPitch");
/*  748 */     setPartStatus(nbt.func_74762_e("PartStatus"));
/*  749 */     setTypeName(nbt.func_74779_i("TypeName"));
/*  750 */     super.func_70037_a(nbt);
/*  751 */     getGuiInventory().readEntityFromNBT(nbt);
/*  752 */     setCommandForce(nbt.func_74779_i("AcCommand"));
/*  753 */     setFuel(nbt.func_74762_e("AcFuel"));
/*  754 */     setGunnerStatus(nbt.func_74767_n("AcGunnerStatus"));
/*  755 */     int[] wa_list = nbt.func_74759_k("AcWeaponsAmmo");
/*      */     
/*  757 */     for (int i = 0; i < wa_list.length; i++) {
/*  758 */       getWeapon(i).setRestAllAmmoNum(wa_list[i]);
/*  759 */       getWeapon(i).reloadMag();
/*      */     } 
/*      */     
/*  762 */     if (getDespawnCount() > 0) {
/*  763 */       setDamageTaken(getMaxHP());
/*  764 */     } else if (nbt.func_74764_b("AcDamage")) {
/*  765 */       setDamageTaken(nbt.func_74762_e("AcDamage"));
/*      */     } 
/*      */     
/*  768 */     if (haveSearchLight() && nbt.func_74764_b("SearchLight")) {
/*  769 */       setSearchLight(nbt.func_74767_n("SearchLight"));
/*      */     }
/*      */     
/*  772 */     this.dismountedUserCtrl = nbt.func_74767_n("AcDismounted");
/*      */   }
/*      */ 
/*      */   
/*      */   protected void func_70014_b(NBTTagCompound nbt) {
/*  777 */     nbt.func_74778_a("TextureName", getTextureName());
/*  778 */     nbt.func_74778_a("AircraftUniqueId", getCommonUniqueId());
/*  779 */     nbt.func_74778_a("TypeName", getTypeName());
/*  780 */     nbt.func_74768_a("PartStatus", getPartStatus() & getLastPartStatusMask());
/*  781 */     nbt.func_74768_a("AcFuel", getFuel());
/*  782 */     nbt.func_74768_a("AcDespawnCount", getDespawnCount());
/*  783 */     nbt.func_74776_a("AcRoll", getRotRoll());
/*  784 */     nbt.func_74757_a("SearchLight", isSearchLightON());
/*  785 */     nbt.func_74776_a("AcLastRYaw", getLastRiderYaw());
/*  786 */     nbt.func_74776_a("AcLastRPitch", getLastRiderPitch());
/*  787 */     nbt.func_74778_a("AcCommand", getCommand());
/*  788 */     if (!nbt.func_74764_b("AcGunnerStatus")) {
/*  789 */       setGunnerStatus(true);
/*      */     }
/*  791 */     nbt.func_74757_a("AcGunnerStatus", getGunnerStatus());
/*      */     
/*  793 */     super.func_70014_b(nbt);
/*  794 */     getGuiInventory().writeEntityToNBT(nbt);
/*  795 */     int[] wa_list = new int[getWeaponNum()];
/*      */     
/*  797 */     for (int i = 0; i < wa_list.length; i++) {
/*  798 */       wa_list[i] = getWeapon(i).getRestAllAmmoNum() + getWeapon(i).getAmmoNum();
/*      */     }
/*      */     
/*  801 */     nbt.func_74782_a("AcWeaponsAmmo", (NBTBase)W_NBTTag.newTagIntArray("AcWeaponsAmmo", wa_list));
/*  802 */     nbt.func_74768_a("AcDamage", getDamageTaken());
/*  803 */     nbt.func_74757_a("AcDismounted", this.dismountedUserCtrl);
/*      */   }
/*      */   
/*      */   public boolean func_70097_a(DamageSource damageSource, float org_damage) {
/*  807 */     float damageFactor = this.lastBBDamageFactor;
/*  808 */     this.lastBBDamageFactor = 1.0F;
/*  809 */     if (func_85032_ar())
/*  810 */       return false; 
/*  811 */     if (this.field_70128_L)
/*  812 */       return false; 
/*  813 */     if (this.timeSinceHit > 0) {
/*  814 */       return false;
/*      */     }
/*  816 */     String dmt = damageSource.func_76355_l();
/*  817 */     if (dmt.equalsIgnoreCase("inFire"))
/*  818 */       return false; 
/*  819 */     if (dmt.equalsIgnoreCase("cactus"))
/*  820 */       return false; 
/*  821 */     if (this.field_70170_p.field_72995_K) {
/*  822 */       return true;
/*      */     }
/*  824 */     MCH_Config var10000 = MCH_MOD.config;
/*  825 */     float damage = MCH_Config.applyDamageByExternal((Entity)this, damageSource, org_damage);
/*  826 */     if (!MCH_Multiplay.canAttackEntity(damageSource, (Entity)this)) {
/*  827 */       return false;
/*      */     }
/*  829 */     if (dmt.equalsIgnoreCase("lava")) {
/*  830 */       damage *= (this.field_70146_Z.nextInt(8) + 2);
/*  831 */       this.timeSinceHit = 2;
/*      */     } 
/*      */     
/*  834 */     if (dmt.startsWith("explosion")) {
/*  835 */       this.timeSinceHit = 1;
/*  836 */     } else if (isMountedEntity(damageSource.func_76346_g())) {
/*  837 */       return false;
/*      */     } 
/*      */     
/*  840 */     if (dmt.equalsIgnoreCase("onFire")) {
/*  841 */       this.timeSinceHit = 10;
/*      */     }
/*      */     
/*  844 */     boolean isCreative = false;
/*  845 */     boolean isSneaking = false;
/*  846 */     Entity entity = damageSource.func_76346_g();
/*  847 */     boolean isDamegeSourcePlayer = false;
/*  848 */     boolean playDamageSound = false;
/*  849 */     if (entity instanceof EntityPlayer) {
/*  850 */       EntityPlayer cmd = (EntityPlayer)entity;
/*  851 */       isCreative = cmd.field_71075_bZ.field_75098_d;
/*  852 */       isSneaking = cmd.func_70093_af();
/*  853 */       if (dmt.equalsIgnoreCase("player")) {
/*  854 */         if (isCreative) {
/*  855 */           isDamegeSourcePlayer = true;
/*      */         } else {
/*  857 */           var10000 = MCH_MOD.config;
/*  858 */           if (!MCH_Config.PreventingBroken.prmBool) {
/*  859 */             var10000 = MCH_MOD.config;
/*  860 */             if (MCH_Config.BreakableOnlyPickaxe.prmBool) {
/*  861 */               if (cmd.func_71045_bC() != null && cmd.func_71045_bC().func_77973_b() instanceof net.minecraft.item.ItemPickaxe) {
/*  862 */                 isDamegeSourcePlayer = true;
/*      */               }
/*      */             } else {
/*  865 */               isDamegeSourcePlayer = !isRidePlayer();
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/*  871 */       W_WorldFunc.MOD_playSoundAtEntity((Entity)this, "hit", 1.0F, 1.0F);
/*      */     } else {
/*  873 */       playDamageSound = true;
/*      */     } 
/*      */     
/*  876 */     if (!isDestroyed()) {
/*  877 */       if (!isDamegeSourcePlayer) {
/*  878 */         MCH_AircraftInfo cmd1 = getAcInfo();
/*  879 */         if (cmd1 != null && !dmt.equalsIgnoreCase("lava") && !dmt.equalsIgnoreCase("onFire")) {
/*  880 */           if (damage > cmd1.armorMaxDamage) {
/*  881 */             damage = cmd1.armorMaxDamage;
/*      */           }
/*      */           
/*  884 */           if (damageFactor <= 1.0F) {
/*  885 */             damage *= 1.0F;
/*      */           }
/*      */           
/*  888 */           damage *= cmd1.armorDamageFactor;
/*  889 */           damage -= cmd1.armorMinDamage;
/*  890 */           if (damage <= 0.0F) {
/*  891 */             MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityAircraft.attackEntityFrom:no damage=%.1f -> %.1f(factor=%.2f):%s", new Object[] { Float.valueOf(org_damage), Float.valueOf(damage), Float.valueOf(damageFactor), dmt });
/*  892 */             return false;
/*      */           } 
/*      */           
/*  895 */           if (damageFactor > 1.0F) {
/*  896 */             damage *= damageFactor;
/*      */           }
/*      */         } 
/*      */         
/*  900 */         MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityAircraft.attackEntityFrom:damage=%.1f(factor=%.2f):%s", new Object[] { Float.valueOf(damage), Float.valueOf(damageFactor), dmt });
/*  901 */         setDamageTaken(getDamageTaken() + (int)damage / 3);
/*      */       } 
/*      */       
/*  904 */       func_70018_K();
/*  905 */       if (getDamageTaken() >= getMaxHP() || isDamegeSourcePlayer) {
/*  906 */         if (!isDamegeSourcePlayer) {
/*  907 */           setDamageTaken(getMaxHP());
/*  908 */           destroyAircraft();
/*  909 */           this.timeSinceHit = 20;
/*  910 */           String cmd2 = getCommand().trim();
/*  911 */           if (cmd2.startsWith("/")) {
/*  912 */             cmd2 = cmd2.substring(1);
/*      */           }
/*      */           
/*  915 */           if (!cmd2.isEmpty()) {
/*  916 */             MCH_DummyCommandSender.execCommand(cmd2);
/*      */           }
/*      */           
/*  919 */           if (dmt.equalsIgnoreCase("inWall")) {
/*  920 */             explosionByCrash(0.0D);
/*  921 */             this.damageSinceDestroyed = getMaxHP();
/*      */           } else {
/*  923 */             MCH_Explosion.newExplosion(this.field_70170_p, (Entity)null, entity, this.field_70165_t, this.field_70163_u, this.field_70161_v, 2.0F, 2.0F, true, true, true, true, 5);
/*      */           } 
/*      */         } else {
/*  926 */           if (getAcInfo() != null && getAcInfo().getItem() != null) {
/*  927 */             if (isCreative) {
/*  928 */               var10000 = MCH_MOD.config;
/*  929 */               if (MCH_Config.DropItemInCreativeMode.prmBool && !isSneaking) {
/*  930 */                 dropItemWithOffset(getAcInfo().getItem(), 1, 0.0F);
/*      */               }
/*      */               
/*  933 */               var10000 = MCH_MOD.config;
/*  934 */               if (!MCH_Config.DropItemInCreativeMode.prmBool && isSneaking) {
/*  935 */                 dropItemWithOffset(getAcInfo().getItem(), 1, 0.0F);
/*      */               }
/*      */             } else {
/*  938 */               dropItemWithOffset(getAcInfo().getItem(), 1, 0.0F);
/*      */             } 
/*      */           }
/*      */           
/*  942 */           setDead(true);
/*      */         } 
/*      */       }
/*  945 */     } else if (isDamegeSourcePlayer && isCreative) {
/*  946 */       setDead(true);
/*      */     } 
/*      */     
/*  949 */     if (playDamageSound) {
/*  950 */       W_WorldFunc.MOD_playSoundAtEntity((Entity)this, "helidmg", 1.0F, 0.9F + this.field_70146_Z.nextFloat() * 0.1F);
/*      */     }
/*      */     
/*  953 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isExploded() {
/*  960 */     return (isDestroyed() && this.damageSinceDestroyed > getMaxHP() / 10 + 1);
/*      */   }
/*      */   
/*      */   public void destruct() {
/*  964 */     if (getRiddenByEntity() != null) {
/*  965 */       getRiddenByEntity().func_70078_a((Entity)null);
/*      */     }
/*      */     
/*  968 */     setDead(true);
/*      */   }
/*      */   
/*      */   public EntityItem func_70099_a(ItemStack is, float par2) {
/*  972 */     if (is.field_77994_a == 0) {
/*  973 */       return null;
/*      */     }
/*  975 */     setAcDataToItem(is);
/*  976 */     return super.func_70099_a(is, par2);
/*      */   }
/*      */ 
/*      */   
/*      */   public void setAcDataToItem(ItemStack is) {
/*  981 */     if (!is.func_77942_o()) {
/*  982 */       is.func_77982_d(new NBTTagCompound());
/*      */     }
/*      */     
/*  985 */     NBTTagCompound nbt = is.func_77978_p();
/*  986 */     nbt.func_74778_a("MCH_Command", getCommand());
/*  987 */     MCH_Config var10000 = MCH_MOD.config;
/*  988 */     if (MCH_Config.ItemFuel.prmBool) {
/*  989 */       nbt.func_74768_a("MCH_Fuel", getFuel());
/*      */     }
/*  991 */     int[] wa_list = new int[getWeaponNum()];
/*      */     
/*  993 */     for (int i = 0; i < wa_list.length; i++) {
/*  994 */       wa_list[i] = getWeapon(i).getRestAllAmmoNum() + getWeapon(i).getAmmoNum();
/*      */     }
/*  996 */     nbt.func_74782_a("AcWeaponsAmmo", (NBTBase)W_NBTTag.newTagIntArray("AcWeaponsAmmo", wa_list));
/*      */     
/*  998 */     var10000 = MCH_MOD.config;
/*  999 */     if (MCH_Config.ItemDamage.prmBool) {
/* 1000 */       is.func_77964_b(getDamageTaken());
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void getAcDataFromItem(ItemStack is) {
/* 1006 */     if (is.func_77942_o()) {
/* 1007 */       NBTTagCompound nbt = is.func_77978_p();
/* 1008 */       setCommandForce(nbt.func_74779_i("MCH_Command"));
/* 1009 */       MCH_Config var10000 = MCH_MOD.config;
/* 1010 */       if (MCH_Config.ItemFuel.prmBool) {
/* 1011 */         setFuel(nbt.func_74762_e("MCH_Fuel"));
/*      */       }
/*      */       
/* 1014 */       int[] wa_list = nbt.func_74759_k("AcWeaponsAmmo");
/*      */       
/* 1016 */       for (int i = 0; i < wa_list.length; i++) {
/* 1017 */         getWeapon(i).setRestAllAmmoNum(wa_list[i]);
/* 1018 */         getWeapon(i).reloadMag();
/*      */       } 
/*      */       
/* 1021 */       var10000 = MCH_MOD.config;
/* 1022 */       if (MCH_Config.ItemDamage.prmBool) {
/* 1023 */         setDamageTaken(is.func_77960_j());
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean func_70300_a(EntityPlayer player) {
/* 1030 */     return isUAV() ? super.func_70300_a(player) : (!this.field_70128_L ? ((getSeatIdByEntity((Entity)player) >= 0) ? ((player.func_70068_e((Entity)this) <= 4096.0D)) : ((player.func_70068_e((Entity)this) <= 64.0D))) : false);
/*      */   }
/*      */   
/*      */   public void func_70108_f(Entity par1Entity) {}
/*      */   
/*      */   public void func_70024_g(double par1, double par3, double par5) {}
/*      */   
/*      */   public void func_70016_h(double par1, double par3, double par5) {
/* 1038 */     this.velocityX = this.field_70159_w = par1;
/* 1039 */     this.velocityY = this.field_70181_x = par3;
/* 1040 */     this.velocityZ = this.field_70179_y = par5;
/*      */   }
/*      */   
/*      */   public void onFirstUpdate() {
/* 1044 */     if (!this.field_70170_p.field_72995_K) {
/* 1045 */       MCH_Config var10002 = MCH_MOD.config;
/* 1046 */       setCommonStatus(3, MCH_Config.InfinityAmmo.prmBool);
/* 1047 */       var10002 = MCH_MOD.config;
/* 1048 */       setCommonStatus(4, MCH_Config.InfinityFuel.prmBool);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void onRidePilotFirstUpdate() {
/* 1054 */     if (this.field_70170_p.field_72995_K && W_Lib.isClientPlayer(getRiddenByEntity())) {
/* 1055 */       updateClientSettings(0);
/*      */     }
/*      */     
/* 1058 */     Entity pilot = getRiddenByEntity();
/* 1059 */     if (pilot != null) {
/* 1060 */       pilot.field_70177_z = getLastRiderYaw();
/* 1061 */       pilot.field_70125_A = getLastRiderPitch();
/*      */     } 
/*      */     
/* 1064 */     this.keepOnRideRotation = false;
/* 1065 */     if (getAcInfo() != null) {
/* 1066 */       switchFreeLookModeClient((getAcInfo()).defaultFreelook);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public double getCurrentThrottle() {
/* 1072 */     return this.currentThrottle;
/*      */   }
/*      */   
/*      */   public void setCurrentThrottle(double throttle) {
/* 1076 */     this.currentThrottle = throttle;
/*      */   }
/*      */   
/*      */   public void addCurrentThrottle(double throttle) {
/* 1080 */     setCurrentThrottle(getCurrentThrottle() + throttle);
/*      */   }
/*      */   
/*      */   public double getPrevCurrentThrottle() {
/* 1084 */     return this.prevCurrentThrottle;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canMouseRot() {
/* 1089 */     return (!this.field_70128_L && getRiddenByEntity() != null && !isDestroyed());
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canUpdateYaw(Entity paramEntity) {
/* 1094 */     if (getRidingEntity() != null) {
/* 1095 */       return false;
/*      */     }
/* 1097 */     if (getCountOnUpdate() < 30) {
/* 1098 */       return false;
/*      */     }
/* 1100 */     return (MCH_Lib.getBlockIdY((Entity)this, 3, -2) == 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canUpdatePitch(Entity paramEntity) {
/* 1105 */     if (getCountOnUpdate() < 30) {
/* 1106 */       return false;
/*      */     }
/* 1108 */     return (MCH_Lib.getBlockIdY((Entity)this, 3, -2) == 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canUpdateRoll(Entity paramEntity) {
/* 1113 */     if (getRidingEntity() != null) {
/* 1114 */       return false;
/*      */     }
/* 1116 */     if (getCountOnUpdate() < 30) {
/* 1117 */       return false;
/*      */     }
/* 1119 */     return (MCH_Lib.getBlockIdY((Entity)this, 3, -2) == 0);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isOverridePlayerYaw() {
/* 1124 */     return !isFreeLookMode();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isOverridePlayerPitch() {
/* 1129 */     return !isFreeLookMode();
/*      */   }
/*      */ 
/*      */   
/*      */   public double getAddRotationYawLimit() {
/* 1134 */     if (getAcInfo() != null) {
/* 1135 */       return 40.0D * (getAcInfo()).mobilityYaw;
/*      */     }
/* 1137 */     return 40.0D;
/*      */   }
/*      */ 
/*      */   
/*      */   public double getAddRotationPitchLimit() {
/* 1142 */     if (getAcInfo() != null) {
/* 1143 */       return 40.0D * (getAcInfo()).mobilityPitch;
/*      */     }
/* 1145 */     return 40.0D;
/*      */   }
/*      */ 
/*      */   
/*      */   public double getAddRotationRollLimit() {
/* 1150 */     if (getAcInfo() != null) {
/* 1151 */       return 40.0D * (getAcInfo()).mobilityRoll;
/*      */     }
/* 1153 */     return 40.0D;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getYawFactor() {
/* 1158 */     return 1.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getPitchFactor() {
/* 1163 */     return 1.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getRollFactor() {
/* 1168 */     return 1.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public abstract void onUpdateAngles(float paramFloat);
/*      */   
/*      */   public float getControlRotYaw(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1175 */     return 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getControlRotPitch(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1180 */     return 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   public float getControlRotRoll(float paramFloat1, float paramFloat2, float paramFloat3) {
/* 1185 */     return 0.0F;
/*      */   }
/*      */   
/*      */   public void setAngles(Entity entity, float n, float n2, float n3, float n4, float n5) {
/* 1189 */     if (n5 < 0.03F) {
/* 1190 */       n5 = 0.4F;
/*      */     }
/* 1192 */     if (n5 > 0.9F) {
/* 1193 */       n5 = 0.6F;
/*      */     }
/* 1195 */     this.lowPassPartialTicks.put(n5);
/* 1196 */     n5 = this.lowPassPartialTicks.getAvg();
/* 1197 */     float rotPitch = getRotPitch();
/* 1198 */     float rotYaw = getRotYaw();
/* 1199 */     float rotRoll = getRotRoll();
/* 1200 */     if (isFreeLookMode()) {
/* 1201 */       n4 = 0.0F;
/* 1202 */       n3 = 0.0F;
/*      */     } 
/* 1204 */     float n6 = 0.0F;
/* 1205 */     float n7 = 0.0F;
/* 1206 */     float n8 = 0.0F;
/* 1207 */     if (canUpdateYaw(entity)) {
/* 1208 */       double addRotationYawLimit = getAddRotationYawLimit();
/*      */       float controlRotYaw;
/* 1210 */       if ((controlRotYaw = getControlRotYaw(n3, n4, n5)) < -addRotationYawLimit) {
/* 1211 */         controlRotYaw = (float)-addRotationYawLimit;
/*      */       }
/* 1213 */       if (controlRotYaw > addRotationYawLimit) {
/* 1214 */         controlRotYaw = (float)addRotationYawLimit;
/*      */       }
/* 1216 */       n6 = (float)((controlRotYaw * getYawFactor()) * 0.06D * n5);
/*      */     } 
/* 1218 */     if (canUpdatePitch(entity)) {
/* 1219 */       double addRotationPitchLimit = getAddRotationPitchLimit();
/*      */       float controlRotPitch;
/* 1221 */       if ((controlRotPitch = getControlRotPitch(n3, n4, n5)) < -addRotationPitchLimit) {
/* 1222 */         controlRotPitch = (float)-addRotationPitchLimit;
/*      */       }
/* 1224 */       if (controlRotPitch > addRotationPitchLimit) {
/* 1225 */         controlRotPitch = (float)addRotationPitchLimit;
/*      */       }
/* 1227 */       n7 = (float)((-controlRotPitch * getPitchFactor()) * 0.06D * n5);
/*      */     } 
/* 1229 */     if (canUpdateRoll(entity)) {
/* 1230 */       double addRotationRollLimit = getAddRotationRollLimit();
/*      */       float controlRotRoll;
/* 1232 */       if ((controlRotRoll = getControlRotRoll(n3, n4, n5)) < -addRotationRollLimit) {
/* 1233 */         controlRotRoll = (float)-addRotationRollLimit;
/*      */       }
/* 1235 */       if (controlRotRoll > addRotationRollLimit) {
/* 1236 */         controlRotRoll = (float)addRotationRollLimit;
/*      */       }
/* 1238 */       n8 = controlRotRoll * getRollFactor() * 0.06F * n5;
/*      */     } 
/*      */     MCH_Math.FMatrix matrix;
/* 1241 */     MCH_Math.MatTurnZ(matrix = MCH_Math.newMatrix(), n8 / 180.0F * 3.1415927F);
/* 1242 */     MCH_Math.MatTurnX(matrix, n7 / 180.0F * 3.1415927F);
/* 1243 */     MCH_Math.MatTurnY(matrix, n6 / 180.0F * 3.1415927F);
/* 1244 */     MCH_Math.MatTurnZ(matrix, (float)((getRotRoll() / 180.0F) * Math.PI));
/* 1245 */     MCH_Math.MatTurnX(matrix, (float)((getRotPitch() / 180.0F) * Math.PI));
/* 1246 */     MCH_Math.MatTurnY(matrix, (float)((getRotYaw() / 180.0F) * Math.PI));
/* 1247 */     MCH_Math.FVector3D matrixToEuler = MCH_Math.MatrixToEuler(matrix);
/* 1248 */     if ((getAcInfo()).limitRotation) {
/* 1249 */       matrixToEuler.x = MCH_Lib.RNG(matrixToEuler.x, (getAcInfo()).minRotationPitch, (getAcInfo()).maxRotationPitch);
/* 1250 */       matrixToEuler.z = MCH_Lib.RNG(matrixToEuler.z, (getAcInfo()).minRotationRoll, (getAcInfo()).maxRotationRoll);
/*      */     } 
/* 1252 */     if (matrixToEuler.z > 180.0F) {
/* 1253 */       MCH_Math.FVector3D fVector3D = matrixToEuler;
/* 1254 */       fVector3D.z -= 360.0F;
/*      */     } 
/* 1256 */     if (matrixToEuler.z < -180.0F) {
/* 1257 */       MCH_Math.FVector3D fVector3D2 = matrixToEuler;
/* 1258 */       fVector3D2.z += 360.0F;
/*      */     } 
/* 1260 */     setRotYaw(matrixToEuler.y);
/* 1261 */     setRotPitch(matrixToEuler.x);
/* 1262 */     setRotRoll(matrixToEuler.z);
/* 1263 */     onUpdateAngles(n5);
/* 1264 */     applyOnGroundPitch(0.9985F);
/* 1265 */     if ((getAcInfo()).limitRotation) {
/* 1266 */       matrixToEuler.x = MCH_Lib.RNG(getRotPitch(), (getAcInfo()).minRotationPitch, (getAcInfo()).maxRotationPitch);
/* 1267 */       matrixToEuler.z = MCH_Lib.RNG(getRotRoll(), (getAcInfo()).minRotationRoll, (getAcInfo()).maxRotationRoll);
/* 1268 */       setRotPitch(matrixToEuler.x);
/* 1269 */       setRotRoll(matrixToEuler.z);
/*      */     } 
/* 1271 */     if (MathHelper.func_76135_e(getRotPitch()) > 90.0F) {
/* 1272 */       MCH_Lib.DbgLog(true, "MCH_EntityAircraft.setAngles Error:Pitch=%.1f", new Object[] { Float.valueOf(getRotPitch()) });
/*      */     }
/* 1274 */     if (getRotRoll() > 180.0F) {
/* 1275 */       setRotRoll(getRotRoll() - 360.0F);
/*      */     }
/* 1277 */     if (getRotRoll() < -180.0F) {
/* 1278 */       setRotRoll(getRotRoll() + 360.0F);
/*      */     }
/* 1280 */     this.prevRotationRoll = getRotRoll();
/* 1281 */     this.field_70127_C = getRotPitch();
/* 1282 */     if (getRidingEntity() == null) {
/* 1283 */       this.field_70126_B = getRotYaw();
/*      */     }
/* 1285 */     if (isOverridePlayerYaw()) {
/* 1286 */       if (getRidingEntity() == null) {
/* 1287 */         entity.field_70126_B = getRotYaw();
/*      */       } else {
/*      */         
/* 1290 */         if (getRotYaw() - entity.field_70177_z > 180.0F) {
/* 1291 */           entity.field_70126_B += 360.0F;
/*      */         }
/* 1293 */         if (getRotYaw() - entity.field_70177_z < -180.0F) {
/* 1294 */           entity.field_70126_B -= 360.0F;
/*      */         }
/*      */       } 
/* 1297 */       entity.field_70177_z = getRotYaw();
/*      */     } else {
/*      */       
/* 1300 */       entity.func_70082_c(n, 0.0F);
/*      */     } 
/* 1302 */     if (isOverridePlayerPitch()) {
/* 1303 */       entity.field_70127_C = getRotPitch();
/* 1304 */       entity.field_70125_A = getRotPitch();
/*      */     } else {
/*      */       
/* 1307 */       entity.func_70082_c(0.0F, n2);
/*      */     } 
/* 1309 */     if ((getRidingEntity() == null && rotYaw != getRotYaw()) || rotPitch != getRotPitch() || rotRoll != getRotRoll()) {
/* 1310 */       this.aircraftRotChanged = true;
/*      */     }
/*      */   }
/*      */   
/*      */   public boolean canSwitchSearchLight(Entity entity) {
/* 1315 */     return (haveSearchLight() && getSeatIdByEntity(entity) <= 1);
/*      */   }
/*      */   
/*      */   public boolean isSearchLightON() {
/* 1319 */     return getCommonStatus(6);
/*      */   }
/*      */   
/*      */   public void setSearchLight(boolean onoff) {
/* 1323 */     setCommonStatus(6, onoff);
/*      */   }
/*      */   
/*      */   public boolean haveSearchLight() {
/* 1327 */     return (getAcInfo() != null && (getAcInfo()).searchLights.size() > 0);
/*      */   }
/*      */   
/*      */   public float getSearchLightValue(Entity entity) {
/* 1331 */     if (haveSearchLight() && isSearchLightON()) {
/* 1332 */       Iterator<MCH_AircraftInfo.SearchLight> i$ = (getAcInfo()).searchLights.iterator();
/*      */       
/* 1334 */       while (i$.hasNext()) {
/* 1335 */         MCH_AircraftInfo.SearchLight sl = i$.next();
/* 1336 */         Vec3 pos = getTransformedPosition(sl.pos);
/* 1337 */         double dist = entity.func_70092_e(pos.field_72450_a, pos.field_72448_b, pos.field_72449_c);
/* 1338 */         if (dist > 2.0D && dist < (sl.height * sl.height + 20.0F)) {
/* 1339 */           double cx = entity.field_70165_t - pos.field_72450_a;
/* 1340 */           double cy = entity.field_70163_u - pos.field_72448_b;
/* 1341 */           double cz = entity.field_70161_v - pos.field_72449_c;
/* 1342 */           double h = 0.0D;
/* 1343 */           double v = 0.0D;
/*      */           
/* 1345 */           if (!sl.fixDir) {
/* 1346 */             Vec3 angle = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -this.lastSearchLightYaw + sl.yaw, -this.lastSearchLightPitch + sl.pitch, -getRotRoll());
/* 1347 */             h = MCH_Lib.getPosAngle(angle.field_72450_a, angle.field_72449_c, cx, cz);
/* 1348 */             v = Math.atan2(cy, Math.sqrt(cx * cx + cz * cz)) * 180.0D / Math.PI;
/* 1349 */             v = Math.abs(v + this.lastSearchLightPitch + sl.pitch);
/*      */           } else {
/* 1351 */             float f = 0.0F;
/* 1352 */             if (sl.steering) {
/* 1353 */               f = this.rotYawWheel * sl.stRot;
/*      */             }
/*      */             
/* 1356 */             Vec3 value = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -getRotYaw() + sl.yaw + f, -getRotPitch() + sl.pitch, -getRotRoll());
/* 1357 */             h = MCH_Lib.getPosAngle(value.field_72450_a, value.field_72449_c, cx, cz);
/* 1358 */             v = Math.atan2(cy, Math.sqrt(cx * cx + cz * cz)) * 180.0D / Math.PI;
/* 1359 */             v = Math.abs(v + getRotPitch() + sl.pitch);
/*      */           } 
/*      */           
/* 1362 */           float angle1 = sl.angle * 3.0F;
/* 1363 */           if (h < angle1 && v < angle1) {
/* 1364 */             float value1 = 0.0F;
/* 1365 */             if (h + v < angle1) {
/* 1366 */               value1 = (float)(1440.0D * (1.0D - (h + v) / angle1));
/*      */             }
/*      */             
/* 1369 */             return (value1 <= 240.0F) ? value1 : 240.0F;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 1375 */     return 0.0F;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public abstract void onUpdateAircraft();
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void func_70071_h_() {
/* 1387 */     if (getCountOnUpdate() < 2) {
/* 1388 */       this.prevPosition.clear(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v));
/*      */     }
/*      */     
/* 1391 */     double x = Math.abs(this.field_70165_t);
/* 1392 */     double y = Math.abs(this.field_70163_u);
/* 1393 */     double z = Math.abs(this.field_70161_v);
/*      */ 
/*      */     
/* 1396 */     this.prevCurrentThrottle = getCurrentThrottle();
/* 1397 */     this.lastBBDamageFactor = 1.0F;
/* 1398 */     updateControl();
/* 1399 */     checkServerNoMove();
/* 1400 */     onUpdate_RidingEntity();
/* 1401 */     Iterator<UnmountReserve> itr = this.listUnmountReserve.iterator();
/*      */     
/* 1403 */     while (itr.hasNext()) {
/* 1404 */       UnmountReserve ft = itr.next();
/* 1405 */       if (ft.entity != null && !ft.entity.field_70128_L) {
/* 1406 */         ft.entity.func_70107_b(ft.posX, ft.posY, ft.posZ);
/* 1407 */         ft.entity.field_70143_R = this.field_70143_R;
/*      */       } 
/*      */       
/* 1410 */       if (ft.cnt > 0) {
/* 1411 */         ft.cnt--;
/*      */       }
/*      */       
/* 1414 */       if (ft.cnt == 0) {
/* 1415 */         itr.remove();
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 1421 */     if (isDestroyed() && getCountOnUpdate() % 20 == 0) {
/* 1422 */       for (int i = 0; i < getSeatNum() + 1; i++) {
/* 1423 */         Entity entity = getEntityBySeatId(i);
/* 1424 */         if (entity != null && (i != 0 || !isUAV() || !isNewUAV())) {
/* 1425 */           MCH_Config var10000 = MCH_MOD.config;
/* 1426 */           if (MCH_Config.applyDamageVsEntity(entity, DamageSource.field_76372_a, 1.0F) > 0.0F) {
/* 1427 */             entity.func_70015_d(5);
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 1433 */     if ((this.aircraftRotChanged || this.aircraftRollRev) && this.field_70170_p.field_72995_K && getRiddenByEntity() != null) {
/* 1434 */       MCH_PacketIndRotation.send(this);
/* 1435 */       this.aircraftRotChanged = false;
/* 1436 */       this.aircraftRollRev = false;
/*      */     } 
/*      */     
/* 1439 */     if (!this.field_70170_p.field_72995_K && (int)this.prevRotationRoll != (int)getRotRoll()) {
/* 1440 */       float var8 = MathHelper.func_76142_g(getRotRoll());
/* 1441 */       func_70096_w().func_75692_b(26, new Short((short)(int)var8));
/*      */     } 
/*      */     
/* 1444 */     this.prevRotationRoll = getRotRoll();
/* 1445 */     if (!this.field_70170_p.field_72995_K && isTargetDrone() && !isDestroyed() && getCountOnUpdate() > 20 && !canUseFuel()) {
/* 1446 */       setDamageTaken(getMaxHP());
/* 1447 */       destroyAircraft();
/* 1448 */       MCH_Explosion.newExplosion(this.field_70170_p, (Entity)null, (Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, 2.0F, 2.0F, true, true, true, true, 5);
/*      */     } 
/*      */     
/* 1451 */     if (this.field_70170_p.field_72995_K && getAcInfo() != null && getHP() <= 0 && getDespawnCount() <= 0) {
/* 1452 */       destroyAircraft();
/*      */     }
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1458 */     if (!this.field_70170_p.field_72995_K && getDespawnCount() > 0) {
/* 1459 */       setDespawnCount(getDespawnCount() - 1);
/* 1460 */       if (getDespawnCount() <= 1) {
/* 1461 */         setDead(true);
/*      */       }
/*      */     } 
/*      */     
/* 1465 */     super.func_70071_h_();
/* 1466 */     if (func_70021_al() != null) {
/* 1467 */       Entity[] var9 = func_70021_al();
/* 1468 */       int var10 = var9.length;
/*      */       
/* 1470 */       for (int prevOnGround = 0; prevOnGround < var10; prevOnGround++) {
/* 1471 */         Entity prevMotionY = var9[prevOnGround];
/* 1472 */         if (prevMotionY != null) {
/* 1473 */           prevMotionY.func_70071_h_();
/*      */         }
/*      */       } 
/*      */     } 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */     
/* 1484 */     updateNoCollisionEntities();
/* 1485 */     updateUAV();
/* 1486 */     supplyFuel();
/* 1487 */     supplyAmmoToOtherAircraft();
/* 1488 */     updateFuel();
/* 1489 */     repairOtherAircraft();
/* 1490 */     if (this.modeSwitchCooldown > 0) {
/* 1491 */       this.modeSwitchCooldown--;
/*      */     }
/*      */     
/* 1494 */     if (this.lastRiddenByEntity == null && getRiddenByEntity() != null) {
/* 1495 */       onRidePilotFirstUpdate();
/*      */     }
/*      */     
/* 1498 */     if (this.countOnUpdate == 0) {
/* 1499 */       onFirstUpdate();
/*      */     }
/*      */     
/* 1502 */     this.countOnUpdate++;
/* 1503 */     if (this.countOnUpdate >= 1000000) {
/* 1504 */       this.countOnUpdate = 1;
/*      */     }
/*      */     
/* 1507 */     if (this.field_70170_p.field_72995_K) {
/* 1508 */       this.commonStatus = func_70096_w().func_75679_c(23);
/*      */     }
/*      */     
/* 1511 */     this.field_70143_R = 0.0F;
/* 1512 */     if (this.field_70153_n != null) {
/* 1513 */       this.field_70153_n.field_70143_R = 0.0F;
/*      */     }
/*      */     
/* 1516 */     if (this.missileDetector != null) {
/* 1517 */       this.missileDetector.update();
/*      */     }
/*      */     
/* 1520 */     if (this.soundUpdater != null) {
/* 1521 */       this.soundUpdater.update();
/*      */     }
/*      */ 
/*      */     
/* 1525 */     updateSupplyAmmo();
/* 1526 */     autoRepair();
/* 1527 */     int var7 = getFlareTick();
/* 1528 */     this.flareDv.update();
/* 1529 */     if (!this.field_70170_p.field_72995_K && getFlareTick() == 0 && var7 != 0) {
/* 1530 */       setCommonStatus(0, false);
/*      */     }
/*      */     
/* 1533 */     Entity e = getRiddenByEntity();
/* 1534 */     if (e != null && !e.field_70128_L && !isDestroyed()) {
/* 1535 */       this.lastRiderYaw = e.field_70177_z;
/* 1536 */       this.prevLastRiderYaw = e.field_70126_B;
/* 1537 */       this.lastRiderPitch = e.field_70125_A;
/* 1538 */       this.prevLastRiderPitch = e.field_70127_C;
/* 1539 */     } else if (this.field_70154_o != null) {
/* 1540 */       this.lastRiderYaw = this.field_70177_z;
/* 1541 */       this.prevLastRiderYaw = this.field_70126_B;
/* 1542 */       this.lastRiderPitch = this.field_70125_A;
/* 1543 */       this.prevLastRiderPitch = this.field_70127_C;
/*      */     } 
/*      */     
/* 1546 */     updatePartCameraRotate();
/* 1547 */     updatePartWheel();
/* 1548 */     updatePartCrawlerTrack();
/* 1549 */     updatePartLightHatch();
/* 1550 */     regenerationMob();
/* 1551 */     if (getRiddenByEntity() == null && this.lastRiddenByEntity != null) {
/* 1552 */       unmountEntity();
/*      */     }
/*      */     
/* 1555 */     updateExtraBoundingBox();
/* 1556 */     boolean var11 = this.field_70122_E;
/* 1557 */     double var12 = this.field_70181_x;
/* 1558 */     onUpdateAircraft();
/* 1559 */     if (getAcInfo() != null) {
/* 1560 */       updateParts(getPartStatus());
/*      */     }
/*      */     
/* 1563 */     if (this.recoilCount > 0) {
/* 1564 */       this.recoilCount--;
/*      */     }
/*      */     
/* 1567 */     if (!W_Entity.isEqual(MCH_MOD.proxy.getClientPlayer(), getRiddenByEntity())) {
/* 1568 */       updateRecoil(1.0F);
/*      */     }
/*      */     
/* 1571 */     if (!this.field_70170_p.field_72995_K && isDestroyed() && !isExploded() && !var11 && this.field_70122_E && var12 < -0.2D) {
/* 1572 */       explosionByCrash(var12);
/* 1573 */       this.damageSinceDestroyed = getMaxHP();
/*      */     } 
/*      */     
/* 1576 */     onUpdate_PartRotation();
/* 1577 */     onUpdate_ParticleSmoke();
/* 1578 */     updateSeatsPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v, false);
/* 1579 */     updateHitBoxPosition();
/* 1580 */     onUpdate_CollisionGroundDamage();
/* 1581 */     onUpdate_UnmountCrew();
/* 1582 */     onUpdate_Repelling();
/* 1583 */     checkRideRack();
/* 1584 */     if (this.lastRidingEntity == null && getRidingEntity() != null) {
/* 1585 */       onRideEntity(getRidingEntity());
/*      */     }
/*      */     
/* 1588 */     this.lastRiddenByEntity = getRiddenByEntity();
/* 1589 */     this.lastRidingEntity = getRidingEntity();
/* 1590 */     this.prevPosition.put(Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v));
/*      */   }
/*      */   
/*      */   public void forceChunkLoading(ForgeChunkManager.Ticket ticket) {
/* 1594 */     for (UnmodifiableIterator<ChunkCoordIntPair> unmodifiableIterator = ticket.getChunkList().iterator(); unmodifiableIterator.hasNext(); ) { ChunkCoordIntPair coord = unmodifiableIterator.next();
/* 1595 */       ForgeChunkManager.forceChunk(ticket, coord); }
/*      */   
/*      */   }
/*      */   
/*      */   private void updateNoCollisionEntities() {
/* 1600 */     if (!this.field_70170_p.field_72995_K && 
/* 1601 */       getCountOnUpdate() % 10 == 0) {
/*      */       
/* 1603 */       for (int key = 0; key < 1 + getSeatNum(); key++) {
/* 1604 */         Entity key1 = getEntityBySeatId(key);
/* 1605 */         if (key1 != null) {
/* 1606 */           this.noCollisionEntities.put(key1, Integer.valueOf(8));
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 1611 */       if (this.field_70154_o instanceof MCH_EntitySeat) {
/* 1612 */         MCH_EntityAircraft var3 = ((MCH_EntitySeat)this.field_70154_o).getParent();
/* 1613 */         if (var3 != null) {
/* 1614 */           this.noCollisionEntities.put(var3, Integer.valueOf(60));
/*      */         }
/* 1616 */       } else if (this.field_70154_o != null) {
/* 1617 */         this.noCollisionEntities.put(this.field_70154_o, Integer.valueOf(60));
/*      */       } 
/*      */       
/* 1620 */       Iterator<Entity> var4 = this.noCollisionEntities.keySet().iterator();
/*      */       
/* 1622 */       while (var4.hasNext()) {
/* 1623 */         Entity key1 = var4.next();
/* 1624 */         this.noCollisionEntities.put(key1, Integer.valueOf(((Integer)this.noCollisionEntities.get(key1)).intValue() - 1));
/*      */       } 
/*      */       
/* 1627 */       var4 = this.noCollisionEntities.values().iterator();
/*      */       
/* 1629 */       while (var4.hasNext()) {
/* 1630 */         if (((Integer)var4.next()).intValue() <= 0) {
/* 1631 */           var4.remove();
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateControl() {
/* 1640 */     if (!this.field_70170_p.field_72995_K) {
/* 1641 */       setCommonStatus(7, this.moveLeft);
/* 1642 */       setCommonStatus(8, this.moveRight);
/* 1643 */       setCommonStatus(9, this.throttleUp);
/* 1644 */       setCommonStatus(10, this.throttleDown);
/* 1645 */     } else if (MCH_MOD.proxy.getClientPlayer() != getRiddenByEntity()) {
/* 1646 */       this.moveLeft = getCommonStatus(7);
/* 1647 */       this.moveRight = getCommonStatus(8);
/* 1648 */       this.throttleUp = getCommonStatus(9);
/* 1649 */       this.throttleDown = getCommonStatus(10);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateRecoil(float partialTicks) {
/* 1655 */     if (this.recoilCount > 0 && this.recoilCount >= 12) {
/* 1656 */       float pitch = MathHelper.func_76134_b((float)((this.recoilYaw - getRotRoll()) * Math.PI / 180.0D));
/* 1657 */       float roll = MathHelper.func_76126_a((float)((this.recoilYaw - getRotRoll()) * Math.PI / 180.0D));
/* 1658 */       float recoil = MathHelper.func_76134_b((float)((this.recoilCount * 6) * Math.PI / 180.0D)) * this.recoilValue;
/* 1659 */       setRotPitch(getRotPitch() + recoil * pitch * partialTicks);
/* 1660 */       setRotRoll(getRotRoll() + recoil * roll * partialTicks);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void updatePartLightHatch() {
/* 1666 */     this.prevRotLightHatch = this.rotLightHatch;
/* 1667 */     if (isSearchLightON()) {
/* 1668 */       this.rotLightHatch = (float)(this.rotLightHatch + 0.5D);
/*      */     } else {
/* 1670 */       this.rotLightHatch = (float)(this.rotLightHatch - 0.5D);
/*      */     } 
/*      */     
/* 1673 */     if (this.rotLightHatch > 1.0F) {
/* 1674 */       this.rotLightHatch = 1.0F;
/*      */     }
/*      */     
/* 1677 */     if (this.rotLightHatch < 0.0F) {
/* 1678 */       this.rotLightHatch = 0.0F;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateExtraBoundingBox() {
/* 1684 */     MCH_BoundingBox[] arr$ = this.extraBoundingBox;
/* 1685 */     int len$ = arr$.length;
/*      */     
/* 1687 */     for (int i$ = 0; i$ < len$; i$++) {
/* 1688 */       MCH_BoundingBox bb = arr$[i$];
/* 1689 */       bb.updatePosition(this.field_70165_t, this.field_70163_u, this.field_70161_v, getRotYaw(), getRotPitch(), getRotRoll());
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void updatePartWheel() {
/* 1695 */     if (this.field_70170_p.field_72995_K && 
/* 1696 */       getAcInfo() != null) {
/* 1697 */       this.prevRotWheel = this.rotWheel;
/* 1698 */       this.prevRotYawWheel = this.rotYawWheel;
/* 1699 */       float LEN = 1.0F;
/* 1700 */       float MIN = 0.0F;
/* 1701 */       double throttle = getCurrentThrottle();
/* 1702 */       double pivotTurnThrottle = (getAcInfo()).pivotTurnThrottle;
/* 1703 */       if (pivotTurnThrottle <= 0.0D) {
/* 1704 */         pivotTurnThrottle = 1.0D;
/*      */       } else {
/* 1706 */         pivotTurnThrottle *= 0.10000000149011612D;
/*      */       } 
/*      */       
/* 1709 */       boolean localMoveLeft = this.moveLeft;
/* 1710 */       boolean localMoveRight = this.moveRight;
/* 1711 */       if ((getAcInfo()).enableBack && this.throttleBack > 0.01D && throttle <= 0.0D) {
/* 1712 */         throttle = (-this.throttleBack * 15.0F);
/*      */       }
/*      */       
/* 1715 */       if (localMoveLeft && !localMoveRight) {
/* 1716 */         this.rotYawWheel += 0.1F;
/* 1717 */         if (this.rotYawWheel > 1.0F) {
/* 1718 */           this.rotYawWheel = 1.0F;
/*      */         }
/* 1720 */       } else if (!localMoveLeft && localMoveRight) {
/* 1721 */         this.rotYawWheel -= 0.1F;
/* 1722 */         if (this.rotYawWheel < -1.0F) {
/* 1723 */           this.rotYawWheel = -1.0F;
/*      */         }
/*      */       } else {
/* 1726 */         this.rotYawWheel *= 0.9F;
/*      */       } 
/*      */       
/* 1729 */       this.rotWheel = (float)(this.rotWheel + throttle * (getAcInfo()).partWheelRot);
/* 1730 */       if (this.rotWheel >= 360.0F) {
/* 1731 */         this.rotWheel -= 360.0F;
/* 1732 */         this.prevRotWheel -= 360.0F;
/* 1733 */       } else if (this.rotWheel < 0.0F) {
/* 1734 */         this.rotWheel += 360.0F;
/* 1735 */         this.prevRotWheel += 360.0F;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updatePartCrawlerTrack() {
/* 1743 */     if (this.field_70170_p.field_72995_K && 
/* 1744 */       getAcInfo() != null) {
/* 1745 */       this.prevRotTrackRoller[0] = this.rotTrackRoller[0];
/* 1746 */       this.prevRotTrackRoller[1] = this.rotTrackRoller[1];
/* 1747 */       this.prevRotCrawlerTrack[0] = this.rotCrawlerTrack[0];
/* 1748 */       this.prevRotCrawlerTrack[1] = this.rotCrawlerTrack[1];
/* 1749 */       float LEN = 1.0F;
/* 1750 */       float MIN = 0.0F;
/* 1751 */       double throttle = getCurrentThrottle();
/* 1752 */       double pivotTurnThrottle = (getAcInfo()).pivotTurnThrottle;
/* 1753 */       if (pivotTurnThrottle <= 0.0D) {
/* 1754 */         pivotTurnThrottle = 1.0D;
/*      */       } else {
/* 1756 */         pivotTurnThrottle *= 0.10000000149011612D;
/*      */       } 
/*      */       
/* 1759 */       boolean localMoveLeft = this.moveLeft;
/* 1760 */       boolean localMoveRight = this.moveRight;
/* 1761 */       byte dir = 1;
/* 1762 */       if ((getAcInfo()).enableBack && this.throttleBack > 0.0F && throttle <= 0.0D) {
/* 1763 */         throttle = (-this.throttleBack * 5.0F);
/* 1764 */         if (localMoveLeft != localMoveRight) {
/* 1765 */           boolean i = localMoveLeft;
/* 1766 */           localMoveLeft = localMoveRight;
/* 1767 */           localMoveRight = i;
/* 1768 */           dir = -1;
/*      */         } 
/*      */       } 
/*      */       
/* 1772 */       if (localMoveLeft && !localMoveRight) {
/* 1773 */         throttle = 0.2D * dir;
/* 1774 */         this.throttleCrawlerTrack[0] = (float)(this.throttleCrawlerTrack[0] + throttle);
/* 1775 */         this.throttleCrawlerTrack[1] = (float)(this.throttleCrawlerTrack[1] - pivotTurnThrottle * throttle);
/* 1776 */       } else if (!localMoveLeft && localMoveRight) {
/* 1777 */         throttle = 0.2D * dir;
/* 1778 */         this.throttleCrawlerTrack[0] = (float)(this.throttleCrawlerTrack[0] - pivotTurnThrottle * throttle);
/* 1779 */         this.throttleCrawlerTrack[1] = (float)(this.throttleCrawlerTrack[1] + throttle);
/*      */       } else {
/* 1781 */         if (throttle > 0.2D) {
/* 1782 */           throttle = 0.2D;
/*      */         }
/*      */         
/* 1785 */         if (throttle < -0.2D) {
/* 1786 */           throttle = -0.2D;
/*      */         }
/*      */         
/* 1789 */         this.throttleCrawlerTrack[0] = (float)(this.throttleCrawlerTrack[0] + throttle);
/* 1790 */         this.throttleCrawlerTrack[1] = (float)(this.throttleCrawlerTrack[1] + throttle);
/*      */       } 
/*      */       
/* 1793 */       for (int var11 = 0; var11 < 2; var11++) {
/* 1794 */         if (this.throttleCrawlerTrack[var11] < -0.72F) {
/* 1795 */           this.throttleCrawlerTrack[var11] = -0.72F;
/* 1796 */         } else if (this.throttleCrawlerTrack[var11] > 0.72F) {
/* 1797 */           this.throttleCrawlerTrack[var11] = 0.72F;
/*      */         } 
/*      */         
/* 1800 */         this.rotTrackRoller[var11] = this.rotTrackRoller[var11] + this.throttleCrawlerTrack[var11] * (getAcInfo()).trackRollerRot;
/* 1801 */         if (this.rotTrackRoller[var11] >= 360.0F) {
/* 1802 */           this.rotTrackRoller[var11] = this.rotTrackRoller[var11] - 360.0F;
/* 1803 */           this.prevRotTrackRoller[var11] = this.prevRotTrackRoller[var11] - 360.0F;
/* 1804 */         } else if (this.rotTrackRoller[var11] < 0.0F) {
/* 1805 */           this.rotTrackRoller[var11] = this.rotTrackRoller[var11] + 360.0F;
/* 1806 */           this.prevRotTrackRoller[var11] = this.prevRotTrackRoller[var11] + 360.0F;
/*      */         } 
/*      */         
/* 1809 */         for (this.rotCrawlerTrack[var11] = this.rotCrawlerTrack[var11] - this.throttleCrawlerTrack[var11]; this.rotCrawlerTrack[var11] >= 1.0F; this.prevRotCrawlerTrack[var11] = this.prevRotCrawlerTrack[var11] - 1.0F) {
/* 1810 */           this.rotCrawlerTrack[var11] = this.rotCrawlerTrack[var11] - 1.0F;
/*      */         }
/*      */         
/* 1813 */         while (this.rotCrawlerTrack[var11] < 0.0F) {
/* 1814 */           this.rotCrawlerTrack[var11] = this.rotCrawlerTrack[var11] + 1.0F;
/*      */         }
/*      */         
/* 1817 */         while (this.prevRotCrawlerTrack[var11] < 0.0F) {
/* 1818 */           this.prevRotCrawlerTrack[var11] = this.prevRotCrawlerTrack[var11] + 1.0F;
/*      */         }
/*      */         
/* 1821 */         this.throttleCrawlerTrack[var11] = (float)(this.throttleCrawlerTrack[var11] * 0.75D);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void checkServerNoMove() {
/* 1829 */     if (!this.field_70170_p.field_72995_K) {
/* 1830 */       double moti = this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y;
/* 1831 */       if (moti < 1.0E-4D) {
/* 1832 */         if (this.serverNoMoveCount < 20) {
/* 1833 */           this.serverNoMoveCount++;
/* 1834 */           if (this.serverNoMoveCount >= 20) {
/* 1835 */             this.serverNoMoveCount = 0;
/* 1836 */             if (this.field_70170_p instanceof WorldServer) {
/* 1837 */               ((WorldServer)this.field_70170_p).func_73039_n().func_151247_a((Entity)this, (Packet)new S12PacketEntityVelocity(func_145782_y(), 0.0D, 0.0D, 0.0D));
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } else {
/* 1842 */         this.serverNoMoveCount = 0;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean haveRotPart() {
/* 1849 */     return (this.field_70170_p.field_72995_K && getAcInfo() != null && this.rotPartRotation.length > 0 && this.rotPartRotation.length == (getAcInfo()).partRotPart.size());
/*      */   }
/*      */   
/*      */   public void onUpdate_PartRotation() {
/* 1853 */     if (haveRotPart()) {
/* 1854 */       for (int i = 0; i < this.rotPartRotation.length; i++) {
/* 1855 */         this.prevRotPartRotation[i] = this.rotPartRotation[i];
/* 1856 */         if ((!isDestroyed() && ((MCH_AircraftInfo.RotPart)(getAcInfo()).partRotPart.get(i)).rotAlways) || getRiddenByEntity() != null) {
/* 1857 */           this.rotPartRotation[i] = this.rotPartRotation[i] + ((MCH_AircraftInfo.RotPart)(getAcInfo()).partRotPart.get(i)).rotSpeed;
/* 1858 */           if (this.rotPartRotation[i] < 0.0F) {
/* 1859 */             this.rotPartRotation[i] = this.rotPartRotation[i] + 360.0F;
/*      */           }
/*      */           
/* 1862 */           if (this.rotPartRotation[i] >= 360.0F) {
/* 1863 */             this.rotPartRotation[i] = this.rotPartRotation[i] - 360.0F;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void onRideEntity(Entity ridingEntity) {}
/*      */   
/*      */   public int getAlt(double px, double py, double pz) {
/*      */     int i;
/* 1875 */     for (i = 0; i < 256 && py - i > 0.0D && (py - i >= 256.0D || 0 == W_WorldFunc.getBlockId(this.field_70170_p, (int)px, (int)py - i, (int)pz)); i++);
/*      */ 
/*      */ 
/*      */     
/* 1879 */     return i;
/*      */   }
/*      */   
/*      */   public boolean canRepelling(Entity entity) {
/* 1883 */     return (isRepelling() && this.tickRepelling > 50);
/*      */   }
/*      */   
/*      */   private void onUpdate_Repelling() {
/* 1887 */     if (getAcInfo() != null && getAcInfo().haveRepellingHook()) {
/* 1888 */       if (isRepelling()) {
/* 1889 */         int alt = getAlt(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 1890 */         if (this.ropesLength > -50.0F && this.ropesLength > -alt) {
/* 1891 */           this.ropesLength = (float)(this.ropesLength - (this.field_70170_p.field_72995_K ? 0.30000001192092896D : 0.25D));
/*      */         }
/*      */       } else {
/* 1894 */         this.ropesLength = 0.0F;
/*      */       } 
/*      */     }
/*      */     
/* 1898 */     onUpdate_UnmountCrewRepelling();
/*      */   }
/*      */   
/*      */   private void onUpdate_UnmountCrewRepelling() {
/* 1902 */     if (getAcInfo() != null) {
/* 1903 */       if (!isRepelling()) {
/* 1904 */         this.tickRepelling = 0;
/* 1905 */       } else if (this.tickRepelling < 60) {
/* 1906 */         this.tickRepelling++;
/* 1907 */       } else if (!this.field_70170_p.field_72995_K) {
/* 1908 */         for (int ropeIdx = 0; ropeIdx < (getAcInfo()).repellingHooks.size(); ropeIdx++) {
/* 1909 */           MCH_AircraftInfo.RepellingHook hook = (getAcInfo()).repellingHooks.get(ropeIdx);
/* 1910 */           if (getCountOnUpdate() % hook.interval == 0) {
/* 1911 */             for (int i = 1; i < getSeatNum(); i++) {
/* 1912 */               MCH_EntitySeat seat = getSeat(i);
/* 1913 */               if (seat != null && seat.field_70153_n != null && !W_EntityPlayer.isPlayer(seat.field_70153_n) && !(getSeatInfo(i + 1) instanceof MCH_SeatRackInfo)) {
/* 1914 */                 Entity entity = seat.field_70153_n;
/* 1915 */                 Vec3 dropPos = getTransformedPosition(hook.pos, (Vec3)this.prevPosition.oldest());
/* 1916 */                 seat.field_70165_t = dropPos.field_72450_a;
/* 1917 */                 seat.field_70163_u = dropPos.field_72448_b - 2.0D;
/* 1918 */                 seat.field_70161_v = dropPos.field_72449_c;
/* 1919 */                 entity.func_70078_a((Entity)null);
/* 1920 */                 unmountEntityRepelling(entity, dropPos, ropeIdx);
/* 1921 */                 this.lastUsedRopeIndex = ropeIdx;
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void unmountEntityRepelling(Entity entity, Vec3 dropPos, int ropeIdx) {
/* 1933 */     entity.field_70165_t = dropPos.field_72450_a;
/* 1934 */     entity.field_70163_u = dropPos.field_72448_b - 2.0D;
/* 1935 */     entity.field_70161_v = dropPos.field_72449_c;
/* 1936 */     MCH_EntityHide hideEntity = new MCH_EntityHide(this.field_70170_p, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
/* 1937 */     hideEntity.setParent(this, entity, ropeIdx);
/* 1938 */     hideEntity.field_70159_w = entity.field_70159_w = 0.0D;
/* 1939 */     hideEntity.field_70181_x = entity.field_70181_x = 0.0D;
/* 1940 */     hideEntity.field_70179_y = entity.field_70179_y = 0.0D;
/* 1941 */     hideEntity.field_70143_R = entity.field_70143_R = 0.0F;
/* 1942 */     this.field_70170_p.func_72838_d((Entity)hideEntity);
/*      */   }
/*      */   
/*      */   private void onUpdate_UnmountCrew() {
/* 1946 */     if (getAcInfo() != null && 
/* 1947 */       this.isParachuting) {
/* 1948 */       if (MCH_Lib.getBlockIdY((Entity)this, 3, -10) != 0) {
/* 1949 */         stopUnmountCrew();
/* 1950 */       } else if ((!haveHatch() || getHatchRotation() > 89.0F) && getCountOnUpdate() % (getAcInfo()).mobDropOption.interval == 0 && !unmountCrew(true)) {
/* 1951 */         stopUnmountCrew();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void unmountAircraft() {
/* 1959 */     Vec3 v = Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 1960 */     if (this.field_70154_o instanceof MCH_EntitySeat) {
/* 1961 */       MCH_EntityAircraft ac = ((MCH_EntitySeat)this.field_70154_o).getParent();
/* 1962 */       MCH_SeatInfo seatInfo = ac.getSeatInfo((Entity)this);
/* 1963 */       if (seatInfo instanceof MCH_SeatRackInfo) {
/* 1964 */         v = ((MCH_SeatRackInfo)seatInfo).getEntryPos();
/* 1965 */         v = ac.getTransformedPosition(v);
/*      */       } 
/* 1967 */     } else if (this.field_70154_o instanceof net.minecraft.entity.item.EntityMinecartEmpty) {
/* 1968 */       this.dismountedUserCtrl = true;
/*      */     } 
/*      */     
/* 1971 */     func_70012_b(v.field_72450_a, v.field_72448_b, v.field_72449_c, getRotYaw(), getRotPitch());
/* 1972 */     func_70078_a((Entity)null);
/* 1973 */     func_70012_b(v.field_72450_a, v.field_72448_b, v.field_72449_c, getRotYaw(), getRotPitch());
/*      */   }
/*      */   
/*      */   public boolean canUnmount(Entity entity) {
/* 1977 */     return (getAcInfo() == null) ? false : (!(getAcInfo()).isEnableParachuting ? false : ((getSeatIdByEntity(entity) <= 1) ? false : ((!haveHatch() || getHatchRotation() >= 89.0F))));
/*      */   }
/*      */   
/*      */   public void unmount(Entity entity) {
/* 1981 */     if (getAcInfo() != null)
/*      */     {
/*      */       
/* 1984 */       if (canRepelling(entity) && getAcInfo().haveRepellingHook()) {
/* 1985 */         MCH_EntitySeat seat = getSeatByEntity(entity);
/* 1986 */         if (seat != null) {
/* 1987 */           this.lastUsedRopeIndex = (this.lastUsedRopeIndex + 1) % (getAcInfo()).repellingHooks.size();
/* 1988 */           Vec3 dropPos = getTransformedPosition(((MCH_AircraftInfo.RepellingHook)(getAcInfo()).repellingHooks.get(this.lastUsedRopeIndex)).pos, (Vec3)this.prevPosition.oldest());
/* 1989 */           dropPos = dropPos.func_72441_c(0.0D, -2.0D, 0.0D);
/* 1990 */           seat.field_70165_t = dropPos.field_72450_a;
/* 1991 */           seat.field_70163_u = dropPos.field_72448_b;
/* 1992 */           seat.field_70161_v = dropPos.field_72449_c;
/* 1993 */           entity.func_70078_a((Entity)null);
/* 1994 */           entity.field_70165_t = dropPos.field_72450_a;
/* 1995 */           entity.field_70163_u = dropPos.field_72448_b;
/* 1996 */           entity.field_70161_v = dropPos.field_72449_c;
/* 1997 */           unmountEntityRepelling(entity, dropPos, this.lastUsedRopeIndex);
/*      */         } else {
/* 1999 */           MCH_Lib.Log((Entity)this, "Error:MCH_EntityAircraft.unmount seat=null : " + entity, new Object[0]);
/*      */         } 
/* 2001 */       } else if (canUnmount(entity)) {
/* 2002 */         MCH_EntitySeat seat = getSeatByEntity(entity);
/* 2003 */         if (seat != null) {
/* 2004 */           Vec3 dropPos = getTransformedPosition((getAcInfo()).mobDropOption.pos, (Vec3)this.prevPosition.oldest());
/* 2005 */           seat.field_70165_t = dropPos.field_72450_a;
/* 2006 */           seat.field_70163_u = dropPos.field_72448_b;
/* 2007 */           seat.field_70161_v = dropPos.field_72449_c;
/* 2008 */           entity.func_70078_a((Entity)null);
/* 2009 */           entity.field_70165_t = dropPos.field_72450_a;
/* 2010 */           entity.field_70163_u = dropPos.field_72448_b;
/* 2011 */           entity.field_70161_v = dropPos.field_72449_c;
/* 2012 */           dropEntityParachute(entity);
/*      */         } else {
/* 2014 */           MCH_Lib.Log((Entity)this, "Error:MCH_EntityAircraft.unmount seat=null : " + entity, new Object[0]);
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canParachuting(Entity entity) {
/* 2022 */     return (getAcInfo() != null && (getAcInfo()).isEnableParachuting && getSeatIdByEntity(entity) > 1 && MCH_Lib.getBlockIdY((Entity)this, 3, -13) == 0) ? ((haveHatch() && getHatchRotation() > 89.0F) ? ((getSeatIdByEntity(entity) > 1)) : ((getSeatIdByEntity(entity) > 1))) : false;
/*      */   }
/*      */   
/*      */   public void onUpdate_RidingEntity() {
/* 2026 */     if (!this.field_70170_p.field_72995_K && this.waitMountEntity == 0 && getCountOnUpdate() > 20 && canMountWithNearEmptyMinecart()) {
/* 2027 */       mountWithNearEmptyMinecart();
/*      */     }
/*      */     
/* 2030 */     if (this.waitMountEntity > 0) {
/* 2031 */       this.waitMountEntity--;
/*      */     }
/*      */     
/* 2034 */     if (!this.field_70170_p.field_72995_K && getRidingEntity() != null) {
/* 2035 */       setRotRoll(getRotRoll() * 0.9F);
/* 2036 */       setRotPitch(getRotPitch() * 0.95F);
/* 2037 */       Entity re = getRidingEntity();
/* 2038 */       float target = MathHelper.func_76142_g(re.field_70177_z + 90.0F);
/* 2039 */       if (target - this.field_70177_z > 180.0F) {
/* 2040 */         target -= 360.0F;
/*      */       }
/*      */       
/* 2043 */       if (target - this.field_70177_z < -180.0F) {
/* 2044 */         target += 360.0F;
/*      */       }
/*      */       
/* 2047 */       if (this.field_70173_aa % 2 == 0);
/*      */ 
/*      */ 
/*      */       
/* 2051 */       float dist = 50.0F * (float)re.func_70092_e(re.field_70169_q, re.field_70167_r, re.field_70166_s);
/* 2052 */       if (dist > 0.001D) {
/* 2053 */         dist = MathHelper.func_76133_a(dist);
/* 2054 */         float bkPosX = MCH_Lib.RNG(target - this.field_70177_z, -dist, dist);
/* 2055 */         this.field_70177_z += bkPosX;
/*      */       } 
/*      */       
/* 2058 */       double var10 = this.field_70165_t;
/* 2059 */       double bkPosY = this.field_70163_u;
/* 2060 */       double bkPosZ = this.field_70161_v;
/* 2061 */       if ((getRidingEntity()).field_70128_L) {
/* 2062 */         func_70078_a((Entity)null);
/* 2063 */         this.waitMountEntity = 20;
/* 2064 */       } else if (getCurrentThrottle() > 0.8D) {
/* 2065 */         this.field_70159_w = (getRidingEntity()).field_70159_w;
/* 2066 */         this.field_70181_x = (getRidingEntity()).field_70181_x;
/* 2067 */         this.field_70179_y = (getRidingEntity()).field_70179_y;
/* 2068 */         func_70078_a((Entity)null);
/* 2069 */         this.waitMountEntity = 20;
/*      */       } 
/*      */       
/* 2072 */       this.field_70165_t = var10;
/* 2073 */       this.field_70163_u = bkPosY;
/* 2074 */       this.field_70161_v = bkPosZ;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void explosionByCrash(double prevMotionY) {
/* 2080 */     float exp = (getAcInfo() != null) ? ((getAcInfo()).maxFuel / 400.0F) : 2.0F;
/* 2081 */     if (exp < 1.0F) {
/* 2082 */       exp = 1.0F;
/*      */     }
/*      */     
/* 2085 */     if (exp > 15.0F) {
/* 2086 */       exp = 15.0F;
/*      */     }
/*      */     
/* 2089 */     MCH_Lib.DbgLog(this.field_70170_p, "OnGroundAfterDestroyed:motionY=%.3f", new Object[] { Float.valueOf((float)prevMotionY) });
/* 2090 */     MCH_Explosion.newExplosion(this.field_70170_p, (Entity)null, (Entity)null, this.field_70165_t, this.field_70163_u, this.field_70161_v, exp, (exp >= 2.0F) ? (exp * 0.5F) : 1.0F, true, true, true, true, 5);
/*      */   }
/*      */   
/*      */   public void onUpdate_CollisionGroundDamage() {
/* 2094 */     if (!isDestroyed() && MCH_Lib.getBlockIdY((Entity)this, 3, -3) > 0 && !this.field_70170_p.field_72995_K) {
/* 2095 */       float e = MathHelper.func_76135_e(MathHelper.func_76142_g(getRotRoll()));
/* 2096 */       float e2 = MathHelper.func_76135_e(MathHelper.func_76142_g(getRotPitch()));
/*      */ 
/*      */       
/* 2099 */       if (e > 40.0F || e2 > 40.0F) { float n2; float n; if ((n = ((n2 = MathHelper.func_76135_e(e) + MathHelper.func_76135_e(e2)) < 90.0F) ? (n2 * 0.4F * (float)func_70011_f(this.field_70169_q, this.field_70167_r, this.field_70166_s)) : (n2 * 0.4F)) > 1.0F && this.field_70146_Z.nextInt(4) == 0) {
/* 2100 */           func_70097_a(DamageSource.field_76368_d, n);
/*      */         } }
/*      */     
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public float getGiveDamageRot() {
/* 2110 */     return 40.0F;
/*      */   }
/*      */   
/*      */   public void applyServerPositionAndRotation() {
/* 2114 */     double rpinc = this.aircraftPosRotInc;
/* 2115 */     double yaw = MathHelper.func_76138_g(this.aircraftYaw - getRotYaw());
/* 2116 */     double roll = MathHelper.func_76138_g(getServerRoll() - getRotRoll());
/* 2117 */     if (!isDestroyed() && (!W_Lib.isClientPlayer(getRiddenByEntity()) || getRidingEntity() != null)) {
/* 2118 */       setRotYaw((float)(getRotYaw() + yaw / rpinc));
/* 2119 */       setRotPitch((float)(getRotPitch() + (this.aircraftPitch - getRotPitch()) / rpinc));
/* 2120 */       setRotRoll((float)(getRotRoll() + roll / rpinc));
/*      */     } 
/*      */     
/* 2123 */     func_70107_b(this.field_70165_t + (this.aircraftX - this.field_70165_t) / rpinc, this.field_70163_u + (this.aircraftY - this.field_70163_u) / rpinc, this.field_70161_v + (this.aircraftZ - this.field_70161_v) / rpinc);
/* 2124 */     func_70101_b(getRotYaw(), getRotPitch());
/* 2125 */     this.aircraftPosRotInc--;
/*      */   }
/*      */   
/*      */   protected void autoRepair() {
/* 2129 */     if (this.timeSinceHit > 0) {
/* 2130 */       this.timeSinceHit--;
/*      */     }
/* 2132 */     if (!isDestroyed()) {
/* 2133 */       if (getDamageTaken() > this.beforeDamageTaken) {
/* 2134 */         this.repairCount = 600;
/*      */       }
/* 2136 */       else if (this.repairCount > 0) {
/* 2137 */         this.repairCount--;
/*      */       } else {
/*      */         
/* 2140 */         this.repairCount = 40;
/*      */         int n;
/* 2142 */         if ((n = getMaxHP() / 100) <= 0) {
/* 2143 */           n = 1;
/*      */         }
/* 2145 */         if (getDamageTaken() > 0) {
/* 2146 */           setDamageTaken(getDamageTaken() - n);
/*      */         }
/*      */       } 
/*      */     }
/* 2150 */     this.beforeDamageTaken = getDamageTaken();
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean repair(int tpd) {
/* 2155 */     if (tpd < 1) {
/* 2156 */       tpd = 1;
/*      */     }
/*      */     
/* 2159 */     int damage = getDamageTaken();
/* 2160 */     if (damage > 0) {
/* 2161 */       if (!this.field_70170_p.field_72995_K) {
/* 2162 */         setDamageTaken(damage - tpd);
/*      */       }
/*      */       
/* 2165 */       return true;
/*      */     } 
/* 2167 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void repairOtherAircraft() {
/* 2172 */     float range = (getAcInfo() != null) ? (getAcInfo()).repairOtherVehiclesRange : 0.0F;
/* 2173 */     if (range > 0.0F && 
/* 2174 */       !this.field_70170_p.field_72995_K && getCountOnUpdate() % 20 == 0) {
/* 2175 */       List<MCH_EntityAircraft> list = this.field_70170_p.func_72872_a(MCH_EntityAircraft.class, func_70046_E().func_72314_b(range, range, range));
/*      */       
/* 2177 */       for (int i = 0; i < list.size(); i++) {
/* 2178 */         MCH_EntityAircraft ac = list.get(i);
/* 2179 */         if (!W_Entity.isEqual((Entity)this, (Entity)ac) && ac.getHP() < ac.getMaxHP()) {
/* 2180 */           ac.setDamageTaken(ac.getDamageTaken() - (getAcInfo()).repairOtherVehiclesValue);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void regenerationMob() {
/* 2189 */     if (!isDestroyed() && 
/* 2190 */       !this.field_70170_p.field_72995_K && 
/* 2191 */       getAcInfo() != null && (getAcInfo()).regeneration && getRiddenByEntity() != null) {
/* 2192 */       MCH_EntitySeat[] st = getSeats();
/* 2193 */       MCH_EntitySeat[] arr$ = st;
/* 2194 */       int len$ = st.length;
/*      */       
/* 2196 */       for (int i$ = 0; i$ < len$; i$++) {
/* 2197 */         MCH_EntitySeat s = arr$[i$];
/* 2198 */         if (s != null && !s.field_70128_L) {
/* 2199 */           Entity e = s.field_70153_n;
/* 2200 */           if (W_Lib.isEntityLivingBase(e) && !e.field_70128_L) {
/* 2201 */             PotionEffect pe = W_Entity.getActivePotionEffect(e, Potion.field_76428_l);
/* 2202 */             if (pe == null || (pe != null && pe.func_76459_b() < 500)) {
/* 2203 */               W_Entity.addPotionEffect(e, new PotionEffect(Potion.field_76428_l.field_76415_H, 250, 0, true));
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public double getWaterDepth() {
/* 2215 */     byte b0 = 5;
/* 2216 */     double d0 = 0.0D;
/*      */     
/* 2218 */     for (int i = 0; i < b0; i++) {
/* 2219 */       double d1 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (i + 0) / b0 - 0.125D;
/* 2220 */       double d2 = this.field_70121_D.field_72338_b + (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * (i + 1) / b0 - 0.125D;
/* 2221 */       d1 += (getAcInfo()).floatOffset;
/* 2222 */       d2 += (getAcInfo()).floatOffset;
/* 2223 */       AxisAlignedBB axisalignedbb = W_AxisAlignedBB.getAABB(this.field_70121_D.field_72340_a, d1, this.field_70121_D.field_72339_c, this.field_70121_D.field_72336_d, d2, this.field_70121_D.field_72334_f);
/* 2224 */       if (this.field_70170_p.func_72830_b(axisalignedbb, Material.field_151586_h)) {
/* 2225 */         d0 += 1.0D / b0;
/*      */       }
/*      */     } 
/*      */     
/* 2229 */     return d0;
/*      */   }
/*      */   
/*      */   public int getCountOnUpdate() {
/* 2233 */     return this.countOnUpdate;
/*      */   }
/*      */   
/*      */   public boolean canSupply() {
/* 2237 */     return canFloatWater() ? ((MCH_Lib.getBlockIdY((Entity)this, 1, -3) != 0)) : ((MCH_Lib.getBlockIdY((Entity)this, 1, -3) != 0 && !func_70090_H()));
/*      */   }
/*      */   
/*      */   public void setFuel(int fuel) {
/* 2241 */     if (!this.field_70170_p.field_72995_K) {
/* 2242 */       if (fuel < 0) {
/* 2243 */         fuel = 0;
/*      */       }
/*      */       
/* 2246 */       if (fuel > getMaxFuel()) {
/* 2247 */         fuel = getMaxFuel();
/*      */       }
/*      */       
/* 2250 */       if (fuel != getFuel()) {
/* 2251 */         func_70096_w().func_75692_b(25, Integer.valueOf(fuel));
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getFuel() {
/* 2258 */     return func_70096_w().func_75679_c(25);
/*      */   }
/*      */   
/*      */   public float getFuelP() {
/* 2262 */     int m = getMaxFuel();
/* 2263 */     return (m == 0) ? 0.0F : (getFuel() / m);
/*      */   }
/*      */   
/*      */   public boolean canUseFuel(boolean checkOtherSeet) {
/* 2267 */     return (getMaxFuel() <= 0 || getFuel() > 1 || isInfinityFuel(getRiddenByEntity(), checkOtherSeet));
/*      */   }
/*      */   
/*      */   public boolean canUseFuel() {
/* 2271 */     return canUseFuel(false);
/*      */   }
/*      */   
/*      */   public int getMaxFuel() {
/* 2275 */     return (getAcInfo() != null) ? (getAcInfo()).maxFuel : 0;
/*      */   }
/*      */   
/*      */   public void supplyFuel() {
/* 2279 */     float range = (getAcInfo() != null) ? (getAcInfo()).fuelSupplyRange : 0.0F;
/* 2280 */     if (range > 0.0F && 
/* 2281 */       !this.field_70170_p.field_72995_K && getCountOnUpdate() % 10 == 0) {
/* 2282 */       List<MCH_EntityAircraft> list = this.field_70170_p.func_72872_a(MCH_EntityAircraft.class, func_70046_E().func_72314_b(range, range, range));
/*      */       
/* 2284 */       for (int i = 0; i < list.size(); i++) {
/* 2285 */         MCH_EntityAircraft ac = list.get(i);
/* 2286 */         if (!W_Entity.isEqual((Entity)this, (Entity)ac)) {
/* 2287 */           if ((!this.field_70122_E || ac.canSupply()) && ac.getFuel() < ac.getMaxFuel()) {
/* 2288 */             int fc = ac.getMaxFuel() - ac.getFuel();
/* 2289 */             if (fc > 30) {
/* 2290 */               fc = 30;
/*      */             }
/*      */             
/* 2293 */             ac.setFuel(ac.getFuel() + fc);
/*      */           } 
/*      */           
/* 2296 */           ac.fuelSuppliedCount = 40;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateFuel() {
/* 2305 */     if (getMaxFuel() != 0) {
/* 2306 */       if (this.fuelSuppliedCount > 0) {
/* 2307 */         this.fuelSuppliedCount--;
/*      */       }
/*      */       
/* 2310 */       if (!isDestroyed() && !this.field_70170_p.field_72995_K) {
/* 2311 */         if (getCountOnUpdate() % 20 == 0 && getFuel() > 1 && getThrottle() > 0.0D && this.fuelSuppliedCount <= 0) {
/* 2312 */           double curFuel = getThrottle() * 1.4D;
/* 2313 */           if (curFuel > 1.0D) {
/* 2314 */             curFuel = 1.0D;
/*      */           }
/*      */           
/* 2317 */           this.fuelConsumption += curFuel * (getAcInfo()).fuelConsumption * getFuelConsumptionFactor();
/* 2318 */           if (this.fuelConsumption > 1.0D) {
/* 2319 */             int fuel = (int)this.fuelConsumption;
/* 2320 */             this.fuelConsumption -= fuel;
/* 2321 */             setFuel(getFuel() - fuel);
/*      */           } 
/*      */         } 
/*      */         
/* 2325 */         int var5 = getFuel();
/* 2326 */         if (canSupply() && getCountOnUpdate() % 10 == 0 && var5 < getMaxFuel()) {
/* 2327 */           for (int i = 0; i < 3; i++) {
/* 2328 */             if (var5 < getMaxFuel()) {
/* 2329 */               ItemStack var6 = getGuiInventory().getFuelSlotItemStack(i);
/* 2330 */               if (var6 != null && var6.func_77973_b() instanceof MCH_ItemFuel && var6.func_77960_j() < var6.func_77958_k()) {
/* 2331 */                 int fc = getMaxFuel() - var5;
/* 2332 */                 if (fc > 100) {
/* 2333 */                   fc = 100;
/*      */                 }
/*      */                 
/* 2336 */                 if (var6.func_77960_j() > var6.func_77958_k() - fc) {
/* 2337 */                   fc = var6.func_77958_k() - var6.func_77960_j();
/*      */                 }
/*      */                 
/* 2340 */                 var6.func_77964_b(var6.func_77960_j() + fc);
/* 2341 */                 var5 += fc;
/*      */               } 
/*      */             } 
/*      */           } 
/*      */ 
/*      */           
/* 2347 */           setFuel(var5);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public float getFuelConsumptionFactor() {
/* 2355 */     return 1.0F;
/*      */   }
/*      */   
/*      */   public void updateSupplyAmmo() {
/* 2359 */     if (!this.field_70170_p.field_72995_K) {
/* 2360 */       boolean isReloading = false;
/* 2361 */       if (getRiddenByEntity() instanceof EntityPlayer && !(getRiddenByEntity()).field_70128_L && ((EntityPlayer)getRiddenByEntity()).field_71070_bA instanceof MCH_AircraftGuiContainer) {
/* 2362 */         isReloading = true;
/*      */       }
/*      */       
/* 2365 */       setCommonStatus(2, isReloading);
/* 2366 */       if (!isDestroyed() && this.beforeSupplyAmmo && !isReloading) {
/* 2367 */         reloadAllWeapon();
/* 2368 */         MCH_PacketNotifyAmmoNum.sendAllAmmoNum(this, (EntityPlayer)null);
/*      */       } 
/*      */       
/* 2371 */       this.beforeSupplyAmmo = isReloading;
/*      */     } 
/*      */     
/* 2374 */     if (getCommonStatus(2)) {
/* 2375 */       this.supplyAmmoWait = 20;
/*      */     }
/*      */     
/* 2378 */     if (this.supplyAmmoWait > 0) {
/* 2379 */       this.supplyAmmoWait--;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void supplyAmmo(int weaponID) {
/* 2385 */     if (this.field_70170_p.field_72995_K) {
/* 2386 */       MCH_WeaponSet player = getWeapon(weaponID);
/* 2387 */       player.supplyRestAllAmmo();
/*      */     }
/* 2389 */     else if (getRiddenByEntity() instanceof EntityPlayer) {
/* 2390 */       EntityPlayer var9 = (EntityPlayer)getRiddenByEntity();
/* 2391 */       if (canPlayerSupplyAmmo(var9, weaponID)) {
/* 2392 */         MCH_WeaponSet ws = getWeapon(weaponID);
/* 2393 */         Iterator<MCH_WeaponInfo.RoundItem> i$ = (ws.getInfo()).roundItems.iterator();
/*      */         
/* 2395 */         while (i$.hasNext()) {
/* 2396 */           MCH_WeaponInfo.RoundItem ri = i$.next();
/* 2397 */           int num = ri.num;
/*      */           
/* 2399 */           for (int i = 0; i < var9.field_71071_by.field_70462_a.length; i++) {
/* 2400 */             ItemStack itemStack = var9.field_71071_by.field_70462_a[i];
/* 2401 */             if (itemStack != null && itemStack.func_77969_a(ri.itemStack)) {
/* 2402 */               if (itemStack.func_77973_b() != W_Item.getItemByName("water_bucket") && itemStack.func_77973_b() != W_Item.getItemByName("lava_bucket")) {
/* 2403 */                 if (itemStack.field_77994_a > num) {
/* 2404 */                   itemStack.field_77994_a -= num;
/* 2405 */                   num = 0;
/*      */                 } else {
/* 2407 */                   num -= itemStack.field_77994_a;
/* 2408 */                   itemStack.field_77994_a = 0;
/* 2409 */                   var9.field_71071_by.field_70462_a[i] = null;
/*      */                 } 
/* 2411 */               } else if (itemStack.field_77994_a == 1) {
/* 2412 */                 var9.field_71071_by.func_70299_a(i, new ItemStack(W_Item.getItemByName("bucket"), 1));
/* 2413 */                 num--;
/*      */               } 
/*      */             }
/*      */             
/* 2417 */             if (num <= 0) {
/*      */               break;
/*      */             }
/*      */           } 
/*      */         } 
/*      */         
/* 2423 */         ws.supplyRestAllAmmo();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void supplyAmmoToOtherAircraft() {
/* 2431 */     float range = (getAcInfo() != null) ? (getAcInfo()).ammoSupplyRange : 0.0F;
/* 2432 */     if (range > 0.0F && 
/* 2433 */       !this.field_70170_p.field_72995_K && getCountOnUpdate() % 40 == 0) {
/* 2434 */       List<MCH_EntityAircraft> list = this.field_70170_p.func_72872_a(MCH_EntityAircraft.class, func_70046_E().func_72314_b(range, range, range));
/*      */       
/* 2436 */       for (int i = 0; i < list.size(); i++) {
/* 2437 */         MCH_EntityAircraft ac = list.get(i);
/* 2438 */         if (!W_Entity.isEqual((Entity)this, (Entity)ac) && ac.canSupply()) {
/* 2439 */           for (int wid = 0; wid < ac.getWeaponNum(); wid++) {
/* 2440 */             MCH_WeaponSet ws = ac.getWeapon(wid);
/* 2441 */             int num = ws.getRestAllAmmoNum() + ws.getAmmoNum();
/* 2442 */             if (num < ws.getAllAmmoNum()) {
/* 2443 */               int ammo = ws.getAllAmmoNum() / 10;
/* 2444 */               if (ammo < 1) {
/* 2445 */                 ammo = 1;
/*      */               }
/*      */               
/* 2448 */               ws.setRestAllAmmoNum(num + ammo);
/* 2449 */               EntityPlayer player = ac.getEntityByWeaponId(wid);
/* 2450 */               if (num != ws.getRestAllAmmoNum() + ws.getAmmoNum()) {
/* 2451 */                 if (ws.getAmmoNum() <= 0) {
/* 2452 */                   ws.reloadMag();
/*      */                 }
/*      */                 
/* 2455 */                 MCH_PacketNotifyAmmoNum.sendAmmoNum(ac, player, wid);
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canPlayerSupplyAmmo(EntityPlayer player, int weaponId) {
/* 2467 */     if (MCH_Lib.getBlockIdY((Entity)this, 1, -3) == 0)
/* 2468 */       return false; 
/* 2469 */     if (!canSupply()) {
/* 2470 */       return false;
/*      */     }
/* 2472 */     MCH_WeaponSet ws = getWeapon(weaponId);
/* 2473 */     if (ws.getRestAllAmmoNum() + ws.getAmmoNum() >= ws.getAllAmmoNum()) {
/* 2474 */       return false;
/*      */     }
/* 2476 */     Iterator<MCH_WeaponInfo.RoundItem> i$ = (ws.getInfo()).roundItems.iterator();
/*      */     
/* 2478 */     while (i$.hasNext()) {
/* 2479 */       MCH_WeaponInfo.RoundItem ri = i$.next();
/* 2480 */       int num = ri.num;
/* 2481 */       ItemStack[] arr$ = player.field_71071_by.field_70462_a;
/* 2482 */       int len$ = arr$.length;
/* 2483 */       int i$1 = 0;
/*      */ 
/*      */       
/* 2486 */       while (i$1 < len$) {
/* 2487 */         ItemStack itemStack = arr$[i$1];
/* 2488 */         if (itemStack != null && itemStack.func_77969_a(ri.itemStack)) {
/* 2489 */           num -= itemStack.field_77994_a;
/*      */         }
/*      */         
/* 2492 */         if (num > 0) {
/* 2493 */           i$1++;
/*      */         }
/*      */       } 
/*      */ 
/*      */       
/* 2498 */       if (num > 0) {
/* 2499 */         return false;
/*      */       }
/*      */     } 
/*      */ 
/*      */ 
/*      */     
/* 2505 */     return true;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public MCH_EntityAircraft setTextureName(String name) {
/* 2511 */     if (name != null && !name.isEmpty()) {
/* 2512 */       func_70096_w().func_75692_b(21, String.valueOf(name));
/*      */     }
/*      */     
/* 2515 */     return this;
/*      */   }
/*      */   
/*      */   public String getTextureName() {
/* 2519 */     return func_70096_w().func_75681_e(21);
/*      */   }
/*      */   
/*      */   public void switchNextTextureName() {
/* 2523 */     if (getAcInfo() != null) {
/* 2524 */       setTextureName(getAcInfo().getNextTextureName(getTextureName()));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void zoomCamera() {
/* 2530 */     if (canZoom()) {
/* 2531 */       float z = this.camera.getCameraZoom();
/* 2532 */       if (z >= getZoomMax() - 0.01D) {
/* 2533 */         z = 1.0F;
/*      */       } else {
/* 2535 */         z *= 2.0F;
/* 2536 */         if (z >= getZoomMax()) {
/* 2537 */           z = getZoomMax();
/*      */         }
/*      */       } 
/*      */       
/* 2541 */       this.camera.setCameraZoom((z <= getZoomMax() + 0.01D) ? z : 1.0F);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getZoomMax() {
/* 2547 */     return (getAcInfo() != null) ? (getAcInfo()).cameraZoom : 1;
/*      */   }
/*      */   
/*      */   public boolean canZoom() {
/* 2551 */     return (getZoomMax() > 1);
/*      */   }
/*      */   
/*      */   public boolean canSwitchCameraMode() {
/* 2555 */     return isDestroyed() ? false : ((getAcInfo() != null && (getAcInfo()).isEnableNightVision));
/*      */   }
/*      */   
/*      */   public boolean canSwitchCameraMode(int seatID) {
/* 2559 */     return isDestroyed() ? false : ((canSwitchCameraMode() && this.camera.isValidUid(seatID)));
/*      */   }
/*      */   
/*      */   public int getCameraMode(EntityPlayer player) {
/* 2563 */     return this.camera.getMode(getSeatIdByEntity((Entity)player));
/*      */   }
/*      */   
/*      */   public String getCameraModeName(EntityPlayer player) {
/* 2567 */     return this.camera.getModeName(getSeatIdByEntity((Entity)player));
/*      */   }
/*      */   
/*      */   public void switchCameraMode(EntityPlayer player) {
/* 2571 */     switchCameraMode(player, this.camera.getMode(getSeatIdByEntity((Entity)player)) + 1);
/*      */   }
/*      */   
/*      */   public void switchCameraMode(EntityPlayer player, int mode) {
/* 2575 */     this.camera.setMode(getSeatIdByEntity((Entity)player), mode);
/*      */   }
/*      */   
/*      */   public void updateCameraViewers() {
/* 2579 */     for (int i = 0; i < getSeatNum() + 1; i++) {
/* 2580 */       this.camera.updateViewer(i, getEntityBySeatId(i));
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateRadar(int radarSpeed) {
/* 2586 */     if (isEntityRadarMounted()) {
/* 2587 */       this.radarRotate += radarSpeed;
/* 2588 */       if (this.radarRotate >= 360) {
/* 2589 */         this.radarRotate = 0;
/*      */       }
/*      */       
/* 2592 */       if (this.radarRotate == 0) {
/* 2593 */         this.entityRadar.updateXZ((Entity)this, 196);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getRadarRotate() {
/* 2600 */     return this.radarRotate;
/*      */   }
/*      */   
/*      */   public void initRadar() {
/* 2604 */     this.entityRadar.clear();
/* 2605 */     this.radarRotate = 0;
/*      */   }
/*      */   
/*      */   public ArrayList getRadarEntityList() {
/* 2609 */     return this.entityRadar.getEntityList();
/*      */   }
/*      */   
/*      */   public ArrayList getRadarEnemyList() {
/* 2613 */     return this.entityRadar.getEnemyList();
/*      */   }
/*      */   
/*      */   public void func_70091_d(double par1, double par3, double par5) {
/* 2617 */     if (getAcInfo() != null) {
/* 2618 */       this.field_70170_p.field_72984_F.func_76320_a("move");
/* 2619 */       this.field_70139_V *= 0.4F;
/* 2620 */       double d3 = this.field_70165_t;
/* 2621 */       double d4 = this.field_70163_u;
/* 2622 */       double d5 = this.field_70161_v;
/* 2623 */       double d6 = par1;
/* 2624 */       double d7 = par3;
/* 2625 */       double d8 = par5;
/* 2626 */       AxisAlignedBB axisalignedbb = this.field_70121_D.func_72329_c();
/* 2627 */       List<AxisAlignedBB> list = getCollidingBoundingBoxes((Entity)this, this.field_70121_D.func_72321_a(par1, par3, par5));
/*      */       
/* 2629 */       for (int flag1 = 0; flag1 < list.size(); flag1++) {
/* 2630 */         par3 = ((AxisAlignedBB)list.get(flag1)).func_72323_b(this.field_70121_D, par3);
/*      */       }
/*      */       
/* 2633 */       this.field_70121_D.func_72317_d(0.0D, par3, 0.0D);
/* 2634 */       if (!this.field_70135_K && d7 != par3) {
/* 2635 */         par5 = 0.0D;
/* 2636 */         par3 = 0.0D;
/* 2637 */         par1 = 0.0D;
/*      */       } 
/*      */       
/* 2640 */       boolean var34 = (this.field_70122_E || (d7 != par3 && d7 < 0.0D));
/*      */       
/*      */       int j;
/* 2643 */       for (j = 0; j < list.size(); j++) {
/* 2644 */         par1 = ((AxisAlignedBB)list.get(j)).func_72316_a(this.field_70121_D, par1);
/*      */       }
/*      */       
/* 2647 */       this.field_70121_D.func_72317_d(par1, 0.0D, 0.0D);
/* 2648 */       if (!this.field_70135_K && d6 != par1) {
/* 2649 */         par5 = 0.0D;
/* 2650 */         par3 = 0.0D;
/* 2651 */         par1 = 0.0D;
/*      */       } 
/*      */       
/* 2654 */       for (j = 0; j < list.size(); j++) {
/* 2655 */         par5 = ((AxisAlignedBB)list.get(j)).func_72322_c(this.field_70121_D, par5);
/*      */       }
/*      */       
/* 2658 */       this.field_70121_D.func_72317_d(0.0D, 0.0D, par5);
/* 2659 */       if (!this.field_70135_K && d8 != par5) {
/* 2660 */         par5 = 0.0D;
/* 2661 */         par3 = 0.0D;
/* 2662 */         par1 = 0.0D;
/*      */       } 
/*      */       
/* 2665 */       if (this.field_70138_W > 0.0F && var34 && this.field_70139_V < 0.05F && (d6 != par1 || d8 != par5)) {
/* 2666 */         double d12 = par1;
/* 2667 */         double d10 = par3;
/* 2668 */         double d11 = par5;
/* 2669 */         par1 = d6;
/* 2670 */         par3 = this.field_70138_W;
/* 2671 */         par5 = d8;
/* 2672 */         AxisAlignedBB throwable = this.field_70121_D.func_72329_c();
/* 2673 */         this.field_70121_D.func_72328_c(axisalignedbb);
/* 2674 */         list = getCollidingBoundingBoxes((Entity)this, this.field_70121_D.func_72321_a(d6, par3, d8));
/*      */         
/*      */         int k;
/* 2677 */         for (k = 0; k < list.size(); k++) {
/* 2678 */           par3 = ((AxisAlignedBB)list.get(k)).func_72323_b(this.field_70121_D, par3);
/*      */         }
/*      */         
/* 2681 */         this.field_70121_D.func_72317_d(0.0D, par3, 0.0D);
/* 2682 */         if (!this.field_70135_K && d7 != par3) {
/* 2683 */           par5 = 0.0D;
/* 2684 */           par3 = 0.0D;
/* 2685 */           par1 = 0.0D;
/*      */         } 
/*      */         
/* 2688 */         for (k = 0; k < list.size(); k++) {
/* 2689 */           par1 = ((AxisAlignedBB)list.get(k)).func_72316_a(this.field_70121_D, par1);
/*      */         }
/*      */         
/* 2692 */         this.field_70121_D.func_72317_d(par1, 0.0D, 0.0D);
/* 2693 */         if (!this.field_70135_K && d6 != par1) {
/* 2694 */           par5 = 0.0D;
/* 2695 */           par3 = 0.0D;
/* 2696 */           par1 = 0.0D;
/*      */         } 
/*      */         
/* 2699 */         for (k = 0; k < list.size(); k++) {
/* 2700 */           par5 = ((AxisAlignedBB)list.get(k)).func_72322_c(this.field_70121_D, par5);
/*      */         }
/*      */         
/* 2703 */         this.field_70121_D.func_72317_d(0.0D, 0.0D, par5);
/* 2704 */         if (!this.field_70135_K && d8 != par5) {
/* 2705 */           par5 = 0.0D;
/* 2706 */           par3 = 0.0D;
/* 2707 */           par1 = 0.0D;
/*      */         } 
/*      */         
/* 2710 */         if (!this.field_70135_K && d7 != par3) {
/* 2711 */           par5 = 0.0D;
/* 2712 */           par3 = 0.0D;
/* 2713 */           par1 = 0.0D;
/*      */         } else {
/* 2715 */           par3 = -this.field_70138_W;
/*      */           
/* 2717 */           for (k = 0; k < list.size(); k++) {
/* 2718 */             par3 = ((AxisAlignedBB)list.get(k)).func_72323_b(this.field_70121_D, par3);
/*      */           }
/*      */           
/* 2721 */           this.field_70121_D.func_72317_d(0.0D, par3, 0.0D);
/*      */         } 
/*      */         
/* 2724 */         if (d12 * d12 + d11 * d11 >= par1 * par1 + par5 * par5) {
/* 2725 */           par1 = d12;
/* 2726 */           par3 = d10;
/* 2727 */           par5 = d11;
/* 2728 */           this.field_70121_D.func_72328_c(throwable);
/*      */         } 
/*      */       } 
/*      */       
/* 2732 */       this.field_70170_p.field_72984_F.func_76319_b();
/* 2733 */       this.field_70170_p.field_72984_F.func_76320_a("rest");
/* 2734 */       this.field_70165_t = (this.field_70121_D.field_72340_a + this.field_70121_D.field_72336_d) / 2.0D;
/* 2735 */       this.field_70163_u = this.field_70121_D.field_72338_b + this.field_70129_M - this.field_70139_V;
/* 2736 */       this.field_70161_v = (this.field_70121_D.field_72339_c + this.field_70121_D.field_72334_f) / 2.0D;
/* 2737 */       this.field_70123_F = (d6 != par1 || d8 != par5);
/* 2738 */       this.field_70124_G = (d7 != par3);
/* 2739 */       this.field_70122_E = (d7 != par3 && d7 < 0.0D);
/* 2740 */       this.field_70132_H = (this.field_70123_F || this.field_70124_G);
/* 2741 */       func_70064_a(par3, this.field_70122_E);
/* 2742 */       if (d6 != par1) {
/* 2743 */         this.field_70159_w = 0.0D;
/*      */       }
/*      */       
/* 2746 */       if (d7 != par3) {
/* 2747 */         this.field_70181_x = 0.0D;
/*      */       }
/*      */       
/* 2750 */       if (d8 != par5) {
/* 2751 */         this.field_70179_y = 0.0D;
/*      */       }
/*      */       
/* 2754 */       double var10000 = this.field_70165_t - d3;
/* 2755 */       var10000 = this.field_70163_u - d4;
/* 2756 */       var10000 = this.field_70161_v - d5;
/*      */       
/*      */       try {
/* 2759 */         doBlockCollisions();
/* 2760 */       } catch (Throwable var33) {
/* 2761 */         CrashReport crashreport = CrashReport.func_85055_a(var33, "Checking entity tile collision");
/* 2762 */         CrashReportCategory crashreportcategory = crashreport.func_85058_a("Entity being checked for collision");
/* 2763 */         func_85029_a(crashreportcategory);
/* 2764 */         throw new ReportedException(crashreport);
/*      */       } 
/*      */       
/* 2767 */       this.field_70170_p.field_72984_F.func_76319_b();
/*      */     } 
/*      */   }
/*      */   
/*      */   public static List getCollidingBoundingBoxes(Entity par1Entity, AxisAlignedBB par2AxisAlignedBB) {
/* 2772 */     ArrayList<AxisAlignedBB> collidingBoundingBoxes = new ArrayList();
/* 2773 */     collidingBoundingBoxes.clear();
/* 2774 */     int i = MathHelper.func_76128_c(par2AxisAlignedBB.field_72340_a);
/* 2775 */     int j = MathHelper.func_76128_c(par2AxisAlignedBB.field_72336_d + 1.0D);
/* 2776 */     int k = MathHelper.func_76128_c(par2AxisAlignedBB.field_72338_b);
/* 2777 */     int l = MathHelper.func_76128_c(par2AxisAlignedBB.field_72337_e + 1.0D);
/* 2778 */     int i1 = MathHelper.func_76128_c(par2AxisAlignedBB.field_72339_c);
/* 2779 */     int j1 = MathHelper.func_76128_c(par2AxisAlignedBB.field_72334_f + 1.0D);
/*      */     
/* 2781 */     for (int d0 = i; d0 < j; d0++) {
/* 2782 */       for (int l1 = i1; l1 < j1; l1++) {
/* 2783 */         if (par1Entity.field_70170_p.func_72899_e(d0, 64, l1)) {
/* 2784 */           for (int list = k - 1; list < l; list++) {
/* 2785 */             Block j2 = W_WorldFunc.getBlock(par1Entity.field_70170_p, d0, list, l1);
/* 2786 */             if (j2 != null) {
/* 2787 */               j2.func_149743_a(par1Entity.field_70170_p, d0, list, l1, par2AxisAlignedBB, collidingBoundingBoxes, par1Entity);
/*      */             }
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2794 */     double var15 = 0.25D;
/* 2795 */     List<Entity> var16 = par1Entity.field_70170_p.func_72839_b(par1Entity, par2AxisAlignedBB.func_72314_b(var15, var15, var15));
/*      */     
/* 2797 */     for (int var17 = 0; var17 < var16.size(); var17++) {
/* 2798 */       Entity entity = var16.get(var17);
/* 2799 */       if (!W_Lib.isEntityLivingBase(entity) && !(entity instanceof MCH_EntitySeat) && !(entity instanceof MCH_EntityHitBox) && entity instanceof EntityPlayer) {
/* 2800 */         AxisAlignedBB axisalignedbb1 = entity.func_70046_E();
/* 2801 */         if (axisalignedbb1 != null && axisalignedbb1.func_72326_a(par2AxisAlignedBB)) {
/* 2802 */           collidingBoundingBoxes.add(axisalignedbb1);
/*      */         }
/*      */         
/* 2805 */         axisalignedbb1 = par1Entity.func_70114_g(entity);
/* 2806 */         if (axisalignedbb1 != null && axisalignedbb1.func_72326_a(par2AxisAlignedBB)) {
/* 2807 */           collidingBoundingBoxes.add(axisalignedbb1);
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 2812 */     return collidingBoundingBoxes;
/*      */   }
/*      */   
/*      */   protected void onUpdate_updateBlock() {
/* 2816 */     MCH_Config var10000 = MCH_MOD.config;
/* 2817 */     if (MCH_Config.Collision_DestroyBlock.prmBool) {
/* 2818 */       for (int l = 0; l < 4; l++) {
/* 2819 */         int i1 = MathHelper.func_76128_c(this.field_70165_t + ((l % 2) - 0.5D) * 0.8D);
/* 2820 */         int j1 = MathHelper.func_76128_c(this.field_70161_v + ((l / 2) - 0.5D) * 0.8D);
/*      */         
/* 2822 */         for (int k1 = 0; k1 < 2; k1++) {
/* 2823 */           int l1 = MathHelper.func_76128_c(this.field_70163_u) + k1;
/* 2824 */           Block block = W_WorldFunc.getBlock(this.field_70170_p, i1, l1, j1);
/* 2825 */           if (!W_Block.isNull(block)) {
/* 2826 */             if (block == W_Block.getSnowLayer()) {
/* 2827 */               this.field_70170_p.func_147468_f(i1, l1, j1);
/*      */             }
/*      */             
/* 2830 */             if (block == Blocks.field_150392_bi || block == Blocks.field_150414_aQ) {
/* 2831 */               W_WorldFunc.destroyBlock(this.field_70170_p, i1, l1, j1, false);
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void onUpdate_ParticleSmoke() {
/* 2841 */     if (this.field_70170_p.field_72995_K && 
/* 2842 */       getCurrentThrottle() > 0.10000000149011612D) {
/* 2843 */       float yaw = getRotYaw();
/* 2844 */       float pitch = getRotPitch();
/* 2845 */       float roll = getRotRoll();
/* 2846 */       MCH_WeaponSet ws = getCurrentWeapon(getRiddenByEntity());
/* 2847 */       if (ws.getFirstWeapon() instanceof mcheli.weapon.MCH_WeaponSmoke) {
/* 2848 */         for (int i = 0; i < ws.getWeaponNum(); i++) {
/* 2849 */           MCH_WeaponBase wb = ws.getWeapon(i);
/* 2850 */           if (wb != null) {
/* 2851 */             MCH_WeaponInfo wi = wb.getInfo();
/* 2852 */             if (wi != null) {
/* 2853 */               Vec3 rot = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -yaw - 180.0F + wb.fixRotationYaw, pitch - wb.fixRotationPitch, roll);
/* 2854 */               if (this.field_70146_Z.nextFloat() <= getCurrentThrottle() * 1.5D) {
/* 2855 */                 Vec3 pos = MCH_Lib.RotVec3(wb.position, -yaw, -pitch, -roll);
/* 2856 */                 double x = this.field_70165_t + pos.field_72450_a + rot.field_72450_a;
/* 2857 */                 double y = this.field_70163_u + pos.field_72448_b + rot.field_72448_b;
/* 2858 */                 double z = this.field_70161_v + pos.field_72449_c + rot.field_72449_c;
/*      */                 
/* 2860 */                 for (int smk = 0; smk < wi.smokeNum; smk++) {
/* 2861 */                   float c = this.field_70146_Z.nextFloat() * 0.05F;
/* 2862 */                   int maxAge = (int)(this.field_70146_Z.nextDouble() * wi.smokeMaxAge);
/* 2863 */                   MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", x, y, z);
/* 2864 */                   prm.setMotion(rot.field_72450_a * wi.acceleration + (this.field_70146_Z.nextDouble() - 0.5D) * 0.2D, rot.field_72448_b * wi.acceleration + (this.field_70146_Z.nextDouble() - 0.5D) * 0.2D, rot.field_72449_c * wi.acceleration + (this.field_70146_Z.nextDouble() - 0.5D) * 0.2D);
/* 2865 */                   prm.size = (this.field_70146_Z.nextInt(5) + 5.0F) * wi.smokeSize;
/* 2866 */                   prm.setColor(wi.color.a + this.field_70146_Z.nextFloat() * 0.05F, wi.color.r + c, wi.color.g + c, wi.color.b + c);
/* 2867 */                   prm.age = maxAge;
/* 2868 */                   prm.toWhite = true;
/* 2869 */                   prm.diffusible = true;
/* 2870 */                   MCH_ParticlesUtil.spawnParticle(prm);
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   protected void onUpdate_ParticleSandCloud(boolean seaOnly) {
/* 2883 */     if (!seaOnly || (getAcInfo()).enableSeaSurfaceParticle) {
/* 2884 */       double particlePosY = (int)this.field_70163_u;
/* 2885 */       boolean b = false;
/* 2886 */       float scale = (getAcInfo()).particlesScale * 3.0F;
/* 2887 */       if (seaOnly) {
/* 2888 */         scale *= 2.0F;
/*      */       }
/*      */       
/* 2891 */       double throttle = getCurrentThrottle();
/* 2892 */       throttle *= 2.0D;
/* 2893 */       if (throttle > 1.0D) {
/* 2894 */         throttle = 1.0D;
/*      */       }
/*      */       
/* 2897 */       int count = seaOnly ? (int)(scale * 7.0F) : 0;
/* 2898 */       int rangeY = (int)(scale * 10.0F) + 1;
/*      */       
/*      */       int y;
/* 2901 */       for (y = 0; y < rangeY && !b; y++) {
/* 2902 */         int pn = -1;
/*      */         
/* 2904 */         while (pn <= 1) {
/* 2905 */           int z = -1;
/*      */ 
/*      */           
/* 2908 */           while (z <= 1) {
/*      */             
/* 2910 */             Block k = W_WorldFunc.getBlock(this.field_70170_p, (int)(this.field_70165_t + 0.5D) + pn, (int)(this.field_70163_u + 0.5D) - y, (int)(this.field_70161_v + 0.5D) + z);
/* 2911 */             if (!b && k != null && !Block.func_149680_a(k, Blocks.field_150350_a)) {
/* 2912 */               if (seaOnly && W_Block.isEqual(k, W_Block.getWater())) {
/* 2913 */                 count--;
/*      */               }
/*      */               
/* 2916 */               if (count <= 0) {
/* 2917 */                 particlePosY = this.field_70163_u + 1.0D + (scale / 5.0F) - y;
/* 2918 */                 b = true;
/* 2919 */                 pn += 100;
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/* 2924 */             z++;
/*      */           } 
/*      */ 
/*      */ 
/*      */           
/* 2929 */           pn++;
/*      */         } 
/*      */       } 
/*      */ 
/*      */ 
/*      */       
/* 2935 */       double var20 = (rangeY - y + 1) / 5.0D * scale / 2.0D;
/* 2936 */       if (b && (getAcInfo()).particlesScale > 0.01F) {
/* 2937 */         for (int var21 = 0; var21 < (int)(throttle * 6.0D * var20); var21++) {
/* 2938 */           float r = (float)(this.field_70146_Z.nextDouble() * Math.PI * 2.0D);
/* 2939 */           double dx = MathHelper.func_76134_b(r);
/* 2940 */           double dz = MathHelper.func_76126_a(r);
/* 2941 */           MCH_ParticleParam prm = new MCH_ParticleParam(this.field_70170_p, "smoke", this.field_70165_t + dx * scale * 3.0D, particlePosY + (this.field_70146_Z.nextDouble() - 0.5D) * scale, this.field_70161_v + dz * scale * 3.0D, scale * dx * 0.3D, scale * -0.4D * 0.05D, scale * dz * 0.3D, scale * 5.0F);
/* 2942 */           prm.setColor(prm.a * 0.6F, prm.r, prm.g, prm.b);
/* 2943 */           prm.age = (int)(10.0F * scale);
/* 2944 */           prm.motionYUpAge = seaOnly ? 0.2F : 0.1F;
/* 2945 */           MCH_ParticlesUtil.spawnParticle(prm);
/*      */         } 
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected boolean func_70041_e_() {
/* 2953 */     return false;
/*      */   }
/*      */   
/*      */   public AxisAlignedBB func_70114_g(Entity par1Entity) {
/* 2957 */     return par1Entity.field_70121_D;
/*      */   }
/*      */   
/*      */   public AxisAlignedBB func_70046_E() {
/* 2961 */     return this.field_70121_D;
/*      */   }
/*      */   
/*      */   public boolean func_70104_M() {
/* 2965 */     return false;
/*      */   }
/*      */   
/*      */   public double func_70042_X() {
/* 2969 */     return 0.0D;
/*      */   }
/*      */   
/*      */   public float func_70053_R() {
/* 2973 */     return 2.0F;
/*      */   }
/*      */   
/*      */   public boolean func_70067_L() {
/* 2977 */     return !this.field_70128_L;
/*      */   }
/*      */   
/*      */   public boolean useFlare(int type) {
/* 2981 */     if (getAcInfo() != null && getAcInfo().haveFlare()) {
/* 2982 */       int[] arr$ = (getAcInfo()).flare.types;
/* 2983 */       int len$ = arr$.length;
/*      */       
/* 2985 */       for (int i$ = 0; i$ < len$; i$++) {
/* 2986 */         int i = arr$[i$];
/* 2987 */         if (i == type) {
/* 2988 */           setCommonStatus(0, true);
/* 2989 */           if (this.flareDv.use(type)) {
/* 2990 */             return true;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 2995 */       return false;
/*      */     } 
/* 2997 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getCurrentFlareType() {
/* 3002 */     return !haveFlare() ? 0 : (getAcInfo()).flare.types[this.currentFlareIndex];
/*      */   }
/*      */   
/*      */   public void nextFlareType() {
/* 3006 */     if (haveFlare()) {
/* 3007 */       this.currentFlareIndex = (this.currentFlareIndex + 1) % (getAcInfo()).flare.types.length;
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canUseFlare() {
/* 3013 */     return (getAcInfo() != null && getAcInfo().haveFlare()) ? (getCommonStatus(0) ? false : ((this.flareDv.tick == 0))) : false;
/*      */   }
/*      */   
/*      */   public boolean isFlarePreparation() {
/* 3017 */     return this.flareDv.isInPreparation();
/*      */   }
/*      */   
/*      */   public boolean isFlareUsing() {
/* 3021 */     return this.flareDv.isUsing();
/*      */   }
/*      */   
/*      */   public int getFlareTick() {
/* 3025 */     return this.flareDv.tick;
/*      */   }
/*      */   
/*      */   public boolean haveFlare() {
/* 3029 */     return (getAcInfo() != null && getAcInfo().haveFlare());
/*      */   }
/*      */   
/*      */   public boolean haveFlare(int seatID) {
/* 3033 */     return (haveFlare() && seatID >= 0 && seatID <= 1);
/*      */   }
/*      */   
/*      */   public MCH_EntitySeat[] getSeats() {
/* 3037 */     return (this.seats != null) ? this.seats : seatsDummy;
/*      */   }
/*      */   
/*      */   public int getSeatIdByEntity(Entity entity) {
/* 3041 */     if (entity == null)
/* 3042 */       return -1; 
/* 3043 */     if (isEqual(getRiddenByEntity(), entity)) {
/* 3044 */       return 0;
/*      */     }
/* 3046 */     for (int i = 0; i < (getSeats()).length; i++) {
/* 3047 */       MCH_EntitySeat seat = getSeats()[i];
/* 3048 */       if (seat != null && isEqual(seat.field_70153_n, entity)) {
/* 3049 */         return i + 1;
/*      */       }
/*      */     } 
/*      */     
/* 3053 */     return -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public MCH_EntitySeat getSeatByEntity(Entity entity) {
/* 3058 */     int idx = getSeatIdByEntity(entity);
/* 3059 */     return (idx > 0) ? getSeat(idx - 1) : null;
/*      */   }
/*      */   
/*      */   public Entity getEntityBySeatId(int id) {
/* 3063 */     if (id == 0) {
/* 3064 */       return getRiddenByEntity();
/*      */     }
/* 3066 */     id--; return (
/* 3067 */       id >= 0 && id < (getSeats()).length) ? ((this.seats[id] != null) ? (this.seats[id]).field_70153_n : null) : null;
/*      */   }
/*      */ 
/*      */   
/*      */   public EntityPlayer getEntityByWeaponId(int id) {
/* 3072 */     if (id >= 0 && id < getWeaponNum()) {
/* 3073 */       for (int i = 0; i < this.currentWeaponID.length; i++) {
/* 3074 */         if (this.currentWeaponID[i] == id) {
/* 3075 */           Entity e = getEntityBySeatId(i);
/* 3076 */           if (e instanceof EntityPlayer) {
/* 3077 */             return (EntityPlayer)e;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     }
/*      */     
/* 3083 */     return null;
/*      */   }
/*      */   
/*      */   public Entity getWeaponUserByWeaponName(String name) {
/* 3087 */     if (getAcInfo() == null) {
/* 3088 */       return null;
/*      */     }
/* 3090 */     MCH_AircraftInfo.Weapon weapon = getAcInfo().getWeaponByName(name);
/* 3091 */     Entity entity = null;
/* 3092 */     if (weapon != null) {
/* 3093 */       entity = getEntityBySeatId(getWeaponSeatID((MCH_WeaponInfo)null, weapon));
/* 3094 */       if (entity == null && weapon.canUsePilot) {
/* 3095 */         entity = getRiddenByEntity();
/*      */       }
/*      */     } 
/*      */     
/* 3099 */     return entity;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void newSeats(int seatsNum) {
/* 3104 */     if (seatsNum >= 2) {
/* 3105 */       if (this.seats != null) {
/* 3106 */         for (int i = 0; i < this.seats.length; i++) {
/* 3107 */           if (this.seats[i] != null) {
/* 3108 */             this.seats[i].func_70106_y();
/* 3109 */             this.seats[i] = null;
/*      */           } 
/*      */         } 
/*      */       }
/*      */       
/* 3114 */       this.seats = new MCH_EntitySeat[seatsNum - 1];
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public MCH_EntitySeat getSeat(int idx) {
/* 3120 */     return (idx < this.seats.length) ? this.seats[idx] : null;
/*      */   }
/*      */   
/*      */   public void setSeat(int idx, MCH_EntitySeat seat) {
/* 3124 */     if (idx < this.seats.length) {
/* 3125 */       MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityAircraft.setSeat SeatID=" + idx + " / seat[]" + ((this.seats[idx] != null) ? 1 : 0) + " / " + ((seat.field_70153_n != null) ? 1 : 0), new Object[0]);
/* 3126 */       if (this.seats[idx] == null || (this.seats[idx]).field_70153_n != null);
/*      */ 
/*      */ 
/*      */       
/* 3130 */       this.seats[idx] = seat;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isValidSeatID(int seatID) {
/* 3136 */     return (seatID >= 0 && seatID < getSeatNum() + 1);
/*      */   }
/*      */   
/*      */   public void updateHitBoxPosition() {}
/*      */   
/*      */   public void updateSeatsPosition(double px, double py, double pz, boolean setPrevPos) {
/* 3142 */     MCH_SeatInfo[] info = getSeatsInfo();
/* 3143 */     if (this.pilotSeat != null && !this.pilotSeat.field_70128_L) {
/* 3144 */       this.pilotSeat.field_70169_q = this.pilotSeat.field_70165_t;
/* 3145 */       this.pilotSeat.field_70167_r = this.pilotSeat.field_70163_u;
/* 3146 */       this.pilotSeat.field_70166_s = this.pilotSeat.field_70161_v;
/* 3147 */       this.pilotSeat.func_70107_b(px, py, pz);
/* 3148 */       if (info != null && info.length > 0 && info[0] != null) {
/* 3149 */         Vec3 i = getTransformedPosition((info[0]).pos.field_72450_a, (info[0]).pos.field_72448_b, (info[0]).pos.field_72449_c, px, py, pz, (info[0]).rotSeat);
/* 3150 */         this.pilotSeat.func_70107_b(i.field_72450_a, i.field_72448_b, i.field_72449_c);
/*      */       } 
/*      */       
/* 3153 */       this.pilotSeat.field_70125_A = getRotPitch();
/* 3154 */       this.pilotSeat.field_70177_z = getRotYaw();
/* 3155 */       if (setPrevPos) {
/* 3156 */         this.pilotSeat.field_70169_q = this.pilotSeat.field_70165_t;
/* 3157 */         this.pilotSeat.field_70167_r = this.pilotSeat.field_70163_u;
/* 3158 */         this.pilotSeat.field_70166_s = this.pilotSeat.field_70161_v;
/*      */       } 
/*      */     } 
/*      */     
/* 3162 */     int var17 = 0;
/* 3163 */     MCH_EntitySeat[] arr$ = this.seats;
/* 3164 */     int len$ = arr$.length;
/*      */     
/* 3166 */     for (int i$ = 0; i$ < len$; i$++) {
/* 3167 */       MCH_EntitySeat seat = arr$[i$];
/* 3168 */       var17++;
/* 3169 */       if (seat != null && !seat.field_70128_L) {
/* 3170 */         float offsetY = 0.0F;
/* 3171 */         if (seat.field_70153_n != null) {
/* 3172 */           if (W_Lib.isClientPlayer(seat.field_70153_n)) {
/* 3173 */             offsetY = 1.0F;
/* 3174 */           } else if (seat.field_70153_n.field_70131_O >= 1.0F) {
/* 3175 */             offsetY = -seat.field_70153_n.field_70131_O + 1.0F;
/*      */           } 
/*      */         }
/*      */         
/* 3179 */         seat.field_70169_q = seat.field_70165_t;
/* 3180 */         seat.field_70167_r = seat.field_70163_u;
/* 3181 */         seat.field_70166_s = seat.field_70161_v;
/* 3182 */         MCH_SeatInfo si = (var17 < info.length) ? info[var17] : info[0];
/* 3183 */         Vec3 v = getTransformedPosition(si.pos.field_72450_a, si.pos.field_72448_b + offsetY, si.pos.field_72449_c, px, py, pz, si.rotSeat);
/* 3184 */         seat.func_70107_b(v.field_72450_a, v.field_72448_b, v.field_72449_c);
/* 3185 */         seat.field_70125_A = getRotPitch();
/* 3186 */         seat.field_70177_z = getRotYaw();
/* 3187 */         if (setPrevPos) {
/* 3188 */           seat.field_70169_q = seat.field_70165_t;
/* 3189 */           seat.field_70167_r = seat.field_70163_u;
/* 3190 */           seat.field_70166_s = seat.field_70161_v;
/*      */         } 
/*      */         
/* 3193 */         if (si instanceof MCH_SeatRackInfo) {
/* 3194 */           seat.updateRotation(((MCH_SeatRackInfo)si).fixYaw + getRotYaw(), ((MCH_SeatRackInfo)si).fixPitch);
/*      */         }
/*      */         
/* 3197 */         seat.updatePosition();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getClientPositionDelayCorrection() {
/* 3204 */     return 7;
/*      */   }
/*      */   
/*      */   public void func_70056_a(double par1, double par3, double par5, float par7, float par8, int par9) {
/* 3208 */     this.aircraftPosRotInc = par9 + getClientPositionDelayCorrection();
/* 3209 */     this.aircraftX = par1;
/* 3210 */     this.aircraftY = par3;
/* 3211 */     this.aircraftZ = par5;
/* 3212 */     this.aircraftYaw = par7;
/* 3213 */     this.aircraftPitch = par8;
/* 3214 */     this.field_70159_w = this.velocityX;
/* 3215 */     this.field_70181_x = this.velocityY;
/* 3216 */     this.field_70179_y = this.velocityZ;
/*      */   }
/*      */   
/*      */   public void updateRiderPosition(double px, double py, double pz) {
/* 3220 */     MCH_SeatInfo[] info = getSeatsInfo();
/* 3221 */     if (this.field_70153_n != null && !this.field_70153_n.field_70128_L) {
/* 3222 */       Vec3 v; float riddenEntityYOffset = this.field_70153_n.field_70129_M;
/* 3223 */       float offset = 0.0F;
/* 3224 */       if (this.field_70153_n instanceof EntityPlayer && !W_Lib.isClientPlayer(this.field_70153_n)) {
/* 3225 */         offset--;
/*      */       }
/*      */ 
/*      */       
/* 3229 */       if (info != null && info.length > 0) {
/* 3230 */         v = getTransformedPosition((info[0]).pos.field_72450_a, (info[0]).pos.field_72448_b + riddenEntityYOffset - 0.5D, (info[0]).pos.field_72449_c, px, py, pz, (info[0]).rotSeat);
/*      */       } else {
/* 3232 */         v = getTransformedPosition(0.0D, (riddenEntityYOffset - 1.0F), 0.0D);
/*      */       } 
/*      */       
/* 3235 */       this.field_70153_n.field_70129_M = 0.0F;
/* 3236 */       this.field_70153_n.func_70107_b(v.field_72450_a, v.field_72448_b, v.field_72449_c);
/* 3237 */       this.field_70153_n.field_70129_M = riddenEntityYOffset;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void func_70043_V() {
/* 3243 */     updateRiderPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*      */   }
/*      */   
/*      */   public Vec3 calcOnTurretPos(Vec3 pos) {
/* 3247 */     float ry = getLastRiderYaw();
/* 3248 */     if (getRiddenByEntity() != null) {
/* 3249 */       ry = (getRiddenByEntity()).field_70177_z;
/*      */     }
/*      */     
/* 3252 */     Vec3 tpos = (getAcInfo()).turretPosition.func_72441_c(0.0D, pos.field_72448_b, 0.0D);
/* 3253 */     Vec3 v = pos.func_72441_c(-tpos.field_72450_a, -tpos.field_72448_b, -tpos.field_72449_c);
/* 3254 */     v = MCH_Lib.RotVec3(v, -ry, 0.0F, 0.0F);
/* 3255 */     Vec3 vv = MCH_Lib.RotVec3(tpos, -getRotYaw(), -getRotPitch(), -getRotRoll());
/* 3256 */     v.field_72450_a += vv.field_72450_a;
/* 3257 */     v.field_72448_b += vv.field_72448_b;
/* 3258 */     v.field_72449_c += vv.field_72449_c;
/* 3259 */     return v;
/*      */   }
/*      */   
/*      */   public float getLastRiderYaw() {
/* 3263 */     return this.lastRiderYaw;
/*      */   }
/*      */   
/*      */   public float getLastRiderPitch() {
/* 3267 */     return this.lastRiderPitch;
/*      */   }
/*      */   
/*      */   @SideOnly(Side.CLIENT)
/*      */   public void setupAllRiderRenderPosition(float tick, EntityPlayer player) {
/* 3272 */     double x = this.field_70142_S + (this.field_70165_t - this.field_70142_S) * tick;
/* 3273 */     double y = this.field_70137_T + (this.field_70163_u - this.field_70137_T) * tick;
/* 3274 */     double z = this.field_70136_U + (this.field_70161_v - this.field_70136_U) * tick;
/* 3275 */     updateRiderPosition(x, y, z);
/* 3276 */     updateSeatsPosition(x, y, z, true);
/*      */     
/* 3278 */     for (int cpi = 0; cpi < getSeatNum() + 1; cpi++) {
/* 3279 */       Entity seatInfo = getEntityBySeatId(cpi);
/* 3280 */       if (seatInfo != null) {
/* 3281 */         seatInfo.field_70142_S = seatInfo.field_70165_t;
/* 3282 */         seatInfo.field_70137_T = seatInfo.field_70163_u;
/* 3283 */         seatInfo.field_70136_U = seatInfo.field_70161_v;
/*      */       } 
/*      */     } 
/*      */     
/* 3287 */     if (getTVMissile() != null && W_Lib.isClientPlayer((getTVMissile()).shootingEntity)) {
/* 3288 */       MCH_EntityTvMissile var14 = getTVMissile();
/* 3289 */       x = var14.field_70169_q + (var14.field_70165_t - var14.field_70169_q) * tick;
/* 3290 */       y = var14.field_70167_r + (var14.field_70163_u - var14.field_70167_r) * tick;
/* 3291 */       z = var14.field_70166_s + (var14.field_70161_v - var14.field_70166_s) * tick;
/* 3292 */       MCH_ViewEntityDummy.setCameraPosition(x, y, z);
/*      */     } else {
/* 3294 */       MCH_AircraftInfo.CameraPosition var13 = getCameraPosInfo();
/* 3295 */       if (var13 != null && var13.pos != null) {
/* 3296 */         Vec3 v; MCH_SeatInfo var12 = getSeatInfo((Entity)player);
/*      */         
/* 3298 */         if (var12 != null && var12.rotSeat) {
/* 3299 */           v = calcOnTurretPos(var13.pos);
/*      */         } else {
/* 3301 */           v = MCH_Lib.RotVec3(var13.pos, -getRotYaw(), -getRotPitch(), -getRotRoll());
/*      */         } 
/*      */         
/* 3304 */         MCH_ViewEntityDummy.setCameraPosition(x + v.field_72450_a, y + v.field_72448_b, z + v.field_72449_c);
/* 3305 */         if (var13.fixRot);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Vec3 getTurretPos(Vec3 pos, boolean turret) {
/* 3314 */     if (turret) {
/* 3315 */       float ry = getLastRiderYaw();
/* 3316 */       if (getRiddenByEntity() != null) {
/* 3317 */         ry = (getRiddenByEntity()).field_70177_z;
/*      */       }
/*      */       
/* 3320 */       Vec3 tpos = (getAcInfo()).turretPosition.func_72441_c(0.0D, pos.field_72448_b, 0.0D);
/* 3321 */       Vec3 v = pos.func_72441_c(-tpos.field_72450_a, -tpos.field_72448_b, -tpos.field_72449_c);
/* 3322 */       v = MCH_Lib.RotVec3(v, -ry, 0.0F, 0.0F);
/* 3323 */       Vec3 vv = MCH_Lib.RotVec3(tpos, -getRotYaw(), -getRotPitch(), -getRotRoll());
/* 3324 */       v.field_72450_a += vv.field_72450_a;
/* 3325 */       v.field_72448_b += vv.field_72448_b;
/* 3326 */       v.field_72449_c += vv.field_72449_c;
/* 3327 */       return v;
/*      */     } 
/* 3329 */     return Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/*      */   }
/*      */ 
/*      */   
/*      */   public Vec3 getTransformedPosition(Vec3 v) {
/* 3334 */     return getTransformedPosition(v.field_72450_a, v.field_72448_b, v.field_72449_c);
/*      */   }
/*      */   
/*      */   public Vec3 getTransformedPosition(double x, double y, double z) {
/* 3338 */     return getTransformedPosition(x, y, z, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*      */   }
/*      */   
/*      */   public Vec3 getTransformedPosition(Vec3 v, Vec3 pos) {
/* 3342 */     return getTransformedPosition(v.field_72450_a, v.field_72448_b, v.field_72449_c, pos.field_72450_a, pos.field_72448_b, pos.field_72449_c);
/*      */   }
/*      */   
/*      */   public Vec3 getTransformedPosition(Vec3 v, double px, double py, double pz) {
/* 3346 */     return getTransformedPosition(v.field_72450_a, v.field_72448_b, v.field_72449_c, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*      */   }
/*      */   
/*      */   public Vec3 getTransformedPosition(double x, double y, double z, double px, double py, double pz) {
/* 3350 */     Vec3 v = MCH_Lib.RotVec3(x, y, z, -getRotYaw(), -getRotPitch(), -getRotRoll());
/* 3351 */     return v.func_72441_c(px, py, pz);
/*      */   }
/*      */   
/*      */   public Vec3 getTransformedPosition(double x, double y, double z, double px, double py, double pz, boolean rotSeat) {
/* 3355 */     if (rotSeat && getAcInfo() != null) {
/* 3356 */       MCH_AircraftInfo v = getAcInfo();
/* 3357 */       Vec3 tv = MCH_Lib.RotVec3(x - v.turretPosition.field_72450_a, y - v.turretPosition.field_72448_b, z - v.turretPosition.field_72449_c, -getLastRiderYaw() + getRotYaw(), 0.0F, 0.0F);
/* 3358 */       x = tv.field_72450_a + v.turretPosition.field_72450_a;
/* 3359 */       y = tv.field_72448_b + v.turretPosition.field_72450_a;
/* 3360 */       z = tv.field_72449_c + v.turretPosition.field_72450_a;
/*      */     } 
/*      */     
/* 3363 */     Vec3 v1 = MCH_Lib.RotVec3(x, y, z, -getRotYaw(), -getRotPitch(), -getRotRoll());
/* 3364 */     return v1.func_72441_c(px, py, pz);
/*      */   }
/*      */   
/*      */   protected MCH_SeatInfo[] getSeatsInfo() {
/* 3368 */     if (this.seatsInfo != null) {
/* 3369 */       return this.seatsInfo;
/*      */     }
/* 3371 */     newSeatsPos();
/* 3372 */     return this.seatsInfo;
/*      */   }
/*      */ 
/*      */   
/*      */   public MCH_SeatInfo getSeatInfo(int index) {
/* 3377 */     MCH_SeatInfo[] seats = getSeatsInfo();
/* 3378 */     return (index >= 0 && seats != null && index < seats.length) ? seats[index] : null;
/*      */   }
/*      */   
/*      */   public MCH_SeatInfo getSeatInfo(Entity entity) {
/* 3382 */     return getSeatInfo(getSeatIdByEntity(entity));
/*      */   }
/*      */   
/*      */   protected void setSeatsInfo(MCH_SeatInfo[] v) {
/* 3386 */     this.seatsInfo = v;
/*      */   }
/*      */   
/*      */   public int getSeatNum() {
/* 3390 */     if (getAcInfo() == null) {
/* 3391 */       return 0;
/*      */     }
/* 3393 */     int s = getAcInfo().getNumSeatAndRack();
/* 3394 */     return (s >= 1) ? (s - 1) : 1;
/*      */   }
/*      */ 
/*      */   
/*      */   protected void newSeatsPos() {
/* 3399 */     if (getAcInfo() != null) {
/* 3400 */       MCH_SeatInfo[] v = new MCH_SeatInfo[getAcInfo().getNumSeatAndRack()];
/*      */       
/* 3402 */       for (int i = 0; i < v.length; i++) {
/* 3403 */         v[i] = (getAcInfo()).seatList.get(i);
/*      */       }
/*      */       
/* 3406 */       setSeatsInfo(v);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void createSeats(String uuid) {
/* 3412 */     if (!this.field_70170_p.field_72995_K && 
/* 3413 */       !uuid.isEmpty()) {
/* 3414 */       setCommonUniqueId(uuid);
/* 3415 */       this.seats = new MCH_EntitySeat[getSeatNum()];
/*      */       
/* 3417 */       for (int i = 0; i < this.seats.length; i++) {
/* 3418 */         this.seats[i] = new MCH_EntitySeat(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 3419 */         (this.seats[i]).parentUniqueID = getCommonUniqueId();
/* 3420 */         (this.seats[i]).seatID = i;
/* 3421 */         this.seats[i].setParent(this);
/* 3422 */         this.field_70170_p.func_72838_d((Entity)this.seats[i]);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean interactFirstSeat(EntityPlayer player) {
/* 3430 */     if (getSeats() == null) {
/* 3431 */       return false;
/*      */     }
/* 3433 */     int seatId = 1;
/* 3434 */     MCH_EntitySeat[] arr$ = getSeats();
/* 3435 */     int len$ = arr$.length;
/*      */     
/* 3437 */     for (int i$ = 0; i$ < len$; i$++) {
/* 3438 */       if (!MCH_CommonProxy.checkSafeZone(player)) {
/* 3439 */         MCH_EntitySeat seat = arr$[i$];
/* 3440 */         if (seat != null && seat.field_70153_n == null && !isMountedEntity((Entity)player) && canRideSeatOrRack(seatId, (Entity)player) && 
/* 3441 */           !this.field_70170_p.field_72995_K) {
/* 3442 */           player.func_70078_a((Entity)seat);
/*      */         }
/*      */         
/*      */         break;
/*      */       } 
/*      */       
/* 3448 */       seatId++;
/*      */     } 
/*      */     
/* 3451 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void onMountPlayerSeat(MCH_EntitySeat seat, Entity entity) {
/* 3456 */     if (seat != null && entity instanceof EntityPlayer) {
/* 3457 */       if (this.field_70170_p.field_72995_K && MCH_Lib.getClientPlayer() == entity) {
/* 3458 */         switchGunnerFreeLookMode(false);
/*      */       }
/*      */       
/* 3461 */       initCurrentWeapon(entity);
/* 3462 */       MCH_Lib.DbgLog(this.field_70170_p, "onMountEntitySeat:%d", new Object[] { Integer.valueOf(W_Entity.getEntityId(entity)) });
/* 3463 */       Entity pilot = getRiddenByEntity();
/* 3464 */       int sid = getSeatIdByEntity(entity);
/* 3465 */       if (sid == 1 && (getAcInfo() == null || !(getAcInfo()).isEnableConcurrentGunnerMode)) {
/* 3466 */         switchGunnerMode(false);
/*      */       }
/*      */       
/* 3469 */       if (sid > 0) {
/* 3470 */         this.isGunnerModeOtherSeat = true;
/*      */       }
/*      */       
/* 3473 */       if (pilot != null && getAcInfo() != null) {
/* 3474 */         int cwid = getCurrentWeaponID(pilot);
/* 3475 */         MCH_AircraftInfo.Weapon w = getAcInfo().getWeaponById(cwid);
/* 3476 */         if (w != null && getWeaponSeatID(getWeaponInfoById(cwid), w) == sid) {
/* 3477 */           int next = getNextWeaponID(pilot, 1);
/* 3478 */           MCH_Lib.DbgLog(this.field_70170_p, "onMountEntitySeat:%d:->%d", new Object[] { Integer.valueOf(W_Entity.getEntityId(pilot)), Integer.valueOf(next) });
/* 3479 */           if (next >= 0) {
/* 3480 */             switchWeapon(pilot, next);
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 3485 */       if (this.field_70170_p.field_72995_K) {
/* 3486 */         updateClientSettings(sid);
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public MCH_WeaponInfo getWeaponInfoById(int id) {
/* 3493 */     if (id >= 0) {
/* 3494 */       MCH_WeaponSet ws = getWeapon(id);
/* 3495 */       if (ws != null) {
/* 3496 */         return ws.getInfo();
/*      */       }
/*      */     } 
/*      */     
/* 3500 */     return null;
/*      */   }
/*      */   
/*      */   public abstract boolean canMountWithNearEmptyMinecart();
/*      */   
/*      */   protected void mountWithNearEmptyMinecart() {
/* 3506 */     if (getRidingEntity() == null) {
/* 3507 */       byte d = 2;
/* 3508 */       if (this.dismountedUserCtrl) {
/* 3509 */         d = 6;
/*      */       }
/*      */       
/* 3512 */       List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, this.field_70121_D.func_72314_b(d, d, d));
/* 3513 */       if (list != null && !list.isEmpty()) {
/* 3514 */         for (int i = 0; i < list.size(); i++) {
/* 3515 */           Entity entity = list.get(i);
/* 3516 */           if (entity instanceof net.minecraft.entity.item.EntityMinecartEmpty) {
/* 3517 */             if (this.dismountedUserCtrl) {
/*      */               return;
/*      */             }
/*      */             
/* 3521 */             if (entity.field_70153_n == null && entity.func_70104_M()) {
/* 3522 */               this.waitMountEntity = 20;
/* 3523 */               MCH_Lib.DbgLog(this.field_70170_p.field_72995_K, "MCH_EntityAircraft.mountWithNearEmptyMinecart:" + entity, new Object[0]);
/* 3524 */               func_70078_a(entity);
/*      */               
/*      */               return;
/*      */             } 
/*      */           } 
/*      */         } 
/*      */       }
/* 3531 */       this.dismountedUserCtrl = false;
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean isRidePlayer() {
/* 3536 */     if (getRiddenByEntity() instanceof EntityPlayer) {
/* 3537 */       return true;
/*      */     }
/* 3539 */     MCH_EntitySeat[] arr$ = getSeats();
/* 3540 */     int len$ = arr$.length;
/*      */     
/* 3542 */     for (int i$ = 0; i$ < len$; i$++) {
/* 3543 */       MCH_EntitySeat seat = arr$[i$];
/* 3544 */       if (seat != null && seat.field_70153_n instanceof EntityPlayer) {
/* 3545 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 3549 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void onUnmountPlayerSeat(MCH_EntitySeat seat, Entity entity) {
/* 3554 */     if (entity instanceof EntityPlayer) {
/* 3555 */       MCH_Lib.DbgLog(this.field_70170_p, "onUnmountPlayerSeat:%d", new Object[] {
/* 3556 */             Integer.valueOf(W_Entity.getEntityId(entity)) });
/* 3557 */       int sid = getSeatIdByEntity(entity);
/* 3558 */       this.camera.initCamera(sid, entity);
/* 3559 */       MCH_SeatInfo seatInfo = getSeatInfo(seat.seatID + 1);
/* 3560 */       if (seatInfo != null) {
/* 3561 */         setUnmountPosition(entity, 
/* 3562 */             Vec3.func_72443_a(seatInfo.pos.field_72450_a, 0.0D, seatInfo.pos.field_72449_c));
/*      */       }
/*      */       
/* 3565 */       if (!isRidePlayer()) {
/* 3566 */         switchGunnerMode(false);
/* 3567 */         switchHoveringMode(false);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isCreatedSeats() {
/* 3574 */     return !getCommonUniqueId().isEmpty();
/*      */   }
/*      */   
/*      */   public void onUpdate_Seats() {
/* 3578 */     boolean b = false;
/*      */     
/* 3580 */     for (int i = 0; i < this.seats.length; i++) {
/* 3581 */       if (this.seats[i] != null) {
/* 3582 */         if (!(this.seats[i]).field_70128_L) {
/* 3583 */           (this.seats[i]).field_70143_R = 0.0F;
/*      */         }
/*      */       } else {
/* 3586 */         b = true;
/*      */       } 
/*      */     } 
/*      */     
/* 3590 */     if (b) {
/* 3591 */       if (this.seatSearchCount > 40) {
/* 3592 */         if (this.field_70170_p.field_72995_K) {
/* 3593 */           MCH_PacketSeatListRequest.requestSeatList(this);
/*      */         } else {
/* 3595 */           searchSeat();
/*      */         } 
/*      */         
/* 3598 */         this.seatSearchCount = 0;
/*      */       } 
/*      */       
/* 3601 */       this.seatSearchCount++;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void searchSeat() {
/* 3607 */     List<MCH_EntitySeat> list = this.field_70170_p.func_72872_a(MCH_EntitySeat.class, this.field_70121_D.func_72314_b(60.0D, 60.0D, 60.0D));
/*      */     
/* 3609 */     for (int i = 0; i < list.size(); i++) {
/* 3610 */       MCH_EntitySeat seat = list.get(i);
/* 3611 */       if (!seat.field_70128_L && seat.parentUniqueID.equals(getCommonUniqueId()) && seat.seatID >= 0 && seat.seatID < getSeatNum() && this.seats[seat.seatID] == null) {
/* 3612 */         this.seats[seat.seatID] = seat;
/* 3613 */         seat.setParent(this);
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public String getCommonUniqueId() {
/* 3620 */     return this.commonUniqueId;
/*      */   }
/*      */   
/*      */   public void setCommonUniqueId(String uniqId) {
/* 3624 */     this.commonUniqueId = uniqId;
/*      */   }
/*      */   
/*      */   public void func_70106_y() {
/* 3628 */     setDead(false);
/*      */   }
/*      */   
/*      */   public void setDead(boolean dropItems) {
/* 3632 */     this.dropContentsWhenDead = dropItems;
/* 3633 */     super.func_70106_y();
/*      */     
/* 3635 */     if (!this.field_70170_p.field_72995_K) {
/* 3636 */       ForgeChunkManager.releaseTicket(this.chunkLoadingTicket);
/*      */     }
/* 3638 */     if (getRiddenByEntity() != null) {
/* 3639 */       getRiddenByEntity().func_70078_a((Entity)null);
/*      */     }
/*      */     
/* 3642 */     getGuiInventory().setDead();
/* 3643 */     MCH_EntitySeat[] arr$ = this.seats;
/* 3644 */     int len$ = arr$.length;
/*      */     
/*      */     int i$;
/* 3647 */     for (i$ = 0; i$ < len$; i$++) {
/* 3648 */       MCH_EntitySeat e = arr$[i$];
/* 3649 */       if (e != null) {
/* 3650 */         e.func_70106_y();
/*      */       }
/*      */     } 
/* 3653 */     if (this.soundUpdater != null) {
/* 3654 */       this.soundUpdater.update();
/*      */     }
/*      */ 
/*      */     
/* 3658 */     Entity[] var6 = func_70021_al();
/* 3659 */     len$ = var6.length;
/*      */     
/* 3661 */     for (i$ = 0; i$ < len$; i$++) {
/* 3662 */       Entity var7 = var6[i$];
/* 3663 */       if (var7 != null) {
/* 3664 */         var7.func_70106_y();
/*      */       }
/*      */     } 
/*      */     
/* 3668 */     MCH_Lib.DbgLog(this.field_70170_p, "setDead:" + ((getAcInfo() != null) ? (getAcInfo()).name : "null"), new Object[0]);
/*      */   }
/*      */   
/*      */   public void unmountEntity() {
/* 3672 */     if (!isRidePlayer()) {
/* 3673 */       switchHoveringMode(false);
/*      */     }
/*      */     
/* 3676 */     this.moveLeft = this.moveRight = this.throttleDown = this.throttleUp = false;
/* 3677 */     Entity rByEntity = null;
/* 3678 */     if (this.field_70153_n != null) {
/* 3679 */       rByEntity = this.field_70153_n;
/* 3680 */       this.camera.initCamera(0, rByEntity);
/* 3681 */       if (!this.field_70170_p.field_72995_K) {
/* 3682 */         this.field_70153_n.func_70078_a((Entity)null);
/*      */       }
/* 3684 */     } else if (this.lastRiddenByEntity != null) {
/* 3685 */       rByEntity = this.lastRiddenByEntity;
/* 3686 */       if (rByEntity instanceof EntityPlayer) {
/* 3687 */         this.camera.initCamera(0, rByEntity);
/*      */       }
/*      */     } 
/*      */     
/* 3691 */     MCH_Lib.DbgLog(this.field_70170_p, "unmountEntity:" + rByEntity, new Object[0]);
/* 3692 */     if (!isRidePlayer()) {
/* 3693 */       switchGunnerMode(false);
/*      */     }
/*      */     
/* 3696 */     setCommonStatus(1, false);
/* 3697 */     if (rByEntity != null) {
/* 3698 */       if (isUAV()) {
/* 3699 */         if (rByEntity.field_70154_o instanceof MCH_EntityUavStation) {
/* 3700 */           rByEntity.func_70078_a((Entity)null);
/*      */         }
/* 3702 */       } else if (isNewUAV()) {
/* 3703 */         rByEntity.func_70078_a((Entity)getUavStation());
/*      */       } else {
/* 3705 */         setUnmountPosition(rByEntity, (getSeatsInfo()[0]).pos);
/*      */       } 
/*      */     }
/*      */     
/* 3709 */     this.field_70153_n = null;
/* 3710 */     this.lastRiddenByEntity = null;
/* 3711 */     if (this.cs_dismountAll) {
/* 3712 */       unmountCrew(false);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public Entity getRidingEntity() {
/* 3718 */     return this.field_70154_o;
/*      */   }
/*      */   
/*      */   public void startUnmountCrew() {
/* 3722 */     this.isParachuting = true;
/* 3723 */     if (haveHatch()) {
/* 3724 */       foldHatch(true, true);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void stopUnmountCrew() {
/* 3730 */     this.isParachuting = false;
/*      */   }
/*      */   
/*      */   public void unmountCrew() {
/* 3734 */     if (getAcInfo() != null) {
/* 3735 */       if (getAcInfo().haveRepellingHook()) {
/* 3736 */         if (!isRepelling()) {
/* 3737 */           if (MCH_Lib.getBlockIdY((Entity)this, 3, -4) > 0) {
/* 3738 */             unmountCrew(false);
/* 3739 */           } else if (canStartRepelling()) {
/* 3740 */             startRepelling();
/*      */           } 
/*      */         } else {
/* 3743 */           stopRepelling();
/*      */         } 
/* 3745 */       } else if (this.isParachuting) {
/* 3746 */         stopUnmountCrew();
/* 3747 */       } else if ((getAcInfo()).isEnableParachuting && MCH_Lib.getBlockIdY((Entity)this, 3, -10) == 0) {
/* 3748 */         startUnmountCrew();
/*      */       } else {
/* 3750 */         unmountCrew(false);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isRepelling() {
/* 3757 */     return getCommonStatus(5);
/*      */   }
/*      */   
/*      */   public void setRepellingStat(boolean b) {
/* 3761 */     setCommonStatus(5, b);
/*      */   }
/*      */   
/*      */   public Vec3 getRopePos(int ropeIndex) {
/* 3765 */     return (getAcInfo() != null && getAcInfo().haveRepellingHook() && ropeIndex < (getAcInfo()).repellingHooks.size()) ? getTransformedPosition(((MCH_AircraftInfo.RepellingHook)(getAcInfo()).repellingHooks.get(ropeIndex)).pos) : Vec3.func_72443_a(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/*      */   }
/*      */   
/*      */   private void startRepelling() {
/* 3769 */     MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityAircraft.startRepelling()", new Object[0]);
/* 3770 */     setRepellingStat(true);
/* 3771 */     this.throttleUp = false;
/* 3772 */     this.throttleDown = false;
/* 3773 */     this.moveLeft = false;
/* 3774 */     this.moveRight = false;
/* 3775 */     this.tickRepelling = 0;
/*      */   }
/*      */   
/*      */   private void stopRepelling() {
/* 3779 */     MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityAircraft.stopRepelling()", new Object[0]);
/* 3780 */     setRepellingStat(false);
/*      */   }
/*      */   
/*      */   public static float abs(float p_76135_0_) {
/* 3784 */     return (p_76135_0_ >= 0.0F) ? p_76135_0_ : -p_76135_0_;
/*      */   }
/*      */   
/*      */   public static double abs(double p_76135_0_) {
/* 3788 */     return (p_76135_0_ >= 0.0D) ? p_76135_0_ : -p_76135_0_;
/*      */   }
/*      */   
/*      */   public boolean canStartRepelling() {
/* 3792 */     if (getAcInfo().haveRepellingHook() && isHovering() && abs(getRotPitch()) < 3.0F && abs(getRotRoll()) < 3.0F) {
/* 3793 */       Vec3 v = ((Vec3)this.prevPosition.oldest()).func_72441_c(-this.field_70165_t, -this.field_70163_u, -this.field_70161_v);
/* 3794 */       if (v.func_72433_c() < 0.3D) {
/* 3795 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 3799 */     return false;
/*      */   }
/*      */   
/*      */   public boolean unmountCrew(boolean unmountParachute) {
/* 3803 */     boolean ret = false;
/* 3804 */     MCH_SeatInfo[] pos = getSeatsInfo();
/*      */     
/* 3806 */     for (int i = 0; i < this.seats.length; i++) {
/* 3807 */       if (this.seats[i] != null && (this.seats[i]).field_70153_n != null) {
/* 3808 */         Entity entity = (this.seats[i]).field_70153_n;
/* 3809 */         if (!(entity instanceof EntityPlayer) && !(pos[i + 1] instanceof MCH_SeatRackInfo))
/*      */         {
/* 3811 */           if (unmountParachute) {
/* 3812 */             if (getSeatIdByEntity(entity) > 1) {
/* 3813 */               ret = true;
/* 3814 */               Vec3 dropPos = getTransformedPosition((getAcInfo()).mobDropOption.pos, (Vec3)this.prevPosition.oldest());
/* 3815 */               (this.seats[i]).field_70165_t = dropPos.field_72450_a;
/* 3816 */               (this.seats[i]).field_70163_u = dropPos.field_72448_b;
/* 3817 */               (this.seats[i]).field_70161_v = dropPos.field_72449_c;
/* 3818 */               entity.func_70078_a((Entity)null);
/* 3819 */               entity.field_70165_t = dropPos.field_72450_a;
/* 3820 */               entity.field_70163_u = dropPos.field_72448_b;
/* 3821 */               entity.field_70161_v = dropPos.field_72449_c;
/* 3822 */               dropEntityParachute(entity);
/*      */               break;
/*      */             } 
/*      */           } else {
/* 3826 */             ret = true;
/* 3827 */             Vec3 dropPos = (pos[i + 1]).pos;
/* 3828 */             setUnmountPosition((Entity)this.seats[i], (pos[i + 1]).pos);
/* 3829 */             entity.func_70078_a((Entity)null);
/* 3830 */             setUnmountPosition(entity, (pos[i + 1]).pos);
/*      */           } 
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 3836 */     return ret;
/*      */   }
/*      */   
/*      */   public void setUnmountPosition(Entity rByEntity, Vec3 pos) {
/* 3840 */     if (rByEntity != null && 
/* 3841 */       rByEntity instanceof EntityPlayer) {
/* 3842 */       Vec3 v; MCH_AircraftInfo info = getAcInfo();
/*      */       
/* 3844 */       if (info != null && info.unmountPosition != null) {
/* 3845 */         v = getTransformedPosition(info.unmountPosition);
/*      */       } else {
/* 3847 */         double x = pos.field_72450_a;
/* 3848 */         x = (x >= 0.0D) ? (x + 3.0D) : (x - 3.0D);
/* 3849 */         v = getTransformedPosition(x, 2.0D, pos.field_72449_c);
/*      */       } 
/*      */       
/* 3852 */       rByEntity.func_70107_b(v.field_72450_a, v.field_72448_b, v.field_72449_c);
/* 3853 */       this.listUnmountReserve
/* 3854 */         .add(new UnmountReserve(rByEntity, v.field_72450_a, v.field_72448_b, v.field_72449_c));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean unmountEntityFromSeat(Entity entity) {
/* 3860 */     if (entity != null && this.seats != null && this.seats.length != 0) {
/* 3861 */       if (entity instanceof EntityPlayer) {
/* 3862 */         MCH_EntitySeat[] arr$ = this.seats;
/* 3863 */         int len$ = arr$.length;
/*      */         
/* 3865 */         for (int i$ = 0; i$ < len$; i$++) {
/* 3866 */           MCH_EntitySeat seat = arr$[i$];
/* 3867 */           if (seat != null && seat.field_70153_n != null && W_Entity.isEqual(seat.field_70153_n, entity)) {
/* 3868 */             entity.func_70078_a((Entity)null);
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 3873 */       return false;
/*      */     } 
/* 3875 */     return false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void ejectSeat(Entity entity) {
/* 3881 */     if (entity instanceof EntityPlayer) {
/* 3882 */       int sid = getSeatIdByEntity(entity);
/* 3883 */       if (sid >= 0 && sid <= 1 && 
/* 3884 */         getGuiInventory().haveParachute()) {
/* 3885 */         if (sid == 0) {
/* 3886 */           getGuiInventory().consumeParachute();
/* 3887 */           unmountEntity();
/* 3888 */           ejectSeatSub(entity, 0);
/* 3889 */           entity = getEntityBySeatId(1);
/* 3890 */           if (entity instanceof EntityPlayer) {
/* 3891 */             entity = null;
/*      */           }
/*      */         } 
/*      */         
/* 3895 */         if (getGuiInventory().haveParachute() && entity != null) {
/* 3896 */           getGuiInventory().consumeParachute();
/* 3897 */           unmountEntityFromSeat(entity);
/* 3898 */           ejectSeatSub(entity, 1);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void ejectSeatSub(Entity entity, int sid) {
/* 3906 */     if (entity instanceof EntityPlayer) {
/* 3907 */       Vec3 pos = (getSeatInfo(sid) != null) ? (getSeatInfo(sid)).pos : null;
/*      */       
/* 3909 */       if (pos != null) {
/* 3910 */         Vec3 vec3 = getTransformedPosition(pos.field_72450_a, pos.field_72448_b + 2.0D, pos.field_72449_c);
/* 3911 */         entity.func_70107_b(vec3.field_72450_a, vec3.field_72448_b, vec3.field_72449_c);
/*      */       } 
/*      */       
/* 3914 */       Vec3 v = MCH_Lib.RotVec3(0.0D, 2.0D, 0.0D, -getRotYaw(), -getRotPitch(), -getRotRoll());
/* 3915 */       entity.field_70159_w = this.field_70159_w + v.field_72450_a + (this.field_70146_Z.nextFloat() - 0.5D) * 0.1D;
/* 3916 */       entity.field_70181_x = this.field_70181_x + v.field_72448_b;
/* 3917 */       entity.field_70179_y = this.field_70179_y + v.field_72449_c + (this.field_70146_Z.nextFloat() - 0.5D) * 0.1D;
/* 3918 */       MCH_EntityParachute parachute = new MCH_EntityParachute(this.field_70170_p, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
/* 3919 */       parachute.field_70177_z = entity.field_70177_z;
/* 3920 */       parachute.field_70159_w = entity.field_70159_w;
/* 3921 */       parachute.field_70181_x = entity.field_70181_x;
/* 3922 */       parachute.field_70179_y = entity.field_70179_y;
/* 3923 */       parachute.field_70143_R = entity.field_70143_R;
/* 3924 */       parachute.user = entity;
/* 3925 */       parachute.setType(2);
/* 3926 */       this.field_70170_p.func_72838_d((Entity)parachute);
/* 3927 */       if (getAcInfo().haveCanopy() && isCanopyClose()) {
/* 3928 */         openCanopy_EjectSeat();
/*      */       }
/*      */       
/* 3931 */       W_WorldFunc.MOD_playSoundAtEntity(entity, "eject_seat", 5.0F, 1.0F);
/*      */     } 
/*      */   }
/*      */   
/*      */   public boolean canEjectSeat(Entity entity) {
/* 3936 */     int sid = getSeatIdByEntity(entity);
/* 3937 */     return (sid == 0 && isUAV()) ? false : ((sid >= 0 && sid < 2 && getAcInfo() != null && (getAcInfo()).isEnableEjectionSeat));
/*      */   }
/*      */   
/*      */   public int getNumEjectionSeat() {
/* 3941 */     return 0;
/*      */   }
/*      */   
/*      */   public int getMountedEntityNum() {
/* 3945 */     int num = 0;
/* 3946 */     if (this.field_70153_n != null && !this.field_70153_n.field_70128_L) {
/* 3947 */       num++;
/*      */     }
/*      */     
/* 3950 */     if (this.seats != null && this.seats.length > 0) {
/* 3951 */       MCH_EntitySeat[] arr$ = this.seats;
/* 3952 */       int len$ = arr$.length;
/*      */       
/* 3954 */       for (int i$ = 0; i$ < len$; i$++) {
/* 3955 */         MCH_EntitySeat seat = arr$[i$];
/* 3956 */         if (seat != null && seat.field_70153_n != null && !seat.field_70153_n.field_70128_L) {
/* 3957 */           num++;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 3962 */     return num;
/*      */   }
/*      */ 
/*      */   
/*      */   public void mountEntityToRack() {
/* 3967 */     MCH_Config var10000 = MCH_MOD.config;
/* 3968 */     if (!MCH_Config.EnablePutRackInFlying.prmBool) {
/* 3969 */       if (getCurrentThrottle() > 0.3D) {
/*      */         return;
/*      */       }
/*      */       
/* 3973 */       Block countRideEntity = MCH_Lib.getBlockY((Entity)this, 1, -3, true);
/* 3974 */       if (countRideEntity == null || W_Block.isEqual(countRideEntity, Blocks.field_150350_a)) {
/*      */         return;
/*      */       }
/*      */     } 
/*      */     
/* 3979 */     int var12 = 0;
/*      */     
/* 3981 */     for (int sid = 0; sid < getSeatNum(); sid++) {
/* 3982 */       MCH_EntitySeat seat = getSeat(sid);
/* 3983 */       if (getSeatInfo(1 + sid) instanceof MCH_SeatRackInfo && seat != null && seat.field_70153_n == null) {
/* 3984 */         MCH_SeatRackInfo info = (MCH_SeatRackInfo)getSeatInfo(1 + sid);
/* 3985 */         Vec3 v = MCH_Lib.RotVec3((info.getEntryPos()).field_72450_a, (info.getEntryPos()).field_72448_b, (info.getEntryPos()).field_72449_c, -getRotYaw(), -getRotPitch(), -getRotRoll());
/* 3986 */         v.field_72450_a += this.field_70165_t;
/* 3987 */         v.field_72448_b += this.field_70163_u;
/* 3988 */         v.field_72449_c += this.field_70161_v;
/* 3989 */         AxisAlignedBB bb = AxisAlignedBB.func_72330_a(v.field_72450_a, v.field_72448_b, v.field_72449_c, v.field_72450_a, v.field_72448_b, v.field_72449_c);
/* 3990 */         float range = info.range;
/* 3991 */         List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, bb.func_72314_b(range, range, range));
/*      */         
/* 3993 */         for (int i = 0; i < list.size(); i++) {
/* 3994 */           Entity entity = list.get(i);
/* 3995 */           if (canRideSeatOrRack(1 + sid, entity)) {
/* 3996 */             if (entity instanceof MCH_IEntityCanRideAircraft) {
/* 3997 */               if (((MCH_IEntityCanRideAircraft)entity).canRideAircraft(this, sid, info)) {
/* 3998 */                 MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityAircraft.mountEntityToRack:%d:%s", new Object[] { Integer.valueOf(sid), entity });
/* 3999 */                 entity.func_70078_a((Entity)seat);
/* 4000 */                 var12++;
/*      */                 break;
/*      */               } 
/* 4003 */             } else if (entity.field_70154_o == null && 
/* 4004 */               entity instanceof EntityPlayer) {
/* 4005 */               NBTTagCompound nbt = entity.getEntityData();
/* 4006 */               if (nbt.func_74764_b("CanMountEntity") && nbt.func_74767_n("CanMountEntity")) {
/* 4007 */                 MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityAircraft.mountEntityToRack:%d:%s:%s", new Object[] { Integer.valueOf(sid), entity, entity.getClass() });
/* 4008 */                 entity.func_70078_a((Entity)seat);
/* 4009 */                 var12++;
/*      */                 
/*      */                 break;
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4019 */     if (var12 > 0) {
/* 4020 */       W_WorldFunc.DEF_playSoundEffect(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.click", 1.0F, 1.0F);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void unmountEntityFromRack() {
/* 4026 */     for (int sid = getSeatNum() - 1; sid >= 0; sid--) {
/* 4027 */       MCH_EntitySeat seat = getSeat(sid);
/* 4028 */       if (getSeatInfo(sid + 1) instanceof MCH_SeatRackInfo && seat != null && seat.field_70153_n != null) {
/* 4029 */         MCH_SeatRackInfo info = (MCH_SeatRackInfo)getSeatInfo(sid + 1);
/* 4030 */         Entity entity = seat.field_70153_n;
/* 4031 */         Vec3 pos = info.getEntryPos();
/* 4032 */         if (entity instanceof MCH_EntityAircraft) {
/* 4033 */           if (pos.field_72449_c >= (getAcInfo()).bbZ) {
/* 4034 */             pos = pos.func_72441_c(0.0D, 0.0D, 12.0D);
/*      */           } else {
/* 4036 */             pos = pos.func_72441_c(0.0D, 0.0D, -12.0D);
/*      */           } 
/*      */         }
/*      */         
/* 4040 */         Vec3 v = MCH_Lib.RotVec3(pos.field_72450_a, pos.field_72448_b, pos.field_72449_c, -getRotYaw(), -getRotPitch(), -getRotRoll());
/* 4041 */         seat.field_70165_t = entity.field_70165_t = this.field_70165_t + v.field_72450_a;
/* 4042 */         seat.field_70163_u = entity.field_70163_u = this.field_70163_u + v.field_72448_b;
/* 4043 */         seat.field_70161_v = entity.field_70161_v = this.field_70161_v + v.field_72449_c;
/* 4044 */         UnmountReserve ur = new UnmountReserve(entity, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
/* 4045 */         ur.cnt = 8;
/* 4046 */         this.listUnmountReserve.add(ur);
/* 4047 */         entity.func_70078_a((Entity)null);
/* 4048 */         if (MCH_Lib.getBlockIdY((Entity)this, 3, -20) > 0) {
/* 4049 */           MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityAircraft.unmountEntityFromRack:%d:%s", new Object[] { Integer.valueOf(sid), entity }); break;
/*      */         } 
/* 4051 */         MCH_Lib.DbgLog(this.field_70170_p, "MCH_EntityAircraft.unmountEntityFromRack:%d Parachute:%s", new Object[] { Integer.valueOf(sid), entity });
/* 4052 */         dropEntityParachute(entity);
/*      */         break;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void dropEntityParachute(Entity entity) {
/* 4061 */     entity.field_70159_w = this.field_70159_w;
/* 4062 */     entity.field_70181_x = this.field_70181_x;
/* 4063 */     entity.field_70179_y = this.field_70179_y;
/* 4064 */     MCH_EntityParachute parachute = new MCH_EntityParachute(this.field_70170_p, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v);
/* 4065 */     parachute.field_70177_z = entity.field_70177_z;
/* 4066 */     parachute.field_70159_w = entity.field_70159_w;
/* 4067 */     parachute.field_70181_x = entity.field_70181_x;
/* 4068 */     parachute.field_70179_y = entity.field_70179_y;
/* 4069 */     parachute.field_70143_R = entity.field_70143_R;
/* 4070 */     parachute.user = entity;
/* 4071 */     parachute.setType(3);
/* 4072 */     this.field_70170_p.func_72838_d((Entity)parachute);
/*      */   }
/*      */   
/*      */   public void rideRack() {
/* 4076 */     if (this.field_70154_o == null) {
/* 4077 */       AxisAlignedBB bb = func_70046_E();
/* 4078 */       List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, bb.func_72314_b(60.0D, 60.0D, 60.0D));
/*      */       
/* 4080 */       for (int i = 0; i < list.size(); i++) {
/* 4081 */         Entity entity = list.get(i);
/* 4082 */         if (entity instanceof MCH_EntityAircraft) {
/* 4083 */           MCH_EntityAircraft ac = (MCH_EntityAircraft)entity;
/* 4084 */           if (ac.getAcInfo() != null) {
/* 4085 */             for (int sid = 0; sid < ac.getSeatNum(); sid++) {
/* 4086 */               MCH_SeatInfo seatInfo = ac.getSeatInfo(1 + sid);
/* 4087 */               if (seatInfo instanceof MCH_SeatRackInfo && ac.canRideSeatOrRack(1 + sid, entity)) {
/* 4088 */                 MCH_SeatRackInfo info = (MCH_SeatRackInfo)seatInfo;
/* 4089 */                 MCH_EntitySeat seat = ac.getSeat(sid);
/* 4090 */                 if (seat != null && seat.field_70153_n == null) {
/* 4091 */                   Vec3 v = ac.getTransformedPosition(info.getEntryPos());
/* 4092 */                   float r = info.range;
/* 4093 */                   if (this.field_70165_t >= v.field_72450_a - r && this.field_70165_t <= v.field_72450_a + r && this.field_70163_u >= v.field_72448_b - r && this.field_70163_u <= v.field_72448_b + r && this.field_70161_v >= v.field_72449_c - r && this.field_70161_v <= v.field_72449_c + r && canRideAircraft(ac, sid, info)) {
/* 4094 */                     W_WorldFunc.DEF_playSoundEffect(this.field_70170_p, this.field_70165_t, this.field_70163_u, this.field_70161_v, "random.click", 1.0F, 1.0F);
/* 4095 */                     func_70078_a((Entity)seat);
/*      */                     return;
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             } 
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canPutToRack() {
/* 4109 */     for (int i = 0; i < getSeatNum(); i++) {
/* 4110 */       MCH_EntitySeat seat = getSeat(i);
/* 4111 */       MCH_SeatInfo seatInfo = getSeatInfo(i + 1);
/* 4112 */       if (seat != null && seat.field_70153_n == null && seatInfo instanceof MCH_SeatRackInfo) {
/* 4113 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 4117 */     return false;
/*      */   }
/*      */   
/*      */   public boolean canDownFromRack() {
/* 4121 */     for (int i = 0; i < getSeatNum(); i++) {
/* 4122 */       MCH_EntitySeat seat = getSeat(i);
/* 4123 */       MCH_SeatInfo seatInfo = getSeatInfo(i + 1);
/* 4124 */       if (seat != null && seat.field_70153_n != null && seatInfo instanceof MCH_SeatRackInfo) {
/* 4125 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 4129 */     return false;
/*      */   }
/*      */   
/*      */   public void checkRideRack() {
/* 4133 */     if (getCountOnUpdate() % 10 == 0) {
/* 4134 */       this.canRideRackStatus = false;
/* 4135 */       if (this.field_70154_o == null) {
/* 4136 */         AxisAlignedBB bb = func_70046_E();
/* 4137 */         List<Entity> list = this.field_70170_p.func_72839_b((Entity)this, bb.func_72314_b(60.0D, 60.0D, 60.0D));
/*      */         
/* 4139 */         for (int i = 0; i < list.size(); i++) {
/* 4140 */           Entity entity = list.get(i);
/* 4141 */           if (entity instanceof MCH_EntityAircraft) {
/* 4142 */             MCH_EntityAircraft ac = (MCH_EntityAircraft)entity;
/* 4143 */             if (ac.getAcInfo() != null) {
/* 4144 */               for (int sid = 0; sid < ac.getSeatNum(); sid++) {
/* 4145 */                 MCH_SeatInfo seatInfo = ac.getSeatInfo(1 + sid);
/* 4146 */                 if (seatInfo instanceof MCH_SeatRackInfo) {
/* 4147 */                   MCH_SeatRackInfo info = (MCH_SeatRackInfo)seatInfo;
/* 4148 */                   MCH_EntitySeat seat = ac.getSeat(sid);
/* 4149 */                   if (seat != null && seat.field_70153_n == null) {
/* 4150 */                     Vec3 v = ac.getTransformedPosition(info.getEntryPos());
/* 4151 */                     float r = info.range;
/*      */                     
/* 4153 */                     if (this.field_70165_t >= v.field_72450_a - r && this.field_70165_t <= v.field_72450_a + r) {
/* 4154 */                       boolean var10000 = true;
/*      */                     } else {
/* 4156 */                       boolean var10000 = false;
/*      */                     } 
/*      */                     
/* 4159 */                     if (this.field_70163_u >= v.field_72448_b - r && this.field_70163_u <= v.field_72448_b + r) {
/* 4160 */                       boolean bool = true;
/*      */                     } else {
/* 4162 */                       boolean bool = false;
/*      */                     } 
/*      */                     
/* 4165 */                     if (this.field_70161_v >= v.field_72449_c - r && this.field_70161_v <= v.field_72449_c + r) {
/* 4166 */                       boolean bool = true;
/*      */                     } else {
/* 4168 */                       boolean bool = false;
/*      */                     } 
/*      */                     
/* 4171 */                     if (this.field_70165_t >= v.field_72450_a - r && this.field_70165_t <= v.field_72450_a + r && this.field_70163_u >= v.field_72448_b - r && this.field_70163_u <= v.field_72448_b + r && this.field_70161_v >= v.field_72449_c - r && this.field_70161_v <= v.field_72449_c + r && canRideAircraft(ac, sid, info)) {
/* 4172 */                       this.canRideRackStatus = true;
/*      */                       return;
/*      */                     } 
/*      */                   } 
/*      */                 } 
/*      */               } 
/*      */             }
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canRideRack() {
/* 4187 */     return (this.field_70154_o == null && this.canRideRackStatus);
/*      */   }
/*      */   
/*      */   public boolean canRideAircraft(MCH_EntityAircraft ac, int seatID, MCH_SeatRackInfo info) {
/* 4191 */     if (getAcInfo() == null)
/* 4192 */       return false; 
/* 4193 */     if (ac.field_70154_o != null)
/* 4194 */       return false; 
/* 4195 */     if (this.field_70154_o != null) {
/* 4196 */       return false;
/*      */     }
/* 4198 */     boolean canRide = false;
/* 4199 */     String[] arr$ = info.names;
/* 4200 */     int len$ = arr$.length;
/*      */     
/*      */     int i$;
/* 4203 */     for (i$ = 0; i$ < len$; i$++) {
/* 4204 */       String seat = arr$[i$];
/* 4205 */       if (seat.equalsIgnoreCase((getAcInfo()).name) || seat.equalsIgnoreCase(getAcInfo().getKindName())) {
/* 4206 */         canRide = true;
/*      */         
/*      */         break;
/*      */       } 
/*      */     } 
/*      */     
/* 4212 */     if (!canRide) {
/* 4213 */       Iterator<MCH_AircraftInfo.RideRack> var9 = (getAcInfo()).rideRacks.iterator();
/*      */       
/* 4215 */       while (var9.hasNext()) {
/* 4216 */         MCH_AircraftInfo.RideRack var11 = var9.next();
/* 4217 */         i$ = ac.getAcInfo().getNumSeat() - 1 + var11.rackID - 1;
/* 4218 */         if (i$ == seatID && var11.name.equalsIgnoreCase((ac.getAcInfo()).name)) {
/* 4219 */           MCH_EntitySeat var12 = ac.getSeat(ac.getAcInfo().getNumSeat() - 1 + var11.rackID - 1);
/* 4220 */           if (var12 != null && var12.field_70153_n == null) {
/* 4221 */             canRide = true;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/*      */       } 
/* 4227 */       if (!canRide) {
/* 4228 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 4232 */     MCH_EntitySeat[] var10 = getSeats();
/* 4233 */     len$ = var10.length;
/*      */     
/* 4235 */     for (i$ = 0; i$ < len$; i$++) {
/* 4236 */       MCH_EntitySeat var12 = var10[i$];
/* 4237 */       if (var12 != null && var12.field_70153_n instanceof MCH_IEntityCanRideAircraft) {
/* 4238 */         return false;
/*      */       }
/*      */     } 
/*      */     
/* 4242 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isMountedEntity(Entity entity) {
/* 4247 */     return (entity == null) ? false : isMountedEntity(W_Entity.getEntityId(entity));
/*      */   }
/*      */   
/*      */   public EntityPlayer getFirstMountPlayer() {
/* 4251 */     if (getRiddenByEntity() instanceof EntityPlayer) {
/* 4252 */       return (EntityPlayer)getRiddenByEntity();
/*      */     }
/* 4254 */     MCH_EntitySeat[] arr$ = getSeats();
/* 4255 */     int len$ = arr$.length;
/*      */     
/* 4257 */     for (int i$ = 0; i$ < len$; i$++) {
/* 4258 */       MCH_EntitySeat seat = arr$[i$];
/* 4259 */       if (seat != null && seat.field_70153_n instanceof EntityPlayer) {
/* 4260 */         return (EntityPlayer)seat.field_70153_n;
/*      */       }
/*      */     } 
/*      */     
/* 4264 */     return null;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isMountedSameTeamEntity(EntityLivingBase player) {
/* 4269 */     if (player != null && player.func_96124_cp() != null) {
/* 4270 */       if (this.field_70153_n instanceof EntityLivingBase && player.func_142014_c((EntityLivingBase)this.field_70153_n)) {
/* 4271 */         return true;
/*      */       }
/* 4273 */       MCH_EntitySeat[] arr$ = getSeats();
/* 4274 */       int len$ = arr$.length;
/*      */       
/* 4276 */       for (int i$ = 0; i$ < len$; i$++) {
/* 4277 */         MCH_EntitySeat seat = arr$[i$];
/* 4278 */         if (seat != null && seat.field_70153_n instanceof EntityLivingBase && player.func_142014_c((EntityLivingBase)seat.field_70153_n)) {
/* 4279 */           return true;
/*      */         }
/*      */       } 
/*      */       
/* 4283 */       return false;
/*      */     } 
/*      */     
/* 4286 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isMountedOtherTeamEntity(EntityLivingBase player) {
/* 4291 */     if (player == null) {
/* 4292 */       return false;
/*      */     }
/* 4294 */     EntityLivingBase target = null;
/* 4295 */     if (this.field_70153_n instanceof EntityLivingBase) {
/* 4296 */       target = (EntityLivingBase)this.field_70153_n;
/* 4297 */       if (player.func_96124_cp() != null && target.func_96124_cp() != null && !player.func_142014_c(target)) {
/* 4298 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 4302 */     MCH_EntitySeat[] arr$ = getSeats();
/* 4303 */     int len$ = arr$.length;
/*      */     
/* 4305 */     for (int i$ = 0; i$ < len$; i$++) {
/* 4306 */       MCH_EntitySeat seat = arr$[i$];
/* 4307 */       if (seat != null && seat.field_70153_n instanceof EntityLivingBase) {
/* 4308 */         target = (EntityLivingBase)seat.field_70153_n;
/* 4309 */         if (player.func_96124_cp() != null && target.func_96124_cp() != null && !player.func_142014_c(target)) {
/* 4310 */           return true;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 4315 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isMountedEntity(int entityId) {
/* 4320 */     if (W_Entity.getEntityId(this.field_70153_n) == entityId) {
/* 4321 */       return true;
/*      */     }
/* 4323 */     MCH_EntitySeat[] arr$ = getSeats();
/* 4324 */     int len$ = arr$.length;
/*      */     
/* 4326 */     for (int i$ = 0; i$ < len$; i$++) {
/* 4327 */       MCH_EntitySeat seat = arr$[i$];
/* 4328 */       if (seat != null && seat.field_70153_n != null && W_Entity.getEntityId(seat.field_70153_n) == entityId) {
/* 4329 */         return true;
/*      */       }
/*      */     } 
/*      */     
/* 4333 */     return false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void onInteractFirst(EntityPlayer player) {}
/*      */   
/*      */   public boolean checkTeam(EntityPlayer player) {
/* 4340 */     for (int i = 0; i < 1 + getSeatNum(); i++) {
/* 4341 */       Entity entity = getEntityBySeatId(i);
/* 4342 */       if (entity instanceof EntityPlayer) {
/* 4343 */         EntityPlayer riddenPlayer = (EntityPlayer)entity;
/* 4344 */         if (riddenPlayer.func_96124_cp() != null && !riddenPlayer.func_142014_c((EntityLivingBase)player)) {
/* 4345 */           return false;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 4350 */     return true;
/*      */   }
/*      */   
/*      */   public boolean interactFirst(EntityPlayer player, boolean ss) {
/* 4354 */     this.switchSeat = ss;
/* 4355 */     boolean ret = func_130002_c(player);
/* 4356 */     this.switchSeat = false;
/* 4357 */     return ret;
/*      */   }
/*      */   
/*      */   public boolean func_130002_c(EntityPlayer player) {
/* 4361 */     if (isDestroyed())
/* 4362 */       return false; 
/* 4363 */     if (getAcInfo() == null)
/* 4364 */       return false; 
/* 4365 */     if (!checkTeam(player)) {
/* 4366 */       return false;
/*      */     }
/* 4368 */     ItemStack itemStack = player.func_71045_bC();
/* 4369 */     if (itemStack != null && itemStack.func_77973_b() instanceof mcheli.tool.MCH_ItemWrench) {
/* 4370 */       if (!this.field_70170_p.field_72995_K && player.func_70093_af()) {
/* 4371 */         switchNextTextureName();
/*      */       }
/*      */       
/* 4374 */       return false;
/* 4375 */     }  if (itemStack != null && itemStack.func_77973_b() instanceof mcheli.mob.MCH_ItemSpawnGunner)
/* 4376 */       return false; 
/* 4377 */     if (player.func_70093_af()) {
/* 4378 */       openInventory(player);
/* 4379 */       return false;
/* 4380 */     }  if (!(getAcInfo()).canRide)
/* 4381 */       return false; 
/* 4382 */     if (this.field_70153_n == null && !isUAV() && !isNewUAV()) {
/* 4383 */       if (player.field_70154_o instanceof MCH_EntitySeat)
/* 4384 */         return false; 
/* 4385 */       if (!canRideSeatOrRack(0, (Entity)player)) {
/* 4386 */         return false;
/*      */       }
/* 4388 */       if (!this.switchSeat) {
/* 4389 */         if (getAcInfo().haveCanopy() && isCanopyClose()) {
/* 4390 */           openCanopy();
/* 4391 */           return false;
/*      */         } 
/*      */         
/* 4394 */         if (getModeSwitchCooldown() > 0) {
/* 4395 */           return false;
/*      */         }
/*      */       } 
/*      */       
/* 4399 */       closeCanopy();
/* 4400 */       this.field_70153_n = null;
/* 4401 */       this.lastRiddenByEntity = null;
/* 4402 */       initRadar();
/* 4403 */       if (!this.field_70170_p.field_72995_K) {
/* 4404 */         player.func_70078_a((Entity)this);
/* 4405 */         if (!this.keepOnRideRotation) {
/* 4406 */           mountMobToSeats();
/*      */         }
/*      */       } else {
/* 4409 */         updateClientSettings(0);
/*      */       } 
/*      */       
/* 4412 */       setCameraId(0);
/* 4413 */       initPilotWeapon();
/* 4414 */       this.lowPassPartialTicks.clear();
/*      */       
/* 4416 */       onInteractFirst(player);
/* 4417 */       return true;
/*      */     } 
/*      */     
/* 4420 */     return interactFirstSeat(player);
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canRideSeatOrRack(int seatId, Entity entity) {
/* 4426 */     if (getAcInfo() == null) {
/* 4427 */       return false;
/*      */     }
/* 4429 */     Iterator<Integer[]> i$ = (getAcInfo()).exclusionSeatList.iterator();
/*      */     
/* 4431 */     while (i$.hasNext()) {
/* 4432 */       Integer[] a = i$.next();
/* 4433 */       if (Arrays.<Integer>asList(a).contains(Integer.valueOf(seatId))) {
/* 4434 */         Integer[] arr$ = a;
/* 4435 */         int len$ = a.length;
/*      */         
/* 4437 */         for (int i$1 = 0; i$1 < len$; i$1++) {
/* 4438 */           int id = arr$[i$1].intValue();
/* 4439 */           if (getEntityBySeatId(id) != null) {
/* 4440 */             return false;
/*      */           }
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4446 */     return true;
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateClientSettings(int seatId) {
/* 4451 */     MCH_Config var10001 = MCH_MOD.config;
/* 4452 */     this.cs_dismountAll = MCH_Config.DismountAll.prmBool;
/* 4453 */     var10001 = MCH_MOD.config;
/* 4454 */     this.cs_heliAutoThrottleDown = MCH_Config.AutoThrottleDownHeli.prmBool;
/* 4455 */     var10001 = MCH_MOD.config;
/* 4456 */     this.cs_planeAutoThrottleDown = MCH_Config.AutoThrottleDownPlane.prmBool;
/* 4457 */     var10001 = MCH_MOD.config;
/* 4458 */     this.cs_tankAutoThrottleDown = MCH_Config.AutoThrottleDownTank.prmBool;
/* 4459 */     this.camera.setShaderSupport(seatId, Boolean.valueOf(W_EntityRenderer.isShaderSupport()));
/* 4460 */     MCH_PacketNotifyClientSetting.send();
/*      */   }
/*      */   
/*      */   public boolean canLockEntity(Entity entity) {
/* 4464 */     return !isMountedEntity(entity);
/*      */   }
/*      */   
/*      */   public void switchNextSeat(Entity entity) {
/* 4468 */     if (entity != null && 
/* 4469 */       this.seats != null && this.seats.length > 0 && 
/* 4470 */       isMountedEntity(entity)) {
/* 4471 */       boolean isFound = false;
/* 4472 */       int sid = 1;
/* 4473 */       MCH_EntitySeat[] arr$ = this.seats;
/* 4474 */       int len$ = arr$.length;
/*      */       
/*      */       int i$;
/*      */       
/* 4478 */       for (i$ = 0; i$ < len$; i$++) {
/* 4479 */         MCH_EntitySeat seat = arr$[i$];
/* 4480 */         if (seat != null) {
/* 4481 */           if (getSeatInfo(sid) instanceof MCH_SeatRackInfo) {
/*      */             break;
/*      */           }
/*      */           
/* 4485 */           if (W_Entity.isEqual(seat.field_70153_n, entity)) {
/* 4486 */             isFound = true;
/* 4487 */           } else if (isFound && seat.field_70153_n == null) {
/* 4488 */             entity.func_70078_a((Entity)seat);
/*      */             
/*      */             return;
/*      */           } 
/* 4492 */           sid++;
/*      */         } 
/*      */       } 
/*      */       
/* 4496 */       sid = 1;
/* 4497 */       arr$ = this.seats;
/* 4498 */       len$ = arr$.length;
/*      */       
/* 4500 */       for (i$ = 0; i$ < len$; i$++) {
/* 4501 */         MCH_EntitySeat seat = arr$[i$];
/* 4502 */         if (seat != null && seat.field_70153_n == null) {
/* 4503 */           if (!(getSeatInfo(sid) instanceof MCH_SeatRackInfo)) {
/* 4504 */             entity.func_70078_a((Entity)seat);
/* 4505 */             onMountPlayerSeat(seat, entity);
/*      */             
/*      */             return;
/*      */           } 
/*      */           break;
/*      */         } 
/* 4511 */         sid++;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public void switchPrevSeat(Entity entity) {
/* 4520 */     if (entity != null && 
/* 4521 */       this.seats != null && this.seats.length > 0 && 
/* 4522 */       isMountedEntity(entity)) {
/* 4523 */       boolean isFound = false;
/*      */       
/*      */       int i;
/*      */       
/* 4527 */       for (i = this.seats.length - 1; i >= 0; i--) {
/* 4528 */         MCH_EntitySeat seat = this.seats[i];
/* 4529 */         if (seat != null) {
/* 4530 */           if (W_Entity.isEqual(seat.field_70153_n, entity)) {
/* 4531 */             isFound = true;
/* 4532 */           } else if (isFound && seat.field_70153_n == null) {
/* 4533 */             entity.func_70078_a((Entity)seat);
/*      */             
/*      */             return;
/*      */           } 
/*      */         }
/*      */       } 
/* 4539 */       for (i = this.seats.length - 1; i >= 0; i--) {
/* 4540 */         MCH_EntitySeat seat = this.seats[i];
/* 4541 */         if (!(getSeatInfo(i + 1) instanceof MCH_SeatRackInfo) && seat != null && seat.field_70153_n == null) {
/* 4542 */           entity.func_70078_a((Entity)seat);
/*      */           return;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public Entity[] func_70021_al() {
/* 4553 */     return this.partEntities;
/*      */   }
/*      */   
/*      */   public float getSoundVolume() {
/* 4557 */     return 1.0F;
/*      */   }
/*      */   
/*      */   public float getSoundPitch() {
/* 4561 */     return 1.0F;
/*      */   }
/*      */   
/*      */   public abstract String getDefaultSoundName();
/*      */   
/*      */   public String getSoundName() {
/* 4567 */     return (getAcInfo() == null) ? "" : (!(getAcInfo()).soundMove.isEmpty() ? (getAcInfo()).soundMove : getDefaultSoundName());
/*      */   }
/*      */   
/*      */   public boolean isSkipNormalRender() {
/* 4571 */     return this.field_70154_o instanceof MCH_EntitySeat;
/*      */   }
/*      */   
/*      */   public boolean isRenderBullet(Entity entity, Entity rider) {
/* 4575 */     return (!isCameraView(rider) || !W_Entity.isEqual((Entity)getTVMissile(), entity) || !W_Entity.isEqual((getTVMissile()).shootingEntity, rider));
/*      */   }
/*      */   
/*      */   public boolean isCameraView(Entity entity) {
/* 4579 */     return (getIsGunnerMode(entity) || isUAV());
/*      */   }
/*      */   
/*      */   public void updateCamera(double x, double y, double z) {
/* 4583 */     if (this.field_70170_p.field_72995_K) {
/* 4584 */       if (getTVMissile() != null) {
/* 4585 */         this.camera.setPosition(this.TVmissile.field_70165_t, this.TVmissile.field_70163_u, this.TVmissile.field_70161_v);
/* 4586 */         this.camera.setCameraZoom(1.0F);
/* 4587 */         this.TVmissile.isSpawnParticle = !isMissileCameraMode(this.TVmissile.shootingEntity);
/*      */       } else {
/* 4589 */         setTVMissile((MCH_EntityTvMissile)null);
/* 4590 */         MCH_AircraftInfo.CameraPosition cpi = getCameraPosInfo();
/* 4591 */         Vec3 cp = (cpi != null) ? cpi.pos : Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/* 4592 */         Vec3 v = MCH_Lib.RotVec3(cp, -getRotYaw(), -getRotPitch(), -getRotRoll());
/* 4593 */         this.camera.setPosition(x + v.field_72450_a, y + v.field_72448_b, z + v.field_72449_c);
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateCameraRotate(float yaw, float pitch) {
/* 4600 */     this.camera.prevRotationYaw = this.camera.rotationYaw;
/* 4601 */     this.camera.prevRotationPitch = this.camera.rotationPitch;
/* 4602 */     this.camera.rotationYaw = yaw;
/* 4603 */     this.camera.rotationPitch = pitch;
/*      */   }
/*      */   
/*      */   public void updatePartCameraRotate() {
/* 4607 */     if (this.field_70170_p.field_72995_K) {
/* 4608 */       Entity e = getEntityBySeatId(1);
/* 4609 */       if (e == null) {
/* 4610 */         e = getRiddenByEntity();
/*      */       }
/*      */       
/* 4613 */       if (e != null) {
/* 4614 */         this.camera.partRotationYaw = e.field_70177_z;
/* 4615 */         float pitch = e.field_70125_A;
/* 4616 */         this.camera.prevPartRotationYaw = this.camera.partRotationYaw;
/* 4617 */         this.camera.prevPartRotationPitch = this.camera.partRotationPitch;
/* 4618 */         this.camera.partRotationPitch = pitch;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void setTVMissile(MCH_EntityTvMissile entity) {
/* 4625 */     this.TVmissile = entity;
/*      */   }
/*      */   
/*      */   public MCH_EntityTvMissile getTVMissile() {
/* 4629 */     return (this.TVmissile != null && !this.TVmissile.field_70128_L) ? this.TVmissile : null;
/*      */   }
/*      */   
/*      */   public MCH_WeaponSet[] createWeapon(int seat_num) {
/* 4633 */     this.currentWeaponID = new int[seat_num];
/*      */     
/* 4635 */     for (int weaponSetArray = 0; weaponSetArray < this.currentWeaponID.length; weaponSetArray++) {
/* 4636 */       this.currentWeaponID[weaponSetArray] = -1;
/*      */     }
/*      */     
/* 4639 */     if (getAcInfo() != null && (getAcInfo()).weaponSetList.size() > 0 && seat_num > 0) {
/* 4640 */       MCH_WeaponSet[] var7 = new MCH_WeaponSet[(getAcInfo()).weaponSetList.size()];
/*      */       
/* 4642 */       for (int i = 0; i < (getAcInfo()).weaponSetList.size(); i++) {
/* 4643 */         MCH_AircraftInfo.WeaponSet ws = (getAcInfo()).weaponSetList.get(i);
/* 4644 */         MCH_WeaponBase[] wb = new MCH_WeaponBase[ws.weapons.size()];
/*      */         
/* 4646 */         for (int defYaw = 0; defYaw < ws.weapons.size(); defYaw++) {
/* 4647 */           wb[defYaw] = MCH_WeaponCreator.createWeapon(this.field_70170_p, ws.type, ((MCH_AircraftInfo.Weapon)ws.weapons.get(defYaw)).pos, ((MCH_AircraftInfo.Weapon)ws.weapons.get(defYaw)).yaw, ((MCH_AircraftInfo.Weapon)ws.weapons.get(defYaw)).pitch, this, ((MCH_AircraftInfo.Weapon)ws.weapons.get(defYaw)).turret);
/* 4648 */           (wb[defYaw]).aircraft = this;
/*      */         } 
/*      */ 
/*      */         
/* 4652 */         if (wb.length > 0 && wb[0] != null) {
/* 4653 */           float var8 = ((MCH_AircraftInfo.Weapon)ws.weapons.get(0)).defaultYaw;
/* 4654 */           var7[i] = new MCH_WeaponSet(wb);
/* 4655 */           (var7[i]).prevRotationYaw = var8;
/* 4656 */           (var7[i]).rotationYaw = var8;
/* 4657 */           (var7[i]).defaultRotationYaw = var8;
/*      */         } 
/*      */       } 
/*      */       
/* 4661 */       return var7;
/*      */     } 
/* 4663 */     return new MCH_WeaponSet[] { this.dummyWeapon };
/*      */   }
/*      */ 
/*      */   
/*      */   public void switchWeapon(Entity entity, int id) {
/* 4668 */     int sid = getSeatIdByEntity(entity);
/* 4669 */     if (isValidSeatID(sid)) {
/* 4670 */       int var10000 = this.currentWeaponID[sid];
/* 4671 */       if (getWeaponNum() > 0 && this.currentWeaponID.length > 0) {
/* 4672 */         if (id < 0) {
/* 4673 */           this.currentWeaponID[sid] = -1;
/*      */         }
/*      */         
/* 4676 */         if (id >= getWeaponNum()) {
/* 4677 */           id = getWeaponNum() - 1;
/*      */         }
/*      */         
/* 4680 */         MCH_Lib.DbgLog(this.field_70170_p, "switchWeapon:" + W_Entity.getEntityId(entity) + " -> " + id, new Object[0]);
/* 4681 */         getCurrentWeapon(entity).reload();
/* 4682 */         this.currentWeaponID[sid] = id;
/* 4683 */         MCH_WeaponSet ws = getCurrentWeapon(entity);
/* 4684 */         ws.onSwitchWeapon(this.field_70170_p.field_72995_K, isInfinityAmmo(entity));
/* 4685 */         if (!this.field_70170_p.field_72995_K) {
/* 4686 */           MCH_PacketNotifyWeaponID.send((Entity)this, sid, id, ws.getAmmoNum(), ws.getRestAllAmmoNum());
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateWeaponID(int sid, int id) {
/* 4694 */     if (sid >= 0 && sid < this.currentWeaponID.length && 
/* 4695 */       getWeaponNum() > 0 && this.currentWeaponID.length > 0) {
/* 4696 */       if (id < 0) {
/* 4697 */         this.currentWeaponID[sid] = -1;
/*      */       }
/*      */       
/* 4700 */       if (id >= getWeaponNum()) {
/* 4701 */         id = getWeaponNum() - 1;
/*      */       }
/*      */       
/* 4704 */       MCH_Lib.DbgLog(this.field_70170_p, "switchWeapon:seatID=" + sid + ", WeaponID=" + id, new Object[0]);
/* 4705 */       this.currentWeaponID[sid] = id;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateWeaponRestAmmo(int id, int num) {
/* 4711 */     if (id < getWeaponNum()) {
/* 4712 */       getWeapon(id).setRestAllAmmoNum(num);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public MCH_WeaponSet getWeaponByName(String name) {
/* 4718 */     MCH_WeaponSet[] arr$ = this.weapons;
/* 4719 */     int len$ = arr$.length;
/*      */     
/* 4721 */     for (int i$ = 0; i$ < len$; i$++) {
/* 4722 */       MCH_WeaponSet ws = arr$[i$];
/* 4723 */       if (ws.isEqual(name)) {
/* 4724 */         return ws;
/*      */       }
/*      */     } 
/*      */     
/* 4728 */     return null;
/*      */   }
/*      */   
/*      */   public int getWeaponIdByName(String name) {
/* 4732 */     int id = 0;
/* 4733 */     MCH_WeaponSet[] arr$ = this.weapons;
/* 4734 */     int len$ = arr$.length;
/*      */     
/* 4736 */     for (int i$ = 0; i$ < len$; i$++) {
/* 4737 */       MCH_WeaponSet ws = arr$[i$];
/* 4738 */       if (ws.isEqual(name)) {
/* 4739 */         return id;
/*      */       }
/*      */       
/* 4742 */       id++;
/*      */     } 
/*      */     
/* 4745 */     return -1;
/*      */   }
/*      */   
/*      */   public void reloadAllWeapon() {
/* 4749 */     for (int i = 0; i < getWeaponNum(); i++) {
/* 4750 */       getWeapon(i).reloadMag();
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public MCH_WeaponSet getFirstSeatWeapon() {
/* 4756 */     return (this.currentWeaponID != null && this.currentWeaponID.length > 0 && this.currentWeaponID[0] >= 0) ? getWeapon(this.currentWeaponID[0]) : getWeapon(0);
/*      */   }
/*      */   
/*      */   public void initCurrentWeapon(Entity entity) {
/* 4760 */     int sid = getSeatIdByEntity(entity);
/* 4761 */     MCH_Lib.DbgLog(this.field_70170_p, "initCurrentWeapon:" + W_Entity.getEntityId(entity) + ":%d", new Object[] { Integer.valueOf(sid) });
/* 4762 */     if (sid >= 0 && sid < this.currentWeaponID.length) {
/* 4763 */       this.currentWeaponID[sid] = -1;
/* 4764 */       if (entity instanceof EntityPlayer || entity instanceof mcheli.mob.MCH_EntityGunner) {
/* 4765 */         this.currentWeaponID[sid] = getNextWeaponID(entity, 1);
/* 4766 */         switchWeapon(entity, getCurrentWeaponID(entity));
/* 4767 */         if (this.field_70170_p.field_72995_K) {
/* 4768 */           MCH_PacketIndNotifyAmmoNum.send(this, -1);
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void initPilotWeapon() {
/* 4776 */     this.currentWeaponID[0] = -1;
/*      */   }
/*      */   
/*      */   public MCH_WeaponSet getCurrentWeapon(Entity entity) {
/* 4780 */     return getWeapon(getCurrentWeaponID(entity));
/*      */   }
/*      */   
/*      */   protected MCH_WeaponSet getWeapon(int id) {
/* 4784 */     return (id >= 0 && this.weapons.length > 0 && id < this.weapons.length) ? this.weapons[id] : this.dummyWeapon;
/*      */   }
/*      */   
/*      */   public int getWeaponIDBySeatID(int sid) {
/* 4788 */     return (sid >= 0 && sid < this.currentWeaponID.length) ? this.currentWeaponID[sid] : -1;
/*      */   }
/*      */   
/*      */   public double getLandInDistance(Entity user) {
/* 4792 */     if (this.lastCalcLandInDistanceCount != getCountOnUpdate() && getCountOnUpdate() % 5 == 0) {
/* 4793 */       this.lastCalcLandInDistanceCount = getCountOnUpdate();
/* 4794 */       MCH_WeaponParam prm = new MCH_WeaponParam();
/* 4795 */       prm.setPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 4796 */       prm.entity = (Entity)this;
/* 4797 */       prm.user = user;
/* 4798 */       prm.isInfinity = isInfinityAmmo(prm.user);
/* 4799 */       if (prm.user != null) {
/* 4800 */         MCH_WeaponSet currentWs = getCurrentWeapon(prm.user);
/* 4801 */         if (currentWs != null) {
/* 4802 */           int sid = getSeatIdByEntity(prm.user);
/* 4803 */           if (getAcInfo().getWeaponSetById(sid) != null) {
/* 4804 */             prm.isTurret = ((MCH_AircraftInfo.Weapon)(getAcInfo().getWeaponSetById(sid)).weapons.get(0)).turret;
/*      */           }
/*      */           
/* 4807 */           this.lastLandInDistance = currentWs.getLandInDistance(prm);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4812 */     return this.lastLandInDistance;
/*      */   }
/*      */   
/*      */   public boolean useCurrentWeapon(Entity user) {
/* 4816 */     MCH_WeaponParam prm = new MCH_WeaponParam();
/* 4817 */     prm.setPosition(this.field_70165_t, this.field_70163_u, this.field_70161_v);
/* 4818 */     prm.entity = (Entity)this;
/* 4819 */     prm.user = user;
/* 4820 */     return useCurrentWeapon(prm);
/*      */   }
/*      */   
/*      */   public boolean useCurrentWeapon(MCH_WeaponParam prm) {
/* 4824 */     prm.isInfinity = isInfinityAmmo(prm.user);
/* 4825 */     if (prm.user != null) {
/* 4826 */       MCH_WeaponSet currentWs = getCurrentWeapon(prm.user);
/* 4827 */       if (currentWs != null && currentWs.canUse()) {
/* 4828 */         int sid = getSeatIdByEntity(prm.user);
/* 4829 */         if (getAcInfo().getWeaponSetById(sid) != null) {
/* 4830 */           prm.isTurret = ((MCH_AircraftInfo.Weapon)(getAcInfo().getWeaponSetById(sid)).weapons.get(0)).turret;
/*      */         }
/*      */         
/* 4833 */         int lastUsedIndex = currentWs.getCurrentWeaponIndex();
/* 4834 */         if (currentWs.use(prm)) {
/* 4835 */           MCH_WeaponSet[] shift = this.weapons;
/* 4836 */           int arr$ = shift.length;
/*      */           
/*      */           int len$;
/* 4839 */           for (len$ = 0; len$ < arr$; len$++) {
/* 4840 */             MCH_WeaponSet i$ = shift[len$];
/* 4841 */             if (i$ != currentWs && !(i$.getInfo()).group.isEmpty() && (i$.getInfo()).group.equals((currentWs.getInfo()).group)) {
/* 4842 */               i$.waitAndReloadByOther(prm.reload);
/*      */             }
/*      */           } 
/*      */           
/* 4846 */           if (!this.field_70170_p.field_72995_K) {
/* 4847 */             int var10 = 0;
/* 4848 */             MCH_WeaponSet[] var11 = this.weapons;
/* 4849 */             len$ = var11.length;
/*      */             
/* 4851 */             for (int var12 = 0; var12 < len$; var12++) {
/* 4852 */               MCH_WeaponSet ws = var11[var12];
/* 4853 */               if (ws == currentWs) {
/*      */                 break;
/*      */               }
/*      */               
/* 4857 */               var10 += ws.getWeaponNum();
/*      */             } 
/*      */             
/* 4860 */             var10 += lastUsedIndex;
/* 4861 */             this.useWeaponStat |= (var10 < 32) ? (1 << var10) : 0;
/*      */           } 
/*      */           
/* 4864 */           return true;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 4869 */     return false;
/*      */   }
/*      */   
/*      */   public void switchCurrentWeaponMode(Entity entity) {
/* 4873 */     getCurrentWeapon(entity).switchMode();
/*      */   }
/*      */   
/*      */   public int getWeaponNum() {
/* 4877 */     return this.weapons.length;
/*      */   }
/*      */   
/*      */   public int getCurrentWeaponID(Entity entity) {
/* 4881 */     if (!(entity instanceof EntityPlayer) && !(entity instanceof mcheli.mob.MCH_EntityGunner)) {
/* 4882 */       return -1;
/*      */     }
/* 4884 */     int id = getSeatIdByEntity(entity);
/* 4885 */     return (id >= 0 && id < this.currentWeaponID.length) ? this.currentWeaponID[id] : -1;
/*      */   }
/*      */ 
/*      */   
/*      */   public int getNextWeaponID(Entity entity, int step) {
/* 4890 */     if (getAcInfo() == null) {
/* 4891 */       return -1;
/*      */     }
/* 4893 */     int sid = getSeatIdByEntity(entity);
/* 4894 */     if (sid < 0) {
/* 4895 */       return -1;
/*      */     }
/* 4897 */     int id = getCurrentWeaponID(entity);
/*      */     
/*      */     int i;
/* 4900 */     for (i = 0; i < getWeaponNum(); i++) {
/* 4901 */       if (step >= 0) {
/* 4902 */         id = (id + 1) % getWeaponNum();
/*      */       } else {
/* 4904 */         id = (id > 0) ? (id - 1) : (getWeaponNum() - 1);
/*      */       } 
/*      */       
/* 4907 */       MCH_AircraftInfo.Weapon w = getAcInfo().getWeaponById(id);
/* 4908 */       if (w != null) {
/* 4909 */         MCH_WeaponInfo wi = getWeaponInfoById(id);
/* 4910 */         int wpsid = getWeaponSeatID(wi, w);
/* 4911 */         if (wpsid < getSeatNum() + 1 + 1 && (wpsid == sid || (sid == 0 && w.canUsePilot && !(getEntityBySeatId(wpsid) instanceof EntityPlayer) && !(getEntityBySeatId(wpsid) instanceof mcheli.mob.MCH_EntityGunner)))) {
/*      */           break;
/*      */         }
/*      */       } 
/*      */     } 
/*      */     
/* 4917 */     if (i >= getWeaponNum()) {
/* 4918 */       return -1;
/*      */     }
/* 4920 */     MCH_Lib.DbgLog(this.field_70170_p, "getNextWeaponID:%d:->%d", new Object[] { Integer.valueOf(W_Entity.getEntityId(entity)), Integer.valueOf(id) });
/* 4921 */     return id;
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public int getWeaponSeatID(MCH_WeaponInfo wi, MCH_AircraftInfo.Weapon w) {
/* 4928 */     return (wi != null && (wi.target & 0xC3) == 0 && wi.type.isEmpty() && (MCH_MOD.proxy.isSinglePlayer() || MCH_Config.TestMode.prmBool)) ? 1000 : w.seatID;
/*      */   }
/*      */   
/*      */   public boolean isMissileCameraMode(Entity entity) {
/* 4932 */     return (getTVMissile() != null && isCameraView(entity));
/*      */   }
/*      */   
/*      */   public boolean isPilotReloading() {
/* 4936 */     return (getCommonStatus(2) || this.supplyAmmoWait > 0);
/*      */   }
/*      */   
/*      */   public int getUsedWeaponStat() {
/* 4940 */     if (getAcInfo() == null)
/* 4941 */       return 0; 
/* 4942 */     if (getAcInfo().getWeaponNum() <= 0) {
/* 4943 */       return 0;
/*      */     }
/* 4945 */     int stat = 0;
/* 4946 */     int i = 0;
/* 4947 */     MCH_WeaponSet[] arr$ = this.weapons;
/* 4948 */     int len$ = arr$.length;
/*      */     
/* 4950 */     for (int i$ = 0; i$ < len$; i$++) {
/* 4951 */       MCH_WeaponSet w = arr$[i$];
/* 4952 */       if (i >= 32) {
/*      */         break;
/*      */       }
/*      */       
/* 4956 */       for (int wi = 0; wi < w.getWeaponNum() && i < 32; wi++) {
/* 4957 */         stat |= w.isUsed(wi) ? (1 << i) : 0;
/* 4958 */         i++;
/*      */       } 
/*      */     } 
/*      */     
/* 4962 */     return stat;
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isWeaponNotCooldown(MCH_WeaponSet checkWs, int index) {
/* 4967 */     if (getAcInfo() == null)
/* 4968 */       return false; 
/* 4969 */     if (getAcInfo().getWeaponNum() <= 0) {
/* 4970 */       return false;
/*      */     }
/* 4972 */     int shift = 0;
/* 4973 */     MCH_WeaponSet[] arr$ = this.weapons;
/* 4974 */     int len$ = arr$.length;
/*      */     
/* 4976 */     for (int i$ = 0; i$ < len$; i$++) {
/* 4977 */       MCH_WeaponSet ws = arr$[i$];
/* 4978 */       if (ws == checkWs) {
/*      */         break;
/*      */       }
/*      */       
/* 4982 */       shift += ws.getWeaponNum();
/*      */     } 
/*      */     
/* 4985 */     shift += index;
/* 4986 */     return (shift < 32) ? (((this.useWeaponStat & 1 << shift) != 0)) : false;
/*      */   }
/*      */ 
/*      */   
/*      */   public void updateWeapons() {
/* 4991 */     if (getAcInfo() != null && 
/* 4992 */       getAcInfo().getWeaponNum() > 0) {
/* 4993 */       int prevUseWeaponStat = this.useWeaponStat;
/* 4994 */       if (!this.field_70170_p.field_72995_K) {
/* 4995 */         this.useWeaponStat |= getUsedWeaponStat();
/* 4996 */         func_70096_w().func_75692_b(24, new Integer(this.useWeaponStat));
/* 4997 */         this.useWeaponStat = 0;
/*      */       } else {
/* 4999 */         this.useWeaponStat = func_70096_w().func_75679_c(24);
/*      */       } 
/*      */       
/* 5002 */       float yaw = MathHelper.func_76142_g(getRotYaw());
/* 5003 */       float pitch = MathHelper.func_76142_g(getRotPitch());
/* 5004 */       int id = 0;
/*      */       
/* 5006 */       for (int wid = 0; wid < this.weapons.length; wid++) {
/* 5007 */         MCH_WeaponSet w = this.weapons[wid];
/* 5008 */         boolean isLongDelay = false;
/* 5009 */         if (w.getFirstWeapon() != null) {
/* 5010 */           isLongDelay = w.isLongDelayWeapon();
/*      */         }
/*      */         
/* 5013 */         boolean isSelected = false;
/* 5014 */         int[] arr$ = this.currentWeaponID;
/* 5015 */         int index = arr$.length;
/*      */         
/* 5017 */         for (int i$ = 0; i$ < index; i$++) {
/* 5018 */           int swid = arr$[i$];
/* 5019 */           if (swid == wid) {
/* 5020 */             isSelected = true;
/*      */             
/*      */             break;
/*      */           } 
/*      */         } 
/* 5025 */         boolean isWpnUsed = false;
/*      */ 
/*      */         
/* 5028 */         for (index = 0; index < w.getWeaponNum(); index++) {
/* 5029 */           boolean isPrevUsed = (id < 32 && (prevUseWeaponStat & 1 << id) != 0);
/* 5030 */           boolean isUsed = (id < 32 && (this.useWeaponStat & 1 << id) != 0);
/* 5031 */           if (isLongDelay && isPrevUsed && isUsed) {
/* 5032 */             isUsed = false;
/*      */           }
/*      */           
/* 5035 */           isWpnUsed |= isUsed;
/* 5036 */           if (!isPrevUsed && isUsed) {
/* 5037 */             float ey = (w.getInfo()).recoil;
/* 5038 */             if (ey > 0.0F) {
/* 5039 */               this.recoilCount = 30;
/* 5040 */               this.recoilValue = ey;
/* 5041 */               this.recoilYaw = w.rotationYaw;
/*      */             } 
/*      */           } 
/*      */           
/* 5045 */           if (this.field_70170_p.field_72995_K && isUsed) {
/* 5046 */             Vec3 wrv = MCH_Lib.RotVec3(0.0D, 0.0D, -1.0D, -w.rotationYaw - yaw, -w.rotationPitch);
/* 5047 */             Vec3 spv = w.getCurrentWeapon().getShotPos((Entity)this);
/* 5048 */             spawnParticleMuzzleFlash(this.field_70170_p, w.getInfo(), this.field_70165_t + spv.field_72450_a, this.field_70163_u + spv.field_72448_b, this.field_70161_v + spv.field_72449_c, wrv);
/*      */           } 
/*      */           
/* 5051 */           w.updateWeapon((Entity)this, isUsed, index);
/* 5052 */           id++;
/*      */         } 
/*      */         
/* 5055 */         w.update((Entity)this, isSelected, isWpnUsed);
/* 5056 */         MCH_AircraftInfo.Weapon wi = getAcInfo().getWeaponById(wid);
/* 5057 */         if (wi != null && !isDestroyed()) {
/* 5058 */           Entity entity = getEntityBySeatId(getWeaponSeatID(getWeaponInfoById(wid), wi));
/* 5059 */           if (wi.canUsePilot && !(entity instanceof EntityPlayer) && !(entity instanceof mcheli.mob.MCH_EntityGunner)) {
/* 5060 */             entity = getEntityBySeatId(0);
/*      */           }
/*      */           
/* 5063 */           if (!(entity instanceof EntityPlayer) && !(entity instanceof mcheli.mob.MCH_EntityGunner)) {
/* 5064 */             w.rotationTurretYaw = getLastRiderYaw() - getRotYaw();
/* 5065 */             if (this.field_70154_o != null) {
/* 5066 */               w.rotationYaw = 0.0F;
/*      */             }
/*      */           } else {
/*      */             
/* 5070 */             if ((int)wi.minYaw != 0 || (int)wi.maxYaw != 0) {
/* 5071 */               float f1 = wi.turret ? (MathHelper.func_76142_g(getLastRiderYaw()) - yaw) : 0.0F;
/* 5072 */               float ey = MathHelper.func_76142_g(entity.field_70177_z - yaw - wi.defaultYaw - f1);
/* 5073 */               if (Math.abs((int)wi.minYaw) < 360 && Math.abs((int)wi.maxYaw) < 360) {
/* 5074 */                 float targetYaw = MCH_Lib.RNG(ey, wi.minYaw, wi.maxYaw);
/* 5075 */                 float wy = w.rotationYaw - wi.defaultYaw - f1;
/* 5076 */                 if (targetYaw < wy) {
/* 5077 */                   if (wy - targetYaw > 15.0F) {
/* 5078 */                     wy -= 15.0F;
/*      */                   } else {
/* 5080 */                     wy = targetYaw;
/*      */                   } 
/* 5082 */                 } else if (targetYaw > wy) {
/* 5083 */                   if (targetYaw - wy > 15.0F) {
/* 5084 */                     wy += 15.0F;
/*      */                   } else {
/* 5086 */                     wy = targetYaw;
/*      */                   } 
/*      */                 } 
/*      */                 
/* 5090 */                 w.rotationYaw = wy + wi.defaultYaw + f1;
/*      */               } else {
/* 5092 */                 w.rotationYaw = ey + f1;
/*      */               } 
/*      */             } 
/*      */             
/* 5096 */             float ty = MathHelper.func_76142_g(entity.field_70125_A - pitch);
/* 5097 */             w.rotationPitch = MCH_Lib.RNG(ty, wi.minPitch, wi.maxPitch);
/* 5098 */             w.rotationTurretYaw = 0.0F;
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/* 5103 */       updateWeaponBay();
/* 5104 */       if (this.hitStatus > 0) {
/* 5105 */         this.hitStatus--;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public void updateWeaponsRotation() {
/* 5113 */     if (getAcInfo() != null && 
/* 5114 */       getAcInfo().getWeaponNum() > 0 && 
/* 5115 */       !isDestroyed()) {
/* 5116 */       float yaw = MathHelper.func_76142_g(getRotYaw());
/* 5117 */       float pitch = MathHelper.func_76142_g(getRotPitch());
/*      */       
/* 5119 */       for (int wid = 0; wid < this.weapons.length; wid++) {
/* 5120 */         MCH_WeaponSet w = this.weapons[wid];
/* 5121 */         MCH_AircraftInfo.Weapon wi = getAcInfo().getWeaponById(wid);
/* 5122 */         if (wi != null) {
/* 5123 */           Entity entity = getEntityBySeatId(getWeaponSeatID(getWeaponInfoById(wid), wi));
/* 5124 */           if (wi.canUsePilot && !(entity instanceof EntityPlayer) && !(entity instanceof mcheli.mob.MCH_EntityGunner)) {
/* 5125 */             entity = getEntityBySeatId(0);
/*      */           }
/*      */           
/* 5128 */           if (!(entity instanceof EntityPlayer) && !(entity instanceof mcheli.mob.MCH_EntityGunner)) {
/* 5129 */             w.rotationTurretYaw = getLastRiderYaw() - getRotYaw();
/*      */           } else {
/*      */             
/* 5132 */             if ((int)wi.minYaw != 0 || (int)wi.maxYaw != 0) {
/* 5133 */               float f1 = wi.turret ? (MathHelper.func_76142_g(getLastRiderYaw()) - yaw) : 0.0F;
/* 5134 */               float ey = MathHelper.func_76142_g(entity.field_70177_z - yaw - wi.defaultYaw - f1);
/* 5135 */               if (Math.abs((int)wi.minYaw) < 360 && Math.abs((int)wi.maxYaw) < 360) {
/* 5136 */                 float targetYaw = MCH_Lib.RNG(ey, wi.minYaw, wi.maxYaw);
/* 5137 */                 float wy = w.rotationYaw - wi.defaultYaw - f1;
/* 5138 */                 if (targetYaw < wy) {
/* 5139 */                   if (wy - targetYaw > 15.0F) {
/* 5140 */                     wy -= 15.0F;
/*      */                   } else {
/* 5142 */                     wy = targetYaw;
/*      */                   } 
/* 5144 */                 } else if (targetYaw > wy) {
/* 5145 */                   if (targetYaw - wy > 15.0F) {
/* 5146 */                     wy += 15.0F;
/*      */                   } else {
/* 5148 */                     wy = targetYaw;
/*      */                   } 
/*      */                 } 
/*      */                 
/* 5152 */                 w.rotationYaw = wy + wi.defaultYaw + f1;
/*      */               } else {
/* 5154 */                 w.rotationYaw = ey + f1;
/*      */               } 
/*      */             } 
/*      */             
/* 5158 */             float ty = MathHelper.func_76142_g(entity.field_70125_A - pitch);
/* 5159 */             w.rotationPitch = MCH_Lib.RNG(ty, wi.minPitch, wi.maxPitch);
/* 5160 */             w.rotationTurretYaw = 0.0F;
/*      */           } 
/*      */         } 
/*      */         
/* 5164 */         w.prevRotationYaw = w.rotationYaw;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   private void spawnParticleMuzzleFlash(World w, MCH_WeaponInfo wi, double px, double py, double pz, Vec3 wrv) {
/* 5175 */     if (wi.listMuzzleFlashSmoke != null) {
/* 5176 */       Iterator<MCH_WeaponInfo.MuzzleFlash> i$ = wi.listMuzzleFlashSmoke.iterator();
/*      */       
/* 5178 */       while (i$.hasNext()) {
/* 5179 */         MCH_WeaponInfo.MuzzleFlash mf = i$.next();
/* 5180 */         double color = px + -wrv.field_72450_a * mf.dist;
/* 5181 */         double y = py + -wrv.field_72448_b * mf.dist;
/* 5182 */         double z = pz + -wrv.field_72449_c * mf.dist;
/* 5183 */         MCH_ParticleParam p = new MCH_ParticleParam(w, "smoke", px, py, pz);
/* 5184 */         p.size = mf.size;
/*      */         
/* 5186 */         for (int i = 0; i < mf.num; i++) {
/* 5187 */           p.a = mf.a * 0.9F + w.field_73012_v.nextFloat() * 0.1F;
/* 5188 */           float color1 = w.field_73012_v.nextFloat() * 0.1F;
/* 5189 */           p.r = color1 + mf.r * 0.9F;
/* 5190 */           p.g = color1 + mf.g * 0.9F;
/* 5191 */           p.b = color1 + mf.b * 0.9F;
/* 5192 */           p.age = (int)(mf.age + 0.1D * mf.age * w.field_73012_v.nextFloat());
/* 5193 */           p.posX = color + (w.field_73012_v.nextDouble() - 0.5D) * mf.range;
/* 5194 */           p.posY = y + (w.field_73012_v.nextDouble() - 0.5D) * mf.range;
/* 5195 */           p.posZ = z + (w.field_73012_v.nextDouble() - 0.5D) * mf.range;
/* 5196 */           p.motionX = w.field_73012_v.nextDouble() * ((p.posX < color) ? -0.2D : 0.2D);
/* 5197 */           p.motionY = w.field_73012_v.nextDouble() * ((p.posY < y) ? -0.03D : 0.03D);
/* 5198 */           p.motionZ = w.field_73012_v.nextDouble() * ((p.posZ < z) ? -0.2D : 0.2D);
/* 5199 */           MCH_ParticlesUtil.spawnParticle(p);
/*      */         } 
/*      */       } 
/*      */     } 
/*      */     
/* 5204 */     if (wi.listMuzzleFlash != null) {
/* 5205 */       Iterator<MCH_WeaponInfo.MuzzleFlash> i$ = wi.listMuzzleFlash.iterator();
/*      */       
/* 5207 */       while (i$.hasNext()) {
/* 5208 */         MCH_WeaponInfo.MuzzleFlash mf = i$.next();
/* 5209 */         float var21 = this.field_70146_Z.nextFloat() * 0.1F + 0.9F;
/* 5210 */         MCH_ParticlesUtil.spawnParticleExplode(this.field_70170_p, px + -wrv.field_72450_a * mf.dist, py + -wrv.field_72448_b * mf.dist, pz + -wrv.field_72449_c * mf.dist, mf.size, var21 * mf.r, var21 * mf.g, var21 * mf.b, mf.a, mf.age + w.field_73012_v.nextInt(3));
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   private void updateWeaponBay() {
/* 5217 */     for (int i = 0; i < this.weaponBays.length; i++) {
/* 5218 */       WeaponBay wb = this.weaponBays[i];
/* 5219 */       MCH_AircraftInfo.WeaponBay info = (getAcInfo()).partWeaponBay.get(i);
/* 5220 */       boolean isSelected = false;
/* 5221 */       Integer[] arr$ = info.weaponIds;
/* 5222 */       int len$ = arr$.length;
/*      */       
/* 5224 */       for (int i$ = 0; i$ < len$; i$++) {
/* 5225 */         int wid = arr$[i$].intValue();
/*      */         
/* 5227 */         for (int sid = 0; sid < this.currentWeaponID.length; sid++) {
/* 5228 */           if (wid == this.currentWeaponID[sid] && getEntityBySeatId(sid) != null) {
/* 5229 */             isSelected = true;
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/* 5234 */       wb.prevRot = wb.rot;
/* 5235 */       if (isSelected) {
/* 5236 */         if (wb.rot < 90.0F) {
/* 5237 */           wb.rot += 3.0F;
/*      */         }
/*      */         
/* 5240 */         if (wb.rot >= 90.0F) {
/* 5241 */           wb.rot = 90.0F;
/*      */         }
/*      */       } else {
/* 5244 */         if (wb.rot > 0.0F) {
/* 5245 */           wb.rot -= 3.0F;
/*      */         }
/*      */         
/* 5248 */         if (wb.rot <= 0.0F) {
/* 5249 */           wb.rot = 0.0F;
/*      */         }
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public int getHitStatus() {
/* 5257 */     return this.hitStatus;
/*      */   }
/*      */   
/*      */   public int getMaxHitStatus() {
/* 5261 */     return 15;
/*      */   }
/*      */   
/*      */   public void hitBullet() {
/* 5265 */     this.hitStatus = getMaxHitStatus();
/*      */   }
/*      */   
/*      */   public void initRotationYaw(float yaw) {
/* 5269 */     this.field_70177_z = yaw;
/* 5270 */     this.field_70126_B = yaw;
/* 5271 */     this.lastRiderYaw = yaw;
/* 5272 */     this.lastSearchLightYaw = yaw;
/* 5273 */     MCH_WeaponSet[] arr$ = this.weapons;
/* 5274 */     int len$ = arr$.length;
/*      */     
/* 5276 */     for (int i$ = 0; i$ < len$; i$++) {
/* 5277 */       MCH_WeaponSet w = arr$[i$];
/* 5278 */       w.rotationYaw = w.defaultRotationYaw;
/* 5279 */       w.rotationPitch = 0.0F;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public MCH_AircraftInfo getAcInfo() {
/* 5285 */     return this.acInfo;
/*      */   }
/*      */   
/*      */   public abstract Item getItem();
/*      */   
/*      */   public void setAcInfo(MCH_AircraftInfo info) {
/* 5291 */     this.acInfo = info;
/* 5292 */     if (info != null) {
/* 5293 */       this.partHatch = createHatch();
/* 5294 */       this.partCanopy = createCanopy();
/* 5295 */       this.partLandingGear = createLandingGear();
/* 5296 */       this.weaponBays = createWeaponBays();
/* 5297 */       this.rotPartRotation = new float[info.partRotPart.size()];
/* 5298 */       this.prevRotPartRotation = new float[info.partRotPart.size()];
/* 5299 */       this.extraBoundingBox = createExtraBoundingBox();
/* 5300 */       this.partEntities = createParts();
/* 5301 */       this.field_70138_W = info.stepHeight;
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public MCH_BoundingBox[] createExtraBoundingBox() {
/* 5307 */     MCH_BoundingBox[] ar = new MCH_BoundingBox[(getAcInfo()).extraBoundingBox.size()];
/* 5308 */     int i = 0;
/*      */     
/* 5310 */     for (MCH_BoundingBox bb : (getAcInfo()).extraBoundingBox) {
/*      */       
/* 5312 */       ar[i] = bb.copy();
/*      */       i++;
/*      */     } 
/* 5315 */     return ar;
/*      */   }
/*      */   
/*      */   public Entity[] createParts() {
/* 5319 */     Entity[] list = { this.partEntities[0] };
/* 5320 */     return list;
/*      */   }
/*      */   
/*      */   public void updateUAV() {
/* 5324 */     if (isUAV()) {
/* 5325 */       if (this.field_70170_p.field_72995_K) {
/* 5326 */         int udx = func_70096_w().func_75679_c(22);
/* 5327 */         if (udx > 0) {
/* 5328 */           if (this.uavStation == null) {
/* 5329 */             Entity uavEntity = this.field_70170_p.func_73045_a(udx);
/* 5330 */             if (uavEntity instanceof MCH_EntityUavStation) {
/* 5331 */               this.uavStation = (MCH_EntityUavStation)uavEntity;
/* 5332 */               this.uavStation.setControlAircract(this);
/*      */             
/*      */             }
/*      */ 
/*      */           
/*      */           }
/*      */         
/*      */         }
/* 5340 */         else if (this.uavStation != null) {
/*      */ 
/*      */         
/*      */         } 
/* 5344 */       } else if (this.uavStation != null) {
/* 5345 */         double udx1 = this.field_70165_t - this.uavStation.field_70165_t;
/* 5346 */         double udz = this.field_70161_v - this.uavStation.field_70161_v;
/* 5347 */         if (udx1 * udx1 + udz * udz > 151290.0D) {
/* 5348 */           this.uavStation.setControlAircract((MCH_EntityAircraft)null);
/* 5349 */           setUavStation((MCH_EntityUavStation)null);
/* 5350 */           attackEntityFrom(DamageSource.field_76380_i, getMaxHP() + 10);
/*      */         } 
/*      */       } 
/*      */       
/* 5354 */       if (this.uavStation != null && this.uavStation.field_70128_L) {
/* 5355 */         this.uavStation = null;
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void switchGunnerMode(boolean mode) {
/* 5362 */     boolean debug_bk_mode = this.isGunnerMode;
/* 5363 */     Entity pilot = getEntityBySeatId(0);
/* 5364 */     if (!mode || canSwitchGunnerMode()) {
/* 5365 */       if (this.isGunnerMode && !mode) {
/* 5366 */         setCurrentThrottle(this.beforeHoverThrottle);
/* 5367 */         this.isGunnerMode = false;
/* 5368 */         this.camera.setCameraZoom(1.0F);
/* 5369 */         getCurrentWeapon(pilot).onSwitchWeapon(this.field_70170_p.field_72995_K, isInfinityAmmo(pilot));
/* 5370 */       } else if (!this.isGunnerMode && mode) {
/* 5371 */         this.beforeHoverThrottle = getCurrentThrottle();
/* 5372 */         this.isGunnerMode = true;
/* 5373 */         this.camera.setCameraZoom(1.0F);
/* 5374 */         getCurrentWeapon(pilot).onSwitchWeapon(this.field_70170_p.field_72995_K, isInfinityAmmo(pilot));
/*      */       } 
/*      */     }
/*      */     
/* 5378 */     MCH_Lib.DbgLog(this.field_70170_p, "switchGunnerMode %s->%s", new Object[] { debug_bk_mode ? "ON" : "OFF", mode ? "ON" : "OFF" });
/*      */   }
/*      */   
/*      */   public boolean canSwitchGunnerMode() {
/* 5382 */     return (getAcInfo() != null && (getAcInfo()).isEnableGunnerMode) ? (!isCanopyClose() ? false : ((!(getAcInfo()).isEnableConcurrentGunnerMode && getEntityBySeatId(1) instanceof EntityPlayer) ? false : (!isHoveringMode()))) : false;
/*      */   }
/*      */   
/*      */   public boolean canSwitchGunnerModeOtherSeat(EntityPlayer player) {
/* 5386 */     int sid = getSeatIdByEntity((Entity)player);
/* 5387 */     if (sid > 0) {
/* 5388 */       MCH_SeatInfo info = getSeatInfo(sid);
/* 5389 */       if (info != null) {
/* 5390 */         return (info.gunner && info.switchgunner);
/*      */       }
/*      */     } 
/*      */     
/* 5394 */     return false;
/*      */   }
/*      */   
/*      */   public void switchGunnerModeOtherSeat(EntityPlayer player) {
/* 5398 */     this.isGunnerModeOtherSeat = !this.isGunnerModeOtherSeat;
/*      */   }
/*      */   
/*      */   public boolean isHoveringMode() {
/* 5402 */     return this.isHoveringMode;
/*      */   }
/*      */   
/*      */   public void switchHoveringMode(boolean mode) {
/* 5406 */     stopRepelling();
/* 5407 */     if (canSwitchHoveringMode() && isHoveringMode() != mode) {
/* 5408 */       if (mode) {
/* 5409 */         this.beforeHoverThrottle = getCurrentThrottle();
/*      */       } else {
/* 5411 */         setCurrentThrottle(this.beforeHoverThrottle);
/*      */       } 
/*      */       
/* 5414 */       this.isHoveringMode = mode;
/* 5415 */       if (this.field_70153_n != null) {
/* 5416 */         this.field_70153_n.field_70125_A = 0.0F;
/* 5417 */         this.field_70153_n.field_70127_C = 0.0F;
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canSwitchHoveringMode() {
/* 5424 */     return (getAcInfo() == null) ? false : (!this.isGunnerMode);
/*      */   }
/*      */   
/*      */   public boolean isHovering() {
/* 5428 */     return (this.isGunnerMode || isHoveringMode());
/*      */   }
/*      */   
/*      */   public boolean getIsGunnerMode(Entity entity) {
/* 5432 */     if (getAcInfo() == null) {
/* 5433 */       return false;
/*      */     }
/* 5435 */     int id = getSeatIdByEntity(entity);
/* 5436 */     if (id < 0)
/* 5437 */       return false; 
/* 5438 */     if (id == 0 && (getAcInfo()).isEnableGunnerMode) {
/* 5439 */       return this.isGunnerMode;
/*      */     }
/* 5441 */     MCH_SeatInfo[] st = getSeatsInfo();
/* 5442 */     return (id < st.length && (st[id]).gunner) ? ((this.field_70170_p.field_72995_K && (st[id]).switchgunner) ? this.isGunnerModeOtherSeat : true) : false;
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean isPilot(Entity player) {
/* 5448 */     return W_Entity.isEqual(getRiddenByEntity(), player);
/*      */   }
/*      */   
/*      */   public boolean canSwitchFreeLook() {
/* 5452 */     return true;
/*      */   }
/*      */   
/*      */   public boolean isFreeLookMode() {
/* 5456 */     return (getCommonStatus(1) || isRepelling());
/*      */   }
/*      */   
/*      */   public void switchFreeLookMode(boolean b) {
/* 5460 */     setCommonStatus(1, b);
/*      */   }
/*      */   
/*      */   public void switchFreeLookModeClient(boolean b) {
/* 5464 */     setCommonStatus(1, b, true);
/*      */   }
/*      */   
/*      */   public boolean canSwitchGunnerFreeLook(EntityPlayer player) {
/* 5468 */     MCH_SeatInfo seatInfo = getSeatInfo((Entity)player);
/* 5469 */     return (seatInfo != null && seatInfo.fixRot && getIsGunnerMode((Entity)player));
/*      */   }
/*      */   
/*      */   public boolean isGunnerLookMode(EntityPlayer player) {
/* 5473 */     return isPilot((Entity)player) ? false : this.isGunnerFreeLookMode;
/*      */   }
/*      */   
/*      */   public void switchGunnerFreeLookMode(boolean b) {
/* 5477 */     this.isGunnerFreeLookMode = b;
/*      */   }
/*      */   
/*      */   public void switchGunnerFreeLookMode() {
/* 5481 */     switchGunnerFreeLookMode(!this.isGunnerFreeLookMode);
/*      */   }
/*      */   
/*      */   public void updateParts(int stat) {
/* 5485 */     if (!isDestroyed()) {
/* 5486 */       MCH_Parts[] parts = { this.partHatch, this.partCanopy, this.partLandingGear };
/* 5487 */       MCH_Parts[] blockId = parts;
/* 5488 */       int unfold = parts.length;
/*      */       
/* 5490 */       for (int i$ = 0; i$ < unfold; i$++) {
/* 5491 */         MCH_Parts p = blockId[i$];
/* 5492 */         if (p != null) {
/* 5493 */           p.updateStatusClient(stat);
/* 5494 */           p.update();
/*      */         } 
/*      */       } 
/*      */       
/* 5498 */       if (!isDestroyed() && !this.field_70170_p.field_72995_K && this.partLandingGear != null) {
/* 5499 */         boolean var7 = false;
/*      */         
/* 5501 */         if (!isLandingGearFolded() && this.partLandingGear.getFactor() <= 0.1F) {
/* 5502 */           int var8 = MCH_Lib.getBlockIdY((Entity)this, 3, -20);
/* 5503 */           if ((getCurrentThrottle() <= 0.800000011920929D || this.field_70122_E || var8 != 0) && (getAcInfo()).isFloat && (func_70090_H() || MCH_Lib.getBlockY((Entity)this, 3, -20, true) == W_Block.getWater())) {
/* 5504 */             this.partLandingGear.setStatusServer(true);
/*      */           }
/* 5506 */         } else if (isLandingGearFolded() && this.partLandingGear.getFactor() >= 0.9F) {
/* 5507 */           int var8 = MCH_Lib.getBlockIdY((Entity)this, 3, -10);
/* 5508 */           if (getCurrentThrottle() < getUnfoldLandingGearThrottle() && var8 != 0) {
/* 5509 */             boolean var9 = true;
/* 5510 */             if ((getAcInfo()).isFloat) {
/* 5511 */               var8 = MCH_Lib.getBlockIdY(this.field_70170_p, this.field_70165_t, this.field_70163_u + 1.0D + (getAcInfo()).floatOffset, this.field_70161_v, 1, -150, true);
/* 5512 */               if (W_Block.isEqual(var8, W_Block.getWater())) {
/* 5513 */                 var9 = false;
/*      */               }
/*      */             } 
/*      */             
/* 5517 */             if (var9) {
/* 5518 */               this.partLandingGear.setStatusServer(false);
/*      */             }
/* 5520 */           } else if (getVtolMode() == 2 && var8 != 0) {
/* 5521 */             this.partLandingGear.setStatusServer(false);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public float getUnfoldLandingGearThrottle() {
/* 5530 */     return 0.8F;
/*      */   }
/*      */   
/*      */   private int getPartStatus() {
/* 5534 */     return func_70096_w().func_75679_c(31);
/*      */   }
/*      */   
/*      */   private void setPartStatus(int n) {
/* 5538 */     func_70096_w().func_75692_b(31, Integer.valueOf(n));
/*      */   }
/*      */   
/*      */   protected void initPartRotation(float yaw, float pitch) {
/* 5542 */     this.lastRiderYaw = yaw;
/* 5543 */     this.prevLastRiderYaw = yaw;
/* 5544 */     this.camera.partRotationYaw = yaw;
/* 5545 */     this.camera.prevPartRotationYaw = yaw;
/* 5546 */     this.lastSearchLightYaw = yaw;
/*      */   }
/*      */   
/*      */   public int getLastPartStatusMask() {
/* 5550 */     return 24;
/*      */   }
/*      */   
/*      */   public int getModeSwitchCooldown() {
/* 5554 */     return this.modeSwitchCooldown;
/*      */   }
/*      */   
/*      */   public void setModeSwitchCooldown(int n) {
/* 5558 */     this.modeSwitchCooldown = n;
/*      */   }
/*      */   
/*      */   protected WeaponBay[] createWeaponBays() {
/* 5562 */     WeaponBay[] wbs = new WeaponBay[(getAcInfo()).partWeaponBay.size()];
/*      */     
/* 5564 */     for (int i = 0; i < wbs.length; i++) {
/* 5565 */       wbs[i] = new WeaponBay();
/*      */     }
/*      */     
/* 5568 */     return wbs;
/*      */   }
/*      */   
/*      */   protected MCH_Parts createHatch() {
/* 5572 */     MCH_Parts hatch = null;
/* 5573 */     if (getAcInfo().haveHatch()) {
/* 5574 */       hatch = new MCH_Parts((Entity)this, 4, 31, "Hatch");
/* 5575 */       hatch.rotationMax = 90.0F;
/* 5576 */       hatch.rotationInv = 1.5F;
/* 5577 */       hatch.soundEndSwichOn.setPrm("plane_cc", 1.0F, 1.0F);
/* 5578 */       hatch.soundEndSwichOff.setPrm("plane_cc", 1.0F, 1.0F);
/* 5579 */       hatch.soundSwitching.setPrm("plane_cv", 1.0F, 0.5F);
/*      */     } 
/*      */     
/* 5582 */     return hatch;
/*      */   }
/*      */   
/*      */   public boolean haveHatch() {
/* 5586 */     return (this.partHatch != null);
/*      */   }
/*      */   
/*      */   public boolean canFoldHatch() {
/* 5590 */     return (this.partHatch != null && this.modeSwitchCooldown <= 0) ? this.partHatch.isOFF() : false;
/*      */   }
/*      */   
/*      */   public boolean canUnfoldHatch() {
/* 5594 */     return (this.partHatch != null && this.modeSwitchCooldown <= 0) ? this.partHatch.isON() : false;
/*      */   }
/*      */   
/*      */   public void foldHatch(boolean fold) {
/* 5598 */     foldHatch(fold, false);
/*      */   }
/*      */   
/*      */   public void foldHatch(boolean fold, boolean force) {
/* 5602 */     if (this.partHatch != null && (
/* 5603 */       force || this.modeSwitchCooldown <= 0)) {
/* 5604 */       this.partHatch.setStatusServer(fold);
/* 5605 */       this.modeSwitchCooldown = 20;
/* 5606 */       if (!fold) {
/* 5607 */         stopUnmountCrew();
/*      */       }
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public float getHatchRotation() {
/* 5615 */     return (this.partHatch != null) ? this.partHatch.rotation : 0.0F;
/*      */   }
/*      */   
/*      */   public float getPrevHatchRotation() {
/* 5619 */     return (this.partHatch != null) ? this.partHatch.prevRotation : 0.0F;
/*      */   }
/*      */   
/*      */   public void foldLandingGear() {
/* 5623 */     if (this.partLandingGear != null && getModeSwitchCooldown() <= 0) {
/* 5624 */       this.partLandingGear.setStatusServer(true);
/* 5625 */       setModeSwitchCooldown(20);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void unfoldLandingGear() {
/* 5630 */     if (this.partLandingGear != null && getModeSwitchCooldown() <= 0 && 
/* 5631 */       isLandingGearFolded()) {
/* 5632 */       this.partLandingGear.setStatusServer(false);
/* 5633 */       setModeSwitchCooldown(20);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean canFoldLandingGear() {
/* 5640 */     if (getLandingGearRotation() >= 1.0F) {
/* 5641 */       return false;
/*      */     }
/* 5643 */     Block block = MCH_Lib.getBlockY((Entity)this, 3, -10, true);
/* 5644 */     return (!isLandingGearFolded() && block == Blocks.field_150350_a);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean canUnfoldLandingGear() {
/* 5649 */     return (getLandingGearRotation() < 89.0F) ? false : isLandingGearFolded();
/*      */   }
/*      */   
/*      */   public boolean isLandingGearFolded() {
/* 5653 */     return (this.partLandingGear != null) ? this.partLandingGear.getStatus() : false;
/*      */   }
/*      */   
/*      */   protected MCH_Parts createLandingGear() {
/* 5657 */     MCH_Parts lg = null;
/* 5658 */     if (getAcInfo().haveLandingGear()) {
/* 5659 */       lg = new MCH_Parts((Entity)this, 2, 31, "LandingGear");
/* 5660 */       lg.rotationMax = 90.0F;
/* 5661 */       lg.rotationInv = 2.5F;
/* 5662 */       lg.soundStartSwichOn.setPrm("plane_cc", 1.0F, 0.5F);
/* 5663 */       lg.soundEndSwichOn.setPrm("plane_cc", 1.0F, 0.5F);
/* 5664 */       lg.soundStartSwichOff.setPrm("plane_cc", 1.0F, 0.5F);
/* 5665 */       lg.soundEndSwichOff.setPrm("plane_cc", 1.0F, 0.5F);
/* 5666 */       lg.soundSwitching.setPrm("plane_cv", 1.0F, 0.75F);
/*      */     } 
/*      */     
/* 5669 */     return lg;
/*      */   }
/*      */   
/*      */   public float getLandingGearRotation() {
/* 5673 */     return (this.partLandingGear != null) ? this.partLandingGear.rotation : 0.0F;
/*      */   }
/*      */   
/*      */   public float getPrevLandingGearRotation() {
/* 5677 */     return (this.partLandingGear != null) ? this.partLandingGear.prevRotation : 0.0F;
/*      */   }
/*      */   
/*      */   public int getVtolMode() {
/* 5681 */     return 0;
/*      */   }
/*      */   
/*      */   public void openCanopy() {
/* 5685 */     if (this.partCanopy != null && getModeSwitchCooldown() <= 0) {
/* 5686 */       this.partCanopy.setStatusServer(true);
/* 5687 */       setModeSwitchCooldown(20);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void openCanopy_EjectSeat() {
/* 5692 */     if (this.partCanopy != null) {
/* 5693 */       this.partCanopy.setStatusServer(true, false);
/* 5694 */       setModeSwitchCooldown(40);
/*      */     } 
/*      */   }
/*      */   
/*      */   public void closeCanopy() {
/* 5699 */     if (this.partCanopy != null && getModeSwitchCooldown() <= 0 && 
/* 5700 */       getCanopyStat()) {
/* 5701 */       this.partCanopy.setStatusServer(false);
/* 5702 */       setModeSwitchCooldown(20);
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public boolean getCanopyStat() {
/* 5709 */     return (this.partCanopy != null) ? this.partCanopy.getStatus() : false;
/*      */   }
/*      */   
/*      */   public boolean isCanopyClose() {
/* 5713 */     return (this.partCanopy == null) ? true : ((!getCanopyStat() && getCanopyRotation() <= 0.01F));
/*      */   }
/*      */   
/*      */   public float getCanopyRotation() {
/* 5717 */     return (this.partCanopy != null) ? this.partCanopy.rotation : 0.0F;
/*      */   }
/*      */   
/*      */   public float getPrevCanopyRotation() {
/* 5721 */     return (this.partCanopy != null) ? this.partCanopy.prevRotation : 0.0F;
/*      */   }
/*      */   
/*      */   protected MCH_Parts createCanopy() {
/* 5725 */     MCH_Parts canopy = null;
/* 5726 */     if (getAcInfo().haveCanopy()) {
/* 5727 */       canopy = new MCH_Parts((Entity)this, 0, 31, "Canopy");
/* 5728 */       canopy.rotationMax = 90.0F;
/* 5729 */       canopy.rotationInv = 3.5F;
/* 5730 */       canopy.soundEndSwichOn.setPrm("plane_cc", 1.0F, 1.0F);
/* 5731 */       canopy.soundEndSwichOff.setPrm("plane_cc", 1.0F, 1.0F);
/*      */     } 
/*      */     
/* 5734 */     return canopy;
/*      */   }
/*      */   
/*      */   public boolean hasBrake() {
/* 5738 */     return false;
/*      */   }
/*      */   
/*      */   public void setBrake(boolean b) {
/* 5742 */     if (!this.field_70170_p.field_72995_K) {
/* 5743 */       setCommonStatus(11, b);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean getBrake() {
/* 5749 */     return getCommonStatus(11);
/*      */   }
/*      */   
/*      */   public String getInvName() {
/* 5753 */     if (getAcInfo() == null) {
/* 5754 */       return super.getInvName();
/*      */     }
/* 5756 */     String s = (getAcInfo()).displayName;
/* 5757 */     return (s.length() <= 32) ? s : s.substring(0, 31);
/*      */   }
/*      */ 
/*      */   
/*      */   public boolean isInvNameLocalized() {
/* 5762 */     return (getAcInfo() != null);
/*      */   }
/*      */   
/*      */   public boolean getGunnerStatus() {
/* 5766 */     return getCommonStatus(12);
/*      */   }
/*      */   
/*      */   public void setGunnerStatus(boolean b) {
/* 5770 */     if (!this.field_70170_p.field_72995_K) {
/* 5771 */       setCommonStatus(12, b);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public void mountMobToSeats() {
/* 5777 */     List<Entity> list = this.field_70170_p.func_72872_a(W_Lib.getEntityLivingBaseClass(), this.field_70121_D.func_72314_b(3.0D, 2.0D, 3.0D));
/*      */     
/* 5779 */     for (int i = 0; i < list.size(); i++) {
/* 5780 */       Entity entity = list.get(i);
/* 5781 */       if (!(entity instanceof EntityPlayer) && entity.field_70154_o == null) {
/* 5782 */         int sid = 1;
/* 5783 */         MCH_EntitySeat[] arr$ = getSeats();
/* 5784 */         int len$ = arr$.length;
/*      */         
/* 5786 */         for (int i$ = 0; i$ < len$; i$++) {
/* 5787 */           MCH_EntitySeat seat = arr$[i$];
/* 5788 */           if (seat != null && seat.field_70153_n == null && !isMountedEntity(entity) && canRideSeatOrRack(sid, entity)) {
/* 5789 */             if (getSeatInfo(sid) instanceof MCH_SeatRackInfo) {
/*      */               break;
/*      */             }
/*      */             
/* 5793 */             entity.func_70078_a((Entity)seat);
/*      */           } 
/*      */           
/* 5796 */           sid++;
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */   
/*      */   public class WeaponBay
/*      */   {
/* 5806 */     public float rot = 0.0F;
/* 5807 */     public float prevRot = 0.0F;
/*      */   }
/*      */ 
/*      */   
/*      */   protected class UnmountReserve
/*      */   {
/*      */     final Entity entity;
/*      */     
/*      */     final double posX;
/*      */     final double posY;
/*      */     final double posZ;
/* 5818 */     int cnt = 5;
/*      */ 
/*      */     
/*      */     public UnmountReserve(Entity e, double x, double y, double z) {
/* 5822 */       this.entity = e;
/* 5823 */       this.posX = x;
/* 5824 */       this.posY = y;
/* 5825 */       this.posZ = z;
/*      */     }
/*      */   }
/*      */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_EntityAircraft.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */