package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class Modelfurrysword extends ModelGun {
  int textureX = 512;
  
  int textureY = 512;
  
  public Modelfurrysword() {
    this.gunModel = new ModelRendererTurbo[11];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 65, 1, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 81, 1, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 2, 9, 1, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(-1.0F, -13.0F, -0.5F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F);
    this.gunModel[1].func_78793_a(-0.5F, -3.0F, -0.5F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F);
    this.gunModel[2].func_78793_a(-1.0F, -4.0F, -0.5F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F);
    this.gunModel[3].func_78793_a(1.0F, -13.0F, -0.5F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F);
    this.gunModel[4].func_78793_a(1.0F, -11.0F, -0.5F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F);
    this.gunModel[5].func_78793_a(1.0F, -9.0F, -0.5F);
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F);
    this.gunModel[6].func_78793_a(1.0F, -7.0F, -0.5F);
    this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F);
    this.gunModel[7].func_78793_a(-2.0F, -7.0F, -0.5F);
    this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F);
    this.gunModel[8].func_78793_a(-2.0F, -9.0F, -0.5F);
    this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F);
    this.gunModel[9].func_78793_a(-2.0F, -11.0F, -0.5F);
    this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, -0.125F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F, 0.0F, 0.625F, -0.5F);
    this.gunModel[10].func_78793_a(-2.0F, -13.0F, -0.5F);
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
}
