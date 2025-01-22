package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelAlmainRivet extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelAlmainRivet() {
    this.bodyModel = new ModelRendererTurbo[15];
    this.leftArmModel = new ModelRendererTurbo[3];
    this.rightArmModel = new ModelRendererTurbo[3];
    this.leftLegModel = new ModelRendererTurbo[5];
    this.rightLegModel = new ModelRendererTurbo[5];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 1.5F, -2.5F, 4, 3, 5, 0.0F, -0.2F, 0.0F, 0.6F, 0.0F, -0.5F, 1.5F, 0.0F, 0.0F, 1.0F, -0.2F, 0.0F, 0.7F, -0.3F, -1.0F, 0.8F, 0.0F, 0.0F, 2.3F, 0.0F, 0.0F, 1.5F, -0.3F, -1.0F, 0.8F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 4.5F, -2.5F, 4, 2, 5, 0.0F, -0.3F, 1.0F, 0.8F, 0.0F, 0.0F, 2.3F, 0.0F, 0.0F, 1.5F, -0.3F, 1.0F, 0.8F, 0.8F, -1.0F, 1.0F, 0.0F, 0.51F, 2.5F, 0.0F, 0.0F, 1.6F, 0.8F, -1.0F, 0.9F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 6.5F, -2.5F, 4, 3, 5, 0.0F, 0.8F, 1.0F, 1.0F, 0.0F, -0.5F, 2.5F, 0.0F, 0.0F, 1.6F, 0.8F, 1.0F, 0.9F, 0.6F, -1.0F, 0.8F, 0.0F, 0.2F, 2.2F, 0.0F, 0.0F, 1.7F, 0.6F, -1.0F, 0.7F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 10.0F, -2.5F, 4, 1, 5, 0.0F, 0.3F, 1.5F, 0.8F, 0.0F, 0.3F, 2.2F, 0.0F, 0.5F, 1.7F, 0.3F, 1.5F, 0.4F, 0.9F, -1.6F, 1.0F, 0.0F, -0.5F, 2.8F, 0.0F, -0.8F, 2.3F, 0.9F, -1.6F, 0.6F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, -1.0F, -2.0F, 1, 1, 4, 0.0F, 0.0F, 0.0F, 0.6F, -0.2F, 0.0F, 0.6F, -0.2F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F, -0.5F, 1.1F, 1.3F, 0.3F, 1.0F, 1.3F, 0.3F, 1.0F, 1.3F, -0.5F, 1.2F, 1.3F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, -0.5F, -2.5F, 4, 3, 5, 0.0F, 0.5F, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.5F, 0.0F, 0.2F, -0.5F, 0.0F, 0.3F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, -0.5F, 0.0F, 0.3F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.0F, 0.5F, -2.5F, 2, 1, 5, 0.0F, 0.0F, 0.3F, 0.3F, -0.5F, 0.6F, 0.4F, -0.5F, 0.6F, 0.4F, 0.0F, 0.3F, 0.3F, -0.2F, 0.0F, 0.6F, 0.0F, 0.25F, 1.0F, 0.0F, 0.0F, 0.85F, -0.2F, 0.0F, 0.7F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-6.0F, -0.7F, -2.5F, 2, 2, 5, 0.0F, 0.0F, 0.2F, 0.2F, -0.3F, 0.1F, 0.2F, -0.3F, 0.1F, 0.2F, 0.0F, 0.2F, 0.2F, -0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.5F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(0.0F, -0.5F, -2.5F, 4, 3, 5, 0.0F, 0.0F, 0.2F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.0F, 1.0F, -0.5F, 0.0F, 0.3F, -0.5F, 0.0F, 0.3F, 0.0F, 0.0F, 1.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(0.0F, 1.5F, -2.5F, 4, 3, 5, 0.0F, 0.0F, -0.5F, 1.5F, -0.2F, 0.0F, 0.6F, -0.2F, 0.0F, 0.7F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 2.3F, -0.3F, -1.0F, 0.8F, -0.3F, -1.0F, 0.8F, 0.0F, 0.0F, 1.5F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(0.0F, 4.5F, -2.5F, 4, 2, 5, 0.0F, 0.0F, 0.0F, 2.3F, -0.3F, 1.0F, 0.8F, -0.3F, 1.0F, 0.8F, 0.0F, 0.0F, 1.5F, 0.0F, 0.51F, 2.5F, 0.8F, -1.0F, 1.0F, 0.8F, -1.0F, 0.9F, 0.0F, 0.0F, 1.6F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(0.0F, 6.5F, -2.5F, 4, 3, 5, 0.0F, 0.0F, -0.5F, 2.5F, 0.8F, 1.0F, 1.0F, 0.8F, 1.0F, 0.9F, 0.0F, 0.0F, 1.6F, 0.0F, 0.2F, 2.2F, 0.6F, -1.0F, 0.8F, 0.6F, -1.0F, 0.7F, 0.0F, 0.0F, 1.7F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(0.0F, 10.0F, -2.5F, 4, 1, 5, 0.0F, 0.0F, 0.3F, 2.2F, 0.3F, 1.5F, 0.8F, 0.3F, 1.5F, 0.4F, 0.0F, 0.5F, 1.7F, 0.0F, -0.5F, 2.8F, 0.9F, -1.6F, 1.0F, 0.9F, -1.6F, 0.6F, 0.0F, -0.8F, 2.3F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(2.0F, 0.5F, -2.5F, 2, 1, 5, 0.0F, -0.5F, 0.6F, 0.4F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, -0.5F, 0.6F, 0.4F, 0.0F, 0.25F, 1.0F, -0.2F, 0.0F, 0.6F, -0.2F, 0.0F, 0.7F, 0.0F, 0.0F, 0.85F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(4.0F, -0.7F, -2.5F, 2, 2, 5, 0.0F, -0.3F, 0.1F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, -0.3F, 0.1F, 0.2F, 0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.3F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(0.5F, -2.5F, -2.5F, 2, 2, 5, 0.0F, -0.3F, 0.1F, 0.1F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, -0.3F, 0.1F, 0.1F, 0.2F, -0.1F, 0.3F, -0.4F, 0.7F, 0.5F, -0.4F, 0.7F, 0.5F, 0.2F, -0.1F, 0.3F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(2.0F, -2.2F, -2.5F, 2, 2, 5, 0.0F, -0.3F, 0.1F, 0.1F, 0.3F, -0.3F, 0.2F, 0.3F, -0.3F, 0.2F, -0.3F, 0.1F, 0.1F, 0.2F, -0.1F, 0.3F, -1.5F, 1.0F, 0.5F, -1.5F, 1.0F, 0.5F, 0.2F, -0.1F, 0.3F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(2.0F, -1.0F, -2.5F, 2, 2, 5, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.3F, 0.1F, -0.2F, 0.3F, 0.1F, 0.0F, 0.0F, 0.0F, -0.5F, 0.8F, 0.1F, 0.6F, -0.2F, 0.2F, 0.6F, -0.2F, 0.2F, -0.5F, 0.8F, 0.1F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-2.5F, -2.5F, -2.5F, 2, 2, 5, 0.0F, 0.0F, 0.0F, 0.2F, -0.3F, 0.1F, 0.1F, -0.3F, 0.1F, 0.1F, 0.0F, 0.0F, 0.2F, -0.4F, 0.7F, 0.5F, 0.2F, -0.1F, 0.3F, 0.2F, -0.1F, 0.3F, -0.4F, 0.7F, 0.5F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-4.0F, -2.2F, -2.5F, 2, 2, 5, 0.0F, 0.3F, -0.3F, 0.2F, -0.3F, 0.1F, 0.1F, -0.3F, 0.1F, 0.1F, 0.3F, -0.3F, 0.2F, -1.5F, 1.0F, 0.5F, 0.2F, -0.1F, 0.3F, 0.2F, -0.1F, 0.3F, -1.5F, 1.0F, 0.5F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-4.0F, -1.0F, -2.5F, 2, 2, 5, 0.0F, -0.2F, 0.3F, 0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.3F, 0.1F, 0.6F, -0.2F, 0.2F, -0.5F, 0.8F, 0.1F, -0.5F, 0.8F, 0.1F, 0.6F, -0.2F, 0.2F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, -2.5F, -3.5F, 4, 1, 1, 0.0F, 0.0F, -0.7F, 1.0F, 0.2F, 0.0F, 0.1F, 0.3F, 0.0F, 0.1F, 0.0F, -0.7F, 0.6F, 0.0F, 0.4F, 1.2F, 0.8F, 0.0F, 0.3F, 1.0F, 0.0F, 0.3F, 0.0F, 0.4F, 0.6F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, -1.0F, -3.5F, 4, 1, 1, 0.0F, 0.0F, 0.0F, 1.4F, 0.6F, 0.5F, 0.5F, 0.8F, 0.5F, -0.1F, 0.0F, 0.0F, -0.6F, -0.9F, 0.4F, 1.2F, 1.5F, 0.0F, 0.3F, 1.5F, 0.0F, -0.2F, -0.9F, 0.4F, -0.8F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-1.5F, 0.5F, -3.5F, 4, 3, 1, 0.0F, -0.3F, 0.0F, 1.4F, 0.8F, 0.5F, 0.5F, 1.0F, 0.5F, -0.1F, -0.3F, 0.0F, -0.6F, -0.6F, 0.4F, 0.9F, 1.3F, 0.0F, 0.0F, 1.3F, 0.0F, 0.1F, -0.6F, 0.4F, -0.5F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-1.5F, 1.7F, -3.5F, 4, 3, 1, 0.0F, -0.3F, 0.0F, 1.4F, 1.2F, 0.5F, 0.5F, 1.2F, 0.5F, -0.1F, -0.3F, 0.0F, -0.6F, -0.6F, 0.4F, 0.9F, 1.6F, 0.0F, 0.0F, 1.6F, 0.0F, 0.1F, -0.6F, 0.4F, -0.5F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-1.5F, 3.0F, -3.5F, 4, 3, 1, 0.0F, -0.3F, 0.0F, 1.4F, 1.4F, 0.5F, 0.5F, 1.4F, 0.5F, -0.1F, -0.3F, 0.0F, -0.6F, -0.6F, -0.1F, 0.9F, 1.8F, -0.8F, 0.0F, 1.8F, -0.8F, 0.1F, -0.6F, -0.1F, -0.5F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, -2.5F, -3.5F, 4, 1, 1, 0.0F, 0.2F, 0.0F, 0.1F, 0.0F, -0.7F, 1.0F, 0.0F, -0.7F, 0.6F, 0.3F, 0.0F, 0.1F, 0.8F, 0.0F, 0.3F, 0.0F, 0.4F, 1.2F, 0.0F, 0.4F, 0.6F, 1.0F, 0.0F, 0.3F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, -1.0F, -3.5F, 4, 1, 1, 0.0F, 0.6F, 0.5F, 0.5F, 0.0F, 0.0F, 1.4F, 0.0F, 0.0F, -0.6F, 0.8F, 0.5F, -0.1F, 1.5F, 0.0F, 0.3F, -0.9F, 0.4F, 1.2F, -0.9F, 0.4F, -0.8F, 1.5F, 0.0F, -0.2F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.5F, 0.5F, -3.5F, 4, 3, 1, 0.0F, 0.8F, 0.5F, 0.5F, -0.3F, 0.0F, 1.4F, -0.3F, 0.0F, -0.6F, 1.0F, 0.5F, -0.1F, 1.3F, 0.0F, 0.0F, -0.6F, 0.4F, 0.9F, -0.6F, 0.4F, -0.5F, 1.3F, 0.0F, 0.1F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.5F, 1.7F, -3.5F, 4, 3, 1, 0.0F, 1.2F, 0.5F, 0.5F, -0.3F, 0.0F, 1.4F, -0.3F, 0.0F, -0.6F, 1.2F, 0.5F, -0.1F, 1.6F, 0.0F, 0.0F, -0.6F, 0.4F, 0.9F, -0.6F, 0.4F, -0.5F, 1.6F, 0.0F, 0.1F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-2.5F, 3.0F, -3.5F, 4, 3, 1, 0.0F, 1.4F, 0.5F, 0.5F, -0.3F, 0.0F, 1.4F, -0.3F, 0.0F, -0.6F, 1.4F, 0.5F, -0.1F, 1.8F, -0.8F, 0.0F, -0.6F, -0.1F, 0.9F, -0.6F, -0.1F, -0.5F, 1.8F, -0.8F, 0.1F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
