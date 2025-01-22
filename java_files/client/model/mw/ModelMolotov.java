package com.flansmod.client.model.mw;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelMolotov extends ModelBase {
  public ModelRendererTurbo neckModel;
  
  public ModelRendererTurbo bodyModel;
  
  public ModelRendererTurbo clothModel;
  
  public ModelMolotov() {
    this.bodyModel = new ModelRendererTurbo(this, 0, 0, 32, 16);
    this.bodyModel.addBox(-1.0F, -2.0F, -1.0F, 2, 4, 2);
    this.neckModel = new ModelRendererTurbo(this, 8, 0, 32, 16);
    this.neckModel.addBox(-0.5F, 2.0F, -0.5F, 1, 2, 1);
    this.clothModel = new ModelRendererTurbo(this, 0, 6, 32, 16);
    this.clothModel.addShapeBox(-1.0F, -0.5F, -0.5F, 2, 1, 5, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.clothModel.func_78793_a(0.0F, 4.0F, 0.0F);
    this.clothModel.field_78795_f = 1.0F;
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.neckModel.func_78785_a(f5);
    this.bodyModel.func_78785_a(f5);
    this.clothModel.func_78785_a(f5);
  }
}
