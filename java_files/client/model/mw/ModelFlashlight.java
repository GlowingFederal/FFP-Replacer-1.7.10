package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelFlashlight extends ModelAttachment {
  public ModelFlashlight() {
    int textureX = 16;
    int textureY = 16;
    this.attachmentModel = new ModelRendererTurbo[3];
    this.attachmentModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.attachmentModel[0].addBox(-2.0F, -1.0F, -0.5F, 4, 1, 1);
    this.attachmentModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 2, textureX, textureY);
    this.attachmentModel[1].addBox(-2.5F, -3.0F, -1.0F, 5, 2, 2);
    this.attachmentModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 6, textureX, textureY);
    this.attachmentModel[2].addBox(2.5F, -3.5F, -1.5F, 1, 3, 3);
  }
}
