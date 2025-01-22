package com.flansmod.common.driveables;

import com.flansmod.client.model.ModelDriveable;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.collisions.CollisionShapeBox;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.EnumFireMode;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.types.TypeFile;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.init.Items;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;

public class DriveableType extends PaintableType {
  public ModelDriveable model;
  
  public String overlay = null;
  
  public String heliGUI = null;
  
  public boolean hasScope = false;
  
  public String afterBurnName = "Afterburner";
  
  public boolean hasAfterBurner = false;
  
  public boolean autoSmoke = false;
  
  public boolean vanillaDamage = false;
  
  public boolean canStab = false;
  
  public float labjacFuel = 10.0F;
  
  public boolean Stabilizer = true;
  
  public boolean transport = false;
  
  public HashMap<EnumDriveablePart, CollisionBox> health = new HashMap<>();
  
  public HashMap<EnumDriveablePart, CollisionBox> crew = new HashMap<>();
  
  public HashMap<EnumDriveablePart, ItemStack[]> partwiseRecipe = (HashMap)new HashMap<>();
  
  public ArrayList<ItemStack> driveableRecipe = new ArrayList<>();
  
  public boolean acceptAllAmmo = true;
  
  public List<BulletType> ammo = new ArrayList<>();
  
  public boolean harvestBlocks = false;
  
  public ArrayList<Material> materialsHarvested = new ArrayList<>();
  
  public boolean collectHarvest = false;
  
  public boolean dropHarvest = false;
  
  public boolean needsThrottle = false;
  
  public Vector3f harvestBoxSize = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f harvestBoxPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public int reloadSoundTick = 15214541;
  
  public float fallDamageFactor = 1.0F;
  
  public String Gunsight = null;
  
  public String passengerGUI = null;
  
  public float gunsightZoom = 1.0F;
  
  public boolean nightScope = false;
  
  public boolean unlimitedOxygen = false;
  
  public boolean epicShip = false;
  
  public int weightLimit = 5000;
  
  public boolean radarVisible = true;
  
  public boolean hasRadar = false;
  
  public boolean hasPlaneRadar = false;
  
  public float radarRange = 69.0F;
  
  public int radarPositionOffset = 0;
  
  public int radarRefreshDelay = 0;
  
  public int slbmFlightType = 0;
  
  public int slbmDelay = 80;
  
  public int slbmRange = 300;
  
  public int slbmStrength = 10;
  
  public int slbmWarheadType = 0;
  
  public float energyRate = 1.0F;
  
  public float energyLossRate = 1.0F;
  
  public float muzzleVelocity = 1000.0F;
  
  public float projectileMass = 0.1F;
  
  public boolean showReload = true;
  
  public boolean solid = false;
  
  public EnumWeaponType primary = EnumWeaponType.NONE;
  
  public EnumWeaponType secondary = EnumWeaponType.NONE;
  
  public boolean alternatePrimary = false;
  
  public boolean alternateSecondary = false;
  
  public int shootDelayPrimary = 1;
  
  public int shootDelaySecondary = 1;
  
  public EnumFireMode modePrimary = EnumFireMode.FULLAUTO;
  
  public EnumFireMode modeSecondary = EnumFireMode.FULLAUTO;
  
  public String shootSoundPrimary;
  
  public String shootSoundSecondary;
  
  public String shootReloadSound;
  
  public ArrayList<ShootPoint> shootPointsPrimary = new ArrayList<>();
  
  public ArrayList<ShootPoint> shootPointsSecondary = new ArrayList<>();
  
  public ArrayList<PilotGun> pilotGuns = new ArrayList<>();
  
  public int reloadTimePrimary = 0;
  
  public int reloadTimeSecondary = 0;
  
  public String reloadSoundPrimary = "";
  
  public String reloadSoundSecondary = "";
  
  public int placeTimePrimary = 5;
  
  public int placeTimeSecondary = 5;
  
  public String placeSoundPrimary = "";
  
  public String placeSoundSecondary = "";
  
  public int numPassengers = 0;
  
  public Seat[] seats;
  
  public int numPassengerGunners = 0;
  
  public float vehicleGunModelScale = 1.0F;
  
  public class ShootParticle {
    float x;
    
    float y;
    
    float z;
    
    String name;
    
    public ShootParticle(String s, float x1, float y1, float z1) {
      this.x = 0.0F;
      this.y = 0.0F;
      this.z = 0.0F;
      this.x = x1;
      this.y = y1;
      this.z = z1;
      this.name = s;
    }
  }
  
  public ArrayList<ShootParticle> shootParticlesPrimary = new ArrayList<>();
  
  public ArrayList<ShootParticle> shootParticlesSecondary = new ArrayList<>();
  
  public int numCargoSlots;
  
  public int numBombSlots;
  
  public int numMissileSlots;
  
  public int fuelTankSize = 100;
  
  public float yOffset = 0.625F;
  
  public float cameraDistance = 5.0F;
  
  public ArrayList<ParticleEmitter> emitters = new ArrayList<>();
  
  public ArrayList<AfterBurnEmitter> afterBurns = new ArrayList<>();
  
  public float maxThrottle = 1.0F, maxNegativeThrottle = 0.0F;
  
  public float ClutchBrake = 0.0F;
  
  public Vector3f turretOrigin = new Vector3f();
  
  public Vector3f turretOriginOffset = new Vector3f();
  
  public DriveablePosition[] wheelPositions = new DriveablePosition[0];
  
  public float wheelSpringStrength = 0.5F;
  
  public float wheelStepHeight = 1.5F;
  
  public boolean canRoll = true;
  
  public ArrayList<DriveablePosition> collisionPoints = new ArrayList<>();
  
  public float drag = 1.0F;
  
  public boolean floatOnWater = false;
  
  public boolean placeableOnLand = true;
  
  public boolean placeableOnWater = false;
  
  public boolean placeableOnSponge = false;
  
  public boolean placeableOnPumpkin = false;
  
  public float buoyancy = 0.0165F;
  
  public float floatOffset = 0.0F;
  
  public float bulletDetectionRadius = 5.0F;
  
  public boolean onRadar = false;
  
  public int animFrames = 2;
  
  public int startSoundRange = 50;
  
  public String startSound = "";
  
  public int startSoundLength;
  
  public int engineSoundRange = 50;
  
  public String engineSound = "";
  
  public int engineSoundLength;
  
  public int backSoundRange = 50;
  
  public String idleSound = "";
  
  public int idleSoundLength = 50;
  
  public String backSound = "";
  
  public int backSoundLength;
  
  public String sonicBoomSound = "sonicBoom";
  
  public boolean collisionDamageEnable = true;
  
  public boolean pushOnCollision = true;
  
  public float collisionDamageThrottle = 0.3F;
  
  public float collisionDamageTimes = 25.0F;
  
  public boolean enableReloadTime = false;
  
  public boolean canMountEntity = false;
  
  public boolean inshallah = false;
  
  public float bulletSpread = 0.0F;
  
  public float bulletSpeed = 3.0F;
  
  public boolean rangingGun = false;
  
  public boolean isExplosionWhenDestroyed = false;
  
  public boolean nuclearDeath = false;
  
  public boolean bigDeath = false;
  
  public boolean Death = false;
  
  public float isExplosionWhenDestroyedRadius = 0.0F;
  
  public String lockedOnSound = "";
  
  public int soundTime = 0;
  
  public int canLockOnAngle = 10;
  
  public int lockOnSoundTime = 60;
  
  public String lockOnSound = "";
  
  public int maxRangeLockOn = 500;
  
  public int lockedOnSoundRange = 5;
  
  public String lockingOnSound = "";
  
  public boolean lockOnToPlanes = false, lockOnToVehicles = false, lockOnToMechas = false, lockOnToPlayers = false, lockOnToLivings = false;
  
  public boolean hasFlare = false;
  
  public int flareDelay = 500;
  
  public String flareSound = "";
  
  public int timeFlareUsing = 10;
  
  public int ticksRepairing = 200;
  
  public int repairDelay = 200;
  
  public int APSdelayMax = 295;
  
  public boolean hasAPS = false;
  
  public int radarDetectableAltitude = -1;
  
  public boolean stealth = false;
  
  public float recoilDist = 7.0F;
  
  public float recoilTime = 7.0F;
  
  public boolean fixedPrimaryFire = false;
  
  public Vector3f primaryFireAngle = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public boolean fixedSecondaryFire = false;
  
  public Vector3f secondaryFireAngle = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public float gunLength = 0.0F;
  
  public boolean setPlayerInvisible = false;
  
  public boolean invinciblePilotType = true;
  
  public float maxThrottleInWater = 0.5F;
  
  public ArrayList<Vector3f> leftTrackPoints = new ArrayList<>();
  
  public ArrayList<Vector3f> rightTrackPoints = new ArrayList<>();
  
  public float trackLinkLength = 0.0F;
  
  public boolean IT1 = false;
  
  public static ArrayList<DriveableType> types = new ArrayList<>();
  
  public ArrayList<CollisionShapeBox> collisionBox = new ArrayList<>();
  
  public boolean fancyCollision = false;
  
  public CollisionShapeBox colbox;
  
  public float maxDepth = 40.0F;
  
  public float maxOxygen = 9001.0F;
  
  public float oxygen = 9001.0F;
  
  public boolean canDive = false;
  
  public boolean fancyShip = false;
  
  public boolean panic = false;
  
  public boolean mechStomp = false;
  
  public float damageVsCrew = 0.5F;
  
  public boolean crewEngine = false;
  
  public boolean autisticHitDetection = false;
  
  public int exitTimer = 20;
  
  public boolean rocketThrottle = false;
  
  public int fuelTimer = 300;
  
  public boolean primaryRecoil = false;
  
  public boolean secondaryRecoil = false;
  
  public boolean bigRecoil = false;
  
  public float primaryRecoilHeight = 2.0F;
  
  public float secondaryRecoilHeight = 2.0F;
  
  public boolean digitalRadar = false;
  
  public float radarDetectionRangeMultiplier = 1.0F;
  
  public boolean gunRange = false;
  
  public boolean filterAmmunition = false;
  
  public String farSound;
  
  public boolean showTurretIndicator = true;
  
  public boolean alwaysShowTurret = false;
  
  public float explosionResistance = 1.0F;
  
  public boolean hasMagicArtilleryMode = false;
  
  public boolean lessOverpen = true;
  
  public float explosionPush = 0.25F;
  
  public String overheatSound = "overheatSound";
  
  public int overheatLimit = 250;
  
  public int overheatPenalty = 75;
  
  public int coolingBonus = 1;
  
  public boolean hijackablePilot = false;
  
  public DriveableType(TypeFile file) {
    super(file);
  }
  
  public void preRead(TypeFile file) {
    super.preRead(file);
    for (String line : file.lines) {
      if (line == null)
        break; 
      if (line.startsWith("//"))
        continue; 
      String[] split = line.split(" ");
      if (split.length < 2)
        continue; 
      if (split[0].equals("Passengers")) {
        this.numPassengers = Integer.parseInt(split[1]);
        this.seats = new Seat[this.numPassengers + 1];
        break;
      } 
    } 
    for (String line : file.lines) {
      if (line == null)
        break; 
      if (line.startsWith("//"))
        continue; 
      String[] split = line.split(" ");
      if (split.length < 2)
        continue; 
      if (split[0].equals("NumWheels")) {
        this.wheelPositions = new DriveablePosition[Integer.parseInt(split[1])];
        break;
      } 
    } 
    types.add(this);
  }
  
  public void postRead(TypeFile file) {
    super.postRead(file);
  }
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (split[0].equals("VehicleGunModelScale"))
        this.vehicleGunModelScale = Float.parseFloat(split[1]); 
      if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
        this.model = (ModelDriveable)FlansMod.proxy.loadModel(split[1], this.shortName, ModelDriveable.class);
      } else if (split[0].equals("VehicleGunReloadTick")) {
        this.reloadSoundTick = Integer.parseInt(split[1]);
      } else if (split[0].equals("Texture")) {
        this.texture = split[1];
      } else if (split[0].equals("IsExplosionWhenDestroyed")) {
        this.isExplosionWhenDestroyed = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("isExplosionWhenDestroyedRadius")) {
        this.isExplosionWhenDestroyedRadius = Float.parseFloat(split[1]);
      } else if (split[0].equals("FallDamageFactor")) {
        this.fallDamageFactor = Float.parseFloat(split[1]);
      } else if (split[0].equals("lessOverpen")) {
        this.lessOverpen = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("primaryRecoilStrength")) {
        this.primaryRecoilHeight = Float.parseFloat(split[1]);
      } else if (split[0].equals("alwaysShowTurret")) {
        this.alwaysShowTurret = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("hasMagicArtilleryMode")) {
        this.hasMagicArtilleryMode = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("explosionResistance")) {
        this.explosionResistance = Float.parseFloat(split[1]);
      } else if (split[0].equals("canStab")) {
        this.canStab = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("canPanic")) {
        this.panic = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("MechStomp")) {
        this.mechStomp = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("artilleryCalculator")) {
        this.gunRange = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("showTurretIndicator")) {
        this.showTurretIndicator = Boolean.parseBoolean(split[1]);
      } 
      if (split[0].equals("fuelTimer"))
        this.fuelTimer = Integer.parseInt(split[1]); 
      if (split[0].equals("rocketThrottle")) {
        this.rocketThrottle = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("labjacFuel")) {
        this.labjacFuel = 200.0F * Float.parseFloat(split[1]);
      } else if (split[0].equals("explosionPush")) {
        this.explosionPush = Float.parseFloat(split[1]);
      } else if (split[0].equals("muzzleVelocity")) {
        this.muzzleVelocity = Float.parseFloat(split[1]);
      } else if (split[0].equals("projectileMass")) {
        this.projectileMass = Float.parseFloat(split[1]);
      } else if (split[0].equals("vanillaDamage")) {
        this.vanillaDamage = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("hijackablePilot")) {
        this.hijackablePilot = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("MaxThrottle")) {
        this.maxThrottle = Float.parseFloat(split[1]) * 0.8F;
      } else if (split[0].equals("MaxNegativeThrottle")) {
        this.maxNegativeThrottle = Float.parseFloat(split[1]) * 0.8F;
      } else if (split[0].equals("ClutchBrake")) {
        this.ClutchBrake = Float.parseFloat(split[1]);
      } else if (split[0].equals("MaxThrottleInWater")) {
        this.maxThrottleInWater = Float.parseFloat(split[1]) * 0.8F;
      } else if (split[0].equals("MaxDepth")) {
        this.maxDepth = Integer.parseInt(split[1]);
      } else if (split[0].equals("oxygen")) {
        this.oxygen = Integer.parseInt(split[1]);
      } else if (split[0].equals("maxOxygen")) {
        this.maxOxygen = Integer.parseInt(split[1]);
      } else if (split[0].equals("exitTimer")) {
        this.exitTimer = Integer.parseInt(split[1]);
      } 
      if (split[0].equals("primaryRecoil")) {
        this.bigRecoil = true;
        this.primaryRecoil = Boolean.parseBoolean(split[1].toLowerCase());
      } 
      if (split[0].equals("secondaryRecoil")) {
        this.bigRecoil = true;
        this.secondaryRecoil = Boolean.parseBoolean(split[1].toLowerCase());
      } 
      if (split[0].equals("Gunsight"))
        this.overlay = split[1]; 
      if (split[0].equals("heliGUI")) {
        this.heliGUI = split[1];
      } else if (split[0].equals("hasScope")) {
        this.hasScope = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("nightScope")) {
        this.nightScope = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("gunsightZoom")) {
        this.gunsightZoom = Float.parseFloat(split[1]);
      } else if (split[0].equals("Drag")) {
        this.drag = Float.parseFloat(split[1]);
      } else if (split[0].equals("TurretOrigin")) {
        this.turretOrigin = new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F);
      } else if (split[0].equals("TurretOriginOffset")) {
        this.turretOriginOffset = new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F);
      } else if (split[0].equals("CollisionPoint") || split[0].equals("AddCollisionPoint")) {
        this.collisionPoints.add(new DriveablePosition(split));
      } else if (split[0].equals("CollisionDamageEnable")) {
        this.collisionDamageEnable = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("unlimitedOxygen")) {
        this.unlimitedOxygen = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("damageVsCrew")) {
        this.damageVsCrew = Float.parseFloat(split[1]);
      } else if (split[0].equals("crewEngine")) {
        this.crewEngine = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("autisticHitDetection")) {
        this.autisticHitDetection = Boolean.parseBoolean(split[1]);
      } 
      if (split[0].equals("weightLimit"))
        this.weightLimit = Integer.parseInt(split[1]); 
      if (split[0].equals("hasAfterBurner"))
        this.hasAfterBurner = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("afterBurnName")) {
        this.afterBurnName = split[1];
      } else if (split[0].equals("CollisionDamageThrottle")) {
        this.collisionDamageThrottle = Float.parseFloat(split[1]);
      } else if (split[0].equals("CollisionDamageTimes")) {
        this.collisionDamageTimes = Float.parseFloat(split[1]);
      } else if (split[0].equals("CanLockAngle")) {
        this.canLockOnAngle = Integer.parseInt(split[1]);
      } else if (split[0].equals("LockOnSoundTime")) {
        this.lockOnSoundTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("LockOnToDriveables")) {
        this.lockOnToPlanes = this.lockOnToVehicles = this.lockOnToMechas = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("LockOnToVehicles")) {
        this.lockOnToVehicles = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("LockOnToPlanes")) {
        this.lockOnToPlanes = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("LockOnToMechas")) {
        this.lockOnToMechas = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("LockOnToPlayers")) {
        this.lockOnToPlayers = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("LockOnToLivings")) {
        this.lockOnToLivings = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("LockedOnSoundRange")) {
        this.lockedOnSoundRange = Integer.parseInt(split[1]);
      } else if (split[0].equals("CanRoll")) {
        this.canRoll = Boolean.parseBoolean(split[1]);
      } 
      if (split[0].equals("HasFlare"))
        this.hasFlare = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("FlareDelay")) {
        this.flareDelay = Integer.parseInt(split[1]);
        if (this.flareDelay <= 0)
          this.flareDelay = 1; 
      } 
      if (split[0].equals("TimeFlareUsing")) {
        this.timeFlareUsing = Integer.parseInt(split[1]);
        if (this.timeFlareUsing <= 0)
          this.timeFlareUsing = 1; 
      } 
      if (split[0].equals("APSdelayMax")) {
        this.APSdelayMax = Integer.parseInt(split[1]);
        if (this.APSdelayMax <= 0)
          this.APSdelayMax = 1; 
      } else if (split[0].equals("hasAPS")) {
        this.hasAPS = Boolean.parseBoolean(split[1]);
      } 
      if (split[0].equals("nuclearDeath"))
        this.nuclearDeath = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("bigDeath"))
        this.bigDeath = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("Death"))
        this.Death = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("radarVisible"))
        this.radarVisible = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("hasRadar"))
        this.hasRadar = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("hasPlaneRadar"))
        this.hasPlaneRadar = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("radarRange"))
        this.radarRange = Float.parseFloat(split[1]); 
      if (split[0].equals("radarPositionOffset"))
        this.radarPositionOffset = Integer.parseInt(split[1]); 
      if (split[0].equals("radarRefreshDelay"))
        this.radarRefreshDelay = Integer.parseInt(split[1]); 
      if (split[0].equals("digitalRadar"))
        this.digitalRadar = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("radarDetectionRangeMultiplier"))
        this.radarDetectionRangeMultiplier = Float.parseFloat(split[1]); 
      if (split[0].equals("solid"))
        this.solid = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("slbmFlightType"))
        this.slbmFlightType = Integer.parseInt(split[1]); 
      if (split[0].equals("slbmDelay"))
        this.slbmDelay = Integer.parseInt(split[1]); 
      if (split[0].equals("slbmRange"))
        this.slbmRange = Integer.parseInt(split[1]); 
      if (split[0].equals("slbmStrength"))
        this.slbmStrength = Integer.parseInt(split[1]); 
      if (split[0].equals("slbmWarheadType")) {
        this.slbmWarheadType = Integer.parseInt(split[1]);
      } else if (split[0].equals("showReload")) {
        this.showReload = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("transport")) {
        this.transport = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("PlaceableOnLand")) {
        this.placeableOnLand = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("PlaceableOnWater")) {
        this.placeableOnWater = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("PlaceableOnSponge")) {
        this.placeableOnSponge = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("placeableOnPumpkin")) {
        this.placeableOnPumpkin = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("FloatOnWater")) {
        this.floatOnWater = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("Boat")) {
        this.placeableOnLand = false;
        this.placeableOnWater = true;
        this.floatOnWater = true;
        this.wheelStepHeight = 0.0F;
      } else if (split[0].equals("Buoyancy")) {
        this.buoyancy = Float.parseFloat(split[1]);
      } else if (split[0].equals("FloatOffset")) {
        this.floatOffset = Float.parseFloat(split[1]);
      } else if (split[0].equals("CanMountEntity")) {
        this.canMountEntity = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("InshaAllah")) {
        this.inshallah = Boolean.parseBoolean(split[1]);
      } 
      if (split[0].equals("needsThrottle"))
        this.needsThrottle = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("Gunsight")) {
        this.Gunsight = split[1];
      } else if (split[0].equals("Wheel") || split[0].equals("WheelPosition")) {
        this.wheelPositions[Integer.parseInt(split[1])] = new DriveablePosition(new Vector3f(Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F, Float.parseFloat(split[4]) / 16.0F), (split.length > 5) ? EnumDriveablePart.getPart(split[5]) : EnumDriveablePart.coreWheel);
      } else if (split[0].equals("WheelRadius") || split[0].equals("WheelStepHeight")) {
        this.wheelStepHeight = Float.parseFloat(split[1]);
      } else if (split[0].equals("WheelSpringStrength") || split[0].equals("SpringStrength")) {
        this.wheelSpringStrength = Float.parseFloat(split[1]);
      } else if (split[0].equals("TrackFrames")) {
        this.animFrames = Integer.parseInt(split[1]) - 1;
      } else if (split[0].equals("Harvester")) {
        this.harvestBlocks = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("CollectHarvest")) {
        this.collectHarvest = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("DropHarvest")) {
        this.dropHarvest = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("HarvestBox")) {
        this.harvestBoxSize = new Vector3f(split[1], this.shortName);
        this.harvestBoxPos = new Vector3f(split[2], this.shortName);
      } else if (split[0].equals("HarvestMaterial")) {
        this.materialsHarvested.add(getMaterial(split[1]));
      } else if (split[0].equals("HarvestToolType")) {
        if (split[1].equals("Axe")) {
          this.materialsHarvested.add(Material.field_151575_d);
          this.materialsHarvested.add(Material.field_151585_k);
          this.materialsHarvested.add(Material.field_151582_l);
        } else if (split[1].equals("Pickaxe") || split[1].equals("Drill")) {
          this.materialsHarvested.add(Material.field_151573_f);
          this.materialsHarvested.add(Material.field_151574_g);
          this.materialsHarvested.add(Material.field_151576_e);
        } else if (split[1].equals("Spade") || split[1].equals("Shovel") || split[1].equals("Excavator")) {
          this.materialsHarvested.add(Material.field_151578_c);
          this.materialsHarvested.add(Material.field_151577_b);
          this.materialsHarvested.add(Material.field_151595_p);
          this.materialsHarvested.add(Material.field_151597_y);
          this.materialsHarvested.add(Material.field_151571_B);
        } else if (split[1].equals("Hoe") || split[1].equals("Combine")) {
          this.materialsHarvested.add(Material.field_151585_k);
          this.materialsHarvested.add(Material.field_151584_j);
          this.materialsHarvested.add(Material.field_151582_l);
          this.materialsHarvested.add(Material.field_151570_A);
          this.materialsHarvested.add(Material.field_151572_C);
        } else if (split[1].equals("Tank")) {
          this.materialsHarvested.add(Material.field_151584_j);
          this.materialsHarvested.add(Material.field_151570_A);
          this.materialsHarvested.add(Material.field_151575_d);
          this.materialsHarvested.add(Material.field_151585_k);
        } 
      } else if (split[0].equals("CargoSlots")) {
        this.numCargoSlots = Integer.parseInt(split[1]);
      } else if (split[0].equals("BombSlots") || split[0].equals("MineSlots")) {
        this.numBombSlots = Integer.parseInt(split[1]);
      } else if (split[0].equals("MissileSlots") || split[0].equals("ShellSlots")) {
        this.numMissileSlots = Integer.parseInt(split[1]);
      } else if (split[0].equals("FuelTankSize")) {
        this.fuelTankSize = Integer.parseInt(split[1]);
      } else if (split[0].equals("BulletDetection")) {
        this.bulletDetectionRadius = Integer.parseInt(split[1]);
      } else if (split[0].equals("AddAmmo")) {
        this.ammo.add(BulletType.getBullet(split[1]));
      } else if (split[0].equals("AllowAllAmmo") || split[0].equals("AcceptAllAmmo")) {
        this.acceptAllAmmo = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("Primary")) {
        this.primary = EnumWeaponType.valueOf(split[1].toUpperCase());
      } else if (split[0].equals("Secondary")) {
        this.secondary = EnumWeaponType.valueOf(split[1].toUpperCase());
      } else if (split[0].equals("ShootDelayPrimary")) {
        this.shootDelayPrimary = Integer.parseInt(split[1]);
      } else if (split[0].equals("ShootDelaySecondary")) {
        this.shootDelaySecondary = Integer.parseInt(split[1]);
      } else if (split[0].equals("PlaceTimePrimary")) {
        this.placeTimePrimary = Integer.parseInt(split[1]);
      } else if (split[0].equals("PlaceTimeSecondary")) {
        this.placeTimeSecondary = Integer.parseInt(split[1]);
      } else if (split[0].equals("ReloadTimePrimary")) {
        this.reloadTimePrimary = Integer.parseInt(split[1]);
      } else if (split[0].equals("ReloadTimeSecondary")) {
        this.reloadTimeSecondary = Integer.parseInt(split[1]);
      } else if (split[0].equals("AlternatePrimary")) {
        this.alternatePrimary = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("AlternateSecondary")) {
        this.alternateSecondary = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("ModePrimary")) {
        this.modePrimary = EnumFireMode.valueOf(split[1].toUpperCase());
      } else if (split[0].equals("ModeSecondary")) {
        this.modeSecondary = EnumFireMode.valueOf(split[1].toUpperCase());
      } else if (split[0].equals("BulletSpeed")) {
        this.bulletSpeed = Float.parseFloat(split[1]);
      } else if (split[0].equals("BulletSpread")) {
        this.bulletSpread = Float.parseFloat(split[1]);
      } else if (split[0].equals("RangingGun")) {
        this.rangingGun = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("GunLength")) {
        this.gunLength = Float.parseFloat(split[1]);
      } else if (split[0].equals("RecoilDistance")) {
        this.recoilDist = Float.parseFloat(split[1]);
      } else if (split[0].equals("RecoilTime")) {
        this.recoilTime = Float.parseFloat(split[1]);
      } else if (split[0].equals("ShootPointPrimary")) {
        Vector3f offPos;
        String[] gun;
        if (split.length == 9) {
          gun = new String[] { split[0], split[1], split[2], split[3], split[4], split[5] };
          offPos = new Vector3f(Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F, Float.parseFloat(split[8]) / 16.0F);
        } else if (split.length == 8) {
          gun = new String[] { split[0], split[1], split[2], split[3], split[4] };
          offPos = new Vector3f(Float.parseFloat(split[5]) / 16.0F, Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F);
        } else {
          gun = split;
          offPos = new Vector3f(0.0F, 0.0F, 0.0F);
        } 
        DriveablePosition rootPos = getShootPoint(gun);
        ShootPoint sPoint = new ShootPoint(rootPos, offPos);
        this.shootPointsPrimary.add(sPoint);
        if (rootPos instanceof PilotGun)
          this.pilotGuns.add((PilotGun)sPoint.rootPos); 
      } else if (split[0].equals("ShootPointSecondary")) {
        Vector3f offPos;
        String[] gun;
        if (split.length == 9) {
          gun = new String[] { split[0], split[1], split[2], split[3], split[4], split[5] };
          offPos = new Vector3f(Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F, Float.parseFloat(split[8]) / 16.0F);
        } else if (split.length == 8) {
          gun = new String[] { split[0], split[1], split[2], split[3], split[4] };
          offPos = new Vector3f(Float.parseFloat(split[5]) / 16.0F, Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F);
        } else {
          gun = split;
          offPos = new Vector3f(0.0F, 0.0F, 0.0F);
        } 
        DriveablePosition rootPos = getShootPoint(gun);
        ShootPoint sPoint = new ShootPoint(rootPos, offPos);
        this.shootPointsSecondary.add(sPoint);
        if (rootPos instanceof PilotGun)
          this.pilotGuns.add((PilotGun)sPoint.rootPos); 
      } else if (split[0].equals("EnableReloadTime")) {
        this.enableReloadTime = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("ShootParticlesPrimary")) {
        this.shootParticlesPrimary.add(new ShootParticle(split[1], 
              
              Float.valueOf(split[2]).floatValue(), 
              Float.valueOf(split[3]).floatValue(), 
              Float.valueOf(split[4]).floatValue()));
      } else if (split[0].equals("ShootParticlesSecondary")) {
        this.shootParticlesSecondary.add(new ShootParticle(split[1], Float.valueOf(split[2]).floatValue(), 
              Float.valueOf(split[3]).floatValue(), 
              Float.valueOf(split[4]).floatValue()));
      } 
      if (split[0].equals("SetPlayerInvisible"))
        this.setPlayerInvisible = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("IT1"))
        this.IT1 = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("FixedPrimary"))
        this.fixedPrimaryFire = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("PrimaryAngle"))
        this.primaryFireAngle = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3])); 
      if (split[0].equals("FixedSecondary"))
        this.fixedSecondaryFire = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("SecondaryAngle")) {
        this.secondaryFireAngle = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
      } else if (split[0].equals("AddGun")) {
        DriveablePosition rootPos;
        Vector3f offPos;
        PilotGun pilotGun;
        this.secondary = EnumWeaponType.GUN;
        if (split.length == 6) {
          rootPos = getShootPoint(split);
          offPos = new Vector3f(0.0F, 0.0F, 0.0F);
          pilotGun = (PilotGun)getShootPoint(split);
        } else {
          String[] gun = { split[0], split[1], split[2], split[3], split[4], split[5] };
          rootPos = getShootPoint(gun);
          pilotGun = (PilotGun)getShootPoint(gun);
          offPos = new Vector3f(Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F, Float.parseFloat(split[8]) / 16.0F);
        } 
        ShootPoint sPoint = new ShootPoint(rootPos, offPos);
        this.shootPointsSecondary.add(sPoint);
        this.pilotGuns.add(pilotGun);
        this.driveableRecipe.add(new ItemStack(pilotGun.type.item));
      } else if (split[0].equals("BombPosition")) {
        this.primary = EnumWeaponType.BOMB;
        if (split.length == 4) {
          this.shootPointsPrimary.add(new ShootPoint(new DriveablePosition(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F), EnumDriveablePart.core), new Vector3f(0.0F, 0.0F, 0.0F)));
        } else if (split.length == 7) {
          this.shootPointsPrimary.add(new ShootPoint(new DriveablePosition(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F), EnumDriveablePart.core), new Vector3f(Float.parseFloat(split[4]) / 16.0F, Float.parseFloat(split[5]) / 16.0F, Float.parseFloat(split[6]) / 16.0F)));
        } 
      } else if (split[0].equals("BarrelPosition")) {
        this.primary = EnumWeaponType.SHELL;
        if (split.length == 4) {
          this.shootPointsPrimary.add(new ShootPoint(new DriveablePosition(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F), EnumDriveablePart.turret), new Vector3f(0.0F, 0.0F, 0.0F)));
        } else if (split.length == 7) {
          this.shootPointsPrimary.add(new ShootPoint(new DriveablePosition(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F), EnumDriveablePart.turret), new Vector3f(Float.parseFloat(split[4]) / 16.0F, Float.parseFloat(split[5]) / 16.0F, Float.parseFloat(split[6]) / 16.0F)));
        } 
      } else if (split[0].equals("ShootDelay")) {
        this.shootDelaySecondary = Integer.parseInt(split[1]);
      } else if (split[0].equals("ShellDelay") || split[0].equals("BombDelay")) {
        this.shootDelayPrimary = Integer.parseInt(split[1]);
      } else if (split[0].equals("AddRecipeParts")) {
        EnumDriveablePart part = EnumDriveablePart.getPart(split[1]);
        ItemStack[] stacks = new ItemStack[(split.length - 2) / 2];
        for (int i = 0; i < (split.length - 2) / 2; i++) {
          int amount = Integer.parseInt(split[2 * i + 2]);
          boolean damaged = split[2 * i + 3].contains(".");
          String itemName = damaged ? split[2 * i + 3].split("\\.")[0] : split[2 * i + 3];
          int damage = damaged ? Integer.parseInt(split[2 * i + 3].split("\\.")[1]) : 0;
          stacks[i] = getRecipeElement(itemName, amount, damage, this.shortName);
          this.driveableRecipe.add(stacks[i]);
        } 
        this.partwiseRecipe.put(part, stacks);
      } else if (split[0].equals("AddDye")) {
        int amount = Integer.parseInt(split[1]);
        int damage = -1;
        for (int i = 0; i < ItemDye.field_150923_a.length; i++) {
          if (ItemDye.field_150923_a[i].equals(split[2]))
            damage = i; 
        } 
        if (damage == -1) {
          FlansMod.log("Failed to find dye colour : " + split[2] + " while adding " + file.name);
          return;
        } 
        this.driveableRecipe.add(new ItemStack(Items.field_151100_aR, amount, damage));
      } else if (split[0].equals("SetupPart")) {
        EnumDriveablePart part = EnumDriveablePart.getPart(split[1]);
        CollisionBox box = new CollisionBox(Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), 1, 1, 1, 1);
        this.health.put(part, box);
        this.crew.put(part, box);
      } else if (split[0].equals("SetupArmoredPart")) {
        EnumDriveablePart part = EnumDriveablePart.getPart(split[1]);
        CollisionBox box = new CollisionBox(Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), Integer.parseInt(split[9]), Integer.parseInt(split[9]), 1, 1);
        this.health.put(part, box);
        this.crew.put(part, box);
      } else if (split[0].equals("SetupCrewedPart")) {
        EnumDriveablePart part = EnumDriveablePart.getPart(split[1]);
        CollisionBox box = new CollisionBox(Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), Integer.parseInt(split[9]), Integer.parseInt(split[9]), 1, Integer.parseInt(split[10]));
        this.health.put(part, box);
        this.crew.put(part, box);
      } else if (split[0].equals("SetupCompositeArmoredPart")) {
        EnumDriveablePart part = EnumDriveablePart.getPart(split[1]);
        CollisionBox box = new CollisionBox(Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), Integer.parseInt(split[9]), Integer.parseInt(split[10]), 1, 1);
        this.health.put(part, box);
        this.crew.put(part, box);
      } else if (split[0].equals("SetupAnimalPart")) {
        EnumDriveablePart part = EnumDriveablePart.getPart(split[1]);
        CollisionBox box = new CollisionBox(Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), Integer.parseInt(split[5]), Integer.parseInt(split[6]), Integer.parseInt(split[7]), Integer.parseInt(split[8]), Integer.parseInt(split[9]), Integer.parseInt(split[10]), 2, 1);
        this.health.put(part, box);
        this.crew.put(part, box);
      } else if (split[0].equals("Driver") || split[0].equals("Pilot")) {
        if (split.length > 4) {
          this.seats[0] = new Seat(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6]), Float.parseFloat(split[7]));
        } else {
          this.seats[0] = new Seat(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]));
        } 
      } else if (split[0].equals("DriverPart")) {
        (this.seats[0]).part = EnumDriveablePart.getPart(split[1]);
      } else if (split[0].equals("DriverGun") || split[0].equals("PilotGun")) {
        (this.seats[0]).gunName = split[2];
      } else if (split[0].equals("DriverGunOrigin")) {
        (this.seats[0]).gunOrigin = new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F);
      } else if (split[0].equals("RotatedDriverOffset")) {
        (this.seats[0]).rotatedOffset = new Vector3f(Integer.parseInt(split[1]) / 16.0F, Integer.parseInt(split[2]) / 16.0F, Integer.parseInt(split[3]) / 16.0F);
      } else if (split[0].equals("RotatedPassengerOffset")) {
        (this.seats[Integer.parseInt(split[1])]).rotatedOffset = new Vector3f(Integer.parseInt(split[2]) / 16.0F, Integer.parseInt(split[3]) / 16.0F, Integer.parseInt(split[4]) / 16.0F);
      } else if (split[0].equals("DriverAimSpeed")) {
        (this.seats[0]).aimingSpeed = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
        (this.seats[0]).aimingSpeedBackup = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
      } else if (split[0].equals("PassengerAimSpeed")) {
        (this.seats[Integer.parseInt(split[1])]).aimingSpeed = new Vector3f(Float.parseFloat(split[2]), Float.parseFloat(split[3]), Float.parseFloat(split[4]));
      } else if (split[0].equals("carrier")) {
        (this.seats[Integer.parseInt(split[1])]).carrier = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("parkingSpot")) {
        (this.seats[Integer.parseInt(split[1])]).parkingSpot = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("helipad")) {
        (this.seats[Integer.parseInt(split[1])]).helipad = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("invisiblePassenger")) {
        (this.seats[Integer.parseInt(split[1])]).invisiblePassenger = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("heliGuiSeat")) {
        (this.seats[Integer.parseInt(split[1])]).heliGuiSeat = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("passengerZoom")) {
        (this.seats[Integer.parseInt(split[1])]).passengerZoom = Float.parseFloat(split[2]);
      } else if (split[0].equals("canSmallArms")) {
        (this.seats[Integer.parseInt(split[1])]).canSmallArms = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("invincible")) {
        (this.seats[Integer.parseInt(split[1])]).invincible = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("enterable")) {
        (this.seats[Integer.parseInt(split[1])]).enterable = Boolean.parseBoolean(split[2]);
      } 
      if (split[0].equals("SetDriverInvincible")) {
        this.invinciblePilotType = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("barrels")) {
        (this.seats[Integer.parseInt(split[1])]).barrels = Integer.parseInt(split[2]);
      } else if (split[0].equals("barrelSpread")) {
        (this.seats[Integer.parseInt(split[1])]).barrelSpread = Float.parseFloat(split[2]);
      } else if (split[0].equals("hasHUD")) {
        (this.seats[Integer.parseInt(split[1])]).hasHUD = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("hudColorR")) {
        (this.seats[Integer.parseInt(split[1])]).hudColorR = Integer.parseInt(split[2]);
      } else if (split[0].equals("hudColorG")) {
        (this.seats[Integer.parseInt(split[1])]).hudColorG = Integer.parseInt(split[2]);
      } else if (split[0].equals("hudColorB")) {
        (this.seats[Integer.parseInt(split[1])]).hudColorB = Integer.parseInt(split[2]);
      } 
      if (split[0].equals("autoSmoke")) {
        this.autoSmoke = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("energyGainRate")) {
        this.energyRate = Float.parseFloat(split[1]);
      } else if (split[0].equals("energyLossRate")) {
        this.energyLossRate = Float.parseFloat(split[1]);
      } else if (split[0].equals("DriverLegacyAiming")) {
        (this.seats[0]).legacyAiming = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("PassengerLegacyAiming")) {
        (this.seats[Integer.parseInt(split[1])]).legacyAiming = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("DriverYawBeforePitch")) {
        (this.seats[0]).yawBeforePitch = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("PassengerYawBeforePitch")) {
        (this.seats[Integer.parseInt(split[1])]).yawBeforePitch = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("DriverLatePitch")) {
        (this.seats[0]).latePitch = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("PassengerLatePitch")) {
        (this.seats[Integer.parseInt(split[1])]).latePitch = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("DriverTraverseSounds")) {
        (this.seats[0]).traverseSounds = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("PassengerTraverseSounds")) {
        (this.seats[Integer.parseInt(split[1])]).traverseSounds = Boolean.parseBoolean(split[2]);
      } else if (split[0].equals("Passenger")) {
        Seat seat = new Seat(split);
        this.seats[seat.id] = seat;
        if (seat.gunType != null) {
          seat.gunnerID = this.numPassengerGunners++;
          this.driveableRecipe.add(new ItemStack(seat.gunType.item));
        } 
      } else if (split[0].equals("GunOrigin")) {
        (this.seats[Integer.parseInt(split[1])]).gunOrigin = new Vector3f(Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F, Float.parseFloat(split[4]) / 16.0F);
      } else if (split[0].equals("YOffset")) {
        this.yOffset = Float.parseFloat(split[1]);
      } else if (split[0].equals("CameraDistance")) {
        this.cameraDistance = Float.parseFloat(split[1]);
      } else if (split[0].equals("StartSoundRange")) {
        this.startSoundRange = Integer.parseInt(split[1]);
      } else if (split[0].equals("StartSoundLength")) {
        this.startSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("EngineSoundRange")) {
        this.engineSoundRange = Integer.parseInt(split[1]);
      } else if (split[0].equals("EngineSoundLength")) {
        this.engineSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("IdleSoundLength")) {
        this.idleSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("BackSoundRange")) {
        this.backSoundRange = Integer.parseInt(split[1]);
      } else if (split[0].equals("BackSoundLength")) {
        this.backSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("SoundTime")) {
        this.soundTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("YawSoundLength")) {
        (this.seats[0]).yawSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("PitchSoundLength")) {
        (this.seats[0]).pitchSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("PassengerYawSoundLength")) {
        (this.seats[Integer.parseInt(split[1])]).yawSoundLength = Integer.parseInt(split[2]);
      } else if (split[0].equals("PassengerPitchSoundLength")) {
        (this.seats[Integer.parseInt(split[1])]).pitchSoundLength = Integer.parseInt(split[2]);
      } else if (split[0].equals("StartSound")) {
        this.startSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("sonicBoomSound")) {
        this.sonicBoomSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("EngineSound")) {
        this.engineSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("overheatSound")) {
        this.overheatSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "overheatSound", split[1]);
      } else if (split[0].equals("Stabilizer")) {
        this.Stabilizer = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("IdleSound")) {
        this.idleSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("BackSound")) {
        this.backSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("YawSound")) {
        (this.seats[0]).yawSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("PitchSound")) {
        (this.seats[0]).pitchSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("PassengerYawSound")) {
        (this.seats[Integer.parseInt(split[1])]).yawSound = split[2];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("PassengerPitchSound")) {
        (this.seats[Integer.parseInt(split[1])]).pitchSound = split[2];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("ShootMainSound") || split[0].equals("ShootSoundPrimary") || split[0].equals("ShellSound") || split[0].equals("BombSound")) {
        this.shootSoundPrimary = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("ShootReloadSound")) {
        this.shootReloadSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("farSound")) {
        this.farSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("ShootSecondarySound") || split[0].equals("ShootSoundSecondary")) {
        this.shootSoundSecondary = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("PlaceSoundPrimary")) {
        this.placeSoundPrimary = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("PlaceSoundSecondary")) {
        this.placeSoundSecondary = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("ReloadSoundPrimary")) {
        this.reloadSoundPrimary = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("ReloadSoundSecondary")) {
        this.reloadSoundSecondary = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("LockedOnSound")) {
        this.lockedOnSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("LockOnSound")) {
        this.lockOnSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("FilterAmmunitionInput")) {
        this.filterAmmunition = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("LockingOnSound")) {
        this.lockingOnSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } 
      if (split[0].equals("FlareSound")) {
        this.flareSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } 
      if (split[0].equals("FancyCollision"))
        this.fancyCollision = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("fancyShip"))
        this.fancyShip = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("AddCollisionMesh")) {
        CollisionShapeBox box = new CollisionShapeBox(new Vector3f(split[1], this.shortName), new Vector3f(split[2], this.shortName), new Vector3f(split[3], this.shortName), new Vector3f(split[4], this.shortName), new Vector3f(split[5], this.shortName), new Vector3f(split[6], this.shortName), new Vector3f(split[7], this.shortName), new Vector3f(split[8], this.shortName), new Vector3f(split[9], this.shortName), new Vector3f(split[10], this.shortName), "core");
        this.collisionBox.add(box);
      } 
      if (split[0].equals("AddCollisionMeshRaw")) {
        Vector3f pos = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
        Vector3f size = new Vector3f(Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6]));
        Vector3f p1 = new Vector3f(Float.parseFloat(split[8]), Float.parseFloat(split[9]), Float.parseFloat(split[10]));
        Vector3f p2 = new Vector3f(Float.parseFloat(split[11]), Float.parseFloat(split[12]), Float.parseFloat(split[13]));
        Vector3f p3 = new Vector3f(Float.parseFloat(split[14]), Float.parseFloat(split[15]), Float.parseFloat(split[16]));
        Vector3f p4 = new Vector3f(Float.parseFloat(split[17]), Float.parseFloat(split[18]), Float.parseFloat(split[19]));
        Vector3f p5 = new Vector3f(Float.parseFloat(split[20]), Float.parseFloat(split[21]), Float.parseFloat(split[22]));
        Vector3f p6 = new Vector3f(Float.parseFloat(split[23]), Float.parseFloat(split[24]), Float.parseFloat(split[25]));
        Vector3f p7 = new Vector3f(Float.parseFloat(split[26]), Float.parseFloat(split[27]), Float.parseFloat(split[28]));
        Vector3f p8 = new Vector3f(Float.parseFloat(split[29]), Float.parseFloat(split[30]), Float.parseFloat(split[31]));
        CollisionShapeBox box = new CollisionShapeBox(pos, size, p1, p2, p3, p4, p5, p6, p7, p8, "core");
        this.collisionBox.add(box);
      } 
      if (split[0].equals("AddTurretCollisionMesh")) {
        CollisionShapeBox box = new CollisionShapeBox(new Vector3f(split[1], this.shortName), new Vector3f(split[2], this.shortName), new Vector3f(split[3], this.shortName), new Vector3f(split[4], this.shortName), new Vector3f(split[5], this.shortName), new Vector3f(split[6], this.shortName), new Vector3f(split[7], this.shortName), new Vector3f(split[8], this.shortName), new Vector3f(split[9], this.shortName), new Vector3f(split[10], this.shortName), "turret");
        this.collisionBox.add(box);
      } 
      if (split[0].equals("AddTurretCollisionMeshRaw")) {
        Vector3f pos = new Vector3f(Float.parseFloat(split[1]), Float.parseFloat(split[2]), Float.parseFloat(split[3]));
        Vector3f size = new Vector3f(Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6]));
        Vector3f p1 = new Vector3f(Float.parseFloat(split[8]), Float.parseFloat(split[9]), Float.parseFloat(split[10]));
        Vector3f p2 = new Vector3f(Float.parseFloat(split[11]), Float.parseFloat(split[12]), Float.parseFloat(split[13]));
        Vector3f p3 = new Vector3f(Float.parseFloat(split[14]), Float.parseFloat(split[15]), Float.parseFloat(split[16]));
        Vector3f p4 = new Vector3f(Float.parseFloat(split[17]), Float.parseFloat(split[18]), Float.parseFloat(split[19]));
        Vector3f p5 = new Vector3f(Float.parseFloat(split[20]), Float.parseFloat(split[21]), Float.parseFloat(split[22]));
        Vector3f p6 = new Vector3f(Float.parseFloat(split[23]), Float.parseFloat(split[24]), Float.parseFloat(split[25]));
        Vector3f p7 = new Vector3f(Float.parseFloat(split[26]), Float.parseFloat(split[27]), Float.parseFloat(split[28]));
        Vector3f p8 = new Vector3f(Float.parseFloat(split[29]), Float.parseFloat(split[30]), Float.parseFloat(split[31]));
        CollisionShapeBox box = new CollisionShapeBox(pos, size, p1, p2, p3, p4, p5, p6, p7, p8, "turret");
        this.collisionBox.add(box);
      } 
      if (split[0].equals("LeftLinkPoint"))
        this.leftTrackPoints.add(new Vector3f(split[1], this.shortName)); 
      if (split[0].equals("RightLinkPoint"))
        this.rightTrackPoints.add(new Vector3f(split[1], this.shortName)); 
      if (split[0].equals("TrackLinkLength")) {
        this.trackLinkLength = Float.parseFloat(split[1]);
      } else if (split[0].equals("OnRadar")) {
        this.onRadar = split[1].equals("True");
      } else if (split[0].equalsIgnoreCase("AddParticle") || split[0].equalsIgnoreCase("AddEmitter")) {
        ParticleEmitter emitter = new ParticleEmitter();
        emitter.effectType = split[1];
        emitter.emitRate = Integer.parseInt(split[2]);
        emitter.origin = new Vector3f(split[3], this.shortName);
        emitter.extents = new Vector3f(split[4], this.shortName);
        emitter.velocity = new Vector3f(split[5], this.shortName);
        emitter.minThrottle = Float.parseFloat(split[6]);
        emitter.maxThrottle = Float.parseFloat(split[7]);
        emitter.minHealth = Float.parseFloat(split[8]);
        emitter.maxHealth = Float.parseFloat(split[9]);
        emitter.part = split[10];
        emitter.origin.scale(0.0625F);
        emitter.extents.scale(0.0625F);
        emitter.velocity.scale(0.0625F);
        this.emitters.add(emitter);
      } else if (split[0].equalsIgnoreCase("particleAfterBurn") || split[0].equalsIgnoreCase("particleTrailBurner")) {
        AfterBurnEmitter emitter = new AfterBurnEmitter();
        emitter.effectType = split[1];
        emitter.emitRate = Integer.parseInt(split[2]);
        emitter.origin = new Vector3f(split[3], this.shortName);
        emitter.extents = new Vector3f(split[4], this.shortName);
        emitter.velocity = new Vector3f(split[5], this.shortName);
        emitter.part = split[6];
        emitter.origin.scale(0.0625F);
        emitter.extents.scale(0.0625F);
        emitter.velocity.scale(0.0625F);
        this.afterBurns.add(emitter);
      } else if (split[0].equals("RadarDetectableAltitude")) {
        this.radarDetectableAltitude = Integer.parseInt(split[1]);
      } else if (split[0].equals("Stealth")) {
        this.stealth = split[1].equals("True");
      } 
    } catch (Exception e) {
      if (split != null) {
        String msg = " : ";
        for (String s : split)
          msg = msg + " " + s; 
        FlansMod.log("Errored reading " + file.name + "");
      } else {
        FlansMod.log("Errored reading " + file.name);
      } 
      if (FlansMod.printStackTrace)
        e.printStackTrace(); 
    } 
  }
  
  private DriveablePosition getShootPoint(String[] split) {
    if (split.length == 6)
      return new PilotGun(split); 
    if (split.length == 5)
      return new DriveablePosition(split); 
    return new DriveablePosition(new Vector3f(), EnumDriveablePart.core);
  }
  
  public ArrayList<ShootPoint> shootPoints(boolean s) {
    return s ? this.shootPointsSecondary : this.shootPointsPrimary;
  }
  
  public boolean alternate(boolean s) {
    return s ? this.alternateSecondary : this.alternatePrimary;
  }
  
  public EnumWeaponType weaponType(boolean s) {
    return s ? this.secondary : this.primary;
  }
  
  public int shootDelay(boolean s) {
    return s ? this.shootDelaySecondary : this.shootDelayPrimary;
  }
  
  public String shootSound(boolean s) {
    return s ? this.shootSoundSecondary : this.shootSoundPrimary;
  }
  
  public ArrayList<ShootParticle> shootParticle(boolean s) {
    return s ? this.shootParticlesSecondary : this.shootParticlesPrimary;
  }
  
  public int numEngines() {
    return 1;
  }
  
  public int ammoSlots() {
    return this.numPassengerGunners + this.pilotGuns.size();
  }
  
  public boolean isValidAmmo(BulletType bulletType, EnumWeaponType weaponType) {
    return ((this.acceptAllAmmo || this.ammo.contains(bulletType)) && bulletType.weaponType == weaponType);
  }
  
  public ArrayList<ItemStack> getItemsRequired(DriveablePart part, PartType engine) {
    ArrayList<ItemStack> stacks = new ArrayList<>();
    if (this.partwiseRecipe.get(part.type) != null)
      for (ItemStack stack : (ItemStack[])this.partwiseRecipe.get(part.type))
        stacks.add(stack.func_77946_l());  
    for (PilotGun gun : this.pilotGuns) {
      if (gun.part == part.type)
        stacks.add(new ItemStack(gun.type.item)); 
    } 
    for (Seat seat : this.seats) {
      if (seat != null && seat.part == part.type && seat.gunType != null)
        stacks.add(new ItemStack(seat.gunType.item)); 
    } 
    return stacks;
  }
  
  public static DriveableType getDriveable(String find) {
    for (DriveableType type : types) {
      if (type.shortName.equals(find))
        return type; 
    } 
    return null;
  }
  
  public float GetRecommendedScale() {
    return 100.0F / this.cameraDistance;
  }
  
  public class ParticleEmitter {
    public String effectType;
    
    public int emitRate;
    
    public Vector3f origin;
    
    public Vector3f extents;
    
    public Vector3f velocity;
    
    public float minThrottle;
    
    public float maxThrottle;
    
    public String part;
    
    public float minHealth;
    
    public float maxHealth;
  }
  
  public class AfterBurnEmitter {
    public String effectType;
    
    public int emitRate;
    
    public Vector3f origin;
    
    public Vector3f extents;
    
    public Vector3f velocity;
    
    public String part;
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBase GetModel() {
    return (ModelBase)this.model;
  }
}
