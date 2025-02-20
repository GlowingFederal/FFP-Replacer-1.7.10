/*     */ package mcheli;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.entity.Entity;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public abstract class MCH_ClientTickHandlerBase
/*     */ {
/*     */   protected Minecraft mc;
/*  15 */   public static float playerRotMinPitch = -90.0F;
/*  16 */   public static float playerRotMaxPitch = 90.0F;
/*     */   public static boolean playerRotLimitPitch = false;
/*  18 */   public static float playerRotMinYaw = -180.0F;
/*  19 */   public static float playerRotMaxYaw = 180.0F;
/*     */   public static boolean playerRotLimitYaw = false;
/*  21 */   private static int mouseWheel = 0;
/*     */ 
/*     */   
/*     */   public abstract void updateKeybind(MCH_Config paramMCH_Config);
/*     */   
/*     */   public static void setRotLimitPitch(float playerRotMinPitch, float playerRotMaxPitch, Entity entity) {
/*  27 */     MCH_ClientTickHandlerBase.playerRotMinPitch = playerRotMinPitch;
/*  28 */     MCH_ClientTickHandlerBase.playerRotMaxPitch = playerRotMaxPitch;
/*  29 */     playerRotLimitPitch = true;
/*  30 */     if (entity != null) {
/*  31 */       entity.field_70125_A = MCH_Lib.RNG(entity.field_70125_A, MCH_ClientTickHandlerBase.playerRotMinPitch, MCH_ClientTickHandlerBase.playerRotMaxPitch);
/*     */     }
/*     */   }
/*     */   
/*     */   public static void setRotLimitYaw(float playerRotMinYaw, float playerRotMaxYaw, Entity entity) {
/*  36 */     MCH_ClientTickHandlerBase.playerRotMinYaw = playerRotMinYaw;
/*  37 */     MCH_ClientTickHandlerBase.playerRotMaxYaw = playerRotMaxYaw;
/*  38 */     playerRotLimitYaw = true;
/*  39 */     if (entity != null) {
/*  40 */       if (entity.field_70125_A < playerRotMinPitch) {
/*  41 */         entity.field_70125_A = playerRotMinPitch;
/*  42 */         entity.field_70127_C = playerRotMinPitch;
/*     */         return;
/*     */       } 
/*  45 */       if (entity.field_70125_A > playerRotMaxPitch) {
/*  46 */         entity.field_70125_A = playerRotMaxPitch;
/*  47 */         entity.field_70127_C = playerRotMaxPitch;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public static void initRotLimit() {
/*  53 */     playerRotMinPitch = -90.0F;
/*  54 */     playerRotMaxPitch = 90.0F;
/*  55 */     playerRotLimitYaw = false;
/*  56 */     playerRotMinYaw = -180.0F;
/*  57 */     playerRotMaxYaw = 180.0F;
/*  58 */     playerRotLimitYaw = false;
/*     */   }
/*     */   
/*     */   public static void applyRotLimit(Entity entity) {
/*  62 */     if (entity != null && playerRotLimitPitch) {
/*  63 */       if (entity.field_70125_A < playerRotMinPitch) {
/*  64 */         entity.field_70125_A = playerRotMinPitch;
/*  65 */         entity.field_70127_C = playerRotMinPitch;
/*     */         return;
/*     */       } 
/*  68 */       if (entity.field_70125_A > playerRotMaxPitch) {
/*  69 */         entity.field_70125_A = playerRotMaxPitch;
/*  70 */         entity.field_70127_C = playerRotMaxPitch;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public MCH_ClientTickHandlerBase(Minecraft minecraft) {
/*  76 */     this.mc = minecraft;
/*     */   }
/*     */   
/*     */   public static boolean updateMouseWheel(int wheel) {
/*  80 */     boolean cancelEvent = false;
/*  81 */     if (wheel != 0) {
/*  82 */       MCH_Config var10000 = MCH_MOD.config;
/*  83 */       if (MCH_Config.SwitchWeaponWithMouseWheel.prmBool) {
/*  84 */         setMouseWheel(0);
/*  85 */         EntityClientPlayerMP player = (Minecraft.func_71410_x()).field_71439_g;
/*  86 */         if (player != null) {
/*  87 */           MCH_EntityAircraft ac = MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)player);
/*  88 */           if (ac != null) {
/*  89 */             int cwid = ac.getWeaponIDBySeatID(ac.getSeatIdByEntity((Entity)player));
/*  90 */             int nwid = ac.getNextWeaponID((Entity)player, 1);
/*  91 */             if (cwid != nwid) {
/*  92 */               setMouseWheel(wheel);
/*  93 */               cancelEvent = true;
/*     */             } 
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 100 */     return cancelEvent;
/*     */   }
/*     */   
/*     */   protected abstract void onTick(boolean paramBoolean);
/*     */   
/*     */   public static void playSoundOK() {
/* 106 */     W_McClient.DEF_playSoundFX("random.click", 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static void playSoundNG() {
/* 110 */     W_McClient.MOD_playSoundFX("ng", 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static void playSound(String name) {
/* 114 */     W_McClient.MOD_playSoundFX(name, 1.0F, 1.0F);
/*     */   }
/*     */   
/*     */   public static void playSound(String name, float vol, float pitch) {
/* 118 */     W_McClient.MOD_playSoundFX(name, vol, pitch);
/*     */   }
/*     */   
/*     */   public static int getMouseWheel() {
/* 122 */     return mouseWheel;
/*     */   }
/*     */   
/*     */   public static void setMouseWheel(int mouseWheel) {
/* 126 */     mouseWheel = mouseWheel;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_ClientTickHandlerBase.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */