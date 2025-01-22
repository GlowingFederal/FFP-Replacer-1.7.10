package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelColt extends ModelGun {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelColt() {
    this.gunModel = new ModelRendererTurbo[15];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 98, 10, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 113, 9, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 65, 17, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 115, 27, this.textureX, this.textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 57, 33, this.textureX, this.textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 6, 12, 5, 0.0F);
    this.gunModel[0].func_78793_a(-2.0F, -12.0F, -2.5F);
    (this.gunModel[0]).field_78808_h = -0.2617994F;
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 5, 11, 1, 0.0F);
    this.gunModel[1].func_78793_a(-1.5F, -11.5F, 2.0F);
    (this.gunModel[1]).field_78808_h = -0.2617994F;
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 5, 11, 1, 0.0F);
    this.gunModel[2].func_78793_a(-1.5F, -11.5F, -3.0F);
    (this.gunModel[2]).field_78808_h = -0.2617994F;
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 13, 2, 5, 0.0F);
    this.gunModel[3].func_78793_a(-2.5F, -12.0F, -2.5F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 7, 2, 5, 0.0F);
    this.gunModel[4].func_78793_a(10.5F, -12.5F, -2.5F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 1, 4, 4, 0.0F);
    this.gunModel[5].func_78793_a(3.5F, -11.0F, -2.0F);
    (this.gunModel[5]).field_78808_h = -0.2617994F;
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 1, 4, 3, 0.0F);
    this.gunModel[6].func_78793_a(9.5F, -11.0F, -1.5F);
    (this.gunModel[6]).field_78808_h = -0.2443461F;
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 1, 6, 3, 0.0F);
    this.gunModel[7].func_78793_a(3.4F, -7.0F, -1.5F);
    (this.gunModel[7]).field_78808_h = 1.553343F;
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 3, 3, 4, 0.0F);
    this.gunModel[8].func_78793_a(-5.0F, -11.0F, -2.0F);
    (this.gunModel[8]).field_78808_h = 0.7853982F;
    this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 21, 2, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[9].func_78793_a(-3.0F, -13.5F, -3.0F);
    this.gunModel[10].func_78790_a(0.0F, 0.0F, 0.0F, 24, 2, 2, 0.0F);
    this.gunModel[10].func_78793_a(-0.5F, -16.0F, -1.0F);
    this.gunModel[11].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
    this.gunModel[11].func_78793_a(23.5F, -16.0F, -1.0F);
    this.gunModel[12].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.gunModel[12].func_78793_a(5.5F, -10.5F, -0.5F);
    this.gunModel[13].func_78790_a(0.0F, 0.0F, 0.0F, 5, 3, 3, 0.0F);
    this.gunModel[13].func_78793_a(4.0F, -16.25F, -2.0F);
    this.gunModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F);
    this.gunModel[14].func_78793_a(24.2F, -13.5F, 1.0F);
    (this.gunModel[14]).field_78796_g = -3.1415927F;
    this.ammoModel = new ModelRendererTurbo[2];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 4, 10, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.ammoModel[0].func_78793_a(-1.0F, -10.0F, -1.5F);
    (this.ammoModel[0]).field_78808_h = -0.17453294F;
    this.ammoModel[1].func_78790_a(-4.5F, -8.9F, -1.5F, 5, 10, 3, 0.0F);
    this.ammoModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[1]).field_78808_h = -0.2617994F;
    this.slideModel = new ModelRendererTurbo[9];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.slideModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.slideModel[2] = new ModelRendererTurbo((ModelBase)this, 105, 17, this.textureX, this.textureY);
    this.slideModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.slideModel[4] = new ModelRendererTurbo((ModelBase)this, 97, 25, this.textureX, this.textureY);
    this.slideModel[5] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.slideModel[6] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.slideModel[7] = new ModelRendererTurbo((ModelBase)this, 97, 41, this.textureX, this.textureY);
    this.slideModel[8] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.slideModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 7, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.slideModel[0].func_78793_a(17.0F, -13.5F, -2.5F);
    this.slideModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 15, 1, 5, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.slideModel[1].func_78793_a(9.0F, -16.5F, -2.5F);
    this.slideModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 6, 2, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.slideModel[2].func_78793_a(18.0F, -15.5F, -2.5F);
    this.slideModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 21, 2, 5, 0.0F);
    this.slideModel[3].func_78793_a(-3.0F, -15.5F, -2.5F);
    this.slideModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 3, 1, 2, 0.0F);
    this.slideModel[4].func_78793_a(-5.0F, -16.5F, -1.0F);
    (this.slideModel[4]).field_78808_h = -0.34906584F;
    this.slideModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.slideModel[5].func_78793_a(-2.0F, -17.0F, -1.5F);
    this.slideModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 7, 1, 5, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.slideModel[6].func_78793_a(-3.0F, -16.5F, -2.5F);
    this.slideModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F);
    this.slideModel[7].func_78793_a(4.0F, -16.5F, -1.5F);
    this.slideModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.slideModel[8].func_78793_a(22.0F, -17.5F, -1.0F);
    this.gunSlideDistance = 1.5F;
    translateAll(0.0F, -10.0F, 0.3F);
    this.thirdPersonOffset = new Vector3f(-0.06F, -0.13F, 0.01F);
    this.animationType = EnumAnimationType.PISTOL_CLIP;
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
}
