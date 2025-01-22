package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelAT4 extends ModelGun {
  int textureX = 256;
  
  int textureY = 32;
  
  public ModelAT4() {
    this.gunModel = new ModelRendererTurbo[8];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
    this.gunModel[0].func_78793_a(-1.0F, -3.0F, -0.5F);
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 18, 3, 3, 0.0F);
    this.gunModel[1].func_78793_a(-15.0F, -6.0F, -1.5F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 1, 4, 4, 0.0F);
    this.gunModel[2].func_78793_a(2.5F, -6.5F, -2.0F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F);
    this.gunModel[3].func_78793_a(1.0F, -5.0F, 1.0F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 0, 0.0F);
    this.gunModel[4].func_78793_a(1.0F, -6.0F, 4.0F);
    (this.gunModel[4]).field_78796_g = -0.1745329F;
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
    this.gunModel[5].func_78793_a(-16.1F, -6.0F, -1.5F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 1, 4, 4, 0.0F);
    this.gunModel[6].func_78793_a(-17.2F, -6.5F, -2.0F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
    this.gunModel[7].func_78793_a(-18.0F, -5.5F, -1.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 5, 2, 2, 0.0F);
    this.ammoModel[0].func_78793_a(-3.0F, -5.5F, -1.0F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.NONE;
    flipAll();
    translateAll(0.0F, 0.0F, 3.0F);
    this.thirdPersonOffset = new Vector3f(0.0F, 0.0F, -0.2F);
    this.itemFrameOffset = new Vector3f(0.6875F, 0.0F, 0.0F);
  }
}
