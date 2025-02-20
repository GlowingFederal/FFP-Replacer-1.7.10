/*     */ package mcheli.gltd;
/*     */ 
/*     */ import mcheli.MCH_ClientTickHandlerBase;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Key;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_ViewEntityDummy;
/*     */ import mcheli.wrapper.W_Network;
/*     */ import mcheli.wrapper.W_PacketBase;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_ClientGLTDTickHandler
/*     */   extends MCH_ClientTickHandlerBase {
/*     */   protected boolean isRiding = false;
/*     */   protected boolean isBeforeRiding = false;
/*     */   public MCH_Key KeyUseWeapon;
/*     */   public MCH_Key KeySwitchWeapon1;
/*     */   public MCH_Key KeySwitchWeapon2;
/*     */   
/*     */   public MCH_ClientGLTDTickHandler(Minecraft minecraft, MCH_Config config) {
/*  25 */     super(minecraft);
/*  26 */     updateKeybind(config);
/*     */   }
/*     */   public MCH_Key KeySwWeaponMode; public MCH_Key KeyZoom; public MCH_Key KeyCameraMode; public MCH_Key KeyUnmount; public MCH_Key KeyUnmount_1_6; public MCH_Key[] Keys;
/*     */   public void updateKeybind(MCH_Config config) {
/*  30 */     this.KeyUseWeapon = new MCH_Key(MCH_Config.KeyUseWeapon.prmInt);
/*  31 */     this.KeySwitchWeapon1 = new MCH_Key(MCH_Config.KeySwitchWeapon1.prmInt);
/*  32 */     this.KeySwitchWeapon2 = new MCH_Key(MCH_Config.KeySwitchWeapon2.prmInt);
/*  33 */     this.KeySwWeaponMode = new MCH_Key(MCH_Config.KeySwWeaponMode.prmInt);
/*  34 */     this.KeyZoom = new MCH_Key(MCH_Config.KeyZoom.prmInt);
/*  35 */     this.KeyCameraMode = new MCH_Key(MCH_Config.KeyCameraMode.prmInt);
/*  36 */     this.KeyUnmount = new MCH_Key(MCH_Config.KeyUnmount.prmInt);
/*  37 */     this.KeyUnmount_1_6 = new MCH_Key(42);
/*  38 */     this.Keys = new MCH_Key[] { this.KeyUseWeapon, this.KeySwWeaponMode, this.KeySwitchWeapon1, this.KeySwitchWeapon2, this.KeyZoom, this.KeyCameraMode, this.KeyUnmount, this.KeyUnmount_1_6 };
/*     */   }
/*     */   
/*     */   protected void updateGLTD(EntityPlayer player, MCH_EntityGLTD gltd) {
/*  42 */     if (player.field_70125_A < -70.0F) {
/*  43 */       player.field_70125_A = -70.0F;
/*     */     }
/*     */     
/*  46 */     if (player.field_70125_A > 70.0F) {
/*  47 */       player.field_70125_A = 70.0F;
/*     */     }
/*     */     
/*  50 */     float yaw = gltd.field_70177_z;
/*  51 */     if (player.field_70177_z < yaw - 70.0F) {
/*  52 */       player.field_70177_z = yaw - 70.0F;
/*     */     }
/*     */     
/*  55 */     if (player.field_70177_z > yaw + 70.0F) {
/*  56 */       player.field_70177_z = yaw + 70.0F;
/*     */     }
/*     */     
/*  59 */     gltd.camera.rotationYaw = player.field_70177_z;
/*  60 */     gltd.camera.rotationPitch = player.field_70125_A;
/*     */   }
/*     */   
/*     */   protected void onTick(boolean inGUI) {
/*  64 */     MCH_Key[] player = this.Keys;
/*  65 */     int viewEntityDummy = player.length;
/*     */     
/*  67 */     for (int gltd = 0; gltd < viewEntityDummy; gltd++) {
/*  68 */       MCH_Key k = player[gltd];
/*  69 */       k.update();
/*     */     } 
/*     */     
/*  72 */     this.isBeforeRiding = this.isRiding;
/*  73 */     EntityClientPlayerMP var6 = this.mc.field_71439_g;
/*  74 */     MCH_ViewEntityDummy var7 = null;
/*  75 */     if (var6 != null && var6.field_70154_o instanceof MCH_EntityGLTD) {
/*  76 */       MCH_EntityGLTD var8 = (MCH_EntityGLTD)var6.field_70154_o;
/*  77 */       updateGLTD((EntityPlayer)var6, var8);
/*  78 */       MCH_Lib.disableFirstPersonItemRender(var6.func_71045_bC());
/*  79 */       var7 = MCH_ViewEntityDummy.getInstance((World)this.mc.field_71441_e);
/*  80 */       var7.update(var8.camera);
/*  81 */       if (!inGUI) {
/*  82 */         playerControl((EntityPlayer)var6, var8);
/*     */       }
/*     */       
/*  85 */       MCH_Lib.setRenderViewEntity((EntityLivingBase)var7);
/*  86 */       this.isRiding = true;
/*     */     } else {
/*  88 */       this.isRiding = false;
/*     */     } 
/*     */     
/*  91 */     if (this.isBeforeRiding != this.isRiding) {
/*  92 */       if (this.isRiding) {
/*  93 */         if (var7 != null) {
/*  94 */           var7.field_70169_q = var7.field_70165_t;
/*  95 */           var7.field_70167_r = var7.field_70163_u;
/*  96 */           var7.field_70166_s = var7.field_70161_v;
/*     */         } 
/*     */       } else {
/*  99 */         MCH_Lib.enableFirstPersonItemRender();
/* 100 */         MCH_Lib.setRenderViewEntity((EntityLivingBase)var6);
/*     */       } 
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   protected void playerControl(EntityPlayer player, MCH_EntityGLTD gltd) {
/* 107 */     MCH_PacketGLTDPlayerControl pc = new MCH_PacketGLTDPlayerControl();
/* 108 */     boolean send = false;
/* 109 */     if (this.KeyUnmount.isKeyDown()) {
/* 110 */       pc.unmount = true;
/* 111 */       send = true;
/*     */     } 
/*     */     
/* 114 */     if ((!this.KeySwitchWeapon1.isKeyDown() || !this.KeySwitchWeapon2.isKeyDown()) && this.KeyUseWeapon.isKeyPress()) {
/* 115 */       if (gltd.useCurrentWeapon(0, 0)) {
/* 116 */         pc.useWeapon = true;
/* 117 */         send = true;
/* 118 */       } else if (this.KeyUseWeapon.isKeyDown()) {
/* 119 */         playSoundNG();
/*     */       } 
/*     */     }
/*     */     
/* 123 */     float prevZoom = gltd.camera.getCameraZoom();
/* 124 */     if (this.KeyZoom.isKeyPress() && !this.KeySwWeaponMode.isKeyPress()) {
/* 125 */       gltd.zoomCamera(0.1F * gltd.camera.getCameraZoom());
/*     */     }
/*     */     
/* 128 */     if (!this.KeyZoom.isKeyPress() && this.KeySwWeaponMode.isKeyPress()) {
/* 129 */       gltd.zoomCamera(-0.1F * gltd.camera.getCameraZoom());
/*     */     }
/*     */     
/* 132 */     if (prevZoom != gltd.camera.getCameraZoom()) {
/* 133 */       playSound("zoom", 0.1F, (prevZoom < gltd.camera.getCameraZoom()) ? 1.0F : 0.85F);
/*     */     }
/*     */     
/* 136 */     if (this.KeyCameraMode.isKeyDown()) {
/* 137 */       int beforeMode = gltd.camera.getMode(0);
/* 138 */       gltd.camera.setMode(0, gltd.camera.getMode(0) + 1);
/* 139 */       int mode = gltd.camera.getMode(0);
/* 140 */       if (mode != beforeMode) {
/* 141 */         pc.switchCameraMode = (byte)mode;
/* 142 */         playSoundOK();
/* 143 */         send = true;
/*     */       } 
/*     */     } 
/*     */     
/* 147 */     if (send)
/* 148 */       W_Network.sendToServer((W_PacketBase)pc); 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\gltd\MCH_ClientGLTDTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */