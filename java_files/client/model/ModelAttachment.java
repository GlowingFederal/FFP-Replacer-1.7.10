package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.vector.Vector3f;
import net.minecraft.client.model.ModelBase;

public class ModelAttachment extends ModelBase {
  public ModelRendererTurbo[] attachmentModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] ammoModel = new ModelRendererTurbo[0];
  
  public EnumAnimationType secondaryAnimType = EnumAnimationType.NONE;
  
  public float tiltGunTime = 0.15F, unloadClipTime = 0.35F, loadClipTime = 0.35F, untiltGunTime = 0.15F;
  
  public float numBulletsInReloadAnimation = 1.0F;
  
  public float endLoadedAmmoDistance = 1.0F;
  
  public float renderOffset = 0.0F;
  
  public float recoilDistance = 0.125F;
  
  public float recoilAngle = -8.0F;
  
  public Vector3f attachmentFlashOffset = new Vector3f(0.0F, 0.0F, 0.0F);
  
  public void renderAttachment(float f) {
    for (ModelRendererTurbo model : this.attachmentModel) {
      if (model != null)
        model.func_78785_a(f); 
    } 
  }
  
  public void renderAttachmentAmmo(float f) {
    for (ModelRendererTurbo model : this.ammoModel) {
      if (model != null)
        model.func_78785_a(f); 
    } 
  }
  
  public void flipAll() {
    for (ModelRendererTurbo anAttachmentModel : this.attachmentModel) {
      anAttachmentModel.doMirror(false, true, true);
      anAttachmentModel.func_78793_a(anAttachmentModel.field_78800_c, -anAttachmentModel.field_78797_d, -anAttachmentModel.field_78798_e);
    } 
    for (ModelRendererTurbo anAmmoModel : this.ammoModel) {
      anAmmoModel.doMirror(false, true, true);
      anAmmoModel.func_78793_a(anAmmoModel.field_78800_c, -anAmmoModel.field_78797_d, -anAmmoModel.field_78798_e);
    } 
  }
}
