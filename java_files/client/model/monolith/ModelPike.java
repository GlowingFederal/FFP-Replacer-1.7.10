package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPike extends ModelGun {
  int textureX = 256;
  
  int textureY = 32;
  
  public ModelPike() {
    this.gunModel = new ModelRendererTurbo[4];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 3, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 217, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 225, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(-25.0F, 0.0F, -3.0F, 106, 1, 1, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, -3.0F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1].func_78793_a(81.0F, 0.0F, 0.0F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, -3.0F, 5, 1, 1, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, 1.0F, 0.0F);
    this.gunModel[2].func_78793_a(83.0F, 0.0F, 0.0F);
    this.gunModel[3].addShapeBox(-1.0F, 0.0F, -3.0F, 2, 1, 1, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.25F, -0.25F);
    this.gunModel[3].func_78793_a(89.0F, 0.0F, 0.0F);
  }
}
