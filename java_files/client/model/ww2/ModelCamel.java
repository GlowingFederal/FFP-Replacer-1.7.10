package com.flansmod.client.model.ww2;

import com.flansmod.client.model.ModelPlane;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelCamel extends ModelPlane {
  public ModelCamel() {
    int textureX = 128;
    int textureY = 128;
    this.propellerModels = new ModelRendererTurbo[1][3];
    this.propellerModels[0][0] = new ModelRendererTurbo((ModelBase)this, 56, 8, textureX, textureY);
    this.propellerModels[0][1] = new ModelRendererTurbo((ModelBase)this, 56, 8, textureX, textureY);
    this.propellerModels[0][2] = new ModelRendererTurbo((ModelBase)this, 56, 8, textureX, textureY);
    this.propellerModels[0][0].func_78790_a(0.0F, -7.0F, -1.0F, 2, 5, 2, 0.0F);
    this.propellerModels[0][1].func_78790_a(0.0F, -7.0F, -1.0F, 2, 5, 2, 0.0F);
    this.propellerModels[0][2].func_78790_a(0.0F, -7.0F, -1.0F, 2, 5, 2, 0.0F);
    this.propellerModels[0][0].func_78793_a(-27.0F, 0.0F, 0.0F);
    this.propellerModels[0][1].func_78793_a(-27.0F, 0.0F, 0.0F);
    this.propellerModels[0][2].func_78793_a(-27.0F, 0.0F, 0.0F);
    this.yawFlapModel = new ModelRendererTurbo[1];
    this.yawFlapModel[0] = new ModelRendererTurbo((ModelBase)this, 104, 0, textureX, textureY);
    this.yawFlapModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 10, 10, 2, 0.0F);
    this.yawFlapModel[0].setPosition(40.0F, -12.0F, -1.0F);
    this.pitchFlapLeftModel = new ModelRendererTurbo[1];
    this.pitchFlapLeftModel[0] = new ModelRendererTurbo((ModelBase)this, 104, 0, textureX, textureY);
    this.pitchFlapLeftModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 10, 15, 2, 0.0F);
    (this.pitchFlapLeftModel[0]).field_78795_f = 1.570796F;
    this.pitchFlapLeftModel[0].setPosition(40.0F, 3.0F, -15.0F);
    this.pitchFlapRightModel = new ModelRendererTurbo[1];
    this.pitchFlapRightModel[0] = new ModelRendererTurbo((ModelBase)this, 104, 0, textureX, textureY);
    this.pitchFlapRightModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 10, 15, 2, 0.0F);
    (this.pitchFlapRightModel[0]).field_78795_f = 1.570796F;
    this.pitchFlapRightModel[0].setPosition(40.0F, 3.0F, 0.0F);
    this.bodyModel = new ModelRendererTurbo[5];
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 8, textureX, textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    byte length = 24;
    byte sidePieceHeight = 6;
    byte width = 20;
    byte boatDepth = 4;
    this.bodyModel[0].func_78790_a((-length / 2), (-width / 2 + 2), -3.0F, length, width - 4, 4, 0.0F);
    this.bodyModel[0].setPosition(0.0F, boatDepth, 0.0F);
    this.bodyModel[1].func_78790_a((-length / 2 + 2), (-sidePieceHeight - 1), -1.0F, length - 4, sidePieceHeight, 2, 0.0F);
    this.bodyModel[1].setPosition((-length / 2 + 1), boatDepth, 0.0F);
    this.bodyModel[2].func_78790_a((-length / 2 + 2), (-sidePieceHeight - 1), -1.0F, length - 4, sidePieceHeight, 2, 0.0F);
    this.bodyModel[2].setPosition((length / 2 - 1), boatDepth, 0.0F);
    this.bodyModel[3].func_78790_a((-length / 2 + 2), (-sidePieceHeight - 1), -1.0F, length - 4, sidePieceHeight, 2, 0.0F);
    this.bodyModel[3].setPosition(0.0F, boatDepth, (-width / 2 + 1));
    this.bodyModel[4].func_78790_a((-length / 2 + 2), (-sidePieceHeight - 1), -1.0F, length - 4, sidePieceHeight, 2, 0.0F);
    this.bodyModel[4].setPosition(0.0F, boatDepth, (width / 2 - 1));
    (this.bodyModel[0]).field_78795_f = 1.570796F;
    (this.bodyModel[1]).field_78796_g = 4.712389F;
    (this.bodyModel[2]).field_78796_g = 1.570796F;
    (this.bodyModel[3]).field_78796_g = 3.141593F;
    this.noseModel = new ModelRendererTurbo[4];
    this.noseModel[0] = new ModelRendererTurbo((ModelBase)this, 44, 0, textureX, textureY);
    this.noseModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 64, textureX, textureY);
    this.noseModel[2] = new ModelRendererTurbo((ModelBase)this, 12, 32, textureX, textureY);
    this.noseModel[3] = new ModelRendererTurbo((ModelBase)this, 12, 32, textureX, textureY);
    this.noseModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 4, 4, 4, 0.0F);
    this.noseModel[0].setPosition(-28.0F, -2.0F, -2.0F);
    this.noseModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 12, 10, 18, 0.0F);
    this.noseModel[1].setPosition(-24.0F, -3.0F, -9.0F);
    this.noseModel[2].func_78790_a(-24.0F, -5.0F, 2.0F, 14, 2, 2, 0.0F);
    this.noseModel[3].func_78790_a(-24.0F, -5.0F, -4.0F, 14, 2, 2, 0.0F);
    this.bodyWheelModel = new ModelRendererTurbo[4];
    this.bodyWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 32, textureX, textureY);
    this.bodyWheelModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 32, textureX, textureY);
    this.bodyWheelModel[2] = new ModelRendererTurbo((ModelBase)this, 56, 15, textureX, textureY);
    this.bodyWheelModel[3] = new ModelRendererTurbo((ModelBase)this, 56, 15, textureX, textureY);
    this.bodyWheelModel[0].func_78790_a(-4.0F, 11.0F, 5.0F, 4, 4, 2, 0.0F);
    this.bodyWheelModel[1].func_78790_a(-4.0F, 11.0F, -7.0F, 4, 4, 2, 0.0F);
    this.bodyWheelModel[2].func_78790_a(-3.0F, 6.0F, 5.0F, 2, 5, 2, 0.0F);
    this.bodyWheelModel[3].func_78790_a(-3.0F, 6.0F, -7.0F, 2, 5, 2, 0.0F);
    this.rightWingModel = new ModelRendererTurbo[2];
    this.rightWingModel[0] = new ModelRendererTurbo((ModelBase)this, 64, 0, textureX, textureY);
    this.rightWingModel[1] = new ModelRendererTurbo((ModelBase)this, 56, 15, textureX, textureY);
    this.rightWingModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 18, 41, 2, 0.0F);
    (this.rightWingModel[0]).field_78795_f = -1.570796F;
    this.rightWingModel[0].setPosition(-9.0F, 0.0F, -9.0F);
    this.rightWingModel[1].func_78790_a(-1.0F, -18.0F, -40.0F, 2, 18, 2, 0.0F);
    this.leftWingModel = new ModelRendererTurbo[2];
    this.leftWingModel[0] = new ModelRendererTurbo((ModelBase)this, 64, 0, textureX, textureY);
    this.leftWingModel[1] = new ModelRendererTurbo((ModelBase)this, 56, 15, textureX, textureY);
    this.leftWingModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 18, 41, 2, 0.0F);
    (this.leftWingModel[0]).field_78795_f = -1.570796F;
    this.leftWingModel[0].setPosition(-9.0F, 0.0F, 50.0F);
    this.leftWingModel[1].func_78790_a(-1.0F, -18.0F, 38.0F, 2, 18, 2, 0.0F);
    this.topWingModel = new ModelRendererTurbo[3];
    this.topWingModel[0] = new ModelRendererTurbo((ModelBase)this, 64, 0, textureX, textureY);
    this.topWingModel[1] = new ModelRendererTurbo((ModelBase)this, 64, 0, textureX, textureY);
    this.topWingModel[2] = new ModelRendererTurbo((ModelBase)this, 64, 0, textureX, textureY);
    this.topWingModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 18, 18, 2, 0.0F);
    (this.topWingModel[0]).field_78795_f = -1.570796F;
    this.topWingModel[0].setPosition(-9.0F, -20.0F, 9.0F);
    this.topWingModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 18, 41, 2, 0.0F);
    (this.topWingModel[1]).field_78795_f = -1.570796F;
    this.topWingModel[1].setPosition(-9.0F, -20.0F, 50.0F);
    this.topWingModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 18, 41, 2, 0.0F);
    (this.topWingModel[2]).field_78795_f = -1.570796F;
    this.topWingModel[2].setPosition(-9.0F, -20.0F, -9.0F);
    this.tailModel = new ModelRendererTurbo[1];
    this.tailModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 43, textureX, textureY);
    this.tailModel[0].func_78790_a(11.0F, -2.0F, -5.0F, 40, 8, 10, 0.0F);
    this.tailWheelModel = new ModelRendererTurbo[1];
    this.tailWheelModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 32, textureX, textureY);
    this.tailWheelModel[0].func_78790_a(44.0F, 6.0F, -1.0F, 4, 4, 2, 0.0F);
    flipAll();
  }
}
