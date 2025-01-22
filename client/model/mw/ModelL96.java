package com.flansmod.client.model.mw;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelL96 extends ModelGun {
  public ModelL96() {
    int textureX = 64;
    int textureY = 16;
    this.gunModel = new ModelRendererTurbo[3];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 0, 0, textureX, textureY);
    this.gunModel[0].addBox(-0.75F, 1.5F, -0.5F, 20, 1, 1);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 2, textureX, textureY);
    this.gunModel[1].addBox(-1.0F, 0.0F, -1.0F, 13, 2, 2);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 0, 6, textureX, textureY);
    this.gunModel[2].addBox(10.0F, -1.0F, -1.0F, 4, 1, 2);
    this.defaultScopeModel = new ModelRendererTurbo[4];
    this.defaultScopeModel[0] = new ModelRendererTurbo((ModelBase)this, 31, 3, textureX, textureY);
    this.defaultScopeModel[0].addBox(-2.0F, 4.5F, -0.5F, 6, 1, 1);
    this.defaultScopeModel[1] = new ModelRendererTurbo((ModelBase)this, 0, 9, textureX, textureY);
    this.defaultScopeModel[1].addTrapezoid(4.0F, 4.0F, -1.0F, 4, 2, 2, 0.0F, -0.5F, 3);
    this.defaultScopeModel[2] = new ModelRendererTurbo((ModelBase)this, 8, 13, textureX, textureY);
    this.defaultScopeModel[2].addBox(1.0F, 2.5F, -0.5F, 1, 2, 1);
    this.defaultScopeModel[3] = new ModelRendererTurbo((ModelBase)this, 12, 13, textureX, textureY);
    this.defaultScopeModel[3].addBox(3.0F, 2.5F, -0.5F, 1, 2, 1);
    this.scopeAttachPoint = new Vector3f(0.1875F, 0.3125F, 0.0F);
    this.barrelAttachPoint = new Vector3f(1.0625F, 0.28125F, 0.0F);
    this.defaultStockModel = new ModelRendererTurbo[5];
    this.defaultStockModel[0] = new ModelRendererTurbo((ModelBase)this, 27, 10, textureX, textureY);
    this.defaultStockModel[0].addBox(-2.0F, -2.0F, -1.0F, 1, 4, 2);
    this.defaultStockModel[1] = new ModelRendererTurbo((ModelBase)this, 34, 13, textureX, textureY);
    this.defaultStockModel[1].addBox(-5.0F, -2.0F, -1.0F, 3, 1, 2);
    this.defaultStockModel[2] = new ModelRendererTurbo((ModelBase)this, 34, 10, textureX, textureY);
    this.defaultStockModel[2].addBox(-4.0F, 1.0F, -1.0F, 2, 1, 2);
    this.defaultStockModel[3] = new ModelRendererTurbo((ModelBase)this, 30, 5, textureX, textureY);
    this.defaultStockModel[3].addBox(-7.0F, -1.0F, -1.0F, 3, 3, 2);
    this.defaultStockModel[4] = new ModelRendererTurbo((ModelBase)this, 18, 10, textureX, textureY);
    this.defaultStockModel[4].addBox(-9.0F, -2.0F, -1.0F, 2, 4, 2);
    this.stockAttachPoint = new Vector3f(-0.0625F, 0.0625F, 0.0F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 41, 7, textureX, textureY);
    this.ammoModel[0].addShapeBox(3.0F, -2.0F, -1.0F, 3, 2, 2, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    translateAll(0.0F, 2.5F, 0.0F);
    this.gunSlideDistance = 0.5F;
    this.animationType = EnumAnimationType.BOTTOM_CLIP;
  }
}
