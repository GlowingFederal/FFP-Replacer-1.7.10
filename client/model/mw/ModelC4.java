package com.flansmod.client.model.mw;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelC4 extends ModelBase {
  public ModelRendererTurbo[] c4Model;
  
  public ModelC4() {
    this.c4Model = new ModelRendererTurbo[2];
    this.c4Model[0] = new ModelRendererTurbo(this, 0, 0, 32, 8);
    this.c4Model[0].addBox(-2.0F, 0.0F, -3.0F, 4, 2, 6);
    this.c4Model[1] = new ModelRendererTurbo(this, 20, 0, 32, 8);
    this.c4Model[1].addBox(-1.0F, 1.5F, -2.0F, 2, 1, 4);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (ModelRendererTurbo mineModelBit : this.c4Model)
      mineModelBit.func_78785_a(f5); 
  }
}
