package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelTachi extends ModelGun {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelTachi() {
    this.gunModel = new ModelRendererTurbo[10];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, -1.35F, 1, 4, 2, 0.0F, -0.45F, 0.0F, -0.2F, -0.45F, 0.0F, -0.2F, -0.45F, 0.0F, -0.9F, -0.45F, 0.0F, -0.9F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F);
    this.gunModel[0].func_78793_a(0.2F, -20.5F, 0.5F);
    (this.gunModel[0]).field_78796_g = -1.0471976F;
    this.gunModel[1].addShapeBox(0.0F, 0.0F, -1.65F, 1, 1, 2, 0.0F, -0.45F, -0.2F, -0.3F, -0.45F, -0.2F, -0.3F, -0.45F, -0.2F, -1.6F, -0.45F, -0.2F, -1.6F, -0.45F, 1.5F, -0.5F, -0.45F, 1.5F, -0.5F, -0.45F, 1.5F, -0.6F, -0.45F, 1.5F, -0.6F);
    this.gunModel[1].func_78793_a(0.2F, -23.0F, 0.5F);
    (this.gunModel[1]).field_78796_g = -1.0471976F;
    this.gunModel[2].addShapeBox(0.0F, 0.0F, -0.65F, 1, 6, 1, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F);
    this.gunModel[2].func_78793_a(0.2F, -2.5F, 0.5F);
    (this.gunModel[2]).field_78796_g = -1.0471976F;
    this.gunModel[3].addShapeBox(0.0F, 0.0F, -0.6F, 1, 1, 1, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F);
    this.gunModel[3].func_78793_a(0.2F, -3.0F, 0.5F);
    (this.gunModel[3]).field_78796_g = -1.0471976F;
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.4F, 1, 1, 1, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.0F, -0.2F, -0.5F, 0.0F, -0.2F, -0.5F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.0F, -0.2F, -0.5F, 0.0F, -0.2F, -0.5F);
    this.gunModel[4].func_78793_a(0.2F, -3.0F, 0.5F);
    (this.gunModel[4]).field_78796_g = -1.0471976F;
    this.gunModel[5].addShapeBox(0.0F, 0.0F, -1.6F, 1, 1, 1, 0.0F, 0.0F, -0.2F, -0.5F, 0.0F, -0.2F, -0.5F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.0F, -0.2F, -0.5F, 0.0F, -0.2F, -0.5F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F);
    this.gunModel[5].func_78793_a(0.2F, -3.0F, 0.5F);
    (this.gunModel[5]).field_78796_g = -1.0471976F;
    this.gunModel[6].addShapeBox(0.0F, 0.0F, -1.25F, 1, 4, 2, 0.0F, -0.45F, 0.0F, -0.4F, -0.45F, 0.0F, -0.4F, -0.45F, 0.0F, -0.6F, -0.45F, 0.0F, -0.6F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F);
    this.gunModel[6].func_78793_a(0.2F, -16.5F, 0.5F);
    (this.gunModel[6]).field_78796_g = -1.0471976F;
    this.gunModel[7].addShapeBox(0.0F, 0.0F, -1.15F, 1, 4, 2, 0.0F, -0.45F, 1.0F, -0.4F, -0.45F, 1.0F, -0.4F, -0.45F, 1.0F, -0.6F, -0.45F, 1.0F, -0.6F, -0.45F, 1.0F, -0.5F, -0.45F, 1.0F, -0.5F, -0.45F, 1.0F, -0.5F, -0.45F, 1.0F, -0.5F);
    this.gunModel[7].func_78793_a(0.2F, -11.5F, 0.5F);
    (this.gunModel[7]).field_78796_g = -1.0471976F;
    this.gunModel[8].addShapeBox(0.0F, 0.0F, -1.15F, 1, 4, 2, 0.0F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F, -0.45F, 0.0F, -0.5F);
    this.gunModel[8].func_78793_a(0.2F, -6.5F, 0.5F);
    (this.gunModel[8]).field_78796_g = -1.0471976F;
    this.gunModel[9].addShapeBox(0.0F, 0.0F, -1.15F, 1, 1, 2, 0.0F, -0.4F, 0.5F, -0.45F, -0.4F, 0.5F, -0.45F, -0.4F, 0.5F, -0.45F, -0.4F, 0.5F, -0.45F, -0.4F, 0.0F, -0.45F, -0.4F, 0.0F, -0.45F, -0.4F, 0.0F, -0.45F, -0.4F, 0.0F, -0.45F);
    this.gunModel[9].func_78793_a(0.2F, -3.5F, 0.5F);
    (this.gunModel[9]).field_78796_g = -1.0471976F;
  }
}
