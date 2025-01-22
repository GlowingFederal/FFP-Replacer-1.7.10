package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSumerHelmet extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelSumerHelmet() {
    this.headModel = new ModelRendererTurbo[7];
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 4, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.5F, -0.5F, 1.0F, 0.5F, -0.5F, 1.0F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -4.0F, -1.0F, 1, 3, 3, 0.0F, 0.5F, 0.4F, 1.0F, -1.2F, 0.4F, 1.0F, -1.2F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.5F, 0.5F, -1.2F, 0.5F, 0.5F, -1.2F, 0.2F, 1.0F, 0.5F, 0.2F, 1.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -4.0F, 3.0F, 8, 3, 1, 0.0F, 0.5F, 0.2F, 1.0F, 0.5F, 0.2F, 1.0F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -1.0F, 0.0F, -2.0F, -1.0F, 0.0F, -2.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-3.0F, -10.8F, -3.0F, 6, 1, 7, 0.0F, -2.8F, 0.75F, -6.2F, -2.8F, 0.75F, -6.2F, -2.8F, 0.75F, -0.5F, -2.8F, 0.75F, -0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-1.2F, -6.0F, -1.7F, 1, 1, 2, 0.0F, -0.5F, 1.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.5F, -0.8F, -0.5F, 0.5F, -0.8F, -0.5F, -1.0F, 1.0F, -0.2F, -1.0F, 1.0F, -0.2F, -0.5F, -1.2F, -0.5F, -0.5F, -1.2F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(3.0F, -4.0F, -1.0F, 1, 3, 3, 0.0F, -1.2F, 0.4F, 1.0F, 0.5F, 0.4F, 1.0F, 0.5F, 0.2F, 0.5F, -1.2F, 0.2F, 0.5F, -1.2F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.2F, 1.0F, -1.2F, 0.2F, 1.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
