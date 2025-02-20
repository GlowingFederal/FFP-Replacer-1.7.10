/*     */ package mcheli.plane;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import mcheli.aircraft.MCH_AircraftInfo;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_RenderAircraft;
/*     */ import mcheli.wrapper.W_Render;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCP_RenderPlane
/*     */   extends MCH_RenderAircraft
/*     */ {
/*     */   public MCP_RenderPlane() {
/*  19 */     this.field_76989_e = 2.0F;
/*     */   }
/*     */   
/*     */   public void renderAircraft(MCH_EntityAircraft entity, double posX, double posY, double posZ, float yaw, float pitch, float roll, float tickTime) {
/*  23 */     MCP_PlaneInfo planeInfo = null;
/*  24 */     if (entity != null && entity instanceof MCP_EntityPlane) {
/*  25 */       MCP_EntityPlane plane = (MCP_EntityPlane)entity;
/*  26 */       planeInfo = plane.getPlaneInfo();
/*  27 */       if (planeInfo != null) {
/*  28 */         renderDebugHitBox(plane, posX, posY, posZ, yaw, pitch);
/*  29 */         renderDebugPilotSeat(plane, posX, posY, posZ, yaw, pitch, roll);
/*  30 */         GL11.glTranslated(posX, posY, posZ);
/*  31 */         GL11.glRotatef(yaw, 0.0F, -1.0F, 0.0F);
/*  32 */         GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/*  33 */         GL11.glRotatef(roll, 0.0F, 0.0F, 1.0F);
/*  34 */         bindTexture("textures/planes/" + plane.getTextureName() + ".png", plane);
/*  35 */         if (planeInfo.haveNozzle() && plane.partNozzle != null) {
/*  36 */           renderNozzle(plane, planeInfo, tickTime);
/*     */         }
/*     */         
/*  39 */         if (planeInfo.haveWing() && plane.partWing != null) {
/*  40 */           renderWing(plane, planeInfo, tickTime);
/*     */         }
/*     */         
/*  43 */         if (planeInfo.haveRotor() && plane.partNozzle != null) {
/*  44 */           renderRotor(plane, planeInfo, tickTime);
/*     */         }
/*     */         
/*  47 */         renderBody(planeInfo.model);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderRotor(MCP_EntityPlane plane, MCP_PlaneInfo planeInfo, float tickTime) {
/*  53 */     float rot = plane.getNozzleRotation();
/*  54 */     float prevRot = plane.getPrevNozzleRotation();
/*  55 */     Iterator<MCP_PlaneInfo.Rotor> i$ = planeInfo.rotorList.iterator();
/*     */     
/*  57 */     while (i$.hasNext()) {
/*  58 */       MCP_PlaneInfo.Rotor r = i$.next();
/*  59 */       GL11.glPushMatrix();
/*  60 */       GL11.glTranslated(r.pos.field_72450_a, r.pos.field_72448_b, r.pos.field_72449_c);
/*  61 */       GL11.glRotatef((prevRot + (rot - prevRot) * tickTime) * r.maxRotFactor, (float)r.rot.field_72450_a, (float)r.rot.field_72448_b, (float)r.rot.field_72449_c);
/*  62 */       GL11.glTranslated(-r.pos.field_72450_a, -r.pos.field_72448_b, -r.pos.field_72449_c);
/*  63 */       renderPart(r.model, planeInfo.model, r.modelName);
/*  64 */       Iterator<MCP_PlaneInfo.Blade> i$1 = r.blades.iterator();
/*     */       
/*  66 */       while (i$1.hasNext()) {
/*  67 */         MCP_PlaneInfo.Blade b = i$1.next();
/*  68 */         float br = plane.prevRotationRotor;
/*  69 */         br += (plane.rotationRotor - plane.prevRotationRotor) * tickTime;
/*  70 */         GL11.glPushMatrix();
/*  71 */         GL11.glTranslated(b.pos.field_72450_a, b.pos.field_72448_b, b.pos.field_72449_c);
/*  72 */         GL11.glRotatef(br, (float)b.rot.field_72450_a, (float)b.rot.field_72448_b, (float)b.rot.field_72449_c);
/*  73 */         GL11.glTranslated(-b.pos.field_72450_a, -b.pos.field_72448_b, -b.pos.field_72449_c);
/*     */         
/*  75 */         for (int i = 0; i < b.numBlade; i++) {
/*  76 */           GL11.glTranslated(b.pos.field_72450_a, b.pos.field_72448_b, b.pos.field_72449_c);
/*  77 */           GL11.glRotatef(b.rotBlade, (float)b.rot.field_72450_a, (float)b.rot.field_72448_b, (float)b.rot.field_72449_c);
/*  78 */           GL11.glTranslated(-b.pos.field_72450_a, -b.pos.field_72448_b, -b.pos.field_72449_c);
/*  79 */           renderPart(b.model, planeInfo.model, b.modelName);
/*     */         } 
/*     */         
/*  82 */         GL11.glPopMatrix();
/*     */       } 
/*     */       
/*  85 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   public void renderWing(MCP_EntityPlane plane, MCP_PlaneInfo planeInfo, float tickTime) {
/*  91 */     float rot = plane.getWingRotation();
/*  92 */     float prevRot = plane.getPrevWingRotation();
/*     */     
/*  94 */     for (MCP_PlaneInfo.Wing w : planeInfo.wingList) {
/*     */       
/*  96 */       GL11.glPushMatrix();
/*  97 */       GL11.glTranslated(w.pos.field_72450_a, w.pos.field_72448_b, w.pos.field_72449_c);
/*  98 */       GL11.glRotatef((prevRot + (rot - prevRot) * tickTime) * w.maxRotFactor, (float)w.rot.field_72450_a, (float)w.rot.field_72448_b, (float)w.rot.field_72449_c);
/*  99 */       GL11.glTranslated(-w.pos.field_72450_a, -w.pos.field_72448_b, -w.pos.field_72449_c);
/* 100 */       renderPart(w.model, planeInfo.model, w.modelName);
/* 101 */       if (w.pylonList != null) {
/* 102 */         Iterator<MCP_PlaneInfo.Pylon> i$1 = w.pylonList.iterator();
/*     */         
/* 104 */         while (i$1.hasNext()) {
/* 105 */           MCP_PlaneInfo.Pylon p = i$1.next();
/* 106 */           GL11.glPushMatrix();
/* 107 */           GL11.glTranslated(p.pos.field_72450_a, p.pos.field_72448_b, p.pos.field_72449_c);
/* 108 */           GL11.glRotatef((prevRot + (rot - prevRot) * tickTime) * p.maxRotFactor, (float)p.rot.field_72450_a, (float)p.rot.field_72448_b, (float)p.rot.field_72449_c);
/* 109 */           GL11.glTranslated(-p.pos.field_72450_a, -p.pos.field_72448_b, -p.pos.field_72449_c);
/* 110 */           renderPart(p.model, planeInfo.model, p.modelName);
/* 111 */           GL11.glPopMatrix();
/*     */         } 
/*     */       } 
/*     */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */   
/*     */   public void renderNozzle(MCP_EntityPlane plane, MCP_PlaneInfo planeInfo, float tickTime) {
/* 119 */     float rot = plane.getNozzleRotation();
/* 120 */     float prevRot = plane.getPrevNozzleRotation();
/* 121 */     Iterator<MCH_AircraftInfo.DrawnPart> i$ = planeInfo.nozzles.iterator();
/*     */     
/* 123 */     while (i$.hasNext()) {
/* 124 */       MCH_AircraftInfo.DrawnPart n = i$.next();
/* 125 */       GL11.glPushMatrix();
/* 126 */       GL11.glTranslated(n.pos.field_72450_a, n.pos.field_72448_b, n.pos.field_72449_c);
/* 127 */       GL11.glRotatef(prevRot + (rot - prevRot) * tickTime, (float)n.rot.field_72450_a, (float)n.rot.field_72448_b, (float)n.rot.field_72449_c);
/* 128 */       GL11.glTranslated(-n.pos.field_72450_a, -n.pos.field_72448_b, -n.pos.field_72449_c);
/* 129 */       renderPart(n.model, planeInfo.model, n.modelName);
/* 130 */       GL11.glPopMatrix();
/*     */     } 
/*     */   }
/*     */ 
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity entity) {
/* 136 */     return W_Render.TEX_DEFAULT;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\plane\MCP_RenderPlane.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */