package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelJazayer extends ModelGun {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelJazayer() {
    this.gunModel = new ModelRendererTurbo[17];
    this.ammoModel = new ModelRendererTurbo[1];
    initgunModel_1();
    initammoModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 9, 17, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.gunModel[15] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.gunModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 17, 2, 2, 0.0F, 10.0F, -0.3F, 0.0F, 10.0F, -0.3F, -0.2F, 10.0F, -0.3F, -0.2F, 10.0F, -0.3F, 0.0F, 10.0F, 0.0F, 0.0F, 10.0F, -0.7F, -0.3F, 10.0F, -0.7F, -0.3F, 10.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(19.0F, -4.5F, -1.0F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 12, 2, 2, 0.0F, 0.0F, -0.9F, 0.2F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.9F, 0.2F, -1.0F, 2.5F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, -1.0F, 2.5F, 0.2F);
    this.gunModel[1].func_78793_a(-13.5F, -4.0F, -1.0F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 6, 1, 2, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2].func_78793_a(3.0F, -3.0F, -1.0F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F, 15.0F, -0.1F, -0.1F, 15.0F, -0.1F, -0.1F, 15.0F, -0.1F, -0.1F, 15.0F, -0.1F, -0.1F, 15.0F, -0.1F, -0.1F, 15.0F, -0.1F, -0.1F, 15.0F, -0.1F, -0.1F, 15.0F, -0.1F, -0.1F);
    this.gunModel[3].func_78793_a(22.0F, -4.9F, -0.5F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.0F, 0.0F);
    this.gunModel[4].func_78793_a(46.0F, -4.9F, -0.5F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[5].func_78793_a(1.0F, -4.0F, -1.0F);
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.gunModel[6].func_78793_a(2.0F, -4.7F, -1.2F);
    this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.gunModel[7].func_78793_a(1.2F, -3.7F, -0.5F);
    this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F);
    this.gunModel[8].func_78793_a(0.2F, -0.9F, -0.5F);
    (this.gunModel[8]).field_78808_h = 0.7853982F;
    this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.gunModel[9].func_78793_a(6.0F, -4.3F, -1.9F);
    this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F, -0.3F, 0.3F, -0.3F);
    this.gunModel[10].func_78793_a(5.5F, -5.6F, -1.9F);
    this.gunModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F, -0.2F, -0.3F, -0.3F);
    this.gunModel[11].func_78793_a(6.2F, -4.7F, -1.9F);
    this.gunModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F, -0.1F, -0.3F, -0.2F);
    this.gunModel[12].func_78793_a(6.0F, -5.4F, -1.9F);
    this.gunModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F);
    this.gunModel[13].func_78793_a(1.0F, -4.9F, -0.5F);
    this.gunModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[14].func_78793_a(0.0F, -4.0F, -1.0F);
    this.gunModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F, 0.5F, -0.3F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.5F, -0.3F, 0.0F, 0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F);
    this.gunModel[15].func_78793_a(-1.0F, -4.0F, -1.0F);
    this.gunModel[16].addShapeBox(-1.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F, -0.2F, -0.3F, 0.0F);
    this.gunModel[16].func_78793_a(-0.5F, -2.1F, -0.5F);
    (this.gunModel[16]).field_78808_h = -0.62831855F;
  }
  
  private void initammoModel_1() {
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F, -0.2F);
    this.ammoModel[0].func_78793_a(46.0F, -4.8F, -0.5F);
  }
}
