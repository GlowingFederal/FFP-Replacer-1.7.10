/*     */ package mcheli.lweapon;
/*     */ import java.nio.FloatBuffer;
/*     */ import java.nio.IntBuffer;
/*     */ import mcheli.MCH_ClientTickHandlerBase;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_Key;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.weapon.MCH_WeaponGuidanceSystem;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_Network;
/*     */ import mcheli.wrapper.W_PacketBase;
/*     */ import mcheli.wrapper.W_Reflection;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.Vec3;
/*     */ import org.lwjgl.BufferUtils;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ import org.lwjgl.util.glu.GLU;
/*     */ 
/*     */ public class MCH_ClientLightWeaponTickHandler extends MCH_ClientTickHandlerBase {
/*  29 */   private static FloatBuffer screenPos = BufferUtils.createFloatBuffer(3);
/*  30 */   private static FloatBuffer screenPosBB = BufferUtils.createFloatBuffer(3);
/*  31 */   private static FloatBuffer matModel = BufferUtils.createFloatBuffer(16);
/*  32 */   private static FloatBuffer matProjection = BufferUtils.createFloatBuffer(16);
/*  33 */   private static IntBuffer matViewport = BufferUtils.createIntBuffer(16);
/*     */   protected boolean isHeldItem = false;
/*     */   protected boolean isBeforeHeldItem = false;
/*  36 */   protected EntityPlayer prevThePlayer = null;
/*  37 */   protected ItemStack prevItemStack = null;
/*     */   public MCH_Key KeyAttack;
/*     */   public MCH_Key KeyUseWeapon;
/*     */   public MCH_Key KeySwWeaponMode;
/*     */   public MCH_Key KeyZoom;
/*     */   public MCH_Key KeyCameraMode;
/*     */   public MCH_Key[] Keys;
/*     */   protected static MCH_WeaponBase weapon;
/*     */   public static int reloadCount;
/*     */   public static int lockonSoundCount;
/*     */   public static int weaponMode;
/*     */   public static int selectedZoom;
/*  49 */   public static Entity markEntity = null;
/*  50 */   public static Vec3 markPos = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/*  51 */   public static MCH_WeaponGuidanceSystem gs = new MCH_WeaponGuidanceSystem();
/*  52 */   public static double lockRange = 120.0D;
/*     */ 
/*     */   
/*     */   public MCH_ClientLightWeaponTickHandler(Minecraft minecraft, MCH_Config config) {
/*  56 */     super(minecraft);
/*  57 */     updateKeybind(config);
/*  58 */     gs.canLockInAir = false;
/*  59 */     gs.canLockOnGround = false;
/*  60 */     gs.canLockInWater = false;
/*  61 */     gs.setLockCountMax(40);
/*  62 */     gs.lockRange = 120.0D;
/*  63 */     lockonSoundCount = 0;
/*  64 */     initWeaponParam((EntityPlayer)null);
/*     */   }
/*     */   
/*     */   public static void markEntity(Entity entity, double x, double y, double z) {
/*  68 */     if (gs.getLockingEntity() == entity) {
/*  69 */       GL11.glGetFloat(2982, matModel);
/*  70 */       GL11.glGetFloat(2983, matProjection);
/*  71 */       GL11.glGetInteger(2978, matViewport);
/*  72 */       GLU.gluProject((float)x, (float)y, (float)z, matModel, matProjection, matViewport, screenPos);
/*  73 */       MCH_AircraftInfo i = (entity instanceof MCH_EntityAircraft) ? ((MCH_EntityAircraft)entity).getAcInfo() : null;
/*  74 */       float w = (i != null) ? i.markerWidth : ((entity.field_70130_N > entity.field_70131_O) ? entity.field_70130_N : entity.field_70131_O);
/*  75 */       float h = (i != null) ? i.markerHeight : entity.field_70131_O;
/*  76 */       GLU.gluProject((float)x + w, (float)y + h, (float)z + w, matModel, matProjection, matViewport, screenPosBB);
/*  77 */       markEntity = entity;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static Vec3 getMartEntityPos() {
/*  83 */     return (gs.getLockingEntity() == markEntity && markEntity != null) ? Vec3.func_72443_a(screenPos.get(0), screenPos.get(1), screenPos.get(2)) : null;
/*     */   }
/*     */   
/*     */   public static Vec3 getMartEntityBBPos() {
/*  87 */     return (gs.getLockingEntity() == markEntity && markEntity != null) ? Vec3.func_72443_a(screenPosBB.get(0), screenPosBB.get(1), screenPosBB.get(2)) : null;
/*     */   }
/*     */   
/*     */   public void initWeaponParam(EntityPlayer player) {
/*  91 */     reloadCount = 0;
/*  92 */     weaponMode = 0;
/*  93 */     selectedZoom = 0;
/*     */   }
/*     */   
/*     */   public void updateKeybind(MCH_Config config) {
/*  97 */     this.KeyAttack = new MCH_Key(MCH_Config.KeyAttack.prmInt);
/*  98 */     this.KeyUseWeapon = new MCH_Key(MCH_Config.KeyUseWeapon.prmInt);
/*  99 */     this.KeySwWeaponMode = new MCH_Key(MCH_Config.KeySwWeaponMode.prmInt);
/* 100 */     this.KeyZoom = new MCH_Key(MCH_Config.KeyZoom.prmInt);
/* 101 */     this.KeyCameraMode = new MCH_Key(MCH_Config.KeyCameraMode.prmInt);
/* 102 */     this.Keys = new MCH_Key[] { this.KeyAttack, this.KeyUseWeapon, this.KeySwWeaponMode, this.KeyZoom, this.KeyCameraMode };
/*     */   }
/*     */   
/*     */   protected void onTick(boolean inGUI) {
/* 106 */     MCH_Key[] player = this.Keys;
/* 107 */     int is = player.length;
/*     */     
/* 109 */     for (int pc = 0; pc < is; pc++) {
/* 110 */       MCH_Key RELOAD_CNT = player[pc];
/* 111 */       RELOAD_CNT.update();
/*     */     } 
/*     */     
/* 114 */     this.isBeforeHeldItem = this.isHeldItem;
/* 115 */     EntityClientPlayerMP var6 = this.mc.field_71439_g;
/* 116 */     if (this.prevThePlayer == null || this.prevThePlayer != var6) {
/* 117 */       initWeaponParam((EntityPlayer)var6);
/* 118 */       this.prevThePlayer = (EntityPlayer)var6;
/*     */     } 
/*     */     
/* 121 */     ItemStack var7 = (var6 != null) ? var6.func_70694_bm() : null;
/* 122 */     if (var6 == null || var6.field_70154_o instanceof mcheli.gltd.MCH_EntityGLTD || var6.field_70154_o instanceof MCH_EntityAircraft) {
/* 123 */       var7 = null;
/*     */     }
/*     */     
/* 126 */     if (gs.getLockingEntity() == null) {
/* 127 */       markEntity = null;
/*     */     }
/*     */     
/* 130 */     if (var7 != null && var7.func_77973_b() instanceof MCH_ItemLightWeaponBase) {
/* 131 */       MCH_ItemLightWeaponBase var8 = (MCH_ItemLightWeaponBase)var7.func_77973_b();
/* 132 */       if (this.prevItemStack == null || (!this.prevItemStack.func_77969_a(var7) && !this.prevItemStack.func_77977_a().equals(var7.func_77977_a()))) {
/* 133 */         initWeaponParam((EntityPlayer)var6);
/* 134 */         weapon = MCH_WeaponCreator.createWeapon(var6.field_70170_p, MCH_ItemLightWeaponBase.getName(var7), Vec3.func_72443_a(0.0D, 0.0D, 0.0D), 0.0F, 0.0F, (MCH_IEntityLockChecker)null, false);
/* 135 */         if (weapon != null && weapon.getInfo() != null && weapon.getGuidanceSystem() != null) {
/* 136 */           gs = weapon.getGuidanceSystem();
/*     */         }
/*     */       } 
/*     */       
/* 140 */       if (weapon == null || gs == null) {
/*     */         return;
/*     */       }
/*     */       
/* 144 */       gs.setWorld(var6.field_70170_p);
/* 145 */       gs.lockRange = lockRange;
/* 146 */       if (var6.func_71057_bx() > 10) {
/* 147 */         selectedZoom %= (weapon.getInfo()).zoom.length;
/* 148 */         W_Reflection.setCameraZoom((weapon.getInfo()).zoom[selectedZoom]);
/*     */       } else {
/* 150 */         W_Reflection.restoreCameraZoom();
/*     */       } 
/*     */       
/* 153 */       if (var7.func_77960_j() < var7.func_77958_k()) {
/* 154 */         if (var6.func_71057_bx() > 10) {
/* 155 */           gs.lock((Entity)var6);
/* 156 */           if (gs.getLockCount() > 0) {
/* 157 */             if (lockonSoundCount > 0) {
/* 158 */               lockonSoundCount--;
/*     */             } else {
/* 160 */               lockonSoundCount = 7;
/* 161 */               lockonSoundCount = (int)(lockonSoundCount * (1.0D - gs.getLockCount() / gs.getLockCountMax()));
/* 162 */               if (lockonSoundCount < 3) {
/* 163 */                 lockonSoundCount = 2;
/*     */               }
/*     */               
/* 166 */               W_McClient.MOD_playSoundFX("lockon", 1.0F, 1.0F);
/*     */             } 
/*     */           }
/*     */         } else {
/* 170 */           W_Reflection.restoreCameraZoom();
/* 171 */           gs.clearLock();
/*     */         } 
/*     */         
/* 174 */         reloadCount = 0;
/*     */       } else {
/* 176 */         lockonSoundCount = 0;
/* 177 */         if (W_EntityPlayer.hasItem((EntityPlayer)var6, (Item)var8.bullet) && var6.func_71052_bv() <= 0) {
/* 178 */           if (reloadCount == 10) {
/* 179 */             W_McClient.MOD_playSoundFX("fim92_reload", 1.0F, 1.0F);
/*     */           }
/*     */           
/* 182 */           boolean var10 = true;
/* 183 */           if (reloadCount < 40) {
/* 184 */             reloadCount++;
/* 185 */             if (reloadCount == 40) {
/* 186 */               onCompleteReload();
/*     */             }
/*     */           } 
/*     */         } else {
/* 190 */           reloadCount = 0;
/*     */         } 
/*     */         
/* 193 */         gs.clearLock();
/*     */       } 
/*     */       
/* 196 */       if (!inGUI) {
/* 197 */         playerControl((EntityPlayer)var6, var7, (MCH_ItemLightWeaponBase)var7.func_77973_b());
/*     */       }
/*     */       
/* 200 */       this.isHeldItem = MCH_ItemLightWeaponBase.isHeld((EntityPlayer)var6);
/*     */     } else {
/* 202 */       lockonSoundCount = 0;
/* 203 */       reloadCount = 0;
/* 204 */       this.isHeldItem = false;
/*     */     } 
/*     */     
/* 207 */     if (this.isBeforeHeldItem != this.isHeldItem) {
/* 208 */       MCH_Lib.DbgLog(true, "LWeapon cancel", new Object[0]);
/* 209 */       if (!this.isHeldItem) {
/* 210 */         if (getPotionNightVisionDuration((EntityPlayer)var6) < 250) {
/* 211 */           MCH_PacketLightWeaponPlayerControl var9 = new MCH_PacketLightWeaponPlayerControl();
/* 212 */           var9.camMode = 1;
/* 213 */           W_Network.sendToServer((W_PacketBase)var9);
/* 214 */           var6.func_70618_n(Potion.field_76439_r.func_76396_c());
/*     */         } 
/*     */         
/* 217 */         W_Reflection.restoreCameraZoom();
/*     */       } 
/*     */     } 
/*     */     
/* 221 */     this.prevItemStack = var7;
/* 222 */     gs.update();
/*     */   }
/*     */   
/*     */   protected void onCompleteReload() {
/* 226 */     MCH_PacketLightWeaponPlayerControl pc = new MCH_PacketLightWeaponPlayerControl();
/* 227 */     pc.cmpReload = 1;
/* 228 */     W_Network.sendToServer((W_PacketBase)pc);
/*     */   }
/*     */   
/*     */   protected void playerControl(EntityPlayer player, ItemStack is, MCH_ItemLightWeaponBase item) {
/* 232 */     MCH_PacketLightWeaponPlayerControl pc = new MCH_PacketLightWeaponPlayerControl();
/* 233 */     boolean send = false;
/* 234 */     boolean autoShot = false;
/* 235 */     MCH_Config var10000 = MCH_MOD.config;
/* 236 */     if (MCH_Config.LWeaponAutoFire.prmBool && is.func_77960_j() < is.func_77958_k() && gs.isLockComplete()) {
/* 237 */       autoShot = true;
/*     */     }
/*     */     
/* 240 */     if (this.KeySwWeaponMode.isKeyDown() && weapon.numMode > 1) {
/* 241 */       weaponMode = (weaponMode + 1) % weapon.numMode;
/* 242 */       W_McClient.MOD_playSoundFX("pi", 0.5F, 0.9F);
/*     */     } 
/*     */     
/* 245 */     if (this.KeyAttack.isKeyPress() || autoShot) {
/* 246 */       boolean pe = false;
/* 247 */       if (is.func_77960_j() < is.func_77958_k() && gs.isLockComplete()) {
/* 248 */         boolean canFire = true;
/* 249 */         if (weaponMode > 0 && gs.getTargetEntity() != null) {
/* 250 */           double dx = (gs.getTargetEntity()).field_70165_t - player.field_70165_t;
/* 251 */           double dz = (gs.getTargetEntity()).field_70161_v - player.field_70161_v;
/* 252 */           canFire = (Math.sqrt(dx * dx + dz * dz) >= 40.0D);
/*     */         } 
/*     */         
/* 255 */         if (canFire) {
/* 256 */           pc.useWeapon = true;
/* 257 */           pc.useWeaponOption1 = W_Entity.getEntityId(gs.lastLockEntity);
/* 258 */           pc.useWeaponOption2 = weaponMode;
/* 259 */           pc.useWeaponPosX = player.field_70165_t;
/* 260 */           pc.useWeaponPosY = player.field_70163_u;
/* 261 */           pc.useWeaponPosZ = player.field_70161_v;
/* 262 */           gs.clearLock();
/* 263 */           send = true;
/* 264 */           pe = true;
/*     */         } 
/*     */       } 
/*     */       
/* 268 */       if (this.KeyAttack.isKeyDown() && !pe && player.func_71057_bx() > 5) {
/* 269 */         playSoundNG();
/*     */       }
/*     */     } 
/*     */     
/* 273 */     if (this.KeyZoom.isKeyDown()) {
/* 274 */       int pe1 = selectedZoom;
/* 275 */       selectedZoom = (selectedZoom + 1) % (weapon.getInfo()).zoom.length;
/* 276 */       if (pe1 != selectedZoom) {
/* 277 */         playSound("zoom", 0.5F, 1.0F);
/*     */       }
/*     */     } 
/*     */     
/* 281 */     if (this.KeyCameraMode.isKeyDown()) {
/* 282 */       PotionEffect pe2 = player.func_70660_b(Potion.field_76439_r);
/* 283 */       MCH_Lib.DbgLog(true, "LWeapon NV %s", new Object[] { (pe2 != null) ? "ON->OFF" : "OFF->ON" });
/* 284 */       if (pe2 != null) {
/* 285 */         player.func_70618_n(Potion.field_76439_r.func_76396_c());
/* 286 */         pc.camMode = 1;
/* 287 */         send = true;
/* 288 */         W_McClient.MOD_playSoundFX("pi", 0.5F, 0.9F);
/* 289 */       } else if (player.func_71057_bx() > 60) {
/* 290 */         pc.camMode = 2;
/* 291 */         send = true;
/* 292 */         W_McClient.MOD_playSoundFX("pi", 0.5F, 0.9F);
/*     */       } else {
/* 294 */         playSoundNG();
/*     */       } 
/*     */     } 
/*     */     
/* 298 */     if (send) {
/* 299 */       W_Network.sendToServer((W_PacketBase)pc);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getPotionNightVisionDuration(EntityPlayer player) {
/* 305 */     PotionEffect cpe = player.func_70660_b(Potion.field_76439_r);
/* 306 */     return (player != null && cpe != null) ? cpe.func_76459_b() : 0;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\lweapon\MCH_ClientLightWeaponTickHandler.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */