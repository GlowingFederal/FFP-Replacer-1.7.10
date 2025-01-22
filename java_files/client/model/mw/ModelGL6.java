package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelGL6 extends ModelGun {
  public ModelGL6() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[13];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addShapeBox(-12.0F, 1.0F, -1.0F, 9, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 22, 0, textureX, textureY);
    this.gunModel[1].addBox(-3.0F, 1.0F, -1.0F, 3, 3, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 32, 0, textureX, textureY);
    this.gunModel[2].addShapeBox(-3.0F, -2.0F, -1.0F, 2, 3, 2, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.gunModel[3].addBox(-2.0F, 4.0F, -1.0F, 10, 1, 2);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 8, textureX, textureY);
    this.gunModel[4].addBox(0.0F, -2.0F, -1.0F, 1, 6, 2);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 8, textureX, textureY);
    this.gunModel[5].addShapeBox(0.0F, -2.0F, 1.0F, 1, 6, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 8, textureX, textureY);
    this.gunModel[6].addShapeBox(0.0F, -2.0F, -3.0F, 1, 6, 2, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 8, textureX, textureY);
    this.gunModel[7].addBox(7.0F, -2.0F, -1.0F, 1, 6, 2);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 8, textureX, textureY);
    this.gunModel[8].addShapeBox(7.0F, -2.0F, 1.0F, 1, 6, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 0, 8, textureX, textureY);
    this.gunModel[9].addShapeBox(7.0F, -2.0F, -3.0F, 1, 6, 2, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 22, 13, textureX, textureY);
    this.gunModel[10].addBox(0.0F, -3.0F, -1.0F, 8, 1, 2);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 22, 9, textureX, textureY);
    this.gunModel[11].addBox(8.0F, 1.5F, -1.0F, 8, 2, 2);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 40, 0, textureX, textureY);
    this.gunModel[12].addBox(8.0F, 1.0F, -1.5F, 4, 3, 3);
    this.revolverBarrelModel = new ModelRendererTurbo[3];
    this.revolverBarrelModel[0] = new ModelRendererTurbo((ModelBase)this, 6, 8, textureX, textureY);
    this.revolverBarrelModel[0].addBox(1.0F, -2.0F, -1.0F, 6, 6, 2);
    this.revolverBarrelModel[1] = new ModelRendererTurbo((ModelBase)this, 6, 8, textureX, textureY);
    this.revolverBarrelModel[1].addShapeBox(1.0F, -2.0F, 1.0F, 6, 6, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F);
    this.revolverBarrelModel[2] = new ModelRendererTurbo((ModelBase)this, 6, 8, textureX, textureY);
    this.revolverBarrelModel[2].addShapeBox(1.0F, -2.0F, -3.0F, 6, 6, 2, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.revolverFlipAngle = -90.0F;
    this.revolverFlipPoint = new Vector3f(0.0F, -0.15625F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[6];
    for (int i = 0; i < 6; i++) {
      this.ammoModel[i] = new ModelRendererTurbo((ModelBase)this, 42, 12, textureX, textureY);
      this.ammoModel[i].addBox(0.9F, -2.75F, -0.75F, 4.0F, 1.5F, 1.5F);
      this.ammoModel[i].func_78793_a(0.0F, 1.0F, 0.0F);
      (this.ammoModel[i]).field_78795_f = 1.0471976F * i;
    } 
    this.barrelAttachPoint = new Vector3f(0.46875F, 0.25F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.375F, 0.3125F, 0.0F);
    translateAll(6.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.25F;
    this.animationType = EnumAnimationType.REVOLVER;
    this.tiltGunTime = 0.2F;
    this.unloadClipTime = 0.2F;
    this.loadClipTime = 0.4F;
    this.untiltGunTime = 0.2F;
    this.itemFrameOffset = new Vector3f(-0.125F, 0.0F, 0.0F);
  }
}
