package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelGL1 extends ModelGun {
  public ModelGL1() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[4];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addShapeBox(-8.0F, 2.0F, -1.0F, 4, 3, 2, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 12, 0, textureX, textureY);
    this.gunModel[1].addShapeBox(-4.0F, 2.0F, -1.0F, 4, 2, 2, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 24, 0, textureX, textureY);
    this.gunModel[2].addShapeBox(0.0F, 2.0F, -1.0F, 3, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.gunModel[3].addBox(3.0F, 2.0F, -1.0F, 5, 1, 2);
    this.breakActionModel = new ModelRendererTurbo[5];
    this.breakActionModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 8, textureX, textureY);
    this.breakActionModel[0].addBox(3.0F, 3.0F, -1.0F, 13, 2, 2);
    this.breakActionModel[1] = new ModelRendererTurbo((ModelBase)this, 14, 5, textureX, textureY);
    this.breakActionModel[1].addBox(15.0F, 5.0F, -0.5F, 1, 1, 1);
    this.breakActionModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 13, textureX, textureY);
    this.breakActionModel[2].addBox(8.0F, 2.0F, -1.0F, 4, 1, 2);
    this.breakActionModel[3] = new ModelRendererTurbo((ModelBase)this, 12, 14, textureX, textureY);
    this.breakActionModel[3].addBox(3.0F, 4.5F, -0.5F, 3, 1, 1);
    this.breakActionModel[4] = new ModelRendererTurbo((ModelBase)this, 34, -1, textureX, textureY);
    this.breakActionModel[4].addShapeBox(11.0F, 5.0001F, -3.5F, 1, 10, 7, 0.0F, 0.0F, 0.0F, -2.5F, 0.0F, 0.0F, -2.5F, 0.0F, 0.0F, -2.5F, 0.0F, 0.0F, -2.5F, 0.0F, -6.0F, -2.5F, 0.0F, -6.0F, -2.5F, 0.0F, -6.0F, -2.5F, 0.0F, -6.0F, -2.5F);
    this.breakAngle = 60.0F;
    this.barrelBreakPoint = new Vector3f(0.25F, 0.125F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 20, 12, textureX, textureY);
    this.ammoModel[0].addBox(2.9F, 3.25F, -0.75F, 3.0F, 1.5F, 1.5F);
    this.barrelAttachPoint = new Vector3f(0.46875F, 0.25F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.scopeIsOnSlide = true;
    translateAll(-4.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.BREAK_ACTION;
    this.tiltGunTime = 0.2F;
    this.unloadClipTime = 0.2F;
    this.loadClipTime = 0.2F;
    this.untiltGunTime = 0.4F;
  }
}
