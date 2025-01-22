package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelBullet;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelMIM23Rocket extends ModelBullet {
  public ModelRendererTurbo[] bulletModel;
  
  public ModelMIM23Rocket() {
    int textureX = 256;
    int textureY = 256;
    this.bulletModel = new ModelRendererTurbo[4];
    this.bulletModel = new ModelRendererTurbo[4];
    this.bulletModel[0] = new ModelRendererTurbo((ModelBase)this, 72, 212, textureX, textureY);
    this.bulletModel[0].addBox(-20.0F, -3.0F, -3.0F, 40, 6, 6);
    this.bulletModel[1] = new ModelRendererTurbo((ModelBase)this, 72, 226, textureX, textureY);
    this.bulletModel[1].addTrapezoid(20.0F, -3.0F, -3.0F, 8, 6, 6, 0.0F, -3.0F, 2);
    this.bulletModel[2] = new ModelRendererTurbo((ModelBase)this, 102, 226, textureX, textureY);
    this.bulletModel[2].addShapeBox(-20.0F, -7.0F, 0.0F, 20, 14, 0, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.bulletModel[3] = new ModelRendererTurbo((ModelBase)this, 88, 242, textureX, textureY);
    this.bulletModel[3].addShapeBox(-20.0F, 0.0F, -7.0F, 20, 0, 14, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, -4.0F, 0.0F, 0.0F, 0.0F);
    for (int i = 0; i < 4; i++)
      (this.bulletModel[i]).field_78808_h = 1.5707964F; 
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (ModelRendererTurbo mrt : this.bulletModel)
      mrt.func_78785_a(f5); 
  }
}
