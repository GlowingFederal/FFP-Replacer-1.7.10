package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelType38 extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelType38() {
    this.gunModel = new ModelRendererTurbo[18];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 220, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 230, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 240, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 250, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 260, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 80, 250, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 230, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 230, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 100, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 0, 112, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 0, 112, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 0, 120, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 0, 120, this.textureX, this.textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 0, 100, this.textureX, this.textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 0, 130, this.textureX, this.textureY);
    this.gunModel[15] = new ModelRendererTurbo((ModelBase)this, 30, 130, this.textureX, this.textureY);
    this.gunModel[16] = new ModelRendererTurbo((ModelBase)this, 50, 130, this.textureX, this.textureY);
    this.gunModel[17] = new ModelRendererTurbo((ModelBase)this, 50, 130, this.textureX, this.textureY);
    this.gunModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
    this.gunModel[0].func_78793_a(-2.5F, -1.7F, -1.0F);
    (this.gunModel[0]).field_78808_h = 0.3490658F;
    this.gunModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 12, 1, 2, 0.0F);
    this.gunModel[1].func_78793_a(1.0F, -3.0F, -1.0F);
    this.gunModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F);
    this.gunModel[2].func_78793_a(-3.5F, -2.0F, -1.0F);
    (this.gunModel[2]).field_78808_h = -0.1745329F;
    this.gunModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
    this.gunModel[3].func_78793_a(-11.0F, -2.0F, -1.0F);
    this.gunModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 8, 2, 2, 0.0F);
    this.gunModel[4].func_78793_a(-11.0F, -0.2F, -1.0F);
    (this.gunModel[4]).field_78808_h = 0.2094395F;
    this.gunModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F);
    this.gunModel[5].func_78793_a(2.5F, -1.0F, -0.5F);
    this.gunModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 4, 1, 2, 0.0F);
    this.gunModel[6].func_78793_a(1.0F, -2.0F, -1.0F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 8, 1, 2, 0.0F);
    this.gunModel[7].func_78793_a(4.7F, -2.0F, -1.0F);
    (this.gunModel[7]).field_78808_h = 0.122173F;
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
    this.gunModel[8].func_78793_a(13.0F, -4.0F, -1.0F);
    this.gunModel[9].func_78790_a(0.0F, 0.0F, 0.0F, 22, 1, 1, 0.0F);
    this.gunModel[9].func_78793_a(0.5F, -3.8F, -0.3F);
    this.gunModel[10].func_78790_a(0.0F, 0.0F, 0.0F, 22, 1, 1, 0.0F);
    this.gunModel[10].func_78793_a(0.5F, -3.8F, -0.7F);
    this.gunModel[11].func_78790_a(0.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F);
    this.gunModel[11].func_78793_a(13.5F, -3.1F, -0.2F);
    this.gunModel[12].func_78790_a(0.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F);
    this.gunModel[12].func_78793_a(13.5F, -3.1F, -0.8F);
    this.gunModel[13].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F);
    this.gunModel[13].func_78793_a(22.0F, -4.0F, -1.0F);
    this.gunModel[14].func_78790_a(0.0F, 0.0F, 0.0F, 7, 1, 1, 0.0F);
    this.gunModel[14].func_78793_a(22.0F, -3.7F, -0.5F);
    this.gunModel[15].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.gunModel[15].func_78793_a(3.0F, -3.7F, -1.5F);
    this.gunModel[16].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 0, 0.0F);
    this.gunModel[16].func_78793_a(26.0F, -4.5F, 0.5F);
    this.gunModel[17].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 0, 0.0F);
    this.gunModel[17].func_78793_a(26.0F, -4.5F, -0.5F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(3.0F, -3.5F, -0.5F, 3, 2, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.RIFLE;
    flipAll();
    translateAll(0.0F, 2.0F, 0.0F);
  }
}
