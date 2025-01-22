package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelFourMirrors extends ModelCustomArmour {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelFourMirrors() {
    this.bodyModel = new ModelRendererTurbo[20];
    initbodyModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-2.0F, 4.6F, -3.0F, 4, 1, 1, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-2.0F, 3.0F, -3.0F, 4, 1, 1, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-2.0F, 6.2F, -3.0F, 4, 1, 1, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-5.0F, 5.4F, -2.0F, 1, 1, 4, 0.0F, 0.1F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.1F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-5.1F, 3.8F, -2.0F, 1, 1, 4, 0.0F, 0.1F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.1F, 0.0F, -1.3F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.9F, 7.0F, -2.0F, 1, 1, 4, 0.0F, 0.1F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.1F, 0.3F, -0.1F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.1F, 0.0F, -1.3F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-5.0F, 4.0F, -2.5F, 5, 1, 1, 0.0F, -0.6F, -2.3F, 0.0F, 0.0F, 0.7F, 0.0F, -0.7F, 0.8F, 0.0F, -0.1F, -2.7F, 0.0F, -0.7F, 1.7F, 0.0F, 0.0F, -1.2F, 0.0F, 0.0F, -1.5F, 0.0F, -0.3F, 2.2F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-5.0F, 5.5F, -2.4F, 5, 1, 1, 0.0F, -0.6F, 0.5F, 0.0F, 0.0F, 0.2F, 0.0F, -0.7F, 0.3F, 0.0F, -0.1F, 0.6F, 0.0F, -0.7F, -1.1F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -1.0F, 0.0F, -0.3F, -1.1F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(0.0F, 4.0F, -2.5F, 5, 1, 1, 0.0F, 0.0F, 0.7F, 0.0F, -0.6F, -2.3F, 0.0F, -0.1F, -2.7F, 0.0F, -0.7F, 0.8F, 0.0F, 0.0F, -1.2F, 0.0F, -0.7F, 1.7F, 0.0F, -0.3F, 2.2F, 0.0F, 0.0F, -1.5F, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(0.0F, 5.5F, -2.4F, 5, 1, 1, 0.0F, 0.0F, 0.2F, 0.0F, -0.6F, 0.5F, 0.0F, -0.1F, 0.6F, 0.0F, -0.7F, 0.3F, 0.0F, 0.0F, -0.7F, 0.0F, -0.7F, -1.1F, 0.0F, -0.3F, -1.1F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(4.2F, 3.8F, -2.0F, 1, 1, 4, 0.0F, 0.0F, 0.0F, -1.3F, 0.1F, 0.0F, -1.3F, 0.1F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(4.1F, 5.4F, -2.0F, 1, 1, 4, 0.0F, 0.0F, 0.3F, -0.1F, 0.1F, 0.3F, -0.1F, 0.1F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(4.0F, 7.0F, -2.0F, 1, 1, 4, 0.0F, 0.0F, 0.3F, -0.1F, 0.1F, 0.3F, -0.1F, 0.1F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.1F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-2.0F, 3.0F, 2.0F, 4, 1, 1, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-2.0F, 4.6F, 2.0F, 4, 1, 1, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-2.0F, 6.2F, 2.0F, 4, 1, 1, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-5.0F, 5.5F, 1.4F, 5, 1, 1, 0.0F, -0.1F, 0.6F, 0.0F, -0.7F, 0.3F, 0.0F, 0.0F, 0.2F, 0.0F, -0.6F, 0.5F, 0.0F, -0.3F, -1.1F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.7F, 0.0F, -0.7F, -1.1F, 0.0F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-5.0F, 4.0F, 1.3F, 5, 1, 1, 0.0F, -0.1F, -2.7F, 0.0F, -0.7F, 0.8F, 0.0F, 0.0F, 0.7F, 0.0F, -0.6F, -2.3F, 0.0F, -0.3F, 2.2F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.2F, 0.0F, -0.7F, 1.7F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(0.0F, 5.5F, 1.4F, 5, 1, 1, 0.0F, -0.7F, 0.3F, 0.0F, -0.1F, 0.6F, 0.0F, -0.6F, 0.5F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -1.0F, 0.0F, -0.3F, -1.1F, 0.0F, -0.7F, -1.1F, 0.0F, 0.0F, -0.7F, 0.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(0.0F, 4.0F, 1.3F, 5, 1, 1, 0.0F, -0.7F, 0.8F, 0.0F, -0.1F, -2.7F, 0.0F, -0.6F, -2.3F, 0.0F, 0.0F, 0.7F, 0.0F, 0.0F, -1.5F, 0.0F, -0.3F, 2.2F, 0.0F, -0.7F, 1.7F, 0.0F, 0.0F, -1.2F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
