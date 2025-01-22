package com.flansmod.common.tools;

import com.flansmod.common.FlansMod;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.HashMap;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class ToolType extends InfoType {
  public static HashMap<String, ToolType> tools = new HashMap<>();
  
  @SideOnly(Side.CLIENT)
  public ModelBase model;
  
  public boolean healPlayers = false;
  
  public boolean healDriveables = false;
  
  public int healAmount = 0;
  
  public int healStrength = 0;
  
  public int toolLife = 0;
  
  public boolean destroyOnEmpty = true;
  
  public ArrayList<ItemStack> rechargeRecipe = new ArrayList<>();
  
  public int EUPerCharge = 0;
  
  public boolean parachute = false;
  
  public boolean remote = false;
  
  public int foodness = 0;
  
  public boolean key = false;
  
  public boolean bandAid = false;
  
  public boolean superBandAid = false;
  
  public boolean surgery = false;
  
  public boolean needle = false;
  
  public boolean transfusion = false;
  
  public String summonItem = null;
  
  public ToolType(TypeFile file) {
    super(file);
  }
  
  protected void postRead(TypeFile file) {
    tools.put(this.shortName, this);
  }
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (FMLCommonHandler.instance().getSide().isClient() && split[0].equals("Model")) {
        this.model = (ModelBase)FlansMod.proxy.loadModel(split[1], this.shortName, ModelBase.class);
      } else if (split[0].equals("Texture")) {
        this.texture = split[1];
      } else if (split[0].equals("Parachute")) {
        this.parachute = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("bandAid")) {
        this.bandAid = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("superBandAid")) {
        this.superBandAid = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("surgery")) {
        this.surgery = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("transfusion")) {
        this.transfusion = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("needle")) {
        this.needle = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("summonItem")) {
        this.summonItem = split[1];
      } else if (split[0].equals("ExplosiveRemote")) {
        this.remote = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("Key")) {
        this.key = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("Heal") || split[0].equals("HealPlayers")) {
        this.healPlayers = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("Repair") || split[0].equals("RepairVehicles")) {
        this.healDriveables = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("HealAmount") || split[0].equals("RepairAmount")) {
        this.healAmount = Integer.parseInt(split[1]);
      } else if (split[0].equals("HealStrength")) {
        this.healStrength = Integer.parseInt(split[1]);
      } else if (split[0].equals("ToolLife") || split[0].equals("ToolUses")) {
        this.toolLife = Integer.parseInt(split[1]);
      } else if (split[0].equals("EUPerCharge")) {
        this.EUPerCharge = Integer.parseInt(split[1]);
      } else if (split[0].equals("RechargeRecipe")) {
        for (int i = 0; i < (split.length - 1) / 2; i++) {
          int amount = Integer.parseInt(split[2 * i + 1]);
          boolean damaged = split[2 * i + 2].contains(".");
          String itemName = damaged ? split[2 * i + 2].split("\\.")[0] : split[2 * i + 2];
          int damage = damaged ? Integer.parseInt(split[2 * i + 2].split("\\.")[1]) : 0;
          this.rechargeRecipe.add(getRecipeElement(itemName, amount, damage, this.shortName));
        } 
      } else if (split[0].equals("DestroyOnEmpty")) {
        this.destroyOnEmpty = Boolean.parseBoolean(split[1].toLowerCase());
      } else if (split[0].equals("Food") || split[0].equals("Foodness")) {
        this.foodness = Integer.parseInt(split[1]);
      } 
    } catch (Exception e) {
      FlansMod.log("Reading file failed : " + this.shortName);
      e.printStackTrace();
    } 
  }
  
  public void addRecipe(Item item) {
    super.addRecipe(item);
    if (this.rechargeRecipe.size() < 1)
      return; 
    this.rechargeRecipe.add(new ItemStack(item, 1, this.toolLife));
    GameRegistry.addShapelessRecipe(new ItemStack(item, 1, 0), this.rechargeRecipe.toArray());
  }
  
  public static ToolType getType(String shortName) {
    return tools.get(shortName);
  }
  
  protected void preRead(TypeFile file) {}
  
  public float GetRecommendedScale() {
    return 0.0F;
  }
  
  @SideOnly(Side.CLIENT)
  public ModelBase GetModel() {
    return null;
  }
}
