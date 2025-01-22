package com.flansmod.client.model.ww2;

import com.flansmod.client.model.ModelPlane;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelYak9 extends ModelPlane {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelYak9() {
    this.noseModel = new ModelRendererTurbo[8];
    this.noseModel[0] = new ModelRendererTurbo((ModelBase)this, 35, 461, this.textureX, this.textureY);
    this.noseModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.noseModel[2] = new ModelRendererTurbo((ModelBase)this, 280, 440, this.textureX, this.textureY);
    this.noseModel[3] = new ModelRendererTurbo((ModelBase)this, 280, 400, this.textureX, this.textureY);
    this.noseModel[4] = new ModelRendererTurbo((ModelBase)this, 280, 350, this.textureX, this.textureY);
    this.noseModel[5] = new ModelRendererTurbo((ModelBase)this, 280, 350, this.textureX, this.textureY);
    this.noseModel[6] = new ModelRendererTurbo((ModelBase)this, 280, 380, this.textureX, this.textureY);
    this.noseModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 480, this.textureX, this.textureY);
    this.noseModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 14, 10, 12, 0.0F);
    this.noseModel[0].func_78793_a(-65.0F, -22.5F, -6.0F);
    this.noseModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 16, 12, 14, 0.0F);
    this.noseModel[1].func_78793_a(-52.0F, -22.5F, -7.0F);
    (this.noseModel[1]).field_78808_h = 0.05235988F;
    this.noseModel[2].func_78790_a(0.0F, -6.0F, 0.0F, 26, 7, 12, 0.0F);
    this.noseModel[2].func_78793_a(-61.0F, -13.0F, -6.0F);
    (this.noseModel[2]).field_78808_h = -0.2094395F;
    this.noseModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 18, 4, 8, 0.0F);
    this.noseModel[3].func_78793_a(-56.0F, -11.0F, -4.0F);
    this.noseModel[4].func_78790_a(0.0F, 0.0F, -1.5F, 20, 2, 3, 0.0F);
    this.noseModel[4].func_78793_a(-55.0F, -20.0F, 6.0F);
    (this.noseModel[4]).field_78796_g = 0.06981317F;
    this.noseModel[5].func_78790_a(0.0F, 0.0F, -1.5F, 20, 2, 3, 0.0F);
    this.noseModel[5].func_78793_a(-55.0F, -20.0F, -6.0F);
    (this.noseModel[5]).field_78796_g = -0.06981317F;
    this.noseModel[6].func_78790_a(0.0F, -0.5F, -0.5F, 10, 1, 1, 0.0F);
    this.noseModel[6].func_78793_a(-74.0F, -18.0F, 0.0F);
    this.noseModel[7].func_78790_a(-2.0F, -3.5F, -3.5F, 7, 7, 7, 0.0F);
    this.noseModel[7].func_78793_a(-70.0F, -18.0F, 0.0F);
    this.propellerModels = new ModelRendererTurbo[1][3];
    this.propellerModels[0][0] = new ModelRendererTurbo((ModelBase)this, 0, 450, this.textureX, this.textureY);
    this.propellerModels[0][1] = new ModelRendererTurbo((ModelBase)this, 0, 450, this.textureX, this.textureY);
    this.propellerModels[0][2] = new ModelRendererTurbo((ModelBase)this, 0, 450, this.textureX, this.textureY);
    this.propellerModels[0][0].func_78790_a(0.0F, 0.0F, -1.0F, 1, 21, 2, 0.0F);
    this.propellerModels[0][1].func_78790_a(0.0F, 0.0F, -1.0F, 1, 21, 2, 0.0F);
    this.propellerModels[0][2].func_78790_a(0.0F, 0.0F, -1.0F, 1, 21, 2, 0.0F);
    this.propellerModels[0][0].func_78793_a(-69.0F, -18.0F, 0.0F);
    this.propellerModels[0][1].func_78793_a(-69.0F, -18.0F, 0.0F);
    this.propellerModels[0][2].func_78793_a(-69.0F, -18.0F, 0.0F);
    this.bodyModel = new ModelRendererTurbo[24];
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 280, 470, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 450, 450, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 450, 415, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 440, 490, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 440, 490, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 420, 460, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 430, 490, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 430, 490, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 440, 490, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 440, 490, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 420, 480, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 420, 480, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 410, 445, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 410, 445, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 420, 460, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 450, 370, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 430, 340, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 460, 310, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 390, 500, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 410, 370, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 420, 390, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 460, 310, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 430, 420, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 80, 200, this.textureX, this.textureY);
    this.bodyModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 12, 17, 16, 0.0F);
    this.bodyModel[0].func_78793_a(-36.0F, -23.5F, -8.0F);
    this.bodyModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 18, 5, 10, 0.0F);
    this.bodyModel[1].func_78793_a(-22.0F, -7.0F, -5.0F);
    (this.bodyModel[1]).field_78808_h = 0.03490658F;
    this.bodyModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 12, 8, 12, 0.0F);
    this.bodyModel[2].func_78793_a(-35.0F, -22.0F, -6.0F);
    (this.bodyModel[2]).field_78808_h = 0.1745329F;
    this.bodyModel[3].func_78790_a(-0.5F, 0.0F, -0.5F, 1, 9, 1, 0.0F);
    this.bodyModel[3].func_78793_a(-18.5F, -29.0F, 3.8F);
    (this.bodyModel[3]).field_78795_f = 0.2443461F;
    this.bodyModel[4].func_78790_a(-0.5F, 0.0F, -0.5F, 1, 9, 1, 0.0F);
    this.bodyModel[4].func_78793_a(-18.5F, -29.0F, -3.8F);
    (this.bodyModel[4]).field_78795_f = -0.2443461F;
    this.bodyModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 8, 0.0F);
    this.bodyModel[5].func_78793_a(-18.0F, -29.3F, -4.0F);
    (this.bodyModel[5]).field_78808_h = -1.396263F;
    this.bodyModel[6].func_78790_a(-0.5F, 0.0F, -0.5F, 1, 10, 1, 0.0F);
    this.bodyModel[6].func_78793_a(-18.5F, -28.7F, 3.0F);
    (this.bodyModel[6]).field_78808_h = -0.9773844F;
    this.bodyModel[7].func_78790_a(-0.5F, 0.0F, -0.5F, 1, 10, 1, 0.0F);
    this.bodyModel[7].func_78793_a(-18.5F, -28.7F, -3.0F);
    (this.bodyModel[7]).field_78808_h = -0.9773844F;
    this.bodyModel[8].func_78790_a(-0.5F, 0.0F, -0.5F, 1, 9, 1, 0.0F);
    this.bodyModel[8].func_78793_a(-9.0F, -28.7F, -3.8F);
    (this.bodyModel[8]).field_78795_f = -0.2443461F;
    this.bodyModel[9].func_78790_a(-0.5F, 0.0F, -0.5F, 1, 9, 1, 0.0F);
    this.bodyModel[9].func_78793_a(-9.0F, -29.0F, 3.8F);
    (this.bodyModel[9]).field_78795_f = 0.2443461F;
    this.bodyModel[10].func_78790_a(-0.5F, -0.5F, -0.5F, 10, 1, 1, 0.0F);
    this.bodyModel[10].func_78793_a(-18.0F, -28.4F, -3.8F);
    (this.bodyModel[10]).field_78795_f = -0.6632251F;
    this.bodyModel[11].func_78790_a(-0.5F, -0.5F, -0.5F, 10, 1, 1, 0.0F);
    this.bodyModel[11].func_78793_a(-18.0F, -28.4F, 3.9F);
    (this.bodyModel[11]).field_78795_f = 0.6632251F;
    this.bodyModel[12].func_78790_a(-0.5F, -0.5F, -0.5F, 16, 1, 1, 0.0F);
    this.bodyModel[12].func_78793_a(-9.0F, -28.2F, -3.8F);
    (this.bodyModel[12]).field_78796_g = 0.1745329F;
    (this.bodyModel[12]).field_78808_h = -0.3839724F;
    this.bodyModel[13].func_78790_a(-0.5F, -0.5F, -0.5F, 22, 1, 1, 0.0F);
    this.bodyModel[13].func_78793_a(-9.0F, -28.2F, 3.8F);
    (this.bodyModel[13]).field_78796_g = -0.1745329F;
    (this.bodyModel[13]).field_78808_h = -0.3839724F;
    this.bodyModel[14].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 8, 0.0F);
    this.bodyModel[14].func_78793_a(-9.5F, -28.2F, -4.0F);
    (this.bodyModel[14]).field_78808_h = 1.396263F;
    this.bodyModel[15].func_78790_a(0.0F, 0.0F, 0.0F, 10, 17, 16, 0.0F);
    this.bodyModel[15].func_78793_a(-6.0F, -23.5F, -8.0F);
    this.bodyModel[16].func_78790_a(0.0F, 0.0F, 0.0F, 18, 1, 16, 0.0F);
    this.bodyModel[16].func_78793_a(-24.0F, -7.5F, -8.0F);
    this.bodyModel[17].func_78790_a(0.0F, 0.0F, 0.0F, 18, 17, 2, 0.0F);
    this.bodyModel[17].func_78793_a(-24.0F, -23.5F, 6.0F);
    this.bodyModel[18].func_78790_a(0.0F, 0.0F, -0.5F, 13, 1, 1, 0.0F);
    this.bodyModel[18].func_78793_a(-18.5F, -9.0F, 0.0F);
    this.bodyModel[19].func_78790_a(0.0F, 0.0F, 0.0F, 8, 2, 7, 0.0F);
    this.bodyModel[19].func_78793_a(-16.0F, -12.0F, -3.5F);
    this.bodyModel[20].func_78790_a(0.0F, 0.0F, 0.0F, 2, 10, 10, 0.0F);
    this.bodyModel[20].func_78793_a(-8.5F, -25.0F, -5.0F);
    (this.bodyModel[20]).field_78808_h = -0.06981317F;
    this.bodyModel[21].func_78790_a(0.0F, 0.0F, 0.0F, 18, 17, 2, 0.0F);
    this.bodyModel[21].func_78793_a(-24.0F, -23.5F, -8.0F);
    this.bodyModel[22].func_78790_a(0.0F, 0.0F, 0.0F, 1, 12, 1, 0.0F);
    this.bodyModel[22].func_78793_a(8.0F, -35.0F, -0.5F);
    this.bodyModel[23].func_78790_a(0.0F, 0.0F, 0.0F, 5, 5, 4, 0.0F);
    this.bodyModel[23].func_78793_a(-5.0F, -25.0F, -2.0F);
    this.bayModel = new ModelRendererTurbo[5];
    this.bayModel[0] = new ModelRendererTurbo((ModelBase)this, 300, 150, this.textureX, this.textureY);
    this.bayModel[1] = new ModelRendererTurbo((ModelBase)this, 300, 180, this.textureX, this.textureY);
    this.bayModel[2] = new ModelRendererTurbo((ModelBase)this, 300, 210, this.textureX, this.textureY);
    this.bayModel[3] = new ModelRendererTurbo((ModelBase)this, 340, 210, this.textureX, this.textureY);
    this.bayModel[4] = new ModelRendererTurbo((ModelBase)this, 425, 200, this.textureX, this.textureY);
    this.bayModel[0].func_78790_a(0.0F, 0.0F, -4.0F, 54, 13, 8, 0.0F);
    this.bayModel[0].func_78793_a(2.0F, -23.0F, -4.0F);
    (this.bayModel[0]).field_78796_g = 0.06981317F;
    this.bayModel[1].func_78790_a(0.0F, 0.0F, -4.0F, 54, 13, 8, 0.0F);
    this.bayModel[1].func_78793_a(2.0F, -23.0F, 4.0F);
    (this.bayModel[1]).field_78796_g = -0.06981317F;
    this.bayModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 12, 3, 6, 0.0F);
    this.bayModel[2].func_78793_a(3.0F, -23.5F, -3.0F);
    this.bayModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 48, 4, 8, 0.0F);
    this.bayModel[3].func_78793_a(3.5F, -10.4F, -4.0F);
    (this.bayModel[3]).field_78808_h = 0.07679449F;
    this.bayModel[4].func_78790_a(-3.0F, -1.0F, 0.0F, 12, 4, 1, 0.0F);
    this.bayModel[4].func_78793_a(46.0F, -9.0F, -0.5F);
    (this.bayModel[4]).field_78808_h = 0.1745329F;
    this.tailModel = new ModelRendererTurbo[8];
    this.tailModel[0] = new ModelRendererTurbo((ModelBase)this, 180, 235, this.textureX, this.textureY);
    this.tailModel[1] = new ModelRendererTurbo((ModelBase)this, 180, 250, this.textureX, this.textureY);
    this.tailModel[2] = new ModelRendererTurbo((ModelBase)this, 180, 265, this.textureX, this.textureY);
    this.tailModel[3] = new ModelRendererTurbo((ModelBase)this, 180, 300, this.textureX, this.textureY);
    this.tailModel[4] = new ModelRendererTurbo((ModelBase)this, 180, 340, this.textureX, this.textureY);
    this.tailModel[5] = new ModelRendererTurbo((ModelBase)this, 180, 300, this.textureX, this.textureY);
    this.tailModel[6] = new ModelRendererTurbo((ModelBase)this, 180, 340, this.textureX, this.textureY);
    this.tailModel[7] = new ModelRendererTurbo((ModelBase)this, 180, 375, this.textureX, this.textureY);
    this.tailModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 6, 4, 2, 0.0F);
    this.tailModel[0].func_78793_a(47.0F, -38.0F, -1.0F);
    this.tailModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 17, 4, 2, 0.0F);
    this.tailModel[1].func_78793_a(43.0F, -20.0F, -1.0F);
    (this.tailModel[1]).field_78808_h = 1.396263F;
    this.tailModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 9, 14, 2, 0.0F);
    this.tailModel[2].func_78793_a(47.0F, -34.0F, -1.0F);
    this.tailModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 5, 2, 24, 0.0F);
    this.tailModel[3].func_78793_a(38.0F, -21.0F, 5.0F);
    (this.tailModel[3]).field_78796_g = -0.3490658F;
    this.tailModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 7, 2, 24, 0.0F);
    this.tailModel[4].func_78793_a(46.0F, -21.0F, 4.0F);
    this.tailModel[5].func_78790_a(0.0F, 0.0F, -24.0F, 5, 2, 24, 0.0F);
    this.tailModel[5].func_78793_a(38.0F, -21.0F, -5.0F);
    (this.tailModel[5]).field_78796_g = 0.3490658F;
    this.tailModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 7, 2, 24, 0.0F);
    this.tailModel[6].func_78793_a(46.0F, -21.0F, -28.0F);
    this.tailModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 5, 2, 26, 0.0F);
    this.tailModel[7].func_78793_a(42.0F, -21.0F, -13.0F);
    this.leftWingModel = new ModelRendererTurbo[5];
    this.leftWingModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.leftWingModel[1] = new ModelRendererTurbo((ModelBase)this, 390, 0, this.textureX, this.textureY);
    this.leftWingModel[2] = new ModelRendererTurbo((ModelBase)this, 390, 20, this.textureX, this.textureY);
    this.leftWingModel[3] = new ModelRendererTurbo((ModelBase)this, 390, 80, this.textureX, this.textureY);
    this.leftWingModel[4] = new ModelRendererTurbo((ModelBase)this, 20, 80, this.textureX, this.textureY);
    this.leftWingModel[0].func_78790_a(0.0F, -1.0F, 0.0F, 20, 2, 68, 0.0F);
    this.leftWingModel[0].func_78793_a(-30.0F, -8.0F, 8.0F);
    (this.leftWingModel[0]).field_78795_f = 0.06981317F;
    (this.leftWingModel[0]).field_78796_g = -0.03490658F;
    this.leftWingModel[1].func_78790_a(20.0F, -1.0F, -4.0F, 10, 2, 10, 0.0F);
    this.leftWingModel[1].func_78793_a(-30.0F, -8.0F, 8.0F);
    (this.leftWingModel[1]).field_78795_f = 0.06981317F;
    (this.leftWingModel[1]).field_78796_g = 0.122173F;
    this.leftWingModel[2].func_78790_a(20.0F, -1.0F, 6.0F, 8, 2, 42, 0.0F);
    this.leftWingModel[2].func_78793_a(-30.0F, -8.0F, 8.0F);
    (this.leftWingModel[2]).field_78795_f = 0.06981317F;
    (this.leftWingModel[2]).field_78796_g = 0.122173F;
    this.leftWingModel[3].func_78790_a(20.0F, -1.0F, 48.0F, 10, 2, 16, 0.0F);
    this.leftWingModel[3].func_78793_a(-30.0F, -8.0F, 8.0F);
    (this.leftWingModel[3]).field_78795_f = 0.06981317F;
    (this.leftWingModel[3]).field_78796_g = 0.122173F;
    this.leftWingModel[4].func_78790_a(23.0F, -1.0F, 0.0F, 10, 2, 70, 0.0F);
    this.leftWingModel[4].func_78793_a(-60.0F, -7.6F, 8.0F);
    (this.leftWingModel[4]).field_78795_f = 0.06981317F;
    (this.leftWingModel[4]).field_78796_g = -0.1396263F;
    this.rightWingModel = new ModelRendererTurbo[5];
    this.rightWingModel[0] = new ModelRendererTurbo((ModelBase)this, 200, 0, this.textureX, this.textureY);
    this.rightWingModel[1] = new ModelRendererTurbo((ModelBase)this, 390, 0, this.textureX, this.textureY);
    this.rightWingModel[2] = new ModelRendererTurbo((ModelBase)this, 390, 20, this.textureX, this.textureY);
    this.rightWingModel[3] = new ModelRendererTurbo((ModelBase)this, 390, 80, this.textureX, this.textureY);
    this.rightWingModel[4] = new ModelRendererTurbo((ModelBase)this, 20, 80, this.textureX, this.textureY);
    this.rightWingModel[0].func_78790_a(0.0F, -1.0F, -68.0F, 20, 2, 68, 0.0F);
    this.rightWingModel[0].func_78793_a(-30.0F, -8.0F, -8.0F);
    (this.rightWingModel[0]).field_78795_f = -0.06981317F;
    (this.rightWingModel[0]).field_78796_g = 0.03490658F;
    this.rightWingModel[1].func_78790_a(20.0F, -1.0F, -6.0F, 10, 2, 10, 0.0F);
    this.rightWingModel[1].func_78793_a(-30.0F, -8.0F, -8.0F);
    (this.rightWingModel[1]).field_78795_f = -0.06981317F;
    (this.rightWingModel[1]).field_78796_g = -0.122173F;
    this.rightWingModel[2].func_78790_a(20.0F, -1.0F, -48.0F, 8, 2, 42, 0.0F);
    this.rightWingModel[2].func_78793_a(-30.0F, -8.0F, -8.0F);
    (this.rightWingModel[2]).field_78795_f = -0.06981317F;
    (this.rightWingModel[2]).field_78796_g = -0.122173F;
    this.rightWingModel[3].func_78790_a(20.0F, -1.0F, -64.0F, 10, 2, 16, 0.0F);
    this.rightWingModel[3].func_78793_a(-30.0F, -8.0F, -8.0F);
    (this.rightWingModel[3]).field_78795_f = -0.06981317F;
    (this.rightWingModel[3]).field_78796_g = -0.122173F;
    this.rightWingModel[4].func_78790_a(23.0F, -1.0F, -72.0F, 10, 2, 70, 0.0F);
    this.rightWingModel[4].func_78793_a(-60.0F, -7.6F, -8.0F);
    (this.rightWingModel[4]).field_78795_f = -0.06981317F;
    (this.rightWingModel[4]).field_78796_g = 0.1396263F;
    this.yawFlapModel = new ModelRendererTurbo[4];
    this.yawFlapModel[0] = new ModelRendererTurbo((ModelBase)this, 420, 420, this.textureX, this.textureY);
    this.yawFlapModel[1] = new ModelRendererTurbo((ModelBase)this, 410, 420, this.textureX, this.textureY);
    this.yawFlapModel[2] = new ModelRendererTurbo((ModelBase)this, 200, 480, this.textureX, this.textureY);
    this.yawFlapModel[3] = new ModelRendererTurbo((ModelBase)this, 200, 460, this.textureX, this.textureY);
    this.yawFlapModel[0].func_78790_a(-0.5F, -0.5F, -0.5F, 1, 11, 1, 0.0F);
    this.yawFlapModel[0].func_78793_a(-18.0F, -19.0F, 0.0F);
    this.yawFlapModel[1].func_78790_a(-1.0F, -0.5F, -0.5F, 1, 2, 1, 0.0F);
    this.yawFlapModel[1].func_78793_a(-18.0F, -19.0F, 0.0F);
    this.yawFlapModel[2].func_78790_a(0.0F, 0.0F, -1.0F, 8, 22, 2, 0.0F);
    this.yawFlapModel[2].func_78793_a(56.0F, -34.0F, 0.0F);
    this.yawFlapModel[3].func_78790_a(-3.0F, -4.0F, 0.0F, 9, 4, 2, 0.0F);
    this.yawFlapModel[3].func_78793_a(56.0F, -34.0F, -1.0F);
    this.pitchFlapLeftModel = new ModelRendererTurbo[3];
    this.pitchFlapLeftModel[0] = new ModelRendererTurbo((ModelBase)this, 400, 460, this.textureX, this.textureY);
    this.pitchFlapLeftModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 220, this.textureX, this.textureY);
    this.pitchFlapLeftModel[2] = new ModelRendererTurbo((ModelBase)this, 200, 430, this.textureX, this.textureY);
    this.pitchFlapLeftModel[0].func_78790_a(0.0F, 0.0F, -2.0F, 2, 1, 4, 0.0F);
    this.pitchFlapLeftModel[0].func_78793_a(-24.0F, -11.0F, -4.0F);
    (this.pitchFlapLeftModel[0]).field_78808_h = 0.1745329F;
    this.pitchFlapLeftModel[1].func_78790_a(0.0F, -1.0F, -21.0F, 2, 1, 42, 0.0F);
    this.pitchFlapLeftModel[1].func_78793_a(-5.5F, -9.5F, 38.0F);
    (this.pitchFlapLeftModel[1]).field_78795_f = 0.06981317F;
    (this.pitchFlapLeftModel[1]).field_78796_g = 0.122173F;
    this.pitchFlapLeftModel[2].func_78790_a(0.0F, -0.5F, 0.0F, 6, 1, 22, 0.0F);
    this.pitchFlapLeftModel[2].func_78793_a(53.0F, -20.0F, 5.0F);
    this.pitchFlapRightModel = new ModelRendererTurbo[3];
    this.pitchFlapRightModel[0] = new ModelRendererTurbo((ModelBase)this, 400, 460, this.textureX, this.textureY);
    this.pitchFlapRightModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 220, this.textureX, this.textureY);
    this.pitchFlapRightModel[2] = new ModelRendererTurbo((ModelBase)this, 200, 430, this.textureX, this.textureY);
    this.pitchFlapRightModel[0].func_78790_a(0.0F, 0.0F, -2.0F, 2, 1, 4, 0.0F);
    this.pitchFlapRightModel[0].func_78793_a(-24.0F, -11.0F, 4.0F);
    (this.pitchFlapRightModel[0]).field_78808_h = 0.1745329F;
    this.pitchFlapRightModel[1].func_78790_a(0.0F, -1.0F, -21.0F, 2, 1, 42, 0.0F);
    this.pitchFlapRightModel[1].func_78793_a(-5.5F, -9.5F, -38.0F);
    (this.pitchFlapRightModel[1]).field_78795_f = -0.06981317F;
    (this.pitchFlapRightModel[1]).field_78796_g = -0.122173F;
    this.pitchFlapRightModel[2].func_78790_a(0.0F, -0.5F, 0.0F, 6, 1, 22, 0.0F);
    this.pitchFlapRightModel[2].func_78793_a(53.0F, -20.0F, -27.0F);
    this.tailWheelModel = new ModelRendererTurbo[1];
    this.tailWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 300, this.textureX, this.textureY);
    this.tailWheelModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 4, 4, 2, 0.0F);
    this.tailWheelModel[0].func_78793_a(50.0F, -8.0F, -1.0F);
    this.leftWingWheelModel = new ModelRendererTurbo[2];
    this.leftWingWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 320, this.textureX, this.textureY);
    this.leftWingWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 345, this.textureX, this.textureY);
    this.leftWingWheelModel[0].func_78790_a(0.0F, 0.0F, -1.0F, 3, 12, 2, 0.0F);
    this.leftWingWheelModel[0].func_78793_a(-27.0F, -8.0F, 22.0F);
    (this.leftWingWheelModel[0]).field_78795_f = 0.03490658F;
    (this.leftWingWheelModel[0]).field_78808_h = -0.2617994F;
    this.leftWingWheelModel[1].func_78790_a(-3.0F, 0.0F, -1.5F, 6, 6, 3, 0.0F);
    this.leftWingWheelModel[1].func_78793_a(-28.5F, 4.0F, 22.5F);
    (this.leftWingWheelModel[1]).field_78795_f = 0.03490658F;
    (this.leftWingWheelModel[1]).field_78808_h = -0.03490658F;
    this.rightWingWheelModel = new ModelRendererTurbo[2];
    this.rightWingWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 320, this.textureX, this.textureY);
    this.rightWingWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 345, this.textureX, this.textureY);
    this.rightWingWheelModel[0].func_78790_a(0.0F, 0.0F, -1.0F, 3, 12, 2, 0.0F);
    this.rightWingWheelModel[0].func_78793_a(-27.0F, -8.0F, -22.0F);
    (this.rightWingWheelModel[0]).field_78795_f = -0.03490658F;
    (this.rightWingWheelModel[0]).field_78808_h = -0.2617994F;
    this.rightWingWheelModel[1].func_78790_a(-3.0F, 0.0F, -1.5F, 6, 6, 3, 0.0F);
    this.rightWingWheelModel[1].func_78793_a(-28.5F, 4.0F, -22.5F);
    (this.rightWingWheelModel[1]).field_78795_f = -0.03490658F;
    (this.rightWingWheelModel[1]).field_78808_h = -0.03490658F;
    translateAll(4, 10, 0);
    flipAll();
  }
  
  private ModelRendererTurbo[] makeProp(int i, int j, int k) {
    ModelRendererTurbo[] prop = new ModelRendererTurbo[0];
    return prop;
  }
}
