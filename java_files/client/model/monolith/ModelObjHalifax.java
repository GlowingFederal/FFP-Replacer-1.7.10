package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelObjHalifax extends ModelVehicle {
  int textureX = 84;
  
  int textureY = 101;
  
  public ModelObjHalifax() {
    this.bodyModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 444, 174, this.textureX, this.textureY);
    this.bodyModel[0].addObj("/Tyrants and Plebeians/assets/flansmod/models/Halifax3.obj");
    this.bodyModel[0].func_78793_a(0.0F, -0.3F, 0.0F);
  }
}
