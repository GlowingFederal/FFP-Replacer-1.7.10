package com.flansmod.common.parts;

import com.flansmod.common.types.EnumType;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.ItemStack;

public class PartType extends InfoType {
  public int category;
  
  public int stackSize;
  
  public float engineSpeed = 1.0F;
  
  public float fuelConsumption = 1.0F;
  
  public int fuel = 0;
  
  public List<EnumType> worksWith = Arrays.asList(new EnumType[] { EnumType.mecha, EnumType.plane, EnumType.vehicle });
  
  public ArrayList<ItemStack> partBoxRecipe = new ArrayList<>();
  
  public boolean useRFPower = false;
  
  public int RFDrawRate = 1;
  
  public static HashMap<EnumType, PartType> defaultEngines = new HashMap<>();
  
  public static List<PartType> parts = new ArrayList<>();
  
  public PartType(TypeFile file) {
    super(file);
    parts.add(this);
  }
  
  public void postRead(TypeFile file) {
    if (this.category == 2 && !this.useRFPower)
      for (EnumType type : this.worksWith) {
        if (defaultEngines.containsKey(type)) {
          PartType possiblyInferiorEngine = defaultEngines.get(type);
          if (isInferiorEngine(possiblyInferiorEngine))
            defaultEngines.put(type, this); 
          continue;
        } 
        defaultEngines.put(type, this);
      }  
  }
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (split[0].equals("Category")) {
        this.category = getCategory(split[1]);
      } else if (split[0].equals("StackSize")) {
        this.stackSize = Integer.parseInt(split[1]);
      } else if (split[0].equals("EngineSpeed")) {
        this.engineSpeed = Float.parseFloat(split[1]);
      } else if (split[0].equals("FuelConsumption")) {
        this.fuelConsumption = Float.parseFloat(split[1]);
      } else if (split[0].equals("Fuel")) {
        this.fuel = Integer.parseInt(split[1]);
      } else if (split[0].equals("PartBoxRecipe")) {
        ItemStack[] stacks = new ItemStack[(split.length - 2) / 2];
        for (int i = 0; i < (split.length - 2) / 2; i++) {
          int amount = Integer.parseInt(split[2 * i + 2]);
          boolean damaged = split[2 * i + 3].contains(".");
          String itemName = damaged ? split[2 * i + 3].split("\\.")[0] : split[2 * i + 3];
          int damage = damaged ? Integer.parseInt(split[2 * i + 3].split("\\.")[1]) : 0;
          stacks[i] = getRecipeElement(itemName, amount, damage, this.shortName);
        } 
        this.partBoxRecipe.addAll(Arrays.asList(stacks));
      } else if (split[0].equals("WorksWith")) {
        this.worksWith = new ArrayList<>();
        for (int i = 0; i < split.length - 1; i++)
          this.worksWith.add(EnumType.get(split[i + 1])); 
      } else if (split[0].equals("UseRF") || split[0].equals("UseRFPower")) {
        this.useRFPower = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("RFDrawRate")) {
        this.RFDrawRate = Integer.parseInt(split[1]);
      } 
    } catch (Exception e) {
      System.out.println("Reading part file failed.");
      e.printStackTrace();
    } 
  }
  
  public boolean isInferiorEngine(PartType quitePossiblyAnInferiorEngine) {
    return (this.engineSpeed > quitePossiblyAnInferiorEngine.engineSpeed);
  }
  
  public static PartType getPart(String s) {
    for (PartType part : parts) {
      if (part.shortName.equals(s))
        return part; 
    } 
    return null;
  }
  
  private int getCategory(String s) {
    if (s.equals("Cockpit"))
      return 0; 
    if (s.equals("Wing"))
      return 1; 
    if (s.equals("Engine"))
      return 2; 
    if (s.equals("Propeller"))
      return 3; 
    if (s.equals("Bay"))
      return 4; 
    if (s.equals("Tail"))
      return 5; 
    if (s.equals("Wheel"))
      return 6; 
    if (s.equals("Chassis"))
      return 7; 
    if (s.equals("Turret"))
      return 8; 
    if (s.equals("Fuel"))
      return 9; 
    if (s.equals("Misc"))
      return 10; 
    return 10;
  }
  
  protected void preRead(TypeFile file) {}
  
  public float GetRecommendedScale() {
    return 0.0F;
  }
  
  public ModelBase GetModel() {
    return null;
  }
}
