package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRussiaNapoleonicGear extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 32;
  
  public ModelRussiaNapoleonicGear() {
    this.bodyModel = new ModelRendererTurbo[17];
    initbodyModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 113, 9, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 113, 9, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(2.0F, -0.5F, -3.0F, 3, 9, 6, 0.0F, -1.0F, 0.5F, 0.2F, 1.0F, -0.3F, 0.2F, 1.0F, -0.3F, 0.2F, -1.0F, 0.5F, 0.2F, 6.5F, -2.0F, 0.4F, -9.5F, 1.5F, 0.4F, -9.5F, 1.5F, 0.8F, 6.5F, -2.0F, 0.8F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(3.0F, -1.5F, -3.0F, 3, 1, 6, 0.0F, -1.0F, -0.3F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.3F, 0.0F, 0.0F, -0.5F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, -0.5F, 0.2F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-5.5F, 6.5F, -3.0F, 1, 3, 6, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.8F, 0.0F, -2.0F, 0.2F, -0.5F, 0.3F, 0.0F, 0.0F, 0.5F, 0.4F, 0.0F, 0.5F, 0.8F, -0.5F, 0.3F, 0.2F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(4.0F, 11.0F, 1.5F, 1, 2, 7, 0.0F, -0.3F, -0.2F, 0.0F, 0.3F, -0.2F, 0.0F, -1.7F, -6.4F, 0.0F, 1.7F, -6.4F, -0.2F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -2.0F, 5.0F, -1.0F, 2.0F, 5.0F, -1.2F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 2.0F, 3.0F, 8, 6, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 1.5F, 5.5F, 8, 6, 1, 0.0F, -0.2F, 0.2F, 2.0F, -0.2F, 0.2F, 2.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -1.0F, -1.0F, 2.0F, -1.0F, -1.0F, 2.0F, -1.0F, -1.0F, -0.5F, -1.0F, -1.0F, -0.5F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-1.5F, 2.0F, 6.5F, 3, 3, 1, 0.0F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.3F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-0.5F, 1.0F, 6.5F, 1, 1, 1, 0.0F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-5.0F, 10.5F, 3.0F, 5, 3, 2, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.4F, -0.2F, 0.0F, 0.0F, -0.2F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.0F, 0.0F, -0.4F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-5.0F, 10.5F, 4.2F, 5, 3, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.4F, -0.2F, 0.0F, -0.6F, -0.2F, 0.0F, -0.4F, -0.2F, -0.4F, -0.2F, -0.4F, 0.0F, -0.4F, -0.4F, 0.0F, -0.6F, -0.4F, 0.0F, -0.4F, -0.4F, -0.4F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-4.0F, 3.5F, -3.0F, 4, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-5.0F, -0.35F, -2.5F, 1, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.3F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-5.0F, 3.65F, -2.5F, 1, 4, 5, 0.0F, -1.0F, 0.0F, 0.3F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-1.0F, 3.5F, -3.95F, 2, 1, 1, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F, -0.3F, -0.1F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(4.0F, -0.35F, -2.5F, 1, 4, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.3F, -1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(4.0F, 3.65F, -2.5F, 1, 4, 5, 0.0F, 1.0F, 0.0F, 0.5F, -1.0F, 0.0F, 0.3F, -1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(0.0F, 3.5F, -3.0F, 4, 1, 1, 0.0F, -1.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.9F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
