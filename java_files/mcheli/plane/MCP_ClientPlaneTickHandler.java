/*     */ package mcheli.plane;
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
/*     */ public class MCP_ClientPlaneTickHandler extends MCH_AircraftClientTickHandler {
/*     */   public MCH_Key KeySwitchMode;
/*     */   public MCH_Key KeyEjectSeat;
/*     */   
/*     */   public MCP_ClientPlaneTickHandler(Minecraft minecraft, MCH_Config config) {
/*  26 */     super(minecraft, config);
/*  27 */     updateKeybind(config);
/*     */   }
/*     */   public MCH_Key KeyZoom; public MCH_Key[] Keys;
/*     */   public void updateKeybind(MCH_Config config) {
/*  31 */     super.updateKeybind(config);
/*  32 */     this.KeySwitchMode = new MCH_Key(MCH_Config.KeySwitchMode.prmInt);
/*  33 */     this.KeyEjectSeat = new MCH_Key(MCH_Config.KeySwitchHovering.prmInt);
/*  34 */     this.KeyZoom = new MCH_Key(MCH_Config.KeyZoom.prmInt);
/*  35 */     this.Keys = new MCH_Key[] { this.KeyUp, this.KeyDown, this.KeyRight, this.KeyLeft, this.KeySwitchMode, this.KeyEjectSeat, this.KeyUseWeapon, this.KeySwWeaponMode, this.KeySwitchWeapon1, this.KeySwitchWeapon2, this.KeyZoom, this.KeyCameraMode, this.KeyUnmount, this.KeyUnmountForce, this.KeyFlare, this.KeyExtra, this.KeyFreeLook, this.KeyGUI, this.KeyGearUpDown, this.KeyPutToRack, this.KeyDownFromRack };
/*     */   }
/*     */   
/*     */   protected void update(EntityPlayer player, MCP_EntityPlane plane) {
/*  39 */     if (plane.getIsGunnerMode((Entity)player)) {
/*  40 */       MCH_SeatInfo seatInfo = plane.getSeatInfo((Entity)player);
/*  41 */       if (seatInfo != null) {
/*  42 */         setRotLimitPitch(seatInfo.minPitch, seatInfo.maxPitch, (Entity)player);
/*     */       }
/*     */     } 
/*     */     
/*  46 */     plane.updateRadar(50);
/*  47 */     plane.updateCameraRotate(player.field_70177_z, player.field_70125_A);
/*     */   }
/*     */   
/*     */   protected void onTick(boolean inGUI) {
/*  51 */     MCH_Key[] player = this.Keys;
/*  52 */     int plane = player.length;
/*     */     
/*  54 */     for (int isPilot = 0; isPilot < plane; isPilot++) {
/*  55 */       MCH_Key viewEntityDummy = player[isPilot];
/*  56 */       viewEntityDummy.update();
/*     */     } 
/*     */     
/*  59 */     this.isBeforeRiding = this.isRiding;
/*  60 */     EntityClientPlayerMP var7 = this.mc.field_71439_g;
/*  61 */     MCP_EntityPlane var8 = null;
/*  62 */     boolean var9 = true;
/*  63 */     if (var7 != null) {
/*  64 */       if (var7.field_70154_o instanceof MCP_EntityPlane) {
/*  65 */         var8 = (MCP_EntityPlane)var7.field_70154_o;
/*  66 */       } else if (var7.field_70154_o instanceof MCH_EntitySeat) {
/*  67 */         MCH_EntitySeat var10 = (MCH_EntitySeat)var7.field_70154_o;
/*  68 */         if (var10.getParent() instanceof MCP_EntityPlane) {
/*  69 */           var9 = false;
/*  70 */           var8 = (MCP_EntityPlane)var10.getParent();
/*     */         } 
/*  72 */       } else if (var7.field_70154_o instanceof MCH_EntityUavStation) {
/*  73 */         MCH_EntityUavStation var11 = (MCH_EntityUavStation)var7.field_70154_o;
/*  74 */         if (var11.getControlAircract() instanceof MCP_EntityPlane) {
/*  75 */           var8 = (MCP_EntityPlane)var11.getControlAircract();
/*     */         }
/*     */       } 
/*     */     }
/*     */     
/*  80 */     if (var8 != null && var8.getAcInfo() != null) {
/*  81 */       update((EntityPlayer)var7, var8);
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
/*  93 */       if ((!var9 || !var8.isAlwaysCameraView()) && !var8.getIsGunnerMode((Entity)var7) && var8.getCameraId() <= 0) {
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
/* 111 */     if (!this.isBeforeRiding && this.isRiding && var8 != null) {
/* 112 */       MCH_ViewEntityDummy.getInstance((World)this.mc.field_71441_e).func_70107_b(var8.field_70165_t, var8.field_70163_u + 0.5D, var8.field_70161_v);
/* 113 */     } else if (this.isBeforeRiding && !this.isRiding) {
/* 114 */       MCH_Lib.enableFirstPersonItemRender();
/* 115 */       MCH_Lib.setRenderViewEntity((EntityLivingBase)var7);
/* 116 */       W_Reflection.setCameraRoll(0.0F);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void playerControlInGUI(EntityPlayer player, MCP_EntityPlane plane, boolean isPilot) {
/* 122 */     commonPlayerControlInGUI(player, plane, isPilot, new MCP_PlanePacketPlayerControl());
/*     */   }
/*     */   
/*     */   protected void playerControl(EntityPlayer player, MCP_EntityPlane plane, boolean isPilot) {
/* 126 */     MCP_PlanePacketPlayerControl pc = new MCP_PlanePacketPlayerControl();
/* 127 */     boolean send = false;
/* 128 */     send = commonPlayerControl(player, plane, isPilot, pc);
/*     */     
/* 130 */     if (isPilot) {
/* 131 */       if (this.KeySwitchMode.isKeyDown()) {
/* 132 */         if (plane.getIsGunnerMode((Entity)player) && plane.canSwitchCameraPos()) {
/* 133 */           pc.switchMode = 0;
/* 134 */           plane.switchGunnerMode(false);
/* 135 */           send = true;
/* 136 */           plane.setCameraId(1);
/* 137 */         } else if (plane.getCameraId() > 0) {
/* 138 */           plane.setCameraId(plane.getCameraId() + 1);
/* 139 */           if (plane.getCameraId() >= plane.getCameraPosNum()) {
/* 140 */             plane.setCameraId(0);
/*     */           }
/* 142 */         } else if (plane.canSwitchGunnerMode()) {
/* 143 */           pc.switchMode = (byte)(plane.getIsGunnerMode((Entity)player) ? 0 : 1);
/* 144 */           plane.switchGunnerMode(!plane.getIsGunnerMode((Entity)player));
/* 145 */           send = true;
/* 146 */           plane.setCameraId(0);
/* 147 */         } else if (plane.canSwitchCameraPos()) {
/* 148 */           plane.setCameraId(1);
/*     */         } else {
/* 150 */           playSoundNG();
/*     */         } 
/*     */       }
/*     */       
/* 154 */       if (this.KeyExtra.isKeyDown()) {
/* 155 */         if (plane.canSwitchVtol()) {
/* 156 */           boolean isUav = plane.getNozzleStat();
/* 157 */           if (!isUav) {
/* 158 */             pc.switchVtol = 1;
/*     */           } else {
/* 160 */             pc.switchVtol = 0;
/*     */           } 
/*     */           
/* 163 */           plane.swithVtolMode(!isUav);
/* 164 */           send = true;
/*     */         } else {
/* 166 */           playSoundNG();
/*     */         } 
/*     */       }
/* 169 */     } else if (this.KeySwitchMode.isKeyDown()) {
/* 170 */       if (plane.canSwitchGunnerModeOtherSeat(player)) {
/* 171 */         plane.switchGunnerModeOtherSeat(player);
/* 172 */         send = true;
/*     */       } else {
/* 174 */         playSoundNG();
/*     */       } 
/*     */     } 
/*     */     
/* 178 */     if (this.KeyZoom.isKeyDown()) {
/* 179 */       boolean isUav = (plane.isUAV() && !plane.getAcInfo().haveHatch() && !plane.getPlaneInfo().haveWing());
/* 180 */       if (!plane.getIsGunnerMode((Entity)player) && !isUav) {
/* 181 */         if (isPilot) {
/* 182 */           if (plane.getAcInfo().haveHatch()) {
/* 183 */             if (plane.canFoldHatch()) {
/* 184 */               pc.switchHatch = 2;
/* 185 */               send = true;
/* 186 */             } else if (plane.canUnfoldHatch()) {
/* 187 */               pc.switchHatch = 1;
/* 188 */               send = true;
/*     */             } 
/* 190 */           } else if (plane.canFoldWing()) {
/* 191 */             pc.switchHatch = 2;
/* 192 */             send = true;
/* 193 */           } else if (plane.canUnfoldWing()) {
/* 194 */             pc.switchHatch = 1;
/* 195 */             send = true;
/*     */           } 
/*     */         }
/*     */       } else {
/* 199 */         plane.zoomCamera();
/* 200 */         playSound("zoom", 0.5F, 1.0F);
/*     */       } 
/*     */     } 
/*     */     
/* 204 */     if (this.KeyEjectSeat.isKeyDown() && plane.canEjectSeat((Entity)player)) {
/* 205 */       pc.ejectSeat = true;
/* 206 */       send = true;
/*     */     } 
/*     */     
/* 209 */     if (send)
/* 210 */       W_Network.sendToServer((W_PacketBase)pc); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\plane\MCP_ClientPlaneTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */