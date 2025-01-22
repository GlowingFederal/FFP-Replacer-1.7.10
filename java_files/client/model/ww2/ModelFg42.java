package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelFg42 extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelFg42() {
    this.gunModel = new ModelRendererTurbo[11];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 169, 1, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 145, 1, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 185, 1, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 193, 1, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
    this.gunModel[0].func_78793_a(1.0F, -3.0F, -0.5F);
    (this.gunModel[0]).field_78808_h = -0.1919862F;
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 15, 2, 2, 0.0F);
    this.gunModel[1].func_78793_a(-3.0F, -4.3F, -1.0F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
    this.gunModel[2].func_78793_a(-8.0F, -3.7F, -1.0F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
    this.gunModel[3].func_78793_a(-4.0F, -4.0F, -1.0F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F);
    this.gunModel[4].func_78793_a(-9.0F, -4.0F, -1.0F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 11, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(12.0F, -4.0F, -0.5F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[6].func_78793_a(12.0F, -3.5F, -0.5F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(12.0F, -2.8F, 0.0F);
    (this.gunModel[7]).field_78796_g = 0.03490658F;
    (this.gunModel[7]).field_78808_h = -0.03490658F;
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
    this.gunModel[8].func_78793_a(12.0F, -2.8F, -1.2F);
    (this.gunModel[8]).field_78796_g = -0.03490658F;
    (this.gunModel[8]).field_78808_h = -0.03490658F;
    this.gunModel[9].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[9].func_78793_a(2.0F, -5.0F, -0.5F);
    (this.gunModel[9]).field_78808_h = -0.1745329F;
    this.gunModel[10].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.gunModel[10].func_78793_a(18.0F, -5.3F, -0.5F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 201, 1, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(2.0F, -4.0F, 1.0F, 3, 1, 4, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[0]).field_78796_g = -0.05235988F;
    this.barrelAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.stockAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.125F, 0.28125F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.SIDE_CLIP;
    flipAll();
    translateAll(0.0F, 1.0F, 0.0F);
  }
}
