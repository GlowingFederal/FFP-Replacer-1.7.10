package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelThaiPeakedHat extends ModelCustomArmour {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelThaiPeakedHat() {
    this.headModel = new ModelRendererTurbo[4];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 21, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 11, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -5.5F, -3.9F, 8, 2, 8, 0.0F, 0.4F, 1.7F, 0.4F, 0.4F, 1.7F, 0.4F, 0.4F, 0.7F, 0.5F, 0.4F, 0.7F, 0.5F, 0.5F, -1.5F, 0.3F, 0.5F, -1.5F, 0.3F, 0.5F, -0.7F, 0.1F, 0.5F, -0.7F, 0.1F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -9.5F, -3.9F, 8, 2, 8, 0.0F, 1.2F, -0.2F, 1.5F, 1.2F, -0.2F, 1.5F, 1.2F, -1.5F, 2.0F, 1.2F, -1.5F, 2.0F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F, 0.4F, 0.4F, 1.3F, 0.5F, 0.4F, 1.3F, 0.5F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -9.2F, -3.9F, 8, 1, 8, 0.0F, -0.3F, 1.1F, -0.7F, -0.3F, 1.1F, -0.7F, -0.3F, 0.5F, -0.2F, -0.3F, 0.5F, -0.2F, 1.2F, -1.1F, 1.5F, 1.2F, -1.1F, 1.5F, 1.2F, 0.2F, 2.0F, 1.2F, 0.2F, 2.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -6.0F, -7.0F, 8, 1, 3, 0.0F, -2.5F, -0.5F, -0.3F, -2.5F, -0.5F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.3F, -2.0F, 0.0F, 0.3F, 0.5F, 0.0F, -0.1F, 0.5F, 0.0F, -0.1F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
