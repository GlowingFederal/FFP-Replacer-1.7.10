/*     */ package mcheli;
/*     */ import cpw.mods.fml.client.registry.ClientRegistry;
/*     */ import cpw.mods.fml.client.registry.RenderingRegistry;
/*     */ import java.util.Iterator;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_EntityHide;
/*     */ import mcheli.aircraft.MCH_RenderAircraft;
/*     */ import mcheli.aircraft.MCH_SoundUpdater;
/*     */ import mcheli.container.MCH_EntityContainer;
/*     */ import mcheli.debug.MCH_RenderTest;
/*     */ import mcheli.gltd.MCH_ItemGLTDRender;
/*     */ import mcheli.gltd.MCH_RenderGLTD;
/*     */ import mcheli.helicopter.MCH_HeliInfo;
/*     */ import mcheli.helicopter.MCH_HeliInfoManager;
/*     */ import mcheli.helicopter.MCH_RenderHeli;
/*     */ import mcheli.hud.MCH_HudManager;
/*     */ import mcheli.lweapon.MCH_ItemLightWeaponRender;
/*     */ import mcheli.mob.MCH_EntityGunner;
/*     */ import mcheli.mob.MCH_RenderGunner;
/*     */ import mcheli.parachute.MCH_RenderParachute;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.plane.MCP_PlaneInfo;
/*     */ import mcheli.plane.MCP_PlaneInfoManager;
/*     */ import mcheli.tank.MCH_RenderTank;
/*     */ import mcheli.tank.MCH_TankInfo;
/*     */ import mcheli.tank.MCH_TankInfoManager;
/*     */ import mcheli.throwable.MCH_EntityThrowable;
/*     */ import mcheli.throwable.MCH_ThrowableInfo;
/*     */ import mcheli.uav.MCH_RenderUavStation;
/*     */ import mcheli.vehicle.MCH_EntityVehicle;
/*     */ import mcheli.vehicle.MCH_VehicleInfo;
/*     */ import mcheli.vehicle.MCH_VehicleInfoManager;
/*     */ import mcheli.weapon.MCH_BulletModel;
/*     */ import mcheli.weapon.MCH_DefaultBulletModels;
/*     */ import mcheli.weapon.MCH_EntityA10;
/*     */ import mcheli.weapon.MCH_EntityASMissile;
/*     */ import mcheli.weapon.MCH_EntityGPSMissile;
/*     */ import mcheli.weapon.MCH_EntityLaserMissile;
/*     */ import mcheli.weapon.MCH_EntityTorpedo;
/*     */ import mcheli.weapon.MCH_EntityTvMissile;
/*     */ import mcheli.weapon.MCH_RenderBomb;
/*     */ import mcheli.weapon.MCH_RenderBullet;
/*     */ import mcheli.weapon.MCH_RenderGPSMissile;
/*     */ import mcheli.weapon.MCH_RenderNone;
/*     */ import mcheli.weapon.MCH_RenderTvMissile;
/*     */ import mcheli.weapon.MCH_WeaponInfo;
/*     */ import mcheli.weapon.MCH_WeaponInfoManager;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_MinecraftForgeClient;
/*     */ import mcheli.wrapper.W_Reflection;
/*     */ import mcheli.wrapper.modelloader.W_ModelCustom;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityPlayerSP;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ import net.minecraftforge.client.IItemRenderer;
/*     */ import net.minecraftforge.client.model.IModelCustom;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ public class MCH_ClientProxy extends MCH_CommonProxy {
/*  65 */   public String lastLoadHUDPath = "";
/*     */ 
/*     */   
/*     */   public String getDataDir() {
/*  69 */     return (Minecraft.func_71410_x()).field_71412_D.getPath();
/*     */   }
/*     */   
/*     */   public void registerRenderer() {
/*  73 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntitySeat.class, (Render)new MCH_RenderTest(0.0F, 0.0F, 0.0F, "seat"));
/*  74 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityHeli.class, (Render)new MCH_RenderHeli());
/*  75 */     RenderingRegistry.registerEntityRenderingHandler(MCP_EntityPlane.class, (Render)new MCP_RenderPlane());
/*  76 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityTank.class, (Render)new MCH_RenderTank());
/*  77 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityGLTD.class, (Render)new MCH_RenderGLTD());
/*  78 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityParachute.class, (Render)new MCH_RenderParachute());
/*  79 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityContainer.class, (Render)new MCH_RenderContainer());
/*  80 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityVehicle.class, (Render)new MCH_RenderVehicle());
/*  81 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityUavStation.class, (Render)new MCH_RenderUavStation());
/*  82 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityCartridge.class, (Render)new MCH_RenderCartridge());
/*  83 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityHide.class, (Render)new MCH_RenderNull());
/*  84 */     RenderingRegistry.registerEntityRenderingHandler(MCH_ViewEntityDummy.class, (Render)new MCH_RenderNull());
/*  85 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityRocket.class, (Render)new MCH_RenderBullet());
/*  86 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityTvMissile.class, (Render)new MCH_RenderTvMissile());
/*  87 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityBullet.class, (Render)new MCH_RenderBullet());
/*  88 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityA10.class, (Render)new MCH_RenderA10());
/*  89 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityAAMissile.class, (Render)new MCH_RenderAAMissile());
/*  90 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityASMissile.class, (Render)new MCH_RenderASMissile());
/*  91 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityGPSMissile.class, (Render)new MCH_RenderGPSMissile());
/*  92 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityATMissile.class, (Render)new MCH_RenderTvMissile());
/*  93 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityLaserMissile.class, (Render)new MCH_RenderLaserMissile());
/*  94 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityTorpedo.class, (Render)new MCH_RenderBullet());
/*  95 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityBomb.class, (Render)new MCH_RenderBomb());
/*  96 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityMarkerRocket.class, (Render)new MCH_RenderBullet());
/*  97 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityDispensedItem.class, (Render)new MCH_RenderNone());
/*  98 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityFlare.class, (Render)new MCH_RenderFlare());
/*  99 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityThrowable.class, (Render)new MCH_RenderThrowable());
/* 100 */     RenderingRegistry.registerEntityRenderingHandler(MCH_EntityGunner.class, (Render)new MCH_RenderGunner());
/*     */     
/* 102 */     W_MinecraftForgeClient.registerItemRenderer((Item)MCH_MOD.itemJavelin, (IItemRenderer)new MCH_ItemLightWeaponRender());
/* 103 */     W_MinecraftForgeClient.registerItemRenderer((Item)MCH_MOD.itemStinger, (IItemRenderer)new MCH_ItemLightWeaponRender());
/* 104 */     W_MinecraftForgeClient.registerItemRenderer((Item)MCH_MOD.invisibleItem, new MCH_InvisibleItemRender());
/* 105 */     W_MinecraftForgeClient.registerItemRenderer((Item)MCH_MOD.itemGLTD, (IItemRenderer)new MCH_ItemGLTDRender());
/* 106 */     W_MinecraftForgeClient.registerItemRenderer((Item)MCH_MOD.itemWrench, (IItemRenderer)new MCH_ItemRenderWrench());
/* 107 */     W_MinecraftForgeClient.registerItemRenderer((Item)MCH_MOD.itemRangeFinder, (IItemRenderer)new MCH_ItemRenderRangeFinder());
/*     */   }
/*     */   
/*     */   public void registerBlockRenderer() {
/* 111 */     ClientRegistry.bindTileEntitySpecialRenderer(MCH_DraftingTableTileEntity.class, (TileEntitySpecialRenderer)new MCH_DraftingTableRenderer());
/* 112 */     W_MinecraftForgeClient.registerItemRenderer(W_Item.getItemFromBlock((Block)MCH_MOD.blockDraftingTable), (IItemRenderer)new MCH_DraftingTableItemRender());
/*     */   }
/*     */   
/*     */   public void registerModels() {
/* 116 */     MCH_ModelManager.setForceReloadMode(true);
/* 117 */     MCH_RenderAircraft.debugModel = MCH_ModelManager.load("box");
/* 118 */     MCH_ModelManager.load("a-10");
/* 119 */     MCH_RenderGLTD.model = MCH_ModelManager.load("gltd");
/* 120 */     MCH_ModelManager.load("chain");
/* 121 */     MCH_ModelManager.load("container");
/* 122 */     MCH_ModelManager.load("parachute1");
/* 123 */     MCH_ModelManager.load("parachute2");
/* 124 */     MCH_ModelManager.load("lweapons", "fim92");
/* 125 */     MCH_ModelManager.load("lweapons", "fgm148");
/* 126 */     String[] i$ = MCH_RenderUavStation.MODEL_NAME;
/* 127 */     int wi = i$.length;
/*     */     
/* 129 */     for (int i$1 = 0; i$1 < wi; i$1++) {
/* 130 */       String s = i$[i$1];
/* 131 */       MCH_ModelManager.load(s);
/*     */     } 
/*     */     
/* 134 */     MCH_ModelManager.load("wrench");
/* 135 */     MCH_ModelManager.load("rangefinder");
/* 136 */     MCH_HeliInfoManager.getInstance();
/* 137 */     Iterator<String> var5 = MCH_HeliInfoManager.map.keySet().iterator();
/*     */ 
/*     */     
/* 140 */     while (var5.hasNext()) {
/* 141 */       String var6 = var5.next();
/* 142 */       registerModelsHeli(var6, false);
/*     */     } 
/*     */     
/* 145 */     var5 = MCP_PlaneInfoManager.map.keySet().iterator();
/*     */     
/* 147 */     while (var5.hasNext()) {
/* 148 */       String var6 = var5.next();
/* 149 */       registerModelsPlane(var6, false);
/*     */     } 
/*     */     
/* 152 */     MCH_TankInfoManager.getInstance();
/* 153 */     var5 = MCH_TankInfoManager.map.keySet().iterator();
/*     */     
/* 155 */     while (var5.hasNext()) {
/* 156 */       String var6 = var5.next();
/* 157 */       registerModelsTank(var6, false);
/*     */     } 
/*     */     
/* 160 */     var5 = MCH_VehicleInfoManager.map.keySet().iterator();
/*     */     
/* 162 */     while (var5.hasNext()) {
/* 163 */       String var6 = var5.next();
/* 164 */       registerModelsVehicle(var6, false);
/*     */     } 
/*     */     
/* 167 */     registerModels_Bullet();
/* 168 */     MCH_DefaultBulletModels.Bullet = loadBulletModel("bullet");
/* 169 */     MCH_DefaultBulletModels.AAMissile = loadBulletModel("aamissile");
/* 170 */     MCH_DefaultBulletModels.ATMissile = loadBulletModel("asmissile");
/* 171 */     MCH_DefaultBulletModels.ASMissile = loadBulletModel("asmissile");
/* 172 */     MCH_DefaultBulletModels.Bomb = loadBulletModel("bomb");
/* 173 */     MCH_DefaultBulletModels.Rocket = loadBulletModel("rocket");
/* 174 */     MCH_DefaultBulletModels.Torpedo = loadBulletModel("torpedo");
/* 175 */     MCH_DefaultBulletModels.GPSMissile = loadBulletModel("asmissile");
/*     */ 
/*     */     
/* 178 */     for (var5 = MCH_ThrowableInfoManager.getValues().iterator(); var5.hasNext(); var7.model = MCH_ModelManager.load("throwable", var7.name)) {
/* 179 */       MCH_ThrowableInfo var7 = (MCH_ThrowableInfo)var5.next();
/*     */     }
/*     */     
/* 182 */     MCH_ModelManager.load("blocks", "drafting_table");
/*     */   }
/*     */   
/*     */   public static void registerModels_Bullet() {
/* 186 */     Iterator<MCH_WeaponInfo> i$ = MCH_WeaponInfoManager.getValues().iterator();
/*     */     
/* 188 */     while (i$.hasNext()) {
/* 189 */       MCH_WeaponInfo wi = i$.next();
/* 190 */       IModelCustom m = null;
/* 191 */       if (!wi.bulletModelName.isEmpty()) {
/* 192 */         m = MCH_ModelManager.load("bullets", wi.bulletModelName);
/* 193 */         if (m != null) {
/* 194 */           wi.bulletModel = new MCH_BulletModel(wi.bulletModelName, m);
/*     */         }
/*     */       } 
/*     */       
/* 198 */       if (!wi.bombletModelName.isEmpty()) {
/* 199 */         m = MCH_ModelManager.load("bullets", wi.bombletModelName);
/* 200 */         if (m != null) {
/* 201 */           wi.bombletModel = new MCH_BulletModel(wi.bombletModelName, m);
/*     */         }
/*     */       } 
/*     */       
/* 205 */       if (wi.cartridge != null && !wi.cartridge.name.isEmpty()) {
/* 206 */         wi.cartridge.model = MCH_ModelManager.load("bullets", wi.cartridge.name);
/* 207 */         if (wi.cartridge.model == null) {
/* 208 */           wi.cartridge = null;
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerModelsHeli(String name, boolean reload) {
/* 216 */     MCH_ModelManager.setForceReloadMode(reload);
/* 217 */     MCH_HeliInfo info = (MCH_HeliInfo)MCH_HeliInfoManager.map.get(name);
/* 218 */     info.model = MCH_ModelManager.load("helicopters", info.name);
/*     */ 
/*     */     
/* 221 */     for (MCH_HeliInfo.Rotor rotor : info.rotorList) rotor.model = loadPartModel("helicopters", info.name, info.model, rotor.modelName);
/*     */ 
/*     */ 
/*     */     
/* 225 */     registerCommonPart("helicopters", (MCH_AircraftInfo)info);
/* 226 */     MCH_ModelManager.setForceReloadMode(false);
/*     */   }
/*     */   
/*     */   public void registerModelsPlane(String name, boolean reload) {
/* 230 */     MCH_ModelManager.setForceReloadMode(reload);
/* 231 */     MCP_PlaneInfo info = (MCP_PlaneInfo)MCP_PlaneInfoManager.map.get(name);
/* 232 */     info.model = MCH_ModelManager.load("planes", info.name);
/*     */ 
/*     */ 
/*     */     
/* 236 */     for (MCH_AircraftInfo.DrawnPart w : info.nozzles) w.model = loadPartModel("planes", info.name, info.model, w.modelName);
/*     */ 
/*     */ 
/*     */     
/* 240 */     Iterator<MCP_PlaneInfo.Rotor> iterator = info.rotorList.iterator();
/*     */ 
/*     */     
/* 243 */     while (iterator.hasNext()) {
/* 244 */       MCP_PlaneInfo.Rotor w1 = iterator.next();
/* 245 */       w1.model = loadPartModel("planes", info.name, info.model, w1.modelName);
/*     */ 
/*     */       
/* 248 */       for (MCP_PlaneInfo.Blade p : w1.blades) p.model = loadPartModel("planes", info.name, info.model, p.modelName);
/*     */     
/*     */     } 
/*     */ 
/*     */     
/* 253 */     iterator = info.wingList.iterator();
/*     */     
/* 255 */     while (iterator.hasNext()) {
/* 256 */       MCP_PlaneInfo.Wing w2 = (MCP_PlaneInfo.Wing)iterator.next();
/* 257 */       w2.model = loadPartModel("planes", info.name, info.model, w2.modelName);
/*     */       
/* 259 */       if (w2.pylonList != null) {
/* 260 */         for (MCP_PlaneInfo.Pylon p1 : w2.pylonList) p1.model = loadPartModel("planes", info.name, info.model, p1.modelName);
/*     */       
/*     */       }
/*     */     } 
/*     */ 
/*     */     
/* 266 */     registerCommonPart("planes", (MCH_AircraftInfo)info);
/* 267 */     MCH_ModelManager.setForceReloadMode(false);
/*     */   }
/*     */   
/*     */   public void registerModelsVehicle(String name, boolean reload) {
/* 271 */     MCH_ModelManager.setForceReloadMode(reload);
/* 272 */     MCH_VehicleInfo info = (MCH_VehicleInfo)MCH_VehicleInfoManager.map.get(name);
/* 273 */     info.model = MCH_ModelManager.load("vehicles", info.name);
/* 274 */     Iterator<MCH_VehicleInfo.VPart> i$ = info.partList.iterator();
/*     */     
/* 276 */     while (i$.hasNext()) {
/* 277 */       MCH_VehicleInfo.VPart vp = i$.next();
/* 278 */       vp.model = loadPartModel("vehicles", info.name, info.model, vp.modelName);
/* 279 */       if (vp.child != null) {
/* 280 */         registerVCPModels(info, vp);
/*     */       }
/*     */     } 
/*     */     
/* 284 */     registerCommonPart("vehicles", (MCH_AircraftInfo)info);
/* 285 */     MCH_ModelManager.setForceReloadMode(false);
/*     */   }
/*     */   
/*     */   public void registerModelsTank(String name, boolean reload) {
/* 289 */     MCH_ModelManager.setForceReloadMode(reload);
/* 290 */     MCH_TankInfo info = (MCH_TankInfo)MCH_TankInfoManager.map.get(name);
/* 291 */     info.model = MCH_ModelManager.load("tanks", info.name);
/* 292 */     registerCommonPart("tanks", (MCH_AircraftInfo)info);
/* 293 */     MCH_ModelManager.setForceReloadMode(false);
/*     */   }
/*     */   
/*     */   private MCH_BulletModel loadBulletModel(String name) {
/* 297 */     IModelCustom m = MCH_ModelManager.load("bullets", name);
/* 298 */     return (m != null) ? new MCH_BulletModel(name, m) : null;
/*     */   }
/*     */   
/*     */   private IModelCustom loadPartModel(String path, String name, IModelCustom body, String part) {
/* 302 */     return (body instanceof W_ModelCustom && ((W_ModelCustom)body).containsPart("$" + part)) ? null : MCH_ModelManager.load(path, name + "_" + part);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void registerCommonPart(String path, MCH_AircraftInfo info) {
/* 308 */     for (MCH_AircraftInfo.Hatch c : info.hatchList) c.model = loadPartModel(path, info.name, info.model, c.modelName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 313 */     for (MCH_AircraftInfo.Camera c1 : info.cameraList) c1.model = loadPartModel(path, info.name, info.model, c1.modelName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 318 */     for (MCH_AircraftInfo.Throttle c2 : info.partThrottle) c2.model = loadPartModel(path, info.name, info.model, c2.modelName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 323 */     for (MCH_AircraftInfo.RotPart c3 : info.partRotPart) c3.model = loadPartModel(path, info.name, info.model, c3.modelName);
/*     */ 
/*     */ 
/*     */     
/* 327 */     null = info.partWeapon.iterator();
/*     */     
/* 329 */     while (null.hasNext()) {
/* 330 */       MCH_AircraftInfo.PartWeapon c4 = null.next();
/* 331 */       c4.model = loadPartModel(path, info.name, info.model, c4.modelName);
/*     */ 
/*     */       
/* 334 */       for (MCH_AircraftInfo.PartWeaponChild wc : c4.child) wc.model = loadPartModel(path, info.name, info.model, wc.modelName);
/*     */     
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 340 */     for (MCH_AircraftInfo.Canopy c5 : info.canopyList) c5.model = loadPartModel(path, info.name, info.model, c5.modelName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 345 */     for (MCH_AircraftInfo.LandingGear c6 : info.landingGear) c6.model = loadPartModel(path, info.name, info.model, c6.modelName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 350 */     for (MCH_AircraftInfo.WeaponBay c7 : info.partWeaponBay) c7.model = loadPartModel(path, info.name, info.model, c7.modelName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 355 */     for (MCH_AircraftInfo.CrawlerTrack c8 : info.partCrawlerTrack) c8.model = loadPartModel(path, info.name, info.model, c8.modelName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 360 */     for (MCH_AircraftInfo.TrackRoller c9 : info.partTrackRoller) c9.model = loadPartModel(path, info.name, info.model, c9.modelName);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 365 */     for (MCH_AircraftInfo.PartWheel c10 : info.partWheel) c10.model = loadPartModel(path, info.name, info.model, c10.modelName);
/*     */ 
/*     */ 
/*     */     
/* 369 */     for (MCH_AircraftInfo.PartWheel c10 : info.partSteeringWheel) c10.model = loadPartModel(path, info.name, info.model, c10.modelName);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   private void registerVCPModels(MCH_VehicleInfo info, MCH_VehicleInfo.VPart vp) {
/* 376 */     Iterator<MCH_VehicleInfo.VPart> i$ = vp.child.iterator();
/*     */     
/* 378 */     while (i$.hasNext()) {
/* 379 */       MCH_VehicleInfo.VPart vcp = i$.next();
/* 380 */       vcp.model = loadPartModel("vehicles", info.name, info.model, vcp.modelName);
/* 381 */       if (vcp.child != null) {
/* 382 */         registerVCPModels(info, vcp);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerClientTick() {
/* 389 */     Minecraft mc = Minecraft.func_71410_x();
/* 390 */     MCH_ClientCommonTickHandler.instance = new MCH_ClientCommonTickHandler(mc, MCH_MOD.config);
/* 391 */     W_TickRegistry.registerTickHandler(MCH_ClientCommonTickHandler.instance, Side.CLIENT);
/*     */   }
/*     */   
/*     */   public boolean isRemote() {
/* 395 */     return true;
/*     */   }
/*     */   
/*     */   public String side() {
/* 399 */     return "Client";
/*     */   }
/*     */   
/*     */   public MCH_SoundUpdater CreateSoundUpdater(MCH_EntityAircraft aircraft) {
/* 403 */     return (aircraft != null && aircraft.field_70170_p.field_72995_K) ? new MCH_SoundUpdater(Minecraft.func_71410_x(), aircraft, (EntityPlayerSP)(Minecraft.func_71410_x()).field_71439_g) : null;
/*     */   }
/*     */   
/*     */   public void registerSounds() {
/* 407 */     W_McClient.addSound("alert.ogg");
/* 408 */     W_McClient.addSound("locked.ogg");
/* 409 */     W_McClient.addSound("gltd.ogg");
/* 410 */     W_McClient.addSound("zoom.ogg");
/* 411 */     W_McClient.addSound("ng.ogg");
/* 412 */     W_McClient.addSound("a-10_snd.ogg");
/* 413 */     W_McClient.addSound("gau-8_snd.ogg");
/* 414 */     W_McClient.addSound("hit.ogg");
/* 415 */     W_McClient.addSound("helidmg.ogg");
/* 416 */     W_McClient.addSound("heli.ogg");
/* 417 */     W_McClient.addSound("plane.ogg");
/* 418 */     W_McClient.addSound("plane_cc.ogg");
/* 419 */     W_McClient.addSound("plane_cv.ogg");
/* 420 */     W_McClient.addSound("chain.ogg");
/* 421 */     W_McClient.addSound("chain_ct.ogg");
/* 422 */     W_McClient.addSound("eject_seat.ogg");
/* 423 */     W_McClient.addSound("fim92_snd.ogg");
/* 424 */     W_McClient.addSound("fim92_reload.ogg");
/* 425 */     W_McClient.addSound("lockon.ogg");
/* 426 */     Iterator<MCH_WeaponInfo> i$ = MCH_WeaponInfoManager.getValues().iterator();
/*     */     
/* 428 */     while (i$.hasNext()) {
/* 429 */       MCH_WeaponInfo info = i$.next();
/* 430 */       W_McClient.addSound(info.soundFileName + ".ogg");
/*     */     } 
/*     */     
/* 433 */     i$ = MCP_PlaneInfoManager.map.values().iterator();
/*     */     
/* 435 */     while (i$.hasNext()) {
/* 436 */       MCP_PlaneInfo info1 = (MCP_PlaneInfo)i$.next();
/* 437 */       if (!info1.soundMove.isEmpty()) {
/* 438 */         W_McClient.addSound(info1.soundMove + ".ogg");
/*     */       }
/*     */     } 
/*     */     
/* 442 */     i$ = MCH_HeliInfoManager.map.values().iterator();
/*     */     
/* 444 */     while (i$.hasNext()) {
/* 445 */       MCH_HeliInfo info2 = (MCH_HeliInfo)i$.next();
/* 446 */       if (!info2.soundMove.isEmpty()) {
/* 447 */         W_McClient.addSound(info2.soundMove + ".ogg");
/*     */       }
/*     */     } 
/*     */     
/* 451 */     i$ = MCH_TankInfoManager.map.values().iterator();
/*     */     
/* 453 */     while (i$.hasNext()) {
/* 454 */       MCH_TankInfo info3 = (MCH_TankInfo)i$.next();
/* 455 */       if (!info3.soundMove.isEmpty()) {
/* 456 */         W_McClient.addSound(info3.soundMove + ".ogg");
/*     */       }
/*     */     } 
/*     */     
/* 460 */     i$ = MCH_VehicleInfoManager.map.values().iterator();
/*     */     
/* 462 */     while (i$.hasNext()) {
/* 463 */       MCH_VehicleInfo info4 = (MCH_VehicleInfo)i$.next();
/* 464 */       if (!info4.soundMove.isEmpty()) {
/* 465 */         W_McClient.addSound(info4.soundMove + ".ogg");
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public MCH_Config loadConfig(String fileName) {
/* 472 */     this.lastConfigFileName = fileName;
/* 473 */     MCH_Config config = new MCH_Config((Minecraft.func_71410_x()).field_71412_D.getPath(), "/" + fileName);
/* 474 */     config.load();
/* 475 */     config.write();
/* 476 */     return config;
/*     */   }
/*     */   
/*     */   public MCH_Config reconfig() {
/* 480 */     MCH_Lib.DbgLog(false, "MCH_ClientProxy.reconfig()", new Object[0]);
/* 481 */     MCH_Config config = loadConfig(this.lastConfigFileName);
/* 482 */     MCH_ClientCommonTickHandler.instance.updatekeybind(config);
/* 483 */     return config;
/*     */   }
/*     */   
/*     */   public void loadHUD(String path) {
/* 487 */     this.lastLoadHUDPath = path;
/* 488 */     MCH_HudManager.load(path);
/*     */   }
/*     */   
/*     */   public void reloadHUD() {
/* 492 */     loadHUD(this.lastLoadHUDPath);
/*     */   }
/*     */   
/*     */   public Entity getClientPlayer() {
/* 496 */     return (Entity)(Minecraft.func_71410_x()).field_71439_g;
/*     */   }
/*     */   
/*     */   public void init() {
/* 500 */     MinecraftForge.EVENT_BUS.register(new MCH_ParticlesUtil());
/* 501 */     MinecraftForge.EVENT_BUS.register(new MCH_ClientEventHook());
/*     */   }
/*     */   
/*     */   public void setCreativeDigDelay(int n) {
/* 505 */     W_Reflection.setCreativeDigSpeed(n);
/*     */   }
/*     */   
/*     */   public boolean isFirstPerson() {
/* 509 */     return ((Minecraft.func_71410_x()).field_71474_y.field_74320_O == 0);
/*     */   }
/*     */   
/*     */   public int getNewRenderType() {
/* 513 */     return RenderingRegistry.getNextAvailableRenderId();
/*     */   }
/*     */   
/*     */   public boolean isSinglePlayer() {
/* 517 */     return Minecraft.func_71410_x().func_71356_B();
/*     */   }
/*     */   
/*     */   public void readClientModList() {
/*     */     try {
/* 522 */       Minecraft e = Minecraft.func_71410_x();
/* 523 */       MCH_MultiplayClient.readModList(e.func_110432_I().func_148255_b());
/* 524 */     } catch (Exception var2) {
/* 525 */       var2.printStackTrace();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void printChatMessage(IChatComponent chat, int showTime, int pos) {
/* 531 */     ((MCH_GuiTitle)MCH_ClientCommonTickHandler.instance.gui_Title).setupTitle(chat, showTime, pos);
/*     */   }
/*     */   
/*     */   public void hitBullet() {
/* 535 */     MCH_ClientCommonTickHandler.instance.gui_Common.hitBullet();
/*     */   }
/*     */   
/*     */   public void clientLocked() {
/* 539 */     MCH_ClientCommonTickHandler.isLocked = true;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_ClientProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */