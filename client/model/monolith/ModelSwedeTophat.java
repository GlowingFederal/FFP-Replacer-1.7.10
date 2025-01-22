package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSwedeTophat extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelSwedeTophat() {
    this.headModel = new ModelRendererTurbo[7];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 9, 7, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -5.5F, -3.9F, 8, 2, 8, 0.0F, 0.2F, 1.7F, 0.4F, 0.2F, 1.7F, 0.4F, 0.2F, 0.7F, 0.3F, 0.2F, 0.7F, 0.3F, 0.2F, -1.5F, 0.5F, 0.2F, -1.5F, 0.5F, 0.2F, -0.7F, 0.1F, 0.2F, -0.7F, 0.1F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -12.5F, -3.9F, 8, 5, 8, 0.0F, -0.2F, 0.0F, -0.7F, -0.2F, 0.0F, -0.7F, -0.2F, -1.2F, 0.8F, -0.2F, -1.2F, 0.8F, 0.2F, 0.3F, 0.4F, 0.2F, 0.3F, 0.4F, 0.2F, 1.3F, 0.3F, 0.2F, 1.3F, 0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(3.5F, -15.0F, 0.5F, 1, 4, 1, 0.0F, 0.5F, 0.4F, 0.4F, 0.5F, 0.4F, 0.4F, 0.5F, 0.0F, 1.2F, 0.5F, 0.0F, 1.2F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-2.5F, -4.0F, -2.9F, 6, 1, 6, 0.0F, 2.4F, 1.7F, 3.4F, 3.2F, 1.7F, 3.4F, 3.2F, 0.7F, 3.3F, 2.4F, 0.7F, 3.3F, 2.7F, -1.5F, 3.5F, 2.2F, -1.5F, 3.5F, 2.2F, -0.7F, 3.1F, 2.7F, -0.7F, 3.1F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(5.5F, -7.0F, -5.9F, 1, 3, 12, 0.0F, 0.2F, 1.2F, -2.6F, 0.2F, 1.2F, -2.6F, 0.2F, 0.6F, -2.7F, 0.2F, 0.6F, -2.7F, 0.2F, -1.5F, 0.5F, 0.2F, -1.5F, 0.5F, 0.2F, -0.7F, 0.1F, 0.2F, -0.7F, 0.1F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(5.5F, -12.9F, -2.9F, 1, 4, 6, 0.0F, 0.2F, -0.7F, -1.9F, 0.2F, -0.7F, -1.9F, 0.2F, -1.3F, -0.4F, 0.2F, -1.3F, -0.4F, 0.2F, 0.7F, 0.3F, 0.2F, 0.7F, 0.3F, 0.2F, 1.3F, 0.4F, 0.2F, 1.3F, 0.4F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-7.4F, -4.0F, -5.9F, 2, 1, 12, 0.0F, -0.8F, 3.7F, -1.6F, 0.5F, 1.7F, 0.4F, 0.5F, 0.7F, 0.3F, -0.8F, 2.7F, -1.7F, -0.2F, -4.0F, -1.5F, 0.2F, -1.5F, 0.5F, 0.2F, -0.7F, 0.1F, -0.2F, -3.2F, -1.9F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
