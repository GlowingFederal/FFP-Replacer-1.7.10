package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelPigBullet extends ModelBase {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelRendererTurbo[] pigbulletModel;
  
  public ModelPigBullet() {
    this.pigbulletModel = new ModelRendererTurbo[7];
    this.pigbulletModel[0] = new ModelRendererTurbo(this, 1, 18, this.textureX, this.textureY);
    this.pigbulletModel[1] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.pigbulletModel[2] = new ModelRendererTurbo(this, 26, 1, this.textureX, this.textureY);
    this.pigbulletModel[3] = new ModelRendererTurbo(this, 34, 6, this.textureX, this.textureY);
    this.pigbulletModel[4] = new ModelRendererTurbo(this, 34, 6, this.textureX, this.textureY);
    this.pigbulletModel[5] = new ModelRendererTurbo(this, 34, 6, this.textureX, this.textureY);
    this.pigbulletModel[6] = new ModelRendererTurbo(this, 34, 6, this.textureX, this.textureY);
    this.pigbulletModel[0].addShapeBox(-9.0F, 7.0F, -5.0F, 16, 8, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pigbulletModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.pigbulletModel[1].addShapeBox(5.0F, 5.0F, -4.0F, 8, 8, 8, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pigbulletModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.pigbulletModel[2].addShapeBox(12.5F, 9.0F, -2.0F, 1, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pigbulletModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.pigbulletModel[3].addShapeBox(2.0F, 15.0F, -5.0F, 4, 6, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pigbulletModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.pigbulletModel[4].addShapeBox(2.0F, 15.0F, 1.0F, 4, 6, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pigbulletModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.pigbulletModel[5].addShapeBox(-10.0F, 15.0F, -5.0F, 4, 6, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pigbulletModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.pigbulletModel[6].addShapeBox(-10.0F, 15.0F, 1.0F, 4, 6, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pigbulletModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 7; i++)
      this.pigbulletModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
