package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelCloakerGoggles extends ModelCustomArmour {
  public ModelCloakerGoggles() {
    int textureX = 64;
    int textureY = 32;
    this.headModel = new ModelRendererTurbo[4];
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.headModel[0].addBox(-4.5F, -9.0F, -4.5F, 9, 9, 9);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 18, textureX, textureY);
    this.headModel[1].addBox(-3.0F, -6.5F, -7.5F, 2, 2, 3);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 18, textureX, textureY);
    this.headModel[2].addBox(1.0F, -6.5F, -7.5F, 2, 2, 3);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 23, textureX, textureY);
    this.headModel[3].addBox(-2.0F, -3.5F, -6.5F, 4, 4, 2);
  }
}
