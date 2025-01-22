package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.paintjob.IPaintableItem;
import com.flansmod.common.paintjob.PaintableType;
import com.flansmod.common.paintjob.Paintjob;
import com.flansmod.common.types.InfoType;
import cpw.mods.fml.common.registry.GameRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.List;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.IIcon;

public class ItemAttachment extends Item implements IPaintableItem {
  public AttachmentType type;
  
  public boolean barisLaser = false;
  
  public boolean barisInfrared = false;
  
  public IIcon[] icons;
  
  public ItemAttachment(AttachmentType t) {
    this.type = t;
    this.type.item = this;
    this.field_77777_bU = t.maxStackSize;
    func_77637_a((CreativeTabs)FlansMod.tabFlanGuns);
    GameRegistry.registerItem(this, this.type.shortName, "flansmod");
    this.barisLaser = t.barisLaser;
    this.barisInfrared = t.barisInfrared;
  }
  
  @SideOnly(Side.CLIENT)
  public int func_82790_a(ItemStack par1ItemStack, int par2) {
    return this.type.colour;
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
  
  public void func_77624_a(ItemStack stack, EntityPlayer player, List<String> lines, boolean b) {
    if (!(this.type.getPaintjob(stack.func_77960_j())).displayName.equals("default"))
      lines.add("§b§o" + (this.type.getPaintjob(stack.func_77960_j())).displayName); 
    if (!this.type.packName.isEmpty())
      lines.add(this.type.packName); 
    if (this.type.description != null)
      Collections.addAll(lines, this.type.description.split("_")); 
  }
  
  public InfoType getInfoType() {
    return (InfoType)this.type;
  }
  
  public PaintableType GetPaintableType() {
    return this.type;
  }
  
  public void func_150895_a(Item item, CreativeTabs tabs, List list) {
    PaintableType type = ((IPaintableItem)item).GetPaintableType();
    if (FlansMod.addAllPaintjobsToCreative) {
      for (Paintjob paintjob : type.paintjobs)
        addPaintjobToList(item, type, paintjob, list); 
    } else {
      addPaintjobToList(item, type, type.defaultPaintjob, list);
    } 
  }
  
  private void addPaintjobToList(Item item, PaintableType type, Paintjob paintjob, List<ItemStack> list) {
    ItemStack paintableStack = new ItemStack(item, 1, paintjob.ID);
    NBTTagCompound tags = new NBTTagCompound();
    paintableStack.func_77982_d(tags);
    list.add(paintableStack);
  }
}
