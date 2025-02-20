/*     */ package mcheli;
/*     */ 
/*     */ import java.util.ArrayList;
/*     */ import java.util.Iterator;
/*     */ import java.util.List;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_RenderAircraft;
/*     */ import mcheli.lweapon.MCH_ClientLightWeaponTickHandler;
/*     */ import mcheli.multiplay.MCH_GuiTargetMarker;
/*     */ import mcheli.particles.MCH_ParticlesUtil;
/*     */ import mcheli.tool.rangefinder.MCH_ItemRangeFinder;
/*     */ import mcheli.wrapper.W_ClientEventHook;
/*     */ import mcheli.wrapper.W_Reflection;
/*     */ import net.minecraft.client.Minecraft;
/*     */ import net.minecraft.client.entity.EntityClientPlayerMP;
/*     */ import net.minecraft.client.renderer.OpenGlHelper;
/*     */ import net.minecraft.client.renderer.Tessellator;
/*     */ import net.minecraft.client.renderer.entity.Render;
/*     */ import net.minecraft.client.renderer.entity.RenderManager;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.entity.EntityLivingBase;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import net.minecraftforge.client.event.MouseEvent;
/*     */ import net.minecraftforge.client.event.RenderLivingEvent;
/*     */ import net.minecraftforge.client.event.RenderPlayerEvent;
/*     */ import net.minecraftforge.event.entity.EntityJoinWorldEvent;
/*     */ import net.minecraftforge.event.world.WorldEvent;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ public class MCH_ClientEventHook
/*     */   extends W_ClientEventHook {
/*  32 */   MCH_TextureManagerDummy dummyTextureManager = null;
/*  33 */   public static List haveSearchLightAircraft = new ArrayList();
/*  34 */   private static final ResourceLocation ir_strobe = new ResourceLocation("mcheli", "textures/ir_strobe.png");
/*     */   
/*     */   private static boolean cancelRender = true;
/*     */   
/*     */   public void renderLivingEventSpecialsPre(RenderLivingEvent.Specials.Pre event) {
/*  39 */     MCH_Config var10000 = MCH_MOD.config;
/*  40 */     if (MCH_Config.DisableRenderLivingSpecials.prmBool) {
/*  41 */       MCH_EntityAircraft ac = MCH_EntityAircraft.getAircraft_RiddenOrControl((Entity)(Minecraft.func_71410_x()).field_71439_g);
/*  42 */       if (ac != null && ac.isMountedEntity((Entity)event.entity)) {
/*  43 */         event.setCanceled(true);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderLivingEventSpecialsPost(RenderLivingEvent.Specials.Post event) {}
/*     */   
/*     */   private void renderIRStrobe(EntityLivingBase entity, RenderLivingEvent.Specials.Post event) {
/*  53 */     int cm = MCH_ClientCommonTickHandler.cameraMode;
/*  54 */     if (cm != 0) {
/*  55 */       int ticks = entity.field_70173_aa % 20;
/*  56 */       if (ticks < 4) {
/*  57 */         float alpha = (ticks != 2 && ticks != 1) ? 0.5F : 1.0F;
/*  58 */         EntityClientPlayerMP player = (Minecraft.func_71410_x()).field_71439_g;
/*  59 */         if (player != null && 
/*  60 */           player.func_142014_c(entity)) {
/*  61 */           short j = 240;
/*  62 */           short k = 240;
/*  63 */           OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, j / 1.0F, k / 1.0F);
/*  64 */           GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
/*  65 */           float f1 = 0.080000006F;
/*  66 */           GL11.glPushMatrix();
/*  67 */           GL11.glTranslated(event.x, event.y + (float)(entity.field_70131_O * 0.75D), event.z);
/*  68 */           GL11.glNormal3f(0.0F, 1.0F, 0.0F);
/*  69 */           GL11.glRotatef(-RenderManager.field_78727_a.field_78735_i, 0.0F, 1.0F, 0.0F);
/*  70 */           GL11.glRotatef(RenderManager.field_78727_a.field_78732_j, 1.0F, 0.0F, 0.0F);
/*  71 */           GL11.glScalef(-f1, -f1, f1);
/*  72 */           GL11.glEnable(3042);
/*  73 */           OpenGlHelper.func_148821_a(770, 771, 1, 0);
/*  74 */           GL11.glEnable(3553);
/*  75 */           RenderManager.field_78727_a.field_78724_e.func_110577_a(ir_strobe);
/*  76 */           GL11.glAlphaFunc(516, 0.003921569F);
/*  77 */           Tessellator tessellator = Tessellator.field_78398_a;
/*  78 */           tessellator.func_78382_b();
/*  79 */           tessellator.func_78369_a(1.0F, 1.0F, 1.0F, alpha * ((cm == 1) ? 0.9F : 0.5F));
/*  80 */           int i = (int)Math.max(entity.field_70130_N, entity.field_70131_O) * 20;
/*  81 */           tessellator.func_78374_a(-i, -i, 0.1D, 0.0D, 0.0D);
/*  82 */           tessellator.func_78374_a(-i, i, 0.1D, 0.0D, 1.0D);
/*  83 */           tessellator.func_78374_a(i, i, 0.1D, 1.0D, 1.0D);
/*  84 */           tessellator.func_78374_a(i, -i, 0.1D, 1.0D, 0.0D);
/*  85 */           tessellator.func_78381_a();
/*  86 */           GL11.glEnable(2896);
/*  87 */           GL11.glPopMatrix();
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void mouseEvent(MouseEvent event) {
/*  95 */     if (MCH_ClientTickHandlerBase.updateMouseWheel(event.dwheel)) {
/*  96 */       event.setCanceled(true);
/*     */     }
/*     */   }
/*     */ 
/*     */   
/*     */   public static void setCancelRender(boolean cancel) {
/* 102 */     cancelRender = cancel;
/*     */   }
/*     */   
/*     */   public void renderLivingEventPre(RenderLivingEvent.Pre event) {
/* 106 */     Iterator<MCH_EntityAircraft> rm = haveSearchLightAircraft.iterator();
/*     */     
/* 108 */     while (rm.hasNext()) {
/* 109 */       MCH_EntityAircraft ac = rm.next();
/* 110 */       OpenGlHelper.func_77475_a(OpenGlHelper.field_77476_b, ac.getSearchLightValue((Entity)event.entity), 240.0F);
/*     */     } 
/*     */     
/* 113 */     MCH_Config var10000 = MCH_MOD.config;
/* 114 */     if (MCH_Config.EnableModEntityRender.prmBool && cancelRender && (event.entity.field_70154_o instanceof MCH_EntityAircraft || event.entity.field_70154_o instanceof mcheli.aircraft.MCH_EntitySeat)) {
/* 115 */       event.setCanceled(true);
/*     */     } else {
/* 117 */       var10000 = MCH_MOD.config;
/* 118 */       if (MCH_Config.EnableReplaceTextureManager.prmBool) {
/* 119 */         RenderManager rm1 = W_Reflection.getRenderManager((Render)event.renderer);
/* 120 */         if (rm1 != null && !(rm1.field_78724_e instanceof MCH_TextureManagerDummy)) {
/* 121 */           if (this.dummyTextureManager == null) {
/* 122 */             this.dummyTextureManager = new MCH_TextureManagerDummy(rm1.field_78724_e);
/*     */           }
/*     */           
/* 125 */           rm1.field_78724_e = this.dummyTextureManager;
/*     */         } 
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderLivingEventPost(RenderLivingEvent.Post event) {
/* 133 */     MCH_RenderAircraft.renderEntityMarker((Entity)event.entity);
/* 134 */     MCH_GuiTargetMarker.addMarkEntityPos(2, (Entity)event.entity, event.x, event.y + event.entity.field_70131_O + 0.5D, event.z);
/* 135 */     MCH_ClientLightWeaponTickHandler.markEntity((Entity)event.entity, event.x, event.y + (event.entity.field_70131_O / 2.0F), event.z);
/*     */   }
/*     */   
/*     */   public void renderPlayerPre(RenderPlayerEvent.Pre event) {
/* 139 */     if (event.entity != null && 
/* 140 */       event.entity.field_70154_o instanceof MCH_EntityAircraft) {
/* 141 */       MCH_EntityAircraft v = (MCH_EntityAircraft)event.entity.field_70154_o;
/* 142 */       if (v.getAcInfo() != null && (v.getAcInfo()).hideEntity) {
/* 143 */         event.setCanceled(true);
/*     */         return;
/*     */       } 
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderPlayerPost(RenderPlayerEvent.Post event) {}
/*     */ 
/*     */   
/*     */   public void worldEventUnload(WorldEvent.Unload event) {
/* 154 */     MCH_ViewEntityDummy.onUnloadWorld();
/*     */   }
/*     */   
/*     */   public void entityJoinWorldEvent(EntityJoinWorldEvent event) {
/* 158 */     if (event.entity.func_70028_i(MCH_Lib.getClientPlayer())) {
/* 159 */       MCH_Lib.DbgLog(true, "MCH_ClientEventHook.entityJoinWorldEvent : " + event.entity, new Object[0]);
/* 160 */       MCH_ItemRangeFinder.mode = Minecraft.func_71410_x().func_71356_B() ? 1 : 0;
/* 161 */       MCH_ParticlesUtil.clearMarkPoint();
/*     */     } 
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\MCH_ClientEventHook.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */