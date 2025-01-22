package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelKuyakPlate extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelKuyakPlate() {
    this.bodyModel = new ModelRendererTurbo[12];
    this.leftArmModel = new ModelRendererTurbo[6];
    this.rightArmModel = new ModelRendererTurbo[6];
    this.leftLegModel = new ModelRendererTurbo[9];
    this.rightLegModel = new ModelRendererTurbo[9];
    this.skirtFrontModel = new ModelRendererTurbo[2];
    this.skirtRearModel = new ModelRendererTurbo[2];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
    initskirtFrontModel_1();
    initskirtRearModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 73, 17, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 97, 25, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 105, 49, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 121, 41, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 121, 41, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 105, 49, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 65, 65, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-2.0F, 9.2F, -3.5F, 4, 1, 7, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -0.7F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.5F, 4.8F, -2.5F, 9, 6, 5, 0.0F, -0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.45F, 1.0F, -0.3F, -0.45F, 1.0F, -0.3F, -0.45F, 1.0F, -0.3F, -0.45F, 1.0F, -0.3F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.5F, -0.2F, -2.5F, 9, 5, 5, 0.0F, -0.4F, -0.1F, -0.4F, -0.4F, -0.1F, -0.4F, -0.4F, -0.1F, -0.4F, -0.4F, -0.1F, -0.4F, -0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(2.0F, 9.2F, -3.5F, 2, 1, 7, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, -1.0F, 0.2F, 0.0F, -1.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, -1.0F, 0.1F, 0.0F, -1.0F, 0.0F, 0.0F, -0.7F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(1.5F, -0.2F, -2.5F, 2, 2, 4, 0.0F, -0.1F, 0.1F, -0.2F, -0.1F, 0.1F, -0.3F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(1.5F, -0.2F, 1.4F, 2, 7, 1, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, 4.2F, 0.5F, 0.1F, -4.5F, 0.5F, -0.1F, -4.5F, 0.5F, 0.0F, 4.2F, 0.5F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-3.5F, -0.2F, 1.4F, 2, 7, 1, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, -4.5F, 0.5F, -0.1F, 4.2F, 0.5F, 0.1F, 4.2F, 0.5F, 0.0F, -4.5F, 0.5F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-3.5F, -0.2F, -2.5F, 2, 2, 4, 0.0F, -0.1F, 0.1F, -0.3F, -0.1F, 0.1F, -0.2F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, 0.1F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-4.0F, 9.2F, -3.5F, 2, 1, 7, 0.0F, 0.25F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.25F, 0.0F, -1.0F, 0.15F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.7F, 0.15F, 0.0F, -1.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-4.5F, 4.8F, -2.5F, 18, 10, 10, 0.0F, 0.0F, 0.0F, 0.5F, -9.0F, 0.0F, 0.5F, -9.0F, 0.0F, -4.6F, 0.0F, 0.0F, -4.6F, -0.25F, -5.0F, -0.1F, -9.25F, -5.0F, -0.1F, -9.25F, -5.0F, -5.1F, -0.25F, -5.0F, -5.1F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-4.5F, 9.8F, -2.5F, 18, 4, 10, 0.0F, -0.4F, 0.0F, -0.1F, -9.4F, 0.0F, -0.1F, -9.4F, 0.0F, -5.1F, -0.4F, 0.0F, -5.1F, 0.3F, -2.0F, 0.6F, -8.7F, -2.0F, 0.6F, -8.7F, -2.0F, -4.5F, 0.3F, -2.0F, -4.5F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-4.5F, 0.8F, -2.5F, 18, 8, 10, 0.0F, -0.1F, 0.0F, 0.2F, -9.1F, 0.0F, 0.2F, -9.1F, 0.0F, -4.9F, -0.1F, 0.0F, -4.9F, 0.0F, -4.0F, 0.5F, -9.0F, -4.0F, 0.5F, -9.0F, -4.0F, -4.6F, 0.0F, -4.0F, -4.6F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.leftArmModel[4] = new ModelRendererTurbo((ModelBase)this, 73, 9, this.textureX, this.textureY);
    this.leftArmModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, 9.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, 9.0F, -2.0F, 4, 3, 4, 0.0F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.2F, -2.2F, 0.2F, 0.2F, -2.2F, 0.2F, 0.2F, -2.2F, 0.2F, 0.2F, -2.2F, 0.2F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-1.0F, 2.4F, -2.0F, 4, 1, 4, 0.0F, 0.4F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.3F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F, 0.3F, 0.4F, 0.3F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(-1.0F, 5.7F, -2.0F, 4, 3, 4, 0.0F, 0.3F, 2.0F, 0.3F, 0.3F, 2.0F, 0.3F, 0.3F, 2.0F, 0.3F, 0.3F, 2.0F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[4].addShapeBox(-1.0F, 3.9F, -2.0F, 4, 2, 4, 0.0F, 0.4F, -0.8F, 0.5F, 0.4F, -0.8F, 0.5F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, -0.8F, 0.5F, 0.4F, -0.8F, 0.5F, 0.4F, 0.2F, 0.5F, 0.4F, 0.2F, 0.5F);
    this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[5].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.3F, 0.0F, 0.5F, 1.4F, 0.5F, 0.5F, 1.4F, 0.5F, 0.5F, 1.4F, 0.5F, 0.5F, 1.4F, 0.5F);
    this.leftArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.rightArmModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.rightArmModel[5] = new ModelRendererTurbo((ModelBase)this, 73, 9, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, 2.4F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.4F, 0.4F, 0.3F, 0.3F, 0.4F, 0.3F, 0.3F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 4, 4, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.4F, 0.0F, 0.5F, 1.4F, 0.5F, 0.5F, 1.4F, 0.5F, 0.5F, 1.4F, 0.5F, 0.5F, 1.4F, 0.5F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-3.0F, 5.7F, -2.0F, 4, 3, 4, 0.0F, 0.3F, 2.0F, 0.3F, 0.3F, 2.0F, 0.3F, 0.3F, 2.0F, 0.3F, 0.3F, 2.0F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-3.0F, 9.0F, -2.0F, 4, 3, 4, 0.0F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.2F, -2.2F, 0.2F, 0.2F, -2.2F, 0.2F, 0.2F, -2.2F, 0.2F, 0.2F, -2.2F, 0.2F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].addShapeBox(-3.0F, 9.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F);
    this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[5].addShapeBox(-3.0F, 3.9F, -2.0F, 4, 2, 4, 0.0F, 0.4F, -0.8F, 0.5F, 0.4F, -0.8F, 0.5F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, -0.8F, 0.5F, 0.4F, -0.8F, 0.5F, 0.4F, 0.2F, 0.5F, 0.4F, 0.2F, 0.5F);
    this.rightArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.leftLegModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.leftLegModel[6] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.leftLegModel[7] = new ModelRendererTurbo((ModelBase)this, 99, 3, this.textureX, this.textureY);
    this.leftLegModel[8] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 11.1F, -1.5F, 4, 1, 4, 0.0F, 0.4F, 0.5F, 0.0F, 0.4F, 0.5F, 0.0F, 0.4F, 0.5F, -0.4F, 0.4F, 0.5F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, -0.2F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-1.8F, 5.1F, -2.5F, 4, 1, 1, 0.0F, 0.2F, -0.3F, 0.0F, 0.2F, -0.3F, 0.0F, 0.2F, 0.7F, -0.4F, 0.2F, 0.7F, -0.4F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-1.8F, 6.1F, -2.0F, 4, 4, 4, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, -1.0F, 0.6F, 0.4F, -1.0F, 0.6F, 0.3F, 0.5F, 0.1F, 0.0F, 0.5F, 0.1F, 0.0F, 0.5F, 0.1F, 0.3F, 0.5F, 0.1F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-1.8F, 1.9F, -2.0F, 4, 5, 3, 0.0F, 0.5F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.8F, -1.5F, 0.2F, 0.5F, -1.5F, -0.7F, 0.2F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, -0.9F, 0.3F, 0.0F, -1.2F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-1.8F, 6.1F, -2.5F, 4, 1, 1, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F, 0.2F, -0.3F, 0.0F, 0.2F, -0.3F, 0.0F, 0.2F, 0.7F, -0.4F, 0.2F, 0.7F, -0.4F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[5].addShapeBox(2.0F, 6.5F, -1.8F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, -1.0F, 0.8F, -0.5F, 0.5F, 0.8F, -0.5F, 0.5F, 0.5F, 0.8F, -1.0F, 0.5F, 0.8F);
    this.leftLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[6].addShapeBox(2.0F, 5.5F, -1.8F, 1, 1, 3, 0.0F, -1.0F, 0.8F, -0.5F, 0.5F, 0.8F, -0.5F, 0.5F, 0.5F, 0.8F, -1.0F, 0.5F, 0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F);
    this.leftLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[7].addShapeBox(-2.0F, 11.1F, -3.5F, 4, 1, 2, 0.0F, -0.1F, 0.0F, 0.5F, -0.1F, 0.0F, 0.5F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftLegModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[8].addShapeBox(-2.0F, 1.1F, -2.0F, 4, 7, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 99, 3, this.textureX, this.textureY);
    this.rightLegModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.rightLegModel[6] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.rightLegModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.rightLegModel[8] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 1.1F, -2.0F, 4, 7, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.2F, 1.9F, -2.0F, 4, 5, 3, 0.0F, 0.8F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, -1.5F, -0.7F, 0.8F, -1.5F, 0.2F, 0.3F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.3F, 0.0F, -1.2F, 0.3F, 0.0F, -0.9F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.2F, 6.1F, -2.0F, 4, 4, 4, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, -1.0F, 0.6F, 0.4F, -1.0F, 0.6F, 0.0F, 0.5F, 0.1F, 0.3F, 0.5F, 0.1F, 0.3F, 0.5F, 0.1F, 0.0F, 0.5F, 0.1F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 11.1F, -1.5F, 4, 1, 4, 0.0F, 0.4F, 0.5F, 0.0F, 0.4F, 0.5F, 0.0F, 0.4F, 0.5F, -0.4F, 0.4F, 0.5F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, -0.2F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-2.0F, 11.1F, -3.5F, 4, 1, 2, 0.0F, -0.1F, 0.0F, 0.5F, -0.1F, 0.0F, 0.5F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[5].addShapeBox(-2.2F, 5.1F, -2.5F, 4, 1, 1, 0.0F, 0.2F, -0.3F, 0.0F, 0.2F, -0.3F, 0.0F, 0.2F, 0.7F, -0.4F, 0.2F, 0.7F, -0.4F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F);
    this.rightLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[6].addShapeBox(-2.2F, 6.1F, -2.5F, 4, 1, 1, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, -0.4F, 0.2F, -0.3F, 0.0F, 0.2F, -0.3F, 0.0F, 0.2F, 0.7F, -0.4F, 0.2F, 0.7F, -0.4F);
    this.rightLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[7].addShapeBox(-3.0F, 5.5F, -1.8F, 1, 1, 3, 0.0F, 0.5F, 0.8F, -0.5F, -1.0F, 0.8F, -0.5F, -1.0F, 0.5F, 0.8F, 0.5F, 0.5F, 0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F);
    this.rightLegModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[8].addShapeBox(-3.0F, 6.5F, -1.8F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.5F, 0.8F, -0.5F, -1.0F, 0.8F, -0.5F, -1.0F, 0.5F, 0.8F, 0.5F, 0.5F, 0.8F);
    this.rightLegModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 73, 41, this.textureX, this.textureY);
    this.skirtFrontModel[1] = new ModelRendererTurbo((ModelBase)this, 97, 41, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, -1.5F, -2.0F, 8, 2, 2, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.5F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F, 0.9F, 0.1F, 0.5F, 0.9F, 0.1F, 0.5F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[1].addShapeBox(-4.0F, 0.5F, -2.0F, 8, 2, 2, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 1.4F, 0.6F, 1.4F, 1.4F, 0.6F, 1.4F, 1.4F, 0.6F, 1.7F, 1.4F, 0.6F, 1.7F);
    this.skirtFrontModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 73, 41, this.textureX, this.textureY);
    this.skirtRearModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-4.0F, -1.5F, 0.0F, 8, 2, 2, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel[1].addShapeBox(-4.0F, 0.5F, 0.0F, 8, 2, 2, 0.0F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F, 1.4F, 0.6F, 1.8F, 1.4F, 0.6F, 1.7F, 1.4F, 0.6F, 1.4F, 1.4F, 0.6F, 1.4F);
    this.skirtRearModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
