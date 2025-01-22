package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSuperHeavyHelmet extends ModelCustomArmour {
  public ModelSuperHeavyHelmet() {
    int textureX = 128;
    int textureY = 64;
    this.headModel = new ModelRendererTurbo[10];
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 28, 20, textureX, textureY);
    this.headModel[0].addBox(-4.5F, -9.0F, -4.5F, 9, 9, 9);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 20, 38, textureX, textureY);
    this.headModel[1].addBox(-3.0F, -10.0F, -3.0F, 6, 1, 6);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 38, 38, textureX, textureY);
    this.headModel[2].addBox(-2.0F, -11.0F, -2.0F, 4, 1, 4);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 20, 45, textureX, textureY);
    this.headModel[3].addShapeBox(-5.5F, -7.0F, -4.5F, 1, 7, 9, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 40, 45, textureX, textureY);
    this.headModel[4].addShapeBox(4.5F, -7.0F, -4.5F, 1, 7, 9, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 2.0F, -1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 64, 0, textureX, textureY);
    this.headModel[5].addShapeBox(-4.5F, -7.0F, 4.5F, 9, 7, 1, 0.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 64, 8, textureX, textureY);
    this.headModel[6].addShapeBox(-4.0F, -7.0F, -5.5F, 8, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 65, 17, textureX, textureY);
    this.headModel[7].addBox(-3.0F, 0.0F, -5.5F, 6, 1, 1);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 66, 19, textureX, textureY);
    this.headModel[8].addBox(-2.0F, 1.0F, -5.5F, 4, 1, 1);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 65, 17, textureX, textureY);
    this.headModel[9].addBox(-3.0F, -8.0F, -5.5F, 6, 1, 1);
  }
}
