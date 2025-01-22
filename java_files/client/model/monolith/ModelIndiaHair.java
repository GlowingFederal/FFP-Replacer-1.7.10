package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelIndiaHair extends ModelCustomArmour {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelIndiaHair() {
    this.headModel = new ModelRendererTurbo[11];
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-2.7F, -4.8F, -3.9F, 2, 1, 1, 0.0F, -0.2F, -0.3F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, -0.5F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, 0.1F, 0.0F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F, 0.0F, 0.2F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-2.0F, -2.5F, -4.05F, 2, 1, 1, 0.0F, -0.5F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-3.2F, -4.8F, -3.9F, 1, 1, 1, 0.0F, 0.2F, -0.6F, 0.2F, -0.3F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.6F, 0.2F, 0.3F, -0.1F, 0.2F, 0.4F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.4F, 0.2F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-0.5F, -5.3F, -4.02F, 1, 1, 1, 0.0F, -0.1F, -0.3F, 0.0F, -0.1F, -0.3F, 0.0F, -0.1F, -0.3F, 0.0F, -0.1F, -0.3F, 0.0F, -0.1F, -0.3F, 0.0F, -0.1F, -0.3F, 0.0F, -0.1F, -0.3F, 0.0F, -0.1F, -0.3F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-2.5F, -2.2F, -4.05F, 1, 1, 1, 0.0F, -0.2F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.4F, -0.2F, 0.0F, 0.0F, -0.6F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-2.5F, -2.2F, -4.05F, 1, 1, 1, 0.0F, 0.2F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, -0.4F, 0.0F, -0.6F, -0.2F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(2.2F, -4.8F, -3.9F, 1, 1, 1, 0.0F, -0.3F, -0.3F, 0.2F, 0.2F, -0.6F, 0.2F, 0.0F, -0.6F, 0.2F, 0.0F, -0.3F, 0.2F, 0.4F, -0.4F, 0.2F, 0.3F, -0.1F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(0.7F, -4.8F, -3.9F, 2, 1, 1, 0.0F, 0.0F, -0.5F, 0.2F, -0.2F, -0.3F, 0.2F, -0.5F, -0.3F, 0.2F, 0.0F, -0.5F, 0.2F, 0.1F, 0.0F, 0.2F, -0.3F, -0.3F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.2F, 0.2F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(0.0F, -2.5F, -4.05F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(1.5F, -2.2F, -4.05F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.0F, -0.4F, -0.2F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(1.5F, -2.2F, -4.05F, 1, 1, 1, 0.0F, -0.5F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.6F, -0.2F, 0.0F, 0.3F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
