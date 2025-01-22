package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelACR extends ModelGun {
  public ModelACR() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[6];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(0.0F, 3.0F, -1.0F, 8, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 8, 4, textureX, textureY);
    this.gunModel[2].addBox(5.0F, 2.0F, -1.0F, 3, 1, 2);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.gunModel[3].addBox(8.0F, 3.0F, -1.0F, 6, 2, 2);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 13, textureX, textureY);
    this.gunModel[4].addBox(14.0F, 3.1F, -0.4F, 4.0F, 0.8F, 0.8F);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 10, 13, textureX, textureY);
    this.gunModel[5].addBox(14.0F, 4.1F, -0.4F, 1.0F, 0.8F, 0.8F);
    this.scopeAttachPoint = new Vector3f(0.21875F, 0.3125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[3];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 20, 0, textureX, textureY);
    this.defaultStockModel[0].addBox(-8.0F, 1.0F, -1.0F, 1.0F, 3.5F, 2.0F);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 26, 0, textureX, textureY);
    this.defaultStockModel[1].addShapeBox(-7.0F, 1.0F, -1.0F, 2, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 18, 6, textureX, textureY);
    this.defaultStockModel[2].addShapeBox(-7.0F, 3.0F, -1.0F, 7, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.stockAttachPoint = new Vector3f(0.0625F, 0.25F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.21875F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.6875F, 0.1875F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 16, 10, textureX, textureY);
    this.ammoModel[0].addShapeBox(5.5F, -2.0F, -1.0F, 2, 4, 2, 0.0F, -0.25F, 0.25F, -0.25F, 0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.25F, -0.25F, 0.25F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
