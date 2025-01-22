package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelForegrip extends ModelAttachment {
  public ModelForegrip() {
    int textureX = 16;
    int textureY = 8;
    this.attachmentModel = new ModelRendererTurbo[2];
    this.attachmentModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.attachmentModel[0].addBox(-2.0F, -1.0F, -1.0F, 4, 1, 2);
    this.attachmentModel[1] = new ModelRendererTurbo((ModelBase)this, 10, 1, textureX, textureY);
    this.attachmentModel[1].addBox(-1.0F, -6.0F, -1.0F, 2, 5, 2);
  }
}
