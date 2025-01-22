package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelChineseMonk extends ModelCustomArmour {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelChineseMonk() {
    this.bodyModel = new ModelRendererTurbo[20];
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 217, 1, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 241, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 265, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 57, 9, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 161, 9, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 424, 12, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 424, 12, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 424, 12, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-3.5F, -1.0F, -3.5F, 1, 8, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.4F, -0.5F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -0.4F, -0.5F, 0.0F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(2.5F, -1.0F, -3.5F, 1, 8, 1, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, -0.4F, -0.5F, 0.0F, -0.4F, -0.5F, 0.0F, 0.0F, -0.2F, 0.0F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].func_78790_a(2.45F, 0.7F, -3.8F, 1, 1, 1, 0.0F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].func_78790_a(2.45F, 2.5F, -3.8F, 1, 1, 1, 0.0F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].func_78790_a(2.45F, 4.5F, -3.8F, 1, 1, 1, 0.0F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].func_78790_a(-3.35F, 4.5F, -3.8F, 1, 1, 1, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].func_78790_a(-3.35F, 2.5F, -3.8F, 1, 1, 1, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].func_78790_a(-3.45F, 0.7F, -3.8F, 1, 1, 1, 0.0F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].func_78790_a(-2.35F, 6.3F, -3.8F, 1, 1, 1, 0.0F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].func_78790_a(1.45F, 6.3F, -3.8F, 1, 1, 1, 0.0F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].func_78790_a(-0.5F, 6.8F, -3.8F, 1, 1, 1, 0.0F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-4.0F, 0.0F, -2.5F, 4, 8, 4, 0.0F, 0.0F, 0.2F, 0.0F, -0.9F, 0.2F, 0.0F, -0.5F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 2.0F, 0.0F, 2.0F, 2.0F, 0.0F, 2.0F, 1.0F, 0.0F, 0.0F, 2.0F, 0.0F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-1.0F, 0.0F, -2.6F, 5, 7, 4, 0.0F, 0.1F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.1F, -2.0F, 0.0F, 1.0F, 2.5F, 0.0F, 0.0F, 2.5F, 0.0F, 0.0F, 2.5F, 0.2F, 1.0F, 2.5F, 0.2F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-1.0F, 0.0F, -2.6F, 5, 4, 4, 0.0F, -1.2F, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, -1.2F, 0.0F, 0.0F, 0.1F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.1F, -2.0F, 0.0F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-3.0F, 3.0F, -3.0F, 8, 10, 6, 0.0F, 0.1F, -2.0F, 0.0F, 0.1F, -2.0F, 0.0F, 0.1F, -2.0F, 0.0F, 0.1F, -2.0F, 0.0F, 2.0F, 2.0F, 0.0F, 0.1F, 1.0F, 0.0F, 0.1F, 1.0F, 0.2F, 2.0F, 2.0F, 0.2F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-3.0F, 0.0F, -3.0F, 8, 7, 6, 0.0F, -4.2F, 0.0F, 0.0F, -0.9F, 0.2F, 0.0F, -0.9F, 0.2F, 0.0F, -4.2F, 0.0F, 0.0F, 0.1F, -2.0F, 0.0F, 0.1F, -2.0F, 0.0F, 0.1F, -2.0F, 0.0F, 0.1F, -2.0F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-4.0F, 0.0F, -1.4F, 8, 9, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-3.5F, 5.8F, -3.5F, 3, 1, 2, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -1.2F, 0.0F, -0.5F, -1.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, 0.8F, 0.0F, -0.5F, 0.8F, 0.0F, -0.5F, -0.2F, 0.0F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(-1.5F, 6.8F, -3.5F, 3, 1, 2, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(0.5F, 5.8F, -3.5F, 3, 1, 2, 0.0F, -0.5F, -1.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -1.2F, 0.0F, -0.5F, 0.8F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, 0.8F, 0.0F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel = new ModelRendererTurbo[1];
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 193, 9, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-0.67F, -2.0F, -2.0F, 3, 12, 4, 0.0F, 0.45F, 0.1F, 0.45F, 0.85F, 0.1F, 0.45F, 0.85F, 0.1F, 0.45F, 0.45F, 0.1F, 0.45F, 0.45F, -0.5F, 0.45F, 1.45F, -0.5F, 0.45F, 1.45F, -0.5F, 0.45F, 0.45F, -0.5F, 0.45F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel = new ModelRendererTurbo[1];
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 129, 9, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-2.33F, -2.0F, -2.0F, 3, 12, 4, 0.0F, 0.85F, 0.1F, 0.45F, 0.45F, 0.1F, 0.45F, 0.45F, 0.1F, 0.45F, 0.85F, 0.1F, 0.45F, 1.45F, -0.5F, 0.45F, 0.45F, -0.5F, 0.45F, 0.45F, -0.5F, 0.45F, 1.45F, -0.5F, 0.45F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel = new ModelRendererTurbo[9];
    this.leftLegModel[0] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.leftLegModel[1] = new ModelRendererTurbo((ModelBase)this, 193, 1, this.textureX, this.textureY);
    this.leftLegModel[2] = new ModelRendererTurbo((ModelBase)this, 305, 1, this.textureX, this.textureY);
    this.leftLegModel[3] = new ModelRendererTurbo((ModelBase)this, 233, 1, this.textureX, this.textureY);
    this.leftLegModel[4] = new ModelRendererTurbo((ModelBase)this, 257, 1, this.textureX, this.textureY);
    this.leftLegModel[5] = new ModelRendererTurbo((ModelBase)this, 369, 1, this.textureX, this.textureY);
    this.leftLegModel[6] = new ModelRendererTurbo((ModelBase)this, 393, 1, this.textureX, this.textureY);
    this.leftLegModel[7] = new ModelRendererTurbo((ModelBase)this, 417, 1, this.textureX, this.textureY);
    this.leftLegModel[8] = new ModelRendererTurbo((ModelBase)this, 465, 1, this.textureX, this.textureY);
    this.leftLegModel[0].addShapeBox(-2.0F, 11.0F, -3.75F, 4, 1, 2, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.25F, -0.1F, 0.0F, -0.25F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.25F, -0.05F, 0.0F, -0.25F);
    this.leftLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[1].addShapeBox(-2.0F, 11.05F, -2.0F, 4, 2, 4, 0.0F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F);
    this.leftLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[2].addShapeBox(-0.5F, 10.2F, -4.0F, 1, 1, 4, 0.0F, -0.3F, -0.4F, -0.85F, -0.3F, -0.5F, -0.85F, -0.3F, -0.5F, -2.6F, -0.3F, -0.4F, -2.6F, -0.3F, 0.0F, -0.85F, -0.3F, 0.0F, -0.85F, -0.3F, 0.0F, -2.6F, -0.3F, 0.0F, -2.6F);
    this.leftLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[3].addShapeBox(-2.0F, 10.2F, -2.75F, 4, 1, 1, 0.0F, -0.25F, -0.5F, -0.3F, -2.1F, -0.5F, 0.3F, -2.1F, -0.4F, -0.9F, -0.25F, -0.4F, -0.3F, -0.25F, 0.0F, -0.3F, -2.1F, 0.0F, 0.3F, -2.1F, 0.0F, -0.9F, -0.25F, 0.0F, -0.3F);
    this.leftLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[4].addShapeBox(-2.0F, 10.2F, -2.75F, 4, 1, 1, 0.0F, -2.1F, -0.5F, 0.3F, -0.25F, -0.5F, -0.3F, -0.25F, -0.4F, -0.3F, -2.1F, -0.4F, -0.9F, -2.1F, 0.0F, 0.3F, -0.25F, 0.0F, -0.3F, -0.25F, 0.0F, -0.3F, -2.1F, 0.0F, -0.9F);
    this.leftLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[5].addShapeBox(-2.0F, -1.0F, -2.0F, 4, 8, 4, 0.0F, 0.0F, 0.0F, 0.05F, 0.0F, 0.0F, 0.05F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.45F, 0.5F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F, 0.0F, 0.0F, 0.15F);
    this.leftLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[6].addShapeBox(-2.0F, 7.0F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 0.0F, 0.45F, 0.5F, 0.0F, 0.55F, 0.5F, 0.0F, 0.55F, 0.0F, 0.0F, 0.15F, 0.0F, 0.0F, 0.05F, 0.0F, 0.0F, 0.05F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[7].addShapeBox(-2.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F);
    this.leftLegModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftLegModel[8].addShapeBox(-2.0F, -1.95F, -2.0F, 4, 14, 4, 0.0F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F);
    this.leftLegModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel = new ModelRendererTurbo[9];
    this.rightLegModel[0] = new ModelRendererTurbo((ModelBase)this, 153, 1, this.textureX, this.textureY);
    this.rightLegModel[1] = new ModelRendererTurbo((ModelBase)this, 169, 1, this.textureX, this.textureY);
    this.rightLegModel[2] = new ModelRendererTurbo((ModelBase)this, 185, 1, this.textureX, this.textureY);
    this.rightLegModel[3] = new ModelRendererTurbo((ModelBase)this, 209, 1, this.textureX, this.textureY);
    this.rightLegModel[4] = new ModelRendererTurbo((ModelBase)this, 289, 1, this.textureX, this.textureY);
    this.rightLegModel[5] = new ModelRendererTurbo((ModelBase)this, 321, 1, this.textureX, this.textureY);
    this.rightLegModel[6] = new ModelRendererTurbo((ModelBase)this, 345, 1, this.textureX, this.textureY);
    this.rightLegModel[7] = new ModelRendererTurbo((ModelBase)this, 441, 1, this.textureX, this.textureY);
    this.rightLegModel[8] = new ModelRendererTurbo((ModelBase)this, 489, 1, this.textureX, this.textureY);
    this.rightLegModel[0].addShapeBox(-2.0F, 11.0F, -3.75F, 4, 1, 2, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.25F, -0.1F, 0.0F, -0.25F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.25F, -0.05F, 0.0F, -0.25F);
    this.rightLegModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[1].addShapeBox(-2.0F, 11.05F, -2.0F, 4, 2, 4, 0.0F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F);
    this.rightLegModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[2].addShapeBox(-2.0F, 10.2F, -2.75F, 4, 1, 1, 0.0F, -0.25F, -0.5F, -0.3F, -2.1F, -0.5F, 0.3F, -2.1F, -0.4F, -0.9F, -0.25F, -0.4F, -0.3F, -0.25F, 0.0F, -0.3F, -2.1F, 0.0F, 0.3F, -2.1F, 0.0F, -0.9F, -0.25F, 0.0F, -0.3F);
    this.rightLegModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[3].addShapeBox(-2.0F, 10.2F, -2.75F, 4, 1, 1, 0.0F, -2.1F, -0.5F, 0.3F, -0.25F, -0.5F, -0.3F, -0.25F, -0.4F, -0.3F, -2.1F, -0.4F, -0.9F, -2.1F, 0.0F, 0.3F, -0.25F, 0.0F, -0.3F, -0.25F, 0.0F, -0.3F, -2.1F, 0.0F, -0.9F);
    this.rightLegModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[4].addShapeBox(-0.5F, 10.2F, -4.0F, 1, 1, 4, 0.0F, -0.3F, -0.4F, -0.85F, -0.3F, -0.5F, -0.85F, -0.3F, -0.5F, -2.6F, -0.3F, -0.4F, -2.6F, -0.3F, 0.0F, -0.85F, -0.3F, 0.0F, -0.85F, -0.3F, 0.0F, -2.6F, -0.3F, 0.0F, -2.6F);
    this.rightLegModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[5].addShapeBox(-2.0F, 8.0F, -2.0F, 4, 2, 4, 0.0F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F, 0.1F, 0.5F, 0.1F);
    this.rightLegModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[6].addShapeBox(-2.0F, 7.0F, -2.0F, 4, 1, 4, 0.0F, 0.5F, 0.0F, 0.55F, 0.0F, 0.0F, 0.45F, 0.0F, 0.0F, 0.15F, 0.5F, 0.0F, 0.55F, 0.0F, 0.0F, 0.05F, 0.0F, 0.0F, 0.05F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightLegModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[7].addShapeBox(-2.0F, -1.0F, -2.0F, 4, 8, 4, 0.0F, 0.0F, 0.0F, 0.05F, 0.0F, 0.0F, 0.05F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.55F, 0.0F, 0.0F, 0.45F, 0.0F, 0.0F, 0.15F, 0.5F, 0.0F, 0.55F);
    this.rightLegModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightLegModel[8].addShapeBox(-2.0F, -1.95F, -2.0F, 4, 14, 4, 0.0F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, 0.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F, 0.02F, -1.0F, 0.02F);
    this.rightLegModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel = new ModelRendererTurbo[4];
    this.skirtFrontModel[0] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.skirtFrontModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.skirtFrontModel[2] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.skirtFrontModel[3] = new ModelRendererTurbo((ModelBase)this, 145, 1, this.textureX, this.textureY);
    this.skirtFrontModel[0].addShapeBox(-4.0F, -2.5F, -2.5F, 8, 8, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.skirtFrontModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[1].addShapeBox(-4.2F, -2.5F, -2.5F, 1, 8, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.skirtFrontModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[2].addShapeBox(3.2F, -2.5F, -2.5F, 1, 8, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.skirtFrontModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtFrontModel[3].addShapeBox(-4.2F, -2.5F, -2.5F, 1, 8, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.skirtFrontModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.skirtRearModel = new ModelRendererTurbo[1];
    this.skirtRearModel[0] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.skirtRearModel[0].addShapeBox(-4.0F, -2.5F, 1.5F, 8, 8, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.skirtRearModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
