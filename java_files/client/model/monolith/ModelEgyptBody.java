package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelEgyptBody extends ModelCustomArmour {
  int textureX = 1024;
  
  int textureY = 1024;
  
  public ModelEgyptBody() {
    this.bodyModel = new ModelRendererTurbo[6];
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 329, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 361, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 393, 1, this.textureX, this.textureY);
    this.bodyModel[0].func_78790_a(-3.0F, 0.0F, -2.0F, 1, 4, 4, 0.0F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 10.0F, -2.0F, 8, 2, 4, 0.0F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].func_78790_a(2.0F, 0.0F, -2.0F, 1, 4, 4, 0.0F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 8.0F, -2.0F, 8, 2, 4, 0.0F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 6.0F, -2.0F, 8, 2, 4, 0.0F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F, 0.075F, 0.0F, 0.075F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 4.0F, -2.0F, 8, 2, 4, 0.0F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel = new ModelRendererTurbo[1];
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 153, 1, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-1.8F, 0.0F, -2.0F, 4, 5, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel = new ModelRendererTurbo[1];
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.2F, 0.0F, -2.0F, 4, 5, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel = new ModelRendererTurbo[3];
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.skirtFrontModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.skirtFrontModel[2] = new ModelRendererTurbo((ModelBase)this, 177, 1, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, 0.0F, -2.0F, 4, 5, 1, 0.0F, 0.125F, 0.0F, 0.125F, 0.0F, 0.0F, 0.125F, 0.0F, 0.0F, 0.0F, 0.125F, 0.0F, 0.0F, 0.125F, 0.0F, 0.125F, 0.0F, -1.0F, 0.125F, 0.0F, -1.0F, 0.0F, 0.125F, 0.0F, 0.0F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[1].addShapeBox(0.0F, 0.0F, -2.0F, 4, 5, 1, 0.0F, 0.0F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.skirtFrontModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[2].addShapeBox(-2.0F, 0.0F, -2.5F, 4, 5, 1, 0.0F, 0.75F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F);
    this.skirtFrontModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel = new ModelRendererTurbo[2];
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.skirtRearModel[1] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(0.0F, 0.0F, 1.0F, 4, 5, 1, 0.0F, 0.0F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel[1].addShapeBox(-4.0F, 0.0F, 1.0F, 4, 5, 1, 0.0F, 0.125F, 0.0F, 0.125F, 0.0F, 0.0F, 0.125F, 0.0F, 0.0F, 0.0F, 0.125F, 0.0F, 0.0F, 0.125F, 0.0F, 0.125F, 0.0F, -1.0F, 0.125F, 0.0F, -1.0F, 0.0F, 0.125F, 0.0F, 0.0F);
    this.skirtRearModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
