package com.flansmod.client.model.ww2;

import com.flansmod.client.model.EnumAnimationType;
import com.flansmod.client.model.ModelGun;
import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelSpringfieldSniper extends ModelGun {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelSpringfieldSniper() {
    this.gunModel = new ModelRendererTurbo[40];
    this.gunModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[1] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[2] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.gunModel[3] = new ModelRendererTurbo((ModelBase)this, 97, 9, this.textureX, this.textureY);
    this.gunModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 17, this.textureX, this.textureY);
    this.gunModel[5] = new ModelRendererTurbo((ModelBase)this, 49, 17, this.textureX, this.textureY);
    this.gunModel[6] = new ModelRendererTurbo((ModelBase)this, 81, 17, this.textureX, this.textureY);
    this.gunModel[7] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.gunModel[8] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.gunModel[9] = new ModelRendererTurbo((ModelBase)this, 25, 25, this.textureX, this.textureY);
    this.gunModel[10] = new ModelRendererTurbo((ModelBase)this, 49, 25, this.textureX, this.textureY);
    this.gunModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.gunModel[12] = new ModelRendererTurbo((ModelBase)this, 81, 33, this.textureX, this.textureY);
    this.gunModel[13] = new ModelRendererTurbo((ModelBase)this, 1, 41, this.textureX, this.textureY);
    this.gunModel[14] = new ModelRendererTurbo((ModelBase)this, 57, 41, this.textureX, this.textureY);
    this.gunModel[15] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.gunModel[16] = new ModelRendererTurbo((ModelBase)this, 17, 1, this.textureX, this.textureY);
    this.gunModel[17] = new ModelRendererTurbo((ModelBase)this, 41, 17, this.textureX, this.textureY);
    this.gunModel[18] = new ModelRendererTurbo((ModelBase)this, 25, 1, this.textureX, this.textureY);
    this.gunModel[19] = new ModelRendererTurbo((ModelBase)this, 49, 9, this.textureX, this.textureY);
    this.gunModel[20] = new ModelRendererTurbo((ModelBase)this, 97, 25, this.textureX, this.textureY);
    this.gunModel[21] = new ModelRendererTurbo((ModelBase)this, 33, 49, this.textureX, this.textureY);
    this.gunModel[22] = new ModelRendererTurbo((ModelBase)this, 105, 41, this.textureX, this.textureY);
    this.gunModel[23] = new ModelRendererTurbo((ModelBase)this, 73, 57, this.textureX, this.textureY);
    this.gunModel[24] = new ModelRendererTurbo((ModelBase)this, 81, 49, this.textureX, this.textureY);
    this.gunModel[25] = new ModelRendererTurbo((ModelBase)this, 97, 49, this.textureX, this.textureY);
    this.gunModel[26] = new ModelRendererTurbo((ModelBase)this, 49, 1, this.textureX, this.textureY);
    this.gunModel[27] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.gunModel[28] = new ModelRendererTurbo((ModelBase)this, 17, 25, this.textureX, this.textureY);
    this.gunModel[29] = new ModelRendererTurbo((ModelBase)this, 121, 17, this.textureX, this.textureY);
    this.gunModel[30] = new ModelRendererTurbo((ModelBase)this, 41, 25, this.textureX, this.textureY);
    this.gunModel[31] = new ModelRendererTurbo((ModelBase)this, 113, 49, this.textureX, this.textureY);
    this.gunModel[32] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.gunModel[33] = new ModelRendererTurbo((ModelBase)this, 17, 65, this.textureX, this.textureY);
    this.gunModel[34] = new ModelRendererTurbo((ModelBase)this, 121, 25, this.textureX, this.textureY);
    this.gunModel[35] = new ModelRendererTurbo((ModelBase)this, 121, 41, this.textureX, this.textureY);
    this.gunModel[36] = new ModelRendererTurbo((ModelBase)this, 41, 65, this.textureX, this.textureY);
    this.gunModel[37] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.gunModel[38] = new ModelRendererTurbo((ModelBase)this, 33, 73, this.textureX, this.textureY);
    this.gunModel[39] = new ModelRendererTurbo((ModelBase)this, 33, 73, this.textureX, this.textureY);
    this.gunModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 4, 3, 5, 0.0F, 2.0F, -2.0F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 2.0F, -2.0F, -0.5F, 0.5F, 3.0F, -0.5F, 1.0F, 1.0F, 0.0F, 1.0F, 1.0F, 0.0F, 0.5F, 3.0F, -0.5F);
    this.gunModel[0].func_78793_a(-5.5F, -8.0F, -2.5F);
    this.gunModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 7, 4, 5, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[1].func_78793_a(-0.5F, -8.0F, -2.5F);
    this.gunModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 18, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -12.0F, 0.0F, 0.0F, -12.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[2].func_78793_a(-24.0F, -2.0F, -2.0F);
    this.gunModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 10, 1, 5, 0.0F, -1.0F, 1.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, -1.0F, 1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[3].func_78793_a(18.5F, -10.0F, -2.5F);
    this.gunModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 15, 1, 5, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[4].func_78793_a(33.5F, -10.0F, -2.5F);
    this.gunModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 10, 2, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.1F, 0.0F, 0.0F, -1.1F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[5].func_78793_a(18.5F, -9.0F, -2.5F);
    this.gunModel[6].addShapeBox(0.0F, 0.0F, 0.0F, 15, 1, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.gunModel[6].func_78793_a(33.5F, -7.0F, -2.5F);
    this.gunModel[7].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 5, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[7].func_78793_a(28.5F, -10.0F, -2.5F);
    this.gunModel[8].func_78790_a(0.0F, 0.0F, 0.0F, 5, 2, 5, 0.0F);
    this.gunModel[8].func_78793_a(28.5F, -9.0F, -2.5F);
    this.gunModel[9].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.gunModel[9].func_78793_a(28.5F, -7.0F, -2.5F);
    this.gunModel[10].addShapeBox(0.0F, 0.0F, 0.0F, 15, 2, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[10].func_78793_a(33.5F, -9.0F, -2.5F);
    this.gunModel[11].addShapeBox(0.0F, 0.0F, 0.0F, 37, 2, 2, 0.0F, 0.0F, -0.1F, -0.1F, 4.0F, -0.1F, -0.1F, 4.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F, 4.0F, -0.1F, -0.1F, 4.0F, -0.1F, -0.1F, 0.0F, -0.1F, -0.1F);
    this.gunModel[11].func_78793_a(21.5F, -9.75F, -1.0F);
    this.gunModel[12].addShapeBox(0.0F, 0.0F, 0.0F, 12, 2, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.1F, 0.0F, 0.0F, -1.1F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[12].func_78793_a(6.5F, -8.0F, -2.5F);
    this.gunModel[13].addShapeBox(0.0F, 0.0F, 0.0F, 22, 1, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F);
    this.gunModel[13].func_78793_a(6.5F, -5.0F, -2.5F);
    (this.gunModel[13]).field_78808_h = 0.09424778F;
    this.gunModel[14].addShapeBox(0.0F, 0.0F, 0.0F, 19, 1, 4, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[14].func_78793_a(0.0F, -9.0F, -2.0F);
    this.gunModel[15].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[15].func_78793_a(0.5F, -4.0F, -0.5F);
    this.gunModel[16].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[16].func_78793_a(5.5F, -4.0F, -0.5F);
    this.gunModel[17].addShapeBox(0.0F, 0.0F, 0.0F, 5, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[17].func_78793_a(1.0F, -2.0F, -0.5F);
    this.gunModel[18].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[18].func_78793_a(3.0F, -4.5F, -0.5F);
    (this.gunModel[18]).field_78808_h = 0.2268928F;
    this.gunModel[19].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 2, 0.0F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F, 0.0F, 0.0F, -0.15F);
    this.gunModel[19].func_78793_a(55.25F, -10.5F, -1.0F);
    this.gunModel[20].addShapeBox(0.0F, 0.0F, 0.0F, 4, 2, 4, 0.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[20].func_78793_a(14.5F, -11.0F, -2.0F);
    this.gunModel[21].addShapeBox(0.0F, 0.0F, 0.0F, 18, 4, 4, 0.0F, 0.5F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, -1.0F, 0.0F, 0.0F, 0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[21].func_78793_a(-24.0F, -6.0F, -2.0F);
    this.gunModel[22].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[22].func_78793_a(48.5F, -9.85F, -1.5F);
    this.gunModel[23].addShapeBox(0.0F, 0.0F, 0.0F, 22, 1, 5, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[23].func_78793_a(6.5F, -6.0F, -2.5F);
    (this.gunModel[23]).field_78808_h = 0.09424778F;
    this.gunModel[24].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[24].func_78793_a(49.5F, -8.85F, -1.5F);
    this.gunModel[25].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[25].func_78793_a(50.5F, -9.85F, -1.5F);
    this.gunModel[26].addShapeBox(0.0F, 0.0F, 0.0F, 2, 3, 1, 0.0F, 0.0F, 0.0F, -0.34F, -1.0F, 0.0F, -0.34F, -1.0F, 0.0F, -0.34F, 0.0F, 0.0F, -0.34F, 0.0F, 0.0F, -0.34F, 0.0F, 0.0F, -0.34F, 0.0F, 0.0F, -0.34F, 0.0F, 0.0F, -0.34F);
    this.gunModel[26].func_78793_a(55.5F, -12.0F, -0.5F);
    this.gunModel[27].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.gunModel[27].func_78793_a(55.25F, -11.0F, -0.5F);
    this.gunModel[28].addShapeBox(0.0F, 0.0F, 0.0F, 3, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[28].func_78793_a(15.0F, -11.5F, -1.5F);
    this.gunModel[29].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.gunModel[29].func_78793_a(15.0F, -12.0F, -1.25F);
    this.gunModel[30].addShapeBox(0.0F, 0.0F, 0.0F, 2, 1, 1, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.gunModel[30].func_78793_a(15.0F, -12.0F, 0.25F);
    this.gunModel[31].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[31].func_78793_a(12.5F, -10.5F, -1.5F);
    this.gunModel[32].addShapeBox(0.0F, 0.0F, 0.0F, 13, 2, 1, 0.0F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F);
    this.gunModel[32].func_78793_a(1.5F, -10.25F, 1.0F);
    this.gunModel[33].addShapeBox(0.0F, 0.0F, 0.0F, 5, 4, 4, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[33].func_78793_a(32.0F, -15.5F, -2.0F);
    this.gunModel[34].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[34].func_78793_a(13.0F, -12.5F, -1.0F);
    this.gunModel[35].addShapeBox(0.0F, 0.0F, 0.0F, 1, 3, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[35].func_78793_a(25.0F, -12.5F, -1.0F);
    this.gunModel[36].addShapeBox(0.0F, 0.0F, 0.0F, 32, 2, 2, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -6.0F, 0.0F, 0.0F);
    this.gunModel[36].func_78793_a(0.0F, -14.5F, -1.0F);
    this.gunModel[37].addShapeBox(0.0F, 0.0F, 0.0F, 5, 4, 4, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F, 0.0F, -1.0F, -1.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -1.0F, -1.0F);
    this.gunModel[37].func_78793_a(27.0F, -15.5F, -2.0F);
    this.gunModel[38].addShapeBox(0.0F, 0.0F, 0.0F, 5, 3, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, -0.5F, -0.5F, 0.0F, -0.5F, -0.5F, 0.0F, 0.0F, 0.0F);
    this.gunModel[38].func_78793_a(6.0F, -15.0F, -1.5F);
    this.gunModel[39].addShapeBox(0.0F, 0.0F, 0.0F, 5, 3, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.gunModel[39].func_78793_a(1.0F, -15.0F, -1.5F);
    this.ammoModel = new ModelRendererTurbo[1];
    this.ammoModel[0] = new ModelRendererTurbo((ModelBase)this, 113, 65, this.textureX, this.textureY);
    this.ammoModel[0].func_78790_a(5.0F, -9.5F, 0.0F, 6, 5, 1, 0.0F);
    this.ammoModel[0].func_78793_a(0.0F, 0.0F, -0.5F);
    this.pumpModel = new ModelRendererTurbo[6];
    this.pumpModel[0] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.pumpModel[1] = new ModelRendererTurbo((ModelBase)this, 1, 49, this.textureX, this.textureY);
    this.pumpModel[2] = new ModelRendererTurbo((ModelBase)this, 113, 33, this.textureX, this.textureY);
    this.pumpModel[3] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.pumpModel[4] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.pumpModel[5] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.pumpModel[0].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 3, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F);
    this.pumpModel[0].func_78793_a(1.5F, -10.5F, -1.5F);
    this.pumpModel[1].addShapeBox(0.0F, 0.0F, 0.0F, 13, 2, 2, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pumpModel[1].func_78793_a(-0.5F, -9.75F, -1.0F);
    this.pumpModel[2].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 3, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pumpModel[2].func_78793_a(2.0F, -9.5F, -4.0F);
    (this.pumpModel[2]).field_78795_f = 0.17453294F;
    this.pumpModel[3].addShapeBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pumpModel[3].func_78793_a(1.5F, -10.0F, -4.5F);
    (this.pumpModel[3]).field_78795_f = 0.17453294F;
    this.pumpModel[4].addShapeBox(0.0F, 0.0F, 0.0F, 1, 2, 3, 0.0F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F, 0.0F, 0.0F, -0.5F);
    this.pumpModel[4].func_78793_a(-2.5F, -10.0F, -1.5F);
    this.pumpModel[5].addShapeBox(0.0F, 0.0F, 0.0F, 1, 1, 1, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.pumpModel[5].func_78793_a(-1.5F, -9.5F, -0.5F);
    this.gunSlideDistance = 0.08F;
    this.pumpDelayAfterReload = 65;
    this.pumpDelay = 11;
    this.pumpTime = 9;
    this.animationType = EnumAnimationType.RIFLE_TOP;
    this.numBulletsInReloadAnimation = 1.0F;
    this.tiltGunTime = 0.25F;
    this.unloadClipTime = 0.0F;
    this.loadClipTime = 0.35F;
    this.untiltGunTime = 0.4F;
    translateAll(0.0F, -9.0F, 0.0F);
    this.thirdPersonOffset = new Vector3f(-0.2F, -0.2F, 0.01F);
    flipAll();
  }
}
