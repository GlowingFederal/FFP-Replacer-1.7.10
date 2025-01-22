package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import net.minecraft.client.model.ModelBase;

public class ModelFlash extends ModelBase {
  public ModelRendererTurbo[][] flashModel = new ModelRendererTurbo[0][0];
  
  public void renderFlash(float f, int i) {
    if (this.flashModel[i] != null)
      render(this.flashModel[i], f); 
  }
  
  public void render(ModelRendererTurbo[] flash, float f) {
    for (ModelRendererTurbo model : flash) {
      if (model != null)
        model.func_78785_a(f); 
    } 
  }
  
  protected void flipAll() {
    for (ModelRendererTurbo[] model : this.flashModel) {
      for (ModelRendererTurbo flash : model) {
        flash.doMirror(false, true, true);
        flash.func_78793_a(flash.field_78800_c, -flash.field_78797_d, -flash.field_78798_e);
      } 
    } 
  }
}
