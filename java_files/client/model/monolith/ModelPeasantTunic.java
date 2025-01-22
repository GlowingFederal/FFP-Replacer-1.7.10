package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPeasantTunic extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelPeasantTunic() {
    this.bodyModel = new ModelRendererTurbo[4];
    this.leftArmModel = new ModelRendererTurbo[1];
    this.rightArmModel = new ModelRendererTurbo[1];
    this.leftLegModel = new ModelRendererTurbo[2];
    this.rightLegModel = new ModelRendererTurbo[2];
    this.skirtFrontModel = new ModelRendererTurbo[1];
    this.skirtRearModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
    initskirtFrontModel_1();
    initskirtRearModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 8.5F, -2.0F, 8, 1, 4, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 8, 4, 0.0F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 8.0F, -2.0F, 8, 1, 4, 0.0F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 9.3F, -2.0F, 8, 1, 4, 0.0F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F, 0.3F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 10.1F, -4.0F, 4, 2, 1, 0.0F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.3F, 0.5F, 0.1F, -0.3F, 0.5F, 0.1F, 0.0F, -0.7F, 0.1F, 0.0F, -0.7F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.1F, -0.3F, 0.5F, 0.1F, -0.3F, 0.5F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 1.0F, 0.1F, 0.0F, 1.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.1F, -0.3F, 0.5F, 0.1F, -0.3F, 0.5F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 1.0F, 0.1F, 0.0F, 1.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 10.1F, -4.0F, 4, 2, 1, 0.0F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.3F, 0.5F, 0.1F, -0.3F, 0.5F, 0.1F, 0.0F, -0.7F, 0.1F, 0.0F, -0.7F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, -1.7F, -2.0F, 8, 6, 3, 0.0F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-4.0F, -1.7F, -1.0F, 8, 6, 3, 0.0F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
