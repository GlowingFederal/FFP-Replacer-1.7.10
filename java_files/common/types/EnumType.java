package com.flansmod.common.types;

import com.flansmod.common.driveables.PlaneType;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.driveables.mechas.MechaItemType;
import com.flansmod.common.driveables.mechas.MechaType;
import com.flansmod.common.guns.AAGunType;
import com.flansmod.common.guns.AttachmentType;
import com.flansmod.common.guns.BulletType;
import com.flansmod.common.guns.GrenadeType;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.boxes.GunBoxType;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.teams.ArmourBoxType;
import com.flansmod.common.teams.ArmourType;
import com.flansmod.common.teams.PlayerClass;
import com.flansmod.common.teams.Team;
import com.flansmod.common.tools.ToolType;

public enum EnumType {
  part("parts"),
  bullet("bullets"),
  attachment("attachments"),
  grenade("grenades"),
  gun("guns"),
  aa("aaguns"),
  vehicle("vehicles"),
  plane("planes"),
  mechaItem("mechaItems"),
  mecha("mechas"),
  tool("tools"),
  armour("armorFiles"),
  armourBox("armorBoxes"),
  box("boxes"),
  playerClass("classes"),
  team("teams"),
  itemHolder("itemHolders");
  
  public String folderName;
  
  EnumType(String s) {
    this.folderName = s;
  }
  
  public static EnumType get(String s) {
    for (EnumType e : values()) {
      if (e.folderName.equals(s))
        return e; 
    } 
    return null;
  }
  
  public Class<? extends InfoType> getTypeClass() {
    switch (this) {
      case bullet:
        return (Class)BulletType.class;
      case aa:
        return (Class)AAGunType.class;
      case vehicle:
        return (Class)VehicleType.class;
      case plane:
        return (Class)PlaneType.class;
      case mechaItem:
        return (Class)MechaItemType.class;
      case mecha:
        return (Class)MechaType.class;
      case attachment:
        return (Class)AttachmentType.class;
      case gun:
        return (Class)GunType.class;
      case grenade:
        return (Class)GrenadeType.class;
      case tool:
        return (Class)ToolType.class;
      case armour:
        return (Class)ArmourType.class;
      case armourBox:
        return (Class)ArmourBoxType.class;
      case playerClass:
        return (Class)PlayerClass.class;
      case team:
        return (Class)Team.class;
      case box:
        return (Class)GunBoxType.class;
      case part:
        return (Class)PartType.class;
    } 
    return InfoType.class;
  }
  
  public static EnumType getFromObject(Object o) {
    if (o instanceof MechaType || o instanceof com.flansmod.common.driveables.mechas.ItemMecha || o instanceof com.flansmod.common.driveables.mechas.EntityMecha)
      return mecha; 
    if (o instanceof PlaneType || o instanceof com.flansmod.common.driveables.ItemPlane || o instanceof com.flansmod.common.driveables.EntityPlane)
      return plane; 
    if (o instanceof VehicleType || o instanceof com.flansmod.common.driveables.ItemVehicle || o instanceof com.flansmod.common.driveables.EntityVehicle)
      return vehicle; 
    if (o instanceof BulletType || o instanceof com.flansmod.common.guns.ItemBullet || o instanceof com.flansmod.common.guns.EntityBullet)
      return bullet; 
    if (o instanceof AAGunType || o instanceof com.flansmod.common.guns.ItemAAGun || o instanceof com.flansmod.common.guns.EntityAAGun)
      return aa; 
    if (o instanceof MechaItemType || o instanceof com.flansmod.common.driveables.mechas.ItemMechaAddon)
      return mechaItem; 
    if (o instanceof AttachmentType || o instanceof com.flansmod.common.guns.ItemAttachment)
      return attachment; 
    if (o instanceof GunType || o instanceof com.flansmod.common.guns.ItemGun || o instanceof com.flansmod.common.guns.EntityMG)
      return gun; 
    if (o instanceof GrenadeType || o instanceof com.flansmod.common.guns.ItemGrenade || o instanceof com.flansmod.common.guns.EntityGrenade)
      return grenade; 
    if (o instanceof ToolType || o instanceof com.flansmod.common.tools.ItemTool)
      return tool; 
    if (o instanceof ArmourType || o instanceof com.flansmod.common.teams.ItemTeamArmour)
      return armour; 
    if (o instanceof ArmourBoxType || o instanceof com.flansmod.common.teams.BlockArmourBox)
      return armourBox; 
    if (o instanceof PlayerClass)
      return playerClass; 
    if (o instanceof Team)
      return team; 
    if (o instanceof GunBoxType || o instanceof com.flansmod.common.guns.boxes.BlockGunBox)
      return box; 
    if (o instanceof PartType || o instanceof com.flansmod.common.parts.ItemPart)
      return part; 
    return null;
  }
}
