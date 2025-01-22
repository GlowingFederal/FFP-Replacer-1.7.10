package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelTonkyogasa extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelTonkyogasa() {
    this.headModel = new ModelRendererTurbo[11];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 12, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 28, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 37, 6, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 43, 11, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 54, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 28, 13, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 45, 25, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 32, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 43, 11, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 54, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.5F, -8.0F, -4.5F, 9, 3, 9, 0.0F, -0.2F, 0.2F, -0.5F, -0.2F, 0.2F, -0.5F, -0.2F, -0.5F, 0.2F, -0.2F, -0.5F, 0.2F, 0.4F, -0.4F, 1.0F, 0.4F, -0.4F, 1.0F, 0.4F, 1.0F, 0.8F, 0.4F, 1.0F, 0.8F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.5F, -14.0F, -4.5F, 9, 6, 9, 0.0F, -4.4F, 0.0F, -7.0F, -4.4F, 0.0F, -7.0F, -4.4F, 0.0F, -1.9F, -4.4F, 0.0F, -1.9F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, 0.5F, 0.2F, -0.2F, 0.5F, 0.2F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-5.0F, -6.0F, -8.5F, 10, 1, 3, 0.0F, -2.5F, -0.9F, -1.3F, -2.5F, -0.9F, -1.3F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -2.0F, 1.0F, 0.1F, -2.0F, 1.0F, 0.1F, 0.3F, 0.5F, -0.1F, 0.3F, 0.5F, -0.1F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-5.0F, -6.0F, -5.5F, 10, 1, 3, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, 0.0F, 0.7F, -0.5F, 0.0F, 0.7F, 0.3F, 0.5F, 0.1F, 0.3F, 0.5F, 0.1F, -2.0F, 0.0F, 4.3F, -2.0F, 0.0F, 4.3F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(3.5F, -4.0F, -4.5F, 1, 4, 9, 0.0F, -0.6F, 1.3F, 0.0F, 0.4F, 1.3F, 0.0F, 0.4F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, -1.5F, -0.5F, -1.8F, 1.4F, -1.1F, -1.8F, 1.2F, 0.0F, -1.5F, -1.2F, 0.6F, -1.5F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(0.0F, -3.0F, 3.5F, 4, 3, 1, 0.0F, 1.0F, 1.0F, -1.8F, 0.9F, 1.0F, -1.8F, 0.4F, -1.0F, 0.8F, -1.0F, -2.0F, 0.8F, -4.7F, 0.6F, 0.5F, 1.7F, 0.0F, 0.5F, 0.8F, -0.5F, 0.2F, -3.0F, 0.2F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.0F, -1.3F, -4.3F, 8, 1, 2, 0.0F, 0.0F, -0.5F, -0.1F, 0.0F, -0.5F, -0.1F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-4.0F, -4.5F, -2.5F, 8, 5, 1, 0.0F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F, 0.3F, -0.2F, 0.8F, 0.3F, -0.2F, 0.8F, 0.3F, -0.2F, -0.7F, 0.3F, -0.3F, -0.7F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-15.0F, -23.5F, -5.6F, 30, 30, 1, 0.0F, -13.0F, -13.0F, -3.9F, -13.0F, -13.0F, -3.9F, -13.0F, -13.0F, 4.0F, -13.0F, -13.0F, 4.0F, -13.0F, -14.0F, -0.7F, -13.0F, -14.0F, -0.7F, -13.0F, -14.0F, 0.0F, -13.0F, -14.0F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.5F, -4.0F, -4.5F, 1, 4, 9, 0.0F, 0.4F, 1.3F, 0.0F, -0.6F, 1.3F, 0.0F, 0.0F, 0.0F, 0.8F, 0.4F, 0.0F, 0.8F, 1.4F, -1.1F, -1.8F, -1.5F, -0.5F, -1.8F, -1.2F, 0.6F, -1.5F, 1.2F, 0.0F, -1.5F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-4.0F, -3.0F, 3.5F, 4, 3, 1, 0.0F, 0.9F, 1.0F, -1.8F, 1.0F, 1.0F, -1.8F, -1.0F, -2.0F, 0.8F, 0.4F, -1.0F, 0.8F, 1.7F, 0.0F, 0.5F, -4.7F, 0.6F, 0.5F, -3.0F, 0.2F, 0.0F, 0.8F, -0.5F, 0.2F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
