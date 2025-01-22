package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSiegeTower extends ModelVehicle {
  int textureX = 1024;
  
  int textureY = 512;
  
  public ModelSiegeTower() {
    this.bodyModel = new ModelRendererTurbo[27];
    this.leftBackWheelModel = new ModelRendererTurbo[9];
    this.rightBackWheelModel = new ModelRendererTurbo[9];
    initbodyModel_1();
    initleftBackWheelModel_1();
    initrightBackWheelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 209, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 345, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 121, 73, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 801, 49, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 961, 41, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 881, 57, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 921, 57, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 497, 73, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 553, 73, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 625, 73, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 569, 153, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 1, 161, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 233, 161, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 593, 73, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 665, 73, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 721, 73, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 385, 177, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 1, 185, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 249, 185, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 905, 185, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 737, 225, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 313, 233, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 385, 257, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 505, 257, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 0.0F, -0.5F, 48, 100, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[0].func_78793_a(-8.0F, -104.0F, -35.0F);
    (this.bodyModel[0]).field_78795_f = -0.06981317F;
    this.bodyModel[1].addShapeBox(0.0F, 0.0F, -0.5F, 48, 100, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[1].func_78793_a(-8.0F, -104.0F, 35.0F);
    (this.bodyModel[1]).field_78795_f = 0.06981317F;
    this.bodyModel[2].addShapeBox(0.0F, 51.0F, -0.5F, 64, 50, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[2].func_78793_a(-72.01F, -105.0F, 35.0F);
    (this.bodyModel[2]).field_78795_f = 0.06981317F;
    this.bodyModel[3].addShapeBox(0.0F, 51.0F, -0.5F, 64, 50, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[3].func_78793_a(-72.01F, -105.0F, -35.0F);
    (this.bodyModel[3]).field_78795_f = -0.06981317F;
    this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 142, 3, 84, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[4].func_78793_a(-72.01F, -5.0F, -42.0F);
    this.bodyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 100, 70, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 6.0F, 0.0F, 0.0F, 6.0F);
    this.bodyModel[5].func_78793_a(39.0F, -104.0F, -35.0F);
    (this.bodyModel[5]).field_78808_h = 0.05235988F;
    this.bodyModel[6].addShapeBox(0.0F, 61.0F, -0.5F, 24, 40, 1, 0.0F, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[6].func_78793_a(41.99F, -105.0F, -35.0F);
    (this.bodyModel[6]).field_78795_f = -0.06981317F;
    this.bodyModel[7].addShapeBox(0.0F, 41.0F, -0.5F, 18, 20, 1, 0.0F, 2.0F, 0.0F, 0.0F, -17.0F, 0.0F, 0.0F, -17.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[7].func_78793_a(41.99F, -105.0F, -35.0F);
    (this.bodyModel[7]).field_78795_f = -0.06981317F;
    this.bodyModel[8].addShapeBox(0.0F, 41.0F, -0.5F, 18, 20, 1, 0.0F, 2.0F, 0.0F, 0.0F, -17.0F, 0.0F, 0.0F, -17.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[8].func_78793_a(41.99F, -105.0F, 35.0F);
    (this.bodyModel[8]).field_78795_f = 0.06981317F;
    this.bodyModel[9].addShapeBox(0.0F, 61.0F, -0.5F, 24, 40, 1, 0.0F, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[9].func_78793_a(41.99F, -105.0F, 35.0F);
    (this.bodyModel[9]).field_78795_f = 0.06981317F;
    this.bodyModel[10].addShapeBox(-0.5F, 0.0F, 0.0F, 1, 27, 76, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F);
    this.bodyModel[10].func_78793_a(42.5F, -64.0F, -38.0F);
    (this.bodyModel[10]).field_78808_h = 0.715585F;
    this.bodyModel[11].addShapeBox(-0.5F, 0.0F, 0.0F, 1, 40, 32, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[11].func_78793_a(60.0F, -44.0F, -39.0F);
    (this.bodyModel[11]).field_78808_h = 0.19198622F;
    this.bodyModel[12].addShapeBox(-0.5F, 0.0F, 0.0F, 1, 40, 32, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 3.0F);
    this.bodyModel[12].func_78793_a(60.0F, -44.0F, 7.0F);
    (this.bodyModel[12]).field_78808_h = 0.19198622F;
    this.bodyModel[13].addShapeBox(-35.0F, -2.0F, 0.0F, 100, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[13].func_78793_a(45.0F, -27.0F, -6.0F);
    this.bodyModel[14].addShapeBox(-35.0F, -6.0F, 0.0F, 100, 4, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[14].func_78793_a(45.0F, -27.0F, -6.0F);
    this.bodyModel[15].addShapeBox(-35.0F, 2.0F, 0.0F, 100, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F);
    this.bodyModel[15].func_78793_a(45.0F, -27.0F, -6.0F);
    this.bodyModel[16].addShapeBox(65.0F, -6.0F, 0.0F, 15, 4, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 2.0F, -4.0F, 0.0F, 2.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[16].func_78793_a(45.0F, -27.0F, -6.0F);
    this.bodyModel[17].addShapeBox(65.0F, -2.0F, 0.0F, 15, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[17].func_78793_a(45.0F, -27.0F, -6.0F);
    this.bodyModel[18].addShapeBox(65.0F, 2.0F, 0.0F, 15, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 2.0F, -4.0F, 0.0F, 2.0F, -4.0F, 0.0F, 0.0F, -4.0F);
    this.bodyModel[18].func_78793_a(45.0F, -27.0F, -6.0F);
    this.bodyModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 115, 1, 78, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[19].func_78793_a(-72.01F, -36.0F, -39.0F);
    this.bodyModel[20].addShapeBox(0.0F, 0.0F, 0.0F, 49, 1, 74, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[20].func_78793_a(-8.01F, -79.0F, -37.0F);
    this.bodyModel[21].addShapeBox(0.0F, 0.0F, 0.0F, 13, 50, 39, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[21].func_78793_a(10.0F, -130.0F, -19.5F);
    this.bodyModel[22].addShapeBox(0.0F, 0.0F, 0.0F, 13, 50, 39, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[22].func_78793_a(23.0F, -130.0F, -19.5F);
    this.bodyModel[23].addShapeBox(0.0F, 0.0F, 0.0F, 13, 50, 39, 0.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -13.0F);
    this.bodyModel[23].func_78793_a(-3.0F, -130.0F, -19.5F);
    this.bodyModel[24].addShapeBox(0.0F, 0.0F, 0.0F, 14, 15, 43, 0.0F, -4.0F, -4.0F, -16.0F, 0.0F, 0.0F, -14.0F, 0.0F, 0.0F, -14.0F, -4.0F, -4.0F, -16.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -13.0F);
    this.bodyModel[24].func_78793_a(-5.0F, -145.0F, -21.5F);
    this.bodyModel[25].addShapeBox(0.0F, 0.0F, 0.0F, 15, 15, 43, 0.0F, 0.0F, 0.0F, -14.0F, 0.0F, 0.0F, -14.0F, 0.0F, 0.0F, -14.0F, 0.0F, 0.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[25].func_78793_a(9.0F, -145.0F, -21.5F);
    this.bodyModel[26].addShapeBox(0.0F, 0.0F, 0.0F, 14, 15, 43, 0.0F, 0.0F, 0.0F, -14.0F, -4.0F, -4.0F, -16.0F, -4.0F, -4.0F, -16.0F, 0.0F, 0.0F, -14.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[26].func_78793_a(24.0F, -145.0F, -21.5F);
  }
  
  private void initleftBackWheelModel_1() {
    this.leftBackWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 641, 25, this.textureX, this.textureY);
    this.leftBackWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 721, 25, this.textureX, this.textureY);
    this.leftBackWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 801, 25, this.textureX, this.textureY);
    this.leftBackWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 881, 33, this.textureX, this.textureY);
    this.leftBackWheelModel[4] = new ModelRendererTurbo((ModelBase)this, 473, 49, this.textureX, this.textureY);
    this.leftBackWheelModel[5] = new ModelRendererTurbo((ModelBase)this, 553, 49, this.textureX, this.textureY);
    this.leftBackWheelModel[6] = new ModelRendererTurbo((ModelBase)this, 633, 49, this.textureX, this.textureY);
    this.leftBackWheelModel[7] = new ModelRendererTurbo((ModelBase)this, 713, 49, this.textureX, this.textureY);
    this.leftBackWheelModel[8] = new ModelRendererTurbo((ModelBase)this, 793, 49, this.textureX, this.textureY);
    this.leftBackWheelModel[0].addShapeBox(-13.5F, -13.5F, 0.0F, 27, 9, 9, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[0].func_78793_a(-4.01F, -4.0F, 30.0F);
    this.leftBackWheelModel[1].addShapeBox(-13.5F, 4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[1].func_78793_a(-4.01F, -4.0F, 30.0F);
    this.leftBackWheelModel[2].addShapeBox(-13.5F, -4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[2].func_78793_a(-4.01F, -4.0F, 30.0F);
    this.leftBackWheelModel[3].addShapeBox(-13.5F, 4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[3].func_78793_a(-55.01F, -4.0F, 30.0F);
    this.leftBackWheelModel[4].addShapeBox(-13.5F, -4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[4].func_78793_a(-55.01F, -4.0F, 30.0F);
    this.leftBackWheelModel[5].addShapeBox(-13.5F, -13.5F, 0.0F, 27, 9, 9, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[5].func_78793_a(-55.01F, -4.0F, 30.0F);
    this.leftBackWheelModel[6].addShapeBox(-13.5F, 4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[6].func_78793_a(45.99F, -4.0F, 30.0F);
    this.leftBackWheelModel[7].addShapeBox(-13.5F, -13.5F, 0.0F, 27, 9, 9, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[7].func_78793_a(45.99F, -4.0F, 30.0F);
    this.leftBackWheelModel[8].addShapeBox(-13.5F, -4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftBackWheelModel[8].func_78793_a(45.99F, -4.0F, 30.0F);
  }
  
  private void initrightBackWheelModel_1() {
    this.rightBackWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 481, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 561, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 641, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 721, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[4] = new ModelRendererTurbo((ModelBase)this, 801, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[5] = new ModelRendererTurbo((ModelBase)this, 881, 1, this.textureX, this.textureY);
    this.rightBackWheelModel[6] = new ModelRendererTurbo((ModelBase)this, 945, 17, this.textureX, this.textureY);
    this.rightBackWheelModel[7] = new ModelRendererTurbo((ModelBase)this, 481, 25, this.textureX, this.textureY);
    this.rightBackWheelModel[8] = new ModelRendererTurbo((ModelBase)this, 561, 25, this.textureX, this.textureY);
    this.rightBackWheelModel[0].addShapeBox(-13.5F, -4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[0].func_78793_a(-55.01F, -4.0F, -39.0F);
    this.rightBackWheelModel[1].addShapeBox(-13.5F, 4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[1].func_78793_a(-55.01F, -4.0F, -39.0F);
    this.rightBackWheelModel[2].addShapeBox(-13.5F, -13.5F, 0.0F, 27, 9, 9, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[2].func_78793_a(-55.01F, -4.0F, -39.0F);
    this.rightBackWheelModel[3].addShapeBox(-13.5F, 4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[3].func_78793_a(-4.01F, -4.0F, -39.0F);
    this.rightBackWheelModel[4].addShapeBox(-13.5F, -13.5F, 0.0F, 27, 9, 9, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[4].func_78793_a(-4.01F, -4.0F, -39.0F);
    this.rightBackWheelModel[5].addShapeBox(-13.5F, -4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[5].func_78793_a(-4.01F, -4.0F, -39.0F);
    this.rightBackWheelModel[6].addShapeBox(-13.5F, 4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[6].func_78793_a(45.99F, -4.0F, -39.0F);
    this.rightBackWheelModel[7].addShapeBox(-13.5F, -13.5F, 0.0F, 27, 9, 9, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[7].func_78793_a(45.99F, -4.0F, -39.0F);
    this.rightBackWheelModel[8].addShapeBox(-13.5F, -4.5F, 0.0F, 27, 9, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightBackWheelModel[8].func_78793_a(45.99F, -4.0F, -39.0F);
  }
}
