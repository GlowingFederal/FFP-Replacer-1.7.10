package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPersianAxe extends ModelGun {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelPersianAxe() {
    this.gunModel = new ModelRendererTurbo[7];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 26, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -19.5F, 0.0F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.gunModel[1].func_78793_a(0.0F, -18.0F, 0.0F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.3F, -0.2F, -0.1F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.3F, -0.2F, -0.1F);
    this.gunModel[2].func_78793_a(1.2F, -18.0F, 0.0F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.1F, 0.3F, -0.3F, 5.0F, 1.0F, -0.48F, 5.0F, 1.0F, -0.48F, -0.1F, 0.3F, -0.3F, -0.1F, 0.3F, -0.3F, 4.0F, 2.0F, -0.48F, 4.0F, 2.0F, -0.48F, -0.1F, 0.3F, -0.3F);
    this.gunModel[3].func_78793_a(2.2F, -17.5F, 0.0F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.4F, -0.2F, 0.0F, 0.4F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.0F, -0.2F);
    this.gunModel[4].func_78793_a(-2.0F, -17.3F, 0.0F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, -1.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -1.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F);
    this.gunModel[5].func_78793_a(-4.0F, -17.3F, 0.0F);
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, -0.4F, -0.8F, -0.2F, 0.0F, -1.0F, -0.2F, 0.0F, -1.0F, -0.2F, -0.4F, -0.8F, -0.2F, -0.4F, 0.0F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, -0.4F, 0.0F, -0.2F);
    this.gunModel[6].func_78793_a(-6.0F, -17.3F, 0.0F);
  }
}
