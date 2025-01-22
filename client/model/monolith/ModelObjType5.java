package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelObjType5 extends ModelVehicle {
  int textureX = 84;
  
  int textureY = 101;
  
  public ModelObjType5() {
    this.bodyModel = new ModelRendererTurbo[1];
    this.turretModel = new ModelRendererTurbo[1];
    this.barrelModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initturretModel_1();
    initbarrelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 444, 174, this.textureX, this.textureY);
    this.bodyModel[0].addObj("/Tyrants and Plebeians/assets/flansmod/models/T5Hull.obj");
    this.bodyModel[0].func_78793_a(0.4F, 4.3F, -0.2F);
  }
  
  private void initturretModel_1() {
    this.turretModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.turretModel[0].addObj("/Tyrants and Plebeians/assets/flansmod/models/T5TurretFix.obj");
    this.turretModel[0].func_78793_a(0.0F, 5.15F, 0.0F);
  }
  
  private void initbarrelModel_1() {
    this.barrelModel[0] = new ModelRendererTurbo((ModelBase)this, 444, 174, this.textureX, this.textureY);
    this.barrelModel[0].addObj("/Tyrants and Plebeians/assets/flansmod/models/T5Barrelfix.obj");
    this.barrelModel[0].func_78793_a(0.5F, 1.7F, 0.0F);
  }
}
