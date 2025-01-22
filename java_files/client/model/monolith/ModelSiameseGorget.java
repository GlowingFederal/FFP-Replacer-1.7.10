package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSiameseGorget extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelSiameseGorget() {
    this.bodyModel = new ModelRendererTurbo[10];
    this.leftArmModel = new ModelRendererTurbo[1];
    this.rightArmModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-2.0F, 6.0F, -3.5F, 4, 2, 1, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -1.8F, 0.0F, -0.5F, -1.8F, 0.0F, -0.5F, -1.8F, 0.0F, 0.5F, -1.8F, 0.0F, 0.5F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-3.5F, 3.5F, -3.5F, 7, 2, 1, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-6.0F, 1.0F, -3.5F, 12, 2, 1, 0.0F, 0.5F, -0.5F, -0.2F, 0.5F, -0.5F, -0.2F, 0.5F, -0.5F, 0.2F, 0.5F, -0.5F, 0.2F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-6.0F, -1.0F, -3.3F, 3, 2, 3, 0.0F, 1.5F, -0.5F, -0.5F, 0.0F, -0.8F, -0.5F, -0.5F, 0.0F, 0.3F, 2.0F, 0.5F, 0.3F, 0.5F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(3.0F, -1.0F, -3.3F, 3, 2, 3, 0.0F, 0.0F, -0.8F, -0.5F, 1.5F, -0.5F, -0.5F, 2.0F, 0.5F, 0.3F, -0.5F, 0.0F, 0.3F, 2.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.3F, 1.0F, 0.5F, 0.3F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-6.0F, 1.0F, 2.5F, 12, 2, 1, 0.0F, 0.5F, -0.5F, 0.2F, 0.5F, -0.5F, 0.2F, 0.5F, -0.5F, -0.2F, 0.5F, -0.5F, -0.2F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-6.0F, -1.0F, 0.3F, 3, 2, 3, 0.0F, 2.0F, 0.5F, 0.3F, -0.5F, 0.0F, 0.3F, 0.0F, -0.8F, -0.5F, 1.5F, -0.5F, -0.5F, 0.5F, 0.5F, 0.3F, 1.0F, 0.5F, 0.3F, 2.0F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(3.0F, -1.0F, 0.3F, 3, 2, 3, 0.0F, -0.5F, 0.0F, 0.3F, 2.0F, 0.5F, 0.3F, 1.5F, -0.5F, -0.5F, 0.0F, -0.8F, -0.5F, 1.0F, 0.5F, 0.3F, 0.5F, 0.5F, 0.3F, 0.5F, 0.5F, 0.0F, 2.0F, 0.5F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-3.5F, 3.5F, 2.5F, 7, 2, 1, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 1.5F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-2.0F, 6.0F, 2.5F, 4, 2, 1, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, -1.8F, 0.0F, 0.5F, -1.8F, 0.0F, 0.5F, -1.8F, 0.0F, -0.5F, -1.8F, 0.0F, -0.5F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, 3.5F, -2.0F, 4, 5, 4, 0.0F, 0.8F, 0.0F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.0F, 0.8F, 0.3F, -0.2F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, -0.2F, 0.3F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, 3.5F, -2.0F, 4, 5, 4, 0.0F, 0.8F, 0.5F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.5F, 0.8F, 0.3F, 0.0F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
