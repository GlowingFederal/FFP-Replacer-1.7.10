package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelLaterCuirass extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 32;
  
  public ModelLaterCuirass() {
    this.bodyModel = new ModelRendererTurbo[33];
    initbodyModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 65, 17, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 89, 17, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[27] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[28] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.bodyModel[29] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.bodyModel[30] = new ModelRendererTurbo((ModelBase)this, 65, 17, this.textureX, this.textureY);
    this.bodyModel[31] = new ModelRendererTurbo((ModelBase)this, 65, 17, this.textureX, this.textureY);
    this.bodyModel[32] = new ModelRendererTurbo((ModelBase)this, 65, 17, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 4.0F, -4.0F, 4, 2, 4, 0.0F, -0.1F, -0.5F, 0.7F, 0.0F, -0.5F, 0.2F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, -0.1F, 0.0F, 0.7F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(0.0F, 6.0F, -4.0F, 4, 2, 4, 0.0F, -0.1F, 0.0F, 0.7F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.1F, 0.0F, 0.2F, 0.7F, 0.0F, -0.8F, 0.7F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(0.0F, 8.0F, -4.0F, 4, 1, 4, 0.0F, -0.1F, 0.0F, 0.2F, 0.7F, 0.0F, -0.8F, 0.7F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.1F, 0.8F, -1.0F, 0.6F, 0.5F, -1.7F, 0.6F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(3.0F, 1.0F, -4.0F, 1, 4, 4, 0.0F, 1.0F, 1.5F, -1.0F, 0.5F, 1.0F, -1.5F, 0.4F, 0.0F, -1.5F, 0.5F, 0.5F, -1.5F, 2.9F, -0.5F, 0.7F, 0.0F, -0.5F, 0.2F, 0.0F, -1.0F, -2.0F, 3.0F, -1.0F, -2.0F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 0.5F, -3.0F, 2, 1, 3, 0.0F, 0.5F, 0.5F, -0.5F, 0.0F, 1.0F, 0.0F, -0.3F, 2.0F, 0.5F, 0.8F, 1.5F, 0.5F, 0.2F, 0.0F, -1.5F, 0.5F, -0.5F, 0.0F, 0.0F, -1.5F, 0.5F, 0.4F, -1.0F, 0.5F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 4.0F, 1.0F, 4, 2, 2, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 0.7F, 1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.8F, 1.0F, 0.0F, 0.3F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.0F, 1.0F, 1.0F, 3, 3, 2, 0.0F, 0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.5F, 1.0F, 0.5F, 0.5F, 1.0F, 0.0F, 0.0F, 0.0F, -1.0F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.2F, 0.0F, 0.0F, 0.7F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-4.0F, 0.5F, 1.0F, 2, 1, 2, 0.0F, 0.8F, 1.5F, 0.5F, -0.3F, 2.0F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.4F, -1.0F, 0.5F, 0.0F, -1.5F, 0.5F, 0.5F, -0.5F, -1.0F, 0.5F, -0.5F, -1.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-4.0F, 6.0F, 1.0F, 4, 3, 2, 0.0F, 1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.8F, 1.0F, 0.0F, 0.3F, 0.6F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.6F, 0.5F, -0.5F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(0.0F, 10.0F, -4.0F, 4, 1, 4, 0.0F, 0.0F, 0.2F, -1.0F, 0.6F, 0.5F, -1.7F, 0.6F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.8F, -0.3F, -0.8F, 1.1F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-4.0F, 10.0F, 1.0F, 4, 1, 3, 0.0F, 0.6F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, -1.0F, 0.6F, 0.5F, -1.5F, 1.1F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.8F, -0.2F, -1.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(0.0F, 9.0F, -4.0F, 5, 1, 4, 0.0F, 0.0F, -0.6F, -0.3F, -0.3F, -0.2F, -1.0F, -0.1F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.4F, -0.1F, -0.3F, -0.2F, -1.0F, -0.1F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-5.0F, 9.0F, 0.0F, 5, 1, 4, 0.0F, -0.1F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, -0.8F, -0.2F, -0.2F, -1.3F, -0.1F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, -0.6F, -0.2F, -0.2F, -1.3F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-0.5F, 4.0F, -4.0F, 1, 2, 1, 0.0F, -0.4F, -0.5F, 0.7F, -0.4F, -0.5F, 0.7F, -0.4F, -0.5F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F, 0.0F, 0.7F, -0.4F, 0.0F, 0.7F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-0.5F, 6.0F, -4.0F, 1, 2, 4, 0.0F, -0.4F, 0.0F, 0.7F, -0.4F, 0.0F, 0.7F, -0.4F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-0.5F, 8.0F, -4.0F, 1, 1, 4, 0.0F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, -0.4F, 0.8F, -1.0F, -0.4F, 0.5F, -1.0F, -0.4F, 0.5F, 0.5F, -0.4F, 0.5F, 0.5F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-0.5F, 1.5F, -5.2F, 2, 3, 1, 0.0F, -0.5F, 0.2F, -1.3F, 0.05F, 0.7F, -1.65F, 0.6F, 0.7F, 3.0F, -0.5F, 0.2F, 3.0F, -0.5F, 0.0F, -0.5F, -1.4F, 0.0F, -0.5F, -1.4F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-4.0F, 1.0F, -4.0F, 1, 4, 4, 0.0F, 0.5F, 1.0F, -1.5F, 1.0F, 1.5F, -1.0F, 0.5F, 0.5F, -1.5F, 0.4F, 0.0F, -1.5F, 0.0F, -0.5F, 0.2F, 2.9F, -0.5F, 0.7F, 3.0F, -1.0F, -2.0F, 0.0F, -1.0F, -2.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-4.0F, 4.0F, -4.0F, 4, 2, 4, 0.0F, 0.0F, -0.5F, 0.2F, -0.1F, -0.5F, 0.7F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 1.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.7F, 0.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(-4.0F, 6.0F, -4.0F, 4, 2, 4, 0.0F, 1.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.7F, 0.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 0.7F, 0.0F, -0.8F, -0.1F, 0.0F, 0.2F, 0.0F, 0.0F, 0.5F, 0.7F, 0.0F, 0.5F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(-4.0F, 8.0F, -4.0F, 4, 1, 4, 0.0F, 0.7F, 0.0F, -0.8F, -0.1F, 0.0F, 0.2F, 0.0F, 0.0F, 0.5F, 0.7F, 0.0F, 0.5F, 0.6F, 0.5F, -1.7F, -0.1F, 0.8F, -1.0F, 0.0F, 0.5F, 0.5F, 0.6F, 0.5F, 0.5F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(-4.0F, 10.0F, -4.0F, 4, 1, 4, 0.0F, 0.6F, 0.5F, -1.7F, 0.0F, 0.2F, -1.0F, 0.0F, 0.5F, 0.5F, 0.6F, 0.5F, 0.5F, 0.8F, -0.3F, -0.8F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.5F, 1.1F, -0.5F, 0.5F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(-5.0F, 9.0F, -4.0F, 5, 1, 4, 0.0F, -0.3F, -0.2F, -1.0F, 0.0F, -0.6F, -0.3F, 0.0F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.3F, -0.2F, -1.0F, 0.0F, 0.4F, -0.1F, 0.0F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[23].addShapeBox(0.0F, 9.0F, 0.0F, 5, 1, 4, 0.0F, 0.0F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.2F, -0.2F, -1.3F, 0.0F, -0.2F, -0.8F, 0.0F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, -0.2F, -0.2F, -1.3F, 0.0F, -0.2F, -0.6F);
    this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[24].addShapeBox(0.0F, 6.0F, 1.0F, 4, 3, 2, 0.0F, 0.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.8F, 0.0F, 0.5F, 0.5F, 0.6F, 0.5F, 0.5F, 0.6F, 0.5F, -0.5F, 0.0F, 0.5F, 0.0F);
    this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[25].addShapeBox(0.0F, 4.0F, 1.0F, 4, 2, 2, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.8F);
    this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[26].addShapeBox(1.0F, 1.0F, 1.0F, 3, 3, 2, 0.0F, -0.5F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F, 0.5F, 1.0F, 0.0F, -0.5F, 1.0F, 0.5F, 1.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.7F, 1.0F, 0.0F, 1.2F);
    this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[27].addShapeBox(2.0F, 0.5F, 1.0F, 2, 1, 2, 0.0F, -0.3F, 2.0F, 0.5F, 0.8F, 1.5F, 0.5F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.5F, 0.0F, -1.5F, 0.5F, 0.4F, -1.0F, 0.5F, 0.5F, -0.5F, -1.0F, 0.5F, -0.5F, -1.0F);
    this.bodyModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[28].addShapeBox(0.0F, 10.0F, 1.0F, 4, 1, 3, 0.0F, 0.0F, 0.5F, 0.5F, 0.6F, 0.5F, 0.5F, 0.6F, 0.5F, -1.5F, 0.0F, 0.5F, -1.0F, 0.0F, -0.5F, 0.5F, 1.1F, -0.5F, 0.5F, 0.8F, -0.2F, -1.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[28].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[29].addShapeBox(2.0F, 0.5F, -3.0F, 2, 1, 3, 0.0F, 0.0F, 1.0F, 0.0F, 0.5F, 0.5F, -0.5F, 0.8F, 1.5F, 0.5F, -0.3F, 2.0F, 0.5F, 0.5F, -0.5F, 0.0F, 0.2F, 0.0F, -1.5F, 0.4F, -1.0F, 0.5F, 0.0F, -1.5F, 0.5F);
    this.bodyModel[29].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[30].addShapeBox(-1.5F, 1.5F, -5.2F, 2, 3, 1, 0.0F, 0.05F, 0.7F, -1.65F, -0.5F, 0.2F, -1.3F, -0.5F, 0.2F, 3.0F, 0.6F, 0.7F, 3.0F, -1.4F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F);
    this.bodyModel[30].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[31].addShapeBox(-0.5F, 1.0F, 3.2F, 2, 3, 1, 0.0F, -0.5F, 0.2F, 3.0F, 0.6F, 0.7F, 3.0F, -0.1F, 0.7F, -0.65F, -0.5F, 0.2F, -0.5F, -0.5F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.bodyModel[31].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[32].addShapeBox(-1.5F, 1.0F, 3.2F, 2, 3, 1, 0.0F, 0.6F, 0.7F, 3.0F, -0.5F, 0.2F, 3.0F, -0.5F, 0.2F, -0.5F, -0.1F, 0.7F, -0.65F, -1.4F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F);
    this.bodyModel[32].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
