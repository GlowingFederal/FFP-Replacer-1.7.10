package com.flansmod.common.guns;

import com.flansmod.client.model.ModelCasing;
import com.flansmod.client.model.ModelFlash;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.model.ModelMG;
import com.flansmod.common.FlansMod;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.types.TypeFile;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;

public class GunType extends PaintableType implements IScope {
  public static final Random rand = new Random();
  
  public List<ShootableType> ammo = new ArrayList<>();
  
  public boolean canForceReload = true;
  
  public boolean canBlock = false;
  
  public boolean matchlock = false;
  
  public boolean RepeatingGun = false;
  
  public boolean OldGun = false;
  
  public boolean Heavy = false;
  
  public boolean Bow = false;
  
  public boolean shootMelee = false;
  
  public boolean spear = false;
  
  public int drawTime = 30;
  
  public String actionSound;
  
  public int reloadTime;
  
  public float recoilPitch = 0.0F;
  
  public float recoilYaw = 0.0F;
  
  public float rndRecoilPitchRange = 1.0F;
  
  public float rndRecoilYawRange = 1.0F;
  
  public float decreaseRecoilPitch = 1.0F;
  
  public float decreaseRecoilYaw = 1.0F;
  
  public float bulletSpread;
  
  public float sneakSpreadMultiplier = 0.63F;
  
  public float sprintSpreadMultiplier = 1.75F;
  
  public boolean allowSpreadByBullet = false;
  
  public float damage = 0.0F;
  
  public float meleeDamage = 1.0F;
  
  public float bulletSpeed = 5.0F;
  
  public int numBullets = 1;
  
  public boolean allowNumBulletsByBulletType = false;
  
  public float shootDelay = 0.0F;
  
  public int numPrimaryAmmoItems = 1;
  
  public EnumFireMode mode = EnumFireMode.FULLAUTO;
  
  public EnumFireMode[] submode = new EnumFireMode[] { EnumFireMode.FULLAUTO };
  
  public EnumFireMode defaultmode = this.mode;
  
  public int numBurstRounds = 3;
  
  public int minigunStartSpeed = 15;
  
  public boolean canShootUnderwater = true;
  
  public float knockback = 0.0F;
  
  public EnumSecondaryFunction secondaryFunction = EnumSecondaryFunction.ADS_ZOOM;
  
  public EnumSecondaryFunction secondaryFunctionWhenShoot = null;
  
  public boolean oneHanded = false;
  
  public int labigunLimit = 0;
  
  public boolean labigunDelay = false;
  
  public boolean consumeGunUponUse = false;
  
  public boolean showCrosshair = true;
  
  public String dropItemOnShoot = null;
  
  public int meleeTime = 1;
  
  public ArrayList<Vector3f> meleePath = new ArrayList<>(), meleePathAngles = new ArrayList<>();
  
  public ArrayList<Vector3f> meleeDamagePoints = new ArrayList<>();
  
  public int meleeLeftTime = 1;
  
  public float swordArmorPen = 10.0F;
  
  public float Xoffset = -0.05F;
  
  public float Yoffset = -0.015F;
  
  public float Zoffset = 0.05F;
  
  public ArrayList<Vector3f> meleeLeftPath = new ArrayList<>(), meleeLeftPathAngles = new ArrayList<>();
  
  public ArrayList<Vector3f> meleeLeftDamagePoints = new ArrayList<>();
  
  public boolean meleeLeft = false;
  
  public int meleeRightTime = 1;
  
  public ArrayList<Vector3f> meleeRightPath = new ArrayList<>(), meleeRightPathAngles = new ArrayList<>();
  
  public ArrayList<Vector3f> meleeRightDamagePoints = new ArrayList<>();
  
  public boolean meleeRight = false;
  
  public String bulletInsert = "defaultshellinsert";
  
  public int meleeDownTime = 1;
  
  public ArrayList<Vector3f> meleeDownPath = new ArrayList<>(), meleeDownPathAngles = new ArrayList<>();
  
  public ArrayList<Vector3f> meleeDownDamagePoints = new ArrayList<>();
  
  public boolean meleeDown = false;
  
  public boolean usableByPlayers = true;
  
  public boolean usableByMechas = true;
  
  public EnumAction itemUseAction = EnumAction.bow;
  
  public int canLockOnAngle = 5;
  
  public int lockOnSoundTime = 0;
  
  public String lockOnSound = "";
  
  public int maxRangeLockOn = 80;
  
  public boolean canSetPosition = false;
  
  public boolean lance = false;
  
  public boolean lockOnToPlanes = false, lockOnToVehicles = false, lockOnToMechas = false, lockOnToPlayers = false, lockOnToLivings = false;
  
  public boolean showAttachments = true;
  
  public boolean showDamage = false, showRecoil = false, showSpread = false;
  
  public boolean showReloadTime = false;
  
  public boolean shield = false;
  
  public Vector3f shieldOrigin;
  
  public Vector3f shieldDimensions;
  
  public float shieldDamageAbsorption = 0.1F;
  
  public String shootSound;
  
  public String distantShootSound;
  
  public String lastShootSound;
  
  public String suppressedShootSound;
  
  public int shootSoundLength;
  
  public boolean distortSound = true;
  
  public String reloadSound;
  
  public String reloadSoundOnEmpty;
  
  public String clickSoundOnEmpty;
  
  public int idleSoundRange = 50;
  
  public int meleeSoundRange = 50;
  
  public int reloadSoundRange = 50;
  
  public int gunSoundRange = 50;
  
  public int distantSoundRange = 200;
  
  public boolean useLoopingSounds = false;
  
  public String warmupSound;
  
  public int warmupSoundLength = 20;
  
  public String loopedSound;
  
  public int loopedSoundLength = 20;
  
  public String cooldownSound;
  
  public String meleeSound;
  
  public String meleeHitSound;
  
  public String ShieldHitSound;
  
  public String idleSound;
  
  public int idleSoundLength;
  
  public boolean deployable = false;
  
  @SideOnly(Side.CLIENT)
  public ModelMG deployableModel;
  
  public String deployableTexture;
  
  public float standBackDist = 1.5F;
  
  public float topViewLimit = -60.0F;
  
  public float bottomViewLimit = 30.0F;
  
  public float sideViewLimit = 45.0F;
  
  public float pivotHeight = 0.375F;
  
  public String defaultScopeTexture;
  
  public boolean hasScopeOverlay = false;
  
  public float zoomLevel = 1.0F;
  
  public float FOVFactor = 1.5F;
  
  public boolean allowNightVision = false;
  
  @SideOnly(Side.CLIENT)
  public ModelGun model;
  
  public float modelScale = 1.0F;
  
  public ModelCasing casingModel;
  
  public ModelFlash flashModel;
  
  public String casingTexture;
  
  public String flashTexture;
  
  public String hitTexture;
  
  public boolean allowAllAttachments = false;
  
  public ArrayList<AttachmentType> allowedAttachments = new ArrayList<>();
  
  public boolean allowBarrelAttachments = false;
  
  public boolean allowScopeAttachments = false;
  
  public boolean allowStockAttachments = false;
  
  public boolean allowGripAttachments = false;
  
  public boolean allowGadgetAttachments = false;
  
  public boolean allowSlideAttachments = false;
  
  public boolean allowPumpAttachments = false;
  
  public boolean allowAccessoryAttachments = false;
  
  public int numGenericAttachmentSlots = 0;
  
  public static HashMap<String, GunType> guns = new HashMap<>();
  
  public static ArrayList<GunType> gunList = new ArrayList<>();
  
  public float moveSpeedModifier = 1.0F;
  
  public float knockbackModifier = 0.0F;
  
  private float defaultSpread = 0.0F;
  
  public boolean sidearm = false;
  
  public int blockTime = 100;
  
  public float dillZoomModifier = 1.0F;
  
  public float dillElevator = 1.0F;
  
  public float recoilElevator = 0.0F;
  
  public float sustainedelevator = 0.25F;
  
  public float firstShotRecoil = 0.1F;
  
  public float sustainedRecoilPitch = 1.0F;
  
  public float sustainedRecoilYaw = 1.0F;
  
  public float muzzleOffset = 5.0F;
  
  public String muzzleParticle = "smallSmoke";
  
  public int muzzleParticleCount = 7;
  
  public boolean muzzleParticleHave = false;
  
  public GunType(TypeFile file) {
    super(file);
  }
  
  public void preRead(TypeFile file) {
    super.preRead(file);
  }
  
  public void postRead(TypeFile file) {
    super.postRead(file);
    gunList.add(this);
    guns.put(this.shortName, this);
  }
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (split[0].equals("Damage")) {
        this.damage = Float.parseFloat(split[1]);
      } else if (split[0].equals("MeleeDamaged")) {
        this.meleeDamage = Float.parseFloat(split[1]);
        if (this.meleeDamage > 0.5F)
          this.secondaryFunction = EnumSecondaryFunction.MELEE; 
      } else if (split[0].equals("dillZoomModifier")) {
        this.dillZoomModifier = Float.parseFloat(split[1]);
      } else if (split[0].equals("dillElevator")) {
        this.dillElevator = Float.parseFloat(split[1]);
      } else if (split[0].equals("muzzleParticleHave")) {
        this.muzzleParticleHave = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("muzzleOffset")) {
        this.muzzleOffset = Float.parseFloat(split[1]);
      } else if (split[0].equals("muzzleParticleCount")) {
        this.muzzleParticleCount = Integer.parseInt(split[1]);
      } else if (split[0].equals("muzzleParticle")) {
        this.muzzleParticle = split[1];
      } else if (split[0].equals("Xoffset")) {
        this.Xoffset = Float.parseFloat(split[1]);
      } else if (split[0].equals("Yoffset")) {
        this.Yoffset = Float.parseFloat(split[1]);
      } else if (split[0].equals("Zoffset")) {
        this.Zoffset = Float.parseFloat(split[1]);
      } else if (split[0].equals("recoilElevator")) {
        this.recoilElevator = Float.parseFloat(split[1]);
      } else if (split[0].equals("sustainedelevator")) {
        this.sustainedelevator = Float.parseFloat(split[1]);
      } else if (split[0].equals("firstShotRecoil")) {
        this.firstShotRecoil = Float.parseFloat(split[1]);
      } else if (split[0].equals("sustainedRecoilPitch")) {
        this.sustainedRecoilPitch = 0.3F * Float.parseFloat(split[1]);
      } else if (split[0].equals("sustainedRecoilYaw")) {
        this.sustainedRecoilYaw = 0.3F * Float.parseFloat(split[1]);
      } else if (split[0].equals("CanForceReload")) {
        this.canForceReload = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("ReloadTime")) {
        this.reloadTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("Recoil")) {
        this.recoilPitch = 0.3F * Float.parseFloat(split[1]);
      } else if (split[0].equals("RecoilYaw")) {
        this.recoilYaw = 0.3F * Float.parseFloat(split[1]);
      } else if (split[0].equals("RandomRecoilRange")) {
        this.rndRecoilPitchRange = Float.parseFloat(split[1]);
      } else if (split[0].equals("RandomRecoilYawRange")) {
        this.rndRecoilYawRange = Float.parseFloat(split[1]);
      } else if (split[0].equals("DecreaseRecoil")) {
        this.decreaseRecoilPitch = Float.parseFloat(split[1]);
      } else if (split[0].equals("DecreaseRecoilYaw")) {
        this.decreaseRecoilYaw = Float.parseFloat(split[1]);
      } else if (split[0].equals("Knockback")) {
        this.knockback = Float.parseFloat(split[1]);
      } else if (split[0].equals("Accuracy") || split[0].equals("Spread")) {
        this.defaultSpread = this.bulletSpread = Float.parseFloat(split[1]);
      } else if (split[0].equals("SneakSpreadModifier")) {
        this.sneakSpreadMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("SprintSpreadModifier")) {
        this.sprintSpreadMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("NumBullets")) {
        this.numBullets = Integer.parseInt(split[1]);
      } else if (split[0].equals("AllowNumBulletsByBulletType")) {
        this.allowNumBulletsByBulletType = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("AllowSpreadByBullet")) {
        this.allowSpreadByBullet = Boolean.parseBoolean(split[1]);
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
      } else if (split[0].equals("sidearm")) {
        this.sidearm = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("ConsumeGunOnUse")) {
        this.consumeGunUponUse = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("ShowCrosshair")) {
        this.showCrosshair = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("DropItemOnShoot")) {
        this.dropItemOnShoot = split[1];
      } else if (split[0].equals("NumBurstRounds")) {
        this.numBurstRounds = Integer.parseInt(split[1]);
      } else if (split[0].equals("MinigunStartSpeed")) {
        this.minigunStartSpeed = Integer.parseInt(split[1]);
      } else if (split[0].equals("ItemUseAction")) {
        this.itemUseAction = EnumAction.valueOf(split[1].toLowerCase());
      } else if (split[0].equals("MaxRangeLockOn")) {
        this.maxRangeLockOn = Integer.parseInt(split[1]);
      } else if (split[0].equals("ShowAttachments")) {
        this.showAttachments = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("ShowDamage")) {
        this.showDamage = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("ShowRecoil")) {
        this.showRecoil = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("ShowAccuracy")) {
        this.showSpread = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("ShowReloadTime")) {
        this.showReloadTime = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("ShootDelay")) {
        this.shootDelay = Float.parseFloat(split[1]);
      } else if (split[0].equals("RPM")) {
        this.shootDelay = 20.0F / Float.parseFloat(split[1]) / 60.0F;
      } else if (split[0].equals("SoundLength")) {
        this.shootSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("DistortSound")) {
        this.distortSound = split[1].equals("True");
      } else if (split[0].equals("IdleSoundRange")) {
        this.idleSoundRange = Integer.parseInt(split[1]);
      } else if (split[0].equals("MeleeSoundRange")) {
        this.meleeSoundRange = Integer.parseInt(split[1]);
      } else if (split[0].equals("ReloadSoundRange")) {
        this.reloadSoundRange = Integer.parseInt(split[1]);
      } else if (split[0].equals("GunSoundRange")) {
        this.gunSoundRange = Integer.parseInt(split[1]);
      } else if (split[0].equals("distantSoundRange")) {
        this.distantSoundRange = Integer.parseInt(split[1]);
      } else if (split[0].equals("ShootSound")) {
        this.shootSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("distantShootSound")) {
        this.distantShootSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("LastShootSound")) {
        this.lastShootSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("SuppressedShootSound")) {
        this.suppressedShootSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("ReloadSound")) {
        this.reloadSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("EmptyReloadSound")) {
        this.reloadSoundOnEmpty = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("EmptyClickSound")) {
        this.clickSoundOnEmpty = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("IdleSound")) {
        this.idleSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("IdleSoundLength")) {
        this.idleSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("MeleeSound")) {
        this.meleeSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("MeleeHitSound")) {
        this.meleeHitSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("ShieldHitSound")) {
        this.ShieldHitSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("WarmupSound")) {
        this.warmupSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("WarmupSoundLength")) {
        this.warmupSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("LoopedSound") || split[0].equals("SpinSound")) {
        this.loopedSound = split[1];
        this.useLoopingSounds = true;
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("LoopedSoundLength") || split[0].equals("SpinSoundLength")) {
        this.loopedSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("CooldownSound")) {
        this.cooldownSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("LockOnSound")) {
        this.lockOnSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("Mode")) {
        this.mode = EnumFireMode.getFireMode(split[1]);
        this.defaultmode = this.mode;
        this.submode = new EnumFireMode[split.length - 1];
        for (int i = 0; i < this.submode.length; i++)
          this.submode[i] = EnumFireMode.getFireMode(split[1 + i]); 
      } else if (split[0].equals("Scope")) {
        this.hasScopeOverlay = true;
        if (split[1].equals("None")) {
          this.hasScopeOverlay = false;
        } else {
          this.defaultScopeTexture = split[1];
        } 
      } else if (split[0].equals("AllowNightVision")) {
        this.allowNightVision = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("ZoomLevel")) {
        this.zoomLevel = Float.parseFloat(split[1]);
        if (this.zoomLevel > 1.0F)
          this.secondaryFunction = EnumSecondaryFunction.ZOOM; 
      } else if (split[0].equals("FOVZoomLevel")) {
        this.FOVFactor = Float.parseFloat(split[1]);
        if (this.FOVFactor > 1.0F)
          this.secondaryFunction = EnumSecondaryFunction.ADS_ZOOM; 
      } else if (split[0].equals("Deployable")) {
        this.deployable = split[1].equals("True");
      } else if (FMLCommonHandler.instance().getSide().isClient() && this.deployable && split[0].equals("DeployedModel")) {
        this.deployableModel = (ModelMG)FlansMod.proxy.loadModel(split[1], this.shortName, ModelMG.class);
      } else if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
        this.model = (ModelGun)FlansMod.proxy.loadModel(split[1], this.shortName, ModelGun.class);
      } else if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("CasingModel")) {
        this.casingModel = (ModelCasing)FlansMod.proxy.loadModel(split[1], this.shortName, ModelCasing.class);
      } else if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("FlashModel")) {
        this.flashModel = (ModelFlash)FlansMod.proxy.loadModel(split[1], this.shortName, ModelFlash.class);
      } else if (split[0].equals("CasingTexture")) {
        this.casingTexture = split[1];
      } else if (split[0].equals("FlashTexture")) {
        this.flashTexture = split[1];
      } else if (split[0].equals("ModelScale")) {
        this.modelScale = Float.parseFloat(split[1]);
      } else if (split[0].equals("Texture")) {
        this.texture = split[1];
      } else if (split[0].equals("HitTexture")) {
        this.hitTexture = split[1];
      } else if (split[0].equals("DeployedTexture")) {
        this.deployableTexture = split[1];
      } else if (split[0].equals("StandBackDistance")) {
        this.standBackDist = Float.parseFloat(split[1]);
      } else if (split[0].equals("TopViewLimit")) {
        this.topViewLimit = -Float.parseFloat(split[1]);
      } else if (split[0].equals("BottomViewLimit")) {
        this.bottomViewLimit = Float.parseFloat(split[1]);
      } else if (split[0].equals("SideViewLimit")) {
        this.sideViewLimit = Float.parseFloat(split[1]);
      } else if (split[0].equals("PivotHeight")) {
        this.pivotHeight = Float.parseFloat(split[1]);
      } else if (split[0].equals("Ammo")) {
        ShootableType type = ShootableType.getShootableType(split[1]);
        if (type != null)
          this.ammo.add(type); 
      } else if (split[0].equals("NumAmmoSlots") || split[0].equals("NumAmmoItemsInGun") || split[0].equals("LoadIntoGun")) {
        this.numPrimaryAmmoItems = Integer.parseInt(split[1]);
      } else if (split[0].equals("BulletSpeed")) {
        this.bulletSpeed = Float.parseFloat(split[1]);
      } else if (split[0].equals("CanShootUnderwater")) {
        this.canShootUnderwater = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("CanSetPosition")) {
        this.canSetPosition = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("OneHanded")) {
        this.oneHanded = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("SecondaryFunction")) {
        this.secondaryFunction = EnumSecondaryFunction.get(split[1]);
      } else if (split[0].equals("UsableByPlayers")) {
        this.usableByPlayers = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("UsableByMechas")) {
        this.usableByMechas = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("UseCustomMelee") && Boolean.parseBoolean(split[1])) {
        this.secondaryFunction = EnumSecondaryFunction.CUSTOM_MELEE;
      } else if (split[0].equals("UseCustomMeleeWhenShoot") && Boolean.parseBoolean(split[1])) {
        this.secondaryFunctionWhenShoot = EnumSecondaryFunction.CUSTOM_MELEE;
      } else if (split[0].equals("MeleeTime")) {
        this.meleeTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("swordArmorPen") || split[0].equals("swordArmorPen")) {
        this.swordArmorPen = Float.parseFloat(split[1]);
      } else if (split[0].equals("MeleeLeftTime")) {
        this.meleeLeftTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("AddLeftNode")) {
        this.meleeLeftPath.add(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F));
        this.meleeLeftPathAngles.add(new Vector3f(Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6])));
      } else if (split[0].equals("meleeLeft")) {
        this.meleeLeft = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("spear")) {
        this.spear = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("MeleeLeftDamagePoint") || split[0].equals("MeleeLeftDamageOffset")) {
        this.meleeLeftDamagePoints.add(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F));
      } else if (split[0].equals("MeleeRightTime")) {
        this.meleeRightTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("AddRightNode")) {
        this.meleeRightPath.add(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F));
        this.meleeRightPathAngles.add(new Vector3f(Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6])));
      } else if (split[0].equals("meleeRight")) {
        this.meleeRight = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("MeleeRightDamagePoint") || split[0].equals("MeleeRightDamageOffset")) {
        this.meleeRightDamagePoints.add(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F));
      } else if (split[0].equals("MeleeUpTime")) {
        this.meleeDownTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("AddUpNode")) {
        this.meleeDownPath.add(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F));
        this.meleeDownPathAngles.add(new Vector3f(Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6])));
      } else if (split[0].equals("meleeUp")) {
        this.meleeDown = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("MeleeUpDamagePoint") || split[0].equals("MeleeUpDamageOffset")) {
        this.meleeDownDamagePoints.add(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F));
      } else if (split[0].equals("lance")) {
        this.lance = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("match")) {
        this.matchlock = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("AddNode")) {
        this.meleePath.add(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F));
        this.meleePathAngles.add(new Vector3f(Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6])));
      } else if (split[0].equals("MeleeDamagePoint") || split[0].equals("MeleeDamageOffset")) {
        this.meleeDamagePoints.add(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F));
      } else if (split[0].equals("MoveSpeedModifier") || split[0].equals("Slowness")) {
        this.moveSpeedModifier = Float.parseFloat(split[1]);
      } else if (split[0].equals("KnockbackReduction") || split[0].equals("KnockbackModifier")) {
        this.knockbackModifier = Float.parseFloat(split[1]);
      } else if (split[0].equals("AllowAllAttachments")) {
        this.allowAllAttachments = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("AllowAttachments")) {
        for (int i = 1; i < split.length; i++)
          this.allowedAttachments.add(AttachmentType.getAttachment(split[i])); 
      } else if (split[0].equals("AllowBarrelAttachments")) {
        this.allowBarrelAttachments = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("AllowScopeAttachments")) {
        this.allowScopeAttachments = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("AllowStockAttachments")) {
        this.allowStockAttachments = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("AllowGripAttachments")) {
        this.allowGripAttachments = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("AllowGadgetAttachments")) {
        this.allowGadgetAttachments = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("AllowSlideAttachments")) {
        this.allowSlideAttachments = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("AllowPumpAttachments")) {
        this.allowPumpAttachments = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("AllowAccessoryAttachments")) {
        this.allowAccessoryAttachments = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("NumGenericAttachmentSlots")) {
        this.numGenericAttachmentSlots = Integer.parseInt(split[1]);
      } else if (split[0].toLowerCase().equals("shield")) {
        this.shield = true;
        this.shieldOrigin = new Vector3f(Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F, Float.parseFloat(split[4]) / 16.0F);
        this.shieldDimensions = new Vector3f(Float.parseFloat(split[5]) / 16.0F, Float.parseFloat(split[6]) / 16.0F, Float.parseFloat(split[7]) / 16.0F);
        this.shieldDamageAbsorption = Float.parseFloat(split[1]);
      } else if (split[0].equals("labigunLimit")) {
        this.labigunLimit = Integer.parseInt(split[1]);
      } else if (split[0].equals("hasLabigunDelay")) {
        this.labigunDelay = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("shootMelee")) {
        this.shootMelee = Boolean.parseBoolean(split[1]);
        this.defaultSpread = this.bulletSpread = 10.0F * this.defaultSpread;
        this.bulletSpeed = 0.8F * this.bulletSpeed;
        this.consumeGunUponUse = Boolean.parseBoolean(split[1]);
        this.canBlock = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("canBlock")) {
        this.canBlock = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("OldGun")) {
        this.OldGun = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("Bow")) {
        this.Bow = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("Heavy")) {
        this.Heavy = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("RepeatingGun")) {
        this.RepeatingGun = Boolean.parseBoolean(split[1]);
      } 
    } catch (Exception e) {
      if (split != null) {
        String msg = " : ";
        for (String s : split)
          msg = msg + " " + s; 
        System.out.println("Reading gun file failed. " + file.name + msg);
      } else {
        System.out.println("Reading gun file failed. " + file.name);
      } 
      if (FlansMod.printStackTrace)
        e.printStackTrace(); 
    } 
  }
  
  public boolean isAmmo(ShootableType type) {
    return this.ammo.contains(type);
  }
  
  public boolean isAmmo(ShootableType type, ItemStack stack) {
    boolean result = this.ammo.contains(type);
    if (getGrip(stack) != null && getSecondaryFire(stack)) {
      List<ShootableType> t = new ArrayList<>();
      for (String s : (getGrip(stack)).secondaryAmmo) {
        ShootableType shoot = ShootableType.getShootableType(s);
        if (type != null)
          t.add(shoot); 
      } 
      result = t.contains(type);
    } 
    return result;
  }
  
  public boolean isAmmo(ItemStack stack) {
    if (stack == null)
      return false; 
    if (stack.func_77973_b() instanceof ItemBullet)
      return isAmmo(((ItemBullet)stack.func_77973_b()).type, stack); 
    if (stack.func_77973_b() instanceof ItemGrenade)
      return isAmmo(((ItemGrenade)stack.func_77973_b()).type, stack); 
    return false;
  }
  
  public void reloadModel() {
    this.model = (ModelGun)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelGun.class);
  }
  
  public float getZoomFactor() {
    return this.zoomLevel;
  }
  
  public boolean hasZoomOverlay() {
    return this.hasScopeOverlay;
  }
  
  public String getZoomOverlay() {
    return this.defaultScopeTexture;
  }
  
  public float getFOVFactor() {
    return this.FOVFactor;
  }
  
  public IScope getCurrentScope(ItemStack gunStack) {
    IScope attachedScope = getScope(gunStack);
    return (attachedScope == null) ? this : attachedScope;
  }
  
  public ArrayList<AttachmentType> getCurrentAttachments(ItemStack gun) {
    checkForTags(gun);
    ArrayList<AttachmentType> attachments = new ArrayList<>();
    NBTTagCompound attachmentTags = gun.field_77990_d.func_74775_l("attachments");
    NBTTagList genericsList = attachmentTags.func_150295_c("generics", 10);
    for (int i = 0; i < this.numGenericAttachmentSlots; i++)
      appendToList(gun, "generic_" + i, attachments); 
    appendToList(gun, "barrel", attachments);
    appendToList(gun, "scope", attachments);
    appendToList(gun, "stock", attachments);
    appendToList(gun, "grip", attachments);
    appendToList(gun, "gadget", attachments);
    appendToList(gun, "slide", attachments);
    appendToList(gun, "pump", attachments);
    appendToList(gun, "accessory", attachments);
    return attachments;
  }
  
  private void appendToList(ItemStack gun, String name, ArrayList<AttachmentType> attachments) {
    AttachmentType type = getAttachment(gun, name);
    if (type != null)
      attachments.add(type); 
  }
  
  public AttachmentType getBarrel(ItemStack gun) {
    return getAttachment(gun, "barrel");
  }
  
  public AttachmentType getScope(ItemStack gun) {
    return getAttachment(gun, "scope");
  }
  
  public AttachmentType getStock(ItemStack gun) {
    return getAttachment(gun, "stock");
  }
  
  public AttachmentType getGrip(ItemStack gun) {
    return getAttachment(gun, "grip");
  }
  
  public AttachmentType getGadget(ItemStack gun) {
    return getAttachment(gun, "gadget");
  }
  
  public AttachmentType getSlide(ItemStack gun) {
    return getAttachment(gun, "slide");
  }
  
  public AttachmentType getPump(ItemStack gun) {
    return getAttachment(gun, "pump");
  }
  
  public AttachmentType getAccessory(ItemStack gun) {
    return getAttachment(gun, "accessory");
  }
  
  public AttachmentType getGeneric(ItemStack gun, int i) {
    return getAttachment(gun, "generic_" + i);
  }
  
  public ItemStack getBarrelItemStack(ItemStack gun) {
    return getAttachmentItemStack(gun, "barrel");
  }
  
  public ItemStack getScopeItemStack(ItemStack gun) {
    return getAttachmentItemStack(gun, "scope");
  }
  
  public ItemStack getStockItemStack(ItemStack gun) {
    return getAttachmentItemStack(gun, "stock");
  }
  
  public ItemStack getGripItemStack(ItemStack gun) {
    return getAttachmentItemStack(gun, "grip");
  }
  
  public ItemStack getGadgetItemStack(ItemStack gun) {
    return getAttachmentItemStack(gun, "gadget");
  }
  
  public ItemStack getSlideItemStack(ItemStack gun) {
    return getAttachmentItemStack(gun, "slide");
  }
  
  public ItemStack getPumpItemStack(ItemStack gun) {
    return getAttachmentItemStack(gun, "pump");
  }
  
  public ItemStack getAccessoryItemStack(ItemStack gun) {
    return getAttachmentItemStack(gun, "accessory");
  }
  
  public ItemStack getGenericItemStack(ItemStack gun, int i) {
    return getAttachmentItemStack(gun, "generic_" + i);
  }
  
  public AttachmentType getAttachment(ItemStack gun, String name) {
    checkForTags(gun);
    return AttachmentType.getFromNBT(gun.field_77990_d.func_74775_l("attachments").func_74775_l(name));
  }
  
  public ItemStack getAttachmentItemStack(ItemStack gun, String name) {
    checkForTags(gun);
    return ItemStack.func_77949_a(gun.field_77990_d.func_74775_l("attachments").func_74775_l(name));
  }
  
  private void checkForTags(ItemStack gun) {
    if (!gun.func_77942_o())
      gun.field_77990_d = new NBTTagCompound(); 
    if (!gun.field_77990_d.func_74764_b("attachments")) {
      NBTTagCompound attachmentTags = new NBTTagCompound();
      for (int i = 0; i < this.numGenericAttachmentSlots; i++)
        attachmentTags.func_74782_a("generic_" + i, (NBTBase)new NBTTagCompound()); 
      attachmentTags.func_74782_a("barrel", (NBTBase)new NBTTagCompound());
      attachmentTags.func_74782_a("scope", (NBTBase)new NBTTagCompound());
      attachmentTags.func_74782_a("stock", (NBTBase)new NBTTagCompound());
      attachmentTags.func_74782_a("grip", (NBTBase)new NBTTagCompound());
      attachmentTags.func_74782_a("gadget", (NBTBase)new NBTTagCompound());
      attachmentTags.func_74782_a("slide", (NBTBase)new NBTTagCompound());
      attachmentTags.func_74782_a("pump", (NBTBase)new NBTTagCompound());
      attachmentTags.func_74782_a("accessory", (NBTBase)new NBTTagCompound());
      gun.field_77990_d.func_74782_a("attachments", (NBTBase)attachmentTags);
    } 
  }
  
  public float getMeleeDamage(ItemStack stack) {
    float stackMeleeDamage = this.meleeDamage;
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackMeleeDamage *= attachment.meleeDamageMultiplier; 
    return stackMeleeDamage;
  }
  
  public float getDamage(ItemStack stack) {
    float stackDamage = this.damage;
    if (getGrip(stack) != null && getSecondaryFire(stack))
      stackDamage = (getGrip(stack)).secondaryDamage; 
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackDamage *= attachment.damageMultiplier; 
    return stackDamage;
  }
  
  public float getSpread(ItemStack stack, boolean sneaking, boolean sprinting) {
    float stackSpread = this.bulletSpread;
    if (getGrip(stack) != null && getSecondaryFire(stack))
      stackSpread = (getGrip(stack)).secondarySpread; 
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackSpread *= attachment.spreadMultiplier; 
    if (sprinting) {
      stackSpread *= this.sprintSpreadMultiplier;
    } else if (sneaking) {
      stackSpread *= this.sneakSpreadMultiplier;
    } 
    return stackSpread;
  }
  
  public float getDefaultSpread(ItemStack stack) {
    float stackSpread = this.defaultSpread;
    if (getGrip(stack) != null && getSecondaryFire(stack))
      stackSpread = (getGrip(stack)).secondaryDefaultSpread; 
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackSpread *= attachment.spreadMultiplier; 
    return stackSpread;
  }
  
  public float getRecoilPitch(ItemStack stack) {
    float stackRecoil = this.recoilPitch;
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackRecoil *= attachment.recoilMultiplier; 
    return stackRecoil;
  }
  
  public float getRecoilYaw(ItemStack stack) {
    float stackRecoilYaw = this.recoilYaw * (rand.nextFloat() - 0.5F);
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackRecoilYaw *= attachment.recoilMultiplier; 
    return stackRecoilYaw;
  }
  
  public float getSustainedRecoilPitch(ItemStack stack) {
    float stackSustainedRecoil = this.sustainedRecoilPitch;
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackSustainedRecoil *= attachment.recoilMultiplier; 
    return stackSustainedRecoil;
  }
  
  public float getSustainedRecoilYaw(ItemStack stack) {
    float stackSustainedRecoilYaw = this.sustainedRecoilYaw * (rand.nextFloat() - 0.5F);
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackSustainedRecoilYaw *= attachment.recoilMultiplier; 
    return stackSustainedRecoilYaw;
  }
  
  public float getBulletSpeed(ItemStack stack) {
    float stackBulletSpeed = this.bulletSpeed;
    if (getGrip(stack) != null && getSecondaryFire(stack))
      stackBulletSpeed = (getGrip(stack)).secondarySpeed; 
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackBulletSpeed *= attachment.bulletSpeedMultiplier; 
    return stackBulletSpeed;
  }
  
  public float getReloadTime(ItemStack stack) {
    float stackReloadTime = this.reloadTime;
    if (getGrip(stack) != null && getSecondaryFire(stack))
      stackReloadTime = (getGrip(stack)).secondaryReloadTime; 
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackReloadTime *= attachment.reloadTimeMultiplier; 
    return stackReloadTime;
  }
  
  public float getShootDelay(ItemStack stack) {
    float fireRate = this.shootDelay;
    if (getGrip(stack) != null && getSecondaryFire(stack))
      fireRate = (getGrip(stack)).secondaryShootDelay; 
    return fireRate;
  }
  
  public int getNumBullets(ItemStack stack) {
    int amount = this.numBullets;
    if (getGrip(stack) != null && getSecondaryFire(stack))
      amount = (getGrip(stack)).secondaryNumBullets; 
    return amount;
  }
  
  public float getMovementSpeed(ItemStack stack) {
    float stackMovement = this.moveSpeedModifier;
    for (AttachmentType attachment : getCurrentAttachments(stack))
      stackMovement *= attachment.moveSpeedMultiplier; 
    return stackMovement;
  }
  
  public void setFireMode(ItemStack stack, int fireMode) {
    if (!stack.func_77942_o())
      stack.func_77982_d(new NBTTagCompound()); 
    if (fireMode < (EnumFireMode.values()).length) {
      stack.func_77978_p().func_74774_a("GunMode", (byte)fireMode);
    } else {
      stack.func_77978_p().func_74774_a("GunMode", (byte)this.mode.ordinal());
    } 
  }
  
  public EnumFireMode getFireMode(ItemStack stack) {
    if (getGrip(stack) != null && getSecondaryFire(stack))
      return (getGrip(stack)).secondaryFireMode; 
    for (AttachmentType attachment : getCurrentAttachments(stack)) {
      if (attachment.modeOverride != null)
        return attachment.modeOverride; 
    } 
    if (stack.func_77942_o() && stack.func_77978_p().func_74764_b("GunMode")) {
      int gm = stack.func_77978_p().func_74771_c("GunMode");
      if (gm < (EnumFireMode.values()).length)
        for (int i = 0; i < this.submode.length; i++) {
          if (gm == this.submode[i].ordinal())
            return EnumFireMode.values()[gm]; 
        }  
    } 
    setFireMode(stack, this.mode.ordinal());
    return this.mode;
  }
  
  public void setSecondaryFire(ItemStack stack, boolean mode) {
    if (!stack.func_77942_o())
      stack.func_77982_d(new NBTTagCompound()); 
    stack.field_77990_d.func_74757_a("secondaryFire", mode);
  }
  
  public boolean getSecondaryFire(ItemStack stack) {
    if (!stack.func_77942_o())
      stack.func_77982_d(new NBTTagCompound()); 
    if (!stack.func_77978_p().func_74764_b("secondaryFire")) {
      stack.field_77990_d.func_74757_a("secondaryFire", false);
      return stack.func_77978_p().func_74767_n("secondaryFire");
    } 
    return stack.func_77978_p().func_74767_n("secondaryFire");
  }
  
  public int getNumAmmoItemsInGun(ItemStack stack) {
    if (getGrip(stack) != null && getSecondaryFire(stack))
      return (getGrip(stack)).numSecAmmoItems; 
    return this.numPrimaryAmmoItems;
  }
  
  public static GunType getGun(String s) {
    return guns.get(s);
  }
  
  public static GunType getGunForMech(String s) {
    for (GunType gun : gunList) {
      if (gun.shortName.equals(s))
        return gun; 
    } 
    return null;
  }
  
  public Paintjob getPaintjob(String s) {
    for (Paintjob paintjob : this.paintjobs) {
      if (paintjob.iconName.equals(s))
        return paintjob; 
    } 
    return this.defaultPaintjob;
  }
  
  public float GetRecommendedScale() {
    return 60.0F;
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBase GetModel() {
    return (ModelBase)this.model;
  }
}
