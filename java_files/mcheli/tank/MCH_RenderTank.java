/*    */ package mcheli.tank;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.MCH_Config;
/*    */ import mcheli.MCH_MOD;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.aircraft.MCH_RenderAircraft;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.client.renderer.Tessellator;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import net.minecraft.util.Vec3;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderTank
/*    */   extends MCH_RenderAircraft {
/*    */   public MCH_RenderTank() {
/* 20 */     this.field_76989_e = 2.0F;
/*    */   }
/*    */   
/*    */   public void renderAircraft(MCH_EntityAircraft entity, double posX, double posY, double posZ, float yaw, float pitch, float roll, float tickTime) {
/* 24 */     MCH_TankInfo tankInfo = null;
/* 25 */     if (entity != null && entity instanceof MCH_EntityTank) {
/* 26 */       MCH_EntityTank tank = (MCH_EntityTank)entity;
/* 27 */       tankInfo = tank.getTankInfo();
/* 28 */       if (tankInfo != null) {
/* 29 */         renderWheel(tank, posX, posY, posZ);
/* 30 */         renderDebugHitBox(tank, posX, posY, posZ, yaw, pitch);
/* 31 */         renderDebugPilotSeat(tank, posX, posY, posZ, yaw, pitch, roll);
/* 32 */         GL11.glTranslated(posX, posY, posZ);
/* 33 */         GL11.glRotatef(yaw, 0.0F, -1.0F, 0.0F);
/* 34 */         GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/* 35 */         GL11.glRotatef(roll, 0.0F, 0.0F, 1.0F);
/* 36 */         bindTexture("textures/tanks/" + tank.getTextureName() + ".png", tank);
/* 37 */         renderBody(tankInfo.model);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void renderWheel(MCH_EntityTank tank, double posX, double posY, double posZ) {
/* 43 */     MCH_Config var10000 = MCH_MOD.config;
/* 44 */     if (MCH_Config.TestMode.prmBool && 
/* 45 */       MCH_RenderAircraft.debugModel != null) {
/* 46 */       GL11.glColor4f(0.75F, 0.75F, 0.75F, 0.5F);
/* 47 */       MCH_EntityWheel[] tessellator = tank.WheelMng.wheels;
/* 48 */       int wp = tessellator.length;
/*    */       
/*    */       int i;
/*    */       
/* 52 */       for (i = 0; i < wp; i++) {
/* 53 */         MCH_EntityWheel w1 = tessellator[i];
/* 54 */         GL11.glPushMatrix();
/* 55 */         GL11.glTranslated(w1.field_70165_t - tank.field_70165_t + posX, w1.field_70163_u - tank.field_70163_u + posY + 0.25D, w1.field_70161_v - tank.field_70161_v + posZ);
/* 56 */         GL11.glScalef(w1.field_70130_N, w1.field_70131_O / 2.0F, w1.field_70130_N);
/* 57 */         bindTexture("textures/seat_pilot.png");
/* 58 */         MCH_RenderAircraft.debugModel.renderAll();
/* 59 */         GL11.glPopMatrix();
/*    */       } 
/*    */       
/* 62 */       GL11.glColor4f(0.75F, 0.75F, 0.75F, 1.0F);
/* 63 */       Tessellator var13 = Tessellator.field_78398_a;
/* 64 */       var13.func_78371_b(1);
/* 65 */       Vec3 var14 = tank.getTransformedPosition(tank.WheelMng.weightedCenter);
/* 66 */       var14.field_72450_a -= tank.field_70165_t;
/* 67 */       var14.field_72448_b -= tank.field_70163_u;
/* 68 */       var14.field_72449_c -= tank.field_70161_v;
/*    */       
/* 70 */       for (i = 0; i < tank.WheelMng.wheels.length / 2; i++) {
/* 71 */         var13.func_78384_a((((i & 0x4) > 0) ? 16711680 : 0) | (((i & 0x2) > 0) ? 65280 : 0) | (((i & 0x1) > 0) ? 255 : 0), 192);
/* 72 */         MCH_EntityWheel w1 = tank.WheelMng.wheels[i * 2 + 0];
/* 73 */         MCH_EntityWheel w2 = tank.WheelMng.wheels[i * 2 + 1];
/* 74 */         if (w1.isPlus) {
/* 75 */           var13.func_78377_a(w2.field_70165_t - tank.field_70165_t + posX, w2.field_70163_u - tank.field_70163_u + posY, w2.field_70161_v - tank.field_70161_v + posZ);
/* 76 */           var13.func_78377_a(w1.field_70165_t - tank.field_70165_t + posX, w1.field_70163_u - tank.field_70163_u + posY, w1.field_70161_v - tank.field_70161_v + posZ);
/* 77 */           var13.func_78377_a(w1.field_70165_t - tank.field_70165_t + posX, w1.field_70163_u - tank.field_70163_u + posY, w1.field_70161_v - tank.field_70161_v + posZ);
/* 78 */           var13.func_78377_a(posX + var14.field_72450_a, posY + var14.field_72448_b, posZ + var14.field_72449_c);
/* 79 */           var13.func_78377_a(posX + var14.field_72450_a, posY + var14.field_72448_b, posZ + var14.field_72449_c);
/* 80 */           var13.func_78377_a(w2.field_70165_t - tank.field_70165_t + posX, w2.field_70163_u - tank.field_70163_u + posY, w2.field_70161_v - tank.field_70161_v + posZ);
/*    */         } else {
/* 82 */           var13.func_78377_a(w1.field_70165_t - tank.field_70165_t + posX, w1.field_70163_u - tank.field_70163_u + posY, w1.field_70161_v - tank.field_70161_v + posZ);
/* 83 */           var13.func_78377_a(w2.field_70165_t - tank.field_70165_t + posX, w2.field_70163_u - tank.field_70163_u + posY, w2.field_70161_v - tank.field_70161_v + posZ);
/* 84 */           var13.func_78377_a(w2.field_70165_t - tank.field_70165_t + posX, w2.field_70163_u - tank.field_70163_u + posY, w2.field_70161_v - tank.field_70161_v + posZ);
/* 85 */           var13.func_78377_a(posX + var14.field_72450_a, posY + var14.field_72448_b, posZ + var14.field_72449_c);
/* 86 */           var13.func_78377_a(posX + var14.field_72450_a, posY + var14.field_72448_b, posZ + var14.field_72449_c);
/* 87 */           var13.func_78377_a(w1.field_70165_t - tank.field_70165_t + posX, w1.field_70163_u - tank.field_70163_u + posY, w1.field_70161_v - tank.field_70161_v + posZ);
/*    */         } 
/*    */       } 
/*    */       
/* 91 */       var13.func_78381_a();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 97 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\tank\MCH_RenderTank.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */