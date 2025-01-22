package com.flansmod.common.guns;

import net.minecraft.inventory.InventoryBasic;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;

public class InventoryGunModTable extends InventoryBasic {
  public ItemStack lastGunStack;
  
  public GunType gunType;
  
  public int genericScroll;
  
  private boolean busy;
  
  public InventoryGunModTable() {
    super("Gun Modification Table", true, 17);
    this.genericScroll = 0;
    this.busy = false;
  }
  
  public void func_70296_d() {
    if (this.busy)
      return; 
    ItemStack gunStack = func_70301_a(0);
    if (gunStack == null || !(gunStack.func_77973_b() instanceof ItemGun))
      return; 
    this.gunType = ((ItemGun)gunStack.func_77973_b()).type;
    String[] tags = { "barrel", "scope", "stock", "grip", "gadget", "slide", "pump", "accessory" };
    if (gunStack != this.lastGunStack) {
      this.busy = true;
      NBTTagCompound attachmentTags = gunStack.field_77990_d.func_74775_l("attachments");
      int i;
      for (i = 0; i < 8; i++)
        func_70299_a(i + 1, ItemStack.func_77949_a(attachmentTags.func_74775_l(tags[i]))); 
      this.genericScroll = 0;
      for (i = 0; i < Math.min(this.gunType.numGenericAttachmentSlots, 8); i++)
        func_70299_a(tags.length + i + 1, ItemStack.func_77949_a(attachmentTags.func_74775_l("generic_" + i))); 
      this.busy = false;
    } else {
      NBTTagCompound gunTags = new NBTTagCompound();
      gunTags.func_74782_a("ammo", (func_70301_a(0)).field_77990_d.func_74781_a("ammo"));
      if ((func_70301_a(0)).field_77990_d.func_74781_a("Paint") != null)
        gunTags.func_74782_a("Paint", (func_70301_a(0)).field_77990_d.func_74781_a("Paint")); 
      NBTTagCompound attachmentTags = new NBTTagCompound();
      int i;
      for (i = 0; i < 8; i++)
        writeAttachmentTags(attachmentTags, func_70301_a(i + 1), tags[i]); 
      for (i = 0; i < this.gunType.numGenericAttachmentSlots; i++) {
        if (i >= this.genericScroll * 4 && i < this.genericScroll * 4 + 8) {
          writeAttachmentTags(attachmentTags, func_70301_a(i - this.genericScroll * 4 + tags.length + 1), "generic_" + i);
        } else {
          attachmentTags.func_74782_a("generic_" + i, (func_70301_a(0)).field_77990_d.func_74781_a("generic_" + i));
        } 
      } 
      gunTags.func_74782_a("attachments", (NBTBase)attachmentTags);
      gunStack.field_77990_d = gunTags;
    } 
    this.lastGunStack = gunStack;
  }
  
  public void writeAttachmentTags(NBTTagCompound attachmentTags, ItemStack attachmentStack, String attachmentName) {
    NBTTagCompound tags = new NBTTagCompound();
    if (attachmentStack != null)
      attachmentStack.func_77955_b(tags); 
    attachmentTags.func_74782_a(attachmentName, (NBTBase)tags);
  }
  
  public boolean func_94041_b(int i, ItemStack itemstack) {
    return false;
  }
}
