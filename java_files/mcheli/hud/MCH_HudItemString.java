/*     */ package mcheli.hud;
/*     */ 
/*     */ import java.util.Date;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_KeyName;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.util.MathHelper;
/*     */ 
/*     */ 
/*     */ public class MCH_HudItemString
/*     */   extends MCH_HudItem
/*     */ {
/*     */   private final String posX;
/*     */   private final String posY;
/*     */   private final String format;
/*     */   private final MCH_HudItemStringArgs[] args;
/*     */   private final boolean isCenteredString;
/*     */   
/*     */   public MCH_HudItemString(int fileLine, String posx, String posy, String fmt, String[] arg, boolean centered) {
/*  22 */     super(fileLine);
/*  23 */     this.posX = posx.toLowerCase();
/*  24 */     this.posY = posy.toLowerCase();
/*  25 */     this.format = fmt;
/*  26 */     int len = (arg.length < 3) ? 0 : (arg.length - 3);
/*  27 */     this.args = new MCH_HudItemStringArgs[len];
/*     */     
/*  29 */     for (int i = 0; i < len; i++) {
/*  30 */       this.args[i] = MCH_HudItemStringArgs.toArgs(arg[3 + i]);
/*     */     }
/*     */     
/*  33 */     this.isCenteredString = centered;
/*     */   }
/*     */   
/*     */   public void execute() {
/*  37 */     int x = (int)(MCH_HudItem.centerX + calc(this.posX));
/*  38 */     int y = (int)(MCH_HudItem.centerY + calc(this.posY));
/*  39 */     long dateCount = (Minecraft.func_71410_x()).field_71439_g.field_70170_p.func_82737_E();
/*  40 */     int worldTime = (int)((MCH_HudItem.ac.field_70170_p.func_72820_D() + 6000L) % 24000L);
/*  41 */     Date date = new Date();
/*  42 */     Object[] prm = new Object[this.args.length];
/*  43 */     double hp_per = (MCH_HudItem.ac.getMaxHP() > 0) ? (MCH_HudItem.ac.getHP() / MCH_HudItem.ac.getMaxHP()) : 0.0D;
/*     */     
/*  45 */     for (int i = 0; i < prm.length; i++) {
/*  46 */       MCH_Config var10002; switch (this.args[i]) {
/*     */         case null:
/*  48 */           prm[i] = (MCH_HudItem.ac.getAcInfo()).displayName;
/*     */           break;
/*     */         case null:
/*  51 */           prm[i] = Integer.valueOf(MCH_HudItem.Altitude);
/*     */           break;
/*     */         case null:
/*  54 */           prm[i] = date;
/*     */           break;
/*     */         case null:
/*  57 */           prm[i] = Integer.valueOf(worldTime / 1000);
/*     */           break;
/*     */         case null:
/*  60 */           prm[i] = Integer.valueOf(worldTime % 1000 * 36 / 10 / 60);
/*     */           break;
/*     */         case null:
/*  63 */           prm[i] = Integer.valueOf(worldTime % 1000 * 36 / 10 % 60);
/*     */           break;
/*     */         case null:
/*  66 */           prm[i] = Integer.valueOf(MCH_HudItem.ac.getMaxHP());
/*     */           break;
/*     */         case null:
/*  69 */           prm[i] = Integer.valueOf(MCH_HudItem.ac.getHP());
/*     */           break;
/*     */         case null:
/*  72 */           prm[i] = Double.valueOf(hp_per * 100.0D);
/*     */           break;
/*     */         case null:
/*  75 */           prm[i] = Double.valueOf(MCH_HudItem.ac.field_70165_t);
/*     */           break;
/*     */         case null:
/*  78 */           prm[i] = Double.valueOf(MCH_HudItem.ac.field_70163_u);
/*     */           break;
/*     */         case null:
/*  81 */           prm[i] = Double.valueOf(MCH_HudItem.ac.field_70161_v);
/*     */           break;
/*     */         case null:
/*  84 */           prm[i] = Double.valueOf(MCH_HudItem.ac.field_70159_w);
/*     */           break;
/*     */         case null:
/*  87 */           prm[i] = Double.valueOf(MCH_HudItem.ac.field_70181_x);
/*     */           break;
/*     */         case null:
/*  90 */           prm[i] = Double.valueOf(MCH_HudItem.ac.field_70179_y);
/*     */           break;
/*     */         case null:
/*  93 */           prm[i] = Integer.valueOf(MCH_HudItem.ac.func_70302_i_());
/*     */           break;
/*     */         case null:
/*  96 */           prm[i] = MCH_HudItem.WeaponName;
/*  97 */           if (MCH_HudItem.CurrentWeapon == null) {
/*     */             return;
/*     */           }
/*     */           break;
/*     */         case null:
/* 102 */           prm[i] = MCH_HudItem.WeaponAmmo;
/* 103 */           if (MCH_HudItem.CurrentWeapon == null) {
/*     */             return;
/*     */           }
/*     */           
/* 107 */           if (MCH_HudItem.CurrentWeapon.getAmmoNumMax() <= 0) {
/*     */             return;
/*     */           }
/*     */           break;
/*     */         case null:
/* 112 */           prm[i] = MCH_HudItem.WeaponAllAmmo;
/* 113 */           if (MCH_HudItem.CurrentWeapon == null) {
/*     */             return;
/*     */           }
/*     */           
/* 117 */           if (MCH_HudItem.CurrentWeapon.getAmmoNumMax() <= 0) {
/*     */             return;
/*     */           }
/*     */           break;
/*     */         case null:
/* 122 */           prm[i] = Float.valueOf(MCH_HudItem.ReloadPer);
/* 123 */           if (MCH_HudItem.CurrentWeapon == null) {
/*     */             return;
/*     */           }
/*     */           break;
/*     */         case null:
/* 128 */           prm[i] = Float.valueOf(MCH_HudItem.ReloadSec);
/* 129 */           if (MCH_HudItem.CurrentWeapon == null) {
/*     */             return;
/*     */           }
/*     */           break;
/*     */         case null:
/* 134 */           prm[i] = Float.valueOf(MCH_HudItem.MortarDist);
/* 135 */           if (MCH_HudItem.CurrentWeapon == null) {
/*     */             return;
/*     */           }
/*     */           break;
/*     */         case null:
/* 140 */           prm[i] = "1.7.10";
/*     */           break;
/*     */         case null:
/* 143 */           prm[i] = MCH_MOD.VER;
/*     */           break;
/*     */         case null:
/* 146 */           prm[i] = "MC Helicopter MOD";
/*     */           break;
/*     */         case null:
/* 149 */           prm[i] = Double.valueOf(MCH_Lib.getRotate360((MCH_HudItem.ac.getRotYaw() + 180.0F)));
/*     */           break;
/*     */         case null:
/* 152 */           prm[i] = Float.valueOf(-MCH_HudItem.ac.getRotPitch());
/*     */           break;
/*     */         case null:
/* 155 */           prm[i] = Float.valueOf(MathHelper.func_76142_g(MCH_HudItem.ac.getRotRoll()));
/*     */           break;
/*     */         case null:
/* 158 */           prm[i] = Double.valueOf(MCH_Lib.getRotate360((MCH_HudItem.player.field_70177_z + 180.0F)));
/*     */           break;
/*     */         case null:
/* 161 */           prm[i] = Float.valueOf(-MCH_HudItem.player.field_70125_A);
/*     */           break;
/*     */         case null:
/* 164 */           prm[i] = Double.valueOf(MCH_HudItem.TVM_PosX);
/*     */           break;
/*     */         case null:
/* 167 */           prm[i] = Double.valueOf(MCH_HudItem.TVM_PosY);
/*     */           break;
/*     */         case null:
/* 170 */           prm[i] = Double.valueOf(MCH_HudItem.TVM_PosZ);
/*     */           break;
/*     */         case null:
/* 173 */           prm[i] = Double.valueOf(MCH_HudItem.TVM_Diff);
/*     */           break;
/*     */         case null:
/* 176 */           prm[i] = Float.valueOf(MCH_HudItem.ac.camera.getCameraZoom());
/*     */           break;
/*     */         case null:
/* 179 */           prm[i] = Double.valueOf(MCH_HudItem.UAV_Dist);
/*     */           break;
/*     */         case null:
/* 182 */           var10002 = MCH_MOD.config;
/* 183 */           prm[i] = MCH_KeyName.getDescOrName(MCH_Config.KeyGUI.prmInt);
/*     */           break;
/*     */         case null:
/* 186 */           prm[i] = Double.valueOf(MCH_HudItem.ac.getCurrentThrottle() * 100.0D);
/*     */           break;
/*     */       } 
/*     */     
/*     */     } 
/* 191 */     if (this.isCenteredString) {
/* 192 */       drawCenteredString(String.format(this.format, prm), x, y, MCH_HudItem.colorSetting);
/*     */     } else {
/* 194 */       drawString(String.format(this.format, prm), x, y, MCH_HudItem.colorSetting);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   static class NamelessClass1090813585
/*     */   {
/* 203 */     static final int[] $SwitchMap$mcheli$hud$MCH_HudItemStringArgs = new int[(MCH_HudItemStringArgs.values()).length];
/*     */ 
/*     */     
/*     */     static {
/*     */       try {
/* 208 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.NAME.ordinal()] = 1;
/* 209 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 214 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.ALTITUDE.ordinal()] = 2;
/* 215 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 220 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.DATE.ordinal()] = 3;
/* 221 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 226 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MC_THOR.ordinal()] = 4;
/* 227 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 232 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MC_TMIN.ordinal()] = 5;
/* 233 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 238 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MC_TSEC.ordinal()] = 6;
/* 239 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 244 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MAX_HP.ordinal()] = 7;
/* 245 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 250 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.HP.ordinal()] = 8;
/* 251 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 256 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.HP_PER.ordinal()] = 9;
/* 257 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 262 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.POS_X.ordinal()] = 10;
/* 263 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 268 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.POS_Y.ordinal()] = 11;
/* 269 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 274 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.POS_Z.ordinal()] = 12;
/* 275 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 280 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MOTION_X.ordinal()] = 13;
/* 281 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 286 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MOTION_Y.ordinal()] = 14;
/* 287 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 292 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MOTION_Z.ordinal()] = 15;
/* 293 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 298 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.INVENTORY.ordinal()] = 16;
/* 299 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 304 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.WPN_NAME.ordinal()] = 17;
/* 305 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 310 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.WPN_AMMO.ordinal()] = 18;
/* 311 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 316 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.WPN_RM_AMMO.ordinal()] = 19;
/* 317 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 322 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.RELOAD_PER.ordinal()] = 20;
/* 323 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 328 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.RELOAD_SEC.ordinal()] = 21;
/* 329 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 334 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MORTAR_DIST.ordinal()] = 22;
/* 335 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 340 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MC_VER.ordinal()] = 23;
/* 341 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 346 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MOD_VER.ordinal()] = 24;
/* 347 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 352 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.MOD_NAME.ordinal()] = 25;
/* 353 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 358 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.YAW.ordinal()] = 26;
/* 359 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 364 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.PITCH.ordinal()] = 27;
/* 365 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 370 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.ROLL.ordinal()] = 28;
/* 371 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 376 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.PLYR_YAW.ordinal()] = 29;
/* 377 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 382 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.PLYR_PITCH.ordinal()] = 30;
/* 383 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 388 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.TVM_POS_X.ordinal()] = 31;
/* 389 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 394 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.TVM_POS_Y.ordinal()] = 32;
/* 395 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 400 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.TVM_POS_Z.ordinal()] = 33;
/* 401 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 406 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.TVM_DIFF.ordinal()] = 34;
/* 407 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 412 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.CAM_ZOOM.ordinal()] = 35;
/* 413 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 418 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.UAV_DIST.ordinal()] = 36;
/* 419 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 424 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.KEY_GUI.ordinal()] = 37;
/* 425 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 430 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.THROTTLE.ordinal()] = 38;
/* 431 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */ 
/*     */ 
/*     */       
/*     */       try {
/* 436 */         $SwitchMap$mcheli$hud$MCH_HudItemStringArgs[MCH_HudItemStringArgs.NONE.ordinal()] = 39;
/* 437 */       } catch (NoSuchFieldError noSuchFieldError) {}
/*     */     }
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\hud\MCH_HudItemString.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */