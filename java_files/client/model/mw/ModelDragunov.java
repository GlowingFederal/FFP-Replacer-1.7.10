package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelDragunov extends ModelGun {
  public ModelDragunov() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[5];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(13.0F, 3.5F, -0.5F, 5, 1, 1);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 2, textureX, textureY);
    this.gunModel[1].addBox(-1.0F, 3.0F, -1.0F, 13, 2, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 6, textureX, textureY);
    this.gunModel[2].addBox(12.0F, 3.0F, -0.5F, 1, 2, 1);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 4, 6, textureX, textureY);
    this.gunModel[3].addBox(16.0F, 4.5F, -0.5F, 1, 1, 1);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 6, 6, textureX, textureY);
    this.gunModel[4].addBox(-1.0F, 0.0F, -1.0F, 1, 3, 2);
    this.defaultScopeModel = new ModelRendererTurbo[4];
    this.defaultScopeModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 12, textureX, textureY);
    this.defaultScopeModel[0].addBox(-2.0F, 5.5F, -1.0F, 3, 2, 2);
    this.defaultScopeModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 10, textureX, textureY);
    this.defaultScopeModel[1].addBox(1.0F, 6.0F, -0.5F, 1, 1, 1);
    this.defaultScopeModel[2] = new ModelRendererTurbo((ModelBase)this, 10, 12, textureX, textureY);
    this.defaultScopeModel[2].addBox(2.0F, 5.5F, -1.0F, 4, 2, 2);
    this.defaultScopeModel[3] = new ModelRendererTurbo((ModelBase)this, 11, 10, textureX, textureY);
    this.defaultScopeModel[3].addBox(1.0F, 4.5F, -0.5F, 5, 1, 1);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.25F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[3];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 12, 6, textureX, textureY);
    this.defaultStockModel[0].addBox(-5.0F, 3.0F, -1.0F, 4, 1, 2);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 24, 6, textureX, textureY);
    this.defaultStockModel[1].addBox(-5.0F, 0.0F, -1.0F, 4, 1, 2);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 23, 9, textureX, textureY);
    this.defaultStockModel[2].addBox(-8.0F, 0.0F, -1.0F, 3, 4, 2);
    this.stockAttachPoint = new Vector3f(-0.0625F, 0.0625F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 9, textureX, textureY);
    this.ammoModel[0].addBox(2.0F, -1.0F, -1.0F, 3, 4, 2);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
