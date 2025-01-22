package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EnumWeaponType;
import com.flansmod.common.types.TypeFile;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.potion.PotionEffect;

public class BulletType extends ShootableType {
  public boolean Parachute = false;
  
  public boolean Bouncerino = false;
  
  public boolean Ghost = false;
  
  public boolean Hesh = false;
  
  public boolean depthCharge = false;
  
  public boolean navalMine = false;
  
  public int activationDepth = 20;
  
  public int seaLevel = 55;
  
  public int flak = 0;
  
  public String flakParticles = "largesmoke";
  
  public boolean setEntitiesOnFire = false;
  
  public float livingProximityTrigger = -1.0F;
  
  public float driveableProximityTrigger = -1.0F;
  
  public float damageToTriggerer = 0.0F;
  
  public int primeDelay = 0;
  
  public int explodeParticles = 0;
  
  public String explodeParticleType = "largesmoke";
  
  public int lockonDelay = 10;
  
  public EnumWeaponType weaponType = EnumWeaponType.NONE;
  
  public String hitSound;
  
  public float hitSoundRange;
  
  public boolean hitSoundEnable = false;
  
  public boolean entityHitSoundEnable = false;
  
  public boolean hasLight = false;
  
  public float penetratingPower = 1.0F;
  
  public int armorPen = 2;
  
  public float penDecay = 0.0F;
  
  public boolean HEAT = false;
  
  public boolean radarGuided = false;
  
  public boolean swordEnergy = false;
  
  public boolean lockOnToPlanes = false;
  
  public boolean lockOnToVehicles = false;
  
  public boolean lockOnToMechas = false;
  
  public boolean lockOnToPlayers = false;
  
  public boolean lockOnToLivings = false;
  
  public float maxLockOnAngle = 45.0F;
  
  public float lockOnForce = 1.0F;
  
  public int maxDegreeOfMissile = 70;
  
  public int tickStartHoming = 5;
  
  public boolean enableSACLOS = false;
  
  public int maxDegreeOfSACLOS = 5;
  
  public int maxRangeOfMissile = 300;
  
  public boolean manualGuidance = false;
  
  public int lockOnFuse = 10;
  
  public boolean TVguided = false;
  
  public String ricochetSound = "bounceMG";
  
  public String minorPenSound = "";
  
  public String penetrateSound = "";
  
  public String overPenSound = "";
  
  public String APSsound = "";
  
  public ArrayList<PotionEffect> hitEffects = new ArrayList<>();
  
  public int numBullets = -1;
  
  public float bulletSpread = -1.0F;
  
  public float dragInAir = 1.0F;
  
  public float dragInWater = 0.8F;
  
  public boolean canSpotEntityDriveable = false;
  
  public int maxRange = -1;
  
  public boolean shootForSettingPos = false;
  
  public int shootForSettingPosHeight = 100;
  
  public boolean isDoTopAttack = false;
  
  public int smokeTime = 0;
  
  public String smokeParticleType = "explode";
  
  public ArrayList<PotionEffect> smokeEffects = new ArrayList<>();
  
  public ArrayList<PotionEffect> stolenSmokeEffects = new ArrayList<>();
  
  public boolean stolenSmoke = false;
  
  public float smokeRadius = 5.0F;
  
  public boolean TVguide = true;
  
  public boolean VLS = false;
  
  public int VLSTime = 0;
  
  public boolean fixedDirection = false;
  
  public float turnRadius = 3.0F;
  
  public String boostPhaseParticle;
  
  public float trackPhaseSpeed = 2.0F;
  
  public float trackPhaseTurn = 0.2F;
  
  public boolean CIWSable = false;
  
  public boolean torpedo = false;
  
  public float seekerRange = 250.0F;
  
  public float nonpenPenalty = 0.0F;
  
  public float barelypenPenalty = 0.01F;
  
  public float overPenPenalty = 0.5F;
  
  public boolean bigWater = false;
  
  public boolean smallWater = true;
  
  public boolean modernTorpedo = false;
  
  public int aftermathFuse = 3;
  
  public boolean angel = false;
  
  public float angelSpeed = 2.5F;
  
  public boolean antiRadiation = false;
  
  public String missNoise = "Passby";
  
  public boolean grenadeBounce = false;
  
  public boolean sticky;
  
  public boolean smokeProtectable = false;
  
  public boolean hasLauncherModel = false;
  
  public boolean CIWSer = false;
  
  public boolean gasmaskable = true;
  
  public boolean angelOfDeath = false;
  
  public int bulletSmokeTime = 5;
  
  public int smokeDelay = 30;
  
  public boolean jamiogravity = false;
  
  public int dynamicBulletDelay = 9000;
  
  public float dynamicDamage = 1.0F;
  
  public int suppression = 16;
  
  public boolean starShell = false;
  
  public boolean ciwsBullet = false;
  
  public float ASWminRange = 5.0F;
  
  public boolean infiniteAngle = false;
  
  public boolean trueManual = false;
  
  public float joystickSensitivity = 1.0F;
  
  public boolean earlyInfrared = false;
  
  public static List<BulletType> bullets = new ArrayList<>();
  
  public BulletType(TypeFile file) {
    super(file);
    this.texture = "defaultBullet";
    bullets.add(this);
  }
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (split[0].equals("FlakParticles")) {
        this.flak = Integer.parseInt(split[1]);
      } else if (split[0].equals("FlakParticleType")) {
        this.flakParticles = split[1];
      } else if (split[0].equals("SetEntitiesOnFire")) {
        this.setEntitiesOnFire = Boolean.parseBoolean(split[1]);
      } 
      if (split[0].equals("suppression")) {
        this.suppression = Integer.parseInt(split[1]);
      } else if (split[0].equals("Parachute")) {
        this.Parachute = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("infiniteAngle")) {
        this.infiniteAngle = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("earlyInfrared")) {
        this.earlyInfrared = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("starShell")) {
        this.starShell = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("ciwsBullet")) {
        this.ciwsBullet = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("joystick")) {
        this.trueManual = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("manualSensitivity")) {
        this.joystickSensitivity = Float.parseFloat(split[1]);
      } else if (split[0].equals("TVguided")) {
        this.TVguided = Boolean.parseBoolean(split[1]);
      } 
      if (split[0].equals("dynamicBulletDelay")) {
        this.dynamicBulletDelay = Integer.parseInt(split[1]);
      } else if (split[0].equals("dynamicDamage")) {
        this.dynamicDamage = Float.parseFloat(split[1]);
      } else if (split[0].equals("hasLauncherModel")) {
        this.hasLauncherModel = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("smokeProtectable")) {
        this.smokeProtectable = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("grenadeBounce")) {
        this.grenadeBounce = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("gasmaskable")) {
        this.gasmaskable = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("stolenSmokeEffect")) {
        this.stolenSmokeEffects.add(getPotionEffect(split));
      } else if (split[0].equals("stolenSmoke")) {
        this.stolenSmoke = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("angelOfDeath")) {
        this.angelOfDeath = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("smokeParticleType")) {
        this.smokeParticleType = split[1];
      } else if (split[0].equals("bulletSmokeTime")) {
        this.bulletSmokeTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("smokeDelay")) {
        this.smokeDelay = Integer.parseInt(split[1]);
      } else if (split[0].equals("shrapnelAngel")) {
        this.angel = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("angelSpeed")) {
        this.barelypenPenalty = Float.parseFloat(split[1]);
      } else if (split[0].equals("nonPenPenalty")) {
        this.nonpenPenalty = Float.parseFloat(split[1]);
      } else if (split[0].equals("overPenPenalty")) {
        this.overPenPenalty = Float.parseFloat(split[1]);
      } else if (split[0].equals("barelyPenPenalty")) {
        this.barelypenPenalty = Float.parseFloat(split[1]);
      } else if (split[0].equals("CIWSable")) {
        this.CIWSable = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("CIWSer")) {
        this.CIWSer = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("armorPen")) {
        this.armorPen = Integer.parseInt(split[1]);
      } else if (split[0].equals("penDecay")) {
        this.penDecay = (float)(Float.parseFloat(split[1]) * 0.5D);
      } else if (split[0].equals("ricochetSound")) {
        this.ricochetSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("minorPenSound")) {
        this.minorPenSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("penetrateSound")) {
        this.penetrateSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("overPenSound")) {
        this.overPenSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("APSsound")) {
        this.APSsound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("missNoise")) {
        this.missNoise = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("HEAT")) {
        this.HEAT = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("radarGuided")) {
        this.radarGuided = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("Bouncy")) {
        this.Bouncerino = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("Hesh")) {
        this.Hesh = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("Ghost")) {
        this.Ghost = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("bigWater")) {
        this.bigWater = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("smallWater")) {
        this.smallWater = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("navalMine")) {
        this.navalMine = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("depthCharge")) {
        this.depthCharge = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("activationDepth")) {
        this.activationDepth = Integer.parseInt(split[1]);
      } else if (split[0].equals("aftermathFuse")) {
        this.aftermathFuse = Integer.parseInt(split[1]);
      } else if (split[0].equals("HitSoundEnable")) {
        this.hitSoundEnable = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("EntityHitSoundEnable")) {
        this.entityHitSoundEnable = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("HitSound")) {
        this.hitSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "sound", split[1]);
      } else if (split[0].equals("HitSoundRange")) {
        this.hitSoundRange = Float.parseFloat(split[1]);
      } else if (split[0].equals("Penetrates")) {
        this.penetratingPower = Boolean.parseBoolean(split[1].toLowerCase()) ? 1.0F : 0.25F;
      } else if (split[0].equals("Penetration") || split[0].equals("PenetratingPower")) {
        this.penetratingPower = Float.parseFloat(split[1]);
      } else if (split[0].equals("DragInAir")) {
        this.dragInAir = Float.parseFloat(split[1]);
        this.dragInAir = (this.dragInAir < 0.0F) ? 0.0F : ((this.dragInAir > 1.0F) ? 1.0F : this.dragInAir);
      } else if (split[0].equals("DragInWater")) {
        this.dragInWater = Float.parseFloat(split[1]);
        this.dragInWater = (this.dragInWater < 0.0F) ? 0.0F : ((this.dragInWater > 1.0F) ? 1.0F : this.dragInWater);
      } else if (split[0].equals("ASWminRange")) {
        this.ASWminRange = Float.parseFloat(split[1]);
      } else if (split[0].equals("seekerRange")) {
        this.seekerRange = Float.parseFloat(split[1]);
      } else if (split[0].equals("NumBullets")) {
        this.numBullets = Integer.parseInt(split[1]);
      } else if (split[0].equals("Accuracy") || split[0].equals("Spread")) {
        this.bulletSpread = Float.parseFloat(split[1]);
      } else if (split[0].equals("LivingProximityTrigger")) {
        this.livingProximityTrigger = Float.parseFloat(split[1]);
      } else if (split[0].equals("VehicleProximityTrigger")) {
        this.driveableProximityTrigger = Float.parseFloat(split[1]);
      } else if (split[0].equals("DamageToTriggerer")) {
        this.damageToTriggerer = Float.parseFloat(split[1]);
      } else if (split[0].equals("PrimeDelay") || split[0].equals("TriggerDelay")) {
        this.primeDelay = Integer.parseInt(split[1]);
      } else if (split[0].equals("NumExplodeParticles")) {
        this.explodeParticles = Integer.parseInt(split[1]);
      } else if (split[0].equals("ExplodeParticles")) {
        this.explodeParticleType = split[1];
      } else if (split[0].equals("SmokeTime")) {
        this.smokeTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("SmokeParticles")) {
        this.smokeParticleType = split[1];
      } else if (split[0].equals("SmokeEffect")) {
        this.smokeEffects.add(getPotionEffect(split));
      } else if (split[0].equals("SmokeRadius")) {
        this.smokeRadius = Float.parseFloat(split[1]);
      } else if (split[0].equals("VLS") || split[0].equals("HasDeadZone")) {
        this.VLS = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("VLSTime") || split[0].equals("DeadZoneTime")) {
        this.VLSTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("FixedTrackDirection")) {
        this.fixedDirection = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("GuidedTurnRadius")) {
        this.turnRadius = Float.parseFloat(split[1]);
      } else if (split[0].equals("GuidedPhaseSpeed")) {
        this.trackPhaseSpeed = Float.parseFloat(split[1]);
      } else if (split[0].equals("GuidedPhaseTurnSpeed")) {
        this.trackPhaseTurn = Float.parseFloat(split[1]);
      } else if (split[0].equals("BoostParticle")) {
        this.boostPhaseParticle = split[1];
      } else if (split[0].equals("Torpedo")) {
        this.torpedo = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("modernTorpedo")) {
        this.modernTorpedo = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("antiRadiation")) {
        this.antiRadiation = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("Bomb")) {
        this.weaponType = EnumWeaponType.BOMB;
      } else if (split[0].equals("Shell")) {
        this.weaponType = EnumWeaponType.SHELL;
      } else if (split[0].equals("jamiogravity")) {
        this.jamiogravity = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("Missile")) {
        this.weaponType = EnumWeaponType.MISSILE;
      } else if (split[0].equals("WeaponType")) {
        this.weaponType = EnumWeaponType.valueOf(split[1].toUpperCase());
      } else if (split[0].equals("HasLight")) {
        this.hasLight = Boolean.parseBoolean(split[1].toLowerCase());
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
      } else if (split[0].equals("MaxLockOnAngle")) {
        this.maxLockOnAngle = Float.parseFloat(split[1]);
      } else if (split[0].equals("LockOnForce") || split[0].equals("TurningForce")) {
        this.lockOnForce = Float.parseFloat(split[1]);
      } else if (split[0].equals("MaxDegreeOfLockOnMissile")) {
        this.maxDegreeOfMissile = Integer.parseInt(split[1]);
      } else if (split[0].equals("TickStartHoming")) {
        this.tickStartHoming = Integer.parseInt(split[1]);
      } else if (split[0].equals("EnableSACLOS")) {
        this.enableSACLOS = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("MaxDegreeOFSACLOS")) {
        this.maxDegreeOfSACLOS = Integer.parseInt(split[1]);
      } else if (split[0].equals("MaxRangeOfMissile")) {
        this.maxRangeOfMissile = Integer.parseInt(split[1]);
      } else if (split[0].equals("CanSpotEntityDriveable")) {
        this.canSpotEntityDriveable = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("ShootForSettingPos")) {
        this.shootForSettingPos = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("ShootForSettingPosHeight")) {
        this.shootForSettingPosHeight = Integer.parseInt(split[1]);
      } else if (split[0].equals("IsDoTopAttack")) {
        this.isDoTopAttack = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("PotionEffect")) {
        this.hitEffects.add(getPotionEffect(split));
      } else if (split[0].equals("ManualGuidance")) {
        this.manualGuidance = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("LockOnFuse")) {
        this.lockOnFuse = Integer.parseInt(split[1]);
      } else if (split[0].equals("MaxRange")) {
        this.maxRange = Integer.parseInt(split[1]);
      } else if (split[0].equals("SwordEnergy")) {
        this.swordEnergy = Boolean.parseBoolean(split[1].toLowerCase());
        this.penetratingPower = 9000.0F;
        this.tickStartHoming = 1;
        this.lockOnForce = 300.0F;
        this.maxLockOnAngle = 90.0F;
        this.lockOnToPlayers = true;
        this.lockOnToLivings = true;
        this.seekerRange = 3.0F;
        this.barelypenPenalty = 0.5F;
        this.nonpenPenalty = 0.25F;
      } else if (split[0].equals("nonpenPenalty")) {
        this.nonpenPenalty = Float.parseFloat(split[1]);
      } else if (split[0].equals("barelypenPenalty")) {
        this.barelypenPenalty = Float.parseFloat(split[1]);
      } 
    } catch (Exception e) {
      System.out.println("Reading bullet file failed.");
      if (FlansMod.printStackTrace)
        e.printStackTrace(); 
    } 
  }
  
  public static BulletType getBullet(String s) {
    for (BulletType bullet : bullets) {
      if (bullet.shortName.equals(s))
        return bullet; 
    } 
    return null;
  }
  
  public static BulletType getBullet(Item item) {
    for (BulletType bullet : bullets) {
      if (bullet.item == item)
        return bullet; 
    } 
    return null;
  }
  
  public void reloadModel() {
    this.model = (ModelBase)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelBase.class);
  }
}
