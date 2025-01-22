package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelBardiche extends ModelGun {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelBardiche() {
    this.gunModel = new ModelRendererTurbo[9];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 26, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -13.0F, 0.0F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.gunModel[1].func_78793_a(0.0F, -13.0F, 0.0F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.3F, 0.0F, -0.1F, -0.1F, 4.0F, -0.3F, -0.1F, 4.0F, -0.3F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, -0.1F, 1.8F, -0.3F, -0.1F, 1.8F, -0.3F, 0.3F, 0.0F, -0.1F);
    this.gunModel[2].func_78793_a(1.2F, -13.0F, 0.0F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, 0.1F, 0.4F, -0.3F, 0.3F, 0.4F, -0.4F, 0.3F, 0.4F, -0.4F, 0.1F, 0.4F, -0.3F, 0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.4F, -0.1F, 0.0F, -0.4F, 0.1F, 0.0F, -0.3F);
    this.gunModel[3].func_78793_a(2.2F, -12.5F, 0.0F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.4F, -0.1F, 0.0F, -0.4F, 0.1F, 0.0F, -0.3F, 1.1F, 1.0F, -0.3F, -0.5F, -0.5F, -0.4F, -0.5F, -0.5F, -0.4F, 1.1F, 1.0F, -0.3F);
    this.gunModel[4].func_78793_a(2.2F, -6.5F, 0.0F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.gunModel[5].func_78793_a(0.0F, 13.0F, 0.0F);
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, 0.1F, 0.0F, -0.3F, -0.1F, -2.0F, -0.4F, -0.1F, -2.0F, -0.4F, 0.1F, 0.0F, -0.3F, 0.1F, 0.4F, -0.3F, 0.3F, 0.4F, -0.4F, 0.3F, 0.4F, -0.4F, 0.1F, 0.4F, -0.3F);
    this.gunModel[6].func_78793_a(2.2F, -19.3F, 0.0F);
    this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 1.0F, 1.8F, -0.4F, 0.1F, 0.0F, -0.3F, 0.1F, 0.0F, -0.3F, 1.0F, 1.8F, -0.4F, 0.8F, -0.5F, -0.4F, 0.1F, 1.5F, -0.3F, 0.1F, 1.5F, -0.3F, 0.8F, -0.5F, -0.4F);
    this.gunModel[7].func_78793_a(1.0F, -19.3F, 0.0F);
    this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -0.5F, 0.0F, -0.4F);
    this.gunModel[8].func_78793_a(1.0F, -18.3F, 0.0F);
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
}
