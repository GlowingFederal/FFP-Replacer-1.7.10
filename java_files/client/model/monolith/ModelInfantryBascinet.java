package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelInfantryBascinet extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelInfantryBascinet() {
    this.headModel = new ModelRendererTurbo[10];
    this.bodyModel = new ModelRendererTurbo[2];
    initheadModel_1();
    initbodyModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 73, 17, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 81, 41, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 1.0F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -5.0F, -4.0F, 1, 3, 6, 0.0F, 0.5F, -0.5F, 1.0F, -1.2F, -0.5F, 1.0F, -1.2F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.5F, -3.0F, -1.2F, 0.5F, -3.0F, -1.2F, 0.2F, 1.0F, 0.5F, 0.2F, 1.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -5.0F, 3.0F, 8, 3, 1, 0.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, -0.2F, 0.5F, 0.5F, -0.2F, 0.5F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(4.7F, -5.0F, -4.0F, 1, 3, 6, 0.0F, 0.5F, -0.5F, 1.0F, -1.2F, -0.5F, 1.0F, -1.2F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.5F, -3.0F, -1.2F, 0.5F, -3.0F, -1.2F, 0.2F, 1.0F, 0.5F, 0.2F, 1.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -9.8F, -4.0F, 8, 1, 8, 0.0F, -1.0F, 0.0F, -2.0F, -1.0F, 0.0F, -2.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-3.0F, -10.8F, -3.0F, 6, 1, 7, 0.0F, -2.8F, 0.75F, -6.2F, -2.8F, 0.75F, -6.2F, -2.8F, 0.75F, -0.5F, -2.8F, 0.75F, -0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-1.2F, -6.0F, -1.7F, 1, 1, 2, 0.0F, -0.5F, 1.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.5F, -0.8F, -0.5F, 0.5F, -0.8F, -0.5F, -1.0F, 1.0F, -0.2F, -1.0F, 1.0F, -0.2F, -0.5F, -1.2F, -0.5F, -0.5F, -1.2F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-4.0F, -1.0F, -4.0F, 16, 5, 4, 0.0F, 0.1F, -0.2F, 0.1F, -7.9F, -0.2F, 0.1F, -7.9F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -3.9F, 0.1F, -7.9F, -3.9F, 0.1F, -7.9F, -1.9F, 0.1F, 0.1F, -1.9F, 0.1F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-4.0F, -5.0F, -3.0F, 16, 10, 7, 0.0F, 0.1F, 0.0F, 0.1F, -7.9F, 0.0F, 0.1F, -7.9F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -5.7F, 1.1F, -7.9F, -5.7F, 1.1F, -7.9F, -5.9F, 0.1F, 0.1F, -5.9F, 0.1F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.0F, -1.0F, 0.0F, 16, 5, 4, 0.0F, 0.1F, 0.0F, 0.1F, -7.9F, 0.0F, 0.1F, -7.9F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, -1.9F, 0.1F, -7.9F, -1.9F, 0.1F, -7.9F, -3.9F, 0.1F, 0.1F, -3.9F, 0.1F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-0.5F, -0.4F, -2.0F, 15, 6, 4, 0.0F, -0.3F, 0.0F, 0.5F, -9.7F, -0.2F, 0.5F, -9.7F, -0.2F, 0.5F, -0.3F, 0.0F, 0.5F, -0.4F, -2.0F, 0.7F, -10.4F, -4.0F, 0.5F, -10.4F, -4.0F, 0.5F, -0.4F, -2.0F, 0.7F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.8F, -0.4F, -2.0F, 15, 6, 4, 0.0F, 0.0F, -0.2F, 0.5F, -10.3F, 0.0F, 0.5F, -10.3F, 0.0F, 0.5F, 0.0F, -0.2F, 0.5F, -0.8F, -4.0F, 0.5F, -10.3F, -2.0F, 0.7F, -10.3F, -2.0F, 0.7F, -0.8F, -4.0F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
