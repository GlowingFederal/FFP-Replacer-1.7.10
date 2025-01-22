package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelExoskeletonBoots extends ModelCustomArmour {
  public ModelExoskeletonBoots() {
    int textureX = 512;
    int textureY = 512;
    this.rightLegModel = new ModelRendererTurbo[3];
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 313, 113, textureX, textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 57, 121, textureX, textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 217, 121, textureX, textureY);
    float x = 8.5F;
    float y = 24.0F;
    float z = 1.0F;
    this.rightLegModel[0].func_78790_a(-17.0F + x, 16.0F + y, -9.0F, 17, 8, 18, 0.0F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].func_78790_a(-17.0F + x, 19.0F + y, -10.0F, 16, 5, 6, 0.0F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, -5.0F);
    this.rightLegModel[2].func_78790_a(-17.0F + x, 11.0F + y, -10.0F, 16, 5, 19, 0.0F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel = new ModelRendererTurbo[3];
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 121, textureX, textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 121, textureX, textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 409, 121, textureX, textureY);
    this.leftLegModel[0].func_78790_a(0.0F - x, 16.0F + y, -9.0F, 17, 8, 18, 0.0F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].func_78790_a(1.0F - x, 19.0F + y, -10.0F, 16, 5, 6, 0.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, -5.0F);
    this.leftLegModel[2].func_78790_a(1.0F - x, 11.0F + y, -10.0F, 16, 5, 19, 0.0F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
