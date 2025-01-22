package com.flansmod.client;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EntityFlash extends EntityFX {
  public static ResourceLocation icon = new ResourceLocation("flansmod", "particle/Boom1.png");
  
  public EntityFlash(World w, double px, double py, double pz, double mx, double my, double mz) {
    super(w, px, py, pz, mx, my, mz);
    this.field_70547_e = 6;
    this.field_70545_g = 1.0F;
    this.field_70159_w = mx;
    this.field_70181_x = my;
    this.field_70179_y = mz;
    icon = new ResourceLocation("flansmod", "particle/Boom1.png");
  }
  
  public int func_70537_b() {
    return 3;
  }
  
  public float getEntityBrightness(float f) {
    return 1.0F;
  }
  
  public int func_70070_b(float par1) {
    return 15728880;
  }
  
  public void func_70539_a(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
    GL11.glPushMatrix();
    par1Tessellator.func_78382_b();
    GL11.glAlphaFunc(516, 0.001F);
    GL11.glEnable(3042);
    int srcBlend = GL11.glGetInteger(3041);
    int dstBlend = GL11.glGetInteger(3040);
    GL11.glBlendFunc(1, 771);
    GL11.glDepthMask(false);
    (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(icon);
    float scale = 1.0F;
    float xPos = (float)(this.field_70169_q + (this.field_70165_t - this.field_70169_q) * par2 - field_70556_an);
    float yPos = (float)(this.field_70167_r + (this.field_70163_u - this.field_70167_r) * par2 - field_70554_ao);
    float zPos = (float)(this.field_70166_s + (this.field_70161_v - this.field_70166_s) * par2 - field_70555_ap);
    float colorIntensity = 1.0F;
    par1Tessellator.func_78386_a(this.field_70552_h * colorIntensity, this.field_70553_i * colorIntensity, this.field_70551_j * colorIntensity);
    par1Tessellator.func_78374_a((xPos - par3 * scale - par6 * scale), (yPos - par4 * scale), (zPos - par5 * scale - par7 * scale), 0.0D, 1.0D);
    par1Tessellator.func_78374_a((xPos - par3 * scale + par6 * scale), (yPos + par4 * scale), (zPos - par5 * scale + par7 * scale), 1.0D, 1.0D);
    par1Tessellator.func_78374_a((xPos + par3 * scale + par6 * scale), (yPos + par4 * scale), (zPos + par5 * scale + par7 * scale), 1.0D, 0.0D);
    par1Tessellator.func_78374_a((xPos + par3 * scale - par6 * scale), (yPos - par4 * scale), (zPos + par5 * scale - par7 * scale), 0.0D, 0.0D);
    par1Tessellator.func_78381_a();
    GL11.glBlendFunc(srcBlend, dstBlend);
    GL11.glDisable(3042);
    GL11.glDepthMask(true);
    GL11.glPopMatrix();
  }
  
  public void func_70071_h_() {
    this.field_70169_q = this.field_70165_t;
    this.field_70167_r = this.field_70163_u;
    this.field_70166_s = this.field_70161_v;
    if (this.field_70546_d++ >= this.field_70547_e)
      func_70106_y(); 
    if (this.field_70122_E)
      func_70106_y(); 
    if (this.field_70546_d == 1)
      icon = new ResourceLocation("flansmod", "particle/Boom2.png"); 
    if (this.field_70546_d == 2)
      icon = new ResourceLocation("flansmod", "particle/Boom3.png"); 
    if (this.field_70546_d == 3)
      icon = new ResourceLocation("flansmod", "particle/Boom4.png"); 
    if (this.field_70546_d == 4)
      icon = new ResourceLocation("flansmod", "particle/Boom5.png"); 
    if (this.field_70546_d == 5)
      icon = new ResourceLocation("flansmod", "particle/Boom6.png"); 
    (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(icon);
  }
}
