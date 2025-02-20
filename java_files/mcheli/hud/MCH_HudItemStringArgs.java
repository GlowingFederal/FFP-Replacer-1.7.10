/*    */ package mcheli.hud;
/*    */ 
/*    */ 
/*    */ public enum MCH_HudItemStringArgs
/*    */ {
/*  6 */   NONE("NONE", 0),
/*  7 */   NAME("NAME", 1),
/*  8 */   ALTITUDE("ALTITUDE", 2),
/*  9 */   DATE("DATE", 3),
/* 10 */   MC_THOR("MC_THOR", 4),
/* 11 */   MC_TMIN("MC_TMIN", 5),
/* 12 */   MC_TSEC("MC_TSEC", 6),
/* 13 */   MAX_HP("MAX_HP", 7),
/* 14 */   HP("HP", 8),
/* 15 */   HP_PER("HP_PER", 9),
/* 16 */   POS_X("POS_X", 10),
/* 17 */   POS_Y("POS_Y", 11),
/* 18 */   POS_Z("POS_Z", 12),
/* 19 */   MOTION_X("MOTION_X", 13),
/* 20 */   MOTION_Y("MOTION_Y", 14),
/* 21 */   MOTION_Z("MOTION_Z", 15),
/* 22 */   INVENTORY("INVENTORY", 16),
/* 23 */   WPN_NAME("WPN_NAME", 17),
/* 24 */   WPN_AMMO("WPN_AMMO", 18),
/* 25 */   WPN_RM_AMMO("WPN_RM_AMMO", 19),
/* 26 */   RELOAD_PER("RELOAD_PER", 20),
/* 27 */   RELOAD_SEC("RELOAD_SEC", 21),
/* 28 */   MORTAR_DIST("MORTAR_DIST", 22),
/* 29 */   MC_VER("MC_VER", 23),
/* 30 */   MOD_VER("MOD_VER", 24),
/* 31 */   MOD_NAME("MOD_NAME", 25),
/* 32 */   YAW("YAW", 26),
/* 33 */   PITCH("PITCH", 27),
/* 34 */   ROLL("ROLL", 28),
/* 35 */   PLYR_YAW("PLYR_YAW", 29),
/* 36 */   PLYR_PITCH("PLYR_PITCH", 30),
/* 37 */   TVM_POS_X("TVM_POS_X", 31),
/* 38 */   TVM_POS_Y("TVM_POS_Y", 32),
/* 39 */   TVM_POS_Z("TVM_POS_Z", 33),
/* 40 */   TVM_DIFF("TVM_DIFF", 34),
/* 41 */   CAM_ZOOM("CAM_ZOOM", 35),
/* 42 */   UAV_DIST("UAV_DIST", 36),
/* 43 */   KEY_GUI("KEY_GUI", 37),
/* 44 */   THROTTLE("THROTTLE", 38);
/*    */   static {
/* 46 */     $VALUES = new MCH_HudItemStringArgs[] { NONE, NAME, ALTITUDE, DATE, MC_THOR, MC_TMIN, MC_TSEC, MAX_HP, HP, HP_PER, POS_X, POS_Y, POS_Z, MOTION_X, MOTION_Y, MOTION_Z, INVENTORY, WPN_NAME, WPN_AMMO, WPN_RM_AMMO, RELOAD_PER, RELOAD_SEC, MORTAR_DIST, MC_VER, MOD_VER, MOD_NAME, YAW, PITCH, ROLL, PLYR_YAW, PLYR_PITCH, TVM_POS_X, TVM_POS_Y, TVM_POS_Z, TVM_DIFF, CAM_ZOOM, UAV_DIST, KEY_GUI, THROTTLE };
/*    */   }
/*    */   
/*    */   private static final MCH_HudItemStringArgs[] $VALUES;
/*    */   
/*    */   public static MCH_HudItemStringArgs toArgs(String name) {
/* 52 */     MCH_HudItemStringArgs a = NONE;
/*    */     
/*    */     try {
/*    */       try {
/* 56 */         a = valueOf(name.toUpperCase());
/* 57 */       } catch (Exception var6) {
/* 58 */         var6.printStackTrace();
/*    */       } 
/*    */       
/* 61 */       return a;
/*    */     } finally {}
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemStringArgs.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */