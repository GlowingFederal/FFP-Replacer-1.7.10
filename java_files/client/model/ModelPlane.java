package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.EnumPlaneMode;
import com.flansmod.common.driveables.PlaneType;
import com.flansmod.common.driveables.Propeller;
import com.flansmod.common.vector.Vector3f;
import org.lwjgl.opengl.GL11;

public class ModelPlane extends ModelDriveable {
  public ModelRendererTurbo[] noseModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftWingModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightWingModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] topWingModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] bayModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] tailModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[][] propellerModels = new ModelRendererTurbo[0][0];
  
  public ModelRendererTurbo[] yawFlapModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] pitchFlapLeftModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] pitchFlapRightModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] pitchFlapLeftWingModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] pitchFlapRightWingModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftAnimWingModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightAnimWingModel = new ModelRendererTurbo[0];
  
  public Vector3f leftWingAttach = new Vector3f();
  
  public Vector3f rightWingAttach = new Vector3f();
  
  public ModelRendererTurbo[] bodyAnimWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] tailAnimWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftAnimWingWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightAnimWingWheelModel = new ModelRendererTurbo[0];
  
  public Vector3f bodyWheelAttach = new Vector3f();
  
  public Vector3f tailWheelAttach = new Vector3f();
  
  public Vector3f leftWingWheelAttach = new Vector3f();
  
  public Vector3f rightWingWheelAttach = new Vector3f();
  
  public ModelRendererTurbo[] doorAnimModel = new ModelRendererTurbo[0];
  
  public Vector3f doorAttach = new Vector3f();
  
  public ModelRendererTurbo[][] heliMainRotorModels = new ModelRendererTurbo[0][0];
  
  public Vector3f[] heliMainRotorOrigins = new Vector3f[0];
  
  public float[] heliRotorSpeeds = new float[0];
  
  public ModelRendererTurbo[][] heliTailRotorModels = new ModelRendererTurbo[0][0];
  
  public Vector3f[] heliTailRotorOrigins = new Vector3f[0];
  
  public ModelRendererTurbo[] skidsModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] helicopterModeParts = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] planeModeParts = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] bodyWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] tailWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftWingWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightWingWheelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] tailDoorOpenModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] tailDoorCloseModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightWingPos1Model = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightWingPos2Model = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftWingPos1Model = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftWingPos2Model = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] hudModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[][] valkyrie = new ModelRendererTurbo[0][0];
  
  public void render(EntityDriveable driveable, float f1) {
    render(0.0625F, (EntityPlane)driveable, f1);
  }
  
  public void render(DriveableType type) {
    super.render(type);
    renderPart(this.noseModel);
    renderPart(this.leftWingModel);
    renderPart(this.rightWingModel);
    GL11.glPushMatrix();
    GL11.glTranslatef(this.leftWingAttach.x, this.leftWingAttach.y, -this.leftWingAttach.z);
    renderPart(this.leftAnimWingModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.rightWingAttach.x, this.rightWingAttach.y, -this.rightWingAttach.z);
    renderPart(this.rightAnimWingModel);
    GL11.glPopMatrix();
    renderPart(this.topWingModel);
    renderPart(this.bayModel);
    renderPart(this.tailModel);
    for (ModelRendererTurbo[] prop : this.propellerModels) {
      for (int j = 0; j < prop.length; j++) {
        (prop[j]).field_78795_f = j * 2.0F * 3.1415927F / prop.length;
        prop[j].func_78785_a(0.0625F);
      } 
    } 
    for (ModelRendererTurbo[] heliMainRotorModel : this.heliMainRotorModels)
      renderPart(heliMainRotorModel); 
    for (ModelRendererTurbo[] heliTailRotorModel : this.heliTailRotorModels)
      renderPart(heliTailRotorModel); 
    for (ModelRendererTurbo[] partModel : this.valkyrie)
      renderPart(partModel); 
    renderPart(this.helicopterModeParts);
    renderPart(this.skidsModel);
    renderPart(this.yawFlapModel);
    renderPart(this.pitchFlapLeftModel);
    renderPart(this.pitchFlapRightModel);
    renderPart(this.pitchFlapLeftWingModel);
    renderPart(this.pitchFlapRightWingModel);
    renderPart(this.bodyWheelModel);
    renderPart(this.tailWheelModel);
    renderPart(this.leftWingWheelModel);
    renderPart(this.rightWingWheelModel);
    renderPart(this.tailDoorCloseModel);
    renderPart(this.rightWingPos1Model);
    renderPart(this.leftWingPos1Model);
    renderPart(this.hudModel);
    GL11.glPushMatrix();
    GL11.glTranslatef(this.bodyWheelAttach.x, this.bodyWheelAttach.y, -this.bodyWheelAttach.z);
    renderPart(this.bodyAnimWheelModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.tailWheelAttach.x, this.tailWheelAttach.y, -this.tailWheelAttach.z);
    renderPart(this.tailAnimWheelModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.leftWingWheelAttach.x, this.leftWingWheelAttach.y, -this.leftWingWheelAttach.z);
    renderPart(this.leftAnimWingWheelModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.rightWingWheelAttach.x, this.rightWingWheelAttach.y, -this.rightWingWheelAttach.z);
    renderPart(this.rightAnimWingWheelModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.doorAttach.x, this.doorAttach.y, -this.doorAttach.z);
    renderPart(this.doorAnimModel);
    GL11.glPopMatrix();
  }
  
  public void render(float f5, EntityPlane plane, float f) {
    PlaneType type = plane.getPlaneType();
    float dAngle = plane.propAngle - plane.prevPropAngle;
    for (; dAngle > 180.0F; dAngle -= 360.0F);
    for (; dAngle <= -180.0F; dAngle += 360.0F);
    float angle = plane.prevPropAngle + dAngle * f;
    for (Propeller propeller : (plane.getPlaneType()).propellers) {
      if (plane.isPartIntact(propeller.planePart) && this.propellerModels.length > propeller.ID) {
        int numParts = (this.propellerModels[propeller.ID]).length;
        for (int j = 0; j < numParts; j++) {
          (this.propellerModels[propeller.ID][j]).field_78795_f = angle + j * 2.0F * 3.1415927F / numParts;
          this.propellerModels[propeller.ID][j].func_78785_a(f5);
        } 
      } 
    } 
    if (plane.isPartIntact(EnumDriveablePart.nose))
      for (ModelRendererTurbo aNoseModel : this.noseModel)
        aNoseModel.func_78785_a(f5);  
    if (plane.isPartIntact(EnumDriveablePart.bay))
      for (ModelRendererTurbo aBayModel : this.bayModel)
        aBayModel.func_78785_a(f5);  
    if (plane.isPartIntact(EnumDriveablePart.tail)) {
      for (ModelRendererTurbo aTailModel : this.tailModel)
        aTailModel.func_78785_a(f5); 
      for (ModelRendererTurbo aTailDoorOpenModel : this.tailDoorOpenModel) {
        if (plane.varDoor)
          aTailDoorOpenModel.func_78785_a(f5); 
      } 
      for (ModelRendererTurbo aTailDoorCloseModel : this.tailDoorCloseModel) {
        if (!plane.varDoor)
          aTailDoorCloseModel.func_78785_a(f5); 
      } 
      for (ModelRendererTurbo aYawFlapModel : this.yawFlapModel) {
        aYawFlapModel.field_78796_g = plane.flapsYaw * 3.1415927F / 180.0F;
        aYawFlapModel.func_78785_a(f5);
      } 
      for (ModelRendererTurbo aPitchFlapLeftModel : this.pitchFlapLeftModel) {
        aPitchFlapLeftModel.field_78808_h = plane.flapsPitchLeft * 3.1415927F / 180.0F;
        aPitchFlapLeftModel.func_78785_a(f5);
      } 
      for (ModelRendererTurbo aPitchFlapRightModel : this.pitchFlapRightModel) {
        aPitchFlapRightModel.field_78808_h = plane.flapsPitchRight * 3.1415927F / 180.0F;
        aPitchFlapRightModel.func_78785_a(f5);
      } 
    } 
    if (plane.isPartIntact(EnumDriveablePart.skids))
      for (ModelRendererTurbo aSkidsModel : this.skidsModel) {
        if (plane.varGear)
          aSkidsModel.func_78785_a(f5); 
      }  
    if (plane.isPartIntact(EnumDriveablePart.tailWheel))
      for (ModelRendererTurbo aTailWheelModel : this.tailWheelModel) {
        if (plane.varGear)
          aTailWheelModel.func_78785_a(f5); 
      }  
    if (plane.isPartIntact(EnumDriveablePart.leftWing)) {
      for (ModelRendererTurbo aLeftWingModel : this.leftWingModel)
        aLeftWingModel.func_78785_a(f5); 
      for (ModelRendererTurbo aLeftWingPos1Model : this.leftWingPos1Model) {
        if (plane.varWing)
          aLeftWingPos1Model.func_78785_a(f5); 
      } 
      for (ModelRendererTurbo aLeftWingPos2Model : this.leftWingPos2Model) {
        if (!plane.varWing)
          aLeftWingPos2Model.func_78785_a(f5); 
      } 
      for (ModelRendererTurbo aPitchFlapLeftWingModel : this.pitchFlapLeftWingModel) {
        aPitchFlapLeftWingModel.field_78808_h = plane.flapsPitchLeft * 3.1415927F / 180.0F;
        aPitchFlapLeftWingModel.func_78785_a(f5);
      } 
    } 
    if (plane.isPartIntact(EnumDriveablePart.rightWing)) {
      for (ModelRendererTurbo aRightWingModel : this.rightWingModel)
        aRightWingModel.func_78785_a(f5); 
      for (ModelRendererTurbo aRightWingPos1Model : this.rightWingPos1Model) {
        if (plane.varWing)
          aRightWingPos1Model.func_78785_a(f5); 
      } 
      for (ModelRendererTurbo aRightWingPos2Model : this.rightWingPos2Model) {
        if (!plane.varWing)
          aRightWingPos2Model.func_78785_a(f5); 
      } 
      for (ModelRendererTurbo aPitchFlapRightWingModel : this.pitchFlapRightWingModel) {
        aPitchFlapRightWingModel.field_78808_h = plane.flapsPitchRight * 3.1415927F / 180.0F;
        aPitchFlapRightWingModel.func_78785_a(f5);
      } 
    } 
    if (plane.isPartIntact(EnumDriveablePart.leftWingWheel))
      for (ModelRendererTurbo aLeftWingWheelModel : this.leftWingWheelModel) {
        if (plane.varGear)
          aLeftWingWheelModel.func_78785_a(f5); 
      }  
    if (plane.isPartIntact(EnumDriveablePart.rightWingWheel))
      for (ModelRendererTurbo aRightWingWheelModel : this.rightWingWheelModel) {
        if (plane.varGear)
          aRightWingWheelModel.func_78785_a(f5); 
      }  
    if (plane.isPartIntact(EnumDriveablePart.core)) {
      for (ModelRendererTurbo aBodyModel : this.bodyModel)
        aBodyModel.func_78785_a(f5); 
      for (ModelRendererTurbo aBodyDoorOpenModel : this.bodyDoorOpenModel) {
        if (plane.varDoor)
          aBodyDoorOpenModel.func_78785_a(f5); 
      } 
      for (ModelRendererTurbo aBodyDoorCloseModel : this.bodyDoorCloseModel) {
        if (!plane.varDoor)
          aBodyDoorCloseModel.func_78785_a(f5); 
      } 
      for (ModelRendererTurbo aHudModel : this.hudModel) {
        aHudModel.field_78795_f = -(plane.axes.getRoll() * 3.1415927F / 180.0F);
        aHudModel.func_78785_a(f5);
      } 
      if (plane.mode == EnumPlaneMode.HELI) {
        renderPart(this.helicopterModeParts);
      } else {
        renderPart(this.planeModeParts);
      } 
    } 
    if (plane.isPartIntact(EnumDriveablePart.coreWheel))
      for (ModelRendererTurbo aBodyWheelModel : this.bodyWheelModel) {
        if (plane.varGear)
          aBodyWheelModel.func_78785_a(f5); 
      }  
    if (plane.isPartIntact(EnumDriveablePart.topWing))
      for (ModelRendererTurbo aTopWingModel : this.topWingModel)
        aTopWingModel.func_78785_a(f5);  
    for (EntitySeat seat : plane.seats) {
      if (seat != null && seat.seatInfo != null && seat.seatInfo.gunName != null && this.gunModels.get(seat.seatInfo.gunName) != null && plane.isPartIntact(seat.seatInfo.part)) {
        float yaw = seat.prevLooking.getYaw() + (seat.looking.getYaw() - seat.prevLooking.getYaw()) * f;
        float pitch = seat.prevLooking.getPitch() + (seat.looking.getPitch() - seat.prevLooking.getPitch()) * f;
        ModelRendererTurbo[][] gunModel = this.gunModels.get(seat.seatInfo.gunName);
        for (ModelRendererTurbo gunModelPart : gunModel[0]) {
          gunModelPart.field_78796_g = (180.0F - yaw) * 3.1415927F / 180.0F;
          gunModelPart.func_78785_a(f5);
        } 
        for (ModelRendererTurbo gunModelPart : gunModel[1]) {
          gunModelPart.field_78796_g = (180.0F - yaw) * 3.1415927F / 180.0F;
          gunModelPart.field_78808_h = -pitch * 3.1415927F / 180.0F;
          gunModelPart.func_78785_a(f5);
        } 
        for (ModelRendererTurbo gunModelPart : gunModel[2]) {
          gunModelPart.field_78796_g = (180.0F - yaw) * 3.1415927F / 180.0F;
          gunModelPart.field_78808_h = -pitch * 3.1415927F / 180.0F;
          gunModelPart.func_78785_a(f5);
        } 
        if (gunModel.length > 3) {
          float minigunSpeed = seat.getMinigunSpeed();
          for (ModelRendererTurbo gunModelPart : gunModel[3]) {
            gunModelPart.field_78796_g = (180.0F - yaw) * 3.1415927F / 180.0F;
            gunModelPart.field_78808_h = -pitch * 3.1415927F / 180.0F;
            gunModelPart.field_78795_f = seat.minigunAngle * 0.5F;
            gunModelPart.func_78785_a(f5);
          } 
        } 
      } 
    } 
  }
  
  public void renderValk(EntityPlane plane, float f5, int id) {
    for (ModelRendererTurbo aModel : this.valkyrie[id])
      aModel.func_78785_a(f5); 
  }
  
  public void renderLeftWing(EntityPlane plane, float f5) {
    if (plane.isPartIntact(EnumDriveablePart.leftWing))
      for (ModelRendererTurbo aAnimLeftWingModel : this.leftAnimWingModel)
        aAnimLeftWingModel.func_78785_a(f5);  
  }
  
  public void renderRightWing(EntityPlane plane, float f5) {
    if (plane.isPartIntact(EnumDriveablePart.rightWing))
      for (ModelRendererTurbo aAnimRightWingModel : this.rightAnimWingModel)
        aAnimRightWingModel.func_78785_a(f5);  
  }
  
  public void renderLeftWingWheel(EntityPlane plane, float f5) {
    if (plane.isPartIntact(EnumDriveablePart.leftWingWheel))
      for (ModelRendererTurbo aAnimLeftWingWheelModel : this.leftAnimWingWheelModel)
        aAnimLeftWingWheelModel.func_78785_a(f5);  
  }
  
  public void renderRightWingWheel(EntityPlane plane, float f5) {
    if (plane.isPartIntact(EnumDriveablePart.rightWingWheel))
      for (ModelRendererTurbo aAnimRightWingWheelModel : this.rightAnimWingWheelModel)
        aAnimRightWingWheelModel.func_78785_a(f5);  
  }
  
  public void renderCoreWheel(EntityPlane plane, float f5) {
    if (plane.isPartIntact(EnumDriveablePart.coreWheel))
      for (ModelRendererTurbo aAnimBodyWheelModel : this.bodyAnimWheelModel)
        aAnimBodyWheelModel.func_78785_a(f5);  
  }
  
  public void renderTailWheel(EntityPlane plane, float f5) {
    if (plane.isPartIntact(EnumDriveablePart.tailWheel))
      for (ModelRendererTurbo aAnimTailWheelModel : this.tailAnimWheelModel)
        aAnimTailWheelModel.func_78785_a(f5);  
  }
  
  public void renderDoor(EntityPlane plane, float f5) {
    if (plane.isPartIntact(EnumDriveablePart.core))
      for (ModelRendererTurbo aDoorAnimModel : this.doorAnimModel)
        aDoorAnimModel.func_78785_a(f5);  
  }
  
  public void renderRotor(EntityPlane plane, float f5, int i) {
    PlaneType type = plane.getPlaneType();
    if (i >= type.heliPropellers.size() || plane.isPartIntact(((Propeller)type.heliPropellers.get(i)).planePart))
      for (int j = 0; j < (this.heliMainRotorModels[i]).length; j++)
        this.heliMainRotorModels[i][j].func_78785_a(f5);  
  }
  
  public void renderTailRotor(EntityPlane plane, float f5, int i) {
    PlaneType type = plane.getPlaneType();
    if (i >= type.heliTailPropellers.size() || plane.isPartIntact(((Propeller)type.heliTailPropellers.get(i)).planePart))
      for (int j = 0; j < (this.heliTailRotorModels[i]).length; j++)
        this.heliTailRotorModels[i][j].func_78785_a(f5);  
  }
  
  public void flipAll() {
    super.flipAll();
    flip(this.noseModel);
    flip(this.leftWingModel);
    flip(this.rightWingModel);
    flip(this.topWingModel);
    flip(this.bayModel);
    flip(this.tailModel);
    flip(this.yawFlapModel);
    flip(this.skidsModel);
    flip(this.helicopterModeParts);
    flip(this.planeModeParts);
    flip(this.pitchFlapLeftModel);
    flip(this.pitchFlapRightModel);
    flip(this.pitchFlapLeftWingModel);
    flip(this.pitchFlapRightWingModel);
    flip(this.bodyWheelModel);
    flip(this.tailWheelModel);
    flip(this.leftWingWheelModel);
    flip(this.rightWingWheelModel);
    flip(this.tailDoorOpenModel);
    flip(this.tailDoorCloseModel);
    flip(this.rightWingPos1Model);
    flip(this.rightWingPos2Model);
    flip(this.leftWingPos1Model);
    flip(this.leftWingPos2Model);
    flip(this.hudModel);
    flip(this.leftAnimWingModel);
    flip(this.rightAnimWingModel);
    flip(this.bodyAnimWheelModel);
    flip(this.tailAnimWheelModel);
    flip(this.leftAnimWingWheelModel);
    flip(this.rightAnimWingWheelModel);
    flip(this.doorAnimModel);
    for (ModelRendererTurbo[] valkModel : this.valkyrie)
      flip(valkModel); 
    for (ModelRendererTurbo[] propellerModel : this.propellerModels)
      flip(propellerModel); 
    for (ModelRendererTurbo[] propellerModel : this.heliMainRotorModels)
      flip(propellerModel); 
    for (ModelRendererTurbo[] propellerModel : this.heliTailRotorModels)
      flip(propellerModel); 
  }
  
  public void translateAll(float x, float y, float z) {
    super.translateAll(x, y, z);
    translate(this.noseModel, x, y, z);
    translate(this.leftWingModel, x, y, z);
    translate(this.rightWingModel, x, y, z);
    translate(this.topWingModel, x, y, z);
    translate(this.bayModel, x, y, z);
    translate(this.tailModel, x, y, z);
    translate(this.yawFlapModel, x, y, z);
    translate(this.skidsModel, x, y, z);
    translate(this.helicopterModeParts, x, y, z);
    translate(this.planeModeParts, x, y, z);
    translate(this.pitchFlapLeftModel, x, y, z);
    translate(this.pitchFlapRightModel, x, y, z);
    translate(this.pitchFlapLeftWingModel, x, y, z);
    translate(this.pitchFlapRightWingModel, x, y, z);
    translate(this.bodyWheelModel, x, y, z);
    translate(this.tailWheelModel, x, y, z);
    translate(this.leftWingWheelModel, x, y, z);
    translate(this.rightWingWheelModel, x, y, z);
    translate(this.tailDoorOpenModel, x, y, z);
    translate(this.tailDoorCloseModel, x, y, z);
    translate(this.rightWingPos1Model, x, y, z);
    translate(this.rightWingPos2Model, x, y, z);
    translate(this.leftWingPos1Model, x, y, z);
    translate(this.leftWingPos2Model, x, y, z);
    translate(this.hudModel, x, y, z);
    translate(this.leftAnimWingModel, x, y, z);
    translate(this.rightAnimWingModel, x, y, z);
    translate(this.bodyAnimWheelModel, x, y, z);
    translate(this.tailAnimWheelModel, x, y, z);
    translate(this.leftAnimWingWheelModel, x, y, z);
    translate(this.rightAnimWingWheelModel, x, y, z);
    translate(this.doorAnimModel, x, y, z);
    for (ModelRendererTurbo[] valkModel : this.valkyrie)
      translate(valkModel, x, y, z); 
    for (ModelRendererTurbo[] mods : this.propellerModels)
      translate(mods, x, y, z); 
    for (ModelRendererTurbo[] mods : this.heliMainRotorModels)
      translate(mods, x, y, z); 
    for (ModelRendererTurbo[] mods : this.heliTailRotorModels)
      translate(mods, x, y, z); 
    for (Vector3f o : this.heliMainRotorOrigins)
      Vector3f.add(o, new Vector3f(x / 16.0F, y / 16.0F, z / 16.0F), o); 
    for (Vector3f o : this.heliTailRotorOrigins)
      Vector3f.add(o, new Vector3f(x / 16.0F, y / 16.0F, z / 16.0F), o); 
  }
}
