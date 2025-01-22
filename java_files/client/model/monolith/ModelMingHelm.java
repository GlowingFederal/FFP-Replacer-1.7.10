package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMingHelm extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelMingHelm() {
    this.headModel = new ModelRendererTurbo[48];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 97, 17, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 105, 17, this.textureX, this.textureY);
    this.headModel[21] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.headModel[22] = new ModelRendererTurbo((ModelBase)this, 113, 17, this.textureX, this.textureY);
    this.headModel[23] = new ModelRendererTurbo((ModelBase)this, 65, 25, this.textureX, this.textureY);
    this.headModel[24] = new ModelRendererTurbo((ModelBase)this, 97, 25, this.textureX, this.textureY);
    this.headModel[25] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.headModel[26] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.headModel[27] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[28] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.headModel[29] = new ModelRendererTurbo((ModelBase)this, 113, 25, this.textureX, this.textureY);
    this.headModel[30] = new ModelRendererTurbo((ModelBase)this, 121, 25, this.textureX, this.textureY);
    this.headModel[31] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.headModel[32] = new ModelRendererTurbo((ModelBase)this, 41, 33, this.textureX, this.textureY);
    this.headModel[33] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.headModel[34] = new ModelRendererTurbo((ModelBase)this, 57, 33, this.textureX, this.textureY);
    this.headModel[35] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.headModel[36] = new ModelRendererTurbo((ModelBase)this, 73, 33, this.textureX, this.textureY);
    this.headModel[37] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.headModel[38] = new ModelRendererTurbo((ModelBase)this, 89, 33, this.textureX, this.textureY);
    this.headModel[39] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.headModel[40] = new ModelRendererTurbo((ModelBase)this, 105, 33, this.textureX, this.textureY);
    this.headModel[41] = new ModelRendererTurbo((ModelBase)this, 113, 33, this.textureX, this.textureY);
    this.headModel[42] = new ModelRendererTurbo((ModelBase)this, 121, 33, this.textureX, this.textureY);
    this.headModel[43] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.headModel[44] = new ModelRendererTurbo((ModelBase)this, 9, 41, this.textureX, this.textureY);
    this.headModel[45] = new ModelRendererTurbo((ModelBase)this, 9, 41, this.textureX, this.textureY);
    this.headModel[46] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.headModel[47] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -2.0F, 1.5F, -2.0F, -2.0F, 1.5F, -2.0F, -2.0F, 1.5F, -2.0F, -2.0F, 1.5F, -2.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-0.5F, -12.3F, -0.5F, 1, 1, 1, 0.0F, 0.5F, 0.3F, 0.5F, 0.4F, 0.3F, 0.4F, 0.4F, 0.3F, 0.4F, 0.5F, 0.3F, 0.5F, 0.9F, 0.0F, 0.9F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.9F, 0.0F, 0.9F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-0.5F, -16.3F, -0.5F, 1, 4, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-0.5F, -14.5F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.2F, -0.3F, -0.7F, 0.2F, -0.3F, -0.7F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-0.5F, -13.8F, 3.0F, 1, 1, 1, 0.0F, 0.3F, -0.3F, 1.3F, 0.3F, -0.3F, 1.3F, 0.3F, 0.8F, -1.0F, 0.3F, 0.8F, -1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-0.5F, -13.8F, 3.0F, 1, 3, 1, 0.0F, 0.5F, -0.5F, 0.5F, 0.5F, -0.5F, 0.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.8F, 0.0F, -2.0F, 0.8F, 0.0F, -2.0F, 0.8F, 0.0F, 2.5F, 0.8F, 0.0F, 2.5F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-0.5F, -10.8F, 5.0F, 1, 3, 1, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.9F, 0.3F, -1.0F, 0.9F, 0.3F, -1.0F, 0.9F, 0.0F, 1.5F, 0.9F, 0.0F, 1.5F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-0.5F, -7.8F, 6.0F, 1, 4, 1, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 1.2F, 0.3F, -1.0F, 1.2F, 0.3F, -1.0F, 1.2F, 0.0F, 1.5F, 1.2F, 0.0F, 1.5F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.0F, -6.0F, -4.0F, 8, 2, 1, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.3F, -0.1F, 0.9F, -0.3F, -0.1F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-4.0F, -5.0F, 4.7F, 8, 3, 1, 0.0F, 0.9F, -0.2F, 0.0F, 0.9F, -0.2F, 0.0F, 0.9F, -0.2F, -0.6F, 0.9F, -0.2F, -0.6F, 0.9F, -0.2F, -0.3F, 0.9F, -0.2F, -0.3F, 0.9F, -0.2F, -0.3F, 0.9F, -0.2F, -0.3F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-4.0F, -2.4F, 5.0F, 8, 3, 1, 0.0F, 1.0F, -0.2F, 0.0F, 1.0F, -0.2F, 0.0F, 1.0F, -0.2F, -0.6F, 1.0F, -0.2F, -0.6F, 1.3F, -0.2F, -0.3F, 1.3F, -0.2F, -0.3F, 1.3F, -0.2F, -0.3F, 1.3F, -0.2F, -0.3F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-5.5F, -5.0F, -4.0F, 1, 3, 9, 0.0F, -0.6F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.0F, -0.6F, -0.2F, 0.0F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-5.8F, -2.4F, -4.0F, 1, 3, 9, 0.0F, -0.6F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.0F, -0.6F, -0.2F, 0.0F, 0.0F, -0.2F, 0.1F, -0.6F, -0.2F, 0.1F, -0.3F, -0.2F, 0.4F, -0.3F, -0.2F, 0.4F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(4.5F, -5.0F, -4.0F, 1, 3, 9, 0.0F, 0.0F, -0.2F, 0.1F, -0.6F, -0.2F, 0.1F, -0.6F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.1F, -0.3F, -0.2F, 0.0F, -0.3F, -0.2F, 0.0F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(4.8F, -2.4F, -4.0F, 1, 3, 9, 0.0F, 0.0F, -0.2F, 0.1F, -0.6F, -0.2F, 0.1F, -0.6F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -0.6F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, -0.3F, -0.2F, 0.4F, -0.3F, -0.2F, 0.4F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(-4.0F, -6.0F, -7.0F, 4, 1, 3, 0.0F, -1.0F, -0.4F, -1.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.5F, -0.4F, -0.8F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, -0.8F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(-1.0F, -5.3F, -4.0F, 2, 2, 1, 0.0F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, -0.5F, -0.7F, 0.9F, -0.5F, -0.7F, 0.9F, -0.5F, -0.3F, 0.9F, -0.5F, -0.3F, 0.9F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(-4.0F, -6.0F, -2.0F, 8, 3, 6, 0.0F, 1.1F, -0.5F, 2.1F, 1.1F, -0.5F, 2.1F, 1.1F, -0.5F, 1.1F, 1.1F, -0.5F, 1.1F, 1.1F, -1.7F, 2.1F, 1.1F, -1.7F, 2.1F, 1.1F, -1.7F, 1.1F, 1.1F, -1.7F, 1.1F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(-4.8F, -5.3F, -4.0F, 2, 2, 1, 0.0F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, -0.5F, -0.5F, 0.9F, -0.5F, -0.1F, 0.9F, 0.0F, -0.1F, 0.9F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[20].addShapeBox(2.8F, -5.3F, -4.0F, 2, 2, 1, 0.0F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, -0.5F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.1F, 0.9F, -0.5F, -0.1F, 0.9F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[21].addShapeBox(-0.5F, -15.8F, 0.5F, 1, 1, 1, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, -1.0F, 0.0F, 0.2F, -1.0F, 0.0F, 0.2F, -0.3F, 1.0F, 0.2F, -0.3F, 1.0F, 0.2F, 0.8F, -1.0F, 0.2F, 0.8F, -1.0F);
    this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[22].addShapeBox(0.0F, -6.0F, -7.0F, 4, 1, 3, 0.0F, 0.0F, -0.4F, 0.0F, -1.0F, -0.4F, -1.0F, 0.5F, -0.4F, -0.8F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, 0.5F, 0.0F, -0.8F, 0.0F, 0.0F, 0.0F);
    this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[23].addShapeBox(-0.5F, -8.0F, -4.3F, 1, 3, 4, 0.0F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F);
    this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[24].addShapeBox(-0.5F, -9.8F, -4.3F, 1, 1, 6, 0.0F, 0.0F, 1.6F, -2.0F, 0.0F, 1.6F, -2.0F, 0.0F, 1.6F, -2.0F, 0.0F, 1.6F, -2.0F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.3F);
    this.headModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[25].addShapeBox(-5.5F, -4.0F, -3.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[26].addShapeBox(-5.5F, -4.0F, 0.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[27].addShapeBox(-5.5F, -4.0F, 3.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[28].addShapeBox(-5.9F, -1.7F, 3.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[29].addShapeBox(-5.9F, -1.7F, 0.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[30].addShapeBox(-5.9F, -1.7F, -3.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[31].addShapeBox(4.9F, -1.7F, 3.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[32].addShapeBox(4.9F, -1.7F, 0.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[32].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[33].addShapeBox(4.9F, -1.7F, -3.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[33].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[34].addShapeBox(4.5F, -4.0F, -3.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[34].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[35].addShapeBox(4.5F, -4.0F, 0.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[35].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[36].addShapeBox(4.5F, -4.0F, 3.0F, 1, 1, 1, 0.0F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F);
    this.headModel[36].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[37].addShapeBox(3.0F, -4.0F, 4.8F, 1, 1, 1, 0.0F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F);
    this.headModel[37].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[38].addShapeBox(0.5F, -4.0F, 4.8F, 1, 1, 1, 0.0F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F);
    this.headModel[38].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[39].addShapeBox(-1.5F, -4.0F, 4.8F, 1, 1, 1, 0.0F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F);
    this.headModel[39].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[40].addShapeBox(-4.0F, -4.0F, 4.8F, 1, 1, 1, 0.0F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F);
    this.headModel[40].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[41].addShapeBox(-4.0F, -1.7F, 5.0F, 1, 1, 1, 0.0F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F);
    this.headModel[41].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[42].addShapeBox(-1.5F, -1.7F, 5.0F, 1, 1, 1, 0.0F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F);
    this.headModel[42].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[43].addShapeBox(0.5F, -1.7F, 5.0F, 1, 1, 1, 0.0F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F);
    this.headModel[43].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[44].addShapeBox(3.0F, -1.7F, 5.0F, 1, 1, 1, 0.0F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F);
    this.headModel[44].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[45].addShapeBox(-0.5F, -9.8F, -1.7F, 1, 1, 6, 0.0F, 0.0F, 1.6F, -2.0F, 0.0F, 1.6F, -2.0F, 0.0F, 1.6F, -2.0F, 0.0F, 1.6F, -2.0F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.3F);
    this.headModel[45].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[46].addShapeBox(-0.5F, -8.0F, 0.3F, 1, 3, 4, 0.0F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F);
    this.headModel[46].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[47].addShapeBox(-0.5F, -17.3F, -0.5F, 1, 1, 1, 0.0F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.4F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.headModel[47].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
