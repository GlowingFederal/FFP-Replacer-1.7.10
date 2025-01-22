package com.flansmod.client.model.mw;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelM1911 extends ModelM9 {
  public ModelM1911() {
    int textureX = 32;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[4];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-1.0F, 0.0F, -1.0F, 3, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 20, 0, textureX, textureY);
    this.gunModel[1].addBox(-2.0F, -2.0F, -1.0F, 3, 2, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 6, textureX, textureY);
    this.gunModel[2].addBox(-1.0F, 2.0F, -1.0F, 8, 1, 2);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.gunModel[3].addBox(-0.5F, 3.5F, -0.5F, 8, 1, 1);
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 14, 0, textureX, textureY);
    this.ammoModel[0].addBox(-1.0F, -1.8F, -0.5F, 2, 4, 1);
  }
}
