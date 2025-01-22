package com.flansmod.client.model.monolith;

import com.flansmod.client.model.ModelVehicle;
import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelPolybolos extends ModelVehicle {
  int textureX = 128;
  
  int textureY = 128;
  
  public ModelPolybolos() {
    this.bodyModel = new ModelRendererTurbo[7];
    this.barrelModel = new ModelRendererTurbo[26];
    initbodyModel_1();
    initbarrelModel_1();
    translateAll(0.0F, 0.0F, 0.0F);
    flipAll();
  }
  
  private void initbodyModel_1() {
    this.bodyModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 1, this.textureX, this.textureY);
    this.bodyModel[1] = new ModelRendererTurbo((ModelBase)this, 9, 1, this.textureX, this.textureY);
    this.bodyModel[2] = new ModelRendererTurbo((ModelBase)this, 33, 1, this.textureX, this.textureY);
    this.bodyModel[3] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.bodyModel[4] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.bodyModel[5] = new ModelRendererTurbo((ModelBase)this, 1, 9, this.textureX, this.textureY);
    this.bodyModel[6] = new ModelRendererTurbo((ModelBase)this, 73, 9, this.textureX, this.textureY);
    this.bodyModel[0].func_78790_a(-0.5F, 0.0F, -0.5F, 1, 15, 1, 0.0F);
    this.bodyModel[0].func_78793_a(0.0F, -5.0F, 0.0F);
    this.bodyModel[1].func_78790_a(-0.5F, 0.0F, -0.5F, 17, 1, 1, 0.0F);
    this.bodyModel[1].func_78793_a(-8.0F, 9.0F, 0.0F);
    this.bodyModel[2].func_78790_a(-0.5F, 0.0F, -0.5F, 1, 1, 17, 0.0F);
    this.bodyModel[2].func_78793_a(0.0F, 9.0F, -8.0F);
    this.bodyModel[3].addShapeBox(-0.5F, 0.0F, 0.5F, 1, 1, 11, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[3].func_78793_a(0.0F, 1.0F, 0.0F);
    (this.bodyModel[3]).field_78795_f = -0.80285144F;
    this.bodyModel[4].addShapeBox(-0.5F, 0.0F, 0.5F, 1, 1, 11, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[4].func_78793_a(0.0F, 1.0F, 0.0F);
    (this.bodyModel[4]).field_78795_f = -0.80285144F;
    (this.bodyModel[4]).field_78796_g = -1.5707964F;
    this.bodyModel[5].addShapeBox(-0.5F, 0.0F, 0.5F, 1, 1, 11, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[5].func_78793_a(0.0F, 1.0F, 0.0F);
    (this.bodyModel[5]).field_78795_f = -0.80285144F;
    (this.bodyModel[5]).field_78796_g = -3.1415927F;
    this.bodyModel[6].addShapeBox(-0.5F, 0.0F, 0.5F, 1, 1, 11, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F);
    this.bodyModel[6].func_78793_a(0.0F, 1.0F, 0.0F);
    (this.bodyModel[6]).field_78795_f = -0.80285144F;
    (this.bodyModel[6]).field_78796_g = -4.712389F;
  }
  
  private void initbarrelModel_1() {
    this.barrelModel[0] = new ModelRendererTurbo((ModelBase)this, 1, 25, this.textureX, this.textureY);
    this.barrelModel[1] = new ModelRendererTurbo((ModelBase)this, 105, 17, this.textureX, this.textureY);
    this.barrelModel[2] = new ModelRendererTurbo((ModelBase)this, 73, 25, this.textureX, this.textureY);
    this.barrelModel[3] = new ModelRendererTurbo((ModelBase)this, 1, 33, this.textureX, this.textureY);
    this.barrelModel[4] = new ModelRendererTurbo((ModelBase)this, 33, 33, this.textureX, this.textureY);
    this.barrelModel[5] = new ModelRendererTurbo((ModelBase)this, 89, 25, this.textureX, this.textureY);
    this.barrelModel[6] = new ModelRendererTurbo((ModelBase)this, 73, 33, this.textureX, this.textureY);
    this.barrelModel[7] = new ModelRendererTurbo((ModelBase)this, 49, 33, this.textureX, this.textureY);
    this.barrelModel[8] = new ModelRendererTurbo((ModelBase)this, 73, 1, this.textureX, this.textureY);
    this.barrelModel[9] = new ModelRendererTurbo((ModelBase)this, 121, 1, this.textureX, this.textureY);
    this.barrelModel[10] = new ModelRendererTurbo((ModelBase)this, 17, 9, this.textureX, this.textureY);
    this.barrelModel[11] = new ModelRendererTurbo((ModelBase)this, 1, 57, this.textureX, this.textureY);
    this.barrelModel[12] = new ModelRendererTurbo((ModelBase)this, 105, 1, this.textureX, this.textureY);
    this.barrelModel[13] = new ModelRendererTurbo((ModelBase)this, 25, 33, this.textureX, this.textureY);
    this.barrelModel[14] = new ModelRendererTurbo((ModelBase)this, 57, 1, this.textureX, this.textureY);
    this.barrelModel[15] = new ModelRendererTurbo((ModelBase)this, 57, 57, this.textureX, this.textureY);
    this.barrelModel[16] = new ModelRendererTurbo((ModelBase)this, 1, 65, this.textureX, this.textureY);
    this.barrelModel[17] = new ModelRendererTurbo((ModelBase)this, 105, 41, this.textureX, this.textureY);
    this.barrelModel[18] = new ModelRendererTurbo((ModelBase)this, 57, 65, this.textureX, this.textureY);
    this.barrelModel[19] = new ModelRendererTurbo((ModelBase)this, 1, 73, this.textureX, this.textureY);
    this.barrelModel[20] = new ModelRendererTurbo((ModelBase)this, 57, 73, this.textureX, this.textureY);
    this.barrelModel[21] = new ModelRendererTurbo((ModelBase)this, 1, 81, this.textureX, this.textureY);
    this.barrelModel[22] = new ModelRendererTurbo((ModelBase)this, 57, 81, this.textureX, this.textureY);
    this.barrelModel[23] = new ModelRendererTurbo((ModelBase)this, 1, 89, this.textureX, this.textureY);
    this.barrelModel[24] = new ModelRendererTurbo((ModelBase)this, 57, 89, this.textureX, this.textureY);
    this.barrelModel[25] = new ModelRendererTurbo((ModelBase)this, 89, 1, this.textureX, this.textureY);
    this.barrelModel[0].func_78790_a(-22.5F, -3.0F, -1.0F, 32, 3, 2, 0.0F);
    this.barrelModel[0].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[1].addShapeBox(4.5F, -11.0F, 7.0F, 2, 12, 2, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.barrelModel[1].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[2].addShapeBox(4.5F, -11.0F, -9.0F, 2, 12, 2, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.barrelModel[2].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[3].addShapeBox(4.0F, -1.5F, 0.0F, 3, 2, 10, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, -1.0F, 0.2F, 0.2F, -1.0F, 0.2F);
    this.barrelModel[3].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[4].addShapeBox(4.0F, -1.5F, -10.0F, 3, 2, 10, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, -1.0F, 0.2F, 0.2F, -1.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.barrelModel[4].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[5].addShapeBox(4.5F, -3.5F, 7.5F, 1, 1, 11, 0.0F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, -5.8F, 0.0F, 0.2F, 6.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, -5.8F, 0.0F, 0.2F, 6.2F, 0.0F, 0.2F);
    this.barrelModel[5].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[6].addShapeBox(4.5F, -3.5F, -18.5F, 1, 1, 11, 0.0F, 6.2F, 0.0F, 0.2F, -5.8F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 6.2F, 0.0F, 0.2F, -5.8F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F, 0.2F, 0.0F, 0.2F);
    this.barrelModel[6].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[7].addShapeBox(4.0F, -10.5F, -8.0F, 2, 5, 15, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F);
    this.barrelModel[7].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[8].func_78790_a(-21.5F, -3.5F, -3.0F, 4, 4, 2, 0.0F);
    this.barrelModel[8].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[9].func_78790_a(-20.0F, -8.5F, -2.5F, 1, 14, 1, 0.0F);
    this.barrelModel[9].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[10].func_78790_a(-26.5F, -2.0F, -2.5F, 14, 1, 1, 0.0F);
    this.barrelModel[10].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[11].func_78790_a(-20.5F, -7.0F, -0.5F, 26, 1, 1, 0.0F);
    this.barrelModel[11].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[12].func_78790_a(-20.5F, -10.5F, -1.0F, 5, 4, 2, 0.0F);
    this.barrelModel[12].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[13].func_78790_a(0.5F, -10.5F, -1.0F, 5, 4, 2, 0.0F);
    this.barrelModel[13].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[14].func_78790_a(-20.5F, -6.5F, -0.5F, 2, 4, 1, 0.0F);
    this.barrelModel[14].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[15].addShapeBox(-21.5F, -3.5F, -3.0F, 26, 1, 1, 0.0F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F);
    this.barrelModel[15].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[16].addShapeBox(-21.5F, -0.5F, -3.0F, 26, 1, 1, 0.0F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F, -0.4F, -0.2F, -0.3F);
    this.barrelModel[16].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[17].func_78790_a(0.5F, -3.5F, -3.0F, 4, 4, 2, 0.0F);
    this.barrelModel[17].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[18].addShapeBox(-20.5F, -8.5F, -0.5F, 26, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.barrelModel[18].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[19].addShapeBox(-20.5F, -9.0F, -0.5F, 26, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.barrelModel[19].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[20].addShapeBox(-20.5F, -9.5F, -0.5F, 26, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.barrelModel[20].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[21].addShapeBox(-20.5F, -10.0F, -0.5F, 26, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.barrelModel[21].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[22].addShapeBox(-20.5F, -10.5F, -0.5F, 26, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.barrelModel[22].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[23].addShapeBox(-20.5F, -8.0F, -0.5F, 26, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.barrelModel[23].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[24].addShapeBox(-20.5F, -4.0F, -0.5F, 24, 1, 1, 0.0F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F, 0.0F, -0.3F, -0.3F);
    this.barrelModel[24].func_78793_a(0.0F, -5.0F, 0.0F);
    this.barrelModel[25].addShapeBox(3.5F, -4.0F, -0.5F, 3, 1, 1, 0.0F, 0.0F, -0.2F, -0.2F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.2F, -0.2F, 0.0F, -0.2F, -0.2F, 0.0F, -0.45F, -0.45F, 0.0F, -0.45F, -0.45F, 0.0F, -0.2F, -0.2F);
    this.barrelModel[25].func_78793_a(0.0F, -5.0F, 0.0F);
  }
}
