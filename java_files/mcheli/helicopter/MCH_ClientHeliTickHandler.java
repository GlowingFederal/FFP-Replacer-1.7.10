/*     */ package mcheli.helicopter;
/*     */ 
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Key;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_ViewEntityDummy;
/*     */ import mcheli.aircraft.MCH_AircraftClientTickHandler;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.aircraft.MCH_SeatInfo;
/*     */ import mcheli.uav.MCH_EntityUavStation;
/*     */ import mcheli.wrapper.W_Network;
/*     */ import mcheli.wrapper.W_PacketBase;
/*     */ import mcheli.wrapper.W_Reflection;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_ClientHeliTickHandler extends MCH_AircraftClientTickHandler {
/*     */   public MCH_Key KeySwitchMode;
/*     */   public MCH_Key KeySwitchHovering;
/*     */   
/*     */   public MCH_ClientHeliTickHandler(Minecraft minecraft, MCH_Config config) {
/*  26 */     super(minecraft, config);
/*  27 */     updateKeybind(config);
/*     */   }
/*     */   public MCH_Key KeyZoom; public MCH_Key[] Keys;
/*     */   public void updateKeybind(MCH_Config config) {
/*  31 */     super.updateKeybind(config);
/*  32 */     this.KeySwitchMode = new MCH_Key(MCH_Config.KeySwitchMode.prmInt);
/*  33 */     this.KeySwitchHovering = new MCH_Key(MCH_Config.KeySwitchHovering.prmInt);
/*  34 */     this.KeyZoom = new MCH_Key(MCH_Config.KeyZoom.prmInt);
/*  35 */     this.Keys = new MCH_Key[] { this.KeyUp, this.KeyDown, this.KeyRight, this.KeyLeft, this.KeySwitchMode, this.KeySwitchHovering, this.KeyUseWeapon, this.KeySwWeaponMode, this.KeySwitchWeapon1, this.KeySwitchWeapon2, this.KeyZoom, this.KeyCameraMode, this.KeyUnmount, this.KeyUnmountForce, this.KeyFlare, this.KeyExtra, this.KeyFreeLook, this.KeyGUI, this.KeyGearUpDown, this.KeyPutToRack, this.KeyDownFromRack };
/*     */   }
/*     */   
/*     */   protected void update(EntityPlayer player, MCH_EntityHeli heli, boolean isPilot) {
/*  39 */     if (heli.getIsGunnerMode((Entity)player)) {
/*  40 */       MCH_SeatInfo seatInfo = heli.getSeatInfo((Entity)player);
/*  41 */       if (seatInfo != null) {
/*  42 */         setRotLimitPitch(seatInfo.minPitch, seatInfo.maxPitch, (Entity)player);
/*     */       }
/*     */     } 
/*     */     
/*  46 */     heli.updateCameraRotate(player.field_70177_z, player.field_70125_A);
/*  47 */     heli.updateRadar(50);
/*     */   }
/*     */   
/*     */   protected void onTick(boolean inGUI) {
/*  51 */     MCH_Key[] player = this.Keys;
/*  52 */     int heli = player.length;
/*     */     
/*  54 */     for (int isPilot = 0; isPilot < heli; isPilot++) {
/*  55 */       MCH_Key viewEntityDummy = player[isPilot];
/*  56 */       viewEntityDummy.update();
/*     */     } 
/*     */     
/*  59 */     this.isBeforeRiding = this.isRiding;
/*  60 */     EntityClientPlayerMP var7 = this.mc.field_71439_g;
/*  61 */     MCH_EntityHeli var8 = null;
/*  62 */     boolean var9 = true;
/*  63 */     if (var7 != null) {
/*  64 */       if (var7.field_70154_o instanceof MCH_EntityHeli) {
/*  65 */         var8 = (MCH_EntityHeli)var7.field_70154_o;
/*  66 */       } else if (var7.field_70154_o instanceof MCH_EntitySeat) {
/*  67 */         MCH_EntitySeat var10 = (MCH_EntitySeat)var7.field_70154_o;
/*  68 */         if (var10.getParent() instanceof MCH_EntityHeli) {
/*  69 */           var9 = false;
/*  70 */           var8 = (MCH_EntityHeli)var10.getParent();
/*     */         } 
/*  72 */       } else if (var7.field_70154_o instanceof MCH_EntityUavStation) {
/*  73 */         MCH_EntityUavStation var11 = (MCH_EntityUavStation)var7.field_70154_o;
/*  74 */         if (var11.getControlAircract() instanceof MCH_EntityHeli) {
/*  75 */           var8 = (MCH_EntityHeli)var11.getControlAircract();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  80 */     if (var8 != null && var8.getAcInfo() != null) {
/*  81 */       update((EntityPlayer)var7, var8, var9);
/*  82 */       MCH_ViewEntityDummy var12 = MCH_ViewEntityDummy.getInstance((World)this.mc.field_71441_e);
/*  83 */       var12.update(var8.camera);
/*  84 */       if (!inGUI) {
/*  85 */         if (!var8.isDestroyed()) {
/*  86 */           playerControl((EntityPlayer)var7, var8, var9);
/*     */         }
/*     */       } else {
/*  89 */         playerControlInGUI((EntityPlayer)var7, var8, var9);
/*     */       } 
/*     */       
/*  92 */       boolean hideHand = true;
/*  93 */       if ((!var9 || !var8.isAlwaysCameraView()) && !var8.getIsGunnerMode((Entity)var7)) {
/*  94 */         MCH_Lib.setRenderViewEntity((EntityLivingBase)var7);
/*  95 */         if (!var9 && var8.getCurrentWeaponID((Entity)var7) < 0) {
/*  96 */           hideHand = false;
/*     */         }
/*     */       } else {
/*  99 */         MCH_Lib.setRenderViewEntity((EntityLivingBase)var12);
/*     */       } 
/*     */       
/* 102 */       if (hideHand) {
/* 103 */         MCH_Lib.disableFirstPersonItemRender(var7.func_71045_bC());
/*     */       }
/*     */       
/* 106 */       this.isRiding = true;
/*     */     } else {
/* 108 */       this.isRiding = false;
/*     */     } 
/*     */     
/* 111 */     if ((this.isBeforeRiding || !this.isRiding) && this.isBeforeRiding && !this.isRiding) {
/* 112 */       W_Reflection.setCameraRoll(0.0F);
/* 113 */       MCH_Lib.enableFirstPersonItemRender();
/* 114 */       MCH_Lib.setRenderViewEntity((EntityLivingBase)var7);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void playerControlInGUI(EntityPlayer player, MCH_EntityHeli heli, boolean isPilot) {
/* 120 */     commonPlayerControlInGUI(player, heli, isPilot, new MCH_HeliPacketPlayerControl());
/*     */   }
/*     */   
/*     */   protected void playerControl(EntityPlayer player, MCH_EntityHeli heli, boolean isPilot) {
/* 124 */     MCH_HeliPacketPlayerControl pc = new MCH_HeliPacketPlayerControl();
/* 125 */     boolean send = false;
/* 126 */     send = commonPlayerControl(player, heli, isPilot, pc);
/* 127 */     if (isPilot) {
/* 128 */       if (this.KeyExtra.isKeyDown())
/*     */       {
/* 130 */         if (heli.canSwitchFoldBlades()) {
/* 131 */           if (heli.isFoldBlades()) {
/* 132 */             heli.unfoldBlades();
/* 133 */             pc.switchFold = 0;
/*     */           } else {
/* 135 */             heli.foldBlades();
/* 136 */             pc.switchFold = 1;
/*     */           } 
/*     */           
/* 139 */           send = true;
/* 140 */           playSoundOK();
/*     */         } else {
/* 142 */           playSoundNG();
/*     */         } 
/*     */       }
/*     */       
/* 146 */       if (this.KeySwitchHovering.isKeyDown()) {
/* 147 */         if (heli.canSwitchHoveringMode()) {
/* 148 */           pc.switchMode = (byte)(heli.isHoveringMode() ? 2 : 3);
/* 149 */           heli.switchHoveringMode(!heli.isHoveringMode());
/* 150 */           send = true;
/*     */         } else {
/* 152 */           playSoundNG();
/*     */         } 
/* 154 */       } else if (this.KeySwitchMode.isKeyDown()) {
/* 155 */         if (heli.canSwitchGunnerMode()) {
/* 156 */           pc.switchMode = (byte)(heli.getIsGunnerMode((Entity)player) ? 0 : 1);
/* 157 */           heli.switchGunnerMode(!heli.getIsGunnerMode((Entity)player));
/* 158 */           send = true;
/*     */         } else {
/* 160 */           playSoundNG();
/*     */         } 
/*     */       } 
/* 163 */     } else if (this.KeySwitchMode.isKeyDown()) {
/* 164 */       if (heli.canSwitchGunnerModeOtherSeat(player)) {
/* 165 */         heli.switchGunnerModeOtherSeat(player);
/* 166 */         send = true;
/*     */       } else {
/* 168 */         playSoundNG();
/*     */       } 
/*     */     } 
/*     */     
/* 172 */     if (this.KeyZoom.isKeyDown()) {
/* 173 */       boolean isUav = (heli.isUAV() && !heli.getAcInfo().haveHatch());
/* 174 */       if (!heli.getIsGunnerMode((Entity)player) && !isUav) {
/* 175 */         if (isPilot && heli.getAcInfo().haveHatch()) {
/* 176 */           if (heli.canFoldHatch()) {
/* 177 */             pc.switchHatch = 2;
/* 178 */             send = true;
/* 179 */           } else if (heli.canUnfoldHatch()) {
/* 180 */             pc.switchHatch = 1;
/* 181 */             send = true;
/*     */           } else {
/* 183 */             playSoundNG();
/*     */           } 
/*     */         }
/*     */       } else {
/* 187 */         heli.zoomCamera();
/* 188 */         playSound("zoom", 0.5F, 1.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 192 */     if (send)
/* 193 */       W_Network.sendToServer((W_PacketBase)pc); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\helicopter\MCH_ClientHeliTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */