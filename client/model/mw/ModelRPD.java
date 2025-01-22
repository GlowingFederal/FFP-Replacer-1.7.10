package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelRPD extends ModelGun {
  public ModelRPD() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[8];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-1.0F, 3.0F, -1.0F, 8, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 20, 0, textureX, textureY);
    this.gunModel[1].addShapeBox(7.0F, 3.0F, -1.0F, 2, 2, 2, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 28, 0, textureX, textureY);
    this.gunModel[2].addShapeBox(9.0F, 3.0F, -1.0F, 2, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[3].addBox(11.0F, 4.1F, -0.4F, 8.0F, 0.8F, 0.8F);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 18, 4, textureX, textureY);
    this.gunModel[4].addBox(11.0F, 3.1F, -0.4F, 3.0F, 0.8F, 0.8F);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 36, 0, textureX, textureY);
    this.gunModel[5].addBox(12.5F, 3.0F, -0.5F, 1, 2, 1);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 40, 0, textureX, textureY);
    this.gunModel[6].addBox(17.5F, 4.0F, -0.5F, 1, 2, 1);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 6, textureX, textureY);
    this.gunModel[7].addBox(-1.0F, -4.0F, -0.75F, 2.0F, 5.0F, 1.5F);
    this.gunModel[7].func_78793_a(1.0F, 3.0F, 0.0F);
    (this.gunModel[7]).field_78808_h = -0.5F;
    this.ammoModel = new ModelRendererTurbo[3];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 8, 6, textureX, textureY);
    this.ammoModel[0].addBox(4.0F, -1.0F, -1.0F, 2, 5, 2);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 24, 6, textureX, textureY);
    this.ammoModel[1].addShapeBox(4.0F, -1.0F, -3.0F, 2, 5, 2, 0.0F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 16, 6, textureX, textureY);
    this.ammoModel[2].addShapeBox(4.0F, -1.0F, 1.0F, 2, 5, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F);
    this.stockAttachPoint = new Vector3f(-0.0625F, 0.25F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[3];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 32, 4, textureX, textureY);
    this.defaultStockModel[0].addShapeBox(-2.0F, 3.0F, -1.0F, 1, 2, 2, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 42, 12, textureX, textureY);
    this.defaultStockModel[1].addShapeBox(-5.0F, 2.0F, -1.0F, 3, 2, 2, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 32, 8, textureX, textureY);
    this.defaultStockModel[2].addBox(-8.0F, 1.0F, -1.0F, 3, 3, 2);
    this.barrelAttachPoint = new Vector3f(0.734375F, 0.21875F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.125F, 0.3125F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.46875F, 0.125F, 0.0F);
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
    this.tiltGunTime = 0.1F;
    this.unloadClipTime = 0.2F;
    this.loadClipTime = 0.2F;
    this.untiltGunTime = 0.5F;
  }
}
