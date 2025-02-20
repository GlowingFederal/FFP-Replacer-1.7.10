/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import mcheli.MCH_ClientTickHandlerBase;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Key;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.MCH_PacketIndOpenScreen;
/*     */ import mcheli.wrapper.W_Network;
/*     */ import mcheli.wrapper.W_PacketBase;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import org.lwjgl.input.Keyboard;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public abstract class MCH_AircraftClientTickHandler
/*     */   extends MCH_ClientTickHandlerBase
/*     */ {
/*     */   protected boolean isRiding = false;
/*     */   protected boolean isBeforeRiding = false;
/*     */   public MCH_Key KeyUp;
/*     */   public MCH_Key KeyDown;
/*     */   public MCH_Key KeyRight;
/*     */   public MCH_Key KeyLeft;
/*     */   public MCH_Key KeyUseWeapon;
/*     */   public MCH_Key KeySwitchWeapon1;
/*     */   public MCH_Key KeySwitchWeapon2;
/*     */   public MCH_Key KeySwWeaponMode;
/*     */   
/*     */   public MCH_AircraftClientTickHandler(Minecraft minecraft, MCH_Config config) {
/*  36 */     super(minecraft);
/*  37 */     updateKeybind(config);
/*     */   }
/*     */   public MCH_Key KeyUnmount; public MCH_Key KeyUnmountForce; public MCH_Key KeyExtra; public MCH_Key KeyFlare; public MCH_Key KeyCameraMode; public MCH_Key KeyFreeLook; public MCH_Key KeyGUI; public MCH_Key KeyGearUpDown; public MCH_Key KeyPutToRack; public MCH_Key KeyDownFromRack; public MCH_Key KeyBrake;
/*     */   public void updateKeybind(MCH_Config config) {
/*  41 */     this.KeyUp = new MCH_Key(MCH_Config.KeyUp.prmInt);
/*  42 */     this.KeyDown = new MCH_Key(MCH_Config.KeyDown.prmInt);
/*  43 */     this.KeyRight = new MCH_Key(MCH_Config.KeyRight.prmInt);
/*  44 */     this.KeyLeft = new MCH_Key(MCH_Config.KeyLeft.prmInt);
/*  45 */     this.KeyUseWeapon = new MCH_Key(MCH_Config.KeyUseWeapon.prmInt);
/*  46 */     this.KeySwitchWeapon1 = new MCH_Key(MCH_Config.KeySwitchWeapon1.prmInt);
/*  47 */     this.KeySwitchWeapon2 = new MCH_Key(MCH_Config.KeySwitchWeapon2.prmInt);
/*  48 */     this.KeySwWeaponMode = new MCH_Key(MCH_Config.KeySwWeaponMode.prmInt);
/*  49 */     this.KeyUnmount = new MCH_Key(MCH_Config.KeyUnmount.prmInt);
/*  50 */     this.KeyUnmountForce = new MCH_Key(42);
/*  51 */     this.KeyExtra = new MCH_Key(MCH_Config.KeyExtra.prmInt);
/*  52 */     this.KeyFlare = new MCH_Key(MCH_Config.KeyFlare.prmInt);
/*  53 */     this.KeyCameraMode = new MCH_Key(MCH_Config.KeyCameraMode.prmInt);
/*  54 */     this.KeyFreeLook = new MCH_Key(MCH_Config.KeyFreeLook.prmInt);
/*  55 */     this.KeyGUI = new MCH_Key(MCH_Config.KeyGUI.prmInt);
/*  56 */     this.KeyGearUpDown = new MCH_Key(MCH_Config.KeyGearUpDown.prmInt);
/*  57 */     this.KeyPutToRack = new MCH_Key(MCH_Config.KeyPutToRack.prmInt);
/*  58 */     this.KeyDownFromRack = new MCH_Key(MCH_Config.KeyDownFromRack.prmInt);
/*  59 */     this.KeyBrake = new MCH_Key(MCH_Config.KeySwitchHovering.prmInt);
/*     */   }
/*     */   
/*     */   protected void commonPlayerControlInGUI(EntityPlayer player, MCH_EntityAircraft ac, boolean isPilot, MCH_PacketPlayerControlBase pc) {}
/*     */   
/*     */   public boolean commonPlayerControl(EntityPlayer player, MCH_EntityAircraft ac, boolean isPilot, MCH_PacketPlayerControlBase pc) {
/*  65 */     MCH_Config var10000 = MCH_MOD.config;
/*     */     
/*  67 */     if (Keyboard.isKeyDown(MCH_Config.KeyFreeLook.prmInt)) {
/*  68 */       if (this.KeyGUI.isKeyDown() || this.KeyExtra.isKeyDown()) {
/*  69 */         MCH_PacketSeatPlayerControl send = new MCH_PacketSeatPlayerControl();
/*  70 */         if (isPilot) {
/*  71 */           send.switchSeat = (byte)(this.KeyGUI.isKeyDown() ? 1 : 2);
/*     */         } else {
/*  73 */           ac.keepOnRideRotation = true;
/*  74 */           send.switchSeat = 3;
/*     */         } 
/*     */         
/*  77 */         W_Network.sendToServer((W_PacketBase)send);
/*  78 */         return false;
/*     */       } 
/*  80 */     } else if (!isPilot && ac.getSeatNum() > 1) {
/*  81 */       MCH_PacketSeatPlayerControl send = new MCH_PacketSeatPlayerControl();
/*  82 */       if (this.KeyGUI.isKeyDown()) {
/*  83 */         send.switchSeat = 1;
/*  84 */         W_Network.sendToServer((W_PacketBase)send);
/*  85 */         return false;
/*     */       } 
/*     */       
/*  88 */       if (this.KeyExtra.isKeyDown()) {
/*  89 */         send.switchSeat = 2;
/*  90 */         W_Network.sendToServer((W_PacketBase)send);
/*  91 */         return false;
/*     */       } 
/*     */     } 
/*     */     
/*  95 */     boolean var12 = false;
/*  96 */     if (this.KeyCameraMode.isKeyDown()) {
/*  97 */       if (ac.haveSearchLight()) {
/*  98 */         if (ac.canSwitchSearchLight((Entity)player)) {
/*  99 */           pc.switchSearchLight = true;
/* 100 */           playSoundOK();
/* 101 */           var12 = true;
/*     */         } 
/* 103 */       } else if (ac.canSwitchCameraMode()) {
/* 104 */         int dKey = ac.getCameraMode(player);
/* 105 */         ac.switchCameraMode(player);
/* 106 */         int arr$ = ac.getCameraMode(player);
/* 107 */         if (arr$ != dKey) {
/* 108 */           pc.switchCameraMode = (byte)(arr$ + 1);
/* 109 */           playSoundOK();
/* 110 */           var12 = true;
/*     */         } 
/*     */       } else {
/* 113 */         playSoundNG();
/*     */       } 
/*     */     }
/*     */     
/* 117 */     if (this.KeyUnmount.isKeyDown() && !ac.isDestroyed() && ac.func_70302_i_() > 0 && !isPilot) {
/* 118 */       MCH_PacketIndOpenScreen.send(3);
/*     */     }
/*     */     
/* 121 */     if (isPilot) {
/* 122 */       if (this.KeyUnmount.isKeyDown()) {
/* 123 */         pc.isUnmount = 2;
/* 124 */         var12 = true;
/*     */       } 
/*     */       
/* 127 */       if (this.KeyPutToRack.isKeyDown()) {
/* 128 */         ac.checkRideRack();
/* 129 */         if (ac.canRideRack()) {
/* 130 */           pc.putDownRack = 3;
/* 131 */           var12 = true;
/* 132 */         } else if (ac.canPutToRack()) {
/* 133 */           pc.putDownRack = 1;
/* 134 */           var12 = true;
/*     */         } 
/* 136 */       } else if (this.KeyDownFromRack.isKeyDown()) {
/* 137 */         if (ac.field_70154_o != null) {
/* 138 */           pc.isUnmount = 3;
/* 139 */           var12 = true;
/* 140 */         } else if (ac.canDownFromRack()) {
/* 141 */           pc.putDownRack = 2;
/* 142 */           var12 = true;
/*     */         } 
/*     */       } 
/*     */       
/* 146 */       if (this.KeyGearUpDown.isKeyDown() && ac.getAcInfo().haveLandingGear()) {
/* 147 */         if (ac.canFoldLandingGear()) {
/* 148 */           pc.switchGear = 1;
/* 149 */           var12 = true;
/* 150 */         } else if (ac.canUnfoldLandingGear()) {
/* 151 */           pc.switchGear = 2;
/* 152 */           var12 = true;
/*     */         } 
/*     */       }
/*     */       
/* 156 */       if (this.KeyFreeLook.isKeyDown() && ac.canSwitchFreeLook()) {
/* 157 */         pc.switchFreeLook = (byte)(ac.isFreeLookMode() ? 2 : 1);
/* 158 */         var12 = true;
/*     */       } 
/*     */       
/* 161 */       if (this.KeyGUI.isKeyDown()) {
/* 162 */         pc.openGui = true;
/* 163 */         var12 = true;
/*     */       } 
/*     */       
/* 166 */       if (ac.isRepelling()) {
/* 167 */         pc.throttleDown = ac.throttleDown = false;
/* 168 */         pc.throttleUp = ac.throttleUp = false;
/* 169 */         pc.moveRight = ac.moveRight = false;
/* 170 */         pc.moveLeft = ac.moveLeft = false;
/* 171 */       } else if (ac.hasBrake() && this.KeyBrake.isKeyPress()) {
/* 172 */         var12 |= this.KeyBrake.isKeyDown();
/* 173 */         pc.throttleDown = ac.throttleDown = false;
/* 174 */         pc.throttleUp = ac.throttleUp = false;
/* 175 */         double var14 = ac.field_70165_t - ac.field_70169_q;
/* 176 */         double var16 = ac.field_70161_v - ac.field_70166_s;
/* 177 */         double var17 = var14 * var14 + var16 * var16;
/* 178 */         if (ac.getCurrentThrottle() <= 0.03D && var17 < 0.01D) {
/* 179 */           pc.moveRight = ac.moveRight = false;
/* 180 */           pc.moveLeft = ac.moveLeft = false;
/*     */         } 
/*     */         
/* 183 */         pc.useBrake = true;
/*     */       } else {
/* 185 */         var12 |= this.KeyBrake.isKeyUp();
/* 186 */         MCH_Key[] var13 = { this.KeyUp, this.KeyDown, this.KeyRight, this.KeyLeft };
/* 187 */         MCH_Key[] var15 = var13;
/* 188 */         int len$ = var13.length;
/*     */         
/* 190 */         for (int i$ = 0; i$ < len$; i$++) {
/* 191 */           MCH_Key k = var15[i$];
/* 192 */           if (k.isKeyDown() || k.isKeyUp()) {
/* 193 */             var12 = true;
/*     */             
/*     */             break;
/*     */           } 
/*     */         } 
/* 198 */         pc.throttleDown = ac.throttleDown = this.KeyDown.isKeyPress();
/* 199 */         pc.throttleUp = ac.throttleUp = this.KeyUp.isKeyPress();
/* 200 */         pc.moveRight = ac.moveRight = this.KeyRight.isKeyPress();
/* 201 */         pc.moveLeft = ac.moveLeft = this.KeyLeft.isKeyPress();
/*     */       } 
/*     */     } 
/*     */     
/* 205 */     if (!ac.isDestroyed() && this.KeyFlare.isKeyDown() && ac.getSeatIdByEntity((Entity)player) <= 1) {
/* 206 */       if (ac.canUseFlare() && ac.useFlare(ac.getCurrentFlareType())) {
/* 207 */         pc.useFlareType = (byte)ac.getCurrentFlareType();
/* 208 */         ac.nextFlareType();
/* 209 */         var12 = true;
/*     */       } else {
/* 211 */         playSoundNG();
/*     */       } 
/*     */     }
/*     */     
/* 215 */     if (!ac.isDestroyed() && !ac.isPilotReloading()) {
/* 216 */       if (!this.KeySwitchWeapon1.isKeyDown() && !this.KeySwitchWeapon2.isKeyDown() && getMouseWheel() == 0) {
/* 217 */         if (this.KeySwWeaponMode.isKeyDown()) {
/* 218 */           ac.switchCurrentWeaponMode((Entity)player);
/* 219 */         } else if (this.KeyUseWeapon.isKeyPress() && ac.useCurrentWeapon((Entity)player)) {
/* 220 */           pc.useWeapon = true;
/* 221 */           pc.useWeaponOption1 = ac.getCurrentWeapon((Entity)player).getLastUsedOptionParameter1();
/* 222 */           pc.useWeaponOption2 = ac.getCurrentWeapon((Entity)player).getLastUsedOptionParameter2();
/* 223 */           pc.useWeaponPosX = ac.field_70169_q;
/* 224 */           pc.useWeaponPosY = ac.field_70167_r;
/* 225 */           pc.useWeaponPosZ = ac.field_70166_s;
/* 226 */           var12 = true;
/*     */         } 
/*     */       } else {
/* 229 */         if (getMouseWheel() > 0) {
/* 230 */           pc.switchWeapon = (byte)ac.getNextWeaponID((Entity)player, -1);
/*     */         } else {
/* 232 */           pc.switchWeapon = (byte)ac.getNextWeaponID((Entity)player, 1);
/*     */         } 
/*     */         
/* 235 */         setMouseWheel(0);
/* 236 */         ac.switchWeapon((Entity)player, pc.switchWeapon);
/* 237 */         var12 = true;
/*     */       } 
/*     */     }
/*     */     
/* 241 */     return (var12 || player.field_70173_aa % 100 == 0);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_AircraftClientTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */