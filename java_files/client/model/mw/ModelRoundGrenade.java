package com.flansmod.client.model.mw;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelRoundGrenade extends ModelBase {
  public ModelRendererTurbo headModel;
  
  public ModelRendererTurbo bodyModel;
  
  public ModelRoundGrenade() {
    this.bodyModel = new ModelRendererTurbo(this, 0, 0, 16, 8);
    this.bodyModel.addBox(-1.0F, -1.0F, -1.0F, 2, 2, 2);
    this.headModel = new ModelRendererTurbo(this, 8, 0, 16, 8);
    this.headModel.addBox(-0.5F, -0.5F, 0.5F, 1, 1, 1);
    this.bodyModel.field_78795_f = -1.5707964F;
    this.headModel.field_78795_f = -1.5707964F;
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    this.headModel.func_78785_a(f5);
    this.bodyModel.func_78785_a(f5);
  }
}
