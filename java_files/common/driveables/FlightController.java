package com.flansmod.common.driveables;

import com.flansmod.common.FlansMod;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketParticle;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.util.DamageSource;

public class FlightController {
  public boolean leftWing = true;
  
  public boolean rightWing = true;
  
  public boolean tail = true;
  
  public float throttle;
  
  public float yawControl;
  
  public float pitchControl;
  
  public float rollControl;
  
  public EnumPlaneMode mode;
  
  public float gravity = 1.0F;
  
  public float drag = 0.0F;
  
  public float dragerino = 5.0F;
  
  public float thrust = 0.0F;
  
  public float lift = 0.0F;
  
  public float V = 0.0F;
  
  public float T = 0.0F;
  
  public float Vh = 0.0F;
  
  public float stallMS = 0.0F;
  
  public float Lc = 0.0F;
  
  public float Lcc = 0.0F;
  
  public float speedBleedGrace = 0.0F;
  
  public Vector3f angularMomentum = new Vector3f(0.0F, 0.0F, 0.0F);
  
  private Object mounted;
  
  public float acceleration;
  
  public float doomsday = 0.0F;
  
  public void UpdateParams(EntityPlane plane) {
    this.throttle = plane.throttle;
    this.yawControl = plane.flapsYaw;
    this.pitchControl = (plane.flapsPitchLeft + plane.flapsPitchRight) / 2.0F;
    this.rollControl = (plane.flapsPitchRight - plane.flapsPitchLeft) / 2.0F;
    this.mode = plane.mode;
  }
  
  public void fly(EntityPlane plane) {
    PlaneType type = plane.getPlaneType();
    DriveableData data = plane.getDriveableData();
    UpdateParams(plane);
    SetAxes(plane);
    this.thrust = 0.01F * (0.85F + ((data.engine == null) ? 0.0F : 2.5F));
    this.stallMS = 0.44704F * type.takeoffSpeed;
    this.Lc = (float)(9.8D * type.mass / (this.stallMS * this.stallMS));
    this.Lcc = (float)(((this.Lc * 0.44704F * type.maxSpeed * 0.44704F * type.maxSpeed) - type.mass * 9.8D) / (type.climbRate * type.climbRate));
    this.gravity = 0.098000005F;
    switch (this.mode) {
      case PLANE:
        PlaneModeFly(plane);
      case HELI:
        HeliModeFly(plane);
        this.drag = 1.0F - 0.05F * type.drag;
        break;
    } 
  }
  
  public void SetAxes(EntityPlane plane) {
    PlaneType type = plane.getPlaneType();
    float labjacTickSpeed = (float)(1.0D * Math.exp(0.487708D * (this.V * 2.23694F / 767.0F)));
    float sensitivityAdjustYaw = (this.V * 2.23694F / type.maxSpeed / 1.2F > 0.5F) ? 0.5F : (this.V * 2.23694F / type.maxSpeed / 1.2F), f = sensitivityAdjustYaw;
    if (plane.mounted || this.V * 2.23694F < 20.0F)
      sensitivityAdjustYaw = 0.3F; 
    if (this.mode == EnumPlaneMode.HELI && this.throttle > 0.3D)
      sensitivityAdjustYaw = (this.throttle > 0.5F) ? (1.5F - this.throttle) : (4.0F * this.throttle - 1.0F); 
    float sensitivityAdjust = ((this.V * 2.23694F - type.takeoffSpeed) / 2.0F / (type.maxSpeed - type.takeoffSpeed) / 3.0F > 0.2F) ? 0.2F : ((this.V * 2.23694F - type.takeoffSpeed) / 2.0F / (type.maxSpeed - type.takeoffSpeed) / 3.0F), f3 = sensitivityAdjust;
    if (this.V * 2.23694F < type.takeoffSpeed)
      sensitivityAdjust = 0.0F; 
    if (this.mode == EnumPlaneMode.HELI) {
      this.drag = 1.0F - 0.05F * type.drag;
      float f1 = sensitivityAdjust = (this.throttle > 0.5F) ? (1.5F - this.throttle) : (4.0F * this.throttle - 1.0F);
    } 
    if ((float)plane.getSpeedXYZ() < 0.5D && sensitivityAdjust < -0.1F)
      sensitivityAdjust = 0.1F; 
    float rollerino = 0.0F;
    float pitcherino = 0.0F;
    if (type.turnTime > 0.0F) {
      pitcherino = (float)(7.754000186920166D * Math.exp((-0.464F * type.turnTime)));
      rollerino = (float)(7.754000186920166D * Math.exp((-0.464F * type.turnTime))) / 1.25F;
      System.out.println("pitcherino :" + pitcherino);
      if (rollerino <= 0.0F)
        rollerino = 0.01F; 
      if (pitcherino <= 0.0F)
        pitcherino = 0.01F; 
    } 
    float yaw = this.yawControl * ((this.yawControl > 0.0F) ? (type.turnLeftModifier * 1.0F) : (type.turnRightModifier * 1.0F)) * (sensitivityAdjustYaw *= 0.5F);
    float roll = this.rollControl * ((this.rollControl > 0.0F) ? (type.rollLeftModifier * 1.0F) : (type.rollRightModifier * 1.0F)) * sensitivityAdjust;
    float pitch = this.pitchControl * ((this.pitchControl > 0.0F) ? (type.lookUpModifier * 1.0F) : (type.lookDownModifier * 1.0F)) * sensitivityAdjust;
    if (type.turnTime > 0.0F) {
      yaw = this.yawControl * ((this.yawControl > 0.0F) ? 1.0F : 1.0F) * (sensitivityAdjustYaw *= 0.5F);
      roll = this.rollControl * ((this.rollControl > 0.0F) ? (rollerino * 1.0F) : (rollerino * 1.0F)) * sensitivityAdjust;
      pitch = this.pitchControl * ((this.pitchControl > 0.0F) ? (pitcherino * 1.0F) : (pitcherino * 1.0F)) * sensitivityAdjust;
    } 
    if (Math.abs(yaw) > 0.1F && this.V > 0.0F) {
      if (this.speedBleedGrace < 6.0F)
        this.speedBleedGrace += 0.02F; 
      this.V /= 1.0F + this.speedBleedGrace * this.V * this.V * Math.abs(yaw) / 0.7F * type.mass * type.mass;
    } else if (Math.abs(pitch) > 0.1F && this.V > 0.0F) {
      if (this.speedBleedGrace < 6.0F)
        this.speedBleedGrace += 0.02F; 
      this.V /= 1.0F + this.speedBleedGrace * this.V * this.V * Math.abs(pitch) / 0.7F * type.mass * type.mass;
    } else if (Math.abs(roll) > 0.1F && this.V > 0.0F) {
      if (this.speedBleedGrace < 6.0F)
        this.speedBleedGrace += 0.02F; 
      this.V /= 1.0F + this.speedBleedGrace * this.V * this.V * Math.abs(roll) / 0.7F * type.mass * type.mass;
    } else if (this.speedBleedGrace > 0.0F) {
      this.speedBleedGrace *= 0.95F;
    } 
    if (plane.axes.getPitch() < 0.0F && plane.field_70163_u > (type.ceiling - 10.0F))
      plane.axes.rotateLocalPitch(-1.0F); 
    if (this.mode == EnumPlaneMode.PLANE) {
      if (!plane.isPartIntact(EnumDriveablePart.tail) && 
        plane.func_70090_H())
        plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F); 
      if (!plane.isPartIntact(EnumDriveablePart.nose))
        if (plane.func_70090_H())
          plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F);  
      if (!plane.isPartIntact(EnumDriveablePart.tail))
        if (plane.func_70090_H())
          plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F);  
      if (!plane.isPartIntact(EnumDriveablePart.leftWing))
        if (plane.func_70090_H())
          plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F);  
      if (!plane.isPartIntact(EnumDriveablePart.rightWing))
        if (plane.func_70090_H())
          plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F);  
    } else if (this.mode == EnumPlaneMode.HELI && !plane.isPartIntact(EnumDriveablePart.tail)) {
      yaw = 25.0F * this.throttle;
      roll = 5.0F * this.throttle;
      plane.field_70181_x += -this.gravity;
      if (plane.func_70090_H())
        plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F); 
    } 
    this.angularMomentum.x = moveToTarget(this.angularMomentum.x, yaw, 1.0F);
    this.angularMomentum.y = moveToTarget(this.angularMomentum.y, pitch, 1.0F);
    this.angularMomentum.z = moveToTarget(this.angularMomentum.z, roll, 1.0F);
    LimitAngularMomentum(this.angularMomentum, 20.0F);
    plane.axes.rotateLocalYaw(this.angularMomentum.x);
    plane.axes.rotateLocalPitch(this.angularMomentum.y);
    plane.axes.rotateLocalRoll(-this.angularMomentum.z);
    this.angularMomentum.scale(0.99F);
  }
  
  public float moveToTarget(float current, float target, float speed) {
    float pitchToMove;
    for (pitchToMove = (float)(Math.sqrt((target * target)) - Math.sqrt((current * current))); pitchToMove > 180.0F; pitchToMove -= 360.0F);
    while (pitchToMove <= -180.0F)
      pitchToMove += 360.0F; 
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
  
  public void LimitAngularMomentum(Vector3f vec, float angle) {
    if (vec.x > angle)
      vec.x = angle; 
    if (vec.x < -angle)
      vec.x = -angle; 
    if (vec.y > angle)
      vec.y = angle; 
    if (vec.y < -angle)
      vec.y = -angle; 
    if (vec.z > angle)
      vec.z = angle; 
    if (vec.z < -angle)
      vec.z = -angle; 
  }
  
  public void PlaneModeFly(EntityPlane plane) {
    if (plane.mode == EnumPlaneMode.HELI)
      return; 
    PlaneType type = plane.getPlaneType();
    DriveableData data = plane.getDriveableData();
    int numPropsWorking = 0;
    int numProps = 0;
    float flap = this.angularMomentum.length();
    this.drag -= flap / 100.0F;
    this.throttle -= -flap / 500.0F;
    for (Propeller prop : type.propellers) {
      if (!plane.isPartIntact(prop.planePart))
        continue; 
      numPropsWorking++;
    } 
    numProps = type.propellers.size();
    if (numProps == 0)
      return; 
    Vector3f forwards = (Vector3f)plane.axes.getXAxis().normalise();
    float lastTickSpeed = (float)plane.getSpeedXYZ();
    float currentSpeedLimit = 1.0F;
    if (lastTickSpeed < 0.0F && this.V > 0.0F)
      lastTickSpeed = 0.0F; 
    if (this.V * 2.23694F > 80.0F && Math.abs(forwards.y) > 0.15F) {
      float mcSpeed = (float)(1.0D * Math.exp(0.487708D * (this.V * 2.23694F / 767.0F)));
      if (lastTickSpeed < mcSpeed) {
        lastTickSpeed += 0.75F * (mcSpeed - lastTickSpeed);
      } else if (lastTickSpeed > mcSpeed) {
        lastTickSpeed -= 0.75F * (lastTickSpeed - mcSpeed);
      } 
    } 
    if (plane.axes.getRoll() > 0.1F)
      plane.axes.rotateLocalRoll(-0.3F); 
    if (plane.axes.getRoll() < -0.1F)
      plane.axes.rotateLocalRoll(0.3F); 
    if (plane.axes.getPitch() > 0.01D && (plane.axes.getPitch() < 5.0F || plane.mounted))
      plane.axes.rotateLocalPitch(0.1F); 
    if (plane.axes.getPitch() < 0.0F && (plane.axes.getPitch() > -5.0F || plane.mounted))
      plane.axes.rotateLocalPitch(-0.1F); 
    if (plane.axes.getPitch() < -1.0F && this.V * 2.23694F < type.takeoffSpeed * 1.2F)
      plane.axes.rotateLocalPitch(-0.4F); 
    float newSpeed = lastTickSpeed + this.thrust * 2.0F;
    if (this.acceleration < 1.0F && this.V > -0.1F)
      this.acceleration += plane.throttle * 74.0F / 10.0F * type.mass - this.acceleration * 74.0F / 10.0F * type.mass; 
    if (this.V <= -0.1F && this.V > -1.01F) {
      this.acceleration = this.V / 1.01F;
    } else if (this.V <= -1.01F) {
      this.acceleration = -1.0F;
    } 
    if (this.acceleration > 1.0F)
      this.acceleration = 1.0F; 
    if ((plane.seats[0] != null && (plane.seats[0]).field_70153_n == null && plane.throttle < 0.05F) || (plane.field_70173_aa < 140 && this.throttle < 0.05F)) {
      this.acceleration = 0.0F;
      this.V = 0.0F;
      this.T = 0.0F;
    } 
    if (plane.throttle < 0.05F && this.V < 0.0F)
      this.acceleration *= 0.95F; 
    float maxMS = 0.44704F * type.maxSpeed;
    float trueDrag = this.V * this.V;
    float diveAngle = 0.0F;
    float trueRoll = Math.abs(plane.axes.getRoll());
    if (plane.axes.getPitch() > 0.0F)
      if (trueRoll <= 90.0F) {
        diveAngle = plane.axes.getPitch() / 90.0F * (1.0F - trueRoll / 90.0F);
      } else if (trueRoll > 90.0F && trueRoll < 180.0F) {
        diveAngle = plane.axes.getPitch() / 90.0F * (trueRoll - 90.0F) / 90.0F;
      }  
    if (plane.field_70173_aa == 20) {
      if (plane.varFlap)
        plane.varFlap = !plane.varFlap; 
      if (!(plane.getDriveableData()).emergencyMode) {
        this.V = 0.0F;
        this.acceleration = 0.0F;
        plane.throttle = 0.0F;
      } 
    } 
    if (plane.varGear)
      trueDrag = 1.8F * this.V * this.V; 
    if (plane.varFlap)
      trueDrag = 3.5F * this.V * this.V; 
    if (plane.varFlap && plane.varGear)
      trueDrag = 6.0F * this.V * this.V; 
    float maxAccel = maxMS * maxMS;
    float catapultBonus = 0.0F;
    if (plane.driveableData.catapult > 0) {
      catapultBonus = 3.0F;
    } else {
      catapultBonus = 0.0F;
    } 
    if (type.hasAfterBurner && !plane.afterBurning && type.cruiseSpeed == 610.0F)
      maxAccel = 74529.0F; 
    if (type.cruiseSpeed != 610.0F && !plane.afterBurning && type.hasAfterBurner)
      maxAccel = type.cruiseSpeed * 0.44704F * type.cruiseSpeed * 0.44704F; 
    this.T = this.throttle * maxAccel - trueDrag;
    if (this.V < 0.0F)
      this.T = this.throttle * maxAccel + trueDrag; 
    this.lift = ((1.0F - Math.abs(forwards.y)) * this.V * this.V - this.stallMS * this.stallMS) / this.stallMS * this.stallMS;
    if (this.lift > type.climbRate)
      this.lift = type.climbRate; 
    if (this.lift < -15.0F)
      this.lift = -15.0F; 
    float VhMPH = this.Vh * 2.23694F;
    float DeltaVh = VhMPH / 74.0F;
    if (DeltaVh > 0.9F)
      DeltaVh = 0.9F; 
    float Vmph = this.V * 2.23694F;
    float bonusFactor = 0.0F;
    if (Vmph < type.maxSpeed && Vmph > 0.0F && (plane.afterBurning || !(plane.getDriveableType()).hasAfterBurner)) {
      bonusFactor = type.accelBonus * (1.0F - Vmph / type.maxSpeed);
    } else if (Vmph < type.cruiseSpeed && Vmph > 0.0F && !plane.afterBurning && (plane.getDriveableType()).hasAfterBurner) {
      bonusFactor = type.accelBonus * (1.0F - Vmph / type.cruiseSpeed);
    } 
    if (plane.planeRecoil > 0.0F || (plane.driveableData.catapult > 0 && plane.driveableData.catapult < 40)) {
      this.V += (this.T - plane.planeRecoil) / type.mass - forwards.y * 9.8F / 20.0F + catapultBonus / 20.0F;
      plane.planeRecoil = 0.0F;
    } else {
      this.V += (1.0F + bonusFactor) * (1.0F + bonusFactor) * this.T / type.mass * 20.0F - type.gravityMultiplier * forwards.y * 9.8F / 20.0F;
    } 
    if (!plane.field_70170_p.func_147437_c((int)plane.field_70165_t, (int)(plane.field_70163_u - 2.0D), (int)plane.field_70161_v) && this.throttle <= 0.2D && plane.driveableData.landBrake > 5 && this.V < 1.75F * type.takeoffSpeed) {
      this.V *= 0.965F;
      if (this.V > -5.0F && this.V < 5.0F) {
        this.acceleration = 0.0F;
        this.V *= 0.3F;
      } else {
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("cloud", plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK);
      } 
    } 
    if (!plane.field_70170_p.func_147437_c((int)plane.field_70165_t, (int)(plane.field_70163_u + 1.0D), (int)plane.field_70161_v) && plane.field_70170_p.func_72953_d(plane.field_70121_D)) {
      this.V *= 0.96F;
      if (this.V > -5.0F && this.V < 5.0F) {
        this.acceleration = 0.0F;
        this.V *= 0.3F;
      } 
    } 
    if (!plane.field_70170_p.func_147437_c((int)plane.field_70165_t, (int)(plane.field_70163_u - 2.0D), (int)plane.field_70161_v) && !plane.field_70170_p.func_147437_c((int)plane.field_70165_t, (int)(plane.field_70163_u - 2.0D), (int)plane.field_70161_v) && this.throttle <= 0.2D && !plane.varGear && !plane.field_70170_p.func_72953_d(plane.field_70121_D)) {
      this.V *= 0.975F;
      if (this.V > -5.0F && this.V < 5.0F) {
        this.acceleration = 0.0F;
        this.V *= 0.3F;
      } else {
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("cloud", plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK);
        FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("largeexplode", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK);
      } 
      if (this.V > 3.0F && plane.isPartIntact(EnumDriveablePart.airframe)) {
        float hullDamage = 1.0F + 2.5E-4F * ((DriveablePart)(plane.getDriveableData()).parts.get(EnumDriveablePart.airframe)).maxHealth;
        plane.attackPart(EnumDriveablePart.airframe, DamageSource.field_76367_g, hullDamage);
      } 
    } 
    if (Vmph > type.maxSpeed) {
      plane.axes.rotateLocalPitch((Vmph - type.maxSpeed) / type.maxSpeed / 20.0F * ((float)Math.random() - 0.5F) / 4.0F);
      plane.axes.rotateLocalYaw((Vmph - type.maxSpeed) / type.maxSpeed / 20.0F * ((float)Math.random() - 0.5F) / 4.0F);
      plane.axes.rotateLocalRoll((Vmph - type.maxSpeed) / type.maxSpeed / 20.0F * ((float)Math.random() - 0.5F) / 4.0F);
    } 
    if (Vmph <= 76.0F && Vmph >= 0.0F) {
      this.dragerino = (float)(5.255000114440918D - 0.088D * Vmph + 5.0E-4D * (Vmph * Vmph));
    } else if (Vmph > 76.0F) {
      this.dragerino = 1.508F * (float)Math.exp((-5.5E-4F * Math.abs(Vmph)));
    } else {
      this.dragerino = 5.0F;
    } 
    this.drag = 1.0F - 0.05F * this.dragerino;
    if (this.mode == EnumPlaneMode.HELI)
      this.drag = 1.0F - 0.05F * type.drag; 
    float proportionOfMotionToCorrect = 2.0F * this.acceleration;
    if (proportionOfMotionToCorrect < -1.0F)
      proportionOfMotionToCorrect = -1.0F; 
    if (proportionOfMotionToCorrect > 1.5F)
      proportionOfMotionToCorrect = 1.5F; 
    int numWingsIntact = 0;
    if (plane.isPartIntact(EnumDriveablePart.airframe))
      numWingsIntact++; 
    plane.field_70159_w *= (1.0F - Math.abs(proportionOfMotionToCorrect));
    plane.field_70181_x *= (1.0F - Math.abs(proportionOfMotionToCorrect));
    plane.field_70179_y *= (1.0F - Math.abs(proportionOfMotionToCorrect));
    if (this.V > 0.0F) {
      plane.field_70159_w += (proportionOfMotionToCorrect * newSpeed * forwards.x);
      plane.field_70181_x += (proportionOfMotionToCorrect * newSpeed * forwards.y);
      plane.field_70179_y += (proportionOfMotionToCorrect * newSpeed * forwards.z);
    } 
    if (this.lift >= 0.0F && this.doomsday < 1.0F) {
      plane.field_70181_x += (this.lift / 1480.0F);
    } else if (plane.field_70170_p.func_147437_c((int)plane.field_70165_t, (int)(plane.field_70163_u - 2.0D), (int)plane.field_70161_v)) {
      plane.field_70181_x += (this.lift / 1480.0F) + 0.13243243243243244D * this.lift - (this.doomsday / 300.0F);
    } 
    if (plane.driveableData.catapult > 0 && plane.field_70181_x < 0.0D)
      plane.field_70181_x = 0.009999999776482582D; 
    if (plane.field_70163_u > type.ceiling)
      plane.field_70181_x = -0.1D; 
    if ((plane.getDriveableData()).emergencyMode) {
      plane.field_70181_x = 0.009999999776482582D;
      plane.field_70159_w = 0.0D;
      plane.field_70179_y = 0.0D;
      this.V = 0.89F * 0.44704F * type.maxSpeed;
    } 
    if (this.V > 0.0F && plane.mounted)
      this.V *= 0.9F; 
    if (!plane.isPartIntact(EnumDriveablePart.airframe)) {
      plane.field_70181_x += -this.gravity;
      this.lift = -9.8F;
      plane.throttle = 0.0F;
      if (plane.axes.getRoll() > 0.1F)
        plane.axes.rotateLocalRoll(-5.0F); 
      if (plane.axes.getRoll() < -0.1F)
        plane.axes.rotateLocalRoll(5.0F); 
      this.doomsday++;
      if (plane.axes.getPitch() < 35.0F)
        plane.axes.rotateLocalPitch(-0.05F * this.doomsday); 
      if (plane.func_70090_H())
        plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F); 
    } 
    plane.field_70159_w *= this.drag;
    plane.field_70179_y *= this.drag;
    plane.lastPos = new Vector3f(plane.field_70159_w, plane.field_70181_x, plane.field_70179_y);
    if (!plane.isPartIntact(EnumDriveablePart.tail)) {
      plane.field_70181_x += -this.gravity;
      this.lift *= 0.8F;
      this.lift = (float)(this.lift - 1.960000029206276D);
      this.tail = false;
      if (this.doomsday < 750.0F)
        this.doomsday++; 
      if (this.doomsday >= 750.0F)
        plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F); 
      plane.axes.rotateLocalPitch(type.lookUpModifier * this.doomsday / this.doomsday / 2.0F);
      if (plane.func_70090_H())
        plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F); 
    } 
    if (!plane.isPartIntact(EnumDriveablePart.leftWing)) {
      plane.field_70181_x += -this.gravity;
      this.leftWing = false;
      if (this.doomsday < 750.0F)
        this.doomsday++; 
      if (this.doomsday >= 750.0F)
        plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F); 
      plane.axes.rotateLocalRoll(type.rollRightModifier * this.doomsday / this.doomsday / 10.0F);
      if (plane.func_70090_H())
        plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F); 
    } 
    if (!plane.isPartIntact(EnumDriveablePart.rightWing)) {
      plane.field_70181_x += -this.gravity;
      this.rightWing = false;
      if (this.doomsday < 750.0F)
        this.doomsday++; 
      if (this.doomsday >= 750.0F)
        plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F); 
      plane.axes.rotateLocalRoll(-type.rollLeftModifier * this.doomsday / this.doomsday / 15.0F);
      if (plane.func_70090_H())
        plane.attackPart(EnumDriveablePart.core, DamageSource.field_76367_g, 10.0F); 
    } 
    if (this.doomsday >= 100.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("largeexplode", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday >= 100.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("largesmoke", plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday >= 20.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flame", plane.field_70165_t, plane.field_70163_u, plane.field_70161_v + 1.0D, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday >= 20.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flame", plane.field_70165_t, plane.field_70163_u + 3.0D, plane.field_70161_v - 0.7D, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday >= 20.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flame", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v + 1.3D, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday >= 100.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("largesmoke", plane.field_70165_t, plane.field_70163_u + 1.5D, plane.field_70161_v + 0.5D, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday >= 100.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flame", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v - 0.5D, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday >= 100.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flame", plane.field_70165_t, plane.field_70163_u, plane.field_70161_v + 0.5D, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday >= 100.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flame", plane.field_70165_t, plane.field_70163_u - 0.5D, plane.field_70161_v - 2.0D, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday >= 100.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.fmflame", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday == 5.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("hugeexplosion", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday == 18.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("largeexplode", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday == 30.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("largeexplode", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday == 100.0F)
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("hugeexplosion", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday == 700.0F && (!this.leftWing || !this.tail || !this.rightWing))
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("hugeexplosion", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday == 720.0F && (!this.leftWing || !this.tail || !this.rightWing))
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("hugeexplosion", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday == 725.0F && (!this.leftWing || !this.tail || !this.rightWing))
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("hugeexplosion", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday == 740.0F && (!this.leftWing || !this.tail || !this.rightWing))
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("hugeexplosion", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
    if (this.doomsday == 748.0F && (!this.leftWing || !this.tail || !this.rightWing))
      FlansMod.getPacketHandler().sendToAllAround((PacketBase)new PacketParticle("flansmod.tankDeath", plane.field_70165_t, plane.field_70163_u + 1.0D, plane.field_70161_v, 0.0D, 0.0D, 0.0D), plane.field_70165_t, plane.field_70163_u, plane.field_70161_v, 150.0F, plane.field_71093_bK); 
  }
  
  public void HeliModeFly(EntityPlane plane) {
    PlaneType type = plane.getPlaneType();
    this.drag = 1.0F - 0.05F * type.drag;
    DriveableData data = plane.getDriveableData();
    int numPropsWorking = 0;
    int numProps = 0;
    for (Propeller prop : type.heliPropellers) {
      if (!plane.isPartIntact(prop.planePart))
        continue; 
      numPropsWorking++;
    } 
    numProps = type.heliPropellers.size();
    this.gravity = 0.05F;
    if (numProps == 0)
      return; 
    Vector3f up = (Vector3f)plane.axes.getYAxis().normalise();
    this.thrust *= (numPropsWorking / numProps) * 2.0F;
    float upwardsForce = this.throttle * this.thrust + this.gravity - this.thrust / 2.0F;
    if (this.throttle < 0.5F)
      upwardsForce = this.gravity * this.throttle * 2.0F; 
    if (!plane.isPartIntact(EnumDriveablePart.blades))
      upwardsForce = 0.04F; 
    if (this.throttle < 0.52F && this.throttle > 0.48F && up.y >= 0.7F)
      upwardsForce = this.gravity / up.y; 
    if ((plane.getPlaneType()).mode != EnumPlaneMode.VTOL && up.y < 0.0F) {
      up.y *= -1.0F;
      up.x *= -1.0F;
      up.z *= -1.0F;
    } 
    if (plane.field_70159_w < 1.0D)
      plane.field_70159_w += (upwardsForce * up.x * 0.5F); 
    if (plane.field_70181_x < 1.0D)
      plane.field_70181_x += (upwardsForce * up.y - this.gravity); 
    if (plane.field_70179_y < 1.0D)
      plane.field_70179_y += (upwardsForce * up.z * 0.5F); 
    if (plane.field_70181_x >= 1.0D)
      upwardsForce = 0.04F; 
    if (plane.field_70159_w >= 1.0D)
      upwardsForce = 0.04F; 
    if (plane.field_70179_y >= 1.0D)
      upwardsForce = 0.04F; 
    if (plane.field_70163_u > type.ceiling)
      plane.field_70181_x = -0.1D; 
    plane.field_70159_w *= (1.0F - (1.0F - this.drag) / 5.0F);
    plane.field_70181_x *= this.drag;
    plane.field_70179_y *= (1.0F - (1.0F - this.drag) / 5.0F);
    plane.lastPos = new Vector3f(plane.field_70159_w, plane.field_70181_x, plane.field_70179_y);
  }
}
