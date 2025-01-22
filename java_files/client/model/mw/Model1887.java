package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class Model1887 extends ModelGun {
  public Model1887() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[5];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addShapeBox(0.0F, 3.0F, -1.0F, 3, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 10, 0, textureX, textureY);
    this.gunModel[1].addShapeBox(0.0F, 2.0F, -1.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[2].addBox(3.0F, 3.05F, -0.45F, 7.0F, 0.9F, 0.9F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 6, textureX, textureY);
    this.gunModel[3].addBox(3.0F, 4.05F, -0.45F, 10.0F, 0.9F, 0.9F);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 8, textureX, textureY);
    this.gunModel[4].addBox(3.0F, 3.25F, -0.75F, 5.0F, 1.5F, 1.5F);
    this.scopeAttachPoint = new Vector3f(0.3125F, 0.3125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[2];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 18, 0, textureX, textureY);
    this.defaultStockModel[0].addShapeBox(-2.0F, 1.0F, -1.0F, 2, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 28, 0, textureX, textureY);
    this.defaultStockModel[1].addShapeBox(-8.0F, 0.0F, -1.0F, 6, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.stockAttachPoint = new Vector3f(0.0F, 0.1875F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.25F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.5625F, 0.140625F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 14, textureX, textureY);
    this.ammoModel[0].addBox(1.0F, 3.0F, -0.5F, 2, 1, 1);
    translateAll(0.0F, -0.5F, 0.0F);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.RIFLE_TOP;
    this.pumpDelayAfterReload = 86;
    this.pumpDelay = 7;
    this.pumpTime = 12;
    this.gripIsOnPump = true;
    this.pumpHandleDistance = -0.25F;
    this.spinningCocking = true;
    this.spinPoint = new Vector3f(0.0625F, 0.125F, 0.0F);
    this.numBulletsInReloadAnimation = 5.0F;
    this.tiltGunTime = 0.159F;
    this.unloadClipTime = 0.0F;
    this.loadClipTime = 0.708F;
    this.untiltGunTime = 0.133F;
  }
}
