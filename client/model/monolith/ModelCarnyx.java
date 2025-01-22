package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelCarnyx extends ModelGun {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelCarnyx() {
    this.gunModel = new ModelRendererTurbo[20];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.gunModel[15] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.gunModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.gunModel[17] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.gunModel[18] = new ModelRendererTurbo((ModelBase)this, 17, 49, this.textureX, this.textureY);
    this.gunModel[19] = new ModelRendererTurbo((ModelBase)this, 33, 49, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 18, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 40.0F, 0.0F, 0.0F, 40.0F, 0.0F, 0.0F, 40.0F, 0.0F, 0.0F, 40.0F, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -65.0F, 3.0F);
    this.gunModel[1].addShapeBox(-1.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1].func_78793_a(1.0F, -7.0F, 3.0F);
    (this.gunModel[1]).field_78808_h = -0.27925268F;
    this.gunModel[2].addShapeBox(-1.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2].func_78793_a(0.5F, -5.0F, 3.0F);
    (this.gunModel[2]).field_78808_h = -0.89011794F;
    this.gunModel[3].addShapeBox(-1.0F, 3.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
    this.gunModel[3].func_78793_a(0.5F, -5.0F, 3.0F);
    (this.gunModel[3]).field_78808_h = -0.89011794F;
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[4].func_78793_a(-1.0F, -10.0F, 2.0F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[5].func_78793_a(-1.0F, -26.0F, 2.0F);
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[6].func_78793_a(-1.0F, -46.0F, 2.0F);
    this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[7].func_78793_a(-1.0F, -64.0F, 2.0F);
    this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, 0.2F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[8].func_78793_a(0.0F, -71.0F, 3.0F);
    this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.5F, 0.0F, 0.8F, 2.0F, -1.0F, 0.8F, 2.0F, -1.0F, 0.8F, -0.5F, 0.0F, 0.8F, 0.2F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.8F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F);
    this.gunModel[9].func_78793_a(0.0F, -74.0F, 3.0F);
    this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F, -1.0F, -0.5F, 0.3F, -0.5F, 0.0F, 0.3F, -0.5F, 0.0F, 0.3F, -1.0F, -0.5F, 0.3F, 0.0F, 0.0F, 0.3F, -0.5F, 1.0F, 0.3F, -0.5F, 1.0F, 0.3F, 0.0F, 0.0F, 0.3F);
    this.gunModel[10].func_78793_a(0.5F, -76.01F, 2.5F);
    this.gunModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, -0.2F, 0.3F, 0.0F, -0.2F, 0.3F, 0.0F, 0.0F, 0.3F);
    this.gunModel[11].func_78793_a(3.0F, -76.01F, 2.5F);
    this.gunModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 7, 5, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[12].func_78793_a(6.0F, -77.5F, 1.0F);
    this.gunModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 7, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, -0.8F, 0.0F, 0.0F, 0.0F, -2.0F, -1.0F, 0.0F, -2.0F, -1.0F, -0.8F, 0.0F, 0.0F);
    this.gunModel[13].func_78793_a(13.0F, -77.5F, 1.0F);
    (this.gunModel[13]).field_78808_h = -0.2268928F;
    this.gunModel[14].addShapeBox(0.0F, -1.0F, 0.0F, 6, 2, 5, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, -0.7F, -1.5F, 0.0F, -0.7F, -1.5F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -1.0F, -0.5F, -1.5F, -1.0F, -0.5F, -1.5F, 0.0F, 0.0F, 0.0F);
    this.gunModel[14].func_78793_a(13.0F, -73.5F, 1.0F);
    (this.gunModel[14]).field_78808_h = -0.19198622F;
    this.gunModel[15].addShapeBox(0.0F, -5.0F, 0.0F, 2, 6, 3, 0.0F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[15].func_78793_a(7.0F, -76.5F, 0.5F);
    this.gunModel[16].addShapeBox(0.0F, -5.0F, 0.0F, 2, 6, 3, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.gunModel[16].func_78793_a(7.0F, -76.5F, 3.5F);
    this.gunModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 6, 6, 1, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F);
    this.gunModel[17].func_78793_a(1.0F, -80.01F, 3.0F);
    (this.gunModel[17]).field_78808_h = 0.27925268F;
    this.gunModel[18].addShapeBox(-6.0F, 0.0F, 0.0F, 6, 4, 1, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F);
    this.gunModel[18].func_78793_a(1.0F, -80.01F, 3.0F);
    (this.gunModel[18]).field_78808_h = 0.9250245F;
    this.gunModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 3, 10, 1, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F, -1.0F, 0.0F, -0.3F);
    this.gunModel[19].func_78793_a(-2.6F, -75.3F, 3.0F);
    (this.gunModel[19]).field_78808_h = 0.08726646F;
  }
}
