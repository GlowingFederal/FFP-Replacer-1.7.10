package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelGaddafi extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelGaddafi() {
    this.headModel = new ModelRendererTurbo[24];
    this.bodyModel = new ModelRendererTurbo[4];
    this.leftArmModel = new ModelRendererTurbo[1];
    this.rightArmModel = new ModelRendererTurbo[1];
    this.leftLegModel = new ModelRendererTurbo[2];
    this.rightLegModel = new ModelRendererTurbo[2];
    initheadModel_1();
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
    initleftLegModel_1();
    initrightLegModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.headModel[7] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[8] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.headModel[9] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.headModel[10] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.headModel[11] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.headModel[12] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.headModel[13] = new ModelRendererTurbo((ModelBase)this, 65, 9, this.textureX, this.textureY);
    this.headModel[14] = new ModelRendererTurbo((ModelBase)this, 73, 9, this.textureX, this.textureY);
    this.headModel[15] = new ModelRendererTurbo((ModelBase)this, 81, 9, this.textureX, this.textureY);
    this.headModel[16] = new ModelRendererTurbo((ModelBase)this, 89, 9, this.textureX, this.textureY);
    this.headModel[17] = new ModelRendererTurbo((ModelBase)this, 97, 9, this.textureX, this.textureY);
    this.headModel[18] = new ModelRendererTurbo((ModelBase)this, 105, 9, this.textureX, this.textureY);
    this.headModel[19] = new ModelRendererTurbo((ModelBase)this, 113, 9, this.textureX, this.textureY);
    this.headModel[20] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.headModel[21] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.headModel[22] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[23] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(1.0F, -3.5F, -4.0F, 2, 1, 1, 0.0F, 0.4F, 0.0F, 0.2F, 0.6F, 0.2F, 0.2F, 0.6F, 0.2F, 0.2F, 0.0F, 0.0F, 0.2F, -0.1F, -0.3F, 0.2F, 0.1F, -0.45F, 0.2F, 0.1F, -0.45F, 0.2F, -0.1F, -0.3F, 0.2F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -5.7F, 0.0F, 8, 1, 4, 0.0F, 0.2F, 0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 1.8F, 0.5F, 0.2F, 1.8F, 1.0F, 0.2F, 1.8F, 1.0F, 1.2F, 1.8F, 0.5F, 1.2F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -1.7F, 0.0F, 8, 2, 4, 0.0F, 1.8F, 0.0F, 0.2F, 1.8F, 0.0F, 0.2F, 1.8F, 0.0F, 1.2F, 1.8F, 0.0F, 1.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -3.2F, 0.0F, 8, 1, 4, 0.0F, 1.8F, 1.0F, 0.2F, 1.8F, 0.5F, 0.2F, 1.8F, 0.5F, 1.2F, 1.8F, 1.0F, 1.2F, 1.8F, 0.5F, 0.2F, 1.8F, 0.5F, 0.2F, 1.8F, 0.5F, 1.2F, 1.8F, 0.5F, 1.2F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -3.2F, -1.2F, 8, 1, 1, 0.0F, 0.8F, 1.0F, 0.0F, 0.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F, 1.8F, 1.0F, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.0F, -5.2F, -1.2F, 8, 1, 1, 0.0F, -1.2F, 1.0F, 0.0F, -1.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 1.0F, 0.0F, 0.8F, 0.0F, 0.0F, 0.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F, 1.8F, 0.0F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(-4.0F, -1.2F, -1.2F, 8, 2, 1, 0.0F, 0.8F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F, 1.8F, 0.5F, 0.0F, -1.2F, -1.0F, 0.0F, -1.2F, -1.0F, 0.0F, 0.2F, -1.0F, 0.0F, 0.2F, -1.0F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[7].addShapeBox(1.0F, -4.9F, -4.0F, 2, 1, 1, 0.0F, 0.8F, -0.5F, 0.2F, 0.7F, -0.5F, 0.2F, 0.7F, -0.5F, 0.2F, 0.8F, -0.5F, 0.2F, 0.4F, 0.4F, 0.2F, 0.6F, 0.2F, 0.2F, 0.6F, 0.2F, 0.2F, 0.0F, 0.6F, 0.2F);
    this.headModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[8].addShapeBox(0.0F, -4.4F, -4.15F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.headModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[9].addShapeBox(3.3F, -4.5F, -4.1F, 1, 1, 4, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F);
    this.headModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[10].addShapeBox(1.0F, -5.1F, -4.05F, 2, 1, 1, 0.0F, -0.5F, -0.35F, 0.2F, -0.5F, -0.35F, 0.2F, -0.5F, -0.35F, 0.2F, -0.5F, -0.35F, 0.2F, -0.5F, -0.3F, 0.2F, -0.5F, -0.3F, 0.2F, -0.5F, -0.3F, 0.2F, -0.5F, -0.3F, 0.2F);
    this.headModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[11].addShapeBox(0.5F, -5.1F, -4.05F, 1, 1, 1, 0.0F, 0.0F, -0.55F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.55F, 0.2F, 0.0F, -0.15F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.15F, 0.2F);
    this.headModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[12].addShapeBox(-0.5F, -4.9F, -4.05F, 1, 1, 1, 0.0F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.2F);
    this.headModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[13].addShapeBox(2.5F, -5.1F, -4.05F, 2, 1, 1, 0.0F, 0.0F, -0.35F, 0.2F, -0.45F, -0.55F, 0.2F, -0.45F, -0.55F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.3F, 0.2F, -0.45F, -0.15F, 0.2F, -0.45F, -0.15F, 0.2F, 0.0F, -0.3F, 0.2F);
    this.headModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[14].addShapeBox(-3.0F, -4.9F, -4.0F, 2, 1, 1, 0.0F, 0.7F, -0.5F, 0.2F, 0.8F, -0.5F, 0.2F, 0.8F, -0.5F, 0.2F, 0.7F, -0.5F, 0.2F, 0.6F, 0.2F, 0.2F, 0.4F, 0.4F, 0.2F, 0.0F, 0.6F, 0.2F, 0.6F, 0.2F, 0.2F);
    this.headModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[15].addShapeBox(-3.0F, -3.5F, -4.0F, 2, 1, 1, 0.0F, 0.6F, 0.2F, 0.2F, 0.4F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.6F, 0.2F, 0.2F, 0.1F, -0.45F, 0.2F, -0.1F, -0.3F, 0.2F, -0.1F, -0.3F, 0.2F, 0.1F, -0.45F, 0.2F);
    this.headModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[16].addShapeBox(-1.0F, -4.4F, -4.15F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.headModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[17].addShapeBox(-1.5F, -5.1F, -4.05F, 1, 1, 1, 0.0F, 0.0F, -0.35F, 0.2F, 0.0F, -0.55F, 0.2F, 0.0F, -0.55F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.15F, 0.2F, 0.0F, -0.15F, 0.2F, 0.0F, -0.3F, 0.2F);
    this.headModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[18].addShapeBox(-3.0F, -5.1F, -4.05F, 2, 1, 1, 0.0F, -0.5F, -0.35F, 0.2F, -0.5F, -0.35F, 0.2F, -0.5F, -0.35F, 0.2F, -0.5F, -0.35F, 0.2F, -0.5F, -0.3F, 0.2F, -0.5F, -0.3F, 0.2F, -0.5F, -0.3F, 0.2F, -0.5F, -0.3F, 0.2F);
    this.headModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[19].addShapeBox(-4.5F, -5.1F, -4.05F, 2, 1, 1, 0.0F, -0.45F, -0.55F, 0.2F, 0.0F, -0.35F, 0.2F, 0.0F, -0.35F, 0.2F, -0.45F, -0.55F, 0.2F, -0.45F, -0.15F, 0.2F, 0.0F, -0.3F, 0.2F, 0.0F, -0.3F, 0.2F, -0.45F, -0.15F, 0.2F);
    this.headModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[20].addShapeBox(-4.3F, -4.5F, -4.1F, 1, 1, 4, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F);
    this.headModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[21].addShapeBox(-3.0F, -9.5F, -4.0F, 6, 3, 8, 0.0F, 0.0F, 0.2F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, -0.8F, 0.5F, 0.0F, 0.1F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 1.5F, 0.5F, 0.2F, 1.8F, 0.8F, 0.2F, 0.8F, 0.8F);
    this.headModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[22].addShapeBox(-4.4F, -9.5F, -4.0F, 1, 3, 8, 0.0F, -0.1F, 0.0F, -0.2F, 0.4F, 0.2F, 0.2F, 0.4F, 0.1F, 0.5F, -0.1F, -0.1F, 0.0F, 0.3F, 0.5F, 0.0F, 0.2F, 0.5F, 0.5F, 0.2F, 0.8F, 0.8F, 0.3F, 0.9F, 0.3F);
    this.headModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[23].addShapeBox(3.4F, -8.5F, -4.0F, 1, 3, 8, 0.0F, 0.2F, 0.3F, 0.2F, 0.2F, -0.2F, -0.2F, 0.2F, -0.3F, 0.0F, 0.2F, 0.2F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.8F, 0.0F, 0.2F, 1.1F, 0.3F, 0.2F, 0.8F, 0.8F);
    this.headModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 41, 49, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 61, 46, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, 0.2F, 0.5F, 0.4F, 0.0F, 0.7F, 0.4F, 0.0F, 0.7F, 0.4F, 0.2F, 0.5F, 0.4F, 0.5F, 0.0F, 0.6F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.6F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(0.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F, 0.0F, 0.7F, 0.4F, 0.2F, 0.5F, 0.4F, 0.2F, 0.5F, 0.4F, 0.0F, 0.7F, 0.4F, 0.0F, 0.0F, 0.8F, 0.5F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.0F, 0.0F, 1.0F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-1.5F, -0.5F, -2.2F, 6, 10, 4, 0.0F, -3.0F, 0.8F, 0.6F, 1.6F, 0.2F, 0.6F, 1.6F, 0.2F, 0.9F, -3.0F, 0.8F, 0.9F, 3.4F, -2.5F, 0.9F, -9.3F, 4.1F, 0.9F, -9.3F, 4.1F, 1.2F, 3.4F, -2.5F, 1.2F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-7.5F, -5.8F, -2.95F, 17, 17, 1, 0.0F, -7.2F, -7.2F, -0.05F, -7.2F, -7.2F, -0.05F, -7.2F, -7.2F, 0.0F, -7.2F, -7.2F, 0.0F, -7.2F, -7.2F, 0.0F, -7.2F, -7.2F, 0.0F, -7.2F, -7.2F, 0.0F, -7.2F, -7.2F, 0.0F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 11, 4, 0.0F, 0.0F, 0.5F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.0F, 0.5F, 0.0F, 0.2F, 0.5F, 0.5F, 1.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 105, 17, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 11, 4, 0.0F, 0.1F, 0.1F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.1F, 0.1F, 0.0F, 1.0F, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 1.0F, 0.0F, 0.5F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 73, 33, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 97, 41, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, 0.0F, 0.0F, 0.8F, 0.5F, 0.0F, 0.6F, 0.5F, 0.0F, 0.6F, 0.0F, 0.0F, 1.0F, 0.0F, 1.7F, 1.0F, 1.2F, 1.5F, 0.4F, 1.2F, 1.5F, 1.0F, 0.0F, 1.7F, 1.5F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 97, 33, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 0.0F, -2.0F, 4, 9, 4, 0.0F, 0.5F, 0.0F, 0.6F, 0.0F, 0.0F, 0.8F, 0.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.6F, 1.2F, 1.5F, 0.4F, 0.0F, 1.7F, 1.0F, 0.0F, 1.7F, 1.5F, 1.2F, 1.5F, 1.0F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 10.0F, -2.0F, 4, 2, 4, 0.0F, 0.2F, -1.1F, 1.5F, 0.2F, -1.1F, 1.5F, 0.2F, 0.5F, 0.2F, 0.2F, 0.5F, 0.2F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 1.8F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
