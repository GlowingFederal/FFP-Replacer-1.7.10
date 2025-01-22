package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelBallistaBolt extends ModelBase {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelRendererTurbo[] ballistaboltModel;
  
  public ModelBallistaBolt() {
    this.ballistaboltModel = new ModelRendererTurbo[2];
    this.ballistaboltModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.ballistaboltModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
    this.ballistaboltModel[0].addShapeBox(-0.5F, -25.0F, -0.5F, 1, 29, 1, 0.0F, 0.4F, 5.0F, 0.4F, 0.4F, 5.0F, 0.4F, 0.4F, 5.0F, 0.4F, 0.4F, 5.0F, 0.4F, 0.4F, 5.0F, 0.4F, 0.4F, 5.0F, 0.4F, 0.4F, 5.0F, 0.4F, 0.4F, 5.0F, 0.4F);
    this.ballistaboltModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.ballistaboltModel[1].addShapeBox(-0.5F, 9.0F, -0.5F, 1, 10, 1, 0.0F, 0.7F, 0.0F, 0.7F, 0.7F, 0.0F, 0.7F, 0.7F, 0.0F, 0.7F, 0.7F, 0.0F, 0.7F, -0.45F, 5.0F, -0.45F, -0.45F, 5.0F, -0.45F, -0.45F, 5.0F, -0.45F, 0.0F, 5.0F, -0.45F);
    this.ballistaboltModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 2; i++)
      this.ballistaboltModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
