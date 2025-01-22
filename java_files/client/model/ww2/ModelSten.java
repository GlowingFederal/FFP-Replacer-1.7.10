package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelSten extends ModelGun {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelSten() {
    this.gunModel = new ModelRendererTurbo[7];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 14, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 21, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 8, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 14, 14, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 14, 18, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 27, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 28, 26, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 5, 4, 2, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, 0.0F, -1.0F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 5, 4, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1].func_78793_a(5.0F, 0.0F, -1.0F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 17, 3, 3, 0.0F);
    this.gunModel[2].func_78793_a(0.0F, -3.0F, -1.5F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
    this.gunModel[3].func_78793_a(17.0F, -2.5F, -1.126667F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F);
    this.gunModel[4].func_78793_a(8.0F, -3.1F, -1.4F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 3, 2, 2, 0.0F);
    this.gunModel[5].func_78793_a(8.0F, -2.6F, 1.6F);
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 3, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F);
    this.gunModel[6].func_78793_a(-2.0F, -3.0F, -1.5F);
    this.defaultStockModel = new ModelRendererTurbo[3];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 14, 24, this.textureX, this.textureY);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 20, 24, this.textureX, this.textureY);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 20, 26, this.textureX, this.textureY);
    this.defaultStockModel[0].func_78790_a(0.0F, -1.0F, 0.0F, 1, 6, 2, 0.0F);
    this.defaultStockModel[0].func_78793_a(-9.0F, 1.0F, -1.0F);
    this.defaultStockModel[1].func_78790_a(-1.0F, 0.0F, 0.0F, 10, 1, 1, 0.0F);
    this.defaultStockModel[1].func_78793_a(-8.0F, 2.0F, -0.5F);
    (this.defaultStockModel[1]).field_78808_h = 0.2268928F;
    this.defaultStockModel[2].addShapeBox(6.0F, 1.0F, 0.0F, 3, 1, 1, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.defaultStockModel[2].func_78793_a(-8.0F, 2.0F, -0.5F);
    (this.defaultStockModel[2]).field_78808_h = 0.2268928F;
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 26, 14, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 7, 0.0F);
    this.ammoModel[0].func_78793_a(8.5F, -2.1F, 3.6F);
    this.barrelAttachPoint = new Vector3f(1.3125F, 0.34375F, 0.0F);
    this.stockAttachPoint = new Vector3f(0.0F, 0.25F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.375F, 0.4375F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.75F, 0.25F, 0.0F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.SIDE_CLIP;
    flipAll();
    translateAll(0.0F, 4.0F, 0.0F);
    this.numBulletsInReloadAnimation = 8.0F;
    this.tiltGunTime = 0.25F;
    this.unloadClipTime = 0.25F;
    this.loadClipTime = 0.25F;
    this.untiltGunTime = 0.25F;
  }
}
