package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSteamFrigate extends ModelVehicle {
  int textureX = 256;
  
  int textureY = 256;
  
  public ModelSteamFrigate() {
    this.bodyModel = new ModelRendererTurbo[23];
    this.frontWheelModel = new ModelRendererTurbo[2];
    initbodyModel_1();
    initfrontWheelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 81, 49, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 153, 49, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 97, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 201, 1, this.textureX, this.textureY);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 137, this.textureX, this.textureY);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 73, 97, this.textureX, this.textureY);
    this.bodyModel[9] = new ModelRendererTurbo((ModelBase)this, 121, 97, this.textureX, this.textureY);
    this.bodyModel[10] = new ModelRendererTurbo((ModelBase)this, 201, 17, this.textureX, this.textureY);
    this.bodyModel[11] = new ModelRendererTurbo((ModelBase)this, 169, 97, this.textureX, this.textureY);
    this.bodyModel[12] = new ModelRendererTurbo((ModelBase)this, 1, 169, this.textureX, this.textureY);
    this.bodyModel[13] = new ModelRendererTurbo((ModelBase)this, 249, 1, this.textureX, this.textureY);
    this.bodyModel[14] = new ModelRendererTurbo((ModelBase)this, 57, 49, this.textureX, this.textureY);
    this.bodyModel[15] = new ModelRendererTurbo((ModelBase)this, 225, 25, this.textureX, this.textureY);
    this.bodyModel[16] = new ModelRendererTurbo((ModelBase)this, 129, 147, this.textureX, this.textureY);
    this.bodyModel[17] = new ModelRendererTurbo((ModelBase)this, 201, 129, this.textureX, this.textureY);
    this.bodyModel[18] = new ModelRendererTurbo((ModelBase)this, 73, 129, this.textureX, this.textureY);
    this.bodyModel[19] = new ModelRendererTurbo((ModelBase)this, 225, 25, this.textureX, this.textureY);
    this.bodyModel[20] = new ModelRendererTurbo((ModelBase)this, 129, 147, this.textureX, this.textureY);
    this.bodyModel[21] = new ModelRendererTurbo((ModelBase)this, 225, 25, this.textureX, this.textureY);
    this.bodyModel[22] = new ModelRendererTurbo((ModelBase)this, 129, 147, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 82, 13, 28, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[0].func_78793_a(-37.5F, -7.2F, -14.0F);
    this.bodyModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 11, 13, 28, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[1].func_78793_a(44.5F, -7.2F, -14.0F);
    this.bodyModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 6, 15, 28, 0.0F, 0.0F, -1.0F, 0.0F, 12.0F, 1.0F, -9.0F, 12.0F, 1.0F, -9.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -11.0F, -0.5F, 0.0F, -11.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[2].func_78793_a(55.5F, -9.2F, -14.0F);
    this.bodyModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 6, 13, 28, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
    this.bodyModel[3].func_78793_a(-43.5F, -7.2F, -14.0F);
    this.bodyModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 10, 13, 24, 0.0F, 0.0F, 1.5F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.5F, -4.0F, 0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F);
    this.bodyModel[4].func_78793_a(-53.5F, -7.2F, -12.0F);
    this.bodyModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 3, 14, 8, 0.0F, 5.0F, 0.5F, -3.5F, 0.0F, 0.5F, 4.0F, 0.0F, 0.5F, 4.0F, 5.0F, 0.5F, -3.5F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.5F);
    this.bodyModel[5].func_78793_a(-56.5F, -8.2F, -4.0F);
    this.bodyModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 3, 3, 8, 0.0F, 0.0F, 0.0F, -3.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.5F, 0.0F, -0.9F, -3.5F, 0.0F, -0.5F, -2.5F, 0.0F, -0.5F, -2.5F, 0.0F, -0.9F, -3.5F);
    this.bodyModel[6].func_78793_a(-56.5F, 5.8F, -4.0F);
    this.bodyModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 82, 4, 28, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, -10.0F, 0.0F, 0.5F, -10.0F, 0.0F, 0.5F, -10.0F, 0.0F, 0.5F, -10.0F);
    this.bodyModel[7].func_78793_a(-37.5F, 5.8F, -14.0F);
    this.bodyModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 6, 4, 28, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -11.0F, 0.0F, 0.5F, -10.0F, 0.0F, 0.5F, -10.0F, 0.0F, 0.0F, -11.0F);
    this.bodyModel[8].func_78793_a(-43.5F, 5.8F, -14.0F);
    this.bodyModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 10, 4, 24, 0.0F, 0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, 0.0F, -1.5F, -10.5F, 0.0F, 0.0F, -9.0F, 0.0F, 0.0F, -9.0F, 0.0F, -1.5F, -10.5F);
    this.bodyModel[9].func_78793_a(-53.5F, 5.8F, -12.0F);
    this.bodyModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 19, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[10].func_78793_a(-56.5F, 5.3F, -0.5F);
    this.bodyModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 11, 4, 28, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.5F, -10.0F, 0.0F, 0.5F, -12.0F, 0.0F, 0.5F, -12.0F, 0.0F, 0.5F, -10.0F);
    this.bodyModel[11].func_78793_a(44.5F, 5.8F, -14.0F);
    this.bodyModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 6, 5, 28, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -11.0F, -0.5F, 0.0F, -11.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -12.0F, -3.5F, -2.0F, -13.5F, -3.5F, -2.0F, -13.5F, 0.0F, -0.5F, -12.0F);
    this.bodyModel[12].func_78793_a(55.5F, 5.8F, -14.0F);
    this.bodyModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 1, 12, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.bodyModel[13].func_78793_a(-63.0F, -19.2F, -0.5F);
    (this.bodyModel[13]).field_78808_h = 0.2268928F;
    this.bodyModel[14].addShapeBox(0.3F, 0.0F, 0.0F, 20, 12, 1, 0.0F, -13.0F, 0.0F, -0.4F, -0.3F, 0.0F, -0.4F, -0.3F, 0.0F, -0.4F, -13.0F, 0.0F, -0.4F, -13.0F, -8.0F, -0.4F, -0.3F, -8.0F, -0.4F, -0.3F, -8.0F, -0.4F, -13.0F, -8.0F, -0.4F);
    this.bodyModel[14].func_78793_a(-82.0F, -14.2F, -0.5F);
    (this.bodyModel[14]).field_78808_h = 0.2268928F;
    this.bodyModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 2, 71, 2, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[15].func_78793_a(0.0F, -78.0F, -1.0F);
    this.bodyModel[16].addShapeBox(2.0F, 0.0F, -30.0F, 1, 41, 63, 0.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F);
    this.bodyModel[16].func_78793_a(0.0F, -65.0F, 0.0F);
    this.bodyModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 6, 24, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[17].func_78793_a(19.5F, -30.2F, -3.0F);
    this.bodyModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 40, 3, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[18].func_78793_a(50.0F, -8.0F, -1.5F);
    (this.bodyModel[18]).field_78808_h = 0.15707964F;
    this.bodyModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 2, 71, 2, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[19].func_78793_a(42.0F, -78.0F, -1.0F);
    this.bodyModel[20].addShapeBox(2.0F, 0.0F, -30.0F, 1, 41, 63, 0.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F);
    this.bodyModel[20].func_78793_a(42.0F, -65.0F, 0.0F);
    this.bodyModel[21].addShapeBox(0.0F, 0.0F, 0.0F, 2, 71, 2, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[21].func_78793_a(-35.0F, -78.0F, -1.0F);
    this.bodyModel[22].addShapeBox(2.0F, 0.0F, -30.0F, 1, 41, 63, 0.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, -6.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F);
    this.bodyModel[22].func_78793_a(-35.0F, -65.0F, 0.0F);
  }
  
  private void initfrontWheelModel_1() {
    this.frontWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 217, 1, this.textureX, this.textureY);
    this.frontWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 233, 1, this.textureX, this.textureY);
    this.frontWheelModel[0].addShapeBox(0.0F, 0.0F, -0.5F, 5, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.frontWheelModel[0].func_78793_a(-61.5F, 5.3F, 0.0F);
    this.frontWheelModel[1].addShapeBox(0.0F, 0.0F, -0.5F, 5, 2, 1, 0.0F, -4.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.frontWheelModel[1].func_78793_a(-61.5F, 3.3F, 0.0F);
  }
}
