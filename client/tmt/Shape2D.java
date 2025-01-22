package com.flansmod.client.tmt;

import java.util.ArrayList;
import java.util.Collections;
import net.minecraft.util.MathHelper;
import net.minecraft.util.Vec3;

public class Shape2D {
  public ArrayList<Coord2D> coords;
  
  public Shape2D() {
    this.coords = new ArrayList<>();
  }
  
  public Shape2D(Coord2D[] coordArray) {
    this.coords = new ArrayList<>();
    Collections.addAll(this.coords, coordArray);
  }
  
  public Shape2D(ArrayList<Coord2D> coordList) {
    this.coords = coordList;
  }
  
  public Coord2D[] getCoordArray() {
    return (Coord2D[])this.coords.toArray();
  }
  
  public Shape3D extrude(float x, float y, float z, float rotX, float rotY, float rotZ, float depth, int u, int v, float textureWidth, float textureHeight, int shapeTextureWidth, int shapeTextureHeight, int sideTextureWidth, int sideTextureHeight, float[] faceLengths) {
    PositionTransformVertex[] verts = new PositionTransformVertex[this.coords.size() * 2];
    PositionTransformVertex[] vertsTop = new PositionTransformVertex[this.coords.size()];
    PositionTransformVertex[] vertsBottom = new PositionTransformVertex[this.coords.size()];
    TexturedPolygon[] poly = new TexturedPolygon[this.coords.size() + 2];
    Vec3 extrudeVector = Vec3.func_72443_a(0.0D, 0.0D, depth);
    setVectorRotations(extrudeVector, rotX, rotY, rotZ);
    if (faceLengths != null && faceLengths.length < this.coords.size())
      faceLengths = null; 
    float totalLength = 0.0F;
    for (int idx = 0; idx < this.coords.size(); idx++) {
      Coord2D curCoord = this.coords.get(idx);
      Coord2D nextCoord = this.coords.get((idx + 1) % this.coords.size());
      float texU1 = (curCoord.uCoord + u) / textureWidth;
      float texU2 = (shapeTextureWidth * 2 - curCoord.uCoord + u) / textureWidth;
      float texV = (curCoord.vCoord + v) / textureHeight;
      Vec3 vecCoord = Vec3.func_72443_a(curCoord.xCoord, curCoord.yCoord, 0.0D);
      setVectorRotations(vecCoord, rotX, rotY, rotZ);
      verts[idx] = new PositionTransformVertex(x + (float)vecCoord.field_72450_a, y + (float)vecCoord.field_72448_b, z + (float)vecCoord.field_72449_c, texU1, texV);
      verts[idx + this.coords.size()] = new PositionTransformVertex(x + (float)vecCoord.field_72450_a - (float)extrudeVector.field_72450_a, y + (float)vecCoord.field_72448_b - (float)extrudeVector.field_72448_b, z + (float)vecCoord.field_72449_c - (float)extrudeVector.field_72449_c, texU2, texV);
      vertsTop[idx] = new PositionTransformVertex(verts[idx]);
      vertsBottom[this.coords.size() - idx - 1] = new PositionTransformVertex(verts[idx + this.coords.size()]);
      if (faceLengths != null) {
        totalLength += faceLengths[idx];
      } else {
        totalLength = (float)(totalLength + Math.sqrt(Math.pow(curCoord.xCoord - nextCoord.xCoord, 2.0D) + Math.pow(curCoord.yCoord - nextCoord.yCoord, 2.0D)));
      } 
    } 
    poly[this.coords.size()] = new TexturedPolygon((PositionTextureVertex[])vertsTop);
    poly[this.coords.size() + 1] = new TexturedPolygon((PositionTextureVertex[])vertsBottom);
    float currentLengthPosition = totalLength;
    for (int i = 0; i < this.coords.size(); i++) {
      Coord2D curCoord = this.coords.get(i);
      Coord2D nextCoord = this.coords.get((i + 1) % this.coords.size());
      float currentLength = (float)Math.sqrt(Math.pow(curCoord.xCoord - nextCoord.xCoord, 2.0D) + Math.pow(curCoord.yCoord - nextCoord.yCoord, 2.0D));
      if (faceLengths != null)
        currentLength = faceLengths[faceLengths.length - i - 1]; 
      float ratioPosition = currentLengthPosition / totalLength;
      float ratioLength = (currentLengthPosition - currentLength) / totalLength;
      float texU1 = (ratioLength * sideTextureWidth + u) / textureWidth;
      float texU2 = (ratioPosition * sideTextureWidth + u) / textureWidth;
      float texV1 = (v + shapeTextureHeight) / textureHeight;
      float texV2 = (v + shapeTextureHeight + sideTextureHeight) / textureHeight;
      PositionTransformVertex[] polySide = new PositionTransformVertex[4];
      polySide[0] = new PositionTransformVertex(verts[i], texU2, texV1);
      polySide[1] = new PositionTransformVertex(verts[this.coords.size() + i], texU2, texV2);
      polySide[2] = new PositionTransformVertex(verts[this.coords.size() + (i + 1) % this.coords.size()], texU1, texV2);
      polySide[3] = new PositionTransformVertex(verts[(i + 1) % this.coords.size()], texU1, texV1);
      poly[i] = new TexturedPolygon((PositionTextureVertex[])polySide);
      currentLengthPosition -= currentLength;
    } 
    return new Shape3D(verts, poly);
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
