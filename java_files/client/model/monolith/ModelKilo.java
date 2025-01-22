package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelKilo extends ModelVehicle {
  int textureX = 512;
  
  int textureY = 64;
  
  public ModelKilo() {
    this.bodyModel = new ModelRendererTurbo[44];
    initbodyModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 129, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 257, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 385, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 441, 9, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 113, 25, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 169, 25, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 225, 25, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 337, 25, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 401, 25, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 369, 1, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 441, 1, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 433, 33, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 465, 33, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 73, 41, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 265, 1, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 369, 1, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 81, 41, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 137, 41, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 193, 41, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 233, 41, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 121, 41, this.textureX, this.textureY);
    this.bodyModel[31] = new ModelRendererTurbo((ModelBase)this, 257, 41, this.textureX, this.textureY);
    this.bodyModel[32] = new ModelRendererTurbo((ModelBase)this, 297, 41, this.textureX, this.textureY);
    this.bodyModel[33] = new ModelRendererTurbo((ModelBase)this, 337, 41, this.textureX, this.textureY);
    this.bodyModel[34] = new ModelRendererTurbo((ModelBase)this, 377, 41, this.textureX, this.textureY);
    this.bodyModel[35] = new ModelRendererTurbo((ModelBase)this, 1, 48, this.textureX, this.textureY);
    this.bodyModel[36] = new ModelRendererTurbo((ModelBase)this, 41, 49, this.textureX, this.textureY);
    this.bodyModel[37] = new ModelRendererTurbo((ModelBase)this, 481, 33, this.textureX, this.textureY);
    this.bodyModel[38] = new ModelRendererTurbo((ModelBase)this, 401, 48, this.textureX, this.textureY);
    this.bodyModel[39] = new ModelRendererTurbo((ModelBase)this, 433, 49, this.textureX, this.textureY);
    this.bodyModel[40] = new ModelRendererTurbo((ModelBase)this, 177, 41, this.textureX, this.textureY);
    this.bodyModel[41] = new ModelRendererTurbo((ModelBase)this, 281, 41, this.textureX, this.textureY);
    this.bodyModel[42] = new ModelRendererTurbo((ModelBase)this, 321, 41, this.textureX, this.textureY);
    this.bodyModel[43] = new ModelRendererTurbo((ModelBase)this, 497, 1, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 46, 5, 14, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[0].func_78793_a(-9.0F, -1.0F, -7.0F);
    this.bodyModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 46, 4, 14, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[1].func_78793_a(-9.0F, 4.0F, -7.0F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 46, 4, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -5.0F);
    this.bodyModel[2].func_78793_a(-9.0F, 8.0F, -7.0F);
    this.bodyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 20, 4, 14, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -2.0F, -5.5F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, -2.0F, -5.5F);
    this.bodyModel[3].func_78793_a(-29.0F, 8.0F, -7.0F);
    this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 20, 4, 14, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
    this.bodyModel[4].func_78793_a(-29.0F, 4.0F, -7.0F);
    this.bodyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 20, 5, 14, 0.0F, 0.0F, -1.0F, -3.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, -1.0F, -3.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.5F);
    this.bodyModel[5].func_78793_a(-29.0F, -1.0F, -7.0F);
    this.bodyModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 20, 3, 6, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 2.5F, 0.0F, 0.0F, 2.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 2.0F, 0.0F, 1.0F, 2.0F, 0.0F, 0.0F, -1.0F);
    this.bodyModel[6].func_78793_a(-49.0F, 4.0F, -3.0F);
    this.bodyModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 20, 2, 6, 0.0F, 0.0F, -0.5F, -2.0F, 0.0F, 2.0F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, -0.5F, -2.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 2.5F, 0.0F, 0.0F, 2.5F, 0.0F, 0.0F, -0.5F);
    this.bodyModel[7].func_78793_a(-49.0F, 2.0F, -3.0F);
    this.bodyModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 20, 2, 6, 0.0F, 0.0F, 1.0F, -1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 1.0F, -1.0F, 0.0F, -2.5F, -2.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, -2.5F, -2.0F);
    this.bodyModel[8].func_78793_a(-49.0F, 8.0F, -3.0F);
    this.bodyModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 46, 2, 8, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[9].func_78793_a(-9.0F, -3.0F, -4.0F);
    this.bodyModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 20, 2, 8, 0.0F, 0.0F, -0.5F, -2.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, -0.5F, -2.5F, 0.0F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, -1.0F);
    this.bodyModel[10].func_78793_a(-29.0F, -3.0F, -4.0F);
    this.bodyModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 13, 2, 6, 0.0F, 0.0F, -2.5F, -2.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, -2.5F, -2.0F, 0.0F, 2.5F, -1.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 2.5F, -1.5F);
    this.bodyModel[11].func_78793_a(-42.0F, -2.5F, -3.0F);
    this.bodyModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 6, 2, 6, 0.0F, 0.0F, -5.0F, -2.5F, 0.0F, -2.5F, -2.0F, 0.0F, -2.5F, -2.0F, 0.0F, -5.0F, -2.5F, 0.0F, 3.5F, -2.5F, 0.0F, 2.5F, -1.5F, 0.0F, 2.5F, -1.5F, 0.0F, 3.5F, -2.5F);
    this.bodyModel[12].func_78793_a(-48.0F, -2.5F, -3.0F);
    this.bodyModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 9, 1, 5, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 1.0F, -0.5F, 0.0F, 1.0F, -0.5F, 0.0F, 0.0F, -2.0F);
    this.bodyModel[13].func_78793_a(-58.0F, 5.0F, -2.5F);
    this.bodyModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 9, 1, 5, 0.0F, -0.5F, -2.75F, -2.25F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, -0.5F, -2.75F, -2.25F, 0.0F, 2.0F, -2.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 2.0F, -2.0F);
    this.bodyModel[14].func_78793_a(-58.0F, 2.0F, -2.5F);
    this.bodyModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 9, 1, 5, 0.0F, 0.0F, 2.0F, -2.0F, 0.0F, 1.0F, -0.5F, 0.0F, 1.0F, -0.5F, 0.0F, 2.0F, -2.0F, -0.5F, -2.75F, -2.25F, 0.0F, -1.5F, -1.5F, 0.0F, -1.5F, -1.5F, -0.5F, -2.75F, -2.25F);
    this.bodyModel[15].func_78793_a(-58.0F, 8.0F, -2.5F);
    this.bodyModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F);
    this.bodyModel[16].func_78793_a(-54.0F, 5.0F, -10.5F);
    this.bodyModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 8, 0.0F, 2.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[17].func_78793_a(-54.0F, 5.0F, 2.5F);
    this.bodyModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 8, 7, 1, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[18].func_78793_a(-56.0F, 6.0F, -0.5F);
    this.bodyModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[19].func_78793_a(-60.0F, 5.0F, -0.5F);
    this.bodyModel[20].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[20].func_78793_a(-59.0F, 5.5F, 0.0F);
    this.bodyModel[21].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[21].func_78793_a(-59.0F, 5.5F, 0.0F);
    (this.bodyModel[21]).field_78795_f = 1.0471976F;
    this.bodyModel[22].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[22].func_78793_a(-59.0F, 5.5F, 0.0F);
    (this.bodyModel[22]).field_78795_f = 2.0943952F;
    this.bodyModel[23].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[23].func_78793_a(-59.0F, 5.5F, 0.0F);
    (this.bodyModel[23]).field_78795_f = 3.1415927F;
    this.bodyModel[24].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[24].func_78793_a(-59.0F, 5.5F, 0.0F);
    (this.bodyModel[24]).field_78795_f = 4.1887903F;
    this.bodyModel[25].addShapeBox(0.0F, -0.5F, -0.5F, 1, 3, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.2F, 0.2F, -0.4F, -0.2F, 0.2F);
    this.bodyModel[25].func_78793_a(-59.0F, 5.5F, 0.0F);
    (this.bodyModel[25]).field_78795_f = 5.2359877F;
    this.bodyModel[26].addShapeBox(0.0F, 0.0F, 0.0F, 11, 5, 14, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.5F, -3.5F, 0.0F, 0.5F, -3.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F);
    this.bodyModel[26].func_78793_a(37.0F, -1.0F, -7.0F);
    this.bodyModel[27].addShapeBox(0.0F, 0.0F, 0.0F, 11, 4, 14, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[27].func_78793_a(37.0F, 4.0F, -7.0F);
    this.bodyModel[28].addShapeBox(0.0F, 0.0F, 0.0F, 11, 4, 14, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, -3.5F);
    this.bodyModel[28].func_78793_a(37.0F, 8.0F, -7.0F);
    this.bodyModel[29].addShapeBox(0.0F, 0.0F, 0.0F, 8, 2, 8, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.25F, -2.5F, 0.0F, -0.25F, -2.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[29].func_78793_a(37.0F, -3.0F, -4.0F);
    this.bodyModel[30].addShapeBox(0.0F, 0.0F, 0.0F, 3, 2, 8, 0.0F, 0.0F, -0.25F, -2.5F, 0.0F, -1.5F, -3.5F, 0.0F, -1.5F, -3.5F, 0.0F, -0.25F, -2.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, -1.5F);
    this.bodyModel[30].func_78793_a(45.0F, -3.0F, -4.0F);
    this.bodyModel[31].addShapeBox(0.0F, 0.0F, 0.0F, 4, 5, 14, 0.0F, 0.0F, 0.5F, -3.5F, 0.0F, -0.5F, -4.0F, 0.0F, -0.5F, -4.0F, 0.0F, 0.5F, -3.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[31].func_78793_a(48.0F, -1.0F, -7.0F);
    this.bodyModel[32].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 14, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[32].func_78793_a(48.0F, 4.0F, -7.0F);
    this.bodyModel[33].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, -1.0F, -5.0F, 0.0F, -1.0F, -5.0F, 0.0F, 0.0F, -5.0F);
    this.bodyModel[33].func_78793_a(48.0F, 8.0F, -7.0F);
    this.bodyModel[34].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -2.5F, 0.0F, -0.5F, -2.5F, 0.0F, 0.0F, -0.5F);
    this.bodyModel[34].func_78793_a(52.0F, 4.0F, -6.0F);
    this.bodyModel[35].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 12, 0.0F, 0.0F, 0.5F, -3.0F, 0.0F, -1.0F, -4.5F, 0.0F, -1.0F, -4.5F, 0.0F, 0.5F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[35].func_78793_a(52.0F, 0.0F, -6.0F);
    this.bodyModel[36].addShapeBox(0.0F, 0.0F, 0.0F, 4, 3, 12, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.5F, -2.5F, 0.0F, 0.5F, -2.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -4.0F, 0.0F, -2.0F, -4.5F, 0.0F, -2.0F, -4.5F, 0.0F, 0.0F, -4.0F);
    this.bodyModel[36].func_78793_a(52.0F, 8.0F, -6.0F);
    this.bodyModel[37].addShapeBox(0.0F, 0.0F, 0.0F, 2, 4, 12, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -2.0F, 0.0F, -0.5F, -2.5F, 0.0F, -1.5F, -4.5F, 0.0F, -1.5F, -4.5F, 0.0F, -0.5F, -2.5F);
    this.bodyModel[37].func_78793_a(56.0F, 4.0F, -6.0F);
    this.bodyModel[38].addShapeBox(0.0F, 0.0F, 0.0F, 2, 4, 12, 0.0F, 0.0F, -1.0F, -4.5F, 0.0F, -3.0F, -5.5F, 0.0F, -3.0F, -5.5F, 0.0F, -1.0F, -4.5F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -2.0F);
    this.bodyModel[38].func_78793_a(56.0F, 0.0F, -6.0F);
    this.bodyModel[39].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 12, 0.0F, 0.0F, 0.5F, -2.5F, 0.0F, 1.5F, -4.5F, 0.0F, 1.5F, -4.5F, 0.0F, 0.5F, -2.5F, 0.0F, -2.0F, -4.5F, -0.5F, -3.5F, -5.0F, -0.5F, -3.5F, -5.0F, 0.0F, -2.0F, -4.5F);
    this.bodyModel[39].func_78793_a(56.0F, 8.0F, -6.0F);
    this.bodyModel[40].addShapeBox(0.0F, 0.0F, 0.0F, 10, 8, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[40].func_78793_a(8.0F, -11.0F, -2.0F);
    this.bodyModel[41].addShapeBox(0.0F, 0.0F, 0.0F, 4, 8, 4, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F);
    this.bodyModel[41].func_78793_a(4.0F, -11.0F, -2.0F);
    this.bodyModel[42].addShapeBox(0.0F, 0.0F, 0.0F, 5, 8, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[42].func_78793_a(18.0F, -11.0F, -2.0F);
    this.bodyModel[43].addShapeBox(0.0F, 0.0F, 0.0F, 3, 8, 2, 0.0F, 0.0F, 0.0F, -0.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9F, 0.0F, 0.0F, -0.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9F);
    this.bodyModel[43].func_78793_a(1.0F, -11.0F, -1.0F);
  }
}
