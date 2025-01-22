package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelIndiaPants extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelIndiaPants() {
    this.bodyModel = new ModelRendererTurbo[4];
    this.leftLegModel = new ModelRendererTurbo[1];
    this.rightLegModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-12.0F, 8.0F, -10.0F, 24, 5, 20, 0.0F, -7.9F, -2.0F, -7.9F, -7.9F, -2.0F, -7.9F, -7.9F, -2.0F, -7.9F, -7.9F, -2.0F, -7.9F, -7.4F, -2.0F, -7.4F, -7.4F, -2.0F, -7.4F, -7.4F, -2.0F, -7.4F, -7.4F, -2.0F, -7.4F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-12.0F, 9.0F, -10.0F, 24, 5, 20, 0.0F, -7.4F, -2.0F, -7.4F, -7.4F, -2.0F, -7.4F, -7.4F, -2.0F, -7.4F, -7.4F, -2.0F, -7.4F, -7.5F, -1.0F, -7.5F, -7.5F, -1.0F, -7.5F, -7.5F, -1.0F, -7.5F, -7.5F, -1.0F, -7.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 9.5F, -2.0F, 8, 1, 4, 0.0F, 0.1F, -0.2F, 0.1F, 0.1F, -0.2F, 0.1F, 0.1F, -0.2F, 0.1F, 0.1F, -0.2F, 0.1F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-5.0F, 9.5F, 0.0F, 1, 8, 1, 0.0F, 0.3F, -0.4F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, -0.4F, 0.3F, 1.3F, 0.2F, -0.2F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 1.5F, -0.2F, 1.3F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-10.0F, -20.0F, -10.0F, 20, 48, 20, 0.0F, -7.4F, -20.0F, -7.4F, -7.4F, -20.0F, -7.4F, -7.4F, -20.0F, -7.4F, -7.4F, -20.0F, -7.4F, -7.0F, -20.0F, -7.0F, -7.0F, -20.0F, -7.0F, -7.0F, -20.0F, -7.0F, -7.0F, -20.0F, -7.0F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-10.0F, -20.0F, -10.0F, 20, 48, 20, 0.0F, -7.4F, -20.0F, -7.4F, -7.4F, -20.0F, -7.4F, -7.4F, -20.0F, -7.4F, -7.4F, -20.0F, -7.4F, -7.0F, -20.0F, -7.0F, -7.0F, -20.0F, -7.0F, -7.0F, -20.0F, -7.0F, -7.0F, -20.0F, -7.0F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
