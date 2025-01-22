package com.flansmod.common.driveables;

import cofh.api.energy.IEnergyContainerItem;
import com.flansmod.api.IControllable;
import com.flansmod.api.IExplodeable;
import com.flansmod.client.EntityCamera;
import com.flansmod.client.FlansModClient;
import com.flansmod.client.debug.EntityDebugVector;
import com.flansmod.common.FlansMod;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.collisions.CollisionPlane;
import com.flansmod.common.driveables.collisions.CollisionShapeBox;
import com.flansmod.common.driveables.collisions.CollisionTest;
import com.flansmod.common.guns.EntityBullet;
import com.flansmod.common.guns.EntityDamageSourceFlans;
import com.flansmod.common.guns.EntityShootable;
import com.flansmod.common.guns.EnumFireMode;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemBullet;
import com.flansmod.common.guns.ItemShootable;
import com.flansmod.common.guns.ShootableType;
import com.flansmod.common.guns.raytracing.BulletHit;
import com.flansmod.common.guns.raytracing.DriveableHit;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketCurrentMissile;
import com.flansmod.common.network.PacketDriveableDamage;
import com.flansmod.common.network.PacketDriveableKeyHeld;
import com.flansmod.common.network.PacketFlak;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.parts.ItemPart;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.teams.Gametype;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.types.InfoType;
import com.flansmod.common.vector.ReadableVector3f;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.IEntityAdditionalSpawnData;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import io.netty.buffer.ByteBuf;
import java.util.ArrayList;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.util.Vec3;
import net.minecraft.world.World;

public abstract class EntityDriveable extends Entity implements IControllable, IExplodeable, IEntityAdditionalSpawnData {
  public boolean syncFromServer = true;
  
  public boolean crushed = false;
  
  public int crushTimer = 40;
  
  public boolean isShip = false;
  
  public boolean aiming = false;
  
  public int serverPositionTransitionTicker;
  
  public double field_70118_ct;
  
  public double field_70117_cu;
  
  public double field_70116_cv;
  
  public double serverYaw;
  
  public double serverPitch;
  
  public double serverRoll;
  
  public DriveableData driveableData;
  
  public String driveableType;
  
  public float throttle;
  
  public float throttlePeepee;
  
  public float oxygenMeter;
  
  public float divingFactor = 0.0F;
  
  public float energy = 0.0F;
  
  public float maxEnergy = 100.0F;
  
  public float minEnergy = -100.0F;
  
  public int crewTotal = 1;
  
  public float planeRecoil = 0.0F;
  
  public float pitchSignal = 0.0F;
  
  public float yawSignal = 0.0F;
  
  public String currentAmmo;
  
  public int warpTimer = 3600;
  
  public EntityWheel[] wheels;
  
  public boolean gtfo = false;
  
  public boolean fuelling;
  
  public float prevRotationRoll;
  
  public Vector3f angularVelocity = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public boolean leftMouseHeld = false;
  
  public boolean rightMouseHeld = false;
  
  private boolean suicide = false;
  
  public int shootDelayPrimary;
  
  public int shootDelaySecondary;
  
  public float minigunSpeedPrimary;
  
  public float minigunSpeedSecondary;
  
  public int currentGunPrimary;
  
  public int currentGunSecondary;
  
  public float harvesterAngle;
  
  public RotatedAxes prevAxes;
  
  public RotatedAxes axes;
  
  public EntitySeat[] seats;
  
  private int foundFuel = -1;
  
  public boolean couldNotFindFuel = false;
  
  public boolean isAmmoPlaced = false;
  
  public int lockOnSoundDelay;
  
  private int[] emitterTimers;
  
  public int animCountLeft = 0;
  
  public int animFrameLeft = 0;
  
  public int animCountRight = 0;
  
  public int animFrameRight = 0;
  
  public boolean leftTurnHeld = false;
  
  public boolean rightTurnHeld = false;
  
  public boolean isShowedPosition = false;
  
  public int tickCount = 0;
  
  public int impactX;
  
  public int impactY;
  
  public int impactZ;
  
  public boolean locked;
  
  public boolean neverLocked = true;
  
  public String key = "ChangeMe";
  
  private String lastKey;
  
  public boolean isRecoil = false;
  
  public float recoilPos = 0.0F;
  
  public float lastRecoilPos = 0.0F;
  
  public int recoilTimer = 0;
  
  public float primaryRecoilHeight = 0.0F;
  
  public float secondaryRecoilHeight = 0.0F;
  
  public int backwardsTimer = 0;
  
  public float recoilEnergy = 0.0F;
  
  public Vector3f lastPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public boolean hugeBoat = false;
  
  public boolean onDeck = false;
  
  public double deckHeight = 0.0D;
  
  public int deckCheck = 0;
  
  public int prevDeckCheck = 0;
  
  public boolean isMecha = false;
  
  public boolean disabled = false;
  
  public float propAngle = 0.0F;
  
  public float prevPropAngle = 0.0F;
  
  public float rotorAngle = 0.0F;
  
  public float prevRotorAngle = 0.0F;
  
  public int flareDelay = 0;
  
  public int ticksFlareUsing = 0;
  
  public boolean varFlare;
  
  public int ticksRepairing = 0;
  
  public int repairDelay = 0;
  
  public boolean varRepair;
  
  public int ramDelay = 0;
  
  public int nintendoSwitchLite = 10;
  
  public int fuelTimer = 300;
  
  public float labjacFuel = 10.0F;
  
  public int APSdelay = 0;
  
  public int APSchecker = 5;
  
  public int APSmax = 295;
  
  public int shieldHitTimer = 0;
  
  public float drakonDoorAngle = 0.0F;
  
  public float drakonArmAngle = 0.0F;
  
  public float drakonRailAngle = 0.0F;
  
  public float prevDrakonDoorAngle = 0.0F;
  
  public float prevDrakonArmAngle = 0.0F;
  
  public float prevDrakonRailAngle = 0.0F;
  
  public boolean reloadingDrakon = false;
  
  public boolean canFireIT1 = true;
  
  public int stage = 1;
  
  public int reloadAnimTime = 0;
  
  public boolean toDeactivate = false;
  
  public int timeTillDeactivate = 0;
  
  public long lastshellswitchedat;
  
  public boolean canFire = true;
  
  @SideOnly(Side.CLIENT)
  public EntityLivingBase camera;
  
  protected int invulnerableUnmountCount;
  
  private ItemStack[][] prevInventoryItems = new ItemStack[][] { null, null };
  
  public Entity lastAtkEntity = null;
  
  DriveableType type;
  
  public boolean epicShip;
  
  public int maximumCrew;
  
  public float damageVsCrew;
  
  public boolean afterBurning;
  
  public boolean thermalScoping;
  
  public boolean mounted;
  
  public boolean carrierTip;
  
  public boolean artilleryMode;
  
  public boolean activeRadar;
  
  public EntityDriveable(World world) {
    super(world);
    this.type = getDriveableType();
    this.damageVsCrew = 0.5F;
    this.thermalScoping = false;
    this.mounted = false;
    this.carrierTip = false;
    this.artilleryMode = false;
    this.activeRadar = true;
    this.axes = new RotatedAxes();
    this.prevAxes = new RotatedAxes();
    this.field_70156_m = true;
    func_70105_a(1.5F, 1.5F);
    this.field_70129_M = 0.375F;
    this.field_70158_ak = true;
    this.field_70155_l = 20000.0D;
    this.locked = false;
  }
  
  public EntityDriveable(World world, DriveableType t, DriveableData d) {
    this(world);
    this.driveableType = t.shortName;
    this.driveableData = d;
  }
  
  protected void initType(DriveableType type, boolean clientSide) {
    this.seats = new EntitySeat[type.numPassengers + 1];
    int i;
    for (i = 0; i < type.numPassengers + 1; i++) {
      if (!clientSide) {
        this.seats[i] = new EntitySeat(this.field_70170_p, this, i);
        this.field_70170_p.func_72838_d(this.seats[i]);
      } 
    } 
    this.wheels = new EntityWheel[type.wheelPositions.length];
    for (i = 0; i < this.wheels.length; i++) {
      if (!clientSide) {
        this.wheels[i] = new EntityWheel(this.field_70170_p, this, i);
        this.field_70170_p.func_72838_d(this.wheels[i]);
      } 
    } 
    this.field_70138_W = type.wheelStepHeight;
    this.field_70129_M = type.yOffset;
    this.emitterTimers = new int[type.emitters.size()];
    for (i = 0; i < type.emitters.size(); i++)
      this.emitterTimers[i] = this.field_70146_Z.nextInt(((DriveableType.ParticleEmitter)type.emitters.get(i)).emitRate); 
    getEntityData().func_74757_a("CanMountEntity", type.canMountEntity);
    this.isShip = type.epicShip;
    for (int ps = 0; ps < 2; ps++) {
      EnumWeaponType weaponType = (ps == 0) ? type.primary : type.secondary;
      if (weaponType == EnumWeaponType.GUN)
        weaponType = EnumWeaponType.NONE; 
      int istart = getInventoryStart(weaponType);
      if (istart == this.driveableData.getAmmoInventoryStart())
        istart += type.numPassengerGunners; 
      int isize = getInventorySize(weaponType);
      if (istart >= 0 || isize > 0) {
        this.prevInventoryItems[ps] = new ItemStack[isize];
        for (int j = 0; j < isize; j++)
          this.prevInventoryItems[ps][j] = this.driveableData.func_70301_a(istart + j); 
      } 
    } 
  }
  
  protected void func_70014_b(NBTTagCompound tag) {
    this.driveableData.writeToNBT(tag);
    tag.func_74778_a("Type", this.driveableType);
    tag.func_74776_a("RotationYaw", this.axes.getYaw());
    tag.func_74776_a("RotationPitch", this.axes.getPitch());
    tag.func_74776_a("RotationRoll", this.axes.getRoll());
    if (this.key != null)
      tag.func_74778_a("key", this.key); 
    tag.func_74757_a("locked", this.locked);
  }
  
  protected void func_70037_a(NBTTagCompound tag) {
    this.driveableType = tag.func_74779_i("Type");
    this.driveableData = new DriveableData(tag);
    initType(DriveableType.getDriveable(this.driveableType), false);
    this.field_70126_B = tag.func_74760_g("RotationYaw");
    this.field_70127_C = tag.func_74760_g("RotationPitch");
    this.prevRotationRoll = tag.func_74760_g("RotationRoll");
    this.locked = tag.func_74767_n("locked");
    this.key = tag.func_74779_i("key");
    this.axes = new RotatedAxes(this.field_70126_B, this.field_70127_C, this.prevRotationRoll);
  }
  
  public void writeSpawnData(ByteBuf data) {
    ByteBufUtils.writeUTF8String(data, this.driveableType);
    NBTTagCompound tag = new NBTTagCompound();
    this.driveableData.writeToNBT(tag);
    ByteBufUtils.writeTag(data, tag);
    data.writeFloat(this.axes.getYaw());
    data.writeFloat(this.axes.getPitch());
    data.writeFloat(this.axes.getRoll());
    for (EnumDriveablePart ep : EnumDriveablePart.values()) {
      DriveablePart part = (getDriveableData()).parts.get(ep);
      data.writeShort((short)part.health);
      data.writeShort((short)part.crew);
      data.writeBoolean(part.onFire);
    } 
    if (this.key != null)
      ByteBufUtils.writeUTF8String(data, this.key); 
  }
  
  public void readSpawnData(ByteBuf data) {
    try {
      this.driveableType = ByteBufUtils.readUTF8String(data);
      this.driveableData = new DriveableData(ByteBufUtils.readTag(data));
      initType(getDriveableType(), true);
      this.axes.setAngles(data.readFloat(), data.readFloat(), data.readFloat());
      this.field_70126_B = this.axes.getYaw();
      this.field_70127_C = this.axes.getPitch();
      this.prevRotationRoll = this.axes.getRoll();
      for (EnumDriveablePart ep : EnumDriveablePart.values()) {
        DriveablePart part = (getDriveableData()).parts.get(ep);
        part.health = data.readShort();
        part.crew = data.readShort();
        part.onFire = data.readBoolean();
      } 
      this.key = ByteBufUtils.readUTF8String(data);
    } catch (Exception e) {
      FlansMod.log("Failed to retreive plane type from server.");
      super.func_70106_y();
      e.printStackTrace();
    } 
    this.camera = (EntityLivingBase)new EntityCamera(this.field_70170_p, this);
    this.field_70170_p.func_72838_d((Entity)this.camera);
  }
  
  public abstract void onMouseMoved(int paramInt1, int paramInt2);
  
  @SideOnly(Side.CLIENT)
  public EntityLivingBase getCamera() {
    return this.camera;
  }
  
  protected boolean canSit(int seat) {
    return ((getDriveableType()).numPassengers >= seat && (this.seats[seat]).field_70153_n == null);
  }
  
  protected boolean func_70041_e_() {
    return false;
  }
  
  protected void func_70088_a() {}
  
  public AxisAlignedBB func_70114_g(Entity entity) {
    if (this.seats[0] != null && (getDriveableType()).collisionDamageEnable && (this.seats[0]).field_70153_n != null)
      if (this.throttle > (getDriveableType()).collisionDamageThrottle)
        if (entity instanceof EntityLiving && !entity.func_70115_ae() && !entity.field_70128_L) {
          entity.func_70097_a(DamageSource.field_76367_g, this.throttle * this.throttle * (getDriveableType()).collisionDamageTimes);
          if (this.throttle * this.throttle * (getDriveableType()).collisionDamageTimes > 23.0F && ((EntityLiving)entity).func_110143_aJ() > 0.0F) {
            FlansMod.proxy.spawnParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, 0.0D, 0.10000000149011612D, 0.0D);
            PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 15.0D, entity.field_71093_bK, "goreDeath", true);
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 150.0F, entity.field_71093_bK);
          } 
        } else if (entity instanceof EntityPlayer && !entity.func_70115_ae() && !entity.field_70128_L) {
          entity.func_70097_a(DamageSource.field_76367_g, this.throttle * this.throttle * (getDriveableType()).collisionDamageTimes);
          if (this.throttle * this.throttle * (getDriveableType()).collisionDamageTimes > 23.0F && ((EntityPlayer)entity).func_110143_aJ() > 0.0F) {
            FlansMod.proxy.spawnParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, 0.0D, 0.10000000149011612D, 0.0D);
            PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 15.0D, entity.field_71093_bK, "goreDeath", true);
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.overkill", entity.field_70165_t, entity.field_70163_u - 4.0D, entity.field_70161_v, ((float)Math.random() * 1.0F), ((float)Math.random() * 1.0F), (-((float)Math.random()) * 1.0F)), entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, 150.0F, entity.field_71093_bK);
          } 
        }   
    return this.field_70121_D;
  }
  
  public AxisAlignedBB func_70046_E() {
    return this.field_70121_D;
  }
  
  public boolean func_70104_M() {
    return false;
  }
  
  public double func_70042_X() {
    return -0.3D;
  }
  
  public boolean func_70097_a(DamageSource damagesource, float i) {
    if (this.field_70170_p.field_72995_K || this.field_70128_L)
      return true; 
    if (isMountedEntity(damagesource.func_76346_g()))
      return false; 
    boolean broken = attackPart(EnumDriveablePart.core, damagesource, i);
    if (i > 0.0F) {
      checkPartsWhenAttacked();
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketDriveableDamage(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 100.0F, this.field_71093_bK);
    } 
    return true;
  }
  
  public boolean isMountedEntity(Entity entity) {
    if (entity != null) {
      Entity entity2 = this.field_70170_p.func_73045_a(entity.func_145782_y());
      for (Entity seat : this.seats) {
        if (seat.field_70153_n != null)
          if (seat.field_70153_n == entity || seat.field_70153_n == entity2)
            return true;  
      } 
    } 
    return false;
  }
  
  public void func_70106_y() {
    super.func_70106_y();
    if (this.field_70170_p.field_72995_K)
      this.camera.func_70106_y(); 
    for (EntitySeat seat : this.seats) {
      if (seat != null)
        seat.func_70106_y(); 
    } 
  }
  
  public void func_70100_b_(EntityPlayer par1EntityPlayer) {}
  
  public boolean func_70067_L() {
    return true;
  }
  
  public void func_70108_f(Entity entity) {}
  
  public void func_70056_a(double d, double d1, double d2, float f, float f1, int i) {
    if (this.field_70173_aa > 1)
      return; 
    if (!(this.field_70153_n instanceof EntityPlayer) || !FlansMod.proxy.isThePlayer((EntityPlayer)this.field_70153_n)) {
      if (this.syncFromServer) {
        this.serverPositionTransitionTicker = i + 5;
      } else {
        double var10 = d - this.field_70165_t;
        double var12 = d1 - this.field_70163_u;
        double var14 = d2 - this.field_70161_v;
        double var16 = var10 * var10 + var12 * var12 + var14 * var14;
        if (var16 <= 1.0D)
          return; 
        this.serverPositionTransitionTicker = 3;
      } 
      this.field_70118_ct = d;
      this.field_70117_cu = d1;
      this.field_70116_cv = d2;
      this.serverYaw = f;
      this.serverPitch = f1;
    } 
  }
  
  public void setIT1(boolean canFire, boolean reloading, int stag, int stageTime) {
    if (this.field_70170_p.field_72995_K && this.field_70173_aa % 5 == 0) {
      this.canFireIT1 = canFire;
      this.reloadingDrakon = reloading;
      this.stage = stag;
      this.reloadAnimTime = stageTime;
    } 
  }
  
  public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw, float throtPP) {
    if (this.field_70170_p.field_72995_K) {
      this.field_70118_ct = x;
      this.field_70117_cu = y;
      this.field_70116_cv = z;
      this.serverYaw = yaw;
      this.serverPitch = pitch;
      this.serverRoll = roll;
      this.serverPositionTransitionTicker = 5;
    } else {
      func_70107_b(x, y, z);
      this.field_70126_B = yaw;
      this.field_70127_C = pitch;
      this.prevRotationRoll = roll;
      setRotation(yaw, pitch, roll);
    } 
    this.field_70159_w = motX;
    this.field_70181_x = motY;
    this.field_70179_y = motZ;
    this.angularVelocity = new Vector3f(velYaw, velPitch, velRoll);
    this.throttle = throt;
    this.throttlePeepee = throtPP;
  }
  
  public void func_70016_h(double d, double d1, double d2) {
    this.field_70159_w = d;
    this.field_70181_x = d1;
    this.field_70179_y = d2;
  }
  
  public boolean pressKey(int key, EntityPlayer player) {
    if (!this.field_70170_p.field_72995_K && key == 9 && (getDriveableType()).modePrimary == EnumFireMode.SEMIAUTO) {
      shoot(false);
      return true;
    } 
    if (!this.field_70170_p.field_72995_K && key == 8 && (getDriveableType()).modeSecondary == EnumFireMode.SEMIAUTO) {
      shoot(true);
      return true;
    } 
    return false;
  }
  
  public void updateKeyHeldState(int key, boolean held) {
    if (this.field_70170_p.field_72995_K) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableKeyHeld(key, held));
      if (key == 2) {
        this.leftTurnHeld = true;
        this.rightTurnHeld = false;
      } else if (key == 3) {
        this.rightTurnHeld = true;
        this.leftTurnHeld = false;
      } else {
        this.leftTurnHeld = false;
        this.rightTurnHeld = false;
      } 
    } 
    switch (key) {
      case 9:
        if (!TeamsManager.violence)
          this.leftMouseHeld = held; 
        break;
      case 8:
        if (!TeamsManager.violence)
          this.rightMouseHeld = held; 
        this.suicide = true;
        break;
      case 30:
        if (this.seats != null && !this.gtfo)
          ((ICommandSender)(this.seats[0]).field_70153_n).func_145747_a((IChatComponent)new ChatComponentText("Passengers are now banned")); 
        this.gtfo = true;
        break;
      case 31:
        if (this.seats != null && this.gtfo)
          ((ICommandSender)(this.seats[0]).field_70153_n).func_145747_a((IChatComponent)new ChatComponentText("Passengers are now allowed")); 
        this.gtfo = false;
        break;
    } 
  }
  
  public void shoot(boolean secondary) {
    DriveableType type = getDriveableType();
    if (this.seats[0] == null)
      return; 
    if (type.IT1 && !this.canFireIT1 && type.weaponType(secondary) == EnumWeaponType.MISSILE)
      return; 
    if (!this.canFire)
      return; 
    if (getShootDelay(secondary) <= 0) {
      if (type.secondaryRecoil && this.rightMouseHeld)
        this.ramDelay = 30; 
      if (type.primaryRecoil && this.leftMouseHeld)
        this.ramDelay = 30; 
      ArrayList<ShootPoint> shootPoints = type.shootPoints(secondary);
      EnumWeaponType weaponType = type.weaponType(secondary);
      if (shootPoints.size() == 0)
        return; 
      int currentGun = getCurrentGun(secondary);
      if (type.alternate(secondary)) {
        currentGun = (currentGun + 1) % shootPoints.size();
        setCurrentGun(currentGun, secondary);
        shootEach(type, shootPoints.get(currentGun), currentGun, secondary, weaponType);
      } else {
        for (int i = 0; i < shootPoints.size(); i++)
          shootEach(type, shootPoints.get(i), i, secondary, weaponType); 
      } 
    } 
  }
  
  private boolean driverIsCreative() {
    return (this.seats != null && this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d);
  }
  
  public void spawnParticle(ArrayList<DriveableType.ShootParticle> list, ShootPoint shootPoint, Vector3f v) {
    for (DriveableType.ShootParticle s : list) {
      float bkx = shootPoint.rootPos.position.x;
      float bky = shootPoint.rootPos.position.y;
      float bkz = shootPoint.rootPos.position.z;
      Vector3f velocity = new Vector3f(s.x, s.y, s.z);
      Vector3f vv = this.lastPos;
      velocity = getDirection(shootPoint, velocity);
      if (shootPoint.rootPos.part == EnumDriveablePart.core) {
        Vector3f v2 = this.axes.findLocalVectorGlobally(shootPoint.rootPos.position);
        Vector3f v3 = rotate((this.seats[0]).looking.findLocalVectorGlobally(shootPoint.offPos));
        Vector3f.add(v2, v3, v);
      } 
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle(s.name, this.field_70165_t + v.x, this.field_70163_u + v.y, this.field_70161_v + v.z, velocity.x, velocity.y, velocity.z), this.field_70165_t + v.x, this.field_70163_u + v.y, this.field_70161_v + v.z, 150.0F, this.field_71093_bK);
      shootPoint.rootPos.position.x = bkx;
      shootPoint.rootPos.position.y = bky;
      shootPoint.rootPos.position.z = bkz;
    } 
  }
  
  public void shootEach(DriveableType type, ShootPoint shootPoint, int currentGun, boolean secondary, EnumWeaponType weaponType) {
    Vector3f gunVec = getFiringPosition(shootPoint);
    Vector3f lookVector = getLookVector(shootPoint);
    Vector3f gunVecFake = getFakeFiringPosition(shootPoint);
    if (!secondary && type.fixedPrimaryFire) {
      lookVector = this.axes.findLocalVectorGlobally(type.primaryFireAngle);
      if (shootPoint.rootPos.part == EnumDriveablePart.turret)
        lookVector = getPositionOnTurret(type.primaryFireAngle, false); 
      if (shootPoint.rootPos.part == EnumDriveablePart.barrel)
        lookVector = getPositionOnTurret(type.primaryFireAngle, true); 
    } 
    if (secondary && type.fixedSecondaryFire) {
      lookVector = this.axes.findLocalVectorGlobally(type.secondaryFireAngle);
      if (shootPoint.rootPos.part == EnumDriveablePart.turret)
        lookVector = getPositionOnTurret(type.secondaryFireAngle, false); 
      if (shootPoint.rootPos.part == EnumDriveablePart.barrel)
        lookVector = getPositionOnTurret(type.secondaryFireAngle, true); 
    } 
    if (weaponType == EnumWeaponType.SHELL)
      this.isRecoil = true; 
    if (shootPoint.rootPos.part == null)
      return; 
    if (!isPartIntact(shootPoint.rootPos.part))
      return; 
    if (shootPoint.rootPos instanceof PilotGun) {
      ItemStack bulletItemStack = this.driveableData.ammo[(getDriveableType()).numPassengerGunners + currentGun];
      PilotGun pilotGun = (PilotGun)shootPoint.rootPos;
      GunType gunType = pilotGun.type;
      if (gunType != null) {
        float shellSpeed = gunType.bulletSpeed;
        if (type.rangingGun)
          shellSpeed = type.bulletSpeed; 
        if (gunType != null && bulletItemStack != null && bulletItemStack.func_77973_b() instanceof ItemShootable && TeamsManager.bulletsEnabled && this.driveableData.overheatSuffer < 1) {
          ShootableType bullet = ((ItemShootable)bulletItemStack.func_77973_b()).type;
          if ((gunType.isAmmo(bullet) && !type.epicShip && this.ticksRepairing == 0) || (type.epicShip && gunType.isAmmo(bullet) && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.buoyancy)).health > 3 && this.ticksFlareUsing <= 0)) {
            spawnParticle(type.shootParticle(secondary), shootPoint, gunVec);
            this.driveableData.overheat += 5;
            this.field_70170_p.func_72838_d((Entity)((ItemShootable)bulletItemStack.func_77973_b()).getEntity(this.field_70170_p, Vector3f.add(new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v), gunVec, null), lookVector, (EntityLivingBase)(this.seats[0]).field_70153_n, gunType.bulletSpread / 2.0F, gunType.damage, 15.0F, bulletItemStack.func_77960_j(), (InfoType)type));
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.shootSound(secondary), false);
            int damage = bulletItemStack.func_77960_j();
            bulletItemStack.func_77964_b(damage + 1);
            if (damage + 1 == bulletItemStack.func_77958_k()) {
              bulletItemStack.func_77964_b(0);
              if (!driverIsCreative()) {
                bulletItemStack.field_77994_a--;
                if (bulletItemStack.field_77994_a <= 0) {
                  onWeaponInventoryChanged(secondary);
                  bulletItemStack = null;
                } 
                this.driveableData.func_70299_a((getDriveableType()).numPassengerGunners + currentGun, bulletItemStack);
              } 
            } 
            if (this.epicShip)
              setShootDelay((int)(type.shootDelay(secondary) / ((this.driveableData.totalCrew * this.driveableData.totalCrew) + this.driveableData.maximumCrew * 0.1D) / (this.driveableData.maximumCrew * this.driveableData.maximumCrew) * 0.9D), secondary); 
            if (!this.epicShip)
              setShootDelay(type.shootDelay(secondary), secondary); 
            if (type.secondaryRecoil && this.rightMouseHeld)
              this.ramDelay = 30; 
            if (type.primaryRecoil && this.leftMouseHeld)
              this.ramDelay = 30; 
          } 
        } 
      } 
    } else {
      switch (weaponType) {
        case BOMB:
          if (TeamsManager.bombsEnabled) {
            int slot = -1;
            for (int i = this.driveableData.getBombInventoryStart(); i < this.driveableData.getBombInventoryStart() + type.numBombSlots; i++) {
              ItemStack bomb = this.driveableData.func_70301_a(i);
              if (bomb != null && bomb.func_77973_b() instanceof ItemBullet && type.isValidAmmo(((ItemBullet)bomb.func_77973_b()).type, weaponType))
                slot = i; 
            } 
            if (slot != -1) {
              int spread = 0;
              int damageMultiplier = 1;
              float shellSpeed = 0.0F;
              ItemStack bulletStack = this.driveableData.func_70301_a(slot);
              ItemBullet bulletItem = (ItemBullet)bulletStack.func_77973_b();
              if (shootPoint.rootPos instanceof PilotGun) {
                PilotGun pilotGun = (PilotGun)shootPoint.rootPos;
                GunType gunType = pilotGun.type;
              } 
              EntityShootable bulletEntity = bulletItem.getEntity(this.field_70170_p, Vec3.func_72443_a(gunVec.x + this.field_70165_t, gunVec.y + this.field_70163_u, gunVec.z + this.field_70161_v), this.axes.getYaw(), this.axes.getPitch(), this.field_70159_w, this.field_70181_x, this.field_70179_y, (EntityLivingBase)(this.seats[0]).field_70153_n, damageMultiplier, this.driveableData.func_70301_a(slot).func_77960_j(), (InfoType)type);
              this.field_70170_p.func_72838_d((Entity)bulletEntity);
              spawnParticle(type.shootParticle(secondary), shootPoint, gunVec);
              if (type.shootSound(secondary) != null)
                PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.shootSound(secondary), false); 
              if (!driverIsCreative()) {
                bulletStack.func_77964_b(bulletStack.func_77960_j() + 1);
                if (bulletStack.func_77960_j() == bulletStack.func_77958_k()) {
                  bulletStack.func_77964_b(0);
                  bulletStack.field_77994_a--;
                  if (bulletStack.field_77994_a == 0) {
                    onWeaponInventoryChanged(secondary);
                    bulletStack = null;
                  } 
                } 
                this.driveableData.func_70299_a(slot, bulletStack);
              } 
              if (this.epicShip)
                setShootDelay((int)(type.shootDelay(secondary) / ((this.driveableData.totalCrew * this.driveableData.totalCrew) + this.driveableData.maximumCrew * 0.1D) / (this.driveableData.maximumCrew * this.driveableData.maximumCrew) * 0.9D), secondary); 
              if (!this.epicShip)
                setShootDelay(type.shootDelay(secondary), secondary); 
              if (type.secondaryRecoil && this.rightMouseHeld)
                this.ramDelay = 30; 
              if (type.primaryRecoil && this.leftMouseHeld)
                this.ramDelay = 30; 
            } 
          } 
          break;
        case MISSILE:
        case SHELL:
          tryRecoil();
          if ((TeamsManager.shellsEnabled && !type.epicShip && this.ticksRepairing == 0 && this.driveableData.overheatSuffer < 1) || (type.epicShip && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.buoyancy)).health > 3 && this.ticksFlareUsing <= 0)) {
            int slot = -1;
            for (int i = this.driveableData.getMissileInventoryStart(); i < this.driveableData.getMissileInventoryStart() + type.numMissileSlots; i++) {
              ItemStack shell = this.driveableData.func_70301_a(i);
              if (shell != null && shell.func_77973_b() instanceof ItemBullet && type.isValidAmmo(((ItemBullet)shell.func_77973_b()).type, weaponType))
                slot = i; 
            } 
            if (slot != -1) {
              int damageMultiplier = 1;
              float spread = type.bulletSpread;
              float shellSpeed = type.bulletSpeed;
              ItemStack bulletStack = this.driveableData.func_70301_a(slot);
              ItemBullet bulletItem = (ItemBullet)bulletStack.func_77973_b();
              float pupperinoSpeed = 1.0F;
              if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.airframe)).maxHealth > 5)
                pupperinoSpeed = 1.3F; 
              EntityShootable bulletEntity = bulletItem.getEntity(this.field_70170_p, Vector3f.add(gunVecFake, new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v), null), lookVector, (EntityLivingBase)(this.seats[0]).field_70153_n, spread, damageMultiplier, pupperinoSpeed * shellSpeed * bulletItem.type.speedMultiplier, this.driveableData.func_70301_a(slot).func_77960_j(), (InfoType)type);
              this.field_70170_p.func_72838_d((Entity)bulletEntity);
              spawnParticle(type.shootParticle(secondary), shootPoint, gunVec);
              this.isRecoil = true;
              if (type.shootSound(secondary) != null)
                PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.shootSound(secondary), false); 
              this.driveableData.overheat += 5;
              if (type.farSound != null)
                FlansMod.packetHandler.sendToDonut((PacketBase)new PacketPlaySound(this.field_70165_t, this.field_70163_u, this.field_70161_v, type.farSound), this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0F, 200.0F, this.field_71093_bK); 
              if (!driverIsCreative()) {
                bulletStack.func_77964_b(bulletStack.func_77960_j() + 1);
                if (bulletStack.func_77960_j() == bulletStack.func_77958_k()) {
                  bulletStack.func_77964_b(0);
                  bulletStack.field_77994_a--;
                  if (bulletStack.field_77994_a == 0) {
                    onWeaponInventoryChanged(secondary);
                    bulletStack = null;
                  } 
                } 
                this.driveableData.func_70299_a(slot, bulletStack);
              } 
              if (this.epicShip)
                setShootDelay((int)(type.shootDelay(secondary) / ((this.driveableData.totalCrew * this.driveableData.totalCrew) + this.driveableData.maximumCrew * 0.1D) / (this.driveableData.maximumCrew * this.driveableData.maximumCrew) * 0.9D), secondary); 
              if (!this.epicShip)
                setShootDelay(type.shootDelay(secondary), secondary); 
              if (type.secondaryRecoil && this.rightMouseHeld)
                this.ramDelay = 30; 
              if (type.primaryRecoil && this.leftMouseHeld)
                this.ramDelay = 30; 
              this.canFireIT1 = false;
            } 
          } 
          break;
      } 
    } 
  }
  
  public Vector3f getOrigin(ShootPoint dp) {
    Vector3f localGunVec = new Vector3f((ReadableVector3f)dp.rootPos.position);
    if (dp.rootPos.part == EnumDriveablePart.turret) {
      Vector3f.sub(localGunVec, (getDriveableType()).turretOrigin, localGunVec);
      localGunVec = (this.seats[0]).looking.findLocalVectorGlobally(localGunVec);
      Vector3f.add(localGunVec, (getDriveableType()).turretOrigin, localGunVec);
    } 
    return rotate(localGunVec);
  }
  
  public Vector3f getPositionOnTurret(Vector3f vecIn, boolean barrel) {
    Vector3f transform = vecIn;
    RotatedAxes yawOnlyLooking = new RotatedAxes((this.seats[0]).looking.getYaw(), 0.0F, 0.0F);
    if (barrel)
      yawOnlyLooking = (this.seats[0]).looking; 
    Vector3f.sub(transform, (getDriveableType()).turretOrigin, transform);
    transform = yawOnlyLooking.findLocalVectorGlobally(transform);
    Vector3f.add(transform, (getDriveableType()).turretOrigin, transform);
    Vector3f turretOriginOffset = new Vector3f((ReadableVector3f)(getDriveableType()).turretOriginOffset);
    turretOriginOffset = yawOnlyLooking.findLocalVectorGloballyYaw(turretOriginOffset);
    Vector3f.add(transform, turretOriginOffset, transform);
    return rotate(transform);
  }
  
  public Vector3f getDirection(ShootPoint dp, Vector3f vIn) {
    Vector3f localGunVec = new Vector3f((ReadableVector3f)vIn);
    localGunVec = (this.seats[0]).looking.findLocalVectorGlobally(localGunVec);
    return rotate(localGunVec);
  }
  
  public Vector3f getLookVector(ShootPoint dp) {
    return this.axes.getXAxis();
  }
  
  public Vector3f getFiringPosition(ShootPoint dp) {
    Vector3f rootVector = new Vector3f((ReadableVector3f)dp.rootPos.position);
    Vector3f offsetVector = new Vector3f((ReadableVector3f)dp.offPos);
    Vector3f localGunVec = new Vector3f((ReadableVector3f)dp.rootPos.position);
    if (dp.rootPos.part == EnumDriveablePart.turret)
      if (offsetVector.x == 0.0F && offsetVector.y == 0.0F && offsetVector.z == 0.0F) {
        Vector3f.sub(localGunVec, (getDriveableType()).turretOrigin, localGunVec);
        localGunVec = (this.seats[0]).looking.findLocalVectorGlobally(localGunVec);
        Vector3f.add(localGunVec, (getDriveableType()).turretOrigin, localGunVec);
      } else {
        RotatedAxes yawOnlyLooking = new RotatedAxes((this.seats[0]).looking.getYaw(), 0.0F, 0.0F);
        Vector3f.sub(rootVector, (getDriveableType()).turretOrigin, rootVector);
        rootVector = yawOnlyLooking.findLocalVectorGlobally(rootVector);
        Vector3f.add(rootVector, (getDriveableType()).turretOrigin, rootVector);
        Vector3f.sub(offsetVector, (getDriveableType()).turretOrigin, offsetVector);
        offsetVector = (this.seats[0]).looking.findLocalVectorGlobally(offsetVector);
        Vector3f.add(rootVector, offsetVector, localGunVec);
      }  
    return rotate(localGunVec);
  }
  
  public Vector3f getFakeFiringPosition(ShootPoint dp) {
    Vector3f rootVector = new Vector3f((ReadableVector3f)dp.rootPos.position);
    Vector3f offsetVector = new Vector3f((ReadableVector3f)dp.offPos);
    Vector3f localGunVec = new Vector3f((ReadableVector3f)dp.rootPos.position);
    Vector3f dumbOffset = new Vector3f(0.0F, offsetVector.y, offsetVector.z);
    Vector3f Xoffset = new Vector3f(offsetVector.x, 0.0F, 0.0F);
    if (dp.rootPos.part == EnumDriveablePart.turret)
      if (offsetVector.x == 0.0F && offsetVector.y == 0.0F && offsetVector.z == 0.0F) {
        Vector3f.sub(localGunVec, (getDriveableType()).turretOrigin, localGunVec);
        localGunVec = (this.seats[0]).looking.findLocalVectorGlobally(localGunVec);
        Vector3f.add(localGunVec, (getDriveableType()).turretOrigin, localGunVec);
      } else {
        RotatedAxes yawOnlyLooking = new RotatedAxes((this.seats[0]).looking.getYaw(), 0.0F, 0.0F);
        Vector3f.sub(rootVector, (getDriveableType()).turretOrigin, rootVector);
        rootVector = yawOnlyLooking.findLocalVectorGlobally(rootVector);
        Vector3f.add(rootVector, (getDriveableType()).turretOrigin, rootVector);
        Vector3f.sub(offsetVector, (getDriveableType()).turretOrigin, offsetVector);
        offsetVector = (this.seats[0]).looking.findLocalVectorGlobally(offsetVector);
        Vector3f.add(rootVector, dumbOffset, localGunVec);
      }  
    return rotate(localGunVec);
  }
  
  public void correctWheelPos() {
    if (this.field_70173_aa % 200 == 0)
      for (EntityWheel wheel : this.wheels) {
        if (wheel != null) {
          Vector3f target = this.axes.findLocalVectorGlobally(((getDriveableType()).wheelPositions[wheel.ID]).position);
          target.x = (float)(target.x + this.field_70165_t);
          target.y = (float)(target.y + this.field_70163_u);
          target.z = (float)(target.z + this.field_70161_v);
          int tf = 1;
          int cf = 1;
          int range = 5;
          if (MathHelper.func_76135_e(target.x - (float)wheel.field_70165_t) > range)
            wheel.field_70165_t = ((target.x * tf + (float)wheel.field_70165_t * cf) / (tf + cf)); 
          if (MathHelper.func_76135_e(target.y - (float)wheel.field_70163_u) > range)
            wheel.field_70163_u = ((target.y * tf + (float)wheel.field_70163_u * cf) / (tf + cf)); 
          if (MathHelper.func_76135_e(target.z - (float)wheel.field_70161_v) > range)
            wheel.field_70161_v = ((target.z * tf + (float)wheel.field_70161_v * cf) / (tf + cf)); 
        } 
      }  
  }
  
  public void func_70071_h_() {
    this.epicShip = (getDriveableType()).epicShip;
    super.func_70071_h_();
    DriveableType type = getDriveableType();
    DriveableData data = getDriveableData();
    this.hugeBoat = (((getDriveableType()).floatOnWater && (getDriveableType()).wheelStepHeight == 0.0F) || (getDriveableType()).solid);
    this.mounted = func_70115_ae();
    if (this.driveableData.overheat > 0)
      this.driveableData.overheat--; 
    if (this.driveableData.overheat < 0)
      this.driveableData.overheat = 0; 
    if (this.driveableData.overheat > type.overheatLimit) {
      this.driveableData.overheatSuffer = type.overheatPenalty;
      PacketPlaySound.sendSoundPacket((this.seats[0]).field_70165_t, (this.seats[0]).field_70163_u, (this.seats[0]).field_70161_v, 15.0D, this.field_71093_bK, type.overheatSound, false);
    } 
    if (this.driveableData.overheatSuffer > 0) {
      this.driveableData.overheatSuffer--;
      if (this.driveableData.overheat > 0)
        this.driveableData.overheat -= type.coolingBonus; 
    } 
    if (!this.field_70170_p.field_72995_K && type != null && type.numMissileSlots > 0 && this.field_70173_aa % 5 == 0) {
      int slot = -1;
      for (int k = type.numMissileSlots; k > -1; k--) {
        ItemStack shellCurrent = this.driveableData.func_70301_a(k);
        if (shellCurrent != null && shellCurrent.func_77973_b() instanceof ItemBullet && (getDriveableType()).ammo.contains(((ItemBullet)shellCurrent.func_77973_b()).type)) {
          slot = k;
          break;
        } 
      } 
      if (slot != -1 && this.seats != null && this.seats[0] != null && (this.seats[0]).field_70153_n != null && (this.seats[0]).field_70153_n instanceof EntityPlayerMP)
        FlansMod.getPacketHandler().sendTo((PacketBase)new PacketCurrentMissile(func_145782_y(), this.driveableData.func_70301_a(slot)), (EntityPlayerMP)(this.seats[0]).field_70153_n); 
    } 
    if (this.driveableData.WarpLimit < type.numPassengers) {
      this.warpTimer--;
      if (this.warpTimer == 1)
        this.driveableData.WarpLimit++; 
      if (this.warpTimer <= 0)
        this.warpTimer = 1200; 
    } else {
      this.warpTimer = 1200;
    } 
    if (this.hugeBoat)
      for (int k = 0; k < this.field_70170_p.field_72996_f.size(); k++) {
        Object obj = this.field_70170_p.field_72996_f.get(k);
        if (obj instanceof EntityPlayer && !isPartOfThis((Entity)obj))
          moveRiders((Entity)obj); 
        if (!(obj instanceof EntityWheel) || isPartOfThis((Entity)obj) || func_70032_d((Entity)obj) <= (getDriveableType()).bulletDetectionRadius);
        if (!(obj instanceof EntityDriveable) || isPartOfThis((Entity)obj) || func_70032_d((Entity)obj) <= (getDriveableType()).bulletDetectionRadius);
      }  
    if (this.seats[0] != null)
      if ((this.seats[0]).field_70153_n != null)
        if (type.nightScope && this.aiming)
          if (!this.field_70170_p.field_72995_K)
            ((EntityLivingBase)(this.seats[0]).field_70153_n).func_70690_d(new PotionEffect(Potion.field_76439_r.field_76415_H, 60));    
    if (this.deckCheck != this.prevDeckCheck) {
      this.onDeck = true;
    } else {
      this.onDeck = false;
    } 
    float e = 2.7182817F;
    float power = (float)(-0.5D * this.backwardsTimer);
    if (this.backwardsTimer > 0) {
      this.recoilEnergy = (float)(((getDriveableType()).primaryRecoilHeight - (getDriveableType()).primaryRecoilHeight * Math.pow(e, power)) * Math.pow(0.8999999761581421D, this.backwardsTimer));
    } else {
      this.recoilEnergy = 0.0F;
    } 
    float engineSum = 0.0F;
    float engineTotal = 0.0F;
    float engine1 = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine)).health;
    float engine2 = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine2)).health;
    float engine3 = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine3)).health;
    float engine4 = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine4)).health;
    float engine5 = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine5)).health;
    float engine6 = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine6)).health;
    float engine1m = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine)).maxHealth;
    float engine2m = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine2)).maxHealth;
    float engine3m = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine3)).maxHealth;
    float engine4m = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine4)).maxHealth;
    float engine5m = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine5)).maxHealth;
    float engine6m = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.engine6)).maxHealth;
    engineSum = engine1 + engine2 + engine3 + engine4 + engine5 + engine6;
    engineTotal = engine1m + engine2m + engine3m + engine4m + engine5m + engine6m;
    float engineRatio = (engineSum + 1.0F) / engineTotal;
    if (this.throttle > engineRatio)
      this.throttle = engineRatio; 
    if (type.IT1 && !this.disabled) {
      boolean fireButtonheld = false;
      if (type.weaponType(false) == EnumWeaponType.MISSILE)
        fireButtonheld = this.leftMouseHeld; 
      if (type.weaponType(true) == EnumWeaponType.MISSILE)
        fireButtonheld = this.rightMouseHeld; 
      this.prevDrakonDoorAngle = this.drakonDoorAngle;
      this.prevDrakonArmAngle = this.drakonArmAngle;
      this.prevDrakonRailAngle = this.drakonRailAngle;
      if (this.canFireIT1)
        this.reloadingDrakon = false; 
      if (this.stage == 0)
        this.stage = 1; 
      if (this.stage == 8 && fireButtonheld) {
        this.stage = 1;
        this.timeTillDeactivate = 5;
        this.toDeactivate = true;
      } 
      if (this.timeTillDeactivate <= 0 && this.toDeactivate) {
        this.canFireIT1 = false;
        this.toDeactivate = false;
      } 
      if (this.reloadAnimTime <= 0)
        IT1Reload(); 
      this.reloadAnimTime--;
      this.timeTillDeactivate--;
    } 
    if (this.shieldHitTimer > 0)
      this.shieldHitTimer--; 
    this.prevPropAngle = this.propAngle;
    this.prevRotorAngle = this.rotorAngle;
    if (this.throttle != 0.0F) {
      this.propAngle = (float)(this.propAngle + Math.pow(this.throttle, 0.4D) * 1.5D);
      this.rotorAngle += this.throttle / 7.0F;
    } 
    if ((this.leftMouseHeld && !this.disabled) || this.ticksRepairing > 1) {
      tryRecoil();
      setRecoilTimer();
    } 
    this.lastRecoilPos = this.recoilPos;
    if (this.recoilPos > 180.0F - 180.0F / type.recoilTime)
      this.recoilPos = 0.0F; 
    if (this.recoilTimer <= 0)
      this.isRecoil = false; 
    if (this.isRecoil)
      this.recoilPos += 180.0F / type.recoilTime; 
    if (this.recoilTimer >= 0) {
      this.recoilTimer--;
      this.backwardsTimer++;
    } else {
      this.backwardsTimer = 0;
    } 
    if (this.recoilTimer < 0.1F * (getDriveableType()).shootDelayPrimary)
      this.backwardsTimer = 0; 
    checkInventoryChanged();
    if (this.field_70170_p.func_72953_d(this.field_70121_D) && !this.hugeBoat) {
      if (this.throttle >= type.maxThrottleInWater)
        this.throttle = type.maxThrottleInWater; 
      if (this.throttle <= -type.maxThrottleInWater)
        this.throttle = -type.maxThrottleInWater; 
      if (this.field_70170_p.func_72953_d(this.field_70121_D.func_72329_c().func_72317_d(0.0D, type.maxDepth, 0.0D))) {
        this.throttle = 0.0F;
        this.disabled = true;
      } 
    } else {
      this.disabled = false;
    } 
    if (TeamsManager.violence == true)
      this.throttle = 0.0F; 
    if (this.isShowedPosition)
      for (Object obj : this.field_70170_p.field_72996_f) {
        Entity entityy = (Entity)obj;
        if (entityy instanceof EntityPlayer)
          ((EntityPlayer)entityy).func_145747_a((IChatComponent)new ChatComponentText("Position is " + this.field_70165_t + this.field_70161_v + " Distance is " + func_70032_d(entityy))); 
      }  
    if (type.lockOnToLivings || type.lockOnToMechas || type.lockOnToPlanes || type.lockOnToPlayers || type.lockOnToVehicles)
      if (!this.field_70170_p.field_72995_K && this.seats.length > 0 && this.lockOnSoundDelay <= 0)
        if (this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer) {
          Vector3f playerVecRelToVehicle = (this.seats[0]).playerLooking.findGlobalVectorLocally(new Vector3f(-1.0F, 0.0F, 0.0F));
          Vector3f playerVec = this.axes.findGlobalVectorLocally(playerVecRelToVehicle);
          for (Object obj : this.field_70170_p.field_72996_f) {
            Entity entity = (Entity)obj;
            if ((type.lockOnToMechas && entity instanceof com.flansmod.common.driveables.mechas.EntityMecha) || (type.lockOnToVehicles && entity instanceof EntityVehicle) || (type.lockOnToPlanes && entity instanceof EntityPlane) || (type.lockOnToPlayers && entity instanceof EntityPlayer) || (type.lockOnToLivings && entity instanceof EntityLivingBase))
              if (func_70068_e(entity) < (type.maxRangeLockOn * type.maxRangeLockOn)) {
                FlansMod.log(entity.toString());
                Vector3f relPosVec = new Vector3f(-entity.field_70165_t + (this.seats[0]).field_70165_t, -entity.field_70163_u + (this.seats[0]).field_70163_u, entity.field_70161_v - (this.seats[0]).field_70161_v);
                float angle = Math.abs(Vector3f.angle(playerVec, relPosVec));
                if (angle < Math.toRadians(type.canLockOnAngle)) {
                  PacketPlaySound.sendSoundPacket((this.seats[0]).field_70165_t, (this.seats[0]).field_70163_u, (this.seats[0]).field_70161_v, 10.0D, this.field_71093_bK, type.lockOnSound, false);
                  if (entity instanceof EntityDriveable)
                    PacketPlaySound.sendSoundPacket(entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, (((EntityDriveable)entity).getDriveableType()).lockedOnSoundRange, entity.field_71093_bK, (((EntityDriveable)entity).getDriveableType()).lockingOnSound, false); 
                  this.lockOnSoundDelay = type.lockOnSoundTime;
                  break;
                } 
              }  
          } 
        }   
    if (this.lockOnSoundDelay > 0)
      this.lockOnSoundDelay--; 
    DriveablePart bow = (getDriveableData()).parts.get(EnumDriveablePart.bow);
    DriveablePart stern = (getDriveableData()).parts.get(EnumDriveablePart.stern);
    DriveablePart leftShip = (getDriveableData()).parts.get(EnumDriveablePart.left);
    DriveablePart right = (getDriveableData()).parts.get(EnumDriveablePart.right);
    DriveablePart midsection = (getDriveableData()).parts.get(EnumDriveablePart.midsection);
    if ((type.epicShip && (this.ticksFlareUsing > 0 || (bow.health <= 0 && bow.maxHealth > 0) || (stern.health <= 0 && stern.maxHealth > 0) || (leftShip.health <= 0 && leftShip.maxHealth > 0) || (right.health <= 0 && right.maxHealth > 0) || (midsection.health <= 0 && midsection.maxHealth > 0))) || this.ticksRepairing > 0)
      this.throttle = 0.0F; 
    if (type.crewEngine && this.throttle > 0.01D && this.throttle > this.driveableData.totalCrew / this.driveableData.maximumCrew)
      this.throttle = this.driveableData.totalCrew / this.driveableData.maximumCrew; 
    if (type.crewEngine && this.throttle < -0.01D && this.throttle < -1.0F * this.driveableData.totalCrew / this.driveableData.maximumCrew)
      this.throttle = -1.0F * this.driveableData.totalCrew / this.driveableData.maximumCrew; 
    if (this.field_70154_o != null) {
      this.invulnerableUnmountCount = 80;
    } else if (this.invulnerableUnmountCount > 0) {
      this.invulnerableUnmountCount--;
    } 
    if (!this.field_70170_p.field_72995_K) {
      int k;
      for (k = 0; k < (getDriveableType()).numPassengers + 1; k++) {
        if (this.seats[k] == null || !(this.seats[k]).field_70175_ag) {
          this.seats[k] = new EntitySeat(this.field_70170_p, this, k);
          this.field_70170_p.func_72838_d(this.seats[k]);
        } 
      } 
      for (k = 0; k < type.wheelPositions.length; k++) {
        if (this.wheels[k] == null || !(this.wheels[k]).field_70175_ag) {
          this.wheels[k] = new EntityWheel(this.field_70170_p, this, k);
          this.field_70170_p.func_72838_d(this.wheels[k]);
        } 
      } 
    } 
    if (hasEnoughFuel())
      this.harvesterAngle += this.throttle / 5.0F; 
    for (DriveablePart part : (getDriveableData()).parts.values()) {
      if (part.box != null) {
        part.update(this);
        if (this.field_70170_p.field_72995_K) {
          if (part.onFire) {
            Vector3f pos = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x + this.field_70146_Z.nextFloat() * part.box.w, part.box.y + this.field_70146_Z.nextFloat() * part.box.h, part.box.z + this.field_70146_Z.nextFloat() * part.box.d));
            this.field_70170_p.func_72869_a("flame", this.field_70165_t + pos.x, this.field_70163_u + pos.y, this.field_70161_v + pos.z, 0.0D, 0.0D, 0.0D);
          } 
          if (part.health > 0 && part.health < part.maxHealth / 2) {
            Vector3f pos = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x + this.field_70146_Z.nextFloat() * part.box.w, part.box.y + this.field_70146_Z.nextFloat() * part.box.h, part.box.z + this.field_70146_Z.nextFloat() * part.box.d));
            this.field_70170_p.func_72869_a((part.health < part.maxHealth / 4) ? "largesmoke" : "smoke", this.field_70165_t + pos.x, this.field_70163_u + pos.y, this.field_70161_v + pos.z, 0.0D, 0.0D, 0.0D);
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak)).maxHealth > 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak)).health == 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).health > 0) {
            Vector3f pos = this.axes.findLocalVectorGlobally(new Vector3f(((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak)).box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak)).box.d));
            this.field_70170_p.func_72869_a("flame", this.field_70165_t + pos.x, this.field_70163_u + pos.y, this.field_70161_v + pos.z, 0.0D, 0.0D, 0.0D);
            Vector3f posturret = this.axes.findLocalVectorGlobally(new Vector3f(((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.d));
            this.field_70170_p.func_72869_a("flame", this.field_70165_t + posturret.x, this.field_70163_u + posturret.y, this.field_70161_v + posturret.z, 0.0D, 0.0D, 0.0D);
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak2)).maxHealth > 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak2)).health == 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).health > 0) {
            Vector3f pos = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak2)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak2)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak2)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak2)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turretWeak2)).box.d));
            this.field_70170_p.func_72869_a("flame", this.field_70165_t + pos.x, this.field_70163_u + pos.y, this.field_70161_v + pos.z, 0.0D, 0.0D, 0.0D);
            Vector3f posturret = this.axes.findLocalVectorGlobally(new Vector3f(((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.d));
            this.field_70170_p.func_72869_a("flame", this.field_70165_t + posturret.x, this.field_70163_u + posturret.y, this.field_70161_v + posturret.z, 0.0D, 0.0D, 0.0D);
          } 
          if ((type.epicShip && this.ticksFlareUsing > 0) || this.ticksRepairing > 0) {
            if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).maxHealth > 0) {
              Vector3f posleft = this.axes.findLocalVectorGlobally(new Vector3f(((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).box.d));
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t + posleft.x, this.field_70163_u + posleft.y, this.field_70161_v + posleft.z, 1, "heart"), this.field_70165_t + posleft.x, this.field_70163_u + posleft.y, this.field_70161_v + posleft.z, 200.0F, this.field_71093_bK);
            } 
            if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).maxHealth > 0) {
              Vector3f posleft = this.axes.findLocalVectorGlobally(new Vector3f(((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).box.d));
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t + posleft.x, this.field_70163_u + posleft.y, this.field_70161_v + posleft.z, 1, "heart"), this.field_70165_t + posleft.x, this.field_70163_u + posleft.y, this.field_70161_v + posleft.z, 200.0F, this.field_71093_bK);
            } 
            if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).maxHealth > 0) {
              Vector3f posleft = this.axes.findLocalVectorGlobally(new Vector3f(((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).box.d));
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t + posleft.x, this.field_70163_u + posleft.y, this.field_70161_v + posleft.z, 1, "heart"), this.field_70165_t + posleft.x, this.field_70163_u + posleft.y, this.field_70161_v + posleft.z, 200.0F, this.field_71093_bK);
            } 
            if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).maxHealth > 0) {
              Vector3f posright = this.axes.findLocalVectorGlobally(new Vector3f(((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).box.d));
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t + posright.x, this.field_70163_u + posright.y, this.field_70161_v + posright.z, 1, "heart"), this.field_70165_t + posright.x, this.field_70163_u + posright.y, this.field_70161_v + posright.z, 200.0F, this.field_71093_bK);
            } 
            if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).maxHealth > 0) {
              Vector3f posbow = this.axes.findLocalVectorGlobally(new Vector3f(((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).box.d));
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t + posbow.x, this.field_70163_u + posbow.y, this.field_70161_v + posbow.z, 1, "heart"), this.field_70165_t + posbow.x, this.field_70163_u + posbow.y, this.field_70161_v + posbow.z, 200.0F, this.field_71093_bK);
            } 
            if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).maxHealth > 0) {
              Vector3f posstern = this.axes.findLocalVectorGlobally(new Vector3f(((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).box.d));
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t + posstern.x, this.field_70163_u + posstern.y, this.field_70161_v + posstern.z, 1, "heart"), this.field_70165_t + posstern.x, this.field_70163_u + posstern.y, this.field_70161_v + posstern.z, 200.0F, this.field_71093_bK);
            } 
            if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).maxHealth > 0) {
              Vector3f posmid = this.axes.findLocalVectorGlobally(new Vector3f(((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).box.x + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).box.w, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).box.y + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).box.h, ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).box.z + this.field_70146_Z.nextFloat() * ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).box.d));
              FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketFlak(this.field_70165_t + posmid.x, this.field_70163_u + posmid.y, this.field_70161_v + posmid.z, 1, "heart"), this.field_70165_t + posmid.x, this.field_70163_u + posmid.y, this.field_70161_v + posmid.z, 200.0F, this.field_71093_bK);
            } 
          } 
        } 
        if (part.onFire) {
          if (this.field_70170_p.func_72896_J() && this.field_70146_Z.nextInt(40) == 0)
            part.onFire = false; 
          Vector3f pos = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x + part.box.w / 2.0F, part.box.y + part.box.h / 2.0F, part.box.z + part.box.d / 2.0F));
          if (this.field_70170_p.func_147439_a(MathHelper.func_76128_c(this.field_70165_t + pos.x), MathHelper.func_76128_c(this.field_70163_u + pos.y), MathHelper.func_76128_c(this.field_70161_v + pos.z)).func_149688_o() == Material.field_151586_h)
            part.onFire = false; 
          continue;
        } 
        Vector3f vector3f = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x / 16.0F + part.box.w / 32.0F, part.box.y / 16.0F + part.box.h / 32.0F, part.box.z / 16.0F + part.box.d / 32.0F));
      } 
    } 
    int i;
    for (i = 0; i < type.emitters.size(); i++) {
      DriveableType.ParticleEmitter emitter = type.emitters.get(i);
      this.emitterTimers[i] = this.emitterTimers[i] - 1;
      boolean canEmit = false;
      boolean inThrottle = false;
      DriveablePart part = (getDriveableData()).parts.get(EnumDriveablePart.getPart(emitter.part));
      float healthPercentage = part.health / part.maxHealth;
      if (isPartIntact(EnumDriveablePart.getPart(emitter.part)) && healthPercentage >= emitter.minHealth && healthPercentage <= emitter.maxHealth) {
        canEmit = true;
      } else {
        canEmit = false;
      } 
      if (this.throttle >= emitter.minThrottle && this.throttle <= emitter.maxThrottle)
        inThrottle = true; 
      if (this.isMecha)
        inThrottle = true; 
      if (this.emitterTimers[i] <= 0) {
        if (inThrottle && canEmit) {
          Vector3f velocity = new Vector3f(0.0F, 0.0F, 0.0F);
          Vector3f pos = new Vector3f(0.0F, 0.0F, 0.0F);
          if (this.seats != null && this.seats[0] != null) {
            if (EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.turret && EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.barrel) {
              Vector3f localPosition = new Vector3f(emitter.origin.x + this.field_70146_Z.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5F, emitter.origin.y + this.field_70146_Z.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5F, emitter.origin.z + this.field_70146_Z.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5F);
              pos = this.axes.findLocalVectorGlobally(localPosition);
              velocity = this.axes.findLocalVectorGlobally(emitter.velocity);
            } else if (EnumDriveablePart.getPart(emitter.part) == EnumDriveablePart.turret || (EnumDriveablePart.getPart(emitter.part) == EnumDriveablePart.head && emitter.part != "barrel")) {
              Vector3f localPosition2 = new Vector3f(emitter.origin.x + this.field_70146_Z.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5F, emitter.origin.y + this.field_70146_Z.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5F, emitter.origin.z + this.field_70146_Z.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5F);
              pos = getPositionOnTurret(localPosition2, false);
              velocity = getPositionOnTurret(emitter.velocity, false);
            } else if (EnumDriveablePart.getPart(emitter.part) == EnumDriveablePart.barrel) {
              Vector3f localPosition2 = new Vector3f(emitter.origin.x + this.field_70146_Z.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5F, emitter.origin.y + this.field_70146_Z.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5F, emitter.origin.z + this.field_70146_Z.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5F);
              pos = getPositionOnTurret(localPosition2, true);
              velocity = getPositionOnTurret(emitter.velocity, true);
            } 
            FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle(emitter.effectType, this.field_70165_t + pos.x, this.field_70163_u + pos.y, this.field_70161_v + pos.z, velocity.x, velocity.y, velocity.z), this.field_70165_t + pos.x, this.field_70163_u + pos.y, this.field_70161_v + pos.z, 150.0F, this.field_71093_bK);
          } 
        } 
        this.emitterTimers[i] = emitter.emitRate;
      } 
    } 
    for (i = 0; i < type.afterBurns.size(); i++) {
      DriveableType.AfterBurnEmitter emitter = type.afterBurns.get(i);
      boolean canEmit = false;
      boolean inThrottle = false;
      DriveablePart part = (getDriveableData()).parts.get(EnumDriveablePart.getPart(emitter.part));
      if (this.afterBurning) {
        canEmit = true;
      } else {
        canEmit = false;
      } 
      if (canEmit) {
        Vector3f velocity = new Vector3f(0.0F, 0.0F, 0.0F);
        Vector3f pos = new Vector3f(0.0F, 0.0F, 0.0F);
        if (this.seats != null && this.seats[0] != null) {
          if (EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.turret && EnumDriveablePart.getPart(emitter.part) != EnumDriveablePart.barrel) {
            Vector3f localPosition = new Vector3f(emitter.origin.x + this.field_70146_Z.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5F, emitter.origin.y + this.field_70146_Z.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5F, emitter.origin.z + this.field_70146_Z.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5F);
            pos = this.axes.findLocalVectorGlobally(localPosition);
            velocity = this.axes.findLocalVectorGlobally(emitter.velocity);
          } else if (EnumDriveablePart.getPart(emitter.part) == EnumDriveablePart.turret || (EnumDriveablePart.getPart(emitter.part) == EnumDriveablePart.head && emitter.part != "barrel")) {
            Vector3f localPosition2 = new Vector3f(emitter.origin.x + this.field_70146_Z.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5F, emitter.origin.y + this.field_70146_Z.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5F, emitter.origin.z + this.field_70146_Z.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5F);
            pos = getPositionOnTurret(localPosition2, false);
            velocity = getPositionOnTurret(emitter.velocity, false);
          } else if (EnumDriveablePart.getPart(emitter.part) == EnumDriveablePart.barrel) {
            Vector3f localPosition2 = new Vector3f(emitter.origin.x + this.field_70146_Z.nextFloat() * emitter.extents.x - emitter.extents.x * 0.5F, emitter.origin.y + this.field_70146_Z.nextFloat() * emitter.extents.y - emitter.extents.y * 0.5F, emitter.origin.z + this.field_70146_Z.nextFloat() * emitter.extents.z - emitter.extents.z * 0.5F);
            pos = getPositionOnTurret(localPosition2, true);
            velocity = getPositionOnTurret(emitter.velocity, true);
          } 
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle(emitter.effectType, this.field_70165_t + pos.x, this.field_70163_u + pos.y, this.field_70161_v + pos.z, velocity.x, velocity.y, velocity.z), this.field_70165_t + pos.x, this.field_70163_u + pos.y, this.field_70161_v + pos.z, 150.0F, this.field_71093_bK);
        } 
      } 
    } 
    checkParts();
    this.field_70126_B = this.axes.getYaw();
    this.field_70127_C = this.axes.getPitch();
    this.prevRotationRoll = this.axes.getRoll();
    this.prevAxes = this.axes.clone();
    if (this.field_70153_n != null && this.field_70153_n.field_70128_L)
      this.field_70153_n = null; 
    if (this.field_70153_n != null && this.field_70128_L)
      this.field_70153_n.func_70078_a(null); 
    if (this.field_70153_n != null)
      this.field_70153_n.field_70143_R = 0.0F; 
    boolean canThrust = (driverIsCreative() || this.driveableData.fuelInTank > 0.0F);
    if ((this.seats[0] != null && (this.seats[0]).field_70153_n == null) || (!canThrust && (getDriveableType()).maxThrottle != 0.0F && (getDriveableType()).maxNegativeThrottle != 0.0F))
      this.throttle *= 0.9995F; 
    if (this.seats[0] != null && (this.seats[0]).field_70153_n == null)
      this.rightMouseHeld = this.leftMouseHeld = false; 
    if (this.shootDelayPrimary > 0)
      this.shootDelayPrimary--; 
    if (this.shootDelaySecondary > 0)
      this.shootDelaySecondary--; 
    if (data.fakeReloadShell > 0.0F);
    data.fakeReloadShell--;
    if (data.fakeReloadMissile > 0.0F);
    data.fakeReloadMissile--;
    if ((getDriveableType()).reloadSoundTick != 15214541 && this.shootDelayPrimary == (getDriveableType()).reloadSoundTick)
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.shootReloadSound, false); 
    if (this.field_70173_aa == 1) {
      if (type.hasAPS)
        this.APSchecker = 1; 
      this.APSmax = type.APSdelayMax;
      this.damageVsCrew = type.damageVsCrew;
      if (!this.driveableData.emergencyMode) {
        setShootDelay((getDriveableType()).placeTimePrimary, false);
        setShootDelay((getDriveableType()).placeTimeSecondary, true);
        data.fakeReloadShell = (getDriveableType()).placeTimePrimary;
        data.fakeReloadMissile = (getDriveableType()).placeTimeSecondary;
      } 
      if (!this.field_70170_p.field_72995_K) {
        if (!(getDriveableType()).placeSoundPrimary.isEmpty())
          PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, 
              (getDriveableType()).placeSoundPrimary, false); 
        if (!(getDriveableType()).placeSoundSecondary.isEmpty())
          PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, 
              (getDriveableType()).placeSoundSecondary, false); 
      } 
    } 
    if (!this.field_70170_p.field_72995_K) {
      if (this.leftMouseHeld && (getDriveableType()).modePrimary == EnumFireMode.FULLAUTO && !(getDriveableType()).needsThrottle)
        shoot(false); 
      if (this.leftMouseHeld && (getDriveableType()).modePrimary == EnumFireMode.FULLAUTO && (getDriveableType()).needsThrottle == true && this.throttle > 0.7D)
        shoot(false); 
      if (this.rightMouseHeld && (getDriveableType()).modeSecondary == EnumFireMode.FULLAUTO) {
        shoot(true);
        if (type.secondaryRecoil && this.rightMouseHeld)
          this.ramDelay = 20; 
      } 
      this.minigunSpeedPrimary *= 0.9F;
      this.minigunSpeedSecondary *= 0.9F;
      if (this.leftMouseHeld && (getDriveableType()).modePrimary == EnumFireMode.MINIGUN) {
        this.minigunSpeedPrimary += 0.1F;
        if (this.minigunSpeedPrimary > 1.0F)
          shoot(false); 
      } 
      if (this.rightMouseHeld && (getDriveableType()).modeSecondary == EnumFireMode.MINIGUN) {
        this.minigunSpeedSecondary += 0.1F;
        if (this.minigunSpeedSecondary > 1.0F)
          shoot(true); 
      } 
    } 
    this.prevDeckCheck = this.deckCheck;
    int fuelMultiplier = 2;
    if (data.fuelInTank >= type.fuelTankSize)
      return; 
    for (int j = 0; j < data.func_70302_i_(); j++) {
      ItemStack stack = data.func_70301_a(j);
      if (stack != null && stack.field_77994_a > 0) {
        Item item = stack.func_77973_b();
        if (data.engine.useRFPower) {
          if (item instanceof IEnergyContainerItem) {
            IEnergyContainerItem energy = (IEnergyContainerItem)item;
            data.fuelInTank += (fuelMultiplier * energy.extractEnergy(stack, data.engine.RFDrawRate, false) / data.engine.RFDrawRate);
          } 
        } else {
          if (item instanceof ItemPart) {
            PartType part = ((ItemPart)item).type;
            if (part.category == 9) {
              data.fuelInTank += fuelMultiplier;
              int damage = stack.func_77960_j();
              stack.func_77964_b(damage + 1);
              if (damage >= stack.func_77958_k()) {
                stack.func_77964_b(0);
                stack.field_77994_a--;
                if (stack.field_77994_a <= 0)
                  data.func_70299_a(j, null); 
              } 
              break;
            } 
          } else if (FlansMod.hooks.BuildCraftLoaded && stack.func_77969_a(FlansMod.hooks.BuildCraftOilBucket) && data.fuelInTank + (1000 * fuelMultiplier) <= type.fuelTankSize) {
            data.fuelInTank += (1000 * fuelMultiplier);
            data.func_70299_a(j, new ItemStack(Items.field_151133_ar));
          } else if (FlansMod.hooks.BuildCraftLoaded && stack.func_77969_a(FlansMod.hooks.BuildCraftFuelBucket) && data.fuelInTank + (2000 * fuelMultiplier) <= type.fuelTankSize) {
            data.fuelInTank += (2000 * fuelMultiplier);
            data.func_70299_a(j, new ItemStack(Items.field_151133_ar));
          } 
          this.field_70169_q = this.field_70165_t;
          this.field_70167_r = this.field_70163_u;
          this.field_70166_s = this.field_70161_v;
        } 
      } 
    } 
  }
  
  public void checkInventoryChanged() {
    DriveableType type = getDriveableType();
    if (type == null)
      return; 
    if (this.field_70170_p.field_72995_K)
      return; 
    if (!this.driveableData.inventoryChanged)
      return; 
    this.driveableData.inventoryChanged = false;
    try {
      for (int ps = 0; ps < 2; ps++) {
        EnumWeaponType weaponType = (ps == 0) ? type.primary : type.secondary;
        if (weaponType == EnumWeaponType.GUN)
          weaponType = EnumWeaponType.NONE; 
        int istart = getInventoryStart(weaponType);
        if (istart == this.driveableData.getAmmoInventoryStart())
          istart += type.numPassengerGunners; 
        int isize = getInventorySize(weaponType);
        if (istart >= 0 || isize > 0) {
          if (this.prevInventoryItems[ps] == null)
            this.prevInventoryItems[ps] = new ItemStack[isize]; 
          int i;
          for (i = 0; i < isize; i++) {
            ItemStack itemStack = this.driveableData.func_70301_a(istart + i);
            if (itemStack != null && itemStack.func_77973_b() instanceof ItemBullet)
              if (this.prevInventoryItems[ps][i] == null || !ItemStack.func_77989_b(itemStack, this.prevInventoryItems[ps][i]))
                if (type.isValidAmmo(((ItemBullet)itemStack.func_77973_b()).type, weaponType)) {
                  onWeaponInventoryChanged((ps == 1));
                  break;
                }   
          } 
          for (i = 0; i < isize; i++)
            this.prevInventoryItems[ps][i] = this.driveableData.func_70301_a(istart + i); 
        } 
      } 
    } catch (Exception e) {
      e.printStackTrace();
    } 
  }
  
  public void onWeaponInventoryChanged(boolean secondary) {
    DriveableType type = getDriveableType();
    if (!secondary) {
      if (type.reloadTimePrimary > 0 && getShootDelay(secondary) <= 0) {
        FlansMod.log("EntityDriveable Reload Primary " + type.reloadTimePrimary + " tick");
        setShootDelay(type.reloadTimePrimary, secondary);
        PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, 
            (getDriveableType()).reloadSoundPrimary, false);
      } 
    } else if (type.reloadTimeSecondary > 0 && getShootDelay(secondary) <= 0) {
      FlansMod.log("EntityDriveable Reload Secondary " + type.reloadTimeSecondary + " tick");
      setShootDelay(type.reloadTimeSecondary, secondary);
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, 
          (getDriveableType()).reloadSoundSecondary, false);
    } 
  }
  
  public int getInventoryStart(EnumWeaponType wt) {
    switch (wt) {
      case GUN:
      case NONE:
        return this.driveableData.getAmmoInventoryStart();
      case MISSILE:
      case SHELL:
        return this.driveableData.getMissileInventoryStart();
      case BOMB:
      case MINE:
        return this.driveableData.getBombInventoryStart();
    } 
    return -1;
  }
  
  public int getInventorySize(EnumWeaponType wt) {
    switch (wt) {
      case GUN:
      case NONE:
        return this.driveableData.ammo.length;
      case MISSILE:
      case SHELL:
        return this.driveableData.missiles.length;
      case BOMB:
      case MINE:
        return this.driveableData.bombs.length;
    } 
    return -1;
  }
  
  public void checkForCollisions() {
    boolean damagePart = false;
    boolean crashInWater = false;
    double speed = getSpeedXYZ();
    for (DriveablePosition p : (getDriveableType()).collisionPoints) {
      if (((DriveablePart)this.driveableData.parts.get(p.part)).dead)
        continue; 
      Vector3f lastRelPos = this.prevAxes.findLocalVectorGlobally(p.position);
      Vec3 lastPos = Vec3.func_72443_a(this.field_70169_q + lastRelPos.x, this.field_70167_r + lastRelPos.y, this.field_70166_s + lastRelPos.z);
      Vector3f currentRelPos = this.axes.findLocalVectorGlobally(p.position);
      Vec3 currentPos = Vec3.func_72443_a(this.field_70165_t + currentRelPos.x, this.field_70163_u + currentRelPos.y, this.field_70161_v + currentRelPos.z);
      if (FlansMod.DEBUG && this.field_70170_p.field_72995_K)
        this.field_70170_p.func_72838_d((Entity)new EntityDebugVector(this.field_70170_p, new Vector3f(lastPos), Vector3f.sub(currentRelPos, lastRelPos, null), 10, 1.0F, 0.0F, 0.0F)); 
      MovingObjectPosition hit = this.field_70170_p.func_72901_a(lastPos, currentPos, crashInWater);
      if (hit != null && hit.field_72313_a == MovingObjectPosition.MovingObjectType.BLOCK) {
        int x = hit.field_72311_b;
        int y = hit.field_72312_c;
        int z = hit.field_72309_d;
        Block blockHit = this.field_70170_p.func_147439_a(x, y, z);
        int meta = this.field_70170_p.func_72805_g(x, y, z);
        float blockHardness = blockHit.func_149712_f(this.field_70170_p, x, y, z);
        float damage = 1.0F + blockHardness * blockHardness * (float)speed;
        if (null == blockHit.func_149668_a(this.field_70170_p, x, y, z))
          damage = 0.0F; 
        if (damage > 0.0F) {
          damagePart = true;
          ((DriveablePart)(getDriveableData()).parts.get(p.part)).health -= (int)damage;
        } 
        if (!attackPart(p.part, DamageSource.field_76368_d, damage) && TeamsManager.driveablesBreakBlocks) {
          this.field_70170_p.func_72889_a(null, 2001, x, y, z, Block.func_149682_b(blockHit) + (meta << 12));
          ((DriveablePart)(getDriveableData()).parts.get(p.part)).health -= (int)damage + 1;
          if (!this.field_70170_p.field_72995_K) {
            blockHit.func_149697_b(this.field_70170_p, x, y, z, meta, 1);
            this.field_70170_p.func_147468_f(x, y, z);
          } 
          continue;
        } 
        ((DriveablePart)(getDriveableData()).parts.get(p.part)).health -= (int)damage;
        this.field_70170_p.func_72876_a(this, currentPos.field_72450_a, currentPos.field_72448_b, currentPos.field_72449_c, 1.0F, false);
      } 
    } 
    if (damagePart)
      if (!this.field_70170_p.field_72995_K)
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketDriveableDamage(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 100.0F, this.field_71093_bK);  
  }
  
  protected void func_70069_a(float k) {
    double fallDist = (this.field_70163_u - this.field_70167_r + this.field_70181_x) / 2.0D;
    float damage = (float)((fallDist < -0.3D) ? (-fallDist * 50.0D) : 0.0D);
    boolean no_damage = true;
    if (damage > 0.0F && this.invulnerableUnmountCount == 0 && this.field_70173_aa > 20 && !no_damage) {
      DriveableType type = getDriveableType();
      damage = (int)(damage * type.fallDamageFactor) * 0.5F;
      ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).health -= (int)damage + 1;
      if (type.wheelPositions.length > 0)
        attackPart((type.wheelPositions[0]).part, DamageSource.field_76379_h, damage / 5.0F); 
      no_damage = false;
    } 
  }
  
  public boolean func_70112_a(double d) {
    double d1 = this.field_70155_l;
    return (d < d1 * d1);
  }
  
  public boolean attackPart(EnumDriveablePart ep, DamageSource source, float damage) {
    if (ep == EnumDriveablePart.core)
      if (source.func_76364_f() instanceof EntityLivingBase) {
        this.lastAtkEntity = source.func_76364_f();
      } else if (source.func_76346_g() instanceof EntityLivingBase) {
        this.lastAtkEntity = source.func_76346_g();
      } else {
        this.lastAtkEntity = null;
      }  
    DriveablePart part = this.driveableData.parts.get(ep);
    return part.attack(damage, source.func_76347_k());
  }
  
  public Vector3f rotate(Vector3f inVec) {
    return this.axes.findLocalVectorGlobally(inVec);
  }
  
  public Vector3f rotate(Vec3 inVec) {
    return rotate(inVec.field_72450_a, inVec.field_72448_b, inVec.field_72449_c);
  }
  
  public Vector3f rotate(double x, double y, double z) {
    return rotate(new Vector3f((float)x, (float)y, (float)z));
  }
  
  public void rotateYaw(float rotateBy) {
    if (Math.abs(rotateBy) < 0.01F)
      return; 
    this.axes.rotateLocalYaw(rotateBy);
    updatePrevAngles();
  }
  
  public void rotatePitch(float rotateBy) {
    if (Math.abs(rotateBy) < 0.01F)
      return; 
    this.axes.rotateLocalPitch(rotateBy);
    updatePrevAngles();
  }
  
  public void rotateRoll(float rotateBy) {
    if (Math.abs(rotateBy) < 0.01F)
      return; 
    this.axes.rotateLocalRoll(rotateBy);
    updatePrevAngles();
  }
  
  public void updatePrevAngles() {
    double dYaw = (this.axes.getYaw() - this.field_70126_B);
    if (dYaw > 180.0D)
      this.field_70126_B += 360.0F; 
    if (dYaw < -180.0D)
      this.field_70126_B -= 360.0F; 
    double dPitch = (this.axes.getPitch() - this.field_70127_C);
    if (dPitch > 180.0D)
      this.field_70127_C += 360.0F; 
    if (dPitch < -180.0D)
      this.field_70127_C -= 360.0F; 
    double dRoll = (this.axes.getRoll() - this.prevRotationRoll);
    if (dRoll > 180.0D)
      this.prevRotationRoll += 360.0F; 
    if (dRoll < -180.0D)
      this.prevRotationRoll -= 360.0F; 
  }
  
  public void setRotation(float rotYaw, float rotPitch, float rotRoll) {
    this.axes.setAngles(rotYaw, rotPitch, rotRoll);
  }
  
  public boolean isPartOfThis(Entity ent) {
    for (EntitySeat seat : this.seats) {
      if (seat != null) {
        if (ent == seat)
          return true; 
        if (seat.field_70153_n == ent)
          return true; 
      } 
    } 
    return (ent == this);
  }
  
  public boolean hitboxPartOfThis(Entity ent) {
    if (this != null && this.seats[0] != null && (this.seats[0]).field_70153_n != null && ent != null && ent instanceof EntityPlayer && (this.seats[0]).field_70153_n instanceof EntityPlayer)
      return (ent == (EntityPlayer)(this.seats[0]).field_70153_n); 
    return false;
  }
  
  public float func_70053_R() {
    return 0.0F;
  }
  
  public DriveableType getDriveableType() {
    return DriveableType.getDriveable(this.driveableType);
  }
  
  public DriveableData getDriveableData() {
    return this.driveableData;
  }
  
  public boolean isDead() {
    return this.field_70128_L;
  }
  
  public Entity getControllingEntity() {
    return this.seats[0].getControllingEntity();
  }
  
  public ItemStack getPickedResult(MovingObjectPosition target) {
    ItemStack stack = new ItemStack((getDriveableType()).item, 1, 0);
    stack.field_77990_d = new NBTTagCompound();
    this.driveableData.writeToNBT(stack.field_77990_d);
    return stack;
  }
  
  public boolean hasFuel() {
    if (this.seats == null || this.seats[0] == null || (this.seats[0]).field_70153_n == null)
      return false; 
    return (driverIsCreative() || this.driveableData.fuelInTank > 0.0F);
  }
  
  public boolean hasEnoughFuel() {
    return (driverIsCreative() || this.driveableData.fuelInTank > this.driveableData.engine.fuelConsumption * this.throttle);
  }
  
  public double getSpeedXYZ() {
    return Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
  }
  
  public double getMPH() {
    float advancedSpeed = (float)Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
    if (advancedSpeed >= 1.05D && (Math.abs(this.field_70159_w) > 0.2D || Math.abs(this.field_70179_y) > 0.2D))
      return (1572.6646F * (float)Math.log(advancedSpeed)); 
    if (Math.abs(this.field_70159_w) > 0.2D || Math.abs(this.field_70179_y) > 0.2D)
      return (0.0F + advancedSpeed * 74.0F); 
    return 0.0D;
  }
  
  public double getSpeedXZ() {
    return Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70179_y * this.field_70179_y);
  }
  
  public boolean landVehicle() {
    return false;
  }
  
  public boolean gearDown() {
    return true;
  }
  
  public boolean onGround() {
    return this.field_70122_E;
  }
  
  public void moveRiders(Entity rider) {
    if (isPartOfThis(rider))
      return; 
    boolean isHuman = false;
    boolean isDriveable = false;
    if (!(rider instanceof EntityPlayer))
      return; 
    Vector3f riderPos = new Vector3f(rider.field_70165_t, rider.field_70163_u, rider.field_70161_v);
    Vector3f riderMotion = new Vector3f(rider.field_70159_w, rider.field_70181_x, rider.field_70181_x);
    Vector3f vehicleMotion = new Vector3f(this.field_70165_t - this.lastPos.x, this.field_70163_u - this.lastPos.y, this.field_70161_v - this.lastPos.z);
    if (rider instanceof EntityVehicle)
      vehicleMotion = ((EntityVehicle)rider).lastPos; 
    Vector3f vehiclePos = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    Vector3f relativePos = Vector3f.sub(riderPos, vehiclePos, null);
    if (rider instanceof EntityPlayer)
      isHuman = true; 
    if (rider instanceof EntityDriveable)
      isDriveable = true; 
    relativePos = new Vector3f(relativePos.x, relativePos.y - (isHuman ? 0.55F : 0.0F), relativePos.z);
    Vector3f rotatedPosVector = this.axes.findGlobalVectorLocally(relativePos);
    Vector3f rotatedMotionVector = this.axes.findGlobalVectorLocally(riderMotion);
    Vector3f ellipsoid = new Vector3f(rider.field_70130_N / 2.0F, rider.field_70131_O, rider.field_70130_N / 2.0F);
    CollisionTest test = new CollisionTest(ellipsoid, new Vector3f(relativePos.x, relativePos.y, relativePos.z), riderMotion);
    test.collisionRecursiveDepth = 0;
    Vector3f eSpacePosition = test.ConvertR3ToESpace(test.R3Position);
    Vector3f eSpaceVelocity = test.velocity;
    DriveableType type = getDriveableType();
    if (type.fancyCollision) {
      for (CollisionShapeBox sbox : type.collisionBox)
        checkCollision(test, sbox); 
    } else {
      for (DriveablePart part : (getDriveableData()).parts.values())
        part.rayTraceRider(this, test); 
    } 
    if (test.didCollide) {
      Vector3f finalPos = collideWithDriveable(test, eSpacePosition, eSpaceVelocity);
      if (finalPos == null) {
        finalPos = new Vector3f(0.0F, 0.0F, 0.0F);
        if (FlansMod.debugMode)
          FlansMod.log("EntityDriveable.java moveRiders> finalPos is null [1]"); 
      } 
      if (rider instanceof net.minecraft.entity.passive.EntityAnimal)
        return; 
      Vector3f velocity = Vector3f.sub(finalPos, test.basePoint, null);
      test.ConvertESpaceToR3(velocity);
      finalPos = new Vector3f(finalPos.x * test.eRad.x, finalPos.y * test.eRad.y, finalPos.z * test.eRad.z);
      if (finalPos == null) {
        finalPos = new Vector3f(0.0F, 0.0F, 0.0F);
        if (FlansMod.debugMode)
          FlansMod.log("EntityDriveable.java moveRiders> finalPos is null [2]"); 
      } 
      Vector3f diff = Vector3f.sub(finalPos, vehiclePos, null);
      if (!rider.field_70122_E || this.field_70163_u + finalPos.y + 0.625D < riderPos.y);
      boolean stationary = (this.throttle == 0.0F);
      test.ConvertESpaceToR3(finalPos);
      boolean onTop = (test.collisionPlaneNormal.y >= 0.5F);
      if (this.field_70163_u + finalPos.y + 0.625D < riderPos.y)
        finalPos.y = riderPos.y - (float)this.field_70163_u - 0.625F; 
      if (!this.hugeBoat)
        rider.func_70107_b(!onTop ? (riderPos.x + finalPos.x / 48.0F * Math.abs(relativePos.x)) : riderPos.x, onTop ? (this.field_70163_u + finalPos.y + 0.625D) : riderPos.y, !onTop ? (riderPos.z + finalPos.z / 48.0F * Math.abs(relativePos.z)) : riderPos.z); 
      if (this.hugeBoat && !stationary) {
        rider.func_70107_b(riderPos.x, this.field_70163_u + finalPos.y + 0.59375D, riderPos.z);
      } else if (this.hugeBoat && stationary) {
        rider.func_70107_b(riderPos.x, this.field_70163_u + finalPos.y + 0.625D, riderPos.z);
      } 
      finalPos = Vector3f.sub(finalPos, riderPos, null);
      finalPos.normalise();
      rider.field_70181_x = 0.0D;
      updateRiderPos(rider, test, finalPos, riderMotion);
      for (EntitySeat seat : this.seats) {
        if ((getDriveableType()).collisionDamageEnable && !test.isOnTop)
          if (this.throttle > (getDriveableType()).collisionDamageThrottle || (type.mechStomp && this.throttle > (getDriveableType()).collisionDamageThrottle)) {
            boolean canDamage = true;
            if (seat != null)
              if (TeamsManager.getInstance() != null && (TeamsManager.getInstance()).currentRound != null && rider instanceof EntityPlayerMP && (this.seats[0]).field_70153_n instanceof EntityPlayer) {
                EntityPlayerMP attacker = (EntityPlayerMP)(this.seats[0]).field_70153_n;
                EntityPlayerMP player = (EntityPlayerMP)rider;
                if (Gametype.getPlayerData(attacker) != null)
                  if ((Gametype.getPlayerData(attacker)).team != null)
                    if (Gametype.getPlayerData(player) != null)
                      if ((Gametype.getPlayerData(player)).team != null)
                        if ((Gametype.getPlayerData(player)).team == (Gametype.getPlayerData(attacker)).team)
                          canDamage = false;     
              }  
            if ((EntityLivingBase)(this.seats[0]).field_70153_n != null)
              if ((canDamage && rider != (EntityLivingBase)(this.seats[0]).field_70153_n) || (this.ticksFlareUsing > 0 && rider != (EntityLivingBase)(this.seats[0]).field_70153_n))
                if (rider instanceof EntityLiving) {
                  ((EntityLivingBase)rider).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5));
                  if (type.panic)
                    ((EntityLivingBase)rider).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
                } else if (rider instanceof EntityPlayer) {
                  ((EntityLivingBase)rider).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5));
                  if (type.panic)
                    ((EntityLivingBase)rider).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
                }   
          }  
      } 
      if (rider instanceof EntityPlayer) {
        EntityPlayer player = (EntityPlayer)rider;
        player.field_70122_E = true;
        player.field_70160_al = false;
        player.field_70143_R = 0.0F;
      } 
    } else if (rider instanceof EntityDriveable) {
      ((EntityDriveable)rider).deckHeight = 0.0D;
    } 
  }
  
  public DamageSource getBulletDamage(boolean headshot) {
    DriveableType type = getDriveableType();
    EntityLivingBase owner = (EntityLivingBase)(this.seats[0]).field_70153_n;
    if (owner instanceof EntityPlayer)
      return (new EntityDamageSourceFlans((getDriveableType()).shortName, this, (EntityPlayer)owner, (InfoType)type, headshot, false)).func_76349_b(); 
    return (new EntityDamageSourceIndirect(type.shortName, this, (Entity)owner)).func_76349_b();
  }
  
  public void checkCollision(CollisionTest tester, CollisionShapeBox box) {
    double distance = tester.nearestDistance;
    Vector3f collisionPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    int surface = 0;
    Vector3f pos = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    RotatedAxes shift = this.axes;
    float f4 = box.pos.x + box.size.x;
    float f5 = -box.pos.y + box.size.y;
    float f6 = box.pos.z + box.size.z;
    box.pos = new Vector3f(box.pos.x, box.pos.y, box.pos.z);
    Vector3f p1 = new Vector3f(box.pos.x - box.p1.x, box.pos.y + box.size.y + box.p1.y - box.size.y + 0.625F, box.pos.z - box.p1.z);
    Vector3f p2 = new Vector3f(box.pos.x + box.size.x + box.p2.x, box.pos.y + box.size.y + box.p2.y - box.size.y + 0.625F, box.pos.z - box.p2.z);
    Vector3f p3 = new Vector3f(box.pos.x + box.size.x + box.p3.x, box.pos.y + box.size.y + box.p3.y - box.size.y + 0.625F, box.pos.z + box.size.z + box.p3.z);
    Vector3f p4 = new Vector3f(box.pos.x - box.p4.x, box.pos.y + box.size.y + box.p4.y - box.size.y + 0.625F, box.pos.z + box.size.z + box.p4.z);
    Vector3f p5 = new Vector3f(box.pos.x - box.p5.x, box.pos.y - box.p5.y - box.size.y + 0.625F, box.pos.z - box.p5.z);
    Vector3f p6 = new Vector3f(box.pos.x + box.size.x + box.p6.x, box.pos.y - box.p6.y - box.size.y + 0.625F, box.pos.z - box.p6.z);
    Vector3f p7 = new Vector3f(box.pos.x + box.size.x + box.p7.x, box.pos.y - box.p7.y - box.size.y + 0.625F, box.pos.z + box.size.z + box.p7.z);
    Vector3f p8 = new Vector3f(box.pos.x - box.p8.x, box.pos.y - box.p8.y - box.size.y + 0.625F, box.pos.z + box.size.z + box.p8.z);
    if (EnumDriveablePart.getPart(box.part) == EnumDriveablePart.turret && this.seats[0] != null) {
      p1 = getPositionOnTurret(p1, false);
      p2 = getPositionOnTurret(p2, false);
      p3 = getPositionOnTurret(p3, false);
      p4 = getPositionOnTurret(p4, false);
      p5 = getPositionOnTurret(p5, false);
      p6 = getPositionOnTurret(p6, false);
      p7 = getPositionOnTurret(p7, false);
      p8 = getPositionOnTurret(p8, false);
    } else {
      p1 = shift.findLocalVectorGlobally(p1);
      p2 = shift.findLocalVectorGlobally(p2);
      p3 = shift.findLocalVectorGlobally(p3);
      p4 = shift.findLocalVectorGlobally(p4);
      p5 = shift.findLocalVectorGlobally(p5);
      p6 = shift.findLocalVectorGlobally(p6);
      p7 = shift.findLocalVectorGlobally(p7);
      p8 = shift.findLocalVectorGlobally(p8);
    } 
    double topFaceDist = 100.0D;
    tester.checkTriangle(tester, p3, p2, p1);
    if (tester.didCollide && tester.nearestDistance < distance) {
      collisionPoint = tester.intersectionPoint;
      surface = 1;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    tester.checkTriangle(tester, p4, p3, p1);
    if (tester.didCollide && tester.nearestDistance < distance) {
      collisionPoint = tester.intersectionPoint;
      surface = 1;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    if (tester.didCollide) {
      tester.isOnTop = true;
      topFaceDist = tester.nearestDistance;
    } 
    tester.checkTriangle(tester, p6, p7, p3);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 2;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    tester.checkTriangle(tester, p3, p2, p6);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 2;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    tester.checkTriangle(tester, p4, p1, p5);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 3;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    tester.checkTriangle(tester, p5, p8, p4);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 3;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    tester.checkTriangle(tester, p6, p5, p1);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 4;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    tester.checkTriangle(tester, p1, p2, p6);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 4;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    tester.checkTriangle(tester, p8, p7, p3);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 5;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    tester.checkTriangle(tester, p3, p4, p8);
    if (tester.didCollide && tester.nearestDistance < distance) {
      distance = tester.nearestDistance;
      collisionPoint = tester.intersectionPoint;
      surface = 5;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    tester.checkTriangle(tester, p5, p6, p7);
    if (tester.didCollide && tester.nearestDistance < distance) {
      collisionPoint = tester.intersectionPoint;
      surface = 1;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    tester.checkTriangle(tester, p8, p7, p5);
    if (tester.didCollide && tester.nearestDistance < distance) {
      collisionPoint = tester.intersectionPoint;
      surface = 1;
      tester.part = EnumDriveablePart.getPart(box.part);
    } 
    if (tester.didCollide) {
      tester.isOnTop = true;
      topFaceDist = tester.nearestDistance;
    } 
    Vector3f.add(p1, pos, p1);
    Vector3f.add(p2, pos, p2);
    Vector3f.add(p3, pos, p3);
    Vector3f.add(p4, pos, p4);
    Vector3f.add(p5, pos, p5);
    Vector3f.add(p6, pos, p6);
    Vector3f.add(p7, pos, p7);
    Vector3f.add(p8, pos, p8);
    boolean muff = true;
    String wank = "crit";
    if (tester.nearestDistance < topFaceDist)
      tester.isOnTop = false; 
    if (surface == 1)
      tester.isOnTop = true; 
  }
  
  public void renderTri(Vector3f p1, Vector3f p2, Vector3f p3) {
    Vector3f pos = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    Vector3f p1a = Vector3f.add(p1, pos, null);
    Vector3f p2a = Vector3f.add(p2, pos, null);
    Vector3f p3a = Vector3f.add(p3, pos, null);
    renderLine(p1a, p2a);
    renderLine(p2a, p3a);
    renderLine(p3a, p1a);
  }
  
  public void renderLine(Vector3f in, Vector3f out) {
    float dx = out.x - in.x;
    float dy = out.y - in.y;
    float dz = out.z - in.z;
    Vector3f diff = Vector3f.sub(out, in, null);
    diff.normalise();
    float distance = (float)Math.sqrt((dx * dx + dy * dy + dz * dz));
    for (int i = 0; i < 10; i++) {
      float dist2 = distance / 10.0F * i;
      Vector3f newVec = new Vector3f(in.x + dist2 * diff.x, in.y + dist2 * diff.y, in.z + dist2 * diff.z);
      FlansMod.proxy.spawnParticle("reddust", newVec.x, newVec.y, newVec.z, 0.0D, 0.0D, 0.0D);
    } 
  }
  
  public Vector3f collideWithDriveable(CollisionTest tester, Vector3f Pos, Vector3f vel) {
    float unitScale = 0.0625F;
    float veryCloseDistance = 0.005F * unitScale;
    if (tester.collisionRecursiveDepth > 2)
      return Pos; 
    tester.basePoint = Pos;
    tester.didCollide = false;
    if ((getDriveableType()).fancyCollision) {
      for (CollisionShapeBox sbox : (getDriveableType()).collisionBox)
        checkCollision(tester, sbox); 
    } else {
      for (DriveablePart ppart : (getDriveableData()).parts.values())
        ppart.rayTraceRider(this, tester); 
    } 
    if (tester.didCollide = false)
      return Vector3f.add(Pos, vel, null); 
    Vector3f destinationPoint = Vector3f.add(Pos, vel, null);
    Vector3f newBasePoint = Pos;
    if (tester.nearestDistance >= veryCloseDistance) {
      Vector3f V = vel;
      V.normalise();
      V.scale((float)(tester.nearestDistance - veryCloseDistance));
      newBasePoint = Vector3f.add(tester.basePoint, V, null);
      if (V.normalise() == new Vector3f(0.0F, 0.0F, 0.0F))
        return Vector3f.add(Pos, vel, null); 
      V.normalise();
      Vector3f.sub(tester.intersectionPoint, new Vector3f(V.x * veryCloseDistance, V.y * veryCloseDistance, V.z * veryCloseDistance), tester.intersectionPoint);
    } 
    Vector3f slidePlaneOrigin = tester.intersectionPoint;
    if (tester.intersectionPoint == null)
      return Vector3f.add(Pos, vel, null); 
    Vector3f slidePlaneNormal = Vector3f.sub(newBasePoint, tester.intersectionPoint, null);
    slidePlaneNormal.normalise();
    tester.collisionPlaneNormal = slidePlaneNormal;
    CollisionPlane plane = new CollisionPlane(slidePlaneOrigin, slidePlaneNormal);
    double sDV = plane.signedDistanceTo(destinationPoint);
    Vector3f scaledNormal = new Vector3f(slidePlaneNormal.x * sDV, slidePlaneNormal.y * sDV, slidePlaneNormal.z * sDV);
    Vector3f newDestPoint = Vector3f.sub(destinationPoint, scaledNormal, null);
    Vector3f newVelocityVector = Vector3f.sub(newDestPoint, tester.intersectionPoint, null);
    if (newVelocityVector.length() < veryCloseDistance)
      return newBasePoint; 
    tester.collisionRecursiveDepth++;
    return collideWithDriveable(tester, newBasePoint, newVelocityVector);
  }
  
  public void updateRiderPos(Entity rider, CollisionTest test, Vector3f pos, Vector3f motion) {
    boolean isDriveable = false;
    if (rider instanceof EntityDriveable)
      isDriveable = true; 
    Vector3f vehicleMotion = this.lastPos;
    Vector3f riderMountPoint = new Vector3f(rider.field_70165_t - this.field_70165_t, rider.field_70163_u - this.field_70163_u, rider.field_70161_v - this.field_70161_v);
    float yawDiff = this.axes.getYaw() - this.prevAxes.getYaw();
    float pitchDiff = this.axes.getPitch() - this.prevAxes.getPitch();
    float rollDiff = this.axes.getRoll() - this.prevAxes.getRoll();
    RotatedAxes velAxes = new RotatedAxes(this.axes.getYaw() + yawDiff, this.axes.getPitch() + pitchDiff, this.axes.getRoll() + rollDiff);
    Vector3f currentLocalPos = this.axes.findGlobalVectorLocally(riderMountPoint);
    Vector3f nextGlobalPos = velAxes.findLocalVectorGlobally(currentLocalPos);
    Vector3f diff = new Vector3f(0.0F, 0.0F, 0.0F);
    if (nextGlobalPos == null)
      nextGlobalPos = new Vector3f(0.0F, 0.0F, 0.0F); 
    if (diff == null) {
      diff = new Vector3f(0.0F, 0.0F, 0.0F);
      if (FlansMod.debugMode)
        FlansMod.log("EntityDriveable.java updateRidarPos> diff is null [1]"); 
    } 
    Vector3f.add(vehicleMotion, diff, diff);
    rider.func_70107_b(nextGlobalPos.x + this.field_70165_t + (this.hugeBoat ? (diff.x / 1.5D) : 0.0D), !isDriveable ? rider.field_70163_u : ((EntityDriveable)rider).deckHeight, nextGlobalPos.z + this.field_70161_v + (this.hugeBoat ? (diff.z / 1.5D) : 0.0D));
    if (this.hugeBoat) {
      if (this.lastPos.x == 0.0F && this.lastPos.y == 0.0F && this.lastPos.z == 0.0F) {
        rider.field_70159_w = rider.field_70159_w;
        rider.field_70181_x = rider.field_70181_x;
        rider.field_70179_y = rider.field_70179_y;
        if (rider.field_70181_x < 0.0D)
          rider.field_70181_x = 0.0D; 
      } 
    } else if (this.lastPos.x == 0.0F && this.lastPos.y == 0.0F && this.lastPos.z == 0.0F) {
      rider.field_70159_w = rider.field_70159_w;
      rider.field_70181_x = rider.field_70181_x;
      rider.field_70179_y = rider.field_70179_y;
    } else {
      rider.field_70159_w = diff.x;
      rider.field_70181_x = diff.y;
      rider.field_70179_y = diff.z;
    } 
  }
  
  public void handleVehicleCollision(EntityDriveable collided, CollisionTest test, Vector3f finalPos, boolean hugeBoat) {}
  
  public ArrayList<BulletHit> attackFromBulletClassic(Vector3f origin, Vector3f motion) {
    ArrayList<BulletHit> hits = new ArrayList<>();
    Vector3f relativePosVector = Vector3f.sub(origin, new Vector3f((float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v), null);
    Vector3f rotatedPosVector = this.axes.findGlobalVectorLocally(relativePosVector);
    Vector3f rotatedMotVector = this.axes.findGlobalVectorLocally(motion);
    for (DriveablePart part : (getDriveableData()).parts.values()) {
      DriveableHit hit = part.rayTrace(this, rotatedPosVector, rotatedMotVector);
      if (hit != null)
        hits.add(hit); 
    } 
    return hits;
  }
  
  public ArrayList<BulletHit> attackFromBullet(Vector3f origin, Vector3f motion) {
    ArrayList<BulletHit> hits = new ArrayList<>();
    Vector3f vehicleMotion = new Vector3f(this.field_70165_t - this.lastPos.x, this.field_70163_u - this.lastPos.y, this.field_70161_v - this.lastPos.z);
    Vector3f vehiclePos = new Vector3f(this.field_70165_t, this.field_70163_u, this.field_70161_v);
    Vector3f relativePos = Vector3f.sub(origin, vehiclePos, null);
    Vector3f rotatedPosVector = this.axes.findGlobalVectorLocally(relativePos);
    Vector3f rotatedMotionVector = this.axes.findGlobalVectorLocally(motion);
    Vector3f ellipsoid = new Vector3f(50.0F, 50.0F, 50.0F);
    CollisionTest testudo = new CollisionTest(ellipsoid, new Vector3f(relativePos.x, relativePos.y, relativePos.z), motion);
    testudo.collisionRecursiveDepth = 0;
    Vector3f eSpacePosition = testudo.ConvertR3ToESpace(testudo.R3Position);
    Vector3f eSpaceVelocity = testudo.velocity;
    for (DriveablePart ppart : (getDriveableData()).parts.values())
      ppart.rayTraceRider(this, testudo); 
    if (testudo.didCollide) {
      Vector3f hitPos = new Vector3f(0.0F, 0.0F, 0.0F);
      Vector3f intersect2 = new Vector3f((ReadableVector3f)testudo.ConvertESpaceToR3(testudo.intersectionPoint));
      Vector3f.sub(origin, intersect2, hitPos);
      float f = hitPos.length() / motion.length();
      DriveableHit hit = new DriveableHit(this, testudo.part, f);
      hits.add(hit);
    } 
    return hits;
  }
  
  public float bulletHit(EntityBullet bullet, DriveableHit hit, float penetratingPower) {
    DriveablePart part = (getDriveableData()).parts.get(hit.part);
    if (bullet != null && hit != null)
      part.hitByBullet(bullet, hit); 
    if (!this.field_70170_p.field_72995_K) {
      checkParts();
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketDriveableDamage(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, 100.0F, this.field_71093_bK);
    } 
    EntitySeat parkingSeat = null;
    EntitySeat shooterSeat = null;
    if (bullet.owner != null && bullet.owner.func_70115_ae() && bullet.owner.field_70154_o != null && bullet.owner.field_70154_o instanceof EntitySeat)
      shooterSeat = (EntitySeat)bullet.owner.field_70154_o; 
    if (func_70115_ae() && this.field_70154_o != null && this.field_70154_o instanceof EntitySeat)
      parkingSeat = (EntitySeat)this.field_70154_o; 
    if (shooterSeat != null && parkingSeat != null && shooterSeat.driveable != null && parkingSeat.driveable != null && (parkingSeat.driveable == shooterSeat.driveable || this == shooterSeat.driveable))
      return penetratingPower - 0.0F; 
    if (part.type == EnumDriveablePart.rightsideArmor || part.type == EnumDriveablePart.frontalArmor || part.type == EnumDriveablePart.leftsideArmor || part.type == EnumDriveablePart.additionalArmor || part.type == EnumDriveablePart.composite || part.type == EnumDriveablePart.composite2 || part.type == EnumDriveablePart.compositeL || part.type == EnumDriveablePart.compositeR || part.type == EnumDriveablePart.beltl || part.type == EnumDriveablePart.beltr || part.type == EnumDriveablePart.turretarmor || part.type == EnumDriveablePart.moreturretarmor || part.type == EnumDriveablePart.turretside) {
      if (bullet.truePen > part.armor) {
        if ((hit.driveable.getDriveableType()).lessOverpen)
          bullet.truePen -= part.armor * 0.9F; 
        return penetratingPower - 0.0F;
      } 
      return penetratingPower - 5.0F;
    } 
    if (part.type == EnumDriveablePart.ERA || part.type == EnumDriveablePart.ERA2 || part.type == EnumDriveablePart.ERA3 || part.type == EnumDriveablePart.spaced || part.type == EnumDriveablePart.superstructure || part.type == EnumDriveablePart.leftTrack || part.type == EnumDriveablePart.rightTrack) {
      if (bullet.truePen > part.armor && !bullet.type.HEAT && !bullet.type.Hesh) {
        bullet.truePen -= part.armor;
        return penetratingPower - 0.0F;
      } 
      return penetratingPower - 5.0F;
    } 
    return penetratingPower - 5.0F;
  }
  
  public DriveablePart raytraceParts(Vector3f origin, Vector3f motion) {
    Vector3f relativePosVector = Vector3f.sub(origin, new Vector3f((float)this.field_70165_t, (float)this.field_70163_u, (float)this.field_70161_v), null);
    Vector3f rotatedPosVector = this.axes.findGlobalVectorLocally(relativePosVector);
    Vector3f rotatedMotVector = this.axes.findGlobalVectorLocally(motion);
    for (DriveablePart part : (getDriveableData()).parts.values()) {
      if (part.rayTrace(this, rotatedPosVector, rotatedMotVector) != null)
        return part; 
    } 
    return null;
  }
  
  public boolean canHitPart(EnumDriveablePart part) {
    return true;
  }
  
  public void checkParts() {
    for (DriveablePart part : (getDriveableData()).parts.values()) {
      DriveableData driveableData = getDriveableData();
      if (part != null && !part.dead && part.crew > 1)
        driveableData.totalCrew = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.infantry)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.steering)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.airframe)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.deck)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.superstructure)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret1)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret2)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret3)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret4)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret5)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret6)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret7)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret8)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret9)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.citadel)).crew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).crew; 
      if (part != null && !part.dead) {
        driveableData.notFlooding = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).health + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).health + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.steering)).health + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).health + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).health + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).health;
        driveableData.notFloodingMax = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).maxHealth + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).maxHealth + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.steering)).maxHealth + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).maxHealth + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).maxHealth + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).maxHealth;
      } 
      if (part != null && !part.dead && part.health <= 0 && part.maxHealth > 0) {
        killPart(part);
        part.crew = 0;
      } 
    } 
    DriveableData data = getDriveableData();
    data.maximumCrew = ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret1)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret2)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret3)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret4)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret5)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret6)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret7)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret8)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret9)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.infantry)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.steering)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.airframe)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.deck)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.superstructure)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.citadel)).maxCrew + ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).maxCrew;
    for (EntitySeat entitySeat : this.seats);
    DriveablePart buoyancy = (getDriveableData()).parts.get(EnumDriveablePart.buoyancy);
    if (data.notFloodingMax > 0 && data.notFlooding < data.notFloodingMax) {
      this.driveableData.sinkingTimer++;
      this.driveableData.sinkLimit = (int)(40.0F + 360.0F * data.notFlooding * data.notFlooding * data.notFlooding / data.notFloodingMax * data.notFloodingMax * data.notFloodingMax);
      if (this.driveableData.sinkingTimer >= this.driveableData.sinkLimit)
        this.driveableData.sinkingTimer = 0; 
      if (this.driveableData.sinkingTimer == 15 && buoyancy.health > 0) {
        buoyancy.health--;
        buoyancy.health--;
        buoyancy.health--;
        buoyancy.health--;
        buoyancy.health--;
      } 
    } 
    if (buoyancy.health < buoyancy.maxHealth) {
      this.driveableData.repairingTimer++;
      if (this.driveableData.repairingTimer >= this.driveableData.repairLimit)
        this.driveableData.repairingTimer = 0; 
      data.repairLimit = (int)(400.0F - 380.0F * (getDriveableData()).totalCrew / (getDriveableData()).maximumCrew);
      if (this.driveableData.repairingTimer == 10)
        buoyancy.health++; 
    } 
    DriveableType type = getDriveableType();
    if (data.depth / -type.maxDepth > 1.0F)
      this.crushed = true; 
    int seatNum = this.seats.length;
    if (!this.field_70170_p.field_72995_K)
      for (int i = 0; i < this.seats.length; i++) {
        if ((this.seats[i]).field_70153_n != null && (this.seats[i]).field_70153_n instanceof EntityPlayer) {
          Entity entity = (this.seats[i]).field_70153_n;
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.turret) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret1)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret1)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.turret1) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret2)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret2)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.turret2) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret3)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret3)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.turret3) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret4)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret4)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.turret4) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret5)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret5)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.turret5) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret6)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret6)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.turret6) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret7)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret7)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.turret7) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret8)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret8)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.turret8) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret9)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.turret9)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.turret9) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.airframe)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.airframe)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.airframe) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.superstructure)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.superstructure)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.superstructure) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.deck)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.deck)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.deck) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.citadel)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.citadel)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.citadel) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bow)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.bow) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.midsection)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.midsection) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.stern)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.stern) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.tail)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.tail)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.tail) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bay)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.bay)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.bay) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.left)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.left) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
          if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).health <= 0.0F && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.right)).maxHealth > 0.0F && 
            (this.seats[i]).seatInfo.part == EnumDriveablePart.right) {
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer)
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 10, 5)); 
          } 
        } 
      }  
    if (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).dead && !type.inshallah) {
      for (EntitySeat seat : this.seats) {
        if (seat != null && 
          (this.seats[0]).field_70153_n != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && 
          ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).health == 0 && ((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).maxHealth > 0) {
          ((EntityPlayer)(this.seats[0]).field_70153_n).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 100, 50));
          if (this.lastAtkEntity != null && this.lastAtkEntity instanceof EntityPlayer && this.seats[0] != null && (this.seats[0]).field_70153_n != null)
            (this.seats[0]).field_70153_n.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.lastAtkEntity), 1.0E7F); 
        } 
      } 
      if (!this.field_70170_p.field_72995_K) {
        for (int i = 0; i < seatNum; i++) {
          if ((this.seats[i]).field_70153_n != null && (this.seats[i]).field_70153_n instanceof EntityPlayer) {
            Entity entity = (this.seats[i]).field_70153_n;
            (this.seats[i]).field_70153_n.func_70078_a(null);
            if (this.lastAtkEntity instanceof EntityPlayer) {
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 100, 50));
              entity.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.lastAtkEntity), 1.0E7F);
            } else if (this.lastAtkEntity instanceof EntityLivingBase) {
              ((EntityLivingBase)entity).func_70690_d(new PotionEffect(Potion.field_76433_i.field_76415_H, 100, 50));
              entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this.lastAtkEntity), 1.0E7F);
            } 
          } 
        } 
        if (type.isExplosionWhenDestroyed && type.isExplosionWhenDestroyedRadius == 0.0F) {
          this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 4.0F, false);
        } else if (type.isExplosionWhenDestroyedRadius > 0.0F) {
          this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, type.isExplosionWhenDestroyedRadius, false);
        } 
        if (type.nuclearDeath == true) {
          FlansMod.proxy.spawnParticle("flansmod.FMNuke", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
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
        for (DriveablePart part : this.driveableData.parts.values()) {
          if (part.health > 0 && !part.dead)
            killPart(part); 
        } 
      } 
      data.depth = -9000.0F;
      func_70106_y();
    } 
    for (EntitySeat seat : this.seats) {
      if ((((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).dead && seat != null && type.inshallah == true) || (((DriveablePart)(getDriveableData()).parts.get(EnumDriveablePart.core)).dead && seat != null && type.canDive == true) || (this.suicide == true && seat != null && type.inshallah == true)) {
        if (seat != null)
          if ((seat != null && (this.seats[0]).field_70153_n != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && type.inshallah == true) || seat == null || (this.seats[0]).field_70153_n == null || !((this.seats[0]).field_70153_n instanceof EntityPlayer) || type.canDive == true); 
        if (!this.field_70170_p.field_72995_K) {
          for (int i = 0; i < seatNum; i++) {
            if ((this.seats[i]).field_70153_n != null && (this.seats[i]).field_70153_n instanceof EntityPlayer) {
              Entity entity = (this.seats[i]).field_70153_n;
              (this.seats[i]).field_70153_n.func_70078_a(null);
              if (this.lastAtkEntity instanceof EntityPlayer) {
                entity.func_70097_a(DamageSource.func_76365_a((EntityPlayer)this.lastAtkEntity), 1.0E7F);
              } else if (this.lastAtkEntity instanceof EntityLivingBase) {
                entity.func_70097_a(DamageSource.func_76358_a((EntityLivingBase)this.lastAtkEntity), 1.0E7F);
              } 
            } 
          } 
          if (type.isExplosionWhenDestroyed && type.isExplosionWhenDestroyedRadius == 0.0F) {
            this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, 4.0F, false);
          } else if (type.isExplosionWhenDestroyedRadius > 0.0F) {
            this.field_70170_p.func_72876_a(this, this.field_70165_t, this.field_70163_u, this.field_70161_v, type.isExplosionWhenDestroyedRadius, false);
          } 
          if (type.nuclearDeath == true) {
            FlansMod.proxy.spawnParticle("flansmod.FMNuke", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "YamatoGun", false);
          } 
          if (type.bigDeath == true) {
            FlansMod.proxy.spawnParticle("flansmod.shipDeath", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "BattleshipGun", false);
          } 
          if (type.Death == true) {
            FlansMod.proxy.spawnParticle("flansmod.tankDeath", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 250.0D, this.field_71093_bK, "explcls6", false);
          } 
          for (DriveablePart part : this.driveableData.parts.values()) {
            if (part.health > 0 && !part.dead)
              killPart(part); 
          } 
        } 
        data.depth = -9000.0F;
        if (seat != null)
          func_70106_y(); 
      } 
    } 
  }
  
  public void checkPartsWhenAttacked() {
    for (DriveablePart part : (getDriveableData()).parts.values()) {
      if (part != null && !part.dead && part.health <= 0 && part.maxHealth > 0)
        killPart(part); 
    } 
  }
  
  private void killPart(DriveablePart part) {
    if (part.dead)
      return; 
    part.health = 0;
    part.crew = 0;
    part.dead = true;
    FlansMod.proxy.spawnParticle("largeexplode", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D);
    DriveableType type = getDriveableType();
    if (!this.field_70170_p.field_72995_K) {
      Vector3f pos = new Vector3f(0.0F, 0.0F, 0.0F);
      if (part.box != null)
        pos = this.axes.findLocalVectorGlobally(new Vector3f(part.box.x / 16.0F + part.box.w / 32.0F, part.box.y / 16.0F + part.box.h / 32.0F, part.box.z / 16.0F + part.box.d / 32.0F)); 
      ArrayList<ItemStack> drops = type.getItemsRequired(part, (getDriveableData()).engine);
      if (drops != null)
        for (ItemStack itemStack : drops); 
      dropItemsOnPartDeath(pos, part);
      if (part.type == EnumDriveablePart.core)
        for (int i = 0; i < getDriveableData().func_70302_i_(); i++) {
          ItemStack stack = getDriveableData().func_70301_a(i);
          if (stack != null)
            this.field_70170_p.func_72838_d((Entity)new EntityItem(this.field_70170_p, this.field_70165_t + this.field_70146_Z.nextGaussian(), this.field_70163_u + this.field_70146_Z.nextGaussian(), this.field_70161_v + this.field_70146_Z.nextGaussian(), stack)); 
        }  
    } 
    for (EnumDriveablePart child : part.type.getChildren())
      killPart((getDriveableData()).parts.get(child)); 
  }
  
  protected abstract void dropItemsOnPartDeath(Vector3f paramVector3f, DriveablePart paramDriveablePart);
  
  public float getPlayerRoll() {
    return this.axes.getRoll();
  }
  
  public void explode() {}
  
  public float getCameraDistance() {
    return (getDriveableType()).cameraDistance;
  }
  
  public boolean isPartIntact(EnumDriveablePart part) {
    DriveablePart thisPart = (getDriveableData()).parts.get(part);
    return (thisPart.maxHealth == 0 || thisPart.health > 0);
  }
  
  public boolean isPartHealthy(EnumDriveablePart part) {
    DriveablePart thisPart = (getDriveableData()).parts.get(part);
    return (thisPart.maxHealth == 0 || thisPart.health > 0.25F * thisPart.maxHealth);
  }
  
  public boolean hudMode() {
    EntityPlayer driver = (EntityPlayer)(this.seats[0]).field_70153_n;
    if ((Minecraft.func_71410_x()).field_71474_y.field_74320_O == 0 && driver != null)
      return true; 
    return false;
  }
  
  public float healthPercent(EnumDriveablePart part) {
    DriveablePart thisPart = (getDriveableData()).parts.get(part);
    if (thisPart.maxHealth == 0)
      return 1.0F; 
    return (thisPart.health / thisPart.maxHealth);
  }
  
  public abstract boolean hasMouseControlMode();
  
  public abstract String getBombInventoryName();
  
  public abstract String getMissileInventoryName();
  
  public boolean rotateWithTurret(Seat seat) {
    return (seat.part == EnumDriveablePart.turret);
  }
  
  public String func_70005_c_() {
    return (getDriveableType()).name;
  }
  
  @SideOnly(Side.CLIENT)
  public boolean showInventory(int seat) {
    return (seat != 0 || !FlansModClient.controlModeMouse);
  }
  
  public int getShootDelay(boolean secondary) {
    return secondary ? this.shootDelaySecondary : this.shootDelayPrimary;
  }
  
  public boolean canLaunchIT1() {
    return this.canFireIT1;
  }
  
  public float getMinigunSpeed(boolean secondary) {
    return secondary ? this.minigunSpeedSecondary : this.minigunSpeedPrimary;
  }
  
  public int getCurrentGun(boolean secondary) {
    return secondary ? this.currentGunSecondary : this.currentGunPrimary;
  }
  
  public void setShootDelay(int i, boolean secondary) {
    setRecoilTimer();
    if (secondary) {
      setRecoilHeightSecondary();
    } else {
      setRecoilHeightPrimary();
    } 
    if (secondary) {
      this.shootDelaySecondary = (i > this.shootDelaySecondary) ? i : this.shootDelaySecondary;
    } else {
      this.shootDelayPrimary = (i > this.shootDelayPrimary) ? i : this.shootDelayPrimary;
    } 
  }
  
  public void setMinigunSpeed(float f, boolean secondary) {
    if (secondary) {
      this.minigunSpeedSecondary = f;
    } else {
      this.minigunSpeedPrimary = f;
    } 
  }
  
  public void setCurrentGun(int i, boolean secondary) {
    if (secondary) {
      this.currentGunSecondary = i;
    } else {
      this.currentGunPrimary = i;
    } 
  }
  
  public void setEntityMarker(int tick) {
    this.isShowedPosition = true;
    this.tickCount = tick;
  }
  
  public void lock(String tool, EntityPlayer player) {
    if (this.key == "ChangeMe") {
      this.key = tool;
      player.func_145747_a((IChatComponent)new ChatComponentText("Registered key"));
    } else if (tool == this.key) {
      this.locked = true;
      player.func_145747_a((IChatComponent)new ChatComponentText("Locked"));
    } else {
      player.func_145747_a((IChatComponent)new ChatComponentText(this.key));
    } 
  }
  
  public void IT1Reload() {
    DriveableType type = getDriveableType();
    if (this.stage == 1) {
      this.drakonDoorAngle = moveToTarget(this.drakonDoorAngle, 0.0F, 5.0F);
      this.drakonArmAngle = moveToTarget(this.drakonArmAngle, 0.0F, 3.0F);
      this.drakonRailAngle = moveToTarget(this.drakonRailAngle, -10.0F, 5.0F);
      if (this.drakonRailAngle == -10.0F)
        this.stage++; 
    } 
    if (this.stage == 2) {
      this.drakonDoorAngle = moveToTarget(this.drakonDoorAngle, -90.0F, 5.0F);
      this.drakonArmAngle = moveToTarget(this.drakonArmAngle, 0.0F, 3.0F);
      this.drakonRailAngle = moveToTarget(this.drakonRailAngle, -10.0F, 1.0F);
      if (this.drakonDoorAngle == -90.0F)
        this.stage++; 
    } 
    if (this.stage == 3) {
      this.drakonDoorAngle = moveToTarget(this.drakonDoorAngle, -90.0F, 5.0F);
      this.drakonArmAngle = moveToTarget(this.drakonArmAngle, 179.0F, 3.0F);
      this.drakonRailAngle = moveToTarget(this.drakonRailAngle, -10.0F, 1.0F);
      if (this.drakonArmAngle == 179.0F)
        this.stage++; 
    } 
    if (this.stage == 4) {
      this.drakonDoorAngle = moveToTarget(this.drakonDoorAngle, 0.0F, 10.0F);
      this.drakonArmAngle = moveToTarget(this.drakonArmAngle, 180.0F, 3.0F);
      this.drakonRailAngle = moveToTarget(this.drakonRailAngle, -10.0F, 1.0F);
      if (this.drakonDoorAngle == 0.0F)
        if (IT1Loaded()) {
          this.stage++;
          this.reloadAnimTime = 60;
        }  
    } 
    if (this.stage == 5) {
      this.drakonDoorAngle = moveToTarget(this.drakonDoorAngle, -90.0F, 10.0F);
      this.drakonArmAngle = moveToTarget(this.drakonArmAngle, 180.0F, 3.0F);
      this.drakonRailAngle = moveToTarget(this.drakonRailAngle, -10.0F, 1.0F);
      this.reloadingDrakon = true;
      if (this.drakonDoorAngle == -90.0F)
        this.stage++; 
    } 
    if (this.stage == 6) {
      this.drakonDoorAngle = moveToTarget(this.drakonDoorAngle, -90.0F, 5.0F);
      this.drakonArmAngle = moveToTarget(this.drakonArmAngle, 0.0F, 3.0F);
      this.drakonRailAngle = moveToTarget(this.drakonRailAngle, -10.0F, 1.0F);
      if (this.drakonArmAngle == 0.0F)
        this.stage++; 
    } 
    if (this.stage == 7) {
      this.drakonDoorAngle = moveToTarget(this.drakonDoorAngle, 0.0F, 10.0F);
      this.drakonArmAngle = moveToTarget(this.drakonArmAngle, 0.0F, 3.0F);
      this.drakonRailAngle = moveToTarget(this.drakonRailAngle, 0.0F, 1.0F);
      if (this.drakonRailAngle == 0.0F && this.drakonDoorAngle == 0.0F) {
        this.stage++;
        this.canFireIT1 = true;
        this.reloadingDrakon = false;
      } 
    } 
    if (this.stage == 8) {
      this.drakonDoorAngle = moveToTarget(this.drakonDoorAngle, 0.0F, 10.0F);
      this.drakonArmAngle = moveToTarget(this.drakonArmAngle, 0.0F, 3.0F);
      if (this.field_70170_p.field_72995_K && this.field_70173_aa > 2)
        this.drakonRailAngle = moveToTarget(this.drakonRailAngle, -(this.seats[0]).looking.getPitch(), (this.seats[0]).seatInfo.aimingSpeed.y); 
      if (!IT1Loaded()) {
        this.stage = 1;
        this.canFireIT1 = false;
      } 
    } 
  }
  
  public float moveToTarget(float current, float target, float speed) {
    float pitchToMove = (float)(Math.sqrt((target * target)) - Math.sqrt((current * current)));
    for (; pitchToMove > 180.0F; pitchToMove -= 360.0F);
    for (; pitchToMove <= -180.0F; pitchToMove += 360.0F);
    float signDeltaY = 0.0F;
    if (pitchToMove > speed) {
      signDeltaY = 1.0F;
    } else if (pitchToMove < -speed) {
      signDeltaY = -1.0F;
    } else {
      signDeltaY = 0.0F;
      return target;
    } 
    if (current > target) {
      current -= speed;
    } else if (current < target) {
      current += speed;
    } 
    return current;
  }
  
  public boolean IT1Loaded() {
    DriveableType type = getDriveableType();
    boolean loaded = false;
    for (int i = this.driveableData.getMissileInventoryStart(); i < this.driveableData.getMissileInventoryStart() + type.numMissileSlots; i++) {
      ItemStack shell = this.driveableData.func_70301_a(i);
      if (shell != null && shell.func_77973_b() instanceof ItemBullet && type.isValidAmmo(((ItemBullet)shell.func_77973_b()).type, EnumWeaponType.MISSILE))
        loaded = true; 
    } 
    return loaded;
  }
  
  public void tryRecoil() {
    int slot = -1;
    DriveableType type = getDriveableType();
    for (int i = this.driveableData.getMissileInventoryStart(); i < this.driveableData.getMissileInventoryStart() + type.numMissileSlots; i++) {
      ItemStack shell = this.driveableData.func_70301_a(i);
      if (shell != null && shell.func_77973_b() instanceof ItemBullet && type.isValidAmmo(((ItemBullet)shell.func_77973_b()).type, EnumWeaponType.SHELL))
        slot = i; 
    } 
    if (this.recoilTimer <= 0 && slot != -1)
      this.isRecoil = true; 
  }
  
  public void setRecoilTimer() {
    int slot = -1;
    DriveableType type = getDriveableType();
    for (int i = this.driveableData.getMissileInventoryStart(); i < this.driveableData.getMissileInventoryStart() + type.numMissileSlots; i++) {
      ItemStack shell = this.driveableData.func_70301_a(i);
      if (shell != null && shell.func_77973_b() instanceof ItemBullet && type.isValidAmmo(((ItemBullet)shell.func_77973_b()).type, EnumWeaponType.SHELL))
        slot = i; 
    } 
    if (this.recoilTimer <= 0 && slot != -1) {
      this.recoilTimer = (getDriveableType()).shootDelayPrimary;
      this.planeRecoil += type.projectileMass * type.muzzleVelocity;
    } 
  }
  
  public void setRecoilHeightPrimary() {
    this.primaryRecoilHeight = (getDriveableType()).primaryRecoilHeight;
  }
  
  public void setRecoilHeightSecondary() {
    this.secondaryRecoilHeight = (getDriveableType()).secondaryRecoilHeight;
  }
  
  public void unlock(String tool, EntityPlayer player) {
    if (this.key == "ChangeMe") {
      this.key = tool;
      player.func_145747_a((IChatComponent)new ChatComponentText("Registered key"));
    } else if (tool == this.key) {
      this.locked = false;
      player.func_145747_a((IChatComponent)new ChatComponentText("Unlocked"));
    } else {
      player.func_145747_a((IChatComponent)new ChatComponentText(this.key));
    } 
  }
}
