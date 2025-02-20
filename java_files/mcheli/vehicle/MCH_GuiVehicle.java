/*     */ package mcheli.vehicle;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_KeyName;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftCommonGui;
/*     */ import mcheli.gui.MCH_Gui;
/*     */ import mcheli.weapon.MCH_WeaponSet;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_GuiVehicle
/*     */   extends MCH_AircraftCommonGui {
/*     */   static final int COLOR1 = -14066;
/*     */   static final int COLOR2 = -2161656;
/*     */   
/*     */   public MCH_GuiVehicle(Minecraft minecraft) {
/*  23 */     super(minecraft);
/*     */   }
/*     */   
/*     */   public boolean isDrawGui(EntityPlayer player) {
/*  27 */     return (player.field_70154_o != null && player.field_70154_o instanceof MCH_EntityVehicle);
/*     */   } public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/*     */     MCH_EntityVehicle vehicle;
/*     */     int seatID;
/*  31 */     if (player.field_70154_o != null && player.field_70154_o instanceof MCH_EntityVehicle)
/*  32 */     { vehicle = (MCH_EntityVehicle)player.field_70154_o;
/*  33 */       if (!vehicle.isDestroyed())
/*  34 */       { seatID = vehicle.getSeatIdByEntity((Entity)player);
/*  35 */         GL11.glLineWidth(MCH_Gui.scaleFactor);
/*  36 */         if (vehicle.getCameraMode(player) == 1) {
/*  37 */           drawNightVisionNoise();
/*     */         }
/*     */         
/*  40 */         if (vehicle.getIsGunnerMode((Entity)player) && vehicle.getTVMissile() != null) {
/*  41 */           drawTvMissileNoise(vehicle, vehicle.getTVMissile());
/*     */         }
/*     */ 
/*     */         
/*  45 */         drawDebugtInfo(vehicle);
/*  46 */         if (isThirdPersonView)
/*  47 */         { MCH_Config var10000 = MCH_MOD.config;
/*  48 */           if (!MCH_Config.DisplayHUDThirdPerson.prmBool)
/*     */           
/*     */           { 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/*  57 */             drawHitBullet(vehicle, -14066, seatID); return; }  }  drawHud(vehicle, player, seatID); drawKeyBind(vehicle, player); } else { return; }  } else { return; }  drawHitBullet(vehicle, -14066, seatID);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void drawKeyBind(MCH_EntityVehicle vehicle, EntityPlayer player) {
/*  63 */     MCH_Config var10000 = MCH_MOD.config;
/*  64 */     if (!MCH_Config.HideKeybind.prmBool) {
/*  65 */       MCH_VehicleInfo info = vehicle.getVehicleInfo();
/*  66 */       if (info != null) {
/*  67 */         int colorActive = -1342177281;
/*  68 */         int colorInactive = -1349546097;
/*  69 */         int RX = this.centerX + 120;
/*  70 */         int LX = this.centerX - 200;
/*     */ 
/*     */ 
/*     */         
/*  74 */         if (vehicle.haveFlare()) {
/*  75 */           int c = vehicle.isFlarePreparation() ? colorInactive : colorActive;
/*  76 */           StringBuilder var11 = (new StringBuilder()).append("Flare : ");
/*  77 */           MCH_Config var10001 = MCH_MOD.config;
/*  78 */           String str = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeyFlare.prmInt)).toString();
/*  79 */           drawString(str, RX, this.centerY - 50, c);
/*     */         } 
/*     */         
/*  82 */         if (vehicle.func_70302_i_() > 0);
/*     */ 
/*     */ 
/*     */ 
/*     */         
/*  87 */         if (vehicle.camera.getCameraZoom() > 1.0F) {
/*  88 */           StringBuilder var11 = (new StringBuilder()).append("Zoom : ");
/*  89 */           MCH_Config var10001 = MCH_MOD.config;
/*  90 */           String str = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt)).toString();
/*  91 */           drawString(str, LX, this.centerY - 80, colorActive);
/*     */         } 
/*     */         
/*  94 */         MCH_WeaponSet ws = vehicle.getCurrentWeapon((Entity)player);
/*  95 */         if (vehicle.getWeaponNum() > 1) {
/*  96 */           StringBuilder var11 = (new StringBuilder()).append("Weapon : ");
/*  97 */           MCH_Config var10001 = MCH_MOD.config;
/*  98 */           String str = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwitchWeapon2.prmInt)).toString();
/*  99 */           drawString(str, LX, this.centerY - 70, colorActive);
/*     */         } 
/*     */         
/* 102 */         if ((ws.getCurrentWeapon()).numMode > 0) {
/* 103 */           StringBuilder var11 = (new StringBuilder()).append("WeaponMode : ");
/* 104 */           MCH_Config var10001 = MCH_MOD.config;
/* 105 */           String str = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwWeaponMode.prmInt)).toString();
/* 106 */           drawString(str, LX, this.centerY - 60, colorActive);
/*     */         } 
/*     */         
/* 109 */         if (info.isEnableNightVision) {
/* 110 */           StringBuilder var11 = (new StringBuilder()).append("CameraMode : ");
/* 111 */           MCH_Config var10001 = MCH_MOD.config;
/* 112 */           String str = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeyCameraMode.prmInt)).toString();
/* 113 */           drawString(str, LX, this.centerY - 50, colorActive);
/*     */         } 
/*     */         
/* 116 */         String msg = "Dismount all : LShift";
/* 117 */         drawString(msg, LX, this.centerY - 40, colorActive);
/* 118 */         if (vehicle.getSeatNum() >= 2) {
/* 119 */           StringBuilder var11 = (new StringBuilder()).append("Dismount : ");
/* 120 */           MCH_Config var10001 = MCH_MOD.config;
/* 121 */           msg = var11.append(MCH_KeyName.getDescOrName(MCH_Config.KeyUnmount.prmInt)).toString();
/* 122 */           drawString(msg, LX, this.centerY - 30, colorActive);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\vehicle\MCH_GuiVehicle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */