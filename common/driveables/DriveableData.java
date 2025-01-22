package com.flansmod.common.driveables;

import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import java.util.HashMap;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class DriveableData implements IInventory {
  public String type;
  
  public int numGuns;
  
  public int numBombs;
  
  public int numMissiles;
  
  public int numCargo;
  
  public ItemStack[] ammo;
  
  public ItemStack[] bombs;
  
  public ItemStack[] missiles;
  
  public ItemStack[] cargo;
  
  public PartType engine;
  
  public ItemStack fuel;
  
  public float fuelInTank;
  
  public float depth;
  
  public int totalCrew = 1;
  
  public int notFlooding = 1;
  
  public int notFloodingMax = 1;
  
  public int maximumCrew = 1;
  
  public float fakeReloadShell;
  
  public float fakeReloadMissile;
  
  public int overheat = 0;
  
  public int overheatSuffer = 0;
  
  public int sinkingTimer = 0;
  
  public int sinkLimit = 400;
  
  public int repairingTimer = 0;
  
  public int repairLimit = 40;
  
  public HashMap<EnumDriveablePart, DriveablePart> parts;
  
  public boolean inventoryChanged = false;
  
  public String puppy;
  
  public int morale = 1;
  
  public int panicTimer = 0;
  
  public int landBrake = 0;
  
  public int paintjobID;
  
  public int thermalTimer = 0;
  
  public int scopeTimer = 0;
  
  public String seatBelt = "null";
  
  public int WarpLimit = 1;
  
  public boolean emergencyMode = false;
  
  public int carrierTip = 0;
  
  public int catapult = 0;
  
  public DriveableData(NBTTagCompound tags, int paintjobID) {
    this(tags);
    this.paintjobID = paintjobID;
  }
  
  public DriveableData(NBTTagCompound tags) {
    this.parts = new HashMap<>();
    readFromNBT(tags);
  }
  
  public void readFromNBT(NBTTagCompound tag) {
    if (tag == null)
      return; 
    if (!tag.func_74764_b("Type"))
      return; 
    this.type = tag.func_74779_i("Type");
    DriveableType dType = DriveableType.getDriveable(this.type);
    this.numBombs = dType.numBombSlots;
    this.numCargo = dType.numCargoSlots;
    this.numMissiles = dType.numMissileSlots;
    this.numGuns = dType.ammoSlots();
    this.engine = PartType.getPart(tag.func_74779_i("Engine"));
    this.paintjobID = tag.func_74762_e("Paint");
    this.ammo = new ItemStack[this.numGuns];
    this.bombs = new ItemStack[this.numBombs];
    this.missiles = new ItemStack[this.numMissiles];
    this.cargo = new ItemStack[this.numCargo];
    int i;
    for (i = 0; i < this.numGuns; i++)
      this.ammo[i] = ItemStack.func_77949_a(tag.func_74775_l("Ammo " + i)); 
    for (i = 0; i < this.numBombs; i++)
      this.bombs[i] = ItemStack.func_77949_a(tag.func_74775_l("Bombs " + i)); 
    for (i = 0; i < this.numMissiles; i++)
      this.missiles[i] = ItemStack.func_77949_a(tag.func_74775_l("Missiles " + i)); 
    for (i = 0; i < this.numCargo; i++)
      this.cargo[i] = ItemStack.func_77949_a(tag.func_74775_l("Cargo " + i)); 
    this.fuel = ItemStack.func_77949_a(tag.func_74775_l("Fuel"));
    this.fuelInTank = tag.func_74762_e("FuelInTank");
    for (EnumDriveablePart part : EnumDriveablePart.values()) {
      this.parts.put(part, new DriveablePart(part, dType.health.get(part)));
      this.parts.put(part, new DriveablePart(part, dType.crew.get(part)));
    } 
    for (DriveablePart part : this.parts.values())
      part.readFromNBT(tag); 
    if (!tag.func_74764_b("seatBelt")) {
      this.seatBelt = "null";
      return;
    } 
    this.seatBelt = tag.func_74779_i("seatBelt");
    this.emergencyMode = tag.func_74767_n("emergencyMode");
    this.seatBelt = tag.func_74779_i("seatBelt");
    if (!tag.func_74764_b("WarpLimiterino")) {
      this.WarpLimit = dType.numPassengers;
    } else {
      this.WarpLimit = tag.func_74762_e("WarpLimiterino");
    } 
  }
  
  public void writeToNBT(NBTTagCompound tag) {
    tag.func_74778_a("Type", this.type);
    tag.func_74778_a("Engine", this.engine.shortName);
    tag.func_74768_a("Paint", this.paintjobID);
    int i;
    for (i = 0; i < this.ammo.length; i++) {
      if (this.ammo[i] != null)
        tag.func_74782_a("Ammo " + i, (NBTBase)this.ammo[i].func_77955_b(new NBTTagCompound())); 
    } 
    for (i = 0; i < this.bombs.length; i++) {
      if (this.bombs[i] != null)
        tag.func_74782_a("Bombs " + i, (NBTBase)this.bombs[i].func_77955_b(new NBTTagCompound())); 
    } 
    for (i = 0; i < this.missiles.length; i++) {
      if (this.missiles[i] != null)
        tag.func_74782_a("Missiles " + i, (NBTBase)this.missiles[i].func_77955_b(new NBTTagCompound())); 
    } 
    for (i = 0; i < this.cargo.length; i++) {
      if (this.cargo[i] != null)
        tag.func_74782_a("Cargo " + i, (NBTBase)this.cargo[i].func_77955_b(new NBTTagCompound())); 
    } 
    if (this.fuel != null)
      tag.func_74782_a("Fuel", (NBTBase)this.fuel.func_77955_b(new NBTTagCompound())); 
    tag.func_74768_a("FuelInTank", (int)this.fuelInTank);
    for (DriveablePart part : this.parts.values())
      part.writeToNBT(tag); 
    tag.func_74757_a("emergencyMode", this.emergencyMode);
    tag.func_74778_a("seatBelt", this.seatBelt);
    tag.func_74768_a("WarpLimiterino", this.WarpLimit);
  }
  
  public int func_70302_i_() {
    return getFuelSlot() + 1;
  }
  
  public ItemStack func_70301_a(int i) {
    ItemStack[] inv = this.ammo;
    if (i >= this.ammo.length) {
      i -= this.ammo.length;
      inv = this.bombs;
      if (i >= this.bombs.length) {
        i -= this.bombs.length;
        inv = this.missiles;
        if (i >= this.missiles.length) {
          i -= this.missiles.length;
          inv = this.cargo;
          if (i >= this.cargo.length)
            return this.fuel; 
        } 
      } 
    } 
    return inv[i];
  }
  
  public ItemStack func_70298_a(int i, int j) {
    ItemStack[] inv = this.ammo;
    if (i >= this.ammo.length) {
      i -= this.ammo.length;
      inv = this.bombs;
      if (i >= this.bombs.length) {
        i -= this.bombs.length;
        inv = this.missiles;
        if (i >= this.missiles.length) {
          i -= this.missiles.length;
          inv = this.cargo;
          if (i >= this.cargo.length) {
            i -= this.cargo.length;
            inv = new ItemStack[1];
            inv[0] = this.fuel;
            func_70299_a(getFuelSlot(), null);
          } 
        } 
      } 
    } 
    if (inv[i] != null) {
      if ((inv[i]).field_77994_a <= j) {
        ItemStack itemstack = inv[i];
        inv[i] = null;
        return itemstack;
      } 
      ItemStack itemstack1 = inv[i].func_77979_a(j);
      if ((inv[i]).field_77994_a <= 0)
        inv[i] = null; 
      return itemstack1;
    } 
    return null;
  }
  
  public ItemStack func_70304_b(int i) {
    return func_70301_a(i);
  }
  
  public void func_70299_a(int i, ItemStack stack) {
    if (stack != null)
      this.inventoryChanged = true; 
    ItemStack[] inv = this.ammo;
    if (i >= this.ammo.length) {
      i -= this.ammo.length;
      inv = this.bombs;
      if (i >= this.bombs.length) {
        i -= this.bombs.length;
        inv = this.missiles;
        if (i >= this.missiles.length) {
          i -= this.missiles.length;
          inv = this.cargo;
          if (i >= this.cargo.length) {
            this.fuel = stack;
            return;
          } 
        } 
      } 
    } 
    inv[i] = stack;
  }
  
  public String func_145825_b() {
    return "Flan's Secret Data";
  }
  
  public int func_70297_j_() {
    return 64;
  }
  
  public void func_70296_d() {}
  
  public boolean func_70300_a(EntityPlayer player) {
    return true;
  }
  
  public void func_70295_k_() {}
  
  public void func_70305_f() {}
  
  public int getAmmoInventoryStart() {
    return 0;
  }
  
  public int getBombInventoryStart() {
    return this.ammo.length;
  }
  
  public int getMissileInventoryStart() {
    return this.ammo.length + this.bombs.length;
  }
  
  public int getCargoInventoryStart() {
    return this.ammo.length + this.bombs.length + this.missiles.length;
  }
  
  public int getFuelSlot() {
    return this.ammo.length + this.bombs.length + this.missiles.length + this.cargo.length;
  }
  
  public boolean func_145818_k_() {
    return false;
  }
  
  public boolean func_94041_b(int i, ItemStack itemstack) {
    if (i < getBombInventoryStart() && itemstack != null && itemstack.func_77973_b() instanceof com.flansmod.common.guns.ItemBullet)
      return true; 
    if (i >= getBombInventoryStart() && i < getMissileInventoryStart() && itemstack != null && itemstack.func_77973_b() instanceof com.flansmod.common.guns.ItemBullet)
      return true; 
    if (i >= getMissileInventoryStart() && i < getCargoInventoryStart() && itemstack != null && itemstack.func_77973_b() instanceof com.flansmod.common.guns.ItemBullet)
      return true; 
    if (i >= getCargoInventoryStart() && i < getFuelSlot())
      return true; 
    if (i == getFuelSlot() && itemstack != null && itemstack.func_77973_b() instanceof ItemPart && ((ItemPart)itemstack.func_77973_b()).type.category == 9)
      return true; 
    return false;
  }
}
