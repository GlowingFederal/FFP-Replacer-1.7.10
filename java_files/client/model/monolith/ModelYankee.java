package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelYankee extends ModelVehicle {
  int textureX = 512;
  
  int textureY = 256;
  
  public ModelYankee() {
    this.bodyModel = new ModelRendererTurbo[61];
    initbodyModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 153, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 305, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 161, 33, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 321, 33, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 97, 65, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 193, 65, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 289, 65, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 377, 65, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 97, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 441, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 441, 9, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 457, 17, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 441, 73, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 89, 97, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 161, 97, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 233, 97, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 297, 97, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 361, 97, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 289, 1, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 465, 25, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 1, 129, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 425, 105, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 473, 49, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 353, 65, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 489, 1, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 497, 25, this.textureX, this.textureY);
    this.bodyModel[31] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[32] = new ModelRendererTurbo((ModelBase)this, 145, 25, this.textureX, this.textureY);
    this.bodyModel[33] = new ModelRendererTurbo((ModelBase)this, 161, 1, this.textureX, this.textureY);
    this.bodyModel[34] = new ModelRendererTurbo((ModelBase)this, 449, 25, this.textureX, this.textureY);
    this.bodyModel[35] = new ModelRendererTurbo((ModelBase)this, 465, 41, this.textureX, this.textureY);
    this.bodyModel[36] = new ModelRendererTurbo((ModelBase)this, 161, 33, this.textureX, this.textureY);
    this.bodyModel[37] = new ModelRendererTurbo((ModelBase)this, 305, 33, this.textureX, this.textureY);
    this.bodyModel[38] = new ModelRendererTurbo((ModelBase)this, 145, 41, this.textureX, this.textureY);
    this.bodyModel[39] = new ModelRendererTurbo((ModelBase)this, 305, 41, this.textureX, this.textureY);
    this.bodyModel[40] = new ModelRendererTurbo((ModelBase)this, 81, 65, this.textureX, this.textureY);
    this.bodyModel[41] = new ModelRendererTurbo((ModelBase)this, 65, 97, this.textureX, this.textureY);
    this.bodyModel[42] = new ModelRendererTurbo((ModelBase)this, 177, 65, this.textureX, this.textureY);
    this.bodyModel[43] = new ModelRendererTurbo((ModelBase)this, 273, 65, this.textureX, this.textureY);
    this.bodyModel[44] = new ModelRendererTurbo((ModelBase)this, 441, 65, this.textureX, this.textureY);
    this.bodyModel[45] = new ModelRendererTurbo((ModelBase)this, 473, 65, this.textureX, this.textureY);
    this.bodyModel[46] = new ModelRendererTurbo((ModelBase)this, 137, 97, this.textureX, this.textureY);
    this.bodyModel[47] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.bodyModel[48] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.bodyModel[49] = new ModelRendererTurbo((ModelBase)this, 289, 1, this.textureX, this.textureY);
    this.bodyModel[50] = new ModelRendererTurbo((ModelBase)this, 313, 1, this.textureX, this.textureY);
    this.bodyModel[51] = new ModelRendererTurbo((ModelBase)this, 489, 1, this.textureX, this.textureY);
    this.bodyModel[52] = new ModelRendererTurbo((ModelBase)this, 505, 17, this.textureX, this.textureY);
    this.bodyModel[53] = new ModelRendererTurbo((ModelBase)this, 465, 25, this.textureX, this.textureY);
    this.bodyModel[54] = new ModelRendererTurbo((ModelBase)this, 313, 1, this.textureX, this.textureY);
    this.bodyModel[55] = new ModelRendererTurbo((ModelBase)this, 489, 1, this.textureX, this.textureY);
    this.bodyModel[56] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.bodyModel[57] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.bodyModel[58] = new ModelRendererTurbo((ModelBase)this, 289, 1, this.textureX, this.textureY);
    this.bodyModel[59] = new ModelRendererTurbo((ModelBase)this, 505, 17, this.textureX, this.textureY);
    this.bodyModel[60] = new ModelRendererTurbo((ModelBase)this, 465, 25, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 55, 7, 18, 0.0F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.bodyModel[0].func_78793_a(-35.0F, -6.0F, -9.0F);
    this.bodyModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 55, 6, 18, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.bodyModel[1].func_78793_a(-35.0F, 1.0F, -9.0F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 55, 6, 18, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -4.5F);
    this.bodyModel[2].func_78793_a(-35.0F, 7.0F, -9.0F);
    this.bodyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 60, 6, 18, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, 0.0F);
    this.bodyModel[3].func_78793_a(20.0F, 1.0F, -9.0F);
    this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 60, 7, 18, 0.0F, 0.0F, -0.5F, -4.5F, 0.0F, -1.0F, -4.5F, 0.0F, -1.0F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, 0.0F);
    this.bodyModel[4].func_78793_a(20.0F, -6.0F, -9.0F);
    this.bodyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 60, 6, 18, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -4.5F, 0.0F, -1.0F, -5.0F, 0.0F, -1.0F, -5.0F, 0.0F, -0.5F, -4.5F);
    this.bodyModel[5].func_78793_a(20.0F, 7.0F, -9.0F);
    this.bodyModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 28, 6, 18, 0.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -1.0F);
    this.bodyModel[6].func_78793_a(-63.0F, 1.0F, -9.0F);
    this.bodyModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 28, 6, 18, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -1.0F, -5.0F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, -1.0F, -5.0F);
    this.bodyModel[7].func_78793_a(-63.0F, 7.0F, -9.0F);
    this.bodyModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 28, 7, 18, 0.0F, 0.0F, -0.5F, -5.0F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -5.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -1.0F);
    this.bodyModel[8].func_78793_a(-63.0F, -6.0F, -9.0F);
    this.bodyModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 22, 6, 18, 0.0F, 0.0F, 0.5F, -4.5F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, 0.5F, -4.5F, 0.0F, -3.5F, -6.5F, 0.0F, -1.0F, -5.0F, 0.0F, -1.0F, -5.0F, 0.0F, -3.5F, -6.5F);
    this.bodyModel[9].func_78793_a(-85.0F, 7.0F, -9.0F);
    this.bodyModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 22, 6, 18, 0.0F, 0.0F, 0.0F, -4.5F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.0F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F, -0.5F, -4.5F);
    this.bodyModel[10].func_78793_a(-85.0F, 1.0F, -9.0F);
    this.bodyModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 22, 7, 18, 0.0F, 0.0F, -3.0F, -6.5F, 0.0F, -0.5F, -5.0F, 0.0F, -0.5F, -5.0F, 0.0F, -3.0F, -6.5F, 0.0F, 0.0F, -4.5F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, 0.0F, -4.5F);
    this.bodyModel[11].func_78793_a(-85.0F, -6.0F, -9.0F);
    this.bodyModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 19, 3, 3, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.5F, 3.0F, 0.0F, 1.5F, 3.0F, 0.0F, -1.0F, -1.0F);
    this.bodyModel[12].func_78793_a(-104.0F, 2.0F, -1.5F);
    this.bodyModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 19, 1, 3, 0.0F, -6.5F, -1.5F, -0.5F, 0.0F, 2.0F, 1.0F, 0.0F, 2.0F, 1.0F, -6.5F, -1.5F, -0.5F, 0.0F, 3.0F, -1.0F, 0.0F, 1.0F, 3.0F, 0.0F, 1.0F, 3.0F, 0.0F, 3.0F, -1.0F);
    this.bodyModel[13].func_78793_a(-104.0F, -1.0F, -1.5F);
    this.bodyModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 19, 1, 3, 0.0F, 0.0F, 3.0F, -1.0F, 0.0F, 0.5F, 3.0F, 0.0F, 0.5F, 3.0F, 0.0F, 3.0F, -1.0F, -6.5F, -1.5F, -0.5F, 0.0F, 1.5F, 1.0F, 0.0F, 1.5F, 1.0F, -6.5F, -1.5F, -0.5F);
    this.bodyModel[14].func_78793_a(-104.0F, 7.0F, -1.5F);
    this.bodyModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 14, 6, 18, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -2.0F, 0.0F, -0.5F, -2.0F, 0.0F, -0.5F, -1.0F, 0.0F, -1.0F, -5.0F, 0.0F, -1.0F, -5.5F, 0.0F, -1.0F, -5.5F, 0.0F, -1.0F, -5.0F);
    this.bodyModel[15].func_78793_a(80.0F, 7.0F, -9.0F);
    this.bodyModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 14, 6, 18, 0.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, -1.0F);
    this.bodyModel[16].func_78793_a(80.0F, 1.0F, -9.0F);
    this.bodyModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 14, 7, 18, 0.0F, 0.0F, -1.0F, -4.5F, 0.0F, -1.0F, -5.5F, 0.0F, -1.0F, -5.5F, 0.0F, -1.0F, -4.5F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -2.0F, 0.0F, -0.5F, -2.0F, 0.0F, -0.5F, -1.0F);
    this.bodyModel[17].func_78793_a(80.0F, -6.0F, -9.0F);
    this.bodyModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 11, 6, 18, 0.0F, 0.0F, -0.5F, -2.0F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -2.0F, 0.0F, -1.0F, -5.5F, 0.0F, -2.0F, -7.0F, 0.0F, -2.0F, -7.0F, 0.0F, -1.0F, -5.5F);
    this.bodyModel[18].func_78793_a(94.0F, 7.0F, -9.0F);
    this.bodyModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 11, 6, 18, 0.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, -4.5F, 0.0F, 0.5F, -4.5F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, -4.5F, 0.0F, 0.5F, -4.5F, 0.0F, 0.5F, -2.0F);
    this.bodyModel[19].func_78793_a(94.0F, 1.0F, -9.0F);
    this.bodyModel[20].addShapeBox(0.0F, 0.0F, 0.0F, 11, 7, 18, 0.0F, 0.0F, -1.0F, -5.5F, 0.0F, -2.0F, -6.5F, 0.0F, -2.0F, -6.5F, 0.0F, -1.0F, -5.5F, 0.0F, -0.5F, -2.0F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -4.5F, 0.0F, -0.5F, -2.0F);
    this.bodyModel[20].func_78793_a(94.0F, -6.0F, -9.0F);
    this.bodyModel[21].addShapeBox(0.0F, 0.0F, 0.0F, 4, 6, 8, 0.0F, 0.0F, 0.5F, 0.5F, 0.5F, 0.0F, -2.0F, 0.5F, 0.0F, -2.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.5F, -1.5F, -2.0F, 0.5F, -1.5F, -2.0F, 0.0F, 0.5F, 0.5F);
    this.bodyModel[21].func_78793_a(105.0F, 1.0F, -4.0F);
    this.bodyModel[22].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 8, 0.0F, 0.0F, 0.0F, -1.5F, -1.5F, -1.25F, -2.5F, -1.5F, -1.25F, -2.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.5F, 0.5F, 0.5F, 1.0F, -2.0F, 0.5F, 1.0F, -2.0F, 0.0F, 0.5F, 0.5F);
    this.bodyModel[22].func_78793_a(105.0F, -4.0F, -4.0F);
    this.bodyModel[23].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 8, 0.0F, 0.0F, -0.5F, 0.5F, 0.5F, 1.5F, -2.0F, 0.5F, 1.5F, -2.0F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, -2.0F, -1.5F, -1.75F, -3.0F, -1.5F, -1.75F, -3.0F, 0.0F, 0.0F, -2.0F);
    this.bodyModel[23].func_78793_a(105.0F, 7.0F, -4.0F);
    this.bodyModel[24].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 4, 0.0F, -0.25F, 0.0F, 0.0F, -0.5F, -1.0F, -1.5F, -0.5F, -1.0F, -1.5F, -0.25F, 0.0F, 0.0F, -0.25F, 0.5F, 0.0F, -0.5F, -0.5F, -1.5F, -0.5F, -0.5F, -1.5F, -0.25F, 0.5F, 0.0F);
    this.bodyModel[24].func_78793_a(109.25F, 1.0F, -2.0F);
    this.bodyModel[25].addShapeBox(0.0F, 0.0F, 0.0F, 45, 2, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.5F, 1.5F, 0.0F, 2.5F, 1.5F, 0.0F, 2.5F, 1.5F, 0.0F, 2.5F, 1.5F);
    this.bodyModel[25].func_78793_a(-3.0F, -6.75F, -5.0F);
    this.bodyModel[26].addShapeBox(0.0F, 0.0F, 0.0F, 15, 2, 10, 0.0F, 0.0F, -1.25F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.25F, -2.0F, 0.0F, 2.5F, 1.5F, 0.0F, 2.5F, 1.5F, 0.0F, 2.5F, 1.5F, 0.0F, 2.5F, 1.5F);
    this.bodyModel[26].func_78793_a(-18.0F, -6.75F, -5.0F);
    this.bodyModel[27].addShapeBox(0.0F, 0.0F, 0.0F, 8, 2, 10, 0.0F, 0.0F, 0.0F, 0.0F, -0.75F, -1.5F, -2.0F, -0.75F, -1.5F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.5F, 1.5F, 0.0F, 3.0F, 1.5F, 0.0F, 3.0F, 1.5F, 0.0F, 2.5F, 1.5F);
    this.bodyModel[27].func_78793_a(42.0F, -6.75F, -5.0F);
    this.bodyModel[28].addShapeBox(0.0F, 0.0F, 0.0F, 15, 9, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[28].func_78793_a(51.0F, -13.75F, -2.5F);
    this.bodyModel[29].addShapeBox(0.0F, 0.0F, 0.0F, 6, 9, 5, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F);
    this.bodyModel[29].func_78793_a(45.0F, -13.75F, -2.5F);
    this.bodyModel[30].addShapeBox(0.0F, 0.0F, 0.0F, 3, 9, 4, 0.0F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.75F);
    this.bodyModel[30].func_78793_a(42.0F, -13.75F, -2.0F);
    this.bodyModel[31].addShapeBox(0.0F, 0.0F, 0.0F, 3, 10, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[31].func_78793_a(66.0F, -13.75F, -2.5F);
    this.bodyModel[32].addShapeBox(0.0F, 0.0F, 0.0F, 1, 10, 3, 0.0F, 0.0F, 0.0F, -0.25F, -0.5F, 0.0F, -1.25F, -0.5F, 0.0F, -1.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, -0.5F, 0.0F, -1.25F, -0.5F, 0.0F, -1.25F, 0.0F, 0.0F, -0.25F);
    this.bodyModel[32].func_78793_a(69.0F, -13.75F, -1.5F);
    this.bodyModel[33].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, -0.5F, -0.75F, -0.75F, -0.5F, -1.25F, -0.75F, -0.5F, -1.25F, 0.0F, -0.5F, -0.75F, 0.0F, 0.0F, -0.25F, -0.5F, 0.0F, -1.25F, -0.5F, 0.0F, -1.25F, 0.0F, 0.0F, -0.25F);
    this.bodyModel[33].func_78793_a(69.0F, -14.75F, -1.5F);
    this.bodyModel[34].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 5, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -1.75F, 0.0F, -0.5F, -1.75F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[34].func_78793_a(66.0F, -14.75F, -2.5F);
    this.bodyModel[35].addShapeBox(0.0F, 0.0F, 0.0F, 15, 1, 5, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[35].func_78793_a(51.0F, -14.75F, -2.5F);
    this.bodyModel[36].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 4, 0.0F, -0.75F, -0.5F, -1.75F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, -0.75F, -0.5F, -1.75F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.75F);
    this.bodyModel[36].func_78793_a(42.0F, -14.75F, -2.0F);
    this.bodyModel[37].addShapeBox(0.0F, 0.0F, 0.0F, 6, 1, 5, 0.0F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -1.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F);
    this.bodyModel[37].func_78793_a(45.0F, -14.75F, -2.5F);
    this.bodyModel[38].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 8, 0.0F, -0.5F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.5F, -0.25F, 0.0F);
    this.bodyModel[38].func_78793_a(61.0F, -9.75F, -9.5F);
    this.bodyModel[39].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 8, 0.0F, 0.5F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, 0.5F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F);
    this.bodyModel[39].func_78793_a(61.0F, -9.75F, 1.5F);
    this.bodyModel[40].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 8, 0.0F, 0.0F, -0.3F, 0.0F, 4.5F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 4.5F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.bodyModel[40].func_78793_a(-99.0F, 3.25F, -4.0F);
    this.bodyModel[41].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 11, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 4.5F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 4.5F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F);
    this.bodyModel[41].func_78793_a(-92.0F, 3.25F, -13.5F);
    this.bodyModel[42].addShapeBox(0.0F, 0.0F, 0.0F, 9, 8, 1, 0.0F, 0.0F, 0.0F, -0.25F, -2.0F, 0.0F, -0.25F, -2.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.75F, 0.0F, -0.25F, 2.0F, 0.0F, -0.25F, 2.0F, 0.0F, -0.25F, 0.75F, 0.0F, -0.25F);
    this.bodyModel[42].func_78793_a(-98.0F, -6.5F, -0.5F);
    this.bodyModel[43].addShapeBox(0.0F, 0.0F, 0.0F, 9, 8, 1, 0.0F, 0.75F, 0.0F, -0.25F, 2.0F, 0.0F, -0.25F, 2.0F, 0.0F, -0.25F, 0.75F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, -1.75F, 0.0F, -0.25F, -1.75F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F);
    this.bodyModel[43].func_78793_a(-98.0F, 5.0F, -0.5F);
    this.bodyModel[44].addShapeBox(0.0F, 0.0F, 0.0F, 12, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[44].func_78793_a(-100.0F, 3.2F, -4.5F);
    this.bodyModel[45].addShapeBox(0.0F, 0.0F, 0.0F, 12, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[45].func_78793_a(-100.0F, 3.2F, 3.5F);
    this.bodyModel[46].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 11, 0.0F, 0.0F, -0.25F, 0.0F, 4.5F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 4.5F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F);
    this.bodyModel[46].func_78793_a(-92.0F, 3.25F, 2.5F);
    this.bodyModel[47].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[47].func_78793_a(-102.0F, 3.25F, -4.5F);
    this.bodyModel[48].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[48].func_78793_a(-101.0F, 3.75F, -4.0F);
    this.bodyModel[49].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[49].func_78793_a(-101.0F, 3.75F, -4.0F);
    (this.bodyModel[49]).field_78795_f = 1.0471976F;
    this.bodyModel[50].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[50].func_78793_a(-101.0F, 3.75F, -4.0F);
    (this.bodyModel[50]).field_78795_f = 2.0943952F;
    this.bodyModel[51].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[51].func_78793_a(-101.0F, 3.75F, -4.0F);
    (this.bodyModel[51]).field_78795_f = 3.1415927F;
    this.bodyModel[52].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[52].func_78793_a(-101.0F, 3.75F, -4.0F);
    (this.bodyModel[52]).field_78795_f = 4.1887903F;
    this.bodyModel[53].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[53].func_78793_a(-101.0F, 3.75F, -4.0F);
    (this.bodyModel[53]).field_78795_f = 5.2359877F;
    this.bodyModel[54].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.4F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[54].func_78793_a(-101.0F, 3.75F, 4.0F);
    (this.bodyModel[54]).field_78795_f = 2.0943952F;
    this.bodyModel[55].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.4F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[55].func_78793_a(-101.0F, 3.75F, 4.0F);
    (this.bodyModel[55]).field_78795_f = 3.1415927F;
    this.bodyModel[56].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[56].func_78793_a(-102.0F, 3.25F, 3.5F);
    this.bodyModel[57].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.4F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[57].func_78793_a(-101.0F, 3.75F, 4.0F);
    this.bodyModel[58].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.4F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[58].func_78793_a(-101.0F, 3.75F, 4.0F);
    (this.bodyModel[58]).field_78795_f = 1.0471976F;
    this.bodyModel[59].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.4F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[59].func_78793_a(-101.0F, 3.75F, 4.0F);
    (this.bodyModel[59]).field_78795_f = 4.1887903F;
    this.bodyModel[60].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.4F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[60].func_78793_a(-101.0F, 3.75F, 4.0F);
    (this.bodyModel[60]).field_78795_f = 5.2359877F;
  }
}
