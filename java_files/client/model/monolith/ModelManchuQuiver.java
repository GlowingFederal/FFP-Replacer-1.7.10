package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelManchuQuiver extends ModelCustomArmour {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelManchuQuiver() {
    this.bodyModel = new ModelRendererTurbo[18];
    initbodyModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 10.0F, -2.5F, 8, 1, 5, 0.0F, 0.55F, -0.1F, 0.25F, 0.55F, -0.1F, 0.25F, 0.55F, -0.1F, 0.25F, 0.55F, -0.1F, 0.25F, 0.55F, -0.3F, 0.25F, 0.55F, -0.3F, 0.25F, 0.55F, -0.3F, 0.25F, 0.55F, -0.3F, 0.25F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-5.5F, 10.5F, -2.5F, 1, 5, 5, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, -0.4F, -1.0F, 0.5F, 2.5F, -1.5F, 0.2F, 0.0F, 1.0F, 2.0F, 1.0F, 0.4F, 1.7F, 1.0F, 2.3F, -2.0F, 0.7F, 3.0F, -2.3F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-12.0F, -2.5F, -0.2F, 1, 17, 1, 0.0F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, 8.75F, -0.25F, 0.0F, 8.75F, -5.25F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, -5.25F, 0.0F, -0.25F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-11.7F, -1.5F, 8.3F, 1, 7, 1, 0.0F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, -2.5F, 0.0F, 3.4F, 1.6F, 0.0F, 3.4F, 1.6F, 0.0F, -4.1F, -2.5F, 0.0F, -4.1F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-10.5F, -3.5F, -0.2F, 1, 17, 1, 0.0F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, 8.75F, -0.25F, 0.0F, 8.75F, -5.25F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, -5.25F, 0.0F, -0.25F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-10.2F, -2.5F, 8.3F, 1, 7, 1, 0.0F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, -2.5F, 0.0F, 3.4F, 1.6F, 0.0F, 3.4F, 1.6F, 0.0F, -4.1F, -2.5F, 0.0F, -4.1F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-10.0F, -3.5F, -3.2F, 1, 17, 1, 0.0F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, 8.75F, -0.25F, 0.0F, 8.75F, -5.25F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, -5.25F, 0.0F, -0.25F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-9.7F, -2.5F, 5.3F, 1, 7, 1, 0.0F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, -2.5F, 0.0F, 3.4F, 1.6F, 0.0F, 3.4F, 1.6F, 0.0F, -4.1F, -2.5F, 0.0F, -4.1F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-11.0F, -3.8F, -2.2F, 1, 17, 1, 0.0F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, 8.75F, -0.25F, 0.0F, 8.75F, -5.25F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, -5.25F, 0.0F, -0.25F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-10.7F, -2.8F, 6.3F, 1, 7, 1, 0.0F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, -2.5F, 0.0F, 3.4F, 1.6F, 0.0F, 3.4F, 1.6F, 0.0F, -4.1F, -2.5F, 0.0F, -4.1F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-11.5F, -4.0F, -0.2F, 1, 17, 1, 0.0F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, 8.75F, -0.25F, 0.0F, 8.75F, -5.25F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, -5.25F, 0.0F, -0.25F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-11.2F, -3.0F, 8.3F, 1, 7, 1, 0.0F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, -2.5F, 0.0F, 3.4F, 1.6F, 0.0F, 3.4F, 1.6F, 0.0F, -4.1F, -2.5F, 0.0F, -4.1F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-11.5F, -3.0F, -3.2F, 1, 17, 1, 0.0F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, 8.75F, -0.25F, 0.0F, 8.75F, -5.25F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, -5.25F, 0.0F, -0.25F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-11.2F, -2.0F, 5.3F, 1, 7, 1, 0.0F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, -2.5F, 0.0F, 3.4F, 1.6F, 0.0F, 3.4F, 1.6F, 0.0F, -4.1F, -2.5F, 0.0F, -4.1F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-11.8F, -3.5F, -1.2F, 1, 17, 1, 0.0F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, 8.75F, -0.25F, 0.0F, 8.75F, -5.25F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, -5.25F, 0.0F, -0.25F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-11.5F, -2.5F, 7.3F, 1, 7, 1, 0.0F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, -2.5F, 0.0F, 3.4F, 1.6F, 0.0F, 3.4F, 1.6F, 0.0F, -4.1F, -2.5F, 0.0F, -4.1F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-9.9F, -3.5F, -1.7F, 1, 17, 1, 0.0F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, -9.25F, -0.25F, 0.0F, 8.75F, -0.25F, 0.0F, 8.75F, -5.25F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, 4.75F, 0.0F, -0.25F, -5.25F, 0.0F, -0.25F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-9.6F, -2.5F, 6.8F, 1, 7, 1, 0.0F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, 0.5F, 0.0F, -0.3F, -2.5F, 0.0F, 3.4F, 1.6F, 0.0F, 3.4F, 1.6F, 0.0F, -4.1F, -2.5F, 0.0F, -4.1F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
