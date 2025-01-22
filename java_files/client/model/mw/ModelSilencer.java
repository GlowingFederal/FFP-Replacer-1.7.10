package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelSilencer extends ModelAttachment {
  public ModelSilencer() {
    int textureX = 16;
    int textureY = 4;
    this.attachmentModel = new ModelRendererTurbo[1];
    this.attachmentModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.attachmentModel[0].addBox(0.0F, -1.0F, -1.0F, 6, 2, 2);
  }
}
