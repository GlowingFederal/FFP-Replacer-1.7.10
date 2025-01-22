package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelARCbullet extends ModelBase {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelRendererTurbo[] arcbulletModel;
  
  public ModelARCbullet() {
    this.arcbulletModel = new ModelRendererTurbo[8];
    this.arcbulletModel[0] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcbulletModel[1] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcbulletModel[2] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcbulletModel[3] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcbulletModel[4] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcbulletModel[5] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcbulletModel[6] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcbulletModel[7] = new ModelRendererTurbo(this, 0, 0, this.textureX, this.textureY);
    this.arcbulletModel[0].addShapeBox(-1.0F, -4.0F, -1.0F, 2, 11, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.arcbulletModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcbulletModel[1].addShapeBox(-1.0F, 39.0F, -1.0F, 2, 14, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcbulletModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcbulletModel[2].addShapeBox(-1.0F, -17.0F, -1.0F, 2, 13, 2, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.arcbulletModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcbulletModel[3].addShapeBox(-1.0F, 7.0F, -1.0F, 2, 10, 2, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.arcbulletModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcbulletModel[4].addShapeBox(0.0F, 17.0F, -2.0F, 2, 12, 2, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 2.0F, 0.0F, 1.0F, -2.0F, 0.0F, 1.0F, -2.0F, 0.0F, -1.0F, 2.0F, 0.0F, -1.0F);
    this.arcbulletModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcbulletModel[5].addShapeBox(-2.0F, 29.0F, -1.0F, 2, 10, 2, 0.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, 2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F);
    this.arcbulletModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcbulletModel[6].addShapeBox(-1.0F, 53.0F, -2.0F, 2, 10, 2, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F);
    this.arcbulletModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.arcbulletModel[7].addShapeBox(-2.0F, 63.0F, -2.0F, 2, 13, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.arcbulletModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 8; i++)
      this.arcbulletModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
