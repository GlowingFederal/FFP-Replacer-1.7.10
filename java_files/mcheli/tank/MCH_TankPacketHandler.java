/*     */ package mcheli.tank;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.uav.MCH_EntityUavStation;
/*     */ import mcheli.weapon.MCH_WeaponParam;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ public class MCH_TankPacketHandler {
/*     */   public static void onPacket_PlayerControl(EntityPlayer player, ByteArrayDataInput data) {
/*  12 */     if (!player.field_70170_p.field_72995_K) {
/*  13 */       MCH_TankPacketPlayerControl pc = new MCH_TankPacketPlayerControl();
/*  14 */       pc.readData(data);
/*  15 */       boolean isPilot = true;
/*  16 */       MCH_EntityTank tank = null;
/*  17 */       if (player.field_70154_o instanceof MCH_EntityTank) {
/*  18 */         tank = (MCH_EntityTank)player.field_70154_o;
/*  19 */       } else if (player.field_70154_o instanceof MCH_EntitySeat) {
/*  20 */         if (((MCH_EntitySeat)player.field_70154_o).getParent() instanceof MCH_EntityTank) {
/*  21 */           tank = (MCH_EntityTank)((MCH_EntitySeat)player.field_70154_o).getParent();
/*     */         }
/*  23 */       } else if (player.field_70154_o instanceof MCH_EntityUavStation) {
/*  24 */         MCH_EntityUavStation ac = (MCH_EntityUavStation)player.field_70154_o;
/*  25 */         if (ac.getControlAircract() instanceof MCH_EntityTank) {
/*  26 */           tank = (MCH_EntityTank)ac.getControlAircract();
/*     */         }
/*     */       } 
/*     */       
/*  30 */       if (tank != null)
/*  31 */         if (pc.isUnmount == 1) {
/*  32 */           tank.unmountEntity();
/*  33 */         } else if (pc.isUnmount == 2) {
/*  34 */           tank.unmountCrew();
/*  35 */         } else if (pc.ejectSeat) {
/*  36 */           tank.ejectSeat((Entity)player);
/*     */         } else {
/*  38 */           if (pc.switchMode == 0) {
/*  39 */             tank.switchGunnerMode(false);
/*     */           }
/*     */           
/*  42 */           if (pc.switchMode == 1) {
/*  43 */             tank.switchGunnerMode(true);
/*     */           }
/*     */           
/*  46 */           if (pc.switchMode == 2) {
/*  47 */             tank.switchHoveringMode(false);
/*     */           }
/*     */           
/*  50 */           if (pc.switchMode == 3) {
/*  51 */             tank.switchHoveringMode(true);
/*     */           }
/*     */           
/*  54 */           if (pc.switchSearchLight) {
/*  55 */             tank.setSearchLight(!tank.isSearchLightON());
/*     */           }
/*     */           
/*  58 */           if (pc.switchCameraMode > 0) {
/*  59 */             tank.switchCameraMode(player, pc.switchCameraMode - 1);
/*     */           }
/*     */           
/*  62 */           if (pc.switchWeapon >= 0) {
/*  63 */             tank.switchWeapon((Entity)player, pc.switchWeapon);
/*     */           }
/*     */           
/*  66 */           if (pc.useWeapon) {
/*  67 */             MCH_WeaponParam dx = new MCH_WeaponParam();
/*  68 */             dx.entity = (Entity)tank;
/*  69 */             dx.user = (Entity)player;
/*  70 */             dx.setPosAndRot(pc.useWeaponPosX, pc.useWeaponPosY, pc.useWeaponPosZ, 0.0F, 0.0F);
/*  71 */             dx.option1 = pc.useWeaponOption1;
/*  72 */             dx.option2 = pc.useWeaponOption2;
/*  73 */             tank.useCurrentWeapon(dx);
/*     */           } 
/*     */           
/*  76 */           if (tank.isPilot((Entity)player)) {
/*  77 */             tank.throttleUp = pc.throttleUp;
/*  78 */             tank.throttleDown = pc.throttleDown;
/*  79 */             double dx1 = tank.field_70165_t - tank.field_70169_q;
/*  80 */             double dz = tank.field_70161_v - tank.field_70166_s;
/*  81 */             double dist = dx1 * dx1 + dz * dz;
/*  82 */             if (pc.useBrake && tank.getCurrentThrottle() <= 0.03D && dist < 0.01D) {
/*  83 */               tank.moveLeft = false;
/*  84 */               tank.moveRight = false;
/*     */             } 
/*     */             
/*  87 */             tank.setBrake(pc.useBrake);
/*     */           } 
/*     */           
/*  90 */           if (pc.useFlareType > 0) {
/*  91 */             tank.useFlare(pc.useFlareType);
/*     */           }
/*     */           
/*  94 */           if (pc.openGui) {
/*  95 */             tank.openGui(player);
/*     */           }
/*     */           
/*  98 */           if (pc.switchHatch > 0 && tank.getAcInfo().haveHatch()) {
/*  99 */             tank.foldHatch((pc.switchHatch == 2));
/*     */           }
/*     */           
/* 102 */           if (pc.switchFreeLook > 0) {
/* 103 */             tank.switchFreeLookMode((pc.switchFreeLook == 1));
/*     */           }
/*     */           
/* 106 */           if (pc.switchGear == 1) {
/* 107 */             tank.foldLandingGear();
/*     */           }
/*     */           
/* 110 */           if (pc.switchGear == 2) {
/* 111 */             tank.unfoldLandingGear();
/*     */           }
/*     */           
/* 114 */           if (pc.putDownRack == 1) {
/* 115 */             tank.mountEntityToRack();
/*     */           }
/*     */           
/* 118 */           if (pc.putDownRack == 2) {
/* 119 */             tank.unmountEntityFromRack();
/*     */           }
/*     */           
/* 122 */           if (pc.putDownRack == 3) {
/* 123 */             tank.rideRack();
/*     */           }
/*     */           
/* 126 */           if (pc.isUnmount == 3)
/* 127 */             tank.unmountAircraft(); 
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tank\MCH_TankPacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */