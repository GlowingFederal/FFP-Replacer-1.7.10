package com.flansmod.client.model.mw;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelRPGRocket extends ModelBase {
  public ModelRendererTurbo[] bulletModel;
  
  public ModelRPGRocket() {
    int textureX = 64;
    int textureY = 32;
    this.bulletModel = new ModelRendererTurbo[3];
    this.bulletModel[0] = new ModelRendererTurbo(this, 14, 12, textureX, textureY);
    this.bulletModel[0].addBox(-1.5F, 0.0F, -1.5F, 3, 1, 3);
    this.bulletModel[1] = new ModelRendererTurbo(this, 26, 9, textureX, textureY);
    this.bulletModel[1].addTrapezoid(-2.0F, 1.0F, -2.0F, 4, 3, 4, 0.0F, -1.0F, 4);
    this.bulletModel[2] = new ModelRendererTurbo(this, 38, 6, textureX, textureY);
    this.bulletModel[2].addTrapezoid(-2.0F, 4.0F, -2.0F, 4, 3, 4, 0.0F, -1.0F, 5);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    GL11.glScalef(0.5F, 0.5F, 0.5F);
    for (ModelRendererTurbo mrt : this.bulletModel)
      mrt.func_78785_a(f5); 
  }
}
