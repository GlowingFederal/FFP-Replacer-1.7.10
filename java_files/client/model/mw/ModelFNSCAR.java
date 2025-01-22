package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelFNSCAR extends ModelGun {
  public ModelFNSCAR() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[8];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(0.0F, 2.0F, -1.0F, 8, 3, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.gunModel[1].addShapeBox(1.0F, -1.0F, -1.0F, 1, 3, 2, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 6, 5, textureX, textureY);
    this.gunModel[2].addBox(4.0F, 1.0F, -1.0F, 3, 1, 2);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 20, 0, textureX, textureY);
    this.gunModel[3].addBox(8.0F, 3.0F, -1.0F, 5, 2, 2);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 10, textureX, textureY);
    this.gunModel[4].addBox(7.5F, 2.5F, -0.5F, 5, 1, 1);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 6, 8, textureX, textureY);
    this.gunModel[5].addBox(13.0F, 4.5F, -0.5F, 1, 1, 1);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 12, textureX, textureY);
    this.gunModel[6].addBox(13.0F, 3.25F, -0.5F, 4, 1, 1);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 10, 8, textureX, textureY);
    this.gunModel[7].addBox(0.5F, 4.5F, -0.5F, 1, 1, 1);
    this.scopeAttachPoint = new Vector3f(0.21875F, 0.3125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[2];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 16, 5, textureX, textureY);
    this.defaultStockModel[0].addShapeBox(-6.0F, 0.0F, -1.0F, 2, 4, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 24, 5, textureX, textureY);
    this.defaultStockModel[1].addShapeBox(-4.0F, 2.0F, -1.0F, 4, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.stockAttachPoint = new Vector3f(0.0625F, 0.25F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.0625F, 0.234375F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.625F, 0.1875F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 12, 11, textureX, textureY);
    this.ammoModel[0].addShapeBox(4.5F, -2.0F, -0.5F, 2, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
