/*     */ package mcheli;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.aircraft.MCH_ClientSeatTickHandler;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.aircraft.MCH_SeatInfo;
/*     */ import mcheli.command.MCH_GuiTitle;
/*     */ import mcheli.gltd.MCH_ClientGLTDTickHandler;
/*     */ import mcheli.gltd.MCH_EntityGLTD;
/*     */ import mcheli.gltd.MCH_GuiGLTD;
/*     */ import mcheli.gui.MCH_Gui;
/*     */ import mcheli.helicopter.MCH_ClientHeliTickHandler;
/*     */ import mcheli.helicopter.MCH_GuiHeli;
/*     */ import mcheli.lweapon.MCH_ClientLightWeaponTickHandler;
/*     */ import mcheli.lweapon.MCH_GuiLightWeapon;
/*     */ import mcheli.mob.MCH_GuiSpawnGunner;
/*     */ import mcheli.multiplay.MCH_GuiScoreboard;
/*     */ import mcheli.multiplay.MCH_GuiTargetMarker;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.plane.MCP_ClientPlaneTickHandler;
/*     */ import mcheli.plane.MCP_GuiPlane;
/*     */ import mcheli.tank.MCH_ClientTankTickHandler;
/*     */ import mcheli.tank.MCH_GuiTank;
/*     */ import mcheli.tool.MCH_ClientToolTickHandler;
/*     */ import mcheli.tool.MCH_GuiWrench;
/*     */ import mcheli.tool.rangefinder.MCH_GuiRangeFinder;
/*     */ import mcheli.uav.MCH_EntityUavStation;
/*     */ import mcheli.vehicle.MCH_ClientVehicleTickHandler;
/*     */ import mcheli.vehicle.MCH_GuiVehicle;
/*     */ import mcheli.weapon.MCH_EntityBullet;
/*     */ import mcheli.weapon.MCH_WeaponParam;
/*     */ import mcheli.weapon.MCH_WeaponSet;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_Reflection;
/*     */ import mcheli.wrapper.W_TickHandler;
/*     */ import mcheli.wrapper.W_Vec3;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.Display;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_ClientCommonTickHandler extends W_TickHandler {
/*     */   public static MCH_ClientCommonTickHandler instance;
/*     */   public MCH_GuiCommon gui_Common;
/*     */   public MCH_Gui gui_Heli;
/*     */   public MCH_Gui gui_Plane;
/*     */   public MCH_Gui gui_Tank;
/*     */   public MCH_Gui gui_GLTD;
/*     */   public MCH_Gui gui_Vehicle;
/*     */   public MCH_Gui gui_LWeapon;
/*     */   public MCH_Gui gui_Wrench;
/*     */   public MCH_Gui gui_SwnGnr;
/*     */   public MCH_Gui gui_EMarker;
/*     */   public MCH_Gui gui_RngFndr;
/*     */   public MCH_Gui gui_Title;
/*     */   public MCH_Gui[] guis;
/*     */   public MCH_Gui[] guiTicks;
/*     */   public MCH_ClientTickHandlerBase[] ticks;
/*     */   public MCH_Key[] Keys;
/*     */   public MCH_Key KeyCamDistUp;
/*     */   public MCH_Key KeyCamDistDown;
/*     */   public MCH_Key KeyScoreboard;
/*     */   public MCH_Key KeyMultiplayManager;
/*  77 */   public static int cameraMode = 0;
/*  78 */   public static MCH_EntityAircraft ridingAircraft = null;
/*     */   public static boolean isDrawScoreboard = false;
/*  80 */   public static int sendLDCount = 0;
/*     */   public static boolean isLocked = false;
/*  82 */   public static int lockedSoundCount = 0;
/*     */   int debugcnt;
/*     */   private static double prevMouseDeltaX;
/*     */   private static double prevMouseDeltaY;
/*  86 */   private static double mouseDeltaX = 0.0D;
/*  87 */   private static double mouseDeltaY = 0.0D;
/*  88 */   private static double mouseRollDeltaX = 0.0D;
/*  89 */   private static double mouseRollDeltaY = 0.0D;
/*     */   private static boolean isRideAircraft = false;
/*  91 */   private static float prevTick = 0.0F;
/*     */   
/*     */   private static long lastFrameTime;
/*     */   
/*     */   public MCH_ClientCommonTickHandler(Minecraft minecraft, MCH_Config config) {
/*  96 */     super(minecraft);
/*  97 */     this.gui_Common = new MCH_GuiCommon(minecraft);
/*  98 */     this.gui_Heli = (MCH_Gui)new MCH_GuiHeli(minecraft);
/*  99 */     this.gui_Plane = (MCH_Gui)new MCP_GuiPlane(minecraft);
/* 100 */     this.gui_Tank = (MCH_Gui)new MCH_GuiTank(minecraft);
/* 101 */     this.gui_GLTD = (MCH_Gui)new MCH_GuiGLTD(minecraft);
/* 102 */     this.gui_Vehicle = (MCH_Gui)new MCH_GuiVehicle(minecraft);
/* 103 */     this.gui_LWeapon = (MCH_Gui)new MCH_GuiLightWeapon(minecraft);
/* 104 */     this.gui_Wrench = (MCH_Gui)new MCH_GuiWrench(minecraft);
/* 105 */     this.gui_SwnGnr = (MCH_Gui)new MCH_GuiSpawnGunner(minecraft);
/* 106 */     this.gui_RngFndr = (MCH_Gui)new MCH_GuiRangeFinder(minecraft);
/* 107 */     this.gui_EMarker = (MCH_Gui)new MCH_GuiTargetMarker(minecraft);
/* 108 */     this.gui_Title = (MCH_Gui)new MCH_GuiTitle(minecraft);
/* 109 */     this.guis = new MCH_Gui[] { this.gui_RngFndr, this.gui_LWeapon, this.gui_Heli, this.gui_Plane, this.gui_Tank, this.gui_GLTD, this.gui_Vehicle };
/* 110 */     this.guiTicks = new MCH_Gui[] { (MCH_Gui)this.gui_Common, this.gui_Heli, this.gui_Plane, this.gui_Tank, this.gui_GLTD, this.gui_Vehicle, this.gui_LWeapon, this.gui_Wrench, this.gui_SwnGnr, this.gui_RngFndr, this.gui_EMarker, this.gui_Title };
/* 111 */     this.ticks = new MCH_ClientTickHandlerBase[] { (MCH_ClientTickHandlerBase)new MCH_ClientHeliTickHandler(minecraft, config), (MCH_ClientTickHandlerBase)new MCP_ClientPlaneTickHandler(minecraft, config), (MCH_ClientTickHandlerBase)new MCH_ClientTankTickHandler(minecraft, config), (MCH_ClientTickHandlerBase)new MCH_ClientGLTDTickHandler(minecraft, config), (MCH_ClientTickHandlerBase)new MCH_ClientVehicleTickHandler(minecraft, config), (MCH_ClientTickHandlerBase)new MCH_ClientLightWeaponTickHandler(minecraft, config), (MCH_ClientTickHandlerBase)new MCH_ClientSeatTickHandler(minecraft, config), (MCH_ClientTickHandlerBase)new MCH_ClientToolTickHandler(minecraft, config) };
/* 112 */     updatekeybind(config);
/*     */   }
/*     */   
/*     */   public void updatekeybind(MCH_Config config) {
/* 116 */     this.KeyCamDistUp = new MCH_Key(MCH_Config.KeyCameraDistUp.prmInt);
/* 117 */     this.KeyCamDistDown = new MCH_Key(MCH_Config.KeyCameraDistDown.prmInt);
/* 118 */     this.KeyScoreboard = new MCH_Key(MCH_Config.KeyScoreboard.prmInt);
/* 119 */     this.KeyMultiplayManager = new MCH_Key(MCH_Config.KeyMultiplayManager.prmInt);
/* 120 */     this.Keys = new MCH_Key[] { this.KeyCamDistUp, this.KeyCamDistDown, this.KeyScoreboard, this.KeyMultiplayManager };
/* 121 */     MCH_ClientTickHandlerBase[] arr$ = this.ticks;
/* 122 */     int len$ = arr$.length;
/*     */     
/* 124 */     for (int i$ = 0; i$ < len$; i$++) {
/* 125 */       MCH_ClientTickHandlerBase t = arr$[i$];
/* 126 */       t.updateKeybind(config);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public String getLabel() {
/* 132 */     return null;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onTick() {
/*     */     // Byte code:
/*     */     //   0: invokestatic initRotLimit : ()V
/*     */     //   3: aload_0
/*     */     //   4: getfield Keys : [Lmcheli/MCH_Key;
/*     */     //   7: astore_1
/*     */     //   8: aload_1
/*     */     //   9: arraylength
/*     */     //   10: istore_2
/*     */     //   11: iconst_0
/*     */     //   12: istore_3
/*     */     //   13: iload_3
/*     */     //   14: iload_2
/*     */     //   15: if_icmpge -> 34
/*     */     //   18: aload_1
/*     */     //   19: iload_3
/*     */     //   20: aaload
/*     */     //   21: astore #4
/*     */     //   23: aload #4
/*     */     //   25: invokevirtual update : ()V
/*     */     //   28: iinc #3, 1
/*     */     //   31: goto -> 13
/*     */     //   34: aload_0
/*     */     //   35: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   38: getfield field_71439_g : Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   41: astore_3
/*     */     //   42: aload_3
/*     */     //   43: ifnull -> 212
/*     */     //   46: aload_0
/*     */     //   47: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   50: getfield field_71462_r : Lnet/minecraft/client/gui/GuiScreen;
/*     */     //   53: ifnonnull -> 212
/*     */     //   56: getstatic mcheli/MCH_ServerSettings.enableCamDistChange : Z
/*     */     //   59: ifeq -> 148
/*     */     //   62: aload_0
/*     */     //   63: getfield KeyCamDistUp : Lmcheli/MCH_Key;
/*     */     //   66: invokevirtual isKeyDown : ()Z
/*     */     //   69: ifne -> 82
/*     */     //   72: aload_0
/*     */     //   73: getfield KeyCamDistDown : Lmcheli/MCH_Key;
/*     */     //   76: invokevirtual isKeyDown : ()Z
/*     */     //   79: ifeq -> 148
/*     */     //   82: invokestatic getThirdPersonDistance : ()F
/*     */     //   85: f2i
/*     */     //   86: istore_2
/*     */     //   87: aload_0
/*     */     //   88: getfield KeyCamDistUp : Lmcheli/MCH_Key;
/*     */     //   91: invokevirtual isKeyDown : ()Z
/*     */     //   94: ifeq -> 123
/*     */     //   97: iload_2
/*     */     //   98: bipush #60
/*     */     //   100: if_icmpge -> 123
/*     */     //   103: iinc #2, 4
/*     */     //   106: iload_2
/*     */     //   107: bipush #60
/*     */     //   109: if_icmple -> 115
/*     */     //   112: bipush #60
/*     */     //   114: istore_2
/*     */     //   115: iload_2
/*     */     //   116: i2f
/*     */     //   117: invokestatic setThirdPersonDistance : (F)V
/*     */     //   120: goto -> 148
/*     */     //   123: aload_0
/*     */     //   124: getfield KeyCamDistDown : Lmcheli/MCH_Key;
/*     */     //   127: invokevirtual isKeyDown : ()Z
/*     */     //   130: ifeq -> 148
/*     */     //   133: iinc #2, -4
/*     */     //   136: iload_2
/*     */     //   137: iconst_4
/*     */     //   138: if_icmpge -> 143
/*     */     //   141: iconst_4
/*     */     //   142: istore_2
/*     */     //   143: iload_2
/*     */     //   144: i2f
/*     */     //   145: invokestatic setThirdPersonDistance : (F)V
/*     */     //   148: aload_0
/*     */     //   149: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   152: getfield field_71462_r : Lnet/minecraft/client/gui/GuiScreen;
/*     */     //   155: ifnonnull -> 212
/*     */     //   158: aload_0
/*     */     //   159: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   162: invokevirtual func_71356_B : ()Z
/*     */     //   165: ifeq -> 182
/*     */     //   168: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   171: astore #4
/*     */     //   173: getstatic mcheli/MCH_Config.DebugLog : Z
/*     */     //   176: ifne -> 182
/*     */     //   179: goto -> 212
/*     */     //   182: aload_0
/*     */     //   183: getfield KeyScoreboard : Lmcheli/MCH_Key;
/*     */     //   186: invokevirtual isKeyPress : ()Z
/*     */     //   189: putstatic mcheli/MCH_ClientCommonTickHandler.isDrawScoreboard : Z
/*     */     //   192: getstatic mcheli/MCH_ClientCommonTickHandler.isDrawScoreboard : Z
/*     */     //   195: ifne -> 212
/*     */     //   198: aload_0
/*     */     //   199: getfield KeyMultiplayManager : Lmcheli/MCH_Key;
/*     */     //   202: invokevirtual isKeyDown : ()Z
/*     */     //   205: ifeq -> 212
/*     */     //   208: iconst_5
/*     */     //   209: invokestatic send : (I)V
/*     */     //   212: getstatic mcheli/MCH_ClientCommonTickHandler.sendLDCount : I
/*     */     //   215: bipush #10
/*     */     //   217: if_icmpge -> 231
/*     */     //   220: getstatic mcheli/MCH_ClientCommonTickHandler.sendLDCount : I
/*     */     //   223: iconst_1
/*     */     //   224: iadd
/*     */     //   225: putstatic mcheli/MCH_ClientCommonTickHandler.sendLDCount : I
/*     */     //   228: goto -> 238
/*     */     //   231: invokestatic sendImageData : ()V
/*     */     //   234: iconst_0
/*     */     //   235: putstatic mcheli/MCH_ClientCommonTickHandler.sendLDCount : I
/*     */     //   238: aload_0
/*     */     //   239: getfield mc : Lnet/minecraft/client/Minecraft;
/*     */     //   242: getfield field_71462_r : Lnet/minecraft/client/gui/GuiScreen;
/*     */     //   245: ifnull -> 252
/*     */     //   248: iconst_1
/*     */     //   249: goto -> 253
/*     */     //   252: iconst_0
/*     */     //   253: istore #4
/*     */     //   255: aload_0
/*     */     //   256: getfield ticks : [Lmcheli/MCH_ClientTickHandlerBase;
/*     */     //   259: astore #5
/*     */     //   261: aload #5
/*     */     //   263: arraylength
/*     */     //   264: istore #6
/*     */     //   266: iconst_0
/*     */     //   267: istore #7
/*     */     //   269: iload #7
/*     */     //   271: iload #6
/*     */     //   273: if_icmpge -> 296
/*     */     //   276: aload #5
/*     */     //   278: iload #7
/*     */     //   280: aaload
/*     */     //   281: astore #8
/*     */     //   283: aload #8
/*     */     //   285: iload #4
/*     */     //   287: invokevirtual onTick : (Z)V
/*     */     //   290: iinc #7, 1
/*     */     //   293: goto -> 269
/*     */     //   296: aload_0
/*     */     //   297: getfield guiTicks : [Lmcheli/gui/MCH_Gui;
/*     */     //   300: astore #8
/*     */     //   302: aload #8
/*     */     //   304: arraylength
/*     */     //   305: istore #6
/*     */     //   307: iconst_0
/*     */     //   308: istore #7
/*     */     //   310: iload #7
/*     */     //   312: iload #6
/*     */     //   314: if_icmpge -> 335
/*     */     //   317: aload #8
/*     */     //   319: iload #7
/*     */     //   321: aaload
/*     */     //   322: astore #9
/*     */     //   324: aload #9
/*     */     //   326: invokevirtual onTick : ()V
/*     */     //   329: iinc #7, 1
/*     */     //   332: goto -> 310
/*     */     //   335: aload_3
/*     */     //   336: invokestatic getAircraft_RiddenOrControl : (Lnet/minecraft/entity/Entity;)Lmcheli/aircraft/MCH_EntityAircraft;
/*     */     //   339: astore #9
/*     */     //   341: aload_3
/*     */     //   342: ifnull -> 388
/*     */     //   345: aload #9
/*     */     //   347: ifnull -> 388
/*     */     //   350: aload #9
/*     */     //   352: invokevirtual isDestroyed : ()Z
/*     */     //   355: ifne -> 388
/*     */     //   358: getstatic mcheli/MCH_ClientCommonTickHandler.isLocked : Z
/*     */     //   361: ifeq -> 396
/*     */     //   364: getstatic mcheli/MCH_ClientCommonTickHandler.lockedSoundCount : I
/*     */     //   367: ifne -> 396
/*     */     //   370: iconst_0
/*     */     //   371: putstatic mcheli/MCH_ClientCommonTickHandler.isLocked : Z
/*     */     //   374: bipush #20
/*     */     //   376: putstatic mcheli/MCH_ClientCommonTickHandler.lockedSoundCount : I
/*     */     //   379: ldc_w 'locked'
/*     */     //   382: invokestatic playSound : (Ljava/lang/String;)V
/*     */     //   385: goto -> 396
/*     */     //   388: iconst_0
/*     */     //   389: putstatic mcheli/MCH_ClientCommonTickHandler.lockedSoundCount : I
/*     */     //   392: iconst_0
/*     */     //   393: putstatic mcheli/MCH_ClientCommonTickHandler.isLocked : Z
/*     */     //   396: getstatic mcheli/MCH_ClientCommonTickHandler.lockedSoundCount : I
/*     */     //   399: ifle -> 410
/*     */     //   402: getstatic mcheli/MCH_ClientCommonTickHandler.lockedSoundCount : I
/*     */     //   405: iconst_1
/*     */     //   406: isub
/*     */     //   407: putstatic mcheli/MCH_ClientCommonTickHandler.lockedSoundCount : I
/*     */     //   410: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #137	-> 0
/*     */     //   #138	-> 3
/*     */     //   #139	-> 8
/*     */     //   #141	-> 11
/*     */     //   #142	-> 18
/*     */     //   #143	-> 23
/*     */     //   #141	-> 28
/*     */     //   #146	-> 34
/*     */     //   #147	-> 42
/*     */     //   #148	-> 56
/*     */     //   #149	-> 82
/*     */     //   #150	-> 87
/*     */     //   #151	-> 103
/*     */     //   #152	-> 106
/*     */     //   #153	-> 112
/*     */     //   #156	-> 115
/*     */     //   #157	-> 123
/*     */     //   #158	-> 133
/*     */     //   #159	-> 136
/*     */     //   #160	-> 141
/*     */     //   #163	-> 143
/*     */     //   #167	-> 148
/*     */     //   #170	-> 158
/*     */     //   #171	-> 168
/*     */     //   #172	-> 173
/*     */     //   #173	-> 179
/*     */     //   #177	-> 182
/*     */     //   #178	-> 192
/*     */     //   #179	-> 208
/*     */     //   #185	-> 212
/*     */     //   #186	-> 220
/*     */     //   #188	-> 231
/*     */     //   #189	-> 234
/*     */     //   #192	-> 238
/*     */     //   #193	-> 255
/*     */     //   #194	-> 261
/*     */     //   #197	-> 266
/*     */     //   #198	-> 276
/*     */     //   #199	-> 283
/*     */     //   #197	-> 290
/*     */     //   #202	-> 296
/*     */     //   #203	-> 302
/*     */     //   #205	-> 307
/*     */     //   #206	-> 317
/*     */     //   #207	-> 324
/*     */     //   #205	-> 329
/*     */     //   #210	-> 335
/*     */     //   #211	-> 341
/*     */     //   #212	-> 358
/*     */     //   #213	-> 370
/*     */     //   #214	-> 374
/*     */     //   #215	-> 379
/*     */     //   #218	-> 388
/*     */     //   #219	-> 392
/*     */     //   #222	-> 396
/*     */     //   #223	-> 402
/*     */     //   #226	-> 410
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   23	5	4	len$	Lmcheli/MCH_Key;
/*     */     //   13	21	3	ac	I
/*     */     //   173	9	4	var10000	Lmcheli/MCH_Config;
/*     */     //   283	7	8	g	Lmcheli/MCH_ClientTickHandlerBase;
/*     */     //   324	5	9	var13	Lmcheli/gui/MCH_Gui;
/*     */     //   0	411	0	this	Lmcheli/MCH_ClientCommonTickHandler;
/*     */     //   8	403	1	player	[Lmcheli/MCH_Key;
/*     */     //   11	400	2	inOtherGui	I
/*     */     //   42	369	3	var7	Lnet/minecraft/client/entity/EntityClientPlayerMP;
/*     */     //   255	156	4	var12	Z
/*     */     //   261	150	5	var8	[Lmcheli/MCH_ClientTickHandlerBase;
/*     */     //   266	145	6	var10	I
/*     */     //   269	142	7	i$	I
/*     */     //   302	109	8	var9	[Lmcheli/gui/MCH_Gui;
/*     */     //   341	70	9	var11	Lmcheli/aircraft/MCH_EntityAircraft;
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onTickPre() {
/* 229 */     if (this.mc.field_71439_g != null && this.mc.field_71441_e != null) {
/* 230 */       onTick();
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public Vec3 getGunnerWeaponPos(MCH_EntityAircraft ac, MCH_WeaponSet ws) {
/* 236 */     MCH_SeatInfo seatInfo = ac.getSeatInfo((Entity)this.mc.field_71439_g);
/* 237 */     return ((seatInfo == null || !seatInfo.rotSeat) && !(ac instanceof mcheli.vehicle.MCH_EntityVehicle)) ? ac.getTransformedPosition((ws.getCurrentWeapon()).position) : ac.calcOnTurretPos((ws.getCurrentWeapon()).position).func_72441_c(ac.field_70165_t, ac.field_70163_u, ac.field_70161_v);
/*     */   }
/*     */   
/*     */   public void onTickPost() {
/* 241 */     if (this.mc.field_71439_g != null && this.mc.field_71441_e != null) {
/* 242 */       MCH_GuiTargetMarker.onClientTick();
/* 243 */       MCH_EntityAircraft ac = null;
/*     */       
/* 245 */       if (MCH_ParticlesUtil.markPoint != null && 
/* 246 */         MCH_ParticlesUtil.markPoint.isFromBallisticCalculator && 
/* 247 */         this.mc.field_71439_g.field_70154_o == null) {
/* 248 */         MCH_ParticlesUtil.clearMarkPoint();
/*     */       }
/*     */       
/* 251 */       if (this.mc.field_71439_g.field_70154_o instanceof MCH_EntityAircraft) {
/* 252 */         ac = (MCH_EntityAircraft)this.mc.field_71439_g.field_70154_o;
/* 253 */       } else if (this.mc.field_71439_g.field_70154_o instanceof MCH_EntitySeat) {
/* 254 */         ac = ((MCH_EntitySeat)this.mc.field_71439_g.field_70154_o).getParent();
/* 255 */       }  if (ac != null && ac.getAcInfo() != null && (ac.getAcInfo()).name.equalsIgnoreCase("ac-130")) {
/* 256 */         int x = 0, y = 300, z = 0;
/* 257 */         int counter = 0;
/* 258 */         boolean hit = false;
/* 259 */         MCH_WeaponSet ws = ac.getCurrentWeapon((Entity)this.mc.field_71439_g);
/*     */         
/* 261 */         MCH_WeaponParam prm = new MCH_WeaponParam();
/* 262 */         prm.setPosition(ac.field_70165_t, ac.field_70163_u, ac.field_70161_v);
/* 263 */         prm.entity = (Entity)ac;
/* 264 */         prm.user = (Entity)this.mc.field_71439_g;
/*     */         
/* 266 */         prm.isInfinity = ac.isInfinityAmmo(prm.user);
/* 267 */         if (prm.user != null) {
/* 268 */           MCH_WeaponSet currentWs = ac.getCurrentWeapon(prm.user);
/* 269 */           if (currentWs != null) {
/* 270 */             int sid = ac.getSeatIdByEntity(prm.user);
/* 271 */             if (ac.getAcInfo().getWeaponSetById(sid) != null) {
/* 272 */               prm.isTurret = ((MCH_AircraftInfo.Weapon)(ac.getAcInfo().getWeaponSetById(sid)).weapons.get(0)).turret;
/*     */             }
/*     */             
/* 275 */             prm.rotYaw = (prm.entity != null) ? prm.entity.field_70177_z : 0.0F;
/* 276 */             prm.rotPitch = (prm.entity != null) ? prm.entity.field_70125_A : 0.0F;
/* 277 */             prm.rotYaw += ws.rotationYaw + (ws.getCurrentWeapon()).fixRotationYaw;
/* 278 */             prm.rotPitch += ws.rotationPitch + (ws.getCurrentWeapon()).fixRotationPitch;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */             
/* 284 */             prm.rotYaw = MathHelper.func_76142_g(prm.rotYaw);
/* 285 */             prm.rotPitch = MathHelper.func_76142_g(prm.rotPitch);
/*     */             
/* 287 */             Vec3 v2 = ws.getCurrentWeapon().getShotPos(prm.entity);
/* 288 */             prm.posX += v2.field_72450_a;
/* 289 */             prm.posY += v2.field_72448_b;
/* 290 */             prm.posZ += v2.field_72449_c;
/*     */             
/* 292 */             Vec3 v1 = MCH_Lib.RotVec3(0.0D, 0.0D, 1.0D, -prm.rotYaw, -prm.rotPitch, -prm.rotRoll);
/* 293 */             MCH_EntityBullet e = new MCH_EntityBullet((World)this.mc.field_71441_e, prm.posX, prm.posY, prm.posZ, v1.field_72450_a, v1.field_72448_b, v1.field_72449_c, prm.rotYaw, prm.rotPitch, (ws.getInfo()).acceleration);
/* 294 */             e.setName((ws.getInfo()).name);
/* 295 */             e.setParameterFromWeapon(ws.getCurrentWeapon(), prm.entity, prm.user);
/*     */             
/* 297 */             e.field_70165_t += e.field_70159_w * 0.5D;
/* 298 */             e.field_70163_u += e.field_70181_x * 0.5D;
/* 299 */             e.field_70161_v += e.field_70179_y * 0.5D;
/* 300 */             while (counter < 128) {
/* 301 */               counter++;
/* 302 */               e.simulateOnUpdate();
/* 303 */               x = (int)e.field_70165_t;
/* 304 */               y = (int)e.field_70163_u;
/* 305 */               z = (int)e.field_70161_v;
/* 306 */               if (this.mc.field_71441_e.func_147439_a(x, y, z) != Blocks.field_150350_a) {
/* 307 */                 hit = true;
/* 308 */                 counter = 500;
/* 309 */                 e.func_70106_y();
/*     */               } 
/*     */             } 
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 316 */         if (this.mc.field_71439_g.func_70011_f(x, y, z) < 300.0D) {
/* 317 */           if (hit && MCH_ParticlesUtil.markPoint != null) {
/* 318 */             MCH_ParticlesUtil.markPoint.func_70107_b(x, y, z);
/*     */           } else {
/* 320 */             MCH_GuiTargetMarker.markPoint(x, y, z);
/*     */           } 
/* 322 */           MCH_ParticlesUtil.markPoint.isFromBallisticCalculator = true;
/*     */         } else {
/* 324 */           MCH_ParticlesUtil.clearMarkPoint();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static double getCurrentStickX() {
/* 332 */     return mouseRollDeltaX;
/*     */   }
/*     */   
/*     */   public static double getCurrentStickY() {
/* 336 */     double inv = 1.0D;
/* 337 */     if ((Minecraft.func_71410_x()).field_71474_y.field_74338_d) {
/* 338 */       inv = -inv;
/*     */     }
/*     */     
/* 341 */     MCH_Config var10000 = MCH_MOD.config;
/* 342 */     if (MCH_Config.InvertMouse.prmBool) {
/* 343 */       inv = -inv;
/*     */     }
/*     */     
/* 346 */     return mouseRollDeltaY * inv;
/*     */   }
/*     */   
/*     */   public static double getMaxStickLength() {
/* 350 */     return 40.0D;
/*     */   }
/*     */ 
/*     */   
/*     */   public void updateMouseDelta(boolean stickMode, float partialTicks) {
/* 355 */     prevMouseDeltaX = mouseDeltaX;
/* 356 */     prevMouseDeltaY = mouseDeltaY;
/* 357 */     mouseDeltaX = 0.0D;
/* 358 */     mouseDeltaY = 0.0D;
/* 359 */     if (this.mc.field_71415_G && Display.isActive() && this.mc.field_71462_r == null) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */       
/* 373 */       this.mc.field_71417_B.func_74374_c();
/* 374 */       float f1 = this.mc.field_71474_y.field_74341_c * 0.6F + 0.2F;
/* 375 */       float f2 = f1 * f1 * f1 * 8.0F;
/* 376 */       MCH_Config var10000 = MCH_MOD.config;
/* 377 */       double ms = MCH_Config.MouseSensitivity.prmDouble * 0.1D;
/* 378 */       mouseDeltaX = ms * this.mc.field_71417_B.field_74377_a * f2;
/* 379 */       mouseDeltaY = ms * this.mc.field_71417_B.field_74375_b * f2;
/* 380 */       byte inv = 1;
/* 381 */       if (this.mc.field_71474_y.field_74338_d) {
/* 382 */         inv = -1;
/*     */       }
/*     */       
/* 385 */       var10000 = MCH_MOD.config;
/* 386 */       if (MCH_Config.InvertMouse.prmBool) {
/* 387 */         inv = (byte)(inv * -1);
/*     */       }
/*     */       
/* 390 */       mouseRollDeltaX += mouseDeltaX;
/* 391 */       mouseRollDeltaY += mouseDeltaY * inv;
/* 392 */       double dist = mouseRollDeltaX * mouseRollDeltaX + mouseRollDeltaY * mouseRollDeltaY;
/* 393 */       if (dist > 1.0D) {
/* 394 */         dist = MathHelper.func_76133_a(dist);
/* 395 */         double d = dist;
/* 396 */         if (dist > getMaxStickLength()) {
/* 397 */           d = getMaxStickLength();
/*     */         }
/*     */         
/* 400 */         mouseRollDeltaX /= dist;
/* 401 */         mouseRollDeltaY /= dist;
/* 402 */         mouseRollDeltaX *= d;
/* 403 */         mouseRollDeltaY *= d;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   public void onRenderTickPre(float partialTicks) {
/*     */     long currentTimeMillis;
/*     */     long n;
/* 414 */     if ((n = (currentTimeMillis = System.currentTimeMillis()) - lastFrameTime) < 0L) {
/* 415 */       lastFrameTime = currentTimeMillis;
/*     */       return;
/*     */     } 
/* 418 */     if (n < 4L) {
/* 419 */       n = 0L;
/*     */     } else {
/* 421 */       lastFrameTime = currentTimeMillis;
/*     */     } 
/* 423 */     if (!MCH_ServerSettings.enableDebugBoundingBox) {
/* 424 */       RenderManager.field_85095_o = false;
/*     */     }
/*     */     
/* 427 */     MCH_ClientEventHook.haveSearchLightAircraft.clear();
/* 428 */     if (this.mc != null && this.mc.field_71441_e != null) {
/* 429 */       Iterator player = (Minecraft.func_71410_x()).field_71441_e.field_72996_f.iterator();
/*     */       
/* 431 */       while (player.hasNext()) {
/* 432 */         Object currentItemstack = player.next();
/* 433 */         if (currentItemstack instanceof MCH_EntityAircraft && ((MCH_EntityAircraft)currentItemstack).haveSearchLight()) {
/* 434 */           MCH_ClientEventHook.haveSearchLightAircraft.add((MCH_EntityAircraft)currentItemstack);
/*     */         }
/*     */       } 
/*     */     } 
/*     */     
/* 439 */     if (!W_McClient.isGamePaused()) {
/* 440 */       EntityClientPlayerMP var17 = this.mc.field_71439_g;
/* 441 */       if (var17 != null) {
/* 442 */         ItemStack var18 = var17.func_71045_bC();
/* 443 */         if (var18 != null && var18.func_77973_b() instanceof mcheli.tool.MCH_ItemWrench && var17.func_71052_bv() > 0) {
/* 444 */           W_Reflection.setItemRendererProgress(1.0F);
/*     */         }
/*     */         
/* 447 */         ridingAircraft = MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)var17);
/* 448 */         if (ridingAircraft != null) {
/* 449 */           cameraMode = ridingAircraft.getCameraMode((EntityPlayer)var17);
/* 450 */         } else if (var17.field_70154_o instanceof MCH_EntityGLTD) {
/* 451 */           MCH_EntityGLTD ac = (MCH_EntityGLTD)var17.field_70154_o;
/* 452 */           cameraMode = ac.camera.getMode(0);
/*     */         } else {
/* 454 */           cameraMode = 0;
/*     */         } 
/*     */         
/* 457 */         MCH_EntityAircraft var19 = null;
/* 458 */         if (!(var17.field_70154_o instanceof mcheli.helicopter.MCH_EntityHeli) && !(var17.field_70154_o instanceof mcheli.plane.MCP_EntityPlane) && !(var17.field_70154_o instanceof mcheli.tank.MCH_EntityTank)) {
/* 459 */           if (var17.field_70154_o instanceof MCH_EntityUavStation) {
/* 460 */             var19 = ((MCH_EntityUavStation)var17.field_70154_o).getControlAircract();
/* 461 */           } else if (var17.field_70154_o instanceof mcheli.vehicle.MCH_EntityVehicle) {
/* 462 */             MCH_EntityAircraft stickMode = (MCH_EntityAircraft)var17.field_70154_o;
/* 463 */             stickMode.setupAllRiderRenderPosition(partialTicks, (EntityPlayer)var17);
/*     */           } 
/*     */         } else {
/* 466 */           var19 = (MCH_EntityAircraft)var17.field_70154_o;
/*     */         } 
/*     */         
/* 469 */         boolean var20 = false;
/*     */         
/* 471 */         if (var19 instanceof mcheli.helicopter.MCH_EntityHeli) {
/* 472 */           MCH_Config var10000 = MCH_MOD.config;
/* 473 */           var20 = MCH_Config.MouseControlStickModeHeli.prmBool;
/*     */         } 
/*     */         
/* 476 */         if (var19 instanceof mcheli.plane.MCP_EntityPlane) {
/* 477 */           MCH_Config var10000 = MCH_MOD.config;
/* 478 */           var20 = MCH_Config.MouseControlStickModePlane.prmBool;
/*     */         } 
/*     */         
/* 481 */         for (int de = 0; de < 10 && prevTick > partialTicks; de++) {
/* 482 */           prevTick--;
/*     */         }
/*     */ 
/*     */ 
/*     */         
/* 487 */         if (var19 != null && var19.canMouseRot()) {
/* 488 */           if (!isRideAircraft) {
/* 489 */             var19.onInteractFirst((EntityPlayer)var17);
/*     */           }
/*     */           
/* 492 */           isRideAircraft = true;
/* 493 */           updateMouseDelta(var20, partialTicks);
/* 494 */           boolean var22 = false;
/* 495 */           float var23 = 0.0F;
/* 496 */           float var25 = 0.0F;
/* 497 */           MCH_SeatInfo var26 = var19.getSeatInfo((Entity)var17);
/* 498 */           if (var26 != null && var26.fixRot && var19.getIsGunnerMode((Entity)var17) && !var19.isGunnerLookMode((EntityPlayer)var17)) {
/* 499 */             var22 = true;
/* 500 */             var23 = var26.fixYaw;
/* 501 */             var25 = var26.fixPitch;
/* 502 */             mouseRollDeltaX *= 0.0D;
/* 503 */             mouseRollDeltaY *= 0.0D;
/* 504 */             mouseDeltaX *= 0.0D;
/* 505 */             mouseDeltaY *= 0.0D;
/* 506 */           } else if (var19.isPilot((Entity)var17)) {
/* 507 */             MCH_AircraftInfo.CameraPosition var28 = var19.getCameraPosInfo();
/* 508 */             if (var28 != null) {
/* 509 */               var23 = var28.yaw;
/* 510 */               var25 = var28.pitch;
/*     */             } 
/*     */           } 
/*     */           
/* 514 */           if (var19.getAcInfo() == null) {
/* 515 */             var17.func_70082_c((float)mouseDeltaX, (float)mouseDeltaY);
/*     */           }
/*     */           else {
/*     */             
/* 519 */             var19.setAngles((Entity)var17, (float)(mouseDeltaX + prevMouseDeltaX) / 2.0F, (float)(mouseDeltaY + prevMouseDeltaY) / 2.0F, (float)mouseRollDeltaX, (float)mouseRollDeltaY, (float)Math.min(100L, n) / 50.0F);
/*     */           } 
/*     */           
/* 522 */           var19.setupAllRiderRenderPosition(partialTicks, (EntityPlayer)var17);
/* 523 */           double var29 = MathHelper.func_76133_a(mouseRollDeltaX * mouseRollDeltaX + mouseRollDeltaY * mouseRollDeltaY);
/* 524 */           if (!var20 || var29 < getMaxStickLength() * 0.1D) {
/* 525 */             mouseRollDeltaX *= 0.95D;
/* 526 */             mouseRollDeltaY *= 0.95D;
/*     */           } 
/*     */           
/* 529 */           float p = MathHelper.func_76142_g(var19.getRotRoll());
/* 530 */           float r = MathHelper.func_76142_g(var19.getRotYaw() - var17.field_70177_z);
/* 531 */           p *= MathHelper.func_76134_b((float)(r * Math.PI / 180.0D));
/* 532 */           if (var19.getTVMissile() != null && W_Lib.isClientPlayer((var19.getTVMissile()).shootingEntity) && var19.getIsGunnerMode((Entity)var17)) {
/* 533 */             p = 0.0F;
/*     */           }
/*     */           
/* 536 */           W_Reflection.setCameraRoll(p);
/* 537 */           correctViewEntityDummy((Entity)var17);
/*     */         } else {
/* 539 */           MCH_EntitySeat var21 = (var17.field_70154_o instanceof MCH_EntitySeat) ? (MCH_EntitySeat)var17.field_70154_o : null;
/* 540 */           if (var21 != null && var21.getParent() != null) {
/* 541 */             updateMouseDelta(var20, partialTicks);
/* 542 */             var19 = var21.getParent();
/* 543 */             boolean wi = false;
/* 544 */             MCH_SeatInfo seatInfo = var19.getSeatInfo((Entity)var17);
/* 545 */             if (seatInfo != null && seatInfo.fixRot && var19.getIsGunnerMode((Entity)var17) && !var19.isGunnerLookMode((EntityPlayer)var17)) {
/* 546 */               wi = true;
/* 547 */               mouseRollDeltaX *= 0.0D;
/* 548 */               mouseRollDeltaY *= 0.0D;
/* 549 */               mouseDeltaX *= 0.0D;
/* 550 */               mouseDeltaY *= 0.0D;
/*     */             } 
/*     */             
/* 553 */             Vec3 v = Vec3.func_72443_a(mouseDeltaX, mouseRollDeltaY, 0.0D);
/* 554 */             W_Vec3.rotateAroundZ((float)((var19.calcRotRoll(partialTicks) / 180.0F) * Math.PI), v);
/* 555 */             MCH_WeaponSet ws = var19.getCurrentWeapon((Entity)var17);
/* 556 */             mouseDeltaY *= (ws != null && ws.getInfo() != null) ? (ws.getInfo()).cameraRotationSpeedPitch : 1.0D;
/* 557 */             var17.func_70082_c((float)mouseDeltaX, (float)mouseDeltaY);
/* 558 */             float y = var19.getRotYaw();
/* 559 */             float p = var19.getRotPitch();
/* 560 */             float r = var19.getRotRoll();
/* 561 */             var19.setRotYaw(var19.calcRotYaw(partialTicks));
/* 562 */             var19.setRotPitch(var19.calcRotPitch(partialTicks));
/* 563 */             var19.setRotRoll(var19.calcRotRoll(partialTicks));
/* 564 */             float revRoll = 0.0F;
/* 565 */             if (wi) {
/* 566 */               var17.field_70177_z = var19.getRotYaw() + seatInfo.fixYaw;
/* 567 */               var17.field_70125_A = var19.getRotPitch() + seatInfo.fixPitch;
/* 568 */               if (var17.field_70125_A > 90.0F) {
/* 569 */                 var17.field_70127_C -= (var17.field_70125_A - 90.0F) * 2.0F;
/* 570 */                 var17.field_70125_A -= (var17.field_70125_A - 90.0F) * 2.0F;
/* 571 */                 var17.field_70126_B += 180.0F;
/* 572 */                 var17.field_70177_z += 180.0F;
/* 573 */                 revRoll = 180.0F;
/* 574 */               } else if (var17.field_70125_A < -90.0F) {
/* 575 */                 var17.field_70127_C -= (var17.field_70125_A - 90.0F) * 2.0F;
/* 576 */                 var17.field_70125_A -= (var17.field_70125_A - 90.0F) * 2.0F;
/* 577 */                 var17.field_70126_B += 180.0F;
/* 578 */                 var17.field_70177_z += 180.0F;
/* 579 */                 revRoll = 180.0F;
/*     */               } 
/*     */             } 
/*     */             
/* 583 */             var19.setupAllRiderRenderPosition(partialTicks, (EntityPlayer)var17);
/* 584 */             var19.setRotYaw(y);
/* 585 */             var19.setRotPitch(p);
/* 586 */             var19.setRotRoll(r);
/* 587 */             mouseRollDeltaX *= 0.9D;
/* 588 */             mouseRollDeltaY *= 0.9D;
/* 589 */             float roll = MathHelper.func_76142_g(var19.getRotRoll());
/* 590 */             float yaw = MathHelper.func_76142_g(var19.getRotYaw() - var17.field_70177_z);
/* 591 */             roll *= MathHelper.func_76134_b((float)(yaw * Math.PI / 180.0D));
/* 592 */             if (var19.getTVMissile() != null && W_Lib.isClientPlayer((var19.getTVMissile()).shootingEntity) && var19.getIsGunnerMode((Entity)var17)) {
/* 593 */               roll = 0.0F;
/*     */             }
/*     */             
/* 596 */             W_Reflection.setCameraRoll(roll + revRoll);
/* 597 */             correctViewEntityDummy((Entity)var17);
/*     */           } else {
/* 599 */             if (isRideAircraft) {
/* 600 */               W_Reflection.setCameraRoll(0.0F);
/* 601 */               isRideAircraft = false;
/*     */             } 
/*     */             
/* 604 */             mouseRollDeltaX = 0.0D;
/* 605 */             mouseRollDeltaY = 0.0D;
/*     */           } 
/*     */         } 
/*     */         
/* 609 */         if (var19 != null) {
/* 610 */           if (var19.getSeatIdByEntity((Entity)var17) == 0 && !var19.isDestroyed()) {
/* 611 */             var19.lastRiderYaw = var17.field_70177_z;
/* 612 */             var19.prevLastRiderYaw = var17.field_70126_B;
/* 613 */             var19.lastRiderPitch = var17.field_70125_A;
/* 614 */             var19.prevLastRiderPitch = var17.field_70127_C;
/*     */           } 
/*     */           
/* 617 */           var19.updateWeaponsRotation();
/*     */         } 
/*     */         
/* 620 */         MCH_ViewEntityDummy var24 = MCH_ViewEntityDummy.getInstance(var17.field_70170_p);
/* 621 */         if (var24 != null) {
/* 622 */           var24.field_70177_z = var17.field_70177_z;
/* 623 */           var24.field_70126_B = var17.field_70126_B;
/* 624 */           if (var19 != null) {
/* 625 */             MCH_WeaponSet var27 = var19.getCurrentWeapon((Entity)var17);
/* 626 */             if (var27 != null && var27.getInfo() != null && (var27.getInfo()).fixCameraPitch) {
/* 627 */               var24.field_70125_A = var24.field_70127_C = 0.0F;
/*     */             }
/*     */           } 
/*     */         } 
/*     */         
/* 632 */         prevTick = partialTicks;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void correctViewEntityDummy(Entity entity) {
/* 638 */     MCH_ViewEntityDummy de = MCH_ViewEntityDummy.getInstance(entity.field_70170_p);
/* 639 */     if (de != null) {
/* 640 */       if (de.field_70177_z - de.field_70126_B > 180.0F) {
/* 641 */         de.field_70126_B += 360.0F;
/* 642 */       } else if (de.field_70177_z - de.field_70126_B < -180.0F) {
/* 643 */         de.field_70126_B -= 360.0F;
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerTickPre(EntityPlayer player) {
/* 650 */     if (player.field_70170_p.field_72995_K) {
/* 651 */       ItemStack currentItemstack = player.func_71045_bC();
/* 652 */       if (currentItemstack != null && currentItemstack.func_77973_b() instanceof mcheli.tool.MCH_ItemWrench && player.func_71052_bv() > 0 && player.func_71011_bu() != currentItemstack) {
/* 653 */         int maxdm = currentItemstack.func_77958_k();
/* 654 */         int dm = currentItemstack.func_77960_j();
/* 655 */         if (dm <= maxdm && dm > 0) {
/* 656 */           player.func_71008_a(currentItemstack, player.func_71052_bv());
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void onPlayerTickPost(EntityPlayer player) {}
/*     */ 
/*     */   
/*     */   public void onRenderTickPost(float partialTicks) {
/* 667 */     if (this.mc.field_71439_g != null) {
/* 668 */       MCH_ClientTickHandlerBase.applyRotLimit((Entity)this.mc.field_71439_g);
/* 669 */       MCH_ViewEntityDummy arr$ = MCH_ViewEntityDummy.getInstance(this.mc.field_71439_g.field_70170_p);
/* 670 */       if (arr$ != null) {
/* 671 */         arr$.field_70125_A = this.mc.field_71439_g.field_70125_A;
/* 672 */         arr$.field_70177_z = this.mc.field_71439_g.field_70177_z;
/* 673 */         arr$.field_70127_C = this.mc.field_71439_g.field_70127_C;
/* 674 */         arr$.field_70126_B = this.mc.field_71439_g.field_70126_B;
/*     */       } 
/*     */     } 
/*     */     
/* 678 */     if (this.mc.field_71462_r == null || this.mc.field_71462_r instanceof net.minecraft.client.gui.GuiChat || this.mc.field_71462_r.getClass().toString().indexOf("GuiDriveableController") >= 0) {
/* 679 */       MCH_Gui[] var6 = this.guis;
/* 680 */       int len$ = var6.length;
/*     */       
/* 682 */       for (int i$ = 0; i$ < len$; i$++) {
/* 683 */         MCH_Gui gui = var6[i$];
/* 684 */         if (drawGui(gui, partialTicks)) {
/*     */           break;
/*     */         }
/*     */       } 
/*     */       
/* 689 */       drawGui((MCH_Gui)this.gui_Common, partialTicks);
/* 690 */       drawGui(this.gui_Wrench, partialTicks);
/* 691 */       drawGui(this.gui_SwnGnr, partialTicks);
/* 692 */       drawGui(this.gui_EMarker, partialTicks);
/* 693 */       if (isDrawScoreboard) {
/* 694 */         MCH_GuiScoreboard.drawList(this.mc, this.mc.field_71466_p, false);
/*     */       }
/*     */       
/* 697 */       drawGui(this.gui_Title, partialTicks);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public boolean drawGui(MCH_Gui gui, float partialTicks) {
/* 703 */     if (gui.isDrawGui((EntityPlayer)this.mc.field_71439_g)) {
/* 704 */       gui.func_73863_a(0, 0, partialTicks);
/* 705 */       return true;
/*     */     } 
/* 707 */     return false;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_ClientCommonTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */