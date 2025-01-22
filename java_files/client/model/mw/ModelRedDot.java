package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelRedDot extends ModelAttachment {
  public ModelRedDot() {
    int textureX = 128;
    int textureY = 32;
    this.attachmentModel = new ModelRendererTurbo[5];
    this.attachmentModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.attachmentModel[0].addBox(-16.0F, 0.0F, -8.0F, 32, 3, 16);
    this.attachmentModel[1] = new ModelRendererTurbo((ModelBase)this, 96, 0, textureX, textureY);
    this.attachmentModel[1].addBox(15.0F, 3.0F, 7.0F, 1, 14, 1);
    this.attachmentModel[2] = new ModelRendererTurbo((ModelBase)this, 100, 0, textureX, textureY);
    this.attachmentModel[2].addBox(15.0F, 3.0F, -8.0F, 1, 14, 1);
    this.attachmentModel[3] = new ModelRendererTurbo((ModelBase)this, 88, 3, textureX, textureY);
    this.attachmentModel[3].addBox(15.0F, 17.0F, -8.0F, 1, 1, 16);
    this.attachmentModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.attachmentModel[4].addBox(15.0F, 9.5F, -0.5F, 1, 1, 1);
  }
}
