package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPalmyraHelm extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelPalmyraHelm() {
    this.headModel = new ModelRendererTurbo[7];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -7.8F, -4.0F, 8, 2, 8, 0.0F, 0.2F, 0.8F, 0.3F, 0.2F, 0.8F, 0.3F, 0.2F, 0.8F, 0.3F, 0.2F, 0.8F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -10.1F, -4.0F, 8, 1, 8, 0.0F, -1.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -6.3F, -4.0F, 8, 2, 8, 0.0F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-2.0F, -12.1F, -2.0F, 4, 2, 4, 0.0F, -1.2F, -0.5F, -1.2F, -1.2F, -0.5F, -1.2F, -1.2F, -0.5F, -1.2F, -1.2F, -0.5F, -1.2F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-0.5F, -13.5F, -0.5F, 1, 2, 1, 0.0F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.0F, -4.3F, -1.1F, 8, 3, 6, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.0F, -1.3F, -1.1F, 8, 1, 6, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, -0.5F, -1.0F, 0.9F, -0.5F, -1.0F, 0.9F, -0.5F, 0.0F, 0.9F, -0.5F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
