package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRapier extends ModelGun {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelRapier() {
    this.gunModel = new ModelRendererTurbo[11];
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
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, -0.65F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5F, 0.0F, 1.5F, 1.5F, 0.0F, 1.5F, 1.5F, 0.0F, 1.5F, 1.5F, 0.0F, 1.5F);
    this.gunModel[0].func_78793_a(0.2F, -3.2F, 0.5F);
    (this.gunModel[0]).field_78796_g = -1.0471976F;
    this.gunModel[1].addShapeBox(0.0F, 0.0F, -1.15F, 1, 15, 2, 0.0F, -0.45F, 0.0F, -0.95F, -0.45F, 0.0F, -0.95F, -0.45F, 0.0F, -0.95F, -0.45F, 0.0F, -0.95F, -0.45F, 1.0F, -0.65F, -0.45F, 1.0F, -0.65F, -0.45F, 1.0F, -0.65F, -0.45F, 1.0F, -0.65F);
    this.gunModel[1].func_78793_a(0.2F, -24.3F, 0.5F);
    (this.gunModel[1]).field_78796_g = -1.0471976F;
    this.gunModel[2].addShapeBox(0.0F, 0.0F, -0.65F, 1, 3, 1, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F);
    this.gunModel[2].func_78793_a(0.2F, -2.0F, 0.5F);
    (this.gunModel[2]).field_78796_g = -1.0471976F;
    this.gunModel[3].addShapeBox(0.0F, 0.0F, -0.65F, 1, 1, 1, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, -0.2F, -0.3F, -0.25F, -0.2F, -0.3F, -0.25F, -0.2F, -0.3F, -0.25F, -0.2F, -0.3F);
    this.gunModel[3].func_78793_a(0.2F, 1.4F, 0.5F);
    (this.gunModel[3]).field_78796_g = -1.0471976F;
    this.gunModel[4].addShapeBox(0.15F, 0.0F, -0.65F, 1, 1, 1, 0.0F, -0.2F, 0.1F, -0.5F, -0.2F, 0.1F, -0.5F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, -0.8F, -0.3F, -0.2F, -0.8F, -0.3F, -0.2F, -0.8F, 0.2F, -0.2F, -0.8F, 0.2F);
    this.gunModel[4].func_78793_a(-0.1F, 1.9F, 0.5F);
    (this.gunModel[4]).field_78796_g = -1.0471976F;
    this.gunModel[5].addShapeBox(0.15F, 0.0F, -0.65F, 1, 1, 1, 0.0F, -0.2F, -0.6F, -0.3F, -0.2F, -0.6F, -0.3F, -0.2F, -0.6F, 0.2F, -0.2F, -0.6F, 0.2F, -0.2F, 0.1F, -0.5F, -0.2F, 0.1F, -0.5F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F);
    this.gunModel[5].func_78793_a(-0.1F, 1.5F, 0.5F);
    (this.gunModel[5]).field_78796_g = -1.0471976F;
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, -0.6F, 0.0F, 0.0F, -0.6F, 0.0F, -0.4F, 0.5F, 0.0F, -0.4F, 0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F);
    this.gunModel[6].func_78793_a(0.2F, -2.5F, 0.5F);
    (this.gunModel[6]).field_78796_g = -1.0471976F;
    this.gunModel[7].addShapeBox(0.0F, 0.0F, -3.3F, 1, 1, 3, 0.0F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.4F, 0.5F, 0.0F, -0.4F, 0.5F, 0.0F, 0.0F, -0.6F, 0.0F, 0.0F, -0.6F);
    this.gunModel[7].func_78793_a(0.2F, -3.0F, 0.5F);
    (this.gunModel[7]).field_78796_g = -1.0471976F;
    this.gunModel[8].addShapeBox(0.0F, 0.8F, 2.8F, 1, 2, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F);
    this.gunModel[8].func_78793_a(0.2F, -2.9F, 0.5F);
    (this.gunModel[8]).field_78796_g = -1.0471976F;
    this.gunModel[9].addShapeBox(0.0F, 0.0F, -4.1F, 1, 2, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F);
    this.gunModel[9].func_78793_a(0.2F, -3.9F, 0.5F);
    (this.gunModel[9]).field_78796_g = -1.0471976F;
    this.gunModel[10].addShapeBox(0.0F, 0.0F, -1.15F, 1, 7, 2, 0.0F, -0.45F, -0.5F, -0.65F, -0.45F, -0.5F, -0.65F, -0.45F, -0.5F, -0.65F, -0.45F, -0.5F, -0.65F, -0.45F, -0.5F, -0.65F, -0.45F, -0.5F, -0.65F, -0.45F, -0.5F, -0.65F, -0.45F, -0.5F, -0.65F);
    this.gunModel[10].func_78793_a(0.2F, -8.8F, 0.5F);
    (this.gunModel[10]).field_78796_g = -1.0471976F;
  }
}
