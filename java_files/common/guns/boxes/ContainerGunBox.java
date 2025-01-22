package com.flansmod.common.guns.boxes;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerGunBox extends Container {
  public InventoryPlayer playerInv;
  
  public World world;
  
  public ContainerGunBox(InventoryPlayer i, World w) {
    this.playerInv = i;
    this.world = w;
    for (int row = 0; row < 3; row++) {
      for (int j = 0; j < 9; j++)
        func_75146_a(new Slot((IInventory)i, j + row * 9 + 9, 57 + j * 18, 151 + row * 18)); 
    } 
    for (int col = 0; col < 9; col++)
      func_75146_a(new Slot((IInventory)i, col, 57 + col * 18, 209)); 
  }
  
  public boolean func_75145_c(EntityPlayer entityplayer) {
    return true;
  }
  
  public ItemStack func_82846_b(EntityPlayer player, int slotID) {
    ItemStack stack = null;
    Slot currentSlot = this.field_75151_b.get(slotID);
    if (currentSlot != null && currentSlot.func_75216_d()) {
      ItemStack slotStack = currentSlot.func_75211_c();
      stack = slotStack.func_77946_l();
      if (slotID != 0) {
        if (!func_75135_a(slotStack, 0, 1, false))
          return null; 
      } else if (!func_75135_a(slotStack, 1, this.field_75151_b.size(), true)) {
        return null;
      } 
      if (slotStack.field_77994_a == 0) {
        currentSlot.func_75215_d(null);
      } else {
        currentSlot.func_75218_e();
      } 
      if (slotStack.field_77994_a == stack.field_77994_a)
        return null; 
      currentSlot.func_82870_a(player, slotStack);
    } 
    return stack;
  }
}
