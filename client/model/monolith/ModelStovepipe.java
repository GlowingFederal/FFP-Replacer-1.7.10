package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelStovepipe extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelStovepipe() {
    this.headModel = new ModelRendererTurbo[9];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 37, 25, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -5.5F, -3.9F, 8, 2, 8, 0.0F, 0.2F, 1.7F, 0.4F, 0.2F, 1.7F, 0.4F, 0.2F, 0.7F, 0.3F, 0.2F, 0.7F, 0.3F, 0.2F, -1.5F, 0.5F, 0.2F, -1.5F, 0.5F, 0.2F, -0.7F, 0.1F, 0.2F, -0.7F, 0.1F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.5F, -6.0F, -8.0F, 9, 1, 3, 0.0F, -2.5F, -0.7F, -1.3F, -2.5F, -0.7F, -1.3F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -2.0F, 0.5F, 0.3F, -2.0F, 0.5F, 0.3F, 0.3F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -13.5F, -3.9F, 8, 6, 8, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -1.2F, 1.0F, 0.0F, -1.2F, 1.0F, 0.2F, 0.3F, 0.4F, 0.2F, 0.3F, 0.4F, 0.2F, 1.3F, 0.3F, 0.2F, 1.3F, 0.3F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-2.0F, -12.0F, -4.5F, 4, 5, 1, 0.0F, 0.0F, -0.5F, -0.7F, 0.0F, -0.5F, -0.7F, 0.0F, -0.5F, 0.7F, 0.0F, -0.5F, 0.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-2.0F, -12.5F, -3.8F, 4, 1, 1, 0.0F, -1.9F, 0.0F, -0.2F, -1.9F, 0.0F, -0.2F, -1.9F, 0.0F, 0.0F, -1.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-2.0F, -7.0F, -4.5F, 4, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.9F, 0.0F, 0.1F, -1.9F, 0.0F, 0.1F, -1.9F, 0.0F, 0.0F, -1.9F, 0.0F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-0.5F, -13.6F, -3.8F, 1, 1, 1, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-0.5F, -17.5F, -3.5F, 1, 4, 1, 0.0F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-4.5F, -6.0F, -5.0F, 9, 1, 3, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, 0.0F, 0.7F, -0.5F, 0.0F, 0.7F, 0.3F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, -2.0F, 0.0F, 4.3F, -2.0F, 0.0F, 4.3F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
