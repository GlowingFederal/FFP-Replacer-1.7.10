/*     */ package mcheli.vehicle;
/*     */ 
/*     */ import cpw.mods.fml.relauncher.Side;
/*     */ import cpw.mods.fml.relauncher.SideOnly;
/*     */ import java.util.Iterator;
/*     */ import mcheli.MCH_Lib;
/*     */ import mcheli.MCH_ModelManager;
/*     */ import mcheli.aircraft.MCH_EntityAircraft;
/*     */ import mcheli.aircraft.MCH_RenderAircraft;
/*     */ import mcheli.weapon.MCH_WeaponSet;
/*     */ import mcheli.wrapper.W_Lib;
/*     */ import mcheli.wrapper.W_Render;
/*     */ import net.minecraft.entity.Entity;
/*     */ import net.minecraft.util.ResourceLocation;
/*     */ import org.lwjgl.opengl.GL11;
/*     */ 
/*     */ @SideOnly(Side.CLIENT)
/*     */ public class MCH_RenderVehicle
/*     */   extends MCH_RenderAircraft
/*     */ {
/*     */   public MCH_RenderVehicle() {
/*  22 */     this.field_76989_e = 2.0F;
/*     */   }
/*     */   
/*     */   public void renderAircraft(MCH_EntityAircraft entity, double posX, double posY, double posZ, float yaw, float pitch, float roll, float tickTime) {
/*  26 */     MCH_VehicleInfo vehicleInfo = null;
/*  27 */     if (entity != null && entity instanceof MCH_EntityVehicle) {
/*  28 */       MCH_EntityVehicle vehicle = (MCH_EntityVehicle)entity;
/*  29 */       vehicleInfo = vehicle.getVehicleInfo();
/*  30 */       if (vehicleInfo != null) {
/*  31 */         if (vehicle.field_70153_n != null && !vehicle.isDestroyed()) {
/*  32 */           vehicle.isUsedPlayer = true;
/*  33 */           vehicle.lastRiderYaw = vehicle.field_70153_n.field_70177_z;
/*  34 */           vehicle.lastRiderPitch = vehicle.field_70153_n.field_70125_A;
/*  35 */         } else if (!vehicle.isUsedPlayer) {
/*  36 */           vehicle.lastRiderYaw = vehicle.field_70177_z;
/*  37 */           vehicle.lastRiderPitch = vehicle.field_70125_A;
/*     */         } 
/*     */         
/*  40 */         renderDebugHitBox(vehicle, posX, posY, posZ, yaw, pitch);
/*  41 */         renderDebugPilotSeat(vehicle, posX, posY, posZ, yaw, pitch, roll);
/*  42 */         GL11.glTranslated(posX, posY, posZ);
/*  43 */         GL11.glRotatef(yaw, 0.0F, -1.0F, 0.0F);
/*  44 */         GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/*  45 */         bindTexture("textures/vehicles/" + vehicle.getTextureName() + ".png", vehicle);
/*  46 */         renderBody(vehicleInfo.model);
/*  47 */         MCH_WeaponSet ws = vehicle.getFirstSeatWeapon();
/*  48 */         drawPart(vehicle, vehicleInfo, yaw, pitch, ws, tickTime);
/*     */       } 
/*     */     } 
/*     */   }
/*     */   
/*     */   public void drawPart(MCH_EntityVehicle vehicle, MCH_VehicleInfo info, float yaw, float pitch, MCH_WeaponSet ws, float tickTime) {
/*  54 */     float rotBrl = ws.prevRotBarrel + (ws.rotBarrel - ws.prevRotBarrel) * tickTime;
/*  55 */     int index = 0;
/*     */ 
/*     */     
/*  58 */     for (MCH_VehicleInfo.VPart vp : info.partList) index = drawPart(vp, vehicle, info, yaw, pitch, rotBrl, tickTime, ws, index);
/*     */   
/*     */   }
/*     */ 
/*     */ 
/*     */   
/*     */   int drawPart(MCH_VehicleInfo.VPart vp, MCH_EntityVehicle vehicle, MCH_VehicleInfo info, float yaw, float pitch, float rotBrl, float tickTime, MCH_WeaponSet ws, int index) {
/*  65 */     GL11.glPushMatrix();
/*  66 */     float recoilBuf = 0.0F;
/*  67 */     if (index < ws.getWeaponNum()) {
/*  68 */       MCH_WeaponSet.Recoil bkIndex = ws.recoilBuf[index];
/*  69 */       recoilBuf = bkIndex.prevRecoilBuf + (bkIndex.recoilBuf - bkIndex.prevRecoilBuf) * tickTime;
/*     */     } 
/*     */     
/*  72 */     if (vp.rotPitch || vp.rotYaw || vp.type == 1) {
/*  73 */       GL11.glTranslated(vp.pos.field_72450_a, vp.pos.field_72448_b, vp.pos.field_72449_c);
/*  74 */       if (vp.rotYaw) {
/*  75 */         GL11.glRotatef(-vehicle.lastRiderYaw + yaw, 0.0F, 1.0F, 0.0F);
/*     */       }
/*     */       
/*  78 */       if (vp.rotPitch) {
/*  79 */         float i$ = MCH_Lib.RNG(vehicle.lastRiderPitch, info.minRotationPitch, info.maxRotationPitch);
/*  80 */         GL11.glRotatef(i$ - pitch, 1.0F, 0.0F, 0.0F);
/*     */       } 
/*     */       
/*  83 */       if (vp.type == 1) {
/*  84 */         GL11.glRotatef(rotBrl, 0.0F, 0.0F, -1.0F);
/*     */       }
/*     */       
/*  87 */       GL11.glTranslated(-vp.pos.field_72450_a, -vp.pos.field_72448_b, -vp.pos.field_72449_c);
/*     */     } 
/*     */     
/*  90 */     if (vp.type == 2) {
/*  91 */       GL11.glTranslated(0.0D, 0.0D, (-vp.recoilBuf * recoilBuf));
/*     */     }
/*     */     
/*  94 */     if (vp.type == 2 || vp.type == 3) {
/*  95 */       index++;
/*     */     }
/*     */ 
/*     */     
/*  99 */     if (vp.child != null) {
/* 100 */       for (Iterator<MCH_VehicleInfo.VPart> var14 = vp.child.iterator(); var14.hasNext(); index = drawPart(vcp, vehicle, info, yaw, pitch, rotBrl, recoilBuf, ws, index)) {
/* 101 */         MCH_VehicleInfo.VPart vcp = var14.next();
/*     */       }
/*     */     }
/*     */     
/* 105 */     if ((vp.drawFP || !W_Lib.isClientPlayer(vehicle.field_70153_n) || !W_Lib.isFirstPerson()) && (vp.type != 3 || !vehicle.isWeaponNotCooldown(ws, index))) {
/* 106 */       renderPart(vp.model, info.model, vp.modelName);
/* 107 */       MCH_ModelManager.render("vehicles", vp.modelName);
/*     */     } 
/*     */     
/* 110 */     GL11.glPopMatrix();
/* 111 */     return index;
/*     */   }
/*     */   
/*     */   protected ResourceLocation func_110775_a(Entity entity) {
/* 115 */     return W_Render.TEX_DEFAULT;
/*     */   }
/*     */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\vehicle\MCH_RenderVehicle.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */