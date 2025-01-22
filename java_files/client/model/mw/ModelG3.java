package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelG3 extends ModelGun {
  public ModelG3() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[8];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-1.0F, 3.0F, -1.0F, 8, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[1].addBox(0.0F, 2.0F, -1.0F, 6, 1, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 7, textureX, textureY);
    this.gunModel[2].addBox(7.0F, 3.0F, -1.0F, 8.0F, 1.5F, 2.0F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 11, textureX, textureY);
    this.gunModel[3].addBox(7.0F, 4.5F, -0.5F, 8.0F, 0.5F, 1.0F);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 13, textureX, textureY);
    this.gunModel[4].addBox(15.0F, 3.375F, -0.375F, 2.0F, 0.75F, 0.75F);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 6, 13, textureX, textureY);
    this.gunModel[5].addBox(17.0F, 3.25F, -0.5F, 1, 1, 1);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 20, 0, textureX, textureY);
    this.gunModel[6].addBox(-0.75F, -3.0F, -0.75F, 1.5F, 4.0F, 1.5F);
    this.gunModel[6].func_78793_a(1.0F, 2.0F, 0.0F);
    (this.gunModel[6]).field_78808_h = -0.5F;
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 16, 5, textureX, textureY);
    this.gunModel[7].addBox(14.0F, 5.0F, -0.5F, 1, 1, 1);
    this.scopeAttachPoint = new Vector3f(0.25F, 0.3125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[3];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 10, 13, textureX, textureY);
    this.defaultStockModel[0].addBox(-8.0F, 2.0F, -0.5F, 1, 2, 1);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 20, 6, textureX, textureY);
    this.defaultStockModel[1].addShapeBox(-7.0F, 2.0F, -0.5F, 5, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 20, 9, textureX, textureY);
    this.defaultStockModel[2].addShapeBox(-2.0F, 3.0F, -1.0F, 1, 2, 2, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -0.5F);
    this.stockAttachPoint = new Vector3f(-0.25F, 0.21875F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.125F, 0.234375F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.625F, 0.1875F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 26, 9, textureX, textureY);
    this.ammoModel[0].addBox(3.5F, -1.0F, -0.75F, 2.0F, 4.0F, 1.5F);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
