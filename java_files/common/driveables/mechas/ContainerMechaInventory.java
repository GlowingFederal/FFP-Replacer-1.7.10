package com.flansmod.common.driveables.mechas;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ContainerMechaInventory extends Container {
  public InventoryPlayer inventory;
  
  public World world;
  
  public EntityMecha mecha;
  
  public int numItems;
  
  public int maxScroll;
  
  public int scroll;
  
  public MechaType type;
  
  public ContainerMechaInventory(InventoryPlayer inv, World w, EntityMecha em) {
    this.inventory = inv;
    this.world = w;
    this.mecha = em;
    this.type = (MechaType)this.mecha.getDriveableType();
    this.numItems = (this.mecha.getDriveableType()).numCargoSlots;
    int numRows = (this.numItems + 7) / 8;
    this.maxScroll = (numRows > 3) ? (numRows - 3) : 0;
    int startSlot = this.mecha.driveableData.getCargoInventoryStart();
    int row;
    for (row = 0; row < numRows; ) {
      int yPos = -1000;
      if (row < 3 + this.scroll && row >= this.scroll)
        yPos = 25 + 19 * (row - this.scroll); 
      int i = 0;
      for (;; row++) {
        if (i < (((row + this.scroll + 1) * 8 <= this.numItems) ? 8 : (this.numItems % 8))) {
          func_75146_a(new SlotMechaInventory((IInventory)this.mecha.driveableData, startSlot + row * 8 + i, 186 + 18 * i, yPos, this.type.restrictInventoryInput));
          i++;
          continue;
        } 
      } 
    } 
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.legs, 84, 128));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.hips, 60, 128));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.leftArm, 36, 80));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.leftTool, 36, 56));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.leftShoulder, 60, 32));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.head, 84, 32));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.feet, 108, 128));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.rightArm, 132, 80));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.rightTool, 132, 56));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.rightShoulder, 108, 32));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.u1, 10, 32));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.u2, 10, 56));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.u3, 10, 80));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.u4, 10, 104));
    func_75146_a(new SlotMecha(this.mecha.inventory, EnumMechaSlotType.u5, 10, 128));
    for (row = 0; row < 3; row++) {
      for (int i = 0; i < 9; i++)
        func_75146_a(new Slot((IInventory)this.inventory, i + row * 9 + 9, 182 + i * 18, 98 + row * 18)); 
    } 
    for (int col = 0; col < 9; col++)
      func_75146_a(new Slot((IInventory)this.inventory, col, 182 + col * 18, 156)); 
  }
  
  public void func_75134_a(EntityPlayer par1EntityPlayer) {
    super.func_75134_a(par1EntityPlayer);
    this.mecha.couldNotFindFuel = false;
  }
  
  public void updateScroll(int scrololol) {
    this.scroll = scrololol;
    int m = (this.numItems + 7) / 8;
    for (int row = 0; row < m; ) {
      int yPos = -1000;
      if (row < 3 + this.scroll && row >= this.scroll)
        yPos = 25 + 19 * (row - this.scroll); 
      int col = 0;
      for (;; row++) {
        if (col < (((row + 1) * 8 < this.numItems) ? 8 : (this.numItems % 8))) {
          ((Slot)this.field_75151_b.get(row * 8 + col)).field_75221_f = yPos;
          col++;
          continue;
        } 
      } 
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
}
