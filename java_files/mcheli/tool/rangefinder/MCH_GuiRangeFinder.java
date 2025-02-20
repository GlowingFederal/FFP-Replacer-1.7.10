/*     */ package mcheli.tool.rangefinder;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import mcheli.MCH_Config;
/*     */ import mcheli.MCH_KeyName;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_MOD;
/*     */ import mcheli.gui.MCH_Gui;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.MovingObjectPosition;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_GuiRangeFinder
/*     */   extends MCH_Gui
/*     */ {
/*     */   public MCH_GuiRangeFinder(Minecraft minecraft) {
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
/*  39 */     return MCH_ItemRangeFinder.canUse(player);
/*     */   }
/*     */   
/*     */   public void drawGui(EntityPlayer player, boolean isThirdPersonView) {
/*  43 */     if (!isThirdPersonView) {
/*  44 */       GL11.glLineWidth(MCH_Gui.scaleFactor);
/*  45 */       if (isDrawGui(player)) {
/*  46 */         GL11.glDisable(3042);
/*  47 */         if (MCH_ItemRangeFinder.isUsingScope(player)) {
/*  48 */           drawRF(player);
/*     */         }
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static MovingObjectPosition worldRay(World world, Vec3 p_147447_1_, Vec3 p_147447_2_, boolean p_147447_3_, boolean p_147447_4_, boolean p_147447_5_) {
/*  56 */     if (!Double.isNaN(p_147447_1_.field_72450_a) && !Double.isNaN(p_147447_1_.field_72448_b) && !Double.isNaN(p_147447_1_.field_72449_c)) {
/*  57 */       if (!Double.isNaN(p_147447_2_.field_72450_a) && !Double.isNaN(p_147447_2_.field_72448_b) && !Double.isNaN(p_147447_2_.field_72449_c)) {
/*  58 */         int i = MathHelper.func_76128_c(p_147447_2_.field_72450_a);
/*  59 */         int j = MathHelper.func_76128_c(p_147447_2_.field_72448_b);
/*  60 */         int k = MathHelper.func_76128_c(p_147447_2_.field_72449_c);
/*  61 */         int l = MathHelper.func_76128_c(p_147447_1_.field_72450_a);
/*  62 */         int i1 = MathHelper.func_76128_c(p_147447_1_.field_72448_b);
/*  63 */         int j1 = MathHelper.func_76128_c(p_147447_1_.field_72449_c);
/*  64 */         Block block = world.func_147439_a(l, i1, j1);
/*  65 */         int k1 = world.func_72805_g(l, i1, j1);
/*     */         
/*  67 */         if ((!p_147447_4_ || block.func_149668_a(world, l, i1, j1) != null) && block.func_149678_a(k1, p_147447_3_)) {
/*  68 */           MovingObjectPosition movingobjectposition = block.func_149731_a(world, l, i1, j1, p_147447_1_, p_147447_2_);
/*     */           
/*  70 */           if (movingobjectposition != null) {
/*  71 */             return movingobjectposition;
/*     */           }
/*     */         } 
/*     */         
/*  75 */         MovingObjectPosition movingobjectposition2 = null;
/*  76 */         k1 = 500;
/*     */         
/*  78 */         while (k1-- >= 0) {
/*  79 */           byte b0; if (Double.isNaN(p_147447_1_.field_72450_a) || Double.isNaN(p_147447_1_.field_72448_b) || Double.isNaN(p_147447_1_.field_72449_c)) {
/*  80 */             return null;
/*     */           }
/*     */           
/*  83 */           if (l == i && i1 == j && j1 == k) {
/*  84 */             return p_147447_5_ ? movingobjectposition2 : null;
/*     */           }
/*     */           
/*  87 */           boolean flag6 = true;
/*  88 */           boolean flag3 = true;
/*  89 */           boolean flag4 = true;
/*  90 */           double d0 = 999.0D;
/*  91 */           double d1 = 999.0D;
/*  92 */           double d2 = 999.0D;
/*     */           
/*  94 */           if (i > l) {
/*  95 */             d0 = l + 1.0D;
/*  96 */           } else if (i < l) {
/*  97 */             d0 = l + 0.0D;
/*     */           } else {
/*  99 */             flag6 = false;
/*     */           } 
/*     */           
/* 102 */           if (j > i1) {
/* 103 */             d1 = i1 + 1.0D;
/* 104 */           } else if (j < i1) {
/* 105 */             d1 = i1 + 0.0D;
/*     */           } else {
/* 107 */             flag3 = false;
/*     */           } 
/*     */           
/* 110 */           if (k > j1) {
/* 111 */             d2 = j1 + 1.0D;
/* 112 */           } else if (k < j1) {
/* 113 */             d2 = j1 + 0.0D;
/*     */           } else {
/* 115 */             flag4 = false;
/*     */           } 
/*     */           
/* 118 */           double d3 = 999.0D;
/* 119 */           double d4 = 999.0D;
/* 120 */           double d5 = 999.0D;
/* 121 */           double d6 = p_147447_2_.field_72450_a - p_147447_1_.field_72450_a;
/* 122 */           double d7 = p_147447_2_.field_72448_b - p_147447_1_.field_72448_b;
/* 123 */           double d8 = p_147447_2_.field_72449_c - p_147447_1_.field_72449_c;
/*     */           
/* 125 */           if (flag6) {
/* 126 */             d3 = (d0 - p_147447_1_.field_72450_a) / d6;
/*     */           }
/*     */           
/* 129 */           if (flag3) {
/* 130 */             d4 = (d1 - p_147447_1_.field_72448_b) / d7;
/*     */           }
/*     */           
/* 133 */           if (flag4) {
/* 134 */             d5 = (d2 - p_147447_1_.field_72449_c) / d8;
/*     */           }
/*     */           
/* 137 */           boolean flag5 = false;
/*     */ 
/*     */           
/* 140 */           if (d3 < d4 && d3 < d5) {
/* 141 */             if (i > l) {
/* 142 */               b0 = 4;
/*     */             } else {
/* 144 */               b0 = 5;
/*     */             } 
/*     */             
/* 147 */             p_147447_1_.field_72450_a = d0;
/* 148 */             p_147447_1_.field_72448_b += d7 * d3;
/* 149 */             p_147447_1_.field_72449_c += d8 * d3;
/* 150 */           } else if (d4 < d5) {
/* 151 */             if (j > i1) {
/* 152 */               b0 = 0;
/*     */             } else {
/* 154 */               b0 = 1;
/*     */             } 
/*     */             
/* 157 */             p_147447_1_.field_72450_a += d6 * d4;
/* 158 */             p_147447_1_.field_72448_b = d1;
/* 159 */             p_147447_1_.field_72449_c += d8 * d4;
/*     */           } else {
/* 161 */             if (k > j1) {
/* 162 */               b0 = 2;
/*     */             } else {
/* 164 */               b0 = 3;
/*     */             } 
/*     */             
/* 167 */             p_147447_1_.field_72450_a += d6 * d5;
/* 168 */             p_147447_1_.field_72448_b += d7 * d5;
/* 169 */             p_147447_1_.field_72449_c = d2;
/*     */           } 
/*     */           
/* 172 */           Vec3 vec32 = Vec3.func_72443_a(p_147447_1_.field_72450_a, p_147447_1_.field_72448_b, p_147447_1_.field_72449_c);
/* 173 */           l = (int)(vec32.field_72450_a = MathHelper.func_76128_c(p_147447_1_.field_72450_a));
/*     */           
/* 175 */           if (b0 == 5) {
/* 176 */             l--;
/* 177 */             vec32.field_72450_a++;
/*     */           } 
/*     */           
/* 180 */           i1 = (int)(vec32.field_72448_b = MathHelper.func_76128_c(p_147447_1_.field_72448_b));
/*     */           
/* 182 */           if (b0 == 1) {
/* 183 */             i1--;
/* 184 */             vec32.field_72448_b++;
/*     */           } 
/*     */           
/* 187 */           j1 = (int)(vec32.field_72449_c = MathHelper.func_76128_c(p_147447_1_.field_72449_c));
/*     */           
/* 189 */           if (b0 == 3) {
/* 190 */             j1--;
/* 191 */             vec32.field_72449_c++;
/*     */           } 
/*     */           
/* 194 */           Block block1 = world.func_147439_a(l, i1, j1);
/* 195 */           int l1 = world.func_72805_g(l, i1, j1);
/*     */           
/* 197 */           if (!p_147447_4_ || block1.func_149668_a(world, l, i1, j1) != null) {
/* 198 */             if (block1.func_149678_a(l1, p_147447_3_)) {
/* 199 */               MovingObjectPosition movingobjectposition1 = block1.func_149731_a(world, l, i1, j1, p_147447_1_, p_147447_2_);
/*     */               
/* 201 */               if (movingobjectposition1 != null)
/* 202 */                 return movingobjectposition1; 
/*     */               continue;
/*     */             } 
/* 205 */             movingobjectposition2 = new MovingObjectPosition(l, i1, j1, b0, p_147447_1_, false);
/*     */           } 
/*     */         } 
/*     */ 
/*     */         
/* 210 */         return p_147447_5_ ? movingobjectposition2 : null;
/*     */       } 
/* 212 */       return null;
/*     */     } 
/*     */     
/* 215 */     return null;
/*     */   }
/*     */ 
/*     */   
/*     */   public static MovingObjectPosition rayTraceBlocks(World world, Vec3 p_72933_1_, Vec3 p_72933_2_) {
/* 220 */     return worldRay(world, p_72933_1_, p_72933_2_, false, false, false);
/*     */   }
/*     */   
/*     */   public MovingObjectPosition rayTraceBlocks(World world, Vec3 p_72901_1_, Vec3 p_72901_2_, boolean p_72901_3_) {
/* 224 */     return worldRay(world, p_72901_1_, p_72901_2_, p_72901_3_, false, false);
/*     */   }
/*     */   
/*     */   void drawRF(EntityPlayer player) {
/* 228 */     GL11.glEnable(3042);
/* 229 */     GL11.glColor4f(0.0F, 0.0F, 0.0F, 1.0F);
/* 230 */     int srcBlend = GL11.glGetInteger(3041);
/* 231 */     int dstBlend = GL11.glGetInteger(3040);
/* 232 */     GL11.glBlendFunc(770, 771);
/* 233 */     W_McClient.MOD_bindTexture("textures/gui/rangefinder.png");
/*     */     
/*     */     double size;
/* 236 */     for (size = 512.0D; size < this.field_146294_l || size < this.field_146295_m; size *= 2.0D);
/*     */ 
/*     */ 
/*     */     
/* 240 */     drawTexturedModalRectRotate(-(size - this.field_146294_l) / 2.0D, -(size - this.field_146295_m) / 2.0D, size, size, 0.0D, 0.0D, 256.0D, 256.0D, 0.0F);
/* 241 */     GL11.glBlendFunc(srcBlend, dstBlend);
/* 242 */     GL11.glDisable(3042);
/* 243 */     double factor = size / 512.0D;
/* 244 */     double SCALE_FACTOR = MCH_Gui.scaleFactor * factor;
/* 245 */     double CX = (this.field_146297_k.field_71443_c / 2);
/* 246 */     double CY = (this.field_146297_k.field_71440_d / 2);
/* 247 */     double px = (CX - 80.0D * SCALE_FACTOR) / SCALE_FACTOR;
/* 248 */     double py = (CY + 55.0D * SCALE_FACTOR) / SCALE_FACTOR;
/* 249 */     GL11.glPushMatrix();
/* 250 */     GL11.glScaled(factor, factor, factor);
/* 251 */     ItemStack item = player.func_71045_bC();
/* 252 */     int damage = (int)((item.func_77958_k() - item.func_77960_j()) / item.func_77958_k() * 100.0D);
/* 253 */     drawDigit(String.format("%3d", new Object[] { Integer.valueOf(damage) }), (int)px, (int)py, 13, (damage > 0) ? -15663328 : -61424);
/* 254 */     if (damage <= 0) {
/* 255 */       drawString("Please craft", (int)px + 40, (int)py + 0, -65536);
/* 256 */       drawString("redstone", (int)px + 40, (int)py + 10, -65536);
/*     */     } 
/*     */     
/* 259 */     px = (CX - 20.0D * SCALE_FACTOR) / SCALE_FACTOR;
/* 260 */     if (damage > 0) {
/* 261 */       Vec3 mode = Vec3.func_72443_a(player.field_70165_t, player.field_70163_u + player.func_70047_e(), player.field_70161_v);
/* 262 */       Vec3 s = MCH_Lib.Rot2Vec3(player.field_70177_z, player.field_70125_A);
/* 263 */       s = mode.func_72441_c(s.field_72450_a * 900.0D, s.field_72448_b * 900.0D, s.field_72449_c * 900.0D);
/* 264 */       MovingObjectPosition mop = rayTraceBlocks(player.field_70170_p, mode, s, true);
/* 265 */       if (mop != null && mop.field_72313_a != MovingObjectPosition.MovingObjectType.MISS) {
/* 266 */         int range = (int)player.func_70011_f(mop.field_72307_f.field_72450_a, mop.field_72307_f.field_72448_b, mop.field_72307_f.field_72449_c);
/* 267 */         drawDigit(String.format("%4d", new Object[] { Integer.valueOf(range) }), (int)px, (int)py, 13, -15663328);
/*     */       } else {
/* 269 */         drawDigit(String.format("----", new Object[0]), (int)px, (int)py, 13, -61424);
/*     */       } 
/*     */     } 
/*     */     
/* 273 */     py -= 4.0D;
/* 274 */     px -= 80.0D;
/* 275 */     func_73734_a((int)px, (int)py, (int)px + 30, (int)py + 2, -15663328);
/* 276 */     func_73734_a((int)px, (int)py, (int)px + MCH_ItemRangeFinder.rangeFinderUseCooldown / 2, (int)py + 2, -61424);
/* 277 */     drawString(String.format("x%.1f", new Object[] { Float.valueOf(MCH_ItemRangeFinder.zoom) }), (int)px, (int)py - 20, -1);
/* 278 */     px += 130.0D;
/* 279 */     int mode1 = MCH_ItemRangeFinder.mode = 2;
/* 280 */     drawString(">", (int)px, (int)py - 30 + mode1 * 10, -1);
/* 281 */     px += 10.0D;
/* 282 */     drawString("Players/Vehicles", (int)px, (int)py - 30, (mode1 == 0) ? -1 : -12566464);
/* 283 */     drawString("Monsters/Mobs", (int)px, (int)py - 20, (mode1 == 1) ? -1 : -12566464);
/* 284 */     drawString("Mark Point", (int)px, (int)py - 10, (mode1 == 2) ? -1 : -12566464);
/* 285 */     GL11.glPopMatrix();
/* 286 */     px = (CX - 160.0D * SCALE_FACTOR) / MCH_Gui.scaleFactor;
/* 287 */     py = (CY - 100.0D * SCALE_FACTOR) / MCH_Gui.scaleFactor;
/* 288 */     if (px < 10.0D) {
/* 289 */       px = 10.0D;
/*     */     }
/*     */     
/* 292 */     if (py < 10.0D) {
/* 293 */       py = 10.0D;
/*     */     }
/*     */     
/* 296 */     StringBuilder var10000 = (new StringBuilder()).append("Spot      : ");
/* 297 */     MCH_Config var10001 = MCH_MOD.config;
/* 298 */     String s1 = var10000.append(MCH_KeyName.getDescOrName(MCH_Config.KeyAttack.prmInt)).toString();
/* 299 */     drawString(s1, (int)px, (int)py + 0, -1);
/* 300 */     var10000 = (new StringBuilder()).append("Zoom in   : ");
/* 301 */     var10001 = MCH_MOD.config;
/* 302 */     s1 = var10000.append(MCH_KeyName.getDescOrName(MCH_Config.KeyZoom.prmInt)).toString();
/* 303 */     drawString(s1, (int)px, (int)py + 10, (MCH_ItemRangeFinder.zoom < 10.0F) ? -1 : -12566464);
/* 304 */     var10000 = (new StringBuilder()).append("Zoom out : ");
/* 305 */     var10001 = MCH_MOD.config;
/* 306 */     s1 = var10000.append(MCH_KeyName.getDescOrName(MCH_Config.KeySwWeaponMode.prmInt)).toString();
/* 307 */     drawString(s1, (int)px, (int)py + 20, (MCH_ItemRangeFinder.zoom > 1.2F) ? -1 : -12566464);
/* 308 */     var10000 = (new StringBuilder()).append("Mode      : ");
/* 309 */     var10001 = MCH_MOD.config;
/* 310 */     s1 = var10000.append(MCH_KeyName.getDescOrName(MCH_Config.KeyFlare.prmInt)).toString();
/* 311 */     drawString(s1, (int)px, (int)py + 30, -1);
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tool\rangefinder\MCH_GuiRangeFinder.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */