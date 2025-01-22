package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelCustomArmour;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelLiripipe extends ModelCustomArmour {
  int textureX = 64;
  
  int textureY = 64;
  
  public ModelLiripipe() {
    this.headModel = new ModelRendererTurbo[7];
    this.bodyModel = new ModelRendererTurbo[2];
    this.leftArmModel = new ModelRendererTurbo[1];
    this.rightArmModel = new ModelRendererTurbo[1];
    initheadModel_1();
    initbodyModel_1();
    initleftArmModel_1();
    initrightArmModel_1();
  }
  
  private void initheadModel_1() {
    this.headModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[1] = new ModelRendererTurbo((ModelBase)this, 41, 1, this.textureX, this.textureY);
    this.headModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 17, this.textureX, this.textureY);
    this.headModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.headModel[4] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.headModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.headModel[6] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.headModel[0].addShapeBox(-4.0F, -8.0F, -3.0F, 8, 8, 8, 0.0F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, 0.8F, 0.8F, 0.0F, 0.8F, 0.8F, 0.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 1.0F);
    this.headModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[1].addShapeBox(-4.0F, -8.0F, 7.0F, 8, 8, 1, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 1.0F, -3.0F, -4.5F, 0.0F, -3.0F, -4.5F, 0.0F, 0.0F, 0.5F, 1.0F, 0.0F, 0.5F, 1.0F, -3.0F, 3.8F, 0.0F, -3.0F, 3.8F, 0.0F);
    this.headModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[2].addShapeBox(-4.0F, -3.0F, 8.0F, 8, 6, 1, 0.0F, -3.0F, 0.5F, 0.0F, -3.0F, 0.5F, 0.0F, -3.5F, -10.0F, 1.0F, -3.5F, -10.0F, 1.0F, -3.0F, 0.8F, 0.0F, -3.0F, 0.8F, 0.0F, -3.5F, 5.0F, 1.0F, -3.5F, 5.0F, 1.0F);
    this.headModel[2].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[3].addShapeBox(-4.0F, -8.01F, -4.01F, 8, 1, 1, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.5F, 0.5F, 0.0F, 0.5F, 0.5F, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.55F, 0.0F, 0.0F, 0.55F, 0.0F, 0.0F);
    this.headModel[3].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[4].addShapeBox(-4.0F, -0.69F, -4.01F, 8, 1, 1, 0.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.5F, 0.75F, 0.0F, 0.0F, 0.75F, 0.0F, 0.0F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.8F, 0.5F, 0.0F, 0.8F, 0.5F, 0.0F);
    this.headModel[4].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[5].addShapeBox(-4.0F, -7.0F, -4.0F, 1, 6, 1, 0.0F, 0.0F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.55F, 0.0F, 0.0F, 0.0F, 0.3F, 0.5F, -0.5F, 0.3F, 0.5F, 0.0F, 0.3F, 0.0F, 0.75F, 0.3F, 0.0F);
    this.headModel[5].func_78793_a(0.0F, 0.0F, 0.0F);
    this.headModel[6].addShapeBox(3.5F, -7.0F, -4.0F, 1, 6, 1, 0.0F, 0.0F, 0.0F, 0.5F, -0.5F, 0.0F, 0.5F, 0.05F, 0.0F, 0.0F, 0.55F, 0.0F, 0.0F, 0.0F, 0.3F, 0.5F, -0.5F, 0.3F, 0.5F, 0.25F, 0.3F, 0.0F, 0.75F, 0.3F, 0.0F);
    this.headModel[6].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 17, 33, this.textureX, this.textureY);
    this.bodyModel[0].addShapeBox(-0.5F, -0.4F, -2.0F, 5, 2, 4, 0.0F, -0.3F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, -0.3F, 0.0F, 0.5F, -0.4F, 3.0F, 0.7F, 0.2F, 2.0F, 0.5F, 0.2F, 2.0F, 0.5F, -0.5F, 3.0F, 0.7F);
    this.bodyModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
    this.bodyModel[1].addShapeBox(-4.8F, -0.4F, -2.0F, 5, 2, 4, 0.0F, 0.2F, 0.0F, 0.5F, -0.3F, 0.0F, 0.5F, -0.3F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 2.0F, 0.5F, -0.3F, 3.0F, 0.7F, -0.5F, 3.0F, 0.7F, 0.2F, 2.0F, 0.5F);
    this.bodyModel[1].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initleftArmModel_1() {
    this.leftArmModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.leftArmModel[0].addShapeBox(-0.1F, -2.4F, -2.0F, 2, 1, 4, 0.0F, 0.2F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 3.0F, 0.5F, 0.0F, 0.7F, 0.5F, 0.0F, 0.7F, 0.5F, 0.2F, 3.0F, 0.5F);
    this.leftArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
  
  private void initrightArmModel_1() {
    this.rightArmModel[0] = new ModelRendererTurbo((ModelBase)this, 41, 33, this.textureX, this.textureY);
    this.rightArmModel[0].addShapeBox(-2.1F, -2.4F, -2.0F, 2, 1, 4, 0.0F, -0.4F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, 0.2F, 0.0F, 0.5F, -0.4F, 0.0F, 0.5F, 0.0F, 0.7F, 0.5F, 0.2F, 3.0F, 0.5F, 0.2F, 3.0F, 0.5F, 0.0F, 0.7F, 0.5F);
    this.rightArmModel[0].func_78793_a(0.0F, 0.0F, 0.0F);
  }
}
