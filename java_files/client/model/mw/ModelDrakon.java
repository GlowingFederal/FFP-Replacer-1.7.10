package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelBullet;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import org.lwjgl.opengl.GL11;

public class ModelDrakon extends ModelBullet {
  public ModelRendererTurbo[] tailModel;
  
  public ModelDrakon() {
    int textureX = 64;
    int textureY = 32;
    this.tailModel = new ModelRendererTurbo[17];
    this.tailModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.tailModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.tailModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.tailModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.tailModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.tailModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 5, textureX, textureY);
    this.tailModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 11, textureX, textureY);
    this.tailModel[7] = new ModelRendererTurbo((ModelBase)this, 0, 11, textureX, textureY);
    this.tailModel[8] = new ModelRendererTurbo((ModelBase)this, 0, 11, textureX, textureY);
    this.tailModel[9] = new ModelRendererTurbo((ModelBase)this, 0, 17, textureX, textureY);
    this.tailModel[10] = new ModelRendererTurbo((ModelBase)this, 0, 17, textureX, textureY);
    this.tailModel[11] = new ModelRendererTurbo((ModelBase)this, 0, 17, textureX, textureY);
    this.tailModel[12] = new ModelRendererTurbo((ModelBase)this, 0, 17, textureX, textureY);
    this.tailModel[13] = new ModelRendererTurbo((ModelBase)this, 0, 25, textureX, textureY);
    this.tailModel[14] = new ModelRendererTurbo((ModelBase)this, 0, 25, textureX, textureY);
    this.tailModel[15] = new ModelRendererTurbo((ModelBase)this, 0, 25, textureX, textureY);
    this.tailModel[16] = new ModelRendererTurbo((ModelBase)this, 0, 25, textureX, textureY);
    this.tailModel[0].addShapeBox(-9.5F, 1.0F, -1.5F, 17, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    (this.tailModel[0]).field_78808_h = -1.5707964F;
    this.tailModel[1].addShapeBox(-9.5F, 0.0F, -1.5F, 17, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    (this.tailModel[1]).field_78808_h = -1.5707964F;
    this.tailModel[2].addShapeBox(-9.5F, -1.0F, -1.5F, 17, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    (this.tailModel[2]).field_78808_h = -1.5707964F;
    this.tailModel[3].addShapeBox(7.5F, -1.0F, -1.5F, 2, 1, 3, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.2F, -1.1F, 0.0F, -0.2F, -1.1F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.0F, 0.0F);
    (this.tailModel[3]).field_78808_h = -1.5707964F;
    this.tailModel[4].addShapeBox(7.5F, 0.0F, -1.5F, 2, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, 0.0F, 0.0F, 0.0F);
    (this.tailModel[4]).field_78808_h = -1.5707964F;
    this.tailModel[5].addShapeBox(7.5F, 1.0F, -1.5F, 2, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.1F, -0.2F, 0.0F, 0.1F, -0.2F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, -0.2F, -1.1F, 0.0F, -0.2F, -1.1F, 0.0F, 0.0F, -1.0F);
    (this.tailModel[5]).field_78808_h = -1.5707964F;
    this.tailModel[6].addShapeBox(9.5F, 0.0F, -1.5F, 1, 1, 3, 0.0F, 0.0F, -0.1F, -0.2F, -0.5F, -0.33F, -1.0F, -0.5F, -0.33F, -1.0F, 0.0F, -0.1F, -0.2F, 0.0F, -0.1F, -0.2F, -0.5F, -0.33F, -1.0F, -0.5F, -0.33F, -1.0F, 0.0F, -0.1F, -0.2F);
    (this.tailModel[6]).field_78808_h = -1.5707964F;
    this.tailModel[7].addShapeBox(9.5F, -1.0F, -1.5F, 1, 1, 3, 0.0F, 0.0F, -0.2F, -1.1F, -0.5F, -1.0F, -1.33F, -0.5F, -1.0F, -1.33F, 0.0F, -0.2F, -1.1F, 0.0F, 0.1F, -0.2F, -0.5F, 0.33F, -1.0F, -0.5F, 0.33F, -1.0F, 0.0F, 0.1F, -0.2F);
    (this.tailModel[7]).field_78808_h = -1.5707964F;
    this.tailModel[8].addShapeBox(9.5F, 1.0F, -1.5F, 1, 1, 3, 0.0F, 0.0F, 0.1F, -0.2F, -0.5F, 0.33F, -1.0F, -0.5F, 0.33F, -1.0F, 0.0F, 0.1F, -0.2F, 0.0F, -0.2F, -1.1F, -0.5F, -1.0F, -1.33F, -0.5F, -1.0F, -1.33F, 0.0F, -0.2F, -1.1F);
    (this.tailModel[8]).field_78808_h = -1.5707964F;
    this.tailModel[9].addShapeBox(-8.0F, 0.0F, -6.5F, 3, 1, 5, 0.0F, 2.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 2.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    (this.tailModel[9]).field_78795_f = 0.7853982F;
    (this.tailModel[9]).field_78808_h = -1.5707964F;
    this.tailModel[10].addShapeBox(-8.0F, 0.0F, 0.5F, 3, 1, 5, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 2.0F, -0.3F, 0.0F);
    (this.tailModel[10]).field_78795_f = 0.7853982F;
    (this.tailModel[10]).field_78808_h = -1.5707964F;
    this.tailModel[11].addShapeBox(-8.0F, 0.0F, 1.5F, 3, 1, 5, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 2.0F, -0.3F, 0.0F);
    (this.tailModel[11]).field_78795_f = -0.7853982F;
    (this.tailModel[11]).field_78808_h = -1.5707964F;
    this.tailModel[12].addShapeBox(-8.0F, 0.0F, -5.5F, 3, 1, 5, 0.0F, 2.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 2.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    (this.tailModel[12]).field_78795_f = -0.7853982F;
    (this.tailModel[12]).field_78808_h = -1.5707964F;
    this.tailModel[13].addShapeBox(2.0F, 0.0F, -4.5F, 3, 1, 3, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    (this.tailModel[13]).field_78795_f = 0.7853982F;
    (this.tailModel[13]).field_78808_h = -1.5707964F;
    this.tailModel[14].addShapeBox(2.0F, 0.0F, 1.5F, 3, 1, 3, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    (this.tailModel[14]).field_78795_f = 0.7853982F;
    (this.tailModel[14]).field_78808_h = -1.5707964F;
    this.tailModel[15].addShapeBox(2.0F, 0.0F, 1.5F, 3, 1, 3, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    (this.tailModel[15]).field_78795_f = -0.7853982F;
    (this.tailModel[15]).field_78808_h = -1.5707964F;
    this.tailModel[16].addShapeBox(2.0F, 0.0F, -3.5F, 3, 1, 3, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, -2.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F, 0.0F, -0.3F, 0.0F);
    (this.tailModel[16]).field_78795_f = -0.7853982F;
    (this.tailModel[16]).field_78808_h = -1.5707964F;
    for (int i = 0; i < 17; i++)
      (this.tailModel[i]).field_78808_h = 1.5707964F; 
  }
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    GL11.glPushMatrix();
    GL11.glTranslatef(0.0F, 1.0F, 0.0F);
    for (ModelRendererTurbo mrt : this.tailModel)
      mrt.func_78785_a(f5); 
    GL11.glPopMatrix();
  }
}
