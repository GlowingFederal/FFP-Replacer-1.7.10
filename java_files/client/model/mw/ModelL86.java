package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelL86 extends ModelGun {
  public ModelL86() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[8];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-8.0F, 1.0F, -1.0F, 1, 4, 2);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 6, 0, textureX, textureY);
    this.gunModel[1].addShapeBox(-7.0F, 2.0F, -1.0F, 8, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 26, 0, textureX, textureY);
    this.gunModel[2].addShapeBox(-4.0F, 1.0F, -1.0F, 2, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.625F, 0.0F, 0.0F, -0.375F, 0.0F, 0.0F, -0.375F, 0.0F, 0.0F, -0.625F, 0.0F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 6, textureX, textureY);
    this.gunModel[3].addBox(1.0F, 3.0F, -1.0F, 8, 2, 2);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 10, textureX, textureY);
    this.gunModel[4].addBox(9.0F, 3.5F, -0.5F, 8, 1, 1);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 12, textureX, textureY);
    this.gunModel[5].addBox(9.0F, 3.0F, -1.0F, 6, 1, 2);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 18, 5, textureX, textureY);
    this.gunModel[6].addBox(7.5F, 4.5F, -0.5F, 1, 1, 1);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 17, 11, textureX, textureY);
    this.gunModel[7].addShapeBox(3.0F, 0.0F, -1.0F, 2, 3, 2, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[3];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 9, textureX, textureY);
    this.ammoModel[0].addBox(-4.0F, -4.0F, -1.0F, 2, 5, 2);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 9, textureX, textureY);
    this.ammoModel[1].addShapeBox(-4.0F, -4.0F, -3.0F, 2, 5, 2, 0.0F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 9, textureX, textureY);
    this.ammoModel[2].addShapeBox(-4.0F, -4.0F, 1.0F, 2, 5, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -0.5F, 0.0F, -1.5F, -0.5F);
    this.stockAttachPoint = new Vector3f(-0.0625F, 0.25F, 0.0F);
    this.barrelAttachPoint = new Vector3f(0.734375F, 0.21875F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.125F, 0.3125F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.875F, 0.1875F, 0.0F);
    this.defaultGripModel = new ModelRendererTurbo[3];
    this.defaultGripModel[0] = new ModelRendererTurbo((ModelBase)this, 34, 0, textureX, textureY);
    this.defaultGripModel[0].addBox(15.0F, 2.0F, -1.0F, 1, 1, 2);
    this.defaultGripModel[1] = new ModelRendererTurbo((ModelBase)this, 44, 0, textureX, textureY);
    this.defaultGripModel[1].addShapeBox(15.0F, -3.0F, -1.0F, 1, 5, 1, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.defaultGripModel[2] = new ModelRendererTurbo((ModelBase)this, 40, 0, textureX, textureY);
    this.defaultGripModel[2].addShapeBox(15.0F, -3.0F, 0.0F, 1, 5, 1, 0.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, -3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.BULLPUP;
    this.tiltGunTime = 0.1F;
    this.unloadClipTime = 0.2F;
    this.loadClipTime = 0.2F;
    this.untiltGunTime = 0.5F;
  }
}
