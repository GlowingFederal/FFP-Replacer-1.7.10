/*     */ package mcheli.helicopter;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.uav.MCH_EntityUavStation;
/*     */ import mcheli.weapon.MCH_WeaponParam;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ public class MCH_HeliPacketHandler {
/*     */   public static void onPacket_PlayerControl(EntityPlayer player, ByteArrayDataInput data) {
/*  12 */     if (!player.field_70170_p.field_72995_K) {
/*  13 */       MCH_HeliPacketPlayerControl pc = new MCH_HeliPacketPlayerControl();
/*  14 */       pc.readData(data);
/*  15 */       MCH_EntityHeli heli = null;
/*  16 */       if (player.field_70154_o instanceof MCH_EntityHeli) {
/*  17 */         heli = (MCH_EntityHeli)player.field_70154_o;
/*  18 */       } else if (player.field_70154_o instanceof MCH_EntitySeat) {
/*  19 */         if (((MCH_EntitySeat)player.field_70154_o).getParent() instanceof MCH_EntityHeli) {
/*  20 */           heli = (MCH_EntityHeli)((MCH_EntitySeat)player.field_70154_o).getParent();
/*     */         }
/*  22 */       } else if (player.field_70154_o instanceof MCH_EntityUavStation) {
/*  23 */         MCH_EntityUavStation ac = (MCH_EntityUavStation)player.field_70154_o;
/*  24 */         if (ac.getControlAircract() instanceof MCH_EntityHeli) {
/*  25 */           heli = (MCH_EntityHeli)ac.getControlAircract();
/*     */         }
/*     */       } 
/*     */       
/*  29 */       if (heli != null)
/*  30 */         if (pc.isUnmount == 1) {
/*  31 */           heli.unmountEntity();
/*  32 */         } else if (pc.isUnmount == 2) {
/*  33 */           heli.unmountCrew();
/*     */         } else {
/*  35 */           if (pc.switchFold == 0) {
/*  36 */             heli.setFoldBladeStat((byte)3);
/*     */           }
/*     */           
/*  39 */           if (pc.switchFold == 1) {
/*  40 */             heli.setFoldBladeStat((byte)1);
/*     */           }
/*     */           
/*  43 */           if (pc.switchMode == 0) {
/*  44 */             heli.switchGunnerMode(false);
/*     */           }
/*     */           
/*  47 */           if (pc.switchMode == 1) {
/*  48 */             heli.switchGunnerMode(true);
/*     */           }
/*     */           
/*  51 */           if (pc.switchMode == 2) {
/*  52 */             heli.switchHoveringMode(false);
/*     */           }
/*     */           
/*  55 */           if (pc.switchMode == 3) {
/*  56 */             heli.switchHoveringMode(true);
/*     */           }
/*     */           
/*  59 */           if (pc.switchSearchLight) {
/*  60 */             heli.setSearchLight(!heli.isSearchLightON());
/*     */           }
/*     */           
/*  63 */           if (pc.switchCameraMode > 0) {
/*  64 */             heli.switchCameraMode(player, pc.switchCameraMode - 1);
/*     */           }
/*     */           
/*  67 */           if (pc.switchWeapon >= 0) {
/*  68 */             heli.switchWeapon((Entity)player, pc.switchWeapon);
/*     */           }
/*     */           
/*  71 */           if (pc.useWeapon) {
/*  72 */             MCH_WeaponParam e = new MCH_WeaponParam();
/*  73 */             e.entity = (Entity)heli;
/*  74 */             e.user = (Entity)player;
/*  75 */             e.setPosAndRot(pc.useWeaponPosX, pc.useWeaponPosY, pc.useWeaponPosZ, 0.0F, 0.0F);
/*  76 */             e.option1 = pc.useWeaponOption1;
/*  77 */             e.option2 = pc.useWeaponOption2;
/*  78 */             heli.useCurrentWeapon(e);
/*     */           } 
/*     */           
/*  81 */           if (heli.isPilot((Entity)player)) {
/*  82 */             heli.throttleUp = pc.throttleUp;
/*  83 */             heli.throttleDown = pc.throttleDown;
/*  84 */             heli.moveLeft = pc.moveLeft;
/*  85 */             heli.moveRight = pc.moveRight;
/*     */           } 
/*     */           
/*  88 */           if (pc.useFlareType > 0) {
/*  89 */             heli.useFlare(pc.useFlareType);
/*     */           }
/*     */ 
/*     */           
/*  93 */           if (pc.openGui) {
/*  94 */             heli.openGui(player);
/*     */           }
/*     */           
/*  97 */           if (pc.switchHatch > 0) {
/*  98 */             heli.foldHatch((pc.switchHatch == 2));
/*     */           }
/*     */           
/* 101 */           if (pc.switchFreeLook > 0) {
/* 102 */             heli.switchFreeLookMode((pc.switchFreeLook == 1));
/*     */           }
/*     */           
/* 105 */           if (pc.switchGear == 1) {
/* 106 */             heli.foldLandingGear();
/*     */           }
/*     */           
/* 109 */           if (pc.switchGear == 2) {
/* 110 */             heli.unfoldLandingGear();
/*     */           }
/*     */           
/* 113 */           if (pc.putDownRack == 1) {
/* 114 */             heli.mountEntityToRack();
/*     */           }
/*     */           
/* 117 */           if (pc.putDownRack == 2) {
/* 118 */             heli.unmountEntityFromRack();
/*     */           }
/*     */           
/* 121 */           if (pc.putDownRack == 3) {
/* 122 */             heli.rideRack();
/*     */           }
/*     */           
/* 125 */           if (pc.isUnmount == 3)
/* 126 */             heli.unmountAircraft(); 
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\helicopter\MCH_HeliPacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */