package com.flansmod.common.driveables.mechas;

import java.util.HashMap;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class MechaInventory implements IInventory {
  public EntityMecha mecha;
  
  public HashMap<EnumMechaSlotType, ItemStack> stacks;
  
  public MechaInventory(EntityMecha m) {
    this.mecha = m;
    this.stacks = new HashMap<>();
    for (EnumMechaSlotType type : EnumMechaSlotType.values())
      this.stacks.put(type, null); 
  }
  
  public MechaInventory(EntityMecha m, NBTTagCompound tags) {
    this(m);
    readFromNBT(tags);
  }
  
  public void readFromNBT(NBTTagCompound tags) {
    if (tags == null)
      return; 
    for (EnumMechaSlotType type : EnumMechaSlotType.values())
      this.stacks.put(type, ItemStack.func_77949_a(tags.func_74775_l(type.toString()))); 
  }
  
  public NBTTagCompound writeToNBT(NBTTagCompound tags) {
    if (tags == null)
      return null; 
    for (EnumMechaSlotType type : EnumMechaSlotType.values()) {
      if (this.stacks.get(type) != null)
        tags.func_74782_a(type.toString(), (NBTBase)((ItemStack)this.stacks.get(type)).func_77955_b(new NBTTagCompound())); 
    } 
    return tags;
  }
  
  public int func_70302_i_() {
    return (EnumMechaSlotType.values()).length;
  }
  
  public ItemStack func_70301_a(int i) {
    return this.stacks.get(EnumMechaSlotType.values()[i]);
  }
  
  public ItemStack getStackInSlot(EnumMechaSlotType e) {
    return this.stacks.get(e);
  }
  
  public ItemStack func_70298_a(int i, int j) {
    func_70296_d();
    ItemStack slot = func_70301_a(i);
    if (slot == null)
      return null; 
    int numToTake = Math.min(j, slot.field_77994_a);
    ItemStack returnStack = slot.func_77946_l();
    returnStack.field_77994_a = numToTake;
    slot.field_77994_a -= numToTake;
    if (slot.field_77994_a <= 0)
      slot = null; 
    func_70299_a(i, slot);
    return returnStack;
  }
  
  public ItemStack func_70304_b(int i) {
    return func_70301_a(i);
  }
  
  public void func_70299_a(int i, ItemStack itemstack) {
    setInventorySlotContents(EnumMechaSlotType.values()[i], itemstack);
  }
  
  public void setInventorySlotContents(EnumMechaSlotType e, ItemStack itemstack) {
    func_70296_d();
    this.stacks.put(e, itemstack);
  }
  
  public String func_145825_b() {
    return "Mecha";
  }
  
  public boolean func_145818_k_() {
    return true;
  }
  
  public int func_70297_j_() {
    return 64;
  }
  
  public void func_70296_d() {
    if (this.mecha != null)
      this.mecha.couldNotFindFuel = false; 
  }
  
  public boolean func_70300_a(EntityPlayer entityplayer) {
    return (this.mecha != null && entityplayer.func_70032_d((Entity)this.mecha) <= 10.0D);
  }
  
  public void func_70295_k_() {}
  
  public void func_70305_f() {}
  
  public boolean func_94041_b(int i, ItemStack itemstack) {
    Item item = itemstack.func_77973_b();
    if (item == null)
      return true; 
    switch (EnumMechaSlotType.values()[i]) {
      case leftTool:
      case rightTool:
        return (item instanceof com.flansmod.common.guns.ItemGun || item instanceof ItemMechaAddon);
      case leftArm:
      case rightArm:
        return item instanceof com.flansmod.common.guns.ItemBullet;
    } 
    return false;
  }
}
