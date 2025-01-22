package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelStinger extends ModelGun {
  public ModelStinger() {
    int textureX = 64;
    int textureY = 32;
    this.gunModel = new ModelRendererTurbo[5];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-15.0F, 2.5F, -1.0F, 25, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[1].addBox(-16.0F, 2.0F, -1.5F, 1, 3, 3);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 8, 4, textureX, textureY);
    this.gunModel[2].addBox(10.0F, 2.0F, -1.5F, 2, 3, 3);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 10, textureX, textureY);
    this.gunModel[3].addBox(0.0F, -0.5F, -0.5F, 1, 3, 1);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 4, 10, textureX, textureY);
    this.gunModel[4].addBox(3.0F, -0.5F, -1.0F, 6, 3, 2);
    int i;
    for (i = 0; i < 5; i++)
      this.gunModel[i].func_78793_a(0.0F, 0.0F, 2.0F); 
    this.scopeAttachPoint = new Vector3f(0.09375F, 0.3125F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.25F, 0.0F);
    this.stockAttachPoint = new Vector3f(-0.0625F, 0.0625F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[3];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 60, 0, textureX, textureY);
    this.ammoModel[0].addBox(-0.5F, -10.0F, -0.5F, 1, 20, 1);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 55, 0, textureX, textureY);
    this.ammoModel[1].addBox(-1.0F, -10.0F, 0.0F, 2, 1, 0);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 55, 2, textureX, textureY);
    this.ammoModel[2].addBox(0.0F, -10.0F, -1.0F, 0, 1, 2);
    for (i = 0; i < 3; i++) {
      this.ammoModel[i].func_78793_a(0.0F, 3.5F, 2.0F);
      (this.ammoModel[i]).field_78808_h = -1.5707964F;
    } 
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.END_LOADED;
    this.endLoadedAmmoDistance = 3.0F;
    this.tiltGunTime = 0.25F;
    this.unloadClipTime = 0.25F;
    this.loadClipTime = 0.25F;
    this.untiltGunTime = 0.25F;
    this.thirdPersonOffset = new Vector3f(0.0F, 0.0F, -0.1F);
    this.itemFrameOffset = new Vector3f(0.25F, 0.0F, 0.0F);
  }
}
