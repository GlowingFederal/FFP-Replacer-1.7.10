package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelAtticHelmet extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelAtticHelmet() {
    this.headModel = new ModelRendererTurbo[26];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 113, 9, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 73, 9, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 97, 17, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.headModel[21] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.headModel[22] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[23] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.headModel[24] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.headModel[25] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 2, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -6.5F, -4.0F, 8, 1, 8, 0.0F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.4F, 0.9F, 0.9F, 0.4F, 0.9F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-5.0F, -5.5F, 1.8F, 10, 1, 3, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, -0.4F, 0.1F, -0.1F, -0.4F, 0.1F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 1.0F, 0.0F, -0.1F, 1.0F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(3.85F, -5.5F, -0.2F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-5.0F, -4.5F, 1.8F, 10, 3, 3, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, -1.0F, 0.1F, -0.1F, -1.0F, 0.1F, -0.1F, -0.7F, -1.0F, -0.1F, -0.7F, -1.0F, -0.1F, 0.0F, 1.0F, -0.1F, 0.0F, 1.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.85F, -5.5F, -0.2F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-0.5F, -11.3F, -3.5F, 1, 1, 8, 0.0F, -0.1F, 0.0F, -2.2F, -0.1F, 0.0F, -2.2F, -0.1F, 0.0F, -2.2F, -0.1F, 0.0F, -2.2F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.5F, 0.1F, -0.1F, 0.5F, 0.1F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-0.5F, -9.5F, 2.5F, 1, 3, 2, 0.0F, -0.1F, 0.5F, 0.1F, -0.1F, 0.5F, 0.1F, -0.1F, 0.3F, 0.1F, -0.1F, 0.3F, 0.1F, -0.1F, 0.5F, 0.7F, -0.1F, 0.5F, 0.7F, -0.1F, -2.5F, 1.2F, -0.1F, -2.5F, 1.2F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-0.5F, -9.5F, -3.5F, 1, 3, 6, 0.0F, -0.1F, 0.8F, 0.1F, -0.1F, 0.8F, 0.1F, -0.1F, 0.5F, 0.1F, -0.1F, 0.5F, 0.1F, -0.1F, -0.5F, -1.3F, -0.1F, -0.5F, -1.3F, -0.1F, -0.5F, 1.0F, -0.1F, -0.5F, 1.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-0.5F, -15.3F, -1.5F, 1, 4, 4, 0.0F, 0.15F, -0.5F, 1.0F, 0.15F, -0.5F, 1.0F, 0.15F, -0.5F, 1.0F, 0.15F, -0.5F, 1.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-0.5F, -15.3F, -3.5F, 1, 4, 2, 0.0F, 0.15F, -2.5F, 1.5F, 0.15F, -2.5F, 1.5F, 0.15F, -0.5F, -1.0F, 0.15F, -0.5F, -1.0F, -0.15F, 1.0F, 0.0F, -0.15F, 1.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-0.5F, -15.3F, 2.5F, 1, 4, 4, 0.0F, 0.15F, -0.5F, -1.0F, 0.15F, -0.5F, -1.0F, 0.15F, -3.5F, 1.0F, 0.15F, -3.5F, 1.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 1.4F, -2.0F, -0.15F, 1.4F, -2.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-0.5F, -10.0F, 4.5F, 1, 3, 3, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, 0.15F, 1.85F, 0.0F, 0.15F, 1.85F, 0.0F, -0.15F, -2.0F, -1.2F, -0.15F, -2.0F, -1.2F, 0.15F, -3.0F, 1.0F, 0.15F, -3.0F, 1.0F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(3.85F, -5.5F, -4.05F, 1, 2, 3, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.7F, 0.2F, 0.0F, 1.7F, 0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.8F, 0.2F, 0.0F, 0.8F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(3.85F, -3.5F, -4.0F, 1, 2, 3, 0.0F, 0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.8F, 0.2F, 0.0F, 0.8F, 0.7F, -0.8F, 0.5F, -0.3F, -0.8F, 0.5F, 0.0F, -0.8F, 1.0F, 0.7F, -0.8F, 1.0F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(3.85F, -2.0F, -4.0F, 1, 2, 3, 0.0F, 0.7F, 0.3F, 0.5F, -0.3F, 0.3F, 0.5F, 0.0F, 0.3F, 1.0F, 0.7F, 0.3F, 1.0F, 1.3F, -0.5F, 0.4F, -0.8F, -0.5F, 0.4F, -0.2F, -0.5F, 0.8F, 0.7F, -0.5F, 0.8F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(3.85F, -1.0F, -4.0F, 1, 2, 3, 0.0F, 1.3F, -0.5F, 0.4F, -0.8F, -0.5F, 0.4F, -0.2F, -0.5F, 0.8F, 0.7F, -0.5F, 0.8F, 1.0F, -0.3F, 0.6F, -1.5F, -0.3F, 0.6F, -1.0F, -0.3F, 0.0F, 0.7F, -0.3F, 0.0F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(-4.85F, -1.0F, -4.0F, 1, 2, 3, 0.0F, -0.8F, -0.5F, 0.4F, 1.3F, -0.5F, 0.4F, 0.7F, -0.5F, 0.8F, -0.2F, -0.5F, 0.8F, -1.5F, -0.3F, 0.6F, 1.0F, -0.3F, 0.6F, 0.7F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(-4.85F, -2.0F, -4.0F, 1, 2, 3, 0.0F, -0.3F, 0.3F, 0.5F, 0.7F, 0.3F, 0.5F, 0.7F, 0.3F, 1.0F, 0.0F, 0.3F, 1.0F, -0.8F, -0.5F, 0.4F, 1.3F, -0.5F, 0.4F, 0.7F, -0.5F, 0.8F, -0.2F, -0.5F, 0.8F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[20].addShapeBox(-4.85F, -3.5F, -4.0F, 1, 2, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.2F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, -0.3F, -0.8F, 0.5F, 0.7F, -0.8F, 0.5F, 0.7F, -0.8F, 1.0F, 0.0F, -0.8F, 1.0F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[21].addShapeBox(-4.85F, -5.5F, -4.05F, 1, 2, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 1.7F, 0.0F, 0.0F, 1.7F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.2F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F);
    this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[22].addShapeBox(-5.0F, -6.0F, -5.2F, 10, 1, 6, 0.0F, 0.0F, 1.0F, -0.5F, 0.0F, 1.0F, -0.5F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.2F, -0.5F, 0.0F, 0.2F, -0.5F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F);
    this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[23].addShapeBox(-5.0F, -7.1F, -5.5F, 5, 2, 1, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 1.5F, 0.8F, 0.0F, 1.5F, -1.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, 0.8F, 0.0F, 0.2F, -1.2F, 0.0F, 0.2F, -0.2F);
    this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[24].addShapeBox(0.0F, -7.1F, -5.5F, 5, 2, 1, 0.0F, 0.0F, 1.5F, 0.8F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 1.5F, -1.2F, 0.0F, 0.2F, 0.8F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -1.2F);
    this.headModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[25].addShapeBox(-5.0F, -5.5F, -4.2F, 10, 1, 4, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F);
    this.headModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
