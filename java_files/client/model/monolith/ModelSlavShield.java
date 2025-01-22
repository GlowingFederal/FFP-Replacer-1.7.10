package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSlavShield extends ModelGun {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelSlavShield() {
    this.gunModel = new ModelRendererTurbo[27];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 15, 18, this.textureX, this.textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 25, 41, this.textureX, this.textureY);
    this.gunModel[15] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[16] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[17] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.gunModel[18] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.gunModel[19] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.gunModel[20] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.gunModel[21] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.gunModel[22] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.gunModel[23] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.gunModel[24] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.gunModel[25] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.gunModel[26] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
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
    this.gunModel[15].addShapeBox(0.1F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.2F, 6.5F, 0.0F, -0.2F, 6.5F, 0.0F, -0.2F, 6.5F, 0.0F, -0.2F, 6.5F, 0.0F, -0.2F, 6.5F, 0.0F, -0.2F, 6.5F, 0.0F, -0.2F, 6.5F, 0.0F, -0.2F, 6.5F);
    this.gunModel[15].func_78793_a(1.0F, -1.0F, -0.5F);
    this.gunModel[16].addShapeBox(0.1F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, 6.3F, 0.0F, 0.0F, 6.3F, 0.0F, 0.0F, 6.3F, 0.0F, 0.0F, 6.3F, 0.0F, 0.0F, 6.3F, 0.0F, 0.0F, 6.3F, 0.0F, 0.0F, 6.3F, 0.0F, 0.0F, 6.3F, 0.0F);
    this.gunModel[16].func_78793_a(1.0F, -1.0F, -0.5F);
    this.gunModel[17].addShapeBox(0.1F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 9.5F, -9.5F, 0.0F, 9.5F, -9.5F, 0.0F, 9.0F, 9.1F, 0.0F, 9.0F, 9.1F);
    this.gunModel[17].func_78793_a(1.0F, -5.5F, -5.0F);
    this.gunModel[18].addShapeBox(0.1F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.6F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 9.0F, 9.1F, 0.0F, 9.0F, 9.1F, 0.0F, 9.5F, -9.5F, 0.0F, 9.5F, -9.5F);
    this.gunModel[18].func_78793_a(1.0F, -5.5F, 4.0F);
    this.gunModel[19].addShapeBox(0.1F, 0.0F, 1.0F, 1, 1, 2, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.gunModel[19].func_78793_a(1.0F, -7.5F, -0.5F);
    this.gunModel[20].addShapeBox(0.1F, 0.0F, 1.0F, 1, 1, 2, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.gunModel[20].func_78793_a(1.0F, 5.5F, -3.5F);
    this.gunModel[21].addShapeBox(0.1F, 0.0F, 1.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.gunModel[21].func_78793_a(1.0F, -0.2F, 5.4F);
    this.gunModel[22].addShapeBox(0.1F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F);
    this.gunModel[22].func_78793_a(1.0F, -2.8F, -7.4F);
    this.gunModel[23].addShapeBox(0.1F, 0.0F, 1.0F, 1, 1, 2, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.gunModel[23].func_78793_a(1.0F, -6.3F, -5.0F);
    this.gunModel[24].addShapeBox(0.1F, 0.0F, 1.0F, 1, 1, 2, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -3.0F, -0.8F, 0.0F, -3.0F, -0.8F, 0.0F, -0.4F, 1.0F, 0.0F, -0.4F, 1.0F, 0.0F, 2.0F, -1.0F, 0.0F, 2.0F, -1.0F);
    this.gunModel[24].func_78793_a(1.0F, -5.7F, 4.0F);
    this.gunModel[25].addShapeBox(0.1F, 0.0F, 1.0F, 1, 1, 2, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.gunModel[25].func_78793_a(1.0F, 4.2F, 1.5F);
    this.gunModel[26].addShapeBox(0.1F, 0.0F, 0.0F, 1, 1, 2, 0.0F, 0.0F, 2.0F, -1.0F, 0.0F, 2.0F, -1.0F, 0.0F, -0.4F, 1.0F, 0.0F, -0.4F, 1.0F, 0.0F, -3.0F, -0.8F, 0.0F, -3.0F, -0.8F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.gunModel[26].func_78793_a(1.0F, 3.7F, -7.1F);
  }
}
