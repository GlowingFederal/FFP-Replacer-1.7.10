package com.flansmod.client;

import cpw.mods.fml.client.FMLClientHandler;
import net.minecraft.client.particle.EntityFX;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import org.lwjgl.opengl.GL11;

public class EntityShipSmoke extends EntityFX {
  public int disTime;
  
  public static ResourceLocation icon = new ResourceLocation("flansmod", "particle/FMSmoke.png");
  
  public EntityShipSmoke(World w, double px, double py, double pz, double mx, double my, double mz) {
    super(w, px, py, pz, mx, my, mz);
    this.field_70547_e = 150;
    this.field_70545_g = 1.0F;
    this.field_70159_w = mx * 5.0D;
    this.field_70181_x = my * 1.0E-5D;
    this.field_70179_y = mz * 5.0D;
    this.field_70544_f = 0.0F;
    this.disTime = 10;
    icon = new ResourceLocation("flansmod", "particle/FMSmoke.png");
  }
  
  public int func_70537_b() {
    return 3;
  }
  
  public float getEntityBrightness(float f) {
    return 1.0F;
  }
  
  public void func_70539_a(Tessellator par1Tessellator, float par2, float par3, float par4, float par5, float par6, float par7) {
    GL11.glPushMatrix();
    par1Tessellator.func_78382_b();
    GL11.glAlphaFunc(516, 0.001F);
    GL11.glEnable(3042);
    int srcBlend = GL11.glGetInteger(3041);
    int dstBlend = GL11.glGetInteger(3040);
    GL11.glDepthMask(false);
    (FMLClientHandler.instance().getClient()).field_71446_o.func_110577_a(new ResourceLocation("flansmod", "particle/FMSmokeElite.png"));
    float scale = 1.0F + this.field_70546_d * 0.1F;
    float xPos = (float)(this.field_70169_q + 0.1D * (this.field_70165_t - this.field_70169_q) * par2 - field_70556_an);
    float yPos = (float)(this.field_70167_r + (this.field_70546_d * 0.3F / (1.0F + 0.01F * this.field_70546_d)) + 0.1D * (this.field_70163_u - this.field_70167_r) * par2 - field_70554_ao);
    float zPos = (float)(this.field_70166_s - (this.field_70546_d * 0.01F) * (Math.random() - 0.5D) + (this.field_70161_v - this.field_70166_s) * par2 - field_70555_ap);
    float colorIntensity = 0.1F;
    par1Tessellator.func_78369_a(this.field_70552_h * colorIntensity, this.field_70553_i * colorIntensity, this.field_70551_j * colorIntensity, 1.0F - (this.field_70546_d * this.field_70546_d * this.field_70546_d) * 1.0E-6F);
    par1Tessellator.func_78374_a((xPos - par3 * scale - par6 * scale), (yPos - par4 * scale), (zPos - par5 * scale - par7 * scale), 0.0D, 1.0D);
    par1Tessellator.func_78374_a((xPos - par3 * scale + par6 * scale), (yPos + par4 * scale), (zPos - par5 * scale + par7 * scale), 1.0D, 1.0D);
    par1Tessellator.func_78374_a((xPos + par3 * scale + par6 * scale), (yPos + par4 * scale), (zPos + par5 * scale + par7 * scale), 1.0D, 0.0D);
    par1Tessellator.func_78374_a((xPos + par3 * scale - par6 * scale), (yPos - par4 * scale), (zPos + par5 * scale - par7 * scale), 0.0D, 0.0D);
    par1Tessellator.func_78381_a();
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
    this.field_70181_x += 1.0E-9D;
    func_70091_d(this.field_70159_w, this.field_70181_x, this.field_70179_y);
    if (func_70090_H()) {
      this.field_70181_x *= 9.0E-9D;
      this.field_70181_x += 1.0E-8D;
    } 
  }
}
