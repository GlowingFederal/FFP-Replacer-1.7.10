package com.flansmod.client.tmt;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Bone {
  protected Angle3D neutralAngles;
  
  public Angle3D relativeAngles;
  
  protected Angle3D absoluteAngles;
  
  private Vec3 positionVector;
  
  private float length;
  
  private Bone parentNode;
  
  protected ArrayList<Bone> childNodes;
  
  private ArrayList<ModelRenderer> models;
  
  private Map<ModelRenderer, Angle3D> modelBaseRot;
  
  private float offsetX;
  
  private float offsetY;
  
  private float offsetZ;
  
  public Bone(float x, float y, float z, float l) {
    this.neutralAngles = new Angle3D(x, y, z);
    this.relativeAngles = new Angle3D(0.0F, 0.0F, 0.0F);
    this.absoluteAngles = new Angle3D(0.0F, 0.0F, 0.0F);
    this.positionVector = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
    this.length = l;
    this.childNodes = new ArrayList<>();
    this.models = new ArrayList<>();
    this.modelBaseRot = new HashMap<>();
    this.parentNode = null;
    this.offsetX = 0.0F;
    this.offsetY = 0.0F;
    this.offsetZ = 0.0F;
    this.positionVector = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
  }
  
  public Bone(float xOrig, float yOrig, float zOrig, float xRot, float yRot, float zRot, float l) {
    this(xRot, yRot, zRot, l);
    this.positionVector = setOffset(xOrig, yOrig, zOrig);
  }
  
  public Bone(float x, float y, float z, float l, Bone parent) {
    this(x, y, z, l);
    attachBone(parent);
  }
  
  public void detachBone() {
    this.parentNode.childNodes.remove(this);
    this.parentNode = null;
  }
  
  public void attachBone(Bone parent) {
    if (this.parentNode != null)
      detachBone(); 
    this.parentNode = parent;
    parent.addChildBone(this);
    this.offsetX = parent.offsetX;
    this.offsetY = parent.offsetY;
    this.offsetZ = parent.offsetZ;
    resetOffset();
  }
  
  public Vec3 setOffset(float x, float y, float z) {
    if (this.parentNode != null) {
      Vec3 vector = this.parentNode.setOffset(x, y, z);
      this.offsetX = (float)vector.field_72450_a;
      this.offsetY = (float)vector.field_72448_b;
      this.offsetZ = (float)vector.field_72449_c;
      return vector;
    } 
    this.offsetX = x;
    this.offsetY = y;
    this.offsetZ = z;
    resetOffset(true);
    return Vec3.func_72443_a(x, y, z);
  }
  
  public void resetOffset() {
    resetOffset(false);
  }
  
  public void resetOffset(boolean doRecursive) {
    if (this.parentNode != null) {
      this.positionVector = Vec3.func_72443_a(0.0D, 0.0D, this.parentNode.length);
      this.parentNode.setVectorRotations(this.positionVector);
      this.positionVector.field_72450_a += this.parentNode.positionVector.field_72450_a;
      this.positionVector.field_72448_b += this.parentNode.positionVector.field_72448_b;
      this.positionVector.field_72449_c += this.parentNode.positionVector.field_72449_c;
    } 
    if (doRecursive && !this.childNodes.isEmpty())
      for (Bone childNode : this.childNodes)
        childNode.resetOffset(doRecursive);  
  }
  
  public void setNeutralRotation(float x, float y, float z) {
    this.neutralAngles.angleX = x;
    this.neutralAngles.angleY = y;
    this.neutralAngles.angleZ = z;
  }
  
  public Bone getRootParent() {
    if (this.parentNode == null)
      return this; 
    return this.parentNode.getRootParent();
  }
  
  public void addModel(ModelRenderer model) {
    addModel(model, false);
  }
  
  public void addModel(ModelRenderer model, boolean inherit) {
    addModel(model, 0.0F, 0.0F, 0.0F, inherit);
  }
  
  public void addModel(ModelRenderer model, boolean inherit, boolean isUpright) {
    addModel(model, 0.0F, 0.0F, 0.0F, inherit, isUpright);
  }
  
  public void addModel(ModelRenderer model, float x, float y, float z) {
    addModel(model, x, y, z, false);
  }
  
  public void addModel(ModelRenderer model, float x, float y, float z, boolean inherit) {
    addModel(model, x, y, z, inherit, false);
  }
  
  public void addModel(ModelRenderer model, float x, float y, float z, boolean inherit, boolean isUpright) {
    if (inherit) {
      x += this.neutralAngles.angleX + (isUpright ? 1.5707964F : 0.0F);
      y += this.neutralAngles.angleY;
      z += this.neutralAngles.angleZ;
    } 
    this.models.add(model);
    this.modelBaseRot.put(model, new Angle3D(x, y, z));
  }
  
  public void removeModel(ModelRenderer model) {
    this.models.remove(model);
    this.modelBaseRot.remove(model);
  }
  
  public Angle3D getAbsoluteAngle() {
    return new Angle3D(this.absoluteAngles.angleX, this.absoluteAngles.angleY, this.absoluteAngles.angleZ);
  }
  
  public Vec3 getPosition() {
    return Vec3.func_72443_a(this.positionVector.field_72450_a, this.positionVector.field_72448_b, this.positionVector.field_72449_c);
  }
  
  protected void addChildBone(Bone bone) {
    this.childNodes.add(bone);
  }
  
  public void prepareDraw() {
    if (this.parentNode != null) {
      this.parentNode.prepareDraw();
    } else {
      setAbsoluteRotations();
      setVectors();
    } 
  }
  
  public void setRotations(float x, float y, float z) {
    this.relativeAngles.angleX = x;
    this.relativeAngles.angleY = y;
    this.relativeAngles.angleZ = z;
  }
  
  protected void setAbsoluteRotations() {
    this.absoluteAngles.angleX = this.relativeAngles.angleX;
    this.absoluteAngles.angleY = this.relativeAngles.angleY;
    this.absoluteAngles.angleZ = this.relativeAngles.angleZ;
    for (Bone childNode : this.childNodes)
      childNode.setAbsoluteRotations(this.absoluteAngles.angleX, this.absoluteAngles.angleY, this.absoluteAngles.angleZ); 
  }
  
  protected void setAbsoluteRotations(float x, float y, float z) {
    this.relativeAngles.angleX += x;
    this.relativeAngles.angleY += y;
    this.relativeAngles.angleZ += z;
    for (Bone childNode : this.childNodes)
      childNode.setAbsoluteRotations(this.absoluteAngles.angleX, this.absoluteAngles.angleY, this.absoluteAngles.angleZ); 
  }
  
  protected void setVectorRotations(Vec3 vector) {
    float x = this.neutralAngles.angleX + this.absoluteAngles.angleX;
    float y = this.neutralAngles.angleY + this.absoluteAngles.angleY;
    float z = this.neutralAngles.angleZ + this.absoluteAngles.angleZ;
    setVectorRotations(vector, x, y, z);
  }
  
  protected void setVectorRotations(Vec3 vector, float xRot, float yRot, float zRot) {
    float x = xRot;
    float y = yRot;
    float z = zRot;
    float xC = MathHelper.func_76134_b(x);
    float xS = MathHelper.func_76126_a(x);
    float yC = MathHelper.func_76134_b(y);
    float yS = MathHelper.func_76126_a(y);
    float zC = MathHelper.func_76134_b(z);
    float zS = MathHelper.func_76126_a(z);
    double xVec = vector.field_72450_a;
    double yVec = vector.field_72448_b;
    double zVec = vector.field_72449_c;
    double xy = xC * yVec - xS * zVec;
    double xz = xC * zVec + xS * yVec;
    double yz = yC * xz - yS * xVec;
    double yx = yC * xVec + yS * xz;
    double zx = zC * yx - zS * xy;
    double zy = zC * xy + zS * yx;
    xVec = zx;
    yVec = zy;
    zVec = yz;
    vector.field_72450_a = xVec;
    vector.field_72448_b = yVec;
    vector.field_72449_c = zVec;
  }
  
  public void setParent(Bone parent) {
    attachBone(parent);
  }
  
  protected void addVector(Vec3 destVec, Vec3 srcVec) {
    destVec.field_72450_a += srcVec.field_72450_a;
    destVec.field_72448_b += srcVec.field_72448_b;
    destVec.field_72449_c += srcVec.field_72449_c;
  }
  
  protected void setVectors() {
    Vec3 tempVec = Vec3.func_72443_a(0.0D, 0.0D, this.length);
    this.positionVector = Vec3.func_72443_a(this.offsetX, this.offsetY, this.offsetZ);
    addVector(tempVec, this.positionVector);
    setVectorRotations(tempVec);
    for (Bone childNode : this.childNodes)
      childNode.setVectors(tempVec); 
  }
  
  protected void setVectors(Vec3 vector) {
    this.positionVector = vector;
    Vec3 tempVec = Vec3.func_72443_a(0.0D, 0.0D, this.length);
    setVectorRotations(tempVec);
    addVector(tempVec, vector);
    for (Bone childNode : this.childNodes)
      childNode.setVectors(tempVec); 
  }
  
  public void setAnglesToModels() {
    for (ModelRenderer currentModel : this.models) {
      Angle3D baseAngles = this.modelBaseRot.get(currentModel);
      currentModel.field_78795_f = baseAngles.angleX + this.absoluteAngles.angleX;
      currentModel.field_78796_g = baseAngles.angleY + this.absoluteAngles.angleY;
      currentModel.field_78808_h = baseAngles.angleZ + this.absoluteAngles.angleZ;
      currentModel.field_78800_c = (float)this.positionVector.field_72450_a;
      currentModel.field_78797_d = (float)this.positionVector.field_72448_b;
      currentModel.field_78798_e = (float)this.positionVector.field_72449_c;
    } 
    for (Bone childNode : this.childNodes)
      childNode.setAnglesToModels(); 
  }
}
