/*     */ package mcheli.tank;
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
/*     */ public class MCH_ClientTankTickHandler extends MCH_AircraftClientTickHandler {
/*     */   public MCH_Key KeySwitchMode;
/*     */   
/*     */   public MCH_ClientTankTickHandler(Minecraft minecraft, MCH_Config config) {
/*  25 */     super(minecraft, config);
/*  26 */     updateKeybind(config);
/*     */   }
/*     */   public MCH_Key KeyZoom; public MCH_Key[] Keys;
/*     */   public void updateKeybind(MCH_Config config) {
/*  30 */     super.updateKeybind(config);
/*  31 */     this.KeySwitchMode = new MCH_Key(MCH_Config.KeySwitchMode.prmInt);
/*  32 */     this.KeyZoom = new MCH_Key(MCH_Config.KeyZoom.prmInt);
/*  33 */     this.Keys = new MCH_Key[] { this.KeyUp, this.KeyDown, this.KeyRight, this.KeyLeft, this.KeySwitchMode, this.KeyUseWeapon, this.KeySwWeaponMode, this.KeySwitchWeapon1, this.KeySwitchWeapon2, this.KeyZoom, this.KeyCameraMode, this.KeyUnmount, this.KeyUnmountForce, this.KeyFlare, this.KeyExtra, this.KeyFreeLook, this.KeyGUI, this.KeyGearUpDown, this.KeyBrake, this.KeyPutToRack, this.KeyDownFromRack };
/*     */   }
/*     */   
/*     */   protected void update(EntityPlayer player, MCH_EntityTank tank) {
/*  37 */     if (tank.getIsGunnerMode((Entity)player)) {
/*  38 */       MCH_SeatInfo seatInfo = tank.getSeatInfo((Entity)player);
/*  39 */       if (seatInfo != null) {
/*  40 */         setRotLimitPitch(seatInfo.minPitch, seatInfo.maxPitch, (Entity)player);
/*     */       }
/*     */     } 
/*     */     
/*  44 */     tank.updateRadar(50);
/*  45 */     tank.updateCameraRotate(player.field_70177_z, player.field_70125_A);
/*     */   }
/*     */   
/*     */   protected void onTick(boolean inGUI) {
/*  49 */     MCH_Key[] player = this.Keys;
/*  50 */     int tank = player.length;
/*     */     
/*  52 */     for (int isPilot = 0; isPilot < tank; isPilot++) {
/*  53 */       MCH_Key viewEntityDummy = player[isPilot];
/*  54 */       viewEntityDummy.update();
/*     */     } 
/*     */     
/*  57 */     this.isBeforeRiding = this.isRiding;
/*  58 */     EntityClientPlayerMP var7 = this.mc.field_71439_g;
/*  59 */     MCH_EntityTank var8 = null;
/*  60 */     boolean var9 = true;
/*  61 */     if (var7 != null) {
/*  62 */       if (var7.field_70154_o instanceof MCH_EntityTank) {
/*  63 */         var8 = (MCH_EntityTank)var7.field_70154_o;
/*  64 */       } else if (var7.field_70154_o instanceof MCH_EntitySeat) {
/*  65 */         MCH_EntitySeat var10 = (MCH_EntitySeat)var7.field_70154_o;
/*  66 */         if (var10.getParent() instanceof MCH_EntityTank) {
/*  67 */           var9 = false;
/*  68 */           var8 = (MCH_EntityTank)var10.getParent();
/*     */         } 
/*  70 */       } else if (var7.field_70154_o instanceof MCH_EntityUavStation) {
/*  71 */         MCH_EntityUavStation var11 = (MCH_EntityUavStation)var7.field_70154_o;
/*  72 */         if (var11.getControlAircract() instanceof MCH_EntityTank) {
/*  73 */           var8 = (MCH_EntityTank)var11.getControlAircract();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  78 */     if (var8 != null && var8.getAcInfo() != null) {
/*  79 */       update((EntityPlayer)var7, var8);
/*  80 */       MCH_ViewEntityDummy var12 = MCH_ViewEntityDummy.getInstance((World)this.mc.field_71441_e);
/*  81 */       var12.update(var8.camera);
/*  82 */       if (!inGUI) {
/*  83 */         if (!var8.isDestroyed()) {
/*  84 */           playerControl((EntityPlayer)var7, var8, var9);
/*     */         }
/*     */       } else {
/*  87 */         playerControlInGUI((EntityPlayer)var7, var8, var9);
/*     */       } 
/*     */       
/*  90 */       boolean hideHand = true;
/*  91 */       if ((!var9 || !var8.isAlwaysCameraView()) && !var8.getIsGunnerMode((Entity)var7) && var8.getCameraId() <= 0) {
/*  92 */         MCH_Lib.setRenderViewEntity((EntityLivingBase)var7);
/*  93 */         if (!var9 && var8.getCurrentWeaponID((Entity)var7) < 0) {
/*  94 */           hideHand = false;
/*     */         }
/*     */       } else {
/*  97 */         MCH_Lib.setRenderViewEntity((EntityLivingBase)var12);
/*     */       } 
/*     */       
/* 100 */       if (hideHand) {
/* 101 */         MCH_Lib.disableFirstPersonItemRender(var7.func_71045_bC());
/*     */       }
/*     */       
/* 104 */       this.isRiding = true;
/*     */     } else {
/* 106 */       this.isRiding = false;
/*     */     } 
/*     */     
/* 109 */     if (!this.isBeforeRiding && this.isRiding && var8 != null) {
/* 110 */       MCH_ViewEntityDummy.getInstance((World)this.mc.field_71441_e).func_70107_b(var8.field_70165_t, var8.field_70163_u + 0.5D, var8.field_70161_v);
/* 111 */     } else if (this.isBeforeRiding && !this.isRiding) {
/* 112 */       MCH_Lib.enableFirstPersonItemRender();
/* 113 */       MCH_Lib.setRenderViewEntity((EntityLivingBase)var7);
/* 114 */       W_Reflection.setCameraRoll(0.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void playerControlInGUI(EntityPlayer player, MCH_EntityTank tank, boolean isPilot) {
/* 120 */     commonPlayerControlInGUI(player, tank, isPilot, new MCH_TankPacketPlayerControl());
/*     */   }
/*     */   
/*     */   protected void playerControl(EntityPlayer player, MCH_EntityTank tank, boolean isPilot) {
/* 124 */     MCH_TankPacketPlayerControl pc = new MCH_TankPacketPlayerControl();
/* 125 */     boolean send = false;
/* 126 */     send = commonPlayerControl(player, tank, isPilot, pc);
/* 127 */     if ((tank.getAcInfo()).defaultFreelook && pc.switchFreeLook > 0) {
/* 128 */       pc.switchFreeLook = 0;
/*     */     }
/*     */     
/* 131 */     if (isPilot) {
/* 132 */       if (this.KeySwitchMode.isKeyDown()) {
/* 133 */         if (tank.getIsGunnerMode((Entity)player) && tank.canSwitchCameraPos()) {
/* 134 */           pc.switchMode = 0;
/* 135 */           tank.switchGunnerMode(false);
/* 136 */           send = true;
/* 137 */           tank.setCameraId(1);
/* 138 */         } else if (tank.getCameraId() > 0) {
/* 139 */           tank.setCameraId(tank.getCameraId() + 1);
/* 140 */           if (tank.getCameraId() >= tank.getCameraPosNum()) {
/* 141 */             tank.setCameraId(0);
/*     */           }
/* 143 */         } else if (tank.canSwitchGunnerMode()) {
/* 144 */           pc.switchMode = (byte)(tank.getIsGunnerMode((Entity)player) ? 0 : 1);
/* 145 */           tank.switchGunnerMode(!tank.getIsGunnerMode((Entity)player));
/* 146 */           send = true;
/* 147 */           tank.setCameraId(0);
/* 148 */         } else if (tank.canSwitchCameraPos()) {
/* 149 */           tank.setCameraId(1);
/*     */         } else {
/* 151 */           playSoundNG();
/*     */         } 
/*     */       }
/* 154 */     } else if (this.KeySwitchMode.isKeyDown()) {
/* 155 */       if (tank.canSwitchGunnerModeOtherSeat(player)) {
/* 156 */         tank.switchGunnerModeOtherSeat(player);
/* 157 */         send = true;
/*     */       } else {
/* 159 */         playSoundNG();
/*     */       } 
/*     */     } 
/*     */     
/* 163 */     if (this.KeyZoom.isKeyDown()) {
/* 164 */       boolean isUav = (tank.isUAV() && !tank.getAcInfo().haveHatch());
/* 165 */       if (!tank.getIsGunnerMode((Entity)player) && !isUav) {
/* 166 */         if (isPilot && tank.getAcInfo().haveHatch()) {
/* 167 */           if (tank.canFoldHatch()) {
/* 168 */             pc.switchHatch = 2;
/* 169 */             send = true;
/* 170 */           } else if (tank.canUnfoldHatch()) {
/* 171 */             pc.switchHatch = 1;
/* 172 */             send = true;
/*     */           } 
/*     */         }
/*     */       } else {
/* 176 */         tank.zoomCamera();
/* 177 */         playSound("zoom", 0.5F, 1.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 181 */     if (send)
/* 182 */       W_Network.sendToServer((W_PacketBase)pc); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tank\MCH_ClientTankTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */