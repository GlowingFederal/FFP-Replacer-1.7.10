package com.flansmod.common.driveables;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerDriveableInventory extends Container {
  public InventoryPlayer inventory;
  
  public World world;
  
  public EntityDriveable plane;
  
  public int numItems;
  
  public int screen;
  
  public int maxScroll;
  
  public int scroll;
  
  public DriveableType type;
  
  public ContainerDriveableInventory(InventoryPlayer inventoryplayer, World worldy, EntityDriveable entPlane, int i) {
    int slotsDone, startSlot, j, m, k;
    this.inventory = inventoryplayer;
    this.world = worldy;
    this.plane = entPlane;
    this.type = this.plane.getDriveableType();
    this.screen = i;
    this.numItems = 0;
    switch (i) {
      case 0:
        this.numItems = this.plane.driveableData.numGuns;
        this.maxScroll = (this.numItems > 3) ? (this.numItems - 3) : 0;
        break;
      case 1:
        this.numItems = (this.plane.getDriveableType()).numBombSlots;
        this.maxScroll = ((this.numItems + 7) / 8 > 3) ? ((this.numItems + 7) / 8 - 3) : 0;
        break;
      case 2:
        this.numItems = (this.plane.getDriveableType()).numCargoSlots;
        this.maxScroll = ((this.numItems + 7) / 8 > 3) ? ((this.numItems + 7) / 8 - 3) : 0;
        break;
      case 3:
        this.numItems = (this.plane.getDriveableType()).numMissileSlots;
        this.maxScroll = ((this.numItems + 7) / 8 > 3) ? ((this.numItems + 7) / 8 - 3) : 0;
        break;
    } 
    switch (this.screen) {
      case 0:
        slotsDone = 0;
        for (j = 0; j < this.plane.driveableData.numGuns; j++) {
          int yPos = -1000;
          if (slotsDone < 3 + this.scroll && slotsDone >= this.scroll)
            yPos = 25 + 19 * slotsDone; 
          func_75146_a(new SlotDriveableAmmunition(this.plane.driveableData, j, 29, yPos, this.type.filterAmmunition));
          slotsDone++;
        } 
        break;
      case 1:
      case 2:
      case 3:
        startSlot = this.plane.driveableData.getBombInventoryStart();
        if (this.screen == 2)
          startSlot = this.plane.driveableData.getCargoInventoryStart(); 
        if (this.screen == 3)
          startSlot = this.plane.driveableData.getMissileInventoryStart(); 
        m = (this.numItems + 7) / 8;
        for (k = 0; k < m; ) {
          int yPos = -1000;
          if (k < 3 + this.scroll && k >= this.scroll)
            yPos = 25 + 19 * (k - this.scroll); 
          int n = 0;
          for (;; k++) {
            if (n < (((k + this.scroll + 1) * 8 <= this.numItems) ? 8 : (this.numItems % 8))) {
              func_75146_a(new SlotDriveableAmmunition(this.plane.driveableData, startSlot + k * 8 + n, 10 + 18 * n, yPos, this.type.filterAmmunition));
              n++;
              continue;
            } 
          } 
        } 
        break;
    } 
    for (int row = 0; row < 3; row++) {
      for (int n = 0; n < 9; n++)
        func_75146_a(new Slot((IInventory)inventoryplayer, n + row * 9 + 9, 8 + n * 18, 98 + row * 18)); 
    } 
    for (int col = 0; col < 9; col++)
      func_75146_a(new Slot((IInventory)inventoryplayer, col, 8 + col * 18, 156)); 
  }
  
  public void updateScroll(int scrololol) {
    int slotsDone, m, i, row;
    this.scroll = scrololol;
    switch (this.screen) {
      case 0:
        slotsDone = 0;
        for (i = 0; i < this.plane.driveableData.numGuns; i++) {
          int yPos = -1000;
          if (slotsDone < 3 + this.scroll && slotsDone >= this.scroll)
            yPos = 25 + 19 * (slotsDone - this.scroll); 
          ((Slot)this.field_75151_b.get(slotsDone)).field_75221_f = yPos;
          slotsDone++;
        } 
        break;
      case 1:
      case 2:
      case 3:
        m = (this.numItems + 7) / 8;
        for (row = 0; row < m; ) {
          int yPos = -1000;
          if (row < 3 + this.scroll && row >= this.scroll)
            yPos = 25 + 19 * (row - this.scroll); 
          int col = 0;
          for (;; row++) {
            if (col < (((row + 1) * 8 <= this.numItems) ? 8 : (this.numItems % 8))) {
              ((Slot)this.field_75151_b.get(row * 8 + col)).field_75221_f = yPos;
              col++;
              continue;
            } 
          } 
        } 
        break;
    } 
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
      if (slotID >= this.numItems) {
        if (!func_75135_a(slotStack, 0, this.numItems, false))
          return null; 
      } else if (!func_75135_a(slotStack, this.numItems, this.field_75151_b.size(), true)) {
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
  
  protected boolean func_75135_a(ItemStack stack, int startIndex, int endIndex, boolean reverseDirection) {
    boolean flag = false;
    int i = startIndex;
    if (reverseDirection)
      i = endIndex - 1; 
    if (stack.func_77985_e())
      while (stack.field_77994_a > 0 && ((!reverseDirection && i < endIndex) || (reverseDirection && i >= startIndex))) {
        Slot slot = this.field_75151_b.get(i);
        ItemStack itemstack = slot.func_75211_c();
        int maxLimit = Math.min(stack.func_77976_d(), slot.func_75219_a());
        if (itemstack != null && ItemStack.func_77989_b(stack, itemstack)) {
          int j = itemstack.field_77994_a + stack.field_77994_a;
          if (j <= maxLimit) {
            stack.field_77994_a = 0;
            itemstack.field_77994_a = j;
            slot.func_75218_e();
            flag = true;
          } else if (itemstack.field_77994_a < maxLimit) {
            stack.field_77994_a = maxLimit;
            itemstack.field_77994_a = maxLimit;
            slot.func_75218_e();
            flag = true;
          } 
        } 
        if (reverseDirection) {
          i--;
          continue;
        } 
        i++;
      }  
    if (stack.field_77994_a > 0) {
      if (reverseDirection) {
        i = endIndex - 1;
      } else {
        i = startIndex;
      } 
      while ((!reverseDirection && i < endIndex) || (reverseDirection && i >= startIndex)) {
        Slot slot1 = this.field_75151_b.get(i);
        ItemStack itemstack1 = slot1.func_75211_c();
        if (itemstack1 == null && slot1.func_75214_a(stack)) {
          if (stack.field_77994_a <= slot1.func_75219_a()) {
            slot1.func_75215_d(stack.func_77946_l());
            slot1.func_75218_e();
            stack.field_77994_a = 0;
            flag = true;
            break;
          } 
          itemstack1 = stack.func_77946_l();
          stack.field_77994_a -= slot1.func_75219_a();
          itemstack1.field_77994_a = slot1.func_75219_a();
          slot1.func_75215_d(itemstack1);
          slot1.func_75218_e();
          flag = true;
        } 
        if (reverseDirection) {
          i--;
          continue;
        } 
        i++;
      } 
    } 
    return flag;
  }
}
