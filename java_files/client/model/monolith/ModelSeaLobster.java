package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSeaLobster extends ModelCustomArmour {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelSeaLobster() {
    this.bodyModel = new ModelRendererTurbo[23];
    this.leftArmModel = new ModelRendererTurbo[3];
    this.rightArmModel = new ModelRendererTurbo[3];
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 17, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 97, 25, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 57, 17, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 0, 35, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 0, 35, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 0, 35, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 0, 35, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 0, 35, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 0, 35, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 0, 35, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 0, 35, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 0, 35, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 0, 35, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-4.0F, 0.0F, -2.0F, 8, 6, 4, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F, 0.1F, 0.0F, 0.1F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.0F, 11.0F, -2.0F, 8, 5, 4, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F, 0.8F, 0.5F, 0.8F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[2].addShapeBox(-4.0F, 3.0F, -2.0F, 4, 3, 4, 0.0F, 0.25F, 0.0F, 0.25F, 0.0F, 1.0F, 0.25F, 0.0F, 1.0F, 0.25F, 0.25F, 0.0F, 0.25F, 0.25F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.25F, 0.0F, 0.25F);
    this.bodyModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[3].addShapeBox(-4.0F, 4.5F, -2.0F, 4, 3, 4, 0.0F, 0.4F, 0.0F, 0.4F, 0.0F, 1.0F, 0.4F, 0.0F, 1.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F);
    this.bodyModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[4].addShapeBox(-4.0F, 6.0F, -2.0F, 4, 3, 4, 0.0F, 0.5F, 0.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
    this.bodyModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[5].addShapeBox(-4.0F, 7.5F, -2.0F, 4, 2, 4, 0.0F, 0.6F, 0.0F, 0.6F, 0.0F, 1.0F, 0.6F, 0.0F, 1.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.0F, -1.0F, 0.6F, 0.0F, -1.0F, 0.6F, 0.6F, 0.0F, 0.6F);
    this.bodyModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[6].addShapeBox(-4.0F, 9.0F, -2.0F, 4, 3, 4, 0.0F, 0.7F, 0.0F, 0.7F, 0.0F, 1.0F, 0.7F, 0.0F, 1.0F, 0.7F, 0.7F, 0.0F, 0.7F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F);
    this.bodyModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[7].addShapeBox(-4.0F, 11.0F, -2.0F, 8, 1, 4, 0.0F, 0.6F, 0.0F, 0.7F, 0.6F, 0.0F, 0.7F, 0.6F, 0.0F, 0.7F, 0.6F, 0.0F, 0.7F, 0.6F, 0.0F, 0.7F, 0.6F, 0.0F, 0.7F, 0.6F, 0.0F, 0.7F, 0.6F, 0.0F, 0.7F);
    this.bodyModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[8].addShapeBox(0.0F, 9.0F, -2.0F, 4, 3, 4, 0.0F, 0.0F, 1.0F, 0.7F, 0.7F, 0.0F, 0.7F, 0.7F, 0.0F, 0.7F, 0.0F, 1.0F, 0.7F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[9].addShapeBox(0.0F, 7.5F, -2.0F, 4, 2, 4, 0.0F, 0.0F, 1.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.0F, 1.0F, 0.6F, 0.0F, -1.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.6F, 0.0F, 0.6F, 0.0F, -1.0F, 0.6F);
    this.bodyModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[10].addShapeBox(0.0F, 6.0F, -2.0F, 4, 3, 4, 0.0F, 0.0F, 1.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 1.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F);
    this.bodyModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[11].addShapeBox(0.0F, 4.5F, -2.0F, 4, 3, 4, 0.0F, 0.0F, 1.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.0F, 1.0F, 0.4F, 0.0F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.4F, 0.0F, 0.4F, 0.0F, 0.0F, 0.4F);
    this.bodyModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[12].addShapeBox(0.0F, 3.0F, -2.0F, 4, 3, 4, 0.0F, 0.0F, 1.0F, 0.25F, 0.25F, 0.0F, 0.25F, 0.25F, 0.0F, 0.25F, 0.0F, 1.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.25F, 0.0F, 0.25F, 0.25F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F);
    this.bodyModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[13].addShapeBox(-4.0F, 8.8F, -2.0F, 4, 1, 4, 0.0F, 0.8F, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.6F, -0.5F, 0.6F, 0.0F, -1.5F, 0.6F, 0.0F, -1.5F, 0.6F, 0.6F, -0.5F, 0.6F);
    this.bodyModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[14].addShapeBox(-4.0F, 5.8F, -2.0F, 4, 1, 4, 0.0F, 0.8F, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.6F, -0.5F, 0.6F, 0.0F, -1.5F, 0.6F, 0.0F, -1.5F, 0.6F, 0.6F, -0.5F, 0.6F);
    this.bodyModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[15].addShapeBox(-4.0F, 2.8F, -2.0F, 4, 1, 4, 0.0F, 0.8F, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.6F, -0.5F, 0.6F, 0.0F, -1.5F, 0.6F, 0.0F, -1.5F, 0.6F, 0.6F, -0.5F, 0.6F);
    this.bodyModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[16].addShapeBox(-4.0F, 4.3F, -2.0F, 4, 1, 4, 0.0F, 0.8F, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.6F, -0.5F, 0.6F, 0.0F, -1.5F, 0.6F, 0.0F, -1.5F, 0.6F, 0.6F, -0.5F, 0.6F);
    this.bodyModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[17].addShapeBox(-4.0F, 7.3F, -2.0F, 4, 1, 4, 0.0F, 0.8F, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.6F, -0.5F, 0.6F, 0.0F, -1.5F, 0.6F, 0.0F, -1.5F, 0.6F, 0.6F, -0.5F, 0.6F);
    this.bodyModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[18].addShapeBox(0.0F, 7.3F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, -1.5F, 0.6F, 0.6F, -0.5F, 0.6F, 0.6F, -0.5F, 0.6F, 0.0F, -1.5F, 0.6F);
    this.bodyModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[19].addShapeBox(0.0F, 8.8F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, -1.5F, 0.6F, 0.6F, -0.5F, 0.6F, 0.6F, -0.5F, 0.6F, 0.0F, -1.5F, 0.6F);
    this.bodyModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[20].addShapeBox(0.0F, 5.8F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, -1.5F, 0.6F, 0.6F, -0.5F, 0.6F, 0.6F, -0.5F, 0.6F, 0.0F, -1.5F, 0.6F);
    this.bodyModel[20].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[21].addShapeBox(0.0F, 4.3F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, -1.5F, 0.6F, 0.6F, -0.5F, 0.6F, 0.6F, -0.5F, 0.6F, 0.0F, -1.5F, 0.6F);
    this.bodyModel[21].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[22].addShapeBox(0.0F, 2.8F, -2.0F, 4, 1, 4, 0.0F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.0F, 1.0F, 0.8F, 0.0F, -1.5F, 0.6F, 0.6F, -0.5F, 0.6F, 0.6F, -0.5F, 0.6F, 0.0F, -1.5F, 0.6F);
    this.bodyModel[22].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.leftArmModel[1] = new ModelRendererTurbo((ModelBase)this, 97, 9, this.textureX, this.textureY);
    this.leftArmModel[2] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-1.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[1].addShapeBox(-1.5F, -2.2F, -2.0F, 3, 4, 4, 0.0F, -1.0F, 0.5F, 0.8F, 2.0F, 0.0F, 0.8F, 2.0F, 0.0F, 0.8F, -1.0F, 0.5F, 0.8F, 0.0F, -1.5F, 1.2F, -0.7F, -0.5F, 0.8F, -0.7F, -0.5F, 0.8F, 0.0F, -1.5F, 1.2F);
    this.leftArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.leftArmModel[2].addShapeBox(-1.0F, -0.7F, -2.0F, 4, 2, 4, 0.0F, -0.7F, 0.2F, 0.2F, 0.3F, 1.5F, 0.2F, 0.3F, 1.5F, 0.2F, -0.7F, 0.2F, 0.2F, -1.0F, -0.2F, 0.4F, 1.0F, -1.0F, 0.4F, 1.0F, -1.0F, 0.4F, -1.0F, -0.2F, 0.4F);
    this.leftArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.rightArmModel[1] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.rightArmModel[2] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-3.0F, -2.0F, -2.0F, 4, 7, 4, 0.0F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F, 0.1F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[1].addShapeBox(-1.5F, -2.2F, -2.0F, 3, 4, 4, 0.0F, 2.0F, 0.0F, 0.8F, -1.0F, 0.5F, 0.8F, -1.0F, 0.5F, 0.8F, 2.0F, 0.0F, 0.8F, -0.7F, -0.5F, 0.8F, 0.0F, -1.5F, 1.2F, 0.0F, -1.5F, 1.2F, -0.7F, -0.5F, 0.8F);
    this.rightArmModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.rightArmModel[2].addShapeBox(-3.0F, -0.7F, -2.0F, 4, 2, 4, 0.0F, 0.3F, 1.5F, 0.2F, -0.7F, 0.2F, 0.2F, -0.7F, 0.2F, 0.2F, 0.3F, 1.5F, 0.2F, 1.0F, -1.0F, 0.4F, -1.0F, -0.2F, 0.4F, -1.0F, -0.2F, 0.4F, 1.0F, -1.0F, 0.4F);
    this.rightArmModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
