package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelM60E4 extends ModelGun {
  public ModelM60E4() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[10];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-5.0F, 2.0F, -1.0F, 13, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[1].addShapeBox(-8.0F, 1.0F, -1.0F, 3, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.gunModel[2].addBox(-3.0F, 4.0F, -1.0F, 7, 1, 2);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 12, textureX, textureY);
    this.gunModel[3].addBox(-1.0F, 1.0F, -1.0F, 3, 1, 2);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 30, 0, textureX, textureY);
    this.gunModel[4].addBox(-0.75F, -3.0F, -0.75F, 1.5F, 4.0F, 1.5F);
    this.gunModel[4].func_78793_a(0.0F, 1.0F, 0.0F);
    (this.gunModel[4]).field_78808_h = -0.5F;
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 10, 4, textureX, textureY);
    this.gunModel[5].addBox(5.0F, 1.5F, -1.25F, 5.0F, 1.5F, 2.5F);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 10, 14, textureX, textureY);
    this.gunModel[6].addBox(8.0F, 2.1F, -0.4F, 7.0F, 0.8F, 0.8F);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 8, 12, textureX, textureY);
    this.gunModel[7].addBox(8.0F, 3.2F, -0.3F, 8.0F, 0.6F, 0.6F);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 18, 10, textureX, textureY);
    this.gunModel[8].addBox(12.0F, 2.9F, -0.4F, 1.0F, 1.0F, 0.8F);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 22, 9, textureX, textureY);
    this.gunModel[9].addBox(14.0F, 3.1F, -0.4F, 1.0F, 2.0F, 0.8F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 26, 6, textureX, textureY);
    this.ammoModel[0].addBox(1.0F, -1.0F, -7.0F, 3, 4, 6);
    this.stockAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.barrelAttachPoint = new Vector3f(0.734375F, 0.21875F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.0F, 0.3125F, 0.0F);
    this.defaultScopeModel = new ModelRendererTurbo[1];
    this.defaultScopeModel[0] = new ModelRendererTurbo((ModelBase)this, 26, 10, textureX, textureY);
    this.defaultScopeModel[0].addBox(3.8F, 5.0F, -0.2F, 0.2F, 1.0F, 0.4F);
    this.gripAttachPoint = new Vector3f(0.46875F, 0.125F, 0.0F);
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
    this.tiltGunTime = 0.1F;
    this.unloadClipTime = 0.2F;
    this.loadClipTime = 0.2F;
    this.untiltGunTime = 0.5F;
  }
}
