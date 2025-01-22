package com.flansmod.client.model.NewArmor;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelHamasBalaclava extends ModelCustomArmour {
  int textureX = 256;
  
  int textureY = 128;
  
  public ModelHamasBalaclava() {
    this.headModel = new ModelRendererTurbo[15];
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 193, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 233, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 169, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 225, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 97, 9, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 137, 17, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 177, 9, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 169, 17, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 186, 15, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -2.0F, -4.0F, 8, 2, 8, 0.0F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, 0.1F, 0.01F, 0.01F, 0.1F, 0.01F, 0.01F, 0.1F, 0.01F, 0.01F, 0.1F, 0.01F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -3.0F, -4.0F, 3, 1, 1, 0.0F, -1.0F, -0.2F, 0.01F, 0.1F, 1.9428903E-16F, 0.01F, 0.1F, 1.9428903E-16F, 0.01F, -1.0F, -0.2F, 0.01F, -1.0F, 0.0F, 0.01F, 0.1F, 0.0F, 0.01F, 0.1F, 0.0F, 0.01F, -1.0F, 0.0F, 0.01F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-2.0F, -3.0F, -4.0F, 3, 1, 1, 0.0F, -1.1F, -2.7755576E-17F, 0.01F, 0.1F, 1.9428903E-16F, 0.01F, 0.1F, 1.9428903E-16F, 0.01F, -1.1F, -2.7755576E-17F, 0.01F, -1.1F, 0.0F, 0.01F, 0.1F, 0.0F, 0.01F, 0.1F, 0.0F, 0.01F, -1.1F, 0.0F, 0.01F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -5.0F, -4.0F, 1, 3, 8, 0.0F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, -8.326673E-17F, 0.01F, 0.01F, 8.326673E-17F, 0.01F, 0.01F, 8.326673E-17F, 0.01F, 0.01F, -8.326673E-17F, 0.01F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -5.0F, -4.0F, 3, 1, 1, 0.0F, -1.0F, 0.0F, 0.01F, 0.1F, 0.0F, 0.01F, 0.1F, 0.0F, 0.01F, -1.0F, 0.0F, 0.01F, -1.0F, -0.1F, 0.01F, 0.1F, -0.2F, 0.01F, 0.1F, -0.2F, 0.01F, -1.0F, -0.1F, 0.01F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-2.0F, -5.0F, -4.0F, 3, 1, 1, 0.0F, -1.1F, 0.0F, 0.01F, 0.1F, 0.0F, 0.01F, 0.1F, 0.0F, 0.01F, -1.1F, 0.0F, 0.01F, -1.1F, -0.2F, 0.01F, 0.1F, -0.2F, 0.01F, 0.1F, -0.2F, 0.01F, -1.1F, -0.2F, 0.01F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(1.0F, -3.0F, -4.0F, 3, 1, 1, 0.0F, -0.1F, 1.9428903E-16F, 0.01F, -1.0F, -0.2F, 0.01F, -1.0F, -0.2F, 0.01F, -0.1F, 1.9428903E-16F, 0.01F, -0.1F, 0.0F, 0.01F, -1.0F, 0.0F, 0.01F, -1.0F, 0.0F, 0.01F, -0.1F, 0.0F, 0.01F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(1.0F, -5.0F, -4.0F, 3, 1, 1, 0.0F, -0.1F, 0.0F, 0.01F, -1.0F, 0.0F, 0.01F, -1.1F, 0.0F, 0.01F, -0.1F, 0.0F, 0.01F, -0.1F, -0.2F, 0.01F, -1.0F, -0.1F, 0.01F, -1.0F, -0.1F, 0.01F, -0.1F, -0.2F, 0.01F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(3.0F, -5.0F, -4.0F, 1, 3, 8, 0.0F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, -8.326673E-17F, 0.01F, 0.01F, 8.326673E-17F, 0.01F, 0.01F, 8.326673E-17F, 0.01F, 0.01F, -8.326673E-17F, 0.01F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F, 0.01F, 0.0F, 0.01F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-3.0F, -5.0F, 3.0F, 6, 3, 1, 0.0F, 0.0F, 0.0F, 0.01F, 0.0F, 0.0F, 0.01F, 0.0F, 0.0F, 0.01F, 0.0F, 0.0F, 0.01F, 0.0F, -8.326673E-17F, 0.01F, 0.0F, 8.326673E-17F, 0.01F, 0.0F, 8.326673E-17F, 0.01F, 0.0F, -8.326673E-17F, 0.01F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-4.0F, -7.5F, -4.0F, 8, 2, 8, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -2.0F, 0.1F, 0.1F, -2.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 1.0F, 0.1F, 0.1F, 1.0F, 0.1F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-0.2F, -5.5F, 4.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F, -1.0F, -1.5F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 2.0F, -1.5F, -1.5F, 2.0F, -1.5F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-0.8F, -5.5F, 4.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -1.0F, -1.0F, 1.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 2.0F, -1.5F, 1.0F, 2.0F, -1.5F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(-17.0F, -15.5F, -4.1F, 34, 18, 1, 0.0F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F, -13.5F, -8.1F, 0.1F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
