package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMp40 extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelMp40() {
    this.gunModel = new ModelRendererTurbo[10];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 100, 150, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 113, 150, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 100, 175, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 100, 165, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 115, 165, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 150, 150, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 160, 150, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 160, 150, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 160, 165, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 150, 180, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 2, 7, 2, 0.0F);
    this.gunModel[0].func_78793_a(-1.0F, -4.0F, -1.0F);
    (this.gunModel[0]).field_78808_h = -0.2268928F;
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 14, 3, 2, 0.0F);
    this.gunModel[1].func_78793_a(-2.0F, -4.0F, -1.0F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 10, 2, 3, 0.0F);
    this.gunModel[2].func_78793_a(0.0F, -2.6F, -1.5F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
    this.gunModel[3].func_78793_a(11.1F, -2.8F, -1.0F);
    (this.gunModel[3]).field_78808_h = 0.4886922F;
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
    this.gunModel[4].func_78793_a(12.0F, -4.0F, -1.0F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(20.0F, -4.0F, -0.5F);
    (this.gunModel[5]).field_78808_h = 0.418879F;
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[6].func_78793_a(1.0F, -4.3F, 0.2F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(1.0F, -4.3F, -1.2F);
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
    this.gunModel[8].func_78793_a(14.0F, -3.7F, -0.5F);
    this.gunModel[9].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[9].func_78793_a(10.0F, -1.0F, -0.5F);
    (this.gunModel[9]).field_78808_h = 0.03490658F;
    this.ammoModel = new ModelRendererTurbo[2];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 135, 175, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 135, 175, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(10.3F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[0]).field_78808_h = 0.03490658F;
    this.ammoModel[1].func_78790_a(10.8F, 0.0F, -0.5F, 1, 7, 1, 0.0F);
    this.ammoModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[1]).field_78808_h = 0.03490658F;
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
    flipAll();
    translateAll(0.0F, 3.0F, 0.0F);
  }
}
