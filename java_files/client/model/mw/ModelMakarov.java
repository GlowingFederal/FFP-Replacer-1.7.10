package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelMakarov extends ModelGun {
  public ModelMakarov() {
    int textureX = 32;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[3];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-1.0F, -1.0F, -1.0F, 2, 3, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.gunModel[1].addShapeBox(-2.0F, 2.0F, -1.0F, 5, 1, 2, 0.0F, -1.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 8, textureX, textureY);
    this.gunModel[2].addBox(0.5F, 3.0F, -0.5F, 6, 1, 1);
    this.slideModel = new ModelRendererTurbo[3];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 10, textureX, textureY);
    this.slideModel[0].addShapeBox(-2.0F, 3.0F, -1.0F, 8, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.slideModel[1] = new ModelRendererTurbo((ModelBase)this, 2, 5, textureX, textureY);
    this.slideModel[1].addBox(-0.5F, 4.25F, -0.5F, 1, 1, 1);
    this.slideModel[2] = new ModelRendererTurbo((ModelBase)this, 2, 5, textureX, textureY);
    this.slideModel[2].addBox(4.75F, 4.25F, -0.5F, 1, 1, 1);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 13, 0, textureX, textureY);
    this.ammoModel[0].addBox(-0.9F, -0.75F, -0.5F, 1.8F, 4.0F, 1.0F);
    this.barrelAttachPoint = new Vector3f(0.40625F, 0.25F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.scopeIsOnSlide = true;
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.PISTOL_CLIP;
  }
}
