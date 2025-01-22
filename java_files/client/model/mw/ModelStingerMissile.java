package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelBullet;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelStingerMissile extends ModelBullet {
  public ModelRendererTurbo[] bulletModel;
  
  public ModelStingerMissile() {
    int textureX = 64;
    int textureY = 32;
    this.bulletModel = new ModelRendererTurbo[3];
    this.bulletModel[0] = new ModelRendererTurbo((ModelBase)this, 60, 0, textureX, textureY);
    this.bulletModel[0].addBox(-0.5F, -10.0F, -0.5F, 1, 20, 1);
    this.bulletModel[1] = new ModelRendererTurbo((ModelBase)this, 55, 0, textureX, textureY);
    this.bulletModel[1].addBox(-1.0F, -10.0F, 0.0F, 2, 1, 0);
    this.bulletModel[2] = new ModelRendererTurbo((ModelBase)this, 55, 2, textureX, textureY);
    this.bulletModel[2].addBox(0.0F, -10.0F, -1.0F, 0, 1, 2);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (ModelRendererTurbo mrt : this.bulletModel)
      mrt.func_78785_a(f5); 
  }
}
