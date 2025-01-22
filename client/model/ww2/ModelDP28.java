package com.flansmod.client.model.ww2;

import com.flansmod.client.model.ModelMG;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelDP28 extends ModelMG {
  public ModelDP28() {
    this.bipodModel = new ModelRendererTurbo[2];
    this.bipodModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0);
    this.bipodModel[0].addBox(0.0F, 0.0F, 0.0F, 1, 8, 1);
    (this.bipodModel[0]).field_78808_h = 0.7853982F;
    this.bipodModel[0].func_78793_a(5.66F, 0.0F, 0.0F);
    this.bipodModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 0);
    this.bipodModel[1].addBox(-1.0F, 0.0F, 0.0F, 1, 8, 1);
    (this.bipodModel[1]).field_78808_h = -0.7853982F;
    this.bipodModel[1].func_78793_a(-5.66F, 0.0F, 0.0F);
    this.gunModel = new ModelRendererTurbo[3];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0);
    this.gunModel[0].addBox(-1.0F, -1.0F, -2.0F, 2, 2, 16);
    this.gunModel[0].func_78793_a(0.0F, 6.0F, 0.0F);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 4, 0);
    this.gunModel[1].addBox(-1.0F, -2.0F, 14.0F, 2, 3, 2);
    this.gunModel[1].func_78793_a(0.0F, 6.0F, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 18);
    this.gunModel[2].addBox(-0.5F, -0.5F, -8.0F, 1, 1, 6);
    this.gunModel[2].func_78793_a(0.0F, 6.0F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 20, 0);
    this.ammoModel[0].addBox(-3.0F, 1.0F, 1.0F, 6, 1, 6);
    this.ammoModel[0].func_78793_a(0.0F, 6.0F, 0.0F);
  }
}
