package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelToaster extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelToaster() {
    this.headModel = new ModelRendererTurbo[23];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 9, 33, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 17, 57, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 41, 57, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.headModel[21] = new ModelRendererTurbo((ModelBase)this, 9, 33, this.textureX, this.textureY);
    this.headModel[22] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -5.0F, -4.0F, 8, 1, 4, 0.0F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, -0.4F, 0.3F, 0.8F, -0.4F, 0.3F, 0.8F, -0.6F, 0.8F, 0.8F, -0.6F, 0.8F, 0.8F, -0.2F, 0.3F, 0.8F, -0.2F, 0.3F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.15F, 0.15F, 0.15F, 0.15F, 0.15F, 0.15F, 0.15F, 0.15F, 0.5F, 0.15F, 0.15F, 0.5F, 0.45F, 0.3F, 0.5F, 0.45F, 0.3F, 0.5F, 0.45F, 0.0F, 0.6F, 0.45F, 0.0F, 0.6F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -8.4F, -4.0F, 8, 1, 8, 0.0F, -0.85F, 0.5F, -1.9F, -0.85F, 0.5F, -1.9F, -0.85F, 0.7F, -1.85F, -0.85F, 0.7F, -1.85F, 0.15F, -0.75F, 0.15F, 0.15F, -0.75F, 0.15F, 0.15F, -0.75F, 0.5F, 0.15F, -0.75F, 0.5F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -5.1F, -1.0F, 8, 3, 5, 0.0F, 0.45F, 0.0F, 0.5F, 0.45F, 0.0F, 0.5F, 0.45F, 0.0F, 0.5F, 0.45F, 0.0F, 0.5F, 0.45F, 0.0F, 0.0F, 0.45F, 0.0F, 0.0F, 0.45F, 0.0F, 0.5F, 0.45F, 0.0F, 0.5F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -4.0F, -3.5F, 8, 4, 2, 0.0F, 0.15F, 0.5F, -0.5F, 0.15F, 0.5F, -0.5F, 0.15F, 0.4F, 2.0F, 0.15F, 0.4F, 2.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-3.5F, -2.1F, 3.0F, 7, 3, 1, 0.0F, 0.15F, 0.0F, 0.5F, 0.15F, 0.0F, 0.5F, 0.15F, 0.0F, 0.5F, 0.15F, 0.0F, 0.5F, -0.85F, 0.0F, -1.0F, -0.85F, 0.0F, -1.0F, -0.85F, 0.0F, 1.0F, -0.85F, 0.0F, 1.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-2.5F, -6.5F, -4.8F, 5, 1, 1, 0.0F, -0.5F, 0.3F, 0.3F, -0.5F, 0.3F, 0.3F, 0.5F, 0.3F, 0.3F, 0.5F, 0.3F, 0.3F, -0.5F, 0.3F, 0.5F, -0.5F, 0.3F, 0.5F, 0.8F, 0.3F, 0.5F, 0.8F, 0.3F, 0.5F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-3.5F, -8.0F, -4.3F, 1, 3, 1, 0.0F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.15F, 0.0F, 0.0F, 0.15F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-3.5F, -8.0F, 3.7F, 1, 6, 1, 0.0F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, -0.3F, 0.15F, 0.0F, -0.3F, 0.15F, 0.0F, -0.3F, 0.15F, 0.0F, -0.3F, 0.15F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-3.5F, -8.4F, -4.0F, 1, 1, 8, 0.0F, 0.0F, 1.0F, -1.6F, 0.0F, 1.0F, -1.6F, 0.0F, 1.2F, -1.55F, 0.0F, 1.2F, -1.55F, 0.0F, -0.75F, 0.45F, 0.0F, -0.75F, 0.45F, 0.0F, -0.75F, 0.8F, 0.0F, -0.75F, 0.8F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-1.6F, -8.2F, -4.3F, 1, 3, 1, 0.0F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, -0.3F, 0.5F, 0.1F, -0.3F, 0.5F, 0.1F, -0.3F, 0.15F, 0.1F, -0.3F, 0.15F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-1.6F, -8.6F, -4.0F, 1, 1, 8, 0.0F, 0.1F, 1.0F, -1.6F, 0.1F, 1.0F, -1.6F, 0.1F, 1.2F, -1.55F, 0.1F, 1.2F, -1.55F, 0.1F, -0.75F, 0.45F, 0.1F, -0.75F, 0.45F, 0.1F, -0.55F, 0.8F, 0.1F, -0.55F, 0.8F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-1.6F, -8.0F, 3.7F, 1, 6, 1, 0.0F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, -0.3F, 0.15F, 0.1F, -0.3F, 0.15F, 0.1F, -0.3F, 0.15F, 0.1F, -0.3F, 0.15F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-6.0F, -6.0F, -2.0F, 2, 4, 4, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(4.0F, -6.0F, -2.0F, 2, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(-4.0F, -8.0F, -0.6F, 8, 3, 1, 0.0F, 0.45F, 0.15F, 0.4F, 0.45F, 0.15F, 0.4F, 0.45F, 0.15F, 0.4F, 0.45F, 0.15F, 0.4F, 0.75F, 0.3F, 0.4F, 0.75F, 0.3F, 0.4F, 0.75F, 0.0F, 0.4F, 0.75F, 0.0F, 0.4F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(-4.0F, -8.4F, -0.6F, 8, 1, 1, 0.0F, -0.85F, 0.7F, 0.4F, -0.85F, 0.7F, 0.4F, -0.85F, 0.8F, 0.4F, -0.85F, 0.8F, 0.4F, 0.45F, -0.75F, 0.4F, 0.45F, -0.75F, 0.4F, 0.45F, -0.75F, 0.4F, 0.45F, -0.75F, 0.4F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(0.6F, -8.0F, 3.7F, 1, 6, 1, 0.0F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, -0.3F, 0.15F, 0.1F, -0.3F, 0.15F, 0.1F, -0.3F, 0.15F, 0.1F, -0.3F, 0.15F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(0.6F, -8.6F, -4.0F, 1, 1, 8, 0.0F, 0.1F, 1.0F, -1.6F, 0.1F, 1.0F, -1.6F, 0.1F, 1.2F, -1.55F, 0.1F, 1.2F, -1.55F, 0.1F, -0.75F, 0.45F, 0.1F, -0.75F, 0.45F, 0.1F, -0.55F, 0.8F, 0.1F, -0.55F, 0.8F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(0.6F, -8.2F, -4.3F, 1, 3, 1, 0.0F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, 0.15F, 0.15F, 0.1F, -0.3F, 0.5F, 0.1F, -0.3F, 0.5F, 0.1F, -0.3F, 0.15F, 0.1F, -0.3F, 0.15F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[20].addShapeBox(2.5F, -8.0F, -4.3F, 1, 3, 1, 0.0F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.15F, 0.0F, 0.0F, 0.15F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[21].addShapeBox(2.5F, -8.4F, -4.0F, 1, 1, 8, 0.0F, 0.0F, 1.0F, -1.6F, 0.0F, 1.0F, -1.6F, 0.0F, 1.2F, -1.55F, 0.0F, 1.2F, -1.55F, 0.0F, -0.75F, 0.45F, 0.0F, -0.75F, 0.45F, 0.0F, -0.75F, 0.8F, 0.0F, -0.75F, 0.8F);
    this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[22].addShapeBox(2.5F, -8.0F, 3.7F, 1, 6, 1, 0.0F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, 0.15F, 0.15F, 0.0F, -0.3F, 0.15F, 0.0F, -0.3F, 0.15F, 0.0F, -0.3F, 0.15F, 0.0F, -0.3F, 0.15F);
    this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
