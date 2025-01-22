package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class Modelkoreanpeasantarmorhat extends ModelCustomArmour {
  int textureX = 512;
  
  int textureY = 512;
  
  public Modelkoreanpeasantarmorhat() {
    this.headModel = new ModelRendererTurbo[12];
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 401, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 425, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 465, 1, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -11.0F, -4.0F, 8, 3, 8, 0.0F, -0.9F, -0.6F, -1.5F, -0.9F, -0.6F, -1.5F, -0.9F, -0.7F, -1.25F, -0.9F, -0.7F, -1.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-6.0F, -8.0F, -6.0F, 12, 2, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.0F, 0.0F, -0.6F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -0.7F, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-0.5F, -12.1F, 0.5F, 1, 1, 3, 0.0F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-0.5F, -11.4F, -0.5F, 1, 1, 1, 0.0F, 0.3F, 0.5F, -0.7F, 0.3F, 0.5F, -0.7F, 0.3F, -0.3F, 1.3F, 0.3F, -0.3F, 1.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-7.0F, -8.0F, -6.0F, 1, 2, 12, 0.0F, -0.4F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, -1.5F, 0.0F, -0.6F, -1.5F, 0.0F, -0.6F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -0.7F, -1.5F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(6.0F, -8.0F, -6.0F, 1, 2, 12, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, -1.5F, -0.4F, 0.0F, -1.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, 0.0F, 0.0F, -0.6F, -1.5F, 0.0F, -0.7F, -1.5F, 0.0F, -0.7F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-6.0F, -8.0F, -7.0F, 12, 2, 1, 0.0F, -1.5F, 0.0F, -0.4F, -1.5F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, -0.6F, 0.0F, -1.5F, -0.7F, 0.0F, 0.0F, -0.7F, 0.0F, 0.0F, -0.6F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(-6.0F, -8.0F, 6.0F, 12, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.5F, 0.0F, -0.4F, -1.5F, 0.0F, -0.4F, 0.0F, -0.6F, 0.0F, 0.0F, -0.7F, 0.0F, -1.5F, -0.7F, 0.0F, -1.5F, -0.6F, 0.0F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-0.5F, -11.4F, 3.5F, 1, 1, 1, 0.0F, 0.3F, -0.3F, 1.3F, 0.3F, -0.3F, 1.3F, 0.3F, 0.7F, -1.0F, 0.3F, 0.7F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 369, 1, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 385, 1, this.textureX, this.textureY);
    this.headModel[9].addShapeBox(-4.0F, -7.5F, -4.0F, 8, 2, 8, 0.0F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-1.5F, -5.5F, 0.0F, 2, 5, 5, 0.0F, 0.0F, 0.0F, -0.55F, 0.0F, 0.0F, -0.55F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 1.0F, -0.6F, -0.55F, -1.0F, -0.2F, -0.55F, -1.0F, -0.2F, 0.25F, 1.0F, -0.6F, 0.25F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-0.5F, -5.5F, 0.0F, 2, 5, 5, 0.0F, 0.0F, 0.0F, -0.55F, 0.0F, 0.0F, -0.55F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, -1.0F, -0.2F, -0.55F, 1.0F, -0.6F, -0.55F, 1.0F, -0.6F, 0.25F, -1.0F, -0.2F, 0.25F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
