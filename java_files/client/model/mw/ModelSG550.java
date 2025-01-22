package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelSG550 extends ModelGun {
  int textureX = 512;
  
  int textureY = 16;
  
  public ModelSG550() {
    this.gunModel = new ModelRendererTurbo[13];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 209, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 161, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 297, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 265, 1, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 193, 1, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 321, 1, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 353, 1, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 369, 1, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 2, 5, 1, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -4.0F, -0.5F);
    (this.gunModel[0]).field_78808_h = -0.2094395F;
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[1].func_78793_a(1.0F, -2.0F, -0.5F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 11, 1, 1, 0.0F);
    this.gunModel[2].func_78793_a(14.0F, -3.8F, -0.5F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 13, 1, 2, 0.0F);
    this.gunModel[3].func_78793_a(-0.23F, -4.0F, -1.0F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
    this.gunModel[4].func_78793_a(11.0F, -4.5F, -1.0F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 10, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(1.0F, -4.5F, -0.5F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 11, 1, 1, 0.0F);
    this.gunModel[6].func_78793_a(1.0F, -3.0F, -0.5F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.gunModel[7].func_78793_a(23.0F, -5.5F, -0.5F);
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
    this.gunModel[8].func_78793_a(1.0F, -5.0F, -0.5F);
    this.gunModel[9].func_78790_a(0.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
    this.gunModel[9].func_78793_a(-3.8F, -2.9F, -1.0F);
    (this.gunModel[9]).field_78808_h = 0.2792527F;
    this.gunModel[10].func_78790_a(0.0F, 0.0F, 0.0F, 11, 2, 1, 0.0F);
    this.gunModel[10].func_78793_a(-9.5F, -2.0F, -0.5F);
    (this.gunModel[10]).field_78808_h = 0.2443461F;
    this.gunModel[11].func_78790_a(0.0F, 0.0F, 0.0F, 4, 3, 1, 0.0F);
    this.gunModel[11].func_78793_a(-10.0F, -3.0F, -0.5F);
    this.gunModel[12].func_78790_a(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
    this.gunModel[12].func_78793_a(-7.0F, -2.0F, -1.0F);
    (this.gunModel[12]).field_78808_h = 0.2792527F;
    this.scopeAttachPoint = new Vector3f(0.25F, 0.375F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.9375F, 0.21875F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.5208334F, 0.28125F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[2];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(6.0F, -2.0F, -0.5F, 2, 2, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.ammoModel[1].func_78790_a(6.2F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
    this.ammoModel[1].func_78793_a(0.0F, 0.0F, -0.5F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
    flipAll();
    translateAll(0.0F, 1.0F, 0.0F);
  }
}
