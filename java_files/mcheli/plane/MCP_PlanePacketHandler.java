/*     */ package mcheli.plane;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.uav.MCH_EntityUavStation;
/*     */ import mcheli.weapon.MCH_WeaponParam;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ public class MCP_PlanePacketHandler {
/*     */   public static void onPacket_PlayerControl(EntityPlayer player, ByteArrayDataInput data) {
/*  12 */     if (!player.field_70170_p.field_72995_K) {
/*  13 */       MCP_PlanePacketPlayerControl pc = new MCP_PlanePacketPlayerControl();
/*  14 */       pc.readData(data);
/*  15 */       boolean isPilot = true;
/*  16 */       MCP_EntityPlane plane = null;
/*  17 */       if (player.field_70154_o instanceof MCP_EntityPlane) {
/*  18 */         plane = (MCP_EntityPlane)player.field_70154_o;
/*  19 */       } else if (player.field_70154_o instanceof MCH_EntitySeat) {
/*  20 */         if (((MCH_EntitySeat)player.field_70154_o).getParent() instanceof MCP_EntityPlane) {
/*  21 */           plane = (MCP_EntityPlane)((MCH_EntitySeat)player.field_70154_o).getParent();
/*     */         }
/*  23 */       } else if (player.field_70154_o instanceof MCH_EntityUavStation) {
/*  24 */         MCH_EntityUavStation ac = (MCH_EntityUavStation)player.field_70154_o;
/*  25 */         if (ac.getControlAircract() instanceof MCP_EntityPlane) {
/*  26 */           plane = (MCP_EntityPlane)ac.getControlAircract();
/*     */         }
/*     */       } 
/*     */       
/*  30 */       if (plane != null)
/*  31 */         if (pc.isUnmount == 1) {
/*  32 */           plane.unmountEntity();
/*  33 */         } else if (pc.isUnmount == 2) {
/*  34 */           plane.unmountCrew();
/*  35 */         } else if (pc.ejectSeat) {
/*  36 */           plane.ejectSeat((Entity)player);
/*     */         } else {
/*  38 */           if (pc.switchVtol == 0) {
/*  39 */             plane.swithVtolMode(false);
/*     */           }
/*     */           
/*  42 */           if (pc.switchVtol == 1) {
/*  43 */             plane.swithVtolMode(true);
/*     */           }
/*     */           
/*  46 */           if (pc.switchMode == 0) {
/*  47 */             plane.switchGunnerMode(false);
/*     */           }
/*     */           
/*  50 */           if (pc.switchMode == 1) {
/*  51 */             plane.switchGunnerMode(true);
/*     */           }
/*     */           
/*  54 */           if (pc.switchMode == 2) {
/*  55 */             plane.switchHoveringMode(false);
/*     */           }
/*     */           
/*  58 */           if (pc.switchMode == 3) {
/*  59 */             plane.switchHoveringMode(true);
/*     */           }
/*     */           
/*  62 */           if (pc.switchSearchLight) {
/*  63 */             plane.setSearchLight(!plane.isSearchLightON());
/*     */           }
/*     */           
/*  66 */           if (pc.switchCameraMode > 0) {
/*  67 */             plane.switchCameraMode(player, pc.switchCameraMode - 1);
/*     */           }
/*     */           
/*  70 */           if (pc.switchWeapon >= 0) {
/*  71 */             plane.switchWeapon((Entity)player, pc.switchWeapon);
/*     */           }
/*     */           
/*  74 */           if (pc.useWeapon) {
/*  75 */             MCH_WeaponParam prm = new MCH_WeaponParam();
/*  76 */             prm.entity = (Entity)plane;
/*  77 */             prm.user = (Entity)player;
/*  78 */             prm.setPosAndRot(pc.useWeaponPosX, pc.useWeaponPosY, pc.useWeaponPosZ, 0.0F, 0.0F);
/*  79 */             prm.option1 = pc.useWeaponOption1;
/*  80 */             prm.option2 = pc.useWeaponOption2;
/*  81 */             plane.useCurrentWeapon(prm);
/*     */           } 
/*     */           
/*  84 */           if (plane.isPilot((Entity)player)) {
/*  85 */             plane.throttleUp = pc.throttleUp;
/*  86 */             plane.throttleDown = pc.throttleDown;
/*  87 */             plane.moveLeft = pc.moveLeft;
/*  88 */             plane.moveRight = pc.moveRight;
/*     */           } 
/*     */           
/*  91 */           if (pc.useFlareType > 0) {
/*  92 */             plane.useFlare(pc.useFlareType);
/*     */           }
/*     */           
/*  95 */           if (pc.openGui) {
/*  96 */             plane.openGui(player);
/*     */           }
/*     */           
/*  99 */           if (pc.switchHatch > 0) {
/* 100 */             if (plane.getAcInfo().haveHatch()) {
/* 101 */               plane.foldHatch((pc.switchHatch == 2));
/*     */             } else {
/* 103 */               plane.foldWing((pc.switchHatch == 2));
/*     */             } 
/*     */           }
/*     */           
/* 107 */           if (pc.switchFreeLook > 0) {
/* 108 */             plane.switchFreeLookMode((pc.switchFreeLook == 1));
/*     */           }
/*     */           
/* 111 */           if (pc.switchGear == 1) {
/* 112 */             plane.foldLandingGear();
/*     */           }
/*     */           
/* 115 */           if (pc.switchGear == 2) {
/* 116 */             plane.unfoldLandingGear();
/*     */           }
/*     */           
/* 119 */           if (pc.putDownRack == 1) {
/* 120 */             plane.mountEntityToRack();
/*     */           }
/*     */           
/* 123 */           if (pc.putDownRack == 2) {
/* 124 */             plane.unmountEntityFromRack();
/*     */           }
/*     */           
/* 127 */           if (pc.putDownRack == 3) {
/* 128 */             plane.rideRack();
/*     */           }
/*     */           
/* 131 */           if (pc.isUnmount == 3)
/* 132 */             plane.unmountAircraft(); 
/*     */         }  
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\plane\MCP_PlanePacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */