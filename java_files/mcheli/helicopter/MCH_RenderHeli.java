/*    */ package mcheli.helicopter;
/*    */ 
/*    */ import cpw.mods.fml.relauncher.Side;
/*    */ import cpw.mods.fml.relauncher.SideOnly;
/*    */ import mcheli.aircraft.MCH_Blade;
/*    */ import mcheli.aircraft.MCH_EntityAircraft;
/*    */ import mcheli.aircraft.MCH_RenderAircraft;
/*    */ import mcheli.aircraft.MCH_Rotor;
/*    */ import mcheli.wrapper.W_Render;
/*    */ import net.minecraft.entity.Entity;
/*    */ import net.minecraft.util.ResourceLocation;
/*    */ import org.lwjgl.opengl.GL11;
/*    */ 
/*    */ @SideOnly(Side.CLIENT)
/*    */ public class MCH_RenderHeli
/*    */   extends MCH_RenderAircraft {
/*    */   public MCH_RenderHeli() {
/* 18 */     this.field_76989_e = 2.0F;
/*    */   }
/*    */   
/*    */   public void renderAircraft(MCH_EntityAircraft entity, double posX, double posY, double posZ, float yaw, float pitch, float roll, float tickTime) {
/* 22 */     MCH_HeliInfo heliInfo = null;
/* 23 */     if (entity != null && entity instanceof MCH_EntityHeli) {
/* 24 */       MCH_EntityHeli heli = (MCH_EntityHeli)entity;
/* 25 */       heliInfo = heli.getHeliInfo();
/* 26 */       if (heliInfo != null) {
/* 27 */         renderDebugHitBox(heli, posX, posY, posZ, yaw, pitch);
/* 28 */         renderDebugPilotSeat(heli, posX, posY, posZ, yaw, pitch, roll);
/* 29 */         GL11.glTranslated(posX, posY, posZ);
/* 30 */         GL11.glRotatef(yaw, 0.0F, -1.0F, 0.0F);
/* 31 */         GL11.glRotatef(pitch, 1.0F, 0.0F, 0.0F);
/* 32 */         GL11.glRotatef(roll, 0.0F, 0.0F, 1.0F);
/* 33 */         bindTexture("textures/helicopters/" + heli.getTextureName() + ".png", heli);
/* 34 */         renderBody(heliInfo.model);
/* 35 */         drawModelBlade(heli, heliInfo, tickTime);
/*    */       } 
/*    */     } 
/*    */   }
/*    */   
/*    */   public void drawModelBlade(MCH_EntityHeli heli, MCH_HeliInfo info, float tickTime) {
/* 41 */     for (int i = 0; i < heli.rotors.length && i < info.rotorList.size(); i++) {
/* 42 */       MCH_HeliInfo.Rotor rotorInfo = info.rotorList.get(i);
/* 43 */       MCH_Rotor rotor = heli.rotors[i];
/* 44 */       GL11.glPushMatrix();
/* 45 */       if (rotorInfo.oldRenderMethod) {
/* 46 */         GL11.glTranslated(rotorInfo.pos.field_72450_a, rotorInfo.pos.field_72448_b, rotorInfo.pos.field_72449_c);
/*    */       }
/*    */       
/* 49 */       MCH_Blade[] arr$ = rotor.blades;
/* 50 */       int len$ = arr$.length;
/*    */       
/* 52 */       for (int i$ = 0; i$ < len$; i$++) {
/* 53 */         MCH_Blade b = arr$[i$];
/* 54 */         GL11.glPushMatrix();
/* 55 */         float rot = b.getRotation();
/* 56 */         float prevRot = b.getPrevRotation();
/* 57 */         if (rot - prevRot < -180.0F) {
/* 58 */           prevRot -= 360.0F;
/* 59 */         } else if (prevRot - rot < -180.0F) {
/* 60 */           prevRot += 360.0F;
/*    */         } 
/*    */         
/* 63 */         if (!rotorInfo.oldRenderMethod) {
/* 64 */           GL11.glTranslated(rotorInfo.pos.field_72450_a, rotorInfo.pos.field_72448_b, rotorInfo.pos.field_72449_c);
/*    */         }
/*    */         
/* 67 */         GL11.glRotatef(prevRot + (rot - prevRot) * tickTime, (float)rotorInfo.rot.field_72450_a, (float)rotorInfo.rot.field_72448_b, (float)rotorInfo.rot.field_72449_c);
/* 68 */         if (!rotorInfo.oldRenderMethod) {
/* 69 */           GL11.glTranslated(-rotorInfo.pos.field_72450_a, -rotorInfo.pos.field_72448_b, -rotorInfo.pos.field_72449_c);
/*    */         }
/*    */         
/* 72 */         renderPart(rotorInfo.model, info.model, rotorInfo.modelName);
/* 73 */         GL11.glPopMatrix();
/*    */       } 
/*    */       
/* 76 */       GL11.glPopMatrix();
/*    */     } 
/*    */   }
/*    */ 
/*    */   
/*    */   protected ResourceLocation func_110775_a(Entity entity) {
/* 82 */     return W_Render.TEX_DEFAULT;
/*    */   }
/*    */ }


/* Location:              C:\Users\Owner\Documents\Downloads\BC Remake 3.0.0 SW Community\mods\mcheli\!\mcheli\helicopter\MCH_RenderHeli.class
 * Java compiler version: 8 (52.0)
 * JD-Core Version:       1.1.3
 */