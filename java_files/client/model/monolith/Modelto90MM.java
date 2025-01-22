package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class Modelto90MM extends ModelBase {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelRendererTurbo[] to90mmModel;
  
  public Modelto90MM() {
    this.to90mmModel = new ModelRendererTurbo[8];
    this.to90mmModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.to90mmModel[1] = new ModelRendererTurbo(this, 9, 1, this.textureX, this.textureY);
    this.to90mmModel[2] = new ModelRendererTurbo(this, 17, 1, this.textureX, this.textureY);
    this.to90mmModel[3] = new ModelRendererTurbo(this, 25, 1, this.textureX, this.textureY);
    this.to90mmModel[4] = new ModelRendererTurbo(this, 1, 17, this.textureX, this.textureY);
    this.to90mmModel[5] = new ModelRendererTurbo(this, 9, 17, this.textureX, this.textureY);
    this.to90mmModel[6] = new ModelRendererTurbo(this, 17, 17, this.textureX, this.textureY);
    this.to90mmModel[7] = new ModelRendererTurbo(this, 25, 17, this.textureX, this.textureY);
    this.to90mmModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 1, 12, 1, 0.0F, -0.95F, 0.0F, -0.95F, 0.0F, 0.0F, -0.95F, 0.0F, 0.0F, 0.0F, -0.95F, 0.0F, 0.0F, -0.35F, 0.0F, -0.35F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F);
    this.to90mmModel[0].func_78793_a(-1.05F, -8.05F, -1.05F);
    this.to90mmModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 1, 12, 1, 0.0F, -0.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.95F, -0.95F, 0.0F, -0.95F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, -0.35F, 0.0F, -0.35F);
    this.to90mmModel[1].func_78793_a(-1.05F, -8.05F, 0.05F);
    this.to90mmModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 12, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.95F, 0.0F, 0.0F, -0.95F, 0.0F, -0.95F, 0.0F, 0.0F, -0.95F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.35F, 0.0F, -0.35F, 0.0F, 0.0F, -0.25F);
    this.to90mmModel[2].func_78793_a(0.05F, -8.05F, 0.05F);
    this.to90mmModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 1, 12, 1, 0.0F, 0.0F, 0.0F, -0.95F, -0.95F, 0.0F, -0.95F, -0.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, -0.35F, 0.0F, -0.35F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.to90mmModel[3].func_78793_a(0.05F, -8.05F, -1.05F);
    this.to90mmModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, 0.0F, 0.0F, -0.25F, -0.35F, 0.0F, -0.35F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.95F, -0.95F, 0.0F, -0.95F, -0.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.to90mmModel[4].func_78793_a(0.05F, 4.05F, -1.05F);
    this.to90mmModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.35F, 0.0F, -0.35F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, -0.95F, 0.0F, 0.0F, -0.95F, 0.0F, -0.95F, 0.0F, 0.0F, -0.95F);
    this.to90mmModel[5].func_78793_a(0.05F, 4.05F, 0.05F);
    this.to90mmModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, -0.35F, 0.0F, -0.35F, -0.95F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.95F, -0.95F, 0.0F, -0.95F);
    this.to90mmModel[6].func_78793_a(-1.05F, 4.05F, 0.05F);
    this.to90mmModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 1, 0.0F, -0.35F, 0.0F, -0.35F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.95F, 0.0F, -0.95F, 0.0F, 0.0F, -0.95F, 0.0F, 0.0F, 0.0F, -0.95F, 0.0F, 0.0F);
    this.to90mmModel[7].func_78793_a(-1.05F, 4.05F, -1.05F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 8; i++)
      this.to90mmModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
