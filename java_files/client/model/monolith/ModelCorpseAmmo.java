package com.flansmod.client.model.monolith;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;

public class ModelCorpseAmmo extends ModelBase {
  int textureX = 128;
  
  int textureY = 64;
  
  public ModelRendererTurbo[] corpseammoModel;
  
  public ModelCorpseAmmo() {
    this.corpseammoModel = new ModelRendererTurbo[6];
    this.corpseammoModel[0] = new ModelRendererTurbo(this, 1, 1, this.textureX, this.textureY);
    this.corpseammoModel[1] = new ModelRendererTurbo(this, 49, 1, this.textureX, this.textureY);
    this.corpseammoModel[2] = new ModelRendererTurbo(this, 89, 1, this.textureX, this.textureY);
    this.corpseammoModel[3] = new ModelRendererTurbo(this, 81, 17, this.textureX, this.textureY);
    this.corpseammoModel[4] = new ModelRendererTurbo(this, 1, 25, this.textureX, this.textureY);
    this.corpseammoModel[5] = new ModelRendererTurbo(this, 41, 25, this.textureX, this.textureY);
    this.corpseammoModel[0].addShapeBox(-4.0F, -2.0F, -6.0F, 8, 4, 12, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.corpseammoModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.corpseammoModel[1].addShapeBox(-4.0F, -4.0F, 6.0F, 8, 8, 8, 0.0F, 1.0F, -0.5F, 0.0F, -1.0F, 0.5F, 0.0F, -1.0F, 0.5F, 0.0F, 1.0F, -0.5F, 0.0F, -1.0F, 0.5F, 0.0F, 1.0F, -0.5F, 0.0F, 1.0F, -0.5F, 0.0F, -1.0F, 0.5F, 0.0F);
    this.corpseammoModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.corpseammoModel[2].addShapeBox(4.0F, -2.0F, 2.0F, 12, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -2.0F, -1.0F, 0.0F, 2.0F, 0.0F, 0.0F, 0.0F);
    this.corpseammoModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.corpseammoModel[3].addShapeBox(-16.0F, -2.0F, 2.0F, 12, 4, 4, 0.0F, -1.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F, -1.0F, 0.0F, 4.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -4.0F);
    this.corpseammoModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.corpseammoModel[4].addShapeBox(-4.0F, -2.0F, -18.0F, 4, 4, 12, 0.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F, 1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 1.0F, 0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 1.0F);
    this.corpseammoModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.corpseammoModel[5].addShapeBox(1.0F, -2.0F, -18.0F, 4, 4, 12, 0.0F, -6.0F, 0.0F, -2.0F, 6.0F, 0.0F, -4.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F, -6.0F, 0.0F, -2.0F, 6.0F, 0.0F, -4.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, -1.0F);
    this.corpseammoModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    for (int i = 0; i < 6; i++)
      this.corpseammoModel[i].func_78785_a(f5); 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
}
