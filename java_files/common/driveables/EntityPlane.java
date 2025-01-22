package com.flansmod.common.driveables;

import com.flansmod.client.model.animation.AnimationController;
import com.flansmod.common.FlansMod;
import com.flansmod.common.PlayerHandler;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketCurrentMissile;
import com.flansmod.common.network.PacketDriveableControl;
import com.flansmod.common.network.PacketDriveableKey;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.network.PacketPlaneAnimator;
import com.flansmod.common.network.PacketPlaneControl;
import com.flansmod.common.network.PacketPlaySound;
import com.flansmod.common.teams.TeamsManager;
import com.flansmod.common.tools.ItemTool;
import com.flansmod.common.vector.Matrix4f;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.FMLCommonHandler;
import java.util.List;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.DamageSource;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class EntityPlane extends EntityDriveable {
  public float flapsYaw;
  
  public float flapsPitchLeft;
  
  public float flapsPitchRight;
  
  public int soundPosition;
  
  public int bombDelay;
  
  public int gunDelay;
  
  public int ticksSinceUsed = 0;
  
  public boolean varGear = true, varDoor = false, varWing = false, varFlap = false;
  
  public boolean doorsHaveShut = false;
  
  public int toggleTimer = 0;
  
  public int carrierTimer = 0;
  
  public EnumPlaneMode mode;
  
  public boolean combatRadar = false;
  
  public int exitTimer = 5;
  
  public Vector3f wingPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f coreWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f coreWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f tailWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f tailWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f doorPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f doorRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevWingPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevWingRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevWingWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevWingWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevCoreWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevCoreWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevTailWheelPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevTailWheelRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevDoorPos = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f prevDoorRot = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public float xSpeed = 0.0F;
  
  public float ySpeed = 0.0F;
  
  public float zSpeed = 0.0F;
  
  public float rollSpeed = 0.0F;
  
  public FlightController control = new FlightController();
  
  public AnimationController anim = new AnimationController();
  
  public boolean initiatedAnim = false;
  
  public boolean radarVisible;
  
  public boolean hasPlaneRadar;
  
  public float radarRange;
  
  public int radarPositionOffset;
  
  public int radarRefreshDelay;
  
  public boolean digitalRadar = false;
  
  public boolean isHeli = false;
  
  public int slbmFlightType;
  
  public int slbmDelay;
  
  public int slbmRange;
  
  public int slbmStrength;
  
  public int slbmWarheadType;
  
  private float radarDetectionRangeMultiplier = 1.0F;
  
  private int poopooTimer;
  
  private int testerino = 0;
  
  public EntityPlane(World world) {
    super(world);
  }
  
  public EntityPlane(World world, double x, double y, double z, PlaneType type, DriveableData data) {
    super(world, type, data);
    func_70107_b(x, y, z);
    this.field_70169_q = x;
    this.field_70167_r = y;
    this.field_70166_s = z;
    initType(type, false);
  }
  
  public EntityPlane(World world, double x, double y, double z, float yaw, float pitch, float roll, PlaneType type, DriveableData data) {
    super(world, type, data);
    rotateYaw(yaw + 90.0F);
    rotatePitch(pitch);
    rotateRoll(roll);
    func_70107_b(x, y, z);
    this.field_70169_q = x;
    this.field_70167_r = y;
    this.field_70166_s = z;
    initType(type, false);
  }
  
  public EntityPlane(World world, double x, double y, double z, EntityPlayer placer, PlaneType type, DriveableData data) {
    this(world, x, y + 5.625D, z, type, data);
    rotateYaw(placer.field_70177_z + 90.0F);
    rotatePitch(type.restingPitch);
  }
  
  public void initType(DriveableType type, boolean clientSide) {
    this.fuelTimer = type.fuelTimer;
    this.labjacFuel = type.labjacFuel;
    this.radarVisible = type.radarVisible;
    this.hasPlaneRadar = type.hasPlaneRadar;
    this.digitalRadar = type.digitalRadar;
    this.radarDetectionRangeMultiplier = type.radarDetectionRangeMultiplier;
    this.radarRange = type.radarRange;
    this.radarPositionOffset = type.radarPositionOffset;
    this.radarRefreshDelay = type.radarRefreshDelay;
    this.slbmFlightType = type.slbmFlightType;
    this.slbmDelay = type.slbmDelay;
    this.slbmRange = type.slbmRange;
    this.slbmStrength = type.slbmStrength;
    this.slbmWarheadType = type.slbmWarheadType;
    super.initType(type, clientSide);
    this.mode = (((PlaneType)type).mode == EnumPlaneMode.HELI) ? EnumPlaneMode.HELI : EnumPlaneMode.PLANE;
    if (((PlaneType)type).mode == EnumPlaneMode.VTOL) {
      this.mode = EnumPlaneMode.HELI;
      this.isHeli = true;
    } else {
      this.isHeli = false;
    } 
  }
  
  protected void func_70014_b(NBTTagCompound tag) {
    super.func_70014_b(tag);
    tag.func_74782_a("Pos", (NBTBase)func_70087_a(new double[] { this.field_70165_t, this.field_70163_u + 1.0D, this.field_70161_v }));
    tag.func_74757_a("VarGear", this.varGear);
    tag.func_74757_a("VarDoor", this.varDoor);
    tag.func_74757_a("VarWing", this.varWing);
  }
  
  protected void func_70037_a(NBTTagCompound tag) {
    super.func_70037_a(tag);
    this.varGear = tag.func_74767_n("VarGear");
    this.varDoor = tag.func_74767_n("VarDoor");
    this.varWing = tag.func_74767_n("VarWing");
  }
  
  public boolean func_70112_a(double d) {
    double d1 = 900.0D;
    return (d < d1 * d1);
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
  
  public void onMouseMoved(int deltaX, int deltaY) {
    if (!FMLCommonHandler.instance().getSide().isClient())
      return; 
    if (!FlansMod.proxy.mouseControlEnabled())
      return; 
    float sensitivity = 0.01F;
    this.flapsPitchLeft -= sensitivity * deltaY;
    this.flapsPitchRight -= sensitivity * deltaY;
    if (this.mode != EnumPlaneMode.SIXDOF) {
      this.flapsPitchLeft -= sensitivity * deltaX;
      this.flapsPitchRight += sensitivity * deltaX;
    } else {
      this.flapsPitchLeft -= sensitivity * deltaX;
      this.flapsPitchRight += sensitivity * deltaX;
    } 
  }
  
  public void setPositionRotationAndMotion(double x, double y, double z, float yaw, float pitch, float roll, double motX, double motY, double motZ, float velYaw, float velPitch, float velRoll, float throt, float steeringYaw, float throtPP) {
    super.setPositionRotationAndMotion(x, y, z, yaw, pitch, roll, motX, motY, motZ, velYaw, velPitch, velRoll, throt, steeringYaw, throtPP);
    this.flapsYaw = steeringYaw;
  }
  
  public void setRotorPosition(float current, float previous) {
    this.rotorAngle = current;
    this.prevRotorAngle = previous;
  }
  
  public void rebirth() {
    PlaneType typo = getPlaneType();
    ItemStack vehicleStack = new ItemStack(typo.item, 1, this.driveableData.paintjobID);
    for (EntitySeat seat : this.seats) {
      if (seat != null && 
        seat.field_70153_n != null && seat.field_70153_n instanceof net.minecraft.entity.player.EntityPlayerMP)
        seat.func_70078_a(null); 
    } 
    vehicleStack.field_77990_d = new NBTTagCompound();
    this.driveableData.writeToNBT(vehicleStack.field_77990_d);
    ((ItemPlane)vehicleStack.func_77973_b()).spawnPlaneAngled(this.field_70170_p, this.field_70165_t + 0.0D, this.field_70163_u + 0.0D, this.field_70161_v + 0.0D, this.axes.getYaw() - 90.0F, -1.0F * this.axes.getPitch(), this.axes.getRoll(), vehicleStack);
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
  
  public void setPropPosition(float current, float previous) {
    this.propAngle = current;
    this.prevPropAngle = previous;
  }
  
  public boolean func_130002_c(EntityPlayer entityplayer) {
    if (this.field_70128_L)
      return false; 
    if (this.field_70170_p.field_72995_K)
      return false; 
    ItemStack currentItem = entityplayer.func_71045_bC();
    if (currentItem != null && currentItem.func_77973_b() instanceof ItemTool && ((ItemTool)currentItem.func_77973_b()).type.healDriveables)
      return true; 
    PlaneType type = getPlaneType();
    for (int i = 0; i <= type.numPassengers; i++) {
      if (this.seats[i].func_130002_c(entityplayer)) {
        if (i == 0) {
          this.bombDelay = type.planeBombDelay;
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
    PlaneType type = getPlaneType();
    if (key == 36 && System.currentTimeMillis() - this.lastshellswitchedat > 500L && this.seats != null && this.seats[0] != null) {
      this.lastshellswitchedat = System.currentTimeMillis();
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketCurrentMissile(func_145782_y(), this.driveableData.func_70301_a(1)));
    } 
    if (this.field_70170_p.field_72995_K && (key == 6 || key == 8 || key == 9)) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableKey(key));
      return true;
    } 
    boolean canThrust = ((this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d) || (getDriveableData()).fuelInTank > 0.0F);
    switch (key) {
      case 0:
        if (canThrust || this.throttle < 0.0F)
          if (type.mode == EnumPlaneMode.HELI || this.mode == EnumPlaneMode.VTOL) {
            this.throttle += 0.002F;
            if (this.throttle > 1.0F)
              this.throttle = 1.0F; 
            this.xSpeed += 0.5F;
          } else {
            this.throttle += 0.02F;
            if (this.throttle > 1.0F)
              this.throttle = 1.0F; 
          }  
        return true;
      case 1:
        if (canThrust || this.throttle > 0.0F)
          if (type.mode == EnumPlaneMode.HELI || type.mode == EnumPlaneMode.VTOL) {
            this.throttle -= 0.005F;
            if (this.throttle < -1.0F)
              this.throttle = -1.0F; 
            if (this.throttle < 0.0F && type.maxNegativeThrottle == 0.0F)
              this.throttle = 0.0F; 
            this.xSpeed -= 0.5F;
          } else {
            this.throttle -= 0.04F;
            if (this.throttle < -1.0F)
              this.throttle = -1.0F; 
            if (this.throttle < 0.0F && type.maxNegativeThrottle == 0.0F) {
              this.throttle = 0.0F;
              if (this.driveableData.landBrake < 20 && this.varGear)
                this.driveableData.landBrake += 2; 
            } 
          }  
        return true;
      case 2:
        if (this.mode != EnumPlaneMode.SIXDOF)
          this.flapsYaw--; 
        this.zSpeed--;
        return true;
      case 3:
        if (this.mode != EnumPlaneMode.SIXDOF)
          this.flapsYaw++; 
        this.zSpeed++;
        return true;
      case 4:
        if (this.mode != EnumPlaneMode.SIXDOF) {
          this.flapsPitchLeft++;
          this.flapsPitchRight++;
        } 
        this.ySpeed++;
        return true;
      case 5:
        if (this.mode != EnumPlaneMode.SIXDOF) {
          this.flapsPitchLeft--;
          this.flapsPitchRight--;
        } 
        this.ySpeed--;
        return true;
      case 6:
        this.exitTimer--;
        this.exitTimer--;
        if (this.exitTimer > 20)
          return true; 
      case 7:
        if (this.field_70170_p.field_72995_K && (type.invInflight || (Math.abs(this.throttle) < 0.1F && this.field_70122_E)))
          FlansMod.proxy.openDriveableMenu((EntityPlayer)(this.seats[0]).field_70153_n, this.field_70170_p, this); 
        return true;
      case 9:
        func_70078_a(null);
        return true;
      case 8:
        checkCarrierRange = 20.0D;
        carrier = this.field_70170_p.func_72872_a(EntitySeat.class, AxisAlignedBB.func_72330_a(this.field_70165_t - checkCarrierRange, this.field_70163_u - checkCarrierRange, this.field_70161_v - checkCarrierRange, this.field_70165_t + checkCarrierRange, this.field_70163_u + checkCarrierRange, this.field_70161_v + checkCarrierRange));
        if (type.carrierLandable == true || type.helipadLandable == true) {
          if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlane && !(this.field_70153_n instanceof EntityPlayer)) {
            this.field_70153_n.func_70078_a(null);
            return true;
          } 
          for (Object obj : carrier) {
            EntitySeat carrierSpot = (EntitySeat)obj;
            if ((carrierSpot.field_70153_n == null && carrierSpot.seatInfo.carrier == true) || (carrierSpot.field_70153_n == null && carrierSpot.seatInfo.helipad == true && type.helipadLandable == true)) {
              if (carrierSpot.driveable != null && type.mass <= (carrierSpot.driveable.getDriveableType()).weightLimit) {
                func_70078_a(carrierSpot);
                continue;
              } 
              player.func_145747_a((IChatComponent)new ChatComponentText("Your aircraft (" + type.mass + " kg) is too heavy to dock! Weight limit: " + (carrierSpot.driveable.getDriveableType()).weightLimit + " kg"));
            } 
          } 
        } 
        return true;
      case 10:
        FlansMod.proxy.changeControlMode((EntityPlayer)(this.seats[0]).field_70153_n);
        (this.seats[0]).playerLooking = new RotatedAxes(0.0F, 0.0F, 0.0F);
        return true;
      case 11:
        if (this.mode != EnumPlaneMode.SIXDOF) {
          this.flapsPitchLeft += 2.0F;
          this.flapsPitchRight -= 2.0F;
        } else {
          this.flapsYaw -= 0.5F;
        } 
        return true;
      case 12:
        if (this.mode != EnumPlaneMode.SIXDOF) {
          this.flapsPitchLeft -= 2.0F;
          this.flapsPitchRight += 2.0F;
        } else {
          this.flapsYaw += 0.5F;
        } 
        return true;
      case 13:
        if (this.toggleTimer <= 0)
          if (this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)(this.field_70163_u - 3.0D), (int)this.field_70161_v)) {
            this.varGear = !this.varGear;
            player.func_145747_a((IChatComponent)new ChatComponentText("Landing gear " + (this.varGear ? "down" : "up")));
            this.toggleTimer = 10;
            FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableControl(this));
          }  
        return true;
      case 14:
        if (this.toggleTimer <= 0) {
          this.varDoor = !this.varDoor;
          if (type.hasDoor)
            player.func_145747_a((IChatComponent)new ChatComponentText("Doors " + (this.varDoor ? "open" : "closed"))); 
          this.toggleTimer = 10;
          FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableControl(this));
        } 
        if (this.toggleTimer <= 0) {
          this.combatRadar = !this.combatRadar;
          if (type.hasRadar)
            player.func_145747_a((IChatComponent)new ChatComponentText("Radar set to " + (this.combatRadar ? "combat range" : "long range"))); 
          this.toggleTimer = 10;
        } 
        return true;
      case 15:
        if (this.toggleTimer <= 0)
          if (type.mode == EnumPlaneMode.VTOL) {
            if (this.mode == EnumPlaneMode.HELI) {
              this.mode = EnumPlaneMode.PLANE;
            } else {
              this.mode = EnumPlaneMode.HELI;
            } 
            this.toggleTimer = 10;
            player.func_145747_a((IChatComponent)new ChatComponentText((this.mode == EnumPlaneMode.HELI) ? "Entering hover mode" : "Entering plane mode"));
          } else if (type.mode != EnumPlaneMode.HELI) {
            player.func_145747_a((IChatComponent)new ChatComponentText(!this.varFlap ? "Landing flaps deployed" : "Landing flaps retracted"));
            this.varFlap = !this.varFlap;
            this.toggleTimer = 10;
            FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableControl(this));
          }  
        return true;
      case 19:
        if (this.nintendoSwitchLite > 0) {
          this.nintendoSwitchLite--;
          this.nintendoSwitchLite--;
        } 
        if (PlayerHandler.getPlayerData(player) != null && this.nintendoSwitchLite <= 0)
          if (type.numPassengers > 0 && (this.seats[1]).field_70153_n == null) {
            (PlayerHandler.getPlayerData(player)).nintendoSwitch = 10;
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
      case 34:
        if (this.ticksRepairing <= 0 && this.throttle <= 0.05D && !this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)(this.field_70163_u - 5.0D), (int)this.field_70161_v)) {
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
      case 35:
        if (this.toggleTimer <= 0 && type.hasPlaneRadar) {
          this.activeRadar = !this.activeRadar;
          this.toggleTimer = 10;
          player.func_145747_a((IChatComponent)new ChatComponentText("Radar Mode : " + (this.activeRadar ? "active" : "passive")));
        } 
        return true;
      case 16:
        if (this.toggleTimer <= 0 && type.hasAfterBurner) {
          this.afterBurning = !this.afterBurning;
          player.func_145747_a((IChatComponent)new ChatComponentText(type.afterBurnName + (this.afterBurning ? " activated" : " deactivated")));
          this.toggleTimer = 10;
          FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableControl(this));
          if (type.AfterburnWing) {
            this.varWing = this.afterBurning;
            this.anim.changeState(this.varWing ? 0 : 1);
          } else if (type.AfterburnWingFlipped) {
            this.varWing = !this.afterBurning;
            this.anim.changeState(this.varWing ? 0 : 1);
          } 
        } 
        return true;
      case 18:
        if (type.hasFlare && this.ticksFlareUsing <= 0 && this.flareDelay <= 0 && !type.autoSmoke) {
          this.ticksFlareUsing = type.timeFlareUsing * 20;
          this.flareDelay = type.flareDelay;
          if (this.field_70170_p.field_72995_K) {
            FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableKey(key));
          } else if (!type.flareSound.isEmpty()) {
            PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.flareSound, false);
          } 
          return true;
        } 
        break;
      case 33:
        if (this.driveableData.thermalTimer <= 0 && type.hasMagicArtilleryMode) {
          this.artilleryMode = !this.artilleryMode;
          this.driveableData.thermalTimer = 10;
        } 
        return true;
    } 
    return false;
  }
  
  public void updateKeyHeldState(int key, boolean held) {
    super.updateKeyHeldState(key, held);
    if (!this.field_70170_p.field_72995_K)
      switch (key) {
      
      }  
  }
  
  public void func_70071_h_() {
    super.func_70071_h_();
    this.prevWingPos = this.wingPos;
    this.prevWingRot = this.wingRot;
    this.prevWingWheelPos = this.wingWheelPos;
    this.prevWingWheelRot = this.wingWheelRot;
    this.prevCoreWheelPos = this.coreWheelPos;
    this.prevCoreWheelRot = this.coreWheelRot;
    this.prevTailWheelPos = this.tailWheelPos;
    this.prevTailWheelRot = this.tailWheelRot;
    this.prevDoorPos = this.doorPos;
    this.prevDoorRot = this.doorRot;
    if ((getPlaneType()).valkyrie) {
      if (!this.initiatedAnim) {
        this.anim.initPoses();
        this.anim.initAnim();
        this.initiatedAnim = true;
        this.anim.changeState(this.varWing ? 0 : 1);
      } 
      if (this.initiatedAnim) {
        int j = this.varWing ? 0 : 1;
        this.anim.UpdateAnim(j);
      } 
    } 
    if (this.driveableData.catapult > 0)
      this.driveableData.catapult--; 
    if (this.field_70173_aa == 19 && ((getDriveableData()).seatBelt == null || (getDriveableData()).seatBelt.length() == 0))
      (getDriveableData()).seatBelt = "null"; 
    if (this.field_70173_aa > 20) {
      if (this.seats[0] != null && (this.seats[0]).field_70153_n != null && (this.seats[0]).field_70153_n instanceof EntityPlayer) {
        EntityPlayer Master = (EntityPlayer)(this.seats[0]).field_70153_n;
        (getDriveableData()).seatBelt = Master.getDisplayName();
        (getDriveableData()).emergencyMode = false;
      } 
      if ((getDriveableData()).seatBelt != null && !(getDriveableData()).seatBelt.equals("null") && (getDriveableData()).seatBelt.length() != 0)
        if (this.field_70170_p.func_72924_a((getDriveableData()).seatBelt) == null)
          if (!(getDriveableData()).emergencyMode) {
            (getDriveableData()).emergencyMode = true;
            rebirth();
          }   
    } 
    boolean isDivisibleBy10 = (this.field_70173_aa % 5 == 0);
    if ((getDriveableData()).emergencyMode && isDivisibleBy10) {
      this.throttle = 1.0F;
      this.varGear = false;
      List<Entity> foxes = this.field_70170_p.func_72839_b(this, AxisAlignedBB.func_72330_a(this.field_70165_t - 200.0D, this.field_70163_u - 1000.0D, this.field_70161_v - 200.0D, this.field_70165_t + 200.0D, this.field_70163_u + 1000.0D, this.field_70161_v + 200.0D));
      for (Entity stuff : foxes) {
        if (!(stuff instanceof EntityPlayer))
          continue; 
        EntityPlayer human = (EntityPlayer)stuff;
        if (this.field_70170_p.func_72924_a((getDriveableData()).seatBelt) == human)
          human.func_70078_a(this.seats[0]); 
      } 
    } 
    if (this.driveableData.landBrake > 0)
      this.driveableData.landBrake--; 
    if (this.initiatedAnim && this.throttle > 0.2F) {
      Vector3f v = this.anim.getFullPosition(new Vector3f(151.0F, -25.0F, -24.0F), this.anim.parts.get(5));
      v = this.axes.findLocalVectorGlobally(new Vector3f(-v.x, -v.y, v.z));
      Vector3f v2 = this.anim.getFullPosition(new Vector3f(151.0F, -25.0F, 24.0F), this.anim.parts.get(8));
      v2 = this.axes.findLocalVectorGlobally(new Vector3f(-v2.x, -v2.y, v2.z));
      for (int j = 0; j < 4; j++) {
        if (!Float.isNaN(v.x))
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.afterburn", this.field_70165_t + (v2.x / 16.0F), this.field_70163_u + (v2.y / 16.0F), this.field_70161_v + (v2.z / 16.0F), 0.0D, 0.0D, 0.0D), this.field_70165_t + (v2.x / 16.0F), this.field_70163_u + (v2.y / 16.0F), this.field_70161_v + (v2.z / 16.0F), 150.0F, this.field_71093_bK); 
        if (!Float.isNaN(v.x))
          FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.afterburn", this.field_70165_t + (v.x / 16.0F), this.field_70163_u + (v.y / 16.0F), this.field_70161_v + (v.z / 16.0F), 0.0D, 0.0D, 0.0D), this.field_70165_t + (v.x / 16.0F), this.field_70163_u + (v.y / 16.0F), this.field_70161_v + (v.z / 16.0F), 150.0F, this.field_71093_bK); 
      } 
    } 
    PlaneType type = getPlaneType();
    DriveableData data = getDriveableData();
    if (type == null) {
      FlansMod.log("Plane type null. Not ticking plane");
      return;
    } 
    if (type.swapInitialWing && this.field_70173_aa == 30)
      this.anim.changeState(!this.afterBurning ? 0 : 1); 
    boolean thePlayerIsDrivingThis = (this.field_70170_p.field_72995_K && this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && FlansMod.proxy.isThePlayer((EntityPlayer)(this.seats[0]).field_70153_n));
    this.ticksSinceUsed++;
    if (!this.field_70170_p.field_72995_K && (this.seats[0]).field_70153_n != null)
      this.ticksSinceUsed = 0; 
    if (!this.field_70170_p.field_72995_K && TeamsManager.planeLife > 0 && this.ticksSinceUsed > TeamsManager.planeLife * 20)
      func_70106_y(); 
    if (this.field_70170_p.field_72995_K && (this.varFlare || this.ticksFlareUsing > 0))
      if (this.field_70173_aa % 5 == 0) {
        Vector3f dir = this.axes.findLocalVectorGlobally(new Vector3f(0.0F, -0.5F, 0.0F));
        FlansMod.proxy.spawnParticle("flansmod.flare", this.field_70165_t, this.field_70163_u, this.field_70161_v, dir.x, dir.y, dir.z);
      }  
    if (this.ticksFlareUsing > 0)
      this.ticksFlareUsing--; 
    if (this.flareDelay > 0)
      this.flareDelay--; 
    double checkCarrierRange = 20.0D;
    List carrier = this.field_70170_p.func_72872_a(EntitySeat.class, AxisAlignedBB.func_72330_a(this.field_70165_t - checkCarrierRange, this.field_70163_u - checkCarrierRange, this.field_70161_v - checkCarrierRange, this.field_70165_t + checkCarrierRange, this.field_70163_u + checkCarrierRange, this.field_70161_v + checkCarrierRange));
    if ((type.carrierLandable == true && this.field_70173_aa == 20) || (type.helipadLandable == true && this.field_70173_aa == 20)) {
      if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlane && !(this.field_70153_n instanceof EntityPlayer)) {
        this.field_70153_n.func_70078_a(null);
        System.out.println("carrier suction did this");
      } 
      for (Object obj : carrier) {
        EntitySeat carrierSpot = (EntitySeat)obj;
        if (type != null && obj != null && carrierSpot != null && carrierSpot.seatInfo != null && ((carrierSpot.field_70153_n == null && carrierSpot.seatInfo.carrier == true) || (carrierSpot.field_70153_n == null && carrierSpot.seatInfo.helipad == true && type.helipadLandable == true))) {
          System.out.println("carrier suction did this");
          if (carrierSpot.driveable != null && type.mass <= (carrierSpot.driveable.getDriveableType()).weightLimit) {
            func_70078_a(carrierSpot);
            continue;
          } 
          if (type.mass <= 1.5F * (carrierSpot.driveable.getDriveableType()).weightLimit)
            func_70078_a(carrierSpot); 
        } 
      } 
    } 
    if (this.mode == EnumPlaneMode.PLANE && type.carrierLandable && this.throttle < 0.2F && this.varGear && this.driveableData.catapult == 0) {
      List carrierLanding = this.field_70170_p.func_72872_a(EntitySeat.class, AxisAlignedBB.func_72330_a(this.field_70165_t - 3.0D, this.field_70163_u - 1.0D, this.field_70161_v - 3.0D, this.field_70165_t + 3.0D, this.field_70163_u + 1.0D, this.field_70161_v + 3.0D));
      if (type.carrierLandable == true || type.helipadLandable == true) {
        if (this.field_70153_n != null && this.field_70153_n instanceof EntityPlane && !(this.field_70153_n instanceof EntityPlayer))
          this.field_70153_n.func_70078_a(null); 
        for (Object obj : carrierLanding) {
          EntitySeat carrierSpot = (EntitySeat)obj;
          if (type != null && obj != null && carrierSpot != null && carrierSpot.seatInfo != null && ((carrierSpot.field_70153_n == null && carrierSpot.seatInfo.carrier == true) || (carrierSpot.field_70153_n == null && carrierSpot.seatInfo.helipad == true && type.helipadLandable == true))) {
            if (carrierSpot.driveable != null && type.mass <= (carrierSpot.driveable.getDriveableType()).weightLimit) {
              func_70078_a(carrierSpot);
              continue;
            } 
            if ((EntityPlayer)(this.seats[0]).field_70153_n != null)
              ((EntityPlayer)(this.seats[0]).field_70153_n).func_145747_a((IChatComponent)new ChatComponentText("Your aircraft (" + type.mass + " kg) is too heavy to dock! Weight limit: " + (carrierSpot.driveable.getDriveableType()).weightLimit + " kg")); 
          } 
        } 
      } 
    } 
    if (this.nintendoSwitchLite < 10)
      this.nintendoSwitchLite++; 
    if (this.exitTimer < type.exitTimer)
      this.exitTimer++; 
    if (this.driveableData.thermalTimer > 0)
      this.driveableData.thermalTimer--; 
    if (this.ticksRepairing > 0)
      this.ticksRepairing--; 
    if (this.exitTimer < 0 && this.seats[0] != null)
      if (this.seats[0] != null && (this.seats[0]).field_70153_n != null) {
        (this.seats[0]).field_70153_n.func_70078_a(null);
        this.exitTimer = type.exitTimer;
      }  
    if (this.testerino > 5 && this.seats[0] != null)
      if (this.field_70170_p.field_72995_K)
        (this.seats[0]).field_70153_n = null;  
    if (this.afterBurning && type.hasAfterBurner)
      if (this.throttle < 1.0F)
        this.throttle += 0.005F;  
    if (this.afterBurning && this.throttle > 0.5D && this.poopooTimer == 0 && getSpeedXYZ() > 1.7000000476837158D) {
      FlansMod.packetHandler.sendToDonut((PacketBase)new PacketPlaySound(this.field_70165_t, this.field_70163_u, this.field_70161_v, type.sonicBoomSound), this.field_70165_t, this.field_70163_u, this.field_70161_v, 15.0F, 120.0F, this.field_71093_bK);
      this.poopooTimer = 140;
    } 
    if (this.bombDelay > 0)
      this.bombDelay--; 
    if (this.gunDelay > 0)
      this.gunDelay--; 
    if (this.toggleTimer > 0)
      this.toggleTimer--; 
    if (this.carrierTimer < 0)
      this.carrierTimer++; 
    if (this.poopooTimer > 0)
      this.poopooTimer--; 
    if (!this.varWing) {
      this.wingPos = transformPart(this.wingPos, type.wingPos1, type.wingRate);
      this.wingRot = transformPart(this.wingRot, type.wingRot1, type.wingRotRate);
    } else {
      this.wingPos = transformPart(this.wingPos, type.wingPos2, type.wingRate);
      this.wingRot = transformPart(this.wingRot, type.wingRot2, type.wingRotRate);
    } 
    if (this.varGear) {
      this.wingWheelPos = transformPart(this.wingWheelPos, type.wingWheelPos1, type.wingWheelRate);
      this.wingWheelRot = transformPart(this.wingWheelRot, type.wingWheelRot1, type.wingWheelRotRate);
      this.coreWheelPos = transformPart(this.coreWheelPos, type.bodyWheelPos1, type.bodyWheelRate);
      this.coreWheelRot = transformPart(this.coreWheelRot, type.bodyWheelRot1, type.bodyWheelRotRate);
      this.tailWheelPos = transformPart(this.tailWheelPos, type.tailWheelPos1, type.tailWheelRate);
      this.tailWheelRot = transformPart(this.tailWheelRot, type.tailWheelRot1, type.tailWheelRotRate);
    } else {
      this.wingWheelPos = transformPart(this.wingWheelPos, type.wingWheelPos2, type.wingWheelRate);
      this.wingWheelRot = transformPart(this.wingWheelRot, type.wingWheelRot2, type.wingWheelRotRate);
      this.coreWheelPos = transformPart(this.coreWheelPos, type.bodyWheelPos2, type.bodyWheelRate);
      this.coreWheelRot = transformPart(this.coreWheelRot, type.bodyWheelRot2, type.bodyWheelRotRate);
      this.tailWheelPos = transformPart(this.tailWheelPos, type.tailWheelPos2, type.tailWheelRate);
      this.tailWheelRot = transformPart(this.tailWheelRot, type.tailWheelRot2, type.tailWheelRotRate);
    } 
    if (!this.varDoor) {
      this.doorPos = transformPart(this.doorPos, type.doorPos1, type.doorRate);
      this.doorRot = transformPart(this.doorRot, type.doorRot1, type.doorRotRate);
    } else {
      this.doorPos = transformPart(this.doorPos, type.doorPos2, type.doorRate);
      this.doorRot = transformPart(this.doorRot, type.doorRot2, type.doorRotRate);
    } 
    if (!this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)(this.field_70163_u - 10.0D), (int)this.field_70161_v) && this.throttle <= 0.2D) {
      for (EntitySeat seat : this.seats) {
        if (seat != null)
          if (!this.varGear && this.seats != null && this.seats[0] != null && (this.seats[0]).field_70153_n != null && (EntityPlayer)(this.seats[0]).field_70153_n != null && this.poopooTimer == 0 && !this.mounted) {
            if (this.field_70170_p.field_72995_K) {
              ((EntityPlayer)(this.seats[0]).field_70153_n).func_145747_a((IChatComponent)new ChatComponentText("Low Altitude! Deploy Landing Gear!"));
            } else {
              ((EntityPlayer)(this.seats[0]).field_70153_n).func_145747_a((IChatComponent)new ChatComponentText("Low Altitude! Deploy Landing Gear!"));
            } 
            this.poopooTimer = 60;
          }  
      } 
      if (type.foldWingForLand) {
        if (this.varWing && (EntityPlayer)(this.seats[0]).field_70153_n != null)
          ((EntityPlayer)(this.seats[0]).field_70153_n).func_145747_a((IChatComponent)new ChatComponentText("Extending wings")); 
        this.varWing = false;
      } 
    } 
    if (!this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)(this.field_70163_u - 3.0D), (int)this.field_70161_v) && this.throttle <= 0.05D) {
      if (!this.doorsHaveShut)
        this.varDoor = true; 
      this.doorsHaveShut = true;
    } else if (!type.flyWithOpenDoor) {
      this.varDoor = false;
      this.doorsHaveShut = false;
    } 
    if (this.locked) {
      this.varDoor = false;
      this.doorsHaveShut = false;
    } 
    if (!isPartIntact(EnumDriveablePart.tail) && type.spinWithoutTail) {
      this.flapsYaw = 15.0F;
      if (func_70090_H())
        attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F); 
    } 
    this.flapsYaw *= 0.9F;
    this.flapsPitchLeft *= 0.9F;
    this.flapsPitchRight *= 0.9F;
    if (this.flapsYaw > 20.0F)
      this.flapsYaw = 20.0F; 
    if (this.flapsYaw < -20.0F)
      this.flapsYaw = -20.0F; 
    if (this.flapsPitchRight > 20.0F)
      this.flapsPitchRight = 20.0F; 
    if (this.flapsPitchRight < -20.0F)
      this.flapsPitchRight = -20.0F; 
    if (this.flapsPitchLeft > 20.0F)
      this.flapsPitchLeft = 20.0F; 
    if (this.flapsPitchLeft < -20.0F)
      this.flapsPitchLeft = -20.0F; 
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
    if (type.labjacFuel > 15.0F) {
      if (this.labjacFuel <= 0.0F) {
        this.throttle = 0.0F;
        this.afterBurning = false;
      } 
      if (this.mounted && this.labjacFuel < type.labjacFuel)
        this.labjacFuel += 50.0F; 
      if (this.labjacFuel < type.labjacFuel && this.throttle <= 0.1D && this.throttle > -0.1D && this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)(this.field_70163_u + 1.0D), (int)this.field_70161_v) && !this.field_70170_p.func_147437_c((int)this.field_70165_t, (int)(this.field_70163_u - 10.0D), (int)this.field_70161_v))
        this.labjacFuel += 30.0F; 
      if (this.labjacFuel > type.labjacFuel)
        this.labjacFuel = type.labjacFuel; 
      if (this.throttle > 0.05F && this.afterBurning) {
        this.labjacFuel -= 10.0F * this.throttle * type.afterBurnFuelPenalty;
      } else if (this.throttle > 0.05F && !this.afterBurning) {
        this.labjacFuel -= 10.0F * this.throttle;
      } 
    } 
    if (this.mounted) {
      if (this.mode != EnumPlaneMode.HELI)
        this.driveableData.catapult = 44; 
      if (this.mode != EnumPlaneMode.HELI || this.throttle > 0.5F)
        this.throttle *= 0.97F; 
      this.control.V *= 0.95F;
      this.field_70159_w *= 0.6899999976158142D;
      this.field_70181_x *= 0.6899999976158142D;
      this.field_70179_y *= 0.6899999976158142D;
      if (this.throttle <= 0.05F && this.field_70173_aa % 10 == 0) {
        if (!type.carrierWingFlip) {
          this.varWing = false;
        } else {
          this.varWing = true;
        } 
        this.anim.changeState(this.varWing ? 0 : 1);
      } 
    } 
    if (this.throttle > 0.05F && this.field_70173_aa % 10 == 0 && !type.AfterburnWing) {
      if (!type.carrierWingFlip) {
        this.varWing = true;
      } else {
        this.varWing = false;
      } 
      this.anim.changeState(this.varWing ? 0 : 1);
    } 
    if (this.driveableData.catapult < 44 && this.driveableData.catapult > 0) {
      this.throttle += 0.025F;
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("cloud", this.field_70165_t, this.field_70163_u, this.field_70161_v, 0.0D, 0.0D, 0.0D), this.field_70165_t, this.field_70163_u, this.field_70161_v, 150.0F, this.field_71093_bK);
    } 
    if (this.field_70170_p != null)
      if ((type.carrierLandable && this.field_70173_aa > 40) || (type.helipadLandable && this.field_70173_aa > 40)) {
        List list = this.field_70170_p.func_72872_a(EntitySeat.class, AxisAlignedBB.func_72330_a(this.field_70165_t - 20.0D, this.field_70163_u - 20.0D, this.field_70161_v - 20.0D, this.field_70165_t + 20.0D, this.field_70163_u + 20.0D, this.field_70161_v + 20.0D));
        for (Object obj : list) {
          if (!(obj instanceof EntitySeat))
            continue; 
          if (obj != null && obj instanceof EntitySeat) {
            EntitySeat carrierSpot = (EntitySeat)obj;
            if (type != null && obj != null && carrierSpot != null && carrierSpot.seatInfo != null && ((carrierSpot.field_70153_n == null && carrierSpot.seatInfo.carrier == true) || (carrierSpot.field_70153_n == null && carrierSpot.seatInfo.helipad == true && type.helipadLandable == true))) {
              data.carrierTip++;
              data.carrierTip++;
            } 
          } 
        } 
      }  
    if (data.carrierTip > 0)
      data.carrierTip--; 
    if (data.carrierTip > 5)
      data.carrierTip = 5; 
    boolean canThrust = ((this.seats[0] != null && (this.seats[0]).field_70153_n instanceof EntityPlayer && ((EntityPlayer)(this.seats[0]).field_70153_n).field_71075_bZ.field_75098_d) || data.fuelInTank > 0.0F);
    float throttlePull = 0.99F;
    if (this.seats[0] != null && (this.seats[0]).field_70153_n != null && this.mode == EnumPlaneMode.HELI && canThrust)
      if (type.rocketThrottle && this.throttle > 0.1F && this.fuelTimer > 0) {
        this.throttle = 1.0F;
        this.fuelTimer--;
      } else if (this.fuelTimer <= 0) {
        this.throttle = 0.0F;
      } else {
        this.throttle = (this.throttle - 0.5F) * throttlePull + 0.5F;
      }  
    this.control.fly(this);
    double motion = Math.sqrt(this.field_70159_w * this.field_70159_w + this.field_70181_x * this.field_70181_x + this.field_70179_y * this.field_70179_y);
    if (motion > 10.0D) {
      this.field_70159_w *= 10.0D / motion;
      this.field_70181_x *= 10.0D / motion;
      this.field_70179_y *= 10.0D / motion;
    } 
    for (EntityWheel wheel : this.wheels) {
      if (wheel != null && this.field_70170_p != null) {
        if (type.floatOnWater && this.field_70170_p.func_72953_d(this.field_70121_D))
          this.field_70181_x = type.buoyancy; 
        if (!type.floatOnWater && this.field_70170_p.func_72953_d(this.field_70121_D))
          this.throttle = 0.0F; 
      } 
    } 
    for (EntityWheel wheel : this.wheels) {
      if (wheel != null) {
        wheel.field_70167_r = wheel.field_70163_u;
        wheel.func_70091_d(this.field_70159_w, this.onDeck ? 0.0D : this.field_70181_x, this.field_70179_y);
      } 
    } 
    correctWheelPos();
    for (int i = 0; i < 2; i++) {
      Vector3f amountToMoveCar = new Vector3f(this.field_70159_w / 2.0D, this.onDeck ? 0.0D : (this.field_70181_x / 2.0D), this.field_70179_y / 2.0D);
      for (EntityWheel wheel : this.wheels) {
        if (wheel != null) {
          this.field_70122_E = true;
          wheel.field_70122_E = true;
          wheel.field_70177_z = this.axes.getYaw();
          Vector3f wPos = ((getPlaneType()).wheelPositions[wheel.ID]).position;
          if (type.valkyrie && this.varWing)
            wPos = new Vector3f(wPos.x, wPos.y + 5.625F, wPos.z); 
          Vector3f targetWheelPos = this.axes.findLocalVectorGlobally(wPos);
          Vector3f currentWheelPos = new Vector3f(wheel.field_70165_t - this.field_70165_t, wheel.field_70163_u - this.field_70163_u, wheel.field_70161_v - this.field_70161_v);
          float targetWheelLength = targetWheelPos.length();
          float currentWheelLength = currentWheelPos.length();
          float dLength = targetWheelLength - currentWheelLength;
          float dAngle = Vector3f.angle(targetWheelPos, currentWheelPos);
          float newLength = currentWheelLength + dLength * type.wheelSpringStrength;
          Vector3f rotateAround = Vector3f.cross(targetWheelPos, currentWheelPos, null);
          Matrix4f mat = new Matrix4f();
          mat.m00 = currentWheelPos.x;
          mat.m10 = currentWheelPos.y;
          mat.m20 = currentWheelPos.z;
          mat.rotate(dAngle * type.wheelSpringStrength, rotateAround);
          if (this.field_70173_aa > 5)
            if (!type.valkyrie || this.anim.timeSinceSwitch >= 10)
              this.axes.rotateGlobal(-dAngle * type.wheelSpringStrength, rotateAround);  
          Vector3f newWheelPos = new Vector3f(mat.m00, mat.m10, mat.m20);
          newWheelPos.normalise().scale(newLength);
          float wheelProportion = 0.75F;
          Vector3f amountToMoveWheel = new Vector3f();
          amountToMoveWheel.x = (newWheelPos.x - currentWheelPos.x) * (1.0F - wheelProportion);
          amountToMoveWheel.y = (newWheelPos.y - currentWheelPos.y) * (1.0F - wheelProportion);
          amountToMoveWheel.z = (newWheelPos.z - currentWheelPos.z) * (1.0F - wheelProportion);
          amountToMoveCar.x -= (newWheelPos.x - currentWheelPos.x) * (1.0F - wheelProportion);
          amountToMoveCar.y -= (newWheelPos.y - currentWheelPos.y) * (1.0F - wheelProportion);
          amountToMoveCar.z -= (newWheelPos.z - currentWheelPos.z) * (1.0F - wheelProportion);
          amountToMoveCar.y = (float)(amountToMoveCar.y + (wheel.field_70163_u - wheel.field_70167_r - (this.onDeck ? 0.0D : this.field_70181_x)) * 0.5D / this.wheels.length);
          wheel.func_70091_d(amountToMoveWheel.x, amountToMoveWheel.y, amountToMoveWheel.z);
        } 
      } 
      func_70091_d(amountToMoveCar.x, amountToMoveCar.y, amountToMoveCar.z);
    } 
    if (this.field_70154_o != null)
      if (this.field_70154_o.getClass().toString().indexOf("mcheli.aircraft.MCH_EntitySeat") > 0)
        this.axes.setAngles(this.field_70154_o.field_70177_z + 90.0F, 0.0F, 0.0F);  
    checkForCollisions();
    if (this.throttle > 0.01F && this.throttle < 0.2F && this.soundPosition == 0) {
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.startSound, false);
      this.soundPosition = type.startSoundLength;
    } 
    if (this.throttle > 0.2F && this.soundPosition == 0) {
      PacketPlaySound.sendSoundPacket(this.field_70165_t, this.field_70163_u, this.field_70161_v, 50.0D, this.field_71093_bK, type.engineSound, false);
      this.soundPosition = type.engineSoundLength;
    } 
    if (this.soundPosition > 0)
      this.soundPosition--; 
    for (EntitySeat seat : this.seats) {
      if ((seat != null && seat.field_70153_n != null && seat.field_70153_n instanceof EntityPlayer) || (seat != null && seat.field_70153_n != null && this.field_70173_aa % 4 == 0) || (seat != null && seat.field_70153_n == null && this.field_70173_aa % 10 == 0))
        seat.updatePosition(); 
    } 
    int packetRate = 4;
    if (thePlayerIsDrivingThis && this.field_70173_aa % 2 == 0) {
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketPlaneControl(this));
      FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketPlaneAnimator(this));
      this.field_70118_ct = this.field_70165_t;
      this.field_70117_cu = this.field_70163_u;
      this.field_70116_cv = this.field_70161_v;
      this.serverYaw = this.axes.getYaw();
    } 
    float updateSpeed = 0.01F;
    if (!this.field_70170_p.field_72995_K && this.field_70173_aa % packetRate == 0) {
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketPlaneControl(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, FlansMod.driveableUpdateRange, this.field_71093_bK);
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketPlaneAnimator(this), this.field_70165_t, this.field_70163_u, this.field_70161_v, FlansMod.driveableUpdateRange, this.field_71093_bK);
    } 
  }
  
  public void func_70106_y() {
    super.func_70106_y();
    for (EntityWheel wheel : this.wheels) {
      if (wheel != null)
        wheel.func_70106_y(); 
    } 
  }
  
  public boolean gearDown() {
    return this.varGear;
  }
  
  public boolean attackEntityFrom(DamageSource damagesource, float i, boolean doDamage) {
    PlaneType type = PlaneType.getPlane(this.driveableType);
    if (this.field_70170_p.field_72995_K || this.field_70128_L || damagesource.field_76373_n.equals("arrow") || (!type.vanillaDamage && damagesource.field_76373_n.equals("player") && this.seats[0] != null && (this.seats[0]).field_70153_n != null))
      return true; 
    if (damagesource.field_76373_n.equals("player") && (damagesource.func_76346_g()).field_70122_E && (this.seats[0] == null || (this.seats[0]).field_70153_n == null) && !this.locked && !type.unpunchable) {
      this.driveableData.seatBelt = "null";
      ItemStack planeStack = new ItemStack(type.item, 1, this.driveableData.paintjobID);
      planeStack.field_77990_d = new NBTTagCompound();
      this.driveableData.writeToNBT(planeStack.field_77990_d);
      func_70099_a(planeStack, 0.5F);
      func_70106_y();
    } 
    return super.func_70097_a(damagesource, i);
  }
  
  public boolean canHitPart(EnumDriveablePart part) {
    return (this.varGear || (part != EnumDriveablePart.coreWheel && part != EnumDriveablePart.leftWingWheel && part != EnumDriveablePart.rightWingWheel && part != EnumDriveablePart.tailWheel));
  }
  
  public boolean func_70097_a(DamageSource damagesource, float i) {
    return attackEntityFrom(damagesource, i, true);
  }
  
  public PlaneType getPlaneType() {
    return PlaneType.getPlane(this.driveableType);
  }
  
  protected void dropItemsOnPartDeath(Vector3f midpoint, DriveablePart part) {}
  
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
  
  public String getBombInventoryName() {
    return "Bombs";
  }
  
  public String getMissileInventoryName() {
    return "Missiles";
  }
  
  public boolean hasMouseControlMode() {
    return true;
  }
}
