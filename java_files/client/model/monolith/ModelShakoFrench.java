package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelShakoFrench extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelShakoFrench() {
    this.headModel = new ModelRendererTurbo[21];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 9, 33, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 49, 13, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 17, 32, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 57, 33, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-5.0F, -8.5F, -6.0F, 10, 4, 10, 0.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -0.5F, 0.25F, 0.0F, -0.5F, 0.25F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.5F, 0.25F, 0.0F, 0.5F, 0.25F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(0.0F, -10.5F, -4.0F, 5, 4, 8, 0.0F, 0.0F, 2.25F, 2.5F, 1.0F, 1.0F, 1.0F, 1.0F, -1.0F, 0.5F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.25F, 0.0F, 0.7F, 0.25F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-5.0F, -5.5F, -6.0F, 5, 1, 1, 0.0F, 0.0F, -0.75F, -0.75F, 0.0F, -0.75F, 0.0F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -4.5F, -3.0F, 8, 5, 1, 0.0F, 1.2F, 0.0F, 0.0F, 1.2F, 0.0F, 0.0F, 1.2F, 0.0F, 0.5F, 1.2F, 0.0F, 0.5F, 0.25F, 0.0F, 0.0F, 0.25F, -0.125F, 0.0F, 0.25F, -0.125F, 0.0F, 0.25F, -0.125F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.headModel[3]).field_78795_f = -0.12217305F;
    this.headModel[4].addShapeBox(-6.0F, -11.5F, -5.2F, 1, 10, 1, 0.0F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].func_78790_a(-6.0F, -11.5F, -5.3F, 1, 1, 1, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-6.0F, -7.5F, -5.2F, 1, 2, 1, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(3.0F, -8.5F, -5.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -0.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.075F, -2.475F, 0.0F, -4.05F, -1.45F, 0.0F, -4.05F, -1.45F, 0.0F, 3.075F, -2.475F, 0.0F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(5.0F, -11.5F, -5.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, -0.125F, -0.25F, 0.0F, 0.0F, -0.125F, 0.0F, 2.0F, -1.0F, 0.0F, -2.5F, 0.0F, 0.0F, -2.5F, 0.0F, 0.0F, 2.0F, -1.0F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].func_78790_a(5.0F, -11.5F, -5.3F, 1, 1, 1, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-6.0F, -3.5F, -5.2F, 1, 2, 1, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-5.0F, -10.5F, -4.0F, 5, 4, 8, 0.0F, 1.0F, 1.0F, 1.0F, 0.0F, 2.25F, 2.5F, 0.0F, 1.0F, 1.0F, 1.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7F, 0.25F, 0.0F, 0.5F, 0.25F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(0.0F, -5.5F, -6.0F, 5, 1, 1, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, -0.75F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-4.0F, -8.5F, -5.0F, 1, 4, 1, 0.0F, -0.5F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.0F, 0.0F, -3.925F, -1.45F, 0.0F, 2.95F, -2.475F, 0.0F, 2.95F, -2.475F, 0.0F, -3.925F, -1.45F, 0.0F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(-6.0F, -11.5F, -5.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.0F, -0.125F, -0.25F, 0.0F, -2.5F, 0.0F, 0.0F, 2.0F, -1.0F, 0.0F, 2.0F, -1.0F, 0.0F, -2.5F, 0.0F, 0.0F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(-0.5F, -12.5F, -6.7F, 1, 1, 1, 0.0F, 0.3F, 0.5F, 0.25F, 0.3F, 0.5F, 0.25F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, -0.125F, 0.3F, 0.5F, -0.125F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(-0.5F, -15.5F, -5.8F, 1, 3, 1, 0.0F, 0.5F, 0.25F, 2.75F, 0.25F, 0.25F, 2.75F, 0.25F, 0.25F, -2.5F, 0.25F, 0.25F, -2.5F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, -1.25F, 0.0F, 0.0F, -1.25F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(-2.0F, -5.5F, -3.0F, 4, 1, 1, 0.0F, 3.5F, 0.2F, 0.0F, 3.5F, 0.2F, 0.0F, 3.5F, 0.2F, 0.5F, 3.5F, 0.2F, 0.5F, 3.5F, 0.0F, 0.0F, 3.5F, 0.0F, 0.0F, 3.5F, 0.0F, 0.5F, 3.5F, 0.0F, 0.5F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.headModel[17]).field_78795_f = -0.12217305F;
    this.headModel[18].addShapeBox(-1.5F, -10.5F, -5.7F, 3, 1, 1, 0.0F, -1.4F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(-1.5F, -8.5F, -5.7F, 3, 1, 1, 0.0F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -1.4F, 0.0F, -0.8F, -1.4F, 0.0F, -0.8F, -1.4F, 0.0F, 0.0F, -1.4F, 0.0F, 0.0F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[20].addShapeBox(-0.5F, -12.5F, -6.8F, 1, 1, 1, 0.0F, 0.0F, 0.15F, 0.25F, 0.0F, 0.15F, 0.25F, 0.0F, 0.15F, 0.0F, 0.0F, 0.15F, 0.0F, 0.0F, 0.15F, -0.125F, 0.0F, 0.15F, -0.125F, 0.0F, 0.15F, 0.0F, 0.0F, 0.15F, 0.0F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
