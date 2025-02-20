/*     */ package mcheli;
/*     */ import java.io.File;
/*     */ import java.text.SimpleDateFormat;
/*     */ import java.util.ArrayList;
/*     */ import java.util.HashMap;
/*     */ import java.util.Iterator;
/*     */ import java.util.Map;
/*     */ import mcheli.wrapper.W_Block;
/*     */ import mcheli.wrapper.W_McClient;
/*     */ import mcheli.wrapper.W_Reflection;
/*     */ import mcheli.wrapper.W_Vec3;
/*     */ import mcheli.wrapper.W_WorldFunc;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.entity.player.InventoryPlayer;
/*     */ import net.minecraft.init.Blocks;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.item.ItemStack;
/*     */ import net.minecraft.item.crafting.IRecipe;
/*     */ import net.minecraft.util.MathHelper;
/*     */ import net.minecraft.util.Vec3;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_Lib {
/*  27 */   private static HashMap mapMaterial = new HashMap<>();
/*  28 */   public static final String[] AZIMUTH_8 = new String[] { "S", "SW", "W", "NW", "N", "NE", "E", "SE" };
/*  29 */   public static final int AZIMUTH_8_ANG = 360 / AZIMUTH_8.length;
/*     */ 
/*     */   
/*     */   public static void init() {
/*  33 */     mapMaterial.clear();
/*  34 */     mapMaterial.put("air", Material.field_151579_a);
/*  35 */     mapMaterial.put("grass", Material.field_151577_b);
/*  36 */     mapMaterial.put("ground", Material.field_151578_c);
/*  37 */     mapMaterial.put("wood", Material.field_151575_d);
/*  38 */     mapMaterial.put("rock", Material.field_151576_e);
/*  39 */     mapMaterial.put("iron", Material.field_151573_f);
/*  40 */     mapMaterial.put("anvil", Material.field_151574_g);
/*  41 */     mapMaterial.put("water", Material.field_151586_h);
/*  42 */     mapMaterial.put("lava", Material.field_151587_i);
/*  43 */     mapMaterial.put("leaves", Material.field_151584_j);
/*  44 */     mapMaterial.put("plants", Material.field_151585_k);
/*  45 */     mapMaterial.put("vine", Material.field_151582_l);
/*  46 */     mapMaterial.put("sponge", Material.field_151583_m);
/*  47 */     mapMaterial.put("cloth", Material.field_151580_n);
/*  48 */     mapMaterial.put("fire", Material.field_151581_o);
/*  49 */     mapMaterial.put("sand", Material.field_151595_p);
/*  50 */     mapMaterial.put("circuits", Material.field_151594_q);
/*  51 */     mapMaterial.put("carpet", Material.field_151593_r);
/*  52 */     mapMaterial.put("glass", Material.field_151592_s);
/*  53 */     mapMaterial.put("redstoneLight", Material.field_151591_t);
/*  54 */     mapMaterial.put("tnt", Material.field_151590_u);
/*  55 */     mapMaterial.put("coral", Material.field_151589_v);
/*  56 */     mapMaterial.put("ice", Material.field_151588_w);
/*  57 */     mapMaterial.put("packedIce", Material.field_151598_x);
/*  58 */     mapMaterial.put("snow", Material.field_151597_y);
/*  59 */     mapMaterial.put("craftedSnow", Material.field_151596_z);
/*  60 */     mapMaterial.put("cactus", Material.field_151570_A);
/*  61 */     mapMaterial.put("clay", Material.field_151571_B);
/*  62 */     mapMaterial.put("gourd", Material.field_151572_C);
/*  63 */     mapMaterial.put("dragonEgg", Material.field_151566_D);
/*  64 */     mapMaterial.put("portal", Material.field_151567_E);
/*  65 */     mapMaterial.put("cake", Material.field_151568_F);
/*  66 */     mapMaterial.put("web", Material.field_151569_G);
/*  67 */     mapMaterial.put("piston", Material.field_76233_E);
/*     */   }
/*     */   
/*     */   public static Material getMaterialFromName(String name) {
/*  71 */     return mapMaterial.containsKey(name) ? (Material)mapMaterial.get(name) : null;
/*     */   }
/*     */   
/*     */   public static Vec3 calculateFaceNormal(Vec3[] vertices) {
/*  75 */     Vec3 v1 = Vec3.func_72443_a((vertices[1]).field_72450_a - (vertices[0]).field_72450_a, (vertices[1]).field_72448_b - (vertices[0]).field_72448_b, (vertices[1]).field_72449_c - (vertices[0]).field_72449_c);
/*  76 */     Vec3 v2 = Vec3.func_72443_a((vertices[2]).field_72450_a - (vertices[0]).field_72450_a, (vertices[2]).field_72448_b - (vertices[0]).field_72448_b, (vertices[2]).field_72449_c - (vertices[0]).field_72449_c);
/*  77 */     return v1.func_72431_c(v2).func_72432_b();
/*     */   }
/*     */   
/*     */   public static double parseDouble(String s) {
/*  81 */     return (s == null) ? 0.0D : Double.parseDouble(s.replace(',', '.'));
/*     */   }
/*     */   
/*     */   public static float RNG(float a, float min, float max) {
/*  85 */     return (a < min) ? min : ((a > max) ? max : a);
/*     */   }
/*     */   
/*     */   public static double RNG(double a, double min, double max) {
/*  89 */     return (a < min) ? min : ((a > max) ? max : a);
/*     */   }
/*     */   
/*     */   public static float smooth(float rot, float prevRot, float tick) {
/*  93 */     return prevRot + (rot - prevRot) * tick;
/*     */   }
/*     */   
/*     */   public static float smoothRot(float rot, float prevRot, float tick) {
/*  97 */     if (rot - prevRot < -180.0F) {
/*  98 */       prevRot -= 360.0F;
/*  99 */     } else if (prevRot - rot < -180.0F) {
/* 100 */       prevRot += 360.0F;
/*     */     } 
/*     */     
/* 103 */     return prevRot + (rot - prevRot) * tick;
/*     */   }
/*     */   
/*     */   public static double getRotateDiff(double base, double target) {
/* 107 */     base = getRotate360(base);
/* 108 */     target = getRotate360(target);
/* 109 */     if (target - base < -180.0D) {
/* 110 */       target += 360.0D;
/* 111 */     } else if (target - base > 180.0D) {
/* 112 */       base += 360.0D;
/*     */     } 
/*     */     
/* 115 */     return target - base;
/*     */   }
/*     */   
/*     */   public static float getPosAngle(double tx, double tz, double cx, double cz) {
/* 119 */     double length_A = Math.sqrt(tx * tx + tz * tz);
/* 120 */     double length_B = Math.sqrt(cx * cx + cz * cz);
/* 121 */     double cos_sita = (tx * cx + tz * cz) / length_A * length_B;
/* 122 */     double sita = Math.acos(cos_sita);
/* 123 */     return (float)(sita * 180.0D / Math.PI);
/*     */   }
/*     */   
/*     */   public static boolean canPlayerCreateItem(IRecipe recipe, InventoryPlayer inventory) {
/* 127 */     if (recipe != null) {
/* 128 */       int var7; Map<Item, Integer> map = getItemMapFromRecipe(recipe);
/*     */       
/* 130 */       for (int i$ = 0; i$ < inventory.func_70302_i_(); i$++) {
/* 131 */         ItemStack i = inventory.func_70301_a(i$);
/* 132 */         if (i != null) {
/* 133 */           Item item = i.func_77973_b();
/* 134 */           if (map.containsKey(item)) {
/* 135 */             map.put(item, Integer.valueOf(((Integer)map.get(item)).intValue() - i.field_77994_a));
/*     */           }
/*     */         } 
/*     */       } 
/*     */       
/* 140 */       Iterator<Integer> var6 = map.values().iterator();
/*     */ 
/*     */       
/*     */       do {
/* 144 */         if (!var6.hasNext()) {
/* 145 */           return true;
/*     */         }
/*     */         
/* 148 */         var7 = ((Integer)var6.next()).intValue();
/* 149 */       } while (var7 <= 0);
/*     */       
/* 151 */       return false;
/*     */     } 
/* 153 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static void applyEntityHurtResistantTimeConfig(Entity entity) {
/* 158 */     if (entity instanceof EntityLivingBase) {
/* 159 */       EntityLivingBase elb = (EntityLivingBase)entity;
/* 160 */       MCH_Config var10000 = MCH_MOD.config;
/* 161 */       double h_time = MCH_Config.HurtResistantTime.prmDouble * elb.field_70172_ad;
/* 162 */       elb.field_70172_ad = (int)h_time;
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static int round(double d) {
/* 168 */     return (int)(d + 0.5D);
/*     */   }
/*     */   
/*     */   public static Vec3 Rot2Vec3(float yaw, float pitch) {
/* 172 */     return Vec3.func_72443_a((-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F)), -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F), (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F)));
/*     */   }
/*     */   
/*     */   public static Vec3 RotVec3(double x, double y, double z, float yaw, float pitch) {
/* 176 */     Vec3 v = Vec3.func_72443_a(x, y, z);
/* 177 */     v.func_72440_a(pitch / 180.0F * 3.1415927F);
/* 178 */     v.func_72442_b(yaw / 180.0F * 3.1415927F);
/* 179 */     return v;
/*     */   }
/*     */   
/*     */   public static Vec3 RotVec3(double x, double y, double z, float yaw, float pitch, float roll) {
/* 183 */     Vec3 v = Vec3.func_72443_a(x, y, z);
/* 184 */     W_Vec3.rotateAroundZ(roll / 180.0F * 3.1415927F, v);
/* 185 */     v.func_72440_a(pitch / 180.0F * 3.1415927F);
/* 186 */     v.func_72442_b(yaw / 180.0F * 3.1415927F);
/* 187 */     return v;
/*     */   }
/*     */   
/*     */   public static Vec3 RotVec3(Vec3 vin, float yaw, float pitch) {
/* 191 */     Vec3 v = Vec3.func_72443_a(vin.field_72450_a, vin.field_72448_b, vin.field_72449_c);
/* 192 */     v.func_72440_a(pitch / 180.0F * 3.1415927F);
/* 193 */     v.func_72442_b(yaw / 180.0F * 3.1415927F);
/* 194 */     return v;
/*     */   }
/*     */   
/*     */   public static Vec3 RotVec3(Vec3 vin, float yaw, float pitch, float roll) {
/* 198 */     Vec3 v = Vec3.func_72443_a(vin.field_72450_a, vin.field_72448_b, vin.field_72449_c);
/* 199 */     W_Vec3.rotateAroundZ(roll / 180.0F * 3.1415927F, v);
/* 200 */     v.func_72440_a(pitch / 180.0F * 3.1415927F);
/* 201 */     v.func_72442_b(yaw / 180.0F * 3.1415927F);
/* 202 */     return v;
/*     */   }
/*     */   
/*     */   public static Vec3 _Rot2Vec3(float yaw, float pitch, float roll) {
/* 206 */     return Vec3.func_72443_a((-MathHelper.func_76126_a(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F)), -MathHelper.func_76126_a(pitch / 180.0F * 3.1415927F), (MathHelper.func_76134_b(yaw / 180.0F * 3.1415927F) * MathHelper.func_76134_b(pitch / 180.0F * 3.1415927F)));
/*     */   }
/*     */   
/*     */   public static double getRotate360(double r) {
/* 210 */     r %= 360.0D;
/* 211 */     return (r >= 0.0D) ? r : (r + 360.0D);
/*     */   }
/*     */   
/*     */   public static void Log(String format, Object... data) {
/* 215 */     String side = MCH_MOD.proxy.isRemote() ? "[Client]" : "[Server]";
/* 216 */     System.out.printf("[" + getTime() + "][mcheli]" + side + " " + format + "\n", data);
/*     */   }
/*     */   
/*     */   public static void Log(World world, String format, Object... data) {
/* 220 */     if (world != null) {
/* 221 */       Log((world.field_72995_K ? "[ClientWorld]" : "[ServerWorld]") + " " + format, data);
/*     */     } else {
/* 223 */       Log("[UnknownWorld]" + format, data);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void Log(Entity entity, String format, Object... data) {
/* 229 */     if (entity != null) {
/* 230 */       Log(entity.field_70170_p, format, data);
/*     */     } else {
/* 232 */       Log((World)null, format, data);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void DbgLog(boolean isRemote, String format, Object... data) {
/* 238 */     MCH_Config var10000 = MCH_MOD.config;
/* 239 */     if (MCH_Config.DebugLog) {
/* 240 */       String t = getTime();
/* 241 */       if (isRemote) {
/* 242 */         String playerName = "null";
/* 243 */         if (getClientPlayer() instanceof EntityPlayer) {
/* 244 */           playerName = ((EntityPlayer)getClientPlayer()).getDisplayName();
/*     */         }
/*     */         
/* 247 */         System.out.println(String.format(format, data));
/*     */       } else {
/* 249 */         System.out.println(String.format(format, data));
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void DbgLog(World w, String format, Object... data) {
/* 256 */     DbgLog(w.field_72995_K, format, data);
/*     */   }
/*     */   
/*     */   public static String getTime() {
/* 260 */     SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss:SSS");
/* 261 */     return sdf.format(new Date());
/*     */   }
/*     */   
/*     */   public static String getAzimuthStr8(int dir) {
/* 265 */     dir %= 360;
/* 266 */     if (dir < 0) {
/* 267 */       dir += 360;
/*     */     }
/*     */     
/* 270 */     dir /= AZIMUTH_8_ANG;
/* 271 */     return AZIMUTH_8[dir];
/*     */   }
/*     */   
/*     */   public static void rotatePoints(double[] points, float r) {
/* 275 */     r = r / 180.0F * 3.1415927F;
/*     */     
/* 277 */     for (int i = 0; i + 1 < points.length; i += 2) {
/* 278 */       double x = points[i + 0];
/* 279 */       double y = points[i + 1];
/* 280 */       points[i + 0] = x * MathHelper.func_76134_b(r) - y * MathHelper.func_76126_a(r);
/* 281 */       points[i + 1] = x * MathHelper.func_76126_a(r) + y * MathHelper.func_76134_b(r);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static void rotatePoints(ArrayList points, float r) {
/* 287 */     r = r / 180.0F * 3.1415927F;
/*     */     
/* 289 */     for (int i = 0; i + 1 < points.size(); i += 2) {
/* 290 */       double x = ((MCH_Vector2)points.get(i + 0)).x;
/* 291 */       double y = ((MCH_Vector2)points.get(i + 0)).y;
/* 292 */       ((MCH_Vector2)points.get(i + 0)).x = x * MathHelper.func_76134_b(r) - y * MathHelper.func_76126_a(r);
/* 293 */       ((MCH_Vector2)points.get(i + 0)).y = x * MathHelper.func_76126_a(r) + y * MathHelper.func_76134_b(r);
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public static String[] listupFileNames(String path) {
/* 299 */     File dir = new File(path);
/* 300 */     return dir.list();
/*     */   }
/*     */   
/*     */   public static boolean isBlockInWater(World w, int x, int y, int z) {
/* 304 */     int[][] offset = { { 0, -1, 0 }, { 0, 0, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { -1, 0, 0 }, { 1, 0, 0 }, { 0, 1, 0 } };
/* 305 */     if (y <= 0) {
/* 306 */       return false;
/*     */     }
/* 308 */     int[][] arr$ = offset;
/* 309 */     int len$ = offset.length;
/*     */     
/* 311 */     for (int i$ = 0; i$ < len$; i$++) {
/* 312 */       int[] o = arr$[i$];
/* 313 */       if (W_WorldFunc.isBlockWater(w, x + o[0], y + o[1], z + o[2])) {
/* 314 */         return true;
/*     */       }
/*     */     } 
/*     */     
/* 318 */     return false;
/*     */   }
/*     */ 
/*     */   
/*     */   public static int getBlockIdY(World w, double posX, double posY, double posZ, int size, int lenY, boolean canColliableOnly) {
/* 323 */     Block block = getBlockY(w, posX, posY, posZ, size, lenY, canColliableOnly);
/* 324 */     return (block == null) ? 0 : W_Block.func_149682_b(block);
/*     */   }
/*     */   
/*     */   public static int getBlockIdY(Entity entity, int size, int lenY) {
/* 328 */     return getBlockIdY(entity, size, lenY, true);
/*     */   }
/*     */   
/*     */   public static int getBlockIdY(Entity entity, int size, int lenY, boolean canColliableOnly) {
/* 332 */     Block block = getBlockY(entity, size, lenY, canColliableOnly);
/* 333 */     return (block == null) ? 0 : W_Block.func_149682_b(block);
/*     */   }
/*     */   
/*     */   public static Block getBlockY(Entity entity, int size, int lenY, boolean canColliableOnly) {
/* 337 */     return getBlockY(entity.field_70170_p, entity.field_70165_t, entity.field_70163_u, entity.field_70161_v, size, lenY, canColliableOnly);
/*     */   }
/*     */   
/*     */   public static Block getBlockY(World world, Vec3 pos, int size, int lenY, boolean canColliableOnly) {
/* 341 */     return getBlockY(world, pos.field_72450_a, pos.field_72448_b, pos.field_72449_c, size, lenY, canColliableOnly);
/*     */   }
/*     */   
/*     */   public static Block getBlockY(World world, double posX, double posY, double posZ, int size, int lenY, boolean canColliableOnly) {
/* 345 */     if (lenY == 0) {
/* 346 */       return Blocks.field_150350_a;
/*     */     }
/* 348 */     int px = (int)(posX + 0.5D);
/* 349 */     int py = (int)(posY + 0.5D);
/* 350 */     int pz = (int)(posZ + 0.5D);
/* 351 */     int cntY = (lenY > 0) ? lenY : -lenY;
/*     */     
/* 353 */     for (int y = 0; y < cntY; y++) {
/* 354 */       if (py + y < 0 || py + y > 255) {
/* 355 */         return Blocks.field_150350_a;
/*     */       }
/*     */       
/* 358 */       for (int x = -size / 2; x <= size / 2; x++) {
/* 359 */         for (int z = -size / 2; z <= size / 2; z++) {
/* 360 */           Block block = W_WorldFunc.getBlock(world, px + x, py + ((lenY > 0) ? y : -y), pz + z);
/* 361 */           if (block != null && block != Blocks.field_150350_a) {
/* 362 */             if (!canColliableOnly) {
/* 363 */               return block;
/*     */             }
/*     */             
/* 366 */             if (block.func_149678_a(0, true)) {
/* 367 */               return block;
/*     */             }
/*     */           } 
/*     */         } 
/*     */       } 
/*     */     } 
/*     */     
/* 374 */     return Blocks.field_150350_a;
/*     */   }
/*     */ 
/*     */   
/*     */   public static Vec3 getYawPitchFromVec(Vec3 v) {
/* 379 */     return getYawPitchFromVec(v.field_72450_a, v.field_72448_b, v.field_72449_c);
/*     */   }
/*     */   
/*     */   public static Vec3 getYawPitchFromVec(double x, double y, double z) {
/* 383 */     double p = MathHelper.func_76133_a(x * x + z * z);
/* 384 */     float yaw = (float)(Math.atan2(z, x) * 180.0D / Math.PI);
/* 385 */     float roll = (float)(Math.atan2(y, p) * 180.0D / Math.PI);
/* 386 */     return Vec3.func_72443_a(0.0D, yaw, roll);
/*     */   }
/*     */   
/*     */   public static float getAlpha(int argb) {
/* 390 */     return (argb >> 24) / 255.0F;
/*     */   }
/*     */   
/*     */   public static float getRed(int argb) {
/* 394 */     return (argb >> 16 & 0xFF) / 255.0F;
/*     */   }
/*     */   
/*     */   public static float getGreen(int argb) {
/* 398 */     return (argb >> 8 & 0xFF) / 255.0F;
/*     */   }
/*     */   
/*     */   public static float getBlue(int argb) {
/* 402 */     return (argb & 0xFF) / 255.0F;
/*     */   }
/*     */   
/*     */   public static void enableFirstPersonItemRender() {
/* 406 */     MCH_Config var10000 = MCH_MOD.config;
/* 407 */     switch (MCH_Config.DisableItemRender.prmInt) {
/*     */       default:
/*     */         return;
/*     */       
/*     */       case 2:
/* 412 */         MCH_ItemRendererDummy.disableDummyItemRenderer();
/*     */       case 3:
/*     */         break;
/* 415 */     }  W_Reflection.restoreCameraZoom();
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   public static void disableFirstPersonItemRender(ItemStack itemStack) {
/* 421 */     if (itemStack == null || !(itemStack.func_77973_b() instanceof net.minecraft.item.ItemMapBase) || W_McClient.getRenderEntity() instanceof MCH_ViewEntityDummy) {
/* 422 */       disableFirstPersonItemRender();
/*     */     }
/*     */   }
/*     */   
/*     */   public static void disableFirstPersonItemRender() {
/* 427 */     MCH_Config var10000 = MCH_MOD.config;
/* 428 */     switch (MCH_Config.DisableItemRender.prmInt) {
/*     */       case 1:
/* 430 */         W_Reflection.setItemRenderer_ItemToRender(new ItemStack((Item)MCH_MOD.invisibleItem));
/*     */         break;
/*     */       case 2:
/* 433 */         MCH_ItemRendererDummy.enableDummyItemRenderer();
/*     */         break;
/*     */       case 3:
/* 436 */         W_Reflection.setCameraZoom(1.01F);
/*     */         break;
/*     */     } 
/*     */   }
/*     */   
/*     */   public static Entity getClientPlayer() {
/* 442 */     return MCH_MOD.proxy.getClientPlayer();
/*     */   }
/*     */   
/*     */   public static void setRenderViewEntity(EntityLivingBase entity) {
/* 446 */     MCH_Config var10000 = MCH_MOD.config;
/* 447 */     if (MCH_Config.ReplaceRenderViewEntity.prmBool) {
/* 448 */       W_McClient.setRenderEntity(entity);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static Map getItemMapFromRecipe(IRecipe recipe) {
/* 454 */     HashMap<Object, Object> map = new HashMap<>();
/* 455 */     if (recipe instanceof ShapedRecipes) {
/* 456 */       ItemStack[] i$ = ((ShapedRecipes)recipe).field_77574_d;
/* 457 */       int o = i$.length;
/*     */       
/* 459 */       for (int is = 0; is < o; is++) {
/* 460 */         ItemStack item = i$[is];
/* 461 */         if (item != null) {
/* 462 */           Item item1 = item.func_77973_b();
/* 463 */           if (map.containsKey(item1)) {
/* 464 */             map.put(item1, Integer.valueOf(((Integer)map.get(item1)).intValue() + 1));
/*     */           } else {
/* 466 */             map.put(item1, Integer.valueOf(1));
/*     */           } 
/*     */         } 
/*     */       } 
/* 470 */     } else if (recipe instanceof ShapelessRecipes) {
/* 471 */       Iterator var7 = ((ShapelessRecipes)recipe).field_77579_b.iterator();
/*     */       
/* 473 */       while (var7.hasNext()) {
/* 474 */         Object var8 = var7.next();
/* 475 */         ItemStack var9 = (ItemStack)var8;
/* 476 */         if (var9 != null) {
/* 477 */           Item var10 = var9.func_77973_b();
/* 478 */           if (map.containsKey(var10)) {
/* 479 */             map.put(var10, Integer.valueOf(((Integer)map.get(var10)).intValue() + 1)); continue;
/*     */           } 
/* 481 */           map.put(var10, Integer.valueOf(1));
/*     */         } 
/*     */       } 
/*     */     } 
/*     */ 
/*     */     
/* 487 */     return map;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_Lib.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */