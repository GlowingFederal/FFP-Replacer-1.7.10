package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelMP5 extends ModelGun {
  public ModelMP5() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[6];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-1.0F, 4.0F, -0.75F, 12.0F, 1.0F, 1.5F);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 3, textureX, textureY);
    this.gunModel[1].addBox(-1.0F, 3.0F, -1.0F, 12, 1, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 6, textureX, textureY);
    this.gunModel[2].addBox(-1.0F, 2.0F, -1.0F, 6, 1, 2);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 26, 0, textureX, textureY);
    this.gunModel[3].addBox(11.0F, 3.0F, -0.5F, 1, 1, 1);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 26, 0, textureX, textureY);
    this.gunModel[5].addBox(10.0F, 5.0F, -0.5F, 1, 1, 1);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.gunModel[4].addBox(-0.75F, -3.0F, -0.75F, 1.5F, 4.0F, 1.5F);
    this.gunModel[4].func_78793_a(1.0F, 2.0F, 0.0F);
    (this.gunModel[4]).field_78808_h = -0.5F;
    this.ammoModel = new ModelRendererTurbo[2];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 8, 9, textureX, textureY);
    this.ammoModel[0].addShapeBox(3.5F, 0.0F, -0.5F, 1, 3, 1, 0.0F, -1.0F, 0.0F, 0.0F, 0.8F, -0.2F, 0.0F, 0.8F, -0.2F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 12, 9, textureX, textureY);
    this.ammoModel[1].addShapeBox(3.5F, -3.0F, -0.5F, 1, 3, 1, 0.0F, -2.5F, -1.0F, 0.0F, 2.0F, -1.5F, 0.0F, 2.0F, -1.5F, 0.0F, -2.5F, -1.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.8F, 0.2F, 0.0F, 0.8F, 0.2F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.stockAttachPoint = new Vector3f(-0.0625F, 0.21875F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[2];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 16, 6, textureX, textureY);
    this.defaultStockModel[0].addBox(-7.0F, 3.0F, -0.5F, 6, 1, 1);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 16, 8, textureX, textureY);
    this.defaultStockModel[1].addBox(-8.0F, 1.0F, -0.5F, 1, 3, 1);
    this.barrelAttachPoint = new Vector3f(0.75F, 0.21875F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.125F, 0.3125F, 0.0F);
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.PISTOL_CLIP;
  }
}
