package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRusWW1Body extends ModelCustomArmour {
  int textureX = 512;
  
  int textureY = 32;
  
  public ModelRusWW1Body() {
    this.bodyModel = new ModelRendererTurbo[12];
    this.leftArmModel = new ModelRendererTurbo[2];
    this.rightArmModel = new ModelRendererTurbo[2];
    this.leftLegModel = new ModelRendererTurbo[3];
    this.rightLegModel = new ModelRendererTurbo[3];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 145, 1, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 153, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 353, 1, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 8.0F, 1.0F, 8, 1, 1, 0.0F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 8.0F, -2.0F, 3, 1, 1, 0.0F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(1.0F, 8.0F, -2.0F, 3, 1, 1, 0.0F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-0.4F, 8.0F, -2.0F, 1, 1, 1, 0.0F, 0.325F, 0.0F, 0.4F, 0.325F, 0.0F, 0.4F, 0.325F, 0.0F, 0.4F, 0.325F, 0.0F, 0.4F, 0.325F, 0.0F, 0.4F, 0.325F, 0.0F, 0.4F, 0.325F, 0.0F, 0.4F, 0.325F, 0.0F, 0.4F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 8, 4, 0.0F, -7.3F, 0.7F, 0.65F, 2.2F, 0.25F, 0.65F, 2.2F, 0.25F, 0.65F, -7.3F, 0.7F, 0.65F, 0.7F, -3.2F, 0.65F, -8.45F, 0.5F, 0.65F, -8.8F, 0.5F, 0.65F, 0.7F, -3.2F, 0.65F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(3.0F, 9.0F, -2.0F, 3, 3, 4, 0.0F, -0.05F, 0.0F, 0.45F, -1.15F, 0.0F, 0.45F, -1.15F, 0.0F, 0.45F, -0.35F, 0.0F, 0.45F, -1.0F, 1.0F, 0.45F, 0.0F, 0.0F, 0.45F, 0.0F, 0.0F, 0.45F, -1.0F, 1.0F, 0.45F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-3.5F, 8.0F, -3.0F, 2, 2, 1, 0.0F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F, 0.325F, 0.0F, 0.325F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-3.5F, 8.0F, 2.0F, 2, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-3.0F, 7.2F, 2.3F, 1, 1, 1, 0.0F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F, -0.25F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-0.5F, 0.0F, -2.0F, 1, 5, 1, 0.0F, 0.2F, 0.0F, 0.325F, 0.2F, 0.0F, 0.325F, 0.2F, 0.0F, 0.325F, 0.2F, 0.0F, 0.325F, 0.2F, 0.0F, 0.325F, 0.2F, 0.0F, 0.325F, 0.2F, 0.0F, 0.325F, 0.2F, 0.0F, 0.325F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-4.0F, 9.5F, -2.0F, 8, 4, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 161, 1, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 177, 1, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-0.8F, -2.0F, -2.0F, 4, 10, 4, 0.0F, 0.125F, 0.1F, 0.125F, 0.125F, 0.1F, 0.125F, 0.125F, 0.1F, 0.125F, 0.125F, 0.1F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-0.8F, -2.1F, -0.5F, 4, 1, 1, 0.0F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, -0.8F, 0.125F, 0.125F, -0.8F, 0.125F, 0.125F, -0.8F, 0.125F, 0.125F, -0.8F, 0.125F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 185, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 201, 1, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 10, 4, 0.0F, 0.125F, 0.1F, 0.125F, 0.125F, 0.1F, 0.125F, 0.125F, 0.1F, 0.125F, 0.125F, 0.1F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, -2.1F, -0.5F, 4, 1, 1, 0.0F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, 0.125F, -0.8F, 0.125F, 0.125F, -0.8F, 0.125F, 0.125F, -0.8F, 0.125F, 0.125F, -0.8F, 0.125F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 209, 1, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 233, 1, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 257, 1, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 10.0F, -3.0F, 4, 2, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 281, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 305, 1, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 329, 1, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 6, 4, 0.0F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F, 0.125F, 0.0F, 0.125F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 6.0F, -2.0F, 4, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 10.0F, -3.0F, 4, 2, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
