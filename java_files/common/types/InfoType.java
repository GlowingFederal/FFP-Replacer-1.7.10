package com.flansmod.common.types;

import com.flansmod.common.FlansMod;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.block.material.Material;
import net.minecraft.client.model.ModelBase;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemDye;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public abstract class InfoType {
  public static List<InfoType> infoTypes = new ArrayList<>();
  
  public String contentPack;
  
  public Item item;
  
  public int colour = 16777215;
  
  public String iconPath;
  
  public Object[] recipe;
  
  public String[] recipeLine;
  
  public int recipeOutput = 1;
  
  public boolean shapeless;
  
  public String smeltableFrom = null;
  
  public String name;
  
  public String shortName;
  
  public String texture;
  
  public String LauncherSkin;
  
  public String modelString;
  
  public String description;
  
  public float modelScale = 1.0F;
  
  public boolean canDrop = true;
  
  public final String packName;
  
  public InfoType(TypeFile file) {
    this.contentPack = file.name;
    this.packName = file.pack;
    infoTypes.add(this);
  }
  
  public void read(TypeFile file) {
    preRead(file);
    while (true) {
      String line = null;
      line = file.readLine();
      if (line == null)
        break; 
      if (line.startsWith("//"))
        continue; 
      String[] split = line.split(" ");
      if (split.length < 2)
        continue; 
      read(split, file);
    } 
    postRead(file);
  }
  
  protected abstract void preRead(TypeFile paramTypeFile);
  
  protected abstract void postRead(TypeFile paramTypeFile);
  
  protected void read(String[] split, TypeFile file) {
    try {
      if (split[0].equals("Model"))
        this.modelString = split[1]; 
      if (split[0].equals("ModelScale"))
        this.modelScale = Float.parseFloat(split[1]); 
      if (split[0].equals("Name") && !split[0].equals("afterBurnName")) {
        this.name = split[1];
        for (int i = 0; i < split.length - 2; i++)
          this.name += " " + split[i + 2]; 
      } 
      if (split[0].equals("Description")) {
        this.description = split[1];
        for (int i = 0; i < split.length - 2; i++)
          this.description += " " + split[i + 2]; 
      } 
      if (split[0].equals("ShortName"))
        this.shortName = split[1]; 
      if (split[0].equals("Colour") || split[0].equals("Color"))
        this.colour = (Integer.parseInt(split[1]) << 16) + (Integer.parseInt(split[2]) << 8) + Integer.parseInt(split[3]); 
      if (split[0].equals("Icon"))
        this.iconPath = split[1]; 
      if (split[0].equals("RecipeOutput"))
        this.recipeOutput = Integer.parseInt(split[1]); 
      if (split[0].equals("Recipe")) {
        this.recipe = new Object[split.length + 2];
        for (int i = 0; i < 3; i++) {
          String line = null;
          line = file.readLine();
          if (line != null)
            if (line == null || line.startsWith("//")) {
              i--;
            } else {
              this.recipe[i] = line;
            }  
        } 
        this.recipeLine = split;
        this.shapeless = false;
      } 
      if (split[0].equals("ShapelessRecipe")) {
        this.recipeLine = split;
        this.shapeless = true;
      } 
      if (split[0].equals("SmeltableFrom"))
        this.smeltableFrom = split[1]; 
      if (split[0].equals("CanDrop"))
        this.canDrop = Boolean.parseBoolean(split[1]); 
    } catch (Exception e) {
      FlansMod.log("Reading file failed : " + this.shortName);
      e.printStackTrace();
    } 
  }
  
  public void addRecipe() {
    addRecipe(getItem());
  }
  
  public void addRecipe(Item par1Item) {
    if (this.smeltableFrom != null)
      GameRegistry.addSmelting(getRecipeElement(this.smeltableFrom, 0), new ItemStack(this.item), 0.0F); 
    if (this.recipeLine == null)
      return; 
    try {
      if (!this.shapeless) {
        int rows = 3;
        if (((String)this.recipe[0]).charAt(0) == ' ' && ((String)this.recipe[1]).charAt(0) == ' ' && ((String)this.recipe[2]).charAt(0) == ' ') {
          int j;
          for (j = 0; j < 3; j++)
            this.recipe[j] = ((String)this.recipe[j]).substring(1); 
          if (((String)this.recipe[0]).charAt(0) == ' ' && ((String)this.recipe[1]).charAt(0) == ' ' && ((String)this.recipe[2]).charAt(0) == ' ')
            for (j = 0; j < 3; j++)
              this.recipe[j] = ((String)this.recipe[j]).substring(1);  
        } 
        int last = ((String)this.recipe[0]).length() - 1;
        if (((String)this.recipe[0]).charAt(last) == ' ' && ((String)this.recipe[1]).charAt(last) == ' ' && ((String)this.recipe[2]).charAt(last) == ' ') {
          int j;
          for (j = 0; j < 3; j++)
            this.recipe[j] = ((String)this.recipe[j]).substring(0, last); 
          last--;
          if (((String)this.recipe[0]).charAt(last) == ' ' && ((String)this.recipe[1]).charAt(last) == ' ' && ((String)this.recipe[2]).charAt(last) == ' ')
            for (j = 0; j < 3; j++)
              this.recipe[j] = ((String)this.recipe[j]).substring(0, 0);  
        } 
        if (this.recipe[0].equals(" ") || this.recipe[0].equals("  ") || this.recipe[0].equals("   ")) {
          Object[] newRecipe = new Object[this.recipe.length - 1];
          newRecipe[0] = this.recipe[1];
          newRecipe[1] = this.recipe[2];
          this.recipe = newRecipe;
          rows--;
          if (this.recipe[0].equals(" ") || this.recipe[0].equals("  ") || this.recipe[0].equals("   ")) {
            Object[] newRecipe1 = new Object[this.recipe.length - 1];
            newRecipe1[0] = this.recipe[1];
            this.recipe = newRecipe1;
            rows--;
          } 
        } 
        if (this.recipe[rows - 1].equals(" ") || this.recipe[rows - 1].equals("  ") || this.recipe[rows - 1].equals("   ")) {
          Object[] newRecipe = new Object[this.recipe.length - 1];
          newRecipe[0] = this.recipe[0];
          newRecipe[1] = this.recipe[1];
          this.recipe = newRecipe;
          rows--;
          if (this.recipe[rows - 1].equals(" ") || this.recipe[rows - 1].equals("  ") || this.recipe[rows - 1].equals("   ")) {
            Object[] newRecipe1 = new Object[this.recipe.length - 1];
            newRecipe1[0] = this.recipe[0];
            this.recipe = newRecipe1;
            rows--;
          } 
        } 
        for (int i = 0; i < (this.recipeLine.length - 1) / 2; i++) {
          this.recipe[i * 2 + rows] = Character.valueOf(this.recipeLine[i * 2 + 1].charAt(0));
          if (this.recipeLine[i * 2 + 2].contains(".")) {
            this.recipe[i * 2 + rows + 1] = getRecipeElement(this.recipeLine[i * 2 + 2].split("\\.")[0], Integer.valueOf(this.recipeLine[i * 2 + 2].split("\\.")[1]).intValue());
          } else {
            this.recipe[i * 2 + rows + 1] = getRecipeElement(this.recipeLine[i * 2 + 2], 0);
          } 
        } 
        GameRegistry.addRecipe(new ItemStack(this.item, this.recipeOutput), this.recipe);
      } else {
        this.recipe = new Object[this.recipeLine.length - 1];
        for (int i = 0; i < this.recipeLine.length - 1; i++) {
          if (this.recipeLine[i + 1].contains(".")) {
            this.recipe[i] = getRecipeElement(this.recipeLine[i + 1].split("\\.")[0], Integer.valueOf(this.recipeLine[i + 1].split("\\.")[1]).intValue());
          } else {
            this.recipe[i] = getRecipeElement(this.recipeLine[i + 1], 0);
          } 
        } 
        GameRegistry.addShapelessRecipe(new ItemStack(this.item, this.recipeOutput), this.recipe);
      } 
    } catch (Exception e) {
      FlansMod.log("Failed to add recipe for : " + this.shortName);
      if (FlansMod.printStackTrace)
        e.printStackTrace(); 
    } 
  }
  
  public Item getItem() {
    return this.item;
  }
  
  public static ItemStack getRecipeElement(String s, int damage) {
    return getRecipeElement(s, 1, damage);
  }
  
  public static ItemStack getRecipeElement(String s, int amount, int damage) {
    return getRecipeElement(s, amount, damage, "nothing");
  }
  
  public static ItemStack getRecipeElement(String s, int amount, int damage, String requester) {
    if (s.equals("doorIron"))
      return new ItemStack(Items.field_151139_aw, amount); 
    if (s.equals("doorWood"))
      return new ItemStack(Items.field_151135_aq, amount); 
    if (s.equals("clayItem"))
      return new ItemStack(Items.field_151119_aD, amount); 
    for (Object object : Item.field_150901_e) {
      Item item = (Item)object;
      if (item != null && item.func_77658_a() != null && (item.func_77658_a().equals("item." + s) || item.func_77658_a().equals("tile." + s)))
        return new ItemStack(item, amount, damage); 
    } 
    for (InfoType type : infoTypes) {
      if (type.shortName.equals(s))
        return new ItemStack(type.item, amount, damage); 
    } 
    if (s.equals("gunpowder"))
      return new ItemStack(Items.field_151016_H, amount); 
    if (s.equals("iron"))
      return new ItemStack(Items.field_151042_j, amount); 
    FlansMod.log("Could not find " + s + " when adding recipe for " + requester);
    return null;
  }
  
  protected int getDyeDamageValue(String dyeName) {
    int damage = -1;
    for (int i = 0; i < ItemDye.field_150923_a.length; i++) {
      if (ItemDye.field_150923_a[i].equals(dyeName))
        damage = i; 
    } 
    if (damage == -1)
      FlansMod.log("Failed to find dye colour : " + dyeName + " while adding " + this.contentPack); 
    return damage;
  }
  
  public void reloadModel() {}
  
  public static InfoType getType(String s) {
    for (InfoType type : infoTypes) {
      if (type != null && 
        type.shortName.equals(s))
        return type; 
    } 
    return null;
  }
  
  public void onWorldLoad(World world) {}
  
  public abstract float GetRecommendedScale();
  
  @SideOnly(Side.CLIENT)
  public abstract ModelBase GetModel();
  
  public static InfoType getType(ItemStack itemStack) {
    if (itemStack == null)
      return null; 
    Item item = itemStack.func_77973_b();
    if (item instanceof IFlanItem)
      return ((IFlanItem)item).getInfoType(); 
    return null;
  }
  
  public static PotionEffect getPotionEffect(String[] split) {
    int potionID = Integer.parseInt(split[1]);
    int duration = Integer.parseInt(split[2]);
    int amplifier = Integer.parseInt(split[3]);
    return new PotionEffect(potionID, duration, amplifier, false);
  }
  
  public static Material getMaterial(String mat) {
    return Material.field_151578_c;
  }
}
