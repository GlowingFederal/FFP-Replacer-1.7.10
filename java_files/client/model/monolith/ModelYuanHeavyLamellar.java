package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelYuanHeavyLamellar extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelYuanHeavyLamellar() {
    this.bodyModel = new ModelRendererTurbo[21];
    this.leftArmModel = new ModelRendererTurbo[5];
    this.rightArmModel = new ModelRendererTurbo[6];
    this.leftLegModel = new ModelRendererTurbo[2];
    this.rightLegModel = new ModelRendererTurbo[2];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 65, 25, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 113, 9, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 81, 25, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 65, 25, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 113, 9, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 10.0F, -2.5F, 8, 1, 5, 0.0F, 0.7F, 0.0F, 0.3F, 0.7F, 0.0F, 0.3F, 0.7F, 0.0F, 0.3F, 0.7F, 0.0F, 0.3F, 0.7F, -0.3F, 0.3F, 0.7F, -0.3F, 0.3F, 0.7F, -0.3F, 0.3F, 0.7F, -0.3F, 0.3F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-0.5F, 1.5F, -2.6F, 1, 8, 1, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-6.0F, -0.7F, -3.0F, 6, 2, 1, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 5.5F, -1.0F, 0.0F, 5.0F, -1.0F, 0.0F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 5.5F, -1.0F, 0.0F, 5.5F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-0.5F, 1.0F, -3.5F, 1, 1, 1, 0.0F, 1.0F, -1.6F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, 1.0F, -1.6F, -0.2F, 0.0F, 1.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, 1.0F, -0.2F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-0.5F, 1.0F, -3.5F, 1, 1, 1, 0.0F, -0.4F, -0.2F, -0.2F, 1.0F, -1.6F, -0.2F, 1.0F, -1.6F, -0.2F, -0.4F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, 1.0F, -0.2F, 0.0F, 1.0F, -0.2F, 0.0F, -0.2F, -0.2F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 4.5F, -2.5F, 8, 10, 10, 0.0F, 0.8F, 0.0F, 0.2F, -4.2F, 0.0F, 0.2F, -4.0F, 0.0F, -4.8F, 0.8F, 0.0F, -4.8F, 0.6F, -4.5F, 0.2F, -4.2F, -4.5F, 0.2F, -4.0F, -4.5F, -4.8F, 0.6F, -4.5F, -4.8F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.0F, 1.5F, -2.7F, 8, 3, 1, 0.0F, 0.0F, 0.2F, 0.0F, -4.2F, 0.0F, 0.0F, -4.2F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.7F, 0.0F, 0.0F, -4.2F, 0.0F, 0.0F, -4.2F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-4.0F, 1.5F, 1.7F, 4, 3, 1, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-5.0F, 3.5F, -2.5F, 1, 3, 10, 0.0F, 0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, 0.0F, 0.0F, -4.8F, 0.2F, 0.0F, -4.8F, 0.0F, 0.5F, 0.2F, -0.2F, 0.4F, 0.2F, 0.0F, 0.4F, -4.8F, 0.0F, 0.5F, -4.8F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-5.0F, 3.5F, -3.7F, 4, 3, 1, 0.0F, 0.0F, 0.0F, -0.5F, -1.7F, 0.0F, -0.5F, -1.7F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.2F, 0.5F, -0.7F, -2.2F, 0.2F, -0.7F, -2.2F, 0.2F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-3.0F, 4.0F, -3.0F, 6, 1, 6, 0.0F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-5.0F, 3.5F, 2.7F, 4, 3, 1, 0.0F, 0.2F, 0.0F, 0.0F, -1.7F, 0.0F, 0.0F, -1.7F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.5F, 0.0F, -2.2F, 0.2F, 0.0F, -2.2F, 0.2F, -0.7F, -0.2F, 0.5F, -0.7F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-0.5F, 4.3F, -3.0F, 1, 2, 1, 0.0F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.6F, -0.5F, 0.3F, -1.0F, -0.2F, 0.3F, -1.0F, -0.2F, 0.0F, 0.6F, -0.5F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-4.0F, 4.5F, -2.5F, 8, 10, 10, 0.0F, -4.2F, 0.0F, 0.2F, 0.8F, 0.0F, 0.2F, 0.8F, 0.0F, -4.8F, -4.0F, 0.0F, -4.8F, -4.2F, -4.5F, 0.2F, 0.6F, -4.5F, 0.2F, 0.6F, -4.5F, -4.8F, -4.0F, -4.5F, -4.8F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-4.0F, 1.5F, -2.7F, 8, 3, 1, 0.0F, -4.2F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -4.2F, 0.0F, 0.0F, -4.2F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -4.2F, 0.0F, 0.0F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(0.0F, -0.7F, -3.0F, 6, 2, 1, 0.0F, 0.0F, 0.3F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 5.0F, 0.0F, 0.3F, 5.5F, 0.0F, 0.5F, 0.0F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 5.5F, 0.0F, 0.5F, 5.5F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(4.0F, 3.5F, -2.5F, 1, 3, 10, 0.0F, -0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, -4.8F, 0.0F, 0.0F, -4.8F, -0.2F, 0.4F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, -4.8F, 0.0F, 0.4F, -4.8F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(1.0F, 3.5F, -3.7F, 4, 3, 1, 0.0F, -1.7F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.2F, 0.0F, 0.0F, -1.7F, 0.0F, 0.0F, -2.2F, 0.2F, -0.7F, -0.2F, 0.5F, -0.7F, 0.0F, 0.5F, 0.0F, -2.2F, 0.2F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(1.0F, 3.5F, 2.7F, 4, 3, 1, 0.0F, -1.7F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.7F, 0.0F, -0.5F, -2.2F, 0.2F, 0.0F, 0.0F, 0.5F, 0.0F, -0.2F, 0.5F, -0.7F, -2.2F, 0.2F, -0.7F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(0.0F, 1.5F, 1.7F, 4, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(-0.5F, 4.3F, -3.0F, 1, 2, 1, 0.0F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -1.0F, -0.2F, 0.3F, 0.6F, -0.5F, 0.3F, 0.6F, -0.5F, 0.0F, -1.0F, -0.2F, 0.0F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 89, 9, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.leftArmModel[4] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-5.0F, -2.0F, -3.0F, 8, 5, 1, 0.0F, -4.0F, 0.0F, -0.25F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.0F, -4.0F, 0.0F, -0.25F, -5.3F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.25F, -5.3F, 0.0F, -0.25F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(3.0F, -2.0F, -2.0F, 1, 10, 8, 0.0F, -0.2F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, -3.5F, -0.2F, 0.0F, -3.5F, -0.2F, -5.0F, 0.7F, 0.2F, -5.0F, 0.7F, 0.2F, -5.0F, -3.3F, -0.2F, -5.0F, -3.3F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-1.7F, 3.0F, -2.0F, 6, 4, 8, 0.0F, -2.0F, 0.0F, 0.7F, -0.1F, 0.0F, 0.7F, -0.1F, 0.0F, -3.3F, -2.0F, 0.0F, -3.3F, -2.8F, -1.7F, 0.7F, 0.0F, -1.5F, 0.7F, 0.0F, -1.5F, -3.3F, -2.8F, -1.7F, -3.3F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(-5.0F, -2.0F, 2.0F, 8, 5, 1, 0.0F, -4.0F, 0.0F, -0.25F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.5F, -4.0F, 0.0F, -0.25F, -5.3F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F, 0.2F, 0.0F, -0.3F, -5.3F, 0.0F, -0.3F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[4].addShapeBox(0.0F, -2.7F, -3.0F, 4, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, -0.5F, -0.5F, -0.5F, 4.5F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.5F, -2.0F, -0.5F, 0.0F, -2.0F, -0.5F, 5.0F, 0.0F, 0.0F, 5.5F);
    this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 89, 9, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.rightArmModel[4] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.rightArmModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-4.0F, -2.7F, -3.0F, 4, 2, 1, 0.0F, -0.5F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, -0.5F, -0.5F, 4.5F, -2.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 5.5F, -2.0F, -0.5F, 5.0F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-4.0F, -2.0F, -2.0F, 1, 10, 8, 0.0F, 0.0F, -0.5F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, -3.5F, 0.0F, -0.5F, -3.5F, 0.2F, -5.0F, 0.7F, -0.2F, -5.0F, 0.7F, -0.2F, -5.0F, -3.3F, 0.2F, -5.0F, -3.3F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-4.3F, 3.0F, -2.0F, 6, 4, 8, 0.0F, -0.1F, 0.0F, 0.7F, -2.0F, 0.0F, 0.7F, -2.0F, 0.0F, -3.3F, -0.1F, 0.0F, -3.3F, 0.0F, -1.5F, 0.7F, -2.8F, -1.7F, 0.7F, -2.8F, -1.7F, -3.3F, 0.0F, -1.5F, -3.3F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-3.0F, -2.0F, -3.0F, 8, 5, 1, 0.0F, 0.2F, 0.0F, -0.5F, -4.0F, 0.0F, -0.25F, -4.0F, 0.0F, -0.25F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.3F, -5.3F, 0.0F, -0.3F, -5.3F, 0.0F, -0.25F, 0.2F, 0.0F, -0.25F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].addShapeBox(-1.0F, 2.0F, -2.0F, 3, 1, 4, 0.0F, 0.62F, 0.2F, 0.62F, 0.62F, -0.2F, 0.62F, 0.62F, -0.2F, 0.62F, 0.62F, 0.2F, 0.62F, 0.62F, -0.4F, 0.62F, 0.62F, 0.0F, 0.62F, 0.62F, 0.0F, 0.62F, 0.62F, -0.4F, 0.62F);
    this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[5].addShapeBox(-3.0F, -2.0F, 2.0F, 8, 5, 1, 0.0F, 0.2F, 0.0F, 0.0F, -4.0F, 0.0F, -0.25F, -4.0F, 0.0F, -0.25F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.25F, -5.3F, 0.0F, -0.25F, -5.3F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F);
    this.rightArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 89, 33, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-6.0F, -0.8F, -2.0F, 8, 16, 8, 0.0F, -3.9F, 0.5F, 0.7F, 0.5F, 0.5F, 0.7F, 0.5F, 0.5F, -3.3F, -3.9F, 0.5F, -3.3F, -4.5F, -7.8F, 2.2F, 2.5F, -8.2F, 1.5F, 2.5F, -8.2F, -2.5F, -4.5F, -7.8F, -1.8F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, -0.8F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, -0.7F, 0.4F, 2.2F, 2.5F, 0.0F, 1.5F, 2.5F, 0.0F, 1.5F, -0.7F, 0.4F, 2.2F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 89, 33, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, -0.8F, -2.0F, 8, 16, 8, 0.0F, 0.5F, 0.5F, 0.7F, -3.9F, 0.5F, 0.7F, -3.9F, 0.5F, -3.3F, 0.5F, 0.5F, -3.3F, 2.5F, -8.2F, 1.5F, -4.5F, -7.8F, 2.2F, -4.5F, -7.8F, -1.8F, 2.5F, -8.2F, -2.5F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, -0.8F, -2.0F, 4, 9, 4, 0.0F, 0.0F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 2.5F, 0.0F, 1.5F, -0.7F, 0.4F, 2.2F, -0.7F, 0.4F, 2.2F, 2.5F, 0.0F, 1.5F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
