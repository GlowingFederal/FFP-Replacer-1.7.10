package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelFieldBombard extends ModelVehicle {
  int textureX = 256;
  
  int textureY = 128;
  
  public ModelFieldBombard() {
    this.bodyModel = new ModelRendererTurbo[14];
    this.barrelModel = new ModelRendererTurbo[13];
    this.leftBackWheelModel = new ModelRendererTurbo[6];
    this.rightBackWheelModel = new ModelRendererTurbo[6];
    initbodyModel_1();
    initbarrelModel_1();
    initleftBackWheelModel_1();
    initrightBackWheelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 121, 33, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 113, 33, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 153, 33, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 169, 33, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 185, 33, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 201, 33, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 217, 33, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 225, 73, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 74, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[0].func_78793_a(-55.5F, 5.5F, -13.5F);
    this.bodyModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 74, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[1].func_78793_a(-55.5F, 5.5F, 8.5F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 17, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[2].func_78793_a(-50.5F, 5.5F, -8.5F);
    this.bodyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 17, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[3].func_78793_a(12.5F, 5.5F, -8.5F);
    this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 5, 16, 3, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F);
    this.bodyModel[4].func_78793_a(-2.5F, -10.0F, -12.5F);
    this.bodyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 5, 16, 3, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F);
    this.bodyModel[5].func_78793_a(-2.5F, -10.0F, 9.5F);
    this.bodyModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 25, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F);
    this.bodyModel[6].func_78793_a(-40.5F, 5.5F, -12.5F);
    this.bodyModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 4, 18, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[7].func_78793_a(-2.5F, -4.0F, 9.5F);
    (this.bodyModel[7]).field_78808_h = 0.7853982F;
    this.bodyModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 4, 18, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[8].func_78793_a(-2.5F, -4.0F, -12.5F);
    (this.bodyModel[8]).field_78808_h = 0.7853982F;
    this.bodyModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 4, 18, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[9].func_78793_a(-0.5F, -7.0F, 9.5F);
    (this.bodyModel[9]).field_78808_h = -0.7853982F;
    this.bodyModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 4, 18, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[10].func_78793_a(-0.5F, -7.0F, -12.5F);
    (this.bodyModel[10]).field_78808_h = -0.7853982F;
    this.bodyModel[11].addShapeBox(-42.0F, -6.0F, -4.0F, 3, 8, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, -7.5F, 0.0F);
    (this.bodyModel[11]).field_78808_h = 0.29670596F;
    this.bodyModel[12].addShapeBox(-42.0F, -6.0F, -4.0F, 3, 8, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, -7.5F, 0.0F);
    (this.bodyModel[12]).field_78808_h = 0.10471976F;
    this.bodyModel[13].addShapeBox(-42.0F, -6.0F, -4.0F, 3, 8, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, -7.5F, 0.0F);
    (this.bodyModel[13]).field_78808_h = -0.08726646F;
  }
  
  private void initbarrelModel_1() {
    this.barrelModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.barrelModel[1] = new ModelRendererTurbo((ModelBase)this, 177, 57, this.textureX, this.textureY);
    this.barrelModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 65, this.textureX, this.textureY);
    this.barrelModel[3] = new ModelRendererTurbo((ModelBase)this, 121, 65, this.textureX, this.textureY);
    this.barrelModel[4] = new ModelRendererTurbo((ModelBase)this, 153, 73, this.textureX, this.textureY);
    this.barrelModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 81, this.textureX, this.textureY);
    this.barrelModel[6] = new ModelRendererTurbo((ModelBase)this, 73, 81, this.textureX, this.textureY);
    this.barrelModel[7] = new ModelRendererTurbo((ModelBase)this, 129, 89, this.textureX, this.textureY);
    this.barrelModel[8] = new ModelRendererTurbo((ModelBase)this, 153, 97, this.textureX, this.textureY);
    this.barrelModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 105, this.textureX, this.textureY);
    this.barrelModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 105, this.textureX, this.textureY);
    this.barrelModel[11] = new ModelRendererTurbo((ModelBase)this, 193, 97, this.textureX, this.textureY);
    this.barrelModel[12] = new ModelRendererTurbo((ModelBase)this, 201, 73, this.textureX, this.textureY);
    this.barrelModel[0].addShapeBox(-11.0F, -2.0F, 6.0F, 17, 6, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[0].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[1].addShapeBox(-46.0F, -2.0F, 5.0F, 35, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[1].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[2].addShapeBox(-46.0F, -2.0F, -9.0F, 35, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[2].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[3].addShapeBox(-11.0F, -2.0F, -9.0F, 17, 6, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 3.0F);
    this.barrelModel[3].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[4].addShapeBox(-10.0F, -5.0F, -6.0F, 20, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[4].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[5].addShapeBox(-10.0F, -9.0F, -6.0F, 20, 4, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[5].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[6].addShapeBox(-10.0F, -1.0F, -6.0F, 20, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F);
    this.barrelModel[6].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[7].addShapeBox(-45.0F, -1.5F, -6.0F, 2, 3, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[7].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[8].addShapeBox(-25.0F, -4.5F, -4.5F, 15, 3, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[8].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[9].addShapeBox(-25.0F, -1.5F, -4.5F, 15, 3, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F);
    this.barrelModel[9].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[10].addShapeBox(-25.0F, -7.5F, -4.5F, 15, 3, 9, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[10].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[11].addShapeBox(-29.0F, -4.0F, -8.0F, 4, 2, 16, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[11].func_78793_a(0.0F, -7.5F, 0.0F);
    this.barrelModel[12].addShapeBox(-41.2F, -0.5F, -9.5F, 1, 1, 19, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[12].func_78793_a(0.0F, -7.5F, 0.0F);
  }
  
  private void initleftBackWheelModel_1() {
    this.leftBackWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 161, 17, this.textureX, this.textureY);
    this.leftBackWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 193, 17, this.textureX, this.textureY);
    this.leftBackWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 225, 17, this.textureX, this.textureY);
    this.leftBackWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 161, 25, this.textureX, this.textureY);
    this.leftBackWheelModel[4] = new ModelRendererTurbo((ModelBase)this, 193, 25, this.textureX, this.textureY);
    this.leftBackWheelModel[5] = new ModelRendererTurbo((ModelBase)this, 225, 25, this.textureX, this.textureY);
    this.leftBackWheelModel[0].addShapeBox(-4.5F, 1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[0].func_78793_a(0.0F, 7.5F, 13.5F);
    this.leftBackWheelModel[1].addShapeBox(-4.5F, -1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[1].func_78793_a(0.0F, 7.5F, 13.5F);
    this.leftBackWheelModel[2].addShapeBox(-4.5F, -4.5F, 0.0F, 9, 3, 4, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[2].func_78793_a(0.0F, 7.5F, 13.5F);
    this.leftBackWheelModel[3].addShapeBox(-4.5F, -4.5F, 0.0F, 9, 3, 4, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[3].func_78793_a(-48.5F, 7.5F, 13.5F);
    this.leftBackWheelModel[4].addShapeBox(-4.5F, -1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[4].func_78793_a(-48.5F, 7.5F, 13.5F);
    this.leftBackWheelModel[5].addShapeBox(-4.5F, 1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[5].func_78793_a(-48.5F, 7.5F, 13.5F);
  }
  
  private void initrightBackWheelModel_1() {
    this.rightBackWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 161, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 193, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 225, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 161, 9, this.textureX, this.textureY);
    this.rightBackWheelModel[4] = new ModelRendererTurbo((ModelBase)this, 193, 9, this.textureX, this.textureY);
    this.rightBackWheelModel[5] = new ModelRendererTurbo((ModelBase)this, 225, 9, this.textureX, this.textureY);
    this.rightBackWheelModel[0].addShapeBox(-4.5F, -1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[0].func_78793_a(-48.5F, 7.5F, -17.5F);
    this.rightBackWheelModel[1].addShapeBox(-4.5F, 1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[1].func_78793_a(-48.5F, 7.5F, -17.5F);
    this.rightBackWheelModel[2].addShapeBox(-4.5F, -4.5F, 0.0F, 9, 3, 4, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[2].func_78793_a(-48.5F, 7.5F, -17.5F);
    this.rightBackWheelModel[3].addShapeBox(-4.5F, 1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[3].func_78793_a(0.0F, 7.5F, -17.5F);
    this.rightBackWheelModel[4].addShapeBox(-4.5F, -1.5F, 0.0F, 9, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[4].func_78793_a(0.0F, 7.5F, -17.5F);
    this.rightBackWheelModel[5].addShapeBox(-4.5F, -4.5F, 0.0F, 9, 3, 4, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[5].func_78793_a(0.0F, 7.5F, -17.5F);
  }
}
