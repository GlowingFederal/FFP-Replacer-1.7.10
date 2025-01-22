package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelUSAtankHelm extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelUSAtankHelm() {
    this.headModel = new ModelRendererTurbo[20];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.15F, 0.15F, 0.15F, 0.15F, 0.15F, 0.15F, 0.1F, 0.15F, 0.4F, 0.1F, 0.15F, 0.4F, 0.45F, 0.0F, 0.5F, 0.45F, 0.0F, 0.5F, 0.45F, 0.5F, 0.6F, 0.45F, 0.5F, 0.6F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -8.4F, -4.0F, 8, 2, 10, 0.0F, -1.85F, 0.8F, -0.9F, -1.85F, 0.8F, -0.9F, -1.85F, 1.0F, -2.85F, -1.85F, 1.0F, -2.85F, 0.15F, -1.75F, 0.15F, 0.15F, -1.75F, 0.15F, 0.1F, -1.75F, -1.6F, 0.1F, -1.75F, -1.6F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -5.4F, -3.9F, 8, 1, 6, 0.0F, 0.5F, -0.2F, 0.6F, 0.5F, -0.2F, 0.6F, 0.5F, -0.6F, 0.7F, 0.5F, -0.6F, 0.7F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F, 0.5F, 0.4F, 0.7F, 0.5F, 0.4F, 0.7F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.4F, -4.0F, -4.5F, 1, 1, 1, 0.0F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-5.0F, -3.8F, -3.0F, 10, 1, 8, 0.0F, -0.35F, 0.0F, -0.2F, -0.35F, 0.0F, -0.2F, -0.4F, 0.2F, -0.2F, -0.4F, 0.2F, -0.2F, -0.35F, -0.4F, -0.2F, -0.35F, -0.4F, -0.2F, -0.4F, -0.5F, -0.3F, -0.4F, -0.5F, -0.3F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(2.1F, -4.7F, -4.8F, 2, 2, 1, 0.0F, 0.0F, -0.3F, -0.2F, -0.5F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, 0.6F, -0.2F, -0.6F, 0.4F, -0.2F, -0.1F, 0.4F, -0.2F, 0.0F, 0.6F, -0.2F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(0.1F, -4.7F, -4.8F, 2, 2, 1, 0.0F, 0.1F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.1F, 0.1F, -0.2F, 0.0F, 0.6F, -0.2F, 0.0F, 0.6F, -0.2F, 0.1F, 0.1F, -0.2F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(3.4F, -4.0F, -4.5F, 1, 1, 1, 0.0F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F, -0.2F, -0.15F, -0.2F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-4.0F, -4.0F, 3.0F, 8, 2, 1, 0.0F, 0.45F, 0.9F, 0.5F, 0.45F, 0.9F, 0.5F, 0.6F, 1.0F, 0.7F, 0.6F, 1.0F, 0.7F, 0.15F, 0.15F, 0.15F, 0.15F, 0.15F, 0.15F, 0.1F, 0.15F, 0.4F, 0.1F, 0.15F, 0.4F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(3.8F, -4.0F, -2.5F, 1, 2, 4, 0.0F, 0.0F, 1.0F, 0.5F, -0.5F, 1.0F, 0.5F, -0.5F, 0.5F, 1.0F, 0.0F, 0.5F, 1.0F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 1.0F, -0.3F, -0.5F, 1.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(3.8F, -2.5F, -2.5F, 1, 2, 4, 0.0F, -0.3F, 0.0F, 0.5F, -0.3F, 0.0F, 0.5F, -0.3F, 0.0F, 1.0F, -0.3F, 0.0F, 1.0F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 0.8F, -0.3F, -0.5F, 0.8F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(3.8F, -1.5F, -2.5F, 1, 2, 4, 0.0F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 0.8F, -0.3F, -0.5F, 0.8F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, -1.0F, -0.3F, -0.3F, -1.0F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-5.0F, -4.0F, -4.0F, 10, 1, 1, 0.0F, -0.85F, -0.2F, -0.2F, -0.85F, -0.2F, -0.2F, -0.35F, -0.2F, 0.2F, -0.35F, -0.2F, 0.2F, -0.85F, -0.2F, -0.2F, -0.85F, -0.2F, -0.2F, -0.35F, -0.2F, 0.2F, -0.35F, -0.2F, 0.2F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-2.1F, -4.7F, -4.8F, 2, 2, 1, 0.0F, 0.0F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, 0.6F, -0.2F, 0.1F, 0.1F, -0.2F, 0.1F, 0.1F, -0.2F, 0.0F, 0.6F, -0.2F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(-4.1F, -4.7F, -4.8F, 2, 2, 1, 0.0F, -0.5F, -0.5F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, -0.2F, -0.5F, -0.2F, -0.6F, 0.4F, -0.2F, 0.0F, 0.6F, -0.2F, 0.0F, 0.6F, -0.2F, -0.1F, 0.4F, -0.2F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(-4.8F, -4.0F, -2.5F, 1, 2, 4, 0.0F, -0.5F, 1.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 0.5F, 1.0F, -0.5F, 0.5F, 1.0F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 1.0F, -0.3F, -0.5F, 1.0F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(-4.8F, -2.5F, -2.5F, 1, 2, 4, 0.0F, -0.3F, 0.0F, 0.5F, -0.3F, 0.0F, 0.5F, -0.3F, 0.0F, 1.0F, -0.3F, 0.0F, 1.0F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 0.8F, -0.3F, -0.5F, 0.8F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(-4.8F, -1.5F, -2.5F, 1, 2, 4, 0.0F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 0.5F, -0.3F, -0.5F, 0.8F, -0.3F, -0.5F, 0.8F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, -1.0F, -0.3F, -0.3F, -1.0F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(3.6F, -3.5F, -2.5F, 1, 2, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(-4.6F, -3.5F, -2.5F, 1, 2, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
