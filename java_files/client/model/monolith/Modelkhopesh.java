package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class Modelkhopesh extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public Modelkhopesh() {
    this.gunModel = new ModelRendererTurbo[7];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(-1.0F, -3.0F, -0.5F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.gunModel[1].func_78793_a(-1.0F, 2.0F, -0.5F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 5, 1, 0.0F, 0.0F, -1.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, -1.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.gunModel[2].func_78793_a(-1.0F, -8.0F, -0.5F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -1.5F, 0.0F, -0.5F, 1.5F, 0.0F, -0.5F, 1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.gunModel[3].func_78793_a(-1.0F, -9.0F, -0.5F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -1.5F, 0.0F, -0.5F, 1.5F, 0.0F, -0.5F, 1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.gunModel[4].func_78793_a(0.0F, -12.0F, -0.5F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, 1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, 1.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.5F, 0.0F, -0.5F);
    this.gunModel[5].func_78793_a(2.0F, -15.0F, -0.5F);
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, -1.5F, 0.0F, -0.5F, 1.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.gunModel[6].func_78793_a(0.5F, -17.0F, -0.5F);
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
}
