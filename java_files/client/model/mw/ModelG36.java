package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelG36 extends ModelGun {
  public ModelG36() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[7];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-1.0F, 2.0F, -1.0F, 15, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[1].addBox(1.0F, 4.0F, -1.0F, 5.0F, 0.5F, 2.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 7, textureX, textureY);
    this.gunModel[2].addBox(2.0F, 4.5F, -1.0F, 9.0F, 0.5F, 2.0F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 14, 4, textureX, textureY);
    this.gunModel[3].addBox(10.0F, 4.0F, -1.0F, 2.0F, 0.5F, 2.0F);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 32, 0, textureX, textureY);
    this.gunModel[4].addBox(14.0F, 2.5F, -0.5F, 1, 1, 1);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 22, 4, textureX, textureY);
    this.gunModel[5].addBox(1.0F, 1.0F, -1.0F, 6, 1, 2);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 10, textureX, textureY);
    this.gunModel[6].addBox(-0.5F, -2.0F, -0.5F, 1, 3, 1);
    this.gunModel[6].func_78793_a(2.0F, 1.0F, 0.0F);
    (this.gunModel[6]).field_78808_h = -0.5F;
    this.scopeAttachPoint = new Vector3f(0.25F, 0.3125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[5];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 4, 10, textureX, textureY);
    this.defaultStockModel[0].addBox(-7.0F, 1.0F, -0.5F, 1, 3, 1);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 14, textureX, textureY);
    this.defaultStockModel[1].addBox(-6.0F, 1.5F, -0.5F, 2.0F, 0.5F, 1.0F);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 6, 14, textureX, textureY);
    this.defaultStockModel[2].addBox(-4.0F, 2.0F, -0.5F, 3.0F, 0.5F, 1.0F);
    this.defaultStockModel[3] = new ModelRendererTurbo((ModelBase)this, 14, 14, textureX, textureY);
    this.defaultStockModel[3].addBox(-6.0F, 3.5F, -0.5F, 5.0F, 0.5F, 1.0F);
    this.defaultStockModel[4] = new ModelRendererTurbo((ModelBase)this, 26, 14, textureX, textureY);
    this.defaultStockModel[4].addBox(-3.0F, 2.5F, -0.5F, 1, 1, 1);
    this.stockAttachPoint = new Vector3f(-0.25F, 0.21875F, 0.0F);
    this.barrelAttachPoint = new Vector3f(0.9375F, 0.1875F, 0.0F);
    this.defaultGripModel = new ModelRendererTurbo[2];
    this.defaultGripModel[0] = new ModelRendererTurbo((ModelBase)this, 8, 10, textureX, textureY);
    this.defaultGripModel[0].addBox(11.0F, 1.0F, -1.0F, 2, 1, 2);
    this.defaultGripModel[1] = new ModelRendererTurbo((ModelBase)this, 16, 10, textureX, textureY);
    this.defaultGripModel[1].addBox(11.5F, -1.0F, -0.5F, 1, 2, 1);
    this.gripAttachPoint = new Vector3f(0.625F, 0.1875F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 22, 7, textureX, textureY);
    this.ammoModel[0].addBox(-1.0F, -4.0F, -0.5F, 2, 5, 1);
    this.ammoModel[0].func_78793_a(6.0F, 1.0F, 0.0F);
    (this.ammoModel[0]).field_78808_h = 0.25F;
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
