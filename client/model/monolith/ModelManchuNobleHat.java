package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelManchuNobleHat extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 128;
  
  public ModelManchuNobleHat() {
    this.headModel = new ModelRendererTurbo[11];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -7.5F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 1.5F, 0.3F, 0.2F, 1.5F, 0.3F, 0.2F, 0.4F, 0.9F, 0.2F, 0.4F, 0.9F, 0.9F, -1.5F, 1.7F, 0.9F, -1.5F, 1.7F, 0.9F, 0.0F, 1.5F, 0.9F, 0.0F, 1.5F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-5.0F, -8.0F, -5.0F, 3, 3, 11, 0.0F, 0.9F, 0.0F, 1.5F, -0.5F, 1.0F, 1.5F, -0.5F, -1.2F, 1.0F, 0.9F, -2.0F, 1.0F, -0.6F, 0.0F, 0.7F, 0.0F, -0.2F, 0.9F, 0.0F, 1.7F, -0.1F, -0.6F, 2.0F, -0.6F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -13.5F, -4.0F, 8, 3, 8, 0.0F, -3.1F, -2.7F, -3.5F, -3.1F, -2.7F, -3.5F, -3.1F, -3.0F, -2.5F, -3.1F, -3.0F, -2.5F, 0.2F, 1.5F, 0.3F, 0.2F, 1.5F, 0.3F, 0.2F, 2.6F, 0.9F, 0.2F, 2.6F, 0.9F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(2.0F, -8.0F, -5.0F, 3, 3, 11, 0.0F, -0.5F, 1.0F, 1.5F, 0.9F, 0.0F, 1.5F, 0.9F, -2.0F, 1.0F, -0.5F, -1.2F, 1.0F, 0.0F, -0.2F, 0.9F, -0.6F, 0.0F, 0.7F, -0.6F, 2.0F, -0.6F, 0.0F, 1.7F, -0.1F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-1.5F, -8.0F, -5.0F, 3, 3, 11, 0.0F, 1.0F, 1.0F, 1.5F, 1.0F, 1.0F, 1.5F, 1.0F, -1.2F, 1.0F, 1.0F, -1.2F, 1.0F, 0.5F, -0.2F, 0.9F, 0.5F, -0.2F, 0.9F, 0.5F, 1.7F, -0.1F, 0.5F, 1.7F, -0.1F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-0.5F, -11.5F, 0.1F, 1, 1, 1, 0.0F, 0.4F, 0.6F, 0.4F, 0.4F, 0.6F, 0.4F, 0.4F, 0.4F, 0.5F, 0.4F, 0.4F, 0.5F, 0.4F, 0.4F, 0.6F, 0.4F, 0.4F, 0.6F, 0.4F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-0.5F, -13.0F, 0.15F, 1, 1, 1, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F, -0.4F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-0.5F, -11.5F, 1.1F, 1, 1, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-0.5F, -9.5F, 6.1F, 1, 1, 9, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 1.0F, -10.3F, 0.0F, 1.0F, -10.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 1.0F, 9.7F, 0.0F, 1.0F, 9.7F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-0.5F, 0.5F, 15.1F, 1, 1, 2, 0.0F, 1.0F, -0.3F, 0.0F, 1.0F, -0.3F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 1.0F, -0.3F, 0.0F, 1.0F, -0.3F, 0.0F, 0.0F, 2.5F, 0.0F, 0.0F, 2.5F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-10.5F, -17.6F, -7.0F, 21, 21, 1, 0.0F, -9.0F, -9.0F, -0.4F, -9.0F, -9.0F, -0.4F, -9.0F, -9.0F, 0.0F, -9.0F, -9.0F, 0.0F, -9.0F, -9.0F, -1.0F, -9.0F, -9.0F, -1.0F, -9.0F, -9.0F, 0.0F, -9.0F, -9.0F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
