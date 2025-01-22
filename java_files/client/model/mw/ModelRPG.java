package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelRPG extends ModelGun {
  public ModelRPG() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[5];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-14.0F, 2.5F, -1.0F, 22, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[1].addBox(-15.0F, 2.0F, -1.5F, 1, 3, 3);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 8, 4, textureX, textureY);
    this.gunModel[2].addBox(-5.0F, 2.0F, -1.5F, 8, 3, 3);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 13, textureX, textureY);
    this.gunModel[3].addBox(0.0F, 0.0F, -0.5F, 1, 2, 1);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 4, 11, textureX, textureY);
    this.gunModel[4].addBox(4.0F, -1.0F, -0.5F, 1, 4, 1);
    this.scopeAttachPoint = new Vector3f(0.09375F, 0.3125F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.25F, 0.0F);
    this.stockAttachPoint = new Vector3f(-0.0625F, 0.0625F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[4];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 14, 12, textureX, textureY);
    this.ammoModel[0].addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 26, 9, textureX, textureY);
    this.ammoModel[1].addTrapezoid(-2.0F, 1.0F, -2.0F, 4, 3, 4, 0.0F, -1.0F, 4);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 38, 6, textureX, textureY);
    this.ammoModel[2].addTrapezoid(-2.0F, 4.0F, -2.0F, 4, 3, 4, 0.0F, -1.0F, 5);
    this.ammoModel[3] = new ModelRendererTurbo((ModelBase)this, 38, 5, textureX, textureY);
    this.ammoModel[3].addBox(-0.5F, -4.0F, -0.5F, 1, 4, 1);
    for (int i = 0; i < 4; i++) {
      this.ammoModel[i].func_78793_a(8.0F, 3.5F, 0.0F);
      (this.ammoModel[i]).field_78808_h = -1.5707964F;
    } 
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.END_LOADED;
    this.tiltGunTime = 0.4F;
    this.unloadClipTime = 0.1F;
    this.loadClipTime = 0.1F;
    this.untiltGunTime = 0.4F;
    this.itemFrameOffset = new Vector3f(0.25F, 0.0F, 0.0F);
  }
}
