package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelKontos extends ModelGun {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelKontos() {
    this.gunModel = new ModelRendererTurbo[6];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(15.0F, 0.0F, 1.0F, 10, 1, 1, 0.0F, 40.0F, -0.1F, -0.1F, 40.0F, -0.1F, -0.1F, 40.0F, -0.1F, -0.1F, 40.0F, -0.1F, -0.1F, 40.0F, -0.1F, -0.1F, 40.0F, -0.1F, -0.1F, 40.0F, -0.1F, -0.1F, 40.0F, -0.1F, -0.1F);
    this.gunModel[0].func_78793_a(-10.0F, 0.0F, 0.0F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 1.0F, 3, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1].func_78793_a(60.0F, 0.0F, 0.0F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 1.0F, 7, 1, 1, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, 1.0F, 0.0F);
    this.gunModel[2].func_78793_a(63.0F, 0.0F, 0.0F);
    this.gunModel[3].addShapeBox(-1.0F, 0.0F, 1.0F, 2, 1, 1, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.25F, -0.25F);
    this.gunModel[3].func_78793_a(71.0F, 0.0F, 0.0F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 1.0F, 7, 1, 1, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.gunModel[4].func_78793_a(53.0F, 0.0F, 0.0F);
    this.gunModel[5].addShapeBox(15.0F, 0.0F, 1.0F, 10, 1, 1, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F);
    this.gunModel[5].func_78793_a(-17.0F, 0.0F, 0.0F);
  }
}
