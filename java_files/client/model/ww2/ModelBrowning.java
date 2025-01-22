package com.flansmod.client.model.ww2;

import com.flansmod.client.model.ModelMG;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelBrowning extends ModelMG {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelBrowning() {
    this.bipodModel = new ModelRendererTurbo[3];
    this.bipodModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bipodModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.bipodModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bipodModel[0].addShapeBox(-0.5F, -4.0F, -2.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 6.0F, 6.0F, 0.0F, 6.0F, 6.0F, 0.0F, -6.0F, -6.0F, 0.0F, -6.0F);
    this.bipodModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bipodModel[1].addShapeBox(-0.5F, -4.0F, -2.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 6.0F, 0.0F, 6.0F, -6.0F, 0.0F, 6.0F, -6.0F, 0.0F, -6.0F, 6.0F, 0.0F, -6.0F);
    this.bipodModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bipodModel[2].addShapeBox(-0.5F, -4.0F, -2.0F, 1, 4, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 4.0F);
    this.bipodModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.gunModel = new ModelRendererTurbo[11];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(-1.0F, -3.3F, -6.25F, 2, 2, 7, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -4.0F, -1.5F);
    this.gunModel[1].addShapeBox(-1.5F, -1.8F, -0.45F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.gunModel[1].func_78793_a(0.0F, -4.0F, -1.5F);
    this.gunModel[2].addShapeBox(-0.5F, -2.8F, 0.25F, 1, 1, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2].func_78793_a(0.0F, -4.0F, -1.5F);
    this.gunModel[3].addShapeBox(-0.5F, -2.8F, 0.75F, 1, 1, 10, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F);
    this.gunModel[3].func_78793_a(0.0F, -4.0F, -1.5F);
    this.gunModel[4].addShapeBox(-0.5F, -2.3F, -7.75F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[4].func_78793_a(0.0F, -4.0F, -1.5F);
    this.gunModel[5].addShapeBox(-0.5F, -2.3F, -7.75F, 1, 3, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 1.0F, -0.2F, -0.2F, 1.0F, -0.2F, -0.2F, -1.0F, -0.2F, -0.2F, -1.0F);
    this.gunModel[5].func_78793_a(0.0F, -4.0F, -1.5F);
    this.gunModel[6].addShapeBox(-0.5F, -4.0F, -0.35F, 1, 1, 1, 0.0F, 0.0F, 0.0F, -0.9F, 0.0F, 0.0F, -0.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.9F, 0.0F, 0.0F, -0.9F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[6].func_78793_a(0.0F, -4.0F, -1.5F);
    this.gunModel[7].addShapeBox(-0.5F, -3.3F, -5.75F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[7].func_78793_a(0.0F, -4.5F, -1.5F);
    this.gunModel[8].addShapeBox(-0.5F, -3.3F, -5.75F, 1, 1, 1, 0.0F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F, -0.2F, -0.2F, -0.4F);
    this.gunModel[8].func_78793_a(0.0F, -5.2F, -1.5F);
    this.gunModel[9].addShapeBox(0.5F, -1.8F, -0.45F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.gunModel[9].func_78793_a(0.0F, -4.0F, -1.5F);
    this.gunModel[10].addShapeBox(-0.5F, -0.5F, -0.45F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.gunModel[10].func_78793_a(0.0F, -4.0F, -1.5F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.ammoModel[0].addShapeBox(-4.0F, -2.7F, -4.75F, 3, 2, 4, 0.0F, 0.5F, 0.0F, -0.6F, 0.0F, 0.0F, -0.6F, 0.0F, 0.0F, -0.6F, 0.5F, 0.0F, -0.6F, 0.5F, 0.5F, -0.6F, 0.0F, 0.5F, -0.6F, 0.0F, 0.5F, -0.6F, 0.5F, 0.5F, -0.6F);
    this.ammoModel[0].func_78793_a(0.0F, -4.0F, -1.5F);
    flipAll();
  }
}
