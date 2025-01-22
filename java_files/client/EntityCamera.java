package com.flansmod.client;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EnumWeaponType;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.vector.Vector3f;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.world.World;

public class EntityCamera extends EntityLivingBase {
  public EntityDriveable driveable;
  
  public int pupperino = 0;
  
  public EntityCamera(World world) {
    super(world);
    func_70105_a(0.0F, 0.0F);
  }
  
  public EntityCamera(World world, EntityDriveable d) {
    this(world);
    this.driveable = d;
    func_70107_b(d.field_70165_t, d.field_70163_u, d.field_70161_v);
  }
  
  public void func_70071_h_() {
    if (this.pupperino > 0)
      this.pupperino--; 
    if (this.pupperino == 1 && FlansModClient.minecraft.field_71474_y.field_74320_O == 1)
      FlansModClient.minecraft.field_71474_y.field_74320_O = 0; 
    List<Entity> foxes = this.driveable.field_70170_p.func_72839_b((Entity)this.driveable, AxisAlignedBB.func_72330_a(this.driveable.field_70165_t - 200.0D, this.driveable.field_70163_u - 500.0D, this.driveable.field_70161_v - 200.0D, this.driveable.field_70165_t + 200.0D, this.driveable.field_70163_u + 500.0D, this.driveable.field_70161_v + 200.0D));
    for (Entity stuff : foxes) {
      if (!(stuff instanceof EntityBullet))
        continue; 
      EntityBullet missile = (EntityBullet)stuff;
      if (missile != null) {
        if (this.driveable != null && missile.type != null && !missile.type.TVguided && !missile.type.starShell && !this.driveable.artilleryMode)
          continue; 
        for (int i = 0; i < (this.driveable.getDriveableType()).numPassengers + 1; i++) {
          if (this.driveable.seats[i] != null)
            if (missile.owner != null)
              if ((this.driveable.seats[i]).field_70153_n != null && 
                missile.owner == (this.driveable.seats[i]).field_70153_n && (missile.type.TVguided || this.driveable.artilleryMode)) {
                if (missile.type.weaponType.equals(EnumWeaponType.MISSILE) || missile.type.weaponType.equals(EnumWeaponType.SHELL) || missile.type.weaponType.equals(EnumWeaponType.BOMB))
                  func_70107_b(missile.field_70165_t, missile.field_70163_u, missile.field_70161_v); 
                this.field_70177_z = missile.field_70177_z;
                this.field_70125_A = missile.field_70125_A;
                if (missile.type.TVguided) {
                  if (missile.owner != null)
                    if (this.pupperino < 40 && FlansModClient.minecraft.field_71439_g == missile.owner)
                      this.pupperino += 2;  
                  func_70078_a((Entity)missile);
                  if (FlansModClient.minecraft.field_71474_y.field_74320_O == 0 && FlansModClient.minecraft.field_71439_g == missile.owner)
                    FlansModClient.minecraft.field_71474_y.field_74320_O = 1; 
                } 
              }   
        } 
      } 
    } 
    if (foxes != null) {
      this.field_70169_q = this.field_70165_t;
      this.field_70167_r = this.field_70163_u;
      this.field_70166_s = this.field_70161_v;
      Vector3f cameraPosition = new Vector3f();
      cameraPosition = this.driveable.axes.findLocalVectorGlobally(cameraPosition);
      double dX = this.driveable.field_70165_t + cameraPosition.x - this.field_70165_t;
      double dY = this.driveable.field_70163_u + cameraPosition.y - this.field_70163_u;
      double dZ = this.driveable.field_70161_v + cameraPosition.z - this.field_70161_v;
      float lerpAmount = 0.1F;
      func_70107_b(this.field_70165_t + dX * lerpAmount, this.field_70163_u + dY * lerpAmount, this.field_70161_v + dZ * lerpAmount);
      if (FlansMod.proxy.mouseControlEnabled() && !(this.driveable instanceof com.flansmod.common.driveables.EntityVehicle)) {
        this.field_70177_z = this.driveable.axes.getYaw() - 90.0F;
        this.field_70125_A = this.driveable.axes.getPitch();
      } else {
        EntityPlayer entityPlayer = FlansMod.proxy.getThePlayer();
        if (entityPlayer != null) {
          this.field_70177_z = ((Entity)entityPlayer).field_70177_z;
          this.field_70125_A = ((Entity)entityPlayer).field_70125_A;
        } 
      } 
      for (; this.field_70177_z - this.field_70126_B >= 180.0F; this.field_70177_z -= 360.0F);
      for (; this.field_70177_z - this.field_70126_B < -180.0F; this.field_70177_z += 360.0F);
    } 
  }
  
  public ItemStack func_70694_bm() {
    return null;
  }
  
  public ItemStack func_71124_b(int p_71124_1_) {
    return null;
  }
  
  public void func_70062_b(int p_70062_1_, ItemStack p_70062_2_) {}
  
  public ItemStack[] func_70035_c() {
    return null;
  }
}
