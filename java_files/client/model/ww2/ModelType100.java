package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelType100 extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelType100() {
    this.gunModel = new ModelRendererTurbo[13];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 220, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 230, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 230, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 240, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 250, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 260, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 275, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 285, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 300, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 0, 300, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 30, 250, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 80, 250, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 120, 250, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
    this.gunModel[0].func_78793_a(-1.3F, -1.0F, -1.0F);
    (this.gunModel[0]).field_78808_h = 0.6632251F;
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 12, 2, 2, 0.0F);
    this.gunModel[1].func_78793_a(1.0F, -3.0F, -0.5F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 12, 2, 2, 0.0F);
    this.gunModel[2].func_78793_a(1.0F, -3.0F, -1.5F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
    this.gunModel[3].func_78793_a(-3.0F, -2.5F, -1.0F);
    (this.gunModel[3]).field_78808_h = -0.3569146F;
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 6, 2, 2, 0.0F);
    this.gunModel[4].func_78793_a(-9.0F, -2.5F, -1.0F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 7, 2, 2, 0.0F);
    this.gunModel[5].func_78793_a(-9.0F, -0.5F, -1.0F);
    (this.gunModel[5]).field_78808_h = 0.2094395F;
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 22, 2, 2, 0.0F);
    this.gunModel[6].func_78793_a(1.2F, -4.0F, -1.0F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(23.0F, -3.5F, -0.5F);
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
    this.gunModel[8].func_78793_a(15.5F, -2.0F, -0.8F);
    this.gunModel[9].func_78790_a(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
    this.gunModel[9].func_78793_a(15.5F, -2.0F, -1.2F);
    this.gunModel[10].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[10].func_78793_a(11.0F, -4.0F, -2.0F);
    this.gunModel[11].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[11].func_78793_a(2.5F, -1.0F, -0.5F);
    this.gunModel[12].func_78790_a(0.0F, 0.0F, 0.0F, 3, 2, 1, 0.0F);
    this.gunModel[12].func_78793_a(9.0F, -3.7F, 0.3F);
    this.ammoModel = new ModelRendererTurbo[3];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 320, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 330, this.textureX, this.textureY);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 330, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 4, 0.0F);
    this.ammoModel[0].func_78793_a(9.5F, -3.5F, 0.0F);
    this.ammoModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 3, 0.0F);
    this.ammoModel[1].func_78793_a(9.5F, -3.5F, 4.0F);
    (this.ammoModel[1]).field_78796_g = -0.1745329F;
    this.ammoModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 3, 0.0F);
    this.ammoModel[2].func_78793_a(10.0F, -3.5F, 7.0F);
    (this.ammoModel[2]).field_78796_g = -0.5235988F;
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.SIDE_CLIP;
    flipAll();
  }
}
