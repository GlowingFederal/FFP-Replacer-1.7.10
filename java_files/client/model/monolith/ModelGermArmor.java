package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelGermArmor extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelGermArmor() {
    this.bodyModel = new ModelRendererTurbo[5];
    this.leftLegModel = new ModelRendererTurbo[4];
    this.rightLegModel = new ModelRendererTurbo[4];
    initbodyModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 97, 25, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 73, 41, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 10.0F, -2.0F, 8, 5, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.5F, -0.2F, -2.5F, 9, 12, 5, 0.0F, 1.0F, 0.1F, -0.2F, 1.0F, 0.1F, -0.2F, 1.0F, 0.1F, -0.2F, 1.0F, 0.1F, -0.2F, 0.3F, 0.2F, -0.2F, 0.3F, 0.2F, -0.2F, 0.3F, 0.2F, -0.2F, 0.3F, 0.2F, -0.2F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.5F, -0.2F, -2.5F, 9, 12, 5, 0.0F, 1.3F, 0.4F, 0.1F, 1.3F, 0.4F, 0.1F, 1.3F, 0.4F, 0.1F, 1.3F, 0.4F, 0.1F, 0.6F, 0.5F, 0.1F, 0.6F, 0.5F, 0.1F, 0.6F, 0.5F, 0.1F, 0.6F, 0.5F, 0.1F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.5F, -0.2F, -2.5F, 9, 12, 5, 0.0F, 1.6F, 0.7F, 0.4F, 1.6F, 0.7F, 0.4F, 1.6F, 0.7F, 0.4F, 1.6F, 0.7F, 0.4F, 0.9F, 0.8F, 0.4F, 0.9F, 0.8F, 0.4F, 0.9F, 0.8F, 0.4F, 0.9F, 0.8F, 0.4F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.5F, -0.2F, -2.5F, 9, 12, 5, 0.0F, 2.2F, 1.2F, 0.8F, 2.2F, 1.2F, 0.8F, 2.2F, 1.2F, 0.8F, 2.2F, 1.2F, 0.8F, 1.5F, 1.2F, 0.8F, 1.5F, 1.2F, 0.8F, 1.5F, 1.2F, 0.8F, 1.5F, 1.2F, 0.8F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 17, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 1.0F, -2.0F, 4, 8, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 9.0F, -2.0F, 4, 1, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 9.4F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 9.4F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 1.0F, -2.0F, 4, 8, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 9.0F, -2.0F, 4, 1, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.7F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
