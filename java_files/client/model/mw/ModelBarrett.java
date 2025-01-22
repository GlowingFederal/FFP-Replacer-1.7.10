package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelBarrett extends ModelGun {
  public ModelBarrett() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[3];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-4.0F, 2.0F, -1.0F, 16, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 26, 4, textureX, textureY);
    this.gunModel[1].addBox(12.0F, 2.5F, -0.5F, 8, 1, 1);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[2].addBox(-1.0F, -2.0F, -1.0F, 3, 4, 2);
    this.slideModel = new ModelRendererTurbo[2];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 34, 6, textureX, textureY);
    this.slideModel[0].addTrapezoid(3.0F, 2.5F, 0.5F, 1, 1, 2, 0.0F, -0.5F, 0);
    this.slideModel[0].doMirror(false, false, true);
    this.slideModel[1] = new ModelRendererTurbo((ModelBase)this, 34, 6, textureX, textureY);
    this.slideModel[1].addTrapezoid(3.0F, 2.5F, 0.5F, 1, 1, 2, 0.0F, -0.5F, 0);
    this.defaultScopeModel = new ModelRendererTurbo[3];
    this.defaultScopeModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 10, textureX, textureY);
    this.defaultScopeModel[0].addTrapezoid(-1.0F, 4.25F, -1.0F, 4, 2, 2, 0.0F, -0.5F, 2);
    this.defaultScopeModel[1] = new ModelRendererTurbo((ModelBase)this, 12, 10, textureX, textureY);
    this.defaultScopeModel[1].addTrapezoid(3.0F, 4.25F, -1.0F, 4, 2, 2, 0.0F, -0.5F, 3);
    this.defaultScopeModel[2] = new ModelRendererTurbo((ModelBase)this, 10, 7, textureX, textureY);
    this.defaultScopeModel[2].addBox(1.5F, 3.5F, -0.5F, 3, 2, 1);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.defaultBarrelModel = new ModelRendererTurbo[1];
    this.defaultBarrelModel[0] = new ModelRendererTurbo((ModelBase)this, 18, 4, textureX, textureY);
    this.defaultBarrelModel[0].addBox(18.5F, 2.0F, -1.0F, 2, 2, 2);
    this.barrelAttachPoint = new Vector3f(1.25F, 0.25F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[1];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 36, 9, textureX, textureY);
    this.defaultStockModel[0].addBox(-8.0F, 0.0F, -1.0F, 4, 3, 2);
    this.stockAttachPoint = new Vector3f(-0.25F, 0.0625F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 24, 8, textureX, textureY);
    this.ammoModel[0].addBox(2.5F, -3.0F, -1.0F, 4, 5, 2);
    translateAll(0.0F, 1.0F, 0.0F);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
