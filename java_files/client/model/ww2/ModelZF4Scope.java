package com.flansmod.client.model.ww2;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelZF4Scope extends ModelAttachment {
  int textureX = 32;
  
  int textureY = 32;
  
  public ModelZF4Scope() {
    this.attachmentModel = new ModelRendererTurbo[8];
    this.attachmentModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.attachmentModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.attachmentModel[2] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.attachmentModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.attachmentModel[4] = new ModelRendererTurbo((ModelBase)this, 9, 9, this.textureX, this.textureY);
    this.attachmentModel[5] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.attachmentModel[6] = new ModelRendererTurbo((ModelBase)this, 25, 9, this.textureX, this.textureY);
    this.attachmentModel[7] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.attachmentModel[0].addShapeBox(-2.0F, -2.0F, -1.5F, 1, 2, 1, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.attachmentModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.attachmentModel[1].addShapeBox(1.0F, -2.0F, -1.5F, 1, 2, 1, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.attachmentModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.attachmentModel[2].addShapeBox(-3.0F, -3.0F, -0.5F, 6, 1, 1, 0.0F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F);
    this.attachmentModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.attachmentModel[3].addShapeBox(1.0F, -3.0F, -0.5F, 1, 1, 1, 0.0F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F);
    this.attachmentModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.attachmentModel[4].addShapeBox(-2.0F, -3.0F, -0.5F, 1, 1, 1, 0.0F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F, 0.0F, 0.3F, 0.3F);
    this.attachmentModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.attachmentModel[5].addShapeBox(-0.5F, -3.0F, -1.0F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.attachmentModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.attachmentModel[6].addShapeBox(-0.5F, -3.5F, -0.5F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.attachmentModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
    this.attachmentModel[7].addShapeBox(1.0F, -2.0F, -1.5F, 1, 2, 1, 0.0F, 3.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 0.0F, -1.5F, 0.0F, 3.0F, -1.5F, 0.0F, 3.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 3.0F, 0.0F, 0.0F);
    this.attachmentModel[7].func_78793_a(0.0F, 0.0F, 0.0F);
    this.renderOffset = 0.0F;
    flipAll();
  }
}
