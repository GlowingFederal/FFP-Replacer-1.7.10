package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelMTAR extends ModelGun {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelMTAR() {
    this.gunModel = new ModelRendererTurbo[8];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 6, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 10, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 7, 7, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 14, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 7, 4, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 3, 3, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 8, 1, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 19, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(-0.25F, -1.8F, -0.5F, 2, 3, 1, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, -0.25F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.gunModel[0]).field_78808_h = -0.13962634F;
    this.gunModel[1].func_78790_a(-1.5F, -4.5F, -1.0F, 6, 2, 2, 0.0F);
    this.gunModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[2].addShapeBox(4.5F, -3.25F, -1.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F);
    this.gunModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[3].addShapeBox(-5.5F, -4.5F, -1.0F, 4, 3, 2, 0.0F, 0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[4].addShapeBox(4.5F, -4.25F, -1.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[5].func_78790_a(6.0F, -3.75F, -0.5F, 2, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[6].func_78790_a(0.2F, -2.5F, -1.0F, 3, 1, 2, 0.0F);
    this.gunModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[7].func_78790_a(0.0F, -5.0F, -0.5F, 6, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 21, this.textureX, this.textureY);
    this.ammoModel[0].addShapeBox(-3.8F, -3.0F, -0.5F, 2, 5, 1, 0.0F, 0.25F, 0.0F, 0.2F, -0.25F, 0.0F, 0.2F, -0.25F, 0.0F, 0.2F, 0.25F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.0F, 0.2F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.slideModel = new ModelRendererTurbo[1];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 6, 21, this.textureX, this.textureY);
    this.slideModel[0].addShapeBox(2.5F, -4.0F, -1.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F);
    this.slideModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.barrelAttachPoint = new Vector3f(0.5625F, 0.203125F, 0.0F);
    this.stockAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.25F, 0.3125F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.PISTOL_CLIP;
    translateAll(1.0F, 0.0F, 0.0F);
    flipAll();
  }
}
