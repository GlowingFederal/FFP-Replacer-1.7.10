package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelObjKongo extends ModelVehicle {
  int textureX = 1024;
  
  int textureY = 1024;
  
  public ModelObjKongo() {
    this.bodyModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 444, 174, this.textureX, this.textureY);
    this.bodyModel[0].addObj("/Tyrants and Plebeians/assets/flansmod/models/kongonogun2.obj");
    this.bodyModel[0].func_78793_a(0.0F, -0.3F, 0.0F);
  }
}
