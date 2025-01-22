package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelAK74 extends ModelGun {
  public ModelAK74() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[7];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-1.0F, 3.0F, -1.0F, 9, 1, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 3, textureX, textureY);
    this.gunModel[1].addShapeBox(-1.0F, 4.0F, -1.0F, 12, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 6, textureX, textureY);
    this.gunModel[2].addShapeBox(8.0F, 3.0F, -1.0F, 3, 1, 2, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 10, 6, textureX, textureY);
    this.gunModel[3].addBox(-1.0F, 2.0F, -1.0F, 2, 1, 2);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 28, 0, textureX, textureY);
    this.gunModel[4].addBox(-0.75F, -3.0F, -0.75F, 1.5F, 4.0F, 1.5F);
    this.gunModel[4].func_78793_a(-0.2F, 2.0F, 0.0F);
    (this.gunModel[4]).field_78808_h = -0.5F;
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 13, textureX, textureY);
    this.gunModel[5].addBox(11.0F, 3.75F, -0.25F, 0.5F, 2.0F, 0.5F);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 4, 14, textureX, textureY);
    this.gunModel[6].addBox(11.0F, 3.25F, -0.25F, 3.0F, 0.5F, 0.5F);
    this.ammoModel = new ModelRendererTurbo[2];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 12, 12, textureX, textureY);
    this.ammoModel[0].addShapeBox(4.0F, 1.0F, -1.0F, 2, 2, 2, 0.0F, -0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 20, 12, textureX, textureY);
    this.ammoModel[1].addShapeBox(4.0F, -1.0F, -1.0F, 2, 2, 2, 0.0F, -2.0F, 0.0F, 0.0F, 1.25F, -1.25F, 0.0F, 1.25F, -1.25F, 0.0F, -2.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F);
    this.stockAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[4];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 12, 10, textureX, textureY);
    this.defaultStockModel[0].addBox(-2.0F, 3.0F, -0.5F, 1, 1, 1);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 16, 10, textureX, textureY);
    this.defaultStockModel[1].addShapeBox(-7.0F, 1.0F, -0.5F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 18, 8, textureX, textureY);
    this.defaultStockModel[2].addBox(-7.0F, 3.5F, -0.5F, 5.0F, 0.5F, 1.0F);
    this.defaultStockModel[3] = new ModelRendererTurbo((ModelBase)this, 28, 12, textureX, textureY);
    this.defaultStockModel[3].addBox(-8.0F, 1.0F, -0.5F, 1, 3, 1);
    this.barrelAttachPoint = new Vector3f(0.734375F, 0.21875F, 0.0F);
    this.defaultBarrelModel = new ModelRendererTurbo[1];
    this.defaultBarrelModel[0] = new ModelRendererTurbo((ModelBase)this, 32, 14, textureX, textureY);
    this.defaultBarrelModel[0].addBox(11.5F, 3.0F, -0.5F, 2, 1, 1);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.defaultScopeModel = new ModelRendererTurbo[1];
    this.defaultScopeModel[0] = new ModelRendererTurbo((ModelBase)this, 38, 14, textureX, textureY);
    this.defaultScopeModel[0].addBox(4.0F, 5.0F, -0.5F, 1, 1, 1);
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
