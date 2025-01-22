package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelKalmykHat extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelKalmykHat() {
    this.headModel = new ModelRendererTurbo[12];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.5F, -2.0F, -4.5F, 4, 1, 1, 0.0F, 0.0F, -1.4F, -0.3F, -1.0F, 0.5F, -0.3F, -1.0F, 0.5F, -0.3F, 0.0F, -1.4F, -0.3F, -2.5F, -0.3F, -0.3F, 0.2F, -1.0F, -0.3F, 0.2F, -1.0F, -0.3F, -2.5F, -0.3F, -0.3F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(0.5F, -2.0F, -4.5F, 4, 1, 1, 0.0F, -1.0F, 0.5F, -0.3F, 0.0F, -1.4F, -0.3F, 0.0F, -1.4F, -0.3F, -1.0F, 0.5F, -0.3F, 0.2F, -1.0F, -0.3F, -2.5F, -0.3F, -0.3F, -2.5F, -0.3F, -0.3F, 0.2F, -1.0F, -0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -7.0F, -3.9F, 8, 3, 8, 0.0F, 0.7F, 1.7F, 0.4F, 0.7F, 1.7F, 0.4F, 0.7F, 0.9F, 1.1F, 0.7F, 0.9F, 1.1F, 0.5F, -1.5F, 0.3F, 0.5F, -1.5F, 0.3F, 0.5F, -0.6F, 0.5F, 0.5F, -0.6F, 0.5F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -6.0F, -3.0F, 8, 6, 1, 0.0F, 0.4F, 0.1F, -0.2F, 0.4F, 0.1F, -0.2F, 0.4F, 0.1F, -0.2F, 0.4F, 0.1F, -0.2F, 0.1F, 0.1F, 0.6F, 0.1F, 0.1F, 0.6F, 0.1F, 0.1F, -1.2F, 0.1F, 0.1F, -1.2F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-5.0F, -13.0F, -3.5F, 5, 5, 4, 0.0F, -0.5F, -0.5F, -0.5F, 0.0F, 0.0F, 2.0F, 0.0F, -1.0F, 0.5F, 2.0F, -1.0F, 0.5F, -1.5F, 0.0F, -1.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 1.2F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-5.0F, -13.0F, 0.5F, 5, 5, 4, 0.0F, 2.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -1.5F, 2.5F, -0.5F, -1.3F, -0.5F, -0.4F, 1.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.2F, -1.5F, 0.5F, -1.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-5.0F, -13.5F, -3.5F, 5, 1, 4, 0.0F, -0.5F, -0.5F, -0.2F, 0.0F, 0.0F, 2.5F, 0.0F, -1.0F, 0.8F, 2.5F, -1.0F, 0.8F, -0.5F, 0.0F, -0.2F, 0.0F, -0.5F, 2.3F, 0.0F, 0.5F, 0.8F, 2.3F, 0.5F, 0.8F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-5.0F, -13.5F, 2.5F, 5, 1, 3, 0.0F, 2.5F, -1.0F, 1.2F, 0.0F, -1.0F, 1.2F, 0.0F, -2.0F, 2.0F, -0.5F, -2.0F, -0.7F, 2.3F, 0.5F, 1.2F, 0.0F, 0.5F, 1.2F, 0.0F, 1.5F, 1.8F, -0.5F, 1.5F, -0.8F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(0.0F, -13.0F, -3.5F, 5, 5, 4, 0.0F, 0.0F, 0.0F, 2.0F, -0.5F, -0.5F, -0.5F, 2.0F, -1.0F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.2F, -1.5F, 0.0F, -1.0F, -0.4F, 1.2F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(0.0F, -13.0F, 0.5F, 5, 5, 4, 0.0F, 0.0F, -1.0F, -0.5F, 2.0F, -1.0F, -0.5F, -0.5F, -1.3F, -0.5F, 0.0F, -1.5F, 2.5F, 0.0F, 0.0F, 0.0F, -0.4F, 1.2F, 0.0F, -1.5F, 0.5F, -1.0F, 0.0F, 1.0F, 0.2F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(0.0F, -13.5F, -3.5F, 5, 1, 4, 0.0F, 0.0F, 0.0F, 2.5F, -0.5F, -0.5F, -0.2F, 2.5F, -1.0F, 0.8F, 0.0F, -1.0F, 0.8F, 0.0F, -0.5F, 2.3F, -0.5F, 0.0F, -0.2F, 2.3F, 0.5F, 0.8F, 0.0F, 0.5F, 0.8F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(0.0F, -13.5F, 2.5F, 5, 1, 3, 0.0F, 0.0F, -1.0F, 1.2F, 2.5F, -1.0F, 1.2F, -0.5F, -1.9F, -0.7F, 0.0F, -2.0F, 2.0F, 0.0F, 0.5F, 1.2F, 2.3F, 0.5F, 1.2F, -0.5F, 1.4F, -0.8F, 0.0F, 1.5F, 1.8F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
