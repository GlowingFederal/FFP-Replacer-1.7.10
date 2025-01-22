package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.driveables.mechas.EntityMecha;
import com.flansmod.common.driveables.mechas.MechaType;
import com.flansmod.common.vector.Vector3f;
import org.lwjgl.opengl.GL11;

public class ModelMecha extends ModelDriveable {
  public ModelRendererTurbo[] leftArmModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightArmModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftHandModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightHandModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] hipsModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftLegModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightLegModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftFootModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightFootModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] headModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] barrelModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftAnimLegUpperModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightAnimLegUpperModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftAnimLegLowerModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightAnimLegLowerModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftAnimFootModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightAnimFootModel = new ModelRendererTurbo[0];
  
  public Vector3f hipsAttachmentPoint = new Vector3f();
  
  public Vector3f legsOrigin = new Vector3f();
  
  public Vector3f leftLegUpperOrigin = new Vector3f();
  
  public Vector3f leftLegLowerOrigin = new Vector3f();
  
  public Vector3f rightLegUpperOrigin = new Vector3f();
  
  public Vector3f rightLegLowerOrigin = new Vector3f();
  
  public Vector3f rightFootOrigin = new Vector3f();
  
  public Vector3f leftFootOrigin = new Vector3f();
  
  public void render(EntityDriveable driveable, float f1) {
    render(0.0625F, (EntityMecha)driveable, f1);
  }
  
  public void render(DriveableType type) {
    super.render(type);
    MechaType mechaType = (MechaType)type;
    renderPart(this.hipsModel);
    renderPart(this.leftLegModel);
    renderPart(this.rightLegModel);
    renderPart(this.leftFootModel);
    renderPart(this.rightFootModel);
    GL11.glPushMatrix();
    renderPart(this.leftAnimLegUpperModel);
    renderPart(this.rightAnimLegUpperModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.leftLegLowerOrigin.x, this.leftLegLowerOrigin.y, this.leftLegLowerOrigin.z);
    renderPart(this.leftAnimLegLowerModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.rightLegLowerOrigin.x, this.rightLegLowerOrigin.y, this.rightLegLowerOrigin.z);
    renderPart(this.rightAnimLegLowerModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.leftFootOrigin.x, this.leftFootOrigin.y, -this.leftFootOrigin.z);
    renderPart(this.leftAnimFootModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(this.rightFootOrigin.x, this.rightFootOrigin.y, -this.rightFootOrigin.z);
    renderPart(this.rightAnimFootModel);
    GL11.glPopMatrix();
    renderPart(this.barrelModel);
    renderPart(this.headModel);
    GL11.glPushMatrix();
    GL11.glTranslatef(mechaType.leftArmOrigin.x / mechaType.modelScale, mechaType.leftArmOrigin.y / mechaType.modelScale, mechaType.leftArmOrigin.z / mechaType.modelScale);
    renderPart(this.leftArmModel);
    renderPart(this.leftHandModel);
    GL11.glPopMatrix();
    GL11.glPushMatrix();
    GL11.glTranslatef(mechaType.rightArmOrigin.x / mechaType.modelScale, mechaType.rightArmOrigin.y / mechaType.modelScale, mechaType.rightArmOrigin.z / mechaType.modelScale);
    renderPart(this.rightArmModel);
    renderPart(this.rightHandModel);
    GL11.glPopMatrix();
  }
  
  public void render(float f5, EntityMecha mecha, float f) {
    if (mecha.isPartIntact(EnumDriveablePart.core))
      for (ModelRendererTurbo aBodyModel : this.bodyModel)
        aBodyModel.func_78785_a(f5);  
    if (mecha.isPartIntact(EnumDriveablePart.head))
      for (ModelRendererTurbo model : this.headModel)
        model.func_78785_a(f5);  
    float pitch = 0.0F;
    if (mecha.seats[0] != null)
      if ((mecha.seats[0]).looking != null) {
        pitch = (mecha.seats[0]).looking.getPitch();
        float dPitch = (mecha.seats[0]).looking.getPitch() - (mecha.seats[0]).prevLooking.getPitch();
        float f1 = (mecha.seats[0]).prevLooking.getPitch() + dPitch * f;
      } else if ((mecha.seats[0]).looking == null) {
        pitch = 0.0F;
      }  
    if (mecha.isPartIntact(EnumDriveablePart.barrel))
      for (ModelRendererTurbo aBarrelModel : this.barrelModel) {
        aBarrelModel.field_78808_h = -(pitch * 3.1415927F / 180.0F);
        aBarrelModel.render(f5, this.oldRotateOrder);
      }  
  }
  
  public void renderLeftArm(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.leftArmModel)
      model.func_78785_a(f5); 
  }
  
  public void renderLeftHand(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.leftHandModel)
      model.func_78785_a(f5); 
  }
  
  public void renderRightArm(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.rightArmModel)
      model.func_78785_a(f5); 
  }
  
  public void renderRightHand(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.rightHandModel)
      model.func_78785_a(f5); 
  }
  
  public void renderRightFoot(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.rightFootModel)
      model.func_78785_a(f5); 
  }
  
  public void renderLeftFoot(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.leftFootModel)
      model.func_78785_a(f5); 
  }
  
  public void renderRightLeg(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.rightLegModel)
      model.func_78785_a(f5); 
  }
  
  public void renderRightAnimLegUpper(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.rightAnimLegUpperModel)
      model.func_78785_a(f5); 
  }
  
  public void renderRightAnimLegLower(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.rightAnimLegLowerModel)
      model.func_78785_a(f5); 
  }
  
  public void renderRightAnimFoot(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.rightAnimFootModel)
      model.func_78785_a(f5); 
  }
  
  public void renderLeftAnimLegUpper(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.leftAnimLegUpperModel)
      model.func_78785_a(f5); 
  }
  
  public void renderLeftAnimLegLower(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.leftAnimLegLowerModel)
      model.func_78785_a(f5); 
  }
  
  public void renderLeftAnimFoot(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.leftAnimFootModel)
      model.func_78785_a(f5); 
  }
  
  public void renderLeftLeg(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.leftLegModel)
      model.func_78785_a(f5); 
  }
  
  public void renderHips(float f5, EntityMecha mecha, float f) {
    for (ModelRendererTurbo model : this.hipsModel)
      model.func_78785_a(f5); 
  }
  
  public void flipAll() {
    super.flipAll();
    flip(this.leftArmModel);
    flip(this.rightArmModel);
    flip(this.leftHandModel);
    flip(this.rightHandModel);
    flip(this.hipsModel);
    flip(this.leftLegModel);
    flip(this.rightLegModel);
    flip(this.leftAnimLegUpperModel);
    flip(this.rightAnimLegUpperModel);
    flip(this.leftAnimLegLowerModel);
    flip(this.rightAnimLegLowerModel);
    flip(this.leftAnimFootModel);
    flip(this.rightAnimFootModel);
    flip(this.leftFootModel);
    flip(this.rightFootModel);
    flip(this.headModel);
    flip(this.barrelModel);
  }
  
  public void translateAll(float x, float y, float z) {
    super.translateAll(x, y, z);
    translate(this.leftArmModel, x, y, z);
    translate(this.rightArmModel, x, y, z);
    translate(this.leftHandModel, x, y, z);
    translate(this.rightHandModel, x, y, z);
    translate(this.hipsModel, x, y, z);
    translate(this.leftLegModel, x, y, z);
    translate(this.rightLegModel, x, y, z);
    translate(this.leftFootModel, x, y, z);
    translate(this.rightFootModel, x, y, z);
    translate(this.leftAnimLegUpperModel, x, y, z);
    translate(this.rightAnimLegUpperModel, x, y, z);
    translate(this.leftAnimLegLowerModel, x, y, z);
    translate(this.rightAnimLegLowerModel, x, y, z);
    translate(this.leftAnimFootModel, x, y, z);
    translate(this.rightAnimFootModel, x, y, z);
    translate(this.headModel, x, y, z);
    translate(this.barrelModel, x, y, z);
  }
}
