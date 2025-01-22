package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelSPAS extends ModelGun {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelSPAS() {
    this.gunModel = new ModelRendererTurbo[11];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 7, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 8, 7, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 12, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 8, 11, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 8, 16, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 19, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 12, 0, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 15, 2, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 16, 19, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 22, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 12, 0, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, -2.3F, -1.0F, 2, 3, 2, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 1.0F, -0.5F, -0.2F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, 1.0F, -0.5F, -0.2F);
    this.gunModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[1].addShapeBox(-0.5F, -4.3F, -1.0F, 5, 2, 2, 0.0F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F);
    this.gunModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[2].func_78790_a(4.0F, -5.0F, -1.0F, 2, 3, 2, 0.0F);
    this.gunModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[3].addShapeBox(6.0F, -5.0F, -1.0F, 6, 3, 2, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[4].func_78790_a(6.0F, -3.2F, -0.5F, 8, 1, 1, 0.0F);
    this.gunModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[5].func_78790_a(7.0F, -4.4F, -0.5F, 8, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[6].func_78790_a(12.0F, -5.4F, -0.5F, 1, 1, 1, 0.0F);
    this.gunModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[7].addShapeBox(-2.0F, -3.1F, -1.5F, 3, 1, 3, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.gunModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.gunModel[7]).field_78808_h = 0.29670596F;
    this.gunModel[8].addShapeBox(-4.0F, -3.1F, -1.5F, 2, 1, 3, 0.0F, -0.5F, 0.4F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -0.5F, 0.4F, -0.5F, -0.2F, -0.5F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, -0.2F, -0.5F, -0.5F);
    this.gunModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.gunModel[8]).field_78808_h = 0.29670596F;
    this.gunModel[9].func_78790_a(-5.3F, -2.5F, -1.0F, 1, 3, 2, 0.0F);
    this.gunModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.gunModel[9]).field_78808_h = -0.05235988F;
    this.gunModel[10].func_78790_a(6.0F, -4.4F, -0.5F, 1, 1, 1, 0.0F);
    this.gunModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(2.0F, -3.5F, -0.5F, 2, 1, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.pumpModel = new ModelRendererTurbo[1];
    this.pumpModel[0] = new ModelRendererTurbo((ModelBase)this, 23, 6, this.textureX, this.textureY);
    this.pumpModel[0].addShapeBox(6.75F, -4.25F, -1.5F, 4, 3, 3, 0.0F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F);
    this.pumpModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.barrelAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.stockAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.3125F, 0.3125F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.546875F, 0.125F, 0.0F);
    this.pumpDelayAfterReload = 115;
    this.pumpDelay = 6;
    this.pumpTime = 9;
    this.gripIsOnPump = true;
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.SHOTGUN;
    this.numBulletsInReloadAnimation = 7.0F;
    this.tiltGunTime = 0.159F;
    this.unloadClipTime = 0.0F;
    this.loadClipTime = 0.708F;
    this.untiltGunTime = 0.133F;
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
}
