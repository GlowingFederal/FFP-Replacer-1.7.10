package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelGaulMail extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelGaulMail() {
    this.bodyModel = new ModelRendererTurbo[15];
    this.leftArmModel = new ModelRendererTurbo[1];
    this.rightArmModel = new ModelRendererTurbo[1];
    this.leftLegModel = new ModelRendererTurbo[2];
    this.rightLegModel = new ModelRendererTurbo[2];
    this.skirtRearModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
    initskirtRearModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 73, 17, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 97, 25, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 113, 25, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 89, 33, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 8.5F, -2.0F, 8, 1, 4, 0.0F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 9.8F, -2.0F, 8, 6, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 2.0F, -2.0F, 8, 6, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 10.0F, -2.0F, 8, 3, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.6F, 1.6F, 0.6F, 0.6F, 1.6F, 0.6F, 0.6F, 1.6F, 0.6F, 0.6F, 1.6F, 0.6F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 9.5F, -2.0F, 8, 1, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.4F, -0.7F, 0.4F, 0.4F, -0.7F, 0.4F, 0.4F, -0.7F, 0.4F, 0.4F, -0.7F, 0.4F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 8.3F, -2.0F, 8, 1, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.2F, -0.7F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, -0.7F, 0.2F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.0F, 0.0F, -2.2F, 2, 2, 4, 0.0F, 0.8F, 0.5F, 0.55F, 1.2F, 0.3F, 0.55F, 1.2F, 0.3F, 0.55F, 0.8F, 0.5F, 0.55F, 1.55F, 1.3F, 0.55F, 0.55F, 2.3F, 0.55F, 0.55F, 2.3F, 0.55F, 1.55F, 1.3F, 0.55F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-4.0F, 0.0F, 1.0F, 8, 4, 1, 0.0F, 0.55F, 0.3F, -1.0F, 0.55F, 0.5F, -1.0F, 0.55F, 0.5F, 0.55F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, -1.0F, 0.55F, 0.3F, -1.0F, 0.55F, 0.3F, 0.55F, 0.55F, 0.3F, 0.55F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(2.0F, 0.0F, -2.2F, 2, 2, 4, 0.0F, 1.2F, 0.3F, 0.55F, 0.8F, 0.5F, 0.55F, 0.8F, 0.5F, 0.55F, 1.2F, 0.3F, 0.55F, 0.55F, 2.3F, 0.55F, 1.55F, 1.3F, 0.55F, 1.55F, 1.3F, 0.55F, 0.55F, 2.3F, 0.55F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-4.0F, 1.0F, -2.0F, 8, 6, 4, 0.0F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 1.1F, 0.1F, 0.1F, 1.1F, 0.1F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-4.0F, 1.2F, -4.6F, 8, 1, 4, 0.0F, -2.7F, -0.3F, -1.6F, -2.7F, -0.3F, -1.6F, -2.7F, -0.3F, -1.6F, -2.7F, -0.3F, -1.6F, -2.7F, -0.3F, -1.6F, -2.7F, -0.3F, -1.6F, -2.7F, -0.3F, -1.6F, -2.7F, -0.3F, -1.6F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-5.0F, -1.0F, 2.0F, 10, 1, 1, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 1.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-7.0F, 0.0F, 3.0F, 14, 10, 1, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-4.5F, -1.7F, -3.0F, 5, 3, 1, 0.0F, 0.0F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 1.5F, -0.7F, 3.0F, 0.5F, -0.8F, 3.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, 1.0F, 0.5F, 5.0F, -1.0F, 0.0F, 5.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(0.5F, -1.7F, -3.0F, 4, 3, 1, 0.0F, 0.5F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.5F, -0.8F, 3.0F, 1.5F, -0.7F, 3.0F, 1.0F, 0.5F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 1.0F, 0.5F, 5.0F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 3.1F, 0.1F, 0.1F, 3.1F, 0.1F, 0.1F, 3.1F, 0.1F, 0.1F, 3.1F, 0.1F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 3.1F, 0.1F, 0.1F, 3.1F, 0.1F, 0.1F, 3.1F, 0.1F, 0.1F, 3.1F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.3F, 0.0F, 0.7F, 0.3F, 0.0F, 0.7F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.7F, 0.3F, 0.0F, 0.7F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 2.1F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.3F, 0.0F, 0.7F, 0.3F, 0.0F, 0.7F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.7F, 0.3F, 0.0F, 0.7F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 2.1F, -2.0F, 4, 6, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 57, 41, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-7.0F, -1.5F, 3.0F, 14, 10, 1, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
