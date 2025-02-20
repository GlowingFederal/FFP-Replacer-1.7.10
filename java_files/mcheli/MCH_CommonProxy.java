/*     */ package mcheli;
/*     */ 
/*     */ import cpw.mods.fml.common.FMLCommonHandler;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_SoundUpdater;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.server.MinecraftServer;
/*     */ import net.minecraft.util.IChatComponent;
/*     */ 
/*     */ 
/*     */ public class MCH_CommonProxy
/*     */ {
/*     */   public String lastConfigFileName;
/*     */   
/*     */   public String getDataDir() {
/*  17 */     return MinecraftServer.func_71276_C().func_71270_I();
/*     */   }
/*     */   
/*     */   public void registerRenderer() {}
/*     */   
/*     */   public void registerBlockRenderer() {}
/*     */   
/*     */   public void registerModels() {}
/*     */   
/*     */   public void registerModelsHeli(String name, boolean reload) {}
/*     */   
/*     */   public void registerModelsPlane(String name, boolean reload) {}
/*     */   
/*     */   public void registerModelsVehicle(String name, boolean reload) {}
/*     */   
/*     */   public void registerModelsTank(String name, boolean reload) {}
/*     */   
/*     */   public void registerClientTick() {}
/*     */   
/*     */   public void registerServerTick() {
/*  37 */     FMLCommonHandler.instance().bus().register(new MCH_ServerTickHandler());
/*     */   }
/*     */   
/*     */   public boolean isRemote() {
/*  41 */     return false;
/*     */   }
/*     */   
/*     */   public String side() {
/*  45 */     return "Server";
/*     */   }
/*     */ 
/*     */   
/*     */   public static boolean checkSafeZone(EntityPlayer player) {
/*  50 */     if (player != null) {
/*  51 */       double x = Math.abs(player.field_70165_t);
/*  52 */       double y = Math.abs(player.field_70163_u);
/*  53 */       double z = Math.abs(player.field_70161_v);
/*  54 */       if (y > 0.0D && y < 255.0D) {
/*  55 */         if (x > -33.0D && z > -15.0D && x < 103.0D && z < 197.0D) {
/*  56 */           return false;
/*     */         }
/*  58 */         return false;
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/*  63 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public void registerSounds() {}
/*     */ 
/*     */   
/*     */   public MCH_Config loadConfig(String fileName) {
/*  71 */     this.lastConfigFileName = fileName;
/*  72 */     MCH_Config config = new MCH_Config("./", fileName);
/*  73 */     config.load();
/*  74 */     config.write();
/*  75 */     return config;
/*     */   }
/*     */   
/*     */   public MCH_Config reconfig() {
/*  79 */     MCH_Lib.DbgLog(false, "MCH_CommonProxy.reconfig()", new Object[0]);
/*  80 */     return loadConfig(this.lastConfigFileName);
/*     */   }
/*     */   
/*     */   public void loadHUD(String path) {}
/*     */   
/*     */   public void reloadHUD() {}
/*     */   
/*     */   public Entity getClientPlayer() {
/*  88 */     return null;
/*     */   }
/*     */   
/*     */   public void setCreativeDigDelay(int n) {}
/*     */   
/*     */   public void init() {}
/*     */   
/*     */   public boolean isFirstPerson() {
/*  96 */     return false;
/*     */   }
/*     */   
/*     */   public int getNewRenderType() {
/* 100 */     return -1;
/*     */   }
/*     */   
/*     */   public boolean isSinglePlayer() {
/* 104 */     return MinecraftServer.func_71276_C().func_71264_H();
/*     */   }
/*     */ 
/*     */   
/*     */   public void readClientModList() {}
/*     */ 
/*     */   
/*     */   public void printChatMessage(IChatComponent chat, int showTime, int pos) {}
/*     */ 
/*     */   
/*     */   public void hitBullet() {}
/*     */   
/*     */   public void clientLocked() {}
/*     */   
/*     */   public MCH_SoundUpdater CreateSoundUpdater(MCH_EntityAircraft mch_EntityAircraft) {
/* 119 */     return null;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_CommonProxy.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */