package com.flansmod.client.model.norwegian;

import com.flansmod.client.model.ModelPlane;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelObjTest extends ModelPlane {
  public ModelObjTest() {
    int textureX = 256;
    int textureY = 128;
    this.bodyModel = new ModelRendererTurbo[1];
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.bodyModel[0].addObj("/Tyrants and Plebeians/assets/flansmod/models/Girl_Lili.obj");
    this.bodyModel[0].func_78793_a(3.5F, 2.0F, 0.0F);
    translateAll(-3.5F, -1.8F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (ModelRendererTurbo mrt : this.bodyModel)
      mrt.func_78785_a(1.0F); 
  }
}
