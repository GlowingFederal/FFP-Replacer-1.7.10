package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelARCrepeaterBullet extends ModelBase {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelRendererTurbo[] arcrepeaterbulletModel;
  
  public ModelARCrepeaterBullet() {
    this.arcrepeaterbulletModel = new ModelRendererTurbo[19];
    this.arcrepeaterbulletModel[0] = new ModelRendererTurbo(this, 7, 1, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[1] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[2] = new ModelRendererTurbo(this, 0, 4, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[3] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[4] = new ModelRendererTurbo(this, 0, 4, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[5] = new ModelRendererTurbo(this, 2, 5, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[6] = new ModelRendererTurbo(this, 2, 5, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[7] = new ModelRendererTurbo(this, 0, 4, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[8] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[9] = new ModelRendererTurbo(this, 2, 5, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[10] = new ModelRendererTurbo(this, 0, 4, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[11] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[12] = new ModelRendererTurbo(this, 2, 5, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[13] = new ModelRendererTurbo(this, 0, 4, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[14] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[15] = new ModelRendererTurbo(this, 2, 5, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[16] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[17] = new ModelRendererTurbo(this, 2, 5, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[18] = new ModelRendererTurbo(this, 0, 4, this.textureX, this.textureY);
    this.arcrepeaterbulletModel[0].addShapeBox(-1.0F, 0.0F, -1.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[1].addShapeBox(-1.0F, 7.0F, -1.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[2].addShapeBox(-1.0F, 9.0F, -1.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.arcrepeaterbulletModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[3].addShapeBox(-2.0F, 25.0F, -3.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[4].addShapeBox(-2.0F, 27.0F, -3.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.arcrepeaterbulletModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[5].addShapeBox(-3.0F, 2.0F, -3.0F, 5, 5, 5, 0.0F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F);
    this.arcrepeaterbulletModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[6].addShapeBox(-4.0F, 20.0F, -5.0F, 5, 5, 5, 0.0F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F);
    this.arcrepeaterbulletModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[7].addShapeBox(3.0F, 24.0F, -1.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.arcrepeaterbulletModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[8].addShapeBox(3.0F, 22.0F, -1.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[9].addShapeBox(1.0F, 17.0F, -3.0F, 5, 5, 5, 0.0F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F);
    this.arcrepeaterbulletModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[10].addShapeBox(-4.0F, 34.0F, 1.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.arcrepeaterbulletModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[11].addShapeBox(-4.0F, 32.0F, 1.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[12].addShapeBox(-6.0F, 27.0F, -1.0F, 5, 5, 5, 0.0F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F);
    this.arcrepeaterbulletModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[13].addShapeBox(0.0F, 19.0F, 2.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.arcrepeaterbulletModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[14].addShapeBox(0.0F, 17.0F, 2.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[15].addShapeBox(-2.0F, 12.0F, 0.0F, 5, 5, 5, 0.0F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F);
    this.arcrepeaterbulletModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[16].addShapeBox(0.0F, 38.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[17].addShapeBox(-2.0F, 33.0F, -2.0F, 5, 5, 5, 0.0F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.2F, 0.0F, -2.2F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F);
    this.arcrepeaterbulletModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcrepeaterbulletModel[18].addShapeBox(0.0F, 40.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.arcrepeaterbulletModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 19; i++)
      this.arcrepeaterbulletModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
