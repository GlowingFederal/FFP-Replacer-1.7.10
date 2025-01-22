package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelMinigun extends ModelGun {
  public ModelMinigun() {
    int textureX = 64;
    int textureY = 64;
    this.gunModel = new ModelRendererTurbo[5];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(0.0F, -4.0F, -3.0F, 8, 6, 6);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 22, 0, textureX, textureY);
    this.gunModel[1].addBox(1.0F, -4.0F, 3.0F, 6, 3, 3);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 28, 6, textureX, textureY);
    this.gunModel[2].addBox(7.0F, 2.0F, -3.0F, 1, 3, 1);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 32, 6, textureX, textureY);
    this.gunModel[3].addBox(7.0F, 2.0F, 2.0F, 1, 3, 1);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 36, 6, textureX, textureY);
    this.gunModel[4].addBox(7.0F, 5.0F, -2.0F, 1, 1, 4);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 46, textureX, textureY);
    this.ammoModel[0].addBox(1.0F, -3.0F, -7.0F, 6, 4, 4);
    this.minigunBarrelModel = new ModelRendererTurbo[12];
    for (int i = 0; i < 6; i++) {
      this.minigunBarrelModel[i] = new ModelRendererTurbo((ModelBase)this, 0, 16 + 2 * i, textureX, textureY);
      this.minigunBarrelModel[i].addBox(12.0F, 1.0F, -0.5F, 28, 1, 1);
      (this.minigunBarrelModel[i]).field_78795_f = i * 3.1415927F / 3.0F;
      this.minigunBarrelModel[i].func_78793_a(0.0F, -1.0F, 0.0F);
    } 
    this.minigunBarrelModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 28, textureX, textureY);
    this.minigunBarrelModel[6].addShapeBox(8.0F, 0.0F, -3.0F, 4, 3, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F);
    this.minigunBarrelModel[6].func_78793_a(0.0F, -1.0F, 0.0F);
    this.minigunBarrelModel[7] = new ModelRendererTurbo((ModelBase)this, 20, 28, textureX, textureY);
    this.minigunBarrelModel[7].addShapeBox(8.0F, -3.0F, -3.0F, 4, 3, 6, 0.0F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.minigunBarrelModel[7].func_78793_a(0.0F, -1.0F, 0.0F);
    this.minigunBarrelModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 37, textureX, textureY);
    this.minigunBarrelModel[8].addShapeBox(28.0F, 0.0F, -3.0F, 2, 3, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F);
    this.minigunBarrelModel[8].func_78793_a(0.0F, -1.0F, 0.0F);
    this.minigunBarrelModel[9] = new ModelRendererTurbo((ModelBase)this, 16, 37, textureX, textureY);
    this.minigunBarrelModel[9].addShapeBox(28.0F, -3.0F, -3.0F, 2, 3, 6, 0.0F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.minigunBarrelModel[9].func_78793_a(0.0F, -1.0F, 0.0F);
    this.minigunBarrelModel[10] = new ModelRendererTurbo((ModelBase)this, 32, 37, textureX, textureY);
    this.minigunBarrelModel[10].addShapeBox(36.0F, 0.0F, -3.0F, 2, 3, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F);
    this.minigunBarrelModel[10].func_78793_a(0.0F, -1.0F, 0.0F);
    this.minigunBarrelModel[11] = new ModelRendererTurbo((ModelBase)this, 48, 37, textureX, textureY);
    this.minigunBarrelModel[11].addShapeBox(36.0F, -3.0F, -3.0F, 2, 3, 6, 0.0F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.minigunBarrelModel[11].func_78793_a(0.0F, -1.0F, 0.0F);
    this.minigunBarrelOrigin = new Vector3f(0.5F, -0.0625F, 0.0F);
    this.animationType = EnumAnimationType.SIDE_CLIP;
    this.thirdPersonOffset = new Vector3f(0.0F, -0.15F, 0.0F);
    this.itemFrameOffset = new Vector3f(-1.0F, 0.1875F, 0.0F);
  }
}
