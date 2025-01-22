package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelM21 extends ModelGun {
  public ModelM21() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[3];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(2.0F, 3.5F, -0.5F, 16, 1, 1);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 2, textureX, textureY);
    this.gunModel[1].addBox(-1.0F, 2.0F, -1.0F, 8, 3, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 7, textureX, textureY);
    this.gunModel[2].addBox(7.0F, 3.0F, -1.0F, 6, 2, 2);
    this.defaultScopeModel = new ModelRendererTurbo[6];
    this.defaultScopeModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 11, textureX, textureY);
    this.defaultScopeModel[0].addBox(-1.0F, 6.0F, -1.0F, 2, 2, 2);
    this.defaultScopeModel[1] = new ModelRendererTurbo((ModelBase)this, 34, 0, textureX, textureY);
    this.defaultScopeModel[1].addBox(1.0F, 6.5F, -0.5F, 4, 1, 1);
    this.defaultScopeModel[2] = new ModelRendererTurbo((ModelBase)this, 8, 11, textureX, textureY);
    this.defaultScopeModel[2].addBox(5.0F, 6.0F, -1.0F, 2, 2, 2);
    this.defaultScopeModel[3] = new ModelRendererTurbo((ModelBase)this, 6, 11, textureX, textureY);
    this.defaultScopeModel[3].addBox(1.5F, 5.5F, -0.5F, 1, 1, 1);
    this.defaultScopeModel[4] = new ModelRendererTurbo((ModelBase)this, 6, 11, textureX, textureY);
    this.defaultScopeModel[4].addBox(3.5F, 5.5F, -0.5F, 1, 1, 1);
    this.defaultScopeModel[5] = new ModelRendererTurbo((ModelBase)this, 14, 11, textureX, textureY);
    this.defaultScopeModel[5].addBox(0.0F, 4.5F, -0.5F, 6, 1, 1);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.25F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[2];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 20, 2, textureX, textureY);
    this.defaultStockModel[0].addBox(-2.0F, 2.0F, -1.0F, 1, 2, 2);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 19, 6, textureX, textureY);
    this.defaultStockModel[1].addBox(-8.0F, 1.0F, -1.0F, 6, 3, 2);
    this.stockAttachPoint = new Vector3f(-0.0625F, 0.1875F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 35, 8, textureX, textureY);
    this.ammoModel[0].addBox(3.0F, -4.0F, -1.0F, 3, 6, 2);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
