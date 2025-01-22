package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelBizon extends ModelGun {
  public ModelBizon() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[5];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addShapeBox(-2.0F, 3.0F, -1.0F, 15, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[1].addBox(-2.0F, 2.0F, -1.0F, 5, 1, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 7, textureX, textureY);
    this.gunModel[2].addShapeBox(-2.0F, -1.0F, -1.0F, 2, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 8, 7, textureX, textureY);
    this.gunModel[3].addBox(13.0F, 3.5F, -0.5F, 2, 1, 1);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 8, 9, textureX, textureY);
    this.gunModel[4].addBox(13.0F, 4.5F, -0.5F, 1, 1, 1);
    this.scopeAttachPoint = new Vector3f(0.46875F, 0.3125F, 0.0F);
    this.barrelAttachPoint = new Vector3f(0.625F, 0.125F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 12, textureX, textureY);
    this.ammoModel[0].addBox(3.0F, 1.2F, -0.9F, 10.0F, 1.8F, 1.8F);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
