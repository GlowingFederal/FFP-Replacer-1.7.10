package com.flansmod.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;

public class CraftingInstance {
  public IInventory inventory;
  
  public List<ItemStack> requiredStacks;
  
  public List<ItemStack> outputStacks;
  
  public boolean craftingSuccessful;
  
  public CraftingInstance(IInventory i, List<ItemStack> in, List<ItemStack> out) {
    this.inventory = i;
    this.requiredStacks = in;
    this.outputStacks = out;
  }
  
  public CraftingInstance(IInventory i, ArrayList<ItemStack> in, ItemStack out) {
    this(i, in, Arrays.asList(new ItemStack[] { out }));
  }
  
  public boolean canCraft() {
    this.craftingSuccessful = true;
    for (ItemStack check : this.requiredStacks) {
      int numMatchingStuff = 0;
      for (int j = 0; j < this.inventory.func_70302_i_(); j++) {
        ItemStack stack = this.inventory.func_70301_a(j);
        if (stack != null && stack.func_77973_b() == check.func_77973_b() && stack.func_77960_j() == check.func_77960_j())
          numMatchingStuff += stack.field_77994_a; 
      } 
      if (numMatchingStuff < check.field_77994_a)
        this.craftingSuccessful = false; 
    } 
    return this.craftingSuccessful;
  }
  
  public void craft(EntityPlayer player) {
    if (!this.craftingSuccessful)
      return; 
    for (ItemStack remove : this.requiredStacks) {
      int amountLeft = remove.field_77994_a;
      for (int j = 0; j < this.inventory.func_70302_i_(); j++) {
        ItemStack stack = this.inventory.func_70301_a(j);
        if (amountLeft > 0 && stack != null && stack.func_77973_b() == remove.func_77973_b() && stack.func_77960_j() == remove.func_77960_j())
          amountLeft -= (this.inventory.func_70298_a(j, amountLeft)).field_77994_a; 
      } 
    } 
    for (ItemStack stack : this.outputStacks) {
      if (!player.field_71071_by.func_70441_a(stack))
        player.func_71019_a(stack, false); 
    } 
  }
}
