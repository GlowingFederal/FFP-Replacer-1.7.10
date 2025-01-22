package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelGustavCat extends ModelVehicle {
  int textureX = 690;
  
  int textureY = 550;
  
  public ModelGustavCat() {
    this.bodyModel = new ModelRendererTurbo[1];
    this.barrelModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initbarrelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.bodyModel[0].addObj("/Tyrants and Plebeians/assets/flansmod/models/GustavBodyFix.obj");
    this.bodyModel[0].func_78793_a(0.0F, -0.5F, 0.0F);
  }
  
  private void initbarrelModel_1() {
    this.barrelModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.barrelModel[0].addObj("/Tyrants and Plebeians/assets/flansmod/models/GustavBarrelFix.obj");
    this.barrelModel[0].func_78793_a(0.0F, 9.0F, 0.0F);
  }
}
