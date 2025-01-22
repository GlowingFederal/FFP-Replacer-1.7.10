package com.flansmod.common.teams;

import com.flansmod.common.FlansMod;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.EnumAttachmentType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.types.TypeFile;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.model.ModelBase;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class PlayerClass extends InfoType {
  public static List<PlayerClass> classes = new ArrayList<>();
  
  public List<String[]> startingItemStrings = (List)new ArrayList<>();
  
  public List<ItemStack> startingItems = new ArrayList<>();
  
  public boolean horse = false;
  
  public boolean locked = false;
  
  public int cost = 1;
  
  public ItemStack hat;
  
  public ItemStack chest;
  
  public ItemStack legs;
  
  public ItemStack shoes;
  
  public PlayerClass(TypeFile file) {
    super(file);
    classes.add(this);
  }
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    if (split[0].equals("AddItem"))
      this.startingItemStrings.add(split); 
    if (split[0].equals("SkinOverride"))
      this.texture = split[1]; 
    if (split[0].equals("Hat") || split[0].equals("Helmet")) {
      if (split[1].equals("None"))
        return; 
      for (Item item : FlansMod.armourItems) {
        ArmourType armour = ((ItemTeamArmour)item).type;
        if (armour != null && armour.shortName.equals(split[1]))
          this.hat = new ItemStack(item); 
      } 
    } 
    if (split[0].equals("Chest") || split[0].equals("Top")) {
      if (split[1].equals("None"))
        return; 
      for (Item item : FlansMod.armourItems) {
        ArmourType armour = ((ItemTeamArmour)item).type;
        if (armour != null && armour.shortName.equals(split[1]))
          this.chest = new ItemStack(item); 
      } 
      if (split[0].equals("Unlockable") || split[0].equals("Locked"))
        this.locked = true; 
      if (split[0].equals("Cost") && this.locked == true)
        this.cost = Integer.parseInt(split[1]); 
    } 
    if (split[0].equals("Legs") || split[0].equals("Bottom")) {
      if (split[1].equals("None"))
        return; 
      for (Item item : FlansMod.armourItems) {
        ArmourType armour = ((ItemTeamArmour)item).type;
        if (armour != null && armour.shortName.equals(split[1]))
          this.legs = new ItemStack(item); 
      } 
    } 
    if (split[0].equals("Shoes") || split[0].equals("Boots")) {
      if (split[1].equals("None"))
        return; 
      for (Item item : FlansMod.armourItems) {
        ArmourType armour = ((ItemTeamArmour)item).type;
        if (armour != null && armour.shortName.equals(split[1]))
          this.shoes = new ItemStack(item); 
      } 
    } 
  }
  
  protected void postRead(TypeFile file) {
    onWorldLoad((World)null);
  }
  
  public void onWorldLoad(World world) {
    if (world != null && world.field_72995_K)
      return; 
    try {
      this.startingItems.clear();
      for (String[] split : this.startingItemStrings) {
        Item matchingItem = null;
        int amount = 1;
        int damage = 0;
        String[] itemNames = split[1].split("\\+");
        for (Object object : Item.field_150901_e) {
          Item item = (Item)object;
          if (item != null && item.func_77658_a() != null && (item.func_77658_a().equals(itemNames[0]) || ((item.func_77658_a().split("\\.")).length > 1 && item.func_77658_a().split("\\.")[1].equals(itemNames[0]))))
            matchingItem = item; 
        } 
        for (InfoType type : InfoType.infoTypes) {
          if (type.shortName.equals(itemNames[0]) && type.item != null)
            matchingItem = type.item; 
        } 
        if (matchingItem == null) {
          FlansMod.log("Tried to add " + split[1] + " to player class " + this.shortName + " but the item did not exist");
          return;
        } 
        if (split.length > 2)
          amount = Integer.parseInt(split[2]); 
        if (split.length > 3)
          damage = Integer.parseInt(split[3]); 
        ItemStack stack = new ItemStack(matchingItem, amount, damage);
        if (itemNames.length > 1 && matchingItem instanceof ItemGun) {
          GunType gunType = ((ItemGun)matchingItem).type;
          NBTTagCompound tags = new NBTTagCompound();
          NBTTagCompound attachmentTags = new NBTTagCompound();
          int genericID = 0;
          for (int i = 0; i < itemNames.length - 1; i++) {
            AttachmentType attachment = AttachmentType.getAttachment(itemNames[i + 1]);
            if (attachment != null) {
              String tagName = null;
              switch (attachment.type) {
                case sights:
                  tagName = "scope";
                  break;
                case barrel:
                  tagName = "barrel";
                  break;
                case stock:
                  tagName = "stock";
                  break;
                case grip:
                  tagName = "grip";
                  break;
                case generic:
                  tagName = "generic_" + genericID++;
                  break;
              } 
              NBTTagCompound specificAttachmentTags = new NBTTagCompound();
              (new ItemStack(attachment.item)).func_77955_b(specificAttachmentTags);
              attachmentTags.func_74782_a(tagName, (NBTBase)specificAttachmentTags);
            } 
          } 
          tags.func_74782_a("attachments", (NBTBase)attachmentTags);
          stack.field_77990_d = tags;
        } 
        this.startingItems.add(stack);
      } 
    } catch (Exception e) {
      System.out.println("Interpreting player class file failed.");
      e.printStackTrace();
    } 
  }
  
  public static PlayerClass getClass(String s) {
    for (PlayerClass playerClass : classes) {
      if (playerClass.shortName.equals(s))
        return playerClass; 
    } 
    return null;
  }
  
  protected void preRead(TypeFile file) {}
  
  public float GetRecommendedScale() {
    return 0.0F;
  }
  
  public ModelBase GetModel() {
    return null;
  }
}
