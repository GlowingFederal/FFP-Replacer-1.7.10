/*     */ package mcheli;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import mcheli.aircraft.MCH_AircraftPacketHandler;
/*     */ import mcheli.block.MCH_DraftingTablePacketHandler;
/*     */ import mcheli.command.MCH_CommandPacketHandler;
/*     */ import mcheli.gltd.MCH_GLTDPacketHandler;
/*     */ import mcheli.helicopter.MCH_HeliPacketHandler;
/*     */ import mcheli.lweapon.MCH_LightWeaponPacketHandler;
/*     */ import mcheli.multiplay.MCH_MultiplayPacketHandler;
/*     */ import mcheli.plane.MCP_PlanePacketHandler;
/*     */ import mcheli.tank.MCH_TankPacketHandler;
/*     */ import mcheli.tool.MCH_ToolPacketHandler;
/*     */ import mcheli.uav.MCH_UavPacketHandler;
/*     */ import mcheli.vehicle.MCH_VehiclePacketHandler;
/*     */ import mcheli.wrapper.W_PacketHandler;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ 
/*     */ public class MCH_PacketHandler
/*     */   extends W_PacketHandler {
/*     */   public void onPacket(ByteArrayDataInput data, EntityPlayer entityPlayer) {
/*  22 */     int msgid = getMessageId(data);
/*  23 */     switch (msgid) {
/*     */       
/*     */       default:
/*  26 */         MCH_Lib.DbgLog(entityPlayer.field_70170_p, "MCH_PacketHandler.onPacket invalid MSGID=0x%X(%d)", new Object[] { Integer.valueOf(msgid), Integer.valueOf(msgid) });
/*     */         return;
/*     */       case 268437520:
/*  29 */         MCH_CommonPacketHandler.onPacketEffectExplosion(entityPlayer, data);
/*     */         return;
/*     */       case 268437568:
/*  32 */         MCH_CommonPacketHandler.onPacketNotifyServerSettings(entityPlayer, data);
/*     */         return;
/*     */       case 268437761:
/*  35 */         MCH_MultiplayPacketHandler.onPacket_NotifySpotedEntity(entityPlayer, data);
/*     */         return;
/*     */       case 268437762:
/*  38 */         MCH_MultiplayPacketHandler.onPacket_NotifyMarkPoint(entityPlayer, data);
/*     */         return;
/*     */       case 268438032:
/*  41 */         MCH_MultiplayPacketHandler.onPacket_IndClient(entityPlayer, data);
/*     */         return;
/*     */       case 268438272:
/*  44 */         MCH_CommandPacketHandler.onPacketTitle(entityPlayer, data);
/*     */         return;
/*     */       case 268439569:
/*  47 */         MCH_AircraftPacketHandler.onPacketSeatListResponse(entityPlayer, data);
/*     */         return;
/*     */       case 268439600:
/*  50 */         MCH_AircraftPacketHandler.onPacketNotifyTVMissileEntity(entityPlayer, data);
/*     */         return;
/*     */       case 268439601:
/*  53 */         MCH_AircraftPacketHandler.onPacketNotifyWeaponID(entityPlayer, data);
/*     */         return;
/*     */       case 268439602:
/*  56 */         MCH_AircraftPacketHandler.onPacketNotifyHitBullet(entityPlayer, data);
/*     */         return;
/*     */       case 268439604:
/*  59 */         MCH_AircraftPacketHandler.onPacketNotifyAmmoNum(entityPlayer, data);
/*     */         return;
/*     */       case 268439632:
/*  62 */         MCH_AircraftPacketHandler.onPacketOnMountEntity(entityPlayer, data);
/*     */         return;
/*     */       case 268439649:
/*  65 */         MCH_AircraftPacketHandler.onPacketStatusResponse(entityPlayer, data);
/*     */         return;
/*     */       case 536872992:
/*  68 */         MCH_CommonPacketHandler.onPacketIndOpenScreen(entityPlayer, data);
/*     */         return;
/*     */       case 536873088:
/*  71 */         MCH_MultiplayPacketHandler.onPacket_Command(entityPlayer, data);
/*     */         return;
/*     */       case 536873216:
/*  74 */         MCH_ToolPacketHandler.onPacket_IndSpotEntity(entityPlayer, data);
/*     */         return;
/*     */       case 536873472:
/*  77 */         MCH_MultiplayPacketHandler.onPacket_LargeData(entityPlayer, data);
/*     */         return;
/*     */       case 536873473:
/*  80 */         MCH_MultiplayPacketHandler.onPacket_ModList(entityPlayer, data);
/*     */         return;
/*     */       case 536873729:
/*  83 */         MCH_CommandPacketHandler.onPacketSave(entityPlayer, data);
/*     */         return;
/*     */       case 536873984:
/*  86 */         MCH_CommonPacketHandler.onPacketNotifyLock(entityPlayer, data);
/*     */         return;
/*     */       case 536875024:
/*  89 */         MCH_AircraftPacketHandler.onPacketSeatListRequest(entityPlayer, data);
/*     */         return;
/*     */       case 536875040:
/*  92 */         MCH_AircraftPacketHandler.onPacket_PlayerControl(entityPlayer, data);
/*     */         return;
/*     */       case 536875059:
/*  95 */         MCH_AircraftPacketHandler.onPacketIndReload(entityPlayer, data);
/*     */         return;
/*     */       case 536875061:
/*  98 */         MCH_AircraftPacketHandler.onPacketIndNotifyAmmoNum(entityPlayer, data);
/*     */         return;
/*     */       case 536875062:
/* 101 */         MCH_AircraftPacketHandler.onPacketIndRotation(entityPlayer, data);
/*     */         return;
/*     */       case 536875063:
/* 104 */         MCH_AircraftPacketHandler.onPacketNotifyInfoReloaded(entityPlayer, data);
/*     */         return;
/*     */       case 536875072:
/* 107 */         MCH_AircraftPacketHandler.onPacket_ClientSetting(entityPlayer, data);
/*     */         return;
/*     */       case 536875104:
/* 110 */         MCH_AircraftPacketHandler.onPacketStatusRequest(entityPlayer, data);
/*     */         return;
/*     */       case 536879120:
/* 113 */         MCH_HeliPacketHandler.onPacket_PlayerControl(entityPlayer, data);
/*     */         return;
/*     */       case 536887312:
/* 116 */         MCH_GLTDPacketHandler.onPacket_GLTDPlayerControl(entityPlayer, data);
/*     */         return;
/*     */       case 536903696:
/* 119 */         MCP_PlanePacketHandler.onPacket_PlayerControl(entityPlayer, data);
/*     */         return;
/*     */       case 536936464:
/* 122 */         MCH_LightWeaponPacketHandler.onPacket_PlayerControl(entityPlayer, data);
/*     */         return;
/*     */       case 537002000:
/* 125 */         MCH_VehiclePacketHandler.onPacket_PlayerControl(entityPlayer, data);
/*     */         return;
/*     */       case 537133072:
/* 128 */         MCH_UavPacketHandler.onPacketUavStatus(entityPlayer, data);
/*     */         return;
/*     */       case 537395216:
/* 131 */         MCH_DraftingTablePacketHandler.onPacketCreate(entityPlayer, data);
/*     */         return;
/*     */       case 537919504:
/* 134 */         MCH_TankPacketHandler.onPacket_PlayerControl(entityPlayer, data);
/*     */         return;
/*     */       case 536875762:
/* 137 */         MCH_AircraftPacketHandler.onChangeAcSkin(entityPlayer, data); return;
/*     */       case 576875059:
/*     */         break;
/* 140 */     }  MCH_AircraftPacketHandler.onSetTargetPoint(entityPlayer, data);
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected int getMessageId(ByteArrayDataInput data) {
/*     */     try {
/* 148 */       return data.readInt();
/* 149 */     } catch (Exception var3) {
/* 150 */       var3.printStackTrace();
/* 151 */       return 0;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_PacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */