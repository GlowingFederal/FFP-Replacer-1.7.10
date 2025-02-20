/*    */ package mcheli.vehicle;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import mcheli.weapon.MCH_WeaponParam;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ public class MCH_VehiclePacketHandler {
/*    */   public static void onPacket_PlayerControl(EntityPlayer player, ByteArrayDataInput data) {
/* 10 */     if (player.field_70154_o instanceof MCH_EntityVehicle && 
/* 11 */       !player.field_70170_p.field_72995_K) {
/* 12 */       MCH_PacketVehiclePlayerControl pc = new MCH_PacketVehiclePlayerControl();
/* 13 */       pc.readData(data);
/* 14 */       MCH_EntityVehicle vehicle = (MCH_EntityVehicle)player.field_70154_o;
/* 15 */       if (pc.isUnmount == 1) {
/* 16 */         vehicle.unmountEntity();
/* 17 */       } else if (pc.isUnmount == 2) {
/* 18 */         vehicle.unmountCrew();
/*    */       } else {
/* 20 */         if (pc.switchSearchLight) {
/* 21 */           vehicle.setSearchLight(!vehicle.isSearchLightON());
/*    */         }
/*    */         
/* 24 */         if (pc.switchCameraMode > 0) {
/* 25 */           vehicle.switchCameraMode(player, pc.switchCameraMode - 1);
/*    */         }
/*    */         
/* 28 */         if (pc.switchWeapon >= 0) {
/* 29 */           vehicle.switchWeapon((Entity)player, pc.switchWeapon);
/*    */         }
/*    */         
/* 32 */         if (pc.useWeapon) {
/* 33 */           MCH_WeaponParam e = new MCH_WeaponParam();
/* 34 */           e.entity = (Entity)vehicle;
/* 35 */           e.user = (Entity)player;
/* 36 */           e.setPosAndRot(pc.useWeaponPosX, pc.useWeaponPosY, pc.useWeaponPosZ, 0.0F, 0.0F);
/* 37 */           e.option1 = pc.useWeaponOption1;
/* 38 */           e.option2 = pc.useWeaponOption2;
/* 39 */           vehicle.useCurrentWeapon(e);
/*    */         } 
/*    */         
/* 42 */         if (vehicle.isPilot((Entity)player)) {
/* 43 */           vehicle.throttleUp = pc.throttleUp;
/* 44 */           vehicle.throttleDown = pc.throttleDown;
/* 45 */           vehicle.moveLeft = pc.moveLeft;
/* 46 */           vehicle.moveRight = pc.moveRight;
/*    */         } 
/*    */         
/* 49 */         if (pc.useFlareType > 0) {
/* 50 */           vehicle.useFlare(pc.useFlareType);
/*    */         }
/*    */ 
/*    */         
/* 54 */         if (pc.openGui) {
/* 55 */           vehicle.openGui(player);
/*    */         }
/*    */         
/* 58 */         if (pc.switchHatch > 0) {
/* 59 */           vehicle.foldHatch((pc.switchHatch == 2));
/*    */         }
/*    */         
/* 62 */         if (pc.isUnmount == 3)
/* 63 */           vehicle.unmountAircraft(); 
/*    */       } 
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\vehicle\MCH_VehiclePacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */