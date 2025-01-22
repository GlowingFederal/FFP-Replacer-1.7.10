package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMingKuyakHelm extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelMingKuyakHelm() {
    this.headModel = new ModelRendererTurbo[27];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 73, 9, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 73, 9, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 73, 33, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 81, 25, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[21] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.headModel[22] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.headModel[23] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.headModel[24] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.headModel[25] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[26] = new ModelRendererTurbo((ModelBase)this, 73, 33, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -7.5F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.7F, 0.3F, 0.2F, 0.7F, 0.3F, 0.2F, 0.7F, 0.3F, 0.2F, 0.7F, 0.3F, 0.9F, -1.0F, 0.9F, 0.9F, -1.0F, 0.9F, 0.9F, -1.0F, 0.9F, 0.9F, -1.0F, 0.9F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -9.3F, -4.0F, 8, 1, 8, 0.0F, -1.8F, 1.4F, -1.8F, -1.8F, 1.4F, -1.8F, -1.8F, 1.4F, -1.8F, -1.8F, 1.4F, -1.8F, 0.2F, 0.1F, 0.3F, 0.2F, 0.1F, 0.3F, 0.2F, 0.1F, 0.3F, 0.2F, 0.1F, 0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-0.5F, -15.8F, -0.5F, 1, 4, 1, 0.0F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -6.0F, -4.0F, 8, 2, 1, 0.0F, 0.7F, -0.5F, 0.9F, 0.7F, -0.5F, 0.9F, 0.7F, -0.5F, 0.9F, 0.7F, -0.5F, 0.9F, 0.7F, -0.5F, 0.9F, 0.7F, -0.5F, 0.9F, 0.7F, -0.3F, -0.1F, 0.7F, -0.3F, -0.1F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -5.5F, -8.0F, 4, 1, 3, 0.0F, -1.5F, -0.4F, -1.2F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F, 0.0F, 0.5F, -0.4F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(0.0F, -5.5F, -8.0F, 4, 1, 3, 0.0F, 0.0F, -0.4F, -0.5F, -1.0F, -0.4F, -1.2F, 0.5F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, 0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-0.5F, -16.8F, -0.5F, 1, 1, 1, 0.0F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-4.0F, -6.0F, 4.7F, 16, 8, 1, 0.0F, 0.9F, -0.2F, 0.0F, -7.1F, -0.2F, 0.0F, -7.1F, -0.2F, -0.6F, 0.9F, -0.2F, -0.6F, 1.3F, -4.2F, -0.3F, -6.7F, -4.2F, -0.3F, -6.7F, -4.2F, -0.3F, 1.3F, -4.2F, -0.3F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-6.0F, -2.4F, 5.0F, 24, 6, 1, 0.0F, -0.7F, -0.2F, 0.0F, -12.7F, -0.2F, 0.0F, -12.7F, -0.2F, -0.6F, -0.7F, -0.2F, -0.6F, 0.5F, -2.5F, -0.9F, -11.5F, -2.5F, -0.9F, -11.5F, -2.5F, 0.3F, 0.5F, -2.5F, 0.3F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-5.5F, -6.0F, 1.0F, 1, 8, 8, 0.0F, -0.5F, -0.2F, 1.0F, 0.0F, -0.2F, 1.0F, 0.0F, -0.2F, -4.0F, -0.6F, -0.2F, -4.0F, 0.0F, -4.2F, 0.5F, -0.6F, -4.2F, 0.5F, -0.6F, -4.2F, -4.0F, 0.0F, -4.2F, -4.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-6.1F, -2.4F, 2.0F, 1, 6, 6, 0.0F, -0.6F, -0.2F, 1.5F, 0.0F, -0.2F, 1.5F, 0.0F, -0.2F, -3.0F, -0.6F, -0.2F, -3.0F, 0.5F, -4.0F, 0.9F, -1.1F, -4.0F, 0.9F, -1.4F, -2.5F, -2.0F, 0.8F, -2.5F, -2.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-5.5F, -6.0F, -5.0F, 1, 8, 8, 0.0F, -0.6F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -2.0F, -0.7F, -0.2F, -2.0F, -0.6F, -4.0F, -0.2F, 0.0F, -4.0F, -0.2F, 0.0F, -4.5F, -3.5F, -0.6F, -4.5F, -3.5F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-5.5F, -2.0F, -5.0F, 1, 4, 8, 0.0F, -0.6F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.5F, -3.5F, -0.6F, 0.5F, -3.5F, -1.1F, -1.2F, 0.0F, 0.5F, -1.2F, 0.0F, 0.2F, -2.4F, -4.5F, -0.8F, -2.4F, -4.5F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-2.0F, -11.8F, -2.0F, 4, 1, 4, 0.0F, -1.5F, -0.2F, -1.5F, -1.5F, -0.2F, -1.5F, -1.5F, -0.2F, -1.5F, -1.5F, -0.2F, -1.5F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(-1.0F, -12.8F, -1.0F, 2, 1, 2, 0.0F, -0.8F, -0.3F, -0.8F, -0.8F, -0.3F, -0.8F, -0.8F, -0.3F, -0.8F, -0.8F, -0.3F, -0.8F, -0.5F, 0.2F, -0.5F, -0.5F, 0.2F, -0.5F, -0.5F, 0.2F, -0.5F, -0.5F, 0.2F, -0.5F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(-0.5F, -15.3F, 0.0F, 1, 3, 4, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -2.9F, 0.0F, -0.4F, -2.9F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(-4.5F, -6.1F, -4.5F, 9, 1, 9, 0.0F, 0.6F, -0.1F, 0.6F, 0.6F, -0.1F, 0.6F, 0.6F, -0.1F, 0.8F, 0.6F, -0.1F, 0.8F, 0.6F, -0.1F, 0.6F, 0.6F, -0.1F, 0.6F, 0.6F, -0.1F, 0.8F, 0.6F, -0.1F, 0.8F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(-0.5F, -16.5F, -0.5F, 1, 2, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, -0.8F, 0.6F, 0.2F, -0.8F, 0.6F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(-0.5F, 0.0F, -3.5F, 1, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, -1.2F, 0.5F, 0.5F, -1.2F, 0.5F, 0.0F, 0.8F, 0.0F, 0.0F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(-0.5F, 0.0F, -3.5F, 1, 2, 1, 0.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -1.2F, 0.5F, 0.5F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.0F, -1.2F, 0.5F, 0.0F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[20].addShapeBox(-4.0F, -5.0F, -3.4F, 8, 5, 1, 0.0F, 0.2F, 0.3F, -4.2F, 0.2F, 0.3F, -4.2F, 0.2F, 0.3F, 3.8F, 0.2F, 0.3F, 3.8F, 0.2F, 0.3F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F, 0.3F, -0.2F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[21].addShapeBox(-0.5F, -13.5F, -0.5F, 1, 2, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, -0.8F, 0.6F, 0.2F, -0.8F, 0.6F);
    this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[22].addShapeBox(-1.0F, -7.5F, -5.0F, 2, 2, 2, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[23].addShapeBox(4.5F, -6.0F, -5.0F, 1, 8, 8, 0.0F, 0.0F, -0.2F, -0.2F, -0.6F, -0.2F, -0.2F, -0.7F, -0.2F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, -4.0F, -0.2F, -0.6F, -4.0F, -0.2F, -0.6F, -4.5F, -3.5F, 0.0F, -4.5F, -3.5F);
    this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[24].addShapeBox(4.5F, -2.0F, -5.0F, 1, 4, 8, 0.0F, 0.0F, 0.0F, -0.2F, -0.6F, 0.0F, -0.2F, -0.6F, 0.5F, -3.5F, 0.0F, 0.5F, -3.5F, 0.5F, -1.2F, 0.0F, -1.1F, -1.2F, 0.0F, -0.8F, -2.4F, -4.5F, 0.2F, -2.4F, -4.5F);
    this.headModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[25].addShapeBox(4.5F, -6.0F, 1.0F, 1, 8, 8, 0.0F, 0.0F, -0.2F, 1.0F, -0.5F, -0.2F, 1.0F, -0.6F, -0.2F, -4.0F, 0.0F, -0.2F, -4.0F, -0.6F, -4.2F, 0.5F, 0.0F, -4.2F, 0.5F, 0.0F, -4.2F, -4.0F, -0.6F, -4.2F, -4.0F);
    this.headModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[26].addShapeBox(5.1F, -2.4F, 2.0F, 1, 6, 6, 0.0F, 0.0F, -0.2F, 1.5F, -0.6F, -0.2F, 1.5F, -0.6F, -0.2F, -3.0F, 0.0F, -0.2F, -3.0F, -1.1F, -4.0F, 0.9F, 0.5F, -4.0F, 0.9F, 0.8F, -2.5F, -2.0F, -1.4F, -2.5F, -2.0F);
    this.headModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
