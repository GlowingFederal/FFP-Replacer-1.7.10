package com.flansmod.common.driveables;

import com.flansmod.api.IControllable;
import com.flansmod.client.FlansModClient;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.guns.EnumFireMode;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.guns.ItemShootable;
import com.flansmod.common.guns.ShootableType;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketDriveableKey;
import com.flansmod.common.network.PacketDriveableKeyHeld;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.network.PacketSeatCheck;
import com.flansmod.common.network.PacketSeatUpdates;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.List;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public class EntitySeat extends Entity implements IControllable, IEntityAdditionalSpawnData {
  @SideOnly(Side.CLIENT)
  public boolean foundDriveable;
  
  private int driveableID;
  
  private int seatID;
  
  public EntityDriveable driveable;
  
  @SideOnly(Side.CLIENT)
  public float playerRoll;
  
  @SideOnly(Side.CLIENT)
  public float prevPlayerRoll;
  
  public Seat seatInfo;
  
  public boolean driver;
  
  public RotatedAxes looking;
  
  public RotatedAxes prevLooking;
  
  public RotatedAxes playerLooking;
  
  public RotatedAxes prevPlayerLooking;
  
  public int gunDelay;
  
  public int nintendoSwitch = 10;
  
  public int exitTimer = 20;
  
  public float minigunSpeed;
  
  public float minigunAngle;
  
  public int soundDelay;
  
  public int yawSoundDelay = 0;
  
  public int pitchSoundDelay = 0;
  
  public boolean playYawSound = false;
  
  public boolean playPitchSound = false;
  
  private double playerPosX;
  
  private double playerPosY;
  
  private double playerPosZ;
  
  private float playerYaw;
  
  private float playerPitch;
  
  private double prevPlayerPosX;
  
  private double prevPlayerPosY;
  
  private double prevPlayerPosZ;
  
  private float prevPlayerYaw;
  
  private float prevPlayerPitch;
  
  private boolean shooting;
  
  public Entity lastRiddenByEntity;
  
  public EntityPlayer Seatbelt = null;
  
  public int SeatBeltMemory = 0;
  
  public int timeLimitDriveableNull = 0;
  
  public boolean calculator = false;
  
  public EntitySeat(World world) {
    super(world);
    func_70105_a(1.0F, 1.0F);
    this.prevLooking = new RotatedAxes();
    this.looking = new RotatedAxes();
    this.playerLooking = new RotatedAxes();
    this.prevPlayerLooking = new RotatedAxes();
    this.lastRiddenByEntity = null;
  }
  
  public EntitySeat(World world, EntityDriveable d, int id) {
    this(world);
    this.driveable = d;
    this.driveableID = d.func_145782_y();
    this.seatInfo = (this.driveable.getDriveableType()).seats[id];
    this.driver = (id == 0);
    func_70107_b(d.field_70165_t, d.field_70163_u, d.field_70161_v);
    this.playerPosX = this.prevPlayerPosX = this.field_70165_t;
    this.playerPosY = this.prevPlayerPosY = this.field_70163_u;
    this.playerPosZ = this.prevPlayerPosZ = this.field_70161_v;
    this.looking.setAngles((this.seatInfo.minYaw + this.seatInfo.maxYaw) / 2.0F, 0.0F, 0.0F);
    this.playerLooking.setAngles((this.seatInfo.minYaw + this.seatInfo.maxYaw) / 2.0F, 0.0F, 0.0F);
    if ((this.driveable.getDriveableType()).gunRange)
      this.calculator = true; 
    if (this.seatInfo.helipad || this.seatInfo.carrier)
      func_70105_a(5.0F, 5.0F); 
  }
  
  public void func_70056_a(double x, double y, double z, float yaw, float pitch, int i) {}
  
  public void func_70071_h_() {
    EntityDriveable entD;
    super.func_70071_h_();
    if (this.driver && this.field_70153_n == null) {
      this.prevLooking = this.looking.clone();
      this.prevPlayerLooking = this.playerLooking.clone();
    } 
    if (this.seatInfo != null && (this.seatInfo.helipad || this.seatInfo.carrier) && this.field_70153_n == null) {
      func_70105_a(5.0F, 5.0F);
    } else if (this.seatInfo != null && (this.seatInfo.helipad || this.seatInfo.carrier) && this.field_70153_n != null) {
      func_70105_a(0.1F, 0.1F);
    } 
    if (this.field_70170_p.field_72995_K && !this.foundDriveable) {
      if (this.field_70170_p.func_73045_a(this.driveableID) instanceof EntityDriveable)
        this.driveable = (EntityDriveable)this.field_70170_p.func_73045_a(this.driveableID); 
      if (this.driveable == null)
        return; 
      this.foundDriveable = true;
      this.driveable.seats[this.seatID] = this;
      this.seatInfo = (this.driveable.getDriveableType()).seats[this.seatID];
      this.looking.setAngles((this.seatInfo.minYaw + this.seatInfo.maxYaw) / 2.0F, 0.0F, 0.0F);
      this.playerLooking.setAngles((this.seatInfo.minYaw + this.seatInfo.maxYaw) / 2.0F, 0.0F, 0.0F);
      this.prevLooking = this.looking.clone();
      this.playerPosX = this.prevPlayerPosX = this.field_70165_t = this.driveable.field_70165_t;
      this.playerPosY = this.prevPlayerPosY = this.field_70163_u = this.driveable.field_70163_u;
      this.playerPosZ = this.prevPlayerPosZ = this.field_70161_v = this.driveable.field_70161_v;
      func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    } 
    if (this.driveable == null)
      return; 
    if (this.field_70170_p.func_73045_a(this.driveableID) instanceof EntityDriveable) {
      entD = (EntityDriveable)this.field_70170_p.func_73045_a(this.driveableID);
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
    if (this.gunDelay > 0)
      this.gunDelay--; 
    if (this.soundDelay > 0)
      this.soundDelay--; 
    if (this.yawSoundDelay > 0)
      this.yawSoundDelay--; 
    if (this.pitchSoundDelay > 0)
      this.pitchSoundDelay--; 
    if (this.nintendoSwitch > 0)
      this.nintendoSwitch--; 
    if (this.exitTimer < 20)
      this.exitTimer++; 
    if (this.exitTimer < 0 || (this.driveable.gtfo && this.field_70153_n != null && !this.driver)) {
      this.field_70153_n.func_70078_a(null);
      this.exitTimer = 20;
    } 
    if (!this.field_70170_p.field_72995_K) {
      if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlayer) {
        EntityPlayerMP mp = (EntityPlayerMP)this.field_70153_n;
        if (this.Seatbelt != mp) {
          this.Seatbelt = (EntityPlayer)this.field_70153_n;
          this.SeatBeltMemory = 1200;
        } 
      } else if (this.Seatbelt != null && this.SeatBeltMemory > 0) {
        this.SeatBeltMemory--;
      } 
      int testerino = 0;
      if (!this.field_70170_p.field_73010_i.contains(this.Seatbelt))
        if (this.Seatbelt != null)
          func_70078_a(null);  
      if (this.Seatbelt != null && this.SeatBeltMemory == 0)
        this.Seatbelt = null; 
    } 
    if (this.playYawSound == true && this.yawSoundDelay == 0 && this.seatInfo.traverseSounds == true) {
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.seatInfo.yawSound, false);
      this.yawSoundDelay = this.seatInfo.yawSoundLength;
    } 
    if (this.playPitchSound == true && this.pitchSoundDelay == 0 && this.seatInfo.traverseSounds == true) {
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, this.seatInfo.pitchSound, false);
      this.pitchSoundDelay = this.seatInfo.pitchSoundLength;
    } 
    if (!(this.field_70153_n instanceof EntityPlayer) || !FlansMod.proxy.isThePlayer((EntityPlayer)this.field_70153_n)) {
      this.playYawSound = false;
      this.playPitchSound = false;
      this.yawSoundDelay = 0;
      this.pitchSoundDelay = 0;
    } 
    if (this.field_70170_p.field_72995_K) {
      if (this.driver && this.field_70153_n instanceof EntityPlayer && FlansMod.proxy
        
        .isThePlayer((EntityPlayer)this.field_70153_n) && FlansModClient.controlModeMouse && this.driveable
        .hasMouseControlMode()) {
        this.looking = new RotatedAxes();
        this.playerLooking = new RotatedAxes();
      } 
      if (this.seatInfo.invisiblePassenger && this.field_70153_n != null)
        this.field_70153_n.func_82142_c(true); 
      Vector3f xAxis = this.driveable.axes.findLocalAxesGlobally(this.looking).getXAxis();
      Vector3f yAxis = this.driveable.axes.findLocalAxesGlobally(this.looking).getYAxis();
      Vector3f zAxis = this.driveable.axes.findLocalAxesGlobally(this.looking).getZAxis();
      Vector3f yOffset = this.driveable.axes.findLocalVectorGlobally(new Vector3f(0.0F, (this.field_70153_n == null) ? 0.0F : (float)this.field_70153_n.func_70033_W(), 0.0F));
      for (int i = 0; i < 10; i++);
      if (this.lastRiddenByEntity instanceof EntityPlayer && this.field_70153_n == null && FlansModClient.proxy.isThePlayer((EntityPlayer)this.lastRiddenByEntity))
        FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketSeatCheck(this)); 
    } 
    if (this.field_70153_n instanceof EntityPlayer && this.shooting)
      pressKey(9, (EntityPlayer)this.field_70153_n); 
    this.minigunSpeed *= 0.95F;
    this.minigunAngle += this.minigunSpeed;
    this.lastRiddenByEntity = this.field_70153_n;
  }
  
  public void updatePosition() {
    if (this.field_70170_p.field_72995_K && !this.foundDriveable)
      return; 
    this.prevPlayerPosX = this.playerPosX;
    this.prevPlayerPosY = this.playerPosY;
    this.prevPlayerPosZ = this.playerPosZ;
    this.prevPlayerYaw = this.playerYaw;
    this.prevPlayerPitch = this.playerPitch;
    Vector3f localPosition = new Vector3f(this.seatInfo.x / 16.0F, this.seatInfo.y / 16.0F, this.seatInfo.z / 16.0F);
    if (this.driveable != null && this.driveable.seats != null && this.driveable.seats[0] != null && (this.driveable.seats[0]).looking != null) {
      RotatedAxes yawOnlyLooking = new RotatedAxes((this.driveable.seats[0]).looking.getYaw(), ((this.driveable.seats[0]).seatInfo.part == EnumDriveablePart.barrel) ? (this.driveable.seats[0]).looking.getPitch() : 0.0F, 0.0F);
      Vector3f rotatedOffset = yawOnlyLooking.findLocalVectorGlobally(this.seatInfo.rotatedOffset);
      Vector3f.add(localPosition, new Vector3f(rotatedOffset.x, ((this.driveable.seats[0]).seatInfo.part == EnumDriveablePart.barrel) ? rotatedOffset.y : 0.0F, rotatedOffset.z), localPosition);
    } 
    Vector3f relativePosition = this.driveable.axes.findLocalVectorGlobally(localPosition);
    func_70107_b(this.driveable.field_70165_t + relativePosition.x, this.driveable.field_70163_u + relativePosition.y, this.driveable.field_70161_v + relativePosition.z);
    if (this.field_70153_n != null) {
      DriveableType type = this.driveable.getDriveableType();
      Vec3 yOffset = this.driveable.rotate(0.0D, this.field_70153_n.func_70033_W(), 0.0D).toVec3();
      this.playerPosX = this.field_70165_t + yOffset.field_72450_a;
      this.playerPosY = this.field_70163_u + yOffset.field_72448_b;
      this.playerPosZ = this.field_70161_v + yOffset.field_72449_c;
      this.field_70153_n.field_70142_S = this.field_70153_n.field_70169_q = this.prevPlayerPosX;
      this.field_70153_n.field_70137_T = this.field_70153_n.field_70167_r = this.prevPlayerPosY;
      this.field_70153_n.field_70136_U = this.field_70153_n.field_70166_s = this.prevPlayerPosZ;
      this.field_70153_n.func_70107_b(this.playerPosX, this.playerPosY, this.playerPosZ);
      RotatedAxes globalLookAxes = this.driveable.axes.findLocalAxesGlobally(this.playerLooking);
      this.playerYaw = -90.0F + globalLookAxes.getYaw();
      this.playerPitch = globalLookAxes.getPitch();
      double dYaw = (this.playerYaw - this.prevPlayerYaw);
      if (dYaw > 180.0D)
        this.prevPlayerYaw += 360.0F; 
      if (dYaw < -180.0D)
        this.prevPlayerYaw -= 360.0F; 
      if (this.field_70153_n instanceof EntityPlayer) {
        this.field_70153_n.field_70126_B = this.prevPlayerYaw;
        this.field_70153_n.field_70127_C = this.prevPlayerPitch;
        this.field_70153_n.field_70177_z = this.playerYaw;
        this.field_70153_n.field_70125_A = this.playerPitch;
      } 
      if (this.field_70170_p.field_72995_K) {
        this.prevPlayerRoll = this.playerRoll;
        this.playerRoll = -globalLookAxes.getRoll();
      } 
    } 
  }
  
  public void updatePositionClient() {
    if (this.field_70170_p.field_72995_K && !this.foundDriveable)
      return; 
    if (this.field_70170_p.field_72995_K) {
      this.prevPlayerPosX = this.playerPosX;
      this.prevPlayerPosY = this.playerPosY;
      this.prevPlayerPosZ = this.playerPosZ;
      this.prevPlayerYaw = this.playerYaw;
      this.prevPlayerPitch = this.playerPitch;
      Vector3f localPosition = new Vector3f(this.seatInfo.x / 16.0F, this.seatInfo.y / 16.0F, this.seatInfo.z / 16.0F);
      if (this.driveable != null && this.driveable.seats != null && this.driveable.seats[0] != null && (this.driveable.seats[0]).looking != null) {
        RotatedAxes yawOnlyLooking = new RotatedAxes((this.driveable.seats[0]).looking.getYaw(), ((this.driveable.seats[0]).seatInfo.part == EnumDriveablePart.barrel) ? (this.driveable.seats[0]).looking.getPitch() : 0.0F, 0.0F);
        Vector3f rotatedOffset = yawOnlyLooking.findLocalVectorGlobally(this.seatInfo.rotatedOffset);
        Vector3f.add(localPosition, new Vector3f(rotatedOffset.x, ((this.driveable.seats[0]).seatInfo.part == EnumDriveablePart.barrel) ? rotatedOffset.y : 0.0F, rotatedOffset.z), localPosition);
      } 
      Vector3f relativePosition = this.driveable.axes.findLocalVectorGlobally(localPosition);
      func_70107_b(this.driveable.field_70165_t + relativePosition.x, this.driveable.field_70163_u + relativePosition.y, this.driveable.field_70161_v + relativePosition.z);
      if (this.field_70153_n != null) {
        DriveableType type = this.driveable.getDriveableType();
        Vec3 yOffset = this.driveable.rotate(0.0D, this.field_70153_n.func_70033_W(), 0.0D).toVec3();
        this.playerPosX = this.field_70165_t + yOffset.field_72450_a;
        this.playerPosY = this.field_70163_u + yOffset.field_72448_b;
        this.playerPosZ = this.field_70161_v + yOffset.field_72449_c;
        this.field_70153_n.field_70142_S = this.field_70153_n.field_70169_q = this.prevPlayerPosX;
        this.field_70153_n.field_70137_T = this.field_70153_n.field_70167_r = this.prevPlayerPosY;
        this.field_70153_n.field_70136_U = this.field_70153_n.field_70166_s = this.prevPlayerPosZ;
        this.field_70153_n.func_70107_b(this.playerPosX, this.playerPosY, this.playerPosZ);
        RotatedAxes globalLookAxes = this.driveable.axes.findLocalAxesGlobally(this.playerLooking);
        this.playerYaw = -90.0F + globalLookAxes.getYaw();
        this.playerPitch = globalLookAxes.getPitch();
        double dYaw = (this.playerYaw - this.prevPlayerYaw);
        if (dYaw > 180.0D)
          this.prevPlayerYaw += 360.0F; 
        if (dYaw < -180.0D)
          this.prevPlayerYaw -= 360.0F; 
        if (this.field_70153_n instanceof EntityPlayer) {
          this.field_70153_n.field_70126_B = this.prevPlayerYaw;
          this.field_70153_n.field_70127_C = this.prevPlayerPitch;
          this.field_70153_n.field_70177_z = this.playerYaw;
          this.field_70153_n.field_70125_A = this.playerPitch;
        } 
        if (this.field_70170_p.field_72995_K) {
          this.prevPlayerRoll = this.playerRoll;
          this.playerRoll = -globalLookAxes.getRoll();
        } 
      } 
    } 
  }
  
  public void func_70043_V() {
    if (this.field_70153_n instanceof EntityPlayer) {
      this.field_70153_n.field_70177_z = this.playerYaw;
      this.field_70153_n.field_70125_A = this.playerPitch;
      this.field_70153_n.field_70126_B = this.prevPlayerYaw;
      this.field_70153_n.field_70127_C = this.prevPlayerPitch;
    } 
    this.field_70153_n.field_70142_S = this.field_70153_n.field_70169_q = this.prevPlayerPosX;
    this.field_70153_n.field_70137_T = this.field_70153_n.field_70167_r = this.prevPlayerPosY;
    this.field_70153_n.field_70136_U = this.field_70153_n.field_70166_s = this.prevPlayerPosZ;
  }
  
  @SideOnly(Side.CLIENT)
  public EntityLivingBase getCamera() {
    return this.driveable.getCamera();
  }
  
  public boolean func_70067_L() {
    return !this.field_70128_L;
  }
  
  protected void func_70088_a() {}
  
  public float func_70053_R() {
    return 4.0F;
  }
  
  protected void func_70037_a(NBTTagCompound tags) {}
  
  protected void func_70014_b(NBTTagCompound tags) {}
  
  public boolean func_70039_c(NBTTagCompound tags) {
    return false;
  }
  
  public boolean func_98035_c(NBTTagCompound tags) {
    return false;
  }
  
  public void onMouseMoved(int deltaX, int deltaY) {
    if (!this.foundDriveable)
      return; 
    this.prevLooking = this.looking.clone();
    this.prevPlayerLooking = this.playerLooking.clone();
    if (this.driver)
      this.driveable.onMouseMoved(deltaX, deltaY); 
    if (!this.driver || !FlansModClient.controlModeMouse || !this.driveable.hasMouseControlMode()) {
      float lookSpeed = 4.0F;
      float newPlayerPitch = this.playerLooking.getPitch() - deltaY / lookSpeed * FlansMod.proxy.getMouseSensitivity();
      if (newPlayerPitch > -this.seatInfo.minPitch)
        newPlayerPitch = -this.seatInfo.minPitch; 
      if (newPlayerPitch < -this.seatInfo.maxPitch)
        newPlayerPitch = -this.seatInfo.maxPitch; 
      float newPlayerYaw = this.playerLooking.getYaw() + deltaX / lookSpeed * FlansMod.proxy.getMouseSensitivity();
      float otherNewPlayerYaw = newPlayerYaw - 360.0F;
      if (newPlayerYaw < 0.0F)
        otherNewPlayerYaw = newPlayerYaw + 360.0F; 
      if ((newPlayerYaw < this.seatInfo.minYaw || newPlayerYaw > this.seatInfo.maxYaw) && (otherNewPlayerYaw < this.seatInfo.minYaw || otherNewPlayerYaw > this.seatInfo.maxYaw)) {
        float newPlayerYawDistFromRange = Math.min(Math.abs(newPlayerYaw - this.seatInfo.minYaw), Math.abs(newPlayerYaw - this.seatInfo.maxYaw));
        float otherPlayerNewYawDistFromRange = Math.min(Math.abs(otherNewPlayerYaw - this.seatInfo.minYaw), Math.abs(otherNewPlayerYaw - this.seatInfo.maxYaw));
        if (newPlayerYawDistFromRange <= otherPlayerNewYawDistFromRange) {
          if (newPlayerYaw > this.seatInfo.maxYaw)
            newPlayerYaw = this.seatInfo.maxYaw; 
          if (newPlayerYaw < this.seatInfo.minYaw)
            newPlayerYaw = this.seatInfo.minYaw; 
        } else {
          if (otherNewPlayerYaw > this.seatInfo.maxYaw)
            otherNewPlayerYaw = this.seatInfo.maxYaw; 
          if (otherNewPlayerYaw < this.seatInfo.minYaw)
            otherNewPlayerYaw = this.seatInfo.minYaw; 
          if (newPlayerYaw < 0.0F) {
            newPlayerYaw = otherNewPlayerYaw - 360.0F;
          } else {
            newPlayerYaw = otherNewPlayerYaw + 360.0F;
          } 
        } 
      } 
      this.playerLooking.setAngles(newPlayerYaw, newPlayerPitch, 0.0F);
      if (this.driveable.disabled)
        return; 
      float targetX = this.playerLooking.getYaw();
      float yawToMove = targetX - this.looking.getYaw();
      for (; yawToMove > 180.0F; yawToMove -= 360.0F);
      for (; yawToMove <= -180.0F; yawToMove += 360.0F);
      float signDeltaX = 0.0F;
      if (yawToMove > this.seatInfo.aimingSpeed.x / 20.0F && !this.seatInfo.legacyAiming) {
        signDeltaX = 0.1F;
      } else if (yawToMove < -(this.seatInfo.aimingSpeed.x / 20.0F) && !this.seatInfo.legacyAiming) {
        signDeltaX = -0.1F;
      } else {
        signDeltaX = 0.0F;
      } 
      float newYaw = 0.0F;
      if (this.seatInfo.legacyAiming == true || (signDeltaX == 0.0F && deltaX == 0)) {
        newYaw = this.playerLooking.getYaw();
      } else if (Math.abs(yawToMove) < 2.0F) {
        newYaw = this.looking.getYaw() + signDeltaX * this.seatInfo.aimingSpeed.x;
      } else {
        newYaw = this.looking.getYaw() + 10.0F * signDeltaX * this.seatInfo.aimingSpeed.x;
      } 
      float otherNewYaw = newYaw - 360.0F;
      if (newYaw < 0.0F)
        otherNewYaw = newYaw + 360.0F; 
      if ((newYaw < this.seatInfo.minYaw || newYaw > this.seatInfo.maxYaw) && (otherNewYaw < this.seatInfo.minYaw || otherNewYaw > this.seatInfo.maxYaw)) {
        float newYawDistFromRange = Math.min(Math.abs(newYaw - this.seatInfo.minYaw), Math.abs(newYaw - this.seatInfo.maxYaw));
        float otherNewYawDistFromRange = Math.min(Math.abs(otherNewYaw - this.seatInfo.minYaw), Math.abs(otherNewYaw - this.seatInfo.maxYaw));
        if (newYawDistFromRange <= otherNewYawDistFromRange) {
          if (newYaw > this.seatInfo.maxYaw)
            newYaw = this.seatInfo.maxYaw; 
          if (newYaw < this.seatInfo.minYaw)
            newYaw = this.seatInfo.minYaw; 
        } else {
          if (otherNewYaw > this.seatInfo.maxYaw)
            otherNewYaw = this.seatInfo.maxYaw; 
          if (otherNewYaw < this.seatInfo.minYaw)
            otherNewYaw = this.seatInfo.minYaw; 
          if (newYaw < 0.0F) {
            newYaw = otherNewYaw - 360.0F;
          } else {
            newYaw = otherNewYaw + 360.0F;
          } 
        } 
      } 
      float targetY = this.playerLooking.getPitch();
      float pitchToMove = targetY - this.looking.getPitch();
      for (; pitchToMove > 180.0F; pitchToMove -= 360.0F);
      for (; pitchToMove <= -180.0F; pitchToMove += 360.0F);
      float signDeltaY = 0.0F;
      if (pitchToMove > this.seatInfo.aimingSpeed.y / 20.0F && !this.seatInfo.legacyAiming) {
        signDeltaY = 0.1F;
      } else if (pitchToMove < -(this.seatInfo.aimingSpeed.y / 20.0F) && !this.seatInfo.legacyAiming) {
        signDeltaY = -0.1F;
      } else {
        signDeltaY = 0.0F;
      } 
      float newPitch = 0.0F;
      float minYawToMove = 0.0F;
      float currentYawToMove = 0.0F;
      if (this.seatInfo.latePitch) {
        minYawToMove = (float)Math.sqrt((pitchToMove / this.seatInfo.aimingSpeed.y * pitchToMove / this.seatInfo.aimingSpeed.y)) * this.seatInfo.aimingSpeed.x;
      } else {
        minYawToMove = 360.0F;
      } 
      currentYawToMove = (float)Math.sqrt((yawToMove * yawToMove));
      if (this.seatInfo.legacyAiming == true || (signDeltaY == 0.0F && deltaY == 0)) {
        newPitch = this.playerLooking.getPitch();
      } else if (Math.abs(pitchToMove) < 2.0F && !this.seatInfo.yawBeforePitch && currentYawToMove < minYawToMove) {
        newPitch = this.looking.getPitch() + signDeltaY * this.seatInfo.aimingSpeed.y;
      } else if (Math.abs(pitchToMove) < 2.0F && this.seatInfo.yawBeforePitch == true && signDeltaX == 0.0F) {
        newPitch = this.looking.getPitch() + signDeltaY * this.seatInfo.aimingSpeed.y;
      } else if (Math.abs(pitchToMove) < 2.0F && this.seatInfo.yawBeforePitch == true && signDeltaX != 0.0F) {
        newPitch = this.looking.getPitch();
      } else if (!this.seatInfo.yawBeforePitch && currentYawToMove < minYawToMove) {
        newPitch = this.looking.getPitch() + 10.0F * signDeltaY * this.seatInfo.aimingSpeed.y;
      } else if (this.seatInfo.yawBeforePitch == true && signDeltaX == 0.0F) {
        newPitch = this.looking.getPitch() + 10.0F * signDeltaY * this.seatInfo.aimingSpeed.y;
      } else if (this.seatInfo.yawBeforePitch == true && signDeltaX != 0.0F) {
        newPitch = this.looking.getPitch();
      } else {
        newPitch = this.looking.getPitch();
      } 
      if (newPitch > -this.seatInfo.minPitch)
        newPitch = -this.seatInfo.minPitch; 
      if (newPitch < -this.seatInfo.maxPitch)
        newPitch = -this.seatInfo.maxPitch; 
      this.looking.setAngles(newYaw, newPitch, 0.0F);
      if (signDeltaX != 0.0F && this.seatInfo.traverseSounds == true) {
        this.playYawSound = true;
      } else {
        this.playYawSound = false;
      } 
      if (signDeltaY != 0.0F && !this.seatInfo.yawBeforePitch && currentYawToMove < minYawToMove) {
        this.playPitchSound = true;
      } else if (signDeltaY != 0.0F && this.seatInfo.yawBeforePitch == true && signDeltaX == 0.0F) {
        this.playPitchSound = true;
      } else {
        this.playPitchSound = false;
      } 
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketSeatUpdates(this));
    } 
  }
  
  public void updateKeyHeldState(int key, boolean held) {
    if (this.field_70170_p.field_72995_K && this.foundDriveable)
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableKeyHeld(key, held)); 
    if (this.driver) {
      this.driveable.updateKeyHeldState(key, held);
    } else if (key == 9) {
      this.shooting = held;
    } 
  }
  
  public boolean pressKey(int key, EntityPlayer player) {
    if (this.driver && (!this.field_70170_p.field_72995_K || this.foundDriveable))
      return this.driveable.pressKey(key, player); 
    if (this.field_70170_p.field_72995_K) {
      if (this.foundDriveable) {
        FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableKey(key));
        if (key == 9)
          this.minigunSpeed += 0.1F; 
      } 
      return false;
    } 
    if (key == 6 && this.field_70153_n != null) {
      this.exitTimer--;
      this.exitTimer--;
      if (this.exitTimer > 20)
        return true; 
    } 
    if (key == 20 && this.field_70153_n != null && (this.driveable.seats[0]).field_70153_n == null && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).s0 <= 0) {
      (PlayerHandler.getPlayerData(player)).s0 = 5;
      player.func_70078_a(this.driveable.seats[0]);
    } 
    if (key == 21 && this.field_70153_n != null && (this.driveable.getDriveableType()).numPassengers > 1)
      if ((this.driveable.seats[2]).field_70153_n == null && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).s1 <= 0) {
        (PlayerHandler.getPlayerData(player)).s1 = 5;
        player.func_70078_a(this.driveable.seats[2]);
      }  
    if (key == 22 && this.field_70153_n != null && (this.driveable.getDriveableType()).numPassengers > 2)
      if ((this.driveable.seats[3]).field_70153_n == null && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).s2 <= 0) {
        (PlayerHandler.getPlayerData(player)).s2 = 5;
        player.func_70078_a(this.driveable.seats[3]);
      }  
    if (key == 23 && this.field_70153_n != null && (this.driveable.getDriveableType()).numPassengers > 3)
      if ((this.driveable.seats[4]).field_70153_n == null && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).s3 <= 0) {
        (PlayerHandler.getPlayerData(player)).s3 = 5;
        player.func_70078_a(this.driveable.seats[4]);
      }  
    if (key == 24 && this.field_70153_n != null && (this.driveable.getDriveableType()).numPassengers > 4)
      if ((this.driveable.seats[5]).field_70153_n == null && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).s4 <= 0) {
        (PlayerHandler.getPlayerData(player)).s4 = 5;
        player.func_70078_a(this.driveable.seats[5]);
      }  
    if (key == 25 && this.field_70153_n != null && (this.driveable.getDriveableType()).numPassengers > 5)
      if ((this.driveable.seats[6]).field_70153_n == null && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).s5 <= 0) {
        (PlayerHandler.getPlayerData(player)).s5 = 5;
        player.func_70078_a(this.driveable.seats[6]);
      }  
    if (key == 26 && this.field_70153_n != null && (this.driveable.getDriveableType()).numPassengers > 6)
      if ((this.driveable.seats[7]).field_70153_n == null && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).s6 <= 0) {
        (PlayerHandler.getPlayerData(player)).s6 = 5;
        player.func_70078_a(this.driveable.seats[7]);
      }  
    if (key == 27 && this.field_70153_n != null && (this.driveable.getDriveableType()).numPassengers > 7)
      if ((this.driveable.seats[8]).field_70153_n == null && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).s7 <= 0) {
        (PlayerHandler.getPlayerData(player)).s7 = 5;
        player.func_70078_a(this.driveable.seats[8]);
      }  
    if (key == 28 && this.field_70153_n != null && (this.driveable.getDriveableType()).numPassengers > 8)
      if ((this.driveable.seats[9]).field_70153_n == null && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).s8 <= 0) {
        (PlayerHandler.getPlayerData(player)).s8 = 5;
        player.func_70078_a(this.driveable.seats[9]);
      }  
    if (key == 29 && this.field_70153_n != null && (this.driveable.getDriveableType()).numPassengers > 9)
      if ((this.driveable.seats[10]).field_70153_n == null && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).s9 <= 0) {
        (PlayerHandler.getPlayerData(player)).s9 = 5;
        player.func_70078_a(this.driveable.seats[10]);
      }  
    if (key == 19 && this.field_70153_n != null && ((this.driveable.seats[0]).field_70153_n == player || (this.driveable.seats[0]).field_70153_n == null) && PlayerHandler.getPlayerData(player) != null && (PlayerHandler.getPlayerData(player)).nintendoSwitch <= 0)
      if ((this.driveable.seats[0]).field_70153_n == null) {
        (PlayerHandler.getPlayerData(player)).nintendoSwitch = 10;
        player.func_70078_a(this.driveable.seats[0]);
        this.driveable.nintendoSwitchLite = 10;
      }  
    if (key == 9) {
      GunType gun = this.seatInfo.gunType;
      this.minigunSpeed += 0.1F;
      if ((gun != null && gun.mode != EnumFireMode.MINIGUN) || this.minigunSpeed > 2.0F)
        if (this.gunDelay <= 0 && TeamsManager.bulletsEnabled && (this.driveable.getDriveableData()).ammo[this.seatInfo.gunnerID] != null) {
          ItemStack bulletItemStack = (this.driveable.getDriveableData()).ammo[this.seatInfo.gunnerID];
          if (gun != null && bulletItemStack != null && bulletItemStack.func_77973_b() instanceof ItemShootable && !TeamsManager.violence) {
            ShootableType bullet = ((ItemShootable)bulletItemStack.func_77973_b()).type;
            if (gun.isAmmo(bullet)) {
              Vector3f gunOrigin = Vector3f.add(this.driveable.axes.findLocalVectorGlobally(this.seatInfo.gunOrigin), new Vector3f(this.driveable.field_70165_t, this.driveable.field_70163_u, this.driveable.field_70161_v), null);
              RotatedAxes globalLookAxes = this.driveable.axes.findLocalAxesGlobally(this.looking);
              Vector3f shootVec = this.driveable.axes.findLocalVectorGlobally(this.looking.getXAxis());
              Vector3f yOffset = this.driveable.axes.findLocalVectorGlobally(new Vector3f(0.0F, (float)player.func_70042_X(), 0.0F));
              if (this.seatInfo.barrels == 1)
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x, gunOrigin.y, gunOrigin.z), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType())); 
              if (this.seatInfo.barrels == 2) {
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x - shootVec.z * this.seatInfo.barrelSpread / 2.0F, gunOrigin.y, gunOrigin.z - shootVec.x * this.seatInfo.barrelSpread / 2.0F), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x + shootVec.z * this.seatInfo.barrelSpread / 2.0F, gunOrigin.y, gunOrigin.z + shootVec.x * this.seatInfo.barrelSpread / 2.0F), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
              } 
              if (this.seatInfo.barrels == 3) {
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x - shootVec.z * this.seatInfo.barrelSpread, gunOrigin.y, gunOrigin.z - shootVec.x * this.seatInfo.barrelSpread), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x, gunOrigin.y, gunOrigin.z), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x + shootVec.z * this.seatInfo.barrelSpread, gunOrigin.y, gunOrigin.z + shootVec.x * this.seatInfo.barrelSpread), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
              } 
              if (this.seatInfo.barrels == 4) {
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x - shootVec.z * this.seatInfo.barrelSpread / 2.0F, gunOrigin.y, gunOrigin.z - shootVec.x * this.seatInfo.barrelSpread / 2.0F), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x + shootVec.z * this.seatInfo.barrelSpread / 2.0F, gunOrigin.y, gunOrigin.z + shootVec.x * this.seatInfo.barrelSpread / 2.0F), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x - shootVec.z * 1.5D * this.seatInfo.barrelSpread, gunOrigin.y, (gunOrigin.z - shootVec.x * this.seatInfo.barrelSpread / 2.0F)), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x + shootVec.z * 1.5D * this.seatInfo.barrelSpread, gunOrigin.y, (gunOrigin.z + shootVec.x * this.seatInfo.barrelSpread / 2.0F)), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
              } 
              if (this.seatInfo.barrels == 5) {
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x - shootVec.z * this.seatInfo.barrelSpread, gunOrigin.y, gunOrigin.z - shootVec.x * this.seatInfo.barrelSpread), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x, gunOrigin.y, gunOrigin.z), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x + shootVec.z * this.seatInfo.barrelSpread, gunOrigin.y, gunOrigin.z + shootVec.x * this.seatInfo.barrelSpread), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x + shootVec.z * this.seatInfo.barrelSpread, gunOrigin.y, gunOrigin.z + 2.0F * shootVec.x * this.seatInfo.barrelSpread), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x + shootVec.z * this.seatInfo.barrelSpread, gunOrigin.y, gunOrigin.z - 2.0F * shootVec.x * this.seatInfo.barrelSpread), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
              } 
              if (this.seatInfo.barrels == 6) {
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x - shootVec.z * this.seatInfo.barrelSpread / 2.0F, gunOrigin.y, gunOrigin.z - shootVec.x * this.seatInfo.barrelSpread / 2.0F), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x + shootVec.z * this.seatInfo.barrelSpread / 2.0F, gunOrigin.y, gunOrigin.z + shootVec.x * this.seatInfo.barrelSpread / 2.0F), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x - shootVec.z * 1.5D * this.seatInfo.barrelSpread, gunOrigin.y, (gunOrigin.z - shootVec.x * this.seatInfo.barrelSpread / 2.0F)), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x + shootVec.z * 1.5D * this.seatInfo.barrelSpread, gunOrigin.y, (gunOrigin.z + shootVec.x * this.seatInfo.barrelSpread / 2.0F)), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x - shootVec.z * 2.5D * this.seatInfo.barrelSpread, gunOrigin.y, (gunOrigin.z - shootVec.x * this.seatInfo.barrelSpread / 2.0F)), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
                this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(yOffset, new Vector3f(gunOrigin.x + shootVec.z * 2.5D * this.seatInfo.barrelSpread, gunOrigin.y, (gunOrigin.z + shootVec.x * this.seatInfo.barrelSpread / 2.0F)), null), shootVec, (EntityLivingBase)this.field_70153_n, gun.bulletSpread, gun.damage, gun.bulletSpeed, bulletItemStack.func_77960_j(), (InfoType)this.driveable.getDriveableType()));
              } 
              if (this.soundDelay <= 0) {
                PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, gun.shootSound, false);
                this.soundDelay = gun.shootSoundLength;
              } 
              int damage = bulletItemStack.func_77960_j();
              if (!((EntityPlayer)this.field_70153_n).field_71075_bZ.field_75098_d)
                bulletItemStack.func_77964_b(damage + 1); 
              if (damage >= bulletItemStack.func_77958_k())
                if (((EntityPlayer)this.field_70153_n).field_71075_bZ.field_75098_d) {
                  bulletItemStack.func_77964_b(0);
                } else {
                  ((this.driveable.getDriveableData()).ammo[this.seatInfo.gunnerID]).field_77994_a--;
                  bulletItemStack.func_77964_b(0);
                  if (((this.driveable.getDriveableData()).ammo[this.seatInfo.gunnerID]).field_77994_a <= 0)
                    (this.driveable.getDriveableData()).ammo[this.seatInfo.gunnerID] = null; 
                }  
              this.gunDelay = (int)gun.shootDelay;
            } 
          } 
        }  
    } 
    return false;
  }
  
  public boolean func_130002_c(EntityPlayer entityplayer) {
    if (this.field_70128_L)
      return false; 
    if (this.field_70170_p.field_72995_K)
      return false; 
    if (this.seatID == 0)
      FlansMod.proxy.doTutorialStuff(entityplayer, this.driveable); 
    ItemStack currentItem = entityplayer.func_71045_bC();
    if (currentItem != null && currentItem.func_77973_b() instanceof ItemTool && ((ItemTool)currentItem.func_77973_b()).type.healDriveables)
      return true; 
    if (currentItem != null && currentItem.func_77973_b() instanceof ItemTool && ((ItemTool)currentItem.func_77973_b()).type.key)
      return true; 
    if (currentItem != null && currentItem.func_77973_b() instanceof ItemGun && ((ItemGun)currentItem.func_77973_b()).type.shootMelee)
      return true; 
    if (!this.seatInfo.enterable)
      return true; 
    if ((this.driveable.getDriveableType()).numPassengers > 0 && (this.driveable.seats[1]).field_70153_n != null && (this.driveable.seats[0]).field_70153_n == null && this.seatID == 0)
      return true; 
    if ((this.driveable.getDriveableType()).numPassengers > 0 && (this.driveable.seats[1]).field_70153_n == null && (this.driveable.seats[0]).field_70153_n != null && this.seatID == 1)
      return true; 
    if (currentItem != null && currentItem.func_77973_b() instanceof ItemPlane && (this.seatInfo.carrier || this.seatInfo.helipad)) {
      if (currentItem != null && currentItem.func_77973_b() instanceof ItemPlane) {
        ItemPlane plane = (ItemPlane)currentItem.func_77973_b();
        PlaneType type = plane.type;
        if (type.mass < (this.driveable.getDriveableType()).weightLimit) {
          if (type.helipadLandable || (type.carrierLandable && this.seatInfo.carrier)) {
            if (!this.field_70170_p.field_72995_K && plane != null && currentItem != null) {
              DriveableData data = plane.getPlaneData(currentItem, this.field_70170_p);
              if (data != null)
                this.field_70170_p.func_72838_d(new EntityPlane(this.field_70170_p, this.field_70165_t + 0.5D, this.field_70163_u + 2.5D, this.field_70161_v + 0.5D, entityplayer, type, data)); 
            } 
            if (!entityplayer.field_71075_bZ.field_75098_d)
              currentItem.field_77994_a--; 
          } else if (type.carrierLandable && this.seatInfo.helipad) {
            entityplayer.func_145747_a((IChatComponent)new ChatComponentText("This carrier slot can only handle Helicopters, VTOL Planes or Seaplanes"));
          } 
        } else if ((type.carrierLandable || type.helipadLandable) && type.mass < 1.5F * (this.driveable.getDriveableType()).weightLimit) {
          entityplayer.func_145747_a((IChatComponent)new ChatComponentText("This plane (" + type.mass + " kg) is too heavy to properly operate on this carrier! (" + (this.driveable.getDriveableType()).weightLimit + " kg Weight Limit)"));
          entityplayer.func_145747_a((IChatComponent)new ChatComponentText("However, you CAN launch it: Park the carrier near land and place the plane nearby to load it onto the deck"));
          entityplayer.func_145747_a((IChatComponent)new ChatComponentText("Also, you will not be able to land back on the carrier after takeoff"));
        } else if (!type.carrierLandable && !type.helipadLandable && this.seatInfo.carrier && type.mass < 1.5F * (this.driveable.getDriveableType()).weightLimit) {
          entityplayer.func_145747_a((IChatComponent)new ChatComponentText("This aircraft is not meant to operate on carriers, however it CAN take off for a one-way trip!"));
          entityplayer.func_145747_a((IChatComponent)new ChatComponentText("Park the carrier near land and place the aircraft nearby to load it onto the deck"));
        } else {
          entityplayer.func_145747_a((IChatComponent)new ChatComponentText("This plane (" + type.mass + " kg) is way too heavy for this carrier (" + (this.driveable.getDriveableType()).weightLimit + " kg Weight Limit)"));
        } 
      } 
      return true;
    } 
    if (currentItem != null && currentItem.func_77973_b() instanceof net.minecraft.item.ItemLead) {
      if (this.field_70153_n != null && this.field_70153_n instanceof EntityLiving && !(this.field_70153_n instanceof EntityPlayer)) {
        EntityLiving mob = (EntityLiving)this.field_70153_n;
        this.field_70153_n.func_70078_a(null);
        mob.func_110162_b((Entity)entityplayer, true);
        return true;
      } 
      double checkRange = 10.0D;
      List nearbyMobs = this.field_70170_p.func_72872_a(EntityLiving.class, AxisAlignedBB.func_72330_a(this.field_70165_t - checkRange, this.field_70163_u - checkRange, this.field_70161_v - checkRange, this.field_70165_t + checkRange, this.field_70163_u + checkRange, this.field_70161_v + checkRange));
      for (Object obj : nearbyMobs) {
        EntityLiving entity = (EntityLiving)obj;
        if (entity.func_110167_bD() && entity.func_110166_bE() == entityplayer && !this.driveable.locked) {
          entity.func_70078_a(this);
          this.looking.setAngles(-entity.field_70177_z, entity.field_70125_A, 0.0F);
          entity.func_110160_i(true, !entityplayer.field_71075_bZ.field_75098_d);
        } 
      } 
      return true;
    } 
    if (this.field_70153_n == null && !this.driveable.locked) {
      entityplayer.func_70078_a(this);
      return true;
    } 
    return false;
  }
  
  public Entity getControllingEntity() {
    return this.field_70153_n;
  }
  
  public boolean isDead() {
    return this.field_70128_L;
  }
  
  public boolean getInvincible() {
    return this.seatInfo.invincible;
  }
  
  public void func_70106_y() {
    super.func_70106_y();
  }
  
  public ItemStack getPickedResult(MovingObjectPosition target) {
    if (this.field_70170_p.field_72995_K && !this.foundDriveable)
      return null; 
    return this.driveable.getPickedResult(target);
  }
  
  public float getPlayerRoll() {
    for (; this.playerRoll - this.prevPlayerRoll > 180.0F; this.playerRoll -= 360.0F);
    for (; this.playerRoll - this.prevPlayerRoll < -180.0F; this.playerRoll += 360.0F);
    return this.playerRoll;
  }
  
  public float getCameraDistance() {
    return (this.foundDriveable && this.seatID == 0) ? (this.driveable.getDriveableType()).cameraDistance : 5.0F;
  }
  
  public boolean func_70097_a(DamageSource source, float f) {
    if (this.seatInfo != null && !this.seatInfo.helipad && !this.seatInfo.carrier && (this.seatInfo.id != 0 || (this.driveable.getDriveableType()).hijackablePilot)) {
      if (this.field_70153_n != null) {
        if (this.exitTimer > 0) {
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketPlaySound(this.field_70165_t, this.field_70163_u, this.field_70161_v, "woodHit"), this.field_70165_t, this.field_70163_u, this.field_70161_v, 25.0F, this.field_71093_bK);
        } else if (this.exitTimer <= 5) {
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketPlaySound(this.field_70165_t, this.field_70163_u, this.field_70161_v, "woodBreak"), this.field_70165_t, this.field_70163_u, this.field_70161_v, 25.0F, this.field_71093_bK);
        } 
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("crit", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D), this.field_70165_t, this.field_70163_u, this.field_70161_v, 25.0F, this.field_71093_bK);
        this.exitTimer -= 5;
        FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketSeatUpdates(this));
        return false;
      } 
      return false;
    } 
    return false;
  }
  
  public void writeSpawnData(ByteBuf data) {
    data.writeInt(this.driveableID);
    data.writeInt(this.seatInfo.id);
  }
  
  public void readSpawnData(ByteBuf data) {
    this.driveableID = data.readInt();
    this.driveable = (EntityDriveable)this.field_70170_p.func_73045_a(this.driveableID);
    this.seatID = data.readInt();
    this.driver = (this.seatID == 0);
    if (this.driveable != null) {
      this.seatInfo = (this.driveable.getDriveableType()).seats[this.seatID];
      this.looking.setAngles((this.seatInfo.minYaw + this.seatInfo.maxYaw) / 2.0F, 0.0F, 0.0F);
      this.playerPosX = this.prevPlayerPosX = this.field_70165_t = this.driveable.field_70165_t;
      this.playerPosY = this.prevPlayerPosY = this.field_70163_u = this.driveable.field_70163_u;
      this.playerPosZ = this.prevPlayerPosZ = this.field_70161_v = this.driveable.field_70161_v;
      func_70107_b(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    } 
  }
  
  public float getMinigunSpeed() {
    return this.minigunSpeed;
  }
}
