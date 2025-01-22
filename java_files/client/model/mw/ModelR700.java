package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelR700 extends ModelGun {
  public ModelR700() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[2];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(1.0F, 1.5F, -0.5F, 16, 1, 1);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 2, textureX, textureY);
    this.gunModel[1].addBox(-1.0F, 0.0F, -1.0F, 13, 2, 2);
    this.defaultScopeModel = new ModelRendererTurbo[5];
    this.defaultScopeModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.defaultScopeModel[0].addBox(-1.0F, 4.0F, -1.0F, 2, 2, 2);
    this.defaultScopeModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 13, textureX, textureY);
    this.defaultScopeModel[1].addBox(1.0F, 4.5F, -0.5F, 3, 1, 1);
    this.defaultScopeModel[2] = new ModelRendererTurbo((ModelBase)this, 8, 9, textureX, textureY);
    this.defaultScopeModel[2].addBox(4.0F, 4.0F, -1.0F, 3, 2, 2);
    this.defaultScopeModel[3] = new ModelRendererTurbo((ModelBase)this, 8, 13, textureX, textureY);
    this.defaultScopeModel[3].addBox(1.0F, 2.5F, -0.5F, 1, 2, 1);
    this.defaultScopeModel[4] = new ModelRendererTurbo((ModelBase)this, 12, 13, textureX, textureY);
    this.defaultScopeModel[4].addBox(3.0F, 2.5F, -0.5F, 1, 2, 1);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.0625F, 0.28125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[2];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 16, 6, textureX, textureY);
    this.defaultStockModel[0].addBox(-2.0F, -0.5F, -1.0F, 1, 2, 2);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 18, 10, textureX, textureY);
    this.defaultStockModel[1].addBox(-8.0F, -1.0F, -1.0F, 6, 3, 2);
    this.stockAttachPoint = new Vector3f(-0.0625F, 0.0625F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 26, 6, textureX, textureY);
    this.ammoModel[0].addBox(1.0F, 0.5F, -0.5F, 3, 1, 1);
    translateAll(0.0F, 2.5F, 0.0F);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.RIFLE;
    this.numBulletsInReloadAnimation = 4.0F;
    this.tiltGunTime = 0.279F;
    this.unloadClipTime = 0.0F;
    this.loadClipTime = 0.558F;
    this.untiltGunTime = 0.163F;
  }
}
