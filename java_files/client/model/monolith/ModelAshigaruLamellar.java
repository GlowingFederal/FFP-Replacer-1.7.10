package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelAshigaruLamellar extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelAshigaruLamellar() {
    this.bodyModel = new ModelRendererTurbo[49];
    this.leftArmModel = new ModelRendererTurbo[1];
    this.rightArmModel = new ModelRendererTurbo[1];
    this.leftLegModel = new ModelRendererTurbo[3];
    this.rightLegModel = new ModelRendererTurbo[3];
    this.skirtFrontModel = new ModelRendererTurbo[5];
    this.skirtRearModel = new ModelRendererTurbo[5];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
    initskirtFrontModel_1();
    initskirtRearModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 113, 25, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 113, 41, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 73, 33, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 57, 41, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 81, 41, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 105, 41, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 17, 49, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 33, 49, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 65, 49, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 73, 49, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 97, 49, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 17, 57, this.textureX, this.textureY);
    this.bodyModel[31] = new ModelRendererTurbo((ModelBase)this, 49, 57, this.textureX, this.textureY);
    this.bodyModel[32] = new ModelRendererTurbo((ModelBase)this, 97, 49, this.textureX, this.textureY);
    this.bodyModel[33] = new ModelRendererTurbo((ModelBase)this, 65, 49, this.textureX, this.textureY);
    this.bodyModel[34] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.bodyModel[35] = new ModelRendererTurbo((ModelBase)this, 73, 49, this.textureX, this.textureY);
    this.bodyModel[36] = new ModelRendererTurbo((ModelBase)this, 97, 49, this.textureX, this.textureY);
    this.bodyModel[37] = new ModelRendererTurbo((ModelBase)this, 65, 49, this.textureX, this.textureY);
    this.bodyModel[38] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.bodyModel[39] = new ModelRendererTurbo((ModelBase)this, 73, 49, this.textureX, this.textureY);
    this.bodyModel[40] = new ModelRendererTurbo((ModelBase)this, 97, 49, this.textureX, this.textureY);
    this.bodyModel[41] = new ModelRendererTurbo((ModelBase)this, 65, 49, this.textureX, this.textureY);
    this.bodyModel[42] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.bodyModel[43] = new ModelRendererTurbo((ModelBase)this, 73, 49, this.textureX, this.textureY);
    this.bodyModel[44] = new ModelRendererTurbo((ModelBase)this, 49, 57, this.textureX, this.textureY);
    this.bodyModel[45] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.bodyModel[46] = new ModelRendererTurbo((ModelBase)this, 49, 57, this.textureX, this.textureY);
    this.bodyModel[47] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.bodyModel[48] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-3.0F, 3.0F, -2.1F, 6, 7, 4, 0.0F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.8F, 0.8F, 0.8F, 0.8F, 0.8F, 0.3F, 0.5F, 0.8F, 0.3F, 0.5F, 0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 7.0F, -2.0F, 1, 3, 4, 0.0F, 0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F, 1.0F, -0.7F, 0.8F, -0.8F, 0.0F, 0.8F, -0.8F, 0.0F, 0.8F, 1.0F, -0.7F, 0.8F, 0.8F, -0.3F, 0.8F, -0.8F, -0.3F, 0.8F, -0.8F, -0.3F, 0.8F, 0.8F, -0.3F, 0.8F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-3.0F, -0.5F, -3.0F, 1, 1, 6, 0.0F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(2.0F, -0.5F, -3.0F, 1, 1, 6, 0.0F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, 0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-3.0F, 0.5F, -3.0F, 1, 1, 6, 0.0F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(2.0F, 0.5F, -3.0F, 1, 1, 6, 0.0F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, 0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(3.0F, 5.0F, -2.0F, 1, 2, 4, 0.0F, -0.8F, 0.0F, 0.8F, 1.0F, -0.7F, 0.8F, 1.0F, -0.7F, 0.8F, -0.8F, 0.0F, 0.8F, -0.8F, -0.3F, 0.8F, 0.8F, -0.3F, 0.8F, 0.8F, -0.3F, 0.8F, -0.8F, -0.3F, 0.8F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(3.0F, 7.0F, -2.0F, 1, 3, 4, 0.0F, -0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, 0.8F, 0.3F, 0.8F, -0.8F, 0.3F, 0.8F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-4.5F, 10.5F, -2.0F, 1, 4, 4, 0.0F, 0.0F, 0.3F, 0.8F, -0.5F, 0.3F, 0.8F, -0.5F, 0.3F, 0.8F, 0.0F, 0.3F, 0.8F, 1.0F, 0.3F, 1.8F, -1.5F, 0.3F, 1.8F, -1.5F, 0.3F, 1.8F, 1.0F, 0.3F, 1.8F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-3.0F, 0.0F, 2.0F, 1, 1, 1, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 2.0F, 0.3F, 0.0F, 2.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(2.0F, 0.0F, 2.0F, 1, 1, 1, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 2.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 2.0F, 0.3F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-3.0F, 1.6F, 2.0F, 6, 1, 1, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-4.5F, 13.5F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 1.4F, -0.5F, -0.1F, 1.4F, -0.5F, -0.1F, 1.4F, 0.8F, -0.1F, 1.4F, 1.0F, -0.1F, 1.5F, -1.5F, -0.1F, 1.5F, -1.5F, -0.1F, 1.5F, 1.0F, -0.1F, 1.5F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-4.3F, 12.5F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 1.3F, -0.5F, -0.1F, 1.3F, -0.5F, -0.1F, 1.3F, 0.8F, -0.1F, 1.3F, 1.0F, -0.1F, 1.4F, -1.5F, -0.1F, 1.4F, -1.5F, -0.1F, 1.4F, 1.0F, -0.1F, 1.4F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-4.05F, 11.5F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 1.1F, -0.5F, -0.1F, 1.1F, -0.5F, -0.1F, 1.1F, 0.8F, -0.1F, 1.1F, 1.0F, -0.1F, 1.2F, -1.5F, -0.1F, 1.2F, -1.5F, -0.1F, 1.2F, 1.0F, -0.1F, 1.2F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-3.8F, 10.5F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 0.9F, -0.5F, -0.1F, 0.9F, -0.5F, -0.1F, 0.9F, 0.8F, -0.1F, 0.9F, 1.0F, -0.1F, 1.0F, -1.5F, -0.1F, 1.0F, -1.5F, -0.1F, 1.0F, 1.0F, -0.1F, 1.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(2.8F, 10.5F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 0.9F, 0.8F, -0.1F, 0.9F, 0.8F, -0.1F, 0.9F, -0.5F, -0.1F, 0.9F, -1.5F, -0.1F, 1.0F, 1.0F, -0.1F, 1.0F, 1.0F, -0.1F, 1.0F, -1.5F, -0.1F, 1.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(3.05F, 11.5F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 1.1F, 0.8F, -0.1F, 1.1F, 0.8F, -0.1F, 1.1F, -0.5F, -0.1F, 1.1F, -1.5F, -0.1F, 1.2F, 1.0F, -0.1F, 1.2F, 1.0F, -0.1F, 1.2F, -1.5F, -0.1F, 1.2F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(3.3F, 12.5F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 1.3F, 0.8F, -0.1F, 1.3F, 0.8F, -0.1F, 1.3F, -0.5F, -0.1F, 1.3F, -1.5F, -0.1F, 1.4F, 1.0F, -0.1F, 1.4F, 1.0F, -0.1F, 1.4F, -1.5F, -0.1F, 1.4F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(3.5F, 13.5F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 1.4F, 0.8F, -0.1F, 1.4F, 0.8F, -0.1F, 1.4F, -0.5F, -0.1F, 1.4F, -1.5F, -0.1F, 1.5F, 1.0F, -0.1F, 1.5F, 1.0F, -0.1F, 1.5F, -1.5F, -0.1F, 1.5F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(3.5F, 10.5F, -2.0F, 1, 4, 4, 0.0F, -0.5F, 0.3F, 0.8F, 0.0F, 0.3F, 0.8F, 0.0F, 0.3F, 0.8F, -0.5F, 0.3F, 0.8F, -1.5F, 0.3F, 1.8F, 1.0F, 0.3F, 1.8F, 1.0F, 0.3F, 1.8F, -1.5F, 0.3F, 1.8F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[23].addShapeBox(-4.0F, 6.3F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F);
    this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[24].addShapeBox(3.0F, 6.3F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F);
    this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[25].addShapeBox(-4.0F, 6.3F, 1.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
    this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[26].addShapeBox(-4.0F, 6.3F, -2.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
    this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[27].addShapeBox(-3.0F, 2.3F, 1.0F, 6, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
    this.bodyModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[28].addShapeBox(-3.0F, 1.0F, -3.2F, 1, 1, 1, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 2.0F, 0.3F, 0.0F, 2.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F);
    this.bodyModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[29].addShapeBox(2.0F, 1.0F, -3.2F, 1, 1, 1, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 2.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 2.0F, 0.3F, 0.0F);
    this.bodyModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[30].addShapeBox(-3.0F, 2.6F, -3.2F, 6, 1, 1, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F, 0.3F, -0.3F, 0.0F);
    this.bodyModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[31].addShapeBox(-3.0F, 3.3F, -2.0F, 6, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
    this.bodyModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[32].addShapeBox(-4.0F, 7.3F, -2.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
    this.bodyModel[32].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[33].addShapeBox(3.0F, 7.3F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F);
    this.bodyModel[33].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[34].addShapeBox(-4.0F, 7.3F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F);
    this.bodyModel[34].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[35].addShapeBox(-4.0F, 7.3F, 1.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
    this.bodyModel[35].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[36].addShapeBox(-4.0F, 8.3F, -2.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
    this.bodyModel[36].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[37].addShapeBox(3.0F, 8.3F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F);
    this.bodyModel[37].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[38].addShapeBox(-4.0F, 8.3F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F);
    this.bodyModel[38].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[39].addShapeBox(-4.0F, 8.3F, 1.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
    this.bodyModel[39].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[40].addShapeBox(-4.0F, 9.3F, -2.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
    this.bodyModel[40].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[41].addShapeBox(3.0F, 9.3F, -2.0F, 1, 1, 4, 0.0F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F);
    this.bodyModel[41].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[42].addShapeBox(-4.0F, 9.3F, -2.0F, 1, 1, 4, 0.0F, 0.8F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, -0.5F, -0.1F, 0.7F, 0.8F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, -1.5F, -0.1F, 0.7F, 1.0F, -0.1F, 0.7F);
    this.bodyModel[42].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[43].addShapeBox(-4.0F, 9.3F, 1.0F, 8, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
    this.bodyModel[43].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[44].addShapeBox(-3.0F, 4.3F, -2.0F, 6, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
    this.bodyModel[44].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[45].addShapeBox(-3.0F, 3.3F, 1.0F, 6, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
    this.bodyModel[45].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[46].addShapeBox(-3.0F, 5.3F, -2.0F, 6, 1, 1, 0.0F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F);
    this.bodyModel[46].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[47].addShapeBox(-3.0F, 4.3F, 1.0F, 6, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
    this.bodyModel[47].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[48].addShapeBox(-3.0F, 5.3F, 1.0F, 6, 1, 1, 0.0F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, 0.8F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, -1.5F, 0.7F, -0.1F, 1.0F, 0.7F, -0.1F, 1.0F);
    this.bodyModel[48].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 7.0F, -2.0F, 4, 3, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 11.0F, -2.0F, 4, 1, 4, 0.0F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 73, 17, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 7.0F, -2.0F, 4, 3, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 11.0F, -2.0F, 4, 1, 4, 0.0F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.skirtFrontModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.skirtFrontModel[2] = new ModelRendererTurbo((ModelBase)this, 57, 33, this.textureX, this.textureY);
    this.skirtFrontModel[3] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.skirtFrontModel[4] = new ModelRendererTurbo((ModelBase)this, 105, 33, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-3.5F, -1.5F, -3.0F, 7, 4, 1, 0.0F, 0.8F, 0.3F, 0.0F, 0.8F, 0.3F, 0.0F, 0.8F, 0.3F, -0.5F, 0.8F, 0.3F, -0.5F, 1.8F, 0.3F, 1.0F, 1.8F, 0.3F, 1.0F, 1.8F, 0.3F, -1.5F, 1.8F, 0.3F, -1.5F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[1].addShapeBox(-4.0F, 1.5F, -4.0F, 8, 1, 1, 0.0F, 0.9F, -0.1F, -0.2F, 0.9F, -0.1F, -0.2F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, 0.0F, 0.9F, -0.1F, 0.0F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, -0.3F);
    this.skirtFrontModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[2].addShapeBox(-4.0F, 0.5F, -3.9F, 8, 1, 1, 0.0F, 0.8F, -0.1F, -0.2F, 0.8F, -0.1F, -0.2F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, 0.0F, 0.8F, -0.1F, 0.0F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, -0.3F);
    this.skirtFrontModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[3].addShapeBox(-4.0F, -0.5F, -3.7F, 8, 1, 1, 0.0F, 0.6F, -0.1F, -0.2F, 0.6F, -0.1F, -0.2F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, 0.0F, 0.6F, -0.1F, 0.0F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, -0.3F);
    this.skirtFrontModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[4].addShapeBox(-4.0F, -1.5F, -3.5F, 8, 1, 1, 0.0F, 0.4F, -0.1F, -0.2F, 0.4F, -0.1F, -0.2F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, 0.0F, 0.4F, -0.1F, 0.0F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, -0.3F);
    this.skirtFrontModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.skirtRearModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.skirtRearModel[2] = new ModelRendererTurbo((ModelBase)this, 65, 41, this.textureX, this.textureY);
    this.skirtRearModel[3] = new ModelRendererTurbo((ModelBase)this, 89, 41, this.textureX, this.textureY);
    this.skirtRearModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-3.5F, -1.5F, 2.0F, 7, 4, 1, 0.0F, 0.8F, 0.3F, -0.5F, 0.8F, 0.3F, -0.5F, 0.8F, 0.3F, 0.0F, 0.8F, 0.3F, 0.0F, 1.8F, 0.3F, -1.5F, 1.8F, 0.3F, -1.5F, 1.8F, 0.3F, 1.0F, 1.8F, 0.3F, 1.0F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel[1].addShapeBox(-4.0F, -1.5F, 2.5F, 8, 1, 1, 0.0F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, -0.2F, 0.4F, -0.1F, -0.2F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, -0.3F, 0.4F, -0.1F, 0.0F, 0.4F, -0.1F, 0.0F);
    this.skirtRearModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel[2].addShapeBox(-4.0F, -0.5F, 2.7F, 8, 1, 1, 0.0F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, -0.2F, 0.6F, -0.1F, -0.2F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, -0.3F, 0.6F, -0.1F, 0.0F, 0.6F, -0.1F, 0.0F);
    this.skirtRearModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel[3].addShapeBox(-4.0F, 0.5F, 2.9F, 8, 1, 1, 0.0F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, -0.2F, 0.8F, -0.1F, -0.2F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, -0.3F, 0.8F, -0.1F, 0.0F, 0.8F, -0.1F, 0.0F);
    this.skirtRearModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel[4].addShapeBox(-4.0F, 1.5F, 3.0F, 8, 1, 1, 0.0F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, -0.2F, 0.9F, -0.1F, -0.2F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, -0.3F, 0.9F, -0.1F, 0.0F, 0.9F, -0.1F, 0.0F);
    this.skirtRearModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
