package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPASGTnude extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 128;
  
  public ModelPASGTnude() {
    this.headModel = new ModelRendererTurbo[32];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 17, 41, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.headModel[21] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.headModel[22] = new ModelRendererTurbo((ModelBase)this, 9, 49, this.textureX, this.textureY);
    this.headModel[23] = new ModelRendererTurbo((ModelBase)this, 33, 49, this.textureX, this.textureY);
    this.headModel[24] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.headModel[25] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.headModel[26] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.headModel[27] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.headModel[28] = new ModelRendererTurbo((ModelBase)this, 9, 33, this.textureX, this.textureY);
    this.headModel[29] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.headModel[30] = new ModelRendererTurbo((ModelBase)this, 57, 57, this.textureX, this.textureY);
    this.headModel[31] = new ModelRendererTurbo((ModelBase)this, 17, 65, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(2.0F, -9.0F, -4.0F, 2, 2, 8, 0.0F, 0.5F, -0.1F, -0.2F, 0.0F, -0.3F, -0.5F, 0.3F, -1.0F, 0.7F, 0.5F, -0.7F, 1.0F, 0.0F, -0.5F, 0.8F, 0.3F, -0.5F, 0.3F, 0.7F, 1.3F, 1.2F, 0.0F, 1.3F, 1.5F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(2.0F, -10.0F, -4.0F, 2, 1, 8, 0.0F, 0.5F, -0.1F, -2.5F, -0.8F, -0.5F, -2.7F, -0.7F, -0.8F, -1.5F, 0.5F, -0.4F, -1.0F, 0.5F, 0.1F, -0.2F, 0.0F, 0.3F, -0.5F, 0.3F, 1.0F, 0.7F, 0.5F, 0.7F, 1.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-1.0F, -9.0F, -4.0F, 2, 2, 8, 0.0F, 0.5F, -0.1F, -0.2F, 0.5F, -0.1F, -0.2F, 0.5F, -0.7F, 1.0F, 0.5F, -0.7F, 1.0F, 1.0F, -0.5F, 0.8F, 1.0F, -0.5F, 0.8F, 1.0F, 1.3F, 1.5F, 1.0F, 1.3F, 1.5F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-1.0F, -6.5F, -4.0F, 2, 2, 8, 0.0F, 1.0F, 1.0F, 0.8F, 1.0F, 1.0F, 0.8F, 1.0F, -0.8F, 1.5F, 1.0F, -0.8F, 1.5F, 1.0F, -1.0F, 1.2F, 1.0F, -1.0F, 1.2F, 0.5F, 2.0F, 1.5F, 0.5F, 2.0F, 1.5F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-1.0F, -5.4F, -5.0F, 2, 1, 3, 0.0F, 1.0F, 0.1F, 0.2F, 1.0F, 0.1F, 0.2F, 0.9F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, -0.5F, 1.2F, 1.0F, -0.5F, 1.2F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-1.5F, -10.0F, -4.0F, 3, 1, 8, 0.0F, 0.0F, -0.1F, -2.5F, 0.0F, -0.1F, -2.5F, 0.0F, -0.4F, -1.0F, 0.0F, -0.4F, -1.0F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.7F, 1.0F, 0.0F, 0.7F, 1.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-5.0F, -0.8F, -4.1F, 10, 1, 1, 0.0F, -0.8F, -0.4F, 0.0F, -0.8F, -0.4F, 0.0F, -0.8F, -0.4F, 0.0F, -0.8F, -0.4F, 0.0F, -1.0F, -0.1F, 0.0F, -1.0F, -0.1F, 0.0F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(4.9F, -5.0F, -0.5F, 1, 5, 1, 0.0F, -0.2F, -1.8F, -0.8F, -0.5F, -2.0F, -0.8F, -0.5F, -2.0F, 0.5F, 0.0F, -2.1F, 0.5F, 1.2F, -0.4F, 3.5F, -1.8F, -0.4F, 3.5F, -1.8F, -0.2F, -3.7F, 1.2F, -0.2F, -3.7F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(3.0F, -6.5F, -4.0F, 1, 2, 3, 0.0F, 1.0F, 1.0F, 0.8F, 0.3F, 1.0F, 0.3F, 0.4F, 0.47F, -0.5F, 1.0F, 0.5F, -0.5F, 1.0F, -1.0F, 1.2F, 0.5F, -1.0F, 0.5F, 0.7F, 0.05F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(2.0F, -6.5F, -2.0F, 2, 2, 4, 0.0F, 0.0F, 0.0F, 0.5F, 0.4F, 0.47F, -0.5F, 0.55F, -0.2F, 0.0F, 1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.4F, 0.7F, 0.0F, -0.5F, 1.7F, 2.7F, 1.5F, 0.5F, 1.5F, 1.5F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(3.0F, -6.5F, 2.0F, 1, 2, 2, 0.0F, 1.0F, -0.2F, 0.0F, 0.55F, -0.2F, 0.0F, 0.7F, -0.8F, 1.2F, 1.0F, -0.8F, 1.5F, 1.5F, 1.5F, -1.5F, 1.8F, 3.0F, -1.5F, 1.0F, 2.5F, 1.0F, 1.5F, 2.0F, 1.5F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-1.0F, -4.8F, -5.0F, 2, 1, 3, 0.0F, 1.0F, 0.1F, 1.2F, 1.0F, 0.1F, 1.2F, 0.9F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, -0.7F, 1.4F, 1.0F, -0.7F, 1.4F, 1.0F, -0.5F, 0.0F, 1.0F, -0.5F, 0.0F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(3.0F, -5.4F, -5.0F, 1, 1, 3, 0.0F, 1.0F, 0.1F, 0.2F, 0.5F, 0.1F, -0.5F, 0.7F, -0.8F, 0.0F, 1.0F, -0.8F, 0.0F, 1.0F, -0.5F, 1.2F, 0.8F, -0.5F, 0.5F, 1.7F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(2.9F, -5.4F, -1.5F, 1, 1, 1, 0.0F, 1.0F, -0.8F, 0.5F, 0.7F, -0.8F, 0.5F, 0.7F, 0.1F, -0.5F, 1.0F, 0.1F, -0.5F, 1.0F, 0.5F, 0.5F, 1.8F, 0.5F, 0.5F, 1.6F, -0.5F, -0.5F, 1.0F, -0.5F, -0.5F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(2.9F, -5.4F, -1.5F, 1, 1, 3, 0.0F, 1.0F, 0.1F, -0.5F, 0.7F, 0.1F, -0.5F, 0.8F, -0.4F, 1.5F, 1.0F, -0.4F, 1.5F, 1.0F, -0.5F, -0.5F, 1.6F, -0.5F, -0.5F, 1.6F, -0.1F, 1.5F, 1.0F, -0.1F, 1.5F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(2.9F, -5.2F, 2.5F, 1, 1, 1, 0.0F, 1.0F, -0.2F, -0.5F, 0.8F, -0.2F, -0.5F, 0.7F, -0.8F, 0.0F, 1.0F, -0.8F, 0.5F, 1.0F, -0.5F, -0.5F, 1.6F, -0.3F, -0.5F, 1.9F, 2.7F, 0.0F, 0.0F, 1.5F, 0.5F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(3.9F, -5.4F, -1.5F, 1, 1, 3, 0.0F, -1.0F, -0.5F, -0.5F, 0.6F, -0.5F, -0.5F, 0.6F, -0.9F, 1.5F, -1.0F, -0.9F, 1.5F, -1.0F, 0.1F, -0.5F, 0.8F, 0.5F, 0.5F, 0.9F, 2.9F, 2.0F, -1.0F, 2.7F, 2.0F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(3.9F, -1.0F, -0.5F, 1, 1, 3, 0.0F, -1.5F, 2.9F, 1.5F, 0.8F, 2.92F, 1.5F, 0.9F, 0.5F, 1.0F, -1.0F, 0.7F, 1.0F, -1.7F, -2.0F, 1.2F, 1.0F, -2.0F, 1.2F, 1.0F, -1.2F, -0.5F, -1.2F, -1.4F, -0.5F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(3.0F, -4.8F, -5.0F, 1, 1, 3, 0.0F, 1.0F, 0.1F, 1.2F, 0.8F, 0.1F, 0.5F, 1.7F, -0.9F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, -0.7F, 1.4F, 0.8F, -0.7F, 0.7F, 1.7F, 0.0F, 0.07F, 1.0F, -0.5F, 0.0F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(-4.0F, -5.4F, -5.0F, 1, 1, 3, 0.0F, 0.5F, 0.1F, -0.5F, 1.0F, 0.1F, 0.2F, 1.0F, -0.8F, 0.0F, 0.7F, -0.8F, 0.0F, 0.8F, -0.5F, 0.5F, 1.0F, -0.5F, 1.2F, 1.0F, 0.5F, 0.0F, 1.7F, 0.5F, 0.0F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[20].addShapeBox(-4.0F, -4.8F, -5.0F, 1, 1, 3, 0.0F, 0.8F, 0.1F, 0.5F, 1.0F, 0.1F, 1.2F, 1.0F, 0.0F, 0.0F, 1.7F, -0.9F, 0.0F, 0.8F, -0.7F, 0.7F, 1.0F, -0.7F, 1.4F, 1.0F, -0.5F, 0.0F, 1.7F, 0.0F, 0.07F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[21].addShapeBox(-4.0F, -6.5F, -4.0F, 1, 2, 3, 0.0F, 0.3F, 1.0F, 0.3F, 1.0F, 1.0F, 0.8F, 1.0F, 0.5F, -0.5F, 0.4F, 0.47F, -0.5F, 0.5F, -1.0F, 0.5F, 1.0F, -1.0F, 1.2F, 0.0F, 0.0F, -0.5F, 0.7F, 0.1F, -0.5F);
    this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[22].addShapeBox(-4.0F, -9.0F, -4.0F, 2, 2, 8, 0.0F, 0.0F, -0.3F, -0.5F, 0.5F, -0.1F, -0.2F, 0.5F, -0.7F, 1.0F, 0.3F, -1.0F, 0.7F, 0.3F, -0.5F, 0.3F, 0.0F, -0.5F, 0.8F, 0.0F, 1.3F, 1.5F, 0.7F, 1.3F, 1.2F);
    this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[23].addShapeBox(-4.0F, -10.0F, -4.0F, 2, 1, 8, 0.0F, -0.8F, -0.5F, -2.7F, 0.5F, -0.1F, -2.5F, 0.5F, -0.4F, -1.0F, -0.7F, -0.8F, -1.5F, 0.0F, 0.3F, -0.5F, 0.5F, 0.1F, -0.2F, 0.5F, 0.7F, 1.0F, 0.3F, 1.0F, 0.7F);
    this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[24].addShapeBox(-4.0F, -6.5F, -2.0F, 2, 2, 4, 0.0F, 0.4F, 0.47F, -0.5F, 0.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.0F, 0.55F, -0.2F, 0.0F, 0.7F, 0.0F, -0.5F, 0.5F, 0.0F, 0.4F, 0.5F, 1.5F, 1.5F, 1.7F, 2.7F, 1.5F);
    this.headModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[25].addShapeBox(-3.9F, -5.4F, -1.5F, 1, 1, 3, 0.0F, 0.7F, 0.1F, -0.5F, 1.0F, 0.1F, -0.5F, 1.0F, -0.4F, 1.5F, 0.8F, -0.4F, 1.5F, 1.6F, -0.5F, -0.5F, 1.0F, -0.5F, -0.5F, 1.0F, -0.1F, 1.5F, 1.6F, -0.1F, 1.5F);
    this.headModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[26].addShapeBox(-3.9F, -5.4F, -1.5F, 1, 1, 1, 0.0F, 0.7F, -0.8F, 0.5F, 1.0F, -0.8F, 0.5F, 1.0F, 0.1F, -0.5F, 0.7F, 0.1F, -0.5F, 1.8F, 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 1.0F, -0.5F, -0.5F, 1.6F, -0.5F, -0.5F);
    this.headModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[27].addShapeBox(-4.9F, -1.0F, -0.5F, 1, 1, 3, 0.0F, 0.8F, 2.9F, 1.5F, -1.5F, 2.9F, 1.5F, -1.0F, 0.7F, 1.0F, 0.9F, 0.5F, 1.0F, 1.0F, -2.0F, 1.2F, -1.7F, -2.0F, 1.2F, -1.2F, -1.4F, -0.5F, 1.0F, -1.2F, -0.5F);
    this.headModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[28].addShapeBox(-3.9F, -5.2F, 2.5F, 1, 1, 1, 0.0F, 0.8F, -0.2F, -0.5F, 1.0F, -0.2F, -0.5F, 1.0F, -0.8F, 0.5F, 0.7F, -0.8F, 0.0F, 1.6F, -0.3F, -0.5F, 1.0F, -0.5F, -0.5F, 0.0F, 1.5F, 0.5F, 1.9F, 2.7F, 0.0F);
    this.headModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[29].addShapeBox(-4.9F, -5.4F, -1.5F, 1, 1, 3, 0.0F, 0.6F, -0.5F, -0.5F, -1.0F, -0.5F, -0.5F, -1.0F, -0.9F, 1.5F, 0.6F, -0.9F, 1.5F, 0.8F, 0.5F, 0.5F, -1.0F, 0.1F, -0.5F, -1.0F, 2.7F, 2.0F, 0.9F, 2.9F, 2.0F);
    this.headModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[30].addShapeBox(-4.0F, -6.5F, 2.0F, 1, 2, 2, 0.0F, 0.55F, -0.2F, 0.0F, 1.0F, -0.2F, 0.0F, 1.0F, -0.8F, 1.5F, 0.7F, -0.8F, 1.2F, 1.8F, 3.0F, -1.5F, 1.5F, 1.5F, -1.5F, 1.5F, 2.0F, 1.5F, 1.0F, 2.5F, 1.0F);
    this.headModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[31].addShapeBox(-5.9F, -5.0F, -0.5F, 1, 5, 1, 0.0F, -0.5F, -2.0F, -0.8F, -0.2F, -1.8F, -0.8F, 0.0F, -2.1F, 0.5F, -0.5F, -2.0F, 0.5F, -1.8F, -0.4F, 3.5F, 1.2F, -0.4F, 3.5F, 1.2F, -0.2F, -3.7F, -1.8F, -0.2F, -3.7F);
    this.headModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
