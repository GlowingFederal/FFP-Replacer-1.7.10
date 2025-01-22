package com.flansmod.client.model.ww2;

import com.flansmod.client.model.ModelMG;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelvickerskGO extends ModelMG {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelvickerskGO() {
    this.bipodModel = new ModelRendererTurbo[1];
    this.bipodModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bipodModel[0].addShapeBox(-0.5F, -1.3F, -0.5F, 1, 2, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.bipodModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel = new ModelRendererTurbo[34];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.gunModel[15] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.gunModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[17] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[19] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.gunModel[20] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[21] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[22] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[23] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[24] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.gunModel[25] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[26] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[27] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.gunModel[28] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.gunModel[29] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.gunModel[30] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.gunModel[31] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.gunModel[32] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.gunModel[33] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(3.0F, -2.2F, -9.5F, 1, 1, 22, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[1].func_78790_a(2.5F, -2.5F, -7.5F, 2, 2, 9, 0.0F);
    this.gunModel[1].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[2].addShapeBox(2.5F, -2.5F, 7.5F, 2, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.gunModel[2].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[3].func_78790_a(3.0F, -1.1F, -1.5F, 1, 1, 10, 0.0F);
    this.gunModel[3].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[4].func_78790_a(3.0F, 0.0F, -9.7F, 1, 1, 4, 0.0F);
    this.gunModel[4].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[5].func_78790_a(3.0F, -3.2F, -6.5F, 1, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[6].func_78790_a(3.0F, -3.0F, 9.5F, 1, 1, 1, 0.0F);
    this.gunModel[6].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[7].func_78790_a(2.0F, -2.0F, -1.5F, 1, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[8].func_78790_a(3.0F, -4.0F, 1.5F, 1, 2, 1, 0.0F);
    this.gunModel[8].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[9].func_78790_a(2.5F, -0.5F, -7.5F, 2, 1, 8, 0.0F);
    this.gunModel[9].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[10].func_78790_a(3.0F, -2.2F, -10.5F, 1, 4, 1, 0.0F);
    this.gunModel[10].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[11].func_78790_a(3.0F, -2.2F, -14.5F, 1, 1, 4, 0.0F);
    this.gunModel[11].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[12].func_78790_a(3.0F, -1.2F, -14.5F, 1, 2, 2, 0.0F);
    this.gunModel[12].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[13].func_78790_a(3.0F, 0.8F, -14.5F, 1, 1, 4, 0.0F);
    this.gunModel[13].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[14].func_78790_a(3.0F, 0.0F, -6.7F, 1, 2, 2, 0.0F);
    this.gunModel[14].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[15].addShapeBox(3.0F, -0.3F, -0.5F, 1, 2, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.gunModel[15].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[16].func_78790_a(-4.0F, -2.2F, -9.5F, 1, 1, 22, 0.0F);
    this.gunModel[16].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[17].func_78790_a(-4.5F, -2.5F, -7.5F, 2, 2, 9, 0.0F);
    this.gunModel[17].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[18].addShapeBox(-4.5F, -2.5F, 7.5F, 2, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.gunModel[18].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[19].func_78790_a(-4.0F, -1.1F, -1.5F, 1, 1, 10, 0.0F);
    this.gunModel[19].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[20].func_78790_a(-4.0F, 0.0F, -9.7F, 1, 1, 4, 0.0F);
    this.gunModel[20].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[21].func_78790_a(-4.0F, -3.2F, -6.5F, 1, 1, 1, 0.0F);
    this.gunModel[21].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[22].func_78790_a(-4.0F, -3.0F, 9.5F, 1, 1, 1, 0.0F);
    this.gunModel[22].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[23].func_78790_a(-5.0F, -2.0F, -1.5F, 1, 1, 1, 0.0F);
    this.gunModel[23].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[24].func_78790_a(-4.0F, -4.0F, 1.5F, 1, 2, 1, 0.0F);
    this.gunModel[24].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[25].func_78790_a(-4.5F, -0.5F, -7.5F, 2, 1, 8, 0.0F);
    this.gunModel[25].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[26].func_78790_a(-4.0F, -2.2F, -10.5F, 1, 4, 1, 0.0F);
    this.gunModel[26].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[27].func_78790_a(-4.0F, -2.2F, -14.5F, 1, 1, 4, 0.0F);
    this.gunModel[27].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[28].func_78790_a(-4.0F, -1.2F, -14.5F, 1, 2, 2, 0.0F);
    this.gunModel[28].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[29].func_78790_a(-4.0F, 0.8F, -14.5F, 1, 1, 4, 0.0F);
    this.gunModel[29].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[30].func_78790_a(-4.0F, 0.0F, -6.7F, 1, 2, 2, 0.0F);
    this.gunModel[30].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[31].addShapeBox(-4.0F, -0.3F, -0.5F, 1, 2, 1, 0.0F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F);
    this.gunModel[31].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[32].addShapeBox(-0.5F, 0.7F, -0.5F, 1, 2, 1, 0.0F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F);
    this.gunModel[32].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[33].addShapeBox(-0.5F, -2.3F, -0.5F, 1, 2, 1, 0.0F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F, 3.4F, -0.5F, -0.3F);
    this.gunModel[33].func_78793_a(0.0F, -3.0F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[6];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.ammoModel[3] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.ammoModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.ammoModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(2.5F, -3.5F, -5.0F, 2, 1, 6, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, -3.0F, 0.0F);
    this.ammoModel[1].addShapeBox(4.5F, -3.5F, -5.0F, 2, 1, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel[1].func_78793_a(0.0F, -3.0F, 0.0F);
    this.ammoModel[2].addShapeBox(0.5F, -3.5F, -5.0F, 2, 1, 6, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
    this.ammoModel[2].func_78793_a(0.0F, -3.0F, 0.0F);
    this.ammoModel[3].func_78790_a(-4.5F, -3.5F, -5.0F, 2, 1, 6, 0.0F);
    this.ammoModel[3].func_78793_a(0.0F, -3.0F, 0.0F);
    this.ammoModel[4].addShapeBox(-2.5F, -3.5F, -5.0F, 2, 1, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel[4].func_78793_a(0.0F, -3.0F, 0.0F);
    this.ammoModel[5].addShapeBox(-6.5F, -3.5F, -5.0F, 2, 1, 6, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
    this.ammoModel[5].func_78793_a(0.0F, -3.0F, 0.0F);
    flipAll();
  }
}
