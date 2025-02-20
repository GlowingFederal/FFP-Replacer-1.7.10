/*     */ package mcheli.lweapon;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_KeyName;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.gui.MCH_Gui;
/*     */ import mcheli.weapon.MCH_WeaponGuidanceSystem;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.potion.Potion;
/*     */ import net.minecraft.potion.PotionEffect;
/*     */ import net.minecraft.util.Vec3;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_GuiLightWeapon
/*     */   extends MCH_Gui
/*     */ {
/*     */   public MCH_GuiLightWeapon(Minecraft minecraft) {
/*  27 */     super(minecraft);
/*     */   }
/*     */   
/*     */   public void func_73866_w_() {
/*  31 */     super.func_73866_w_();
/*     */   }
/*     */   
/*     */   public boolean func_73868_f() {
/*  35 */     return false;
/*     */   }
/*     */   
/*     */   public boolean isDrawGui(EntityPlayer player) {
/*  39 */     if (MCH_ItemLightWeaponBase.isHeld(player)) {
/*  40 */       Entity re = player.field_70154_o;
/*  41 */       if (!(re instanceof mcheli.aircraft.MCH_EntityAircraft) && !(re instanceof mcheli.gltd.MCH_EntityGLTD)) {
/*  42 */         return true;
/*     */       }
/*     */     } 
/*     */     
/*  46 */     return false;
/*     */   }
/*     */   
/*     */   public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/*  50 */     if (!isThirdPersonView) {
/*  51 */       GL11.glLineWidth(MCH_Gui.scaleFactor);
/*  52 */       if (isDrawGui(player)) {
/*  53 */         MCH_ItemLightWeaponBase item = (MCH_ItemLightWeaponBase)player.func_70694_bm().func_77973_b();
/*  54 */         MCH_WeaponGuidanceSystem gs = MCH_ClientLightWeaponTickHandler.gs;
/*  55 */         if (gs != null && MCH_ClientLightWeaponTickHandler.weapon != null && MCH_ClientLightWeaponTickHandler.weapon.getInfo() != null) {
/*  56 */           PotionEffect pe = player.func_70660_b(Potion.field_76439_r);
/*  57 */           if (pe != null) {
/*  58 */             drawNightVisionNoise();
/*     */           }
/*     */           
/*  61 */           GL11.glEnable(3042);
/*  62 */           GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
/*  63 */           int srcBlend = GL11.glGetInteger(3041);
/*  64 */           int dstBlend = GL11.glGetInteger(3040);
/*  65 */           GL11.glBlendFunc(770, 771);
/*  66 */           double dist = 0.0D;
/*  67 */           if (gs.getTargetEntity() != null) {
/*  68 */             double canFire = (gs.getTargetEntity()).field_70165_t - player.field_70165_t;
/*  69 */             double dz = (gs.getTargetEntity()).field_70161_v - player.field_70161_v;
/*  70 */             dist = Math.sqrt(canFire * canFire + dz * dz);
/*     */           } 
/*     */           
/*  73 */           boolean canFire1 = (MCH_ClientLightWeaponTickHandler.weaponMode == 0 || dist >= 40.0D || gs.getLockCount() <= 0);
/*  74 */           if ("fgm148".equalsIgnoreCase(MCH_ItemLightWeaponBase.getName(player.func_70694_bm()))) {
/*  75 */             drawGuiFGM148(player, gs, canFire1, player.func_70694_bm());
/*  76 */             drawKeyBind(-805306369, true);
/*     */           } else {
/*  78 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  79 */             W_McClient.MOD_bindTexture("textures/gui/stinger.png");
/*     */             
/*     */             double size;
/*  82 */             for (size = 512.0D; size < this.field_146294_l || size < this.field_146295_m; size *= 2.0D);
/*     */ 
/*     */ 
/*     */             
/*  86 */             drawTexturedModalRectRotate(-(size - this.field_146294_l) / 2.0D, -(size - this.field_146295_m) / 2.0D - 20.0D, size, size, 0.0D, 0.0D, 256.0D, 256.0D, 0.0F);
/*  87 */             drawKeyBind(-805306369, false);
/*     */           } 
/*     */           
/*  90 */           GL11.glBlendFunc(srcBlend, dstBlend);
/*  91 */           GL11.glDisable(3042);
/*  92 */           drawLock(-14101432, -2161656, gs.getLockCount(), gs.getLockCountMax());
/*  93 */           drawRange(player, gs, canFire1, -14101432, -2161656);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawNightVisionNoise() {
/* 101 */     GL11.glEnable(3042);
/* 102 */     GL11.glColor4f(0.0F, 1.0F, 0.0F, 0.3F);
/* 103 */     int srcBlend = GL11.glGetInteger(3041);
/* 104 */     int dstBlend = GL11.glGetInteger(3040);
/* 105 */     GL11.glBlendFunc(1, 1);
/* 106 */     W_McClient.MOD_bindTexture("textures/gui/alpha.png");
/* 107 */     drawTexturedModalRectRotate(0.0D, 0.0D, this.field_146294_l, this.field_146295_m, this.rand.nextInt(256), this.rand.nextInt(256), 256.0D, 256.0D, 0.0F);
/* 108 */     GL11.glBlendFunc(srcBlend, dstBlend);
/* 109 */     GL11.glDisable(3042);
/*     */   }
/*     */   
/*     */   void drawLock(int color, int colorLock, int cntLock, int cntMax) {
/* 113 */     int posX = this.centerX;
/* 114 */     int posY = this.centerY + 20;
/* 115 */     boolean WID = true;
/* 116 */     boolean INV = true;
/* 117 */     double[] var10000 = { (posX - 20), (posY - 10), (posX - 20), (posY - 20), (posX - 20), (posY - 20), (posX - 10), (posY - 20), (posX - 20), (posY + 10), (posX - 20), (posY + 20), (posX - 20), (posY + 20), (posX - 10), (posY + 20), (posX + 20), (posY - 10), (posX + 20), (posY - 20), (posX + 20), (posY - 20), (posX + 10), (posY - 20), (posX + 20), (posY + 10), (posX + 20), (posY + 20), (posX + 20), (posY + 20), (posX + 10), (posY + 20) };
/* 118 */     func_73734_a(posX - 20, posY + 20 + 1, posX - 20 + 40, posY + 20 + 1 + 1 + 3 + 1, color);
/* 119 */     float lock = cntLock / cntMax;
/* 120 */     func_73734_a(posX - 20 + 1, posY + 20 + 1 + 1, posX - 20 + 1 + (int)(38.0D * lock), posY + 20 + 1 + 1 + 3, -2161656);
/*     */   }
/*     */   
/*     */   void drawRange(EntityPlayer player, MCH_WeaponGuidanceSystem gs, boolean canFire, int color1, int color2) {
/* 124 */     String msgLockDist = "[--.--]";
/* 125 */     int color = color2;
/* 126 */     if (gs.getLockCount() > 0) {
/* 127 */       Entity target = gs.getLockingEntity();
/* 128 */       if (target != null) {
/* 129 */         double dx = target.field_70165_t - player.field_70165_t;
/* 130 */         double dz = target.field_70161_v - player.field_70161_v;
/* 131 */         msgLockDist = String.format("[%.2f]", new Object[] { Double.valueOf(Math.sqrt(dx * dx + dz * dz)) });
/* 132 */         color = canFire ? color1 : color2;
/* 133 */         MCH_Config var10000 = MCH_MOD.config;
/* 134 */         if (!MCH_Config.HideKeybind.prmBool && gs.isLockComplete()) {
/* 135 */           var10000 = MCH_MOD.config;
/* 136 */           String k = MCH_KeyName.getDescOrName(MCH_Config.KeyAttack.prmInt);
/* 137 */           drawCenteredString("Shot : " + k, this.centerX, this.centerY + 65, -805306369);
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 142 */     drawCenteredString(msgLockDist, this.centerX, this.centerY + 50, color);
/*     */   }
/*     */   
/*     */   void drawGuiFGM148(EntityPlayer player, MCH_WeaponGuidanceSystem gs, boolean canFire, ItemStack itemStack) {
/* 146 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 147 */     double fac = (this.field_146294_l / 800.0D < this.field_146295_m / 700.0D) ? (this.field_146294_l / 800.0D) : (this.field_146295_m / 700.0D);
/* 148 */     int size = (int)(1024.0D * fac);
/* 149 */     size = size / 64 * 64;
/* 150 */     fac = size / 1024.0D;
/* 151 */     double left = (-(size - this.field_146294_l) / 2);
/* 152 */     double top = (-(size - this.field_146295_m) / 2 - 20);
/* 153 */     double right = left + size;
/* 154 */     double bottom = top + size;
/* 155 */     Vec3 pos = MCH_ClientLightWeaponTickHandler.getMartEntityPos();
/* 156 */     if (gs.getLockCount() > 0) {
/* 157 */       int x = (MCH_Gui.scaleFactor > 0) ? MCH_Gui.scaleFactor : 2;
/* 158 */       if (pos == null) {
/* 159 */         pos = Vec3.func_72443_a((this.field_146294_l / 2 * x), (this.field_146295_m / 2 * x), 0.0D);
/*     */       }
/*     */       
/* 162 */       double IX = 280.0D * fac;
/* 163 */       double IY = 370.0D * fac;
/* 164 */       double cx = pos.field_72450_a / x;
/* 165 */       double cy = this.field_146295_m - pos.field_72448_b / x;
/* 166 */       double sx = MCH_Lib.RNG(cx, left + IX, right - IX);
/* 167 */       double sy = MCH_Lib.RNG(cy, top + IY, bottom - IY);
/* 168 */       if (gs.getLockCount() >= gs.getLockCountMax() / 2) {
/* 169 */         drawLine(new double[] { -1.0D, sy, (this.field_146294_l + 1), sy, sx, -1.0D, sx, (this.field_146295_m + 1) }, -1593835521);
/*     */       }
/*     */       
/* 172 */       if (player.field_70173_aa % 6 >= 3) {
/* 173 */         pos = MCH_ClientLightWeaponTickHandler.getMartEntityBBPos();
/* 174 */         if (pos == null) {
/* 175 */           pos = Vec3.func_72443_a(((this.field_146294_l / 2 - 65) * x), ((this.field_146295_m / 2 + 50) * x), 0.0D);
/*     */         }
/*     */         
/* 178 */         double bx = pos.field_72450_a / x;
/* 179 */         double by = this.field_146295_m - pos.field_72448_b / x;
/* 180 */         double dx = Math.abs(cx - bx);
/* 181 */         double dy = Math.abs(cy - by);
/* 182 */         double p = 1.0D - gs.getLockCount() / gs.getLockCountMax();
/* 183 */         dx = MCH_Lib.RNG(dx, 25.0D, 70.0D);
/* 184 */         dy = MCH_Lib.RNG(dy, 15.0D, 70.0D);
/* 185 */         dx += (70.0D - dx) * p;
/* 186 */         dy += (70.0D - dy) * p;
/* 187 */         byte lx = 10;
/* 188 */         byte ly = 6;
/* 189 */         drawLine(new double[] { sx - dx, sy - dy + ly, sx - dx, sy - dy, sx - dx + lx, sy - dy }, -1593835521, 3);
/* 190 */         drawLine(new double[] { sx + dx, sy - dy + ly, sx + dx, sy - dy, sx + dx - lx, sy - dy }, -1593835521, 3);
/* 191 */         dy /= 6.0D;
/* 192 */         drawLine(new double[] { sx - dx, sy + dy - ly, sx - dx, sy + dy, sx - dx + lx, sy + dy }, -1593835521, 3);
/* 193 */         drawLine(new double[] { sx + dx, sy + dy - ly, sx + dx, sy + dy, sx + dx - lx, sy + dy }, -1593835521, 3);
/*     */       } 
/*     */     } 
/*     */     
/* 197 */     func_73734_a(-1, -1, (int)left + 1, this.field_146295_m + 1, -16777216);
/* 198 */     func_73734_a((int)right - 1, -1, this.field_146294_l + 1, this.field_146295_m + 1, -16777216);
/* 199 */     func_73734_a(-1, -1, this.field_146294_l + 1, (int)top + 1, -16777216);
/* 200 */     func_73734_a(-1, (int)bottom - 1, this.field_146294_l + 1, this.field_146295_m + 1, -16777216);
/* 201 */     GL11.glEnable(3042);
/* 202 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/* 203 */     W_McClient.MOD_bindTexture("textures/gui/javelin.png");
/* 204 */     drawTexturedModalRectRotate(left, top, size, size, 0.0D, 0.0D, 256.0D, 256.0D, 0.0F);
/* 205 */     W_McClient.MOD_bindTexture("textures/gui/javelin2.png");
/* 206 */     PotionEffect pe = player.func_70660_b(Potion.field_76439_r);
/*     */ 
/*     */ 
/*     */ 
/*     */     
/* 211 */     if (pe == null) {
/* 212 */       double x1 = 247.0D;
/* 213 */       double y = 211.0D;
/* 214 */       double w = 380.0D;
/* 215 */       double h = 350.0D;
/* 216 */       drawTexturedRect(left + x1 * fac, top + y * fac, (w - x1) * fac, (h - y) * fac, x1, y, w - x1, h - y, 1024.0D, 1024.0D);
/*     */     } 
/*     */     
/* 219 */     if (player.func_71057_bx() <= 60) {
/* 220 */       double x1 = 130.0D;
/* 221 */       double y = 334.0D;
/* 222 */       double w = 257.0D;
/* 223 */       double h = 455.0D;
/* 224 */       drawTexturedRect(left + x1 * fac, top + y * fac, (w - x1) * fac, (h - y) * fac, x1, y, w - x1, h - y, 1024.0D, 1024.0D);
/*     */     } 
/*     */     
/* 227 */     if (MCH_ClientLightWeaponTickHandler.selectedZoom == 0) {
/* 228 */       double x1 = 387.0D;
/* 229 */       double y = 211.0D;
/* 230 */       double w = 510.0D;
/* 231 */       double h = 350.0D;
/* 232 */       drawTexturedRect(left + x1 * fac, top + y * fac, (w - x1) * fac, (h - y) * fac, x1, y, w - x1, h - y, 1024.0D, 1024.0D);
/*     */     } 
/*     */     
/* 235 */     if (MCH_ClientLightWeaponTickHandler.selectedZoom == (MCH_ClientLightWeaponTickHandler.weapon.getInfo()).zoom.length - 1) {
/* 236 */       double x1 = 511.0D;
/* 237 */       double y = 211.0D;
/* 238 */       double w = 645.0D;
/* 239 */       double h = 350.0D;
/* 240 */       drawTexturedRect(left + x1 * fac, top + y * fac, (w - x1) * fac, (h - y) * fac, x1, y, w - x1, h - y, 1024.0D, 1024.0D);
/*     */     } 
/*     */     
/* 243 */     if (gs.getLockCount() > 0) {
/* 244 */       double x1 = 643.0D;
/* 245 */       double y = 211.0D;
/* 246 */       double w = 775.0D;
/* 247 */       double h = 350.0D;
/* 248 */       drawTexturedRect(left + x1 * fac, top + y * fac, (w - x1) * fac, (h - y) * fac, x1, y, w - x1, h - y, 1024.0D, 1024.0D);
/*     */     } 
/*     */     
/* 251 */     if (MCH_ClientLightWeaponTickHandler.weaponMode == 1) {
/* 252 */       double x1 = 768.0D;
/* 253 */       double y = 340.0D;
/* 254 */       double w = 890.0D;
/* 255 */       double h = 455.0D;
/* 256 */       drawTexturedRect(left + x1 * fac, top + y * fac, (w - x1) * fac, (h - y) * fac, x1, y, w - x1, h - y, 1024.0D, 1024.0D);
/*     */     } else {
/* 258 */       double x1 = 768.0D;
/* 259 */       double y = 456.0D;
/* 260 */       double w = 890.0D;
/* 261 */       double h = 565.0D;
/* 262 */       drawTexturedRect(left + x1 * fac, top + y * fac, (w - x1) * fac, (h - y) * fac, x1, y, w - x1, h - y, 1024.0D, 1024.0D);
/*     */     } 
/*     */     
/* 265 */     if (!canFire) {
/* 266 */       double d4 = 379.0D;
/* 267 */       double d1 = 670.0D;
/* 268 */       double d2 = 511.0D;
/* 269 */       double d3 = 810.0D;
/* 270 */       drawTexturedRect(left + d4 * fac, top + d1 * fac, (d2 - d4) * fac, (d3 - d1) * fac, d4, d1, d2 - d4, d3 - d1, 1024.0D, 1024.0D);
/*     */     } 
/*     */     
/* 273 */     if (itemStack.func_77960_j() >= itemStack.func_77958_k()) {
/* 274 */       double d4 = 512.0D;
/* 275 */       double d1 = 670.0D;
/* 276 */       double d2 = 645.0D;
/* 277 */       double d3 = 810.0D;
/* 278 */       drawTexturedRect(left + d4 * fac, top + d1 * fac, (d2 - d4) * fac, (d3 - d1) * fac, d4, d1, d2 - d4, d3 - d1, 1024.0D, 1024.0D);
/*     */     } 
/*     */     
/* 281 */     if (gs.getLockCount() < gs.getLockCountMax()) {
/* 282 */       double d4 = 646.0D;
/* 283 */       double d1 = 670.0D;
/* 284 */       double d2 = 776.0D;
/* 285 */       double d3 = 810.0D;
/* 286 */       drawTexturedRect(left + d4 * fac, top + d1 * fac, (d2 - d4) * fac, (d3 - d1) * fac, d4, d1, d2 - d4, d3 - d1, 1024.0D, 1024.0D);
/*     */     } 
/*     */     
/* 289 */     if (pe != null) {
/* 290 */       double d4 = 768.0D;
/* 291 */       double d1 = 562.0D;
/* 292 */       double d2 = 890.0D;
/* 293 */       double d3 = 694.0D;
/* 294 */       drawTexturedRect(left + d4 * fac, top + d1 * fac, (d2 - d4) * fac, (d3 - d1) * fac, d4, d1, d2 - d4, d3 - d1, 1024.0D, 1024.0D);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void drawKeyBind(int color, boolean canSwitchMode) {
/* 300 */     int OffX = this.centerX + 55;
/* 301 */     int OffY = this.centerY + 40;
/* 302 */     drawString("CAM MODE :", OffX, OffY + 10, color);
/* 303 */     drawString("ZOOM      :", OffX, OffY + 20, color);
/* 304 */     if (canSwitchMode) {
/* 305 */       drawString("MODE      :", OffX, OffY + 30, color);
/*     */     }
/*     */     
/* 308 */     OffX += 60;
/* 309 */     MCH_Config var10001 = MCH_MOD.config;
/* 310 */     drawString(MCH_KeyName.getDescOrName(MCH_Config.KeyCameraMode.prmInt), OffX, OffY + 10, color);
/* 311 */     var10001 = MCH_MOD.config;
/* 312 */     drawString(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt), OffX, OffY + 20, color);
/* 313 */     if (canSwitchMode) {
/* 314 */       var10001 = MCH_MOD.config;
/* 315 */       drawString(MCH_KeyName.getDescOrName(MCH_Config.KeySwWeaponMode.prmInt), OffX, OffY + 30, color);
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\lweapon\MCH_GuiLightWeapon.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */