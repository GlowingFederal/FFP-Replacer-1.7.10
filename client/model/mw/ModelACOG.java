package com.flansmod.client.model.mw;

import com.flansmod.client.model.ModelAttachment;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelACOG extends ModelAttachment {
  public ModelACOG() {
    int textureX = 128;
    int textureY = 128;
    this.attachmentModel = new ModelRendererTurbo[6];
    this.attachmentModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.attachmentModel[0].addBox(-16.0F, 0.0F, -6.0F, 32, 3, 12);
    this.attachmentModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 111, textureX, textureY);
    this.attachmentModel[1].addBox(-16.0F, 3.0F, -8.0F, 32, 1, 16);
    this.attachmentModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 77, textureX, textureY);
    this.attachmentModel[2].addBox(-16.0F, 20.0F, -8.0F, 32, 1, 16);
    this.attachmentModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 94, textureX, textureY);
    this.attachmentModel[3].addBox(-16.0F, 4.0F, -9.0F, 32, 16, 1);
    this.attachmentModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 60, textureX, textureY);
    this.attachmentModel[4].addBox(-16.0F, 4.0F, 8.0F, 32, 16, 1);
    this.attachmentModel[5] = new ModelRendererTurbo((ModelBase)this, 0, 19, textureX, textureY);
    this.attachmentModel[5].addBox(-15.0F, 10.5F, -1.5F, 30, 3, 3);
    this.renderOffset = 0.0F;
  }
}
