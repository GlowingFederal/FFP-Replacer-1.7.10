package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.driveables.DriveableType;
import com.flansmod.common.driveables.EntityDriveable;
import java.util.HashMap;
import net.minecraft.client.model.ModelBase;

public class ModelDriveable extends ModelBase {
  public static final float pi = 3.1415927F;
  
  public static final float tau = 6.2831855F;
  
  public HashMap<String, ModelRendererTurbo[][]> gunModels = (HashMap)new HashMap<>();
  
  public ModelRendererTurbo[] bodyModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] bodyDoorOpenModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] bodyDoorCloseModel = new ModelRendererTurbo[0];
  
  public boolean oldRotateOrder = false;
  
  public void render(EntityDriveable driveable, float f1) {}
  
  public void render(DriveableType type) {
    renderPart(this.bodyModel);
    renderPart(this.bodyDoorCloseModel);
    for (ModelRendererTurbo[][] gun : this.gunModels.values()) {
      for (ModelRendererTurbo[] gunPart : gun)
        renderPart(gunPart); 
    } 
  }
  
  public void renderPart(ModelRendererTurbo[] part) {
    for (ModelRendererTurbo bit : part)
      bit.render(0.0625F, this.oldRotateOrder); 
  }
  
  public void registerGunModel(String name, ModelRendererTurbo[][] gunModel) {
    this.gunModels.put(name, gunModel);
  }
  
  protected void flip(ModelRendererTurbo[] model) {
    for (ModelRendererTurbo part : model) {
      part.doMirror(false, true, true);
      part.func_78793_a(part.field_78800_c, -part.field_78797_d, -part.field_78798_e);
    } 
  }
  
  public void flipAll() {
    flip(this.bodyModel);
    flip(this.bodyDoorOpenModel);
    flip(this.bodyDoorCloseModel);
    for (ModelRendererTurbo[][] modsOfMods : this.gunModels.values()) {
      for (ModelRendererTurbo[] mods : modsOfMods)
        flip(mods); 
    } 
  }
  
  protected void translate(ModelRendererTurbo[] model, float x, float y, float z) {
    for (ModelRendererTurbo mod : model) {
      mod.field_78800_c += x;
      mod.field_78797_d += y;
      mod.field_78798_e += z;
    } 
  }
  
  public void translateAll(float x, float y, float z) {
    translate(this.bodyModel, x, y, z);
    translate(this.bodyDoorOpenModel, x, y, z);
    translate(this.bodyDoorCloseModel, x, y, z);
    for (ModelRendererTurbo[][] modsOfMods : this.gunModels.values()) {
      for (ModelRendererTurbo[] mods : modsOfMods)
        translate(mods, x, y, z); 
    } 
  }
  
  public void translateAll(int x, int y, int z) {
    translateAll(x, y, z);
  }
}
