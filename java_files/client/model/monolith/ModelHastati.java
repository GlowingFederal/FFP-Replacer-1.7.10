package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelHastati extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 128;
  
  public ModelHastati() {
    this.bodyModel = new ModelRendererTurbo[16];
    this.leftArmModel = new ModelRendererTurbo[1];
    this.rightArmModel = new ModelRendererTurbo[1];
    this.leftLegModel = new ModelRendererTurbo[3];
    this.rightLegModel = new ModelRendererTurbo[1];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 9, 57, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 33, 57, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 9.5F, -2.0F, 8, 1, 4, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 11.3F, -2.0F, 8, 4, 4, 0.0F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.3F, 0.1F, 0.3F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F, 0.8F, 0.7F, 0.8F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 9, 4, 0.0F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 9.0F, -2.0F, 8, 1, 4, 0.0F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 10.3F, -2.0F, 8, 1, 4, 0.0F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F, 0.3F, 0.3F, -0.1F, 0.3F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-3.5F, 1.0F, -2.5F, 7, 6, 1, 0.0F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F, 0.35F, 0.0F, 0.35F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-3.0F, 6.5F, -2.5F, 6, 1, 5, 0.0F, 1.4F, -0.2F, 0.1F, 1.4F, -0.2F, 0.1F, 1.4F, -2.2F, 0.1F, 1.4F, -2.2F, 0.1F, 1.4F, -0.2F, 0.1F, 1.4F, -0.2F, 0.1F, 1.4F, 1.8F, 0.1F, 1.4F, 1.8F, 0.1F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-3.5F, -0.5F, -2.5F, 1, 2, 5, 0.0F, -0.2F, 0.0F, 0.35F, -0.2F, 0.0F, 0.35F, -0.2F, 0.0F, 0.35F, -0.2F, 0.0F, 0.35F, -0.2F, -0.5F, 0.35F, -0.2F, -0.5F, 0.35F, -0.2F, -1.5F, 0.35F, -0.2F, -1.5F, 0.35F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(2.5F, -0.5F, -2.5F, 1, 2, 5, 0.0F, -0.2F, 0.0F, 0.35F, -0.2F, 0.0F, 0.35F, -0.2F, 0.0F, 0.35F, -0.2F, 0.0F, 0.35F, -0.2F, -0.5F, 0.35F, -0.2F, -0.5F, 0.35F, -0.2F, -1.5F, 0.35F, -0.2F, -1.5F, 0.35F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-3.5F, -0.7F, 1.8F, 7, 1, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-2.9F, 1.0F, -3.5F, 3, 3, 1, 0.0F, 0.0F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F, 0.0F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.2F, -0.2F, 0.5F, -0.2F, -0.2F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-0.1F, 1.0F, -3.5F, 3, 3, 1, 0.0F, -0.5F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.5F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.5F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-0.1F, 3.5F, -3.5F, 3, 2, 1, 0.0F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-2.9F, 3.5F, -3.5F, 3, 2, 1, 0.0F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-0.1F, 5.0F, -3.5F, 3, 2, 1, 0.0F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-2.9F, 5.0F, -3.5F, 3, 2, 1, 0.0F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, -0.5F, -0.5F, -0.2F, -0.5F, -0.5F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 11.1F, -2.0F, 4, 1, 4, 0.0F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 5.0F, -2.0F, 2, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -2.8F, 0.1F, 0.0F, -2.8F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.8F, 0.1F, 0.0F, -0.8F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 7.0F, -2.0F, 2, 4, 4, 0.0F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -0.8F, 0.1F, 0.0F, -0.8F, 0.1F, 0.0F, 0.1F, 2.1F, 0.0F, 0.1F, 2.1F, 0.0F, -1.8F, 0.1F, 0.0F, -1.8F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 11.1F, -2.0F, 4, 1, 4, 0.0F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.4F, 0.1F, -0.5F, 0.1F, 0.1F, -0.5F, 0.1F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.4F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
