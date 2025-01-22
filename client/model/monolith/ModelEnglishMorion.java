package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelEnglishMorion extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelEnglishMorion() {
    this.headModel = new ModelRendererTurbo[17];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 25, 57, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 41, 57, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 2, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-0.5F, -11.8F, -4.5F, 1, 1, 9, 0.0F, -0.2F, -1.0F, -1.5F, -0.2F, -1.0F, -1.5F, -0.2F, -1.2F, -2.5F, -0.2F, -1.2F, -2.5F, -0.2F, 1.5F, 0.5F, -0.2F, 1.5F, 0.5F, -0.2F, 1.5F, 0.1F, -0.2F, 1.5F, 0.1F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-0.5F, -10.0F, -4.5F, 1, 5, 9, 0.0F, -0.2F, -0.7F, 0.5F, -0.2F, -0.7F, 0.5F, -0.2F, -0.7F, 0.1F, -0.2F, -0.7F, 0.1F, -0.2F, -0.5F, 1.0F, -0.2F, -0.5F, 1.0F, -0.2F, 0.5F, 1.0F, -0.2F, 0.5F, 1.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(0.0F, -6.5F, -4.0F, 4, 2, 8, 0.0F, 0.0F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, -0.5F, 0.9F, 0.9F, 0.4F, 0.9F, 0.9F, 0.5F, 0.9F, 0.0F, -0.5F, 0.9F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.0F, -6.5F, -4.0F, 4, 2, 8, 0.0F, 0.9F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.9F, 0.0F, 0.9F, 0.9F, 0.4F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.9F, 0.5F, 0.9F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(5.0F, -4.0F, -5.0F, 1, 1, 5, 0.0F, 0.2F, 0.3F, -0.2F, 0.0F, 0.0F, -0.2F, 1.0F, -0.2F, 0.0F, 0.2F, 0.3F, 0.0F, 0.0F, -0.8F, -0.2F, 0.0F, -0.3F, -0.2F, 1.0F, -0.1F, 0.0F, 0.0F, -0.8F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-6.0F, -4.0F, -5.0F, 1, 1, 5, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, 0.3F, -0.2F, 0.2F, 0.3F, 0.0F, 1.0F, -0.2F, 0.0F, 0.0F, -0.3F, -0.2F, 0.0F, -0.8F, -0.2F, 0.0F, -0.8F, 0.0F, 1.0F, -0.1F, 0.0F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(5.0F, -4.0F, 0.0F, 1, 1, 5, 0.0F, 0.2F, 0.3F, 0.0F, 1.0F, -0.2F, 0.0F, 0.0F, -0.2F, -0.2F, 0.2F, 0.0F, -0.2F, 0.0F, -0.8F, 0.0F, 1.0F, -0.1F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, -0.8F, -0.2F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-6.0F, -4.0F, -9.6F, 6, 1, 5, 0.0F, -3.0F, 0.5F, -1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.8F, -0.2F, 0.0F, 0.0F, -0.2F, -3.0F, -1.0F, -1.0F, 0.0F, -1.5F, 0.0F, 0.0F, -2.0F, -0.2F, 0.0F, -0.3F, -0.2F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(0.0F, -4.0F, -9.6F, 6, 1, 5, 0.0F, 0.0F, 1.0F, 0.0F, -3.0F, 0.5F, -1.0F, 0.0F, 0.0F, -0.2F, 0.0F, 1.8F, -0.2F, 0.0F, -1.5F, 0.0F, -3.0F, -1.0F, -1.0F, 0.0F, -0.3F, -0.2F, 0.0F, -2.0F, -0.2F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(0.0F, -4.0F, 4.6F, 6, 1, 3, 0.0F, 0.0F, 1.0F, -0.2F, 0.0F, -0.2F, -0.2F, -3.0F, -0.3F, -1.0F, 0.0F, -0.5F, -0.5F, 0.0F, -1.0F, -0.2F, 0.0F, 0.0F, -0.2F, -3.0F, -0.1F, -1.0F, 0.0F, 0.0F, -0.5F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-6.0F, -4.0F, 0.0F, 1, 1, 5, 0.0F, 1.0F, -0.2F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 1.0F, -0.1F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, -0.8F, -0.2F, 0.0F, 0.0F, -0.2F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-6.0F, -4.0F, 4.6F, 6, 1, 3, 0.0F, 0.0F, -0.2F, -0.2F, 0.0F, 1.0F, -0.2F, 0.0F, -0.5F, -0.5F, -3.0F, -0.3F, -1.0F, 0.0F, 0.0F, -0.2F, 0.0F, -1.0F, -0.2F, 0.0F, 0.0F, -0.5F, -3.0F, -0.1F, -1.0F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(4.0F, -4.0F, -3.0F, 1, 4, 3, 0.0F, 0.0F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -0.7F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(-4.5F, -0.5F, -3.2F, 9, 1, 1, 0.0F, -0.25F, -0.3F, -0.3F, -0.25F, -0.3F, -0.3F, -0.25F, -0.3F, -0.3F, -0.25F, -0.3F, -0.3F, -0.5F, -0.3F, -0.3F, -0.5F, -0.3F, -0.3F, -0.5F, -0.3F, -0.3F, -0.5F, -0.3F, -0.3F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(-5.0F, -4.0F, -3.0F, 1, 4, 3, 0.0F, -0.1F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.5F, -0.1F, 0.0F, 0.5F, -0.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.5F, -0.7F, -0.5F, -1.5F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
