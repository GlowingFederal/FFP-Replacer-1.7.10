package com.flansmod.common.driveables.mechas;

import com.flansmod.common.parts.ItemPart;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotMechaInventory extends Slot {
  int slotd = 0;
  
  boolean restrictInput = false;
  
  public SlotMechaInventory(IInventory inv, int e, int x, int y, boolean filterInput) {
    super(inv, e, x, y);
    this.slotd = e;
    this.restrictInput = filterInput;
  }
  
  public boolean func_75214_a(ItemStack stack) {
    if (stack == null || stack.func_77973_b() == null)
      return true; 
    if (!this.restrictInput)
      return true; 
    Item item = stack.func_77973_b();
    return ((item instanceof ItemPart && ((ItemPart)item).type.fuel > 0) || item instanceof com.flansmod.common.guns.ItemBullet || item instanceof com.flansmod.common.guns.ItemGrenade);
  }
  
  public void func_75215_d(ItemStack stack) {
    this.field_75224_c.func_70299_a(this.slotd, stack);
    func_75218_e();
  }
}
