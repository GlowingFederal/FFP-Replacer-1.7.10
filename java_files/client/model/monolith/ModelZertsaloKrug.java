package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelZertsaloKrug extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelZertsaloKrug() {
    this.bodyModel = new ModelRendererTurbo[27];
    this.leftArmModel = new ModelRendererTurbo[4];
    this.rightArmModel = new ModelRendererTurbo[4];
    this.leftLegModel = new ModelRendererTurbo[1];
    this.rightLegModel = new ModelRendererTurbo[1];
    this.skirtFrontModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
    initskirtFrontModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 89, 9, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 73, 17, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 97, 17, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 113, 17, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 57, 33, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 105, 33, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 9, 41, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 49, 57, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 41, 73, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.5F, 4.8F, -2.5F, 9, 6, 5, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, 1.0F, 0.15F, 0.0F, 1.0F, 0.15F, 0.0F, 1.0F, 0.15F, 0.0F, 1.0F, 0.15F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 10.55F, -2.0F, 4, 1, 4, 0.0F, 0.6F, -0.2F, 0.8F, 4.6F, -0.2F, 0.8F, 4.6F, -0.2F, 0.8F, 0.6F, -0.2F, 0.8F, 0.6F, -0.2F, 0.8F, 4.6F, -0.2F, 0.8F, 4.6F, -0.2F, 0.8F, 0.6F, -0.2F, 0.8F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.5F, -0.2F, -2.5F, 9, 5, 5, 0.0F, 0.0F, 0.2F, 0.15F, 0.0F, 0.2F, 0.15F, 0.0F, 0.2F, 0.15F, 0.0F, 0.2F, 0.15F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.5F, 6.0F, -3.7F, 9, 2, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.5F, 2.5F, -3.7F, 9, 2, 1, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.5F, 4.0F, -3.7F, 9, 2, 1, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.5F, 8.0F, -3.7F, 9, 2, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-4.5F, 9.5F, -3.7F, 9, 2, 1, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-1.5F, 6.5F, -3.9F, 3, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-1.5F, 5.5F, -3.9F, 3, 1, 1, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-1.5F, 7.5F, -3.9F, 3, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-1.5F, 0.2F, -3.5F, 3, 3, 1, 0.0F, 0.7F, 0.0F, -0.4F, 0.7F, 0.0F, -0.4F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-4.5F, -0.8F, -3.5F, 5, 4, 7, 0.0F, 1.0F, -0.1F, -0.7F, -3.2F, 0.4F, -0.7F, -3.2F, 0.4F, -0.7F, 1.0F, -0.1F, -0.7F, -1.0F, 1.5F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.0F, 1.5F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-4.5F, 9.5F, 2.7F, 9, 2, 1, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-1.5F, 7.5F, 2.9F, 3, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-1.5F, -0.8F, 2.5F, 3, 4, 1, 0.0F, 1.2F, 0.4F, 1.0F, 1.2F, 0.4F, 1.0F, 1.2F, 0.4F, -0.7F, 1.2F, 0.4F, -0.7F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-2.5F, -1.2F, -1.5F, 5, 1, 3, 0.0F, 0.0F, 0.2F, 0.15F, 0.0F, 0.2F, 0.15F, 0.0F, 0.2F, 0.15F, 0.0F, 0.2F, 0.15F, 0.3F, -0.2F, 1.2F, 0.3F, -0.2F, 1.2F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-4.5F, 8.0F, 2.7F, 9, 2, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-4.5F, 6.0F, 2.7F, 9, 2, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(-4.5F, 4.0F, 2.7F, 9, 2, 1, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -1.2F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(-4.5F, 2.5F, 2.7F, 9, 2, 1, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -3.5F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F, -1.2F, -0.3F, 0.0F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(-1.5F, 6.5F, 2.9F, 3, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(-1.5F, 5.5F, 2.9F, 3, 1, 1, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[23].addShapeBox(-0.5F, -0.8F, -3.5F, 5, 4, 7, 0.0F, -3.2F, 0.4F, -0.7F, 1.0F, -0.1F, -0.7F, 1.0F, -0.1F, -0.7F, -3.2F, 0.4F, -0.7F, -1.5F, 0.0F, 0.0F, -1.0F, 1.5F, 0.0F, -1.0F, 1.5F, 0.0F, -1.5F, 0.0F, 0.0F);
    this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[24].addShapeBox(-5.5F, 5.2F, -3.0F, 15, 10, 6, 0.0F, 0.2F, 0.0F, 0.4F, -3.8F, 0.0F, 0.4F, -3.8F, 0.0F, 0.4F, 0.2F, 0.0F, 0.4F, -0.7F, -5.0F, 0.3F, -4.7F, -5.0F, 0.3F, -4.7F, -5.0F, 0.3F, -0.7F, -5.0F, 0.3F);
    this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[25].addShapeBox(-5.0F, 2.2F, -3.0F, 14, 3, 6, 0.0F, -0.7F, 0.0F, 0.0F, -4.7F, 0.0F, 0.0F, -4.7F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, 0.4F, 0.0F, 0.3F, -3.6F, 0.0F, 0.3F, -3.6F, 0.0F, 0.3F, 0.4F, 0.0F, 0.3F);
    this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[26].addShapeBox(-5.0F, 10.2F, -3.0F, 14, 2, 6, 0.0F, -0.4F, 0.0F, 0.0F, -4.4F, 0.0F, 0.0F, -4.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.3F, 0.0F, 0.4F, -3.7F, 0.0F, 0.4F, -3.7F, 0.0F, 0.4F, 0.3F, 0.0F, 0.4F);
    this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 81, 41, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-5.0F, 4.5F, -2.0F, 8, 4, 8, 0.0F, -3.4F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, -3.4F, -3.4F, 0.0F, -3.4F, -3.7F, 0.5F, 0.3F, 0.3F, 0.5F, 0.3F, 0.3F, 0.5F, -3.8F, -3.7F, 0.5F, -3.7F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 0.3F, 0.6F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.3F, 0.6F, 0.3F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(3.0F, 4.0F, -2.0F, 1, 5, 4, 0.0F, -0.5F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.0F, 0.2F, -0.2F, -0.4F, 0.2F, -0.2F, -0.4F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(3.0F, 0.6F, -2.0F, 1, 3, 4, 0.0F, -1.2F, 0.2F, -0.5F, 0.4F, 0.2F, -0.5F, 0.4F, 0.2F, -0.5F, -1.2F, 0.2F, -0.5F, -0.5F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 81, 41, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 0.3F, 0.3F, 0.3F, 0.3F, 0.6F, 0.3F, 0.3F, 0.6F, 0.3F, 0.3F, 0.3F, 0.3F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F, 0.5F, 0.4F, 0.5F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-4.0F, 4.0F, -2.0F, 1, 5, 4, 0.0F, 0.0F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.4F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, -0.4F, 0.2F, -0.2F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-4.0F, 0.6F, -2.0F, 1, 3, 4, 0.0F, 0.4F, 0.2F, -0.5F, -1.2F, 0.2F, -0.5F, -1.2F, 0.2F, -0.5F, 0.4F, 0.2F, -0.5F, 0.0F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-3.0F, 4.5F, -2.0F, 8, 4, 8, 0.0F, 0.6F, 0.0F, 0.6F, -3.4F, 0.0F, 0.6F, -3.4F, 0.0F, -3.4F, 0.6F, 0.0F, -3.4F, 0.3F, 0.5F, 0.3F, -3.7F, 0.5F, 0.3F, -3.7F, 0.5F, -3.7F, 0.3F, 0.5F, -3.8F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 4.8F, -2.0F, 8, 5, 8, 0.0F, 0.7F, 0.2F, 0.7F, -3.3F, 0.2F, 0.7F, -3.3F, 0.2F, -3.3F, 0.7F, 0.2F, -3.3F, 0.4F, 1.0F, 0.4F, -3.6F, 1.0F, 0.4F, -3.6F, 1.0F, -3.6F, 0.4F, 1.0F, -3.6F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 4.8F, -2.0F, 8, 5, 8, 0.0F, 0.7F, 0.2F, 0.7F, -3.3F, 0.2F, 0.7F, -3.3F, 0.2F, -3.3F, 0.7F, 0.2F, -3.3F, 0.4F, 1.0F, 0.4F, -3.6F, 1.0F, 0.4F, -3.6F, 1.0F, -3.6F, 0.4F, 1.0F, -3.6F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, -1.5F, -2.0F, 8, 12, 2, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.5F, 0.0F, 0.5F, 2.0F, -6.0F, 1.8F, 2.0F, -6.0F, 1.8F, 2.0F, -5.9F, 1.8F, 2.0F, -5.9F, 1.8F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
