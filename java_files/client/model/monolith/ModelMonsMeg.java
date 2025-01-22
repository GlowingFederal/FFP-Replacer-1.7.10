package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMonsMeg extends ModelVehicle {
  int textureX = 256;
  
  int textureY = 256;
  
  public ModelMonsMeg() {
    this.bodyModel = new ModelRendererTurbo[15];
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
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 161, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 209, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 161, 25, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 161, 49, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 121, 73, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 153, 97, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 121, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 169, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 97, 169, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 217, 81, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 217, 161, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 60, 5, 16, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F);
    this.bodyModel[0].func_78793_a(-22.0F, -11.0F, -8.0F);
    this.bodyModel[1].addShapeBox(0.0F, -5.0F, 0.0F, 60, 6, 16, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[1].func_78793_a(-22.0F, -12.0F, -8.0F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 60, 5, 16, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[2].func_78793_a(-22.0F, -22.0F, -8.0F);
    this.bodyModel[3].addShapeBox(0.0F, -5.0F, 0.0F, 46, 16, 26, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[3].func_78793_a(-24.0F, -4.0F, -13.0F);
    this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 16, 0.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[4].func_78793_a(38.0F, -22.5F, -8.0F);
    this.bodyModel[5].addShapeBox(0.0F, -5.0F, 0.0F, 6, 7, 17, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[5].func_78793_a(38.0F, -12.5F, -8.5F);
    this.bodyModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 16, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F);
    this.bodyModel[6].func_78793_a(38.0F, -10.5F, -8.0F);
    this.bodyModel[7].addShapeBox(0.0F, -5.0F, 0.0F, 24, 5, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[7].func_78793_a(-46.0F, -11.5F, -7.0F);
    this.bodyModel[8].addShapeBox(0.0F, -10.0F, 0.0F, 24, 5, 14, 0.0F, 0.0F, -0.5F, -4.0F, 0.0F, -0.5F, -4.0F, 0.0F, -0.5F, -4.0F, 0.0F, -0.5F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[8].func_78793_a(-46.0F, -11.5F, -7.0F);
    this.bodyModel[9].addShapeBox(0.0F, -10.0F, 0.0F, 24, 5, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -4.0F, 0.0F, -0.5F, -4.0F, 0.0F, -0.5F, -4.0F, 0.0F, -0.5F, -4.0F);
    this.bodyModel[9].func_78793_a(-46.0F, -1.5F, -7.0F);
    this.bodyModel[10].addShapeBox(0.0F, -5.0F, 0.0F, 14, 14, 26, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[10].func_78793_a(-38.0F, -2.0F, -13.0F);
    this.bodyModel[11].addShapeBox(-1.5F, -1.5F, 0.0F, 3, 3, 42, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[11].func_78793_a(16.0F, 3.0F, -21.0F);
    this.bodyModel[12].addShapeBox(-1.5F, -1.5F, 0.0F, 3, 3, 42, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[12].func_78793_a(-27.0F, 3.0F, -21.0F);
    this.bodyModel[13].addShapeBox(0.0F, -5.0F, 0.0F, 4, 16, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[13].func_78793_a(22.0F, -4.0F, -13.0F);
    this.bodyModel[14].addShapeBox(0.0F, -5.0F, 0.0F, 4, 16, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[14].func_78793_a(22.0F, -4.0F, 4.0F);
  }
  
  private void initleftBackWheelModel_1() {
    this.leftBackWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 209, 33, this.textureX, this.textureY);
    this.leftBackWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 185, 73, this.textureX, this.textureY);
    this.leftBackWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 57, 121, this.textureX, this.textureY);
    this.leftBackWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 105, 121, this.textureX, this.textureY);
    this.leftBackWheelModel[4] = new ModelRendererTurbo((ModelBase)this, 153, 121, this.textureX, this.textureY);
    this.leftBackWheelModel[5] = new ModelRendererTurbo((ModelBase)this, 201, 121, this.textureX, this.textureY);
    this.leftBackWheelModel[0].addShapeBox(-7.5F, -2.5F, 0.0F, 15, 5, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[0].func_78793_a(16.0F, 3.0F, 13.0F);
    this.leftBackWheelModel[1].addShapeBox(-7.5F, 2.5F, 0.0F, 15, 5, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[1].func_78793_a(16.0F, 3.0F, 13.0F);
    this.leftBackWheelModel[2].addShapeBox(-7.5F, -7.5F, 0.0F, 15, 5, 5, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[2].func_78793_a(16.0F, 3.0F, 13.0F);
    this.leftBackWheelModel[3].addShapeBox(-7.5F, 2.5F, 0.0F, 15, 5, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[3].func_78793_a(-27.0F, 3.0F, 13.0F);
    this.leftBackWheelModel[4].addShapeBox(-7.5F, -2.5F, 0.0F, 15, 5, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[4].func_78793_a(-27.0F, 3.0F, 13.0F);
    this.leftBackWheelModel[5].addShapeBox(-7.5F, -7.5F, 0.0F, 15, 5, 5, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[5].func_78793_a(-27.0F, 3.0F, 13.0F);
  }
  
  private void initrightBackWheelModel_1() {
    this.rightBackWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 89, 137, this.textureX, this.textureY);
    this.rightBackWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 137, 137, this.textureX, this.textureY);
    this.rightBackWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 185, 137, this.textureX, this.textureY);
    this.rightBackWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 89, 153, this.textureX, this.textureY);
    this.rightBackWheelModel[4] = new ModelRendererTurbo((ModelBase)this, 137, 153, this.textureX, this.textureY);
    this.rightBackWheelModel[5] = new ModelRendererTurbo((ModelBase)this, 185, 153, this.textureX, this.textureY);
    this.rightBackWheelModel[0].addShapeBox(-7.5F, -7.5F, 0.0F, 15, 5, 5, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[0].func_78793_a(-27.0F, 3.0F, -18.0F);
    this.rightBackWheelModel[1].addShapeBox(-7.5F, 2.5F, 0.0F, 15, 5, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[1].func_78793_a(-27.0F, 3.0F, -18.0F);
    this.rightBackWheelModel[2].addShapeBox(-7.5F, -2.5F, 0.0F, 15, 5, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[2].func_78793_a(-27.0F, 3.0F, -18.0F);
    this.rightBackWheelModel[3].addShapeBox(-7.5F, 2.5F, 0.0F, 15, 5, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[3].func_78793_a(16.0F, 3.0F, -18.0F);
    this.rightBackWheelModel[4].addShapeBox(-7.5F, -2.5F, 0.0F, 15, 5, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[4].func_78793_a(16.0F, 3.0F, -18.0F);
    this.rightBackWheelModel[5].addShapeBox(-7.5F, -7.5F, 0.0F, 15, 5, 5, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[5].func_78793_a(16.0F, 3.0F, -18.0F);
  }
}
