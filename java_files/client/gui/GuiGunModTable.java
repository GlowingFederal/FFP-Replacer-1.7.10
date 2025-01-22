package com.flansmod.client.gui;

import com.flansmod.client.ClientProxy;
import com.flansmod.client.model.GunAnimations;
import com.flansmod.common.FlansMod;
import com.flansmod.common.guns.ContainerGunModTable;
import com.flansmod.common.guns.GunType;
import com.flansmod.common.guns.ItemGun;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketGunPaint;
import com.flansmod.common.paintjob.Paintjob;
import java.util.Collections;
import java.util.Random;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.client.IItemRenderer;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;

public class GuiGunModTable extends GuiContainer {
  private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/gunTableNew.png");
  
  private static final Random rand = new Random();
  
  private Paintjob hoveringOver = null;
  
  private String hoveringOverModSlots = null;
  
  private int mouseX;
  
  private int mouseY;
  
  private InventoryPlayer inventory;
  
  private boolean flipGunModel = false;
  
  private int[] lastStats = new int[] { 0, 0, 0, 0 };
  
  public GuiGunModTable(InventoryPlayer inv, World w) {
    super((Container)new ContainerGunModTable(inv, w));
    this.inventory = inv;
    this.field_146999_f = 331;
    this.field_147000_g = 236;
  }
  
  protected void func_146979_b(int x, int y) {
    this.field_146289_q.func_78276_b("Gun Modification Table", 6, 6, 4210752);
    this.field_146289_q.func_78276_b("Inventory", 7, 142, 4210752);
    this.field_146289_q.func_78276_b("Gun Information", 179, 22, 4210752);
    this.field_146289_q.func_78276_b("Paintjobs", 179, 128, 4210752);
    ItemStack gunStack = this.field_147002_h.func_75139_a(0).func_75211_c();
    if (gunStack != null && gunStack.func_77973_b() instanceof ItemGun) {
      GunType gunType = ((ItemGun)gunStack.func_77973_b()).type;
      int reloadt = Math.round(gunType.getReloadTime(gunStack));
      if (gunType.model != null) {
        GL11.glPushMatrix();
        GL11.glColor3f(1.0F, 1.0F, 1.0F);
        GL11.glTranslatef(105.0F, 55.0F, 100.0F);
        GL11.glRotatef(160.0F, 1.0F, 0.0F, 0.0F);
        GL11.glRotatef(20.0F, 0.0F, 1.0F, 0.0F);
        if (this.flipGunModel) {
          GL11.glTranslatef(-30.0F, 0.0F, 0.0F);
          GL11.glRotatef(190.0F, 0.0F, 1.0F, 0.0F);
        } 
        RenderHelper.func_74519_b();
        GL11.glScalef(-60.0F, 60.0F, 60.0F);
        ClientProxy.gunRenderer.renderGun(gunStack, gunType, 0.0625F, gunType.model, GunAnimations.defaults, 0.0F, IItemRenderer.ItemRenderType.ENTITY);
        GL11.glPopMatrix();
      } 
      if (gunStack.func_82833_r() != null)
        this.field_146289_q.func_78276_b(gunStack.func_82833_r(), 207, 36, 4210752); 
      this.field_146289_q.func_78276_b(gunType.description, 207, 46, 4210752);
      this.field_146289_q.func_78276_b("Damage", 181, 61, 4210752);
      this.field_146289_q.func_78276_b("Accuracy", 181, 73, 4210752);
      this.field_146289_q.func_78276_b("Recoil", 181, 85, 4210752);
      this.field_146289_q.func_78276_b("Reload", 181, 97, 4210752);
      this.field_146289_q.func_78276_b(String.valueOf(roundFloat(gunType.getDamage(gunStack), 2)), 241, 62, 4210752);
      this.field_146289_q.func_78276_b(String.valueOf(gunType.getSpread(gunStack, false, false)), 241, 74, 4210752);
      this.field_146289_q.func_78276_b(String.valueOf(roundFloat(gunType.getRecoilPitch(gunStack), 2)), 241, 86, 4210752);
      this.field_146289_q.func_78276_b(String.valueOf(roundFloat((reloadt / 20), 2)) + "s", 241, 98, 4210752);
      if (this.hoveringOverModSlots != null)
        drawHoveringText(Collections.singletonList(this.hoveringOverModSlots), this.mouseX - this.field_147003_i, this.mouseY - this.field_147009_r, this.field_146289_q); 
    } 
  }
  
  protected void func_146976_a(float f, int i, int j) {
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    int xOrigin = (this.field_146294_l - this.field_146999_f) / 2;
    int yOrigin = (this.field_146295_m - this.field_147000_g) / 2;
    this.field_146297_k.field_71446_o.func_110577_a(texture);
    func_73729_b(xOrigin, yOrigin, 0, 0, this.field_146999_f, this.field_147000_g);
    for (int z = 1; z < 17; z++)
      (this.field_147002_h.func_75139_a(z)).field_75221_f = -1000; 
    ItemStack gunStack = this.field_147002_h.func_75139_a(0).func_75211_c();
    if (gunStack == null)
      this.lastStats = new int[] { 0, 0, 0, 0 }; 
    if (gunStack != null && gunStack.func_77973_b() instanceof ItemGun) {
      GunType gunType = ((ItemGun)gunStack.func_77973_b()).type;
      boolean[] allowBools = { gunType.allowBarrelAttachments, gunType.allowScopeAttachments, gunType.allowStockAttachments, gunType.allowGripAttachments, gunType.allowGadgetAttachments, gunType.allowSlideAttachments, gunType.allowPumpAttachments, gunType.allowAccessoryAttachments };
      int reloadt = Math.round(gunType.getReloadTime(gunStack));
      func_73729_b(xOrigin + 146, yOrigin + 63, 340, 166, 20, 10);
      for (int m = 0; m < allowBools.length; m++) {
        if (allowBools[m]) {
          func_73729_b(xOrigin + 16 + m * 18, yOrigin + 88, 340 + m * 18, 136, 18, 18);
          (this.field_147002_h.func_75139_a(m + 1)).field_75221_f = 89;
        } 
      } 
      for (int x = 0; x < 8; x++) {
        if (x < gunType.numGenericAttachmentSlots) {
          func_73729_b(xOrigin + 16 + 18 * x, yOrigin + 114, 340, 100, 18, 18);
          (this.field_147002_h.func_75139_a(allowBools.length + 1 + x)).field_75221_f = 115;
        } 
      } 
      int[] stats = { Math.round(gunType.getDamage(gunStack)) * 4, Math.round(gunType.getSpread(gunStack, false, false)) * 4, Math.round(gunType.getRecoilPitch(gunStack)) * 4, reloadt / 20 * 8 };
      displayGunValues(stats);
      int numPaintjobs = gunType.paintjobs.size();
      int numRows = numPaintjobs / 2 + 1;
      int y;
      for (y = 0; y < numRows; y++) {
        for (int k = 0; k < 2; k++) {
          if (2 * y + k < numPaintjobs)
            func_73729_b(xOrigin + 181 + 18 * k, yOrigin + 150 + 18 * y, 340, 100, 18, 18); 
        } 
      } 
      for (y = 0; y < numRows; y++) {
        for (int k = 0; k < 2; k++) {
          if (2 * y + k < numPaintjobs) {
            Paintjob paintjob = gunType.paintjobs.get(2 * y + k);
            ItemStack stack = gunStack.func_77946_l();
            stack.func_77964_b(paintjob.ID);
            field_146296_j.func_77015_a(this.field_146297_k.field_71466_p, this.field_146297_k.func_110434_K(), stack, xOrigin + 182 + k * 18, yOrigin + 151 + y * 18);
          } 
        } 
      } 
    } 
    if (this.hoveringOver != null) {
      int numDyes = this.hoveringOver.dyesNeeded.length;
      if (numDyes != 0 && !this.inventory.field_70458_d.field_71075_bZ.field_75098_d) {
        boolean[] haveDyes = new boolean[numDyes];
        for (int n = 0; n < numDyes; n++) {
          int amountNeeded = (this.hoveringOver.dyesNeeded[n]).field_77994_a;
          for (int k = 0; k < this.inventory.func_70302_i_(); k++) {
            ItemStack stack = this.inventory.func_70301_a(k);
            if (stack != null && stack.func_77973_b() == Items.field_151100_aR && stack.func_77960_j() == this.hoveringOver.dyesNeeded[n].func_77960_j())
              amountNeeded -= stack.field_77994_a; 
          } 
          if (amountNeeded <= 0)
            haveDyes[n] = true; 
        } 
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        GL11.glDisable(2896);
        this.field_146297_k.field_71446_o.func_110577_a(texture);
        int s;
        for (s = 0; s < numDyes; s++)
          func_73729_b(xOrigin + 223 + 18 * s, yOrigin + 150, haveDyes[s] ? 358 : 340, 118, 18, 18); 
        for (s = 0; s < numDyes; s++) {
          field_146296_j.func_77015_a(this.field_146289_q, this.field_146297_k.func_110434_K(), this.hoveringOver.dyesNeeded[s], xOrigin + 224 + s * 18, yOrigin + 151);
          field_146296_j.func_77021_b(this.field_146289_q, this.field_146297_k.func_110434_K(), this.hoveringOver.dyesNeeded[s], xOrigin + 224 + s * 18, yOrigin + 151);
        } 
      } 
    } 
  }
  
  public void displayGunValues(int[] stats) {
    int xOrigin = (this.field_146294_l - this.field_146999_f) / 2;
    int yOrigin = (this.field_146295_m - this.field_147000_g) / 2;
    for (int y = 0; y < 4; y++)
      func_73729_b(xOrigin + 239, yOrigin + 60 + 12 * y, 340, 80, 80, 10); 
    for (int k = 0; k < 4; k++) {
      int difference = stats[k] - this.lastStats[k];
      int finalWidth = 0;
      if (k == 0) {
        if (stats[k] < 80 && difference != 0 && difference > 0) {
          finalWidth = this.lastStats[k] = this.lastStats[k] + 2;
        } else if (difference != 0 && difference < 0) {
          finalWidth = this.lastStats[k] = this.lastStats[k] - 2;
        } else if (stats[k] < 80) {
          finalWidth = stats[k];
        } else {
          finalWidth = 80;
        } 
        func_73729_b(xOrigin + 239, yOrigin + 60 + 12 * k, 340, 90, finalWidth, 10);
      } else {
        difference = 80 - stats[k] - this.lastStats[k];
        if (80 - stats[k] > 2 && difference != 0 && difference > 0) {
          finalWidth = this.lastStats[k] = this.lastStats[k] + 2;
        } else if (difference != 0 && difference < 0) {
          finalWidth = this.lastStats[k] = this.lastStats[k] - 2;
        } else if (80 - stats[k] > 2) {
          finalWidth = 80 - stats[k];
        } else {
          finalWidth = 2;
        } 
        func_73729_b(xOrigin + 239, yOrigin + 60 + 12 * k, 340, 90, finalWidth, 10);
      } 
    } 
  }
  
  public void func_73729_b(int par1, int par2, int par3, int par4, int par5, int par6) {
    float f = 0.001953125F;
    float f1 = 0.00390625F;
    Tessellator tessellator = Tessellator.field_78398_a;
    tessellator.func_78382_b();
    tessellator.func_78374_a(par1, (par2 + par6), this.field_73735_i, (par3 * f), ((par4 + par6) * f1));
    tessellator.func_78374_a((par1 + par5), (par2 + par6), this.field_73735_i, ((par3 + par5) * f), ((par4 + par6) * f1));
    tessellator.func_78374_a((par1 + par5), par2, this.field_73735_i, ((par3 + par5) * f), (par4 * f1));
    tessellator.func_78374_a(par1, par2, this.field_73735_i, (par3 * f), (par4 * f1));
    tessellator.func_78381_a();
  }
  
  public void func_146274_d() {
    super.func_146274_d();
    this.mouseX = Mouse.getEventX() * this.field_146294_l / this.field_146297_k.field_71443_c;
    this.mouseY = this.field_146295_m - Mouse.getEventY() * this.field_146295_m / this.field_146297_k.field_71440_d - 1;
    int mouseXInGUI = this.mouseX - this.field_147003_i;
    int mouseYInGUI = this.mouseY - this.field_147009_r;
    this.hoveringOver = null;
    ItemStack gunStack = this.field_147002_h.func_75139_a(0).func_75211_c();
    if (gunStack != null && gunStack.func_77973_b() instanceof ItemGun) {
      GunType gunType = ((ItemGun)gunStack.func_77973_b()).type;
      int numPaintjobs = gunType.paintjobs.size();
      int numRows = numPaintjobs / 2 + 1;
      for (int j = 0; j < numRows; j++) {
        for (int i = 0; i < 2; i++) {
          if (2 * j + i < numPaintjobs) {
            Paintjob paintjob = gunType.paintjobs.get(2 * j + i);
            ItemStack stack = gunStack.func_77946_l();
            stack.field_77990_d.func_74778_a("Paint", paintjob.iconName);
            int slotX = 181 + i * 18;
            int slotY = 150 + j * 18;
            if (mouseXInGUI >= slotX && mouseXInGUI < slotX + 18 && mouseYInGUI >= slotY && mouseYInGUI < slotY + 18)
              this.hoveringOver = paintjob; 
          } 
        } 
      } 
      this.hoveringOverModSlots = null;
      String[] text = { "Barrel", "Scope", "Stock", "Grip", "Gadget", "Slide", "Pump", "Accessory" };
      boolean[] allowBools = { gunType.allowBarrelAttachments, gunType.allowScopeAttachments, gunType.allowStockAttachments, gunType.allowGripAttachments, gunType.allowGadgetAttachments, gunType.allowSlideAttachments, gunType.allowPumpAttachments, gunType.allowAccessoryAttachments };
      for (int a = 0; a < allowBools.length; a++) {
        int slotX = 16 + a * 18;
        int slotY = 88;
        if (mouseXInGUI >= slotX && mouseXInGUI < slotX + 18 && mouseYInGUI >= slotY && mouseYInGUI < slotY + 18 && 
          !this.field_147002_h.func_75139_a(a + 1).func_75216_d() && allowBools[a])
          this.hoveringOverModSlots = text[a]; 
      } 
    } 
  }
  
  protected void func_73864_a(int x, int y, int button) {
    int xOrigin = (this.field_146294_l - this.field_146999_f) / 2;
    int yOrigin = (this.field_146295_m - this.field_147000_g) / 2;
    super.func_73864_a(x, y, button);
    int m = x - xOrigin;
    int n = y - yOrigin;
    if (button == 0 || button == 1)
      if (m >= 146 && m <= 165 && n >= 63 && n <= 72)
        if (!this.flipGunModel) {
          this.flipGunModel = true;
        } else {
          this.flipGunModel = false;
        }   
    if (button != 0)
      return; 
    if (this.hoveringOver == null)
      return; 
    FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketGunPaint(this.hoveringOver.ID));
    ((ContainerGunModTable)this.field_147002_h).clickPaintjob(this.hoveringOver);
  }
  
  public static float roundFloat(float value, int points) {
    int pow = 10;
    for (int i = 1; i < points; i++)
      pow *= 10; 
    float result = value * pow;
    return (int)((result - (int)result >= 0.5F) ? (result + 1.0F) : result) / pow;
  }
}
