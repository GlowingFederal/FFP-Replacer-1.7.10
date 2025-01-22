package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelNgob extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelNgob() {
    this.headModel = new ModelRendererTurbo[10];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -9.0F, -4.0F, 8, 3, 8, 0.0F, 0.0F, 0.9F, 0.1F, 0.0F, 0.9F, 0.1F, 0.0F, 0.5F, 0.1F, 0.0F, 0.5F, 0.1F, 0.9F, -0.7F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -7.0F, -4.0F, 8, 3, 8, 0.0F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.7F, 0.9F, 1.9F, -0.7F, 1.9F, 1.9F, -0.7F, 1.9F, 1.9F, -0.3F, 1.9F, 1.9F, -0.3F, 1.9F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-5.0F, -5.5F, 4.8F, 10, 2, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-8.9F, -5.9F, -4.8F, 4, 2, 10, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, -0.3F, 0.0F, -1.9F, -0.3F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.9F, -0.3F, 0.0F, 0.1F, -0.3F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-8.01F, -5.9F, -7.8F, 3, 2, 3, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.5F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 1.0F, 0.0F, -0.8F, 0.0F, 1.0F, -0.3F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-8.01F, -5.5F, 4.91F, 3, 2, 3, 0.0F, 1.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 1.0F, 0.0F, -1.5F, 0.0F, 1.0F, -0.3F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, -0.3F, 1.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-5.0F, -5.9F, -8.8F, 10, 2, 4, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(4.9F, -5.9F, -4.8F, 4, 2, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.9F, -0.3F, 0.0F, -0.4F, -0.3F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.1F, -0.3F, 0.0F, -0.9F, -0.3F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(4.9F, -5.5F, 4.91F, 3, 2, 3, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 1.0F, 0.0F, -0.8F, 0.0F, 1.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 1.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(4.9F, -5.9F, -7.8F, 3, 2, 3, 0.0F, 0.0F, -1.5F, 1.0F, 0.0F, -1.5F, 0.0F, 1.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, 1.0F, 0.0F, -0.3F, 0.0F, 1.0F, -0.3F, 0.0F, 0.0F, -0.8F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
