package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelGenericMailShirt extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 32;
  
  public ModelGenericMailShirt() {
    this.bodyModel = new ModelRendererTurbo[2];
    this.leftArmModel = new ModelRendererTurbo[1];
    this.rightArmModel = new ModelRendererTurbo[1];
    this.skirtFrontModel = new ModelRendererTurbo[1];
    this.skirtRearModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initskirtFrontModel_1();
    initskirtRearModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 8.5F, -2.0F, 8, 2, 4, 0.0F, 0.7F, 0.0F, 1.0F, 0.7F, 0.0F, 1.0F, 0.7F, 0.0F, 1.0F, 0.7F, 0.0F, 1.0F, 0.7F, 0.0F, 1.0F, 0.7F, 0.0F, 1.0F, 0.7F, 0.0F, 1.0F, 0.7F, 0.0F, 1.0F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.5F, -0.2F, -2.5F, 9, 10, 5, 0.0F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.4F, 0.2F, 0.4F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F, 0.0F, 0.2F, 0.1F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F, 0.3F, 0.4F, 0.3F, 0.3F, 0.25F, 0.3F, 0.3F, 0.25F, 0.3F, 0.3F, 0.4F, 0.3F, 0.5F, 2.0F, 0.5F, 0.5F, 2.0F, 0.5F, 0.5F, 2.0F, 0.5F, 0.5F, 2.0F, 0.5F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F, 0.3F, 0.25F, 0.3F, 0.3F, 0.4F, 0.3F, 0.3F, 0.4F, 0.3F, 0.3F, 0.25F, 0.3F, 0.5F, 2.0F, 0.5F, 0.5F, 2.0F, 0.5F, 0.5F, 2.0F, 0.5F, 0.5F, 2.0F, 0.5F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtFrontModel_1() {
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, -1.5F, -2.0F, 8, 6, 2, 0.0F, 0.4F, 2.0F, 0.4F, 0.4F, 2.0F, 0.4F, 0.4F, 2.0F, 0.4F, 0.4F, 2.0F, 0.4F, 0.9F, -3.5F, 0.9F, 0.9F, -3.5F, 0.9F, 0.9F, -3.5F, 0.9F, 0.9F, -3.5F, 0.9F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initskirtRearModel_1() {
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-4.0F, -1.5F, 0.0F, 8, 6, 2, 0.0F, 0.4F, 1.0F, 0.4F, 0.4F, 1.0F, 0.4F, 0.4F, 1.0F, 0.4F, 0.4F, 1.0F, 0.4F, 0.9F, -3.5F, 0.9F, 0.9F, -3.5F, 0.9F, 0.9F, -3.5F, 0.9F, 0.9F, -3.5F, 0.9F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
