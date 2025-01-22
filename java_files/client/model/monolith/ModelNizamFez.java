package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelNizamFez extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelNizamFez() {
    this.headModel = new ModelRendererTurbo[10];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -6.0F, -4.0F, 8, 2, 8, 0.0F, 0.2F, 1.5F, 0.3F, 0.2F, 1.5F, 0.3F, 0.2F, 0.9F, 0.7F, 0.2F, 0.9F, 0.7F, 0.1F, -1.5F, 0.5F, 0.1F, -1.5F, 0.5F, 0.1F, -0.6F, 0.3F, 0.1F, -0.6F, 0.3F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -2.0F, -4.5F, 4, 1, 1, 0.0F, 0.0F, -1.0F, -0.3F, -1.0F, 0.5F, -0.3F, -1.0F, 0.5F, -0.3F, 0.0F, -1.0F, -0.3F, -2.5F, -0.3F, -0.3F, 0.2F, -1.0F, -0.3F, 0.2F, -1.0F, -0.3F, -2.5F, -0.3F, -0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(0.0F, -2.0F, -4.5F, 4, 1, 1, 0.0F, -1.0F, 0.5F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F, -1.0F, -0.3F, -1.0F, 0.5F, -0.3F, 0.2F, -1.0F, -0.3F, -2.5F, -0.3F, -0.3F, -2.5F, -0.3F, -0.3F, 0.2F, -1.0F, -0.3F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-3.0F, -5.0F, -4.0F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.3F, 0.2F, 0.2F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(1.0F, -5.0F, -4.0F, 2, 1, 1, 0.0F, 0.0F, -0.5F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.5F, 0.2F, 0.4F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.0F, -12.0F, -4.0F, 8, 4, 8, 0.0F, 0.5F, 0.4F, 0.2F, 0.3F, 0.6F, 0.2F, 0.5F, -0.5F, 1.7F, 0.4F, -0.7F, 1.6F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 1.1F, 0.7F, 0.2F, 1.1F, 0.7F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-3.0F, -11.0F, 6.0F, 4, 5, 2, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, -0.4F, 1.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-3.0F, -13.0F, 0.0F, 4, 1, 8, 0.0F, -1.5F, 0.0F, -2.0F, 1.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, -1.0F, 0.0F, -2.0F, -0.5F, 0.5F, 0.2F, 2.0F, 0.5F, 0.2F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, -0.4F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-4.5F, -6.0F, 5.5F, 6, 3, 2, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -1.0F, 0.5F, -0.5F, -0.5F, 0.5F, -0.5F, -0.5F, 0.5F, 0.8F, -1.0F, 0.5F, 0.8F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.0F, -2.5F, 5.5F, 5, 2, 2, 0.0F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.8F, -0.5F, 0.0F, 0.8F, -1.5F, 0.5F, -2.3F, -1.0F, 0.5F, -2.3F, -1.0F, 0.0F, 1.8F, -1.5F, 0.0F, 1.8F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
