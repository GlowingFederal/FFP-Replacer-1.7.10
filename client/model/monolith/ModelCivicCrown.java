package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelCivicCrown extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelCivicCrown() {
    this.headModel = new ModelRendererTurbo[20];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-1.5F, -6.1F, -2.0F, 3, 1, 2, 0.0F, 3.6F, 0.5F, 0.2F, 3.5F, 0.5F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F, 3.6F, 0.5F, 0.2F, 3.5F, 0.5F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-1.5F, -5.7F, -1.0F, 3, 1, 2, 0.0F, 3.6F, 0.5F, 0.2F, 3.5F, 0.5F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F, 3.6F, 0.5F, 0.2F, 3.5F, 0.5F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-1.5F, -5.5F, 0.0F, 3, 1, 2, 0.0F, 3.6F, 0.5F, 0.2F, 3.5F, 0.5F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F, 3.6F, 0.5F, 0.2F, 3.5F, 0.5F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-1.5F, -5.3F, 1.0F, 3, 1, 2, 0.0F, 3.6F, 0.5F, 0.2F, 3.5F, 0.5F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F, 3.6F, 0.5F, 0.2F, 3.5F, 0.5F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(3.5F, -5.3F, 2.0F, 1, 1, 2, 0.0F, 0.6F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.6F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-1.5F, -6.5F, -3.0F, 3, 1, 2, 0.0F, 3.6F, 0.5F, 0.2F, 3.5F, 0.5F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F, 3.6F, 0.5F, 0.2F, 3.5F, 0.5F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.5F, -6.9F, -4.0F, 1, 1, 2, 0.0F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-4.5F, -5.1F, 2.0F, 1, 1, 2, 0.0F, 0.6F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.6F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(3.5F, -7.0F, -4.0F, 1, 1, 2, 0.0F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(2.5F, -5.1F, 3.2F, 2, 1, 1, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.6F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.6F, 0.2F, 0.2F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(1.5F, -5.0F, 3.3F, 2, 1, 1, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.6F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.6F, 0.2F, 0.2F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(0.5F, -4.8F, 3.4F, 2, 1, 1, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.6F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.6F, 0.2F, 0.2F, 0.0F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-0.5F, -4.6F, 3.5F, 2, 1, 1, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.6F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.6F, 0.2F, 0.2F, 0.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-1.5F, -4.6F, 3.5F, 2, 1, 1, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.6F, 0.2F, 0.5F, 0.5F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.6F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(-2.5F, -4.8F, 3.4F, 2, 1, 1, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.6F, 0.2F, 0.5F, 0.5F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.6F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(-3.5F, -5.0F, 3.3F, 2, 1, 1, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.6F, 0.2F, 0.5F, 0.5F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.6F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(-4.2F, -7.2F, -4.5F, 1, 1, 2, 0.0F, 0.2F, 0.7F, 0.2F, 0.5F, 0.7F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(-3.6F, -7.6F, -5.0F, 1, 1, 2, 0.0F, 0.2F, 0.7F, 0.2F, 0.5F, 0.7F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(3.2F, -7.2F, -4.5F, 1, 1, 2, 0.0F, 0.5F, 0.7F, 0.2F, 0.2F, 0.7F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.5F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(2.8F, -7.6F, -5.0F, 1, 1, 2, 0.0F, 0.5F, 0.7F, 0.2F, 0.2F, 0.7F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.5F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
