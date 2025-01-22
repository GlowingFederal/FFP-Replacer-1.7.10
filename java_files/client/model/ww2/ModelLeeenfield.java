package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelLeeenfield extends ModelGun {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelLeeenfield() {
    this.gunModel = new ModelRendererTurbo[11];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 9, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 17, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 26, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 34, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 39, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 53, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 58, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 67, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 88, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 0, 98, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 0, 108, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 7, 2, 3, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, 1.0F, -1.5F);
    this.gunModel[1].addShapeBox(0.0F, -1.0F, 0.0F, 20, 4, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1].func_78793_a(7.0F, 0.0F, -1.5F);
    this.gunModel[2].func_78790_a(0.0F, -1.0F, 0.0F, 2, 3, 2, 0.0F);
    this.gunModel[2].func_78793_a(27.0F, 0.0F, -1.0F);
    this.gunModel[3].func_78790_a(0.0F, -1.0F, 0.0F, 3, 1, 1, 0.0F);
    this.gunModel[3].func_78793_a(29.0F, 0.5F, -0.5F);
    this.gunModel[4].func_78790_a(0.0F, -2.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[4].func_78793_a(29.0F, 0.5F, -0.5F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 7, 1, 2, 0.0F);
    this.gunModel[5].func_78793_a(0.0F, 0.0F, -1.0F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
    this.gunModel[6].func_78793_a(-1.0F, 0.0F, -1.5F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    this.gunModel[7].func_78793_a(0.0F, -1.0F, -1.0F);
    this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 5, 4, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[8].func_78793_a(-6.0F, 0.0F, -1.5F);
    this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 8, 5, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[9].func_78793_a(-14.0F, 0.0F, -1.5F);
    this.gunModel[10].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.gunModel[10].func_78793_a(0.0F, 3.0F, -0.5F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 43, this.textureX, this.textureY);
    this.ammoModel[0].addShapeBox(0.0F, -1.0F, 0.0F, 5, 5, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel[0].func_78793_a(2.0F, 2.0F, -1.0F);
    this.pumpModel = new ModelRendererTurbo[3];
    this.pumpModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 73, this.textureX, this.textureY);
    this.pumpModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 78, this.textureX, this.textureY);
    this.pumpModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 83, this.textureX, this.textureY);
    this.pumpModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F);
    this.pumpModel[0].func_78793_a(2.0F, -0.8F, -0.5F);
    this.pumpModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.pumpModel[1].func_78793_a(6.0F, -0.8F, -1.5F);
    this.pumpModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.pumpModel[2].func_78793_a(6.0F, -0.8F, -2.5F);
    this.barrelAttachPoint = new Vector3f(1.8125F, 0.375F, 0.0F);
    this.gunSlideDistance = 0.5F;
    this.pumpDelayAfterReload = 65;
    this.pumpDelay = 6;
    this.pumpTime = 9;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
    flipAll();
    translateAll(2.0F, 7.0F, 0.0F);
  }
}
