/*     */ package mcheli.hud;
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.Random;
/*     */ import mcheli.MCH_ClientCommonTickHandler;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_LowPassFilterFloat;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.eval.eval.ExpRuleFactory;
/*     */ import mcheli.eval.eval.Expression;
/*     */ import mcheli.eval.eval.var.MapVariable;
/*     */ import mcheli.eval.eval.var.Variable;
/*     */ import mcheli.weapon.MCH_EntityTvMissile;
/*     */ import mcheli.weapon.MCH_SightType;
/*     */ import mcheli.weapon.MCH_WeaponBase;
/*     */ import mcheli.weapon.MCH_WeaponInfo;
/*     */ import mcheli.weapon.MCH_WeaponSet;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public abstract class MCH_HudItem extends Gui {
/*     */   public final int fileLine;
/*     */   public static Minecraft mc;
/*  29 */   protected static double centerX = 0.0D; public static EntityPlayer player; public static MCH_EntityAircraft ac;
/*  30 */   protected static double centerY = 0.0D;
/*     */   public static double width;
/*     */   public static double height;
/*  33 */   protected static Random rand = new Random();
/*     */   public static int scaleFactor;
/*  35 */   public static int colorSetting = -16777216;
/*  36 */   protected static int altitudeUpdateCount = 0;
/*  37 */   protected static int Altitude = 0;
/*     */   protected static float prevRadarRot;
/*  39 */   protected static String WeaponName = "";
/*  40 */   protected static String WeaponAmmo = "";
/*  41 */   protected static String WeaponAllAmmo = "";
/*  42 */   protected static MCH_WeaponSet CurrentWeapon = null;
/*  43 */   protected static float ReloadPer = 0.0F;
/*  44 */   protected static float ReloadSec = 0.0F;
/*  45 */   protected static float MortarDist = 0.0F;
/*  46 */   protected static MCH_LowPassFilterFloat StickX_LPF = new MCH_LowPassFilterFloat(4);
/*  47 */   protected static MCH_LowPassFilterFloat StickY_LPF = new MCH_LowPassFilterFloat(4);
/*     */   protected static double StickX;
/*     */   protected static double StickY;
/*     */   protected static double TVM_PosX;
/*     */   protected static double TVM_PosY;
/*     */   protected static double TVM_PosZ;
/*     */   protected static double TVM_Diff;
/*     */   protected static double UAV_Dist;
/*     */   protected static int countFuelWarn;
/*     */   protected static ArrayList EntityList;
/*     */   protected static ArrayList EnemyList;
/*  58 */   protected static Map varMap = null;
/*     */   protected MCH_Hud parent;
/*     */   protected static float partialTicks;
/*  61 */   private static MCH_HudItemExit dummy = new MCH_HudItemExit(0);
/*     */ 
/*     */   
/*     */   public MCH_HudItem(int fileLine) {
/*  65 */     this.fileLine = fileLine;
/*  66 */     this.field_73735_i = -110.0F;
/*     */   }
/*     */   
/*     */   public abstract void execute();
/*     */   
/*     */   public boolean canExecute() {
/*  72 */     return !this.parent.isIfFalse;
/*     */   }
/*     */   
/*     */   public static void update() {
/*  76 */     MCH_WeaponSet ws = ac.getCurrentWeapon((Entity)player);
/*  77 */     updateRadar(ac);
/*  78 */     updateStick();
/*  79 */     updateAltitude(ac);
/*  80 */     updateTvMissile(ac);
/*  81 */     updateUAV(ac);
/*  82 */     updateWeapon(ac, ws);
/*  83 */     updateVarMap(ac, ws);
/*     */   }
/*     */   
/*     */   public static String toFormula(String s) {
/*  87 */     return s.toLowerCase().replaceAll("#", "0x").replace("\t", " ").replace(" ", "");
/*     */   }
/*     */   
/*     */   public static double calc(String s) {
/*  91 */     Expression exp = ExpRuleFactory.getDefaultRule().parse(s);
/*  92 */     exp.setVariable((Variable)new MapVariable(varMap));
/*  93 */     return exp.evalDouble();
/*     */   }
/*     */   
/*     */   public static long calcLong(String s) {
/*  97 */     Expression exp = ExpRuleFactory.getDefaultRule().parse(s);
/*  98 */     exp.setVariable((Variable)new MapVariable(varMap));
/*  99 */     return exp.evalLong();
/*     */   }
/*     */   
/*     */   public void drawCenteredString(String s, int x, int y, int color) {
/* 103 */     func_73732_a(mc.field_71466_p, s, x, y, color);
/*     */   }
/*     */   
/*     */   public void drawString(String s, int x, int y, int color) {
/* 107 */     func_73731_b(mc.field_71466_p, s, x, y, color);
/*     */   }
/*     */   
/*     */   public void drawTexture(String name, double left, double top, double width, double height, double uLeft, double vTop, double uWidth, double vHeight, float rot, int textureWidth, int textureHeight) {
/* 111 */     W_McClient.MOD_bindTexture("textures/gui/" + name + ".png");
/* 112 */     GL11.glPushMatrix();
/* 113 */     GL11.glTranslated(left + width / 2.0D, top + height / 2.0D, 0.0D);
/* 114 */     GL11.glRotatef(rot, 0.0F, 0.0F, 1.0F);
/* 115 */     float fx = (float)(1.0D / textureWidth);
/* 116 */     float fy = (float)(1.0D / textureHeight);
/* 117 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 118 */     tessellator.func_78382_b();
/* 119 */     tessellator.func_78374_a(-width / 2.0D, height / 2.0D, this.field_73735_i, uLeft * fx, (vTop + vHeight) * fy);
/* 120 */     tessellator.func_78374_a(width / 2.0D, height / 2.0D, this.field_73735_i, (uLeft + uWidth) * fx, (vTop + vHeight) * fy);
/* 121 */     tessellator.func_78374_a(width / 2.0D, -height / 2.0D, this.field_73735_i, (uLeft + uWidth) * fx, vTop * fy);
/* 122 */     tessellator.func_78374_a(-width / 2.0D, -height / 2.0D, this.field_73735_i, uLeft * fx, vTop * fy);
/* 123 */     tessellator.func_78381_a();
/* 124 */     GL11.glPopMatrix();
/*     */   }
/*     */ 
/*     */   
/*     */   public static void drawRect(double par0, double par1, double par2, double par3, int par4) {
/* 129 */     if (par0 < par2) {
/* 130 */       double j1 = par0;
/* 131 */       par0 = par2;
/* 132 */       par2 = j1;
/*     */     } 
/*     */     
/* 135 */     if (par1 < par3) {
/* 136 */       double j1 = par1;
/* 137 */       par1 = par3;
/* 138 */       par3 = j1;
/*     */     } 
/*     */     
/* 141 */     float f3 = (par4 >> 24 & 0xFF) / 255.0F;
/* 142 */     float f = (par4 >> 16 & 0xFF) / 255.0F;
/* 143 */     float f1 = (par4 >> 8 & 0xFF) / 255.0F;
/* 144 */     float f2 = (par4 & 0xFF) / 255.0F;
/* 145 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 146 */     GL11.glEnable(3042);
/* 147 */     GL11.glDisable(3553);
/* 148 */     W_OpenGlHelper.glBlendFunc(770, 771, 1, 0);
/* 149 */     GL11.glColor4f(f, f1, f2, f3);
/* 150 */     tessellator.func_78382_b();
/* 151 */     tessellator.func_78377_a(par0, par3, 0.0D);
/* 152 */     tessellator.func_78377_a(par2, par3, 0.0D);
/* 153 */     tessellator.func_78377_a(par2, par1, 0.0D);
/* 154 */     tessellator.func_78377_a(par0, par1, 0.0D);
/* 155 */     tessellator.func_78381_a();
/* 156 */     GL11.glEnable(3553);
/* 157 */     GL11.glDisable(3042);
/*     */   }
/*     */   
/*     */   public void drawLine(double[] line, int color) {
/* 161 */     drawLine(line, color, 1);
/*     */   }
/*     */   
/*     */   public void drawLine(double[] line, int color, int mode) {
/* 165 */     GL11.glPushMatrix();
/* 166 */     GL11.glEnable(3042);
/* 167 */     GL11.glDisable(3553);
/* 168 */     GL11.glBlendFunc(770, 771);
/* 169 */     GL11.glColor4ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color >> 0 & 0xFF), (byte)(color >> 24 & 0xFF));
/* 170 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 171 */     tessellator.func_78371_b(mode);
/*     */     
/* 173 */     for (int i = 0; i < line.length; i += 2) {
/* 174 */       tessellator.func_78377_a(line[i + 0], line[i + 1], this.field_73735_i);
/*     */     }
/*     */     
/* 177 */     tessellator.func_78381_a();
/* 178 */     GL11.glEnable(3553);
/* 179 */     GL11.glDisable(3042);
/* 180 */     GL11.glColor4b((byte)-1, (byte)-1, (byte)-1, (byte)-1);
/* 181 */     GL11.glPopMatrix();
/*     */   }
/*     */   
/*     */   public void drawLineStipple(double[] line, int color, int factor, int pattern) {
/* 185 */     GL11.glEnable(2852);
/* 186 */     GL11.glLineStipple(factor * scaleFactor, (short)pattern);
/* 187 */     drawLine(line, color);
/* 188 */     GL11.glDisable(2852);
/*     */   }
/*     */   
/*     */   public void drawPoints(ArrayList<Double> points, int color, int pointWidth) {
/* 192 */     int prevWidth = GL11.glGetInteger(2833);
/* 193 */     GL11.glPushMatrix();
/* 194 */     GL11.glEnable(3042);
/* 195 */     GL11.glDisable(3553);
/* 196 */     GL11.glBlendFunc(770, 771);
/* 197 */     GL11.glColor4ub((byte)(color >> 16 & 0xFF), (byte)(color >> 8 & 0xFF), (byte)(color >> 0 & 0xFF), (byte)(color >> 24 & 0xFF));
/* 198 */     GL11.glPointSize(pointWidth);
/* 199 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 200 */     tessellator.func_78371_b(0);
/*     */     
/* 202 */     for (int i = 0; i < points.size(); i += 2) {
/* 203 */       tessellator.func_78377_a(((Double)points.get(i)).doubleValue(), ((Double)points.get(i + 1)).doubleValue(), 0.0D);
/*     */     }
/*     */     
/* 206 */     tessellator.func_78381_a();
/* 207 */     GL11.glEnable(3553);
/* 208 */     GL11.glDisable(3042);
/* 209 */     GL11.glPopMatrix();
/* 210 */     GL11.glColor4b((byte)-1, (byte)-1, (byte)-1, (byte)-1);
/* 211 */     GL11.glPointSize(prevWidth);
/*     */   }
/*     */   
/*     */   public static void updateVarMap(MCH_EntityAircraft ac, MCH_WeaponSet ws) {
/* 215 */     if (varMap == null) {
/* 216 */       varMap = new LinkedHashMap<>();
/*     */     }
/*     */     
/* 219 */     updateVarMapItem("color", getColor());
/* 220 */     updateVarMapItem("center_x", centerX);
/* 221 */     updateVarMapItem("center_y", centerY);
/* 222 */     updateVarMapItem("width", width);
/* 223 */     updateVarMapItem("height", height);
/* 224 */     updateVarMapItem("time", (player.field_70170_p.func_72820_D() % 24000L));
/* 225 */     MCH_Config var10001 = MCH_MOD.config;
/* 226 */     updateVarMapItem("test_mode", MCH_Config.TestMode.prmBool ? 1.0D : 0.0D);
/* 227 */     updateVarMapItem("plyr_yaw", MathHelper.func_76142_g(player.field_70177_z));
/* 228 */     updateVarMapItem("plyr_pitch", player.field_70125_A);
/* 229 */     updateVarMapItem("yaw", MathHelper.func_76142_g(ac.getRotYaw()));
/* 230 */     updateVarMapItem("pitch", ac.getRotPitch());
/* 231 */     updateVarMapItem("roll", MathHelper.func_76142_g(ac.getRotRoll()));
/* 232 */     updateVarMapItem("altitude", Altitude);
/* 233 */     updateVarMapItem("sea_alt", getSeaAltitude(ac));
/* 234 */     updateVarMapItem("have_radar", ac.isEntityRadarMounted() ? 1.0D : 0.0D);
/* 235 */     updateVarMapItem("radar_rot", getRadarRot(ac));
/* 236 */     updateVarMapItem("hp", ac.getHP());
/* 237 */     updateVarMapItem("max_hp", ac.getMaxHP());
/* 238 */     updateVarMapItem("hp_rto", (ac.getMaxHP() > 0) ? (ac.getHP() / ac.getMaxHP()) : 0.0D);
/* 239 */     updateVarMapItem("throttle", ac.getCurrentThrottle());
/* 240 */     updateVarMapItem("pos_x", ac.field_70165_t);
/* 241 */     updateVarMapItem("pos_y", ac.field_70163_u);
/* 242 */     updateVarMapItem("pos_z", ac.field_70161_v);
/* 243 */     updateVarMapItem("motion_x", ac.field_70159_w);
/* 244 */     updateVarMapItem("motion_y", ac.field_70181_x);
/* 245 */     updateVarMapItem("motion_z", ac.field_70179_y);
/* 246 */     updateVarMapItem("speed", Math.sqrt(ac.field_70159_w * ac.field_70159_w + ac.field_70181_x * ac.field_70181_x + ac.field_70179_y * ac.field_70179_y));
/* 247 */     updateVarMapItem("fuel", ac.getFuelP());
/* 248 */     updateVarMapItem("low_fuel", isLowFuel(ac));
/* 249 */     updateVarMapItem("stick_x", StickX);
/* 250 */     updateVarMapItem("stick_y", StickY);
/* 251 */     updateVarMap_Weapon(ws);
/* 252 */     updateVarMapItem("vtol_stat", getVtolStat(ac));
/* 253 */     updateVarMapItem("free_look", getFreeLook(ac, player));
/* 254 */     updateVarMapItem("gunner_mode", ac.getIsGunnerMode((Entity)player) ? 1.0D : 0.0D);
/* 255 */     updateVarMapItem("cam_mode", ac.getCameraMode(player));
/* 256 */     updateVarMapItem("cam_zoom", ac.camera.getCameraZoom());
/* 257 */     updateVarMapItem("auto_pilot", getAutoPilot(ac, player));
/* 258 */     updateVarMapItem("have_flare", ac.haveFlare() ? 1.0D : 0.0D);
/* 259 */     updateVarMapItem("can_flare", ac.canUseFlare() ? 1.0D : 0.0D);
/* 260 */     updateVarMapItem("inventory", ac.func_70302_i_());
/* 261 */     updateVarMapItem("hovering", (ac instanceof mcheli.helicopter.MCH_EntityHeli && ac.isHoveringMode()) ? 1.0D : 0.0D);
/* 262 */     updateVarMapItem("is_uav", ac.isUAV() ? 1.0D : 0.0D);
/* 263 */     updateVarMapItem("uav_fs", getUAV_Fs(ac));
/*     */   }
/*     */   
/*     */   public static void updateVarMapItem(String key, double value) {
/* 267 */     varMap.put(key, Double.valueOf(value));
/*     */   }
/*     */   
/*     */   public static void drawVarMap() {
/* 271 */     MCH_Config var10000 = MCH_MOD.config;
/* 272 */     if (MCH_Config.TestMode.prmBool) {
/* 273 */       int i = 0;
/* 274 */       int x = (int)(-300.0D + centerX);
/* 275 */       int y = (int)(-100.0D + centerY);
/* 276 */       Iterator<String> i$ = varMap.keySet().iterator();
/*     */       
/* 278 */       while (i$.hasNext()) {
/* 279 */         String key = i$.next();
/* 280 */         dummy.drawString(key, x, y, -12544);
/* 281 */         Double d = (Double)varMap.get(key);
/* 282 */         String fmt = key.equalsIgnoreCase("color") ? String.format(": 0x%08X", new Object[] { Integer.valueOf(d.intValue()) }) : String.format(": %.2f", new Object[] { d });
/* 283 */         dummy.drawString(fmt, x + 50, y, -12544);
/* 284 */         i++;
/* 285 */         y += 8;
/* 286 */         if (i == varMap.size() / 2) {
/* 287 */           x = (int)(200.0D + centerX);
/* 288 */           y = (int)(-100.0D + centerY);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static double getUAV_Fs(MCH_EntityAircraft ac) {
/* 296 */     double uav_fs = 0.0D;
/* 297 */     if (ac.isUAV() && ac.getUavStation() != null) {
/* 298 */       double dx = ac.field_70165_t - (ac.getUavStation()).field_70165_t;
/* 299 */       double dz = ac.field_70161_v - (ac.getUavStation()).field_70161_v;
/* 300 */       float dist = (float)Math.sqrt(dx * dx + dz * dz);
/* 301 */       float distMax = 120.0F;
/* 302 */       if (dist > 120.0F) {
/* 303 */         dist = 120.0F;
/*     */       }
/*     */       
/* 306 */       uav_fs = (1.0F - dist / 120.0F);
/*     */     } 
/*     */     
/* 309 */     return uav_fs;
/*     */   }
/*     */   
/*     */   private static void updateVarMap_Weapon(MCH_WeaponSet ws) {
/* 313 */     int reloading = 0;
/* 314 */     double wpn_heat = 0.0D;
/* 315 */     int is_heat_wpn = 0;
/* 316 */     byte sight_type = 0;
/* 317 */     double lock = 0.0D;
/* 318 */     float rel_time = 0.0F;
/* 319 */     int display_mortar_dist = 0;
/* 320 */     if (ws != null) {
/* 321 */       MCH_WeaponBase wb = ws.getCurrentWeapon();
/* 322 */       MCH_WeaponInfo wi = wb.getInfo();
/* 323 */       if (wi == null) {
/*     */         return;
/*     */       }
/*     */       
/* 327 */       is_heat_wpn = (wi.maxHeatCount > 0) ? 1 : 0;
/* 328 */       reloading = ws.isInPreparation() ? 1 : 0;
/* 329 */       display_mortar_dist = wi.displayMortarDistance ? 1 : 0;
/* 330 */       if (wi.delay > wi.reloadTime) {
/* 331 */         rel_time = ws.countWait / ((wi.delay > 0) ? wi.delay : true);
/* 332 */         if (rel_time < 0.0F) {
/* 333 */           rel_time = -rel_time;
/*     */         }
/*     */         
/* 336 */         if (rel_time > 1.0F) {
/* 337 */           rel_time = 1.0F;
/*     */         }
/*     */       } else {
/* 340 */         rel_time = ws.countReloadWait / ((wi.reloadTime > 0) ? wi.reloadTime : true);
/*     */       } 
/*     */       
/* 343 */       if (wi.maxHeatCount > 0) {
/* 344 */         double cntLockMax = ws.currentHeat / wi.maxHeatCount;
/* 345 */         wpn_heat = (cntLockMax > 1.0D) ? 1.0D : cntLockMax;
/*     */       } 
/*     */       
/* 348 */       int cntLockMax1 = wb.getLockCountMax();
/* 349 */       MCH_SightType sight = wb.getSightType();
/* 350 */       if (sight == MCH_SightType.LOCK && cntLockMax1 > 0) {
/* 351 */         lock = wb.getLockCount() / cntLockMax1;
/* 352 */         sight_type = 2;
/*     */       } 
/*     */       
/* 355 */       if (sight == MCH_SightType.ROCKET) {
/* 356 */         sight_type = 1;
/*     */       }
/*     */     } 
/*     */     
/* 360 */     updateVarMapItem("reloading", reloading);
/* 361 */     updateVarMapItem("reload_time", rel_time);
/* 362 */     updateVarMapItem("wpn_heat", wpn_heat);
/* 363 */     updateVarMapItem("is_heat_wpn", is_heat_wpn);
/* 364 */     updateVarMapItem("sight_type", sight_type);
/* 365 */     updateVarMapItem("lock", lock);
/* 366 */     updateVarMapItem("dsp_mt_dist", display_mortar_dist);
/* 367 */     updateVarMapItem("mt_dist", MortarDist);
/*     */   }
/*     */   
/*     */   public static int isLowFuel(MCH_EntityAircraft ac) {
/* 371 */     byte is_low_fuel = 0;
/* 372 */     if (countFuelWarn <= 0) {
/* 373 */       countFuelWarn = 280;
/*     */     }
/*     */     
/* 376 */     countFuelWarn--;
/* 377 */     if (countFuelWarn < 160 && ac.getMaxFuel() > 0 && ac.getFuelP() < 0.1F && !ac.isInfinityFuel((Entity)player, false)) {
/* 378 */       is_low_fuel = 1;
/*     */     }
/*     */     
/* 381 */     return is_low_fuel;
/*     */   }
/*     */   
/*     */   public static double getSeaAltitude(MCH_EntityAircraft ac) {
/* 385 */     double a = ac.field_70163_u - ac.field_70170_p.func_72919_O();
/* 386 */     return (a >= 0.0D) ? a : 0.0D;
/*     */   }
/*     */   
/*     */   public static float getRadarRot(MCH_EntityAircraft ac) {
/* 390 */     float rot = ac.getRadarRotate();
/* 391 */     float prevRot = prevRadarRot;
/* 392 */     if (rot < prevRot) {
/* 393 */       rot += 360.0F;
/*     */     }
/*     */     
/* 396 */     prevRadarRot = ac.getRadarRotate();
/* 397 */     return MCH_Lib.smooth(rot, prevRot, partialTicks);
/*     */   }
/*     */   
/*     */   public static int getVtolStat(MCH_EntityAircraft ac) {
/* 401 */     return (ac instanceof MCP_EntityPlane) ? ((MCP_EntityPlane)ac).getVtolMode() : 0;
/*     */   }
/*     */   
/*     */   public static int getFreeLook(MCH_EntityAircraft ac, EntityPlayer player) {
/* 405 */     return (ac.isPilot((Entity)player) && ac.canSwitchFreeLook() && ac.isFreeLookMode()) ? 1 : 0;
/*     */   }
/*     */   
/*     */   public static int getAutoPilot(MCH_EntityAircraft ac, EntityPlayer player) {
/* 409 */     return (ac instanceof MCP_EntityPlane && ac.isPilot((Entity)player) && ac.getIsGunnerMode((Entity)player)) ? 1 : 0;
/*     */   }
/*     */   
/*     */   public static double getColor() {
/* 413 */     long l = colorSetting;
/* 414 */     l &= 0xFFFFFFFFL;
/* 415 */     return l;
/*     */   }
/*     */   
/*     */   private static void updateStick() {
/* 419 */     StickX_LPF.put((float)(MCH_ClientCommonTickHandler.getCurrentStickX() / MCH_ClientCommonTickHandler.getMaxStickLength()));
/* 420 */     StickY_LPF.put((float)(-MCH_ClientCommonTickHandler.getCurrentStickY() / MCH_ClientCommonTickHandler.getMaxStickLength()));
/* 421 */     StickX = StickX_LPF.getAvg();
/* 422 */     StickY = StickY_LPF.getAvg();
/*     */   }
/*     */   
/*     */   private static void updateRadar(MCH_EntityAircraft ac) {
/* 426 */     EntityList = ac.getRadarEntityList();
/* 427 */     EnemyList = ac.getRadarEnemyList();
/*     */   }
/*     */   
/*     */   private static void updateAltitude(MCH_EntityAircraft ac) {
/* 431 */     if (altitudeUpdateCount <= 0) {
/* 432 */       int heliY = (int)ac.field_70163_u;
/* 433 */       if (heliY > 256) {
/* 434 */         heliY = 256;
/*     */       }
/*     */       
/* 437 */       for (int i = 0; i < 256 && heliY - i > 0; i++) {
/* 438 */         int id = W_WorldFunc.getBlockId(ac.field_70170_p, (int)ac.field_70165_t, heliY - i, (int)ac.field_70161_v);
/* 439 */         if (id != 0) {
/* 440 */           Altitude = i;
/* 441 */           if (ac.field_70163_u > 256.0D) {
/* 442 */             Altitude = (int)(Altitude + ac.field_70163_u - 256.0D);
/*     */           }
/*     */           
/*     */           break;
/*     */         } 
/*     */       } 
/* 448 */       altitudeUpdateCount = 30;
/*     */     } else {
/* 450 */       altitudeUpdateCount--;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateWeapon(MCH_EntityAircraft ac, MCH_WeaponSet ws) {
/* 456 */     if (ac.getWeaponNum() > 0 && 
/* 457 */       ws != null) {
/* 458 */       CurrentWeapon = ws;
/* 459 */       WeaponName = ac.isPilotReloading() ? "-- Reloading --" : ws.getName();
/* 460 */       if (ws.getAmmoNumMax() > 0) {
/* 461 */         WeaponAmmo = ac.isPilotReloading() ? "----" : String.format("%4d", new Object[] { Integer.valueOf(ws.getAmmoNum()) });
/* 462 */         WeaponAllAmmo = ac.isPilotReloading() ? "----" : String.format("%4d", new Object[] { Integer.valueOf(ws.getRestAllAmmoNum()) });
/*     */       } else {
/* 464 */         WeaponAmmo = "";
/* 465 */         WeaponAllAmmo = "";
/*     */       } 
/*     */       
/* 468 */       MCH_WeaponInfo wi = ws.getInfo();
/* 469 */       if (wi.displayMortarDistance) {
/* 470 */         MortarDist = (float)ac.getLandInDistance((Entity)player);
/*     */       } else {
/* 472 */         MortarDist = -1.0F;
/*     */       } 
/*     */       
/* 475 */       if (wi.delay > wi.reloadTime) {
/* 476 */         ReloadSec = (ws.countWait >= 0) ? ws.countWait : -ws.countWait;
/* 477 */         ReloadPer = ws.countWait / ((wi.delay > 0) ? wi.delay : true);
/* 478 */         if (ReloadPer < 0.0F) {
/* 479 */           ReloadPer = -ReloadPer;
/*     */         }
/*     */         
/* 482 */         if (ReloadPer > 1.0F) {
/* 483 */           ReloadPer = 1.0F;
/*     */         }
/*     */       } else {
/* 486 */         ReloadSec = ws.countReloadWait;
/* 487 */         ReloadPer = ws.countReloadWait / ((wi.reloadTime > 0) ? wi.reloadTime : true);
/*     */       } 
/*     */       
/* 490 */       ReloadSec /= 20.0F;
/* 491 */       ReloadPer = (1.0F - ReloadPer) * 100.0F;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void updateUAV(MCH_EntityAircraft ac) {
/* 497 */     if (ac.isUAV() && ac.getUavStation() != null) {
/* 498 */       double dx = ac.field_70165_t - (ac.getUavStation()).field_70165_t;
/* 499 */       double dz = ac.field_70161_v - (ac.getUavStation()).field_70161_v;
/* 500 */       UAV_Dist = (float)Math.sqrt(dx * dx + dz * dz);
/*     */     } else {
/* 502 */       UAV_Dist = 0.0D;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   private static void updateTvMissile(MCH_EntityAircraft ac) {
/* 508 */     MCH_EntityTvMissile tvmissile = ac.getTVMissile();
/* 509 */     if (tvmissile != null) {
/* 510 */       TVM_PosX = tvmissile.field_70165_t;
/* 511 */       TVM_PosY = tvmissile.field_70163_u;
/* 512 */       TVM_PosZ = tvmissile.field_70161_v;
/* 513 */       double dx = tvmissile.field_70165_t - ac.field_70165_t;
/* 514 */       double dy = tvmissile.field_70163_u - ac.field_70163_u;
/* 515 */       double dz = tvmissile.field_70161_v - ac.field_70161_v;
/* 516 */       TVM_Diff = Math.sqrt(dx * dx + dy * dy + dz * dz);
/*     */     } else {
/* 518 */       TVM_PosX = 0.0D;
/* 519 */       TVM_PosY = 0.0D;
/* 520 */       TVM_PosZ = 0.0D;
/* 521 */       TVM_Diff = 0.0D;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItem.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */