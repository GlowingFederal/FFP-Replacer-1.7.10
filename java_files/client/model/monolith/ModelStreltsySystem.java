package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelStreltsySystem extends ModelVehicle {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelStreltsySystem() {
    this.turretModel = new ModelRendererTurbo[9];
    this.barrelModel = new ModelRendererTurbo[27];
    initturretModel_1();
    initbarrelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initturretModel_1() {
    this.turretModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.turretModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.turretModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.turretModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.turretModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.turretModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.turretModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.turretModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.turretModel[8] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.turretModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 26, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.turretModel[0].func_78793_a(-0.5F, -17.0F, -0.5F);
    this.turretModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.turretModel[1].func_78793_a(-0.5F, -17.0F, -0.5F);
    this.turretModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.3F, 4.0F, -0.1F, -0.3F, 4.0F, -0.1F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.3F, 1.8F, -0.1F, -0.3F, 1.8F, -0.1F);
    this.turretModel[2].func_78793_a(-0.5F, -17.0F, 0.7F);
    this.turretModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, -0.3F, 0.4F, 0.1F, -0.3F, 0.4F, 0.1F, -0.4F, 0.4F, 0.3F, -0.4F, 0.4F, 0.3F, -0.3F, 0.0F, 0.1F, -0.3F, 0.0F, 0.1F, -0.4F, 0.0F, -0.1F, -0.4F, 0.0F, -0.1F);
    this.turretModel[3].func_78793_a(-0.5F, -16.5F, 1.7F);
    this.turretModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.3F, 0.0F, 0.1F, -0.3F, 0.0F, 0.1F, -0.4F, 0.0F, -0.1F, -0.4F, 0.0F, -0.1F, -0.3F, 1.0F, 1.1F, -0.3F, 1.0F, 1.1F, -0.4F, -0.5F, -0.5F, -0.4F, -0.5F, -0.5F);
    this.turretModel[4].func_78793_a(-0.5F, -10.5F, 1.7F);
    this.turretModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.turretModel[5].func_78793_a(-0.5F, 9.0F, -0.5F);
    this.turretModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F, -0.3F, 0.0F, 0.1F, -0.3F, 0.0F, 0.1F, -0.4F, -2.0F, -0.1F, -0.4F, -2.0F, -0.1F, -0.3F, 0.4F, 0.1F, -0.3F, 0.4F, 0.1F, -0.4F, 0.4F, 0.3F, -0.4F, 0.4F, 0.3F);
    this.turretModel[6].func_78793_a(-0.5F, -23.3F, 1.7F);
    this.turretModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.4F, 1.8F, 1.0F, -0.4F, 1.8F, 1.0F, -0.3F, 0.0F, 0.1F, -0.3F, 0.0F, 0.1F, -0.4F, -0.5F, 0.8F, -0.4F, -0.5F, 0.8F, -0.3F, 1.5F, 0.1F, -0.3F, 1.5F, 0.1F);
    this.turretModel[7].func_78793_a(-0.5F, -23.3F, 0.7F);
    this.turretModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.4F, 0.0F, -0.5F, -0.4F, 0.0F, -0.5F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F);
    this.turretModel[8].func_78793_a(-0.5F, -22.3F, 0.7F);
  }
  
  private void initbarrelModel_1() {
    this.barrelModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.barrelModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.barrelModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.barrelModel[3] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.barrelModel[4] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.barrelModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.barrelModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.barrelModel[7] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.barrelModel[8] = new ModelRendererTurbo((ModelBase)this, 41, 33, this.textureX, this.textureY);
    this.barrelModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.barrelModel[10] = new ModelRendererTurbo((ModelBase)this, 9, 41, this.textureX, this.textureY);
    this.barrelModel[11] = new ModelRendererTurbo((ModelBase)this, 17, 41, this.textureX, this.textureY);
    this.barrelModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.barrelModel[13] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.barrelModel[14] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.barrelModel[15] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.barrelModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.barrelModel[17] = new ModelRendererTurbo((ModelBase)this, 57, 41, this.textureX, this.textureY);
    this.barrelModel[18] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.barrelModel[19] = new ModelRendererTurbo((ModelBase)this, 33, 49, this.textureX, this.textureY);
    this.barrelModel[20] = new ModelRendererTurbo((ModelBase)this, 41, 49, this.textureX, this.textureY);
    this.barrelModel[21] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.barrelModel[22] = new ModelRendererTurbo((ModelBase)this, 57, 49, this.textureX, this.textureY);
    this.barrelModel[23] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.barrelModel[24] = new ModelRendererTurbo((ModelBase)this, 17, 57, this.textureX, this.textureY);
    this.barrelModel[25] = new ModelRendererTurbo((ModelBase)this, 25, 57, this.textureX, this.textureY);
    this.barrelModel[26] = new ModelRendererTurbo((ModelBase)this, 33, 57, this.textureX, this.textureY);
    this.barrelModel[0].addShapeBox(-1.0F, -2.0F, -1.0F, 17, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.3F, 0.0F, -0.5F, -0.3F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[0].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[1].addShapeBox(-17.5F, -1.5F, -1.0F, 5, 2, 2, 0.0F, 0.0F, -0.3F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, 0.2F, 0.0F, 1.5F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 1.5F, 0.2F);
    this.barrelModel[1].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[2].addShapeBox(-8.0F, -0.5F, -1.0F, 7, 1, 2, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[2].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[3].addShapeBox(-4.0F, -2.4F, -0.5F, 26, 1, 1, 0.0F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F);
    this.barrelModel[3].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[4].addShapeBox(22.0F, -2.4F, -0.5F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[4].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[5].addShapeBox(-10.0F, -1.5F, -1.0F, 2, 2, 2, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[5].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[6].addShapeBox(16.0F, -2.0F, -1.0F, 5, 2, 2, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.2F, 0.0F, -0.8F, -0.3F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -0.8F, -0.3F);
    this.barrelModel[6].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[7].addShapeBox(16.0F, -1.3F, -0.5F, 8, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.barrelModel[7].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[8].addShapeBox(-9.0F, -1.0F, -1.2F, 7, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[8].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[9].addShapeBox(-5.8F, 0.0F, -0.5F, 1, 1, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.barrelModel[9].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[10].addShapeBox(-6.0F, -3.4F, -0.5F, 2, 1, 1, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F);
    this.barrelModel[10].func_78793_a(0.0F, -17.0F, -0.5F);
    (this.barrelModel[10]).field_78808_h = 0.7853982F;
    this.barrelModel[11].addShapeBox(-3.0F, -1.8F, -1.9F, 1, 1, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.barrelModel[11].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[12].addShapeBox(-2.5F, -3.1F, -1.9F, 1, 1, 1, 0.0F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F);
    this.barrelModel[12].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[13].addShapeBox(-2.8F, -2.2F, -1.9F, 1, 1, 1, 0.0F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
    this.barrelModel[13].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[14].addShapeBox(-3.0F, -3.9F, -1.9F, 1, 1, 1, 0.0F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F);
    this.barrelModel[14].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[15].addShapeBox(-3.3F, -3.9F, -1.4F, 1, 1, 1, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F);
    this.barrelModel[15].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[16].addShapeBox(-8.0F, -2.4F, -0.5F, 7, 1, 1, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.1F, 0.4F, 0.0F, 0.1F, 0.4F, 0.0F, 0.1F, 0.4F, 0.0F, 0.1F, 0.4F);
    this.barrelModel[16].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[17].addShapeBox(-7.5F, -3.1F, -1.4F, 1, 1, 1, 0.0F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.3F);
    this.barrelModel[17].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[18].addShapeBox(-3.3F, -3.7F, -1.2F, 2, 1, 1, 0.0F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F);
    this.barrelModel[18].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[19].addShapeBox(-3.5F, -2.0F, -2.2F, 2, 1, 1, 0.0F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F, -0.1F, -0.3F, -0.3F);
    this.barrelModel[19].func_78793_a(0.0F, -17.0F, -0.5F);
    (this.barrelModel[19]).field_78796_g = -0.54105204F;
    (this.barrelModel[19]).field_78808_h = -0.7679449F;
    this.barrelModel[20].addShapeBox(-1.0F, -2.5F, -1.7F, 1, 5, 1, 0.0F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F, -0.3F);
    this.barrelModel[20].func_78793_a(0.0F, -17.0F, -0.5F);
    (this.barrelModel[20]).field_78796_g = -0.27925268F;
    this.barrelModel[21].addShapeBox(-11.0F, -1.5F, -1.0F, 1, 2, 2, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[21].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[22].addShapeBox(-12.0F, -1.5F, -1.0F, 1, 2, 2, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F);
    this.barrelModel[22].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[23].addShapeBox(-19.5F, -1.5F, -1.0F, 2, 2, 2, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, 0.3F, 0.0F, -0.5F, 2.5F, 0.0F, 0.0F, 1.5F, 0.2F, 0.0F, 1.5F, 0.2F, -0.5F, 2.5F, 0.0F);
    this.barrelModel[23].func_78793_a(0.0F, -17.0F, -0.5F);
    this.barrelModel[24].addShapeBox(-4.5F, 5.7F, -0.5F, 2, 1, 1, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F);
    this.barrelModel[24].func_78793_a(0.0F, -17.0F, -0.5F);
    (this.barrelModel[24]).field_78808_h = -0.7853982F;
    this.barrelModel[25].addShapeBox(-7.5F, 0.5F, -0.5F, 2, 1, 1, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F);
    this.barrelModel[25].func_78793_a(0.0F, -17.0F, -0.5F);
    (this.barrelModel[25]).field_78808_h = -0.5235988F;
    this.barrelModel[26].addShapeBox(-7.3F, 0.5F, -0.5F, 4, 1, 1, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F);
    this.barrelModel[26].func_78793_a(-4.0F, -17.0F, -0.5F);
    (this.barrelModel[26]).field_78808_h = 0.17453294F;
  }
}
