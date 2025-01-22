package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelM249 extends ModelGun {
  public ModelM249() {
    int textureX = 64;
    int textureY = 32;
    this.gunModel = new ModelRendererTurbo[15];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 14, textureX, textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 17, textureX, textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 4, 27, textureX, textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 4, 25, textureX, textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 4, 23, textureX, textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 12, 24, textureX, textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 0, 7, textureX, textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 6, 6, textureX, textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 12, 22, textureX, textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 22, 18, textureX, textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 10, 7, textureX, textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 20, 14, textureX, textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 20, 16, textureX, textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 12, 1, 1, 0.0F);
    this.gunModel[0].func_78793_a(6.0F, 3.8F, -0.5F);
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
    this.gunModel[1].func_78793_a(6.0F, 3.0F, -1.0F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F);
    this.gunModel[2].func_78793_a(6.0F, 2.5F, -0.5F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F);
    this.gunModel[3].func_78793_a(4.9F, 4.2F, -0.5F);
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[8].func_78793_a(9.2F, 4.3F, -0.2F);
    this.gunModel[9].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[9].func_78793_a(9.2F, 4.3F, -0.8F);
    this.gunModel[10].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[10].func_78793_a(9.7F, 4.4F, -0.5F);
    this.gunModel[11].func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 2, 0.0F);
    this.gunModel[11].func_78793_a(3.0F, 2.5F, -1.0F);
    this.gunModel[12].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[12].func_78793_a(3.5F, 2.2F, -0.5F);
    this.gunModel[13].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.gunModel[13].func_78793_a(3.5F, 0.2F, -0.5F);
    this.gunModel[14].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[14].func_78793_a(5.8F, 3.5F, -1.1F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, -1.0F, 2, 2, 1, 0.0F);
    this.gunModel[4].func_78793_a(6.8F, 2.9F, 1.2F);
    this.gunModel[5].func_78790_a(0.0F, -0.6666667F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(5.0F, 5.0F, -0.9F);
    this.gunModel[6].func_78790_a(0.0F, -0.6666667F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[6].func_78793_a(5.0F, 5.0F, -0.1F);
    this.gunModel[7].func_78790_a(0.0F, -0.6666667F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(5.1F, 5.1F, -0.5F);
    this.scopeAttachPoint = new Vector3f(0.125F, 0.2083125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[4];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 20, 11, textureX, textureY);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 24, 11, textureX, textureY);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.defaultStockModel[3] = new ModelRendererTurbo((ModelBase)this, 20, 7, textureX, textureY);
    this.defaultStockModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.defaultStockModel[0].func_78793_a(2.0F, 3.3F, -0.8F);
    this.defaultStockModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.defaultStockModel[1].func_78793_a(2.0F, 3.3F, -0.2F);
    this.defaultStockModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.defaultStockModel[2].func_78793_a(1.0F, 4.4F, -0.5F);
    this.defaultStockModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
    this.defaultStockModel[3].func_78793_a(0.0F, 2.4F, -0.5F);
    this.stockAttachPoint = new Vector3f(0.0625F, 0.25F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.25F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.5F, 0.03125F, 0.0F);
    this.defaultGripModel = new ModelRendererTurbo[4];
    this.defaultGripModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 20, textureX, textureY);
    this.defaultGripModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 24, textureX, textureY);
    this.defaultGripModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 29, textureX, textureY);
    this.defaultGripModel[3] = new ModelRendererTurbo((ModelBase)this, 4, 29, textureX, textureY);
    this.defaultGripModel[0].func_78790_a(0.0F, -1.0F, 0.0F, 4, 1, 2, 0.0F);
    this.defaultGripModel[0].func_78793_a(8.5F, 3.0F, -1.0F);
    this.defaultGripModel[1].func_78790_a(0.0F, -3.0F, 0.0F, 1, 3, 1, 0.0F);
    this.defaultGripModel[1].func_78793_a(10.5F, 2.5F, -0.5F);
    (this.defaultGripModel[1]).field_78808_h = -0.3141593F;
    this.defaultGripModel[2].func_78790_a(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
    this.defaultGripModel[2].func_78793_a(10.4F, 3.4F, 0.1F);
    this.defaultGripModel[3].func_78790_a(0.0F, -1.0F, 0.0F, 1, 1, 1, 0.0F);
    this.defaultGripModel[3].func_78793_a(10.4F, 3.4F, -1.1F);
    this.slideModel = new ModelRendererTurbo[2];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 18, 20, textureX, textureY);
    this.slideModel[1] = new ModelRendererTurbo((ModelBase)this, 22, 21, textureX, textureY);
    this.slideModel[0].func_78790_a(0.0F, 0.0F, -1.0F, 1, 1, 1, 0.0F);
    this.slideModel[0].func_78793_a(10.8F, 3.5F, 1.2F);
    this.slideModel[1].func_78790_a(0.0F, 0.0F, -1.0F, 4, 1, 1, 0.0F);
    this.slideModel[1].func_78793_a(7.8F, 3.5F, 1.1F);
    this.ammoModel = new ModelRendererTurbo[2];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 22, 23, textureX, textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 12, 19, textureX, textureY);
    this.ammoModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
    this.ammoModel[0].func_78793_a(5.8F, 0.0F, -2.4F);
    this.ammoModel[1].func_78790_a(0.0F, 2.5F, -1.5F, 2, 2, 1, 0.0F);
    this.ammoModel[1].func_78793_a(6.266667F, 0.0F, -2.5F);
    (this.ammoModel[1]).field_78795_f = 0.6806784F;
    (this.ammoModel[1]).field_78796_g = 0.01745329F;
    translateAll(-3.0F, -2.2F, 0.0F);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
    this.tiltGunTime = 0.1F;
    this.unloadClipTime = 0.2F;
    this.loadClipTime = 0.2F;
    this.untiltGunTime = 0.5F;
  }
}
