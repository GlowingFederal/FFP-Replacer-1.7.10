package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelAchaemenidHeadwrap extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelAchaemenidHeadwrap() {
    this.headModel = new ModelRendererTurbo[9];
    initheadModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 65, 17, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 89, 17, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 33, 25, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 57, 25, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.0F, -4.0F, 8, 3, 8, 0.0F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.2F, 0.3F, 0.3F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -10.3F, -4.0F, 8, 2, 8, 0.0F, -2.0F, -0.5F, -2.0F, -2.0F, -0.5F, -2.0F, -2.0F, -0.5F, -2.0F, -2.0F, -0.5F, -2.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -6.0F, -4.0F, 8, 2, 8, 0.0F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.5F, 0.9F, 0.9F, -0.2F, 0.9F, 0.9F, -0.2F, 0.9F, 0.9F, 0.2F, 0.9F, 0.9F, 0.2F, 0.9F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.5F, -5.0F, -4.5F, 9, 1, 9, 0.0F, 0.6F, 0.0F, 0.55F, 0.6F, 0.0F, 0.55F, 0.6F, -0.7F, 0.55F, 0.6F, -0.7F, 0.55F, 0.6F, -0.7F, 0.55F, 0.6F, -0.7F, 0.55F, 0.6F, 0.3F, 0.55F, 0.6F, 0.3F, 0.55F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -2.5F, -4.0F, 8, 2, 4, 0.0F, 0.5F, -1.5F, 0.5F, 0.5F, -1.5F, 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 1.0F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.0F, -3.2F, -4.0F, 8, 1, 4, 0.0F, 0.0F, -2.0F, 0.2F, 0.0F, -2.0F, 0.2F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F, 0.5F, 0.5F, 1.2F, 0.5F, 0.5F, 1.2F, 0.5F, 0.5F, -1.3F, 0.5F, 0.5F, -1.3F, 0.5F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.0F, 0.0F, -4.0F, 4, 1, 8, 0.0F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, -1.5F, -0.3F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -1.5F, -0.3F, 0.25F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(0.0F, 0.0F, -4.0F, 4, 1, 8, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, -1.5F, -0.3F, 0.0F, -1.5F, -0.3F, 0.25F, 0.0F, 0.0F, 0.0F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-4.0F, -2.5F, 1.0F, 8, 2, 3, 0.0F, 0.5F, 1.5F, 0.5F, 0.5F, 1.5F, 0.5F, 0.9F, 1.5F, 0.9F, 0.9F, 1.5F, 0.9F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
