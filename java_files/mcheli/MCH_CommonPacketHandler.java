/*    */ package mcheli;
/*    */ 
/*    */ import com.google.common.io.ByteArrayDataInput;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.aircraft.MCH_EntitySeat;
/*    */ import mcheli.lweapon.MCH_ClientLightWeaponTickHandler;
/*    */ import mcheli.wrapper.W_Reflection;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.entity.player.EntityPlayer;
/*    */ 
/*    */ 
/*    */ public class MCH_CommonPacketHandler
/*    */ {
/*    */   public static void onPacketEffectExplosion(EntityPlayer player, ByteArrayDataInput data) {
/* 15 */     if (player.field_70170_p.field_72995_K) {
/* 16 */       MCH_PacketEffectExplosion pkt = new MCH_PacketEffectExplosion();
/* 17 */       pkt.readData(data);
/* 18 */       Object exploder = null;
/* 19 */       if (player.func_70092_e(pkt.prm.posX, pkt.prm.posY, pkt.prm.posZ) <= 40000.0D) {
/* 20 */         if (!pkt.prm.inWater) {
/* 21 */           MCH_Config var10000 = MCH_MOD.config;
/* 22 */           if (!MCH_Config.DefaultExplosionParticle.prmBool) {
/* 23 */             MCH_Explosion.effectExplosion(player.field_70170_p, (Entity)exploder, pkt.prm.posX, pkt.prm.posY, pkt.prm.posZ, pkt.prm.size, true);
/*    */           } else {
/* 25 */             MCH_Explosion.DEF_effectExplosion(player.field_70170_p, (Entity)exploder, pkt.prm.posX, pkt.prm.posY, pkt.prm.posZ, pkt.prm.size, true);
/*    */           } 
/*    */         } else {
/* 28 */           MCH_Explosion.effectExplosionInWater(player.field_70170_p, (Entity)exploder, pkt.prm.posX, pkt.prm.posY, pkt.prm.posZ, pkt.prm.size, true);
/*    */         } 
/*    */       }
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void onPacketIndOpenScreen(EntityPlayer player, ByteArrayDataInput data) {
/* 36 */     if (!player.field_70170_p.field_72995_K) {
/* 37 */       MCH_PacketIndOpenScreen pkt = new MCH_PacketIndOpenScreen();
/* 38 */       pkt.readData(data);
/* 39 */       if (pkt.guiID == 3) {
/* 40 */         MCH_EntityAircraft ac = MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)player);
/* 41 */         if (ac != null) {
/* 42 */           ac.openInventory(player);
/*    */         }
/*    */       } else {
/* 45 */         player.openGui(MCH_MOD.instance, pkt.guiID, player.field_70170_p, (int)player.field_70165_t, (int)player.field_70163_u, (int)player.field_70161_v);
/*    */       } 
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   public static void onPacketNotifyServerSettings(EntityPlayer player, ByteArrayDataInput data) {
/* 52 */     if (player.field_70170_p.field_72995_K) {
/* 53 */       MCH_Lib.DbgLog(false, "onPacketNotifyServerSettings:" + player, new Object[0]);
/* 54 */       MCH_PacketNotifyServerSettings pkt = new MCH_PacketNotifyServerSettings();
/* 55 */       pkt.readData(data);
/* 56 */       if (!pkt.enableCamDistChange) {
/* 57 */         W_Reflection.setThirdPersonDistance(4.0F);
/*    */       }
/*    */       
/* 60 */       MCH_ServerSettings.enableCamDistChange = pkt.enableCamDistChange;
/* 61 */       MCH_ServerSettings.enableEntityMarker = pkt.enableEntityMarker;
/* 62 */       MCH_ServerSettings.enablePVP = pkt.enablePVP;
/* 63 */       MCH_ServerSettings.stingerLockRange = pkt.stingerLockRange;
/* 64 */       MCH_ServerSettings.enableDebugBoundingBox = pkt.enableDebugBoundingBox;
/* 65 */       MCH_ClientLightWeaponTickHandler.lockRange = MCH_ServerSettings.stingerLockRange;
/*    */     } 
/*    */   }
/*    */   
/*    */   public static void onPacketNotifyLock(EntityPlayer player, ByteArrayDataInput data) {
/* 70 */     MCH_PacketNotifyLock pkt = new MCH_PacketNotifyLock();
/* 71 */     pkt.readData(data);
/* 72 */     if (!player.field_70170_p.field_72995_K) {
/* 73 */       if (pkt.entityID >= 0) {
/* 74 */         Entity target = player.field_70170_p.func_73045_a(pkt.entityID);
/* 75 */         if (target != null) {
/* 76 */           MCH_EntityAircraft ac = null;
/* 77 */           if (target instanceof MCH_EntityAircraft) {
/* 78 */             ac = (MCH_EntityAircraft)target;
/* 79 */           } else if (target instanceof MCH_EntitySeat) {
/* 80 */             ac = ((MCH_EntitySeat)target).getParent();
/*    */           } else {
/* 82 */             ac = MCH_EntityAircraft.getAircraft_RiddenOrControl(target);
/*    */           } 
/*    */           
/* 85 */           if (ac != null && ac.haveFlare() && !ac.isDestroyed()) {
/* 86 */             for (int i = 0; i < 2; i++) {
/* 87 */               Entity entity = ac.getEntityBySeatId(i);
/* 88 */               if (entity instanceof net.minecraft.entity.player.EntityPlayerMP) {
/* 89 */                 MCH_PacketNotifyLock.sendToPlayer((EntityPlayer)entity);
/*    */               }
/*    */             } 
/*    */           }
/*    */         } 
/*    */       } 
/*    */     } else {
/* 96 */       MCH_MOD.proxy.clientLocked();
/*    */     } 
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_CommonPacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */