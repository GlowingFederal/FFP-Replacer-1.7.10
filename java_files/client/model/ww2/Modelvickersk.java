package com.flansmod.client.model.ww2;

import com.flansmod.client.model.ModelMG;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class Modelvickersk extends ModelMG {
  int textureX = 64;
  
  int textureY = 64;
  
  public Modelvickersk() {
    this.bipodModel = new ModelRendererTurbo[1];
    this.bipodModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bipodModel[0].addShapeBox(-0.5F, -2.3F, -0.5F, 1, 2, 1, 0.0F, -0.2F, 0.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.2F);
    this.bipodModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel = new ModelRendererTurbo[15];
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
    this.gunModel[0].func_78790_a(-0.5F, -2.2F, -9.5F, 1, 1, 22, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[1].func_78790_a(-1.0F, -2.5F, -7.5F, 2, 2, 9, 0.0F);
    this.gunModel[1].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[2].addShapeBox(-1.0F, -2.5F, 7.5F, 2, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.gunModel[2].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[3].func_78790_a(-0.5F, -1.1F, -1.5F, 1, 1, 10, 0.0F);
    this.gunModel[3].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[4].func_78790_a(-0.5F, 0.0F, -9.7F, 1, 1, 4, 0.0F);
    this.gunModel[4].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[5].func_78790_a(-0.5F, -3.2F, -6.5F, 1, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[6].func_78790_a(-0.5F, -3.0F, 9.5F, 1, 1, 1, 0.0F);
    this.gunModel[6].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[7].func_78790_a(-1.5F, -2.0F, -1.5F, 1, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[8].func_78790_a(-0.5F, -4.0F, 1.5F, 1, 2, 1, 0.0F);
    this.gunModel[8].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[9].func_78790_a(-1.0F, -0.5F, -7.5F, 2, 1, 8, 0.0F);
    this.gunModel[9].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[10].func_78790_a(-0.5F, -2.2F, -10.5F, 1, 4, 1, 0.0F);
    this.gunModel[10].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[11].func_78790_a(-0.5F, -2.2F, -14.5F, 1, 1, 4, 0.0F);
    this.gunModel[11].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[12].func_78790_a(-0.5F, -1.2F, -14.5F, 1, 2, 2, 0.0F);
    this.gunModel[12].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[13].func_78790_a(-0.5F, 0.8F, -14.5F, 1, 1, 4, 0.0F);
    this.gunModel[13].func_78793_a(0.0F, -3.0F, 0.0F);
    this.gunModel[14].func_78790_a(-0.5F, 0.0F, -6.7F, 1, 2, 2, 0.0F);
    this.gunModel[14].func_78793_a(0.0F, -3.0F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[3];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 9, 25, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(-1.0F, -3.5F, -5.0F, 2, 1, 6, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, -3.0F, 0.0F);
    this.ammoModel[1].addShapeBox(1.0F, -3.5F, -5.0F, 2, 1, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel[1].func_78793_a(0.0F, -3.0F, 0.0F);
    this.ammoModel[2].addShapeBox(-3.0F, -3.5F, -5.0F, 2, 1, 6, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
    this.ammoModel[2].func_78793_a(0.0F, -3.0F, 0.0F);
    flipAll();
  }
}
