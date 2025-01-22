package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRomaniaWW2helm extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelRomaniaWW2helm() {
    this.headModel = new ModelRendererTurbo[7];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 65, 17, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.5F, 0.0F, -4.0F, 9, 1, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.6F, -0.8F, 0.0F, -0.6F, -0.8F, 0.0F, -0.6F, -0.8F, 0.0F, -0.6F, -0.8F, 0.0F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.5F, -4.0F, -4.5F, 9, 4, 4, 0.0F, 0.5F, 0.0F, -3.5F, 0.5F, 0.0F, -3.5F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 1.0F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -2.5F, -0.4F, 0.0F, -2.5F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -10.0F, -4.0F, 8, 2, 8, 0.0F, -1.2F, -0.4F, -2.8F, -1.2F, -0.4F, -2.8F, -1.2F, -0.7F, -1.0F, -1.2F, -0.7F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -8.0F, -5.0F, 8, 3, 5, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.1F, 0.0F, 1.1F, 0.1F, 0.0F, 1.1F, 0.75F, 0.4F, 0.5F, 0.75F, 0.4F, 0.5F, 1.5F, 1.0F, 1.1F, 1.5F, 1.0F, 1.1F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -8.0F, 0.2F, 8, 3, 4, 0.0F, 0.1F, 0.0F, -0.9F, 0.1F, 0.0F, -0.9F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 1.5F, 1.0F, -0.9F, 1.5F, 1.0F, -0.9F, 0.85F, 1.2F, 0.9F, 0.85F, 1.2F, 0.9F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.0F, -4.0F, 0.4F, 8, 1, 4, 0.0F, 1.5F, 0.5F, -0.4F, 1.5F, 0.5F, -0.4F, 0.85F, -0.2F, 0.7F, 0.85F, -0.2F, 0.7F, 1.7F, -0.8F, -0.4F, 1.7F, -0.8F, -0.4F, 1.4F, 0.8F, 1.5F, 1.4F, 0.8F, 1.5F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.0F, -4.0F, -4.2F, 8, 1, 4, 0.0F, 0.75F, 0.7F, 1.2F, 0.75F, 0.7F, 1.2F, 1.5F, 0.5F, 1.0F, 1.5F, 0.5F, 1.0F, 0.95F, -1.3F, 1.7F, 0.95F, -1.3F, 1.7F, 1.7F, -0.8F, 1.0F, 1.7F, -0.8F, 1.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
