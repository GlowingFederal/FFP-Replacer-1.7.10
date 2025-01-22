package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMingHat extends ModelCustomArmour {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelMingHat() {
    this.headModel = new ModelRendererTurbo[24];
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 129, 1, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 153, 1, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 177, 1, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 193, 1, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 209, 1, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 225, 1, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 257, 1, this.textureX, this.textureY);
    this.headModel[21] = new ModelRendererTurbo((ModelBase)this, 273, 1, this.textureX, this.textureY);
    this.headModel[22] = new ModelRendererTurbo((ModelBase)this, 289, 1, this.textureX, this.textureY);
    this.headModel[23] = new ModelRendererTurbo((ModelBase)this, 305, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-0.5F, -10.8F, -0.5F, 1, 1, 1, 0.0F, 0.3F, 0.3F, 0.3F, 0.2F, 0.3F, 0.2F, 0.2F, 0.3F, 0.2F, 0.3F, 0.3F, 0.3F, 1.3F, 0.0F, 1.3F, 1.2F, 0.0F, 1.2F, 1.2F, 0.0F, 1.2F, 1.3F, 0.0F, 1.3F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-0.5F, -12.5F, 0.5F, 1, 1, 3, 0.0F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-0.5F, -11.8F, 3.5F, 1, 3, 1, 0.0F, 0.5F, -0.5F, 0.5F, 0.5F, -0.5F, 0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.8F, 0.0F, -2.0F, 0.8F, 0.0F, -2.0F, 0.8F, 0.0F, 2.5F, 0.8F, 0.0F, 2.5F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-0.5F, -8.8F, 5.5F, 1, 3, 1, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.9F, 0.3F, -1.0F, 0.9F, 0.3F, -1.0F, 0.9F, 0.0F, 1.5F, 0.9F, 0.0F, 1.5F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-0.5F, -5.8F, 6.5F, 1, 4, 1, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-4.0F, -6.0F, -3.0F, 1, 5, 7, 0.0F, 0.9F, -0.5F, 0.9F, 0.2F, -0.5F, 0.9F, 0.2F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(3.0F, -6.0F, -3.0F, 1, 5, 7, 0.0F, 0.2F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.2F, -0.5F, 0.9F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-0.5F, -11.8F, -0.5F, 1, 1, 1, 0.0F, 0.3F, 0.5F, -0.7F, 0.3F, 0.5F, -0.7F, 0.3F, -0.3F, 1.3F, 0.3F, -0.3F, 1.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-0.5F, -11.8F, 3.5F, 1, 1, 1, 0.0F, 0.3F, -0.3F, 1.3F, 0.3F, -0.3F, 1.3F, 0.3F, 0.8F, -1.0F, 0.3F, 0.8F, -1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-1.0F, -9.0F, -4.0F, 2, 4, 1, 0.0F, 0.2F, -0.1F, 0.3F, 0.2F, -0.1F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-0.5F, -10.0F, -3.0F, 1, 4, 1, 0.0F, 0.2F, -0.1F, 0.3F, 0.2F, -0.1F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-5.0F, -8.0F, -2.0F, 1, 4, 3, 0.0F, 0.9F, -1.5F, 0.9F, -1.0F, -1.5F, 0.9F, -1.6F, -0.5F, 0.9F, 1.5F, -0.5F, 0.9F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(-3.0F, -6.0F, 1.0F, 6, 5, 3, 0.0F, 0.2F, -0.5F, 0.9F, 0.2F, -0.5F, 0.9F, 0.2F, -0.5F, 0.9F, 0.2F, -0.5F, 0.9F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(4.0F, -8.0F, -2.0F, 1, 4, 3, 0.0F, -1.0F, -1.5F, 0.9F, 0.9F, -1.5F, 0.9F, 1.5F, -0.5F, 0.9F, -1.6F, -0.5F, 0.9F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(3.0F, -4.0F, 0.4F, 1, 5, 4, 0.0F, 0.0F, -0.2F, -1.2F, 0.4F, -0.2F, 0.3F, 0.4F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.3F, -3.7F, 3.4F, 0.7F, 0.3F, 2.6F, -0.7F, 2.7F, 0.0F, -0.7F, 3.1F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(0.0F, -4.0F, 3.4F, 3, 5, 1, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.8F, -1.5F, 0.0F, -0.3F, -0.7F, 0.0F, -0.7F, 3.1F, 0.0F, -0.7F, 3.1F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(-4.0F, -4.0F, 0.4F, 1, 5, 4, 0.0F, 0.4F, -0.2F, 0.3F, 0.0F, -0.2F, -1.2F, 0.0F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 3.4F, 0.7F, 0.3F, 0.0F, -0.3F, -3.7F, 0.0F, -0.7F, 3.1F, 2.6F, -0.7F, 2.7F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(-3.0F, -4.0F, 3.4F, 3, 5, 1, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.3F, -0.7F, 0.0F, -0.8F, -1.5F, 0.0F, -0.7F, 3.1F, 0.0F, -0.7F, 3.1F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[20].addShapeBox(3.0F, -4.5F, 0.4F, 1, 5, 4, 0.0F, 0.0F, -0.2F, -1.2F, 0.4F, -0.2F, 0.3F, 0.4F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.3F, -3.7F, 3.4F, 0.7F, 0.3F, 2.6F, -0.7F, 2.7F, 0.0F, -0.7F, 3.1F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[21].addShapeBox(0.0F, -4.5F, 3.4F, 3, 5, 1, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.8F, -1.5F, 0.0F, -0.3F, -0.7F, 0.0F, -0.7F, 3.1F, 0.0F, -0.7F, 3.1F);
    this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[22].addShapeBox(-3.0F, -4.5F, 3.4F, 3, 5, 1, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.3F, -0.7F, 0.0F, -0.8F, -1.5F, 0.0F, -0.7F, 3.1F, 0.0F, -0.7F, 3.1F);
    this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[23].addShapeBox(-4.0F, -4.5F, 0.4F, 1, 5, 4, 0.0F, 0.4F, -0.2F, 0.3F, 0.0F, -0.2F, -1.2F, 0.0F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 3.4F, 0.7F, 0.3F, 0.0F, -0.3F, -3.7F, 0.0F, -0.7F, 3.1F, 2.6F, -0.7F, 2.7F);
    this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
