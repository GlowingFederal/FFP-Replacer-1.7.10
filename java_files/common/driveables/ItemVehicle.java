package com.flansmod.common.driveables;

import com.flansmod.common.FlansMod;
import com.flansmod.common.paintjob.IPaintableItem;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.types.EnumType;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import net.minecraft.block.Block;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemMapBase;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompressedStreamTools;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemVehicle extends ItemMapBase implements IPaintableItem {
  public VehicleType type;
  
  public IIcon[] icons;
  
  public ItemVehicle(VehicleType type1) {
    this.field_77777_bU = 1;
    this.type = type1;
    this.type.item = (Item)this;
    func_77637_a((CreativeTabs)FlansMod.tabFlanDriveables);
    GameRegistry.registerItem((Item)this, this.type.shortName, "flansmod");
  }
  
  public boolean func_77651_p() {
    return true;
  }
  
  private NBTTagCompound getTagCompound(ItemStack stack, World world) {
    if (stack.field_77990_d == null) {
      if (!world.field_72995_K)
        stack.field_77990_d = getOldTagCompound(stack, world); 
      if (stack.field_77990_d == null) {
        stack.field_77990_d = new NBTTagCompound();
        stack.field_77990_d.func_74778_a("Type", this.type.shortName);
        stack.field_77990_d.func_74778_a("Engine", ((PartType)PartType.defaultEngines.get(EnumType.vehicle)).shortName);
      } 
    } 
    return stack.field_77990_d;
  }
  
  private NBTTagCompound getOldTagCompound(ItemStack stack, World world) {
    try {
      File file1 = world.func_72860_G().func_75758_b("vehicle_" + stack.func_77960_j());
      FileInputStream fileinputstream = new FileInputStream(file1);
      NBTTagCompound tags = CompressedStreamTools.func_74796_a(fileinputstream).func_74775_l("data");
      for (EnumDriveablePart part : EnumDriveablePart.values()) {
        tags.func_74768_a(part.getShortName() + "_Health", (this.type.health.get(part) == null) ? 0 : ((CollisionBox)this.type.health.get(part)).health);
        tags.func_74768_a(part.getShortName() + "_Crew", (this.type.crew.get(part) == null) ? 0 : ((CollisionBox)this.type.crew.get(part)).crew);
        tags.func_74757_a(part.getShortName() + "_Fire", false);
      } 
      fileinputstream.close();
      return tags;
    } catch (IOException e) {
      FlansMod.log("Failed to read old vehicle file");
      e.printStackTrace();
      return null;
    } 
  }
  
  public ItemStack func_77659_a(ItemStack itemstack, World world, EntityPlayer entityplayer) {
    float cosYaw = MathHelper.func_76134_b(-entityplayer.field_70177_z * 0.01745329F - 3.141593F);
    float sinYaw = MathHelper.func_76126_a(-entityplayer.field_70177_z * 0.01745329F - 3.141593F);
    float cosPitch = -MathHelper.func_76134_b(-entityplayer.field_70125_A * 0.01745329F);
    float sinPitch = MathHelper.func_76126_a(-entityplayer.field_70125_A * 0.01745329F);
    double length = 5.0D;
    Vec3 posVec = Vec3.func_72443_a(entityplayer.field_70165_t, entityplayer.field_70163_u + 1.62D - entityplayer.field_70129_M, entityplayer.field_70161_v);
    Vec3 lookVec = posVec.func_72441_c((sinYaw * cosPitch) * length, sinPitch * length, (cosYaw * cosPitch) * length);
    MovingObjectPosition movingobjectposition = world.func_72901_a(posVec, lookVec, this.type.placeableOnWater);
    if (movingobjectposition == null)
      return itemstack; 
    if (movingobjectposition.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
      int i = movingobjectposition.field_72311_b;
      int j = movingobjectposition.field_72312_c;
      int k = movingobjectposition.field_72309_d;
      Block block = world.func_147439_a(i, j, k);
      if (this.type.placeableOnLand || block instanceof net.minecraft.block.BlockLiquid) {
        if (!world.field_72995_K)
          world.func_72838_d(new EntityVehicle(world, i + 0.5D, j + 2.5D, k + 0.5D, entityplayer, this.type, getData(itemstack, world))); 
        if (!entityplayer.field_71075_bZ.field_75098_d)
          itemstack.field_77994_a--; 
      } 
      if (!this.type.placeableOnLand && this.type.placeableOnSponge && block instanceof net.minecraft.block.BlockSponge) {
        if (!world.field_72995_K)
          world.func_72838_d(new EntityVehicle(world, i + 0.5D, j + 2.5D, k + 0.5D, entityplayer, this.type, getData(itemstack, world))); 
        if (!entityplayer.field_71075_bZ.field_75098_d)
          itemstack.field_77994_a--; 
      } 
      if (!this.type.placeableOnLand && this.type.placeableOnPumpkin && block instanceof net.minecraft.block.BlockPumpkin) {
        if (!world.field_72995_K)
          world.func_72838_d(new EntityVehicle(world, i + 0.5D, j + 2.5D, k + 0.5D, entityplayer, this.type, getData(itemstack, world))); 
        if (!entityplayer.field_71075_bZ.field_75098_d)
          itemstack.field_77994_a--; 
      } 
    } 
    return itemstack;
  }
  
  public Entity spawnVehicle(World world, double x, double y, double z, ItemStack stack) {
    Entity entity = new EntityVehicle(world, x, y, z, this.type, getData(stack, world));
    if (!world.field_72995_K)
      world.func_72838_d(entity); 
    return entity;
  }
  
  public Entity spawnVehicleAngled(World world, double x, double y, double z, float yaw, ItemStack stack) {
    Entity entity = new EntityVehicle(world, x, y, z, yaw, this.type, getData(stack, world));
    if (!world.field_72995_K)
      world.func_72838_d(entity); 
    return entity;
  }
  
  public DriveableData getData(ItemStack itemstack, World world) {
    return new DriveableData(getTagCompound(itemstack, world), itemstack.func_77960_j());
  }
  
  @SideOnly(Side.CLIENT)
  public int func_82790_a(ItemStack par1ItemStack, int par2) {
    return this.type.colour;
  }
  
  public void func_77624_a(ItemStack stack, EntityPlayer player, List<String> lines, boolean advancedTooltips) {
    if (!(this.type.getPaintjob(stack.func_77960_j())).displayName.equals("default"))
      lines.add("§b§o" + (this.type.getPaintjob(stack.func_77960_j())).displayName); 
    if (!this.type.packName.isEmpty())
      lines.add("§o" + this.type.packName); 
    if (this.type.description != null)
      Collections.addAll(lines, this.type.description.split("_")); 
    lines.add("");
    NBTTagCompound tags = getTagCompound(stack, player.field_70170_p);
    PartType engine = PartType.getPart(tags.func_74779_i("Engine"));
    if (engine != null)
      lines.add("§9Engine§7: " + engine.name); 
    if (this.type.transport) {
      lines.add("§2Can Disembark Infantry");
      lines.add("§6Available Warps: " + (getData(stack, player.field_70170_p)).WarpLimit + " / " + this.type.numPassengers + " seats");
    } 
    if (this.type.weightLimit != 5000)
      lines.add("§6Carrier aircraft weight limit: " + this.type.weightLimit + "kg"); 
    if (this.type.epicShip)
      lines.add("§2Uses A.dvanced S.hip S.ystem TM"); 
  }
  
  @SideOnly(Side.CLIENT)
  public void func_94581_a(IIconRegister icon) {
    this.icons = new IIcon[this.type.paintjobs.size()];
    this.field_77791_bV = icon.func_94245_a("FlansMod:" + this.type.iconPath);
    for (int i = 0; i < this.type.paintjobs.size(); i++)
      this.icons[i] = icon.func_94245_a("FlansMod:" + ((Paintjob)this.type.paintjobs.get(i)).iconName); 
  }
  
  @SideOnly(Side.CLIENT)
  public IIcon func_77650_f(ItemStack stack) {
    return this.icons[stack.func_77960_j()];
  }
  
  public void func_150895_a(Item item, CreativeTabs tabs, List<ItemStack> list) {
    ItemStack planeStack = new ItemStack(item, 1, 0);
    NBTTagCompound tags = new NBTTagCompound();
    tags.func_74778_a("Type", this.type.shortName);
    if (PartType.defaultEngines.containsKey(EnumType.vehicle))
      tags.func_74778_a("Engine", ((PartType)PartType.defaultEngines.get(EnumType.vehicle)).shortName); 
    for (EnumDriveablePart part : EnumDriveablePart.values()) {
      tags.func_74768_a(part.getShortName() + "_Health", (this.type.health.get(part) == null) ? 0 : ((CollisionBox)this.type.health.get(part)).health);
      tags.func_74768_a(part.getShortName() + "_Crew", (this.type.crew.get(part) == null) ? 0 : ((CollisionBox)this.type.crew.get(part)).crew);
      tags.func_74757_a(part.getShortName() + "_Fire", false);
    } 
    planeStack.field_77990_d = tags;
    list.add(planeStack);
  }
  
  public InfoType getInfoType() {
    return (InfoType)this.type;
  }
  
  public PaintableType GetPaintableType() {
    return this.type;
  }
}
