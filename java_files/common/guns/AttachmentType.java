package com.flansmod.common.guns;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.common.FlansMod;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.types.TypeFile;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;

public class AttachmentType extends PaintableType implements IScope {
  public static ArrayList<AttachmentType> attachments = new ArrayList<>();
  
  public EnumAttachmentType type = EnumAttachmentType.generic;
  
  public boolean silencer = false;
  
  public boolean flashlight = false;
  
  public float flashlightRange = 10.0F;
  
  public int flashlightStrength = 12;
  
  public boolean disableMuzzleFlash = false;
  
  public boolean barisLaser = false;
  
  public boolean barisInfrared = false;
  
  public float spreadMultiplier = 1.0F;
  
  public float recoilMultiplier = 1.0F;
  
  public float damageMultiplier = 1.0F;
  
  public float meleeDamageMultiplier = 1.0F;
  
  public float bulletSpeedMultiplier = 1.0F;
  
  public float reloadTimeMultiplier = 1.0F;
  
  public float moveSpeedMultiplier = 1.0F;
  
  public EnumFireMode modeOverride = null;
  
  public boolean secondaryFire = false;
  
  public List<String> secondaryAmmo = new ArrayList<>();
  
  public float secondaryDamage = 1.0F;
  
  public float secondarySpread = 1.0F;
  
  public float secondarySpeed = 5.0F;
  
  public int secondaryReloadTime = 1;
  
  public float secondaryShootDelay = 1.0F;
  
  public String secondaryShootSound;
  
  public String secondaryReloadSound;
  
  public EnumFireMode secondaryFireMode = EnumFireMode.SEMIAUTO;
  
  public String toggleSound;
  
  public int secondaryNumBullets = 1;
  
  public int numSecAmmoItems = 1;
  
  public float zoomLevel = 1.0F;
  
  public float FOVZoomLevel = 1.0F;
  
  public String zoomOverlay;
  
  public boolean hasScopeOverlay = false;
  
  public boolean hasNightVision = false;
  
  @SideOnly(Side.CLIENT)
  public ModelAttachment model;
  
  public float modelScale = 1.0F;
  
  public int maxStackSize = 1;
  
  public float secondaryDefaultSpread = 0.0F;
  
  public boolean bayonet = false;
  
  public ArrayList<Vector3f> meleePath = new ArrayList<>(), meleePathAngles = new ArrayList<>();
  
  public AttachmentType(TypeFile file) {
    super(file);
    attachments.add(this);
  }
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (split[0].equals("AttachmentType")) {
        this.type = EnumAttachmentType.get(split[1]);
      } else if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
        this.model = (ModelAttachment)FlansMod.proxy.loadModel(split[1], this.shortName, ModelAttachment.class);
      } else if (split[0].equals("ModelScale")) {
        this.modelScale = Float.parseFloat(split[1]);
      } else if (split[0].equals("Texture")) {
        this.texture = split[1];
      } else if (split[0].equals("Silencer")) {
        this.silencer = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("DisableMuzzleFlash") || split[0].equals("DisableFlash")) {
        this.disableMuzzleFlash = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("barisLaser")) {
        this.barisLaser = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("barisInfrared")) {
        this.barisInfrared = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("bayonet")) {
        this.bayonet = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("AddNode")) {
        this.meleePath.add(new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F));
        this.meleePathAngles.add(new Vector3f(Float.parseFloat(split[4]), Float.parseFloat(split[5]), Float.parseFloat(split[6])));
      } else if (split[0].equals("Flashlight")) {
        this.flashlight = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("FlashlightRange")) {
        this.flashlightRange = Float.parseFloat(split[1]);
      } else if (split[0].equals("FlashlightStrength")) {
        this.flashlightStrength = Integer.parseInt(split[1]);
      } else if (split[0].equals("ModeOverride")) {
        this.modeOverride = EnumFireMode.getFireMode(split[1]);
      } else if (split[0].equals("SecondaryMode")) {
        this.secondaryFire = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("SecondaryAmmo")) {
        this.secondaryAmmo.add(split[1]);
      } else if (split[0].equals("SecondaryDamage")) {
        this.secondaryDamage = Float.parseFloat(split[1]);
      } else if (split[0].equals("SecondarySpread") || split[0].equals("SecondaryAccuracy")) {
        this.secondarySpread = this.secondaryDefaultSpread = Float.parseFloat(split[1]);
      } else if (split[0].equals("SecondaryBulletSpeed")) {
        this.secondarySpeed = Float.parseFloat(split[1]);
      } else if (split[0].equals("SecondaryShootDelay")) {
        this.secondaryShootDelay = Integer.parseInt(split[1]);
      } else if (split[0].equals("SecondaryReloadTime")) {
        this.secondaryReloadTime = Integer.parseInt(split[1]);
      } else if (split[0].equals("SecondaryShootDelay")) {
        this.secondaryShootDelay = Integer.parseInt(split[1]);
      } else if (split[0].equals("SecondaryNumBullets")) {
        this.secondaryNumBullets = Integer.parseInt(split[1]);
      } else if (split[0].equals("LoadSecondaryIntoGun")) {
        this.numSecAmmoItems = Integer.parseInt(split[1]);
      } else if (split[0].equals("SecondaryFireMode")) {
        this.secondaryFireMode = EnumFireMode.getFireMode(split[1]);
      } else if (split[0].equals("SecondaryShootSound")) {
        this.secondaryShootSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("SecondaryReloadSound")) {
        this.secondaryReloadSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("ModeSwitchSound")) {
        this.toggleSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "guns", split[1]);
      } else if (split[0].equals("MeleeDamageMultiplier")) {
        this.meleeDamageMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("DamageMultiplier")) {
        this.damageMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("SpreadMultiplier")) {
        this.spreadMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("RecoilMultiplier")) {
        this.recoilMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("BulletSpeedMultiplier")) {
        this.bulletSpeedMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("ReloadTimeMultiplier")) {
        this.reloadTimeMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("MovementSpeedMultiplier")) {
        this.moveSpeedMultiplier = Float.parseFloat(split[1]);
      } else if (split[0].equals("ZoomLevel")) {
        this.zoomLevel = Float.parseFloat(split[1]);
      } else if (split[0].equals("FOVZoomLevel")) {
        this.FOVZoomLevel = Float.parseFloat(split[1]);
      } else if (split[0].equals("ZoomOverlay")) {
        this.hasScopeOverlay = true;
        if (split[1].equals("None")) {
          this.hasScopeOverlay = false;
        } else {
          this.zoomOverlay = split[1];
        } 
      } else if (split[0].equals("HasNightVision")) {
        this.hasNightVision = Boolean.parseBoolean(split[1].toLowerCase());
      } 
    } catch (Exception e) {
      System.out.println("Reading attachment file failed.");
      if (FlansMod.printStackTrace)
        e.printStackTrace(); 
    } 
  }
  
  public void reloadModel() {
    this.model = (ModelAttachment)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelAttachment.class);
  }
  
  public static AttachmentType getFromNBT(NBTTagCompound tags) {
    ItemStack stack = ItemStack.func_77949_a(tags);
    if (stack != null && stack.func_77973_b() instanceof ItemAttachment)
      return ((ItemAttachment)stack.func_77973_b()).type; 
    return null;
  }
  
  public float getZoomFactor() {
    return this.zoomLevel;
  }
  
  public boolean hasZoomOverlay() {
    return this.hasScopeOverlay;
  }
  
  public String getZoomOverlay() {
    return this.zoomOverlay;
  }
  
  public float getFOVFactor() {
    return this.FOVZoomLevel;
  }
  
  public static AttachmentType getAttachment(String s) {
    for (AttachmentType attachment : attachments) {
      if (attachment.shortName.equals(s))
        return attachment; 
    } 
    return null;
  }
  
  public float GetRecommendedScale() {
    return 100.0F;
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBase GetModel() {
    return (ModelBase)this.model;
  }
}
