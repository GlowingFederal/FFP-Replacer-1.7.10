package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelARCrepeaterLaser extends ModelBase {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelRendererTurbo[] arcrepeaterlaserModel;
  
  public ModelARCrepeaterLaser() {
    this.arcrepeaterlaserModel = new ModelRendererTurbo[6];
    this.arcrepeaterlaserModel[0] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterlaserModel[1] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterlaserModel[2] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterlaserModel[3] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterlaserModel[4] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterlaserModel[5] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterlaserModel[0].addShapeBox(-0.5F, 0.0F, -0.5F, 1, 11, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcrepeaterlaserModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterlaserModel[1].addShapeBox(-0.5F, 11.0F, -0.5F, 1, 11, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F);
    this.arcrepeaterlaserModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterlaserModel[2].addShapeBox(-1.5F, 22.0F, -1.5F, 1, 6, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 2.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, -2.0F, 0.0F, 2.0F);
    this.arcrepeaterlaserModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterlaserModel[3].addShapeBox(0.5F, 28.0F, 0.5F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 3.0F, -2.0F, 0.0F, 3.0F, -2.0F, 0.0F, -3.0F, 2.0F, 0.0F, -3.0F);
    this.arcrepeaterlaserModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterlaserModel[4].addShapeBox(-1.5F, 35.0F, -2.5F, 1, 11, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, 2.0F, 0.0F, -2.0F, 2.0F, 0.0F, 2.0F, -2.0F, 0.0F, 2.0F);
    this.arcrepeaterlaserModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterlaserModel[5].addShapeBox(-0.5F, 46.0F, -0.5F, 1, 11, 1, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcrepeaterlaserModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 6; i++)
      this.arcrepeaterlaserModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
