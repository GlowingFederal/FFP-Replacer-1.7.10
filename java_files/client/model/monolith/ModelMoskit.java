package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMoskit extends ModelVehicle {
  int textureX = 512;
  
  int textureY = 64;
  
  public ModelMoskit() {
    this.bodyModel = new ModelRendererTurbo[50];
    this.turretModel = new ModelRendererTurbo[2];
    this.barrelModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initturretModel_1();
    initbarrelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 100, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 161, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 201, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 281, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 353, 1, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 409, 1, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 473, 1, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 265, 17, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 305, 17, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 329, 17, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 145, 1, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 185, 1, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 225, 1, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 265, 1, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 393, 1, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 457, 1, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 161, 1, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 345, 1, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 497, 1, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 161, 9, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 241, 9, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 265, 9, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 409, 9, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 289, 17, this.textureX, this.textureY);
    this.bodyModel[31] = new ModelRendererTurbo((ModelBase)this, 305, 17, this.textureX, this.textureY);
    this.bodyModel[32] = new ModelRendererTurbo((ModelBase)this, 393, 17, this.textureX, this.textureY);
    this.bodyModel[33] = new ModelRendererTurbo((ModelBase)this, 457, 9, this.textureX, this.textureY);
    this.bodyModel[34] = new ModelRendererTurbo((ModelBase)this, 417, 17, this.textureX, this.textureY);
    this.bodyModel[35] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.bodyModel[36] = new ModelRendererTurbo((ModelBase)this, 161, 1, this.textureX, this.textureY);
    this.bodyModel[37] = new ModelRendererTurbo((ModelBase)this, 457, 1, this.textureX, this.textureY);
    this.bodyModel[38] = new ModelRendererTurbo((ModelBase)this, 393, 1, this.textureX, this.textureY);
    this.bodyModel[39] = new ModelRendererTurbo((ModelBase)this, 265, 1, this.textureX, this.textureY);
    this.bodyModel[40] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.bodyModel[41] = new ModelRendererTurbo((ModelBase)this, 161, 1, this.textureX, this.textureY);
    this.bodyModel[42] = new ModelRendererTurbo((ModelBase)this, 457, 1, this.textureX, this.textureY);
    this.bodyModel[43] = new ModelRendererTurbo((ModelBase)this, 393, 1, this.textureX, this.textureY);
    this.bodyModel[44] = new ModelRendererTurbo((ModelBase)this, 265, 1, this.textureX, this.textureY);
    this.bodyModel[45] = new ModelRendererTurbo((ModelBase)this, 265, 1, this.textureX, this.textureY);
    this.bodyModel[46] = new ModelRendererTurbo((ModelBase)this, 393, 1, this.textureX, this.textureY);
    this.bodyModel[47] = new ModelRendererTurbo((ModelBase)this, 457, 1, this.textureX, this.textureY);
    this.bodyModel[48] = new ModelRendererTurbo((ModelBase)this, 161, 1, this.textureX, this.textureY);
    this.bodyModel[49] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 32, 5, 13, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -0.5F, 0.0F, 0.0F, -0.75F, -0.25F, 0.0F, -0.75F, -0.25F, -1.5F, -0.5F, 0.0F);
    this.bodyModel[0].func_78793_a(-31.0F, 1.0F, -6.5F);
    this.bodyModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 13, 4, 13, 0.0F, 0.0F, 0.5F, 0.0F, 3.0F, 2.0F, 0.0F, 3.0F, 2.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.25F, -0.25F, 3.0F, -1.25F, -0.75F, 3.0F, -1.25F, -0.75F, 0.0F, 0.25F, -0.25F);
    this.bodyModel[1].func_78793_a(1.0F, 1.0F, -6.5F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 5, 4, 13, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, -0.75F, 0.0F, 0.5F, -0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.75F, -0.75F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -1.75F, 0.0F, 0.75F, -0.75F);
    this.bodyModel[2].func_78793_a(17.0F, -1.0F, -6.5F);
    this.bodyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 13, 0.0F, 0.0F, 0.5F, -0.75F, 0.0F, 0.75F, -2.0F, 0.0F, 0.75F, -2.0F, 0.0F, 0.5F, -0.75F, 0.0F, 0.0F, -1.75F, 0.0F, -1.0F, -3.75F, 0.0F, -1.0F, -3.75F, 0.0F, 0.0F, -1.75F);
    this.bodyModel[3].func_78793_a(22.0F, -1.0F, -6.5F);
    this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 3, 4, 13, 0.0F, 0.0F, 0.75F, -2.0F, 0.0F, 0.75F, -4.0F, 0.0F, 0.75F, -4.0F, 0.0F, 0.75F, -2.0F, 0.0F, -1.0F, -3.75F, 0.0F, -1.5F, -5.5F, 0.0F, -1.5F, -5.5F, 0.0F, -1.0F, -3.75F);
    this.bodyModel[4].func_78793_a(26.0F, -1.0F, -6.5F);
    this.bodyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 2, 4, 4, 0.0F, 0.0F, 0.75F, 0.5F, 0.5F, 0.75F, -1.75F, 0.5F, 0.75F, -1.75F, 0.0F, 0.75F, 0.5F, 0.0F, -1.5F, -1.0F, -0.75F, -1.75F, -1.75F, -0.75F, -1.75F, -1.75F, 0.0F, -1.5F, -1.0F);
    this.bodyModel[5].func_78793_a(29.0F, -1.0F, -2.0F);
    this.bodyModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 22, 2, 13, 0.0F, -1.5F, -0.5F, 0.0F, 0.0F, -0.33F, -0.17F, 0.0F, -0.33F, -0.17F, -1.5F, -0.5F, 0.0F, -16.75F, 0.0F, -4.75F, 0.0F, 0.25F, -3.75F, 0.0F, 0.25F, -3.75F, -16.75F, 0.0F, -4.75F);
    this.bodyModel[6].func_78793_a(-31.0F, 5.0F, -6.5F);
    this.bodyModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 12, 2, 13, 0.0F, 0.0F, -0.33F, -0.17F, -2.0F, -0.25F, -0.25F, -2.0F, -0.25F, -0.25F, 0.0F, -0.33F, -0.17F, 0.0F, 0.25F, -3.75F, -1.75F, 0.0F, -3.0F, -1.75F, 0.0F, -3.0F, 0.0F, 0.25F, -3.75F);
    this.bodyModel[7].func_78793_a(-9.0F, 5.0F, -6.5F);
    this.bodyModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 16, 2, 13, 0.0F, 0.0F, 0.25F, -0.25F, 0.0F, 1.75F, -0.75F, 0.0F, 1.75F, -0.75F, 0.0F, 0.25F, -0.25F, -0.25F, -0.5F, -3.0F, 0.0F, -0.25F, -3.75F, 0.0F, -0.25F, -3.75F, -0.25F, -0.5F, -3.0F);
    this.bodyModel[8].func_78793_a(1.0F, 5.5F, -6.5F);
    this.bodyModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 5, 3, 13, 0.0F, 0.0F, 0.25F, -0.75F, 0.0F, 1.0F, -1.75F, 0.0F, 1.0F, -1.75F, 0.0F, 0.25F, -0.75F, 0.0F, 0.25F, -3.75F, 0.0F, 0.5F, -5.0F, 0.0F, 0.5F, -5.0F, 0.0F, 0.25F, -3.75F);
    this.bodyModel[9].func_78793_a(17.0F, 4.0F, -6.5F);
    this.bodyModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 4, 4, 13, 0.0F, 0.0F, -1.0F, -1.75F, 0.0F, 0.0F, -3.75F, 0.0F, 0.0F, -3.75F, 0.0F, -1.0F, -1.75F, 0.0F, 1.5F, -5.0F, 0.0F, 0.0F, -5.75F, 0.0F, 0.0F, -5.75F, 0.0F, 1.5F, -5.0F);
    this.bodyModel[10].func_78793_a(22.0F, 2.0F, -6.5F);
    this.bodyModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 3, 3, 13, 0.0F, 0.0F, 0.0F, -3.75F, 0.0F, 0.5F, -5.5F, 0.0F, 0.5F, -5.5F, 0.0F, 0.0F, -3.75F, 0.0F, 1.0F, -5.75F, 0.0F, -2.0F, -6.0F, 0.0F, -2.0F, -6.0F, 0.0F, 1.0F, -5.75F);
    this.bodyModel[11].func_78793_a(26.0F, 2.0F, -6.5F);
    this.bodyModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 4, 0.0F, 0.0F, -0.5F, -1.0F, -0.75F, -0.25F, -1.75F, -0.75F, -0.25F, -1.75F, 0.0F, -0.5F, -1.0F, 0.0F, 1.0F, -1.5F, -1.25F, 0.1F, -1.75F, -1.25F, 0.1F, -1.75F, 0.0F, 1.0F, -1.5F);
    this.bodyModel[12].func_78793_a(29.0F, 1.0F, -2.0F);
    this.bodyModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 24, 5, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[13].func_78793_a(-22.0F, -3.0F, -2.0F);
    this.bodyModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 3, 5, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[14].func_78793_a(2.0F, -3.0F, -2.0F);
    this.bodyModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 5, 4, 6, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[15].func_78793_a(5.0F, -3.0F, -3.0F);
    this.bodyModel[16].addShapeBox(0.0F, -1.0F, 0.0F, 4, 7, 8, 0.0F, 1.0F, 0.5F, 0.0F, -4.0F, 0.25F, -2.0F, -4.0F, 0.25F, -4.0F, 1.0F, 0.5F, -2.0F, 0.5F, 0.0F, 0.0F, -3.0F, -2.0F, -2.0F, -3.0F, -2.0F, -4.0F, 0.5F, -2.0F, -2.0F);
    this.bodyModel[16].func_78793_a(11.0F, -3.0F, -3.0F);
    this.bodyModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 3, 5, 4, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F);
    this.bodyModel[17].func_78793_a(3.0F, -5.5F, -2.0F);
    this.bodyModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 1, 8, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F, 0.2F, 3.0F, 0.2F);
    this.bodyModel[18].func_78793_a(1.0F, -13.5F, -0.5F);
    this.bodyModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[19].func_78793_a(-8.0F, -3.2F, 2.9F);
    (this.bodyModel[19]).field_78808_h = 0.17453294F;
    this.bodyModel[20].addShapeBox(0.0F, 1.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[20].func_78793_a(-8.0F, -3.2F, 2.9F);
    (this.bodyModel[20]).field_78808_h = 0.17453294F;
    this.bodyModel[21].addShapeBox(0.0F, 2.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.bodyModel[21].func_78793_a(-8.0F, -3.2F, 2.9F);
    (this.bodyModel[21]).field_78808_h = 0.17453294F;
    this.bodyModel[22].addShapeBox(0.0F, 2.0F, 0.0F, 1, 3, 3, 0.0F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
    this.bodyModel[22].func_78793_a(-6.0F, -4.2F, 2.9F);
    this.bodyModel[23].addShapeBox(0.0F, 2.0F, 0.0F, 1, 3, 3, 0.0F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
    this.bodyModel[23].func_78793_a(-2.5F, -4.2F, 2.9F);
    (this.bodyModel[23]).field_78808_h = 0.17453294F;
    this.bodyModel[24].addShapeBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[24].func_78793_a(-29.0F, -1.0F, -1.5F);
    this.bodyModel[25].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[25].func_78793_a(-29.0F, -2.0F, -1.5F);
    this.bodyModel[26].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.bodyModel[26].func_78793_a(-29.0F, -3.0F, -1.5F);
    this.bodyModel[27].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, -1.05F, -0.5F, -1.05F, -1.05F, -0.5F, -1.05F, -1.05F, -0.5F, -1.05F, -1.05F, -0.5F, -1.05F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.bodyModel[27].func_78793_a(-29.0F, -4.0F, -1.5F);
    this.bodyModel[28].addShapeBox(-3.5F, -0.5F, 0.0F, 4, 1, 1, 0.0F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F);
    this.bodyModel[28].func_78793_a(-27.5F, -2.7F, -0.5F);
    (this.bodyModel[28]).field_78808_h = -0.2617994F;
    this.bodyModel[29].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[29].func_78793_a(13.25F, -2.0F, -1.5F);
    this.bodyModel[30].addShapeBox(0.0F, 0.0F, 0.0F, 3, 2, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[30].func_78793_a(13.25F, -1.0F, -1.5F);
    this.bodyModel[31].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[31].func_78793_a(-20.5F, -6.0F, -1.0F);
    this.bodyModel[32].addShapeBox(0.0F, 0.0F, 0.0F, 4, 1, 4, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F);
    this.bodyModel[32].func_78793_a(-21.5F, -6.5F, -2.0F);
    this.bodyModel[33].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.bodyModel[33].func_78793_a(-20.5F, -8.0F, -1.0F);
    this.bodyModel[34].addShapeBox(-1.0F, -2.0F, 0.0F, 3, 2, 3, 0.0F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F);
    this.bodyModel[34].func_78793_a(-19.5F, -7.5F, -1.5F);
    (this.bodyModel[34]).field_78808_h = 0.7679449F;
    this.bodyModel[35].addShapeBox(0.0F, 2.0F, 0.0F, 1, 3, 3, 0.0F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
    this.bodyModel[35].func_78793_a(-21.4F, -3.9F, 2.9F);
    (this.bodyModel[35]).field_78808_h = 0.17453294F;
    this.bodyModel[36].addShapeBox(0.0F, 2.0F, 0.0F, 1, 3, 3, 0.0F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
    this.bodyModel[36].func_78793_a(-24.9F, -3.9F, 2.9F);
    this.bodyModel[37].addShapeBox(0.0F, 2.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.bodyModel[37].func_78793_a(-26.9F, -2.9F, 2.9F);
    (this.bodyModel[37]).field_78808_h = 0.17453294F;
    this.bodyModel[38].addShapeBox(0.0F, 1.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[38].func_78793_a(-26.9F, -2.9F, 2.9F);
    (this.bodyModel[38]).field_78808_h = 0.17453294F;
    this.bodyModel[39].addShapeBox(0.0F, 0.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[39].func_78793_a(-26.9F, -2.9F, 2.9F);
    (this.bodyModel[39]).field_78808_h = 0.17453294F;
    this.bodyModel[40].addShapeBox(0.0F, 2.0F, 0.0F, 1, 3, 3, 0.0F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
    this.bodyModel[40].func_78793_a(-21.4F, -3.9F, -5.9F);
    (this.bodyModel[40]).field_78808_h = 0.17453294F;
    this.bodyModel[41].addShapeBox(0.0F, 2.0F, 0.0F, 1, 3, 3, 0.0F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
    this.bodyModel[41].func_78793_a(-24.9F, -3.9F, -5.9F);
    this.bodyModel[42].addShapeBox(0.0F, 2.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.bodyModel[42].func_78793_a(-26.9F, -2.9F, -5.9F);
    (this.bodyModel[42]).field_78808_h = 0.17453294F;
    this.bodyModel[43].addShapeBox(0.0F, 1.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[43].func_78793_a(-26.9F, -2.9F, -5.9F);
    (this.bodyModel[43]).field_78808_h = 0.17453294F;
    this.bodyModel[44].addShapeBox(0.0F, 0.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[44].func_78793_a(-26.9F, -2.9F, -5.9F);
    (this.bodyModel[44]).field_78808_h = 0.17453294F;
    this.bodyModel[45].addShapeBox(0.0F, 0.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, -1.5F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[45].func_78793_a(-8.0F, -3.2F, -5.9F);
    (this.bodyModel[45]).field_78808_h = 0.17453294F;
    this.bodyModel[46].addShapeBox(0.0F, 1.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[46].func_78793_a(-8.0F, -3.2F, -5.9F);
    (this.bodyModel[46]).field_78808_h = 0.17453294F;
    this.bodyModel[47].addShapeBox(0.0F, 2.0F, 0.0F, 11, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.bodyModel[47].func_78793_a(-8.0F, -3.2F, -5.9F);
    (this.bodyModel[47]).field_78808_h = 0.17453294F;
    this.bodyModel[48].addShapeBox(0.0F, 2.0F, 0.0F, 1, 3, 3, 0.0F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
    this.bodyModel[48].func_78793_a(-6.0F, -4.2F, -5.9F);
    this.bodyModel[49].addShapeBox(0.0F, 2.0F, 0.0F, 1, 3, 3, 0.0F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F);
    this.bodyModel[49].func_78793_a(-2.5F, -4.2F, -5.9F);
    (this.bodyModel[49]).field_78808_h = 0.17453294F;
  }
  
  private void initturretModel_1() {
    this.turretModel[0] = new ModelRendererTurbo((ModelBase)this, 345, 9, this.textureX, this.textureY);
    this.turretModel[1] = new ModelRendererTurbo((ModelBase)this, 393, 9, this.textureX, this.textureY);
    this.turretModel[0].addShapeBox(-1.5F, 0.0F, 0.0F, 3, 1, 3, 0.0F, -1.05F, -0.5F, -1.05F, -1.05F, -0.5F, -1.05F, -1.05F, -0.5F, -1.05F, -1.05F, -0.5F, -1.05F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.turretModel[0].func_78793_a(14.75F, -4.0F, -1.5F);
    this.turretModel[1].addShapeBox(-1.5F, 0.0F, 0.0F, 3, 1, 3, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.turretModel[1].func_78793_a(14.75F, -3.0F, -1.5F);
  }
  
  private void initbarrelModel_1() {
    this.barrelModel[0] = new ModelRendererTurbo((ModelBase)this, 281, 9, this.textureX, this.textureY);
    this.barrelModel[0].addShapeBox(0.0F, -0.5F, 0.0F, 4, 1, 1, 0.0F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F);
    this.barrelModel[0].func_78793_a(14.75F, -2.5F, -0.5F);
  }
}
