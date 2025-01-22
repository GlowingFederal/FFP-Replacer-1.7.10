package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelOneHandAxe extends ModelGun {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelOneHandAxe() {
    this.gunModel = new ModelRendererTurbo[4];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 21, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -15.5F, 0.0F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.gunModel[1].func_78793_a(0.0F, -15.0F, 0.0F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.3F, -0.2F, -0.1F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.3F, -0.2F, -0.1F);
    this.gunModel[2].func_78793_a(1.2F, -15.0F, 0.0F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.1F, 0.3F, -0.3F, 4.8F, 0.4F, -0.48F, 4.8F, 0.4F, -0.48F, -0.1F, 0.3F, -0.3F, -0.1F, 0.3F, -0.3F, 4.5F, 1.8F, -0.48F, 4.5F, 1.8F, -0.48F, -0.1F, 0.3F, -0.3F);
    this.gunModel[3].func_78793_a(2.2F, -14.5F, 0.0F);
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
}
