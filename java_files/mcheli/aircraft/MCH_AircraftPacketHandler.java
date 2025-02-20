/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import com.google.common.io.ByteArrayDataInput;
/*     */ import java.util.List;
/*     */ import java.util.UUID;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.weapon.MCH_EntityTvMissile;
/*     */ import mcheli.weapon.MCH_WeaponInfoManager;
/*     */ import mcheli.weapon.MCH_WeaponSet;
/*     */ import mcheli.wrapper.W_Entity;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.WorldServer;
/*     */ 
/*     */ 
/*     */ public class MCH_AircraftPacketHandler
/*     */ {
/*     */   public static void onSetTargetPoint(EntityPlayer player, ByteArrayDataInput data) {
/*  23 */     if (player != null && !player.field_70170_p.field_72995_K) {
/*  24 */       int AcEntityID = data.readInt();
/*  25 */       int weaponID = data.readByte();
/*  26 */       int x = data.readInt();
/*  27 */       int y = data.readInt();
/*  28 */       int z = data.readInt();
/*  29 */       MCH_EntityAircraft ac = (MCH_EntityAircraft)player.field_70170_p.func_73045_a(AcEntityID);
/*  30 */       MCH_WeaponSet ws = ac.getWeapon(weaponID);
/*  31 */       ws.targetPoint = Vec3.func_72443_a(x, y, z);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onChangeAcSkin(EntityPlayer player, ByteArrayDataInput data) {
/*  37 */     if (player != null && !player.field_70170_p.field_72995_K) {
/*  38 */       int AcEntityID = data.readInt();
/*  39 */       MCH_EntityAircraft ac = (MCH_EntityAircraft)player.field_70170_p.func_73045_a(AcEntityID);
/*  40 */       ac.switchNextTextureName();
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void onPacketIndRotation(EntityPlayer player, ByteArrayDataInput data) {
/*  45 */     if (player != null && !player.field_70170_p.field_72995_K) {
/*  46 */       MCH_PacketIndRotation req = new MCH_PacketIndRotation();
/*  47 */       req.readData(data);
/*  48 */       if (req.entityID_Ac > 0) {
/*  49 */         Entity e = player.field_70170_p.func_73045_a(req.entityID_Ac);
/*  50 */         if (e instanceof MCH_EntityAircraft) {
/*  51 */           MCH_EntityAircraft ac = (MCH_EntityAircraft)e;
/*  52 */           ac.setRotRoll(req.roll);
/*  53 */           if (req.rollRev) {
/*  54 */             MCH_Lib.DbgLog(ac.field_70170_p, "onPacketIndRotation Error:req.rollRev y=%.2f, p=%.2f, r=%.2f", new Object[] { Float.valueOf(req.yaw), Float.valueOf(req.pitch), Float.valueOf(req.roll) });
/*  55 */             if (ac.getRiddenByEntity() != null) {
/*  56 */               (ac.getRiddenByEntity()).field_70177_z = req.yaw;
/*  57 */               (ac.getRiddenByEntity()).field_70126_B = req.yaw;
/*     */             } 
/*     */             
/*  60 */             for (int sid = 0; sid < ac.getSeatNum(); sid++) {
/*  61 */               Entity entity = ac.getEntityBySeatId(1 + sid);
/*  62 */               if (entity != null) {
/*  63 */                 entity.field_70177_z += (entity.field_70177_z <= 0.0F) ? 180.0F : -180.0F;
/*     */               }
/*     */             } 
/*     */           } 
/*     */           
/*  68 */           ac.setRotYaw(req.yaw);
/*  69 */           ac.setRotPitch(req.pitch);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacketOnMountEntity(EntityPlayer player, ByteArrayDataInput data) {
/*  77 */     if (player != null && player.field_70170_p.field_72995_K) {
/*  78 */       MCH_PacketNotifyOnMountEntity req = new MCH_PacketNotifyOnMountEntity();
/*  79 */       req.readData(data);
/*  80 */       MCH_Lib.DbgLog(player.field_70170_p, "onPacketOnMountEntity.rcv:%d, %d, %d, %d", new Object[] { Integer.valueOf(W_Entity.getEntityId((Entity)player)), Integer.valueOf(req.entityID_Ac), Integer.valueOf(req.entityID_rider), Integer.valueOf(req.seatID) });
/*  81 */       if (req.entityID_Ac > 0 && 
/*  82 */         req.entityID_rider > 0 && 
/*  83 */         req.seatID >= 0) {
/*  84 */         Entity e = player.field_70170_p.func_73045_a(req.entityID_Ac);
/*  85 */         if (e instanceof MCH_EntityAircraft) {
/*  86 */           MCH_Lib.DbgLog(player.field_70170_p, "onPacketOnMountEntity:" + W_Entity.getEntityId((Entity)player), new Object[0]);
/*  87 */           player.field_70170_p.func_73045_a(req.entityID_rider);
/*  88 */           MCH_EntityAircraft mCH_EntityAircraft = (MCH_EntityAircraft)e;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public static void onPacketNotifyAmmoNum(EntityPlayer player, ByteArrayDataInput data) {
/*  98 */     if (player != null && player.field_70170_p.field_72995_K) {
/*  99 */       MCH_PacketNotifyAmmoNum status = new MCH_PacketNotifyAmmoNum();
/* 100 */       status.readData(data);
/* 101 */       if (status.entityID_Ac > 0) {
/* 102 */         Entity e = player.field_70170_p.func_73045_a(status.entityID_Ac);
/* 103 */         if (e instanceof MCH_EntityAircraft) {
/* 104 */           MCH_EntityAircraft ac = (MCH_EntityAircraft)e;
/* 105 */           String msg = "onPacketNotifyAmmoNum:";
/* 106 */           msg = msg + ((ac.getAcInfo() != null) ? (ac.getAcInfo()).displayName : "null") + ":";
/* 107 */           if (status.all) {
/* 108 */             msg = msg + "All=true, Num=" + status.num;
/*     */             
/* 110 */             for (int i = 0; i < ac.getWeaponNum() && i < status.num; i++) {
/* 111 */               ac.getWeapon(i).setAmmoNum(status.ammo[i]);
/* 112 */               ac.getWeapon(i).setRestAllAmmoNum(status.restAmmo[i]);
/* 113 */               msg = msg + ", [" + status.ammo[i] + "/" + status.restAmmo[i] + "]";
/*     */             } 
/*     */             
/* 116 */             MCH_Lib.DbgLog(e.field_70170_p, msg, new Object[0]);
/* 117 */           } else if (status.weaponID < ac.getWeaponNum()) {
/* 118 */             msg = msg + "All=false, WeaponID=" + status.weaponID + ", " + status.ammo[0] + ", " + status.restAmmo[0];
/* 119 */             ac.getWeapon(status.weaponID).setAmmoNum(status.ammo[0]);
/* 120 */             ac.getWeapon(status.weaponID).setRestAllAmmoNum(status.restAmmo[0]);
/* 121 */             MCH_Lib.DbgLog(e.field_70170_p, msg, new Object[0]);
/*     */           } else {
/* 123 */             MCH_Lib.DbgLog(e.field_70170_p, "Error:" + status.weaponID, new Object[0]);
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacketStatusRequest(EntityPlayer player, ByteArrayDataInput data) {
/* 132 */     if (!player.field_70170_p.field_72995_K) {
/* 133 */       MCH_PacketStatusRequest req = new MCH_PacketStatusRequest();
/* 134 */       req.readData(data);
/* 135 */       if (req.entityID_AC > 0) {
/* 136 */         Entity e = player.field_70170_p.func_73045_a(req.entityID_AC);
/* 137 */         if (e instanceof MCH_EntityAircraft) {
/* 138 */           MCH_PacketStatusResponse.sendStatus((MCH_EntityAircraft)e, player);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacketIndNotifyAmmoNum(EntityPlayer player, ByteArrayDataInput data) {
/* 146 */     if (!player.field_70170_p.field_72995_K) {
/* 147 */       MCH_PacketIndNotifyAmmoNum req = new MCH_PacketIndNotifyAmmoNum();
/* 148 */       req.readData(data);
/* 149 */       if (req.entityID_Ac > 0) {
/* 150 */         Entity e = player.field_70170_p.func_73045_a(req.entityID_Ac);
/* 151 */         if (e instanceof MCH_EntityAircraft) {
/* 152 */           if (req.weaponID >= 0) {
/* 153 */             MCH_PacketNotifyAmmoNum.sendAmmoNum((MCH_EntityAircraft)e, player, req.weaponID);
/*     */           } else {
/* 155 */             MCH_PacketNotifyAmmoNum.sendAllAmmoNum((MCH_EntityAircraft)e, player);
/*     */           } 
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacketIndReload(EntityPlayer player, ByteArrayDataInput data) {
/* 164 */     if (!player.field_70170_p.field_72995_K) {
/* 165 */       MCH_PacketIndReload ind = new MCH_PacketIndReload();
/* 166 */       ind.readData(data);
/* 167 */       if (ind.entityID_Ac > 0) {
/* 168 */         Entity e = player.field_70170_p.func_73045_a(ind.entityID_Ac);
/* 169 */         if (e instanceof MCH_EntityAircraft) {
/* 170 */           MCH_EntityAircraft ac = (MCH_EntityAircraft)e;
/* 171 */           MCH_Lib.DbgLog(e.field_70170_p, "onPacketIndReload :%s", new Object[] { (ac.getAcInfo()).displayName });
/* 172 */           ac.supplyAmmo(ind.weaponID);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacketStatusResponse(EntityPlayer player, ByteArrayDataInput data) {
/* 180 */     if (player.field_70170_p.field_72995_K) {
/* 181 */       MCH_PacketStatusResponse status = new MCH_PacketStatusResponse();
/* 182 */       status.readData(data);
/* 183 */       String msg = "onPacketStatusResponse:";
/* 184 */       if (status.entityID_AC > 0) {
/* 185 */         msg = msg + "EID=" + status.entityID_AC + ":";
/* 186 */         Entity e = player.field_70170_p.func_73045_a(status.entityID_AC);
/* 187 */         if (e instanceof MCH_EntityAircraft) {
/* 188 */           MCH_EntityAircraft ac = (MCH_EntityAircraft)e;
/* 189 */           if (status.seatNum > 0 && status.weaponIDs != null && status.weaponIDs.length == status.seatNum) {
/* 190 */             msg = msg + "seatNum=" + status.seatNum + ":";
/*     */             
/* 192 */             for (int i = 0; i < status.seatNum; i++) {
/* 193 */               ac.updateWeaponID(i, status.weaponIDs[i]);
/* 194 */               msg = msg + "[" + i + "," + status.weaponIDs[i] + "]";
/*     */             } 
/*     */           } else {
/* 197 */             msg = msg + "Error seatNum=" + status.seatNum;
/*     */           } 
/*     */         } 
/*     */         
/* 201 */         MCH_Lib.DbgLog(true, msg, new Object[0]);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void onPacketNotifyWeaponID(EntityPlayer player, ByteArrayDataInput data) {
/* 207 */     if (player.field_70170_p.field_72995_K) {
/* 208 */       MCH_PacketNotifyWeaponID status = new MCH_PacketNotifyWeaponID();
/* 209 */       status.readData(data);
/* 210 */       if (status.entityID_Ac > 0) {
/* 211 */         Entity e = player.field_70170_p.func_73045_a(status.entityID_Ac);
/* 212 */         if (e instanceof MCH_EntityAircraft) {
/* 213 */           MCH_EntityAircraft ac = (MCH_EntityAircraft)e;
/* 214 */           if (ac.isValidSeatID(status.seatID)) {
/* 215 */             ac.getWeapon(status.weaponID).setAmmoNum(status.ammo);
/* 216 */             ac.getWeapon(status.weaponID).setRestAllAmmoNum(status.restAmmo);
/* 217 */             MCH_Lib.DbgLog(true, "onPacketNotifyWeaponID:WeaponID=%d (%d / %d)", new Object[] { Integer.valueOf(status.weaponID), Short.valueOf(status.ammo), Short.valueOf(status.restAmmo) });
/* 218 */             if (W_Lib.isClientPlayer(ac.getEntityBySeatId(status.seatID))) {
/* 219 */               MCH_Lib.DbgLog(true, "onPacketNotifyWeaponID:#discard:SeatID=%d, WeaponID=%d", new Object[] { Integer.valueOf(status.seatID), Integer.valueOf(status.weaponID) });
/*     */             } else {
/* 221 */               MCH_Lib.DbgLog(true, "onPacketNotifyWeaponID:SeatID=%d, WeaponID=%d", new Object[] { Integer.valueOf(status.seatID), Integer.valueOf(status.weaponID) });
/* 222 */               ac.updateWeaponID(status.seatID, status.weaponID);
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacketNotifyHitBullet(EntityPlayer player, ByteArrayDataInput data) {
/* 232 */     if (player.field_70170_p.field_72995_K) {
/* 233 */       MCH_PacketNotifyHitBullet status = new MCH_PacketNotifyHitBullet();
/* 234 */       status.readData(data);
/* 235 */       if (status.entityID_Ac <= 0) {
/* 236 */         MCH_MOD.proxy.hitBullet();
/*     */       } else {
/* 238 */         Entity e = player.field_70170_p.func_73045_a(status.entityID_Ac);
/* 239 */         if (e instanceof MCH_EntityAircraft) {
/* 240 */           ((MCH_EntityAircraft)e).hitBullet();
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacketSeatListRequest(EntityPlayer player, ByteArrayDataInput data) {
/* 248 */     if (!player.field_70170_p.field_72995_K) {
/* 249 */       MCH_PacketSeatListRequest req = new MCH_PacketSeatListRequest();
/* 250 */       req.readData(data);
/* 251 */       if (req.entityID_AC > 0) {
/* 252 */         Entity e = player.field_70170_p.func_73045_a(req.entityID_AC);
/* 253 */         if (e instanceof MCH_EntityAircraft) {
/* 254 */           MCH_PacketSeatListResponse.sendSeatList((MCH_EntityAircraft)e, player);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacketNotifyTVMissileEntity(EntityPlayer player, ByteArrayDataInput data) {
/* 262 */     if (player.field_70170_p.field_72995_K) {
/* 263 */       MCH_PacketNotifyTVMissileEntity packet = new MCH_PacketNotifyTVMissileEntity();
/* 264 */       packet.readData(data);
/* 265 */       if (packet.entityID_Ac <= 0) {
/*     */         return;
/*     */       }
/*     */       
/* 269 */       if (packet.entityID_TVMissile <= 0) {
/*     */         return;
/*     */       }
/*     */       
/* 273 */       Entity e = player.field_70170_p.func_73045_a(packet.entityID_Ac);
/* 274 */       if (e == null || !(e instanceof MCH_EntityAircraft)) {
/*     */         return;
/*     */       }
/*     */       
/* 278 */       MCH_EntityAircraft ac = (MCH_EntityAircraft)e;
/* 279 */       e = player.field_70170_p.func_73045_a(packet.entityID_TVMissile);
/* 280 */       if (e == null || !(e instanceof MCH_EntityTvMissile)) {
/*     */         return;
/*     */       }
/*     */       
/* 284 */       ((MCH_EntityTvMissile)e).shootingEntity = (Entity)player;
/* 285 */       ac.setTVMissile((MCH_EntityTvMissile)e);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacketSeatListResponse(EntityPlayer player, ByteArrayDataInput data) {
/* 291 */     if (player.field_70170_p.field_72995_K) {
/* 292 */       MCH_PacketSeatListResponse seatList = new MCH_PacketSeatListResponse();
/* 293 */       seatList.readData(data);
/* 294 */       if (seatList.entityID_AC > 0) {
/* 295 */         Entity e = player.field_70170_p.func_73045_a(seatList.entityID_AC);
/* 296 */         if (e instanceof MCH_EntityAircraft) {
/* 297 */           MCH_EntityAircraft ac = (MCH_EntityAircraft)e;
/* 298 */           if (seatList.seatNum > 0 && seatList.seatNum == (ac.getSeats()).length && seatList.seatEntityID != null && seatList.seatEntityID.length == seatList.seatNum) {
/* 299 */             for (int i = 0; i < seatList.seatNum; i++) {
/* 300 */               Entity entity = player.field_70170_p.func_73045_a(seatList.seatEntityID[i]);
/* 301 */               if (entity instanceof MCH_EntitySeat) {
/* 302 */                 MCH_EntitySeat seat = (MCH_EntitySeat)entity;
/* 303 */                 seat.seatID = i;
/* 304 */                 seat.setParent(ac);
/* 305 */                 seat.parentUniqueID = ac.getCommonUniqueId();
/* 306 */                 ac.setSeat(i, seat);
/*     */               } 
/*     */             } 
/*     */           }
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacket_PlayerControl(EntityPlayer player, ByteArrayDataInput data) {
/* 317 */     if (!player.field_70170_p.field_72995_K) {
/* 318 */       MCH_EntityAircraft ac = null;
/* 319 */       if (player.field_70154_o instanceof MCH_EntitySeat) {
/* 320 */         MCH_EntitySeat pc = (MCH_EntitySeat)player.field_70154_o;
/* 321 */         ac = pc.getParent();
/*     */       } else {
/* 323 */         ac = MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)player);
/*     */       } 
/*     */       
/* 326 */       if (ac != null) {
/* 327 */         MCH_PacketSeatPlayerControl pc1 = new MCH_PacketSeatPlayerControl();
/* 328 */         pc1.readData(data);
/* 329 */         if (pc1.isUnmount) {
/* 330 */           ac.unmountEntityFromSeat((Entity)player);
/* 331 */         } else if (pc1.switchSeat > 0) {
/* 332 */           if (pc1.switchSeat == 3) {
/* 333 */             player.func_70078_a((Entity)null);
/* 334 */             ac.keepOnRideRotation = true;
/* 335 */             ac.interactFirst(player, true);
/*     */           } 
/*     */           
/* 338 */           if (pc1.switchSeat == 1) {
/* 339 */             ac.switchNextSeat((Entity)player);
/*     */           }
/*     */           
/* 342 */           if (pc1.switchSeat == 2) {
/* 343 */             ac.switchPrevSeat((Entity)player);
/*     */           }
/* 345 */         } else if (pc1.parachuting) {
/* 346 */           ac.unmount((Entity)player);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacket_ClientSetting(EntityPlayer player, ByteArrayDataInput data) {
/* 354 */     if (!player.field_70170_p.field_72995_K) {
/* 355 */       MCH_PacketNotifyClientSetting pc = new MCH_PacketNotifyClientSetting();
/* 356 */       pc.readData(data);
/* 357 */       MCH_EntityAircraft ac = MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)player);
/* 358 */       if (ac != null) {
/* 359 */         int sid = ac.getSeatIdByEntity((Entity)player);
/* 360 */         if (sid == 0) {
/* 361 */           ac.cs_dismountAll = pc.dismountAll;
/* 362 */           ac.cs_heliAutoThrottleDown = pc.heliAutoThrottleDown;
/* 363 */           ac.cs_planeAutoThrottleDown = pc.planeAutoThrottleDown;
/* 364 */           ac.cs_tankAutoThrottleDown = pc.tankAutoThrottleDown;
/*     */         } 
/*     */         
/* 367 */         ac.camera.setShaderSupport(sid, Boolean.valueOf(pc.shaderSupport));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void onPacketNotifyInfoReloaded(EntityPlayer player, ByteArrayDataInput data) {
/* 374 */     if (!player.field_70170_p.field_72995_K) {
/* 375 */       MCH_EntityAircraft ac; int i$; WorldServer[] arr$; int len$; MCH_PacketNotifyInfoReloaded pc = new MCH_PacketNotifyInfoReloaded();
/* 376 */       pc.readData(data);
/*     */ 
/*     */       
/* 379 */       switch (pc.type) {
/*     */         case 0:
/* 381 */           ac = MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)player);
/* 382 */           if (ac != null && ac.getAcInfo() != null) {
/* 383 */             String var11 = (ac.getAcInfo()).name;
/* 384 */             WorldServer[] var12 = (MinecraftServer.func_71276_C()).field_71305_c;
/* 385 */             int i = var12.length;
/*     */             
/* 387 */             for (int var13 = 0; var13 < i; var13++) {
/* 388 */               WorldServer var14 = var12[var13];
/* 389 */               List<MCH_EntityAircraft> var15 = var14.field_72996_f;
/*     */               
/* 391 */               for (int i1 = 0; i1 < var15.size(); i1++) {
/* 392 */                 if (var15.get(i1) instanceof MCH_EntityAircraft) {
/* 393 */                   ac = var15.get(i1);
/* 394 */                   if (ac.getAcInfo() != null && (ac.getAcInfo()).name.equals(var11)) {
/* 395 */                     ac.changeType(var11);
/* 396 */                     ac.createSeats(UUID.randomUUID().toString());
/* 397 */                     ac.onAcInfoReloaded();
/*     */                   } 
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           break;
/*     */         case 1:
/* 405 */           MCH_WeaponInfoManager.reload();
/* 406 */           arr$ = (MinecraftServer.func_71276_C()).field_71305_c;
/* 407 */           len$ = arr$.length;
/*     */           
/* 409 */           for (i$ = 0; i$ < len$; i$++) {
/* 410 */             WorldServer world = arr$[i$];
/* 411 */             List<MCH_EntityAircraft> list = world.field_72996_f;
/*     */             
/* 413 */             for (int i = 0; i < list.size(); i++) {
/* 414 */               if (list.get(i) instanceof MCH_EntityAircraft) {
/* 415 */                 ac = list.get(i);
/* 416 */                 if (ac.getAcInfo() != null) {
/* 417 */                   ac.changeType((ac.getAcInfo()).name);
/* 418 */                   ac.createSeats(UUID.randomUUID().toString());
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_AircraftPacketHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */