package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPPSH extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelPPSH() {
    this.gunModel = new ModelRendererTurbo[10];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 310, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 300, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 290, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 280, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 270, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 5, 300, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 250, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 240, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 235, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 0, 230, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 20, 1, 1, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -6.0F, -0.5F);
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 11, 2, 2, 0.0F);
    this.gunModel[1].func_78793_a(0.0F, -5.5F, -1.0F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 7, 2, 1, 0.0F);
    this.gunModel[2].func_78793_a(-5.0F, -4.0F, -0.5F);
    (this.gunModel[2]).field_78808_h = 0.2094395F;
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 4, 3, 1, 0.0F);
    this.gunModel[3].func_78793_a(-8.0F, -4.0F, -0.5F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
    this.gunModel[4].func_78793_a(-9.0F, -4.0F, -0.5F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F);
    this.gunModel[5].func_78793_a(7.3F, -5.0F, -1.5F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[6].func_78793_a(-2.0F, -2.6F, -0.5F);
    (this.gunModel[6]).field_78808_h = 0.6632251F;
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(1.0F, -3.5F, -0.5F);
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[8].func_78793_a(0.0F, -5.9F, -0.5F);
    (this.gunModel[8]).field_78808_h = 0.6981317F;
    this.gunModel[9].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[9].func_78793_a(18.0F, -6.9F, -0.5F);
    (this.gunModel[9]).field_78808_h = 0.06981317F;
    this.ammoModel = new ModelRendererTurbo[5];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 260, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 220, this.textureX, this.textureY);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 215, this.textureX, this.textureY);
    this.ammoModel[3] = new ModelRendererTurbo((ModelBase)this, 10, 215, this.textureX, this.textureY);
    this.ammoModel[4] = new ModelRendererTurbo((ModelBase)this, 10, 220, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(8.0F, -4.0F, -2.0F, 1, 4, 4, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[0]).field_78808_h = 0.05235988F;
    this.ammoModel[1].func_78790_a(8.0F, -4.5F, -1.0F, 1, 1, 2, 0.0F);
    this.ammoModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[1]).field_78808_h = 0.05235988F;
    this.ammoModel[2].func_78790_a(8.0F, -0.5F, -1.0F, 1, 1, 2, 0.0F);
    this.ammoModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[2]).field_78808_h = 0.05235988F;
    this.ammoModel[3].func_78790_a(8.0F, -3.0F, 1.5F, 1, 2, 1, 0.0F);
    this.ammoModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[3]).field_78808_h = 0.05235988F;
    this.ammoModel[4].func_78790_a(8.0F, -3.0F, -2.5F, 1, 2, 1, 0.0F);
    this.ammoModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[4]).field_78808_h = 0.05235988F;
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
    flipAll();
    translateAll(0.0F, -0.8F, 0.0F);
  }
}
