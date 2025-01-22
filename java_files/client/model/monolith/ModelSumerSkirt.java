package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSumerSkirt extends ModelCustomArmour {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelSumerSkirt() {
    this.bodyModel = new ModelRendererTurbo[1];
    this.skirtFrontModel = new ModelRendererTurbo[1];
    this.skirtRearModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initskirtFrontModel_1();
    initskirtRearModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 9.8F, -2.0F, 8, 10, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.8F, 0.2F, 0.8F, 0.8F, 0.2F, 0.8F, 0.8F, 0.2F, 0.8F, 0.8F, 0.2F, 0.8F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, -2.2F, -2.2F, 8, 10, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.2F, 0.8F, 0.0F, 0.2F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-4.0F, -2.2F, -1.8F, 8, 10, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.8F, 0.0F, 0.2F, 0.8F, 0.0F, 0.2F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
