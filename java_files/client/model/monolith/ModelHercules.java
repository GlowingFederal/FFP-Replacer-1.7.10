package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelHercules extends ModelVehicle {
  int textureX = 512;
  
  int textureY = 256;
  
  public ModelHercules() {
    this.turretModel = new ModelRendererTurbo[1];
    this.barrelModel = new ModelRendererTurbo[20];
    initturretModel_1();
    initbarrelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initturretModel_1() {
    this.turretModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 113, this.textureX, this.textureY);
    this.turretModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 150, 10, 24, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.turretModel[0].func_78793_a(-50.0F, 0.0F, -12.0F);
  }
  
  private void initbarrelModel_1() {
    this.barrelModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.barrelModel[1] = new ModelRendererTurbo((ModelBase)this, 145, 1, this.textureX, this.textureY);
    this.barrelModel[2] = new ModelRendererTurbo((ModelBase)this, 233, 1, this.textureX, this.textureY);
    this.barrelModel[3] = new ModelRendererTurbo((ModelBase)this, 329, 1, this.textureX, this.textureY);
    this.barrelModel[4] = new ModelRendererTurbo((ModelBase)this, 401, 1, this.textureX, this.textureY);
    this.barrelModel[5] = new ModelRendererTurbo((ModelBase)this, 457, 1, this.textureX, this.textureY);
    this.barrelModel[6] = new ModelRendererTurbo((ModelBase)this, 233, 17, this.textureX, this.textureY);
    this.barrelModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.barrelModel[8] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.barrelModel[9] = new ModelRendererTurbo((ModelBase)this, 289, 33, this.textureX, this.textureY);
    this.barrelModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.barrelModel[11] = new ModelRendererTurbo((ModelBase)this, 137, 49, this.textureX, this.textureY);
    this.barrelModel[12] = new ModelRendererTurbo((ModelBase)this, 425, 25, this.textureX, this.textureY);
    this.barrelModel[13] = new ModelRendererTurbo((ModelBase)this, 265, 57, this.textureX, this.textureY);
    this.barrelModel[14] = new ModelRendererTurbo((ModelBase)this, 337, 57, this.textureX, this.textureY);
    this.barrelModel[15] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.barrelModel[16] = new ModelRendererTurbo((ModelBase)this, 113, 73, this.textureX, this.textureY);
    this.barrelModel[17] = new ModelRendererTurbo((ModelBase)this, 209, 81, this.textureX, this.textureY);
    this.barrelModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 89, this.textureX, this.textureY);
    this.barrelModel[19] = new ModelRendererTurbo((ModelBase)this, 113, 97, this.textureX, this.textureY);
    this.barrelModel[0].addShapeBox(99.0F, -29.0F, -5.0F, 58, 10, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[0].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[1].addShapeBox(157.0F, -29.0F, -5.0F, 30, 10, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.8F, -4.8F, 0.0F, -4.8F, -4.8F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.8F, -4.8F, 0.0F, -4.8F, -4.8F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[1].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[2].addShapeBox(15.0F, -31.0F, -7.0F, 46, 6, 6, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F);
    this.barrelModel[2].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[3].addShapeBox(-5.0F, -31.0F, -7.0F, 20, 14, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[3].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[4].addShapeBox(-7.0F, -51.5F, -28.0F, 24, 20, 1, 0.0F, 0.0F, 0.0F, 0.0F, -15.0F, 0.0F, 0.0F, -15.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F);
    this.barrelModel[4].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[5].addShapeBox(-7.0F, -51.5F, 27.0F, 24, 20, 1, 0.0F, 0.0F, 0.0F, 0.0F, -15.0F, 0.0F, 0.0F, -15.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, -20.0F);
    this.barrelModel[5].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[6].addShapeBox(-7.0F, -16.5F, 27.0F, 24, 20, 1, 0.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, 0.0F, -15.0F, 0.0F, 0.0F, -15.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[6].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[7].addShapeBox(-7.0F, -16.5F, -28.0F, 24, 20, 1, 0.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 0.0F, -15.0F, 0.0F, 0.0F, -15.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[7].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[8].addShapeBox(80.0F, -20.5F, -20.0F, 65, 16, 1, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 0.0F, -55.0F, 0.0F, 0.0F, -55.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[8].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[9].addShapeBox(80.0F, -43.5F, -20.0F, 65, 16, 1, 0.0F, 0.0F, 0.0F, 0.0F, -55.0F, 0.0F, 0.0F, -55.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 16.0F);
    this.barrelModel[9].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[10].addShapeBox(80.0F, -43.5F, 19.0F, 65, 16, 1, 0.0F, 0.0F, 0.0F, 0.0F, -55.0F, 0.0F, 0.0F, -55.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F);
    this.barrelModel[10].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[11].addShapeBox(80.0F, -20.5F, 19.0F, 65, 16, 1, 0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, -55.0F, 0.0F, 0.0F, -55.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[11].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[12].addShapeBox(61.0F, -31.0F, -7.0F, 16, 14, 14, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.5F, 0.5F);
    this.barrelModel[12].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[13].addShapeBox(77.0F, -29.0F, -5.0F, 22, 10, 10, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F);
    this.barrelModel[13].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[14].addShapeBox(15.0F, -31.0F, 1.0F, 46, 6, 6, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F);
    this.barrelModel[14].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[15].addShapeBox(15.0F, -23.0F, 1.0F, 46, 6, 6, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F);
    this.barrelModel[15].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[16].addShapeBox(15.0F, -23.0F, -7.0F, 46, 6, 6, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F);
    this.barrelModel[16].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[17].addShapeBox(0.0F, -17.0F, -6.0F, 124, 8, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[17].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[18].addShapeBox(0.0F, -6.0F, -5.0F, 50, 5, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[18].func_78793_a(-40.0F, 2.0F, 0.0F);
    this.barrelModel[19].addShapeBox(50.0F, -6.0F, -5.0F, 40, 5, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 8.0F, 0.0F, 0.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[19].func_78793_a(-40.0F, 2.0F, 0.0F);
  }
}
