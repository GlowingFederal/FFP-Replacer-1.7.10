/*     */ package mcheli.aircraft;
/*     */ 
/*     */ import mcheli.MCH_PacketIndOpenScreen;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.weapon.MCH_WeaponInfo;
/*     */ import mcheli.weapon.MCH_WeaponSet;
/*     */ import mcheli.wrapper.W_GuiContainer;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_ScaledResolution;
/*     */ import net.minecraft.client.gui.GuiButton;
/*     */ import net.minecraft.client.gui.GuiTextField;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.util.Vec3;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ public class MCH_AircraftGui
/*     */   extends W_GuiContainer
/*     */ {
/*     */   private final EntityPlayer thePlayer;
/*     */   private final MCH_EntityAircraft aircraft;
/*     */   private int scaleFactor;
/*     */   private GuiButton buttonReload;
/*     */   private GuiButton buttonNext;
/*     */   private GuiButton buttonPrev;
/*     */   private GuiButton buttonInventory;
/*     */   private GuiButton buttonChangeSkin;
/*     */   private GuiButton buttonSetTarget;
/*     */   private GuiButton buttonGetTarget;
/*     */   private GuiTextField targetPointFieldX;
/*     */   private GuiTextField targetPointFieldY;
/*     */   private GuiTextField targetPointFieldZ;
/*     */   private Vec3 targetPoint;
/*     */   private String currentSkin;
/*     */   private int currentWeaponId;
/*     */   private int reloadWait;
/*     */   public static final int BUTTON_RELOAD = 1;
/*     */   public static final int BUTTON_NEXT = 2;
/*     */   public static final int BUTTON_PREV = 3;
/*     */   public static final int BUTTON_CLOSE = 4;
/*     */   public static final int BUTTON_CONFIG = 5;
/*     */   public static final int BUTTON_INVENTORY = 6;
/*     */   
/*     */   public MCH_AircraftGui(EntityPlayer player, MCH_EntityAircraft ac) {
/*  48 */     super(new MCH_AircraftGuiContainer(player, ac));
/*  49 */     this.aircraft = ac;
/*  50 */     this.thePlayer = player;
/*  51 */     this.field_146999_f = 210;
/*  52 */     this.field_147000_g = 236;
/*  53 */     this.buttonReload = null;
/*  54 */     this.currentWeaponId = 0;
/*  55 */     this.currentSkin = ac.getAcInfo().getTextureName();
/*  56 */     this.targetPoint = Vec3.func_72443_a(0.0D, 0.0D, 0.0D);
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  60 */     super.func_73866_w_();
/*  61 */     this.field_146292_n.clear();
/*  62 */     this.buttonReload = new GuiButton(1, this.field_147003_i + 85, this.field_147009_r + 40, 50, 20, "Reload");
/*  63 */     this.buttonNext = new GuiButton(3, this.field_147003_i + 140, this.field_147009_r + 40, 20, 20, "<<");
/*  64 */     this.buttonPrev = new GuiButton(2, this.field_147003_i + 160, this.field_147009_r + 40, 20, 20, ">>");
/*  65 */     this.buttonChangeSkin = new GuiButton(8, this.field_147003_i + 180 - 30 - 110, this.field_147009_r + 110, 80, 20, this.currentSkin);
/*     */     
/*  67 */     this.buttonSetTarget = new GuiButton(9, this.field_147003_i + 220, this.field_147009_r + 10 + 20 + 5 + 20 + 5 + 20 + 5, 70, 20, "SET");
/*  68 */     this.buttonGetTarget = new GuiButton(10, this.field_147003_i + 220, this.field_147009_r + 10 + 20 + 5 + 20 + 5 + 20 + 5 + 20 + 5, 70, 20, "GET");
/*  69 */     addTargetPointFields();
/*     */     
/*  71 */     this.buttonReload.field_146124_l = canReload(this.thePlayer);
/*  72 */     this.buttonNext.field_146124_l = (this.aircraft.getWeaponNum() >= 2);
/*  73 */     this.buttonPrev.field_146124_l = (this.aircraft.getWeaponNum() >= 2);
/*  74 */     this.field_146292_n.add(new GuiButton(5, this.field_147003_i + 210 - 30 - 60, this.field_147009_r + 110, 80, 20, "MOD Options"));
/*  75 */     this.field_146292_n.add(new GuiButton(4, this.field_147003_i + 210 - 30 - 20, this.field_147009_r + 10, 40, 20, "Close"));
/*  76 */     this.field_146292_n.add(this.buttonReload);
/*  77 */     this.field_146292_n.add(this.buttonNext);
/*  78 */     this.field_146292_n.add(this.buttonPrev);
/*  79 */     this.field_146292_n.add(this.buttonChangeSkin);
/*  80 */     this.field_146292_n.add(this.buttonSetTarget);
/*  81 */     this.field_146292_n.add(this.buttonGetTarget);
/*  82 */     this.reloadWait = 10;
/*     */   }
/*     */   
/*     */   private void addTargetPointFields() {
/*  86 */     this.targetPointFieldX = new GuiTextField(this.field_146289_q, this.field_147003_i + 220, this.field_147009_r + 10, 70, 20);
/*  87 */     this.targetPointFieldX.func_146193_g(-1);
/*  88 */     this.targetPointFieldX.func_146204_h(-1);
/*  89 */     this.targetPointFieldX.func_146185_a(true);
/*  90 */     this.targetPointFieldX.func_146203_f(8);
/*     */     
/*  92 */     this.targetPointFieldY = new GuiTextField(this.field_146289_q, this.field_147003_i + 220, this.field_147009_r + 10 + 20 + 5, 70, 20);
/*  93 */     this.targetPointFieldY.func_146193_g(-1);
/*  94 */     this.targetPointFieldY.func_146204_h(-1);
/*  95 */     this.targetPointFieldY.func_146185_a(true);
/*  96 */     this.targetPointFieldY.func_146203_f(8);
/*     */     
/*  98 */     this.targetPointFieldZ = new GuiTextField(this.field_146289_q, this.field_147003_i + 220, this.field_147009_r + 10 + 20 + 5 + 20 + 5, 70, 20);
/*  99 */     this.targetPointFieldZ.func_146193_g(-1);
/* 100 */     this.targetPointFieldZ.func_146204_h(-1);
/* 101 */     this.targetPointFieldZ.func_146185_a(true);
/* 102 */     this.targetPointFieldZ.func_146203_f(8);
/* 103 */     for (MCH_WeaponSet ws : this.aircraft.weapons) {
/* 104 */       if ((ws.getInfo()).type.equalsIgnoreCase("GPSMissile")) {
/* 105 */         this.targetPointFieldX.func_146180_a(String.valueOf(ws.targetPoint.field_72450_a));
/* 106 */         this.targetPointFieldY.func_146180_a(String.valueOf(ws.targetPoint.field_72448_b));
/* 107 */         this.targetPointFieldZ.func_146180_a(String.valueOf(ws.targetPoint.field_72449_c));
/*     */         break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void closeScreen() {
/* 114 */     this.field_146297_k.field_71439_g.func_71053_j();
/*     */   }
/*     */   
/*     */   public boolean canReload(EntityPlayer player) {
/* 118 */     return this.aircraft.canPlayerSupplyAmmo(player, this.currentWeaponId);
/*     */   }
/*     */   
/*     */   public void func_73876_c() {
/* 122 */     super.func_73876_c();
/* 123 */     this.buttonChangeSkin.field_146126_j = this.aircraft.getTextureName();
/* 124 */     if (this.reloadWait > 0) {
/* 125 */       this.reloadWait--;
/* 126 */       if (this.reloadWait == 0) {
/* 127 */         this.buttonReload.field_146124_l = canReload(this.thePlayer);
/* 128 */         this.reloadWait = 20;
/*     */       } 
/*     */     } 
/* 131 */     this.buttonGetTarget.field_146124_l = (this.buttonGetTarget.field_146125_m && MCH_ParticlesUtil.markPoint != null);
/*     */   }
/*     */   
/*     */   protected void func_73864_a(int p_73864_1_, int p_73864_2_, int p_73864_3_) {
/* 135 */     super.func_73864_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 136 */     this.targetPointFieldX.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 137 */     this.targetPointFieldY.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/* 138 */     this.targetPointFieldZ.func_146192_a(p_73864_1_, p_73864_2_, p_73864_3_);
/*     */   }
/*     */   
/*     */   public void func_146281_b() {
/* 142 */     super.func_146281_b();
/*     */   }
/*     */   
/*     */   protected void func_146284_a(GuiButton button) {
/* 146 */     super.func_146284_a(button);
/* 147 */     if (button.field_146124_l) {
/* 148 */       MCH_WeaponSet ws; MCH_WeaponSet ws2; switch (button.field_146127_k) {
/*     */         case 1:
/* 150 */           this.buttonReload.field_146124_l = canReload(this.thePlayer);
/* 151 */           if (this.buttonReload.field_146124_l) {
/* 152 */             MCH_PacketIndReload.send(this.aircraft, this.currentWeaponId);
/* 153 */             this.aircraft.supplyAmmo(this.currentWeaponId);
/* 154 */             this.reloadWait = 3;
/* 155 */             this.buttonReload.field_146124_l = false;
/*     */           } 
/*     */           break;
/*     */         case 2:
/* 159 */           this.currentWeaponId++;
/* 160 */           if (this.currentWeaponId >= this.aircraft.getWeaponNum()) {
/* 161 */             this.currentWeaponId = 0;
/*     */           }
/*     */           
/* 164 */           this.buttonReload.field_146124_l = canReload(this.thePlayer);
/* 165 */           ws = this.aircraft.getWeapon(this.currentWeaponId);
/* 166 */           if ((ws.getInfo()).type.equalsIgnoreCase("GPSMissile")) {
/* 167 */             this.targetPointFieldX.func_146180_a(String.valueOf((int)ws.targetPoint.field_72450_a));
/* 168 */             this.targetPointFieldY.func_146180_a(String.valueOf((int)ws.targetPoint.field_72448_b));
/* 169 */             this.targetPointFieldZ.func_146180_a(String.valueOf((int)ws.targetPoint.field_72449_c));
/*     */           } 
/*     */           break;
/*     */         case 3:
/* 173 */           this.currentWeaponId--;
/* 174 */           if (this.currentWeaponId < 0) {
/* 175 */             this.currentWeaponId = this.aircraft.getWeaponNum() - 1;
/*     */           }
/*     */           
/* 178 */           this.buttonReload.field_146124_l = canReload(this.thePlayer);
/* 179 */           ws2 = this.aircraft.getWeapon(this.currentWeaponId);
/* 180 */           if ((ws2.getInfo()).type.equalsIgnoreCase("GPSMissile")) {
/* 181 */             this.targetPointFieldX.func_146180_a(String.valueOf((int)ws2.targetPoint.field_72450_a));
/* 182 */             this.targetPointFieldY.func_146180_a(String.valueOf((int)ws2.targetPoint.field_72448_b));
/* 183 */             this.targetPointFieldZ.func_146180_a(String.valueOf((int)ws2.targetPoint.field_72449_c));
/*     */           } 
/*     */           break;
/*     */         case 4:
/* 187 */           closeScreen();
/*     */           break;
/*     */         case 5:
/* 190 */           MCH_PacketIndOpenScreen.send(2);
/*     */           break;
/*     */         case 6:
/* 193 */           MCH_PacketIndOpenScreen.send(3);
/*     */           break;
/*     */         case 8:
/* 196 */           MCH_PacketChangeAcSkin.send(this.aircraft);
/*     */           break;
/*     */         case 9:
/*     */           try {
/* 200 */             MCH_PacketSetTargetPoint.send(this.aircraft, this.currentWeaponId, 
/* 201 */                 Integer.parseInt(this.targetPointFieldX.func_146179_b()), 
/* 202 */                 Integer.parseInt(this.targetPointFieldY.func_146179_b()), 
/* 203 */                 Integer.parseInt(this.targetPointFieldZ.func_146179_b()));
/* 204 */             (this.aircraft.getWeapon(this.currentWeaponId)).targetPoint = Vec3.func_72443_a(
/* 205 */                 Integer.parseInt(this.targetPointFieldX.func_146179_b()), 
/* 206 */                 Integer.parseInt(this.targetPointFieldY.func_146179_b()), 
/* 207 */                 Integer.parseInt(this.targetPointFieldZ.func_146179_b()));
/* 208 */           } catch (Exception ex) {
/* 209 */             ex.printStackTrace();
/*     */           } 
/*     */           break;
/*     */         case 10:
/*     */           try {
/* 214 */             if (MCH_ParticlesUtil.markPoint != null) {
/* 215 */               this.targetPointFieldX.func_146180_a(String.valueOf((int)MCH_ParticlesUtil.markPoint.field_70165_t));
/* 216 */               this.targetPointFieldY.func_146180_a(String.valueOf((int)MCH_ParticlesUtil.markPoint.field_70163_u - 2));
/* 217 */               this.targetPointFieldZ.func_146180_a(String.valueOf((int)MCH_ParticlesUtil.markPoint.field_70161_v));
/*     */               
/* 219 */               MCH_PacketSetTargetPoint.send(this.aircraft, this.currentWeaponId, 
/* 220 */                   Integer.parseInt(this.targetPointFieldX.func_146179_b()), 
/* 221 */                   Integer.parseInt(this.targetPointFieldY.func_146179_b()), 
/* 222 */                   Integer.parseInt(this.targetPointFieldZ.func_146179_b()));
/*     */               
/* 224 */               (this.aircraft.getWeapon(this.currentWeaponId)).targetPoint = Vec3.func_72443_a(
/* 225 */                   Integer.parseInt(this.targetPointFieldX.func_146179_b()), 
/* 226 */                   Integer.parseInt(this.targetPointFieldY.func_146179_b()), 
/* 227 */                   Integer.parseInt(this.targetPointFieldZ.func_146179_b()));
/*     */             } 
/* 229 */           } catch (Exception ex) {
/* 230 */             ex.printStackTrace();
/*     */           } 
/*     */           break;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public void func_73863_a(int p_73863_1_, int p_73863_2_, float p_73863_3_) {
/* 240 */     if (this.aircraft.getWeaponNum() > 0) {
/* 241 */       MCH_WeaponSet ws = this.aircraft.getWeapon(this.currentWeaponId);
/* 242 */       if (ws != null && !(ws.getFirstWeapon() instanceof mcheli.weapon.MCH_WeaponDummy) && (ws.getInfo()).type.equalsIgnoreCase("GPSMissile")) {
/* 243 */         this.buttonSetTarget.field_146125_m = true;
/* 244 */         this.buttonSetTarget.field_146124_l = true;
/* 245 */         this.buttonGetTarget.field_146125_m = true;
/*     */       } else {
/* 247 */         this.buttonSetTarget.field_146125_m = false;
/* 248 */         this.buttonSetTarget.field_146124_l = false;
/* 249 */         this.buttonGetTarget.field_146125_m = false;
/* 250 */         this.buttonGetTarget.field_146124_l = false;
/*     */       } 
/*     */     } 
/*     */     
/* 254 */     super.func_73863_a(p_73863_1_, p_73863_2_, p_73863_3_);
/* 255 */     if (this.aircraft.getWeaponNum() > 0) {
/* 256 */       MCH_WeaponSet ws = this.aircraft.getWeapon(this.currentWeaponId);
/* 257 */       if (ws != null && !(ws.getFirstWeapon() instanceof mcheli.weapon.MCH_WeaponDummy) && (ws.getInfo()).type.equalsIgnoreCase("GPSMissile")) {
/* 258 */         this.targetPointFieldX.func_146194_f();
/* 259 */         this.targetPointFieldY.func_146194_f();
/* 260 */         this.targetPointFieldZ.func_146194_f();
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   protected void func_146979_b(int par1, int par2) {
/* 266 */     super.func_146979_b(par1, par2);
/* 267 */     MCH_EntityAircraft ac = this.aircraft;
/* 268 */     drawString(ac.getGuiInventory().func_145825_b(), 10, 10, 16777215);
/* 269 */     if (this.aircraft.getNumEjectionSeat() > 0) {
/* 270 */       drawString("Parachute", 9, 95, 16777215);
/*     */     }
/*     */     
/* 273 */     if (this.aircraft.getWeaponNum() > 0) {
/* 274 */       MCH_WeaponSet ws = this.aircraft.getWeapon(this.currentWeaponId);
/* 275 */       if (ws != null && !(ws.getFirstWeapon() instanceof mcheli.weapon.MCH_WeaponDummy)) {
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */ 
/*     */         
/* 288 */         drawString(ws.getName(), 79, 30, 16777215);
/* 289 */         int rest = ws.getRestAllAmmoNum() + ws.getAmmoNum();
/* 290 */         int color = (rest == 0) ? 16711680 : ((rest == ws.getAllAmmoNum()) ? 2675784 : 16777215);
/* 291 */         String s = String.format("%4d/%4d", new Object[] { Integer.valueOf(rest), Integer.valueOf(ws.getAllAmmoNum()) });
/* 292 */         drawString(s, 145, 70, color);
/* 293 */         int itemPosX = 90;
/*     */ 
/*     */ 
/*     */         
/* 297 */         for (MCH_WeaponInfo.RoundItem r : (ws.getInfo()).roundItems) {
/*     */           
/* 299 */           drawString("" + r.num, itemPosX, 80, 16777215);
/*     */           itemPosX += 20;
/*     */         } 
/* 302 */         itemPosX = 85;
/*     */         
/* 304 */         for (MCH_WeaponInfo.RoundItem r : (ws.getInfo()).roundItems) {
/*     */           
/* 306 */           drawItemStack(r.itemStack, itemPosX, 62); itemPosX += 20;
/*     */         } 
/*     */       } 
/*     */     } else {
/* 310 */       drawString("None", 79, 45, 16777215);
/*     */     } 
/*     */   }
/*     */ 
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_73869_a(char c, int code) {
/* 318 */     if (this.aircraft.getWeaponNum() > 0) {
/* 319 */       MCH_WeaponSet ws = this.aircraft.getWeapon(this.currentWeaponId);
/* 320 */       if (ws != null && !(ws.getFirstWeapon() instanceof mcheli.weapon.MCH_WeaponDummy) && (ws.getInfo()).type.equalsIgnoreCase("GPSMissile")) {
/* 321 */         if (this.targetPointFieldX.func_146201_a(c, code));
/*     */ 
/*     */         
/* 324 */         if (this.targetPointFieldY.func_146201_a(c, code));
/*     */ 
/*     */         
/* 327 */         if (this.targetPointFieldZ.func_146201_a(c, code));
/*     */       } 
/*     */     } 
/*     */ 
/*     */ 
/*     */     
/* 333 */     if (code == 1) {
/* 334 */       closeScreen();
/*     */     }
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   protected void func_146976_a(float var1, int var2, int var3) {
/* 341 */     W_ScaledResolution scaledresolution = new W_ScaledResolution(this.field_146297_k, this.field_146297_k.field_71443_c, this.field_146297_k.field_71440_d);
/* 342 */     this.scaleFactor = scaledresolution.func_78325_e();
/* 343 */     W_McClient.MOD_bindTexture("textures/gui/gui.png");
/* 344 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 345 */     int x = (this.field_146294_l - this.field_146999_f) / 2;
/* 346 */     int y = (this.field_146295_m - this.field_147000_g) / 2;
/* 347 */     func_73729_b(x, y, 0, 0, this.field_146999_f, this.field_147000_g);
/*     */     
/*     */     int ff;
/* 350 */     for (ff = 0; ff < this.aircraft.getNumEjectionSeat(); ff++) {
/* 351 */       func_73729_b(x + 10 + 18 * ff - 1, y + 105 - 1, 215, 55, 18, 18);
/*     */     }
/*     */     
/* 354 */     ff = (int)(this.aircraft.getFuelP() * 50.0F);
/* 355 */     if (ff >= 99) {
/* 356 */       ff = 100;
/*     */     }
/*     */     
/* 359 */     func_73729_b(x + 57, y + 30 + 50 - ff, 215, 0, 12, ff);
/* 360 */     ff = (int)((this.aircraft.getFuelP() * 100.0F) + 0.5D);
/* 361 */     int color = (ff > 20) ? -14101432 : 16711680;
/* 362 */     drawString(String.format("%3d", new Object[] { Integer.valueOf(ff) }) + "%", x + 30, y + 65, color);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_AircraftGui.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */