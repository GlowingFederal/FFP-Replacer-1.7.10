package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMuromachiDou extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelMuromachiDou() {
    this.bodyModel = new ModelRendererTurbo[51];
    this.leftArmModel = new ModelRendererTurbo[6];
    this.rightArmModel = new ModelRendererTurbo[6];
    this.leftLegModel = new ModelRendererTurbo[6];
    this.rightLegModel = new ModelRendererTurbo[6];
    this.skirtFrontModel = new ModelRendererTurbo[3];
    this.skirtRearModel = new ModelRendererTurbo[3];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
    initskirtFrontModel_1();
    initskirtRearModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 77, 61, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 73, 9, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 97, 17, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 25, 38, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 25, 38, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 25, 38, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 25, 38, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[31] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[32] = new ModelRendererTurbo((ModelBase)this, 97, 17, this.textureX, this.textureY);
    this.bodyModel[33] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.bodyModel[34] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[35] = new ModelRendererTurbo((ModelBase)this, 73, 9, this.textureX, this.textureY);
    this.bodyModel[36] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[37] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[38] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[39] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[40] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[41] = new ModelRendererTurbo((ModelBase)this, 77, 61, this.textureX, this.textureY);
    this.bodyModel[42] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[43] = new ModelRendererTurbo((ModelBase)this, 77, 61, this.textureX, this.textureY);
    this.bodyModel[44] = new ModelRendererTurbo((ModelBase)this, 77, 61, this.textureX, this.textureY);
    this.bodyModel[45] = new ModelRendererTurbo((ModelBase)this, 77, 61, this.textureX, this.textureY);
    this.bodyModel[46] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.bodyModel[47] = new ModelRendererTurbo((ModelBase)this, 25, 38, this.textureX, this.textureY);
    this.bodyModel[48] = new ModelRendererTurbo((ModelBase)this, 25, 38, this.textureX, this.textureY);
    this.bodyModel[49] = new ModelRendererTurbo((ModelBase)this, 25, 38, this.textureX, this.textureY);
    this.bodyModel[50] = new ModelRendererTurbo((ModelBase)this, 25, 38, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 10.0F, -2.5F, 8, 1, 5, 0.0F, 0.6F, -0.1F, 0.3F, 0.6F, -0.1F, 0.3F, 0.6F, -0.1F, 0.3F, 0.6F, -0.1F, 0.3F, 0.6F, -0.1F, 0.3F, 0.6F, -0.1F, 0.3F, 0.6F, -0.1F, 0.3F, 0.6F, -0.1F, 0.3F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-3.5F, 0.5F, -2.5F, 2, 1, 5, 0.0F, 0.8F, 0.2F, 0.0F, -2.2F, 0.2F, 0.0F, -2.2F, 0.2F, 0.0F, 0.8F, 0.2F, 0.0F, -0.5F, 0.5F, 0.2F, -1.0F, 0.5F, 0.2F, -1.0F, 0.7F, 0.2F, -0.5F, 0.7F, 0.2F);
    this.bodyModel[1].func_78793_a(0.0F, -1.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 2.5F, -2.8F, 8, 1, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 2.5F, -3.0F, 24, 1, 1, 0.0F, -0.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 3.75F, -2.8F, 8, 1, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.5F, 5.0F, -3.0F, 27, 1, 1, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.5F, 5.0F, -2.8F, 9, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-4.5F, 6.25F, -2.8F, 9, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-4.5F, 7.5F, -2.8F, 9, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-4.5F, 8.75F, -2.8F, 9, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-4.0F, 1.7F, -3.1F, 8, 1, 1, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-4.0F, 1.4F, -3.0F, 8, 1, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-4.0F, 0.4F, -3.0F, 2, 1, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(3.8F, 5.0F, -3.0F, 1, 1, 6, 0.0F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(3.8F, 6.25F, -3.0F, 1, 1, 6, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(3.8F, 7.5F, -3.0F, 1, 1, 6, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(3.8F, 8.75F, -3.0F, 1, 1, 6, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-0.5F, 10.0F, -2.9F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(1.5F, 0.5F, -2.5F, 2, 1, 5, 0.0F, -2.2F, 0.2F, 0.0F, 0.8F, 0.2F, 0.0F, 0.8F, 0.2F, 0.0F, -2.2F, 0.2F, 0.0F, -1.0F, 0.5F, 0.2F, -0.5F, 0.5F, 0.2F, -0.5F, 0.7F, 0.2F, -1.0F, 0.7F, 0.2F);
    this.bodyModel[18].func_78793_a(0.0F, -1.0F, 0.0F);
    this.bodyModel[19].addShapeBox(2.0F, 0.4F, -3.0F, 2, 1, 1, 0.0F, -0.8F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(-4.8F, 5.0F, -3.0F, 1, 1, 6, 0.0F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(-4.8F, 6.25F, -3.0F, 1, 1, 6, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(-4.8F, 7.5F, -3.0F, 1, 1, 6, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[23].addShapeBox(-4.8F, 8.75F, -3.0F, 1, 1, 6, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F, 0.0F, 0.25F, -0.2F);
    this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[24].addShapeBox(-5.0F, 5.0F, -3.0F, 1, 1, 18, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F);
    this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[25].addShapeBox(-5.0F, 6.25F, -3.0F, 1, 1, 18, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F);
    this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[26].addShapeBox(-4.5F, 6.25F, -3.0F, 27, 1, 1, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[27].addShapeBox(-5.0F, 7.5F, -3.0F, 1, 1, 18, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F);
    this.bodyModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[28].addShapeBox(-4.5F, 7.5F, -3.0F, 27, 1, 1, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.bodyModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[29].addShapeBox(-5.0F, 8.75F, -3.0F, 1, 1, 18, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F);
    this.bodyModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[30].addShapeBox(-4.5F, 8.75F, -3.0F, 27, 1, 1, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.bodyModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[31].addShapeBox(-4.0F, 2.5F, 1.8F, 8, 1, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F);
    this.bodyModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[32].addShapeBox(-4.5F, 8.75F, 1.8F, 9, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F);
    this.bodyModel[32].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[33].addShapeBox(-4.5F, 7.5F, 1.8F, 9, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F);
    this.bodyModel[33].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[34].addShapeBox(-4.5F, 6.25F, 1.8F, 9, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F);
    this.bodyModel[34].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[35].addShapeBox(-4.5F, 5.0F, 1.8F, 9, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F);
    this.bodyModel[35].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[36].addShapeBox(-4.0F, 3.75F, 1.8F, 8, 1, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F);
    this.bodyModel[36].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[37].addShapeBox(-4.5F, 8.75F, 2.0F, 27, 1, 1, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.bodyModel[37].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[38].addShapeBox(-4.5F, 7.5F, 2.0F, 27, 1, 1, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.bodyModel[38].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[39].addShapeBox(-4.5F, 6.25F, 2.0F, 27, 1, 1, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.bodyModel[39].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[40].addShapeBox(-4.5F, 5.0F, 2.0F, 27, 1, 1, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, -17.7F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.bodyModel[40].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[41].addShapeBox(-4.0F, 3.75F, 2.0F, 24, 1, 1, 0.0F, -0.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.bodyModel[41].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[42].addShapeBox(-4.0F, 1.25F, 1.8F, 8, 1, 1, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.1F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F, -0.2F, 0.25F, 0.0F);
    this.bodyModel[42].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[43].addShapeBox(-4.0F, 2.5F, 2.0F, 24, 1, 1, 0.0F, -0.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.bodyModel[43].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[44].addShapeBox(-4.0F, 1.25F, 2.0F, 24, 1, 1, 0.0F, -0.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.bodyModel[44].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[45].addShapeBox(-4.0F, 3.75F, -3.0F, 24, 1, 1, 0.0F, -0.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -16.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.bodyModel[45].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[46].addShapeBox(-4.0F, 0.4F, 1.9F, 8, 1, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.bodyModel[46].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[47].addShapeBox(4.0F, 8.75F, -3.0F, 1, 1, 18, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F);
    this.bodyModel[47].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[48].addShapeBox(4.0F, 5.0F, -3.0F, 1, 1, 18, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F);
    this.bodyModel[48].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[49].addShapeBox(4.0F, 6.25F, -3.0F, 1, 1, 18, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F);
    this.bodyModel[49].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[50].addShapeBox(4.0F, 7.5F, -3.0F, 1, 1, 18, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -12.1F, 0.0F, 0.0F, -12.1F);
    this.bodyModel[50].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.leftArmModel[4] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.leftArmModel[5] = new ModelRendererTurbo((ModelBase)this, 89, 9, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -3.5F, -2.5F, 1, 1, 5, 0.0F, -0.4F, 0.2F, -0.15F, 0.0F, 0.2F, -0.15F, 0.0F, 0.2F, -0.15F, -0.4F, 0.2F, -0.15F, -0.2F, 0.2F, -0.15F, -0.2F, 0.2F, -0.15F, -0.2F, 0.2F, -0.15F, -0.2F, 0.2F, -0.15F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(0.0F, -3.0F, -2.5F, 1, 1, 5, 0.0F, 0.25F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.25F, -0.2F, -0.2F, 0.25F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.25F, -0.2F, -0.2F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(0.0F, -3.2F, -2.5F, 1, 1, 5, 0.0F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(1.2F, -3.2F, -2.5F, 1, 1, 5, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[4].addShapeBox(1.5F, -3.0F, -2.5F, 1, 1, 5, 0.0F, 0.25F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.25F, -0.2F, -0.1F, 0.25F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.25F, -0.2F, -0.1F);
    this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[5].addShapeBox(2.5F, -3.0F, -2.5F, 1, 1, 5, 0.0F, 0.0F, -0.1F, 0.0F, 0.25F, -0.5F, 0.1F, 0.25F, -0.5F, 0.1F, 0.0F, -0.1F, 0.0F, 0.0F, -0.2F, 0.0F, 0.25F, 0.2F, 0.1F, 0.25F, 0.2F, 0.1F, 0.0F, -0.2F, 0.0F);
    this.leftArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.rightArmModel[4] = new ModelRendererTurbo((ModelBase)this, 89, 9, this.textureX, this.textureY);
    this.rightArmModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-1.0F, -3.0F, -2.5F, 1, 1, 5, 0.0F, 0.25F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.25F, -0.2F, -0.2F, 0.25F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.25F, -0.2F, -0.2F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-1.0F, -3.2F, -2.5F, 1, 1, 5, 0.0F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-2.25F, -3.2F, -2.5F, 1, 1, 5, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-2.25F, -3.0F, -2.5F, 1, 1, 5, 0.0F, 0.25F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.25F, -0.2F, -0.1F, 0.25F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -0.1F, 0.25F, -0.2F, -0.1F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].addShapeBox(-3.5F, -3.0F, -2.5F, 1, 1, 5, 0.0F, 0.25F, -0.5F, 0.1F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.25F, -0.5F, 0.1F, 0.25F, 0.2F, 0.1F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.25F, 0.2F, 0.1F);
    this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[5].addShapeBox(0.0F, -3.5F, -2.5F, 1, 1, 5, 0.0F, 0.0F, 0.2F, -0.15F, -0.4F, 0.2F, -0.15F, -0.4F, 0.2F, -0.15F, 0.0F, 0.2F, -0.15F, -0.2F, 0.2F, -0.15F, -0.2F, 0.2F, -0.15F, -0.2F, 0.2F, -0.15F, -0.2F, 0.2F, -0.15F);
    this.rightArmModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.leftLegModel[5] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.3F, 0.45F, -3.9F, 7, 1, 1, 0.0F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.2F, -1.8F, 0.0F, 0.2F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.3F, -0.8F, -3.3F, 7, 1, 1, 0.0F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-1.0F, -1.5F, -2.6F, 4, 4, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.2F, -0.2F, 1.2F, 0.0F, -0.4F, 1.2F, 0.0F, -0.4F, -1.1F, -0.2F, -0.2F, -1.1F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-1.0F, -1.5F, 1.6F, 4, 4, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.2F, -0.2F, -1.1F, 0.0F, -0.4F, -1.1F, 0.0F, -0.4F, 1.2F, -0.2F, -0.2F, 1.2F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-2.3F, 0.45F, 2.9F, 7, 1, 1, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.2F, -1.8F, 0.0F, 0.2F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[5].addShapeBox(-2.3F, -0.8F, 2.3F, 7, 1, 1, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.2F);
    this.leftLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.rightLegModel[5] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-3.0F, -1.5F, -2.6F, 4, 4, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.4F, 1.2F, -0.2F, -0.2F, 1.2F, -0.2F, -0.2F, -1.1F, 0.0F, -0.4F, -1.1F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-4.7F, -0.8F, -3.3F, 7, 1, 1, 0.0F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-4.7F, 0.45F, -3.9F, 7, 1, 1, 0.0F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.2F, -1.8F, 0.0F, 0.2F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-3.0F, -1.5F, 1.6F, 4, 4, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, -0.4F, -1.1F, -0.2F, -0.2F, -1.1F, -0.2F, -0.2F, 1.2F, 0.0F, -0.4F, 1.2F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-4.7F, 0.45F, 2.9F, 7, 1, 1, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.2F, -1.8F, 0.0F, 0.2F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[5].addShapeBox(-4.7F, -0.8F, 2.3F, 7, 1, 1, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.2F);
    this.rightLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.skirtFrontModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.skirtFrontModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-2.0F, -1.3F, -2.8F, 4, 4, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.2F, 0.0F, 1.7F, -0.2F, 0.0F, 1.7F, -0.2F, 0.0F, -1.6F, -0.2F, 0.0F, -1.6F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[1].addShapeBox(-3.5F, -0.6F, -3.7F, 7, 1, 1, 0.0F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F);
    this.skirtFrontModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[2].addShapeBox(-3.5F, 0.65F, -4.3F, 7, 1, 1, 0.0F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.2F, -1.8F, 0.0F, 0.2F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F);
    this.skirtFrontModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.skirtRearModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.skirtRearModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-2.0F, -1.3F, 1.8F, 4, 4, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.2F, 0.0F, -1.6F, -0.2F, 0.0F, -1.6F, -0.2F, 0.0F, 1.7F, -0.2F, 0.0F, 1.7F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel[1].addShapeBox(-3.5F, -0.6F, 2.7F, 7, 1, 1, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, -0.2F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.2F, -2.0F, 0.0F, 0.2F);
    this.skirtRearModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel[2].addShapeBox(-3.5F, 0.65F, 3.3F, 7, 1, 1, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, -0.2F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, 0.2F, -1.8F, 0.0F, 0.2F);
    this.skirtRearModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
