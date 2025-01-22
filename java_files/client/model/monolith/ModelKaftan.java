package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelKaftan extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 128;
  
  public ModelKaftan() {
    this.bodyModel = new ModelRendererTurbo[23];
    this.leftArmModel = new ModelRendererTurbo[2];
    this.rightArmModel = new ModelRendererTurbo[2];
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
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 33, 73, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 1, 81, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 57, 33, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 57, 41, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 57, 49, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 7.7F, -2.0F, 8, 1, 4, 0.0F, 0.5F, -0.1F, 0.5F, 0.5F, -1.1F, 0.5F, 0.5F, -1.1F, 0.5F, 0.5F, -0.1F, 0.5F, 0.3F, -0.1F, 0.3F, 0.3F, 1.9F, 0.3F, 0.3F, 1.9F, 0.3F, 0.3F, -0.1F, 0.3F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, -0.2F, -2.0F, 11, 8, 4, 0.0F, 0.7F, 0.2F, 0.5F, -2.3F, 0.2F, 0.5F, -2.3F, 0.2F, 0.5F, 0.7F, 0.2F, 0.5F, 0.5F, 0.0F, 0.5F, -2.5F, 1.0F, 0.5F, -2.5F, 1.0F, 0.5F, 0.5F, 0.0F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 9.5F, -2.0F, 8, 1, 4, 0.0F, 0.3F, 0.9F, 0.3F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F, 0.3F, 0.3F, 0.9F, 0.3F, 0.5F, -1.1F, 0.5F, 0.5F, -0.1F, 0.5F, 0.5F, -0.1F, 0.5F, 0.5F, -1.1F, 0.5F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-1.0F, 0.5F, -2.7F, 2, 1, 1, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 6.5F, -2.0F, 8, 1, 4, 0.0F, 0.6F, -0.9F, 0.6F, 0.6F, -3.5F, 0.6F, 0.6F, -3.5F, 0.6F, 0.6F, -0.9F, 0.6F, 0.6F, 1.1F, 0.6F, 0.6F, 3.5F, 0.6F, 0.6F, 3.5F, 0.6F, 0.6F, 1.1F, 0.6F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(4.0F, 7.5F, 0.0F, 1, 13, 1, 0.0F, 0.3F, -0.5F, 4.0F, -0.1F, -0.3F, 4.0F, -0.1F, 0.2F, -4.0F, 0.3F, 0.0F, -4.0F, -2.7F, -0.3F, -1.5F, 2.5F, -0.5F, -1.5F, 2.5F, -1.0F, 1.0F, -2.7F, -0.7F, 1.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-1.0F, 3.5F, -2.7F, 2, 1, 1, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-1.0F, 6.5F, -2.7F, 2, 1, 1, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-4.0F, 8.2F, -2.0F, 8, 1, 4, 0.0F, 0.8F, 0.4F, 0.8F, 0.8F, 0.4F, 0.8F, 0.8F, 0.4F, 0.8F, 0.8F, 0.4F, 0.8F, 0.8F, 0.4F, 0.8F, 0.8F, 0.4F, 0.8F, 0.8F, 0.4F, 0.8F, 0.8F, 0.4F, 0.8F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-1.0F, 2.0F, -2.7F, 2, 1, 1, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-1.0F, 5.0F, -2.7F, 2, 1, 1, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F, 0.7F, -0.2F, 0.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-4.0F, -2.6F, -2.0F, 8, 1, 4, 0.0F, 0.9F, -11.5F, 0.9F, -0.8F, -1.9F, 0.7F, -0.8F, -1.9F, 0.7F, 0.9F, -11.5F, 0.9F, 0.7F, 13.0F, 0.9F, 1.6F, 1.3F, 0.7F, 1.6F, 1.3F, 0.7F, 0.7F, 13.0F, 0.9F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-6.5F, 9.5F, -3.0F, 2, 4, 6, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.4F, -0.4F, 0.0F, 0.4F, -0.4F, 0.0F, 0.0F, -0.5F, 0.0F, 0.3F, 0.2F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.3F, 0.2F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-4.5F, 9.0F, -3.6F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-4.5F, 11.0F, -3.6F, 1, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.2F, 0.0F, -0.6F, 0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-3.0F, 9.5F, -3.57F, 1, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.2F, 0.0F, -0.6F, 0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-3.0F, 7.5F, -3.57F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-1.5F, 7.5F, -3.55F, 1, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.2F, 0.0F, -0.6F, 0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-1.5F, 5.5F, -3.55F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(0.0F, 6.0F, -3.52F, 1, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.2F, 0.0F, -0.6F, 0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(0.0F, 4.0F, -3.52F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(1.5F, 4.0F, -3.5F, 1, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.2F, 0.0F, -0.6F, 0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(1.5F, 2.0F, -3.5F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F, -0.3F, 0.5F, -0.3F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 65, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F, 0.4F, 0.35F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.35F, 0.4F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, 7.2F, -2.0F, 4, 1, 4, 0.0F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.6F, 0.4F, 0.6F, 0.6F, 0.4F, 0.6F, 0.6F, 0.4F, 0.6F, 0.6F, 0.4F, 0.6F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 65, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.35F, 0.4F, 0.4F, 0.35F, 0.4F, 0.4F, 0.2F, 0.4F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, 7.2F, -2.0F, 4, 1, 4, 0.0F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.6F, 0.4F, 0.6F, 0.6F, 0.4F, 0.6F, 0.6F, 0.4F, 0.6F, 0.6F, 0.4F, 0.6F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 57, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 1.0F, -2.0F, 4, 5, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 4, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 6.8F, -2.0F, 4, 4, 4, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-2.0F, -1.7F, -2.0F, 4, 11, 4, 0.0F, 0.5F, 0.7F, 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 0.7F, 0.5F, -0.3F, 0.5F, 1.4F, 1.6F, 0.0F, 1.0F, 1.6F, 0.0F, 1.0F, -0.3F, 0.5F, 1.4F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 25, 57, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 1.0F, -2.0F, 4, 5, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 4, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, -1.7F, -2.0F, 4, 11, 4, 0.0F, 0.5F, 1.0F, 0.5F, 0.5F, 0.7F, 0.5F, 0.5F, 0.7F, 0.5F, 0.5F, 1.0F, 0.5F, 1.6F, 0.0F, 1.0F, -0.3F, 0.5F, 1.4F, -0.3F, 0.5F, 1.4F, 1.6F, 0.0F, 1.0F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-2.0F, 6.8F, -2.0F, 4, 4, 4, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, -1.7F, -2.0F, 8, 5, 2, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.8F, 0.5F, 0.5F, 0.8F, 0.5F, 0.5F, 0.8F, 0.5F, 0.5F, 0.8F, 0.5F, 0.5F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-4.0F, -1.7F, 0.0F, 8, 5, 2, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.8F, 0.5F, 0.5F, 0.8F, 0.5F, 0.5F, 0.8F, 0.5F, 0.5F, 0.8F, 0.5F, 0.5F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
