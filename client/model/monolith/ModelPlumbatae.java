package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelPlumbatae extends ModelBase {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelRendererTurbo[] plumbataeModel;
  
  public ModelPlumbatae() {
    this.plumbataeModel = new ModelRendererTurbo[6];
    this.plumbataeModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.plumbataeModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
    this.plumbataeModel[2] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
    this.plumbataeModel[3] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
    this.plumbataeModel[4] = new ModelRendererTurbo(this, 9, 9, this.textureX, this.textureY);
    this.plumbataeModel[5] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
    this.plumbataeModel[0].addShapeBox(-0.5F, -6.5F, -0.5F, 1, 7, 1, 0.0F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F);
    this.plumbataeModel[0].func_78793_a(0.0F, -1.0F, 0.0F);
    this.plumbataeModel[1].addShapeBox(-0.5F, 4.5F, -0.5F, 1, 5, 1, 0.0F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F);
    this.plumbataeModel[1].func_78793_a(0.0F, -6.0F, 0.0F);
    this.plumbataeModel[2].addShapeBox(-0.5F, 4.5F, -0.5F, 1, 1, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F);
    this.plumbataeModel[2].func_78793_a(0.0F, -1.0F, 0.0F);
    this.plumbataeModel[3].addShapeBox(-0.5F, -0.5F, -0.5F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F);
    this.plumbataeModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.plumbataeModel[4].addShapeBox(-0.5F, -6.0F, -1.5F, 1, 3, 3, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F, -1.0F);
    this.plumbataeModel[4].func_78793_a(0.0F, -1.0F, 0.0F);
    this.plumbataeModel[5].addShapeBox(-1.5F, -6.0F, -0.5F, 3, 3, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F);
    this.plumbataeModel[5].func_78793_a(0.0F, -1.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 6; i++)
      this.plumbataeModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
