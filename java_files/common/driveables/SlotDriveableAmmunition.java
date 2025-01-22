package com.flansmod.common.driveables;

import com.flansmod.common.FlansMod;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotDriveableAmmunition extends Slot {
  int slotd = 0;
  
  boolean restrictInput = false;
  
  public SlotDriveableAmmunition(IInventory inv, int e, int x, int y, boolean filterInput) {
    super(inv, e, x, y);
    this.slotd = e;
    this.restrictInput = filterInput;
  }
  
  public boolean func_75214_a(ItemStack stack) {
    if (stack == null || stack.func_77973_b() == null)
      return true; 
    Item item = stack.func_77973_b();
    if (item instanceof ItemVehicle || item instanceof ItemPlane || item instanceof com.flansmod.common.driveables.mechas.ItemMecha)
      return false; 
    if (!this.restrictInput)
      return true; 
    FlansMod.log("E %b", new Object[] { Boolean.valueOf((item instanceof com.flansmod.common.guns.ItemBullet || item instanceof com.flansmod.common.guns.ItemGrenade)) });
    return (item instanceof com.flansmod.common.guns.ItemBullet || item instanceof com.flansmod.common.guns.ItemGrenade);
  }
  
  public void func_75215_d(ItemStack stack) {
    if (!func_75214_a(stack))
      return; 
    this.field_75224_c.func_70299_a(this.slotd, stack);
    func_75218_e();
  }
}
