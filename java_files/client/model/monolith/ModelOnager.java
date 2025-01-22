package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelOnager extends ModelVehicle {
  int textureX = 256;
  
  int textureY = 128;
  
  public ModelOnager() {
    this.bodyModel = new ModelRendererTurbo[20];
    this.leftBackWheelModel = new ModelRendererTurbo[6];
    this.rightBackWheelModel = new ModelRendererTurbo[6];
    initbodyModel_1();
    initleftBackWheelModel_1();
    initrightBackWheelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 105, 33, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 169, 33, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 233, 25, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 145, 33, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 97, 65, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 233, 49, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 177, 65, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 193, 65, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 209, 65, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 1, 81, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 1, 89, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 233, 9, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 169, 33, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 9, 81, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 80, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[0].func_78793_a(-40.0F, 3.5F, -17.5F);
    this.bodyModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 80, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[1].func_78793_a(-40.0F, 3.5F, 12.5F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 25, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[2].func_78793_a(-40.0F, 3.5F, -12.5F);
    this.bodyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 25, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[3].func_78793_a(36.0F, 3.5F, -12.5F);
    this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 5, 20, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[4].func_78793_a(1.0F, -16.0F, -16.5F);
    this.bodyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 5, 20, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[5].func_78793_a(1.0F, -16.0F, 13.5F);
    this.bodyModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 5, 3, 33, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[6].func_78793_a(1.0F, -19.0F, -16.5F);
    this.bodyModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 35, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[7].func_78793_a(6.0F, -1.0F, -17.5F);
    this.bodyModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 33, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F);
    this.bodyModel[8].func_78793_a(-5.0F, 3.5F, -16.5F);
    this.bodyModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 4, 38, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[9].func_78793_a(1.0F, -10.0F, 13.5F);
    (this.bodyModel[9]).field_78808_h = 1.0995574F;
    this.bodyModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 4, 38, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[10].func_78793_a(1.0F, -10.0F, -16.5F);
    (this.bodyModel[10]).field_78808_h = 1.0995574F;
    this.bodyModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 4, 38, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[11].func_78793_a(4.0F, -13.0F, 13.5F);
    (this.bodyModel[11]).field_78808_h = -1.0995574F;
    this.bodyModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 4, 38, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[12].func_78793_a(4.0F, -13.0F, -16.5F);
    (this.bodyModel[12]).field_78808_h = -1.0995574F;
    this.bodyModel[13].addShapeBox(0.5F, 4.0F, 0.0F, 2, 35, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[13].func_78793_a(-20.0F, -30.0F, -1.5F);
    (this.bodyModel[13]).field_78808_h = 0.41887903F;
    this.bodyModel[14].addShapeBox(-1.5F, -6.0F, -2.0F, 4, 10, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[14].func_78793_a(-20.0F, -30.0F, -2.5F);
    (this.bodyModel[14]).field_78808_h = 0.41887903F;
    this.bodyModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 37, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[15].func_78793_a(6.0F, -16.0F, -18.5F);
    this.bodyModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 9, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[16].func_78793_a(1.0F, -16.0F, -24.5F);
    (this.bodyModel[16]).field_78796_g = 0.7330383F;
    this.bodyModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 9, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, -16.0F, 23.0F);
    (this.bodyModel[17]).field_78796_g = -0.7330383F;
    this.bodyModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 28, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[18].func_78793_a(-14.0F, -15.0F, 0.0F);
    (this.bodyModel[18]).field_78796_g = -1.0297443F;
    this.bodyModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 28, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[19].func_78793_a(-13.0F, -15.0F, -1.0F);
    (this.bodyModel[19]).field_78796_g = 1.0297443F;
  }
  
  private void initleftBackWheelModel_1() {
    this.leftBackWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 169, 25, this.textureX, this.textureY);
    this.leftBackWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 201, 25, this.textureX, this.textureY);
    this.leftBackWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.leftBackWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.leftBackWheelModel[4] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.leftBackWheelModel[5] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.leftBackWheelModel[0].addShapeBox(-4.5F, 1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[0].func_78793_a(24.0F, 5.5F, 17.5F);
    this.leftBackWheelModel[1].addShapeBox(-4.5F, -1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[1].func_78793_a(24.0F, 5.5F, 17.5F);
    this.leftBackWheelModel[2].addShapeBox(-4.5F, -4.5F, 0.0F, 9, 3, 4, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[2].func_78793_a(24.0F, 5.5F, 17.5F);
    this.leftBackWheelModel[3].addShapeBox(-4.5F, -4.5F, 0.0F, 9, 3, 4, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[3].func_78793_a(-24.0F, 5.5F, 17.5F);
    this.leftBackWheelModel[4].addShapeBox(-4.5F, -1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[4].func_78793_a(-24.0F, 5.5F, 17.5F);
    this.leftBackWheelModel[5].addShapeBox(-4.5F, 1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[5].func_78793_a(-24.0F, 5.5F, 17.5F);
  }
  
  private void initrightBackWheelModel_1() {
    this.rightBackWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 177, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 209, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 169, 9, this.textureX, this.textureY);
    this.rightBackWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 201, 9, this.textureX, this.textureY);
    this.rightBackWheelModel[4] = new ModelRendererTurbo((ModelBase)this, 177, 17, this.textureX, this.textureY);
    this.rightBackWheelModel[5] = new ModelRendererTurbo((ModelBase)this, 209, 17, this.textureX, this.textureY);
    this.rightBackWheelModel[0].addShapeBox(-4.5F, -1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[0].func_78793_a(-24.0F, 5.5F, -21.5F);
    this.rightBackWheelModel[1].addShapeBox(-4.5F, 1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[1].func_78793_a(-24.0F, 5.5F, -21.5F);
    this.rightBackWheelModel[2].addShapeBox(-4.5F, -4.5F, 0.0F, 9, 3, 4, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[2].func_78793_a(-24.0F, 5.5F, -21.5F);
    this.rightBackWheelModel[3].addShapeBox(-4.5F, 1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[3].func_78793_a(24.0F, 5.5F, -21.5F);
    this.rightBackWheelModel[4].addShapeBox(-4.5F, -1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[4].func_78793_a(24.0F, 5.5F, -21.5F);
    this.rightBackWheelModel[5].addShapeBox(-4.5F, -4.5F, 0.0F, 9, 3, 4, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[5].func_78793_a(24.0F, 5.5F, -21.5F);
  }
}
