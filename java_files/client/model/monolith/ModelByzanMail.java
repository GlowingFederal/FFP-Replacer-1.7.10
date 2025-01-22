package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelByzanMail extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelByzanMail() {
    this.bodyModel = new ModelRendererTurbo[8];
    this.leftArmModel = new ModelRendererTurbo[3];
    this.rightArmModel = new ModelRendererTurbo[3];
    this.leftLegModel = new ModelRendererTurbo[5];
    this.rightLegModel = new ModelRendererTurbo[5];
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
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 81, 41, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 8.6F, -2.0F, 8, 1, 4, 0.0F, 0.6F, 0.1F, 0.8F, 0.6F, 0.1F, 0.8F, 0.6F, 0.1F, 0.8F, 0.6F, 0.1F, 0.8F, 0.6F, 0.1F, 0.8F, 0.6F, 0.1F, 0.8F, 0.6F, 0.1F, 0.8F, 0.6F, 0.1F, 0.8F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 10.3F, -2.0F, 8, 5, 4, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.8F, 0.5F, 0.5F, 0.8F, 0.5F, 0.5F, 0.8F, 0.5F, 0.5F, 0.8F, 0.5F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 7.7F, -2.0F, 16, 2, 4, 0.0F, 0.7F, -0.1F, 0.7F, -7.3F, -0.1F, 0.7F, -7.3F, -0.1F, 0.7F, 0.7F, -0.1F, 0.7F, 0.5F, -1.1F, 0.5F, -7.3F, -1.1F, 0.5F, -7.3F, -1.1F, 0.5F, 0.5F, -1.1F, 0.5F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, -0.2F, -2.0F, 16, 16, 4, 0.0F, 0.7F, 0.1F, 0.7F, -7.2F, 0.1F, 0.7F, -7.2F, 0.1F, 0.7F, 0.7F, 0.1F, 0.7F, 0.7F, -8.0F, 0.7F, -7.2F, -8.0F, 0.7F, -7.2F, -8.0F, 0.7F, 0.7F, -8.0F, 0.7F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 8.5F, -2.0F, 16, 2, 4, 0.0F, 0.5F, -1.1F, 0.5F, -7.3F, -1.1F, 0.5F, -7.3F, -1.1F, 0.5F, 0.5F, -1.1F, 0.5F, 0.7F, -0.1F, 0.7F, -7.3F, -0.1F, 0.7F, -7.3F, -0.1F, 0.7F, 0.7F, -0.1F, 0.7F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 3.0F, -2.0F, 8, 1, 4, 0.0F, 0.8F, 0.1F, 0.8F, 0.8F, 0.1F, 0.8F, 0.8F, 0.1F, 0.8F, 0.8F, 0.1F, 0.8F, 0.8F, 0.1F, 0.8F, 0.8F, 0.1F, 0.8F, 0.8F, 0.1F, 0.8F, 0.8F, 0.1F, 0.8F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-6.5F, 1.0F, -2.0F, 8, 1, 4, 0.0F, -2.5F, 1.4F, 0.8F, -4.5F, 1.5F, 0.8F, -4.5F, 1.5F, 0.8F, -2.5F, 1.4F, 0.8F, -3.5F, 1.7F, 0.8F, -3.5F, 1.7F, 0.8F, -3.5F, 1.7F, 0.8F, -3.5F, 1.7F, 0.8F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-1.5F, 1.0F, -2.0F, 8, 1, 4, 0.0F, -4.5F, 1.5F, 0.8F, -2.5F, 1.4F, 0.8F, -2.5F, 1.4F, 0.8F, -4.5F, 1.5F, 0.8F, -3.5F, 1.7F, 0.8F, -3.5F, 1.7F, 0.8F, -3.5F, 1.7F, 0.8F, -3.5F, 1.7F, 0.8F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 105, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 89, 57, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 11, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 1.0F, 0.4F, 0.4F, 1.0F, 0.4F, 0.4F, 1.0F, 0.4F, 0.4F, 1.0F, 0.4F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-5.0F, -2.0F, -2.0F, 8, 6, 8, 0.0F, -3.5F, 0.3F, 0.5F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F, -3.5F, -3.5F, 0.3F, -3.5F, -3.5F, -2.0F, 0.5F, 0.5F, -2.0F, 0.5F, 0.5F, -2.0F, -3.5F, -3.5F, -2.0F, -3.5F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 57, 49, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 11, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 1.0F, 0.4F, 0.4F, 1.0F, 0.4F, 0.4F, 1.0F, 0.4F, 0.4F, 1.0F, 0.4F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-7.0F, -2.0F, -2.0F, 8, 6, 8, 0.0F, -3.5F, 0.3F, 0.5F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F, -3.5F, -3.5F, 0.3F, -3.5F, -3.5F, -2.0F, 0.5F, 0.5F, -2.0F, 0.5F, 0.5F, -2.0F, -3.5F, -3.5F, -2.0F, -3.5F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 25, 89, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 1.0F, -2.0F, 4, 6, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 7.0F, -2.0F, 4, 1, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 7.4F, -2.0F, 4, 4, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-2.0F, -1.7F, -2.0F, 4, 8, 4, 0.0F, 0.5F, -0.1F, 0.4F, 0.5F, -0.1F, 0.5F, 0.5F, -0.1F, 0.5F, 0.5F, -0.1F, 0.4F, -0.3F, -0.3F, 0.8F, 1.2F, -0.5F, 0.7F, 1.2F, -0.5F, 0.7F, -0.3F, -0.3F, 0.8F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 17, 41, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 89, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 7.4F, -2.0F, 4, 4, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 1.0F, -2.0F, 4, 6, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 7.0F, -2.0F, 4, 1, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-2.0F, -1.7F, -2.0F, 4, 8, 4, 0.0F, 0.5F, -0.1F, 0.5F, 0.5F, -0.1F, 0.5F, 0.5F, -0.1F, 0.5F, 0.5F, -0.1F, 0.5F, 1.2F, -0.5F, 0.7F, -0.3F, -0.3F, 0.9F, -0.3F, -0.3F, 0.9F, 1.2F, -0.5F, 0.7F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, -1.5F, -3.0F, 16, 16, 4, 0.0F, 0.7F, 0.1F, -0.3F, -7.2F, 0.1F, -0.3F, -7.2F, 0.1F, -0.3F, 0.7F, 0.1F, -0.3F, 1.2F, -10.0F, 0.0F, -6.5F, -10.0F, 0.0F, -6.5F, -10.0F, 0.0F, 1.2F, -10.0F, 0.0F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-4.0F, -1.5F, -1.0F, 16, 16, 4, 0.0F, 0.7F, 0.1F, -0.3F, -7.2F, 0.1F, -0.3F, -7.2F, 0.1F, -0.3F, 0.7F, 0.1F, -0.3F, 1.2F, -10.0F, 0.0F, -6.5F, -10.0F, 0.0F, -6.5F, -10.0F, 0.0F, 1.2F, -10.0F, 0.0F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
