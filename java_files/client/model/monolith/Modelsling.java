package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class Modelsling extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public Modelsling() {
    this.gunModel = new ModelRendererTurbo[15];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 97, 1, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 113, 1, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 137, 1, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 153, 1, this.textureX, this.textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 169, 1, this.textureX, this.textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 177, 1, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 3, 42, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(0.0F, -2.0F, -2.5F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 2, 42, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -1.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1].func_78793_a(3.0F, -2.0F, -2.5F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 42, 1, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F);
    this.gunModel[2].func_78793_a(-2.0F, -2.0F, -2.5F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 2, 42, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, -1.0F);
    this.gunModel[3].func_78793_a(-2.0F, -2.0F, 14.5F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 3, 42, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[4].func_78793_a(0.0F, -2.0F, 14.5F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 2, 42, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[5].func_78793_a(3.0F, -2.0F, 14.5F);
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 7, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.gunModel[6].func_78793_a(0.0F, 40.0F, 8.5F);
    this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[7].func_78793_a(2.0F, 42.0F, 4.5F);
    this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 4, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.gunModel[8].func_78793_a(-2.0F, 42.0F, 4.5F);
    this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[9].func_78793_a(1.0F, 42.0F, 4.5F);
    this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[10].func_78793_a(-2.0F, 41.0F, 2.5F);
    this.gunModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[11].func_78793_a(3.0F, 41.0F, 2.5F);
    this.gunModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F);
    this.gunModel[12].func_78793_a(-2.0F, 41.0F, 8.5F);
    this.gunModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[13].func_78793_a(3.0F, 41.0F, 8.5F);
    this.gunModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 7, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F);
    this.gunModel[14].func_78793_a(0.0F, 41.0F, -2.5F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.ammoModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel[0].func_78793_a(1.0F, 41.0F, 5.5F);
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
}
