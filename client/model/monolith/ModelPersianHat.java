package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPersianHat extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelPersianHat() {
    this.headModel = new ModelRendererTurbo[19];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 57, 41, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 81, 41, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 105, 41, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -5.3F, -4.0F, 8, 1, 8, 0.0F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.3F, -0.3F, 0.3F, 0.3F, -0.3F, 0.3F, 0.3F, -0.3F, 0.3F, 0.3F, -0.3F, 0.3F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -6.1F, -4.0F, 8, 1, 8, 0.0F, 1.0F, -0.2F, 1.0F, 1.0F, -0.2F, 1.0F, 1.0F, -0.2F, 1.0F, 1.0F, -0.2F, 1.0F, 0.8F, -0.2F, 0.8F, 0.8F, -0.2F, 0.8F, 0.8F, -0.2F, 0.8F, 0.8F, -0.2F, 0.8F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -6.9F, -4.0F, 8, 1, 8, 0.0F, 1.3F, 0.3F, 1.3F, 1.3F, 0.3F, 1.3F, 1.3F, 0.3F, 1.3F, 1.3F, 0.3F, 1.3F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -8.2F, -4.0F, 8, 1, 8, 0.0F, 1.2F, 0.0F, 1.2F, 1.2F, 0.0F, 1.2F, 1.2F, 0.0F, 1.2F, 1.2F, 0.0F, 1.2F, 1.3F, 0.0F, 1.3F, 1.3F, 0.0F, 1.3F, 1.3F, 0.0F, 1.3F, 1.3F, 0.0F, 1.3F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -10.2F, -4.0F, 8, 1, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.0F, -11.5F, -4.0F, 8, 1, 8, 0.0F, -1.6F, -0.3F, -1.6F, -1.6F, -0.3F, -1.6F, -1.6F, -0.3F, -1.6F, -1.6F, -0.3F, -1.6F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.0F, -9.2F, -4.0F, 8, 1, 8, 0.0F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 1.2F, 0.0F, 1.2F, 1.2F, 0.0F, 1.2F, 1.2F, 0.0F, 1.2F, 1.2F, 0.0F, 1.2F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-3.0F, -5.0F, -4.0F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.3F, 0.2F, 0.2F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(1.0F, -5.0F, -4.0F, 2, 1, 1, 0.0F, 0.0F, -0.5F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.5F, 0.2F, 0.4F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.0F, -1.0F, -4.0F, 8, 1, 5, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 1.0F, 0.2F, 0.2F, 1.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-2.0F, -2.5F, -4.0F, 2, 1, 1, 0.0F, 0.0F, -0.8F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.8F, 0.2F, 0.5F, 0.7F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F, 0.5F, 0.7F, 0.2F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(0.0F, -2.5F, -4.0F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.2F, 0.0F, -0.8F, 0.2F, 0.0F, -0.8F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F, 0.5F, 0.7F, 0.2F, 0.5F, 0.7F, 0.2F, 0.0F, -0.3F, 0.2F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-4.0F, -4.7F, 0.0F, 8, 1, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 1.8F, 0.5F, 0.2F, 1.8F, 0.5F, 0.2F, 1.8F, 0.5F, 1.2F, 1.8F, 0.5F, 1.2F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-4.0F, -0.7F, 0.0F, 8, 1, 4, 0.0F, 1.8F, 0.0F, 0.2F, 1.8F, 0.0F, 0.2F, 1.8F, 0.0F, 1.2F, 1.8F, 0.0F, 1.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(-4.0F, -3.2F, 0.0F, 8, 2, 4, 0.0F, 1.8F, 0.0F, 0.2F, 1.8F, 0.0F, 0.2F, 1.8F, 0.0F, 1.2F, 1.8F, 0.0F, 1.2F, 1.8F, 0.5F, 0.2F, 1.8F, 0.5F, 0.2F, 1.8F, 0.5F, 1.2F, 1.8F, 0.5F, 1.2F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(-4.0F, -3.2F, -1.2F, 8, 2, 1, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 1.8F, 0.0F, 0.0F, 1.8F, 0.0F, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(-4.0F, -4.7F, -1.2F, 8, 1, 1, 0.0F, -1.2F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(-4.0F, -0.2F, -1.2F, 8, 1, 1, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F, -1.2F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(-4.0F, 0.0F, -4.0F, 8, 1, 5, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, -2.8F, 0.0F, 0.2F, -2.8F, 0.0F, 0.2F, -2.8F, 0.0F, 0.2F, -2.8F, 0.0F, 0.2F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
