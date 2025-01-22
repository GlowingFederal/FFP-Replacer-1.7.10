package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelCannonBall extends ModelBase {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelRendererTurbo[] cannonballModel;
  
  public ModelCannonBall() {
    this.cannonballModel = new ModelRendererTurbo[9];
    this.cannonballModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.cannonballModel[1] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
    this.cannonballModel[2] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.cannonballModel[3] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.cannonballModel[4] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.cannonballModel[5] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.cannonballModel[6] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.cannonballModel[7] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.cannonballModel[8] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.cannonballModel[0].addShapeBox(-1.0F, -1.0F, -3.0F, 2, 2, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.cannonballModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.cannonballModel[1].addShapeBox(-1.0F, -3.0F, -3.0F, 2, 2, 6, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.cannonballModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.cannonballModel[2].addShapeBox(-1.0F, 1.0F, -3.0F, 2, 2, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F);
    this.cannonballModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.cannonballModel[3].addShapeBox(-1.01F, -1.0F, 3.0F, 2, 2, 6, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
    this.cannonballModel[3].func_78793_a(-2.0F, 0.0F, -6.0F);
    this.cannonballModel[4].addShapeBox(-1.01F, -3.01F, 3.01F, 2, 2, 6, 0.0F, -1.9F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, -1.9F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F);
    this.cannonballModel[4].func_78793_a(-2.0F, 0.0F, -6.0F);
    this.cannonballModel[5].addShapeBox(-1.01F, 0.99F, 3.01F, 2, 2, 6, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -1.9F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, -1.9F, 0.0F, -2.0F);
    this.cannonballModel[5].func_78793_a(-2.0F, 0.0F, -6.0F);
    this.cannonballModel[6].addShapeBox(3.01F, 0.99F, 3.01F, 2, 2, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -1.9F, 0.0F, -2.0F, -1.9F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F);
    this.cannonballModel[6].func_78793_a(-2.0F, 0.0F, -6.0F);
    this.cannonballModel[7].addShapeBox(3.01F, -3.01F, 3.01F, 2, 2, 6, 0.0F, 0.0F, 0.0F, -2.0F, -1.9F, 0.0F, -2.0F, -1.9F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
    this.cannonballModel[7].func_78793_a(-2.0F, 0.0F, -6.0F);
    this.cannonballModel[8].addShapeBox(3.01F, -1.0F, 3.0F, 2, 2, 6, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F);
    this.cannonballModel[8].func_78793_a(-2.0F, 0.0F, -6.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 9; i++)
      this.cannonballModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
