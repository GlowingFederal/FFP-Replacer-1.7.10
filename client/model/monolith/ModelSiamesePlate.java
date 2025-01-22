package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSiamesePlate extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 256;
  
  public ModelSiamesePlate() {
    this.bodyModel = new ModelRendererTurbo[14];
    this.leftArmModel = new ModelRendererTurbo[6];
    this.rightArmModel = new ModelRendererTurbo[6];
    this.leftLegModel = new ModelRendererTurbo[6];
    this.rightLegModel = new ModelRendererTurbo[8];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 113, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 89, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 153, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 169, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 185, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 201, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 41, 113, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 33, 145, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 33, 145, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 0.5F, -2.5F, 12, 4, 5, 0.0F, -0.2F, 0.8F, 0.7F, -8.0F, -0.2F, 1.5F, -8.0F, 0.5F, 0.5F, -0.2F, 0.8F, 0.3F, 0.0F, -3.0F, 1.0F, -8.0F, -2.5F, 2.0F, -8.0F, -3.0F, 1.0F, 0.0F, -3.0F, 0.7F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 1.5F, -2.5F, 12, 9, 5, 0.0F, 0.0F, 0.0F, 1.0F, -8.0F, -0.5F, 2.0F, -8.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.7F, 0.3F, -7.0F, 1.3F, -8.0F, -6.0F, 2.3F, -8.0F, -6.0F, 1.5F, 0.3F, -7.0F, 0.8F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 4.5F, -2.5F, 12, 5, 5, 0.0F, 0.3F, 1.0F, 1.3F, -8.0F, 0.0F, 2.3F, -8.0F, 0.0F, 1.5F, 0.3F, 1.0F, 0.8F, 1.0F, -5.0F, 1.3F, -8.0F, -3.49F, 2.3F, -8.0F, -4.0F, 1.6F, 1.0F, -5.0F, 0.9F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 5.5F, -2.5F, 4, 4, 5, 0.0F, 1.0F, 1.0F, 1.3F, 0.0F, -0.5F, 2.3F, 0.0F, 0.0F, 1.6F, 1.0F, 1.0F, 0.9F, 0.4F, -0.5F, 0.8F, 0.0F, 0.2F, 1.5F, 0.0F, 0.0F, 1.2F, 0.4F, -0.5F, 0.2F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 10.0F, -2.5F, 4, 6, 5, 0.0F, 0.3F, 1.0F, 0.8F, 0.0F, 0.3F, 1.5F, 0.0F, 0.5F, 1.2F, 0.3F, 1.0F, 0.1F, 0.5F, -5.7F, 0.5F, 0.0F, -5.0F, 2.0F, 0.0F, -5.3F, 1.3F, 0.9F, -5.7F, 0.0F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-2.0F, 2.5F, -4.8F, 24, 18, 1, 0.0F, 0.0F, 0.0F, -0.2F, -20.0F, 0.0F, -0.2F, -20.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -15.0F, 0.1F, -20.0F, -15.0F, 0.1F, -20.0F, -15.0F, 0.0F, 0.0F, -15.0F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-8.0F, 0.5F, -2.5F, 12, 4, 5, 0.0F, -8.0F, -0.2F, 1.5F, -0.2F, 0.8F, 0.7F, -0.2F, 0.8F, 0.3F, -8.0F, 0.5F, 0.5F, -8.0F, -2.5F, 2.0F, 0.0F, -3.0F, 1.0F, 0.0F, -3.0F, 0.7F, -8.0F, -3.0F, 1.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-8.0F, 4.5F, -2.5F, 12, 5, 5, 0.0F, -8.0F, 0.0F, 2.3F, 0.3F, 1.0F, 1.3F, 0.3F, 1.0F, 0.8F, -8.0F, 0.0F, 1.5F, -8.0F, -3.49F, 2.3F, 1.0F, -5.0F, 1.3F, 1.0F, -5.0F, 0.9F, -8.0F, -4.0F, 1.6F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-8.0F, 1.5F, -2.5F, 12, 9, 5, 0.0F, -8.0F, -0.5F, 2.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.7F, -8.0F, 0.0F, 1.0F, -8.0F, -6.0F, 2.3F, 0.3F, -7.0F, 1.3F, 0.3F, -7.0F, 0.8F, -8.0F, -6.0F, 1.5F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-2.0F, 5.5F, -4.8F, 24, 28, 1, 0.0F, 0.0F, 0.0F, 0.1F, -20.0F, 0.0F, 0.1F, -20.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -25.0F, -0.5F, -20.0F, -25.0F, -0.5F, -20.0F, -25.0F, 0.0F, 0.0F, -25.0F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(0.0F, 5.5F, -2.5F, 4, 4, 5, 0.0F, 0.0F, -0.5F, 2.3F, 1.0F, 1.0F, 1.3F, 1.0F, 1.0F, 0.9F, 0.0F, 0.0F, 1.6F, 0.0F, 0.2F, 1.5F, 0.4F, -0.5F, 0.8F, 0.4F, -0.5F, 0.2F, 0.0F, 0.0F, 1.2F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(0.0F, 10.0F, -2.5F, 4, 6, 5, 0.0F, 0.0F, 0.3F, 1.5F, 0.3F, 1.0F, 0.8F, 0.3F, 1.0F, 0.1F, 0.0F, 0.5F, 1.2F, 0.0F, -5.0F, 2.0F, 0.5F, -5.7F, 0.5F, 0.9F, -5.7F, 0.0F, 0.0F, -5.3F, 1.3F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-3.8F, 10.6F, -3.5F, 3, 1, 6, 0.0F, 1.2F, 0.5F, 0.2F, 0.8F, 0.0F, 1.2F, 0.8F, 0.0F, 1.2F, 1.2F, 0.5F, 0.2F, 1.0F, 0.0F, 0.2F, 1.2F, 0.5F, 1.2F, 1.2F, 0.5F, 1.2F, 1.0F, 0.0F, 0.2F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(0.8F, 10.6F, -3.5F, 3, 1, 6, 0.0F, 1.0F, 0.0F, 1.2F, 1.2F, 0.5F, 0.2F, 1.2F, 0.5F, 0.2F, 1.0F, 0.0F, 1.2F, 1.2F, 0.5F, 1.2F, 0.8F, 0.0F, 0.2F, 0.8F, 0.0F, 0.2F, 1.2F, 0.5F, 1.2F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 121, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 137, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.leftArmModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.leftArmModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 73, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-9.0F, 0.4F, -2.0F, 12, 6, 4, 0.0F, -8.5F, 0.5F, 2.0F, 1.0F, 0.0F, 0.3F, 1.0F, 0.0F, 0.3F, -8.5F, 0.5F, 2.0F, -8.0F, -5.0F, 2.0F, 0.0F, -4.2F, 0.3F, 0.0F, -4.2F, 0.3F, -8.0F, -5.0F, 2.0F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-9.0F, -2.1F, -2.0F, 12, 9, 4, 0.0F, -7.5F, 0.7F, 1.4F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, -7.5F, 0.7F, 1.4F, -8.5F, -7.0F, 2.0F, 1.0F, -6.5F, 0.3F, 1.0F, -6.5F, 0.3F, -8.5F, -7.0F, 2.0F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(1.0F, 2.0F, -2.0F, 2, 1, 4, 0.0F, 1.1F, 0.0F, 0.8F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 1.1F, 0.0F, 0.8F, 0.1F, 0.2F, 1.2F, 0.5F, -0.3F, 0.3F, 0.5F, -0.3F, 0.3F, 0.1F, 0.2F, 1.2F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(1.0F, 3.0F, -2.0F, 2, 1, 4, 0.0F, 1.1F, 0.0F, 0.8F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 1.1F, 0.0F, 0.8F, 0.1F, 0.2F, 1.2F, 0.5F, -0.3F, 0.3F, 0.5F, -0.3F, 0.3F, 0.1F, 0.2F, 1.2F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[4].addShapeBox(-1.0F, 5.0F, -2.0F, 4, 4, 4, 0.0F, 0.8F, 0.0F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.0F, 0.8F, 0.3F, -0.2F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, -0.2F, 0.3F);
    this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[5].addShapeBox(0.0F, 9.0F, -2.0F, 3, 1, 4, 0.0F, 1.3F, 0.2F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 1.3F, 0.2F, 0.3F, -1.2F, -0.5F, 0.8F, 0.5F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F, -1.2F, -0.5F, 0.8F);
    this.leftArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.rightArmModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.rightArmModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 73, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.1F, -2.0F, 12, 9, 4, 0.0F, 0.0F, 0.3F, 0.3F, -7.5F, 0.7F, 1.4F, -7.5F, 0.7F, 1.4F, 0.0F, 0.3F, 0.3F, 1.0F, -6.5F, 0.3F, -8.5F, -7.0F, 2.0F, -8.5F, -7.0F, 2.0F, 1.0F, -6.5F, 0.3F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, 0.4F, -2.0F, 12, 6, 4, 0.0F, 1.0F, 0.0F, 0.3F, -8.5F, 0.5F, 2.0F, -8.5F, 0.5F, 2.0F, 1.0F, 0.0F, 0.3F, 0.0F, -4.2F, 0.3F, -8.0F, -5.0F, 2.0F, -8.0F, -5.0F, 2.0F, 0.0F, -4.2F, 0.3F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-3.0F, 5.0F, -2.0F, 4, 4, 4, 0.0F, 0.8F, 0.5F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.5F, 0.8F, 0.3F, 0.0F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-3.0F, 2.0F, -2.0F, 2, 1, 4, 0.0F, 0.1F, 0.5F, 0.1F, 1.1F, 0.0F, 0.8F, 1.1F, 0.0F, 0.8F, 0.1F, 0.5F, 0.1F, 0.5F, -0.3F, 0.3F, 0.1F, 0.2F, 1.2F, 0.1F, 0.2F, 1.2F, 0.5F, -0.3F, 0.3F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].addShapeBox(-3.0F, 3.0F, -2.0F, 2, 1, 4, 0.0F, 0.1F, 0.5F, 0.1F, 1.1F, 0.0F, 0.8F, 1.1F, 0.0F, 0.8F, 0.1F, 0.5F, 0.1F, 0.5F, -0.3F, 0.3F, 0.1F, 0.2F, 1.2F, 0.1F, 0.2F, 1.2F, 0.5F, -0.3F, 0.3F);
    this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[5].addShapeBox(-3.0F, 9.0F, -2.0F, 3, 1, 4, 0.0F, 0.3F, 0.0F, 0.3F, 1.3F, 0.2F, 0.3F, 1.3F, 0.2F, 0.3F, 0.3F, 0.0F, 0.3F, 0.5F, -0.2F, 0.5F, -1.2F, -0.5F, 0.8F, -1.2F, -0.5F, 0.8F, 0.5F, -0.2F, 0.5F);
    this.rightArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 81, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 49, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.leftLegModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 57, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-11.2F, 4.3F, -4.0F, 15, 4, 1, 0.0F, -10.0F, 0.0F, 0.5F, 0.0F, 0.7F, -0.9F, 0.0F, 0.7F, 0.5F, -10.0F, 0.0F, -0.9F, -10.4F, -2.7F, 0.8F, -0.1F, -3.2F, -0.5F, -0.1F, -3.2F, 0.2F, -10.4F, -2.7F, -1.2F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, -0.5F, -4.0F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.7F, -0.9F, 0.0F, 0.7F, 0.5F, 0.0F, 0.0F, -0.9F, -0.4F, 0.3F, 0.8F, -0.1F, -0.2F, -0.5F, -0.1F, -0.2F, 0.2F, -0.4F, 0.3F, -1.2F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-1.8F, 0.7F, -4.0F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.7F, -0.9F, 0.0F, 0.7F, 0.5F, 0.0F, 0.0F, -0.9F, -0.4F, 0.3F, 0.8F, -0.1F, -0.2F, -0.5F, -0.1F, -0.2F, 0.2F, -0.4F, 0.3F, -1.2F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-1.6F, 1.9F, -4.0F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.7F, -0.9F, 0.0F, 0.7F, 0.5F, 0.0F, 0.0F, -0.9F, -0.4F, 0.3F, 0.8F, -0.1F, -0.2F, -0.5F, -0.1F, -0.2F, 0.2F, -0.4F, 0.3F, -1.2F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-1.4F, 3.1F, -4.0F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.7F, -0.9F, 0.0F, 0.7F, 0.5F, 0.0F, 0.0F, -0.9F, -0.4F, 0.3F, 0.8F, -0.1F, -0.2F, -0.5F, -0.1F, -0.2F, 0.2F, -0.4F, 0.3F, -1.2F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[5].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 5, 4, 0.0F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.leftLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 49, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 81, this.textureX, this.textureY);
    this.rightLegModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 57, this.textureX, this.textureY);
    this.rightLegModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.rightLegModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-3.0F, -0.5F, -4.0F, 5, 1, 1, 0.0F, 0.0F, 0.7F, -0.9F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.9F, 0.0F, 0.7F, 0.5F, -0.1F, -0.2F, -0.5F, -0.4F, 0.3F, 0.8F, -0.4F, 0.3F, -1.2F, -0.1F, -0.2F, 0.2F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-3.2F, 0.7F, -4.0F, 5, 1, 1, 0.0F, 0.0F, 0.7F, -0.9F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.9F, 0.0F, 0.7F, 0.5F, -0.1F, -0.2F, -0.5F, -0.4F, 0.3F, 0.8F, -0.4F, 0.3F, -1.2F, -0.1F, -0.2F, 0.2F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-3.4F, 1.9F, -4.0F, 5, 1, 1, 0.0F, 0.0F, 0.7F, -0.9F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.9F, 0.0F, 0.7F, 0.5F, -0.1F, -0.2F, -0.5F, -0.4F, 0.3F, 0.8F, -0.4F, 0.3F, -1.2F, -0.1F, -0.2F, 0.2F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-3.6F, 3.1F, -4.0F, 5, 1, 1, 0.0F, 0.0F, 0.7F, -0.9F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.9F, 0.0F, 0.7F, 0.5F, -0.1F, -0.2F, -0.5F, -0.4F, 0.3F, 0.8F, -0.4F, 0.3F, -1.2F, -0.1F, -0.2F, 0.2F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-3.8F, 4.3F, -4.0F, 15, 4, 1, 0.0F, 0.0F, 0.7F, -0.9F, -10.0F, 0.0F, 0.5F, -10.0F, 0.0F, -0.9F, 0.0F, 0.7F, 0.5F, -0.1F, -3.2F, -0.5F, -10.4F, -2.7F, 0.8F, -10.4F, -2.7F, -1.2F, -0.1F, -3.2F, 0.2F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[5].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 5, 4, 0.0F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.rightLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[6].addShapeBox(0.7F, -0.7F, -4.5F, 2, 3, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, 0.2F, 0.0F, 1.6F, -0.4F, 0.0F, 1.6F, -0.4F, 0.0F, -1.1F, 0.2F, 0.0F, -1.1F);
    this.rightLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[7].addShapeBox(1.0F, -1.2F, -4.5F, 2, 3, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -1.4F, 0.0F, 1.7F, 1.2F, 0.0F, 1.7F, 1.2F, 0.0F, -1.1F, -1.4F, 0.0F, -1.1F);
    this.rightLegModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
