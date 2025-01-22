package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelQingFakeArmor extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 128;
  
  public ModelQingFakeArmor() {
    this.bodyModel = new ModelRendererTurbo[22];
    this.leftArmModel = new ModelRendererTurbo[5];
    this.rightArmModel = new ModelRendererTurbo[5];
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
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 46, 54, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 46, 54, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 49, 66, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 33, 53, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 33, 53, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 49, 66, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 49, 66, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 33, 9, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 25, 16, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 11.5F, -2.5F, 8, 1, 5, 0.0F, 0.55F, 0.0F, 0.25F, 0.55F, 0.0F, 0.25F, 0.55F, 0.0F, 0.25F, 0.55F, 0.0F, 0.25F, 0.55F, -0.2F, 0.25F, 0.55F, -0.2F, 0.25F, 0.55F, -0.2F, 0.25F, 0.55F, -0.2F, 0.25F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 11.0F, -2.5F, 8, 1, 5, 0.0F, 0.6F, -0.1F, 0.3F, 0.6F, -0.1F, 0.3F, 0.6F, -0.1F, 0.3F, 0.6F, -0.1F, 0.3F, 0.6F, -0.3F, 0.3F, 0.6F, -0.3F, 0.3F, 0.6F, -0.3F, 0.3F, 0.6F, -0.3F, 0.3F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-0.5F, 1.5F, -2.6F, 1, 8, 1, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, 0.0F, 1.5F, 0.0F, -0.2F, 1.5F, 0.0F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 5.0F, -2.5F, 4, 5, 5, 0.0F, 0.5F, 0.0F, 0.4F, -0.1F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.5F, 0.0F, 0.4F, 0.5F, 1.1F, 0.2F, -0.1F, 1.1F, 0.2F, 0.0F, 1.1F, 0.2F, 0.5F, 1.1F, 0.2F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 1.5F, -2.7F, 4, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.5F, 0.2F, -0.1F, 0.5F, 0.2F, -0.1F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 0.0F, -2.5F, 2, 1, 5, 0.0F, -0.5F, 0.7F, 0.0F, -0.5F, 0.8F, 0.0F, 2.0F, 0.8F, 0.0F, -0.5F, 0.7F, 0.0F, 0.0F, 0.5F, 0.2F, -0.2F, 0.5F, 0.2F, 2.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.0F, 1.5F, 1.7F, 4, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.7F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.2F, 0.7F, 0.5F, 0.2F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(0.0F, 5.0F, -2.5F, 4, 5, 5, 0.0F, -0.1F, 0.0F, 0.4F, 0.5F, 0.0F, 0.4F, 0.5F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, -0.1F, 1.1F, 0.2F, 0.5F, 1.1F, 0.2F, 0.5F, 1.1F, 0.2F, 0.0F, 1.1F, 0.2F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-2.5F, 4.6F, -3.0F, 5, 1, 6, 0.0F, -0.05F, -0.3F, -0.02F, -0.05F, -0.3F, -0.02F, -0.05F, -0.3F, -0.02F, -0.05F, -0.3F, -0.02F, -0.05F, -0.3F, -0.02F, -0.05F, -0.3F, -0.02F, -0.05F, -0.3F, -0.02F, -0.05F, -0.3F, -0.02F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-4.0F, 5.0F, -2.5F, 1, 5, 5, 0.0F, 1.0F, -0.3F, 0.45F, 0.9F, 0.0F, 0.7F, 1.0F, 0.0F, 0.7F, 1.0F, -0.3F, 0.45F, 0.6F, 0.0F, 0.3F, -0.1F, -1.5F, 0.45F, 0.0F, -1.5F, 0.45F, 0.6F, 0.0F, 0.3F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-4.5F, 4.6F, -3.0F, 2, 1, 6, 0.0F, 0.05F, -0.3F, -0.1F, 0.05F, -0.3F, -0.02F, 0.05F, -0.3F, -0.02F, 0.05F, -0.3F, -0.1F, 0.05F, -0.3F, -0.1F, 0.05F, -0.3F, -0.02F, 0.05F, -0.3F, -0.02F, 0.05F, -0.3F, -0.1F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-1.5F, -0.5F, -4.1F, 3, 5, 1, 0.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, 1.0F, -0.5F, 0.0F, 1.0F, 0.5F, -2.8F, 0.0F, 0.5F, -2.8F, 0.0F, 0.5F, -3.0F, 0.5F, 0.5F, -3.0F, 0.5F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(0.0F, 1.5F, -2.7F, 4, 3, 1, 0.0F, -0.1F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.5F, 0.2F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, 0.0F, -0.1F, 0.5F, 0.0F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(2.5F, 4.6F, -3.0F, 2, 1, 6, 0.0F, 0.05F, -0.3F, -0.02F, 0.05F, -0.3F, -0.1F, 0.05F, -0.3F, -0.1F, 0.05F, -0.3F, -0.02F, 0.05F, -0.3F, -0.02F, 0.05F, -0.3F, -0.1F, 0.05F, -0.3F, -0.1F, 0.05F, -0.3F, -0.02F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(3.0F, 5.0F, -2.5F, 1, 5, 5, 0.0F, 0.9F, 0.0F, 0.7F, 1.0F, -0.3F, 0.45F, 1.0F, -0.3F, 0.45F, 1.0F, 0.0F, 0.7F, -0.1F, -1.5F, 0.45F, 0.6F, 0.0F, 0.3F, 0.6F, 0.0F, 0.3F, 0.0F, -1.5F, 0.45F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(0.0F, 1.5F, 1.7F, 4, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-3.8F, 5.0F, -2.5F, 1, 5, 5, 0.0F, 1.0F, -0.3F, 0.45F, 0.9F, 0.0F, 0.7F, 1.0F, 0.0F, 0.7F, 1.0F, -0.3F, 0.45F, 0.6F, 0.0F, 0.3F, -0.1F, -1.5F, 0.45F, 0.0F, -1.5F, 0.45F, 0.6F, 0.0F, 0.3F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(2.8F, 5.0F, -2.5F, 1, 5, 5, 0.0F, 0.9F, 0.0F, 0.7F, 1.0F, -0.3F, 0.45F, 1.0F, -0.3F, 0.45F, 1.0F, 0.0F, 0.7F, -0.1F, -1.5F, 0.45F, 0.6F, 0.0F, 0.3F, 0.6F, 0.0F, 0.3F, 0.0F, -1.5F, 0.45F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-5.0F, -0.5F, -4.1F, 3, 5, 1, 0.0F, -1.0F, 0.5F, -1.5F, 1.0F, 0.0F, -1.0F, 1.0F, 0.0F, 1.0F, -1.0F, 0.5F, 1.5F, 0.0F, -3.8F, -0.7F, 0.0F, -2.8F, 0.0F, 0.0F, -3.0F, 0.5F, 0.0F, -4.0F, 0.5F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(2.0F, -0.5F, -4.1F, 3, 5, 1, 0.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.5F, -1.5F, -1.0F, 0.5F, 1.5F, 1.0F, 0.0F, 1.0F, 0.0F, -2.8F, 0.0F, 0.0F, -3.8F, -0.7F, 0.0F, -4.0F, 0.5F, 0.0F, -3.0F, 0.5F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(2.0F, 0.0F, -2.5F, 2, 1, 5, 0.0F, -0.5F, 0.8F, 0.0F, -0.5F, 0.7F, 0.0F, -0.5F, 0.7F, 0.0F, 2.0F, 0.8F, 0.0F, -0.2F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 2.0F, 0.5F, 0.2F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(-2.0F, 9.0F, -3.6F, 4, 4, 1, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.2F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 58, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.leftArmModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 65, this.textureX, this.textureY);
    this.leftArmModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, 2.0F, -2.0F, 3, 1, 4, 0.0F, 0.6F, -0.2F, 0.6F, 0.6F, -0.2F, 0.5F, 0.6F, -0.2F, 0.5F, 0.6F, -0.2F, 0.6F, 0.6F, -0.2F, 0.6F, 0.6F, -0.2F, 0.5F, 0.6F, -0.2F, 0.5F, 0.6F, -0.2F, 0.6F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(3.0F, -2.0F, -2.0F, 1, 5, 4, 0.0F, -0.2F, 0.2F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, -0.2F, 0.2F, 0.5F, -0.2F, -0.1F, 0.8F, 1.2F, 0.0F, 0.7F, 1.2F, 0.0F, 0.7F, -0.2F, -0.1F, 0.8F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(0.3F, 3.0F, -2.0F, 5, 2, 4, 0.0F, 1.0F, 0.5F, 1.1F, -0.1F, 0.0F, 0.7F, -0.1F, 0.0F, 0.7F, 1.0F, 0.5F, 1.1F, -3.0F, 0.0F, 1.0F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, -3.0F, 0.0F, 1.0F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[3].addShapeBox(-1.0F, -2.0F, -3.0F, 4, 5, 6, 0.0F, 0.5F, 0.7F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, 0.2F, -0.5F, 0.5F, 0.7F, -0.5F, -0.3F, -0.5F, 0.1F, 0.2F, -0.1F, -0.2F, 0.2F, -0.1F, -0.2F, -0.3F, -0.5F, 0.1F);
    this.leftArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[4].addShapeBox(0.3F, 3.3F, -2.0F, 5, 2, 4, 0.0F, 1.0F, 0.5F, 1.0F, -0.1F, 0.0F, 0.6F, -0.1F, 0.0F, 0.6F, 1.0F, 0.5F, 1.0F, -3.0F, 0.0F, 0.9F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, 0.5F, -3.0F, 0.0F, 0.9F);
    this.leftArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 58, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 49, 41, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 65, this.textureX, this.textureY);
    this.rightArmModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-2.0F, 2.0F, -2.0F, 3, 1, 4, 0.0F, 0.6F, -0.2F, 0.5F, 0.6F, -0.2F, 0.6F, 0.6F, -0.2F, 0.6F, 0.6F, -0.2F, 0.5F, 0.6F, -0.2F, 0.5F, 0.6F, -0.2F, 0.6F, 0.6F, -0.2F, 0.6F, 0.6F, -0.2F, 0.5F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-4.0F, -2.0F, -2.0F, 1, 5, 4, 0.0F, 0.0F, -0.5F, 0.5F, -0.2F, 0.2F, 0.5F, -0.2F, 0.2F, 0.5F, 0.0F, -0.5F, 0.5F, 1.2F, 0.0F, 0.7F, -0.2F, -0.1F, 0.8F, -0.2F, -0.1F, 0.8F, 1.2F, 0.0F, 0.7F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-5.3F, 3.0F, -2.0F, 5, 2, 4, 0.0F, -0.1F, 0.0F, 0.7F, 1.0F, 0.5F, 1.1F, 1.0F, 0.5F, 1.1F, -0.1F, 0.0F, 0.7F, 0.5F, 0.5F, 0.5F, -3.0F, 0.0F, 1.0F, -3.0F, 0.0F, 1.0F, 0.5F, 0.5F, 0.5F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-3.0F, -2.0F, -3.0F, 4, 5, 6, 0.0F, 0.2F, 0.2F, -0.5F, 0.5F, 0.7F, -0.5F, 0.5F, 0.7F, -0.5F, 0.2F, 0.2F, -0.5F, 0.2F, -0.1F, -0.2F, -0.3F, -0.5F, 0.1F, -0.3F, -0.5F, 0.1F, 0.2F, -0.1F, -0.2F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].addShapeBox(-5.3F, 3.3F, -2.0F, 5, 2, 4, 0.0F, -0.1F, 0.0F, 0.6F, 1.0F, 0.5F, 1.0F, 1.0F, 0.5F, 1.0F, -0.1F, 0.0F, 0.6F, 0.5F, 0.5F, 0.4F, -3.0F, 0.0F, 1.0F, -3.0F, 0.0F, 1.0F, 0.5F, 0.5F, 0.4F);
    this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftLegModel_1() {
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 49, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, -1.0F, -2.0F, 4, 11, 4, 0.0F, -0.1F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.3F, -1.0F, 2.2F, 2.5F, -2.0F, 1.5F, 2.5F, -2.0F, 1.5F, -0.3F, -1.0F, 2.2F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightLegModel_1() {
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 49, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, -1.0F, -2.0F, 4, 11, 4, 0.0F, 0.5F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, -0.1F, -0.5F, 0.7F, 0.5F, -0.5F, 0.7F, 2.5F, -2.0F, 1.5F, -0.3F, -1.0F, 2.2F, -0.3F, -1.0F, 2.2F, 2.5F, -2.0F, 1.5F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
