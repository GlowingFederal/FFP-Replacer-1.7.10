package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRomanCrown extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelRomanCrown() {
    this.headModel = new ModelRendererTurbo[20];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 41, 33, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-8.5F, -10.0F, -4.0F, 8, 8, 8, 0.0F, -3.1F, -2.3F, 0.9F, 0.5F, -1.6F, 1.3F, 0.5F, -1.6F, 1.3F, -3.1F, -2.3F, 0.9F, -3.6F, -3.0F, 0.4F, 0.5F, -3.0F, 0.9F, 0.5F, -3.0F, 0.9F, -3.6F, -3.0F, 0.4F);
    this.headModel[0].func_78793_a(0.0F, -0.5F, 0.0F);
    this.headModel[1].addShapeBox(0.5F, -10.0F, -4.0F, 8, 8, 8, 0.0F, 0.5F, -1.6F, 1.3F, -3.1F, -2.3F, 0.9F, -3.1F, -2.3F, 0.9F, 0.5F, -1.6F, 1.3F, 0.5F, -3.0F, 0.9F, -3.6F, -3.0F, 0.4F, -3.6F, -3.0F, 0.4F, 0.5F, -3.0F, 0.9F);
    this.headModel[1].func_78793_a(0.0F, -0.5F, 0.0F);
    this.headModel[2].addShapeBox(-4.8F, -5.5F, -3.5F, 1, 6, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.headModel[2].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[3].addShapeBox(3.8F, -5.5F, -3.5F, 1, 6, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.headModel[3].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[4].addShapeBox(-4.8F, -5.5F, -1.5F, 1, 6, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.headModel[4].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[5].addShapeBox(3.8F, -5.5F, -1.5F, 1, 6, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.headModel[5].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[6].addShapeBox(-0.5F, -10.2F, -5.4F, 1, 2, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.headModel[6].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[7].addShapeBox(-0.5F, -10.1F, -5.4F, 1, 1, 1, 0.0F, 0.5F, -0.3F, -0.2F, 0.5F, -0.3F, -0.2F, 0.5F, -0.3F, -0.2F, 0.5F, -0.3F, -0.2F, 0.5F, -0.3F, -0.2F, 0.5F, -0.3F, -0.2F, 0.5F, -0.3F, -0.2F, 0.5F, -0.3F, -0.2F);
    this.headModel[7].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[8].addShapeBox(-0.5F, -7.7F, -5.4F, 1, 2, 1, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[9].addShapeBox(-3.5F, -7.5F, -5.2F, 1, 2, 1, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[10].addShapeBox(2.5F, -7.5F, -5.2F, 1, 2, 1, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[11].addShapeBox(-3.5F, -7.5F, 4.2F, 1, 2, 1, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F);
    this.headModel[11].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[12].addShapeBox(-0.5F, -7.5F, 4.3F, 1, 2, 1, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F);
    this.headModel[12].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[13].addShapeBox(2.5F, -7.5F, 4.2F, 1, 2, 1, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F);
    this.headModel[13].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[14].addShapeBox(-5.5F, -7.5F, -0.5F, 1, 2, 1, 0.0F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F);
    this.headModel[14].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[15].addShapeBox(-5.5F, -7.5F, -3.2F, 1, 2, 1, 0.0F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F);
    this.headModel[15].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[16].addShapeBox(-5.5F, -7.5F, 2.2F, 1, 2, 1, 0.0F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F);
    this.headModel[16].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[17].addShapeBox(4.5F, -7.5F, -3.2F, 1, 2, 1, 0.0F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F);
    this.headModel[17].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[18].addShapeBox(4.5F, -7.5F, -0.5F, 1, 2, 1, 0.0F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F);
    this.headModel[18].func_78793_a(0.0F, 0.5F, 0.0F);
    this.headModel[19].addShapeBox(4.5F, -7.5F, 2.2F, 1, 2, 1, 0.0F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F);
    this.headModel[19].func_78793_a(0.0F, 0.5F, 0.0F);
  }
}
