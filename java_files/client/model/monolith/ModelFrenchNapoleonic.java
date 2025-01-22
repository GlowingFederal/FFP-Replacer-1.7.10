package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelFrenchNapoleonic extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 32;
  
  public ModelFrenchNapoleonic() {
    this.bodyModel = new ModelRendererTurbo[22];
    this.leftArmModel = new ModelRendererTurbo[5];
    this.rightArmModel = new ModelRendererTurbo[5];
    this.leftLegModel = new ModelRendererTurbo[4];
    this.rightLegModel = new ModelRendererTurbo[4];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 80, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 97, 9, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 113, 17, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 97, 9, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 80, 14, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 113, 17, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 115, 1, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 116, 26, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-3.25F, 0.0F, -3.1F, 1, 1, 1, 0.0F, -0.7F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, -0.7F, -0.2F, -0.3F, -0.7F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-2.25F, 2.0F, -3.2F, 1, 1, 1, 0.0F, -0.7F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, -0.7F, -0.2F, -0.3F, -0.7F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-2.25F, 4.0F, -3.1F, 1, 1, 1, 0.0F, -0.7F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, -0.7F, -0.2F, -0.3F, -0.7F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-2.25F, 6.0F, -3.1F, 1, 1, 1, 0.0F, -0.7F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, -0.7F, -0.2F, -0.3F, -0.7F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-2.25F, 8.0F, -3.1F, 1, 1, 1, 0.0F, -0.7F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, -0.7F, -0.2F, -0.3F, -0.7F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(0.0F, -0.2F, -2.0F, 4, 7, 4, 0.0F, 0.0F, 0.25F, 0.5F, 0.7F, 0.1F, 0.5F, 0.7F, 0.1F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.0F, 0.2F, 0.5F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(0.0F, 7.0F, -2.0F, 4, 2, 4, 0.0F, 0.0F, 0.0F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.25F, 0.4F, 0.5F, 0.1F, 0.4F, 0.5F, 0.1F, 0.8F, 0.0F, 0.2F, 0.8F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-3.0F, -1.2F, -2.0F, 6, 1, 4, 0.0F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.3F, 0.5F, 0.2F, 0.3F, 0.5F, 0.2F, 0.3F, 0.5F, 0.2F, 0.3F, 0.5F, 0.2F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(0.0F, 8.5F, -2.0F, 4, 3, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, -0.2F, 0.2F, 0.4F, -0.2F, 0.2F, 0.4F, 0.2F, 0.2F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(0.0F, 9.0F, 0.0F, 4, 5, 2, 0.0F, -0.5F, -0.25F, 0.8F, 0.5F, -0.1F, 0.8F, 0.5F, -0.1F, 0.8F, 0.0F, -0.2F, 0.8F, 0.5F, 0.5F, 0.5F, -0.4F, 0.2F, 0.5F, 0.0F, 0.2F, 1.0F, 0.0F, 0.5F, 1.2F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(1.25F, 0.0F, -3.1F, 1, 1, 1, 0.0F, -0.7F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, -0.7F, -0.2F, -0.3F, -0.7F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(0.25F, 2.0F, -3.2F, 1, 1, 1, 0.0F, -0.7F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, -0.7F, -0.2F, -0.3F, -0.7F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(0.25F, 4.0F, -3.1F, 1, 1, 1, 0.0F, -0.7F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, -0.7F, -0.2F, -0.3F, -0.7F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(0.25F, 6.0F, -3.1F, 1, 1, 1, 0.0F, -0.7F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, -0.7F, -0.2F, -0.3F, -0.7F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(0.25F, 8.0F, -3.1F, 1, 1, 1, 0.0F, -0.7F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, 0.2F, -0.2F, -0.3F, -0.7F, -0.2F, -0.3F, -0.7F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, -0.7F, -0.3F, -0.3F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-4.0F, 8.5F, -2.0F, 4, 3, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.4F, -0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, -0.2F, 0.2F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-4.0F, 7.0F, -2.0F, 4, 2, 4, 0.0F, 0.3F, 0.2F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.3F, 0.2F, 0.5F, 0.5F, 0.1F, 0.4F, 0.0F, 0.25F, 0.4F, 0.0F, 0.2F, 0.8F, 0.5F, 0.1F, 0.8F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-4.0F, -0.2F, -2.0F, 4, 7, 4, 0.0F, 0.7F, 0.1F, 0.4F, 0.0F, 0.25F, 0.5F, 0.0F, 0.2F, 0.5F, 0.7F, 0.1F, 0.5F, 0.3F, 0.0F, 0.5F, 0.0F, 0.2F, 0.5F, 0.0F, 0.2F, 0.5F, 0.3F, 0.0F, 0.5F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-4.0F, 9.0F, 0.0F, 4, 5, 2, 0.0F, 0.5F, -0.1F, 0.8F, -0.5F, -0.25F, 0.8F, 0.0F, -0.2F, 0.8F, 0.5F, -0.1F, 0.8F, -0.4F, 0.2F, 0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.5F, 1.2F, 0.0F, 0.2F, 1.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(2.0F, -0.5F, -2.5F, 2, 11, 5, 0.0F, -0.3F, 0.1F, 0.4F, 0.3F, -0.1F, 0.4F, 0.3F, -0.1F, 0.2F, -0.3F, 0.1F, 0.2F, 6.5F, -1.5F, 0.5F, -8.7F, 1.8F, 0.5F, -8.4F, 3.8F, 0.8F, 6.5F, 0.8F, 0.8F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(-2.0F, 1.8F, -2.6F, 4, 7, 1, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(-2.0F, -0.2F, -2.6F, 4, 2, 1, 0.0F, 1.4F, 0.3F, -0.1F, 1.4F, 0.3F, -0.1F, 1.4F, 0.3F, 0.0F, 1.4F, 0.3F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 97, 17, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 19, 18, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.leftArmModel[4] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-2.0F, -2.5F, -1.5F, 4, 2, 3, 0.0F, 0.0F, 0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.2F, 1.1F, 0.2F, 0.3F, 0.9F, 0.2F, 0.3F, 0.9F, 0.2F, 0.2F, 1.1F, 0.2F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-1.0F, 6.5F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.2F, 0.6F, 0.2F, 0.3F, 0.4F, 0.2F, 0.3F, 0.4F, 0.2F, 0.2F, 0.6F, 0.2F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(3.0F, 6.5F, -0.5F, 1, 1, 1, 0.0F, -0.2F, -0.4F, -0.3F, -0.6F, -0.4F, -0.3F, -0.6F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, 0.1F, 0.0F, -0.3F, -0.6F, -1.0214052E-14F, -0.3F, -0.6F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[4].addShapeBox(3.0F, 5.0F, -0.5F, 1, 1, 1, 0.0F, -0.2F, -0.4F, -0.3F, -0.6F, -0.4F, -0.3F, -0.6F, -0.4F, -0.1F, -0.3F, -0.4F, -0.1F, 0.1F, 0.0F, -0.3F, -0.6F, -1.0214052E-14F, -0.3F, -0.6F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F);
    this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 19, 18, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.rightArmModel[4] = new ModelRendererTurbo((ModelBase)this, 97, 17, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.9F, 0.2F, 0.2F, 1.1F, 0.2F, 0.2F, 1.1F, 0.2F, 0.3F, 0.9F, 0.2F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, 6.5F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.4F, 0.2F, 0.2F, 0.6F, 0.2F, 0.2F, 0.6F, 0.2F, 0.3F, 0.4F, 0.2F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-4.0F, 5.0F, -0.5F, 1, 1, 1, 0.0F, -0.6F, -0.4F, -0.3F, -0.2F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.6F, -0.4F, -0.1F, -0.6F, -1.0214052E-14F, -0.3F, 0.1F, 0.0F, -0.3F, 0.1F, 0.0F, -0.1F, -0.6F, 0.0F, -0.1F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-4.0F, 6.5F, -0.5F, 1, 1, 1, 0.0F, -0.6F, -0.4F, -0.3F, -0.2F, -0.4F, -0.3F, -0.3F, -0.4F, -0.1F, -0.6F, -0.4F, -0.1F, -0.6F, -1.0214052E-14F, -0.3F, 0.1F, 0.0F, -0.3F, 0.1F, 0.0F, -0.1F, -0.6F, 0.0F, -0.1F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].addShapeBox(-2.0F, -2.5F, -1.5F, 4, 2, 3, 0.0F, 0.2F, -0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F);
    this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 5, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 22, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, -0.5F, -2.0F, 4, 5, 4, 0.0F, 0.4F, -0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, -0.2F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 4, 6, 5, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, -0.8F, 0.4F, 0.0F, -0.8F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -1.0F, -0.2F, 0.0F, -1.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 6.8F, -2.0F, 4, 4, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 5, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 65, 22, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, -0.5F, -2.0F, 4, 5, 4, 0.0F, 0.4F, 0.2F, 0.2F, 0.4F, -0.2F, 0.2F, 0.4F, -0.2F, 0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 4, 6, 5, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, -0.8F, 0.4F, 0.0F, -0.8F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -1.0F, -0.2F, 0.0F, -1.0F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 6.8F, -2.0F, 4, 4, 4, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
