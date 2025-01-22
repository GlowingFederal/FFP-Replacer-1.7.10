package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelPlane;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelChinook extends ModelPlane {
  public ModelChinook() {
    int textureX = 1024;
    int textureY = 512;
    this.bodyModel = new ModelRendererTurbo[9];
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.bodyModel[0].addBox(-96.0F, 8.0F, -32.0F, 192, 2, 64);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 132, textureX, textureY);
    this.bodyModel[1].addBox(-96.0F, 10.0F, -32.0F, 192, 64, 2);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 198, textureX, textureY);
    this.bodyModel[2].addBox(-96.0F, 10.0F, 30.0F, 192, 64, 2);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 66, textureX, textureY);
    this.bodyModel[3].addBox(-96.0F, 74.0F, -32.0F, 192, 2, 64);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 264, textureX, textureY);
    this.bodyModel[4].addShapeBox(-96.0F, 10.0F, -48.0F, 192, 32, 16, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 312, textureX, textureY);
    this.bodyModel[5].addShapeBox(-96.0F, 10.0F, 32.0F, 192, 32, 16, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, -8.0F, 0.0F, -8.0F, -8.0F, 0.0F);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 512, 314, textureX, textureY);
    this.bodyModel[6].addBox(-92.0F, 32.0F, -30.0F, 184, 2, 16);
    this.bodyModel[7] = new ModelRendererTurbo((ModelBase)this, 512, 332, textureX, textureY);
    this.bodyModel[7].addBox(-92.0F, 32.0F, 14.0F, 184, 2, 16);
    this.bodyModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.bodyModel[8].addBox(-96.0F, 24.0F, -32.0F, 192, 2, 64);
    this.bodyWheelModel = new ModelRendererTurbo[12];
    for (int k = 0; k < 2; k++) {
      for (int m = 0; m < 2; m++) {
        this.bodyWheelModel[3 * k + 6 * m] = new ModelRendererTurbo((ModelBase)this, 624, 32, textureX, textureY);
        this.bodyWheelModel[3 * k + 6 * m].addBox(0.0F, -8.0F, -2.0F, 4, 16, 4);
        this.bodyWheelModel[3 * k + 6 * m].func_78793_a(-80.0F * ((k == 0) ? true : -1), 0.0F, -24.0F * ((m == 0) ? true : -1));
        this.bodyWheelModel[1 + 3 * k + 6 * m] = new ModelRendererTurbo((ModelBase)this, 640, 12, textureX, textureY);
        this.bodyWheelModel[1 + 3 * k + 6 * m].addBox(-6.0F, -14.0F, -4.0F, 16, 16, 3);
        this.bodyWheelModel[1 + 3 * k + 6 * m].func_78793_a(-80.0F * ((k == 0) ? true : -1), 0.0F, -24.0F * ((m == 0) ? true : -1));
        this.bodyWheelModel[2 + 3 * k + 6 * m] = new ModelRendererTurbo((ModelBase)this, 640, 12, textureX, textureY);
        this.bodyWheelModel[2 + 3 * k + 6 * m].addBox(-6.0F, -14.0F, 1.0F, 16, 16, 3);
        this.bodyWheelModel[2 + 3 * k + 6 * m].func_78793_a(-80.0F * ((k == 0) ? true : -1), 0.0F, -24.0F * ((m == 0) ? true : -1));
      } 
    } 
    this.noseModel = new ModelRendererTurbo[17];
    this.noseModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 360, textureX, textureY);
    this.noseModel[0].addShapeBox(-128.0F, 8.0F, -32.0F, 32, 2, 64, 0.0F, 0.0F, -4.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, -8.0F, 0.0F, 4.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 4.0F, -8.0F);
    this.noseModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 426, textureX, textureY);
    this.noseModel[1].addShapeBox(-128.0F, 10.0F, -32.0F, 32, 64, 2, 0.0F, 0.0F, -4.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 8.0F, -8.0F, -4.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, -4.0F, 8.0F);
    this.noseModel[2] = new ModelRendererTurbo((ModelBase)this, 68, 426, textureX, textureY);
    this.noseModel[2].addShapeBox(-128.0F, 10.0F, 30.0F, 32, 64, 2, 0.0F, 0.0F, -4.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, -8.0F, -8.0F, -4.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, -4.0F, -8.0F);
    this.noseModel[3] = new ModelRendererTurbo((ModelBase)this, 192, 360, textureX, textureY);
    this.noseModel[3].addShapeBox(-128.0F, 74.0F, -32.0F, 32, 2, 64, 0.0F, -8.0F, 4.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, 4.0F, -8.0F, -8.0F, -4.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, -4.0F, -8.0F);
    this.noseModel[4] = new ModelRendererTurbo((ModelBase)this, 136, 426, textureX, textureY);
    this.noseModel[4].addShapeBox(-125.75F, 44.0F, -24.0F, 2, 28, 48, 0.0F, 0.0F, 0.25F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, -1.0F, -4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F);
    this.noseModel[5] = new ModelRendererTurbo((ModelBase)this, 236, 426, textureX, textureY);
    this.noseModel[5].addShapeBox(-152.0F, 12.0F, -24.0F, 24, 2, 48, 0.0F, 0.0F, -4.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, -8.0F, 0.0F, 4.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 4.0F, -8.0F);
    this.noseModel[6] = new ModelRendererTurbo((ModelBase)this, 128, 360, textureX, textureY);
    this.noseModel[6].addShapeBox(-152.0F, 14.0F, -24.0F, 24, 28, 2, 0.0F, 0.0F, -4.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 8.0F, 0.0F, -4.0F, -8.0F, 4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F, -4.0F, 8.0F);
    this.noseModel[7] = new ModelRendererTurbo((ModelBase)this, 128, 390, textureX, textureY);
    this.noseModel[7].addShapeBox(-152.0F, 14.0F, 22.0F, 24, 28, 2, 0.0F, 0.0F, -4.0F, 8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, -8.0F, 0.0F, -4.0F, 8.0F, 4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F, -4.0F, -8.0F);
    this.noseModel[8] = new ModelRendererTurbo((ModelBase)this, 320, 360, textureX, textureY);
    this.noseModel[8].addShapeBox(-152.0F, 42.0F, -24.0F, 24, 2, 48, 0.0F, 0.0F, 4.0F, -8.0F, 4.0F, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 4.0F, -8.0F, 0.0F, -4.0F, -8.0F, 4.25F, 0.0F, 0.0F, 4.25F, 0.0F, 0.0F, 0.0F, -4.0F, -8.0F);
    this.noseModel[9] = new ModelRendererTurbo((ModelBase)this, 448, 0, textureX, textureY);
    this.noseModel[9].addShapeBox(-152.0F, 18.0F, -14.0F, 2, 20, 28, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.noseModel[10] = new ModelRendererTurbo((ModelBase)this, 512, 0, textureX, textureY);
    this.noseModel[10].addShapeBox(-96.0F, 76.0F, -4.0F, 48, 24, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.noseModel[11] = new ModelRendererTurbo((ModelBase)this, 512, 32, textureX, textureY);
    this.noseModel[11].addShapeBox(-120.0F, 76.0F, -4.0F, 24, 24, 8, 0.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 4.0F, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F);
    this.noseModel[12] = new ModelRendererTurbo((ModelBase)this, 512, 252, textureX, textureY);
    this.noseModel[12].addShapeBox(-124.0F, 24.0F, -30.0F, 28, 2, 60, 0.0F, 0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F, 0.0F, 0.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -8.0F);
    this.noseModel[13] = new ModelRendererTurbo((ModelBase)this, 688, 196, textureX, textureY);
    this.noseModel[13].addBox(-112.0F, 26.0F, 8.0F, 16, 2, 16);
    this.noseModel[14] = new ModelRendererTurbo((ModelBase)this, 688, 196, textureX, textureY);
    this.noseModel[14].addBox(-112.0F, 26.0F, -24.0F, 16, 2, 16);
    this.noseModel[15] = new ModelRendererTurbo((ModelBase)this, 688, 214, textureX, textureY);
    this.noseModel[15].addBox(-96.0F, 26.0F, 8.0F, 2, 24, 16);
    this.noseModel[16] = new ModelRendererTurbo((ModelBase)this, 688, 214, textureX, textureY);
    this.noseModel[16].addBox(-96.0F, 26.0F, -24.0F, 2, 24, 16);
    this.tailModel = new ModelRendererTurbo[2];
    this.tailModel[0] = new ModelRendererTurbo((ModelBase)this, 512, 64, textureX, textureY);
    this.tailModel[0].addShapeBox(96.0F, 8.0F, -32.0F, 64, 68, 64, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -48.0F, -24.0F, 0.0F, -48.0F, -24.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -24.0F, 0.0F, 0.0F, -24.0F, 0.0F, 0.0F, 0.0F);
    this.tailModel[1] = new ModelRendererTurbo((ModelBase)this, 512, 196, textureX, textureY);
    this.tailModel[1].addShapeBox(80.0F, 76.0F, -4.0F, 80, 48, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F);
    this.heliMainRotorModels = new ModelRendererTurbo[2][7];
    for (int j = 0; j < 2; j++) {
      this.heliMainRotorModels[j][0] = new ModelRendererTurbo((ModelBase)this, 624, 0, textureX, textureY);
      this.heliMainRotorModels[j][0].addBox(-2.0F, 124.0F, -2.0F, 4, 8, 4);
      for (int m = 0; m < 3; m++) {
        this.heliMainRotorModels[j][m * 2 + 1] = new ModelRendererTurbo((ModelBase)this, 640, 0, textureX, textureY);
        this.heliMainRotorModels[j][m * 2 + 1].addBox(0.0F, 132.0F, -2.0F, 8, 1, 4);
        (this.heliMainRotorModels[j][m * 2 + 1]).field_78796_g = 1.0471976F * m * 2.0F;
        this.heliMainRotorModels[j][m * 2 + 2] = new ModelRendererTurbo((ModelBase)this, 664, 0, textureX, textureY);
        this.heliMainRotorModels[j][m * 2 + 2].addBox(8.0F, 132.0F, -2.0F, 128, 1, 8);
        (this.heliMainRotorModels[j][m * 2 + 2]).field_78796_g = 1.0471976F * m * 2.0F;
      } 
    } 
    int i;
    for (i = 0; i < 7; i++)
      this.heliMainRotorModels[0][i].func_78793_a(-84.0F, -24.0F, 0.0F); 
    for (i = 0; i < 7; i++)
      this.heliMainRotorModels[1][i].func_78793_a(128.0F, 0.0F, 0.0F); 
    this.heliMainRotorOrigins = new Vector3f[] { new Vector3f(-5.25F, 3.0F, 0.0F), new Vector3f(8.0F, 3.0F, 0.0F) };
    this.heliRotorSpeeds = new float[] { 1.0F, 1.0F };
    translateAll(0.0F, -15.0F, 0.0F);
  }
}
