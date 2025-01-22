package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSaddam extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 128;
  
  public ModelSaddam() {
    this.headModel = new ModelRendererTurbo[14];
    this.bodyModel = new ModelRendererTurbo[20];
    this.leftArmModel = new ModelRendererTurbo[5];
    this.rightArmModel = new ModelRendererTurbo[5];
    this.leftLegModel = new ModelRendererTurbo[4];
    this.rightLegModel = new ModelRendererTurbo[4];
    initheadModel_1();
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 9, 65, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 49, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 49, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 57, 57, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 57, 65, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 49, 73, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 81, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 33, 81, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 97, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 33, 97, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 81, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 5, 112, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -7.8F, -4.0F, 8, 2, 8, 0.0F, 0.15F, 0.0F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, 0.0F, 0.15F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-2.5F, -2.45F, -4.05F, 2, 1, 1, 0.0F, -0.6F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(0.5F, -2.45F, -4.05F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.6F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, -0.5F, 0.0F, 0.0F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-0.5F, -2.45F, -4.05F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, -0.2F, 0.0F, 0.5F, -0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-2.7F, -5.2F, -3.9F, 2, 1, 1, 0.0F, 0.0F, -0.1F, 0.2F, -0.1F, -0.35F, 0.2F, 0.0F, -0.4F, 0.2F, -0.5F, -0.3F, 0.2F, -0.3F, -0.3F, 0.2F, -0.2F, -0.15F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, 0.0F, 0.2F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-3.2F, -5.2F, -3.9F, 1, 1, 1, 0.0F, 0.2F, -0.4F, 0.2F, -0.5F, -0.1F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.6F, 0.2F, 0.3F, -0.1F, 0.2F, 0.4F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.4F, 0.2F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(0.8F, -5.2F, -3.9F, 2, 1, 1, 0.0F, -0.1F, -0.35F, 0.2F, 0.0F, -0.1F, 0.2F, -0.5F, -0.3F, 0.2F, 0.0F, -0.4F, 0.2F, -0.2F, -0.15F, 0.2F, -0.3F, -0.3F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -0.3F, 0.2F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(2.3F, -5.2F, -3.9F, 1, 1, 1, 0.0F, -0.5F, -0.1F, 0.2F, 0.2F, -0.4F, 0.2F, 0.0F, -0.6F, 0.2F, 0.0F, -0.3F, 0.2F, 0.4F, -0.4F, 0.2F, 0.3F, -0.1F, 0.2F, 0.0F, -0.4F, 0.2F, 0.0F, 0.0F, 0.2F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(-3.0F, -9.8F, -4.0F, 7, 2, 8, 0.0F, 0.2F, -1.0F, 1.0F, -4.2F, 0.0F, 1.2F, -4.2F, 0.0F, 1.2F, 0.2F, -1.0F, 1.0F, -0.85F, 1.0F, 0.15F, 0.15F, 0.5F, 0.15F, 0.15F, 0.5F, 0.15F, -0.85F, 1.0F, 0.15F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(-5.0F, -9.8F, -4.0F, 2, 3, 8, 0.0F, -0.2F, -2.0F, 0.8F, -0.2F, -1.0F, 1.0F, -0.2F, -1.0F, 1.0F, -0.2F, -2.0F, 0.8F, -0.5F, 2.0F, 0.15F, 0.85F, 0.0F, 0.15F, 0.85F, 0.0F, 0.15F, -0.5F, 2.0F, 0.15F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(-0.2F, -10.3F, -4.0F, 4, 1, 8, 0.0F, -3.0F, -0.3F, 0.7F, 0.5F, -1.5F, 0.2F, 0.5F, -1.5F, 0.2F, -3.0F, -0.3F, 0.7F, 0.0F, -0.5F, 1.2F, 0.35F, 2.0F, 0.15F, 0.35F, 2.0F, 0.15F, 0.0F, -0.5F, 1.2F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(-5.6F, -9.8F, -4.0F, 1, 4, 8, 0.0F, 0.0F, -4.0F, 0.5F, -0.2F, -2.0F, 0.8F, -0.2F, -2.0F, 0.8F, 0.0F, -4.0F, 0.5F, -0.15F, 0.8F, 0.15F, 0.1F, 1.0F, 0.15F, 0.1F, 1.0F, 0.15F, -0.15F, 0.8F, 0.15F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(1.0F, -8.6F, -4.5F, 3, 3, 1, 0.0F, -0.8F, -0.6F, 0.1F, -0.8F, -0.6F, 0.0F, -0.8F, -0.6F, 0.0F, -0.8F, -0.6F, 0.0F, -0.8F, -0.6F, -0.15F, -0.8F, -0.6F, -0.2F, -0.8F, -0.6F, 0.0F, -0.8F, -0.6F, 0.0F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(-4.0F, -6.8F, -4.0F, 8, 1, 8, 0.0F, 0.25F, -0.4F, 0.25F, 0.25F, -0.4F, 0.25F, 0.25F, -0.4F, 0.25F, 0.25F, -0.4F, 0.25F, 0.25F, 0.1F, 0.25F, 0.25F, 0.1F, 0.25F, 0.25F, 0.1F, 0.25F, 0.25F, 0.1F, 0.25F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 41, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 41, 33, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 57, 33, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 17, 57, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 9.5F, -2.0F, 8, 1, 4, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-2.0F, 0.0F, -2.2F, 2, 1, 4, 0.0F, 0.1F, 0.4F, 0.4F, 0.1F, 0.2F, 0.4F, 0.1F, 0.2F, 0.0F, 0.1F, 0.4F, 0.0F, -1.9F, 0.5F, 0.4F, 0.1F, 0.5F, 0.4F, 0.1F, 0.5F, 0.0F, -1.9F, 0.5F, 0.0F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, -2.2F, 2, 1, 4, 0.0F, 0.1F, 0.2F, 0.4F, 0.1F, 0.4F, 0.4F, 0.1F, 0.4F, 0.0F, 0.1F, 0.2F, 0.0F, 0.1F, 0.5F, 0.4F, -1.9F, 0.5F, 0.4F, -1.9F, 0.5F, 0.0F, 0.1F, 0.5F, 0.0F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 2.0F, -2.0F, 8, 8, 4, 0.0F, 0.75F, 0.0F, 0.5F, 0.75F, 0.0F, 0.5F, 0.75F, 0.0F, 0.5F, 0.75F, 0.0F, 0.5F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F, 0.15F, -0.5F, 0.15F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 10.3F, -2.0F, 8, 2, 4, 0.0F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.5F, -0.3F, 0.3F, 0.5F, -0.3F, 0.3F, 0.5F, -0.3F, 0.3F, 0.5F, -0.3F, 0.3F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 2, 4, 0.0F, 0.7F, 0.2F, 0.15F, 0.7F, 0.2F, 0.15F, 0.7F, 0.2F, 0.15F, 0.7F, 0.2F, 0.15F, 0.75F, 0.0F, 0.5F, 0.75F, 0.0F, 0.5F, 0.75F, 0.0F, 0.5F, 0.75F, 0.0F, 0.5F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.0F, 2.2F, -2.6F, 3, 3, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.2F, -0.1F, -0.2F, 0.2F, -0.1F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-4.0F, 2.2F, -2.8F, 1, 1, 1, 0.0F, -0.15F, 0.05F, 0.0F, 0.5F, 0.05F, 0.0F, 0.5F, 0.05F, 0.0F, -0.15F, 0.05F, 0.0F, -0.15F, -0.2F, -0.1F, 0.5F, 0.2F, -0.1F, 0.5F, 0.2F, 0.0F, -0.15F, -0.2F, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-2.0F, 2.2F, -2.8F, 1, 1, 1, 0.0F, 0.5F, 0.05F, 0.0F, -0.15F, 0.05F, 0.0F, -0.15F, 0.05F, 0.0F, 0.5F, 0.05F, 0.0F, 0.5F, 0.2F, -0.1F, -0.15F, -0.2F, -0.1F, -0.15F, -0.2F, 0.0F, 0.5F, 0.2F, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(3.0F, 2.2F, -2.8F, 1, 1, 1, 0.0F, 0.5F, 0.05F, 0.0F, -0.15F, 0.05F, 0.0F, -0.15F, 0.05F, 0.0F, 0.5F, 0.05F, 0.0F, 0.5F, 0.2F, -0.1F, -0.15F, -0.2F, -0.1F, -0.15F, -0.2F, 0.0F, 0.5F, 0.2F, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(1.0F, 2.2F, -2.8F, 1, 1, 1, 0.0F, -0.15F, 0.05F, 0.0F, 0.5F, 0.05F, 0.0F, 0.5F, 0.05F, 0.0F, -0.15F, 0.05F, 0.0F, -0.15F, -0.2F, -0.1F, 0.5F, 0.2F, -0.1F, 0.5F, 0.2F, 0.0F, -0.15F, -0.2F, 0.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(1.0F, 2.2F, -2.6F, 3, 3, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.2F, -0.1F, -0.2F, 0.2F, -0.1F, -0.2F, 0.2F, 0.0F, -0.2F, 0.2F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-0.5F, 1.2F, -2.6F, 1, 8, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.5F, -0.4F, -0.2F, 0.5F, -0.4F, -0.2F, 0.5F, 0.0F, -0.2F, 0.5F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-4.7F, 4.0F, -3.0F, 1, 2, 1, 0.0F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-3.3F, 4.0F, -3.0F, 1, 2, 1, 0.0F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, -0.35F, 0.0F, -0.35F, 0.9F, 0.0F, -0.35F, -1.5F, -0.2F, -0.35F, -1.5F, -0.2F, -0.35F, 0.9F, 0.0F, -0.35F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-3.0F, 3.0F, -3.0F, 1, 1, 1, 0.0F, -0.35F, 0.2F, -0.35F, -0.35F, 0.2F, -0.35F, -0.35F, 0.2F, -0.35F, -0.35F, 0.2F, -0.35F, -0.05F, 0.0F, -0.35F, -0.65F, 0.0F, -0.35F, -0.65F, 0.0F, -0.35F, -0.05F, 0.0F, -0.35F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-5.0F, 0.0F, -3.0F, 1, 4, 1, 0.0F, -0.35F, 0.2F, -0.5F, -0.35F, 0.2F, -0.5F, -0.35F, 0.2F, -0.2F, -0.35F, 0.2F, -0.2F, -0.65F, 0.0F, -0.35F, -0.05F, 0.0F, -0.35F, -0.05F, 0.0F, -0.35F, -0.65F, 0.0F, -0.35F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-5.0F, 0.0F, -3.0F, 1, 1, 2, 0.0F, -0.35F, 0.2F, -0.5F, -0.35F, 0.2F, -0.5F, -0.5F, 0.4F, -0.2F, -0.1F, 0.4F, -0.2F, -0.35F, -0.9F, -0.5F, -0.35F, -0.9F, -0.5F, -0.35F, -0.9F, -0.2F, -0.35F, -0.9F, -0.2F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-2.5F, -0.5F, -2.7F, 2, 2, 5, 0.0F, -0.2F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, -0.3F, 0.3F, 0.0F, 0.5F, 0.0F, 0.0F, 0.7F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(0.5F, -0.5F, -2.7F, 2, 2, 5, 0.0F, -1.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.3F, 0.3F, 0.0F, 0.5F, 0.5F, 0.0F, 0.7F, 0.2F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.leftArmModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.0F, 3.0F, -2.0F, 4, 4, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-1.0F, 7.0F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(-1.0F, 8.0F, -2.0F, 4, 1, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[4].addShapeBox(-2.0F, -2.4F, -1.5F, 4, 1, 3, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 49, this.textureX, this.textureY);
    this.rightArmModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 49, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, 8.0F, -2.0F, 4, 1, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, 7.0F, -2.0F, 4, 1, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F, 0.1F, -0.1F, 0.1F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-3.0F, 3.0F, -2.0F, 4, 4, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 5, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].addShapeBox(-2.0F, -2.4F, -1.5F, 4, 1, 3, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.1F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 41, 57, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 4.0F, -2.0F, 4, 6, 4, 0.0F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.4F, 0.0F, 0.3F, 0.4F, 0.0F, 0.5F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.3F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-2.0F, 6.8F, -2.0F, 4, 4, 4, 0.0F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 41, 57, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 4.0F, -2.0F, 4, 6, 4, 0.0F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.4F, 0.0F, 0.3F, 0.4F, 0.0F, 0.5F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.3F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 6.8F, -2.0F, 4, 4, 4, 0.0F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.3F, -0.2F, 0.3F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 4, 4, 0.0F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F, 0.5F, 0.0F, 0.3F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
