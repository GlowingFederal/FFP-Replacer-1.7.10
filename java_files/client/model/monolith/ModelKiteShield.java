package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelKiteShield extends ModelGun {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelKiteShield() {
    this.gunModel = new ModelRendererTurbo[9];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, -1.0F, 0.0F, 1, 4, 12, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.gunModel[0].func_78793_a(1.0F, -2.5F, -6.0F);
    this.gunModel[1].addShapeBox(0.0F, 1.0F, 0.0F, 1, 1, 4, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.gunModel[1].func_78793_a(1.3F, -1.0F, -2.0F);
    this.gunModel[2].addShapeBox(0.0F, 1.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2].func_78793_a(2.3F, -1.0F, -1.5F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[3].func_78793_a(2.3F, -0.99F, -1.5F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.gunModel[4].func_78793_a(2.3F, 1.01F, -1.5F);
    this.gunModel[5].addShapeBox(0.0F, -0.7F, 0.0F, 1, 1, 4, 0.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.gunModel[5].func_78793_a(1.3F, -1.0F, -2.0F);
    this.gunModel[6].addShapeBox(0.0F, 2.7F, 0.0F, 1, 1, 4, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F);
    this.gunModel[6].func_78793_a(1.3F, -1.0F, -2.0F);
    this.gunModel[7].addShapeBox(0.0F, -5.0F, 0.0F, 1, 4, 12, 0.0F, 0.0F, 0.0F, -4.5F, 0.0F, 0.0F, -4.5F, 0.0F, 0.0F, -4.5F, 0.0F, 0.0F, -4.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.gunModel[7].func_78793_a(1.0F, -2.5F, -6.0F);
    this.gunModel[8].addShapeBox(0.0F, -5.0F, 0.0F, 1, 19, 12, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F);
    this.gunModel[8].func_78793_a(1.0F, 5.5F, -6.0F);
  }
}
