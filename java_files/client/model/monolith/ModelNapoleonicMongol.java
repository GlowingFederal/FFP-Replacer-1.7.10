package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelNapoleonicMongol extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 128;
  
  public ModelNapoleonicMongol() {
    this.bodyModel = new ModelRendererTurbo[12];
    this.leftArmModel = new ModelRendererTurbo[3];
    this.rightArmModel = new ModelRendererTurbo[3];
    this.leftLegModel = new ModelRendererTurbo[5];
    this.rightLegModel = new ModelRendererTurbo[5];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 33, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 41, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 73, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 41, 9, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 17, 17, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, -0.2F, -2.0F, 4, 8, 4, 0.0F, 0.7F, 0.1F, 0.4F, 0.0F, 0.15F, 0.45F, 0.0F, 0.15F, 0.5F, 0.7F, 0.1F, 0.5F, 0.3F, 0.0F, 0.4F, 0.0F, 0.2F, 0.45F, 0.0F, 0.2F, 0.5F, 0.3F, 0.0F, 0.5F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(0.0F, -0.2F, -2.0F, 4, 8, 4, 0.0F, 0.5F, 0.25F, 0.5F, 0.7F, 0.1F, 0.5F, 0.7F, 0.1F, 0.5F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.3F, 0.0F, 0.5F, 0.3F, 0.0F, 0.5F, 0.0F, 0.2F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-3.0F, -1.2F, -2.0F, 6, 1, 4, 0.0F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.3F, 0.5F, 0.2F, 0.3F, 0.5F, 0.2F, 0.3F, 0.5F, 0.2F, 0.3F, 0.5F, 0.2F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(2.0F, -0.5F, -2.5F, 2, 6, 5, 0.0F, -0.3F, 0.1F, 0.2F, 0.3F, -0.1F, 0.2F, 0.3F, -0.1F, 0.2F, -0.3F, 0.1F, 0.2F, 6.5F, -0.2F, 0.2F, -8.4F, 1.8F, 0.1F, -8.4F, 1.8F, 0.1F, 6.5F, -0.2F, 0.2F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-0.3F, 1.3F, -2.6F, 1, 1, 1, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F, 0.3F, 0.2F, 0.4F, 0.0F, 0.0F, 0.45F, 0.0F, 0.0F, 0.5F, 0.3F, 0.2F, 0.5F, 0.7F, 0.1F, 0.4F, 0.0F, 0.15F, 0.45F, 0.0F, 0.15F, 0.5F, 0.7F, 0.1F, 0.5F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(0.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.3F, 0.2F, 0.5F, 0.3F, 0.2F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.25F, 0.5F, 0.7F, 0.1F, 0.5F, 0.7F, 0.1F, 0.5F, 0.0F, 0.2F, 0.5F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-4.5F, 7.8F, -2.5F, 9, 2, 5, 0.0F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.0F, 0.0F, 0.1F, 0.2F, -0.3F, 0.3F, 0.2F, -0.3F, 0.3F, 0.2F, -0.3F, 0.3F, 0.2F, -0.3F, 0.3F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-3.5F, 6.5F, -3.0F, 3, 1, 1, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-5.0F, 6.5F, -3.0F, 2, 1, 1, 0.0F, -0.5F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 2.0F, 0.0F, -0.6F, -2.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.6F, -2.0F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-1.0F, 6.5F, -3.0F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 1.5F, 0.0F, -0.5F, 1.5F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, -1.8F, 0.0F, 0.0F, -1.8F, 0.0F, -0.5F, -0.5F, 0.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(2.0F, 0.5F, -3.0F, 1, 6, 1, 0.0F, 0.2F, 0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.2F, 0.5F, 0.0F, 1.5F, -1.5F, 0.0F, -2.0F, -0.8F, 0.0F, -2.0F, -0.8F, 0.0F, 1.5F, -1.5F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 97, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 97, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-2.0F, -2.5F, -1.5F, 4, 2, 3, 0.0F, 0.0F, 0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.2F, 1.1F, 0.2F, 0.3F, 0.9F, 0.2F, 0.3F, 0.9F, 0.2F, 0.2F, 1.1F, 0.2F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-1.0F, 7.5F, -2.0F, 4, 1, 4, 0.0F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.2F, 0.6F, 0.2F, 0.3F, 0.4F, 0.2F, 0.3F, 0.4F, 0.2F, 0.2F, 0.6F, 0.2F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 41, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 9, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.9F, 0.2F, 0.2F, 1.1F, 0.2F, 0.2F, 1.1F, 0.2F, 0.3F, 0.9F, 0.2F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, 7.5F, -2.0F, 4, 1, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.3F, 0.1F, 0.1F, 0.1F, 0.1F, 0.3F, 0.4F, 0.2F, 0.2F, 0.6F, 0.2F, 0.2F, 0.6F, 0.2F, 0.3F, 0.4F, 0.2F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-2.0F, -2.5F, -1.5F, 4, 2, 3, 0.0F, 0.2F, -0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.2F, -0.2F, 0.0F, 0.4F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 57, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 81, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 81, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 89, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, 0.5F, -0.25F, 0.5F, 0.7F, -0.1F, 0.5F, 0.7F, -0.15F, 0.5F, 0.0F, -0.1F, 0.5F, -0.4F, 0.5F, 0.9F, 1.5F, 0.0F, 0.9F, 1.5F, 0.0F, 0.9F, -0.4F, 0.5F, 0.9F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, -2.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, -0.5F, -2.0F, 4, 5, 4, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 5.0F, -2.0F, 4, 6, 5, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, -0.8F, 0.4F, 0.0F, -0.8F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, -0.7F, 0.4F, 0.0F, -0.7F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, -2.5F, -2.0F, 4, 2, 4, 0.0F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, -0.5F, -2.0F, 4, 5, 4, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F, 0.4F, 0.5F, 0.2F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 5.0F, -2.0F, 4, 6, 5, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, -0.8F, 0.4F, 0.0F, -0.8F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, -0.7F, 0.4F, 0.0F, -0.7F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 10.1F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-2.0F, -2.0F, -2.0F, 4, 8, 4, 0.0F, 0.7F, -0.15F, 0.4F, 0.0F, -0.1F, 0.45F, 0.0F, -0.1F, 0.5F, 0.7F, -0.15F, 0.5F, 1.5F, 0.0F, 0.88F, -0.4F, 0.5F, 0.88F, -0.4F, 0.5F, 0.88F, 1.5F, 0.0F, 0.88F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
