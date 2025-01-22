package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRoundShield extends ModelGun {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelRoundShield() {
    this.gunModel = new ModelRendererTurbo[15];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 0, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 15, 18, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 34, 9, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 27, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 15, 18, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 27, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 34, 9, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 15, 18, this.textureX, this.textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 15, 18, this.textureX, this.textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 25, 0, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 16, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(1.0F, -1.0F, -8.0F);
    this.gunModel[1].addShapeBox(0.0F, -5.0F, 0.0F, 1, 1, 8, 0.0F, 0.0F, -0.1F, -3.5F, 0.0F, -0.1F, -3.5F, 0.0F, -0.1F, -3.5F, 0.0F, -0.1F, -3.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1].func_78793_a(1.0F, -3.5F, -4.0F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 12, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.gunModel[2].func_78793_a(1.0F, -7.5F, -6.0F);
    this.gunModel[3].addShapeBox(0.0F, -3.0F, 0.0F, 1, 3, 14, 0.0F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F);
    this.gunModel[3].func_78793_a(1.0F, -1.0F, -7.0F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.gunModel[4].func_78793_a(1.3F, -1.0F, -2.0F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[5].func_78793_a(2.3F, -1.0F, -1.5F);
    this.gunModel[6].addShapeBox(0.0F, -1.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[6].func_78793_a(2.3F, -0.99F, -1.5F);
    this.gunModel[7].addShapeBox(0.0F, -1.7F, 0.0F, 1, 1, 4, 0.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.gunModel[7].func_78793_a(1.3F, -1.0F, -2.0F);
    this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 12, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F);
    this.gunModel[8].func_78793_a(1.0F, -5.5F, -6.0F);
    this.gunModel[9].addShapeBox(0.0F, -1.3F, 0.0F, 1, 1, 4, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F);
    this.gunModel[9].func_78793_a(1.3F, 2.0F, -2.0F);
    this.gunModel[10].addShapeBox(0.0F, -1.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, -0.95F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.gunModel[10].func_78793_a(2.3F, 1.01F, -1.5F);
    this.gunModel[11].addShapeBox(0.0F, 1.0F, 0.0F, 1, 3, 14, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F);
    this.gunModel[11].func_78793_a(1.0F, -1.0F, -7.0F);
    this.gunModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 12, 0.0F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.gunModel[12].func_78793_a(1.0F, 2.5F, -6.0F);
    this.gunModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 12, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F);
    this.gunModel[13].func_78793_a(1.0F, 4.5F, -6.0F);
    this.gunModel[14].addShapeBox(0.0F, -5.0F, 0.0F, 1, 1, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, -3.5F, 0.0F, -0.1F, -3.5F, 0.0F, -0.1F, -3.5F, 0.0F, -0.1F, -3.5F);
    this.gunModel[14].func_78793_a(1.0F, 11.5F, -4.0F);
  }
}
