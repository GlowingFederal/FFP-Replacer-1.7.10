package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelSIGP226 extends ModelGun {
  public ModelSIGP226() {
    int textureX = 32;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[3];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-1.0F, 3.0F, -1.0F, 7, 1, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 3, textureX, textureY);
    this.gunModel[1].addShapeBox(-1.0F, -1.0F, -1.0F, 2, 4, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 8, 3, textureX, textureY);
    this.gunModel[2].addBox(0.5F, 3.5F, -0.5F, 6, 1, 1);
    this.slideModel = new ModelRendererTurbo[2];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.slideModel[0].addShapeBox(-1.0F, 4.0F, -1.0F, 7, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.slideModel[1] = new ModelRendererTurbo((ModelBase)this, 8, 5, textureX, textureY);
    this.slideModel[1].addBox(0.0F, 4.5F, -0.5F, 1, 1, 1);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 16, 5, textureX, textureY);
    this.ammoModel[0].addShapeBox(0.0F, -0.9F, -0.5F, 2, 4, 1, 0.0F, 0.9F, 0.0F, 0.0F, -1.1F, 0.0F, 0.0F, -1.1F, 0.0F, 0.0F, 0.9F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    translateAll(0.0F, 0.0F, 0.0F);
    this.barrelAttachPoint = new Vector3f(0.40625F, 0.25F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.scopeIsOnSlide = true;
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.PISTOL_CLIP;
  }
}
