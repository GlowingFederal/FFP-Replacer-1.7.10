package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelMingGunnerBelt extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 32;
  
  public ModelMingGunnerBelt() {
    this.bodyModel = new ModelRendererTurbo[27];
    this.rightArmModel = new ModelRendererTurbo[5];
    initbodyModel_1();
    initrightArmModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[23] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[24] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.bodyModel[25] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[26] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 10.0F, -2.5F, 8, 1, 5, 0.0F, 0.55F, -0.1F, 0.25F, 0.55F, -0.1F, 0.25F, 0.55F, -0.1F, 0.25F, 0.55F, -0.1F, 0.25F, 0.55F, -0.3F, 0.25F, 0.55F, -0.3F, 0.25F, 0.55F, -0.3F, 0.25F, 0.55F, -0.3F, 0.25F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 9.5F, -4.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.6F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-3.4F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 9.0F, -4.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-5.5F, 10.0F, -3.5F, 1, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.4F, 0.0F, 0.0F, 0.7F, 0.0F, -0.3F, 0.5F, 0.0F, 0.3F, 0.0F, 0.4F, 0.0F, 0.0F, 0.3F, 0.0F, 1.2F, 0.0F, -0.3F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-5.5F, 10.0F, -3.5F, 1, 3, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.4F, 0.0F, -1.0F, 0.7F, 0.0F, -1.3F, 0.5F, -2.0F, 0.3F, 0.0F, -1.6F, 0.0F, 0.0F, -1.7F, -1.0F, 1.2F, -2.0F, -1.3F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-2.6F, 9.5F, -4.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(-3.2F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(-2.0F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(-2.6F, 9.0F, -4.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(-1.2F, 9.5F, -4.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(-1.8F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-0.6F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-1.2F, 9.0F, -4.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(0.2F, 9.5F, -4.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-0.4F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(0.8F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(0.2F, 9.0F, -4.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(1.6F, 9.5F, -4.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(1.0F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(2.2F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(1.6F, 9.0F, -4.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[23].addShapeBox(3.0F, 9.5F, -4.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F, 0.0F, 0.3F, 0.2F);
    this.bodyModel[23].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[24].addShapeBox(2.4F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F);
    this.bodyModel[24].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[25].addShapeBox(3.6F, 9.5F, -4.0F, 1, 2, 1, 0.0F, -0.4F, 0.0F, 0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, -0.2F, -0.4F, 0.0F, 0.2F, -0.4F, 0.3F, 0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, -0.2F, -0.4F, 0.3F, 0.2F);
    this.bodyModel[25].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[26].addShapeBox(3.0F, 9.0F, -4.0F, 1, 1, 1, 0.0F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F);
    this.bodyModel[26].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.rightArmModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.rightArmModel[4] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, 2.0F, -2.0F, 4, 1, 4, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, -0.6F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, 0.8F, 0.5F, 0.5F, -0.6F, 0.5F, 0.5F, 0.2F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, -1.2F, 0.5F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-3.0F, 3.0F, -2.0F, 4, 1, 4, 0.0F, 0.5F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, -1.2F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, -0.4F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, 0.8F, 0.5F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-3.0F, 4.5F, -2.0F, 4, 1, 4, 0.0F, 0.5F, -0.2F, 0.5F, 0.5F, -0.4F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, -0.4F, 0.5F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[3].addShapeBox(-3.0F, 5.5F, -2.0F, 4, 1, 4, 0.0F, 0.5F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, -0.4F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, -0.4F, 0.5F, 0.5F, -0.2F, 0.5F, 0.5F, 0.0F, 0.5F);
    this.rightArmModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].addShapeBox(-3.7F, 1.2F, -1.5F, 1, 1, 3, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.3F, 0.0F, 0.0F, 0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.rightArmModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
