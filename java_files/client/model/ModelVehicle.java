package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.RotatedAxes;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EntityVehicle;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.VehicleType;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.AdvancedModelLoader;
import net.minecraftforge.client.model.IModelCustom;
import org.lwjgl.opengl.GL11;

public class ModelVehicle extends ModelDriveable {
  public ModelRendererTurbo[] turretModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] barrelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[][] ammoModel = new ModelRendererTurbo[0][0];
  
  public ModelRendererTurbo[] frontWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] backWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftFrontWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightFrontWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftBackWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightBackWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightTrackModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftTrackModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightTrackWheelModels = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftTrackWheelModels = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[][] leftAnimTrackModel = new ModelRendererTurbo[0][0];
  
  public ModelRendererTurbo[][] rightAnimTrackModel = new ModelRendererTurbo[0][0];
  
  public ModelRendererTurbo[] fancyTrackModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightAnimTrackModel1 = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftAnimTrackModel1 = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightAnimTrackModel2 = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftAnimTrackModel2 = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightAnimTrackModel3 = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftAnimTrackModel3 = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] bodyDoorOpenModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] bodyDoorCloseModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] trailerModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] steeringWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] drillHeadModel = new ModelRendererTurbo[0];
  
  public Vector3f drillHeadOrigin = new Vector3f();
  
  public ModelRendererTurbo[] barrelSpecModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] animBarrelModel = new ModelRendererTurbo[0];
  
  public Vector3f barrelAttach = new Vector3f();
  
  public ModelRendererTurbo[] doorAnimModel = new ModelRendererTurbo[0];
  
  public Vector3f doorAttach = new Vector3f();
  
  public ModelRendererTurbo[] door2AnimModel = new ModelRendererTurbo[0];
  
  public Vector3f door2Attach = new Vector3f();
  
  public ModelRendererTurbo[] drakonModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] drakonReloadModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] drakonArmModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] drakonRailModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] drakonDoorModel = new ModelRendererTurbo[0];
  
  public Vector3f drakonArmAttach = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f drakonRailAttach = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public Vector3f drakonDoorAttach = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public float animFrameLeft = 0.0F;
  
  public float animFrameRight = 0.0F;
  
  public Vector3f turretScale = new Vector3f(1.0F, 1.0F, 1.0F);
  
  public Vector3f turretTrans = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public boolean fancyTurret = false;
  
  public String turretName;
  
  public void render(EntityDriveable driveable, float f1) {
    render(0.0625F, (EntityVehicle)driveable, f1);
  }
  
  public void render(DriveableType type) {
    super.render(type);
    renderPart(this.leftBackWheelModel);
    renderPart(this.rightBackWheelModel);
    renderPart(this.leftFrontWheelModel);
    renderPart(this.rightFrontWheelModel);
    renderPart(this.rightTrackModel);
    renderPart(this.leftTrackModel);
    renderPart(this.rightTrackWheelModels);
    renderPart(this.leftTrackWheelModels);
    renderPart(this.bodyDoorCloseModel);
    renderPart(this.trailerModel);
    GL11.glPushMatrix();
    GL11.glScalef(this.turretScale.x, this.turretScale.y, this.turretScale.z);
    GL11.glTranslatef(this.turretTrans.x, this.turretTrans.y, this.turretTrans.z);
    renderPart(this.turretModel);
    renderPart(this.barrelModel);
    GL11.glPopMatrix();
    renderPart(this.drillHeadModel);
    for (ModelRendererTurbo[] mods : this.ammoModel)
      renderPart(mods); 
    for (ModelRendererTurbo[] latm : this.leftAnimTrackModel)
      renderPart(latm); 
    for (ModelRendererTurbo[] ratm : this.rightAnimTrackModel)
      renderPart(ratm); 
    renderPart(this.rightAnimTrackModel1);
    renderPart(this.leftAnimTrackModel1);
    renderPart(this.rightAnimTrackModel2);
    renderPart(this.leftAnimTrackModel2);
    renderPart(this.rightAnimTrackModel3);
    renderPart(this.leftAnimTrackModel3);
    renderPart(this.steeringWheelModel);
    renderPart(this.steeringWheelModel);
    renderPart(this.barrelSpecModel);
    renderTrackInGUI(type);
    GL11.glPushMatrix();
    GL11.glTranslatef(this.barrelAttach.x, this.barrelAttach.y, -this.barrelAttach.z);
    renderPart(this.animBarrelModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.doorAttach.x, this.doorAttach.y, -this.doorAttach.z);
    renderPart(this.doorAnimModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.door2Attach.x, this.door2Attach.y, -this.door2Attach.z);
    renderPart(this.door2AnimModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.drakonArmAttach.x, this.drakonArmAttach.y, this.drakonArmAttach.z);
    renderPart(this.drakonArmModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.drakonRailAttach.x, this.drakonRailAttach.y, this.drakonRailAttach.z);
    renderPart(this.drakonRailModel);
    renderPart(this.drakonModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.drakonDoorAttach.x, this.drakonDoorAttach.y, this.drakonDoorAttach.z);
    renderPart(this.drakonDoorModel);
    GL11.glPopMatrix();
  }
  
  public void renderTrackInGUI(DriveableType type) {
    AnimTankTrack rightTrack = new AnimTankTrack(type.rightTrackPoints, type.trackLinkLength);
    AnimTankTrack leftTrack = new AnimTankTrack(type.leftTrackPoints, type.trackLinkLength);
    AnimTrackLink[] trackLinksLeft = new AnimTrackLink[0];
    AnimTrackLink[] trackLinksRight = new AnimTrackLink[0];
    int numLinks = Math.round(rightTrack.getTrackLength() / type.trackLinkLength);
    trackLinksLeft = new AnimTrackLink[numLinks];
    trackLinksRight = new AnimTrackLink[numLinks];
    int i;
    for (i = 0; i < numLinks; i++) {
      float progress = 0.01F + type.trackLinkLength * i;
      int trackPart = leftTrack.getTrackPart(progress);
      trackLinksLeft[i] = new AnimTrackLink(progress);
      trackLinksRight[i] = new AnimTrackLink(progress);
      (trackLinksLeft[i]).position = leftTrack.getPositionOnTrack(progress);
      (trackLinksRight[i]).position = rightTrack.getPositionOnTrack(progress);
      (trackLinksLeft[i]).rot = new RotatedAxes(0.0F, 0.0F, rotateTowards(leftTrack.points.get((trackPart == 0) ? (leftTrack.points.size() - 1) : (trackPart - 1)), (trackLinksLeft[i]).position));
      (trackLinksRight[i]).rot = new RotatedAxes(0.0F, 0.0F, rotateTowards(rightTrack.points.get((trackPart == 0) ? (rightTrack.points.size() - 1) : (trackPart - 1)), (trackLinksRight[i]).position));
      (trackLinksLeft[i]).zRot = rotateTowards(leftTrack.points.get((trackPart == 0) ? (leftTrack.points.size() - 1) : (trackPart - 1)), (trackLinksLeft[i]).position);
      (trackLinksRight[i]).zRot = rotateTowards(rightTrack.points.get((trackPart == 0) ? (rightTrack.points.size() - 1) : (trackPart - 1)), (trackLinksRight[i]).position);
    } 
    for (i = 0; i < trackLinksLeft.length; i++) {
      AnimTrackLink link = trackLinksLeft[i];
      float rotZ = link.zRot;
      GL11.glPushMatrix();
      GL11.glTranslatef(link.position.x / 16.0F, link.position.y / 16.0F, link.position.z / 16.0F);
      for (; rotZ > 180.0F; rotZ -= 360.0F);
      for (; rotZ <= -180.0F; rotZ += 360.0F);
      GL11.glRotatef(rotZ * 57.29578F, 0.0F, 0.0F, 1.0F);
      renderPart(this.fancyTrackModel);
      GL11.glPopMatrix();
    } 
    for (i = 0; i < trackLinksRight.length; i++) {
      AnimTrackLink link = trackLinksRight[i];
      float rotZ = link.zRot;
      for (; rotZ > 180.0F; rotZ -= 360.0F);
      for (; rotZ <= -180.0F; rotZ += 360.0F);
      GL11.glPushMatrix();
      GL11.glTranslatef(link.position.x / 16.0F, link.position.y / 16.0F, link.position.z / 16.0F);
      GL11.glRotatef(rotZ * 57.29578F, 0.0F, 0.0F, 1.0F);
      renderPart(this.fancyTrackModel);
      GL11.glPopMatrix();
    } 
  }
  
  public float rotateTowards(Vector3f point, Vector3f original) {
    float angle = (float)Math.atan2((point.y - original.y), (point.x - original.x));
    return angle;
  }
  
  public void render(float f5, EntityVehicle vehicle, float f) {
    boolean rotateWheels = (vehicle.getVehicleType()).rotateWheels;
    this.animFrameLeft = vehicle.animFrameLeft;
    this.animFrameRight = vehicle.animFrameRight;
    if (vehicle.isPartIntact(EnumDriveablePart.core)) {
      for (ModelRendererTurbo aBodyModel : this.bodyModel)
        aBodyModel.render(f5, this.oldRotateOrder); 
      for (ModelRendererTurbo aBodyDoorOpenModel : this.bodyDoorOpenModel) {
        if (vehicle.varDoor)
          aBodyDoorOpenModel.render(f5, this.oldRotateOrder); 
      } 
      for (ModelRendererTurbo aBodyDoorCloseModel : this.bodyDoorCloseModel) {
        if (!vehicle.varDoor)
          aBodyDoorCloseModel.render(f5, this.oldRotateOrder); 
      } 
      for (ModelRendererTurbo aSteeringWheelModel : this.steeringWheelModel) {
        if (!vehicle.hugeBoat) {
          aSteeringWheelModel.field_78795_f = vehicle.wheelsYaw * 3.1415927F / 180.0F * 3.0F;
        } else {
          aSteeringWheelModel.field_78795_f = -vehicle.wheelsYaw * 3.1415927F / 180.0F * 3.0F;
        } 
        aSteeringWheelModel.render(f5, this.oldRotateOrder);
      } 
    } 
    if (vehicle.isPartIntact(EnumDriveablePart.backLeftWheel))
      for (ModelRendererTurbo aLeftBackWheelModel : this.leftBackWheelModel) {
        aLeftBackWheelModel.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
        aLeftBackWheelModel.render(f5, this.oldRotateOrder);
      }  
    if (vehicle.isPartIntact(EnumDriveablePart.backRightWheel))
      for (ModelRendererTurbo aRightBackWheelModel : this.rightBackWheelModel) {
        aRightBackWheelModel.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
        aRightBackWheelModel.render(f5, this.oldRotateOrder);
      }  
    if (vehicle.isPartIntact(EnumDriveablePart.frontLeftWheel))
      for (ModelRendererTurbo aLeftFrontWheelModel : this.leftFrontWheelModel) {
        aLeftFrontWheelModel.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
        aLeftFrontWheelModel.field_78796_g = -vehicle.wheelsYaw * 3.1415927F / 180.0F * 3.0F;
        aLeftFrontWheelModel.render(f5, this.oldRotateOrder);
      }  
    if (vehicle.isPartIntact(EnumDriveablePart.frontRightWheel))
      for (ModelRendererTurbo aRightFrontWheelModel : this.rightFrontWheelModel) {
        aRightFrontWheelModel.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
        aRightFrontWheelModel.field_78796_g = -vehicle.wheelsYaw * 3.1415927F / 180.0F * 3.0F;
        aRightFrontWheelModel.render(f5, this.oldRotateOrder);
      }  
    if (vehicle.isPartIntact(EnumDriveablePart.frontWheel))
      for (ModelRendererTurbo aFrontWheelModel : this.frontWheelModel) {
        aFrontWheelModel.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
        aFrontWheelModel.field_78796_g = -vehicle.wheelsYaw * 3.1415927F / 180.0F * 3.0F;
        aFrontWheelModel.render(f5, this.oldRotateOrder);
      }  
    if (vehicle.isPartIntact(EnumDriveablePart.backWheel))
      for (ModelRendererTurbo aBackWheelModel : this.backWheelModel) {
        aBackWheelModel.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
        aBackWheelModel.render(f5, this.oldRotateOrder);
      }  
    if (vehicle.isPartIntact(EnumDriveablePart.leftTrack)) {
      for (ModelRendererTurbo aLeftTrackModel : this.leftTrackModel)
        aLeftTrackModel.render(f5, this.oldRotateOrder); 
      for (ModelRendererTurbo leftTrackWheelModel : this.leftTrackWheelModels) {
        leftTrackWheelModel.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
        leftTrackWheelModel.render(f5, this.oldRotateOrder);
      } 
      if (vehicle.animFrameLeft == 0) {
        for (ModelRendererTurbo aLeftTrackModel1 : this.leftAnimTrackModel1)
          aLeftTrackModel1.render(f5, this.oldRotateOrder); 
      } else if (vehicle.animFrameLeft == 1) {
        for (ModelRendererTurbo aLeftTrackModel2 : this.leftAnimTrackModel2)
          aLeftTrackModel2.render(f5, this.oldRotateOrder); 
      } else if (vehicle.animFrameLeft == 2) {
        for (ModelRendererTurbo aLeftTrackModel3 : this.leftAnimTrackModel3)
          aLeftTrackModel3.render(f5, this.oldRotateOrder); 
      } 
      for (int i = 0; i < this.leftAnimTrackModel.length; i++) {
        if (i == this.animFrameLeft)
          for (ModelRendererTurbo aLeftAnimTrackModel : this.leftAnimTrackModel[i])
            aLeftAnimTrackModel.render(f5, this.oldRotateOrder);  
      } 
    } 
    if (vehicle.isPartIntact(EnumDriveablePart.rightTrack)) {
      for (ModelRendererTurbo aRightTrackModel : this.rightTrackModel)
        aRightTrackModel.render(f5, this.oldRotateOrder); 
      for (ModelRendererTurbo rightTrackWheelModel : this.rightTrackWheelModels) {
        rightTrackWheelModel.field_78808_h = rotateWheels ? -vehicle.wheelsAngle : 0.0F;
        rightTrackWheelModel.render(f5, this.oldRotateOrder);
      } 
      if (vehicle.animFrameRight == 0) {
        for (ModelRendererTurbo aRightTrackModel1 : this.rightAnimTrackModel1)
          aRightTrackModel1.render(f5, this.oldRotateOrder); 
      } else if (vehicle.animFrameRight == 1) {
        for (ModelRendererTurbo aRightTrackModel2 : this.rightAnimTrackModel2)
          aRightTrackModel2.render(f5, this.oldRotateOrder); 
      } else if (vehicle.animFrameRight == 2) {
        for (ModelRendererTurbo aRightTrackModel3 : this.rightAnimTrackModel3)
          aRightTrackModel3.render(f5, this.oldRotateOrder); 
      } 
      for (int i = 0; i < this.rightAnimTrackModel.length; i++) {
        if (i == this.animFrameRight)
          for (ModelRendererTurbo aRightAnimTrackModel : this.rightAnimTrackModel[i])
            aRightAnimTrackModel.render(f5, this.oldRotateOrder);  
      } 
    } 
    if (vehicle.isPartIntact(EnumDriveablePart.trailer))
      for (ModelRendererTurbo aTrailerModel : this.trailerModel)
        aTrailerModel.render(f5, this.oldRotateOrder);  
    for (EntitySeat seat : vehicle.seats) {
      if (seat != null && seat.seatInfo != null && seat.seatInfo.gunName != null && this.gunModels.get(seat.seatInfo.gunName) != null && vehicle.isPartIntact(seat.seatInfo.part) && !vehicle.rotateWithTurret(seat.seatInfo)) {
        float yaw = seat.prevLooking.getYaw() + (seat.looking.getYaw() - seat.prevLooking.getYaw()) * f;
        float pitch = seat.prevLooking.getPitch() + (seat.looking.getPitch() - seat.prevLooking.getPitch()) * f;
        ModelRendererTurbo[][] gunModel = this.gunModels.get(seat.seatInfo.gunName);
        for (ModelRendererTurbo gunModelPart : gunModel[0]) {
          GL11.glPushMatrix();
          GL11.glScalef((vehicle.getVehicleType()).vehicleGunModelScale, (vehicle.getVehicleType()).vehicleGunModelScale, (vehicle.getVehicleType()).vehicleGunModelScale);
          gunModelPart.field_78796_g = -yaw * 3.1415927F / 180.0F;
          gunModelPart.func_78785_a(f5);
          GL11.glPopMatrix();
        } 
        GL11.glPushMatrix();
        GL11.glScalef((vehicle.getVehicleType()).vehicleGunModelScale, (vehicle.getVehicleType()).vehicleGunModelScale, (vehicle.getVehicleType()).vehicleGunModelScale);
        for (ModelRendererTurbo gunModelPart : gunModel[1]) {
          gunModelPart.field_78796_g = -yaw * 3.1415927F / 180.0F;
          gunModelPart.field_78808_h = -pitch * 3.1415927F / 180.0F;
          gunModelPart.func_78785_a(f5);
        } 
        for (ModelRendererTurbo gunModelPart : gunModel[2]) {
          gunModelPart.field_78796_g = -yaw * 3.1415927F / 180.0F;
          gunModelPart.field_78808_h = -pitch * 3.1415927F / 180.0F;
          gunModelPart.func_78785_a(f5);
        } 
        GL11.glPopMatrix();
      } 
    } 
  }
  
  public void renderDoor(EntityVehicle vehicle, float f5) {
    if (vehicle.isPartIntact(EnumDriveablePart.core))
      for (ModelRendererTurbo aDoorAnimModel : this.doorAnimModel)
        aDoorAnimModel.func_78785_a(f5);  
  }
  
  public void renderDoor2(EntityVehicle vehicle, float f5) {
    if (vehicle.isPartIntact(EnumDriveablePart.core))
      for (ModelRendererTurbo aDoor2AnimModel : this.door2AnimModel)
        aDoor2AnimModel.func_78785_a(f5);  
  }
  
  public void renderTurret(float f, float f1, float f2, float f3, float f4, float f5, EntityVehicle vehicle, float dt) {
    VehicleType type = vehicle.getVehicleType();
    GL11.glPushMatrix();
    GL11.glScalef(this.turretScale.x, this.turretScale.y, this.turretScale.z);
    GL11.glTranslatef(this.turretTrans.x, this.turretTrans.y, this.turretTrans.z);
    if (this.fancyTurret) {
      ResourceLocation turretobj = new ResourceLocation("flansmod", "models/" + this.turretName);
      IModelCustom model = AdvancedModelLoader.loadModel(turretobj);
      GL11.glPushMatrix();
      float scale = 1.0F;
      model.renderAll();
      GL11.glPopMatrix();
    } 
    float yaw = (vehicle.seats[0]).looking.getYaw();
    float pitch = (vehicle.seats[0]).looking.getPitch();
    float dPitch = (vehicle.seats[0]).looking.getPitch() - (vehicle.seats[0]).prevLooking.getPitch();
    float aPitch = (vehicle.seats[0]).prevLooking.getPitch() + dPitch * dt;
    for (ModelRendererTurbo aTurretModel : this.turretModel) {
      if ((Minecraft.func_71410_x()).field_71474_y.field_74320_O != 0 || (vehicle.seats[0]).field_70153_n != (Minecraft.func_71410_x()).field_71439_g || vehicle.alwaysShowTurret)
        aTurretModel.render(f5, this.oldRotateOrder); 
    } 
    for (ModelRendererTurbo aBarrelModel : this.barrelModel) {
      aBarrelModel.field_78808_h = -(aPitch * 3.1415927F / 180.0F);
      aBarrelModel.render(f5, this.oldRotateOrder);
    } 
    GL11.glPushMatrix();
    GL11.glTranslatef(this.barrelAttach.x, this.barrelAttach.y, -this.barrelAttach.z);
    GL11.glRotatef(-aPitch, 0.0F, 0.0F, 1.0F);
    for (ModelRendererTurbo aBarrelModel : this.barrelSpecModel)
      aBarrelModel.render(f5, this.oldRotateOrder); 
    GL11.glPopMatrix();
    for (int i = 0; i < this.ammoModel.length; i++) {
      if (i >= type.numMissileSlots || (vehicle.getDriveableData()).missiles[i] != null)
        for (int j = 0; j < (this.ammoModel[i]).length; j++) {
          (this.ammoModel[i][j]).field_78808_h = -pitch * 3.1415927F / 180.0F;
          this.ammoModel[i][j].render(f5, this.oldRotateOrder);
        }  
    } 
    float armAngle = vehicle.drakonArmAngle;
    float dArmAngle = vehicle.drakonArmAngle - vehicle.prevDrakonArmAngle;
    for (; dArmAngle > 180.0F; dArmAngle -= 360.0F);
    for (; dArmAngle <= -180.0F; dArmAngle += 360.0F);
    float drakonArmAngle = vehicle.prevDrakonArmAngle + dArmAngle * dt;
    float railAngle = vehicle.drakonRailAngle;
    float dRailAngle = vehicle.drakonRailAngle - vehicle.prevDrakonRailAngle;
    for (; dRailAngle > 180.0F; dRailAngle -= 360.0F);
    for (; dRailAngle <= -180.0F; dRailAngle += 360.0F);
    float drakonRailAngle = vehicle.prevDrakonRailAngle + dRailAngle * dt;
    float doorAngle = vehicle.drakonDoorAngle;
    float dDoorAngle = vehicle.drakonDoorAngle - vehicle.prevDrakonDoorAngle;
    for (; dDoorAngle > 180.0F; dDoorAngle -= 360.0F);
    for (; dDoorAngle <= -180.0F; dDoorAngle += 360.0F);
    float drakonDoorAngle = vehicle.prevDrakonDoorAngle + dDoorAngle * dt;
    GL11.glPushMatrix();
    GL11.glTranslatef(this.drakonArmAttach.x, this.drakonArmAttach.y, this.drakonArmAttach.z);
    GL11.glRotatef(drakonArmAngle, 0.0F, 0.0F, 1.0F);
    for (ModelRendererTurbo aArmModel : this.drakonArmModel)
      aArmModel.render(f5, this.oldRotateOrder); 
    GL11.glTranslatef(this.drakonRailAttach.x - this.drakonArmAttach.x, this.drakonRailAttach.y - this.drakonArmAttach.y, this.drakonRailAttach.z - this.drakonArmAttach.z);
    GL11.glRotatef(drakonRailAngle, 0.0F, 0.0F, 1.0F);
    for (ModelRendererTurbo aRailModel : this.drakonRailModel)
      aRailModel.render(f5, this.oldRotateOrder); 
    if (vehicle.canFireIT1)
      for (ModelRendererTurbo aMissileModel : this.drakonModel)
        aMissileModel.render(f5, this.oldRotateOrder);  
    if (vehicle.reloadingDrakon && !vehicle.canFireIT1)
      for (ModelRendererTurbo aMissileModel : this.drakonReloadModel)
        aMissileModel.render(f5, this.oldRotateOrder);  
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.drakonDoorAttach.x, this.drakonDoorAttach.y, this.drakonDoorAttach.z);
    GL11.glRotatef(drakonDoorAngle, 1.0F, 0.0F, 0.0F);
    for (ModelRendererTurbo aDoorModel : this.drakonDoorModel)
      aDoorModel.render(f5, this.oldRotateOrder); 
    GL11.glPopMatrix();
    for (EntitySeat seat : vehicle.seats) {
      if (seat != null && seat.seatInfo != null && seat.seatInfo.gunName != null && this.gunModels.get(seat.seatInfo.gunName) != null && vehicle.isPartIntact(seat.seatInfo.part) && vehicle.rotateWithTurret(seat.seatInfo)) {
        EntitySeat driverSeat = vehicle.seats[0];
        float driverYaw = driverSeat.prevLooking.getYaw() + (driverSeat.looking.getYaw() - driverSeat.prevLooking.getYaw()) * dt;
        float f6 = seat.prevLooking.getYaw() + (seat.looking.getYaw() - seat.prevLooking.getYaw()) * dt;
        float f7 = seat.prevLooking.getPitch() + (seat.looking.getPitch() - seat.prevLooking.getPitch()) * dt;
        float effectiveYaw = f6 - driverYaw;
        ModelRendererTurbo[][] gunModel = this.gunModels.get(seat.seatInfo.gunName);
        for (ModelRendererTurbo gunModelPart : gunModel[0]) {
          gunModelPart.field_78796_g = -effectiveYaw * 3.1415927F / 180.0F;
          gunModelPart.render(f5, this.oldRotateOrder);
        } 
        for (ModelRendererTurbo gunModelPart : gunModel[1]) {
          gunModelPart.field_78796_g = -effectiveYaw * 3.1415927F / 180.0F;
          gunModelPart.field_78808_h = -f7 * 3.1415927F / 180.0F;
          gunModelPart.render(f5, this.oldRotateOrder);
        } 
        for (ModelRendererTurbo gunModelPart : gunModel[2]) {
          gunModelPart.field_78796_g = -effectiveYaw * 3.1415927F / 180.0F;
          gunModelPart.field_78808_h = -f7 * 3.1415927F / 180.0F;
          gunModelPart.render(f5, this.oldRotateOrder);
        } 
      } 
    } 
    GL11.glPopMatrix();
  }
  
  public void renderAnimBarrel(float f, float f1, float f2, float f3, float f4, float f5, EntityVehicle vehicle, float dt) {
    if (vehicle.isPartIntact(EnumDriveablePart.turret))
      for (ModelRendererTurbo aAnimBarrelModel : this.animBarrelModel)
        aAnimBarrelModel.render(f5, this.oldRotateOrder);  
  }
  
  public void renderDrillBit(EntityVehicle vehicle, float f) {
    if (vehicle.isPartIntact(EnumDriveablePart.harvester))
      for (ModelRendererTurbo adrillHeadModel : this.drillHeadModel)
        adrillHeadModel.render(0.0625F, this.oldRotateOrder);  
  }
  
  public void renderFancyTracks(EntityVehicle vehicle, float f) {
    for (ModelRendererTurbo adrillHeadModel : this.fancyTrackModel)
      adrillHeadModel.render(0.0625F, this.oldRotateOrder); 
  }
  
  public void flipAll() {
    super.flipAll();
    flip(this.bodyDoorOpenModel);
    flip(this.bodyDoorCloseModel);
    flip(this.turretModel);
    flip(this.barrelModel);
    flip(this.barrelSpecModel);
    flip(this.animBarrelModel);
    flip(this.leftFrontWheelModel);
    flip(this.rightFrontWheelModel);
    flip(this.leftBackWheelModel);
    flip(this.rightBackWheelModel);
    flip(this.rightTrackModel);
    flip(this.leftTrackModel);
    flip(this.rightTrackWheelModels);
    flip(this.leftTrackWheelModels);
    flip(this.trailerModel);
    flip(this.steeringWheelModel);
    flip(this.frontWheelModel);
    flip(this.backWheelModel);
    flip(this.drillHeadModel);
    flip(this.rightAnimTrackModel1);
    flip(this.leftAnimTrackModel1);
    flip(this.rightAnimTrackModel2);
    flip(this.leftAnimTrackModel2);
    flip(this.rightAnimTrackModel3);
    flip(this.leftAnimTrackModel3);
    flip(this.drakonArmModel);
    flip(this.drakonRailModel);
    flip(this.drakonDoorModel);
    flip(this.drakonModel);
    flip(this.drakonReloadModel);
    for (ModelRendererTurbo[] latm : this.leftAnimTrackModel)
      flip(latm); 
    for (ModelRendererTurbo[] ratm : this.rightAnimTrackModel)
      flip(ratm); 
    flip(this.doorAnimModel);
    flip(this.door2AnimModel);
    flip(this.fancyTrackModel);
  }
  
  public void translateAll(float x, float y, float z) {
    super.translateAll(x, y, z);
    translate(this.bodyDoorOpenModel, x, y, z);
    translate(this.bodyDoorCloseModel, x, y, z);
    translate(this.turretModel, x, y, z);
    translate(this.barrelModel, x, y, z);
    translate(this.barrelSpecModel, x, y, z);
    translate(this.animBarrelModel, x, y, z);
    translate(this.leftFrontWheelModel, x, y, z);
    translate(this.rightFrontWheelModel, x, y, z);
    translate(this.leftBackWheelModel, x, y, z);
    translate(this.rightBackWheelModel, x, y, z);
    translate(this.rightTrackModel, x, y, z);
    translate(this.leftTrackModel, x, y, z);
    translate(this.rightTrackWheelModels, x, y, z);
    translate(this.leftTrackWheelModels, x, y, z);
    translate(this.trailerModel, x, y, z);
    translate(this.steeringWheelModel, x, y, z);
    translate(this.frontWheelModel, x, y, z);
    translate(this.backWheelModel, x, y, z);
    translate(this.drillHeadModel, x, y, z);
    translate(this.rightAnimTrackModel1, x, y, z);
    translate(this.leftAnimTrackModel1, x, y, z);
    translate(this.rightAnimTrackModel2, x, y, z);
    translate(this.leftAnimTrackModel2, x, y, z);
    translate(this.rightAnimTrackModel3, x, y, z);
    translate(this.leftAnimTrackModel3, x, y, z);
    for (ModelRendererTurbo[] latm : this.leftAnimTrackModel)
      translate(latm, x, y, z); 
    for (ModelRendererTurbo[] ratm : this.rightAnimTrackModel)
      translate(ratm, x, y, z); 
    translate(this.doorAnimModel, x, y, z);
    translate(this.door2AnimModel, x, y, z);
    translate(this.drakonArmModel, x, y, z);
    translate(this.drakonRailModel, x, y, z);
    translate(this.drakonDoorModel, x, y, z);
    translate(this.drakonReloadModel, x, y, z);
    translate(this.drakonModel, x, y, z);
    translate(this.fancyTrackModel, x, y, z);
  }
}
