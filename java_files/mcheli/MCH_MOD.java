/*     */ package mcheli;
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import cpw.mods.fml.common.Loader;
/*     */ import cpw.mods.fml.common.Mod;
/*     */ import cpw.mods.fml.common.Mod.EventHandler;
/*     */ import cpw.mods.fml.common.event.FMLInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPostInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLPreInitializationEvent;
/*     */ import cpw.mods.fml.common.event.FMLServerStartedEvent;
/*     */ import cpw.mods.fml.common.network.IGuiHandler;
/*     */ import cpw.mods.fml.common.registry.EntityRegistry;
/*     */ import cpw.mods.fml.common.registry.GameRegistry;
/*     */ import java.io.File;
/*     */ import java.util.Iterator;
/*     */ import mcheli.aircraft.MCH_EntityHide;
/*     */ import mcheli.aircraft.MCH_EntityHitBox;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.aircraft.MCH_ItemAircraft;
/*     */ import mcheli.aircraft.MCH_ItemFuel;
/*     */ import mcheli.block.MCH_DraftingTableBlock;
/*     */ import mcheli.block.MCH_DraftingTableTileEntity;
/*     */ import mcheli.command.MCH_Command;
/*     */ import mcheli.container.MCH_EntityContainer;
/*     */ import mcheli.container.MCH_ItemContainer;
/*     */ import mcheli.gltd.MCH_EntityGLTD;
/*     */ import mcheli.gltd.MCH_ItemGLTD;
/*     */ import mcheli.gui.MCH_GuiCommonHandler;
/*     */ import mcheli.helicopter.MCH_EntityHeli;
/*     */ import mcheli.helicopter.MCH_HeliInfo;
/*     */ import mcheli.helicopter.MCH_HeliInfoManager;
/*     */ import mcheli.helicopter.MCH_ItemHeli;
/*     */ import mcheli.lweapon.MCH_ItemLightWeaponBase;
/*     */ import mcheli.lweapon.MCH_ItemLightWeaponBullet;
/*     */ import mcheli.mob.MCH_EntityGunner;
/*     */ import mcheli.mob.MCH_ItemSpawnGunner;
/*     */ import mcheli.parachute.MCH_EntityParachute;
/*     */ import mcheli.parachute.MCH_ItemParachute;
/*     */ import mcheli.plane.MCP_PlaneInfo;
/*     */ import mcheli.plane.MCP_PlaneInfoManager;
/*     */ import mcheli.tank.MCH_EntityTank;
/*     */ import mcheli.tank.MCH_TankInfo;
/*     */ import mcheli.tank.MCH_TankInfoManager;
/*     */ import mcheli.throwable.MCH_EntityThrowable;
/*     */ import mcheli.throwable.MCH_ItemThrowable;
/*     */ import mcheli.throwable.MCH_ThrowableInfo;
/*     */ import mcheli.throwable.MCH_ThrowableInfoManager;
/*     */ import mcheli.tool.MCH_ItemWrench;
/*     */ import mcheli.tool.rangefinder.MCH_ItemRangeFinder;
/*     */ import mcheli.uav.MCH_EntityUavStation;
/*     */ import mcheli.uav.MCH_ItemUavStation;
/*     */ import mcheli.vehicle.MCH_ItemVehicle;
/*     */ import mcheli.vehicle.MCH_VehicleInfo;
/*     */ import mcheli.vehicle.MCH_VehicleInfoManager;
/*     */ import mcheli.weapon.MCH_EntityAAMissile;
/*     */ import mcheli.weapon.MCH_EntityASMissile;
/*     */ import mcheli.weapon.MCH_EntityATMissile;
/*     */ import mcheli.weapon.MCH_EntityBullet;
/*     */ import mcheli.weapon.MCH_EntityGPSMissile;
/*     */ import mcheli.weapon.MCH_EntityMarkerRocket;
/*     */ import mcheli.weapon.MCH_EntityTorpedo;
/*     */ import mcheli.weapon.MCH_EntityTvMissile;
/*     */ import mcheli.weapon.MCH_ItemAmmo;
/*     */ import mcheli.weapon.MCH_WeaponInfoManager;
/*     */ import mcheli.wrapper.NetworkMod;
/*     */ import mcheli.wrapper.W_Item;
/*     */ import mcheli.wrapper.W_ItemList;
/*     */ import mcheli.wrapper.W_LanguageRegistry;
/*     */ import mcheli.wrapper.W_NetworkRegistry;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.command.CommandHandler;
/*     */ import net.minecraft.command.ICommand;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraftforge.common.ForgeChunkManager;
/*     */ import net.minecraftforge.common.MinecraftForge;
/*     */ 
/*     */ @Mod(modid = "mcheli", name = "MCHeli SWRE Edition", version = "3.0.0", dependencies = "required-after:Forge@[10.13.2.1230,)")
/*     */ @NetworkMod(clientSideRequired = true, serverSideRequired = false)
/*     */ public class MCH_MOD {
/*  79 */   public static String VER = "1.0.2";
/*     */   public static final String MOD_ID = "mcheli";
/*     */   public static final String DOMAIN = "mcheli";
/*     */   public static final String MCVER = "1.7.10";
/*     */   public static final String MOD_CH = "MCHeli_CH";
/*     */   @Instance("mcheli")
/*     */   public static MCH_MOD instance;
/*     */   @SidedProxy(clientSide = "mcheli.MCH_ClientProxy", serverSide = "mcheli.MCH_CommonProxy")
/*     */   public static MCH_CommonProxy proxy;
/*  88 */   public static MCH_PacketHandler packetHandler = new MCH_PacketHandler();
/*     */   public static MCH_Config config;
/*     */   public static String sourcePath;
/*     */   public static MCH_InvisibleItem invisibleItem;
/*     */   public static MCH_ItemGLTD itemGLTD;
/*     */   public static MCH_ItemLightWeaponBullet itemStingerBullet;
/*     */   public static MCH_ItemLightWeaponBase itemStinger;
/*     */   public static MCH_ItemLightWeaponBullet itemJavelinBullet;
/*     */   public static MCH_ItemLightWeaponBase itemJavelin;
/*     */   public static MCH_ItemUavStation[] itemUavStation;
/*     */   public static MCH_ItemParachute itemParachute;
/*     */   public static MCH_ItemContainer itemContainer;
/*     */   public static MCH_ItemFuel itemFuel;
/*     */   public static MCH_ItemAmmo itemAmmo;
/*     */   public static MCH_ItemWrench itemWrench;
/*     */   public static MCH_ItemRangeFinder itemRangeFinder;
/*     */   public static MCH_ItemSpawnGunner itemSpawnGunnerVsPlayer;
/*     */   public static MCH_ItemSpawnGunner itemSpawnGunnerVsMonster;
/*     */   public static MCH_CreativeTabs creativeTabs;
/*     */   public static MCH_CreativeTabs creativeTabsHeli;
/*     */   public static MCH_CreativeTabs creativeTabsPlane;
/*     */   public static MCH_CreativeTabs creativeTabsTank;
/*     */   public static MCH_CreativeTabs creativeTabsVehicle;
/*     */   public static MCH_DraftingTableBlock blockDraftingTable;
/*     */   public static MCH_DraftingTableBlock blockDraftingTableLit;
/*     */   public static Item sampleHelmet;
/*     */   
/*     */   @EventHandler
/*     */   public void PreInit(FMLPreInitializationEvent evt) {
/* 117 */     VER = Loader.instance().activeModContainer().getVersion();
/* 118 */     MCH_Lib.init();
/* 119 */     MCH_Lib.Log("MC Ver:1.7.10 MOD Ver:" + VER + "", new Object[0]);
/* 120 */     MCH_Lib.Log("Start load...", new Object[0]);
/* 121 */     sourcePath = Loader.instance().activeModContainer().getSource().getPath();
/* 122 */     MCH_Lib.Log("SourcePath: " + sourcePath, new Object[0]);
/* 123 */     MCH_Lib.Log("CurrentDirectory:" + (new File(".")).getAbsolutePath(), new Object[0]);
/* 124 */     proxy.init();
/* 125 */     creativeTabs = new MCH_CreativeTabs("MC Heli Item");
/* 126 */     creativeTabsHeli = new MCH_CreativeTabs("MC Heli Helicopters");
/* 127 */     creativeTabsPlane = new MCH_CreativeTabs("MC Heli Planes");
/* 128 */     creativeTabsTank = new MCH_CreativeTabs("MC Heli Tanks");
/* 129 */     creativeTabsVehicle = new MCH_CreativeTabs("MC Heli Vehicles");
/* 130 */     W_ItemList.init();
/* 131 */     config = proxy.loadConfig("config/mcheli.cfg");
/* 132 */     proxy.loadHUD(sourcePath + "/assets/mcheli/hud");
/* 133 */     MCH_WeaponInfoManager.load(sourcePath + "/assets/mcheli/weapons");
/* 134 */     MCH_HeliInfoManager.getInstance().load(sourcePath + "/assets/mcheli/", "helicopters");
/* 135 */     MCP_PlaneInfoManager.getInstance().load(sourcePath + "/assets/mcheli/", "planes");
/* 136 */     MCH_TankInfoManager.getInstance().load(sourcePath + "/assets/mcheli/", "tanks");
/* 137 */     MCH_VehicleInfoManager.getInstance().load(sourcePath + "/assets/mcheli/", "vehicles");
/* 138 */     MCH_ThrowableInfoManager.load(sourcePath + "/assets/mcheli/throwable");
/* 139 */     MCH_SoundsJson.update(sourcePath + "/assets/mcheli/");
/* 140 */     MCH_Lib.Log("Register item", new Object[0]);
/* 141 */     registerItemRangeFinder();
/* 142 */     registerItemSpawnGunner();
/* 143 */     registerItemWrench();
/* 144 */     registerItemFuel();
/* 145 */     registerItemAmmo();
/* 146 */     registerItemGLTD();
/* 147 */     registerItemParachute();
/* 148 */     registerItemContainer();
/* 149 */     registerItemUavStation();
/* 150 */     registerItemInvisible();
/* 151 */     registerItemThrowable();
/* 152 */     registerItemLightWeaponBullet();
/* 153 */     registerItemLightWeapon();
/* 154 */     registerItemAircraft();
/* 155 */     MCH_DraftingTableBlock var10000 = new MCH_DraftingTableBlock(MCH_Config.BlockID_DraftingTableOFF.prmInt, false);
/* 156 */     MCH_Config var10002 = config;
/* 157 */     blockDraftingTable = var10000;
/* 158 */     blockDraftingTable.func_149663_c("drafting_table");
/* 159 */     blockDraftingTable.func_149647_a(creativeTabs);
/* 160 */     var10000 = new MCH_DraftingTableBlock(MCH_Config.BlockID_DraftingTableON.prmInt, true);
/* 161 */     var10002 = config;
/* 162 */     blockDraftingTableLit = var10000;
/* 163 */     blockDraftingTableLit.func_149663_c("lit_drafting_table");
/* 164 */     GameRegistry.registerBlock((Block)blockDraftingTable, "drafting_table");
/* 165 */     GameRegistry.registerBlock((Block)blockDraftingTableLit, "lit_drafting_table");
/* 166 */     W_LanguageRegistry.addName(blockDraftingTable, "Drafting Table");
/* 167 */     W_LanguageRegistry.addNameForObject(blockDraftingTable, "ja_JP", "製図台");
/* 168 */     MCH_Lib.Log("Register system", new Object[0]);
/* 169 */     W_NetworkRegistry.registerChannel(packetHandler, "MCHeli_CH");
/* 170 */     MinecraftForge.EVENT_BUS.register(new MCH_EventHook());
/* 171 */     proxy.registerClientTick();
/* 172 */     W_NetworkRegistry.registerGuiHandler(this, (IGuiHandler)new MCH_GuiCommonHandler());
/* 173 */     MCH_Lib.Log("Register entity", new Object[0]);
/* 174 */     registerEntity();
/* 175 */     MCH_Lib.Log("Register renderer", new Object[0]);
/* 176 */     proxy.registerRenderer();
/* 177 */     MCH_Lib.Log("Register models", new Object[0]);
/* 178 */     proxy.registerModels();
/* 179 */     MCH_Lib.Log("Register Sounds", new Object[0]);
/* 180 */     proxy.registerSounds();
/* 181 */     W_LanguageRegistry.updateLang(sourcePath + "/assets/mcheli/lang/");
/* 182 */     MCH_Lib.Log("End load", new Object[0]);
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void initCl(FMLInitializationEvent evt) {}
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void init(FMLInitializationEvent evt) {
/* 193 */     GameRegistry.registerTileEntity(MCH_DraftingTableTileEntity.class, "drafting_table");
/* 194 */     proxy.registerBlockRenderer();
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void postInit(FMLPostInitializationEvent evt) {
/* 199 */     MCH_Config var10001 = config;
/* 200 */     creativeTabs.setFixedIconItem(MCH_Config.CreativeTabIcon.prmString);
/* 201 */     var10001 = config;
/* 202 */     creativeTabsHeli.setFixedIconItem(MCH_Config.CreativeTabIconHeli.prmString);
/* 203 */     var10001 = config;
/* 204 */     creativeTabsPlane.setFixedIconItem(MCH_Config.CreativeTabIconPlane.prmString);
/* 205 */     var10001 = config;
/* 206 */     creativeTabsTank.setFixedIconItem(MCH_Config.CreativeTabIconTank.prmString);
/* 207 */     var10001 = config;
/* 208 */     creativeTabsVehicle.setFixedIconItem(MCH_Config.CreativeTabIconVehicle.prmString);
/* 209 */     MCH_WeaponInfoManager.setRoundItems();
/* 210 */     proxy.readClientModList();
/*     */   }
/*     */   
/*     */   @EventHandler
/*     */   public void onStartServer(FMLServerStartingEvent event) {
/* 215 */     proxy.registerServerTick();
/*     */   }
/*     */   
/*     */   public void registerEntity() {
/* 219 */     EntityRegistry.registerModEntity(MCH_EntitySeat.class, "MCH.E.Seat", 100, this, 200, 2, true);
/* 220 */     EntityRegistry.registerModEntity(MCH_EntityHeli.class, "MCH.E.Heli", 101, this, 200, 2, true);
/* 221 */     EntityRegistry.registerModEntity(MCH_EntityGLTD.class, "MCH.E.GLTD", 102, this, 200, 2, true);
/* 222 */     EntityRegistry.registerModEntity(MCP_EntityPlane.class, "MCH.E.Plane", 103, this, 200, 2, true);
/* 223 */     EntityRegistry.registerModEntity(MCH_EntityHitBox.class, "MCH.E.PSeat", 105, this, 200, 2, true);
/* 224 */     EntityRegistry.registerModEntity(MCH_EntityParachute.class, "MCH.E.Parachute", 106, this, 200, 2, true);
/* 225 */     EntityRegistry.registerModEntity(MCH_EntityContainer.class, "MCH.E.Container", 107, this, 200, 2, true);
/* 226 */     EntityRegistry.registerModEntity(MCH_EntityVehicle.class, "MCH.E.Vehicle", 108, this, 200, 2, true);
/* 227 */     EntityRegistry.registerModEntity(MCH_EntityUavStation.class, "MCH.E.UavStation", 109, this, 200, 2, true);
/* 228 */     EntityRegistry.registerModEntity(MCH_EntityHitBox.class, "MCH.E.HitBox", 110, this, 200, 1, true);
/* 229 */     EntityRegistry.registerModEntity(MCH_EntityHide.class, "MCH.E.Hide", 111, this, 200, 2, true);
/* 230 */     EntityRegistry.registerModEntity(MCH_EntityTank.class, "MCH.E.Tank", 112, this, 200, 2, true);
/* 231 */     EntityRegistry.registerModEntity(MCH_EntityRocket.class, "MCH.E.Rocket", 200, this, 530, 5, true);
/* 232 */     EntityRegistry.registerModEntity(MCH_EntityTvMissile.class, "MCH.E.TvMissle", 201, this, 530, 5, true);
/* 233 */     EntityRegistry.registerModEntity(MCH_EntityBullet.class, "MCH.E.Bullet", 202, this, 530, 5, true);
/* 234 */     EntityRegistry.registerModEntity(MCH_EntityA10.class, "MCH.E.A10", 203, this, 530, 5, true);
/* 235 */     EntityRegistry.registerModEntity(MCH_EntityAAMissile.class, "MCH.E.AAM", 204, this, 530, 1, true);
/* 236 */     EntityRegistry.registerModEntity(MCH_EntityASMissile.class, "MCH.E.ASM", 204, this, 530, 1, true);
/* 237 */     EntityRegistry.registerModEntity(MCH_EntityGPSMissile.class, "MCH.E.GPSM", 205, this, 530, 5, true);
/* 238 */     EntityRegistry.registerModEntity(MCH_EntityTorpedo.class, "MCH.E.Torpedo", 206, this, 530, 5, true);
/* 239 */     EntityRegistry.registerModEntity(MCH_EntityATMissile.class, "MCH.E.ATMissle", 207, this, 530, 5, true);
/* 240 */     EntityRegistry.registerModEntity(MCH_EntityLaserMissile.class, "MCH.E.LaserMissle", 207, this, 530, 1, true);
/* 241 */     EntityRegistry.registerModEntity(MCH_EntityBomb.class, "MCH.E.Bomb", 208, this, 530, 5, true);
/* 242 */     EntityRegistry.registerModEntity(MCH_EntityMarkerRocket.class, "MCH.E.MkRocket", 209, this, 530, 5, true);
/* 243 */     EntityRegistry.registerModEntity(MCH_EntityDispensedItem.class, "MCH.E.DispItem", 210, this, 530, 5, true);
/* 244 */     EntityRegistry.registerModEntity(MCH_EntityFlare.class, "MCH.E.Flare", 300, this, 330, 10, true);
/* 245 */     EntityRegistry.registerModEntity(MCH_EntityThrowable.class, "MCH.E.Throwable", 400, this, 330, 10, true);
/* 246 */     EntityRegistry.registerModEntity(MCH_EntityGunner.class, "MCH.E.Gunner", 500, this, 530, 1, true);
/*     */     
/* 248 */     ForgeChunkManager.setForcedChunkLoadingCallback(this, (ForgeChunkManager.LoadingCallback)new ChunkLoadingHandler());
/*     */   }
/*     */ 
/*     */   
/*     */   @EventHandler
/*     */   public void registerCommand(FMLServerStartedEvent e) {
/* 254 */     CommandHandler handler = (CommandHandler)FMLCommonHandler.instance().getSidedDelegate().getServer().func_71187_D();
/* 255 */     handler.func_71560_a((ICommand)new MCH_Command());
/*     */   }
/*     */   
/*     */   private void registerItemRangeFinder() {
/* 259 */     String name = "rangefinder";
/* 260 */     MCH_ItemRangeFinder var10000 = new MCH_ItemRangeFinder(MCH_Config.ItemID_RangeFinder.prmInt);
/* 261 */     MCH_Config var10002 = config;
/* 262 */     MCH_ItemRangeFinder item = var10000;
/* 263 */     itemRangeFinder = item;
/* 264 */     registerItem((W_Item)item, "rangefinder", creativeTabs);
/* 265 */     W_LanguageRegistry.addName(item, "Laser Rangefinder");
/* 266 */     W_LanguageRegistry.addNameForObject(item, "ja_JP", "レーザー レンジ ファインダー");
/*     */   }
/*     */   
/*     */   private void registerItemSpawnGunner() {
/* 270 */     String name = "spawn_gunner_vs_monster";
/* 271 */     MCH_ItemSpawnGunner item = new MCH_ItemSpawnGunner();
/* 272 */     item.targetType = 0;
/* 273 */     item.primaryColor = 12632224;
/* 274 */     item.secondaryColor = 12582912;
/* 275 */     itemSpawnGunnerVsMonster = item;
/* 276 */     registerItem((W_Item)item, name, creativeTabs);
/* 277 */     W_LanguageRegistry.addName(item, "Gunner (vs Monster)");
/* 278 */     W_LanguageRegistry.addNameForObject(item, "ja_JP", "対モンスター 射撃手");
/* 279 */     name = "spawn_gunner_vs_player";
/* 280 */     item = new MCH_ItemSpawnGunner();
/* 281 */     item.targetType = 1;
/* 282 */     item.primaryColor = 12632224;
/* 283 */     item.secondaryColor = 49152;
/* 284 */     itemSpawnGunnerVsPlayer = item;
/* 285 */     registerItem((W_Item)item, name, creativeTabs);
/* 286 */     W_LanguageRegistry.addName(item, "Gunner (vs Player of other team)");
/* 287 */     W_LanguageRegistry.addNameForObject(item, "ja_JP", "対他チームプレイヤー 射撃手");
/*     */   }
/*     */   
/*     */   private void registerItemWrench() {
/* 291 */     String name = "wrench";
/* 292 */     MCH_ItemWrench var10000 = new MCH_ItemWrench(MCH_Config.ItemID_Wrench.prmInt, Item.ToolMaterial.IRON);
/* 293 */     MCH_Config var10002 = config;
/* 294 */     MCH_ItemWrench item = var10000;
/* 295 */     itemWrench = item;
/* 296 */     registerItem((W_Item)item, "wrench", creativeTabs);
/* 297 */     W_LanguageRegistry.addName(item, "Wrench");
/* 298 */     W_LanguageRegistry.addNameForObject(item, "ja_JP", "レンチ");
/*     */   }
/*     */   
/*     */   public void registerItemInvisible() {
/* 302 */     String name = "internal";
/* 303 */     MCH_InvisibleItem var10000 = new MCH_InvisibleItem(MCH_Config.ItemID_InvisibleItem.prmInt);
/* 304 */     MCH_Config var10002 = config;
/* 305 */     MCH_InvisibleItem item = var10000;
/* 306 */     invisibleItem = item;
/* 307 */     registerItem(item, "internal", (MCH_CreativeTabs)null);
/*     */   }
/*     */   
/*     */   public void registerItemUavStation() {
/* 311 */     String[] dispName = { "UAV Station", "Portable UAV Controller" };
/* 312 */     String[] localName = { "UAVステーション", "携帯UAV制御端末" };
/* 313 */     itemUavStation = new MCH_ItemUavStation[MCH_ItemUavStation.UAV_STATION_KIND_NUM];
/* 314 */     String name = "uav_station";
/*     */     
/* 316 */     for (int i = 0; i < itemUavStation.length; i++) {
/* 317 */       String nn = (i > 0) ? ("" + (i + 1)) : "";
/* 318 */       MCH_ItemUavStation var10000 = new MCH_ItemUavStation((MCH_Config.ItemID_UavStation[i]).prmInt, 1 + i);
/* 319 */       MCH_Config var10002 = config;
/* 320 */       MCH_ItemUavStation item = var10000;
/* 321 */       itemUavStation[i] = item;
/* 322 */       registerItem((W_Item)item, "uav_station" + nn, creativeTabs);
/* 323 */       W_LanguageRegistry.addName(item, dispName[i]);
/* 324 */       W_LanguageRegistry.addNameForObject(item, "ja_JP", localName[i]);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerItemParachute() {
/* 330 */     String name = "parachute";
/* 331 */     MCH_ItemParachute var10000 = new MCH_ItemParachute(MCH_Config.ItemID_Parachute.prmInt);
/* 332 */     MCH_Config var10002 = config;
/* 333 */     MCH_ItemParachute item = var10000;
/* 334 */     itemParachute = item;
/* 335 */     registerItem((W_Item)item, "parachute", creativeTabs);
/* 336 */     W_LanguageRegistry.addName(item, "Parachute");
/* 337 */     W_LanguageRegistry.addNameForObject(item, "ja_JP", "パラシュート");
/*     */   }
/*     */   
/*     */   public void registerItemContainer() {
/* 341 */     String name = "container";
/* 342 */     MCH_ItemContainer var10000 = new MCH_ItemContainer(MCH_Config.ItemID_Container.prmInt);
/* 343 */     MCH_Config var10002 = config;
/* 344 */     MCH_ItemContainer item = var10000;
/* 345 */     itemContainer = item;
/* 346 */     registerItem((W_Item)item, "container", creativeTabs);
/* 347 */     W_LanguageRegistry.addName(item, "Container");
/* 348 */     W_LanguageRegistry.addNameForObject(item, "ja_JP", "コンテナ");
/*     */   }
/*     */   
/*     */   public void registerItemLightWeapon() {
/* 352 */     String name = "fim92";
/* 353 */     MCH_ItemLightWeaponBase var10000 = new MCH_ItemLightWeaponBase(MCH_Config.ItemID_Stinger.prmInt, itemStingerBullet);
/* 354 */     MCH_Config var10002 = config;
/* 355 */     MCH_ItemLightWeaponBase item = var10000;
/* 356 */     itemStinger = item;
/* 357 */     registerItem((W_Item)item, name, creativeTabs);
/* 358 */     W_LanguageRegistry.addName(item, "FIM-92 Stinger");
/* 359 */     name = "fgm148";
/* 360 */     var10000 = new MCH_ItemLightWeaponBase(MCH_Config.ItemID_Stinger.prmInt, itemJavelinBullet);
/* 361 */     var10002 = config;
/* 362 */     item = var10000;
/* 363 */     itemJavelin = item;
/* 364 */     registerItem((W_Item)item, name, creativeTabs);
/* 365 */     W_LanguageRegistry.addName(item, "FGM-148 Javelin");
/*     */   }
/*     */   
/*     */   public void registerItemLightWeaponBullet() {
/* 369 */     String name = "fim92_bullet";
/* 370 */     MCH_ItemLightWeaponBullet var10000 = new MCH_ItemLightWeaponBullet(MCH_Config.ItemID_StingerMissile.prmInt);
/* 371 */     MCH_Config var10002 = config;
/* 372 */     MCH_ItemLightWeaponBullet item = var10000;
/* 373 */     itemStingerBullet = item;
/* 374 */     registerItem((W_Item)item, name, creativeTabs);
/* 375 */     W_LanguageRegistry.addName(item, "FIM-92 Stinger missile");
/* 376 */     name = "fgm148_bullet";
/* 377 */     var10000 = new MCH_ItemLightWeaponBullet(MCH_Config.ItemID_StingerMissile.prmInt);
/* 378 */     var10002 = config;
/* 379 */     item = var10000;
/* 380 */     itemJavelinBullet = item;
/* 381 */     registerItem((W_Item)item, name, creativeTabs);
/* 382 */     W_LanguageRegistry.addName(item, "FGM-148 Javelin missile");
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void registerItemFuel() {
/* 388 */     String name = "fuel";
/* 389 */     MCH_ItemFuel var10000 = new MCH_ItemFuel(MCH_Config.ItemID_Fuel.prmInt);
/* 390 */     MCH_Config var10002 = config;
/* 391 */     MCH_ItemFuel item = var10000;
/* 392 */     itemFuel = item;
/* 393 */     registerItem((W_Item)item, "fuel", creativeTabs);
/* 394 */     W_LanguageRegistry.addName(item, "Fuel");
/* 395 */     W_LanguageRegistry.addNameForObject(item, "ja_JP", "燃料");
/*     */   }
/*     */   
/*     */   public void registerItemAmmo() {
/* 399 */     String name = "ammo";
/* 400 */     MCH_ItemAmmo item = new MCH_ItemAmmo();
/* 401 */     itemAmmo = item;
/* 402 */     registerItem((W_Item)item, "ammo", creativeTabs);
/* 403 */     W_LanguageRegistry.addName(item, "Ammo");
/* 404 */     W_LanguageRegistry.addNameForObject(item, "ru_RU", "Боеприпасы");
/*     */   }
/*     */   
/*     */   public void registerItemGLTD() {
/* 408 */     String name = "gltd";
/* 409 */     MCH_ItemGLTD var10000 = new MCH_ItemGLTD(MCH_Config.ItemID_GLTD.prmInt);
/* 410 */     MCH_Config var10002 = config;
/* 411 */     MCH_ItemGLTD item = var10000;
/* 412 */     itemGLTD = item;
/* 413 */     registerItem((W_Item)item, "gltd", creativeTabs);
/* 414 */     W_LanguageRegistry.addName(item, "GLTD:Target Designator");
/* 415 */     W_LanguageRegistry.addNameForObject(item, "ja_JP", "GLTD:レーザー目標指示装置");
/*     */   }
/*     */   
/*     */   public static void registerItem(W_Item item, String name, MCH_CreativeTabs ct) {
/* 419 */     item.func_77655_b("mcheli:" + name);
/* 420 */     item.setTexture(name);
/* 421 */     if (ct != null) {
/* 422 */       item.func_77637_a(ct);
/* 423 */       ct.addIconItem((Item)item);
/*     */     } 
/*     */     
/* 426 */     GameRegistry.registerItem((Item)item, name);
/*     */   }
/*     */   
/*     */   public static void registerItemThrowable() {
/* 430 */     Iterator<String> i$ = MCH_ThrowableInfoManager.getKeySet().iterator();
/*     */     
/* 432 */     while (i$.hasNext()) {
/* 433 */       String name = i$.next();
/* 434 */       MCH_ThrowableInfo info = MCH_ThrowableInfoManager.get(name);
/* 435 */       info.item = (W_Item)new MCH_ItemThrowable(info.itemID);
/* 436 */       info.item.func_77625_d(info.stackSize);
/* 437 */       registerItem(info.item, name, creativeTabs);
/* 438 */       MCH_ItemThrowable.registerDispenseBehavior((Item)info.item);
/* 439 */       info.itemID = W_Item.getIdFromItem((Item)info.item) - 256;
/* 440 */       W_LanguageRegistry.addName(info.item, info.displayName);
/* 441 */       Iterator<String> i$1 = info.displayNameLang.keySet().iterator();
/*     */       
/* 443 */       while (i$1.hasNext()) {
/* 444 */         String lang = i$1.next();
/* 445 */         W_LanguageRegistry.addNameForObject(info.item, lang, (String)info.displayNameLang.get(lang));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void registerItemAircraft() {
/* 452 */     Iterator<String> i$ = MCH_HeliInfoManager.map.keySet().iterator();
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 457 */     while (i$.hasNext()) {
/* 458 */       String name = i$.next();
/* 459 */       MCH_HeliInfo info = (MCH_HeliInfo)MCH_HeliInfoManager.map.get(name);
/* 460 */       info.item = new MCH_ItemHeli(info.itemID);
/* 461 */       info.item.func_77656_e(info.maxHp);
/* 462 */       if (!info.canRide && (info.ammoSupplyRange > 0.0F || info.fuelSupplyRange > 0.0F)) {
/* 463 */         registerItem((W_Item)info.item, name, creativeTabs);
/*     */       } else {
/* 465 */         registerItem((W_Item)info.item, name, creativeTabsHeli);
/*     */       } 
/*     */       
/* 468 */       MCH_ItemAircraft.registerDispenseBehavior((Item)info.item);
/* 469 */       info.itemID = W_Item.getIdFromItem((Item)info.item) - 256;
/* 470 */       W_LanguageRegistry.addName(info.item, info.displayName);
/* 471 */       Iterator<String> i$1 = info.displayNameLang.keySet().iterator();
/*     */       
/* 473 */       while (i$1.hasNext()) {
/* 474 */         String lang = i$1.next();
/* 475 */         W_LanguageRegistry.addNameForObject(info.item, lang, (String)info.displayNameLang.get(lang));
/*     */       } 
/*     */     } 
/*     */     
/* 479 */     i$ = MCP_PlaneInfoManager.map.keySet().iterator();
/*     */     
/* 481 */     while (i$.hasNext()) {
/* 482 */       String name = i$.next();
/* 483 */       MCP_PlaneInfo info1 = (MCP_PlaneInfo)MCP_PlaneInfoManager.map.get(name);
/* 484 */       info1.item = new MCP_ItemPlane(info1.itemID);
/* 485 */       info1.item.func_77656_e(info1.maxHp);
/* 486 */       if (!info1.canRide && (info1.ammoSupplyRange > 0.0F || info1.fuelSupplyRange > 0.0F)) {
/* 487 */         registerItem((W_Item)info1.item, name, creativeTabs);
/*     */       } else {
/* 489 */         registerItem((W_Item)info1.item, name, creativeTabsPlane);
/*     */       } 
/*     */       
/* 492 */       MCH_ItemAircraft.registerDispenseBehavior((Item)info1.item);
/* 493 */       info1.itemID = W_Item.getIdFromItem((Item)info1.item) - 256;
/* 494 */       W_LanguageRegistry.addName(info1.item, info1.displayName);
/* 495 */       Iterator<String> i$1 = info1.displayNameLang.keySet().iterator();
/*     */       
/* 497 */       while (i$1.hasNext()) {
/* 498 */         String lang = i$1.next();
/* 499 */         W_LanguageRegistry.addNameForObject(info1.item, lang, (String)info1.displayNameLang.get(lang));
/*     */       } 
/*     */     } 
/*     */     
/* 503 */     i$ = MCH_TankInfoManager.map.keySet().iterator();
/*     */     
/* 505 */     while (i$.hasNext()) {
/* 506 */       String name = i$.next();
/* 507 */       MCH_TankInfo info2 = (MCH_TankInfo)MCH_TankInfoManager.map.get(name);
/* 508 */       info2.item = new MCH_ItemTank(info2.itemID);
/* 509 */       info2.item.func_77656_e(info2.maxHp);
/* 510 */       if (!info2.canRide && (info2.ammoSupplyRange > 0.0F || info2.fuelSupplyRange > 0.0F)) {
/* 511 */         registerItem((W_Item)info2.item, name, creativeTabs);
/*     */       } else {
/* 513 */         registerItem((W_Item)info2.item, name, creativeTabsTank);
/*     */       } 
/*     */       
/* 516 */       MCH_ItemAircraft.registerDispenseBehavior((Item)info2.item);
/* 517 */       info2.itemID = W_Item.getIdFromItem((Item)info2.item) - 256;
/* 518 */       W_LanguageRegistry.addName(info2.item, info2.displayName);
/* 519 */       Iterator<String> i$1 = info2.displayNameLang.keySet().iterator();
/*     */       
/* 521 */       while (i$1.hasNext()) {
/* 522 */         String lang = i$1.next();
/* 523 */         W_LanguageRegistry.addNameForObject(info2.item, lang, (String)info2.displayNameLang.get(lang));
/*     */       } 
/*     */     } 
/*     */     
/* 527 */     i$ = MCH_VehicleInfoManager.map.keySet().iterator();
/*     */     
/* 529 */     while (i$.hasNext()) {
/* 530 */       String name = i$.next();
/* 531 */       MCH_VehicleInfo info3 = (MCH_VehicleInfo)MCH_VehicleInfoManager.map.get(name);
/* 532 */       info3.item = new MCH_ItemVehicle(info3.itemID);
/* 533 */       info3.item.func_77656_e(info3.maxHp);
/* 534 */       if (!info3.canRide && (info3.ammoSupplyRange > 0.0F || info3.fuelSupplyRange > 0.0F)) {
/* 535 */         registerItem((W_Item)info3.item, name, creativeTabs);
/*     */       } else {
/* 537 */         registerItem((W_Item)info3.item, name, creativeTabsVehicle);
/*     */       } 
/*     */       
/* 540 */       MCH_ItemAircraft.registerDispenseBehavior((Item)info3.item);
/* 541 */       info3.itemID = W_Item.getIdFromItem((Item)info3.item) - 256;
/* 542 */       W_LanguageRegistry.addName(info3.item, info3.displayName);
/* 543 */       Iterator<String> i$1 = info3.displayNameLang.keySet().iterator();
/*     */       
/* 545 */       while (i$1.hasNext()) {
/* 546 */         String lang = i$1.next();
/* 547 */         W_LanguageRegistry.addNameForObject(info3.item, lang, (String)info3.displayNameLang.get(lang));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_MOD.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */