package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelM72LAW extends ModelGun {
  public ModelM72LAW() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[4];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 10, textureX, textureY);
    this.gunModel[0].addBox(-12.0F, 1.0F, -1.5F, 26, 3, 3);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 7, textureX, textureY);
    this.gunModel[1].addBox(-12.0F, 4.0F, -1.0F, 3, 1, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[2].addBox(0.0F, 4.0F, -1.0F, 14, 1, 2);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 3, textureX, textureY);
    this.gunModel[3].addBox(0.0F, 5.0F, -0.5F, 1, 2, 1);
    this.scopeAttachPoint = new Vector3f(0.09375F, 0.3125F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.25F, 0.0F);
    this.stockAttachPoint = new Vector3f(-0.0625F, 0.0625F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[0];
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.END_LOADED;
    this.tiltGunTime = 0.4F;
    this.unloadClipTime = 0.1F;
    this.loadClipTime = 0.1F;
    this.untiltGunTime = 0.4F;
  }
}
