package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRomaniaWW2body extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelRomaniaWW2body() {
    this.bodyModel = new ModelRendererTurbo[55];
    this.leftArmModel = new ModelRendererTurbo[1];
    this.rightArmModel = new ModelRendererTurbo[1];
    this.leftLegModel = new ModelRendererTurbo[4];
    this.rightLegModel = new ModelRendererTurbo[4];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 97, 17, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 89, 17, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 97, 17, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 121, 17, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 65, 25, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 81, 25, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 97, 25, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 113, 25, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 105, 25, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 41, 33, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.bodyModel[31] = new ModelRendererTurbo((ModelBase)this, 57, 33, this.textureX, this.textureY);
    this.bodyModel[32] = new ModelRendererTurbo((ModelBase)this, 65, 33, this.textureX, this.textureY);
    this.bodyModel[33] = new ModelRendererTurbo((ModelBase)this, 73, 33, this.textureX, this.textureY);
    this.bodyModel[34] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.bodyModel[35] = new ModelRendererTurbo((ModelBase)this, 89, 33, this.textureX, this.textureY);
    this.bodyModel[36] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.bodyModel[37] = new ModelRendererTurbo((ModelBase)this, 105, 33, this.textureX, this.textureY);
    this.bodyModel[38] = new ModelRendererTurbo((ModelBase)this, 113, 33, this.textureX, this.textureY);
    this.bodyModel[39] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[40] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.bodyModel[41] = new ModelRendererTurbo((ModelBase)this, 57, 41, this.textureX, this.textureY);
    this.bodyModel[42] = new ModelRendererTurbo((ModelBase)this, 17, 41, this.textureX, this.textureY);
    this.bodyModel[43] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.bodyModel[44] = new ModelRendererTurbo((ModelBase)this, 73, 41, this.textureX, this.textureY);
    this.bodyModel[45] = new ModelRendererTurbo((ModelBase)this, 89, 41, this.textureX, this.textureY);
    this.bodyModel[46] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[47] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.bodyModel[48] = new ModelRendererTurbo((ModelBase)this, 33, 57, this.textureX, this.textureY);
    this.bodyModel[49] = new ModelRendererTurbo((ModelBase)this, 113, 65, this.textureX, this.textureY);
    this.bodyModel[50] = new ModelRendererTurbo((ModelBase)this, 81, 57, this.textureX, this.textureY);
    this.bodyModel[51] = new ModelRendererTurbo((ModelBase)this, 25, 73, this.textureX, this.textureY);
    this.bodyModel[52] = new ModelRendererTurbo((ModelBase)this, 17, 65, this.textureX, this.textureY);
    this.bodyModel[53] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.bodyModel[54] = new ModelRendererTurbo((ModelBase)this, 113, 33, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.3F, 8.05F, -2.55F, 9, 1, 5, 0.0F, -0.1F, 0.1F, -0.2F, -0.5F, 0.1F, -0.2F, -0.5F, 0.1F, -0.2F, -0.1F, 0.1F, -0.2F, -0.1F, 0.1F, -0.2F, -0.5F, 0.1F, -0.2F, -0.5F, 0.1F, -0.2F, -0.1F, 0.1F, -0.2F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(2.3F, 7.9F, -2.6F, 1, 1, 1, 0.0F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-3.3F, 7.9F, -2.6F, 1, 1, 1, 0.0F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-3.3F, 0.1F, -2.55F, 1, 7, 4, 0.0F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(2.3F, 0.1F, -2.55F, 1, 7, 4, 0.0F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.5F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-3.3F, 5.0F, -2.65F, 1, 1, 2, 0.0F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(2.3F, 5.0F, -2.65F, 1, 1, 2, 0.0F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F, -0.13F, -0.2F, -0.2F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(2.3F, 5.0F, -2.75F, 1, 1, 1, 0.0F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-3.3F, 5.0F, -2.75F, 1, 1, 1, 0.0F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F, -0.25F, -0.3F, -0.25F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-0.5F, 2.7F, 1.5F, 1, 5, 1, 0.0F, -0.15F, -0.9F, -0.2F, -0.15F, -0.9F, -0.2F, -0.15F, -0.9F, -0.2F, -0.15F, -0.9F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F, -0.15F, 0.3F, -0.2F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-0.5F, 3.4F, 1.55F, 1, 1, 1, 0.0F, -0.1F, -0.2F, -0.2F, -0.1F, -0.2F, -0.2F, -0.1F, -0.2F, -0.2F, -0.1F, -0.2F, -0.2F, -0.1F, -0.2F, -0.2F, -0.1F, -0.2F, -0.2F, -0.1F, -0.2F, -0.2F, -0.1F, -0.2F, -0.2F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-0.5F, 3.4F, 1.6F, 1, 1, 1, 0.0F, -0.2F, -0.3F, -0.2F, -0.2F, -0.3F, -0.2F, -0.2F, -0.3F, -0.2F, -0.2F, -0.3F, -0.2F, -0.2F, -0.3F, -0.2F, -0.2F, -0.3F, -0.2F, -0.2F, -0.3F, -0.2F, -0.2F, -0.3F, -0.2F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-0.5F, 8.1F, 1.5F, 1, 1, 1, 0.0F, -0.15F, 0.1F, -0.2F, -0.15F, 0.1F, -0.2F, -0.15F, 0.1F, -0.2F, -0.15F, 0.1F, -0.2F, -0.15F, 0.1F, -0.2F, -0.15F, 0.1F, -0.2F, -0.15F, 0.1F, -0.2F, -0.15F, 0.1F, -0.2F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-0.5F, 1.0F, -2.3F, 1, 1, 1, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(0.0F, 0.0F, -2.4F, 2, 1, 1, 0.0F, -0.75F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, -0.75F, 0.25F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-2.0F, 0.0F, -2.4F, 2, 1, 1, 0.0F, 0.0F, 0.25F, 0.0F, -0.75F, 0.25F, 0.0F, -0.75F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.5F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-0.5F, 2.5F, -2.3F, 1, 1, 1, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-0.5F, 4.25F, -2.3F, 1, 1, 1, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-0.5F, 6.0F, -2.3F, 1, 1, 1, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F, -0.27F, -0.27F, 0.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(-0.5F, 8.0F, -2.2F, 1, 1, 1, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(-3.15F, 0.1F, 0.45F, 3, 3, 2, 0.0F, 0.0F, 0.5F, -0.2F, -2.3F, 0.5F, -0.2F, -2.3F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, -2.75F, 0.5F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, -0.2F, -2.75F, 0.5F, -0.2F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(0.15F, 0.1F, 0.45F, 3, 3, 2, 0.0F, -2.3F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, -2.3F, 0.5F, -0.2F, 0.5F, 0.5F, -0.2F, -2.75F, 0.5F, -0.2F, -2.75F, 0.5F, -0.2F, 0.5F, 0.5F, -0.2F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(-0.95F, 8.05F, -2.6F, 2, 1, 3, 0.0F, -0.25F, 0.11F, -0.2F, -0.25F, 0.11F, -0.2F, -0.25F, 0.11F, -0.2F, -0.25F, 0.11F, -0.2F, -0.25F, 0.11F, -0.2F, -0.25F, 0.11F, -0.2F, -0.25F, 0.11F, -0.2F, -0.25F, 0.11F, -0.2F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[23].addShapeBox(-3.2F, 8.2F, 1.05F, 3, 2, 2, 0.0F, -0.25F, 0.35F, -0.2F, -0.25F, 0.35F, -0.2F, -0.25F, 0.35F, -0.2F, -0.25F, 0.35F, -0.2F, -0.25F, 0.35F, -0.2F, -0.25F, 0.35F, -0.2F, -0.25F, 0.35F, -0.2F, -0.25F, 0.35F, -0.2F);
    this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[24].addShapeBox(-3.2F, 7.7F, 1.1F, 3, 1, 2, 0.0F, -0.23F, 0.0F, -0.2F, -0.23F, 0.0F, -0.2F, -0.23F, 0.0F, -0.2F, -0.23F, 0.0F, -0.2F, -0.23F, -0.2F, -0.2F, -0.23F, -0.2F, -0.2F, -0.23F, -0.2F, -0.2F, -0.23F, -0.2F, -0.2F);
    this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[25].addShapeBox(-2.2F, 8.4F, 2.15F, 1, 1, 1, 0.0F, -0.32F, 0.2F, -0.2F, -0.32F, 0.2F, -0.2F, -0.32F, 0.2F, -0.2F, -0.32F, 0.2F, -0.2F, -0.32F, 0.2F, -0.2F, -0.32F, 0.2F, -0.2F, -0.32F, 0.2F, -0.2F, -0.32F, 0.2F, -0.2F);
    this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[26].addShapeBox(-2.2F, 8.6F, 2.2F, 1, 1, 1, 0.0F, -0.28F, -0.32F, -0.2F, -0.28F, -0.32F, -0.2F, -0.28F, -0.32F, -0.2F, -0.28F, -0.32F, -0.2F, -0.28F, -0.32F, -0.2F, -0.28F, -0.32F, -0.2F, -0.28F, -0.32F, -0.2F, -0.28F, -0.32F, -0.2F);
    this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[27].addShapeBox(-2.2F, 10.4F, 2.0F, 1, 1, 1, 0.0F, -0.2F, 0.35F, -0.2F, -0.2F, 0.35F, -0.2F, -0.2F, 0.35F, -0.2F, -0.2F, 0.35F, -0.2F, -0.1F, 0.35F, -0.2F, -0.1F, 0.35F, -0.2F, -0.1F, 0.35F, -0.2F, -0.1F, 0.35F, -0.2F);
    this.bodyModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[28].addShapeBox(-2.2F, 12.55F, 2.0F, 1, 1, 1, 0.0F, -0.18F, 0.8F, -0.2F, -0.18F, 0.8F, -0.2F, -0.18F, 0.8F, -0.2F, -0.18F, 0.8F, -0.2F, -0.22F, 0.8F, -0.2F, -0.22F, 0.8F, -0.2F, -0.22F, 0.8F, -0.2F, -0.22F, 0.8F, -0.2F);
    this.bodyModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[29].addShapeBox(-2.2F, 14.55F, 2.0F, 1, 1, 1, 0.0F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.15F, -0.8F, -0.2F, -0.15F, -0.8F, -0.2F, -0.15F, -0.8F, -0.2F, -0.15F, -0.8F, -0.2F);
    this.bodyModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[30].addShapeBox(-2.2F, 14.95F, 2.0F, 1, 1, 1, 0.0F, -0.15F, 0.2F, -0.2F, -0.15F, 0.2F, -0.2F, -0.15F, 0.2F, -0.2F, -0.15F, 0.2F, -0.2F, -0.2F, -0.8F, -0.2F, -0.2F, -0.8F, -0.2F, -0.2F, -0.8F, -0.2F, -0.2F, -0.8F, -0.2F);
    this.bodyModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[31].addShapeBox(1.8F, 8.65F, 2.0F, 2, 1, 1, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F);
    this.bodyModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[32].addShapeBox(1.8F, 7.75F, 2.0F, 2, 1, 1, 0.0F, -0.3F, -0.45F, 0.0F, -0.3F, -0.45F, 0.0F, -0.3F, -0.45F, 0.0F, -0.3F, -0.45F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[32].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[33].addShapeBox(1.8F, 7.5F, 2.0F, 2, 1, 1, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F);
    this.bodyModel[33].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[34].addShapeBox(1.8F, 9.1F, 2.0F, 2, 1, 1, 0.0F, 0.0F, -0.45F, 0.0F, 0.0F, -0.45F, 0.0F, 0.0F, -0.45F, 0.0F, 0.0F, -0.45F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F);
    this.bodyModel[34].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[35].addShapeBox(1.8F, 9.8F, 2.0F, 2, 1, 1, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F, -0.6F, -0.3F, 0.0F);
    this.bodyModel[35].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[36].addShapeBox(1.8F, 7.2F, 2.1F, 2, 1, 1, 0.0F, -0.75F, -0.35F, -0.3F, -0.75F, -0.35F, -0.3F, -0.75F, -0.35F, -0.3F, -0.75F, -0.35F, -0.3F, -0.75F, -0.35F, -0.3F, -0.75F, -0.35F, -0.3F, -0.75F, -0.35F, -0.3F, -0.75F, -0.35F, -0.3F);
    this.bodyModel[36].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[37].addShapeBox(1.8F, 6.95F, 2.1F, 2, 1, 1, 0.0F, -0.7F, -0.3F, -0.25F, -0.7F, -0.3F, -0.25F, -0.7F, -0.3F, -0.25F, -0.7F, -0.3F, -0.25F, -0.7F, -0.3F, -0.25F, -0.7F, -0.3F, -0.25F, -0.7F, -0.3F, -0.25F, -0.7F, -0.3F, -0.25F);
    this.bodyModel[37].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[38].addShapeBox(-0.5F, 1.0F, -2.25F, 1, 11, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.1F, 0.0F, 0.0F, -3.1F, 0.0F, 0.0F, -3.1F, 0.0F, 0.0F, -3.1F, 0.0F);
    this.bodyModel[38].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[39].addShapeBox(-4.0F, -0.1F, -2.0F, 4, 1, 4, 0.0F, 0.1F, 0.0F, 0.1F, -1.5F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.bodyModel[39].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[40].addShapeBox(-4.0F, 0.9F, -2.0F, 8, 11, 4, 0.0F, 0.1F, -0.1F, 0.2F, 0.1F, -0.1F, 0.2F, 0.1F, -0.1F, 0.2F, 0.1F, -0.1F, 0.2F, 0.1F, -3.0F, 0.0F, 0.1F, -3.0F, 0.0F, 0.1F, -3.0F, 0.0F, 0.1F, -3.0F, 0.0F);
    this.bodyModel[40].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[41].addShapeBox(0.0F, -0.1F, -2.0F, 4, 1, 4, 0.0F, -1.5F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F);
    this.bodyModel[41].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[42].addShapeBox(-3.9F, 7.0F, -2.3F, 3, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[42].func_78793_a(0.0F, -5.0F, 0.0F);
    this.bodyModel[43].func_78790_a(-3.9F, 8.0F, -2.25F, 3, 2, 1, 0.0F);
    this.bodyModel[43].func_78793_a(0.0F, -5.0F, 0.0F);
    this.bodyModel[44].func_78790_a(0.9F, 7.0F, -2.3F, 3, 1, 1, 0.0F);
    this.bodyModel[44].func_78793_a(0.0F, -5.0F, 0.0F);
    this.bodyModel[45].func_78790_a(0.9F, 8.0F, -2.25F, 3, 2, 1, 0.0F);
    this.bodyModel[45].func_78793_a(0.0F, -5.0F, 0.0F);
    this.bodyModel[46].addShapeBox(-1.5F, -0.09F, -2.05F, 3, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.14F, 0.0F, 0.0F, 3.14F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[46].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[47].addShapeBox(2.37F, 8.3F, 2.27F, 12, 6, 1, 0.0F, 0.0F, -0.2F, -0.22F, -11.15F, -0.2F, -0.22F, -11.15F, -0.2F, -0.22F, 0.0F, -0.2F, -0.22F, 0.0F, -5.25F, -0.22F, -11.15F, -5.25F, -0.22F, -11.15F, -5.25F, -0.22F, 0.0F, -5.25F, -0.22F);
    this.bodyModel[47].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[48].addShapeBox(-2.13F, 9.5F, 2.12F, 12, 6, 1, 0.0F, 0.0F, -0.2F, -0.22F, -11.15F, -0.2F, -0.22F, -11.15F, -0.2F, -0.22F, 0.0F, -0.2F, -0.22F, 0.0F, -5.25F, -0.22F, -11.15F, -5.25F, -0.22F, -11.15F, -5.25F, -0.22F, 0.0F, -5.25F, -0.22F);
    this.bodyModel[48].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[49].addShapeBox(-4.0F, 8.0F, -3.25F, 4, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, 0.0F, -0.75F, -0.5F, 0.0F, -0.75F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F);
    this.bodyModel[49].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[50].addShapeBox(-4.0F, 8.1F, -3.45F, 4, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, -0.5F, 0.0F, -0.75F, -0.5F, 0.0F, -0.75F, -0.5F, -0.75F, 0.0F, -0.5F, -0.75F);
    this.bodyModel[50].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[51].addShapeBox(0.8F, 8.0F, -3.25F, 4, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, 0.0F, -0.75F, -0.5F, 0.0F, -0.75F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F);
    this.bodyModel[51].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[52].addShapeBox(0.8F, 8.1F, -3.45F, 4, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, -0.5F, 0.0F, -0.75F, -0.5F, 0.0F, -0.75F, -0.5F, -0.75F, 0.0F, -0.5F, -0.75F);
    this.bodyModel[52].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[53].addShapeBox(-4.0F, 5.9F, -2.0F, 8, 11, 4, 0.0F, 0.1F, -3.0F, 0.1F, 0.1F, -3.0F, 0.1F, 0.1F, -3.0F, 0.1F, 0.1F, -3.0F, 0.1F, 0.3F, -3.1F, 0.5F, 0.3F, -3.1F, 0.5F, 0.3F, -3.1F, 0.5F, 0.3F, -3.1F, 0.5F);
    this.bodyModel[53].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[54].addShapeBox(-0.5F, 9.0F, -2.25F, 1, 11, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -6.1F, 0.5F, 0.0F, -6.1F, 0.5F, 0.0F, -6.1F, 0.0F, 0.0F, -6.1F, 0.0F);
    this.bodyModel[54].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.1F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 89, 57, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.1F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F, 0.1F, 2.0F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 105, 49, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 49, 65, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 73, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 57, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 6, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 10.0F, -3.0F, 4, 2, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 4, 4, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 2.9F, -2.0F, 4, 6, 4, 0.0F, 0.2F, -2.5F, 0.2F, 0.2F, -2.5F, 0.2F, 0.2F, -2.5F, 0.2F, 0.2F, -2.5F, 0.2F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 57, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 65, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 65, 73, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 57, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, -0.1F, -2.0F, 4, 6, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 10.0F, -3.0F, 4, 2, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 4, 4, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 2.9F, -2.0F, 4, 6, 4, 0.0F, 0.2F, -2.5F, 0.2F, 0.2F, -2.5F, 0.2F, 0.2F, -2.5F, 0.2F, 0.2F, -2.5F, 0.2F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
