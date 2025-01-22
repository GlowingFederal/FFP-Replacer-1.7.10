package com.flansmod.common.guns;

import com.flansmod.common.paintjob.Paintjob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerGunModTable extends Container {
  private InventoryGunModTable inventory;
  
  public InventoryPlayer playerInv;
  
  public World world;
  
  public ContainerGunModTable(InventoryPlayer i, World w) {
    this.playerInv = i;
    this.inventory = new InventoryGunModTable();
    this.world = w;
    SlotGun gunSlot = new SlotGun((IInventory)this.inventory, 0, 184, 37, null);
    func_75146_a(gunSlot);
    for (int k = 0; k < 8; k++)
      func_75146_a(new SlotGun((IInventory)this.inventory, k + 1, 17 + k * 18, 89, gunSlot)); 
    for (int j = 0; j < 8; j++)
      func_75146_a(new SlotGun((IInventory)this.inventory, 9 + j, 17 + j * 18, 115 + j * 18, gunSlot)); 
    for (int row = 0; row < 3; row++) {
      for (int m = 0; m < 9; m++)
        func_75146_a(new Slot((IInventory)this.playerInv, m + row * 9 + 9, 8 + m * 18, 154 + row * 18)); 
    } 
    for (int col = 0; col < 9; col++)
      func_75146_a(new Slot((IInventory)this.playerInv, col, 8 + col * 18, 212)); 
  }
  
  public void func_75134_a(EntityPlayer player) {
    if (this.inventory.func_70301_a(0) != null)
      player.func_71019_a(this.inventory.func_70301_a(0), false); 
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
      if (slotID >= 17)
        return null; 
      if (!func_75135_a(slotStack, 17, this.field_75151_b.size(), true))
        return null; 
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
  
  public void pressButton(boolean paint, boolean left) {}
  
  public void clickPaintjob(int id) {
    ItemStack gunStack = this.inventory.func_70301_a(0);
    if (gunStack != null && gunStack.func_77973_b() instanceof ItemGun) {
      GunType gunType = ((ItemGun)gunStack.func_77973_b()).type;
      clickPaintjob(gunType.getPaintjob(id));
    } 
  }
  
  public void clickPaintjob(Paintjob paintjob) {
    ItemStack gunStack = this.inventory.func_70301_a(0);
    if (gunStack != null && gunStack.func_77973_b() instanceof ItemGun) {
      GunType gunType = ((ItemGun)gunStack.func_77973_b()).type;
      int numDyes = paintjob.dyesNeeded.length;
      if (!this.playerInv.field_70458_d.field_71075_bZ.field_75098_d) {
        int n;
        for (n = 0; n < numDyes; n++) {
          int amountNeeded = (paintjob.dyesNeeded[n]).field_77994_a;
          for (int s = 0; s < this.playerInv.func_70302_i_(); s++) {
            ItemStack stack = this.playerInv.func_70301_a(s);
            if (stack != null && stack.func_77973_b() == Items.field_151100_aR && stack.func_77960_j() == paintjob.dyesNeeded[n].func_77960_j())
              amountNeeded -= stack.field_77994_a; 
          } 
          if (amountNeeded > 0)
            return; 
        } 
        for (n = 0; n < numDyes; n++) {
          int amountNeeded = (paintjob.dyesNeeded[n]).field_77994_a;
          for (int s = 0; s < this.playerInv.func_70302_i_(); s++) {
            if (amountNeeded > 0) {
              ItemStack stack = this.playerInv.func_70301_a(s);
              if (stack != null && stack.func_77973_b() == Items.field_151100_aR && stack.func_77960_j() == paintjob.dyesNeeded[n].func_77960_j()) {
                ItemStack consumed = this.playerInv.func_70298_a(s, amountNeeded);
                amountNeeded -= consumed.field_77994_a;
              } 
            } 
          } 
        } 
      } 
      gunStack.func_77964_b(paintjob.ID);
    } 
  }
}
