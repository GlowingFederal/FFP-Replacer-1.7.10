package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelM3A1GreaseGun extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelM3A1GreaseGun() {
    this.gunModel = new ModelRendererTurbo[9];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 300, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 290, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 280, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 270, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 260, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 250, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 15, 250, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 240, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 230, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -4.0F, -1.0F);
    (this.gunModel[0]).field_78808_h = -0.1919862F;
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F);
    this.gunModel[1].func_78793_a(-1.0F, -5.0F, -1.0F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
    this.gunModel[2].func_78793_a(12.0F, -4.5F, -0.5F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
    this.gunModel[3].func_78793_a(1.0F, -3.0F, -0.5F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[4].func_78793_a(4.0F, -2.5F, -0.5F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 5, 0, 1, 0.0F);
    this.gunModel[5].func_78793_a(-6.0F, -3.5F, -0.5F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 0, 3, 1, 0.0F);
    this.gunModel[6].func_78793_a(-5.9F, -4.0F, -0.5F);
    (this.gunModel[6]).field_78808_h = -0.1047198F;
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(10.5F, -5.7F, -0.5F);
    (this.gunModel[7]).field_78808_h = 0.122173F;
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[8].func_78793_a(0.0F, -5.5F, -0.5F);
    this.ammoModel = new ModelRendererTurbo[2];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 10, 230, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 15, 230, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(8.0F, -3.0F, -0.5F, 1, 6, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.ammoModel[1].func_78790_a(8.5F, -3.0F, -0.5F, 1, 6, 1, 0.0F);
    this.ammoModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
    flipAll();
    translateAll(0.0F, 1.0F, 0.0F);
  }
}
