package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelA91 extends ModelGun {
  int textureX = 64;
  
  int textureY = 16;
  
  public ModelA91() {
    this.gunModel = new ModelRendererTurbo[16];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 32, 5, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 5, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 0, 9, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 0, 12, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 10, 3, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 10, 5, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 22, 3, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 14, 5, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 32, 0, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 36, 0, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 12, 13, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 6, 12, this.textureX, this.textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 16, 7, this.textureX, this.textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 0, 5, this.textureX, this.textureY);
    this.gunModel[15] = new ModelRendererTurbo((ModelBase)this, 40, 0, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 15, 1, 2, 0.0F, 0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[0].func_78793_a(-7.0F, -3.0F, -1.0F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 4, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F, 0.0F, -0.5F, -0.25F);
    this.gunModel[1].func_78793_a(4.0F, -2.0F, -1.0F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, -0.5F, -0.25F, -0.25F, -0.5F, -0.25F, -0.25F, -0.5F, -0.25F, -0.25F, -0.5F, -0.25F);
    this.gunModel[2].func_78793_a(0.0F, -2.0F, -1.0F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 2, 0.0F, 0.5F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.5F, 0.0F, -0.25F, 0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F);
    this.gunModel[3].func_78793_a(-7.0F, -4.0F, -1.0F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 1.0F, -0.5F, 0.0F, 1.0F, -0.5F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[4].func_78793_a(-2.0F, -4.0F, -1.0F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.gunModel[5].func_78793_a(-1.0F, -5.0F, -0.5F);
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 2, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.25F, -0.5F, 0.0F, -0.25F, -0.5F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F);
    this.gunModel[6].func_78793_a(3.5F, -5.0F, -1.0F);
    this.gunModel[7].func_78790_a(0.0F, 0.0F, 0.0F, 6, 1, 1, 0.0F);
    this.gunModel[7].func_78793_a(-1.0F, -3.5F, -0.5F);
    this.gunModel[8].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 1, 0.0F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F);
    this.gunModel[8].func_78793_a(8.0F, -3.0F, -0.5F);
    this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F);
    this.gunModel[9].func_78793_a(11.0F, -3.0F, -0.5F);
    this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[10].func_78793_a(7.0F, -5.0F, -0.5F);
    this.gunModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F, 0.25F, -0.8F, -0.25F, 0.0F, -0.8F, -0.25F, 0.0F, -0.8F, -0.25F, 0.25F, -0.8F, -0.25F, 0.25F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, -0.25F, 0.25F, 0.0F, -0.25F);
    this.gunModel[11].func_78793_a(2.0F, -1.5F, -1.0F);
    this.gunModel[12].addShapeBox(-8.0F, -4.0F, -1.0F, 1, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[13].addShapeBox(-6.0F, -2.0F, -1.0F, 2, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F);
    this.gunModel[14].addShapeBox(0.0F, -0.5F, -1.0F, 2, 2, 2, 0.0F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, -0.5F, -0.25F, 0.0F, -0.25F, -0.25F, 0.0F, -0.25F, -0.25F, -0.25F, -0.5F, -0.25F);
    this.gunModel[15].addShapeBox(-8.0F, -2.0F, -1.0F, 1, 1, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[3];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 24, 5, this.textureX, this.textureY);
    this.ammoModel[1] = new ModelRendererTurbo((ModelBase)this, 24, 8, this.textureX, this.textureY);
    this.ammoModel[2] = new ModelRendererTurbo((ModelBase)this, 24, 12, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
    this.ammoModel[0].func_78793_a(-4.0F, -2.0F, -1.0F);
    this.ammoModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, 0.25F, 0.0F, 0.0F, -0.25F, 0.0F, 0.0F);
    this.ammoModel[1].func_78793_a(-4.0F, -1.0F, -1.0F);
    this.ammoModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, 0.25F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, -0.5F, 0.25F, 0.0F);
    this.ammoModel[2].func_78793_a(-3.75F, 1.0F, -1.0F);
    this.barrelAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.stockAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.scopeAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.gripAttachPoint = new Vector3f(0.0F, 0.0F, 0.0F);
    this.gunSlideDistance = 0.0F;
    this.animationType = EnumAnimationType.BULLPUP;
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
}
