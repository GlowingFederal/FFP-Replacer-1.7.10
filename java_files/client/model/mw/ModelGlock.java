package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelGlock extends ModelGun {
  int textureX = 256;
  
  int textureY = 16;
  
  public ModelGlock() {
    this.gunModel = new ModelRendererTurbo[6];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 129, 1, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 2, 5, 2, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -2.5F, -1.0F);
    (this.gunModel[0]).field_78808_h = -0.1396263F;
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 9, 1, 2, 0.0F);
    this.gunModel[1].func_78793_a(-1.0F, -3.0F, -1.0F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
    this.gunModel[2].func_78793_a(1.0F, -2.5F, -0.5F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[3].func_78793_a(7.5F, -3.5F, -0.5F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[4].func_78793_a(1.5F, -1.5F, -0.5F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 8, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(0.0F, -3.5F, -0.5F);
    this.ammoModel = new ModelRendererTurbo[3];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 2.0F, -0.5F);
    (this.ammoModel[0]).field_78808_h = -0.1396263F;
    this.ammoModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F);
    this.ammoModel[1].func_78793_a(-0.5F, 1.9F, -0.5F);
    (this.ammoModel[1]).field_78808_h = -0.1396263F;
    this.ammoModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.ammoModel[2].func_78793_a(-0.9F, 6.3F, -0.5F);
    (this.ammoModel[2]).field_78808_h = -0.1396263F;
    this.slideModel = new ModelRendererTurbo[2];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.slideModel[1] = new ModelRendererTurbo((ModelBase)this, 153, 1, this.textureX, this.textureY);
    this.slideModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 9, 1, 2, 0.0F);
    this.slideModel[0].func_78793_a(-1.0F, -4.0F, -1.0F);
    this.slideModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.slideModel[1].func_78793_a(7.0F, -4.5F, -0.5F);
    this.barrelAttachPoint = new Vector3f(0.53125F, 0.25F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.scopeIsOnSlide = true;
    this.gunSlideDistance = 0.2F;
    this.animationType = EnumAnimationType.PISTOL_CLIP;
    flipAll();
    translateAll(0.0F, 1.0F, 0.0F);
  }
}
