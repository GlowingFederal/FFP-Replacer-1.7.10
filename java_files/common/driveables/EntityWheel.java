package com.flansmod.common.driveables;

import com.flansmod.common.FlansMod;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;

public class EntityWheel extends Entity implements IEntityAdditionalSpawnData {
  public EntityDriveable vehicle;
  
  public int ID;
  
  @SideOnly(Side.CLIENT)
  public boolean foundVehicle;
  
  private int vehicleID;
  
  public boolean onDeck = false;
  
  private int invulnerableUnmountCount;
  
  public int timeLimitDriveableNull = 0;
  
  public EntityWheel(World world) {
    super(world);
    func_70105_a(1.0F, 1.0F);
    this.field_70138_W = 1.5F;
    this.invulnerableUnmountCount = 0;
  }
  
  public EntityWheel(World world, EntityDriveable entity, int i) {
    this(world);
    this.vehicle = entity;
    this.vehicleID = entity.func_145782_y();
    this.ID = i;
    initPosition();
  }
  
  public void initPosition() {
    Vector3f wheelVector = this.vehicle.axes.findLocalVectorGlobally(((this.vehicle.getDriveableType()).wheelPositions[this.ID]).position);
    func_70107_b(this.vehicle.field_70165_t + wheelVector.x, this.vehicle.field_70163_u + wheelVector.y, this.vehicle.field_70161_v + wheelVector.z);
    this.field_70138_W = (this.vehicle.getDriveableType()).wheelStepHeight;
    this.field_70169_q = this.field_70165_t;
    this.field_70167_r = this.field_70163_u;
    this.field_70166_s = this.field_70161_v;
  }
  
  protected void func_70069_a(float k) {}
  
  protected void func_70088_a() {}
  
  protected void func_70037_a(NBTTagCompound tags) {
    func_70106_y();
  }
  
  protected void func_70014_b(NBTTagCompound tags) {}
  
  public void func_70071_h_() {
    EntityDriveable entD;
    if (this.field_70154_o != null) {
      this.invulnerableUnmountCount = 80;
    } else if (this.invulnerableUnmountCount > 0) {
      this.invulnerableUnmountCount--;
    } 
    if (this.field_70170_p.field_72995_K && !this.foundVehicle) {
      if (this.field_70170_p.func_73045_a(this.vehicleID) instanceof EntityDriveable)
        this.vehicle = (EntityDriveable)this.field_70170_p.func_73045_a(this.vehicleID); 
      if (this.vehicle == null)
        return; 
      this.foundVehicle = true;
      this.vehicle.wheels[this.ID] = this;
    } 
    if (this.vehicle == null)
      return; 
    if (this.field_70170_p.func_73045_a(this.vehicleID) instanceof EntityDriveable) {
      entD = (EntityDriveable)this.field_70170_p.func_73045_a(this.vehicleID);
    } else {
      entD = null;
    } 
    if (entD == null) {
      this.timeLimitDriveableNull++;
    } else {
      this.timeLimitDriveableNull = 0;
    } 
    if (this.timeLimitDriveableNull > 1200)
      func_70106_y(); 
    if (!this.field_70175_ag)
      this.field_70170_p.func_72838_d(this); 
  }
  
  public double getSpeedXZ() {
    return Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
  }
  
  public double getSpeedXYZ() {
    return Math.cbrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y + this.field_70181_x * this.field_70181_x);
  }
  
  public void func_70056_a(double d, double d1, double d2, float f, float f1, int i) {}
  
  public AxisAlignedBB func_70114_g(Entity entity) {
    if (this.vehicle.seats[0] != null && 
      (this.vehicle.getDriveableType()).collisionDamageEnable && (this.vehicle.seats[0]).field_70153_n != null)
      if (this.vehicle.throttle > (this.vehicle.getDriveableType()).collisionDamageThrottle)
        if (entity instanceof EntityLiving && !entity.func_70115_ae() && !entity.field_70128_L) {
          entity.func_70097_a(DamageSource.field_76367_g, this.vehicle.throttle * this.vehicle.throttle * (this.vehicle.getDriveableType()).collisionDamageTimes);
          if (this.vehicle.throttle * this.vehicle.throttle * (this.vehicle.getDriveableType()).collisionDamageTimes > 23.0F && ((EntityLiving)entity).func_110143_aJ() > 0.0F) {
            FlansMod.proxy.spawnParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, 0.0D, 0.10000000149011612D, 0.0D);
            PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 15.0D, entity.field_71093_bK, "goreDeath", true);
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 150.0F, entity.field_71093_bK);
          } 
        } else if (entity instanceof EntityPlayer && !entity.func_70115_ae() && !entity.field_70128_L) {
          entity.func_70097_a(DamageSource.field_76367_g, this.vehicle.throttle * this.vehicle.throttle * (this.vehicle.getDriveableType()).collisionDamageTimes);
          if (this.vehicle.throttle * this.vehicle.throttle * (this.vehicle.getDriveableType()).collisionDamageTimes > 23.0F && ((EntityPlayer)entity).func_110143_aJ() > 0.0F) {
            FlansMod.proxy.spawnParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, 0.0D, 0.10000000149011612D, 0.0D);
            PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 15.0D, entity.field_71093_bK, "goreDeath", true);
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 150.0F, entity.field_71093_bK);
          } 
        }   
    return this.field_70121_D;
  }
  
  public void writeSpawnData(ByteBuf data) {
    data.writeInt(this.vehicleID);
    data.writeInt(this.ID);
  }
  
  public void readSpawnData(ByteBuf data) {
    this.vehicleID = data.readInt();
    this.ID = data.readInt();
    this.vehicle = (EntityDriveable)this.field_70170_p.func_73045_a(this.vehicleID);
    if (this.vehicle != null)
      func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v); 
  }
}
