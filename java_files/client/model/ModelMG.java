package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.guns.EntityMG;
import net.minecraft.client.model.ModelBase;

public class ModelMG extends ModelBase {
  public ModelRendererTurbo[] bipodModel;
  
  public ModelRendererTurbo[] gunModel;
  
  public ModelRendererTurbo[] ammoModel;
  
  public ModelRendererTurbo[] ammoBoxModel = new ModelRendererTurbo[0];
  
  public void renderBipod(float f, float f1, float f2, float f3, float f4, float f5, EntityMG mg) {
    for (ModelRendererTurbo bipodPart : this.bipodModel)
      bipodPart.func_78785_a(f5); 
    if (mg.reloadTimer > 0 || mg.ammo == null)
      return; 
    for (ModelRendererTurbo ammoBoxPart : this.ammoBoxModel)
      ammoBoxPart.func_78785_a(f5); 
  }
  
  public void renderGun(float f, float f1, float f2, float f3, float f4, float f5, float f6, EntityMG mg) {
    for (ModelRendererTurbo gunPart : this.gunModel) {
      gunPart.field_78795_f = -(mg.field_70127_C + (mg.field_70125_A - mg.field_70127_C) * f6) / 180.0F * 3.1415927F;
      gunPart.func_78785_a(f5);
    } 
    if (mg.reloadTimer > 0 || mg.ammo == null)
      return; 
    for (ModelRendererTurbo ammoPart : this.ammoModel) {
      ammoPart.field_78795_f = -(mg.field_70127_C + (mg.field_70125_A - mg.field_70127_C) * f6) / 180.0F * 3.1415927F;
      ammoPart.func_78785_a(f5);
    } 
  }
  
  public void flipAll() {
    for (ModelRendererTurbo aBipodModel : this.bipodModel) {
      aBipodModel.doMirror(false, true, true);
      aBipodModel.func_78793_a(aBipodModel.field_78800_c, -aBipodModel.field_78797_d, -aBipodModel.field_78798_e);
    } 
    for (ModelRendererTurbo aGunModel : this.gunModel) {
      aGunModel.doMirror(false, true, true);
      aGunModel.func_78793_a(aGunModel.field_78800_c, -aGunModel.field_78797_d, -aGunModel.field_78798_e);
    } 
    for (ModelRendererTurbo anAmmoModel : this.ammoModel) {
      anAmmoModel.doMirror(false, true, true);
      anAmmoModel.func_78793_a(anAmmoModel.field_78800_c, -anAmmoModel.field_78797_d, -anAmmoModel.field_78798_e);
    } 
    for (ModelRendererTurbo anAmmoBoxModel : this.ammoBoxModel) {
      anAmmoBoxModel.doMirror(false, true, true);
      anAmmoBoxModel.func_78793_a(anAmmoBoxModel.field_78800_c, -anAmmoBoxModel.field_78797_d, -anAmmoBoxModel.field_78798_e);
    } 
  }
}
