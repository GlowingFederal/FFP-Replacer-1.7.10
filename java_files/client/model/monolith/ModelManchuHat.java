package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelManchuHat extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 32;
  
  public ModelManchuHat() {
    this.headModel = new ModelRendererTurbo[7];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 89, 9, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 38, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -7.5F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 1.5F, 0.3F, 0.2F, 1.5F, 0.3F, 0.2F, 0.4F, 0.9F, 0.2F, 0.4F, 0.9F, 0.9F, -1.5F, 1.7F, 0.9F, -1.5F, 1.7F, 0.9F, 0.0F, 1.5F, 0.9F, 0.0F, 1.5F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -6.0F, -4.0F, 8, 2, 8, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -1.2F, 0.9F, 0.9F, -1.2F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-5.0F, -8.0F, -5.0F, 3, 3, 11, 0.0F, 0.9F, 0.0F, 1.5F, -0.5F, 1.0F, 1.5F, -0.5F, -1.2F, 1.0F, 0.9F, -2.0F, 1.0F, -0.1F, 0.0F, 0.9F, 0.0F, -0.2F, 0.9F, 0.0F, 1.7F, -0.1F, -0.1F, 2.0F, -0.1F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -13.5F, -4.0F, 8, 3, 8, 0.0F, -3.1F, -2.7F, -3.5F, -3.1F, -2.7F, -3.5F, -3.1F, -3.0F, -2.5F, -3.1F, -3.0F, -2.5F, 0.2F, 1.5F, 0.3F, 0.2F, 1.5F, 0.3F, 0.2F, 2.6F, 0.9F, 0.2F, 2.6F, 0.9F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(2.0F, -8.0F, -5.0F, 3, 3, 11, 0.0F, -0.5F, 1.0F, 1.5F, 0.9F, 0.0F, 1.5F, 0.9F, -2.0F, 1.0F, -0.5F, -1.2F, 1.0F, 0.0F, -0.2F, 0.9F, -0.1F, 0.0F, 0.9F, -0.1F, 2.0F, -0.1F, 0.0F, 1.7F, -0.1F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-1.5F, -8.0F, -5.0F, 3, 3, 11, 0.0F, 1.0F, 1.0F, 1.5F, 1.0F, 1.0F, 1.5F, 1.0F, -1.2F, 1.0F, 1.0F, -1.2F, 1.0F, 0.5F, -0.2F, 0.9F, 0.5F, -0.2F, 0.9F, 0.5F, 1.7F, -0.1F, 0.5F, 1.7F, -0.1F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-0.5F, -4.5F, 4.0F, 1, 8, 1, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
