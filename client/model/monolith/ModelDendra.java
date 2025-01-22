package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelDendra extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelDendra() {
    this.headModel = new ModelRendererTurbo[2];
    this.bodyModel = new ModelRendererTurbo[4];
    this.leftArmModel = new ModelRendererTurbo[4];
    this.rightArmModel = new ModelRendererTurbo[4];
    this.leftLegModel = new ModelRendererTurbo[3];
    this.rightLegModel = new ModelRendererTurbo[3];
    this.skirtFrontModel = new ModelRendererTurbo[1];
    this.skirtRearModel = new ModelRendererTurbo[1];
    initheadModel_1();
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
    initskirtFrontModel_1();
    initskirtRearModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 49, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -2.0F, -4.0F, 8, 2, 8, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, 0.0F, -4.0F, 8, 2, 8, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 6, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 5.0F, -2.0F, 8, 5, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 8.0F, -2.0F, 8, 5, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 11.0F, -2.0F, 8, 5, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 73, 41, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 97, 41, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, 5.0F, -2.0F, 4, 4, 4, 0.0F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-2.5F, -2.0F, -2.0F, 4, 5, 4, 0.0F, -2.0F, 1.5F, 0.8F, 2.0F, 0.0F, 0.8F, 2.0F, 0.0F, 0.8F, -2.0F, 1.5F, 0.8F, 1.0F, -1.5F, 1.2F, -1.7F, 0.5F, 0.8F, -0.7F, 0.5F, 0.8F, 1.0F, -1.5F, 1.2F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(-1.0F, -0.5F, -2.0F, 4, 3, 4, 0.0F, -0.7F, 0.2F, 0.2F, 0.3F, 1.5F, 0.2F, 0.3F, 1.5F, 0.2F, -0.7F, 0.2F, 0.2F, -1.0F, 0.8F, 0.4F, 1.0F, 0.0F, 0.4F, 1.0F, 0.0F, 0.4F, -1.0F, 0.8F, 0.4F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 97, 9, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-1.5F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 2.0F, 0.0F, 0.8F, -2.0F, 1.5F, 0.8F, -2.0F, 1.5F, 0.8F, 2.0F, 0.0F, 0.8F, -1.7F, 0.5F, 0.8F, 1.0F, -1.5F, 1.2F, 1.0F, -1.5F, 1.2F, -0.7F, 0.5F, 0.8F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-3.0F, -0.5F, -2.0F, 4, 3, 4, 0.0F, 0.3F, 1.5F, 0.2F, -0.7F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, 0.3F, 1.5F, 0.2F, 1.0F, 0.0F, 0.4F, -1.0F, 0.8F, 0.4F, -1.0F, 0.8F, 0.4F, 1.0F, 0.0F, 0.4F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-3.0F, 5.0F, -2.0F, 4, 4, 4, 0.0F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 11.1F, -2.0F, 4, 1, 4, 0.0F, 0.1F, -0.5F, 0.8F, 0.1F, -0.5F, 0.8F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.8F, 0.1F, 0.0F, 0.8F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 2, 2, 5, 0.0F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -2.8F, 0.1F, 0.0F, -2.8F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.6F, 0.1F, 0.0F, -0.6F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 7.0F, -2.0F, 2, 4, 5, 0.0F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.6F, 0.1F, 0.0F, -0.6F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.9F, 0.1F, 0.0F, -0.9F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 73, 17, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 113, 17, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 11.1F, -2.0F, 4, 1, 4, 0.0F, 0.1F, -0.5F, 0.8F, 0.1F, -0.5F, 0.8F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.8F, 0.1F, 0.0F, 0.8F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 2, 2, 5, 0.0F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -2.8F, 0.1F, 0.0F, -2.8F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.6F, 0.1F, 0.0F, -0.6F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 7.0F, -2.0F, 2, 4, 5, 0.0F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.6F, 0.1F, 0.0F, -0.6F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.9F, 0.1F, 0.0F, -0.9F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, -1.0F, -2.2F, 8, 5, 2, 0.0F, 0.6F, -0.5F, 0.5F, 0.6F, -0.5F, 0.5F, 0.6F, -0.5F, 0.5F, 0.6F, -0.5F, 0.5F, 0.7F, 0.0F, 0.6F, 0.7F, 0.0F, 0.6F, 0.7F, 0.0F, 0.6F, 0.7F, 0.0F, 0.6F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-4.0F, -1.0F, 0.2F, 8, 5, 2, 0.0F, 0.6F, -0.5F, 0.5F, 0.6F, -0.5F, 0.5F, 0.6F, -0.5F, 0.5F, 0.6F, -0.5F, 0.5F, 0.7F, 0.0F, 0.6F, 0.7F, 0.0F, 0.6F, 0.7F, 0.0F, 0.6F, 0.7F, 0.0F, 0.6F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
