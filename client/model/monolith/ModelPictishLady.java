package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPictishLady extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelPictishLady() {
    this.headModel = new ModelRendererTurbo[14];
    this.bodyModel = new ModelRendererTurbo[34];
    this.leftArmModel = new ModelRendererTurbo[2];
    this.rightArmModel = new ModelRendererTurbo[2];
    this.leftLegModel = new ModelRendererTurbo[2];
    this.rightLegModel = new ModelRendererTurbo[2];
    initheadModel_1();
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 81, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 57, 81, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 89, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 73, 41, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 89, 97, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 89, 97, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 73, 41, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 57, 81, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 33, 81, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.1F, -4.0F, 8, 8, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-3.25F, -8.5F, -4.5F, 5, 2, 8, 0.0F, -1.75F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -1.75F, -0.5F, 0.0F, -1.75F, -1.0F, 0.0F, -1.75F, -1.0F, 0.0F, -1.75F, 0.5F, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -3.5F, 2.5F, 8, 6, 2, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-2.5F, -8.5F, -4.5F, 1, 3, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, 2.5F, 2.5F, 8, 4, 2, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.5F, -2.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.5F, -4.5F, -4.5F, 1, 2, 4, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 1.0F, 1.5F, 0.0F, 1.0F, 1.5F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.5F, -8.5F, -4.5F, 1, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-4.5F, -8.5F, -1.5F, 1, 12, 5, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(3.5F, -8.5F, -1.5F, 1, 12, 5, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(3.5F, -4.5F, -4.5F, 1, 2, 4, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 1.0F, 1.5F, 0.0F, 1.0F, 1.5F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(3.5F, -8.5F, -4.5F, 1, 4, 5, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(1.5F, -8.5F, -4.5F, 1, 3, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-1.75F, -8.5F, -4.5F, 5, 2, 8, 0.0F, -1.75F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -1.75F, 0.0F, 0.0F, -1.75F, -1.0F, 0.0F, -1.75F, -0.5F, 0.0F, -1.75F, 0.5F, 0.0F, -1.75F, -1.0F, 0.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-4.0F, -8.5F, 2.5F, 8, 6, 2, 0.0F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.5F, 1.0F, 0.5F, -0.5F, 1.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 65, 25, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 113, 25, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 65, 17, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 113, 33, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 17, 41, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 65, 41, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 81, 41, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 0, 102, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 0, 102, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 0, 102, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 89, 41, this.textureX, this.textureY);
    this.bodyModel[31] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.bodyModel[32] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[33] = new ModelRendererTurbo((ModelBase)this, -26, 102, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 2.0F, -2.0F, 8, 3, 4, 0.0F, -0.5F, -0.1F, -0.1F, -0.5F, -0.1F, -0.1F, -0.5F, -1.0F, -0.5F, -0.5F, -1.0F, -0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, -1.0F, 0.5F, -1.5F, -1.0F, 0.5F, -1.5F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 9.0F, -2.0F, 8, 2, 4, 0.0F, -1.2F, 0.0F, 0.7F, -1.2F, 0.0F, 0.7F, -0.8F, 0.0F, -0.5F, -0.8F, 0.0F, -0.5F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -1.5F, -0.5F, 0.5F, -1.5F, -0.5F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-3.5F, 5.0F, -3.0F, 7, 4, 4, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.7F, 0.0F, -0.2F, -0.7F, 0.0F, -0.2F, -0.7F, 0.0F, 0.5F, -0.7F, 0.0F, 0.5F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-3.0F, 11.0F, -2.0F, 6, 2, 4, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.5F, 0.5F, 0.5F, -0.5F, 0.5F, 0.5F, -2.5F, -0.5F, -1.0F, -2.5F, -0.5F, -1.0F, -2.0F, 0.0F, -1.0F, -2.0F, 0.0F, -1.0F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 3, 4, 0.0F, -1.0F, 0.0F, -1.5F, -1.0F, 0.0F, -1.5F, -0.7F, 0.0F, -0.5F, -0.7F, 0.0F, -0.5F, -0.5F, -0.8F, 0.2F, -0.5F, -0.8F, 0.2F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 10.8F, -2.0F, 4, 3, 4, 0.0F, 0.5F, -0.3F, 0.4F, -0.5F, -0.3F, 0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 0.3F, 1.0F, 0.0F, 0.0F, 0.2F, -0.3F, 0.0F, 0.2F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.0F, 8.8F, -2.0F, 4, 2, 4, 0.0F, -1.0F, 2.0F, -1.0F, -1.0F, 0.0F, 0.0F, -0.3F, 0.0F, -0.5F, -0.8F, 1.0F, -0.8F, 0.5F, 0.3F, 0.4F, -0.5F, 0.3F, 0.0F, 0.0F, 0.0F, 1.0F, 0.5F, -0.3F, 1.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(0.0F, 8.8F, -2.0F, 4, 2, 4, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 2.0F, -1.0F, -0.8F, 1.0F, -0.8F, -0.3F, 0.0F, -0.5F, -0.5F, 0.3F, 0.0F, 0.5F, 0.3F, 0.4F, 0.5F, -0.3F, 1.0F, 0.0F, 0.0F, 1.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(0.0F, 10.8F, -2.0F, 4, 3, 4, 0.0F, -0.5F, -0.3F, 0.0F, 0.5F, -0.3F, 0.4F, 0.5F, 0.3F, 1.0F, 0.0F, 0.0F, 1.0F, -0.3F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-4.0F, 2.2F, -2.21F, 4, 2, 2, 0.0F, -0.5F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -1.9F, 0.2F, 0.0F, -1.7F, 0.2F, -0.5F, -1.2F, -2.0F, -0.5F, -1.2F, -2.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-4.0F, 0.2F, -2.19F, 4, 2, 2, 0.0F, -0.2F, -0.7F, -0.9F, -0.3F, -1.5F, -0.3F, -1.5F, -0.5F, -0.8F, 0.5F, 0.0F, -0.5F, -0.5F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-3.5F, 2.5F, -3.4F, 3, 1, 1, 0.0F, -0.2F, -0.2F, -0.5F, 0.1F, -0.4F, -0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.1F, -0.5F, 0.3F, -0.1F, -0.5F, 0.5F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-3.3F, 2.4F, -3.89F, 3, 1, 1, 0.0F, -0.2F, -0.8F, 0.0F, -0.7F, -1.0F, 0.0F, -0.1F, -0.5F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.5F, 0.0F, -0.4F, 0.5F, 0.0F, 0.1F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-3.3F, 4.39F, -3.9F, 3, 1, 1, 0.0F, 0.0F, 0.5F, 0.0F, -0.4F, 0.5F, 0.0F, 0.1F, 1.0F, 0.0F, 0.2F, 1.0F, 0.0F, -0.2F, 0.1F, 0.3F, -0.9F, 0.0F, 0.3F, -0.5F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-3.5F, 3.29F, -3.4F, 3, 2, 1, 0.0F, 0.0F, -0.1F, -0.5F, 0.3F, -0.1F, -0.5F, 0.5F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, -0.2F, 0.1F, -0.5F, -0.3F, 0.0F, -0.5F, 0.5F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-3.3F, 2.4F, -4.9F, 3, 1, 1, 0.0F, -0.9F, -1.9F, 0.0F, -1.8F, -1.9F, 0.0F, -0.7F, -1.0F, 0.0F, -0.2F, -0.8F, 0.0F, -0.8F, 1.2F, 0.0F, -1.6F, 1.2F, 0.0F, -0.4F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-3.3F, 5.79F, -4.9F, 3, 1, 1, 0.0F, -0.8F, 1.2F, 0.0F, -1.6F, 1.2F, 0.0F, -0.4F, 1.9F, 0.0F, 0.0F, 1.9F, 0.0F, -0.9F, -1.9F, 0.0F, -1.8F, -1.9F, 0.0F, -0.9F, -1.4F, -0.3F, -0.2F, -1.3F, -0.3F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-3.5F, 3.29F, -2.0F, 3, 2, 1, 0.0F, 0.0F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.3F, 1.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, -0.5F, 0.2F, 0.5F, -0.5F, 0.2F, -0.1F, -1.6F, 0.0F, -0.2F, -1.6F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(0.01F, 0.21F, -2.21F, 4, 2, 2, 0.0F, -0.3F, -1.5F, -0.3F, -0.2F, -0.7F, -0.9F, 0.5F, 0.0F, -0.5F, -1.5F, -0.5F, -0.8F, 0.0F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(0.0F, 2.2F, -2.21F, 4, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.3F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.7F, 0.2F, -0.5F, -1.9F, 0.2F, -0.5F, -1.2F, -2.0F, -0.5F, -1.2F, -2.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(0.5F, 2.5F, -3.4F, 3, 1, 1, 0.0F, 0.1F, -0.4F, -0.5F, -0.2F, -0.2F, -0.5F, 0.0F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3F, -0.1F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.5F, 0.2F, 0.5F, -0.5F, 0.2F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(0.3F, 2.4F, -3.89F, 3, 1, 1, 0.0F, -0.7F, -1.0F, 0.0F, -0.2F, -0.8F, 0.0F, 0.0F, -0.3F, 0.0F, -0.1F, -0.5F, 0.0F, -0.4F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.2F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(0.3F, 2.4F, -4.9F, 3, 1, 1, 0.0F, -1.8F, -1.9F, 0.0F, -0.9F, -1.9F, 0.0F, -0.2F, -0.8F, 0.0F, -0.7F, -1.0F, 0.0F, -1.6F, 1.2F, 0.0F, -0.8F, 1.2F, 0.0F, 0.0F, 0.5F, 0.0F, -0.4F, 0.5F, 0.0F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[23].addShapeBox(0.5F, 3.29F, -3.4F, 3, 2, 1, 0.0F, 0.3F, -0.1F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, -0.3F, 0.0F, -0.5F, -0.2F, 0.1F, -0.5F, 0.0F, -0.5F, 0.2F, 0.5F, -0.5F, 0.2F);
    this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[24].addShapeBox(0.3F, 4.39F, -3.9F, 3, 1, 1, 0.0F, -0.4F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.2F, 1.0F, 0.0F, 0.1F, 1.0F, 0.0F, -0.9F, 0.0F, 0.3F, -0.2F, 0.1F, 0.3F, 0.0F, 0.0F, 0.0F, -0.5F, -0.1F, 0.0F);
    this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[25].addShapeBox(0.3F, 5.79F, -4.9F, 3, 1, 1, 0.0F, -1.6F, 1.2F, 0.0F, -0.8F, 1.2F, 0.0F, 0.0F, 1.9F, 0.0F, -0.4F, 1.9F, 0.0F, -1.8F, -1.9F, 0.0F, -0.9F, -1.9F, 0.0F, -0.2F, -1.3F, -0.3F, -0.9F, -1.4F, -0.3F);
    this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[26].addShapeBox(0.5F, 3.29F, -2.0F, 3, 2, 1, 0.0F, 0.5F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 1.0F, 0.5F, 0.3F, 1.0F, 0.5F, 0.5F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, -0.2F, -1.6F, 0.0F, -0.1F, -1.6F, 0.0F);
    this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[27].addShapeBox(-14.5F, -8.0F, -5.5F, 25, 25, 1, 0.0F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F);
    this.bodyModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[28].addShapeBox(-10.5F, -8.0F, -5.5F, 25, 25, 1, 0.0F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F, -11.25F, -11.25F, -0.45F);
    this.bodyModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[29].addShapeBox(-12.5F, -1.5F, -2.8F, 25, 25, 1, 0.0F, -10.25F, -10.25F, -0.1F, -10.25F, -10.25F, -0.1F, -10.25F, -10.25F, -0.45F, -10.25F, -10.25F, -0.45F, -10.25F, -10.25F, -0.65F, -10.25F, -10.25F, -0.65F, -10.25F, -10.25F, -0.25F, -10.25F, -10.25F, -0.25F);
    this.bodyModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[30].addShapeBox(-3.5F, 6.5F, -3.0F, 7, 1, 4, 0.0F, -0.4F, -0.2F, 0.0F, -0.2F, -0.7F, -0.3F, -0.3F, -0.7F, 0.4F, -0.4F, -0.2F, 0.1F, -0.4F, 0.0F, 0.0F, 0.1F, 0.5F, -0.2F, 0.0F, 0.5F, 0.4F, -0.4F, 0.0F, 0.2F);
    this.bodyModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[31].addShapeBox(3.4F, 6.5F, -2.0F, 1, 12, 2, 0.0F, 0.0F, -0.2F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.5F, 0.0F, 0.0F, 0.3F, 0.0F, -3.0F, -0.9F, -5.9F, 3.0F, -1.2F, -5.9F, 3.0F, -2.0F, 5.0F, -3.0F, -1.7F, 5.0F);
    this.bodyModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[32].addShapeBox(-2.5F, 0.0F, -1.0F, 5, 1, 3, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -0.2F, 0.5F, -1.5F, -0.2F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[32].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[33].addShapeBox(-12.5F, -0.6F, 2.3F, 25, 25, 1, 0.0F, -10.25F, -10.25F, -0.45F, -10.25F, -10.25F, -0.45F, -10.25F, -10.25F, -0.1F, -10.25F, -10.25F, -0.1F, -10.25F, -10.25F, -0.25F, -10.25F, -10.25F, -0.25F, -10.25F, -10.25F, -0.65F, -10.25F, -10.25F, -0.65F);
    this.bodyModel[33].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -1.0F, 3, 7, 3, 0.0F, 0.8F, 0.0F, -0.2F, -1.0F, -0.2F, -0.2F, -1.0F, -0.2F, -0.2F, 0.8F, 0.0F, -0.2F, -0.2F, 0.0F, -0.6F, -0.2F, 0.0F, -0.6F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, 4.7F, -0.7F, 3, 6, 3, 0.0F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.6F, -0.5F, 0.8F, 0.0F, -0.5F, 0.8F, 0.0F, 0.0F, -1.8F, -0.6F, 0.0F, -1.8F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-2.0F, -2.0F, -1.0F, 3, 7, 3, 0.0F, -1.0F, -0.2F, -0.2F, 0.8F, 0.0F, -0.2F, 0.8F, 0.0F, -0.2F, -1.0F, -0.2F, -0.2F, -0.2F, 0.0F, -0.6F, -0.2F, 0.0F, -0.6F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-2.0F, 4.7F, -0.7F, 3, 6, 3, 0.0F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, 0.0F, -0.5F, 0.8F, -0.6F, -0.5F, 0.8F, -0.6F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 33, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 1.8F, -2.0F, 4, 3, 4, 0.0F, -0.3F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.2F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 4.8F, -2.0F, 4, 7, 4, 0.0F, -0.2F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.5F, 0.0F, -1.5F, -1.0F, 0.0F, -1.5F, -1.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 1.8F, -2.0F, 4, 3, 4, 0.0F, 0.0F, 0.0F, 0.2F, -0.3F, 0.0F, 0.2F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 4.8F, -2.0F, 4, 7, 4, 0.0F, -0.1F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.2F, -0.1F, 0.0F, -0.2F, -1.0F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
