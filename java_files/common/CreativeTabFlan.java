package com.flansmod.common;

import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EnumPlaneMode;
import com.flansmod.common.driveables.ItemPlane;
import com.flansmod.common.driveables.ItemVehicle;
import com.flansmod.common.driveables.PlaneType;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.types.IFlanItem;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabFlan extends CreativeTabs {
  public int type;
  
  public int icon;
  
  public int time = 0;
  
  public CreativeTabFlan(int i) {
    super("tabFlan" + i);
    this.type = i;
  }
  
  public Item func_78016_d() {
    return null;
  }
  
  public ItemStack func_151244_d() {
    this.icon = FlansMod.ticker / 20;
    switch (this.type) {
      case 0:
        return (GunType.gunList.size() == 0) ? new ItemStack((Item)FlansMod.opStick, 1, 5) : new ItemStack((Item)FlansMod.opStick, 1, 5);
      case 1:
        return (DriveableType.types.size() == 0) ? new ItemStack((Item)FlansMod.opStick, 1, 1) : new ItemStack((Item)FlansMod.opStick, 1, 1);
      case 2:
        return (FlansMod.partItems.size() == 0) ? new ItemStack((Item)FlansMod.opStick, 1, 3) : new ItemStack((Item)FlansMod.opStick, 1, 3);
      case 3:
        return (FlansMod.armourItems.size() == 0) ? new ItemStack((Item)FlansMod.opStick, 1, 0) : new ItemStack((Item)FlansMod.opStick, 1, 0);
      case 4:
        return (FlansMod.mechaItems.size() == 0) ? new ItemStack((Item)FlansMod.opStick, 1, 2) : new ItemStack((Item)FlansMod.opStick, 1, 2);
    } 
    return new ItemStack(FlansMod.workbench);
  }
  
  @SideOnly(Side.CLIENT)
  public void func_78018_a(List<ItemStack> list) {
    super.func_78018_a(list);
    Comparator<ItemStack> cmp = new Comparator<ItemStack>() {
        public int compare(ItemStack is1, ItemStack is2) {
          PlaneType planeType1, planeType2;
          String s1 = is1.func_77977_a();
          String s2 = is2.func_77977_a();
          Item i1 = is1.func_77973_b();
          Item i2 = is2.func_77973_b();
          if (i1 instanceof IFlanItem && i2 instanceof IFlanItem) {
            String it1 = (((IFlanItem)i1).getInfoType()).packName;
            String it2 = (((IFlanItem)i2).getInfoType()).packName;
            int cmp = it1.compareTo(it2);
            if (cmp != 0)
              return cmp; 
          } 
          if (i1 instanceof ItemBlockManyNames && !(i2 instanceof ItemBlockManyNames))
            return -1; 
          if (!(i1 instanceof ItemBlockManyNames) && i2 instanceof ItemBlockManyNames)
            return 1; 
          if (i1 instanceof net.minecraft.item.ItemBlock && !(i2 instanceof net.minecraft.item.ItemBlock))
            return -1; 
          if (!(i1 instanceof net.minecraft.item.ItemBlock) && i2 instanceof net.minecraft.item.ItemBlock)
            return 1; 
          if (i1 instanceof com.flansmod.common.guns.ItemAttachment && !(i2 instanceof com.flansmod.common.guns.ItemAttachment))
            return -1; 
          if (!(i1 instanceof com.flansmod.common.guns.ItemAttachment) && i2 instanceof com.flansmod.common.guns.ItemAttachment)
            return 1; 
          if (i1 instanceof com.flansmod.common.guns.ItemAAGun && !(i2 instanceof com.flansmod.common.guns.ItemAAGun))
            return -1; 
          if (!(i1 instanceof com.flansmod.common.guns.ItemAAGun) && i2 instanceof com.flansmod.common.guns.ItemAAGun)
            return 1; 
          if (i1 instanceof ItemVehicle && i2 instanceof com.flansmod.common.guns.ItemBullet)
            return 1; 
          if (i1 instanceof com.flansmod.common.guns.ItemBullet && i2 instanceof ItemVehicle)
            return -1; 
          if (i1 instanceof ItemPlane && i2 instanceof com.flansmod.common.guns.ItemBullet)
            return 1; 
          if (i1 instanceof com.flansmod.common.guns.ItemBullet && i2 instanceof ItemPlane)
            return -1; 
          DriveableType dt1 = null;
          DriveableType dt2 = null;
          if (i1 instanceof ItemVehicle)
            VehicleType vehicleType = ((ItemVehicle)i1).type; 
          if (i2 instanceof ItemVehicle)
            VehicleType vehicleType = ((ItemVehicle)i2).type; 
          if (i1 instanceof ItemPlane)
            planeType1 = ((ItemPlane)i1).type; 
          if (i2 instanceof ItemPlane)
            planeType2 = ((ItemPlane)i2).type; 
          if (planeType1 != null && planeType2 != null) {
            String ct1 = "";
            String ct2 = "";
            if (((DriveableType)planeType1).modelString.indexOf(".") >= 1)
              ct1 = ((DriveableType)planeType1).modelString.substring(0, ((DriveableType)planeType1).modelString.indexOf(".") - 1); 
            if (((DriveableType)planeType2).modelString.indexOf(".") >= 1)
              ct1 = ((DriveableType)planeType2).modelString.substring(0, ((DriveableType)planeType2).modelString.indexOf(".") - 1); 
            if (!ct1.equals(ct2))
              return ct1.compareTo(ct2); 
          } 
          if (i1 instanceof ItemVehicle && !(i2 instanceof ItemVehicle))
            return -1; 
          if (!(i1 instanceof ItemVehicle) && i2 instanceof ItemVehicle)
            return 1; 
          if (i1 instanceof ItemPlane && !(i2 instanceof ItemPlane))
            return -1; 
          if (!(i1 instanceof ItemPlane) && i2 instanceof ItemPlane)
            return 1; 
          if (i1 instanceof ItemPlane && i2 instanceof ItemPlane) {
            EnumPlaneMode epm1 = ((ItemPlane)i1).type.mode;
            EnumPlaneMode epm2 = ((ItemPlane)i2).type.mode;
            return epm1.compareTo((Enum)epm2);
          } 
          if (!(i1 instanceof com.flansmod.common.guns.ItemGrenade) && i2 instanceof com.flansmod.common.guns.ItemGrenade)
            return -1; 
          if (i1 instanceof com.flansmod.common.guns.ItemGrenade && !(i2 instanceof com.flansmod.common.guns.ItemGrenade))
            return 1; 
          return s1.compareTo(s2);
        }
      };
    try {
      Collections.sort(list, cmp);
    } catch (Exception exception) {}
  }
}
