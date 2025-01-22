package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelKamikaze extends ModelBase {
  int textureX = 512;
  
  int textureY = 512;
  
  public ModelRendererTurbo[] kamikazeModel;
  
  public ModelKamikaze() {
    this.kamikazeModel = new ModelRendererTurbo[22];
    this.kamikazeModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.kamikazeModel[1] = new ModelRendererTurbo(this, 33, 1, this.textureX, this.textureY);
    this.kamikazeModel[2] = new ModelRendererTurbo(this, 65, 1, this.textureX, this.textureY);
    this.kamikazeModel[3] = new ModelRendererTurbo(this, 97, 1, this.textureX, this.textureY);
    this.kamikazeModel[4] = new ModelRendererTurbo(this, 121, 1, this.textureX, this.textureY);
    this.kamikazeModel[5] = new ModelRendererTurbo(this, 145, 1, this.textureX, this.textureY);
    this.kamikazeModel[6] = new ModelRendererTurbo(this, 137, 1, this.textureX, this.textureY);
    this.kamikazeModel[7] = new ModelRendererTurbo(this, 169, 1, this.textureX, this.textureY);
    this.kamikazeModel[8] = new ModelRendererTurbo(this, 193, 1, this.textureX, this.textureY);
    this.kamikazeModel[9] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
    this.kamikazeModel[10] = new ModelRendererTurbo(this, 217, 1, this.textureX, this.textureY);
    this.kamikazeModel[11] = new ModelRendererTurbo(this, 241, 1, this.textureX, this.textureY);
    this.kamikazeModel[12] = new ModelRendererTurbo(this, 265, 1, this.textureX, this.textureY);
    this.kamikazeModel[13] = new ModelRendererTurbo(this, 57, 1, this.textureX, this.textureY);
    this.kamikazeModel[14] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
    this.kamikazeModel[15] = new ModelRendererTurbo(this, 289, 1, this.textureX, this.textureY);
    this.kamikazeModel[16] = new ModelRendererTurbo(this, 369, 1, this.textureX, this.textureY);
    this.kamikazeModel[17] = new ModelRendererTurbo(this, 449, 1, this.textureX, this.textureY);
    this.kamikazeModel[18] = new ModelRendererTurbo(this, 481, 1, this.textureX, this.textureY);
    this.kamikazeModel[19] = new ModelRendererTurbo(this, 201, 1, this.textureX, this.textureY);
    this.kamikazeModel[20] = new ModelRendererTurbo(this, 225, 1, this.textureX, this.textureY);
    this.kamikazeModel[21] = new ModelRendererTurbo(this, 249, 1, this.textureX, this.textureY);
    this.kamikazeModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 7, 6, 7, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F);
    this.kamikazeModel[0].func_78793_a(-3.5F, 19.0F, -3.0F);
    this.kamikazeModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 7, 11, 7, 0.0F, -1.2F, 0.0F, -0.5F, -1.2F, 0.0F, -0.5F, -1.2F, 0.0F, -1.0F, -1.2F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[1].func_78793_a(-3.5F, -13.0F, -3.0F);
    this.kamikazeModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 7, 21, 7, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[2].func_78793_a(-3.5F, -2.0F, -3.0F);
    this.kamikazeModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 5, 16, 6, 0.0F, -2.2F, 0.0F, -3.0F, -2.2F, 0.0F, -3.0F, -2.2F, 0.0F, -2.8F, -2.2F, 0.0F, -2.8F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, -0.5F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F);
    this.kamikazeModel[3].func_78793_a(-2.5F, -29.0F, -3.0F);
    this.kamikazeModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 7, 10, 0.0F, -0.25F, -4.0F, 0.0F, -0.25F, -4.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F);
    this.kamikazeModel[4].func_78793_a(-0.5F, -29.0F, -10.0F);
    this.kamikazeModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 4, 10, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, -4.0F, 0.0F, -0.25F, -4.0F, 0.0F, -0.25F, 4.0F, 0.0F, -0.25F, 4.0F, 0.0F);
    this.kamikazeModel[5].func_78793_a(-0.5F, -22.0F, -10.0F);
    this.kamikazeModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 5, 5, 3, 0.0F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[6].func_78793_a(-2.5F, 6.5F, -6.0F);
    this.kamikazeModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 5, 8, 3, 0.0F, -2.0F, 0.0F, -3.0F, -2.0F, 0.0F, -3.0F, -2.0F, 0.0F, 0.0F, -2.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.2F, -1.0F, 0.0F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[7].func_78793_a(-2.5F, -1.5F, -6.0F);
    this.kamikazeModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 5, 4, 3, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -0.2F, -3.0F, -2.0F, -0.2F, -3.0F, -2.0F, -0.2F, 0.0F, -2.0F, -0.2F, 0.0F);
    this.kamikazeModel[8].func_78793_a(-2.5F, 11.5F, -6.0F);
    this.kamikazeModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 2, 4, 2, 0.0F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[9].func_78793_a(-1.0F, 24.5F, -0.5F);
    this.kamikazeModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 4, 5, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[10].func_78793_a(-2.0F, 9.0F, 5.0F);
    this.kamikazeModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F);
    this.kamikazeModel[11].func_78793_a(-2.0F, 14.0F, 5.0F);
    this.kamikazeModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 4, 3, 4, 0.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, -2.0F, 0.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[12].func_78793_a(-2.0F, 6.0F, 5.0F);
    this.kamikazeModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 3, 3, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[13].func_78793_a(-1.5F, 4.0F, 5.5F);
    this.kamikazeModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[14].func_78793_a(-1.0F, 11.0F, 4.0F);
    this.kamikazeModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 34, 17, 3, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -7.0F, 0.5F, 0.0F, -7.0F, -2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -4.0F, 0.5F, 0.0F, -4.0F, -2.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[15].func_78793_a(3.5F, 2.0F, 1.0F);
    this.kamikazeModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 34, 17, 3, 0.0F, 0.0F, -7.0F, 0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -7.0F, -2.0F, 0.0F, -4.0F, 0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, -2.0F);
    this.kamikazeModel[16].func_78793_a(-37.5F, 2.0F, 1.0F);
    this.kamikazeModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 14, 10, 1, 0.0F, 0.0F, 0.0F, -0.2F, 0.0F, -1.0F, -0.2F, 0.0F, -1.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -6.0F, -0.2F, 0.0F, -6.0F, -0.2F, 0.0F, 0.0F, -0.2F);
    this.kamikazeModel[17].func_78793_a(0.0F, -23.0F, -1.0F);
    this.kamikazeModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 14, 10, 1, 0.0F, 0.0F, -1.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -1.0F, -0.2F, 0.0F, -6.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, 0.0F, -0.2F, 0.0F, -6.0F, -0.2F);
    this.kamikazeModel[18].func_78793_a(-15.0F, -23.0F, -1.0F);
    this.kamikazeModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.kamikazeModel[19].func_78793_a(-0.5F, 26.0F, -8.5F);
    this.kamikazeModel[20].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 7.0F, 0.0F, -5.0F, -7.3F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 7.0F, 0.0F, -5.0F, -7.3F, 0.0F, -4.0F);
    this.kamikazeModel[20].func_78793_a(-0.5F, 26.0F, 1.0F);
    this.kamikazeModel[21].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 10, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -7.3F, 0.0F, -4.0F, 7.0F, 0.0F, -5.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -7.3F, 0.0F, -4.0F, 7.0F, 0.0F, -5.0F);
    this.kamikazeModel[21].func_78793_a(-0.5F, 26.0F, 1.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 22; i++)
      this.kamikazeModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
