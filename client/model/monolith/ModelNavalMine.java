package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelNavalMine extends ModelBase {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelRendererTurbo[] navalmineModel;
  
  public ModelNavalMine() {
    this.navalmineModel = new ModelRendererTurbo[17];
    this.navalmineModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.navalmineModel[1] = new ModelRendererTurbo(this, 41, 1, this.textureX, this.textureY);
    this.navalmineModel[2] = new ModelRendererTurbo(this, 81, 1, this.textureX, this.textureY);
    this.navalmineModel[3] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
    this.navalmineModel[4] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
    this.navalmineModel[5] = new ModelRendererTurbo(this, 81, 25, this.textureX, this.textureY);
    this.navalmineModel[6] = new ModelRendererTurbo(this, 1, 49, this.textureX, this.textureY);
    this.navalmineModel[7] = new ModelRendererTurbo(this, 41, 49, this.textureX, this.textureY);
    this.navalmineModel[8] = new ModelRendererTurbo(this, 81, 49, this.textureX, this.textureY);
    this.navalmineModel[9] = new ModelRendererTurbo(this, 1, 73, this.textureX, this.textureY);
    this.navalmineModel[10] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
    this.navalmineModel[11] = new ModelRendererTurbo(this, 25, 73, this.textureX, this.textureY);
    this.navalmineModel[12] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
    this.navalmineModel[13] = new ModelRendererTurbo(this, 73, 17, this.textureX, this.textureY);
    this.navalmineModel[14] = new ModelRendererTurbo(this, 113, 17, this.textureX, this.textureY);
    this.navalmineModel[15] = new ModelRendererTurbo(this, 121, 25, this.textureX, this.textureY);
    this.navalmineModel[16] = new ModelRendererTurbo(this, 33, 41, this.textureX, this.textureY);
    this.navalmineModel[0].addShapeBox(-2.0F, -2.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.navalmineModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[1].addShapeBox(-2.0F, -6.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.navalmineModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[2].addShapeBox(-6.01F, -2.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F);
    this.navalmineModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[3].addShapeBox(-6.01F, -6.01F, -5.99F, 4, 4, 12, 0.0F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F);
    this.navalmineModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[4].addShapeBox(-2.0F, 2.01F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F);
    this.navalmineModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[5].addShapeBox(-6.01F, -6.01F, -5.99F, 4, 4, 12, 0.0F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F);
    this.navalmineModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[6].addShapeBox(-6.01F, 1.99F, -5.99F, 4, 4, 12, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F);
    this.navalmineModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[7].addShapeBox(1.99F, 1.99F, -5.99F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F);
    this.navalmineModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[8].addShapeBox(1.99F, -2.0F, -6.0F, 4, 4, 12, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F);
    this.navalmineModel[8].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[9].addShapeBox(1.99F, -6.01F, -5.99F, 4, 4, 12, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, -3.95F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, -3.95F, 0.0F, 0.0F, 0.0F);
    this.navalmineModel[9].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[10].addShapeBox(-0.5F, -0.5F, -9.0F, 1, 1, 18, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.navalmineModel[10].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[11].addShapeBox(-9.0F, -0.5F, -0.5F, 18, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.navalmineModel[11].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[12].addShapeBox(-0.5F, -9.0F, -0.5F, 1, 18, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.navalmineModel[12].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[13].addShapeBox(-0.5F, -7.0F, 5.5F, 1, 14, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 13.0F, 0.0F, -1.0F, 13.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, -13.0F);
    this.navalmineModel[13].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[14].addShapeBox(-0.5F, -7.0F, -7.0F, 1, 14, 1, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, -13.0F, 0.0F, -1.0F, 13.0F, 0.0F, -1.0F, 13.0F);
    this.navalmineModel[14].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[15].addShapeBox(-6.5F, -7.0F, -0.5F, 1, 14, 1, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -13.0F, 0.0F, 0.0F, 13.0F, -1.0F, 0.0F, 13.0F, -1.0F, 0.0F, -13.0F, 0.0F, 0.0F);
    this.navalmineModel[15].func_78793_a(0.0F, 0.0F, 0.0F);
    this.navalmineModel[16].addShapeBox(5.5F, -7.0F, -0.5F, 1, 14, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 13.0F, -1.0F, 0.0F, -13.0F, 0.0F, 0.0F, -13.0F, 0.0F, 0.0F, 13.0F, -1.0F, 0.0F);
    this.navalmineModel[16].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 17; i++)
      this.navalmineModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
