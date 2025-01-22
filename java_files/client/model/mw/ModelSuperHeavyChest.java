package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSuperHeavyChest extends ModelCustomArmour {
  public ModelSuperHeavyChest() {
    int textureX = 128;
    int textureY = 64;
    this.bodyModel = new ModelRendererTurbo[6];
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.bodyModel[0].addBox(-4.5F, -0.5F, -3.0F, 9, 13, 6);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 30, 0, textureX, textureY);
    this.bodyModel[1].addBox(-3.0F, 2.0F, -4.0F, 6, 12, 1);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 19, textureX, textureY);
    this.bodyModel[2].addBox(-5.5F, 8.0F, -2.0F, 1, 3, 4);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 10, 19, textureX, textureY);
    this.bodyModel[3].addBox(4.5F, 8.0F, -2.0F, 1, 3, 4);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 44, 0, textureX, textureY);
    this.bodyModel[4].addBox(4.5F, -2.0F, -3.0F, 4, 4, 6);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 44, 10, textureX, textureY);
    this.bodyModel[5].addBox(-8.5F, -2.0F, -3.0F, 4, 4, 6);
    this.leftArmModel = new ModelRendererTurbo[2];
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 26, textureX, textureY);
    this.leftArmModel[0].addBox(-1.25F, -2.0F, -2.25F, 4.5F, 13.0F, 4.5F);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 20, 19, textureX, textureY);
    this.leftArmModel[1].addBox(2.75F, 2.0F, -1.5F, 1, 4, 3);
    this.rightArmModel = new ModelRendererTurbo[2];
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 44, textureX, textureY);
    this.rightArmModel[0].addBox(-3.25F, -2.0F, -2.25F, 4.5F, 13.0F, 4.5F);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 20, 26, textureX, textureY);
    this.rightArmModel[1].addBox(-3.75F, 2.0F, -1.5F, 1, 4, 3);
  }
}
