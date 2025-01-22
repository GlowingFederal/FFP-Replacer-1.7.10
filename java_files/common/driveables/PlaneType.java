package com.flansmod.common.driveables;

import com.flansmod.client.model.ModelDriveable;
import com.flansmod.client.model.ModelPlane;
import com.flansmod.common.FlansMod;
import com.flansmod.common.parts.PartType;
import com.flansmod.common.types.TypeFile;
import com.flansmod.common.vector.Vector3f;
import java.util.ArrayList;
import net.minecraft.item.ItemStack;

public class PlaneType extends DriveableType {
  public EnumPlaneMode mode = EnumPlaneMode.PLANE;
  
  public float lookDownModifier = 1.0F, lookUpModifier = 1.0F;
  
  public float rollLeftModifier = 1.0F, rollRightModifier = 1.0F;
  
  public float turnLeftModifier = 1.0F, turnRightModifier = 1.0F;
  
  public float lift = 1.0F;
  
  public Vector3f bombPosition;
  
  public int planeShootDelay;
  
  public int planeBombDelay;
  
  public float ceiling = 800.0F;
  
  public float speedLimit = 2.0F;
  
  public float speedLimitHigh = 4.0F;
  
  public float speedLimitDry = 1.0F;
  
  public float speedLimitHighDry = 1.5F;
  
  public Vector3f wingPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingRate = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingWheelPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingWheelPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingWheelRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingWheelRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingWheelRate = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f wingWheelRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f bodyWheelPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f bodyWheelPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f bodyWheelRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f bodyWheelRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f bodyWheelRate = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f bodyWheelRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f tailWheelPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f tailWheelPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f tailWheelRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f tailWheelRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f tailWheelRate = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f tailWheelRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f doorPos1 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f doorPos2 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f doorRot1 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f doorRot2 = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f doorRate = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f doorRotRate = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public ArrayList<Propeller> propellers = new ArrayList<>();
  
  public ArrayList<Propeller> heliPropellers = new ArrayList<>();
  
  public ArrayList<Propeller> heliTailPropellers = new ArrayList<>();
  
  public boolean hasGear = false, hasDoor = false, hasWing = false;
  
  public boolean foldWingForLand = false;
  
  public boolean flyWithOpenDoor = false;
  
  public float restingPitch = 0.0F;
  
  public boolean spinWithoutTail = false;
  
  public boolean valkyrie = false;
  
  public boolean carrierLandable = false;
  
  public boolean helipadLandable = false;
  
  public float planeDiveFactor = 0.5F;
  
  public float deathDiveSpeedLimit = 1.2F;
  
  public float stallSpeedLimit = 1.9F;
  
  public boolean invInflight = true;
  
  public float yawBonus = 1.2F;
  
  public float pitchBonus = 1.2F;
  
  public float rollBonus = 1.2F;
  
  public float yawStall = 0.5F;
  
  public float pitchStall = 0.5F;
  
  public float rollStall = 0.5F;
  
  public float afterBurnFuelPenalty = 3.0F;
  
  public boolean gunRecoil = true;
  
  public boolean swapInitialWing = false;
  
  public boolean unpunchable = false;
  
  public float noStallAngle = 15.0F;
  
  public boolean missileVisible = false;
  
  public float missileWingSpan = 4.0F;
  
  public float missileForward = -1.0F;
  
  public float missileElevation = -1.0F;
  
  public float afterburnOffBonus = 1.5F;
  
  public float mass = 5000.0F;
  
  public float cruiseSpeed = 400.0F;
  
  public float takeoffSpeed = 100.0F;
  
  public float climbRate = 5.0F;
  
  public float maxSpeed = 600.0F;
  
  public float turnTime = 0.0F;
  
  public float accelBonus = 1.0F;
  
  public float gravityMultiplier = 1.0F;
  
  public boolean carrierWingFlip = false;
  
  public boolean AfterburnWing = false;
  
  public boolean AfterburnWingFlipped = false;
  
  public static ArrayList<PlaneType> types = new ArrayList<>();
  
  public PlaneType(TypeFile file) {
    super(file);
    types.add(this);
  }
  
  public void preRead(TypeFile file) {
    super.preRead(file);
  }
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (split[0].equals("Mode"))
        this.mode = EnumPlaneMode.getMode(split[1]); 
      if (split[0].equals("TurnLeftSpeed"))
        this.turnLeftModifier = Float.parseFloat(split[1]); 
      if (split[0].equals("TurnRightSpeed"))
        this.turnRightModifier = Float.parseFloat(split[1]); 
      if (split[0].equals("yawBonus"))
        this.yawBonus = Float.parseFloat(split[1]); 
      if (split[0].equals("yawStall"))
        this.yawStall = Float.parseFloat(split[1]); 
      if (split[0].equals("LookUpSpeed"))
        this.lookUpModifier = Float.parseFloat(split[1]); 
      if (split[0].equals("LookDownSpeed"))
        this.lookDownModifier = Float.parseFloat(split[1]); 
      if (split[0].equals("pitchBonus"))
        this.pitchBonus = Float.parseFloat(split[1]); 
      if (split[0].equals("pitchStall"))
        this.pitchStall = Float.parseFloat(split[1]); 
      if (split[0].equals("RollLeftSpeed"))
        this.rollLeftModifier = Float.parseFloat(split[1]); 
      if (split[0].equals("RollRightSpeed"))
        this.rollRightModifier = Float.parseFloat(split[1]); 
      if (split[0].equals("rollBonus"))
        this.rollBonus = Float.parseFloat(split[1]); 
      if (split[0].equals("rollStall"))
        this.rollStall = Float.parseFloat(split[1]); 
      if (split[0].equals("afterBurnFuelPenalty"))
        this.afterBurnFuelPenalty = Float.parseFloat(split[1]); 
      if (split[0].equals("afterburnOffBonus"))
        this.afterburnOffBonus = Float.parseFloat(split[1]); 
      if (split[0].equals("Lift"))
        this.lift = Float.parseFloat(split[1]); 
      if (split[0].equals("ShootDelay"))
        this.planeShootDelay = Integer.parseInt(split[1]); 
      if (split[0].equals("BombDelay"))
        this.planeBombDelay = Integer.parseInt(split[1]); 
      if (split[0].equals("flightCeiling"))
        this.ceiling = Float.parseFloat(split[1]); 
      if (split[0].equals("diveBonus"))
        this.deathDiveSpeedLimit = Float.parseFloat(split[1]); 
      if (split[0].equals("stallSuffering"))
        this.stallSpeedLimit = Float.parseFloat(split[1]); 
      if (split[0].equals("maxSpeed"))
        this.speedLimit = Float.parseFloat(split[1]); 
      if (split[0].equals("accelBonus"))
        this.accelBonus = Float.parseFloat(split[1]); 
      if (split[0].equals("gravityMultiplier"))
        this.gravityMultiplier = Float.parseFloat(split[1]); 
      if (split[0].equals("highAltMax"))
        this.speedLimitHigh = Float.parseFloat(split[1]); 
      if (split[0].equals("maxSpeedDry"))
        this.speedLimitDry = Float.parseFloat(split[1]); 
      if (split[0].equals("highAltMaxDry"))
        this.speedLimitHighDry = Float.parseFloat(split[1]); 
      if (split[0].equals("planeDiveFactor"))
        this.planeDiveFactor = Float.parseFloat(split[1]); 
      if (split[0].equals("carrierLandable"))
        this.carrierLandable = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("helipadLandable"))
        this.helipadLandable = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("gunRecoil"))
        this.gunRecoil = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("unpunchable"))
        this.unpunchable = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("mass"))
        this.mass = Float.parseFloat(split[1]); 
      if (split[0].equals("cruiseSpeed"))
        this.cruiseSpeed = Float.parseFloat(split[1]); 
      if (split[0].equals("takeoffSpeed"))
        this.takeoffSpeed = Float.parseFloat(split[1]); 
      if (split[0].equals("climbRate"))
        this.climbRate = 0.17F * Float.parseFloat(split[1]); 
      if (split[0].equals("maximumSpeed"))
        this.maxSpeed = Float.parseFloat(split[1]); 
      if (split[0].equals("turnTime"))
        this.turnTime = 0.5F * Float.parseFloat(split[1]); 
      if (split[0].equals("swapInitialWing"))
        this.swapInitialWing = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("missileVisible"))
        this.missileVisible = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("missileWingSpan"))
        this.missileWingSpan = Float.parseFloat(split[1]); 
      if (split[0].equals("missileForward"))
        this.missileForward = Float.parseFloat(split[1]); 
      if (split[0].equals("missileElevation"))
        this.missileElevation = Float.parseFloat(split[1]); 
      if (split[0].equals("heliSpeedLimit"))
        this.speedLimit = Float.parseFloat(split[1]); 
      if (split[0].equals("Propeller")) {
        Propeller propeller = new Propeller(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), EnumDriveablePart.getPart(split[5]), PartType.getPart(split[6]));
        this.propellers.add(propeller);
        this.driveableRecipe.add(new ItemStack(propeller.itemType.item));
      } 
      if (split[0].equals("HeliPropeller")) {
        Propeller propeller = new Propeller(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), EnumDriveablePart.getPart(split[5]), PartType.getPart(split[6]));
        this.heliPropellers.add(propeller);
        this.driveableRecipe.add(new ItemStack(propeller.itemType.item));
      } 
      if (split[0].equals("HeliTailPropeller")) {
        Propeller propeller = new Propeller(Integer.parseInt(split[1]), Integer.parseInt(split[2]), Integer.parseInt(split[3]), Integer.parseInt(split[4]), EnumDriveablePart.getPart(split[5]), PartType.getPart(split[6]));
        this.heliTailPropellers.add(propeller);
        this.driveableRecipe.add(new ItemStack(propeller.itemType.item));
      } 
      if (split[0].equals("HasFlare"))
        this.hasFlare = split[1].equals("True"); 
      if (split[0].equals("FlareDelay")) {
        this.flareDelay = Integer.parseInt(split[1]);
        if (this.flareDelay <= 0)
          this.flareDelay = 1; 
      } 
      if (split[0].equals("TimeFlareUsing")) {
        this.timeFlareUsing = Integer.parseInt(split[1]);
        if (this.timeFlareUsing <= 0)
          this.timeFlareUsing = 1; 
      } 
      if (split[0].equals("PropSoundLength"))
        this.engineSoundLength = Integer.parseInt(split[1]); 
      if (split[0].equals("PropSound")) {
        this.engineSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } 
      if (split[0].equals("ShootSound")) {
        this.shootSoundPrimary = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } 
      if (split[0].equals("BombSound")) {
        this.shootSoundSecondary = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } 
      if (split[0].equals("HasGear"))
        this.hasGear = split[1].equals("True"); 
      if (split[0].equals("HasDoor"))
        this.hasDoor = split[1].equals("True"); 
      if (split[0].equals("HasWing"))
        this.hasWing = split[1].equals("True"); 
      if (split[0].equals("FoldWingForLand"))
        this.foldWingForLand = split[1].equals("True"); 
      if (split[0].equals("FlyWithOpenDoor"))
        this.flyWithOpenDoor = split[1].equals("True"); 
      if (split[0].equals("RestingPitch"))
        this.restingPitch = Float.parseFloat(split[1]); 
      if (split[0].equals("SpinWithoutTail"))
        this.spinWithoutTail = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("Valkyrie"))
        this.valkyrie = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("AfterburnWing"))
        this.AfterburnWing = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("AfterburnWingFlipped"))
        this.AfterburnWingFlipped = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("carrierWingFlip"))
        this.carrierWingFlip = Boolean.parseBoolean(split[1]); 
      if (split[0].equals("WingPosition1"))
        this.wingPos1 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingPosition2"))
        this.wingPos2 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingRotation1"))
        this.wingRot1 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingRotation2"))
        this.wingRot2 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingRate"))
        this.wingRate = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingRotRate"))
        this.wingRotRate = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingWheelPosition1"))
        this.wingWheelPos1 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingWheelPosition2"))
        this.wingWheelPos2 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingWheelRotation1"))
        this.wingWheelRot1 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingWheelRotation2"))
        this.wingWheelRot2 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingWheelRate"))
        this.wingWheelRate = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("WingWheelRotRate"))
        this.wingWheelRotRate = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("BodyWheelPosition1"))
        this.bodyWheelPos1 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("BodyWheelPosition2"))
        this.bodyWheelPos2 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("BodyWheelRotation1"))
        this.bodyWheelRot1 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("BodyWheelRotation2"))
        this.bodyWheelRot2 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("BodyWheelRate"))
        this.bodyWheelRate = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("BodyWheelRotRate"))
        this.bodyWheelRotRate = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("overheatLimit")) {
        this.overheatLimit = Integer.parseInt(split[1]);
      } else {
        this.overheatLimit = 750;
      } 
      if (split[0].equals("overheatPenalty")) {
        this.overheatPenalty = Integer.parseInt(split[1]);
      } else {
        this.overheatPenalty = 240;
      } 
      if (split[0].equals("coolingBonus")) {
        this.coolingBonus = Integer.parseInt(split[1]);
      } else {
        this.coolingBonus = 4;
      } 
      if (split[0].equals("TailWheelPosition1"))
        this.tailWheelPos1 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("TailWheelPosition2"))
        this.tailWheelPos2 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("TailWheelRotation1"))
        this.tailWheelRot1 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("TailWheelRotation2"))
        this.tailWheelRot2 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("TailWheelRate"))
        this.tailWheelRate = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("TailWheelRotRate"))
        this.tailWheelRotRate = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("DoorPosition1"))
        this.doorPos1 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("DoorPosition2"))
        this.doorPos2 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("DoorRotation1"))
        this.doorRot1 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("DoorRotation2"))
        this.doorRot2 = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("DoorRate"))
        this.doorRate = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("DoorRotRate"))
        this.doorRotRate = new Vector3f(split[1], this.shortName); 
      if (split[0].equals("InflightInventory"))
        this.invInflight = split[1].equals("False"); 
    } catch (Exception exception) {}
  }
  
  public int numEngines() {
    switch (this.mode) {
      case VTOL:
        return Math.max(this.propellers.size(), this.heliPropellers.size());
      case PLANE:
        return this.propellers.size();
      case HELI:
        return this.heliPropellers.size();
    } 
    return 1;
  }
  
  public ArrayList<ItemStack> getItemsRequired(DriveablePart part, PartType engine) {
    ArrayList<ItemStack> stacks = super.getItemsRequired(part, engine);
    for (Propeller propeller : this.propellers) {
      if (propeller.planePart == part.type) {
        stacks.add(new ItemStack(propeller.itemType.item));
        stacks.add(new ItemStack(engine.item));
      } 
    } 
    return stacks;
  }
  
  public static PlaneType getPlane(String find) {
    for (PlaneType type : types) {
      if (type.shortName.equals(find))
        return type; 
    } 
    return null;
  }
  
  public void reloadModel() {
    this.model = (ModelDriveable)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelPlane.class);
  }
}
