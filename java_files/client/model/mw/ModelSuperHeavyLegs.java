package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSuperHeavyLegs extends ModelCustomArmour {
  public ModelSuperHeavyLegs() {
    int textureX = 64;
    int textureY = 32;
    this.leftLegModel = new ModelRendererTurbo[2];
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.leftLegModel[0].addBox(-2.1F, -1.0F, -2.5F, 5, 10, 5);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 15, textureX, textureY);
    this.leftLegModel[1].addBox(-1.0F, 3.0F, -3.5F, 3, 4, 1);
    this.rightLegModel = new ModelRendererTurbo[2];
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 20, 0, textureX, textureY);
    this.rightLegModel[0].addBox(-2.9F, -1.0F, -2.5F, 5, 10, 5);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 8, 15, textureX, textureY);
    this.rightLegModel[1].addBox(-2.0F, 3.0F, -3.5F, 3, 4, 1);
  }
}
