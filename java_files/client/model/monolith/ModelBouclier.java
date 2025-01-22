package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelBouclier extends ModelVehicle {
  int textureX = 512;
  
  int textureY = 64;
  
  public ModelBouclier() {
    this.bodyModel = new ModelRendererTurbo[87];
    initbodyModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 145, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 257, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 313, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 321, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 329, 1, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 225, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 345, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 409, 1, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 457, 1, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 97, 25, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 145, 25, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 177, 25, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 233, 25, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 441, 1, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 257, 1, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 297, 1, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 401, 1, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 481, 1, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 329, 9, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 441, 9, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 497, 1, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[31] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[32] = new ModelRendererTurbo((ModelBase)this, 489, 9, this.textureX, this.textureY);
    this.bodyModel[33] = new ModelRendererTurbo((ModelBase)this, 329, 17, this.textureX, this.textureY);
    this.bodyModel[34] = new ModelRendererTurbo((ModelBase)this, 81, 25, this.textureX, this.textureY);
    this.bodyModel[35] = new ModelRendererTurbo((ModelBase)this, 137, 9, this.textureX, this.textureY);
    this.bodyModel[36] = new ModelRendererTurbo((ModelBase)this, 153, 1, this.textureX, this.textureY);
    this.bodyModel[37] = new ModelRendererTurbo((ModelBase)this, 353, 1, this.textureX, this.textureY);
    this.bodyModel[38] = new ModelRendererTurbo((ModelBase)this, 465, 1, this.textureX, this.textureY);
    this.bodyModel[39] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.bodyModel[40] = new ModelRendererTurbo((ModelBase)this, 153, 9, this.textureX, this.textureY);
    this.bodyModel[41] = new ModelRendererTurbo((ModelBase)this, 225, 9, this.textureX, this.textureY);
    this.bodyModel[42] = new ModelRendererTurbo((ModelBase)this, 233, 9, this.textureX, this.textureY);
    this.bodyModel[43] = new ModelRendererTurbo((ModelBase)this, 497, 9, this.textureX, this.textureY);
    this.bodyModel[44] = new ModelRendererTurbo((ModelBase)this, 497, 17, this.textureX, this.textureY);
    this.bodyModel[45] = new ModelRendererTurbo((ModelBase)this, 217, 25, this.textureX, this.textureY);
    this.bodyModel[46] = new ModelRendererTurbo((ModelBase)this, 273, 25, this.textureX, this.textureY);
    this.bodyModel[47] = new ModelRendererTurbo((ModelBase)this, 353, 9, this.textureX, this.textureY);
    this.bodyModel[48] = new ModelRendererTurbo((ModelBase)this, 257, 9, this.textureX, this.textureY);
    this.bodyModel[49] = new ModelRendererTurbo((ModelBase)this, 297, 9, this.textureX, this.textureY);
    this.bodyModel[50] = new ModelRendererTurbo((ModelBase)this, 401, 9, this.textureX, this.textureY);
    this.bodyModel[51] = new ModelRendererTurbo((ModelBase)this, 409, 9, this.textureX, this.textureY);
    this.bodyModel[52] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[53] = new ModelRendererTurbo((ModelBase)this, 345, 25, this.textureX, this.textureY);
    this.bodyModel[54] = new ModelRendererTurbo((ModelBase)this, 369, 25, this.textureX, this.textureY);
    this.bodyModel[55] = new ModelRendererTurbo((ModelBase)this, 393, 25, this.textureX, this.textureY);
    this.bodyModel[56] = new ModelRendererTurbo((ModelBase)this, 305, 17, this.textureX, this.textureY);
    this.bodyModel[57] = new ModelRendererTurbo((ModelBase)this, 137, 25, this.textureX, this.textureY);
    this.bodyModel[58] = new ModelRendererTurbo((ModelBase)this, 417, 25, this.textureX, this.textureY);
    this.bodyModel[59] = new ModelRendererTurbo((ModelBase)this, 441, 25, this.textureX, this.textureY);
    this.bodyModel[60] = new ModelRendererTurbo((ModelBase)this, 465, 25, this.textureX, this.textureY);
    this.bodyModel[61] = new ModelRendererTurbo((ModelBase)this, 177, 25, this.textureX, this.textureY);
    this.bodyModel[62] = new ModelRendererTurbo((ModelBase)this, 185, 25, this.textureX, this.textureY);
    this.bodyModel[63] = new ModelRendererTurbo((ModelBase)this, 297, 33, this.textureX, this.textureY);
    this.bodyModel[64] = new ModelRendererTurbo((ModelBase)this, 321, 33, this.textureX, this.textureY);
    this.bodyModel[65] = new ModelRendererTurbo((ModelBase)this, 481, 33, this.textureX, this.textureY);
    this.bodyModel[66] = new ModelRendererTurbo((ModelBase)this, 145, 41, this.textureX, this.textureY);
    this.bodyModel[67] = new ModelRendererTurbo((ModelBase)this, 97, 25, this.textureX, this.textureY);
    this.bodyModel[68] = new ModelRendererTurbo((ModelBase)this, 297, 25, this.textureX, this.textureY);
    this.bodyModel[69] = new ModelRendererTurbo((ModelBase)this, 465, 9, this.textureX, this.textureY);
    this.bodyModel[70] = new ModelRendererTurbo((ModelBase)this, 361, 25, this.textureX, this.textureY);
    this.bodyModel[71] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[72] = new ModelRendererTurbo((ModelBase)this, 481, 9, this.textureX, this.textureY);
    this.bodyModel[73] = new ModelRendererTurbo((ModelBase)this, 337, 41, this.textureX, this.textureY);
    this.bodyModel[74] = new ModelRendererTurbo((ModelBase)this, 393, 41, this.textureX, this.textureY);
    this.bodyModel[75] = new ModelRendererTurbo((ModelBase)this, 433, 41, this.textureX, this.textureY);
    this.bodyModel[76] = new ModelRendererTurbo((ModelBase)this, 169, 41, this.textureX, this.textureY);
    this.bodyModel[77] = new ModelRendererTurbo((ModelBase)this, 321, 25, this.textureX, this.textureY);
    this.bodyModel[78] = new ModelRendererTurbo((ModelBase)this, 369, 25, this.textureX, this.textureY);
    this.bodyModel[79] = new ModelRendererTurbo((ModelBase)this, 393, 25, this.textureX, this.textureY);
    this.bodyModel[80] = new ModelRendererTurbo((ModelBase)this, 305, 17, this.textureX, this.textureY);
    this.bodyModel[81] = new ModelRendererTurbo((ModelBase)this, 137, 25, this.textureX, this.textureY);
    this.bodyModel[82] = new ModelRendererTurbo((ModelBase)this, 417, 25, this.textureX, this.textureY);
    this.bodyModel[83] = new ModelRendererTurbo((ModelBase)this, 441, 25, this.textureX, this.textureY);
    this.bodyModel[84] = new ModelRendererTurbo((ModelBase)this, 465, 25, this.textureX, this.textureY);
    this.bodyModel[85] = new ModelRendererTurbo((ModelBase)this, 177, 25, this.textureX, this.textureY);
    this.bodyModel[86] = new ModelRendererTurbo((ModelBase)this, 185, 25, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 14, 0.0F, 35.0F, 0.2F, 0.0F, 34.0F, 0.0F, 0.0F, 34.0F, 0.0F, 0.0F, 35.0F, 0.2F, 0.0F, 35.0F, 0.5F, 0.0F, 34.0F, 0.5F, 0.0F, 34.0F, 0.5F, 0.0F, 35.0F, 0.5F, 0.0F);
    this.bodyModel[0].func_78793_a(-2.0F, 0.5F, -7.0F);
    this.bodyModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 41, 3, 14, 0.0F, -0.5F, -0.5F, 0.0F, 0.6F, -0.5F, -4.5F, 0.6F, -0.5F, -4.5F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, -1.0F, -4.5F, 0.5F, -1.0F, -4.5F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[1].func_78793_a(33.0F, -4.0F, -7.0F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 30, 4, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, -3.5F, 0.0F, 1.0F, -3.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[2].func_78793_a(33.0F, -1.0F, -7.0F);
    this.bodyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 3, 13, 4, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.bodyModel[3].func_78793_a(26.5F, -12.0F, -2.0F);
    this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 12, 4, 12, 0.0F, -1.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -4.0F, 0.0F, 0.0F, -5.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -5.0F);
    this.bodyModel[4].func_78793_a(-75.0F, 0.0F, -6.0F);
    this.bodyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 38, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.bodyModel[5].func_78793_a(31.0F, -37.0F, -0.5F);
    (this.bodyModel[5]).field_78808_h = 0.03490659F;
    this.bodyModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 22, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.bodyModel[6].func_78793_a(-43.0F, -21.0F, -0.5F);
    (this.bodyModel[6]).field_78808_h = 0.01745329F;
    this.bodyModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 6, 0.0F, -0.35F, -0.3F, -0.35F, -0.35F, -0.3F, -0.35F, -0.35F, -0.3F, -0.35F, -0.35F, -0.3F, -0.35F, -0.35F, -0.3F, -0.35F, -0.35F, -0.3F, -0.35F, -0.35F, -0.3F, -0.35F, -0.35F, -0.3F, -0.35F);
    this.bodyModel[7].func_78793_a(-43.0F, -20.0F, -3.0F);
    (this.bodyModel[7]).field_78808_h = -0.08726646F;
    this.bodyModel[8].addShapeBox(4.5F, -0.7F, -1.5F, 3, 1, 1, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.bodyModel[8].func_78793_a(-17.0F, -1.5F, 0.0F);
    this.bodyModel[9].addShapeBox(-5.5F, -0.7F, -1.5F, 10, 1, 1, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.bodyModel[9].func_78793_a(-17.0F, -1.5F, 0.0F);
    this.bodyModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[10].func_78793_a(-52.5F, -7.0F, -0.5F);
    this.bodyModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F);
    this.bodyModel[11].func_78793_a(-53.5F, -7.0F, -0.5F);
    this.bodyModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F);
    this.bodyModel[12].func_78793_a(-58.0F, -7.0F, -0.5F);
    this.bodyModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 17, 5, 14, 0.0F, 4.5F, 0.0F, -1.0F, 4.5F, 0.0F, 0.0F, 4.5F, 0.0F, 0.0F, 4.5F, 0.0F, -1.0F, 4.5F, -1.5F, -3.0F, -0.5F, 1.5F, -2.0F, -0.5F, 1.5F, -2.0F, 4.5F, -1.5F, -3.0F);
    this.bodyModel[13].func_78793_a(-58.5F, 3.0F, -7.0F);
    this.bodyModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 9, 5, 12, 0.0F, 2.0F, -1.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, -1.0F, -5.0F, -4.0F, -2.8F, -4.0F, 0.0F, -1.5F, -2.0F, 0.0F, -1.5F, -2.0F, -4.0F, -2.8F, -4.0F);
    this.bodyModel[14].func_78793_a(-72.0F, 3.0F, -6.0F);
    this.bodyModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 30, 5, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, -2.0F, 0.0F, 0.5F, -4.5F, 0.0F, 0.5F, -4.5F, 0.0F, 1.0F, -2.0F);
    this.bodyModel[15].func_78793_a(33.0F, 3.0F, -7.0F);
    this.bodyModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 14, 0.0F, 35.0F, 0.0F, 0.0F, 34.0F, 0.0F, 0.0F, 34.0F, 0.0F, 0.0F, 35.0F, 0.0F, 0.0F, 40.0F, 0.5F, -2.0F, 34.0F, 0.0F, -2.0F, 34.0F, 0.0F, -2.0F, 40.0F, 0.5F, -2.0F);
    this.bodyModel[16].func_78793_a(-2.0F, 3.0F, -7.0F);
    this.bodyModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 11, 6, 12, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -3.0F, 0.0F, -0.5F, -3.5F, -0.8F, -2.0F, -5.5F, -0.8F, -2.0F, -5.5F, 0.0F, -0.5F, -3.5F);
    this.bodyModel[17].func_78793_a(63.0F, 3.0F, -6.0F);
    this.bodyModel[18].addShapeBox(-8.5F, -1.5F, 0.0F, 12, 12, 1, 0.0F, -3.35F, -4.0F, -0.45F, -3.35F, -4.0F, -0.45F, -3.35F, -4.0F, -0.45F, -3.35F, -4.0F, -0.45F, -3.35F, -4.0F, -0.45F, -3.35F, -4.0F, -0.45F, -3.35F, -4.0F, -0.45F, -3.35F, -4.0F, -0.45F);
    this.bodyModel[18].func_78793_a(-74.8F, -10.0F, -0.5F);
    (this.bodyModel[18]).field_78808_h = 0.08726646F;
    this.bodyModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 10, 2, 14, 0.0F, 8.0F, 0.4F, -1.0F, 8.0F, 0.2F, 0.0F, 8.0F, 0.2F, 0.0F, 8.0F, 0.4F, -1.0F, 8.0F, 0.5F, -1.0F, 8.0F, 0.5F, 0.0F, 8.0F, 0.5F, 0.0F, 8.0F, 0.5F, -1.0F);
    this.bodyModel[19].func_78793_a(-55.0F, 0.5F, -7.0F);
    this.bodyModel[20].addShapeBox(0.0F, 0.0F, 0.0F, 11, 5, 12, 0.0F, 0.0F, 0.0F, -2.5F, 0.5F, 0.0F, -3.5F, 0.5F, 0.0F, -3.5F, 0.0F, 0.0F, -2.5F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -3.0F);
    this.bodyModel[20].func_78793_a(63.0F, -2.0F, -6.0F);
    this.bodyModel[21].addShapeBox(-5.5F, -0.7F, 0.5F, 10, 1, 1, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.bodyModel[21].func_78793_a(-17.0F, -1.5F, 0.0F);
    this.bodyModel[22].addShapeBox(4.5F, -0.7F, 0.5F, 3, 1, 1, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.bodyModel[22].func_78793_a(-17.0F, -1.5F, 0.0F);
    this.bodyModel[23].addShapeBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[23].func_78793_a(-18.5F, -1.0F, -0.5F);
    this.bodyModel[24].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F, -0.2F, 0.2F, 0.2F);
    this.bodyModel[24].func_78793_a(44.5F, -6.5F, -0.5F);
    this.bodyModel[25].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[25].func_78793_a(45.5F, -6.5F, -0.5F);
    this.bodyModel[26].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F);
    this.bodyModel[26].func_78793_a(47.0F, -6.5F, -0.5F);
    this.bodyModel[27].addShapeBox(-5.5F, -0.7F, -1.5F, 10, 1, 1, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.bodyModel[27].func_78793_a(-35.0F, -1.5F, 0.0F);
    this.bodyModel[28].addShapeBox(-5.5F, -0.7F, 0.5F, 10, 1, 1, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.bodyModel[28].func_78793_a(-35.0F, -1.5F, 0.0F);
    this.bodyModel[29].addShapeBox(4.5F, -0.7F, 0.5F, 3, 1, 1, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.bodyModel[29].func_78793_a(-35.0F, -1.5F, 0.0F);
    this.bodyModel[30].addShapeBox(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[30].func_78793_a(-36.5F, -1.0F, -0.5F);
    this.bodyModel[31].addShapeBox(4.5F, -0.7F, -1.5F, 3, 1, 1, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.bodyModel[31].func_78793_a(-35.0F, -1.5F, 0.0F);
    this.bodyModel[32].addShapeBox(-0.5F, -1.5F, 0.0F, 1, 16, 1, 0.0F, -0.4F, -4.0F, -0.4F, -0.4F, -4.0F, -0.4F, -0.4F, -4.0F, -0.4F, -0.4F, -4.0F, -0.4F, -0.4F, -4.0F, -0.4F, -0.4F, -4.0F, -0.4F, -0.4F, -4.0F, -0.4F, -0.4F, -4.0F, -0.4F);
    this.bodyModel[32].func_78793_a(-74.8F, -10.0F, -0.5F);
    (this.bodyModel[32]).field_78808_h = 0.12217305F;
    this.bodyModel[33].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[33].func_78793_a(36.0F, -6.5F, -2.5F);
    this.bodyModel[34].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 5, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, -1.5F, 0.0F, -0.35F, -1.5F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, -1.5F, 0.0F, -0.35F, -1.5F, 0.0F, -0.35F, 0.0F);
    this.bodyModel[34].func_78793_a(36.0F, -8.5F, -2.5F);
    this.bodyModel[35].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F);
    this.bodyModel[35].func_78793_a(33.2F, -12.5F, -1.0F);
    this.bodyModel[36].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.25F, 0.1F, -0.25F, -0.25F, 0.1F, -0.25F, -0.25F, 0.1F, -0.25F, -0.25F, 0.1F, -0.25F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F);
    this.bodyModel[36].func_78793_a(33.7F, -10.5F, -0.5F);
    this.bodyModel[37].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.bodyModel[37].func_78793_a(35.75F, -8.0F, -2.5F);
    this.bodyModel[38].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.bodyModel[38].func_78793_a(35.75F, -8.0F, 1.5F);
    this.bodyModel[39].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.bodyModel[39].func_78793_a(39.25F, -8.0F, 0.0F);
    this.bodyModel[40].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.bodyModel[40].func_78793_a(39.25F, -8.0F, -1.0F);
    this.bodyModel[41].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.bodyModel[41].func_78793_a(37.5F, -8.0F, -1.8F);
    this.bodyModel[42].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.bodyModel[42].func_78793_a(37.5F, -8.0F, 0.8F);
    this.bodyModel[43].addShapeBox(0.0F, 0.0F, 0.0F, 5, 5, 1, 0.0F, 0.5F, -0.5F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, -0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.5F, 0.0F);
    this.bodyModel[43].func_78793_a(-74.0F, 4.0F, -0.5F);
    (this.bodyModel[43]).field_78808_h = -0.12217305F;
    this.bodyModel[44].addShapeBox(0.0F, 0.0F, 0.0F, 3, 13, 4, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.bodyModel[44].func_78793_a(15.5F, -12.0F, -2.0F);
    this.bodyModel[45].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[45].func_78793_a(15.0F, -2.0F, -2.5F);
    this.bodyModel[46].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[46].func_78793_a(26.0F, -2.0F, -2.5F);
    this.bodyModel[47].addShapeBox(-0.8F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.bodyModel[47].func_78793_a(28.5F, -1.8F, 5.5F);
    this.bodyModel[48].addShapeBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F);
    this.bodyModel[48].func_78793_a(28.5F, -2.7F, 5.5F);
    (this.bodyModel[48]).field_78796_g = 0.7679449F;
    this.bodyModel[49].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.bodyModel[49].func_78793_a(28.5F, -2.7F, 5.5F);
    (this.bodyModel[49]).field_78796_g = 0.7679449F;
    this.bodyModel[50].addShapeBox(-0.8F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.bodyModel[50].func_78793_a(28.5F, -1.8F, -6.5F);
    this.bodyModel[51].addShapeBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F);
    this.bodyModel[51].func_78793_a(28.0F, -2.7F, -6.5F);
    (this.bodyModel[51]).field_78796_g = -0.7679449F;
    this.bodyModel[52].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.bodyModel[52].func_78793_a(28.0F, -2.7F, -6.5F);
    (this.bodyModel[52]).field_78796_g = -0.7679449F;
    this.bodyModel[53].addShapeBox(0.0F, 0.0F, 0.0F, 4, 3, 5, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.4F, -2.4F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, -2.4F, -2.4F);
    this.bodyModel[53].func_78793_a(9.0F, -5.0F, 2.0F);
    this.bodyModel[54].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.5F, -1.0F);
    this.bodyModel[54].func_78793_a(13.0F, -5.0F, 2.0F);
    this.bodyModel[55].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, -1.0F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, -1.5F, 0.0F, -0.3F, -1.0F);
    this.bodyModel[55].func_78793_a(19.0F, -5.0F, 2.0F);
    this.bodyModel[56].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[56].func_78793_a(11.0F, -6.0F, 5.8F);
    this.bodyModel[57].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[57].func_78793_a(23.0F, -6.0F, 5.8F);
    this.bodyModel[58].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, -1.0F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, -1.5F, 0.0F, -0.3F, -1.0F);
    this.bodyModel[58].func_78793_a(-1.0F, -5.0F, 2.0F);
    this.bodyModel[59].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.5F, -1.0F);
    this.bodyModel[59].func_78793_a(-7.0F, -5.0F, 2.0F);
    this.bodyModel[60].addShapeBox(0.0F, 0.0F, 0.0F, 4, 3, 5, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.4F, -2.4F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, -2.4F, -2.4F);
    this.bodyModel[60].func_78793_a(-11.0F, -5.0F, 2.0F);
    this.bodyModel[61].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[61].func_78793_a(3.0F, -6.0F, 5.8F);
    this.bodyModel[62].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[62].func_78793_a(-9.0F, -6.0F, 5.8F);
    this.bodyModel[63].addShapeBox(0.0F, 0.0F, 0.0F, 3, 13, 4, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.bodyModel[63].func_78793_a(4.5F, -12.0F, -2.0F);
    this.bodyModel[64].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[64].func_78793_a(4.0F, -2.0F, -2.5F);
    this.bodyModel[65].addShapeBox(0.0F, 0.0F, 0.0F, 3, 13, 4, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.bodyModel[65].func_78793_a(-6.5F, -12.0F, -2.0F);
    this.bodyModel[66].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[66].func_78793_a(-7.0F, -2.0F, -2.5F);
    this.bodyModel[67].addShapeBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F);
    this.bodyModel[67].func_78793_a(-50.5F, -2.7F, 5.5F);
    (this.bodyModel[67]).field_78796_g = 2.5132742F;
    this.bodyModel[68].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.bodyModel[68].func_78793_a(-50.5F, -2.7F, 5.5F);
    (this.bodyModel[68]).field_78796_g = 2.5132742F;
    this.bodyModel[69].addShapeBox(-0.8F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.bodyModel[69].func_78793_a(-50.5F, -1.8F, 5.5F);
    (this.bodyModel[69]).field_78796_g = 1.7453293F;
    this.bodyModel[70].addShapeBox(-2.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F, -0.2F, -0.1F, -0.1F);
    this.bodyModel[70].func_78793_a(-51.0F, -2.7F, -5.0F);
    (this.bodyModel[70]).field_78796_g = 3.9618974F;
    this.bodyModel[71].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.bodyModel[71].func_78793_a(-51.0F, -2.7F, -5.0F);
    (this.bodyModel[71]).field_78796_g = 3.9618974F;
    this.bodyModel[72].addShapeBox(-0.8F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.bodyModel[72].func_78793_a(-50.5F, -1.8F, -5.0F);
    (this.bodyModel[72]).field_78796_g = 1.7453293F;
    this.bodyModel[73].addShapeBox(0.0F, 0.0F, 0.0F, 16, 1, 9, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[73].func_78793_a(-57.5F, -4.5F, -4.5F);
    this.bodyModel[74].addShapeBox(0.0F, 0.0F, 0.0F, 12, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[74].func_78793_a(-56.5F, -3.5F, -2.5F);
    this.bodyModel[75].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 5, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, 0.0F, 0.0F, -0.35F, 0.0F);
    this.bodyModel[75].func_78793_a(32.0F, -8.5F, -2.5F);
    this.bodyModel[76].addShapeBox(0.0F, 0.0F, 0.0F, 2, 9, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[76].func_78793_a(32.8F, -8.0F, -1.5F);
    this.bodyModel[77].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.bodyModel[77].func_78793_a(73.5F, -10.0F, -0.5F);
    this.bodyModel[78].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.5F, -1.0F);
    this.bodyModel[78].func_78793_a(13.0F, -5.0F, -7.0F);
    this.bodyModel[79].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, -1.0F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, -1.5F, 0.0F, -0.3F, -1.0F);
    this.bodyModel[79].func_78793_a(19.0F, -5.0F, -7.0F);
    this.bodyModel[80].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[80].func_78793_a(11.0F, -6.0F, -6.8F);
    this.bodyModel[81].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[81].func_78793_a(23.0F, -6.0F, -6.8F);
    this.bodyModel[82].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, -1.0F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, -1.5F, 0.0F, -0.3F, -1.0F);
    this.bodyModel[82].func_78793_a(-1.0F, -5.0F, -7.0F);
    this.bodyModel[83].addShapeBox(0.0F, 0.0F, 0.0F, 6, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.5F, -1.0F);
    this.bodyModel[83].func_78793_a(-7.0F, -5.0F, -7.0F);
    this.bodyModel[84].addShapeBox(0.0F, 0.0F, 0.0F, 4, 3, 5, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.4F, -2.4F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, -2.4F, -2.4F);
    this.bodyModel[84].func_78793_a(-11.0F, -5.0F, -7.0F);
    this.bodyModel[85].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[85].func_78793_a(3.0F, -6.0F, -6.8F);
    this.bodyModel[86].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[86].func_78793_a(-9.0F, -6.0F, -6.8F);
  }
}
