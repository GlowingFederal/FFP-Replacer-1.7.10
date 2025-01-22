package com.flansmod.common.guns;

import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.Item;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class ItemShootable extends Item {
  public ShootableType type;
  
  public ItemShootable(ShootableType t) {
    this.type = t;
    this.field_77777_bU = this.type.maxStackSize;
    func_77656_e(this.type.roundsPerItem);
    GameRegistry.registerItem(this, this.type.shortName, "flansmod");
  }
  
  public abstract EntityShootable getEntity(World paramWorld, Vec3 paramVec3, float paramFloat1, float paramFloat2, double paramDouble1, double paramDouble2, double paramDouble3, EntityLivingBase paramEntityLivingBase, float paramFloat3, int paramInt, InfoType paramInfoType);
  
  public abstract EntityShootable getEntity(World paramWorld, Vector3f paramVector3f1, Vector3f paramVector3f2, EntityLivingBase paramEntityLivingBase, float paramFloat1, float paramFloat2, float paramFloat3, int paramInt, InfoType paramInfoType);
  
  public abstract EntityShootable getEntity(World paramWorld, Vec3 paramVec3, float paramFloat1, float paramFloat2, EntityLivingBase paramEntityLivingBase, float paramFloat3, float paramFloat4, int paramInt, InfoType paramInfoType);
  
  public abstract EntityShootable getEntity(World paramWorld, EntityLivingBase paramEntityLivingBase, float paramFloat1, float paramFloat2, float paramFloat3, boolean paramBoolean, int paramInt, InfoType paramInfoType, float paramFloat4, float paramFloat5, float paramFloat6);
}
