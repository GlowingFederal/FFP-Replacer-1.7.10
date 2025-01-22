package com.flansmod.client.tmt;

import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class TransformGroupBone extends TransformGroup {
  protected Angle3D baseAngles;
  
  protected Vec3 baseVector;
  
  protected Bone attachedBone;
  
  protected double weight;
  
  public TransformGroupBone(Bone bone, double wght) {
    this.baseVector = bone.getPosition();
    this.baseAngles = bone.getAbsoluteAngle();
    this.attachedBone = bone;
    this.weight = wght;
  }
  
  public Angle3D getBaseAngles() {
    return this.baseAngles.copy();
  }
  
  public Angle3D getTransformAngle() {
    Angle3D returnAngle = this.attachedBone.getAbsoluteAngle().copy();
    returnAngle.angleX -= this.baseAngles.angleX;
    returnAngle.angleY -= this.baseAngles.angleY;
    returnAngle.angleZ -= this.baseAngles.angleZ;
    return returnAngle;
  }
  
  public Vec3 getBaseVector() {
    return Vec3.func_72443_a(this.baseVector.field_72450_a, this.baseVector.field_72448_b, this.baseVector.field_72449_c);
  }
  
  public Vec3 getTransformVector() {
    return this.baseVector.func_72444_a(this.attachedBone.getPosition());
  }
  
  public Vec3 getCurrentVector() {
    return this.attachedBone.getPosition();
  }
  
  public double getWeight() {
    return this.weight;
  }
  
  public void attachBone(Bone bone) {
    this.baseVector = bone.getPosition();
    this.baseAngles = bone.getAbsoluteAngle();
    this.attachedBone = bone;
  }
  
  public Vec3 doTransformation(PositionTransformVertex vertex) {
    Vec3 vector = Vec3.func_72443_a(vertex.neutralVector.field_72450_a, vertex.neutralVector.field_72448_b, vertex.neutralVector.field_72449_c);
    vector = getBaseVector().func_72444_a(vector);
    Angle3D angle = getTransformAngle();
    setVectorRotations(vector, angle.angleX, angle.angleY, angle.angleZ);
    return vector;
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
}
