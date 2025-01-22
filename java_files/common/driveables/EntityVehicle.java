package com.flansmod.common.driveables;

import com.flansmod.api.IExplodeable;
import com.flansmod.client.model.AnimTankTrack;
import com.flansmod.client.model.AnimTrackLink;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketCurrentMissile;
import com.flansmod.common.network.PacketDriveableKey;
import com.flansmod.common.network.PacketFlak;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.network.PacketVehicleControl;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.vector.Vector3f;
import io.netty.buffer.ByteBuf;
import java.util.List;
import java.util.Random;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntityVehicle extends EntityDriveable implements IExplodeable {
  public int shellDelay;
  
  public int gunDelay;
  
  public int soundPosition;
  
  public int idlePosition;
  
  public float wheelsYaw;
  
  private int ticksSinceUsed = 0;
  
  public boolean varDoor;
  
  public boolean combatRadar = false;
  
  public float wheelsAngle;
  
  public int toggleTimer = 0;
  
  public boolean pupperino = false;
  
  private int testerino = 0;
  
  public int totalCrewInfo;
  
  public int exitTimer = 40;
  
  public float yaw = 0.0F;
  
  public float pitch = 0.0F;
  
  public float roll = 0.0F;
  
  public float yawSpeed = 0.0F;
  
  public boolean leftTurnHeld = false;
  
  public boolean rightTurnHeld = false;
  
  public boolean allWheelsOnGround;
  
  public boolean tooDeep = false;
  
  boolean lockTurretForward = false;
  
  public Vector3f doorPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f doorRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f door2Pos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f door2Rot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevDoorPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevDoorRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevDoor2Pos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevDoor2Rot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public int yawDelay = 0;
  
  public int pitchDelay = 0;
  
  public boolean turretYawing;
  
  public boolean turretPitching;
  
  public boolean deployedSmoke = false;
  
  public boolean repairing = false;
  
  public AnimTankTrack rightTrack;
  
  public AnimTankTrack leftTrack;
  
  public AnimTrackLink[] trackLinksLeft = new AnimTrackLink[0];
  
  public AnimTrackLink[] trackLinksRight = new AnimTrackLink[0];
  
  public boolean radarVisible;
  
  public boolean hasRadar;
  
  public boolean digitalRadar = false;
  
  public float radarRange;
  
  public int radarPositionOffset;
  
  public int radarRefreshDelay;
  
  public int slbmFlightType;
  
  public int slbmDelay;
  
  public int slbmRange;
  
  public int slbmStrength;
  
  public int slbmWarheadType;
  
  double jolt = 0.0D;
  
  int delay = 0;
  
  double timer = 0.0D;
  
  int cringe = 0;
  
  private int deathTimer = 0;
  
  private float radarDetectionRangeMultiplier = 1.0F;
  
  private float terrainFactor = 1.0F;
  
  public boolean alwaysShowTurret = false;
  
  public EntityVehicle(World world) {
    super(world);
    this.field_70138_W = 1.5F;
  }
  
  public EntityVehicle(World world, double x, double y, double z, VehicleType type, DriveableData data) {
    super(world, type, data);
    this.field_70138_W = type.wheelStepHeight;
    func_70107_b(x, y, z);
    initType(type, false);
  }
  
  public EntityVehicle(World world, double x, double y, double z, float yaw, VehicleType type, DriveableData data) {
    super(world, type, data);
    this.field_70138_W = type.wheelStepHeight;
    func_70107_b(x, y, z);
    rotateYaw(yaw);
    initType(type, false);
  }
  
  public EntityVehicle(World world, double x, double y, double z, EntityPlayer placer, VehicleType type, DriveableData data) {
    super(world, type, data);
    this.field_70138_W = type.wheelStepHeight;
    func_70107_b(x, y, z);
    if (placer != null)
      rotateYaw(placer.field_70177_z + 90.0F); 
    initType(type, false);
    setupTracks(type);
  }
  
  public void setupTracks(DriveableType type) {
    this.rightTrack = new AnimTankTrack(type.rightTrackPoints, type.trackLinkLength);
    this.leftTrack = new AnimTankTrack(type.leftTrackPoints, type.trackLinkLength);
    int numLinks = Math.round(this.rightTrack.getTrackLength() / type.trackLinkLength);
    this.trackLinksLeft = new AnimTrackLink[numLinks];
    this.trackLinksRight = new AnimTrackLink[numLinks];
    for (int i = 0; i < numLinks; i++) {
      float progress = 0.01F + type.trackLinkLength * i;
      int trackPart = this.leftTrack.getTrackPart(progress);
      this.trackLinksLeft[i] = new AnimTrackLink(progress);
      this.trackLinksRight[i] = new AnimTrackLink(progress);
      (this.trackLinksLeft[i]).position = this.leftTrack.getPositionOnTrack(progress);
      (this.trackLinksRight[i]).position = this.rightTrack.getPositionOnTrack(progress);
      (this.trackLinksLeft[i]).rot = new RotatedAxes(0.0F, 0.0F, rotateTowards(this.leftTrack.points.get((trackPart == 0) ? (this.leftTrack.points.size() - 1) : (trackPart - 1)), (this.trackLinksLeft[i]).position));
      (this.trackLinksRight[i]).rot = new RotatedAxes(0.0F, 0.0F, rotateTowards(this.rightTrack.points.get((trackPart == 0) ? (this.rightTrack.points.size() - 1) : (trackPart - 1)), (this.trackLinksRight[i]).position));
      (this.trackLinksLeft[i]).zRot = rotateTowards(this.leftTrack.points.get((trackPart == 0) ? (this.leftTrack.points.size() - 1) : (trackPart - 1)), (this.trackLinksLeft[i]).position);
      (this.trackLinksRight[i]).zRot = rotateTowards(this.rightTrack.points.get((trackPart == 0) ? (this.rightTrack.points.size() - 1) : (trackPart - 1)), (this.trackLinksRight[i]).position);
    } 
  }
  
  protected void initType(DriveableType type, boolean clientSide) {
    this.radarVisible = type.radarVisible;
    this.hasRadar = type.hasRadar;
    this.radarRange = type.radarRange;
    this.radarPositionOffset = type.radarPositionOffset;
    this.radarRefreshDelay = type.radarRefreshDelay;
    this.slbmFlightType = type.slbmFlightType;
    this.slbmDelay = type.slbmDelay;
    this.slbmRange = type.slbmRange;
    this.slbmStrength = type.slbmStrength;
    this.slbmWarheadType = type.slbmWarheadType;
    this.digitalRadar = type.digitalRadar;
    this.radarDetectionRangeMultiplier = type.radarDetectionRangeMultiplier;
    super.initType(type, clientSide);
    setupTracks(type);
    this.field_70138_W = type.wheelStepHeight;
    this.alwaysShowTurret = type.alwaysShowTurret;
  }
  
  public void readSpawnData(ByteBuf data) {
    super.readSpawnData(data);
  }
  
  protected void func_70014_b(NBTTagCompound tag) {
    super.func_70014_b(tag);
    tag.func_74757_a("VarDoor", this.varDoor);
  }
  
  protected void func_70037_a(NBTTagCompound tag) {
    super.func_70037_a(tag);
    this.varDoor = tag.func_74767_n("VarDoor");
  }
  
  public int func_70070_b(float par1) {
    if ((Minecraft.func_71410_x()).field_71460_t.func_147702_a())
      return 15728880; 
    int i = MathHelper.func_76128_c(this.field_70165_t);
    int j = MathHelper.func_76128_c(this.field_70161_v);
    if (this.field_70170_p.func_72899_e(i, 0, j)) {
      double d0 = (this.field_70121_D.field_72337_e - this.field_70121_D.field_72338_b) * 0.66D;
      int k = MathHelper.func_76128_c(this.field_70163_u - this.field_70129_M + d0);
      return this.field_70170_p.func_72802_i(i, k, j, 0);
    } 
    return 0;
  }
  
  public void onMouseMoved(int deltaX, int deltaY) {}
  
  public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw, float throtPP) {
    super.setPositionRotationAndMotion(x, y, z, yaw, pitch, roll, motX, motY, motZ, velYaw, velPitch, velRoll, throt, steeringYaw, throtPP);
    this.wheelsYaw = steeringYaw;
  }
  
  public boolean func_130002_c(EntityPlayer entityplayer) {
    if (this.field_70128_L)
      return false; 
    if (this.field_70170_p.field_72995_K)
      return false; 
    ItemStack currentItem = entityplayer.func_71045_bC();
    if (currentItem != null && currentItem.func_77973_b() instanceof ItemTool && ((ItemTool)currentItem.func_77973_b()).type.healDriveables)
      return true; 
    if (currentItem != null && currentItem.func_77973_b() instanceof ItemGun && ((ItemGun)currentItem.func_77973_b()).type.shootMelee)
      return true; 
    VehicleType type = getVehicleType();
    if (type.numPassengers > 0 && (this.seats[1]).field_70153_n != null && (this.seats[0]).field_70153_n == null)
      return true; 
    for (int i = 0; i <= type.numPassengers; i++) {
      if (this.seats[i].func_130002_c(entityplayer)) {
        if (i == 0) {
          this.shellDelay = type.vehicleShellDelay;
          FlansMod.proxy.doTutorialStuff(entityplayer, this);
        } 
        return true;
      } 
    } 
    return false;
  }
  
  public boolean pressKey(int key, EntityPlayer player) {
    double checkCarrierRange;
    List carrier;
    VehicleType type = getVehicleType();
    if (key == 36 && System.currentTimeMillis() - this.lastshellswitchedat > 500L && this.seats != null && this.seats[0] != null) {
      this.lastshellswitchedat = System.currentTimeMillis();
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketCurrentMissile(func_145782_y(), this.driveableData.func_70301_a(1)));
    } 
    float engineHealth = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine)).health / ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine)).maxHealth * 1.0F;
    if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine)).maxHealth == 0)
      engineHealth = 1.0F; 
    float steeringHealth = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.steering)).health / ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.steering)).maxHealth * 1.0F;
    if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.steering)).maxHealth == 0)
      steeringHealth = 1.0F; 
    float buoyancy = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.buoyancy)).health / ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.buoyancy)).maxHealth * 1.0F;
    if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.steering)).maxHealth == 0)
      buoyancy = 1.0F; 
    if (this.field_70170_p.field_72995_K && (key == 6 || key == 9)) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableKey(key));
      return true;
    } 
    switch (key) {
      case 0:
        if (((type.epicShip || type.canDive || type.airship) && this.throttle <= 1.0F) || (!type.floatOnWater && this.field_70170_p.func_72953_d(this.field_70121_D) && this.throttle <= 0.1D)) {
          this.throttle += type.accelModifier * 0.01F;
        } else if (!type.marioKart && ((!type.floatOnWater && !this.field_70170_p.func_72953_d(this.field_70121_D) && this.throttle < 1.0F && !type.epicShip) || (type.floatOnWater && this.throttle < 1.0F && !type.epicShip))) {
          this.throttle += type.accelModifier * 0.1F;
        } else if (type.marioKart && ((!type.floatOnWater && !this.field_70170_p.func_72953_d(this.field_70121_D) && this.throttlePeepee < 1.5D && !type.epicShip) || (type.floatOnWater && this.throttlePeepee < 1.5D && !type.epicShip))) {
          this.throttlePeepee += 0.5F;
        } else if (type.floatOnWater == true || type.epicShip) {
          this.throttle += type.accelModifier * 0.01F;
        } 
        if (this.throttle > 1.0F * engineHealth)
          this.throttle = 1.0F * engineHealth; 
        if (this.throttle > 1.0F * steeringHealth)
          this.throttle = 1.0F * steeringHealth; 
        if (this.throttle > 1.0F * buoyancy)
          this.throttle = 1.0F * buoyancy; 
        return true;
      case 1:
        if (type.epicShip || type.canDive || type.airship) {
          this.throttle -= 2.0F * type.decelModifier * 0.01F;
        } else if (!type.marioKart && !type.floatOnWater && !this.field_70170_p.func_72953_d(this.field_70121_D)) {
          this.throttle -= type.decelModifier * 0.1F;
        } else if (type.marioKart && ((!type.floatOnWater && !this.field_70170_p.func_72953_d(this.field_70121_D) && this.throttlePeepee > -1.5D && !type.epicShip) || (type.floatOnWater && this.throttlePeepee > -1.5D && !type.epicShip))) {
          this.throttlePeepee -= 0.5F;
        } else {
          this.throttle -= type.decelModifier * 0.005F;
        } 
        if (this.throttle < -1.0F * engineHealth)
          this.throttle = -1.0F * engineHealth; 
        if (this.throttle < -1.0F * steeringHealth)
          this.throttle = -1.0F * steeringHealth; 
        if (this.throttle < -1.0F * buoyancy)
          this.throttle = -1.0F * buoyancy; 
        if (this.throttle < 0.0F && type.maxNegativeThrottle == 0.0F)
          this.throttle = 0.0F; 
        return true;
      case 2:
        this.wheelsYaw -= 1.0F * steeringHealth;
        this.leftTurnHeld = true;
        return true;
      case 3:
        this.wheelsYaw += 1.0F * steeringHealth;
        this.rightTurnHeld = true;
        return true;
      case 4:
        if (((getVehicleType()).canDive == true && this.oxygenMeter > 0.1F) || (getVehicleType()).airship == true)
          this.divingFactor *= 0.7F / (type.brakeModifier + 0.01F); 
        if ((getVehicleType()).canDive == true && this.oxygenMeter < 0.1F) {
          this.divingFactor += 0.01F;
          if (this.divingFactor > 1.0F)
            this.divingFactor = 1.0F; 
        } 
        this.throttle *= 0.91F / (type.brakeModifier + 0.01F);
        if (type.epicShip)
          this.throttle *= 0.93F / (type.brakeModifier + 0.01F); 
        if (this.throttle > type.boostLimit)
          this.throttle = 0.0F; 
        return true;
      case 5:
        if (this.driveableData.scopeTimer <= 0 && type.hasScope) {
          this.aiming = !this.aiming;
          this.driveableData.scopeTimer = 10;
          PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 10.0D, this.field_71093_bK, "tankSight", false);
        } 
        return true;
      case 6:
        if (!this.aiming) {
          this.exitTimer--;
          this.exitTimer--;
          return true;
        } 
      case 7:
        if (this.field_70170_p.field_72995_K)
          FlansMod.proxy.openDriveableMenu((EntityPlayer)(this.seats[0]).field_70153_n, this.field_70170_p, this); 
        return true;
      case 8:
        func_70078_a(null);
        return true;
      case 19:
        if (PlayerHandler.getPlayerData(player) != null && this.nintendoSwitchLite <= 0)
          if (type.numPassengers > 0 && (this.seats[1]).field_70153_n == null) {
            this.nintendoSwitchLite = 10;
            player.func_70078_a(this.seats[1]);
          }  
        return true;
      case 21:
        if (PlayerHandler.getPlayerData(player) != null)
          if (type.numPassengers > 1 && (this.seats[1]).field_70153_n == null && (this.seats[2]).field_70153_n == null)
            player.func_70078_a(this.seats[1]);  
        return true;
      case 22:
        if (PlayerHandler.getPlayerData(player) != null)
          if (type.numPassengers > 2 && (this.seats[1]).field_70153_n == null && (this.seats[3]).field_70153_n == null)
            player.func_70078_a(this.seats[1]);  
        return true;
      case 23:
        if (PlayerHandler.getPlayerData(player) != null)
          if (type.numPassengers > 3 && (this.seats[1]).field_70153_n == null && (this.seats[4]).field_70153_n == null)
            player.func_70078_a(this.seats[1]);  
        return true;
      case 24:
        if (PlayerHandler.getPlayerData(player) != null)
          if (type.numPassengers > 4 && (this.seats[1]).field_70153_n == null && (this.seats[5]).field_70153_n == null)
            player.func_70078_a(this.seats[1]);  
        return true;
      case 25:
        if (PlayerHandler.getPlayerData(player) != null)
          if (type.numPassengers > 5 && (this.seats[1]).field_70153_n == null && (this.seats[6]).field_70153_n == null)
            player.func_70078_a(this.seats[1]);  
        return true;
      case 26:
        if (PlayerHandler.getPlayerData(player) != null)
          if (type.numPassengers > 6 && (this.seats[1]).field_70153_n == null && (this.seats[7]).field_70153_n == null)
            player.func_70078_a(this.seats[1]);  
        return true;
      case 27:
        if (PlayerHandler.getPlayerData(player) != null)
          if (type.numPassengers > 7 && (this.seats[1]).field_70153_n == null && (this.seats[8]).field_70153_n == null)
            player.func_70078_a(this.seats[1]);  
        return true;
      case 28:
        if (PlayerHandler.getPlayerData(player) != null)
          if (type.numPassengers > 8 && (this.seats[1]).field_70153_n == null && (this.seats[9]).field_70153_n == null)
            player.func_70078_a(this.seats[1]);  
        return true;
      case 29:
        if (PlayerHandler.getPlayerData(player) != null)
          if (type.numPassengers > 9 && (this.seats[1]).field_70153_n == null && (this.seats[10]).field_70153_n == null)
            player.func_70078_a(this.seats[1]);  
        return true;
      case 30:
        return true;
      case 32:
        if (this.driveableData.thermalTimer <= 0 && type.thermalSight) {
          this.thermalScoping = !this.thermalScoping;
          this.driveableData.thermalTimer = 10;
        } 
        return true;
      case 33:
        if (this.driveableData.thermalTimer <= 0 && type.hasMagicArtilleryMode) {
          this.artilleryMode = !this.artilleryMode;
          this.driveableData.thermalTimer = 10;
        } 
        return true;
      case 35:
        if (this.toggleTimer <= 0 && type.hasRadar) {
          this.activeRadar = !this.activeRadar;
          this.toggleTimer = 10;
          player.func_145747_a((IChatComponent)new ChatComponentText("Radar Mode : " + (this.activeRadar ? "active" : "passive")));
        } 
        return true;
      case 9:
        checkCarrierRange = 20.0D;
        carrier = this.field_70170_p.func_72872_a(EntitySeat.class, AxisAlignedBB.func_72330_a(this.field_70165_t - checkCarrierRange, this.field_70163_u - checkCarrierRange, this.field_70161_v - checkCarrierRange, this.field_70165_t + checkCarrierRange, this.field_70163_u + checkCarrierRange, this.field_70161_v + checkCarrierRange));
        if (type.canDabOnEntity == true) {
          if (this.field_70153_n != null && this.field_70153_n instanceof EntityVehicle && !(this.field_70153_n instanceof EntityPlayer)) {
            this.field_70153_n.func_70078_a(null);
            return true;
          } 
          for (Object obj : carrier) {
            EntitySeat carrierSpot = (EntitySeat)obj;
            if (carrierSpot.field_70153_n == null && carrierSpot.seatInfo.parkingSpot == true)
              func_70078_a(carrierSpot); 
          } 
        } 
        return true;
      case 10:
        if ((getVehicleType()).canDive == true || (getVehicleType()).airship == true)
          this.divingFactor += 0.02F; 
        if (this.divingFactor > 1.0F)
          this.divingFactor = 1.0F; 
        return true;
      case 11:
        (this.seats[0]).seatInfo.aimingSpeed = new Vector3f(0.0F, 0.0F, 0.0F);
        return true;
      case 12:
        (this.seats[0]).seatInfo.aimingSpeed = (this.seats[0]).seatInfo.aimingSpeedBackup;
        return true;
      case 13:
        return true;
      case 14:
        if (this.toggleTimer <= 0) {
          this.varDoor = !this.varDoor;
          if (type.hasDoor)
            player.func_145747_a((IChatComponent)new ChatComponentText("Doors " + (this.varDoor ? "open" : "closed"))); 
          this.toggleTimer = 10;
          FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketVehicleControl(this));
        } 
        if (this.toggleTimer <= 0) {
          this.combatRadar = !this.combatRadar;
          if (type.hasRadar)
            player.func_145747_a((IChatComponent)new ChatComponentText("Radar set to " + (this.combatRadar ? "combat range" : "long range"))); 
          this.toggleTimer = 10;
        } 
        return true;
      case 15:
        if (((getVehicleType()).canDive == true && this.oxygenMeter > 0.1F) || (getVehicleType()).airship == true)
          this.divingFactor -= 0.02F; 
        if (this.divingFactor < -1.0F)
          this.divingFactor = -1.0F; 
        if ((getVehicleType()).canDive == true && this.oxygenMeter < 0.1F) {
          this.divingFactor += 0.02F;
          if (this.divingFactor > 1.0F)
            this.divingFactor = 1.0F; 
        } 
        return true;
      case 18:
        if (type.hasFlare && this.ticksFlareUsing <= 0 && this.flareDelay <= 0 && !type.autoSmoke) {
          this.ticksFlareUsing = type.timeFlareUsing * 20;
          this.flareDelay = type.flareDelay;
          if (!type.epicShip)
            dischargeSmoke(); 
          if (this.field_70170_p.field_72995_K) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableKey(key));
          } else {
            dischargeSmoke();
            if (!type.flareSound.isEmpty())
              PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.flareSound, false); 
          } 
          return true;
        } 
        break;
      case 34:
        if (type.canRepair && this.ticksRepairing <= 0 && this.throttle <= 0.05D && !type.epicShip) {
          this.ticksRepairing = type.ticksRepairing;
          PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 10.0D, this.field_71093_bK, "Repair", false);
          if (this.field_70170_p.field_72995_K) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableKey(key));
          } else if (!type.flareSound.isEmpty()) {
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.flareSound, false);
          } 
          return true;
        } 
        break;
      case 37:
        this.pitchSignal++;
        break;
      case 38:
        this.pitchSignal--;
        break;
      case 39:
        this.yawSignal++;
        break;
      case 40:
        this.yawSignal--;
        break;
    } 
    return false;
  }
  
  public Vector3f getLookVector(ShootPoint dp) {
    return rotate((this.seats[0]).looking.getXAxis());
  }
  
  public void func_70071_h_() {
    double bkPrevPosY = this.field_70167_r;
    super.func_70071_h_();
    animateFancyTracks();
    if (this.field_70170_p.field_72995_K)
      for (Entity e : findEntitiesWithinbounds()) {
        if (e != this)
          moveRiders(e); 
      }  
    if (this.testerino > 5 && this.seats[0] != null)
      if (this.field_70170_p.field_72995_K)
        (this.seats[0]).field_70153_n = null;  
    if (Math.abs(this.pitchSignal) > 0.0F)
      this.pitchSignal *= 0.8F; 
    if (Math.abs(this.pitchSignal) > 0.0F && Math.abs(this.pitchSignal) < 0.5F)
      this.pitchSignal = 0.0F; 
    if (this.pitchSignal > 9.0F)
      this.pitchSignal = 9.0F; 
    if (this.pitchSignal < -9.0F)
      this.pitchSignal = -9.0F; 
    if (Math.abs(this.yawSignal) > 0.0F)
      this.yawSignal *= 0.8F; 
    if (Math.abs(this.yawSignal) > 0.0F && Math.abs(this.yawSignal) < 0.5F)
      this.yawSignal = 0.0F; 
    if (this.yawSignal > 9.0F)
      this.yawSignal = 9.0F; 
    if (this.yawSignal < -9.0F)
      this.yawSignal = -9.0F; 
    if (this.field_70173_aa == 5)
      this.driveableData.seatBelt = "null"; 
    if (this.field_70173_aa == 19 && ((getDriveableData()).seatBelt == null || (getDriveableData()).seatBelt.length() == 0))
      (getDriveableData()).seatBelt = "null"; 
    if (this.field_70173_aa > 20)
      if (this.seats[0] != null && (this.seats[0]).field_70153_n != null && (this.seats[0]).field_70153_n instanceof EntityPlayer) {
        EntityPlayer Master = (EntityPlayer)(this.seats[0]).field_70153_n;
        (getDriveableData()).emergencyMode = false;
      }  
    boolean isDivisibleBy10 = (this.field_70173_aa % 5 == 0);
    if ((getDriveableData()).emergencyMode && isDivisibleBy10) {
      List<Entity> foxes = this.field_70170_p.func_72839_b(this, AxisAlignedBB.func_72330_a(this.field_70165_t - 200.0D, this.field_70163_u - 500.0D, this.field_70161_v - 200.0D, this.field_70165_t + 200.0D, this.field_70163_u + 500.0D, this.field_70161_v + 200.0D));
      for (Entity stuff : foxes) {
        if (!(stuff instanceof EntityPlayer))
          continue; 
        EntityPlayer human = (EntityPlayer)stuff;
        if (this.field_70170_p.func_72924_a((getDriveableData()).seatBelt) == human)
          human.func_70078_a(this.seats[0]); 
      } 
    } 
    VehicleType type = getVehicleType();
    DriveableData data = getDriveableData();
    if (type == null) {
      FlansMod.log("Vehicle type null. Not ticking vehicle");
      return;
    } 
    if (this.throttle > 0.7D && (getDriveableType()).needsThrottle == true && this.leftMouseHeld && this.ramDelay <= 0)
      this.ramDelay = 20; 
    if (!type.marioKart) {
      if (this.throttle > 0.0F && !type.epicShip && !type.canDive && !type.airship)
        this.throttle -= type.accelModifier * 0.05F; 
      if (this.throttle < 0.0F && !type.epicShip && !type.canDive && !type.airship)
        this.throttle += type.decelModifier * 0.05F; 
      if (Math.abs(this.throttle) < 0.2D && Math.abs(this.throttle) > 0.0F && !type.epicShip && !type.canDive && !type.airship)
        this.throttle = (float)(this.throttle * 0.8D); 
    } 
    if (!type.epicShip && !type.canDive && !type.airship)
      if (this.throttlePeepee >= 0.05D) {
        if (this.throttle < 0.2D) {
          this.throttle = (float)(this.throttle + this.throttlePeepee * 0.15D);
        } else if (this.throttle >= 0.2D && this.throttle < 0.4D) {
          this.throttle = (float)(this.throttle + this.throttlePeepee * 0.05D);
        } else if (this.throttle >= 0.4D && this.throttle < 0.6D) {
          this.throttle = (float)(this.throttle + this.throttlePeepee * 0.015D);
        } else if (this.throttle >= 0.6D && this.throttle < 0.85D) {
          this.throttle = (float)(this.throttle + this.throttlePeepee * 0.005D);
        } else if (this.throttle >= 0.85D && this.throttle < 1.0F) {
          this.throttle = (float)(this.throttle + this.throttlePeepee * 0.001D);
        } 
      } else if (this.throttlePeepee < 0.05D && this.throttlePeepee > -0.05D) {
        this.throttle *= 0.75F;
      } else if (this.throttlePeepee <= -0.05D) {
        if (this.throttle > -0.2D) {
          this.throttle = (float)(this.throttle + this.throttlePeepee * 0.1D);
        } else if (this.throttle <= -0.2D && this.throttle > -0.4D) {
          this.throttle = (float)(this.throttle + this.throttlePeepee * 0.05D);
        } else if (this.throttle <= -0.4D && this.throttle > -0.6D) {
          this.throttle = (float)(this.throttle + this.throttlePeepee * 0.02D);
        } else if (this.throttle <= -0.6D && this.throttle > -0.85D) {
          this.throttle = (float)(this.throttle + this.throttlePeepee * 0.0025D);
        } else if (this.throttle <= -0.85D && this.throttle > -1.0F) {
          this.throttle = (float)(this.throttle + this.throttlePeepee * 5.0E-4D);
        } 
      }  
    this.throttlePeepee *= 0.55F;
    if (this.nintendoSwitchLite > 0) {
      this.nintendoSwitchLite--;
      this.nintendoSwitchLite--;
    } 
    boolean thePlayerIsDrivingThis = (this.field_70170_p.field_72995_K && this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)(this.seats[0]).field_70153_n));
    this.ticksSinceUsed++;
    if (!this.field_70170_p.field_72995_K && (this.seats[0]).field_70153_n != null)
      this.ticksSinceUsed = 0; 
    if (!this.field_70170_p.field_72995_K && TeamsManager.vehicleLife > 0 && this.ticksSinceUsed > TeamsManager.vehicleLife * 20)
      func_70106_y(); 
    if (this.field_70170_p.field_72995_K && (this.varFlare || this.ticksFlareUsing > type.timeFlareUsing * 20 - 5))
      if (this.field_70173_aa % 5 == 0) {
        if (!type.epicShip)
          this.deployedSmoke = true; 
        if (type.epicShip)
          this.repairing = true; 
      }  
    if (this.field_70170_p.field_72995_K && this.ticksRepairing > type.ticksRepairing - 5)
      if (this.field_70173_aa % 5 == 0)
        this.repairing = true;  
    if (type.setPlayerInvisible && !this.field_70170_p.field_72995_K && (this.seats[0]).field_70153_n != null)
      (this.seats[0]).field_70153_n.func_82142_c(true); 
    if (this.ticksFlareUsing <= 0 || this.ticksRepairing <= 0) {
      this.deployedSmoke = false;
      this.repairing = false;
    } 
    if (this.cringe < 5)
      this.cringe++; 
    if (this.cringe == 5)
      this.cringe = 0; 
    Material mat = this.field_70170_p.func_147439_a((int)this.field_70165_t, (int)this.field_70163_u - 1, (int)this.field_70161_v).func_149688_o();
    if (!type.epicShip)
      if (mat == Material.field_151578_c || mat == Material.field_151577_b || mat == Material.field_151595_p || mat == Material.field_151597_y || mat == Material.field_151596_z || mat == Material.field_151584_j || mat == Material.field_151579_a) {
        this.terrainFactor = type.terrainPenalty;
      } else {
        this.terrainFactor = 1.0F;
      }  
    if (this.exitTimer < type.exitTimer)
      this.exitTimer++; 
    if (this.exitTimer > type.exitTimer)
      this.exitTimer = type.exitTimer; 
    if (this.exitTimer < 0) {
      if (this.seats != null && this.seats[0] != null && (this.seats[0]).field_70153_n != null)
        (this.seats[0]).field_70153_n.func_70078_a(null); 
      this.exitTimer = type.exitTimer;
    } 
    if (type.raceCar)
      this.throttle = (float)(this.throttle * 0.9D); 
    float floatiness = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.buoyancy)).health / ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.buoyancy)).maxHealth * 1.0F;
    DriveablePart bow = (getDriveableData()).parts.get(EnumDriveablePart.bow);
    DriveablePart stern = (getDriveableData()).parts.get(EnumDriveablePart.stern);
    DriveablePart leftShip = (getDriveableData()).parts.get(EnumDriveablePart.left);
    DriveablePart right = (getDriveableData()).parts.get(EnumDriveablePart.right);
    DriveablePart midsection = (getDriveableData()).parts.get(EnumDriveablePart.midsection);
    if (floatiness < 0.1D && TeamsManager.seaLevel - this.field_70163_u > 1.0D)
      this.throttle = 0.0F; 
    if ((floatiness < 0.1D && TeamsManager.seaLevel - this.field_70163_u > 14.0D) || (TeamsManager.seaLevel - this.field_70163_u > 14.0D && bow.health <= 0 && bow.maxHealth > 0) || (TeamsManager.seaLevel - this.field_70163_u > 14.0D && stern.health <= 0 && stern.maxHealth > 0) || (TeamsManager.seaLevel - this.field_70163_u > 14.0D && leftShip.health <= 0 && leftShip.maxHealth > 0) || (TeamsManager.seaLevel - this.field_70163_u > 14.0D && right.health <= 0 && right.maxHealth > 0) || (TeamsManager.seaLevel - this.field_70163_u > 14.0D && midsection.health <= 0 && midsection.maxHealth > 0))
      this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u + 2.0D, this.field_70161_v, 1.0F, false); 
    if ((floatiness < 0.1D && TeamsManager.seaLevel - this.field_70163_u > 15.0D) || (TeamsManager.seaLevel - this.field_70163_u > 15.0D && bow.health <= 0 && bow.maxHealth > 0) || (TeamsManager.seaLevel - this.field_70163_u > 15.0D && stern.health <= 0 && stern.maxHealth > 0) || (TeamsManager.seaLevel - this.field_70163_u > 15.0D && leftShip.health <= 0 && leftShip.maxHealth > 0) || (TeamsManager.seaLevel - this.field_70163_u > 15.0D && right.health <= 0 && right.maxHealth > 0) || (TeamsManager.seaLevel - this.field_70163_u > 15.0D && midsection.health <= 0 && midsection.maxHealth > 0)) {
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t, this.field_70163_u, this.field_70161_v, 1, "shippuDeath"), this.field_70165_t, this.field_70163_u, this.field_70161_v, 200.0F, this.field_71093_bK);
      if (type.nuclearDeath == true) {
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t, this.field_70163_u, this.field_70161_v, 1, "nuclear"), this.field_70165_t, this.field_70163_u, this.field_70161_v, 400.0F, this.field_71093_bK);
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "YamatoGun", false);
      } 
      if (type.bigDeath == true) {
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t, this.field_70163_u, this.field_70161_v, 1, "shippuDeath"), this.field_70165_t, this.field_70163_u, this.field_70161_v, 200.0F, this.field_71093_bK);
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "BattleshipGun", false);
      } 
      if (type.Death == true) {
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t, this.field_70163_u, this.field_70161_v, 1, "tankkuDeath"), this.field_70165_t, this.field_70163_u, this.field_70161_v, 200.0F, this.field_71093_bK);
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "explcls6", false);
      } 
      func_70106_y();
    } 
    if ((bow.health <= 0 && bow.maxHealth > 0) || (stern.health <= 0 && stern.maxHealth > 0) || (leftShip.health <= 0 && leftShip.maxHealth > 0) || (right.health <= 0 && right.maxHealth > 0) || (midsection.health <= 0 && midsection.maxHealth > 0)) {
      this.deathTimer++;
    } else if (this.deathTimer > 0) {
      this.deathTimer--;
    } 
    if ((this.deathTimer > 1800 && bow.health <= 0 && bow.maxHealth > 0) || (this.deathTimer > 1200 && stern.health <= 0 && stern.maxHealth > 0) || (this.deathTimer > 1200 && leftShip.health <= 0 && leftShip.maxHealth > 0) || (this.deathTimer > 1200 && right.health <= 0 && right.maxHealth > 0) || (this.deathTimer > 1200 && midsection.health <= 0 && midsection.maxHealth > 0)) {
      if (type.nuclearDeath == true) {
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t, this.field_70163_u, this.field_70161_v, 1, "nuclear"), this.field_70165_t, this.field_70163_u, this.field_70161_v, 400.0F, this.field_71093_bK);
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "YamatoGun", false);
      } 
      if (type.bigDeath == true) {
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t, this.field_70163_u, this.field_70161_v, 1, "shippuDeath"), this.field_70165_t, this.field_70163_u, this.field_70161_v, 200.0F, this.field_71093_bK);
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "BattleshipGun", false);
      } 
      if (type.Death == true) {
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t, this.field_70163_u, this.field_70161_v, 1, "tankkuDeath"), this.field_70165_t, this.field_70163_u, this.field_70161_v, 200.0F, this.field_71093_bK);
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "explcls6", false);
      } 
      func_70106_y();
    } 
    this.totalCrewInfo = (getDriveableData()).totalCrew;
    if ((((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak)).maxHealth > 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak)).health <= 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).health > 0) || (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak2)).maxHealth > 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak2)).health <= 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).health > 0))
      if (this.cringe == 4) {
        ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).health -= ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).maxHealth / (int)(4.0F * type.WeakspotCookTime);
        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u + 3.0D, this.field_70161_v, 0.1F, false);
        for (int smoke = 0; smoke < 10; smoke++) {
          float smokeRand = (float)Math.random();
          if (smokeRand < 0.25D) {
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.flare", this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, ((float)Math.random() * smokeRand), ((float)Math.random() * smokeRand), ((float)Math.random() * smokeRand)), this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, 150.0F, this.field_70170_p.field_73011_w.field_76574_g);
          } else if (smokeRand > 0.25D && smokeRand < 0.5D) {
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.flare", this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, ((float)Math.random() * smokeRand), ((float)Math.random() * smokeRand), (-((float)Math.random()) * smokeRand)), this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, 150.0F, this.field_70170_p.field_73011_w.field_76574_g);
          } else if (smokeRand > 0.5D && smokeRand < 0.75D) {
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.flare", this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, (-((float)Math.random()) * smokeRand), ((float)Math.random() * smokeRand), (-((float)Math.random()) * smokeRand)), this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, 150.0F, this.field_70170_p.field_73011_w.field_76574_g);
          } else if (smokeRand > 0.75D) {
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.flare", this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, (-((float)Math.random()) * smokeRand), ((float)Math.random() * smokeRand), ((float)Math.random() * smokeRand)), this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, 150.0F, this.field_70170_p.field_73011_w.field_76574_g);
          } 
        } 
      }  
    if ((((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.weakSpot)).maxHealth > 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.weakSpot)).health <= 0) || (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.weakSpot2)).maxHealth > 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.weakSpot2)).health <= 0) || (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.weakSpot3)).maxHealth > 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.weakSpot3)).health <= 0) || (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).maxHealth > 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).health <= 0 && !type.epicShip && type.needsTurret))
      if (this.cringe == 4) {
        ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).health -= ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).maxHealth / (int)(4.0F * type.WeakspotCookTime);
        this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u + 2.0D, this.field_70161_v, 0.1F, false);
        for (int smoke = 0; smoke < 10; smoke++) {
          float smokeRand = (float)Math.random();
          if (smokeRand < 0.25D) {
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.flare", this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v, ((float)Math.random() * smokeRand), ((float)Math.random() * smokeRand), ((float)Math.random() * smokeRand)), this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, 150.0F, this.field_70170_p.field_73011_w.field_76574_g);
          } else if (smokeRand > 0.25D && smokeRand < 0.5D) {
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.flare", this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v, ((float)Math.random() * smokeRand), ((float)Math.random() * smokeRand), (-((float)Math.random()) * smokeRand)), this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, 150.0F, this.field_70170_p.field_73011_w.field_76574_g);
          } else if (smokeRand > 0.5D && smokeRand < 0.75D) {
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.flare", this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v, (-((float)Math.random()) * smokeRand), ((float)Math.random() * smokeRand), (-((float)Math.random()) * smokeRand)), this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, 150.0F, this.field_70170_p.field_73011_w.field_76574_g);
          } else if (smokeRand > 0.75D) {
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.flare", this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v, (-((float)Math.random()) * smokeRand), ((float)Math.random() * smokeRand), ((float)Math.random() * smokeRand)), this.field_70165_t, this.field_70163_u + 4.0D, this.field_70161_v, 150.0F, this.field_70170_p.field_73011_w.field_76574_g);
          } 
        } 
      }  
    if (this.ticksFlareUsing > 0)
      this.ticksFlareUsing--; 
    if (this.ticksRepairing > 0)
      this.ticksRepairing--; 
    if (this.repairDelay > 0)
      this.repairDelay--; 
    if (this.flareDelay > 0)
      this.flareDelay--; 
    if (this.ramDelay > 0) {
      if ((getDriveableType()).needsThrottle == true || type.bigRecoil)
        this.throttle = this.ramDelay * this.ramDelay * this.ramDelay * -1.25E-4F - 0.1F; 
      this.ramDelay--;
    } 
    if (this.nintendoSwitchLite < 10)
      this.nintendoSwitchLite++; 
    if (this.APSdelay > 0)
      this.APSdelay--; 
    if (this.APSdelay == type.APSdelayMax - 5)
      dischargeAPS(); 
    if (((getVehicleType()).canDive == true && this.oxygenMeter > 0.1F && this.divingFactor >= -1.0F && this.divingFactor < 0.0F) || ((getVehicleType()).airship == true && this.divingFactor > -1.0F && this.divingFactor < 0.0F))
      this.divingFactor += 0.01F; 
    if (((getVehicleType()).canDive == true && this.oxygenMeter > 0.1F && this.divingFactor <= 1.0F && this.divingFactor > 0.0F) || ((getVehicleType()).airship == true && this.divingFactor < 1.0F && this.divingFactor > 0.0F))
      this.divingFactor -= 0.01F; 
    if (this.shellDelay > 0)
      this.shellDelay--; 
    if (this.gunDelay > 0)
      this.gunDelay--; 
    if (this.toggleTimer > 0)
      this.toggleTimer--; 
    if (this.driveableData.thermalTimer > 0)
      this.driveableData.thermalTimer--; 
    if (this.driveableData.scopeTimer > 0)
      this.driveableData.scopeTimer--; 
    if (this.soundPosition > 0)
      this.soundPosition--; 
    if (this.idlePosition > 0)
      this.idlePosition--; 
    if (this.driveableData.thermalTimer == 9)
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 10.0D, this.field_71093_bK, "AnalogComputerSound", false); 
    if (this.driveableData.scopeTimer == 9)
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 10.0D, this.field_71093_bK, "tankSight", false); 
    if (type.tank && !hasBothTracks())
      this.throttle = 0.0F; 
    if (this.disabled)
      this.wheelsYaw = 0.0F; 
    if (!type.tank && !hasAllTyres())
      this.throttle = 0.0F; 
    if (hasEnoughFuel())
      this.wheelsAngle += this.throttle / 7.0F; 
    if (!this.varDoor) {
      this.doorPos = transformPart(this.doorPos, type.doorPos1, type.doorRate);
      this.doorRot = transformPart(this.doorRot, type.doorRot1, type.doorRotRate);
    } else {
      this.doorPos = transformPart(this.doorPos, type.doorPos2, type.doorRate);
      this.doorRot = transformPart(this.doorRot, type.doorRot2, type.doorRotRate);
    } 
    this.wheelsYaw *= 0.9F;
    if (this.wheelsYaw > 20.0F)
      this.wheelsYaw = 20.0F; 
    if (this.wheelsYaw < -20.0F)
      this.wheelsYaw = -20.0F; 
    if (this.field_70170_p.field_72995_K && !thePlayerIsDrivingThis)
      if (this.serverPositionTransitionTicker > 0) {
        double x = this.field_70165_t + (this.field_70118_ct - this.field_70165_t) / this.serverPositionTransitionTicker;
        double y = this.field_70163_u + (this.field_70117_cu - this.field_70163_u) / this.serverPositionTransitionTicker;
        double z = this.field_70161_v + (this.field_70116_cv - this.field_70161_v) / this.serverPositionTransitionTicker;
        double dYaw = MathHelper.func_76138_g(this.serverYaw - this.axes.getYaw());
        double dPitch = MathHelper.func_76138_g(this.serverPitch - this.axes.getPitch());
        double dRoll = MathHelper.func_76138_g(this.serverRoll - this.axes.getRoll());
        this.field_70177_z = (float)(this.axes.getYaw() + dYaw / this.serverPositionTransitionTicker);
        this.field_70125_A = (float)(this.axes.getPitch() + dPitch / this.serverPositionTransitionTicker);
        float rotationRoll = (float)(this.axes.getRoll() + dRoll / this.serverPositionTransitionTicker);
        this.serverPositionTransitionTicker--;
        func_70107_b(x, y, z);
        setRotation(this.field_70177_z, this.field_70125_A, rotationRoll);
      }  
    correctWheelPos();
    Vector3f amountToMoveCar = new Vector3f();
    for (EntityWheel wheel : this.wheels) {
      if (wheel != null) {
        double prevPosYWheel = wheel.field_70163_u;
        this.field_70122_E = true;
        wheel.field_70122_E = true;
        List<Entity> shipsCheck = this.field_70170_p.func_72872_a(Entity.class, wheel.field_70121_D);
        boolean onShip = false;
        for (Entity ship : shipsCheck) {
          if (getClass().toString().indexOf("cuchaz.ships.EntityShip") > 0) {
            wheel.field_70122_E = true;
            onShip = true;
          } 
        } 
        wheel.field_70177_z = this.axes.getYaw();
        if (!type.tank && (wheel.ID == 2 || wheel.ID == 3))
          wheel.field_70177_z += this.wheelsYaw; 
        wheel.field_70159_w *= 0.8999999761581421D;
        wheel.field_70181_x *= (this.field_70163_u - bkPrevPosY < 0.0D) ? 0.9990000128746033D : 0.8999999761581421D;
        wheel.field_70179_y *= 0.8999999761581421D;
        boolean canThrustCreatively = (!TeamsManager.vehiclesNeedFuel || (this.seats != null && this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d));
        if (canThrustCreatively || data.fuelInTank > data.engine.fuelConsumption * this.throttle)
          if ((getVehicleType()).tank) {
            boolean left = (wheel.ID == 0 || wheel.ID == 3);
            float turningDrag = 0.02F;
            wheel.field_70159_w *= (1.0F - Math.abs(this.wheelsYaw) * turningDrag);
            wheel.field_70179_y *= (1.0F - Math.abs(this.wheelsYaw) * turningDrag);
            float velocityScale = 0.04F * ((this.throttle > 0.0F) ? type.maxThrottle : type.maxNegativeThrottle) * data.engine.engineSpeed * this.terrainFactor;
            float steeringScale = 0.1F * ((this.wheelsYaw > 0.0F) ? type.turnLeftModifier : type.turnRightModifier);
            if ((isPartHealthy(EnumDriveablePart.leftTrack) && isPartHealthy(EnumDriveablePart.rightTrack)) || !isPartHealthy(EnumDriveablePart.engine))
              steeringScale = 0.0F; 
            float effectiveWheelSpeed = (this.throttle + this.wheelsYaw * (left ? true : -1) * steeringScale) * velocityScale;
            wheel.field_70159_w += effectiveWheelSpeed * Math.cos((wheel.field_70177_z * 3.1415927F / 180.0F));
            wheel.field_70179_y += effectiveWheelSpeed * Math.sin((wheel.field_70177_z * 3.1415927F / 180.0F));
            this.yawSpeed = (float)(this.yawSpeed + effectiveWheelSpeed * Math.sin((wheel.field_70177_z * 3.1415927F / 180.0F)));
          } else {
            float velocityScale = 0.1F * this.throttle * this.terrainFactor * ((this.throttle > 0.0F) ? type.maxThrottle : type.maxNegativeThrottle) * data.engine.engineSpeed;
            wheel.field_70159_w += Math.cos((wheel.field_70177_z * 3.1415927F / 180.0F)) * velocityScale;
            wheel.field_70179_y += Math.sin((wheel.field_70177_z * 3.1415927F / 180.0F)) * velocityScale;
            if (wheel.ID == 2 || wheel.ID == 3) {
              velocityScale = 0.01F * ((this.wheelsYaw > 0.0F) ? type.turnLeftModifier : type.turnRightModifier) * ((this.throttle > 0.0F) ? true : -1);
              wheel.field_70159_w -= wheel.getSpeedXZ() * Math.sin((wheel.field_70177_z * 3.1415927F / 180.0F)) * velocityScale * this.wheelsYaw;
              wheel.field_70179_y += wheel.getSpeedXZ() * Math.cos((wheel.field_70177_z * 3.1415927F / 180.0F)) * velocityScale * this.wheelsYaw;
            } else {
              wheel.field_70159_w *= 0.8999999761581421D;
              wheel.field_70179_y *= 0.8999999761581421D;
            } 
          }  
        wheel.func_70091_d(wheel.field_70159_w, wheel.field_70181_x, wheel.field_70179_y);
        Vector3f targetWheelPos = this.axes.findLocalVectorGlobally(((getVehicleType()).wheelPositions[wheel.ID]).position);
        Vector3f currentWheelPos = new Vector3f(wheel.field_70165_t - this.field_70165_t, wheel.field_70163_u - this.field_70163_u, wheel.field_70161_v - this.field_70161_v);
        Vector3f dPos = (Vector3f)Vector3f.sub(targetWheelPos, currentWheelPos, null).scale(type.wheelSpringStrength);
        if (dPos.length() > 0.001F) {
          wheel.func_70091_d(dPos.x, dPos.y, dPos.z);
          dPos.scale(0.5F);
          Vector3f.sub(amountToMoveCar, dPos, amountToMoveCar);
        } 
        float avgWheelHeight = 0.0F;
        if (this.wheels[0] != null && this.wheels[1] != null && this.wheels[2] != null && this.wheels[3] != null) {
          avgWheelHeight = (float)((this.wheels[0]).field_70165_t + (this.wheels[1]).field_70165_t + (this.wheels[2]).field_70165_t + (this.wheels[3]).field_70165_t) / 4.0F;
          if (!(this.wheels[0]).field_70122_E && !(this.wheels[1]).field_70122_E && !(this.wheels[2]).field_70122_E && !(this.wheels[3]).field_70122_E) {
            this.allWheelsOnGround = false;
          } else {
            this.allWheelsOnGround = true;
          } 
        } 
        float gas = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.gasbag)).health / ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.gasbag)).maxHealth * 1.0F;
        if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.gasbag)).maxHealth == 0)
          gas = 1.0F; 
        if (data.depth > 0.01D && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).health > 0.0F)
          data.depth = 0.0F; 
        if (TeamsManager.seaLevel - this.field_70163_u > 2.0D) {
          if (!type.unlimitedOxygen)
            this.oxygenMeter--; 
          if (this.oxygenMeter < 0.0F)
            this.oxygenMeter = 0.0F; 
        } 
        if (TeamsManager.seaLevel - this.field_70163_u < 2.0D && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).health > 0.0F) {
          this.oxygenMeter += 15.0F;
          if (this.oxygenMeter > type.maxOxygen)
            this.oxygenMeter = type.maxOxygen; 
        } 
        if (TeamsManager.seaLevel - this.field_70163_u > type.maxDepth && type.canDive == true)
          ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).health -= 10; 
        if (!type.floatOnWater && this.field_70170_p.func_72953_d(this.field_70121_D) && this.throttle > 0.1D)
          this.throttle = (float)(this.throttle - 0.001D); 
        if (!type.floatOnWater && this.field_70170_p.func_72953_d(this.field_70121_D) && this.throttle < -0.1D)
          this.throttle = (float)(this.throttle + 0.001D); 
        Random rand = new Random();
        if (!type.Stabilizer)
          if (this.throttle > 0.05D) {
            this.delay--;
            this.timer += 0.05D;
            this.timer %= 15.0D;
            this.jolt++;
            if (this.jolt > 0.8D) {
              this.jolt = 0.8D;
            } else {
              this.jolt = 0.0D;
            } 
            if (this.delay <= 0)
              this.delay = 1 + 2 * rand.nextInt(2); 
            float change = (float)(Math.PI * Math.cos(Math.PI * this.timer) / 180.0D * this.timer * this.jolt);
            (this.seats[0]).playerLooking.rotateLocalPitch(change * this.throttle * 2.0F);
          } else {
            this.jolt = 0.0D;
          }  
        DriveablePart buoyancy = (getDriveableData()).parts.get(EnumDriveablePart.buoyancy);
        if (type.epicShip && leftShip.health > 0 && right.health > 0 && bow.health > 0 && stern.health > 0) {
          this.roll = 0.0F;
          this.pitch = 0.0F;
        } 
        if (this.allWheelsOnGround && (!type.floatOnWater || !this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D))) && !wheel.onDeck && !type.canDive && !type.airship) {
          wheel.func_70091_d(0.0D, !this.onDeck ? -2.0D : 0.0D, 0.0D);
          if ((type.epicShip && floatiness < 0.1F) || (bow.maxHealth > 0 && bow.health <= 0) || (stern.maxHealth > 0 && stern.health <= 0) || (leftShip.maxHealth > 0 && leftShip.health <= 0) || (right.maxHealth > 0 && right.health <= 0) || (midsection.health <= 0 && midsection.maxHealth > 0))
            wheel.func_70091_d(0.0D, -0.19600000977516174D, 0.0D); 
        } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && !type.canDive && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && !wheel.onDeck) {
          if (!type.epicShip)
            wheel.func_70091_d(0.0D, 0.5D, 0.0D); 
          data.depth = 0.0F;
          if (type.epicShip && leftShip.maxHealth <= 0.0F && right.maxHealth <= 0.0F && bow.maxHealth <= 0.0F && stern.maxHealth <= 0.0F && midsection.maxHealth <= 0.0F) {
            wheel.func_70091_d(0.0D, 0.30000001192092896D * (1.1D * floatiness - 0.5D), 0.0D);
            data.depth = 0.0F;
          } else if ((type.epicShip && leftShip.health > 1.0F && leftShip.maxHealth > 0 && right.health > 1.0F && right.maxHealth > 1 && midsection.maxHealth <= 0 && bow.health > 1 && bow.maxHealth > 0 && stern.health > 0 && stern.maxHealth > 0) || (midsection.maxHealth > 0 && midsection.health > 1 && type.epicShip) || (type.epicShip && leftShip.maxHealth <= 0 && right.health > 1.0F && right.maxHealth <= 0 && midsection.maxHealth > 1 && midsection.health > 1 && bow.health > 1 && bow.maxHealth > 0 && stern.health > 0 && stern.maxHealth > 0)) {
            wheel.func_70091_d(0.0D, 0.30000001192092896D * (1.1D * floatiness - 0.5D), 0.0D);
            data.depth = 0.0F;
          } else {
            wheel.func_70091_d(0.0D, -0.009000000543892384D, 0.0D);
            if (leftShip.health <= 0 && right.health > 0 && this.roll < 1.5F)
              this.roll += 5.0E-4F; 
            if (right.health <= 0 && leftShip.health > 0 && this.roll > -1.5F)
              this.roll -= 5.0E-4F; 
            if (bow.health <= 0 && stern.health > 0 && this.pitch < 0.6F)
              this.pitch += 2.5E-4F; 
            if (stern.health <= 0 && bow.health > 0 && this.pitch > -0.6F)
              this.pitch -= 2.5E-4F; 
          } 
        } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && type.canDive == true && !type.airship && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && this.divingFactor > 0.0F && (this.seats[0]).field_70153_n instanceof EntityPlayer && this.oxygenMeter > 0.1F) {
          wheel.func_70091_d(0.0D, type.surfaceSpeed * 0.5D * this.divingFactor, 0.0D);
          data.depth = (float)(data.depth + type.surfaceSpeed * 0.5D * this.divingFactor * 0.16666D);
        } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && type.canDive == true && !type.airship && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && this.divingFactor > 0.0F && (this.seats[0]).field_70153_n instanceof EntityPlayer && this.oxygenMeter < 0.1F) {
          wheel.func_70091_d(0.0D, type.surfaceSpeed * 0.5D * 1.0D, 0.0D);
          data.depth = (float)(data.depth + type.surfaceSpeed * 0.5D * 1.0D * 0.16666D);
        } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && type.canDive == true && !type.airship && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && this.divingFactor < 0.0F && (this.seats[0]).field_70153_n instanceof EntityPlayer && this.oxygenMeter > 0.1F) {
          wheel.func_70091_d(0.0D, type.diveSpeed * 0.5D * this.divingFactor, 0.0D);
          data.depth = (float)(data.depth + type.diveSpeed * 0.5D * this.divingFactor * 0.16666D);
        } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && type.canDive == true && !type.airship && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && this.divingFactor < 0.0F && (this.seats[0]).field_70153_n instanceof EntityPlayer && this.oxygenMeter < 0.1F) {
          wheel.func_70091_d(0.0D, type.diveSpeed * 0.5D * 1.0D, 0.0D);
          data.depth = (float)(data.depth + type.diveSpeed * 0.5D * 1.0D * 0.16666D);
        } else if (!this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && !type.canDive && type.airship == true && !this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && this.divingFactor > 0.1D && this.field_70163_u < type.maxAltitude && (this.seats[0]).field_70153_n instanceof EntityPlayer) {
          wheel.func_70091_d(0.0D, this.divingFactor * type.surfaceSpeed * 0.5D * (2.0F * gas - 1.0F), 0.0D);
        } else if (!this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && !type.canDive && type.airship == true && !this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && this.divingFactor < -0.1D && (this.seats[0]).field_70153_n instanceof EntityPlayer) {
          wheel.func_70091_d(0.0D, this.divingFactor * type.diveSpeed * 0.5D * (2.0F - gas * 1.0F), 0.0D);
        } else if (!this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && !type.canDive && type.airship == true && !this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && this.divingFactor > -0.1D && this.divingFactor < 0.1D) {
          wheel.func_70091_d(0.0D, 0.5D * (gas - 1.0F), 0.0D);
        } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && type.canDive == true && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && this.oxygenMeter > 0.1F) {
          wheel.func_70091_d(0.0D, 0.0D, 0.0D);
        } else if (type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && type.canDive == true && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && this.oxygenMeter < 0.1F) {
          wheel.func_70091_d(0.0D, type.surfaceSpeed * 0.6D * 1.0D, 0.0D);
        } else if ((type.floatOnWater && this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, -type.floatOffset, 0.0D)) && !this.field_70170_p.func_72953_d(wheel.field_70121_D.func_72329_c().func_72317_d(0.0D, (1.0F - type.floatOffset), 0.0D)) && !type.canDive) || (wheel.onDeck && !type.canDive)) {
          if (!type.epicShip) {
            wheel.func_70091_d(0.0D, 0.0D, 0.0D);
            this.roll = 0.0F;
            this.pitch = 0.0F;
          } 
          if (type.epicShip && floatiness >= 0.1D)
            wheel.func_70091_d(0.0D, 0.0D, 0.0D); 
          if ((type.epicShip && floatiness < 0.1D) || (type.epicShip && bow.maxHealth > 0 && bow.health <= 0) || (type.epicShip && stern.maxHealth > 0 && stern.health <= 0) || (type.epicShip && leftShip.maxHealth > 0 && leftShip.health <= 0) || (type.epicShip && right.maxHealth > 0 && right.health <= 0) || (midsection.health <= 0 && midsection.maxHealth > 0))
            wheel.func_70091_d(0.0D, -0.5D, 0.0D); 
        } else if (wheel.onDeck && type.canDive == true && this.divingFactor < 0.0F) {
          this.divingFactor = -0.3F;
          data.depth = 0.0F;
          this.roll = 0.0F;
          this.pitch = 0.0F;
        } else {
          wheel.func_70091_d(0.0D, !this.onDeck ? -0.9800000190734863D : 0.0D, 0.0D);
        } 
        if ((this.throttle >= 1.1D || this.throttle <= -1.1D) && wheel.getSpeedXYZ() <= (getAvgWheelSpeedXYZ() / 1.0F))
          this.throttle = 1.0F; 
      } 
    } 
    if (this.wheels[0] != null && this.wheels[1] != null && this.wheels[2] != null && this.wheels[3] != null) {
      this.lastPos.x = (float)((this.wheels[0]).field_70159_w + (this.wheels[1]).field_70159_w + (this.wheels[2]).field_70159_w + (this.wheels[3]).field_70159_w) / 4.0F;
      this.lastPos.y = (float)((this.wheels[0]).field_70181_x + (this.wheels[1]).field_70181_x + (this.wheels[2]).field_70181_x + (this.wheels[3]).field_70181_x) / 4.0F;
      this.lastPos.z = (float)((this.wheels[0]).field_70179_y + (this.wheels[1]).field_70179_y + (this.wheels[2]).field_70179_y + (this.wheels[3]).field_70179_y) / 4.0F;
    } 
    double bmy = this.field_70181_x;
    this.field_70181_x = amountToMoveCar.y;
    func_70091_d(amountToMoveCar.x, amountToMoveCar.y, amountToMoveCar.z);
    this.field_70181_x = bmy;
    if (this.wheels[0] != null && this.wheels[1] != null && this.wheels[2] != null && this.wheels[3] != null) {
      Vector3f frontAxleCentre = new Vector3f(((this.wheels[2]).field_70165_t + (this.wheels[3]).field_70165_t) / 2.0D, ((this.wheels[2]).field_70163_u + (this.wheels[3]).field_70163_u) / 2.0D, ((this.wheels[2]).field_70161_v + (this.wheels[3]).field_70161_v) / 2.0D);
      Vector3f backAxleCentre = new Vector3f(((this.wheels[0]).field_70165_t + (this.wheels[1]).field_70165_t) / 2.0D, ((this.wheels[0]).field_70163_u + (this.wheels[1]).field_70163_u) / 2.0D, ((this.wheels[0]).field_70161_v + (this.wheels[1]).field_70161_v) / 2.0D);
      Vector3f leftSideCentre = new Vector3f(((this.wheels[0]).field_70165_t + (this.wheels[3]).field_70165_t) / 2.0D, ((this.wheels[0]).field_70163_u + (this.wheels[3]).field_70163_u) / 2.0D, ((this.wheels[0]).field_70161_v + (this.wheels[3]).field_70161_v) / 2.0D);
      Vector3f rightSideCentre = new Vector3f(((this.wheels[1]).field_70165_t + (this.wheels[2]).field_70165_t) / 2.0D, ((this.wheels[1]).field_70163_u + (this.wheels[2]).field_70163_u) / 2.0D, ((this.wheels[1]).field_70161_v + (this.wheels[2]).field_70161_v) / 2.0D);
      float dx = frontAxleCentre.x - backAxleCentre.x;
      float dy = frontAxleCentre.y - backAxleCentre.y;
      float dz = frontAxleCentre.z - backAxleCentre.z;
      float drx = leftSideCentre.x - rightSideCentre.x;
      float dry = leftSideCentre.y - rightSideCentre.y;
      float drz = leftSideCentre.z - rightSideCentre.z;
      float dxz = (float)Math.sqrt((dx * dx + dz * dz));
      float drxz = (float)Math.sqrt((drx * drx + drz * drz));
      float tyaw = (float)Math.atan2(dz, dx);
      float tpitch = -((float)Math.atan2(dy, dxz));
      float troll = 0.0F;
      if (type.canRoll)
        troll = -((float)Math.atan2(dry, drxz)); 
      this.yaw = tyaw;
      this.pitch = Lerp(this.pitch, tpitch, 0.2F);
      this.roll = Lerp(this.roll, troll, 0.2F);
      float engineHealthTwo = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine)).health / ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine)).maxHealth * 1.0F;
      if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine)).maxHealth == 0)
        engineHealthTwo = 1.0F; 
      if (type.epicShip) {
        float velocityScale = 0.04F * ((this.throttle > 0.0F) ? type.maxThrottle : type.maxNegativeThrottle) * data.engine.engineSpeed;
        float steeringScale = 0.040000003F * ((this.wheelsYaw > 0.0F) ? type.turnLeftModifier : type.turnRightModifier);
        float effectiveWheelSpeed = this.wheelsYaw * steeringScale * velocityScale;
        this.yaw = this.axes.getYaw() / 180.0F * 3.14159F + effectiveWheelSpeed;
      } else {
        float velocityScale = 0.1F * this.throttle * ((this.throttle > 0.0F) ? type.maxThrottle : type.maxNegativeThrottle) * data.engine.engineSpeed;
        float velocityScaleTank = 0.1F * (0.5F + 0.5F * this.throttle) * ((this.throttle > 0.0F) ? type.maxThrottle : type.maxNegativeThrottle) * data.engine.engineSpeed;
        if (this.throttle < 0.0F)
          velocityScaleTank = -0.1F * (-0.5F + 0.5F * this.throttle) * ((this.throttle > 0.0F) ? type.maxThrottle : type.maxNegativeThrottle) * data.engine.engineSpeed; 
        if ((!isPartHealthy(EnumDriveablePart.leftTrack) && !isPartHealthy(EnumDriveablePart.rightTrack)) || this.ticksRepairing > 0 || !isPartHealthy(EnumDriveablePart.engine))
          velocityScaleTank = 0.0F; 
        float steeringScale = 0.1F * ((this.wheelsYaw > 0.0F) ? (type.turnLeftModifier * 0.5F) : (type.turnRightModifier * 0.5F));
        if (type.epicShip)
          steeringScale = 0.040000003F * ((this.wheelsYaw > 0.0F) ? type.turnLeftModifier : type.turnRightModifier); 
        float effectiveWheelSpeed = this.wheelsYaw * steeringScale * velocityScale;
        if (type.tank)
          effectiveWheelSpeed = this.wheelsYaw * steeringScale * velocityScaleTank; 
        this.yaw = this.axes.getYaw() / 180.0F * 3.14159F + effectiveWheelSpeed;
      } 
      this.axes.setAngles(this.yaw * 180.0F / 3.14159F, this.pitch * 180.0F / 3.14159F, this.roll * 180.0F / 3.14159F);
    } 
    if (this.field_70154_o != null)
      if (this.field_70154_o.getClass().toString().indexOf("mcheli.aircraft.MCH_EntitySeat") > 0)
        this.axes.setAngles(this.field_70154_o.field_70177_z + 90.0F, 0.0F, 0.0F);  
    checkForCollisions();
    if (Math.abs(this.throttle) > 0.01F && Math.abs(this.throttle) < 0.2F && this.soundPosition == 0 && hasEnoughFuel()) {
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, type.startSoundRange, this.field_71093_bK, type.startSound, false);
      this.soundPosition = type.startSoundLength;
    } 
    if (this.throttle >= 0.2F && this.soundPosition == 0 && hasEnoughFuel()) {
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, type.engineSoundRange, this.field_71093_bK, type.engineSound, false);
      this.soundPosition = type.engineSoundLength;
    } 
    if (this.seats[0] != null && 
      this.throttle <= 0.01F && this.throttle >= -0.2F && (this.seats[0]).field_70153_n != null && this.idlePosition == 0) {
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, type.engineSoundRange, this.field_71093_bK, type.idleSound, false);
      this.idlePosition = type.idleSoundLength;
    } 
    if (this.throttle <= -0.2F && this.soundPosition == 0 && hasEnoughFuel()) {
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, type.backSoundRange, this.field_71093_bK, type.backSound, false);
      this.soundPosition = type.backSoundLength;
    } 
    for (EntitySeat seat : this.seats) {
      if ((seat != null && seat.field_70153_n != null && seat.field_70153_n instanceof EntityPlayer) || (seat != null && seat.field_70153_n != null && this.field_70173_aa % 4 == 0) || (seat != null && seat.field_70153_n == null && this.field_70173_aa % 10 == 0))
        seat.updatePosition(); 
    } 
    int packetRate = 6;
    if (thePlayerIsDrivingThis && this.field_70173_aa % 2 == 0) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketVehicleControl(this));
      this.field_70118_ct = this.field_70165_t;
      this.field_70117_cu = this.field_70163_u;
      this.field_70116_cv = this.field_70161_v;
      this.serverYaw = this.axes.getYaw();
    } 
    if (!this.field_70170_p.field_72995_K && this.field_70173_aa % packetRate == 0)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketVehicleControl(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, FlansMod.driveableUpdateRange, this.field_71093_bK); 
    int animSpeed = 4;
    if ((this.throttle > 0.05D && this.throttle <= 0.33D) || (this.throttle < -0.05D && this.throttle >= -0.33D)) {
      animSpeed = 3;
    } else if ((this.throttle > 0.33D && this.throttle <= 0.66D) || (this.throttle < -0.33D && this.throttle >= -0.66D)) {
      animSpeed = 2;
    } else if ((this.throttle > 0.66D && this.throttle <= 0.9D) || (this.throttle < -0.66D && this.throttle >= -0.9D)) {
      animSpeed = 1;
    } else if ((this.throttle > 0.9D && this.throttle <= 1.0F) || (this.throttle < -0.9D && this.throttle >= -1.0F)) {
      animSpeed = 0;
    } 
    boolean turningLeft = false;
    boolean turningRight = false;
    if (this.throttle > 0.05D) {
      this.animCountLeft--;
      this.animCountRight--;
    } else if (this.throttle < -0.05D) {
      this.animCountLeft++;
      this.animCountRight++;
    } else if (this.wheelsYaw < -1.0F) {
      turningLeft = true;
      this.animCountLeft++;
      this.animCountRight--;
      animSpeed = 1;
      if (this.soundPosition == 0 && hasEnoughFuel() && type.tank) {
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, type.engineSoundRange, this.field_71093_bK, type.engineSound, false);
        this.soundPosition = type.engineSoundLength;
      } 
    } else if (this.wheelsYaw > 1.0F) {
      turningRight = true;
      this.animCountLeft--;
      this.animCountRight++;
      animSpeed = 1;
      if (this.soundPosition == 0 && hasEnoughFuel() && type.tank) {
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, type.engineSoundRange, this.field_71093_bK, type.engineSound, false);
        this.soundPosition = type.engineSoundLength;
      } 
    } else {
      turningLeft = false;
      turningRight = false;
    } 
    if (this.animCountLeft <= 0) {
      this.animCountLeft = animSpeed;
      this.animFrameLeft++;
    } 
    if (this.animCountRight <= 0) {
      this.animCountRight = animSpeed;
      this.animFrameRight++;
    } 
    if ((this.throttle < 0.0F || turningLeft) && 
      this.animCountLeft >= animSpeed) {
      this.animCountLeft = 0;
      this.animFrameLeft--;
    } 
    if ((this.throttle < 0.0F || turningRight) && 
      this.animCountRight >= animSpeed) {
      this.animCountRight = 0;
      this.animFrameRight--;
    } 
    if (this.animFrameLeft > type.animFrames)
      this.animFrameLeft = 0; 
    if (this.animFrameLeft < 0)
      this.animFrameLeft = type.animFrames; 
    if (this.animFrameRight > type.animFrames)
      this.animFrameRight = 0; 
    if (this.animFrameRight < 0)
      this.animFrameRight = type.animFrames; 
  }
  
  private void interrupt(float f) {}
  
  public void rebirthVehicle() {
    VehicleType typo = getVehicleType();
    ItemStack vehicleStack = new ItemStack(typo.item, 1, this.driveableData.paintjobID);
    vehicleStack.field_77990_d = new NBTTagCompound();
    for (EntitySeat seat : this.seats) {
      if (seat != null && 
        seat.field_70153_n != null && seat.field_70153_n instanceof EntityPlayerMP) {
        EntityPlayerMP human = (EntityPlayerMP)seat.field_70153_n;
        human.field_71135_a.func_147360_c("Seat kick detected?! Let's hope you brought a rifle!");
      } 
    } 
    this.driveableData.writeToNBT(vehicleStack.field_77990_d);
    ((ItemVehicle)vehicleStack.func_77973_b()).spawnVehicleAngled(this.field_70170_p, this.field_70165_t + 0.5D, this.field_70163_u + 0.5D, this.field_70161_v + 0.5D, this.axes.getYaw(), vehicleStack);
    System.out.println("rebirth attemtped!");
    for (EntitySeat seat : this.seats) {
      if (seat != null)
        seat.func_70106_y(); 
    } 
    for (EntityWheel wheel : this.wheels) {
      if (wheel != null)
        wheel.func_70106_y(); 
    } 
    func_70106_y();
  }
  
  public void animateFancyTracks() {
    float funkypart = (getVehicleType()).trackLinkFix;
    boolean funk = true;
    float funk2 = 0.0F;
    int i;
    for (i = 0; i < this.trackLinksLeft.length; i++) {
      (this.trackLinksLeft[i]).prevPosition = (this.trackLinksLeft[i]).position;
      (this.trackLinksLeft[i]).prevZRot = (this.trackLinksLeft[i]).zRot;
      float speed = this.throttle * 1.5F - this.wheelsYaw / 12.0F;
      (this.trackLinksLeft[i]).progress += speed;
      if ((this.trackLinksLeft[i]).progress > this.leftTrack.getTrackLength())
        (this.trackLinksLeft[i]).progress -= this.leftTrack.getTrackLength(); 
      if ((this.trackLinksLeft[i]).progress < 0.0F)
        (this.trackLinksLeft[i]).progress += this.leftTrack.getTrackLength(); 
      (this.trackLinksLeft[i]).position = this.leftTrack.getPositionOnTrack((this.trackLinksLeft[i]).progress);
      for (; (this.trackLinksLeft[i]).zRot > 180.0F; (this.trackLinksLeft[i]).zRot -= 360.0F);
      for (; (this.trackLinksLeft[i]).zRot <= -180.0F; (this.trackLinksLeft[i]).zRot += 360.0F);
      float newAngle = rotateTowards(this.leftTrack.points.get(this.leftTrack.getTrackPart((this.trackLinksLeft[i]).progress)), (this.trackLinksLeft[i]).position);
      int part = this.leftTrack.getTrackPart((this.trackLinksLeft[i]).progress);
      if (funk) {
        funk2 = (speed < 0.0F) ? 0.0F : 1.0F;
      } else {
        funk2 = (speed < 0.0F) ? -1.0F : 0.0F;
      } 
      (this.trackLinksLeft[i]).zRot = Lerp((this.trackLinksLeft[i]).zRot, newAngle, (part != funkypart + funk2) ? 0.5F : 1.0F);
    } 
    for (i = 0; i < this.trackLinksRight.length; i++) {
      (this.trackLinksRight[i]).prevPosition = (this.trackLinksRight[i]).position;
      (this.trackLinksRight[i]).prevZRot = (this.trackLinksRight[i]).zRot;
      float speed = this.throttle * 1.5F + this.wheelsYaw / 12.0F;
      (this.trackLinksRight[i]).progress += speed;
      if ((this.trackLinksRight[i]).progress > this.rightTrack.getTrackLength())
        (this.trackLinksRight[i]).progress -= this.leftTrack.getTrackLength(); 
      if ((this.trackLinksRight[i]).progress < 0.0F)
        (this.trackLinksRight[i]).progress += this.rightTrack.getTrackLength(); 
      (this.trackLinksRight[i]).position = this.rightTrack.getPositionOnTrack((this.trackLinksRight[i]).progress);
      float newAngle = rotateTowards(this.rightTrack.points.get(this.rightTrack.getTrackPart((this.trackLinksRight[i]).progress)), (this.trackLinksRight[i]).position);
      int part = this.rightTrack.getTrackPart((this.trackLinksRight[i]).progress);
      if (funk) {
        funk2 = (speed < 0.0F) ? 0.0F : 1.0F;
      } else {
        funk2 = (speed < 0.0F) ? -1.0F : 0.0F;
      } 
      (this.trackLinksRight[i]).zRot = Lerp((this.trackLinksRight[i]).zRot, newAngle, (part != funkypart + funk2) ? 0.5F : 1.0F);
    } 
  }
  
  public float rotateTowards(Vector3f point, Vector3f original) {
    float angle = (float)Math.atan2((point.y - original.y), (point.x - original.x));
    return angle;
  }
  
  public void dischargeSmoke() {
    VehicleType type = getVehicleType();
    for (int i = 0; i < type.smokers.size(); i++) {
      VehicleType.SmokePoint smoker = type.smokers.get(i);
      Vector3f dir = smoker.direction;
      Vector3f pos = smoker.position;
      int time = smoker.detTime;
      dir = this.axes.findLocalVectorGlobally(dir);
      pos = this.axes.findLocalVectorGlobally(pos);
      if (EnumDriveablePart.getPart(smoker.part) == EnumDriveablePart.turret) {
        dir = rotate((this.seats[0]).looking.findLocalVectorGlobally(smoker.direction));
        pos = getPositionOnTurret(smoker.position, false);
      } 
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.smoker", this.field_70165_t + (pos.x / 16.0F), this.field_70163_u + (pos.y / 16.0F), this.field_70161_v + (pos.z / 16.0F), dir.x, dir.y, dir.z), this.field_70165_t, this.field_70163_u, this.field_70161_v, 150.0F, this.field_71093_bK);
    } 
  }
  
  public void dischargeAPS() {
    VehicleType type = getVehicleType();
    for (int i = 0; i < type.smokers.size(); i++) {
      VehicleType.SmokePoint smoker = type.smokers.get(i);
      Vector3f dir = smoker.direction;
      Vector3f pos = smoker.position;
      int time = smoker.detTime;
      dir = this.axes.findLocalVectorGlobally(dir);
      pos = this.axes.findLocalVectorGlobally(pos);
      if (EnumDriveablePart.getPart(smoker.part) == EnumDriveablePart.turret) {
        dir = rotate((this.seats[0]).looking.findLocalVectorGlobally(smoker.direction));
        pos = getPositionOnTurret(smoker.position, false);
      } 
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.smokeburst", this.field_70165_t + (pos.x / 10.0F), this.field_70163_u + (pos.y / 10.0F), this.field_70161_v + (pos.z / 10.0F), dir.x, dir.y, dir.z), this.field_70165_t, this.field_70163_u, this.field_70161_v, 150.0F, this.field_71093_bK);
    } 
  }
  
  public float Lerp(float start, float end, float percent) {
    float result = start + percent * (end - start);
    return result;
  }
  
  public static float Clamp(float val, float min, float max) {
    return Math.max(min, Math.min(max, val));
  }
  
  public List<Entity> findEntitiesWithinbounds() {
    VehicleType type = getVehicleType();
    AxisAlignedBB initialBox = this.field_70121_D.func_72329_c();
    List<Entity> riddenEntities = this.field_70170_p.func_72872_a(Entity.class, initialBox);
    Vector3f size = new Vector3f(type.harvestBoxSize.x / 8.0F, type.harvestBoxSize.y / 8.0F, type.harvestBoxSize.z / 8.0F);
    Vector3f pos = new Vector3f(type.harvestBoxPos.x / 8.0F, type.harvestBoxPos.y / 8.0F, type.harvestBoxPos.z / 8.0F);
    float x;
    for (x = pos.x; x <= pos.x + size.x; x++) {
      float y;
      for (y = pos.y; y <= pos.y + size.y; y++) {
        float z;
        for (z = pos.z; z <= pos.z + size.z; z++) {
          Vector3f v = this.axes.findLocalVectorGlobally(new Vector3f(x, y, z));
          double entX = this.field_70165_t + v.x;
          double entY = this.field_70163_u + v.y;
          double entZ = this.field_70161_v + v.z;
          AxisAlignedBB checkBox = this.field_70121_D.func_72329_c().func_72317_d(v.x, v.y, v.z);
          List<Entity> entityhere = this.field_70170_p.func_72872_a(Entity.class, checkBox);
          for (int i = 0; i < entityhere.size(); i++) {
            if (entityhere.get(i) instanceof net.minecraft.entity.EntityLivingBase)
              riddenEntities.add(entityhere.get(i)); 
          } 
        } 
      } 
    } 
    return riddenEntities;
  }
  
  public Vector3f transformPart(Vector3f current, Vector3f target, Vector3f rate) {
    Vector3f newPos = current;
    if (Math.sqrt(((current.x - target.x) * (current.x - target.x))) > (rate.x / 2.0F)) {
      if (current.x > target.x) {
        current.x -= rate.x;
      } else if (current.x < target.x) {
        current.x += rate.x;
      } 
    } else {
      current.x = target.x;
    } 
    if (Math.sqrt(((current.y - target.y) * (current.y - target.y))) > (rate.y / 2.0F)) {
      if (current.y > target.y) {
        current.y -= rate.y;
      } else if (current.y < target.y) {
        current.y += rate.y;
      } 
    } else {
      current.y = target.y;
    } 
    if (Math.sqrt(((current.z - target.z) * (current.z - target.z))) > (rate.z / 2.0F)) {
      if (current.z > target.z) {
        current.z -= rate.z;
      } else if (current.z < target.z) {
        current.z += rate.z;
      } 
    } else {
      current.z = target.z;
    } 
    return newPos;
  }
  
  protected void func_70069_a(float k) {
    if (k <= 20.0F)
      return; 
    float damage = (MathHelper.func_76123_f(k) * 2);
    boolean no_damage = true;
    if (damage > 0.0F && this.invulnerableUnmountCount == 0 && this.field_70173_aa > 20) {
      DriveableType type = getDriveableType();
      damage = (int)(damage * type.fallDamageFactor) * 0.25F;
      ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).health -= (int)damage + 1;
      if (type.wheelPositions.length > 0)
        attackPart((type.wheelPositions[0]).part, DamageSource.field_76379_h, damage / 5.0F); 
      no_damage = false;
    } 
  }
  
  private float averageAngles(float a, float b) {
    FlansMod.log("Pre  " + a + " " + b);
    float pi = 3.1415927F;
    for (; a > b + pi; a -= 2.0F * pi);
    for (; a < b - pi; a += 2.0F * pi);
    float avg = (a + b) / 2.0F;
    for (; avg > pi; avg -= 2.0F * pi);
    for (; avg < -pi; avg += 2.0F * pi);
    FlansMod.log("Post " + a + " " + b + " " + avg);
    return avg;
  }
  
  private Vec3 subtract(Vec3 a, Vec3 b) {
    return Vec3.func_72443_a(a.field_72450_a - b.field_72450_a, a.field_72448_b - b.field_72448_b, a.field_72449_c - b.field_72449_c);
  }
  
  private Vec3 crossProduct(Vec3 a, Vec3 b) {
    return Vec3.func_72443_a(a.field_72448_b * b.field_72449_c - a.field_72449_c * b.field_72448_b, a.field_72449_c * b.field_72450_a - a.field_72450_a * b.field_72449_c, a.field_72450_a * b.field_72448_b - a.field_72448_b * b.field_72450_a);
  }
  
  public boolean landVehicle() {
    return true;
  }
  
  public boolean func_70097_a(DamageSource damagesource, float i) {
    VehicleType type = getVehicleType();
    if (this.field_70170_p.field_72995_K || this.field_70128_L || damagesource.field_76373_n.equals("onFire") || damagesource.field_76373_n.equals("inFire") || damagesource.field_76373_n.equals("lava") || damagesource.field_76373_n.equals("arrow") || damagesource.field_76373_n.equals("arrow") || (!type.vanillaDamage && damagesource.field_76373_n.equals("player") && this.seats[0] != null && (this.seats[0]).field_70153_n != null))
      return true; 
    if (damagesource.field_76373_n.equals("player") && (damagesource.func_76346_g()).field_70122_E && (this.seats[0] == null || (this.seats[0]).field_70153_n == null) && !this.locked && !type.unpunchable) {
      this.driveableData.seatBelt = "null";
      ItemStack vehicleStack = new ItemStack(type.item, 1, this.driveableData.paintjobID);
      vehicleStack.field_77990_d = new NBTTagCompound();
      this.driveableData.writeToNBT(vehicleStack.field_77990_d);
      func_70099_a(vehicleStack, 0.5F);
      func_70106_y();
    } 
    float poopoo = 1.0F;
    if (damagesource.field_76373_n.equals("explosion"))
      poopoo = type.explosionResistance; 
    return super.func_70097_a(damagesource, i * poopoo);
  }
  
  public VehicleType getVehicleType() {
    return VehicleType.getVehicle(this.driveableType);
  }
  
  public float getPlayerRoll() {
    return this.axes.getRoll();
  }
  
  public float getAvgWheelSpeedXYZ() {
    float speed = (float)(this.wheels[0].getSpeedXYZ() + this.wheels[1].getSpeedXYZ() + this.wheels[2].getSpeedXYZ() + this.wheels[3].getSpeedXYZ()) / 4.0F;
    return speed;
  }
  
  public void Recoil() {}
  
  protected void dropItemsOnPartDeath(Vector3f midpoint, DriveablePart part) {}
  
  public String getBombInventoryName() {
    return "Mines";
  }
  
  public String getMissileInventoryName() {
    return "Shells";
  }
  
  public boolean hasMouseControlMode() {
    return false;
  }
  
  public boolean hasAllTyres() {
    boolean tyres = true;
    if (!isPartHealthy(EnumDriveablePart.frontLeftWheel))
      tyres = false; 
    if (!isPartHealthy(EnumDriveablePart.frontRightWheel))
      tyres = false; 
    if (!isPartHealthy(EnumDriveablePart.backLeftWheel))
      tyres = false; 
    if (!isPartHealthy(EnumDriveablePart.backRightWheel))
      tyres = false; 
    return tyres;
  }
  
  public boolean hasBothTracks() {
    boolean tracks = true;
    if (!isPartHealthy(EnumDriveablePart.leftTrack))
      tracks = false; 
    if (!isPartHealthy(EnumDriveablePart.rightTrack))
      tracks = false; 
    return tracks;
  }
  
  public void func_70106_y() {
    super.func_70106_y();
    for (EntityWheel wheel : this.wheels) {
      if (wheel != null)
        wheel.func_70106_y(); 
    } 
  }
}
