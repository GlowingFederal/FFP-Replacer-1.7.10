package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelDvina extends ModelVehicle {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelDvina() {
    this.bodyModel = new ModelRendererTurbo[4];
    this.turretModel = new ModelRendererTurbo[9];
    this.barrelModel = new ModelRendererTurbo[13];
    initbodyModel_1();
    initturretModel_1();
    initbarrelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 409, 57, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 265, 81, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 137, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 97, 169, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 24, 18, 24, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[0].func_78793_a(-12.0F, -2.0F, -12.0F);
    this.bodyModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 10, 10, 75, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[1].func_78793_a(-5.0F, 6.0F, 0.0F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 10, 10, 75, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[2].func_78793_a(-5.0F, 6.0F, -75.0F);
    this.bodyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 140, 10, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[3].func_78793_a(-70.0F, 6.0F, -6.0F);
  }
  
  private void initturretModel_1() {
    this.turretModel[0] = new ModelRendererTurbo((ModelBase)this, 177, 193, this.textureX, this.textureY);
    this.turretModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 233, this.textureX, this.textureY);
    this.turretModel[2] = new ModelRendererTurbo((ModelBase)this, 201, 233, this.textureX, this.textureY);
    this.turretModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 273, this.textureX, this.textureY);
    this.turretModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 329, this.textureX, this.textureY);
    this.turretModel[5] = new ModelRendererTurbo((ModelBase)this, 225, 289, this.textureX, this.textureY);
    this.turretModel[6] = new ModelRendererTurbo((ModelBase)this, 489, 33, this.textureX, this.textureY);
    this.turretModel[7] = new ModelRendererTurbo((ModelBase)this, 361, 81, this.textureX, this.textureY);
    this.turretModel[8] = new ModelRendererTurbo((ModelBase)this, 193, 81, this.textureX, this.textureY);
    this.turretModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 90, 30, 6, 0.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.turretModel[0].func_78793_a(-40.0F, -30.0F, -12.0F);
    this.turretModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 90, 30, 6, 0.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.turretModel[1].func_78793_a(-40.0F, -30.0F, 6.0F);
    this.turretModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 90, 30, 18, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, 0.0F, 0.0F, 12.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F);
    this.turretModel[2].func_78793_a(-40.0F, -30.0F, -30.0F);
    this.turretModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 90, 30, 18, 0.0F, 12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -18.0F, 0.0F, 0.0F, -18.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, 0.0F, 0.0F);
    this.turretModel[3].func_78793_a(-40.0F, -30.0F, 12.0F);
    this.turretModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 142, 4, 18, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.turretModel[4].func_78793_a(-93.0F, -4.0F, -9.0F);
    this.turretModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 72, 4, 24, 0.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 4.0F);
    this.turretModel[5].func_78793_a(-160.0F, -31.0F, -12.0F);
    (this.turretModel[5]).field_78808_h = -0.36651915F;
    this.turretModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 3, 41, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.turretModel[6].func_78793_a(-145.0F, -21.0F, -2.0F);
    (this.turretModel[6]).field_78808_h = 0.34906584F;
    this.turretModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 3, 32, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.turretModel[7].func_78793_a(-118.0F, -14.0F, -2.0F);
    (this.turretModel[7]).field_78808_h = -0.34906584F;
    this.turretModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 18, 4, 16, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.turretModel[8].func_78793_a(-139.0F, 13.0F, -8.0F);
  }
  
  private void initbarrelModel_1() {
    this.barrelModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.barrelModel[1] = new ModelRendererTurbo((ModelBase)this, 361, 1, this.textureX, this.textureY);
    this.barrelModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.barrelModel[3] = new ModelRendererTurbo((ModelBase)this, 441, 1, this.textureX, this.textureY);
    this.barrelModel[4] = new ModelRendererTurbo((ModelBase)this, 137, 33, this.textureX, this.textureY);
    this.barrelModel[5] = new ModelRendererTurbo((ModelBase)this, 241, 33, this.textureX, this.textureY);
    this.barrelModel[6] = new ModelRendererTurbo((ModelBase)this, 345, 33, this.textureX, this.textureY);
    this.barrelModel[7] = new ModelRendererTurbo((ModelBase)this, 137, 57, this.textureX, this.textureY);
    this.barrelModel[8] = new ModelRendererTurbo((ModelBase)this, 241, 57, this.textureX, this.textureY);
    this.barrelModel[9] = new ModelRendererTurbo((ModelBase)this, 337, 57, this.textureX, this.textureY);
    this.barrelModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.barrelModel[11] = new ModelRendererTurbo((ModelBase)this, 97, 81, this.textureX, this.textureY);
    this.barrelModel[12] = new ModelRendererTurbo((ModelBase)this, 1, 105, this.textureX, this.textureY);
    this.barrelModel[0].addShapeBox(32.0F, -22.0F, -6.0F, 166, 12, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[0].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[1].addShapeBox(198.0F, -22.0F, -6.0F, 24, 12, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, -5.0F, 0.0F, -5.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -5.0F, -5.0F, 0.0F, -5.0F, -5.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[1].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[2].addShapeBox(2.0F, -24.0F, -8.0F, 50, 16, 16, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[2].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[3].addShapeBox(-16.0F, -22.0F, -6.0F, 18, 12, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, -3.0F, 0.0F, -3.0F, -3.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[3].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[4].addShapeBox(-14.0F, -43.5F, -28.0F, 50, 20, 1, 0.0F, 0.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F);
    this.barrelModel[4].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[5].addShapeBox(-14.0F, -43.5F, 27.0F, 50, 20, 1, 0.0F, 0.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, -20.0F);
    this.barrelModel[5].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[6].addShapeBox(-14.0F, -8.5F, 27.0F, 50, 20, 1, 0.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[6].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[7].addShapeBox(-14.0F, -8.5F, -28.0F, 50, 20, 1, 0.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, -20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 20.0F, 0.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[7].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[8].addShapeBox(96.0F, -10.5F, -22.0F, 44, 16, 1, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[8].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[9].addShapeBox(96.0F, -37.5F, -22.0F, 44, 16, 1, 0.0F, 0.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 16.0F);
    this.barrelModel[9].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[10].addShapeBox(96.0F, -37.5F, 21.0F, 44, 16, 1, 0.0F, 0.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F);
    this.barrelModel[10].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[11].addShapeBox(96.0F, -10.5F, 21.0F, 44, 16, 1, 0.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, -35.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[11].func_78793_a(-54.0F, -30.0F, 0.0F);
    this.barrelModel[12].addShapeBox(-9.0F, -8.0F, -6.0F, 156, 17, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[12].func_78793_a(-54.0F, -30.0F, 0.0F);
  }
}
