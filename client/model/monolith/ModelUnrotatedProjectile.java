package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelUnrotatedProjectile extends ModelBase {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelRendererTurbo[] modelunrotatedprojectileModel;
  
  public ModelUnrotatedProjectile() {
    this.modelunrotatedprojectileModel = new ModelRendererTurbo[9];
    this.modelunrotatedprojectileModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.modelunrotatedprojectileModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
    this.modelunrotatedprojectileModel[2] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
    this.modelunrotatedprojectileModel[3] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
    this.modelunrotatedprojectileModel[4] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
    this.modelunrotatedprojectileModel[5] = new ModelRendererTurbo(this, 9, 25, this.textureX, this.textureY);
    this.modelunrotatedprojectileModel[6] = new ModelRendererTurbo(this, 17, 25, this.textureX, this.textureY);
    this.modelunrotatedprojectileModel[7] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.modelunrotatedprojectileModel[8] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
    this.modelunrotatedprojectileModel[0].addShapeBox(-2.0F, -34.0F, -6.0F, 4, 6, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.modelunrotatedprojectileModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.modelunrotatedprojectileModel[1].addShapeBox(-6.01F, -34.02F, -5.99F, 4, 6, 12, 0.0F, 0.0F, -5.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, -5.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F);
    this.modelunrotatedprojectileModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.modelunrotatedprojectileModel[2].addShapeBox(1.99F, -34.02F, -5.99F, 4, 6, 12, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, -5.95F, -3.95F, 0.0F, -5.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F);
    this.modelunrotatedprojectileModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.modelunrotatedprojectileModel[3].addShapeBox(4.5F, -28.0F, -0.5F, 1, 18, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, 4.7F, 0.0F, -0.3F, -5.3F, 0.0F, -0.3F, -5.3F, 0.0F, -0.3F, 4.7F, 0.0F, -0.3F);
    this.modelunrotatedprojectileModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.modelunrotatedprojectileModel[4].addShapeBox(-5.5F, -28.0F, -0.5F, 1, 18, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -5.3F, 0.0F, -0.3F, 4.7F, 0.0F, -0.3F, 4.7F, 0.0F, -0.3F, -5.3F, 0.0F, -0.3F);
    this.modelunrotatedprojectileModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.modelunrotatedprojectileModel[5].addShapeBox(-0.5F, -28.0F, 4.5F, 1, 18, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, 4.7F, -0.3F, 0.0F, 4.7F, -0.3F, 0.0F, -5.3F, -0.3F, 0.0F, -5.3F);
    this.modelunrotatedprojectileModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.modelunrotatedprojectileModel[6].addShapeBox(-0.5F, -28.0F, -5.5F, 1, 18, 1, 0.0F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -5.3F, -0.3F, 0.0F, -5.3F, -0.3F, 0.0F, 4.7F, -0.3F, 0.0F, 4.7F);
    this.modelunrotatedprojectileModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.modelunrotatedprojectileModel[7].addShapeBox(-0.5F, 10.0F, -0.5F, 1, 10, 1, 0.0F, -0.3F, 20.0F, -0.3F, -0.3F, 20.0F, -0.3F, -0.3F, 20.0F, -0.3F, -0.3F, 20.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F);
    this.modelunrotatedprojectileModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.modelunrotatedprojectileModel[8].addShapeBox(-0.5F, 20.0F, -0.5F, 1, 10, 1, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F);
    this.modelunrotatedprojectileModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 9; i++)
      this.modelunrotatedprojectileModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
