package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.guns.EntityAAGun;
import net.minecraft.client.model.ModelBase;

public class ModelAAGun extends ModelBase {
  public boolean oldModel = false;
  
  public void renderBase(float f, float f1, float f2, float f3, float f4, float f5, EntityAAGun aa) {
    for (ModelRendererTurbo aBaseModel : this.baseModel)
      aBaseModel.func_78785_a(f5); 
  }
  
  public void renderGun(float f, float f1, float f2, float f3, float f4, float f5, EntityAAGun aa) {
    for (ModelRendererTurbo aSeatModel : this.seatModel)
      aSeatModel.func_78785_a(f5); 
    for (ModelRendererTurbo aGunModel : this.gunModel) {
      aGunModel.setPosition(this.barrelX, this.barrelY, this.barrelZ);
      aGunModel.field_78808_h = -aa.gunPitch / 180.0F * 3.1415927F;
      aGunModel.func_78785_a(f5);
    } 
    for (ModelRendererTurbo aGunsightModel : this.gunsightModel) {
      aGunsightModel.field_78808_h = -aa.gunPitch / 180.0F * 3.1415927F;
      aGunsightModel.func_78785_a(f5);
    } 
    int i;
    for (i = 0; i < this.barrelModel.length; i++) {
      for (int j = 0; j < (this.barrelModel[i]).length; j++) {
        this.barrelModel[i][j].setPosition(-aa.barrelRecoil[i] * (float)Math.cos((-aa.gunPitch * 3.1415927F / 180.0F)) + this.barrelX, -aa.barrelRecoil[i] * (float)Math.sin((-aa.gunPitch * 3.1415927F / 180.0F)) + this.barrelY, this.barrelZ);
        (this.barrelModel[i][j]).field_78808_h = -aa.gunPitch / 180.0F * 3.1415927F;
        this.barrelModel[i][j].func_78785_a(f5);
      } 
    } 
    for (i = 0; i < this.ammoModel.length; i++) {
      if (aa.ammo[i] != null)
        for (int j = 0; j < (this.ammoModel[i]).length; j++) {
          this.ammoModel[i][j].setPosition(this.barrelX, this.barrelY, this.barrelZ);
          (this.ammoModel[i][j]).field_78808_h = -aa.gunPitch / 180.0F * 3.1415927F;
          this.ammoModel[i][j].func_78785_a(f5);
        }  
    } 
  }
  
  public void setRotationAngles(float f, float f1, float f2, float f3, float f4, float f5) {}
  
  public void flipAll() {
    for (ModelRendererTurbo aBaseModel : this.baseModel) {
      aBaseModel.doMirror(false, true, true);
      aBaseModel.func_78793_a(aBaseModel.field_78800_c, -aBaseModel.field_78797_d, -aBaseModel.field_78798_e);
    } 
    for (ModelRendererTurbo aSeatModel : this.seatModel) {
      aSeatModel.doMirror(false, true, true);
      aSeatModel.func_78793_a(aSeatModel.field_78800_c, -aSeatModel.field_78797_d, -aSeatModel.field_78798_e);
    } 
    for (ModelRendererTurbo aGunModel : this.gunModel) {
      aGunModel.doMirror(false, true, true);
      aGunModel.func_78793_a(aGunModel.field_78800_c, -aGunModel.field_78797_d, -aGunModel.field_78798_e);
    } 
    for (ModelRendererTurbo aGunsightModel : this.gunsightModel) {
      aGunsightModel.doMirror(false, true, true);
      aGunsightModel.func_78793_a(aGunsightModel.field_78800_c, -aGunsightModel.field_78797_d, -aGunsightModel.field_78798_e);
    } 
    for (ModelRendererTurbo[] aBarrelModel : this.barrelModel) {
      for (int j = 0; j < aBarrelModel.length; j++) {
        aBarrelModel[j].doMirror(false, true, true);
        aBarrelModel[j].func_78793_a((aBarrelModel[j]).field_78800_c, -(aBarrelModel[j]).field_78797_d, -(aBarrelModel[j]).field_78798_e);
      } 
    } 
    for (ModelRendererTurbo[] anAmmoModel : this.ammoModel) {
      for (int j = 0; j < anAmmoModel.length; j++) {
        anAmmoModel[j].doMirror(false, true, true);
        anAmmoModel[j].func_78793_a((anAmmoModel[j]).field_78800_c, -(anAmmoModel[j]).field_78797_d, -(anAmmoModel[j]).field_78798_e);
      } 
    } 
  }
  
  public ModelRendererTurbo[] baseModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] seatModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] gunModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[][] barrelModel = new ModelRendererTurbo[0][0];
  
  public ModelRendererTurbo[][] ammoModel = new ModelRendererTurbo[0][0];
  
  public ModelRendererTurbo[] gunsightModel = new ModelRendererTurbo[0];
  
  public int barrelX;
  
  public int barrelY;
  
  public int barrelZ;
}
