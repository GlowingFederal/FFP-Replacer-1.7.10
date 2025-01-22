package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMusketeer extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelMusketeer() {
    this.bodyModel = new ModelRendererTurbo[21];
    this.leftArmModel = new ModelRendererTurbo[14];
    this.rightArmModel = new ModelRendererTurbo[14];
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
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 77, 48, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, -1.0F, -3.5F, 2, 2, 5, 0.0F, 0.2F, 0.1F, -0.3F, 1.5F, 0.0F, -0.7F, 0.6F, 0.2F, 1.2F, 0.0F, 0.2F, 0.7F, -1.6F, -0.3F, 0.2F, 2.5F, -1.3F, -0.8F, 0.8F, -1.0F, 1.5F, 0.0F, -0.8F, 1.3F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-2.0F, -1.0F, -3.5F, 2, 2, 5, 0.0F, 1.5F, 0.0F, -1.3F, 0.2F, 0.1F, -0.3F, 0.0F, 0.2F, 0.7F, 0.6F, 0.2F, 1.2F, 2.5F, -1.3F, -0.8F, -1.6F, -0.3F, 0.2F, 0.0F, -0.8F, 1.3F, 0.8F, -1.0F, 1.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F, 0.5F, 0.5F, 0.2F, 0.0F, 1.0F, 0.2F, 0.0F, 1.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.1F, 0.2F, 0.0F, 1.1F, 0.2F, 0.0F, 1.1F, 0.2F, 0.5F, 0.1F, 0.2F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-7.0F, 0.0F, -2.0F, 2, 3, 4, 0.0F, 0.0F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.0F, 0.0F, 0.2F, -1.0F, -0.9F, 0.2F, 0.5F, 0.1F, 0.2F, 0.5F, 0.1F, 0.2F, -1.0F, -0.9F, 0.2F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 8.0F, -2.0F, 4, 5, 4, 0.0F, 0.2F, -0.1F, 0.0F, 0.0F, -1.1F, 0.2F, 0.0F, -1.1F, 0.2F, 0.2F, -0.1F, 0.0F, 1.0F, 0.5F, 0.5F, 0.0F, 1.5F, 1.0F, 0.0F, 1.5F, 1.0F, 1.0F, 0.5F, 0.5F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-1.0F, 0.0F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-1.0F, 1.0F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(5.0F, 0.0F, -2.0F, 2, 3, 4, 0.0F, 0.5F, 0.5F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.1F, 0.2F, -1.0F, -0.9F, 0.2F, -1.0F, -0.9F, 0.2F, 0.5F, 0.1F, 0.2F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(0.0F, 0.0F, -2.0F, 4, 8, 4, 0.0F, 0.0F, 1.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.0F, 1.0F, 0.2F, 0.0F, 1.1F, 0.2F, 0.5F, 0.1F, 0.2F, 0.5F, 0.1F, 0.2F, 0.0F, 1.1F, 0.2F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(0.0F, 8.0F, -2.0F, 4, 5, 4, 0.0F, 0.0F, -1.1F, 0.2F, 0.2F, -0.1F, 0.0F, 0.2F, -0.1F, 0.0F, 0.0F, -1.1F, 0.2F, 0.0F, 1.5F, 1.0F, 1.0F, 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 0.0F, 1.5F, 1.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-1.0F, 1.5F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-1.0F, 2.5F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-1.0F, 3.0F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-1.0F, 4.0F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-1.0F, 4.5F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-1.0F, 5.5F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-1.0F, 6.0F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-1.0F, 7.0F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-1.0F, 7.5F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(-1.0F, 8.5F, -2.7F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(-4.0F, 7.7F, -2.0F, 8, 2, 4, 0.0F, 0.8F, 0.0F, 0.4F, 0.8F, 0.0F, 0.4F, 0.8F, 0.0F, 0.4F, 0.8F, 0.0F, 0.4F, 0.8F, 0.0F, 0.4F, 0.8F, 0.0F, 0.4F, 0.8F, 0.0F, 0.4F, 0.8F, 0.0F, 0.4F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.leftArmModel[4] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.leftArmModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.leftArmModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.leftArmModel[7] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.leftArmModel[8] = new ModelRendererTurbo((ModelBase)this, 121, 17, this.textureX, this.textureY);
    this.leftArmModel[9] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.leftArmModel[10] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.leftArmModel[11] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.leftArmModel[12] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.leftArmModel[13] = new ModelRendererTurbo((ModelBase)this, 60, 50, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, 6.0F, -2.0F, 4, 2, 4, 0.0F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-1.0F, 2.0F, -2.0F, 4, 4, 4, 0.0F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F, 0.4F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[4].addShapeBox(-0.25F, -2.0F, -2.0F, 1, 5, 4, 0.0F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F);
    this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[5].addShapeBox(1.25F, -2.0F, -2.0F, 1, 5, 4, 0.0F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F);
    this.leftArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[6].addShapeBox(-1.0F, -2.0F, 0.25F, 4, 5, 1, 0.0F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F);
    this.leftArmModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[7].addShapeBox(-1.0F, -2.0F, -1.25F, 4, 5, 1, 0.0F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F);
    this.leftArmModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[8].addShapeBox(2.55F, -2.0F, -2.55F, 1, 5, 1, 0.0F, 0.0F, 0.3F, -0.1F, -0.1F, 0.3F, -0.1F, -0.1F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.0F, 0.0F, 0.3F, 0.1F);
    this.leftArmModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[9].addShapeBox(-1.55F, -2.0F, -2.55F, 1, 5, 1, 0.0F, -0.1F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, 0.1F, 0.3F, 0.1F, 0.0F, 0.3F, 0.1F, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.0F);
    this.leftArmModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[10].addShapeBox(-1.55F, -2.0F, 1.55F, 1, 5, 1, 0.0F, -0.1F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, -0.1F, -0.1F, 0.3F, -0.1F, 0.1F, 0.3F, 0.0F, 0.0F, 0.3F, 0.1F, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F);
    this.leftArmModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[11].addShapeBox(2.55F, -2.0F, 1.55F, 1, 5, 1, 0.0F, 0.0F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.0F, 0.1F, 0.3F, 0.1F, 0.0F, 0.3F, 0.1F);
    this.leftArmModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[12].addShapeBox(-1.0F, 3.5F, -2.0F, 4, 1, 4, 0.0F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.4F, -0.5F, 0.4F, 0.4F, -0.5F, 0.4F, 0.4F, -0.5F, 0.4F, 0.4F, -0.5F, 0.4F);
    this.leftArmModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[13].addShapeBox(-1.0F, 5.4F, -2.0F, 4, 2, 4, 0.0F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftArmModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.rightArmModel[4] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.rightArmModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.rightArmModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.rightArmModel[7] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.rightArmModel[8] = new ModelRendererTurbo((ModelBase)this, 121, 17, this.textureX, this.textureY);
    this.rightArmModel[9] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.rightArmModel[10] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.rightArmModel[11] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.rightArmModel[12] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.rightArmModel[13] = new ModelRendererTurbo((ModelBase)this, 60, 50, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, 6.0F, -2.0F, 4, 2, 4, 0.0F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-3.0F, 2.0F, -2.0F, 4, 4, 4, 0.0F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F, 0.4F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].addShapeBox(-2.25F, -2.0F, -2.0F, 1, 5, 4, 0.0F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F);
    this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[5].addShapeBox(-0.75F, -2.0F, -2.0F, 1, 5, 4, 0.0F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.4F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F, 0.1F, 0.3F, 0.6F);
    this.rightArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[6].addShapeBox(-3.0F, -2.0F, 0.25F, 4, 5, 1, 0.0F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F);
    this.rightArmModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[7].addShapeBox(-3.0F, -2.0F, -1.25F, 4, 5, 1, 0.0F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.4F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F, 0.6F, 0.3F, 0.1F);
    this.rightArmModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[8].addShapeBox(0.55F, -2.0F, -2.55F, 1, 5, 1, 0.0F, 0.0F, 0.3F, -0.1F, -0.1F, 0.3F, -0.1F, -0.1F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.0F, 0.0F, 0.3F, 0.1F);
    this.rightArmModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[9].addShapeBox(-3.55F, -2.0F, -2.55F, 1, 5, 1, 0.0F, -0.1F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, 0.1F, 0.3F, 0.1F, 0.0F, 0.3F, 0.1F, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.0F);
    this.rightArmModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[10].addShapeBox(-3.55F, -2.0F, 1.55F, 1, 5, 1, 0.0F, -0.1F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, -0.1F, -0.1F, 0.3F, -0.1F, 0.1F, 0.3F, 0.0F, 0.0F, 0.3F, 0.1F, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F);
    this.rightArmModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[11].addShapeBox(0.55F, -2.0F, 1.55F, 1, 5, 1, 0.0F, 0.0F, 0.3F, 0.0F, -0.1F, 0.3F, 0.0F, -0.1F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, 0.1F, 0.1F, 0.3F, 0.0F, 0.1F, 0.3F, 0.1F, 0.0F, 0.3F, 0.1F);
    this.rightArmModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[12].addShapeBox(-3.0F, 3.5F, -2.0F, 4, 1, 4, 0.0F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.6F, 0.2F, 0.6F, 0.4F, -0.5F, 0.4F, 0.4F, -0.5F, 0.4F, 0.4F, -0.5F, 0.4F, 0.4F, -0.5F, 0.4F);
    this.rightArmModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[13].addShapeBox(-3.0F, 5.4F, -2.0F, 4, 2, 4, 0.0F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightArmModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 83, 36, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 4, 51, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 4, 1, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 5.8F, -2.0F, 4, 1, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-2.0F, 6.8F, -2.0F, 4, 4, 4, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 83, 36, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 4, 51, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 4, 1, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 5.8F, -2.0F, 4, 1, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-2.0F, 6.8F, -2.0F, 4, 4, 4, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
