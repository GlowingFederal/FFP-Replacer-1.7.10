package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPolishCzapka extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelPolishCzapka() {
    this.headModel = new ModelRendererTurbo[10];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-5.0F, -8.5F, -5.0F, 10, 4, 9, 0.0F, -0.2F, -2.0F, -0.5F, -0.2F, -2.0F, -0.5F, 0.0F, -0.5F, 0.25F, 0.0F, -0.5F, 0.25F, -0.5F, 0.0F, -0.8F, -0.5F, 0.0F, -0.8F, -0.5F, 1.0F, 0.1F, -0.5F, 1.0F, 0.1F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(0.0F, -8.5F, -4.0F, 5, 2, 8, 0.0F, 0.0F, 0.75F, 1.5F, 0.5F, 0.5F, 0.8F, 0.5F, -0.5F, 0.5F, 0.0F, -0.5F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 0.25F, 0.0F, 0.7F, 0.25F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-5.0F, -8.5F, -4.0F, 5, 2, 8, 0.0F, 0.5F, 0.5F, 0.8F, 0.0F, 0.75F, 1.5F, 0.0F, -0.5F, 1.0F, 0.5F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.7F, 0.25F, 0.0F, 0.5F, 0.25F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -4.5F, -3.0F, 8, 5, 1, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.5F, 0.4F, 0.0F, 0.5F, 0.25F, 0.1F, 0.0F, 0.25F, 0.1F, 0.0F, 0.25F, 0.2F, 0.0F, 0.25F, 0.2F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.headModel[3]).field_78795_f = -0.12217305F;
    this.headModel[4].addShapeBox(-4.5F, -5.5F, -8.0F, 9, 1, 3, 0.0F, -2.5F, -0.7F, -1.3F, -2.5F, -0.7F, -1.3F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -2.0F, 0.5F, 0.3F, -2.0F, 0.5F, 0.3F, 0.3F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.5F, -5.5F, -5.0F, 9, 1, 3, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, 0.0F, 0.7F, -0.5F, 0.0F, 0.7F, 0.3F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, -2.0F, 0.0F, 4.3F, -2.0F, 0.0F, 4.3F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-5.0F, -11.5F, -4.0F, 5, 2, 4, 0.0F, -4.9F, 1.0F, 5.25F, 0.0F, 1.0F, 5.25F, 0.0F, -0.5F, 0.0F, 4.0F, -0.5F, 0.0F, 0.5F, 0.5F, 0.8F, 0.0F, 0.2F, 1.5F, 0.0F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-5.0F, -11.5F, 0.0F, 5, 2, 4, 0.0F, 4.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.5F, 4.25F, -4.9F, -1.5F, 4.25F, 0.5F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.5F, 1.0F, 0.5F, 1.5F, 0.5F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(0.0F, -11.5F, 0.0F, 5, 2, 4, 0.0F, 0.0F, -0.5F, 0.0F, 4.0F, -0.5F, 0.0F, -4.9F, -1.5F, 4.25F, 0.0F, -1.5F, 4.25F, 0.0F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 1.5F, 0.5F, 0.0F, 1.5F, 1.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(0.0F, -11.5F, -4.0F, 5, 2, 4, 0.0F, 0.0F, 1.0F, 5.25F, -4.9F, 1.0F, 5.25F, 4.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.2F, 1.5F, 0.5F, 0.5F, 0.8F, 0.5F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
