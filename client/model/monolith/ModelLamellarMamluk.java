package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelLamellarMamluk extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelLamellarMamluk() {
    this.bodyModel = new ModelRendererTurbo[6];
    this.leftArmModel = new ModelRendererTurbo[2];
    this.rightArmModel = new ModelRendererTurbo[2];
    this.leftLegModel = new ModelRendererTurbo[1];
    this.rightLegModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-10.0F, 4.0F, -2.5F, 20, 10, 5, 0.0F, -4.9F, 0.0F, 0.4F, -4.9F, 0.0F, 0.4F, -4.9F, 0.0F, 0.2F, -4.9F, 0.0F, 0.2F, -5.2F, -5.0F, 0.2F, -5.2F, -5.0F, 0.2F, -5.2F, -5.0F, 0.2F, -5.2F, -5.0F, 0.2F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 8.8F, -2.0F, 8, 2, 4, 0.0F, 0.75F, 0.0F, 1.0F, 1.2F, 1.0F, 1.0F, 1.2F, 1.0F, 1.0F, 0.75F, 0.0F, 1.0F, 1.0F, 0.5F, 1.0F, 0.75F, 0.0F, 1.0F, 0.75F, 0.0F, 1.0F, 1.0F, 0.5F, 1.0F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 8.5F, -2.0F, 8, 2, 4, 0.0F, 1.2F, 0.5F, 1.2F, 0.8F, 0.0F, 1.2F, 0.8F, 0.0F, 1.2F, 1.2F, 0.5F, 1.2F, 1.0F, 0.0F, 1.2F, 1.2F, 0.5F, 1.2F, 1.2F, 0.5F, 1.2F, 1.0F, 0.0F, 1.2F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-10.0F, -3.0F, -2.5F, 20, 7, 5, 0.0F, -5.5F, -4.0F, 0.2F, -5.5F, -4.0F, 0.2F, -5.5F, -4.0F, 0.2F, -5.5F, -4.0F, 0.2F, -4.9F, 0.0F, 0.4F, -4.9F, 0.0F, 0.4F, -4.9F, 0.0F, 0.2F, -4.9F, 0.0F, 0.2F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-3.0F, -0.3F, -2.0F, 1, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.0F, 0.6F, 0.2F, 0.0F, 0.6F, 0.2F, 0.0F, 0.6F, 0.2F, 0.0F, 0.6F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(2.0F, -0.3F, -2.0F, 1, 2, 4, 0.0F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.2F, 0.0F, 0.6F, 0.2F, 0.0F, 0.6F, 0.2F, 0.0F, 0.6F, 0.2F, 0.0F, 0.6F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 44, 37, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 34, 52, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(3.0F, -2.3F, -4.5F, 1, 5, 9, 0.0F, 0.4F, 0.1F, -1.9F, -0.4F, 0.2F, -1.9F, -0.4F, 0.2F, -1.9F, 0.4F, 0.1F, -1.9F, 0.1F, 0.4F, -1.0F, 0.0F, 0.4F, -1.0F, 0.0F, 0.4F, -1.0F, 0.1F, 0.4F, -1.0F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(3.0F, 3.4F, -4.0F, 1, 3, 8, 0.0F, 0.1F, 0.4F, -1.2F, 0.0F, 0.4F, -1.2F, 0.0F, 0.4F, -1.2F, 0.1F, 0.4F, -1.2F, -0.1F, 0.1F, -1.9F, 0.2F, 0.2F, -1.9F, 0.2F, 0.2F, -1.9F, -0.1F, 0.1F, -1.9F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 44, 37, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 34, 52, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-4.0F, -2.3F, -4.5F, 1, 5, 9, 0.0F, -0.4F, 0.2F, -1.9F, 0.4F, 0.1F, -1.9F, 0.4F, 0.1F, -1.9F, -0.4F, 0.2F, -1.9F, 0.0F, 0.4F, -1.0F, 0.1F, 0.4F, -1.0F, 0.1F, 0.4F, -1.0F, 0.0F, 0.4F, -1.0F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-4.0F, 3.4F, -4.0F, 1, 3, 8, 0.0F, 0.0F, 0.4F, -1.2F, 0.1F, 0.4F, -1.2F, 0.1F, 0.4F, -1.2F, 0.0F, 0.4F, -1.2F, 0.2F, 0.2F, -1.9F, -0.1F, 0.1F, -1.9F, -0.1F, 0.1F, -1.9F, 0.2F, 0.2F, -1.9F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-1.0F, -1.5F, -2.0F, 8, 14, 8, 0.0F, 0.5F, 0.0F, 0.7F, -4.3F, 0.0F, 0.7F, -4.3F, 0.0F, -3.3F, 0.5F, 0.0F, -3.3F, -0.3F, -6.5F, 1.8F, -2.8F, -6.8F, 1.3F, -2.8F, -6.8F, -2.7F, -0.3F, -6.5F, -2.2F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-7.0F, -1.5F, -2.0F, 8, 14, 8, 0.0F, -4.3F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, -3.3F, -4.3F, 0.0F, -3.3F, -2.8F, -6.8F, 1.3F, -0.3F, -6.5F, 1.8F, -0.3F, -6.5F, -2.2F, -2.8F, -6.8F, -2.7F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
