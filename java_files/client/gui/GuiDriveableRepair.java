package com.flansmod.client.gui;

import com.flansmod.common.FlansMod;
import com.flansmod.common.driveables.DriveablePart;
import com.flansmod.common.driveables.EntityDriveable;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.driveables.EnumDriveablePart;
import com.flansmod.common.network.PacketBase;
import com.flansmod.common.network.PacketDriveableGUI;
import java.util.ArrayList;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class GuiDriveableRepair extends GuiScreen {
  private static final ResourceLocation texture = new ResourceLocation("flansmod", "gui/repair.png");
  
  private EntityPlayer driver;
  
  private EntityDriveable driving;
  
  private ArrayList<DriveablePart> partsToDraw = new ArrayList<>();
  
  private static RenderItem itemRenderer = new RenderItem();
  
  private int guiOriginX;
  
  private int guiOriginY;
  
  public GuiDriveableRepair(EntityPlayer player) {
    this.driver = player;
    this.driving = ((EntitySeat)player.field_70154_o).driveable;
    for (DriveablePart part : (this.driving.getDriveableData()).parts.values()) {
      if (part.maxHealth > 0)
        this.partsToDraw.add(part); 
    } 
  }
  
  public void func_73866_w_() {
    super.func_73866_w_();
    for (int i = 0; i < this.partsToDraw.size(); i++)
      this.field_146292_n.add(new GuiButton(i, 0, 0, 55, 20, "Repair")); 
  }
  
  protected void func_146284_a(GuiButton button) {
    FlansMod.proxy.repairDriveable(this.driver, this.driving, this.partsToDraw.get(button.field_146127_k));
  }
  
  private void updateButtons() {
    int y = 43;
    for (int i = 0; i < this.partsToDraw.size(); i++) {
      DriveablePart part = this.partsToDraw.get(i);
      GuiButton button = this.field_146292_n.get(i);
      button.field_146128_h = this.guiOriginX + 9;
      button.field_146129_i = (part.health <= 0) ? (this.guiOriginY + y) : -1000;
      y += (part.health <= 0) ? 40 : 20;
    } 
  }
  
  public void func_73863_a(int i, int j, float f) {
    int guiWidth = 202;
    int guiHeight = 31;
    for (DriveablePart part : this.partsToDraw)
      guiHeight += (part.health <= 0) ? 40 : 20; 
    updateButtons();
    ScaledResolution scaledresolution = new ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
    int w = scaledresolution.func_78326_a();
    int h = scaledresolution.func_78328_b();
    func_146276_q_();
    GL11.glEnable(3042);
    this.field_146297_k.field_71446_o.func_110577_a(texture);
    GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
    this.guiOriginX = w / 2 - guiWidth / 2;
    this.guiOriginY = h / 2 - guiHeight / 2;
    func_73729_b(this.guiOriginX, this.guiOriginY, 0, 0, 202, 23);
    func_73729_b(this.guiOriginX, this.guiOriginY + guiHeight - 8, 0, 65, 202, 8);
    func_73731_b(this.field_146289_q, (this.driving.getDriveableType()).name + " - Repair", this.guiOriginX + 7, this.guiOriginY + 7, 16777215);
    int y = 23;
    for (DriveablePart part : this.partsToDraw) {
      boolean broken = (part.health <= 0);
      this.field_146297_k.field_71446_o.func_110577_a(texture);
      func_73729_b(this.guiOriginX, this.guiOriginY + y, 0, 24, 202, broken ? 40 : 20);
      float percentHealth = part.health / part.maxHealth;
      GL11.glColor3f(1.0F - percentHealth, percentHealth, 0.0F);
      func_73729_b(this.guiOriginX + 121, this.guiOriginY + y + 2, 0, 73, (int)(70.0F * percentHealth), 16);
      if (part.armor > 1) {
        func_73731_b(this.field_146289_q, part.type.getName() + ": " + part.armor + "mm", this.guiOriginX + 10, this.guiOriginY + y + 6, 16777215);
      } else if (part.armor == 1) {
        func_73731_b(this.field_146289_q, part.type.getName(), this.guiOriginX + 10, this.guiOriginY + y + 6, 16777215);
      } 
      func_73732_a(this.field_146289_q, (int)(percentHealth * 100.0F) + "%", this.guiOriginX + 158, this.guiOriginY + y + 6, 16777215);
      if (broken && part.type != EnumDriveablePart.frontalArmor) {
        InventoryPlayer temporaryInventory = new InventoryPlayer(null);
        temporaryInventory.func_70455_b(this.driver.field_71071_by);
        ArrayList<ItemStack> stacksNeeded = this.driving.getDriveableType().getItemsRequired(part, (this.driving.getDriveableData()).engine);
        for (int n = 0; n < 7; n++) {
          int stackNum = n + FlansMod.ticker / 60 % Math.max(1, stacksNeeded.size() - 6);
          if (stackNum < stacksNeeded.size()) {
            ItemStack stackNeeded = stacksNeeded.get(stackNum);
            int totalAmountFound = 0;
            for (int m = 0; m < temporaryInventory.func_70302_i_(); m++) {
              ItemStack stackInSlot = temporaryInventory.func_70301_a(m);
              if (stackInSlot != null && stackInSlot.func_77973_b() == stackNeeded.func_77973_b() && stackInSlot.func_77960_j() == stackNeeded.func_77960_j()) {
                int amountFound = Math.min(stackInSlot.field_77994_a, stackNeeded.field_77994_a - totalAmountFound);
                stackInSlot.field_77994_a -= amountFound;
                if (stackInSlot.field_77994_a <= 0)
                  stackInSlot = null; 
                temporaryInventory.func_70299_a(m, stackInSlot);
                totalAmountFound += amountFound;
                if (totalAmountFound == stackNeeded.field_77994_a)
                  break; 
              } 
            } 
            if (totalAmountFound < stackNeeded.field_77994_a) {
              this.field_146297_k.field_71446_o.func_110577_a(texture);
              func_73729_b(this.guiOriginX + 67 + 18 * n, this.guiOriginY + y + 22, 202, 0, 16, 16);
            } 
            drawSlotInventory(stacksNeeded.get(stackNum), this.guiOriginX + 67 + 18 * n, this.guiOriginY + y + 22);
          } 
        } 
      } 
      y += broken ? 40 : 20;
    } 
    super.func_73863_a(i, j, f);
  }
  
  protected void func_73864_a(int i, int j, int k) {
    super.func_73864_a(i, j, k);
    int m = i - this.guiOriginX;
    int n = j - this.guiOriginY;
    if (m > 185 && m < 195 && n > 5 && n < 15)
      if (this.driving instanceof com.flansmod.common.driveables.mechas.EntityMecha) {
        FlansMod.getPacketHandler().sendToServer((PacketBase)new PacketDriveableGUI(4));
        this.driver.openGui(FlansMod.INSTANCE, 10, this.driver.field_70170_p, this.driving.field_70176_ah, this.driving.field_70162_ai, this.driving.field_70164_aj);
      } else {
        this.field_146297_k.func_147108_a((GuiScreen)new GuiDriveableMenu(this.driver.field_71071_by, this.driver.field_70170_p, this.driving));
      }  
  }
  
  private void drawSlotInventory(ItemStack itemstack, int i, int j) {
    if (itemstack == null || itemstack.func_77973_b() == null)
      return; 
    itemRenderer.func_77015_a(this.field_146289_q, this.field_146297_k.field_71446_o, itemstack, i, j);
    itemRenderer.func_77021_b(this.field_146289_q, this.field_146297_k.field_71446_o, itemstack, i, j);
    GL11.glDisable(2896);
    GL11.glDisable(2929);
  }
  
  public boolean func_73868_f() {
    return false;
  }
}
