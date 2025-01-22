package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelKuyak extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelKuyak() {
    this.bodyModel = new ModelRendererTurbo[64];
    this.leftArmModel = new ModelRendererTurbo[2];
    this.rightArmModel = new ModelRendererTurbo[2];
    this.leftLegModel = new ModelRendererTurbo[4];
    this.rightLegModel = new ModelRendererTurbo[4];
    this.skirtFrontModel = new ModelRendererTurbo[1];
    this.skirtRearModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
    initskirtFrontModel_1();
    initskirtRearModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[31] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[32] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[33] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[34] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[35] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[36] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[37] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[38] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[39] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[40] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[41] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[42] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[43] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[44] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[45] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[46] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[47] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[48] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[49] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[50] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[51] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[52] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[53] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[54] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[55] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[56] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[57] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[58] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[59] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[60] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[61] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[62] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.bodyModel[63] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 4.0F, -2.0F, 8, 6, 4, 0.0F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.1F, 0.5F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 4, 4, 0.0F, 0.1F, 0.15F, 0.3F, 0.1F, 0.15F, 0.3F, 0.1F, 0.15F, 0.3F, 0.1F, 0.15F, 0.3F, 0.5F, -0.1F, 0.5F, 0.5F, -0.1F, 0.5F, 0.5F, -0.1F, 0.5F, 0.5F, -0.1F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-1.6F, 3.0F, -2.6F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-3.3F, 3.0F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-3.3F, 4.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-3.3F, 6.0F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-3.3F, 7.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-4.8F, 3.0F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-4.8F, 4.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-4.8F, 6.0F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-4.8F, 7.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(0.2F, 3.0F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(0.2F, 4.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(0.2F, 6.0F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(0.2F, 7.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(1.7F, 3.0F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(1.7F, 4.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(1.7F, 6.0F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(1.7F, 7.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(1.7F, -0.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(0.2F, -0.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(1.7F, 1.0F, -2.6F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(0.2F, 1.0F, -2.6F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[23].addShapeBox(-3.1F, 1.0F, -2.6F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[24].addShapeBox(-3.1F, -0.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[25].addShapeBox(-4.6F, 1.0F, -2.6F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[26].addShapeBox(-4.6F, -0.5F, -2.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[27].addShapeBox(-4.6F, 1.0F, 1.6F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[28].addShapeBox(-4.6F, -0.5F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[29].addShapeBox(-3.1F, -0.5F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[30].addShapeBox(-3.1F, 1.0F, 1.6F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[31].addShapeBox(0.2F, -0.5F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[32].addShapeBox(0.2F, 1.0F, 1.6F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[32].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[33].addShapeBox(1.7F, 1.0F, 1.6F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[33].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[34].addShapeBox(1.7F, -0.5F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[34].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[35].addShapeBox(1.7F, 3.0F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[35].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[36].addShapeBox(1.7F, 4.5F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[36].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[37].addShapeBox(0.2F, 4.5F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[37].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[38].addShapeBox(0.2F, 3.0F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[38].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[39].addShapeBox(-3.3F, 4.5F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[39].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[40].addShapeBox(-3.3F, 3.0F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[40].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[41].addShapeBox(-4.8F, 3.0F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[41].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[42].addShapeBox(-4.8F, 4.5F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[42].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[43].addShapeBox(-4.8F, 6.0F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[43].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[44].addShapeBox(-4.8F, 7.5F, 1.4F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[44].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[45].addShapeBox(-3.3F, 7.5F, 1.4F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[45].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[46].addShapeBox(-3.3F, 6.0F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[46].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[47].addShapeBox(1.7F, 7.5F, 1.4F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[47].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[48].addShapeBox(1.7F, 6.0F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[48].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[49].addShapeBox(0.2F, 6.0F, 1.5F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[49].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[50].addShapeBox(0.2F, 7.5F, 1.4F, 3, 3, 1, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F);
    this.bodyModel[50].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[51].addShapeBox(-1.45F, 1.0F, -2.7F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[51].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[52].addShapeBox(-1.45F, -0.5F, -2.7F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[52].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[53].addShapeBox(-1.6F, 6.0F, -2.6F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[53].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[54].addShapeBox(-1.6F, 7.5F, -2.6F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[54].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[55].addShapeBox(-1.6F, 4.5F, -2.6F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[55].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[56].addShapeBox(-1.45F, -0.5F, 1.55F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[56].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[57].addShapeBox(-1.45F, 1.0F, 1.55F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[57].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[58].addShapeBox(-1.6F, 3.0F, 1.65F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[58].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[59].addShapeBox(-1.6F, 4.5F, 1.65F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[59].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[60].addShapeBox(-1.6F, 6.0F, 1.65F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[60].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[61].addShapeBox(-1.6F, 7.5F, 1.65F, 3, 3, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F, -0.7F, -1.0F, 0.0F);
    this.bodyModel[61].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[62].addShapeBox(4.0F, 9.2F, 0.0F, 1, 13, 1, 0.0F, 0.3F, -0.5F, 4.0F, -0.1F, -0.3F, 4.0F, -0.1F, 0.2F, -4.0F, 0.3F, 0.0F, -4.0F, -2.7F, -0.3F, -1.5F, 2.5F, -0.5F, -1.5F, 2.5F, -1.0F, 1.0F, -2.7F, -0.7F, 1.0F);
    this.bodyModel[62].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[63].addShapeBox(-4.0F, 10.0F, -2.0F, 8, 1, 4, 0.0F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F);
    this.bodyModel[63].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-3.0F, -7.2F, -4.0F, 8, 16, 8, 0.0F, -1.8F, -5.0F, -1.8F, -1.8F, -5.0F, -1.8F, -1.8F, -5.0F, -1.8F, -1.8F, -5.0F, -1.8F, -1.8F, -4.0F, -1.8F, -1.8F, -4.0F, -1.8F, -1.8F, -4.0F, -1.8F, -1.8F, -4.0F, -1.8F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, -2.1F, -2.0F, 4, 10, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-5.0F, -7.2F, -4.0F, 8, 16, 8, 0.0F, -1.8F, -5.0F, -1.8F, -1.8F, -5.0F, -1.8F, -1.8F, -5.0F, -1.8F, -1.8F, -5.0F, -1.8F, -1.8F, -4.0F, -1.8F, -1.8F, -4.0F, -1.8F, -1.8F, -4.0F, -1.8F, -1.8F, -4.0F, -1.8F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, -2.1F, -2.0F, 4, 10, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 81, 25, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-4.0F, -5.1F, -4.0F, 8, 19, 8, 0.0F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 6.3F, -2.0F, 4, 1, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 7.3F, -2.0F, 4, 4, 4, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 81, 25, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 6.3F, -2.0F, 4, 1, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F, 0.7F, 0.2F, 0.7F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 7.3F, -2.0F, 4, 4, 4, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-4.0F, -5.1F, -4.0F, 8, 19, 8, 0.0F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F, -1.9F, -5.0F, -1.9F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 97, 9, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, -1.8F, -2.0F, 8, 6, 2, 0.0F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.7F, 0.8F, 0.7F, 0.7F, 0.8F, 0.7F, 0.7F, 0.8F, 0.7F, 0.7F, 0.8F, 0.7F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 97, 9, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-4.0F, -1.8F, 0.0F, 8, 6, 2, 0.0F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.2F, 0.1F, 0.2F, 0.7F, 0.8F, 0.7F, 0.7F, 0.8F, 0.7F, 0.7F, 0.8F, 0.7F, 0.7F, 0.8F, 0.7F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
