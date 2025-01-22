package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelW1200 extends ModelGun {
  public ModelW1200() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[5];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-1.0F, 3.0F, -1.0F, 7, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[1].addBox(6.0F, 3.0F, -0.5F, 12, 2, 1);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 16, 0, textureX, textureY);
    this.gunModel[2].addBox(15.0F, 5.0F, -0.5F, 1, 1, 1);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 7, textureX, textureY);
    this.gunModel[3].addBox(-1.0F, 0.0F, -1.0F, 2, 3, 2);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 18, 0, textureX, textureY);
    this.gunModel[4].addBox(1.0F, 2.0F, -1.0F, 1, 1, 2);
    this.pumpModel = new ModelRendererTurbo[1];
    this.pumpModel[0] = new ModelRendererTurbo((ModelBase)this, 8, 7, textureX, textureY);
    this.pumpModel[0].addBox(10.0F, 2.8F, -1.0F, 4, 1, 2);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[3];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 8, 10, textureX, textureY);
    this.defaultStockModel[0].addBox(-8.0F, 0.0F, -1.0F, 3, 3, 2);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 12, textureX, textureY);
    this.defaultStockModel[1].addBox(-5.0F, 1.0F, -1.0F, 2, 2, 2);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 18, 12, textureX, textureY);
    this.defaultStockModel[2].addBox(-3.0F, 2.0F, -1.0F, 2, 2, 2);
    this.stockAttachPoint = new Vector3f(0.0625F, 0.25F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.25F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.75F, 0.1875F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 22, 0, textureX, textureY);
    this.ammoModel[0].addBox(4.0F, 3.5F, -0.5F, 2, 1, 1);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.SHOTGUN;
    this.pumpDelayAfterReload = 115;
    this.pumpDelay = 6;
    this.pumpTime = 9;
    this.gripIsOnPump = true;
    this.numBulletsInReloadAnimation = 7.0F;
    this.tiltGunTime = 0.159F;
    this.unloadClipTime = 0.0F;
    this.loadClipTime = 0.708F;
    this.untiltGunTime = 0.133F;
  }
}
