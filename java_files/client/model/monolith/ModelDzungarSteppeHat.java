package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelDzungarSteppeHat extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelDzungarSteppeHat() {
    this.headModel = new ModelRendererTurbo[11];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.5F, -9.0F, -4.0F, 9, 3, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.3F, 0.0F, -0.5F, 0.3F, 1.0F, 0.5F, 0.4F, 1.0F, 0.5F, 0.4F, 1.0F, 1.5F, 0.2F, 1.0F, 1.5F, 0.2F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -12.0F, -4.0F, 8, 3, 8, 0.0F, -2.0F, 0.5F, -2.6F, -2.0F, 0.5F, -2.6F, -2.0F, -0.5F, 1.2F, -2.0F, -0.5F, 1.2F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -14.0F, -3.0F, 8, 1, 8, 0.0F, -3.8F, 0.0F, -7.0F, -3.8F, 0.0F, -7.0F, -3.8F, -0.5F, 2.0F, -3.8F, -0.5F, 2.0F, -2.0F, 0.5F, -1.6F, -2.0F, 0.5F, -1.6F, -2.0F, 1.5F, 0.2F, -2.0F, 1.5F, 0.2F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-3.0F, -10.5F, -7.0F, 3, 5, 3, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -10.5F, -7.0F, 1, 6, 3, 0.0F, 1.0F, -3.0F, -1.5F, 0.0F, -0.5F, -1.0F, 0.0F, -1.0F, 0.0F, 1.0F, -3.4F, 1.0F, 0.0F, 2.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 2.3F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-6.0F, -7.5F, -7.0F, 2, 6, 13, 0.0F, 2.5F, -2.0F, -4.0F, -1.0F, 0.0F, -1.5F, -1.0F, -2.0F, 0.0F, 2.5F, -3.0F, -3.0F, 1.0F, -1.0F, -3.0F, 0.0F, -0.5F, -0.5F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, -3.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-6.0F, -7.5F, 4.0F, 6, 7, 2, 0.0F, -1.0F, -1.6F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -2.5F, 1.0F, -1.0F, -2.0F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, -2.0F, 0.0F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(0.0F, -10.5F, -7.0F, 3, 5, 3, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(0.0F, -7.5F, 4.0F, 6, 7, 2, 0.0F, 0.0F, -1.8F, 0.0F, -1.0F, -1.6F, 0.0F, -1.0F, -2.0F, 0.0F, 0.0F, -2.5F, 1.0F, 0.0F, 0.0F, 0.0F, -2.0F, -0.3F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(3.0F, -10.5F, -7.0F, 1, 6, 3, 0.0F, 0.0F, -0.5F, -1.0F, 1.0F, -3.0F, -1.5F, 1.0F, -3.4F, 1.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 2.5F, -0.5F, 0.0F, 2.3F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(4.0F, -7.5F, -7.0F, 2, 6, 13, 0.0F, -1.0F, 0.0F, -1.5F, 2.5F, -2.0F, -4.0F, 2.5F, -3.0F, -3.0F, -1.0F, -2.0F, 0.0F, 0.0F, -0.5F, -0.5F, 1.0F, -1.0F, -3.0F, 1.0F, 0.0F, -3.0F, 0.0F, 1.0F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
