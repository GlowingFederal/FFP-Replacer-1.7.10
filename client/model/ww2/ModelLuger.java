package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelLuger extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelLuger() {
    this.gunModel = new ModelRendererTurbo[5];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 100, 145, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 100, 155, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 100, 175, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 116, 150, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 115, 140, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -3.0F, -1.0F);
    (this.gunModel[0]).field_78808_h = -0.1919862F;
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
    this.gunModel[1].func_78793_a(-0.4F, -4.0F, -1.0F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
    this.gunModel[2].func_78793_a(3.0F, -3.8F, -0.5F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[3].func_78793_a(6.8F, -4.2F, -0.5F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 0, 2, 1, 0.0F);
    this.gunModel[4].func_78793_a(3.0F, -2.4F, -0.5F);
    (this.gunModel[4]).field_78808_h = -0.8552113F;
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 126, 150, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(0.0F, -3.0F, -0.5F, 1, 4, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[0]).field_78808_h = -0.1919862F;
    this.slideModel = new ModelRendererTurbo[1];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 100, 165, this.textureX, this.textureY);
    this.slideModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
    this.slideModel[0].func_78793_a(1.0F, -3.8F, -1.5F);
    this.gunSlideDistance = 0.1F;
    this.animationType = EnumAnimationType.PISTOL_CLIP;
    flipAll();
    translateAll(0.0F, 2.0F, 0.0F);
    this.thirdPersonOffset = new Vector3f(0.0F, -0.1F, 0.0F);
  }
}
