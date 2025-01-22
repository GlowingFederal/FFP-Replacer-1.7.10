package com.flansmod.common.driveables.mechas;

import com.flansmod.client.model.ModelMechaTool;
import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import net.minecraft.client.model.ModelBase;

public class MechaItemType extends InfoType {
  public static ArrayList<MechaItemType> types = new ArrayList<>();
  
  public EnumMechaItemType type;
  
  public EnumMechaToolType function = EnumMechaToolType.sword;
  
  public float speed = 1.0F;
  
  public float toolHardness = 1.0F;
  
  public float reach = 1.0F;
  
  public boolean floater = false;
  
  public float speedMultiplier = 1.0F;
  
  public float damageResistance = 0.0F;
  
  public String soundEffect = "";
  
  public String detectSound = "";
  
  public float soundTime = 0.0F;
  
  public int energyShield = 0;
  
  public int lightLevel = 0;
  
  public boolean stopMechaFallDamage = false;
  
  public boolean forceBlockFallDamage = false;
  
  public boolean vacuumItems = false;
  
  public boolean refineIron = false;
  
  public boolean autoCoal = false;
  
  public boolean autoRepair = false;
  
  public boolean rocketPack = false;
  
  public boolean diamondDetect = false;
  
  public boolean infiniteAmmo = false;
  
  public boolean forceDark = false;
  
  public boolean wasteCompact = false;
  
  public boolean flameBurst = false;
  
  public float fortuneDiamond = 1.0F, fortuneRedstone = 1.0F, fortuneCoal = 1.0F, fortuneEmerald = 1.0F, fortuneIron = 1.0F;
  
  public float rocketPower = 1.0F;
  
  @SideOnly(Side.CLIENT)
  public ModelMechaTool model;
  
  public MechaItemType(TypeFile file) {
    super(file);
  }
  
  protected void preRead(TypeFile file) {}
  
  protected void postRead(TypeFile file) {}
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model"))
        this.model = (ModelMechaTool)FlansMod.proxy.loadModel(split[1], this.shortName, ModelMechaTool.class); 
      if (split[0].equals("Texture"))
        this.texture = split[1]; 
      if (split[0].equals("Type"))
        this.type = EnumMechaItemType.getToolType(split[1]); 
      if (split[0].equals("ToolType"))
        this.function = EnumMechaToolType.getToolType(split[1]); 
      if (split[0].equals("Speed"))
        this.speed = Float.parseFloat(split[1]); 
      if (split[0].equals("ToolHardness"))
        this.toolHardness = Float.parseFloat(split[1]); 
      if (split[0].equals("Reach"))
        this.reach = Float.parseFloat(split[1]); 
      if (split[0].equals("AutoFuel"))
        this.autoCoal = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("Armour"))
        this.damageResistance = Float.parseFloat(split[1]); 
      if (split[0].equals("CoalMultiplier"))
        this.fortuneCoal = Float.parseFloat(split[1]); 
      if (split[0].equals("DetectSound"))
        this.detectSound = split[1]; 
      if (split[0].equals("DiamondDetect"))
        this.diamondDetect = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("DiamondMultiplier"))
        this.fortuneDiamond = Float.parseFloat(split[1]); 
      if (split[0].equals("EmeraldMultiplier"))
        this.fortuneEmerald = Float.parseFloat(split[1]); 
      if (split[0].equals("FlameBurst"))
        this.flameBurst = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("Floatation"))
        this.floater = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("ForceBlockFallDamage"))
        this.forceBlockFallDamage = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("ForceDark"))
        this.forceDark = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("InfiniteAmmo"))
        this.infiniteAmmo = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("IronMultiplier"))
        this.fortuneIron = Float.parseFloat(split[1]); 
      if (split[0].equals("IronRefine"))
        this.refineIron = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("ItemVacuum"))
        this.vacuumItems = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("LightLevel"))
        this.lightLevel = Integer.parseInt(split[1]); 
      if (split[0].equals("Nanorepair"))
        this.autoRepair = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("RedstoneMultiplier"))
        this.fortuneRedstone = Float.parseFloat(split[1]); 
      if (split[0].equals("RocketPack"))
        this.rocketPack = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("RocketPower"))
        this.rocketPower = Float.parseFloat(split[1]); 
      if (split[0].equals("SoundEffect"))
        this.soundEffect = split[1]; 
      if (split[0].equals("SoundTime"))
        this.soundTime = Float.parseFloat(split[1]); 
      if (split[0].equals("SpeedMultiplier"))
        this.speedMultiplier = Float.parseFloat(split[1]); 
      if (split[0].equals("StopMechaFallDamage"))
        this.stopMechaFallDamage = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("WasteCompact"))
        this.wasteCompact = Boolean.parseBoolean(split[1].toLowerCase()); 
    } catch (Exception exception) {}
  }
  
  public static MechaItemType getTool(String find) {
    for (MechaItemType type : types) {
      if (type.shortName.equals(find))
        return type; 
    } 
    return null;
  }
  
  public void reloadModel() {
    if (this.modelString != null)
      this.model = (ModelMechaTool)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelMechaTool.class); 
  }
  
  public float GetRecommendedScale() {
    return 0.0F;
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBase GetModel() {
    return null;
  }
}
