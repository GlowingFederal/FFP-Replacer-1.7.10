package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelAUG extends ModelGun {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelAUG() {
    this.gunModel = new ModelRendererTurbo[11];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 7, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 13, 2, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 21, 7, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 8, 12, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 24, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 18, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 27, 4, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 23, 13, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 0, 22, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 5, 22, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(-6.0F, -3.25F, -3.25F, 8, 2, 2, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.gunModel[0]).field_78795_f = -0.7853982F;
    this.gunModel[1].addShapeBox(-7.0F, -3.0F, -1.0F, 4, 4, 2, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.5F, 0.0F, 0.0F, -2.5F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[2].addShapeBox(-3.0F, -3.5F, -1.0F, 4, 2, 2, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, -1.3F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[3].addShapeBox(-0.4F, -3.0F, -0.5F, 2, 4, 1, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.gunModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.gunModel[3]).field_78808_h = -0.13962634F;
    this.gunModel[4].addShapeBox(2.0F, -3.0F, -3.0F, 5, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F);
    this.gunModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.gunModel[4]).field_78795_f = -0.7853982F;
    this.gunModel[5].addShapeBox(7.0F, -3.4F, -0.5F, 2, 1, 1, 0.0F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F);
    this.gunModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[6].func_78790_a(-1.5F, -5.0F, -0.5F, 8, 2, 1, 0.0F);
    this.gunModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[7].addShapeBox(6.5F, -5.0F, -0.5F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[8].func_78790_a(4.5F, -2.6F, -0.5F, 3, 1, 1, 0.0F);
    this.gunModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[9].addShapeBox(-2.5F, -5.0F, -0.5F, 1, 1, 1, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[10].addShapeBox(-7.0F, -3.25F, -3.25F, 1, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.gunModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.gunModel[10]).field_78795_f = -0.7853982F;
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 12, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(-4.0F, -2.7F, -0.5F, 2, 4, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    (this.ammoModel[0]).field_78808_h = 0.15707964F;
    this.slideModel = new ModelRendererTurbo[2];
    this.slideModel[0] = new ModelRendererTurbo((ModelBase)this, 19, 17, this.textureX, this.textureY);
    this.slideModel[1] = new ModelRendererTurbo((ModelBase)this, 19, 17, this.textureX, this.textureY);
    this.slideModel[0].addShapeBox(3.0F, -4.1F, 0.4F, 1, 1, 1, 0.0F, -0.5F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -0.5F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F);
    this.slideModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.slideModel[1].addShapeBox(3.0F, -4.1F, -1.4F, 1, 1, 1, 0.0F, -0.5F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, -0.5F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F);
    this.slideModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.barrelAttachPoint = new Vector3f(0.5625F, 0.171875F, 0.0F);
    this.stockAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.25F, 0.3125F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.ALT_PISTOL_CLIP;
    this.hasArms = true;
    this.leftArmPos = new Vector3f(0.0F, -0.2F, 0.0F);
    this.leftArmRot = new Vector3f(90.0F, 45.0F, 0.0F);
    this.leftArmReloadPos = new Vector3f(-0.6F, -0.5F, 0.0F);
    this.leftArmReloadRot = new Vector3f(90.0F, 20.0F, 0.0F);
    this.rightArmPos = new Vector3f(0.4F, -0.5F, 0.0F);
    this.rightArmRot = new Vector3f(0.0F, 0.0F, -90.0F);
    this.rightArmReloadPos = new Vector3f(0.4F, -0.6F, 0.0F);
    this.rightArmReloadRot = new Vector3f(-40.0F, 0.0F, -90.0F);
    this.rightHandAmmo = false;
    this.leftHandAmmo = true;
    translateAll(1.0F, 0.0F, 0.0F);
    flipAll();
  }
}
