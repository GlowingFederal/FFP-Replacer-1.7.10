package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelType14 extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelType14() {
    this.gunModel = new ModelRendererTurbo[12];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 58, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 58, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 58, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 58, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 73, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 83, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 285, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 73, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 285, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 0, 305, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 0, 73, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 0, 73, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, -0.3F, 1, 5, 1, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -3.0F, 0.0F);
    (this.gunModel[0]).field_78808_h = -0.2617994F;
    this.gunModel[1].func_78790_a(0.0F, 0.0F, -0.7F, 1, 5, 1, 0.0F);
    this.gunModel[1].func_78793_a(0.0F, -3.0F, 0.0F);
    (this.gunModel[1]).field_78808_h = -0.2617994F;
    this.gunModel[2].func_78790_a(0.3F, 0.0F, -0.3F, 1, 5, 1, 0.0F);
    this.gunModel[2].func_78793_a(0.0F, -3.0F, 0.0F);
    (this.gunModel[2]).field_78808_h = -0.2617994F;
    this.gunModel[3].func_78790_a(0.3F, 0.0F, -0.7F, 1, 5, 1, 0.0F);
    this.gunModel[3].func_78793_a(0.0F, -3.0F, 0.0F);
    (this.gunModel[3]).field_78808_h = -0.2617994F;
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[4].func_78793_a(-1.2F, -3.0F, -0.6F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(0.3F, -2.0F, -0.5F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
    this.gunModel[6].func_78793_a(0.5F, -3.3F, -0.5F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(-1.2F, -3.5F, -0.4F);
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[8].func_78793_a(-1.0F, -2.5F, -0.5F);
    this.gunModel[9].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 0, 0.0F);
    this.gunModel[9].func_78793_a(4.2F, -3.6F, 0.0F);
    this.gunModel[10].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[10].func_78793_a(-1.2F, -3.5F, -0.6F);
    this.gunModel[11].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[11].func_78793_a(-1.2F, -3.0F, -0.4F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 306, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(0.2F, 0.5F, -0.5F, 1, 4, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, -3.0F, 0.0F);
    (this.ammoModel[0]).field_78808_h = -0.2617994F;
    this.slideModel = new ModelRendererTurbo[1];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 295, this.textureX, this.textureY);
    this.slideModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.slideModel[0].func_78793_a(-1.5F, -3.3F, -0.5F);
    this.gunSlideDistance = 0.1F;
    this.animationType = EnumAnimationType.PISTOL_CLIP;
    flipAll();
  }
}
