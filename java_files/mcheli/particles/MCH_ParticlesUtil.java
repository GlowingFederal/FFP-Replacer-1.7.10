/*     */ package mcheli.particles;
/*     */ 
/*     */ import cpw.mods.fml.client.FMLClientHandler;
/*     */ import mcheli.wrapper.W_Particle;
/*     */ import net.minecraft.block.Block;
/*     */ import net.minecraft.block.material.Material;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.particle.EntityAuraFX;
/*     */ import net.minecraft.client.particle.EntityBreakingFX;
/*     */ import net.minecraft.client.particle.EntityBubbleFX;
/*     */ import net.minecraft.client.particle.EntityCloudFX;
/*     */ import net.minecraft.client.particle.EntityCritFX;
/*     */ import net.minecraft.client.particle.EntityDiggingFX;
/*     */ import net.minecraft.client.particle.EntityDropParticleFX;
/*     */ import net.minecraft.client.particle.EntityEnchantmentTableParticleFX;
/*     */ import net.minecraft.client.particle.EntityExplodeFX;
/*     */ import net.minecraft.client.particle.EntityFX;
/*     */ import net.minecraft.client.particle.EntityFireworkSparkFX;
/*     */ import net.minecraft.client.particle.EntityFishWakeFX;
/*     */ import net.minecraft.client.particle.EntityFlameFX;
/*     */ import net.minecraft.client.particle.EntityFootStepFX;
/*     */ import net.minecraft.client.particle.EntityHeartFX;
/*     */ import net.minecraft.client.particle.EntityHugeExplodeFX;
/*     */ import net.minecraft.client.particle.EntityLargeExplodeFX;
/*     */ import net.minecraft.client.particle.EntityLavaFX;
/*     */ import net.minecraft.client.particle.EntityNoteFX;
/*     */ import net.minecraft.client.particle.EntityPortalFX;
/*     */ import net.minecraft.client.particle.EntityReddustFX;
/*     */ import net.minecraft.client.particle.EntitySmokeFX;
/*     */ import net.minecraft.client.particle.EntitySnowShovelFX;
/*     */ import net.minecraft.client.particle.EntitySpellParticleFX;
/*     */ import net.minecraft.client.particle.EntitySplashFX;
/*     */ import net.minecraft.client.particle.EntitySuspendFX;
/*     */ import net.minecraft.client.renderer.RenderGlobal;
/*     */ import net.minecraft.entity.player.EntityPlayer;
/*     */ import net.minecraft.init.Items;
/*     */ import net.minecraft.item.Item;
/*     */ import net.minecraft.world.World;
/*     */ 
/*     */ public class MCH_ParticlesUtil {
/*     */   public static void spawnParticleExplode(World w, double x, double y, double z, float size, float r, float g, float b, float a, int age) {
/*  42 */     MCH_EntityParticleExplode epe = new MCH_EntityParticleExplode(w, x, y, z, size, age, 0.0D);
/*  43 */     epe.setParticleMaxAge(age);
/*  44 */     epe.func_70538_b(r, g, b);
/*  45 */     epe.func_82338_g(a);
/*  46 */     (FMLClientHandler.instance().getClient()).field_71452_i.func_78873_a((EntityFX)epe);
/*     */   }
/*     */   
/*     */   public static void spawnParticleTileCrack(World w, int blockX, int blockY, int blockZ, double x, double y, double z, double mx, double my, double mz) {
/*  50 */     String name = W_Particle.getParticleTileCrackName(w, blockX, blockY, blockZ);
/*  51 */     if (!name.isEmpty())
/*  52 */       DEF_spawnParticle(name, x, y, z, mx, my, mz, 20.0F); 
/*     */   }
/*     */   
/*     */   public static boolean spawnParticleTileDust(World w, int blockX, int blockY, int blockZ, double x, double y, double z, double mx, double my, double mz, float scale) {
/*  56 */     boolean ret = false;
/*  57 */     int[][] offset = { { 0, 0, 0 }, { 0, 0, -1 }, { 0, 0, 1 }, { 1, 0, 0 }, { -1, 0, 0 } };
/*  58 */     int len = offset.length;
/*  59 */     for (int i = 0; i < len; i++) {
/*  60 */       String name = W_Particle.getParticleTileDustName(w, blockX + offset[i][0], blockY + offset[i][1], blockZ + offset[i][2]);
/*  61 */       if (!name.isEmpty()) {
/*  62 */         EntityFX e = DEF_spawnParticle(name, x, y, z, mx, my, mz, 20.0F);
/*  63 */         if (e instanceof MCH_EntityBlockDustFX) {
/*  64 */           ((MCH_EntityBlockDustFX)e).setScale(scale * 2.0F);
/*  65 */           ret = true;
/*     */           break;
/*     */         } 
/*     */       } 
/*     */     } 
/*  70 */     return ret;
/*     */   }
/*     */   
/*     */   public static EntityFX DEF_spawnParticle(String s, double x, double y, double z, double mx, double my, double mz, float dist) {
/*  74 */     EntityFX e = doSpawnParticle(s, x, y, z, mx, my, mz);
/*  75 */     if (e != null)
/*  76 */       e.field_70155_l *= dist; 
/*  77 */     return e;
/*     */   }
/*     */   
/*     */   public static EntityFX doSpawnParticle(String p_72726_1_, double p_72726_2_, double p_72726_4_, double p_72726_6_, double p_72726_8_, double p_72726_10_, double p_72726_12_) {
/*  81 */     Minecraft mc = Minecraft.func_71410_x();
/*  82 */     RenderGlobal renderGlobal = mc.field_71438_f;
/*  83 */     if (mc != null && mc.field_71451_h != null && mc.field_71452_i != null) {
/*  84 */       EntityFireworkSparkFX entityFireworkSparkFX = null;
/*  85 */       EntityDiggingFX entityDiggingFX = null;
/*  86 */       int i = mc.field_71474_y.field_74362_aa;
/*  87 */       if (i == 1 && mc.field_71441_e.field_73012_v.nextInt(3) == 0)
/*  88 */         i = 2; 
/*  89 */       double d6 = mc.field_71451_h.field_70165_t - p_72726_2_;
/*  90 */       double d7 = mc.field_71451_h.field_70163_u - p_72726_4_;
/*  91 */       double d8 = mc.field_71451_h.field_70161_v - p_72726_6_;
/*  92 */       EntityFX entityfx = null;
/*  93 */       if (p_72726_1_.equalsIgnoreCase("hugeexplosion")) {
/*     */         EntityHugeExplodeFX entityHugeExplodeFX;
/*  95 */         mc.field_71452_i.func_78873_a((EntityFX)(entityHugeExplodeFX = new EntityHugeExplodeFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_)));
/*  96 */       } else if (p_72726_1_.equalsIgnoreCase("largeexplode")) {
/*     */         EntityLargeExplodeFX entityLargeExplodeFX;
/*  98 */         mc.field_71452_i.func_78873_a((EntityFX)(entityLargeExplodeFX = new EntityLargeExplodeFX(mc.field_71446_o, (World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_)));
/*  99 */       } else if (p_72726_1_.equalsIgnoreCase("fireworksSpark")) {
/* 100 */         mc.field_71452_i.func_78873_a((EntityFX)(entityFireworkSparkFX = new EntityFireworkSparkFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, mc.field_71452_i)));
/*     */       } 
/* 102 */       if (entityFireworkSparkFX != null)
/* 103 */         return (EntityFX)entityFireworkSparkFX; 
/* 104 */       double d9 = 300.0D;
/* 105 */       if (d6 * d6 + d7 * d7 + d8 * d8 > d9 * d9)
/* 106 */         return null; 
/* 107 */       if (i > 1)
/* 108 */         return null; 
/* 109 */       if (p_72726_1_.equalsIgnoreCase("bubble")) {
/* 110 */         EntityBubbleFX entityBubbleFX = new EntityBubbleFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 111 */       } else if (p_72726_1_.equalsIgnoreCase("suspended")) {
/* 112 */         EntitySuspendFX entitySuspendFX = new EntitySuspendFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 113 */       } else if (p_72726_1_.equalsIgnoreCase("depthsuspend")) {
/* 114 */         EntityAuraFX entityAuraFX = new EntityAuraFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 115 */       } else if (p_72726_1_.equalsIgnoreCase("townaura")) {
/* 116 */         EntityAuraFX entityAuraFX = new EntityAuraFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 117 */       } else if (p_72726_1_.equalsIgnoreCase("crit")) {
/* 118 */         EntityCritFX entityCritFX = new EntityCritFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 119 */       } else if (p_72726_1_.equalsIgnoreCase("magicCrit")) {
/* 120 */         EntityCritFX entityCritFX = new EntityCritFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 121 */         entityCritFX.func_70538_b(entityCritFX.func_70534_d() * 0.3F, entityCritFX.func_70542_f() * 0.8F, entityCritFX.func_70535_g());
/* 122 */         entityCritFX.func_94053_h();
/* 123 */       } else if (p_72726_1_.equalsIgnoreCase("smoke")) {
/* 124 */         EntitySmokeFX entitySmokeFX = new EntitySmokeFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 125 */       } else if (p_72726_1_.equalsIgnoreCase("mobSpell")) {
/* 126 */         EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
/* 127 */         entitySpellParticleFX.func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
/* 128 */       } else if (p_72726_1_.equalsIgnoreCase("mobSpellAmbient")) {
/* 129 */         EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, 0.0D, 0.0D, 0.0D);
/* 130 */         entitySpellParticleFX.func_82338_g(0.15F);
/* 131 */         entitySpellParticleFX.func_70538_b((float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
/* 132 */       } else if (p_72726_1_.equalsIgnoreCase("spell")) {
/* 133 */         EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 134 */       } else if (p_72726_1_.equalsIgnoreCase("instantSpell")) {
/* 135 */         EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 136 */         entitySpellParticleFX.func_70589_b(144);
/* 137 */       } else if (p_72726_1_.equalsIgnoreCase("witchMagic")) {
/* 138 */         EntitySpellParticleFX entitySpellParticleFX = new EntitySpellParticleFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 139 */         entitySpellParticleFX.func_70589_b(144);
/* 140 */         float f = mc.field_71441_e.field_73012_v.nextFloat() * 0.5F + 0.35F;
/* 141 */         entitySpellParticleFX.func_70538_b(1.0F * f, 0.0F * f, 1.0F * f);
/* 142 */       } else if (p_72726_1_.equalsIgnoreCase("note")) {
/* 143 */         EntityNoteFX entityNoteFX = new EntityNoteFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 144 */       } else if (p_72726_1_.equalsIgnoreCase("portal")) {
/* 145 */         EntityPortalFX entityPortalFX = new EntityPortalFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 146 */       } else if (p_72726_1_.equalsIgnoreCase("enchantmenttable")) {
/* 147 */         EntityEnchantmentTableParticleFX entityEnchantmentTableParticleFX = new EntityEnchantmentTableParticleFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 148 */       } else if (p_72726_1_.equalsIgnoreCase("explode")) {
/* 149 */         EntityExplodeFX entityExplodeFX = new EntityExplodeFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 150 */       } else if (p_72726_1_.equalsIgnoreCase("flame")) {
/* 151 */         EntityFlameFX entityFlameFX = new EntityFlameFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 152 */       } else if (p_72726_1_.equalsIgnoreCase("lava")) {
/* 153 */         EntityLavaFX entityLavaFX = new EntityLavaFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_);
/* 154 */       } else if (p_72726_1_.equalsIgnoreCase("footstep")) {
/* 155 */         EntityFootStepFX entityFootStepFX = new EntityFootStepFX(mc.field_71446_o, (World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_);
/* 156 */       } else if (p_72726_1_.equalsIgnoreCase("splash")) {
/* 157 */         EntitySplashFX entitySplashFX = new EntitySplashFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 158 */       } else if (p_72726_1_.equalsIgnoreCase("wake")) {
/* 159 */         EntityFishWakeFX entityFishWakeFX = new EntityFishWakeFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 160 */       } else if (p_72726_1_.equalsIgnoreCase("largesmoke")) {
/* 161 */         EntitySmokeFX entitySmokeFX = new EntitySmokeFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, 2.5F);
/* 162 */       } else if (p_72726_1_.equalsIgnoreCase("cloud")) {
/* 163 */         EntityCloudFX entityCloudFX = new EntityCloudFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 164 */       } else if (p_72726_1_.equalsIgnoreCase("reddust")) {
/* 165 */         EntityReddustFX entityReddustFX = new EntityReddustFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, (float)p_72726_8_, (float)p_72726_10_, (float)p_72726_12_);
/* 166 */       } else if (p_72726_1_.equalsIgnoreCase("snowballpoof")) {
/* 167 */         EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, Items.field_151126_ay);
/* 168 */       } else if (p_72726_1_.equalsIgnoreCase("dripWater")) {
/* 169 */         EntityDropParticleFX entityDropParticleFX = new EntityDropParticleFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_151586_h);
/* 170 */       } else if (p_72726_1_.equalsIgnoreCase("dripLava")) {
/* 171 */         EntityDropParticleFX entityDropParticleFX = new EntityDropParticleFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, Material.field_151587_i);
/* 172 */       } else if (p_72726_1_.equalsIgnoreCase("snowshovel")) {
/* 173 */         EntitySnowShovelFX entitySnowShovelFX = new EntitySnowShovelFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 174 */       } else if (p_72726_1_.equalsIgnoreCase("slime")) {
/* 175 */         EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, Items.field_151123_aH);
/* 176 */       } else if (p_72726_1_.equalsIgnoreCase("heart")) {
/* 177 */         EntityHeartFX entityHeartFX = new EntityHeartFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 178 */       } else if (p_72726_1_.equalsIgnoreCase("angryVillager")) {
/* 179 */         EntityHeartFX entityHeartFX = new EntityHeartFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_ + 0.5D, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 180 */         entityHeartFX.func_70536_a(81);
/* 181 */         entityHeartFX.func_70538_b(1.0F, 1.0F, 1.0F);
/* 182 */       } else if (p_72726_1_.equalsIgnoreCase("happyVillager")) {
/* 183 */         EntityAuraFX entityAuraFX = new EntityAuraFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_);
/* 184 */         entityAuraFX.func_70536_a(82);
/* 185 */         entityAuraFX.func_70538_b(1.0F, 1.0F, 1.0F);
/* 186 */       } else if (p_72726_1_.startsWith("iconcrack_")) {
/* 187 */         String[] astring = p_72726_1_.split("_", 3);
/* 188 */         int j = Integer.parseInt(astring[1]);
/* 189 */         if (astring.length > 2) {
/* 190 */           int k = Integer.parseInt(astring[2]);
/* 191 */           EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.func_150899_d(j), k);
/*     */         } else {
/* 193 */           EntityBreakingFX entityBreakingFX = new EntityBreakingFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, Item.func_150899_d(j), 0);
/*     */         } 
/* 195 */       } else if (p_72726_1_.startsWith("blockcrack_")) {
/* 196 */         String[] astring = p_72726_1_.split("_", 3);
/* 197 */         Block block = Block.func_149729_e(Integer.parseInt(astring[1]));
/* 198 */         int k = Integer.parseInt(astring[2]);
/* 199 */         entityDiggingFX = (new EntityDiggingFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, block, k)).func_90019_g(k);
/* 200 */       } else if (p_72726_1_.startsWith("blockdust_")) {
/* 201 */         String[] astring = p_72726_1_.split("_", 3);
/* 202 */         Block block = Block.func_149729_e(Integer.parseInt(astring[1]));
/* 203 */         int k = Integer.parseInt(astring[2]);
/* 204 */         entityDiggingFX = (new MCH_EntityBlockDustFX((World)mc.field_71441_e, p_72726_2_, p_72726_4_, p_72726_6_, p_72726_8_, p_72726_10_, p_72726_12_, block, k)).func_90019_g(k);
/*     */       } 
/* 206 */       if (entityDiggingFX != null)
/* 207 */         mc.field_71452_i.func_78873_a((EntityFX)entityDiggingFX); 
/* 208 */       return (EntityFX)entityDiggingFX;
/*     */     } 
/* 210 */     return null;
/*     */   }
/*     */   
/*     */   public static void spawnParticle(MCH_ParticleParam p) {
/* 214 */     if (p.world.field_72995_K) {
/* 215 */       MCH_EntityParticleBase entityFX = null;
/* 216 */       if (p.name.equalsIgnoreCase("Splash")) {
/* 217 */         entityFX = new MCH_EntityParticleSplash(p.world, p.posX, p.posY, p.posZ, p.motionX, p.motionY, p.motionZ);
/*     */       } else {
/* 219 */         entityFX = new MCH_EntityParticleSmoke(p.world, p.posX, p.posY, p.posZ, p.motionX, p.motionY, p.motionZ);
/*     */       } 
/* 221 */       entityFX.func_70538_b(p.r, p.g, p.b);
/* 222 */       entityFX.func_82338_g(p.a);
/* 223 */       if (p.age > 0)
/* 224 */         entityFX.setParticleMaxAge(p.age); 
/* 225 */       entityFX.moutionYUpAge = p.motionYUpAge;
/* 226 */       entityFX.gravity = p.gravity;
/* 227 */       entityFX.isEffectedWind = p.isEffectWind;
/* 228 */       entityFX.diffusible = p.diffusible;
/* 229 */       entityFX.toWhite = p.toWhite;
/* 230 */       if (p.diffusible) {
/* 231 */         entityFX.setParticleScale(p.size * 0.2F);
/* 232 */         entityFX.particleMaxScale = p.size * 2.0F;
/*     */       } else {
/* 234 */         entityFX.setParticleScale(p.size);
/*     */       } 
/* 236 */       (FMLClientHandler.instance().getClient()).field_71452_i.func_78873_a((EntityFX)entityFX);
/*     */     } 
/*     */   }
/*     */   
/* 240 */   public static MCH_EntityParticleMarkPoint markPoint = null;
/*     */   
/*     */   public static void spawnMarkPoint(EntityPlayer player, double x, double y, double z) {
/* 243 */     clearMarkPoint();
/* 244 */     markPoint = new MCH_EntityParticleMarkPoint(player.field_70170_p, x, y, z, player.func_96124_cp());
/* 245 */     (FMLClientHandler.instance().getClient()).field_71452_i.func_78873_a((EntityFX)markPoint);
/*     */   }
/*     */   
/*     */   public static void clearMarkPoint() {
/* 249 */     if (markPoint != null) {
/* 250 */       markPoint.func_70106_y();
/* 251 */       markPoint = null;
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\particles\MCH_ParticlesUtil.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */