package com.flansmod.common.driveables.mechas;

import com.flansmod.common.guns.ItemGun;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class SlotMecha extends Slot {
  private EnumMechaSlotType slotType;
  
  public SlotMecha(IInventory inv, EnumMechaSlotType e, int x, int y) {
    super(inv, e.ordinal(), x, y);
    this.slotType = e;
  }
  
  public boolean func_75214_a(ItemStack stack) {
    if (stack == null || stack.func_77973_b() == null)
      return true; 
    EnumMechaItemType itemType = null;
    Item item = stack.func_77973_b();
    if (item instanceof ItemGun && ((ItemGun)item).type.usableByMechas) {
      itemType = EnumMechaItemType.tool;
    } else if (item instanceof ItemMechaAddon) {
      itemType = ((ItemMechaAddon)item).type.type;
    } else {
      return false;
    } 
    return this.slotType.accepts(itemType);
  }
  
  public void func_75215_d(ItemStack stack) {
    if (!func_75214_a(stack))
      return; 
    this.field_75224_c.func_70299_a(this.slotType.ordinal(), stack);
    func_75218_e();
  }
}
