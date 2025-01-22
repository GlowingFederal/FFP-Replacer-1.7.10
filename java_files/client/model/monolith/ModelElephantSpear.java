package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelElephantSpear extends ModelGun {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelElephantSpear() {
    this.gunModel = new ModelRendererTurbo[12];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 8, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 12, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 24, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 24, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 30, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 3, 35, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 3, 30, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 12, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 0, 8, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 0, 8, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 0, 12, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(56.0F, -3.0F, -1.0F, 30, 1, 1, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[1].addShapeBox(56.0F, -2.0F, -1.0F, 30, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F);
    this.gunModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[2].addShapeBox(86.0F, -3.0F, -1.0F, 2, 1, 1, 0.0F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F);
    this.gunModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[3].addShapeBox(86.0F, -2.0F, -1.0F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -0.2F);
    this.gunModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[4].addShapeBox(88.0F, -2.5F, -1.0F, 2, 1, 1, 0.0F, 0.0F, -0.1F, -0.1F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.1F, -0.1F);
    this.gunModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[5].addShapeBox(90.0F, -2.5F, -1.0F, 4, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F);
    this.gunModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[6].addShapeBox(90.0F, -2.5F, -0.5F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.0F);
    this.gunModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[7].addShapeBox(90.0F, -2.5F, -1.5F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, -1.5F, 0.0F, 0.0F, 0.0F);
    this.gunModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[8].addShapeBox(26.0F, -2.0F, -1.0F, 30, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F);
    this.gunModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[9].addShapeBox(26.0F, -3.0F, -1.0F, 30, 1, 1, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[10].addShapeBox(-4.0F, -3.0F, -1.0F, 30, 1, 1, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[11].addShapeBox(-4.0F, -2.0F, -1.0F, 30, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F);
    this.gunModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
}
