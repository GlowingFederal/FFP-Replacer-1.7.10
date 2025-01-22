package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRomanKettle extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 32;
  
  public ModelRomanKettle() {
    this.headModel = new ModelRendererTurbo[11];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 97, 17, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -7.7F, -4.0F, 8, 3, 8, 0.0F, 0.7F, 0.6F, 0.7F, 0.7F, 0.6F, 0.7F, 0.7F, 0.2F, 1.0F, 0.7F, 0.2F, 1.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -10.4F, -4.0F, 8, 2, 8, 0.0F, -3.8F, 2.5F, -4.3F, -3.8F, 2.5F, -4.3F, -3.8F, 2.5F, -3.5F, -3.8F, 2.5F, -3.5F, 0.7F, 0.1F, 0.7F, 0.7F, 0.1F, 0.7F, 0.7F, 0.5F, 1.0F, 0.7F, 0.5F, 1.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -5.7F, -4.0F, 8, 2, 8, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.7F, 0.9F, 0.9F, -0.3F, 0.9F, 0.9F, -0.3F, 0.9F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-5.0F, -5.7F, 4.8F, 10, 2, 2, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(4.9F, -6.1F, -4.8F, 2, 2, 10, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.9F, -0.3F, 0.0F, -1.8F, -0.3F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.1F, -0.3F, 0.0F, 0.1F, -0.3F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-6.9F, -6.1F, -4.8F, 2, 2, 10, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.6F, -0.3F, 0.0F, -1.9F, -0.3F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.1F, -0.3F, 0.0F, 0.1F, -0.3F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-7.01F, -6.1F, -6.8F, 2, 2, 2, 0.0F, -1.0F, -1.5F, -1.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.5F, 0.0F, -1.0F, -0.3F, -1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(5.01F, -6.1F, -6.8F, 2, 2, 2, 0.0F, 0.0F, -1.5F, 0.0F, -1.0F, -1.5F, -1.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -0.3F, 0.0F, -1.0F, -0.3F, -1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(5.01F, -5.7F, 4.91F, 2, 2, 2, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.5F, 0.0F, -1.0F, -1.5F, -1.0F, 0.0F, -1.5F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -1.0F, -0.3F, -1.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-7.01F, -5.7F, 4.91F, 2, 2, 2, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.5F, 0.0F, -1.0F, -1.5F, -1.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -1.0F, -0.3F, -1.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-5.0F, -6.1F, -6.8F, 10, 2, 2, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
