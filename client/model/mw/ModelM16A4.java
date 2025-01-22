package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelM16A4 extends ModelGun {
  public ModelM16A4() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[6];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(1.0F, 2.0F, -1.0F, 5, 3, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 14, 0, textureX, textureY);
    this.gunModel[1].addBox(0.0F, -1.0F, -1.0F, 1, 3, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 20, 0, textureX, textureY);
    this.gunModel[2].addBox(1.0F, 1.0F, -1.0F, 1, 1, 2);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.gunModel[3].addBox(6.5F, 3.0F, -1.0F, 7, 2, 2);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 12, 0, textureX, textureY);
    this.gunModel[4].addBox(14.0F, 4.5F, -0.5F, 1, 1, 1);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.gunModel[5].addBox(6.0F, 3.5F, -0.5F, 12, 1, 1);
    this.scopeAttachPoint = new Vector3f(0.21875F, 0.3125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[3];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 20, 3, textureX, textureY);
    this.defaultStockModel[0].addBox(-8.0F, 1.0F, -1.0F, 3, 4, 2);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 11, textureX, textureY);
    this.defaultStockModel[1].addBox(-5.0F, 2.0F, -1.0F, 3, 3, 2);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 10, 11, textureX, textureY);
    this.defaultStockModel[2].addBox(-2.0F, 3.0F, -1.0F, 3, 2, 2);
    this.stockAttachPoint = new Vector3f(0.0625F, 0.25F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.25F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.625F, 0.1875F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[2];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 20, 11, textureX, textureY);
    this.ammoModel[0].addBox(3.0F, 0.0F, -1.0F, 3, 2, 2);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 30, 11, textureX, textureY);
    this.ammoModel[1].addBox(4.0F, -2.0F, -1.0F, 3, 2, 2);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
