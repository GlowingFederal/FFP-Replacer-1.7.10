package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelMiniUzi extends ModelGun {
  public ModelMiniUzi() {
    int textureX = 32;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[7];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-1.0F, 3.0F, -1.0F, 8, 2, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 4, textureX, textureY);
    this.gunModel[1].addShapeBox(0.0F, 2.0F, -1.0F, 6, 1, 2, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 7, textureX, textureY);
    this.gunModel[2].addBox(1.0F, -1.0F, -1.0F, 2, 3, 2);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 12, textureX, textureY);
    this.gunModel[3].addBox(0.0F, 5.0F, -0.5F, 1.0F, 0.5F, 1.0F);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 14, textureX, textureY);
    this.gunModel[4].addBox(6.0F, 5.0F, -0.5F, 1.0F, 0.5F, 1.0F);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 4, 12, textureX, textureY);
    this.gunModel[5].addBox(6.5F, 3.25F, -0.5F, 1, 1, 1);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 4, 14, textureX, textureY);
    this.gunModel[6].addBox(7.0F, 3.5F, -0.25F, 2.0F, 0.5F, 0.5F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 10, 7, textureX, textureY);
    this.ammoModel[0].addBox(1.25F, -4.0F, -0.75F, 1.5F, 6.0F, 1.5F);
    this.barrelAttachPoint = new Vector3f(0.46875F, 0.234375F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.PISTOL_CLIP;
  }
}
