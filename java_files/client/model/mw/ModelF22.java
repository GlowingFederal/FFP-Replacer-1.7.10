package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelPlane;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelF22 extends ModelPlane {
  public ModelF22() {
    int textureX = 512;
    int textureY = 512;
    this.bodyModel = new ModelRendererTurbo[3];
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.bodyModel[0].addBox(-48.0F, 8.0F, -32.0F, 128, 16, 64);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 80, textureX, textureY);
    this.bodyModel[1].addBox(80.0F, 10.0F, -24.0F, 8, 12, 16);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 48, 80, textureX, textureY);
    this.bodyModel[2].addBox(80.0F, 10.0F, 8.0F, 8, 12, 16);
    this.noseModel = new ModelRendererTurbo[6];
    this.noseModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 108, textureX, textureY);
    this.noseModel[0].addShapeBox(-80.0F, 8.0F, -32.0F, 32, 16, 64, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F);
    this.noseModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 188, textureX, textureY);
    this.noseModel[1].addShapeBox(-80.0F, 24.0F, -12.0F, 64, 16, 24, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.noseModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 228, textureX, textureY);
    this.noseModel[2].addShapeBox(-112.0F, 8.0F, -12.0F, 32, 32, 24, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, -16.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, -4.0F);
    this.noseModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 284, textureX, textureY);
    this.noseModel[3].addShapeBox(-144.0F, 8.0F, -8.0F, 32, 16, 16, 0.0F, 0.0F, -4.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, -8.0F, 0.0F, -12.0F, -8.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -12.0F, -8.0F);
    this.noseModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 356, textureX, textureY);
    (this.noseModel[4]).flip = true;
    this.noseModel[4].addShapeBox(-112.0F, 8.0F, -12.0F, 32, 32, 24, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, -16.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, -4.0F);
    this.noseModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 316, textureX, textureY);
    (this.noseModel[5]).flip = true;
    this.noseModel[5].addShapeBox(-80.0F, 24.0F, -12.0F, 24, 16, 24, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.leftWingModel = new ModelRendererTurbo[1];
    this.leftWingModel[0] = new ModelRendererTurbo((ModelBase)this, 192, 80, textureX, textureY);
    this.leftWingModel[0].addShapeBox(-16.0F, 12.0F, 32.0F, 64, 4, 64, 0.0F, 0.0F, 0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, -48.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, -48.0F, 0.0F, 0.0F);
    this.rightWingModel = new ModelRendererTurbo[1];
    this.rightWingModel[0] = new ModelRendererTurbo((ModelBase)this, 192, 150, textureX, textureY);
    this.rightWingModel[0].addShapeBox(-16.0F, 12.0F, -96.0F, 64, 4, 64, 0.0F, -48.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -48.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, 32.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.tailModel = new ModelRendererTurbo[4];
    this.tailModel[0] = new ModelRendererTurbo((ModelBase)this, 192, 220, textureX, textureY);
    this.tailModel[0].addShapeBox(64.0F, 15.99F, -64.0F, 40, 4, 32, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.tailModel[1] = new ModelRendererTurbo((ModelBase)this, 192, 256, textureX, textureY);
    this.tailModel[1].addShapeBox(64.0F, 15.99F, 32.0F, 40, 4, 32, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F);
    this.tailModel[2] = new ModelRendererTurbo((ModelBase)this, 192, 300, textureX, textureY);
    this.tailModel[2].addShapeBox(48.0F, 16.0F, -36.0F, 48, 48, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, 16.0F, 0.0F, 0.0F, 16.0F, 0.0F, 0.0F, -16.0F, -16.0F, 0.0F, -16.0F);
    this.tailModel[3] = new ModelRendererTurbo((ModelBase)this, 296, 300, textureX, textureY);
    this.tailModel[3].addShapeBox(48.0F, 16.0F, 32.0F, 48, 48, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -16.0F, 0.0F, -16.0F, 0.0F, 0.0F, -16.0F, 0.0F, 0.0F, 16.0F, -16.0F, 0.0F, 16.0F);
    this.bodyWheelModel = new ModelRendererTurbo[2];
    this.bodyWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 416, 0, textureX, textureY);
    this.bodyWheelModel[0].addBox(-58.0F, 0.0F, -3.0F, 4, 8, 6);
    this.bodyWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 384, 0, textureX, textureY);
    this.bodyWheelModel[1].addBox(-62.0F, -10.0F, -2.0F, 12, 12, 4);
    this.tailWheelModel = new ModelRendererTurbo[4];
    for (int i = 0; i < 2; i++) {
      this.tailWheelModel[2 * i] = new ModelRendererTurbo((ModelBase)this, 416, 0, textureX, textureY);
      this.tailWheelModel[2 * i].addBox(58.0F, 0.0F, -27.0F + i * 48.0F, 4, 8, 6);
      this.tailWheelModel[2 * i + 1] = new ModelRendererTurbo((ModelBase)this, 384, 0, textureX, textureY);
      this.tailWheelModel[2 * i + 1].addBox(54.0F, -10.0F, -26.0F + i * 48.0F, 12, 12, 4);
    } 
    translateAll(0.0F, 0.0F, 0.0F);
  }
}
