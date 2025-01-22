package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelPanzerfaust3 extends ModelGun {
  int textureX = 256;
  
  int textureY = 16;
  
  public ModelPanzerfaust3() {
    this.gunModel = new ModelRendererTurbo[13];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F);
    this.gunModel[0].func_78793_a(-1.0F, -3.23F, -0.5F);
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.gunModel[1].func_78793_a(-2.0F, -4.5F, -0.5F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 17, 2, 2, 0.0F);
    this.gunModel[2].func_78793_a(-18.0F, -6.0F, -1.0F);
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 6, 3, 3, 0.0F);
    this.gunModel[3].func_78793_a(-12.0F, -6.5F, -1.5F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 2, 3, 3, 0.0F);
    this.gunModel[4].func_78793_a(-1.0F, -6.5F, -1.5F);
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(-2.0F, -6.0F, 2.3F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
    this.gunModel[6].func_78793_a(-1.0F, -6.0F, 0.3F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F);
    this.gunModel[7].func_78793_a(-19.0F, -6.5F, -1.5F);
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
    this.gunModel[8].func_78793_a(-13.0F, -4.0F, 0.0F);
    this.gunModel[9].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[9].func_78793_a(-13.0F, -2.0F, 0.0F);
    this.gunModel[10].func_78790_a(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
    this.gunModel[10].func_78793_a(-2.0F, -7.0F, 1.3F);
    this.gunModel[11].func_78790_a(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
    this.gunModel[11].func_78793_a(-2.0F, -8.0F, 2.3F);
    this.gunModel[12].func_78790_a(0.0F, 0.0F, 0.0F, 4, 1, 1, 0.0F);
    this.gunModel[12].func_78793_a(-2.0F, -7.0F, 3.3F);
    this.ammoModel = new ModelRendererTurbo[2];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 129, 1, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 153, 1, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, -5.5F, -0.5F);
    this.ammoModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
    this.ammoModel[1].func_78793_a(2.0F, -6.0F, -1.0F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.NONE;
    flipAll();
    translateAll(0.0F, 0.0F, 3.0F);
    this.thirdPersonOffset = new Vector3f(0.0F, -0.05F, -0.2F);
    this.itemFrameOffset = new Vector3f(0.5F, 0.0F, 0.0F);
  }
}
