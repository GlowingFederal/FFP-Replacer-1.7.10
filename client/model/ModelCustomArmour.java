package com.flansmod.client.model;

import com.flansmod.client.tmt.ModelRendererTurbo;
import com.flansmod.common.teams.ArmourType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;
import org.lwjgl.opengl.GL11;

public class ModelCustomArmour extends ModelBiped {
  public ArmourType type;
  
  public ModelRendererTurbo[] headModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] bodyModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftArmModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightArmModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] leftLegModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] rightLegModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] skirtFrontModel = new ModelRendererTurbo[0];
  
  public ModelRendererTurbo[] skirtRearModel = new ModelRendererTurbo[0];
  
  public void func_78088_a(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
    GL11.glPushMatrix();
    GL11.glScalef(this.type.modelScale, this.type.modelScale, this.type.modelScale);
    this.field_78117_n = entity.func_70093_af();
    ItemStack itemstack = ((EntityLivingBase)entity).func_71124_b(0);
    this.field_78120_m = (itemstack != null) ? 1 : 0;
    if (entity.func_82150_aj() && !this.type.playermodel)
      GL11.glScalef(1.0E-4F, 1.0E-4F, 1.0E-4F); 
    if ((Minecraft.func_71410_x()).field_71460_t.func_147702_a())
      GL11.glColor4f(5.0F, 5.0F, 5.0F, 100.0F); 
    this.field_78118_o = false;
    if (itemstack != null && entity instanceof EntityPlayer && ((EntityPlayer)entity).func_71052_bv() > 0) {
      EnumAction enumaction = itemstack.func_77975_n();
      if (enumaction == EnumAction.block) {
        this.field_78120_m = 3;
      } else if (enumaction == EnumAction.bow) {
        this.field_78118_o = true;
      } 
    } 
    func_78087_a(f, f1, f2, f3, f4, f5, entity);
    render(this.headModel, this.field_78116_c, f5, this.type.modelScale);
    render(this.bodyModel, this.field_78115_e, f5, this.type.modelScale);
    render(this.leftArmModel, this.field_78113_g, f5, this.type.modelScale);
    render(this.rightArmModel, this.field_78112_f, f5, this.type.modelScale);
    render(this.leftLegModel, this.field_78124_i, f5, this.type.modelScale);
    render(this.rightLegModel, this.field_78123_h, f5, this.type.modelScale);
    for (ModelRendererTurbo mod : this.skirtFrontModel) {
      mod.field_78800_c = (this.field_78124_i.field_78800_c + this.field_78123_h.field_78800_c) / 2.0F / this.type.modelScale;
      mod.field_78797_d = (this.field_78124_i.field_78797_d + this.field_78123_h.field_78797_d) / 2.0F / this.type.modelScale;
      mod.field_78798_e = (this.field_78124_i.field_78798_e + this.field_78123_h.field_78798_e) / 2.0F / this.type.modelScale;
      mod.field_78795_f = Math.min(this.field_78124_i.field_78795_f, this.field_78123_h.field_78795_f);
      mod.field_78796_g = this.field_78124_i.field_78796_g;
      mod.field_78808_h = this.field_78124_i.field_78808_h;
      mod.func_78785_a(f5);
    } 
    for (ModelRendererTurbo mod : this.skirtRearModel) {
      mod.field_78800_c = (this.field_78124_i.field_78800_c + this.field_78123_h.field_78800_c) / 2.0F / this.type.modelScale;
      mod.field_78797_d = (this.field_78124_i.field_78797_d + this.field_78123_h.field_78797_d) / 2.0F / this.type.modelScale;
      mod.field_78798_e = (this.field_78124_i.field_78798_e + this.field_78123_h.field_78798_e) / 2.0F / this.type.modelScale;
      mod.field_78795_f = Math.max(this.field_78124_i.field_78795_f, this.field_78123_h.field_78795_f);
      mod.field_78796_g = this.field_78124_i.field_78796_g;
      mod.field_78808_h = this.field_78124_i.field_78808_h;
      mod.func_78785_a(f5);
    } 
    GL11.glPopMatrix();
  }
  
  public void render(ModelRendererTurbo[] models, ModelRenderer bodyPart, float f5, float scale) {
    setBodyPart(models, bodyPart, scale);
    for (ModelRendererTurbo mod : models) {
      mod.field_78795_f = bodyPart.field_78795_f;
      mod.field_78796_g = bodyPart.field_78796_g;
      mod.field_78808_h = bodyPart.field_78808_h;
      mod.func_78785_a(f5);
    } 
  }
  
  public void setBodyPart(ModelRendererTurbo[] models, ModelRenderer bodyPart, float scale) {
    for (ModelRendererTurbo mod : models) {
      mod.field_78800_c = bodyPart.field_78800_c / scale;
      mod.field_78797_d = bodyPart.field_78797_d / scale;
      mod.field_78798_e = bodyPart.field_78798_e / scale;
    } 
  }
}
