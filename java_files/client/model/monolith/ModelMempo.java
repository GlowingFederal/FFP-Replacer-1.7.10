package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMempo extends ModelCustomArmour {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelMempo() {
    this.headModel = new ModelRendererTurbo[13];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 2, 25, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -3.0F, -4.7F, 3, 1, 2, 0.0F, 0.4F, 0.1F, 0.0F, 0.0F, -0.2F, -0.1F, 0.0F, 0.3F, 0.8F, 0.8F, 0.6F, 0.8F, 0.2F, 0.0F, 0.6F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F, 0.6F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-0.5F, -3.7F, -4.9F, 1, 2, 1, 0.0F, -0.1F, 0.0F, -0.6F, -0.1F, 0.0F, -0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, -0.5F, 0.7F, 0.2F, -0.5F, 0.7F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-1.5F, -3.4F, -4.9F, 1, 1, 1, 0.0F, -0.5F, -0.2F, -0.3F, 0.2F, -0.1F, -0.3F, 0.2F, -0.1F, 0.0F, -0.5F, -0.2F, 0.0F, 0.0F, 0.0F, 0.3F, -0.1F, 0.0F, 0.5F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F, 0.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-1.0F, -2.4F, -4.9F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-3.0F, -2.4F, -4.9F, 2, 1, 1, 0.0F, -0.3F, 0.0F, 0.3F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.5F, 0.0F, 0.3F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.0F, -2.0F, -4.5F, 3, 2, 2, 0.0F, 0.1F, 0.1F, 0.0F, -0.8F, 0.0F, 0.1F, -0.8F, 0.0F, 0.0F, 0.6F, 0.2F, 0.3F, 0.0F, 0.1F, 0.0F, -0.2F, 0.3F, 0.2F, -0.2F, 0.3F, 0.0F, 0.4F, 0.1F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-1.0F, -1.5F, -4.7F, 1, 2, 2, 0.0F, 0.8F, -0.4F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.8F, -0.4F, 0.0F, 0.3F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-4.0F, -3.0F, -2.0F, 8, 1, 6, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.1F, -1.0F, 0.1F, 0.1F, -1.0F, 0.1F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(1.0F, -2.4F, -4.9F, 2, 1, 1, 0.0F, 0.0F, -0.3F, 0.0F, -0.3F, 0.0F, 0.3F, -0.3F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -0.5F, 0.0F, 0.3F, -0.5F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(1.0F, -3.0F, -4.7F, 3, 1, 2, 0.0F, 0.0F, -0.2F, -0.1F, 0.4F, 0.1F, 0.0F, 0.8F, 0.6F, 0.8F, 0.0F, 0.3F, 0.8F, 0.0F, 0.2F, 0.0F, 0.2F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.0F, 0.0F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(1.0F, -2.0F, -4.5F, 3, 2, 2, 0.0F, -0.8F, 0.0F, 0.1F, 0.1F, 0.1F, 0.0F, 0.6F, 0.2F, 0.3F, -0.8F, 0.0F, 0.0F, -0.2F, 0.3F, 0.2F, 0.0F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, -0.2F, 0.3F, 0.0F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(0.0F, -1.5F, -4.7F, 1, 2, 2, 0.0F, 0.0F, -0.2F, 0.0F, 0.8F, -0.4F, 0.0F, 0.8F, -0.4F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.2F, 0.3F, 0.0F, 0.2F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(0.5F, -3.4F, -4.9F, 1, 1, 1, 0.0F, 0.2F, -0.1F, -0.3F, -0.5F, -0.2F, -0.3F, -0.5F, -0.2F, 0.0F, 0.2F, -0.1F, 0.0F, -0.1F, 0.0F, 0.5F, 0.0F, 0.0F, 0.3F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F, 0.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
