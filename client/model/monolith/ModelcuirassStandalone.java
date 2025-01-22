package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelcuirassStandalone extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 32;
  
  public ModelcuirassStandalone() {
    this.bodyModel = new ModelRendererTurbo[12];
    initbodyModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 89, 17, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 22, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, -0.5F, -2.0F, 4, 2, 4, 0.0F, -0.5F, -0.2F, 0.5F, 0.0F, -0.3F, 0.15F, 0.0F, -0.3F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, 0.0F, 1.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.7F, 0.0F, 0.0F, 1.0F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(2.5F, -0.5F, -2.0F, 1, 3, 4, 0.0F, -0.2F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.5F, -0.2F, 0.0F, 0.6F, 0.0F, 0.3F, 1.5F, -0.2F, 0.0F, 1.2F, -0.2F, 0.0F, 1.2F, 0.0F, 0.3F, 1.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, -0.5F, -2.0F, 4, 2, 4, 0.0F, 0.0F, -0.3F, 0.15F, -0.5F, -0.2F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F, -0.3F, 0.5F, -0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.0F, -0.2F, 0.0F, 0.7F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-3.5F, -0.5F, -2.0F, 1, 3, 4, 0.0F, 0.0F, 0.0F, 0.3F, -0.2F, 0.0F, 0.3F, -0.2F, 0.0F, 0.6F, 0.0F, 0.0F, 0.5F, -0.2F, 0.0F, 1.2F, 0.0F, 0.3F, 1.5F, 0.0F, 0.3F, 1.5F, -0.2F, 0.0F, 1.2F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 1.5F, -2.0F, 8, 6, 4, 0.0F, -0.2F, 0.0F, 0.5F, -4.0F, 0.0F, 1.5F, -4.0F, 0.0F, 1.0F, -0.2F, 0.0F, 0.7F, -0.1F, -4.0F, 0.7F, -3.9F, -3.0F, 2.3F, -4.0F, -3.0F, 1.5F, -0.1F, -4.0F, 1.0F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 4.5F, -2.0F, 8, 6, 4, 0.0F, -0.1F, 1.0F, 0.7F, -3.9F, 0.0F, 2.3F, -4.0F, 0.0F, 1.5F, -0.1F, 1.0F, 1.0F, 0.9F, -4.0F, 0.8F, -3.8F, -2.49F, 2.1F, -4.0F, -3.0F, 1.2F, 0.9F, -4.0F, 0.8F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.0F, 7.5F, -2.0F, 8, 6, 4, 0.0F, 0.9F, 1.0F, 0.8F, -3.8F, -0.5F, 2.1F, -4.0F, 0.0F, 1.2F, 0.9F, 1.0F, 0.8F, 0.5F, -3.5F, 0.5F, -3.9F, -2.8F, 1.5F, -4.0F, -3.0F, 0.8F, 0.5F, -3.5F, 0.4F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-4.0F, 11.0F, -2.0F, 4, 1, 4, 0.0F, 0.5F, 1.0F, 0.5F, 0.0F, 0.3F, 1.5F, 0.0F, 0.5F, 0.8F, 0.5F, 1.0F, 0.4F, 0.6F, -1.8F, 0.7F, 0.0F, -0.8F, 2.0F, 0.0F, -0.8F, 1.2F, 0.6F, -1.8F, 0.6F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(0.0F, 11.0F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.3F, 1.5F, 0.5F, 1.0F, 0.5F, 0.5F, 1.0F, 0.4F, 0.0F, 0.5F, 0.8F, 0.0F, -0.8F, 2.0F, 0.6F, -1.8F, 0.7F, 0.6F, -1.8F, 0.6F, 0.0F, -0.8F, 1.2F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(0.0F, 7.5F, -2.0F, 8, 6, 4, 0.0F, -0.2F, -0.5F, 2.1F, -3.1F, 1.0F, 0.8F, -3.1F, 1.0F, 0.8F, 0.0F, 0.0F, 1.2F, -0.1F, -2.8F, 1.5F, -3.5F, -3.5F, 0.5F, -3.5F, -3.5F, 0.4F, 0.0F, -3.0F, 0.8F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(0.0F, 4.5F, -2.0F, 8, 6, 4, 0.0F, -0.1F, 0.0F, 2.3F, -4.1F, 1.0F, 0.7F, -4.1F, 1.0F, 1.0F, 0.0F, 0.0F, 1.5F, -0.2F, -2.49F, 2.1F, -3.1F, -4.0F, 0.8F, -3.1F, -4.0F, 0.8F, 0.0F, -3.0F, 1.2F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(0.0F, 1.5F, -2.0F, 8, 6, 4, 0.0F, 0.0F, 0.0F, 1.5F, -4.2F, 0.0F, 0.5F, -4.2F, 0.0F, 0.7F, 0.0F, 0.0F, 1.0F, -0.1F, -3.0F, 2.3F, -4.1F, -4.0F, 0.7F, -4.1F, -4.0F, 1.0F, 0.0F, -3.0F, 1.5F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
