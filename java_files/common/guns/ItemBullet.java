package com.flansmod.common.guns;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EnumWeaponType;
import com.flansmod.common.types.IFlanItem;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.List;
import javax.vecmath.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class ItemBullet extends ItemShootable implements IFlanItem {
  public BulletType type;
  
  public ItemBullet(BulletType infoType) {
    super(infoType);
    this.type = infoType;
    func_77625_d(this.type.maxStackSize);
    func_77627_a(true);
    this.type.item = this;
    switch (this.type.weaponType) {
      case SHELL:
      case BOMB:
      case MINE:
      case MISSILE:
        func_77637_a((CreativeTabs)FlansMod.tabFlanDriveables);
        return;
    } 
    func_77637_a((CreativeTabs)FlansMod.tabFlanGuns);
  }
  
  public boolean isRepairable() {
    return this.canRepair;
  }
  
  @SideOnly(Side.CLIENT)
  public int func_82790_a(ItemStack par1ItemStack, int par2) {
    return this.type.colour;
  }
  
  @SideOnly(Side.CLIENT)
  public void func_94581_a(IIconRegister icon) {
    this.field_77791_bV = icon.func_94245_a("FlansMod:" + this.type.iconPath);
  }
  
  public void func_77624_a(ItemStack stack, EntityPlayer player, List<String> lines, boolean b) {
    KeyBinding shift = (Minecraft.func_71410_x()).field_71474_y.field_74311_E;
    if (!this.type.packName.isEmpty())
      lines.add(this.type.packName); 
    if (this.type.description != null)
      Collections.addAll(lines, this.type.description.split("_")); 
    if (this.type.roundsPerItem > 1)
      lines.add("§6Rounds§7: " + this.type.roundsPerItem); 
    if (this.type.damageVsLiving > 1.0F)
      lines.add("§6Soft Target Damage§7: " + this.type.damageVsLiving); 
    if (this.type.damageVsVehicles > 1.0F)
      lines.add("§6Hard Target Damage§7: " + this.type.damageVsVehicles); 
    if (this.type.damageVsPlanes > 1.0F)
      lines.add("§6Air Target Damage§7: " + this.type.damageVsVehicles); 
    if (this.type.bodyarmorPen != 500.0F)
      lines.add("§2Body Armor Penetration§7: " + this.type.bodyarmorPen); 
    if (this.type.armorPen > 2.0F)
      lines.add("§2Tank Armor Penetration§7: " + this.type.armorPen + " mm"); 
    if (this.type.HEAT)
      lines.add("Has Shaped-Charge (Weak Against Composite armor)"); 
    if (!GameSettings.func_100015_a(shift) && this.type.dynamicBulletDelay < 8999) {
      lines.add("Hold §b§o" + GameSettings.func_74298_c(shift.func_151463_i()) + "§r§7 for long range details");
    } else if (this.type.dynamicBulletDelay < 8999) {
      lines.add("");
      lines.add("§oLong-Range Performance: ");
      lines.add("§6Soft-Target Damage§7: " + this.type.dynamicDamage);
      lines.add("§2Body Armor Penetration§7: " + this.type.dynamicBodyarmorPen);
    } 
  }
  
  public EntityShootable getEntity(World worldObj, Vec3 origin, float yaw, float pitch, double motionX, double motionY, double motionZ, EntityLivingBase shooter, float gunDamage, int itemDamage, InfoType shotFrom) {
    return new EntityBullet(worldObj, origin, yaw, pitch, motionX, motionY, motionZ, shooter, gunDamage, this.type, shotFrom);
  }
  
  public EntityShootable getEntity(World worldObj, Vector3f origin, Vector3f direction, EntityLivingBase shooter, float spread, float damage, float speed, int itemDamage, InfoType shotFrom) {
    return new EntityBullet(worldObj, origin, direction, shooter, spread, damage, this.type, speed, shotFrom);
  }
  
  public EntityShootable getEntity(World worldObj, Vec3 origin, float yaw, float pitch, EntityLivingBase shooter, float spread, float damage, int itemDamage, InfoType shotFrom) {
    return new EntityBullet(worldObj, origin, yaw, pitch, shooter, spread, damage, this.type, shotFrom);
  }
  
  public EntityShootable getEntity(World worldObj, EntityLivingBase player, float bulletSpread, float damage, float bulletSpeed, boolean b, int itemDamage, InfoType shotFrom, float Xoffset, float Yoffset, float Zoffset) {
    return new EntityBullet(worldObj, player, bulletSpread, damage, this.type, bulletSpeed, b, shotFrom, Xoffset, Yoffset, Zoffset);
  }
  
  public InfoType getInfoType() {
    return this.type;
  }
  
  public Entity getEntity(World worldObj, EntityLivingBase player, float bulletSpread, float damage, float bulletSpeed, boolean b, int itemDamage, GunType type2, Vector3f vector3f) {
    return null;
  }
}
