package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.driveables.mechas.EntityMecha;
import net.minecraft.client.model.ModelBase;
import org.lwjgl.opengl.GL11;

public class ModelMechaTool extends ModelBase {
  public ModelRendererTurbo[] baseModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] drillModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] sawModel = new ModelRendererTurbo[0];
  
  public void render(EntityMecha mecha, float f1) {
    float f5 = 0.0625F;
    for (ModelRendererTurbo model : this.baseModel)
      model.func_78785_a(f5); 
  }
  
  public void renderDrill(EntityMecha mecha, float f1) {
    float f5 = 0.0625F;
    for (ModelRendererTurbo model : this.drillModel)
      model.func_78785_a(f5); 
  }
  
  public void renderSaw(EntityMecha mecha, float f1, boolean spin) {
    float f5 = 0.0625F;
    for (ModelRendererTurbo model : this.sawModel) {
      GL11.glPushMatrix();
      if (spin) {
        GL11.glTranslatef(model.field_78800_c / 16.0F, model.field_78797_d / 16.0F, model.field_78798_e / 16.0F);
        GL11.glRotatef(25.0F * mecha.field_70173_aa, 0.0F, 1.0F, 0.0F);
        GL11.glTranslatef(-model.field_78800_c / 16.0F, -model.field_78797_d / 16.0F, -model.field_78798_e / 16.0F);
      } 
      model.func_78785_a(f5);
      GL11.glPopMatrix();
    } 
  }
}
