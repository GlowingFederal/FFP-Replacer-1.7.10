package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelNiqab extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 512;
  
  public ModelNiqab() {
    this.headModel = new ModelRendererTurbo[25];
    this.bodyModel = new ModelRendererTurbo[23];
    this.leftArmModel = new ModelRendererTurbo[5];
    this.rightArmModel = new ModelRendererTurbo[5];
    this.leftLegModel = new ModelRendererTurbo[10];
    this.rightLegModel = new ModelRendererTurbo[10];
    this.skirtFrontModel = new ModelRendererTurbo[3];
    this.skirtRearModel = new ModelRendererTurbo[3];
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
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 121, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 129, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 137, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 33, 81, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 33, 113, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 145, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 25, 145, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 25, 137, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 41, 145, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 25, 153, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 57, 41, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 1, 161, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 17, 161, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 33, 161, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 169, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 17, 169, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 33, 169, this.textureX, this.textureY);
    this.headModel[21] = new ModelRendererTurbo((ModelBase)this, 49, 169, this.textureX, this.textureY);
    this.headModel[22] = new ModelRendererTurbo((ModelBase)this, 1, 177, this.textureX, this.textureY);
    this.headModel[23] = new ModelRendererTurbo((ModelBase)this, 17, 177, this.textureX, this.textureY);
    this.headModel[24] = new ModelRendererTurbo((ModelBase)this, 25, 177, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.5F, -4.0F, 8, 8, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.5F, -8.5F, -4.0F, 1, 8, 8, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -4.5F, -4.6F, 1, 2, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.3F, -0.4F, 0.2F, 0.3F, -0.4F, 0.2F, 0.3F, -0.4F, 0.0F, 0.3F, -0.4F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(3.0F, -4.5F, -4.6F, 1, 2, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.2F, 0.3F, -0.4F, 0.0F, 0.3F, -0.4F, 0.0F, 0.3F, -0.4F, 0.2F, 0.3F, -0.4F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -2.7F, -4.6F, 4, 5, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.0F, 2.3F, -4.6F, 8, 3, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-4.5F, -1.0F, -4.0F, 1, 2, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-4.5F, -1.0F, 1.0F, 1, 2, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.0F, -8.5F, 3.5F, 8, 11, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-4.0F, 2.3F, 3.5F, 8, 3, 1, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F, -2.0F, 0.0F, -0.4F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-4.5F, 1.0F, -4.0F, 1, 1, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(3.5F, -8.5F, -4.0F, 1, 8, 8, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(3.5F, -1.0F, 1.0F, 1, 2, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(3.5F, -1.0F, -1.0F, 1, 2, 2, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(3.5F, -1.0F, -4.0F, 1, 2, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(3.5F, 1.0F, -4.0F, 1, 1, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(-4.5F, 1.0F, 0.9F, 1, 1, 3, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(-4.5F, 2.3F, 0.9F, 1, 3, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -1.4F, -1.0F, 0.0F, 0.6F, -1.0F, 0.0F, 1.6F, 0.0F, 0.0F, -2.4F, 0.0F, 0.0F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(3.5F, 1.0F, 0.9F, 1, 1, 3, 0.0F, -0.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F, -0.4F, 0.3F, 0.0F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[20].addShapeBox(3.5F, 2.3F, 0.9F, 1, 3, 3, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.6F, -1.0F, 0.0F, -1.4F, -1.0F, 0.0F, -2.4F, 0.0F, 0.0F, 1.6F, 0.0F, 0.0F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[21].addShapeBox(0.0F, -2.7F, -4.6F, 4, 5, 1, 0.0F, 0.0F, -0.2F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F);
    this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[22].addShapeBox(-4.0F, -8.7F, -4.6F, 4, 5, 1, 0.0F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.8F, -0.4F, 0.0F, -0.8F, -0.4F, 0.0F, -0.4F, -0.4F);
    this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[23].addShapeBox(0.0F, -8.7F, -4.6F, 4, 5, 1, 0.0F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.8F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.8F, -0.4F);
    this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[24].addShapeBox(-4.0F, -9.0F, -4.0F, 8, 1, 8, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 17, 49, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 33, 49, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 17, 57, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 17, 121, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 209, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 49, 193, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 201, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 1, 257, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 1, 249, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 17, 257, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 49, 257, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.5F, 7.5F, -3.4F, 9, 3, 5, 0.0F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, 0.2F, -0.5F, -0.2F, 0.2F, -0.5F, -0.2F, -0.2F, 0.0F, 1.6F, -0.2F, 0.0F, 1.6F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 9.5F, -2.5F, 8, 3, 4, 0.0F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -2.8F, 0.0F, -0.7F, -2.8F, 0.0F, -0.7F, 0.1F, -2.0F, 1.0F, 0.1F, -2.0F, 1.0F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.5F, 8.5F, -3.0F, 9, 1, 5, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-3.5F, 2.5F, -3.0F, 7, 4, 4, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-3.0F, 6.0F, -3.0F, 6, 2, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.1F, 0.0F, 0.5F, 0.1F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.1F, 1.0F, 0.0F, 0.1F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-3.5F, 0.5F, -2.5F, 7, 2, 4, 0.0F, -0.5F, 0.5F, -1.0F, -0.5F, 0.5F, -1.0F, -0.5F, 0.5F, 0.3F, -0.5F, 0.5F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-3.5F, 1.0F, -2.5F, 3, 2, 1, 0.0F, -0.5F, -0.8F, 0.3F, 0.0F, -0.8F, 0.3F, 0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-3.5F, 3.01F, -2.5F, 3, 1, 1, 0.0F, -0.5F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, -0.5F, -0.4F, 0.7F, 0.0F, -0.4F, 0.7F, 0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(0.5F, 3.0F, -2.5F, 3, 1, 1, 0.0F, 0.0F, 0.0F, 1.0F, -0.5F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F, 0.0F, -0.4F, 0.7F, -0.5F, -0.4F, 0.7F, -0.5F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(0.5F, 1.01F, -2.5F, 3, 2, 1, 0.0F, 0.0F, -0.8F, 0.3F, -0.5F, -0.8F, 0.3F, -0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 1.0F, -0.5F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-4.5F, 0.1F, -1.5F, 4, 5, 3, 0.0F, 0.0F, -0.2F, 0.0F, -1.5F, 0.3F, 0.0F, -2.5F, 0.3F, 0.5F, 0.0F, -0.2F, 0.2F, -1.3F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, -2.0F, 0.0F, -1.3F, 0.0F, -1.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-4.0F, 0.1F, -1.0F, 4, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.2F, 0.7F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.7F, 0.7F, 0.0F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(0.5F, 0.1F, -1.5F, 4, 5, 3, 0.0F, -1.5F, 0.3F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.2F, -2.5F, 0.3F, 0.5F, 0.0F, -1.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, -1.0F, -1.0F, -2.0F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(0.0F, 0.1F, -1.0F, 4, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.5F, 0.0F, 1.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -1.0F, -1.0F, 0.7F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-1.5F, -2.5F, -1.2F, 3, 3, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-3.5F, 4.5F, -3.0F, 7, 4, 4, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.2F, -1.0F, 0.2F, -0.2F, -1.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-4.5F, 10.5F, -1.4F, 9, 3, 3, 0.0F, 0.2F, 0.5F, -0.2F, 0.2F, 0.5F, -0.2F, -0.2F, 0.0F, 1.6F, -0.2F, 0.0F, 1.6F, 0.4F, -1.0F, -1.2F, 0.4F, -1.0F, -1.2F, 0.0F, -1.8F, 2.2F, 0.0F, -1.8F, 2.2F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-4.5F, -0.5F, -1.5F, 4, 3, 3, 0.0F, 0.0F, -0.2F, 0.0F, -1.5F, 0.3F, 0.0F, -1.0F, 0.3F, 0.5F, 0.0F, -0.2F, 0.4F, -0.3F, 0.5F, 2.0F, 0.0F, 0.5F, 2.5F, 0.0F, 0.0F, 1.0F, -0.3F, 0.0F, 1.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(0.5F, -0.5F, -1.5F, 4, 3, 3, 0.0F, -1.5F, 0.3F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.4F, -1.0F, 0.3F, 0.5F, 0.0F, 0.5F, 2.5F, -0.3F, 0.5F, 2.0F, -0.3F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(-4.5F, 3.5F, -1.5F, 4, 3, 3, 0.0F, -0.3F, 0.5F, 2.0F, 0.0F, 0.5F, 2.5F, 0.0F, 1.0F, 1.0F, -0.3F, 1.0F, 1.0F, 0.0F, -1.2F, 1.5F, 0.0F, 0.3F, 2.0F, 0.0F, 0.3F, 1.4F, 0.0F, -1.2F, 1.3F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(-1.0F, 3.5F, -1.5F, 2, 3, 3, 0.0F, 0.0F, 0.5F, 2.6F, 0.0F, 0.5F, 2.6F, 0.0F, 1.0F, 1.2F, 0.0F, 1.0F, 1.2F, 1.0F, 0.3F, 2.0F, 1.0F, 0.3F, 2.0F, 0.0F, 0.5F, 1.5F, 0.0F, 0.5F, 1.5F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(-1.0F, -0.5F, -1.5F, 2, 3, 3, 0.0F, 1.0F, 0.3F, 0.0F, 1.0F, 0.3F, 0.0F, 1.0F, 0.5F, 0.7F, 1.0F, 0.5F, 0.7F, 0.0F, 0.5F, 2.6F, 0.0F, 0.5F, 2.6F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.2F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(0.5F, 3.5F, -1.5F, 4, 3, 3, 0.0F, 0.0F, 0.5F, 2.5F, -0.3F, 0.5F, 2.0F, -0.3F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.3F, 2.0F, 0.0F, -1.2F, 1.5F, 0.0F, -1.2F, 1.3F, 0.0F, 0.3F, 1.4F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 57, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 65, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 265, this.textureX, this.textureY);
    this.leftArmModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 265, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.5F, -2.0F, -1.5F, 3, 3, 3, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, -1.0F, -0.6F, -0.2F, -1.0F, -0.6F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.3F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.4F, -1.0F, 0.0F, -0.3F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-0.55F, 4.0F, -1.0F, 2, 6, 2, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.2F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-0.8F, 0.0F, -1.0F, 2, 4, 2, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(-2.0F, -1.5F, -1.5F, 3, 4, 3, 0.0F, -1.5F, 0.3F, 0.0F, 0.5F, -0.2F, -0.5F, 0.5F, -0.2F, -0.2F, -1.0F, 0.3F, 0.5F, 0.0F, 1.5F, 1.5F, 0.7F, 0.5F, 0.5F, 0.7F, 0.0F, 0.5F, 0.0F, 1.0F, 1.0F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[4].addShapeBox(-0.55F, 4.0F, -1.0F, 2, 5, 2, 0.0F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.5F, 0.0F, 1.2F, 0.5F, 0.0F, 1.2F, 0.5F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F);
    this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 65, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 49, 65, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 9, 73, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 257, this.textureX, this.textureY);
    this.rightArmModel[4] = new ModelRendererTurbo((ModelBase)this, 17, 265, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-1.5F, -2.0F, -1.5F, 3, 3, 3, 0.0F, -0.2F, -1.0F, -0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, -1.0F, -0.6F, -0.2F, 0.0F, -0.4F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -0.2F, 0.0F, -0.4F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-1.2F, 0.0F, -1.0F, 2, 4, 2, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-1.55F, 4.0F, -1.0F, 2, 6, 2, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.2F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-1.0F, -1.5F, -1.5F, 3, 4, 3, 0.0F, 0.5F, -0.2F, -0.5F, -1.5F, 0.3F, 0.0F, -1.0F, 0.3F, 0.5F, 0.5F, -0.2F, -0.2F, 0.7F, 0.5F, 0.5F, 0.0F, 1.5F, 1.5F, 0.0F, 1.0F, 1.0F, 0.7F, 0.0F, 0.5F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].addShapeBox(-1.55F, 4.0F, -1.0F, 2, 5, 2, 0.0F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.1F, 0.1F, 0.2F, 0.5F, 0.0F, 1.2F, 0.5F, 0.0F, 1.2F, 0.5F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F);
    this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 73, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 73, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 81, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 89, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 81, this.textureX, this.textureY);
    this.leftLegModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 89, this.textureX, this.textureY);
    this.leftLegModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 89, this.textureX, this.textureY);
    this.leftLegModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 97, this.textureX, this.textureY);
    this.leftLegModel[8] = new ModelRendererTurbo((ModelBase)this, 49, 217, this.textureX, this.textureY);
    this.leftLegModel[9] = new ModelRendererTurbo((ModelBase)this, 9, 233, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-1.0F, 0.4F, 1.0F, 4, 1, 2, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-1.7F, 0.0F, -2.0F, 4, 6, 4, 0.0F, -0.4F, 0.0F, 0.2F, 0.2F, 2.5F, 0.5F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, -0.5F, -0.8F, 0.0F, -0.5F, -0.8F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-1.7F, 6.0F, -2.0F, 3, 6, 4, 0.0F, -0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, -0.8F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-1.0F, -2.6F, 1.0F, 4, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, -0.8F, -0.5F, 0.0F, -0.8F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-3.0F, 0.4F, 1.0F, 2, 1, 2, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, -0.5F, 0.5F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, -0.5F, -1.0F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[5].addShapeBox(-3.0F, -2.6F, 1.0F, 2, 2, 2, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.8F, 0.0F, -1.0F, -0.8F, -0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, -0.5F, 0.5F, 0.0F);
    this.leftLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[6].addShapeBox(-1.0F, 0.4F, -2.0F, 4, 1, 3, 0.0F, 0.0F, 0.5F, 0.0F, -0.8F, 0.5F, -0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.leftLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[7].addShapeBox(-1.0F, -2.6F, -2.0F, 4, 2, 3, 0.0F, 0.0F, -0.8F, 0.0F, -0.5F, 0.1F, 0.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.5F, 0.0F, -0.8F, 0.5F, -0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.leftLegModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[8].addShapeBox(3.7F, -0.5F, -0.2F, 1, 11, 5, 0.0F, 1.0F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F, -2.5F, 0.0F, -2.0F, 2.0F, 0.0F, -2.0F, -1.2F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F, -2.2F, 0.0F, 0.0F, 1.8F, 0.0F, 0.0F);
    this.leftLegModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[9].addShapeBox(3.7F, -0.5F, -3.2F, 1, 11, 5, 0.0F, 1.2F, 2.0F, -1.5F, -2.0F, 2.0F, -1.5F, -1.4F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.8F, -0.5F, 0.0F, -1.2F, -0.5F, 0.0F, 0.8F, 0.0F, -1.0F, -1.2F, 0.0F, -1.0F);
    this.leftLegModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 97, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 97, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 97, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 105, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 17, 105, this.textureX, this.textureY);
    this.rightLegModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 105, this.textureX, this.textureY);
    this.rightLegModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 113, this.textureX, this.textureY);
    this.rightLegModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 121, this.textureX, this.textureY);
    this.rightLegModel[8] = new ModelRendererTurbo((ModelBase)this, 25, 233, this.textureX, this.textureY);
    this.rightLegModel[9] = new ModelRendererTurbo((ModelBase)this, 41, 233, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(1.0F, -2.6F, 1.0F, 2, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, -0.8F, -0.5F, 0.0F, -0.8F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-3.0F, -2.6F, 1.0F, 4, 2, 2, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.8F, 0.0F, -1.0F, -0.8F, -0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, -0.5F, 0.5F, 0.0F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(1.0F, 0.4F, 1.0F, 2, 1, 2, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, -0.5F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-3.0F, 0.4F, 1.0F, 4, 1, 2, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, -0.5F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-2.2F, 0.0F, -2.0F, 4, 6, 4, 0.0F, 0.2F, 2.5F, 0.5F, -0.4F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.8F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[5].addShapeBox(-1.2F, 6.0F, -2.0F, 3, 6, 4, 0.0F, 0.0F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.8F, -0.2F, 0.0F, -0.8F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[6].addShapeBox(-3.0F, 0.4F, -2.0F, 4, 1, 3, 0.0F, -0.8F, 0.5F, -0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F);
    this.rightLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[7].addShapeBox(-3.0F, -2.6F, -2.0F, 4, 2, 3, 0.0F, -0.5F, 0.1F, 0.5F, 0.0F, -0.8F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.8F, 0.5F, -0.5F, -1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.rightLegModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[8].addShapeBox(-4.7F, -0.5F, -3.2F, 1, 11, 5, 0.0F, -2.0F, 2.0F, -1.5F, 1.2F, 2.0F, -1.5F, 1.0F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F, -1.2F, -0.5F, 0.0F, 0.8F, -0.5F, 0.0F, -1.2F, 0.0F, -1.0F, 0.8F, 0.0F, -1.0F);
    this.rightLegModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[9].addShapeBox(-4.7F, -0.5F, -0.2F, 1, 11, 5, 0.0F, -1.4F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 2.0F, 0.0F, -2.0F, -2.5F, 0.0F, -2.0F, 0.8F, 0.0F, 1.0F, -1.2F, 0.0F, 1.0F, 1.8F, 0.0F, 0.0F, -2.2F, 0.0F, 0.0F);
    this.rightLegModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 185, this.textureX, this.textureY);
    this.skirtFrontModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 217, this.textureX, this.textureY);
    this.skirtFrontModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 217, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.5F, -2.5F, -3.4F, 9, 13, 1, 0.0F, 0.2F, -0.5F, -0.2F, 0.2F, -0.5F, -0.2F, 0.2F, -0.5F, -0.2F, 0.2F, -0.5F, -0.2F, 1.2F, -0.5F, 0.8F, 1.2F, -0.5F, 0.8F, 1.2F, -0.5F, -1.2F, 1.2F, -0.5F, -1.2F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[1].addShapeBox(5.7F, -0.5F, -4.2F, 1, 11, 5, 0.0F, 1.2F, 2.0F, -1.5F, -2.0F, 2.0F, -1.5F, -1.4F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.8F, -0.5F, 0.0F, -1.2F, -0.5F, 0.0F, 0.8F, 0.0F, -1.0F, -1.2F, 0.0F, -1.0F);
    this.skirtFrontModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[2].addShapeBox(-6.7F, -0.5F, -4.2F, 1, 11, 5, 0.0F, -2.0F, 2.0F, -1.5F, 1.2F, 2.0F, -1.5F, 1.0F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F, -1.2F, -0.5F, 0.0F, 0.8F, -0.5F, 0.0F, -1.2F, 0.0F, -1.0F, 0.8F, 0.0F, -1.0F);
    this.skirtFrontModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 193, this.textureX, this.textureY);
    this.skirtRearModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 201, this.textureX, this.textureY);
    this.skirtRearModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 217, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-4.5F, -0.5F, 3.0F, 9, 11, 1, 0.0F, 0.5F, -1.0F, -0.2F, 0.5F, -1.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -2.2F, 0.0F, 0.0F, -2.2F, 0.0F, 0.5F, 1.8F, 0.0F, 0.5F, 1.8F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel[1].addShapeBox(5.7F, -0.5F, 0.8F, 1, 11, 5, 0.0F, 1.0F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F, -2.5F, 0.0F, -2.0F, 2.0F, 0.0F, -2.0F, -1.2F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F, -2.2F, 0.0F, 0.0F, 1.8F, 0.0F, 0.0F);
    this.skirtRearModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel[2].addShapeBox(-6.7F, -0.5F, 0.8F, 1, 11, 5, 0.0F, -1.4F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 2.0F, 0.0F, -2.0F, -2.5F, 0.0F, -2.0F, 0.8F, 0.0F, 1.0F, -1.2F, 0.0F, 1.0F, 1.8F, 0.0F, 0.0F, -2.2F, 0.0F, 0.0F);
    this.skirtRearModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
