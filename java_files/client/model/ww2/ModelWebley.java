package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelWebley extends ModelGun {
  int textureX = 256;
  
  int textureY = 128;
  
  public ModelWebley() {
    this.gunModel = new ModelRendererTurbo[9];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 11, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 26, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 37, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 83, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 91, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 97, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 102, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 20, 19, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 20, 27, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 5, 9, 4, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, 2.0F, -2.0F);
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 5, 4, 4, 0.0F);
    this.gunModel[1].func_78793_a(2.0F, -2.0F, -2.0F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 4, 4, 3, 0.0F);
    this.gunModel[2].func_78793_a(4.0F, -3.0F, -1.5F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 12, 3, 3, 0.0F);
    this.gunModel[3].func_78793_a(4.0F, -6.0F, -1.5F);
    this.gunModel[4].func_78790_a(-3.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[4].func_78793_a(7.0F, -6.0F, -0.5F);
    (this.gunModel[4]).field_78808_h = -0.1745329F;
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
    this.gunModel[5].func_78793_a(7.0F, 1.0F, -1.0F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 2, 5, 3, 0.0F);
    this.gunModel[6].func_78793_a(14.0F, -3.0F, -1.5F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 12, 3, 3, 0.0F);
    this.gunModel[7].func_78793_a(16.0F, -6.0F, -1.5F);
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[8].func_78793_a(25.0F, -7.0F, -0.5F);
    this.revolverBarrelModel = new ModelRendererTurbo[3];
    this.revolverBarrelModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 47, this.textureX, this.textureY);
    this.revolverBarrelModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 59, this.textureX, this.textureY);
    this.revolverBarrelModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 72, this.textureX, this.textureY);
    this.revolverBarrelModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 6, 6, 2, 0.0F);
    this.revolverBarrelModel[0].func_78793_a(8.0F, -5.0F, -1.0F);
    this.revolverBarrelModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 6, 6, 2, 0.0F);
    this.revolverBarrelModel[1].func_78793_a(8.0F, -5.0F, 1.0F);
    this.revolverBarrelModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 6, 6, 2, 0.0F);
    this.revolverBarrelModel[2].func_78793_a(8.0F, -5.0F, -3.0F);
    this.ammoModel = new ModelRendererTurbo[8];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 19, 32, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 19, 32, this.textureX, this.textureY);
    this.ammoModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.ammoModel[4] = new ModelRendererTurbo((ModelBase)this, 19, 32, this.textureX, this.textureY);
    this.ammoModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.ammoModel[6] = new ModelRendererTurbo((ModelBase)this, 19, 32, this.textureX, this.textureY);
    this.ammoModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(0.0F, 0.0F, 0.1F, 4, 2, 2, 0.0F);
    this.ammoModel[0].func_78793_a(8.1F, -4.0F, -3.0F);
    this.ammoModel[1].func_78790_a(0.0F, 0.0F, 0.1F, 2, 2, 2, 0.0F);
    this.ammoModel[1].func_78793_a(11.9F, -4.0F, -3.0F);
    this.ammoModel[2].func_78790_a(0.0F, 0.0F, 0.1F, 4, 2, 2, 0.0F);
    this.ammoModel[2].func_78793_a(8.1F, -1.5F, -3.0F);
    this.ammoModel[3].func_78790_a(0.0F, 0.0F, 0.1F, 2, 2, 2, 0.0F);
    this.ammoModel[3].func_78793_a(11.9F, -1.5F, -3.0F);
    this.ammoModel[4].func_78790_a(0.0F, 0.0F, 0.1F, 4, 2, 2, 0.0F);
    this.ammoModel[4].func_78793_a(8.1F, -4.0F, 0.5F);
    this.ammoModel[5].func_78790_a(0.0F, 0.0F, 0.1F, 2, 2, 2, 0.0F);
    this.ammoModel[5].func_78793_a(11.9F, -4.0F, 0.5F);
    this.ammoModel[6].func_78790_a(0.0F, 0.0F, 0.1F, 4, 2, 2, 0.0F);
    this.ammoModel[6].func_78793_a(8.1F, -1.5F, 0.5F);
    this.ammoModel[7].func_78790_a(0.0F, 0.0F, 0.1F, 2, 2, 2, 0.0F);
    this.ammoModel[7].func_78793_a(11.9F, -1.5F, 0.5F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.REVOLVER;
    flipAll();
    translateAll(0.0F, 13.0F, 0.0F);
    this.thirdPersonOffset = new Vector3f(-0.05F, -0.05F, 0.0F);
  }
}
