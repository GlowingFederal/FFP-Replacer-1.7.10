package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMosin extends ModelGun {
  public ModelMosin() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[8];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addShapeBox(-8.0F, -2.0F, -1.0F, 4, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.gunModel[1].addShapeBox(-4.0F, -1.0F, -1.0F, 1, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.gunModel[2].addShapeBox(-3.0F, -1.0F, -1.0F, 3, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 12, textureX, textureY);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, -1.0F, 8, 2, 2, 0.0F);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 12, 0, textureX, textureY);
    this.gunModel[4].addShapeBox(0.0F, -1.0F, -1.0F, 4, 1, 2, 0.0F, -0.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 12, 3, textureX, textureY);
    this.gunModel[5].func_78790_a(1.0F, 1.5F, -0.5F, 18, 1, 1, 0.0F);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 24, 0, textureX, textureY);
    this.gunModel[6].func_78790_a(16.0F, 2.5F, -0.5F, 1, 1, 1, 0.0F);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 9, 6, textureX, textureY);
    this.gunModel[7].func_78790_a(8.0F, 1.0F, -1.0F, 5, 1, 2, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 23, 12, textureX, textureY);
    this.ammoModel[0].addBox(1.0F, -1.0F, -0.5F, 3, 3, 1);
    translateAll(0.0F, 2.5F, 0.0F);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.RIFLE_TOP;
    this.numBulletsInReloadAnimation = 1.0F;
    this.tiltGunTime = 0.279F;
    this.unloadClipTime = 0.0F;
    this.loadClipTime = 0.558F;
    this.untiltGunTime = 0.163F;
  }
}
