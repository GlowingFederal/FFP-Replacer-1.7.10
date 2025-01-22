package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMunitionsImproved extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelMunitionsImproved() {
    this.bodyModel = new ModelRendererTurbo[31];
    this.leftArmModel = new ModelRendererTurbo[2];
    this.rightArmModel = new ModelRendererTurbo[2];
    this.leftLegModel = new ModelRendererTurbo[5];
    this.rightLegModel = new ModelRendererTurbo[5];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 105, 33, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 105, 33, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, -0.5F, -2.0F, 4, 2, 4, 0.0F, -0.5F, -0.2F, 0.5F, 0.0F, -0.3F, 0.15F, 0.0F, -0.3F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, 0.0F, 1.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.7F, 0.0F, 0.0F, 1.0F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(0.0F, 1.5F, -2.0F, 4, 3, 4, 0.0F, 0.0F, 0.0F, 1.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.7F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 2.0F, -0.3F, -1.0F, 0.6F, -0.3F, -1.0F, 0.8F, 0.0F, 0.0F, 1.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(0.0F, 4.5F, -2.0F, 4, 2, 4, 0.0F, 0.0F, 0.0F, 2.0F, -0.3F, 1.0F, 0.6F, -0.3F, 1.0F, 0.8F, 0.0F, 0.0F, 1.5F, 0.0F, 0.51F, 2.1F, 0.5F, -1.0F, 0.5F, 0.5F, -1.0F, 0.6F, 0.0F, 0.0F, 1.6F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(0.0F, 6.5F, -2.0F, 4, 3, 4, 0.0F, 0.0F, -0.5F, 2.1F, 0.5F, 1.0F, 0.5F, 0.5F, 1.0F, 0.6F, 0.0F, 0.0F, 1.6F, 0.0F, 0.2F, 2.2F, 0.3F, -1.0F, 0.2F, 0.3F, -1.0F, 0.4F, 0.0F, 0.0F, 1.7F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(0.0F, 10.0F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.3F, 2.2F, 0.3F, 1.5F, 0.2F, 0.3F, 1.5F, 0.4F, 0.0F, 0.5F, 1.7F, 0.0F, -0.8F, 2.8F, 0.9F, -1.6F, 0.5F, 0.9F, -1.6F, 0.6F, 0.0F, -0.8F, 2.3F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(0.0F, -1.0F, -3.0F, 1, 2, 4, 0.0F, -0.7F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 1.0F, 0.0F, 0.2F, 1.5F, 0.1F, 0.5F, 0.5F, -0.6F, 0.5F, 0.5F, -0.2F, -1.2F, 1.6F, 0.0F, -1.2F, 1.8F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(0.8F, -1.0F, -3.0F, 1, 2, 4, 0.0F, 0.1F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, 0.0F, 0.2F, 1.5F, 0.0F, 0.2F, 1.0F, -1.6F, -0.3F, 0.5F, 1.1F, -0.3F, 0.5F, 0.2F, -1.4F, 1.8F, 0.0F, -1.2F, 1.6F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(2.5F, -0.5F, -2.0F, 1, 3, 4, 0.0F, -0.2F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.5F, -0.2F, 0.0F, 0.6F, 0.0F, 0.3F, 1.5F, -0.2F, 0.0F, 1.2F, -0.2F, 0.0F, 1.2F, 0.0F, 0.3F, 1.5F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-1.0F, -1.0F, -3.0F, 1, 2, 4, 0.0F, 0.0F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, 0.0F, 0.2F, 1.5F, 0.0F, 0.2F, 1.0F, -0.6F, 0.5F, 0.5F, 0.1F, 0.5F, 0.5F, 0.0F, -1.2F, 1.8F, -0.2F, -1.2F, 1.6F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-1.8F, -1.0F, -3.0F, 1, 2, 4, 0.0F, -0.7F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.0F, 0.2F, 1.0F, 0.0F, 0.2F, 1.5F, 1.1F, -0.3F, 0.5F, -1.6F, -0.3F, 0.5F, 0.0F, -1.2F, 1.6F, 0.2F, -1.4F, 1.8F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(0.0F, 10.5F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.3F, 2.7F, 0.7F, 1.2F, 0.4F, 0.7F, 1.2F, 0.5F, 0.0F, 0.5F, 2.2F, 0.0F, -0.8F, 3.1F, 1.4F, -1.2F, 0.7F, 1.4F, -1.2F, 0.8F, 0.0F, -0.8F, 2.6F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(0.0F, 10.9F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.3F, 2.9F, 1.3F, 0.55F, 0.6F, 1.3F, 0.55F, 0.7F, 0.0F, 0.5F, 2.3F, 0.0F, -0.8F, 3.1F, 1.7F, -0.8F, 0.8F, 1.7F, -0.8F, 0.9F, 0.0F, -0.8F, 2.7F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(0.0F, 11.4F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.3F, 3.0F, 1.5F, 0.55F, 0.6F, 1.5F, 0.55F, 0.7F, 0.0F, 0.5F, 2.5F, 0.0F, -0.7F, 3.2F, 1.9F, -0.7F, 0.8F, 1.9F, -0.7F, 0.9F, 0.0F, -0.7F, 2.7F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(0.0F, 11.9F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.3F, 3.1F, 1.8F, 0.3F, 0.6F, 1.8F, 0.3F, 0.7F, 0.0F, 0.5F, 2.5F, 0.0F, -0.7F, 3.2F, 2.0F, -0.7F, 0.8F, 2.0F, -0.7F, 0.9F, 0.0F, -0.7F, 2.7F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(0.0F, 12.5F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.3F, 3.1F, 1.9F, 0.4F, 0.6F, 1.9F, 0.4F, 0.7F, 0.0F, 0.5F, 2.5F, 0.0F, -0.6F, 3.2F, 2.0F, -0.6F, 0.8F, 2.0F, -0.6F, 0.9F, 0.0F, -0.6F, 2.7F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(0.0F, 13.2F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.3F, 3.1F, 1.9F, 0.4F, 0.6F, 1.9F, 0.4F, 0.7F, 0.0F, 0.5F, 2.5F, 0.0F, -0.6F, 3.2F, 2.0F, -0.6F, 0.8F, 2.0F, -0.6F, 0.9F, 0.0F, -0.6F, 2.7F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(0.0F, 13.7F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.3F, 3.1F, 1.9F, 0.4F, 0.6F, 1.9F, 0.4F, 0.7F, 0.0F, 0.5F, 2.5F, 0.0F, -0.6F, 3.2F, 2.0F, -0.6F, 0.8F, 2.0F, -0.6F, 0.9F, 0.0F, -0.6F, 2.7F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-4.0F, -0.5F, -2.0F, 4, 2, 4, 0.0F, 0.0F, -0.3F, 0.15F, -0.5F, -0.2F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, -0.3F, 0.5F, -0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.0F, -0.2F, 0.0F, 0.7F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(-4.0F, 1.5F, -2.0F, 4, 3, 4, 0.0F, -0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.0F, -0.2F, 0.0F, 0.7F, -0.3F, -1.0F, 0.6F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 1.5F, -0.3F, -1.0F, 0.8F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(-4.0F, 4.5F, -2.0F, 4, 2, 4, 0.0F, -0.3F, 1.0F, 0.6F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 1.5F, -0.3F, 1.0F, 0.8F, 0.5F, -1.0F, 0.5F, 0.0F, 0.51F, 2.1F, 0.0F, 0.0F, 1.6F, 0.5F, -1.0F, 0.6F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(-4.0F, 6.5F, -2.0F, 4, 3, 4, 0.0F, 0.5F, 1.0F, 0.5F, 0.0F, -0.5F, 2.1F, 0.0F, 0.0F, 1.6F, 0.5F, 1.0F, 0.6F, 0.3F, -1.0F, 0.2F, 0.0F, 0.2F, 2.2F, 0.0F, 0.0F, 1.7F, 0.3F, -1.0F, 0.4F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(-4.0F, 10.0F, -2.0F, 4, 1, 4, 0.0F, 0.3F, 1.5F, 0.2F, 0.0F, 0.3F, 2.2F, 0.0F, 0.5F, 1.7F, 0.3F, 1.5F, 0.4F, 0.9F, -1.6F, 0.5F, 0.0F, -0.8F, 2.8F, 0.0F, -0.8F, 2.3F, 0.9F, -1.6F, 0.6F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[23].addShapeBox(-4.0F, 10.5F, -2.0F, 4, 1, 4, 0.0F, 0.7F, 1.2F, 0.4F, 0.0F, 0.3F, 2.7F, 0.0F, 0.5F, 2.2F, 0.7F, 1.2F, 0.5F, 1.4F, -1.2F, 0.7F, 0.0F, -0.8F, 3.1F, 0.0F, -0.8F, 2.6F, 1.4F, -1.2F, 0.8F);
    this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[24].addShapeBox(-4.0F, 10.9F, -2.0F, 4, 1, 4, 0.0F, 1.3F, 0.55F, 0.6F, 0.0F, 0.3F, 2.9F, 0.0F, 0.5F, 2.3F, 1.3F, 0.55F, 0.7F, 1.7F, -0.8F, 0.8F, 0.0F, -0.8F, 3.1F, 0.0F, -0.8F, 2.7F, 1.7F, -0.8F, 0.9F);
    this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[25].addShapeBox(-4.0F, 11.4F, -2.0F, 4, 1, 4, 0.0F, 1.5F, 0.55F, 0.6F, 0.0F, 0.3F, 3.0F, 0.0F, 0.5F, 2.5F, 1.5F, 0.55F, 0.7F, 1.9F, -0.7F, 0.8F, 0.0F, -0.7F, 3.2F, 0.0F, -0.7F, 2.7F, 1.9F, -0.7F, 0.9F);
    this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[26].addShapeBox(-4.0F, 11.9F, -2.0F, 4, 1, 4, 0.0F, 1.8F, 0.3F, 0.6F, 0.0F, 0.3F, 3.1F, 0.0F, 0.5F, 2.5F, 1.8F, 0.3F, 0.7F, 2.0F, -0.7F, 0.8F, 0.0F, -0.7F, 3.2F, 0.0F, -0.7F, 2.7F, 2.0F, -0.7F, 0.9F);
    this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[27].addShapeBox(-4.0F, 12.5F, -2.0F, 4, 1, 4, 0.0F, 1.9F, 0.4F, 0.6F, 0.0F, 0.3F, 3.1F, 0.0F, 0.5F, 2.5F, 1.9F, 0.4F, 0.7F, 2.0F, -0.6F, 0.8F, 0.0F, -0.6F, 3.2F, 0.0F, -0.6F, 2.7F, 2.0F, -0.6F, 0.9F);
    this.bodyModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[28].addShapeBox(-4.0F, 13.2F, -2.0F, 4, 1, 4, 0.0F, 1.9F, 0.4F, 0.6F, 0.0F, 0.3F, 3.1F, 0.0F, 0.5F, 2.5F, 1.9F, 0.4F, 0.7F, 2.0F, -0.6F, 0.8F, 0.0F, -0.6F, 3.2F, 0.0F, -0.6F, 2.7F, 2.0F, -0.6F, 0.9F);
    this.bodyModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[29].addShapeBox(-4.0F, 13.7F, -2.0F, 4, 1, 4, 0.0F, 1.9F, 0.4F, 0.6F, 0.0F, 0.3F, 3.1F, 0.0F, 0.5F, 2.5F, 1.9F, 0.4F, 0.7F, 2.0F, -0.6F, 0.8F, 0.0F, -0.6F, 3.2F, 0.0F, -0.6F, 2.7F, 2.0F, -0.6F, 0.9F);
    this.bodyModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[30].addShapeBox(-3.5F, -0.5F, -2.0F, 1, 3, 4, 0.0F, 0.0F, 0.0F, 0.3F, -0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.6F, 0.0F, 0.0F, 0.5F, -0.2F, 0.0F, 1.2F, 0.0F, 0.3F, 1.5F, 0.0F, 0.3F, 1.5F, -0.2F, 0.0F, 1.2F);
    this.bodyModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, 5.0F, -2.0F, 4, 3, 4, 0.0F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, 5.0F, -2.0F, 4, 3, 4, 0.0F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, -0.9F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F, 0.35F, 0.1F, 0.35F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 65, 25, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F, 0.8F, 0.0F, 1.5F, 1.2F, 0.0F, 0.6F, 1.2F, 0.0F, 0.6F, 0.8F, 0.0F, 1.5F, 0.6F, 0.0F, 1.0F, 1.0F, 0.0F, 0.6F, 1.0F, 0.0F, 0.6F, 0.6F, 0.0F, 1.0F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 4, 1, 4, 0.0F, 0.6F, 0.0F, 1.0F, 1.0F, 0.0F, 0.6F, 1.0F, 0.0F, 0.6F, 0.6F, 0.0F, 1.0F, 0.5F, 0.0F, 0.5F, 0.7F, 0.0F, 0.5F, 0.7F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -0.6F, 0.9F, 0.2F, -0.6F, 0.9F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 5, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 65, 25, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 5, 4, 0.0F, 1.2F, 0.0F, 0.6F, 0.8F, 0.0F, 1.5F, 0.8F, 0.0F, 1.5F, 1.2F, 0.0F, 0.6F, 1.0F, 0.0F, 0.6F, 0.6F, 0.0F, 1.0F, 0.6F, 0.0F, 1.0F, 1.0F, 0.0F, 0.6F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 4, 1, 4, 0.0F, 1.0F, 0.0F, 0.6F, 0.6F, 0.0F, 1.0F, 0.6F, 0.0F, 1.0F, 1.0F, 0.0F, 0.6F, 0.7F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.7F, 0.0F, 0.5F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 5, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -0.6F, 0.9F, 0.2F, -0.6F, 0.9F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.9F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
