/*    */ package mcheli.hud;
/*    */ 
/*    */ import mcheli.MCH_Camera;
/*    */ import mcheli.MCH_Lib;
/*    */ import net.minecraft.entity.Entity;
/*    */ 
/*    */ public class MCH_HudItemCameraRot
/*    */   extends MCH_HudItem
/*    */ {
/*    */   private final String drawPosX;
/*    */   private final String drawPosY;
/*    */   
/*    */   public MCH_HudItemCameraRot(int fileLine, String posx, String posy) {
/* 14 */     super(fileLine);
/* 15 */     this.drawPosX = toFormula(posx);
/* 16 */     this.drawPosY = toFormula(posy);
/*    */   }
/*    */   
/*    */   public void execute() {
/* 20 */     drawCommonGunnerCamera((Entity)MCH_HudItem.ac, MCH_HudItem.ac.camera, MCH_HudItem.colorSetting, MCH_HudItem.centerX + calc(this.drawPosX), MCH_HudItem.centerY + calc(this.drawPosY));
/*    */   }
/*    */   
/*    */   private void drawCommonGunnerCamera(Entity ac, MCH_Camera camera, int color, double posX, double posY) {
/* 24 */     if (camera != null) {
/* 25 */       boolean WW = true;
/* 26 */       boolean WH = true;
/* 27 */       boolean LW = true;
/* 28 */       double[] line = { posX - 21.0D, posY - 11.0D, posX + 21.0D, posY - 11.0D, posX + 21.0D, posY + 11.0D, posX - 21.0D, posY + 11.0D };
/* 29 */       drawLine(line, color, 2);
/* 30 */       line = new double[] { posX - 21.0D, posY, posX, posY, posX + 21.0D, posY, posX, posY, posX, posY - 11.0D, posX, posY, posX, posY + 11.0D, posX, posY };
/* 31 */       drawLineStipple(line, color, 1, 52428);
/* 32 */       float pitch = camera.rotationPitch;
/* 33 */       if (pitch < -30.0F) {
/* 34 */         pitch = -30.0F;
/*    */       }
/*    */       
/* 37 */       if (pitch > 70.0F) {
/* 38 */         pitch = 70.0F;
/*    */       }
/*    */       
/* 41 */       pitch -= 20.0F;
/* 42 */       pitch = (float)(pitch * 0.16D);
/* 43 */       float var10000 = ac.field_70126_B + (ac.field_70177_z - ac.field_70126_B) / 2.0F;
/* 44 */       var10000 = camera.prevRotationYaw + (camera.rotationYaw - camera.prevRotationYaw) / 2.0F;
/* 45 */       float yaw = (float)MCH_Lib.getRotateDiff(ac.field_70177_z, camera.rotationYaw);
/* 46 */       yaw *= 2.0F;
/* 47 */       if (yaw < -50.0F) {
/* 48 */         yaw = -50.0F;
/*    */       }
/*    */       
/* 51 */       if (yaw > 50.0F) {
/* 52 */         yaw = 50.0F;
/*    */       }
/*    */       
/* 55 */       yaw = (float)(yaw * 0.34D);
/* 56 */       line = new double[] { posX + yaw - 3.0D, posY + pitch - 2.0D, posX + yaw + 3.0D, posY + pitch - 2.0D, posX + yaw + 3.0D, posY + pitch + 2.0D, posX + yaw - 3.0D, posY + pitch + 2.0D };
/* 57 */       drawLine(line, color, 2);
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemCameraRot.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */