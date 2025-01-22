package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelSuperCannonBall extends ModelBase {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelRendererTurbo[] supercannonballModel;
  
  public ModelSuperCannonBall() {
    this.supercannonballModel = new ModelRendererTurbo[10];
    this.supercannonballModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.supercannonballModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
    this.supercannonballModel[2] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
    this.supercannonballModel[3] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
    this.supercannonballModel[4] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
    this.supercannonballModel[5] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
    this.supercannonballModel[6] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
    this.supercannonballModel[7] = new ModelRendererTurbo(this, 41, 49, this.textureX, this.textureY);
    this.supercannonballModel[8] = new ModelRendererTurbo(this, 81, 49, this.textureX, this.textureY);
    this.supercannonballModel[9] = new ModelRendererTurbo(this, 1, 73, this.textureX, this.textureY);
    this.supercannonballModel[0].addShapeBox(-2.0F, -2.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.supercannonballModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.supercannonballModel[1].addShapeBox(-2.0F, -6.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.supercannonballModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.supercannonballModel[2].addShapeBox(-6.01F, -2.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F);
    this.supercannonballModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.supercannonballModel[3].addShapeBox(-6.01F, -6.01F, -5.99F, 4, 4, 12, 0.0F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F);
    this.supercannonballModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.supercannonballModel[4].addShapeBox(-2.0F, 2.01F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F);
    this.supercannonballModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.supercannonballModel[5].addShapeBox(-6.01F, -6.01F, -5.99F, 4, 4, 12, 0.0F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F);
    this.supercannonballModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.supercannonballModel[6].addShapeBox(-6.01F, 1.99F, -5.99F, 4, 4, 12, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F);
    this.supercannonballModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.supercannonballModel[7].addShapeBox(1.99F, 1.99F, -5.99F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F);
    this.supercannonballModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.supercannonballModel[8].addShapeBox(1.99F, -2.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F);
    this.supercannonballModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.supercannonballModel[9].addShapeBox(1.99F, -6.01F, -5.99F, 4, 4, 12, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F);
    this.supercannonballModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 10; i++)
      this.supercannonballModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
