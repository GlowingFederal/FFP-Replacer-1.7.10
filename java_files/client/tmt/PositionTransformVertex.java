package com.flansmod.client.tmt;

import java.util.ArrayList;
import net.minecraft.util.Vec3;

public class PositionTransformVertex extends PositionTextureVertex {
  public Vec3 neutralVector;
  
  public ArrayList<TransformGroup> transformGroups;
  
  public PositionTransformVertex(float x, float y, float z, float u, float v) {
    this(Vec3.func_72443_a(x, y, z), u, v);
  }
  
  public PositionTransformVertex(PositionTextureVertex vertex, float u, float v) {
    super(vertex, u, v);
    this.transformGroups = new ArrayList<>();
    if (vertex instanceof PositionTransformVertex) {
      this.neutralVector = ((PositionTransformVertex)vertex).neutralVector;
    } else {
      this.neutralVector = Vec3.func_72443_a(vertex.field_78243_a.field_72450_a, vertex.field_78243_a.field_72448_b, vertex.field_78243_a.field_72449_c);
    } 
  }
  
  public PositionTransformVertex(PositionTextureVertex vertex) {
    this(vertex, vertex.field_78241_b, vertex.field_78242_c);
  }
  
  public PositionTransformVertex(Vec3 vector, float u, float v) {
    super(vector, u, v);
    this.transformGroups = new ArrayList<>();
    this.neutralVector = Vec3.func_72443_a(vector.field_72450_a, vector.field_72448_b, vector.field_72449_c);
  }
  
  public void setTransformation() {
    if (this.transformGroups.size() == 0) {
      this.field_78243_a.field_72450_a = this.neutralVector.field_72450_a;
      this.field_78243_a.field_72448_b = this.neutralVector.field_72448_b;
      this.field_78243_a.field_72449_c = this.neutralVector.field_72449_c;
      return;
    } 
    double weight = 0.0D;
    for (TransformGroup transformGroup : this.transformGroups)
      weight += transformGroup.getWeight(); 
    this.field_78243_a.field_72450_a = 0.0D;
    this.field_78243_a.field_72448_b = 0.0D;
    this.field_78243_a.field_72449_c = 0.0D;
    for (TransformGroup group : this.transformGroups) {
      double cWeight = group.getWeight() / weight;
      Vec3 vector = group.doTransformation(this);
      this.field_78243_a.field_72450_a += cWeight * vector.field_72450_a;
      this.field_78243_a.field_72448_b += cWeight * vector.field_72448_b;
      this.field_78243_a.field_72449_c += cWeight * vector.field_72449_c;
    } 
  }
  
  public void addGroup(TransformGroup group) {
    this.transformGroups.add(group);
  }
  
  public void removeGroup(TransformGroup group) {
    this.transformGroups.remove(group);
  }
}
