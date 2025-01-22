package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelDepthCharge extends ModelBase {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelRendererTurbo[] depthchargeModel;
  
  public ModelDepthCharge() {
    this.depthchargeModel = new ModelRendererTurbo[20];
    this.depthchargeModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.depthchargeModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
    this.depthchargeModel[2] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
    this.depthchargeModel[3] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
    this.depthchargeModel[4] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
    this.depthchargeModel[5] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
    this.depthchargeModel[6] = new ModelRendererTurbo(this, 41, 49, this.textureX, this.textureY);
    this.depthchargeModel[7] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
    this.depthchargeModel[8] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
    this.depthchargeModel[9] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
    this.depthchargeModel[10] = new ModelRendererTurbo(this, 41, 49, this.textureX, this.textureY);
    this.depthchargeModel[11] = new ModelRendererTurbo(this, 81, 49, this.textureX, this.textureY);
    this.depthchargeModel[12] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.depthchargeModel[13] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
    this.depthchargeModel[14] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
    this.depthchargeModel[15] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
    this.depthchargeModel[16] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
    this.depthchargeModel[17] = new ModelRendererTurbo(this, 73, 1, this.textureX, this.textureY);
    this.depthchargeModel[18] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
    this.depthchargeModel[19] = new ModelRendererTurbo(this, 105, 1, this.textureX, this.textureY);
    this.depthchargeModel[0].addShapeBox(-2.0F, -2.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[1].addShapeBox(-6.01F, -2.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F);
    this.depthchargeModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[2].addShapeBox(-2.0F, 2.01F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F);
    this.depthchargeModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[3].addShapeBox(-6.01F, 1.99F, -5.99F, 4, 4, 12, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F);
    this.depthchargeModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[4].addShapeBox(1.99F, 1.99F, -5.99F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F);
    this.depthchargeModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[5].addShapeBox(1.99F, -2.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[6].addShapeBox(1.99F, -11.01F, -5.99F, 4, 9, 12, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, -8.95F, -3.95F, 0.0F, -8.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[7].addShapeBox(-2.0F, -10.99F, -6.0F, 4, 9, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[8].addShapeBox(-6.01F, -11.01F, -5.99F, 4, 9, 12, 0.0F, 0.0F, -8.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, -8.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F);
    this.depthchargeModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[9].addShapeBox(-6.01F, -10.0F, -6.0F, 4, 1, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F);
    this.depthchargeModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[10].addShapeBox(-2.0F, -10.0F, -6.0F, 4, 1, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[11].addShapeBox(1.99F, -10.0F, -6.0F, 4, 1, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[12].addShapeBox(4.5F, -11.0F, -0.5F, 1, 9, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[13].addShapeBox(-5.5F, -11.0F, -0.5F, 1, 9, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[14].addShapeBox(-0.5F, -11.0F, 4.5F, 1, 9, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[15].addShapeBox(-0.5F, -11.0F, -5.5F, 1, 9, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[16].addShapeBox(2.7F, -11.0F, 2.7F, 1, 9, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[17].addShapeBox(-3.7F, -11.0F, -3.7F, 1, 9, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[17].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[18].addShapeBox(-3.7F, -11.0F, 2.7F, 1, 9, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[18].func_78793_a(0.0F, 0.0F, 0.0F);
    this.depthchargeModel[19].addShapeBox(2.7F, -11.0F, -3.7F, 1, 9, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.depthchargeModel[19].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 20; i++)
      this.depthchargeModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
