package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelPanzerschreck extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelPanzerschreck() {
    this.gunModel = new ModelRendererTurbo[8];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 76, 0, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 86, 17, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 51, 34, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 35, 35, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 35, 35, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 35, 35, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 35, 35, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 35, 35, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 26, 3, 3, 0.0F);
    this.gunModel[0].func_78793_a(-18.0F, -4.5F, -1.5F);
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 0, 9, 11, 0.0F);
    this.gunModel[1].func_78793_a(3.0F, -7.0F, -3.0F);
    (this.gunModel[1]).field_78796_g = 0.01745329F;
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
    this.gunModel[2].func_78793_a(0.8F, -2.2F, -0.5F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
    this.gunModel[3].func_78793_a(-18.5F, -4.0F, -1.0F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 1, 4, 1, 0.0F);
    this.gunModel[4].func_78793_a(-19.0F, -5.0F, 1.0F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
    this.gunModel[5].func_78793_a(-19.0F, -5.0F, -2.0F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
    this.gunModel[6].func_78793_a(-19.0F, -2.0F, -2.0F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.gunModel[7].func_78793_a(-19.0F, -4.0F, -2.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(-18.0F, -4.0F, -1.0F, 7, 2, 2, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.RIFLE;
    flipAll();
    translateAll(0.0F, 2.0F, 4.0F);
    this.thirdPersonOffset = new Vector3f(0.0F, -0.05F, -0.2F);
  }
}
