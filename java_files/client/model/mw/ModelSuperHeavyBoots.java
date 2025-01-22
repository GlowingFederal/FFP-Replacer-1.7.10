package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSuperHeavyBoots extends ModelCustomArmour {
  public ModelSuperHeavyBoots() {
    int textureX = 128;
    int textureY = 64;
    this.leftLegModel = new ModelRendererTurbo[1];
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 84, 0, textureX, textureY);
    this.leftLegModel[0].addBox(-2.1F, 9.0F, -3.0F, 5, 3, 6);
    this.rightLegModel = new ModelRendererTurbo[1];
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 84, 9, textureX, textureY);
    this.rightLegModel[0].addBox(-2.9F, 9.0F, -3.0F, 5, 3, 6);
  }
}
