package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModeliranHeadband extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 32;
  
  public ModeliranHeadband() {
    this.headModel = new ModelRendererTurbo[4];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -6.5F, -4.0F, 8, 2, 8, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -2.0F, 0.1F, 0.1F, -2.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 1.0F, 0.1F, 0.1F, 1.0F, 0.1F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-0.2F, -4.5F, 4.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, -1.0F, -1.5F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 2.0F, -1.5F, -1.5F, 2.0F, -1.5F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-0.8F, -4.5F, 4.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 2.0F, -1.5F, 1.0F, 2.0F, -1.5F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-17.0F, -14.5F, -4.1F, 34, 18, 1, 0.0F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
