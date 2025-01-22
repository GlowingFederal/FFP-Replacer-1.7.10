package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSikhInfantry extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelSikhInfantry() {
    this.bodyModel = new ModelRendererTurbo[14];
    this.leftArmModel = new ModelRendererTurbo[2];
    this.rightArmModel = new ModelRendererTurbo[2];
    this.leftLegModel = new ModelRendererTurbo[7];
    this.rightLegModel = new ModelRendererTurbo[7];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 49, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, -0.2F, -2.0F, 4, 8, 4, 0.0F, 0.7F, 0.1F, 0.4F, 0.0F, 0.15F, 0.45F, 0.0F, 0.15F, 0.5F, 0.7F, 0.1F, 0.5F, 0.3F, 0.0F, 0.4F, 0.0F, 0.2F, 0.45F, 0.0F, 0.2F, 0.5F, 0.3F, 0.0F, 0.5F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(0.0F, -0.2F, -2.0F, 4, 8, 4, 0.0F, 0.5F, 0.25F, 0.5F, 0.7F, 0.1F, 0.5F, 0.7F, 0.1F, 0.5F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.0F, 0.2F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-3.0F, -1.2F, -2.0F, 6, 1, 4, 0.0F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.3F, 0.5F, 0.2F, 0.3F, 0.5F, 0.2F, 0.3F, 0.5F, 0.2F, 0.3F, 0.5F, 0.2F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, -0.5F, -2.5F, 2, 9, 5, 0.0F, 0.3F, -0.1F, 0.2F, -0.3F, 0.1F, 0.2F, -0.3F, 0.1F, 0.2F, 0.3F, -0.1F, 0.2F, -8.7F, 1.8F, 0.4F, 6.5F, -0.2F, 0.2F, 6.5F, -0.2F, 0.2F, -8.7F, 1.8F, 0.4F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(2.0F, -0.5F, -2.5F, 2, 9, 5, 0.0F, -0.3F, 0.1F, 0.2F, 0.3F, -0.1F, 0.2F, 0.3F, -0.1F, 0.2F, -0.3F, 0.1F, 0.2F, 6.5F, -0.2F, 0.2F, -8.7F, 1.8F, 0.4F, -8.7F, 1.8F, 0.4F, 6.5F, -0.2F, 0.2F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-0.3F, -0.2F, -2.6F, 1, 1, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-0.3F, 1.3F, -2.6F, 1, 1, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-0.3F, 6.8F, -2.7F, 1, 1, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-0.3F, 5.5F, -2.6F, 1, 1, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-4.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F, 0.3F, 0.2F, 0.4F, 0.0F, 0.0F, 0.45F, 0.0F, 0.0F, 0.5F, 0.3F, 0.2F, 0.5F, 0.7F, 0.1F, 0.7F, 0.0F, 0.15F, 0.75F, 0.0F, 0.15F, 0.8F, 0.7F, 0.1F, 0.8F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(0.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.25F, 0.8F, 0.7F, 0.1F, 0.8F, 0.7F, 0.1F, 0.8F, 0.0F, 0.2F, 0.8F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-0.3F, 2.9F, -3.0F, 1, 1, 1, 0.0F, 1.2F, 0.0F, 0.1F, -1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.2F, 0.0F, 0.0F, -0.4F, 1.0F, 0.2F, 0.5F, 0.0F, 0.1F, 0.5F, 0.0F, 0.0F, -0.4F, 1.0F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-0.3F, 8.1F, -2.8F, 1, 1, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-0.3F, 9.4F, -2.9F, 1, 1, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.2F, 0.6F, 0.2F, 0.3F, 0.4F, 0.2F, 0.3F, 0.4F, 0.2F, 0.2F, 0.6F, 0.2F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, 6.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.2F, 0.6F, 0.2F, 0.3F, 0.4F, 0.2F, 0.3F, 0.4F, 0.2F, 0.2F, 0.6F, 0.2F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.4F, 0.2F, 0.2F, 0.6F, 0.2F, 0.2F, 0.6F, 0.2F, 0.3F, 0.4F, 0.2F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, 6.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.4F, 0.2F, 0.2F, 0.6F, 0.2F, 0.2F, 0.6F, 0.2F, 0.3F, 0.4F, 0.2F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 33, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.leftLegModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.leftLegModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F, 0.5F, -0.25F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.15F, 0.8F, 0.0F, -0.1F, 0.8F, -0.4F, 0.5F, 0.9F, 1.5F, 0.0F, 0.9F, 1.5F, 0.0F, 0.9F, -0.4F, 0.5F, 0.9F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, -0.5F, -2.0F, 4, 5, 4, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 5.5F, -2.0F, 4, 5, 4, 0.0F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-2.0F, 9.8F, -2.0F, 4, 1, 4, 0.0F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[5].addShapeBox(-2.0F, 10.0F, -4.8F, 4, 2, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.2F, -1.1F, 0.5F, 0.2F, -1.1F, 0.5F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F);
    this.leftLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[6].addShapeBox(-2.0F, -2.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F);
    this.leftLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 33, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.rightLegModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.rightLegModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, -2.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, -0.5F, -2.0F, 4, 5, 4, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 5.5F, -2.0F, 4, 5, 4, 0.0F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-2.0F, 9.8F, -2.0F, 4, 1, 4, 0.0F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[5].addShapeBox(-2.0F, 10.0F, -4.8F, 4, 2, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.2F, -1.1F, 0.5F, 0.2F, -1.1F, 0.5F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F);
    this.rightLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[6].addShapeBox(-2.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F, 0.7F, -0.15F, 0.7F, 0.0F, -0.1F, 0.75F, 0.0F, -0.1F, 0.8F, 0.7F, -0.15F, 0.8F, 1.5F, 0.0F, 0.88F, -0.4F, 0.5F, 0.88F, -0.4F, 0.5F, 0.88F, 1.5F, 0.0F, 0.88F);
    this.rightLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
