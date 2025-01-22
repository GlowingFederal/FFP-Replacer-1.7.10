package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class Modelegyptheaddress extends ModelCustomArmour {
  int textureX = 1024;
  
  int textureY = 1024;
  
  public Modelegyptheaddress() {
    this.headModel = new ModelRendererTurbo[5];
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 185, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 225, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 265, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 289, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 313, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -7.0F, -4.0F, 8, 2, 8, 0.0F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.0F, 0.125F, 0.0F, 0.0F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].func_78790_a(-4.0F, -8.0F, -4.0F, 8, 2, 9, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].func_78790_a(-4.0F, -8.0F, 4.0F, 8, 8, 1, 0.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].func_78790_a(-5.0F, -7.5F, -3.0F, 1, 7, 7, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].func_78790_a(4.0F, -7.5F, -3.0F, 1, 7, 7, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
