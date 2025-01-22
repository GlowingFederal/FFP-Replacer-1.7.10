package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMusketeerHat extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelMusketeerHat() {
    this.headModel = new ModelRendererTurbo[11];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(2.0F, -10.0F, 1.5F, 7, 3, 1, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(9.0F, -10.0F, 1.5F, 6, 3, 1, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 2.0F, 0.0F, -3.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(2.0F, -10.0F, 1.5F, 7, 3, 1, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.5F, -2.0F, 0.0F, 2.5F, 2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(9.0F, -10.0F, 1.5F, 4, 3, 1, 0.0F, 0.0F, 2.5F, -2.0F, 0.0F, -1.0F, -3.0F, 0.0F, -1.0F, 3.0F, 0.0F, 2.5F, 2.0F, 0.0F, 0.0F, -2.0F, -3.0F, 2.0F, -3.0F, -3.0F, 2.0F, 3.0F, 0.0F, 0.0F, 2.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(2.0F, -9.0F, 1.5F, 7, 1, 1, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F, -2.0F, 0.0F, -1.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(9.0F, -9.0F, 1.5F, 4, 1, 1, 0.0F, 0.0F, 2.0F, 2.0F, 0.0F, -1.0F, 3.0F, 0.0F, -1.0F, -3.0F, 0.0F, 2.0F, -2.0F, 0.0F, 0.0F, 2.0F, -3.0F, 2.0F, 3.0F, -3.0F, 2.0F, -3.0F, 0.0F, 0.0F, -2.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-11.0F, -6.0F, -3.0F, 22, 1, 6, 0.0F, -7.0F, 1.0F, 0.0F, -7.0F, 1.0F, 0.0F, -7.0F, 1.0F, 0.0F, -7.0F, 1.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-11.0F, -6.0F, -10.0F, 22, 1, 7, 0.0F, -7.0F, -0.8F, 0.0F, -7.0F, -0.8F, 0.0F, -7.0F, 1.0F, 0.0F, -7.0F, 1.0F, 0.0F, -7.0F, 0.0F, 0.0F, -7.0F, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-11.0F, -6.0F, 3.0F, 22, 1, 7, 0.0F, -7.0F, 1.0F, 0.0F, -7.0F, 1.0F, 0.0F, -7.0F, -1.8F, 0.0F, -7.0F, -1.8F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -7.0F, 1.0F, 0.0F, -7.0F, 1.0F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 2, 9, 0.0F, 0.0F, 0.5F, -0.1F, 0.0F, 0.5F, -0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-4.0F, -12.0F, -4.0F, 8, 4, 9, 0.0F, -1.0F, -0.5F, -2.0F, -1.0F, -0.5F, -2.0F, -1.0F, -1.5F, 0.0F, -1.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
