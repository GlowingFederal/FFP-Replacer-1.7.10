package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRiotShield extends ModelGun {
  public ModelRiotShield() {
    int textureX = 64;
    int textureY = 64;
    this.gunModel = new ModelRendererTurbo[1];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(4.0F, -20.0F, -8.0F, 1, 32, 16);
  }
}
