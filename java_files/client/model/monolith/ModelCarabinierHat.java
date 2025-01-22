package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelCarabinierHat extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelCarabinierHat() {
    this.headModel = new ModelRendererTurbo[22];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 41, 49, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 17, 49, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 57, 41, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 33, 57, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.headModel[21] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -9.0F, -4.0F, 4, 3, 8, 0.0F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, 1.3F, 0.2F, 0.0F, 1.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 1.5F, 0.9F, -0.5F, 1.5F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -10.5F, -3.3F, 8, 1, 8, 0.0F, -2.0F, 0.2F, -3.3F, -2.0F, 0.2F, -3.3F, -2.0F, 0.0F, -1.0F, -2.0F, 0.0F, -1.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.6F, 0.2F, 0.5F, 0.6F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -6.5F, -5.0F, 8, 2, 9, 0.0F, 0.9F, 0.0F, -0.1F, 0.9F, 0.0F, -0.1F, 0.9F, 0.0F, 1.5F, 0.9F, 0.0F, 1.5F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, 0.4F, 0.9F, 0.9F, 0.4F, 0.9F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-5.0F, -5.5F, 0.8F, 10, 2, 4, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, -0.4F, 0.1F, -0.1F, -0.4F, 0.1F, -0.1F, 0.2F, -0.5F, -0.1F, 0.2F, -0.5F, -0.1F, 1.0F, 0.0F, -0.1F, 1.0F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-5.0F, -4.5F, 0.8F, 10, 4, 4, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, -2.0F, 0.1F, -0.1F, -2.0F, 0.1F, -0.1F, -1.7F, -1.0F, -0.1F, -1.7F, -1.0F, -0.1F, 0.5F, 1.5F, -0.1F, 0.5F, 1.5F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-2.0F, -9.0F, 3.0F, 4, 3, 1, 0.0F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, 1.3F, 0.2F, 0.0F, 1.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 1.5F, 0.9F, -0.5F, 1.5F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-0.5F, -9.0F, -3.8F, 1, 1, 1, 0.0F, 2.2F, 0.0F, -0.4F, 2.2F, 0.0F, -0.4F, 2.2F, 0.0F, 1.0F, 2.2F, 0.0F, 1.0F, 2.2F, 1.5F, 0.9F, 2.2F, 1.5F, 0.9F, 2.2F, 1.5F, 1.2F, 2.2F, 1.5F, 1.2F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-4.5F, -5.5F, -8.5F, 9, 1, 2, 0.0F, -1.8F, -0.8F, -1.3F, -1.8F, -0.8F, -1.3F, 0.2F, -0.5F, 0.0F, 0.2F, -0.5F, 0.0F, -1.8F, 0.9F, 0.3F, -1.8F, 0.9F, 0.3F, 1.0F, 0.5F, -0.1F, 1.0F, 0.5F, -0.1F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-4.5F, -6.0F, -6.5F, 9, 1, 3, 0.0F, 0.2F, -1.0F, 0.0F, 0.2F, -1.0F, 0.0F, 0.2F, 0.0F, 0.7F, 0.2F, 0.0F, 0.7F, 1.0F, 1.0F, 0.1F, 1.0F, 1.0F, 0.1F, -1.3F, 0.0F, 4.3F, -1.3F, 0.0F, 4.3F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.0F, -7.0F, -6.0F, 8, 2, 1, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-3.0F, -9.0F, -5.0F, 6, 2, 1, 0.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-1.0F, -7.5F, 6.1F, 2, 2, 1, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.5F, 0.4F, 0.3F, 0.5F, 0.4F, 0.3F, 0.5F, -0.4F, 0.3F, 0.5F, -0.4F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-1.0F, -11.5F, 6.1F, 2, 4, 1, 0.0F, 0.3F, 0.0F, 0.8F, 0.3F, 0.0F, 0.8F, 0.3F, 0.0F, -0.2F, 0.3F, 0.0F, -0.2F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-1.0F, -14.5F, 6.1F, 2, 3, 1, 0.0F, 0.3F, 0.7F, 3.0F, 0.3F, 0.7F, 3.0F, 0.3F, -1.0F, -1.5F, 0.3F, -1.0F, -1.5F, 0.3F, 0.0F, 0.8F, 0.3F, 0.0F, 0.8F, 0.3F, 0.0F, -0.2F, 0.3F, 0.0F, -0.2F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(-1.0F, -15.0F, 1.1F, 2, 2, 3, 0.0F, 0.3F, 0.8F, 0.0F, 0.3F, 0.8F, 0.0F, 0.3F, 0.2F, -1.0F, 0.3F, 0.2F, -1.0F, 0.3F, -0.5F, 0.0F, 0.3F, -0.5F, 0.0F, 0.3F, 0.5F, 0.6F, 0.3F, 0.5F, 0.6F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(-1.0F, -15.0F, -1.9F, 2, 2, 3, 0.0F, 0.3F, 1.0F, 1.3F, 0.3F, 1.0F, 1.3F, 0.3F, 0.8F, 0.0F, 0.3F, 0.8F, 0.0F, 0.3F, 0.5F, 0.6F, 0.3F, 0.5F, 0.6F, 0.3F, -0.5F, 0.0F, 0.3F, -0.5F, 0.0F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(-0.5F, -14.0F, 0.1F, 1, 4, 4, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(-0.5F, -12.0F, 4.1F, 1, 8, 2, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(-1.0F, -5.0F, 6.1F, 2, 2, 1, 0.0F, 0.3F, 0.0F, 0.7F, 0.3F, 0.0F, 0.7F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.2F, 0.0F, -1.0F, 0.2F, 0.0F, -1.0F, 0.0F, 0.0F, 1.3F, 0.0F, 0.0F, 1.3F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(-4.0F, -4.5F, -3.0F, 8, 5, 1, 0.0F, 1.2F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.2F, 0.0F, 0.5F, 1.2F, 0.0F, 0.5F, 0.25F, 0.0F, 0.0F, 0.25F, -0.125F, 0.0F, 0.25F, -0.125F, 0.0F, 0.25F, -0.125F, 0.0F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.headModel[19]).field_78795_f = -0.12217305F;
    this.headModel[20].addShapeBox(-2.0F, -5.5F, -3.0F, 4, 1, 1, 0.0F, 3.5F, 0.2F, 0.0F, 3.5F, 0.2F, 0.0F, 3.5F, 0.2F, 0.5F, 3.5F, 0.2F, 0.5F, 3.5F, 0.0F, 0.0F, 3.5F, 0.0F, 0.0F, 3.5F, 0.0F, 0.5F, 3.5F, 0.0F, 0.5F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.headModel[20]).field_78795_f = -0.12217305F;
    this.headModel[21].addShapeBox(0.0F, -9.0F, -4.0F, 4, 3, 8, 0.0F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, 1.3F, 0.2F, 0.0F, 1.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 1.5F, 0.9F, -0.5F, 1.5F);
    this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
