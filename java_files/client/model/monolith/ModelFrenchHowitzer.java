package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelFrenchHowitzer extends ModelVehicle {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelFrenchHowitzer() {
    this.bodyModel = new ModelRendererTurbo[7];
    this.barrelModel = new ModelRendererTurbo[9];
    this.leftBackWheelModel = new ModelRendererTurbo[13];
    this.rightBackWheelModel = new ModelRendererTurbo[13];
    initbodyModel_1();
    initbarrelModel_1();
    initleftBackWheelModel_1();
    initrightBackWheelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 105, 17, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-33.0F, -2.0F, -3.0F, 42, 4, 6, 0.0F, 0.5F, -0.6F, -0.5F, 3.0F, -0.3F, 0.0F, 3.0F, -0.3F, 0.0F, 0.5F, -0.6F, -0.5F, -1.0F, -1.5F, -0.5F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -1.0F, -1.5F, -0.5F);
    this.bodyModel[0].func_78793_a(-8.0F, -4.9F, 0.0F);
    (this.bodyModel[0]).field_78808_h = 0.41887903F;
    this.bodyModel[1].addShapeBox(0.0F, -2.0F, -4.0F, 2, 2, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[1].func_78793_a(-1.0F, -12.9F, 0.0F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 6, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 8.0F, -0.15F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 4.0F, 8.0F, -0.1F);
    this.bodyModel[2].func_78793_a(-3.5F, -14.5F, -3.0F);
    (this.bodyModel[2]).field_78808_h = -0.2443461F;
    this.bodyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 6, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 8.0F, -0.15F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 4.0F, 8.0F, -0.1F);
    this.bodyModel[3].func_78793_a(-3.5F, -14.5F, 1.95F);
    (this.bodyModel[3]).field_78808_h = -0.2443461F;
    this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F, 4.0F, 1.5F, -0.1F, 1.3F, 4.7F, 0.0F, 1.3F, 4.7F, 0.0F, 4.0F, 1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[4].func_78793_a(-4.5F, -1.5F, -3.0F);
    this.bodyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 4, 2, 1, 0.0F, 4.0F, 1.5F, 0.0F, 1.3F, 4.7F, 0.0F, 1.3F, 4.7F, 0.0F, 4.0F, 1.5F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[5].func_78793_a(-4.5F, -1.5F, 2.0F);
    this.bodyModel[6].addShapeBox(-1.0F, -1.0F, 0.0F, 2, 2, 22, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[6].func_78793_a(-2.5F, -0.5F, -11.0F);
  }
  
  private void initbarrelModel_1() {
    this.barrelModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.barrelModel[1] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.barrelModel[2] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.barrelModel[3] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.barrelModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.barrelModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.barrelModel[6] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.barrelModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.barrelModel[8] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.barrelModel[0].addShapeBox(3.0F, -1.0F, -1.0F, 22, 2, 2, 0.0F, 0.0F, 0.7F, 0.7F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.7F, 0.7F, 0.0F, 0.7F, 0.7F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.7F, 0.7F);
    this.barrelModel[0].func_78793_a(0.0F, -14.2F, 0.0F);
    this.barrelModel[1].addShapeBox(1.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.7F, 0.7F, 0.0F, 0.7F, 0.7F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.7F, 0.7F, 0.0F, 0.7F, 0.7F, 0.0F, 1.0F, 1.0F);
    this.barrelModel[1].func_78793_a(0.0F, -14.2F, 0.0F);
    this.barrelModel[2].addShapeBox(-13.0F, -2.0F, -2.0F, 14, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[2].func_78793_a(0.0F, -14.2F, 0.0F);
    this.barrelModel[3].addShapeBox(-15.0F, -2.0F, -2.0F, 2, 4, 4, 0.0F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F);
    this.barrelModel[3].func_78793_a(0.0F, -14.2F, 0.0F);
    this.barrelModel[4].addShapeBox(-9.0F, -2.0F, -2.0F, 1, 4, 4, 0.0F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F);
    this.barrelModel[4].func_78793_a(0.0F, -14.2F, 0.0F);
    this.barrelModel[5].addShapeBox(25.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F);
    this.barrelModel[5].func_78793_a(0.0F, -14.2F, 0.0F);
    this.barrelModel[6].addShapeBox(-2.0F, -3.0F, -0.5F, 1, 1, 1, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.barrelModel[6].func_78793_a(0.0F, -14.2F, 0.0F);
    this.barrelModel[7].addShapeBox(0.5F, -3.0F, -0.5F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.barrelModel[7].func_78793_a(0.0F, -14.2F, 0.0F);
    this.barrelModel[8].addShapeBox(-2.0F, -4.0F, -0.5F, 3, 1, 1, 0.0F, -0.8F, -0.5F, 0.0F, -0.3F, -0.5F, 0.0F, -0.3F, -0.5F, 0.0F, -0.8F, -0.5F, 0.0F, -0.4F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.barrelModel[8].func_78793_a(0.0F, -14.2F, 0.0F);
  }
  
  private void initleftBackWheelModel_1() {
    this.leftBackWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.leftBackWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 113, 41, this.textureX, this.textureY);
    this.leftBackWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 65, this.textureX, this.textureY);
    this.leftBackWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 65, this.textureX, this.textureY);
    this.leftBackWheelModel[4] = new ModelRendererTurbo((ModelBase)this, 121, 41, this.textureX, this.textureY);
    this.leftBackWheelModel[5] = new ModelRendererTurbo((ModelBase)this, 89, 49, this.textureX, this.textureY);
    this.leftBackWheelModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.leftBackWheelModel[7] = new ModelRendererTurbo((ModelBase)this, 105, 57, this.textureX, this.textureY);
    this.leftBackWheelModel[8] = new ModelRendererTurbo((ModelBase)this, 121, 57, this.textureX, this.textureY);
    this.leftBackWheelModel[9] = new ModelRendererTurbo((ModelBase)this, 105, 65, this.textureX, this.textureY);
    this.leftBackWheelModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.leftBackWheelModel[11] = new ModelRendererTurbo((ModelBase)this, 25, 73, this.textureX, this.textureY);
    this.leftBackWheelModel[12] = new ModelRendererTurbo((ModelBase)this, 41, 73, this.textureX, this.textureY);
    this.leftBackWheelModel[0].addShapeBox(-6.0F, -5.5F, 0.0F, 12, 1, 1, 0.0F, -0.2F, 0.5F, -0.2F, -0.2F, -10.5F, -0.2F, -0.2F, -10.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 10.3F, -0.2F, -0.2F, 10.3F, -0.2F, -0.2F, -0.5F, -0.2F);
    this.leftBackWheelModel[0].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[1].addShapeBox(-0.5F, -7.0F, 0.0F, 1, 14, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.leftBackWheelModel[1].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[2].addShapeBox(-6.0F, -5.5F, 0.0F, 12, 1, 1, 0.0F, -0.2F, -10.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, -10.5F, -0.2F, -0.2F, 10.3F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 10.3F, -0.2F);
    this.leftBackWheelModel[2].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[3].addShapeBox(-8.0F, -0.5F, 0.0F, 16, 1, 1, 0.0F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F);
    this.leftBackWheelModel[3].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[4].addShapeBox(7.0F, -4.0F, 0.0F, 2, 8, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[4].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[5].addShapeBox(4.0F, -9.0F, 0.0F, 6, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -5.0F, 0.0F, -1.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -3.0F, 4.0F, 0.0F, -3.0F, 4.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[5].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[6].addShapeBox(-4.0F, -9.0F, 0.0F, 8, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[6].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[7].addShapeBox(-10.0F, -9.0F, 0.0F, 6, 2, 1, 0.0F, -1.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -5.0F, 0.0F, -3.0F, 4.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -3.0F, 4.0F, 0.0F);
    this.leftBackWheelModel[7].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[8].addShapeBox(-9.0F, -4.0F, 0.0F, 2, 8, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[8].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[9].addShapeBox(-10.0F, 7.0F, 0.0F, 6, 2, 1, 0.0F, -3.0F, 4.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -3.0F, 4.0F, 0.0F, -1.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -5.0F, 0.0F);
    this.leftBackWheelModel[9].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[10].addShapeBox(-4.0F, 7.0F, 0.0F, 8, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[10].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[11].addShapeBox(4.0F, 7.0F, 0.0F, 6, 2, 1, 0.0F, 1.0F, 0.0F, 0.0F, -3.0F, 4.0F, 0.0F, -3.0F, 4.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -5.0F, 0.0F, -1.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[11].func_78793_a(-2.5F, -0.5F, 9.0F);
    this.leftBackWheelModel[12].addShapeBox(-2.0F, -2.0F, 0.0F, 4, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[12].func_78793_a(-2.5F, -0.5F, 9.0F);
  }
  
  private void initrightBackWheelModel_1() {
    this.rightBackWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.rightBackWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 57, 33, this.textureX, this.textureY);
    this.rightBackWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 121, 17, this.textureX, this.textureY);
    this.rightBackWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.rightBackWheelModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.rightBackWheelModel[5] = new ModelRendererTurbo((ModelBase)this, 89, 33, this.textureX, this.textureY);
    this.rightBackWheelModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.rightBackWheelModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 41, this.textureX, this.textureY);
    this.rightBackWheelModel[8] = new ModelRendererTurbo((ModelBase)this, 89, 41, this.textureX, this.textureY);
    this.rightBackWheelModel[9] = new ModelRendererTurbo((ModelBase)this, 105, 41, this.textureX, this.textureY);
    this.rightBackWheelModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.rightBackWheelModel[11] = new ModelRendererTurbo((ModelBase)this, 57, 49, this.textureX, this.textureY);
    this.rightBackWheelModel[12] = new ModelRendererTurbo((ModelBase)this, 73, 57, this.textureX, this.textureY);
    this.rightBackWheelModel[0].addShapeBox(-2.0F, -2.0F, 0.0F, 4, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[0].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[1].addShapeBox(-4.0F, 7.0F, 0.0F, 8, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[1].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[2].addShapeBox(-9.0F, -4.0F, 0.0F, 2, 8, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[2].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[3].addShapeBox(7.0F, -4.0F, 0.0F, 2, 8, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[3].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[4].addShapeBox(-4.0F, -9.0F, 0.0F, 8, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[4].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[5].addShapeBox(4.0F, -9.0F, 0.0F, 6, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -5.0F, 0.0F, -1.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -3.0F, 4.0F, 0.0F, -3.0F, 4.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[5].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[6].addShapeBox(-10.0F, -9.0F, 0.0F, 6, 2, 1, 0.0F, -1.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -5.0F, 0.0F, -3.0F, 4.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -3.0F, 4.0F, 0.0F);
    this.rightBackWheelModel[6].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[7].addShapeBox(-10.0F, 7.0F, 0.0F, 6, 2, 1, 0.0F, -3.0F, 4.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -3.0F, 4.0F, 0.0F, -1.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -5.0F, 0.0F);
    this.rightBackWheelModel[7].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[8].addShapeBox(4.0F, 7.0F, 0.0F, 6, 2, 1, 0.0F, 1.0F, 0.0F, 0.0F, -3.0F, 4.0F, 0.0F, -3.0F, 4.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -5.0F, 0.0F, -1.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[8].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[9].addShapeBox(-0.5F, -7.0F, 0.0F, 1, 14, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.rightBackWheelModel[9].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[10].addShapeBox(-8.0F, -0.5F, 0.0F, 16, 1, 1, 0.0F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F);
    this.rightBackWheelModel[10].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[11].addShapeBox(-6.0F, -5.5F, 0.0F, 12, 1, 1, 0.0F, -0.2F, 0.5F, -0.2F, -0.2F, -10.5F, -0.2F, -0.2F, -10.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 10.3F, -0.2F, -0.2F, 10.3F, -0.2F, -0.2F, -0.5F, -0.2F);
    this.rightBackWheelModel[11].func_78793_a(-2.5F, -0.5F, -10.0F);
    this.rightBackWheelModel[12].addShapeBox(-6.0F, -5.5F, 0.0F, 12, 1, 1, 0.0F, -0.2F, -10.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, -10.5F, -0.2F, -0.2F, 10.3F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, -0.5F, -0.2F, -0.2F, 10.3F, -0.2F);
    this.rightBackWheelModel[12].func_78793_a(-2.5F, -0.5F, -10.0F);
  }
}
