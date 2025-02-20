/*      */ package mcheli.aircraft;
/*      */ import java.util.Iterator;
/*      */ import mcheli.MCH_ClientCommonTickHandler;
/*      */ import mcheli.MCH_ClientEventHook;
/*      */ import mcheli.MCH_Config;
/*      */ import mcheli.MCH_Lib;
/*      */ import mcheli.MCH_MOD;
/*      */ import mcheli.gui.MCH_Gui;
/*      */ import mcheli.multiplay.MCH_GuiTargetMarker;
/*      */ import mcheli.weapon.MCH_WeaponGuidanceSystem;
/*      */ import mcheli.weapon.MCH_WeaponSet;
/*      */ import mcheli.wrapper.W_Entity;
/*      */ import mcheli.wrapper.W_Lib;
/*      */ import mcheli.wrapper.W_MOD;
/*      */ import mcheli.wrapper.W_Render;
/*      */ import mcheli.wrapper.modelloader.W_ModelCustom;
/*      */ import net.minecraft.client.Minecraft;
/*      */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*      */ import net.minecraft.client.gui.FontRenderer;
/*      */ import net.minecraft.client.renderer.OpenGlHelper;
/*      */ import net.minecraft.client.renderer.RenderHelper;
/*      */ import net.minecraft.client.renderer.Tessellator;
/*      */ import net.minecraft.client.renderer.entity.RenderManager;
/*      */ import net.minecraft.client.renderer.texture.TextureMap;
/*      */ import net.minecraft.entity.Entity;
/*      */ import net.minecraft.entity.EntityLivingBase;
/*      */ import net.minecraft.init.Blocks;
/*      */ import net.minecraft.util.IIcon;
/*      */ import net.minecraft.util.MathHelper;
/*      */ import net.minecraft.util.ResourceLocation;
/*      */ import net.minecraftforge.client.model.IModelCustom;
/*      */ import org.lwjgl.opengl.GL11;
/*      */ 
/*      */ public abstract class MCH_RenderAircraft extends W_Render {
/*   35 */   public static IModelCustom debugModel = null;
/*      */   public static boolean renderingEntity = false;
/*      */   
/*      */   public void func_76986_a(Entity entity, double posX, double posY, double posZ, float par8, float tickTime) {
/*   39 */     MCH_EntityAircraft ac = (MCH_EntityAircraft)entity;
/*   40 */     MCH_AircraftInfo info = ac.getAcInfo();
/*   41 */     if (info != null) {
/*   42 */       GL11.glPushMatrix();
/*   43 */       float yaw = calcRot(ac.getRotYaw(), ac.field_70126_B, tickTime);
/*   44 */       float pitch = ac.calcRotPitch(tickTime);
/*   45 */       float roll = calcRot(ac.getRotRoll(), ac.prevRotationRoll, tickTime);
/*   46 */       MCH_Config var10000 = MCH_MOD.config;
/*   47 */       if (MCH_Config.EnableModEntityRender.prmBool) {
/*   48 */         renderRiddenEntity(ac, tickTime, yaw, pitch + info.entityPitch, roll + info.entityRoll, info.entityWidth, info.entityHeight);
/*      */       }
/*      */       
/*   51 */       if (!shouldSkipRender(entity)) {
/*   52 */         setCommonRenderParam(info.smoothShading, ac.func_70070_b(tickTime));
/*   53 */         if (ac.isDestroyed()) {
/*   54 */           GL11.glColor4f(0.45F, 0.45F, 0.45F, 1.0F);
/*      */         } else {
/*   56 */           GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);
/*      */         } 
/*      */         
/*   59 */         renderAircraft(ac, posX, posY, posZ, yaw, pitch, roll, tickTime);
/*   60 */         renderCommonPart(ac, info, posX, posY, posZ, tickTime);
/*   61 */         renderLight(posX, posY, posZ, tickTime, ac, info);
/*   62 */         restoreCommonRenderParam();
/*      */       } 
/*      */       
/*   65 */       GL11.glPopMatrix();
/*   66 */       MCH_GuiTargetMarker.addMarkEntityPos(1, entity, posX, posY + info.markerHeight, posZ);
/*   67 */       MCH_ClientLightWeaponTickHandler.markEntity(entity, posX, posY, posZ);
/*   68 */       renderEntityMarker((Entity)ac);
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static boolean shouldSkipRender(Entity entity) {
/*   74 */     if (entity instanceof MCH_IEntityCanRideAircraft) {
/*   75 */       MCH_IEntityCanRideAircraft e = (MCH_IEntityCanRideAircraft)entity;
/*   76 */       if (e.isSkipNormalRender()) {
/*   77 */         return !renderingEntity;
/*      */       }
/*   79 */     } else if ((entity.getClass().toString().indexOf("flansmod.common.driveables.EntityPlane") > 0 || entity.getClass().toString().indexOf("flansmod.common.driveables.EntityVehicle") > 0) && entity.field_70154_o instanceof MCH_EntitySeat) {
/*   80 */       return !renderingEntity;
/*      */     } 
/*      */     
/*   83 */     return false;
/*      */   }
/*      */   
/*      */   public void func_76979_b(Entity entity, double p_76979_2_, double p_76979_4_, double p_76979_6_, float p_76979_8_, float p_76979_9_) {
/*   87 */     if (entity.func_90999_ad()) {
/*   88 */       renderEntityOnFire(entity, p_76979_2_, p_76979_4_, p_76979_6_, p_76979_9_);
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   private void renderEntityOnFire(Entity entity, double x, double y, double z, float tick) {
/*   94 */     GL11.glDisable(2896);
/*   95 */     IIcon iicon = Blocks.field_150480_ab.func_149840_c(0);
/*   96 */     IIcon iicon1 = Blocks.field_150480_ab.func_149840_c(1);
/*   97 */     GL11.glPushMatrix();
/*   98 */     GL11.glTranslatef((float)x, (float)y, (float)z);
/*   99 */     float f1 = entity.field_70130_N * 1.4F;
/*  100 */     GL11.glScalef(f1 * 2.0F, f1 * 2.0F, f1 * 2.0F);
/*  101 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  102 */     float f2 = 1.5F;
/*  103 */     float f3 = 0.0F;
/*  104 */     float f4 = entity.field_70131_O / f1;
/*  105 */     float f5 = (float)(entity.field_70163_u + entity.field_70121_D.field_72338_b);
/*  106 */     GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/*  107 */     GL11.glTranslatef(0.0F, 0.0F, -0.3F + (int)f4 * 0.02F);
/*  108 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  109 */     float f6 = 0.0F;
/*  110 */     int i = 0;
/*  111 */     tessellator.func_78382_b();
/*      */     
/*  113 */     while (f4 > 0.0F) {
/*  114 */       IIcon iicon2 = (i % 2 == 0) ? iicon : iicon1;
/*  115 */       func_110776_a(TextureMap.field_110575_b);
/*  116 */       float f7 = iicon2.func_94209_e();
/*  117 */       float f8 = iicon2.func_94206_g();
/*  118 */       float f9 = iicon2.func_94212_f();
/*  119 */       float f10 = iicon2.func_94210_h();
/*  120 */       if (i / 2 % 2 == 0) {
/*  121 */         float f11 = f9;
/*  122 */         f9 = f7;
/*  123 */         f7 = f11;
/*      */       } 
/*      */       
/*  126 */       tessellator.func_78374_a((f2 - f3), (0.0F - f5), f6, f9, f10);
/*  127 */       tessellator.func_78374_a((-f2 - f3), (0.0F - f5), f6, f7, f10);
/*  128 */       tessellator.func_78374_a((-f2 - f3), (1.4F - f5), f6, f7, f8);
/*  129 */       tessellator.func_78374_a((f2 - f3), (1.4F - f5), f6, f9, f8);
/*  130 */       f4 -= 0.45F;
/*  131 */       f5 -= 0.45F;
/*  132 */       f2 *= 0.9F;
/*  133 */       f6 += 0.03F;
/*  134 */       i++;
/*      */     } 
/*      */     
/*  137 */     tessellator.func_78381_a();
/*  138 */     GL11.glPopMatrix();
/*  139 */     GL11.glEnable(2896);
/*      */   }
/*      */   
/*      */   public static void renderLight(double x, double y, double z, float tickTime, MCH_EntityAircraft ac, MCH_AircraftInfo info) {
/*  143 */     if (ac.haveSearchLight() && 
/*  144 */       ac.isSearchLightON()) {
/*  145 */       Entity entity = ac.getEntityBySeatId(1);
/*  146 */       if (entity != null) {
/*  147 */         ac.lastSearchLightYaw = entity.field_70177_z;
/*  148 */         ac.lastSearchLightPitch = entity.field_70125_A;
/*      */       } else {
/*  150 */         entity = ac.getEntityBySeatId(0);
/*  151 */         if (entity != null) {
/*  152 */           ac.lastSearchLightYaw = entity.field_70177_z;
/*  153 */           ac.lastSearchLightPitch = entity.field_70125_A;
/*      */         } 
/*      */       } 
/*      */       
/*  157 */       float yaw = ac.lastSearchLightYaw;
/*  158 */       float pitch = ac.lastSearchLightPitch;
/*  159 */       RenderHelper.func_74518_a();
/*  160 */       GL11.glDisable(3553);
/*  161 */       GL11.glShadeModel(7425);
/*  162 */       GL11.glEnable(3042);
/*  163 */       GL11.glBlendFunc(770, 1);
/*  164 */       GL11.glDisable(3008);
/*  165 */       GL11.glDisable(2884);
/*  166 */       GL11.glDepthMask(false);
/*  167 */       float rot = ac.prevRotYawWheel + (ac.rotYawWheel - ac.prevRotYawWheel) * tickTime;
/*  168 */       Iterator<MCH_AircraftInfo.SearchLight> i$ = info.searchLights.iterator();
/*      */       
/*  170 */       while (i$.hasNext()) {
/*  171 */         MCH_AircraftInfo.SearchLight sl = i$.next();
/*  172 */         GL11.glPushMatrix();
/*  173 */         GL11.glTranslated(sl.pos.field_72450_a, sl.pos.field_72448_b, sl.pos.field_72449_c);
/*      */         
/*  175 */         if (!sl.fixDir) {
/*  176 */           GL11.glRotatef(yaw - ac.getRotYaw() + sl.yaw, 0.0F, -1.0F, 0.0F);
/*  177 */           GL11.glRotatef(pitch + 90.0F - ac.getRotPitch() + sl.pitch, 1.0F, 0.0F, 0.0F);
/*      */         } else {
/*  179 */           float f = 0.0F;
/*  180 */           if (sl.steering) {
/*  181 */             f = -rot * sl.stRot;
/*      */           }
/*      */           
/*  184 */           GL11.glRotatef(0.0F + sl.yaw + f, 0.0F, -1.0F, 0.0F);
/*  185 */           GL11.glRotatef(90.0F + sl.pitch, 1.0F, 0.0F, 0.0F);
/*      */         } 
/*      */         
/*  188 */         float height = sl.height;
/*  189 */         float width = sl.width / 2.0F;
/*  190 */         Tessellator tessellator = Tessellator.field_78398_a;
/*  191 */         tessellator.func_78371_b(6);
/*  192 */         tessellator.func_78384_a(0xFFFFFF & sl.colorStart, sl.colorStart >> 24 & 0xFF);
/*  193 */         tessellator.func_78377_a(0.0D, 0.0D, 0.0D);
/*  194 */         tessellator.func_78384_a(0xFFFFFF & sl.colorEnd, sl.colorEnd >> 24 & 0xFF);
/*  195 */         boolean VNUM = true;
/*      */         
/*  197 */         for (int i = 0; i < 25; i++) {
/*  198 */           float angle = (float)(15.0D * i / 180.0D * Math.PI);
/*  199 */           tessellator.func_78377_a((MathHelper.func_76126_a(angle) * width), height, (MathHelper.func_76134_b(angle) * width));
/*      */         } 
/*      */         
/*  202 */         tessellator.func_78381_a();
/*  203 */         GL11.glPopMatrix();
/*      */       } 
/*      */       
/*  206 */       GL11.glDepthMask(true);
/*  207 */       GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  208 */       GL11.glEnable(3553);
/*  209 */       GL11.glEnable(3008);
/*  210 */       GL11.glBlendFunc(770, 771);
/*  211 */       RenderHelper.func_74519_b();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   protected void bindTexture(String path, MCH_EntityAircraft ac) {
/*  217 */     if (ac == MCH_ClientCommonTickHandler.ridingAircraft) {
/*  218 */       int bk = MCH_ClientCommonTickHandler.cameraMode;
/*  219 */       MCH_ClientCommonTickHandler.cameraMode = 0;
/*  220 */       func_110776_a(new ResourceLocation(W_MOD.DOMAIN, path));
/*  221 */       MCH_ClientCommonTickHandler.cameraMode = bk;
/*      */     } else {
/*  223 */       func_110776_a(new ResourceLocation(W_MOD.DOMAIN, path));
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void renderRiddenEntity(MCH_EntityAircraft ac, float tickTime, float yaw, float pitch, float roll, float width, float height) {
/*  229 */     MCH_ClientEventHook.setCancelRender(false);
/*  230 */     GL11.glPushMatrix();
/*  231 */     renderEntitySimple(ac, ac.field_70153_n, tickTime, yaw, pitch, roll, width, height);
/*  232 */     MCH_EntitySeat[] arr$ = ac.getSeats();
/*  233 */     int len$ = arr$.length;
/*      */     
/*  235 */     for (int i$ = 0; i$ < len$; i$++) {
/*  236 */       MCH_EntitySeat s = arr$[i$];
/*  237 */       if (s != null) {
/*  238 */         renderEntitySimple(ac, s.field_70153_n, tickTime, yaw, pitch, roll, width, height);
/*      */       }
/*      */     } 
/*      */     
/*  242 */     GL11.glPopMatrix();
/*  243 */     MCH_ClientEventHook.setCancelRender(true);
/*      */   }
/*      */   
/*      */   public void renderEntitySimple(MCH_EntityAircraft ac, Entity entity, float tickTime, float yaw, float pitch, float roll, float width, float height) {
/*  247 */     if (entity != null) {
/*  248 */       boolean isPilot = ac.isPilot(entity);
/*  249 */       boolean isClientPlayer = W_Lib.isClientPlayer(entity);
/*  250 */       if (!isClientPlayer || !W_Lib.isFirstPerson() || (isClientPlayer && isPilot && ac.getCameraId() > 0)) {
/*  251 */         GL11.glPushMatrix();
/*  252 */         if (entity.field_70173_aa == 0) {
/*  253 */           entity.field_70142_S = entity.field_70165_t;
/*  254 */           entity.field_70137_T = entity.field_70163_u;
/*  255 */           entity.field_70136_U = entity.field_70161_v;
/*      */         } 
/*      */         
/*  258 */         double x = entity.field_70142_S + (entity.field_70165_t - entity.field_70142_S) * tickTime;
/*  259 */         double y = entity.field_70137_T + (entity.field_70163_u - entity.field_70137_T) * tickTime;
/*  260 */         double z = entity.field_70136_U + (entity.field_70161_v - entity.field_70136_U) * tickTime;
/*  261 */         float f1 = entity.field_70126_B + (entity.field_70177_z - entity.field_70126_B) * tickTime;
/*  262 */         int i = entity.func_70070_b(tickTime);
/*  263 */         if (entity.func_70027_ad()) {
/*  264 */           i = 15728880;
/*      */         }
/*      */         
/*  267 */         int j = i % 65536;
/*  268 */         int k = i / 65536;
/*  269 */         OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, j / 1.0F, k / 1.0F);
/*  270 */         GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  271 */         RenderManager var10001 = this.field_76990_c;
/*  272 */         double dx = x - RenderManager.field_78725_b;
/*  273 */         var10001 = this.field_76990_c;
/*  274 */         double dy = y - RenderManager.field_78726_c;
/*  275 */         var10001 = this.field_76990_c;
/*  276 */         double dz = z - RenderManager.field_78723_d;
/*  277 */         GL11.glTranslated(dx, dy, dz);
/*  278 */         GL11.glRotatef(yaw, 0.0F, -1.0F, 0.0F);
/*  279 */         GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/*  280 */         GL11.glRotatef(roll, 0.0F, 0.0F, 1.0F);
/*  281 */         GL11.glScaled(width, height, width);
/*  282 */         GL11.glRotatef(-yaw, 0.0F, -1.0F, 0.0F);
/*  283 */         GL11.glTranslated(-dx, -dy, -dz);
/*  284 */         boolean bk = renderingEntity;
/*  285 */         renderingEntity = true;
/*  286 */         Entity ridingEntity = entity.field_70154_o;
/*  287 */         if (!W_Lib.isEntityLivingBase(entity) && !(entity instanceof MCH_IEntityCanRideAircraft)) {
/*  288 */           entity.field_70154_o = null;
/*      */         }
/*      */         
/*  291 */         EntityLivingBase entityLiving = (entity instanceof EntityLivingBase) ? (EntityLivingBase)entity : null;
/*  292 */         float bkYaw = 0.0F;
/*  293 */         float bkPrevYaw = 0.0F;
/*  294 */         float bkPitch = 0.0F;
/*  295 */         float bkPrevPitch = 0.0F;
/*  296 */         if (isPilot && entityLiving != null) {
/*  297 */           entityLiving.field_70761_aq = ac.getRotYaw();
/*  298 */           entityLiving.field_70760_ar = ac.getRotYaw();
/*  299 */           if (ac.getCameraId() > 0) {
/*  300 */             entityLiving.field_70759_as = ac.getRotYaw();
/*  301 */             entityLiving.field_70758_at = ac.getRotYaw();
/*  302 */             bkPitch = entityLiving.field_70125_A;
/*  303 */             bkPrevPitch = entityLiving.field_70127_C;
/*  304 */             entityLiving.field_70125_A = ac.getRotPitch();
/*  305 */             entityLiving.field_70127_C = ac.getRotPitch();
/*      */           } 
/*      */         } 
/*      */         
/*  309 */         W_EntityRenderer.renderEntityWithPosYaw(this.field_76990_c, entity, dx, dy, dz, f1, tickTime, false);
/*  310 */         if (isPilot && entityLiving != null && ac.getCameraId() > 0) {
/*  311 */           entityLiving.field_70125_A = bkPitch;
/*  312 */           entityLiving.field_70127_C = bkPrevPitch;
/*      */         } 
/*      */         
/*  315 */         entity.field_70154_o = ridingEntity;
/*  316 */         renderingEntity = bk;
/*  317 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void Test_Material(int light, float a, float b, float c) {
/*  324 */     GL11.glMaterial(1032, light, setColorBuffer(a, b, c, 1.0F));
/*      */   }
/*      */   
/*      */   public static void Test_Light(int light, float a, float b, float c) {
/*  328 */     GL11.glLight(16384, light, setColorBuffer(a, b, c, 1.0F));
/*  329 */     GL11.glLight(16385, light, setColorBuffer(a, b, c, 1.0F));
/*      */   }
/*      */   
/*      */   public abstract void renderAircraft(MCH_EntityAircraft paramMCH_EntityAircraft, double paramDouble1, double paramDouble2, double paramDouble3, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);
/*      */   
/*      */   public float calcRot(float rot, float prevRot, float tickTime) {
/*  335 */     rot = MathHelper.func_76142_g(rot);
/*  336 */     prevRot = MathHelper.func_76142_g(prevRot);
/*  337 */     if (rot - prevRot < -180.0F) {
/*  338 */       prevRot -= 360.0F;
/*  339 */     } else if (prevRot - rot < -180.0F) {
/*  340 */       prevRot += 360.0F;
/*      */     } 
/*      */     
/*  343 */     return prevRot + (rot - prevRot) * tickTime;
/*      */   }
/*      */   
/*      */   public void renderDebugHitBox(MCH_EntityAircraft e, double x, double y, double z, float yaw, float pitch) {
/*  347 */     MCH_Config var10000 = MCH_MOD.config;
/*  348 */     if (MCH_Config.TestMode.prmBool && debugModel != null) {
/*  349 */       GL11.glPushMatrix();
/*  350 */       GL11.glTranslated(x, y, z);
/*  351 */       GL11.glScalef(e.field_70130_N, e.field_70131_O, e.field_70130_N);
/*  352 */       bindTexture("textures/hit_box.png");
/*  353 */       debugModel.renderAll();
/*  354 */       GL11.glPopMatrix();
/*  355 */       GL11.glPushMatrix();
/*  356 */       GL11.glTranslated(x, y, z);
/*  357 */       MCH_BoundingBox[] arr$ = e.extraBoundingBox;
/*  358 */       int len$ = arr$.length;
/*      */       
/*  360 */       for (int i$ = 0; i$ < len$; i$++) {
/*  361 */         MCH_BoundingBox bb = arr$[i$];
/*  362 */         GL11.glPushMatrix();
/*  363 */         GL11.glTranslated(bb.rotatedOffset.field_72450_a, bb.rotatedOffset.field_72448_b, bb.rotatedOffset.field_72449_c);
/*  364 */         GL11.glPushMatrix();
/*  365 */         GL11.glScalef(bb.width, bb.height, bb.width);
/*  366 */         bindTexture("textures/bounding_box.png");
/*  367 */         debugModel.renderAll();
/*  368 */         GL11.glPopMatrix();
/*  369 */         drawHitBoxDetail(bb);
/*  370 */         GL11.glPopMatrix();
/*      */       } 
/*      */       
/*  373 */       GL11.glPopMatrix();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public void drawHitBoxDetail(MCH_BoundingBox bb) {
/*  379 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  380 */     float f1 = 0.080000006F;
/*  381 */     String s = String.format("%.2f", new Object[] { Float.valueOf(bb.damegeFactor) });
/*  382 */     GL11.glPushMatrix();
/*  383 */     GL11.glTranslatef(0.0F, 0.5F + (float)(bb.offsetY * 0.0D + bb.height), 0.0F);
/*  384 */     GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/*  385 */     GL11.glRotatef(-this.field_76990_c.field_78735_i, 0.0F, 1.0F, 0.0F);
/*  386 */     GL11.glRotatef(this.field_76990_c.field_78732_j, 1.0F, 0.0F, 0.0F);
/*  387 */     GL11.glScalef(-f1, -f1, f1);
/*  388 */     GL11.glDisable(2896);
/*  389 */     GL11.glEnable(3042);
/*  390 */     OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  391 */     GL11.glDisable(3553);
/*  392 */     FontRenderer fontrenderer = func_76983_a();
/*  393 */     Tessellator tessellator = Tessellator.field_78398_a;
/*  394 */     tessellator.func_78382_b();
/*  395 */     int i = fontrenderer.func_78256_a(s) / 2;
/*  396 */     tessellator.func_78369_a(0.0F, 0.0F, 0.0F, 0.4F);
/*  397 */     tessellator.func_78377_a((-i - 1), -1.0D, 0.1D);
/*  398 */     tessellator.func_78377_a((-i - 1), 8.0D, 0.1D);
/*  399 */     tessellator.func_78377_a((i + 1), 8.0D, 0.1D);
/*  400 */     tessellator.func_78377_a((i + 1), -1.0D, 0.1D);
/*  401 */     tessellator.func_78381_a();
/*  402 */     GL11.glEnable(3553);
/*  403 */     GL11.glDepthMask(false);
/*  404 */     int color = (bb.damegeFactor < 1.0F) ? 65535 : ((bb.damegeFactor > 1.0F) ? 16711680 : 16777215);
/*  405 */     fontrenderer.func_78276_b(s, -fontrenderer.func_78256_a(s) / 2, 0, 0xC0000000 | color);
/*  406 */     GL11.glDepthMask(true);
/*  407 */     GL11.glEnable(2896);
/*  408 */     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  409 */     GL11.glPopMatrix();
/*      */   }
/*      */   
/*      */   public void renderDebugPilotSeat(MCH_EntityAircraft e, double x, double y, double z, float yaw, float pitch, float roll) {
/*  413 */     MCH_Config var10000 = MCH_MOD.config;
/*  414 */     if (MCH_Config.TestMode.prmBool && debugModel != null) {
/*  415 */       GL11.glPushMatrix();
/*  416 */       MCH_SeatInfo seat = e.getSeatInfo(0);
/*  417 */       GL11.glTranslated(x, y, z);
/*  418 */       GL11.glRotatef(yaw, 0.0F, -1.0F, 0.0F);
/*  419 */       GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/*  420 */       GL11.glRotatef(roll, 0.0F, 0.0F, 1.0F);
/*  421 */       GL11.glTranslated(seat.pos.field_72450_a, seat.pos.field_72448_b, seat.pos.field_72449_c);
/*  422 */       GL11.glScalef(1.0F, 1.0F, 1.0F);
/*  423 */       bindTexture("textures/seat_pilot.png");
/*  424 */       debugModel.renderAll();
/*  425 */       GL11.glPopMatrix();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderBody(IModelCustom model) {
/*  431 */     if (model != null) {
/*  432 */       if (model instanceof W_ModelCustom) {
/*  433 */         if (((W_ModelCustom)model).containsPart("$body")) {
/*  434 */           model.renderPart("$body");
/*      */         } else {
/*  436 */           model.renderAll();
/*      */         } 
/*      */       } else {
/*  439 */         model.renderAll();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderPart(IModelCustom model, IModelCustom modelBody, String partName) {
/*  446 */     if (model != null) {
/*  447 */       model.renderAll();
/*  448 */     } else if (modelBody instanceof W_ModelCustom && ((W_ModelCustom)modelBody).containsPart("$" + partName)) {
/*  449 */       modelBody.renderPart("$" + partName);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void renderPartWithOffset(IModelCustom model, IModelCustom modelBody, String partName, float turretOffX, float turretOffY, float turretOffZ) {
/*  454 */     if (model != null) {
/*  455 */       model.renderAll();
/*  456 */     } else if (modelBody instanceof W_ModelCustom && ((W_ModelCustom)modelBody).containsPart("$" + partName)) {
/*  457 */       if (partName.contains("weapon0")) {
/*  458 */         GL11.glPushMatrix();
/*  459 */         GL11.glTranslated(turretOffX, turretOffY, turretOffZ);
/*  460 */         modelBody.renderPart("$" + partName);
/*  461 */         GL11.glPopMatrix();
/*      */       } else {
/*  463 */         modelBody.renderPart("$" + partName);
/*      */       } 
/*      */     } 
/*      */   }
/*      */   
/*      */   public void renderCommonPart(MCH_EntityAircraft ac, MCH_AircraftInfo info, double x, double y, double z, float tickTime) {
/*  469 */     renderRope(ac, info, x, y, z, tickTime);
/*  470 */     renderWeapon(ac, info, tickTime);
/*  471 */     renderRotPart(ac, info, tickTime);
/*  472 */     renderHatch(ac, info, tickTime);
/*  473 */     renderTrackRoller(ac, info, tickTime);
/*  474 */     renderCrawlerTrack(ac, info, tickTime);
/*  475 */     renderSteeringWheel(ac, info, tickTime);
/*  476 */     renderLightHatch(ac, info, tickTime);
/*  477 */     renderWheel(ac, info, tickTime);
/*  478 */     renderThrottle(ac, info, tickTime);
/*  479 */     renderCamera(ac, info, tickTime);
/*  480 */     renderLandingGear(ac, info, tickTime);
/*  481 */     renderWeaponBay(ac, info, tickTime);
/*  482 */     renderCanopy(ac, info, tickTime);
/*      */   }
/*      */   
/*      */   public static void renderLightHatch(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  486 */     if (info.lightHatchList.size() > 0) {
/*  487 */       float rot = ac.prevRotLightHatch + (ac.rotLightHatch - ac.prevRotLightHatch) * tickTime;
/*  488 */       Iterator<MCH_AircraftInfo.Hatch> i$ = info.lightHatchList.iterator();
/*      */       
/*  490 */       while (i$.hasNext()) {
/*  491 */         MCH_AircraftInfo.Hatch t = i$.next();
/*  492 */         GL11.glPushMatrix();
/*  493 */         GL11.glTranslated(t.pos.field_72450_a, t.pos.field_72448_b, t.pos.field_72449_c);
/*  494 */         GL11.glRotated((rot * t.maxRot), t.rot.field_72450_a, t.rot.field_72448_b, t.rot.field_72449_c);
/*  495 */         GL11.glTranslated(-t.pos.field_72450_a, -t.pos.field_72448_b, -t.pos.field_72449_c);
/*  496 */         renderPart(t.model, info.model, t.modelName);
/*  497 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderSteeringWheel(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  504 */     if (info.partSteeringWheel.size() > 0) {
/*  505 */       float rot = ac.prevRotYawWheel + (ac.rotYawWheel - ac.prevRotYawWheel) * tickTime;
/*  506 */       Iterator<MCH_AircraftInfo.PartWheel> i$ = info.partSteeringWheel.iterator();
/*      */       
/*  508 */       while (i$.hasNext()) {
/*  509 */         MCH_AircraftInfo.PartWheel t = i$.next();
/*  510 */         GL11.glPushMatrix();
/*  511 */         GL11.glTranslated(t.pos.field_72450_a, t.pos.field_72448_b, t.pos.field_72449_c);
/*  512 */         GL11.glRotated((rot * t.rotDir), t.rot.field_72450_a, t.rot.field_72448_b, t.rot.field_72449_c);
/*  513 */         GL11.glTranslated(-t.pos.field_72450_a, -t.pos.field_72448_b, -t.pos.field_72449_c);
/*  514 */         renderPart(t.model, info.model, t.modelName);
/*  515 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderWheel(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  522 */     if (info.partWheel.size() > 0) {
/*  523 */       float yaw = ac.prevRotYawWheel + (ac.rotYawWheel - ac.prevRotYawWheel) * tickTime;
/*  524 */       Iterator<MCH_AircraftInfo.PartWheel> i$ = info.partWheel.iterator();
/*      */       
/*  526 */       while (i$.hasNext()) {
/*  527 */         MCH_AircraftInfo.PartWheel t = i$.next();
/*  528 */         GL11.glPushMatrix();
/*  529 */         GL11.glTranslated(t.pos2.field_72450_a, t.pos2.field_72448_b, t.pos2.field_72449_c);
/*  530 */         GL11.glRotated((yaw * t.rotDir), t.rot.field_72450_a, t.rot.field_72448_b, t.rot.field_72449_c);
/*  531 */         GL11.glTranslated(-t.pos2.field_72450_a, -t.pos2.field_72448_b, -t.pos2.field_72449_c);
/*  532 */         GL11.glTranslated(t.pos.field_72450_a, t.pos.field_72448_b, t.pos.field_72449_c);
/*  533 */         GL11.glRotatef(ac.prevRotWheel + (ac.rotWheel - ac.prevRotWheel) * tickTime, 1.0F, 0.0F, 0.0F);
/*  534 */         GL11.glTranslated(-t.pos.field_72450_a, -t.pos.field_72448_b, -t.pos.field_72449_c);
/*  535 */         renderPart(t.model, info.model, t.modelName);
/*  536 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderRotPart(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  543 */     if (ac.haveRotPart()) {
/*  544 */       for (int i = 0; i < ac.rotPartRotation.length; i++) {
/*  545 */         float rot = ac.rotPartRotation[i];
/*  546 */         float prevRot = ac.prevRotPartRotation[i];
/*  547 */         if (prevRot > rot) {
/*  548 */           rot += 360.0F;
/*      */         }
/*      */         
/*  551 */         rot = MCH_Lib.smooth(rot, prevRot, tickTime);
/*  552 */         MCH_AircraftInfo.RotPart h = info.partRotPart.get(i);
/*  553 */         GL11.glPushMatrix();
/*  554 */         GL11.glTranslated(h.pos.field_72450_a, h.pos.field_72448_b, h.pos.field_72449_c);
/*  555 */         GL11.glRotatef(rot, (float)h.rot.field_72450_a, (float)h.rot.field_72448_b, (float)h.rot.field_72449_c);
/*  556 */         GL11.glTranslated(-h.pos.field_72450_a, -h.pos.field_72448_b, -h.pos.field_72449_c);
/*  557 */         renderPart(h.model, info.model, h.modelName);
/*  558 */         GL11.glPopMatrix();
/*      */       } 
/*      */     }
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderWeapon(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  565 */     MCH_WeaponSet beforeWs = null;
/*  566 */     Entity e = ac.getRiddenByEntity();
/*  567 */     int weaponIndex = 0;
/*  568 */     int cnt = 0;
/*  569 */     Iterator<MCH_AircraftInfo.PartWeapon> i$ = info.partWeapon.iterator();
/*      */     
/*  571 */     while (i$.hasNext()) {
/*  572 */       MCH_AircraftInfo.PartWeapon w = i$.next();
/*  573 */       MCH_WeaponSet ws = ac.getWeaponByName(w.name[0]);
/*      */       
/*  575 */       if (ws != null && (ws.getFirstWeapon()).onTurret) {
/*  576 */         boolean var10000 = true;
/*      */       } else {
/*  578 */         boolean var10000 = false;
/*      */       } 
/*      */       
/*  581 */       if (ws != beforeWs) {
/*  582 */         weaponIndex = 0;
/*  583 */         beforeWs = ws;
/*      */       } 
/*      */       
/*  586 */       float rotYaw = 0.0F;
/*  587 */       float prevYaw = 0.0F;
/*  588 */       float rotPitch = 0.0F;
/*  589 */       float prevPitch = 0.0F;
/*      */ 
/*      */       
/*  592 */       if (w.hideGM && W_Lib.isFirstPerson()) {
/*  593 */         if (ws != null) {
/*  594 */           boolean bool = false;
/*  595 */           String[] i$1 = w.name;
/*  596 */           int wc = i$1.length;
/*      */           
/*  598 */           for (int len$ = 0; len$ < wc; len$++) {
/*  599 */             String i$2 = i$1[len$];
/*  600 */             if (W_Lib.isClientPlayer(ac.getWeaponUserByWeaponName(i$2))) {
/*  601 */               bool = true;
/*      */               
/*      */               break;
/*      */             } 
/*      */           } 
/*  606 */           if (bool) {
/*      */             continue;
/*      */           }
/*  609 */         } else if (ac.isMountedEntity(MCH_Lib.getClientPlayer())) {
/*      */           continue;
/*      */         } 
/*      */       }
/*      */       
/*  614 */       GL11.glPushMatrix();
/*      */       
/*  616 */       if (w.turret) {
/*  617 */         GL11.glTranslated(info.turretPosition.field_72450_a, info.turretPosition.field_72448_b, info.turretPosition.field_72449_c);
/*  618 */         float var22 = MCH_Lib.smooth(ac.getLastRiderYaw() - ac.getRotYaw(), ac.prevLastRiderYaw - ac.field_70126_B, tickTime);
/*  619 */         GL11.glRotatef(var22, 0.0F, -1.0F, 0.0F);
/*  620 */         GL11.glTranslated(-info.turretPosition.field_72450_a, -info.turretPosition.field_72448_b, -info.turretPosition.field_72449_c);
/*      */       } 
/*      */       
/*  623 */       GL11.glTranslated(w.pos.field_72450_a, w.pos.field_72448_b, w.pos.field_72449_c);
/*  624 */       if (w.yaw) {
/*  625 */         if (ws != null) {
/*  626 */           rotYaw = ws.rotationYaw - ws.defaultRotationYaw;
/*  627 */           prevYaw = ws.prevRotationYaw - ws.defaultRotationYaw;
/*  628 */         } else if (e != null) {
/*  629 */           rotYaw = e.field_70177_z - ac.getRotYaw();
/*  630 */           prevYaw = e.field_70126_B - ac.field_70126_B;
/*      */         } else {
/*  632 */           rotYaw = ac.getLastRiderYaw() - ac.field_70177_z;
/*  633 */           prevYaw = ac.prevLastRiderYaw - ac.field_70126_B;
/*      */         } 
/*      */         
/*  636 */         if (rotYaw - prevYaw > 180.0F) {
/*  637 */           prevYaw += 360.0F;
/*  638 */         } else if (rotYaw - prevYaw < -180.0F) {
/*  639 */           prevYaw -= 360.0F;
/*      */         } 
/*      */         
/*  642 */         GL11.glRotatef(prevYaw + (rotYaw - prevYaw) * tickTime, 0.0F, -1.0F, 0.0F);
/*      */       } 
/*      */       
/*  645 */       if (w.turret) {
/*  646 */         float var22 = MCH_Lib.smooth(ac.getLastRiderYaw() - ac.getRotYaw(), ac.prevLastRiderYaw - ac.field_70126_B, tickTime);
/*  647 */         var22 -= ws.rotationTurretYaw;
/*  648 */         GL11.glRotatef(-var22, 0.0F, -1.0F, 0.0F);
/*      */       } 
/*      */       
/*  651 */       boolean rev_sign = false;
/*      */       
/*  653 */       if (ws != null && (int)ws.defaultRotationYaw != 0) {
/*  654 */         float var23 = MathHelper.func_76142_g(ws.defaultRotationYaw);
/*  655 */         rev_sign = ((var23 >= 45.0F && var23 <= 135.0F) || (var23 <= -45.0F && var23 >= -135.0F));
/*  656 */         GL11.glRotatef(-ws.defaultRotationYaw, 0.0F, -1.0F, 0.0F);
/*      */       } 
/*      */       
/*  659 */       if (w.pitch) {
/*  660 */         if (ws != null) {
/*  661 */           rotPitch = ws.rotationPitch;
/*  662 */           prevPitch = ws.prevRotationPitch;
/*  663 */         } else if (e != null) {
/*  664 */           rotPitch = e.field_70125_A;
/*  665 */           prevPitch = e.field_70127_C;
/*      */         } else {
/*  667 */           rotPitch = ac.getLastRiderPitch();
/*  668 */           prevPitch = ac.prevLastRiderPitch;
/*      */         } 
/*      */         
/*  671 */         if (rev_sign) {
/*  672 */           rotPitch = -rotPitch;
/*  673 */           prevPitch = -prevPitch;
/*      */         } 
/*      */         
/*  676 */         GL11.glRotatef(prevPitch + (rotPitch - prevPitch) * tickTime, 1.0F, 0.0F, 0.0F);
/*      */       } 
/*      */       
/*  679 */       if (ws != null && w.recoilBuf != 0.0F) {
/*  680 */         MCH_WeaponSet.Recoil var24 = ws.recoilBuf[0];
/*  681 */         if (w.name.length > 1) {
/*  682 */           String[] var25 = w.name;
/*  683 */           int len$ = var25.length;
/*      */           
/*  685 */           for (int var29 = 0; var29 < len$; var29++) {
/*  686 */             String wnm = var25[var29];
/*  687 */             MCH_WeaponSet tws = ac.getWeaponByName(wnm);
/*  688 */             if (tws != null && (tws.recoilBuf[0]).recoilBuf > var24.recoilBuf) {
/*  689 */               var24 = tws.recoilBuf[0];
/*      */             }
/*      */           } 
/*      */         } 
/*      */         
/*  694 */         float var26 = var24.prevRecoilBuf + (var24.recoilBuf - var24.prevRecoilBuf) * tickTime;
/*  695 */         GL11.glTranslated(0.0D, 0.0D, (w.recoilBuf * var26));
/*      */       } 
/*      */       
/*  698 */       if (ws != null) {
/*  699 */         GL11.glRotatef(ws.defaultRotationYaw, 0.0F, -1.0F, 0.0F);
/*  700 */         if (w.rotBarrel) {
/*  701 */           float var23 = ws.prevRotBarrel + (ws.rotBarrel - ws.prevRotBarrel) * tickTime;
/*  702 */           GL11.glRotatef(var23, (float)w.rot.field_72450_a, (float)w.rot.field_72448_b, (float)w.rot.field_72449_c);
/*      */         } 
/*      */       } 
/*      */       
/*  706 */       boolean doRender = false;
/*  707 */       if (ws != null) {
/*  708 */         GL11.glTranslated(-w.pos.field_72450_a, -w.pos.field_72448_b, -w.pos.field_72449_c);
/*  709 */         if (!w.isMissile) {
/*      */ 
/*      */           
/*  712 */           renderPartWithOffset(w.model, info.model, w.modelName, ac.turretOffX, ac.turretOffY, ac.turretOffZ);
/*  713 */           Iterator<MCH_AircraftInfo.PartWeaponChild> var27 = w.child.iterator();
/*      */           
/*  715 */           while (var27.hasNext()) {
/*  716 */             MCH_AircraftInfo.PartWeaponChild var28 = var27.next();
/*  717 */             GL11.glPushMatrix();
/*  718 */             renderWeaponChild(ac, info, var28, ws, e, tickTime);
/*  719 */             GL11.glPopMatrix();
/*      */           } 
/*      */         } 
/*      */       } 
/*      */       
/*  724 */       GL11.glPopMatrix();
/*  725 */       weaponIndex++;
/*  726 */       cnt++;
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void renderWeaponChild(MCH_EntityAircraft ac, MCH_AircraftInfo info, MCH_AircraftInfo.PartWeaponChild w, MCH_WeaponSet ws, Entity e, float tickTime) {
/*  731 */     float rotYaw = 0.0F;
/*  732 */     float prevYaw = 0.0F;
/*  733 */     float rotPitch = 0.0F;
/*  734 */     float prevPitch = 0.0F;
/*  735 */     GL11.glTranslated(w.pos.field_72450_a, w.pos.field_72448_b, w.pos.field_72449_c);
/*  736 */     if (w.yaw) {
/*  737 */       if (ws != null) {
/*  738 */         rotYaw = ws.rotationYaw - ws.defaultRotationYaw;
/*  739 */         prevYaw = ws.prevRotationYaw - ws.defaultRotationYaw;
/*  740 */       } else if (e != null) {
/*  741 */         rotYaw = e.field_70177_z - ac.getRotYaw();
/*  742 */         prevYaw = e.field_70126_B - ac.field_70126_B;
/*      */       } else {
/*  744 */         rotYaw = ac.getLastRiderYaw() - ac.field_70177_z;
/*  745 */         prevYaw = ac.prevLastRiderYaw - ac.field_70126_B;
/*      */       } 
/*      */       
/*  748 */       if (rotYaw - prevYaw > 180.0F) {
/*  749 */         prevYaw += 360.0F;
/*  750 */       } else if (rotYaw - prevYaw < -180.0F) {
/*  751 */         prevYaw -= 360.0F;
/*      */       } 
/*      */       
/*  754 */       GL11.glRotatef(prevYaw + (rotYaw - prevYaw) * tickTime, 0.0F, -1.0F, 0.0F);
/*      */     } 
/*      */     
/*  757 */     boolean rev_sign = false;
/*  758 */     if (ws != null && (int)ws.defaultRotationYaw != 0) {
/*  759 */       float r = MathHelper.func_76142_g(ws.defaultRotationYaw);
/*  760 */       rev_sign = ((r >= 45.0F && r <= 135.0F) || (r <= -45.0F && r >= -135.0F));
/*  761 */       GL11.glRotatef(-ws.defaultRotationYaw, 0.0F, -1.0F, 0.0F);
/*      */     } 
/*      */     
/*  764 */     if (w.pitch) {
/*  765 */       if (ws != null) {
/*  766 */         rotPitch = ws.rotationPitch;
/*  767 */         prevPitch = ws.prevRotationPitch;
/*  768 */       } else if (e != null) {
/*  769 */         rotPitch = e.field_70125_A;
/*  770 */         prevPitch = e.field_70127_C;
/*      */       } else {
/*  772 */         rotPitch = ac.getLastRiderPitch();
/*  773 */         prevPitch = ac.prevLastRiderPitch;
/*      */       } 
/*      */       
/*  776 */       if (rev_sign) {
/*  777 */         rotPitch = -rotPitch;
/*  778 */         prevPitch = -prevPitch;
/*      */       } 
/*      */       
/*  781 */       GL11.glRotatef(prevPitch + (rotPitch - prevPitch) * tickTime, 1.0F, 0.0F, 0.0F);
/*      */     } 
/*      */     
/*  784 */     if (ws != null && w.recoilBuf != 0.0F) {
/*  785 */       MCH_WeaponSet.Recoil var17 = ws.recoilBuf[0];
/*  786 */       if (w.name.length > 1) {
/*  787 */         String[] recoilBuf = w.name;
/*  788 */         int len$ = recoilBuf.length;
/*      */         
/*  790 */         for (int i$ = 0; i$ < len$; i$++) {
/*  791 */           String wnm = recoilBuf[i$];
/*  792 */           MCH_WeaponSet tws = ac.getWeaponByName(wnm);
/*  793 */           if (tws != null && (tws.recoilBuf[0]).recoilBuf > var17.recoilBuf) {
/*  794 */             var17 = tws.recoilBuf[0];
/*      */           }
/*      */         } 
/*      */       } 
/*      */       
/*  799 */       float var18 = var17.prevRecoilBuf + (var17.recoilBuf - var17.prevRecoilBuf) * tickTime;
/*  800 */       GL11.glTranslated(0.0D, 0.0D, (-w.recoilBuf * var18));
/*      */     } 
/*      */     
/*  803 */     if (ws != null) {
/*  804 */       GL11.glRotatef(ws.defaultRotationYaw, 0.0F, -1.0F, 0.0F);
/*      */     }
/*      */     
/*  807 */     GL11.glTranslated(-w.pos.field_72450_a, -w.pos.field_72448_b, -w.pos.field_72449_c);
/*  808 */     renderPartWithOffset(w.model, info.model, w.modelName, ac.turretOffX, ac.turretOffY, ac.turretOffZ);
/*      */   }
/*      */   
/*      */   public static void renderTrackRoller(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  812 */     if (info.partTrackRoller.size() > 0) {
/*  813 */       float[] rot = ac.rotTrackRoller;
/*  814 */       float[] prevRot = ac.prevRotTrackRoller;
/*  815 */       Iterator<MCH_AircraftInfo.TrackRoller> i$ = info.partTrackRoller.iterator();
/*      */       
/*  817 */       while (i$.hasNext()) {
/*  818 */         MCH_AircraftInfo.TrackRoller t = i$.next();
/*  819 */         GL11.glPushMatrix();
/*  820 */         GL11.glTranslated(t.pos.field_72450_a, t.pos.field_72448_b, t.pos.field_72449_c);
/*  821 */         GL11.glRotatef(prevRot[t.side] + (rot[t.side] - prevRot[t.side]) * tickTime, 1.0F, 0.0F, 0.0F);
/*  822 */         GL11.glTranslated(-t.pos.field_72450_a, -t.pos.field_72448_b, -t.pos.field_72449_c);
/*  823 */         renderPart(t.model, info.model, t.modelName);
/*  824 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderCrawlerTrack(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  831 */     if (info.partCrawlerTrack.size() > 0) {
/*  832 */       int prevWidth = GL11.glGetInteger(2833);
/*  833 */       Tessellator tessellator = Tessellator.field_78398_a;
/*  834 */       Iterator<MCH_AircraftInfo.CrawlerTrack> i$ = info.partCrawlerTrack.iterator();
/*      */       
/*  836 */       while (i$.hasNext()) {
/*  837 */         MCH_AircraftInfo.CrawlerTrack c = i$.next();
/*  838 */         GL11.glPointSize(c.len * 20.0F);
/*  839 */         MCH_Config var10000 = MCH_MOD.config;
/*      */         
/*  841 */         if (MCH_Config.TestMode.prmBool) {
/*  842 */           GL11.glDisable(3553);
/*  843 */           GL11.glDisable(3042);
/*  844 */           tessellator.func_78371_b(0);
/*      */           
/*  846 */           for (int j = 0; j < c.cx.length; j++) {
/*  847 */             tessellator.func_78370_a((int)(255.0F / c.cx.length * j), 80, 255 - (int)(255.0F / c.cx.length * j), 255);
/*  848 */             tessellator.func_78377_a(c.z, c.cx[j], c.cy[j]);
/*      */           } 
/*      */           
/*  851 */           tessellator.func_78381_a();
/*      */         } 
/*      */         
/*  854 */         GL11.glEnable(3553);
/*  855 */         GL11.glEnable(3042);
/*  856 */         int L = c.lp.size() - 1;
/*  857 */         double rc = (ac != null) ? ac.rotCrawlerTrack[c.side] : 0.0D;
/*  858 */         double pc = (ac != null) ? ac.prevRotCrawlerTrack[c.side] : 0.0D;
/*      */         
/*  860 */         for (int i = 0; i < L; i++) {
/*  861 */           MCH_AircraftInfo.CrawlerTrackPrm cp = c.lp.get(i);
/*  862 */           MCH_AircraftInfo.CrawlerTrackPrm np = c.lp.get((i + 1) % L);
/*  863 */           double x1 = cp.x;
/*  864 */           double x2 = np.x;
/*  865 */           double r1 = cp.r;
/*  866 */           double y1 = cp.y;
/*  867 */           double y2 = np.y;
/*  868 */           double r2 = np.r;
/*  869 */           if (r2 - r1 < -180.0D) {
/*  870 */             r2 += 360.0D;
/*      */           }
/*      */           
/*  873 */           if (r2 - r1 > 180.0D) {
/*  874 */             r2 -= 360.0D;
/*      */           }
/*      */           
/*  877 */           double sx = x1 + (x2 - x1) * rc;
/*  878 */           double sy = y1 + (y2 - y1) * rc;
/*  879 */           double sr = r1 + (r2 - r1) * rc;
/*  880 */           double ex = x1 + (x2 - x1) * pc;
/*  881 */           double ey = y1 + (y2 - y1) * pc;
/*  882 */           double er = r1 + (r2 - r1) * pc;
/*  883 */           double x = sx + (ex - sx) * pc;
/*  884 */           double y = sy + (ey - sy) * pc;
/*  885 */           double r = sr + (er - sr) * pc;
/*  886 */           GL11.glPushMatrix();
/*  887 */           GL11.glTranslated(0.0D, x, y);
/*  888 */           GL11.glRotatef((float)r, -1.0F, 0.0F, 0.0F);
/*  889 */           renderPart(c.model, info.model, c.modelName);
/*  890 */           GL11.glPopMatrix();
/*      */         } 
/*      */       } 
/*      */       
/*  894 */       GL11.glEnable(3042);
/*  895 */       GL11.glPointSize(prevWidth);
/*      */     } 
/*      */   }
/*      */   
/*      */   public static void renderHatch(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  900 */     if (info.haveHatch() && ac.partHatch != null) {
/*  901 */       float rot = ac.getHatchRotation();
/*  902 */       float prevRot = ac.getPrevHatchRotation();
/*  903 */       Iterator<MCH_AircraftInfo.Hatch> i$ = info.hatchList.iterator();
/*      */       
/*  905 */       while (i$.hasNext()) {
/*  906 */         MCH_AircraftInfo.Hatch h = i$.next();
/*  907 */         GL11.glPushMatrix();
/*  908 */         if (h.isSlide) {
/*  909 */           float r = ac.partHatch.rotation / ac.partHatch.rotationMax;
/*  910 */           float pr = ac.partHatch.prevRotation / ac.partHatch.rotationMax;
/*  911 */           float f = pr + (r - pr) * tickTime;
/*  912 */           GL11.glTranslated(h.pos.field_72450_a * f, h.pos.field_72448_b * f, h.pos.field_72449_c * f);
/*      */         } else {
/*  914 */           GL11.glTranslated(h.pos.field_72450_a, h.pos.field_72448_b, h.pos.field_72449_c);
/*  915 */           GL11.glRotatef((prevRot + (rot - prevRot) * tickTime) * h.maxRotFactor, (float)h.rot.field_72450_a, (float)h.rot.field_72448_b, (float)h.rot.field_72449_c);
/*  916 */           GL11.glTranslated(-h.pos.field_72450_a, -h.pos.field_72448_b, -h.pos.field_72449_c);
/*      */         } 
/*      */         
/*  919 */         renderPart(h.model, info.model, h.modelName);
/*  920 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderThrottle(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  927 */     if (info.havePartThrottle()) {
/*  928 */       float throttle = MCH_Lib.smooth((float)ac.getCurrentThrottle(), (float)ac.getPrevCurrentThrottle(), tickTime);
/*  929 */       Iterator<MCH_AircraftInfo.Throttle> i$ = info.partThrottle.iterator();
/*      */       
/*  931 */       while (i$.hasNext()) {
/*  932 */         MCH_AircraftInfo.Throttle h = i$.next();
/*  933 */         GL11.glPushMatrix();
/*  934 */         GL11.glTranslated(h.pos.field_72450_a, h.pos.field_72448_b, h.pos.field_72449_c);
/*  935 */         GL11.glRotatef(throttle * h.rot2, (float)h.rot.field_72450_a, (float)h.rot.field_72448_b, (float)h.rot.field_72449_c);
/*  936 */         GL11.glTranslated(-h.pos.field_72450_a, -h.pos.field_72448_b, -h.pos.field_72449_c);
/*  937 */         GL11.glTranslated(h.slide.field_72450_a * throttle, h.slide.field_72448_b * throttle, h.slide.field_72449_c * throttle);
/*  938 */         renderPart(h.model, info.model, h.modelName);
/*  939 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderWeaponBay(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  946 */     for (int i = 0; i < info.partWeaponBay.size(); i++) {
/*  947 */       MCH_AircraftInfo.WeaponBay w = info.partWeaponBay.get(i);
/*  948 */       MCH_EntityAircraft.WeaponBay ws = ac.weaponBays[i];
/*  949 */       GL11.glPushMatrix();
/*  950 */       if (w.isSlide) {
/*  951 */         float r = ws.rot / 90.0F;
/*  952 */         float pr = ws.prevRot / 90.0F;
/*  953 */         float f = pr + (r - pr) * tickTime;
/*  954 */         GL11.glTranslated(w.pos.field_72450_a * f, w.pos.field_72448_b * f, w.pos.field_72449_c * f);
/*      */       } else {
/*  956 */         GL11.glTranslated(w.pos.field_72450_a, w.pos.field_72448_b, w.pos.field_72449_c);
/*  957 */         GL11.glRotatef((ws.prevRot + (ws.rot - ws.prevRot) * tickTime) * w.maxRotFactor, (float)w.rot.field_72450_a, (float)w.rot.field_72448_b, (float)w.rot.field_72449_c);
/*  958 */         GL11.glTranslated(-w.pos.field_72450_a, -w.pos.field_72448_b, -w.pos.field_72449_c);
/*      */       } 
/*      */       
/*  961 */       renderPart(w.model, info.model, w.modelName);
/*  962 */       GL11.glPopMatrix();
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderCamera(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  968 */     if (info.havePartCamera()) {
/*  969 */       float rotYaw = ac.camera.partRotationYaw;
/*  970 */       float prevRotYaw = ac.camera.prevPartRotationYaw;
/*  971 */       float rotPitch = ac.camera.partRotationPitch;
/*  972 */       float prevRotPitch = ac.camera.prevPartRotationPitch;
/*  973 */       float yaw = prevRotYaw + (rotYaw - prevRotYaw) * tickTime - ac.getRotYaw();
/*  974 */       float pitch = prevRotPitch + (rotPitch - prevRotPitch) * tickTime - ac.getRotPitch();
/*  975 */       Iterator<MCH_AircraftInfo.Camera> i$ = info.cameraList.iterator();
/*      */       
/*  977 */       while (i$.hasNext()) {
/*  978 */         MCH_AircraftInfo.Camera c = i$.next();
/*  979 */         GL11.glPushMatrix();
/*  980 */         GL11.glTranslated(c.pos.field_72450_a, c.pos.field_72448_b, c.pos.field_72449_c);
/*  981 */         if (c.yawSync) {
/*  982 */           GL11.glRotatef(yaw, 0.0F, -1.0F, 0.0F);
/*      */         }
/*      */         
/*  985 */         if (c.pitchSync) {
/*  986 */           GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/*      */         }
/*      */         
/*  989 */         GL11.glTranslated(-c.pos.field_72450_a, -c.pos.field_72448_b, -c.pos.field_72449_c);
/*  990 */         renderPart(c.model, info.model, c.modelName);
/*  991 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderCanopy(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/*  998 */     if (info.haveCanopy() && ac.partCanopy != null) {
/*  999 */       float rot = ac.getCanopyRotation();
/* 1000 */       float prevRot = ac.getPrevCanopyRotation();
/* 1001 */       Iterator<MCH_AircraftInfo.Canopy> i$ = info.canopyList.iterator();
/*      */       
/* 1003 */       while (i$.hasNext()) {
/* 1004 */         MCH_AircraftInfo.Canopy c = i$.next();
/* 1005 */         GL11.glPushMatrix();
/* 1006 */         if (c.isSlide) {
/* 1007 */           float r = ac.partCanopy.rotation / ac.partCanopy.rotationMax;
/* 1008 */           float pr = ac.partCanopy.prevRotation / ac.partCanopy.rotationMax;
/* 1009 */           float f = pr + (r - pr) * tickTime;
/* 1010 */           GL11.glTranslated(c.pos.field_72450_a * f, c.pos.field_72448_b * f, c.pos.field_72449_c * f);
/*      */         } else {
/* 1012 */           GL11.glTranslated(c.pos.field_72450_a, c.pos.field_72448_b, c.pos.field_72449_c);
/* 1013 */           GL11.glRotatef((prevRot + (rot - prevRot) * tickTime) * c.maxRotFactor, (float)c.rot.field_72450_a, (float)c.rot.field_72448_b, (float)c.rot.field_72449_c);
/* 1014 */           GL11.glTranslated(-c.pos.field_72450_a, -c.pos.field_72448_b, -c.pos.field_72449_c);
/*      */         } 
/*      */         
/* 1017 */         renderPart(c.model, info.model, c.modelName);
/* 1018 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderLandingGear(MCH_EntityAircraft ac, MCH_AircraftInfo info, float tickTime) {
/* 1025 */     if (info.haveLandingGear() && ac.partLandingGear != null) {
/* 1026 */       float rot = ac.getLandingGearRotation();
/* 1027 */       float prevRot = ac.getPrevLandingGearRotation();
/* 1028 */       float revR = 90.0F - rot;
/* 1029 */       float revPr = 90.0F - prevRot;
/* 1030 */       float rot1 = prevRot + (rot - prevRot) * tickTime;
/* 1031 */       float rot1Rev = revPr + (revR - revPr) * tickTime;
/* 1032 */       float rotHatch = 90.0F * MathHelper.func_76126_a(rot1 * 2.0F * 3.1415927F / 180.0F) * 3.0F;
/* 1033 */       if (rotHatch > 90.0F) {
/* 1034 */         rotHatch = 90.0F;
/*      */       }
/*      */       
/* 1037 */       Iterator<MCH_AircraftInfo.LandingGear> i$ = info.landingGear.iterator();
/*      */       
/* 1039 */       while (i$.hasNext()) {
/* 1040 */         MCH_AircraftInfo.LandingGear n = i$.next();
/* 1041 */         GL11.glPushMatrix();
/* 1042 */         GL11.glTranslated(n.pos.field_72450_a, n.pos.field_72448_b, n.pos.field_72449_c);
/* 1043 */         if (!n.reverse) {
/* 1044 */           if (!n.hatch) {
/* 1045 */             GL11.glRotatef(rot1 * n.maxRotFactor, (float)n.rot.field_72450_a, (float)n.rot.field_72448_b, (float)n.rot.field_72449_c);
/*      */           } else {
/* 1047 */             GL11.glRotatef(rotHatch * n.maxRotFactor, (float)n.rot.field_72450_a, (float)n.rot.field_72448_b, (float)n.rot.field_72449_c);
/*      */           } 
/*      */         } else {
/* 1050 */           GL11.glRotatef(rot1Rev * n.maxRotFactor, (float)n.rot.field_72450_a, (float)n.rot.field_72448_b, (float)n.rot.field_72449_c);
/*      */         } 
/*      */         
/* 1053 */         if (n.enableRot2) {
/* 1054 */           if (!n.reverse) {
/* 1055 */             GL11.glRotatef(rot1 * n.maxRotFactor2, (float)n.rot2.field_72450_a, (float)n.rot2.field_72448_b, (float)n.rot2.field_72449_c);
/*      */           } else {
/* 1057 */             GL11.glRotatef(rot1Rev * n.maxRotFactor2, (float)n.rot2.field_72450_a, (float)n.rot2.field_72448_b, (float)n.rot2.field_72449_c);
/*      */           } 
/*      */         }
/*      */         
/* 1061 */         GL11.glTranslated(-n.pos.field_72450_a, -n.pos.field_72448_b, -n.pos.field_72449_c);
/* 1062 */         if (n.slide != null) {
/* 1063 */           float f = rot / 90.0F;
/* 1064 */           if (n.reverse) {
/* 1065 */             f = 1.0F - f;
/*      */           }
/*      */           
/* 1068 */           GL11.glTranslated(f * n.slide.field_72450_a, f * n.slide.field_72448_b, f * n.slide.field_72449_c);
/*      */         } 
/*      */         
/* 1071 */         renderPart(n.model, info.model, n.modelName);
/* 1072 */         GL11.glPopMatrix();
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */   
/*      */   public static void renderEntityMarker(Entity entity) {
/* 1079 */     EntityClientPlayerMP player = (Minecraft.func_71410_x()).field_71439_g;
/* 1080 */     if (player != null && 
/* 1081 */       !W_Entity.isEqual((Entity)player, entity)) {
/* 1082 */       MCH_EntityAircraft ac = null;
/* 1083 */       if (player.field_70154_o instanceof MCH_EntityAircraft) {
/* 1084 */         ac = (MCH_EntityAircraft)player.field_70154_o;
/* 1085 */       } else if (player.field_70154_o instanceof MCH_EntitySeat) {
/* 1086 */         ac = ((MCH_EntitySeat)player.field_70154_o).getParent();
/* 1087 */       } else if (player.field_70154_o instanceof MCH_EntityUavStation) {
/* 1088 */         ac = ((MCH_EntityUavStation)player.field_70154_o).getControlAircract();
/*      */       } 
/*      */       
/* 1091 */       if (ac != null && 
/* 1092 */         !W_Entity.isEqual((Entity)ac, entity)) {
/* 1093 */         MCH_WeaponGuidanceSystem gs = ac.getCurrentWeapon((Entity)player).getCurrentWeapon().getGuidanceSystem();
/* 1094 */         if (gs != null && gs.canLockEntity(entity)) {
/* 1095 */           RenderManager rm = RenderManager.field_78727_a;
/* 1096 */           double dist = entity.func_70068_e((Entity)rm.field_78734_h);
/* 1097 */           double x = entity.field_70165_t - RenderManager.field_78725_b;
/* 1098 */           double y = entity.field_70163_u - RenderManager.field_78726_c;
/* 1099 */           double z = entity.field_70161_v - RenderManager.field_78723_d;
/* 1100 */           if (dist < 10000.0D) {
/* 1101 */             float scl = 0.02666667F;
/* 1102 */             GL11.glPushMatrix();
/* 1103 */             GL11.glTranslatef((float)x, (float)y + entity.field_70131_O + 0.5F, (float)z);
/* 1104 */             GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/* 1105 */             GL11.glRotatef(-rm.field_78735_i, 0.0F, 1.0F, 0.0F);
/* 1106 */             GL11.glRotatef(rm.field_78732_j, 1.0F, 0.0F, 0.0F);
/* 1107 */             GL11.glScalef(-0.02666667F, -0.02666667F, 0.02666667F);
/* 1108 */             GL11.glDisable(2896);
/* 1109 */             GL11.glTranslatef(0.0F, 9.374999F, 0.0F);
/* 1110 */             GL11.glDepthMask(false);
/* 1111 */             GL11.glEnable(3042);
/* 1112 */             GL11.glBlendFunc(770, 771);
/* 1113 */             GL11.glDisable(3553);
/* 1114 */             int prevWidth = GL11.glGetInteger(2849);
/* 1115 */             float size = Math.max(entity.field_70130_N, entity.field_70131_O) * 20.0F;
/* 1116 */             if (entity instanceof MCH_EntityAircraft) {
/* 1117 */               size *= 2.0F;
/*      */             }
/*      */             
/* 1120 */             Tessellator tessellator = Tessellator.field_78398_a;
/* 1121 */             tessellator.func_78371_b(2);
/* 1122 */             tessellator.func_78380_c(240);
/* 1123 */             boolean isLockEntity = gs.isLockingEntity(entity);
/* 1124 */             if (isLockEntity) {
/* 1125 */               GL11.glLineWidth(MCH_Gui.scaleFactor * 1.5F);
/* 1126 */               tessellator.func_78369_a(1.0F, 0.0F, 0.0F, 1.0F);
/*      */             } else {
/* 1128 */               GL11.glLineWidth(MCH_Gui.scaleFactor);
/* 1129 */               tessellator.func_78369_a(1.0F, 0.3F, 0.0F, 8.0F);
/*      */             } 
/*      */             
/* 1132 */             tessellator.func_78377_a((-size - 1.0F), 0.0D, 0.0D);
/* 1133 */             tessellator.func_78377_a((-size - 1.0F), (size * 2.0F), 0.0D);
/* 1134 */             tessellator.func_78377_a((size + 1.0F), (size * 2.0F), 0.0D);
/* 1135 */             tessellator.func_78377_a((size + 1.0F), 0.0D, 0.0D);
/* 1136 */             tessellator.func_78381_a();
/* 1137 */             GL11.glPopMatrix();
/* 1138 */             if (!ac.isUAV() && isLockEntity && (Minecraft.func_71410_x()).field_71474_y.field_74320_O == 0) {
/* 1139 */               GL11.glPushMatrix();
/* 1140 */               tessellator.func_78371_b(1);
/* 1141 */               GL11.glLineWidth(1.0F);
/* 1142 */               tessellator.func_78369_a(1.0F, 0.0F, 0.0F, 1.0F);
/* 1143 */               tessellator.func_78377_a(x, y + (entity.field_70131_O / 2.0F), z);
/* 1144 */               tessellator.func_78377_a(ac.field_70142_S - RenderManager.field_78725_b, ac.field_70137_T - RenderManager.field_78726_c - 1.0D, ac.field_70136_U - RenderManager.field_78723_d);
/* 1145 */               tessellator.func_78380_c(240);
/* 1146 */               tessellator.func_78381_a();
/* 1147 */               GL11.glPopMatrix();
/*      */             } 
/*      */             
/* 1150 */             GL11.glLineWidth(prevWidth);
/* 1151 */             GL11.glEnable(3553);
/* 1152 */             GL11.glDepthMask(true);
/* 1153 */             GL11.glEnable(2896);
/* 1154 */             GL11.glDisable(3042);
/* 1155 */             GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*      */           } 
/*      */         } 
/*      */       } 
/*      */     } 
/*      */   }
/*      */ 
/*      */ 
/*      */ 
/*      */   
/*      */   public static void renderRope(MCH_EntityAircraft ac, MCH_AircraftInfo info, double x, double y, double z, float tickTime) {
/* 1166 */     GL11.glPushMatrix();
/* 1167 */     Tessellator tessellator = Tessellator.field_78398_a;
/* 1168 */     if (ac.isRepelling()) {
/* 1169 */       GL11.glDisable(3553);
/* 1170 */       GL11.glDisable(2896);
/*      */       
/* 1172 */       for (int i = 0; i < info.repellingHooks.size(); i++) {
/* 1173 */         tessellator.func_78371_b(3);
/* 1174 */         tessellator.func_78378_d(0);
/* 1175 */         tessellator.func_78377_a(((MCH_AircraftInfo.RepellingHook)info.repellingHooks.get(i)).pos.field_72450_a, ((MCH_AircraftInfo.RepellingHook)info.repellingHooks.get(i)).pos.field_72448_b, ((MCH_AircraftInfo.RepellingHook)info.repellingHooks.get(i)).pos.field_72449_c);
/* 1176 */         tessellator.func_78377_a(((MCH_AircraftInfo.RepellingHook)info.repellingHooks.get(i)).pos.field_72450_a, ((MCH_AircraftInfo.RepellingHook)info.repellingHooks.get(i)).pos.field_72448_b + ac.ropesLength, ((MCH_AircraftInfo.RepellingHook)info.repellingHooks.get(i)).pos.field_72449_c);
/* 1177 */         tessellator.func_78381_a();
/*      */       } 
/*      */       
/* 1180 */       GL11.glEnable(2896);
/* 1181 */       GL11.glEnable(3553);
/*      */     } 
/*      */     
/* 1184 */     GL11.glPopMatrix();
/*      */   }
/*      */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\aircraft\MCH_RenderAircraft.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */