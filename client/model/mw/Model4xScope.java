package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class Model4xScope extends ModelAttachment {
  int textureX = 32;
  
  int textureY = 32;
  
  public Model4xScope() {
    this.attachmentModel = new ModelRendererTurbo[7];
    this.attachmentModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.attachmentModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 10, this.textureX, this.textureY);
    this.attachmentModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 10, this.textureX, this.textureY);
    this.attachmentModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 15, this.textureX, this.textureY);
    this.attachmentModel[4] = new ModelRendererTurbo((ModelBase)this, 9, 15, this.textureX, this.textureY);
    this.attachmentModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 20, this.textureX, this.textureY);
    this.attachmentModel[6] = new ModelRendererTurbo((ModelBase)this, 0, 20, this.textureX, this.textureY);
    this.attachmentModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 9, 1, 1, 0.0F);
    this.attachmentModel[0].func_78793_a(-4.0F, -2.0F, -0.5F);
    this.attachmentModel[1].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.attachmentModel[1].func_78793_a(-2.0F, -1.0F, -0.5F);
    this.attachmentModel[2].func_78790_a(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F);
    this.attachmentModel[2].func_78793_a(2.0F, -1.0F, -0.5F);
    this.attachmentModel[3].func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
    this.attachmentModel[3].func_78793_a(-5.0F, -2.5F, -1.0F);
    this.attachmentModel[4].func_78790_a(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F);
    this.attachmentModel[4].func_78793_a(4.0F, -2.5F, -1.0F);
    this.attachmentModel[5].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.attachmentModel[5].func_78793_a(-1.0F, -2.5F, -0.5F);
    this.attachmentModel[6].func_78790_a(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F);
    this.attachmentModel[6].func_78793_a(-1.0F, -2.0F, -1.0F);
    this.renderOffset = 0.0F;
    flipAll();
  }
}
