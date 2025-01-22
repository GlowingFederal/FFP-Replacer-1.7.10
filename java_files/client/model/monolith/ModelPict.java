package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPict extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelPict() {
    this.headModel = new ModelRendererTurbo[1];
    this.bodyModel = new ModelRendererTurbo[15];
    this.leftArmModel = new ModelRendererTurbo[3];
    this.rightArmModel = new ModelRendererTurbo[3];
    this.leftLegModel = new ModelRendererTurbo[7];
    this.rightLegModel = new ModelRendererTurbo[11];
    initheadModel_1();
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -10.0F, -4.0F, 8, 8, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 17, 41, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 89, 41, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 105, 41, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-3.5F, 9.0F, -2.5F, 7, 3, 4, 0.0F, -1.0F, 0.0F, 0.3F, -1.0F, 0.0F, 0.3F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, -2.8F, 0.0F, -0.7F, -2.8F, 0.0F, -0.7F, 0.1F, -2.0F, 1.1F, 0.1F, -2.0F, 1.1F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-3.5F, 2.5F, -4.0F, 2, 3, 3, 0.0F, 1.0F, -0.5F, -1.0F, 1.0F, -1.0F, -0.5F, 2.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 0.5F, -1.3F, -1.0F, 0.5F, -1.0F, -1.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-3.5F, 6.5F, -2.0F, 7, 2, 3, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-3.5F, -0.5F, -3.5F, 3, 3, 4, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -0.5F, -2.0F, -0.5F, -0.5F, 0.3F, -0.5F, -0.5F, 0.3F, 1.0F, 0.5F, -0.5F, 0.2F, 1.0F, 0.0F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.5F, -0.4F, -1.5F, 5, 1, 3, 0.0F, 0.0F, -0.2F, 0.0F, -1.5F, 1.3F, -1.0F, -0.5F, 1.3F, 0.0F, 0.0F, -0.2F, 0.2F, -0.3F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.5F, -1.0F, 1.5F, -1.3F, 0.0F, 0.5F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, -0.4F, -1.0F, 4, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.2F, 0.7F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.7F, 0.7F, 0.0F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(0.0F, -0.4F, -1.0F, 4, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.5F, 0.0F, 1.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -1.0F, -1.0F, 0.7F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-1.5F, -3.0F, -1.2F, 3, 3, 3, 0.0F, 0.3F, 0.0F, -0.5F, 0.3F, 0.0F, -0.5F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(0.5F, -0.5F, -3.5F, 3, 3, 4, 0.0F, 0.0F, -0.5F, -2.0F, 0.0F, 0.0F, -2.0F, -0.5F, -0.5F, 0.3F, -0.5F, -0.5F, 0.3F, 0.2F, 1.0F, 0.0F, 1.0F, 0.5F, -0.5F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-3.5F, 0.0F, -3.5F, 4, 5, 6, 0.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, 0.3F, 0.5F, 0.5F, 0.0F, 0.0F, 0.5F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, -1.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(1.5F, 2.5F, -4.0F, 2, 3, 3, 0.0F, 1.0F, -1.0F, -0.5F, 1.0F, -0.5F, -1.0F, 1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 1.0F, 0.5F, -1.0F, -1.0F, 0.5F, -1.3F, -1.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-0.5F, 0.0F, -3.5F, 4, 5, 6, 0.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, -2.0F, 0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.3F, 0.0F, -1.0F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 1.0F, -1.0F, 0.0F, 1.0F, -1.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-3.0F, 6.5F, -3.0F, 6, 2, 1, 0.0F, 0.0F, 2.5F, 0.0F, 0.0F, 2.5F, 0.0F, 0.5F, 1.5F, 0.0F, 0.5F, 1.5F, 0.0F, -0.5F, 0.5F, -0.2F, -0.5F, 0.5F, -0.2F, 1.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-0.5F, -0.4F, -1.5F, 5, 1, 3, 0.0F, -1.5F, 1.3F, -1.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.2F, -0.5F, 1.3F, 0.0F, 0.0F, -1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.5F, -0.5F, -1.0F, 1.5F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-2.0F, 9.5F, -3.5F, 4, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 41, 49, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 57, 49, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 73, 49, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.5F, -2.5F, -1.5F, 3, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, -0.5F, -0.6F, 0.2F, -0.5F, -0.6F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.7F, 1.0F, 0.0F, -0.4F, 1.0F, 0.0F, 0.3F, -0.5F, 0.0F, 0.4F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-0.7F, -0.5F, -1.0F, 2, 4, 3, 0.0F, 0.2F, -1.0F, 1.2F, 1.2F, -1.0F, 0.0F, 1.2F, -1.0F, 0.8F, 0.2F, -1.0F, 0.9F, -0.5F, 0.0F, 0.5F, 1.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-0.45F, 3.5F, -1.0F, 2, 6, 3, 0.0F, -0.3F, 0.0F, 0.7F, 0.7F, 0.0F, 0.2F, 0.7F, -0.5F, 0.2F, -0.3F, -0.5F, 0.2F, -0.4F, 0.5F, 1.2F, 0.5F, 0.5F, 1.2F, 0.5F, 1.0F, -1.5F, -0.4F, 1.0F, -1.5F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 97, 9, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 113, 9, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-1.5F, -2.5F, -1.5F, 3, 3, 4, 0.0F, 0.2F, -0.5F, -0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, -0.5F, -0.6F, 1.0F, 0.0F, -0.4F, -1.0F, 0.0F, 0.7F, -0.5F, 0.0F, 0.4F, 1.0F, 0.0F, 0.3F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-1.2F, -0.5F, -1.0F, 2, 4, 3, 0.0F, 1.2F, -1.0F, 0.0F, 0.2F, -1.0F, 1.2F, 0.2F, -1.0F, 0.9F, 1.2F, -1.0F, 0.8F, 1.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.5F, -0.5F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-1.55F, 3.5F, -1.0F, 2, 6, 3, 0.0F, 0.7F, 0.0F, 0.2F, -0.3F, 0.0F, 0.7F, -0.3F, -0.5F, 0.2F, 0.7F, -0.5F, 0.2F, 0.5F, 0.5F, 1.2F, -0.4F, 0.5F, 1.2F, -0.4F, 1.0F, -1.5F, 0.5F, 1.0F, -1.5F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 17, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 89, 17, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.leftLegModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.leftLegModel[6] = new ModelRendererTurbo((ModelBase)this, 113, 49, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-1.7F, -0.5F, -2.0F, 4, 6, 4, 0.0F, 0.0F, 0.0F, 0.5F, 0.2F, 2.5F, 0.5F, 0.2F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, -0.2F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-1.7F, 5.5F, -2.0F, 3, 7, 4, 0.0F, -0.2F, 0.0F, -0.5F, 0.4F, 0.0F, -0.5F, 0.4F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, -0.8F, 0.4F, 0.0F, -0.8F, 0.4F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-3.0F, -0.4F, 1.0F, 2, 1, 2, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, -0.5F, 0.5F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, -0.5F, -1.0F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-3.0F, -3.4F, 1.0F, 2, 2, 2, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.8F, 0.0F, -1.0F, -0.8F, -0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, -0.5F, 0.5F, 0.0F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-1.0F, -0.1F, -2.0F, 4, 1, 3, 0.0F, 0.0F, 0.5F, 0.0F, -0.8F, 0.5F, -0.5F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[5].addShapeBox(-1.0F, -3.1F, -2.0F, 4, 2, 3, 0.0F, 0.0F, -0.8F, 0.0F, -0.8F, 0.1F, 0.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F, -0.8F, 0.5F, -0.5F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.leftLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[6].addShapeBox(-1.2F, 11.0F, -3.0F, 3, 1, 5, 0.0F, 0.4F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, -0.8F, -0.2F, 0.0F, -0.8F, -0.2F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F);
    this.leftLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.rightLegModel[5] = new ModelRendererTurbo((ModelBase)this, 73, 33, this.textureX, this.textureY);
    this.rightLegModel[6] = new ModelRendererTurbo((ModelBase)this, 89, 33, this.textureX, this.textureY);
    this.rightLegModel[7] = new ModelRendererTurbo((ModelBase)this, 105, 33, this.textureX, this.textureY);
    this.rightLegModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.rightLegModel[9] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.rightLegModel[10] = new ModelRendererTurbo((ModelBase)this, 113, 49, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(1.0F, -3.4F, 1.0F, 2, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, -0.8F, -0.5F, 0.0F, -0.8F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-3.0F, -3.4F, 1.0F, 4, 2, 2, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.8F, 0.0F, -1.5F, -0.8F, -0.5F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, -0.8F, 0.5F, 0.0F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(1.0F, -0.4F, 1.0F, 2, 1, 2, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, -0.5F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-3.0F, -0.4F, 1.0F, 4, 1, 2, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, -0.8F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-2.2F, -0.5F, -2.0F, 4, 6, 4, 0.0F, 0.2F, 2.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, -0.4F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[5].addShapeBox(-1.2F, 5.5F, -2.0F, 3, 7, 4, 0.0F, 0.4F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, -0.8F, -0.2F, 0.0F, -0.8F, -0.2F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F);
    this.rightLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[6].addShapeBox(-3.0F, -0.1F, -2.0F, 4, 1, 3, 0.0F, -0.8F, 0.5F, -0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F);
    this.rightLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[7].addShapeBox(-3.0F, -3.1F, -2.0F, 4, 2, 3, 0.0F, -0.8F, 0.1F, 0.5F, 0.0F, -0.8F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.8F, 0.5F, -0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F);
    this.rightLegModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[8].addShapeBox(3.0F, -3.4F, 1.0F, 4, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.5F, -0.8F, -0.5F, 0.0F, -0.8F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.8F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F);
    this.rightLegModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[9].addShapeBox(3.0F, -0.4F, 1.0F, 4, 1, 2, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.8F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.rightLegModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[10].addShapeBox(-1.2F, 11.0F, -3.0F, 3, 1, 5, 0.0F, 0.4F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, -0.8F, -0.2F, 0.0F, -0.8F, -0.2F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F);
    this.rightLegModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
