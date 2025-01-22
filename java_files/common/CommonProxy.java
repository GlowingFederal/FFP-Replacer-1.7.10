package com.flansmod.common;

import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.driveables.CollisionBox;
import com.flansmod.common.driveables.ContainerDriveableInventory;
import com.flansmod.common.driveables.ContainerDriveableMenu;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.mechas.ContainerMechaInventory;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.guns.ContainerGunModTable;
import com.flansmod.common.guns.boxes.ContainerGunBox;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketBreakSound;
import com.flansmod.common.paintjob.ContainerPaintjobTable;
import com.flansmod.common.paintjob.TileEntityPaintjobTable;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.teams.ArmourBoxType;
import com.flansmod.common.types.EnumType;
import com.flansmod.common.types.InfoType;
import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;
import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;

public class CommonProxy {
  protected static Pattern zipJar = Pattern.compile("(.+).(zip|jar)$");
  
  public List<File> getContentList(Method method, ClassLoader classloader) {
    List<File> contentPacks = new ArrayList<>();
    for (File file : FlansMod.flanDir.listFiles()) {
      if (file.isDirectory() || zipJar.matcher(file.getName()).matches()) {
        FlansMod.log("Loaded content pack : " + file.getName());
        contentPacks.add(file);
      } 
    } 
    FlansMod.log("Loaded content pack list server side.");
    return contentPacks;
  }
  
  public void load() {}
  
  public void forceReload() {}
  
  public void registerRenderers() {}
  
  public void doTutorialStuff(EntityPlayer player, EntityDriveable entityType) {}
  
  public void changeControlMode(EntityPlayer player) {}
  
  public boolean mouseControlEnabled() {
    return false;
  }
  
  public void openDriveableMenu(EntityPlayer player, World world, EntityDriveable driveable) {}
  
  public <T> T loadModel(String s, String shortName, Class<T> typeClass) {
    return null;
  }
  
  public void loadSound(String contentPack, String type, String sound) {}
  
  public boolean isThePlayer(EntityPlayer player) {
    return false;
  }
  
  public EntityPlayer getThePlayer() {
    return null;
  }
  
  public boolean isOnSameTeamClientPlayer(EntityLivingBase entity) {
    return false;
  }
  
  public void buyGun(GunBoxType type, InfoType gun) {}
  
  public void buyAmmo(GunBoxType box, int ammo, int type) {}
  
  public Object getClientGui(int ID, EntityPlayer player, World world, int x, int y, int z) {
    return null;
  }
  
  public HashMap<EntityLivingBase, GunAnimations> getAnimations(boolean left) {
    if (left)
      return FlansMod.gunAnimationsLeft; 
    return FlansMod.gunAnimationsRight;
  }
  
  public Container getServerGui(int ID, EntityPlayer player, World world, int x, int y, int z) {
    switch (ID) {
      case 0:
        return null;
      case 1:
        return null;
      case 2:
        return (Container)new ContainerGunModTable(player.field_71071_by, world);
      case 3:
        return (Container)new ContainerDriveableMenu(player.field_71071_by, world);
      case 4:
        return (Container)new ContainerDriveableMenu(player.field_71071_by, world, true, ((EntitySeat)player.field_70154_o).driveable);
      case 5:
        return (Container)new ContainerGunBox(player.field_71071_by, world);
      case 6:
        return (Container)new ContainerDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 0);
      case 7:
        return (Container)new ContainerDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 1);
      case 8:
        return (Container)new ContainerDriveableMenu(player.field_71071_by, world, true, ((EntitySeat)player.field_70154_o).driveable);
      case 9:
        return (Container)new ContainerDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 2);
      case 10:
        return (Container)new ContainerMechaInventory(player.field_71071_by, world, (EntityMecha)((EntitySeat)player.field_70154_o).driveable);
      case 11:
        return null;
      case 12:
        return (Container)new ContainerDriveableInventory(player.field_71071_by, world, ((EntitySeat)player.field_70154_o).driveable, 3);
      case 13:
        return (Container)new ContainerPaintjobTable(player.field_71071_by, world, (TileEntityPaintjobTable)world.func_147438_o(x, y, z));
    } 
    return null;
  }
  
  public void playBlockBreakSound(int x, int y, int z, Block blockHit, int dimension) {
    FlansMod.packetHandler.sendToAllAround((PacketBase)new PacketBreakSound(x, y, z, blockHit), x, y, z, 32.0F, dimension);
  }
  
  public void addItem(EntityPlayer player, int id) {
    ItemStack item = new ItemStack(Item.func_150899_d(id), 1, 4);
    player.field_71071_by.func_70441_a(item);
    ArrayList<ItemStack> dirts = new ArrayList<>();
    dirts.add(0, new ItemStack(Item.func_150899_d(3)));
    CraftingInstance crafting = new CraftingInstance((IInventory)player.field_71071_by, dirts, new ItemStack(Item.func_150899_d(id)));
    if (crafting.canCraft())
      crafting.craft(player.field_71071_by.field_70458_d); 
  }
  
  public void craftDriveable(EntityPlayer player, DriveableType type) {
    InventoryPlayer temporaryInventory = new InventoryPlayer(null);
    temporaryInventory.func_70455_b(player.field_71071_by);
    boolean canCraft = true;
    for (ItemStack recipeStack : type.driveableRecipe) {
      int totalAmountFound = 0;
      for (int j = 0; j < player.field_71071_by.func_70302_i_(); j++) {
        ItemStack stackInSlot = player.field_71071_by.func_70301_a(j);
        if (stackInSlot != null && stackInSlot.func_77973_b() == recipeStack.func_77973_b() && stackInSlot.func_77960_j() == recipeStack.func_77960_j()) {
          int amountFound = Math.min(stackInSlot.field_77994_a, recipeStack.field_77994_a - totalAmountFound);
          stackInSlot.field_77994_a -= amountFound;
          if (stackInSlot.field_77994_a <= 0)
            stackInSlot = null; 
          player.field_71071_by.func_70299_a(j, stackInSlot);
          totalAmountFound += amountFound;
          if (totalAmountFound == recipeStack.field_77994_a)
            break; 
        } 
      } 
      if (totalAmountFound < recipeStack.field_77994_a) {
        canCraft = false;
        break;
      } 
    } 
    if (!canCraft) {
      player.field_71071_by.func_70455_b(temporaryInventory);
      return;
    } 
    HashMap<PartType, ItemStack> engines = new HashMap<>();
    for (int n = 0; n < temporaryInventory.func_70302_i_(); n++) {
      ItemStack stackInSlot = temporaryInventory.func_70301_a(n);
      if (stackInSlot != null && stackInSlot.func_77973_b() instanceof ItemPart) {
        PartType partType = ((ItemPart)stackInSlot.func_77973_b()).type;
        if (partType.category == 2 && partType.worksWith.contains(EnumType.getFromObject(type)))
          if (engines.containsKey(partType)) {
            ((ItemStack)engines.get(partType)).field_77994_a += stackInSlot.field_77994_a;
          } else {
            engines.put(partType, stackInSlot);
          }  
      } 
    } 
    float bestEngineSpeed = -1.0F;
    ItemStack bestEngineStack = null;
    for (PartType part : engines.keySet()) {
      if (part.engineSpeed > bestEngineSpeed && ((ItemStack)engines.get(part)).field_77994_a >= type.numEngines()) {
        bestEngineSpeed = part.engineSpeed;
        bestEngineStack = engines.get(part);
      } 
    } 
    if (bestEngineStack == null) {
      player.field_71071_by.func_70455_b(temporaryInventory);
      return;
    } 
    int numEnginesAcquired = 0;
    for (int i = 0; i < player.field_71071_by.func_70302_i_(); i++) {
      ItemStack stackInSlot = player.field_71071_by.func_70301_a(i);
      if (stackInSlot != null && stackInSlot.func_77973_b() == bestEngineStack.func_77973_b()) {
        int amountFound = Math.min(stackInSlot.field_77994_a, type.numEngines() - numEnginesAcquired);
        stackInSlot.field_77994_a -= amountFound;
        if (stackInSlot.field_77994_a <= 0)
          stackInSlot = null; 
        player.field_71071_by.func_70299_a(i, stackInSlot);
        numEnginesAcquired += amountFound;
        if (numEnginesAcquired == type.numEngines())
          break; 
      } 
    } 
    ItemStack driveableStack = new ItemStack(type.item);
    NBTTagCompound tags = new NBTTagCompound();
    tags.func_74778_a("Engine", ((ItemPart)bestEngineStack.func_77973_b()).type.shortName);
    tags.func_74778_a("Type", type.shortName);
    for (EnumDriveablePart part : EnumDriveablePart.values()) {
      tags.func_74768_a(part.getShortName() + "_Health", (type.health.get(part) == null) ? 0 : ((CollisionBox)type.health.get(part)).health);
      tags.func_74768_a(part.getShortName() + "_Crew", (type.crew.get(part) == null) ? 0 : ((CollisionBox)type.crew.get(part)).crew);
      tags.func_74757_a(part.getShortName() + "_Fire", false);
    } 
    driveableStack.field_77990_d = tags;
    if (!player.field_71071_by.func_70441_a(driveableStack))
      player.func_71019_a(driveableStack, false); 
  }
  
  public void repairDriveable(EntityPlayer driver, EntityDriveable driving, DriveablePart part) {
    for (EnumDriveablePart parent : part.type.getParents()) {
      if (!driving.isPartIntact(parent))
        return; 
    } 
    InventoryPlayer temporaryInventory = new InventoryPlayer(null);
    temporaryInventory.func_70455_b(driver.field_71071_by);
    boolean canRepair = true;
    ArrayList<ItemStack> stacksNeeded = driving.getDriveableType().getItemsRequired(part, (driving.getDriveableData()).engine);
    for (ItemStack stackNeeded : stacksNeeded) {
      int totalAmountFound = 0;
      for (int m = 0; m < temporaryInventory.func_70302_i_(); m++) {
        ItemStack stackInSlot = temporaryInventory.func_70301_a(m);
        if (stackInSlot != null && stackInSlot.func_77973_b() == stackNeeded.func_77973_b() && stackInSlot.func_77960_j() == stackNeeded.func_77960_j()) {
          int amountFound = Math.min(stackInSlot.field_77994_a, stackNeeded.field_77994_a - totalAmountFound);
          stackInSlot.field_77994_a -= amountFound;
          if (stackInSlot.field_77994_a <= 0)
            stackInSlot = null; 
          temporaryInventory.func_70299_a(m, stackInSlot);
          totalAmountFound += amountFound;
          if (totalAmountFound == stackNeeded.field_77994_a)
            break; 
        } 
      } 
      if (totalAmountFound < stackNeeded.field_77994_a)
        canRepair = false; 
    } 
    if (canRepair) {
      driver.field_71071_by.func_70455_b(temporaryInventory);
      if (part.type == EnumDriveablePart.ERA || part.type == EnumDriveablePart.ERA2 || part.type == EnumDriveablePart.ERA3 || part.type == EnumDriveablePart.APS || part.type == EnumDriveablePart.ADS) {
        part.health = Math.max(1, part.maxHealth);
      } else {
        part.health = Math.max(1, (int)(1.0F + part.maxHealth / 115.0F));
      } 
      part.onFire = false;
      part.dead = false;
      driving.checkParts();
    } 
  }
  
  public boolean isScreenOpen() {
    return false;
  }
  
  public boolean isKeyDown(int key) {
    return false;
  }
  
  public boolean keyDown(int keycode) {
    return false;
  }
  
  public void buyArmour(String shortName, int piece, ArmourBoxType type) {}
  
  public void spawnParticle(String p_72869_1_, double p_72869_2_, double p_72869_4_, double p_72869_6_, double p_72869_8_, double p_72869_10_, double p_72869_12_) {}
  
  public float getMouseSensitivity() {
    return 0.5F;
  }
}
