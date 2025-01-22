package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelBurghCastle extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelBurghCastle() {
    this.headModel = new ModelRendererTurbo[28];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 17, 49, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.headModel[21] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.headModel[22] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.headModel[23] = new ModelRendererTurbo((ModelBase)this, 9, 49, this.textureX, this.textureY);
    this.headModel[24] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.headModel[25] = new ModelRendererTurbo((ModelBase)this, 33, 49, this.textureX, this.textureY);
    this.headModel[26] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.headModel[27] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.5F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.2F, 0.9F, 0.9F, -0.2F, 0.9F, 0.9F, -0.2F, 0.9F, 0.9F, -0.2F, 0.9F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -10.3F, -4.0F, 8, 1, 8, 0.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -6.0F, -4.0F, 8, 2, 1, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 1.5F, 0.9F, -0.5F, 1.5F, 0.9F, -0.7F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -6.0F, 1.0F, 8, 2, 3, 0.0F, 0.9F, -0.5F, 1.5F, 0.9F, -0.5F, 1.5F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-3.0F, -4.5F, 3.7F, 6, 2, 1, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.9F, -0.5F, 0.5F, 0.9F, -0.5F, 0.5F, 0.9F, -0.5F, 0.0F, 0.9F, -0.5F, 0.0F, 0.9F, -0.3F, 0.0F, 0.9F, -0.3F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-3.0F, -3.5F, 2.7F, 6, 4, 1, 0.0F, 0.9F, -0.5F, -1.1F, 0.9F, -0.5F, -1.1F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F, 1.9F, 0.5F, -3.7F, 1.9F, 0.5F, -3.7F, 1.9F, -0.1F, 3.5F, 1.9F, -0.1F, 3.5F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-0.5F, -6.5F, 0.5F, 1, 2, 4, 0.0F, 0.0F, -0.5F, 1.5F, 0.0F, -0.5F, 1.5F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.3F, 0.9F, 0.0F, -0.3F, 0.9F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-0.5F, -8.5F, -4.5F, 1, 3, 9, 0.0F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-0.5F, -6.5F, -4.5F, 1, 2, 1, 0.0F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 1.5F, 0.0F, -0.5F, 1.5F, 0.0F, -0.7F, 0.9F, 0.0F, -0.7F, 0.9F, 0.0F, -0.5F, 0.9F, 0.0F, -0.5F, 0.9F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-0.5F, -10.8F, -4.5F, 1, 1, 9, 0.0F, 0.0F, -0.2F, -2.4F, 0.0F, -0.2F, -2.4F, 0.0F, -0.2F, -2.4F, 0.0F, -0.2F, -2.4F, 0.0F, 1.0F, 0.3F, 0.0F, 1.0F, 0.3F, 0.0F, 1.0F, 0.3F, 0.0F, 1.0F, 0.3F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-4.85F, -1.0F, -3.0F, 1, 2, 3, 0.0F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, -0.3F, -0.3F, -1.0F, -0.3F, -0.3F, -1.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-4.85F, -2.0F, -3.0F, 1, 2, 3, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-4.85F, -3.5F, -3.0F, 1, 2, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-4.85F, -4.5F, -3.0F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(-4.85F, -4.5F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.4F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(3.85F, -1.0F, -3.0F, 1, 2, 3, 0.0F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, -0.3F, -0.3F, -1.0F, -0.3F, -0.3F, -1.0F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(3.85F, -2.0F, -3.0F, 1, 2, 3, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(3.85F, -3.5F, -3.0F, 1, 2, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(3.85F, -4.5F, -3.0F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(3.85F, -4.5F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[20].addShapeBox(-1.0F, -5.0F, -4.5F, 2, 1, 1, 0.0F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, -0.7F, 0.5F, -0.2F, -0.7F, -0.4F, 0.2F, 0.7F, -0.4F, 0.2F, 0.7F, -0.4F, 0.2F, -0.7F, -0.4F, 0.2F, -0.7F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[21].addShapeBox(-3.0F, -5.2F, -4.5F, 2, 1, 1, 0.0F, -0.3F, -0.2F, 0.7F, -0.3F, -0.2F, 0.7F, -0.3F, -0.2F, -0.7F, -0.3F, -0.2F, -0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, -0.7F, 0.5F, -0.2F, -0.7F);
    this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[22].addShapeBox(-4.0F, -5.0F, -4.5F, 1, 1, 1, 0.0F, 0.0F, -0.4F, 0.7F, 0.5F, -0.4F, 0.7F, 0.5F, -0.4F, -0.7F, 0.0F, -0.4F, -0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -0.7F);
    this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[23].addShapeBox(1.0F, -5.2F, -4.5F, 2, 1, 1, 0.0F, -0.3F, -0.2F, 0.7F, -0.3F, -0.2F, 0.7F, -0.3F, -0.2F, -0.7F, -0.3F, -0.2F, -0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, 0.7F, 0.5F, -0.2F, -0.7F, 0.5F, -0.2F, -0.7F);
    this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[24].addShapeBox(3.0F, -5.0F, -4.5F, 1, 1, 1, 0.0F, 0.5F, -0.4F, 0.7F, 0.0F, -0.4F, 0.7F, 0.0F, -0.4F, -0.7F, 0.5F, -0.4F, -0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -0.7F);
    this.headModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[25].addShapeBox(-0.5F, -4.5F, -4.5F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -0.7F, 0.2F, 0.2F, 0.7F, 0.2F, 0.2F, 0.7F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, -0.7F);
    this.headModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[26].addShapeBox(-0.5F, -2.5F, -4.5F, 1, 1, 1, 0.0F, 0.2F, -0.2F, 0.7F, 0.2F, -0.2F, 0.7F, 0.2F, -0.2F, -0.7F, 0.2F, -0.2F, -0.7F, -0.2F, -0.2F, 0.7F, -0.2F, -0.2F, 0.7F, -0.2F, -0.2F, -0.7F, -0.2F, -0.2F, -0.7F);
    this.headModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[27].addShapeBox(-4.0F, -6.5F, 1.0F, 8, 2, 3, 0.0F, 1.0F, -0.7F, 6.0F, 1.0F, -0.7F, 6.0F, 1.0F, -0.7F, 1.0F, 1.0F, -0.7F, 1.0F, 1.0F, -0.7F, 6.0F, 1.0F, -0.7F, 6.0F, 1.0F, -0.5F, 1.0F, 1.0F, -0.5F, 1.0F);
    this.headModel[27].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
