package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelModernMail extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelModernMail() {
    this.headModel = new ModelRendererTurbo[18];
    this.bodyModel = new ModelRendererTurbo[2];
    this.leftArmModel = new ModelRendererTurbo[2];
    this.rightArmModel = new ModelRendererTurbo[2];
    this.leftLegModel = new ModelRendererTurbo[3];
    this.rightLegModel = new ModelRendererTurbo[3];
    initheadModel_1();
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -2.0F, -4.0F, 4, 2, 8, 0.0F, 0.1F, 0.5F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -7.5F, -4.0F, 2, 3, 8, 0.0F, 0.1F, 0.6F, 0.1F, 0.0F, 0.6F, 0.1F, 0.0F, 0.6F, 0.1F, 0.1F, 0.6F, 0.1F, 0.1F, 1.0F, 0.1F, 0.0F, 0.3F, 0.1F, 0.0F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-2.0F, -7.5F, -4.0F, 4, 4, 8, 0.0F, 0.0F, 0.6F, 0.1F, 0.0F, 0.6F, 0.1F, 0.0F, 0.6F, 0.1F, 0.0F, 0.6F, 0.1F, 0.0F, -0.7F, 0.1F, 0.0F, -0.7F, 0.1F, 0.0F, 1.0F, 0.1F, 0.0F, 1.0F, 0.1F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -3.5F, -4.0F, 1, 1, 8, 0.0F, 0.1F, 0.0F, 0.1F, -0.6F, 0.5F, 0.1F, -0.3F, 0.5F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, -0.3F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -7.5F, -4.0F, 2, 3, 8, 0.0F, 0.3F, 0.8F, 0.3F, 0.0F, 1.0F, 0.3F, 0.0F, 1.0F, 0.3F, 0.3F, 0.8F, 0.3F, 0.3F, 0.2F, 0.3F, 1.5F, 0.5F, 0.3F, 0.8F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-2.0F, -7.5F, -4.0F, 4, 3, 8, 0.0F, 0.0F, 1.0F, 0.3F, 0.0F, 1.0F, 0.3F, 0.0F, 1.0F, 0.3F, 0.0F, 1.0F, 0.3F, -1.5F, 0.5F, 0.3F, -1.5F, 0.5F, 0.3F, -0.8F, 0.2F, 0.3F, -0.8F, 0.2F, 0.3F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.0F, -4.1F, -4.0F, 1, 4, 8, 0.0F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-3.0F, -4.1F, 3.0F, 6, 4, 1, 0.0F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-3.0F, -2.0F, -4.0F, 3, 2, 1, 0.0F, 0.3F, 0.0F, 0.3F, 0.0F, -1.0F, 0.3F, 0.0F, -1.0F, -0.3F, 0.3F, 0.0F, -0.3F, 0.3F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, -0.3F, 0.3F, 0.2F, -0.3F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.0F, 0.5F, -4.0F, 2, 2, 8, 0.0F, 0.3F, 0.3F, 0.3F, 0.5F, 0.3F, 0.3F, 0.5F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, -0.5F, 0.0F, 0.3F, 0.5F, 1.0F, 0.3F, 0.5F, 1.0F, 0.3F, -0.5F, 0.0F, 0.3F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-1.5F, 0.5F, -4.0F, 3, 3, 8, 0.0F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(2.0F, -7.5F, -4.0F, 2, 3, 8, 0.0F, 0.0F, 1.0F, 0.3F, 0.3F, 0.8F, 0.3F, 0.3F, 0.8F, 0.3F, 0.0F, 1.0F, 0.3F, 1.5F, 0.5F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.8F, 0.2F, 0.3F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(3.0F, -4.1F, -4.0F, 1, 4, 8, 0.0F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(2.0F, 0.5F, -4.0F, 2, 2, 8, 0.0F, 0.5F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.5F, 0.3F, 0.3F, 0.5F, 1.0F, 0.3F, -0.5F, 0.0F, 0.3F, -0.5F, 0.0F, 0.3F, 0.5F, 1.0F, 0.3F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(2.0F, -7.5F, -4.0F, 2, 3, 8, 0.0F, 0.0F, 0.6F, 0.1F, 0.1F, 0.6F, 0.1F, 0.1F, 0.6F, 0.1F, 0.0F, 0.6F, 0.1F, 0.0F, 0.3F, 0.1F, 0.1F, 1.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.0F, 2.0F, 0.1F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(3.0F, -3.5F, -4.0F, 1, 1, 8, 0.0F, -0.6F, 0.5F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, -0.3F, 0.5F, 0.1F, -0.3F, 0.2F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.0F, 0.2F, 0.1F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(0.0F, -2.0F, -4.0F, 4, 2, 8, 0.0F, 0.0F, 0.1F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.0F, 0.5F, 0.1F, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(0.0F, -2.0F, -4.0F, 3, 2, 1, 0.0F, 0.0F, -1.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, -0.3F, 0.0F, -1.0F, -0.3F, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, -0.3F, 0.0F, 0.2F, -0.3F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 10, 4, 0.0F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 8.5F, -2.0F, 8, 6, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, -0.2F, 0.1F, 0.1F, -0.2F, 0.1F, 0.1F, -0.2F, 0.1F, 0.1F, -0.2F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, -0.2F, 0.1F, 0.1F, -0.2F, 0.1F, 0.1F, -0.2F, 0.1F, 0.1F, -0.2F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 89, 41, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 7.8F, -2.0F, 4, 3, 4, 0.0F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 89, 41, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 7.8F, -2.0F, 4, 3, 4, 0.0F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
