/*     */ package mcheli.gui;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_PacketNotifyInfoReloaded;
/*     */ import mcheli.multiplay.MCH_GuiTargetMarker;
/*     */ import mcheli.weapon.MCH_WeaponInfoManager;
/*     */ import mcheli.wrapper.W_GuiButton;
/*     */ import mcheli.wrapper.W_GuiContainer;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_ScaledResolution;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import org.lwjgl.input.Mouse;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_ConfigGui
/*     */   extends W_GuiContainer
/*     */ {
/*     */   private final EntityPlayer thePlayer;
/*     */   private int scaleFactor;
/*     */   private MCH_GuiOnOffButton buttonMouseInv;
/*     */   private MCH_GuiOnOffButton buttonStickModeHeli;
/*     */   private MCH_GuiOnOffButton buttonStickModePlane;
/*     */   private MCH_GuiOnOffButton buttonHideKeyBind;
/*     */   private MCH_GuiOnOffButton buttonShowHUDTP;
/*     */   private MCH_GuiOnOffButton buttonSmoothShading;
/*     */   private MCH_GuiOnOffButton buttonShowEntityMarker;
/*     */   private MCH_GuiOnOffButton buttonMarkThroughWall;
/*     */   private MCH_GuiOnOffButton buttonReplaceCamera;
/*     */   private MCH_GuiOnOffButton buttonNewExplosion;
/*     */   private MCH_GuiSlider sliderEntityMarkerSize;
/*     */   private MCH_GuiSlider sliderBlockMarkerSize;
/*     */   private MCH_GuiSlider sliderSensitivity;
/*     */   private MCH_GuiSlider[] sliderHitMark;
/*     */   private MCH_GuiOnOffButton buttonTestMode;
/*     */   private MCH_GuiOnOffButton buttonThrottleHeli;
/*     */   private MCH_GuiOnOffButton buttonThrottlePlane;
/*     */   private MCH_GuiOnOffButton buttonThrottleTank;
/*     */   private MCH_GuiOnOffButton buttonFlightSimMode;
/*     */   private MCH_GuiOnOffButton buttonSwitchWeaponWheel;
/*     */   private W_GuiButton buttonReloadAircraftInfo;
/*     */   private W_GuiButton buttonReloadWeaponInfo;
/*     */   private W_GuiButton buttonReloadAllHUD;
/*     */   public List listControlButtons;
/*     */   public List listRenderButtons;
/*     */   public List listKeyBindingButtons;
/*     */   public List listDevelopButtons;
/*     */   public MCH_GuiList keyBindingList;
/*     */   public int waitKeyButtonId;
/*     */   public int waitKeyAcceptCount;
/*     */   public static final int BUTTON_RENDER = 50;
/*     */   public static final int BUTTON_KEY_BINDING = 51;
/*     */   public static final int BUTTON_PREV_CONTROL = 52;
/*     */   public static final int BUTTON_DEVELOP = 55;
/*     */   public static final int BUTTON_KEY_LIST = 53;
/*     */   public static final int BUTTON_KEY_RESET_ALL = 54;
/*     */   public static final int BUTTON_KEY_LIST_BASE = 200;
/*     */   public static final int BUTTON_KEY_RESET_BASE = 300;
/*     */   public static final int BUTTON_DEV_RELOAD_AC = 400;
/*     */   public static final int BUTTON_DEV_RELOAD_WEAPON = 401;
/*     */   public static final int BUTTON_DEV_RELOAD_HUD = 402;
/*     */   public static final int BUTTON_SAVE_CLOSE = 100;
/*     */   public static final int BUTTON_CANCEL = 101;
/*  74 */   public int currentScreenId = 0;
/*     */   public static final int SCREEN_CONTROLS = 0;
/*     */   public static final int SCREEN_RENDER = 1;
/*     */   public static final int SCREEN_KEY_BIND = 2;
/*     */   public static final int SCREEN_DEVELOP = 3;
/*  79 */   private int ignoreButtonCounter = 0;
/*     */ 
/*     */   
/*     */   public MCH_ConfigGui(EntityPlayer player) {
/*  83 */     super(new MCH_ConfigGuiContainer(player));
/*  84 */     this.thePlayer = player;
/*  85 */     this.field_146999_f = 330;
/*  86 */     this.field_147000_g = 200;
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  90 */     super.func_73866_w_();
/*  91 */     this.field_146292_n.clear();
/*  92 */     int x1 = this.field_147003_i + 10;
/*  93 */     int x2 = this.field_147003_i + 10 + 150 + 10;
/*  94 */     int y = this.field_147009_r;
/*  95 */     boolean DY = true;
/*  96 */     this.listControlButtons = new ArrayList();
/*  97 */     this.buttonMouseInv = new MCH_GuiOnOffButton(0, x1, y + 25, 150, 20, "Invert Mouse : ");
/*  98 */     this.sliderSensitivity = new MCH_GuiSlider(0, x1, y + 50, 150, 20, "Sensitivity : %.1f", 0.0F, 0.0F, 30.0F, 0.1F);
/*  99 */     this.buttonFlightSimMode = new MCH_GuiOnOffButton(0, x1, y + 75, 150, 20, "Mouse Flight Sim Mode : ");
/* 100 */     this.buttonSwitchWeaponWheel = new MCH_GuiOnOffButton(0, x1, y + 100, 150, 20, "Switch Weapon Wheel : ");
/* 101 */     this.listControlButtons.add(new W_GuiButton(50, x1, y + 125, 150, 20, "Render Settings >>"));
/* 102 */     this.listControlButtons.add(new W_GuiButton(51, x1, y + 150, 150, 20, "Key Binding >>"));
/* 103 */     this.listControlButtons.add(new W_GuiButton(55, x2, y + 150, 150, 20, "Development >>"));
/* 104 */     this.buttonTestMode = new MCH_GuiOnOffButton(0, x1, y + 175, 150, 20, "Test Mode : ");
/* 105 */     this.buttonStickModeHeli = new MCH_GuiOnOffButton(0, x2, y + 25, 150, 20, "Stick Mode Heli : ");
/* 106 */     this.buttonStickModePlane = new MCH_GuiOnOffButton(0, x2, y + 50, 150, 20, "Stick Mode Plane : ");
/* 107 */     this.buttonThrottleHeli = new MCH_GuiOnOffButton(0, x2, y + 75, 150, 20, "Throttle Down Heli : ");
/* 108 */     this.buttonThrottlePlane = new MCH_GuiOnOffButton(0, x2, y + 100, 150, 20, "Throttle Down Plane : ");
/* 109 */     this.buttonThrottleTank = new MCH_GuiOnOffButton(0, x2, y + 125, 150, 20, "Throttle Down Tank : ");
/* 110 */     this.listControlButtons.add(this.buttonMouseInv);
/* 111 */     this.listControlButtons.add(this.buttonStickModeHeli);
/* 112 */     this.listControlButtons.add(this.buttonStickModePlane);
/* 113 */     this.listControlButtons.add(this.sliderSensitivity);
/* 114 */     this.listControlButtons.add(this.buttonThrottleHeli);
/* 115 */     this.listControlButtons.add(this.buttonThrottlePlane);
/* 116 */     this.listControlButtons.add(this.buttonThrottleTank);
/* 117 */     this.listControlButtons.add(this.buttonTestMode);
/* 118 */     this.listControlButtons.add(this.buttonFlightSimMode);
/* 119 */     this.listControlButtons.add(this.buttonSwitchWeaponWheel);
/* 120 */     Iterator<W_GuiButton> id = this.listControlButtons.iterator();
/*     */ 
/*     */     
/* 123 */     while (id.hasNext()) {
/* 124 */       W_GuiButton idr = id.next();
/* 125 */       this.field_146292_n.add(idr);
/*     */     } 
/*     */     
/* 128 */     this.listRenderButtons = new ArrayList();
/* 129 */     this.buttonShowHUDTP = new MCH_GuiOnOffButton(0, x1, y + 25, 150, 20, "Show HUD Third Person : ");
/* 130 */     this.buttonHideKeyBind = new MCH_GuiOnOffButton(0, x1, y + 50, 150, 20, "Hide Key Binding : ");
/* 131 */     this.sliderHitMark = new MCH_GuiSlider[] { new MCH_GuiSlider(0, x1 + 0, y + 125, 75, 20, "Alpha:%.0f", 0.0F, 0.0F, 255.0F, 16.0F), new MCH_GuiSlider(0, x1 + 75, y + 75, 75, 20, "Red:%.0f", 0.0F, 0.0F, 255.0F, 16.0F), new MCH_GuiSlider(0, x1 + 75, y + 100, 75, 20, "Green:%.0f", 0.0F, 0.0F, 255.0F, 16.0F), new MCH_GuiSlider(0, x1 + 75, y + 125, 75, 20, "Blue:%.0f", 0.0F, 0.0F, 255.0F, 16.0F) };
/* 132 */     this.buttonReplaceCamera = new MCH_GuiOnOffButton(0, x1, y + 150, 150, 20, "Change Camera Pos : ");
/* 133 */     this.listRenderButtons.add(new W_GuiButton(52, x1, y + 175, 90, 20, "Controls <<"));
/* 134 */     this.buttonSmoothShading = new MCH_GuiOnOffButton(0, x2, y + 25, 150, 20, "Smooth Shading : ");
/* 135 */     this.buttonShowEntityMarker = new MCH_GuiOnOffButton(0, x2, y + 50, 150, 20, "Show Entity Maker : ");
/* 136 */     this.sliderEntityMarkerSize = new MCH_GuiSlider(0, x2 + 30, y + 75, 120, 20, "Entity Marker Size:%.0f", 10.0F, 0.0F, 30.0F, 1.0F);
/* 137 */     this.sliderBlockMarkerSize = new MCH_GuiSlider(0, x2 + 60, y + 100, 90, 20, "Block Marker Size:%.0f", 10.0F, 0.0F, 20.0F, 1.0F);
/* 138 */     this.buttonMarkThroughWall = new MCH_GuiOnOffButton(0, x2 + 30, y + 100, 120, 20, "Mark Through Wall : ");
/* 139 */     this.buttonNewExplosion = new MCH_GuiOnOffButton(0, x2, y + 150, 150, 20, "Default Explosion : ");
/* 140 */     this.listRenderButtons.add(this.buttonShowHUDTP);
/*     */     
/* 142 */     for (int var12 = 0; var12 < this.sliderHitMark.length; var12++) {
/* 143 */       this.listRenderButtons.add(this.sliderHitMark[var12]);
/*     */     }
/*     */     
/* 146 */     this.listRenderButtons.add(this.buttonSmoothShading);
/* 147 */     this.listRenderButtons.add(this.buttonHideKeyBind);
/* 148 */     this.listRenderButtons.add(this.buttonShowEntityMarker);
/* 149 */     this.listRenderButtons.add(this.buttonReplaceCamera);
/* 150 */     this.listRenderButtons.add(this.buttonNewExplosion);
/* 151 */     this.listRenderButtons.add(this.sliderEntityMarkerSize);
/* 152 */     this.listRenderButtons.add(this.sliderBlockMarkerSize);
/* 153 */     id = this.listRenderButtons.iterator();
/*     */     
/* 155 */     while (id.hasNext()) {
/* 156 */       W_GuiButton idr = id.next();
/* 157 */       this.field_146292_n.add(idr);
/*     */     } 
/*     */     
/* 160 */     this.listKeyBindingButtons = new ArrayList();
/* 161 */     this.waitKeyButtonId = 0;
/* 162 */     this.waitKeyAcceptCount = 0;
/* 163 */     this.keyBindingList = new MCH_GuiList(53, 7, x1, y + 25 - 2, 310, 150, "");
/* 164 */     this.listKeyBindingButtons.add(this.keyBindingList);
/* 165 */     this.listKeyBindingButtons.add(new W_GuiButton(52, x1, y + 175, 90, 20, "Controls <<"));
/* 166 */     this.listKeyBindingButtons.add(new W_GuiButton(54, x1 + 90, y + 175, 60, 20, "Reset All"));
/* 167 */     boolean var13 = true;
/* 168 */     boolean var14 = true;
/* 169 */     MCH_GuiListItemKeyBind[] var10000 = new MCH_GuiListItemKeyBind[23];
/* 170 */     MCH_GuiListItemKeyBind var10003 = new MCH_GuiListItemKeyBind(200, 300, x1, "Up", MCH_Config.KeyUp);
/* 171 */     MCH_Config var10009 = MCH_MOD.config;
/* 172 */     var10000[0] = var10003;
/* 173 */     var10003 = new MCH_GuiListItemKeyBind(201, 301, x1, "Down", MCH_Config.KeyDown);
/* 174 */     var10009 = MCH_MOD.config;
/* 175 */     var10000[1] = var10003;
/* 176 */     var10003 = new MCH_GuiListItemKeyBind(202, 302, x1, "Right", MCH_Config.KeyRight);
/* 177 */     var10009 = MCH_MOD.config;
/* 178 */     var10000[2] = var10003;
/* 179 */     var10003 = new MCH_GuiListItemKeyBind(203, 303, x1, "Left", MCH_Config.KeyLeft);
/* 180 */     var10009 = MCH_MOD.config;
/* 181 */     var10000[3] = var10003;
/* 182 */     var10003 = new MCH_GuiListItemKeyBind(204, 304, x1, "Switch Gunner", MCH_Config.KeySwitchMode);
/* 183 */     var10009 = MCH_MOD.config;
/* 184 */     var10000[4] = var10003;
/* 185 */     var10003 = new MCH_GuiListItemKeyBind(205, 305, x1, "Switch Hovering", MCH_Config.KeySwitchHovering);
/* 186 */     var10009 = MCH_MOD.config;
/* 187 */     var10000[5] = var10003;
/* 188 */     var10003 = new MCH_GuiListItemKeyBind(206, 306, x1, "Switch Weapon1", MCH_Config.KeySwitchWeapon1);
/* 189 */     var10009 = MCH_MOD.config;
/* 190 */     var10000[6] = var10003;
/* 191 */     var10003 = new MCH_GuiListItemKeyBind(207, 307, x1, "Switch Weapon2", MCH_Config.KeySwitchWeapon2);
/* 192 */     var10009 = MCH_MOD.config;
/* 193 */     var10000[7] = var10003;
/* 194 */     var10003 = new MCH_GuiListItemKeyBind(208, 308, x1, "Switch Weapon Mode", MCH_Config.KeySwWeaponMode);
/* 195 */     var10009 = MCH_MOD.config;
/* 196 */     var10000[8] = var10003;
/* 197 */     var10003 = new MCH_GuiListItemKeyBind(209, 309, x1, "Zoom / Fold Wing", MCH_Config.KeyZoom);
/* 198 */     var10009 = MCH_MOD.config;
/* 199 */     var10000[9] = var10003;
/* 200 */     var10003 = new MCH_GuiListItemKeyBind(210, 310, x1, "Camera Mode", MCH_Config.KeyCameraMode);
/* 201 */     var10009 = MCH_MOD.config;
/* 202 */     var10000[10] = var10003;
/* 203 */     var10003 = new MCH_GuiListItemKeyBind(211, 311, x1, "Unmount Mobs", MCH_Config.KeyUnmount);
/* 204 */     var10009 = MCH_MOD.config;
/* 205 */     var10000[11] = var10003;
/* 206 */     var10003 = new MCH_GuiListItemKeyBind(212, 312, x1, "Flare", MCH_Config.KeyFlare);
/* 207 */     var10009 = MCH_MOD.config;
/* 208 */     var10000[12] = var10003;
/* 209 */     var10003 = new MCH_GuiListItemKeyBind(213, 313, x1, "Vtol / Drop / Fold Blade", MCH_Config.KeyExtra);
/* 210 */     var10009 = MCH_MOD.config;
/* 211 */     var10000[13] = var10003;
/* 212 */     var10003 = new MCH_GuiListItemKeyBind(214, 314, x1, "Third Person Distance Up", MCH_Config.KeyCameraDistUp);
/* 213 */     var10009 = MCH_MOD.config;
/* 214 */     var10000[14] = var10003;
/* 215 */     var10003 = new MCH_GuiListItemKeyBind(215, 315, x1, "Third Person Distance Down", MCH_Config.KeyCameraDistDown);
/* 216 */     var10009 = MCH_MOD.config;
/* 217 */     var10000[15] = var10003;
/* 218 */     var10003 = new MCH_GuiListItemKeyBind(216, 316, x1, "Switch Free Look", MCH_Config.KeyFreeLook);
/* 219 */     var10009 = MCH_MOD.config;
/* 220 */     var10000[16] = var10003;
/* 221 */     var10003 = new MCH_GuiListItemKeyBind(217, 317, x1, "Open GUI", MCH_Config.KeyGUI);
/* 222 */     var10009 = MCH_MOD.config;
/* 223 */     var10000[17] = var10003;
/* 224 */     var10003 = new MCH_GuiListItemKeyBind(218, 318, x1, "Gear Up Down", MCH_Config.KeyGearUpDown);
/* 225 */     var10009 = MCH_MOD.config;
/* 226 */     var10000[18] = var10003;
/* 227 */     var10003 = new MCH_GuiListItemKeyBind(219, 319, x1, "Put entity in the rack", MCH_Config.KeyPutToRack);
/* 228 */     var10009 = MCH_MOD.config;
/* 229 */     var10000[19] = var10003;
/* 230 */     var10003 = new MCH_GuiListItemKeyBind(220, 320, x1, "Drop entity from the rack", MCH_Config.KeyDownFromRack);
/* 231 */     var10009 = MCH_MOD.config;
/* 232 */     var10000[20] = var10003;
/* 233 */     var10003 = new MCH_GuiListItemKeyBind(221, 321, x1, "[MP]Score board", MCH_Config.KeyScoreboard);
/* 234 */     var10009 = MCH_MOD.config;
/* 235 */     var10000[21] = var10003;
/* 236 */     var10003 = new MCH_GuiListItemKeyBind(222, 322, x1, "[MP][OP]Multiplay manager", MCH_Config.KeyMultiplayManager);
/* 237 */     var10009 = MCH_MOD.config;
/* 238 */     var10000[22] = var10003;
/* 239 */     MCH_GuiListItemKeyBind[] listKeyBindItems = var10000;
/* 240 */     MCH_GuiListItemKeyBind[] i$ = listKeyBindItems;
/* 241 */     int b = listKeyBindItems.length;
/*     */     
/* 243 */     for (int i$1 = 0; i$1 < b; i$1++) {
/* 244 */       MCH_GuiListItemKeyBind item = i$[i$1];
/* 245 */       this.keyBindingList.addItem(item);
/*     */     } 
/*     */     
/* 248 */     Iterator<W_GuiButton> var15 = this.listKeyBindingButtons.iterator();
/*     */ 
/*     */     
/* 251 */     while (var15.hasNext()) {
/* 252 */       W_GuiButton var16 = var15.next();
/* 253 */       this.field_146292_n.add(var16);
/*     */     } 
/*     */     
/* 256 */     this.listDevelopButtons = new ArrayList();
/* 257 */     if (Minecraft.func_71410_x().func_71356_B()) {
/* 258 */       this.buttonReloadAircraftInfo = new W_GuiButton(400, x1, y + 50, 150, 20, "Reload aircraft setting");
/* 259 */       this.buttonReloadWeaponInfo = new W_GuiButton(401, x1, y + 75, 150, 20, "Reload All Weapons");
/* 260 */       this.buttonReloadAllHUD = new W_GuiButton(402, x1, y + 100, 150, 20, "Reload All HUD");
/* 261 */       this.listDevelopButtons.add(this.buttonReloadAircraftInfo);
/* 262 */       this.listDevelopButtons.add(this.buttonReloadWeaponInfo);
/* 263 */       this.listDevelopButtons.add(this.buttonReloadAllHUD);
/*     */     } 
/*     */     
/* 266 */     this.listDevelopButtons.add(new W_GuiButton(52, x1, y + 175, 90, 20, "Controls <<"));
/* 267 */     var15 = this.listDevelopButtons.iterator();
/*     */     
/* 269 */     while (var15.hasNext()) {
/* 270 */       W_GuiButton var16 = var15.next();
/* 271 */       this.field_146292_n.add(var16);
/*     */     } 
/*     */     
/* 274 */     this.field_146292_n.add(new GuiButton(100, x2, y + 175, 80, 20, "Save & Close"));
/* 275 */     this.field_146292_n.add(new GuiButton(101, x2 + 90, y + 175, 60, 20, "Cancel"));
/* 276 */     switchScreen(0);
/* 277 */     applySwitchScreen();
/* 278 */     getAllStatusFromConfig();
/*     */   }
/*     */   
/*     */   public boolean canButtonClick() {
/* 282 */     return (this.ignoreButtonCounter <= 0);
/*     */   }
/*     */   
/*     */   public void getAllStatusFromConfig() {
/* 286 */     MCH_Config var10001 = MCH_MOD.config;
/* 287 */     this.buttonMouseInv.setOnOff(MCH_Config.InvertMouse.prmBool);
/* 288 */     var10001 = MCH_MOD.config;
/* 289 */     this.buttonStickModeHeli.setOnOff(MCH_Config.MouseControlStickModeHeli.prmBool);
/* 290 */     var10001 = MCH_MOD.config;
/* 291 */     this.buttonStickModePlane.setOnOff(MCH_Config.MouseControlStickModePlane.prmBool);
/* 292 */     var10001 = MCH_MOD.config;
/* 293 */     this.sliderSensitivity.setSliderValue((float)MCH_Config.MouseSensitivity.prmDouble);
/* 294 */     var10001 = MCH_MOD.config;
/* 295 */     this.buttonShowHUDTP.setOnOff(MCH_Config.DisplayHUDThirdPerson.prmBool);
/* 296 */     var10001 = MCH_MOD.config;
/* 297 */     this.buttonSmoothShading.setOnOff(MCH_Config.SmoothShading.prmBool);
/* 298 */     var10001 = MCH_MOD.config;
/* 299 */     this.buttonHideKeyBind.setOnOff(MCH_Config.HideKeybind.prmBool);
/* 300 */     var10001 = MCH_MOD.config;
/* 301 */     this.buttonShowEntityMarker.setOnOff(MCH_Config.DisplayEntityMarker.prmBool);
/* 302 */     var10001 = MCH_MOD.config;
/* 303 */     this.buttonMarkThroughWall.setOnOff(MCH_Config.DisplayMarkThroughWall.prmBool);
/* 304 */     var10001 = MCH_MOD.config;
/* 305 */     this.sliderEntityMarkerSize.setSliderValue((float)MCH_Config.EntityMarkerSize.prmDouble);
/* 306 */     var10001 = MCH_MOD.config;
/* 307 */     this.sliderBlockMarkerSize.setSliderValue((float)MCH_Config.BlockMarkerSize.prmDouble);
/* 308 */     var10001 = MCH_MOD.config;
/* 309 */     this.buttonReplaceCamera.setOnOff(MCH_Config.ReplaceRenderViewEntity.prmBool);
/* 310 */     var10001 = MCH_MOD.config;
/* 311 */     this.buttonNewExplosion.setOnOff(MCH_Config.DefaultExplosionParticle.prmBool);
/* 312 */     MCH_GuiSlider var10000 = this.sliderHitMark[0];
/* 313 */     var10001 = MCH_MOD.config;
/* 314 */     var10000.setSliderValue(MCH_Config.hitMarkColorAlpha * 255.0F);
/* 315 */     var10000 = this.sliderHitMark[1];
/* 316 */     var10001 = MCH_MOD.config;
/* 317 */     var10000.setSliderValue((MCH_Config.hitMarkColorRGB >> 16 & 0xFF));
/* 318 */     var10000 = this.sliderHitMark[2];
/* 319 */     var10001 = MCH_MOD.config;
/* 320 */     var10000.setSliderValue((MCH_Config.hitMarkColorRGB >> 8 & 0xFF));
/* 321 */     var10000 = this.sliderHitMark[3];
/* 322 */     var10001 = MCH_MOD.config;
/* 323 */     var10000.setSliderValue((MCH_Config.hitMarkColorRGB >> 0 & 0xFF));
/* 324 */     var10001 = MCH_MOD.config;
/* 325 */     this.buttonThrottleHeli.setOnOff(MCH_Config.AutoThrottleDownHeli.prmBool);
/* 326 */     var10001 = MCH_MOD.config;
/* 327 */     this.buttonThrottlePlane.setOnOff(MCH_Config.AutoThrottleDownPlane.prmBool);
/* 328 */     var10001 = MCH_MOD.config;
/* 329 */     this.buttonThrottleTank.setOnOff(MCH_Config.AutoThrottleDownTank.prmBool);
/* 330 */     var10001 = MCH_MOD.config;
/* 331 */     this.buttonTestMode.setOnOff(MCH_Config.TestMode.prmBool);
/* 332 */     var10001 = MCH_MOD.config;
/* 333 */     this.buttonFlightSimMode.setOnOff(MCH_Config.MouseControlFlightSimMode.prmBool);
/* 334 */     var10001 = MCH_MOD.config;
/* 335 */     this.buttonSwitchWeaponWheel.setOnOff(MCH_Config.SwitchWeaponWithMouseWheel.prmBool);
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
/*     */   public void saveAndApplyConfig() {
/*     */     // Byte code:
/*     */     //   0: iconst_0
/*     */     //   1: istore_2
/*     */     //   2: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   5: astore_1
/*     */     //   6: getstatic mcheli/MCH_Config.InvertMouse : Lmcheli/MCH_ConfigPrm;
/*     */     //   9: aload_0
/*     */     //   10: getfield buttonMouseInv : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   13: invokevirtual getOnOff : ()Z
/*     */     //   16: invokevirtual setPrm : (Z)V
/*     */     //   19: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   22: astore_1
/*     */     //   23: getstatic mcheli/MCH_Config.MouseControlStickModeHeli : Lmcheli/MCH_ConfigPrm;
/*     */     //   26: aload_0
/*     */     //   27: getfield buttonStickModeHeli : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   30: invokevirtual getOnOff : ()Z
/*     */     //   33: invokevirtual setPrm : (Z)V
/*     */     //   36: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   39: astore_1
/*     */     //   40: getstatic mcheli/MCH_Config.MouseControlStickModePlane : Lmcheli/MCH_ConfigPrm;
/*     */     //   43: aload_0
/*     */     //   44: getfield buttonStickModePlane : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   47: invokevirtual getOnOff : ()Z
/*     */     //   50: invokevirtual setPrm : (Z)V
/*     */     //   53: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   56: astore_1
/*     */     //   57: getstatic mcheli/MCH_Config.MouseControlFlightSimMode : Lmcheli/MCH_ConfigPrm;
/*     */     //   60: aload_0
/*     */     //   61: getfield buttonFlightSimMode : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   64: invokevirtual getOnOff : ()Z
/*     */     //   67: invokevirtual setPrm : (Z)V
/*     */     //   70: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   73: astore_1
/*     */     //   74: getstatic mcheli/MCH_Config.SwitchWeaponWithMouseWheel : Lmcheli/MCH_ConfigPrm;
/*     */     //   77: aload_0
/*     */     //   78: getfield buttonSwitchWeaponWheel : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   81: invokevirtual getOnOff : ()Z
/*     */     //   84: invokevirtual setPrm : (Z)V
/*     */     //   87: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   90: astore_1
/*     */     //   91: getstatic mcheli/MCH_Config.MouseSensitivity : Lmcheli/MCH_ConfigPrm;
/*     */     //   94: aload_0
/*     */     //   95: getfield sliderSensitivity : Lmcheli/gui/MCH_GuiSlider;
/*     */     //   98: iconst_1
/*     */     //   99: invokevirtual getSliderValueInt : (I)F
/*     */     //   102: f2d
/*     */     //   103: invokevirtual setPrm : (D)V
/*     */     //   106: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   109: astore_1
/*     */     //   110: getstatic mcheli/MCH_Config.DisplayHUDThirdPerson : Lmcheli/MCH_ConfigPrm;
/*     */     //   113: aload_0
/*     */     //   114: getfield buttonShowHUDTP : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   117: invokevirtual getOnOff : ()Z
/*     */     //   120: invokevirtual setPrm : (Z)V
/*     */     //   123: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   126: astore_1
/*     */     //   127: getstatic mcheli/MCH_Config.SmoothShading : Lmcheli/MCH_ConfigPrm;
/*     */     //   130: aload_0
/*     */     //   131: getfield buttonSmoothShading : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   134: invokevirtual getOnOff : ()Z
/*     */     //   137: invokevirtual setPrm : (Z)V
/*     */     //   140: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   143: astore_1
/*     */     //   144: getstatic mcheli/MCH_Config.HideKeybind : Lmcheli/MCH_ConfigPrm;
/*     */     //   147: aload_0
/*     */     //   148: getfield buttonHideKeyBind : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   151: invokevirtual getOnOff : ()Z
/*     */     //   154: invokevirtual setPrm : (Z)V
/*     */     //   157: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   160: astore_1
/*     */     //   161: getstatic mcheli/MCH_Config.DisplayEntityMarker : Lmcheli/MCH_ConfigPrm;
/*     */     //   164: aload_0
/*     */     //   165: getfield buttonShowEntityMarker : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   168: invokevirtual getOnOff : ()Z
/*     */     //   171: invokevirtual setPrm : (Z)V
/*     */     //   174: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   177: astore_1
/*     */     //   178: getstatic mcheli/MCH_Config.DisplayMarkThroughWall : Lmcheli/MCH_ConfigPrm;
/*     */     //   181: aload_0
/*     */     //   182: getfield buttonMarkThroughWall : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   185: invokevirtual getOnOff : ()Z
/*     */     //   188: invokevirtual setPrm : (Z)V
/*     */     //   191: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   194: astore_1
/*     */     //   195: getstatic mcheli/MCH_Config.EntityMarkerSize : Lmcheli/MCH_ConfigPrm;
/*     */     //   198: aload_0
/*     */     //   199: getfield sliderEntityMarkerSize : Lmcheli/gui/MCH_GuiSlider;
/*     */     //   202: iconst_1
/*     */     //   203: invokevirtual getSliderValueInt : (I)F
/*     */     //   206: f2d
/*     */     //   207: invokevirtual setPrm : (D)V
/*     */     //   210: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   213: astore_1
/*     */     //   214: getstatic mcheli/MCH_Config.BlockMarkerSize : Lmcheli/MCH_ConfigPrm;
/*     */     //   217: aload_0
/*     */     //   218: getfield sliderBlockMarkerSize : Lmcheli/gui/MCH_GuiSlider;
/*     */     //   221: iconst_1
/*     */     //   222: invokevirtual getSliderValueInt : (I)F
/*     */     //   225: f2d
/*     */     //   226: invokevirtual setPrm : (D)V
/*     */     //   229: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   232: astore_1
/*     */     //   233: getstatic mcheli/MCH_Config.ReplaceRenderViewEntity : Lmcheli/MCH_ConfigPrm;
/*     */     //   236: aload_0
/*     */     //   237: getfield buttonReplaceCamera : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   240: invokevirtual getOnOff : ()Z
/*     */     //   243: invokevirtual setPrm : (Z)V
/*     */     //   246: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   249: astore_1
/*     */     //   250: getstatic mcheli/MCH_Config.DefaultExplosionParticle : Lmcheli/MCH_ConfigPrm;
/*     */     //   253: aload_0
/*     */     //   254: getfield buttonNewExplosion : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   257: invokevirtual getOnOff : ()Z
/*     */     //   260: invokevirtual setPrm : (Z)V
/*     */     //   263: aload_0
/*     */     //   264: getfield sliderHitMark : [Lmcheli/gui/MCH_GuiSlider;
/*     */     //   267: iconst_0
/*     */     //   268: aaload
/*     */     //   269: invokevirtual getSliderValue : ()F
/*     */     //   272: fstore_3
/*     */     //   273: aload_0
/*     */     //   274: getfield sliderHitMark : [Lmcheli/gui/MCH_GuiSlider;
/*     */     //   277: iconst_1
/*     */     //   278: aaload
/*     */     //   279: invokevirtual getSliderValue : ()F
/*     */     //   282: f2i
/*     */     //   283: istore #4
/*     */     //   285: aload_0
/*     */     //   286: getfield sliderHitMark : [Lmcheli/gui/MCH_GuiSlider;
/*     */     //   289: iconst_2
/*     */     //   290: aaload
/*     */     //   291: invokevirtual getSliderValue : ()F
/*     */     //   294: f2i
/*     */     //   295: istore #5
/*     */     //   297: aload_0
/*     */     //   298: getfield sliderHitMark : [Lmcheli/gui/MCH_GuiSlider;
/*     */     //   301: iconst_3
/*     */     //   302: aaload
/*     */     //   303: invokevirtual getSliderValue : ()F
/*     */     //   306: f2i
/*     */     //   307: istore #6
/*     */     //   309: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   312: astore_1
/*     */     //   313: fload_3
/*     */     //   314: ldc 255.0
/*     */     //   316: fdiv
/*     */     //   317: putstatic mcheli/MCH_Config.hitMarkColorAlpha : F
/*     */     //   320: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   323: astore_1
/*     */     //   324: iload #4
/*     */     //   326: bipush #16
/*     */     //   328: ishl
/*     */     //   329: iload #5
/*     */     //   331: bipush #8
/*     */     //   333: ishl
/*     */     //   334: ior
/*     */     //   335: iload #6
/*     */     //   337: ior
/*     */     //   338: putstatic mcheli/MCH_Config.hitMarkColorRGB : I
/*     */     //   341: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   344: astore_1
/*     */     //   345: getstatic mcheli/MCH_Config.HitMarkColor : Lmcheli/MCH_ConfigPrm;
/*     */     //   348: ldc_w '%d, %d, %d, %d'
/*     */     //   351: iconst_4
/*     */     //   352: anewarray java/lang/Object
/*     */     //   355: dup
/*     */     //   356: iconst_0
/*     */     //   357: fload_3
/*     */     //   358: f2i
/*     */     //   359: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   362: aastore
/*     */     //   363: dup
/*     */     //   364: iconst_1
/*     */     //   365: iload #4
/*     */     //   367: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   370: aastore
/*     */     //   371: dup
/*     */     //   372: iconst_2
/*     */     //   373: iload #5
/*     */     //   375: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   378: aastore
/*     */     //   379: dup
/*     */     //   380: iconst_3
/*     */     //   381: iload #6
/*     */     //   383: invokestatic valueOf : (I)Ljava/lang/Integer;
/*     */     //   386: aastore
/*     */     //   387: invokestatic format : (Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
/*     */     //   390: invokevirtual setPrm : (Ljava/lang/String;)V
/*     */     //   393: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   396: astore_1
/*     */     //   397: getstatic mcheli/MCH_Config.AutoThrottleDownHeli : Lmcheli/MCH_ConfigPrm;
/*     */     //   400: getfield prmBool : Z
/*     */     //   403: istore #7
/*     */     //   405: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   408: astore_1
/*     */     //   409: getstatic mcheli/MCH_Config.AutoThrottleDownPlane : Lmcheli/MCH_ConfigPrm;
/*     */     //   412: getfield prmBool : Z
/*     */     //   415: istore #8
/*     */     //   417: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   420: astore_1
/*     */     //   421: getstatic mcheli/MCH_Config.AutoThrottleDownHeli : Lmcheli/MCH_ConfigPrm;
/*     */     //   424: aload_0
/*     */     //   425: getfield buttonThrottleHeli : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   428: invokevirtual getOnOff : ()Z
/*     */     //   431: invokevirtual setPrm : (Z)V
/*     */     //   434: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   437: astore_1
/*     */     //   438: getstatic mcheli/MCH_Config.AutoThrottleDownPlane : Lmcheli/MCH_ConfigPrm;
/*     */     //   441: aload_0
/*     */     //   442: getfield buttonThrottlePlane : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   445: invokevirtual getOnOff : ()Z
/*     */     //   448: invokevirtual setPrm : (Z)V
/*     */     //   451: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   454: astore_1
/*     */     //   455: getstatic mcheli/MCH_Config.AutoThrottleDownTank : Lmcheli/MCH_ConfigPrm;
/*     */     //   458: aload_0
/*     */     //   459: getfield buttonThrottleTank : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   462: invokevirtual getOnOff : ()Z
/*     */     //   465: invokevirtual setPrm : (Z)V
/*     */     //   468: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   471: astore #9
/*     */     //   473: iload #7
/*     */     //   475: getstatic mcheli/MCH_Config.AutoThrottleDownHeli : Lmcheli/MCH_ConfigPrm;
/*     */     //   478: getfield prmBool : Z
/*     */     //   481: if_icmpne -> 503
/*     */     //   484: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   487: astore #9
/*     */     //   489: iload #8
/*     */     //   491: getstatic mcheli/MCH_Config.AutoThrottleDownPlane : Lmcheli/MCH_ConfigPrm;
/*     */     //   494: getfield prmBool : Z
/*     */     //   497: if_icmpne -> 503
/*     */     //   500: goto -> 507
/*     */     //   503: aload_0
/*     */     //   504: invokevirtual sendClientSettings : ()V
/*     */     //   507: iconst_0
/*     */     //   508: istore_2
/*     */     //   509: iload_2
/*     */     //   510: aload_0
/*     */     //   511: getfield keyBindingList : Lmcheli/gui/MCH_GuiList;
/*     */     //   514: invokevirtual getItemNum : ()I
/*     */     //   517: if_icmpge -> 540
/*     */     //   520: aload_0
/*     */     //   521: getfield keyBindingList : Lmcheli/gui/MCH_GuiList;
/*     */     //   524: iload_2
/*     */     //   525: invokevirtual getItem : (I)Lmcheli/gui/MCH_GuiListItem;
/*     */     //   528: checkcast mcheli/gui/MCH_GuiListItemKeyBind
/*     */     //   531: invokevirtual applyKeycode : ()V
/*     */     //   534: iinc #2, 1
/*     */     //   537: goto -> 509
/*     */     //   540: getstatic mcheli/MCH_ClientCommonTickHandler.instance : Lmcheli/MCH_ClientCommonTickHandler;
/*     */     //   543: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   546: invokevirtual updatekeybind : (Lmcheli/MCH_Config;)V
/*     */     //   549: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   552: astore_1
/*     */     //   553: getstatic mcheli/MCH_Config.TestMode : Lmcheli/MCH_ConfigPrm;
/*     */     //   556: aload_0
/*     */     //   557: getfield buttonTestMode : Lmcheli/gui/MCH_GuiOnOffButton;
/*     */     //   560: invokevirtual getOnOff : ()Z
/*     */     //   563: invokevirtual setPrm : (Z)V
/*     */     //   566: getstatic mcheli/MCH_MOD.config : Lmcheli/MCH_Config;
/*     */     //   569: invokevirtual write : ()V
/*     */     //   572: return
/*     */     // Line number table:
/*     */     //   Java source line number -> byte code offset
/*     */     //   #341	-> 0
/*     */     //   #342	-> 2
/*     */     //   #343	-> 6
/*     */     //   #344	-> 19
/*     */     //   #345	-> 23
/*     */     //   #346	-> 36
/*     */     //   #347	-> 40
/*     */     //   #348	-> 53
/*     */     //   #349	-> 57
/*     */     //   #350	-> 70
/*     */     //   #351	-> 74
/*     */     //   #352	-> 87
/*     */     //   #353	-> 91
/*     */     //   #354	-> 106
/*     */     //   #355	-> 110
/*     */     //   #356	-> 123
/*     */     //   #357	-> 127
/*     */     //   #358	-> 140
/*     */     //   #359	-> 144
/*     */     //   #360	-> 157
/*     */     //   #361	-> 161
/*     */     //   #362	-> 174
/*     */     //   #363	-> 178
/*     */     //   #364	-> 191
/*     */     //   #365	-> 195
/*     */     //   #366	-> 210
/*     */     //   #367	-> 214
/*     */     //   #368	-> 229
/*     */     //   #369	-> 233
/*     */     //   #370	-> 246
/*     */     //   #371	-> 250
/*     */     //   #372	-> 263
/*     */     //   #373	-> 273
/*     */     //   #374	-> 285
/*     */     //   #375	-> 297
/*     */     //   #376	-> 309
/*     */     //   #377	-> 313
/*     */     //   #378	-> 320
/*     */     //   #379	-> 324
/*     */     //   #380	-> 341
/*     */     //   #381	-> 345
/*     */     //   #382	-> 393
/*     */     //   #383	-> 397
/*     */     //   #384	-> 405
/*     */     //   #385	-> 409
/*     */     //   #386	-> 417
/*     */     //   #387	-> 421
/*     */     //   #388	-> 434
/*     */     //   #389	-> 438
/*     */     //   #390	-> 451
/*     */     //   #391	-> 455
/*     */     //   #392	-> 468
/*     */     //   #393	-> 473
/*     */     //   #394	-> 484
/*     */     //   #395	-> 489
/*     */     //   #396	-> 500
/*     */     //   #400	-> 503
/*     */     //   #403	-> 507
/*     */     //   #404	-> 520
/*     */     //   #403	-> 534
/*     */     //   #407	-> 540
/*     */     //   #408	-> 549
/*     */     //   #409	-> 553
/*     */     //   #410	-> 566
/*     */     //   #411	-> 572
/*     */     // Local variable table:
/*     */     //   start	length	slot	name	descriptor
/*     */     //   2	505	2	n	Z
/*     */     //   273	234	3	a	F
/*     */     //   285	222	4	r	I
/*     */     //   297	210	5	g	I
/*     */     //   309	198	6	b	I
/*     */     //   405	102	7	b1	Z
/*     */     //   417	90	8	b2	Z
/*     */     //   473	34	9	var10001	Lmcheli/MCH_Config;
/*     */     //   509	31	2	i	I
/*     */     //   0	573	0	this	Lmcheli/gui/MCH_ConfigGui;
/*     */     //   6	567	1	var10000	Lmcheli/MCH_Config;
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
/*     */   public void switchScreen(int screenID) {
/* 414 */     this.waitKeyButtonId = 0;
/* 415 */     this.currentScreenId = screenID;
/* 416 */     Iterator<W_GuiButton> i$ = this.listControlButtons.iterator();
/*     */ 
/*     */     
/* 419 */     while (i$.hasNext()) {
/* 420 */       W_GuiButton b = i$.next();
/* 421 */       b.setVisible(false);
/*     */     } 
/*     */     
/* 424 */     i$ = this.listRenderButtons.iterator();
/*     */     
/* 426 */     while (i$.hasNext()) {
/* 427 */       W_GuiButton b = i$.next();
/* 428 */       b.setVisible(false);
/*     */     } 
/*     */     
/* 431 */     i$ = this.listKeyBindingButtons.iterator();
/*     */     
/* 433 */     while (i$.hasNext()) {
/* 434 */       W_GuiButton b = i$.next();
/* 435 */       b.setVisible(false);
/*     */     } 
/*     */     
/* 438 */     i$ = this.listDevelopButtons.iterator();
/*     */     
/* 440 */     while (i$.hasNext()) {
/* 441 */       W_GuiButton b = i$.next();
/* 442 */       b.setVisible(false);
/*     */     } 
/*     */     
/* 445 */     this.ignoreButtonCounter = 3;
/*     */   }
/*     */ 
/*     */   
/*     */   public void applySwitchScreen() {
/*     */     Iterator<W_GuiButton> iterator3, iterator2, iterator1;
/* 451 */     switch (this.currentScreenId) {
/*     */       
/*     */       default:
/* 454 */         iterator3 = this.listControlButtons.iterator();
/*     */         
/* 456 */         while (iterator3.hasNext()) {
/* 457 */           W_GuiButton b = iterator3.next();
/* 458 */           b.setVisible(true);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 1:
/* 463 */         iterator2 = this.listRenderButtons.iterator();
/*     */         
/* 465 */         while (iterator2.hasNext()) {
/* 466 */           W_GuiButton b = iterator2.next();
/* 467 */           b.setVisible(true);
/*     */         } 
/*     */         return;
/*     */       
/*     */       case 2:
/* 472 */         iterator1 = this.listKeyBindingButtons.iterator();
/*     */         
/* 474 */         while (iterator1.hasNext()) {
/* 475 */           W_GuiButton b = iterator1.next();
/* 476 */           b.setVisible(true);
/*     */         }  return;
/*     */       case 3:
/*     */         break;
/*     */     } 
/* 481 */     Iterator<W_GuiButton> i$ = this.listDevelopButtons.iterator();
/*     */     
/* 483 */     while (i$.hasNext()) {
/* 484 */       W_GuiButton b = i$.next();
/* 485 */       b.setVisible(true);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void sendClientSettings() {
/* 492 */     if (this.field_146297_k.field_71439_g != null) {
/* 493 */       MCH_EntityAircraft ac = MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)this.field_146297_k.field_71439_g);
/* 494 */       if (ac != null) {
/* 495 */         int seatId = ac.getSeatIdByEntity((Entity)this.field_146297_k.field_71439_g);
/* 496 */         if (seatId == 0) {
/* 497 */           ac.updateClientSettings(seatId);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73869_a(char a, int code) {
/* 505 */     if (this.waitKeyButtonId != 0) {
/* 506 */       if (code != 1) {
/* 507 */         super.func_73869_a(a, code);
/*     */       }
/*     */       
/* 510 */       acceptKeycode(code);
/* 511 */       this.waitKeyButtonId = 0;
/*     */     } else {
/* 513 */       super.func_73869_a(a, code);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void func_73864_a(int par1, int par2, int par3) {
/* 519 */     super.func_73864_a(par1, par2, par3);
/* 520 */     if (this.waitKeyButtonId != 0 && this.waitKeyAcceptCount == 0) {
/* 521 */       acceptKeycode(par3 - 100);
/* 522 */       this.waitKeyButtonId = 0;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void acceptKeycode(int code) {
/* 528 */     if (code != 1 && this.field_146297_k.field_71462_r instanceof MCH_ConfigGui) {
/* 529 */       MCH_GuiListItemKeyBind kb = (MCH_GuiListItemKeyBind)this.keyBindingList.getItem(this.waitKeyButtonId - 200);
/* 530 */       if (kb != null) {
/* 531 */         kb.setKeycode(code);
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146274_d() {
/* 538 */     super.func_146274_d();
/* 539 */     if (this.waitKeyButtonId == 0) {
/* 540 */       int var16 = Mouse.getEventDWheel();
/* 541 */       if (var16 != 0) {
/* 542 */         if (var16 > 0) {
/* 543 */           this.keyBindingList.scrollDown(2.0F);
/* 544 */         } else if (var16 < 0) {
/* 545 */           this.keyBindingList.scrollUp(2.0F);
/*     */         } 
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_73876_c() {
/* 553 */     super.func_73876_c();
/* 554 */     if (this.waitKeyAcceptCount > 0) {
/* 555 */       this.waitKeyAcceptCount--;
/*     */     }
/*     */     
/* 558 */     if (this.ignoreButtonCounter > 0) {
/* 559 */       this.ignoreButtonCounter--;
/* 560 */       if (this.ignoreButtonCounter == 0) {
/* 561 */         applySwitchScreen();
/*     */       }
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void func_146281_b() {
/* 568 */     super.func_146281_b(); } protected void func_146284_a(GuiButton button) { try {
/*     */       MCH_EntityAircraft ac; MCH_GuiListItem e;
/*     */       int var8;
/*     */       List<MCH_EntityAircraft> list;
/*     */       int i;
/* 573 */       super.func_146284_a(button);
/* 574 */       if (!button.field_146124_l) {
/*     */         return;
/*     */       }
/*     */       
/* 578 */       if (this.waitKeyButtonId != 0) {
/*     */         return;
/*     */       }
/*     */       
/* 582 */       if (!canButtonClick()) {
/*     */         return;
/*     */       }
/*     */ 
/*     */       
/* 587 */       switch (button.field_146127_k) {
/*     */         case 50:
/* 589 */           switchScreen(1);
/*     */           break;
/*     */         case 51:
/* 592 */           switchScreen(2);
/*     */           break;
/*     */         case 52:
/* 595 */           switchScreen(0);
/*     */           break;
/*     */         case 53:
/* 598 */           e = this.keyBindingList.lastPushItem;
/* 599 */           if (e != null) {
/* 600 */             MCH_GuiListItemKeyBind var10 = (MCH_GuiListItemKeyBind)e;
/* 601 */             if (var10.lastPushButton != null) {
/* 602 */               int var11 = this.keyBindingList.getItemNum();
/* 603 */               if (var10.lastPushButton.field_146127_k >= 200 && var10.lastPushButton.field_146127_k < 200 + var11) {
/* 604 */                 this.waitKeyButtonId = var10.lastPushButton.field_146127_k;
/* 605 */                 this.waitKeyAcceptCount = 5;
/* 606 */               } else if (var10.lastPushButton.field_146127_k >= 300 && var10.lastPushButton.field_146127_k < 300 + var11) {
/* 607 */                 var10.resetKeycode();
/*     */               } 
/*     */               
/* 610 */               var10.lastPushButton = null;
/*     */             } 
/*     */           } 
/*     */           break;
/*     */         case 54:
/* 615 */           for (var8 = 0; var8 < this.keyBindingList.getItemNum(); var8++) {
/* 616 */             ((MCH_GuiListItemKeyBind)this.keyBindingList.getItem(var8)).resetKeycode();
/*     */           }
/*     */           return;
/*     */         
/*     */         case 55:
/* 621 */           switchScreen(3);
/*     */           break;
/*     */         case 100:
/* 624 */           saveAndApplyConfig();
/* 625 */           this.field_146297_k.field_71439_g.func_71053_j();
/*     */           break;
/*     */         case 101:
/* 628 */           this.field_146297_k.field_71439_g.func_71053_j();
/*     */           break;
/*     */         case 401:
/* 631 */           MCH_Lib.DbgLog(true, "MCH_BaseInfo.reload all weapon info.", new Object[0]);
/* 632 */           MCH_PacketNotifyInfoReloaded.sendRealodAllWeapon();
/* 633 */           MCH_WeaponInfoManager.reload();
/* 634 */           list = this.field_146297_k.field_71441_e.field_72996_f;
/*     */           
/* 636 */           for (i = 0; i < list.size(); i++) {
/* 637 */             if (list.get(i) instanceof MCH_EntityAircraft) {
/* 638 */               MCH_EntityAircraft mCH_EntityAircraft = list.get(i);
/* 639 */               if (mCH_EntityAircraft.getAcInfo() != null) {
/* 640 */                 mCH_EntityAircraft.getAcInfo().reload();
/* 641 */                 mCH_EntityAircraft.changeType((mCH_EntityAircraft.getAcInfo()).name);
/* 642 */                 mCH_EntityAircraft.onAcInfoReloaded();
/*     */               } 
/*     */             } 
/*     */           } 
/*     */           
/* 647 */           this.field_146297_k.field_71439_g.func_71053_j();
/*     */           break;
/*     */         case 402:
/* 650 */           MCH_MOD.proxy.reloadHUD();
/*     */         case 400:
/* 652 */           ac = MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)this.thePlayer);
/* 653 */           if (ac != null && ac.getAcInfo() != null) {
/* 654 */             String var9 = (ac.getAcInfo()).name;
/* 655 */             MCH_Lib.DbgLog(true, "MCH_BaseInfo.reload : " + var9, new Object[0]);
/* 656 */             List<MCH_EntityAircraft> var12 = this.field_146297_k.field_71441_e.field_72996_f;
/*     */             
/* 658 */             for (int i1 = 0; i1 < var12.size(); i1++) {
/* 659 */               if (var12.get(i1) instanceof MCH_EntityAircraft) {
/* 660 */                 ac = var12.get(i1);
/* 661 */                 if (ac.getAcInfo() != null && (ac.getAcInfo()).name.equals(var9)) {
/* 662 */                   ac.getAcInfo().reload();
/* 663 */                   ac.changeType(var9);
/* 664 */                   ac.onAcInfoReloaded();
/*     */                 } 
/*     */               } 
/*     */             } 
/*     */             
/* 669 */             MCH_PacketNotifyInfoReloaded.sendRealodAc();
/*     */           } 
/*     */           
/* 672 */           this.field_146297_k.field_71439_g.func_71053_j(); break;
/*     */       } 
/* 674 */     } catch (Exception var7) {
/* 675 */       var7.printStackTrace();
/*     */     }  }
/*     */ 
/*     */ 
/*     */   
/*     */   public boolean func_73868_f() {
/* 681 */     return true;
/*     */   }
/*     */   
/*     */   protected void func_146979_b(int par1, int par2) {
/* 685 */     super.func_146979_b(par1, par2);
/* 686 */     drawString("MC Helicopter MOD Options", 10, 10, 16777215);
/* 687 */     if (this.currentScreenId == 0) {
/* 688 */       drawString("< Controls >", 170, 10, 16777215);
/* 689 */     } else if (this.currentScreenId == 1) {
/* 690 */       drawString("< Render >", 170, 10, 16777215);
/* 691 */       drawString("Hit Mark", 10, 75, 16777215);
/* 692 */       byte ignoreItems = 0;
/* 693 */       int var11 = ignoreItems | (int)this.sliderHitMark[0].getSliderValue() << 24;
/* 694 */       var11 |= (int)this.sliderHitMark[1].getSliderValue() << 16;
/* 695 */       var11 |= (int)this.sliderHitMark[2].getSliderValue() << 8;
/* 696 */       var11 |= (int)this.sliderHitMark[3].getSliderValue() << 0;
/* 697 */       drawSampleHitMark(40, 105, var11);
/* 698 */       double y = this.sliderEntityMarkerSize.getSliderValue();
/* 699 */       double len$ = 170.0D + (30.0D - y) / 2.0D;
/* 700 */       double s = (this.sliderEntityMarkerSize.field_146129_i - this.sliderEntityMarkerSize.getHeight());
/* 701 */       double[] ls = { len$ + y, s, len$, s, len$ + y / 2.0D, s + y };
/* 702 */       drawLine(ls, -65536, 4);
/* 703 */       y = this.sliderBlockMarkerSize.getSliderValue();
/* 704 */       len$ = 185.0D;
/* 705 */       s = this.sliderBlockMarkerSize.field_146129_i;
/* 706 */       var11 = -65536;
/* 707 */       GL11.glPushMatrix();
/* 708 */       GL11.glEnable(3042);
/* 709 */       GL11.glDisable(3553);
/* 710 */       GL11.glBlendFunc(770, 771);
/* 711 */       GL11.glColor4ub((byte)(var11 >> 16 & 0xFF), (byte)(var11 >> 8 & 0xFF), (byte)(var11 >> 0 & 0xFF), (byte)(var11 >> 24 & 0xFF));
/* 712 */       Tessellator.field_78398_a.func_78371_b(1);
/* 713 */       MCH_GuiTargetMarker.drawRhombus(Tessellator.field_78398_a, 15, len$, s, this.field_73735_i, y, var11);
/* 714 */       Tessellator.field_78398_a.func_78381_a();
/* 715 */       GL11.glEnable(3553);
/* 716 */       GL11.glDisable(3042);
/* 717 */       GL11.glColor4b((byte)-1, (byte)-1, (byte)-1, (byte)-1);
/* 718 */       GL11.glPopMatrix();
/*     */     
/*     */     }
/* 721 */     else if (this.currentScreenId == 2) {
/* 722 */       drawString("< Key Binding >", 170, 10, 16777215);
/* 723 */       if (this.waitKeyButtonId != 0) {
/* 724 */         func_73734_a(30, 30, this.field_146999_f - 30, this.field_147000_g - 30, -533712848);
/* 725 */         String var13 = "Please ant key or mouse button.";
/* 726 */         int var12 = getStringWidth(var13);
/* 727 */         drawString(var13, (this.field_146999_f - var12) / 2, this.field_147000_g / 2 - 4, 16777215);
/*     */       } 
/* 729 */     } else if (this.currentScreenId == 3) {
/* 730 */       drawString("< Development >", 170, 10, 16777215);
/* 731 */       drawString("Single player only!", 10, 30, 16711680);
/* 732 */       if (this.buttonReloadAircraftInfo != null && this.buttonReloadAircraftInfo.isOnMouseOver()) {
/* 733 */         drawString("The following items are not reload.", 170, 30, 16777215);
/* 734 */         String[] var14 = MCH_AircraftInfo.getCannotReloadItem();
/* 735 */         int var12 = 10;
/* 736 */         String[] arr$ = var14;
/* 737 */         int var15 = var14.length;
/*     */         
/* 739 */         for (int i$ = 0; i$ < var15; i$++) {
/* 740 */           String var16 = arr$[i$];
/* 741 */           drawString("  " + var16, 170, 30 + var12, 16777215);
/* 742 */           var12 += 10;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float var1, int var2, int var3) {
/* 751 */     W_ScaledResolution scaledresolution = new W_ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 752 */     this.scaleFactor = scaledresolution.func_78325_e();
/* 753 */     W_McClient.MOD_bindTexture("textures/gui/config.png");
/* 754 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 755 */     int x = (this.field_146294_l - this.field_146999_f) / 2;
/* 756 */     int y = (this.field_146295_m - this.field_147000_g) / 2;
/* 757 */     drawTexturedModalRectRotate(x, y, this.field_146999_f, this.field_147000_g, 0.0D, 0.0D, this.field_146999_f, this.field_147000_g, 0.0F, 512.0D, 256.0D);
/*     */   }
/*     */   
/*     */   public void drawSampleHitMark(int x, int y, int color) {
/* 761 */     byte IVX = 10;
/* 762 */     byte IVY = 10;
/* 763 */     byte SZX = 5;
/* 764 */     byte SZY = 5;
/* 765 */     double[] ls = { (x - IVX), (y - IVY), (x - SZX), (y - SZY), (x - IVX), (y + IVY), (x - SZX), (y + SZY), (x + IVX), (y - IVY), (x + SZX), (y - SZY), (x + IVX), (y + IVY), (x + SZX), (y + SZY) };
/* 766 */     drawLine(ls, color, 1);
/*     */   }
/*     */   
/*     */   public void drawLine(double[] line, int color, int mode) {
/* 770 */     GL11.glPushMatrix();
/* 771 */     GL11.glEnable(3042);
/* 772 */     GL11.glDisable(3553);
/* 773 */     GL11.glBlendFunc(770, 771);
/* 774 */     GL11.glColor4ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color >> 0 & 0xFF), (byte)(color >> 24 & 0xFF));
/* 775 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 776 */     tessellator.func_78371_b(mode);
/*     */     
/* 778 */     for (int i = 0; i < line.length; i += 2) {
/* 779 */       tessellator.func_78377_a(line[i + 0], line[i + 1], this.field_73735_i);
/*     */     }
/*     */     
/* 782 */     tessellator.func_78381_a();
/* 783 */     GL11.glEnable(3553);
/* 784 */     GL11.glDisable(3042);
/* 785 */     GL11.glColor4b((byte)-1, (byte)-1, (byte)-1, (byte)-1);
/* 786 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void drawTexturedModalRectRotate(double left, double top, double width, double height, double uLeft, double vTop, double uWidth, double vHeight, float rot, double texWidth, double texHeight) {
/* 790 */     GL11.glPushMatrix();
/* 791 */     GL11.glTranslated(left + width / 2.0D, top + height / 2.0D, 0.0D);
/* 792 */     GL11.glRotatef(rot, 0.0F, 0.0F, 1.0F);
/* 793 */     float fw = (float)(1.0D / texWidth);
/* 794 */     float fh = (float)(1.0D / texHeight);
/* 795 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 796 */     tessellator.func_78382_b();
/* 797 */     tessellator.func_78374_a(-width / 2.0D, height / 2.0D, this.field_73735_i, uLeft * fw, (vTop + vHeight) * fh);
/* 798 */     tessellator.func_78374_a(width / 2.0D, height / 2.0D, this.field_73735_i, (uLeft + uWidth) * fw, (vTop + vHeight) * fh);
/* 799 */     tessellator.func_78374_a(width / 2.0D, -height / 2.0D, this.field_73735_i, (uLeft + uWidth) * fw, vTop * fh);
/* 800 */     tessellator.func_78374_a(-width / 2.0D, -height / 2.0D, this.field_73735_i, uLeft * fw, vTop * fh);
/* 801 */     tessellator.func_78381_a();
/* 802 */     GL11.glPopMatrix();
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gui\MCH_ConfigGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */