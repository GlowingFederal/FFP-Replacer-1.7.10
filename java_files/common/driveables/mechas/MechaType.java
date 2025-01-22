package com.flansmod.common.driveables.mechas;

import com.flansmod.client.model.ModelDriveable;
import com.flansmod.client.model.ModelMecha;
import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePosition;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.types.TypeFile;
import com.flansmod.common.vector.Vector3f;
import java.util.ArrayList;
import java.util.List;

public class MechaType extends DriveableType {
  public float turnLeftModifier = 1.0F;
  
  public float turnRightModifier = 1.0F;
  
  public float moveSpeed = 1.0F;
  
  public boolean squashMobs = false;
  
  public int stepHeight = 0;
  
  public float jumpHeight = 1.0F;
  
  public float jumpVelocity = 1.0F;
  
  public float rotateSpeed = 10.0F;
  
  public Vector3f leftArmOrigin;
  
  public Vector3f rightArmOrigin;
  
  public float armLength = 1.0F, legLength = 1.0F;
  
  public float heldItemScale = 1.0F;
  
  public float height = 3.0F, width = 2.0F;
  
  public float chassisHeight = 1.0F;
  
  public boolean isValidGun(GunType gunType) {
    return (this.acceptAllGuns || this.allowedGuns.contains(gunType));
  }
  
  public String panicSound = "";
  
  public String runAmokSound = "";
  
  public float morale = 1.0F;
  
  public int panicTime = 40;
  
  public float reach = 10.0F;
  
  public boolean damageBlocksFromFalling = true;
  
  public float blockDamageFromFalling = 1.0F;
  
  public boolean takeFallDamage = true;
  
  public float fallDamageMultiplier = 1.0F;
  
  public float legSwingLimit = 2.0F;
  
  public boolean limitHeadTurn = false;
  
  public float limitHeadTurnValue = 90.0F;
  
  public float legSwingTime = 5.0F;
  
  public float upperArmLimit = 90.0F;
  
  public float lowerArmLimit = 90.0F;
  
  public float leftHandModifierX = 0.0F;
  
  public float leftHandModifierY = 0.0F;
  
  public float leftHandModifierZ = 0.0F;
  
  public float rightHandModifierX = 0.0F;
  
  public float rightHandModifierY = 0.0F;
  
  public float rightHandModifierZ = 0.0F;
  
  public ArrayList<LegNode> legNodes = new ArrayList<>();
  
  public float legAnimSpeed = 0.0F;
  
  public String stompSound = "";
  
  public int stompSoundLength = 0;
  
  public float stompRangeLower = 0.0F;
  
  public float stompRangeUpper = 0.0F;
  
  public static ArrayList<MechaType> types = new ArrayList<>();
  
  public boolean acceptAllGuns;
  
  public List<GunType> allowedGuns;
  
  public boolean unpunchable;
  
  public boolean restrictInventoryInput;
  
  public MechaType(TypeFile file) {
    super(file);
    this.acceptAllGuns = true;
    this.allowedGuns = new ArrayList<>();
    this.unpunchable = false;
    types.add(this);
  }
  
  protected void read(String[] split, TypeFile file) {
    super.read(split, file);
    try {
      if (split[0].equals("TurnLeftSpeed"))
        this.turnLeftModifier = Float.parseFloat(split[1]); 
      if (split[0].equals("TurnRightSpeed"))
        this.turnRightModifier = Float.parseFloat(split[1]); 
      if (split[0].equals("MoveSpeed"))
        this.moveSpeed = Float.parseFloat(split[1]); 
      if (split[0].equals("SquashMobs"))
        this.squashMobs = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("StepHeight"))
        this.stepHeight = Integer.parseInt(split[1]); 
      if (split[0].equals("JumpHeight")) {
        this.jumpHeight = Float.parseFloat(split[1]);
        this.jumpVelocity = (float)Math.sqrt(Math.abs(9.81F * (this.jumpHeight + 0.2F) / 200.0F));
      } 
      if (split[0].equals("RotateSpeed")) {
        this.rotateSpeed = Float.parseFloat(split[1]);
      } else if (split[0].equals("StompSound")) {
        this.stompSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("StompSoundLength")) {
        this.stompSoundLength = Integer.parseInt(split[1]);
      } else if (split[0].equals("StompRangeLower")) {
        this.stompRangeLower = Float.parseFloat(split[1]);
      } else if (split[0].equals("StompRangeUpper")) {
        this.stompRangeUpper = Float.parseFloat(split[1]);
      } else if (split[0].equals("RestrictInventoryInput")) {
        this.restrictInventoryInput = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("AddGun")) {
        this.allowedGuns.add(GunType.getGunForMech(split[1]));
      } else if (split[0].equals("AllowAllGuns") || split[0].equals("AcceptAllGuns")) {
        this.acceptAllGuns = Boolean.parseBoolean(split[1]);
      } else if (split[0].equals("panicSound")) {
        this.panicSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("runAmokSound")) {
        this.runAmokSound = split[1];
        FlansMod.proxy.loadSound(this.contentPack, "driveables", split[1]);
      } else if (split[0].equals("morale")) {
        this.morale = Float.parseFloat(split[1]);
      } else if (split[0].equals("panicTime")) {
        this.panicTime = Integer.parseInt(split[1]);
      } 
      if (split[0].equals("unpunchable"))
        this.unpunchable = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("LeftArmOrigin"))
        this.leftArmOrigin = new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F); 
      if (split[0].equals("RightArmOrigin"))
        this.rightArmOrigin = new Vector3f(Float.parseFloat(split[1]) / 16.0F, Float.parseFloat(split[2]) / 16.0F, Float.parseFloat(split[3]) / 16.0F); 
      if (split[0].equals("ArmLength"))
        this.armLength = Float.parseFloat(split[1]) / 16.0F; 
      if (split[0].equals("LegLength"))
        this.legLength = Float.parseFloat(split[1]) / 16.0F; 
      if (split[0].equals("HeldItemScale"))
        this.heldItemScale = Float.parseFloat(split[1]); 
      if (split[0].equals("Height"))
        this.height = Float.parseFloat(split[1]) / 16.0F; 
      if (split[0].equals("Width"))
        this.width = Float.parseFloat(split[1]) / 16.0F; 
      if (split[0].equals("ChassisHeight"))
        this.chassisHeight = Integer.parseInt(split[1]) / 16.0F; 
      if (split[0].equals("FallDamageMultiplier"))
        this.fallDamageMultiplier = Float.parseFloat(split[1]); 
      if (split[0].equals("BlockDamageFromFalling"))
        this.blockDamageFromFalling = Float.parseFloat(split[1]); 
      if (split[0].equals("Reach"))
        this.reach = Float.parseFloat(split[1]); 
      if (split[0].equals("TakeFallDamage"))
        this.takeFallDamage = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("DamageBlocksFromFalling"))
        this.damageBlocksFromFalling = Boolean.parseBoolean(split[1].toLowerCase()); 
      if (split[0].equals("LegSwingLimit"))
        this.legSwingLimit = Float.parseFloat(split[1]); 
      if (split[0].equals("LimitHeadTurn")) {
        this.limitHeadTurn = Boolean.parseBoolean(split[1].toLowerCase());
        this.limitHeadTurnValue = Float.parseFloat(split[2]);
      } 
      if (split[0].equals("LegSwingTime"))
        this.legSwingTime = Float.parseFloat(split[1]); 
      if (split[0].equals("UpperArmLimit"))
        this.upperArmLimit = Float.parseFloat(split[1]); 
      if (split[0].equals("LowerArmLimit"))
        this.lowerArmLimit = Float.parseFloat(split[1]); 
      if (split[0].equals("LeftHandModifier")) {
        this.leftHandModifierX = Float.parseFloat(split[1]) / 16.0F;
        this.leftHandModifierY = Float.parseFloat(split[2]) / 16.0F;
        this.leftHandModifierZ = Float.parseFloat(split[3]) / 16.0F;
      } 
      if (split[0].equals("RightHandModifier")) {
        this.rightHandModifierX = Float.parseFloat(split[1]) / 16.0F;
        this.rightHandModifierY = Float.parseFloat(split[2]) / 16.0F;
        this.rightHandModifierZ = Float.parseFloat(split[3]) / 16.0F;
      } else if (split[0].equals("LegNode")) {
        LegNode node = new LegNode();
        node.rotation = Integer.parseInt(split[1]);
        node.lowerBound = Float.parseFloat(split[2]);
        node.upperBound = Float.parseFloat(split[3]);
        node.speed = Integer.parseInt(split[4]);
        node.legPart = Integer.parseInt(split[5]);
        this.legNodes.add(node);
      } else if (split[0].equals("LegAnimSpeed")) {
        this.legAnimSpeed = Float.parseFloat(split[1]);
      } 
    } catch (Exception exception) {}
  }
  
  public void reloadModel() {
    this.model = (ModelDriveable)FlansMod.proxy.loadModel(this.modelString, this.shortName, ModelMecha.class);
  }
  
  private DriveablePosition getShootPoint(String[] split) {
    if (split.length == 5)
      return new DriveablePosition(split); 
    return new DriveablePosition(new Vector3f(), EnumDriveablePart.core);
  }
  
  public static MechaType getMecha(String find) {
    for (MechaType type : types) {
      if (type.shortName.equals(find))
        return type; 
    } 
    return null;
  }
  
  public class LegNode {
    public int rotation;
    
    public float lowerBound;
    
    public float upperBound;
    
    public int speed;
    
    public int legPart;
  }
}
