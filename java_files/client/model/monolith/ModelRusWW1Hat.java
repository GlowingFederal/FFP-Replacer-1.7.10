package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRusWW1Hat extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 32;
  
  public ModelRusWW1Hat() {
    this.headModel = new ModelRendererTurbo[10];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-3.5F, -7.5F, -4.5F, 7, 2, 9, 0.0F, 0.0F, 1.0F, 0.2F, 0.0F, 1.0F, 0.2F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 2.7F, 0.0F, 0.0F, 2.7F, 0.0F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-2.0F, -5.5F, -6.5F, 4, 1, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(2.0F, -5.5F, -6.5F, 2, 1, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, -1.5F, 0.3F, 0.25F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.75F, 0.0F, 0.0F, -0.3F, -1.5F, 0.3F, 0.0F, 0.0F, 0.0F, -0.75F, 0.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-2.5F, -9.5F, -4.5F, 5, 4, 9, 0.0F, 0.0F, 1.3F, 2.5F, 0.0F, 1.3F, 2.5F, 0.0F, -1.2F, 2.5F, 0.0F, -1.2F, 2.5F, 0.8F, -2.0F, 1.0F, 0.8F, -2.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(3.5F, -7.5F, -4.5F, 1, 2, 9, 0.0F, 0.0F, 1.0F, 0.2F, 0.2F, -0.3F, -1.2F, 0.2F, -1.0F, -0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, -0.1F, 0.2F, -1.0F, -0.1F, 2.0F, -1.0F, 0.0F, 2.7F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(2.5F, -9.5F, -4.5F, 3, 4, 9, 0.0F, 0.0F, 1.3F, 2.5F, 1.0F, -1.2F, -0.5F, 1.0F, -2.2F, 0.2F, 0.0F, -1.2F, 2.5F, -0.8F, -2.0F, 1.0F, -0.4F, -1.5F, -0.8F, -0.7F, 0.0F, -0.3F, 0.0F, 1.0F, 1.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-0.5F, -7.1F, -5.2F, 1, 1, 1, 0.0F, 0.1F, 0.2F, -0.1F, 0.1F, 0.2F, -0.1F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-5.5F, -9.5F, -4.5F, 3, 4, 9, 0.0F, 1.0F, -1.2F, -0.5F, 0.0F, 1.3F, 2.5F, 0.0F, -1.2F, 2.5F, 1.0F, -2.7F, 0.2F, -0.4F, -1.5F, -0.8F, -0.8F, -2.0F, 1.0F, 0.0F, 1.0F, 1.0F, -0.7F, 0.0F, -0.3F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-4.5F, -7.5F, -4.5F, 1, 2, 9, 0.0F, 0.2F, -0.3F, -1.2F, 0.0F, 1.0F, 0.2F, 0.0F, 0.0F, 0.5F, 0.2F, -1.0F, -0.5F, -0.1F, 0.2F, -1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 2.7F, 0.0F, -0.1F, 2.0F, -1.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-4.0F, -5.5F, -6.5F, 2, 1, 6, 0.0F, 0.0F, -0.4F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.3F, 0.25F, 0.0F, 0.0F, -0.3F, -1.5F, 0.0F, -0.75F, 0.0F, 0.0F, -0.75F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
