package com.flansmod.client.model.mw;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelDeployableBag extends ModelBase {
  public ModelRendererTurbo[] bagModel;
  
  public ModelDeployableBag() {
    this.bagModel = new ModelRendererTurbo[2];
    this.bagModel[0] = new ModelRendererTurbo(this, 0, 0, 32, 32);
    this.bagModel[0].addShapeBox(-3.0F, 0.0F, -6.0F, 6, 6, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.1F, -1.0F, 0.0F);
    this.bagModel[1] = new ModelRendererTurbo(this, 0, 12, 32, 32);
    this.bagModel[1].addShapeBox(-3.0F, 0.0F, 0.0F, 6, 6, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (ModelRendererTurbo bagModelBit : this.bagModel)
      bagModelBit.func_78785_a(f5); 
  }
}
