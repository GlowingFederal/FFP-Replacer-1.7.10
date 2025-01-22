package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSumerShield extends ModelGun {
  int textureX = 32;
  
  int textureY = 64;
  
  public ModelSumerShield() {
    this.gunModel = new ModelRendererTurbo[3];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 26, 13, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(1.0F, -8.0F, -3.5F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1].func_78793_a(0.0F, -1.0F, -1.0F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2].func_78793_a(0.0F, -1.0F, 6.0F);
  }
}
