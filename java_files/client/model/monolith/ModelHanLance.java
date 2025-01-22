package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelHanLance extends ModelGun {
  int textureX = 128;
  
  int textureY = 32;
  
  public ModelHanLance() {
    this.gunModel = new ModelRendererTurbo[7];
    initgunModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initgunModel_1() {
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(-17.0F, 0.0F, -2.0F, 54, 1, 1, 0.0F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F);
    this.gunModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel[1].addShapeBox(-0.5F, -0.5F, -0.65F, 1, 1, 1, 0.0F, 0.0F, -0.25F, 0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.15F, -0.5F, 0.0F, -0.15F, -0.5F);
    this.gunModel[1].func_78793_a(40.2F, 0.5F, -1.65F);
    (this.gunModel[1]).field_78795_f = 3.1415927F;
    (this.gunModel[1]).field_78808_h = 1.5707964F;
    this.gunModel[2].addShapeBox(0.0F, 0.0F, -1.15F, 1, 4, 2, 0.0F, -0.45F, 0.5F, -0.4F, -0.45F, 0.5F, -0.4F, -0.45F, 0.5F, -0.4F, -0.45F, 0.5F, -0.4F, -0.45F, 5.5F, -0.3F, -0.45F, 5.5F, -0.3F, -0.45F, 5.5F, -0.3F, -0.45F, 5.5F, -0.3F);
    this.gunModel[2].func_78793_a(49.5F, 1.0F, -1.6F);
    (this.gunModel[2]).field_78795_f = 3.1415927F;
    (this.gunModel[2]).field_78796_g = 0.0F;
    (this.gunModel[2]).field_78808_h = 1.5707964F;
    this.gunModel[3].addShapeBox(0.0F, 0.0F, -1.15F, 1, 1, 2, 0.0F, -0.45F, 0.0F, -0.95F, -0.45F, 0.0F, -0.95F, -0.45F, 0.0F, -0.95F, -0.45F, 0.0F, -0.95F, -0.45F, 1.0F, -0.4F, -0.45F, 1.0F, -0.4F, -0.45F, 1.0F, -0.4F, -0.45F, 1.0F, -0.4F);
    this.gunModel[3].func_78793_a(52.0F, 1.0F, -1.6F);
    (this.gunModel[3]).field_78795_f = 3.1415927F;
    (this.gunModel[3]).field_78808_h = 1.5707964F;
    this.gunModel[4].addShapeBox(0.0F, 0.0F, -0.65F, 1, 3, 1, 0.0F, -0.1F, 0.2F, -0.1F, -0.1F, 0.2F, -0.1F, -0.1F, 0.2F, -0.1F, -0.1F, 0.2F, -0.1F, -0.1F, 0.5F, -0.1F, -0.1F, 0.5F, -0.1F, -0.1F, 0.5F, -0.1F, -0.1F, 0.5F, -0.1F);
    this.gunModel[4].func_78793_a(40.2F, 1.0F, -1.65F);
    (this.gunModel[4]).field_78795_f = 3.1415927F;
    (this.gunModel[4]).field_78808_h = 1.5707964F;
    this.gunModel[5].addShapeBox(-0.5F, -0.5F, -0.65F, 1, 1, 1, 0.0F, 0.0F, -0.1F, -0.5F, 0.0F, -0.1F, -0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.15F, -0.5F, 0.0F, -0.15F, -0.5F, 0.0F, -0.25F, 0.5F, 0.0F, -0.25F, 0.5F);
    this.gunModel[5].func_78793_a(40.2F, 0.5F, -1.65F);
    (this.gunModel[5]).field_78795_f = 3.1415927F;
    (this.gunModel[5]).field_78808_h = 1.5707964F;
    this.gunModel[6].addShapeBox(-17.0F, 0.0F, -2.0F, 4, 1, 1, 0.0F, 0.1F, -0.1F, -0.1F, 0.1F, -0.1F, -0.1F, 0.1F, -0.1F, -0.1F, 0.1F, -0.1F, -0.1F, 0.1F, -0.1F, -0.1F, 0.1F, -0.1F, -0.1F, 0.1F, -0.1F, -0.1F, 0.1F, -0.1F, -0.1F);
    this.gunModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
