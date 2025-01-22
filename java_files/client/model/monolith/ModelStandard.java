package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelStandard extends ModelGun {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelStandard() {
    this.gunModel = new ModelRendererTurbo[6];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 4, 4, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F);
    this.gunModel[0].func_78793_a(0.5F, -18.0F, 0.0F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.gunModel[1].func_78793_a(0.5F, -40.0F, 0.0F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.1F, 1.0F, -0.1F, -0.1F, 1.0F, -0.1F, -0.1F, 1.0F, -0.1F, -0.1F, 1.0F, -0.1F);
    this.gunModel[2].func_78793_a(0.5F, -43.0F, 0.0F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[3].func_78793_a(0.5F, -39.0F, 0.0F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.1F, 6.0F, 0.1F, 0.1F, 6.0F, 0.1F, 0.1F, 6.0F, 0.1F, 0.1F, 6.0F, 0.1F, 0.1F, 9.0F, 0.1F, 0.1F, 9.0F, 0.1F, 0.1F, 9.0F, 0.1F, 0.1F, 9.0F, 0.1F);
    this.gunModel[4].func_78793_a(0.5F, -31.5F, 0.0F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 60, 58, 1, 0.0F, -20.0F, -21.0F, -0.3F, -20.0F, -21.0F, -0.3F, -20.0F, -21.0F, -0.3F, -20.0F, -21.0F, -0.3F, -20.0F, -21.0F, -0.3F, -20.0F, -21.0F, -0.3F, -20.0F, -21.0F, -0.3F, -20.0F, -21.0F, -0.3F);
    this.gunModel[5].func_78793_a(-39.5F, -58.5F, 0.0F);
  }
}
