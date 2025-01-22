package com.flansmod.client;

import com.flansmod.common.driveables.EntityPlane;
import com.flansmod.common.driveables.EntitySeat;
import com.flansmod.common.vector.Vector3f;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.MathHelper;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import org.lwjgl.opengl.GL11;

public class PlaneHUD extends Gui {
  static double roll;
  
  static double pitch;
  
  static double yaw;
  
  static double w;
  
  static double h;
  
  static double y;
  
  static int kirmizi;
  
  static int yesil;
  
  static int mavi;
  
  static int renk;
  
  @SubscribeEvent
  public void asd(RenderGameOverlayEvent.Post event) {
    if (event.isCancelable())
      event.setCanceled(true); 
    if (event.type == RenderGameOverlayEvent.ElementType.HELMET && (Minecraft.func_71410_x()).field_71474_y.field_74320_O == 0) {
      EntityClientPlayerMP entityClientPlayerMP = (Minecraft.func_71410_x()).field_71439_g;
      if (((EntityPlayer)entityClientPlayerMP).field_70154_o != null && ((EntityPlayer)entityClientPlayerMP).field_70154_o instanceof EntitySeat) {
        EntitySeat seat = (EntitySeat)((EntityPlayer)entityClientPlayerMP).field_70154_o;
        if (seat.driveable instanceof EntityPlane) {
          EntityPlane plane = (EntityPlane)seat.driveable;
          double croll = plane.axes.getRoll();
          double proll = plane.prevAxes.getRoll();
          double cpitch = plane.axes.getPitch();
          double ppitch = plane.prevAxes.getPitch();
          double cyaw = plane.axes.getYaw();
          double pyaw = plane.prevAxes.getYaw();
          roll = proll + (croll - proll) * event.partialTicks;
          pitch = -(ppitch + (cpitch - ppitch) * event.partialTicks);
          yaw = -(pyaw + (cyaw - pyaw) * event.partialTicks);
          w = event.resolution.func_78327_c();
          h = event.resolution.func_78324_d();
          y = plane.field_70163_u;
          float dx = (float)(plane.field_70165_t - plane.field_70142_S);
          float dy = (float)(plane.field_70163_u - plane.field_70137_T);
          float dz = (float)(plane.field_70161_v - plane.field_70136_U);
          Vector3f forwards = (Vector3f)plane.axes.getXAxis().normalise();
          float speed = forwards.x * (float)plane.field_70159_w * forwards.x * (float)plane.field_70159_w + forwards.y * (float)plane.field_70181_x * forwards.y * (float)plane.field_70181_x + forwards.z * (float)plane.field_70179_y * forwards.z * (float)plane.field_70179_y;
          float advancedSpeed = (float)Math.sqrt(speed);
          float cringedUniversalBuff = 1.0F;
          float Mach = (float)(plane.control.V * 2.23694D);
          float hiz = Mach;
          double cizgiicinyatay = MathHelper.func_76128_c(yaw);
          double cizgiicindikey = MathHelper.func_76128_c(pitch);
          FontRenderer fr = (Minecraft.func_71410_x()).field_71466_p;
          double oran = h / 353.0D;
          GL11.glPushMatrix();
          GL11.glEnable(3042);
          GL11.glColor4d(1.0D, 1.0D, 1.0D, 1.0D);
          Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("flansmod:gui/renk.png"));
          GL11.glTranslated(w / 2.0D, h / 2.0D, 0.0D);
          GL11.glScaled(oran * 0.8D, oran * 0.8D, 1.0D);
          double playerpitch = (((EntityPlayer)entityClientPlayerMP).field_70127_C + (((EntityPlayer)entityClientPlayerMP).field_70125_A - ((EntityPlayer)entityClientPlayerMP).field_70127_C) * event.partialTicks);
          double playeryaw = (((EntityPlayer)entityClientPlayerMP).field_70126_B + (((EntityPlayer)entityClientPlayerMP).field_70177_z - ((EntityPlayer)entityClientPlayerMP).field_70126_B) * event.partialTicks);
          playerpitch = -playerpitch;
          playeryaw = -playeryaw + 90.0D;
          double planepitch = pitch;
          double planeyaw = yaw + 180.0D;
          double yawdifference = planeyaw - playeryaw;
          double angleclosesttozero = yawdifference;
          if (Math.abs(planeyaw + 360.0D - playeryaw) < angleclosesttozero)
            angleclosesttozero = planeyaw + 360.0D - playeryaw; 
          if (Math.abs(planeyaw - 360.0D - playeryaw) < angleclosesttozero)
            angleclosesttozero = planeyaw - 360.0D - playeryaw; 
          if (Math.abs(planeyaw - playeryaw + 360.0D) < angleclosesttozero)
            angleclosesttozero = planeyaw - playeryaw + 360.0D; 
          if (Math.abs(planeyaw - playeryaw - 360.0D) < angleclosesttozero)
            angleclosesttozero = planeyaw - playeryaw - 360.0D; 
          yawdifference = angleclosesttozero;
          double actualplayerpitch = (90.0D - playerpitch) * 2.0D * (1.0D - Math.cos(Math.toRadians(yawdifference)) / 2.0D + 0.5D + 1.0D - Math.cos(Math.toRadians(roll)) / 2.0D + 0.5D) + playerpitch;
          double actualplanepitch = (90.0D - planepitch) * 2.0D * (1.0D - Math.cos(Math.toRadians(roll)) / 2.0D + 0.5D) + planepitch;
          double pitchdifference = actualplanepitch - actualplayerpitch;
          double pitchfactor = Math.cos(Math.toRadians(roll)) * pitchdifference;
          double yawfactor = Math.sin(Math.toRadians(roll)) * yawdifference;
          double sum = pitchfactor + yawfactor;
          GL11.glTranslated(0.0D, -sum * 3.0D + 120.0D, 0.0D);
          double aralik = 20.0D;
          double yaricap = 60.0D;
          GL11.glPopMatrix();
          if (seat.seatInfo.hasHUD) {
            kirmizi = seat.seatInfo.hudColorR;
            yesil = seat.seatInfo.hudColorG;
            mavi = seat.seatInfo.hudColorB;
            renk = (kirmizi << 16) + (yesil << 8) + mavi;
            GL11.glPushMatrix();
            GL11.glEnable(3042);
            GL11.glColor4d(kirmizi / 255.0D * 1.0D, yesil / 255.0D * 1.0D, mavi / 255.0D * 1.0D, 0.8D);
            Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("flansmod:gui/renk.png"));
            GL11.glTranslated(w / 2.0D, h / 2.0D, 0.0D);
            GL11.glScaled(oran * 0.8D, oran * 0.8D, 1.0D);
            nisangah(0);
            yukseklik(0);
            GL11.glColor4d(kirmizi / 255.0D * 0.85D, yesil / 255.0D * 0.85D, mavi / 255.0D * 0.85D, 0.8D);
            Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("flansmod:gui/renk.png"));
            for (; yaw < 0.0D; yaw += 360.0D);
            for (; yaw > 0.0D; yaw -= 360.0D);
            GL11.glPushMatrix();
            GL11.glColor4d(kirmizi / 255.0D * 0.85D, yesil / 255.0D * 0.85D, mavi / 255.0D * 0.85D, 0.8D);
            Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("flansmod:gui/renk.png"));
            GL11.glTranslated(0.0D, -135.0D, 0.0D);
            GL11.glRotated(60.0D, 0.0D, 0.0D, 1.0D);
            dortgen(15.0D, 2.0D, -1, 0);
            GL11.glRotated(60.0D, 0.0D, 0.0D, 1.0D);
            dortgen(15.0D, 2.0D, -1, 0);
            GL11.glPopMatrix();
            double d1;
            for (d1 = -15.0D; d1 <= 20.0D; d1 += 5.0D) {
              GL11.glPushMatrix();
              GL11.glTranslated(0.0D, -133.0D, 0.0D);
              double fark = d1 + yaw % 5.0D;
              GL11.glTranslated(fark * 6.0D, 0.0D, 0.0D);
              GL11.glColor4d(kirmizi / 255.0D * 0.85D, yesil / 255.0D * 0.85D, mavi / 255.0D * 0.85D, 0.8D);
              Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("flansmod:gui/renk.png"));
              int pi = MathHelper.func_76128_c(yaw - yaw % 5.0D - d1);
              dortgen(1.0D, 10.0D, 0, 1);
              int yatay = MathHelper.func_76128_c(yaw - yaw % 5.0D - d1);
              for (; yatay < 360; yatay += 360);
              for (; yatay > 360; yatay -= 360);
              String s = yatay + "";
              boolean yon = false;
              if (s.equals("0") || s.equals("360")) {
                s = "E";
                yon = true;
              } 
              if (s.equals("-90") || s.equals("270")) {
                s = "S";
                yon = true;
              } 
              if (s.equals("-180") || s.equals("180")) {
                s = "W";
                yon = true;
              } 
              if (s.equals("90") || s.equals("-270")) {
                s = "N";
                yon = true;
              } 
              if (yon) {
                GL11.glTranslated(0.0D, -12.0D, 0.0D);
                GL11.glScaled(2.0D, 2.0D, 0.0D);
              } 
              GL11.glTranslated(-fr.func_78256_a(s) / 2.0D, 12.0D, 0.0D);
              fr.func_78276_b(s, 0, 0, renk);
              GL11.glPopMatrix();
            } 
            GL11.glColor4d(kirmizi / 255.0D * 0.85D, yesil / 255.0D * 0.85D, mavi / 255.0D * 0.85D, 0.8D);
            Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("flansmod:gui/renk.png"));
            GL11.glPushMatrix();
            GL11.glRotated(-roll, 0.0D, 0.0D, 1.0D);
            GL11.glPushMatrix();
            GL11.glTranslated(0.0D, -15.0D, 0.0D);
            dortgen(1.0D, 20.0D, 0, -1);
            GL11.glPopMatrix();
            GL11.glTranslated(-15.0D, 0.0D, 0.0D);
            dortgen(20.0D, 1.0D, -1, 0);
            GL11.glTranslated(30.0D, 0.0D, 0.0D);
            dortgen(20.0D, 1.0D, 1, 0);
            GL11.glPopMatrix();
            for (int j = -90; j < 120; j += 30) {
              GL11.glPushMatrix();
              GL11.glRotated(j, 0.0D, 0.0D, 1.0D);
              GL11.glTranslated(0.0D, 40.0D, 0.0D);
              dortgen(1.0D, 10.0D, 0, 1);
              GL11.glPopMatrix();
            } 
            GL11.glPushMatrix();
            GL11.glTranslated(65.0D, 0.0D, 0.0D);
            GL11.glTranslated(30.0D, 0.0D, 0.0D);
            dortgen(42.5D, 1.0D, 1, 0);
            GL11.glTranslated(42.5D, -1.0D, 0.0D);
            dortgen(1.0D, 12.0D, 1, 0);
            GL11.glPushMatrix();
            GL11.glTranslated((1 + fr.func_78256_a(String.format("%.2f", new Object[] { Double.valueOf(y) })) + 2), 0.0D, 0.0D);
            dortgen(1.0D, 12.0D, 1, 0);
            GL11.glPopMatrix();
            GL11.glTranslated(0.0D, -6.5D, 0.0D);
            dortgen((2 + fr.func_78256_a(String.format("%.2f", new Object[] { Double.valueOf(y) })) + 2), 1.0D, 1, 0);
            GL11.glTranslated(0.0D, 12.5D, 0.0D);
            dortgen((2 + fr.func_78256_a(String.format("%.2f", new Object[] { Double.valueOf(y) })) + 2), 1.0D, 1, 0);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(fr.func_78256_a(String.format("%.2f", new Object[] { Double.valueOf(y) })) / 2.0D, 0.0D, 0.0D);
            yazi(String.format("%.2f", new Object[] { Double.valueOf(y) }), renk, 140.0D, 0.0D, 1.0D);
            GL11.glPopMatrix();
            double i;
            for (i = -80.0D; i <= 80.0D; i += 10.0D) {
              GL11.glPushMatrix();
              GL11.glTranslated(30.0D, 0.0D, 0.0D);
              GL11.glTranslated(70.0D, 0.0D, 0.0D);
              double fark = i + y % 10.0D;
              if (-50.0D < fark && fark < 50.0D) {
                GL11.glTranslated(0.0D, fark * 2.0D, 0.0D);
                GL11.glColor4d(kirmizi / 255.0D * 0.85D, yesil / 255.0D * 0.85D, mavi / 255.0D * 0.85D, 0.8D);
                Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("flansmod:gui/renk.png"));
                dortgen(10.0D, 1.0D, 0, 0);
                String s = MathHelper.func_76128_c(y - y % 10.0D - i) + "";
                GL11.glTranslated((fr.func_78256_a(s) + 2), 0.0D, 0.0D);
                yazi(s, renk, 0.0D, 0.0D, 1.0D);
              } 
              GL11.glPopMatrix();
            } 
            GL11.glColor4d(kirmizi / 255.0D * 0.85D, yesil / 255.0D * 0.85D, mavi / 255.0D * 0.85D, 0.8D);
            Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("flansmod:gui/renk.png"));
            GL11.glPushMatrix();
            GL11.glTranslated(-30.0D, 0.0D, 0.0D);
            GL11.glTranslated(-65.0D, 0.0D, 0.0D);
            dortgen(42.5D, 1.0D, -1, 0);
            GL11.glTranslated(-42.5D, -1.0D, 0.0D);
            dortgen(1.0D, 12.0D, -1, 0);
            GL11.glPushMatrix();
            double genislik = fr.func_78256_a(String.format("%.2f", new Object[] { Float.valueOf(hiz) }));
            GL11.glTranslated(-genislik - 4.0D, 0.0D, 0.0D);
            dortgen(1.0D, 12.0D, -1, 0);
            GL11.glPopMatrix();
            GL11.glTranslated(0.0D, -6.5D, 0.0D);
            dortgen(genislik + 5.0D, 1.0D, -1, 0);
            GL11.glTranslated(0.0D, 12.5D, 0.0D);
            dortgen(genislik + 5.0D, 1.0D, -1, 0);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(-genislik / 2.0D, 0.0D, 0.0D);
            yazi(String.format("%.2f", new Object[] { Float.valueOf(hiz) }), renk, -140.0D, 0.0D, 1.0D);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(-fr.func_78256_a((int)(plane.throttle * 100.0D / 1.0D) + "%") / 2.0D, 0.0D, 0.0D);
            yazi((int)(plane.throttle * 100.0D / 1.0D) + "%", renk, -140.0D, 12.0D, 1.0D);
            GL11.glPopMatrix();
            double d2;
            for (d2 = -50.0D; d2 < 50.0D; d2 += 10.0D) {
              GL11.glPushMatrix();
              GL11.glTranslated(-30.0D, 0.0D, 0.0D);
              double fark = d2 + (hiz % 10.0F);
              GL11.glTranslated(-70.0D, fark * 2.0D, 0.0D);
              if (hiz - d2 >= 0.0D && -50.0D < fark && fark < 50.0D) {
                GL11.glColor4d(kirmizi / 255.0D * 0.85D, yesil / 255.0D * 0.85D, mavi / 255.0D * 0.85D, 0.8D);
                Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("flansmod:gui/renk.png"));
                dortgen(10.0D, 1.0D, 0, 0);
                String shiz = MathHelper.func_76128_c((hiz - hiz % 10.0F) - d2) + "";
                fr.func_78276_b(shiz, -10 - fr.func_78256_a(shiz) + 4, -4, renk);
              } 
              GL11.glPopMatrix();
            } 
            GL11.glPopMatrix();
          } 
        } 
      } 
    } 
  }
  
  public static void dortgen(double x, double y, int xhiza, int yhiza) {
    Tessellator t = Tessellator.field_78398_a;
    t.func_78382_b();
    double solx = -x / 2.0D + xhiza * x / 2.0D;
    double sagx = x / 2.0D + xhiza * x / 2.0D;
    double usty = -y / 2.0D + yhiza * y / 2.0D;
    double alty = y / 2.0D + yhiza * y / 2.0D;
    t.func_78377_a(solx, alty, 0.0D);
    t.func_78377_a(sagx, alty, 0.0D);
    t.func_78377_a(sagx, usty, 0.0D);
    t.func_78377_a(solx, usty, 0.0D);
    t.func_78381_a();
  }
  
  public static void yuvarlak(int i, double yaricap) {
    Tessellator t = Tessellator.field_78398_a;
    t.func_78371_b(9);
    while (i > 0) {
      double c = Math.cos(Math.toRadians(i));
      double s = Math.sin(Math.toRadians(i));
      t.func_78374_a(c * yaricap, s * yaricap, 0.0D, (c + 1.0D) / 2.0D, (s + 1.0D) / 2.0D);
      i--;
    } 
    t.func_78381_a();
  }
  
  public static void yazi(String s, int renk, double x, double y, double b) {
    FontRenderer fr = (Minecraft.func_71410_x()).field_71466_p;
    GL11.glPushMatrix();
    GL11.glTranslated(x, y, 0.0D);
    GL11.glScaled(b, b, 1.0D);
    fr.func_78276_b(s, -fr.func_78256_a(s) / 2, -fr.field_78288_b / 2, renk);
    GL11.glPopMatrix();
  }
  
  public static void nisangah(int tur) {
    double nisangahgenislik;
    switch (tur) {
      case 0:
        nisangahgenislik = 6.0D;
        GL11.glPushMatrix();
        GL11.glTranslated(0.0D, -nisangahgenislik, 0.0D);
        dortgen(1.5D, 6.0D, 0, 0);
        GL11.glTranslated(0.0D, nisangahgenislik * 2.0D, 0.0D);
        dortgen(1.5D, 6.0D, 0, 0);
        GL11.glTranslated(nisangahgenislik, -nisangahgenislik, 0.0D);
        dortgen(6.0D, 1.5D, 0, 0);
        GL11.glTranslated(-nisangahgenislik * 2.0D, 0.0D, 0.0D);
        dortgen(6.0D, 1.5D, 0, 0);
        GL11.glPopMatrix();
        break;
      case 1:
        nisangahgenislik = 8.0D;
        GL11.glPushMatrix();
        GL11.glTranslated(-nisangahgenislik, 0.0D, 0.0D);
        dortgen(1.5D, 8.0D, 0, 0);
        GL11.glTranslated(nisangahgenislik * 2.0D, 0.0D, 0.0D);
        dortgen(1.5D, 8.0D, 0, 0);
        GL11.glTranslated(-nisangahgenislik, nisangahgenislik, 0.0D);
        dortgen(8.0D, 1.5D, 0, 0);
        GL11.glTranslated(0.0D, -nisangahgenislik * 2.0D, 0.0D);
        dortgen(8.0D, 1.5D, 0, 0);
        GL11.glPopMatrix();
        break;
    } 
  }
  
  public static void yukseklik(int tur) {
    double i;
    switch (tur) {
      case 0:
        for (i = -15.0D; i < 25.0D; i += 5.0D) {
          GL11.glPushMatrix();
          GL11.glRotated(roll, 0.0D, 0.0D, 1.0D);
          double fark = i + pitch % 5.0D;
          GL11.glTranslated(0.0D, fark * 5.0D, 0.0D);
          GL11.glColor4d(kirmizi / 255.0D, yesil / 255.0D, mavi / 255.0D, 0.8D);
          Minecraft.func_71410_x().func_110434_K().func_110577_a(new ResourceLocation("flansmod:gui/renk.png"));
          boolean kisa = false;
          boolean sifir = false;
          int pi = MathHelper.func_76128_c(pitch - pitch % 5.0D - i);
          FontRenderer fr = (Minecraft.func_71410_x()).field_71466_p;
          if (pi == 0) {
            sifir = true;
            GL11.glPushMatrix();
            GL11.glTranslated(13.0D, 0.0D, 0.0D);
            dortgen(80.0D, 1.5D, 1, 0);
            GL11.glPopMatrix();
            GL11.glPushMatrix();
            GL11.glTranslated(-13.0D, 0.0D, 0.0D);
            dortgen(80.0D, 1.5D, -1, 0);
            GL11.glPopMatrix();
          } else if (pi % 10 == 0) {
            dortgen(80.0D, 1.0D, 0, 0);
            yazi(pi + "", renk, (fr.func_78256_a(pi + "") + 40), 0.0D, 1.0D);
          } 
          GL11.glPopMatrix();
        } 
        break;
    } 
  }
}
