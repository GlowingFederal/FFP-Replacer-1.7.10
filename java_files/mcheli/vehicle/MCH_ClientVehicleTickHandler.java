/*     */ package mcheli.vehicle;
/*     */ 
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Key;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_ViewEntityDummy;
/*     */ import mcheli.aircraft.MCH_AircraftClientTickHandler;
/*     */ import mcheli.aircraft.MCH_EntitySeat;
/*     */ import mcheli.wrapper.W_Network;
/*     */ import mcheli.wrapper.W_PacketBase;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_ClientVehicleTickHandler
/*     */   extends MCH_AircraftClientTickHandler {
/*     */   public MCH_Key KeySwitchMode;
/*     */   public MCH_Key KeySwitchHovering;
/*     */   
/*     */   public MCH_ClientVehicleTickHandler(Minecraft minecraft, MCH_Config config) {
/*  24 */     super(minecraft, config);
/*  25 */     updateKeybind(config);
/*     */   }
/*     */   public MCH_Key KeyZoom; public MCH_Key KeyExtra; public MCH_Key[] Keys;
/*     */   public void updateKeybind(MCH_Config config) {
/*  29 */     super.updateKeybind(config);
/*  30 */     this.KeySwitchMode = new MCH_Key(MCH_Config.KeySwitchMode.prmInt);
/*  31 */     this.KeySwitchHovering = new MCH_Key(MCH_Config.KeySwitchHovering.prmInt);
/*  32 */     this.KeyZoom = new MCH_Key(MCH_Config.KeyZoom.prmInt);
/*  33 */     this.KeyExtra = new MCH_Key(MCH_Config.KeyExtra.prmInt);
/*  34 */     this.Keys = new MCH_Key[] { this.KeyUp, this.KeyDown, this.KeyRight, this.KeyLeft, this.KeySwitchMode, this.KeySwitchHovering, this.KeyUseWeapon, this.KeySwWeaponMode, this.KeySwitchWeapon1, this.KeySwitchWeapon2, this.KeyZoom, this.KeyCameraMode, this.KeyUnmount, this.KeyUnmountForce, this.KeyFlare, this.KeyExtra, this.KeyGUI };
/*     */   }
/*     */   
/*     */   protected void update(EntityPlayer player, MCH_EntityVehicle vehicle, MCH_VehicleInfo info) {
/*  38 */     if (info != null) {
/*  39 */       setRotLimitPitch(info.minRotationPitch, info.maxRotationPitch, (Entity)player);
/*     */     }
/*     */     
/*  42 */     vehicle.updateCameraRotate(player.field_70177_z, player.field_70125_A);
/*  43 */     vehicle.updateRadar(50);
/*     */   }
/*     */   
/*     */   protected void onTick(boolean inGUI) {
/*  47 */     MCH_Key[] player = this.Keys;
/*  48 */     int vehicle = player.length;
/*     */     
/*  50 */     for (int isPilot = 0; isPilot < vehicle; isPilot++) {
/*  51 */       MCH_Key viewEntityDummy = player[isPilot];
/*  52 */       viewEntityDummy.update();
/*     */     } 
/*     */     
/*  55 */     this.isBeforeRiding = this.isRiding;
/*  56 */     EntityClientPlayerMP var6 = this.mc.field_71439_g;
/*  57 */     MCH_EntityVehicle var7 = null;
/*  58 */     boolean var8 = true;
/*  59 */     if (var6 != null) {
/*  60 */       if (var6.field_70154_o instanceof MCH_EntityVehicle) {
/*  61 */         var7 = (MCH_EntityVehicle)var6.field_70154_o;
/*  62 */       } else if (var6.field_70154_o instanceof MCH_EntitySeat) {
/*  63 */         MCH_EntitySeat var9 = (MCH_EntitySeat)var6.field_70154_o;
/*  64 */         if (var9.getParent() instanceof MCH_EntityVehicle) {
/*  65 */           var8 = false;
/*  66 */           var7 = (MCH_EntityVehicle)var9.getParent();
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/*  71 */     if (var7 != null && var7.getAcInfo() != null) {
/*  72 */       MCH_Lib.disableFirstPersonItemRender(var6.func_71045_bC());
/*  73 */       update((EntityPlayer)var6, var7, var7.getVehicleInfo());
/*  74 */       MCH_ViewEntityDummy var10 = MCH_ViewEntityDummy.getInstance((World)this.mc.field_71441_e);
/*  75 */       var10.update(var7.camera);
/*  76 */       if (!inGUI) {
/*  77 */         if (!var7.isDestroyed()) {
/*  78 */           playerControl((EntityPlayer)var6, var7, var8);
/*     */         }
/*     */       } else {
/*  81 */         playerControlInGUI((EntityPlayer)var6, var7, var8);
/*     */       } 
/*     */       
/*  84 */       MCH_Lib.setRenderViewEntity((EntityLivingBase)var10);
/*  85 */       this.isRiding = true;
/*     */     } else {
/*  87 */       this.isRiding = false;
/*     */     } 
/*     */     
/*  90 */     if ((this.isBeforeRiding || !this.isRiding) && this.isBeforeRiding && !this.isRiding) {
/*  91 */       MCH_Lib.enableFirstPersonItemRender();
/*  92 */       MCH_Lib.setRenderViewEntity((EntityLivingBase)var6);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected void playerControlInGUI(EntityPlayer player, MCH_EntityVehicle vehicle, boolean isPilot) {
/*  98 */     commonPlayerControlInGUI(player, vehicle, isPilot, new MCH_PacketVehiclePlayerControl());
/*     */   }
/*     */   
/*     */   protected void playerControl(EntityPlayer player, MCH_EntityVehicle vehicle, boolean isPilot) {
/* 102 */     MCH_PacketVehiclePlayerControl pc = new MCH_PacketVehiclePlayerControl();
/* 103 */     boolean send = false;
/* 104 */     send = commonPlayerControl(player, vehicle, isPilot, pc);
/* 105 */     if (this.KeyExtra.isKeyDown()) {
/* 106 */       playSoundNG();
/*     */     }
/*     */     
/* 109 */     if (this.KeySwitchHovering.isKeyDown() || this.KeySwitchMode.isKeyDown());
/*     */ 
/*     */ 
/*     */     
/* 113 */     if (this.KeyZoom.isKeyDown()) {
/* 114 */       if (vehicle.canZoom()) {
/* 115 */         vehicle.zoomCamera();
/* 116 */         playSound("zoom", 0.5F, 1.0F);
/* 117 */       } else if (vehicle.getAcInfo().haveHatch()) {
/* 118 */         if (vehicle.canFoldHatch()) {
/* 119 */           pc.switchHatch = 2;
/* 120 */           send = true;
/* 121 */         } else if (vehicle.canUnfoldHatch()) {
/* 122 */           pc.switchHatch = 1;
/* 123 */           send = true;
/*     */         } else {
/* 125 */           playSoundNG();
/*     */         } 
/*     */       } 
/*     */     }
/*     */     
/* 130 */     if (send)
/* 131 */       W_Network.sendToServer((W_PacketBase)pc); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\vehicle\MCH_ClientVehicleTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */