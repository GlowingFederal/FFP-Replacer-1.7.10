package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelDesertEagle extends ModelGun {
  public ModelDesertEagle() {
    int textureX = 32;
    int textureY = 32;
    this.gunModel = new ModelRendererTurbo[6];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-3.0F, 1.0F, -1.0F, 7, 1, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 3, textureX, textureY);
    this.gunModel[1].addBox(-2.0F, -3.0F, -1.0F, 3, 4, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 13, textureX, textureY);
    this.gunModel[2].addBox(-1.0F, 2.1F, -0.5F, 11, 1, 1);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.gunModel[3].addBox(2.0F, 3.0F, -1.0F, 8, 2, 2);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 10, 3, textureX, textureY);
    this.gunModel[4].addBox(10.0F, 2.0F, -1.0F, 2, 3, 2);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 23, textureX, textureY);
    this.gunModel[5].addBox(10.5F, 4.2F, -0.5F, 1, 1, 1);
    this.slideModel = new ModelRendererTurbo[4];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 15, textureX, textureY);
    this.slideModel[0].addBox(-2.0F, 2.0F, -1.0F, 4, 3, 2);
    this.slideModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 20, textureX, textureY);
    this.slideModel[1].addBox(2.0F, 2.0F, -1.0F, 8, 1, 2);
    this.slideModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 23, textureX, textureY);
    this.slideModel[2].addBox(-3.0F, 3.0F, -0.5F, 1, 1, 1);
    this.slideModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 23, textureX, textureY);
    this.slideModel[3].addBox(-1.5F, 4.2F, -0.5F, 1, 1, 1);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 25, textureX, textureY);
    this.ammoModel[0].addBox(-1.5F, -2.8F, -0.5F, 2, 4, 1);
    translateAll(0.0F, 1.0F, 0.0F);
    this.barrelAttachPoint = new Vector3f(0.75F, 0.28125F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.3125F, 0.375F, 0.0F);
    this.scopeIsOnSlide = false;
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.PISTOL_CLIP;
  }
}
