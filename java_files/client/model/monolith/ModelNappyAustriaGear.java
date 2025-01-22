package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelNappyAustriaGear extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelNappyAustriaGear() {
    this.bodyModel = new ModelRendererTurbo[22];
    initbodyModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-5.0F, -1.0F, 3.0F, 10, 2, 3, 0.0F, 0.1F, -0.8F, 0.3F, 0.1F, -0.8F, 0.3F, 0.1F, -0.8F, 0.4F, 0.1F, -0.8F, 0.4F, 0.1F, 0.0F, -0.5F, 0.1F, 0.0F, -0.5F, 0.1F, 0.0F, -0.5F, 0.1F, 0.0F, -0.5F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-5.0F, -2.0F, 3.0F, 10, 2, 3, 0.0F, 0.1F, -0.8F, 0.3F, 0.1F, -0.8F, 0.3F, 0.1F, -0.8F, 0.4F, 0.1F, -0.8F, 0.4F, 0.1F, -0.2F, 0.3F, 0.1F, -0.2F, 0.3F, 0.1F, -0.2F, 0.4F, 0.1F, -0.2F, 0.4F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-5.0F, -2.0F, 3.0F, 10, 2, 3, 0.0F, 0.1F, 0.3F, -0.5F, 0.1F, 0.3F, -0.5F, 0.1F, 0.3F, -0.5F, 0.1F, 0.3F, -0.5F, 0.1F, -1.2F, 0.3F, 0.1F, -1.2F, 0.3F, 0.1F, -1.2F, 0.4F, 0.1F, -1.2F, 0.4F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-5.0F, 1.0F, 2.5F, 10, 6, 3, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-5.0F, 9.5F, 3.0F, 5, 4, 2, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.4F, -0.2F, 0.0F, 0.0F, -0.2F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-5.0F, 9.5F, 4.2F, 5, 4, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.6F, -0.2F, 0.0F, -0.4F, -0.2F, -0.4F, -0.2F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.6F, -0.4F, 0.0F, -0.4F, -0.4F, -0.4F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(2.5F, 9.0F, 2.5F, 1, 12, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, -0.2F, -1.8F, -4.3F, 0.2F, -1.5F, -4.3F, 0.2F, -2.0F, 4.0F, -0.2F, -2.3F, 4.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(3.5F, -1.3F, -2.5F, 1, 1, 5, 0.0F, 0.1F, -0.4F, -1.0F, 0.4F, -0.6F, -1.0F, 0.4F, -0.6F, 0.0F, 0.1F, -0.4F, 0.0F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(3.5F, -0.3F, -2.5F, 1, 4, 5, 0.0F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, -0.1F, -0.4F, 0.1F, 0.0F, -0.5F, 0.1F, 0.0F, -0.5F, 0.0F, -0.1F, -0.4F, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(3.5F, 2.7F, -2.5F, 1, 3, 5, 0.0F, -0.1F, -0.6F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -0.1F, -0.6F, 0.0F, -0.88F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.88F, 0.0F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-3.5F, 1.0F, 5.5F, 1, 6, 1, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-3.5F, -3.0F, 7.0F, 1, 2, 1, 0.0F, -0.4F, -0.7F, 1.5F, 0.0F, -0.7F, 1.5F, 0.0F, -0.7F, -2.4F, -0.4F, -0.7F, -2.4F, -0.4F, -0.2F, 0.6F, 0.0F, -0.2F, 0.6F, 0.0F, -0.2F, -1.5F, -0.4F, -0.2F, -1.5F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-3.5F, -2.0F, 7.0F, 1, 2, 1, 0.0F, -0.4F, -0.8F, 0.6F, 0.0F, -0.8F, 0.6F, 0.0F, -0.8F, -1.5F, -0.4F, -0.8F, -1.5F, -0.4F, -0.2F, 0.6F, 0.0F, -0.2F, 0.6F, 0.0F, -0.2F, -1.5F, -0.4F, -0.2F, -1.5F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-3.5F, 0.0F, 7.0F, 1, 1, 1, 0.0F, -0.4F, 0.2F, 0.6F, 0.0F, 0.2F, 0.6F, 0.0F, 0.2F, -1.5F, -0.4F, 0.2F, -1.5F, -0.4F, 0.1F, 1.5F, 0.0F, 0.1F, 1.5F, 0.0F, 0.0F, -2.3F, -0.4F, 0.0F, -2.3F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(2.0F, -3.0F, 7.0F, 1, 2, 1, 0.0F, -0.4F, -0.7F, 1.5F, 0.0F, -0.7F, 1.5F, 0.0F, -0.7F, -2.4F, -0.4F, -0.7F, -2.4F, -0.4F, -0.2F, 0.6F, 0.0F, -0.2F, 0.6F, 0.0F, -0.2F, -1.5F, -0.4F, -0.2F, -1.5F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(2.0F, -2.0F, 7.0F, 1, 2, 1, 0.0F, -0.4F, -0.8F, 0.6F, 0.0F, -0.8F, 0.6F, 0.0F, -0.8F, -1.5F, -0.4F, -0.8F, -1.5F, -0.4F, -0.2F, 0.6F, 0.0F, -0.2F, 0.6F, 0.0F, -0.2F, -1.5F, -0.4F, -0.2F, -1.5F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(2.0F, 0.0F, 7.0F, 1, 1, 1, 0.0F, -0.4F, 0.2F, 0.6F, 0.0F, 0.2F, 0.6F, 0.0F, 0.2F, -1.5F, -0.4F, 0.2F, -1.5F, -0.4F, 0.1F, 1.5F, 0.0F, 0.1F, 1.5F, 0.0F, 0.0F, -2.3F, -0.4F, 0.0F, -2.3F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(2.0F, 1.0F, 5.5F, 1, 6, 1, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-4.5F, -1.3F, -2.5F, 1, 1, 5, 0.0F, 0.4F, -0.6F, -1.0F, 0.1F, -0.4F, -1.0F, 0.1F, -0.4F, 0.0F, 0.4F, -0.6F, 0.0F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(-4.5F, -0.3F, -2.5F, 1, 4, 5, 0.0F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.1F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.0F, -0.5F, 0.1F, -0.1F, -0.4F, 0.1F, -0.1F, -0.4F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(-4.5F, 2.7F, -2.5F, 1, 3, 5, 0.0F, 0.0F, -0.5F, 0.1F, -0.1F, -0.6F, 0.1F, -0.1F, -0.6F, 0.0F, 0.0F, -0.5F, 0.0F, -0.1F, 0.0F, 0.0F, -0.88F, 0.0F, 0.0F, -0.88F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(-4.5F, 2.3F, -2.65F, 9, 1, 5, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F, -0.1F, -0.3F, -0.1F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
