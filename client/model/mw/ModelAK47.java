package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelAK47 extends ModelGun {
  public ModelAK47() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[4];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-4.0F, 2.0F, -1.0F, 12, 3, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.gunModel[1].addBox(-0.0F, -2.0F, -1.0F, 2, 4, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 8, 5, textureX, textureY);
    this.gunModel[2].addBox(6.9F, 4.2F, -0.5F, 1, 1, 1);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 12, textureX, textureY);
    this.gunModel[3].addBox(8.0F, 2.25F, -1.0F, 6, 2, 2);
    this.scopeAttachPoint = new Vector3f(0.25F, 0.3125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[2];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 8, 7, textureX, textureY);
    this.defaultStockModel[0].addBox(-7.0F, 1.0F, -1.0F, 3, 3, 2);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 18, 7, textureX, textureY);
    this.defaultStockModel[1].addBox(-10.0F, 0.0F, -1.0F, 3, 3, 2);
    this.stockAttachPoint = new Vector3f(-0.25F, 0.21875F, 0.0F);
    this.defaultBarrelModel = new ModelRendererTurbo[2];
    this.defaultBarrelModel[0] = new ModelRendererTurbo((ModelBase)this, 30, 14, textureX, textureY);
    this.defaultBarrelModel[0].addBox(14.0F, 2.5F, -0.5F, 3, 1, 1);
    this.defaultBarrelModel[1] = new ModelRendererTurbo((ModelBase)this, 16, 12, textureX, textureY);
    this.defaultBarrelModel[1].addBox(17.0F, 2.5F, -0.5F, 1, 2, 1);
    this.barrelAttachPoint = new Vector3f(0.875F, 0.203125F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[3];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 28, 0, textureX, textureY);
    this.ammoModel[0].addBox(4.0F, -2.0F, -1.0F, 3, 4, 2);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 20, 12, textureX, textureY);
    this.ammoModel[1].addBox(5.0F, -4.0F, -1.0F, 3, 2, 2);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 28, 7, textureX, textureY);
    this.ammoModel[2].addBox(6.0F, -5.0F, -1.0F, 2, 1, 2);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
