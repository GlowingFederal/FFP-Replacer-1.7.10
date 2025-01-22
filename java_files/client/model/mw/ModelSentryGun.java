package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelAAGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSentryGun extends ModelAAGun {
  public ModelSentryGun() {
    int textureX = 64;
    int textureY = 64;
    this.baseModel = new ModelRendererTurbo[5];
    this.baseModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.baseModel[0].func_78790_a(-4.0F, 16.0F, -4.0F, 8, 2, 8, 0.0F);
    this.baseModel[1] = new ModelRendererTurbo((ModelBase)this, 32, 0, textureX, textureY);
    this.baseModel[1].addShapeBox(-4.0F, 0.0F, -4.0F, 2, 16, 2, 0.0F, 4.0F, 0.0F, 4.0F, -4.0F, 0.0F, 4.0F, -4.0F, 0.0F, -4.0F, 4.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.baseModel[2] = new ModelRendererTurbo((ModelBase)this, 40, 0, textureX, textureY);
    this.baseModel[2].addShapeBox(2.0F, 0.0F, -4.0F, 2, 16, 2, 0.0F, -4.0F, 0.0F, 4.0F, 4.0F, 0.0F, 4.0F, 4.0F, 0.0F, -4.0F, -4.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.baseModel[3] = new ModelRendererTurbo((ModelBase)this, 48, 0, textureX, textureY);
    this.baseModel[3].addShapeBox(2.0F, 0.0F, 2.0F, 2, 16, 2, 0.0F, -4.0F, 0.0F, -4.0F, 4.0F, 0.0F, -4.0F, 4.0F, 0.0F, 4.0F, -4.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.baseModel[4] = new ModelRendererTurbo((ModelBase)this, 56, 0, textureX, textureY);
    this.baseModel[4].addShapeBox(-4.0F, 0.0F, 2.0F, 2, 16, 2, 0.0F, 4.0F, 0.0F, -4.0F, -4.0F, 0.0F, -4.0F, -4.0F, 0.0F, 4.0F, 4.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.seatModel = new ModelRendererTurbo[5];
    this.seatModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 10, textureX, textureY);
    this.seatModel[0].func_78790_a(-4.0F, 18.0F, -4.0F, 8, 1, 8, 0.0F);
    this.seatModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 19, textureX, textureY);
    this.seatModel[1].func_78790_a(-2.0F, 19.0F, -4.0F, 4, 7, 1, 0.0F);
    this.seatModel[2] = new ModelRendererTurbo((ModelBase)this, 16, 19, textureX, textureY);
    this.seatModel[2].func_78790_a(-2.0F, 19.0F, 3.0F, 4, 7, 1, 0.0F);
    this.seatModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 27, textureX, textureY);
    this.seatModel[3].func_78790_a(-3.0F, 18.0F, 4.0F, 6, 6, 2, 0.0F);
    this.seatModel[4] = new ModelRendererTurbo((ModelBase)this, 17, 27, textureX, textureY);
    this.seatModel[4].func_78790_a(-3.0F, 19.0F, -9.0F, 6, 5, 5, 0.0F);
    this.gunModel = new ModelRendererTurbo[4];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 37, textureX, textureY);
    this.gunModel[0].func_78790_a(-4.0F, -3.0F, -3.0F, 8, 6, 6, 0.0F);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 49, textureX, textureY);
    this.gunModel[1].func_78790_a(4.0F, -1.0F, -2.0F, 2, 4, 4, 0.0F);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 12, 49, textureX, textureY);
    this.gunModel[2].func_78790_a(8.0F, -1.0F, -2.0F, 2, 4, 4, 0.0F);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 24, 49, textureX, textureY);
    this.gunModel[3].func_78790_a(14.0F, -1.0F, -2.0F, 4, 4, 4, 0.0F);
    this.barrelModel = new ModelRendererTurbo[4][1];
    this.barrelModel[0][0] = new ModelRendererTurbo((ModelBase)this, 34, 18, textureX, textureY);
    this.barrelModel[0][0].func_78790_a(6.0F, 1.5F, 0.5F, 14, 1, 1, 0.0F);
    this.barrelModel[1][0] = new ModelRendererTurbo((ModelBase)this, 34, 20, textureX, textureY);
    this.barrelModel[1][0].func_78790_a(6.0F, 1.5F, -1.5F, 14, 1, 1, 0.0F);
    this.barrelModel[2][0] = new ModelRendererTurbo((ModelBase)this, 34, 22, textureX, textureY);
    this.barrelModel[2][0].func_78790_a(6.0F, -0.5F, -1.5F, 14, 1, 1, 0.0F);
    this.barrelModel[3][0] = new ModelRendererTurbo((ModelBase)this, 34, 24, textureX, textureY);
    this.barrelModel[3][0].func_78790_a(6.0F, -0.5F, 0.5F, 14, 1, 1, 0.0F);
    this.ammoModel = new ModelRendererTurbo[0][0];
    this.barrelX = 0;
    this.barrelY = 24;
    this.barrelZ = 0;
  }
}
