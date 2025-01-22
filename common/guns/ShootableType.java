package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.HashMap;
import net.minecraft.client.model.ModelBase;

public abstract class ShootableType extends InfoType {
  @SideOnly(Side.CLIENT)
  public ModelBase model;
  
  public ModelBase launcherMesh;
  
  public boolean wingVisible = false;
  
  public boolean trailParticles = false;
  
  public String trailParticleType = "smoke";
  
  public int maxStackSize = 1;
  
  public String dropItemOnReload = null;
  
  public String dropItemOnShoot = null;
  
  public String dropItemOnHit = null;
  
  public int roundsPerItem = 1;
  
  public float fallSpeed = 1.0F;
  
  public float throwSpeed = 1.0F;
  
  public float hitBoxSize = 0.5F;
  
  public float damageVsPlayer = 1.0F;
  
  public float damageVsEntity = 1.0F;
  
  public float damageVsLiving = 1.0F;
  
  public float damageVsVehicles = 1.0F;
  
  public float damageVsPlanes = 1.0F;
  
  public boolean readDamageVsPlayer = false;
  
  public boolean readDamageVsEntity = false;
  
  public boolean readDamageVsPlanes = false;
  
  public boolean missileRadarVisible = false;
  
  public boolean breaksGlass = false;
  
  public float ignoreArmorProbability = 0.0F;
  
  public float ignoreArmorDamageFactor = 0.0F;
  
  public float speedMultiplier = 1.0F;
  
  public float bleedMultiplier = 1.0F;
  
  public float bodyarmorPen = 500.0F;
  
  public float dynamicBodyarmorPen = 250.0F;
  
  public int fuse = 0;
  
  public int despawnTime = 0;
  
  public boolean explodeOnImpact = false;
  
  public float fireRadius = 0.0F;
  
  public float explosionRadius = 0.0F;
  
  public float classicExplosionRadius = 0.0F;
  
  public boolean explosionBreaksBlocks = true;
  
  public float explosionDamageVsLiving = 1.0F;
  
  public float explosionDamageVsPlayer = 1.0F;
  
  public float explosionDamageVsPlane = 1.0F;
  
  public float explosionDamageVsVehicle = 1.0F;
  
  public String dropItemOnDetonate = null;
  
  public String detonateSound = "";
  
  public boolean hasSubmunitions = false;
  
  public String submunition = "";
  
  public int numSubmunitions = 0;
  
  public int subMunitionTimer = 0;
  
  public float submunitionSpread = 1.0F;
  
  public boolean destroyOnDeploySubmunition = false;
  
  public int smokeParticleCount = 0;
  
  public int debrisParticleCount = 0;
  
  public static HashMap<String, ShootableType> shootables = new HashMap<>();
  
  public ShootableType(TypeFile file) {
    super(file);
  }
  
  protected void preRead(TypeFile file) {}
  
  public void postRead(TypeFile file) {
    if (shootables.containsKey(this.shortName))
      FlansMod.log("Error : " + this.shortName + " reduplicated"); 
    shootables.put(this.shortName, this);
    if (!this.readDamageVsPlayer)
      this.damageVsPlayer = this.damageVsLiving; 
    if (!this.readDamageVsEntity)
      this.damageVsEntity = this.damageVsVehicles; 
    if (!this.readDamageVsPlanes)
      this.damageVsPlanes = this.damageVsVehicles; 
  }
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
        this.model = (ModelBase)FlansMod.proxy.loadModel(split[1], this.shortName, ModelBase.class);
      } else if (split[0].equals("Texture")) {
        this.texture = split[1];
      } 
      if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("launcherMesh")) {
        this.launcherMesh = (ModelBase)FlansMod.proxy.loadModel(split[1], this.shortName, ModelBase.class);
      } else if (split[0].equals("LauncherSkin")) {
        this.LauncherSkin = split[1];
      } else if (split[0].equals("StackSize") || split[0].equals("MaxStackSize")) {
        this.maxStackSize = Integer.parseInt(split[1]);
      } else if (split[0].equals("DropItemOnShoot")) {
        this.dropItemOnShoot = split[1];
      } else if (split[0].equals("DropItemOnReload")) {
        this.dropItemOnReload = split[1];
      } else if (split[0].equals("DropItemOnHit")) {
        this.dropItemOnHit = split[1];
      } else if (split[0].equals("RoundsPerItem")) {
        this.roundsPerItem = Integer.parseInt(split[1]);
      } else if (split[0].equals("missileRadarVisible")) {
        this.missileRadarVisible = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("speedMultiplier")) {
        this.speedMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("armPen")) {
        this.bodyarmorPen = Float.parseFloat(split[1]);
      } else if (split[0].equals("headPen")) {
        this.bodyarmorPen = Float.parseFloat(split[1]);
      } else if (split[0].equals("bodyPen")) {
        this.bodyarmorPen = Float.parseFloat(split[1]);
      } else if (split[0].equals("bodyArmorPen")) {
        this.bodyarmorPen = Float.parseFloat(split[1]);
      } else if (split[0].equals("dynamicBodyArmorPen")) {
        this.dynamicBodyarmorPen = Float.parseFloat(split[1]);
      } else if (split[0].equals("bleedMultiplier")) {
        this.bleedMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("FallSpeed")) {
        this.fallSpeed = Float.parseFloat(split[1]);
      } else if (split[0].equals("ThrowSpeed") || split[0].equals("ShootSpeed")) {
        this.throwSpeed = Float.parseFloat(split[1]);
      } else if (split[0].equals("HitBoxSize")) {
        this.hitBoxSize = Float.parseFloat(split[1]);
      } else if (split[0].equals("DamageVsLiving")) {
        this.damageVsLiving = Float.parseFloat(split[1]);
      } else if (split[0].equals("DamageVsPlayer")) {
        this.damageVsPlayer = Float.parseFloat(split[1]);
        this.readDamageVsPlayer = true;
      } else if (split[0].equals("DamageVsEntity")) {
        this.damageVsEntity = Float.parseFloat(split[1]);
        this.readDamageVsEntity = true;
      } else if (split[0].equals("DamageVsVehicles")) {
        this.damageVsVehicles = Float.parseFloat(split[1]);
      } else if (split[0].equals("DamageVsPlanes")) {
        this.damageVsPlanes = Float.parseFloat(split[1]);
        this.readDamageVsPlanes = true;
      } else if (split[0].equals("IgnoreArmorProbability")) {
        this.ignoreArmorProbability = Float.parseFloat(split[1]);
      } else if (split[0].equals("IgnoreArmorDamageFactor")) {
        this.ignoreArmorDamageFactor = Float.parseFloat(split[1]);
      } else if (split[0].equals("BreaksGlass")) {
        this.breaksGlass = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("wingVisible")) {
        this.wingVisible = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("Fuse")) {
        this.fuse = Integer.parseInt(split[1]);
      } else if (split[0].equals("DespawnTime")) {
        this.despawnTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("CringeExplodeOnImpact") || split[0].equals("CringeDetonateOnImpact")) {
        this.explodeOnImpact = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("FireRadius") || split[0].equals("Fire")) {
        this.fireRadius = Float.parseFloat(split[1]);
      } else if (split[0].equals("ExplosionRadius") || split[0].equals("Explosion")) {
        this.explosionRadius = Float.parseFloat(split[1]);
      } else if (split[0].equals("classicExplosionRadius") || split[0].equals("classicExplosion")) {
        this.classicExplosionRadius = Float.parseFloat(split[1]);
      } else if (split[0].equals("ExplosionBreaksBlocks")) {
        this.explosionBreaksBlocks = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("ExplosionDamageVsLiving")) {
        this.explosionDamageVsLiving = Float.parseFloat(split[1]);
      } else if (split[0].equals("ExplosionDamageVsPlayer")) {
        this.explosionDamageVsPlayer = Float.parseFloat(split[1]);
      } else if (split[0].equals("ExplosionDamageVsPlane")) {
        this.explosionDamageVsPlane = Float.parseFloat(split[1]);
      } else if (split[0].equals("ExplosionDamageVsVehicle")) {
        this.explosionDamageVsVehicle = Float.parseFloat(split[1]);
      } else if (split[0].equals("DropItemOnDetonate")) {
        this.dropItemOnDetonate = split[1];
      } else if (split[0].equals("DetonateSound")) {
        this.detonateSound = split[1];
      } else if (split[0].equals("HasSubmunitions")) {
        this.hasSubmunitions = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("Submunition")) {
        this.submunition = split[1];
      } else if (split[0].equals("NumSubmunitions")) {
        this.numSubmunitions = Integer.parseInt(split[1]);
      } else if (split[0].equals("SubmunitionDelay")) {
        this.subMunitionTimer = Integer.parseInt(split[1]);
      } else if (split[0].equals("SubmunitionSpread")) {
        this.submunitionSpread = Float.parseFloat(split[1]);
      } else if (split[0].equals("FlareParticleCount")) {
        this.smokeParticleCount = Integer.parseInt(split[1]);
      } else if (split[0].equals("DebrisParticleCount")) {
        this.debrisParticleCount = Integer.parseInt(split[1]);
      } else if (split[0].equals("smokeParticleCount")) {
        this.smokeParticleCount = Integer.parseInt(split[1]);
      } else if (split[0].equals("TrailParticles") || split[0].equals("SmokeTrail")) {
        this.trailParticles = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("TrailParticleType")) {
        this.trailParticleType = split[1];
      } else if (split[0].equals("SwordEnergy")) {
        this.fuse = 4 * this.fuse;
        this.hitBoxSize = 0.7F * this.hitBoxSize;
      } 
    } catch (Exception e) {
      if (split != null) {
        String msg = " : ";
        for (String s : split)
          msg = msg + " " + s; 
        System.out.println("Reading grenade file failed. " + file.name + msg);
      } else {
        System.out.println("Reading grenade file failed. " + file.name);
      } 
      if (FlansMod.printStackTrace)
        e.printStackTrace(); 
    } 
  }
  
  public static ShootableType getShootableType(String string) {
    return shootables.get(string);
  }
  
  public float GetRecommendedScale() {
    return 0.0F;
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBase GetModel() {
    return this.model;
  }
}
